package com.halfbit;

import java.awt.Image;

public class Frame {
	private String filename;
	private Image image;
	private int xOffset;
	private int yOffset;
	
	public Frame(String filename, int xOffset, int yOffset) {
		this.filename = filename;
		this.image = ImageCache.getInstance().getImage(filename);
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public String getFilename() {
		return filename;
	}

	public int getXOffset() {
		return xOffset;
	}

	public int getYOffset() {
		return yOffset;
	}

	public Image getImage() {
		return image;
	}
}
