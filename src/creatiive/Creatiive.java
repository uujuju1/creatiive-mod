package creatiive;
 
import creatiive.content.*;

import mindustry.mod.Mod;

public class Creatiive extends Mod{

    @Override
    public void init(){
    }

    @Override
    public void loadContent(){
    	new CreatiiveItems().load();
    	new CreatiiveBlocks().load();
    }
}
