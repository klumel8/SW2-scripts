package klumel8.Skilling.Lavas.Branches.RepairPouch.Leaves;

import klumel8.KlumAPI.Framework.Leaf;
import org.powbot.api.Condition;
import org.powbot.api.rt4.Bank;

public class CloseBankMage extends Leaf {
    @Override
    public boolean validate() {
        return Bank.opened();
    }

    @Override
    public void execute() {
        if(Bank.close()) {
            Condition.wait(() -> !Bank.opened(), 100, 18);
        }
    }

    @Override
    public String status() {
        return "closing bank";
    }
}
