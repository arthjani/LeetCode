
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


//Recursive method with List as returning value:


class Solution {
List<Integer> a=new ArrayList<Integer>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root ==null)
            return a;
        a.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return a;
    }
}

//Recursive method with Helper method to have a List as paramater, so we can modify the parameter and don't have to instantiate a new List at each recursive call:
	class solutin{
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> pre = new LinkedList<Integer>();
		preHelper(root,pre);
		return pre;
	}
	public void preHelper(TreeNode root, List<Integer> pre) {
		if(root==null) return;
		pre.add(root.val);
		preHelper(root.left,pre);
		preHelper(root.right,pre);
	}
}

//Iterative method with Stack:
class solution{
	public List<Integer> preorderIt(TreeNode root) {
		List<Integer> pre = new LinkedList<Integer>();
		if(root==null) return pre;
		Stack<TreeNode> tovisit = new Stack<TreeNode>();
		tovisit.push(root);
		while(!tovisit.empty()) {
			TreeNode visiting = tovisit.pop();
			pre.add(visiting.val);
			if(visiting.right!=null) tovisit.push(visiting.right);
			if(visiting.left!=null) tovisit.push(visiting.left);
		}
		return pre;
	}
}