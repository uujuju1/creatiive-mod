package creatiive.content;

import arc.graphics.*;
import mindustry.type.*;
import mindustry.ctype.*;

public class CreatiiveLiquids implements ContentList {
	public static Liquid steam, fissileFuel;

	@Override
	public void load() {
		steam = new Liquid("steam", Color.valueOf("C3C3C3")) {{
			localizedName = "Steam";
		}};
		fissileFuel = new Liquid("fissileFuel" Color.valueOf("565E59")) {{
			localizedName = "Fissile Fuel";
			explosiveness = 1f;
		}};
	}
}