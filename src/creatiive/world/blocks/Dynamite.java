package creatiive.world.blocks;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.scene.ui.*;
import arc.scene.ui.layout.*;
import arc.util.*;
import arc.util.io.*;
import mindustry.gen.*;
import mindustry.ui.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.graphics.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.meta.*.

// different from betamindy mynamite this block only deals damage
public class Dynamite extends Block {
	public int radius = 10;
	public float charge = 80f;

	public int damage = 69420;
	// dont change
	public float countdown = 0f;

	public Effect bababooey = Fx.none;
	// public Sound bababooeySound = Sounds.explosionBig;

	public Dynamite(String name) {
		super(name);
		sync = true;
		update = true;
		solid = true;
	}

	@Override
	public void setStats() {
		super.setStats();
		stats.add(Stat.charge, 60f / charge, StatUnit.seconds);
		stats.add(Stat.range, radius, StatUnit.blocks);
	}

	@Override
	public void setBars() {
		super.setBars();
		bars.add("Charge", e -> new Bar("Charge", Color.red, () -> countdown/charge));
	}

	public class DynamiteBuild extends Building {
		boolean explode = false;
		@Override 
		public void buildConfiguration(Table table) {
			table.button("Explode", () -> {
				explode = true;
			}).size(120, 20);
		}

		@Override
		public void updateTile() {
			super.updateTile();
			if (explode) {
				countdown++;
				if (countdown >= charge) {
					kill();
				}
			}
		}

		@Override
		public void onDestroyed() {
			if (explode) {
				bababooey.at(x, y);
				// bababooeySound.at(tile);
				Damage.damage(x, y, radius * 8, damage);
			}
		}
	}
}