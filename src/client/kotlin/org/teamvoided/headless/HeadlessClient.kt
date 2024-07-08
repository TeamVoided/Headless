package org.teamvoided.headless

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.minecraft.client.render.block.entity.model.SkullBlockEntityModel
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.util.Identifier
import org.teamvoided.headless.Headless.log
import org.teamvoided.headless.skull.CustomSkullType

@Suppress("unused")
object HeadlessClient {
    fun init() {
        log.info("Hello from Client")

        EntityModelLayerRegistry.registerModelLayer(BOGGED_HEAD, SkullBlockEntityModel::getSkullTexturedModelData)
        HeadlessRegistry.registerSkull(CustomSkullType.BOGGED, bogged_png) { SkullBlockEntityModel(it.getModelPart(BOGGED_HEAD)) }

        EntityModelLayerRegistry.registerModelLayer(HUSK_HEAD, SkullBlockEntityModel::getHeadTexturedModelData)
        HeadlessRegistry.registerSkull(CustomSkullType.HUSK, husk_png) { SkullBlockEntityModel(it.getModelPart(HUSK_HEAD)) }

    }

    val HUSK_HEAD = register("husk_head", "main")
    val husk_png = Identifier.ofDefault("textures/entity/zombie/husk.png")

    val BOGGED_HEAD = register("bogged_head", "main")
    val bogged_png = Identifier.ofDefault("textures/entity/skeleton/bogged.png")

    private fun register(id: String, layer: String): EntityModelLayer {
        val entityModelLayer = EntityModelLayer(Identifier.ofDefault(id), layer);
        return entityModelLayer
    }
}
