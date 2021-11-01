package creatiive.type;

import arc.graphics.g2d.Draw;
import arc.struct.Seq;
import arc.util.Time;
import mindustry.gen.*;
import mindustry.type.UnitType;

public class HydronavalUnitType extends UnitType {
	public final Seq<DrawRotor> rotor = new Seq<>();

	public HydronavalUnitType(String name) {
		super(name);
		canBoost = lowAltitude = true;
		constructor = UnitEntity::create;
		engineSize = 0f;
	}

	@Override
	public void draw(Unit unit) {
		super.draw(unit);
		applyColor(unit);
		rotor.each(DrawRotor -> DrawRotor.draw(unit));
	}

	@Override
	public void load() {
		super.load();
		rotor.each(DrawRotor::load());
	}
}
