package com.demo.streamextractor.domain.services

import com.demo.streamextractor.controller.request.SearchStreamsRequest
import com.demo.streamextractor.domain.contracts.IStreamGateway
import com.demo.streamextractor.domain.contracts.IStreamService
import com.demo.streamextractor.domain.converter.ExternalModelToStreamModelConverter
import com.demo.streamextractor.domain.models.StreamModel
import org.springframework.stereotype.Service

@Service
class StreamService(
    private val gateway: IStreamGateway
): IStreamService {
    override fun transformData(request: SearchStreamsRequest): List<StreamModel> {
        val response = gateway.getExternalData(request)
        return ExternalModelToStreamModelConverter.convert(response)
    }
}