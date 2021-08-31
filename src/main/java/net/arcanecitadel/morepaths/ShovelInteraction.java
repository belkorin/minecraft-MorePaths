package net.arcanecitadel.morepaths;

import net.arcanecitadel.morepaths.registries.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ShovelInteraction {

	@SubscribeEvent
	public static void onRightClick(PlayerInteractEvent.RightClickBlock event) {
		
		PlayerEntity p = event.getPlayer();
		
		ItemStack held = p.getHeldItemMainhand();
		
		Item item = held.getItem();
		boolean isShovel = item.getToolTypes(held).contains(ToolType.SHOVEL);
		
		if(!isShovel)
			return;
		
		Direction facing = event.getFace();
		
		if(facing == null)
			return;
		
		BlockPos pos = event.getPos();
		
		boolean playerCanEditBlock = p.canPlayerEdit(pos.offset(facing), facing, held);
		if(!playerCanEditBlock)
			return;
		
		World world = event.getWorld();
		
		Material blockAbove = world.getBlockState(pos.up()).getMaterial();
		if(blockAbove != Material.AIR)
			return;
		
		Block targetBlock = world.getBlockState(pos).getBlock();
		
		Block pathBlock = BlockRegistry.getPathForBlock(targetBlock);
		
		if(pathBlock == null)
			return;
		
		world.playSound(p, pos, SoundEvents.ITEM_SHOVEL_FLATTEN, SoundCategory.BLOCKS, 1.0F, 1.0F);

		if(!world.isRemote) {
			world.setBlockState(event.getPos(), pathBlock.getDefaultState());
			held.damageItem(1, p, (pl) -> { pl.sendBreakAnimation(EquipmentSlotType.MAINHAND); });
		}

		event.setCanceled(true);
		event.setCancellationResult(ActionResultType.SUCCESS);
		
	}
}
