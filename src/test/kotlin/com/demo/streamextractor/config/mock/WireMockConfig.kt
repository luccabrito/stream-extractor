package com.demo.streamextractor.config.mock

import com.github.tomakehurst.wiremock.WireMockServer
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

@TestConfiguration
class WireMockConfig {

    @Bean(initMethod = "start", destroyMethod = "stop")
    fun mockExternalService(): WireMockServer {
        return WireMockServer(7070)
    }
}