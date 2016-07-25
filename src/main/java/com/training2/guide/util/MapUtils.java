package com.training2.guide.util;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class reverse sort fields of Map collection
 * @author rutkovba
 */
public class MapUtils {

    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator = (K k1, K k2) -> {
                int compare = map.get(k1).compareTo(map.get(k2));
                if (compare == 0)
                    return 1;
                else
                    return compare;
            };
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }
}
