public class State 
{
	//the board of the game
	Tile[][] board;
	int size;
	
	//the state the board is in
	public State(int n)
	{
		size = n;
		//initialised with the starting position
		board = new Tile[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				board[i][j] = new Tile("/",i,j);

		board[n-1][0].name = "A";
		board[n-1][1].name = "B";
		board[n-1][2].name = "C";
		board[n-1][3].name = ":)";
	}
	
	public boolean isFinal()
	{

		if(board[1][1].name != "A")
			return false;
		if(board[2][1].name != "B")
			return false;
		if(board[3][1].name != "C")
			return false;
		return true;
	}
	
	public class Tile
	{
		//Coordinates
		int row,col;
		public String name;
		
		public Tile(String name,int i, int j)
		{
			this.name = name;
			row = i;
			col = j;
		}
	}
	
	//find the coordinates of a tile
	public Tile find(String name)
	{
		for(int i = 0; i < board.length; i++)
			for(int j = 0; j < board.length; j++)
				if(board[i][j].name.equals(name))
				{
					return board[i][j];
				}
		return null;
	}
	
	//moving the agent
	public int move(String direction)
	{
		int n = board.length;
		Tile agent,aux;
		agent = this.find(":)");
		
		//move right
		if(direction.equals("right"))
		{
			if(agent.col == n-1)
			{
				return -1;
			}
			else
			{
				aux = agent;
				agent = board[agent.row][agent.col + 1];
				board[agent.row][agent.col - 1] = aux;
				board[agent.row][agent.col - 1].name = agent.name;
				agent.name = ":)";
				aux = null;			
				return 0;
			}
		}
		//move left
		else if(direction.equals("left"))
		{
			if(agent.col == 0)
			{
				return -1;
			}
			else
			{
				aux = agent;
				agent = board[agent.row][agent.col - 1];
				board[agent.row][agent.col + 1] = aux;
				board[agent.row][agent.col + 1].name = agent.name;
				agent.name = ":)";
				aux = null;		
				return 0;
			}
		}
		//move up
		else if(direction.equals("up"))
		{
			if(agent.row == 0)
			{
				return -1;
			}
			else
			{
				aux = agent;
				agent = board[agent.row - 1][agent.col];
				board[agent.row + 1][agent.col] = aux;
				board[agent.row + 1][agent.col].name = agent.name;
				agent.name = ":)";
				aux = null;		
				return 0;
			}
		}
		//move down
		else if(direction.equals("down"))
		{
			if(agent.row == n-1)
			{
				return -1;
			}
			else
			{
				aux = agent;
				agent = board[agent.row + 1][agent.col];
				board[agent.row - 1][agent.col] = aux;
				board[agent.row - 1][agent.col].name = agent.name;
				agent.name = ":)";
				aux = null;		
				return 0;
			}
		}
		else
		{
			return -1;
		}
		
	}
	
	//display the current state
	public void display()
	{
		for(int i = 0; i < this.board.length; i++)
		{
			for(int j = 0; j< this.board.length; j++)
				System.out.print(this.board[i][j].name + " ");
			System.out.println();
		}
		System.out.println();
	}
}
