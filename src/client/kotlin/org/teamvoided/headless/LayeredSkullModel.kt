package org.teamvoided.headless

import com.mojang.blaze3d.vertex.VertexConsumer
import net.minecraft.client.MinecraftClient
import net.minecraft.client.model.*
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.block.entity.model.SkullBlockEntityModel
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier

@ExperimentalStdlibApi
open class LayeredSkullModel(root: ModelPart, hat: ModelPart,  layer: Identifier) : SkullBlockEntityModel(root) {
    val OUTER_LAYER: RenderLayer = RenderLayer.getEntityCutoutNoCullZOffset(layer)
    protected val hat: ModelPart = hat.getChild("hat")

    override fun setHeadAngles(animationProgress: Float, yaw: Float, pitch: Float) {
        super.setHeadAngles(animationProgress, yaw, pitch)
        hat.yaw = yaw * 0.017453292f
        hat.pitch = pitch * 0.017453292f
    }

    override fun method_2828(matrices: MatrixStack, vertexConsumer: VertexConsumer, i: Int, j: Int, k: Int) {
        super.method_2828(matrices, vertexConsumer, i, j, k)

        val provider = MinecraftClient.getInstance().bufferBuilders.entityVertexConsumers
        val buffer = provider.getBuffer(OUTER_LAYER)
        hat.method_22699(matrices, buffer, i, j, k)
        provider.draw(OUTER_LAYER)
    }

    companion object {
        fun makeHed(): ModelData {
            val modelData = ModelData()
            val modelPartData = modelData.root
            modelPartData.addChild(
                "head",
                ModelPartBuilder.create()
                    .uv(0, 0)
                    .cuboid(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f),
                ModelTransform.NONE
            )
            modelPartData.addChild(
                "hat",
                ModelPartBuilder.create()
                    .uv(0, 0)
                    .cuboid(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, Dilation(0.25f)),
                ModelTransform.NONE
            )

            return modelData
        }

        fun getHeadTexturedModelData(): TexturedModelData {
            val meshdefinition = makeHed()
            return TexturedModelData.of(meshdefinition, 64, 64)
        }

        fun getSkullTexturedModelData(): TexturedModelData {
            val modelData = ModelData()
            val modelPartData = modelData.root
            modelPartData.addChild(
                "head",
                ModelPartBuilder.create()
                    .uv(0, 0)
                    .cuboid(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f),
                ModelTransform.NONE
            )
            return TexturedModelData.of(modelData, 64, 32)
        }
        fun getSkullTexturedModelOverlayData(): TexturedModelData {
            val modelData = ModelData()
            val modelPartData = modelData.root
            modelPartData.addChild(
                "hat",
                ModelPartBuilder.create()
                    .uv(0, 0)
                    .cuboid(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f, Dilation(0.25f)),
                ModelTransform.NONE
            )
            return TexturedModelData.of(modelData, 64, 32)
        }
    }
}