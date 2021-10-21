package creatiive.content;

import creatiive.type.*;

import arc.graphics.Color;
import mindustry.content.*;
import mindustry.ctype.ContentList;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.MultiEffect;
import mindustry.gen.*;
import mindustry.graphics.Pal;
import mindustry.type.*;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.weapons.PointDefenseWeapon;
import mindustry.world.meta.BlockFlag;

import static mindustry.Vars.tilesize;
import static mindustry.content.Bullets.*;

public class CreatiiveUnitTypes implements ContentList {
	public final UnitType
	// copters
	ACopter, BCopter, CCopter, DCopter ECopter;

	public void load() {
		ACopter = new RotorUnitType("ACopter") {{
			localizedName = "Carbine";
			details = "Name by SimpyTav";
			health = 350;
			hitSize = 14;
			speed = 2.5f;
			accel = 0.04f;
			drag = 0.016f;
			faceTarget = flying = true;
			range = 25 * tilesize;
			maxRange = range;
			rotors.add(
				new Rotor(name + "-ARotor") {{
					x = 0f;
					y = 5.25f;
					rotorSpeed = 10;
				}},
				new Rotor(name + "-BRotor") {{
					x = 0f;
					y = -10f;
					rotorSpeed = 11;
				}}
			);
		}};
		BCopter = new RotorUnitType("BCopter") {{
			localizedName = "Blunderbuss";
			details = "Name by SimpyTav";
			health = 630;
			hitSize = 24;
			speed = 2.3f;
			accel = 0.06f;
			drag = 0.024f;
			faceTarget = flying = true;
			range = 30 * tilesize;
			maxRange = range;
			rotors.add(
				new Rotor(name + "-ARotor") {{
					x = y = 0f;
					rotorSpeed = 11;
				}},
				new Rotor(name + "-BRotor") {{
					x = y = 0f;
					rotorSpeed = 12;
				}}
			);
		}};
		CCopter = new RotorUnitType("CCopter") {{
			localizedName = "Culverin";
			details = "Name by SimpyTav";
			health = 1520;
			hitSize = 33;
			speed = 2f;
			accel = 0.08f;
			drag = 0.032f;
			faceTarget = flying = true;
			range = 30 * tilesize;
			maxRange = range;
			rotors.add(
				new Rotor(name + "-ARotor") {{
					x = y = 0f;
					rotorSpeed = 12;
				}},
				new Rotor(name + "-BRotor") {{
					x = y = 0;
					rotorSpeed = 13;
				}}
			);
		}};
		DCopter = new RotorUnitType("DCopter") {{
			localizedName = "Derringer";
			details = "Name by SimpyTav";
			health = 7250;
			hitSize = 35;
			speed = 1.7f;
			accel = 0.1f;
			drag = 0.040f;
			faceTarget = flying = true;
			range = 35 * tilesize;
			maxRange = range;
			rotors.add(
				new Rotor(name + "-ARotor") {{
					x = y = 0f;
					rotorSpeed = 13;
				}},
				new Rotor(name + "-BRotor") {{
					x = y = 0f;
					rotorSpeed = 14;
				}}
			);
		}};
		ECopter = new RotorUnitType("ECopter") {{
			localizedName = "Breechloader";
			details = "Name by SimpyTav";
			health = 13650;
			hitSize = 41;
			speed = 1.5f;
			accel = 0.12f;
			drag = 0.048f;
			faceTarget = flying = true;
			range = 40 * tilesize;
			maxRange = range;
			rotors.add(
				new Rotor(name + "-ARotor") {{
					x = y = 0f;
					rotorSpeed = 14;
				}},
				new Rotor(name + "-BRotor") {{
					x = y = 0f;
					rotorSpeed = 15;
				}}
			);
		}}
	}
}