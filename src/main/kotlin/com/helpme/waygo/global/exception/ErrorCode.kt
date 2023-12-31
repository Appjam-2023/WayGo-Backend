package com.helpme.waygo.global.exception

enum class ErrorCode(
    val msg: String,
    val code: Int
) {
    BAD_REQUEST("잘못된 요청", 400),
    PASSWORD_MISMATCH("비밀번호가 일치하지 않습니다.", 400),

    UNAUTHORIZED("권한 없음", 401),
    EXPIRED_TOKEN("토큰 만료", 401),
    INVALID_TOKEN("토큰 변질", 401),
    EXPIRED_REFRESH_TOKEN("리프레시 토큰이 만료되었습니다", 401),
    INVALID_REFRESH_TOKEN("리프레시 토큰이 변질되었습니다", 401),

    BAD_USER_ROLE_REQUEST("잘못된 유저 역할입니다..", 400),

    FORBIDDEN("금지된 요청입니다.", 403),

    NOT_FOUND("리소스를 찾을수 없음", 404),
    LOCATION_NOT_FOUND("위치정보를 찾을 수 없습니다", 404),
    USER_NOT_FOUND("해당 유저를 찾을 수 없습니다.", 404),

    DUPLICATE_PHONE_NUMBER("중복된 전화번호입니다", 409),
    DUPLICATE_LOCATION("중복된 위치세션입니다", 409),
    INTERNAL_SERVER_ERROR("서버 내부 에러", 500);
}