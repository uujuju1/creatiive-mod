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

public class CreatiiveUnitArc implements ContentList {
	
	public static UnitType
	// ground
	nilo, mosquerite, eskerbone, obletsy, telene;

	@Override
	public void load() {
		// arc
		nilo = new UnitType("nilo") {{
			localizedName = "Nilo";
			health = 250;
			speed = 2f;
			rotateSpeed = 5f;
			rotateShooting = true;
			legCount = 3;
			legLength = 9f;
			legTrns = 0.6f;
			legMoveSpace = 1.4f;
			hovering = true;
			groundLayer = Layer.legUnit - 1f;
			visualElevation = 0.2f;
			constructor = LegsUnit::create;

			weapons.add(
				new Weapon("creatiive-weapon-arc-shockgun") {{
					x = 3.5f;
					y = 0f;
					reload = 30f;
					rotate = false;
					bullet = new LightningBulletType(){{
                    	lightningColor = hitColor = Color.valueOf("8AA3F4");
                    	damage = 15f;
                    	lightningLength = 8;
                    	lightningLengthRand = 6;
                    	shootEffect = CreatiiveFx.shootArc;
                    	
                    	lightningType = new BulletType(0.0001f, 0f){{
                        	lifetime = Fx.lightning.lifetime;
                        	hitEffect = Fx.hitLancer;
                        	hittable = false;
                   		}};
                	}};
				}}
			);
		}};
		mosquerite = new UnitType("mosquerite") {{
			localizedName = "Mosquerite";
			health = 545;
			speed = 1.5f;
			rotateSpeed = 4.5f;
			rotateShooting = true;
			legCount = 4;
			legLength = 13f;
			legTrns = 0.6f;
			legMoveSpace = 1.3f;
			hovering = true;
			groundLayer = Layer.legUnit;
			visualElevation = 0.3f;
			constructor = LegsUnit::create;
			range = 360f;
			maxRange = range;
			hitSize = 10f;

			weapons.add(
				new Weapon("creatiive-weapon-arc-electra") {{
					x = 3f;
					y = -3f;
					reload = 5f;
					mirror = true;
					recoil = 0.5f;
					bullet = new BasicBulletType(4f, 15) {{
						width = height = 8f;
						lifetime = 40f;
						frontColor = Pal.lancerLaser;
						backColor = Color.valueOf("74ADDB");
					}};
				}},
				new Weapon("creatiive-weapon-arc-shockgun") {{
					x = 3.5f;
					y = 3.5f;
					reload = 30f;
					rotate = false;
					bullet = new LightningBulletType(){{
                    	lightningColor = hitColor = Color.valueOf("8AA3F4");
                    	damage = 15f;
                    	lightningLength = 12;
                    	lightningLengthRand = 6;
                    	shootEffect = CreatiiveFx.shootArc;
                    	
                    	lightningType = new BulletType(0.0001f, 0f){{
                        	lifetime = Fx.lightning.lifetime;
                        	hitEffect = Fx.hitLancer;
                        	hittable = false;
                   		}};
                	}};
				}},
				new Weapon("creatiive-weapon-arc-shockgun") {{
					x = 6.75f;
					y = 2f;
					reload = 30f;
					rotate = false;
					bullet = new LightningBulletType(){{
                    	lightningColor = hitColor = Color.valueOf("8AA3F4");
                    	damage = 15f;
                    	lightningLength = 8;
                    	lightningLengthRand = 6;
                    	shootEffect = CreatiiveFx.shootArc;
                    	
                    	lightningType = new BulletType(0.0001f, 0f){{
                        	lifetime = Fx.lightning.lifetime;
                        	hitEffect = Fx.hitLancer;
                        	hittable = false;
                   		}};
                	}};
				}}
			);
		}};
		eskerbone = new UnitType("eskerbone") {{
			localizedName = "Eskerbone";
			health = 1250;
			speed = 1.3f;
			rotateSpeed = 4f;
			rotateShooting = true;
			legCount = 6;
			legLength = 13f;
			legTrns = 1f;
			legMoveSpace = 1.6f;
			hovering = true;
			groundLayer = Layer.legUnit + 0.001f;
			visualElevation = 0.4f;
			constructor = LegsUnit::create;
			range = 180f;
			maxRange = range;
			hitSize = 12f;

			weapons.add(
				new Weapon("creatiive-weapon-arc-point") {{
					x = y = 0f;
					reload = 180f;
					rotate = true;
					rotateSpeed = 6;
					shootY = 5f;
					shootSound = Sounds.railgun;
					mirror = false;

					bullet = new RailBulletType(){{
                	    shootEffect = Fx.railShoot;
            	        length = range;
        	            updateEffectSeg = 60f;
    	                pierceEffect = Fx.railHit;
                    	updateEffect = Fx.railTrail;
                	    hitEffect = Fx.massiveExplosion;
            	        smokeEffect = Fx.shootBig2;
        	            damage = 530;
    	                pierceDamageFactor = 0.5f;
	                }};
				}}
			);
		}};
		obletsy = new UnitType("obletsy") {{
			localizedName = "Obletsy";
			health = 8000;
			speed = 1f;
			rotateSpeed = 2f;
			rotateShooting = true;
			legCount = 8;
			legLength = 30f;
			legExtension = -15f;
			legBaseOffset = 10f;
			legTrns = 1f;
			legMoveSpace = 1.6f;
			legSplashDamage = 32;
            legSplashRange = 30;
			hovering = true;
			groundLayer = Layer.legUnit + 0.002f;
			visualElevation = 0.4f;
			constructor = LegsUnit::create;
			range = 240f;
			maxRange = range;
			hitSize = 20f;

			weapons.add(
				new Weapon("creatiive-weapon-arc-railgun") {{
					x = y = 0f;
					reload = 180f;
					rotate = true;
					rotateSpeed = 4f;
					mirror = false;
					recoil = 5f;
					bullet = new LaserBulletType(300) {{
						lifetime = 30f;
						length = range;
						width = 16f;
					}};
				}},
				new Weapon("creatiive-weapon-arc-salvo") {{
					x = 8.75f;
					y = 2.75f;
					reload = 20f;
					mirror = true;
					shots = 1;

					bullet = new ChargedBulletType(6f, 50) {{
						bullet = new LightningBulletType(){{
                    		lightningColor = hitColor = Color.valueOf("8AA3F4");
                    		damage = 15f;
                    		lightningLength = 8;
                    		lightningLengthRand = 6;
                    		shootEffect = CreatiiveFx.shootArc;
                    	
                    		lightningType = new BulletType(0.0001f, 0f){{
                        		lifetime = Fx.lightning.lifetime;
                        		hitEffect = Fx.hitLancer;
                        		hittable = false;
                   			}};
                		}};
                		lifetime = 40f;
                		hitSize = 3f;
					}};
				}}
			);
		}};
		telene = new UnitType("telene") {{
			localizedName = "Telene";
			health = 20000;
			speed = 0.5f;
			rotateSpeed = 1.5f;
			rotateShooting = true;
			legCount = 10;
			legLength = 35f;
			legExtension = -24f;
			legBaseOffset = 10f;
			legTrns = 1f;
			legMoveSpace = 1.6f;
			legSplashDamage = 40;
            legSplashRange = 36;
			hovering = true;
			groundLayer = Layer.legUnit + 0.003f;
			visualElevation = 0.5f;
			constructor = LegsUnit::create;
			range = 300f;
			maxRange = range;
			hitSize = 30f;

			weapons.add(
				new Weapon("creatiive-weapon-arc-meltdown") {{
					x = 10f;
					y = -10f;
					reload = 120f;
					rotate = true;
					rotateSpeed = 4f;

					bullet = new ContinuousLaserBulletType(){{
                        maxRange = range;
                        damage = 30f;
                        length = range;
                        hitEffect = Fx.hitMeltHeal;
                        drawSize = 200f;
                        lifetime = 155f;
                        shake = 1f;
                        shootEffect = Fx.shootHeal;
                        smokeEffect = Fx.none;
                        width = 4f;
                        largeHit = false;
                        colors = new Color[]{Pal.lancerLaser.cpy().a(.2f), Pal.lancerLaser.cpy().a(.5f), Pal.lancerLaser.cpy().mul(1.2f), Color.white};
                    }};
				}},
				new Weapon("creatiive-weapon-arc-meltdown") {{
					x = 10f;
					y = 6f;
					reload = 120f;
					rotate = true;
					rotateSpeed = 4f;

					bullet = new ContinuousLaserBulletType(){{
                        maxRange = range;
                        damage = 30f;
                        length = range;
                        hitEffect = Fx.hitMeltHeal;
                        drawSize = 200f;
                        lifetime = 155f;
                        shake = 1f;
                        shootEffect = Fx.shootHeal;
                        smokeEffect = Fx.none;
                        width = 4f;
                        largeHit = false;
                        colors = new Color[]{Pal.lancerLaser.cpy().a(.2f), Pal.lancerLaser.cpy().a(.5f), Pal.lancerLaser.cpy().mul(1.2f), Color.white};
                    }};
				}}
			);
		}};
	}
}