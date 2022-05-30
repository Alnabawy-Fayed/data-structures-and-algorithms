package com.company.Algorithms;

public class CountSort {
    public int[] coutSort(int[] input){
        int size = input.length;
        int[] sortedArray = new int[size];
        int[] count = new int[256];
        for(int i = 0; i < 256; i++){
            count[i] = 0;
        }
        for(int i = 0; i < size; i++){
            count[input[i]]++;
        }
        for(int i = 1; i < 255; i++){
            count[i] = count[i] + count[i-1];
        }
        for(int i = size-1; i >= 0; i--){
            sortedArray[count[input[i]]-1] = input[i];
            count[input[i]]--;
        }
        System.arraycopy(sortedArray,0,input,0,size);
        return input;
    }

}
