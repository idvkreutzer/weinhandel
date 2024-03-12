package de.idv.weinhandel.api

import de.idv.weinhandel.model.Wein
import de.idv.weinhandel.repository.WeinRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/weinhandel")
class WeinController {

    @Autowired
    lateinit var weinRepository: WeinRepository

    @GetMapping("/all")
    fun getAll(): List<Wein?> {
        return weinRepository.getAll()
    }

}