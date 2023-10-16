package edu.hw1;

public class Task3 {
    public static boolean isNestable(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return false;
        }
        if (arr1.length == 0 || arr2.length == 0) {
            return false;
        }

        int min1 = arr1[0];
        int max1 = arr1[0];
        int min2 = arr2[0];
        int max2 = arr2[0];

        for (int n : arr1) {
            if (n < min1) {
                min1 = n;
            }
            if (n > max1) {
                max1 = n;
            }
        }
        for (int n : arr2) {
            if (n < min2) {
                min2 = n;
            }
            if (n > max2) {
                max2 = n;
            }
        }

        return (min1 > min2 && max1 < max2);
    }

    private Task3() {
    }
}
