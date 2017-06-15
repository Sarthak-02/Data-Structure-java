package binary_tree;

import java.util.Stack;

class Node{
	int data;
	int h;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		
	}
}

public class AVLtree {
	static Node root;
	AVLtree(){
		root=null;
	}
	static Node GetNewNode(int data){
		Node node = new Node(data);
		node.left = node.right = null;
		node.h=0;
		return node;
	}
	
	static Node right_rotate(Node root){
		Node newRoot = root.right;
		root.left = newRoot.right;
		newRoot.right = root;
		root.h = Math.max(height(root.left), height(root.right))+1;
		newRoot.h = Math.max(height(newRoot.left), height(newRoot.right))+1;
		return newRoot;
		
	}
	static Node left_rotate(Node root){
		Node newRoot = root.left;
		root.right = newRoot.left;
		newRoot.left = root;
		root.h = Math.max(height(root.left), height(root.right))+1;
		newRoot.h = Math.max(height(newRoot.left), height(newRoot.right))+1;
		return newRoot;
	}
	static int height(Node root)
	{
		if(root==null) {
			return 0;
		}
		else{
			int lheight = height(root.left);
			int rheight = height(root.right);
			return Math.max(lheight, rheight)+1;
		}
		
	}
	
	static Node insert(Node root,int data){
		if(root==null) {
			root=GetNewNode(data);
		}
		else if(data <= root.data){
			root.left = insert(root.left,data);
		}
		else{
			root.right = insert(root.right,data);
		}
		int bal = height(root.left) - height(root.right);
		if(bal>1)
		{
			if(height(root.left.left)>height(root.left.right)){
				//L-L Rotation
				return left_rotate(root);
			}
			else{
				//L-R Rotation
				root.left =  left_rotate(root.left);
				return right_rotate(root);
			}
		}
		if(bal<-1){
			if(height(root.right)>height(root.left)){
				//R-R rotation
				return right_rotate(root);
			}
			else{
				//R-L Rotation
				root.right = right_rotate(root.right);
				return left_rotate(root);
			}
		}
		root.h =Math.max(height(root.left), height(root.right))+1;
		return root;
	}
	
	static void iterative_InOrder(Node root)
	{
		if(root==null) return ;
		Stack<Node> s = new Stack<Node>();
		while(true){
			if(root!=null){
				s.push(root);
				root=root.left;
			}
			else{
				if(s.isEmpty()) break;
				root=s.pop();
				System.out.print(root.data+" "); 
				root=root.right;
			}
		}
	}
	public static void main(String args[]){
		AVLtree avl = new AVLtree();
		root = insert(root,5);
		root = insert(root,10);
		root = insert(root,4);
		root = insert(root,9);
		root = insert(root,11);
		System.out.println(height(root));
		iterative_InOrder(root);
	}
}
