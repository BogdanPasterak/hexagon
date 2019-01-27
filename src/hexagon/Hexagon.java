package hexagon;

import java.awt.Color;
import java.awt.PaintContext;
import java.awt.Point;
import java.awt.Polygon;

public class Hexagon extends Polygon {
	private Color frame, field;
	private final int ID;
	

	public Hexagon(int i) {
		super(xArray(i), yArray(i) , 6);
		ID = i;
		frame = Color.BLACK;
		field = Color.WHITE;
	}

	private static int[] xArray(int i) {
		int x = (i % 8) * 34 + (( (i / 8) % 2 == 1) ? 17 : 0);
		return new int[] { 0 + x, 0 + x, 17 + x, 34 + x, 34 + x, 17 + x };
	}

	private static int[] yArray(int i) {
		int y = (i / 8) * 27;
		return new int[] { 27 + y, 9 + y, 0 + y, 9 + y, 27 + y, 36 + y };
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

	public int getID() {
		return ID;
	}

	public void turnColor() {
		if (field.equals(Color.WHITE))
			field = Color.GRAY;
		else
			field = Color.WHITE;
	}

}
