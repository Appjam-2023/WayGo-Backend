package com.helpme.waygo.domain.auth.repository

import com.helpme.waygo.auth.entity.UserMapping
import org.springframework.data.repository.CrudRepository

interface UserMappingRepository : CrudRepository<UserMapping, Long>