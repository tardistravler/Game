import java.awt.Color;
import java.nio.file.DirectoryIteratorException;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class GamePanel extends JPanel implements Runnable {

/*
* image sizes for pixles. 16
*
* */
final int originalTileSize = 16; //16 pixles
final int scale = 3; //3 x scaling.

public final int tileSize = originalTileSize * scale;

public final int maxScreenCol = 16;
public final int maxScreenRow = 12;

public final int screenWidth = tileSize * maxScreenCol; // 768 pix
public final int screenHeight = tileSize * maxScreenRow; // 576 pix

public boolean showP = false;
public boolean showFinalText = false;


public boolean startGame= false;

KeyHandler kh = new KeyHandler();
Thread gameThread;
Player player = new Player(this, kh);
Princess pr = new Princess(this);
Sound sound = new Sound();


TileManager tileManager = new TileManager(this);

FinallyText finallyText = new FinallyText(this);

UI ui = new UI(this);

Intro intro = new Intro(this);




//FPS
int FPS = 60;

public CollisionChecker cChecker = new CollisionChecker(this);





public GamePanel() {
	this.setPreferredSize(new Dimension(screenWidth, screenHeight));
	this.setBackground(Color.black);
	this.setDoubleBuffered(true);
	this.addKeyListener(kh);
	this.setFocusable(true);
	
}

public void GameThread() {
//playMusic(0);
kh.playMusic(0);
gameThread = new Thread(this);
gameThread.start();
}


public void setupGame() {

}

@Override
public void run() {
	double drawInterval = 1000000000/FPS;
	double delta = 0;
	long LastTime = System.nanoTime();
	long currentTime;
	

while(gameThread != null) {
	currentTime = System.nanoTime();
	
	delta += (currentTime - LastTime)/drawInterval;
	
	LastTime = currentTime;
	
	if(delta >= 1) {
		update();
		repaint();
		delta--;	
	}
	
	
}
}

public void update() {
	

	player.update();

	

}
public void paintComponent(Graphics g) {
	super.paintComponent(g);
	//showFinalText = true;
	Graphics2D g2 = (Graphics2D)g;	
	intro.draw(g2);

	if(startGame) {
		//tileManager.loadMap("/maps/map01.txt");
		
		
		tileManager.draw(g2);	
		ui.draw(g2);
		player.draw(g2);
		//System.out.println(showP);
		//System.out.println("showFinalText: "+showFinalText) ;
		if(showFinalText == true) {
			System.out.println("showFinalText == " + showFinalText);
			finallyText.draw(g2);
			
		}
		if(showP == true) {
			
			
			pr.draw(g2);
			pr.update();
		}
		


	}
	g2.dispose();

	


}

public void playMusic(int i) {
	sound.setFile(i);
	sound.play();
	
}

public void stopMusic() {
	
	sound.stop();
}




}