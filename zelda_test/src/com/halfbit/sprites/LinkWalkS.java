package com.halfbit.sprites;

import com.halfbit.AnimatedSprite;
import com.halfbit.Frame;

public class LinkWalkS extends AnimatedSprite {
	
	public LinkWalkS() {
		super(5);
		Frame[] frames = new Frame[2];
		frames[0] = new Frame("Resources/Characters/Link/LALinkWalkS1.png", 0, 0);
		frames[1] = new Frame("Resources/Characters/Link/LALinkWalkS2.png", 0, 0);
		setFrames(frames); 
	}
}
