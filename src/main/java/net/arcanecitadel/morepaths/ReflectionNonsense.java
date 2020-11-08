package net.arcanecitadel.morepaths;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ShovelItem;

public class ReflectionNonsense {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void updateShovelRightClickBlocks(Map<Block, BlockState> addToMap) {
		try {
			Class<Map<Block, BlockState>> clazz = (Class<Map<Block, BlockState>>) ((Class) Map.class);

			Field field = findFirstPrivateOrProtectedFieldOfType(ShovelItem.class, clazz);
			field.setAccessible(true);

			Map<Block, BlockState> map = (Map<Block, BlockState>) field.get(null);

			for (Map.Entry<Block, BlockState> entry : addToMap.entrySet()) {
				map.put(entry.getKey(), entry.getValue());
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void updateShovelEffectiveOnBlocks(Block[] blocksToAdd) {
		try {
			Class<Set<Block>> clazz = (Class<Set<Block>>) ((Class) Set.class);

			Field field = findFirstPrivateOrProtectedFieldOfType(ShovelItem.class, clazz);
			field.setAccessible(true);

			Set<Block> set = (Set<Block>) field.get(null);

			for (Block entry : blocksToAdd) {
				set.add(entry);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static Field findFirstPrivateOrProtectedFieldOfType(Class<?> clazz, Class<?> type) {
		Field[] fields = clazz.getDeclaredFields();

		for (Field f : fields) {
			if (Modifier.isPublic(f.getModifiers()))
				continue;

			if (f.getType().equals(type))
				return f;
		}

		throw new RuntimeException("could not find non-public field of type " + type.toString());
	}

}