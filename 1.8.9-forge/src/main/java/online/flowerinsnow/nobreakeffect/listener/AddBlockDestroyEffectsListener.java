package online.flowerinsnow.nobreakeffect.listener;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import online.flowerinsnow.nobreakeffect.event.AddBlockDestroyEffectsEvent;

@SideOnly(Side.CLIENT)
public class AddBlockDestroyEffectsListener {
    @SubscribeEvent
    public void onAddBlockDestroyEffects(AddBlockDestroyEffectsEvent event) {
        event.setCanceled(true);
    }
}
