package io.jadon.valhalla.sponge;

import io.jadon.valhalla.world.AbstractWorld;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.api.world.World;

import java.lang.ref.WeakReference;

public class SpongeWorld implements AbstractWorld {

    private WeakReference<World> world;

    public SpongeWorld(World world) {
        this.world = new WeakReference<>(world);
    }

    @NotNull
    @Override
    public String getName() {
        return world.get().getName();
    }
}
