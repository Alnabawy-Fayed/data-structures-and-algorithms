package com.company.Data_Structures;

import javax.sound.midi.SysexMessage;
import java.io.PrintStream;

public class MyQueue {
    int first = -1, last = -1;
    int arr[];
    public MyQueue(int n){
        arr = new int[n];
    }
    public void enqueue(int n){
        if(isFull()){
            System.out.println("queue is full");
            System.exit(-1);
        }
        last = (last+1) % arr.length;
        arr[last] = n;
    }
    public int dequeue() {
        int element = 0;
        if (isEmpty()) {
            System.out.println("queue is empty");
            System.exit(-1);
        } else {
            first = (first + 1) % arr.length;
            element = arr[first];
            //reset the queue
            if (first == last) {
                first = -1;
                last = -1;
            }
        }
        return element;
    }
    public boolean isFull(){
        return (first == last && first != -1) || (first == -1 && last == arr.length-1);
    }
    public boolean isEmpty(){
        return first == -1 && last == -1;
    }
}
