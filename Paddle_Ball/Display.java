import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Display extends JPanel {
	private Controller controller;
	
	public Display(int width, int height) {
		this.setSize(width, height);
		this.setLayout(null);
	}
	
	public void SetController(Controller ctrl) {
		controller = ctrl;		
	}
	
	@Override
    public void paint(Graphics graphics) {
        super.paint(graphics);

        controller.draw(graphics);
    }
	
	public void drawBackgroud(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		Color color = Color.BLACK;
		g2.setColor(color);
		g2.fillRect(0, 0, getWidth(), getHeight());		
	}
}
