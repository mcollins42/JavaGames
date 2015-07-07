package com.halfbit.sprites;

import com.halfbit.AnimatedSprite;
import com.halfbit.Frame;

public class LinkWalkE extends AnimatedSprite {

	public LinkWalkE() {
		super(5);
		Frame[] frames = new Frame[2];
		frames[0] = new Frame("Resources/Characters/Link/LALinkWalkE1.png", 0, 0);
		frames[1] = new Frame("Resources/Characters/Link/LALinkWalkE2.png", 0, 0);
		setFrames(frames); 
	}
}
