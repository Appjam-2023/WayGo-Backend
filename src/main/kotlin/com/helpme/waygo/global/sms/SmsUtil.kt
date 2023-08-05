package com.helpme.waygo.global.sms

import net.nurigo.java_sdk.api.Message
import org.springframework.web.bind.annotation.RestController

@RestController
class SmsUtil(
    private val smsProperties: SmsProperties
) {

    fun sendSMS(phoneNum: String, msg: String) {
        val coolSms = Message(smsProperties.apiKey, smsProperties.apiSecret)

        val params = HashMap<String, String>()
        params["to"] = phoneNum    // 수신전화번호 (ajax로 view 화면에서 받아온 값으로 넘김)
        params["from"] = "01086027151"    // 발신전화번호. 테스트시에는 발신,수신 둘다 본인 번호로 하면 됨
        params["type"] = "sms"
        params["text"] = msg
        
        coolSms.send(params)
    }
}