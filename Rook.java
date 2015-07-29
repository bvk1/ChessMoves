public class Rook extends Piece
{	
	public Rook(String position, char color)
	{
		super(position, color, 'R');
	}
	
	public bool canMoveTo(string toPosition, final boolean[][] chessBoard) {
		String fromPosition = getPosition();
		if(fromPosition.charAt(0) == toPosition.charAt(0)) {
			for(int i = min(fromPosition.charAt(1),toPosition.charAt(1)) + 1; i <= max(fromPosition.charAt(1),toPosition.charAt(1)); i++) {
				if(chessBoard[8-(fromPosition.charAt(0)+'a')][i]) {
					return false;
				}
			}
		}
		if(fromPosition.charAt(1) == toPosition.charAt(1)) {
			for(int i = min(fromPosition.charAt(0),toPosition.charAt(0)) + 1; i <= max(fromPosition.charAt(0),toPosition.charAt(0)); i++) {
				if(chessBoard[i-'a'][toPosition.charAt(1)]) {
					return false;
				}
			}
		}
	}
}
