package com.helpme.waygo.global.sms

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "sms")
class SmsProperties(
    val apiKey: String,
    val apiSecret: String
)