package ovh.herisson.tonitch.Money;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class MoneyStorage implements Capability.IStorage<IMoney> {
    public MoneyStorage() {
    }

    @Nullable
    @Override
    public CompoundNBT writeNBT(Capability<IMoney> capability, IMoney instance, Direction side) {
        CompoundNBT compound = new CompoundNBT();
        compound.putFloat("money", instance.getMoney());
        return compound;
    }

    @Override
    public void readNBT(Capability<IMoney> capability, IMoney instance, Direction side, INBT nbt) {
        instance.setMoney(((CompoundNBT) nbt).getFloat("money"));

    }
}
