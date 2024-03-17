package cx.june.playermeowing.handlers;

import cx.june.playermeowing.PlayerMeowing;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;

public class ChatListener implements Listener {
    private final PlayerMeowing plugin;

    public ChatListener(PlayerMeowing plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onChat(@NotNull AsyncChatEvent event) {
        String message = PlainTextComponentSerializer.plainText().serialize(event.message()).toLowerCase();
        Player player = event.getPlayer();
        World world = player.getWorld();

        Bukkit.getScheduler().runTask(plugin, () -> {
            if (message.matches("\\b(?i)m+e+o+w+\\b")) {
                world.playSound(player, Sound.ENTITY_CAT_AMBIENT, 1, 1);
            } else if (message.matches("\\b(?i)m+r+e+o+w+\\b") || message.matches("\\b(?i)m+r+r+p+\\b")) {
                world.playSound(player, Sound.ENTITY_CAT_PURREOW, 1, 1);
            } else if (message.matches("\\b(?i)p+u+r+r+\\b")) {
                world.playSound(player, Sound.ENTITY_CAT_PURR, 1, 1);
            }
        });
    }
}
