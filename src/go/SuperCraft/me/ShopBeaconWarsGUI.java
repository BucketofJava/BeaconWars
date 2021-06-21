package go.SuperCraft.me;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Score;
import go.SuperCraft.me.BeaconWar;
import net.md_5.bungee.api.ChatColor;

public class ShopBeaconWarsGUI implements Listener {

public static ItemSmith GlassBreaker=new ItemSmith(Material.STONE_HOE, "Glass Breaker", ChatColor.GOLD+(("Cost: 50")), false, false, 0, 1, null);
static Player playar;

public ShopBeaconWarsGUI(){}
public void OnEnable(PluginManager pm){
	pm.registerEvents(this, Main.getInstance());
	
}
public void givegooditem(Player player, ItemStack item){
	
	
	Integer score=Integer.valueOf(ChatColor.stripColor(item.getItemMeta().getLore().get(0)).split(" ")[1]);
	
	if(BeaconWar.teamscores.get(BeaconWar.BeaconMain.getEntryTeam(player.getName()).getName())>=score){
	
if(item.getType().name().contains("CHESTPLATE")){
	player.getEquipment().setChestplate(new ItemStack(Material.valueOf(item.getType().name().split("_")[0]+"_CHESTPLATE")));
	player.getEquipment().setBoots(new ItemStack(Material.valueOf(item.getType().name().split("_")[0]+"_BOOTS")));
player.getEquipment().setLeggings(new ItemStack(Material.valueOf(item.getType().name().split("_")[0]+"_LEGGINGS")));
	player.getEquipment().setHelmet(new ItemStack(Material.valueOf(item.getType().name().split("_")[0]+"_HELMET")));
}	
else{player.getInventory().addItem(new ItemSmith(item.getType(), item.getItemMeta().getDisplayName(), new String[]{},false, false, 0, item.getAmount(), null));
	int teamscore=BeaconWar.teamscores.get(BeaconWar.BeaconMain.getEntryTeam(player.getName()));
	BeaconWar.teamscores.remove(BeaconWar.BeaconMain.getEntryTeam(player.getName()));
	BeaconWar.teamscores.put(BeaconWar.BeaconMain.getEntryTeam(player.getName()).getName(), teamscore-score);}
	}else{
		
		
		Bukkit.broadcastMessage(ChatColor.RED+"You don't have enough points for that");
	}
	Bukkit.broadcastMessage(String.valueOf(BeaconWar.teamscores.get(BeaconWar.BeaconMain.getEntryTeam(player.getName()))));
}
@EventHandler
public void OnInventoryClickEvent(InventoryClickEvent e){

if(e.getView().getTitle().equals("Shop"))	{
ItemStack item= e.getCurrentItem();
if(item.getType()
		!=Material.AIR
&&e.getRawSlot()>=9){

	givegooditem(((Player) e.getWhoClicked()), item);

e.setCancelled(true);
	
}
	
	
	
}
}

	





 


public static void openShopGUI(Player player){

playar=player;
Bukkit.getServer().broadcastMessage("POsfojaklsdfjasl;fdjas;ldfkja");
Inventory ShopGUI=Bukkit.createInventory(null, 54, "Shop");
//Line 1
ShopGUI.setItem(0, new ItemStack(Material.AIR, 1));
ShopGUI.setItem(1, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(2, new ItemStack(Material.AIR, 1));
ShopGUI.setItem(3, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(4, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(5, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(6, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(7, new ItemStack(Material.AIR, 1));
ShopGUI.setItem(8, new ItemStack(Material.AIR, 1));	
//Line 2
ShopGUI.setItem(9, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(10,  new ItemSmith(Material.valueOf((BeaconWar.BeaconMain.getEntryTeam(player.getName()).getName().toUpperCase())+"_STAINED_GLASS"), "Glass", ChatColor.GOLD+("Cost: 20"), false, false, 0, 64, null));	
ShopGUI.setItem(11, new ItemStack(Material.AIR, 1));
ShopGUI.setItem(12, GlassBreaker);
ShopGUI.setItem(13, new ItemStack(Material.AIR, 1));
ShopGUI.setItem(14, new ItemSmith(Material.STONE_SWORD, "Stone Sword", ChatColor.GOLD+("Cost: 10"), false, false, 0, 1, null));	
ShopGUI.setItem(15, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(16, new ItemSmith(Material.valueOf(BeaconWar.BeaconMain.getEntryTeam(player.getName()).getName().toUpperCase()+"_DYE"), "Beacon Dye", ChatColor.GOLD+"Cost: 50", false, false, 0, 1, null));	
ShopGUI.setItem(17, new ItemStack(Material.AIR, 1));
//Line 3
ShopGUI.setItem(18, new ItemStack(Material.AIR, 1));
ShopGUI.setItem(19, new ItemSmith(Material.LADDER, "Ladders", ChatColor.GOLD+("Cost: 25"), false, false ,0, 64, null));	
ShopGUI.setItem(20, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(21, new ItemSmith(Material.SLIME_BLOCK, "Launchpad (1 use)", ChatColor.GOLD+("Cost: 30"), false, false, 0, 1, null));	
ShopGUI.setItem(22, new ItemStack(Material.AIR, 1));
ShopGUI.setItem(23, new ItemSmith(Material.IRON_SWORD, "Iron Sword", ChatColor.GOLD+("Cost: 40"), false, false, 0, 1, null));	
ShopGUI.setItem(24, new ItemStack(Material.AIR, 1));
ShopGUI.setItem(25, new ItemSmith(Material.CHAINMAIL_CHESTPLATE, "Full Chainmail Armor", ChatColor.GOLD+"Cost: 20", false, false, 0, 1, null));	
ShopGUI.setItem(26, new ItemStack(Material.AIR, 1)); 
//Line 4
ShopGUI.setItem(27, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(28, new ItemSmith(Material.SNOWBALL, "Snowballs", ChatColor.GOLD+"Cost: 15", false, false, 0, 16, null));
ShopGUI.setItem(29, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(30, new ItemSmith(Material.WATER_BUCKET, "Permanent Water Bucket", ChatColor.GOLD+"Cost: 50", false, false, 0, 1, null));	
ShopGUI.setItem(31, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(32, new ItemSmith(Material.DIAMOND_SWORD, "Diamond Sword", ChatColor.GOLD+("Cost: 80"), false, false, 0, 1, null));	
ShopGUI.setItem(33, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(34, new ItemSmith(Material.IRON_CHESTPLATE, "Full Iron Armor", ChatColor.GOLD+"Cost: 50", false, false, 0, 1, null));
ShopGUI.setItem(35, new ItemStack(Material.AIR, 1));	
//Line 5
ShopGUI.setItem(36, new ItemStack(Material.AIR, 1));
ShopGUI.setItem(37, new ItemSmith(Material.ZOMBIE_SPAWN_EGG, "Minion Egg", ChatColor.GOLD+"Cost: 100", false, false, 0, 1, null));	
ShopGUI.setItem(38, new ItemStack(Material.AIR, 1));
ShopGUI.setItem(39, new ItemSmith(Material.BOW, "Bow", ChatColor.GOLD+("Cost: 50"), false, false, 0, 1, null));	
ShopGUI.setItem(40, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(41, new ItemSmith(Material.ARROW, "Arrows", ChatColor.GOLD+("Cost: 10"), false, false, 0, 16, null));	
ShopGUI.setItem(42, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(43, new ItemSmith(Material.DIAMOND_CHESTPLATE, "Full Diamond Armor", ChatColor.GOLD+"Cost: 100", false, false, 0, 1, null));
ShopGUI.setItem(44, new ItemStack(Material.AIR, 1));
//Line 6
ShopGUI.setItem(45, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(46, new ItemStack(Material.AIR, 1));
ShopGUI.setItem(47, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(48, new ItemStack(Material.AIR, 1));
ShopGUI.setItem(49, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(20, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(51, new ItemStack(Material.AIR, 1));	
ShopGUI.setItem(52, new ItemStack(Material.AIR, 1));
ShopGUI.setItem(53, new ItemStack(Material.AIR, 1));	
player.openInventory(ShopGUI);	

}
@EventHandler
public void Onplayerinteract(PlayerInteractEvent e){
if(e.getAction()==Action.RIGHT_CLICK_BLOCK&&e.getItem().getItemMeta().getDisplayName().contains("Beacon Dye")&&e.getClickedBlock().getType().name().toLowerCase().contains("glass")){
	
	for(Location x:BeaconWar.getMappy().getPoses()){
		if(x.getX()==e.getClickedBlock().getX()&&x.getZ()==e.getClickedBlock().getZ()&&BeaconWar.getMappy().getWorld().getBlockAt(new Location(e.getClickedBlock().getWorld(), e.getClickedBlock().getX(), e.getClickedBlock().getY()+1, e.getClickedBlock().getZ())).getType()==Material.AIR){
			BeaconWar.getMappy().getWorld().getBlockAt(new Location(e.getClickedBlock().getWorld(), e.getClickedBlock().getX(), e.getClickedBlock().getY()+1, e.getClickedBlock().getZ())).setType(Material.valueOf(e.getItem().getType().name().split("_")[0]+"_STAINED_GLASS"));
			e.getClickedBlock().setType(Material.valueOf(e.getItem().getType().name().split("_")[0]+"_STAINED_GLASS"));
			break;
		}
		
	}
	 
	
	
	
}

	
}	

@EventHandler
public void onblockplace(BlockPlaceEvent e){
	
	
	
}
	
public static boolean containsyvalue(Location[] array, double yvalue){
	boolean returnvalue=false;
	for (Location x:array){
		if(x.getY()==yvalue){
			
			returnvalue=true;
			break;
			
		}
		
	}
	return returnvalue;
	
	
}	


}
