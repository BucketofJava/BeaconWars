package go.SuperCraft.me;
import java.lang.Math;
import java.text.DecimalFormat;
import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import go.SuperCraft.me.ImprovedNoise;
public class FloatingIsland {
public int change=1;

public FloatingIsland(){}
/*public ArrayList<double[]> drawCircle(int xc, int yc, int x, int y) 
{ 
    ArrayList<double[]> ar = null;
   for(int i=1;i>=x-1; i++){
	   
   } 
   double[] o={xc+x, yc+y};
   ar.add(1, o); 
   double[] op={xc-x, yc+y};
   ar.add(1, op);  
   double[] oc={xc+x, yc-y};
   ar.add(1, oc);  
   double[] od={xc-x, yc-y};
   ar.add(1, od);   
   double[] ov={xc+y, yc+x};
   ar.add(1, ov);   
   double[] ol={xc-y, yc+x};
   ar.add(1, ol);  
   double[] oi={xc+y, yc-x};
   ar.add(1, oi);  
   double[] oq={xc-y, yc-x};
   ar.add(1, oq);  
    return ar;
}
public ArrayList<double[]> circleBres(int xc, int yc, int rone, int rtwo) 
{ 
	
	int x = 0, y = rone; 
	int d = 3 - 2 * rone; 
	drawCircle(xc, yc, x, y); 
	while (y >= x) 
	{ 
		// for each pixel we will 
		// draw all eight pixels 
		
		x++; 

		// check for decision parameter 
		// and correspondingly 
		// update d, x, y 
		if (d > 0) 
		{ 
			y--; 
			d = d + 4 * (x - y) + 10; 
		} 
		else
			d = d + 4 * x + 6; 
		drawCircle(xc, yc, x, y);  
	} 
} */
public static int Curve(int xbase, int ybase, int x, int z){
	Bukkit.getServer().broadcastMessage(String.valueOf(x));
	Bukkit.getServer().broadcastMessage(String.valueOf(z));
	Bukkit.getServer().broadcastMessage(String.valueOf((((int) Math.pow((z),(x-xbase))+ybase))));
	
	return (((int) (z)^(x-xbase))+ybase);
}
static ArrayList<double[]> makellipse(float rx, float ry,  
        float xc, float yc, Player player) 
{ 
ArrayList<double[]> xidi = new ArrayList<double[]>();

float dx, dy, d1, d2, x, y; 
x = 0;
y = ry; 

// Initial decision parameter of region 1 
d1 = (ry * ry) - (rx * rx * ry) + 
    (0.25f * rx * rx); 
dx = 2 * ry * ry * x; 
dy = 2 * rx * rx * y; 
DecimalFormat df = new DecimalFormat("#,###,##0.00000"); 

// For region 1 
while (dx < dy) 
{ 
player.sendMessage("pm");
// Print points based on 4-way symmetry 
double[] o={(x + xc), (y + yc)}; 
xidi.add(o);
double[] ofd={(-x + xc), (y + yc)}; 
xidi.add(ofd);
double[] od={(x + xc), (-y + yc)}; 
xidi.add(od);
double[] oh={(-x + xc), (-y + yc)}; 
xidi.add(oh);
player.sendMessage(String.valueOf(xidi.size()));

// Checking and updating value of 
// decision parameter based on algorithm 
if (d1 < 0)  
{ 
x++; 
dx = dx + (2 * ry * ry); 
d1 = d1 + dx + (ry * ry); 
} 
else
{ 
x++; 
y--; 
dx = dx + (2 * ry * ry); 
dy = dy - (2 * rx * rx); 
d1 = d1 + dx - dy + (ry * ry); 
} 
} 

// Decision parameter of region 2 
d2 = ((ry * ry) * ((x + 0.5f) * (x + 0.5f))) 
+ ((rx * rx) * ((y - 1) * (y - 1))) 
- (rx * rx * ry * ry); 

// Plotting points of region 2 
while (y >= 0) { 

// printing points based on 4-way symmetry 
double[] o={(x + xc), (y + yc)}; 
xidi.add(o);
double[] ofd={(-x + xc), (y + yc)}; 
xidi.add(ofd);
double[] od={(x + xc), (-y + yc)}; 
xidi.add(od);
double[] oh={(-x + xc), (-y + yc)}; 
xidi.add(oh);

// Checking and updating parameter 
// value based on algorithm 
if (d2 > 0) { 
y--; 
dy = dy - (2 * rx * rx); 
d2 = d2 + (rx * rx) - dy; 
} 
else { 
y--; 
x++; 
dx = dx + (2 * ry * ry); 
dy = dy - (2 * rx * rx); 
d2 = d2 + dx - dy + (rx * rx); 
} 
} 
return xidi;
} 
public void GenerateIsland(Player player, int hr, int h, int vr, Boolean Above){
	//double[][] newpos=new double[(hr*2+1)*(vr*2+1)][2];
	Location startpos=player.getLocation();
	ArrayList<double[]> hooray=makellipse((float) hr, (float) vr, (float) startpos.getX(), (float) startpos.getZ(), player);
	player.sendMessage(String.valueOf(vr));
	player.sendMessage(String.valueOf(1<vr));
	for(int od=1; od<vr; od++){player.sendMessage("testing");}
	for(int id=0; id<vr; id++){
		player.sendMessage(String.valueOf(id));
		hooray.addAll(makellipse((float) hr, (float) vr-id, (float) startpos.getX(), (float) startpos.getZ(), player));
	}
	
	
	double[][] newpos=new double[hooray.size()][2];
	newpos=hooray.toArray(newpos);
	/*player.sendMessage(String.valueOf(newpos.length));
	double x=(int) startpos.getX()-hr;
	double z=(int) startpos.getZ()-vr; 
	player.sendMessage("Ummmmmmmm");
	for(int o=0; o<(hr*2+1)*(vr*2+1); o++){
		x++;
		if(x>startpos.getX()+hr){
			x=startpos.getX()-hr;
			z++;
	}
		double[] er={x,z};
		newpos[o]=er;}
	player.sendMessage(String.valueOf(newpos[0].length));
	player.sendMessage("First stage complete");*/
	
		
	int circleamount=5;
	
	
	Boolean go=true;
	if(startpos.getY()+h>256&&Above){
		player.sendMessage("You are too high to peform this action");
		go=false;
	}else if(startpos.getY()-h<0&&!Above){
		player.sendMessage("You are too low to perform this action");
		go=false;
	}
	player.sendMessage("second stage complete");
	if(go){
	for(int i=0; i<newpos.length; i++){
		player.getWorld().getBlockAt((int) newpos[i][0], (int) (startpos.getY()+h), (int) newpos[i][1]).setType(Material.STONE);
		for(int v=(int) Math.round(h*ImprovedNoise.Octaves(newpos[i][0], newpos[i][1], 0.0, 8, 1)); v>0; v--){
			player.getWorld().getBlockAt((int) newpos[i][0], (int) (startpos.getY()+h-(v)), (int) newpos[i][1]).setType(Material.STONE);
			System.out.println(i);
		}
		
	}
		
	}
}
}
