package io.jadon.valhalla.bukkit;

import io.jadon.valhalla.team.VTeam;
import io.jadon.valhalla.world.VLocation;
import io.jadon.valhalla.world.VMap;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.util.List;
import java.util.Map;

public class BukkitVMap extends VMap {

    private World world;

    public BukkitVMap(String name, String worldName, List<String> authors, Map<VTeam, VLocation> spawns) {
        super(name, worldName, authors, spawns);
    }

    @Override
    public void loadWorld() {
        if (this.isLoaded()) this.unloadWorld();
        Bukkit.createWorld(new WorldCreator(this.getWorldName()));
        this.setLoaded(true);
    }

    @Override
    public void unloadWorld() {
        Bukkit.unloadWorld(this.getWorldName(), false);
        this.setLoaded(false);
    }
}
