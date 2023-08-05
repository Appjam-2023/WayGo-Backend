package com.helpme.waygo.domain.location.presentation

import com.helpme.waygo.domain.location.presentation.dto.request.CreateWearingAndLocationRequest
import com.helpme.waygo.domain.location.service.CreateWearingAndLocationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LocationController(
    private val createWearingAndLocationService: CreateWearingAndLocationService
) {
    @PostMapping("/chase")
    fun createWearingAndLocation(@RequestBody createWearingAndLocationRequest: CreateWearingAndLocationRequest): ResponseEntity<Void> {
        createWearingAndLocationService.execute(createWearingAndLocationRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }
}