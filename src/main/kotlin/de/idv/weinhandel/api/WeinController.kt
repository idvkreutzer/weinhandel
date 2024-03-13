package de.idv.weinhandel.api

import de.idv.weinhandel.model.Land
import de.idv.weinhandel.model.Wein
import de.idv.weinhandel.service.WeinService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/weinhandel")
class WeinController {

    @Autowired
    lateinit var weinService: WeinService

    @GetMapping("/all")
    fun getAll(): List<Wein?> {
        return weinService.getAll()
    }

}