package com.demo.streamextractor.resources

import com.demo.streamextractor.controller.request.SearchStreamsRequest
import com.demo.streamextractor.domain.contracts.IStreamGateway
import com.demo.streamextractor.domain.models.ExternalClientModel
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component

@Component
@Primary
class SpotifyGatewayV2: IStreamGateway {
    override fun getExternalData(request: SearchStreamsRequest): List<ExternalClientModel> {
        val ext1 = ExternalClientModel("u7R9p3K5qL8s", 20000L, "Joni Mitchell",
            "spoolUser", "Lesson in Survival", "myprivatemail@email.com",
            "For The Roses", shuffle = false, offline = false
        )

        val ext2 = ExternalClientModel("u7R9p3K5qL8s", 30000L, "Talking Heads",
            "spoolUser", "Houses In Motion", "myprivatemail@email.com",
            "Remain In Light", shuffle = false, offline = false
        )

        val ext3 = ExternalClientModel("u7R9p3K5qL8s", 10000L, "Yeah Yeah Yeahs",
            "spoolUser", "Y Control", "myprivatemail@email.com",
            "Fever To Tell", shuffle = false, offline = false
        )
        return listOf(ext1)
    }
}