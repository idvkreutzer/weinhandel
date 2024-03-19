package de.idv.weinhandel.service

import de.idv.weinhandel.model.Land
import de.idv.weinhandel.model.Wein
import de.idv.weinhandel.repository.WeinRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDate

@ExtendWith(MockitoExtension::class)
class WeinServiceTest {

    @Mock
    lateinit var weinRepository: WeinRepository

    @InjectMocks
    lateinit var weinService: WeinService

    private val weinlager = listOf<Wein>(
        Wein(1, "Bordeaux", 13, Land.FR, LocalDate.of(2022, 11, 1)),
        Wein(2, "Merlot", 12, Land.IT, LocalDate.of(2022, 10, 1)),
        Wein(3, "Chardonnay", 14, Land.FR, LocalDate.of(2023, 11, 1)),
        Wein(7, "Primitivo", 11, Land.IT, LocalDate.of(2017, 10, 1)),
        Wein(5, "Veltiner", 10, Land.AT, LocalDate.of(2020, 10, 1))
    )

    @BeforeEach
    fun setup() {
        Mockito.lenient().`when`(weinRepository.getAll()).thenReturn(weinlager)
    }

    @Test
    fun getSorted() {
        Mockito.`when`(weinRepository.getAll()).thenReturn(weinlager)
        assert(weinService.getSorted().first().name == "Chardonnay")
    }


    @Test
    fun getFiltered() {
        assert(weinService.getFiltered(Land.AT).first().name == "Veltiner")
    }

    @Test
    fun water2Wine() {
        val water2Wine = weinService.water2WineOldWay(5)
        assert(water2Wine.name == "Holy Juice")
    }
}