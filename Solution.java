/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /**
  * 1. Print the tree in pre-order traversal and use "#" to denote null node and split node with ",". 
  * 2. We can use a StringBuilder for building the string on the fly. 
  * 3. For deserializing, we use a String array to store the pre-order traversal and since we have "#" as null node, 
  * 4. we know exactly how to where to end building subtress.
  */
public class Codec {
	public String serialize(TreeNode root){
        StringBuilder str = new StringBuilder();
        serialize_helper(root, str);
        return str.toString();
	}
	
	public void serialize_helper(TreeNode root, StringBuilder str){
		if(root == null){
			str.append("#,");
			return;
		}
		str.append(root.val+",");
		serialize_helper(root.left, str);
		serialize_helper(root.right, str);
		return;
	}
	
	
	int count = 0;

	public TreeNode deserialize(String data){
	    if(data == "") return null;
		String[] list = data.split(",");
        return deserialize_helper(list);
	}
	
	public TreeNode deserialize_helper(String[] list){
		if(count >= list.length || list[count].equals("#")){
		    count++;
		    return null;
		}
		TreeNode curr = new TreeNode(Integer.parseInt(list[count]));
		count++;
		curr.left = deserialize_helper(list);
		curr.right = deserialize_helper(list);
		
		return curr;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
