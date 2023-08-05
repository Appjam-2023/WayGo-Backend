package com.helpme.waygo.domain.location.exception

import com.helpme.waygo.global.exception.ErrorCode
import com.helpme.waygo.global.exception.exceptions.BasicException

class DuplicateLocationException : BasicException(ErrorCode.DUPLICATE_LOCATION)