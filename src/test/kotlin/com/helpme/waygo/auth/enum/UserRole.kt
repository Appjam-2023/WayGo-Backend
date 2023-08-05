package com.helpme.waygo.auth.enum

import org.springframework.security.core.GrantedAuthority

enum class UserRole : GrantedAuthority {
    ROLE_WARD, ROLE_GUARDIAN;

    override fun getAuthority(): String =
        name
}