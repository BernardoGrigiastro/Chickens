package net.creeperhost.chickens.init;

import dev.architectury.registry.menu.MenuRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.creeperhost.chickens.Chickens;
import net.creeperhost.chickens.containers.ContainerBreeder;
import net.creeperhost.chickens.containers.ContainerRoost;
import net.minecraft.core.Registry;
import net.minecraft.world.inventory.MenuType;


public class ModContainers
{
    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(Chickens.MOD_ID, Registry.MENU_REGISTRY);
    public static final RegistrySupplier<MenuType<ContainerBreeder>> BREEDER_CONTAINER = CONTAINERS.register("container_breeder", () -> MenuRegistry.ofExtended(ContainerBreeder::new));
    public static final RegistrySupplier<MenuType<ContainerRoost>> ROOST = CONTAINERS.register("container_roost", () -> MenuRegistry.ofExtended(ContainerRoost::new));

}
