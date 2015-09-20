package com.exilegl.box.state;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.exilegl.box.map.Map;
import com.exilegl.engine.Game;
import com.exilegl.engine.state.State;

public class StateLevel extends State{

	//The level's map
	private Map map;
	
	//Whether or not this is the boss level
	private boolean boss;
	
	public StateLevel(Game game, Map map) {
		super(game);
		//Set map
		this.map = (map);
		this.boss = false;
	}

	@Override
	public void draw() {
		Graphics g = (this.getGame().getGraphicsHandler().getGraphics());
		//Draw the map
		this.getMap().draw(g, boss);
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		GameContainer c = (this.getGame().getInput().getContainer());
		//Update the map
		this.getMap().update(c, boss);
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public boolean isBoss() {
		return boss;
	}

	public void setBoss(boolean boss) {
		this.boss = boss;
	}

}
