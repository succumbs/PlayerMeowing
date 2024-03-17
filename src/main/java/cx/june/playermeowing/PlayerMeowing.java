package cx.june.playermeowing;

import cx.june.playermeowing.handlers.ChatListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerMeowing extends JavaPlugin {
    @Override
    public void onEnable() {
        new ChatListener(this);
        Bukkit.getLogger().info("PlayerMeowing has been enabled!");

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("PlayerMeowing has been disabled!");
    }
}
