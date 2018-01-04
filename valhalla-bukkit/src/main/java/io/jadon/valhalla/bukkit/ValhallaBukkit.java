package io.jadon.valhalla.bukkit;

import io.jadon.valhalla.Valhalla;
import org.bukkit.plugin.java.JavaPlugin;

public final class ValhallaBukkit extends JavaPlugin {

    @Override
    public void onEnable() {
        Valhalla.INSTANCE.onEnable();
    }

    @Override
    public void onDisable() {
        Valhalla.INSTANCE.onDisable();
    }
}
