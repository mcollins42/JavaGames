package com.halfbit;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

public class Room {
	Image tilesImg;
	int [][] houseTiles;
	int tileSize;
	int spacer;
	int tilesPerRow;
	int roomWidth;
	int roomHeight;
	
	public Room(String tileImageFilename, int tileSize, int spacer, int tilesPerRow, int[][] tiles){
		houseTiles = tiles;
		roomWidth = tileSize*2*(tiles[0].length/2);
		roomHeight = tileSize*2*tiles.length;
		tilesImg = ImageLoader.loadImage(tileImageFilename);
		this.tileSize = tileSize;
		this.spacer = spacer;
		this.tilesPerRow = tilesPerRow;
	}
	
	public Point getCoordinates(int row, int column) { 
		int x = column*(tileSize+spacer);
		int y = row*(tileSize+spacer);
		return new Point(x,y);
	}
	
	public void drawBackground(Graphics2D g, Point offset) {
		int destTileSize = tileSize*2;
		for (int row = 0; row < houseTiles.length; row++){
			int destY = (destTileSize*row) - offset.y;
			for (int column = 0; column < houseTiles[row].length; column+=2) {
				Point point = getCoordinates(houseTiles[row][column], houseTiles[row][column+1]);
				int destX = (destTileSize*(column/2)) - offset.x;
				g.drawImage(tilesImg, destX, destY,	destX+destTileSize, destY+destTileSize, 
					point.x, point.y, point.x+tileSize, point.y+tileSize, null);
			}
		}
	}
	
	public void setIsDay(boolean isNight) {
	}
	
	public void setTileImage(String tileImageFilename) {
		tilesImg = ImageLoader.loadImage(tileImageFilename);
	}
}
