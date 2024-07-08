package org.teamvoided.headless.skull

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Blocks
import net.minecraft.block.SkullBlock
import net.minecraft.block.WallSkullBlock
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.item.Item
import net.minecraft.item.ItemGroups
import net.minecraft.item.SkullItem
import net.minecraft.registry.Registries
import org.teamvoided.headless.Headless.id
import org.teamvoided.headless.utils.register

object SkullInit {

    val HUSK_SKULL_BLOCK = Registries.BLOCK.register(
        id("husk_skull"),
        SkullBlock(CustomSkullType.HUSK, AbstractBlock.Settings.copy(Blocks.SKELETON_SKULL))
    )
    val HUSK_SKULL_WALL_BLOCK = Registries.BLOCK.register(
        id("husk_skull"),
        WallSkullBlock(CustomSkullType.HUSK, AbstractBlock.Settings.copy(Blocks.SKELETON_SKULL))
    )
    val HUSK_SKULL_ITEM = Registries.ITEM.register(
        id("husk_skull"), SkullItem(HUSK_SKULL_BLOCK, HUSK_SKULL_WALL_BLOCK, Item.Settings())
    )
    @Suppress("UNCHECKED_CAST")
    val CUSTOM_SKULL_BE_TYPE: BlockEntityType<CustomSkullBlockEntity> = Registries.BLOCK_ENTITY_TYPE.register(
        id("custom_skull"),
        BlockEntityType.Builder.create(
            ::CustomSkullBlockEntity,
            HUSK_SKULL_BLOCK, HUSK_SKULL_WALL_BLOCK
        ).build()
    ) as BlockEntityType<CustomSkullBlockEntity>

    fun init() {
        ItemGroupEvents.MODIFY_ENTRIES_ALL.register(ItemGroups.BUILDING_BLOCKS.value) { _, entires ->
            entires.prepend(HUSK_SKULL_ITEM)
        }
    }
}