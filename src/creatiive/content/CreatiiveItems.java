package creatiive.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class CreatiiveItems implements ContentList {
	public static Item 
	highCarbonSteel, dusterite, moisturizedDust;

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
	}
}
