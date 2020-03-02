import java.util.ArrayList;

public class IterativeDeepeningSearch {
	
	Fringe f = new Fringe();
	Fringe.Node found;
	int nodeNumber = 0;
	
	public void findSolution()
	{
		for(int i=0; ;i++)
		{
			f.Tree.clear();
			f.Tree.add(f.root);
			found = DepthLimitedSearch(f.root,i);
			if(found != null)
			{
				found.s.display();
				System.out.println("IDS: node " + nodeNumber + " found at depth " +  found.depth + " with limit = " + i + "\n");
				break;
			}
		}
	}

	public Fringe.Node DepthLimitedSearch(Fringe.Node node, int limit)
	{
		nodeNumber++;
		if(limit == 0 && node.s.isFinal())
			return node;
		if(limit > 0)
		{
			f.expandNode(node);
			for(Fringe.Node child : node.children)
			{
				Fringe.Node result = DepthLimitedSearch(child, limit - 1);
				if(result != null)
				{
					return result;
				}
			}
		}
		return null;
	}
	
	public void displaySolution()
	{
		ArrayList<Fringe.Node> solution = new ArrayList<Fringe.Node>();
		Fringe.Node nodeAdded = found;
		while(nodeAdded.depth != 0)
		{
			solution.add(nodeAdded);
			nodeAdded = nodeAdded.parent;
		}
		f.root.s.display();
		for(int i = solution.size() -1; i >= 0; i--)
			solution.get(i).s.display();
	}
}
