package de.idv.weinhandel.model

import java.time.LocalDate


data class Wein (
    var id: Int,
    val name: String,
    var alkohol: Int,
    val herkunft: Land? = null,
    val jahrgang: LocalDate? = LocalDate.now()
)

