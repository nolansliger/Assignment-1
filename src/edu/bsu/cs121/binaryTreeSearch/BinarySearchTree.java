package edu.bsu.cs121.binaryTreeSearch;

import edu.bsu.cs121.treeClasses.exceptions.EmptyCollectionException;

/*
 * author: Mr. Aaron Feng and Dr. Jeff Zhang
 * References: "Big Java" Textbook- Author: Dr. Horstmann
 */
public class BinarySearchTree<T> {
	private Node<T> root;
	private int count;

	/**
	 * Constructs an empty tree.
	 */
	public BinarySearchTree() {
		root = null;
		count = 0;
	}

	/**
	 * Inserts a new node into the tree.
	 * 
	 * @param obj
	 *            the object to insert
	 */
	// For your Project 3 BST, you need to modify the add() method
	// so that it will no longer allow duplicates.
	public void add(T obj) // add root first
	{
		Node<T> newNode = new Node<T>(obj);
		if (root == null) {
			root = newNode;
			count++;
		} else {
			if (!find(obj)) {
				root.addNode(newNode);
				count++;
			}

		}
	}

	/**
	 * Tries to find an object in the tree.
	 * 
	 * @param obj
	 *            the object to find
	 * @return true if the object is contained in the tree
	 */

	@SuppressWarnings("unchecked")
	public boolean find(T obj) {
		Node<T> current = root;

		while (current != null) {
			Comparable<T> tempElement = (Comparable<T>) current.getElement();
			int d = tempElement.compareTo(obj);
			if (d == 0)
				return true;
			else if (d > 0) {
				current = current.getLeft();
			} else {
				current = current.getRight();
			}
		}
		return false;
	}

	/**
	 * Tries to remove an object from the tree. Does nothing if the object is
	 * not contained in the tree.
	 * 
	 * @param obj
	 *            the object to remove
	 */
	@SuppressWarnings("unchecked")
	/*
	 * Project 3 Task 2: Modify remove(T obj) method with remove (T obj, int
	 * flag) from BinarySearchTree class. When flag==1: the ToBeRemoved node
	 * with two children will be replaced by the smallest child of its right
	 * sub-tree. When flag==2: the ToBeRemoved node with two children is
	 * replaced by the largest child of its left sub-tree.
	 */
	public void remove(T obj, int flag) {
		// Find node to be removed

		Node<T> toBeRemoved = root;
		Node<T> parent = null;
		boolean found = false;
		while (!found && toBeRemoved != null) {
			Comparable<T> tempElement = (Comparable<T>) toBeRemoved.getElement();
			int d = tempElement.compareTo(obj);
			if (d == 0)
				found = true;
			else {
				parent = toBeRemoved;
				if (d > 0)
					toBeRemoved = toBeRemoved.getLeft();
				else
					toBeRemoved = toBeRemoved.getRight();
			}
		}

		if (!found)
			return;

		// toBeRemoved contains obj

		// If one of the children is empty, use the other

		if (toBeRemoved.getLeft() == null || toBeRemoved.getRight() == null) {
			Node<T> newChild;
			if (toBeRemoved.getLeft() == null)
				newChild = toBeRemoved.getRight();
			else
				newChild = toBeRemoved.getLeft();

			if (parent == null) // Found in root
				root = newChild;
			else if (parent.getLeft() == toBeRemoved)
				parent.setLeft(newChild);
			else
				parent.setRight(newChild);
			return;
		}

		// Neither subtree is empty
		// Your Project 3 modified code should add to the below:
		if (flag == 1) {
			
		Node<T> smallestParent = toBeRemoved;
		Node<T> smallest = toBeRemoved.getRight();
		while(smallest.getLeft()!=null){
			smallestParent=smallest;
			smallest=smallest.getLeft();
		}
		toBeRemoved.setElement(smallest.getElement());
		if(!smallestParent.getElement().equals(toBeRemoved.getElement())){
			smallestParent.setLeft(smallest.getRight());
		}
		else{
			smallestParent.setRight(null);
		}
			
		smallest.setElement(null);
		//			Node<T> smallest = toBeRemoved.getRight();
//			while (smallest.getLeft() != null) {
//				smallestParent = smallest;
//				smallest = smallest.getLeft();
//				toBeRemoved.setElement(smallest.getElement());
//				if (smallest.getRight() != null) {
//					toBeRemoved.setRight(smallest.getRight());
//				}
//
//				// Find smallest element of the right subtree
//			}
		} else {
			Node<T> largestParent = toBeRemoved;
			Node<T> largest = toBeRemoved.getLeft();
			while(largest.getRight()!=null){
				largestParent=largest;
				largest=largest.getRight();
			}
			toBeRemoved.setElement(largest.getElement());
			if(!largestParent.getElement().equals(toBeRemoved.getElement())){
				largestParent.setRight(largest.getLeft());
			}
			else{
				largestParent.setLeft(null);
			}
				
			largest.setElement(null);

				// Find largest element of the left subtree
				// Add your Project 3 code here
			}
		}
	// close remove(T obj, int flag) method

	/**
	 * Prints the contents of the tree in InOrder.
	 */
	public void printInOrder() {
		if (root != null) {
			root.printNodesInOrder();
		}
		System.out.println();
	}

	/**
	 * Prints the contents of the tree in PreOrder.
	 */
	public void printPreOrder() {
		if (root != null) {
			root.printNodesPreOrder();
		}
		System.out.println();
	}

	/**
	 * Prints the contents of the tree in PostOrder.
	 */
	public void printPostOrder() {
		if (root != null) {
			root.printNodesPostOrder();
		}
		System.out.println();
	}

	/**
	 * Returns the element with the least value in the binary search tree. It
	 * does not remove the node from the binary search tree. Throws an
	 * EmptyBinarySearchTreeException if this tree is empty.
	 *
	 * @return the element with the least value
	 * @throws EmptyCollectionException
	 *             if an empty collection exception occurs
	 */
	public T findMin() throws EmptyCollectionException {
		T result = null;
		if (isEmpty()) {
			throw new EmptyCollectionException("binary search tree");
		} else {
			Node<T> current = root;
			while (current.getLeft() != null) {
				current = current.getLeft();
			}
			result = current.getElement();
		}
		return result;
	}

	/**
	 * Returns the element with the highest value in the binary search tree. It
	 * does not remove the node from the binary search tree. Throws an
	 * EmptyBinarySearchTreeException if this tree is empty.
	 *
	 * @return the element with the highest value
	 * @throws EmptyCollectionException
	 *             if an empty collection exception occurs
	 */
	public T findMax() throws EmptyCollectionException {
		T result = null;
		if (isEmpty())

		{
			throw new EmptyCollectionException("binary search tree");
		}

		else {
			Node<T> current = root;
			while (current.getRight() != null) {
				current = current.getRight();
			}
			result = current.getElement();
		}
		return result;
	}// close findMax() method

	/**
	 * Returns the integer size of this tree.
	 *
	 * @return the integer size of this tree
	 */
	public int size() {
		return count;
	}

	/**
	 * Returns true if this binary tree is empty and false otherwise.
	 *
	 * @return true if this binary tree is empty
	 */

	public boolean isEmpty() {
		return count == 0;
	}

	public String toString() {
		return root.toString();
	}


}// close BinarySearchTree class
