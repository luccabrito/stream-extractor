package com.demo.streamextractor.resources

import com.demo.streamextractor.controller.request.SearchStreamsRequest
import com.demo.streamextractor.domain.contracts.IStreamGateway
import com.demo.streamextractor.domain.models.ExternalClientModel
import com.demo.streamextractor.resources.http.IStreamClient
import org.springframework.stereotype.Component

@Component
class StreamGatewayAdapter(
    private val client: IStreamClient
): IStreamGateway {
    override fun getExternalData(request: SearchStreamsRequest): List<ExternalClientModel> {
        return client.getStreamData(request)
    }
}