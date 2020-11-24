import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {
	private int diameter;
	private int dx, dy;
	private int xPos, yPos;
	
	public Ball(int d, int cx, int cy, int x, int y) {
		diameter = d;
		dx = cx; dy = cy;
		xPos = x; yPos = y;
	}
	
	public int getTop() {
		return yPos;
	}
	public int getLeft() {
		return xPos;
	}
	public int getBottom() {
		return yPos + diameter;
	}
	public int getRight() {
		return xPos + diameter;
	}
	
	public void DrawBall(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;
		Rectangle2D rect = new Rectangle2D.Double(xPos, yPos, diameter, diameter);
		Ellipse2D ellipse = new Ellipse2D.Double();
		Color color = Color.RED;
		g2.setColor(color);
		ellipse.setFrame(rect);
		g2.draw(ellipse);
	}
	
	public int getDy() {
		return dy;
	}
	public void reverseDirectionX() {
		dx = -dx;
	}
	public void reverseDirectionY() {
		dy = -dy;
	}
	
	public void CalcNextPosition(int width, int height) {
		if (getLeft() <= 0) dx = -dx;
		if (getRight() >= width) dx = -dx;
		if (getTop() <= 0) dy = -dy;
		if (getBottom() >= height) dy = -dy;
		
		xPos += dx;
		yPos += dy;
	}
}
