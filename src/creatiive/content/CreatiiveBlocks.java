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
import mindustry.world.blocks.units.*;
import mindustry.world.meta.*;
import mindustry.world.draw.*;

import creatiive.content.*;
import creatiive.world.blocks.*;
import creatiive.graphics.*;

import static mindustry.type.ItemStack.with;

public class CreatiiveBlocks implements ContentList {
	public static Block
	// production
	carbonizedFurnace, rustMoisturizer, magnetizer, lerboniumWeaver, plastaniumImploder,

	// scatters
	dustScatter, healScatter,

	// enviromnent
	sandMetalFloor, sandMetalFloor2, sandMetalFloor3, sandMetalFloor4, sandMetalFloor5,
	sandDamagedMetalFloor,

	// distribution
	dusteriteBridge,

	// ores
	oreDusterite, oreZicromnium, orePelenium,

	// unit factories
	rotorizedFactory,
	carbonAdditive, carbonMultiplicative, carbonExponential, carbonTetrative,

	arcFactory,

	// pressess
	mechanicalPress, mechanicalCompressor,

	// nukes
	anuke, tnuke,

	// start
	creatiiveBegginings;

	@Override
	public void load() {
		// production
		carbonizedFurnace = new GenericCrafter("carbonized-furnace") {{
			requirements(Category.crafting, with(
				Items.silicon, 75,
				Items.graphite, 55,
				Items.copper, 60
			));
			localizedName = "Carbonized Furnace";
			size = 2;
			health = 40 * size * size;
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
		rustMoisturizer = new GenericCrafter("rust-moisturizer") {{
			requirements(Category.crafting, with(
				Items.silicon, 125,
				Items.plastanium, 50,
				CreatiiveItems.highCarbonSteel, 60,
				Items.copper, 230
			));
			localizedName = "Rust Moisturizer";
			size = 3;
			health = 40 * size * size;
			hasItems = true;
			drawer = new DrawLiquid();
			craftTime = 120;
			craftEffect = Fx.smelt;
			consumes.items(new ItemStack(CreatiiveItems.dusterite, 3));
			consumes.liquid(Liquids.water, 0.5f);
			consumes.power(1.5f);
			outputItem = new ItemStack(CreatiiveItems.moisturizedDust, 2);
		}};
		magnetizer = new GenericCrafter("magnetizer") {{
			requirements(Category.crafting,
				with(
					CreatiiveItems.zicromnium, 140,
					CreatiiveItems.dusterite, 250,
					Items.silicon, 200,
					Items.titanium, 165
				)
			);
			localizedName = "Magnetizer";
			health = 160;
			size = 2;
			craftTime = 90;
			craftEffect = Fx.smelt;
			consumes.items(with(Items.silicon, 2, CreatiiveItems.zicromnium, 2));
			consumes.power(1f);
			outputItem = new ItemStack(CreatiiveItems.erbite, 2);
		}};
		lerboniumWeaver = new GenericCrafter("lerbonium-weaver") {{
			requirements(Category.crafting, 
				with(
					CreatiiveItems.erbite, 220,
					CreatiiveItems.zicromnium, 350,
					CreatiiveItems.moisturizedDust, 200,
					Items.silicon, 400,
					Items.plastanium, 380
				)
			);
			localizedName = "Lerbonium Weaver";
			health = 220;
			size = 3;
			craftTime = 120;
			craftEffect = Fx.smelt;
			drawer = new DrawWeave();
			consumes.items(
				with(
					Items.titanium, 2,
					CreatiiveItems.erbite, 3
				)
			);
			consumes.liquid(Liquids.oil, 0.2f);
			consumes.power(2f);
			outputItem = new ItemStack(CreatiiveItems.lerbonium, 1);
		}};
		plastaniumImploder = new GenericCrafter("plastanium-imploder") {{
			requirements(Category.crafting, with(
				Items.plastanium, 100,
				Items.silicon, 200,
				Items.thorium, 150,
				Items.titanium, 250,
				Items.graphite, 300
			));
			localizedName = "Plastanium Imploder";
			health = 220;
			size = 3;
			itemCapacity = 20;
			craftTime = 90f;
			craftEffect = Fx.smelt;
			updateEffect = CreatiiveFx.dynamicPlastShards;
			drawer = new DrawGlow();
			consumes.items(with(
				Items.titanium, 5,
				Items.graphite, 3
			));
			consumes.liquid(Liquids.oil, 0.3f);
			consumes.power(4f);
			outputItem = new ItemStack(Items.plastanium, 4);
		}};

		// env
		sandMetalFloor = new Floor("sand-metal-floor", 0);
		sandMetalFloor2 = new Floor("sand-metal-floor-2", 0);
		sandMetalFloor3 = new Floor("sand-metal-floor-3", 0);
		sandMetalFloor4 = new Floor("sand-metal-floor-4", 0);
		sandMetalFloor5 = new Floor("sand-metal-floor-5", 0);

		sandDamagedMetalFloor = new Floor("sand-damaged-metal-floor", 3);

		// ores
		oreDusterite = new OreBlock(CreatiiveItems.dusterite) {{
			oreDefault = true;
			oreThreshold = 0.846f;
			oreScale = 24.428572f;
		}};
		oreZicromnium = new OreBlock(CreatiiveItems.zicromnium) {{
			oreDefault = true;
			oreThreshold = 0.846f;
			oreScale = 24.428572f;
		}};
		orePelenium = new OreBlock(CreatiiveItems.pelenium) {{
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

		// factories
		rotorizedFactory = new UnitFactory("rotorized-factory") {{
			requirements(Category.units, with(
				CreatiiveItems.dusterite, 25,
				Items.silicon, 85,
				Items.graphite, 75,
				CreatiiveItems.highCarbonSteel, 35
			));
			plans = Seq.with(
				new UnitPlan(CreatiiveUnitMisc.ACopter, 60f * 25, with(Items.silicon, 20, CreatiiveItems.highCarbonSteel, 25)),
				new UnitPlan(CreatiiveUnitDust.silver, 60f * 15, with(Items.silicon, 15, CreatiiveItems.dusterite, 20))
			);
			localizedName = "Rotorized Factory";
			size = 3;
			health = 220;
			consumes.power(1.5f);
		}};

		arcFactory = new UnitFactory("arc-factory") {{
			requirements(Category.units, with(
				CreatiiveItems.zicromnium, 85,
				CreatiiveItems.erbite, 55,
				Items.titanium, 60,
				Items.silicon, 70
			));
			plans = Seq.with(
				new UnitPlan(CreatiiveUnitArc.nilo, 60f * 30, with(
					CreatiiveItems.zicromnium, 10,
					Items.titanium, 15,
					Items.silicon, 10
				))
			);
			localizedName = "Rotorized Factory";
			size = 3;
			health = 220;
			consumes.power(1.5f);
		}};

		// reconstructors
		carbonAdditive = new Reconstructor("carbon-additive-reconstructor") {{
			requirements(Category.units, with(
				CreatiiveItems.highCarbonSteel, 55,
				CreatiiveItems.dusterite, 125,
				Items.copper, 200,
				Items.lead, 120,
				Items.silicon, 90
			));
			upgrades.addAll(
				new UnitType[]{CreatiiveUnitMisc.ACopter, CreatiiveUnitMisc.BCopter},
				new UnitType[]{CreatiiveUnitDust.silver, CreatiiveUnitDust.gold},
				new UnitType[]{CreatiiveUnitArc.nilo, CreatiiveUnitArc.mosquerite}
			);
			localizedName = "Carbon Reconstructor(ADDITIVE)";
			size = 3;
			health = 220;
			consumes.power(3f);
			consumes.items(
				with(
					CreatiiveItems.dusterite, 15,
					CreatiiveItems.highCarbonSteel, 20,
					Items.silicon, 40,
					Items.graphite, 40
				)
			);
			constructTime = 60f * 10;
		}};
		carbonMultiplicative = new Reconstructor("carbon-multiplicative-reconstructor") {{
			requirements(Category.units, with(
				CreatiiveItems.highCarbonSteel, 420,
				CreatiiveItems.dusterite, 650,
				Items.lead, 650,
				Items.silicon, 450,
				Items.titanium, 350,
				Items.thorium, 650
			));
			upgrades.addAll(
				new UnitType[]{CreatiiveUnitMisc.BCopter, CreatiiveUnitMisc.CCopter},
				new UnitType[]{CreatiiveUnitDust.gold, CreatiiveUnitDust.platinum},
				new UnitType[]{CreatiiveUnitArc.mosquerite, CreatiiveUnitArc.eskerbone}
			);
			localizedName = "Carbon Reconstructor(MULTIPLICATIVE)";
			size = 5;
			health = 450;
			consumes.power(6f);
			consumes.items(
				with(
					CreatiiveItems.dusterite, 15,
					CreatiiveItems.highCarbonSteel, 20,
					Items.silicon, 130,
					Items.titanium, 80,
					Items.metaglass, 40
				)
			);
			constructTime = 60f * 30;
		}};
		carbonExponential = new Reconstructor("carbon-exponential-reconstructor") {{
			requirements(Category.units, with(
				CreatiiveItems.highCarbonSteel, 750,
				CreatiiveItems.dusterite, 1500,
				Items.lead, 2000,
				Items.silicon, 1000,
				Items.titanium, 2000,
				Items.thorium, 750,
				Items.plastanium, 450,
				Items.phaseFabric, 600
			));
			upgrades.addAll(
				new UnitType[]{CreatiiveUnitMisc.CCopter, CreatiiveUnitMisc.DCopter},
				new UnitType[]{CreatiiveUnitDust.platinum, CreatiiveUnitDust.iridium},
				new UnitType[]{CreatiiveUnitArc.eskerbone, CreatiiveUnitArc.obletsy}
			);
			localizedName = "Carbon Reconstructor(EXPONENTIAL)";
			size = 7;
			health = 670;
			consumes.power(13f);
			consumes.items(
				with(
					CreatiiveItems.dusterite, 15,
					CreatiiveItems.highCarbonSteel, 20,
					Items.silicon, 850,
					Items.titanium, 750,
					Items.plastanium, 650
				)
			);
			consumes.liquid(Liquids.cryofluid, 1f);
			liquidCapacity = 60f;
			constructTime = 60f * 10;
		}};
		carbonTetrative = new Reconstructor("carbon-tetrative-reconstructor") {{
			requirements(Category.units, with(
				CreatiiveItems.highCarbonSteel, 1700,
				CreatiiveItems.dusterite, 2500,
				Items.lead, 4000,
				Items.silicon, 3000,
				Items.thorium, 1000,
				Items.plastanium, 600,
				Items.phaseFabric, 600,
				Items.surgeAlloy, 800
			));
			upgrades.addAll(
				new UnitType[]{CreatiiveUnitMisc.DCopter, CreatiiveUnitMisc.ECopter},
				new UnitType[]{CreatiiveUnitDust.iridium, CreatiiveUnitDust.tenelite},
				new UnitType[]{CreatiiveUnitArc.obletsy, CreatiiveUnitArc.telene}
			);
			localizedName = "Carbon Reconstructor(TETRATIVE)";
			size = 9;
			health = 820;
			consumes.power(25f);
			consumes.items(
				with(
					CreatiiveItems.dusterite, 15,
					CreatiiveItems.highCarbonSteel, 20,
					Items.silicon, 1000,
					Items.plastanium, 600,
					Items.surgeAlloy, 500,
					Items.phaseFabric, 350
				)
			);
			consumes.liquid(Liquids.cryofluid, 3f);
			liquidCapacity = 180f;
			constructTime = 60f * 60f * 4;
		}};


		dustScatter = new ScatterBlock("dust-scatter") {{
			requirements(Category.turret, with(CreatiiveItems.dusterite, 50, Items.silicon, 25));
			size = 2;
			health = 160;
			shots = 10;
			cooldown = 0.016f;
			consumes.items(new ItemStack(CreatiiveItems.dusterite, 10));
			consumes.power(0.1f);
			bullet = new BasicBulletType(4f, 15) {{
				lifetime = 30f;
			}};
		}};

		healScatter = new ScatterBlock("heal-scatter") {{
			requirements(Category.turret, with(CreatiiveItems.moisturizedDust, 50, Items.silicon, 45));
			size = 2;
			health = 160;
			shots = 10;
			cooldown = 0.016f;
			consumes.items(new ItemStack(CreatiiveItems.moisturizedDust, 10));
			consumes.power(0.5f);
			bullet = new LaserBoltBulletType(4f, 10){{
				lifetime = 30f;
				healPercent = 0.5f;
				collidesTeam = true;
				frontColor = Pal.heal;
				backColor = Color.white;
			}};
		}};

		// mechanical crafters
		mechanicalPress = new MechanicalCrafter("mechanical-press") {{
			requirements(Category.crafting, with(
				Items.copper, 75,
				Items.lead, 30,
				CreatiiveItems.zicromnium, 30
			));
			localizedName = "Mechanincal Press";
			health = 160;
			size = 2;
			reloadTime = 30f;
			consumes.item(Items.coal, 1);
			outputItem = new ItemStack(Items.graphite, 1);
		}};
		mechanicalCompressor = new MechanicalCrafter("mechanical-compressor") {{
			requirements(Category.crafting, with(
				Items.silicon, 80,
				Items.lead, 115,
				Items.graphite, 60,
				Items.titanium, 80,
				CreatiiveItems.zicromnium, 100
			));
			localizedName = "Mechanincal Compressor";
			health = 160;
			size = 2;
			reloadTime = 30f;
			consumes.item(Items.titanium, 1);
			consumes.liquid(Liquids.oil, 0.125f);
			outputItem = new ItemStack(Items.plastanium, 1);
		}};

		// a nuke
		anuke = new Dynamite("dev-nuke") {{
			requirements(Category.effect, with(Items.thorium, 69, CreatiiveItems.zicromnium, 69));
			localizedName = "Anuke";
			health = 400;
			size = 1;
			radius = 10;
			charge = 120f;
			damage = 2147483647;
			buildVisibility = BuildVisibility.sandboxOnly;
		}};
		tnuke = new Dynamite("thorium-nuke") {{
			requirements(Category.effect, with(Items.thorium, 48, CreatiiveItems.zicromnium, 16));
			localizedName = "Thorium nuke";
			health = 420;
			size = 1;
			radius = 10;
			charge = 60f;
			damage = 1000;
		}};

		// ababa
		creatiiveBegginings = new Block("creatiive-begginings") {{
			inEditor = false;
			buildVisibility = BuildVisibility.debugOnly;
		}};
	}
}