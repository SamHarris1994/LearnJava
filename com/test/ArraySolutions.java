package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArraySolutions {

	public static int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) return 0;
        int sum = array[0];
        int tempSum = array[0];
        for (int i = 1; i < array.length; i++) {
            tempSum = (tempSum > 0) ? tempSum + array[i] : array[i];
            if(tempSum > sum) sum = tempSum;
        }
        return sum;
    }
	
	public static ArrayList<Integer> GetLeastNumbers(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || input.length < k) return list;
        for(int pos = k/2 - 1; pos >= 0; pos--) {
            adjustMaxHeap(input, pos, k);
        }
        for(int i = k; i < input.length; i++) {
            if(input[i] < input[0]) {
                input[0] = input[i];
                adjustMaxHeap(input, 0, k);
            }
        }
        for(int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }
    
    public static void adjustMaxHeap(int[] arr, int pos, int len) {
        int childPos = 2*pos + 1;
        int temp = arr[pos];
        while(childPos < len) {
            if(childPos + 1 < len && arr[childPos + 1] > arr[childPos]) childPos++;
            if(arr[childPos] < temp) { break; }
            else {
                arr[pos] = arr[childPos];
                pos = childPos;
                childPos = 2*pos + 1;
            }
        }
        arr[pos] = temp;
    }
    
    public String PrintMinNumber(int[] numbers) {
        int len = numbers.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < len; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String str1 = a + "" + b;
                String str2 = b + "" + a;
                return str1.compareTo(str2);
            }
        }
        );
        String str = "";
        for(int i = 0; i < len; i++) {
            str += list.get(i);
        }
        return str;
    }
    
}
