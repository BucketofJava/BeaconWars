package go.SuperCraft.me;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Command implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
		Player player= (Player) sender;
		if (sender instanceof Player){
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', "hi"));
		}else{
			sender.sendMessage("Bye");
		}
		return true;
	}

}
