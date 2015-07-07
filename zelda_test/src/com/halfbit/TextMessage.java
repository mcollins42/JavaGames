package com.halfbit;

import java.awt.Dimension;

public class TextMessage {
	private String text;
	private int position;
	
	public TextMessage(String text, int position) {
		this.text = text;
		this.position = position;
	}
	
	MessageRender getRenderer() {
		MessageFormat formatter = new MessageFormat(text, position);
		int[][] textBox = formatter.getMessageArray();
		this.position = formatter.getPosition();
		return new MessageRender("Resources/Misc/LALowerCaseText.png", new Dimension(8, 16), 0, 6, textBox);
	}

	public int getPosition() {
		return position;
	}
}

