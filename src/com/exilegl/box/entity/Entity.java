package com.exilegl.box.entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import com.exilegl.box.map.Map;

public abstract class Entity {

	//The entity's location
	private float x;
	private float y;
	
	//The entity's health (probably will be calculated in x amount of hhearts, like 3 hearts for enemies)
	private int health;
	
	//The entity's speed
	private float speed;
	
	private Animation animation;
	
	private float originalHealth;
	
	private boolean dead;
	
	public Entity(float x, float y, int health, float speed, Animation animation){
		this.setX(x);
		this.setY(y);
		this.setHealth(health);
		this.setSpeed(speed);
		this.setAnimation(animation);
		this.setOriginalHealth(health);
	}
	
	/**
	 * Draws the entity
	 */
	public void draw(Graphics g){
		//Draw the animation
		if(!(this.getHealth() < 1)){
		this.getAnimation().draw(this.getX(), this.getY());
		}else{
			Animation animation = (this.getAnimation());
			//animation.setLooping(false);
			//animation.getCurrentFrame().setAlpha(0.5f);
			animation.draw(this.getX(), this.getY());
		}
		//Draw the health
		g.setColor(Color.green);
		g.fillRect(this.getX() - this.getHealth() * 10 + this.getAnimation().getWidth(), this.getY() - this.getAnimation().getHeight() / 4, this.getHealth() * 10, this.getAnimation().getHeight() / 10);
		g.setColor(Color.green.darker());
		g.drawRect(this.getX() - this.getHealth() * 10 + this.getAnimation().getWidth(), this.getY() - this.getAnimation().getHeight() / 4, this.getOriginalHealth() * 10, this.getAnimation().getHeight() / 10);
		g.setColor(Color.white);
	}
	
	/**
	 * Updates the entity
	 */
	public abstract void update(GameContainer c, Map map);
	
	public void checkAlive(){
		if(this.getHealth() < 1){
			this.setDead(true);
		}
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public float getOriginalHealth() {
		return originalHealth;
	}

	public void setOriginalHealth(float originalHealth) {
		this.originalHealth = originalHealth;
	}
	
}
