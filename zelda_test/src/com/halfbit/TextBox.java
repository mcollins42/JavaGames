package com.halfbit;

import java.awt.Graphics2D;
import java.awt.Point;

public class TextBox {
	
	String text;
	int position;
	MessageRender messageRender;
	
	public TextBox(String text){
		this.text = text;
		position = 0;
		TextMessage msg = new TextMessage(text, position);
		messageRender = msg.getRenderer();
		position = msg.getPosition();
	}
	
	public void textScroll() {
		if(position < text.length()){
			TextMessage msg = new TextMessage(text, position);
			messageRender = msg.getRenderer();
			position = msg.getPosition();
		}
	}
		
	
	public void drawMessage(Graphics2D g, Point offset) {
		messageRender.drawMessage(g, offset);
	}
}
