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
	dynamicPlastShards = new Effect(40f, e -> {
		randLenVectors(e.id, 3 * 2, 10 + e.fin() * 5, (x, y) -> {
			color(Color.valueOf("92C966"), Color.valueOf("73BD36"), e.fin());
			Fill.rect(e.x + x, e.y + y, e.fout() * 3, e.fout() * 3, 45);
		});
	}),
	bababooey = new Effect(30f, e -> {
		e.scaled(7, i -> {
			stroke(3.1f * i.fout());
			Lines.circle(e.x, e.y, 3f + i.fin() * 14f);
		});

		color(Color.gray);

		randLenVectors(e.id, 20, 100f + 19f * e.finpow(), (x, y) -> {
			Fill.circle(e.x + x, e.y + y, e.fout() * 3f + 0.5f);
			Fill.circle(e.x + x / 2f, e.y + y / 2f, e.fout());
		});

		color(Pal.lighterOrange, Pal.lightOrange, Color.gray, e.fin());
		stroke(1.7f * e.fout());

		randLenVectors(e.id + 1, 20, 100f * e.finpow(), (x, y) -> {
			lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), 1f + e.fout() * 3f);
		});
	}),
	lerboniumExplosion = new Effect(120f, e -> {
		color(Color.valueOf("A34F5C"));

		Fill.circle(e.x, e.y, 40f * e.fout());

		color(Color.valueOf("BA5A69"));

		randLenVectors(e.id + 1, 10, 20f + e.fin() * 20f, (x, y) -> {
			Fill.rect(e.x + x, e.y + y, Mathf.sin(e.fin() * Math.PI) * 10f, Mathf.sin(e.fin() * Math.PI) * 10f, 45f);
		});
	});
}