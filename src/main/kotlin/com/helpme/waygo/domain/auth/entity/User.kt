package com.helpme.waygo.auth.entity

import com.helpme.waygo.auth.enum.UserRole
import javax.persistence.*

@Entity
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val phoneNum: String,

    val password: String,

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "UserRole", joinColumns = [JoinColumn(name = "id")])
    val userRole: MutableList<UserRole> = mutableListOf()
)