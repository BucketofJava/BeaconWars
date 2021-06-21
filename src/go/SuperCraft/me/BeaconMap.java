package go.SuperCraft.me; 
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
public class BeaconMap{
World World;
ArrayList<Location> poses= new ArrayList<Location>();
float Xdimension;
float Ydimension;
float Zdimension;
Location Corner;
public BeaconMap(World world, float xdimension, float ydimension, float zdimension, Location corner){
this.Xdimension=xdimension;
this.Ydimension=ydimension;
this.Zdimension=zdimension;
this.Corner=corner;
this.World=world;
for(int x=(int) corner.getX(); x<=xdimension+(int) corner.getX(); x++){
	//Bukkit.broadcastMessage(String.valueOf(x));
	for(int y=(int) corner.getY(); y<=ydimension+(int) corner.getY(); y++){
		//Bukkit.broadcastMessage(String.valueOf(y));
		for(int z=(int) corner.getZ(); z<=zdimension+(int) corner.getZ(); z++){
			//Bukkit.broadcastMessage(String.valueOf(z));
			if(x==xdimension+(int) corner.getX()&&y==ydimension+(int) corner.getY()&&z==zdimension+(int) corner.getZ()){
				Bukkit.broadcastMessage("Starting ending");
				Bukkit.broadcastMessage(String.valueOf(x));
				Bukkit.broadcastMessage(String.valueOf(y));
				Bukkit.broadcastMessage(String.valueOf(z));
				Bukkit.broadcastMessage(String.valueOf(poses.size()));
			}
			if((new Location(world, x, y, z).getBlock().getType())==Material.BEACON){
				Bukkit.broadcastMessage(String.valueOf(x));
				Bukkit.broadcastMessage(String.valueOf(z));
				poses.add(new Location(world, x, y, z));
			}
			
		}
		
	}	
	
}

}
public World getWorld(){
	
	return World;
}
public Location[] getPoses(){
	return this.poses.toArray(new Location[poses.size()]);
}
public float[] getdimensions(){
	float[] returnvalue={Xdimension, Ydimension, Zdimension};
	return returnvalue;
	
}
public Location getCorner(){
	return Corner;
}

}
