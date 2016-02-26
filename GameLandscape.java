public class GameLandscape
{
	private static String[] player_Board;

	public GameLandscape()
	{
		player_Board = new String[TheGame.BOARD_SIZE];
	}

	public boolean isBoardFull()
	{
		for(int i=0; i<=player_Board.length-1;i=i+1)
		{
			if(player_Board[i].equals(" "))
				return false;
		}
		return true;
	}

	public boolean isSquareEmpty(int ruta)
	{
		if(!(ruta>=0 && ruta<=8))
		{
			System.out.println("Try a number between 1-9");
			return false;
		}
		else
		{
			if(player_Board[ruta].equals(" "))
				return true;
			else
				return false;
		}
	}

	public void fixNullBoard()
	{
		player_Board = new String[TheGame.BOARD_SIZE];
		
		for(int k=0;k<=player_Board.length-1;k=k+1)
		{
			if(player_Board[k]==null)
			{
				player_Board[k] = " ";
			}
		}
	}

	public void setBoardSpot(int index, String s)
	{
		player_Board[index] = s;
	}

	public boolean isThreeInRow(String str) 
	{
		if((player_Board[0]==str && player_Board[1]==str && player_Board[2]==str)||
		  (player_Board[3]==str && player_Board[4]==str && player_Board[5]==str) ||
		  (player_Board[6]==str && player_Board[7]==str && player_Board[8]==str) ||
		  (player_Board[0]==str && player_Board[3]==str && player_Board[6]==str) ||
		  (player_Board[1]==str && player_Board[4]==str && player_Board[7]==str) ||
		  (player_Board[2]==str && player_Board[5]==str && player_Board[8]==str) ||
          (player_Board[0]==str && player_Board[4]==str && player_Board[8]==str) ||
          (player_Board[2]==str && player_Board[4]==str && player_Board[6]==str))
			
			return true;
		else
			return false;
	}

	public void paintBoard()  
	{		
			String[] graph_Board =  {"   ","   ","   ","\n",
								" "+player_Board[0]+" |"," "+player_Board[1]+" | "," "+player_Board[2]+"|", "\n",
								"---+","---+","----", "\n",
								"---!","---!","---+", "\n",
		 						" "+player_Board[3]+" |"," "+player_Board[4]+" | "," "+player_Board[5]+"|", "\n",
		 						"---!","---!","---+", "\n",
		 						"---+","---+","----", "\n",
		  						" "+player_Board[6]+" |"," "+player_Board[7]+" | "," "+player_Board[8]+"|", "\n",
		  						"   ","   ","   ","\n"};
		  						
        for(int i=0;i<=graph_Board.length-1;i=i+1)
		{
			System.out.print(graph_Board[i]);
		}
	}

	public void paintScoreBoard(Player p1, Player p2)
	{
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Player1, namely:" + p1.getName() + " has score:	" + p1.getWinCount());
		System.out.println("Player2, namely:" + p2.getName() + " has score: " + p2.getWinCount());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
	}
}