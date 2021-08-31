package net.arcanecitadel.morepaths.registries;

import net.arcanecitadel.morepaths.ModLoader;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {

	public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModLoader.MODID);
	
	//block items
	public static final RegistryObject<Item> GRAVEL_PATH = ITEMS.register("gravel_path", () -> new BlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ModLoader.MODID, "gravel_path")), new Item.Properties()));
    public static final RegistryObject<Item> COARSE_DIRT_PATH = ITEMS.register("coarse_dirt_path", () -> new BlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ModLoader.MODID, "coarse_dirt_path")), new Item.Properties()));
    public static final RegistryObject<Item> SAND_PATH = ITEMS.register("sand_path", () -> new BlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ModLoader.MODID, "sand_path")), new Item.Properties()));
    public static final RegistryObject<Item> SNOW_PATH = ITEMS.register("snow_path", () -> new BlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ModLoader.MODID, "snow_path")), new Item.Properties()));
}
