package com.halfbit.sprites;

import com.halfbit.AnimatedSprite;
import com.halfbit.Frame;

public class LinkWalkN extends AnimatedSprite {
	
	public LinkWalkN() {
		super(5);
		Frame[] frames = new Frame[2];
		frames[0] = new Frame("Resources/Characters/Link/LALinkWalkN1.png", 0, 0);
		frames[1] = new Frame("Resources/Characters/Link/LALinkWalkN2.png", 0, 0);
		setFrames(frames); 
	}
}
