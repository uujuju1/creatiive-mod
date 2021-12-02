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
		@Override
		public void buildConfiguration(Table table) {
			table.button(Tex.clear, 20f, t -> {});
		}
	}
}