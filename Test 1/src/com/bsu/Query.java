package com.bsu;

import java.util.ArrayList;
import java.util.List;

class Query {

    List<Horses> findHorse(String str, List<Horses> horse){
        List<Horses> result = new ArrayList<>();

        for (Horses i : horse) {
            if (i.getUniqueNumber().equals(str)) {
                result.add(i);
            }
        }

        return result;
    }



}