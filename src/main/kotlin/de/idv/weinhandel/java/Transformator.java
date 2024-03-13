package de.idv.weinhandel.java;


import java.time.LocalDate;
import java.util.Random;

public class Transformator {

    public Wein water2Wein(int liter) {
        return new Wein(new Random().nextInt(), "Holy Juice", 99, LocalDate.now(), liter);
    }

    class Wein {
        private int id;
        private String name;
        private int alkohol;
        private LocalDate jahrgang;
        private int liter;

        public Wein(int id, String name, int alkohol, LocalDate jahrgang, int liter) {
            this.id = id;
            this.name = name;
            this.alkohol = alkohol;
            this.jahrgang = jahrgang;
            this.liter = liter;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAlkohol() {
            return alkohol;
        }

        public void setAlkohol(int alkohol) {
            this.alkohol = alkohol;
        }

        public LocalDate getJahrgang() {
            return jahrgang;
        }

        public void setJahrgang(LocalDate jahrgang) {
            this.jahrgang = jahrgang;
        }

        public int getLiter() {
            return liter;
        }

        public void setLiter(int liter) {
            this.liter = liter;
        }

        @Override
        public String toString() {
            return "Wein{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", alkohol=" + alkohol +
                    ", jahrgang=" + jahrgang +
                    ", liter=" + liter +
                    '}';
        }
    }
}