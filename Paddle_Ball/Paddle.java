import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Paddle {
	private int length;
	private int xPos;
	private int yPos;
	
	public Paddle(int len, int x, int y) {
		length = len;
		xPos = x;
		yPos = y;
	}
	
	public void DrawPaddle(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		Color color = Color.WHITE;
		g2.setColor(color);
		g2.fillRect(xPos - length / 2, yPos, length, 5);
	}
	
	public int getTop() {
		return yPos;
	}
	public int getLeft() {
		return xPos - length / 2;
	}
	public int getBottom() {
		return yPos + 5;
	}
	public int getRight() {
		return xPos + length / 2;
	}

	public void UpdatePosition(int mouse_x_pos, int width) {
		xPos = mouse_x_pos;
		if (xPos - length / 2 < 0)
			xPos = length / 2;
		if (xPos + length / 2 > width)
			xPos = width - length / 2;
	}
}
