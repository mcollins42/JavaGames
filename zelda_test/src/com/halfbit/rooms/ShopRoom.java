package com.halfbit.rooms;

import com.halfbit.Room;

public class ShopRoom extends Room {
	
	public ShopRoom(){
	super("LAHouse_Tiles2.png", 32, 2, 10, new int[][] { 
			{ 11,11,11,0,1,1,1,2 }, 
			{ 11,11,11,10,25,25,25,12 }, 
			{ 0,1,1,41,55,55,55,12 }, 
			{ 10,11,11,11,25,25,25,12 }, 
			{ 10,11,11,11,25,25,25,12 }, 
			{ 20,21,63,64,21,21,21,22 }
			});
	}

}
