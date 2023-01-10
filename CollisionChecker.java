import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class CollisionChecker {
	
	GamePanel gp;
	Princess pr;

	public CollisionChecker(GamePanel gp) {
			this.gp = gp;
			pr = new Princess(gp);
			
		}
	public void checkTile(Entity entity) {
		
		int entityLeftX = entity.x + entity.solidArea.x;
		int entityRightX = entity.x + entity.solidArea.x + entity.solidArea.width;
		int entityTopY = entity.y + entity.solidArea.y;
		int entityBottomY = entity.y + entity.solidArea.y + entity.solidArea.height;
		
		int entityLeftCol = entityLeftX/gp.tileSize;
		int entityRightCol = entityRightX/gp.tileSize;
		int entityTopRow = entityTopY/gp.tileSize;
		int entityBottomRow = entityBottomY/gp.tileSize;
		
		int tileNum1, tileNum2;
		
		switch(entity.direction) {
		case "up":
			entityTopRow = (entityTopY - entity.speed)/gp.tileSize;
			tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
			
			System.out.println("entityLeftCol :  " + entityLeftCol + " entityRightCol : " + entityRightCol + " tileNum1 : " + 
			tileNum1 + " tileNum2: " + tileNum2);
			if(gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true) {
				
				entity.collisionOn = true;
						
			}

			

			
			//test for direction of door. (you can only go down to the door. Once it is there, SOUT a reply at Door
			if(gp.tileManager.tile[tileNum1].warpL2 == true || gp.tileManager.tile[tileNum2].warpL2 == true) {
				System.out.println("MAP02");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/map02.txt");
				gp.player.x = 45;
				gp.player.y = 10;
				
				gp.tileManager.tile[tileNum2].warpL2 = false;
				gp.tileManager.tile[tileNum1].warpL2 = false;
				gp.ui.timeRemaining = 15;



			}
			
			if(gp.tileManager.tile[tileNum1].warpL3 == true || gp.tileManager.tile[tileNum2].warpL3 == true) {
				System.out.println("MAP03");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/map03.txt");
				gp.player.x = 45;
				gp.player.y = 10;
				
				gp.tileManager.tile[tileNum2].warpL3 = false;
				gp.tileManager.tile[tileNum1].warpL3 = false;
				gp.ui.timeRemaining = 15;
				

			}
			
			if(gp.tileManager.tile[tileNum1].warpL4 == true || gp.tileManager.tile[tileNum2].warpL4 == true) {
	
				/*
				 *  COPY THIS ENTIRE THING TO FRONT LEVEL THEN BACK TO LAST LEVEL warpL4 == true ||
				 * 
				 * 
				 * */
				System.out.println("MAP04");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/map04.txt");
				gp.player.x = 45;
				gp.player.y = 10;
				
				gp.tileManager.tile[tileNum2].warpL3 = false;
				gp.tileManager.tile[tileNum1].warpL3 = false;
				gp.ui.timeRemaining = 15;
				
				
				/*
				 *  COPY THIS ENTIRE THING TO FRONT LEVEL THEN BACK TO LAST LEVEL warpL4 == true ||
				 * 
				 * 
				 * */

			}
			
			if(gp.tileManager.tile[tileNum1].warpL5 == true || gp.tileManager.tile[tileNum2].warpL5 == true) {
				
				/*
				 *  COPY THIS ENTIRE THING TO FRONT LEVEL THEN BACK TO LAST LEVEL warpL4 == true ||
				 * 
				 * 
				 * */
				System.out.println("MAP05");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/map05.txt");
				gp.player.x = 300;
				gp.player.y = 10;
				
				gp.tileManager.tile[tileNum2].warpL3 = false;
				gp.tileManager.tile[tileNum1].warpL3 = false;
				gp.ui.timeRemaining = 15;
				gp.showP = true;
				
				/*
				 *  COPY THIS ENTIRE THING TO FRONT LEVEL THEN BACK TO LAST LEVEL warpL4 == true ||
				 * 
				 * 
				 * */

			}
			
			if(gp.tileManager.tile[tileNum1].end == true || gp.tileManager.tile[tileNum2].end == true) {
				System.out.println("END!");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/finally.txt");
				gp.player.x = 75;
				gp.player.y = 475;
				
				gp.pr.stopMoving = true;
				
				gp.pr.stopMoving = true;
				
				gp.tileManager.tile[tileNum2].warpL3 = false;
				gp.tileManager.tile[tileNum1].warpL3 = false;
				
				gp.tileManager.tile[tileNum2].warpL4 = false;
				gp.tileManager.tile[tileNum1].warpL4 = false;
				
				gp.tileManager.tile[tileNum2].warpL5 = false;
				gp.tileManager.tile[tileNum1].warpL5 = false;
				
				gp.tileManager.tile[tileNum2].warpL2 = false;
				gp.tileManager.tile[tileNum1].warpL2 = false;
				gp.ui.timeRemaining = 1500;
				gp.showFinalText = true;
			}
			
			
			break;
		case "down":
			entityBottomRow = (entityBottomY + entity.speed)/gp.tileSize;
			tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
			tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
			
			System.out.println("entityLeftCol :  " + entityLeftCol + " entityRightCol : " + entityRightCol + " tileNum1 : " + 
			tileNum1 + " tileNum2: " + tileNum2);
			if(gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true) {
				entity.collisionOn = true;	
				
			}
			


			//test for direction of door. (you can only go down to the door. Once it is there, SOUT a reply at Door
			if(gp.tileManager.tile[tileNum1].warpL2 == true || gp.tileManager.tile[tileNum2].warpL2 == true) {
				System.out.println("MAP02");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/map02.txt");
				gp.player.x = 45;
				gp.player.y = 10;
				
				gp.tileManager.tile[tileNum2].warpL2 = false;
				gp.tileManager.tile[tileNum1].warpL2 = false;
				gp.ui.timeRemaining = 15;
				

			}
			
			if(gp.tileManager.tile[tileNum1].warpL3 == true || gp.tileManager.tile[tileNum2].warpL3 == true) {
				System.out.println("MAP03");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/map03.txt");
				gp.player.x = 45;
				gp.player.y = 10;
				
				gp.tileManager.tile[tileNum2].warpL3 = false;
				gp.tileManager.tile[tileNum1].warpL3 = false;
				gp.ui.timeRemaining = 15;
				

			}
			
			if(gp.tileManager.tile[tileNum1].warpL4 == true || gp.tileManager.tile[tileNum2].warpL4 == true) {
				System.out.println("MAP04");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/map04.txt");
				gp.player.x = 45;
				gp.player.y = 10;
				
				gp.tileManager.tile[tileNum2].warpL3 = false;
				gp.tileManager.tile[tileNum1].warpL3 = false;
				gp.ui.timeRemaining = 15;
				

			}
			
			
			if(gp.tileManager.tile[tileNum1].warpL5 == true || gp.tileManager.tile[tileNum2].warpL5 == true) {
				
				/*
				 *  COPY THIS ENTIRE THING TO FRONT LEVEL THEN BACK TO LAST LEVEL warpL4 == true ||
				 * 
				 * 
				 * */
				System.out.println("MAP05");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/map05.txt");
				gp.player.x = 300;
				gp.player.y = 10;
				
				gp.tileManager.tile[tileNum2].warpL3 = false;
				gp.tileManager.tile[tileNum1].warpL3 = false;
				gp.ui.timeRemaining = 15;
				gp.showP = true;
				
				/*
				 *  COPY THIS ENTIRE THING TO FRONT LEVEL THEN BACK TO LAST LEVEL warpL4 == true ||
				 * 
				 * 
				 * */

			}
			if(gp.tileManager.tile[tileNum1].end == true || gp.tileManager.tile[tileNum2].end == true) {
				System.out.println("END!");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/finally.txt");
				gp.player.x = 75;
				gp.player.y = 475;
				
				gp.pr.stopMoving = true;
				
				gp.tileManager.tile[tileNum2].warpL3 = false;
				gp.tileManager.tile[tileNum1].warpL3 = false;
				
				gp.tileManager.tile[tileNum2].warpL4 = false;
				gp.tileManager.tile[tileNum1].warpL4 = false;
				
				gp.tileManager.tile[tileNum2].warpL5 = false;
				gp.tileManager.tile[tileNum1].warpL5 = false;
				
				gp.tileManager.tile[tileNum2].warpL2 = false;
				gp.tileManager.tile[tileNum1].warpL2 = false;
				gp.ui.timeRemaining = 1500;
				
				gp.showFinalText = true;
			}
			
			break;
		case "left":
			entityLeftCol = (entityLeftX + entity.speed)/gp.tileSize;
			tileNum1 = gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
			tileNum2 = gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
			
			System.out.println("entityLeftCol :  " + entityLeftCol + " entityRightCol : " + entityRightCol + " tileNum1 : " + 
			tileNum1 + " tileNum2: " + tileNum2);
			if(gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true) {
				entity.collisionOn = true;	
				
			}
			

			//test for direction of door. (you can only go down to the door. Once it is there, SOUT a reply at Door
			if(gp.tileManager.tile[tileNum1].warpL2 == true || gp.tileManager.tile[tileNum2].warpL2 == true) {
				System.out.println("MAP02");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/map02.txt");
				gp.player.x = 45;
				gp.player.y = 10;
				
				gp.tileManager.tile[tileNum2].warpL2 = false;
				gp.tileManager.tile[tileNum1].warpL2 = false;
				gp.ui.timeRemaining = 15;
				

			}
			
			if(gp.tileManager.tile[tileNum1].warpL3 == true || gp.tileManager.tile[tileNum2].warpL3 == true) {
				System.out.println("MAP03");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/map03.txt");
				gp.player.x = 45;
				gp.player.y = 10;
				
				gp.tileManager.tile[tileNum2].warpL3 = false;
				gp.tileManager.tile[tileNum1].warpL3 = false;
				gp.ui.timeRemaining = 15;
				

			}
			
			if(gp.tileManager.tile[tileNum1].warpL4 == true || gp.tileManager.tile[tileNum2].warpL4 == true) {
				System.out.println("MAP04");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/map04.txt");
				gp.player.x = 45;
				gp.player.y = 10;
				
				gp.tileManager.tile[tileNum2].warpL3 = false;
				gp.tileManager.tile[tileNum1].warpL3 = false;
				gp.ui.timeRemaining = 15;
				
				

			}
			
			if(gp.tileManager.tile[tileNum1].warpL5 == true || gp.tileManager.tile[tileNum2].warpL5 == true) {
				
				/*
				 *  COPY THIS ENTIRE THING TO FRONT LEVEL THEN BACK TO LAST LEVEL warpL4 == true ||
				 * 
				 * 
				 * */
				System.out.println("MAP05");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/map05.txt");
				gp.player.x = 300;
				gp.player.y = 10;
				
				gp.tileManager.tile[tileNum2].warpL3 = false;
				gp.tileManager.tile[tileNum1].warpL3 = false;
				gp.ui.timeRemaining = 15;
				gp.showP = true;
				
				/*
				 *  COPY THIS ENTIRE THING TO FRONT LEVEL THEN BACK TO LAST LEVEL warpL4 == true ||
				 * 
				 * 
				 * */

			}
			if(gp.tileManager.tile[tileNum1].end == true || gp.tileManager.tile[tileNum2].end == true) {
				System.out.println("END!");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/finally.txt");
				gp.player.x = 75;
				gp.player.y = 475;
				
				gp.pr.stopMoving = true;
				
				gp.tileManager.tile[tileNum2].warpL3 = false;
				gp.tileManager.tile[tileNum1].warpL3 = false;
				
				gp.tileManager.tile[tileNum2].warpL4 = false;
				gp.tileManager.tile[tileNum1].warpL4 = false;
				
				gp.tileManager.tile[tileNum2].warpL5 = false;
				gp.tileManager.tile[tileNum1].warpL5 = false;
				
				gp.tileManager.tile[tileNum2].warpL2 = false;
				gp.tileManager.tile[tileNum1].warpL2 = false;
				gp.ui.timeRemaining = 1500;
				
				gp.showFinalText = true;
			}
			
			break;
		case "right":
			entityRightCol = (entityRightX + entity.speed)/gp.tileSize;
			tileNum1 = gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
			tileNum2 = gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
			
			System.out.println("entityLeftCol :  " + entityLeftCol + " entityRightCol : " + entityRightCol + " tileNum1 : " + 
			tileNum1 + " tileNum2: " + tileNum2);
			if(gp.tileManager.tile[tileNum1].collision == true || gp.tileManager.tile[tileNum2].collision == true) {
				entity.collisionOn = true;
				
			}

			
			//test for direction of door. (you can only go down to the door. Once it is there, SOUT a reply at Door
			if(gp.tileManager.tile[tileNum1].warpL2 == true || gp.tileManager.tile[tileNum2].warpL2 == true) {
				System.out.println("MAP02");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/map02.txt");
				gp.player.x = 45;
				gp.player.y = 10;
				
				gp.tileManager.tile[tileNum2].warpL2 = false;
				gp.tileManager.tile[tileNum1].warpL2 = false;
				gp.ui.timeRemaining = 15;
				

			}
			
			if(gp.tileManager.tile[tileNum1].warpL3 == true || gp.tileManager.tile[tileNum2].warpL3 == true) {
				System.out.println("MAP03");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/map03.txt");
				gp.player.x = 45;
				gp.player.y = 10;
				
				gp.tileManager.tile[tileNum2].warpL3 = false;
				gp.tileManager.tile[tileNum1].warpL3 = false;
				gp.ui.timeRemaining = 15;
				

			}
			
			if(gp.tileManager.tile[tileNum1].warpL4 == true || gp.tileManager.tile[tileNum2].warpL4 == true) {
				System.out.println("MAP04");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/map04.txt");
				gp.player.x = 45;
				gp.player.y = 10;
				
				gp.tileManager.tile[tileNum2].warpL3 = false;
				gp.tileManager.tile[tileNum1].warpL3 = false;
				gp.ui.timeRemaining = 15;
				//gp.showP = true;

			}
			
			if(gp.tileManager.tile[tileNum1].warpL5 == true || gp.tileManager.tile[tileNum2].warpL5 == true) {
				
				/*
				 *  COPY THIS ENTIRE THING TO FRONT LEVEL THEN BACK TO LAST LEVEL warpL4 == true ||
				 * 
				 * 
				 * */
				System.out.println("MAP05");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/map05.txt");
				gp.player.x = 300;
				gp.player.y = 10;
				
				gp.tileManager.tile[tileNum2].warpL3 = false;
				gp.tileManager.tile[tileNum1].warpL3 = false;
				gp.ui.timeRemaining = 15;
				gp.pr.direction = "down";
				gp.showP = true;
				
				/*
				 *  COPY THIS ENTIRE THING TO FRONT LEVEL THEN BACK TO LAST LEVEL warpL4 == true ||
				 * 
				 * 
				 * */

			}
			
			if(gp.tileManager.tile[tileNum1].end == true || gp.tileManager.tile[tileNum2].end == true) {
				System.out.println("END!");
				gp.tileManager.getTileImage();
				gp.tileManager.loadMap("/maps/finally.txt");
				gp.player.x = 75;
				gp.player.y = 475;
				
				gp.pr.stopMoving = true;
				
				gp.tileManager.tile[tileNum2].warpL3 = false;
				gp.tileManager.tile[tileNum1].warpL3 = false;
				
				gp.tileManager.tile[tileNum2].warpL4 = false;
				gp.tileManager.tile[tileNum1].warpL4 = false;
				
				gp.tileManager.tile[tileNum2].warpL5 = false;
				gp.tileManager.tile[tileNum1].warpL5 = false;
				
				gp.tileManager.tile[tileNum2].warpL2 = false;
				gp.tileManager.tile[tileNum1].warpL2 = false;
				gp.ui.timeRemaining = 1500;
				
				
				gp.showP = true;
				gp.showFinalText = true;
			}
			
			
			break;

		}
		
	
	}

	
}
