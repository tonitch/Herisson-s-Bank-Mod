package ovh.herisson.tonitch.Items;

import net.minecraft.item.Item;
import ovh.herisson.tonitch.HBM;

public class Bills extends Item {
    public Bills() {
        super(new Properties().group(HBM.itemGroup));
        setRegistryName("bill");
    }
}
