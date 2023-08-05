package com.helpme.waygo.global.exception.exceptions

import com.helpme.waygo.global.exception.ErrorCode

class UserNotFoundException : BasicException(ErrorCode.USER_NOT_FOUND)