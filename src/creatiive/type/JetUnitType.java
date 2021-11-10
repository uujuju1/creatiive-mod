package creatiive.type;

import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.Seq;
import arc.util.Time;
import mindustry.gen.*;
import mindustry.type.UnitType;

// Based of sentries

public class JetUnitType extends UnitType {
	public float engineX = 0f;
	public float engineY = 0f;

	public JetUnitType(String name) {
		super(name);
		flying = lowAltitude = true;
		constructor = UnitWaterMove::create;
		fallSpeed = 0.005f;
	}

	@Override
	public void drawEngine(Unit unit) {
		if (!unit.isFlying()) return;

		float scal = unit.elevation;
		float offset = engineOffset * scale;

		Draw.color(unit.team.color);
		Fill.circle(
			unit.x + Angles.trnsx(unit.rotation + 180, engineX, engineY),
			unit.y + Angles.trnsy(unit.rotation + 180, engineX, engineY),
			(engineSize + Mathf.absin(Time.time, 2f, engineSize / 4f)) * scale
		);
		Draw.color(Color.white);
		Fill.circle(
			unit.x + Angles.trnsx(unit.rotation + 180, engineX, engineY),
			unit.y + Angles.trnsy(unit.rotation + 180, engineX, engineY),
			(engineSize + Mathf.absin(Time.time, 2f, engineSize / 4f)) / 2f * scale
		);

		Draw.color(unit.team.color);
		Fill.circle(
			unit.x + Angles.trnsx(unit.rotation + 180, -engineX, engineY),
			unit.y + Angles.trnsy(unit.rotation + 180, -engineX, engineY),
			(engineSize + Mathf.absin(Time.time, 2f, engineSize / 4f)) * scale
		);
		Draw.color(Color.white);
		Fill.circle(
			unit.x + Angles.trnsx(unit.rotation + 180, -engineX, engineY),
			unit.y + Angles.trnsy(unit.rotation + 180, -engineX, engineY),
			(engineSize + Mathf.absin(Time.time, 2f, engineSize / 4f)) / 2f * scale
		);
		Draw.color();
	}
}