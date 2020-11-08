package net.arcanecitadel.morepaths;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import net.arcanecitadel.morepaths.registries.BlockRegistry;
import net.arcanecitadel.morepaths.registries.ItemRegistry;

	@Mod(ModLoader.MODID)
	public class ModLoader {

		public static final String MODID = "morepaths";
		public static final String NAME = "More Paths";
		public static final String VERSION = "1.15.2-1.0.0";

		public ModLoader() {
			BlockRegistry.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
			ItemRegistry.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

			FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
		}

		private void commonSetup(FMLCommonSetupEvent evt) {
			ReflectionNonsense
					.updateShovelRightClickBlocks(ImmutableMap.of(Blocks.DIRT, Blocks.GRASS_PATH.getDefaultState(),
							Blocks.GRAVEL, BlockRegistry.GRAVEL_PATH.get().getDefaultState(), Blocks.COARSE_DIRT,
							BlockRegistry.COARSE_DIRT_PATH.get().getDefaultState(), Blocks.SAND,
							BlockRegistry.SAND_PATH.get().getDefaultState(), Blocks.SNOW_BLOCK,
							BlockRegistry.SNOW_PATH.get().getDefaultState()));

			ReflectionNonsense.updateShovelEffectiveOnBlocks(
					new Block[] { BlockRegistry.GRAVEL_PATH.get(), BlockRegistry.COARSE_DIRT_PATH.get(),
							BlockRegistry.SAND_PATH.get(), BlockRegistry.SNOW_PATH.get(), });
		}
}
