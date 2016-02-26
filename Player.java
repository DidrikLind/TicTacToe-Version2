public class Player
{
	private int winAmount;
	private String playerName, objName, playFigure;

	public Player()
	{
		winAmount = 0;
	}
	
	public Player(String objName, String playFigure)
	{
		this.objName = objName;
		this.playFigure = playFigure;
	}

	public String getName()
	{
		return playerName;
	}

	public void setName(String playerName)
	{
		this.playerName = playerName;
	}

	public String getobjName()
	{
		return objName;
	}
//nytt
	public void setobjName(String objName) 
	{
         this.objName = objName;
	}

	public String toString()
	{
		return getobjName();
	}

	public String getplayFigure()
	{
		return playFigure;
	}

	public void setplayFigure(String playFigure)
	{
		this.playFigure = playFigure;
	}

	public void addWinCount()
	{
		winAmount = winAmount + 1;
	}

	public int getWinCount()
	{
		return winAmount;
	}
}