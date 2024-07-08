package org.teamvoided.headless.skull

import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.block.entity.SkullBlockEntity
import net.minecraft.util.math.BlockPos

class CustomSkullBlockEntity(pos: BlockPos, state: BlockState) : SkullBlockEntity(pos, state) {

    override fun getType(): BlockEntityType<*> = SkullInit.CUSTOM_SKULL_BE_TYPE
}