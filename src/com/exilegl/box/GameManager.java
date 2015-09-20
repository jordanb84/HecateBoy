package com.exilegl.box;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.exilegl.box.map.Map;
import com.exilegl.box.map.MapLoader;
import com.exilegl.box.state.StateLevel;
import com.exilegl.box.state.StateMenu;
import com.exilegl.engine.Game;
import com.exilegl.engine.graphics.GraphicsHandler;
import com.exilegl.engine.input.Input;
import com.exilegl.engine.state.State;
import com.exilegl.engine.state.StateManager;

public class GameManager extends Game{

	public static Image SHEET;
	
	public static Animation PLAYER;
	
	public static Animation DEMON;
	
	public static Animation BOSS;
	
	public static Animation PLAYER_LARGE;
	
	public static Animation MINI;
	
	public static Animation TEA;
	
	public static Image END;
	
	public static StateManager manager;
	
	public static Game game;
	
	public GameManager() {
		super("Hecate Boy - Made for Mini LD 62", 640, 640, false, false, 30); //capping at 30 FPS; should give cooler gameboy effect and avoid difficulty differences
	}

	@Override
	public void draw(GraphicsHandler arg0) {
		//Draw the current state
		manager.draw(this);
	}

	@Override
	public void setupStates() {
		//Initiate sheet
		try {
			SHEET = new Image("res/sprite/tile/sheet.png");
		//Initiate entity sprites
		PLAYER = new Animation();
		PLAYER.addFrame(new Image("res/sprite/entity/player0.png"), 120);
		PLAYER.addFrame(new Image("res/sprite/entity/player1.png"), 120);
		DEMON = new Animation();
		DEMON.addFrame(new Image("res/sprite/entity/demon0.png"), 120);
		DEMON.addFrame(new Image("res/sprite/entity/demon1.png"), 120);
		BOSS = new Animation();
		BOSS.addFrame(new Image("res/sprite/entity/boss0.png"), 120);
		BOSS.addFrame(new Image("res/sprite/entity/boss1.png"), 120);
		PLAYER_LARGE = new Animation();
		PLAYER_LARGE.addFrame(new Image("res/sprite/entity/player0large.png"), 120);
		PLAYER_LARGE.addFrame(new Image("res/sprite/entity/player1large.png"), 120);
		TEA = new Animation();
		TEA.addFrame(new Image("res/sprite/entity/tea0.png"), 150);
		TEA.addFrame(new Image("res/sprite/entity/tea1.png"), 150);
		END = new Image("res/sprite/menu/end.png");
		MINI = new Animation();
		MINI.addFrame(new Image("res/sprite/entity/mini0.png"), 150);
		MINI.addFrame(new Image("res/sprite/entity/mini1.png"), 150);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		//Setup map for level (ADD A MENU LATER, WE ARE JUST DOING LEVEL ONE TO START)
		//Setup state manager with new level state
		this.setStateManager(new StateManager(new StateMenu(this, false)));
		manager = (this.getStateManager());
		game = this;
	}

	@Override
	public void start(GameContainer arg0) {
		
	}

	@Override
	public void update(Input arg0) {
		//Update the current state
		manager.update(this);
	}
	
	public static void switchState(State state){
		manager.setCurrentState(state);
	}
	
	//TODO: Maps should be able to set demon health and speed.
	
	/**
	 * How monster spawning will work:
	 * 
	 * in the tile class, it checks if it's tile is the
	 * spawn type. If it is, it will randomly spawn monsters
	 * based on the current FPS.
	 */
	
	/**
	 * Remember: The theme is based on the final boss.
	 * This needs to be multi leveled with some sort of cool boss
	 * at the end.
	 */
	
	/**
	 * If an enemy gets to the end block, the player
	 * loses 1 HP and said enemy is killed.
	 */
	
	/**
	 * Game boss:
	 * 
	 * Largely rescaled demon sprite, but with
	 * more creepy additions.
	 * 
	 * The boss slowly walks around the map randomly,
	 * spawning demons that look like players which will
	 * quickly chase the player, looking as if the boss is shooting them.
	 * After they collide with the player, they will go to the end, so watch
	 * out!
	 * 
	 * The boss should last for about a minute or so and be on it's
	 * own level labeled "boss"
	 * 
	 * To defeat the boss,
	 * 
	 * When you defeat the boss, it will turn into a huge
	 * player, which will stand doing nothing and slowly shrink.
	 * When it's depleted, a message is displayed for a few seconds, then you win.
	 */

}
