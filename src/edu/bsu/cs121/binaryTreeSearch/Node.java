package edu.bsu.cs121.binaryTreeSearch;

import java.util.ArrayList;

public class TreeNode <T> {
	//Changed Node to TreeNode.  More descriptive class name 
	private Node <T> leftNode;
	//changed left to leftNode, more descriptive
	private Node <T> rightNode;
	//same as the leftNode
	private T element;
/**
	    * Creates a new tree node with the specified data.
	    *
	    * @param obj  the element that will become a part of the new tree node
 */
	public TreeNode ( T obj){
		leftNode=null;
		rightNode=null;
		element=obj;
	}
	public TreeNode<T> getLeft() {
		return leftNode;
	}

	public void setLeft(Node<T> leftNode) {
		this.left = leftNode;
	}

	public Node<T> getRight() {
		return rightNode;
	}

	public void setRight(Node<T> rightNode) {
		this.right = rightNode;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}
//changed left and right to leftNode and rightNode throughout the document
	@SuppressWarnings("unchecked")
	//For Project 3 BST, you need to modify the addNode () method
	//so that it will no longer allow duplicates.
	
	//this function follows structured programming and Edsger Dijkstra's rules of structured programming
	public void addNode(Node <T> newNode){
		Comparable<T> tempElement = (Comparable<T>) newNode.element;	
		int comp = tempElement.compareTo(element);
	      if (comp < 0)
	      {  
	         if (leftNode == null) 
	        	 {leftNode = newNode;}
	         else 
	        	 {leftNode.addNode(newNode);}
	      }
	     
	      else if (comp > 0)
	      {  
	         if (rightNode == null) 
	        	 {rightNode = newNode;}
	         else 
	        	 {rightNode.addNode(newNode);}
	      }
	}
	public void printNodesInOrder()
	   {  
	      if (leftNode != null)
	         {leftNode.printNodesInOrder();}
	      System.out.print(element + " ");
	      if (rightNode != null)
	         {rightNode.printNodesInOrder();}
	   }
	   
	   public void printNodesPostOrder()
	   {  
	      if (leftNode != null)
	         {leftNode.printNodesPostOrder();} 
	      if (rightNode != null)
	         {rightNode.printNodesPostOrder();}
	      System.out.print(element + " ");
	   }
	   
	   public void printNodesPreOrder()
	   {  
		  System.out.print(element + " ");
	      if (leftNode != null)
	         {leftNode.printNodesPreOrder();}
	      if (rightNode != null)
	         {rightNode.printNodesPreOrder();}
	   }

	 
	   public String toString(){
		   if(element==null){
			   return"";
		   }
		   String leftResult=".";
		   String rightResult=".";
		   if(leftNode!=null){
			   leftResult=leftNode.toString();
		   }
		   if(rightNode!=null){
			   rightResult=rightNode.toString();
		   }
		   return String.format("(%s %s %s)", leftResult,element.toString(),rightResult);
	   }
}//close Node class

//All other sections that implement or use functions, classes, etc., from this class will have to change with this one.  This includes 
//items that were renamed, code that was shortened/simplified.  A partial review of some of the overall project would probably be required.
