package com.helpme.waygo.domain.location.entity

import com.helpme.waygo.domain.auth.entity.User
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@Entity
class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val longitude: Double,

    val latitude: Double,

    @OneToOne
    @JoinColumn(name = "ward_id")
    val user: User
)