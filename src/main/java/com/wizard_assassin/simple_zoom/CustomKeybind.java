package com.wizard_assassin.simple_zoom;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class CustomKeybind {
    public static KeyBinding zoomKey;
    public static boolean zoomKeyPressed;

    public static void init() {
        zoomKey = new KeyBinding("Zoom", KeyConflictContext.IN_GAME, KeyModifier.NONE, Keyboard.KEY_C,
                "Simple Zoom");
        ClientRegistry.registerKeyBinding(zoomKey);
    }

    public static void reset() {
        zoomKeyPressed = false;
    }

    @SubscribeEvent
    public static void onKeyInput(InputEvent.KeyInputEvent event) {
        if (CustomConfig.isToggleKeybind) {
            if (zoomKey.isPressed())
                zoomKeyPressed = !zoomKeyPressed;
            return;
        }
        if (zoomKey.isKeyDown()) {
            zoomKeyPressed = true;
            return;
        }
        zoomKeyPressed = false;
    }
}
