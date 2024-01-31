package com.largelanguagemodel.mapping;

import java.util.ArrayList;
import java.util.List;

public class Mapping {
    public static List<String> getUnimportantWords(){
        ArrayList<String> lst = new ArrayList<>();
        lst.add("le");
        lst.add("la");
        lst.add("du");
        lst.add("de");
        lst.add("d'");
        lst.add("un");
        lst.add("une");
        lst.add("a");
        lst.add("est");
        return lst;
    }
}
