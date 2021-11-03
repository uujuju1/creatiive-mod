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

import static mindustry.Vars.tilesize;

public class WaterMissileBulletType extends BulletType {
	public float groundDrag = 0.15f;
	public float waterDrag = 0.015f;

	public WaterMissileBulletType(float speed, float damage) {
		super(speed, damage);
		layer = Layer.scorch;
        homingPower = 0.035f;
        homingRange = 20 * tilesize;
        keepVelocity = collidesAir = absorbable = hittable = reflectable = false;
        trailRotation = true;
        hitSoundVolume = 4f;
        hitSound = Sounds.explosionbig;
	}

	@Override
	public void update(Bullet b) {
		Floor floor = Vars.world.floorWorld(b.x, b.y);
		if (floor.isLiquid) {
			b.vel.scl(Math.max(1f - waterDrag * Time.delta, 0.01f));
		} else {
			b.vel.scl(Math.max(1f - groundDrag * Time.delta, 0.01f));
		}
		super.update(b);
	}
}