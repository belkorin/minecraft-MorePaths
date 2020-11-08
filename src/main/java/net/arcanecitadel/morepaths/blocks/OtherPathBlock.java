package net.arcanecitadel.morepaths.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.GrassPathBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.server.ServerWorld;

public class OtherPathBlock extends GrassPathBlock {

	private Block _pathedFrom;
	private boolean _isFallingBlock;
	
	public OtherPathBlock(Block pathedFrom) {
		super(Block.Properties.from(pathedFrom));
		_pathedFrom = pathedFrom;
		_isFallingBlock = pathedFrom instanceof FallingBlock;
	}
	
	@Override
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		if (checkIfFalling(worldIn, currentPos)) {
	         worldIn.getPendingBlockTicks().scheduleTick(currentPos, this, 1);
	      }

	      return super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
	}

	
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		worldIn.setBlockState(pos, nudgeEntitiesWithNewState(state, _pathedFrom.getDefaultState(), worldIn, pos));
	}
	
	@Override
	   public BlockState getStateForPlacement(BlockItemUseContext context) {
	      return !this.getDefaultState().isValidPosition(context.getWorld(), context.getPos()) ? Block.nudgeEntitiesWithNewState(this.getDefaultState(), _pathedFrom.getDefaultState(), context.getWorld(), context.getPos()) : super.getStateForPlacement(context);
	   }
	
	private boolean checkIfFalling(IWorld worldIn, BlockPos currentPos)
	{
		if(!_isFallingBlock)
			return false;
		
		return worldIn.isAirBlock(currentPos.down()) || FallingBlock.canFallThrough(worldIn.getBlockState(currentPos.down())) && currentPos.getY() >= 0;
	}

}