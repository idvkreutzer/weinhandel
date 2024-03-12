package de.idv.weinhandel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan
class WeinhandelApplication

fun main(args: Array<String>) {
    runApplication<WeinhandelApplication>(*args)
}
