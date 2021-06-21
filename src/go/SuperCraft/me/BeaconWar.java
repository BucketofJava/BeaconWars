package go.SuperCraft.me;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import go.SuperCraft.me.ShopBeaconWarsGUI;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;

public class BeaconWar implements Listener{
	/*+
	BeaconMain.
	getEntryTeam(player.getName()).
	getColor()*/
	/*objective.setDisplayName(ChatColor.GREEN+(ChatColor.BOLD+"Beacon Wars"));
	objective.setDisplaySlot(DisplaySlot.SIDEBAR);*/
	
	public static HashMap<Team, Score> teampoints = new HashMap<Team, Score>();
	public int teams=0;
	public static ItemStack specialLaunchpad;
	public int playersper=0;
	public int players=0;
	public static Scoreboard BeaconMain;
	public ArrayList<Player> playerlist=new ArrayList<>();
	public static HashMap<String, Integer> teamscores = new HashMap<>();
	public HashMap<Team, ChatColor> teamcolors=new HashMap<>();
	public World beaconworld; 
	public static BeaconMap beaconmappy;
	public static BeaconMap mappy=new BeaconMap(Bukkit.getWorld("BeaconWarsTest"),  (float) 295, (float) 3, (float) 295,new Location(Bukkit.getWorld("BeaconWarsTest"), (float) 131, (float)205, (float) 110 ));
	public Score scoreteam;
	Material xyz=Material.valueOf("YELLOW_STAINED_GLASS");

	public ArrayList<Float> yposes;
	public BeaconWar(){}
	
	public BeaconWar(int teamsx, int playersperx, int playersx, ArrayList<Player> playerlistx){
		teams=teamsx;
		playersper=playersperx;
		players=playersx;
		playerlist=playerlistx;

		
	}
	
	
	public static BeaconMap getMappy(){
		
		
		return beaconmappy;
	}
	public void OnEnable(PluginManager pm){
		pm.registerEvents(this, Main.getInstance());
		
	}
	@EventHandler
	public void OnPlayerMove(PlayerMoveEvent e){
		if(e.getFrom().getY()<e.getTo().getY()&&Main.Launchpads.contains(new Location(e.getFrom().getWorld(), e.getFrom().getX(), e.getFrom().getY()-1, e.getFrom().getZ()).getBlock())){
			e.setCancelled(true);
			e.getPlayer().setVelocity(e.getTo().subtract(e.getFrom()).toVector().multiply(Main.launchpadvalue));
			new Location(e.getFrom().getWorld(), e.getFrom().getX(), e.getFrom().getY()-1, e.getFrom().getZ()).getBlock().setType(Material.AIR);;
			
			Main.Launchpads.remove(new Location(e.getFrom().getWorld(), e.getFrom().getX(), e.getFrom().getY()-1, e.getFrom().getZ()).getBlock());
			
		}
		
		
	}
	@EventHandler
	public void OnInteract(PlayerInteractEvent e){
		if(e.getAction()==Action.RIGHT_CLICK_BLOCK||e.getAction()==Action.RIGHT_CLICK_AIR){
			
			if(e.getPlayer().getInventory().getItemInMainHand().getType()==Material.BOOK&&e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Shop")){
				ShopBeaconWarsGUI.openShopGUI(e.getPlayer());
				
			}
		}
		
		
	}
	@EventHandler
	public void OnBlockPlace(BlockPlaceEvent e){
		
		
		if(Main.gamestart&&!(e.getPlayer().getGameMode()==GameMode.CREATIVE)){
			for(Location pos:beaconmappy.getPoses()){
				Boolean stuffies=(e.getBlock().getX()>beaconmappy.getdimensions()[0]+beaconmappy.getCorner().getX()||e.getBlock().getX()<beaconmappy.getCorner().getX());
				if(pos.getY()==e.getBlock().getY()&&stuffies){
					e.getPlayer().sendMessage(ChatColor.RED+"You can't place blocks here");
					e.setCancelled(true); 
					break;
				}
				
			}
		
			
			
			
			
		}
		if(e.isCancelled()==false){
			Main.Playerblocks.add(e.getBlock());
		

			if(e.getItemInHand().getItemMeta().getDisplayName().contains("Launchpad")){
				
				Main.Launchpads.add(e.getBlock());
				specialLaunchpad=e.getItemInHand();
				specialLaunchpad.setAmount(1);
				
									
			}
		}
		
		
	}
	
	public void Scoreboarding(Player player){
		Team teamyu=BeaconMain.getEntryTeam(player.getName());
		Scoreboard board=Bukkit.getScoreboardManager().getNewScoreboard();
		Objective tive=board.registerNewObjective("Points", "", "dummy");
		tive.setDisplaySlot(DisplaySlot.SIDEBAR);
		tive.setDisplayName(ChatColor.GREEN+(ChatColor.BOLD+"BeaconWars"));
		Score empty1=tive.getScore("");
		empty1.setScore(0);
		Score empty2=tive.getScore("");
		empty2.setScore(1);
		Score Pointy=tive.getScore(ChatColor.WHITE+"Points: "+ChatColor.GOLD+String.valueOf(teamscores.get(teamyu.getName())));
		Pointy.setScore(2);
		Score empty3=tive.getScore("");
		empty3.setScore(3);
		Score empty4=tive.getScore("");
		empty4.setScore(4);
		Score Teamy=tive.getScore(teamyu.getColor()+teamyu.getName());
		player.setScoreboard(board);
	}
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent e){
		if(Main.gamestart){
		Scoreboarding(e.getPlayer());}

		}
	@EventHandler
	public void onPlayerInteractBlock(PlayerInteractEvent e){

		if (e.getAction()==Action.RIGHT_CLICK_BLOCK&&e.getClickedBlock().getType()==Material.BEACON&&e.getClickedBlock().getWorld()==beaconworld){}
		}
	@EventHandler
	public void onBeaconBreak(BlockBreakEvent e){
		if(Main.gamestart){
		if ((!Main.Playerblocks.contains(e.getBlock()))&&!(e.getPlayer().getGameMode()==GameMode.CREATIVE)&&e.getBlock().getWorld()==beaconworld){
			e.setCancelled(true);
		}
		if(Main.Launchpads.contains(e.getBlock())){
			e.setDropItems(false);
			Main.Launchpads.remove(e.getBlock());
			specialLaunchpad.setAmount(1);
			e.getBlock().getWorld().dropItem(e.getBlock().getLocation(), specialLaunchpad);
		}}
		
	}
	
	public void StartGame(){
		   ScoreboardManager manager=Bukkit.getScoreboardManager();
			  
		 
		   BeaconMain=manager.getMainScoreboard();

		   Team red;
		   Team green;
		   Team yellow;
		   Team blue;
		   Team white;
		   if(BeaconMain.getTeams().size()==0){
		 red=BeaconMain
				  .registerNewTeam("Red");
	green=BeaconMain.registerNewTeam("Green");
	yellow=BeaconMain.registerNewTeam("Yellow");
blue=BeaconMain.registerNewTeam("Blue");
	 white=BeaconMain.registerNewTeam("Default");}
		   else{
			   red=BeaconMain
						  .getTeam("Red");
			green=BeaconMain.getTeam("Green");
			yellow=BeaconMain.getTeam("Yellow");
		blue=BeaconMain.getTeam("Blue");
			 white=BeaconMain.getTeam("Default");
			   
		   }
		   for (String team:teamscores.keySet()){
			   teamscores.remove(team);
			   
		   }
		   for (Team team:teampoints.keySet()){
			   teampoints.remove(team);
			   
		   }
			white.setColor(ChatColor.WHITE);
			red.setColor(ChatColor.RED);
			blue.setColor(ChatColor.BLUE);
			yellow.setColor(ChatColor.YELLOW);
			green.setColor(ChatColor.GREEN);
			Team[] teamss={red, green, yellow, blue};
			for(int i =0; i<=3; i++){
		
				teamss[i].setCanSeeFriendlyInvisibles(true);
				teamss[i].setAllowFriendlyFire(false);
				teamss[i].setPrefix(teamss[i].getColor()+teamss[i].getName());
				
				teamscores.put(teamss[i].getName(), 0);
		
				teampoints.put(teamss[i], null);
				
			}
		  /*yellowBeacon=manager.getNewScoreboard();
		   redBeacon=manager.getNewScoreboard();
		   greenBeacon=manager.getNewScoreboard();
		   blueBeacon=manager.getNewScoreboard();
		
			Objective yellowObjective=yellowBeacon.registerNewObjective("Points", "",  "dummy");
			yellowObjective.setDisplayName(ChatColor.GREEN+(ChatColor.BOLD+"Beacon Wars"));
			yellowObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
			yellowPoints=yellowObjective.getScore(ChatColor.WHITE+"Points: "+BeaconWar.teamscores.get(yellow));
			Score yellowteamscore=yellowObjective.getScore(ChatColor.WHITE+"Team: "+yellow.getColor()+yellow.getName());
			Objective redObjective= redBeacon.registerNewObjective("Points", "",  "dummy");
			redObjective.setDisplayName(ChatColor.GREEN+(ChatColor.BOLD+"Beacon Wars"));
			redObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
			redPoints=redObjective.getScore(ChatColor.WHITE+"Points: "+BeaconWar.teamscores.get(red));
			Score redteamscore=redObjective.getScore(ChatColor.WHITE+"Team: "+red.getColor()+red.getName());
			Objective blueObjective=blueBeacon.registerNewObjective("Points", "",  "dummy");
			blueObjective.setDisplayName(ChatColor.GREEN+(ChatColor.BOLD+"Beacon Wars"));
			blueObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
			bluePoints=blueObjective.getScore(ChatColor.WHITE+"Points: "+BeaconWar.teamscores.get(blue));
			Score blueteamscore=blueObjective.getScore(ChatColor.WHITE+"Team: "+blue.getColor()+blue.getName());
			Objective greenObjective=greenBeacon.registerNewObjective("Points", "",  "dummy");
			greenObjective.setDisplayName(ChatColor.GREEN+(ChatColor.BOLD+"Beacon Wars"));
			greenObjective.setDisplaySlot(DisplaySlot.SIDEBAR);
			greenPoints=greenObjective.getScore(ChatColor.WHITE+"Points: "+BeaconWar.teamscores.get(green));
			Score greenteamscore=greenObjective.getScore(ChatColor.WHITE+"Team: "+green.getColor()+green.getName());
			teampoints.put(BeaconMain.getTeam("Red"), redPoints);
			teampoints.put(BeaconMain.getTeam("Blue"), bluePoints);
			teampoints.put(BeaconMain.getTeam("Yellow"), yellowPoints);
			teampoints.put(BeaconMain.getTeam("Green"), greenPoints);*/

		Collections.shuffle(playerlist);
		int v=0;

		for(int i=0; i<players; i++){
			Player player=playerlist.get(i);
			//Bukkit.broadcastMessage("TESTMESSAGE@");
			Scoreboard boardt=playerlist.get(i).getScoreboard();
			if(v>=4){
				v=0;
			} else if(v==3){
				BeaconMain.getTeam("Red").addEntry(player.getName());
				
				
				
			}
		else if(v==2){
			BeaconMain.getTeam("Green").addEntry(player.getName());
			
		}else if(v==1){
			BeaconMain.getTeam("Blue").addEntry(player.getName());
			
		}else if(v==0){
			String xe=player.getName();
			Scoreboard hahaha=BeaconMain;
			BeaconMain.getTeam("Yellow").addEntry(player.getName());
			//Bukkit.broadcastMessage("Yellow be working");
		}
	
			BeaconGameLoop(mappy);
			//playerlist.get(i).setScoreboard(boardt);
			/*BukkitRunnable stuff=new BukkitRunnable(){

				@Override
				public void run() {
					ShopBeaconWarsGUI.openShopGUI(player);
					
				}
				
			};
			player.getInventory().addItem(new ItemSmith(Material.BOOK, (ChatColor.RESET+"Shop")+ChatColor.GREEN, ChatColor.RESET+"Buy things using your points", false, false, 0, 1, stuff));
			
			v++;*/
			
		
	
	}
		
		
		
	}

	
	public void BeaconGameLoop(BeaconMap world){
		beaconworld=world.getWorld();
		beaconmappy=world;
		//Bukkit.broadcastMessage(beaconworld.getName());
		boolean endGame=false;
		//Bukkit.broadcastMessage(String.valueOf(world.getPoses().length));
		for (int i=0; i<players; i++){
			Player player=playerlist.get(i);
			BukkitRunnable stuff=new BukkitRunnable(){

				@Override
				public void run() {
					ShopBeaconWarsGUI.openShopGUI(player);
					
				}
				
			};
			player.getInventory().addItem(new ItemSmith(Material.BOOK, (ChatColor.RESET+"Shop")+ChatColor.GREEN, ChatColor.RESET+"Buy things using your points", false, false, 0, 1, null));
			
			
			
		}
		
		BukkitRunnable loop=new BukkitRunnable(){

			@Override
			public void run() {
				//Bukkit.broadcastMessage("DOUD");
				Boolean keepgoing=true;
				for (int i=0; i<=world.getPoses().length-1; i++){
					Team happened=null;
					for (int u=(int) world.getPoses()[i].getY()+1; u<=256; u++){
					Boolean hasran=false;
							//Bukkit.broadcastMessage(String.valueOf((int) world.getPoses()[i].getY()+1));
						Location loc=new Location(beaconworld, world.getPoses()[i].getX(), u,  world.getPoses()[i].getZ());
						
						if (u==(int) world.getPoses()[i].getY()+1&&loc.getBlock().getType()==Material.AIR){
							
							break;
						}else{ 
							//Bukkit.broadcastMessage(String.valueOf(teamscores.keySet().size()));							
							Team[] teams=teampoints.keySet().toArray(new Team[teampoints.keySet().size()]);
							for(int z=0; z<=teampoints.size()-1; z++){
							
							if (loc.getBlock().getType().name().contains(teams[z].getName().toUpperCase())){
								hasran=true;
								
								teamscores.replace(teams[z].getName(), teamscores.get(teams[z])+1);
								happened=teams[z];
								
								break;
								
							}
								 
								
								
							}
							if(!hasran&&happened!=null){
								
								teamscores.replace(happened.getName(), teamscores.get(happened)+1);
								
							}
						}
						
					
					}
					
				}
	
				for(int he=0; he<=world.getPoses().length-1; he++){
					/*Bukkit.broadcastMessage(String.valueOf((float) world.getPoses()[he].getX())+
				","+	String.valueOf((float) world.getPoses()[he].getY())+
				","+String.valueOf((float) world.getPoses()[he].getZ()));*/
				}
				
				
				
			for(int l=0; l<=playerlist.size()-1; l++){
				
				
				
				
			}}
			
			
			
		};
		loop.runTaskTimer(Main.getInstance(), 0, 1200);
		
	}
	
	
	
}
