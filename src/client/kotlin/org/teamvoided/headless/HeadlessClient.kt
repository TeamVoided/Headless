package org.teamvoided.headless

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.block.entity.SkullBlockEntityRenderer
import net.minecraft.client.render.block.entity.model.SkullBlockEntityModel
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import org.teamvoided.headless.Headless.log
import org.teamvoided.headless.skull.CustomSkullType

@Suppress("unused")
object HeadlessClient {
    fun init() {
        log.info("Hello from Client")
        SkullBlockEntityRenderer.TEXTURES[CustomSkullType.HUSK] =
            Identifier.ofDefault("textures/entity/zombie/husk.png")
        EntityModelLayerRegistry.registerModelLayer(HUSK_HEAD, SkullBlockEntityModel::getHeadTexturedModelData)


        ClientTickEvents.END_WORLD_TICK.register {
            var x = ""
            DEBUG_VALUE.forEach { (a, b) -> x += "$a: [$b] |" }
            MinecraftClient.getInstance().player?.sendMessage(Text.of(x), true)
        }
    }


    @JvmField
    val DEBUG_VALUE = mutableMapOf<String, Any>()

    val HUSK_HEAD = registerMain("husk_head")

    private fun registerMain(id: String): EntityModelLayer {
        return register(id, "main")
    }

    private fun register(id: String, layer: String): EntityModelLayer {
        val entityModelLayer = EntityModelLayer(Identifier.ofDefault(id), layer);
        return entityModelLayer
    }
}
