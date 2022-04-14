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

//Recursive
class Solution {
   List<Integer> result = new ArrayList<Integer>();
public List<Integer> postorderTraversal(TreeNode root) {
    
    if(root == null)
        return result;
    
    postorderTraversal(root.left);
    postorderTraversal(root.right);
    result.add(root.val);
    return result;
}
}

// Iterative

class Solution {

public List<Integer> postorderTraversal(TreeNode root) {

Stack stack = new Stack<>();

    while(true) {
        while(root != null) {
            stack.push(root);
            stack.push(root);
            root = root.left;
        }
         
        // Check for empty stack
        if(stack.empty()) return;
        root = stack.pop();
         
        if(!stack.empty() && stack.peek() == root) root = root.right;
         
        else {
             
            System.out.print(root.data + " "); root = null;
        }
    }