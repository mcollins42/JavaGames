package com.halfbit;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

public class ImageCache {
	private static ImageCache instance = new ImageCache();
	private Map<String, Image> imageMap;
	
	private ImageCache() {
		imageMap = new HashMap<>();
	}
	
	public static ImageCache getInstance() {
		return instance;
	}
	
	public Image getImage(String filename) {
		Image image = imageMap.get(filename);
		if (image == null){
			image = ImageLoader.loadImage(filename);
			imageMap.put(filename, image);
		}
		return image;
	}
}
