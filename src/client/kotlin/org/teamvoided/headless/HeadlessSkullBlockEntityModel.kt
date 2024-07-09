package org.teamvoided.headless

import net.minecraft.block.entity.SkullBlockEntity
import net.minecraft.client.model.ModelPart
import net.minecraft.client.render.block.entity.model.SkullBlockEntityModel

class HeadlessSkullBlockEntityModel(root: ModelPart ) : SkullBlockEntityModel(root){

    override fun setHeadAngles(animationProgress: Float, yaw: Float, pitch: Float) {
        super.setHeadAngles(animationProgress, yaw, pitch)
    }
}