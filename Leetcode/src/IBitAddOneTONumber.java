package com.anmol.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IBitAddOneTONumber {

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        for(int i = A.size()-1;i>=0;i--) {
            if(A.get(i)<9) {
                A.set(i, A.get(i)+1);
                while(A.size() >1 && A.get(0) ==0) {
                    A.remove(0);
                }

                return A;
            }
            A.set(i, 0);
        }

        while(A.get(0) ==0) {
            A.remove(0);
        }
        A.add(0,1);

        return A;
    }

    public static void main(String[] args) {
        IBitAddOneTONumber oneTONumber = new IBitAddOneTONumber();
        List<Integer> list = Arrays.asList(0, 0, 3, 4, 5, 6, 3, 2, 5, 5);

//        List<Integer> integers = oneTONumber.plusOne(list);
//        for(int i : integers) {
//            System.out.print(i +" ");
//        }
    }

}
