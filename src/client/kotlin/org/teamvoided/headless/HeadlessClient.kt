package org.teamvoided.headless

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.minecraft.client.render.block.entity.model.SkullBlockEntityModel
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.util.Identifier
import org.teamvoided.headless.Headless.id
import org.teamvoided.headless.Headless.log
import org.teamvoided.headless.skull.CustomSkullType

@Suppress("unused")
object HeadlessClient {
    val BOGGED_HEAD = register("bogged_head", "main")
    val bogged_png = Identifier.ofDefault("textures/entity/skeleton/bogged.png")

    val HUSK_HEAD = register("husk_head", "main")
    val husk_png = Identifier.ofDefault("textures/entity/zombie/husk.png")

    val STRAY_HEAD = register("stray_head", "main")
    val stray_png = Identifier.ofDefault("textures/entity/skeleton/stray.png")

    fun init() {
        log.info("Hello from Client")

        EntityModelLayerRegistry.registerModelLayer(BOGGED_HEAD, SkullBlockEntityModel::getSkullTexturedModelData)
        HeadlessRegistry.registerSkull(CustomSkullType.BOGGED, bogged_png)
        { SkullBlockEntityModel(it.getModelPart(BOGGED_HEAD)) }

        EntityModelLayerRegistry.registerModelLayer(HUSK_HEAD, SkullBlockEntityModel::getHeadTexturedModelData)
        HeadlessRegistry.registerSkull(CustomSkullType.HUSK, husk_png)
        { SkullBlockEntityModel(it.getModelPart(HUSK_HEAD)) }

        EntityModelLayerRegistry.registerModelLayer(STRAY_HEAD, SkullBlockEntityModel::getSkullTexturedModelData)
        HeadlessRegistry.registerSkull(CustomSkullType.STRAY, stray_png)
        { SkullBlockEntityModel(it.getModelPart(STRAY_HEAD)) }

    }

    private fun register(id: String, layer: String): EntityModelLayer = EntityModelLayer(id(id), layer)
}
