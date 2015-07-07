package com.halfbit;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

public class MessageRender {
	Image tilesImg;
	int [][] lowerText;
	Dimension tileDimension;
	int spacer;
	int tilesPerRow;
	int roomWidth;
	int roomHeight;
	
	public MessageRender(String tileImageFilename, Dimension tileDimension, int spacer, int tilesPerRow, int[][] tiles){
		lowerText = tiles;
		roomWidth = tileDimension.width*2*tiles[0].length;
		roomHeight = tileDimension.height*2*tiles.length;
		tilesImg = ImageLoader.loadImage(tileImageFilename);
		this.tileDimension = tileDimension;
		this.spacer = spacer;
		this.tilesPerRow = tilesPerRow;
	}
	
	public Point getCoordinates(int tileIndex) {
		int row = tileIndex/tilesPerRow;
		int column = tileIndex%tilesPerRow;
		int x = column*(tileDimension.width+spacer);
		int y = row*(tileDimension.height+spacer);
		return new Point(x,y);
	}
	
	public void drawMessage(Graphics2D g, Point offset) {
		int destTileWidth = tileDimension.width*2;
		int destTileHeight = tileDimension.height*2;
		for (int row = 0; row < lowerText.length; row++){
			int destY = (destTileHeight*row) + offset.y;
			for (int column = 0; column < lowerText[row].length; column++) {
				Point point = getCoordinates(lowerText[row][column]);
				int destX = (destTileWidth*column) + offset.x;
				g.drawImage(tilesImg, destX, destY,	destX+destTileWidth, destY+destTileHeight, 
					point.x, point.y, point.x+tileDimension.width, point.y+tileDimension.height,
					null);
			}
		}
	}
}
