import java.util.Random;

public class DepthFirstSearch {
	
	Fringe f = new Fringe();
	Random r = new Random();
	int nodeNumber = 1;
	
	public int findSolution()
	{
		
		Fringe.Node n = f.root;
		int pos = 0;
		int child = 0;
		int i = 0;
		
		while(n.s.isFinal() != true)
		{
			f.expandNode(n);
			for(Fringe.Node nodes : n.children)
			{
				nodeNumber++;
			}
			//we pick a random child
			child = r.nextInt((f.Tree.size() - pos - 2) + 1) + pos + 1;
			
			//we remove from the tree all children that were not picked for search
			i = pos + 1;
			while(i < child)
			{
				f.Tree.remove(i);
				child --;
			}
			i = child + 1;
			while(i <= (f.Tree.size() - 1))
			{
				f.Tree.remove(i);
			}
			//the child becomes the next parent
			n = f.Tree.get(child);
			pos = child;
		}
		f.Tree.get(f.Tree.size()-1).s.display();		
		System.out.println("DFS: node " + nodeNumber + " at depth " + f.Tree.get(f.Tree.size()-1).depth);
		return nodeNumber;
				
	}
}
