package tennis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import tennis.Game.STATE;


public class Menu extends MouseAdapter{
	
	private Handler handler;
	private HUD hud;
	
	public Menu(Handler handler, HUD hud) {
		this.handler = handler;
		this.hud = hud;
	}
	
	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();
		
		if(Game.gameState == STATE.Menu) {
			//play button
			if(mouseOver(mx, my,Game.WIDTH/2-75,Game.HEIGHT/2-100,150,50)) {
				Game.gameState = STATE.Game;
				handler.addObject(new Player(Game.WIDTH/4-80, Game.HEIGHT/2-10, ID.Player1, handler));
				handler.addObject(new Player(510, Game.HEIGHT/2-10, ID.Player2, handler));
				handler.addObject(new Ball(Game.WIDTH/2-8, Game.HEIGHT/2+15, ID.Ball,handler, hud));
				
			}
			
			//help button
			if(mouseOver(mx, my, Game.WIDTH/2-75, Game.HEIGHT/2-25, 150, 50)) {
				Game.gameState = STATE.Help;
			}
			
			//quit button
			if(mouseOver(mx, my,Game.WIDTH/2-75,Game.HEIGHT/2+50,150,50)) {
				System.exit(1);
			}
		}
		
		//back button for help
		if(Game.gameState == STATE.Help) {
			if(mouseOver(mx,my,Game.WIDTH/2-75, Game.HEIGHT/2+125, 150, 50)) {
				System.out.print("clic");
				Game.gameState = STATE.Menu;
				return;
			}
		}
		
		//try again button for new game
		if(Game.gameState == STATE.End) {
			if(mouseOver(mx,my,Game.WIDTH/2-75, Game.HEIGHT/2+125, 150, 50)) {
				Game.gameState = STATE.Menu;
				HUD.setScorePlayerOne(0);;
				HUD.setScorePlayerTwo(0);;
			}
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x + width) {
			if(my > y && my < y + height) {
				return true;
			}else return false;
		}else return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		Font fnt = new Font("arial", 1, 50);
		Font fnt2 = new Font("arial", 1, 30);
		Font fnt3 = new Font("arial", 1, 20);
		if(Game.gameState == STATE.Menu) {
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Menu", Game.WIDTH/2-65, Game.HEIGHT/2-150);
			
			g.setFont(fnt2);
			g.drawRect(Game.WIDTH/2-75, Game.HEIGHT/2-100, 150, 50);
			g.drawString("Play", Game.WIDTH/2-30, Game.HEIGHT/2-65);
			
			g.drawRect(Game.WIDTH/2-75, Game.HEIGHT/2-25, 150, 50);
			g.drawString("Help", Game.WIDTH/2-30, Game.HEIGHT/2+10);
			
			g.drawRect(Game.WIDTH/2-75, Game.HEIGHT/2+50, 150, 50);
			g.drawString("Quit", Game.WIDTH/2-30, Game.HEIGHT/2+85);
		}else if(Game.gameState == STATE.Help) {
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Help", Game.WIDTH/2-65, Game.HEIGHT/2-150);
			
			g.setFont(fnt3);
			g.setColor(Color.blue);
			g.drawString("Blue player", 80, Game.HEIGHT/2-75);
			g.setColor(Color.white);
			g.drawString("use S key to move down", 100, Game.HEIGHT/2-50);
			g.drawString("use W key to move up", 100, Game.HEIGHT/2-30);
			g.setColor(Color.green);
			g.drawString("Green player", 80, Game.HEIGHT/2);
			g.setColor(Color.white);
			g.drawString("use Arrow down to move down", 100, Game.HEIGHT/2+25);
			g.drawString("use Arrow up to move up", 100, Game.HEIGHT/2+45);
			g.drawString("Pause - press P", Game.WIDTH/2-74, Game.HEIGHT/2+90);
			
			g.drawRect(Game.WIDTH/2-75, Game.HEIGHT/2+125, 150, 50);
			g.drawString("Back", Game.WIDTH/2-25, Game.HEIGHT/2+157);
		}else if(Game.gameState == STATE.End) {
			g.setFont(fnt);
			if(HUD.getScorePlayerOne() == 10) {
				g.setColor(Color.blue);
				g.drawString("Blue player WIN!", Game.WIDTH/2-205, Game.HEIGHT/2-150);
			}
			
			if(HUD.getScorePlayerTwo() == 10) {
				g.setColor(Color.green);
				g.drawString("Green player WIN!", Game.WIDTH/2-205, Game.HEIGHT/2-150);
			}
			
			
			g.setFont(fnt3);
			g.setColor(Color.white);
			
			
			g.drawRect(Game.WIDTH/2-75, Game.HEIGHT/2+125, 150, 50);
			g.drawString("Try again", Game.WIDTH/2-50, Game.HEIGHT/2+157);
			
		}
		
	}
}
