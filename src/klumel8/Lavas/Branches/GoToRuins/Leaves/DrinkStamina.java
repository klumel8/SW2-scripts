package klumel8.Lavas.Branches.GoToRuins.Leaves;

import klumel8.Framework.Leaf;
import klumel8.Lavas.store.LavaConstants;
import klumel8.Lavas.store.Store;
import org.powbot.api.Condition;
import org.powbot.api.rt4.Inventory;
import org.powbot.api.rt4.Item;
import org.powbot.api.rt4.Movement;

public class DrinkStamina extends Leaf {
    LavaConstants lc = new LavaConstants();

    @Override
    public boolean validate() {
        return Movement.energyLevel() < lc.runThreshold && Store.useStaminas && Inventory.stream().filtered(s -> s.name().contains("Stamina")).isNotEmpty();
    }

    @Override
    public void execute() {
        Item stam = Inventory.stream().filtered(s -> s.name().contains("Stamina")).first();
        stam.interact("Drink");
        Condition.wait(() -> !stam.valid(), 100, 12);
        if(Inventory.stream().name("Vial").isNotEmpty()){
            Inventory.stream().name("Vial").first().interact("Drop");
        }
    }

    @Override
    public String status() {
        return "drinking stamina";
    }
}