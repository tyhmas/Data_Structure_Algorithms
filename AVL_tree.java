import java.util.*;

class TreeNode{
	public int val;
	public TreeNode left;
	public TreeNode right;
	public int height;

	TreeNode(int val){
		this.val = val;
		left = right = null;
		height = 1;
	}
}

class AVL_Tree{
	TreeNode root;

	public static void main(String[] args){
		AVL_Tree avl = new AVL_Tree();
		avl.root = avl.insertion(3, avl.root);
		int[] array = new int[]{8, 6, 7, 20, 2};
		for(int i = 0; i < array.length; i++){
			avl.insertion(array[i], avl.root);
		}
		System.out.println("Preorder traversal" +
                        " of constructed tree is : ");
		avl.preorder(avl.root);

		//System.out.println("Inorder traversal" +
        //                " of constructed tree is : ");
		//avl.inorder(avl.root);
	}

	private int getHeight(TreeNode node){
		return 1 + Math.max(node.left.height, node.right.height);
	}

	private int getBalance(TreeNode node){
		if (node == null){
			return 0;
		}
		return getHeight(node.left) - getHeight(node.right);
	}

	private TreeNode leftRotate(TreeNode node){
		TreeNode a = node;
		TreeNode b = node.right;
		TreeNode c = b.left;

		a.right = c;
		b.left = a;

		a.height = getHeight(a);
		b.height = getHeight(b);

		return b;
	}

	private TreeNode rightRotate(TreeNode node){
		TreeNode a = node;
		TreeNode b = node.left;
		TreeNode c = b.right;

		a.left = c;
		b.right = a;

		a.height = getHeight(a);
		b.height = getHeight(b);

		return b;
	}

	private TreeNode insertion(int val, TreeNode root){
		if (root == null){
			TreeNode node = new TreeNode(val);
			return node;
		}

		if (root.val > val){
			root.left = insertion(val, root.left);
			return root;
		}
		else if (root.val < val){
			root.right = insertion(val, root.right);
			return root;
		}
		else{
			//AVL tree part
			root.height = getHeight(root);
			int balance = getBalance(root);

			//RR
			if (balance > 1 && val < root.left.val){
				return rightRotate(root);
			}
			//LR
			else if (balance > 1 && val > root.left.val ){
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}
			//LL
			else if (balance < -1 && val > root.right.val){
				return leftRotate(root);
			}
			//RL
			else if (balance < -1 && val < root.right.val){
				root.right = rightRotate(root.right);
				return leftRotate(root);
			}
		}

		return root;
	}

	private TreeNode deletion(int val, TreeNode root){
		if (root == null){
			return null;
		}

		if (root.val > val){
			root.left = deletion(val, root.left);
			return root;
		}
		else if (root.val < val){
			root.right = deletion(val, root.right);
			return root;
		}
		else{
			//Find the leftmost node in root's right side for succedent
			TreeNode succParent = root;
			TreeNode succ = root.right;

			while(succ != null){
				succParent = succ;
				succ = succParent.left;
			}

			if (succParent == root){
				succParent.right = succ.right;
			}
			else{
				succParent.left = succ.right;
			}

			root.val = succ.val;

			//AVL tree part
			root.height = getHeight(root);
			int balance = getBalance(root);

			//RR
			if (balance > 1 && val < root.left.val){
				return rightRotate(root);
			}
			//LR
			else if (balance > 1 && val > root.left.val ){
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}
			//LL
			else if (balance < -1 && val > root.right.val){
				return leftRotate(root);
			}
			//RL
			else if (balance < -1 && val < root.right.val){
				root.right = rightRotate(root.right);
				return leftRotate(root);
			}
		}

		return root;
		
	}

	private TreeNode find(int val, TreeNode root){
		if (root == null){
			return null;
		}

		if (root.val == val){
			return root;
		}
		else{
			return (root.val > val)? find(val, root.left) : find(val, root.right);
		}
	}

	private void inorder(TreeNode root){
		if (root != null){
			inorder(root.left);
			System.out.print(root.val + " ");
			inorder(root.right);
		}
	}

	private void preorder(TreeNode root){
		if (root != null){
			System.out.print(root.val + " ");
			inorder(root.left);
			inorder(root.right);
		}
	}
}