package com.exilegl.box.entity;

import java.util.Random;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

import com.exilegl.box.GameManager;
import com.exilegl.box.map.Map;
import com.exilegl.box.state.StateMenu;
import com.exilegl.box.text.Text;

public class EntityBoss extends Entity{
	
	private float destX;
	private float destY;
	
	private float originalX;
	private float originalY;
	
	private float originalDestX;
	private float originalDestY;
	
	private boolean firstDead;
	
	private float scaleWidth;
	private float scaleHeight;
	
	private boolean reachedCenter;
	
	private int frames;
	private int seconds;
	
	public EntityBoss(float x, float y) {
		super(x, y, 105, 0.5f, GameManager.BOSS);
		this.originalX = 320;
		this.originalY = 320;
		this.setDestination(16, 16);
		originalDestX = (this.destX);
		originalDestY = (this.destY);
		scaleWidth = 0;
		scaleHeight = 0;
		frames = 0;
		seconds = 0;
	}
	
	@Override
	public void draw(Graphics g){
		//Draw the animation
		if(!(this.getHealth() < 1)){
		this.getAnimation().draw(this.getX(), this.getY());
		}else{
			Animation animation = (this.getAnimation());
			animation.draw(this.getX(), this.getY(), animation.getCurrentFrame().getWidth() - scaleWidth, animation.getCurrentFrame().getHeight() - scaleHeight);
		}
		//Draw the health
		g.setColor(Color.green);
		g.fillRect(this.getX() - this.getHealth() * 10 + this.getAnimation().getWidth(), this.getY() - this.getAnimation().getHeight() / 4, this.getHealth() * 10, this.getAnimation().getHeight() / 10);
		g.setColor(Color.green.darker());
		g.drawRect(this.getX() - this.getHealth() * 10 + this.getAnimation().getWidth(), this.getY() - this.getAnimation().getHeight() / 4, this.getOriginalHealth() * 10, this.getAnimation().getHeight() / 10);
		g.setColor(Color.white);
		
		if(seconds > 0){
			Map.end = true;
		}
		if(seconds > 105){
			GameManager.switchState(new StateMenu(GameManager.game, true));
		}
	}

	@Override
	public void update(GameContainer c, Map map) {
		if(!(this.getHealth() < 1)){
		int fps = (c.getFPS());
		if(fps > 1 && reachedCenter){
			this.setSpeed(3.5f);
			Random r = new Random();
			System.out.println("Reached center: " + reachedCenter);
			if(r.nextInt(fps / 2 + fps / 3) == fps / 2  + fps / 3 - 1){
				map.getQueue().add(new EntityBossDemon(this.getX(), this.getY() + this.getAnimation().getCurrentFrame().getHeight() / 2, this));
			}
		}
		//Check if we're at our destination, and if so, set a new one
		Rectangle destination = new Rectangle(destX, destY, 1, 1);
		Rectangle boss = new Rectangle(this.getX(), this.getY(), this.getAnimation().getCurrentFrame().getWidth(), this.getAnimation().getCurrentFrame().getHeight());
		if(boss.intersects(destination)){
			if(destination.getX() == originalDestX && destination.getY() == originalDestY){
				this.reachedCenter = true;
			}
			this.setDestination(168, 168);
		}
		//Go closer to our destination
		if(this.getX() < this.destX){
			this.setX(this.getX() + this.getSpeed());
		}
		if(this.getX() > this.destX){
			this.setX(this.getX() - this.getSpeed());
		}
		if(this.getY() < this.destY){
			this.setY(this.getY() + this.getSpeed());
		}
		if(this.getY() > this.destY){
			this.setY(this.getY() - this.getSpeed());
		}
		}else{
			this.setX(320);
			this.setY(320);
			this.setAnimation(GameManager.PLAYER_LARGE);
			//scale down the sprite
			scaleWidth = (scaleWidth + 1);
			scaleHeight = (scaleHeight + 1);
		}
		if(scaleWidth > 256 && scaleHeight > 256){
			this.finish(c);
		}
	}
	
	public void finish(GameContainer c){
		if(c.getFPS() > 1){
		this.frames++;
		}
		if(c.getFPS() > 1 && frames > c.getFPS()){
			seconds++;
		}
	}
	
	/**
	 * Define new destination according to a given range
	 */
	public void setDestination(float rangeX, float rangeY){
		Random r = new Random();
		if(r.nextBoolean()){
			this.destX = (originalX + r.nextInt(Math.round(rangeX)));
		}else{
			this.destX = (originalX - r.nextInt(Math.round(rangeX)));
		}
		if(r.nextBoolean()){
			this.destY = (originalY + r.nextInt(Math.round(rangeY)));
		}else{
			this.destY = (originalY - r.nextInt(Math.round(rangeY)));
		}
	}

	public int getSeconds(){
		return this.seconds;
	}
	
}
