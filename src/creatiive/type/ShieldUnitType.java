package creatiive.type;

import arc.*;
import arc.math.*;
import arc.math.geom.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.Seq;
import arc.util.Time;
import mindustry.gen.*;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.type.UnitType;
import mindustry.entities.*;
import mindustry.entities.bullet.*;

public class ShieldUnitType extends UnitType {
	public BulletType shootType = Bullets.standardCopper;

	public ShieldUnitType(String name) {
		super(name);
		flying = true;
		constructor = UnitEntity::create;
	}

	@Override
	public void update(Unit unit) {
		float x = unit.vel.x;
		float y = unit.vel.y;
		if (Math.abs(x) >= 2.5f || Math.abs(y) >= 2.5f) {
				shootType.create(unit, unit.team, unit.x, unit.y, unit.rotation - 22.5f + (Mathf.random() * 45f));
		}
	}
}