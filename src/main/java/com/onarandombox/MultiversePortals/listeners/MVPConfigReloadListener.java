package com.onarandombox.MultiversePortals.listeners;

import org.bukkit.event.CustomEventListener;
import org.bukkit.event.Event;

import com.onarandombox.MultiverseCore.event.MVConfigReloadEvent;       
import com.onarandombox.MultiverseCore.event.MVVersionRequestEvent;
import com.onarandombox.MultiversePortals.MultiversePortals;

public class MVPConfigReloadListener extends CustomEventListener {
    private MultiversePortals plugin;
    public MVPConfigReloadListener(MultiversePortals plugin) {
        this.plugin = plugin;
    }
    @Override
    public void onCustomEvent(Event event) {
        if(event instanceof MVConfigReloadEvent) {
            plugin.reloadConfigs();
            ((MVConfigReloadEvent)event).addConfig("Multiverse-Portals - portals.yml");
            ((MVConfigReloadEvent)event).addConfig("Multiverse-Portals - config.yml");
        } else if(event instanceof MVVersionRequestEvent) {
            this.plugin.dumpVersionInfo();
        }
    }
}