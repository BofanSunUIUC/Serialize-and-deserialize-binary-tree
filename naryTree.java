import java.util.ArrayList;
import java.util.List;

public class naryTree {
	public Node root;
	
	public naryTree(int kArity)
	{
	    Node.maxNumOfChildren = kArity;        
	}
	
	public void addRoot(Object info)
	{
	    root = new Node(info);
	    root.parent = null;
	    root.children = new ArrayList<Node>(Node.maxNumOfChildren);
	}
	
	public int numberOfNodesInTree(Node rootNode){
	    int count=0;

	    count++;
	    if(rootNode.children.size()!=0)
	        for(Node ch : rootNode.children)
	            count=count+numberOfNodesInTree(ch);

	    return count;
	}
	public static void main(String[] args) {
	    naryTree tree=new naryTree(3);
	    Node a = new Node("a");
	    Node b = new Node("b");
	    Node c = new Node("c");

	    tree.addRoot("root");
	    tree.root.addChild(a);
	    a.addChild(b);
	    tree.root.addChild(c);
	    System.out.println(tree.numberOfNodesInTree(tree.root));
	}

}
