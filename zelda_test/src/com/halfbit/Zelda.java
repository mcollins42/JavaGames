package com.halfbit;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import com.halfbit.entities.Moblin;
import com.halfbit.entities.Player;
import com.halfbit.rooms.OverWorldRoom;
import com.halfbit.sprites.ThoreauWalkS;

public class Zelda extends Canvas {
	private TextBox textBox;
	private Room scrollingRoom;
	private Player link;
	private BufferStrategy strategy;
	private KeyboardInputHandler keyHandler;
	private MouseHandler mouseHandler;
	private boolean gameRunning = true;
	private Point offset = new Point();
	private ThoreauWalkS thoreau;
	private DayNightCycle dayNight;
	private Moblin[] moblins;
	private List<Entity> projectiles;
	
	public Zelda(int width, int height) {
		textBox = new TextBox("welcome to zelda java edition indev feel free to mess around with things woohoo have fun");
		//textBox = new TextBox("dummy string woo bar");
		scrollingRoom = new OverWorldRoom();
		link = new Player();
		setIgnoreRepaint(true);
		setBounds(0,0,width,height);
		keyHandler = new KeyboardInputHandler();
		addKeyListener(keyHandler);
		mouseHandler = new MouseHandler();
		addMouseListener(mouseHandler);
		thoreau = new ThoreauWalkS();
		dayNight = new DayNightCycle(scrollingRoom);
		moblins = new Moblin[3];
		moblins[0] = new Moblin(new Point(20,120));
		moblins[1] = new Moblin(new Point(60,90));
		moblins[2] = new Moblin(new Point(540,67));
		projectiles = new ArrayList<>();
	}
	
	public void init() {
		// create the buffering strategy which will allow AWT
		// to manage our accelerated graphics
		createBufferStrategy(2);
		strategy = getBufferStrategy();
	}
	
	private boolean isCentered(Player.Facing facing) {
		double windowCenter = getSize().getWidth() / 2 + offset.x;
		int playerCenter = link.position.x + link.getWidth() / 2;
		if (facing == Player.Facing.WEST) {
			return (playerCenter <= windowCenter);
		} else if (facing == Player.Facing.EAST) {
			return (playerCenter >= windowCenter);
		}
		return false;
	}
	
	private boolean isCenteredY(Player.Facing facing) {
		double windowCenter = getSize().getHeight() / 2 + offset.y;
		int playerCenter = link.position.y + link.getHeight() / 2;
		if (facing == Player.Facing.SOUTH) {
			return (playerCenter >= windowCenter);
		} else if (facing == Player.Facing.NORTH) {
			return (playerCenter <= windowCenter);
		}
		return false;
	}
	
	public void gameLoop() {
		long lastLoopTime = System.currentTimeMillis();
		
		// keep looping round till the game ends
		while (gameRunning) {
			// work out how long its been since the last update, this
			// will be used to calculate how far the entities should
			// move this loop
			long delta = System.currentTimeMillis() - lastLoopTime;
			lastLoopTime = System.currentTimeMillis();
			dayNight.tick();
			
			for (Moblin moblin: moblins) {
				Entity projectile = moblin.update(link.position);
				if (projectile != null) {
					projectiles.add(projectile);
				}
			}
			for (Entity projectile: projectiles) {
				projectile.update(link.position);
			}
			// Get hold of a graphics context for the accelerated surface.
			Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
			if (keyHandler.leftPressed && !keyHandler.rightPressed) {
				link.setFacing(Player.Facing.WEST);
				if (isCentered(Player.Facing.WEST)) {
					if (offset.x > 0) {
						offset.x -= 2;
					}
				}
				if (link.position.x > 64){
					link.position.x -= 2;
				}
			} else if (keyHandler.rightPressed && !keyHandler.leftPressed) {
				link.setFacing(Player.Facing.EAST);
				if (isCentered(Player.Facing.EAST)) {
					if (offset.x + getSize().getWidth() < scrollingRoom.roomWidth) {
						offset.x += 2;
					}
				}
				if (link.position.x + link.getWidth() < scrollingRoom.roomWidth - 64){
					link.position.x += 2;
				}
			}

			if (keyHandler.upPressed && !keyHandler.downPressed) {
				link.setFacing(Player.Facing.NORTH);
				if (isCenteredY(Player.Facing.NORTH)) {
					if (offset.y > 0) {
						offset.y -= 2;
					}
				}
				if (link.position.y > 32){
					link.position.y -= 2;
				}
			} else if (keyHandler.downPressed && !keyHandler.upPressed) {
				link.setFacing(Player.Facing.SOUTH);
				if (isCenteredY(Player.Facing.SOUTH)) {
					if (offset.y + getSize().getHeight() < scrollingRoom.roomHeight) {
						offset.y += 2;
					}
				}
				if (link.position.y + link.getHeight() < scrollingRoom.roomHeight - 64) {
					link.position.y += 2;
				}
			}
			if (!keyHandler.upPressed && !keyHandler.downPressed && !keyHandler.rightPressed && !keyHandler.leftPressed) {
				link.setMoving(false);
			}
			if (keyHandler.spacePressed) {
				textBox.textScroll();
				keyHandler.spacePressed = false;
			}
	
			// draw the background.
			scrollingRoom.drawBackground(g, offset);
			
			textBox.drawMessage(g, new Point(30,30));
			
			// cycle round asking each entity to move itself
			link.imageTransition();
			
			// cycle round drawing all the entities we have in the game
			link.draw(g, offset);
			
			for (Moblin moblin: moblins) {
				moblin.imageTransition();
			}
			
			for (Entity projectile : projectiles) {
				projectile.draw(g, offset);
			}
			
			for (int i = 0; i < moblins.length; i++) {
				moblins[i].draw(g, offset);
			}
			
			// if a game event has indicated that game logic should
			// be resolved, cycle round every entity requesting that
			// their personal logic should be considered.
		
			// finally, we've completed drawing so clear up the graphics
			// and flip the buffer over
			g.dispose();
			strategy.show();
			
			// resolve the movement of the ship. First assume the ship 
			// isn't moving. If either cursor key is pressed then
			// update the movement appropriately
			
			// finally pause for a bit. Note: this should run us at about
			// 100 fps but on windows this might vary each loop due to
			// a bad implementation of timer
			try { Thread.sleep(10); } catch (Exception e) {}
		}
	}	
}
