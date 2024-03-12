package de.idv.weinhandel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WeinhandelApplication

fun main(args: Array<String>) {
	runApplication<WeinhandelApplication>(*args)
}
