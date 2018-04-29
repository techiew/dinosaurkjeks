package rules;

import gui.Position;
import gui.BoardSquare;
import gui.ChessPiece;

public class Pawn extends Rules implements RulesInterface {
	
	public boolean isLegalMove(BoardSquare[][] board, ChessPiece piece, Position from, Position to) {
		b = board;
		
		boolean firstMove = piece.isFirstMove();
		
		if(from.getX() == to.getX()) {
			
			if(getSquareAt(to).hasChild()) {
				return false;
			}
			
		}
		
		if(from.getX() + 1 == to.getX() || from.getX() - 1 == to.getX()) {
			
			if(!getSquareAt(to).hasChild()) {
				return false;
			}
			
		}
		
		if(!inRange(from.getX(), to.getX(), 1)) {
			return false;
		}
		
		if(piece.getDirection() == "up") {
			
			if(firstMove) {
				
				if(from.getY() + 1 != to.getY() && from.getY() + 2 != to.getY()) {
					return false;
				}
				
			} else if(from.getY() + 1 != to.getY()) {
				return false;
			}
			
			
		} else if(piece.getDirection() == "down") {
			
			if(firstMove) {
				
				if(from.getY() - 1 != to.getY() && from.getY() - 2 != to.getY()) {
					return false;
				}
				
			} else if(from.getY() - 1 != to.getY()) {
				return false;
			}
			
		}
		
		return true;
	}
	
}