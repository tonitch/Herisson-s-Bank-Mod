package ovh.herisson.tonitch;

import net.minecraft.block.Block;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ovh.herisson.tonitch.Items.Bills;
import ovh.herisson.tonitch.Items.Coin;
import ovh.herisson.tonitch.block.BlockATM;
import ovh.herisson.tonitch.block.Containers.ContainerATM;
import ovh.herisson.tonitch.block.ModBlocks;
import ovh.herisson.tonitch.block.Tiles.TileATM;

@Mod.EventBusSubscriber(modid=HBM.MODID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class ModRegistryEvents {
    @SubscribeEvent
    public static void onBlocksRegistry(RegistryEvent.Register<Block> event){
        event.getRegistry().register(new BlockATM());
    }
    @SubscribeEvent
    public static void onItemsRegistry(RegistryEvent.Register<Item> event){
        event.getRegistry().register(new BlockItem(ModBlocks.atm, new Item.Properties().group(HBM.itemGroup)).setRegistryName("atm"));
        event.getRegistry().register(new Bills());
        event.getRegistry().register(new Coin());
    }

    @SubscribeEvent
    public static void onTileEntityRegistry(RegistryEvent.Register<TileEntityType<?>> event){
        TileEntityType<?> type = TileEntityType.Builder.create(() -> new TileATM(), ModBlocks.atm).build(null).setRegistryName("atm");
        event.getRegistry().register(type);
    }

    @SubscribeEvent
    public static void onContainerRegistry(RegistryEvent.Register<ContainerType<?>> event){
        event.getRegistry().register(IForgeContainerType.create((id, inv, data) -> {
            BlockPos pos = data.readBlockPos();
            return new ContainerATM(id, inv, pos);
        }).setRegistryName("atm"));

    }
}
