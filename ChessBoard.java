import java.util.*;

public class ChessBoard{
  
  private Piece[] whitePieces = new Piece[16];
  private Piece[] blackPieces = new Piece[16];
  
  private static final int MOVE = 0;
  private static final int KILLING_MOVE = 1;
  private static final int PREFERENCE_MOVE = 2;
  private static final int CASTLING = 3;
  
  Chessboard() {
    whitePieces[0] = new King("", 'W');
    whitePieces[1] = new Queen("", 'W');
    whitePieces[2] = new Rook("", 'W');
    whitePieces[3] = new Rook("", 'W');
    whitePieces[4] = new Bishop("", 'W');
    whitePieces[5] = new Bishop("", 'W');
    whitePieces[6] = new Knight("", 'W');
    whitePieces[7] = new Knight("", 'W');
    for(int i=8; i<16; i++) {
      whitePieces[i] = newPawn("", 'W');
    }
    blackPieces[0] = new King("", 'B');
    blackPieces[1] = new Queen("", 'B');
    blackPieces[2] = new Rook("", 'B');
    blackPieces[3] = new Rook("", 'B');
    blackPieces[4] = new Bishop("", 'B');
    blackPieces[5] = new Bishop("", 'B');
    blackPieces[6] = new Knight("", 'B');
    blackPieces[7] = new Knight("", 'B');
    for(int i=8; i<16; i++) {
      blackPieces[i] = newPawn("", 'B');
    }
  }
  
  public void chessMove(String pieceType, String move, char color)
  {
	 char pos = '';
	 if (color == 'B')
	 {
		for (int piece = 0; piece < 16; piece++)
		{
			if (blackPieces[piece].getType() == pieceType && !blackPieces[piece].isKilled())
			{
				switch (classifyMove(move))
				{
					case MOVE : 			blackPieces[piece].setPosition(move); 
											return;
					case KILLING_MOVE :
											move = move.substring(1);
											blackPieces[piece].setPosition(move);
										
											for (int whitePiece = 16; whitePiece < 32; whitePiece++)
											{
												if (whitePieces[piece].getPosition().equals(move))
												{
													whitePieces[piece].kill(true);
												}
											}
											return;
					case PREFERENCE_MOVE :
										
											pos = move.charAt(0);
											if (blackPieces[piece].getPosition().charAt(0) == pos)
											{
												move = move.substring(1);
												blackPieces[piece].setPosition(move);
											}else
											{
												continue;
											}
											return;
					case CASTLING : 		return;
				}
			}
		}
	 }else
	 {
		for (int piece = 0; piece < 16; piece++)
		{
			if (blackPieces[piece].getType() == pieceType && !blackPieces[piece].isKilled())
			{
				switch (classifyMove(move))
				{
					case MOVE : 			blackPieces[piece].setPosition(move); 
											return;
					case KILLING_MOVE :
											move = move.substring(1);
											blackPieces[piece].setPosition(move);
										
											for (int whitePiece = 16; whitePiece < 32; whitePiece++)
											{
												if (whitePieces[piece].getPosition().equals(move))
												{
													whitePieces[piece].kill(true);
												}
											}
											return;
					case PREFERENCE_MOVE :
										
											pos = move.charAt(0);
											if (blackPieces[piece].getPosition().charAt(0) == pos)
											{
												move = move.substring(1);
												blackPieces[piece].setPosition(move);
											}else
											{
												continue;
											}
											return;
					case CASTLING : 		return;
				}
			}
		}	
	 }
  }  
  
  private int classifyMove(String moves)
  {
  
	if (moves.length() == 2)
	{
		return MOVE;
	}
	if (moves.charAt(0) == 'x')
	{
		return KILLING_MOVE;
	}
	if (moves.charAt(0) >= 'a' && moves.charAt(0) =< 'h')
	{
		return  PREFERENCE_MOVE;
	}
	if (moves.charAt(0) == 'o')
	{
		return CASTLING;
	}
  }
}
