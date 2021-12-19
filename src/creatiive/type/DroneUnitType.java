package creatiive.type;

import arc.math.*;
import arc.util.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import mindustry.gen.*;
import mindustry.type.*;

public class DroneUnitType extends UnitType {
	public int flameDamage = 1;
	public float flameSize = 2.5f;
	public float flameOffset = hitSize;
	public DroneUnitType(String name) {
		super(name);
		flying = lowAltitude = true;
		constructor = UnitEntity::create;
	}

	@Override
	public void drawEngine(Unit unit) {
		if (!unit.isFlying()) return;
		for (int i = 0; i >= 4; i++) {
			float flameX = unit.x + Angles.trnsx(unit.rotation - 90f + (i * 45f), unit.x, unit.y + flameOffset);
			float flameY = unit.y + Angles.trnsy(unit.rotation - 90f + (i * 45f), unit.x, unit.y + flameOffset);
			Draw.color(unit.team.color);
			Fill.circle(flameX, flameY, flameSize + Mathf.absin(Time.time, 2f, engineSize / 4f));
			Draw.color(Color.white);
			Fill.circle(flameX, flameY, flameSize + Mathf.absin(Time.time, 2f, engineSize / 4f) / 2);
			Draw.color();
		}
	}
}