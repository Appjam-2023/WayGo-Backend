package com.helpme.waygo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WaygoApplication

fun main(args: Array<String>) {
    runApplication<WaygoApplication>(*args)
}
