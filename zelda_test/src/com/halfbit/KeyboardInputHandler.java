package com.halfbit;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardInputHandler extends KeyAdapter {
	public boolean waitingForKeyPress;

	/** True if the left cursor key is currently pressed */
	boolean leftPressed = false;
	/** True if the right cursor key is currently pressed */
	boolean rightPressed = false;
	/** True if the up cursor key is currently pressed */
	boolean upPressed = false;
	/** True if the down cursor key is currently pressed */
	boolean downPressed = false;
	/** True if the space bar is currently pressed */
	boolean spacePressed = false;

	/** The number of key presses we've had while waiting for an "any key" press */
	private int pressCount = 1;

	/**
	 * Notification from AWT that a key has been pressed. Note that
	 * a key being pressed is equal to being pushed down but *NOT*
	 * released. Thats where keyTyped() comes in.
	 *
	 * @param e The details of the key that was pressed 
	 */
	public void keyPressed(KeyEvent e) {
		// if we're waiting for an "any key" typed then we don't 
		// want to do anything with just a "press"
		if (waitingForKeyPress) {
			return;
		}

		System.out.println("key pressed! " + e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_A) {
			leftPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			rightPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			upPressed = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			downPressed = true;
		}
	} 

	/**
	 * Notification from AWT that a key has been released.
	 *
	 * @param e The details of the key that was released 
	 */
	public void keyReleased(KeyEvent e) {
		// if we're waiting for an "any key" typed then we don't 
		// want to do anything with just a "released"
		if (waitingForKeyPress) {
			return;
		}

		if (e.getKeyCode() == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			rightPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_W) {
			upPressed = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			downPressed = false;
		}
	}

	/**
	 * Notification from AWT that a key has been typed. Note that
	 * typing a key means to both press and then release it.
	 *
	 * @param e The details of the key that was typed. 
	 */
	public void keyTyped(KeyEvent e) {
		// if we hit escape, then quit the game
		if (e.getKeyChar() == 27) {
			System.exit(0);
		} else if (Character.isSpaceChar(e.getKeyChar())) {
			spacePressed = true;
		}
	}
}
