package hexagon;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

//custom panel
class ShapePanel extends JPanel {

	private Rectangle bound;
	private Dimension dim = new Dimension(290, 252);
	private final ArrayList<Hexagon> hexagons;

	public ShapePanel() {
		hexagons = new ArrayList<>();
		for (int i = 0; i < 72; i++) {
			hexagons.add(new Hexagon(i));
		}

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				super.mouseClicked(me);
				for (Hexagon h : hexagons) {

					if (h.contains(me.getPoint())) {
						// check if mouse is clicked within shape
						// we can either just print out the object class name
//                      System.out.println("Clicked a hexagon " + h.getID() +
//                      		"   Color " + h.getField());
						h.turnColor();
						bound = h.getBounds();
						update(getGraphics());
					}
				}
			}
		});
	}

	@Override
	public void update(Graphics g) {
		// super.update(g);
		repaint(bound);
	}

	@Override
	protected void paintComponent(Graphics grphcs) {
		super.paintComponent(grphcs);
		Graphics2D g2d = (Graphics2D) grphcs;
		for (Hexagon h : hexagons) {
			g2d.setPaint(h.getField());
			g2d.fill(h);
			g2d.setPaint(h.getFrame());
			g2d.draw(h);
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return dim;
	}
}