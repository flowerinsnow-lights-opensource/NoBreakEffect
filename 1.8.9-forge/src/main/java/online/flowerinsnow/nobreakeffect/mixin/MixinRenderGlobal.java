package online.flowerinsnow.nobreakeffect.mixin;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.util.BlockPos;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import online.flowerinsnow.nobreakeffect.event.AddBlockDestroyEffectsEvent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(RenderGlobal.class)
@SideOnly(Side.CLIENT)
public class MixinRenderGlobal {
    @Shadow
    @Final
    private Minecraft mc;
    @Redirect(
            method = "playAuxSFX",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/particle/EffectRenderer;addBlockDestroyEffects(Lnet/minecraft/util/BlockPos;Lnet/minecraft/block/state/IBlockState;)V",
                    ordinal = 0
            )
    )
    public void callAddBlockDestroyEffects(EffectRenderer instance, BlockPos blockPosIn, IBlockState blockState) {
        AddBlockDestroyEffectsEvent event = new AddBlockDestroyEffectsEvent(blockPosIn, blockState);
        if (!MinecraftForge.EVENT_BUS.post(event)) {
            this.mc.effectRenderer.addBlockDestroyEffects(event.blockPosIn, event.blockState);
        }
    }
}
