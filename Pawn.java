public class Bishop extends Piece
{
	public King(String position, char color)
	{
		super(position, color);
	}
	
	public void canMoveTo(String position)
	{
		char row = newPosition[1];
		char col = newPosition[0];
		char currentRow = this.position.charAt(position.length - 1 );
		char currentCol = this.position.charAt(position.length - 2 );

			}
}
