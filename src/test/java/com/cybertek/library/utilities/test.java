package com.cybertek.library.utilities;

import java.util.Arrays;

public class test {

   // public abstract void test1();



    public static void main(String[] args) {

        int num = 123;

        num = Integer.parseInt(new StringBuilder(String.valueOf(num)).reverse().toString());// will throw class
        // NumberFormatException if number is negative

        System.out.println(num);

        int num2 = 234;
        int result = 0;

        while (num2 != 0) {

            int temp = num2 % 10;// temp = 4; temp = 3; temp = 2
            result = result * 10 + temp;// result = 4; result = 43; result = 432
            num2 /= 10;// 23  2  0

        }

        System.out.println(result);


        int[] arr = {3, 5, 7, 3, 54, 6};

        for (int i = 0; i <= arr.length-1; i++) {
            for (int j = 0; j < arr.length; j++) {
                int temp = 0;

                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }

        }
        System.out.println("arr = " + Arrays.toString(arr));



    }

}
