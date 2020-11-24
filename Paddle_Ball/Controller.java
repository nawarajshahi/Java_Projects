import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.Timer;

import javax.swing.JFrame;

public class Controller implements ActionListener, MouseMotionListener {
	private Display display;
	private Ball ball;
	private Paddle paddle;
	private JFrame mainFrame;
	private Timer timer;
	
	public Controller(JFrame frame) {
		display = new Display(800, 600);
		ball = new Ball(10, 1, 1, 100, 100);
		paddle = new Paddle(50, 300, 500);
		timer = new Timer(5, this);
		
		mainFrame = frame;
		
		display.addMouseMotionListener(this);
		mainFrame.add(display);
	}
	
	public void play() {
		display.SetController(this);
		timer.start();
	}

	public void draw(Graphics g) {
		display.drawBackgroud(g);
		ball.DrawBall(g);
		paddle.DrawPaddle(g);		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (ball.getBottom() <= paddle.getTop() && ball.getBottom() + ball.getDy() > paddle.getTop()) {
			if (ball.getRight() >= paddle.getLeft() && ball.getLeft() <= paddle.getRight()) {
				ball.reverseDirectionY();
			}
		}
		
		ball.CalcNextPosition(display.getWidth(), display.getHeight());
		display.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		paddle.UpdatePosition(e.getX(), display.getWidth());
	}
}
