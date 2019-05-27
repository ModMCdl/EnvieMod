package com.modmcdl.envie.blocks;

import javax.annotation.Nonnull;

import com.modmcdl.envie.EnvieMod;
import com.modmcdl.envie.init.ModBlocks;
import com.modmcdl.envie.init.ModItems;
import com.modmcdl.envie.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockNetherStar extends Block implements IHasModel
{
	public BlockNetherStar(String name, Material material)
	{
		super(material);
		
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setHardness(50.0F);
		this.setResistance(6442450944F);
		this.setLightLevel(0.2F);
		
		this.setCreativeTab(EnvieMod.envietab);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels() 
	{
		EnvieMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
	
	@Override
	public boolean canEntityDestroy(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull Entity entity) 
	{
		return !(entity instanceof EntityWither) && !(entity instanceof EntityWitherSkull);
	}
	
	
}
