
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
       
		// Create a new Node 
  
Node newNode = new Node(key, name, name2,isbn);
		// If there is no root

		if (root == null) {

			root = newNode;

		} else {

			// Set root as the Node we will start
			
			Node focusNode = root;

			//  parent for  new Node

			Node parent;

			while (true) {

				

				parent = focusNode;

				// Check if the new node should go on
				// the left side of the parent node
//"abc".compareTo("def")
//will yield something smaller than 0 as abc is alphabetically before def.
                                if (key.compareTo( focusNode.key )>0) {
					//  focus to the left child
					focusNode = focusNode.leftChild;
System.out.println("left");
					// left child has no children

					if (focusNode == null) {

						// new node on the left 

						parent.leftChild = newNode;
						return; 

					}

				} else { 

					focusNode = focusNode.rightChild;
System.out.println("right");
					// If the right child has no children

					if (focusNode == null) {

						//  new node on the right 

						parent.rightChild = newNode;
						return; 

					}

				}

			}
		}

	}
   


 int bbg=10,x=0;

// method for find node by isbn
	public void findbyIsbn(Node focusNode) 
        {
            
        if (focusNode != null ) {
			
                       if(bbg!=100)
                        {System.out.println(focusNode);
      //because isbn is not the key the whole tree must be searched                                      
                            if(focusNode.isbn==isbnsrch)
                              {
                                  System.out.println("found");
                              System.out.println(focusNode.key);
                                 JOptionPane.showMessageDialog(null,"Title:"+ focusNode.key+"\n Author:"
                                         +focusNode.name+" "+focusNode.name2+"\n ISBN#:"
                                         +focusNode.isbn,"search result",JOptionPane.INFORMATION_MESSAGE);
                             bbg=100;
                             x=10;

                              }
                        findbyIsbn(focusNode.leftChild);
			findbyIsbn(focusNode.rightChild);
                        }
			                        
		}else if (focusNode == null ) {
           
            if(x == 0 ) {
                    
                    JOptionPane.showMessageDialog(null,"not found");
                    x=10;
                }
               
	}}  
        
        
        
        public Node findNode(String key) {

		// Start at the top 
		Node focusNode = root;


		while ((key.compareTo( focusNode.key ))!=0) {
			// search to the left

			if ((key.compareTo( focusNode.key ))<0) {
				// focus Node to the left child

				focusNode = focusNode.leftChild;
			} else  {
                        
				//  focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// The node wasn't found

			if (focusNode == null){

                        	return null;}

		}
 //return found value
		return focusNode;
               

	}
      public int del=5 ;
    public void deletebyisbn(Node focusNode) {
        //delete node by isbn #
          if (focusNode != null) {
			System.out.println("del here"+bbg+isbndel);
                        
                        if(bbg!=100)
                        {System.out.println(focusNode.isbn);
                       // findNodei(focusNode);
                        
                            if(focusNode.isbn==isbndel)
                              {
                                  System.out.println("found");
                                  System.out.println(focusNode.key);
        //send key of the isbn for removal
                                  remove(focusNode.key);
//                                    del=true;
                                    bbg=100;
                                     del=1;
                                     
                              }
                        deletebyisbn(focusNode.leftChild);
			deletebyisbn(focusNode.rightChild);
                        }		                       
		}
                   
    }
   
  public boolean remove(String key) {

		// Start at the top 

		Node focusNode = root;
		Node parent = root;

		

		boolean isItALeftChild = true;

		

		while ((key.compareTo(focusNode.key))!=0) {

			parent = focusNode;

			// search to the left

			if ((key.compareTo( focusNode.key ))>0) {

				isItALeftChild = true;

				//  focus Node to the left child

				focusNode = focusNode.leftChild;

			} else {

				// Greater than focus node so go to the right

				isItALeftChild = false;

				//  focus Node to the right child

				focusNode = focusNode.rightChild;

			}

			// node not

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
        
  public static void main(String[] args) {
    BinaryTree theTree = new BinaryTree();
 
		
    
    
     //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
 java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
		
           
		// Different ways to traverse binary trees

		// theTree.inOrderTraverseTree(theTree.root);

		// theTree.preorderTraverseTree(theTree.root);

		// theTree.postOrderTraverseTree(theTree.root);

		// Find the node with key 75

		//System.out.println("\nNode with the key 75");
           
//Scanner in = new Scanner(System.in);
// 
//      System.out.println("Enter a string");
//     isbnsrch = Integer.parseInt(in.nextLine());
     
	//	System.out.println(theTree.findNodei(theTree.root,43));
           //theTree.remove("");
//theTree.findbyIsbn(theTree.root);
//System.out.println(theTree.postOrderTraverseTree(theTree.root));
//
 
//theTree.findNodei(50);
//System.out.println(theTree.findMaximum(theTree.root).key);
}
    
}



class Node {

	String key;
     
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

}

