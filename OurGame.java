import javax.swing.JFrame;

public class OurGame {


public static void main(String[] args) {
// TODO Auto-generated method stub

	JFrame window = new JFrame();
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setResizable(false);
	window.setTitle("game");


	GamePanel gp = new GamePanel();

	window.add(gp);
	gp.GameThread();	
	window.pack();
	window.setLocationRelativeTo(null);
	window.setVisible(true);
}


}
