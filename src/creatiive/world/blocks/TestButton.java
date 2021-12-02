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

public class TestButton extends Block {
	public float reloadTime = 60f;

	public @Nullable ItemStack outputItem;
	public @Nullable LiquidStack outputLiquid;

	public TestButton(String name) {
		super(name);
        configurable = saveConfig = true;
      	rotate = false;
        update = true;
        solid = true;
        destructible = true;
        hideDetails = false;
        buildVisibility = BuildVisibility.shown;
        category = Category.logic;
	}

	public class TestButtonBuild extends Building {
		float reload = 0f;
		@Override
		public void buildConfiguration(Table table) {
			table.button("Craft", () -> {
				this.checkConsReload();
			});
		}

		public void checkConsReload() {
			if (cons.valid()) {
				if (reload <= 0.001f) {
					consume();
					reload = reloadTime;

					if (outputItem != null) {
						for (int i; i < outputItem.amount; i++) {
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
			if (reload >= 0.001f) {
				reload--;
			}
		}
	}
}