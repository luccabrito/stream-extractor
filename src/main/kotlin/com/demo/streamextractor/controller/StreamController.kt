package com.demo.streamextractor.controller

import com.demo.streamextractor.controller.request.SearchStreamsRequest
import com.demo.streamextractor.controller.response.StreamResponse
import com.demo.streamextractor.domain.contracts.IStreamService
import feign.FeignException
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/stream")
class StreamController(
    private val service: IStreamService
) {

    @PostMapping("/data")
    fun getData(@RequestBody request: SearchStreamsRequest): StreamResponse {
        try {
            val response = service.transformData(request)
            return StreamResponse(response)
        } catch (ex: FeignException) {
            throw ex
        }
    }
}