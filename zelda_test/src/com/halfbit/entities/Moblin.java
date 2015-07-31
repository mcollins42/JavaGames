package com.halfbit.entities;

import java.awt.Point;
import java.util.Random;

import com.halfbit.Entity;
import com.halfbit.sprites.MoblinWalkE;
import com.halfbit.sprites.MoblinWalkN;
import com.halfbit.sprites.MoblinWalkS;
import com.halfbit.sprites.MoblinWalkW;

public class Moblin extends Entity {

	private static Random random;
	
	static {
		random = new Random();
	}
	
	private int rechargeDelay = 0;
	
	public Moblin(Point position) {
		super(new MoblinWalkN(), new MoblinWalkS(), new MoblinWalkE(), new MoblinWalkW(), position, Facing.SOUTH);
	}
	
	
	@Override
	public Entity update(Point position) {
		super.update(position);
		if (rechargeDelay > 0) {
			rechargeDelay--;
		}
		int x = this.position.x;
		int y = this.position.y;
		if(position.x >= x && position.x <= x + getWidth()) {
			if(position.y < y) {
				return shoot(Facing.NORTH);
			} else {
				return shoot(Facing.SOUTH);
			} 
		} else if(position.y >= y && position.y <= y + getWidth()) {
			if(position.x < x) {
				return shoot(Facing.WEST);
			} else {
				return shoot(Facing.EAST);
			} 
		} else {
			move(position, x, y);
		}
		return null;
	}


	public int decide() {
		int headingTowards = random.nextInt(2);
		return headingTowards;
	}
	
	public Entity shoot(Facing direction) {
		if (rechargeDelay > 0) return null;
		
		this.rechargeDelay = 30;
		return new MoblinSpear(direction, position);
	}
	
	public void move(Point position, int x, int y){
		if (decide() == 1) {
			if (position.x > x) {
				this.position.x += 1;
			} else {
				this.position.x -= 1;
			}
		} else {
			if (position.y > y) {
				this.position.y += 1;
			} else {
				this.position.y -= 1;
			}

		}
		
	}
	
}
