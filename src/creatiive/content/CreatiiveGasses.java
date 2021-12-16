package creatiive.content;

import arc.graphics.Color;
import gas.type.Gas;
import mindustry.ctype.ContentList;

public class CreatiiveGasses implements ContentList {
	public static Gas steam, fissileFuel;

	@Override
	public void load() {
		steam = new Gas("steam") {{
			localizedName = "Steam";
			color = Color.valueOf("C3C3C3");
		}};
		fissileFuel = new Gas("fissile-fuel") {{
			localizedName = "Fissile Fuel";
			color = Color.valueOf("565E59");
			radioactivity = 0.5f;
		}};
	}
}