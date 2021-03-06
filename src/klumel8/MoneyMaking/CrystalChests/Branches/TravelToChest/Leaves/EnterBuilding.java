package klumel8.MoneyMaking.CrystalChests.Branches.TravelToChest.Leaves;

import klumel8.MoneyMaking.CrystalChests.CrystalConstants;
import klumel8.KlumAPI.Framework.Leaf;
import org.powbot.api.Condition;
import org.powbot.api.rt4.Movement;
import org.powbot.api.rt4.Objects;
import org.powbot.api.rt4.Players;
import org.powbot.api.rt4.stream.locatable.interactive.GameObjectStream;

import java.util.Random;

public class EnterBuilding extends Leaf {
    @Override
    public boolean validate() {
        GameObjectStream doors = Objects.stream().name("Door").nearest(CrystalConstants.doorTile);

        return CrystalConstants.doorTile.distanceTo(Players.local().tile()) < 6 && !doors.first().actions().contains("Open");
    }

    @Override
    public void execute() {
        Random rand = new Random();
        if(Movement.step(CrystalConstants.chestArea.getCentralTile().derive(rand.nextInt(3)-1,rand.nextInt(3)-1))) {
            Condition.wait(() -> CrystalConstants.chestArea.getCentralTile().distanceTo(Players.local().tile()) < 6, 100, 40);
        }
    }

    @Override
    public String status() {
        return null;
    }
}
