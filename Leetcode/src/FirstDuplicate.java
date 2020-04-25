package com.anmol.service;

import java.util.ArrayList;
import java.util.List;

/**
 * find the first duplicate in an array where the elements are in the range 1 to nums.length
 *
 * Solution : make the number at the index as negative if the element is negative that is repearting
 */
public class FirstDuplicate {

    int firstDuplicate(int[] a) {
        if(a == null || a.length<=0) return 0;

        for(int i = 0;i<a.length;i++) {
            if(a[Math.abs(a[i])-1] <0) {
                return Math.abs(a[i]);
            }
            a[Math.abs(a[i])-1] = -a[Math.abs(a[i])-1];
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstDuplicate duplicate = new FirstDuplicate();
        System.out.println(duplicate.firstDuplicate(new int[]{2, 1, 3, 5, 3, 2}));
    }
}
