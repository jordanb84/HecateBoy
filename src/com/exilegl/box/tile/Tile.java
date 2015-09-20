package com.exilegl.box.tile;

import java.util.Random;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.exilegl.box.GameManager;
import com.exilegl.box.entity.Entity;
import com.exilegl.box.entity.EntityDemon;
import com.exilegl.box.map.Map;

public class Tile extends Entity{

	//The tile's type
	private TileType type;
	
	//Total demons spawned
	private int demonsSpawned;
	
	private boolean bonus;
	
	public Tile(TileType type, float x, float y) {
		super(x, y, 0, 0, type.ANIMATION);
		this.setType(type);
		demonsSpawned = 0;
	}

	@Override
	public void update(GameContainer c, Map map) {
		//If we are of the spawn block, randomly spawn demons until we've spawned the cap
		if(this.getType() == TileType.Checker_Light_Spawn){
			//System.out.println(c.getFPS());
			if(c.getFPS() > 1 && demonsSpawned < map.getDemonCap()){
			Random r = new Random();
			int fps = (c.getFPS());
			if(r.nextInt(fps * 2) == fps * 2 - 1){
				if(!bonus){
				map.addDemon(new EntityDemon(this.getX(), this.getY(), GameManager.DEMON));
				}else{
					if(r.nextBoolean()){
					map.addDemon(new EntityDemon(this.getX(), this.getY(), GameManager.MINI));
					}else{
						map.addDemon(new EntityDemon(this.getX(), this.getY(), GameManager.DEMON));
					}
				}
				System.out.println("SPAWNED");
				this.demonsSpawned++;
			}
			}
		}
	}
	
	@Override
	public void draw(Graphics g){
		//Draw the animation
		this.getAnimation().draw(this.getX(), this.getY());
	}

	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}

	public boolean isBonus() {
		return bonus;
	}

	public void setBonus(boolean bonus) {
		this.bonus = bonus;
	}

}
