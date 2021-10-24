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
	refractoryKiln, ionizerPress, chlorophiteCultivator, carbonizedFurnace, fabricWeaver,

	// enviromnent
	sandMetalFloor, sandMetalFloor2, sandMetalFloor3, sandMetalFloor4, sandMetalFloor5,
	sandDamagedMetalFloor;

	@Override
	public void load() {
		refractoryKiln = new GenericCrafter("refractory-kiln") {{
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
		fabricWeaver = new GenericCrafter("fabric-weaver") {{
			requirements(Category.crafting, with(
				Items.phaseFabric, 69, // nice
				Items.silicon, 55,
				Items.thorium, 32,
				Items.titanium, 25 
			));
			localizedName = "Fabric Weaver";
			size = 2;
			health = 160;
			hasItems = true;
			drawer = new DrawWeave();
			craftTime = 120;
			craftEffect = Fx.smelt;
			consumes.items(
				new ItemStack(Items.phaseFabric, 1),
				new ItemStack(Items.metaglass, 2)
			);
			consumes.power(2f);
			outputItem = new ItemStack(CreatiiveItems.fabric, 1);
		}};
		ionizerPress = new GenericCrafter("ionizer-press") {{
			requirements(Category.crafting, with(
				Items.silicon, 55,
				Items.lead, 85,
				Items.graphite, 44,
				Items.copper, 125
			));
			localizedName = "Ionizer Press";
			size = 2;
			health = 160;
			hasItems = true;
			craftTime = 45;
			craftEffect = Fx.smelt;
			consumes.items(
				new ItemStack(Items.thorium, 1),
				new ItemStack(Items.titanium, 2)
			);
			consumes.power(1.5f);
			outputItem = new ItemStack(CreatiiveItems.cesium, 2);
		}};
		chlorophiteCultivator = new AttributeCrafter("chlorophite-cultivator") {{
			requirements(Category.production, with(
				Items.silicon, 25,
				Items.titanium, 10,
				Items.metaglass, 30
			));
			localizedName = "Chlorophite Cultivator";
			size = 2;
			health = 160;
			hasItems = true;
			hasLiquids = true;
			liquidCapacity = 60;
			drawer = new DrawCultivator();
			attribute = Attribute.spores;
			craftTime = 80;
			craftEffect = Fx.none;
			consumes.items(
				new ItemStack(Items.titanium, 1)
			);
			consumes.liquid(Liquids.water, 0.5f);
			consumes.power(0.5f);
			outputItem = new ItemStack(CreatiiveItems.chlorophite, 1);
		}};

		// env
		sandMetalFloor = new Floor("sand-metal-floor", 0);
		sandMetalFloor2 = new Floor("sand-metal-floor2", 0);
		sandMetalFloor3 = new Floor("sand-metal-floor3", 0);
		sandMetalFloor4 = new Floor("sand-metal-floor4", 0);
		sandMetalFloor5 = new Floor("sand-metal-floor5", 0);

		sandDamagedMetalFloor = new Floor("sand-damaged-metal-floor", 3);
	}
}