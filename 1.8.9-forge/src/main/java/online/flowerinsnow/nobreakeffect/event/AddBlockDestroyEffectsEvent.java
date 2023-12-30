package online.flowerinsnow.nobreakeffect.event;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Cancelable
@SideOnly(Side.CLIENT)
public class AddBlockDestroyEffectsEvent extends Event {
    public BlockPos blockPosIn;
    public IBlockState blockState;

    public AddBlockDestroyEffectsEvent(BlockPos blockPosIn, IBlockState blockState) {
        this.blockPosIn = blockPosIn;
        this.blockState = blockState;
    }

    @Override
    public boolean isCancelable() {
        return true;
    }
}
