import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class TileManager extends Entity{

	public Tile[] tile;
	
	int mapTileNum[][];
	//Sound sound = new Sound();
	
	public TileManager(GamePanel gp) {
		super(gp);
		tile = new Tile[24];//create 10 different tiles, grass tile, floor tile, wall tile, water tile. you get it. 
		mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
		
		System.out.println("TileManager gp.start game == " + gp.startGame);
		//loadMap("/maps/intro.txt");
			getTileImage();
			loadMap("/maps/map01.txt");

		

	}
	
	public void getTileImage() {
		
		try {
			tile[0] = new Tile(gp);
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			tile[0].collision = false;
			
			tile[1] = new Tile(gp);
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[1].collision = true;
			
			
			tile[2] = new Tile(gp);
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			tile[2].collision = true;
			
			//TEST OF TILES! 
			
			tile[3] = new Tile(gp);
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/brickyellow.png")); // yellow brick wall
			tile[3].collision = false;
			
			
			tile[4] = new Tile(gp);
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall1.png"));
			tile[4].collision = true;
			
			tile[5] = new Tile(gp);
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grassFlowers.png"));
			tile[5].collision = true;
			
			
			tile[6] = new Tile(gp);
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass1.png"));
			tile[6].collision = false;
			
			//doors
			
			tile[7] = new Tile(gp);
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/door.png"));
			tile[7].warpL2 = true;
			
			tile[8] = new Tile(gp);
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/door2.png"));
			tile[8].warpL3 = true;
			
			tile[9] = new Tile(gp);
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/door3.png"));
			tile[9].warpL4 = true;
			
			tile[10] = new Tile(gp);
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/door4.png"));
			tile[10].warpL5 = true;

			tile[11] = new Tile(gp);
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass3.png"));
			tile[11].collision = false;

			tile[12] = new Tile(gp);
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water2.png"));
			tile[12].collision = true;
			
			tile[13] = new Tile(gp);
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass3.png"));
			tile[13].collision = true;
			tile[13].end = true;
			
			/*
			 * 
			 * This section will be for the game ending tiles. 
			 * 
			 * */
			tile[14] = new Tile(gp);
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sky1.png"));
			tile[14].collision = true;
			
			tile[15] = new Tile(gp);
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sky2.png"));
			tile[15].collision = true;
			
			tile[16] = new Tile(gp);
			tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sky3.png"));
			tile[16].collision = true;
			
			tile[17] = new Tile(gp);
			tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sky4.png"));
			tile[17].collision = true;
			
			tile[18] = new Tile(gp);
			tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sky5.png"));
			tile[18].collision = true;
			
			tile[19] = new Tile(gp);
			tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/star1.png"));
			tile[19].collision = true;
			
			tile[20] = new Tile(gp);
			tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/star2.png"));
			tile[20].collision = true;
			
			tile[21] = new Tile(gp);
			tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/star3.png"));
			tile[21].collision = true;
			
			tile[22] = new Tile(gp);
			tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/groundfinal.png"));
			tile[22].collision = true;
			
			tile[23] = new Tile(gp);
			tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sky5.png"));
			tile[23].collision = false;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("this is coming from here? ");
		}
	}
	
	public void loadMap(String filePath) {
		try {
			
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
				
				String line = br.readLine();
				while(col < gp.maxScreenCol) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.maxScreenCol) {
					col = 0;
					row++;
				}
			}
			br.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < gp.maxScreenCol  && row < gp.maxScreenRow) {
			int tileNum = mapTileNum[col][row];
			g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
			col++;
			x += gp.tileSize;
			
			if(col == gp.maxScreenCol) {
				col = 0;
				x = 0;
				row++;
				y += gp.tileSize;
			}
		}
	}

}
