package de.idv.weinhandel.java;

import de.idv.weinhandel.model.Wein;

import java.time.LocalDate;
import java.util.Random;

public class Transformator {

    public Wein water2Wein(int liter){
        return new Wein(new Random().nextInt(), "Holy Juice", 99, null, LocalDate.now(), liter);
    }
}
