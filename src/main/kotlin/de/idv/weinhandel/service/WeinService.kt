package de.idv.weinhandel.service
import de.idv.weinhandel.java.Transformator
import de.idv.weinhandel.model.Land
import de.idv.weinhandel.model.Wein
import de.idv.weinhandel.repository.WeinRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.modelmapper.ModelMapper

@Service
class WeinService {

    @Autowired lateinit var weinRepository: WeinRepository

    fun getAll() : List<Wein> {
        return weinRepository.getAll()
    }

    fun deleteWein(weinId: Int) =  weinRepository.deleteWein(weinId)

    fun findWein(weinId: Int) : Wein? {
        return weinRepository.findWein(weinId)
    }

    fun saveWein(wein: Wein): Wein {
        return weinRepository.saveWein(wein)
    }

    fun getSorted(): List<Wein> {
        // kotlin way. "it" ein implizites Namen für den einzelnen Parameter in Lambda-Ausdrücken
        return getAll().sortedBy { it.alkohol }
//      java way  return getAll().stream().sorted { w1, w2 -> w2.alkohol - w1.alkohol  }.toList()
    }

    fun getFiltered(land: Land): List<Wein> {
        return getAll().stream().filter { w -> w.herkunft == land  }.toList()
    }

    fun water2Wine(liter: Int): Wein {
        val modelmapper = ModelMapper()
        val water2Wein = Transformator().water2Wein(liter)
        return saveWein(modelmapper.map(water2Wein, Wein::class.java))
    }

    fun water2WineOldWay(liter: Int): Wein {
//        Loesung mit eigenem kleinen mapping.
        val water2Wein = javaToKotlin(Transformator().water2Wein(liter))
        saveWein(water2Wein)
        return water2Wein
    }

    private fun javaToKotlin(javaObject: Transformator.Wein): Wein {
        return Wein(
            id = javaObject.id,
            name = javaObject.name,
            alkohol = javaObject.alkohol,
            herkunft = null,
            jahrgang = javaObject.jahrgang,
            liter = javaObject.liter
        )
    }
}