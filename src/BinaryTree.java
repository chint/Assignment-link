
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package dsa.assignment.link;

/**
 *
 * @author Chinthaka
 */
public class BinaryTree {
       public  int isbnsrch,isbndel;
Node root;
   public void addNode( String key, String name,String name2,int isbn) {
       
		// Create a new Node and initialize it
  
Node newNode = new Node(key, name, name2,isbn);
		// If there is no root this becomes root

		if (root == null) {

			root = newNode;

		} else {

			// Set root as the Node we will start
			// with as we traverse the tree

			Node focusNode = root;

			// Future parent for our new Node

			Node parent;

			while (true) {

				// root is the top parent so we start
				// there

				parent = focusNode;

				// Check if the new node should go on
				// the left side of the parent node

//				if (key < focusNode.key) {
                                if (key.compareTo( focusNode.key )<0) {
					// Switch focus to the left child
					focusNode = focusNode.leftChild;

					// If the left child has no children

					if (focusNode == null) {

						// then place the new node on the left of it

						parent.leftChild = newNode;
						return; // All Done

					}

				} else { // If we get here put the node on the right

					focusNode = focusNode.rightChild;

					// If the right child has no children

					if (focusNode == null) {

						// then place the new node on the right of it

						parent.rightChild = newNode;
						return; // All Done

					}

				}

			}
		}

	}
   
   public void inOrderTraverseTree(Node focusNode) {

		if (focusNode != null) {

			// Traverse the left node

			inOrderTraverseTree(focusNode.leftChild);

			// Visit the currently focused on node

			System.out.println(focusNode.key);

			// Traverse the right node

			inOrderTraverseTree(focusNode.rightChild);

		}

	}

 int bbg=10,x=0;
	public void findbyIsbn(Node focusNode) 
        {
            
        if (focusNode != null ) {
			System.out.println("here");
                       if(bbg!=100)
                        {System.out.println(focusNode);
                                            
                            if(focusNode.isbn==isbnsrch)
                              {
                                  System.out.println("found");
                              System.out.println(focusNode.key);
                                 JOptionPane.showMessageDialog(null,"Title:"+ focusNode.key+"\n Author:"
                                         +focusNode.name+" "+focusNode.name2+"\n ISBN#:"
                                         +focusNode.isbn,"search result",JOptionPane.INFORMATION_MESSAGE);
                             bbg=100;
                             x=10;
//                             return focusNode.key;
                              }
                        findbyIsbn(focusNode.leftChild);
			findbyIsbn(focusNode.rightChild);
                        }
			                        
		}else if (focusNode == null ) {
           
            if(x == 0 ) {
                    
                    JOptionPane.showMessageDialog(null,"not found");
                    x=10;
                }
               // else{JOptionPane.showMessageDialog(null,"not found");}
	}}  
   
   
}



class Node {

	String key;
     //  ssssss
	String name;
        String name2;
        int isbn;
        

	Node leftChild;
	Node rightChild;

	Node(String key, String name,String name2,int isbn) {

		this.key = key;
//                this.title = title;
		this.name = name;
                this.name2 = name2;
                 this.isbn = isbn;
	}

//	public String toString() {
//
//		//return name +" "+ name2 + " has the key " + key;
//return ""+key;
//		/*
//		 * return name + " has the key " + key + "\nLeft Child: " + leftChild +
//		 * "\nRight Child: " + rightChild + "\n";
//		 */
//
//	}

     public Node getRight()
    {
        return rightChild;
    }
//  public boolean isEmpty() {
//        return true;
//    }
}

