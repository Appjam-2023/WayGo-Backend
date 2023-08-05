package com.helpme.waygo.domain.auth.repository

import com.helpme.waygo.auth.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>