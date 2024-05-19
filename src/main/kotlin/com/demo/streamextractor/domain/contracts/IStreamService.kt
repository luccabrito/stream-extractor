package com.demo.streamextractor.domain.contracts

import com.demo.streamextractor.controller.request.SearchStreamsRequest
import com.demo.streamextractor.domain.models.StreamModel

interface IStreamService {

    fun transformData(request: SearchStreamsRequest): List<StreamModel>
}