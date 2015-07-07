package com.halfbit.sprites;

import com.halfbit.AnimatedSprite;
import com.halfbit.Frame;

public class MoblinWalkW extends AnimatedSprite {

	public MoblinWalkW() {
		super(5);
		Frame[] frames = new Frame[2];
		frames[0] = new Frame("Resources/Enemies/Moblin/LAMoblinW1.png", 0, 0);
		frames[1] = new Frame("Resources/Enemies/Moblin/LAMoblinW2.png", 0, 0);
		setFrames(frames); 
	}
}