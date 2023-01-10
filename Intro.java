import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Intro extends Entity {
	


	Graphics2D g2;
	Stroke stoke1 = new BasicStroke(6f);
	
	BufferedImage image1;
	BufferedImage image2;
	BufferedImage textImageIntro;
	BufferedImage directions;
	
	public Intro(GamePanel gp) {
		super(gp);
		//arial_50 = new Font("Arial", Font.BOLD, 30 );
		
		
		getPlayersImages();

	}
	
	public void getPlayersImages() {
		try {
			image1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/NPC/G1D.png"));
			textImageIntro = ImageIO.read(getClass().getResourceAsStream("/font/introText.png"));
			directions = ImageIO.read(getClass().getResourceAsStream("/font/Directions.png"));
		    
			
			/*
			 * show all fonts
			 * */
			

			
		    
		    //Font n = new Font("", Font.PLAIN, 23);
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void draw(Graphics2D g2) {
		this.g2 = g2;

		int x = gp.tileSize /2;
		int y = gp.tileSize /2;
		int width =gp.tileSize + 650;
		int height=gp.tileSize + 200;
		g2.setColor(Color.WHITE);
		g2.setStroke(stoke1);
		g2.drawRect(x, y, width, height);
		g2.setColor(Color.RED);
		
		//g2.drawString("Erika and Andrzej's Excellent Adventure", x + 50, y+ 150);
		
		g2.drawImage(image1, x, y, gp.tileSize, gp.tileSize, null);
		g2.drawImage(image2, x + 650, y + 200, gp.tileSize, gp.tileSize, null);
		g2.drawImage(textImageIntro, x, y, 600, 200, null);
		g2.drawString("Press Enter", x + 500, y+ 450);
		
		g2.setColor(Color.WHITE);
		g2.drawRect(x, y+300, 200, 200);
		g2.drawImage(directions, x, y+300, 200, 200, null);
		
		
		
		
		
		
		
	}

}
