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
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.meta.*;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class CreatiiveBlocks implements ContentList {
	public static Block
	// production
	carbonizedFurnace,

	// enviromnent
	sandMetalFloor, sandMetalFloor2, sandMetalFloor3, sandMetalFloor4, sandMetalFloor5,
	sandDamagedMetalFloor,

	// distribution
	dusteriteBridge,

	// ores
	oreDusterite,

	// walls
	dusteriteWall, dusteriteWallLarge, dusteriteWallHuge, dusteriteWallGigantic,

	// turrets
	pull /*, attract, implode */;

	@Override
	public void load() {
		carbonizedFurnace = new GenericCrafter("carbonized-furnace") {{
			requirements(Category.crafting, with(
				Items.silicon, 75,
				Items.graphite, 55,
				Items.copper, 60
			));
			localizedName = "Carbonized Furnace";
			size = 2;
			health = 160;
			hasItems = true;
			drawer = new DrawSmelter(Color.valueOf("F2FF7D"));
			craftTime = 30;
			craftEffect = Fx.smelt;
			consumes.items(
				new ItemStack(Items.lead, 1),
				new ItemStack(Items.coal, 2)
			);
			consumes.power(1f);
			outputItem = new ItemStack(CreatiiveItems.highCarbonSteel, 1);
		}};

		// env
		sandMetalFloor = new Floor("sand-metal-floor", 0);
		sandMetalFloor2 = new Floor("sand-metal-floor2", 0);
		sandMetalFloor3 = new Floor("sand-metal-floor3", 0);
		sandMetalFloor4 = new Floor("sand-metal-floor4", 0);
		sandMetalFloor5 = new Floor("sand-metal-floor5", 0);

		sandDamagedMetalFloor = new Floor("sand-damaged-metal-floor", 3);

		// walls
		dusteriteWall = new Wall("dusterite-wall") {{
			requirements(Category.defense, with(CreatiiveItems.dusterite, 6));
			localizedName = "Dusterite Wall";
			health = 350;
			size = 1;
		}};

		dusteriteWallLarge = new Wall("dusterite-wall-large") {{
			requirements(Category.defense, with(CreatiiveItems.dusterite, 6 * 4));
			localizedName = "Large Dusterite Wall";
			health = 350 * 4;
			size = 2;
		}};

		dusteriteWallHuge = new Wall("dusterite-wall-huge") {{
			requirements(Category.defense, with(CreatiiveItems.dusterite, 6 * 9));
			localizedName = "Huge Dusterite Wall";
			details = "sus";
			health = 350 * 11;
			size = 3;
		}};

		dusteriteWallGigantic = new Wall("dusterite-wall-gigantic") {{
			requirements(Category.defense, with(CreatiiveItems.dusterite, 6 * 16));
			localizedName = "Gigantic Dusterite Wall";
			health = 350 * 17;
			size = 4;
		}};

		// ores
		oreDusterite = new OreBlock(CreatiiveItems.dusterite) {{
			oreDefault = true;
            oreThreshold = 0.846f;
            oreScale = 24.428572f;
        }};

        // distribution
        // bridges
        dusteriteBridge = new BufferedItemBridge("dusterite-bridge") {{
        	requirements(Category.distribution, with(CreatiiveItems.dusterite, 12, Items.lead, 6));
        	range = 4;
        	speed = 74f;
        	bufferCapacity = 14;
        }};

        // turrets
        pull = new ItemTurret("pull") {{
        	requirements(Category.turret, with(CreatiiveItems.dusterite, 15, Items.lead, 20));
        	ammo(
        		CreatiiveItems.dusterite, new BasicBulletType(4f, 15) {{
        			lifetime = range/speed;
        			width = 7;
        			height = 9;
        		}},
        		Items.silicon, new MissileBulletType(4f, 17) {{
        			lifetime = range/speed;
        			width = 7;
        			height = 9;
        		}}
        	);
        	localizedName = "Pull";
        	health = 230;
        	size = 1;
        	reloadTime = 30f;
        	recoilAmount = -1f;
        	range = 120f;
        	inaccuracy = 1f;
        	rotateSpeed = 10f;
        	maxAmmo = 30;
        	restitution = 0.05f;
        }};

        // attract = new ItemTurret("attract") {{
        // 	requirements(Category.turret, with(CreatiiveItems.dusterite, 120, Items.silicon, 80, Items.titanium, 75));
        // 	ammo(
        // 		CreatiiveItems.dusterite, CreatiiveBullets.pullMedium,
        // 		Items.silicon, CreatiiveBullets.pullHomeMedium
        // 	);
        // 	localizedName = "Attract";
        // 	health = 240 * 2 * 2;
        // 	size = 2;
        // 	reloadTime = 60f;
        // 	recoilAmount = -1.5f;
        // 	range = 200f;
        // 	inaccuracy = 1.5f;
        // 	rotateSpeed = 7.5f;
        // 	maxAmmo = 100;
        // 	restitution = 0.05f;
        // }};

        // implode = new ItemTurret("implode") {{
        // 	requirements(Category.turret, with(CreatiiveItems.dusterite, 250, Items.silicon, 150, Items.thorium, 100));
        // 	ammo(
        // 		CreatiiveItems.dusterite, CreatiiveBullets.pullLarge,
        // 		Items.silicon, CreatiiveBullets.pullHomeLarge
        // 	);
        // 	localizedName = "Implode";
        // 	health = 260 * 3 * 3;
        // 	size = 3;
        // 	reloadTime = 30f;
        // 	recoilAmount = -1f;
        // 	range = 240f;
        // 	inaccuracy = 2f;
        // 	rotateSpeed = 5f;
        // 	shots = 4;
        // 	burstSpacing = 4f;
        // 	maxAmmo = 100;
        // 	restitution = 0.05f;
        // }};
	}
}