package org.teamvoided.headless

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.minecraft.client.render.RenderLayers
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories
import net.minecraft.client.render.block.entity.SkullBlockEntityRenderer
import net.minecraft.client.render.block.entity.model.SkullBlockEntityModel
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.util.Identifier
import org.teamvoided.headless.Headless.log
import org.teamvoided.headless.skull.CustomSkullType
import org.teamvoided.headless.skull.SkullInit

@Suppress("unused")
object HeadlessClient {
    fun init() {
        log.info("Hello from Client")
        BlockEntityRendererFactories.register(SkullInit.CUSTOM_SKULL_BE_TYPE, ::SkullBlockEntityRenderer)
        SkullBlockEntityRenderer.TEXTURES[CustomSkullType.HUSK] = Identifier.ofDefault("textures/entity/husk.png")
        EntityModelLayerRegistry.registerModelLayer(HUSK_HEAD,  SkullBlockEntityModel::getSkullTexturedModelData)
    }

    val HUSK_HEAD = registerMain("husk_head")

    private fun registerMain(id: String): EntityModelLayer {
        return register(id, "main")
    }

    private fun register(id: String, layer: String): EntityModelLayer {
        val entityModelLayer = EntityModelLayer(Identifier.ofDefault(id), layer);
        return entityModelLayer
    }
}
