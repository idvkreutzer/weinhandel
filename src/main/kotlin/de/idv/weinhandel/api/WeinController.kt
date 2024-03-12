package de.idv.weinhandel.api

import de.idv.weinhandel.model.Land
import de.idv.weinhandel.model.Wein
import de.idv.weinhandel.repository.WeinRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/weinhandel")
class WeinController {

    @Autowired
    lateinit var weinRepository: WeinRepository

    @GetMapping("/all")
    fun getAll(): List<Wein?> {
        return weinRepository.getAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int): Wein? {
        return weinRepository.findWein(id);
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int) = weinRepository.deleteWein(id);

    @PostMapping(consumes = [MediaType.ALL_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun saveWein( @RequestBody wein: Wein) = weinRepository.saveWein(wein)

    @GetMapping("/all/sorted")
    fun getSortedAll(): List<Wein> {
        return weinRepository.getSorted()
    }

    @GetMapping("/all/filtered")
    fun getFiltered(@RequestParam land: Land): List<Wein> {
        return weinRepository.getFiltered(land)
    }
}