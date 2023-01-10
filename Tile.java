import java.awt.image.BufferedImage;

public class Tile extends Entity{
		public Tile(GamePanel gp) {
		super(gp);
		// TODO Auto-generated constructor stub
	}
		public BufferedImage image;
		public boolean collision = false;
		//test if booealn warp will work. create a new boolean and add to tileManager Class, 
		
		public boolean warpL2 = false;
		public boolean warpL3 = false;
		public boolean warpL4 = false;
		public boolean warpL5 = false;
		public boolean end = false;
	
}
