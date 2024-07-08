package org.teamvoided.headless

import net.minecraft.client.render.block.entity.model.AbstractSkullBlockEntityModel
import net.minecraft.client.render.entity.model.EntityModelLoader
import net.minecraft.util.Identifier
import org.teamvoided.headless.mixin.SkullBlockEntityRendererAccessor
import org.teamvoided.headless.skull.CustomSkullType

object HeadlessRegistry {
    private val SKULLS: MutableMap<CustomSkullType, (EntityModelLoader) -> AbstractSkullBlockEntityModel> = mutableMapOf()

    fun registerSkull(type: CustomSkullType, texture: Identifier, model: (EntityModelLoader) -> AbstractSkullBlockEntityModel) {
        SkullBlockEntityRendererAccessor.headless_TEXTURES()[type] = texture
        SKULLS[type] = model
    }

    @JvmStatic
    fun getSkulls() = SKULLS
}