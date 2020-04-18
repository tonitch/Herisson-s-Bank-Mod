package ovh.herisson.tonitch;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ovh.herisson.tonitch.Money.*;
import ovh.herisson.tonitch.Screens.ScreenATM;
import ovh.herisson.tonitch.block.Containers.ContainerATM;
import ovh.herisson.tonitch.block.ModBlocks;

@Mod(HBM.MODID)
public class HBM
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "hbm";
    public static ItemGroup itemGroup = new ItemGroup("Herisson's Bank"){
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.atm);
        }
    };

    public HBM() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        CapabilityManager.INSTANCE.register(IMoney.class, new MoneyStorage() ,new MoneyFactory());
        ScreenManager.registerFactory(ModBlocks.atm, ScreenATM::new);
    }
