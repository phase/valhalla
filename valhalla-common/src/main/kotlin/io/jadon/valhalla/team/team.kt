package io.jadon.valhalla.team

import java.util.*

interface AbstractPlayer {
    fun getUUID(): UUID
    fun getName(): String

    fun sendMessage(message: String)

    fun getInternalPlayer(): Any
}

class VTeam(val name: String, val maxPlayers: Int) {
    val players = mutableListOf<AbstractPlayer>()

    fun isOnTeam(player: AbstractPlayer): Boolean {
        return players.contains(player)
    }

    fun addPlayer(player: AbstractPlayer) {
        if (!isOnTeam(player)) {
            if (players.size < maxPlayers) {
                players.add(player)
            } else {
                player.sendMessage("$name is full!")
            }
        } else {
            player.sendMessage("You are already on $name!")
        }
    }

    fun removePlayer(player: AbstractPlayer) {
        if (isOnTeam(player)) {
            players.remove(player)
        } else {
            player.sendMessage("You are not on $name!")
        }
    }
}
