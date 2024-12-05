//Anchal Patel 

import javax.swing.*;
import java.awt.*;
public class SierpinskiTriangle extends JPanel{
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Sierpinski Triangle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		
		SierpinskiTriangle panel = new SierpinskiTriangle();
		frame.add(panel);
		frame.setVisible(true);
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int[] xPoints = {400, 50, 750};
		int[] yPoints = {50, 700, 700};
		
		drawTriangle(g, xPoints, yPoints, 4);
	}
	
	private void drawTriangle(Graphics g, int[] xPoints, int[] yPoints, int limit)
	{
		int sideLength = xPoints[2] - xPoints[1];
		if(sideLength < limit)
		{
			return;
		}
		
		g.fillPolygon(xPoints, yPoints, 3);
		int midX1 = (xPoints[0] + xPoints[1]) / 2;
		int midY1 = (yPoints[0] + yPoints[1]) / 2;
		int midX2 = (xPoints[1] + xPoints[2]) / 2;
		int midY2 = (yPoints[1] + yPoints[2]) / 2; 
		int midX3 = (xPoints[2] + xPoints[0]) / 2;
		int midY3 = (yPoints[2] + yPoints[0]) / 2;
		
		drawTriangle(g, new int[] {xPoints[0], midX1, midX3}, new int [] {yPoints[0], midY1, midY3}, limit);
		drawTriangle(g, new int[] {midX1, xPoints[1], midX2}, new int [] {midY1, yPoints[1], midY2}, limit);
		drawTriangle(g, new int[] {midX3, midX2, xPoints[2]}, new int [] {midY3, midY2, yPoints[2]}, limit);
		
		g.setColor(Color.WHITE);
		g.fillPolygon(new int[] {midX1, midX2, midX3}, new int[] {midY1, midY2, midY3}, 3);
		g.setColor(Color.BLACK);
		
		
	}

}
