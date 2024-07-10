package org.teamvoided.headless

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.minecraft.client.render.block.entity.model.AbstractSkullBlockEntityModel
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.client.render.entity.model.EntityModelLoader
import net.minecraft.util.Identifier
import org.teamvoided.headless.Headless.id
import org.teamvoided.headless.mixin.SkullBlockEntityRendererAccessor
import org.teamvoided.headless.skull.CustomSkullType

object HeadlessRegistry {
    private val SKULLS: MutableMap<CustomSkullType, (EntityModelLoader) -> AbstractSkullBlockEntityModel> =
        mutableMapOf()

    fun register(
        type: CustomSkullType,
        texture: Identifier,
        model: (EntityModelLoader) -> AbstractSkullBlockEntityModel
    ) {
        SkullBlockEntityRendererAccessor.headless_TEXTURES()[type] = texture
        SKULLS[type] = model
    }

    @ExperimentalStdlibApi
    fun registerLayeredSkull(type: CustomSkullType, texture: Identifier, overlayTexture: Identifier) {
        val head = register("${type.type}_head", "main")
        val headOverlay = register("${type.type}_head", "overlay")
        EntityModelLayerRegistry.registerModelLayer(head, LayeredSkullModel::getSkullTexturedModelData)
        EntityModelLayerRegistry.registerModelLayer(headOverlay, LayeredSkullModel::getSkullTexturedModelOverlayData)

        SkullBlockEntityRendererAccessor.headless_TEXTURES()[type] = texture
        SKULLS[type] = { LayeredSkullModel(it.getModelPart(head), it.getModelPart(headOverlay), overlayTexture) }
    }

    @JvmStatic
    fun getSkulls() = SKULLS
    private fun register(id: String, layer: String): EntityModelLayer = EntityModelLayer(id(id), layer)
}