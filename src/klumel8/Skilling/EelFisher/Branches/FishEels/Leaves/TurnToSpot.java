package klumel8.Skilling.EelFisher.Branches.FishEels.Leaves;

import klumel8.Skilling.EelFisher.EelMain;
import klumel8.KlumAPI.Framework.Leaf;
import org.powbot.api.rt4.Camera;
import org.powbot.api.rt4.Npc;
import org.powbot.api.rt4.Npcs;
import org.powbot.api.rt4.Players;
import org.powbot.api.rt4.stream.locatable.interactive.NpcStream;

public class TurnToSpot extends Leaf {
    @Override
    public boolean validate() {
        NpcStream fishSpots = Npcs.stream().id(EelMain.spotId).nearest();
        if(fishSpots.isEmpty()){
            return false;
        }
        Npc fishSpot = fishSpots.first();
        return fishSpot.valid() && !fishSpot.inViewport() && fishSpot.tile().distanceTo(Players.local().tile()) < 8;
    }

    @Override
    public void execute() {
        Camera.turnTo(Npcs.stream().id(EelMain.spotId).nearest().first());
    }

    @Override
    public String status() {
        return "Turning to spot";
    }
}
