package creatiive.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.entities.bullet.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.meta.*;
import mindustry.world.draw.*;

import creatiive.content.*;
import creatiive.world.blocks.*;

import static mindustry.type.ItemStack.with;

public class CreatiiveWalls implements ContentList {
	public static Block
	// dustertite
	dusteriteWall, dusteriteWallLarge, dusteriteWallHuge, dusteriteWallGigantic,
	// erbite
    erbiteWall, erbiteWallLarge, erbiteWallHuge, erbiteWallGigantic;

    @Override
    public void load() {
    	dusteriteWall = new Wall("dusterite-wall") {{
			requirements(Category.defense, with(CreatiiveItems.dusterite, 6));
			localizedName = "Dusterite Wall";
			health = 350;
			size = 1;
		}};
		dusteriteWallLarge = new Wall("dusterite-wall-large") {{
			requirements(Category.defense, with(CreatiiveItems.dusterite, 6 * 4));
			localizedName = "Large Dusterite Wall";
			health = 350 * 4;
			size = 2;
		}};
		dusteriteWallHuge = new Wall("dusterite-wall-huge") {{
			requirements(Category.defense, with(CreatiiveItems.dusterite, 6 * 9));
			localizedName = "Huge Dusterite Wall";
			details = "sus";
			health = 350 * 11;
			size = 3;
		}};
		dusteriteWallGigantic = new Wall("dusterite-wall-gigantic") {{
			requirements(Category.defense, with(CreatiiveItems.dusterite, 6 * 16));
			localizedName = "Gigantic Dusterite Wall";
			health = 350 * 17;
			size = 4;
		}};

        erbiteWall = new Wall("erbite-wall") {{
            requirements(Category.defense, with(CreatiiveItems.erbite, 6));
            localizedName = "Erbite Wall";
            size = 1;
            health = 460;
        }};
        erbiteWallLarge = new Wall("erbite-wall-large") {{
            requirements(Category.defense, with(CreatiiveItems.erbite, 6 * size * size));
            localizedName = "Large Erbite Wall";
            size = 2;
            health = 460 * 4;
        }};
        erbiteWallHuge = new Wall("erbite-wall-huge") {{
            requirements(Category.defense, with(CreatiiveItems.erbite, 6 * size * size));
            localizedName = "Huge Erbite Wall";
            size = 3;
            health = 460 * 11;
        }};
        erbiteWallGigantic = new Wall("erbite-wall-gigantic") {{
            requirements(Category.defense, with(CreatiiveItems.erbite, 6 * size * size));
            localizedName = "Gigantic Erbite Wall";
            size = 4;
            health = 460 * 17;
        }};
    }
}