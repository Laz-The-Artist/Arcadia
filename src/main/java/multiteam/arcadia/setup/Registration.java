package multiteam.arcadia.setup;

import multiteam.arcadia.ArcadiaMod;
import multiteam.arcadia.setup.entitys.villager.PointOfInterests;
import net.minecraft.block.Block;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.item.Item;
import net.minecraft.village.PointOfInterestType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.common.world.ForgeWorldType;

public class Registration {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ArcadiaMod.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ArcadiaMod.MOD_ID);
    public static final DeferredRegister<PaintingType> PAINTINGS = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, ArcadiaMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(ForgeRegistries.PROFESSIONS, ArcadiaMod.MOD_ID);
    public static final DeferredRegister<PointOfInterestType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, ArcadiaMod.MOD_ID);
    public static final DeferredRegister<ForgeWorldType> DIM_TYPES = DeferredRegister.create(ForgeRegistries.WORLD_TYPES, ArcadiaMod.MOD_ID);
    //public static final DeferredRegister<ModDimensions> MOD_DIM_DREG = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, ArcadiaMod.MOD_ID);


    public static void register() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        PAINTINGS.register(modEventBus);
        PROFESSIONS.register(modEventBus);
        POI_TYPES.register(modEventBus);
        DIM_TYPES.register(modEventBus);

        ModBlocks.register();
        ModItems.register();
        ModPaintings.register();
        VillagerProfessions.register();
        PointOfInterests.register();
        //ModDimensions.register();
    }
}
