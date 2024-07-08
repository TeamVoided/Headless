package org.teamvoided.headless.skull

import net.minecraft.block.SkullBlock.SkullType

class CustomSkullType(val type: String) : SkullType {
    override fun asString(): String = type
    override fun toString(): String = type.uppercase()
    companion object {
        val HUSK = CustomSkullType("husk")
        val BOGGED = CustomSkullType("bogged")
    }
}