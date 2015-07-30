import java.util.*;

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
    blackPieces[3] = new Piece("Qd8");
    blackPieces[4] = new Piece("Ke8");
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
	 String tmpMov = "";
	 
	 if (color == 'B')
	 {
		for (int piece = 0; piece < 16; piece++)
		{
			if (blackPieces[piece].getType().equals(pieceType) && !blackPieces[piece].isKilled())
			{
				switch (classifyMove(move))
				{
					case MOVE : 			
											System.out.println("BLACK OLD POSITION :" + blackPieces[piece].getPosition()); 
											if (blackPieces[piece].setPosition(move)) 
											{
												System.out.println("MOVE");
												System.out.println("BLACK NEW POSITION :" + blackPieces[piece].getPosition());												
												return ;	
											}else
											{
												continue;
											}
									
					case KILLING_MOVE :
											pos = "";
											tmpMov = "";
											if (move.charAt(0) == 'x')
											{
												 tmpMov = move.substring(1);
											}else
											{
												pos += move.charAt(0);
												tmpMov = move.substring(2);
											}
											
											//for exD4 type
											if (!pos.equals("") && blackPieces[piece].getPosition().charAt(0) == pos.charAt(0))
											{
											
												System.out.println("OLD POSITION :" + blackPieces[piece].getPosition());
												if (blackPieces[piece].setPosition(tmpMov))
												{
													for (int whitePiece = 0; whitePiece < 16; whitePiece++)
													{
														if (whitePieces[whitePiece].getPosition().equals(move))
														{
															whitePieces[whitePiece].kill(true);
														}
													}
													System.out.println("KILLING_MOVE_XD");
													System.out.println("NEW POSITION :" + blackPieces[piece].getPosition());
													return;
												}
											}
					
											// for xD4 type
											System.out.println("OLD POSITION :" + blackPieces[piece].getPosition());
											if (blackPieces[piece].setPosition(tmpMov))
											{
												for (int whitePiece = 0; whitePiece < 16; whitePiece++)
												{
													if (blackPieces[whitePiece].getPosition().equals(move))
													{
														blackPieces[whitePiece].kill(true);
													}
												}
												System.out.println("KILLING_MOVE");
												System.out.println("NEW POSITION :" + whitePieces[piece].getPosition());
												return;
											}
											else
											{
												continue;
											}
											
											
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
											System.out.println("PREFERENCE_MOVE");
											return;
					case CASTLING : 		System.out.println("CASTLING");
											return;
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
					case MOVE : 			System.out.println("WHITE OLD POSITION :" + whitePieces[piece].getPosition());
											if (whitePieces[piece].setPosition(move)) 
											{
												System.out.println("MOVE");
												System.out.println("WHITE NEW POSITION :" + whitePieces[piece].getPosition());												
												return ;	
											}else
											{
												continue;
											}											
					case KILLING_MOVE :		pos = "";
											tmpMov = "";
											if (move.charAt(0) == 'x')
											{
												 tmpMov = move.substring(1);
											}else
											{
												pos += move.charAt(0);
												tmpMov = move.substring(2);
											}
											
											//for exD4 type
											if (!pos.equals("") && whitePieces[piece].getPosition().charAt(0) == pos.charAt(0))
											{
											
												System.out.println("OLD POSITION :" + whitePieces[piece].getPosition());
												if (whitePieces[piece].setPosition(tmpMov))
												{
													for (int blackPiece = 0; blackPiece < 16; blackPiece++)
													{
														if (blackPieces[blackPiece].getPosition().equals(move))
														{
															blackPieces[blackPiece].kill(true);
														}
													}
													System.out.println("KILLING_MOVE_XD");
													System.out.println("NEW POSITION :" + whitePieces[piece].getPosition());
													return;
												}
											}
					
											// for xD4 type
											System.out.println("OLD POSITION :" + whitePieces[piece].getPosition());
											if (whitePieces[piece].setPosition(tmpMov))
											{
												for (int blackPiece = 0; blackPiece < 16; blackPiece++)
												{
													if (blackPieces[blackPiece].getPosition().equals(move))
													{
														blackPieces[blackPiece].kill(true);
													}
												}
												System.out.println("KILLING_MOVE");
												System.out.println("NEW POSITION :" + whitePieces[piece].getPosition());
												return;
											}
											else
											{
												continue;
											}
											
											
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
											System.out.println("PREFERENCE_MOVE");
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
	chess.chessMove("P","c4",'W');
	chess.chessMove("P","d6",'B');
	chess.chessMove("P","e4",'W');
	chess.chessMove("P","d5", 'B');
	chess.chessMove("P", "cxd5", 'W');
	
	
	System.out.println("Done!");
  }
  
}
