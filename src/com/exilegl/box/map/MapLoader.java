package com.exilegl.box.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.exilegl.box.GameManager;
import com.exilegl.box.entity.Entity;
import com.exilegl.box.entity.EntityDemon;
import com.exilegl.box.entity.EntityPlayer;
import com.exilegl.box.tile.Tile;
import com.exilegl.box.tile.TileType;

public class MapLoader { //Everything here will be static; not going to waste time for a mini ld!

	//Static level maps
	public static final int[] ONE_TILES =
		{
			1,1,1,1,1,1,1,1,1,1,
			1,0,0,0,0,0,0,0,0,1,
			1,0,0,0,0,0,0,0,0,1,
			1,0,0,0,0,0,0,0,0,8,
			1,0,0,0,0,0,0,0,0,9,
			1,0,0,0,0,0,0,0,0,8,
			8,0,0,0,0,0,0,0,0,1,
			10,0,0,0,0,0,0,0,0,1,
			8,0,0,0,0,0,0,0,0,1,
			1,1,1,1,1,1,1,1,1,1,
		};
	
	public static final Entity[] ONE_ENTITIES =
		{
			new EntityPlayer(128, 128)	
		};
	
	public static final int ONE_CAP = 10;
	public static final int ONE_HEALTH = 6;
	public static final int ONE_SPEED = 11;
	public static final String ONE_INTRO = ("[Beginning] - WASD. Defend the exit!");
	
	public static final int[] TWO_TILES =
		{
			1,1,1,1,7,9,7,1,1,1,
			1,0,0,8,0,0,0,8,0,1,
			1,0,0,5,5,5,5,5,0,1,
			1,0,0,5,0,5,0,5,0,8,
			1,0,0,5,0,5,0,5,0,9,
			1,0,0,5,6,5,6,5,0,8,
			8,0,0,0,0,0,0,0,0,1,
			10,0,0,0,0,0,0,0,0,1,
			8,0,0,0,0,0,0,0,0,1,
			1,1,1,1,1,1,1,1,1,1,
		};
	
	public static final Entity[] TWO_ENTITIES =
		{
			new EntityPlayer(128, 128)	
		};
	
	public static final int TWO_CAP = 20;
	public static final int TWO_HEALTH = 3;
	public static final int TWO_SPEED = 6;
	public static final String TWO_INTRO = ("[Double Fun] - Hmm, two spawners.");

	public static final int[] THREE_TILES =
		{
			1,1,1,1,7,9,7,1,1,1,
			1,0,0,8,0,0,0,8,0,1,
			1,0,0,0,0,0,0,0,0,1,
			1,0,0,5,5,5,5,5,0,8,
			1,0,0,5,6,5,6,5,0,9,
			1,0,0,5,5,5,5,5,0,8,
			8,0,0,5,6,6,6,5,0,1,
			10,0,0,5,5,5,5,5,0,1,
			8,0,0,0,0,0,0,0,0,1,
			1,1,1,1,1,1,1,1,1,1,
		};
	
	public static final Entity[] THREE_ENTITIES =
		{
			new EntityPlayer(128, 128), new EntityDemon(288, 288, GameManager.PLAYER)
		};
	
	public static final int THREE_CAP = 25;
	public static final int THREE_HEALTH = 3;
	public static final int THREE_SPEED = 7;
	
	public static final String THREE_INTRO = ("[Trust] - Hecate warns you of disguise");
	
	public static final int[] FOUR_TILES =
		{
				1,1,1,1,3,9,3,1,1,1,
				1,0,0,0,0,1,0,0,0,1,
				1,0,3,3,3,3,3,0,0,1,
				1,0,3,7,3,7,3,0,0,8,
				1,0,3,3,7,3,3,0,7,9,
				1,0,3,3,3,3,3,0,0,8,
				8,0,3,7,7,7,3,0,0,1,
				10,0,7,7,7,7,7,0,0,1,
				8,0,0,0,0,0,0,0,0,1,
				1,1,1,1,1,1,1,1,1,1,
		};
	
	public static final Entity[] FOUR_ENTITIES =
		{
			new EntityPlayer(128, 128), new EntityDemon(288, 288, GameManager.PLAYER), new EntityDemon(288, 388, GameManager.PLAYER),
			new EntityDemon(288, 388, GameManager.PLAYER), new EntityDemon(288, 388, GameManager.PLAYER)
		};
	
	public static final int FOUR_CAP = 35;
	public static final int FOUR_HEALTH = 4;
	public static final int FOUR_SPEED = 8;
	public static final String FOUR_INTRO = ("[Preparation] - Hecate warns you: Prepare.");
	
	public static final int[] FIVE_TILES =
		{
			1,1,1,1,1,1,1,1,1,1,
			1,0,0,0,0,0,0,0,0,1,
			1,0,0,0,0,0,0,0,0,1,
			1,0,0,0,0,0,0,0,0,8,
			1,0,0,0,0,0,0,0,0,9,
			1,0,0,0,0,0,0,0,0,8,
			8,0,0,0,0,0,0,0,0,1,
			10,0,0,0,0,0,0,0,0,1,
			8,0,0,0,0,0,0,0,0,1,
			1,1,1,1,1,1,1,1,1,1,
		};
	
	public static final Entity[] FIVE_ENTITIES =
		{
			new EntityPlayer(128, 128)	
		};
	
	public static final int FIVE_CAP = 10;
	public static final int FIVE_HEALTH = 6;
	public static final int FIVE_SPEED = 11;
	public static final String FIVE_INTRO = ("[Earl Gray] Hecate will reward you.");
	
	//bonus levels
	public static final int[] SIX_TILES =
		{
			1,1,1,1,1,1,1,1,1,1,
			1,4,3,4,3,4,3,4,3,1,
			1,3,0,3,4,3,0,3,4,1,
			1,4,3,4,3,4,3,4,3,8,
			1,3,4,3,4,3,4,3,4,9,
			1,4,3,0,3,4,3,4,4,8,
			8,3,4,3,4,3,4,4,3,1,
			10,4,3,4,3,4,4,3,4,1,
			8,4,3,4,3,4,3,4,4,1,
			1,1,1,1,1,1,1,1,1,1,
		};
	
	public static final Entity[] SIX_ENTITIES =
		{
			new EntityPlayer(128, 128)	
		};
	
	public static final int SIX_CAP = 10;
	public static final int SIX_HEALTH = 10;
	public static final int SIX_SPEED = 15;
	public static final String SIX_INTRO = ("Welcome to the bonus levels, Earl Gray!");
	
	public static final int[] SEVEN_TILES =
		{
			1,1,1,1,1,1,1,1,1,1,
			1,0,0,0,0,0,0,0,0,1,
			1,0,0,0,7,8,7,0,0,1,
			1,0,0,0,8,9,8,0,0,8,
			1,0,0,0,7,7,7,0,0,9,
			1,0,0,0,0,0,0,0,0,8,
			8,0,0,0,0,0,0,0,0,1,
			10,0,0,0,0,7,7,0,0,1,
			8,0,0,0,0,9,8,9,0,1,
			1,1,1,1,1,9,9,9,1,1,
		};
	
	public static final Entity[] SEVEN_ENTITIES =
		{
			new EntityPlayer(128, 128)	
		};
	
	public static final int SEVEN_CAP = 35;
	public static final int SEVEN_HEALTH = 1;
	public static final int SEVEN_SPEED = 25;
	public static final String SEVEN_INTRO = ("Hmm, this shall have quite the speed");
	
	public static final int[] EIGHT_TILES =
		{
				8,8,8,8,8,8,8,8,8,8,
				8,0,7,0,7,0,7,0,0,8,
				8,0,7,0,7,0,7,0,0,8,
				8,0,7,0,7,0,7,0,0,8,
				8,0,7,0,7,0,7,0,0,9,
				8,0,7,0,7,0,7,0,0,8,
				8,0,7,0,7,0,7,0,0,8,
				10,7,0,7,0,0,7,0,0,8,
				8,0,0,0,7,0,7,0,0,8,
				8,8,8,8,8,8,8,8,8,8,
		};
	
	public static final Entity[] EIGHT_ENTITIES =
		{
			new EntityPlayer(128, 128)	
		};
	
	public static final int EIGHT_CAP = 10;
	public static final int EIGHT_HEALTH = 10;
	public static final int EIGHT_SPEED = 25;
	public static final String EIGHT_INTRO = ("Earl gray will support the strength.");
	
	public static final int[] NINE_TILES =
		{
			8,8,8,8,8,8,8,8,8,8,
			8,0,7,0,0,8,0,8,0,8,
			8,7,9,7,8,9,8,9,8,8,
			8,0,7,0,0,8,0,8,0,8,
			8,0,0,0,0,0,9,0,0,8,
			8,0,0,0,0,0,0,0,0,8,
			8,0,0,0,0,0,0,9,0,8,
			10,0,0,0,0,0,0,0,0,8,
			8,0,0,0,0,0,0,0,0,8,
			8,8,8,8,8,8,8,8,8,8,
		};
	
	public static final Entity[] NINE_ENTITIES =
		{
			new EntityPlayer(128, 188)	
		};
	
	public static final int NINE_CAP = 25;
	public static final int NINE_HEALTH = 1;
	public static final int NINE_SPEED = 11;
	public static final String NINE_INTRO = ("Five is an interesting number.");
	
	public static final int[] TEN_TILES =
		{
			11,11,11,11,11,11,11,11,11,11,
			11,4,4,4,4,4,4,4,4,11,
			11,4,4,4,4,4,4,4,4,11,
			11,4,4,4,4,4,4,4,4,9,
			11,4,4,4,4,4,4,4,4,9,
			11,4,4,4,4,4,4,4,4,9,
			8,4,4,4,4,4,4,4,4,11,
			10,4,0,4,4,4,4,4,4,11,
			8,4,4,4,4,4,4,4,4,11,
			11,11,11,11,11,11,11,11,11,11,
		};
	
	public static final Entity[] TEN_ENTITIES =
		{
			new EntityPlayer(128, 128)	
		};
	
	public static final int TEN_CAP = 25;
	public static final int TEN_HEALTH = 2;
	public static final int TEN_SPEED = 18;
	public static final String TEN_INTRO = ("The last of the Hecate series.");
	
	/**
	 * Returns a map with a specified tile and entity list
	 */
	public Map getMap(boolean bonus, int[] tileList, Entity[] entityList, int cap, int demonHealth, int demonSpeed, String intro){
		//Load tiles
		List<Tile> tiles = new ArrayList<Tile>();
		int total = 0;
		for(int layers = 0; layers < 10; layers++){
			for(int rows = 0; rows < 10; rows++){
				TileType type = (TileType.TILES[tileList[total]]);
				tiles.add(new Tile(type, type.ANIMATION.getWidth() * rows, type.ANIMATION.getHeight() * layers));
				total++;
			}
		}
		//Load entities
		List<Entity> entities = new ArrayList<Entity>();
		for(Entity e : entityList){
			entities.add(e);
		}
		return new Map(bonus, tiles, entities, cap, demonHealth, demonSpeed, intro);
	}
	
}
