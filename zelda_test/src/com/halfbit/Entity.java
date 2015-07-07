package com.halfbit;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import com.halfbit.Entity.Facing;
import com.halfbit.sprites.StandingSprite;

public class Entity {
	public enum Facing {
		NORTH,
		SOUTH,
		EAST,
		WEST
	};
	
	private Map<Facing, AnimatedSprite> facingSpriteMap;	
	
	protected Point position;
	protected AnimatedSprite currentSprite;
	protected Facing facing;
	protected boolean moving = false;
	
	public Entity(AnimatedSprite animatedspriteN, AnimatedSprite animatedspriteE, AnimatedSprite animatedspriteW, AnimatedSprite animatedspriteS, Point startPosition) {
		position = startPosition;
		facing = Facing.SOUTH;
		moving = false;
		
		facingSpriteMap = new HashMap<>();
		facingSpriteMap.put(Facing.SOUTH, animatedspriteS);
		facingSpriteMap.put(Facing.NORTH, animatedspriteN);
		facingSpriteMap.put(Facing.EAST,  animatedspriteE);
		facingSpriteMap.put(Facing.WEST, animatedspriteW);
		
		currentSprite = facingSpriteMap.get(facing);
		
	}
	
	public int getWidth() {
		return currentSprite.imageSize.width;
	}
	
	public void imageTransition() {
		currentSprite.imageTransition();
	}
	
	public void setPosition(Point position) {
		this.position = position;
	}
	
	public void setMoving(boolean moving) {
		this.moving = moving;
		//facing = Facing.SOUTH;		
		currentSprite = new StandingSprite(facingSpriteMap.get(facing).getStandingFrame());
	}
	
	public void setFacing(Facing facing) {
		if (facing == this.facing && this.moving) {
			return;
		}
		this.facing = facing;
		this.moving = true;
		this.currentSprite = facingSpriteMap.get(facing);
	}
	
	public Entity update(Point position) {
		return null;
	}
	
	public void draw(Graphics2D g2d, Point offset) {
		Point viewPosition = new Point(position.x - offset.x, position.y - offset.y);
		currentSprite.draw(g2d, viewPosition);
	}

	public int getHeight() {
		return currentSprite.imageSize.height;
	}
}
