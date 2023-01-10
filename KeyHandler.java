
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{

	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
	boolean soundOne = false;
	boolean soundTwo = false;
	boolean soundThree = false;
	boolean soundFour = false;
	
	int counter = 3;
	
	Sound sound = new Sound();

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			//System.out.println("w");
			upPressed = true;
		}
		if(code == KeyEvent.VK_A) {
			//System.out.println("a");
			leftPressed = true;
		}
		if(code == KeyEvent.VK_D) {
			//System.out.println("d");
			rightPressed = true;
		}
		if(code == KeyEvent.VK_S) {
			//System.out.println("s");
			downPressed = true;
		}
		if(code == e.VK_ENTER) {
			//System.out.println("THIS SHIT WORKED");
			enterPressed = true;

		}
		if(code == e.VK_1) {
			stopMusic();
			playMusic(0);
		}
		if(code == e.VK_2) {

			stopMusic();
			playMusic(1);
			
		}
		if(code == e.VK_3) {
			stopMusic();
			playMusic(2);
		}
		if(code == e.VK_4) {
			stopMusic();
			playMusic(3);
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = false;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if(code == KeyEvent.VK_ENTER) {
			enterPressed = false;
		}
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void playMusic(int i) {
		sound.setFile(i); 
		sound.play();
		
	}
	public void stopMusic(){
		
		sound.stop();
	}
	
	

}
