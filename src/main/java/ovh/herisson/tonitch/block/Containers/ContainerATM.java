package ovh.herisson.tonitch.block.Containers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;

public class ContainerATM extends Container {

    private PlayerEntity playerEntity;
    private IInventory atmInventory;

    public ContainerATM(int id, PlayerInventory inv) {
        super(ModContainers.atm, id);
        this.atmInventory = inv;
        this.playerEntity = inv.player;
        this.atmInventory.openInventory(this.playerEntity);
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }
}
