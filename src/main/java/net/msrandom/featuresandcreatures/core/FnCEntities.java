package net.msrandom.featuresandcreatures.core;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.msrandom.featuresandcreatures.FeaturesAndCreatures;
import net.msrandom.featuresandcreatures.common.entities.boar.Boar;
import net.msrandom.featuresandcreatures.common.entities.jackalope.Jackalope;
import net.msrandom.featuresandcreatures.common.entities.jockey.Jockey;
import net.msrandom.featuresandcreatures.common.entities.sabertooth.Sabertooth;

public class FnCEntities {

    public static final DeferredRegister<EntityType<?>> REGISTRAR = DeferredRegister.create(ForgeRegistries.ENTITIES, FeaturesAndCreatures.MOD_ID);

    public static final RegistryObject<EntityType<Jockey>> JOCKEY = createEntity("jockey", EntityType.Builder.of(Jockey::new, EntityClassification.CREATURE).sized(0.25f, 1f), 0xDBA5FF, 0x564237);
    public static final RegistryObject<EntityType<Boar>> BOAR = createEntity("boar", EntityType.Builder.of(Boar::new, EntityClassification.CREATURE).sized(0.9F, 0.9F), 0x705F44, 0xFFF05A);
    public static final RegistryObject<EntityType<Jackalope>> JACKALOPE = createEntity("jackalope", EntityType.Builder.of(Jackalope::new, EntityClassification.CREATURE).sized(1F, 0.8F), 0xB3A98D, 0x444444);
    public static final RegistryObject<EntityType<Sabertooth>> SABERTOOTH = createEntity("sabertooth", EntityType.Builder.of(Sabertooth::new, EntityClassification.CREATURE).sized(1.2F, 1.3F), 0xC59125, 0xEEA2C4);


    private static <T extends Entity> RegistryObject<EntityType<T>> createEntity(String name, EntityType.Builder<T> builder, int colour1, int colour2) {
        EntityType<T> type = builder.build(name);
        FnCItems.REGISTRAR.register(name + "_spawn_egg", () -> new SpawnEggItem(type, colour1, colour2, new Item.Properties().tab(FnCItems.TAB)));
        return REGISTRAR.register(name, () -> type);
    }
}