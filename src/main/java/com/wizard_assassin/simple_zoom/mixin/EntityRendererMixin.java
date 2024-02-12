package com.wizard_assassin.simple_zoom.mixin;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.wizard_assassin.simple_zoom.CustomConfig;
import com.wizard_assassin.simple_zoom.CustomKeybind;

import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;

@Mixin(EntityRenderer.class)
public class EntityRendererMixin {
    private boolean zoomEnabledSmoothCamera = false;

    @Shadow
    @Final
    Minecraft mc;

    @Inject(method = "getFOVModifier", at = @At("TAIL"), cancellable = true)
    private void setZoom(float partialTicks, boolean useFOVSetting, CallbackInfoReturnable<Float> info) {
        if (CustomKeybind.zoomKeyPressed) {
            float fov = info.getReturnValue();
            info.setReturnValue(fov * CustomConfig.zoomScale);
            if (!mc.gameSettings.smoothCamera && CustomConfig.enableSmoothCamera) {
                zoomEnabledSmoothCamera = true;
                mc.gameSettings.smoothCamera = true;
            }
            return;
        }
        if (zoomEnabledSmoothCamera) {
            zoomEnabledSmoothCamera = false;
            mc.gameSettings.smoothCamera = false;
        }
    }
}
