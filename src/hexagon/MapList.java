package hexagon;

import java.awt.Color;
import java.util.ArrayList;

public class MapList extends ArrayList<Hexagon> {
	
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
			} else if (i == 681) {
				Hexagon me = new Hexagon(x, y, false);
				me.setField(Color.PINK);
				add(me);
			} else
				add(new Hexagon(x, y, false));
		}
	}

}
