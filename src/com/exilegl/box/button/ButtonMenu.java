package com.exilegl.box.button;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import com.exilegl.box.GameManager;
import com.exilegl.box.entity.Entity;
import com.exilegl.box.map.Map;
import com.exilegl.box.map.MapLoader;
import com.exilegl.box.state.StateLevel;
import com.exilegl.box.text.Text;
import com.exilegl.engine.Game;
import com.exilegl.engine.state.StateManager;

public class ButtonMenu extends Entity{

	private int level;
	
	private int width = 64;
	private int height = 64;
	
	private boolean hovered;
	
	private Game game;
	
	private Image image;
	
	private boolean boss;

	private boolean bonus;
	
	public ButtonMenu(int level, Image image, Game game, boolean bonus) {
		super(0, 0, 0, 0, null);
		this.setLevel(level);
		if(!bonus){
		this.setX(320 / 2 + level* 32 + level * width);
		this.setX(this.getX() - 64);
		this.game = game;
		this.setY(320 + level / 5 * height);
		}else{
			this.setX(320 / 2 + level* 32 + level * width);
			this.setX(this.getX() - 64);
			this.game = game;
			this.setY(420 + level / 5 * height * 3);
		}
		this.image = image;
		this.bonus = bonus;
	}

	public void update(GameContainer c) {
		Input input = (c.getInput());
		//Check if we're being hovered by the mouse
		Rectangle mouse = new Rectangle(input.getMouseX(), input.getMouseY(), 1, 1);
		Rectangle button = new Rectangle(this.getX(), this.getY(), width, height);
		if(mouse.intersects(button)){
			this.setHovered(true);
		}else{
			this.setHovered(false);
		}
		//If we're being hovered, check if we're being clicked
		if(this.hovered){
			if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
				this.play();
			}
		}
	}
	
	@Override
	public void draw(Graphics g){
		if(this.isHovered()){
			this.image.draw(this.getX(), this.getY());
			g.setColor(Color.darkGray);
			g.drawRect(this.getX(), this.getY(), width, height);
		}else{
			this.image.draw(this.getX(), this.getY());
			g.setColor(Color.lightGray);
			g.drawRect(this.getX(), this.getY(), width, height);
		}
		g.setColor(Color.white);
		if(this.isBoss()){
			Text.drawBold(g, "Boss", this.getX(), this.getY());
		}
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isHovered() {
		return hovered;
	}

	public void setHovered(boolean hovered) {
		this.hovered = hovered;
	}

	@Override
	public void update(GameContainer c, Map map) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Switches the game state to the matching
	 * level state with a matching map
	 */
	public void play(){
		MapLoader loader = new MapLoader();
		if(!bonus){
		switch(this.level){
		case 0:
			GameManager.switchState(new StateLevel(game, loader.getMap(false, MapLoader.ONE_TILES, MapLoader.ONE_ENTITIES, MapLoader.ONE_CAP, MapLoader.ONE_HEALTH, MapLoader.ONE_SPEED, MapLoader.ONE_INTRO)));
			break;
		case 1:
			GameManager.switchState(new StateLevel(game, loader.getMap(false, MapLoader.TWO_TILES, MapLoader.TWO_ENTITIES, MapLoader.TWO_CAP, MapLoader.TWO_HEALTH, MapLoader.TWO_SPEED, MapLoader.TWO_INTRO)));
			break;
		case 2:
			GameManager.switchState(new StateLevel(game, loader.getMap(false, MapLoader.THREE_TILES, MapLoader.THREE_ENTITIES, MapLoader.THREE_CAP, MapLoader.THREE_HEALTH, MapLoader.THREE_SPEED, MapLoader.THREE_INTRO)));
			break;
		case 3:
			GameManager.switchState(new StateLevel(game, loader.getMap(false, MapLoader.FOUR_TILES, MapLoader.FOUR_ENTITIES, MapLoader.FOUR_CAP, MapLoader.FOUR_HEALTH, MapLoader.FOUR_SPEED, MapLoader.FOUR_INTRO)));
			break;
		case 4:
			StateLevel level = new StateLevel(game, loader.getMap(false, MapLoader.FIVE_TILES, MapLoader.FIVE_ENTITIES, MapLoader.FIVE_CAP, MapLoader.FIVE_HEALTH, MapLoader.FIVE_SPEED, MapLoader.FIVE_INTRO));
			level.setBoss(true);
			GameManager.switchState(level);
			break;
		}
		}else{
		switch(level){
		case 0:
			GameManager.switchState(new StateLevel(game, loader.getMap(true, MapLoader.SIX_TILES, MapLoader.SIX_ENTITIES, MapLoader.SIX_CAP, MapLoader.SIX_HEALTH, MapLoader.SIX_SPEED, MapLoader.SIX_INTRO)));
			break;
		case 1:
			GameManager.switchState(new StateLevel(game, loader.getMap(true, MapLoader.SEVEN_TILES, MapLoader.SEVEN_ENTITIES, MapLoader.SEVEN_CAP, MapLoader.SEVEN_HEALTH, MapLoader.SEVEN_SPEED, MapLoader.SEVEN_INTRO)));
			break;
		case 2:
			GameManager.switchState(new StateLevel(game, loader.getMap(true, MapLoader.EIGHT_TILES, MapLoader.EIGHT_ENTITIES, MapLoader.EIGHT_CAP, MapLoader.EIGHT_HEALTH, MapLoader.EIGHT_SPEED, MapLoader.EIGHT_INTRO)));
			break;
		case 3:
			GameManager.switchState(new StateLevel(game, loader.getMap(true, MapLoader.NINE_TILES, MapLoader.NINE_ENTITIES, MapLoader.NINE_CAP, MapLoader.NINE_HEALTH, MapLoader.NINE_SPEED, MapLoader.NINE_INTRO)));
			break;
		case 4:
			StateLevel level = new StateLevel(game, loader.getMap(true, MapLoader.TEN_TILES, MapLoader.TEN_ENTITIES, MapLoader.TEN_CAP, MapLoader.TEN_HEALTH, MapLoader.TEN_SPEED, MapLoader.TEN_INTRO));
			GameManager.switchState(level);
			break;
		}
		}
	}

	public boolean isBoss() {
		return boss;
	}

	public void setBoss(boolean boss) {
		this.boss = boss;
	}

	public boolean isBonus() {
		return bonus;
	}

	public void setBonus(boolean bonus) {
		this.bonus = bonus;
	}

}
