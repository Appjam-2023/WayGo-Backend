package com.helpme.waygo.domain.image.service

import com.helpme.waygo.domain.image.presentation.dto.response.ImageUploadResponse
import com.helpme.waygo.global.s3.S3Util
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class ImageUploadService(
    private val s3Util: S3Util
) {
    fun execute(img: MultipartFile): ImageUploadResponse =
        ImageUploadResponse(s3Util.upload(img))
}