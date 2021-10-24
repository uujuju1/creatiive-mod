package creatiive.content;

import arc.graphics.*;
import mindustry.ctype.*;
import mindustry.graphics.g3d.*;
import mindustry.type.*;
import mindustry.content.*;

import creatiive.maps.planet.*;

public class CreatiivePlanets implements ContentList {
	public static Planet scaler;

	@Override
	public void load() {
		scaler = new Planet("scaler", Planets.sun, 2, 0.87f) {{
			generator = new ScalerPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 6);
            atmosphereColor = Color.valueOf("ff7a38");
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            startSector = 15;
            alwaysUnlocked = true;
		}};
	}
}