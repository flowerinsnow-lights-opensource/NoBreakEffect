package online.flowerinsnow.nobreakeffect;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoBreakEffect implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("no-break-effect");

	@Override
	public void onInitializeClient() {
		LOGGER.info("No Break Effect initialized");
	}
}