package com.exilegl.box.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.exilegl.box.GameManager;
import com.exilegl.box.entity.Entity;
import com.exilegl.box.entity.EntityBoss;
import com.exilegl.box.entity.EntityDemon;
import com.exilegl.box.entity.EntityPlayer;
import com.exilegl.box.state.StateMenu;
import com.exilegl.box.text.Text;
import com.exilegl.box.tile.Tile;
import com.exilegl.box.tile.TileType;

public class Map {

	//The map's tile list
	private List<Tile> tiles = new ArrayList<Tile>();
	
	//The map's entity list
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Entity> queue = new ArrayList<Entity>();
	
	//The amount of demons we should spawn in this map
	private int demonCap;
	
	private int framesPast = 0;
	private int secondsPast = 0;
	
	private boolean lost;
	private boolean won;
	
	private int demonHealth;
	private int demonSpeed;
	
	private String intro;
	
	private int introFrames = 0;
	private int introSeconds = 0;
	
	public static boolean end;
	
	private boolean bonus;
	
	public Map(boolean bonus, List<Tile> tiles, List<Entity> entities, int demons, int demonHealth, int demonSpeed, String intro){
		//Set tile and entity lists
		this.setBonus(bonus);
		this.setTiles(tiles);
		this.setEntities(entities);
		this.setDemonCap(demons);
		//Set demon speed/health
		this.setDemonHealth(demonHealth);
		this.setDemonSpeed(demonSpeed);
		this.intro = intro;
		end = false;
		//make sure the players' health is set back to 3 so we don't auto lose when we retry
		for(Entity e : entities){
			if(e instanceof EntityPlayer){
				e.setHealth(3);
			}
		}
		if(bonus){
			for(Tile t : this.tiles){
				if(t.getType() == TileType.Checker_Light_Spawn){
					t.setBonus(true);
				}
			}
		}
	}
	
	public void addDemon(EntityDemon demon){
		demon.setHealth(demonHealth);
		demon.setSpeed(demonSpeed);
		this.getEntities().add(demon);
	}
	
	public void draw(Graphics g, boolean boss){
		//Draw tiles
		for(Tile t : tiles){
			t.draw(g);
		}
		//Draw entities
		for(Entity e : entities){
			if(e instanceof EntityBoss){
				if(((EntityBoss) e).getSeconds() > 0){
					e.draw(g);
				}else{
					e.draw(g);
				}
			}else{
				e.draw(g);
			}
			
		}
		
		if(introSeconds < 20){
			Text.drawBold(g, intro, intro.length(), 320);
		}
		
		if(secondsPast > 20){
			this.framesPast = 0;
			this.secondsPast = 0;
			GameManager.switchState(new StateMenu(GameManager.game, false));
		}else{
			if(lost){
			String text = ("Shucks, you've lost. You can try again,");
			String text2 = ("or play a different level!");
			Text.drawBold(g, text, text.length(), 320);
			Text.drawBold(g, text2, text2.length(), 380);
			}else{
				if(won){
				String text = ("Congrats, you have the skills of Hecate!");
				Text.drawBold(g, text, text.length(), 320);
				}
			}
		}
		if(end){
			GameManager.TEA.draw(320 - GameManager.TEA.getCurrentFrame().getWidth(), 320 - GameManager.TEA.getCurrentFrame().getHeight());
			String text = ("You've defeated the boss, and");
			String text2 = ("you should feel proud. Have some");
			String text3 = ("Earl Gray.");
			String text4 = ("[Press jdf2j in the menu for a secret!]");
			Text.drawBold(g, text, text.length(), 320);
			Text.drawBold(g, text2, text2.length(), 352);
			Text.drawBold(g, text3, text3.length(), 384);
			Text.drawBold(g, text4, text4.length(), 420);
		}
		
		
	}
	
	public void update(GameContainer c, boolean boss){
		//TODO: Make it so you can actually lose, and then nerf the boss accordingly.
		if(introSeconds > 20){
		int deadDemons = 0;
		EntityPlayer player = null;
		//Update tiles
		for(Tile t : tiles){
			t.update(c, this);
		}
		//Update entities
		for(Entity e : entities){
			if(!e.isDead()){
			e.update(c, this);
				if(e instanceof EntityPlayer){
					player = (EntityPlayer) e;
				}
			}else{
				if(e instanceof EntityDemon && e.isDead()){
					deadDemons++;
				}
			}
			if(e instanceof EntityBoss){
				if(((EntityBoss) e).getSeconds() > 0){
					
				}
			}
		}
		entities.addAll(queue);
		queue.clear();
		if(end){
			player.setHealth(3);
		}
		if(deadDemons > this.demonCap - 1){
			//System.out.println("Dead demons is " + deadDemons + " and demon cap is " + demonCap + ", so we shall win");
			if(!boss){
			this.win(c);
			}else{
				this.boss();
			}
		}
		System.out.println("Checkin if player's health is <1. Health is " + player.getHealth());
		if(player.getHealth() < 1){
			this.lose(c);
		}
		}else{
		this.introFrames++;
		if(introFrames > c.getFPS() && c.getFPS() > 1){
			this.introSeconds++;
		}
		}
	}
	
	public void win(GameContainer c){
		framesPast++;
		if(framesPast > c.getFPS() && c.getFPS() > 1){
			secondsPast++;
		}
		this.won = true;
	}
	
	public void lose(GameContainer c){
		framesPast++;
		if(framesPast > c.getFPS() && c.getFPS() > 1){
			secondsPast++;
		}
		this.lost = true;
	}

	private boolean spawned;
	public void boss(){
		//If this is the first frame, spawn the boss
		if(!spawned){
			queue.add(new EntityBoss(640, 640));
			spawned = true;
		}
	}
	
	public List<Tile> getTiles() {
		return tiles;
	}

	public void setTiles(List<Tile> tiles) {
		this.tiles = tiles;
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}

	public int getDemonCap() {
		return demonCap;
	}

	public void setDemonCap(int demonCap) {
		this.demonCap = demonCap;
	}

	public int getDemonHealth() {
		return demonHealth;
	}

	public void setDemonHealth(int demonHealth) {
		this.demonHealth = demonHealth;
	}

	public int getDemonSpeed() {
		return demonSpeed;
	}

	public void setDemonSpeed(int demonSpeed) {
		this.demonSpeed = demonSpeed;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public List<Entity> getQueue(){
		return queue;
	}

	public boolean isBonus() {
		return bonus;
	}

	public void setBonus(boolean bonus) {
		this.bonus = bonus;
	}
	
}
