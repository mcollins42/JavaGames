package com.halfbit;

public class MessageFormat {

	String textMessage;
	int position;
	int row;
	int column;
	int messageLength;

	public MessageFormat(String message, int position) {
		this.textMessage = message;
		this.position = position;
		this.column = 1;
	}

	public int [][] getMessageArray(){
		int [][] textBox = new int[2][17];
		for (int i = 0; i < textBox.length; i++) {
			for (int j = 0; j < textBox[0].length; j++) {
				textBox[i][j] = 26;
			}
		}
		while (position < textMessage.length()) {
			int nextSpace = textMessage.indexOf(' ', position);
			int numberOfCharacters;
			if(nextSpace >= 0){
				numberOfCharacters = nextSpace - position;
			} else {
				numberOfCharacters = textMessage.length() - position;
			}
			if(numberOfCharacters <= remainingSpace()){
				copyWord(textBox, numberOfCharacters);
			} else {
				if (row < 1){
					row =+ 1;
					column = 1;
				} else {
					return boxScrollable(textBox);
				}
				if (numberOfCharacters <= remainingSpace()){
					copyWord(textBox, numberOfCharacters);
				} else {
					return boxScrollable(textBox);
				}
			}
			if (remainingSpace() > 0) {
				textBox[row][column] = getTileNumber(' ');
				column++;				
			}
			position += numberOfCharacters + 1;
		}
		return textBox;
	}

	public int getPosition() {
		return position;
	}

	private int[][] boxScrollable(int[][] textBox){
		textBox[1][16] = 29;
		return textBox;
	}
	
	private void copyWord(int[][] textBox, int numberOfCharacters) {
		for(int i = 0; i < numberOfCharacters; i++) {
			char ch = textMessage.charAt(position + i);
			textBox[row][column] = getTileNumber(ch);
			column++;
		}
	}

	private int getTileNumber(char ch) {
		return (ch == ' ') ? 26 : ch - 'a';
	}
	private int remainingSpace(){
		return 16 - column;

	}

}
