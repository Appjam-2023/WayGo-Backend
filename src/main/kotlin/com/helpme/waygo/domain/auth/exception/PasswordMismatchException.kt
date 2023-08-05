package com.helpme.waygo.domain.auth.exception

import com.helpme.waygo.global.exception.ErrorCode
import com.helpme.waygo.global.exception.exceptions.BasicException

class PasswordMismatchException : BasicException(ErrorCode.PASSWORD_MISMATCH)