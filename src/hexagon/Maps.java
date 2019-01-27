package hexagon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PaintContext;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Maps extends JFrame {
	JPanel panel;
	JButton btn;
	Shape p;
	List<ShapeInfo> shapes;

	public Maps() {
//		int xp[] = { 0, 0, 26, 52, 52, 26, 0 };
//		int yp[] = { 45, 15, 0, 15, 45, 60, 45 };
		int xp[] = { 0, 0, 17, 34, 34, 17, 0 };
		int yp[] = { 27, 9, 0, 9, 27, 36, 27 };
		int xd = 34;
		int yd = 27;
		p = new Polygon(xp, yp, 6) {
			protected void paintComponent(Graphics g) {
				//super.paintComponent(g);
				Graphics2D g2d = (Graphics2D)g.create();
				
				g2d.translate(50, 30);
				g2d.setColor(Color.BLUE);
				g2d.fill(p);
				g2d.translate(-50, -30);
				
				g2d.dispose();
			}
		
		};

		setSize(350, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Maps");
//		panel = new JPanel() {
//			public void paint(Graphics g) {
//				boolean yb;
//				int xpy;
//				for (int y = 0; y < 9; y++) {
//					yb = y % 2 == 0;
//					xpy = (yb) ? 0: xd / 2;
//					for (int x = 0; x < 8; x++) {
//						for (int i = (x > 0) ? 1: 0; i < 6; i++) {
//							if (y > 0 && (yb && (i == 2 || (i == 1 && x > 0))) || ( !yb && (i == 1 || (i == 2 && x < 7))))
//								continue;
//							g.drawLine(xp[i] + x * xd + xpy, yp[i] + y * yd, xp[i + 1] + x * xd + xpy, yp[i + 1] + y * yd);
//						}					
//					}
//					
//				}
//				// g.drawPolygon(p);
//			}
//		};
//		panel.setBackground(Color.WHITE);
//		panel.setLayout(new FlowLayout());
//		add(panel);
//		btn = new JButton("Press");
//		btn.setPreferredSize(new Dimension(50, 30));
//		add(btn);
		// panel.add(btn);
	}

	public static void main(String[] args) {
		new Maps();
	}

}
