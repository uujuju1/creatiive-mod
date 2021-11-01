package creatiive.content;

import creatiive.type.*;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import arc.graphics.Color;
import mindustry.ai.types.*;
import mindustry.ctype.*;
import mindustry.ctype.ContentList;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.*;
import mindustry.entities.effect.MultiEffect;
import mindustry.graphics.Pal;
import mindustry.type.ammo.ItemAmmoType;
import mindustry.type.weapons.PointDefenseWeapon;
import mindustry.world.meta.BlockFlag;

import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;
import static mindustry.Vars.tilesize;
import static mindustry.content.Bullets.*;

public class CreatiiveUnitTypes implements ContentList {
	// flying
	public static UnitType ACopter, BCopter, CCopter, DCopter, ECopter,
	
	// dust navals
	silver, gold, platinum;

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
				new DrawRotor(name + "-ARotor") {{
					x = 0f;
					y = 5.25f;
					rotorSpeed = 10;
				}},
				new DrawRotor(name + "-BRotor") {{
					x = 0f;
					y = -10f;
					rotorSpeed = 11;
				}}
			);

			weapons.add(
				new Weapon("creatiive-weapon-copter-basic") {{
					x = 5f;
					y = 6f;
					reload = 10f;
					mirror = true;
					recoil = 1f;
					maxRange = range;
					bullet = new BasicBulletType(6f, 15) {{
						width = 7f;
						height = 12f;
						lifetime = range/speed;
					}};
				}},
				new Weapon("creatiive-weapon-copter-basic") {{
					x = 3f;
					y = 8f;
					reload = 10f;
					mirror = true;
					recoil = 1f;
					bullet = new BasicBulletType(6f, 15) {{
						width = 7f;
						height = 12f;
						lifetime = range/speed;
					}};
				}},
				new Weapon("creatiive-weapon-copter-missile") {{
					x = 5f;
					y = -1f;
					reload = 30f;
					mirror = true;
					recoil = 1.5f;
					maxRange = range + 16f;
					bullet = new MissileBulletType(4f, 35) {{
						width = 8f;
						height = 13f;
						lifetime = range/speed + 16f;
					}};
				}}
			);
		}};


		BCopter = new RotorUnitType("BCopter") {{
			localizedName = "Blunderbuss";
			details = "Name by SimpyTav";
			health = 630;
			hitSize = 20;
			speed = 2.3f;
			accel = 0.06f;
			drag = 0.024f;
			faceTarget = flying = true;
			range = 30 * tilesize;
			maxRange = range;

			rotors.add(
				new DrawRotor(name + "-ARotor") {{
					x = 0f;
					y = 3.25f;
					rotorSpeed = 11;
				}},
				new DrawRotor(name + "-BRotor") {{
					x = 0f;
					y = -9.5f;
					rotorSpeed = 12;
				}}
			);

			weapons.add(
				new Weapon("creatiive-weapon-copter-missile") {{
					x = 6f;
					y = 8f;
					reload = 30f;
					mirror = true;
					recoil = 1.5f;
					maxRange = range + 16f;
					bullet = new MissileBulletType(4f, 57) {{
						width = 8f;
						height = 13f;
						lifetime = range/speed + 16f;
					}};
				}},
				new Weapon("creatiive-weapon-copter-missile") {{
					x = 4f;
					y = 4f;
					reload = 30f;
					mirror = true;
					recoil = 1.5f;
					maxRange = range + 16f;
					bullet = new MissileBulletType(4f, 57) {{
						width = 8f;
						height = 13f;
						lifetime = range/speed + 16f;
					}};
				}},
				new Weapon("creatiive-weapon-copter-basic") {{
					x = 6f;
					y = -1f;
					reload = 10f;
					mirror = true;
					recoil = 1f;
					maxRange = range;
					bullet = new BasicBulletType(6f, 30) {{
						width = 7f;
						height = 12f;
						lifetime = range/speed;
					}};
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
				new DrawRotor(name + "-ARotor") {{
					x = 0f;
					y = 7.5f;
					rotorSpeed = 12;
				}},
				new DrawRotor(name + "-BRotor") {{
					x = 0f;
					y = -18f;
					rotorSpeed = 13;
				}}
			);

			weapons.add(
				new Weapon("creatiive-weapon-copter-artilleryB") {{
					x = 8f;
					y = 8f;
					mirror = true;
					reload = 15f;
					recoil = 1f;
					bullet = new ArtilleryBulletType(8f, 78) {{
						width = 11f;
						height = 15f;
						lifetime = range/speed;
						splashDamageRadius = 25f;
	            		splashDamage = 33f;
					}};
				}},
				new Weapon("creatiive-weapon-copter-artilleryM") {{
					x = 6.75f;
					y = -4f;
					mirror = true;
					reload = 20f;
					recoil = 1f;
					bullet = new ArtilleryBulletType(8f, 80) {{
						width = 11f;
						height = 15f;
						lifetime = range/speed;
						splashDamageRadius = 25f;
	            		splashDamage = 80f;
    	    	    	homingPower = 0.02f;
        		    	homingRange = 50f;
					}};
				}}
			);
		}};


		DCopter = new RotorUnitType("DCopter") {{
			localizedName = "Derringer";
			details = "Name by SimpyTav";
			health = 7250;
			hitSize = 39;
			speed = 1.7f;
			accel = 0.1f;
			drag = 0.040f;
			faceTarget = flying = true;
			range = 35 * tilesize;
			maxRange = range;

			rotors.add(
				new DrawRotor(name + "-ARotor") {{
					x = 0f;
					y = 10f;
					rotorSpeed = 13;
				}},
				new DrawRotor(name + "-BRotor") {{
					x = 0f;
					y = -16f;
					rotorSpeed = 14;
				}}
			);

			weapons.add(
				new Weapon("creatiive-weapon-copter-basicP") {{
					x = 11f;
					y = -11f;
					reload = 10f;
					recoil = 2f;
					bullet = new BasicBulletType(6f, 120) {{
						width = 12f;
						height = 16f;
						lifetime = range/speed;
						pierce = true;
						pierceCap = 10;
					}};
				}}
			);
		}};

		
		ECopter = new RotorUnitType("ECopter") {{
			localizedName = "Breechloader";
			details = "Name by SimpyTav";
			health = 13650;
			hitSize = 44;
			speed = 1.5f;
			accel = 0.12f;
			drag = 0.048f;
			faceTarget = flying = true;
			range = 40 * tilesize;
			maxRange = range;

			rotors.add(
				new DrawRotor(name + "-ARotor") {{
					x = 0f;
					y = 18f;
					rotorSpeed = 14;
				}},
				new DrawRotor(name + "-BRotor") {{
					x = 0f;
					y = -20f;
					rotorSpeed = 15;
				}}
			);

			weapons.add(
				new Weapon("creatiive-weapon-copter-missileP") {{
					x = 14f;
					y = -12f;
					reload = 10f;
					recoil = 2f;
					bullet = new MissileBulletType(6f, 195) {{
						width = 12f;
						height = 16f;
						lifetime = range/speed;
						pierce = true;
						pierceCap = 10;
					}};
				}}
			);
		}};

		silver = new RotorUnitType("silver") {{
			localizedName = "Silver";
			canBoost = true;
			flying = false;
			constructor = UnitWaterMove::create;
			speed = 1.1f;
            drag = 0.13f;
            hitSize = 10f;
            health = 280;
            accel = 0.4f;
            rotateSpeed = 3.3f;
            trailLength = 20;
            rotateShooting = false;

            rotors.add(
            	new DrawRotor(name + "-rotor") {{
            		x = y = 0f;
            		rotorSpeed = 15f;
            	}}
            );
		}};

		gold = new RotorUnitType("gold") {{
			localizedName = "Gold";
			canBoost = false;
			flying = false;
			constructor = UnitWaterMove::create;
			health = 560;
            speed = 0.83f;
            drag = 0.14f;
            hitSize = 14f;
            armor = 4f;
            accel = 0.4f;
            rotateSpeed = 4f;
            rotateShooting = false;

            trailLength = 22;
            trailX = 5.5f;
            trailY = -4f;
            trailScl = 1.9f;

            rotors.add(
            	new DrawRotor(name + "-rotor") {{
            		x = y = 0f;
            		rotorSpeed = 15f;
            	}}
            );
		}};

		platinum = new RotorUnitType("platinum") {{
			localizedName = "Platinum";
			canBoost = true;
			flying = false;
			constructor = UnitWaterMove::create;
			health = 870;
            speed = 0.86f;
            accel = 0.22f;
            rotateSpeed = 2.6f;
            drag = 0.16f;
            hitSize = 20f;
            armor = 6f;
            rotateShooting = false;

            trailLength = 23;
            trailX = 9f;
            trailY = -9f;
            trailScl = 2f;

            rotors.add(
            	new DrawRotor(name + "-rotor") {{
            		x = y = 0f;
            		rotorSpeed = 15f;
            	}}
            );
		}};
	}
}