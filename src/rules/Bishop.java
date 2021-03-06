package rules;

import gui.BoardSquare;
import gui.ChessPiece;
import gui.Position;

public class Bishop extends Rules implements RulesInterface {

	//Sjekker om Bishop gj�r et lovlig trekk. Returner true hvis trekket er lovlig, og false hvis den er ulovlig. 
	public boolean isLegalMove(BoardSquare[][] board, ChessPiece piece, Position from, Position to) {
		b = board;
		int fromX = from.getX();
		int fromY = from.getY();
		int toX = to.getX();
		int toY = to.getY();
		int xMove = Math.abs(fromX - toX);
		int yMove = Math.abs(fromY - toY);
		String direction = null;
		
		if (xMove == yMove) { //Sjekker om du g�r skr�tt
			
			if (fromX < toX && fromY < toY) { // Sjekker om du g�r opp mot h�yre
				direction = "upRight";
				
				if (canIMovePieceDiagonal(fromX, fromY, toX, toY, xMove, direction) == false) { 
					return false;
				}
				
			}
			
			if (fromX > toX && fromY < toY) { // Sjekker om du g�r opp mot venstre
				direction = "upLeft";
				
				if (canIMovePieceDiagonal(fromX, fromY, toX, toY, xMove, direction) == false) { 
					return false;
				}
				
			}
			
			if (fromX < toX && fromY > toY) { // Sjekker om du g�r ned mot h�yre
				direction = "downRight";
				
				if (canIMovePieceDiagonal(fromX, fromY, toX, toY, xMove, direction) == false) { 
					return false;
				}
				
			}
			
			if (fromX > toX && fromY > toY) { // Sjekker om du g�r ned mot venstre
				direction = "downLeft";
				
				if (canIMovePieceDiagonal(fromX, fromY, toX, toY, xMove, direction) == false) { 
					return false;
				}
				
			}
			
			return true;
		}
		
		return false;
	}

	//Metode som sjekker at Bishop brikken ikke passerer noen andre brikker og hopper over de. 
	private boolean canIMovePieceDiagonal(int fromX, int fromY, int toX, int toY, int squaresMoved, String direction) {
		
		for (int i = 0; i < squaresMoved; i++) { 
			String movedDirection = direction;
			int[] previousBoxX = new int[8];
			int[] previousBoxY = new int[8]; 
			BoardSquare square; 
			
			switch (movedDirection) {
			case "upRight":
				previousBoxX[i] = toX - (i + 1);
				previousBoxY[i] = toY - (i + 1);
				break;
			case "upLeft":
				previousBoxX[i] = toX + (i + 1);
				previousBoxY[i] = toY - (i + 1);
				break;
			case "downRight":
				previousBoxX[i] = toX - (i + 1);
				previousBoxY[i] = toY + (i + 1);
				break;
			case "downLeft":
				previousBoxX[i] = toX + (i + 1);
				previousBoxY[i] = toY + (i + 1);
				break;
			}
			
			if (previousBoxX[i] != fromX && previousBoxY[i] != fromY) { 
				square = getSquareAt(new Position(previousBoxX[i], previousBoxY[i])); 
				
				if (square.hasChild()) {	
					System.out.println("hasChild ble bes�kt");
					return false; 
				}
				
			}
			
		}

		return true; 
	}
	
}