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

    public Creatiive() {
        Events.on(ClientLoadEvent.class, e -> {
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("Mod is in develop");
                dialog.cont.add("If you wanna contribute with kool ideas go to [[cyan]]https://github.com/uujuju1/creatiive-mod").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("creatiive-startup-icon")).pad(20f).row();
                dialog.cont.button("Ok", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    } 

    @Override
    public void loadContent(){
    	new CreatiiveItems().load();
    	new CreatiiveUnitArc().load();
    	new CreatiiveUnitDust().load();
    	new CreatiiveUnitMisc().load();
    	new CreatiiveBlocks().load();
    	new CreatiiveTurrets().load();
    	new CreatiiveWalls().load();
    	new CreatiivePlanets().load();
        new CreatiiveTechTree().load();
    }
}
