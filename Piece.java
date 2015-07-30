import java.util.*;

public class Piece{
  
  protected String position = "";
  protected String typeOfPiece = "";
  protected boolean isKilled;
  
  
  Piece(String position){
	extractType(position);
	this.position = position;
	isKilled = false;
	position = position.substring(position.length() - 2);
  }

  protected boolean setPosition(String position){
	  if (canMoveTo(position))
	  {
			this.position = position;
			return true;
	  }
	  return false;
  }
  
  protected boolean canMoveTo(String nposition){
  
		if (this.typeOfPiece.equals("P"))
		{
			char alpha[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
			int row = Integer.parseInt("" + nposition.charAt(1));
			char col = nposition.charAt(0);
		
			int currentRow = Integer.parseInt("" + this.position.charAt(1)); 
			char currentCol = this.position.charAt(0); 
		
			if(currentRow + 1 == row && currentCol == col) return true;
			if(current - 1 == row && currentCol == col) return true;
		
		
			if(currentRow + 1 == row && Arrays.indexOf(alpha,currentCol) + 1 == Arrays.indexOf(alpha,col)) return true;
			if(currentRow + 1 == row && Arrays.indexOf(alpha,currentCol) - 1 == Arrays.indexOf(alpha,col)) return true;
		
			return false;
		}
		if (this.typeOfPiece.equals("R"))
		{
			
		
		}
		
		if (this.typeOfPiece.equals("N"))
		{
		
		
		
		
		}
		if (this.typeOfPiece.equals("B"))
		{
		
	
		}
	}

  protected boolean isKilled()
  {
	return isKilled;
  }
  
  protected boolean kill(boolean isKilled)
  {
	this.isKilled = isKilled;
	return isKilled;
  }
  
  private void extractType(String position){
	  if(Character.isUpperCase(position.charAt(0)) == false)
		  typeOfPiece = "P";
	  else{
		  typeOfPiece += position.charAt(0);
	  }
  }
  
  
  protected String getType()
  {
	return typeOfPiece;
  }
  
  protected String getPosition(){
	  return position;
  }
  
}
