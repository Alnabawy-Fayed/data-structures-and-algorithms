package com.company;

import com.company.Data_Structures.MyQueue;
public class Main {
  public static int factorial(int n){
    if(n==0)
      return 1;
    else
      return n*factorial(n-1);
  }
  public static int sum(int[] arr,int n){
    if(n <= 0)
      return 0;
    return sum(arr,n-1)+arr[n-1];
  }
  public static int max(int[] arr,int index){
    if(index > 0)
      return Math.max(arr[index],max(arr,index-1));
    else return arr[0];
  }
  public static int binarySearch(int[] arr,int first,int last,int key) {
    int mid = first + (last - first) / 2;
    if (last >= first) {
      if (arr[mid] == key)
        return mid;
      if (arr[mid] > key) {
        return binarySearch(arr, first, --mid , key);
      } else {
       return binarySearch(arr, ++mid, last, key);
      }
    }
    return -1;
  }
    public static int fibo(int n){
    if(n == 0)
      return 0;
    else if(n == 1)
      return 1;
    else
      return fibo(n-1)+fibo(n-2);
  }

    public static void main(String[] args) {
	// write your code here
      int[] arr = {1,3,12,2,5,7};
      System.out.println(binarySearch(arr,0,arr.length-1,5));
        }
    }

