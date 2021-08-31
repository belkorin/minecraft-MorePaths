package net.arcanecitadel.morepaths;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.arcanecitadel.morepaths.blocks.OtherPathBlock;
import net.arcanecitadel.morepaths.registries.BlockRegistry;
import net.arcanecitadel.morepaths.registries.ItemRegistry;

	@Mod(ModLoader.MODID)
	public class ModLoader {

		public static final String MODID = "morepaths";
		public static final String NAME = "More Paths";
		public static final String VERSION = "1.15.2-1.2.0";
	    public static Logger logger = LogManager.getLogger();


		public ModLoader() {
			BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
			ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
			
	        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

			MinecraftForge.EVENT_BUS.addListener(OtherPathBlock::doPlayerHarvestCheck);
			MinecraftForge.EVENT_BUS.addListener(ShovelInteraction::onRightClick);
		}
		
	    private void setup(final FMLCommonSetupEvent event)
	    {
	    	BlockRegistry.registerDirtAsPathable();
	    }
}
