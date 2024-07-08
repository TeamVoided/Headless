package org.teamvoided.headless.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.teamvoided.headless.block.Headless;

@Mixin(BlockEntityType.class)
public abstract class BlockEntityTypeMixin {

    @Inject(method = "supports", at = @At("RETURN"), cancellable = true)
    private void supports(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        if (state.getBlock() instanceof Headless) cir.setReturnValue(true);
    }
}
