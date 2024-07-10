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
        val HUSK = CustomSkullType("husk")
        val BOGGED = CustomSkullType("bogged")
        val STRAY = CustomSkullType("stray")


    val HUSK_SKULL_BLOCK = Registries.BLOCK.register(
        id("husk_skull"),
        HeadlessSkull(HUSK, AbstractBlock.Settings.copy(Blocks.SKELETON_SKULL))
    )
    val HUSK_SKULL_WALL_BLOCK = Registries.BLOCK.register(
        id("husk_wall_skull"),
        HeadlessWallSkull(HUSK, AbstractBlock.Settings.copy(Blocks.SKELETON_SKULL))
    )
    val HUSK_SKULL_ITEM = Registries.ITEM.register(
        id("husk_skull"), SkullItem(HUSK_SKULL_BLOCK, HUSK_SKULL_WALL_BLOCK, Item.Settings())
    )

    val BOGGED_SKULL_BLOCK = Registries.BLOCK.register(
        id("bogged_skull"),
        HeadlessSkull(BOGGED, AbstractBlock.Settings.copy(Blocks.SKELETON_SKULL))
    )
    val BOGGED_SKULL_WALL_BLOCK = Registries.BLOCK.register(
        id("bogged_wall_skull"),
        HeadlessWallSkull(BOGGED, AbstractBlock.Settings.copy(Blocks.SKELETON_SKULL))
    )
    val BOGGED_SKULL_ITEM = Registries.ITEM.register(
        id("bogged_skull"), SkullItem(BOGGED_SKULL_BLOCK, BOGGED_SKULL_WALL_BLOCK, Item.Settings())
    )

    val STRAY_SKULL_BLOCK = Registries.BLOCK.register(
        id("stray_skull"),
        HeadlessSkull(STRAY, AbstractBlock.Settings.copy(Blocks.SKELETON_SKULL))
    )
    val STRAY_SKULL_WALL_BLOCK = Registries.BLOCK.register(
        id("stray_wall_skull"),
        HeadlessWallSkull(STRAY, AbstractBlock.Settings.copy(Blocks.SKELETON_SKULL))
    )
    val STRAY_SKULL_ITEM = Registries.ITEM.register(
        id("stray_skull"), SkullItem(STRAY_SKULL_BLOCK, STRAY_SKULL_WALL_BLOCK, Item.Settings())
    )

    fun init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register {
            it.prepend(HUSK_SKULL_ITEM)
            it.prepend(BOGGED_SKULL_ITEM)
            it.prepend(STRAY_SKULL_ITEM)
        }
    }
}