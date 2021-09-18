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
    public static final RegistryObject<Item> RED_SAND_PATH = ITEMS.register("red_sand_path", () -> new BlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ModLoader.MODID, "red_sand_path")), new Item.Properties()));
    public static final RegistryObject<Item> PODZOL_PATH = ITEMS.register("podzol_path", () -> new BlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ModLoader.MODID, "podzol_path")), new Item.Properties()));
    public static final RegistryObject<Item> MYCELIUM_PATH = ITEMS.register("mycelium_path", () -> new BlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ModLoader.MODID, "mycelium_path")), new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_NYLIUM_PATH = ITEMS.register("crimson_nylium_path", () -> new BlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ModLoader.MODID, "crimson_nylium_path")), new Item.Properties()));
    public static final RegistryObject<Item> WARPED_NYLIUM_PATH = ITEMS.register("warped_nylium_path", () -> new BlockItem(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(ModLoader.MODID, "warped_nylium_path")), new Item.Properties()));
    
}
