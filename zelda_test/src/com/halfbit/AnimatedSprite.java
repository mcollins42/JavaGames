package com.halfbit;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

public class AnimatedSprite {
	private int framesPerSecond;
	private long lastUpdated;
	private int currentimage;
	private Frame[] frames;
	public Dimension imageSize;

	public AnimatedSprite(int framesPerSecond) {
		this.framesPerSecond = framesPerSecond;
		this.imageSize = new Dimension(52,64);
	}
	
	protected void setFrames(Frame[] frames) {
		this.frames = frames;
		lastUpdated = System.nanoTime();
	}
	
	public void imageTransition() {
	   	long now = System.nanoTime();
	   	long updatePeriod = 1000000000 / framesPerSecond;
    	if (Math.abs(now - lastUpdated) > updatePeriod) {
    		currentimage = (currentimage+1) % frames.length;
    		lastUpdated = now;
    	}
	}
	
	public void draw(Graphics2D g2D, Point position){
		Frame currentFrame = frames[currentimage]; 
		g2D.drawImage(currentFrame.getImage(), 
				position.x - currentFrame.getXOffset(), 
				position.y - currentFrame.getYOffset(), 
				imageSize.width, imageSize.height, null);
	}
	
	public Frame getStandingFrame() {
		return frames[0];
	}
}
