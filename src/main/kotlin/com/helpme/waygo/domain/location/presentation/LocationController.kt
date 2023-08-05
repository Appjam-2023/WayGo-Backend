package com.helpme.waygo.domain.location.presentation

import com.helpme.waygo.domain.location.presentation.dto.request.CreateWearingAndLocationRequest
import com.helpme.waygo.domain.location.service.CreateWearingAndLocationService
import com.helpme.waygo.domain.location.service.DeleteWearingAndLocationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.http.HttpHeaders
import javax.servlet.http.HttpServletRequest

@RestController
class LocationController(
    private val createWearingAndLocationService: CreateWearingAndLocationService,
    private val deleteWearingAndLocationService: DeleteWearingAndLocationService
) {
    @PostMapping("/chase")
    fun createWearingAndLocation(@RequestBody createWearingAndLocationRequest: CreateWearingAndLocationRequest): ResponseEntity<Void> {
        createWearingAndLocationService.execute(createWearingAndLocationRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @DeleteMapping("/chase")
    fun deleteWearingAndLocation(httpServletRequest: HttpServletRequest): ResponseEntity<Void> {
        deleteWearingAndLocationService.execute(httpServletRequest)
        return ResponseEntity.noContent().build()
    }
}