package com.company.Algorithms;

public class MergeSort {
    public static  void mergeSort(int[] arr){
        if(arr.length > 1){
            int[] firstHalf = new int[arr.length/2];
            System.arraycopy(arr,0,firstHalf,0,arr.length/2);
            mergeSort(firstHalf);
            int seconthalflength = arr.length - arr.length/2;
            int[] secondHalf = new int[seconthalflength];
            System.arraycopy(arr,arr.length/2,secondHalf,0,seconthalflength);
            mergeSort(secondHalf);
            merge(firstHalf,secondHalf,arr);
        }

    }
    public static void merge(int[] first,int[] second,int[] temp){
        int currenta=0,currentb=0,currentc=0;
        while(currenta < first.length && currentb < second.length){
            if(first[currenta] < second[currentb]){
                temp[currentc++]=first[currenta++];
            }
            else {
                temp[currentc++] = second[currentc++];
            }
        }
        while(currenta < first.length){
            temp[currentc++] = first[currenta++];
        }
        while(currentb < first.length){
            temp[currentc++] = second[currentb++];
        }

    }

    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        mergeSort(list);
         for (int i = 0; i < list.length; i++)
             System.out.print(list[i] + " ");
    }
}
