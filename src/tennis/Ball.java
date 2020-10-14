package tennis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball extends GameObject {
	
	private Handler handler;
	private HUD hud;
	
	private int freezeBallTimer = 200;
	
	private Random randomMove = new Random();
	
	Ball(float x, float y, ID id, Handler handler, HUD hud){
		super(x,y,id);
		this.handler = handler;
		this.hud = new HUD();
		
		velX = 0;
		velY = 0;
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 10,10);
	}
	
	
	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		
		if(freezeBallTimer<=0) {
			if(velY == 0 && velX == 0)move();
		}else freezeBallTimer--;
						
		if(y <=100 || y >=Game.HEIGHT-50) velY*=-1;
		if(x<=0 || x>=Game.WIDTH-30) {
			score();
			setX(Game.WIDTH/2-8);
			setY(Game.HEIGHT/2+15);
			velX = 0;
			velY = 0;
			freezeBallTimer = 200;	
		};
		
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillOval((int)x, (int)y, 15, 15);
		
		
		if(freezeBallTimer < 200 && freezeBallTimer  !=0) {
			Font fnt = new Font("Arial", 1, 20);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString(""+freezeBallTimer, Game.WIDTH/2-34, Game.HEIGHT/2-150);
		}else {
			Font fnt = new Font("Arial", 1, 20);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("start", Game.WIDTH/2-40, Game.HEIGHT/2-150);
		}
	}
	
	public void score() {
		if(x <= 0)HUD.setScorePlayerTwo(HUD.getScorePlayerTwo() + 1);
		if(x>=Game.HEIGHT)HUD.setScorePlayerOne(HUD.getScorePlayerOne() + 1);
	}
	
	public void move() {
		int key = randomMove.nextInt(4);
		
		switch (key) {
		case 0:
			velY = 5;
			velX =5;
			//System.out.print(key);
			break;
		case 1:
			velY = -5;
			velX =5;
			//System.out.print(key);
			break;
		case 2:
			velY = 5;
			velX =-5;
			//System.out.print(key);
			break;
		case 3:
			velY = -5;
			velX =-5;
			//System.out.print(key);
			break;
		}
		
		
	}

}
