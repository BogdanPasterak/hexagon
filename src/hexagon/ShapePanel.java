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
	private Dimension dim = new Dimension(290, 253);
	private final BattleFieldList battleField;

	public ShapePanel() {
		battleField = new BattleFieldList();

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				super.mouseClicked(me);
				for (Hexagon h : battleField) {

					if (h.contains(me.getPoint())) {
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
		for (Hexagon h : battleField) {
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