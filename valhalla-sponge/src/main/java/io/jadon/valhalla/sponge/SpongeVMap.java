package io.jadon.valhalla.sponge;

import io.jadon.valhalla.team.VTeam;
import io.jadon.valhalla.world.VLocation;
import io.jadon.valhalla.world.VMap;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.world.SerializationBehaviors;
import org.spongepowered.api.world.World;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SpongeVMap extends VMap {

    private World world;

    public SpongeVMap(String name, String worldName, List<String> authors, Map<VTeam, VLocation> spawns) {
        super(name, worldName, authors, spawns);
    }

    @Override
    public void loadWorld() {
        if (isLoaded()) this.unloadWorld();
        Optional<World> oWorld = Sponge.getServer().loadWorld(this.getWorldName());
        if (oWorld.isPresent()) {
            world = oWorld.get();
            world.getProperties().setSerializationBehavior(SerializationBehaviors.NONE);
            this.setLoaded(true);
        } else {
            throw new IllegalStateException("World " + getWorldName() + " couldn't be loaded.");
        }
    }

    @Override
    public void unloadWorld() {
        Sponge.getServer().unloadWorld(world);
        this.setLoaded(false);
    }
}
