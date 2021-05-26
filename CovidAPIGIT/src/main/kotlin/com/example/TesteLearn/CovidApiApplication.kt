package com.example.TesteLearn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CovidApiApplication

fun main(args: Array<String>) {
	runApplication<CovidApiApplication>(*args)
}
