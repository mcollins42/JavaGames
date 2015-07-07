package com.halfbit.sprites;

import com.halfbit.AnimatedSprite;
import com.halfbit.Frame;

public class ThoreauWalkS extends AnimatedSprite {
	public ThoreauWalkS() {
		super(5);
		Frame[] frames = new Frame[2];
		frames[0] = new Frame("Resources/Characters/NPC's/LAThoreauS1.png", 0, 0);
		frames[1] = new Frame("Resources/Characters/NPC's/LAThoreauS2.png", 0, 0);
		setFrames(frames); 
	}
}
