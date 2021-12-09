package creatiive.entities.bullet;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.blocks.environment.*;
import mindustry.entities.Effect;

import static mindustry.Vars.tilesize;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.stroke;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class ChargedBulletType extends BulletType {
	public float lightningChance = 0.25f;
	public Color bulletColor = Pal.lancerLaser;
	public @Nullable BulletType bullet = Bullets.standardCopper;

	public ChargedBulletType(float speed, float damage) {
		super(speed, damage);
		lifetime = 60;
	}

	@Override
	public void update(Bullet b) {
		if (Mathf.randomBoolean(lightningChance)) {
			bullet.create(b, b.x, b.y, Mathf.random() * 360);
		}
	}

	@Override
	public void draw(Bullet b) {
		Draw.color(bulletColor);
		Fill.circle(b.x, b.y, hitSize/2);
	}
}