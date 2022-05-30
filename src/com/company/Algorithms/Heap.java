package com.company.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Heap<E extends Comparable<E>> {
    private List<E> list = new ArrayList<>();
    public Heap(){

    }
    public Heap(E[] objects){
        for(int i = 0; i < objects.length; i++){
            add(objects[i]);
        }
    }
    public void add(E object){
        list.add(object);
        int currentIndex = list.size()-1;
        while(currentIndex > 0){
            int parentIndex = (currentIndex-1)/2;
            if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0){
                E temp = list.get(currentIndex);
                list.set(currentIndex,list.get(parentIndex));
                list.set(parentIndex,temp);
            }
            else{
                break;
            }
            currentIndex = parentIndex;
        }
    }
    public E remove(){
       if(list.size() == 0) return null;
       E removedNode = list.get(0);
       list.set(0,list.get(list.size()-1));
       list.remove(list.size()-1);
       int currentIndex =0;
       while(currentIndex < list.size()) {
           int leftIndex = 2 * currentIndex + 1;
           int rightIndex = 2 * currentIndex + 2;
           if (leftIndex >= list.size()) break;
           int maxIndex = leftIndex;
           if(rightIndex < list.size()){
               if(list.get(maxIndex).compareTo(list.get(rightIndex)) <0){
                   maxIndex = rightIndex;
               }
           }
           if(list.get(currentIndex).compareTo(list.get(maxIndex)) < 0){
               E temp = list.get(currentIndex);
               list.set(currentIndex,list.get(maxIndex));
               list.set(maxIndex,temp);
               currentIndex = maxIndex;
           }
           else break;

       }
       return removedNode;

    }
    public int getSize(){
        return list.size();
    }
}
