package online.flowerinsnow.nobreakeffect;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import online.flowerinsnow.nobreakeffect.listener.AddBlockDestroyEffectsListener;

@Mod(
        modid = NoBreakEffect.MODID,
        version = NoBreakEffect.VERSION,
        clientSideOnly = true
)
@SideOnly(Side.CLIENT)
public class NoBreakEffect {
    public static final String MODID = "no-break-effect";
    public static final String VERSION = "2.0.0";

    @EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new AddBlockDestroyEffectsListener());
    }
}
