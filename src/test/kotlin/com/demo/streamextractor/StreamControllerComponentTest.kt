package com.demo.streamextractor

import com.demo.streamextractor.config.mock.WireMockConfig
import com.demo.streamextractor.controller.response.StreamResponse
import com.demo.streamextractor.mock.StreamServiceMocks.setupMockStreamServiceResponse
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.github.tomakehurst.wiremock.WireMockServer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@EnableFeignClients
@ContextConfiguration(classes = [WireMockConfig::class])
class StreamControllerComponentTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var mockExternalServer: WireMockServer

    private val objectMapper = jacksonObjectMapper()

    @Test
    fun shouldReturnListWithThreeStreams() {
        setupMockStreamServiceResponse(mockExternalServer)
        val request = """
            {
                "user_identifier": "u7R9p3K5qL8s"
            }
        """.trimIndent()
        val result = mockMvc.perform(
            post("/stream/data")
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
        )
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andReturn()

        val response = objectMapper.readValue(result.response.contentAsString, StreamResponse::class.java)
        Assertions.assertEquals(3, response.data.size)
        Assertions.assertEquals("Lesson In Survival", response.data[0].track)
        Assertions.assertEquals("Remain In Light", response.data[1].album)
        Assertions.assertEquals("Yeah Yeah Yeahs", response.data[2].artist)
    }
}