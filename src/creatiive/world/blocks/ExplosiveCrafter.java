package creatiive.world.blocks;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.unit.*;
import mindustry.entities.*;
import mindustry.graphics.*;
import mindustry.world.consumers.*;
import mindustry.type.*;
import mindustry.world.meta.*;
import mindustry.world.blocks.production.*;

public class ExplosiveCrafter extends GenereicCrafter {
	public float heatCap = 60f;
	public float heatingScl = 1f;
	public float cooldownScl = 1f;
	public float coolerConsume = 0.1;
	public float minCoolerCap = 0.5f;
	public float explodeRadius = 160f;
	public float explodeDamage = 1000f;

	public ExplosiveCrafter(String name) {
		super(name);
	}

	public class ExplosiveCrafterDraw extends GenereicCrafterBuild {
		float heat = 0f;
		ConsumeLiquid liquidCons = consumes.get(ConsumeType.liquid);
		@Override
		public void updateTile() {
			super.updateTile();
			if (this.heat > 0f) {
				if (liquidCons.liquid.amount >= 0f) {
					liquids.remove(liquidCons.liquid, coolerConsume);
					this.heat -= (Time.delta * cooldownScl);
				}
			}
			if (liquidCons.liquid.amount <= minCoolerCap) {
				this.heat += (Time.delta * heatingScl);
			}
			if (this.heat >= heatCap) {
				kill();
				Damage.damage(x, y, explodeRadius, explodeDamage);
			}
		}

		@Override
		public void draw() {
			super.draw();
			Draw.alpha(this.heat/heatCap - 0.5f);
			Draw.color(Pal.turretHeat);
			Fill.rect(x, y, this.size * 8, this.size * 8, 0);
		}
	}
}