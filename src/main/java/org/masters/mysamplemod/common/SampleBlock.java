package org.masters.mysamplemod.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class SampleBlock extends Block {

	public static final String NAME = "sampleBlock";
	
	public SampleBlock() {
		super(Material.rock);

		setBlockName(NAME);
		setCreativeTab(CreativeTabs.tabBlock);
		
	}

}
