package klumel8.Skilling.MonkeyTrainer.Branches.GoToSpot.Leaves;

import klumel8.KlumAPI.Framework.Leaf;
import klumel8.Skilling.MonkeyTrainer.Shared;
import org.powbot.api.rt4.Movement;
import org.powbot.api.rt4.Players;

public class Walker extends Leaf {

    @Override
    public boolean validate() {
        return Shared.baseTile.distanceTo(Players.local().tile()) < 100 && Shared.baseTile.distanceTo(Players.local().tile()) > 0;
    }

    @Override
    public void execute() {
        Movement.walkTo(Shared.baseTile);
    }

    @Override
    public String status() {
        return "Walking";
    }
}
