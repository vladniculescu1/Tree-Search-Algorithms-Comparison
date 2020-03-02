public class Main
{
	public static void main(String[] args)
	{
		BreadthFirstSearch b = new BreadthFirstSearch();
		DepthFirstSearch d = new DepthFirstSearch();
		IterativeDeepeningSearch i = new IterativeDeepeningSearch();
		AStar a = new AStar();
		
		d.findSolution();
		b.findSolution();	
		i.findSolution();
		a.findSolution();
	}
}
