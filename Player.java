import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Player extends Entity{

		
		KeyHandler kh;
		
		
		
		
		public Player(GamePanel gp, KeyHandler kh) {
			super(gp);
			
			this.kh = kh;
			setDefaultValues();
			getPlayerImage();
			
			//x = gp.screenWidth/2 - (gp.tileSize/2);
			//y = gp.screenHeight/2 - (gp.tileSize/2);
			
			x = 45;
			y = 45;
			
			
			solidArea = new Rectangle(8, 8, 32, 32);
			
			//adjust solid aread on a rectangle on the player
			
			
			System.out.println(solidArea.getBounds());
			
		}
		
		public void setDefaultValues() {
	
		}
		
		public void getPlayerImage() {
			
			try {
				
				up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
				up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
				down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
				down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
				left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
				left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
				right1= ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
				right2= ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void update() {


			if(kh.upPressed == true || kh.downPressed == true || kh.leftPressed == true ||
					kh.rightPressed == true || kh.enterPressed == true) {
				
				if(kh.upPressed == true) {
					
					direction = "up";
				
				}
				if(kh.downPressed == true) {
					
					direction = "down";
				}

				if(kh.leftPressed == true) {
					
					
					direction = "left";
				}
				
				if(kh.rightPressed == true) {
					
					direction = "right";
					
				}
				if(kh.enterPressed == true) {
					direction = "enter";
					kh.enterPressed = false;
				}
	

				//check tile collison
				collisionOn = false;
				gp.cChecker.checkTile(this);
				//IF COLLISION IS FALSE PLAYER CAN MOVE
				
				if(collisionOn == false) {
					
					switch(direction) {
					case "up":
						y -= speed;
						System.out.println("t/f collision : " + collisionOn + " y " + y + " x " + x);
						
						break;
					case "down":
						y += speed;
						System.out.println("t/f collision: " + collisionOn + " y " + y + " x " + x);
						break;
					case "left":
						x -= speed;
						System.out.println("t/f collision: " + collisionOn + " y " + y + " x " + x);
						break;
					case "right":
						x += speed;
						System.out.println("t/f collision: " + collisionOn + " y " + y + " x " + x);
						break;
					case "enter":
						System.out.println("enter pressed from Player class " + kh.enterPressed);
						gp.startGame = true;
						System.out.println("gp.startGame - "  + gp.startGame);
	
						
						break;
					
					}
				}
				
				spriteCounter++;
				//spriteCounter > 12 is referring to the Frames
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
			
		}
		
		public void draw(Graphics2D g2) {
			//g2.setColor(Color.white);

			//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
			
			BufferedImage image = null;
			
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

			
			}
			g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
			//g2.fillRect(x + solidArea.x, y + solidArea.y, solidArea.width, solidArea.height);
		}
}
