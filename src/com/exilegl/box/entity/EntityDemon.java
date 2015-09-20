package com.exilegl.box.entity;

import java.util.Random;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Rectangle;

import com.exilegl.box.GameManager;
import com.exilegl.box.map.Map;
import com.exilegl.box.tile.Tile;
import com.exilegl.box.tile.TileType;

public class EntityDemon extends Entity{

	public EntityDemon(float x, float y, Animation animation) {
		super(x, y, 6, 11, animation);
		Random r = new Random();
		this.setSpeed(11 + r.nextInt(8));
		this.setAnimation(animation);
	}

	@Override
	public void update(GameContainer c, Map map) {
		this.checkAlive();
		//Get the player entity and end tile
		Tile tileEnd = null;
		for(Tile t : map.getTiles()){
			if(t.getType() == TileType.Checker_Dark_End){
				tileEnd = t;
			}
		}
		EntityPlayer player = null;
		for(Entity e : map.getEntities()){
			if(e instanceof EntityPlayer){
				player = (EntityPlayer) e;
			}
		}
		//Move towards the player
		if(c.getFPS() > 1){
		int fps = (c.getFPS());
		Random r = new Random();
		if(r.nextInt(fps / 2 + fps / 5) == fps / 2 + fps / 5 -1){
			if(this.getX() < tileEnd.getX()){
				this.setX(this.getX() + this.getSpeed());
			}
			if(this.getX() > tileEnd.getX()){
				this.setX(this.getX() - this.getSpeed());
			}
			if(this.getY() < tileEnd.getY()){
				this.setY(this.getY() + this.getSpeed());
			}
			if(this.getY() > tileEnd.getY()){
				this.setY(this.getY() - this.getSpeed());
			}
		}
		}
		
		//Check for collision with the player and end tile
		Rectangle tileRect = new Rectangle(tileEnd.getX(), tileEnd.getY(), tileEnd.getAnimation().getCurrentFrame().getWidth(), tileEnd.getAnimation().getCurrentFrame().getHeight());
		Rectangle demon = new Rectangle(this.getX(), this.getY(), this.getAnimation().getCurrentFrame().getWidth(), this.getAnimation().getCurrentFrame().getHeight());
		if(tileRect.intersects(demon)){
			player.reverse(player.getDirection(), player.getSpeed() * 1.5f);
			player.setHealth(player.getHealth() - 1);
			this.setDead(true);
		}
		Rectangle playerRect = new Rectangle(player.getX(), player.getY(), player.getAnimation().getCurrentFrame().getWidth(), player.getAnimation().getCurrentFrame().getHeight());
		if(demon.intersects(playerRect)){
			player.reverse(player.getDirection(), player.getSpeed() * 1.5f);
			this.setHealth(this.getHealth() - 1);
		}
	}

}
