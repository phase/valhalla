package io.jadon.valhalla.sponge;

import io.jadon.valhalla.team.VTeam;
import io.jadon.valhalla.world.VLocation;
import io.jadon.valhalla.world.VMap;
import org.spongepowered.api.world.SerializationBehaviors;
import org.spongepowered.api.world.World;

import java.util.List;
import java.util.Map;

public class SVMap extends VMap {

    private World world;

    public SVMap(String name, String worldName, List<String> authors, Map<VTeam, VLocation> spawns) {
        super(name, worldName, authors, spawns);
    }

    @Override
    public void loadWorld() {
        if (isLoaded()) this.unloadWorld();
        // TODO load world
        world.getProperties().setSerializationBehavior(SerializationBehaviors.NONE);
        this.setLoaded(true);
    }

    @Override
    public void unloadWorld() {
        // TODO unload world
        this.setLoaded(false);
    }
}
