package go.SuperCraft.me;

import org.bukkit.craftbukkit.v1_14_R1.CraftWorld;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scoreboard.Team;

import net.minecraft.server.v1_14_R1.EntityHuman;
import net.minecraft.server.v1_14_R1.EntityTypes;
import net.minecraft.server.v1_14_R1.EntityZombie;
import net.minecraft.server.v1_14_R1.EntityZombieHusk;
import net.minecraft.server.v1_14_R1.PathfinderGoalZombieAttack;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;

public class Minion extends EntityZombie {
	Team team;

	public Minion( World world, Team turny) {
		super(((CraftWorld)world).getHandle());
		Zombie hahazombie=(Zombie) this.getBukkitEntity();
		this.setBaby(true);
		hahazombie.setMaxHealth(50);
		this.team=turny;
		
		hahazombie.setCustomName("MINION_"+turny.getName().toUpperCase()+"_"+String.valueOf(Main.Minionnumber));
		Main.Minionnumber++;
		this.setCustomNameVisible(false);
		this.setHealth(50);
		hahazombie.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(7);
		hahazombie.getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(0.85);
		ItemStack ArmorBoots=new ItemStack(Material.LEATHER_BOOTS);
		ItemStack ArmorChestplate=new ItemStack(Material.LEATHER_CHESTPLATE);
		ItemStack ArmorHelmet=new ItemStack(Material.LEATHER_HELMET);
		ItemStack ArmorLeggings=new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta asaMeta=(LeatherArmorMeta) ArmorBoots.getItemMeta();
		if(turny.getColor()==ChatColor.RED){
			asaMeta.setColor(Color.RED);
		}else if(turny.getColor()==ChatColor.BLUE){
			
			asaMeta.setColor(Color.BLUE);
		}else if(turny.getColor()==ChatColor.GREEN){
			asaMeta.setColor(Color.GREEN);
			
		}else if(turny.getColor()==ChatColor.YELLOW){
			
			
			asaMeta.setColor(Color.YELLOW);
		}
		ArmorBoots.setItemMeta(asaMeta);
		ArmorChestplate.setItemMeta(asaMeta);
		ArmorHelmet.setItemMeta(asaMeta);
		ArmorLeggings.setItemMeta(asaMeta);
		
		
		hahazombie.getEquipment().setChestplate(ArmorChestplate);
		hahazombie.getEquipment().setBoots(ArmorBoots);
		hahazombie.getEquipment().setLeggings(ArmorLeggings);
		hahazombie.getEquipment().setHelmet(ArmorHelmet);
		double distance=1000000;
		Player playeri = null;
		for(Player p:this.getWorld().getPlayers().toArray(new Player[this.getWorld().getPlayers().size()])){
			if(BeaconWar.BeaconMain.getEntryTeam(this.getName())!=BeaconWar.BeaconMain.getEntryTeam(p.getName())){
				double distancey=p.getLocation().distance(this.getBukkitEntity().getLocation());
				if(distancey<distance){
					distance=distancey;
					playeri=p;
				}
				
				
			}
			
		}
		if(playeri!=null){
			
			hahazombie.setTarget(playeri);
		}
		
		this.targetSelector.a(new PathfinderGoalZombieAttack(this,EntityType.PLAYER.getTypeId(), true));
		
		// TODO Auto-generated constructor stub
	}
	
	public void setTeam(Team teamy){
		
		this.team=teamy;
		teamy.addEntry(this.getName());
	}
	public Team getTeam(){
		return this.team;
	}



}
