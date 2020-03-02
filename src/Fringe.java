import java.util.ArrayList;

public class Fringe {
	
	Node root;
	ArrayList<Node> Tree;
	
	public Fringe()
	{
		root = new Node(new State(4), null);
		Tree = new ArrayList<Node>();
		Tree.add(root);
	}
	
	public void display()
	{
		for(Node it : Tree)
			it.s.display();
	}
	
	public void expandNode(Node node)
	{
		node.children = new ArrayList<Node>();
		if(node.s.move("up") == 0)
		{
			Node c = new Node(node.s, node);
			node.children.add(c);
			Tree.add(c);
			node.s.move("down");
		}
		if(node.s.move("down") == 0)
		{
			Node c = new Node(node.s, node);
			node.children.add(c);
			Tree.add(c);
			node.s.move("up");
		}
		if(node.s.move("left") == 0)
		{
			Node c = new Node(node.s, node);
			node.children.add(c);
			Tree.add(c);
			node.s.move("right");
		}
		if(node.s.move("right") == 0)
		{
			Node c = new Node(node.s, node);
			node.children.add(c);
			Tree.add(c);
			node.s.move("left");
		}
	}
	
	public class Node
	{
		State s;
		Node parent;
		ArrayList<Node> children;
		int depth;
		
		public Node(State ps, Node p)
		{
			s = new State(ps.size);
			for(int i = 0; i < s.size; i++)
				for(int j = 0; j < s.size; j++)
					s.board[i][j].name = ps.board[i][j].name;		
			parent = p;
			if(parent == null)
				depth = 0;
			else
				depth = p.depth + 1;
		}
	}
}
