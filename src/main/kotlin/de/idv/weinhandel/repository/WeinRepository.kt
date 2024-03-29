package de.idv.weinhandel.repository

import de.idv.weinhandel.model.Land
import de.idv.weinhandel.model.Wein
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class WeinRepository {

    private val weinlager = mutableListOf<Wein>()

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

}