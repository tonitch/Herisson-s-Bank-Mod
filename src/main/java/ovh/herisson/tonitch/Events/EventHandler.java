package ovh.herisson.tonitch.Events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ovh.herisson.tonitch.HBM;
import ovh.herisson.tonitch.Money.IMoney;
import ovh.herisson.tonitch.Money.MoneyProvider;



@Mod.EventBusSubscriber(modid = HBM.MODID, bus=Mod.EventBusSubscriber.Bus.FORGE)
public class EventHandler {

    @SubscribeEvent
    public static void onCapUpdate(AttachCapabilitiesEvent<Entity> event){
        if(event.getObject() instanceof PlayerEntity){
            event.addCapability(new ResourceLocation(HBM.MODID, "money"), new MoneyProvider());
        }
    }

    @SubscribeEvent
    public static void onCloneMoney(PlayerEvent.Clone event){
        PlayerEntity newPlayer = event.getPlayer();
        PlayerEntity oldPlayer = event.getOriginal();
        newPlayer.getCapability(MoneyProvider.money).orElse(null).setMoney(oldPlayer.getCapability(MoneyProvider.money).orElse(null).getMoney());
    }

    @SubscribeEvent
    public static void onJump(LivingEvent.LivingJumpEvent event){
        if(event.getEntityLiving() instanceof PlayerEntity){
            IMoney data = event.getEntityLiving().getCapability(MoneyProvider.money).orElse(null);
            data.giveMoney(1.0f);
            System.out.println("test");
        }
    }
}
