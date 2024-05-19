package com.demo.streamextractor.domain.contracts

import com.demo.streamextractor.controller.request.SearchStreamsRequest
import com.demo.streamextractor.domain.models.ExternalClientModel

interface IStreamGateway {

    fun getExternalData(request: SearchStreamsRequest): List<ExternalClientModel>
}