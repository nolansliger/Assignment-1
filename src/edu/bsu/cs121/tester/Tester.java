package edu.bsu.cs121.tester;

import edu.bsu.cs121.binaryTreeSearch.BinarySearchTree;

public class Tester {
	public static void main(String[] args)
	   {  
		withoutRemoving();
		withRemoving();
	   }

	private static void withRemoving() {
		System.out.println("Replacing root by the smallest child of the right subtree: ");
		BinarySearchTree<Integer> myBST = createTree();
		myBST.remove(10, 1);
		myBST.printInOrder();
		System.out.println(myBST);	
		System.out.println("Replacing root by the largest child of the left subtree ");
		myBST = createTree();
		myBST.remove(10, 2);
		myBST.printInOrder();
		System.out.println(myBST);	
	}

	private static void withoutRemoving() {
		BinarySearchTree<Integer> myBST = createTree();
		System.out.println("The original input numbers's order: 10, 7, 15, 3, 9, 8");
		myBST.printInOrder();
		System.out.println("The tree size is: " + myBST.size());
		System.out.println("Print Binary Tree with List Format: ");	
		System.out.println(myBST);	
	
	}

	private static BinarySearchTree<Integer> createTree() {
		BinarySearchTree<Integer> myBST=new BinarySearchTree<Integer>();
		myBST.add(10);
		myBST.add(7);
		myBST.add(15);
		myBST.add(3);
		myBST.add(3);
		myBST.add(9);
		myBST.add(8);
		myBST.add(8);
		return myBST;
	}
}
