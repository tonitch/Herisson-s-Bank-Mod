package ovh.herisson.tonitch.Items;

import net.minecraft.item.Item;
import ovh.herisson.tonitch.HBM;

public class Coin extends Item {
    public Coin() {
        super(new Properties().group(HBM.itemGroup));
        setRegistryName("coin");
    }
}
