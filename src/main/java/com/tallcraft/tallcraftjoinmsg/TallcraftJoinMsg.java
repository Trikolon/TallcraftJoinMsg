package com.tallcraft.tallcraftjoinmsg;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TallcraftJoinMsg extends JavaPlugin implements Listener {
    public TallcraftJoinMsg() {
    }

    public void onEnable() {
        this.saveDefaultConfig();
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        String joinMessageSetNoColour = this.getConfig().getString("message").replaceAll("PLAYERNAME", p.getName());
        String joinMessageSet = ChatColor.translateAlternateColorCodes('&', joinMessageSetNoColour);
        e.setJoinMessage(joinMessageSet);
    }

    @EventHandler
    public void PlayerLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        String leaveMessageNoColour = this.getConfig().getString("leaveMessage").replaceAll("PLAYERNAME", p.getName());
        String leaveMessage = ChatColor.translateAlternateColorCodes('&', leaveMessageNoColour);
        e.setQuitMessage(leaveMessage);
    }
}
