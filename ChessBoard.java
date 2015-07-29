import java.util.*;

public class ChessBoard{
  private Piece[] whitePieces = new Piece[16];
  private Piece[] blackPieces = new Piece[16];
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
}
