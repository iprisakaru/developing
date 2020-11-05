package com.bsu;

import java.util.Objects;
class Horses {
    private String uniqueNumber;
    private String horseName;
    private String dateOfBirth;
    private String kindOfCompetition;
    private int numberOfWins;

    public Horses(String[] args) throws Exception {
        this.uniqueNumber= args[0];
        this.horseName= args[1];
        this.dateOfBirth = args[2];
        this.kindOfCompetition = args[3];
        this.numberOfWins = Integer.parseInt(args[4]);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueNumber,horseName,dateOfBirth,kindOfCompetition,numberOfWins);
    }

    public boolean equalHorse(Object t) {
        if (this == t) return true;
        if (t == null || getClass() != t.getClass()) return false;
        Horses a = (Horses) t;
        return  Objects.equals(uniqueNumber, a.uniqueNumber) ;
    }


    public void setUniqueNumber(String uniqueNumber) {
        this.uniqueNumber= uniqueNumber;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth= dateOfBirth;
    }

    public void setHorseName(String horseName) {
        this.horseName= horseName;
    }
    public void setKindOfCompetition(String kindOfCompetition) {
        this.kindOfCompetition= kindOfCompetition;
    }
    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins= numberOfWins;
    }


    public String getUniqueNumber() {
        return uniqueNumber;
    }

    public String getHorseName() {
        return horseName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getKindOfCompetition() {
        return kindOfCompetition;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }


}