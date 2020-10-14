package tennis;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;



public class Player extends GameObject {
	Handler handler;
	
	public Player(float x, float y, ID id, Handler handler) {
		super(x,y,id);
		this.handler = handler;
	}
	
	@Override
	public Rectangle getBounds() {
		
		return new Rectangle( (int)x, (int)y, 1,55);
	}
	
	@Override
	public void tick() {
		y += velY;
		
		y = Game.clamp(y, 100, Game.HEIGHT - 100);
		
		collision();
	}
	
	public void collision() {
		for(int i =0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Ball) {
				if(getBounds().intersects(tempObject.getBounds())) {
					
					float tempVelX = tempObject.getVelX();
					
					tempVelX = -tempVelX;
					
					tempObject.setVelX(tempVelX);
				
				}
			}
		}
	}
	

	
	@Override
	public void render(Graphics g) {
		
		if(getId() == ID.Player1) g.setColor(Color.blue);
		else if(getId() == ID.Player2) g.setColor(Color.green);
		g.fillRect((int)x, (int)y,15,60);
		
	}
}
