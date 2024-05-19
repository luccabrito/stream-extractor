package com.demo.streamextractor.domain.models

data class ExternalClientModel (
    val userId: String,
    val duration: Long,
    val artist: String,
    val username: String,
    val track: String,
    val email: String,
    val album: String,
    val shuffle: Boolean,
    val offline: Boolean,
)