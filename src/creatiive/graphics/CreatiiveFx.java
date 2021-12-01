package creatiive.graphics;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.entities.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;

import creatiive.graphics.DynamicEffect;

import static arc.graphics.g2d.Draw.rect;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class CreatiiveFx {
	public static final Effect
	shootArc = new Effect(20, e -> {
		color(Pal.lancerLaser);
        float w = 1f + 5 * e.fout();
        stroke(e.fout());
        Lines.circle(e.x, e.y, e.fin() * 8f);
        Drawf.tri(e.x, e.y, w, 17f * e.fout(), e.rotation);
        Drawf.tri(e.x, e.y, w, 4f * e.fout(), e.rotation + 180f);
	}),
	dynamicPlastShards = new DynamicEffect(40f, 3f, e -> {
		randLenVectors(e.id, e.intensity * 2f, 10 + e.fin() * 5, (x, y) -> {
			color(Color.valueOf("92C966"), Color.valueOf("73BD36"), e.fin());
			Fill.rect(e.x + x, e.y + y, e.fout() * e.intensity, e.fout() * e.intensity, 45);
		});
	});
}