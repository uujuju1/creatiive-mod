package creatiive.type;

import arc.graphics.*;
import arc.util.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.world.meta.*;

public class SuperFluid extends UnlockableContent {
	public Color color = Color.black;
	public float flammability = 0;
	public float heatCapacity = 0.5;
	public float viscocity = 0;
	public float radioactivity = 0;
	public float temperature = 0.5f;
	public StatusEffect effect = StatusEffects.none;

	public SuperFluid(String name, Color color) {
		super(name);
		this.color = color;
	}

	@Override
	public void setStats() {
		stats.addPercent(Stat.radioactivity, radioactivity);
        stats.addPercent(Stat.flammability, flammability);
        stats.addPercent(Stat.temperature, temperature);
        stats.addPercent(Stat.heatCapacity, heatCapacity);
        stats.addPercent(Stat.viscosity, viscosity);
	}

	@Override
    public String toString(){
        return localizedName;
    }

    @Override
    public ContentType getContentType(){
        return CreatiiveContentType.superFluid;
    }
}