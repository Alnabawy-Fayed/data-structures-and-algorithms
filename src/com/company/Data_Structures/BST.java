//package com.company.Data_Structures;
//
//public class BST<E extends Comparable<E>>   {
//    class TreeNode <E>{
//        E element;
//        TreeNode<E> left;
//        TreeNode<E> right;
//        public TreeNode(E element){
//            this.element  = element;
//        }
//
//    }
//    public TreeNode<E> root;
//    int size = 0;
//    public BST(){
//
//    }
//    public BST(E[] elements){
//        for(int i = 0; i < elements.length; i++){
//            insert(elements[i]);
//        }
//    }
//    public boolean search(E e){
//        TreeNode<E> current = root;
//        while(current != null){
//            if(e.compareTo(current.element) < 0){
//                current = current.left;
//            }
//            else if(e.compareTo(current.element) > 0){
//                current = current.right;
//            }
//            else{
//                return true;
//            }
//        }
//        return false;
//    }
//    public boolean insert(E e){
//        if(root == null){
//            root = creatNewNode(e);
//        }
//        else{
//            TreeNode<E> parent = null;
//            TreeNode<E> current = root;
//            while(current != null){
//                if(e.compareTo(current.element) < 0){
//                    parent = current;
//                    current = current.left;
//                }
//                else if(e.compareTo(current.element) > 0){
//                    parent = current ;
//                    current = current.right;
//                }
//                else{
//                    return false;
//                }
//            }
//            if(e.compareTo(parent.element) > 0){
//                parent.right = creatNewNode(e);
//            }
//            else{
//                parent.left = creatNewNode(e);
//            }
//         }
//        size++;
//        return true;
//    }
//    public TreeNode<E> creatNewNode(E e){
//        return new TreeNode<>(e);
//    }
//    public boolean delete(E e){
//        TreeNode<E> parent = null;
//        TreeNode<E> current = root;
//        while(current != null){
//            if(e.compareTo(current.element) < 0){
//                parent = current;
//                current = current.left;
//            }
//            else if(e.compareTo(current.element) > 0 ){
//                parent =current;
//                current = current.right;
//            }
//            else break;
//        }
//        if(current == null) return false;
//
//      }
//
//
//}