package go.SuperCraft.me;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import net.md_5.bungee.api.ChatColor;

public class BeaconWarsScoreboard implements Listener {
	public BeaconWarsScoreboard(){}
	/*public void OnEnable(PluginManager pm){
		pm.registerEvents(this, Main.getInstance());
		
	}
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent e){
		Bukkit.getServer().broadcastMessage("PlayerJoined");
		createScoreboard(e.getPlayer());
	}
	public void createScoreboard(Player player){
		ScoreboardManager manager=Bukkit.getScoreboardManager();
		Scoreboard board=manager.getNewScoreboard();
		Objective objective=board.registerNewObjective("Points", "", "dummy");
		objective.setDisplayName(ChatColor.GREEN+"Beacon Wars"+ChatColor.BOLD);
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		Score score=objective.getScore("Points: ");
		score.setScore(0);
		player.setScoreboard(board);
	}*/

}
