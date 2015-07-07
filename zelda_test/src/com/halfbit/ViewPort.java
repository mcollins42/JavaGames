package com.halfbit;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.halfbit.entities.Player;
import com.halfbit.rooms.OverWorldRoom;

public class ViewPort extends JPanel implements ActionListener {
	private final int DELAY = 25;
	private Timer timer;
	private Room debugRoom;
	private Player link;
	private long lastUpdate = System.nanoTime();
	
	public ViewPort() {
		timer = new Timer(DELAY, this);
		timer.start();
		debugRoom = new OverWorldRoom();
		link = new Player();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
//        debugRoom.drawBackground(g2d);
        //link.draw(g2d);
    }

    @Override
	public void actionPerformed(ActionEvent e) {
    	long now = System.nanoTime();
    	if (Math.abs(now - lastUpdate) > 200000000) {
    		link.imageTransition();
    		lastUpdate = now;
    	}
    	repaint();
	}
}
