package hexagon;

import java.util.ArrayList;

public class BattleFieldList extends ArrayList<Hexagon> {

	public BattleFieldList() {
		super();
		int x, y;
		for (int i = 0; i < 72; i++) {
			x = (i % 8) * 34 + (( (i / 8) % 2 == 1) ? 17 : 0);
			y = (i / 8) * 27;
			add(new Hexagon(x, y, true));
		}
	}
	

}
