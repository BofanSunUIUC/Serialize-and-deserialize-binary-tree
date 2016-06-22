import java.util.ArrayList;

public class Codec{

	public static String serialize(Node root){
		StringBuilder str = new StringBuilder();
		serialize_helper(root, str);
		return str.toString();
	}
	
	public static void serialize_helper(Node root, StringBuilder str){
		if(root == null) return ;
		str.append(root.val + ",");
		for(int i = 0; i < root.children.size(); i++){
			if(root.children.get(i) != null){
				serialize_helper(root.children.get(i), str);
			}
		}
		str.append("#,");
	}
	
	static int count = 0;
	public static Node deserialize(String data, int kArity){
		String[] list = data.split(",");
		return deserialize_helper(list, kArity);
	}	

	public static Node deserialize_helper(String[] list, int kArity){		
		if(count >= list.length || list[count].equals("#")){
		    count++;
		    return null;
		}
		Node curr = new Node(Integer.parseInt(list[count]));
		count++;
		for(int i = 0; i < kArity; i++){
			Node temp = deserialize_helper(list, kArity);
			if( temp!= null) {
				curr.addChild(temp);
			}
			else{
				break;
			}
		}
		return curr;
	}

	public static void main(String[] args) {
		naryTree tree = new naryTree(4);
	
		Node B = new Node(2);
		Node C = new Node(3);
		Node D = new Node(4);
		Node E = new Node(5);
		Node F = new Node(6);
		Node G = new Node(7);
		Node H = new Node(8);
		Node I = new Node(9);		
		Node J = new Node(10);
		Node K = new Node(11);
	
		tree.addRoot(1);
		
		tree.root.addChild(B);
		tree.root.addChild(C);
		tree.root.addChild(D);
		
		B.addChild(E);
		B.addChild(F);
		
		D.addChild(G);
		D.addChild(H);
		D.addChild(I);
		D.addChild(J);
		
		F.addChild(K);
		
		System.out.println(serialize(tree.root));
		System.out.println(tree.numberOfNodesInTree(tree.root));
		System.out.println(serialize(deserialize(serialize(tree.root), tree.root.maxNumOfChildren)));
	}

}
