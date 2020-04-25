package com.anmol.service;

public class MedianOfSortedArrays {

    public static void main(String[] args) {
//        int[] arr1 = new int[]{1, 12, 15, 26, 38};
//        int[] arr2 = new int[]{2, 13, 17, 30, 45};
        int[] arr1 = new int[]{1, 2,3,6};
        int[] arr2 = new int[]{4,6,8,10};

//        System.out.println("median is : "+ medianEqualSizeArray(arr1, arr2, 0, arr1.length-1, 0, arr2.length-1));

//        int[] nums1 = new int[]{1,3,8,9,15};
//        int[] nums1 = new int[]{23,26,31,35};
//        int[] nums2 = new int[]{3,5,7,9,11,16};
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        /**
         * Idea is to divide the arrays into 2 partitions such that they have equal number of elements and
         * check the condition that all the elements on left side of the prtition are less than or equal to all the elements
         * on the right side
         *
         */
        System.out.println("median is : "+ medianUnEqualArray(nums1, nums2));
    }

    public static double medianUnEqualArray(int[] arr1, int[] arr2) {
        // https://www.youtube.com/watch?v=LPFhl65R7ww
        int start = 0;
        if(arr1.length > arr2.length) {
            return medianUnEqualArray(arr2, arr1);
        }
        int end = arr1.length;
        int partitionX;
        int partitionY;

        while (start<=end) {
            partitionX = (start + end)/2;       // how many element on left side of x an how many on right side of X;
            partitionY = (arr1.length + arr2.length +1)/2 - partitionX; //how many element on left side of y an how many on right side of y;
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : arr1[partitionX-1];
            int minRightX = partitionX == arr1.length ? Integer.MAX_VALUE : arr1[partitionX];

            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE : arr2[partitionY-1];
            int minRightY = partitionY == arr2.length ? Integer.MAX_VALUE : arr2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <=minRightX) {
                if((arr1.length + arr2.length)%2==0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX,  minRightY))/2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if(maxLeftX < minRightY) {
                start = partitionX + 1;
            } else {
                end = partitionX -1;
            }

        }
        throw new IllegalArgumentException();
    }

    public static double medianEqualSizeArray(int[] arr1, int[] arr2, int startA, int endA, int startB, int endB) {
        if(endA - startA == 1) {
            return ((Math.max(arr1[startA], arr2[startB])+ Math.min(arr1[endA], arr2[endB]))) / 2.0;
        }

        int mid1 = getMedian(arr1, startA, endA);
        int mid2 = getMedian(arr2, startB, endB);

       if(mid1 == mid2) {
           return mid1;
       } else if(mid1 > mid2) {
           return medianEqualSizeArray(arr1, arr2, startA, (endA+startA+1)/2, (endB+startB+1)/2, endB);
       } else{
           return medianEqualSizeArray(arr1, arr2, (endA+startA+1)/2, endA, startB, (endB+startB+1)/2);
       }
    }

    private static int getMedian(int[] arr1, int start, int end) {
        int totalNumberOfElements = end - start + 1;
        if(totalNumberOfElements %2 == 0) {
            return (arr1[start + totalNumberOfElements/2] + arr1[start + totalNumberOfElements/2-1])/2;
        }
        return arr1[start + totalNumberOfElements/2];
    }
}
