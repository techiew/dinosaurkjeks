package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

enum pieceType {
	PAWN,
	ROOK,
	KNIGHT,
	BISHOP,
	QUEEN,
	KING
};

public class ChessPiece extends JLabel {
		
	private pieceType type;
	private String color;
	private ImageIcon image;
	
	public ChessPiece(pieceType type, String color) {
		this.type = type;
		this.color = color;
		this.setVisible(true);
		String imgSrc = "";
		
		switch(type) {
		case PAWN:
			imgSrc = (color == "white") ? imgSrc = "white_pawn.png" : "black_pawn.png";
			break;
		case ROOK:
			imgSrc = (color == "white") ? imgSrc = "white_rook.png" : "black_rook.png";
			break;
		case KNIGHT:
			imgSrc = (color == "white") ? imgSrc = "white_knight.png" : "black_knight.png";
			break;
		case BISHOP:
			imgSrc = (color == "white") ? imgSrc = "white_bishop.png" : "black_bishop.png";
			break;
		case QUEEN:
			imgSrc = (color == "white") ? imgSrc = "white_queen.png" : "black_queen.png";
			break;
		case KING:
			imgSrc = (color == "white") ? imgSrc = "white_king.png" : "black_king.png";
			break;
		}
		
		image = new ImageIcon(imgSrc);
		ImageIcon scaledImageIcon = new ImageIcon(image.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
		this.setIcon(scaledImageIcon);
	}
	
	public pieceType getType() {
		return type;
	}
	
	public String getColor() {
		return color;
	}
	
}
