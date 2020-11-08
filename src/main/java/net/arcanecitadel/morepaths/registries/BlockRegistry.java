package net.arcanecitadel.morepaths.registries;

import net.arcanecitadel.morepaths.ModLoader;
import net.arcanecitadel.morepaths.blocks.OtherPathBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModLoader.MODID);

    public static final RegistryObject<Block> GRAVEL_PATH = BLOCKS.register("gravel_path", () -> new OtherPathBlock(Blocks.GRAVEL));
    public static final RegistryObject<Block> COARSE_DIRT_PATH = BLOCKS.register("coarse_dirt_path", () -> new OtherPathBlock(Blocks.COARSE_DIRT));
    public static final RegistryObject<Block> SAND_PATH = BLOCKS.register("sand_path", () -> new OtherPathBlock(Blocks.SAND));
    public static final RegistryObject<Block> SNOW_PATH = BLOCKS.register("snow_path", () -> new OtherPathBlock(Blocks.SNOW_BLOCK));
}
