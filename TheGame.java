import java.util.Random;
public class TheGame
{
	final static int BOARD_SIZE = 9;
	private Player player1;
	private Player player2;
	private Player whichPlayer;
	//private Random rand;

	public TheGame()
	{
		//rand = new Random();
	}

	public void playGame()
	{
		boolean isPlaying = true, playAgain = true;
		int playerChoiceNum = 0, numOfGames = 0;; 
		String playerInput, againString;
		GameLandscape grid = new GameLandscape(); 
		
		while(playAgain)
		{	
			grid.fixNullBoard();
			grid.paintBoard(); 
			if(numOfGames>0) 
			{
				String newNamesOr = System.console().readLine("Do you want new names and reseted score?? If so, write *YES*");
				newNamesOr = newNamesOr.toLowerCase();
				if(newNamesOr.equals("yes"))
				{
					makePlayChoice();
				}
			}
			else
			{
				makePlayChoice();
			}

			whichPlayer = player1; // reference, pointing at object player1
			numOfGames++;
			while(isPlaying)
			{

				if(!grid.isBoardFull())
				{
					if(!(whichPlayer instanceof ComputerPlayer))
					{	
						playerInput = System.console().readLine("Player " + whichPlayer + " i.e "+  whichPlayer.getName()+
										  					 " which square between (1-" + BOARD_SIZE+")?:");
						try
						{
							playerChoiceNum = Integer.parseInt(playerInput) - 1;

						}
						catch(NumberFormatException e)
						{
							System.out.println("You did not write a number! TRY AGAIN");
							continue;
						}
					}
					else
					{
						playerChoiceNum = whichPlayer.getPCRandNum();
					}

					if(!grid.isSquareEmpty(playerChoiceNum)) 
					{
						if(!(whichPlayer instanceof ComputerPlayer))
						{
							System.out.println("This square was full, try another one!");
					    }
					    
						if(whichPlayer.getobjName().equals(player1.getobjName())) // if(player1)
				    	{
				    		whichPlayer = player1;
				    		continue;
				    	}
				    	else
				    	{
				    		whichPlayer = player2;
				    		continue;
						}
					}
				    else 
				    {
				    	grid.setBoardSpot(playerChoiceNum, whichPlayer.getplayFigure());
				    	grid.paintBoard();

				    	if((grid.isThreeInRow("X"))||
				    	   (grid.isThreeInRow("O"))) 
				    	{
				    		whichPlayer.addWinCount(); 
				    		System.out.println("Congratz," + whichPlayer + ", namely " + whichPlayer.getName() + " you have won ;)");
				    		isPlaying = false;
				    	}
				    	
				    }

				    if(whichPlayer.getobjName().equals(player1.getobjName()))
				    {
				    	whichPlayer = player2;
				    }
				    else
				    {
				    	whichPlayer = player1;
					}
				}
				else//FULLT BRÄDE
				{
					if((grid.isThreeInRow("X"))|| 
				       (grid.isThreeInRow("O")))
			    	{
			    		whichPlayer.addWinCount();
			    		System.out.println("Congratz, " + whichPlayer + ", namely " + whichPlayer.getName() + " you have won ;)");
			    		isPlaying = false;
			    		//break;
				    }
					else
					{
						System.out.println("Its a draw!!!  ;)");
				    	isPlaying = false;
				    	//break;
					}
				}
			}

			grid.paintScoreBoard(player1, player2);
			againString = System.console().readLine("Do you want to play again? If so write *YES*, otherwise something arbitary:	");
			againString = againString.toLowerCase(); 
			if(againString.equals("yes"))
			{
				isPlaying = true;
			}
			else
			{
				playAgain = false;
				System.out.println("Thanks for playing, bye ;)");
			}
		}
		
	}

	public void makePlayChoice()
	{
		String inputChoice1, inputChoice2;
			
		inputChoice1 = System.console().readLine("Name for player1"+": (write *computer* if you want the computer as the player):");
		if(inputChoice1.equals("computer"))
		{
			player1 = new ComputerPlayer("computer", "X");
			whichPlayer = player1;
			whichPlayer.setName(inputChoice1);
		}
		else
		{
			player1 = new Player("player1", "X");
			whichPlayer = player1;
			whichPlayer.setName(inputChoice1);
		}

		inputChoice2 = System.console().readLine("Name for player2"+": (write *computer* if you want the computer as the player):");
		if(inputChoice2.equals("computer"))
		{
			player2 = new ComputerPlayer("computer", "O");
			whichPlayer = player2;
			whichPlayer.setName(inputChoice2);
		}
		else
		{
			player2 = new Player("player2", "O");
			whichPlayer = player2;
			whichPlayer.setName(inputChoice2);
		}
    }
}