package go.SuperCraft.me;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
public class VoidCreation{
//WorldCreator teest=(WorldCreator) Bukkit.getWorld("Void_Template");
	WorldCreator teest=new WorldCreator("Void_Template");

public void onEnable(){
Bukkit.getServer().createWorld(teest);
}

public VoidCreation(){
}}

