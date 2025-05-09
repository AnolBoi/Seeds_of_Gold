package net.anoltongi.seedsofgold;

import net.anoltongi.seedsofgold.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeedsOfGold implements ModInitializer {
	public static final String MOD_ID = "seeds_of_gold";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
		ModItems.registerModItems();
	}
}