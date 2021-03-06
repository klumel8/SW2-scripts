package klumel8.Skilling.Lavas.Branches.GoToRuins.Leaves;

import klumel8.KlumAPI.Framework.Leaf;
import org.powbot.api.Condition;
import org.powbot.api.rt4.Movement;

public class AlwaysRun extends Leaf {
    @Override
    public boolean validate() {
        return !Movement.running();
    }

    @Override
    public void execute() {
        if(Movement.running()) {
            Condition.wait(() -> !Movement.running(), 100, 12);
        }
    }

    @Override
    public String status() {
        return "enabling run";
    }
}
