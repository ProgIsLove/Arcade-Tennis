package tennis;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import tennis.Game.STATE;

public class KeyInput extends KeyAdapter {
	private Handler handler;
	private boolean[] keyDown = new boolean[2];
	
	public KeyInput(Handler handler) {
		this.handler = handler;
		
		keyDown[0] = false;
		keyDown[1] = false;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i=0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player1) {
				if(key == KeyEvent.VK_W) {tempObject.setVelY(-handler.speed); keyDown[0] = true;}
				if(key == KeyEvent.VK_S) {tempObject.setVelY(handler.speed); keyDown[1] = true;}
			}
			
			if(tempObject.getId() == ID.Player2) {
				if(key == KeyEvent.VK_UP) {tempObject.setVelY(-handler.speed); keyDown[0] = true;}
				if(key == KeyEvent.VK_DOWN) {tempObject.setVelY(handler.speed); keyDown[1] = true;}
			}
		}
		
		if(key == KeyEvent.VK_P) {
			if(Game.gameState == STATE.Game) {
				if(Game.paused) Game.paused = false;
				else Game.paused = true;
			}
		}
		
		if(key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0;i < handler.object.size();i++) {
			GameObject tempObject = handler.object.get(i);
			
			if(tempObject.getId() == ID.Player1) {
				if(key == KeyEvent.VK_W) keyDown[0] = false;
				if(key == KeyEvent.VK_S) keyDown[1] = false;
				
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
			}
			
			if(tempObject.getId() == ID.Player2) {
				if(key == KeyEvent.VK_UP) keyDown[0] = false;
				if(key == KeyEvent.VK_DOWN) keyDown[1] = false;
				
				if(!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
			}
		}
	}
	

}
