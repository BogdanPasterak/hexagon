package hexagon;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;

public class MapList extends ArrayList<Hexagon> implements Serializable{
	private static final long serialVersionUID = 1L;

	public MapList() {
		super();
		int x, y;
		int div = 35;
		for (int i = 0; i < 37 * div; i++) {
			x = (i / div) * 21 + 7;
			y = (i % div) * 24 + (( (i / div) % 2 == 1) ? 12 : 0) + 6;
			if (i == 647) {
				Hexagon me = new Hexagon(x, y, false);
				me.setField(Color.BLACK);
				add(me);
			} else if ((i + 1) % 3 == (i / 70) % 3){
				Hexagon me = new Hexagon(x, y, false);
				me.setField(Color.LIGHT_GRAY);
				add(me);
			} else
				add(new Hexagon(x, y, false));
		}
	}

}
