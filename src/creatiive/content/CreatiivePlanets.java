package creatiive.content;

import arc.graphics.*;
import mindustry.ctype.*;
import mindustry.graphics.g3d.*;
import mindustry.type.*;
import mindustry.content.*;

import creatiive.maps.planet.*;

public class CreatiivePlanets implements ContentList {
	public static Planet scaler, vuintuer, krus;

	@Override
	public void load() {
		scaler = new Planet("scaler", Planets.sun, 2, 0.87f) {{
			localizedName = "Scaler";
			generator = new ScalerPlanetGenerator();
			meshLoader = () -> new HexMesh(this, 6);
			atmosphereColor = Color.valueOf("ff7a38");
			atmosphereRadIn = 0.02f;
			atmosphereRadOut = 0.15f;
			startSector = 15;
			alwaysUnlocked = true;
		}};
		vuintuer = new Planet("vuintuer", Planets.sun, 2, 0.90f) {{
			localizedName = "Vuintuer";
			generator = new VuintuerPlanetGenerator();
			meshLoader = () -> new HexMesh(this, 6);
			hasAtmosphere = false;
			alwaysUnlocked = true;
			orbitRadius = 100f;
		}};
		krus = new Planet("krus", Planets.sun, 1, 0.75f) {{
			localizedName = "Krus";
			generator = new KrusPlanetGenerator();
			meshLoader = () -> new HexMesh(this, 6);
			atmosphereColor = Color.valueOf("5FB2C9");
			atmosphereRadIn = 0.02f;
			atmosphereRadOut = 0.15f;
			startSector = 69;
			alwaysUnlocked = true;
		}};
	}
}