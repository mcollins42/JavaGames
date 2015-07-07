package com.halfbit;

import java.awt.Point;

import com.halfbit.Entity.Facing;
import com.halfbit.sprites.StandingSprite;

public class MoblinSpear extends Entity {
	public MoblinSpear(Facing direction, Point position) {
		super(
			new StandingSprite(new Frame("Resources/Enemies/Moblin/LAMobSpearN.png", 0, 0)),
			new StandingSprite(new Frame("Resources/Enemies/Moblin/LAMobSpearE.png", 0, 0)),
			new StandingSprite(new Frame("Resources/Enemies/Moblin/LAMobSpearW.png", 0, 0)),
			new StandingSprite(new Frame("Resources/Enemies/Moblin/LAMobSpearS.png", 0, 0)),
			position);
	}
}