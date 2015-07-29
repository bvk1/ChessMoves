import java.util.*;

public class Piece{
  
  protected String position;
  protected char type;
  protected boolean isKilled;
  protected char colourOfPiece;
  
  Piece(String position,char color){
  position = position;
  isKilled = false;
  colourOfPiece = color;
  
  }
  protected void moveTo(String position){}
  protected boolean canMoveTo(String position){}
  
  protected String getPosition(){
	  return position;
  }
  }
