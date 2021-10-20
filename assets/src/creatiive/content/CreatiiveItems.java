package creatiive.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Item;

public class CreatiiveItems implements ContentList {
	public static Item 
	highCarbonSteel, fabric, chlorophite, refractoryGlass, cesium;

	@Override
	public void load(){
		highCarbonSteel = new Item("high-carbon-steel", Color.valueOf("515151")) {{
			localizedName = "High Carbon Steel";
			cost = 5;
		}};
		fabric = new Item("fabric", Color.valueOf("BFBFBF")) {{
			localizedName = "Fabric";
			cost = 3;
		}};
		chlorophite = new Item("chlorophite", Color.valueOf("17851C")) {{
			localizedName = "Chlorophite";
			cost = 4;
			flammability = 0.3f;
		}};
		refractoryGlass = new Item("refractory-glass", Color.valueOf("9DA8DC")) {{
			localizedName = "refractory Glass";
			cost = 7;
		}};
		cesium = new Item("cesium", Color.valueOf("A4A498")) {{
			localizedName = "Cesium";
			cost = 6;
		}};
	}
}
