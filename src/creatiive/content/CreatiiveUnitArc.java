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
	nilo, mosquerite, eskerbone;

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
			range = 160f;
			maxRange = range;

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
	}
}