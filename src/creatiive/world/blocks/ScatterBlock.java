package creatiive.world.blocks;

import arc.*;
import arc.Core;
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
    public TextureRegion base, heat;
    
    public int shots = 10;
    public float cooldown = 0.007f;

    public ScatterBlock(String name) {
        super(name);
        destructible = true;
        hasItems = true;
        update = true;
        solid = true;
        flags = EnumSet.of(BlockFlag.turret);
        sync = true;
        itemCapacity = 10;
    }

    @Override
    public void load() {
        super.load();
        base = Core.atlas.find(name);
        heat = Core.atlas.find(name + "-heat");
    }

    public class ScatterBlockBuild extends Building { 
        public float alpha = 0;

        @Override
        public void updateTile() {
            // check consume for shoot
            if (cons.valid()) {
                if (alpha <= 0.001f) {
                    for (int i = 0; i <= shots; i++) {
                        bullet.create(this, this.team, x, y, Mathf.random() * 360f);
                    }
                    consume();
                    alpha = 1f;
                }   
            }
            if (alpha <= 0.001f) {
                alpha = 0f;
            }
            alpha -= cooldown;
        }

        @Override
        public void draw() {
            Draw.rect(base, x, y, 0);
            Draw.color(Pal.turretHeat);
            Draw.alpha(alpha);
            Draw.rect(heat, x, y, 0);
            Draw.reset();
        }
    }
}