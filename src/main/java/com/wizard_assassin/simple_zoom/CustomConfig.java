package com.wizard_assassin.simple_zoom;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = SimpleZoom.MOD_ID)
public class CustomConfig {
    @RangeDouble(min = 0, max = 1)
    public static float zoomScale = 0.25f;
    public static boolean isToggleKeybind = false;
    public static boolean enableSmoothCamera = true;

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(SimpleZoom.MOD_ID)) {
            ConfigManager.sync(SimpleZoom.MOD_ID, Config.Type.INSTANCE);
            CustomKeybind.reset();
        }
    }
}