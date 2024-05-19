package com.demo.streamextractor.resources.http

import com.demo.streamextractor.controller.request.SearchStreamsRequest
import com.demo.streamextractor.domain.models.ExternalClientModel
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(
    value = "stream-client",
    url = "\${external-client.path}"
)
interface IStreamClient {

    @PostMapping(
        value = ["/stream/data"],
        headers = [
            "Content-Type=application/json"
        ]
    )
    fun getStreamData(request: SearchStreamsRequest): List<ExternalClientModel>
}