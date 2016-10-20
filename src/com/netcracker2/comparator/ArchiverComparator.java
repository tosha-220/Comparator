package com.netcracker2.comparator;

import java.util.*;

public class ArchiverComparator {

    private ArrayList<String> list1 = new ArrayList<>();
    private ArrayList<String> list2 = new ArrayList<>();

    public ArrayList<String> compareFirstToSecond(final HashMap<String, Long> first, final HashMap<String, Long> second) {
        for (Map.Entry<String, Long> maps : first.entrySet()) {
            if (second.containsKey(maps.getKey()) && !second.containsValue(maps.getValue())) {
                list1.add("modified" + " " + maps.getKey());
            } else if (!second.containsKey(maps.getKey()) && second.containsValue(maps.getValue())) {
                list1.add("rename" + " " + maps.getKey());
            } else if (!second.containsKey(maps.getKey()) && !second.containsValue(maps.getValue())) {
                list1.add("deleted" + " " + maps.getKey());
            }
        }
        return sort(list1);
    }

    public ArrayList<String> compareSecondToFirst(final HashMap<String, Long> first, final HashMap<String, Long> second) {

        for (Map.Entry<String, Long> maps : second.entrySet()) {
            if (!first.containsKey(maps.getKey()) && !first.containsValue(maps.getValue())) {
                list2.add("added" + " " + maps.getKey());
            } else if (first.containsKey(maps.getKey()) && !first.containsValue(maps.getValue())) {
                list2.add("modified" + " " + maps.getKey());
            } else if (!first.containsKey(maps.getKey()) && first.containsValue(maps.getValue())) {
                list2.add("renamed" + " " + maps.getKey());
            }
        }

        return sort(list2);
    }

    private ArrayList<String> sort(final ArrayList<String> list) {
        Collections.sort(list, String::compareTo);
        return list;
    }
}
