package ovh.herisson.tonitch.Money;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MoneyProvider implements ICapabilitySerializable<INBT>{

    public MoneyProvider() {
    }

    @CapabilityInject(IMoney.class)
    public static Capability<IMoney> money;

    public IMoney instance = money.getDefaultInstance();
    private LazyOptional<IMoney> handler = LazyOptional.of(() -> this.instance);


    @Override
    public INBT serializeNBT() {
        return money.getStorage().writeNBT(money, this.instance, null);
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        money.getStorage().readNBT(money, this.instance, null, nbt);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == money){
            return handler.cast();
        }
        return LazyOptional.empty();
    }
}

