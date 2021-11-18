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

import static mindustry.type.ItemStack.with;

public class CreatiiveBlocks implements ContentList {
	public static Block
	// production
	carbonizedFurnace, rustMoisturizer, magnetizer, lerboniumWeaver,

    // scatters
    dustScatter, healScatter,

	// enviromnent
	sandMetalFloor, sandMetalFloor2, sandMetalFloor3, sandMetalFloor4, sandMetalFloor5,
	sandDamagedMetalFloor,

	// distribution
	dusteriteBridge,

	// ores
	oreDusterite,

    // unit factories
    rotorizedFactory,
    carbonAdditive, carbonMultiplicative, carbonExponential, carbonTetrative,

	// walls
	dusteriteWall, dusteriteWallLarge, dusteriteWallHuge, dusteriteWallGigantic,
    erbiteWall, erbiteWallLarge, erbiteWallHuge, erbiteWallGigantic,

	// turrets
	pull, attract, implode;

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

		// env
		sandMetalFloor = new Floor("sand-metal-floor", 0);
		sandMetalFloor2 = new Floor("sand-metal-floor-2", 0);
		sandMetalFloor3 = new Floor("sand-metal-floor-3", 0);
		sandMetalFloor4 = new Floor("sand-metal-floor-4", 0);
		sandMetalFloor5 = new Floor("sand-metal-floor-5", 0);

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

        erbiteWall = new Wall("erbite-wall") {{
            requirements(Category.defense, with(CreatiiveItems.erbite, 6));
            localizedName = "Erbite Wall";
            health = 460;
            size = 1;
        }};
        erbiteWallLarge = new Wall("erbite-wall-large") {{
            requirements(Category.defense, with(CreatiiveItems.erbite, 6 * size * size));
            localizedName = "Large Erbite Wall";
            health = 460 * size * size;
            size = 2;
        }};
        erbiteWallHuge = new Wall("erbite-wall-huge") {{
            requirements(Category.defense, with(CreatiiveItems.erbite, 6 * size * size));
            localizedName = "Huge Erbite Wall";
            health = 460 * size * size;
            size = 3;
        }};
        erbiteWallGigantic = new Wall("erbite-wall-gigantic") {{
            requirements(Category.defense, with(CreatiiveItems.erbite, 6 * size * size));
            localizedName = "Gigantic Erbite Wall";
            health = 460 * size * size;
            size = 4;
        }};

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
        			lifetime = 30f;
        			width = 7f;
        			height = 9f;
        			pierce = true;
        			pierceCap = 10;
        		}},
        		Items.silicon, new MissileBulletType(4f, 17) {{
        			lifetime = 30f;
        			width = 7f;
        			height = 9f;
        			pierce = true;
        			pierceCap = 10;
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

        attract = new ItemTurret("attract") {{
        	requirements(Category.turret, with(CreatiiveItems.dusterite, 120, Items.silicon, 80, Items.titanium, 75));
        	ammo(
        		CreatiiveItems.dusterite, new BasicBulletType(4f, 50) {{
        			lifetime = 50f;
        			width = 9f;
        			height = 11f;
        			pierce = true;
        			pierceCap = 10;
        		}},
        		Items.silicon, new MissileBulletType(4f, 75) {{
        			lifetime = 50f;
        			width = 9f;
        			height = 11f;
        			pierce = true;
        			pierceCap = 10;
        		}}
        	);
        	localizedName = "Attract";
        	health = 240 * 2 * 2;
        	size = 2;
        	reloadTime = 60f;
        	recoilAmount = -1.5f;
        	range = 200f;
        	inaccuracy = 1.5f;
        	rotateSpeed = 7.5f;
        	maxAmmo = 100;
        	restitution = 0.05f;
        }};

        implode = new ItemTurret("implode") {{
        	requirements(Category.turret, with(CreatiiveItems.dusterite, 250, Items.silicon, 150, Items.thorium, 100));
        	ammo(
        		CreatiiveItems.dusterite, new BasicBulletType(4f, 50) {{
        			lifetime = 60f;
        			width = 11;
        			height = 13;
        			pierce = true;
        			pierceCap = 10;
        		}},
        		Items.silicon, new MissileBulletType(4f, 75) {{
        			lifetime = 60f;
        			width = 11;
        			height = 13;
        			pierce = true;
        			pierceCap = 10;
        		}}
        	);
        	localizedName = "Implode";
        	health = 260 * 3 * 3;
        	size = 3;
        	reloadTime = 30f;
        	recoilAmount = -1f;
        	range = 240f;
        	inaccuracy = 2f;
        	rotateSpeed = 5f;
        	shots = 4;
        	burstSpacing = 4f;
        	maxAmmo = 100;
        	restitution = 0.05f;
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
                new UnitPlan(CreatiiveUnitTypes.ACopter, 60f * 25, with(Items.silicon, 20, CreatiiveItems.highCarbonSteel, 25)),
                new UnitPlan(CreatiiveUnitTypes.silver, 60f * 15, with(Items.silicon, 15, CreatiiveItems.dusterite, 20))
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
                new UnitType[]{CreatiiveUnitTypes.ACopter, CreatiiveUnitTypes.BCopter},
                new UnitType[]{CreatiiveUnitTypes.silver, CreatiiveUnitTypes.gold}
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
                new UnitType[]{CreatiiveUnitTypes.BCopter, CreatiiveUnitTypes.CCopter},
                new UnitType[]{CreatiiveUnitTypes.gold, CreatiiveUnitTypes.platinum}
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
                new UnitType[]{CreatiiveUnitTypes.CCopter, CreatiiveUnitTypes.DCopter}
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
                new UnitType[]{CreatiiveUnitTypes.DCopter, CreatiiveUnitTypes.ECopter}
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
	}
}