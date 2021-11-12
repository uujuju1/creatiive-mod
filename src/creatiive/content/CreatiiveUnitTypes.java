package creatiive.content;

import creatiive.type.*;
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

public class CreatiiveUnitTypes implements ContentList {
	
	public static UnitType 

	// copters
	ACopter, BCopter, CCopter, DCopter, ECopter,

	// jets
	arcana, monoquone, zelinote,
	
	// dust navals
	silver, gold, platinum, iridium, tenelite;

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

		arcana = new JetUnitType("arcana") {{
			localizedName = "Arcana";
			health = 350;
			speed = 3f;
			accel = 0.06f;
            drag = 0.024f;
            engineX = 2.25f;
            engineY = -5.5f;
            range = 136f;
            rotateSpeed = 2f;
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
            drag = 0.028f;
            engineX = 2.75f;
            engineY = -8f;
            range = 184f;
            rotateShooting = false;
            rotateSpeed = 2f;
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
            drag = 0.032f;
            engineX = 5.5f;
            engineY = -11.5f;
            range = 232f;
            maxRange = range;
            rotateShooting = false;
            rotateSpeed = 2f;

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
	}
}