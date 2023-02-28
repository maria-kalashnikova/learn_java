package lesson3;

import java.util.Arrays;

public class HomeWorkApp3 {
    public static void main(String[] args) {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(replaseArray(array)));
        System.out.println(Arrays.toString(createArray(100)));

        int numArray[] = {1, 5, 3, 2, 11, 8, 9, 1};
        System.out.println(Arrays.toString(multiplication(numArray)));

        twoDimArray(6);
        System.out.println(Arrays.toString(createArray(5, 10)));

        int arrayMinMax[] = {3, 5, 2, 7, 1, 44, 53, 29};
        System.out.println(minVal(arrayMinMax));
        System.out.println(maxVal(arrayMinMax));

        int arr[] = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(arr));

        System.out.println(Arrays.toString(moveArray(numArray, -2)));
    }

    public static int[] replaseArray(int[] array){
        for (int i = 0; i < array.length; i += 1){
            switch (array[i]){
                case 1 -> array[i] = 0;
                case 0 -> array[i] = 1;
            }
        }
        return array;
    };

    public static int[] createArray(int lenght){
        int array[] = new int[lenght];
        for (int i = 0; i < array.length; i += 1){
            array[i] = i + 1;
        }
        return array;
    }

    public static int[] multiplication(int [] array){
        int i = 0;
        while (i < array.length){
            if (array[i] < 6){
                array[i] = array[i] * 2;
            }
            i += 1;
        }
        return array;
    }

    public static int[][] twoDimArray(int size) {
        int[][] nums = new int[size][size];
        for (int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums[i].length; j++){
                if (j == i || j == nums[i].length - (i + 1)) {
                    nums[i][j] = 1;
                }
            };
            System.out.println(Arrays.toString(nums[i]));
        }
        return nums;
    }

    public static int[] createArray(int len, int initialValue){
        int[] array = new int [len];
        for (int i = 0; i < len; i++){
            array[i] = initialValue;
        }
        return array;
    };

    public static int minVal(int[] array){
        int min = array[0];
        for (int i: array){
            if (i < min){
                min = i;
            }
        }
        return min;
    }

    public static int maxVal(int[] array){
        int max = array[0];
        for (int i: array){
            if (i > max){
                max = i;
            }
        }
        return max;
    }

    public static boolean checkBalance(int[] array){
        for (int i = 1; i < array.length; i++){
            int sumBefore = 0;
            int sumAfter = 0;
            for (int j = 0; j < array.length; j++){
                if (j < i){
                    sumBefore += array[j];
                } else if (j >= i) {
                    sumAfter += array[j];
                }
            }
            if (sumBefore == sumAfter){
                return true;
            }
        }
        return false;
    };

    public static int[] moveArray(int[] array, int n){
        int val = 0;
        if (n >= 0) {
            for (int i = 0; i < array.length - n; i++) {
                val = array[i];
                array[i] = array[i + n];
                array[i + n] = val;
            }
        } else {
            for (int i = 0; i < array.length + n; i++) {
                val = array[i];
                array[i] = array[i - n];
                array[i - n] = val;
            }
        }
        return array;
    }
}
