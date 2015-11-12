package com.dstevens.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lists {

    public static <E> List<E> list() {
        return new ArrayList<E>();
    }
    
    public static <E> List<E> list(@SuppressWarnings("unchecked") E... elements) {
        return listFrom(Arrays.asList(elements));
    }
    
    public static <E> List<E> listFrom(Iterable<E> elements) {
        List<E> list = list();
        elements.forEach((E e) -> list.add(e));
        return list;
    }
    
    public static <E> List<E> listWith(Collection<E> elements, E elementToAdd) {
        List<E> listFrom = listFrom(elements);
        listFrom.add(elementToAdd);
        return listFrom;
    }
    
    public static <E> List<E> listWithout(Collection<E> elements, E elementToAdd) {
        List<E> listFrom = listFrom(elements);
        listFrom.remove(elementToAdd);
        return listFrom;
    }
    
    public static <E extends Comparable<E>> List<E> sort(List<E> list) {
    	return sort(list, Comparator.naturalOrder());
    }
    
    public static <E> List<E> sort(List<E> list, Comparator<? super E> comparator) {
    	List<E> sortedList = listFrom(list);
    	sortedList.sort(comparator);
    	return sortedList;
    }
    
    public static <E> E first(List<E> list) {
        return list.get(0);
    }
    
    public static <E> E last(List<E> list) {
        return list.get(list.size() - 1);
    }
    
    public static <E> List<E> shuffle(List<E> list) {
        List<E> shuffledList = listFrom(list);
        Collections.shuffle(shuffledList);
        return shuffledList;
    }
}
