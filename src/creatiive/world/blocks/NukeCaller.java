package creatiive.world.blocks;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.scene.ui.layout.*;
import arc.struct.*;
import arc.util.io.*;
import arc.math.geom.*;
import arc.scene.ui.*;
import arc.util.*;
import creatiive.util.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.logic.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.meta.*;

import static creatiive.CreatiiveVars;

public class NukeCaller extends Block {
	public NukeCaller(String name) {
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

	@Override
	public void load() {
		nukeRegion = Core.atlas.find(name + "-nuke");
	}

	public class nukeCallerBuild extends Building {

		@Override
        public void buildConfiguration(Table table){
            table.table(tex.clear, t -> {
            	tt.table().size(40);
                addConfigButton(t, 1).align(Align.center);
            });
        }

        public Cell<Table> addConfigButton(Table table, int index) {
        	return table.table(t -> {
        		TextButton b = t.button(states[configs.get(index)], () -> {
        			configure(index);
        			CreatiiveVars.nukes--;
        			print(CreatiiveVars.nukes);
        		}).size(40f).get();

        		b.update(() -> b.setText("X"));
        	}).size(40f);
        }
	}
}