import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;


import javax.imageio.ImageIO;

public class Princess extends Entity{
	int x;
	int y;
	
	public BufferedImage image;

	public boolean stopMoving = false;
	
	public double timeRemaining;
	
	public Princess(GamePanel gp) {
		super(gp);
	try {
		up1 = ImageIO.read(getClass().getResourceAsStream("/NPC/G1U.png"));
		up2 = ImageIO.read(getClass().getResourceAsStream("/NPC/G2U.png"));
		
		down1 = ImageIO.read(getClass().getResourceAsStream("/NPC/G1D.png"));
		down2 = ImageIO.read(getClass().getResourceAsStream("/NPC/G2D.png"));
		
		left1 = ImageIO.read(getClass().getResourceAsStream("/NPC/G1L.png"));
		left2 = ImageIO.read(getClass().getResourceAsStream("/NPC/G2L.png"));
		
		right1 = ImageIO.read(getClass().getResourceAsStream("/NPC/G3R.png"));
		right2 = ImageIO.read(getClass().getResourceAsStream("/NPC/G3R.png"));
		direction = "down";
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	timeRemaining = 0;
	x = 325;
	y = 400;
	solidArea = new Rectangle(8, 8, 32, 32);
	
	this.gp = gp;
	
	}
	
	public void update() {
		
		if(stopMoving == true) {
			y = 475;
			x = 325;
		}
		
		
		
		gp.cChecker.checkTile(this);
		timeRemaining +=(double)1/60;
		System.out.println("Princess : collisionOn2 : " + collisionOn);
		if(collisionOn == true) {
			
			switch(direction) {
			
			case "down":
					y += 2;
					System.out.println("y : " + y);
					if(y >=475) {
						direction = "up";
						collisionOn = false;
						
						
					}
					break;
					
			case "up":
				y -=2;
				collisionOn = true;
					if(y <= 425) {
						direction = "down";
						collisionOn = false;
					}
			
			}
			
			if(gp.showFinalText == true) {
				System.out.println("True for gp.showFinalText from Princess class : " + gp.showFinalText);
				direction = "finalLeft";
				
			}

				
			
			
		}
		spriteCounter++;
		if(spriteCounter > 12) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
		
		
	}
	
	public void draw(Graphics2D g2) {

		
		switch(direction) {
		case "up":
			if(spriteNum == 1) {image = up1;}
			if(spriteNum == 2) {image = up2;}
			break;
		case "down":
			if(spriteNum == 1) {image = down1;}
			if(spriteNum == 2) {image = down2;}
			break;
		case "right": 
			if(spriteNum == 1) {image = right1;}
			if(spriteNum == 2) {image = right2;}
			break;
		case "left": 
			if(spriteNum == 1) {image = left1;}
			if(spriteNum == 2) {image = left2;}
			break;
		case "finalLeft":
			image = left1;
			break;
		}
		
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize,null);
		
		//g2.fillRect(x + solidArea.x, y + solidArea.y, solidArea.width, solidArea.height);
	}
	

}
 