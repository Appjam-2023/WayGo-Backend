package com.helpme.waygo.global.security.exception

import com.helpme.waygo.global.exception.ErrorCode
import com.helpme.waygo.global.exception.exceptions.BasicException

class ExpiredTokenException : BasicException(ErrorCode.EXPIRED_TOKEN) {
}