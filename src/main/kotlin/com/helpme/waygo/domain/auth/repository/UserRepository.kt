package com.helpme.waygo.domain.auth.repository

import com.helpme.waygo.domain.auth.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface UserRepository : JpaRepository<User, Long> {
    fun findByPhoneNum(phoneNum: String): User?
    fun existsByPhoneNum(phoneNum: String): Boolean
    @Query("SELECT u FROM User u WHERE u.phoneNum IN :phoneNums")
    fun findAllByPhoneNum(phoneNums: List<String>): List<User>
}