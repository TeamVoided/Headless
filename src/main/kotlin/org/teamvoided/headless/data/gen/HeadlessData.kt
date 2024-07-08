package org.teamvoided.headless.data.gen

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider
import net.minecraft.data.client.ItemModelGenerator
import net.minecraft.data.client.model.BlockStateModelGenerator
import net.minecraft.data.client.model.Model
import net.minecraft.item.Item
import net.minecraft.registry.RegistrySetBuilder
import net.minecraft.util.Identifier
import org.teamvoided.headless.Headless.log
import org.teamvoided.headless.skull.SkullInit
import java.util.*

@Suppress("unused")
class HeadlessData : DataGeneratorEntrypoint {
    override fun onInitializeDataGenerator(gen: FabricDataGenerator) {
        log.info("Hello from DataGen")
        val pack = gen.createPack()

//        pack.addProvider(::TemplateWorldGenerator)

        pack.addProvider { o: FabricDataOutput ->
            object : FabricModelProvider(o) {
                override fun generateBlockStateModels(gen: BlockStateModelGenerator) {
                }

                override fun generateItemModels(gen: ItemModelGenerator) {
                    gen.skull(SkullInit.HUSK_SKULL_ITEM)
//        gen.register(DuskItems.BOGGED_SKULL, parentedItemModel(mc("template_skull")))
//        gen.register(DuskItems.GLOOM_SKULL, parentedItemModel(mc("template_skull")))
                }
            }
        }
    }

    override fun buildRegistry(gen: RegistrySetBuilder) {
//        gen.add(RegistryKeys.BIOME, TemplateBiomes::boostrap)
    }

    fun ItemModelGenerator.skull(item: Item) =
        this.register(item, parentedItemModel(Identifier.ofDefault("template_skull")))

    fun parentedItemModel(id: Identifier) = Model(Optional.of(id.withPrefix("item/")), Optional.empty())
}
