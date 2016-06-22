import java.util.ArrayList;
import java.util.List;

public class Node {

	public Node parent;
	public List<Node> children;
	public Object val;
	public static int maxNumOfChildren;

	public Node(Object val){
		this.val = val;
		children = new ArrayList<Node>(maxNumOfChildren);
	}
	
	public void addChild(Node childNode){
	    if(this.children.size()>=maxNumOfChildren)
	    {
	        //do nothing (just don't add another node), or throw an error
	    }
	    else
	    {
	        childNode.parent=this;
	        this.children.add(childNode);
	    }
	}
}
