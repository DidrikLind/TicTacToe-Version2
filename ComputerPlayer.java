import java.util.Random;
public class ComputerPlayer extends Player
{
	
	public ComputerPlayer()
	{
		//
	}
//nytt, har ny tagit bort all "crap". Min idé med denna klass var mer än vad den är!
// jag ville ha mer specifika metoder i den!
	public ComputerPlayer(String objName, String playFigure) 
	{
		super(objName, playFigure);
		//Detta gör samma sak
		//setobjName(objName);
		//setplayFigure(playFigure); // eller kanske super(objName, playFigure)
	}


}