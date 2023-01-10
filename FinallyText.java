import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class FinallyText extends Entity{

	Font arial_40;
	Sound sound = new Sound();
	
	public FinallyText(GamePanel gp) {
		super(gp);
		// TODO Auto-generated constructor stub
		arial_40 = new Font("Arial", Font.PLAIN, 20);
				
	}
	

	public void draw(Graphics2D g2) {
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		
		g2.drawString("After a long time searching through the castle of hazardous mazes", gp.tileSize + 75, gp.tileSize + 75);
		g2.drawString("Finally, Andrzej found his one true love Erika!!",gp.tileSize + 75, gp.tileSize + 100);
		g2.drawString("Their Love grew and grew for each other!",gp.tileSize + 75, gp.tileSize + 125);
		g2.drawString("AND THEY LIVED HAPPILY EVER AFTER!!",gp.tileSize + 75, gp.tileSize + 150);

	}

}
