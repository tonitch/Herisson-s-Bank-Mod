package ovh.herisson.tonitch.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import ovh.herisson.tonitch.block.Tiles.TileATM;

import javax.annotation.Nullable;

public class BlockATM extends Block {

    public BlockATM() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(2.0F)
                .lightValue(15)
                .sound(SoundType.METAL)
        );
        setRegistryName("atm");
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        if(placer != null) {
            worldIn.setBlockState(pos, state.with(BlockStateProperties.FACING, getFacingFromEntity(pos, placer)),2);
        }
    }

    private static Direction getFacingFromEntity(BlockPos pos, LivingEntity placer) {
        return Direction.getFacingFromVector((float) (placer.prevPosX - pos.getX()), (float) (placer.prevPosY - pos.getY()),(float) (placer.prevPosZ - pos.getZ()));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileATM();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult p_225533_6_) {
        if(!worldIn.isRemote){
            TileEntity blockTile = worldIn.getTileEntity(pos);
            if(blockTile instanceof TileATM){
                if(handIn == Hand.MAIN_HAND){
                    player.openContainer((TileATM)blockTile);
                    return ActionResultType.SUCCESS;
                }
            }
        }
        return ActionResultType.SUCCESS;
    }
}
