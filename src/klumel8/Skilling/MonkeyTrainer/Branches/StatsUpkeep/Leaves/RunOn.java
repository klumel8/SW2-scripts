package klumel8.Skilling.MonkeyTrainer.Branches.StatsUpkeep.Leaves;

import klumel8.KlumAPI.Framework.Leaf;
import org.powbot.api.Condition;
import org.powbot.api.rt4.Movement;

public class RunOn extends Leaf {
    @Override
    public boolean validate() {
        return !Movement.running() && Movement.energyLevel() > 10;
    }

    @Override
    public void execute() {
        if(Movement.running(true)) {
            Condition.wait(() -> Movement.running(), 100, 12);
        }
    }

    @Override
    public String status() {
        return "Enabling run";
    }
}
