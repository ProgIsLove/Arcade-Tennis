package tennis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HUD {
	
	//public static int scorePlayerOne = 0;
	//public static int scorePlayerTwo = 0;
	
	private static int scorePlayerOne = 0;
	private static int scorePlayerTwo = 0;
	
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawLine(0, 100, Game.WIDTH, 100);
		g.setColor(Color.white);
		g.setFont(new Font("Arial",3,20));
		g.drawString("Scoreboard", 250, 30);
		g.drawString("Blue player", 40, 65);
		g.drawString(""+getScorePlayerOne(), 280, 65);
		g.drawString("Green player", 460, 65);
		g.drawString(" : "+getScorePlayerTwo(), 295,65);
	}


	/**
	 * @return the scorePlayerTwo
	 */
	public static int getScorePlayerTwo() {
		return scorePlayerTwo;
	}


	/**
	 * @param scorePlayerTwo the scorePlayerTwo to set
	 */
	public static void setScorePlayerTwo(int scorePlayerTwo) {
		HUD.scorePlayerTwo = scorePlayerTwo;
	}


	/**
	 * @return the scorePlayerOne
	 */
	public static int getScorePlayerOne() {
		return scorePlayerOne;
	}


	/**
	 * @param scorePlayerOne the scorePlayerOne to set
	 */
	public static void setScorePlayerOne(int scorePlayerOne) {
		HUD.scorePlayerOne = scorePlayerOne;
	}


	
}
