package org.teamvoided.headless.mixin;

import net.minecraft.block.SkullBlock;
import net.minecraft.client.render.block.entity.SkullBlockEntityRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Debug(export = true)
@Mixin(SkullBlockEntityRenderer.class)
public interface SkullBlockEntityRendererAccessor {

    @Accessor("TEXTURES")
    static Map<SkullBlock.SkullType, Identifier> headless_TEXTURES() {
        throw new AssertionError("Mixin failed! Please send help!");
    }
}