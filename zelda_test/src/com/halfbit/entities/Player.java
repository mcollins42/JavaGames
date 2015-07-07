package com.halfbit.entities;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import com.halfbit.Entity;
import com.halfbit.sprites.LinkWalkE;
import com.halfbit.sprites.LinkWalkN;
import com.halfbit.sprites.LinkWalkS;
import com.halfbit.sprites.LinkWalkW;

public class Player extends Entity {
	
	public Player() {
		super(new LinkWalkN(), new LinkWalkE(), new LinkWalkW(), new LinkWalkS(), new Point(375,280));
	}
}
