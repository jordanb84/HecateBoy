package com.exilegl.box.entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Rectangle;

import com.exilegl.box.GameManager;
import com.exilegl.box.map.Map;
import com.exilegl.box.tile.Tile;

public class EntityPlayer extends Entity{

	//Current movement direction-- 0 = right / 1 = left / 2 = up / 3 = down
	private Direction direction = Direction.UP;
	
	private float spawnX;
	private float spawnY;

	public EntityPlayer(float x, float y) {
		super(x, y, 3, 16, GameManager.PLAYER);
		this.spawnX = x;
		this.spawnY = y;
	}

	@Override
	public void update(GameContainer c, Map map) {
		Input input = (c.getInput());
		//Crappy hard code check, but... if the player is outside of the map, teleport them back to the spawn point
		if(this.getX() > 640 || this.getY() > 640 || this.getX() < 0 || this.getY() < 0){
			this.setX(spawnX);
			this.setY(spawnY);
		}
		//Check for movement input
		if(input.isKeyPressed(Input.KEY_W) || input.isKeyPressed(Input.KEY_UP)){
			this.setY(this.getY() - this.getSpeed());
			this.setDirection(Direction.UP);
		}
		if(input.isKeyPressed(Input.KEY_S) || input.isKeyPressed(Input.KEY_DOWN)){
			this.setY(this.getY() + this.getSpeed());
			this.setDirection(Direction.DOWN);
		}
		if(input.isKeyPressed(Input.KEY_A) || input.isKeyPressed(Input.KEY_RIGHT)){
			this.setX(this.getX() - this.getSpeed());
			this.setDirection(Direction.RIGHT);
		}
		if(input.isKeyPressed(Input.KEY_D) || input.isKeyPressed(Input.KEY_LEFT)){
			this.setX(this.getX() + this.getSpeed());
			this.setDirection(Direction.LEFT);
		}
		//Check for collision with tiles
		for(Tile t : map.getTiles()){
			if(t.getType().SOLID){
				Rectangle tile = new Rectangle(t.getX(), t.getY(), t.getAnimation().getWidth(), t.getAnimation().getHeight());
				Rectangle entity = new Rectangle(this.getX(), this.getY(), this.getAnimation().getCurrentFrame().getWidth(), this.getAnimation().getCurrentFrame().getHeight());
				if(entity.intersects(tile)){
					this.reverse(this.getDirection(), this.getSpeed() * 2);
					System.out.println("Reversed");
				}
			}else{
			}
		}
	}
	
	/**
	 * Reverses the entity according to a given direction
	 */
	public void reverse(Direction direction, float force){
		float forceX = 0;
		float forceY = 0;
		switch(direction){
		case UP:
			forceY = (-force);
			break;
		case DOWN:
			forceY = (+force);
			break;
		case LEFT:
			forceX = (+force);
			break;
		case RIGHT:
			forceX = (-force);
			break;
		}
		this.setX(this.getX() +- forceX);
		this.setY(this.getY() +- forceY);
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
