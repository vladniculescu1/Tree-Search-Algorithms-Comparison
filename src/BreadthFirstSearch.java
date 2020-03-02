import java.util.ArrayList;

public class BreadthFirstSearch {

	Fringe f = new Fringe();
	int j = 0;
	
	public void findSolution()
	{
		for(int i=0; i < f.Tree.size();i++)
		{
			Fringe.Node it = f.Tree.get(i);
			
			if(it.s.isFinal() != true)
			{
				f.expandNode(it);
			}
			else
			{
				j = i;
				break;
			}
		}
		
		f.Tree.get(j).s.display();
		System.out.println("BFS: node " + f.Tree.size()  + " at depth " + f.Tree.get(j).depth + "\n");
		
	}
	
	public void displaySolution()
	{
		ArrayList<Fringe.Node> solution = new ArrayList<Fringe.Node>();
		Fringe.Node n = f.Tree.get(j);
		while(n.depth != 0)
		{
			solution.add(n);
			n = n.parent;
		}
		f.root.s.display();
		for(int i = solution.size() - 1; i >=0 ; i--)
		{
			solution.get(i).s.display();
		}
	}
}
