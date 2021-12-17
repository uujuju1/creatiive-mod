package creatiive.type;

import arc.Core;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.Time;
import mindustry.gen.Unit;

public class DrawRotor {
	public final String name;
	public TextureRegion rotorRegion, jointRegion;

	public float x = 0;
	public float y = 0;
	public float rotorSpeed = 15;

	float speedMultiplier = 0f;

	public DrawRotor(String name) {
		this.name = name;
	}

	public void load() {
		rotorRegion = Core.atlas.find(name);
		jointRegion = Core.atlas.find(name + "-joint");
	}

	public void draw(Unit unit) {
		float speedMultiplier = 0f;
		
		if (unit.isFlying()) {
			speedMultiplier = 1f;
		}
		if (!unit.isFlying()) {
			speedMultiplier = 0f;
		}

		float speedScl = rotorSpeed * speedMultiplier;
		float rotorX = unit.x + Angles.trnsx(unit.rotation - 90, x, y);
		float rotorY = unit.y + Angles.trnsy(unit.rotation - 90, x, y);

		
		if (unit.health <= 0 || unit.dead) {
			speedScl = rotorSpeed/2;			
		}

		Draw.rect(rotorRegion, rotorX, rotorY, Time.time * speedScl + unit.rotation);
		Draw.rect(jointRegion, rotorX, rotorY, unit.rotation - 90);
	}
}