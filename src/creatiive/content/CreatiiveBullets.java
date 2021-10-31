package creatiive.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.util.*;
import mindustry.ctype.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.*;

public class CreatiiveBullets implements ContentList {
	public static BulletType 
		// pull default
		pullSmall, pullMedium, pullLarge,

		// pull home
		pullHomeSmall, pullHomeMedium, pullHomeLarge;

	@Override
	public void load() {
		pullSmall = new BasicBulletType(4f, 20) {{
			lifetime = 30f;
			width = 9f;
			height = 11f;
            pierce = true;
            pierceCap = 10;
            ammoMultiplier = 2;
            knockback = -1;
		}};
		pullMedium = new BasicBulletType(4f, 30) {{
			lifetime = 30f;
			width = 9f;
			height = 11f;
            pierce = true;
            pierceCap = 15;
            ammoMultiplier = 2;
            knockback = -1.5f;
		}};
		pullLarge = new BasicBulletType(4f, 50) {{
			lifetime = 30f;
			width = 9f;
			height = 11f;
            pierce = true;
            pierceCap = 15;
            ammoMultiplier = 2;
            knockback = -2f;
		}};

		pullHomeSmall = new MissileBulletType(4f, 17) {{
			lifetime = 30f;
			width = 9f;
			height = 11f;
            pierce = true;
            pierceCap = 10;
            ammoMultiplier = 2;
            knockback = -1f;
		}};
		pullHomeMedium = new MissileBulletType(4f, 26) {{
			lifetime = 30f;
			width = 9f;
			height = 11f;
            pierce = true;
            pierceCap = 15;
            ammoMultiplier = 2;
            knockback = -1.5f;
		}};
		pullHomeLarge = new MissileBulletType(4f, 45) {{
			lifetime = 30f;
			width = 9f;
			height = 11f;
            pierce = true;
            pierceCap = 15;
            ammoMultiplier = 2;
            knockback = -2f;
		}};
	}
}