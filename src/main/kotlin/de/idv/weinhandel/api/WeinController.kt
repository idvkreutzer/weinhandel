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

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Wein? {
        return weinService.findWein(id);
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = weinService.deleteWein(id);

    @PostMapping(consumes = [MediaType.ALL_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun saveWein( @RequestBody wein: Wein) = weinService.saveWein(wein)

    @GetMapping("/sorted")
    fun getSortedAll(): List<Wein> {
        return weinService.getSorted()
    }

    @GetMapping("/filtered")
    fun getFiltered(@RequestParam land: Land): List<Wein> {
        return weinService.getFiltered(land)
    }
}