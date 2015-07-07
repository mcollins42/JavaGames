package com.halfbit.sprites;

import com.halfbit.AnimatedSprite;
import com.halfbit.Frame;

public class StandingSprite extends AnimatedSprite {
	
	public StandingSprite(Frame frame) {
		super(1);
		Frame[] frames = { frame };
		setFrames(frames); 
	}
}
