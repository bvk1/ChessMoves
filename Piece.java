import java.util.*;

public class Piece{
  
  protected String position;
  protected char typeOfPiece;
  protected boolean isKilled;
  protected char colourOfPiece;
  
  Piece(String position,char color, String type){
	position = position;
	isKilled = false;
	colourOfPiece = color;
	typeOfPiece = type;
  }

  protected void setPosition(String position){
  
  }
  
  protected boolean canMoveTo(String position){
  
  }
  
  protected boolean getType()
  {
	return typeOfPiece;
  }
  
  protected String getPosition(){
	  return position;
  }
  
}
