package com.reformedalloy.dtextradelight;

import com.dtteam.dynamictrees.block.fruit.Fruit;
import com.dtteam.dynamictrees.block.leaves.LeavesProperties;
import com.dtteam.dynamictrees.block.pod.Pod;
import com.dtteam.dynamictrees.data.GatherDataHelper;
import com.dtteam.dynamictrees.registry.NeoForgeRegistryHandler;
import com.dtteam.dynamictrees.tree.family.Family;
import com.dtteam.dynamictrees.tree.species.Species;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.fml.ModContainer;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(DynamicTreesExtraDelight.MOD_ID)
public class DynamicTreesExtraDelight {
  public static final String MOD_ID = "dtextradelight";

  public static final Logger LOGGER = LogUtils.getLogger();

  public DynamicTreesExtraDelight(IEventBus bus, ModContainer modContainer) {
    bus.addListener(this::commonSetup);
    bus.addListener(this::clientSetup);
    bus.addListener(this::gatherData);

    NeoForgeRegistryHandler.setup(MOD_ID, bus);
  }

  private void commonSetup(final FMLConstructModEvent event) {
  }

  private void clientSetup(final FMLClientSetupEvent event) {
  }

  private void gatherData(final GatherDataEvent event) {
    GatherDataHelper.gatherAllData(MOD_ID, event,
        // SoilProperties.REGISTRY,
        Family.REGISTRY,
        Species.REGISTRY,
        LeavesProperties.REGISTRY,
        Fruit.REGISTRY,
        Pod.REGISTRY);
  }

  public static ResourceLocation location(final String path) {
    return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
  }
}
