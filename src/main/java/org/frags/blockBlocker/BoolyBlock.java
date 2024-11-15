package org.frags.blockBlocker;

import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.frags.blockBlocker.files.DataFile;

public final class BlockBlocker extends JavaPlugin {

    public DataFile dataFile;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        dataFile = new DataFile(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static String miniMessageParser(String input) {
        MiniMessage miniMessage = MiniMessage.miniMessage();

        TextComponent textComponent = (TextComponent) miniMessage.deserialize(input);

        return ChatColor.translateAlternateColorCodes('&', textComponent.content());
    }
}
