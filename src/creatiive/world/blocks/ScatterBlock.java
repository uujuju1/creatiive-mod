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

public class ScatterBlock extends Block {
	public BulletType bullet = Bullets.standardCopper;
	public Color heatColor = Pal.turretHeat;
	public Effect shootEffect = Fx.none;
    public Effect smokeEffect = Fx.none;
    public Effect ammoUseEffect = Fx.none;
    public Sound shootSound = Sounds.shoot;
    public Item ammo = Items.copper;
    public TextureRegion baseRegion, turretRegion, heatRegion;

    public int shots = 10;

    float alpha = 0f;

    public ScatterBlock(String name) {
    	super(name);
    	destructible = true;
    	hasItems = true;
    	update = true;
        solid = true;
        outlineIcon = true;
        group = BlockGroup.turrets;
        flags = EnumSet.of(BlockFlag.turret);
        sync = true;
        itemCapacity = 10;
    }

    @Override
    public void load() {
    	baseRegion = Core.atlas.find(name + "-base");
    	turretRegion = Core.atlas.find(name);
    	heatRegion = Core.atlas.find(name + "-heat");
    }

   	public class ScatterBlockBuild extends Building { 
   		@Override
   		public void updateTile() {
   			// check consume for shoot
   			if (cons.valid()) {
   				for (int i = 0; i <= shots; i++) {
   					bullet.create(this, this.team, x, y, Mathf.random() * 360f);
   				}
   				consume();
   				alpha+=0.5f;
   			}

   			// heat
   			if (alpha != 0f) {
   				alpha-=0.001f;
   			}
   		}

   		@Override 
   		public void draw() {
   			Draw.rect(baseRegion, x, y, 0);
   			Draw.rect(turretRegion, x, y, 0);
   			Draw.alpha(alpha);
   			Draw.color(heatColor);
   			Draw.rect(heatRegion, x, y, 0);
   		}
   	}
}