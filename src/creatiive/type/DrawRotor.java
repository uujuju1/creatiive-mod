package creatiive.type;

import arc.Core;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.Time;
import mindustry.gen.Unit;

public class DrawRotor {
	public final String rotorName;
	public TextureRegion rotorRegion, topRegion;

	public float x = 0;
	public float y = 0;
	public float rotorSpeed = 15;

	public DrawRotor(String name) {
	}

	public void load() {
		rotorRegion = Core.atlas.find(rotorName);
		rotorRegion = Core.atlas.find(rotorName + "-top");
	}

	public void draw(Unit unit) {
		float speedScl = rotorSpeed;
		float rotorX = unit.x + Angles.trnsx(unit.rotation - 90, x, y);
		float rotorY = unit.y + Angles.trnsy(unit.rotation - 90, x, y);

		if (unit.health <= 0 || unit.dead) {
			speedScl = rotorSpeed/2;			
		}
		Draw.rect(rotorRegion, rotorX, rotorY, Time.time * speedScl);
	}
}