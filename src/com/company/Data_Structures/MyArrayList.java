package com.company.Data_Structures;


public class MyArrayList<E>  {
    public static final int INITIAL_CAPACITY =16;
    private E[] data = (E[]) new Object[INITIAL_CAPACITY];
    private int size = 0;
    public MyArrayList(){
    }
    public MyArrayList(E[] arr){
        for(int i = 0; i < arr.length; i++){
            add(arr[i]);
        }
    }
    public void add(E element){
            ensureCapacity();
        data[size] = element;
        size++;
    }
    public void add(int index, E element){
        if(index > data.length || index < 0)
            throw new IndexOutOfBoundsException("index"+index+ "size"+size);
        ensureCapacity();
        for(int i =size-1; i > index; i--){
            data[i+1] = data[i];
        }
        data[index] = element;
        size++;
    }
    public void ensureCapacity(){
        if(size >= data.length){
        E[] tempData = (E[]) new Object[size*2];
        System.arraycopy(data,0,tempData,0,size);
        data = tempData;
        }
    }
    public void clear(){
        data = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }
    public boolean contains(int element){
        for(int i = 0; i < size; i++){
            if(data[i].equals(element))
                return true;
        }
        return false;
    }
    public E get(int index){
        if(index > data.length || index < 0)
            throw new IndexOutOfBoundsException("index"+index+ "size"+size);
        return data[index];
    }
    public int indexOf(E element){
        for(int i = 0; i < size; i++){
            if(data[i].equals(element))
                return i;
        }
        return -1;
    }
    public int lastIndexOf(E element){
        for(int i = size-1 ; i >= 0; i--){
            if(data[i].equals(element))
                return i ;
        }
        return -1;
    }
    public E remove(int index){
        if(index > data.length || index < 0)
            throw new IndexOutOfBoundsException("index"+index+ "size"+size);
        E element = data[index];
        for(int i = index ; i < size-1;i++){
            data[i] = data[i+1];
        }
        size--;
        return element;
    }
    public E set(int index , E element){
        if(index > data.length || index < 0)
            throw new IndexOutOfBoundsException("index"+index+ "size"+size);
        E old = data[index];
        data[index] = element;
        return old;
    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("[");
        for(int i = 0; i <size ; i++){
            stringBuilder.append(data[i]);
        }
        return stringBuilder.toString()+"]";
    }
    public void trimToSize(){
        if(size != data.length){
            E[] tempdata = (E[])new  Object[size];
            System.arraycopy(data,0,tempdata,0,size);
            data = tempdata;
        }
    }
    public java.util.Iterator<E> iterator(){
        return new ArrayListIterator() ;

        }
        public class ArrayListIterator implements java.util.Iterator<E>{
        private int current = 0;
        public boolean hasNext(){
            return current < size;
        }
        public E next(){
            return data[current++];
        }
            @Override // Remove the element returned by the last next()
        public void remove() {
                 if (current == 0) // next() has not been called yet
                     throw new IllegalStateException();
                 MyArrayList.this.remove(--current);
                 }
                 public int size() {
                     return size;
                 }


        }
    }




