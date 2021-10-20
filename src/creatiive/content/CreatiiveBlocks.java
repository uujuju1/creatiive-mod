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
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.storage.*; 
import mindustry.world.meta.*;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class CreatiiveBlocks implements ContentList {
	public static Block
	// production
	refractoryKiln, ionizerPress, chlorophiteCultivator, carbonizedFurnace, fabricWeaver;

	@Override
	public void load() {
		refractoryKiln = new GenericCrafter("refractor-kiln") {{
			requirements(Category.crafting, with(
				Items.metaglass, 50,
				Items.graphite, 35,
				Items.titanium, 83,
				Items.silicon, 125
			));
			localizedName = "Refractory Kiln";
			size = 3;
			health = 220;
			hasItems = true;
			hasLiquids = true;
			itemCapacity = 20;
			liquidCapacity = 60;
			drawer = new DrawSmelter(Color.valueOf("C3CBE7"));
			craftEffect = Fx.smelt;
			updateEffect = Fx.none;
			craftTime = 60;
			consumes.items(
				new ItemStack(Items.titanium, 3),
				new ItemStack(Items.metaglass, 6)
			);
			consumes.liquid(Liquids.water, 0.2f);
			consumes.power(0.5f);
			outputItem = new ItemStack(CreatiiveItems.refractoryGlass, 3);
		}};
		carbonizedFurnace = new GenericCrafter("carbonized-furnace") {{
			requirements(Category.crafting, with(
				Items.silicon, 75,
				Items.graphite, 55,
				Items.copper, 60
			));
			localizedName = "Carbonized Furnace";
			size = 3;
			health = 160;
			hasItems = true;
			drawer = new DrawSmelter(Color.valueOf("F2FF7D"));
			craftTime = 30;
			craftEffect = Fx.smelt;
			consumes.items(
				new ItemStack(Items.lead, 1),
				new ItemStack(Items.coal, 2)
			);
			outputItem = new ItemStack(CreatiiveItems.highCarbonSteel, 1);
		}};
	}
}