
class Link
{
	int data;
	Link left;
	Link right;
	Link(int data)
	{
		this.data = data;
		left=null;
		right=null;
	}
}

public class Binarytree{
	static Link root;
	
	Binarytree()
	{
		root = null;
	}
	
	
	
	static Link GetNewNode(int data)
	{
		Link link = new Link(data);
		link.left = link.right = null;
		return link;
	}
	static Link Insert(Link root ,int data)
	{
		if(root==null)
		{
			root = GetNewNode(data);
		}
		else if(data <= root.data)
		{
			root.left = Insert(root.left,data);
		}
		else
		{
			root.right = Insert(root.right,data);
		}
		return root;
	}
	void Preorder(Link root)
	{
		if(root == null)
		{
			return;
		}
		System.out.print(root.data+" ");
		Preorder(root.left);
		Preorder(root.right);
	}
	void Inorder(Link root)
	{
		if(root == null)
		{
			return;
		}
		Inorder(root.left);
		System.out.print(root.data+" ");
		Inorder(root.right);
		
	}
	void Postorder(Link root)
	{
		if(root == null)
		{
			return;
		}
		Inorder(root.left);
		Inorder(root.right);
		System.out.print(root.data+" ");
		
		
	}
	static void printGivenLevel(Link root,int i)
	{
		if(root==null)
			return;
		if(i==1)
		{
			System.out.print(root.data+" ");
		}
		else
		{
			printGivenLevel(root.left,i-1);
			printGivenLevel(root.right,i-1);
		}
	}
	void Levelorder(Link root,int height)
	{
		int i=1;
		if (root==null)
			return;
		
		for(i=1;i<=height;i++)
		{
			printGivenLevel(root,i);
		}
	}
	static  Link Search(Link root, int data)
	{
		if(root == null || data == root.data)
		{
			return root ;
		}
		else if(data<=root.data) 
			return Search(root.left,data);
		else 
			return Search(root.right,data);
	}
	
	static Link Min(Link root)
	{
		if(root.left == null)
		{
			System.out.println(root.data);
			return root;
		}
			
		else
			return Min(root.left);
	}
	static Link Max(Link root)
	{
		if(root.right == null)
		{
			System.out.println(root.data);
			return root;
		}
		else
			return Max(root.right);
	}
	static int height(Link root)
	{
		if (root==null)
		{
			return 0;
		}
		else {
			int lheight = height(root.left);
			int rheight = height(root.right);
			if(lheight>rheight)
				return (lheight+1);
			else
				return (rheight+1);
		}
	
	}
	
	static Link Successor(Link root,int data)
	{
		Link current = Search(root,data);
		if(current == null)
			return null;
		else if(current.right !=null) //if a node has right subtree
		{
			Link temp = current.right;
			while(temp.left !=null)
			{
				temp = temp.left;
			}
			return temp;
		}
		else //if node doesnt have right sub tree
		{
			Link successor = null ;
			Link ancestor = root;
			while(ancestor!=current)
			{
				if(current.data <= ancestor.data)
				{
					successor = ancestor;
					ancestor = ancestor.left;
				}
				else
					ancestor = ancestor.right;
			}
			return successor;
		}
			
	}
	static Link findMin(Link root,int data)
	{
		
		if(root == null)
		{
			return root;
		}
		else
		{
			return findMin(root.left,data);
		}
	}
	static int Totalnodes(Link root)
	{
		if(root == null)
			return 0;
		return Totalnodes(root.right)+Totalnodes(root.left)+1;
		
	}
	static Link Delete(Link root,int key)
	{
		 if (root == null)  return root;
		 
	        /* Otherwise, recur down the tree */
	        if (key < root.data)
	            root.left = Delete(root.left, key);
	        else if (key > root.data)
	            root.right = Delete(root.right, key);
	 
	        // if key is same as root's key, then This is the node
	        // to be deleted
	        else
	        {
	            // node with only one child or no child
	            if (root.left == null)
	                return root.right;
	            else if (root.right == null)
	                return root.left;
	 
	            // node with two children: Get the inorder successor (smallest
	            // in the right subtree)
	            Link temp = findMin(root.right,key);
	            root.data = temp.data;
	 
	            // Delete the inorder successor
	            root.right = Delete(root.right, root.data);
	        }
	 
	        return root;
	        }
	static int Leafnodes(Link root)
	{
		if(root == null)
		{
			return 0;
		}
		else if (root.left == null && root.right == null)
		{
			return 1;
		}
		else
		{
			return Leafnodes(root.right)+Leafnodes(root.left);
		}
			
	}
	public static void main(String args[])
	{
		Binarytree tree = new Binarytree();
		
		root=Insert(root,5);
		root=Insert(root,10);
		root=Insert(root,3);
		root= Insert(root,1);
		System.out.println("PreOrder Traversal");
		tree.Preorder(root);
		System.out.println("\n");
		System.out.println("Inorder Traversal");
		tree.Inorder(root);
		System.out.println("\n");
		System.out.println("Postorder Traversal");
		tree.Postorder(root);
		System.out.println("\n\n");
		int h = height(root);
		System.out.println("Height of the tree is "+h+"\n\n");
		Link temp ;
		System.out.println("Levelorder Traversal");
		tree.Levelorder(root,h);
		temp = Search(root,7);
		System.out.println("\n\nSearching.....");
		if(temp==null)
			System.out.print("not present");
		else
			System.out.println("present");
		
		System.out.println("\n\nminimum");
		temp = Min(root);
		//System.out.println(temp.data);
		System.out.println("\n\nmaxmimum");
		temp = Max(root);
		//System.out.println("temp.data");
		temp = Successor(root,5);
		System.out.println("\n\nSuccessor "+temp.data);
		System.out.println("\n\nDelete a Node");
		Delete(root,10);
		System.out.println("\n\nInorder Traversal after Deletion");
		tree.Inorder(root);
		int n = Totalnodes(root);
		System.out.println("\n\nTotal number of nodes"+n);
		n = Leafnodes(root);
		System.out.println("\n\nTotal number of leaf nodes"+n);
		
		
	}
}

