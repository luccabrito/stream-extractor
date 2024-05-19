package com.demo.streamextractor

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class SpotifyDataExtractorApplication

fun main(args: Array<String>) {
	runApplication<SpotifyDataExtractorApplication>(*args)
}
