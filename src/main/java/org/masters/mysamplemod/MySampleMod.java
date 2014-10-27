package org.masters.mysamplemod;


import org.masters.mysamplemod.common.CommonProxy;
import org.masters.mysamplemod.common.SampleBlock;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = MySampleMod.MODID, version = MySampleMod.VERSION)
public class MySampleMod
{
    public static final String MODID = "mysamplemod";
    public static final String VERSION = "1.0";
    
    @SidedProxy(
    	    clientSide="org.masters.mysamplemod.client.ClientProxy",
    	    serverSide="org.masters.mysamplemod.common.CommonProxy")
    public static CommonProxy proxy;
    
    private Block mySampleBlock;
    
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {    	
    	mySampleBlock = new SampleBlock();
    	GameRegistry.registerBlock(mySampleBlock, SampleBlock.NAME);
    }
}
