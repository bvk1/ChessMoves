public class Pawn extends Piece
{
	public Pawn(String position, char color)
	{
		super(position, color);
	}
	
	public void canMoveTo(String position)
	{
		char row = newPosition[1];
		char col = newPosition[0];
		char currentRow = this.position.charAt(position.length - 1 );
		char currentCol = this.position.charAt(position.length - 2 );
		if(row - '1' == currentRow && col == currentCol) return true;
		else if((row - '1' == currentRow && col - '1' == currentCol) return true;
			else if((row - '1' == currentRow && col + '1' == currentCol)) reurn true;

		return false;

			}
}
