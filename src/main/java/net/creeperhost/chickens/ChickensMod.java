package net.creeperhost.chickens;

import net.creeperhost.chickens.config.ConfigHandler;
import net.creeperhost.chickens.init.*;
import net.creeperhost.chickens.registry.LiquidEggRegistry;
import net.creeperhost.chickens.registry.LiquidEggRegistryItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(ChickensMod.MODID)
public class ChickensMod
{
    public static final String MODID = "chickens";
    public static final Logger LOGGER = LogManager.getLogger();

    public ChickensMod()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        registerLiquidEggs();

        ModBlocks.BLOCKS.register(eventBus);
        ModItems.ITEMS.register(eventBus);
        ConfigHandler.LoadConfigs(ModChickens.generateDefaultChickens());
        ModBlocks.TILES_ENTITIES.register(eventBus);
        ModContainers.CONTAINERS.register(eventBus);
        ModEntities.ENTITIES.register(eventBus);
        eventBus.addListener(this::clientInit);
        eventBus.addListener(this::loaded);

        if (ModList.get().isLoaded("theoneprobe")) {
            //TODO
//            InterModComms.sendTo("theoneprobe", "getTheOneProbe", TheOneProbePlugin.GetTheOneProbe::new);
        }

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void loaded(final FMLCommonSetupEvent event)
    {
        ModEntities.CHICKENS.forEach((chickensRegistryItem, entityTypeSupplier) -> ModEntities.registerSpawn(entityTypeSupplier, chickensRegistryItem));
    }

    private void clientInit(final FMLClientSetupEvent event)
    {
        ModScreens.init();
        event.enqueueWork(ChickensClient::init);
    }

    public void registerLiquidEggs()
    {
        LiquidEggRegistry.register(new LiquidEggRegistryItem(0, Blocks.WATER, 0x0000ff, Fluids.WATER));
        LiquidEggRegistry.register(new LiquidEggRegistryItem(1, Blocks.LAVA, 0xff0000, Fluids.LAVA));
    }
}
