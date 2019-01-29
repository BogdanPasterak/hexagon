package hexagon;

import java.awt.Color;
import java.awt.PaintContext;
import java.awt.Point;
import java.awt.Polygon;

public class Hexagon extends Polygon {
	private Color frame, field;
	// private final int ID;

	public Hexagon(int x, int y, boolean horizontal) {
		super(xArray(x, horizontal), yArray(y, horizontal), 6);
		// ID = i;
		frame = Color.BLACK;
		field = Color.WHITE;
	}

	private static int[] xArray(int x, boolean horizontal) {
		if (horizontal)
			return new int[] { 0 + x, 0 + x, 17 + x, 34 + x, 34 + x, 17 + x };
		else
			return new int[] { 0 + x, 9 + x, 27 + x, 36 + x, 27 + x, 9 + x };
	}

	private static int[] yArray(int y, boolean horizontal) {
		if (horizontal)
			return new int[] { 27 + y, 9 + y, 0 + y, 9 + y, 27 + y, 36 + y };
		else
			return new int[] { 17 + y, 0 + y, 0 + y, 17 + y, 34 + y, 34 + y };

	}

	public Color getFrame() {
		return frame;
	}

	public void setFrame(Color frame) {
		this.frame = frame;
	}

	public Color getField() {
		return field;
	}

	public void setField(Color field) {
		this.field = field;
	}

//	public int getID() {
//		return ID;
//	}
//
	public void turnColor() {
		if (field.equals(Color.WHITE))
			field = Color.GRAY;
		else
			field = Color.WHITE;
	}

}
