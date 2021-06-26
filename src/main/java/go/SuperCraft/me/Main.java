package go.SuperCraft.me;
import go.SuperCraft.me.Minion;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import java.util.Random;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.block.Beacon;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import go.SuperCraft.me.ItemSmith;  
import go.SuperCraft.me.VoidCreator;
import org.bukkit.generator.ChunkGenerator;
import go.SuperCraft.me.FloatingIsland;
import go.SuperCraft.me.ShopBeaconWarsGUI;
public class Main extends JavaPlugin {
	public static Boolean MinecraftBut=false;
	private static Main instance;
	public static boolean gamestart=false;
	Boolean check=false;
	/*public static Scoreboard yellowBeacon;
	public static Scoreboard redBeacon;
	public static Scoreboard greenBeacon;
	public static Scoreboard blueBeacon;
	public static Scoreboard BeaconMain;
	public static Score yellowPoints;
	public static Score redPoints;
	public static Score bluePoints;
	public static Score greenPoints;
	public static HashMap<Team, Score> teampoints = new HashMap<Team, Score>();*/
	public static int Minionnumber=0;
	public static double launchpadvalue=10;
	
	
	public static ArrayList<Block> Launchpads= new ArrayList<>();
	public static ArrayList<Block> Playerblocks=new ArrayList<>();
	/*public static EntityType getRandomEntity(){
		ArrayList<EntityType> entities=new ArrayList<>();
		entities.add(EntityType.BAT);
		entities.add(EntityType.BLAZE);
		entities.add(EntityType.CAT);
		entities.add(EntityType.CAVE_SPIDER);
		entities.add(EntityType.CHICKEN);
		entities.add(EntityType.COD);
		entities.add(EntityType.COW);
		entities.add(EntityType.CREEPER);
		entities.add(EntityType.DOLPHIN);
		entities.add(EntityType.DONKEY);
		entities.add(EntityType.DROWNED);
		entities.add(EntityType.ELDER_GUARDIAN);
		entities.add(EntityType.ENDER_DRAGON);
		entities.add(EntityType.ENDERMAN);
		entities.add(EntityType.EVOKER);
		entities.add(EntityType.FOX);
		entities.add(EntityType.GHAST);
		entities.add(EntityType.GIANT);
		entities.add(EntityType.GUARDIAN);
		entities.add(EntityType.HORSE);
		entities.add(EntityType.HUSK);
		entities.add(EntityType.ILLUSIONER);
		entities.add(EntityType.IRON_GOLEM);
		entities.add(EntityType.LLAMA);
		entities.add(EntityType.MAGMA_CUBE);
		entities.add(EntityType.MULE);
		entities.add(EntityType.MUSHROOM_COW);
		entities.add(EntityType.OCELOT);
		entities.add(EntityType.PANDA);
		entities.add(EntityType.PARROT);
		entities.add(EntityType.PHANTOM);
		entities.add(EntityType.PIG);
		entities.add(EntityType.PIG_ZOMBIE);
		entities.add(EntityType.PILLAGER);
		entities.add(EntityType.POLAR_BEAR);
		entities.add(EntityType.PUFFERFISH);
		entities.add(EntityType.RABBIT);
		entities.add(EntityType.RAVAGER);
		entities.add(EntityType.SALMON);
		entities.add(EntityType.SHEEP);
		entities.add(EntityType.SHULKER);
		entities.add(EntityType.SILVERFISH);
		entities.add(EntityType.SKELETON);
		entities.add(EntityType.SLIME);
		entities.add(EntityType.SNOWMAN);
		entities.add(EntityType.SPIDER);
		entities.add(EntityType.SQUID);
		entities.add(EntityType.STRAY);
		entities.add(EntityType.TURTLE);
		entities.add(EntityType.VEX);
		entities.add(EntityType.VINDICATOR);
		entities.add(EntityType.VILLAGER);
		entities.add(EntityType.WANDERING_TRADER);
		entities.add(EntityType.WITCH);
		//entities.add(EntityType.WITHER);
		entities.add(EntityType.WITHER_SKELETON);
		entities.add(EntityType.WITCH);
		entities.add(EntityType.ZOMBIE);
		entities.add(EntityType.ZOMBIE_HORSE);
		entities.add(EntityType.ZOMBIE_VILLAGER);
		Random rand=new Random();
		return entities.get(rand.nextInt(entities.size()));
		
	}
*/
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id)
	{
	return new WorldGenerator();
	}
	

	WorldCreator teest=new WorldCreator("Void_Template");
	   @Override
	    public void onEnable() {
		   
		   
		  instance=this; 
		   PluginManager pm=getServer().getPluginManager();
		   ListenerOne listener= new ListenerOne(this);
		   ItemSmith Smith=new ItemSmith();
		   pm.registerEvents(listener, this);
		   Bukkit.getServer().createWorld(teest);
		   new BeaconWar().OnEnable(pm);
		   new ShopBeaconWarsGUI().OnEnable(pm);

			
		   
	   }
	   public static Main getInstance(){
		   return instance;
		   
	   }
	   public static Boolean getMinecraftBut(){
		   return MinecraftBut;
	   }
	   @Override
	    public void onDisable() {
		  
	    }
	   
	   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		   Player player= (Player) sender;
		   if (sender instanceof Player){
			   String lowerCmd= cmd.getName().toLowerCase();
		   
		   switch(lowerCmd){
		   case "givebeacon":
			   if(player.isOp()){
				   player.sendMessage(ChatColor.translateAlternateColorCodes('&', "OP is working"));
				   player.sendMessage(ChatColor.translateAlternateColorCodes('&', "aToNull is working"));
				   
				   
				   player.sendMessage(ChatColor.translateAlternateColorCodes('&', "B is working"));
				  // BeaconState state=BeaconState.asBeacon(b);

				   player.sendMessage(ChatColor.translateAlternateColorCodes('&', "ItemSmith is working"));}
				   //state.setPrimary(PotionEffectType.BLINDNESS);
				   //state.setSecondary(PotionEffectType.UNLUCK);
			case "createvoid":
				//WorldCreator wc = new WorldCreator("Void");
				//wc.generator(new VoidCreator()); 
				//wc.createWorld();-all this was commented out because I had already created the world
				player.teleport(new Location(Bukkit.getWorld("Void"), 0, 255, 0));
			case "generateisland":
				new FloatingIsland().GenerateIsland(player, 40, 20, 40, true);
				player.sendMessage("hi");
			case "setlaunchpadvalue":
				if(player.isOp()){
					if(args.length==1){
						if(Double.valueOf(args[0])!=null){
							
							launchpadvalue=Double.valueOf(args[0]);
							
						}else{	Bukkit.broadcastMessage("Usage: setlaunchpadvalue value");}
						
						
					}else{
						
						Bukkit.broadcastMessage("Usage: setlaunchpadvalue value");
					}
					
				}
			case "gencurve":
				int z=(int) Math.round(Math.random()*20);
		
				for(int i=0; i<10; i++){
					player.sendMessage(String.valueOf(FloatingIsland.Curve((int) player.getLocation().getX(), (int) player.getLocation().getY(), (int) i, z)));
					player.getWorld().getBlockAt((int) player.getLocation().getX()+i,FloatingIsland.Curve((int) player.getLocation().getX(), (int) player.getLocation().getY(), (int) i, z), (int) player.getLocation().getZ()).setType(Material.STONE);
				}
			case "dostuff":
				Bukkit.getServer().broadcastMessage("asdfafsd");
				BukkitRunnable stuff=new BukkitRunnable(){
					
					@Override
					public void run() {
						
						Bukkit.getServer().broadcastMessage("HELLO,ISIISISI");
						ShopBeaconWarsGUI.openShopGUI(player);
						
					}
			
					
				};
				ItemStack u=(ItemStack) new ItemSmith(Material.PAPER, "Woooo", "woooooooo", false, false, 0, 1, stuff);
				Bukkit.getServer().broadcastMessage(String.valueOf(u));
				player.getInventory().addItem(u);
				
			case "startgame":
				gamestart=true;
				Bukkit.getServer().broadcastMessage("HELLO::::"+String.valueOf(BeaconWar.mappy.getPoses().length));
				BeaconWar beaconwar=new BeaconWar(4, 4, ListenerOne.getPlayerList().size(), ListenerOne.getPlayerList());
				beaconwar.StartGame();
			/*case "spawnminion":
				net.minecraft.server.v1_14_R1.World world=(net.minecraft.server.v1_14_R1.World) player.getWorld();
				Minion minion=new Minion(player.getWorld(), BeaconMain.getTeam("Yellow"));
				world.addEntity(minion);*/
			case "minecraftbut":
				MinecraftBut=true;
			case "check":
				Bukkit.broadcastMessage(String.valueOf(check));
			case "toglass":
				Block block=player.getWorld().getBlockAt(player.getLocation());
				block.setType(Material.AIR);
				player.sendBlockChange(player.getLocation(), block.getBlockData());
			case "getworld":
				Bukkit.broadcastMessage("Current World: "+player.getWorld().getName());
			case "addteamscore":
				if(player.isOp()){
					Team[] yteams=new Team[4];
					Team[] keyysto=BeaconWar.teamscores.keySet().toArray(yteams);
					if(args.length==2){
					for (Team team:keyysto){
						Bukkit.broadcastMessage(team.getName()+"HITHEIRHERE");
						if(ChatColor.stripColor(team.getName()).toLowerCase().contains(ChatColor.stripColor(args[0]).toLowerCase())){
							player.sendMessage(ChatColor.GREEN+String.valueOf(args[1])+" points were added to team " + args[0]);
							int score=BeaconWar.teamscores.get(team);
							
							BeaconWar.teamscores.replace(team.getName(), score+Integer.valueOf(args[1]));
							
							break;
							
						}
						
						
					}	
					
						
					}else{
						
						
						player.sendMessage(ChatColor.RED+"Usage: /addteamscore Team Score");
					}
					
				}
	
				   
		   
		   }
			   
		  
	   }
		   return true;
}}
