package com.demo.streamextractor.domain.converter

import com.demo.streamextractor.domain.models.ExternalClientModel
import com.demo.streamextractor.domain.models.StreamModel

class ExternalModelToStreamModelConverter {

    companion object {
        fun convert(externalData: List<ExternalClientModel>): List<StreamModel> {
            val responseList = mutableListOf<StreamModel>()
            externalData.forEach {
                val instance = StreamModel(it.artist, it.album, it.track)
                responseList.add(instance)
            }
            return responseList
        }
    }
}