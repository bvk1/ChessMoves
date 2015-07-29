import java.util.*;

public class Piece{
  
  protected String position;
  protected char typeOfPiece;
  protected boolean isKilled;
  protected char colourOfPiece;
  
  Piece(String position,char color){
  position = position;
  isKilled = false;
  colourOfPiece = color;
  typeOfPiece = getType(position);
  
  }
  private String getType(String position){
	  if(isUpperCase(position.charAt(0)) == false)
		  typeOfPiece = "pawn";
	  else{
		  typeOfPiece = position.charAt(0);
	  }
  }
  protected void setPosition(String position){}
  protected boolean canMoveTo(String position){}
  
  protected String getPosition(){
	  return position;
  }
  
  public void displayinfo(){
	  System.out.println(isKilled + " " + typeOfPiece + " " + position);
  }
  
  public static void main(String [] args)throws IOException{
	  
	  Piece obj = new Piece("Ke4",'B');
	  obj.displayinfo();
  }
  }
