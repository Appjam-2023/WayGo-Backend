package com.helpme.waygo.domain.image.presentation

import com.helpme.waygo.domain.image.presentation.dto.response.ImageUploadResponse
import com.helpme.waygo.domain.image.service.ImageUploadService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/image")
class ImageController(
    private val imageUploadService: ImageUploadService
) {
    @PostMapping
    fun uploadImage(@RequestPart("image") image: MultipartFile): ResponseEntity<ImageUploadResponse> {
        val result = imageUploadService.execute(image)
        return ResponseEntity.ok(result)
    }
}