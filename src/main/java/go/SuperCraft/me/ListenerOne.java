package go.SuperCraft.me;

import java.util.ArrayList;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vex;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import go.SuperCraft.me.BeaconGUI;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import net.md_5.bungee.api.ChatColor;
import java.util.Random;

public class ListenerOne implements Listener {
	static ArrayList<Player> playerlist=new ArrayList<>();
	
	Player player;
	//Block b=new ItemSmith().BuildBlock(Material.BEACON, new Location(Bukkit.getWorld("world"), 0, 255, 0));
	public ListenerOne(Main plugin){
		
	}
	public static ArrayList<Player> getPlayerList(){
		return playerlist;
	}
	
	
	@EventHandler (priority = EventPriority.NORMAL)
	public void onInventoryOpen (InventoryOpenEvent event, PlayerInteractEvent event2) {
		/*player.sendMessage(String.valueOf( event.getInventory().getType() == InventoryType.BEACON&&event2.getClickedBlock()==b));
	    if (event.getInventory().getType() == InventoryType.BEACON&&event2.getClickedBlock()==b) {
	        event.setCancelled(true); 
	        BeaconGUI.openBeaconGUI((Player) event.getPlayer());
	    }*/
	}
	//public ItemStack interfaced=new ItemSmith().BuildItem(Material.BOOK, "Interface", "Right-click to access interface", false, false);
	//public ItemStack hhelo=new ItemSmith().BuildItem(Material.DIAMOND_SWORD, "Sword of Zeus", "May Lightning destroy your enemies", false, false);
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		playerlist.add(event.getPlayer());
		Player player=(Player) event.getPlayer();
		//player.getInventory().addItem(hhelo);
	}
	@EventHandler
	public void onPlayerInteractBlock(PlayerInteractEvent event) {
		
		  Player player = event.getPlayer();
		 // player.sendMessage(String.valueOf(player.getInventory().getItemInMainHand().isSimilar(hhelo)));
	    //if (player.getInventory().getItemInMainHand().isSimilar(hhelo)) {
	    	//player.sendMessage(ChatColor.translateAlternateColorCodes('&', "hi2"));
	        // Creates a bolt of lightning at a given location. In this case, that location is where the player is looking.
	        // Can only create lightning up to 200 blocks away.
	        //player.getWorld().strikeLightning(player.getLocation().add(5, 0, 5));
	    	//player.teleport(new Location(Bukkit.getWorld("void"), 0, 255, 0));
	    //}
	
		
	}
	@EventHandler
	public void OnInventoryClickEvent(InventoryClickEvent e){
		Player p=(Player) e.getWhoClicked();
		Inventory in=e.getClickedInventory();
		  if(e==e){
			  
			  
		  }
	}
	@EventHandler
	public void OnPlayerJoin(PlayerJoinEvent e){
		
		e.getPlayer().setGameMode(GameMode.CREATIVE);
		
	}
	@EventHandler
	public void OnPlayerInteract(PlayerInteractEvent e){
		Random random=new Random();
		/*if(Main.getMinecraftBut()==true&&random.nextInt(1)==0){

			e.getPlayer().getWorld().spawnEntity(e.getPlayer().getLocation(), Main.getRandomEntity());}*/
		
	}
}