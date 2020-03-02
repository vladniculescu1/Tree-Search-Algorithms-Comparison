import java.util.Comparator;
import java.util.PriorityQueue;

public class AStar {
	
	int nodeNumber = 1;
	State solution;
	Fringe f = new Fringe();
	PriorityQueue<Fringe.Node> queue = new PriorityQueue<Fringe.Node>(1, new NodeComparator());
	
	
	public AStar()
	{
		solution = new State(4);
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 4; j++)
				solution.board[i][j].name = "/";
		solution.board[1][1].name = "A";
		solution.board[2][1].name = "B";
		solution.board[3][1].name = "C";
		
		queue.add(f.root);
	}
	
	public void findSolution()
	{
		Fringe.Node node = queue.poll();
		while(node.s.isFinal() == false)
		{
			f.expandNode(node);
			for(Fringe.Node child : node.children)
			{
				queue.add(child);
				nodeNumber++;
			}
			node = queue.poll();
			
			//clear the fringe since we don't need it
			f.Tree.clear();
		}
		node.s.display();
		System.out.println("A*: node " + nodeNumber + " found at depth " + node.depth);
	}
	
	public void displaySolution()
	{
		
	}
	
	public int calcManDis(State state)
	{
		int a = 0;
		int b = 0;
		int c = 0;
		
		a = Math.abs((state.find("A").col) - solution.find("A").col) + Math.abs((state.find("A").row) - solution.find("A").row);
		b = Math.abs((state.find("B").col) - solution.find("A").col) + Math.abs((state.find("B").row) - solution.find("B").row);
		c = Math.abs((state.find("C").col) - solution.find("C").col) + Math.abs((state.find("C").row) - solution.find("C").row);
		
		return (a + b + c);
	}
	
	public class NodeComparator implements Comparator<Fringe.Node>
	{
		public int compare(Fringe.Node n1, Fringe.Node n2)
		{
			int dis1 = n1.depth + calcManDis(n1.s);
			int dis2 = n2.depth + calcManDis(n2.s);
			
			if(dis1 < dis2)
			{
				return -1;
			}
			else if (dis1 > dis2)
			{
				return 1;
			}
			return 0;
		}
	}
}
