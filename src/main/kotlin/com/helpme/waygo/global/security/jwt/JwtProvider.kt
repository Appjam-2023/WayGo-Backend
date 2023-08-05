package com.helpme.waygo.global.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.security.Key
import java.time.ZonedDateTime
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtProvider(
    val jwtProperties: JwtProperties
) {
    companion object {
        const val ACCESS_TYPE = "access"
        const val REFRESH_TYPE = "refresh"
        const val ACCESS_EXP = 60L * 15 // 15 min
        const val REFRESH_EXP = 60L * 60 * 24 * 3 // 3 days
        const val TOKEN_PREFIX = "Bearer "
    }

    fun getAccessExpiredTime(): ZonedDateTime =
        ZonedDateTime.now().plusSeconds(ACCESS_EXP)

    fun generateToken(sub: String, type: String, secret: Key, exp: Long): String =
        Jwts.builder()
            .signWith(secret, SignatureAlgorithm.HS256)
            .setSubject(sub)
            .claim("type", type)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .compact()

    fun generateAccessToken(phoneNum: String): String =
        generateToken(phoneNum, ACCESS_TYPE, jwtProperties.accessSecret, ACCESS_EXP)

    fun generateRefreshToken(phoneNum: String): String =
        generateToken(phoneNum, REFRESH_TYPE, jwtProperties.refreshSecret, REFRESH_EXP)

    fun resolveToken(req: HttpServletRequest): String? {
        val token = req.getHeader("Authorization") ?: return null
        return parseToken(token)
    }

    fun parseToken(token: String): String? =
        if(token.startsWith(TOKEN_PREFIX)) token.replace(TOKEN_PREFIX, "") else null
}