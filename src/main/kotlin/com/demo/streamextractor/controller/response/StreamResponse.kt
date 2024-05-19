package com.demo.streamextractor.controller.response

import com.demo.streamextractor.domain.models.StreamModel

data class StreamResponse(
    val data: List<StreamModel>
)