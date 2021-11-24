package creatiive.content;

import creatiive.type.*;
import creatiive.graphics.*;
import creatiive.entities.bullet.*;

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

public class CreatiiveUnitDust implements ContentList {
	public static UnitType 
	silver, gold, platinum, iridium, tenelite,
	arcana, monoquone, zelinote, kepsylon, zernite;

	@Override public void load() {
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
            range = 160f;
            maxRange = range;

            immunities = ObjectSet.with(StatusEffects.burning, StatusEffects.melting);

            rotors.add(
            	new DrawRotor(name + "-rotor") {{
            		x = y = 0f;
            		rotorSpeed = 15f;
            	}}
            );

            weapons.add(
            	new Weapon("creatiive-weapon-dust-anti_air") {{
            		x = 4.5f;
            		y = 0f;
            		reload = 10f;
            		rotate = true;
            		rotateSpeed = 5f;
            		recoil = 1f;
            		bullet = new BasicBulletType(4f, 15) {{
            			lifetime = range/speed;
            			width = 6f;
            			height = 8f;
            			collidesGround = false;
            			collidesAir = true;
            		}};
            	}},

            	new Weapon("creatiive-weapon-dust-torpedo") {{
            		x = 0f;
            		y = -3f;
            		reload = 60f;
            		rotate = true;
            		rotateSpeed = 4f;
            		recoil = 2f;
            		mirror = true;
            		bullet = new WaterMissileBulletType(4f, 45f) {{
            			lifetime = range/speed;
            		}};
            	}}
            );
		}};

		gold = new RotorUnitType("gold") {{
			localizedName = "Gold";
			canBoost = true;
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
            range = 240;
            maxRange = range;

            immunities = ObjectSet.with(StatusEffects.burning, StatusEffects.melting);

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

            weapons.add(
            	new Weapon("creatiive-weapon-dust-torpedobig") {{
            		x = 4.5f;
            		y = -3f;
            		reload = 60f;
            		mirror = true;
            		recoil = 2f;
            		rotate = true;
            		rotateSpeed = 3.7f;
            		bullet = new WaterMissileBulletType(4f, 150f) {{
            			lifetime = range/speed + 80;
            			size = 2f;
            		}};
            	}},
            	new Weapon("creatiive-weapon-dust-machinegun") {{
            		x = 7f;
            		y = 2f;
            		rotate = true;
            		mirror = true;
            		reload = 20f;
            		recoil = 2f;
            		rotateSpeed = 4f;
            		bullet = new BasicBulletType(6f, 45) {{
            			lifetime = range/speed;
            			width = 9f;
            			height = 11f;
            		}};
            	}},
            	new Weapon("creatiive-weapon-dust-anti_air") {{
            		x = 2f;
            		y = 5f;
            		reload = 10f;
            		rotate = true;
            		rotateSpeed = 5f;
            		recoil = 1f;
            		bullet = new BasicBulletType(4f, 15) {{
            			lifetime = range/speed;
            			width = 6f;
            			height = 8f;
            			collidesGround = false;
            			collidesAir = true;
            		}};
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
            range = 8f * 40f;
            maxRange = range;

            immunities = ObjectSet.with(StatusEffects.burning, StatusEffects.melting);

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

            weapons.add(
            	new Weapon("creatiive-weapon-dust-torpedobig") {{
            		x = 6f;
            		y = -7f;
            		reload = 60f;
            		mirror = true;
            		recoil = 2f;
            		rotate = true;
            		rotateSpeed = 3.7f;
            		bullet = new WaterMissileBulletType(4f, 250f) {{
            			lifetime = range/speed + 80;
            			size = 2f;
            		}};
            	}},

            	new Weapon("creatiive-weapon-dust-torpedo") {{
            		x = 7f;
            		y = 1f;
            		reload = 60f;
            		rotate = true;
            		rotateSpeed = 4f;
            		recoil = 2f;
            		mirror = true;
            		bullet = new WaterMissileBulletType(4f, 125f) {{
            			lifetime = range/speed;
            		}};
            	}},
            	
            	new Weapon("creatiive-weapon-dust-anti_air") {{
            		x = 8f;
            		y = 8f;
            		reload = 10f;
            		rotate = true;
            		rotateSpeed = 5f;
            		recoil = 1f;
            		bullet = new BasicBulletType(4f, 33) {{
            			lifetime = range/speed;
            			width = 6f;
            			height = 8f;
            			collidesGround = false;
            			collidesAir = true;
            		}};
            	}},

            	new Weapon("creatiive-weapon-dust-machinegun") {{
            		x = 2f;
            		y = 13f;
            		reload = 10f;
            		rotate = true;
            		rotateSpeed = 5f;
            		recoil = 1f;
            		bullet = new BasicBulletType(4f, 50) {{
            			lifetime = range/speed;
            			width = 8f;
            			height = 10f;
            		}};
            	}}
            );
		}};

		iridium = new RotorUnitType("iridium") {{
			localizedName = "Iridium";
			canBoost = true;
			flying = false;
			health = 11000;
            armor = 12f;
            constructor = UnitWaterMove::create;
            speed = 0.73f;
            drag = 0.17f;
            hitSize = 39f;
            accel = 0.2f;
            rotateSpeed = 1.3f;
            rotateShooting = false;
            range = 360f;
            maxRange = range;

            immunities = ObjectSet.with(StatusEffects.burning, StatusEffects.melting);

            trailLength = 50;
            trailX = 18f;
            trailY = -21f;
            trailScl = 3f;

            rotors.add(
            	new DrawRotor(name + "-rotor") {{
            		x = y = 0f;
            		rotorSpeed = 15f;
            	}}
            );

            weapons.add(
            	new Weapon("creatiive-weapon-dust-torpedomine") {{
            		x = 12f;
            		y = -6f;
            		reload = 90f;
            		mirror = true;
            		recoil = 3f;
            		rotate = true;
            		rotateSpeed = 3.7f;
            		bullet = new ArtilleryBulletType(4f, 15f) {{
            			hitEffect = Fx.blastExplosion;
                    	lifetime = range/speed + 10f;
                    	width = height = 14f;
                    	splashDamageRadius = 30f;
                    	splashDamage = 60f;
                    	fragBullets = 4;
                    	fragBullet = new WaterMissileBulletType(4f, 350f) {{
            				lifetime = range/speed + 60f;
            			}};
            		}};
            	}},
				new Weapon("creatiive-weapon-dust-anti_airbig") {{
            		x = 0f;
            		y = 15f;
            		reload = 10f;
            		mirror = false;
            		recoil = 3f;
            		rotate = true;
            		rotateSpeed = 3.7f;
            		bullet = new ArtilleryBulletType(4f, 150f) {{
                    	lifetime = range/speed + 10f;
                    	width = 7f;
                    	height = 9f;
                    	splashDamageRadius = 30f;
                    	splashDamage = 60f;
                    	collidesGround = false;
                    	collidesAir = true;
                    	collides = true;
                    	fragBullets = 4;
                    	fragBullet = new BasicBulletType(1f, 70f) {{
            				lifetime = 10f;
                    		width = 5f;
                    		height = 7f;
                    		splashDamageRadius = 15f;
                    		splashDamage = 30f;
            			}};
            		}};
            	}}
            );
		}};

		tenelite = new RotorUnitType("tenelite") {{
			localizedName = "Tenelite";
			health = 22000;
			canBoost = true;
			flying = false;
            speed = 0.62f;
            drag = 0.18f;
            hitSize = 58f;
            armor = 16f;
            accel = 0.19f;
            rotateSpeed = 0.9f;
            rotateShooting = false;
            constructor = UnitWaterMove::create;
            range = 400f;
            maxRange = range;

            float spawnTime = 60f * 15f;
            immunities = ObjectSet.with(StatusEffects.burning, StatusEffects.melting);
            abilities.add(new ForceFieldAbility(140f, 4f, 7000f, 60f * 8));

            trailLength = 70;
            trailX = 23f;
            trailY = -32f;
            trailScl = 3.5f;

            rotors.add(
            	new DrawRotor(name + "-rotor") {{
            		x = y = 0f;
            		rotorSpeed = 15f;
            	}}
            );

            weapons.add(
            	new Weapon("creatiive-weapon-dust-anti_airbig") {{
            		x = 15f;
            		y = 12f;
            		reload = 10f;
            		mirror = true;
            		recoil = 3f;
            		rotate = true;
            		rotateSpeed = 3.7f;
            		bullet = new ArtilleryBulletType(4f, 150f) {{
                    	lifetime = range/speed + 10f;
                    	width = 7f;
                    	height = 9f;
                    	splashDamageRadius = 30f;
                    	splashDamage = 60f;
                    	collidesGround = false;
                    	collidesAir = true;
                    	collides = true;
                    	fragBullets = 4;
                    	fragBullet = new BasicBulletType(1f, 70f) {{
            				lifetime = 10f;
                    		width = 5f;
                    		height = 7f;
                    		splashDamageRadius = 15f;
                    		splashDamage = 30f;
            			}};
            		}};
            	}},
            	new Weapon("creatiive-weapon-dust-anti_airbig") {{
            		x = 24f;
            		y = 2f;
            		reload = 10f;
            		mirror = true;
            		recoil = 3f;
            		rotate = true;
            		rotateSpeed = 3.7f;
            		bullet = new ArtilleryBulletType(4f, 150f) {{
                    	lifetime = range/speed + 10f;
                    	width = 7f;
                    	height = 9f;
                    	splashDamageRadius = 30f;
                    	splashDamage = 60f;
                    	collidesGround = false;
                    	collidesAir = true;
                    	collides = true;
                    	fragBullets = 4;
                    	fragBullet = new BasicBulletType(1f, 70f) {{
            				lifetime = 10f;
                    		width = 5f;
                    		height = 7f;
                    		splashDamageRadius = 15f;
                    		splashDamage = 30f;
            			}};
            		}};
            	}},
            	new Weapon("creatiive-weapon-dust-torpedomine") {{
            		x = 14f;
            		y = -10f;
            		reload = 90f;
            		mirror = true;
            		recoil = 3f;
            		rotate = true;
            		rotateSpeed = 3.7f;
            		bullet = new ArtilleryBulletType(4f, 15f) {{
            			hitEffect = Fx.blastExplosion;
                    	lifetime = range/speed + 10f;
                    	width = height = 14f;
                    	splashDamageRadius = 30f;
                    	splashDamage = 60f;
                    	fragBullets = 4;
                    	fragBullet = new WaterMissileBulletType(4f, 450f) {{
            				lifetime = range/speed + 60f;
            				size = 2f;
            			}};
            		}};
            	}},
            	new Weapon("creatiive-weapon-dust-torpedomine") {{
            		x = 4f;
            		y = -18f;
            		reload = 90f;
            		mirror = true;
            		recoil = 3f;
            		rotate = true;
            		rotateSpeed = 3.7f;
            		bullet = new ArtilleryBulletType(4f, 15f) {{
            			hitEffect = Fx.blastExplosion;
                    	lifetime = range/speed + 10f;
                    	width = height = 14f;
                    	splashDamageRadius = 30f;
                    	splashDamage = 60f;
                    	fragBullets = 4;
                    	fragBullet = new WaterMissileBulletType(4f, 450f) {{
            				lifetime = range/speed + 60f;
            			}};
            		}};
            	}}
            );
		}};

		// jets
		arcana = new JetUnitType("arcana") {{
			localizedName = "Arcana";
			health = 350;
			speed = 3f;
			accel = 0.06f;
            drag = 0.048f;
            engineX = 2.25f;
            engineY = -5.5f;
            range = 136f;
            rotateSpeed = 3.5f;
            rotateShooting = false;
            maxRange = range;

            weapons.add(
            	new Weapon("creatiive-weapon-jet-heal") {{
            		x = 3.75f;
            		y = -2f;
            		reload = 30f;
            		mirror = true;
            		rotate = true;
            		rotateSpeed = 3f;
            		bullet = new LaserBoltBulletType(4f, 7){{
                    	lifetime = range/speed;
                    	healPercent = 5.5f;
                   		collidesTeam = true;
                    	backColor = Pal.heal;
                    	frontColor = Color.white;
                	}};
            	}},
            	new RepairBeamWeapon("creatiive-weapon-jet-repairBeam") {{
            		x = 0f;
            		y = -1f;
            		beamWidth = 0.5f;
            		mirror = false;
            		repairSpeed = 0.5f;
            		bullet = new BulletType() {{
            			maxRange = range/2;
            		}};
            	}}
            );
		}};

		monoquone = new JetUnitType("monoquone") {{
			localizedName = "Monoquone";
			health = 530;
			speed = 2.8f;
			accel = 0.07f;
            drag = 0.056f;
            engineX = 2.75f;
            engineY = -8f;
            range = 184f;
            rotateShooting = false;
            rotateSpeed = 3f;
            maxRange = range;

            weapons.add(
            	new Weapon("creatiive-weapon-jet-heal") {{
            		x = 6f;
            		y = -1f;
            		reload = 30f;
            		mirror = true;
            		rotate = true;
            		rotateSpeed = 3f;
            		bullet = new LaserBoltBulletType(4f, 7){{
                    	lifetime = range/speed;
                    	healPercent = 5.5f;
                   		collidesTeam = true;
                    	backColor = Pal.heal;
                    	frontColor = Color.white;
                	}};
            	}},
            	new Weapon("creatiive-weapon-jet-heal") {{
            		x = 2.5f;
            		y = 2.5f;
            		reload = 30f;
            		mirror = true;
            		rotate = true;
            		rotateSpeed = 3f;
            		bullet = new LaserBoltBulletType(4f, 7){{
                    	lifetime = range/speed;
                    	healPercent = 5.5f;
                   		collidesTeam = true;
                    	backColor = Pal.heal;
                    	frontColor = Color.white;
                	}};
            	}},
            	new Weapon("creatiive-weapon-jet-repairBeam") {{
            		x = 2.75f;
            		y = -5f;
            		reload = 60f;
            		mirror = true;
            		rotate = true;
            		rotateSpeed = 2.5f;
            		bullet = new BasicBulletType(7f, 50) {{
            			width = height = 10f;
            			lifetime = range/speed;
            			collidesTeam = true;
            			healPercent = 6f;
            			frontColor = Color.white;
            			backColor = Pal.heal;
            			weaveScale = 8f;
                    	weaveMag = 1f;
            		}};
            	}}
            );
		}};

		zelinote = new JetUnitType("zelinote") {{
			localizedName = "Zelinote";
			health = 830;
			speed = 1.9f;
			accel = 0.08f;
            drag = 0.064f;
            engineX = 5.5f;
            engineY = -11.5f;
            range = 232f;
            maxRange = range;
            rotateShooting = false;
            rotateSpeed = 2.5f;

            weapons.add(
            	new Weapon("creatiive-weapon-jet-repairBeam") {{
            		x = 5.5f;
            		y = -6f;
            		reload = 30f;
            		mirror = true;
            		rotate = true;
            		rotateSpeed = 0.6f;
            		bullet = new MissileBulletType(4f, 125) {{
            			width = 7f;
            			height = 10f;
            			lifetime = range/speed;
            			frontColor = Pal.heal;
            			backColor = Color.white;
            		}};
            	}}
            );
		}};
		kepsylon = new JetUnitType("kepsylon") {{
			localizedName = "Kepsylon";
			health = 3570;
			speed = 1.8f;
			accel = 0.09f;
            drag = 0.072f;
            engineX = 12f;
            engineY = -9f;
            range = 264f;
            maxRange = range;
            rotateShooting = false;
            rotateSpeed = 2f;
            weapons.add(
            	new Weapon("plasma-laser-mount"){{
                    shake = 3f;
                    shootY = 7f;
                    rotate = true;
                    x = 10f;
                    y = 0f;
					targetInterval = 20f;
					targetSwitchInterval = 35f;
					rotateSpeed = 3.5f;
					reload = 170f;
					recoil = 1f;
					shootSound = Sounds.beam;
					continuous = true;
					cooldownTime = reload;
					bullet = new ContinuousLaserBulletType(){{
                        maxRange = 90f;
                        damage = 26f;
                        length = 95f;
                        hitEffect = Fx.hitMeltHeal;
                        drawSize = 200f;
                        lifetime = 155f;
                        shake = 1f;
                        shootEffect = Fx.shootHeal;
                        smokeEffect = Fx.none;
                        width = 4f;
                        largeHit = false;
                        incendChance = 0.03f;
                        incendSpread = 5f;
                        incendAmount = 1;
                        healPercent = 0.4f;
                        collidesTeam = true;
                    }};
                }}
            );
		}};
		zermite = new JetUnitType("zermite") {{
			localizedName = "Zermite";
			health = 15000;
			speed = 1.7f;
			accel = 0.1f;
            drag = 0.08f;
            range = 304f;
            maxRange = range;
            rotateSpeed = 1.5f;
            rotateShooting = false;
		}};
	}
}