package com.exilegl.box.state;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import com.exilegl.box.button.ButtonMenu;
import com.exilegl.box.text.Text;
import com.exilegl.engine.Game;
import com.exilegl.engine.state.State;

public class StateMenu extends State{

	private Image background;
	
	private List<ButtonMenu> buttons = new ArrayList<ButtonMenu>();
	
	private List<ButtonMenu> buttonsBonus = new ArrayList<ButtonMenu>();
	
	private Image[] buttonImages = new Image[10];
	
	private boolean bonus;
	
	public StateMenu(Game game, boolean afterBoss) {
		super(game);
		try {
			Text.loadFonts();
			background = new Image("res/sprite/menu/background.png");
			
			buttonImages[0] = new Image("res/sprite/menu/level0.png");
			buttonImages[1] = new Image("res/sprite/menu/level1.png");
			buttonImages[2] = new Image("res/sprite/menu/level2.png");
			buttonImages[3] = new Image("res/sprite/menu/level3.png");
			buttonImages[4] = new Image("res/sprite/menu/level0.png");
			buttonImages[5] = new Image("res/sprite/menu/level0.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Generate buttons
		for(int generated = 0; generated < 5; generated++){
			ButtonMenu button = new ButtonMenu(generated, buttonImages[generated], this.getGame(), false);
			if(generated == 4){
				button.setBoss(true);
			}
			this.buttons.add(button);
		}
		//Generate bonus buttons
		for(int generated = 0; generated < 5; generated++){
			ButtonMenu button = new ButtonMenu(generated, buttonImages[generated], this.getGame(), true);
			this.buttonsBonus.add(button);
		}
		if(!afterBoss){
		bonus = false;
		}else{
			bonus = true;
		}
	}

	@Override
	public void draw() {
		Graphics g = (this.getGraphics().getGraphics());
		//Draw background
		this.background.draw();
		//Draw header text
		Text.drawLarge(g, "Hecate Boy", 640 / 4, 640 / 5);
		Text.drawBold(g, "Made in one day for Mini LD #62", 10, 600);
		//Draw all buttons
		for(ButtonMenu b : buttons){
			b.draw(g);
		}
		if(bonus){
			for(ButtonMenu b : buttonsBonus){
				b.draw(g);
			}
		}
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		GameContainer c = (this.getGame().getInput().getContainer());
		//Update all buttons
		for(ButtonMenu b : buttons){
			b.update(c);
		}
		if(bonus){
			for(ButtonMenu b : buttonsBonus){
				b.update(c);
			}
		}
		
		if(c.getInput().isKeyPressed(Input.KEY_J)){
			if(c.getInput().isKeyPressed(Input.KEY_D)){
				if(c.getInput().isKeyPressed(Input.KEY_F)){
					if(c.getInput().isKeyPressed(Input.KEY_2)){
						System.out.println("Code  done");
						bonus = true;
					}
				}
			}
		}
	}

}
