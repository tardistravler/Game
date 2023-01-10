import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

public class UI extends Entity{


	Font arial_40;
	
	public double timeRemaining = 15;
	DecimalFormat dFormat = new DecimalFormat("#0.00");
	
	public UI(GamePanel gp) {
		super(gp);
		// TODO Auto-generated constructor stub
		arial_40 = new Font("Arial", Font.PLAIN, 20);
	
	}
	public void draw(Graphics2D g2) {
		
		g2.setFont(arial_40);
		g2.setColor(Color.WHITE);//were going to change that. 
		timeRemaining -=(double)1/60;
		g2.drawString("Timer: " + dFormat.format(timeRemaining), 35, 575);
		
		if(timeRemaining < 0) {
			g2.drawString("GAME OVER!", gp.tileSize /2, gp.tileSize /2);
			timeRemaining = 0;
			g2.dispose();
			gp.sound.stop();
			
		}
		
	}
}
