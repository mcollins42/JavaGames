package com.halfbit;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

public class MouseHandler extends MouseInputAdapter {
	private boolean leftClicked = false;
	private boolean rightClicked = false;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		super.mouseClicked(e);
		if (SwingUtilities.isLeftMouseButton(e)) {
			leftClicked = true;
		} else if (SwingUtilities.isRightMouseButton(e)) {
			rightClicked = true;
		}
	}
	public boolean wasLeftClicked() {
		boolean wasClicked = leftClicked;
		if (leftClicked) {
			leftClicked = false;
		}
		return wasClicked;
	}
	public boolean wasRightClicked() {
		boolean wasClicked = rightClicked;
		if (rightClicked) {
			rightClicked = false;
		}
		return wasClicked;
	}
}
