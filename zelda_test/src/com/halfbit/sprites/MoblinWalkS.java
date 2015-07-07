package com.halfbit.sprites;

import com.halfbit.AnimatedSprite;
import com.halfbit.Frame;

public class MoblinWalkS extends AnimatedSprite {

	public MoblinWalkS() {
		super(5);
		Frame[] frames = new Frame[2];
		frames[0] = new Frame("Resources/Enemies/Moblin/LAMoblinS1.png", 0, 0);
		frames[1] = new Frame("Resources/Enemies/Moblin/LAMoblinS2.png", 0, 0);
		setFrames(frames); 
	}
}