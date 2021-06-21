package go.SuperCraft.me;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BeaconGUI {
static Inventory beaconGUI=Bukkit.createInventory(null, 27, "");
public BeaconGUI(){}
public static void openBeaconGUI(Player player){
beaconGUI.setItem(0, new ItemStack(Material.DIAMOND_LEGGINGS, 1));
beaconGUI.setItem(1, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(2, new ItemStack(Material.AIR, 1));
beaconGUI.setItem(3, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(4, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(5, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(6, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(7, new ItemStack(Material.AIR, 1));
beaconGUI.setItem(8, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(9, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(10, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(11, new ItemStack(Material.AIR, 1));
beaconGUI.setItem(12, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(13, new ItemStack(Material.AIR, 1));
beaconGUI.setItem(14, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(15, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(16, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(17, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(18, new ItemStack(Material.AIR, 1));
beaconGUI.setItem(19, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(20, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(21, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(22, new ItemStack(Material.AIR, 1));
beaconGUI.setItem(23, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(24, new ItemStack(Material.AIR, 1));
beaconGUI.setItem(25, new ItemStack(Material.AIR, 1));	
beaconGUI.setItem(26, new ItemStack(Material.AIR, 1));	
player.openInventory(beaconGUI);	


}
}
