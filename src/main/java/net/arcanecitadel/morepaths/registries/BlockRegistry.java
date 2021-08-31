package net.arcanecitadel.morepaths.registries;

import java.util.HashMap;

import net.arcanecitadel.morepaths.ModLoader;
import net.arcanecitadel.morepaths.blocks.OtherPathBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassPathBlock;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModLoader.MODID);

	public static final RegistryObject<Block> GRAVEL_PATH = BLOCKS.register("gravel_path", () -> createBlock(Blocks.GRAVEL));
	public static final RegistryObject<Block> COARSE_DIRT_PATH = BLOCKS.register("coarse_dirt_path", () -> createBlock(Blocks.COARSE_DIRT));
	public static final RegistryObject<Block> SAND_PATH = BLOCKS.register("sand_path", () -> createBlock(Blocks.SAND));
	public static final RegistryObject<Block> SNOW_PATH = BLOCKS.register("snow_path", () -> createBlock(Blocks.SNOW_BLOCK));
	
    static HashMap<Block, GrassPathBlock> ALL_PATHS = new HashMap<Block, GrassPathBlock>();
    
    private static OtherPathBlock createBlock(Block fromBlock)
    {
    	OtherPathBlock regBlock = new OtherPathBlock(fromBlock);
    	ALL_PATHS.put(fromBlock, regBlock);
    	return regBlock;
    }
    
    public static Block getPathForBlock(Block fromBlock)
    {
    	GrassPathBlock path = ALL_PATHS.get(fromBlock);
    	return path;
    }
    
    public static void registerDirtAsPathable()
    {
    	ALL_PATHS.put(Blocks.DIRT, (GrassPathBlock)Blocks.GRASS_PATH);
    }
}
