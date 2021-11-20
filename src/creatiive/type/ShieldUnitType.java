package creatiive.type;

import arc.Core;
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

    // public Color shieldColor = Pal.lancerLaser;
    // public TextureRegion shieldRegion;

	public int reloadTime = 5;
	float rel = 0;
	// float alpha = 0;

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
			// if (rel <= 0) {
				shootType.create(unit, unit.team, unit.x, unit.y, unit.rotation + (Mathf.random(-1, 1) * 45));
				// rel = 5;
			// }
		}
		// if (rel >= 0f) {
			// rel--;
		// }
	}

	/**
	@Override
	public void draw(Unit unit) {
		super.draw(unit);
		Draw.color(shieldColor);
		Draw.alpha(rel/reloadTime);
		Draw.rect(shieldRegion, unit.x, unit.y, unit.rotation);
		Draw.color();
	}

	@Override
	public void load() {
		shieldRegion = Core.atlas.find(name + "-shield");
	}
	*/
}