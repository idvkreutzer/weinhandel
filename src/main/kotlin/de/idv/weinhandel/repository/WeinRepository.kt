package de.idv.weinhandel.repository

import de.idv.weinhandel.model.Land
import de.idv.weinhandel.model.Wein
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service
import java.time.LocalDate
import kotlin.random.Random

@Service
class WeinRepository {

    val weinlager = mutableListOf<Wein>()

    @PostConstruct
    fun setup(){
        weinlager.add(Wein(1, "Bordeaux", 13, Land.FR, LocalDate.of(2022, 11, 1)))
        weinlager.add(Wein(2, "Merlot", 12, Land.IT, LocalDate.of(2022, 10, 1)))
        weinlager.add(Wein(3, "Pinot Gridgio", 11, Land.IT, LocalDate.of(2021, 11, 1)))
        weinlager.add(Wein(4, "Burgunder", 12))
        weinlager.add(Wein(5, "Chardonnay", 14, Land.FR, LocalDate.of(2023, 11, 1)))
        weinlager.add(Wein(6, "Riesling", 11, Land.DE, LocalDate.of(2022, 9, 1)))
        weinlager.add(Wein(7, "Primitivo", 14, Land.IT, LocalDate.of(2017, 10, 1)))
        weinlager.add(Wein(8, "Grauburgunder", 12, Land.DE, LocalDate.of(2015, 10, 1)))
        weinlager.add(Wein(9, "Veltiner", 11, Land.AT, LocalDate.of(2020, 10, 1)))
    }

    fun getAll() : List<Wein> {
        return weinlager
    }

    fun deleteWein(weinId: Int) {
        if (!weinlager.removeIf { weinId == it.id })
            throw NoSuchElementException("No Wein found with id %s".format(weinId))
    }

    fun findWein(weinId: Int) : Wein? {
        return weinlager.firstOrNull {
            weinId == it.id
        }
    }

    fun saveWein(wein: Wein): String {
        if (wein.id == null || wein.id == 0) {
            val maxOrNull = weinlager.stream().map { w -> w.id }.toList().maxOrNull()
            wein.id = maxOrNull!!  + 1
        }
        if (weinlager.stream().anyMatch { wein.id == it.id })
            deleteWein(wein.id!!)
        weinlager.add(wein)
        println("Stored: $wein")
        return wein.id!!.toString()
    }

    fun getSorted(): List<Wein> {
        val all: List<Wein> = getAll();
        return all.stream().sorted { w1, w2 -> w2.alkohol - w1.alkohol  }.toList()
    }

    fun getFiltered(land: Land): List<Wein> {
        val all: List<Wein> = getAll();
        return all.stream().filter { w -> w.equals(land)  }.toList()
    }

}