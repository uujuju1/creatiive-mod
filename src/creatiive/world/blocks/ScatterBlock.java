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
    
    public int shots = 10;

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

    public class ScatterBlockBuild extends Building { 
        @Override
        public void updateTile() {
            // check consume for shoot
            if (cons.valid()) {
                for (int i = 0; i <= shots; i++) {
                    bullet.create(this, this.team, x, y, Mathf.random() * 360f);
                }
            consume();
            }
        }
    }
}