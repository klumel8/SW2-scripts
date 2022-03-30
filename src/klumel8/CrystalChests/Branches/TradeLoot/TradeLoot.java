package klumel8.CrystalChests.Branches.TradeLoot;

import klumel8.CrystalChests.CrystalConstants;
import klumel8.Framework.Branch;
import klumel8.Framework.Leaf;

import java.util.List;

public class TradeLoot extends Branch {
    public final List<Leaf> leaves;

    public TradeLoot(Leaf... leaves) {
        super(leaves);
        this.leaves = List.of(leaves);
    }

    @Override
    public boolean validate() {
        return CrystalConstants.doGE;
    }

    @Override
    public String status() {
        return "Trading loot";
    }
}
