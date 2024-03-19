package de.idv.weinhandel.service

import de.idv.weinhandel.model.Land
import de.idv.weinhandel.model.Wein
import de.idv.weinhandel.repository.WeinRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.RelaxedMockK
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

class WeinServiceMockkTest {


    @InjectMockKs
    private lateinit var weinService: WeinService
    @RelaxedMockK
    private lateinit var weinRepository: WeinRepository

    @BeforeEach
    fun setUp() = MockKAnnotations.init(this)

    private val weinlager = listOf<Wein>(
        Wein(1, "Bordeaux", 13, Land.FR, LocalDate.of(2022, 11, 1)),
        Wein(2, "Merlot", 12, Land.IT, LocalDate.of(2022, 10, 1)),
        Wein(3, "Chardonnay", 14, Land.FR, LocalDate.of(2023, 11, 1)),
        Wein(7, "Primitivo", 11, Land.IT, LocalDate.of(2017, 10, 1)),
        Wein(5, "Veltiner", 10, Land.AT, LocalDate.of(2020, 10, 1))
    )

    @Test
    fun sorted() {
        every { weinRepository.getAll() } returns weinlager
        assert(weinService.getSorted().first().name == "Chardonnay")
    }

    @Test
    fun filtered() {
        every { weinRepository.getAll() } returns weinlager
        assert(weinService.getFiltered(Land.AT).first().name == "Veltiner")
    }

    @Test
    fun water2Wine() {
        val water2Wine = weinService.water2WineOldWay(5)
        assert(water2Wine.name == "Holy Juice")
    }
}