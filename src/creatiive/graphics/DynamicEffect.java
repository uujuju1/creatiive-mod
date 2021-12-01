package creatiive.graphics;

import arc.*;
import arc.func.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.entities.Effect;
import mindustry.world.*;

import static mindustry.Vars.*;

public class DynamicEffect extends Effect {
	public float intensity = 1f;

	public DynamicEffect(float life, float clipScl, float scl, Cons<EffectContainer> renderer) {
		this.intensity = scl;
		this.id = all.size;
        this.lifetime = life;
        this.renderer = renderer;
        this.clip = clipsize;
        all.add(this);
	}
	public DynamicEffect(float life, float scl, Cons<EffectContainere> renderer) {
		this.intensity = scl;
        this(life, 50f, renderer);
	}
	public DynamicEffect(float scl){
        this.id = all.size;
        this.intensity = scl;
        all.add(this);
    }
}