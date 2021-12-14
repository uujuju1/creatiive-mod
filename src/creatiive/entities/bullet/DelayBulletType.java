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

public class DelayBulletType extends BulletType {
	public float explodeTime = 60f, explodeRadius = 40f;
	public int explodeDamage = 10;
	float despawnTime = 0f;

	public Color groundColor = Color.valueOf("A34F5C");

	public DelayBulletType(float speed, float dmg) {
		super(speed, dmg);
		collides = collidesAir = collidesGround = false;
		drag = 0.1f;
		lifetime = explodeTime + 1f;
	}

	@Override
	public void update(Bullet b) {
		if (this.despawnTime >= explodeTime) {
			Damage.damage(b.team, b.x, b.y, explodeRadius, explodeDamage);
		}
		this.despawnTime += Time.delta;
	}

	@Override
	public void draw(Bullet b) {
		Draw.color(groundColor);
		Draw.z(Layer.floor + 0.001f);
		Draw.alpha(this.despawnTime/this.explodeTime);
		Fill.circle(b.x, b.y, explodeRadius);
	}
}