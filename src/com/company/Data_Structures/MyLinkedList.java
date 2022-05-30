package com.company.Data_Structures;

public class MyLinkedList<E> {
    Node<E> head = null;
    Node<E> tail = null;
    int size = 0;
    private class Node<E>{
        E elemnet;
        Node<E> next;
        public Node(E element){
            this.elemnet = element;
        }
    }
    public MyLinkedList(){
    }
    public MyLinkedList(E[] objects){
        for(int i = 0; i < objects.length; i++){
            add(objects[i]);
        }
    }
    public E getFirst(){
        if(size == 0) return null;
        else
            return head.elemnet;
    }
    public E getLast(){
        if(size == 0) return null;
        else
            return tail.elemnet;
    }

    public void add(E element) {
        if (size == 0)
            addFirst(element);
        else {
            Node<E> node = new Node<>(element);
            tail.next = node;
            tail = node;
            size++;
        }
    }
    public void addFirst(E element){
        Node<E> node = new Node<>(element);
        node.next = head;
        head = node;
        size++;
        if(tail == null)
            tail  = head;
    }
    public void addLast(E element){
        Node<E> node = new Node<>(element);
        if(tail == null)
            head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }
        size++;

    }
    public void add(int index, E element){
        if(size == 0)
            addFirst(element);
        else if (index >= size)
            addLast(element);
        else{
            Node<E> current = head;
            for(int i = 1; i < index; i++){
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(element);
            current.next.next = temp;
            size++;

         }
    }
    public E remove(){
         return removeLast();
    }
    public E removeFirst(){
        if(size == 0) return null;
        else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) tail = null;
            return temp.elemnet;
        }
     }
    public E removeLast(){
        if(size == 0) return null;
        else if (size == 1){
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return head.elemnet;
        }
        else{
            Node<E> current = head;
            for(int i = 0; i < size-2; i++)
                current = current.next;
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.elemnet;
        }
    }
    public E remove(int index) {
        if (index < 0 || index > size) return null;
        else if (index == 0) return removeFirst();
        else if (index == size - 1) return removeLast();
        else {
            Node<E> previous = head;
            for (int i = 0; i < index - 1; i++) {
                previous = previous.next;
            }
            Node<E> temp = previous.next;
            previous = temp.next;
            size--;
            return temp.elemnet;
        }
    }
    public E set(int index, E element){
        if(index < 0 || index > size) return null;
        Node<E> current = head;
        for(int i = 1; i < index; i++){
            current =current.next;
        }
        E temp = current.elemnet;
        current.elemnet = element;
        return temp;
    }
    public void clear(){
        size = 0;
        head = tail = null;
    }
    public boolean contains(E element){
        E value;
        Node<E> current = head;
        for(int i = 0; i < size; i++){
            value = current.elemnet;
            if(element == value)  return true;
            else
                current = current.next;
        }
        return false;
    }
    public E get(int index){
        if(index < 0 || index > size) return null;
        Node<E> current = head;
        for(int i = 1; i < index; i++ ){
            current = current.next;
        }
        return current.elemnet;
    }
    public int indexOf(E element){
        Node<E> current = head;
        for(int i = 0; i < size; i++){
            if(current.elemnet == element) return i;
            else
                current = current.next;
        }
        return -1;
    }
    public int lastIndexOf(E element){
        Node<E> current = head;
        int index = -1;
        for(int i = 0; i < size; i++){
            if(current.elemnet == element) index = i;
            else
                current = current.next;
        }
        return index;
    }
    public java.util.Iterator<E> iterator(){
        return new LinkedListIterator();
    }
    private class LinkedListIterator implements java.util.Iterator<E>{
        private Node<E> current = head;
        public boolean hasNext(){
            if(current == null) return false;
            else return true;
        }
        public E next(){
            E e = current.elemnet;
            current = current.next;
            return e;

        }
        public void remove(){
        }
    }
    public int getSize(){
        return size;
    }



}
