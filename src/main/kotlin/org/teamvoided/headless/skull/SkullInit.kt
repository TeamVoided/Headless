package org.teamvoided.headless.skull

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Blocks
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.item.SkullItem
import net.minecraft.registry.Registries
import org.teamvoided.headless.Headless.id
import org.teamvoided.headless.block.HeadlessSkull
import org.teamvoided.headless.block.HeadlessWallSkull
import org.teamvoided.headless.utils.register

object SkullInit {

    val HUSK_SKULL_BLOCK = Registries.BLOCK.register(
        id("husk_skull"),
        HeadlessSkull(CustomSkullType.HUSK, AbstractBlock.Settings.copy(Blocks.SKELETON_SKULL))
    )
    val HUSK_SKULL_WALL_BLOCK = Registries.BLOCK.register(
        id("husk_wall_skull"),
        HeadlessWallSkull(CustomSkullType.HUSK, AbstractBlock.Settings.copy(Blocks.SKELETON_SKULL))
    )
    val HUSK_SKULL_ITEM = Registries.ITEM.register(
        id("husk_skull"), SkullItem(HUSK_SKULL_BLOCK, HUSK_SKULL_WALL_BLOCK, Item.Settings())
    )

    fun init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register {
            it.prepend(HUSK_SKULL_ITEM)
        }
    }
}