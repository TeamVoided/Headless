package org.teamvoided.headless.skull

import net.minecraft.block.SkullBlock.SkullType

class CustomSkullType(val type: String) : SkullType {
    override fun asString(): String = type
    companion object {
        val HUSK = CustomSkullType("husk")
    }
}