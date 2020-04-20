package ovh.herisson.tonitch.block.Containers;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import ovh.herisson.tonitch.Items.Bills;
import ovh.herisson.tonitch.Items.Coin;
import ovh.herisson.tonitch.Items.ModItems;

import javax.annotation.Nonnull;

public class ContainerATM extends Container {

    private TileEntity tileEntity;
    public IItemHandler inputInventory = new ItemStackHandler(2);

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        return super.transferStackInSlot(playerIn, index);
    }

    public ContainerATM(int id, PlayerInventory inv, BlockPos pos) {
        super(ModContainers.atm, id);
        this.tileEntity = inv.player.world.getTileEntity(pos);
        this.inputInventory.insertItem(0, new ItemStack(ModItems.coin, 16), false);
        inv.openInventory(inv.player);
        addSlot(new SlotItemHandler(inputInventory, 0, 50,53));
        addSlot(new SlotItemHandler(inputInventory, 1, 109,53));


        // Player Inventory
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inv, k, 8 + k * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return true;
    }

}
