package creatiive.world.blocks;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.scene.ui.*;
import arc.scene.ui.layout.*;
import arc.struct.*;
import arc.util.*;
import arc.util.io.*;
import arc.func.*;
import mindustry.gen.*;
import mindustry.ui.*;
import mindustry.graphics.*;
import mindustry.logic.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.meta.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.logic.*;
import mindustry.type.*;
import mindustry.world.draw.*;

public class MechanicalCrafter extends Block {
	public float reloadTime = 60f;
	public float reload = 0f;

	public @Nullable ItemStack outputItem;
	public @Nullable LiquidStack outputLiquid;

	public Effect craftEffect = Fx.none;

	public MechanicalCrafter(String name) {
		super(name);
        configurable = saveConfig = true;
      	rotate = false;
        update = true;
        solid = true;
        destructible = true;
        hideDetails = false;
        hasItems = true;
        sync = true;
        buildVisibility = BuildVisibility.shown;
	}

	@Override
	public void setStats() {
		stats.timePeriod = reloadTime;
        super.setStats();
        stats.add(Stat.productionTime, reloadTime / 60f, StatUnit.seconds);

        if(outputItem != null){
            stats.add(Stat.output, StatValues.items(reloadTime, outputItem));
        }

        if(outputLiquid != null){
            stats.add(Stat.output, outputLiquid.liquid, outputLiquid.amount * (60f / reloadTime), true);
        }
	}

	@Override
	public void setBars() {
		super.setBars();
		bars.add("Cooldown", e -> new Bar("Cooldown", Pal.power, () -> reload/reloadTime));
	}

	public class MechanicalCrafterBuild extends Building {
		@Override
		public void buildConfiguration(Table table) {
			table.button("Craft", () -> {
				this.checkConsReload();
			}).size(40, 60);
		}

		public void checkConsReload() {
			if (cons.valid()) {
				if (reload <= 0.001f) {
					consume();
					reload = reloadTime;
					craftEffect.at(x, y);
					if (outputItem != null) {
						for (int i = 0; i < outputItem.amount; i++) {
							offload(outputItem.item);
						}
					}

					if (outputLiquid != null) {
						handleLiquid(this, outputLiquid.liquid, outputLiquid.amount);
					}
				}
			}
		}

		@Override
		public void updateTile() {
			super.updateTile;
			if (reload >= 0.001f) {
				reload--;
			}
		}
	}
}