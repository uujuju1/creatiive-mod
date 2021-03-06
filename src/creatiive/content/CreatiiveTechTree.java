package creatiive.content;

import arc.struct.Seq;
import mindustry.content.*;
import mindustry.content.TechTree.TechNode;
import mindustry.ctype.ContentList;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives.*;
import mindustry.type.ItemStack;

import static creatiive.content.CreatiiveItems.*;
import static creatiive.content.CreatiiveBlocks.*;
import static creatiive.content.CreatiiveWalls.*;
import static creatiive.content.CreatiiveTurrets.*;
import static creatiive.content.CreatiiveUnitArc.*;
import static creatiive.content.CreatiiveUnitDust.*;
import static creatiive.content.CreatiiveUnitMisc.*;

import static mindustry.content.Blocks.*;
import static mindustry.content.Items.*;
import static mindustry.content.UnitTypes.*;

public class CreatiiveTechTree implements ContentList {
	static TechTree.TechNode context = null;

	private static void ConeccNode (UnlockableContent parent, Runnable children) {
		context = TechTree.all.find(t -> t.content == parent);
		children.run();
	}

	private static void node (UnlockableContent content, ItemStack[] requirements, Seq <Objective> objectives, Runnable children) {
		TechNode node = new TechNode(context, content, requirements);
		if (objectives != null) node.objectives = objectives;

		TechNode prev = context;
		context = node;
		children.run();
		context = prev;
	}

	private static void node (UnlockableContent content, ItemStack[] requirements, Seq <Objective> objectives) {
		node(content, requirements, objectives, () -> {
		});
	}

	private static void node (UnlockableContent content, Seq <Objective> objectives) {
		node(content, content.researchRequirements(), objectives, () -> {
		});
	}

	private static void node (UnlockableContent content, ItemStack[] requirements) {
		node(content, requirements, Seq.with(), () -> {
		});
	}

	private static void node (UnlockableContent content, ItemStack[] requirements, Runnable children) {
		node(content, requirements, null, children);
	}

	private static void node (UnlockableContent content, Seq <Objective> objectives, Runnable children) {
		node(content, content.researchRequirements(), objectives, children);
	}

	private static void node (UnlockableContent content, Runnable children) {
		node(content, content.researchRequirements(), children);
	}

	private static void node (UnlockableContent block) {
		node(block, () -> {
		});
	}

	private static void nodeProduce (UnlockableContent content, Seq <Objective> objectives, Runnable children) {
		node(content, content.researchRequirements(), objectives.and(new Produce(content)), children);
	}

	private static void nodeProduce (UnlockableContent content, Seq <Objective> objectives) {
		nodeProduce(content, objectives, () -> {
		});
	}

	private static void nodeProduce (UnlockableContent content, Runnable children) {
		nodeProduce(content, Seq.with(), children);
	}

	private static void nodeProduce (UnlockableContent content) {
		nodeProduce(content, Seq.with(), () -> {
		});
	}

	@Override
	public void load() {
		// start
		ConeccNode(coreShard, () -> {
			node(creatiiveBegginings, () -> {
				// items
				node(dusterite, () -> {
					node(moisturizedDust, Seq.with(new Produce(Items.sporePod)));
				});
				node(zicromnium, () -> {
					node(erbite, Seq.with(new Produce(Items.titanium)), () -> {
						node(lerbonium, Seq.with(new Produce(Items.thorium)));
					});
				});
				node(highCarbonSteel, Seq.with(new Produce(Items.silicon)));
				
				// turrets
				node(pull, Seq.with(new Produce(dusterite)), () -> {
					node(attract, Seq.with(new Produce(Items.titanium)), () -> {
						node(implode, Seq.with(new Produce(Items.plastanium)), () -> {
							node(inhale, Seq.with(new Produce(Items.surgeAlloy)));
						});
					});
					node(zetni, Seq.with(new Produce(erbite)), () -> {
						node(tameteri, Seq.with(new Produce(Items.thorium)), () -> {
							node(terskermite, Seq.with(new Produce(Items.plastanium)), () -> {
								node(katserume, Seq.with(new Produce(Items.surgeAlloy)));
							});
						});
						node(meta, Seq.with(new Produce(lerbonium)), () -> {
							node(karma, Seq.with(new Produce(titanium)), () -> {
								node(delta, Seq.with(new Produce(thorium)), () -> {
									node(dauma, Seq.with(new Produce(surgeAlloy)));
								});
							});
						});
					});
				});

				// scatters
				node(dustScatter, Seq.with(new Produce(dusterite)), () -> {
					node(healScatter, Seq.with(new Produce(moisturizedDust)));
				});

				// walls
				node(dusteriteWall, Seq.with(new Produce(dusterite)), () -> {
					node(dusteriteWallLarge, () -> {
						node(dusteriteWallHuge, () -> {
							node(dusteriteWallGigantic);
						});
					});
					node(erbiteWall, Seq.with(new Produce(dusterite)), () -> {
						node(erbiteWallLarge, () -> {
							node(erbiteWallHuge, () -> {
								node(erbiteWallGigantic);
							});
						});
					});
				});

				node(rustMoisturizer, Seq.with(new Produce(dusterite)), () -> {
					node(carbonizedFurnace, Seq.with(new Produce(titanium)));
					node(magnetizer, Seq.with(new Produce(zicromnium)), () -> {
						node(lerboniumWeaver, Seq.with(new Produce(erbite)));
					});
				});

				// units
				node(rotorizedFactory, Seq.with(new Produce(highCarbonSteel), new Research(Blocks.airFactory)), () -> {
					node(arcFactory, Seq.with(new Produce(erbite)), () -> {
						node(nilo, Seq.with(new Research(UnitTypes.crawler)), () -> {
							node(mosquerite, Seq.with(new Research(Blocks.additiveReconstructor)), () -> {
								node(eskerbone, Seq.with(new Research(Blocks.multiplicativeReconstructor)), () -> {
									node(obletsy, Seq.with(new Research(Blocks.exponentialReconstructor)), () -> {
										node(telene, Seq.with(new Research(Blocks.tetrativeReconstructor)));
									});
								});
							});
						});
					});

					node(carbonAdditive, Seq.with(new Research(Blocks.additiveReconstructor)), () -> {
						node(carbonMultiplicative, Seq.with(new Research(Blocks.multiplicativeReconstructor)), () -> {
							node(carbonExponential, Seq.with(new Research(Blocks.exponentialReconstructor)), () -> {
								node(carbonTetrative, Seq.with(new Research(Blocks.tetrativeReconstructor)));
							});
						});	
					});

					node(ACopter, Seq.with(new Produce(dusterite)), () -> {
						node(BCopter, Seq.with(new Research(Blocks.additiveReconstructor)), () -> {
							node(CCopter, Seq.with(new Research(Blocks.multiplicativeReconstructor)), () -> {
								node(DCopter, Seq.with(new Research(Blocks.exponentialReconstructor)), () -> {
									node(ECopter, Seq.with(new Research(Blocks.tetrativeReconstructor)));
								});
							});
						});
					});
					node(silver, Seq.with(new Produce(dusterite)), () -> {
						node(gold, Seq.with(new Research(Blocks.additiveReconstructor)), () -> {
							node(platinum, Seq.with(new Research(Blocks.multiplicativeReconstructor)), () -> {
								node(iridium, Seq.with(new Research(Blocks.exponentialReconstructor)), () -> {
									node(tenelite, Seq.with(new Research(Blocks.tetrativeReconstructor)));
								});
							});
						});
					});
				});
			});
		});

		ConeccNode(plastaniumCompressor, () -> {
			node(plastaniumImploder);
		});
	}
}