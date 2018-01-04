package io.jadon.valhalla.sponge;

import io.jadon.valhalla.team.AbstractPlayer;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

import java.util.Optional;
import java.util.UUID;

public class SpongePlayer implements AbstractPlayer {

    private UUID uuid;

    public SpongePlayer(Player player) {
        this.uuid = player.getUniqueId();
    }

    @NotNull
    @Override
    public Player getInternalPlayer() {
        Optional<Player> p = Sponge.getServer().getPlayer(uuid);
        if (p.isPresent()) {
            return p.get();
        } else throw new IllegalArgumentException("Player " + uuid + " is not on the server.");
    }

    @NotNull
    @Override
    public String getName() {
        return getInternalPlayer().getName();
    }

    @NotNull
    @Override
    public UUID getUUID() {
        return getInternalPlayer().getUniqueId();
    }

    @Override
    public void sendMessage(@NotNull String message) {
        getInternalPlayer().sendMessage(Text.of(message));
    }
}
