package hexagon;

import java.awt.Color;
import java.awt.Point;
import java.awt.Polygon;

public class Hexagon extends Polygon {
	Point location;
	Color color;
	private static int xp[] = { 1, 1, 17, 34, 34, 17 };
	private static int yp[] = { 27, 9, 0, 9, 27, 36 };

	public Hexagon (int x, int y) {
		super(	new int[] {0 + x, 0 + x, 17 + x, 34 + x, 34 + x, 17 + x},
				new int[] {27 + y, 9 + y, 0 + y, 9 + y, 27 + y, 36 + y}, 6);
		location = new Point(x, y);
		color = Color.BLACK;
	}

}
