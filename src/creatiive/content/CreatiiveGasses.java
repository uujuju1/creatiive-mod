package creatiive.content;

import arc.graphics.Color;
import gas.type.Gas;
import mindustry.ctype.ContentList;

public class CreatiiveGasses implements ContentList {
	public static Gas steam;
	@Override
	public void load() {
		steam = new Gas("steam") {{
			color = Color.valueOf("C3C3C3");
		}};
	}
}