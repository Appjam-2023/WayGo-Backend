package com.helpme.waygo.global.exception.exceptions

import com.helpme.waygo.global.exception.ErrorCode

open class BasicException(val errorCode: ErrorCode): RuntimeException(errorCode.msg)