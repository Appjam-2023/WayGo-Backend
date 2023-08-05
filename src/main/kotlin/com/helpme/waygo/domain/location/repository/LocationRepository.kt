package com.helpme.waygo.domain.location.repository

import com.helpme.waygo.domain.location.entity.Location
import org.springframework.data.jpa.repository.JpaRepository

interface LocationRepository : JpaRepository<Location, Long>