package org.teamvoided.headless

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.minecraft.client.render.block.entity.SkullBlockEntityRenderer
import net.minecraft.client.render.block.entity.model.SkullBlockEntityModel
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.util.Identifier
import org.teamvoided.headless.Headless.log
import org.teamvoided.headless.skull.CustomSkullType

@Suppress("unused")
object HeadlessClient {
    fun init() {
        log.info("Hello from Client")
        SkullBlockEntityRenderer.TEXTURES[CustomSkullType.HUSK] =
            Identifier.ofDefault("textures/entity/zombie/drowned.png")
        EntityModelLayerRegistry.registerModelLayer(HUSK_HEAD, SkullBlockEntityModel::getHeadTexturedModelData)
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
