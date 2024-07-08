package org.teamvoided.headless.mixin;

import com.google.common.collect.ImmutableMap;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.SkullBlock;
import net.minecraft.client.render.block.entity.SkullBlockEntityRenderer;
import net.minecraft.client.render.block.entity.model.AbstractSkullBlockEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.teamvoided.headless.HeadlessRegistry;

import java.util.Map;

import static org.teamvoided.headless.Headless.log;

@Debug(export = true)
@Mixin(SkullBlockEntityRenderer.class)
public abstract class SkullBlockEntityRendererMixin {

    @Shadow @Final private static Map<SkullBlock.SkullType, Identifier> TEXTURES;

    @Shadow @Final private Map<SkullBlock.SkullType, AbstractSkullBlockEntityModel> models;

    @Inject(at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableMap$Builder;build()Lcom/google/common/collect/ImmutableMap;"), method = "getModels")
    private static void addCustomModels(EntityModelLoader modelLoader, CallbackInfoReturnable<Map<SkullBlock.SkullType, AbstractSkullBlockEntityModel>> cir,
                                        @Local ImmutableMap.Builder<SkullBlock.SkullType, AbstractSkullBlockEntityModel> builder) {
        HeadlessRegistry.getSkulls().forEach((type, model) -> builder.put(type, model.invoke(modelLoader)));
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void x(CallbackInfo ci) {
        this.models.forEach((type, model) -> log.info("type: {} model: {}", type, model));
        TEXTURES.forEach((type, texture) -> log.info("type: {} texture: {}", type, texture));
    }

}