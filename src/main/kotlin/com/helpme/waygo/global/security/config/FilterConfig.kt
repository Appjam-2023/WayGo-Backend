package com.helpme.waygo.global.security.config

import com.helpme.waygo.global.filter.JwtTokenFilter
import com.helpme.waygo.global.security.jwt.JwtProvider
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val jwtProvider: JwtProvider
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain?, HttpSecurity>() {
    override fun configure(builder: HttpSecurity) {
        val jwtTokenFilter = JwtTokenFilter(jwtProvider)
        builder.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter::class.java)
    }
}