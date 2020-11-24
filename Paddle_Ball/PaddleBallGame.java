import javax.swing.JFrame;

public class PaddleBallGame {
	public static void main(String args[]) {
		JFrame mainFrame = new JFrame("PaddleBallGame");
		JFrame.setDefaultLookAndFeelDecorated(true);
		mainFrame.setSize(900, 800);
		
		mainFrame.setVisible(true);
		
		Controller con = new Controller(mainFrame);
		con.play();
	}
}
