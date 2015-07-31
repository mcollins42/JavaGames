package com.halfbit.entities;

import java.awt.Point;

import com.halfbit.Entity;
import com.halfbit.Frame;
import com.halfbit.Entity.Facing;
import com.halfbit.sprites.StandingSprite;

public class MoblinSpear extends Entity {
	public MoblinSpear(Facing direction, Point position) {
		super(
			new StandingSprite(new Frame("Resources/Enemies/Moblin/LAMobSpearN.png", 0, 0)),
			new StandingSprite(new Frame("Resources/Enemies/Moblin/LAMobSpearE.png", 0, 0)),
			new StandingSprite(new Frame("Resources/Enemies/Moblin/LAMobSpearW.png", 0, 0)),
			new StandingSprite(new Frame("Resources/Enemies/Moblin/LAMobSpearS.png", 0, 0)),
			new Point(position), direction);
	}

	@Override
	public Entity update(Point position) {
		switch (this.facing) {
		case NORTH:
			this.position.y -= 5;
			break;
			
		case SOUTH:
			this.position.y += 5;
			break;
		case EAST:
			this.position.x += 5;
			
		case WEST:
			this.position.x -= 5;
		}
		return null;
	}
	
	
}