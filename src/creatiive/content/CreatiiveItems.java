package creatiive.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class CreatiiveItems implements ContentList {
	public static Item 
	// scaler
	highCarbonSteel, dusterite, moisturizedDust,

	// vuintuer
	erbite, zicromnium, lerbonium,

	// krus
	deltaMatter, pelenium, kotelene;

	@Override
	public void load(){
		highCarbonSteel = new Item("high-carbon-steel", Color.valueOf("515151")) {{
			localizedName = "High Carbon Steel";
			cost = 5;
		}};
		dusterite = new Item("dusterite", Color.valueOf("8F7956")) {{
			localizedName = "Dusterite";
			hardness = 1;
		}};
		moisturizedDust = new Item("moisturized-dust", Color.valueOf("BDC375")) {{
			localizedName = "Moisturized Dust";
			cost = 3;
			flammability = 0.8f;
		}};
		erbite = new Item("erbite", Color.valueOf("3D3253")) {{
			localizedName = "Erbite";
			cost = 2;
		}};
		zicromnium = new Item("zicromnium", Color.valueOf("9999D4")) {{
			localizedName = "Zicromnium";
			cost = 7;
			hardness = 1;
		}};
		lerbonium = new Item("lerbonium", Color.valueOf("5F3037")) {{
			localizedName = "Lerbonium";
			cost = 12;
		}};
		deltaMatter = new Item("delta-matter", Color.valueOf("242F97")) {{
			localizedName = "Delta Matter";
			cost = 3;
		}};
		pelenium = new Item("pelenium", Color.valueOf("76A8A6")) {{
			localizedName = "Pelenium";
			cost = 2;
			hardness = 3;
		}};
		kotelene = new Item("kotelene", Color.valueOf("1D8E45")) {{
			localizedName = "Kotelene";
			cost = 3;
		}};
	}
}
