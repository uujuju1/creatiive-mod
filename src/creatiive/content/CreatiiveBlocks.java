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
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.enviromnent.*;
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

	// defense
	dusteriteWall, dusteriteWallLarge;

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

		// def
		dusteriteWall = new Wall("dusterite-wall") {{
			requirements(Category.defense, with(CreatiiveItems.dusterite, 6));
			localizedName = "Dusterite Wall";
			health = 350;
			size = 1;
		}};

		dusteriteWallLarge = new Wall("dusterite-wall-large") {{
			requirements(Category.defense, with(CreatiiveItems.dusterite, 24));
			localizedName = "Large Dusterite Wall";
			health = 350 * 4;
			size = 2;
		}};
	}
}