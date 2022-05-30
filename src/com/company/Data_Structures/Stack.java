package com.company.Data_Structures;

import java.util.ArrayList;

public class Stack {
    private ArrayList<Integer> arrayList;
    private int top ;
    public Stack(){
        arrayList = new ArrayList<>();
        top = -1;
    }
    public void push(int value){
        arrayList.add(++top,value);
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("the stack is empty");
            System.exit(1);
        }
        int  value = peek();
        --top;
        return value;

    }
    public int peek(){
        if(!isEmpty()) {
            return arrayList.get(top);
        }
        System.out.println("stack is empty");
        System.exit(1);
        return -1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public int size(){
        return top+1;
    }


}
