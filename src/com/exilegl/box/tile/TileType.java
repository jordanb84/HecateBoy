package com.exilegl.box.tile;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

import com.exilegl.box.GameManager;

public enum TileType {
	
	Brick(0, 0, 0, 64, 64, true), Floor_Dark(1, 64, 0, 64, 64, false), Floor_Light(2, 128, 0, 64, 64, false),
	Checker_Dark(3, 192, 0, 64, 64, false), Checker_Light(4, 256, 0, 64, 64, false), Spotted_Dark(5, 320, 0, 64, 64, false),
	Spotted_Light(6, 384, 0, 64, 64, false), Brick2(7, 448, 0, 64, 64, false), BrickMoss(8, 512, 0, 64, 64, true)
	,Checker_Light_Spawn(9, 256, 0, 64, 64, true), Checker_Dark_End(10, 192, 0, 64, 64, true), Checker_Dark_Solid(11, 192, 0, 64, 64, true);
	
	TileType(int id, int x, int y, int width, int height, boolean solid){
		this.SOLID = solid;
		this.ANIMATION = new Animation();
		ANIMATION.addFrame((GameManager.SHEET.getSubImage(x, y, width, height)), 1);
	}
	
	public Animation ANIMATION;
	public boolean SOLID;
	
	//All tile types that should be loaded by maps
	public static TileType[] TILES = {Floor_Light, Brick, Floor_Dark, Checker_Dark, Checker_Light, Spotted_Dark,
			Spotted_Light, Brick2, BrickMoss, Checker_Light_Spawn, Checker_Dark_End, Checker_Dark_Solid};
	
}
