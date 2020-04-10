package ovh.herisson.tonitch.Events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
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
        System.out.println("hey an entity here just evented");
        if(event.getObject() instanceof PlayerEntity){
            System.out.println("hey a player here just evented");
            event.addCapability(new ResourceLocation(HBM.MODID, "money"), new MoneyProvider());
        }
    }

    @SubscribeEvent
    public static void onPlyClone(PlayerEvent.Clone event){
        PlayerEntity player = event.getPlayer();
        IMoney money = (IMoney) player.getCapability(MoneyProvider.money, null);
        IMoney oldmoney = (IMoney) event.getOriginal().getCapability(MoneyProvider.money, null);

        money.setMoney(oldmoney.getMoney());

    }

}
