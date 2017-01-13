package edu.bsu.cs121.binaryTreeSearch;

import java.util.ArrayList;

//Author: Dr. Jeff Zhang and Mr. Aaron Feng
public class Node <T> {
	private Node <T> left;
	private Node <T> right;
	private T element;
/**
	    * Creates a new tree node with the specified data.
	    *
	    * @param obj  the element that will become a part of the new tree node
 */
	public Node ( T obj){
		left=null;
		right=null;
		element=obj;
	}
	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	@SuppressWarnings("unchecked")
	//For your Project 3 BST, you need to modify the addNode () method
	//so that it will no longer allow duplicates.
	public void addNode(Node <T> newNode){
		Comparable<T> tempElement = (Comparable<T>) newNode.element;	
		int comp = tempElement.compareTo(element);
	      if (comp < 0)
	      {  
	         if (left == null) 
	        	 {left = newNode;}
	         else 
	        	 {left.addNode(newNode);}
	      }
	     
	      else if (comp > 0)
	      {  
	         if (right == null) 
	        	 {right = newNode;}
	         else 
	        	 {right.addNode(newNode);}
	      }
	}
	public void printNodesInOrder()
	   {  
	      if (left != null)
	         {left.printNodesInOrder();}
	      System.out.print(element + " ");
	      if (right != null)
	         {right.printNodesInOrder();}
	   }
	   
	   public void printNodesPostOrder()
	   {  
	      if (left != null)
	         {left.printNodesPostOrder();} 
	      if (right != null)
	         {right.printNodesPostOrder();}
	      System.out.print(element + " ");
	   }
	   
	   public void printNodesPreOrder()
	   {  
		  System.out.print(element + " ");
	      if (left != null)
	         {left.printNodesPreOrder();}
	      if (right != null)
	         {right.printNodesPreOrder();}
	   }
	 // finish your Project 3 code here:
	 //Write an Override method called toString() method here 
/*
 * For instance, if you add nodes like: 10, 7, 15, 3, 9, 8 
 * into BinarySearchTree, when toString() method is called in 
 * a Tester class, it will print the below result to the console window:  
 *   ( (  (  .  3   .  )  7   (  (  .  8   .  )  9   .  )  )  10   (  .  15   .  ) )
 */
	 
	   public String toString(){
		   if(element==null){
			   return"";
		   }
		   String leftResult=".";
		   String rightResult=".";
		   if(left!=null){
			   leftResult=left.toString();
		   }
		   if(right!=null){
			   rightResult=right.toString();
		   }
		   return String.format("(%s %s %s)", leftResult,element.toString(),rightResult);
	   }
}//close Node class
