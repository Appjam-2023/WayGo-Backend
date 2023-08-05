package com.helpme.waygo.domain.location.presentation

import com.helpme.waygo.domain.location.presentation.dto.request.CreateWearingAndLocationRequest
import com.helpme.waygo.domain.location.presentation.dto.response.FindWardLocationRequest
import com.helpme.waygo.domain.location.service.*
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.net.http.HttpHeaders
import javax.servlet.http.HttpServletRequest

@RestController
class LocationController(
    private val createWearingAndLocationService: CreateWearingAndLocationService,
    private val deleteWearingAndLocationService: DeleteWearingAndLocationService,
    private val findWardLocationService: FindWardLocationService,
    private val wardReportService: WardReportService,
    private val guardianReportService: GuardianReportService
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

    @PostMapping("/chase/report")
    fun reportWard(): ResponseEntity<Void> {
        wardReportService.execute()
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @GetMapping("/checking")
    fun findWardLocation(): ResponseEntity<FindWardLocationRequest> {
        val result = findWardLocationService.execute()
        return ResponseEntity.ok(result)
    }

    @PostMapping("/checking/report/{user_id}")
    fun reportGuardian(@PathVariable("user_id") userId: Long): ResponseEntity<Void> {
        guardianReportService.execute(userId)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}