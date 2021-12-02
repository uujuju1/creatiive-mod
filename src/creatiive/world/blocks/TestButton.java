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
import mindstry.gen.*;

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
			table.table(Tex.clear, t -> {
				t.table().size(40);
				addConfigButton(t, 1).align(Align.center);
			});
		}

		public Cell<Table> addConfigButton(Table table, int index){
            return table.table(t -> {
                TextButton b = t.button("hello", () -> {
                    configure(index);
                    print("test");
                }).size(40f).get();
            }).size(40f);
        }
	}
}