
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package dsa.assidcdscdscdsgndccscsnk;

/**
 *
 * c
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
//gitcon
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
        
        
        
        public Node findNode(String key) {

		// Start at the top of the tree
System.out.println("fnkey"+key);
		Node focusNode = root;
//System.out.println( focusNode.rightChild.key);
		// While we haven't found the Node
		// keep looking

		while ((key.compareTo( focusNode.key ))!=0) {
//System.out.println(key.compareTo( focusNode.key ) );
			// If we should search to the left

			if ((key.compareTo( focusNode.key ))<0) {
 //System.out.println("gg"+key+focusNode.key+key.compareTo( focusNode.key ) );
				// Shift the focus Node to the left child

				focusNode = focusNode.leftChild;
//System.out.println(key.compareTo( focusNode.key ) );
			} else  {
                        
 //System.out.println("ff"+key.compareTo( focusNode.key ) );
				// Shift the focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found

			if (focusNode == null){
// System.out.println("hh"+key.compareTo( focusNode.key ) );
                            //System.out.println("nothingf");
                        	return null;}

		}
 //System.out.println("this retturn" );
		return focusNode;
               

	}
    public void deletebyisbn(Node focusNode) {
          if (focusNode != null) {
			System.out.println("del here"+bbg+isbndel);
                        
                        if(bbg!=100)
                        {System.out.println(focusNode.isbn);
                       // findNodei(focusNode);
                        
                            if(focusNode.isbn==isbndel)
                              {
                                  System.out.println("found");
                                  System.out.println(focusNode.key);
                                 remove(focusNode.key);
                                    bbg=100;
                              }
                        deletebyisbn(focusNode.leftChild);
			deletebyisbn(focusNode.rightChild);
                        }		                       
		}
	}
   
  public boolean remove(String key) {

		// Start at the top of the tree

		Node focusNode = root;
		Node parent = root;

		// When searching for a Node this will
		// tell us whether to search to the
		// right or left

		boolean isItALeftChild = true;

		// While we haven't found the Node
		// keep looking

		while ((key.compareTo( focusNode.key ))!=0) {

			parent = focusNode;

			// If we should search to the left

			if ((key.compareTo( focusNode.key ))<0) {

				isItALeftChild = true;

				// Shift the focus Node to the left child

				focusNode = focusNode.leftChild;

			} else {

				// Greater than focus node so go to the right

				isItALeftChild = false;

				// Shift the focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found

			if (focusNode == null)
				return false;

		}

		// If Node doesn't have children delete it

		if (focusNode.leftChild == null && focusNode.rightChild == null) {

			// If root delete it

			if (focusNode == root)
				root = null;

			// If it was marked as a left child
			// of the parent delete it in its parent

			else if (isItALeftChild)
				parent.leftChild = null;

			// Vice versa for the right child

			else
				parent.rightChild = null;

		}

		// If no right child

		else if (focusNode.rightChild == null) {

			if (focusNode == root)
				root = focusNode.leftChild;

			// If focus Node was on the left of parent
			// move the focus Nodes left child up to the
			// parent node

			else if (isItALeftChild)
				parent.leftChild = focusNode.leftChild;

			// Vice versa for the right child

			else
				parent.rightChild = focusNode.leftChild;

		}

		// If no left child

		else if (focusNode.leftChild == null) {

			if (focusNode == root)
				root = focusNode.rightChild;

			// If focus Node was on the left of parent
			// move the focus Nodes right child up to the
			// parent node

			else if (isItALeftChild)
				parent.leftChild = focusNode.rightChild;

			// Vice versa for the left child

			else
				parent.rightChild = focusNode.rightChild;

		}

		// Two children so I need to find the deleted nodes
		// replacement

		else {

			Node replacement = getReplacementNode(focusNode);

			// If the focusNode is root replace root
			// with the replacement

			if (focusNode == root)
				root = replacement;

			// If the deleted node was a left child
			// make the replacement the left child

			else if (isItALeftChild)
				parent.leftChild = replacement;

			// Vice versa if it was a right child

			else
				parent.rightChild = replacement;

			replacement.leftChild = focusNode.leftChild;

		}

		return true;

	}  
  
  public Node getReplacementNode(Node replacedNode) {

		Node replacementParent = replacedNode;
		Node replacement = replacedNode;

		Node focusNode = replacedNode.rightChild;

		// While there are no more left children

		while (focusNode != null) {

			replacementParent = replacement;

			replacement = focusNode;

			focusNode = focusNode.leftChild;

		}

		// If the replacement isn't the right child
		// move the replacement into the parents
		// leftChild slot and move the replaced nodes
		// right child into the replacements rightChild

		if (replacement != replacedNode.rightChild) {

			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;

		}

		return replacement;    
        }
        
    
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

		this.name = name;
                this.name2 = name2;
                 this.isbn = isbn;
	}



     public Node getRight()
    {
        return rightChild;
    }
//  public boolean isEmpty() {
//        return true;
//    }
}

