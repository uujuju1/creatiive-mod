package creatiive;
 
import creatiive.content.*;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

public class Creatiive extends Mod{

    @Override
    public void loadContent(){
    	new CreatiiveItems().load();
    	new CreatiiveBlocks().load();
    	new CreatiiveUnitTypes().load();
    	new CreatiivePlanets().load();
    	new CreatiiveBullets().load();
    }
}
