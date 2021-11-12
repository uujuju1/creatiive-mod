package creatiive.world.blocks;

import arc.*;
import arc.audio.*;
import arc.func.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import arc.util.io.*;
import arc.scene.ui.*;
import arc.scene.ui.layout.*;
import mindustry.audio.*;
import mindustry.content.*;
import mindustry.graphics.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.meta.*;
import mindustry.world.*;
import mindustry.logic.*;
import mindustry.type.*;
import mindustry.world.draw.*;

import static mindustry.Vars;

public class ScatterBlock extends Block {
	public Color heatColor = Pal.turretHeat;
	public BulletType bullet = Bullets.standardCopper;
	public Effect shootEffect = Fx.none;
    public Effect smokeEffect = Fx.none;
    public Effect ammoUseEffect = Fx.none;
    public Sound shootSound = Sounds.shoot;
    public TextureRegion turretSprite;
    public Item ammo = Items.copper;

    public int shots = 10;

    public ScatterBlock(String name) {
    	destructible = true;
    	update = true;
        solid = true;
        outlineIcon = true;
        group = BlockGroup.turrets;
        flags = EnumSet.of(BlockFlag.turret);
    }

   	@Override
   	public void init() {
   		super.init();
   		consumes.items(new ItemStack(ammo, shots));
   	}

   	public class ScatterBlockBuild extends Building { 
   		// some code modified from eso
   		@Override
   		public void buildConfiguration(Table table) {
   			table.table(Tex.clear, t -> {
   				t.table().size(40);
   				t.addConfigButton(t, 1).align(Align.center);
   			});
   		}

   		@Override
   		public Cell<Table> addConfigButton(Table table, Int index) {
   			return table.table(t -> {
   				TextButton b = t.button("x", () -> {
   					configure(1);
   					if (consValid()) {
   						consume();
   						bullet.create(Team.delerict, x, y, Math.random() * 360f);
   					}
   					
   				}).size(40f).get();
   			}).size(40f);
   		}
   	}
}