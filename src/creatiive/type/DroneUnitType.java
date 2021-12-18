package creatiive.type;

import mindustry.gen.*;
import mindustry.type.*;

public class DroneUnitType extends UnitType {
	public int flameDamage = 1;
	public DroneUnitType(String name) {
		super(name);
		flying = lowAltitude = true;
		constructor = UnitEntity::create;
	}
}