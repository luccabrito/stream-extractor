    package com.demo.streamextractor.mock

    import com.github.tomakehurst.wiremock.WireMockServer
    import com.github.tomakehurst.wiremock.client.WireMock.aResponse
    import com.github.tomakehurst.wiremock.client.WireMock.post
    import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
    import org.springframework.http.HttpStatus
    import org.springframework.http.MediaType

    object StreamServiceMocks {
        fun setupMockStreamServiceResponse(mockServer: WireMockServer) {
            mockServer.stubFor(
                post(urlEqualTo("/stream/data"))
                    .willReturn(
                        aResponse()
                            .withStatus(HttpStatus.OK.value())
                            .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                            .withBodyFile("get-external-data.json")
                    )
            )
        }
    }