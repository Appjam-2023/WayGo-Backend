package com.helpme.waygo.global.exception

import com.helpme.waygo.global.exception.ErrorCode

class ErrorResponse(errorCode: ErrorCode) {
    val msg: String
    val code: Int

    init {
        msg = errorCode.msg
        code = errorCode.code
    }
}