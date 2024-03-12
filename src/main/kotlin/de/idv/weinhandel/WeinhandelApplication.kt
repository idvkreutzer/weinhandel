package de.idv.weinhandel

import de.idv.weinhandel.repository.WeinRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@SpringBootApplication
@ComponentScan
@Configuration
class WeinhandelApplication

@Bean
fun weinRepository() = WeinRepository()

fun main(args: Array<String>) {
    var context = runApplication<WeinhandelApplication>(*args)


}
