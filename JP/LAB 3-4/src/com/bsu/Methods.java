package com.bsu;

import java.util.ArrayList;
import java.util.List;

class Query {
    List<Company> findShortNameOfCompany(String str, List<Company> companies){
        List<Company> result = new ArrayList<>();

        for (Company i : companies) {
            if (i.getShortNameOfCompany().toLowerCase().equals(str.toLowerCase())) {
                result.add(i);
            }
        }

        return result;
    }

    List<Company> findIndustry(String str, List<Company> companies){
        List<Company> result = new ArrayList<>();

        for (Company i : companies) {
            if (i.getIndustry().toLowerCase().equals(str.toLowerCase())) {
                result.add(i);
            }
        }

        return result;
    }

    List<Company> findDateOfFoundation(int start, int end, List<Company> companies){
        List<Company> result = new ArrayList<>();

        for (Company i : companies) {
            if ( i.getDateOfFoundation()>=start && i.getDateOfFoundation() <= end) {
                result.add(i);
            }
        }

        return result;
    }

    List<Company> findKindOfActivity(String str, List<Company> companies){
        List<Company> result = new ArrayList<>();

        for (Company i : companies) {
            if (i.getKindOfActivity().toLowerCase().equals(str.toLowerCase())) {
                result.add(i);
            }
        }

        return result;
    }

    List<Company> findCountOfEmployees(int start, int end, List<Company> companies){
        List<Company> result = new ArrayList<>();

        for (Company i : companies) {
            if (i.getNumOfEmployees()>= start   && i.getNumOfEmployees() <= end) {
                result.add(i);
            }
        }

        return result;
    }
}