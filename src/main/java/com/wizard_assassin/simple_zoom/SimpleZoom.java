package com.wizard_assassin.simple_zoom;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = SimpleZoom.MOD_ID, clientSideOnly = true)
public class SimpleZoom {
    public static final String MOD_ID = "simple-zoom";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent event) {
        CustomKeybind.init();
        MinecraftForge.EVENT_BUS.register(CustomConfig.class);
        MinecraftForge.EVENT_BUS.register(CustomKeybind.class);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }
}
