package com.exilegl.box.entity;

import java.util.Random;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Rectangle;

import com.exilegl.box.GameManager;
import com.exilegl.box.map.Map;
import com.exilegl.box.tile.Tile;
import com.exilegl.box.tile.TileType;

public class EntityBossDemon extends Entity{

	private boolean collided;
	
	private EntityBoss boss;
	
	public EntityBossDemon(float x, float y, EntityBoss boss) {
		super(x, y, 2, 4, GameManager.PLAYER);
		this.boss = boss;
	}

	@Override
	public void update(GameContainer c, Map map) {
		//Get player entity
		EntityPlayer player = null;
		for(Entity e : map.getEntities()){
			if(e instanceof EntityPlayer){
				player = (EntityPlayer) e;
			}
		}
		//If we haven't collided with the player yet, go towards it
		/**if(!collided){
			if(this.getX() < player.getX()){
				this.setX(this.getX() + this.getSpeed());
			}
			if(this.getX() > player.getX()){
				this.setX(this.getX() - this.getSpeed());
			}
			if(this.getY() < player.getY()){
				this.setY(this.getY() + this.getSpeed());
			}
			if(this.getY() > player.getY()){
				this.setY(this.getY() - this.getSpeed());
			}
			//Check for collision with player
			Rectangle playerRect = new Rectangle(player.getX(), player.getY(), player.getAnimation().getCurrentFrame().getWidth(), player.getAnimation().getCurrentFrame().getHeight());
			Rectangle demon = new Rectangle(this.getX(), this.getY(), this.getAnimation().getCurrentFrame().getWidth(), this.getAnimation().getCurrentFrame().getHeight());
			if(playerRect.intersects(demon)){
				player.reverse(player.getDirection(), player.getSpeed() * 1.5f);
				//this.setHealth(this.getHealth() - 1);
				//boss.setHealth(boss.getHealth() - 1);
				if(this.getHealth() < 1){
					this.setDead(true);
				}
				this.collided = true;
			}
		}else{**/
			//Otherwise, do normal demon AI (go towards the end to fuck up the player!)
			Tile end = null;
			for(Tile t : map.getTiles()){
				if(t.getType() == TileType.Checker_Dark_End){
					//move towards the end
					if(c.getFPS() > 1){
						int fps = (c.getFPS());
						Random r = new Random();
						if(r.nextInt(fps / 4) == fps / 4 - 1){
							if(this.getX() < t.getX()){
								this.setX(this.getX() + this.getSpeed());
							}
							if(this.getX() > t.getX()){
								this.setX(this.getX() - this.getSpeed());
							}
							if(this.getY() < t.getY()){
								this.setY(this.getY() + this.getSpeed());
							}
							if(this.getY() > t.getY()){
								this.setY(this.getY() - this.getSpeed());
							}
								
						}
						}
					//Check if we collide with the end
					Rectangle tileRect = new Rectangle(t.getX(), t.getY(), t.getAnimation().getCurrentFrame().getWidth(), t.getAnimation().getCurrentFrame().getHeight());
					Rectangle demon = new Rectangle(this.getX(), this.getY(), this.getAnimation().getCurrentFrame().getWidth(), this.getAnimation().getCurrentFrame().getHeight());
					if(demon.intersects(tileRect)){
						player.setHealth(player.getHealth() - 1);
						player.reverse(player.getDirection(), player.getSpeed() * 1.5f);
						this.setDead(true);
					}
				}
			}
			//Check if we collide with the player
			Rectangle playerRect = new Rectangle(player.getX(), player.getY(), player.getAnimation().getCurrentFrame().getWidth(), player.getAnimation().getCurrentFrame().getHeight());
			Rectangle demon = new Rectangle(this.getX(), this.getY(), this.getAnimation().getCurrentFrame().getWidth(), this.getAnimation().getCurrentFrame().getHeight());
			if(playerRect.intersects(demon)){
				player.reverse(player.getDirection(), player.getSpeed() * 1.5f);
				this.setHealth(this.getHealth() - 1);
				if(this.getHealth() < 1){
					this.setDead(true);
					boss.setHealth(boss.getHealth() - 2);
				}
			}
	}

}
