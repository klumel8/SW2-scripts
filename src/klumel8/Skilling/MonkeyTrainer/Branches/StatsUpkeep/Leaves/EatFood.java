package klumel8.Skilling.MonkeyTrainer.Branches.StatsUpkeep.Leaves;

import klumel8.KlumAPI.Framework.Leaf;
import klumel8.Skilling.MonkeyTrainer.Shared;
import org.powbot.api.Condition;
import org.powbot.api.rt4.Combat;
import org.powbot.api.rt4.Inventory;
import org.powbot.api.rt4.Item;

public class EatFood extends Leaf {
    @Override
    public boolean validate() {
        return Combat.health() < Combat.maxHealth() - 20;
    }

    @Override
    public void execute() {
        if(Inventory.stream().name(Shared.food).isEmpty()){
            return;
        }
        Item food = Inventory.stream().name(Shared.food).first();
        if(food.valid() && food.interact("Eat")) {
            Condition.wait(() -> Combat.health() > Combat.maxHealth() - 20, 100, 18);
        }
    }

    @Override
    public String status() {
        return "Eating food";
    }
}
