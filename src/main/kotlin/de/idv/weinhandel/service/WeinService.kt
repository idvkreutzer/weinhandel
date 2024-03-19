package de.idv.weinhandel.service
import de.idv.weinhandel.java.Transformator
import de.idv.weinhandel.model.Land
import de.idv.weinhandel.model.Wein
import de.idv.weinhandel.repository.WeinRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
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
        // kotlin way
        return getAll().sortedBy { it.alkohol }
//      java way  return getAll().stream().sorted { w1, w2 -> w2.alkohol - w1.alkohol  }.toList()


    }

    fun getFiltered(land: Land): List<Wein> {
        return getAll().stream().filter { w -> w.herkunft == land  }.toList()
    }

    fun water2Wine(liter: Int): Wein {
        val water2Wein = javaToKotlin(Transformator().water2Wein(liter))
        saveWein(water2Wein)
        return water2Wein
    }

    fun javaToKotlin(javaObject: Transformator.Wein): Wein {
        return Wein(
            id = javaObject.getId(),
            name = javaObject.getName(),
            alkohol = javaObject.getAlkohol(),
            herkunft = null,
            jahrgang = javaObject.getJahrgang(),
            liter = javaObject.getLiter()
        )
    }
}