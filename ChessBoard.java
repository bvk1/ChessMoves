mport java.util.*;

public class ChessBoard{
  
  private Piece[] whitePieces = new Piece[16];
  private Piece[] blackPieces = new Piece[16];
  
  private static final int MOVE = 0;
  private static final int KILLING_MOVE = 1;
  private static final int PREFERENCE_MOVE = 2;
  private static final int CASTLING = 3;
  
  public ChessBoard() {
    whitePieces[0] = new Piece("Ra1");
    whitePieces[1] = new Piece("Nb1");
    whitePieces[2] = new Piece("Bc1");
    whitePieces[3] = new Piece("Qd1");
    whitePieces[4] = new Piece("Ke1");
    whitePieces[5] = new Piece("Bf1");
    whitePieces[6] = new Piece("Ng1");
    whitePieces[7] = new Piece("Rh1");
	whitePieces[8] = new Piece("a2");
	whitePieces[9] = new Piece("b2");
	whitePieces[10] = new Piece("c2");
	whitePieces[11] = new Piece("d2");
	whitePieces[12] = new Piece("e2");
	whitePieces[13] = new Piece("f2");
	whitePieces[14] = new Piece("g2");
	whitePieces[15] = new Piece("h2");
   
	
    blackPieces[0] = new Piece("Ra8");
    blackPieces[1] = new Piece("Nb8");
    blackPieces[2] = new Piece("Bc8");
    blackPieces[3] = new Piece("Kd8");
    blackPieces[4] = new Piece("Qe8");
    blackPieces[5] = new Piece("Bf8");
    blackPieces[6] = new Piece("Ng8");
    blackPieces[7] = new Piece("Rh8");
    blackPieces[8] = new Piece("a7");
    blackPieces[9] = new Piece("b7");
    blackPieces[10] = new Piece("c7");
    blackPieces[11] = new Piece("d7");
    blackPieces[12] = new Piece("e7");
    blackPieces[13] = new Piece("f7");
    blackPieces[14] = new Piece("g7");
    blackPieces[15] = new Piece("h7");
   
  }
  
  public void chessMove(String pieceType, String move, char color)
  {
	 String pos = "";
	 if (color == 'B')
	 {
		for (int piece = 0; piece < 16; piece++)
		{
			if (blackPieces[piece].getType().equals(pieceType) && !blackPieces[piece].isKilled())
			{
				switch (classifyMove(move))
				{
					case MOVE : 			blackPieces[piece].setPosition(move); 
											return;
					case KILLING_MOVE :
											if (move.charAt(0) == 'x')
												move = move.substring(1);
											else
												move = move.substring(2);
												
											blackPieces[piece].setPosition(move);
										
											for (int whitePiece = 0; whitePiece < 16; whitePiece++)
											{
												if (whitePieces[whitePiece].getPosition().equals(move))
												{
													whitePieces[whitePiece].kill(true);
												}
											}
											return;
					case PREFERENCE_MOVE :
										
											if (move.length() == 3)
											{
												pos += move.charAt(0);
												move = move.substring(1);
											}else if (move.length() == 4)
											{
												pos += move.substring(0,2);
												move = move.substring(2);
											}
											
											if (blackPieces[piece].getPosition().equals(pos))
											{
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
			if (whitePieces[piece].getType() == pieceType && !whitePieces[piece].isKilled())
			{
				switch (classifyMove(move))
				{
					case MOVE : 			whitePieces[piece].setPosition(move); 
											return;
					case KILLING_MOVE :
											if (move.charAt(0) == 'x')
												move = move.substring(1);
											else
												move = move.substring(2);
											
											whitePieces[piece].setPosition(move);
										
											for (int blackPiece = 0; blackPiece < 16; blackPiece++)
											{
												if (blackPieces[blackPiece].getPosition().equals(move))
												{
													blackPieces[blackPiece].kill(true);
												}
											}
											return;
					case PREFERENCE_MOVE :
										
											if (move.length() == 3)
											{
												pos += move.charAt(0);
												move = move.substring(1);
											}else if (move.length() == 4)
											{
												pos += move.substring(0,2);
												move = move.substring(2);
											}
											
											if (whitePieces[piece].getPosition().equals(pos))
											{
												whitePieces[piece].setPosition(move);
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
	
	if (moves.charAt(0) == 'x' || moves.charAt(1) == 'x')
	{
		return KILLING_MOVE;
	}
	
	if (moves.charAt(0) >= 'a' && moves.charAt(0) <= 'h')
	{
		return  PREFERENCE_MOVE;
	}
	
	if (moves.charAt(0) == 'o')
	{
		return CASTLING;
	}
	return -1;
  }
  
  public static void main(String[] arg)
  {
	ChessBoard chess = new ChessBoard();
	chess.makeMove('K','e4','B');
  
  }
  
}
