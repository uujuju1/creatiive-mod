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

import static mindustry.Vars.*;

public class CreatiiveBullets implements ContentList {
	public static BulletType
	// dust
	pierceI, pierceII, pierceIII, pierceIV,

	// erbite
	homeI, homeII, homeIII, homeIV;

	@Override
	public void load() {
		pierceI = new BasicBulletType(4f, 15) {{
			lifetime = 30f;
			width = 7f;
			height = 9f;
			pierce = true;
			pierceCap = 10;
			frontColor = Color.valueOf("BDA072");
			backColor = Color.valueOf("8F7956");
		}};
		pierceII = new BasicBulletType(4f, 50) {{
			lifetime = 50f;
			width = 9f;
			height = 11f;
			pierce = true;
			pierceCap = 20;
			frontColor = Color.valueOf("BDA072");
			backColor = Color.valueOf("8F7956");
		}};
		pierceIII = new BasicBulletType(4f, 125) {{
			lifetime = 60f;
			width = 11f;
			height = 13f;
			pierce = true;
			pierceCap = 30;
			frontColor = Color.valueOf("BDA072");
			backColor = Color.valueOf("8F7956");
		}};
		pierceIV = new BasicBulletType(4f, 200) {{
			lifetime = 75f;
			width = 13f;
			height = 15f;
			pierce = true;
			pierceCap = 40;
			frontColor = Color.valueOf("BDA072");
			backColor = Color.valueOf("8F7956");
		}};

		homeI = new MissileBulletType(4f, 15) {{
			width = 7f;
			height = 9f;
    	lifetime = range/speed;
    	frontColor = Color.valueOf("63528A");
    	backColor = Color.valueOf("3D3253");
    }};
    homeII = new BasicBulletType(4f, 50) {{
    	width = 9f;
    	height = 11f;
    	lifetime = range/speed;
    	frontColor = Color.valueOf("63528A");
    	backColor = Color.valueOf("3D3253");
    }};
    homeIII = new BasicBulletType(6f, 150) {{
    	width = 11f;
    	height = 13f;
    	lifetime = range/speed;
    }};
    homeIV = new BasicBulletType(4f, 350) {{
    	lifetime = 75f;
    	width = 13f;
    	height = 15f;
    	pierce = true;
    	pierceCap = 40;
    	frontColor = Color.valueOf("63528A");
    	backColor = Color.valueOf("3D3253");
    }};
	}
}
