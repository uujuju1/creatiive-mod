package creatiive.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.entities.bullet.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.meta.*;
import mindustry.world.draw.*;

import creatiive.content.*;
import creatiive.world.blocks.*;
import creatiive.entities.bullet.*;
import creatiive.graphics.*;

import static mindustry.type.ItemStack.with;

public class CreatiiveTurrets implements ContentList {
	public static Block 
	// dusterite
	pull, attract, implode, inhale,
	// erbite
	zetni, tameteri, terskermite, katserume,
	// lerbonium
	meta;

	@Override
	public void load() {
		pull = new ItemTurret("pull") {{
			requirements(Category.turret, with(
				CreatiiveItems.dusterite, 20,
				Items.silicon, 15
			));
			localizedName = "Pull";
			size = 1;
			health = 160;
			reloadTime = 30f;
			recoilAmount = -1f;
			range = 120f;
			inaccuracy = 1f;
			rotateSpeed = 10f;
			maxAmmo = 30;
			restitution = 0.05f;
			ammo(
						CreatiiveItems.dusterite, CreatiiveBullets.pierceI,
						Items.silicon, new MissileBulletType(4f, 17) {{
							lifetime = 30f;
							width = 7f;
							height = 9f;
							pierce = true;
							pierceCap = 10;
						}}
					);
		}};
		attract = new ItemTurret("attract") {{
			requirements(Category.turret, with(
				CreatiiveItems.dusterite, 75,
				Items.silicon, 60,
				Items.titanium, 55
			));
			localizedName = "Attract";
			size = 2;
			health = 160 * size * size;
			reloadTime = 60f;
			recoilAmount = -2f;
			range = 200f;
			inaccuracy = 1.5f;
			rotateSpeed = 10f;
			maxAmmo = 100;
			restitution = 0.05f;
			ammo(
				CreatiiveItems.dusterite, CreatiiveBullets.pierceII,
						Items.titanium, new BasicBulletType(4f, 80) {{
							lifetime = 50f;
							width = 11f;
							height = 13f;
							pierce = true;
							pierceCap = 20;
						}},
						Items.silicon, new MissileBulletType(4f, 75) {{
							lifetime = 50f;
							width = 11;
							height = 13;
							pierce = true;
							pierceCap = 20;
						}}
			);
		}};
		implode = new ItemTurret("implode") {{
			requirements(Category.turret, with(
					CreatiiveItems.dusterite, 250,
					Items.silicon, 150,
					Items.thorium, 100
				));
			localizedName = "Implode";
			size = 3;
			health = 160 * size * size;
			reloadTime = 30f;
			recoilAmount = -1f;
			range = 240f;
			inaccuracy = 2f;
			rotateSpeed = 5f;
			shots = 4;
			burstSpacing = 4f;
			maxAmmo = 100;
			restitution = 0.05f;
			ammo(
				CreatiiveItems.dusterite, CreatiiveBullets.pierceIII,
				Items.thorium, new BasicBulletType(4f, 200) {{
					lifetime = 60f;
					width = 11f;
					height = 13f;
					pierce = true;
					pierceCap = 30;
				}},
				Items.silicon, new MissileBulletType(4f, 150) {{
					lifetime = 60f;
					width = 11f;
					height = 13f;
					pierce = true;
					pierceCap = 30;
				}},
				Items.surgeAlloy, new BasicBulletType(4f, 175) {{
					lifetime = 60f;
					width = 11f;
					height = 13f;
					pierce = true;
					pierceCap = 30;
					lightningDamage = 10;
					lightning = 2;
					lightningLength = 10;
				}}
			);
		}};
		inhale = new ItemTurret("inhale") {{
			requirements(Category.turret, with(
				CreatiiveItems.dusterite, 520,
				Items.silicon, 250,
				Items.surgeAlloy, 200,
				Items.plastanium, 300,
				Items.graphite, 420	
			));
			localizedName = "Inhale";
			size = 4;
			health = 160 * size * size;
			reloadTime = 30f;
			recoilAmount = -1f;
			range = 300f;
			inaccuracy = 2f;
			rotateSpeed = 5f;
			shots = 4;
			burstSpacing = 4f;
			maxAmmo = 150;
			restitution = 0.05f;
			ammo(
				CreatiiveItems.dusterite, CreatiiveBullets.pierceIV,
				Items.thorium, new BasicBulletType(4f, 350) {{
					lifetime = 75f;
					width = 13f;
					height = 15f;
					pierce = true;
					pierceCap = 40;
				}},
				Items.silicon, new MissileBulletType(4f, 250) {{
					lifetime = 75f;
					width = 13f;
					height = 15f;
					pierce = true;
					pierceCap = 40;
				}},
				Items.surgeAlloy, new BasicBulletType(4f, 200) {{
					lifetime = 75f;
					width = 13f;
					height = 15f;
					pierce = true;
					pierceCap = 40;
					lightningDamage = 15;
					lightning = 5;
					lightningLength = 15;
				}}
			);
		}};
		// erbite
		
		zetni = new ItemTurret("zetni") {{
			requirements(Category.turret, with(
				CreatiiveItems.erbite, 11,
				CreatiiveItems.zicromnium, 12,
				Items.graphite, 12
			));
			localizedName = "Zetni";
			health = 200;
			size = 1;
			reloadTime = 30f;
			recoilAmount = 1f;
			range = 130f;
			inaccuracy = 2f;
			rotateSpeed = 10f;
			restitution = 0.03f;
			ammo(
				CreatiiveItems.erbite, CreatiiveBullets.homeI,
				CreatiiveItems.zicromnium, new BasicBulletType(4f, 13) {{
					lifetime = range/speed;
				}},
				Items.silicon, new MissileBulletType(4f, 18) {{
					lifetime = range/speed;
				}},
				Items.pyratite, new BasicBulletType(4f, 10) {{
					lifetime = range/speed;
					status = StatusEffects.burning;
					statusDuration = 120f;
				}}
			);
		}};
		tameteri = new ItemTurret("tameteri") {{
			requirements(Category.turret, with(
				CreatiiveItems.erbite, 30,
				CreatiiveItems.zicromnium, 40,
				Items.graphite, 35,
				Items.titanium, 20
			));
			localizedName = "Tameteri";
			health = 200 * 4;
			size = 2;
			reloadTime = 45f;
			shots = 2;
			burstSpacing = 2;
			recoilAmount = 2f;
			range = 200f;
			inaccuracy = 2f;
			rotateSpeed = 7f;
			restitution = 0.04f;
			ammo(
				CreatiiveItems.erbite, CreatiiveBullets.homeII,
				Items.thorium, new BasicBulletType(4f, 60) {{
					width = 9f;
					height = 11f;
					lifetime = range/speed;
				}},
				CreatiiveItems.lerbonium, new MissileBulletType(5f, 70) {{
					width = 9f;
					height = 11f;
					lifetime = range/speed;
				}},
				Items.pyratite, new BasicBulletType(4f, 40) {{
					width = 9f;
					height = 11f;
					lifetime = range/speed;
					status = StatusEffects.burning;
					statusDuration = 120f;
				}}
			);
		}};
		terskermite = new ItemTurret("terskermite") {{
			requirements(Category.turret, with(
				CreatiiveItems.lerbonium, 80,
				CreatiiveItems.erbite, 100,
				Items.silicon, 150,
				Items.graphite, 140,
				Items.plastanium, 120
			));
			localizedName = "Terskermite";
			health = 200 * 9;
			size = 3;
			reloadTime = 120f;
			shots = 6;
			burstSpacing = 10f;
			recoilAmount = 1f;
			range = 250f;
			inaccuracy = 1f;
			restitution = 0.05f;
			ammo(
				CreatiiveItems.lerbonium, new MissileBulletType(6f, 200) {{
					width = 11f;
					height = 13f;
					lifetime = range/speed;
				}},
				CreatiiveItems.erbite, CreatiiveBullets.homeIII,
				Items.titanium, new BasicBulletType(6f, 170) {{
					width = 11f;
					height = 13f;
					lifetime = range/speed;
				}},
				Items.pyratite, new BasicBulletType(6f, 140) {{
					width = 11f;
					height = 13f;
					lifetime = range/speed;
					status = StatusEffects.burning;
					statusDuration = 120f;
				}}
			);
		}};
		katserume = new ItemTurret("katserume") {{
			requirements(Category.turret, with(
				CreatiiveItems.lerbonium, 400,
				CreatiiveItems.erbite, 500,
				Items.surgeAlloy, 300,
				Items.silicon, 400,
				Items.plastanium, 600,
				Items.thorium, 450
			));
			localizedName = "Katserume";
			health = 200 * 16;
			size = 4;
			reloadTime = 10f;
			shots = 2;
			burstSpacing = 3.5f;
			recoilAmount = 2f;
			range = 300f;
			inaccuracy = 2f;
			restitution = 0.05f;
			ammo(
				CreatiiveItems.lerbonium, new MissileBulletType(4f, 300) {{
					lifetime = 75f;
					width = 13f;
					height = 15f;
					pierce = true;
					pierceCap = 40;
				}},
				CreatiiveItems.erbite, CreatiiveBullets.homeIV,
				Items.silicon, new MissileBulletType(4f, 250) {{
					lifetime = 75f;
					width = 13f;
					height = 15f;
					pierce = true;
					pierceCap = 40;
				}},
				Items.surgeAlloy, new BasicBulletType(4f, 200) {{
					lifetime = 75f;
					width = 13f;
					height = 15f;
					pierce = true;
					pierceCap = 40;
					lightningDamage = 15;
					lightning = 8;
					lightningLength = 15;
				}}
			);
		}};

		meta = new ItemTurret("meta") {{
			requirements(Category.turret, with(
				Items.silicon, 10,
				CreatiiveItems.lerbonium, 10,
				CreatiiveItems.erbite, 15
			));
			localizedName = "Meta";
			health = 200;
			size = 1;
			reloadTime = 90f;
			recoilAmount = 2f;
			range = 120f;
			restitution = 0.05f;
			buildVisibility = BuildVisibility.shown;
			ammo(
				CreatiiveItems.lerbonium, new BasicBulletType(4f, 1) {{
					lifetime = 30f;
					frontColor = Color.valueOf("BA5A69");
					backColor = Color.valueOf("A34F5C");
					fragBullets = 1;
					fragBullet = new DelayBulletType(0f, 100) {{
						lifetime = 70;
						despawnEffect = CreatiiveFx.lerboniumExplosion;
					}};
				}}
			);
		}};
	} 
}