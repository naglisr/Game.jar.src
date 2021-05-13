 import java.applet.Applet;
 import java.awt.Checkbox;
 import java.awt.Color;
 import java.awt.Component;
 import java.awt.Cursor;
 import java.awt.Event;
 import java.awt.Font;
 import java.awt.FontMetrics;
 import java.awt.Graphics;
 import java.awt.Graphics2D;
 import java.awt.Image;
 import java.awt.LayoutManager;
 import java.awt.MediaTracker;
 import java.awt.RenderingHints;
 import java.awt.TextField;
 import java.awt.Toolkit;
 import java.io.BufferedReader;
 import java.io.BufferedWriter;
 import java.io.ByteArrayInputStream;
 import java.io.DataInputStream;
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileReader;
 import java.io.FileWriter;
 import java.util.zip.ZipEntry;
 import java.util.zip.ZipInputStream;
 import javax.swing.JOptionPane;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 public class StageMaker
   extends Applet
   implements Runnable
 {
   Graphics2D rd;
   Image offImage;
   Thread thredo;
   boolean exwist = false;
   FontMetrics ftm;
   int apx = 0; int apy = 0;
 
   
   String sstage = "";
   String suser = "Horaks";
 
   
   int tab = 0; int tabed = -1;
   Image[] btgame = new Image[2]; Image logo; boolean onbtgame = false, focuson = true, overcan = false; boolean left = false; boolean right = false;
   boolean up = false;
   boolean down = false;
   boolean zoomi = false;
   boolean zoomo = false;
   String stagename = "";
 
   
   String tstage = "snap(0,0,0)\r\nsky(191,215,255)\r\nclouds(255,255,255,5,-1000)\r\nfog(195,207,230)\r\nground(192,194,202)\r\ntexture(0,0,0,50)\r\nfadefrom(5000)\r\ndensity(5)\n\rmountains(" + (int)(Math.random() * 100000.0D) + ")\r\nnlaps(5)\r\n\r\n";
   String bstage = "set(47,0,0,0)\r\nmaxr(11,28500,-5600)\r\nmaxb(9,-8000,-12300)\r\nmaxl(11,-14700,-5600)\r\nmaxt(9,44800,-12300)\r\n";
   
   String[] undos = new String[5000];
   int nundo = 0;
   
   Medium m = new Medium();
   CheckPoints cp = new CheckPoints();
   Trackers t = new Trackers();
   ContO[] bco = new ContO[67];
   ContO[] co = new ContO[601];
   int nob = 0, xnob = 0;
   int errd = 0;
   int origfade = 5000;
 
   
   int sfase = 0;
   Smenu slstage = new Smenu(2000);
   TextField srch = new TextField("", 38);
   Smenu strtyp = new Smenu(40);
 
   
   Smenu ptyp = new Smenu(40);
   Smenu part = new Smenu(40);
   int sptyp = 0, spart = 0;
   int sp = 0; int lsp = -1; int seq = 0; boolean setcur = false; boolean epart = false;
   boolean arrng = false;
   int esp = -1; int hi = -1; int arrcnt = 0; int chi = -1;
   boolean seqn = false;
   int rot = 0; int adrot = 0;
   Image[] su = new Image[2];
   Image[] sl = new Image[2];
   Image[] sd = new Image[2];
   Image[] sr = new Image[2];
   Image[] zi = new Image[2];
   Image[] zo = new Image[2];
   
   boolean pgen = false;
   
   float pwd = (float)(2L + Math.round(Math.random() * 4.0D));
   float phd = (float)(2L + Math.round(Math.random() * 4.0D));
   int fgen = 0;
   
   int sx = 0; int sz = 1500; int sy = -10000;
   
   TextField fixh = new TextField("2000", 5);
   int hf = 2000;
   
   int[][] atp = new int[][] { { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 1520, 2830, -1520, -2830 }, { -1520, 2830, 1520, -2830 }, { 0, -1750, 1750, 0 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 0, -1750, 1750, 0 }, { 0, 2800, 0, -2800 }, { 0, -1750, 1750, 0 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 0, 560, 0, -560 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 385, 980, 385, -980 }, { 0, 0, 0, -600 }, { 0, 0, 0, 0 }, { 0, 2164, 0, -2164 }, { 0, 2164, 0, -2164 }, { 0, 3309, 0, -1680 }, { 0, 1680, 0, -3309 }, { 350, 0, -350, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1810, 980, 1810, -980 }, { 0, 0, 0, 0 }, { 0, 500, 0, -500 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 0, 1680, 0, -3309 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 0, 2800, 0, -2800 }, { 700, 1400, 700, -1400 }, { 0, -1480, 0, -1480 }, { 0, 0, 0, 0 }, { 350, 0, -350, 0 }, { 0, 0, 0, 0 }, { 700, 0, -700, 0 }, { 0, 0, 0, 0 }, { 0, -2198, 0, 1482 }, { 0, -1319, 0, 1391 }, { 0, -1894, 0, 2271 }, { 0, -826, 0, 839 }, { 0, -1400, 0, 1400 }, { 0, -1400, 0, 1400 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
   
   String[] discp = new String[] { "NormalRoad :  Basic asphalt road.\nAttaches correctly to the following other parts :\n\n'NormalRoad Turn',  'NormalRoad End',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',  'NormalRoad Edged',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "NormalRoad Edged :  Asphalt road with edged side blocks (a destructive road).\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "NormalRoad TwistedRight :  Asphalt road twisted towards the right.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad Twistedleft',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "NormalRoad TwistedLeft :  Asphalt road twisted towards the left.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "NormalRoad Turn :  Asphalt corner road turn.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp', 'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "OffRoad :  Basic sandy dirt-road.\nAttaches correctly to the following other parts :\n\n'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand  'Normal-Off-Road Blend'\n\n", "OffRoad BumpyGreen :  Dirt-road with bumpy greenery in the middle.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand  'Normal-Off-Road Blend'\n\n", "OffRoad Turn :  Dirt-road corner turn.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad End',  'OffRoad BumpyGreen',  ' OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand 'Normal-Off-Road Blend'\n\n", "HalfpipeRoad :  Basic road for the half-pipe ramp.\nAttaches correctly to the following other parts :\n\n'Off-Halfpipe-Road Blend',  'HalfpipeRoad',  'HalfpipeRoad Turn',  'HalfpipeRoad-Ramp Filler'\nand  'Halfpipe-Normal-Road Blend'\n\n", "HalfpipeRoad Turn :  Half-pipe corner road turn.\nAttaches correctly to the following other parts :\n\n'HalfpipeRoad',  'Off-Halfpipe-Road Blend',  'HalfpipeRoad'  and  'Halfpipe-Normal-Road Blend'\n\n", "Normal-Off-Road Blend :  Road blend between the normal asphalt road and the dirt-road.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'NormalRoad-Raised Ramp', 'Halfpipe-Normal-Road Blend' 'OffRoad',  'OffRoad Turn',\n'OffRoad End',  'OffRoad BumpyGreen',  ' OffRoad-BumpySides Start'  and  'Off-Halfpipe-Road Blend'\n\n", "Off-Halfpipe-Road Blend :  Road blend between the dirt-road and the half-pipe road.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start',\n'HalfpipeRoad',  'HalfpipeRoad Turn',  'Halfpipe-Normal-Road Blend'  and  'Normal-Off-Road Blend'\n\n", "Halfpipe-Normal-Road Blend :  Road blend between the normal asphalt road and the half-pipe road.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'NormalRoad-Raised Ramp',  'HalfpipeRoad',  'Off-Halfpipe-Road Blend',  'HalfpipeRoad'\nand  'Off-Halfpipe-Road Blend'\n\n", "NormalRoad End :  The end part of the normal asphalt road.\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad Edged',  'NormalRoad TwistedLeft',  'NormalRoad TwistedRight',\n'NormalRoad-Raised Ramp',  'Normal-Off-Road Blend'  and  'Halfpipe-Normal-Road Blend'\n\n", "OffRoad End :  The end part of the dirt-road.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad BumpyGreen',  ' OffRoad-BumpySides Start',  'Off-Halfpipe-Road Blend'\nand  'Normal-Off-Road Blend'\n\n", "HalfpipeRoad-Ramp Filler :  A part that gets placed between the half-pipe road and the half-pipe ramp to extend the distance in between.\nAttaches correctly to the following other parts :\n\n'HalfpipeRoad'  and  'Halfpipe'\n\n", "Basic Ramp :  Basic 30 degree asphalt ramp.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Crash Ramp :  A 35 degree ramp with big side blocks for crashing into.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Two-Way Ramp :  Two way 15 degree inclined ramp.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Two-Way High-Low Ramp :  Two way 15 degree inclined ramp, with peeked side for an optional higher car jump.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Landing Ramp :  A ramp that is both a landing inclination and an obstacle as well, it is usually placed just after another normal ramp.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand   'NormalRoad TwistedRight'\n\n", "Big-Takeoff Ramp:  A big takeoff ramp for getting huge heights with the cars.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand   'NormalRoad TwistedRight'\n\n", "Small Ramp :  A small ramp that can be placed on either side of the road.\nAttaches correctly over and to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand   'NormalRoad TwistedRight'\n\n", "Offroad Bump Ramp :  A small bump ramp that is to be placed over the off-road dirt tracks.\nAttaches correctly over and to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n", "Offroad Big Ramp :  The big off-road dirt mountain like ramp!\nAttaches correctly over and to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n", "Offroad Ramp :  Normal sized off-road dirt track ramp!\nAttaches correctly over and to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n", "Halfpipe :  The Half-pipe ramp, two of these ramps opposite each other create a half-pipe for the cars!\nAttaches correctly over and to the following other parts :\n\n'HalfpipeRoad',  'HalfpipeRoad Turn'  and  'HalfpipeRoad-Ramp Filler'\n\n", "Spiky Pillars :  An obstacle that is usually placed after a ramp for the cars to crash onto if they did not jump high or far enough!\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Rail Doorway :  A rail doorway that works as an obstacle for cars flying above it or cars driving through it!\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "The Wall", "Checkpoint :  The checkpoint part that ultimately decides how you stage is raced, place carefully with thought.\n(Any stage must have at least two checkpoints to work).\nMounts correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',\n'OffRoad-BumpySides Start',  'OffRoad-BumpySides',  'Rollercoaster Start/End'  and  'Rollercoaster Road 2,3,4 and 5'\n\n", "Fixing Hoop :  The fixing hoop that fixes a car when it flies through it! You can add a max of 5 fixing hoops per stage.\nPlace it anywhere in the stage at an height your choose, the only important thing is that it needs to be reachable by the cars.", "Checkpoint :  The checkpoint part that ultimately decides how you stage is raced, place carefully with thought.\n(Any stage must have at least two checkpoints to work).\nMounts correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',\n'OffRoad-BumpySides Start',  'OffRoad-BumpySides',  'Rollercoaster Start/End'  and  'Rollercoaster Road 2,3,4 and 5'\n\n", "OffRoad BumpySides :  Off-road dirt track with bumpy sandbar sides.\nAttaches correctly to the following other parts :\n\n'OffRoad-BumpySides Start'\n\n", "OffRoad-BumpySides Start: The start of the off-road dirt track with bumpy sandbar sides.\nAttaches correctly to the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides',\n'Off-Halfpipe-Road Blend'  and  'Normal-Off-Road Blend'\n\n", "NormalRoad-Raised Ramp:  The start of the raised above the ground road (NormalRoad Raised).\nAttaches correctly to the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight'  and  'NormalRoad Raised'\n\n", "NormalRoad Raised :  Normal road raised above the ground, cars must avoid falling off it when driving on it.\nAttaches correctly to the following other parts :\n\n'NormalRoad-Raised Ramp'\n\n", "The Start1", "The Start2", "Tunnel Side Ramp:  A ramp that can be used to create a tunnel like road with an open top or can be used as a wall ramp!\nAttaches correctly over only the 'NormalRoad' part.", "Launch Pad Ramp:  A ramp that launches your car fully upwards like a rocket, it also has sides to lock any car climbing it!\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "The Net:  An obstacle part that is to be placed in the center of the road right after a ramp, the idea is that the\ncars jumping the ramp should try to go over it or through it without getting caught crashing (without getting\ncaught in it, getting caught in the net!).\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Speed Ramp:  A ramp that is designed to have the perfect angle to catapult your car the furthest when doing forward loops, it is half the roads width.\nAttaches correctly over following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Offroad Hill Ramp:  An offroad hill ramp that has two different inclines from the front and back to jump.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n", "Bump Slide:  A small bump obstacle that is to be placed on the sides of the road or in the center.\nAttaches correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft'\nand  'NormalRoad TwistedRight'\n\n", "Offroad Big Hill Ramp:  An offroad big hill ramp that has two different inclines from the front and back to jump.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',  'OffRoad-BumpySides Start'\nand  'OffRoad-BumpySides'\n\n", "Rollercoaster Start/End:  The ramp that starts the Rollercoaster Road and ends it.\nAttaches correctly over and to following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n 'NormalRoad TwistedRight'  and  'Rollercoaster Start/End'\n\n", "Rollercoaster Road1\nAttaches correctly to only 'Rollercoaster Start/End', 'Rollercoaster Road2' and itself.\n\n", "Rollercoaster Road3\nAttaches correctly to only 'Rollercoaster Road2', 'Rollercoaster Road4' and itself.\n\n", "Rollercoaster Road4\nAttaches correctly to only 'Rollercoaster Road3', 'Rollercoaster Road5' and itself.\n\n", "Rollercoaster Road2\nAttaches correctly to only 'Rollercoaster Road1', 'Rollercoaster Road3' and itself.\n\n", "Rollercoaster Road5\nAttaches correctly to only 'Rollercoaster Road4' and itself.\n\n", "Offroad Dirt-Pile:  A dirt pile obstacle that is to be placed anywhere in the middle of the road.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad-BumpySides Start'  and  'OffRoad-BumpySides'\n\n", "Offroad Dirt-Pile:  A dirt pile obstacle that is to be placed anywhere in the middle of the road.\nAttaches correctly over the following other parts :\n\n'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad-BumpySides Start'  and  'OffRoad-BumpySides'\n\n", "Checkpoint :  The checkpoint part that ultimately decides how you stage is raced, place carefully with thought.\n(Any stage must have at least two checkpoints to work).\nMounts correctly over the following other parts :\n\n'NormalRoad',  'NormalRoad Turn',  'NormalRoad End',  'NormalRoad Edged',  'NormalRoad TwistedLeft',\n'NormalRoad TwistedRight',  'OffRoad',  'OffRoad Turn',  'OffRoad End',  'OffRoad BumpyGreen',\n'OffRoad-BumpySides Start',  'OffRoad-BumpySides',  'Rollercoaster Start/End'  and  'Rollercoaster Road 2,3,4 and 5'\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Trees/Cactus are decorative stage parts that should be placed outside the race track on the ground and NEVER on any road part or ramp!\nTrees/Cactus are not to be used as obstacles of the race course!\nThey are to be used as out of path ground decoration only.\n\n", "Ground Piles are to be paced outside the race track on the ground and NEVER on any road part or ramp!\nThey are to be used as ground decoration and out of race course obstacles (ground obstacles)!\n\n" };
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
   
   String[] errlo = new String[] { "The maximum allocated memory for the stage's part's details has been exerted.\nPlease decrease the amount of parts in the stage that have more details then average.", "The maximum amount of road points allowed in the track has been exceeded.\nPlease remove some of the road parts that are in the circler path of the track (the parts that are between the checkpoints).\nOr try to remove some of the extra checkpoints in the track as well.", "The maximum allowed area for a track (the area in between its walls) has been exceeded.\nPlease try to place parts only inside the current allowed area, inside the area between the current maximum wall placements.", "The maximum number of parts allowed per stage has been exceeded.\nPlease remove some of the already extra parts placed in order to make space.", "The maximum number of Fixing Hoops allowed per stage is 5!\nPlease remove the extra Fixing Hoops from your stage to have only 5 main ones left.", "Unknown Error, please make sure the stage you are handling is saved correctly.\nPlease go to the 'Build' tab and press 'Save & Preview'.", "There needs to be at least 2 checkpoints in the Stage in order for the game to work.\nPlease go to the 'Build' tab and select 'Checkpoint' in the Part Selection menu to add more checkpoints.", "The name of the stage is too long!\nPlease go to the 'Stage' tab, click 'Rename Stage' and give your stage a shorter name." };
 
 
 
 
 
 
 
 
 
 
   
   int[] rcheckp = new int[] { 0, 1, 2, 3, 4, 12, 13, 37 };
   int[] ocheckp = new int[] { 5, 6, 7, 11, 14, 33, 34, 38 }; boolean onoff = false;
   boolean onfly = false;
   int flyh = 0;
 
   
   int[] csky = new int[] { 170, 220, 255 };
   int[] cgrnd = new int[] { 205, 200, 200 };
   int[] cfade = new int[] { 255, 220, 220 };
   
   int[] texture = new int[] { 0, 0, 0, 10 };
   int[] cldd = new int[] { 210, 210, 210, 1, -1000 };
   TextField mgen = new TextField("", 10);
   
   int vxz = 0, vx = 0, vz = 0, vy = 0;
   int dtab = 0; int dtabed = -1; int mouseon = -1;
   float[][] hsb = new float[][] { { 0.5F, 0.875F, 0.5F }, { 0.5F, 0.875F, 0.5F }, { 0.5F, 0.875F, 0.5F } };
   Checkbox pfog = new Checkbox("Linked Blend");
   int[] snap = new int[] { 50, 50, 50 };
   int[] fogn = new int[] { 60, 0 };
   Smenu nlaps = new Smenu(40);
   
   Smenu tracks = new Smenu(2000);
   String trackname = ""; String ltrackname = "";
   int trackvol = 200; int tracksize = 111;
   RadicalMod track = new RadicalMod();
   int avon = 0;
   Smenu witho = new Smenu(40);
 
 
   
   int logged = 0;
   TextField tnick = new TextField("", 15);
   TextField tpass = new TextField("", 15);
   Smenu pubitem = new Smenu(707);
   Smenu pubtyp = new Smenu(40);
   int nms = 0; int roto = 0;
   String[] mystages = new String[20];
   String[] maker = new String[20];
   int[] pubt = new int[20];
   String[][] addeda = new String[20][5000];
   int[] nad = new int[20];
   String justpubd = "";
 
   
   boolean[] pessd = new boolean[] { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 
       false, false, false, false }; int[] bx = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   int[] by = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   int[] bw = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   int btn = 0;
   int mouses = 0, xm = 0, ym = 0;
   int lxm = 0; int lym = 0; int cntout = 0;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
   
   public void run() {
     // Byte code:
     //   0: aload_0
     //   1: getfield thredo : Ljava/lang/Thread;
     //   4: bipush #10
     //   6: invokevirtual setPriority : (I)V
     //   9: aload_0
     //   10: getfield btgame : [Ljava/awt/Image;
     //   13: iconst_0
     //   14: aload_0
     //   15: new java/lang/StringBuilder
     //   18: dup
     //   19: invokespecial <init> : ()V
     //   22: ldc ''
     //   24: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   27: getstatic Madness.fpath : Ljava/lang/String;
     //   30: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   33: ldc 'data/backtogame1.gif'
     //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   38: invokevirtual toString : ()Ljava/lang/String;
     //   41: invokevirtual getImage : (Ljava/lang/String;)Ljava/awt/Image;
     //   44: aastore
     //   45: aload_0
     //   46: getfield btgame : [Ljava/awt/Image;
     //   49: iconst_1
     //   50: aload_0
     //   51: new java/lang/StringBuilder
     //   54: dup
     //   55: invokespecial <init> : ()V
     //   58: ldc ''
     //   60: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   63: getstatic Madness.fpath : Ljava/lang/String;
     //   66: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   69: ldc 'data/backtogame2.gif'
     //   71: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   74: invokevirtual toString : ()Ljava/lang/String;
     //   77: invokevirtual getImage : (Ljava/lang/String;)Ljava/awt/Image;
     //   80: aastore
     //   81: aload_0
     //   82: aload_0
     //   83: new java/lang/StringBuilder
     //   86: dup
     //   87: invokespecial <init> : ()V
     //   90: ldc ''
     //   92: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   95: getstatic Madness.fpath : Ljava/lang/String;
     //   98: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   101: ldc 'data/stagemakerlogo.gif'
     //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   106: invokevirtual toString : ()Ljava/lang/String;
     //   109: invokevirtual getImage : (Ljava/lang/String;)Ljava/awt/Image;
     //   112: putfield logo : Ljava/awt/Image;
     //   115: iconst_0
     //   116: istore_1
     //   117: iload_1
     //   118: iconst_2
     //   119: if_icmplt -> 127
     //   122: goto_w -> 417
     //   127: aload_0
     //   128: getfield su : [Ljava/awt/Image;
     //   131: iload_1
     //   132: aload_0
     //   133: new java/lang/StringBuilder
     //   136: dup
     //   137: invokespecial <init> : ()V
     //   140: ldc ''
     //   142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   145: getstatic Madness.fpath : Ljava/lang/String;
     //   148: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   151: ldc 'data/su'
     //   153: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   156: iload_1
     //   157: iconst_1
     //   158: iadd
     //   159: invokevirtual append : (I)Ljava/lang/StringBuilder;
     //   162: ldc '.gif'
     //   164: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   167: invokevirtual toString : ()Ljava/lang/String;
     //   170: invokevirtual getImage : (Ljava/lang/String;)Ljava/awt/Image;
     //   173: aastore
     //   174: aload_0
     //   175: getfield sl : [Ljava/awt/Image;
     //   178: iload_1
     //   179: aload_0
     //   180: new java/lang/StringBuilder
     //   183: dup
     //   184: invokespecial <init> : ()V
     //   187: ldc ''
     //   189: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   192: getstatic Madness.fpath : Ljava/lang/String;
     //   195: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   198: ldc 'data/sl'
     //   200: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   203: iload_1
     //   204: iconst_1
     //   205: iadd
     //   206: invokevirtual append : (I)Ljava/lang/StringBuilder;
     //   209: ldc '.gif'
     //   211: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   214: invokevirtual toString : ()Ljava/lang/String;
     //   217: invokevirtual getImage : (Ljava/lang/String;)Ljava/awt/Image;
     //   220: aastore
     //   221: aload_0
     //   222: getfield sd : [Ljava/awt/Image;
     //   225: iload_1
     //   226: aload_0
     //   227: new java/lang/StringBuilder
     //   230: dup
     //   231: invokespecial <init> : ()V
     //   234: ldc ''
     //   236: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   239: getstatic Madness.fpath : Ljava/lang/String;
     //   242: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   245: ldc 'data/sd'
     //   247: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   250: iload_1
     //   251: iconst_1
     //   252: iadd
     //   253: invokevirtual append : (I)Ljava/lang/StringBuilder;
     //   256: ldc '.gif'
     //   258: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   261: invokevirtual toString : ()Ljava/lang/String;
     //   264: invokevirtual getImage : (Ljava/lang/String;)Ljava/awt/Image;
     //   267: aastore
     //   268: aload_0
     //   269: getfield sr : [Ljava/awt/Image;
     //   272: iload_1
     //   273: aload_0
     //   274: new java/lang/StringBuilder
     //   277: dup
     //   278: invokespecial <init> : ()V
     //   281: ldc ''
     //   283: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   286: getstatic Madness.fpath : Ljava/lang/String;
     //   289: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   292: ldc 'data/sr'
     //   294: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   297: iload_1
     //   298: iconst_1
     //   299: iadd
     //   300: invokevirtual append : (I)Ljava/lang/StringBuilder;
     //   303: ldc '.gif'
     //   305: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   308: invokevirtual toString : ()Ljava/lang/String;
     //   311: invokevirtual getImage : (Ljava/lang/String;)Ljava/awt/Image;
     //   314: aastore
     //   315: aload_0
     //   316: getfield zi : [Ljava/awt/Image;
     //   319: iload_1
     //   320: aload_0
     //   321: new java/lang/StringBuilder
     //   324: dup
     //   325: invokespecial <init> : ()V
     //   328: ldc ''
     //   330: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   333: getstatic Madness.fpath : Ljava/lang/String;
     //   336: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   339: ldc 'data/zi'
     //   341: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   344: iload_1
     //   345: iconst_1
     //   346: iadd
     //   347: invokevirtual append : (I)Ljava/lang/StringBuilder;
     //   350: ldc '.gif'
     //   352: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   355: invokevirtual toString : ()Ljava/lang/String;
     //   358: invokevirtual getImage : (Ljava/lang/String;)Ljava/awt/Image;
     //   361: aastore
     //   362: aload_0
     //   363: getfield zo : [Ljava/awt/Image;
     //   366: iload_1
     //   367: aload_0
     //   368: new java/lang/StringBuilder
     //   371: dup
     //   372: invokespecial <init> : ()V
     //   375: ldc ''
     //   377: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   380: getstatic Madness.fpath : Ljava/lang/String;
     //   383: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   386: ldc 'data/zo'
     //   388: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   391: iload_1
     //   392: iconst_1
     //   393: iadd
     //   394: invokevirtual append : (I)Ljava/lang/StringBuilder;
     //   397: ldc '.gif'
     //   399: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   402: invokevirtual toString : ()Ljava/lang/String;
     //   405: invokevirtual getImage : (Ljava/lang/String;)Ljava/awt/Image;
     //   408: aastore
     //   409: iinc #1, 1
     //   412: goto_w -> 117
     //   417: aload_0
     //   418: invokevirtual loadbase : ()V
     //   421: aload_0
     //   422: invokevirtual loadsettings : ()V
     //   425: getstatic Madness.testdrive : I
     //   428: ifne -> 436
     //   431: goto_w -> 545
     //   436: getstatic Madness.testcar : Ljava/lang/String;
     //   439: ldc 'Failx12'
     //   441: invokevirtual equals : (Ljava/lang/Object;)Z
     //   444: ifne -> 452
     //   447: goto_w -> 474
     //   452: aconst_null
     //   453: ldc 'Failed to load stage! Please make sure stage is saved properly before Test Drive.'
     //   455: ldc_w 'Stage Maker'
     //   458: iconst_1
     //   459: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
     //   462: aload_0
     //   463: getfield thredo : Ljava/lang/Thread;
     //   466: invokevirtual stop : ()V
     //   469: goto_w -> 531
     //   474: aload_0
     //   475: getstatic Madness.testcar : Ljava/lang/String;
     //   478: putfield stagename : Ljava/lang/String;
     //   481: aload_0
     //   482: iconst_0
     //   483: putfield errd : I
     //   486: aload_0
     //   487: iconst_3
     //   488: invokevirtual readstage : (I)V
     //   491: aload_0
     //   492: getfield errd : I
     //   495: ifeq -> 503
     //   498: goto_w -> 531
     //   503: aload_0
     //   504: iconst_2
     //   505: putfield tab : I
     //   508: aload_0
     //   509: bipush #6
     //   511: putfield dtab : I
     //   514: aload_0
     //   515: getfield witho : LSmenu;
     //   518: getstatic Madness.testdrive : I
     //   521: iconst_3
     //   522: isub
     //   523: invokevirtual select : (I)V
     //   526: goto_w -> 531
     //   531: ldc ''
     //   533: putstatic Madness.testcar : Ljava/lang/String;
     //   536: iconst_0
     //   537: putstatic Madness.testdrive : I
     //   540: goto_w -> 545
     //   545: aload_0
     //   546: invokevirtual requestFocus : ()V
     //   549: aload_0
     //   550: getfield exwist : Z
     //   553: ifeq -> 561
     //   556: goto_w -> 44523
     //   561: aload_0
     //   562: getfield rd : Ljava/awt/Graphics2D;
     //   565: new java/awt/Color
     //   568: dup
     //   569: sipush #225
     //   572: sipush #225
     //   575: sipush #225
     //   578: invokespecial <init> : (III)V
     //   581: invokevirtual setColor : (Ljava/awt/Color;)V
     //   584: aload_0
     //   585: getfield rd : Ljava/awt/Graphics2D;
     //   588: iconst_0
     //   589: bipush #25
     //   591: sipush #800
     //   594: sipush #525
     //   597: invokevirtual fillRect : (IIII)V
     //   600: aload_0
     //   601: getfield rd : Ljava/awt/Graphics2D;
     //   604: new java/awt/Color
     //   607: dup
     //   608: iconst_0
     //   609: iconst_0
     //   610: iconst_0
     //   611: invokespecial <init> : (III)V
     //   614: invokevirtual setColor : (Ljava/awt/Color;)V
     //   617: aload_0
     //   618: getfield tab : I
     //   621: aload_0
     //   622: getfield tabed : I
     //   625: if_icmpne -> 633
     //   628: goto_w -> 642
     //   633: aload_0
     //   634: invokevirtual hidefields : ()V
     //   637: goto_w -> 642
     //   642: aload_0
     //   643: getfield tab : I
     //   646: ifeq -> 654
     //   649: goto_w -> 3068
     //   654: aload_0
     //   655: getfield tabed : I
     //   658: aload_0
     //   659: getfield tab : I
     //   662: if_icmpne -> 670
     //   665: goto_w -> 946
     //   670: aload_0
     //   671: getfield slstage : LSmenu;
     //   674: invokevirtual removeAll : ()V
     //   677: aload_0
     //   678: getfield slstage : LSmenu;
     //   681: sipush #360
     //   684: putfield maxl : I
     //   687: aload_0
     //   688: getfield slstage : LSmenu;
     //   691: aload_0
     //   692: getfield rd : Ljava/awt/Graphics2D;
     //   695: ldc_w 'Select a Stage                      '
     //   698: invokevirtual add : (Ljava/awt/Graphics2D;Ljava/lang/String;)V
     //   701: new java/io/File
     //   704: dup
     //   705: new java/lang/StringBuilder
     //   708: dup
     //   709: invokespecial <init> : ()V
     //   712: ldc ''
     //   714: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   717: getstatic Madness.fpath : Ljava/lang/String;
     //   720: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   723: ldc_w 'mystages/'
     //   726: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   729: invokevirtual toString : ()Ljava/lang/String;
     //   732: invokespecial <init> : (Ljava/lang/String;)V
     //   735: invokevirtual list : ()[Ljava/lang/String;
     //   738: astore_1
     //   739: aload_1
     //   740: ifnonnull -> 748
     //   743: goto_w -> 825
     //   748: iconst_0
     //   749: istore_2
     //   750: iload_2
     //   751: aload_1
     //   752: arraylength
     //   753: if_icmplt -> 761
     //   756: goto_w -> 820
     //   761: aload_1
     //   762: iload_2
     //   763: aaload
     //   764: invokevirtual toLowerCase : ()Ljava/lang/String;
     //   767: ldc_w '.txt'
     //   770: invokevirtual endsWith : (Ljava/lang/String;)Z
     //   773: ifne -> 781
     //   776: goto_w -> 812
     //   781: aload_0
     //   782: getfield slstage : LSmenu;
     //   785: aload_0
     //   786: getfield rd : Ljava/awt/Graphics2D;
     //   789: aload_1
     //   790: iload_2
     //   791: aaload
     //   792: iconst_0
     //   793: aload_1
     //   794: iload_2
     //   795: aaload
     //   796: invokevirtual length : ()I
     //   799: iconst_4
     //   800: isub
     //   801: invokevirtual substring : (II)Ljava/lang/String;
     //   804: invokevirtual add : (Ljava/awt/Graphics2D;Ljava/lang/String;)V
     //   807: goto_w -> 812
     //   812: iinc #2, 1
     //   815: goto_w -> 750
     //   820: goto_w -> 825
     //   825: aload_0
     //   826: getfield stagename : Ljava/lang/String;
     //   829: ldc ''
     //   831: invokevirtual equals : (Ljava/lang/Object;)Z
     //   834: ifne -> 842
     //   837: goto_w -> 855
     //   842: aload_0
     //   843: getfield slstage : LSmenu;
     //   846: iconst_0
     //   847: invokevirtual select : (I)V
     //   850: goto_w -> 931
     //   855: aload_0
     //   856: getfield slstage : LSmenu;
     //   859: aload_0
     //   860: getfield stagename : Ljava/lang/String;
     //   863: invokevirtual select : (Ljava/lang/String;)V
     //   866: aload_0
     //   867: getfield stagename : Ljava/lang/String;
     //   870: aload_0
     //   871: getfield slstage : LSmenu;
     //   874: invokevirtual getSelectedItem : ()Ljava/lang/String;
     //   877: invokevirtual equals : (Ljava/lang/Object;)Z
     //   880: ifne -> 888
     //   883: goto_w -> 917
     //   888: aload_0
     //   889: iconst_3
     //   890: invokevirtual readstage : (I)V
     //   893: aload_0
     //   894: iconst_0
     //   895: putfield sx : I
     //   898: aload_0
     //   899: sipush #1500
     //   902: putfield sz : I
     //   905: aload_0
     //   906: sipush #-10000
     //   909: putfield sy : I
     //   912: goto_w -> 931
     //   917: aload_0
     //   918: ldc ''
     //   920: putfield stagename : Ljava/lang/String;
     //   923: aload_0
     //   924: getfield slstage : LSmenu;
     //   927: iconst_0
     //   928: invokevirtual select : (I)V
     //   931: aload_0
     //   932: iconst_m1
     //   933: putfield mouseon : I
     //   936: aload_0
     //   937: iconst_0
     //   938: putfield sfase : I
     //   941: goto_w -> 946
     //   946: aload_0
     //   947: getfield rd : Ljava/awt/Graphics2D;
     //   950: aload_0
     //   951: getfield logo : Ljava/awt/Image;
     //   954: sipush #261
     //   957: bipush #35
     //   959: aconst_null
     //   960: invokevirtual drawImage : (Ljava/awt/Image;IILjava/awt/image/ImageObserver;)Z
     //   963: pop
     //   964: aload_0
     //   965: getfield xm : I
     //   968: sipush #261
     //   971: if_icmpgt -> 979
     //   974: goto_w -> 1058
     //   979: aload_0
     //   980: getfield xm : I
     //   983: sipush #538
     //   986: if_icmplt -> 994
     //   989: goto_w -> 1058
     //   994: aload_0
     //   995: getfield ym : I
     //   998: bipush #35
     //   1000: if_icmpgt -> 1008
     //   1003: goto_w -> 1058
     //   1008: aload_0
     //   1009: getfield ym : I
     //   1012: bipush #121
     //   1014: if_icmplt -> 1022
     //   1017: goto_w -> 1058
     //   1022: aload_0
     //   1023: getfield mouseon : I
     //   1026: iconst_m1
     //   1027: if_icmpeq -> 1035
     //   1030: goto_w -> 1093
     //   1035: aload_0
     //   1036: iconst_3
     //   1037: putfield mouseon : I
     //   1040: aload_0
     //   1041: new java/awt/Cursor
     //   1044: dup
     //   1045: bipush #12
     //   1047: invokespecial <init> : (I)V
     //   1050: invokevirtual setCursor : (Ljava/awt/Cursor;)V
     //   1053: goto_w -> 1093
     //   1058: aload_0
     //   1059: getfield mouseon : I
     //   1062: iconst_3
     //   1063: if_icmpeq -> 1071
     //   1066: goto_w -> 1093
     //   1071: aload_0
     //   1072: iconst_m1
     //   1073: putfield mouseon : I
     //   1076: aload_0
     //   1077: new java/awt/Cursor
     //   1080: dup
     //   1081: iconst_0
     //   1082: invokespecial <init> : (I)V
     //   1085: invokevirtual setCursor : (Ljava/awt/Cursor;)V
     //   1088: goto_w -> 1093
     //   1093: aload_0
     //   1094: getfield mouseon : I
     //   1097: iconst_3
     //   1098: if_icmpeq -> 1106
     //   1101: goto_w -> 1128
     //   1106: aload_0
     //   1107: getfield mouses : I
     //   1110: iconst_m1
     //   1111: if_icmpeq -> 1119
     //   1114: goto_w -> 1128
     //   1119: aload_0
     //   1120: invokevirtual openhlink : ()V
     //   1123: goto_w -> 1128
     //   1128: aload_0
     //   1129: getfield rd : Ljava/awt/Graphics2D;
     //   1132: new java/awt/Font
     //   1135: dup
     //   1136: ldc_w 'Arial'
     //   1139: iconst_1
     //   1140: bipush #13
     //   1142: invokespecial <init> : (Ljava/lang/String;II)V
     //   1145: invokevirtual setFont : (Ljava/awt/Font;)V
     //   1148: aload_0
     //   1149: aload_0
     //   1150: getfield rd : Ljava/awt/Graphics2D;
     //   1153: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
     //   1156: putfield ftm : Ljava/awt/FontMetrics;
     //   1159: aload_0
     //   1160: getfield xm : I
     //   1163: sipush #200
     //   1166: if_icmpgt -> 1174
     //   1169: goto_w -> 1255
     //   1174: aload_0
     //   1175: getfield xm : I
     //   1178: sipush #550
     //   1181: if_icmplt -> 1189
     //   1184: goto_w -> 1255
     //   1189: aload_0
     //   1190: getfield ym : I
     //   1193: sipush #467
     //   1196: if_icmpgt -> 1204
     //   1199: goto_w -> 1255
     //   1204: aload_0
     //   1205: getfield ym : I
     //   1208: sipush #504
     //   1211: if_icmplt -> 1219
     //   1214: goto_w -> 1255
     //   1219: aload_0
     //   1220: getfield mouseon : I
     //   1223: iconst_m1
     //   1224: if_icmpeq -> 1232
     //   1227: goto_w -> 1290
     //   1232: aload_0
     //   1233: iconst_2
     //   1234: putfield mouseon : I
     //   1237: aload_0
     //   1238: new java/awt/Cursor
     //   1241: dup
     //   1242: bipush #12
     //   1244: invokespecial <init> : (I)V
     //   1247: invokevirtual setCursor : (Ljava/awt/Cursor;)V
     //   1250: goto_w -> 1290
     //   1255: aload_0
     //   1256: getfield mouseon : I
     //   1259: iconst_2
     //   1260: if_icmpeq -> 1268
     //   1263: goto_w -> 1290
     //   1268: aload_0
     //   1269: iconst_m1
     //   1270: putfield mouseon : I
     //   1273: aload_0
     //   1274: new java/awt/Cursor
     //   1277: dup
     //   1278: iconst_0
     //   1279: invokespecial <init> : (I)V
     //   1282: invokevirtual setCursor : (Ljava/awt/Cursor;)V
     //   1285: goto_w -> 1290
     //   1290: aload_0
     //   1291: getfield mouseon : I
     //   1294: iconst_2
     //   1295: if_icmpeq -> 1303
     //   1298: goto_w -> 1328
     //   1303: aload_0
     //   1304: getfield rd : Ljava/awt/Graphics2D;
     //   1307: new java/awt/Color
     //   1310: dup
     //   1311: iconst_0
     //   1312: bipush #64
     //   1314: sipush #128
     //   1317: invokespecial <init> : (III)V
     //   1320: invokevirtual setColor : (Ljava/awt/Color;)V
     //   1323: goto_w -> 1345
     //   1328: aload_0
     //   1329: getfield rd : Ljava/awt/Graphics2D;
     //   1332: new java/awt/Color
     //   1335: dup
     //   1336: iconst_0
     //   1337: iconst_0
     //   1338: iconst_0
     //   1339: invokespecial <init> : (III)V
     //   1342: invokevirtual setColor : (Ljava/awt/Color;)V
     //   1345: aload_0
     //   1346: getfield rd : Ljava/awt/Graphics2D;
     //   1349: ldc_w 'For the Stage Maker Homepage, Development Center and Forums :'
     //   1352: sipush #400
     //   1355: aload_0
     //   1356: getfield ftm : Ljava/awt/FontMetrics;
     //   1359: ldc_w 'For the Stage Maker Homepage, Development Center and Forums :'
     //   1362: invokevirtual stringWidth : (Ljava/lang/String;)I
     //   1365: iconst_2
     //   1366: idiv
     //   1367: isub
     //   1368: sipush #480
     //   1371: invokevirtual drawString : (Ljava/lang/String;II)V
     //   1374: aload_0
     //   1375: getfield rd : Ljava/awt/Graphics2D;
     //   1378: new java/awt/Color
     //   1381: dup
     //   1382: iconst_0
     //   1383: sipush #128
     //   1386: sipush #255
     //   1389: invokespecial <init> : (III)V
     //   1392: invokevirtual setColor : (Ljava/awt/Color;)V
     //   1395: ldc_w 'http://www.needformadness.com/developer/'
     //   1398: astore_1
     //   1399: aload_0
     //   1400: getfield rd : Ljava/awt/Graphics2D;
     //   1403: aload_1
     //   1404: sipush #400
     //   1407: aload_0
     //   1408: getfield ftm : Ljava/awt/FontMetrics;
     //   1411: aload_1
     //   1412: invokevirtual stringWidth : (Ljava/lang/String;)I
     //   1415: iconst_2
     //   1416: idiv
     //   1417: isub
     //   1418: sipush #500
     //   1421: invokevirtual drawString : (Ljava/lang/String;II)V
     //   1424: aload_0
     //   1425: getfield mouseon : I
     //   1428: iconst_2
     //   1429: if_icmpeq -> 1437
     //   1432: goto_w -> 1463
     //   1437: aload_0
     //   1438: getfield rd : Ljava/awt/Graphics2D;
     //   1441: new java/awt/Color
     //   1444: dup
     //   1445: iconst_0
     //   1446: sipush #128
     //   1449: sipush #255
     //   1452: invokespecial <init> : (III)V
     //   1455: invokevirtual setColor : (Ljava/awt/Color;)V
     //   1458: goto_w -> 1483
     //   1463: aload_0
     //   1464: getfield rd : Ljava/awt/Graphics2D;
     //   1467: new java/awt/Color
     //   1470: dup
     //   1471: iconst_0
     //   1472: bipush #64
     //   1474: sipush #128
     //   1477: invokespecial <init> : (III)V
     //   1480: invokevirtual setColor : (Ljava/awt/Color;)V
     //   1483: aload_0
     //   1484: getfield rd : Ljava/awt/Graphics2D;
     //   1487: sipush #400
     //   1490: aload_0
     //   1491: getfield ftm : Ljava/awt/FontMetrics;
     //   1494: aload_1
     //   1495: invokevirtual stringWidth : (Ljava/lang/String;)I
     //   1498: iconst_2
     //   1499: idiv
     //   1500: isub
     //   1501: sipush #501
     //   1504: sipush #400
     //   1507: aload_0
     //   1508: getfield ftm : Ljava/awt/FontMetrics;
     //   1511: aload_1
     //   1512: invokevirtual stringWidth : (Ljava/lang/String;)I
     //   1515: iconst_2
     //   1516: idiv
     //   1517: iadd
     //   1518: sipush #501
     //   1521: invokevirtual drawLine : (IIII)V
     //   1524: aload_0
     //   1525: getfield mouseon : I
     //   1528: iconst_2
     //   1529: if_icmpeq -> 1537
     //   1532: goto_w -> 1559
     //   1537: aload_0
     //   1538: getfield mouses : I
     //   1541: iconst_m1
     //   1542: if_icmpeq -> 1550
     //   1545: goto_w -> 1559
     //   1550: aload_0
     //   1551: invokevirtual openhlink : ()V
     //   1554: goto_w -> 1559
     //   1559: bipush #-110
     //   1561: istore_2
     //   1562: aload_0
     //   1563: getfield xm : I
     //   1566: sipush #150
     //   1569: if_icmpgt -> 1577
     //   1572: goto_w -> 1662
     //   1577: aload_0
     //   1578: getfield xm : I
     //   1581: sipush #600
     //   1584: if_icmplt -> 1592
     //   1587: goto_w -> 1662
     //   1592: aload_0
     //   1593: getfield ym : I
     //   1596: sipush #467
     //   1599: iload_2
     //   1600: iadd
     //   1601: if_icmpgt -> 1609
     //   1604: goto_w -> 1662
     //   1609: aload_0
     //   1610: getfield ym : I
     //   1613: sipush #504
     //   1616: iload_2
     //   1617: iadd
     //   1618: if_icmplt -> 1626
     //   1621: goto_w -> 1662
     //   1626: aload_0
     //   1627: getfield mouseon : I
     //   1630: iconst_m1
     //   1631: if_icmpeq -> 1639
     //   1634: goto_w -> 1697
     //   1639: aload_0
     //   1640: iconst_1
     //   1641: putfield mouseon : I
     //   1644: aload_0
     //   1645: new java/awt/Cursor
     //   1648: dup
     //   1649: bipush #12
     //   1651: invokespecial <init> : (I)V
     //   1654: invokevirtual setCursor : (Ljava/awt/Cursor;)V
     //   1657: goto_w -> 1697
     //   1662: aload_0
     //   1663: getfield mouseon : I
     //   1666: iconst_1
     //   1667: if_icmpeq -> 1675
     //   1670: goto_w -> 1697
     //   1675: aload_0
     //   1676: iconst_m1
     //   1677: putfield mouseon : I
     //   1680: aload_0
     //   1681: new java/awt/Cursor
     //   1684: dup
     //   1685: iconst_0
     //   1686: invokespecial <init> : (I)V
     //   1689: invokevirtual setCursor : (Ljava/awt/Cursor;)V
     //   1692: goto_w -> 1697
     //   1697: aload_0
     //   1698: getfield mouseon : I
     //   1701: iconst_1
     //   1702: if_icmpeq -> 1710
     //   1705: goto_w -> 1735
     //   1710: aload_0
     //   1711: getfield rd : Ljava/awt/Graphics2D;
     //   1714: new java/awt/Color
     //   1717: dup
     //   1718: iconst_0
     //   1719: bipush #64
     //   1721: sipush #128
     //   1724: invokespecial <init> : (III)V
     //   1727: invokevirtual setColor : (Ljava/awt/Color;)V
     //   1730: goto_w -> 1752
     //   1735: aload_0
     //   1736: getfield rd : Ljava/awt/Graphics2D;
     //   1739: new java/awt/Color
     //   1742: dup
     //   1743: iconst_0
     //   1744: iconst_0
     //   1745: iconst_0
     //   1746: invokespecial <init> : (III)V
     //   1749: invokevirtual setColor : (Ljava/awt/Color;)V
     //   1752: aload_0
     //   1753: getfield rd : Ljava/awt/Graphics2D;
     //   1756: ldc_w 'For help and a detailed step by step description on how to use the Stage Maker :'
     //   1759: sipush #400
     //   1762: aload_0
     //   1763: getfield ftm : Ljava/awt/FontMetrics;
     //   1766: ldc_w 'For help and a detailed step by step description on how to use the Stage Maker :'
     //   1769: invokevirtual stringWidth : (Ljava/lang/String;)I
     //   1772: iconst_2
     //   1773: idiv
     //   1774: isub
     //   1775: sipush #480
     //   1778: iload_2
     //   1779: iadd
     //   1780: invokevirtual drawString : (Ljava/lang/String;II)V
     //   1783: aload_0
     //   1784: getfield rd : Ljava/awt/Graphics2D;
     //   1787: new java/awt/Color
     //   1790: dup
     //   1791: iconst_0
     //   1792: sipush #128
     //   1795: sipush #255
     //   1798: invokespecial <init> : (III)V
     //   1801: invokevirtual setColor : (Ljava/awt/Color;)V
     //   1804: ldc_w 'http://www.needformadness.com/developer/help.html'
     //   1807: astore_1
     //   1808: aload_0
     //   1809: getfield rd : Ljava/awt/Graphics2D;
     //   1812: aload_1
     //   1813: sipush #400
     //   1816: aload_0
     //   1817: getfield ftm : Ljava/awt/FontMetrics;
     //   1820: aload_1
     //   1821: invokevirtual stringWidth : (Ljava/lang/String;)I
     //   1824: iconst_2
     //   1825: idiv
     //   1826: isub
     //   1827: sipush #500
     //   1830: iload_2
     //   1831: iadd
     //   1832: invokevirtual drawString : (Ljava/lang/String;II)V
     //   1835: aload_0
     //   1836: getfield mouseon : I
     //   1839: iconst_1
     //   1840: if_icmpeq -> 1848
     //   1843: goto_w -> 1874
     //   1848: aload_0
     //   1849: getfield rd : Ljava/awt/Graphics2D;
     //   1852: new java/awt/Color
     //   1855: dup
     //   1856: iconst_0
     //   1857: sipush #128
     //   1860: sipush #255
     //   1863: invokespecial <init> : (III)V
     //   1866: invokevirtual setColor : (Ljava/awt/Color;)V
     //   1869: goto_w -> 1894
     //   1874: aload_0
     //   1875: getfield rd : Ljava/awt/Graphics2D;
     //   1878: new java/awt/Color
     //   1881: dup
     //   1882: iconst_0
     //   1883: bipush #64
     //   1885: sipush #128
     //   1888: invokespecial <init> : (III)V
     //   1891: invokevirtual setColor : (Ljava/awt/Color;)V
     //   1894: aload_0
     //   1895: getfield rd : Ljava/awt/Graphics2D;
     //   1898: sipush #400
     //   1901: aload_0
     //   1902: getfield ftm : Ljava/awt/FontMetrics;
     //   1905: aload_1
     //   1906: invokevirtual stringWidth : (Ljava/lang/String;)I
     //   1909: iconst_2
     //   1910: idiv
     //   1911: isub
     //   1912: sipush #501
     //   1915: iload_2
     //   1916: iadd
     //   1917: sipush #400
     //   1920: aload_0
     //   1921: getfield ftm : Ljava/awt/FontMetrics;
     //   1924: aload_1
     //   1925: invokevirtual stringWidth : (Ljava/lang/String;)I
     //   1928: iconst_2
     //   1929: idiv
     //   1930: iadd
     //   1931: sipush #501
     //   1934: iload_2
     //   1935: iadd
     //   1936: invokevirtual drawLine : (IIII)V
     //   1939: aload_0
     //   1940: getfield mouseon : I
     //   1943: iconst_1
     //   1944: if_icmpeq -> 1952
     //   1947: goto_w -> 1974
     //   1952: aload_0
     //   1953: getfield mouses : I
     //   1956: iconst_m1
     //   1957: if_icmpeq -> 1965
     //   1960: goto_w -> 1974
     //   1965: aload_0
     //   1966: invokevirtual openlink : ()V
     //   1969: goto_w -> 1974
     //   1974: bipush #-60
     //   1976: istore_3
     //   1977: bipush #70
     //   1979: istore #4
     //   1981: aload_0
     //   1982: getfield rd : Ljava/awt/Graphics2D;
     //   1985: new java/awt/Color
     //   1988: dup
     //   1989: iconst_0
     //   1990: iconst_0
     //   1991: iconst_0
     //   1992: invokespecial <init> : (III)V
     //   1995: invokevirtual setColor : (Ljava/awt/Color;)V
     //   1998: aload_0
     //   1999: getfield rd : Ljava/awt/Graphics2D;
     //   2002: sipush #227
     //   2005: iload #4
     //   2007: isub
     //   2008: sipush #194
     //   2011: iload_3
     //   2012: iadd
     //   2013: sipush #346
     //   2016: iload #4
     //   2018: iconst_2
     //   2019: imul
     //   2020: iadd
     //   2021: sipush #167
     //   2024: iload #4
     //   2026: iconst_5
     //   2027: idiv
     //   2028: iadd
     //   2029: invokevirtual drawRect : (IIII)V
     //   2032: aload_0
     //   2033: getfield sfase : I
     //   2036: ifeq -> 2044
     //   2039: goto_w -> 2497
     //   2044: aload_0
     //   2045: getfield rd : Ljava/awt/Graphics2D;
     //   2048: ldc_w 'Select Stage to Edit'
     //   2051: sipush #400
     //   2054: aload_0
     //   2055: getfield ftm : Ljava/awt/FontMetrics;
     //   2058: ldc_w 'Select Stage to Edit'
     //   2061: invokevirtual stringWidth : (Ljava/lang/String;)I
     //   2064: iconst_2
     //   2065: idiv
     //   2066: isub
     //   2067: sipush #230
     //   2070: iload_3
     //   2071: iadd
     //   2072: invokevirtual drawString : (Ljava/lang/String;II)V
     //   2075: aload_0
     //   2076: getfield slstage : LSmenu;
     //   2079: sipush #220
     //   2082: sipush #240
     //   2085: iload_3
     //   2086: iadd
     //   2087: invokevirtual move : (II)V
     //   2090: aload_0
     //   2091: getfield slstage : LSmenu;
     //   2094: invokevirtual getWidth : ()I
     //   2097: sipush #360
     //   2100: if_icmpne -> 2108
     //   2103: goto_w -> 2125
     //   2108: aload_0
     //   2109: getfield slstage : LSmenu;
     //   2112: sipush #360
     //   2115: bipush #21
     //   2117: invokevirtual setSize : (II)V
     //   2120: goto_w -> 2125
     //   2125: aload_0
     //   2126: getfield slstage : LSmenu;
     //   2129: invokevirtual isShowing : ()Z
     //   2132: ifeq -> 2140
     //   2135: goto_w -> 2152
     //   2140: aload_0
     //   2141: getfield slstage : LSmenu;
     //   2144: invokevirtual show : ()V
     //   2147: goto_w -> 2152
     //   2152: aload_0
     //   2153: ldc_w '    Make new Stage    '
     //   2156: sipush #400
     //   2159: sipush #296
     //   2162: iload_3
     //   2163: iadd
     //   2164: iconst_0
     //   2165: iconst_1
     //   2166: invokevirtual button : (Ljava/lang/String;IIIZ)Z
     //   2169: ifne -> 2177
     //   2172: goto_w -> 2203
     //   2177: aload_0
     //   2178: getfield srch : Ljava/awt/TextField;
     //   2181: ldc ''
     //   2183: invokevirtual setText : (Ljava/lang/String;)V
     //   2186: aload_0
     //   2187: getfield slstage : LSmenu;
     //   2190: invokevirtual hide : ()V
     //   2193: aload_0
     //   2194: iconst_1
     //   2195: putfield sfase : I
     //   2198: goto_w -> 2203
     //   2203: aload_0
     //   2204: ldc_w '     Rename Stage     '
     //   2207: sipush #325
     //   2210: sipush #336
     //   2213: iload_3
     //   2214: iadd
     //   2215: iconst_0
     //   2216: iconst_0
     //   2217: invokevirtual button : (Ljava/lang/String;IIIZ)Z
     //   2220: ifne -> 2228
     //   2223: goto_w -> 2289
     //   2228: aload_0
     //   2229: getfield stagename : Ljava/lang/String;
     //   2232: ldc ''
     //   2234: invokevirtual equals : (Ljava/lang/Object;)Z
     //   2237: ifeq -> 2245
     //   2240: goto_w -> 2273
     //   2245: aload_0
     //   2246: getfield slstage : LSmenu;
     //   2249: invokevirtual hide : ()V
     //   2252: aload_0
     //   2253: getfield srch : Ljava/awt/TextField;
     //   2256: aload_0
     //   2257: getfield stagename : Ljava/lang/String;
     //   2260: invokevirtual setText : (Ljava/lang/String;)V
     //   2263: aload_0
     //   2264: iconst_2
     //   2265: putfield sfase : I
     //   2268: goto_w -> 2289
     //   2273: aconst_null
     //   2274: ldc_w 'Please select a stage to rename first.'
     //   2277: ldc_w 'Stage Maker'
     //   2280: iconst_1
     //   2281: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
     //   2284: goto_w -> 2289
     //   2289: aload_0
     //   2290: ldc_w '      Delete Stage      '
     //   2293: sipush #475
     //   2296: sipush #336
     //   2299: iload_3
     //   2300: iadd
     //   2301: iconst_0
     //   2302: iconst_0
     //   2303: invokevirtual button : (Ljava/lang/String;IIIZ)Z
     //   2306: ifne -> 2314
     //   2309: goto_w -> 2405
     //   2314: aload_0
     //   2315: getfield stagename : Ljava/lang/String;
     //   2318: ldc ''
     //   2320: invokevirtual equals : (Ljava/lang/Object;)Z
     //   2323: ifeq -> 2331
     //   2326: goto_w -> 2389
     //   2331: aconst_null
     //   2332: new java/lang/StringBuilder
     //   2335: dup
     //   2336: invokespecial <init> : ()V
     //   2339: ldc_w 'Are you sure you want to permanently delete this stage?\\n\\n'
     //   2342: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   2345: aload_0
     //   2346: getfield stagename : Ljava/lang/String;
     //   2349: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   2352: ldc_w '\\n\\n'
     //   2355: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   2358: invokevirtual toString : ()Ljava/lang/String;
     //   2361: ldc_w 'Stage Maker'
     //   2364: iconst_0
     //   2365: invokestatic showConfirmDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)I
     //   2368: ifeq -> 2376
     //   2371: goto_w -> 2405
     //   2376: aload_0
     //   2377: aload_0
     //   2378: getfield stagename : Ljava/lang/String;
     //   2381: invokevirtual delstage : (Ljava/lang/String;)V
     //   2384: goto_w -> 2405
     //   2389: aconst_null
     //   2390: ldc_w 'Please select a stage to delete first.'
     //   2393: ldc_w 'Stage Maker'
     //   2396: iconst_1
     //   2397: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
     //   2400: goto_w -> 2405
     //   2405: aload_0
     //   2406: getfield slstage : LSmenu;
     //   2409: invokevirtual getSelectedIndex : ()I
     //   2412: ifne -> 2420
     //   2415: goto_w -> 2486
     //   2420: aload_0
     //   2421: getfield stagename : Ljava/lang/String;
     //   2424: aload_0
     //   2425: getfield slstage : LSmenu;
     //   2428: invokevirtual getSelectedItem : ()Ljava/lang/String;
     //   2431: invokevirtual equals : (Ljava/lang/Object;)Z
     //   2434: ifeq -> 2442
     //   2437: goto_w -> 2497
     //   2442: aload_0
     //   2443: aload_0
     //   2444: getfield slstage : LSmenu;
     //   2447: invokevirtual getSelectedItem : ()Ljava/lang/String;
     //   2450: putfield stagename : Ljava/lang/String;
     //   2453: aload_0
     //   2454: iconst_3
     //   2455: invokevirtual readstage : (I)V
     //   2458: aload_0
     //   2459: iconst_0
     //   2460: putfield sx : I
     //   2463: aload_0
     //   2464: sipush #1500
     //   2467: putfield sz : I
     //   2470: aload_0
     //   2471: sipush #-10000
     //   2474: putfield sy : I
     //   2477: aload_0
     //   2478: invokevirtual requestFocus : ()V
     //   2481: goto_w -> 2497
     //   2486: aload_0
     //   2487: ldc ''
     //   2489: putfield stagename : Ljava/lang/String;
     //   2492: goto_w -> 2497
     //   2497: aload_0
     //   2498: getfield sfase : I
     //   2501: iconst_1
     //   2502: if_icmpeq -> 2510
     //   2505: goto_w -> 2785
     //   2510: aload_0
     //   2511: getfield rd : Ljava/awt/Graphics2D;
     //   2514: ldc_w 'Make a new Stage'
     //   2517: sipush #400
     //   2520: aload_0
     //   2521: getfield ftm : Ljava/awt/FontMetrics;
     //   2524: ldc_w 'Make a new Stage'
     //   2527: invokevirtual stringWidth : (Ljava/lang/String;)I
     //   2530: iconst_2
     //   2531: idiv
     //   2532: isub
     //   2533: sipush #220
     //   2536: iload_3
     //   2537: iadd
     //   2538: invokevirtual drawString : (Ljava/lang/String;II)V
     //   2541: aload_0
     //   2542: getfield rd : Ljava/awt/Graphics2D;
     //   2545: new java/awt/Font
     //   2548: dup
     //   2549: ldc_w 'Arial'
     //   2552: iconst_1
     //   2553: bipush #12
     //   2555: invokespecial <init> : (Ljava/lang/String;II)V
     //   2558: invokevirtual setFont : (Ljava/awt/Font;)V
     //   2561: aload_0
     //   2562: getfield rd : Ljava/awt/Graphics2D;
     //   2565: ldc_w 'New stage name :'
     //   2568: sipush #200
     //   2571: sipush #246
     //   2574: iload_3
     //   2575: iadd
     //   2576: invokevirtual drawString : (Ljava/lang/String;II)V
     //   2579: aload_0
     //   2580: aload_0
     //   2581: getfield srch : Ljava/awt/TextField;
     //   2584: sipush #310
     //   2587: sipush #231
     //   2590: iload_3
     //   2591: iadd
     //   2592: sipush #290
     //   2595: bipush #23
     //   2597: invokevirtual movefield : (Ljava/awt/Component;IIII)V
     //   2600: aload_0
     //   2601: getfield srch : Ljava/awt/TextField;
     //   2604: invokevirtual isShowing : ()Z
     //   2607: ifeq -> 2615
     //   2610: goto_w -> 2634
     //   2615: aload_0
     //   2616: getfield srch : Ljava/awt/TextField;
     //   2619: invokevirtual show : ()V
     //   2622: aload_0
     //   2623: getfield srch : Ljava/awt/TextField;
     //   2626: invokevirtual requestFocus : ()V
     //   2629: goto_w -> 2634
     //   2634: aload_0
     //   2635: aload_0
     //   2636: getfield srch : Ljava/awt/TextField;
     //   2639: invokevirtual fixtext : (Ljava/awt/TextField;)V
     //   2642: aload_0
     //   2643: getfield rd : Ljava/awt/Graphics2D;
     //   2646: ldc_w 'Starting line type :'
     //   2649: sipush #293
     //   2652: sipush #272
     //   2655: iload_3
     //   2656: iadd
     //   2657: invokevirtual drawString : (Ljava/lang/String;II)V
     //   2660: aload_0
     //   2661: getfield strtyp : LSmenu;
     //   2664: sipush #408
     //   2667: sipush #256
     //   2670: iload_3
     //   2671: iadd
     //   2672: invokevirtual move : (II)V
     //   2675: aload_0
     //   2676: getfield strtyp : LSmenu;
     //   2679: invokevirtual isShowing : ()Z
     //   2682: ifeq -> 2690
     //   2685: goto_w -> 2702
     //   2690: aload_0
     //   2691: getfield strtyp : LSmenu;
     //   2694: invokevirtual show : ()V
     //   2697: goto_w -> 2702
     //   2702: aload_0
     //   2703: ldc_w '    Make Stage    '
     //   2706: sipush #400
     //   2709: sipush #311
     //   2712: iload_3
     //   2713: iadd
     //   2714: iconst_0
     //   2715: iconst_1
     //   2716: invokevirtual button : (Ljava/lang/String;IIIZ)Z
     //   2719: ifne -> 2727
     //   2722: goto_w -> 2736
     //   2727: aload_0
     //   2728: invokevirtual newstage : ()V
     //   2731: goto_w -> 2736
     //   2736: aload_0
     //   2737: ldc_w '  Cancel  '
     //   2740: sipush #400
     //   2743: sipush #351
     //   2746: iload_3
     //   2747: iadd
     //   2748: iconst_0
     //   2749: iconst_0
     //   2750: invokevirtual button : (Ljava/lang/String;IIIZ)Z
     //   2753: ifne -> 2761
     //   2756: goto_w -> 2785
     //   2761: aload_0
     //   2762: getfield strtyp : LSmenu;
     //   2765: invokevirtual hide : ()V
     //   2768: aload_0
     //   2769: getfield srch : Ljava/awt/TextField;
     //   2772: invokevirtual hide : ()V
     //   2775: aload_0
     //   2776: iconst_0
     //   2777: putfield sfase : I
     //   2780: goto_w -> 2785
     //   2785: aload_0
     //   2786: getfield sfase : I
     //   2789: iconst_2
     //   2790: if_icmpeq -> 2798
     //   2793: goto_w -> 3063
     //   2798: aload_0
     //   2799: getfield rd : Ljava/awt/Graphics2D;
     //   2802: new java/lang/StringBuilder
     //   2805: dup
     //   2806: invokespecial <init> : ()V
     //   2809: ldc_w 'Rename Stage :  '
     //   2812: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   2815: aload_0
     //   2816: getfield stagename : Ljava/lang/String;
     //   2819: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   2822: ldc ''
     //   2824: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   2827: invokevirtual toString : ()Ljava/lang/String;
     //   2830: sipush #400
     //   2833: aload_0
     //   2834: getfield ftm : Ljava/awt/FontMetrics;
     //   2837: new java/lang/StringBuilder
     //   2840: dup
     //   2841: invokespecial <init> : ()V
     //   2844: ldc_w 'Rename Stage :  '
     //   2847: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   2850: aload_0
     //   2851: getfield stagename : Ljava/lang/String;
     //   2854: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   2857: ldc ''
     //   2859: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   2862: invokevirtual toString : ()Ljava/lang/String;
     //   2865: invokevirtual stringWidth : (Ljava/lang/String;)I
     //   2868: iconst_2
     //   2869: idiv
     //   2870: isub
     //   2871: sipush #230
     //   2874: iload_3
     //   2875: iadd
     //   2876: invokevirtual drawString : (Ljava/lang/String;II)V
     //   2879: aload_0
     //   2880: getfield rd : Ljava/awt/Graphics2D;
     //   2883: new java/awt/Font
     //   2886: dup
     //   2887: ldc_w 'Arial'
     //   2890: iconst_1
     //   2891: bipush #12
     //   2893: invokespecial <init> : (Ljava/lang/String;II)V
     //   2896: invokevirtual setFont : (Ljava/awt/Font;)V
     //   2899: aload_0
     //   2900: getfield rd : Ljava/awt/Graphics2D;
     //   2903: ldc_w 'New name :'
     //   2906: sipush #218
     //   2909: sipush #266
     //   2912: iload_3
     //   2913: iadd
     //   2914: invokevirtual drawString : (Ljava/lang/String;II)V
     //   2917: aload_0
     //   2918: getfield srch : Ljava/awt/TextField;
     //   2921: invokevirtual isShowing : ()Z
     //   2924: ifeq -> 2932
     //   2927: goto_w -> 2951
     //   2932: aload_0
     //   2933: getfield srch : Ljava/awt/TextField;
     //   2936: invokevirtual show : ()V
     //   2939: aload_0
     //   2940: getfield srch : Ljava/awt/TextField;
     //   2943: invokevirtual requestFocus : ()V
     //   2946: goto_w -> 2951
     //   2951: aload_0
     //   2952: aload_0
     //   2953: getfield srch : Ljava/awt/TextField;
     //   2956: sipush #292
     //   2959: sipush #251
     //   2962: iload_3
     //   2963: iadd
     //   2964: sipush #290
     //   2967: bipush #23
     //   2969: invokevirtual movefield : (Ljava/awt/Component;IIII)V
     //   2972: aload_0
     //   2973: aload_0
     //   2974: getfield srch : Ljava/awt/TextField;
     //   2977: invokevirtual fixtext : (Ljava/awt/TextField;)V
     //   2980: aload_0
     //   2981: ldc_w '    Rename Stage    '
     //   2984: sipush #400
     //   2987: sipush #306
     //   2990: iload_3
     //   2991: iadd
     //   2992: iconst_0
     //   2993: iconst_1
     //   2994: invokevirtual button : (Ljava/lang/String;IIIZ)Z
     //   2997: ifne -> 3005
     //   3000: goto_w -> 3021
     //   3005: aload_0
     //   3006: aload_0
     //   3007: getfield srch : Ljava/awt/TextField;
     //   3010: invokevirtual getText : ()Ljava/lang/String;
     //   3013: invokevirtual renstage : (Ljava/lang/String;)V
     //   3016: goto_w -> 3021
     //   3021: aload_0
     //   3022: ldc_w '  Cancel  '
     //   3025: sipush #400
     //   3028: sipush #346
     //   3031: iload_3
     //   3032: iadd
     //   3033: iconst_0
     //   3034: iconst_0
     //   3035: invokevirtual button : (Ljava/lang/String;IIIZ)Z
     //   3038: ifne -> 3046
     //   3041: goto_w -> 3063
     //   3046: aload_0
     //   3047: getfield srch : Ljava/awt/TextField;
     //   3050: invokevirtual hide : ()V
     //   3053: aload_0
     //   3054: iconst_0
     //   3055: putfield sfase : I
     //   3058: goto_w -> 3063
     //   3063: goto_w -> 3068
     //   3068: aload_0
     //   3069: getfield tab : I
     //   3072: iconst_1
     //   3073: if_icmpeq -> 3081
     //   3076: goto_w -> 21893
     //   3081: aload_0
     //   3082: getfield tabed : I
     //   3085: aload_0
     //   3086: getfield tab : I
     //   3089: if_icmpne -> 3097
     //   3092: goto_w -> 3297
     //   3097: aload_0
     //   3098: getfield m : LMedium;
     //   3101: iconst_2
     //   3102: putfield trk : I
     //   3105: aload_0
     //   3106: iconst_0
     //   3107: invokevirtual readstage : (I)V
     //   3110: aload_0
     //   3111: getfield sptyp : I
     //   3114: ifeq -> 3122
     //   3117: goto_w -> 3131
     //   3122: aload_0
     //   3123: invokevirtual partroads : ()V
     //   3126: goto_w -> 3131
     //   3131: aload_0
     //   3132: getfield sptyp : I
     //   3135: iconst_1
     //   3136: if_icmpeq -> 3144
     //   3139: goto_w -> 3153
     //   3144: aload_0
     //   3145: invokevirtual partramps : ()V
     //   3148: goto_w -> 3153
     //   3153: aload_0
     //   3154: getfield sptyp : I
     //   3157: iconst_2
     //   3158: if_icmpeq -> 3166
     //   3161: goto_w -> 3175
     //   3166: aload_0
     //   3167: invokevirtual partobst : ()V
     //   3170: goto_w -> 3175
     //   3175: aload_0
     //   3176: getfield sptyp : I
     //   3179: iconst_5
     //   3180: if_icmpeq -> 3188
     //   3183: goto_w -> 3197
     //   3188: aload_0
     //   3189: invokevirtual partrees : ()V
     //   3192: goto_w -> 3197
     //   3197: aload_0
     //   3198: iconst_0
     //   3199: putfield onoff : Z
     //   3202: aload_0
     //   3203: new java/awt/Cursor
     //   3206: dup
     //   3207: iconst_0
     //   3208: invokespecial <init> : (I)V
     //   3211: invokevirtual setCursor : (Ljava/awt/Cursor;)V
     //   3214: aload_0
     //   3215: iconst_0
     //   3216: putfield setcur : Z
     //   3219: aload_0
     //   3220: iconst_0
     //   3221: putfield epart : Z
     //   3224: aload_0
     //   3225: iconst_0
     //   3226: putfield arrng : Z
     //   3229: aload_0
     //   3230: getfield nob : I
     //   3233: iconst_1
     //   3234: if_icmpeq -> 3242
     //   3237: goto_w -> 3287
     //   3242: aload_0
     //   3243: iconst_0
     //   3244: putfield sptyp : I
     //   3247: aload_0
     //   3248: getfield co : [LContO;
     //   3251: iconst_0
     //   3252: aaload
     //   3253: getfield colok : I
     //   3256: bipush #38
     //   3258: if_icmpeq -> 3266
     //   3261: goto_w -> 3277
     //   3266: aload_0
     //   3267: bipush #9
     //   3269: putfield spart : I
     //   3272: goto_w -> 3287
     //   3277: aload_0
     //   3278: iconst_0
     //   3279: putfield spart : I
     //   3282: goto_w -> 3287
     //   3287: aload_0
     //   3288: iconst_m1
     //   3289: putfield mouseon : I
     //   3292: goto_w -> 3297
     //   3297: aload_0
     //   3298: getfield sptyp : I
     //   3301: ifeq -> 3309
     //   3304: goto_w -> 3946
     //   3309: aload_0
     //   3310: getfield spart : I
     //   3313: ifeq -> 3321
     //   3316: goto_w -> 3331
     //   3321: aload_0
     //   3322: iconst_0
     //   3323: putfield sp : I
     //   3326: goto_w -> 3331
     //   3331: aload_0
     //   3332: getfield spart : I
     //   3335: iconst_1
     //   3336: if_icmpeq -> 3344
     //   3339: goto_w -> 3354
     //   3344: aload_0
     //   3345: iconst_4
     //   3346: putfield sp : I
     //   3349: goto_w -> 3354
     //   3354: aload_0
     //   3355: getfield spart : I
     //   3358: iconst_2
     //   3359: if_icmpeq -> 3367
     //   3362: goto_w -> 3378
     //   3367: aload_0
     //   3368: bipush #13
     //   3370: putfield sp : I
     //   3373: goto_w -> 3378
     //   3378: aload_0
     //   3379: getfield spart : I
     //   3382: iconst_3
     //   3383: if_icmpeq -> 3391
     //   3386: goto_w -> 3401
     //   3391: aload_0
     //   3392: iconst_3
     //   3393: putfield sp : I
     //   3396: goto_w -> 3401
     //   3401: aload_0
     //   3402: getfield spart : I
     //   3405: iconst_4
     //   3406: if_icmpeq -> 3414
     //   3409: goto_w -> 3424
     //   3414: aload_0
     //   3415: iconst_2
     //   3416: putfield sp : I
     //   3419: goto_w -> 3424
     //   3424: aload_0
     //   3425: getfield spart : I
     //   3428: iconst_5
     //   3429: if_icmpeq -> 3437
     //   3432: goto_w -> 3447
     //   3437: aload_0
     //   3438: iconst_1
     //   3439: putfield sp : I
     //   3442: goto_w -> 3447
     //   3447: aload_0
     //   3448: getfield spart : I
     //   3451: bipush #6
     //   3453: if_icmpeq -> 3461
     //   3456: goto_w -> 3472
     //   3461: aload_0
     //   3462: bipush #35
     //   3464: putfield sp : I
     //   3467: goto_w -> 3472
     //   3472: aload_0
     //   3473: getfield spart : I
     //   3476: bipush #7
     //   3478: if_icmpeq -> 3486
     //   3481: goto_w -> 3497
     //   3486: aload_0
     //   3487: bipush #36
     //   3489: putfield sp : I
     //   3492: goto_w -> 3497
     //   3497: aload_0
     //   3498: getfield spart : I
     //   3501: bipush #8
     //   3503: if_icmpeq -> 3511
     //   3506: goto_w -> 3522
     //   3511: aload_0
     //   3512: bipush #10
     //   3514: putfield sp : I
     //   3517: goto_w -> 3522
     //   3522: aload_0
     //   3523: getfield spart : I
     //   3526: bipush #9
     //   3528: if_icmpeq -> 3536
     //   3531: goto_w -> 3546
     //   3536: aload_0
     //   3537: iconst_5
     //   3538: putfield sp : I
     //   3541: goto_w -> 3546
     //   3546: aload_0
     //   3547: getfield spart : I
     //   3550: bipush #10
     //   3552: if_icmpeq -> 3560
     //   3555: goto_w -> 3571
     //   3560: aload_0
     //   3561: bipush #7
     //   3563: putfield sp : I
     //   3566: goto_w -> 3571
     //   3571: aload_0
     //   3572: getfield spart : I
     //   3575: bipush #11
     //   3577: if_icmpeq -> 3585
     //   3580: goto_w -> 3596
     //   3585: aload_0
     //   3586: bipush #14
     //   3588: putfield sp : I
     //   3591: goto_w -> 3596
     //   3596: aload_0
     //   3597: getfield spart : I
     //   3600: bipush #12
     //   3602: if_icmpeq -> 3610
     //   3605: goto_w -> 3621
     //   3610: aload_0
     //   3611: bipush #6
     //   3613: putfield sp : I
     //   3616: goto_w -> 3621
     //   3621: aload_0
     //   3622: getfield spart : I
     //   3625: bipush #13
     //   3627: if_icmpeq -> 3635
     //   3630: goto_w -> 3646
     //   3635: aload_0
     //   3636: bipush #34
     //   3638: putfield sp : I
     //   3641: goto_w -> 3646
     //   3646: aload_0
     //   3647: getfield spart : I
     //   3650: bipush #14
     //   3652: if_icmpeq -> 3660
     //   3655: goto_w -> 3671
     //   3660: aload_0
     //   3661: bipush #33
     //   3663: putfield sp : I
     //   3666: goto_w -> 3671
     //   3671: aload_0
     //   3672: getfield spart : I
     //   3675: bipush #15
     //   3677: if_icmpeq -> 3685
     //   3680: goto_w -> 3696
     //   3685: aload_0
     //   3686: bipush #11
     //   3688: putfield sp : I
     //   3691: goto_w -> 3696
     //   3696: aload_0
     //   3697: getfield spart : I
     //   3700: bipush #16
     //   3702: if_icmpeq -> 3710
     //   3705: goto_w -> 3721
     //   3710: aload_0
     //   3711: bipush #8
     //   3713: putfield sp : I
     //   3716: goto_w -> 3721
     //   3721: aload_0
     //   3722: getfield spart : I
     //   3725: bipush #17
     //   3727: if_icmpeq -> 3735
     //   3730: goto_w -> 3746
     //   3735: aload_0
     //   3736: bipush #9
     //   3738: putfield sp : I
     //   3741: goto_w -> 3746
     //   3746: aload_0
     //   3747: getfield spart : I
     //   3750: bipush #18
     //   3752: if_icmpeq -> 3760
     //   3755: goto_w -> 3771
     //   3760: aload_0
     //   3761: bipush #15
     //   3763: putfield sp : I
     //   3766: goto_w -> 3771
     //   3771: aload_0
     //   3772: getfield spart : I
     //   3775: bipush #19
     //   3777: if_icmpeq -> 3785
     //   3780: goto_w -> 3796
     //   3785: aload_0
     //   3786: bipush #12
     //   3788: putfield sp : I
     //   3791: goto_w -> 3796
     //   3796: aload_0
     //   3797: getfield spart : I
     //   3800: bipush #20
     //   3802: if_icmpeq -> 3810
     //   3805: goto_w -> 3821
     //   3810: aload_0
     //   3811: bipush #46
     //   3813: putfield sp : I
     //   3816: goto_w -> 3821
     //   3821: aload_0
     //   3822: getfield spart : I
     //   3825: bipush #21
     //   3827: if_icmpeq -> 3835
     //   3830: goto_w -> 3846
     //   3835: aload_0
     //   3836: bipush #47
     //   3838: putfield sp : I
     //   3841: goto_w -> 3846
     //   3846: aload_0
     //   3847: getfield spart : I
     //   3850: bipush #22
     //   3852: if_icmpeq -> 3860
     //   3855: goto_w -> 3871
     //   3860: aload_0
     //   3861: bipush #50
     //   3863: putfield sp : I
     //   3866: goto_w -> 3871
     //   3871: aload_0
     //   3872: getfield spart : I
     //   3875: bipush #23
     //   3877: if_icmpeq -> 3885
     //   3880: goto_w -> 3896
     //   3885: aload_0
     //   3886: bipush #48
     //   3888: putfield sp : I
     //   3891: goto_w -> 3896
     //   3896: aload_0
     //   3897: getfield spart : I
     //   3900: bipush #24
     //   3902: if_icmpeq -> 3910
     //   3905: goto_w -> 3921
     //   3910: aload_0
     //   3911: bipush #49
     //   3913: putfield sp : I
     //   3916: goto_w -> 3921
     //   3921: aload_0
     //   3922: getfield spart : I
     //   3925: bipush #25
     //   3927: if_icmpeq -> 3935
     //   3930: goto_w -> 3946
     //   3935: aload_0
     //   3936: bipush #51
     //   3938: putfield sp : I
     //   3941: goto_w -> 3946
     //   3946: aload_0
     //   3947: getfield sptyp : I
     //   3950: iconst_1
     //   3951: if_icmpeq -> 3959
     //   3954: goto_w -> 4352
     //   3959: aload_0
     //   3960: getfield spart : I
     //   3963: ifeq -> 3971
     //   3966: goto_w -> 3982
     //   3971: aload_0
     //   3972: bipush #16
     //   3974: putfield sp : I
     //   3977: goto_w -> 3982
     //   3982: aload_0
     //   3983: getfield spart : I
     //   3986: iconst_1
     //   3987: if_icmpeq -> 3995
     //   3990: goto_w -> 4006
     //   3995: aload_0
     //   3996: bipush #18
     //   3998: putfield sp : I
     //   4001: goto_w -> 4006
     //   4006: aload_0
     //   4007: getfield spart : I
     //   4010: iconst_2
     //   4011: if_icmpeq -> 4019
     //   4014: goto_w -> 4030
     //   4019: aload_0
     //   4020: bipush #19
     //   4022: putfield sp : I
     //   4025: goto_w -> 4030
     //   4030: aload_0
     //   4031: getfield spart : I
     //   4034: iconst_3
     //   4035: if_icmpeq -> 4043
     //   4038: goto_w -> 4054
     //   4043: aload_0
     //   4044: bipush #22
     //   4046: putfield sp : I
     //   4049: goto_w -> 4054
     //   4054: aload_0
     //   4055: getfield spart : I
     //   4058: iconst_4
     //   4059: if_icmpeq -> 4067
     //   4062: goto_w -> 4078
     //   4067: aload_0
     //   4068: bipush #17
     //   4070: putfield sp : I
     //   4073: goto_w -> 4078
     //   4078: aload_0
     //   4079: getfield spart : I
     //   4082: iconst_5
     //   4083: if_icmpeq -> 4091
     //   4086: goto_w -> 4102
     //   4091: aload_0
     //   4092: bipush #21
     //   4094: putfield sp : I
     //   4097: goto_w -> 4102
     //   4102: aload_0
     //   4103: getfield spart : I
     //   4106: bipush #6
     //   4108: if_icmpeq -> 4116
     //   4111: goto_w -> 4127
     //   4116: aload_0
     //   4117: bipush #20
     //   4119: putfield sp : I
     //   4122: goto_w -> 4127
     //   4127: aload_0
     //   4128: getfield spart : I
     //   4131: bipush #7
     //   4133: if_icmpeq -> 4141
     //   4136: goto_w -> 4152
     //   4141: aload_0
     //   4142: bipush #39
     //   4144: putfield sp : I
     //   4147: goto_w -> 4152
     //   4152: aload_0
     //   4153: getfield spart : I
     //   4156: bipush #8
     //   4158: if_icmpeq -> 4166
     //   4161: goto_w -> 4177
     //   4166: aload_0
     //   4167: bipush #42
     //   4169: putfield sp : I
     //   4172: goto_w -> 4177
     //   4177: aload_0
     //   4178: getfield spart : I
     //   4181: bipush #9
     //   4183: if_icmpeq -> 4191
     //   4186: goto_w -> 4202
     //   4191: aload_0
     //   4192: bipush #40
     //   4194: putfield sp : I
     //   4197: goto_w -> 4202
     //   4202: aload_0
     //   4203: getfield spart : I
     //   4206: bipush #10
     //   4208: if_icmpeq -> 4216
     //   4211: goto_w -> 4227
     //   4216: aload_0
     //   4217: bipush #23
     //   4219: putfield sp : I
     //   4222: goto_w -> 4227
     //   4227: aload_0
     //   4228: getfield spart : I
     //   4231: bipush #11
     //   4233: if_icmpeq -> 4241
     //   4236: goto_w -> 4252
     //   4241: aload_0
     //   4242: bipush #25
     //   4244: putfield sp : I
     //   4247: goto_w -> 4252
     //   4252: aload_0
     //   4253: getfield spart : I
     //   4256: bipush #12
     //   4258: if_icmpeq -> 4266
     //   4261: goto_w -> 4277
     //   4266: aload_0
     //   4267: bipush #24
     //   4269: putfield sp : I
     //   4272: goto_w -> 4277
     //   4277: aload_0
     //   4278: getfield spart : I
     //   4281: bipush #13
     //   4283: if_icmpeq -> 4291
     //   4286: goto_w -> 4302
     //   4291: aload_0
     //   4292: bipush #43
     //   4294: putfield sp : I
     //   4297: goto_w -> 4302
     //   4302: aload_0
     //   4303: getfield spart : I
     //   4306: bipush #14
     //   4308: if_icmpeq -> 4316
     //   4311: goto_w -> 4327
     //   4316: aload_0
     //   4317: bipush #45
     //   4319: putfield sp : I
     //   4322: goto_w -> 4327
     //   4327: aload_0
     //   4328: getfield spart : I
     //   4331: bipush #15
     //   4333: if_icmpeq -> 4341
     //   4336: goto_w -> 4352
     //   4341: aload_0
     //   4342: bipush #26
     //   4344: putfield sp : I
     //   4347: goto_w -> 4352
     //   4352: aload_0
     //   4353: getfield sptyp : I
     //   4356: iconst_2
     //   4357: if_icmpeq -> 4365
     //   4360: goto_w -> 4508
     //   4365: aload_0
     //   4366: getfield spart : I
     //   4369: ifeq -> 4377
     //   4372: goto_w -> 4388
     //   4377: aload_0
     //   4378: bipush #27
     //   4380: putfield sp : I
     //   4383: goto_w -> 4388
     //   4388: aload_0
     //   4389: getfield spart : I
     //   4392: iconst_1
     //   4393: if_icmpeq -> 4401
     //   4396: goto_w -> 4412
     //   4401: aload_0
     //   4402: bipush #28
     //   4404: putfield sp : I
     //   4407: goto_w -> 4412
     //   4412: aload_0
     //   4413: getfield spart : I
     //   4416: iconst_2
     //   4417: if_icmpeq -> 4425
     //   4420: goto_w -> 4436
     //   4425: aload_0
     //   4426: bipush #41
     //   4428: putfield sp : I
     //   4431: goto_w -> 4436
     //   4436: aload_0
     //   4437: getfield spart : I
     //   4440: iconst_3
     //   4441: if_icmpeq -> 4449
     //   4444: goto_w -> 4460
     //   4449: aload_0
     //   4450: bipush #44
     //   4452: putfield sp : I
     //   4455: goto_w -> 4460
     //   4460: aload_0
     //   4461: getfield spart : I
     //   4464: iconst_4
     //   4465: if_icmpeq -> 4473
     //   4468: goto_w -> 4484
     //   4473: aload_0
     //   4474: bipush #52
     //   4476: putfield sp : I
     //   4479: goto_w -> 4484
     //   4484: aload_0
     //   4485: getfield spart : I
     //   4488: iconst_5
     //   4489: if_icmpeq -> 4497
     //   4492: goto_w -> 4508
     //   4497: aload_0
     //   4498: bipush #53
     //   4500: putfield sp : I
     //   4503: goto_w -> 4508
     //   4508: aload_0
     //   4509: getfield sptyp : I
     //   4512: iconst_3
     //   4513: if_icmpeq -> 4521
     //   4516: goto_w -> 4578
     //   4521: aload_0
     //   4522: getfield onfly : Z
     //   4525: ifne -> 4533
     //   4528: goto_w -> 4544
     //   4533: aload_0
     //   4534: bipush #54
     //   4536: putfield sp : I
     //   4539: goto_w -> 4578
     //   4544: aload_0
     //   4545: getfield onoff : Z
     //   4548: ifeq -> 4556
     //   4551: goto_w -> 4567
     //   4556: aload_0
     //   4557: bipush #30
     //   4559: putfield sp : I
     //   4562: goto_w -> 4578
     //   4567: aload_0
     //   4568: bipush #32
     //   4570: putfield sp : I
     //   4573: goto_w -> 4578
     //   4578: aload_0
     //   4579: getfield sptyp : I
     //   4582: iconst_4
     //   4583: if_icmpeq -> 4591
     //   4586: goto_w -> 4602
     //   4591: aload_0
     //   4592: bipush #31
     //   4594: putfield sp : I
     //   4597: goto_w -> 4602
     //   4602: aload_0
     //   4603: getfield sptyp : I
     //   4606: iconst_5
     //   4607: if_icmpeq -> 4615
     //   4610: goto_w -> 4883
     //   4615: aload_0
     //   4616: getfield spart : I
     //   4619: ifeq -> 4627
     //   4622: goto_w -> 4638
     //   4627: aload_0
     //   4628: bipush #55
     //   4630: putfield sp : I
     //   4633: goto_w -> 4638
     //   4638: aload_0
     //   4639: getfield spart : I
     //   4642: iconst_1
     //   4643: if_icmpeq -> 4651
     //   4646: goto_w -> 4662
     //   4651: aload_0
     //   4652: bipush #56
     //   4654: putfield sp : I
     //   4657: goto_w -> 4662
     //   4662: aload_0
     //   4663: getfield spart : I
     //   4666: iconst_2
     //   4667: if_icmpeq -> 4675
     //   4670: goto_w -> 4686
     //   4675: aload_0
     //   4676: bipush #57
     //   4678: putfield sp : I
     //   4681: goto_w -> 4686
     //   4686: aload_0
     //   4687: getfield spart : I
     //   4690: iconst_3
     //   4691: if_icmpeq -> 4699
     //   4694: goto_w -> 4710
     //   4699: aload_0
     //   4700: bipush #58
     //   4702: putfield sp : I
     //   4705: goto_w -> 4710
     //   4710: aload_0
     //   4711: getfield spart : I
     //   4714: iconst_4
     //   4715: if_icmpeq -> 4723
     //   4718: goto_w -> 4734
     //   4723: aload_0
     //   4724: bipush #59
     //   4726: putfield sp : I
     //   4729: goto_w -> 4734
     //   4734: aload_0
     //   4735: getfield spart : I
     //   4738: iconst_5
     //   4739: if_icmpeq -> 4747
     //   4742: goto_w -> 4758
     //   4747: aload_0
     //   4748: bipush #60
     //   4750: putfield sp : I
     //   4753: goto_w -> 4758
     //   4758: aload_0
     //   4759: getfield spart : I
     //   4762: bipush #6
     //   4764: if_icmpeq -> 4772
     //   4767: goto_w -> 4783
     //   4772: aload_0
     //   4773: bipush #61
     //   4775: putfield sp : I
     //   4778: goto_w -> 4783
     //   4783: aload_0
     //   4784: getfield spart : I
     //   4787: bipush #7
     //   4789: if_icmpeq -> 4797
     //   4792: goto_w -> 4808
     //   4797: aload_0
     //   4798: bipush #62
     //   4800: putfield sp : I
     //   4803: goto_w -> 4808
     //   4808: aload_0
     //   4809: getfield spart : I
     //   4812: bipush #8
     //   4814: if_icmpeq -> 4822
     //   4817: goto_w -> 4833
     //   4822: aload_0
     //   4823: bipush #63
     //   4825: putfield sp : I
     //   4828: goto_w -> 4833
     //   4833: aload_0
     //   4834: getfield spart : I
     //   4837: bipush #9
     //   4839: if_icmpeq -> 4847
     //   4842: goto_w -> 4858
     //   4847: aload_0
     //   4848: bipush #64
     //   4850: putfield sp : I
     //   4853: goto_w -> 4858
     //   4858: aload_0
     //   4859: getfield spart : I
     //   4862: bipush #10
     //   4864: if_icmpeq -> 4872
     //   4867: goto_w -> 4883
     //   4872: aload_0
     //   4873: bipush #65
     //   4875: putfield sp : I
     //   4878: goto_w -> 4883
     //   4883: aload_0
     //   4884: getfield sptyp : I
     //   4887: bipush #6
     //   4889: if_icmpeq -> 4897
     //   4892: goto_w -> 5053
     //   4897: aload_0
     //   4898: getfield pgen : Z
     //   4901: ifeq -> 4909
     //   4904: goto_w -> 5037
     //   4909: ldc2_w 10000.0
     //   4912: invokestatic random : ()D
     //   4915: dmul
     //   4916: d2i
     //   4917: istore_1
     //   4918: aload_0
     //   4919: getfield fgen : I
     //   4922: ifne -> 4930
     //   4925: goto_w -> 4945
     //   4930: aload_0
     //   4931: getfield fgen : I
     //   4934: istore_1
     //   4935: aload_0
     //   4936: iconst_0
     //   4937: putfield fgen : I
     //   4940: goto_w -> 4945
     //   4945: aload_0
     //   4946: getfield bco : [LContO;
     //   4949: bipush #66
     //   4951: new ContO
     //   4954: dup
     //   4955: iload_1
     //   4956: aload_0
     //   4957: getfield pwd : F
     //   4960: f2i
     //   4961: aload_0
     //   4962: getfield phd : F
     //   4965: f2i
     //   4966: aload_0
     //   4967: getfield m : LMedium;
     //   4970: aload_0
     //   4971: getfield t : LTrackers;
     //   4974: iconst_0
     //   4975: iconst_0
     //   4976: iconst_0
     //   4977: invokespecial <init> : (IIILMedium;LTrackers;III)V
     //   4980: aastore
     //   4981: aload_0
     //   4982: getfield bco : [LContO;
     //   4985: bipush #66
     //   4987: aaload
     //   4988: iload_1
     //   4989: putfield srz : I
     //   4992: aload_0
     //   4993: getfield bco : [LContO;
     //   4996: bipush #66
     //   4998: aaload
     //   4999: aload_0
     //   5000: getfield pwd : F
     //   5003: f2i
     //   5004: putfield srx : I
     //   5007: aload_0
     //   5008: getfield bco : [LContO;
     //   5011: bipush #66
     //   5013: aaload
     //   5014: aload_0
     //   5015: getfield phd : F
     //   5018: f2i
     //   5019: putfield sry : I
     //   5022: aload_0
     //   5023: iconst_1
     //   5024: putfield pgen : Z
     //   5027: aload_0
     //   5028: iconst_3
     //   5029: putfield seq : I
     //   5032: goto_w -> 5037
     //   5037: aload_0
     //   5038: bipush #66
     //   5040: putfield sp : I
     //   5043: aload_0
     //   5044: iconst_0
     //   5045: putfield rot : I
     //   5048: goto_w -> 5113
     //   5053: aload_0
     //   5054: getfield pgen : Z
     //   5057: ifne -> 5065
     //   5060: goto_w -> 5113
     //   5065: aload_0
     //   5066: iconst_0
     //   5067: putfield pgen : Z
     //   5070: aload_0
     //   5071: ldc2_w 2
     //   5074: invokestatic random : ()D
     //   5077: ldc2_w 4.0
     //   5080: dmul
     //   5081: invokestatic round : (D)J
     //   5084: ladd
     //   5085: l2f
     //   5086: putfield pwd : F
     //   5089: aload_0
     //   5090: ldc2_w 2
     //   5093: invokestatic random : ()D
     //   5096: ldc2_w 4.0
     //   5099: dmul
     //   5100: invokestatic round : (D)J
     //   5103: ladd
     //   5104: l2f
     //   5105: putfield phd : F
     //   5108: goto_w -> 5113
     //   5113: aload_0
     //   5114: getfield sp : I
     //   5117: bipush #30
     //   5119: if_icmpne -> 5127
     //   5122: goto_w -> 5169
     //   5127: aload_0
     //   5128: getfield sp : I
     //   5131: bipush #31
     //   5133: if_icmpne -> 5141
     //   5136: goto_w -> 5169
     //   5141: aload_0
     //   5142: getfield sp : I
     //   5145: bipush #32
     //   5147: if_icmpne -> 5155
     //   5150: goto_w -> 5169
     //   5155: aload_0
     //   5156: getfield sp : I
     //   5159: bipush #54
     //   5161: if_icmpeq -> 5169
     //   5164: goto_w -> 5219
     //   5169: aload_0
     //   5170: getfield rot : I
     //   5173: bipush #-90
     //   5175: if_icmpeq -> 5183
     //   5178: goto_w -> 5194
     //   5183: aload_0
     //   5184: bipush #90
     //   5186: putfield rot : I
     //   5189: goto_w -> 5194
     //   5194: aload_0
     //   5195: getfield rot : I
     //   5198: sipush #180
     //   5201: if_icmpeq -> 5209
     //   5204: goto_w -> 5219
     //   5209: aload_0
     //   5210: iconst_0
     //   5211: putfield rot : I
     //   5214: goto_w -> 5219
     //   5219: aload_0
     //   5220: iconst_0
     //   5221: putfield adrot : I
     //   5224: aload_0
     //   5225: getfield sp : I
     //   5228: iconst_2
     //   5229: if_icmpeq -> 5237
     //   5232: goto_w -> 5248
     //   5237: aload_0
     //   5238: bipush #-30
     //   5240: putfield adrot : I
     //   5243: goto_w -> 5248
     //   5248: aload_0
     //   5249: getfield sp : I
     //   5252: iconst_3
     //   5253: if_icmpeq -> 5261
     //   5256: goto_w -> 5272
     //   5261: aload_0
     //   5262: bipush #30
     //   5264: putfield adrot : I
     //   5267: goto_w -> 5272
     //   5272: aload_0
     //   5273: getfield sp : I
     //   5276: bipush #15
     //   5278: if_icmpeq -> 5286
     //   5281: goto_w -> 5297
     //   5286: aload_0
     //   5287: bipush #90
     //   5289: putfield adrot : I
     //   5292: goto_w -> 5297
     //   5297: aload_0
     //   5298: getfield sp : I
     //   5301: bipush #20
     //   5303: if_icmpeq -> 5311
     //   5306: goto_w -> 5323
     //   5311: aload_0
     //   5312: sipush #180
     //   5315: putfield adrot : I
     //   5318: goto_w -> 5323
     //   5323: aload_0
     //   5324: getfield sp : I
     //   5327: bipush #26
     //   5329: if_icmpeq -> 5337
     //   5332: goto_w -> 5348
     //   5337: aload_0
     //   5338: bipush #90
     //   5340: putfield adrot : I
     //   5343: goto_w -> 5348
     //   5348: aload_0
     //   5349: getfield rd : Ljava/awt/Graphics2D;
     //   5352: new java/awt/Color
     //   5355: dup
     //   5356: sipush #200
     //   5359: sipush #200
     //   5362: sipush #200
     //   5365: invokespecial <init> : (III)V
     //   5368: invokevirtual setColor : (Ljava/awt/Color;)V
     //   5371: aload_0
     //   5372: getfield rd : Ljava/awt/Graphics2D;
     //   5375: sipush #248
     //   5378: bipush #63
     //   5380: sipush #514
     //   5383: sipush #454
     //   5386: invokevirtual fillRect : (IIII)V
     //   5389: aload_0
     //   5390: getfield m : LMedium;
     //   5393: iconst_2
     //   5394: putfield trk : I
     //   5397: aload_0
     //   5398: getfield m : LMedium;
     //   5401: bipush #90
     //   5403: putfield zy : I
     //   5406: aload_0
     //   5407: getfield m : LMedium;
     //   5410: iconst_0
     //   5411: putfield xz : I
     //   5414: aload_0
     //   5415: getfield m : LMedium;
     //   5418: sipush #248
     //   5421: putfield iw : I
     //   5424: aload_0
     //   5425: getfield m : LMedium;
     //   5428: sipush #762
     //   5431: putfield w : I
     //   5434: aload_0
     //   5435: getfield m : LMedium;
     //   5438: bipush #63
     //   5440: putfield ih : I
     //   5443: aload_0
     //   5444: getfield m : LMedium;
     //   5447: sipush #517
     //   5450: putfield h : I
     //   5453: aload_0
     //   5454: getfield m : LMedium;
     //   5457: sipush #505
     //   5460: putfield cx : I
     //   5463: aload_0
     //   5464: getfield m : LMedium;
     //   5467: sipush #290
     //   5470: putfield cy : I
     //   5473: aload_0
     //   5474: getfield m : LMedium;
     //   5477: aload_0
     //   5478: getfield sx : I
     //   5481: aload_0
     //   5482: getfield m : LMedium;
     //   5485: getfield cx : I
     //   5488: isub
     //   5489: putfield x : I
     //   5492: aload_0
     //   5493: getfield m : LMedium;
     //   5496: aload_0
     //   5497: getfield sz : I
     //   5500: aload_0
     //   5501: getfield m : LMedium;
     //   5504: getfield cz : I
     //   5507: isub
     //   5508: putfield z : I
     //   5511: aload_0
     //   5512: getfield m : LMedium;
     //   5515: aload_0
     //   5516: getfield sy : I
     //   5519: putfield y : I
     //   5522: iconst_0
     //   5523: istore_1
     //   5524: sipush #200
     //   5527: newarray int
     //   5529: astore_2
     //   5530: iconst_0
     //   5531: istore_3
     //   5532: iload_3
     //   5533: aload_0
     //   5534: getfield nob : I
     //   5537: if_icmplt -> 5545
     //   5540: goto_w -> 5595
     //   5545: aload_0
     //   5546: getfield co : [LContO;
     //   5549: iload_3
     //   5550: aaload
     //   5551: getfield dist : I
     //   5554: ifne -> 5562
     //   5557: goto_w -> 5574
     //   5562: aload_2
     //   5563: iload_1
     //   5564: iload_3
     //   5565: iastore
     //   5566: iinc #1, 1
     //   5569: goto_w -> 5587
     //   5574: aload_0
     //   5575: getfield co : [LContO;
     //   5578: iload_3
     //   5579: aaload
     //   5580: aload_0
     //   5581: getfield rd : Ljava/awt/Graphics2D;
     //   5584: invokevirtual d : (Ljava/awt/Graphics2D;)V
     //   5587: iinc #3, 1
     //   5590: goto_w -> 5532
     //   5595: iload_1
     //   5596: newarray int
     //   5598: astore_3
     //   5599: iconst_0
     //   5600: istore #4
     //   5602: iload #4
     //   5604: iload_1
     //   5605: if_icmplt -> 5613
     //   5608: goto_w -> 5626
     //   5613: aload_3
     //   5614: iload #4
     //   5616: iconst_0
     //   5617: iastore
     //   5618: iinc #4, 1
     //   5621: goto_w -> 5602
     //   5626: iconst_0
     //   5627: istore #4
     //   5629: iload #4
     //   5631: iload_1
     //   5632: if_icmplt -> 5640
     //   5635: goto_w -> 5796
     //   5640: iload #4
     //   5642: iconst_1
     //   5643: iadd
     //   5644: istore #5
     //   5646: iload #5
     //   5648: iload_1
     //   5649: if_icmplt -> 5657
     //   5652: goto_w -> 5788
     //   5657: aload_0
     //   5658: getfield co : [LContO;
     //   5661: aload_2
     //   5662: iload #4
     //   5664: iaload
     //   5665: aaload
     //   5666: getfield dist : I
     //   5669: aload_0
     //   5670: getfield co : [LContO;
     //   5673: aload_2
     //   5674: iload #5
     //   5676: iaload
     //   5677: aaload
     //   5678: getfield dist : I
     //   5681: if_icmpne -> 5689
     //   5684: goto_w -> 5747
     //   5689: aload_0
     //   5690: getfield co : [LContO;
     //   5693: aload_2
     //   5694: iload #4
     //   5696: iaload
     //   5697: aaload
     //   5698: getfield dist : I
     //   5701: aload_0
     //   5702: getfield co : [LContO;
     //   5705: aload_2
     //   5706: iload #5
     //   5708: iaload
     //   5709: aaload
     //   5710: getfield dist : I
     //   5713: if_icmplt -> 5721
     //   5716: goto_w -> 5734
     //   5721: aload_3
     //   5722: iload #4
     //   5724: dup2
     //   5725: iaload
     //   5726: iconst_1
     //   5727: iadd
     //   5728: iastore
     //   5729: goto_w -> 5780
     //   5734: aload_3
     //   5735: iload #5
     //   5737: dup2
     //   5738: iaload
     //   5739: iconst_1
     //   5740: iadd
     //   5741: iastore
     //   5742: goto_w -> 5780
     //   5747: iload #5
     //   5749: iload #4
     //   5751: if_icmpgt -> 5759
     //   5754: goto_w -> 5772
     //   5759: aload_3
     //   5760: iload #4
     //   5762: dup2
     //   5763: iaload
     //   5764: iconst_1
     //   5765: iadd
     //   5766: iastore
     //   5767: goto_w -> 5780
     //   5772: aload_3
     //   5773: iload #5
     //   5775: dup2
     //   5776: iaload
     //   5777: iconst_1
     //   5778: iadd
     //   5779: iastore
     //   5780: iinc #5, 1
     //   5783: goto_w -> 5646
     //   5788: iinc #4, 1
     //   5791: goto_w -> 5629
     //   5796: iconst_0
     //   5797: istore #4
     //   5799: iload #4
     //   5801: iload_1
     //   5802: if_icmplt -> 5810
     //   5805: goto_w -> 7301
     //   5810: iconst_0
     //   5811: istore #5
     //   5813: iload #5
     //   5815: iload_1
     //   5816: if_icmplt -> 5824
     //   5819: goto_w -> 7293
     //   5824: aload_3
     //   5825: iload #5
     //   5827: iaload
     //   5828: iload #4
     //   5830: if_icmpeq -> 5838
     //   5833: goto_w -> 7285
     //   5838: aload_2
     //   5839: iload #5
     //   5841: iaload
     //   5842: aload_0
     //   5843: getfield hi : I
     //   5846: if_icmpeq -> 5854
     //   5849: goto_w -> 5867
     //   5854: aload_0
     //   5855: getfield m : LMedium;
     //   5858: iconst_3
     //   5859: putfield trk : I
     //   5862: goto_w -> 5867
     //   5867: aload_2
     //   5868: iload #5
     //   5870: iaload
     //   5871: aload_0
     //   5872: getfield chi : I
     //   5875: if_icmpeq -> 5883
     //   5878: goto_w -> 6517
     //   5883: aload_0
     //   5884: getfield co : [LContO;
     //   5887: aload_2
     //   5888: iload #5
     //   5890: iaload
     //   5891: aaload
     //   5892: getfield errd : Z
     //   5895: ifeq -> 5903
     //   5898: goto_w -> 6517
     //   5903: aload_0
     //   5904: getfield m : LMedium;
     //   5907: getfield cx : I
     //   5910: aload_0
     //   5911: getfield co : [LContO;
     //   5914: aload_2
     //   5915: iload #5
     //   5917: iaload
     //   5918: aaload
     //   5919: getfield x : I
     //   5922: aload_0
     //   5923: getfield m : LMedium;
     //   5926: getfield x : I
     //   5929: isub
     //   5930: aload_0
     //   5931: getfield m : LMedium;
     //   5934: getfield cx : I
     //   5937: isub
     //   5938: i2f
     //   5939: aload_0
     //   5940: getfield m : LMedium;
     //   5943: aload_0
     //   5944: getfield m : LMedium;
     //   5947: getfield xz : I
     //   5950: invokevirtual cos : (I)F
     //   5953: fmul
     //   5954: aload_0
     //   5955: getfield co : [LContO;
     //   5958: aload_2
     //   5959: iload #5
     //   5961: iaload
     //   5962: aaload
     //   5963: getfield z : I
     //   5966: aload_0
     //   5967: getfield m : LMedium;
     //   5970: getfield z : I
     //   5973: isub
     //   5974: aload_0
     //   5975: getfield m : LMedium;
     //   5978: getfield cz : I
     //   5981: isub
     //   5982: i2f
     //   5983: aload_0
     //   5984: getfield m : LMedium;
     //   5987: aload_0
     //   5988: getfield m : LMedium;
     //   5991: getfield xz : I
     //   5994: invokevirtual sin : (I)F
     //   5997: fmul
     //   5998: fsub
     //   5999: f2i
     //   6000: iadd
     //   6001: istore #6
     //   6003: aload_0
     //   6004: getfield m : LMedium;
     //   6007: getfield cz : I
     //   6010: aload_0
     //   6011: getfield co : [LContO;
     //   6014: aload_2
     //   6015: iload #5
     //   6017: iaload
     //   6018: aaload
     //   6019: getfield x : I
     //   6022: aload_0
     //   6023: getfield m : LMedium;
     //   6026: getfield x : I
     //   6029: isub
     //   6030: aload_0
     //   6031: getfield m : LMedium;
     //   6034: getfield cx : I
     //   6037: isub
     //   6038: i2f
     //   6039: aload_0
     //   6040: getfield m : LMedium;
     //   6043: aload_0
     //   6044: getfield m : LMedium;
     //   6047: getfield xz : I
     //   6050: invokevirtual sin : (I)F
     //   6053: fmul
     //   6054: aload_0
     //   6055: getfield co : [LContO;
     //   6058: aload_2
     //   6059: iload #5
     //   6061: iaload
     //   6062: aaload
     //   6063: getfield z : I
     //   6066: aload_0
     //   6067: getfield m : LMedium;
     //   6070: getfield z : I
     //   6073: isub
     //   6074: aload_0
     //   6075: getfield m : LMedium;
     //   6078: getfield cz : I
     //   6081: isub
     //   6082: i2f
     //   6083: aload_0
     //   6084: getfield m : LMedium;
     //   6087: aload_0
     //   6088: getfield m : LMedium;
     //   6091: getfield xz : I
     //   6094: invokevirtual cos : (I)F
     //   6097: fmul
     //   6098: fadd
     //   6099: f2i
     //   6100: iadd
     //   6101: istore #7
     //   6103: aload_0
     //   6104: getfield m : LMedium;
     //   6107: getfield cy : I
     //   6110: aload_0
     //   6111: getfield co : [LContO;
     //   6114: aload_2
     //   6115: iload #5
     //   6117: iaload
     //   6118: aaload
     //   6119: getfield y : I
     //   6122: aload_0
     //   6123: getfield m : LMedium;
     //   6126: getfield y : I
     //   6129: isub
     //   6130: aload_0
     //   6131: getfield m : LMedium;
     //   6134: getfield cy : I
     //   6137: isub
     //   6138: i2f
     //   6139: aload_0
     //   6140: getfield m : LMedium;
     //   6143: aload_0
     //   6144: getfield m : LMedium;
     //   6147: getfield zy : I
     //   6150: invokevirtual cos : (I)F
     //   6153: fmul
     //   6154: iload #7
     //   6156: aload_0
     //   6157: getfield m : LMedium;
     //   6160: getfield cz : I
     //   6163: isub
     //   6164: i2f
     //   6165: aload_0
     //   6166: getfield m : LMedium;
     //   6169: aload_0
     //   6170: getfield m : LMedium;
     //   6173: getfield zy : I
     //   6176: invokevirtual sin : (I)F
     //   6179: fmul
     //   6180: fsub
     //   6181: f2i
     //   6182: iadd
     //   6183: istore #8
     //   6185: aload_0
     //   6186: getfield m : LMedium;
     //   6189: getfield cz : I
     //   6192: aload_0
     //   6193: getfield co : [LContO;
     //   6196: aload_2
     //   6197: iload #5
     //   6199: iaload
     //   6200: aaload
     //   6201: getfield y : I
     //   6204: aload_0
     //   6205: getfield m : LMedium;
     //   6208: getfield y : I
     //   6211: isub
     //   6212: aload_0
     //   6213: getfield m : LMedium;
     //   6216: getfield cy : I
     //   6219: isub
     //   6220: i2f
     //   6221: aload_0
     //   6222: getfield m : LMedium;
     //   6225: aload_0
     //   6226: getfield m : LMedium;
     //   6229: getfield zy : I
     //   6232: invokevirtual sin : (I)F
     //   6235: fmul
     //   6236: iload #7
     //   6238: aload_0
     //   6239: getfield m : LMedium;
     //   6242: getfield cz : I
     //   6245: isub
     //   6246: i2f
     //   6247: aload_0
     //   6248: getfield m : LMedium;
     //   6251: aload_0
     //   6252: getfield m : LMedium;
     //   6255: getfield zy : I
     //   6258: invokevirtual cos : (I)F
     //   6261: fmul
     //   6262: fadd
     //   6263: f2i
     //   6264: iadd
     //   6265: istore #9
     //   6267: ldc_w 1000000
     //   6270: aload_0
     //   6271: getfield sy : I
     //   6274: invokestatic abs : (I)I
     //   6277: idiv
     //   6278: istore #10
     //   6280: aload_0
     //   6281: getfield rd : Ljava/awt/Graphics2D;
     //   6284: astore #11
     //   6286: aload #11
     //   6288: iconst_3
     //   6289: ldc_w 0.7
     //   6292: invokestatic getInstance : (IF)Ljava/awt/AlphaComposite;
     //   6295: invokevirtual setComposite : (Ljava/awt/Composite;)V
     //   6298: aload_0
     //   6299: getfield rd : Ljava/awt/Graphics2D;
     //   6302: new java/awt/Color
     //   6305: dup
     //   6306: iconst_0
     //   6307: sipush #164
     //   6310: sipush #255
     //   6313: invokespecial <init> : (III)V
     //   6316: invokevirtual setColor : (Ljava/awt/Color;)V
     //   6319: aload_0
     //   6320: getfield rd : Ljava/awt/Graphics2D;
     //   6323: aload_0
     //   6324: iload #6
     //   6326: iload #9
     //   6328: invokevirtual xs : (II)I
     //   6331: iload #10
     //   6333: iconst_2
     //   6334: idiv
     //   6335: isub
     //   6336: aload_0
     //   6337: iload #8
     //   6339: iload #9
     //   6341: invokevirtual ys : (II)I
     //   6344: iload #10
     //   6346: iconst_2
     //   6347: idiv
     //   6348: isub
     //   6349: iload #10
     //   6351: iload #10
     //   6353: invokevirtual fillOval : (IIII)V
     //   6356: aload #11
     //   6358: iconst_3
     //   6359: fconst_1
     //   6360: invokestatic getInstance : (IF)Ljava/awt/AlphaComposite;
     //   6363: invokevirtual setComposite : (Ljava/awt/Composite;)V
     //   6366: aload_0
     //   6367: getfield rd : Ljava/awt/Graphics2D;
     //   6370: new java/awt/Color
     //   6373: dup
     //   6374: iconst_0
     //   6375: iconst_0
     //   6376: iconst_0
     //   6377: invokespecial <init> : (III)V
     //   6380: invokevirtual setColor : (Ljava/awt/Color;)V
     //   6383: aload_0
     //   6384: getfield rd : Ljava/awt/Graphics2D;
     //   6387: new java/awt/Font
     //   6390: dup
     //   6391: ldc_w 'Arial'
     //   6394: iconst_1
     //   6395: bipush #12
     //   6397: invokespecial <init> : (Ljava/lang/String;II)V
     //   6400: invokevirtual setFont : (Ljava/awt/Font;)V
     //   6403: aload_0
     //   6404: aload_0
     //   6405: getfield rd : Ljava/awt/Graphics2D;
     //   6408: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
     //   6411: putfield ftm : Ljava/awt/FontMetrics;
     //   6414: aload_0
     //   6415: getfield rd : Ljava/awt/Graphics2D;
     //   6418: new java/lang/StringBuilder
     //   6421: dup
     //   6422: invokespecial <init> : ()V
     //   6425: ldc_w 'NO# '
     //   6428: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   6431: aload_0
     //   6432: getfield arrcnt : I
     //   6435: iconst_1
     //   6436: iadd
     //   6437: invokevirtual append : (I)Ljava/lang/StringBuilder;
     //   6440: ldc ''
     //   6442: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   6445: invokevirtual toString : ()Ljava/lang/String;
     //   6448: aload_0
     //   6449: iload #6
     //   6451: iload #9
     //   6453: invokevirtual xs : (II)I
     //   6456: aload_0
     //   6457: getfield ftm : Ljava/awt/FontMetrics;
     //   6460: new java/lang/StringBuilder
     //   6463: dup
     //   6464: invokespecial <init> : ()V
     //   6467: ldc_w 'NO# '
     //   6470: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   6473: aload_0
     //   6474: getfield arrcnt : I
     //   6477: iconst_1
     //   6478: iadd
     //   6479: invokevirtual append : (I)Ljava/lang/StringBuilder;
     //   6482: ldc ''
     //   6484: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   6487: invokevirtual toString : ()Ljava/lang/String;
     //   6490: invokevirtual stringWidth : (Ljava/lang/String;)I
     //   6493: iconst_2
     //   6494: idiv
     //   6495: isub
     //   6496: aload_0
     //   6497: iload #8
     //   6499: iload #9
     //   6501: invokevirtual ys : (II)I
     //   6504: iload #10
     //   6506: iconst_2
     //   6507: idiv
     //   6508: isub
     //   6509: invokevirtual drawString : (Ljava/lang/String;II)V
     //   6512: goto_w -> 6517
     //   6517: aload_0
     //   6518: getfield arrng : Z
     //   6521: ifne -> 6529
     //   6524: goto_w -> 7240
     //   6529: aload_0
     //   6530: getfield co : [LContO;
     //   6533: aload_2
     //   6534: iload #5
     //   6536: iaload
     //   6537: aaload
     //   6538: getfield colok : I
     //   6541: bipush #30
     //   6543: if_icmpne -> 6551
     //   6546: goto_w -> 6595
     //   6551: aload_0
     //   6552: getfield co : [LContO;
     //   6555: aload_2
     //   6556: iload #5
     //   6558: iaload
     //   6559: aaload
     //   6560: getfield colok : I
     //   6563: bipush #32
     //   6565: if_icmpne -> 6573
     //   6568: goto_w -> 6595
     //   6573: aload_0
     //   6574: getfield co : [LContO;
     //   6577: aload_2
     //   6578: iload #5
     //   6580: iaload
     //   6581: aaload
     //   6582: getfield colok : I
     //   6585: bipush #54
     //   6587: if_icmpeq -> 6595
     //   6590: goto_w -> 7240
     //   6595: aload_0
     //   6596: getfield co : [LContO;
     //   6599: aload_2
     //   6600: iload #5
     //   6602: iaload
     //   6603: aaload
     //   6604: getfield errd : Z
     //   6607: ifne -> 6615
     //   6610: goto_w -> 7240
     //   6615: aload_0
     //   6616: getfield m : LMedium;
     //   6619: getfield cx : I
     //   6622: aload_0
     //   6623: getfield co : [LContO;
     //   6626: aload_2
     //   6627: iload #5
     //   6629: iaload
     //   6630: aaload
     //   6631: getfield x : I
     //   6634: aload_0
     //   6635: getfield m : LMedium;
     //   6638: getfield x : I
     //   6641: isub
     //   6642: aload_0
     //   6643: getfield m : LMedium;
     //   6646: getfield cx : I
     //   6649: isub
     //   6650: i2f
     //   6651: aload_0
     //   6652: getfield m : LMedium;
     //   6655: aload_0
     //   6656: getfield m : LMedium;
     //   6659: getfield xz : I
     //   6662: invokevirtual cos : (I)F
     //   6665: fmul
     //   6666: aload_0
     //   6667: getfield co : [LContO;
     //   6670: aload_2
     //   6671: iload #5
     //   6673: iaload
     //   6674: aaload
     //   6675: getfield z : I
     //   6678: aload_0
     //   6679: getfield m : LMedium;
     //   6682: getfield z : I
     //   6685: isub
     //   6686: aload_0
     //   6687: getfield m : LMedium;
     //   6690: getfield cz : I
     //   6693: isub
     //   6694: i2f
     //   6695: aload_0
     //   6696: getfield m : LMedium;
     //   6699: aload_0
     //   6700: getfield m : LMedium;
     //   6703: getfield xz : I
     //   6706: invokevirtual sin : (I)F
     //   6709: fmul
     //   6710: fsub
     //   6711: f2i
     //   6712: iadd
     //   6713: istore #6
     //   6715: aload_0
     //   6716: getfield m : LMedium;
     //   6719: getfield cz : I
     //   6722: aload_0
     //   6723: getfield co : [LContO;
     //   6726: aload_2
     //   6727: iload #5
     //   6729: iaload
     //   6730: aaload
     //   6731: getfield x : I
     //   6734: aload_0
     //   6735: getfield m : LMedium;
     //   6738: getfield x : I
     //   6741: isub
     //   6742: aload_0
     //   6743: getfield m : LMedium;
     //   6746: getfield cx : I
     //   6749: isub
     //   6750: i2f
     //   6751: aload_0
     //   6752: getfield m : LMedium;
     //   6755: aload_0
     //   6756: getfield m : LMedium;
     //   6759: getfield xz : I
     //   6762: invokevirtual sin : (I)F
     //   6765: fmul
     //   6766: aload_0
     //   6767: getfield co : [LContO;
     //   6770: aload_2
     //   6771: iload #5
     //   6773: iaload
     //   6774: aaload
     //   6775: getfield z : I
     //   6778: aload_0
     //   6779: getfield m : LMedium;
     //   6782: getfield z : I
     //   6785: isub
     //   6786: aload_0
     //   6787: getfield m : LMedium;
     //   6790: getfield cz : I
     //   6793: isub
     //   6794: i2f
     //   6795: aload_0
     //   6796: getfield m : LMedium;
     //   6799: aload_0
     //   6800: getfield m : LMedium;
     //   6803: getfield xz : I
     //   6806: invokevirtual cos : (I)F
     //   6809: fmul
     //   6810: fadd
     //   6811: f2i
     //   6812: iadd
     //   6813: istore #7
     //   6815: aload_0
     //   6816: getfield m : LMedium;
     //   6819: getfield cy : I
     //   6822: aload_0
     //   6823: getfield co : [LContO;
     //   6826: aload_2
     //   6827: iload #5
     //   6829: iaload
     //   6830: aaload
     //   6831: getfield y : I
     //   6834: aload_0
     //   6835: getfield m : LMedium;
     //   6838: getfield y : I
     //   6841: isub
     //   6842: aload_0
     //   6843: getfield m : LMedium;
     //   6846: getfield cy : I
     //   6849: isub
     //   6850: i2f
     //   6851: aload_0
     //   6852: getfield m : LMedium;
     //   6855: aload_0
     //   6856: getfield m : LMedium;
     //   6859: getfield zy : I
     //   6862: invokevirtual cos : (I)F
     //   6865: fmul
     //   6866: iload #7
     //   6868: aload_0
     //   6869: getfield m : LMedium;
     //   6872: getfield cz : I
     //   6875: isub
     //   6876: i2f
     //   6877: aload_0
     //   6878: getfield m : LMedium;
     //   6881: aload_0
     //   6882: getfield m : LMedium;
     //   6885: getfield zy : I
     //   6888: invokevirtual sin : (I)F
     //   6891: fmul
     //   6892: fsub
     //   6893: f2i
     //   6894: iadd
     //   6895: istore #8
     //   6897: aload_0
     //   6898: getfield m : LMedium;
     //   6901: getfield cz : I
     //   6904: aload_0
     //   6905: getfield co : [LContO;
     //   6908: aload_2
     //   6909: iload #5
     //   6911: iaload
     //   6912: aaload
     //   6913: getfield y : I
     //   6916: aload_0
     //   6917: getfield m : LMedium;
     //   6920: getfield y : I
     //   6923: isub
     //   6924: aload_0
     //   6925: getfield m : LMedium;
     //   6928: getfield cy : I
     //   6931: isub
     //   6932: i2f
     //   6933: aload_0
     //   6934: getfield m : LMedium;
     //   6937: aload_0
     //   6938: getfield m : LMedium;
     //   6941: getfield zy : I
     //   6944: invokevirtual sin : (I)F
     //   6947: fmul
     //   6948: iload #7
     //   6950: aload_0
     //   6951: getfield m : LMedium;
     //   6954: getfield cz : I
     //   6957: isub
     //   6958: i2f
     //   6959: aload_0
     //   6960: getfield m : LMedium;
     //   6963: aload_0
     //   6964: getfield m : LMedium;
     //   6967: getfield zy : I
     //   6970: invokevirtual cos : (I)F
     //   6973: fmul
     //   6974: fadd
     //   6975: f2i
     //   6976: iadd
     //   6977: istore #9
     //   6979: ldc_w 1000000
     //   6982: aload_0
     //   6983: getfield sy : I
     //   6986: invokestatic abs : (I)I
     //   6989: idiv
     //   6990: istore #10
     //   6992: aload_0
     //   6993: getfield rd : Ljava/awt/Graphics2D;
     //   6996: astore #11
     //   6998: aload #11
     //   7000: iconst_3
     //   7001: ldc 0.5
     //   7003: invokestatic getInstance : (IF)Ljava/awt/AlphaComposite;
     //   7006: invokevirtual setComposite : (Ljava/awt/Composite;)V
     //   7009: aload_0
     //   7010: getfield rd : Ljava/awt/Graphics2D;
     //   7013: new java/awt/Color
     //   7016: dup
     //   7017: sipush #255
     //   7020: sipush #128
     //   7023: iconst_0
     //   7024: invokespecial <init> : (III)V
     //   7027: invokevirtual setColor : (Ljava/awt/Color;)V
     //   7030: aload_0
     //   7031: getfield rd : Ljava/awt/Graphics2D;
     //   7034: aload_0
     //   7035: iload #6
     //   7037: iload #9
     //   7039: invokevirtual xs : (II)I
     //   7042: iload #10
     //   7044: iconst_2
     //   7045: idiv
     //   7046: isub
     //   7047: aload_0
     //   7048: iload #8
     //   7050: iload #9
     //   7052: invokevirtual ys : (II)I
     //   7055: iload #10
     //   7057: iconst_2
     //   7058: idiv
     //   7059: isub
     //   7060: iload #10
     //   7062: iload #10
     //   7064: invokevirtual fillOval : (IIII)V
     //   7067: aload #11
     //   7069: iconst_3
     //   7070: fconst_1
     //   7071: invokestatic getInstance : (IF)Ljava/awt/AlphaComposite;
     //   7074: invokevirtual setComposite : (Ljava/awt/Composite;)V
     //   7077: aload_0
     //   7078: getfield rd : Ljava/awt/Graphics2D;
     //   7081: new java/awt/Color
     //   7084: dup
     //   7085: iconst_0
     //   7086: iconst_0
     //   7087: iconst_0
     //   7088: invokespecial <init> : (III)V
     //   7091: invokevirtual setColor : (Ljava/awt/Color;)V
     //   7094: aload_0
     //   7095: getfield rd : Ljava/awt/Graphics2D;
     //   7098: new java/awt/Font
     //   7101: dup
     //   7102: ldc_w 'Arial'
     //   7105: iconst_1
     //   7106: bipush #12
     //   7108: invokespecial <init> : (Ljava/lang/String;II)V
     //   7111: invokevirtual setFont : (Ljava/awt/Font;)V
     //   7114: aload_0
     //   7115: aload_0
     //   7116: getfield rd : Ljava/awt/Graphics2D;
     //   7119: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
     //   7122: putfield ftm : Ljava/awt/FontMetrics;
     //   7125: aload_0
     //   7126: getfield rd : Ljava/awt/Graphics2D;
     //   7129: new java/lang/StringBuilder
     //   7132: dup
     //   7133: invokespecial <init> : ()V
     //   7136: ldc_w 'NO# '
     //   7139: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   7142: aload_0
     //   7143: getfield co : [LContO;
     //   7146: aload_2
     //   7147: iload #5
     //   7149: iaload
     //   7150: aaload
     //   7151: getfield wh : I
     //   7154: invokevirtual append : (I)Ljava/lang/StringBuilder;
     //   7157: ldc ''
     //   7159: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   7162: invokevirtual toString : ()Ljava/lang/String;
     //   7165: aload_0
     //   7166: iload #6
     //   7168: iload #9
     //   7170: invokevirtual xs : (II)I
     //   7173: aload_0
     //   7174: getfield ftm : Ljava/awt/FontMetrics;
     //   7177: new java/lang/StringBuilder
     //   7180: dup
     //   7181: invokespecial <init> : ()V
     //   7184: ldc_w 'NO# '
     //   7187: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   7190: aload_0
     //   7191: getfield co : [LContO;
     //   7194: aload_2
     //   7195: iload #5
     //   7197: iaload
     //   7198: aaload
     //   7199: getfield wh : I
     //   7202: invokevirtual append : (I)Ljava/lang/StringBuilder;
     //   7205: ldc ''
     //   7207: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   7210: invokevirtual toString : ()Ljava/lang/String;
     //   7213: invokevirtual stringWidth : (Ljava/lang/String;)I
     //   7216: iconst_2
     //   7217: idiv
     //   7218: isub
     //   7219: aload_0
     //   7220: iload #8
     //   7222: iload #9
     //   7224: invokevirtual ys : (II)I
     //   7227: iload #10
     //   7229: iconst_2
     //   7230: idiv
     //   7231: isub
     //   7232: invokevirtual drawString : (Ljava/lang/String;II)V
     //   7235: goto_w -> 7240
     //   7240: aload_0
     //   7241: getfield co : [LContO;
     //   7244: aload_2
     //   7245: iload #5
     //   7247: iaload
     //   7248: aaload
     //   7249: aload_0
     //   7250: getfield rd : Ljava/awt/Graphics2D;
     //   7253: invokevirtual d : (Ljava/awt/Graphics2D;)V
     //   7256: aload_0
     //   7257: getfield m : LMedium;
     //   7260: getfield trk : I
     //   7263: iconst_3
     //   7264: if_icmpeq -> 7272
     //   7267: goto_w -> 7285
     //   7272: aload_0
     //   7273: getfield m : LMedium;
     //   7276: iconst_2
     //   7277: putfield trk : I
     //   7280: goto_w -> 7285
     //   7285: iinc #5, 1
     //   7288: goto_w -> 5813
     //   7293: iinc #4, 1
     //   7296: goto_w -> 5799
     //   7301: aload_0
     //   7302: getfield xm : I
     //   7305: sipush #248
     //   7308: if_icmpgt -> 7316
     //   7311: goto_w -> 13892
     //   7316: aload_0
     //   7317: getfield xm : I
     //   7320: sipush #762
     //   7323: if_icmplt -> 7331
     //   7326: goto_w -> 13892
     //   7331: aload_0
     //   7332: getfield ym : I
     //   7335: bipush #63
     //   7337: if_icmpgt -> 7345
     //   7340: goto_w -> 13892
     //   7345: aload_0
     //   7346: getfield ym : I
     //   7349: sipush #517
     //   7352: if_icmplt -> 7360
     //   7355: goto_w -> 13892
     //   7360: aload_0
     //   7361: getfield epart : Z
     //   7364: ifeq -> 7372
     //   7367: goto_w -> 12187
     //   7372: aload_0
     //   7373: getfield arrng : Z
     //   7376: ifeq -> 7384
     //   7379: goto_w -> 12187
     //   7384: aload_0
     //   7385: getfield bco : [LContO;
     //   7388: aload_0
     //   7389: getfield sp : I
     //   7392: aaload
     //   7393: aload_0
     //   7394: getfield xm : I
     //   7397: sipush #505
     //   7400: isub
     //   7401: aload_0
     //   7402: getfield sy : I
     //   7405: invokestatic abs : (I)I
     //   7408: aload_0
     //   7409: getfield m : LMedium;
     //   7412: getfield focus_point : I
     //   7415: idiv
     //   7416: imul
     //   7417: aload_0
     //   7418: getfield sx : I
     //   7421: iadd
     //   7422: putfield x : I
     //   7425: aload_0
     //   7426: getfield bco : [LContO;
     //   7429: aload_0
     //   7430: getfield sp : I
     //   7433: aaload
     //   7434: sipush #290
     //   7437: aload_0
     //   7438: getfield ym : I
     //   7441: isub
     //   7442: aload_0
     //   7443: getfield sy : I
     //   7446: invokestatic abs : (I)I
     //   7449: aload_0
     //   7450: getfield m : LMedium;
     //   7453: getfield focus_point : I
     //   7456: idiv
     //   7457: imul
     //   7458: aload_0
     //   7459: getfield sz : I
     //   7462: iadd
     //   7463: putfield z : I
     //   7466: aload_0
     //   7467: getfield bco : [LContO;
     //   7470: aload_0
     //   7471: getfield sp : I
     //   7474: aaload
     //   7475: aload_0
     //   7476: getfield m : LMedium;
     //   7479: getfield ground : I
     //   7482: aload_0
     //   7483: getfield bco : [LContO;
     //   7486: aload_0
     //   7487: getfield sp : I
     //   7490: aaload
     //   7491: getfield grat : I
     //   7494: isub
     //   7495: putfield y : I
     //   7498: aload_0
     //   7499: getfield bco : [LContO;
     //   7502: aload_0
     //   7503: getfield sp : I
     //   7506: aaload
     //   7507: aload_0
     //   7508: getfield rot : I
     //   7511: aload_0
     //   7512: getfield adrot : I
     //   7515: iadd
     //   7516: putfield xz : I
     //   7519: sipush #200
     //   7522: istore #4
     //   7524: iconst_0
     //   7525: istore #5
     //   7527: iconst_0
     //   7528: istore #6
     //   7530: iconst_2
     //   7531: newarray int
     //   7533: dup
     //   7534: iconst_0
     //   7535: aload_0
     //   7536: getfield bco : [LContO;
     //   7539: aload_0
     //   7540: getfield sp : I
     //   7543: aaload
     //   7544: getfield x : I
     //   7547: aload_0
     //   7548: getfield atp : [[I
     //   7551: aload_0
     //   7552: getfield sp : I
     //   7555: aaload
     //   7556: iconst_0
     //   7557: iaload
     //   7558: iadd
     //   7559: iastore
     //   7560: dup
     //   7561: iconst_1
     //   7562: aload_0
     //   7563: getfield bco : [LContO;
     //   7566: aload_0
     //   7567: getfield sp : I
     //   7570: aaload
     //   7571: getfield x : I
     //   7574: aload_0
     //   7575: getfield atp : [[I
     //   7578: aload_0
     //   7579: getfield sp : I
     //   7582: aaload
     //   7583: iconst_2
     //   7584: iaload
     //   7585: iadd
     //   7586: iastore
     //   7587: astore #7
     //   7589: iconst_2
     //   7590: newarray int
     //   7592: dup
     //   7593: iconst_0
     //   7594: aload_0
     //   7595: getfield bco : [LContO;
     //   7598: aload_0
     //   7599: getfield sp : I
     //   7602: aaload
     //   7603: getfield z : I
     //   7606: aload_0
     //   7607: getfield atp : [[I
     //   7610: aload_0
     //   7611: getfield sp : I
     //   7614: aaload
     //   7615: iconst_1
     //   7616: iaload
     //   7617: iadd
     //   7618: iastore
     //   7619: dup
     //   7620: iconst_1
     //   7621: aload_0
     //   7622: getfield bco : [LContO;
     //   7625: aload_0
     //   7626: getfield sp : I
     //   7629: aaload
     //   7630: getfield z : I
     //   7633: aload_0
     //   7634: getfield atp : [[I
     //   7637: aload_0
     //   7638: getfield sp : I
     //   7641: aaload
     //   7642: iconst_3
     //   7643: iaload
     //   7644: iadd
     //   7645: iastore
     //   7646: astore #8
     //   7648: aload_0
     //   7649: aload #7
     //   7651: aload #8
     //   7653: aload_0
     //   7654: getfield bco : [LContO;
     //   7657: aload_0
     //   7658: getfield sp : I
     //   7661: aaload
     //   7662: getfield x : I
     //   7665: aload_0
     //   7666: getfield bco : [LContO;
     //   7669: aload_0
     //   7670: getfield sp : I
     //   7673: aaload
     //   7674: getfield z : I
     //   7677: aload_0
     //   7678: getfield rot : I
     //   7681: iconst_2
     //   7682: invokevirtual rot : ([I[IIIII)V
     //   7685: iconst_0
     //   7686: istore #9
     //   7688: aload_0
     //   7689: iconst_0
     //   7690: putfield onfly : Z
     //   7693: sipush #500
     //   7696: istore #10
     //   7698: iconst_0
     //   7699: istore #11
     //   7701: iload #11
     //   7703: aload_0
     //   7704: getfield nob : I
     //   7707: if_icmplt -> 7715
     //   7710: goto_w -> 10423
     //   7715: iconst_2
     //   7716: newarray int
     //   7718: dup
     //   7719: iconst_0
     //   7720: aload_0
     //   7721: getfield co : [LContO;
     //   7724: iload #11
     //   7726: aaload
     //   7727: getfield x : I
     //   7730: aload_0
     //   7731: getfield atp : [[I
     //   7734: aload_0
     //   7735: getfield co : [LContO;
     //   7738: iload #11
     //   7740: aaload
     //   7741: getfield colok : I
     //   7744: aaload
     //   7745: iconst_0
     //   7746: iaload
     //   7747: iadd
     //   7748: iastore
     //   7749: dup
     //   7750: iconst_1
     //   7751: aload_0
     //   7752: getfield co : [LContO;
     //   7755: iload #11
     //   7757: aaload
     //   7758: getfield x : I
     //   7761: aload_0
     //   7762: getfield atp : [[I
     //   7765: aload_0
     //   7766: getfield co : [LContO;
     //   7769: iload #11
     //   7771: aaload
     //   7772: getfield colok : I
     //   7775: aaload
     //   7776: iconst_2
     //   7777: iaload
     //   7778: iadd
     //   7779: iastore
     //   7780: astore #12
     //   7782: iconst_2
     //   7783: newarray int
     //   7785: dup
     //   7786: iconst_0
     //   7787: aload_0
     //   7788: getfield co : [LContO;
     //   7791: iload #11
     //   7793: aaload
     //   7794: getfield z : I
     //   7797: aload_0
     //   7798: getfield atp : [[I
     //   7801: aload_0
     //   7802: getfield co : [LContO;
     //   7805: iload #11
     //   7807: aaload
     //   7808: getfield colok : I
     //   7811: aaload
     //   7812: iconst_1
     //   7813: iaload
     //   7814: iadd
     //   7815: iastore
     //   7816: dup
     //   7817: iconst_1
     //   7818: aload_0
     //   7819: getfield co : [LContO;
     //   7822: iload #11
     //   7824: aaload
     //   7825: getfield z : I
     //   7828: aload_0
     //   7829: getfield atp : [[I
     //   7832: aload_0
     //   7833: getfield co : [LContO;
     //   7836: iload #11
     //   7838: aaload
     //   7839: getfield colok : I
     //   7842: aaload
     //   7843: iconst_3
     //   7844: iaload
     //   7845: iadd
     //   7846: iastore
     //   7847: astore #13
     //   7849: aload_0
     //   7850: getfield co : [LContO;
     //   7853: iload #11
     //   7855: aaload
     //   7856: getfield roofat : I
     //   7859: istore #14
     //   7861: aload_0
     //   7862: getfield co : [LContO;
     //   7865: iload #11
     //   7867: aaload
     //   7868: getfield colok : I
     //   7871: iconst_2
     //   7872: if_icmpeq -> 7880
     //   7875: goto_w -> 7888
     //   7880: iinc #14, 30
     //   7883: goto_w -> 7888
     //   7888: aload_0
     //   7889: getfield co : [LContO;
     //   7892: iload #11
     //   7894: aaload
     //   7895: getfield colok : I
     //   7898: iconst_3
     //   7899: if_icmpeq -> 7907
     //   7902: goto_w -> 7915
     //   7907: iinc #14, -30
     //   7910: goto_w -> 7915
     //   7915: aload_0
     //   7916: getfield co : [LContO;
     //   7919: iload #11
     //   7921: aaload
     //   7922: getfield colok : I
     //   7925: bipush #15
     //   7927: if_icmpeq -> 7935
     //   7930: goto_w -> 7943
     //   7935: iinc #14, -90
     //   7938: goto_w -> 7943
     //   7943: aload_0
     //   7944: getfield co : [LContO;
     //   7947: iload #11
     //   7949: aaload
     //   7950: getfield colok : I
     //   7953: bipush #20
     //   7955: if_icmpeq -> 7963
     //   7958: goto_w -> 7974
     //   7963: wide iinc #14 -180
     //   7969: goto_w -> 7974
     //   7974: aload_0
     //   7975: getfield co : [LContO;
     //   7978: iload #11
     //   7980: aaload
     //   7981: getfield colok : I
     //   7984: bipush #26
     //   7986: if_icmpeq -> 7994
     //   7989: goto_w -> 8002
     //   7994: iinc #14, -90
     //   7997: goto_w -> 8002
     //   8002: aload_0
     //   8003: aload #12
     //   8005: aload #13
     //   8007: aload_0
     //   8008: getfield co : [LContO;
     //   8011: iload #11
     //   8013: aaload
     //   8014: getfield x : I
     //   8017: aload_0
     //   8018: getfield co : [LContO;
     //   8021: iload #11
     //   8023: aaload
     //   8024: getfield z : I
     //   8027: iload #14
     //   8029: iconst_2
     //   8030: invokevirtual rot : ([I[IIIII)V
     //   8033: aload_0
     //   8034: getfield sp : I
     //   8037: bipush #54
     //   8039: if_icmple -> 8047
     //   8042: goto_w -> 8352
     //   8047: aload_0
     //   8048: aload #12
     //   8050: iconst_0
     //   8051: iaload
     //   8052: aload #7
     //   8054: iconst_0
     //   8055: iaload
     //   8056: aload #13
     //   8058: iconst_0
     //   8059: iaload
     //   8060: aload #8
     //   8062: iconst_0
     //   8063: iaload
     //   8064: invokevirtual py : (IIII)I
     //   8067: istore #15
     //   8069: iload #15
     //   8071: iload #4
     //   8073: if_icmplt -> 8081
     //   8076: goto_w -> 8122
     //   8081: iload #15
     //   8083: ifne -> 8091
     //   8086: goto_w -> 8122
     //   8091: iload #15
     //   8093: istore #4
     //   8095: aload #12
     //   8097: iconst_0
     //   8098: iaload
     //   8099: aload #7
     //   8101: iconst_0
     //   8102: iaload
     //   8103: isub
     //   8104: istore #5
     //   8106: aload #13
     //   8108: iconst_0
     //   8109: iaload
     //   8110: aload #8
     //   8112: iconst_0
     //   8113: iaload
     //   8114: isub
     //   8115: istore #6
     //   8117: goto_w -> 8122
     //   8122: aload_0
     //   8123: aload #12
     //   8125: iconst_1
     //   8126: iaload
     //   8127: aload #7
     //   8129: iconst_0
     //   8130: iaload
     //   8131: aload #13
     //   8133: iconst_1
     //   8134: iaload
     //   8135: aload #8
     //   8137: iconst_0
     //   8138: iaload
     //   8139: invokevirtual py : (IIII)I
     //   8142: istore #15
     //   8144: iload #15
     //   8146: iload #4
     //   8148: if_icmplt -> 8156
     //   8151: goto_w -> 8197
     //   8156: iload #15
     //   8158: ifne -> 8166
     //   8161: goto_w -> 8197
     //   8166: iload #15
     //   8168: istore #4
     //   8170: aload #12
     //   8172: iconst_1
     //   8173: iaload
     //   8174: aload #7
     //   8176: iconst_0
     //   8177: iaload
     //   8178: isub
     //   8179: istore #5
     //   8181: aload #13
     //   8183: iconst_1
     //   8184: iaload
     //   8185: aload #8
     //   8187: iconst_0
     //   8188: iaload
     //   8189: isub
     //   8190: istore #6
     //   8192: goto_w -> 8197
     //   8197: aload_0
     //   8198: aload #12
     //   8200: iconst_1
     //   8201: iaload
     //   8202: aload #7
     //   8204: iconst_1
     //   8205: iaload
     //   8206: aload #13
     //   8208: iconst_1
     //   8209: iaload
     //   8210: aload #8
     //   8212: iconst_1
     //   8213: iaload
     //   8214: invokevirtual py : (IIII)I
     //   8217: istore #15
     //   8219: iload #15
     //   8221: iload #4
     //   8223: if_icmplt -> 8231
     //   8226: goto_w -> 8272
     //   8231: iload #15
     //   8233: ifne -> 8241
     //   8236: goto_w -> 8272
     //   8241: iload #15
     //   8243: istore #4
     //   8245: aload #12
     //   8247: iconst_1
     //   8248: iaload
     //   8249: aload #7
     //   8251: iconst_1
     //   8252: iaload
     //   8253: isub
     //   8254: istore #5
     //   8256: aload #13
     //   8258: iconst_1
     //   8259: iaload
     //   8260: aload #8
     //   8262: iconst_1
     //   8263: iaload
     //   8264: isub
     //   8265: istore #6
     //   8267: goto_w -> 8272
     //   8272: aload_0
     //   8273: aload #12
     //   8275: iconst_0
     //   8276: iaload
     //   8277: aload #7
     //   8279: iconst_1
     //   8280: iaload
     //   8281: aload #13
     //   8283: iconst_0
     //   8284: iaload
     //   8285: aload #8
     //   8287: iconst_1
     //   8288: iaload
     //   8289: invokevirtual py : (IIII)I
     //   8292: istore #15
     //   8294: iload #15
     //   8296: iload #4
     //   8298: if_icmplt -> 8306
     //   8301: goto_w -> 8347
     //   8306: iload #15
     //   8308: ifne -> 8316
     //   8311: goto_w -> 8347
     //   8316: iload #15
     //   8318: istore #4
     //   8320: aload #12
     //   8322: iconst_0
     //   8323: iaload
     //   8324: aload #7
     //   8326: iconst_1
     //   8327: iaload
     //   8328: isub
     //   8329: istore #5
     //   8331: aload #13
     //   8333: iconst_0
     //   8334: iaload
     //   8335: aload #8
     //   8337: iconst_1
     //   8338: iaload
     //   8339: isub
     //   8340: istore #6
     //   8342: goto_w -> 8347
     //   8347: goto_w -> 8352
     //   8352: aload_0
     //   8353: getfield sptyp : I
     //   8356: iconst_3
     //   8357: if_icmpeq -> 8365
     //   8360: goto_w -> 8796
     //   8365: aload_0
     //   8366: aload #12
     //   8368: iconst_0
     //   8369: iaload
     //   8370: aload #7
     //   8372: iconst_0
     //   8373: iaload
     //   8374: aload #13
     //   8376: iconst_0
     //   8377: iaload
     //   8378: aload #8
     //   8380: iconst_0
     //   8381: iaload
     //   8382: invokevirtual py : (IIII)I
     //   8385: ifne -> 8393
     //   8388: goto_w -> 8796
     //   8393: aload_0
     //   8394: aload #12
     //   8396: iconst_1
     //   8397: iaload
     //   8398: aload #7
     //   8400: iconst_0
     //   8401: iaload
     //   8402: aload #13
     //   8404: iconst_1
     //   8405: iaload
     //   8406: aload #8
     //   8408: iconst_0
     //   8409: iaload
     //   8410: invokevirtual py : (IIII)I
     //   8413: ifne -> 8421
     //   8416: goto_w -> 8796
     //   8421: iconst_0
     //   8422: istore #15
     //   8424: iload #15
     //   8426: aload_0
     //   8427: getfield rcheckp : [I
     //   8430: arraylength
     //   8431: if_icmplt -> 8439
     //   8434: goto_w -> 8606
     //   8439: aload_0
     //   8440: getfield co : [LContO;
     //   8443: iload #11
     //   8445: aaload
     //   8446: getfield colok : I
     //   8449: aload_0
     //   8450: getfield rcheckp : [I
     //   8453: iload #15
     //   8455: iaload
     //   8456: if_icmpeq -> 8464
     //   8459: goto_w -> 8598
     //   8464: aload_0
     //   8465: aload #12
     //   8467: iconst_0
     //   8468: iaload
     //   8469: aload #7
     //   8471: iconst_0
     //   8472: iaload
     //   8473: aload #13
     //   8475: iconst_0
     //   8476: iaload
     //   8477: aload #8
     //   8479: iconst_0
     //   8480: iaload
     //   8481: invokevirtual py : (IIII)I
     //   8484: iload #9
     //   8486: if_icmpgt -> 8494
     //   8489: goto_w -> 8504
     //   8494: iload #9
     //   8496: ifeq -> 8504
     //   8499: goto_w -> 8536
     //   8504: aload_0
     //   8505: aload #12
     //   8507: iconst_0
     //   8508: iaload
     //   8509: aload #7
     //   8511: iconst_0
     //   8512: iaload
     //   8513: aload #13
     //   8515: iconst_0
     //   8516: iaload
     //   8517: aload #8
     //   8519: iconst_0
     //   8520: iaload
     //   8521: invokevirtual py : (IIII)I
     //   8524: istore #9
     //   8526: aload_0
     //   8527: iconst_0
     //   8528: putfield onoff : Z
     //   8531: goto_w -> 8536
     //   8536: aload_0
     //   8537: aload #12
     //   8539: iconst_1
     //   8540: iaload
     //   8541: aload #7
     //   8543: iconst_0
     //   8544: iaload
     //   8545: aload #13
     //   8547: iconst_1
     //   8548: iaload
     //   8549: aload #8
     //   8551: iconst_0
     //   8552: iaload
     //   8553: invokevirtual py : (IIII)I
     //   8556: iload #9
     //   8558: if_icmple -> 8566
     //   8561: goto_w -> 8598
     //   8566: aload_0
     //   8567: aload #12
     //   8569: iconst_1
     //   8570: iaload
     //   8571: aload #7
     //   8573: iconst_0
     //   8574: iaload
     //   8575: aload #13
     //   8577: iconst_1
     //   8578: iaload
     //   8579: aload #8
     //   8581: iconst_0
     //   8582: iaload
     //   8583: invokevirtual py : (IIII)I
     //   8586: istore #9
     //   8588: aload_0
     //   8589: iconst_0
     //   8590: putfield onoff : Z
     //   8593: goto_w -> 8598
     //   8598: iinc #15, 1
     //   8601: goto_w -> 8424
     //   8606: iconst_0
     //   8607: istore #15
     //   8609: iload #15
     //   8611: aload_0
     //   8612: getfield ocheckp : [I
     //   8615: arraylength
     //   8616: if_icmplt -> 8624
     //   8619: goto_w -> 8791
     //   8624: aload_0
     //   8625: getfield co : [LContO;
     //   8628: iload #11
     //   8630: aaload
     //   8631: getfield colok : I
     //   8634: aload_0
     //   8635: getfield ocheckp : [I
     //   8638: iload #15
     //   8640: iaload
     //   8641: if_icmpeq -> 8649
     //   8644: goto_w -> 8783
     //   8649: aload_0
     //   8650: aload #12
     //   8652: iconst_0
     //   8653: iaload
     //   8654: aload #7
     //   8656: iconst_0
     //   8657: iaload
     //   8658: aload #13
     //   8660: iconst_0
     //   8661: iaload
     //   8662: aload #8
     //   8664: iconst_0
     //   8665: iaload
     //   8666: invokevirtual py : (IIII)I
     //   8669: iload #9
     //   8671: if_icmpgt -> 8679
     //   8674: goto_w -> 8689
     //   8679: iload #9
     //   8681: ifeq -> 8689
     //   8684: goto_w -> 8721
     //   8689: aload_0
     //   8690: aload #12
     //   8692: iconst_0
     //   8693: iaload
     //   8694: aload #7
     //   8696: iconst_0
     //   8697: iaload
     //   8698: aload #13
     //   8700: iconst_0
     //   8701: iaload
     //   8702: aload #8
     //   8704: iconst_0
     //   8705: iaload
     //   8706: invokevirtual py : (IIII)I
     //   8709: istore #9
     //   8711: aload_0
     //   8712: iconst_1
     //   8713: putfield onoff : Z
     //   8716: goto_w -> 8721
     //   8721: aload_0
     //   8722: aload #12
     //   8724: iconst_1
     //   8725: iaload
     //   8726: aload #7
     //   8728: iconst_0
     //   8729: iaload
     //   8730: aload #13
     //   8732: iconst_1
     //   8733: iaload
     //   8734: aload #8
     //   8736: iconst_0
     //   8737: iaload
     //   8738: invokevirtual py : (IIII)I
     //   8741: iload #9
     //   8743: if_icmple -> 8751
     //   8746: goto_w -> 8783
     //   8751: aload_0
     //   8752: aload #12
     //   8754: iconst_1
     //   8755: iaload
     //   8756: aload #7
     //   8758: iconst_0
     //   8759: iaload
     //   8760: aload #13
     //   8762: iconst_1
     //   8763: iaload
     //   8764: aload #8
     //   8766: iconst_0
     //   8767: iaload
     //   8768: invokevirtual py : (IIII)I
     //   8771: istore #9
     //   8773: aload_0
     //   8774: iconst_1
     //   8775: putfield onoff : Z
     //   8778: goto_w -> 8783
     //   8783: iinc #15, 1
     //   8786: goto_w -> 8609
     //   8791: goto_w -> 8796
     //   8796: aload_0
     //   8797: getfield sp : I
     //   8800: bipush #12
     //   8802: if_icmpgt -> 8810
     //   8805: goto_w -> 8824
     //   8810: aload_0
     //   8811: getfield sp : I
     //   8814: bipush #33
     //   8816: if_icmpge -> 8824
     //   8819: goto_w -> 8880
     //   8824: aload_0
     //   8825: getfield sp : I
     //   8828: bipush #35
     //   8830: if_icmpne -> 8838
     //   8833: goto_w -> 8880
     //   8838: aload_0
     //   8839: getfield sp : I
     //   8842: bipush #36
     //   8844: if_icmpne -> 8852
     //   8847: goto_w -> 8880
     //   8852: aload_0
     //   8853: getfield sp : I
     //   8856: bipush #39
     //   8858: if_icmpge -> 8866
     //   8861: goto_w -> 9406
     //   8866: aload_0
     //   8867: getfield sp : I
     //   8870: bipush #54
     //   8872: if_icmple -> 8880
     //   8875: goto_w -> 9406
     //   8880: aload_0
     //   8881: getfield rot : I
     //   8884: ifne -> 8892
     //   8887: goto_w -> 8935
     //   8892: aload_0
     //   8893: getfield rot : I
     //   8896: sipush #180
     //   8899: if_icmpne -> 8907
     //   8902: goto_w -> 8935
     //   8907: aload_0
     //   8908: getfield sp : I
     //   8911: bipush #26
     //   8913: if_icmpne -> 8921
     //   8916: goto_w -> 8935
     //   8921: aload_0
     //   8922: getfield sp : I
     //   8925: bipush #15
     //   8927: if_icmpeq -> 8935
     //   8930: goto_w -> 9142
     //   8935: iload #14
     //   8937: ifne -> 8945
     //   8940: goto_w -> 8986
     //   8945: iload #14
     //   8947: sipush #180
     //   8950: if_icmpne -> 8958
     //   8953: goto_w -> 8986
     //   8958: aload_0
     //   8959: getfield sp : I
     //   8962: bipush #26
     //   8964: if_icmpne -> 8972
     //   8967: goto_w -> 8986
     //   8972: aload_0
     //   8973: getfield sp : I
     //   8976: bipush #15
     //   8978: if_icmpeq -> 8986
     //   8981: goto_w -> 9142
     //   8986: aload #12
     //   8988: iconst_0
     //   8989: iaload
     //   8990: aload #7
     //   8992: iconst_0
     //   8993: iaload
     //   8994: isub
     //   8995: invokestatic abs : (I)I
     //   8998: sipush #200
     //   9001: if_icmplt -> 9009
     //   9004: goto_w -> 9025
     //   9009: aload #12
     //   9011: iconst_0
     //   9012: iaload
     //   9013: aload #7
     //   9015: iconst_0
     //   9016: iaload
     //   9017: isub
     //   9018: istore #5
     //   9020: goto_w -> 9025
     //   9025: aload #12
     //   9027: iconst_0
     //   9028: iaload
     //   9029: aload #7
     //   9031: iconst_1
     //   9032: iaload
     //   9033: isub
     //   9034: invokestatic abs : (I)I
     //   9037: sipush #200
     //   9040: if_icmplt -> 9048
     //   9043: goto_w -> 9064
     //   9048: aload #12
     //   9050: iconst_0
     //   9051: iaload
     //   9052: aload #7
     //   9054: iconst_1
     //   9055: iaload
     //   9056: isub
     //   9057: istore #5
     //   9059: goto_w -> 9064
     //   9064: aload #12
     //   9066: iconst_1
     //   9067: iaload
     //   9068: aload #7
     //   9070: iconst_1
     //   9071: iaload
     //   9072: isub
     //   9073: invokestatic abs : (I)I
     //   9076: sipush #200
     //   9079: if_icmplt -> 9087
     //   9082: goto_w -> 9103
     //   9087: aload #12
     //   9089: iconst_1
     //   9090: iaload
     //   9091: aload #7
     //   9093: iconst_1
     //   9094: iaload
     //   9095: isub
     //   9096: istore #5
     //   9098: goto_w -> 9103
     //   9103: aload #12
     //   9105: iconst_1
     //   9106: iaload
     //   9107: aload #7
     //   9109: iconst_0
     //   9110: iaload
     //   9111: isub
     //   9112: invokestatic abs : (I)I
     //   9115: sipush #200
     //   9118: if_icmplt -> 9126
     //   9121: goto_w -> 9142
     //   9126: aload #12
     //   9128: iconst_1
     //   9129: iaload
     //   9130: aload #7
     //   9132: iconst_0
     //   9133: iaload
     //   9134: isub
     //   9135: istore #5
     //   9137: goto_w -> 9142
     //   9142: aload_0
     //   9143: getfield rot : I
     //   9146: bipush #90
     //   9148: if_icmpne -> 9156
     //   9151: goto_w -> 9198
     //   9156: aload_0
     //   9157: getfield rot : I
     //   9160: bipush #-90
     //   9162: if_icmpne -> 9170
     //   9165: goto_w -> 9198
     //   9170: aload_0
     //   9171: getfield sp : I
     //   9174: bipush #26
     //   9176: if_icmpne -> 9184
     //   9179: goto_w -> 9198
     //   9184: aload_0
     //   9185: getfield sp : I
     //   9188: bipush #15
     //   9190: if_icmpeq -> 9198
     //   9193: goto_w -> 9406
     //   9198: iload #14
     //   9200: bipush #90
     //   9202: if_icmpne -> 9210
     //   9205: goto_w -> 9250
     //   9210: iload #14
     //   9212: bipush #-90
     //   9214: if_icmpne -> 9222
     //   9217: goto_w -> 9250
     //   9222: aload_0
     //   9223: getfield sp : I
     //   9226: bipush #26
     //   9228: if_icmpne -> 9236
     //   9231: goto_w -> 9250
     //   9236: aload_0
     //   9237: getfield sp : I
     //   9240: bipush #15
     //   9242: if_icmpeq -> 9250
     //   9245: goto_w -> 9406
     //   9250: aload #13
     //   9252: iconst_0
     //   9253: iaload
     //   9254: aload #8
     //   9256: iconst_0
     //   9257: iaload
     //   9258: isub
     //   9259: invokestatic abs : (I)I
     //   9262: sipush #200
     //   9265: if_icmplt -> 9273
     //   9268: goto_w -> 9289
     //   9273: aload #13
     //   9275: iconst_0
     //   9276: iaload
     //   9277: aload #8
     //   9279: iconst_0
     //   9280: iaload
     //   9281: isub
     //   9282: istore #6
     //   9284: goto_w -> 9289
     //   9289: aload #13
     //   9291: iconst_0
     //   9292: iaload
     //   9293: aload #8
     //   9295: iconst_1
     //   9296: iaload
     //   9297: isub
     //   9298: invokestatic abs : (I)I
     //   9301: sipush #200
     //   9304: if_icmplt -> 9312
     //   9307: goto_w -> 9328
     //   9312: aload #13
     //   9314: iconst_0
     //   9315: iaload
     //   9316: aload #8
     //   9318: iconst_1
     //   9319: iaload
     //   9320: isub
     //   9321: istore #6
     //   9323: goto_w -> 9328
     //   9328: aload #13
     //   9330: iconst_1
     //   9331: iaload
     //   9332: aload #8
     //   9334: iconst_1
     //   9335: iaload
     //   9336: isub
     //   9337: invokestatic abs : (I)I
     //   9340: sipush #200
     //   9343: if_icmplt -> 9351
     //   9346: goto_w -> 9367
     //   9351: aload #13
     //   9353: iconst_1
     //   9354: iaload
     //   9355: aload #8
     //   9357: iconst_1
     //   9358: iaload
     //   9359: isub
     //   9360: istore #6
     //   9362: goto_w -> 9367
     //   9367: aload #13
     //   9369: iconst_1
     //   9370: iaload
     //   9371: aload #8
     //   9373: iconst_0
     //   9374: iaload
     //   9375: isub
     //   9376: invokestatic abs : (I)I
     //   9379: sipush #200
     //   9382: if_icmplt -> 9390
     //   9385: goto_w -> 9406
     //   9390: aload #13
     //   9392: iconst_1
     //   9393: iaload
     //   9394: aload #8
     //   9396: iconst_0
     //   9397: iaload
     //   9398: isub
     //   9399: istore #6
     //   9401: goto_w -> 9406
     //   9406: aload_0
     //   9407: getfield sptyp : I
     //   9410: iconst_3
     //   9411: if_icmpeq -> 9419
     //   9414: goto_w -> 10415
     //   9419: aload_0
     //   9420: getfield co : [LContO;
     //   9423: iload #11
     //   9425: aaload
     //   9426: getfield colok : I
     //   9429: bipush #46
     //   9431: if_icmpge -> 9439
     //   9434: goto_w -> 10415
     //   9439: aload_0
     //   9440: getfield co : [LContO;
     //   9443: iload #11
     //   9445: aaload
     //   9446: getfield colok : I
     //   9449: bipush #51
     //   9451: if_icmple -> 9459
     //   9454: goto_w -> 10415
     //   9459: bipush #6
     //   9461: newarray int
     //   9463: dup
     //   9464: iconst_0
     //   9465: iconst_2
     //   9466: iastore
     //   9467: dup
     //   9468: iconst_1
     //   9469: iconst_3
     //   9470: iastore
     //   9471: dup
     //   9472: iconst_2
     //   9473: iconst_5
     //   9474: iastore
     //   9475: dup
     //   9476: iconst_3
     //   9477: iconst_2
     //   9478: iastore
     //   9479: dup
     //   9480: iconst_4
     //   9481: iconst_3
     //   9482: iastore
     //   9483: dup
     //   9484: iconst_5
     //   9485: iconst_3
     //   9486: iastore
     //   9487: astore #15
     //   9489: aload_0
     //   9490: getfield co : [LContO;
     //   9493: iload #11
     //   9495: aaload
     //   9496: getfield roofat : I
     //   9499: invokestatic abs : (I)I
     //   9502: sipush #180
     //   9505: if_icmpne -> 9513
     //   9508: goto_w -> 9531
     //   9513: aload_0
     //   9514: getfield co : [LContO;
     //   9517: iload #11
     //   9519: aaload
     //   9520: getfield roofat : I
     //   9523: ifeq -> 9531
     //   9526: goto_w -> 9958
     //   9531: aload_0
     //   9532: getfield rot : I
     //   9535: ifeq -> 9543
     //   9538: goto_w -> 9958
     //   9543: aload_0
     //   9544: getfield bco : [LContO;
     //   9547: aload_0
     //   9548: getfield sp : I
     //   9551: aaload
     //   9552: getfield x : I
     //   9555: aload_0
     //   9556: getfield co : [LContO;
     //   9559: iload #11
     //   9561: aaload
     //   9562: getfield x : I
     //   9565: isub
     //   9566: invokestatic abs : (I)I
     //   9569: sipush #500
     //   9572: if_icmplt -> 9580
     //   9575: goto_w -> 9958
     //   9580: aload_0
     //   9581: getfield bco : [LContO;
     //   9584: aload_0
     //   9585: getfield sp : I
     //   9588: aaload
     //   9589: getfield z : I
     //   9592: aload_0
     //   9593: getfield co : [LContO;
     //   9596: iload #11
     //   9598: aaload
     //   9599: getfield z : I
     //   9602: isub
     //   9603: invokestatic abs : (I)I
     //   9606: sipush #3000
     //   9609: if_icmplt -> 9617
     //   9612: goto_w -> 9958
     //   9617: iconst_0
     //   9618: istore #16
     //   9620: iload #16
     //   9622: aload #15
     //   9624: aload_0
     //   9625: getfield co : [LContO;
     //   9628: iload #11
     //   9630: aaload
     //   9631: getfield colok : I
     //   9634: bipush #46
     //   9636: isub
     //   9637: iaload
     //   9638: if_icmplt -> 9646
     //   9641: goto_w -> 9953
     //   9646: iconst_0
     //   9647: istore #17
     //   9649: iload #17
     //   9651: aload_0
     //   9652: getfield co : [LContO;
     //   9655: iload #11
     //   9657: aaload
     //   9658: getfield p : [LPlane;
     //   9661: iload #16
     //   9663: aaload
     //   9664: getfield n : I
     //   9667: if_icmplt -> 9675
     //   9670: goto_w -> 9945
     //   9675: aload_0
     //   9676: aload_0
     //   9677: getfield bco : [LContO;
     //   9680: aload_0
     //   9681: getfield sp : I
     //   9684: aaload
     //   9685: getfield x : I
     //   9688: aload_0
     //   9689: getfield co : [LContO;
     //   9692: iload #11
     //   9694: aaload
     //   9695: getfield x : I
     //   9698: aload_0
     //   9699: getfield bco : [LContO;
     //   9702: aload_0
     //   9703: getfield sp : I
     //   9706: aaload
     //   9707: getfield z : I
     //   9710: aload_0
     //   9711: getfield co : [LContO;
     //   9714: iload #11
     //   9716: aaload
     //   9717: getfield z : I
     //   9720: aload_0
     //   9721: getfield co : [LContO;
     //   9724: iload #11
     //   9726: aaload
     //   9727: getfield p : [LPlane;
     //   9730: iload #16
     //   9732: aaload
     //   9733: getfield oz : [I
     //   9736: iload #17
     //   9738: iaload
     //   9739: iadd
     //   9740: invokevirtual py : (IIII)I
     //   9743: iload #10
     //   9745: if_icmplt -> 9753
     //   9748: goto_w -> 9937
     //   9753: aload_0
     //   9754: aload_0
     //   9755: getfield bco : [LContO;
     //   9758: aload_0
     //   9759: getfield sp : I
     //   9762: aaload
     //   9763: getfield x : I
     //   9766: aload_0
     //   9767: getfield co : [LContO;
     //   9770: iload #11
     //   9772: aaload
     //   9773: getfield x : I
     //   9776: aload_0
     //   9777: getfield bco : [LContO;
     //   9780: aload_0
     //   9781: getfield sp : I
     //   9784: aaload
     //   9785: getfield z : I
     //   9788: aload_0
     //   9789: getfield co : [LContO;
     //   9792: iload #11
     //   9794: aaload
     //   9795: getfield z : I
     //   9798: aload_0
     //   9799: getfield co : [LContO;
     //   9802: iload #11
     //   9804: aaload
     //   9805: getfield p : [LPlane;
     //   9808: iload #16
     //   9810: aaload
     //   9811: getfield oz : [I
     //   9814: iload #17
     //   9816: iaload
     //   9817: iadd
     //   9818: invokevirtual py : (IIII)I
     //   9821: istore #10
     //   9823: aload_0
     //   9824: aload_0
     //   9825: getfield co : [LContO;
     //   9828: iload #11
     //   9830: aaload
     //   9831: getfield p : [LPlane;
     //   9834: iload #16
     //   9836: aaload
     //   9837: getfield oy : [I
     //   9840: iload #17
     //   9842: iaload
     //   9843: bipush #28
     //   9845: isub
     //   9846: aload_0
     //   9847: getfield m : LMedium;
     //   9850: getfield ground : I
     //   9853: iadd
     //   9854: putfield flyh : I
     //   9857: aload_0
     //   9858: getfield co : [LContO;
     //   9861: iload #11
     //   9863: aaload
     //   9864: getfield x : I
     //   9867: aload_0
     //   9868: getfield bco : [LContO;
     //   9871: aload_0
     //   9872: getfield sp : I
     //   9875: aaload
     //   9876: getfield x : I
     //   9879: isub
     //   9880: istore #5
     //   9882: aload_0
     //   9883: getfield co : [LContO;
     //   9886: iload #11
     //   9888: aaload
     //   9889: getfield z : I
     //   9892: aload_0
     //   9893: getfield co : [LContO;
     //   9896: iload #11
     //   9898: aaload
     //   9899: getfield p : [LPlane;
     //   9902: iload #16
     //   9904: aaload
     //   9905: getfield oz : [I
     //   9908: iload #17
     //   9910: iaload
     //   9911: iadd
     //   9912: aload_0
     //   9913: getfield bco : [LContO;
     //   9916: aload_0
     //   9917: getfield sp : I
     //   9920: aaload
     //   9921: getfield z : I
     //   9924: isub
     //   9925: istore #6
     //   9927: aload_0
     //   9928: iconst_1
     //   9929: putfield onfly : Z
     //   9932: goto_w -> 9937
     //   9937: iinc #17, 1
     //   9940: goto_w -> 9649
     //   9945: iinc #16, 1
     //   9948: goto_w -> 9620
     //   9953: goto_w -> 9958
     //   9958: aload_0
     //   9959: getfield co : [LContO;
     //   9962: iload #11
     //   9964: aaload
     //   9965: getfield roofat : I
     //   9968: invokestatic abs : (I)I
     //   9971: bipush #90
     //   9973: if_icmpeq -> 9981
     //   9976: goto_w -> 10410
     //   9981: aload_0
     //   9982: getfield rot : I
     //   9985: bipush #90
     //   9987: if_icmpeq -> 9995
     //   9990: goto_w -> 10410
     //   9995: aload_0
     //   9996: getfield bco : [LContO;
     //   9999: aload_0
     //   10000: getfield sp : I
     //   10003: aaload
     //   10004: getfield z : I
     //   10007: aload_0
     //   10008: getfield co : [LContO;
     //   10011: iload #11
     //   10013: aaload
     //   10014: getfield z : I
     //   10017: isub
     //   10018: invokestatic abs : (I)I
     //   10021: sipush #500
     //   10024: if_icmplt -> 10032
     //   10027: goto_w -> 10410
     //   10032: aload_0
     //   10033: getfield bco : [LContO;
     //   10036: aload_0
     //   10037: getfield sp : I
     //   10040: aaload
     //   10041: getfield x : I
     //   10044: aload_0
     //   10045: getfield co : [LContO;
     //   10048: iload #11
     //   10050: aaload
     //   10051: getfield x : I
     //   10054: isub
     //   10055: invokestatic abs : (I)I
     //   10058: sipush #3000
     //   10061: if_icmplt -> 10069
     //   10064: goto_w -> 10410
     //   10069: iconst_0
     //   10070: istore #16
     //   10072: iload #16
     //   10074: aload #15
     //   10076: aload_0
     //   10077: getfield co : [LContO;
     //   10080: iload #11
     //   10082: aaload
     //   10083: getfield colok : I
     //   10086: bipush #46
     //   10088: isub
     //   10089: iaload
     //   10090: if_icmplt -> 10098
     //   10093: goto_w -> 10405
     //   10098: iconst_0
     //   10099: istore #17
     //   10101: iload #17
     //   10103: aload_0
     //   10104: getfield co : [LContO;
     //   10107: iload #11
     //   10109: aaload
     //   10110: getfield p : [LPlane;
     //   10113: iload #16
     //   10115: aaload
     //   10116: getfield n : I
     //   10119: if_icmplt -> 10127
     //   10122: goto_w -> 10397
     //   10127: aload_0
     //   10128: aload_0
     //   10129: getfield bco : [LContO;
     //   10132: aload_0
     //   10133: getfield sp : I
     //   10136: aaload
     //   10137: getfield z : I
     //   10140: aload_0
     //   10141: getfield co : [LContO;
     //   10144: iload #11
     //   10146: aaload
     //   10147: getfield z : I
     //   10150: aload_0
     //   10151: getfield bco : [LContO;
     //   10154: aload_0
     //   10155: getfield sp : I
     //   10158: aaload
     //   10159: getfield x : I
     //   10162: aload_0
     //   10163: getfield co : [LContO;
     //   10166: iload #11
     //   10168: aaload
     //   10169: getfield x : I
     //   10172: aload_0
     //   10173: getfield co : [LContO;
     //   10176: iload #11
     //   10178: aaload
     //   10179: getfield p : [LPlane;
     //   10182: iload #16
     //   10184: aaload
     //   10185: getfield ox : [I
     //   10188: iload #17
     //   10190: iaload
     //   10191: iadd
     //   10192: invokevirtual py : (IIII)I
     //   10195: iload #10
     //   10197: if_icmplt -> 10205
     //   10200: goto_w -> 10389
     //   10205: aload_0
     //   10206: aload_0
     //   10207: getfield bco : [LContO;
     //   10210: aload_0
     //   10211: getfield sp : I
     //   10214: aaload
     //   10215: getfield z : I
     //   10218: aload_0
     //   10219: getfield co : [LContO;
     //   10222: iload #11
     //   10224: aaload
     //   10225: getfield z : I
     //   10228: aload_0
     //   10229: getfield bco : [LContO;
     //   10232: aload_0
     //   10233: getfield sp : I
     //   10236: aaload
     //   10237: getfield x : I
     //   10240: aload_0
     //   10241: getfield co : [LContO;
     //   10244: iload #11
     //   10246: aaload
     //   10247: getfield x : I
     //   10250: aload_0
     //   10251: getfield co : [LContO;
     //   10254: iload #11
     //   10256: aaload
     //   10257: getfield p : [LPlane;
     //   10260: iload #16
     //   10262: aaload
     //   10263: getfield ox : [I
     //   10266: iload #17
     //   10268: iaload
     //   10269: iadd
     //   10270: invokevirtual py : (IIII)I
     //   10273: istore #10
     //   10275: aload_0
     //   10276: aload_0
     //   10277: getfield co : [LContO;
     //   10280: iload #11
     //   10282: aaload
     //   10283: getfield p : [LPlane;
     //   10286: iload #16
     //   10288: aaload
     //   10289: getfield oy : [I
     //   10292: iload #17
     //   10294: iaload
     //   10295: bipush #28
     //   10297: isub
     //   10298: aload_0
     //   10299: getfield m : LMedium;
     //   10302: getfield ground : I
     //   10305: iadd
     //   10306: putfield flyh : I
     //   10309: aload_0
     //   10310: getfield co : [LContO;
     //   10313: iload #11
     //   10315: aaload
     //   10316: getfield z : I
     //   10319: aload_0
     //   10320: getfield bco : [LContO;
     //   10323: aload_0
     //   10324: getfield sp : I
     //   10327: aaload
     //   10328: getfield z : I
     //   10331: isub
     //   10332: istore #6
     //   10334: aload_0
     //   10335: getfield co : [LContO;
     //   10338: iload #11
     //   10340: aaload
     //   10341: getfield x : I
     //   10344: aload_0
     //   10345: getfield co : [LContO;
     //   10348: iload #11
     //   10350: aaload
     //   10351: getfield p : [LPlane;
     //   10354: iload #16
     //   10356: aaload
     //   10357: getfield ox : [I
     //   10360: iload #17
     //   10362: iaload
     //   10363: iadd
     //   10364: aload_0
     //   10365: getfield bco : [LContO;
     //   10368: aload_0
     //   10369: getfield sp : I
     //   10372: aaload
     //   10373: getfield x : I
     //   10376: isub
     //   10377: istore #5
     //   10379: aload_0
     //   10380: iconst_1
     //   10381: putfield onfly : Z
     //   10384: goto_w -> 10389
     //   10389: iinc #17, 1
     //   10392: goto_w -> 10101
     //   10397: iinc #16, 1
     //   10400: goto_w -> 10072
     //   10405: goto_w -> 10410
     //   10410: goto_w -> 10415
     //   10415: iinc #11, 1
     //   10418: goto_w -> 7701
     //   10423: aload_0
     //   10424: getfield bco : [LContO;
     //   10427: aload_0
     //   10428: getfield sp : I
     //   10431: aaload
     //   10432: dup
     //   10433: getfield x : I
     //   10436: iload #5
     //   10438: iadd
     //   10439: putfield x : I
     //   10442: aload_0
     //   10443: getfield bco : [LContO;
     //   10446: aload_0
     //   10447: getfield sp : I
     //   10450: aaload
     //   10451: dup
     //   10452: getfield z : I
     //   10455: iload #6
     //   10457: iadd
     //   10458: putfield z : I
     //   10461: aload_0
     //   10462: getfield bco : [LContO;
     //   10465: aload_0
     //   10466: getfield sp : I
     //   10469: aaload
     //   10470: getfield xy : I
     //   10473: istore #11
     //   10475: aload_0
     //   10476: getfield bco : [LContO;
     //   10479: aload_0
     //   10480: getfield sp : I
     //   10483: aaload
     //   10484: getfield zy : I
     //   10487: istore #12
     //   10489: aload_0
     //   10490: getfield sp : I
     //   10493: bipush #31
     //   10495: if_icmpeq -> 10503
     //   10498: goto_w -> 10563
     //   10503: aload_0
     //   10504: getfield bco : [LContO;
     //   10507: aload_0
     //   10508: getfield sp : I
     //   10511: aaload
     //   10512: aload_0
     //   10513: getfield hf : I
     //   10516: ineg
     //   10517: putfield y : I
     //   10520: aload_0
     //   10521: getfield bco : [LContO;
     //   10524: aload_0
     //   10525: getfield sp : I
     //   10528: aaload
     //   10529: getfield y : I
     //   10532: sipush #-500
     //   10535: if_icmpgt -> 10543
     //   10538: goto_w -> 10576
     //   10543: aload_0
     //   10544: getfield bco : [LContO;
     //   10547: aload_0
     //   10548: getfield sp : I
     //   10551: aaload
     //   10552: sipush #-500
     //   10555: putfield y : I
     //   10558: goto_w -> 10576
     //   10563: aload_0
     //   10564: getfield bco : [LContO;
     //   10567: aload_0
     //   10568: getfield sp : I
     //   10571: aaload
     //   10572: iconst_0
     //   10573: putfield xy : I
     //   10576: aload_0
     //   10577: getfield sp : I
     //   10580: bipush #54
     //   10582: if_icmpeq -> 10590
     //   10585: goto_w -> 10611
     //   10590: aload_0
     //   10591: getfield bco : [LContO;
     //   10594: aload_0
     //   10595: getfield sp : I
     //   10598: aaload
     //   10599: aload_0
     //   10600: getfield flyh : I
     //   10603: putfield y : I
     //   10606: goto_w -> 10611
     //   10611: aload_0
     //   10612: getfield bco : [LContO;
     //   10615: aload_0
     //   10616: getfield sp : I
     //   10619: aaload
     //   10620: iconst_0
     //   10621: putfield zy : I
     //   10624: aload_0
     //   10625: getfield cntout : I
     //   10628: ifeq -> 10636
     //   10631: goto_w -> 12057
     //   10636: aload_0
     //   10637: getfield mouseon : I
     //   10640: iconst_m1
     //   10641: if_icmpeq -> 10649
     //   10644: goto_w -> 12154
     //   10649: aload_0
     //   10650: getfield bco : [LContO;
     //   10653: aload_0
     //   10654: getfield sp : I
     //   10657: aaload
     //   10658: aload_0
     //   10659: getfield rd : Ljava/awt/Graphics2D;
     //   10662: invokevirtual d : (Ljava/awt/Graphics2D;)V
     //   10665: aload_0
     //   10666: getfield setcur : Z
     //   10669: ifeq -> 10677
     //   10672: goto_w -> 10700
     //   10677: aload_0
     //   10678: new java/awt/Cursor
     //   10681: dup
     //   10682: bipush #13
     //   10684: invokespecial <init> : (I)V
     //   10687: invokevirtual setCursor : (Ljava/awt/Cursor;)V
     //   10690: aload_0
     //   10691: iconst_1
     //   10692: putfield setcur : Z
     //   10695: goto_w -> 10700
     //   10700: aload_0
     //   10701: getfield mouses : I
     //   10704: iconst_m1
     //   10705: if_icmpeq -> 10713
     //   10708: goto_w -> 12154
     //   10713: aload_0
     //   10714: getfield nundo : I
     //   10717: sipush #5000
     //   10720: if_icmplt -> 10728
     //   10723: goto_w -> 10756
     //   10728: aload_0
     //   10729: getfield undos : [Ljava/lang/String;
     //   10732: aload_0
     //   10733: getfield nundo : I
     //   10736: aload_0
     //   10737: getfield bstage : Ljava/lang/String;
     //   10740: aastore
     //   10741: aload_0
     //   10742: dup
     //   10743: getfield nundo : I
     //   10746: iconst_1
     //   10747: iadd
     //   10748: putfield nundo : I
     //   10751: goto_w -> 10756
     //   10756: aload_0
     //   10757: getfield bco : [LContO;
     //   10760: aload_0
     //   10761: getfield sp : I
     //   10764: aaload
     //   10765: getfield xz : I
     //   10768: sipush #270
     //   10771: if_icmpeq -> 10779
     //   10774: goto_w -> 10798
     //   10779: aload_0
     //   10780: getfield bco : [LContO;
     //   10783: aload_0
     //   10784: getfield sp : I
     //   10787: aaload
     //   10788: bipush #-90
     //   10790: putfield xz : I
     //   10793: goto_w -> 10798
     //   10798: aload_0
     //   10799: getfield bco : [LContO;
     //   10802: aload_0
     //   10803: getfield sp : I
     //   10806: aaload
     //   10807: getfield xz : I
     //   10810: sipush #360
     //   10813: if_icmpeq -> 10821
     //   10816: goto_w -> 10839
     //   10821: aload_0
     //   10822: getfield bco : [LContO;
     //   10825: aload_0
     //   10826: getfield sp : I
     //   10829: aaload
     //   10830: iconst_0
     //   10831: putfield xz : I
     //   10834: goto_w -> 10839
     //   10839: aload_0
     //   10840: iconst_0
     //   10841: putfield errd : I
     //   10844: iconst_0
     //   10845: istore #13
     //   10847: aload_0
     //   10848: getfield xnob : I
     //   10851: sipush #601
     //   10854: if_icmplt -> 10862
     //   10857: goto_w -> 11616
     //   10862: aload_0
     //   10863: getfield sp : I
     //   10866: bipush #31
     //   10868: if_icmpne -> 10876
     //   10871: goto_w -> 11052
     //   10876: aload_0
     //   10877: getfield sp : I
     //   10880: bipush #54
     //   10882: if_icmpne -> 10890
     //   10885: goto_w -> 11052
     //   10890: aload_0
     //   10891: getfield sp : I
     //   10894: bipush #66
     //   10896: if_icmpne -> 10904
     //   10899: goto_w -> 11052
     //   10904: aload_0
     //   10905: getfield co : [LContO;
     //   10908: aload_0
     //   10909: getfield nob : I
     //   10912: new ContO
     //   10915: dup
     //   10916: aload_0
     //   10917: getfield bco : [LContO;
     //   10920: aload_0
     //   10921: getfield sp : I
     //   10924: aaload
     //   10925: aload_0
     //   10926: getfield bco : [LContO;
     //   10929: aload_0
     //   10930: getfield sp : I
     //   10933: aaload
     //   10934: getfield x : I
     //   10937: aload_0
     //   10938: getfield m : LMedium;
     //   10941: getfield ground : I
     //   10944: aload_0
     //   10945: getfield bco : [LContO;
     //   10948: aload_0
     //   10949: getfield sp : I
     //   10952: aaload
     //   10953: getfield grat : I
     //   10956: isub
     //   10957: aload_0
     //   10958: getfield bco : [LContO;
     //   10961: aload_0
     //   10962: getfield sp : I
     //   10965: aaload
     //   10966: getfield z : I
     //   10969: aload_0
     //   10970: getfield bco : [LContO;
     //   10973: aload_0
     //   10974: getfield sp : I
     //   10977: aaload
     //   10978: getfield xz : I
     //   10981: invokespecial <init> : (LContO;IIII)V
     //   10984: aastore
     //   10985: aload_0
     //   10986: getfield co : [LContO;
     //   10989: aload_0
     //   10990: getfield nob : I
     //   10993: aaload
     //   10994: aload_0
     //   10995: getfield bco : [LContO;
     //   10998: aload_0
     //   10999: getfield sp : I
     //   11002: aaload
     //   11003: getfield xz : I
     //   11006: putfield roofat : I
     //   11009: aload_0
     //   11010: getfield co : [LContO;
     //   11013: aload_0
     //   11014: getfield nob : I
     //   11017: aaload
     //   11018: aload_0
     //   11019: getfield sp : I
     //   11022: putfield colok : I
     //   11025: aload_0
     //   11026: dup
     //   11027: getfield nob : I
     //   11030: iconst_1
     //   11031: iadd
     //   11032: putfield nob : I
     //   11035: goto_w -> 11052
     //   11040: astore #14
     //   11042: aload_0
     //   11043: iconst_1
     //   11044: putfield errd : I
     //   11047: goto_w -> 11052
     //   11052: aload_0
     //   11053: getfield sp : I
     //   11056: bipush #31
     //   11058: if_icmpeq -> 11066
     //   11061: goto_w -> 11265
     //   11066: aload_0
     //   11067: getfield cp : LCheckPoints;
     //   11070: getfield fn : I
     //   11073: iconst_5
     //   11074: if_icmplt -> 11082
     //   11077: goto_w -> 11255
     //   11082: aload_0
     //   11083: getfield co : [LContO;
     //   11086: aload_0
     //   11087: getfield nob : I
     //   11090: new ContO
     //   11093: dup
     //   11094: aload_0
     //   11095: getfield bco : [LContO;
     //   11098: aload_0
     //   11099: getfield sp : I
     //   11102: aaload
     //   11103: aload_0
     //   11104: getfield bco : [LContO;
     //   11107: aload_0
     //   11108: getfield sp : I
     //   11111: aaload
     //   11112: getfield x : I
     //   11115: aload_0
     //   11116: getfield bco : [LContO;
     //   11119: aload_0
     //   11120: getfield sp : I
     //   11123: aaload
     //   11124: getfield y : I
     //   11127: aload_0
     //   11128: getfield bco : [LContO;
     //   11131: aload_0
     //   11132: getfield sp : I
     //   11135: aaload
     //   11136: getfield z : I
     //   11139: aload_0
     //   11140: getfield bco : [LContO;
     //   11143: aload_0
     //   11144: getfield sp : I
     //   11147: aaload
     //   11148: getfield xz : I
     //   11151: invokespecial <init> : (LContO;IIII)V
     //   11154: aastore
     //   11155: aload_0
     //   11156: getfield co : [LContO;
     //   11159: aload_0
     //   11160: getfield nob : I
     //   11163: aaload
     //   11164: aload_0
     //   11165: getfield bco : [LContO;
     //   11168: aload_0
     //   11169: getfield sp : I
     //   11172: aaload
     //   11173: getfield xz : I
     //   11176: putfield roofat : I
     //   11179: aload_0
     //   11180: getfield co : [LContO;
     //   11183: aload_0
     //   11184: getfield nob : I
     //   11187: aaload
     //   11188: aload_0
     //   11189: getfield sp : I
     //   11192: putfield colok : I
     //   11195: aload_0
     //   11196: dup
     //   11197: getfield nob : I
     //   11200: iconst_1
     //   11201: iadd
     //   11202: putfield nob : I
     //   11205: aload_0
     //   11206: getfield fixh : Ljava/awt/TextField;
     //   11209: new java/lang/StringBuilder
     //   11212: dup
     //   11213: invokespecial <init> : ()V
     //   11216: ldc ''
     //   11218: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   11221: aload_0
     //   11222: getfield bco : [LContO;
     //   11225: aload_0
     //   11226: getfield sp : I
     //   11229: aaload
     //   11230: getfield y : I
     //   11233: invokestatic abs : (I)I
     //   11236: invokevirtual append : (I)Ljava/lang/StringBuilder;
     //   11239: ldc ''
     //   11241: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   11244: invokevirtual toString : ()Ljava/lang/String;
     //   11247: invokevirtual setText : (Ljava/lang/String;)V
     //   11250: goto_w -> 11265
     //   11255: aload_0
     //   11256: iconst_5
     //   11257: putfield errd : I
     //   11260: goto_w -> 11265
     //   11265: aload_0
     //   11266: getfield sp : I
     //   11269: bipush #54
     //   11271: if_icmpeq -> 11279
     //   11274: goto_w -> 11419
     //   11279: aload_0
     //   11280: getfield co : [LContO;
     //   11283: aload_0
     //   11284: getfield nob : I
     //   11287: new ContO
     //   11290: dup
     //   11291: aload_0
     //   11292: getfield bco : [LContO;
     //   11295: aload_0
     //   11296: getfield sp : I
     //   11299: aaload
     //   11300: aload_0
     //   11301: getfield bco : [LContO;
     //   11304: aload_0
     //   11305: getfield sp : I
     //   11308: aaload
     //   11309: getfield x : I
     //   11312: aload_0
     //   11313: getfield bco : [LContO;
     //   11316: aload_0
     //   11317: getfield sp : I
     //   11320: aaload
     //   11321: getfield y : I
     //   11324: aload_0
     //   11325: getfield bco : [LContO;
     //   11328: aload_0
     //   11329: getfield sp : I
     //   11332: aaload
     //   11333: getfield z : I
     //   11336: aload_0
     //   11337: getfield bco : [LContO;
     //   11340: aload_0
     //   11341: getfield sp : I
     //   11344: aaload
     //   11345: getfield xz : I
     //   11348: invokespecial <init> : (LContO;IIII)V
     //   11351: aastore
     //   11352: aload_0
     //   11353: getfield co : [LContO;
     //   11356: aload_0
     //   11357: getfield nob : I
     //   11360: aaload
     //   11361: aload_0
     //   11362: getfield bco : [LContO;
     //   11365: aload_0
     //   11366: getfield sp : I
     //   11369: aaload
     //   11370: getfield xz : I
     //   11373: putfield roofat : I
     //   11376: aload_0
     //   11377: getfield co : [LContO;
     //   11380: aload_0
     //   11381: getfield nob : I
     //   11384: aaload
     //   11385: aload_0
     //   11386: getfield sp : I
     //   11389: putfield colok : I
     //   11392: aload_0
     //   11393: dup
     //   11394: getfield nob : I
     //   11397: iconst_1
     //   11398: iadd
     //   11399: putfield nob : I
     //   11402: goto_w -> 11419
     //   11407: astore #14
     //   11409: aload_0
     //   11410: iconst_1
     //   11411: putfield errd : I
     //   11414: goto_w -> 11419
     //   11419: aload_0
     //   11420: getfield sp : I
     //   11423: bipush #66
     //   11425: if_icmpeq -> 11433
     //   11428: goto_w -> 11621
     //   11433: aload_0
     //   11434: getfield co : [LContO;
     //   11437: aload_0
     //   11438: getfield nob : I
     //   11441: new ContO
     //   11444: dup
     //   11445: aload_0
     //   11446: getfield bco : [LContO;
     //   11449: bipush #66
     //   11451: aaload
     //   11452: getfield srz : I
     //   11455: aload_0
     //   11456: getfield bco : [LContO;
     //   11459: bipush #66
     //   11461: aaload
     //   11462: getfield srx : I
     //   11465: aload_0
     //   11466: getfield bco : [LContO;
     //   11469: bipush #66
     //   11471: aaload
     //   11472: getfield sry : I
     //   11475: aload_0
     //   11476: getfield m : LMedium;
     //   11479: aload_0
     //   11480: getfield t : LTrackers;
     //   11483: aload_0
     //   11484: getfield bco : [LContO;
     //   11487: bipush #66
     //   11489: aaload
     //   11490: getfield x : I
     //   11493: aload_0
     //   11494: getfield bco : [LContO;
     //   11497: bipush #66
     //   11499: aaload
     //   11500: getfield z : I
     //   11503: aload_0
     //   11504: getfield bco : [LContO;
     //   11507: aload_0
     //   11508: getfield sp : I
     //   11511: aaload
     //   11512: getfield y : I
     //   11515: invokespecial <init> : (IIILMedium;LTrackers;III)V
     //   11518: aastore
     //   11519: aload_0
     //   11520: getfield co : [LContO;
     //   11523: aload_0
     //   11524: getfield nob : I
     //   11527: aaload
     //   11528: aload_0
     //   11529: getfield bco : [LContO;
     //   11532: bipush #66
     //   11534: aaload
     //   11535: getfield srz : I
     //   11538: putfield srz : I
     //   11541: aload_0
     //   11542: getfield co : [LContO;
     //   11545: aload_0
     //   11546: getfield nob : I
     //   11549: aaload
     //   11550: aload_0
     //   11551: getfield bco : [LContO;
     //   11554: bipush #66
     //   11556: aaload
     //   11557: getfield srx : I
     //   11560: putfield srx : I
     //   11563: aload_0
     //   11564: getfield co : [LContO;
     //   11567: aload_0
     //   11568: getfield nob : I
     //   11571: aaload
     //   11572: aload_0
     //   11573: getfield bco : [LContO;
     //   11576: bipush #66
     //   11578: aaload
     //   11579: getfield sry : I
     //   11582: putfield sry : I
     //   11585: aload_0
     //   11586: getfield co : [LContO;
     //   11589: aload_0
     //   11590: getfield nob : I
     //   11593: aaload
     //   11594: aload_0
     //   11595: getfield sp : I
     //   11598: putfield colok : I
     //   11601: aload_0
     //   11602: dup
     //   11603: getfield nob : I
     //   11606: iconst_1
     //   11607: iadd
     //   11608: putfield nob : I
     //   11611: goto_w -> 11621
     //   11616: aload_0
     //   11617: iconst_4
     //   11618: putfield errd : I
     //   11621: aload_0
     //   11622: getfield errd : I
     //   11625: ifeq -> 11633
     //   11628: goto_w -> 11915
     //   11633: aload_0
     //   11634: invokevirtual sortstage : ()V
     //   11637: aload_0
     //   11638: iconst_0
     //   11639: invokevirtual readstage : (I)V
     //   11642: iconst_1
     //   11643: istore #13
     //   11645: aload_0
     //   11646: getfield sp : I
     //   11649: bipush #66
     //   11651: if_icmpeq -> 11659
     //   11654: goto_w -> 11669
     //   11659: aload_0
     //   11660: iconst_0
     //   11661: putfield pgen : Z
     //   11664: goto_w -> 11669
     //   11669: aload_0
     //   11670: getfield sp : I
     //   11673: bipush #52
     //   11675: if_icmpne -> 11683
     //   11678: goto_w -> 11725
     //   11683: aload_0
     //   11684: getfield sp : I
     //   11687: bipush #53
     //   11689: if_icmpne -> 11697
     //   11692: goto_w -> 11725
     //   11697: aload_0
     //   11698: getfield sp : I
     //   11701: bipush #55
     //   11703: if_icmpge -> 11711
     //   11706: goto_w -> 11915
     //   11711: aload_0
     //   11712: getfield sp : I
     //   11715: bipush #65
     //   11717: if_icmple -> 11725
     //   11720: goto_w -> 11915
     //   11725: aload_0
     //   11726: iconst_3
     //   11727: putfield seq : I
     //   11730: aload_0
     //   11731: getfield bco : [LContO;
     //   11734: aload_0
     //   11735: getfield sp : I
     //   11738: aaload
     //   11739: iconst_0
     //   11740: putfield xy : I
     //   11743: aload_0
     //   11744: getfield bco : [LContO;
     //   11747: aload_0
     //   11748: getfield sp : I
     //   11751: aaload
     //   11752: iconst_0
     //   11753: putfield zy : I
     //   11756: iconst_0
     //   11757: istore #14
     //   11759: aload_0
     //   11760: getfield rot : I
     //   11763: ifeq -> 11771
     //   11766: goto_w -> 11795
     //   11771: iload #14
     //   11773: ifeq -> 11781
     //   11776: goto_w -> 11795
     //   11781: aload_0
     //   11782: bipush #90
     //   11784: putfield rot : I
     //   11787: iconst_1
     //   11788: istore #14
     //   11790: goto_w -> 11795
     //   11795: aload_0
     //   11796: getfield rot : I
     //   11799: bipush #90
     //   11801: if_icmpeq -> 11809
     //   11804: goto_w -> 11834
     //   11809: iload #14
     //   11811: ifeq -> 11819
     //   11814: goto_w -> 11834
     //   11819: aload_0
     //   11820: sipush #180
     //   11823: putfield rot : I
     //   11826: iconst_1
     //   11827: istore #14
     //   11829: goto_w -> 11834
     //   11834: aload_0
     //   11835: getfield rot : I
     //   11838: sipush #180
     //   11841: if_icmpeq -> 11849
     //   11844: goto_w -> 11873
     //   11849: iload #14
     //   11851: ifeq -> 11859
     //   11854: goto_w -> 11873
     //   11859: aload_0
     //   11860: bipush #-90
     //   11862: putfield rot : I
     //   11865: iconst_1
     //   11866: istore #14
     //   11868: goto_w -> 11873
     //   11873: aload_0
     //   11874: getfield rot : I
     //   11877: bipush #-90
     //   11879: if_icmpeq -> 11887
     //   11882: goto_w -> 11910
     //   11887: iload #14
     //   11889: ifeq -> 11897
     //   11892: goto_w -> 11910
     //   11897: aload_0
     //   11898: iconst_0
     //   11899: putfield rot : I
     //   11902: iconst_1
     //   11903: istore #14
     //   11905: goto_w -> 11910
     //   11910: goto_w -> 11915
     //   11915: aload_0
     //   11916: getfield errd : I
     //   11919: ifne -> 11927
     //   11922: goto_w -> 12014
     //   11927: aconst_null
     //   11928: new java/lang/StringBuilder
     //   11931: dup
     //   11932: invokespecial <init> : ()V
     //   11935: ldc_w 'Error!  Unable to place part!\\nReason:\\n'
     //   11938: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   11941: aload_0
     //   11942: getfield errlo : [Ljava/lang/String;
     //   11945: aload_0
     //   11946: getfield errd : I
     //   11949: iconst_1
     //   11950: isub
     //   11951: aaload
     //   11952: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   11955: ldc_w '\\n\\n'
     //   11958: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
     //   11961: invokevirtual toString : ()Ljava/lang/String;
     //   11964: ldc_w 'Stage Maker'
     //   11967: iconst_0
     //   11968: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
     //   11971: iload #13
     //   11973: ifne -> 11981
     //   11976: goto_w -> 12014
     //   11981: aload_0
     //   11982: dup
     //   11983: getfield nundo : I
     //   11986: iconst_1
     //   11987: isub
     //   11988: putfield nundo : I
     //   11991: aload_0
     //   11992: aload_0
     //   11993: getfield undos : [Ljava/lang/String;
     //   11996: aload_0
     //   11997: getfield nundo : I
     //   12000: aaload
     //   12001: putfield bstage : Ljava/lang/String;
     //   12004: aload_0
     //   12005: iconst_0
     //   12006: invokevirtual readstage : (I)V
     //   12009: goto_w -> 12014
     //   12014: aload_0
     //   12015: aload_0
     //   12016: getfield bco : [LContO;
     //   12019: aload_0
     //   12020: getfield sp : I
     //   12023: aaload
     //   12024: getfield x : I
     //   12027: putfield lxm : I
     //   12030: aload_0
     //   12031: aload_0
     //   12032: getfield bco : [LContO;
     //   12035: aload_0
     //   12036: getfield sp : I
     //   12039: aaload
     //   12040: getfield z : I
     //   12043: putfield lym : I
     //   12046: aload_0
     //   12047: bipush #10
     //   12049: putfield cntout : I
     //   12052: goto_w -> 12154
     //   12057: aload_0
     //   12058: getfield lxm : I
     //   12061: aload_0
     //   12062: getfield bco : [LContO;
     //   12065: aload_0
     //   12066: getfield sp : I
     //   12069: aaload
     //   12070: getfield x : I
     //   12073: if_icmpne -> 12081
     //   12076: goto_w -> 12120
     //   12081: aload_0
     //   12082: getfield lxm : I
     //   12085: aload_0
     //   12086: getfield bco : [LContO;
     //   12089: aload_0
     //   12090: getfield sp : I
     //   12093: aaload
     //   12094: getfield z : I
     //   12097: if_icmpne -> 12105
     //   12100: goto_w -> 12120
     //   12105: aload_0
     //   12106: dup
     //   12107: getfield cntout : I
     //   12110: iconst_1
     //   12111: isub
     //   12112: putfield cntout : I
     //   12115: goto_w -> 12120
     //   12120: aload_0
     //   12121: getfield setcur : Z
     //   12124: ifne -> 12132
     //   12127: goto_w -> 12154
     //   12132: aload_0
     //   12133: new java/awt/Cursor
     //   12136: dup
     //   12137: iconst_0
     //   12138: invokespecial <init> : (I)V
     //   12141: invokevirtual setCursor : (Ljava/awt/Cursor;)V
     //   12144: aload_0
     //   12145: iconst_0
     //   12146: putfield setcur : Z
     //   12149: goto_w -> 12154
     //   12154: aload_0
     //   12155: getfield bco : [LContO;
     //   12158: aload_0
     //   12159: getfield sp : I
     //   12162: aaload
     //   12163: iload #11
     //   12165: putfield xy : I
     //   12168: aload_0
     //   12169: getfield bco : [LContO;
     //   12172: aload_0
     //   12173: getfield sp : I
     //   12176: aaload
     //   12177: iload #12
     //   12179: putfield zy : I
     //   12182: goto_w -> 13926
     //   12187: aload_0
     //   12188: getfield epart : Z
     //   12191: ifne -> 12199
     //   12194: goto_w -> 13058
     //   12199: aload_0
     //   12200: getfield esp : I
     //   12203: iconst_m1
     //   12204: if_icmpeq -> 12212
     //   12207: goto_w -> 13024
     //   12212: aload_0
     //   12213: getfield overcan : Z
     //   12216: ifeq -> 12224
     //   12219: goto_w -> 13024
     //   12224: aload_0
     //   12225: iconst_m1
     //   12226: putfield hi : I
     //   12229: iconst_0
     //   12230: istore #4
     //   12232: iconst_0
     //   12233: istore #5
     //   12235: iload #5
     //   12237: aload_0
     //   12238: getfield nob : I
     //   12241: if_icmplt -> 12249
     //   12244: goto_w -> 12906
     //   12249: aload_0
     //   12250: getfield m : LMedium;
     //   12253: getfield cx : I
     //   12256: aload_0
     //   12257: getfield co : [LContO;
     //   12260: iload #5
     //   12262: aaload
     //   12263: getfield x : I
     //   12266: aload_0
     //   12267: getfield m : LMedium;
     //   12270: getfield x : I
     //   12273: isub
     //   12274: aload_0
     //   12275: getfield m : LMedium;
     //   12278: getfield cx : I
     //   12281: isub
     //   12282: i2f
     //   12283: aload_0
     //   12284: getfield m : LMedium;
     //   12287: aload_0
     //   12288: getfield m : LMedium;
     //   12291: getfield xz : I
     //   12294: invokevirtual cos : (I)F
     //   12297: fmul
     //   12298: aload_0
     //   12299: getfield co : [LContO;
     //   12302: iload #5
     //   12304: aaload
     //   12305: getfield z : I
     //   12308: aload_0
     //   12309: getfield m : LMedium;
     //   12312: getfield z : I
     //   12315: isub
     //   12316: aload_0
     //   12317: getfield m : LMedium;
     //   12320: getfield cz : I
     //   12323: isub
     //   12324: i2f
     //   12325: aload_0
     //   12326: getfield m : LMedium;
     //   12329: aload_0
     //   12330: getfield m : LMedium;
     //   12333: getfield xz : I
     //   12336: invokevirtual sin : (I)F
     //   12339: fmul
     //   12340: fsub
     //   12341: f2i
     //   12342: iadd
     //   12343: istore #6
     //   12345: aload_0
     //   12346: getfield m : LMedium;
     //   12349: getfield cz : I
     //   12352: aload_0
     //   12353: getfield co : [LContO;
     //   12356: iload #5
     //   12358: aaload
     //   12359: getfield x : I
     //   12362: aload_0
     //   12363: getfield m : LMedium;
     //   12366: getfield x : I
     //   12369: isub
     //   12370: aload_0
     //   12371: getfield m : LMedium;
     //   12374: getfield cx : I
     //   12377: isub
     //   12378: i2f
     //   12379: aload_0
     //   12380: getfield m : LMedium;
     //   12383: aload_0
     //   12384: getfield m : LMedium;
     //   12387: getfield xz : I
     //   12390: invokevirtual sin : (I)F
     //   12393: fmul
     //   12394: aload_0
     //   12395: getfield co : [LContO;
     //   12398: iload #5
     //   12400: aaload
     //   12401: getfield z : I
     //   12404: aload_0
     //   12405: getfield m : LMedium;
     //   12408: getfield z : I
     //   12411: isub
     //   12412: aload_0
     //   12413: getfield m : LMedium;
     //   12416: getfield cz : I
     //   12419: isub
     //   12420: i2f
     //   12421: aload_0
     //   12422: getfield m : LMedium;
     //   12425: aload_0
     //   12426: getfield m : LMedium;
     //   12429: getfield xz : I
     //   12432: invokevirtual cos : (I)F
     //   12435: fmul
     //   12436: fadd
     //   12437: f2i
     //   12438: iadd
     //   12439: istore #7
     //   12441: aload_0
     //   12442: getfield m : LMedium;
     //   12445: getfield cy : I
     //   12448: aload_0
     //   12449: getfield co : [LContO;
     //   12452: iload #5
     //   12454: aaload
     //   12455: getfield y : I
     //   12458: aload_0
     //   12459: getfield m : LMedium;
     //   12462: getfield y : I
     //   12465: isub
     //   12466: aload_0
     //   12467: getfield m : LMedium;
     //   12470: getfield cy : I
     //   12473: isub
     //   12474: i2f
     //   12475: aload_0
     //   12476: getfield m : LMedium;
     //   12479: aload_0
     //   12480: getfield m : LMedium;
     //   12483: getfield zy : I
     //   12486: invokevirtual cos : (I)F
     //   12489: fmul
     //   12490: iload #7
     //   12492: aload_0
     //   12493: getfield m : LMedium;
     //   12496: getfield cz : I
     //   12499: isub
     //   12500: i2f
     //   12501: aload_0
     //   12502: getfield m : LMedium;
     //   12505: aload_0
     //   12506: getfield m : LMedium;
     //   12509: getfield zy : I
     //   12512: invokevirtual sin : (I)F
     //   12515: fmul
     //   12516: fsub
     //   12517: f2i
     //   12518: iadd
     //   12519: istore #8
     //   12521: aload_0
     //   12522: getfield m : LMedium;
     //   12525: getfield cz : I
     //   12528: aload_0
     //   12529: getfield co : [LContO;
     //   12532: iload #5
     //   12534: aaload
     //   12535: getfield y : I
     //   12538: aload_0
     //   12539: getfield m : LMedium;
     //   12542: getfield y : I
     //   12545: isub
     //   12546: aload_0
     //   12547: getfield m : LMedium;
     //   12550: getfield cy : I
     //   12553: isub
     //   12554: i2f
     //   12555: aload_0
     //   12556: getfield m : LMedium;
     //   12559: aload_0
     //   12560: getfield m : LMedium;
     //   12563: getfield zy : I
     //   12566: invokevirtual sin : (I)F
     //   12569: fmul
     //   12570: iload #7
     //   12572: aload_0
     //   12573: getfield m : LMedium;
     //   12576: getfield cz : I
     //   12579: isub
     //   12580: i2f
     //   12581: aload_0
     //   12582: getfield m : LMedium;
     //   12585: aload_0
     //   12586: getfield m : LMedium;
     //   12589: getfield zy : I
     //   12592: invokevirtual cos : (I)F
     //   12595: fmul
     //   12596: fadd
     //   12597: f2i
     //   12598: iadd
     //   12599: istore #9
     //   12601: aload_0
     //   12602: getfield xm : I
     //   12605: aload_0
     //   12606: iload #6
     //   12608: aload_0
     //   12609: getfield co : [LContO;
     //   12612: iload #5
     //   12614: aaload
     //   12615: getfield maxR : I
     //   12618: isub
     //   12619: iload #9
     //   12621: invokevirtual xs : (II)I
     //   12624: if_icmpgt -> 12632
     //   12627: goto_w -> 12898
     //   12632: aload_0
     //   12633: getfield xm : I
     //   12636: aload_0
     //   12637: iload #6
     //   12639: aload_0
     //   12640: getfield co : [LContO;
     //   12643: iload #5
     //   12645: aaload
     //   12646: getfield maxR : I
     //   12649: iadd
     //   12650: iload #9
     //   12652: invokevirtual xs : (II)I
     //   12655: if_icmplt -> 12663
     //   12658: goto_w -> 12898
     //   12663: aload_0
     //   12664: getfield ym : I
     //   12667: aload_0
     //   12668: iload #8
     //   12670: aload_0
     //   12671: getfield co : [LContO;
     //   12674: iload #5
     //   12676: aaload
     //   12677: getfield maxR : I
     //   12680: isub
     //   12681: iload #9
     //   12683: invokevirtual ys : (II)I
     //   12686: if_icmpgt -> 12694
     //   12689: goto_w -> 12898
     //   12694: aload_0
     //   12695: getfield ym : I
     //   12698: aload_0
     //   12699: iload #8
     //   12701: aload_0
     //   12702: getfield co : [LContO;
     //   12705: iload #5
     //   12707: aaload
     //   12708: getfield maxR : I
     //   12711: iadd
     //   12712: iload #9
     //   12714: invokevirtual ys : (II)I
     //   12717: if_icmplt -> 12725
     //   12720: goto_w -> 12898
     //   12725: aload_0
     //   12726: getfield co : [LContO;
     //   12729: iload #5
     //   12731: aaload
     //   12732: getfield colok : I
     //   12735: bipush #37
     //   12737: if_icmpne -> 12745
     //   12740: goto_w -> 12898
     //   12745: aload_0
     //   12746: getfield co : [LContO;
     //   12749: iload #5
     //   12751: aaload
     //   12752: getfield colok : I
     //   12755: bipush #38
     //   12757: if_icmpne -> 12765
     //   12760: goto_w -> 12898
     //   12765: aload_0
     //   12766: getfield hi : I
     //   12769: iconst_m1
     //   12770: if_icmpeq -> 12778
     //   12773: goto_w -> 12819
     //   12778: aload_0
     //   12779: iload #5
     //   12781: putfield hi : I
     //   12784: aload_0
     //   12785: aload_0
     //   12786: getfield xm : I
     //   12789: aload_0
     //   12790: iload #6
     //   12792: iload #9
     //   12794: invokevirtual xs : (II)I
     //   12797: aload_0
     //   12798: getfield ym : I
     //   12801: aload_0
     //   12802: iload #8
     //   12804: iload #9
     //   12806: invokevirtual ys : (II)I
     //   12809: invokevirtual py : (IIII)I
     //   12812: istore #4
     //   12814: goto_w -> 12898
     //   12819: aload_0
     //   12820: aload_0
     //   12821: getfield xm : I
     //   12824: aload_0
     //   12825: iload #6
     //   12827: iload #9
     //   12829: invokevirtual xs : (II)I
     //   12832: aload_0
     //   12833: getfield ym : I
     //   12836: aload_0
     //   12837: iload #8
     //   12839: iload #9
     //   12841: invokevirtual ys : (II)I
     //   12844: invokevirtual py : (IIII)I
     //   12847: iload #4
     //   12849: if_icmple -> 12857
     //   12852: goto_w -> 12898
     //   12857: aload_0
     //   12858: iload #5
     //   12860: putfield hi : I
     //   12863: aload_0
     //   12864: aload_0
     //   12865: getfield xm : I
     //   12868: aload_0
     //   12869: iload #6
     //   12871: iload #9
     //   12873: invokevirtual xs : (II)I
     //   12876: aload_0
     //   12877: getfield ym : I
     //   12880: aload_0
     //   12881: iload #8
     //   12883: iload #9
     //   12885: invokevirtual ys : (II)I
     //   12888: invokevirtual py : (IIII)I
     //   12891: istore #4
     //   12893: goto_w -> 12898
     //   12898: iinc #5, 1
     //   12901: goto_w -> 12235
     //   12906: aload_0
     //   12907: getfield hi : I
     //   12910: iconst_m1
     //   12911: if_icmpne -> 12919
     //   12914: goto_w -> 12985
     //   12919: aload_0
     //   12920: getfield setcur : Z
     //   12923: ifeq -> 12931
     //   12926: goto_w -> 12954
     //   12931: aload_0
     //   12932: new java/awt/Cursor
     //   12935: dup
     //   12936: bipush #13
     //   12938: invokespecial <init> : (I)V
     //   12941: invokevirtual setCursor : (Ljava/awt/Cursor;)V
     //   12944: aload_0
     //   12945: iconst_1
     //   12946: putfield setcur : Z
     //   12949: goto_w -> 12954
     //   12954: aload_0
     //   12955: getfield mouses : I
     //   12958: iconst_m1
     //   12959: if_icmpeq -> 12967
     //   12962: goto_w -> 13019
     //   12967: aload_0
     //   12968: aload_0
     //   12969: getfield hi : I
     //   12972: putfield esp : I
     //   12975: aload_0
     //   12976: iconst_0
     //   12977: putfield mouses : I
     //   12980: goto_w -> 13019
     //   12985: aload_0
     //   12986: getfield setcur : Z
     //   12989: ifne -> 12997
     //   12992: goto_w -> 13019
     //   12997: aload_0
     //   12998: new java/awt/Cursor
     //   13001: dup
     //   13002: iconst_0
     //   13003: invokespecial <init> : (I)V
     //   13006: invokevirtual setCursor : (Ljava/awt/Cursor;)V
     //   13009: aload_0
     //   13010: iconst_0
     //   13011: putfield setcur : Z
     //   13014: goto_w -> 13019
     //   13019: goto_w -> 13058
     //   13024: aload_0
     //   13025: getfield setcur : Z
     //   13028: ifne -> 13036
     //   13031: goto_w -> 13058
     //   13036: aload_0
     //   13037: new java/awt/Cursor
     //   13040: dup
     //   13041: iconst_0
     //   13042: invokespecial <init> : (I)V
     //   13045: invokevirtual setCursor : (Ljava/awt/Cursor;)V
     //   13048: aload_0
     //   13049: iconst_0
     //   13050: putfield setcur : Z
     //   13053: goto_w -> 13058
     //   13058: aload_0
     //   13059: getfield arrng : Z
     //   13062: ifne -> 13070
     //   13065: goto_w -> 13926
     //   13070: aload_0
     //   13071: iconst_m1
     //   13072: putfield chi : I
     //   13075: sipush #5000
     //   13078: istore #4
     //   13080: iconst_0
     //   13081: istore #5
     //   13083: iload #5
     //   13085: aload_0
     //   13086: getfield nob : I
     //   13089: if_icmplt -> 13097
     //   13092: goto_w -> 13743
     //   13097: aload_0
     //   13098: getfield co : [LContO;
     //   13101: iload #5
     //   13103: aaload
     //   13104: getfield colok : I
     //   13107: bipush #30
     //   13109: if_icmpne -> 13117
     //   13112: goto_w -> 13157
     //   13117: aload_0
     //   13118: getfield co : [LContO;
     //   13121: iload #5
     //   13123: aaload
     //   13124: getfield colok : I
     //   13127: bipush #32
     //   13129: if_icmpne -> 13137
     //   13132: goto_w -> 13157
     //   13137: aload_0
     //   13138: getfield co : [LContO;
     //   13141: iload #5
     //   13143: aaload
     //   13144: getfield colok : I
     //   13147: bipush #54
     //   13149: if_icmpeq -> 13157
     //   13152: goto_w -> 13735
     //   13157: aload_0
     //   13158: getfield co : [LContO;
     //   13161: iload #5
     //   13163: aaload
     //   13164: getfield errd : Z
     //   13167: ifeq -> 13175
     //   13170: goto_w -> 13735
     //   13175: aload_0
     //   13176: getfield m : LMedium;
     //   13179: getfield cx : I
     //   13182: aload_0
     //   13183: getfield co : [LContO;
     //   13186: iload #5
     //   13188: aaload
     //   13189: getfield x : I
     //   13192: aload_0
     //   13193: getfield m : LMedium;
     //   13196: getfield x : I
     //   13199: isub
     //   13200: aload_0
     //   13201: getfield m : LMedium;
     //   13204: getfield cx : I
     //   13207: isub
     //   13208: i2f
     //   13209: aload_0
     //   13210: getfield m : LMedium;
     //   13213: aload_0
     //   13214: getfield m : LMedium;
     //   13217: getfield xz : I
     //   13220: invokevirtual cos : (I)F
     //   13223: fmul
     //   13224: aload_0
     //   13225: getfield co : [LContO;
     //   13228: iload #5
     //   13230: aaload
     //   13231: getfield z : I
     //   13234: aload_0
     //   13235: getfield m : LMedium;
     //   13238: getfield z : I
     //   13241: isub
     //   13242: aload_0
     //   13243: getfield m : LMedium;
     //   13246: getfield cz : I
     //   13249: isub
     //   13250: i2f
     //   13251: aload_0
     //   13252: getfield m : LMedium;
     //   13255: aload_0
     //   13256: getfield m : LMedium;
     //   13259: getfield xz : I
     //   13262: invokevirtual sin : (I)F
     //   13265: fmul
     //   13266: fsub
     //   13267: f2i
     //   13268: iadd
     //   13269: istore #6
     //   13271: aload_0
     //   13272: getfield m : LMedium;
     //   13275: getfield cz : I
     //   13278: aload_0
     //   13279: getfield co : [LContO;
     //   13282: iload #5
     //   13284: aaload
     //   13285: getfield x : I
     //   13288: aload_0
     //   13289: getfield m : LMedium;
     //   13292: getfield x : I
     //   13295: isub
     //   13296: aload_0
     //   13297: getfield m : LMedium;
     //   13300: getfield cx : I
     //   13303: isub
     //   13304: i2f
     //   13305: aload_0
     //   13306: getfield m : LMedium;
     //   13309: aload_0
     //   13310: getfield m : LMedium;
     //   13313: getfield xz : I
     //   13316: invokevirtual sin : (I)F
     //   13319: fmul
     //   13320: aload_0
     //   13321: getfield co : [LContO;
     //   13324: iload #5
     //   13326: aaload
     //   13327: getfield z : I
     //   13330: aload_0
     //   13331: getfield m : LMedium;
     //   13334: getfield z : I
     //   13337: isub
     //   13338: aload_0
     //   13339: getfield m : LMedium;
     //   13342: getfield cz : I
     //   13345: isub
     //   13346: i2f
     //   13347: aload_0
     //   13348: getfield m : LMedium;
     //   13351: aload_0
     //   13352: getfield m : LMedium;
     //   13355: getfield xz : I
     //   13358: invokevirtual cos : (I)F
     //   13361: fmul
     //   13362: fadd
     //   13363: f2i
     //   13364: iadd
     //   13365: istore #7
     //   13367: aload_0
     //   13368: getfield m : LMedium;
     //   13371: getfield cy : I
     //   13374: aload_0
     //   13375: getfield co : [LContO;
     //   13378: iload #5
     //   13380: aaload
     //   13381: getfield y : I
     //   13384: aload_0
     //   13385: getfield m : LMedium;
     //   13388: getfield y : I
     //   13391: isub
     //   13392: aload_0
     //   13393: getfield m : LMedium;
     //   13396: getfield cy : I
     //   13399: isub
     //   13400: i2f
     //   13401: aload_0
     //   13402: getfield m : LMedium;
     //   13405: aload_0
     //   13406: getfield m : LMedium;
     //   13409: getfield zy : I
     //   13412: invokevirtual cos : (I)F
     //   13415: fmul
     //   13416: iload #7
     //   13418: aload_0
     //   13419: getfield m : LMedium;
     //   13422: getfield cz : I
     //   13425: isub
     //   13426: i2f
     //   13427: aload_0
     //   13428: getfield m : LMedium;
     //   13431: aload_0
     //   13432: getfield m : LMedium;
     //   13435: getfield zy : I
     //   13438: invokevirtual sin : (I)F
     //   13441: fmul
     //   13442: fsub
     //   13443: f2i
     //   13444: iadd
     //   13445: istore #8
     //   13447: aload_0
     //   13448: getfield m : LMedium;
     //   13451: getfield cz : I
     //   13454: aload_0
     //   13455: getfield co : [LContO;
     //   13458: iload #5
     //   13460: aaload
     //   13461: getfield y : I
     //   13464: aload_0
     //   13465: getfield m : LMedium;
     //   13468: getfield y : I
     //   13471: isub
     //   13472: aload_0
     //   13473: getfield m : LMedium;
     //   13476: getfield cy : I
     //   13479: isub
     //   13480: i2f
     //   13481: aload_0
     //   13482: getfield m : LMedium;
     //   13485: aload_0
     //   13486: getfield m : LMedium;
     //   13489: getfield zy : I
     //   13492: invokevirtual sin : (I)F
     //   13495: fmul
     //   13496: iload #7
     //   13498: aload_0
     //   13499: getfield m : LMedium;
     //   13502: getfield cz : I
     //   13505: isub
     //   13506: i2f
     //   13507: aload_0
     //   13508: getfield m : LMedium;
     //   13511: aload_0
     //   13512: getfield m : LMedium;
     //   13515: getfield zy : I
     //   13518: invokevirtual cos : (I)F
     //   13521: fmul
     //   13522: fadd
     //   13523: f2i
     //   13524: iadd
     //   13525: istore #9
     //   13527: aload_0
     //   13528: getfield xm : I
     //   13531: aload_0
     //   13532: iload #6
     //   13534: aload_0
     //   13535: getfield co : [LContO;
     //   13538: iload #5
     //   13540: aaload
     //   13541: getfield maxR : I
     //   13544: isub
     //   13545: iload #9
     //   13547: invokevirtual xs : (II)I
     //   13550: if_icmpgt -> 13558
     //   13553: goto_w -> 13730
     //   13558: aload_0
     //   13559: getfield xm : I
     //   13562: aload_0
     //   13563: iload #6
     //   13565: aload_0
     //   13566: getfield co : [LContO;
     //   13569: iload #5
     //   13571: aaload
     //   13572: getfield maxR : I
     //   13575: iadd
     //   13576: iload #9
     //   13578: invokevirtual xs : (II)I
     //   13581: if_icmplt -> 13589
     //   13584: goto_w -> 13730
     //   13589: aload_0
     //   13590: getfield ym : I
     //   13593: aload_0
     //   13594: iload #8
     //   13596: aload_0
     //   13597: getfield co : [LContO;
     //   13600: iload #5
     //   13602: aaload
     //   13603: getfield maxR : I
     //   13606: isub
     //   13607: iload #9
     //   13609: invokevirtual ys : (II)I
     //   13612: if_icmpgt -> 13620
     //   13615: goto_w -> 13730
     //   13620: aload_0
     //   13621: getfield ym : I
     //   13624: aload_0
     //   13625: iload #8
     //   13627: aload_0
     //   13628: getfield co : [LContO;
     //   13631: iload #5
     //   13633: aaload
     //   13634: getfield maxR : I
     //   13637: iadd
     //   13638: iload #9
     //   13640: invokevirtual ys : (II)I
     //   13643: if_icmplt -> 13651
     //   13646: goto_w -> 13730
     //   13651: aload_0
     //   13652: aload_0
     //   13653: getfield xm : I
     //   13656: aload_0
     //   13657: iload #6
     //   13659: iload #9
     //   13661: invokevirtual xs : (II)I
     //   13664: aload_0
     //   13665: getfield ym : I
     //   13668: aload_0
     //   13669: iload #8
     //   13671: iload #9
     //   13673: invokevirtual ys : (II)I
     //   13676: invokevirtual py : (IIII)I
     //   13679: iload #4
     //   13681: if_icmple -> 13689
     //   13684: goto_w -> 13730
     //   13689: aload_0
     //   13690: iload #5
     //   13692: putfield chi : I
     //   13695: aload_0
     //   13696: aload_0
     //   13697: getfield xm : I
     //   13700: aload_0
     //   13701: iload #6
     //   13703: iload #9
     //   13705: invokevirtual xs : (II)I
     //   13708: aload_0
     //   13709: getfield ym : I
     //   13712: aload_0
     //   13713: iload #8
     //   13715: iload #9
     //   13717: invokevirtual ys : (II)I
     //   13720: invokevirtual py : (IIII)I
     //   13723: istore #4
     //   13725: goto_w -> 13730
     //   13730: goto_w -> 13735
     //   13735: iinc #5, 1
     //   13738: goto_w -> 13083
     //   13743: aload_0
     //   13744: getfield chi : I
     //   13747: iconst_m1
     //   13748: if_icmpne -> 13756
     //   13751: goto_w -> 13853
     //   13756: aload_0
     //   13757: getfield setcur : Z
     //   13760: ifeq -> 13768
     //   13763: goto_w -> 13791
     //   13768: aload_0
     //   13769: new java/awt/Cursor
     //   13772: dup
     //   13773: bipush #13
     //   13775: invokespecial <init> : (I)V
     //   13778: invokevirtual setCursor : (Ljava/awt/Cursor;)V
     //   13781: aload_0
     //   13782: iconst_1
     //   13783: putfield setcur : Z
     //   13786: goto_w -> 13791
     //   13791: aload_0
     //   13792: getfield mouses : I
     //   13795: iconst_m1
     //   13796: if_icmpeq -> 13804
     //   13799: goto_w -> 13887
     //   13804: aload_0
     //   13805: dup
     //   13806: getfield arrcnt : I
     //   13809: iconst_1
     //   13810: iadd
     //   13811: putfield arrcnt : I
     //   13814: aload_0
     //   13815: getfield co : [LContO;
     //   13818: aload_0
     //   13819: getfield chi : I
     //   13822: aaload
     //   13823: aload_0
     //   13824: getfield arrcnt : I
     //   13827: putfield wh : I
     //   13830: aload_0
     //   13831: getfield co : [LContO;
     //   13834: aload_0
     //   13835: getfield chi : I
     //   13838: aaload
     //   13839: iconst_1
     //   13840: putfield errd : Z
     //   13843: aload_0
     //   13844: iconst_0
     //   13845: putfield mouses : I
     //   13848: goto_w -> 13887
     //   13853: aload_0
     //   13854: getfield setcur : Z
     //   13857: ifne -> 13865
     //   13860: goto_w -> 13887
     //   13865: aload_0
     //   13866: new java/awt/Cursor
     //   13869: dup
     //   13870: iconst_0
     //   13871: invokespecial <init> : (I)V
     //   13874: invokevirtual setCursor : (Ljava/awt/Cursor;)V
     //   13877: aload_0
     //   13878: iconst_0
     //   13879: putfield setcur : Z
     //   13882: goto_w -> 13887
     //   13887: goto_w -> 13926
     //   13892: aload_0
     //   13893: getfield setcur : Z
     //   13896: ifne -> 13904
     //   13899: goto_w -> 13926
     //   13904: aload_0
     //   13905: new java/awt/Cursor
     //   13908: dup
     //   13909: iconst_0
     //   13910: invokespecial <init> : (I)V
     //   13913: invokevirtual setCursor : (Ljava/awt/Cursor;)V
     //   13916: aload_0
     //   13917: iconst_0
     //   13918: putfield setcur : Z
     //   13921: goto_w -> 13926
     //   13926: aload_0
     //   13927: getfield epart : Z
     //   13930: ifne -> 13938
     //   13933: goto_w -> 14866
     //   13938: aload_0
     //   13939: getfield esp : I
     //   13942: iconst_m1
     //   13943: if_icmpne -> 13951
     //   13946: goto_w -> 14866
     //   13951: aload_0
     //   13952: getfield co : [LContO;
     //   13955: aload_0
     //   13956: getfield esp : I
     //   13959: aaload
     //   13960: getfield dist : I
     //   13963: ifne -> 13971
     //   13966: goto_w -> 14856
     //   13971: aload_0
     //   13972: getfield m : LMedium;
     //   13975: sipush #505
     //   13978: putfield cx : I
     //   13981: aload_0
     //   13982: getfield m : LMedium;
     //   13985: sipush #290
     //   13988: putfield cy : I
     //   13991: aload_0
     //   13992: getfield m : LMedium;
     //   13995: aload_0
     //   13996: getfield sx : I
     //   13999: aload_0
     //   14000: getfield m : LMedium;
     //   14003: getfield cx : I
     //   14006: isub
     //   14007: putfield x : I
     //   14010: aload_0
     //   14011: getfield m : LMedium;
     //   14014: aload_0
     //   14015: getfield sz : I
     //   14018: aload_0
     //   14019: getfield m : LMedium;
     //   14022: getfield cz : I
     //   14025: isub
     //   14026: putfield z : I
     //   14029: aload_0
     //   14030: getfield m : LMedium;
     //   14033: aload_0
     //   14034: getfield sy : I
     //   14037: putfield y : I
     //   14040: aload_0
     //   14041: getfield m : LMedium;
     //   14044: getfield cx : I
     //   14047: aload_0
     //   14048: getfield co : [LContO;
     //   14051: aload_0
     //   14052: getfield esp : I
     //   14055: aaload
     //   14056: getfield x : I
     //   14059: aload_0
     //   14060: getfield m : LMedium;
     //   14063: getfield x : I
     //   14066: isub
     //   14067: aload_0
     //   14068: getfield m : LMedium;
     //   14071: getfield cx : I
     //   14074: isub
     //   14075: i2f
     //   14076: aload_0
     //   14077: getfield m : LMedium;
     //   14080: aload_0
     //   14081: getfield m : LMedium;
     //   14084: getfield xz : I
     //   14087: invokevirtual cos : (I)F
     //   14090: fmul
     //   14091: aload_0
     //   14092: getfield co : [LContO;
     //   14095: aload_0
     //   14096: getfield esp : I
     //   14099: aaload
     //   14100: getfield z : I
     //   14103: aload_0
     //   14104: getfield m : LMedium;
     //   14107: getfield z : I
     //   14110: isub
     //   14111: aload_0
     //   14112: getfield m : LMedium;
     //   14115: getfield cz : I
     //   14118: isub
     //   14119: i2f
     //   14120: aload_0
     //   14121: getfield m : LMedium;
     //   14124: aload_0
     //   14125: getfield m : LMedium;
     //   14128: getfield xz : I
     //   14131: invokevirtual sin : (I)F
     //   14134: fmul
     //   14135: fsub
     //   14136: f2i
     //   14137: iadd
     //   14138: istore #4
     //   14140: aload_0
     //   14141: getfield m : LMedium;
     //   14144: getfield cz : I
     //   14147: aload_0
     //   14148: getfield co : [LContO;
     //   14151: aload_0
     //   14152: getfield esp : I
     //   14155: aaload
     //   14156: getfield x : I
     //   14159: aload_0
     //   14160: getfield m : LMedium;
     //   14163: getfield x : I
     //   14166: isub
     //   14167: aload_0
     //   14168: getfield m : LMedium;
     //   14171: getfield cx : I
     //   14174: isub
     //   14175: i2f
     //   14176: aload_0
     //   14177: getfield m : LMedium;
     //   14180: aload_0
     //   14181: getfield m : LMedium;
     //   14184: getfield xz : I
     //   14187: invokevirtual sin : (I)F
     //   14190: fmul
     //   14191: aload_0
     //   14192: getfield co : [LContO;
     //   14195: aload_0
     //   14196: getfield esp : I
     //   14199: aaload
     //   14200: getfield z : I
     //   14203: aload_0
     //   14204: getfield m : LMedium;
     //   14207: getfield z : I
     //   14210: isub
     //   14211: aload_0
     //   14212: getfield m : LMedium;
     //   14215: getfield cz : I
     //   14218: isub
     //   14219: i2f
     //   14220: aload_0
     //   14221: getfield m : LMedium;
     //   14224: aload_0
     //   14225: getfield m : LMedium;
     //   14228: getfield xz : I
     //   14231: invokevirtual cos : (I)F
     //   14234: fmul
     //   14235: fadd
     //   14236: f2i
     //   14237: iadd
     //   14238: istore #5
     //   14240: aload_0
     //   14241: getfield m : LMedium;
     //   14244: getfield cy : I
     //   14247: aload_0
     //   14248: getfield co : [LContO;
     //   14251: aload_0
     //   14252: getfield esp : I
     //   14255: aaload
     //   14256: getfield y : I
     //   14259: aload_0
     //   14260: getfield m : LMedium;
     //   14263: getfield y : I
     //   14266: isub
     //   14267: aload_0
     //   14268: getfield m : LMedium;
     //   14271: getfield cy : I
     //   14274: isub
     //   14275: i2f
     //   14276: aload_0
     //   14277: getfield m : LMedium;
     //   14280: aload_0
     //   14281: getfield m : LMedium;
     //   14284: getfield zy : I
     //   14287: invokevirtual cos : (I)F
     //   14290: fmul
     //   14291: iload #5
     //   14293: aload_0
     //   14294: getfield m : LMedium;
     //   14297: getfield cz : I
     //   14300: isub
     //   14301: i2f
     //   14302: aload_0
     //   14303: getfield m : LMedium;
     //   14306: aload_0
     //   14307: getfield m : LMedium;
     //   14310: getfield zy : I
     //   14313: invokevirtual sin : (I)F
     //   14316: fmul
     //   14317: fsub
     //   14318: f2i
     //   14319: iadd
     //   14320: istore #6
     //   14322: aload_0
     //   14323: getfield m : LMedium;
     //   14326: getfield cz : I
     //   14329: aload_0
     //   14330: getfield co : [LContO;
     //   14333: aload_0
     //   14334: getfield esp : I
     //   14337: aaload
     //   14338: getfield y : I
     //   14341: aload_0
     //   14342: getfield m : LMedium;
     //   14345: getfield y : I
     //   14348: isub
     //   14349: aload_0
     //   14350: getfield m : LMedium;
     //   14353: getfield cy : I
     //   14356: isub
     //   14357: i2f
     //   14358: aload_0
     //   14359: getfield m : LMedium;
     //   14362: aload_0
     //   14363: getfield m : LMedium;
     //   14366: getfield zy : I
     //   14369: invokevirtual sin : (I)F
     //   14372: fmul
     //   14373: iload #5
     //   14375: aload_0
     //   14376: getfield m : LMedium;
     //   14379: getfield cz : I
     //   14382: isub
     //   14383: i2f
     //   14384: aload_0
     //   14385: getfield m : LMedium;
     //   14388: aload_0
     //   14389: getfield m : LMedium;
     //   14392: getfield zy : I
     //   14395: invokevirtual cos : (I)F
     //   14398: fmul
     //   14399: fadd
     //   14400: f2i
     //   14401: iadd
     //   14402: istore #7
     //   14404: aload_0
     //   14405: iload #4
     //   14407: iload #7
     //   14409: invokevirtual xs : (II)I
     //   14412: istore #8
     //   14414: aload_0
     //   14415: iload #6
     //   14417: iload #7
     //   14419: invokevirtual ys : (II)I
     //   14422: istore #9
     //   14424: aload_0
     //   14425: getfield rd : Ljava/awt/Graphics2D;
     //   14428: new java/awt/Color
     //   14431: dup
     //   14432: sipush #225
     //   14435: sipush #225
     //   14438: sipush #225
     //   14441: invokespecial <init> : (III)V
     //   14444: invokevirtual setColor : (Ljava/awt/Color;)V
     //   14447: aload_0
     //   14448: getfield rd : Ljava/awt/Graphics2D;
     //   14451: iload #8
     //   14453: iload #9
     //   14455: bipush #90
     //   14457: bipush #88
     //   14459: invokevirtual fillRect : (IIII)V
     //   14462: aload_0
     //   14463: getfield rd : Ljava/awt/Graphics2D;
     //   14466: new java/awt/Color
     //   14469: dup
     //   14470: sipush #138
     //   14473: sipush #147
     //   14476: sipush #160
     //   14479: invokespecial <init> : (III)V
     //   14482: invokevirtual setColor : (Ljava/awt/Color;)V
     //   14485: aload_0
     //   14486: getfield rd : Ljava/awt/Graphics2D;
     //   14489: iload #8
     //   14491: iload #9
     //   14493: bipush #90
     //   14495: bipush #88
     //   14497: invokevirtual drawRect : (IIII)V
     //   14500: aload_0
     //   14501: ldc_w '   Edit   '
     //   14504: iload #8
     //   14506: bipush #45
     //   14508: iadd
     //   14509: iload #9
     //   14511: bipush #22
     //   14513: iadd
     //   14514: iconst_3
     //   14515: iconst_0
     //   14516: invokevirtual button : (Ljava/lang/String;IIIZ)Z
     //   14519: ifne -> 14527
     //   14522: goto_w -> 14561
     //   14527: aload_0
     //   14528: iconst_1
     //   14529: invokevirtual copyesp : (Z)V
     //   14532: aload_0
     //   14533: invokevirtual removesp : ()V
     //   14536: aload_0
     //   14537: iconst_0
     //   14538: putfield lxm : I
     //   14541: aload_0
     //   14542: iconst_0
     //   14543: putfield lym : I
     //   14546: aload_0
     //   14547: iconst_2
     //   14548: putfield cntout : I
     //   14551: aload_0
     //   14552: iconst_0
     //   14553: putfield epart : Z
     //   14556: goto_w -> 14561
     //   14561: aload_0
     //   14562: ldc_w ' Remove '
     //   14565: iload #8
     //   14567: bipush #45
     //   14569: iadd
     //   14570: iload #9
     //   14572: bipush #49
     //   14574: iadd
     //   14575: iconst_3
     //   14576: iconst_0
     //   14577: invokevirtual button : (Ljava/lang/String;IIIZ)Z
     //   14580: ifne -> 14588
     //   14583: goto_w -> 14607
     //   14588: aload_0
     //   14589: invokevirtual removesp : ()V
     //   14592: aload_0
     //   14593: iconst_m1
     //   14594: putfield esp : I
     //   14597: aload_0
     //   14598: iconst_0
     //   14599: putfield mouses : I
     //   14602: goto_w -> 14607
     //   14607: aload_0
     //   14608: ldc_w '  Copy  '
     //   14611: iload #8
     //   14613: bipush #45
     //   14615: iadd
     //   14616: iload #9
     //   14618: bipush #76
     //   14620: iadd
     //   14621: iconst_3
     //   14622: iconst_0
     //   14623: invokevirtual button : (Ljava/lang/String;IIIZ)Z
     //   14626: ifne -> 14634
     //   14629: goto_w -> 14664
     //   14634: aload_0
     //   14635: iconst_0
     //   14636: invokevirtual copyesp : (Z)V
     //   14639: aload_0
     //   14640: iconst_0
     //   14641: putfield lxm : I
     //   14644: aload_0
     //   14645: iconst_0
     //   14646: putfield lym : I
     //   14649: aload_0
     //   14650: iconst_2
     //   14651: putfield cntout : I
     //   14654: aload_0
     //   14655: iconst_0
     //   14656: putfield epart : Z
     //   14659: goto_w -> 14664
     //   14664: aload_0
     //   14665: getfield rd : Ljava/awt/Graphics2D;
     //   14668: new java/awt/Color
     //   14671: dup
     //   14672: sipush #255
     //   14675: iconst_0
     //   14676: iconst_0
     //   14677: invokespecial <init> : (III)V
     //   14680: invokevirtual setColor : (Ljava/awt/Color;)V
     //   14683: aload_0
     //   14684: getfield rd : Ljava/awt/Graphics2D;
     //   14687: ldc_w 'x'
     //   14690: iload #8
     //   14692: bipush #82
     //   14694: iadd
     //   14695: iload #9
     //   14697: iconst_2
     //   14698: isub
     //   14699: invokevirtual drawString : (Ljava/lang/String;II)V
     //   14702: aload_0
     //   14703: getfield xm : I
     //   14706: sipush #248
     //   14709: if_icmpgt -> 14717
     //   14712: goto_w -> 14851
     //   14717: aload_0
     //   14718: getfield xm : I
     //   14721: sipush #762
     //   14724: if_icmplt -> 14732
     //   14727: goto_w -> 14851
     //   14732: aload_0
     //   14733: getfield ym : I
     //   14736: bipush #63
     //   14738: if_icmpgt -> 14746
     //   14741: goto_w -> 14851
     //   14746: aload_0
     //   14747: getfield ym : I
     //   14750: sipush #517
     //   14753: if_icmplt -> 14761
     //   14756: goto_w -> 14851
     //   14761: aload_0
     //   14762: getfield mouses : I
     //   14765: iconst_1
     //   14766: if_icmpeq -> 14774
     //   14769: goto_w -> 14851
     //   14774: aload_0
     //   14775: getfield xm : I
     //   14778: iload #8
     //   14780: if_icmpge -> 14788
     //   14783: goto_w -> 14836
     //   14788: aload_0
     //   14789: getfield xm : I
     //   14792: iload #8
     //   14794: bipush #90
     //   14796: iadd
     //   14797: if_icmple -> 14805
     //   14800: goto_w -> 14836
     //   14805: aload_0
     //   14806: getfield ym : I
     //   14809: iload #9
     //   14811: if_icmpge -> 14819
     //   14814: goto_w -> 14836
     //   14819: aload_0
     //   14820: getfield ym : I
     //   14823: iload #9
     //   14825: bipush #88
     //   14827: iadd
     //   14828: if_icmpgt -> 14836
     //   14831: goto_w -> 14851
     //   14836: aload_0
     //   14837: iconst_m1
     //   14838: putfield esp : I
     //   14841: aload_0
     //   14842: iconst_0
     //   14843: putfield mouses : I
     //   14846: goto_w -> 14851
     //   14851: goto_w -> 14866
     //   14856: aload_0
     //   14857: iconst_m1
     //   14858: putfield esp : I
     //   14861: goto_w -> 14866
     //   14866: aload_0
     //   14867: getfield rd : Ljava/awt/Graphics2D;
     //   14870: new java/awt/Color
     //   14873: dup
     //   14874: sipush #225
     //   14877: sipush #225
     //   14880: sipush #225
     //   14883: invokespecial <init> : (III)V
     //   14886: invokevirtual setColor : (Ljava/awt/Color;)V
     //   14889: aload_0
     //   14890: getfield rd : Ljava/awt/Graphics2D;
     //   14893: sipush #248
     //   14896: bipush #25
     //   14898: sipush #514
     //   14901: bipush #38
     //   14903: invokevirtual fillRect : (IIII)V
     //   14906: aload_0
     //   14907: getfield rd : Ljava/awt/Graphics2D;
     //   14910: iconst_0
     //   14911: bipush #25
     //   14913: sipush #248
     //   14916: sipush #530
     //   14919: invokevirtual fillRect : (IIII)V
     //   14922: aload_0
     //   14923: getfield rd : Ljava/awt/Graphics2D;
     //   14926: sipush #248
     //   14929: sipush #517
     //   14932: sipush #514
     //   14935: bipush #38
     //   14937: invokevirtual fillRect : (IIII)V
     //   14940: aload_0
     //   14941: getfield rd : Ljava/awt/Graphics2D;
     //   14944: sipush #762
     //   14947: bipush #25
     //   14949: bipush #38
     //   14951: sipush #530
     //   14954: invokevirtual fillRect : (IIII)V
     //   14957: aload_0
     //   14958: getfield sptyp : I
     //   14961: bipush #6
     //   14963: if_icmpeq -> 14971
     //   14966: goto_w -> 15691
     //   14971: aload_0
     //   14972: getfield rd : Ljava/awt/Graphics2D;
     //   14975: new java/awt/Color
     //   14978: dup
     //   14979: iconst_0
     //   14980: iconst_0
     //   14981: iconst_0
     //   14982: invokespecial <init> : (III)V
     //   14985: invokevirtual setColor : (Ljava/awt/Color;)V
     //   14988: aload_0
     //   14989: getfield rd : Ljava/awt/Graphics2D;
     //   14992: new java/awt/Font
     //   14995: dup
     //   14996: ldc_w 'Arial'
     //   14999: iconst_1
     //   15000: bipush #12
     //   15002: invokespecial <init> : (Ljava/lang/String;II)V
     //   15005: invokevirtual setFont : (Ljava/awt/Font;)V
     //   15008: aload_0
     //   15009: getfield rd : Ljava/awt/Graphics2D;
     //   15012: ldc_w 'Radius:'
     //   15015: bipush #11
     //   15017: bipush #97
     //   15019: invokevirtual drawString : (Ljava/lang/String;II)V
     //   15022: aload_0
     //   15023: getfield rd : Ljava/awt/Graphics2D;
     //   15026: ldc_w 'Height:'
     //   15029: bipush #14
     //   15031: bipush #117
     //   15033: invokevirtual drawString : (Ljava/lang/String;II)V
     //   15036: iconst_0
     //   15037: istore #4
     //   15039: aload_0
     //   15040: getfield xm : I
     //   15043: bipush #57
     //   15045: if_icmpgt -> 15053
     //   15048: goto_w -> 15104
     //   15053: aload_0
     //   15054: getfield xm : I
     //   15057: sipush #204
     //   15060: if_icmplt -> 15068
     //   15063: goto_w -> 15104
     //   15068: aload_0
     //   15069: getfield ym : I
     //   15072: bipush #90
     //   15074: if_icmpgt -> 15082
     //   15077: goto_w -> 15104
     //   15082: aload_0
     //   15083: getfield ym : I
     //   15086: bipush #99
     //   15088: if_icmplt -> 15096
     //   15091: goto_w -> 15104
     //   15096: iconst_1
     //   15097: istore #4
     //   15099: goto_w -> 15104
     //   15104: aload_0
     //   15105: getfield rd : Ljava/awt/Graphics2D;
     //   15108: new java/awt/Color
     //   15111: dup
     //   15112: sipush #136
     //   15115: sipush #148
     //   15118: sipush #170
     //   15121: invokespecial <init> : (III)V
     //   15124: invokevirtual setColor : (Ljava/awt/Color;)V
     //   15127: iload #4
     //   15129: ifeq -> 15137
     //   15132: goto_w -> 15150
     //   15137: aload_0
     //   15138: getfield mouseon : I
     //   15141: iconst_1
     //   15142: if_icmpeq -> 15150
     //   15145: goto_w -> 15188
     //   15150: aload_0
     //   15151: getfield rd : Ljava/awt/Graphics2D;
     //   15154: bipush #57
     //   15156: bipush #90
     //   15158: sipush #147
     //   15161: bipush #8
     //   15163: invokevirtual drawRect : (IIII)V
     //   15166: aload_0
     //   15167: getfield rd : Ljava/awt/Graphics2D;
     //   15170: new java/awt/Color
     //   15173: dup
     //   15174: iconst_0
     //   15175: iconst_0
     //   15176: iconst_0
     //   15177: invokespecial <init> : (III)V
     //   15180: invokevirtual setColor : (Ljava/awt/Color;)V
     //   15183: goto_w -> 15188
     //   15188: aload_0
     //   15189: getfield rd : Ljava/awt/Graphics2D;
     //   15192: bipush #57
     //   15194: bipush #94
     //   15196: sipush #204
     //   15199: bipush #94
     //   15201: invokevirtual drawLine : (IIII)V
     //   15204: aload_0
     //   15205: getfield mouseon : I
     //   15208: iconst_1
     //   15209: if_icmpeq -> 15217
     //   15212: goto_w -> 15287
     //   15217: aload_0
     //   15218: aload_0
     //   15219: getfield xm : I
     //   15222: bipush #57
     //   15224: isub
     //   15225: i2f
     //   15226: ldc_w 36.75
     //   15229: fdiv
     //   15230: fconst_2
     //   15231: fadd
     //   15232: putfield pwd : F
     //   15235: aload_0
     //   15236: getfield pwd : F
     //   15239: fconst_2
     //   15240: fcmpg
     //   15241: iflt -> 15249
     //   15244: goto_w -> 15259
     //   15249: aload_0
     //   15250: fconst_2
     //   15251: putfield pwd : F
     //   15254: goto_w -> 15259
     //   15259: aload_0
     //   15260: getfield pwd : F
     //   15263: ldc_w 6.0
     //   15266: fcmpl
     //   15267: ifgt -> 15275
     //   15270: goto_w -> 15287
     //   15275: aload_0
     //   15276: ldc_w 6.0
     //   15279: putfield pwd : F
     //   15282: goto_w -> 15287
     //   15287: aload_0
     //   15288: getfield rd : Ljava/awt/Graphics2D;
     //   15291: ldc_w 57.0
     //   15294: aload_0
     //   15295: getfield pwd : F
     //   15298: fconst_2
     //   15299: fsub
     //   15300: ldc_w 36.75
     //   15303: fmul
     //   15304: fadd
     //   15305: f2i
     //   15306: bipush #90
     //   15308: iconst_2
     //   15309: bipush #8
     //   15311: invokevirtual drawRect : (IIII)V
     //   15314: iconst_0
     //   15315: istore #5
     //   15317: aload_0
     //   15318: getfield xm : I
     //   15321: bipush #57
     //   15323: if_icmpgt -> 15331
     //   15326: goto_w -> 15382
     //   15331: aload_0
     //   15332: getfield xm : I
     //   15335: sipush #204
     //   15338: if_icmplt -> 15346
     //   15341: goto_w -> 15382
     //   15346: aload_0
     //   15347: getfield ym : I
     //   15350: bipush #110
     //   15352: if_icmpgt -> 15360
     //   15355: goto_w -> 15382
     //   15360: aload_0
     //   15361: getfield ym : I
     //   15364: bipush #119
     //   15366: if_icmplt -> 15374
     //   15369: goto_w -> 15382
     //   15374: iconst_1
     //   15375: istore #5
     //   15377: goto_w -> 15382
     //   15382: aload_0
     //   15383: getfield rd : Ljava/awt/Graphics2D;
     //   15386: new java/awt/Color
     //   15389: dup
     //   15390: sipush #136
     //   15393: sipush #148
     //   15396: sipush #170
     //   15399: invokespecial <init> : (III)V
     //   15402: invokevirtual setColor : (Ljava/awt/Color;)V
     //   15405: iload #5
     //   15407: ifeq -> 15415
     //   15410: goto_w -> 15428
     //   15415: aload_0
     //   15416: getfield mouseon : I
     //   15419: iconst_2
     //   15420: if_icmpeq -> 15428
     //   15423: goto_w -> 15466
     //   15428: aload_0
     //   15429: getfield rd : Ljava/awt/Graphics2D;
     //   15432: bipush #57
     //   15434: bipush #110
     //   15436: sipush #147
     //   15439: bipush #8
     //   15441: invokevirtual drawRect : (IIII)V
     //   15444: aload_0
     //   15445: getfield rd : Ljava/awt/Graphics2D;
     //   15448: new java/awt/Color
     //   15451: dup
     //   15452: iconst_0
     //   15453: iconst_0
     //   15454: iconst_0
     //   15455: invokespecial <init> : (III)V
     //   15458: invokevirtual setColor : (Ljava/awt/Color;)V
     //   15461: goto_w -> 15466
     //   15466: aload_0
     //   15467: getfield rd : Ljava/awt/Graphics2D;
     //   15470: bipush #57
     //   15472: bipush #114
     //   15474: sipush #204
     //   15477: bipush #114
     //   15479: invokevirtual drawLine : (IIII)V
     //   15482: aload_0
     //   15483: getfield mouseon : I
     //   15486: iconst_2
     //   15487: if_icmpeq -> 15495
     //   15490: goto_w -> 15565
     //   15495: aload_0
     //   15496: aload_0
     //   15497: getfield xm : I
     //   15500: bipush #57
     //   15502: isub
     //   15503: i2f
     //   15504: ldc_w 36.75
     //   15507: fdiv
     //   15508: fconst_2
     //   15509: fadd
     //   15510: putfield phd : F
     //   15513: aload_0
     //   15514: getfield phd : F
     //   15517: fconst_2
     //   15518: fcmpg
     //   15519: iflt -> 15527
     //   15522: goto_w -> 15537
     //   15527: aload_0
     //   15528: fconst_2
     //   15529: putfield phd : F
     //   15532: goto_w -> 15537
     //   15537: aload_0
     //   15538: getfield phd : F
     //   15541: ldc_w 6.0
     //   15544: fcmpl
     //   15545: ifgt -> 15553
     //   15548: goto_w -> 15565
     //   15553: aload_0
     //   15554: ldc_w 6.0
     //   15557: putfield phd : F
     //   15560: goto_w -> 15565
     //   15565: aload_0
     //   15566: getfield rd : Ljava/awt/Graphics2D;
     //   15569: ldc_w 57.0
     //   15572: aload_0
     //   15573: getfield phd : F
     //   15576: fconst_2
     //   15577: fsub
     //   15578: ldc_w 36.75
     //   15581: fmul
     //   15582: fadd
     //   15583: f2i
     //   15584: bipush #110
     //   15586: iconst_2
     //   15587: bipush #8
     //   15589: invokevirtual drawRect : (IIII)V
     //   15592: aload_0
     //   15593: getfield mouses : I
     //   15596: iconst_1
     //   15597: if_icmpeq -> 15605
     //   15600: goto_w -> 15645
     //   15605: iload #4
     //   15607: ifne -> 15615
     //   15610: goto_w -> 15625
     //   15615: aload_0
     //   15616: iconst_1
     //   15617: putfield mouseon : I
     //   15620: goto_w -> 15625
     //   15625: iload #5
     //   15627: ifne -> 15635
     //   15630: goto_w -> 15686
     //   15635: aload_0
     //   15636: iconst_2
     //   15637: putfield mouseon : I
     //   15640: goto_w -> 15686
     //   15645: aload_0
     //   15646: getfield mouseon : I
     //   15649: iconst_1
     //   15650: if_icmpne -> 15658
     //   15653: goto_w -> 15671
     //   15658: aload_0
     //   15659: getfield mouseon : I
     //   15662: iconst_2
/*      */     //   15663: if_icmpeq -> 15671
/*      */     //   15666: goto_w -> 15681
/*      */     //   15671: aload_0
/*      */     //   15672: iconst_0
/*      */     //   15673: putfield pgen : Z
/*      */     //   15676: goto_w -> 15681
/*      */     //   15681: aload_0
/*      */     //   15682: iconst_m1
/*      */     //   15683: putfield mouseon : I
/*      */     //   15686: goto_w -> 15691
/*      */     //   15691: iconst_0
/*      */     //   15692: istore #4
/*      */     //   15694: aload_0
/*      */     //   15695: getfield xm : I
/*      */     //   15698: sipush #482
/*      */     //   15701: if_icmpgt -> 15709
/*      */     //   15704: goto_w -> 15752
/*      */     //   15709: aload_0
/*      */     //   15710: getfield xm : I
/*      */     //   15713: sipush #529
/*      */     //   15716: if_icmplt -> 15724
/*      */     //   15719: goto_w -> 15752
/*      */     //   15724: aload_0
/*      */     //   15725: getfield ym : I
/*      */     //   15728: bipush #35
/*      */     //   15730: if_icmpgt -> 15738
/*      */     //   15733: goto_w -> 15752
/*      */     //   15738: aload_0
/*      */     //   15739: getfield ym : I
/*      */     //   15742: bipush #61
/*      */     //   15744: if_icmpge -> 15752
/*      */     //   15747: goto_w -> 15764
/*      */     //   15752: aload_0
/*      */     //   15753: getfield up : Z
/*      */     //   15756: ifne -> 15764
/*      */     //   15759: goto_w -> 15809
/*      */     //   15764: iconst_1
/*      */     //   15765: istore #4
/*      */     //   15767: aload_0
/*      */     //   15768: getfield mouses : I
/*      */     //   15771: iconst_1
/*      */     //   15772: if_icmpne -> 15780
/*      */     //   15775: goto_w -> 15792
/*      */     //   15780: aload_0
/*      */     //   15781: getfield up : Z
/*      */     //   15784: ifne -> 15792
/*      */     //   15787: goto_w -> 15809
/*      */     //   15792: aload_0
/*      */     //   15793: dup
/*      */     //   15794: getfield sz : I
/*      */     //   15797: sipush #500
/*      */     //   15800: iadd
/*      */     //   15801: putfield sz : I
/*      */     //   15804: goto_w -> 15809
/*      */     //   15809: aload_0
/*      */     //   15810: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   15813: aload_0
/*      */     //   15814: getfield su : [Ljava/awt/Image;
/*      */     //   15817: iload #4
/*      */     //   15819: aaload
/*      */     //   15820: sipush #482
/*      */     //   15823: bipush #35
/*      */     //   15825: aconst_null
/*      */     //   15826: invokevirtual drawImage : (Ljava/awt/Image;IILjava/awt/image/ImageObserver;)Z
/*      */     //   15829: pop
/*      */     //   15830: iconst_0
/*      */     //   15831: istore #4
/*      */     //   15833: aload_0
/*      */     //   15834: getfield xm : I
/*      */     //   15837: sipush #482
/*      */     //   15840: if_icmpgt -> 15848
/*      */     //   15843: goto_w -> 15893
/*      */     //   15848: aload_0
/*      */     //   15849: getfield xm : I
/*      */     //   15852: sipush #529
/*      */     //   15855: if_icmplt -> 15863
/*      */     //   15858: goto_w -> 15893
/*      */     //   15863: aload_0
/*      */     //   15864: getfield ym : I
/*      */     //   15867: sipush #519
/*      */     //   15870: if_icmpgt -> 15878
/*      */     //   15873: goto_w -> 15893
/*      */     //   15878: aload_0
/*      */     //   15879: getfield ym : I
/*      */     //   15882: sipush #545
/*      */     //   15885: if_icmpge -> 15893
/*      */     //   15888: goto_w -> 15905
/*      */     //   15893: aload_0
/*      */     //   15894: getfield down : Z
/*      */     //   15897: ifne -> 15905
/*      */     //   15900: goto_w -> 15950
/*      */     //   15905: iconst_1
/*      */     //   15906: istore #4
/*      */     //   15908: aload_0
/*      */     //   15909: getfield mouses : I
/*      */     //   15912: iconst_1
/*      */     //   15913: if_icmpne -> 15921
/*      */     //   15916: goto_w -> 15933
/*      */     //   15921: aload_0
/*      */     //   15922: getfield down : Z
/*      */     //   15925: ifne -> 15933
/*      */     //   15928: goto_w -> 15950
/*      */     //   15933: aload_0
/*      */     //   15934: dup
/*      */     //   15935: getfield sz : I
/*      */     //   15938: sipush #500
/*      */     //   15941: isub
/*      */     //   15942: putfield sz : I
/*      */     //   15945: goto_w -> 15950
/*      */     //   15950: aload_0
/*      */     //   15951: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   15954: aload_0
/*      */     //   15955: getfield sd : [Ljava/awt/Image;
/*      */     //   15958: iload #4
/*      */     //   15960: aaload
/*      */     //   15961: sipush #482
/*      */     //   15964: sipush #519
/*      */     //   15967: aconst_null
/*      */     //   15968: invokevirtual drawImage : (Ljava/awt/Image;IILjava/awt/image/ImageObserver;)Z
/*      */     //   15971: pop
/*      */     //   15972: iconst_0
/*      */     //   15973: istore #4
/*      */     //   15975: aload_0
/*      */     //   15976: getfield xm : I
/*      */     //   15979: sipush #220
/*      */     //   15982: if_icmpgt -> 15990
/*      */     //   15985: goto_w -> 16035
/*      */     //   15990: aload_0
/*      */     //   15991: getfield xm : I
/*      */     //   15994: sipush #246
/*      */     //   15997: if_icmplt -> 16005
/*      */     //   16000: goto_w -> 16035
/*      */     //   16005: aload_0
/*      */     //   16006: getfield ym : I
/*      */     //   16009: sipush #264
/*      */     //   16012: if_icmpgt -> 16020
/*      */     //   16015: goto_w -> 16035
/*      */     //   16020: aload_0
/*      */     //   16021: getfield ym : I
/*      */     //   16024: sipush #311
/*      */     //   16027: if_icmpge -> 16035
/*      */     //   16030: goto_w -> 16047
/*      */     //   16035: aload_0
/*      */     //   16036: getfield left : Z
/*      */     //   16039: ifne -> 16047
/*      */     //   16042: goto_w -> 16092
/*      */     //   16047: iconst_1
/*      */     //   16048: istore #4
/*      */     //   16050: aload_0
/*      */     //   16051: getfield mouses : I
/*      */     //   16054: iconst_1
/*      */     //   16055: if_icmpne -> 16063
/*      */     //   16058: goto_w -> 16075
/*      */     //   16063: aload_0
/*      */     //   16064: getfield left : Z
/*      */     //   16067: ifne -> 16075
/*      */     //   16070: goto_w -> 16092
/*      */     //   16075: aload_0
/*      */     //   16076: dup
/*      */     //   16077: getfield sx : I
/*      */     //   16080: sipush #500
/*      */     //   16083: isub
/*      */     //   16084: putfield sx : I
/*      */     //   16087: goto_w -> 16092
/*      */     //   16092: aload_0
/*      */     //   16093: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   16096: aload_0
/*      */     //   16097: getfield sl : [Ljava/awt/Image;
/*      */     //   16100: iload #4
/*      */     //   16102: aaload
/*      */     //   16103: sipush #220
/*      */     //   16106: sipush #264
/*      */     //   16109: aconst_null
/*      */     //   16110: invokevirtual drawImage : (Ljava/awt/Image;IILjava/awt/image/ImageObserver;)Z
/*      */     //   16113: pop
/*      */     //   16114: iconst_0
/*      */     //   16115: istore #4
/*      */     //   16117: aload_0
/*      */     //   16118: getfield xm : I
/*      */     //   16121: sipush #764
/*      */     //   16124: if_icmpgt -> 16132
/*      */     //   16127: goto_w -> 16177
/*      */     //   16132: aload_0
/*      */     //   16133: getfield xm : I
/*      */     //   16136: sipush #790
/*      */     //   16139: if_icmplt -> 16147
/*      */     //   16142: goto_w -> 16177
/*      */     //   16147: aload_0
/*      */     //   16148: getfield ym : I
/*      */     //   16151: sipush #264
/*      */     //   16154: if_icmpgt -> 16162
/*      */     //   16157: goto_w -> 16177
/*      */     //   16162: aload_0
/*      */     //   16163: getfield ym : I
/*      */     //   16166: sipush #311
/*      */     //   16169: if_icmpge -> 16177
/*      */     //   16172: goto_w -> 16189
/*      */     //   16177: aload_0
/*      */     //   16178: getfield right : Z
/*      */     //   16181: ifne -> 16189
/*      */     //   16184: goto_w -> 16234
/*      */     //   16189: iconst_1
/*      */     //   16190: istore #4
/*      */     //   16192: aload_0
/*      */     //   16193: getfield mouses : I
/*      */     //   16196: iconst_1
/*      */     //   16197: if_icmpne -> 16205
/*      */     //   16200: goto_w -> 16217
/*      */     //   16205: aload_0
/*      */     //   16206: getfield right : Z
/*      */     //   16209: ifne -> 16217
/*      */     //   16212: goto_w -> 16234
/*      */     //   16217: aload_0
/*      */     //   16218: dup
/*      */     //   16219: getfield sx : I
/*      */     //   16222: sipush #500
/*      */     //   16225: iadd
/*      */     //   16226: putfield sx : I
/*      */     //   16229: goto_w -> 16234
/*      */     //   16234: aload_0
/*      */     //   16235: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   16238: aload_0
/*      */     //   16239: getfield sr : [Ljava/awt/Image;
/*      */     //   16242: iload #4
/*      */     //   16244: aaload
/*      */     //   16245: sipush #764
/*      */     //   16248: sipush #264
/*      */     //   16251: aconst_null
/*      */     //   16252: invokevirtual drawImage : (Ljava/awt/Image;IILjava/awt/image/ImageObserver;)Z
/*      */     //   16255: pop
/*      */     //   16256: iconst_0
/*      */     //   16257: istore #4
/*      */     //   16259: aload_0
/*      */     //   16260: getfield xm : I
/*      */     //   16263: sipush #616
/*      */     //   16266: if_icmpgt -> 16274
/*      */     //   16269: goto_w -> 16317
/*      */     //   16274: aload_0
/*      */     //   16275: getfield xm : I
/*      */     //   16278: sipush #677
/*      */     //   16281: if_icmplt -> 16289
/*      */     //   16284: goto_w -> 16317
/*      */     //   16289: aload_0
/*      */     //   16290: getfield ym : I
/*      */     //   16293: bipush #30
/*      */     //   16295: if_icmpgt -> 16303
/*      */     //   16298: goto_w -> 16317
/*      */     //   16303: aload_0
/*      */     //   16304: getfield ym : I
/*      */     //   16307: bipush #61
/*      */     //   16309: if_icmpge -> 16317
/*      */     //   16312: goto_w -> 16329
/*      */     //   16317: aload_0
/*      */     //   16318: getfield zoomi : Z
/*      */     //   16321: ifne -> 16329
/*      */     //   16324: goto_w -> 16396
/*      */     //   16329: iconst_1
/*      */     //   16330: istore #4
/*      */     //   16332: aload_0
/*      */     //   16333: getfield mouses : I
/*      */     //   16336: iconst_1
/*      */     //   16337: if_icmpne -> 16345
/*      */     //   16340: goto_w -> 16357
/*      */     //   16345: aload_0
/*      */     //   16346: getfield zoomi : Z
/*      */     //   16349: ifne -> 16357
/*      */     //   16352: goto_w -> 16396
/*      */     //   16357: aload_0
/*      */     //   16358: dup
/*      */     //   16359: getfield sy : I
/*      */     //   16362: sipush #500
/*      */     //   16365: iadd
/*      */     //   16366: putfield sy : I
/*      */     //   16369: aload_0
/*      */     //   16370: getfield sy : I
/*      */     //   16373: sipush #-2500
/*      */     //   16376: if_icmpgt -> 16384
/*      */     //   16379: goto_w -> 16396
/*      */     //   16384: aload_0
/*      */     //   16385: sipush #-2500
/*      */     //   16388: putfield sy : I
/*      */     //   16391: goto_w -> 16396
/*      */     //   16396: aload_0
/*      */     //   16397: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   16400: aload_0
/*      */     //   16401: getfield zi : [Ljava/awt/Image;
/*      */     //   16404: iload #4
/*      */     //   16406: aaload
/*      */     //   16407: sipush #616
/*      */     //   16410: bipush #30
/*      */     //   16412: aconst_null
/*      */     //   16413: invokevirtual drawImage : (Ljava/awt/Image;IILjava/awt/image/ImageObserver;)Z
/*      */     //   16416: pop
/*      */     //   16417: iconst_0
/*      */     //   16418: istore #4
/*      */     //   16420: aload_0
/*      */     //   16421: getfield xm : I
/*      */     //   16424: sipush #690
/*      */     //   16427: if_icmpgt -> 16435
/*      */     //   16430: goto_w -> 16478
/*      */     //   16435: aload_0
/*      */     //   16436: getfield xm : I
/*      */     //   16439: sipush #751
/*      */     //   16442: if_icmplt -> 16450
/*      */     //   16445: goto_w -> 16478
/*      */     //   16450: aload_0
/*      */     //   16451: getfield ym : I
/*      */     //   16454: bipush #30
/*      */     //   16456: if_icmpgt -> 16464
/*      */     //   16459: goto_w -> 16478
/*      */     //   16464: aload_0
/*      */     //   16465: getfield ym : I
/*      */     //   16468: bipush #61
/*      */     //   16470: if_icmpge -> 16478
/*      */     //   16473: goto_w -> 16490
/*      */     //   16478: aload_0
/*      */     //   16479: getfield zoomo : Z
/*      */     //   16482: ifne -> 16490
/*      */     //   16485: goto_w -> 16557
/*      */     //   16490: iconst_1
/*      */     //   16491: istore #4
/*      */     //   16493: aload_0
/*      */     //   16494: getfield mouses : I
/*      */     //   16497: iconst_1
/*      */     //   16498: if_icmpne -> 16506
/*      */     //   16501: goto_w -> 16518
/*      */     //   16506: aload_0
/*      */     //   16507: getfield zoomo : Z
/*      */     //   16510: ifne -> 16518
/*      */     //   16513: goto_w -> 16557
/*      */     //   16518: aload_0
/*      */     //   16519: dup
/*      */     //   16520: getfield sy : I
/*      */     //   16523: sipush #500
/*      */     //   16526: isub
/*      */     //   16527: putfield sy : I
/*      */     //   16530: aload_0
/*      */     //   16531: getfield sy : I
/*      */     //   16534: ldc_w -55000
/*      */     //   16537: if_icmplt -> 16545
/*      */     //   16540: goto_w -> 16557
/*      */     //   16545: aload_0
/*      */     //   16546: ldc_w -55000
/*      */     //   16549: putfield sy : I
/*      */     //   16552: goto_w -> 16557
/*      */     //   16557: aload_0
/*      */     //   16558: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   16561: aload_0
/*      */     //   16562: getfield zo : [Ljava/awt/Image;
/*      */     //   16565: iload #4
/*      */     //   16567: aaload
/*      */     //   16568: sipush #690
/*      */     //   16571: bipush #30
/*      */     //   16573: aconst_null
/*      */     //   16574: invokevirtual drawImage : (Ljava/awt/Image;IILjava/awt/image/ImageObserver;)Z
/*      */     //   16577: pop
/*      */     //   16578: aload_0
/*      */     //   16579: getfield epart : Z
/*      */     //   16582: ifeq -> 16590
/*      */     //   16585: goto_w -> 16602
/*      */     //   16590: aload_0
/*      */     //   16591: getfield arrng : Z
/*      */     //   16594: ifne -> 16602
/*      */     //   16597: goto_w -> 16629
/*      */     //   16602: aload_0
/*      */     //   16603: getfield sy : I
/*      */     //   16606: ldc_w -36000
/*      */     //   16609: if_icmplt -> 16617
/*      */     //   16612: goto_w -> 16629
/*      */     //   16617: aload_0
/*      */     //   16618: ldc_w -36000
/*      */     //   16621: putfield sy : I
/*      */     //   16624: goto_w -> 16629
/*      */     //   16629: aload_0
/*      */     //   16630: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   16633: new java/awt/Font
/*      */     //   16636: dup
/*      */     //   16637: ldc_w 'Arial'
/*      */     //   16640: iconst_1
/*      */     //   16641: bipush #11
/*      */     //   16643: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   16646: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   16649: aload_0
/*      */     //   16650: aload_0
/*      */     //   16651: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   16654: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   16657: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   16660: aload_0
/*      */     //   16661: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   16664: new java/awt/Color
/*      */     //   16667: dup
/*      */     //   16668: iconst_0
/*      */     //   16669: iconst_0
/*      */     //   16670: iconst_0
/*      */     //   16671: invokespecial <init> : (III)V
/*      */     //   16674: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   16677: aload_0
/*      */     //   16678: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   16681: ldc_w 'Part Selection'
/*      */     //   16684: bipush #11
/*      */     //   16686: bipush #47
/*      */     //   16688: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   16691: aload_0
/*      */     //   16692: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   16695: new java/awt/Font
/*      */     //   16698: dup
/*      */     //   16699: ldc_w 'Arial'
/*      */     //   16702: iconst_1
/*      */     //   16703: bipush #13
/*      */     //   16705: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   16708: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   16711: aload_0
/*      */     //   16712: aload_0
/*      */     //   16713: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   16716: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   16719: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   16722: aload_0
/*      */     //   16723: getfield ptyp : LSmenu;
/*      */     //   16726: bipush #10
/*      */     //   16728: bipush #50
/*      */     //   16730: invokevirtual move : (II)V
/*      */     //   16733: aload_0
/*      */     //   16734: getfield ptyp : LSmenu;
/*      */     //   16737: invokevirtual isShowing : ()Z
/*      */     //   16740: ifeq -> 16748
/*      */     //   16743: goto_w -> 16771
/*      */     //   16748: aload_0
/*      */     //   16749: getfield ptyp : LSmenu;
/*      */     //   16752: invokevirtual show : ()V
/*      */     //   16755: aload_0
/*      */     //   16756: getfield ptyp : LSmenu;
/*      */     //   16759: aload_0
/*      */     //   16760: getfield sptyp : I
/*      */     //   16763: invokevirtual select : (I)V
/*      */     //   16766: goto_w -> 16771
/*      */     //   16771: aload_0
/*      */     //   16772: getfield sptyp : I
/*      */     //   16775: aload_0
/*      */     //   16776: getfield ptyp : LSmenu;
/*      */     //   16779: invokevirtual getSelectedIndex : ()I
/*      */     //   16782: if_icmpne -> 16790
/*      */     //   16785: goto_w -> 16955
/*      */     //   16790: aload_0
/*      */     //   16791: aload_0
/*      */     //   16792: getfield ptyp : LSmenu;
/*      */     //   16795: invokevirtual getSelectedIndex : ()I
/*      */     //   16798: putfield sptyp : I
/*      */     //   16801: aload_0
/*      */     //   16802: getfield sptyp : I
/*      */     //   16805: ifeq -> 16813
/*      */     //   16808: goto_w -> 16829
/*      */     //   16813: aload_0
/*      */     //   16814: invokevirtual partroads : ()V
/*      */     //   16817: aload_0
/*      */     //   16818: getfield part : LSmenu;
/*      */     //   16821: invokevirtual show : ()V
/*      */     //   16824: goto_w -> 16829
/*      */     //   16829: aload_0
/*      */     //   16830: getfield sptyp : I
/*      */     //   16833: iconst_1
/*      */     //   16834: if_icmpeq -> 16842
/*      */     //   16837: goto_w -> 16858
/*      */     //   16842: aload_0
/*      */     //   16843: invokevirtual partramps : ()V
/*      */     //   16846: aload_0
/*      */     //   16847: getfield part : LSmenu;
/*      */     //   16850: invokevirtual show : ()V
/*      */     //   16853: goto_w -> 16858
/*      */     //   16858: aload_0
/*      */     //   16859: getfield sptyp : I
/*      */     //   16862: iconst_2
/*      */     //   16863: if_icmpeq -> 16871
/*      */     //   16866: goto_w -> 16887
/*      */     //   16871: aload_0
/*      */     //   16872: invokevirtual partobst : ()V
/*      */     //   16875: aload_0
/*      */     //   16876: getfield part : LSmenu;
/*      */     //   16879: invokevirtual show : ()V
/*      */     //   16882: goto_w -> 16887
/*      */     //   16887: aload_0
/*      */     //   16888: getfield sptyp : I
/*      */     //   16891: iconst_5
/*      */     //   16892: if_icmpeq -> 16900
/*      */     //   16895: goto_w -> 16916
/*      */     //   16900: aload_0
/*      */     //   16901: invokevirtual partrees : ()V
/*      */     //   16904: aload_0
/*      */     //   16905: getfield part : LSmenu;
/*      */     //   16908: invokevirtual show : ()V
/*      */     //   16911: goto_w -> 16916
/*      */     //   16916: aload_0
/*      */     //   16917: iconst_0
/*      */     //   16918: putfield spart : I
/*      */     //   16921: aload_0
/*      */     //   16922: getfield part : LSmenu;
/*      */     //   16925: aload_0
/*      */     //   16926: getfield spart : I
/*      */     //   16929: invokevirtual select : (I)V
/*      */     //   16932: aload_0
/*      */     //   16933: invokevirtual requestFocus : ()V
/*      */     //   16936: aload_0
/*      */     //   16937: getfield fixh : Ljava/awt/TextField;
/*      */     //   16940: ldc '2000'
/*      */     //   16942: invokevirtual setText : (Ljava/lang/String;)V
/*      */     //   16945: aload_0
/*      */     //   16946: iconst_0
/*      */     //   16947: putfield focuson : Z
/*      */     //   16950: goto_w -> 16955
/*      */     //   16955: aload_0
/*      */     //   16956: getfield part : LSmenu;
/*      */     //   16959: bipush #10
/*      */     //   16961: bipush #80
/*      */     //   16963: invokevirtual move : (II)V
/*      */     //   16966: aload_0
/*      */     //   16967: getfield part : LSmenu;
/*      */     //   16970: sipush #200
/*      */     //   16973: bipush #21
/*      */     //   16975: invokevirtual setSize : (II)V
/*      */     //   16978: aload_0
/*      */     //   16979: getfield sptyp : I
/*      */     //   16982: ifne -> 16990
/*      */     //   16985: goto_w -> 17029
/*      */     //   16990: aload_0
/*      */     //   16991: getfield sptyp : I
/*      */     //   16994: iconst_1
/*      */     //   16995: if_icmpne -> 17003
/*      */     //   16998: goto_w -> 17029
/*      */     //   17003: aload_0
/*      */     //   17004: getfield sptyp : I
/*      */     //   17007: iconst_2
/*      */     //   17008: if_icmpne -> 17016
/*      */     //   17011: goto_w -> 17029
/*      */     //   17016: aload_0
/*      */     //   17017: getfield sptyp : I
/*      */     //   17020: iconst_5
/*      */     //   17021: if_icmpeq -> 17029
/*      */     //   17024: goto_w -> 17067
/*      */     //   17029: aload_0
/*      */     //   17030: getfield part : LSmenu;
/*      */     //   17033: invokevirtual isShowing : ()Z
/*      */     //   17036: ifeq -> 17044
/*      */     //   17039: goto_w -> 17094
/*      */     //   17044: aload_0
/*      */     //   17045: getfield part : LSmenu;
/*      */     //   17048: invokevirtual show : ()V
/*      */     //   17051: aload_0
/*      */     //   17052: getfield part : LSmenu;
/*      */     //   17055: aload_0
/*      */     //   17056: getfield spart : I
/*      */     //   17059: invokevirtual select : (I)V
/*      */     //   17062: goto_w -> 17094
/*      */     //   17067: aload_0
/*      */     //   17068: getfield part : LSmenu;
/*      */     //   17071: invokevirtual isShowing : ()Z
/*      */     //   17074: ifne -> 17082
/*      */     //   17077: goto_w -> 17094
/*      */     //   17082: aload_0
/*      */     //   17083: getfield part : LSmenu;
/*      */     //   17086: invokevirtual hide : ()V
/*      */     //   17089: goto_w -> 17094
/*      */     //   17094: aload_0
/*      */     //   17095: getfield spart : I
/*      */     //   17098: aload_0
/*      */     //   17099: getfield part : LSmenu;
/*      */     //   17102: invokevirtual getSelectedIndex : ()I
/*      */     //   17105: if_icmpne -> 17113
/*      */     //   17108: goto_w -> 17134
/*      */     //   17113: aload_0
/*      */     //   17114: aload_0
/*      */     //   17115: getfield part : LSmenu;
/*      */     //   17118: invokevirtual getSelectedIndex : ()I
/*      */     //   17121: putfield spart : I
/*      */     //   17124: aload_0
/*      */     //   17125: iconst_0
/*      */     //   17126: putfield focuson : Z
/*      */     //   17129: goto_w -> 17134
/*      */     //   17134: aload_0
/*      */     //   17135: getfield sptyp : I
/*      */     //   17138: iconst_3
/*      */     //   17139: if_icmpeq -> 17147
/*      */     //   17142: goto_w -> 17179
/*      */     //   17147: aload_0
/*      */     //   17148: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   17151: ldc_w 'Checkpoint'
/*      */     //   17154: bipush #110
/*      */     //   17156: aload_0
/*      */     //   17157: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   17160: ldc_w 'Checkpoint'
/*      */     //   17163: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   17166: iconst_2
/*      */     //   17167: idiv
/*      */     //   17168: isub
/*      */     //   17169: bipush #120
/*      */     //   17171: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   17174: goto_w -> 17179
/*      */     //   17179: aload_0
/*      */     //   17180: getfield sptyp : I
/*      */     //   17183: iconst_4
/*      */     //   17184: if_icmpeq -> 17192
/*      */     //   17187: goto_w -> 17224
/*      */     //   17192: aload_0
/*      */     //   17193: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   17196: ldc_w 'Fixing Hoop'
/*      */     //   17199: bipush #110
/*      */     //   17201: aload_0
/*      */     //   17202: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   17205: ldc_w 'Fixing Hoop'
/*      */     //   17208: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   17211: iconst_2
/*      */     //   17212: idiv
/*      */     //   17213: isub
/*      */     //   17214: bipush #120
/*      */     //   17216: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   17219: goto_w -> 17224
/*      */     //   17224: aload_0
/*      */     //   17225: getfield lsp : I
/*      */     //   17228: aload_0
/*      */     //   17229: getfield sp : I
/*      */     //   17232: if_icmpne -> 17240
/*      */     //   17235: goto_w -> 17294
/*      */     //   17240: aload_0
/*      */     //   17241: iconst_3
/*      */     //   17242: putfield seq : I
/*      */     //   17245: aload_0
/*      */     //   17246: getfield bco : [LContO;
/*      */     //   17249: aload_0
/*      */     //   17250: getfield sp : I
/*      */     //   17253: aaload
/*      */     //   17254: iconst_0
/*      */     //   17255: putfield xy : I
/*      */     //   17258: aload_0
/*      */     //   17259: getfield bco : [LContO;
/*      */     //   17262: aload_0
/*      */     //   17263: getfield sp : I
/*      */     //   17266: aaload
/*      */     //   17267: iconst_0
/*      */     //   17268: putfield zy : I
/*      */     //   17271: aload_0
/*      */     //   17272: aload_0
/*      */     //   17273: getfield sp : I
/*      */     //   17276: putfield lsp : I
/*      */     //   17279: aload_0
/*      */     //   17280: iconst_0
/*      */     //   17281: putfield epart : Z
/*      */     //   17284: aload_0
/*      */     //   17285: iconst_0
/*      */     //   17286: putfield arrng : Z
/*      */     //   17289: goto_w -> 17294
/*      */     //   17294: aload_0
/*      */     //   17295: getfield xm : I
/*      */     //   17298: bipush #10
/*      */     //   17300: if_icmpgt -> 17308
/*      */     //   17303: goto_w -> 17476
/*      */     //   17308: aload_0
/*      */     //   17309: getfield xm : I
/*      */     //   17312: sipush #210
/*      */     //   17315: if_icmplt -> 17323
/*      */     //   17318: goto_w -> 17476
/*      */     //   17323: aload_0
/*      */     //   17324: getfield ym : I
/*      */     //   17327: sipush #130
/*      */     //   17330: if_icmpgt -> 17338
/*      */     //   17333: goto_w -> 17476
/*      */     //   17338: aload_0
/*      */     //   17339: getfield ym : I
/*      */     //   17342: sipush #334
/*      */     //   17345: if_icmplt -> 17353
/*      */     //   17348: goto_w -> 17476
/*      */     //   17353: aload_0
/*      */     //   17354: getfield seq : I
/*      */     //   17357: iconst_3
/*      */     //   17358: if_icmpge -> 17366
/*      */     //   17361: goto_w -> 17443
/*      */     //   17366: aload_0
/*      */     //   17367: getfield seq : I
/*      */     //   17370: bipush #20
/*      */     //   17372: if_icmpne -> 17380
/*      */     //   17375: goto_w -> 17392
/*      */     //   17380: aload_0
/*      */     //   17381: getfield seqn : Z
/*      */     //   17384: ifeq -> 17392
/*      */     //   17387: goto_w -> 17428
/*      */     //   17392: aload_0
/*      */     //   17393: iconst_0
/*      */     //   17394: putfield seq : I
/*      */     //   17397: aload_0
/*      */     //   17398: getfield bco : [LContO;
/*      */     //   17401: aload_0
/*      */     //   17402: getfield sp : I
/*      */     //   17405: aaload
/*      */     //   17406: iconst_0
/*      */     //   17407: putfield xy : I
/*      */     //   17410: aload_0
/*      */     //   17411: getfield bco : [LContO;
/*      */     //   17414: aload_0
/*      */     //   17415: getfield sp : I
/*      */     //   17418: aaload
/*      */     //   17419: iconst_0
/*      */     //   17420: putfield zy : I
/*      */     //   17423: goto_w -> 17443
/*      */     //   17428: aload_0
/*      */     //   17429: dup
/*      */     //   17430: getfield seq : I
/*      */     //   17433: iconst_1
/*      */     //   17434: iadd
/*      */     //   17435: putfield seq : I
/*      */     //   17438: goto_w -> 17443
/*      */     //   17443: aload_0
/*      */     //   17444: iconst_1
/*      */     //   17445: putfield seqn : Z
/*      */     //   17448: aload_0
/*      */     //   17449: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   17452: new java/awt/Color
/*      */     //   17455: dup
/*      */     //   17456: sipush #210
/*      */     //   17459: sipush #210
/*      */     //   17462: sipush #210
/*      */     //   17465: invokespecial <init> : (III)V
/*      */     //   17468: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   17471: goto_w -> 17504
/*      */     //   17476: aload_0
/*      */     //   17477: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   17480: new java/awt/Color
/*      */     //   17483: dup
/*      */     //   17484: sipush #200
/*      */     //   17487: sipush #200
/*      */     //   17490: sipush #200
/*      */     //   17493: invokespecial <init> : (III)V
/*      */     //   17496: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   17499: aload_0
/*      */     //   17500: iconst_0
/*      */     //   17501: putfield seqn : Z
/*      */     //   17504: aload_0
/*      */     //   17505: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   17508: bipush #10
/*      */     //   17510: sipush #130
/*      */     //   17513: sipush #200
/*      */     //   17516: sipush #200
/*      */     //   17519: invokevirtual fillRect : (IIII)V
/*      */     //   17522: aload_0
/*      */     //   17523: getfield sp : I
/*      */     //   17526: bipush #30
/*      */     //   17528: if_icmpne -> 17536
/*      */     //   17531: goto_w -> 17564
/*      */     //   17536: aload_0
/*      */     //   17537: getfield sp : I
/*      */     //   17540: bipush #32
/*      */     //   17542: if_icmpne -> 17550
/*      */     //   17545: goto_w -> 17564
/*      */     //   17550: aload_0
/*      */     //   17551: getfield sp : I
/*      */     //   17554: bipush #54
/*      */     //   17556: if_icmpeq -> 17564
/*      */     //   17559: goto_w -> 17734
/*      */     //   17564: aload_0
/*      */     //   17565: ldc_w '  Rearrange Checkpoints  >  '
/*      */     //   17568: bipush #110
/*      */     //   17570: sipush #315
/*      */     //   17573: iconst_2
/*      */     //   17574: iconst_1
/*      */     //   17575: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   17578: ifne -> 17586
/*      */     //   17581: goto_w -> 17734
/*      */     //   17586: aload_0
/*      */     //   17587: iconst_0
/*      */     //   17588: putfield mouses : I
/*      */     //   17591: aload_0
/*      */     //   17592: iconst_0
/*      */     //   17593: putfield epart : Z
/*      */     //   17596: aload_0
/*      */     //   17597: getfield arrng : Z
/*      */     //   17600: ifeq -> 17608
/*      */     //   17603: goto_w -> 17724
/*      */     //   17608: aload_0
/*      */     //   17609: iconst_0
/*      */     //   17610: putfield arrcnt : I
/*      */     //   17613: iconst_0
/*      */     //   17614: istore #5
/*      */     //   17616: iload #5
/*      */     //   17618: aload_0
/*      */     //   17619: getfield nob : I
/*      */     //   17622: if_icmplt -> 17630
/*      */     //   17625: goto_w -> 17714
/*      */     //   17630: aload_0
/*      */     //   17631: getfield co : [LContO;
/*      */     //   17634: iload #5
/*      */     //   17636: aaload
/*      */     //   17637: getfield colok : I
/*      */     //   17640: bipush #30
/*      */     //   17642: if_icmpne -> 17650
/*      */     //   17645: goto_w -> 17690
/*      */     //   17650: aload_0
/*      */     //   17651: getfield co : [LContO;
/*      */     //   17654: iload #5
/*      */     //   17656: aaload
/*      */     //   17657: getfield colok : I
/*      */     //   17660: bipush #32
/*      */     //   17662: if_icmpne -> 17670
/*      */     //   17665: goto_w -> 17690
/*      */     //   17670: aload_0
/*      */     //   17671: getfield co : [LContO;
/*      */     //   17674: iload #5
/*      */     //   17676: aaload
/*      */     //   17677: getfield colok : I
/*      */     //   17680: bipush #54
/*      */     //   17682: if_icmpeq -> 17690
/*      */     //   17685: goto_w -> 17706
/*      */     //   17690: aload_0
/*      */     //   17691: getfield co : [LContO;
/*      */     //   17694: iload #5
/*      */     //   17696: aaload
/*      */     //   17697: iconst_0
/*      */     //   17698: putfield errd : Z
/*      */     //   17701: goto_w -> 17706
/*      */     //   17706: iinc #5, 1
/*      */     //   17709: goto_w -> 17616
/*      */     //   17714: aload_0
/*      */     //   17715: iconst_1
/*      */     //   17716: putfield arrng : Z
/*      */     //   17719: goto_w -> 17734
/*      */     //   17724: aload_0
/*      */     //   17725: iconst_0
/*      */     //   17726: putfield arrng : Z
/*      */     //   17729: goto_w -> 17734
/*      */     //   17734: aload_0
/*      */     //   17735: getfield seqn : Z
/*      */     //   17738: ifne -> 17746
/*      */     //   17741: goto_w -> 18113
/*      */     //   17746: aload_0
/*      */     //   17747: getfield mouses : I
/*      */     //   17750: iconst_m1
/*      */     //   17751: if_icmpeq -> 17759
/*      */     //   17754: goto_w -> 18113
/*      */     //   17759: aload_0
/*      */     //   17760: getfield sp : I
/*      */     //   17763: bipush #66
/*      */     //   17765: if_icmpne -> 17773
/*      */     //   17768: goto_w -> 18065
/*      */     //   17773: iconst_0
/*      */     //   17774: istore #5
/*      */     //   17776: aload_0
/*      */     //   17777: getfield rot : I
/*      */     //   17780: ifeq -> 17788
/*      */     //   17783: goto_w -> 17812
/*      */     //   17788: iload #5
/*      */     //   17790: ifeq -> 17798
/*      */     //   17793: goto_w -> 17812
/*      */     //   17798: aload_0
/*      */     //   17799: bipush #90
/*      */     //   17801: putfield rot : I
/*      */     //   17804: iconst_1
/*      */     //   17805: istore #5
/*      */     //   17807: goto_w -> 17812
/*      */     //   17812: aload_0
/*      */     //   17813: getfield rot : I
/*      */     //   17816: bipush #90
/*      */     //   17818: if_icmpeq -> 17826
/*      */     //   17821: goto_w -> 17851
/*      */     //   17826: iload #5
/*      */     //   17828: ifeq -> 17836
/*      */     //   17831: goto_w -> 17851
/*      */     //   17836: aload_0
/*      */     //   17837: sipush #180
/*      */     //   17840: putfield rot : I
/*      */     //   17843: iconst_1
/*      */     //   17844: istore #5
/*      */     //   17846: goto_w -> 17851
/*      */     //   17851: aload_0
/*      */     //   17852: getfield rot : I
/*      */     //   17855: sipush #180
/*      */     //   17858: if_icmpeq -> 17866
/*      */     //   17861: goto_w -> 17890
/*      */     //   17866: iload #5
/*      */     //   17868: ifeq -> 17876
/*      */     //   17871: goto_w -> 17890
/*      */     //   17876: aload_0
/*      */     //   17877: bipush #-90
/*      */     //   17879: putfield rot : I
/*      */     //   17882: iconst_1
/*      */     //   17883: istore #5
/*      */     //   17885: goto_w -> 17890
/*      */     //   17890: aload_0
/*      */     //   17891: getfield rot : I
/*      */     //   17894: bipush #-90
/*      */     //   17896: if_icmpeq -> 17904
/*      */     //   17899: goto_w -> 17927
/*      */     //   17904: iload #5
/*      */     //   17906: ifeq -> 17914
/*      */     //   17909: goto_w -> 17927
/*      */     //   17914: aload_0
/*      */     //   17915: iconst_0
/*      */     //   17916: putfield rot : I
/*      */     //   17919: iconst_1
/*      */     //   17920: istore #5
/*      */     //   17922: goto_w -> 17927
/*      */     //   17927: aload_0
/*      */     //   17928: getfield sp : I
/*      */     //   17931: bipush #30
/*      */     //   17933: if_icmpne -> 17941
/*      */     //   17936: goto_w -> 17969
/*      */     //   17941: aload_0
/*      */     //   17942: getfield sp : I
/*      */     //   17945: bipush #31
/*      */     //   17947: if_icmpne -> 17955
/*      */     //   17950: goto_w -> 17969
/*      */     //   17955: aload_0
/*      */     //   17956: getfield sp : I
/*      */     //   17959: bipush #32
/*      */     //   17961: if_icmpeq -> 17969
/*      */     //   17964: goto_w -> 18019
/*      */     //   17969: aload_0
/*      */     //   17970: getfield rot : I
/*      */     //   17973: bipush #-90
/*      */     //   17975: if_icmpeq -> 17983
/*      */     //   17978: goto_w -> 17994
/*      */     //   17983: aload_0
/*      */     //   17984: bipush #90
/*      */     //   17986: putfield rot : I
/*      */     //   17989: goto_w -> 17994
/*      */     //   17994: aload_0
/*      */     //   17995: getfield rot : I
/*      */     //   17998: sipush #180
/*      */     //   18001: if_icmpeq -> 18009
/*      */     //   18004: goto_w -> 18019
/*      */     //   18009: aload_0
/*      */     //   18010: iconst_0
/*      */     //   18011: putfield rot : I
/*      */     //   18014: goto_w -> 18019
/*      */     //   18019: aload_0
/*      */     //   18020: iconst_5
/*      */     //   18021: putfield seq : I
/*      */     //   18024: aload_0
/*      */     //   18025: getfield bco : [LContO;
/*      */     //   18028: aload_0
/*      */     //   18029: getfield sp : I
/*      */     //   18032: aaload
/*      */     //   18033: iconst_0
/*      */     //   18034: putfield xy : I
/*      */     //   18037: aload_0
/*      */     //   18038: getfield bco : [LContO;
/*      */     //   18041: aload_0
/*      */     //   18042: getfield sp : I
/*      */     //   18045: aaload
/*      */     //   18046: iconst_0
/*      */     //   18047: putfield zy : I
/*      */     //   18050: aload_0
/*      */     //   18051: iconst_0
/*      */     //   18052: putfield epart : Z
/*      */     //   18055: aload_0
/*      */     //   18056: iconst_0
/*      */     //   18057: putfield arrng : Z
/*      */     //   18060: goto_w -> 18113
/*      */     //   18065: aload_0
/*      */     //   18066: iconst_0
/*      */     //   18067: putfield pgen : Z
/*      */     //   18070: aload_0
/*      */     //   18071: ldc2_w 2
/*      */     //   18074: invokestatic random : ()D
/*      */     //   18077: ldc2_w 4.0
/*      */     //   18080: dmul
/*      */     //   18081: invokestatic round : (D)J
/*      */     //   18084: ladd
/*      */     //   18085: l2f
/*      */     //   18086: putfield pwd : F
/*      */     //   18089: aload_0
/*      */     //   18090: ldc2_w 2
/*      */     //   18093: invokestatic random : ()D
/*      */     //   18096: ldc2_w 4.0
/*      */     //   18099: dmul
/*      */     //   18100: invokestatic round : (D)J
/*      */     //   18103: ladd
/*      */     //   18104: l2f
/*      */     //   18105: putfield phd : F
/*      */     //   18108: goto_w -> 18113
/*      */     //   18113: aload_0
/*      */     //   18114: getfield sp : I
/*      */     //   18117: bipush #31
/*      */     //   18119: if_icmpeq -> 18127
/*      */     //   18122: goto_w -> 18433
/*      */     //   18127: aload_0
/*      */     //   18128: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   18131: new java/awt/Font
/*      */     //   18134: dup
/*      */     //   18135: ldc_w 'Arial'
/*      */     //   18138: iconst_1
/*      */     //   18139: bipush #12
/*      */     //   18141: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   18144: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   18147: aload_0
/*      */     //   18148: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   18151: new java/awt/Color
/*      */     //   18154: dup
/*      */     //   18155: iconst_0
/*      */     //   18156: iconst_0
/*      */     //   18157: iconst_0
/*      */     //   18158: invokespecial <init> : (III)V
/*      */     //   18161: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   18164: aload_0
/*      */     //   18165: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   18168: ldc_w 'Height:'
/*      */     //   18171: bipush #62
/*      */     //   18173: sipush #280
/*      */     //   18176: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   18179: aload_0
/*      */     //   18180: aload_0
/*      */     //   18181: getfield fixh : Ljava/awt/TextField;
/*      */     //   18184: bipush #107
/*      */     //   18186: sipush #266
/*      */     //   18189: bipush #50
/*      */     //   18191: bipush #20
/*      */     //   18193: invokevirtual movefield : (Ljava/awt/Component;IIII)V
/*      */     //   18196: aload_0
/*      */     //   18197: getfield fixh : Ljava/awt/TextField;
/*      */     //   18200: invokevirtual hasFocus : ()Z
/*      */     //   18203: ifne -> 18211
/*      */     //   18206: goto_w -> 18221
/*      */     //   18211: aload_0
/*      */     //   18212: iconst_0
/*      */     //   18213: putfield focuson : Z
/*      */     //   18216: goto_w -> 18221
/*      */     //   18221: aload_0
/*      */     //   18222: getfield fixh : Ljava/awt/TextField;
/*      */     //   18225: invokevirtual isShowing : ()Z
/*      */     //   18228: ifeq -> 18236
/*      */     //   18231: goto_w -> 18248
/*      */     //   18236: aload_0
/*      */     //   18237: getfield fixh : Ljava/awt/TextField;
/*      */     //   18240: invokevirtual show : ()V
/*      */     //   18243: goto_w -> 18248
/*      */     //   18248: aload_0
/*      */     //   18249: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   18252: new java/awt/Font
/*      */     //   18255: dup
/*      */     //   18256: ldc_w 'Arial'
/*      */     //   18259: iconst_0
/*      */     //   18260: bipush #11
/*      */     //   18262: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   18265: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   18268: aload_0
/*      */     //   18269: aload_0
/*      */     //   18270: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   18273: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   18276: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   18279: aload_0
/*      */     //   18280: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   18283: ldc_w '( Height off the ground... )'
/*      */     //   18286: bipush #110
/*      */     //   18288: aload_0
/*      */     //   18289: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   18292: ldc_w '( Height off the ground... )'
/*      */     //   18295: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   18298: iconst_2
/*      */     //   18299: idiv
/*      */     //   18300: isub
/*      */     //   18301: sipush #300
/*      */     //   18304: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   18307: aload_0
/*      */     //   18308: getfield fixh : Ljava/awt/TextField;
/*      */     //   18311: invokevirtual getText : ()Ljava/lang/String;
/*      */     //   18314: ldc ''
/*      */     //   18316: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   18319: ifne -> 18327
/*      */     //   18322: goto_w -> 18351
/*      */     //   18327: aload_0
/*      */     //   18328: getfield fixh : Ljava/awt/TextField;
/*      */     //   18331: ldc_w '0'
/*      */     //   18334: invokevirtual setText : (Ljava/lang/String;)V
/*      */     //   18337: aload_0
/*      */     //   18338: getfield fixh : Ljava/awt/TextField;
/*      */     //   18341: iconst_0
/*      */     //   18342: iconst_0
/*      */     //   18343: invokevirtual select : (II)V
/*      */     //   18346: goto_w -> 18351
/*      */     //   18351: aload_0
/*      */     //   18352: aload_0
/*      */     //   18353: getfield fixh : Ljava/awt/TextField;
/*      */     //   18356: invokevirtual getText : ()Ljava/lang/String;
/*      */     //   18359: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
/*      */     //   18362: invokevirtual intValue : ()I
/*      */     //   18365: putfield hf : I
/*      */     //   18368: aload_0
/*      */     //   18369: getfield hf : I
/*      */     //   18372: sipush #8000
/*      */     //   18375: if_icmpgt -> 18383
/*      */     //   18378: goto_w -> 18405
/*      */     //   18383: aload_0
/*      */     //   18384: sipush #8000
/*      */     //   18387: putfield hf : I
/*      */     //   18390: aload_0
/*      */     //   18391: getfield fixh : Ljava/awt/TextField;
/*      */     //   18394: ldc_w '8000'
/*      */     //   18397: invokevirtual setText : (Ljava/lang/String;)V
/*      */     //   18400: goto_w -> 18405
/*      */     //   18405: goto_w -> 18460
/*      */     //   18410: astore #5
/*      */     //   18412: aload_0
/*      */     //   18413: sipush #2000
/*      */     //   18416: putfield hf : I
/*      */     //   18419: aload_0
/*      */     //   18420: getfield fixh : Ljava/awt/TextField;
/*      */     //   18423: ldc '2000'
/*      */     //   18425: invokevirtual setText : (Ljava/lang/String;)V
/*      */     //   18428: goto_w -> 18460
/*      */     //   18433: aload_0
/*      */     //   18434: getfield fixh : Ljava/awt/TextField;
/*      */     //   18437: invokevirtual isShowing : ()Z
/*      */     //   18440: ifne -> 18448
/*      */     //   18443: goto_w -> 18460
/*      */     //   18448: aload_0
/*      */     //   18449: getfield fixh : Ljava/awt/TextField;
/*      */     //   18452: invokevirtual hide : ()V
/*      */     //   18455: goto_w -> 18460
/*      */     //   18460: aload_0
/*      */     //   18461: getfield m : LMedium;
/*      */     //   18464: iconst_2
/*      */     //   18465: putfield trk : I
/*      */     //   18468: aload_0
/*      */     //   18469: getfield m : LMedium;
/*      */     //   18472: bipush #90
/*      */     //   18474: putfield zy : I
/*      */     //   18477: aload_0
/*      */     //   18478: getfield m : LMedium;
/*      */     //   18481: iconst_0
/*      */     //   18482: putfield xz : I
/*      */     //   18485: aload_0
/*      */     //   18486: getfield m : LMedium;
/*      */     //   18489: bipush #10
/*      */     //   18491: putfield iw : I
/*      */     //   18494: aload_0
/*      */     //   18495: getfield m : LMedium;
/*      */     //   18498: sipush #210
/*      */     //   18501: putfield w : I
/*      */     //   18504: aload_0
/*      */     //   18505: getfield m : LMedium;
/*      */     //   18508: sipush #130
/*      */     //   18511: putfield ih : I
/*      */     //   18514: aload_0
/*      */     //   18515: getfield m : LMedium;
/*      */     //   18518: sipush #330
/*      */     //   18521: putfield h : I
/*      */     //   18524: aload_0
/*      */     //   18525: getfield m : LMedium;
/*      */     //   18528: bipush #110
/*      */     //   18530: putfield cx : I
/*      */     //   18533: aload_0
/*      */     //   18534: getfield m : LMedium;
/*      */     //   18537: sipush #230
/*      */     //   18540: putfield cy : I
/*      */     //   18543: aload_0
/*      */     //   18544: getfield m : LMedium;
/*      */     //   18547: bipush #-110
/*      */     //   18549: putfield x : I
/*      */     //   18552: aload_0
/*      */     //   18553: getfield m : LMedium;
/*      */     //   18556: sipush #-230
/*      */     //   18559: putfield z : I
/*      */     //   18562: aload_0
/*      */     //   18563: getfield m : LMedium;
/*      */     //   18566: sipush #-15000
/*      */     //   18569: putfield y : I
/*      */     //   18572: aload_0
/*      */     //   18573: getfield sptyp : I
/*      */     //   18576: iconst_1
/*      */     //   18577: if_icmpeq -> 18585
/*      */     //   18580: goto_w -> 18656
/*      */     //   18585: aload_0
/*      */     //   18586: getfield sp : I
/*      */     //   18589: bipush #20
/*      */     //   18591: if_icmpne -> 18599
/*      */     //   18594: goto_w -> 18656
/*      */     //   18599: aload_0
/*      */     //   18600: getfield sp : I
/*      */     //   18603: bipush #21
/*      */     //   18605: if_icmpne -> 18613
/*      */     //   18608: goto_w -> 18656
/*      */     //   18613: aload_0
/*      */     //   18614: getfield sp : I
/*      */     //   18617: bipush #43
/*      */     //   18619: if_icmpne -> 18627
/*      */     //   18622: goto_w -> 18656
/*      */     //   18627: aload_0
/*      */     //   18628: getfield sp : I
/*      */     //   18631: bipush #45
/*      */     //   18633: if_icmpne -> 18641
/*      */     //   18636: goto_w -> 18656
/*      */     //   18641: aload_0
/*      */     //   18642: getfield m : LMedium;
/*      */     //   18645: sipush #-10000
/*      */     //   18648: putfield y : I
/*      */     //   18651: goto_w -> 18656
/*      */     //   18656: aload_0
/*      */     //   18657: getfield sptyp : I
/*      */     //   18660: iconst_2
/*      */     //   18661: if_icmpeq -> 18669
/*      */     //   18664: goto_w -> 18698
/*      */     //   18669: aload_0
/*      */     //   18670: getfield sp : I
/*      */     //   18673: bipush #41
/*      */     //   18675: if_icmpne -> 18683
/*      */     //   18678: goto_w -> 18698
/*      */     //   18683: aload_0
/*      */     //   18684: getfield m : LMedium;
/*      */     //   18687: sipush #-7600
/*      */     //   18690: putfield y : I
/*      */     //   18693: goto_w -> 18698
/*      */     //   18698: aload_0
/*      */     //   18699: getfield sptyp : I
/*      */     //   18702: iconst_3
/*      */     //   18703: if_icmpne -> 18711
/*      */     //   18706: goto_w -> 18724
/*      */     //   18711: aload_0
/*      */     //   18712: getfield sptyp : I
/*      */     //   18715: iconst_4
/*      */     //   18716: if_icmpeq -> 18724
/*      */     //   18719: goto_w -> 18739
/*      */     //   18724: aload_0
/*      */     //   18725: getfield m : LMedium;
/*      */     //   18728: sipush #-5000
/*      */     //   18731: putfield y : I
/*      */     //   18734: goto_w -> 18739
/*      */     //   18739: aload_0
/*      */     //   18740: getfield sptyp : I
/*      */     //   18743: iconst_5
/*      */     //   18744: if_icmpeq -> 18752
/*      */     //   18747: goto_w -> 18777
/*      */     //   18752: aload_0
/*      */     //   18753: getfield m : LMedium;
/*      */     //   18756: sipush #-3000
/*      */     //   18759: putfield y : I
/*      */     //   18762: aload_0
/*      */     //   18763: getfield m : LMedium;
/*      */     //   18766: sipush #150
/*      */     //   18769: putfield z : I
/*      */     //   18772: goto_w -> 18777
/*      */     //   18777: aload_0
/*      */     //   18778: getfield sptyp : I
/*      */     //   18781: bipush #6
/*      */     //   18783: if_icmpeq -> 18791
/*      */     //   18786: goto_w -> 18806
/*      */     //   18791: aload_0
/*      */     //   18792: getfield m : LMedium;
/*      */     //   18795: sipush #-7600
/*      */     //   18798: putfield y : I
/*      */     //   18801: goto_w -> 18806
/*      */     //   18806: aload_0
/*      */     //   18807: getfield sp : I
/*      */     //   18810: bipush #31
/*      */     //   18812: if_icmpeq -> 18820
/*      */     //   18815: goto_w -> 18878
/*      */     //   18820: aload_0
/*      */     //   18821: getfield m : LMedium;
/*      */     //   18824: sipush #-500
/*      */     //   18827: putfield z : I
/*      */     //   18830: aload_0
/*      */     //   18831: getfield rot : I
/*      */     //   18834: ifne -> 18842
/*      */     //   18837: goto_w -> 18860
/*      */     //   18842: aload_0
/*      */     //   18843: getfield bco : [LContO;
/*      */     //   18846: aload_0
/*      */     //   18847: getfield sp : I
/*      */     //   18850: aaload
/*      */     //   18851: iconst_1
/*      */     //   18852: putfield roted : Z
/*      */     //   18855: goto_w -> 18878
/*      */     //   18860: aload_0
/*      */     //   18861: getfield bco : [LContO;
/*      */     //   18864: aload_0
/*      */     //   18865: getfield sp : I
/*      */     //   18868: aaload
/*      */     //   18869: iconst_0
/*      */     //   18870: putfield roted : Z
/*      */     //   18873: goto_w -> 18878
/*      */     //   18878: aload_0
/*      */     //   18879: getfield bco : [LContO;
/*      */     //   18882: aload_0
/*      */     //   18883: getfield sp : I
/*      */     //   18886: aaload
/*      */     //   18887: iconst_0
/*      */     //   18888: putfield x : I
/*      */     //   18891: aload_0
/*      */     //   18892: getfield bco : [LContO;
/*      */     //   18895: aload_0
/*      */     //   18896: getfield sp : I
/*      */     //   18899: aaload
/*      */     //   18900: iconst_0
/*      */     //   18901: putfield y : I
/*      */     //   18904: aload_0
/*      */     //   18905: getfield bco : [LContO;
/*      */     //   18908: aload_0
/*      */     //   18909: getfield sp : I
/*      */     //   18912: aaload
/*      */     //   18913: iconst_0
/*      */     //   18914: putfield z : I
/*      */     //   18917: aload_0
/*      */     //   18918: getfield bco : [LContO;
/*      */     //   18921: aload_0
/*      */     //   18922: getfield sp : I
/*      */     //   18925: aaload
/*      */     //   18926: aload_0
/*      */     //   18927: getfield rot : I
/*      */     //   18930: aload_0
/*      */     //   18931: getfield adrot : I
/*      */     //   18934: iadd
/*      */     //   18935: putfield xz : I
/*      */     //   18938: aload_0
/*      */     //   18939: getfield bco : [LContO;
/*      */     //   18942: aload_0
/*      */     //   18943: getfield sp : I
/*      */     //   18946: aaload
/*      */     //   18947: aload_0
/*      */     //   18948: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   18951: invokevirtual d : (Ljava/awt/Graphics2D;)V
/*      */     //   18954: iconst_1
/*      */     //   18955: istore #5
/*      */     //   18957: aload_0
/*      */     //   18958: getfield sptyp : I
/*      */     //   18961: ifne -> 18969
/*      */     //   18964: goto_w -> 18982
/*      */     //   18969: aload_0
/*      */     //   18970: getfield sptyp : I
/*      */     //   18973: iconst_1
/*      */     //   18974: if_icmpeq -> 18982
/*      */     //   18977: goto_w -> 19301
/*      */     //   18982: aload_0
/*      */     //   18983: getfield sp : I
/*      */     //   18986: bipush #26
/*      */     //   18988: if_icmpne -> 18996
/*      */     //   18991: goto_w -> 19044
/*      */     //   18996: aload_0
/*      */     //   18997: getfield sp : I
/*      */     //   19000: bipush #20
/*      */     //   19002: if_icmpne -> 19010
/*      */     //   19005: goto_w -> 19044
/*      */     //   19010: aload_0
/*      */     //   19011: getfield rot : I
/*      */     //   19014: bipush #-90
/*      */     //   19016: if_icmpne -> 19024
/*      */     //   19019: goto_w -> 19036
/*      */     //   19024: aload_0
/*      */     //   19025: getfield rot : I
/*      */     //   19028: ifeq -> 19036
/*      */     //   19031: goto_w -> 19146
/*      */     //   19036: iconst_m1
/*      */     //   19037: istore #5
/*      */     //   19039: goto_w -> 19146
/*      */     //   19044: aload_0
/*      */     //   19045: getfield sp : I
/*      */     //   19048: bipush #26
/*      */     //   19050: if_icmpeq -> 19058
/*      */     //   19053: goto_w -> 19095
/*      */     //   19058: aload_0
/*      */     //   19059: getfield rot : I
/*      */     //   19062: bipush #-90
/*      */     //   19064: if_icmpne -> 19072
/*      */     //   19067: goto_w -> 19087
/*      */     //   19072: aload_0
/*      */     //   19073: getfield rot : I
/*      */     //   19076: sipush #180
/*      */     //   19079: if_icmpeq -> 19087
/*      */     //   19082: goto_w -> 19095
/*      */     //   19087: iconst_m1
/*      */     //   19088: istore #5
/*      */     //   19090: goto_w -> 19095
/*      */     //   19095: aload_0
/*      */     //   19096: getfield sp : I
/*      */     //   19099: bipush #20
/*      */     //   19101: if_icmpeq -> 19109
/*      */     //   19104: goto_w -> 19146
/*      */     //   19109: aload_0
/*      */     //   19110: getfield rot : I
/*      */     //   19113: bipush #90
/*      */     //   19115: if_icmpne -> 19123
/*      */     //   19118: goto_w -> 19138
/*      */     //   19123: aload_0
/*      */     //   19124: getfield rot : I
/*      */     //   19127: sipush #180
/*      */     //   19130: if_icmpeq -> 19138
/*      */     //   19133: goto_w -> 19146
/*      */     //   19138: iconst_m1
/*      */     //   19139: istore #5
/*      */     //   19141: goto_w -> 19146
/*      */     //   19146: aload_0
/*      */     //   19147: getfield seq : I
/*      */     //   19150: iconst_2
/*      */     //   19151: if_icmpeq -> 19159
/*      */     //   19154: goto_w -> 19210
/*      */     //   19159: aload_0
/*      */     //   19160: getfield bco : [LContO;
/*      */     //   19163: aload_0
/*      */     //   19164: getfield sp : I
/*      */     //   19167: aaload
/*      */     //   19168: dup
/*      */     //   19169: getfield xy : I
/*      */     //   19172: iconst_5
/*      */     //   19173: iload #5
/*      */     //   19175: imul
/*      */     //   19176: isub
/*      */     //   19177: putfield xy : I
/*      */     //   19180: aload_0
/*      */     //   19181: getfield bco : [LContO;
/*      */     //   19184: aload_0
/*      */     //   19185: getfield sp : I
/*      */     //   19188: aaload
/*      */     //   19189: getfield xy : I
/*      */     //   19192: ifeq -> 19200
/*      */     //   19195: goto_w -> 19210
/*      */     //   19200: aload_0
/*      */     //   19201: iconst_3
/*      */     //   19202: putfield seq : I
/*      */     //   19205: goto_w -> 19210
/*      */     //   19210: aload_0
/*      */     //   19211: getfield seq : I
/*      */     //   19214: iconst_1
/*      */     //   19215: if_icmpeq -> 19223
/*      */     //   19218: goto_w -> 19233
/*      */     //   19223: aload_0
/*      */     //   19224: iconst_2
/*      */     //   19225: putfield seq : I
/*      */     //   19228: goto_w -> 19233
/*      */     //   19233: aload_0
/*      */     //   19234: getfield seq : I
/*      */     //   19237: ifeq -> 19245
/*      */     //   19240: goto_w -> 19301
/*      */     //   19245: aload_0
/*      */     //   19246: getfield bco : [LContO;
/*      */     //   19249: aload_0
/*      */     //   19250: getfield sp : I
/*      */     //   19253: aaload
/*      */     //   19254: dup
/*      */     //   19255: getfield xy : I
/*      */     //   19258: iconst_5
/*      */     //   19259: iload #5
/*      */     //   19261: imul
/*      */     //   19262: iadd
/*      */     //   19263: putfield xy : I
/*      */     //   19266: aload_0
/*      */     //   19267: getfield bco : [LContO;
/*      */     //   19270: aload_0
/*      */     //   19271: getfield sp : I
/*      */     //   19274: aaload
/*      */     //   19275: getfield xy : I
/*      */     //   19278: bipush #85
/*      */     //   19280: iload #5
/*      */     //   19282: imul
/*      */     //   19283: if_icmpeq -> 19291
/*      */     //   19286: goto_w -> 19301
/*      */     //   19291: aload_0
/*      */     //   19292: iconst_1
/*      */     //   19293: putfield seq : I
/*      */     //   19296: goto_w -> 19301
/*      */     //   19301: aload_0
/*      */     //   19302: getfield sptyp : I
/*      */     //   19305: iconst_2
/*      */     //   19306: if_icmpne -> 19314
/*      */     //   19309: goto_w -> 19354
/*      */     //   19314: aload_0
/*      */     //   19315: getfield sptyp : I
/*      */     //   19318: iconst_3
/*      */     //   19319: if_icmpne -> 19327
/*      */     //   19322: goto_w -> 19354
/*      */     //   19327: aload_0
/*      */     //   19328: getfield sptyp : I
/*      */     //   19331: iconst_4
/*      */     //   19332: if_icmpne -> 19340
/*      */     //   19335: goto_w -> 19354
/*      */     //   19340: aload_0
/*      */     //   19341: getfield sptyp : I
/*      */     //   19344: bipush #6
/*      */     //   19346: if_icmpeq -> 19354
/*      */     //   19349: goto_w -> 19547
/*      */     //   19354: aload_0
/*      */     //   19355: getfield rot : I
/*      */     //   19358: bipush #-90
/*      */     //   19360: if_icmpne -> 19368
/*      */     //   19363: goto_w -> 19383
/*      */     //   19368: aload_0
/*      */     //   19369: getfield rot : I
/*      */     //   19372: sipush #180
/*      */     //   19375: if_icmpeq -> 19383
/*      */     //   19378: goto_w -> 19391
/*      */     //   19383: iconst_m1
/*      */     //   19384: istore #5
/*      */     //   19386: goto_w -> 19391
/*      */     //   19391: aload_0
/*      */     //   19392: getfield seq : I
/*      */     //   19395: iconst_2
/*      */     //   19396: if_icmpeq -> 19404
/*      */     //   19399: goto_w -> 19455
/*      */     //   19404: aload_0
/*      */     //   19405: getfield bco : [LContO;
/*      */     //   19408: aload_0
/*      */     //   19409: getfield sp : I
/*      */     //   19412: aaload
/*      */     //   19413: dup
/*      */     //   19414: getfield zy : I
/*      */     //   19417: iconst_5
/*      */     //   19418: iload #5
/*      */     //   19420: imul
/*      */     //   19421: iadd
/*      */     //   19422: putfield zy : I
/*      */     //   19425: aload_0
/*      */     //   19426: getfield bco : [LContO;
/*      */     //   19429: aload_0
/*      */     //   19430: getfield sp : I
/*      */     //   19433: aaload
/*      */     //   19434: getfield zy : I
/*      */     //   19437: ifeq -> 19445
/*      */     //   19440: goto_w -> 19455
/*      */     //   19445: aload_0
/*      */     //   19446: iconst_3
/*      */     //   19447: putfield seq : I
/*      */     //   19450: goto_w -> 19455
/*      */     //   19455: aload_0
/*      */     //   19456: getfield seq : I
/*      */     //   19459: iconst_1
/*      */     //   19460: if_icmpeq -> 19468
/*      */     //   19463: goto_w -> 19478
/*      */     //   19468: aload_0
/*      */     //   19469: iconst_2
/*      */     //   19470: putfield seq : I
/*      */     //   19473: goto_w -> 19478
/*      */     //   19478: aload_0
/*      */     //   19479: getfield seq : I
/*      */     //   19482: ifeq -> 19490
/*      */     //   19485: goto_w -> 19547
/*      */     //   19490: aload_0
/*      */     //   19491: getfield bco : [LContO;
/*      */     //   19494: aload_0
/*      */     //   19495: getfield sp : I
/*      */     //   19498: aaload
/*      */     //   19499: dup
/*      */     //   19500: getfield zy : I
/*      */     //   19503: iconst_5
/*      */     //   19504: iload #5
/*      */     //   19506: imul
/*      */     //   19507: isub
/*      */     //   19508: putfield zy : I
/*      */     //   19511: aload_0
/*      */     //   19512: getfield bco : [LContO;
/*      */     //   19515: aload_0
/*      */     //   19516: getfield sp : I
/*      */     //   19519: aaload
/*      */     //   19520: getfield zy : I
/*      */     //   19523: bipush #85
/*      */     //   19525: iload #5
/*      */     //   19527: imul
/*      */     //   19528: ineg
/*      */     //   19529: if_icmpeq -> 19537
/*      */     //   19532: goto_w -> 19547
/*      */     //   19537: aload_0
/*      */     //   19538: iconst_1
/*      */     //   19539: putfield seq : I
/*      */     //   19542: goto_w -> 19547
/*      */     //   19547: aload_0
/*      */     //   19548: getfield sptyp : I
/*      */     //   19551: iconst_5
/*      */     //   19552: if_icmpeq -> 19560
/*      */     //   19555: goto_w -> 19965
/*      */     //   19560: aload_0
/*      */     //   19561: getfield rot : I
/*      */     //   19564: bipush #-90
/*      */     //   19566: if_icmpne -> 19574
/*      */     //   19569: goto_w -> 19589
/*      */     //   19574: aload_0
/*      */     //   19575: getfield rot : I
/*      */     //   19578: sipush #180
/*      */     //   19581: if_icmpeq -> 19589
/*      */     //   19584: goto_w -> 19597
/*      */     //   19589: iconst_m1
/*      */     //   19590: istore #5
/*      */     //   19592: goto_w -> 19597
/*      */     //   19597: iconst_0
/*      */     //   19598: istore #6
/*      */     //   19600: aload_0
/*      */     //   19601: getfield rot : I
/*      */     //   19604: bipush #-90
/*      */     //   19606: if_icmpne -> 19614
/*      */     //   19609: goto_w -> 19628
/*      */     //   19614: aload_0
/*      */     //   19615: getfield rot : I
/*      */     //   19618: bipush #90
/*      */     //   19620: if_icmpeq -> 19628
/*      */     //   19623: goto_w -> 19636
/*      */     //   19628: iconst_1
/*      */     //   19629: istore #6
/*      */     //   19631: goto_w -> 19636
/*      */     //   19636: iload #6
/*      */     //   19638: ifeq -> 19646
/*      */     //   19641: goto_w -> 19664
/*      */     //   19646: aload_0
/*      */     //   19647: getfield bco : [LContO;
/*      */     //   19650: aload_0
/*      */     //   19651: getfield sp : I
/*      */     //   19654: aaload
/*      */     //   19655: iconst_0
/*      */     //   19656: putfield xy : I
/*      */     //   19659: goto_w -> 19677
/*      */     //   19664: aload_0
/*      */     //   19665: getfield bco : [LContO;
/*      */     //   19668: aload_0
/*      */     //   19669: getfield sp : I
/*      */     //   19672: aaload
/*      */     //   19673: iconst_0
/*      */     //   19674: putfield zy : I
/*      */     //   19677: aload_0
/*      */     //   19678: getfield seq : I
/*      */     //   19681: iconst_2
/*      */     //   19682: if_icmpeq -> 19690
/*      */     //   19685: goto_w -> 19802
/*      */     //   19690: iload #6
/*      */     //   19692: ifeq -> 19700
/*      */     //   19695: goto_w -> 19751
/*      */     //   19700: aload_0
/*      */     //   19701: getfield bco : [LContO;
/*      */     //   19704: aload_0
/*      */     //   19705: getfield sp : I
/*      */     //   19708: aaload
/*      */     //   19709: dup
/*      */     //   19710: getfield zy : I
/*      */     //   19713: iconst_5
/*      */     //   19714: iload #5
/*      */     //   19716: imul
/*      */     //   19717: iadd
/*      */     //   19718: putfield zy : I
/*      */     //   19721: aload_0
/*      */     //   19722: getfield bco : [LContO;
/*      */     //   19725: aload_0
/*      */     //   19726: getfield sp : I
/*      */     //   19729: aaload
/*      */     //   19730: getfield zy : I
/*      */     //   19733: ifeq -> 19741
/*      */     //   19736: goto_w -> 19802
/*      */     //   19741: aload_0
/*      */     //   19742: iconst_3
/*      */     //   19743: putfield seq : I
/*      */     //   19746: goto_w -> 19802
/*      */     //   19751: aload_0
/*      */     //   19752: getfield bco : [LContO;
/*      */     //   19755: aload_0
/*      */     //   19756: getfield sp : I
/*      */     //   19759: aaload
/*      */     //   19760: dup
/*      */     //   19761: getfield xy : I
/*      */     //   19764: iconst_5
/*      */     //   19765: iload #5
/*      */     //   19767: imul
/*      */     //   19768: isub
/*      */     //   19769: putfield xy : I
/*      */     //   19772: aload_0
/*      */     //   19773: getfield bco : [LContO;
/*      */     //   19776: aload_0
/*      */     //   19777: getfield sp : I
/*      */     //   19780: aaload
/*      */     //   19781: getfield xy : I
/*      */     //   19784: ifeq -> 19792
/*      */     //   19787: goto_w -> 19802
/*      */     //   19792: aload_0
/*      */     //   19793: iconst_3
/*      */     //   19794: putfield seq : I
/*      */     //   19797: goto_w -> 19802
/*      */     //   19802: aload_0
/*      */     //   19803: getfield seq : I
/*      */     //   19806: iconst_1
/*      */     //   19807: if_icmpeq -> 19815
/*      */     //   19810: goto_w -> 19825
/*      */     //   19815: aload_0
/*      */     //   19816: iconst_2
/*      */     //   19817: putfield seq : I
/*      */     //   19820: goto_w -> 19825
/*      */     //   19825: aload_0
/*      */     //   19826: getfield seq : I
/*      */     //   19829: ifeq -> 19837
/*      */     //   19832: goto_w -> 19960
/*      */     //   19837: iload #6
/*      */     //   19839: ifeq -> 19847
/*      */     //   19842: goto_w -> 19904
/*      */     //   19847: aload_0
/*      */     //   19848: getfield bco : [LContO;
/*      */     //   19851: aload_0
/*      */     //   19852: getfield sp : I
/*      */     //   19855: aaload
/*      */     //   19856: dup
/*      */     //   19857: getfield zy : I
/*      */     //   19860: iconst_5
/*      */     //   19861: iload #5
/*      */     //   19863: imul
/*      */     //   19864: isub
/*      */     //   19865: putfield zy : I
/*      */     //   19868: aload_0
/*      */     //   19869: getfield bco : [LContO;
/*      */     //   19872: aload_0
/*      */     //   19873: getfield sp : I
/*      */     //   19876: aaload
/*      */     //   19877: getfield zy : I
/*      */     //   19880: bipush #85
/*      */     //   19882: iload #5
/*      */     //   19884: imul
/*      */     //   19885: ineg
/*      */     //   19886: if_icmpeq -> 19894
/*      */     //   19889: goto_w -> 19960
/*      */     //   19894: aload_0
/*      */     //   19895: iconst_1
/*      */     //   19896: putfield seq : I
/*      */     //   19899: goto_w -> 19960
/*      */     //   19904: aload_0
/*      */     //   19905: getfield bco : [LContO;
/*      */     //   19908: aload_0
/*      */     //   19909: getfield sp : I
/*      */     //   19912: aaload
/*      */     //   19913: dup
/*      */     //   19914: getfield xy : I
/*      */     //   19917: iconst_5
/*      */     //   19918: iload #5
/*      */     //   19920: imul
/*      */     //   19921: iadd
/*      */     //   19922: putfield xy : I
/*      */     //   19925: aload_0
/*      */     //   19926: getfield bco : [LContO;
/*      */     //   19929: aload_0
/*      */     //   19930: getfield sp : I
/*      */     //   19933: aaload
/*      */     //   19934: getfield xy : I
/*      */     //   19937: bipush #85
/*      */     //   19939: iload #5
/*      */     //   19941: imul
/*      */     //   19942: if_icmpeq -> 19950
/*      */     //   19945: goto_w -> 19960
/*      */     //   19950: aload_0
/*      */     //   19951: iconst_1
/*      */     //   19952: putfield seq : I
/*      */     //   19955: goto_w -> 19960
/*      */     //   19960: goto_w -> 19965
/*      */     //   19965: aload_0
/*      */     //   19966: getfield sp : I
/*      */     //   19969: bipush #66
/*      */     //   19971: if_icmpne -> 19979
/*      */     //   19974: goto_w -> 20293
/*      */     //   19979: aload_0
/*      */     //   19980: ldc_w '  Rotate  '
/*      */     //   19983: bipush #110
/*      */     //   19985: sipush #348
/*      */     //   19988: iconst_3
/*      */     //   19989: iconst_1
/*      */     //   19990: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   19993: ifne -> 20001
/*      */     //   19996: goto_w -> 20363
/*      */     //   20001: iconst_0
/*      */     //   20002: istore #6
/*      */     //   20004: aload_0
/*      */     //   20005: getfield rot : I
/*      */     //   20008: ifeq -> 20016
/*      */     //   20011: goto_w -> 20040
/*      */     //   20016: iload #6
/*      */     //   20018: ifeq -> 20026
/*      */     //   20021: goto_w -> 20040
/*      */     //   20026: aload_0
/*      */     //   20027: bipush #90
/*      */     //   20029: putfield rot : I
/*      */     //   20032: iconst_1
/*      */     //   20033: istore #6
/*      */     //   20035: goto_w -> 20040
/*      */     //   20040: aload_0
/*      */     //   20041: getfield rot : I
/*      */     //   20044: bipush #90
/*      */     //   20046: if_icmpeq -> 20054
/*      */     //   20049: goto_w -> 20079
/*      */     //   20054: iload #6
/*      */     //   20056: ifeq -> 20064
/*      */     //   20059: goto_w -> 20079
/*      */     //   20064: aload_0
/*      */     //   20065: sipush #180
/*      */     //   20068: putfield rot : I
/*      */     //   20071: iconst_1
/*      */     //   20072: istore #6
/*      */     //   20074: goto_w -> 20079
/*      */     //   20079: aload_0
/*      */     //   20080: getfield rot : I
/*      */     //   20083: sipush #180
/*      */     //   20086: if_icmpeq -> 20094
/*      */     //   20089: goto_w -> 20118
/*      */     //   20094: iload #6
/*      */     //   20096: ifeq -> 20104
/*      */     //   20099: goto_w -> 20118
/*      */     //   20104: aload_0
/*      */     //   20105: bipush #-90
/*      */     //   20107: putfield rot : I
/*      */     //   20110: iconst_1
/*      */     //   20111: istore #6
/*      */     //   20113: goto_w -> 20118
/*      */     //   20118: aload_0
/*      */     //   20119: getfield rot : I
/*      */     //   20122: bipush #-90
/*      */     //   20124: if_icmpeq -> 20132
/*      */     //   20127: goto_w -> 20155
/*      */     //   20132: iload #6
/*      */     //   20134: ifeq -> 20142
/*      */     //   20137: goto_w -> 20155
/*      */     //   20142: aload_0
/*      */     //   20143: iconst_0
/*      */     //   20144: putfield rot : I
/*      */     //   20147: iconst_1
/*      */     //   20148: istore #6
/*      */     //   20150: goto_w -> 20155
/*      */     //   20155: aload_0
/*      */     //   20156: getfield sp : I
/*      */     //   20159: bipush #30
/*      */     //   20161: if_icmpne -> 20169
/*      */     //   20164: goto_w -> 20197
/*      */     //   20169: aload_0
/*      */     //   20170: getfield sp : I
/*      */     //   20173: bipush #31
/*      */     //   20175: if_icmpne -> 20183
/*      */     //   20178: goto_w -> 20197
/*      */     //   20183: aload_0
/*      */     //   20184: getfield sp : I
/*      */     //   20187: bipush #32
/*      */     //   20189: if_icmpeq -> 20197
/*      */     //   20192: goto_w -> 20247
/*      */     //   20197: aload_0
/*      */     //   20198: getfield rot : I
/*      */     //   20201: bipush #-90
/*      */     //   20203: if_icmpeq -> 20211
/*      */     //   20206: goto_w -> 20222
/*      */     //   20211: aload_0
/*      */     //   20212: bipush #90
/*      */     //   20214: putfield rot : I
/*      */     //   20217: goto_w -> 20222
/*      */     //   20222: aload_0
/*      */     //   20223: getfield rot : I
/*      */     //   20226: sipush #180
/*      */     //   20229: if_icmpeq -> 20237
/*      */     //   20232: goto_w -> 20247
/*      */     //   20237: aload_0
/*      */     //   20238: iconst_0
/*      */     //   20239: putfield rot : I
/*      */     //   20242: goto_w -> 20247
/*      */     //   20247: aload_0
/*      */     //   20248: iconst_3
/*      */     //   20249: putfield seq : I
/*      */     //   20252: aload_0
/*      */     //   20253: getfield bco : [LContO;
/*      */     //   20256: aload_0
/*      */     //   20257: getfield sp : I
/*      */     //   20260: aaload
/*      */     //   20261: iconst_0
/*      */     //   20262: putfield xy : I
/*      */     //   20265: aload_0
/*      */     //   20266: getfield bco : [LContO;
/*      */     //   20269: aload_0
/*      */     //   20270: getfield sp : I
/*      */     //   20273: aaload
/*      */     //   20274: iconst_0
/*      */     //   20275: putfield zy : I
/*      */     //   20278: aload_0
/*      */     //   20279: iconst_0
/*      */     //   20280: putfield epart : Z
/*      */     //   20283: aload_0
/*      */     //   20284: iconst_0
/*      */     //   20285: putfield arrng : Z
/*      */     //   20288: goto_w -> 20363
/*      */     //   20293: aload_0
/*      */     //   20294: ldc_w '  Generate New  '
/*      */     //   20297: bipush #110
/*      */     //   20299: sipush #348
/*      */     //   20302: iconst_3
/*      */     //   20303: iconst_1
/*      */     //   20304: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   20307: ifne -> 20315
/*      */     //   20310: goto_w -> 20363
/*      */     //   20315: aload_0
/*      */     //   20316: iconst_0
/*      */     //   20317: putfield pgen : Z
/*      */     //   20320: aload_0
/*      */     //   20321: ldc2_w 2
/*      */     //   20324: invokestatic random : ()D
/*      */     //   20327: ldc2_w 4.0
/*      */     //   20330: dmul
/*      */     //   20331: invokestatic round : (D)J
/*      */     //   20334: ladd
/*      */     //   20335: l2f
/*      */     //   20336: putfield pwd : F
/*      */     //   20339: aload_0
/*      */     //   20340: ldc2_w 2
/*      */     //   20343: invokestatic random : ()D
/*      */     //   20346: ldc2_w 4.0
/*      */     //   20349: dmul
/*      */     //   20350: invokestatic round : (D)J
/*      */     //   20353: ladd
/*      */     //   20354: l2f
/*      */     //   20355: putfield phd : F
/*      */     //   20358: goto_w -> 20363
/*      */     //   20363: aload_0
/*      */     //   20364: ldc_w '>'
/*      */     //   20367: sipush #191
/*      */     //   20370: sipush #348
/*      */     //   20373: iconst_3
/*      */     //   20374: iconst_1
/*      */     //   20375: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   20378: ifne -> 20386
/*      */     //   20381: goto_w -> 20502
/*      */     //   20386: aload_0
/*      */     //   20387: getfield sptyp : I
/*      */     //   20390: ifne -> 20398
/*      */     //   20393: goto_w -> 20437
/*      */     //   20398: aload_0
/*      */     //   20399: getfield sptyp : I
/*      */     //   20402: iconst_1
/*      */     //   20403: if_icmpne -> 20411
/*      */     //   20406: goto_w -> 20437
/*      */     //   20411: aload_0
/*      */     //   20412: getfield sptyp : I
/*      */     //   20415: iconst_2
/*      */     //   20416: if_icmpne -> 20424
/*      */     //   20419: goto_w -> 20437
/*      */     //   20424: aload_0
/*      */     //   20425: getfield sptyp : I
/*      */     //   20428: iconst_5
/*      */     //   20429: if_icmpeq -> 20437
/*      */     //   20432: goto_w -> 20502
/*      */     //   20437: aload_0
/*      */     //   20438: dup
/*      */     //   20439: getfield spart : I
/*      */     //   20442: iconst_1
/*      */     //   20443: iadd
/*      */     //   20444: putfield spart : I
/*      */     //   20447: aload_0
/*      */     //   20448: getfield spart : I
/*      */     //   20451: aload_0
/*      */     //   20452: getfield part : LSmenu;
/*      */     //   20455: invokevirtual getItemCount : ()I
/*      */     //   20458: if_icmpeq -> 20466
/*      */     //   20461: goto_w -> 20476
/*      */     //   20466: aload_0
/*      */     //   20467: iconst_0
/*      */     //   20468: putfield spart : I
/*      */     //   20471: goto_w -> 20476
/*      */     //   20476: aload_0
/*      */     //   20477: getfield part : LSmenu;
/*      */     //   20480: aload_0
/*      */     //   20481: getfield spart : I
/*      */     //   20484: invokevirtual select : (I)V
/*      */     //   20487: aload_0
/*      */     //   20488: iconst_0
/*      */     //   20489: putfield epart : Z
/*      */     //   20492: aload_0
/*      */     //   20493: iconst_0
/*      */     //   20494: putfield arrng : Z
/*      */     //   20497: goto_w -> 20502
/*      */     //   20502: aload_0
/*      */     //   20503: ldc_w '<'
/*      */     //   20506: bipush #28
/*      */     //   20508: sipush #348
/*      */     //   20511: iconst_3
/*      */     //   20512: iconst_1
/*      */     //   20513: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   20516: ifne -> 20524
/*      */     //   20519: goto_w -> 20642
/*      */     //   20524: aload_0
/*      */     //   20525: getfield sptyp : I
/*      */     //   20528: ifne -> 20536
/*      */     //   20531: goto_w -> 20575
/*      */     //   20536: aload_0
/*      */     //   20537: getfield sptyp : I
/*      */     //   20540: iconst_1
/*      */     //   20541: if_icmpne -> 20549
/*      */     //   20544: goto_w -> 20575
/*      */     //   20549: aload_0
/*      */     //   20550: getfield sptyp : I
/*      */     //   20553: iconst_2
/*      */     //   20554: if_icmpne -> 20562
/*      */     //   20557: goto_w -> 20575
/*      */     //   20562: aload_0
/*      */     //   20563: getfield sptyp : I
/*      */     //   20566: iconst_5
/*      */     //   20567: if_icmpeq -> 20575
/*      */     //   20570: goto_w -> 20642
/*      */     //   20575: aload_0
/*      */     //   20576: dup
/*      */     //   20577: getfield spart : I
/*      */     //   20580: iconst_1
/*      */     //   20581: isub
/*      */     //   20582: putfield spart : I
/*      */     //   20585: aload_0
/*      */     //   20586: getfield spart : I
/*      */     //   20589: iconst_m1
/*      */     //   20590: if_icmpeq -> 20598
/*      */     //   20593: goto_w -> 20616
/*      */     //   20598: aload_0
/*      */     //   20599: aload_0
/*      */     //   20600: getfield part : LSmenu;
/*      */     //   20603: invokevirtual getItemCount : ()I
/*      */     //   20606: iconst_1
/*      */     //   20607: isub
/*      */     //   20608: putfield spart : I
/*      */     //   20611: goto_w -> 20616
/*      */     //   20616: aload_0
/*      */     //   20617: getfield part : LSmenu;
/*      */     //   20620: aload_0
/*      */     //   20621: getfield spart : I
/*      */     //   20624: invokevirtual select : (I)V
/*      */     //   20627: aload_0
/*      */     //   20628: iconst_0
/*      */     //   20629: putfield epart : Z
/*      */     //   20632: aload_0
/*      */     //   20633: iconst_0
/*      */     //   20634: putfield arrng : Z
/*      */     //   20637: goto_w -> 20642
/*      */     //   20642: aload_0
/*      */     //   20643: ldc_w '   <  Undo   '
/*      */     //   20646: sipush #204
/*      */     //   20649: sipush #404
/*      */     //   20652: iconst_0
/*      */     //   20653: iconst_1
/*      */     //   20654: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   20657: ifne -> 20665
/*      */     //   20660: goto_w -> 20720
/*      */     //   20665: aload_0
/*      */     //   20666: iconst_0
/*      */     //   20667: putfield epart : Z
/*      */     //   20670: aload_0
/*      */     //   20671: iconst_0
/*      */     //   20672: putfield arrng : Z
/*      */     //   20675: aload_0
/*      */     //   20676: getfield nundo : I
/*      */     //   20679: ifgt -> 20687
/*      */     //   20682: goto_w -> 20720
/*      */     //   20687: aload_0
/*      */     //   20688: dup
/*      */     //   20689: getfield nundo : I
/*      */     //   20692: iconst_1
/*      */     //   20693: isub
/*      */     //   20694: putfield nundo : I
/*      */     //   20697: aload_0
/*      */     //   20698: aload_0
/*      */     //   20699: getfield undos : [Ljava/lang/String;
/*      */     //   20702: aload_0
/*      */     //   20703: getfield nundo : I
/*      */     //   20706: aaload
/*      */     //   20707: putfield bstage : Ljava/lang/String;
/*      */     //   20710: aload_0
/*      */     //   20711: iconst_0
/*      */     //   20712: invokevirtual readstage : (I)V
/*      */     //   20715: goto_w -> 20720
/*      */     //   20720: aload_0
/*      */     //   20721: ldc_w '   Remove / Edit  Part   '
/*      */     //   20724: sipush #172
/*      */     //   20727: sipush #454
/*      */     //   20730: iconst_0
/*      */     //   20731: iconst_1
/*      */     //   20732: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   20735: ifne -> 20743
/*      */     //   20738: goto_w -> 20785
/*      */     //   20743: aload_0
/*      */     //   20744: getfield epart : Z
/*      */     //   20747: ifeq -> 20755
/*      */     //   20750: goto_w -> 20765
/*      */     //   20755: aload_0
/*      */     //   20756: iconst_1
/*      */     //   20757: putfield epart : Z
/*      */     //   20760: goto_w -> 20770
/*      */     //   20765: aload_0
/*      */     //   20766: iconst_0
/*      */     //   20767: putfield epart : Z
/*      */     //   20770: aload_0
/*      */     //   20771: iconst_0
/*      */     //   20772: putfield arrng : Z
/*      */     //   20775: aload_0
/*      */     //   20776: iconst_m1
/*      */     //   20777: putfield esp : I
/*      */     //   20780: goto_w -> 20785
/*      */     //   20785: aload_0
/*      */     //   20786: ldc_w '   Go to >  Startline   '
/*      */     //   20789: sipush #175
/*      */     //   20792: sipush #504
/*      */     //   20795: iconst_0
/*      */     //   20796: iconst_1
/*      */     //   20797: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   20800: ifne -> 20808
/*      */     //   20803: goto_w -> 20825
/*      */     //   20808: aload_0
/*      */     //   20809: iconst_0
/*      */     //   20810: putfield sx : I
/*      */     //   20813: aload_0
/*      */     //   20814: sipush #1500
/*      */     //   20817: putfield sz : I
/*      */     //   20820: goto_w -> 20825
/*      */     //   20825: aload_0
/*      */     //   20826: ldc_w ' About Part '
/*      */     //   20829: sipush #164
/*      */     //   20832: bipush #66
/*      */     //   20834: iconst_3
/*      */     //   20835: iconst_0
/*      */     //   20836: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   20839: ifne -> 20847
/*      */     //   20842: goto_w -> 20869
/*      */     //   20847: aconst_null
/*      */     //   20848: aload_0
/*      */     //   20849: getfield discp : [Ljava/lang/String;
/*      */     //   20852: aload_0
/*      */     //   20853: getfield sp : I
/*      */     //   20856: aaload
/*      */     //   20857: ldc_w 'Stage Maker'
/*      */     //   20860: iconst_1
/*      */     //   20861: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   20864: goto_w -> 20869
/*      */     //   20869: aload_0
/*      */     //   20870: ldc_w '  Keyboard Controls  '
/*      */     //   20873: sipush #691
/*      */     //   20876: sipush #536
/*      */     //   20879: iconst_3
/*      */     //   20880: iconst_0
/*      */     //   20881: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   20884: ifne -> 20892
/*      */     //   20887: goto_w -> 20908
/*      */     //   20892: aconst_null
/*      */     //   20893: ldc_w 'Instead of clicking the triangular buttons around the Building Area to scroll, you can use:\\n[ Keyboard Arrows ]\\n\\nYou can also zoom in and out using the following keys:\\n[+] & [-]  or  [8] & [2]  or  [Enter] & [Backspace]\\n\\n'
/*      */     //   20896: ldc_w 'Stage Maker'
/*      */     //   20899: iconst_1
/*      */     //   20900: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   20903: goto_w -> 20908
/*      */     //   20908: aload_0
/*      */     //   20909: ldc_w '  Save  '
/*      */     //   20912: sipush #280
/*      */     //   20915: bipush #50
/*      */     //   20917: iconst_0
/*      */     //   20918: iconst_0
/*      */     //   20919: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   20922: ifne -> 20930
/*      */     //   20925: goto_w -> 20949
/*      */     //   20930: aload_0
/*      */     //   20931: iconst_0
/*      */     //   20932: putfield epart : Z
/*      */     //   20935: aload_0
/*      */     //   20936: iconst_0
/*      */     //   20937: putfield arrng : Z
/*      */     //   20940: aload_0
/*      */     //   20941: invokevirtual savefile : ()V
/*      */     //   20944: goto_w -> 20949
/*      */     //   20949: aload_0
/*      */     //   20950: ldc_w '  Save & Preview  '
/*      */     //   20953: sipush #380
/*      */     //   20956: bipush #50
/*      */     //   20958: iconst_0
/*      */     //   20959: iconst_0
/*      */     //   20960: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   20963: ifne -> 20971
/*      */     //   20966: goto_w -> 20999
/*      */     //   20971: aload_0
/*      */     //   20972: iconst_0
/*      */     //   20973: putfield epart : Z
/*      */     //   20976: aload_0
/*      */     //   20977: iconst_0
/*      */     //   20978: putfield arrng : Z
/*      */     //   20981: aload_0
/*      */     //   20982: invokevirtual savefile : ()V
/*      */     //   20985: aload_0
/*      */     //   20986: invokevirtual hidefields : ()V
/*      */     //   20989: aload_0
/*      */     //   20990: iconst_2
/*      */     //   20991: putfield tab : I
/*      */     //   20994: goto_w -> 20999
/*      */     //   20999: aload_0
/*      */     //   21000: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   21003: new java/awt/Font
/*      */     //   21006: dup
/*      */     //   21007: ldc_w 'Arial'
/*      */     //   21010: iconst_1
/*      */     //   21011: bipush #12
/*      */     //   21013: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   21016: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   21019: aload_0
/*      */     //   21020: aload_0
/*      */     //   21021: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   21024: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   21027: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   21030: aload_0
/*      */     //   21031: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   21034: new java/awt/Color
/*      */     //   21037: dup
/*      */     //   21038: iconst_0
/*      */     //   21039: iconst_0
/*      */     //   21040: iconst_0
/*      */     //   21041: invokespecial <init> : (III)V
/*      */     //   21044: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   21047: iconst_0
/*      */     //   21048: istore #6
/*      */     //   21050: iconst_0
/*      */     //   21051: istore #7
/*      */     //   21053: aload_0
/*      */     //   21054: getfield xnob : I
/*      */     //   21057: i2f
/*      */     //   21058: ldc_w 601.0
/*      */     //   21061: fdiv
/*      */     //   21062: ldc_w 200.0
/*      */     //   21065: fmul
/*      */     //   21066: f2i
/*      */     //   21067: istore #8
/*      */     //   21069: iload #8
/*      */     //   21071: istore #6
/*      */     //   21073: aload_0
/*      */     //   21074: getfield t : LTrackers;
/*      */     //   21077: getfield nt : I
/*      */     //   21080: i2f
/*      */     //   21081: ldc_w 6700.0
/*      */     //   21084: fdiv
/*      */     //   21085: ldc_w 200.0
/*      */     //   21088: fmul
/*      */     //   21089: f2i
/*      */     //   21090: istore #9
/*      */     //   21092: iload #9
/*      */     //   21094: iload #6
/*      */     //   21096: if_icmpgt -> 21104
/*      */     //   21099: goto_w -> 21116
/*      */     //   21104: iload #9
/*      */     //   21106: istore #6
/*      */     //   21108: iconst_1
/*      */     //   21109: istore #7
/*      */     //   21111: goto_w -> 21116
/*      */     //   21116: aload_0
/*      */     //   21117: getfield cp : LCheckPoints;
/*      */     //   21120: getfield n : I
/*      */     //   21123: i2f
/*      */     //   21124: ldc_w 140.0
/*      */     //   21127: fdiv
/*      */     //   21128: ldc_w 200.0
/*      */     //   21131: fmul
/*      */     //   21132: f2i
/*      */     //   21133: istore #10
/*      */     //   21135: iload #10
/*      */     //   21137: iload #6
/*      */     //   21139: if_icmpgt -> 21147
/*      */     //   21142: goto_w -> 21159
/*      */     //   21147: iload #10
/*      */     //   21149: istore #6
/*      */     //   21151: iconst_2
/*      */     //   21152: istore #7
/*      */     //   21154: goto_w -> 21159
/*      */     //   21159: aload_0
/*      */     //   21160: getfield m : LMedium;
/*      */     //   21163: getfield nrw : I
/*      */     //   21166: aload_0
/*      */     //   21167: getfield m : LMedium;
/*      */     //   21170: getfield ncl : I
/*      */     //   21173: imul
/*      */     //   21174: i2f
/*      */     //   21175: ldc_w 16000.0
/*      */     //   21178: fdiv
/*      */     //   21179: ldc_w 200.0
/*      */     //   21182: fmul
/*      */     //   21183: f2i
/*      */     //   21184: istore #11
/*      */     //   21186: iload #11
/*      */     //   21188: iload #6
/*      */     //   21190: if_icmpgt -> 21198
/*      */     //   21193: goto_w -> 21210
/*      */     //   21198: iload #11
/*      */     //   21200: istore #6
/*      */     //   21202: iconst_3
/*      */     //   21203: istore #7
/*      */     //   21205: goto_w -> 21210
/*      */     //   21210: iload #6
/*      */     //   21212: sipush #200
/*      */     //   21215: if_icmpgt -> 21223
/*      */     //   21218: goto_w -> 21233
/*      */     //   21223: sipush #200
/*      */     //   21226: istore #6
/*      */     //   21228: goto_w -> 21233
/*      */     //   21233: iload #6
/*      */     //   21235: bipush #100
/*      */     //   21237: if_icmple -> 21245
/*      */     //   21240: goto_w -> 21274
/*      */     //   21245: aload_0
/*      */     //   21246: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   21249: new java/awt/Color
/*      */     //   21252: dup
/*      */     //   21253: bipush #100
/*      */     //   21255: iload #6
/*      */     //   21257: iadd
/*      */     //   21258: sipush #225
/*      */     //   21261: bipush #30
/*      */     //   21263: invokespecial <init> : (III)V
/*      */     //   21266: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   21269: goto_w -> 21299
/*      */     //   21274: aload_0
/*      */     //   21275: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   21278: new java/awt/Color
/*      */     //   21281: dup
/*      */     //   21282: sipush #200
/*      */     //   21285: sipush #325
/*      */     //   21288: iload #6
/*      */     //   21290: isub
/*      */     //   21291: bipush #30
/*      */     //   21293: invokespecial <init> : (III)V
/*      */     //   21296: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   21299: aload_0
/*      */     //   21300: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   21303: sipush #167
/*      */     //   21306: sipush #531
/*      */     //   21309: iload #6
/*      */     //   21311: bipush #9
/*      */     //   21313: invokevirtual fillRect : (IIII)V
/*      */     //   21316: aload_0
/*      */     //   21317: ldc_w 'Memory Consumption :'
/*      */     //   21320: bipush #85
/*      */     //   21322: sipush #540
/*      */     //   21325: iconst_3
/*      */     //   21326: iconst_0
/*      */     //   21327: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   21330: ifne -> 21338
/*      */     //   21333: goto_w -> 21419
/*      */     //   21338: aconst_null
/*      */     //   21339: new java/lang/StringBuilder
/*      */     //   21342: dup
/*      */     //   21343: invokespecial <init> : ()V
/*      */     //   21346: ldc_w 'Memory Consumption Details\\n\\nNumber of Parts:  '
/*      */     //   21349: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   21352: iload #8
/*      */     //   21354: iconst_2
/*      */     //   21355: idiv
/*      */     //   21356: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   21359: ldc_w ' %\\nPart's Details:  '
/*      */     //   21362: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   21365: iload #9
/*      */     //   21367: iconst_2
/*      */     //   21368: idiv
/*      */     //   21369: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   21372: ldc_w ' %\\nRoad Points:  '
/*      */     //   21375: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   21378: iload #10
/*      */     //   21380: iconst_2
/*      */     //   21381: idiv
/*      */     //   21382: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   21385: ldc_w ' %\\nStage Area:  '
/*      */     //   21388: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   21391: iload #11
/*      */     //   21393: iconst_2
/*      */     //   21394: idiv
/*      */     //   21395: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   21398: ldc_w ' %\\n \\n'
/*      */     //   21401: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   21404: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   21407: ldc_w 'Stage Maker'
/*      */     //   21410: iconst_1
/*      */     //   21411: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   21414: goto_w -> 21419
/*      */     //   21419: aload_0
/*      */     //   21420: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   21423: new java/awt/Color
/*      */     //   21426: dup
/*      */     //   21427: iconst_0
/*      */     //   21428: iconst_0
/*      */     //   21429: iconst_0
/*      */     //   21430: invokespecial <init> : (III)V
/*      */     //   21433: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   21436: aload_0
/*      */     //   21437: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   21440: sipush #167
/*      */     //   21443: sipush #531
/*      */     //   21446: sipush #200
/*      */     //   21449: bipush #9
/*      */     //   21451: invokevirtual drawRect : (IIII)V
/*      */     //   21454: iconst_4
/*      */     //   21455: anewarray java/lang/String
/*      */     //   21458: dup
/*      */     //   21459: iconst_0
/*      */     //   21460: ldc_w 'Number of Parts'
/*      */     //   21463: aastore
/*      */     //   21464: dup
/*      */     //   21465: iconst_1
/*      */     //   21466: ldc_w 'Part's Details'
/*      */     //   21469: aastore
/*      */     //   21470: dup
/*      */     //   21471: iconst_2
/*      */     //   21472: ldc_w 'Road Points'
/*      */     //   21475: aastore
/*      */     //   21476: dup
/*      */     //   21477: iconst_3
/*      */     //   21478: ldc_w 'Stage Area'
/*      */     //   21481: aastore
/*      */     //   21482: astore #12
/*      */     //   21484: aload_0
/*      */     //   21485: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   21488: aload #12
/*      */     //   21490: iload #7
/*      */     //   21492: aaload
/*      */     //   21493: sipush #267
/*      */     //   21496: aload_0
/*      */     //   21497: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   21500: aload #12
/*      */     //   21502: iload #7
/*      */     //   21504: aaload
/*      */     //   21505: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   21508: iconst_2
/*      */     //   21509: idiv
/*      */     //   21510: isub
/*      */     //   21511: sipush #540
/*      */     //   21514: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   21517: aload_0
/*      */     //   21518: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   21521: new java/lang/StringBuilder
/*      */     //   21524: dup
/*      */     //   21525: invokespecial <init> : ()V
/*      */     //   21528: ldc ''
/*      */     //   21530: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   21533: iload #6
/*      */     //   21535: iconst_2
/*      */     //   21536: idiv
/*      */     //   21537: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   21540: ldc_w ' %  used'
/*      */     //   21543: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   21546: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   21549: sipush #375
/*      */     //   21552: sipush #540
/*      */     //   21555: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   21558: aload_0
/*      */     //   21559: getfield overcan : Z
/*      */     //   21562: ifne -> 21570
/*      */     //   21565: goto_w -> 21580
/*      */     //   21570: aload_0
/*      */     //   21571: iconst_0
/*      */     //   21572: putfield overcan : Z
/*      */     //   21575: goto_w -> 21580
/*      */     //   21580: aload_0
/*      */     //   21581: getfield epart : Z
/*      */     //   21584: ifne -> 21592
/*      */     //   21587: goto_w -> 21671
/*      */     //   21592: aload_0
/*      */     //   21593: getfield esp : I
/*      */     //   21596: iconst_m1
/*      */     //   21597: if_icmpeq -> 21605
/*      */     //   21600: goto_w -> 21717
/*      */     //   21605: aload_0
/*      */     //   21606: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   21609: new java/awt/Color
/*      */     //   21612: dup
/*      */     //   21613: iconst_0
/*      */     //   21614: iconst_0
/*      */     //   21615: iconst_0
/*      */     //   21616: invokespecial <init> : (III)V
/*      */     //   21619: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   21622: aload_0
/*      */     //   21623: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   21626: ldc_w 'Click on any part to Edit >'
/*      */     //   21629: sipush #257
/*      */     //   21632: sipush #454
/*      */     //   21635: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   21638: aload_0
/*      */     //   21639: ldc_w ' Cancel '
/*      */     //   21642: sipush #323
/*      */     //   21645: sipush #474
/*      */     //   21648: iconst_4
/*      */     //   21649: iconst_0
/*      */     //   21650: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   21653: ifne -> 21661
/*      */     //   21656: goto_w -> 21717
/*      */     //   21661: aload_0
/*      */     //   21662: iconst_0
/*      */     //   21663: putfield epart : Z
/*      */     //   21666: goto_w -> 21717
/*      */     //   21671: aload_0
/*      */     //   21672: getfield hi : I
/*      */     //   21675: iconst_m1
/*      */     //   21676: if_icmpne -> 21684
/*      */     //   21679: goto_w -> 21694
/*      */     //   21684: aload_0
/*      */     //   21685: iconst_m1
/*      */     //   21686: putfield hi : I
/*      */     //   21689: goto_w -> 21694
/*      */     //   21694: aload_0
/*      */     //   21695: getfield esp : I
/*      */     //   21698: iconst_m1
/*      */     //   21699: if_icmpne -> 21707
/*      */     //   21702: goto_w -> 21717
/*      */     //   21707: aload_0
/*      */     //   21708: iconst_m1
/*      */     //   21709: putfield esp : I
/*      */     //   21712: goto_w -> 21717
/*      */     //   21717: aload_0
/*      */     //   21718: getfield arrng : Z
/*      */     //   21721: ifne -> 21729
/*      */     //   21724: goto_w -> 21865
/*      */     //   21729: aload_0
/*      */     //   21730: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   21733: new java/awt/Color
/*      */     //   21736: dup
/*      */     //   21737: iconst_0
/*      */     //   21738: iconst_0
/*      */     //   21739: iconst_0
/*      */     //   21740: invokespecial <init> : (III)V
/*      */     //   21743: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   21746: aload_0
/*      */     //   21747: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   21750: new java/lang/StringBuilder
/*      */     //   21753: dup
/*      */     //   21754: invokespecial <init> : ()V
/*      */     //   21757: ldc_w 'Click on Checkpoint NO# '
/*      */     //   21760: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   21763: aload_0
/*      */     //   21764: getfield arrcnt : I
/*      */     //   21767: iconst_1
/*      */     //   21768: iadd
/*      */     //   21769: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   21772: ldc_w '  >'
/*      */     //   21775: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   21778: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   21781: sipush #257
/*      */     //   21784: bipush #80
/*      */     //   21786: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   21789: aload_0
/*      */     //   21790: ldc_w ' Cancel '
/*      */     //   21793: sipush #330
/*      */     //   21796: bipush #100
/*      */     //   21798: iconst_4
/*      */     //   21799: iconst_0
/*      */     //   21800: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   21803: ifne -> 21811
/*      */     //   21806: goto_w -> 21821
/*      */     //   21811: aload_0
/*      */     //   21812: iconst_0
/*      */     //   21813: putfield arrng : Z
/*      */     //   21816: goto_w -> 21821
/*      */     //   21821: aload_0
/*      */     //   21822: getfield arrcnt : I
/*      */     //   21825: aload_0
/*      */     //   21826: getfield cp : LCheckPoints;
/*      */     //   21829: getfield nsp : I
/*      */     //   21832: if_icmpeq -> 21840
/*      */     //   21835: goto_w -> 21888
/*      */     //   21840: aload_0
/*      */     //   21841: invokevirtual sortstage : ()V
/*      */     //   21844: aconst_null
/*      */     //   21845: ldc_w 'Checkpoints Arranged!\\nPress Save and Test Drive to check the new checkpoint order.\\n'
/*      */     //   21848: ldc_w 'Stage Maker'
/*      */     //   21851: iconst_1
/*      */     //   21852: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   21855: aload_0
/*      */     //   21856: iconst_0
/*      */     //   21857: putfield arrng : Z
/*      */     //   21860: goto_w -> 21888
/*      */     //   21865: aload_0
/*      */     //   21866: getfield chi : I
/*      */     //   21869: iconst_m1
/*      */     //   21870: if_icmpne -> 21878
/*      */     //   21873: goto_w -> 21888
/*      */     //   21878: aload_0
/*      */     //   21879: iconst_m1
/*      */     //   21880: putfield chi : I
/*      */     //   21883: goto_w -> 21888
/*      */     //   21888: goto_w -> 21893
/*      */     //   21893: aload_0
/*      */     //   21894: getfield tab : I
/*      */     //   21897: iconst_2
/*      */     //   21898: if_icmpeq -> 21906
/*      */     //   21901: goto_w -> 35980
/*      */     //   21906: aload_0
/*      */     //   21907: getfield tabed : I
/*      */     //   21910: aload_0
/*      */     //   21911: getfield tab : I
/*      */     //   21914: if_icmpne -> 21922
/*      */     //   21917: goto_w -> 22006
/*      */     //   21922: aload_0
/*      */     //   21923: getfield m : LMedium;
/*      */     //   21926: iconst_0
/*      */     //   21927: putfield trk : I
/*      */     //   21930: aload_0
/*      */     //   21931: iconst_1
/*      */     //   21932: invokevirtual readstage : (I)V
/*      */     //   21935: aload_0
/*      */     //   21936: new java/awt/Cursor
/*      */     //   21939: dup
/*      */     //   21940: iconst_0
/*      */     //   21941: invokespecial <init> : (I)V
/*      */     //   21944: invokevirtual setCursor : (Ljava/awt/Cursor;)V
/*      */     //   21947: aload_0
/*      */     //   21948: iconst_0
/*      */     //   21949: putfield setcur : Z
/*      */     //   21952: aload_0
/*      */     //   21953: iconst_0
/*      */     //   21954: putfield vxz : I
/*      */     //   21957: aload_0
/*      */     //   21958: aload_0
/*      */     //   21959: getfield sx : I
/*      */     //   21962: sipush #400
/*      */     //   21965: isub
/*      */     //   21966: putfield vx : I
/*      */     //   21969: aload_0
/*      */     //   21970: aload_0
/*      */     //   21971: getfield sz : I
/*      */     //   21974: aload_0
/*      */     //   21975: getfield m : LMedium;
/*      */     //   21978: getfield cz : I
/*      */     //   21981: isub
/*      */     //   21982: sipush #8000
/*      */     //   21985: isub
/*      */     //   21986: putfield vz : I
/*      */     //   21989: aload_0
/*      */     //   21990: sipush #-1500
/*      */     //   21993: putfield vy : I
/*      */     //   21996: aload_0
/*      */     //   21997: iconst_m1
/*      */     //   21998: putfield dtabed : I
/*      */     //   22001: goto_w -> 22006
/*      */     //   22006: aload_0
/*      */     //   22007: getfield m : LMedium;
/*      */     //   22010: iconst_0
/*      */     //   22011: putfield trk : I
/*      */     //   22014: aload_0
/*      */     //   22015: getfield m : LMedium;
/*      */     //   22018: bipush #6
/*      */     //   22020: putfield zy : I
/*      */     //   22023: aload_0
/*      */     //   22024: getfield m : LMedium;
/*      */     //   22027: bipush #10
/*      */     //   22029: putfield iw : I
/*      */     //   22032: aload_0
/*      */     //   22033: getfield m : LMedium;
/*      */     //   22036: sipush #790
/*      */     //   22039: putfield w : I
/*      */     //   22042: aload_0
/*      */     //   22043: getfield m : LMedium;
/*      */     //   22046: bipush #35
/*      */     //   22048: putfield ih : I
/*      */     //   22051: aload_0
/*      */     //   22052: getfield m : LMedium;
/*      */     //   22055: sipush #445
/*      */     //   22058: putfield h : I
/*      */     //   22061: aload_0
/*      */     //   22062: getfield m : LMedium;
/*      */     //   22065: sipush #400
/*      */     //   22068: putfield cx : I
/*      */     //   22071: aload_0
/*      */     //   22072: getfield m : LMedium;
/*      */     //   22075: sipush #215
/*      */     //   22078: putfield cy : I
/*      */     //   22081: aload_0
/*      */     //   22082: getfield m : LMedium;
/*      */     //   22085: aload_0
/*      */     //   22086: getfield vxz : I
/*      */     //   22089: putfield xz : I
/*      */     //   22092: aload_0
/*      */     //   22093: getfield m : LMedium;
/*      */     //   22096: aload_0
/*      */     //   22097: getfield vx : I
/*      */     //   22100: putfield x : I
/*      */     //   22103: aload_0
/*      */     //   22104: getfield m : LMedium;
/*      */     //   22107: aload_0
/*      */     //   22108: getfield vz : I
/*      */     //   22111: putfield z : I
/*      */     //   22114: aload_0
/*      */     //   22115: getfield m : LMedium;
/*      */     //   22118: aload_0
/*      */     //   22119: getfield vy : I
/*      */     //   22122: putfield y : I
/*      */     //   22125: aload_0
/*      */     //   22126: getfield m : LMedium;
/*      */     //   22129: aload_0
/*      */     //   22130: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   22133: invokevirtual d : (Ljava/awt/Graphics2D;)V
/*      */     //   22136: iconst_0
/*      */     //   22137: istore_1
/*      */     //   22138: sipush #200
/*      */     //   22141: newarray int
/*      */     //   22143: astore_2
/*      */     //   22144: iconst_0
/*      */     //   22145: istore_3
/*      */     //   22146: iload_3
/*      */     //   22147: aload_0
/*      */     //   22148: getfield nob : I
/*      */     //   22151: if_icmplt -> 22159
/*      */     //   22154: goto_w -> 22209
/*      */     //   22159: aload_0
/*      */     //   22160: getfield co : [LContO;
/*      */     //   22163: iload_3
/*      */     //   22164: aaload
/*      */     //   22165: getfield dist : I
/*      */     //   22168: ifne -> 22176
/*      */     //   22171: goto_w -> 22188
/*      */     //   22176: aload_2
/*      */     //   22177: iload_1
/*      */     //   22178: iload_3
/*      */     //   22179: iastore
/*      */     //   22180: iinc #1, 1
/*      */     //   22183: goto_w -> 22201
/*      */     //   22188: aload_0
/*      */     //   22189: getfield co : [LContO;
/*      */     //   22192: iload_3
/*      */     //   22193: aaload
/*      */     //   22194: aload_0
/*      */     //   22195: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   22198: invokevirtual d : (Ljava/awt/Graphics2D;)V
/*      */     //   22201: iinc #3, 1
/*      */     //   22204: goto_w -> 22146
/*      */     //   22209: iload_1
/*      */     //   22210: newarray int
/*      */     //   22212: astore_3
/*      */     //   22213: iconst_0
/*      */     //   22214: istore #4
/*      */     //   22216: iload #4
/*      */     //   22218: iload_1
/*      */     //   22219: if_icmplt -> 22227
/*      */     //   22222: goto_w -> 22240
/*      */     //   22227: aload_3
/*      */     //   22228: iload #4
/*      */     //   22230: iconst_0
/*      */     //   22231: iastore
/*      */     //   22232: iinc #4, 1
/*      */     //   22235: goto_w -> 22216
/*      */     //   22240: iconst_0
/*      */     //   22241: istore #4
/*      */     //   22243: iload #4
/*      */     //   22245: iload_1
/*      */     //   22246: if_icmplt -> 22254
/*      */     //   22249: goto_w -> 22410
/*      */     //   22254: iload #4
/*      */     //   22256: iconst_1
/*      */     //   22257: iadd
/*      */     //   22258: istore #5
/*      */     //   22260: iload #5
/*      */     //   22262: iload_1
/*      */     //   22263: if_icmplt -> 22271
/*      */     //   22266: goto_w -> 22402
/*      */     //   22271: aload_0
/*      */     //   22272: getfield co : [LContO;
/*      */     //   22275: aload_2
/*      */     //   22276: iload #4
/*      */     //   22278: iaload
/*      */     //   22279: aaload
/*      */     //   22280: getfield dist : I
/*      */     //   22283: aload_0
/*      */     //   22284: getfield co : [LContO;
/*      */     //   22287: aload_2
/*      */     //   22288: iload #5
/*      */     //   22290: iaload
/*      */     //   22291: aaload
/*      */     //   22292: getfield dist : I
/*      */     //   22295: if_icmpne -> 22303
/*      */     //   22298: goto_w -> 22361
/*      */     //   22303: aload_0
/*      */     //   22304: getfield co : [LContO;
/*      */     //   22307: aload_2
/*      */     //   22308: iload #4
/*      */     //   22310: iaload
/*      */     //   22311: aaload
/*      */     //   22312: getfield dist : I
/*      */     //   22315: aload_0
/*      */     //   22316: getfield co : [LContO;
/*      */     //   22319: aload_2
/*      */     //   22320: iload #5
/*      */     //   22322: iaload
/*      */     //   22323: aaload
/*      */     //   22324: getfield dist : I
/*      */     //   22327: if_icmplt -> 22335
/*      */     //   22330: goto_w -> 22348
/*      */     //   22335: aload_3
/*      */     //   22336: iload #4
/*      */     //   22338: dup2
/*      */     //   22339: iaload
/*      */     //   22340: iconst_1
/*      */     //   22341: iadd
/*      */     //   22342: iastore
/*      */     //   22343: goto_w -> 22394
/*      */     //   22348: aload_3
/*      */     //   22349: iload #5
/*      */     //   22351: dup2
/*      */     //   22352: iaload
/*      */     //   22353: iconst_1
/*      */     //   22354: iadd
/*      */     //   22355: iastore
/*      */     //   22356: goto_w -> 22394
/*      */     //   22361: iload #5
/*      */     //   22363: iload #4
/*      */     //   22365: if_icmpgt -> 22373
/*      */     //   22368: goto_w -> 22386
/*      */     //   22373: aload_3
/*      */     //   22374: iload #4
/*      */     //   22376: dup2
/*      */     //   22377: iaload
/*      */     //   22378: iconst_1
/*      */     //   22379: iadd
/*      */     //   22380: iastore
/*      */     //   22381: goto_w -> 22394
/*      */     //   22386: aload_3
/*      */     //   22387: iload #5
/*      */     //   22389: dup2
/*      */     //   22390: iaload
/*      */     //   22391: iconst_1
/*      */     //   22392: iadd
/*      */     //   22393: iastore
/*      */     //   22394: iinc #5, 1
/*      */     //   22397: goto_w -> 22260
/*      */     //   22402: iinc #4, 1
/*      */     //   22405: goto_w -> 22243
/*      */     //   22410: iconst_0
/*      */     //   22411: istore #4
/*      */     //   22413: iload #4
/*      */     //   22415: iload_1
/*      */     //   22416: if_icmplt -> 22424
/*      */     //   22419: goto_w -> 22542
/*      */     //   22424: iconst_0
/*      */     //   22425: istore #5
/*      */     //   22427: iload #5
/*      */     //   22429: iload_1
/*      */     //   22430: if_icmplt -> 22438
/*      */     //   22433: goto_w -> 22534
/*      */     //   22438: aload_3
/*      */     //   22439: iload #5
/*      */     //   22441: iaload
/*      */     //   22442: iload #4
/*      */     //   22444: if_icmpeq -> 22452
/*      */     //   22447: goto_w -> 22526
/*      */     //   22452: aload_2
/*      */     //   22453: iload #5
/*      */     //   22455: iaload
/*      */     //   22456: aload_0
/*      */     //   22457: getfield hi : I
/*      */     //   22460: if_icmpeq -> 22468
/*      */     //   22463: goto_w -> 22481
/*      */     //   22468: aload_0
/*      */     //   22469: getfield m : LMedium;
/*      */     //   22472: iconst_3
/*      */     //   22473: putfield trk : I
/*      */     //   22476: goto_w -> 22481
/*      */     //   22481: aload_0
/*      */     //   22482: getfield co : [LContO;
/*      */     //   22485: aload_2
/*      */     //   22486: iload #5
/*      */     //   22488: iaload
/*      */     //   22489: aaload
/*      */     //   22490: aload_0
/*      */     //   22491: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   22494: invokevirtual d : (Ljava/awt/Graphics2D;)V
/*      */     //   22497: aload_0
/*      */     //   22498: getfield m : LMedium;
/*      */     //   22501: getfield trk : I
/*      */     //   22504: iconst_3
/*      */     //   22505: if_icmpeq -> 22513
/*      */     //   22508: goto_w -> 22526
/*      */     //   22513: aload_0
/*      */     //   22514: getfield m : LMedium;
/*      */     //   22517: iconst_2
/*      */     //   22518: putfield trk : I
/*      */     //   22521: goto_w -> 22526
/*      */     //   22526: iinc #5, 1
/*      */     //   22529: goto_w -> 22427
/*      */     //   22534: iinc #4, 1
/*      */     //   22537: goto_w -> 22413
/*      */     //   22542: aload_0
/*      */     //   22543: getfield up : Z
/*      */     //   22546: ifne -> 22554
/*      */     //   22549: goto_w -> 22617
/*      */     //   22554: aload_0
/*      */     //   22555: dup
/*      */     //   22556: getfield vz : I
/*      */     //   22559: i2f
/*      */     //   22560: ldc_w 500.0
/*      */     //   22563: aload_0
/*      */     //   22564: getfield m : LMedium;
/*      */     //   22567: aload_0
/*      */     //   22568: getfield m : LMedium;
/*      */     //   22571: getfield xz : I
/*      */     //   22574: invokevirtual cos : (I)F
/*      */     //   22577: fmul
/*      */     //   22578: fadd
/*      */     //   22579: f2i
/*      */     //   22580: putfield vz : I
/*      */     //   22583: aload_0
/*      */     //   22584: dup
/*      */     //   22585: getfield vx : I
/*      */     //   22588: i2f
/*      */     //   22589: ldc_w 500.0
/*      */     //   22592: aload_0
/*      */     //   22593: getfield m : LMedium;
/*      */     //   22596: aload_0
/*      */     //   22597: getfield m : LMedium;
/*      */     //   22600: getfield xz : I
/*      */     //   22603: invokevirtual sin : (I)F
/*      */     //   22606: fmul
/*      */     //   22607: fadd
/*      */     //   22608: f2i
/*      */     //   22609: putfield vx : I
/*      */     //   22612: goto_w -> 22617
/*      */     //   22617: aload_0
/*      */     //   22618: getfield down : Z
/*      */     //   22621: ifne -> 22629
/*      */     //   22624: goto_w -> 22692
/*      */     //   22629: aload_0
/*      */     //   22630: dup
/*      */     //   22631: getfield vz : I
/*      */     //   22634: i2f
/*      */     //   22635: ldc_w 500.0
/*      */     //   22638: aload_0
/*      */     //   22639: getfield m : LMedium;
/*      */     //   22642: aload_0
/*      */     //   22643: getfield m : LMedium;
/*      */     //   22646: getfield xz : I
/*      */     //   22649: invokevirtual cos : (I)F
/*      */     //   22652: fmul
/*      */     //   22653: fsub
/*      */     //   22654: f2i
/*      */     //   22655: putfield vz : I
/*      */     //   22658: aload_0
/*      */     //   22659: dup
/*      */     //   22660: getfield vx : I
/*      */     //   22663: i2f
/*      */     //   22664: ldc_w 500.0
/*      */     //   22667: aload_0
/*      */     //   22668: getfield m : LMedium;
/*      */     //   22671: aload_0
/*      */     //   22672: getfield m : LMedium;
/*      */     //   22675: getfield xz : I
/*      */     //   22678: invokevirtual sin : (I)F
/*      */     //   22681: fmul
/*      */     //   22682: fsub
/*      */     //   22683: f2i
/*      */     //   22684: putfield vx : I
/*      */     //   22687: goto_w -> 22692
/*      */     //   22692: aload_0
/*      */     //   22693: getfield left : Z
/*      */     //   22696: ifne -> 22704
/*      */     //   22699: goto_w -> 22719
/*      */     //   22704: aload_0
/*      */     //   22705: dup
/*      */     //   22706: getfield vxz : I
/*      */     //   22709: iconst_5
/*      */     //   22710: isub
/*      */     //   22711: putfield vxz : I
/*      */     //   22714: goto_w -> 22719
/*      */     //   22719: aload_0
/*      */     //   22720: getfield right : Z
/*      */     //   22723: ifne -> 22731
/*      */     //   22726: goto_w -> 22746
/*      */     //   22731: aload_0
/*      */     //   22732: dup
/*      */     //   22733: getfield vxz : I
/*      */     //   22736: iconst_5
/*      */     //   22737: iadd
/*      */     //   22738: putfield vxz : I
/*      */     //   22741: goto_w -> 22746
/*      */     //   22746: aload_0
/*      */     //   22747: getfield zoomi : Z
/*      */     //   22750: ifne -> 22758
/*      */     //   22753: goto_w -> 22796
/*      */     //   22758: aload_0
/*      */     //   22759: dup
/*      */     //   22760: getfield vy : I
/*      */     //   22763: bipush #100
/*      */     //   22765: iadd
/*      */     //   22766: putfield vy : I
/*      */     //   22769: aload_0
/*      */     //   22770: getfield vy : I
/*      */     //   22773: sipush #-500
/*      */     //   22776: if_icmpgt -> 22784
/*      */     //   22779: goto_w -> 22796
/*      */     //   22784: aload_0
/*      */     //   22785: sipush #-500
/*      */     //   22788: putfield vy : I
/*      */     //   22791: goto_w -> 22796
/*      */     //   22796: aload_0
/*      */     //   22797: getfield zoomo : Z
/*      */     //   22800: ifne -> 22808
/*      */     //   22803: goto_w -> 22846
/*      */     //   22808: aload_0
/*      */     //   22809: dup
/*      */     //   22810: getfield vy : I
/*      */     //   22813: bipush #100
/*      */     //   22815: isub
/*      */     //   22816: putfield vy : I
/*      */     //   22819: aload_0
/*      */     //   22820: getfield vy : I
/*      */     //   22823: sipush #-5000
/*      */     //   22826: if_icmplt -> 22834
/*      */     //   22829: goto_w -> 22846
/*      */     //   22834: aload_0
/*      */     //   22835: sipush #-5000
/*      */     //   22838: putfield vy : I
/*      */     //   22841: goto_w -> 22846
/*      */     //   22846: aload_0
/*      */     //   22847: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   22850: new java/awt/Color
/*      */     //   22853: dup
/*      */     //   22854: sipush #225
/*      */     //   22857: sipush #225
/*      */     //   22860: sipush #225
/*      */     //   22863: invokespecial <init> : (III)V
/*      */     //   22866: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   22869: aload_0
/*      */     //   22870: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   22873: iconst_0
/*      */     //   22874: bipush #25
/*      */     //   22876: bipush #10
/*      */     //   22878: sipush #525
/*      */     //   22881: invokevirtual fillRect : (IIII)V
/*      */     //   22884: aload_0
/*      */     //   22885: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   22888: sipush #790
/*      */     //   22891: bipush #25
/*      */     //   22893: bipush #10
/*      */     //   22895: sipush #525
/*      */     //   22898: invokevirtual fillRect : (IIII)V
/*      */     //   22901: aload_0
/*      */     //   22902: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   22905: bipush #10
/*      */     //   22907: bipush #25
/*      */     //   22909: sipush #780
/*      */     //   22912: bipush #10
/*      */     //   22914: invokevirtual fillRect : (IIII)V
/*      */     //   22917: aload_0
/*      */     //   22918: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   22921: bipush #10
/*      */     //   22923: sipush #445
/*      */     //   22926: sipush #780
/*      */     //   22929: bipush #105
/*      */     //   22931: invokevirtual fillRect : (IIII)V
/*      */     //   22934: aload_0
/*      */     //   22935: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   22938: new java/awt/Font
/*      */     //   22941: dup
/*      */     //   22942: ldc_w 'Arial'
/*      */     //   22945: iconst_1
/*      */     //   22946: bipush #12
/*      */     //   22948: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   22951: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   22954: aload_0
/*      */     //   22955: aload_0
/*      */     //   22956: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   22959: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   22962: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   22965: bipush #7
/*      */     //   22967: anewarray java/lang/String
/*      */     //   22970: dup
/*      */     //   22971: iconst_0
/*      */     //   22972: ldc_w 'Controls'
/*      */     //   22975: aastore
/*      */     //   22976: dup
/*      */     //   22977: iconst_1
/*      */     //   22978: ldc_w 'Atmosphere'
/*      */     //   22981: aastore
/*      */     //   22982: dup
/*      */     //   22983: iconst_2
/*      */     //   22984: ldc_w 'Colors'
/*      */     //   22987: aastore
/*      */     //   22988: dup
/*      */     //   22989: iconst_3
/*      */     //   22990: ldc_w 'Scenery'
/*      */     //   22993: aastore
/*      */     //   22994: dup
/*      */     //   22995: iconst_4
/*      */     //   22996: ldc_w 'Laps'
/*      */     //   22999: aastore
/*      */     //   23000: dup
/*      */     //   23001: iconst_5
/*      */     //   23002: ldc_w 'Sound Track'
/*      */     //   23005: aastore
/*      */     //   23006: dup
/*      */     //   23007: bipush #6
/*      */     //   23009: ldc_w 'Test Drive'
/*      */     //   23012: aastore
/*      */     //   23013: astore #4
/*      */     //   23015: iconst_4
/*      */     //   23016: newarray int
/*      */     //   23018: dup
/*      */     //   23019: iconst_0
/*      */     //   23020: bipush #10
/*      */     //   23022: iastore
/*      */     //   23023: dup
/*      */     //   23024: iconst_1
/*      */     //   23025: bipush #10
/*      */     //   23027: iastore
/*      */     //   23028: dup
/*      */     //   23029: iconst_2
/*      */     //   23030: bipush #121
/*      */     //   23032: iastore
/*      */     //   23033: dup
/*      */     //   23034: iconst_3
/*      */     //   23035: bipush #111
/*      */     //   23037: iastore
/*      */     //   23038: astore #5
/*      */     //   23040: iconst_4
/*      */     //   23041: newarray int
/*      */     //   23043: dup
/*      */     //   23044: iconst_0
/*      */     //   23045: sipush #425
/*      */     //   23048: iastore
/*      */     //   23049: dup
/*      */     //   23050: iconst_1
/*      */     //   23051: sipush #445
/*      */     //   23054: iastore
/*      */     //   23055: dup
/*      */     //   23056: iconst_2
/*      */     //   23057: sipush #445
/*      */     //   23060: iastore
/*      */     //   23061: dup
/*      */     //   23062: iconst_3
/*      */     //   23063: sipush #425
/*      */     //   23066: iastore
/*      */     //   23067: astore #6
/*      */     //   23069: iconst_0
/*      */     //   23070: istore #7
/*      */     //   23072: iload #7
/*      */     //   23074: bipush #7
/*      */     //   23076: if_icmplt -> 23084
/*      */     //   23079: goto_w -> 23445
/*      */     //   23084: aload_0
/*      */     //   23085: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   23088: new java/awt/Color
/*      */     //   23091: dup
/*      */     //   23092: sipush #170
/*      */     //   23095: sipush #170
/*      */     //   23098: sipush #170
/*      */     //   23101: invokespecial <init> : (III)V
/*      */     //   23104: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   23107: aload_0
/*      */     //   23108: getfield xm : I
/*      */     //   23111: aload #5
/*      */     //   23113: iconst_0
/*      */     //   23114: iaload
/*      */     //   23115: if_icmpgt -> 23123
/*      */     //   23118: goto_w -> 23197
/*      */     //   23123: aload_0
/*      */     //   23124: getfield xm : I
/*      */     //   23127: aload #5
/*      */     //   23129: iconst_3
/*      */     //   23130: iaload
/*      */     //   23131: if_icmplt -> 23139
/*      */     //   23134: goto_w -> 23197
/*      */     //   23139: aload_0
/*      */     //   23140: getfield ym : I
/*      */     //   23143: sipush #425
/*      */     //   23146: if_icmpgt -> 23154
/*      */     //   23149: goto_w -> 23197
/*      */     //   23154: aload_0
/*      */     //   23155: getfield ym : I
/*      */     //   23158: sipush #445
/*      */     //   23161: if_icmplt -> 23169
/*      */     //   23164: goto_w -> 23197
/*      */     //   23169: aload_0
/*      */     //   23170: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   23173: new java/awt/Color
/*      */     //   23176: dup
/*      */     //   23177: sipush #190
/*      */     //   23180: sipush #190
/*      */     //   23183: sipush #190
/*      */     //   23186: invokespecial <init> : (III)V
/*      */     //   23189: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   23192: goto_w -> 23197
/*      */     //   23197: aload_0
/*      */     //   23198: getfield dtab : I
/*      */     //   23201: iload #7
/*      */     //   23203: if_icmpeq -> 23211
/*      */     //   23206: goto_w -> 23239
/*      */     //   23211: aload_0
/*      */     //   23212: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   23215: new java/awt/Color
/*      */     //   23218: dup
/*      */     //   23219: sipush #225
/*      */     //   23222: sipush #225
/*      */     //   23225: sipush #225
/*      */     //   23228: invokespecial <init> : (III)V
/*      */     //   23231: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   23234: goto_w -> 23239
/*      */     //   23239: aload_0
/*      */     //   23240: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   23243: aload #5
/*      */     //   23245: aload #6
/*      */     //   23247: iconst_4
/*      */     //   23248: invokevirtual fillPolygon : ([I[II)V
/*      */     //   23251: aload_0
/*      */     //   23252: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   23255: new java/awt/Color
/*      */     //   23258: dup
/*      */     //   23259: iconst_0
/*      */     //   23260: iconst_0
/*      */     //   23261: iconst_0
/*      */     //   23262: invokespecial <init> : (III)V
/*      */     //   23265: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   23268: aload_0
/*      */     //   23269: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   23272: aload #4
/*      */     //   23274: iload #7
/*      */     //   23276: aaload
/*      */     //   23277: iload #7
/*      */     //   23279: bipush #111
/*      */     //   23281: imul
/*      */     //   23282: bipush #62
/*      */     //   23284: iadd
/*      */     //   23285: aload_0
/*      */     //   23286: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   23289: aload #4
/*      */     //   23291: iload #7
/*      */     //   23293: aaload
/*      */     //   23294: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   23297: iconst_2
/*      */     //   23298: idiv
/*      */     //   23299: isub
/*      */     //   23300: sipush #439
/*      */     //   23303: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   23306: aload_0
/*      */     //   23307: getfield xm : I
/*      */     //   23310: aload #5
/*      */     //   23312: iconst_0
/*      */     //   23313: iaload
/*      */     //   23314: if_icmpgt -> 23322
/*      */     //   23317: goto_w -> 23405
/*      */     //   23322: aload_0
/*      */     //   23323: getfield xm : I
/*      */     //   23326: aload #5
/*      */     //   23328: iconst_3
/*      */     //   23329: iaload
/*      */     //   23330: if_icmplt -> 23338
/*      */     //   23333: goto_w -> 23405
/*      */     //   23338: aload_0
/*      */     //   23339: getfield ym : I
/*      */     //   23342: sipush #425
/*      */     //   23345: if_icmpgt -> 23353
/*      */     //   23348: goto_w -> 23405
/*      */     //   23353: aload_0
/*      */     //   23354: getfield ym : I
/*      */     //   23357: sipush #445
/*      */     //   23360: if_icmplt -> 23368
/*      */     //   23363: goto_w -> 23405
/*      */     //   23368: aload_0
/*      */     //   23369: getfield mouses : I
/*      */     //   23372: iconst_m1
/*      */     //   23373: if_icmpeq -> 23381
/*      */     //   23376: goto_w -> 23405
/*      */     //   23381: aload_0
/*      */     //   23382: getfield mouseon : I
/*      */     //   23385: iconst_m1
/*      */     //   23386: if_icmpeq -> 23394
/*      */     //   23389: goto_w -> 23405
/*      */     //   23394: aload_0
/*      */     //   23395: iload #7
/*      */     //   23397: putfield dtab : I
/*      */     //   23400: goto_w -> 23405
/*      */     //   23405: iconst_0
/*      */     //   23406: istore #8
/*      */     //   23408: iload #8
/*      */     //   23410: iconst_4
/*      */     //   23411: if_icmplt -> 23419
/*      */     //   23414: goto_w -> 23437
/*      */     //   23419: aload #5
/*      */     //   23421: iload #8
/*      */     //   23423: dup2
/*      */     //   23424: iaload
/*      */     //   23425: bipush #111
/*      */     //   23427: iadd
/*      */     //   23428: iastore
/*      */     //   23429: iinc #8, 1
/*      */     //   23432: goto_w -> 23408
/*      */     //   23437: iinc #7, 1
/*      */     //   23440: goto_w -> 23072
/*      */     //   23445: aload_0
/*      */     //   23446: getfield tabed : I
/*      */     //   23449: aload_0
/*      */     //   23450: getfield tab : I
/*      */     //   23453: if_icmpeq -> 23461
/*      */     //   23456: goto_w -> 23527
/*      */     //   23461: aload_0
/*      */     //   23462: getfield dtab : I
/*      */     //   23465: aload_0
/*      */     //   23466: getfield dtabed : I
/*      */     //   23469: if_icmpne -> 23477
/*      */     //   23472: goto_w -> 23527
/*      */     //   23477: aload_0
/*      */     //   23478: getfield ttstage : Ljava/lang/String;
/*      */     //   23481: ldc ''
/*      */     //   23483: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   23486: ifeq -> 23494
/*      */     //   23489: goto_w -> 23513
/*      */     //   23494: aload_0
/*      */     //   23495: aload_0
/*      */     //   23496: getfield ttstage : Ljava/lang/String;
/*      */     //   23499: putfield tstage : Ljava/lang/String;
/*      */     //   23502: aload_0
/*      */     //   23503: ldc ''
/*      */     //   23505: putfield ttstage : Ljava/lang/String;
/*      */     //   23508: goto_w -> 23513
/*      */     //   23513: aload_0
/*      */     //   23514: iconst_1
/*      */     //   23515: invokevirtual readstage : (I)V
/*      */     //   23518: aload_0
/*      */     //   23519: invokevirtual hidefields : ()V
/*      */     //   23522: goto_w -> 23527
/*      */     //   23527: aload_0
/*      */     //   23528: getfield dtab : I
/*      */     //   23531: ifeq -> 23539
/*      */     //   23534: goto_w -> 23606
/*      */     //   23539: aload_0
/*      */     //   23540: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   23543: new java/awt/Color
/*      */     //   23546: dup
/*      */     //   23547: iconst_0
/*      */     //   23548: iconst_0
/*      */     //   23549: iconst_0
/*      */     //   23550: invokespecial <init> : (III)V
/*      */     //   23553: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   23556: aload_0
/*      */     //   23557: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   23560: ldc_w 'Use the [ Keyboard Arrows ] to navigate through the stage.'
/*      */     //   23563: bipush #20
/*      */     //   23565: sipush #470
/*      */     //   23568: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   23571: aload_0
/*      */     //   23572: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   23575: ldc_w '[Left] & [Right] arrows are for rotating.  [Up] & [Down] arrows are for moving forwards and backwards.'
/*      */     //   23578: bipush #20
/*      */     //   23580: sipush #490
/*      */     //   23583: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   23586: aload_0
/*      */     //   23587: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   23590: ldc_w 'For moving vertically down and up use the following keys:  [+] & [-]  or  [8] & [2]  or  [Enter] & [Backspace]'
/*      */     //   23593: bipush #20
/*      */     //   23595: sipush #520
/*      */     //   23598: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   23601: goto_w -> 23606
/*      */     //   23606: aload_0
/*      */     //   23607: getfield dtab : I
/*      */     //   23610: iconst_2
/*      */     //   23611: if_icmpeq -> 23619
/*      */     //   23614: goto_w -> 25862
/*      */     //   23619: aload_0
/*      */     //   23620: getfield dtabed : I
/*      */     //   23623: aload_0
/*      */     //   23624: getfield dtab : I
/*      */     //   23627: if_icmpne -> 23635
/*      */     //   23630: goto_w -> 23904
/*      */     //   23635: aload_0
/*      */     //   23636: getfield csky : [I
/*      */     //   23639: iconst_0
/*      */     //   23640: iaload
/*      */     //   23641: aload_0
/*      */     //   23642: getfield csky : [I
/*      */     //   23645: iconst_1
/*      */     //   23646: iaload
/*      */     //   23647: aload_0
/*      */     //   23648: getfield csky : [I
/*      */     //   23651: iconst_2
/*      */     //   23652: iaload
/*      */     //   23653: aload_0
/*      */     //   23654: getfield hsb : [[F
/*      */     //   23657: iconst_0
/*      */     //   23658: aaload
/*      */     //   23659: invokestatic RGBtoHSB : (III[F)[F
/*      */     //   23662: pop
/*      */     //   23663: aload_0
/*      */     //   23664: getfield cfade : [I
/*      */     //   23667: iconst_0
/*      */     //   23668: iaload
/*      */     //   23669: aload_0
/*      */     //   23670: getfield cfade : [I
/*      */     //   23673: iconst_1
/*      */     //   23674: iaload
/*      */     //   23675: aload_0
/*      */     //   23676: getfield cfade : [I
/*      */     //   23679: iconst_2
/*      */     //   23680: iaload
/*      */     //   23681: aload_0
/*      */     //   23682: getfield hsb : [[F
/*      */     //   23685: iconst_1
/*      */     //   23686: aaload
/*      */     //   23687: invokestatic RGBtoHSB : (III[F)[F
/*      */     //   23690: pop
/*      */     //   23691: aload_0
/*      */     //   23692: getfield cgrnd : [I
/*      */     //   23695: iconst_0
/*      */     //   23696: iaload
/*      */     //   23697: aload_0
/*      */     //   23698: getfield cgrnd : [I
/*      */     //   23701: iconst_1
/*      */     //   23702: iaload
/*      */     //   23703: aload_0
/*      */     //   23704: getfield cgrnd : [I
/*      */     //   23707: iconst_2
/*      */     //   23708: iaload
/*      */     //   23709: aload_0
/*      */     //   23710: getfield hsb : [[F
/*      */     //   23713: iconst_2
/*      */     //   23714: aaload
/*      */     //   23715: invokestatic RGBtoHSB : (III[F)[F
/*      */     //   23718: pop
/*      */     //   23719: iconst_0
/*      */     //   23720: istore #7
/*      */     //   23722: iload #7
/*      */     //   23724: iconst_3
/*      */     //   23725: if_icmplt -> 23733
/*      */     //   23728: goto_w -> 23781
/*      */     //   23733: aload_0
/*      */     //   23734: getfield hsb : [[F
/*      */     //   23737: iload #7
/*      */     //   23739: aaload
/*      */     //   23740: iconst_1
/*      */     //   23741: faload
/*      */     //   23742: fstore #8
/*      */     //   23744: aload_0
/*      */     //   23745: getfield hsb : [[F
/*      */     //   23748: iload #7
/*      */     //   23750: aaload
/*      */     //   23751: iconst_1
/*      */     //   23752: aload_0
/*      */     //   23753: getfield hsb : [[F
/*      */     //   23756: iload #7
/*      */     //   23758: aaload
/*      */     //   23759: iconst_2
/*      */     //   23760: faload
/*      */     //   23761: fastore
/*      */     //   23762: aload_0
/*      */     //   23763: getfield hsb : [[F
/*      */     //   23766: iload #7
/*      */     //   23768: aaload
/*      */     //   23769: iconst_2
/*      */     //   23770: fload #8
/*      */     //   23772: fastore
/*      */     //   23773: iinc #7, 1
/*      */     //   23776: goto_w -> 23722
/*      */     //   23781: aload_0
/*      */     //   23782: getfield hsb : [[F
/*      */     //   23785: iconst_1
/*      */     //   23786: aaload
/*      */     //   23787: iconst_1
/*      */     //   23788: faload
/*      */     //   23789: aload_0
/*      */     //   23790: getfield hsb : [[F
/*      */     //   23793: iconst_0
/*      */     //   23794: aaload
/*      */     //   23795: iconst_1
/*      */     //   23796: faload
/*      */     //   23797: aload_0
/*      */     //   23798: getfield hsb : [[F
/*      */     //   23801: iconst_2
/*      */     //   23802: aaload
/*      */     //   23803: iconst_1
/*      */     //   23804: faload
/*      */     //   23805: fadd
/*      */     //   23806: fconst_2
/*      */     //   23807: fdiv
/*      */     //   23808: fcmpl
/*      */     //   23809: ifeq -> 23817
/*      */     //   23812: goto_w -> 23880
/*      */     //   23817: aload_0
/*      */     //   23818: getfield hsb : [[F
/*      */     //   23821: iconst_1
/*      */     //   23822: aaload
/*      */     //   23823: iconst_0
/*      */     //   23824: faload
/*      */     //   23825: aload_0
/*      */     //   23826: getfield hsb : [[F
/*      */     //   23829: iconst_2
/*      */     //   23830: aaload
/*      */     //   23831: iconst_0
/*      */     //   23832: faload
/*      */     //   23833: fcmpl
/*      */     //   23834: ifeq -> 23842
/*      */     //   23837: goto_w -> 23880
/*      */     //   23842: aload_0
/*      */     //   23843: getfield hsb : [[F
/*      */     //   23846: iconst_1
/*      */     //   23847: aaload
/*      */     //   23848: iconst_2
/*      */     //   23849: faload
/*      */     //   23850: aload_0
/*      */     //   23851: getfield hsb : [[F
/*      */     //   23854: iconst_2
/*      */     //   23855: aaload
/*      */     //   23856: iconst_2
/*      */     //   23857: faload
/*      */     //   23858: fcmpl
/*      */     //   23859: ifeq -> 23867
/*      */     //   23862: goto_w -> 23880
/*      */     //   23867: aload_0
/*      */     //   23868: getfield pfog : Ljava/awt/Checkbox;
/*      */     //   23871: iconst_1
/*      */     //   23872: invokevirtual setState : (Z)V
/*      */     //   23875: goto_w -> 23888
/*      */     //   23880: aload_0
/*      */     //   23881: getfield pfog : Ljava/awt/Checkbox;
/*      */     //   23884: iconst_0
/*      */     //   23885: invokevirtual setState : (Z)V
/*      */     //   23888: aload_0
/*      */     //   23889: ldc ''
/*      */     //   23891: putfield ttstage : Ljava/lang/String;
/*      */     //   23894: aload_0
/*      */     //   23895: iconst_m1
/*      */     //   23896: putfield mouseon : I
/*      */     //   23899: goto_w -> 23904
/*      */     //   23904: aload_0
/*      */     //   23905: getfield mouses : I
/*      */     //   23908: iconst_1
/*      */     //   23909: if_icmpne -> 23917
/*      */     //   23912: goto_w -> 24011
/*      */     //   23917: aload_0
/*      */     //   23918: getfield mouseon : I
/*      */     //   23921: bipush #6
/*      */     //   23923: if_icmplt -> 23931
/*      */     //   23926: goto_w -> 23944
/*      */     //   23931: aload_0
/*      */     //   23932: getfield mouseon : I
/*      */     //   23935: iconst_3
/*      */     //   23936: if_icmplt -> 23944
/*      */     //   23939: goto_w -> 24001
/*      */     //   23944: aload_0
/*      */     //   23945: getfield mouseon : I
/*      */     //   23948: iconst_m1
/*      */     //   23949: if_icmpne -> 23957
/*      */     //   23952: goto_w -> 24001
/*      */     //   23957: aload_0
/*      */     //   23958: getfield ttstage : Ljava/lang/String;
/*      */     //   23961: ldc ''
/*      */     //   23963: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   23966: ifne -> 23974
/*      */     //   23969: goto_w -> 23987
/*      */     //   23974: aload_0
/*      */     //   23975: aload_0
/*      */     //   23976: getfield tstage : Ljava/lang/String;
/*      */     //   23979: putfield ttstage : Ljava/lang/String;
/*      */     //   23982: goto_w -> 23987
/*      */     //   23987: aload_0
/*      */     //   23988: invokevirtual sortop : ()V
/*      */     //   23991: aload_0
/*      */     //   23992: iconst_1
/*      */     //   23993: invokevirtual readstage : (I)V
/*      */     //   23996: goto_w -> 24001
/*      */     //   24001: aload_0
/*      */     //   24002: iconst_m1
/*      */     //   24003: putfield mouseon : I
/*      */     //   24006: goto_w -> 24011
/*      */     //   24011: iconst_3
/*      */     //   24012: anewarray java/lang/String
/*      */     //   24015: dup
/*      */     //   24016: iconst_0
/*      */     //   24017: ldc_w 'Sky'
/*      */     //   24020: aastore
/*      */     //   24021: dup
/*      */     //   24022: iconst_1
/*      */     //   24023: ldc_w 'Dust / Fog'
/*      */     //   24026: aastore
/*      */     //   24027: dup
/*      */     //   24028: iconst_2
/*      */     //   24029: ldc_w 'Ground'
/*      */     //   24032: aastore
/*      */     //   24033: astore #7
/*      */     //   24035: iconst_0
/*      */     //   24036: istore #8
/*      */     //   24038: iload #8
/*      */     //   24040: iconst_3
/*      */     //   24041: if_icmplt -> 24049
/*      */     //   24044: goto_w -> 25302
/*      */     //   24049: aload_0
/*      */     //   24050: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   24053: new java/awt/Color
/*      */     //   24056: dup
/*      */     //   24057: iconst_0
/*      */     //   24058: iconst_0
/*      */     //   24059: iconst_0
/*      */     //   24060: invokespecial <init> : (III)V
/*      */     //   24063: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   24066: aload_0
/*      */     //   24067: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   24070: aload #7
/*      */     //   24072: iload #8
/*      */     //   24074: aaload
/*      */     //   24075: bipush #107
/*      */     //   24077: sipush #195
/*      */     //   24080: iload #8
/*      */     //   24082: imul
/*      */     //   24083: iadd
/*      */     //   24084: aload_0
/*      */     //   24085: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   24088: aload #7
/*      */     //   24090: iload #8
/*      */     //   24092: aaload
/*      */     //   24093: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   24096: iconst_2
/*      */     //   24097: idiv
/*      */     //   24098: isub
/*      */     //   24099: sipush #461
/*      */     //   24102: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   24105: iconst_0
/*      */     //   24106: istore #9
/*      */     //   24108: iload #9
/*      */     //   24110: sipush #150
/*      */     //   24113: if_icmplt -> 24121
/*      */     //   24116: goto_w -> 24187
/*      */     //   24121: aload_0
/*      */     //   24122: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   24125: iload #9
/*      */     //   24127: i2f
/*      */     //   24128: f2d
/*      */     //   24129: ldc2_w 0.006667
/*      */     //   24132: dmul
/*      */     //   24133: d2f
/*      */     //   24134: fconst_1
/*      */     //   24135: fconst_1
/*      */     //   24136: invokestatic getHSBColor : (FFF)Ljava/awt/Color;
/*      */     //   24139: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   24142: aload_0
/*      */     //   24143: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   24146: bipush #32
/*      */     //   24148: iload #9
/*      */     //   24150: iadd
/*      */     //   24151: sipush #195
/*      */     //   24154: iload #8
/*      */     //   24156: imul
/*      */     //   24157: iadd
/*      */     //   24158: sipush #467
/*      */     //   24161: bipush #32
/*      */     //   24163: iload #9
/*      */     //   24165: iadd
/*      */     //   24166: sipush #195
/*      */     //   24169: iload #8
/*      */     //   24171: imul
/*      */     //   24172: iadd
/*      */     //   24173: sipush #474
/*      */     //   24176: invokevirtual drawLine : (IIII)V
/*      */     //   24179: iinc #9, 1
/*      */     //   24182: goto_w -> 24108
/*      */     //   24187: iconst_0
/*      */     //   24188: istore #9
/*      */     //   24190: iload #9
/*      */     //   24192: sipush #150
/*      */     //   24195: if_icmplt -> 24203
/*      */     //   24198: goto_w -> 24270
/*      */     //   24203: aload_0
/*      */     //   24204: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   24207: fconst_0
/*      */     //   24208: fconst_0
/*      */     //   24209: ldc 0.5
/*      */     //   24211: iload #9
/*      */     //   24213: i2f
/*      */     //   24214: ldc_w 0.00333
/*      */     //   24217: fmul
/*      */     //   24218: fadd
/*      */     //   24219: invokestatic getHSBColor : (FFF)Ljava/awt/Color;
/*      */     //   24222: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   24225: aload_0
/*      */     //   24226: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   24229: bipush #32
/*      */     //   24231: iload #9
/*      */     //   24233: iadd
/*      */     //   24234: sipush #195
/*      */     //   24237: iload #8
/*      */     //   24239: imul
/*      */     //   24240: iadd
/*      */     //   24241: sipush #483
/*      */     //   24244: bipush #32
/*      */     //   24246: iload #9
/*      */     //   24248: iadd
/*      */     //   24249: sipush #195
/*      */     //   24252: iload #8
/*      */     //   24254: imul
/*      */     //   24255: iadd
/*      */     //   24256: sipush #490
/*      */     //   24259: invokevirtual drawLine : (IIII)V
/*      */     //   24262: iinc #9, 1
/*      */     //   24265: goto_w -> 24190
/*      */     //   24270: iconst_0
/*      */     //   24271: istore #9
/*      */     //   24273: iload #9
/*      */     //   24275: sipush #150
/*      */     //   24278: if_icmplt -> 24286
/*      */     //   24281: goto_w -> 24370
/*      */     //   24286: aload_0
/*      */     //   24287: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   24290: aload_0
/*      */     //   24291: getfield hsb : [[F
/*      */     //   24294: iload #8
/*      */     //   24296: aaload
/*      */     //   24297: iconst_0
/*      */     //   24298: faload
/*      */     //   24299: fconst_0
/*      */     //   24300: iload #9
/*      */     //   24302: i2f
/*      */     //   24303: f2d
/*      */     //   24304: ldc2_w 0.001667
/*      */     //   24307: dmul
/*      */     //   24308: d2f
/*      */     //   24309: fadd
/*      */     //   24310: aload_0
/*      */     //   24311: getfield hsb : [[F
/*      */     //   24314: iload #8
/*      */     //   24316: aaload
/*      */     //   24317: iconst_1
/*      */     //   24318: faload
/*      */     //   24319: invokestatic getHSBColor : (FFF)Ljava/awt/Color;
/*      */     //   24322: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   24325: aload_0
/*      */     //   24326: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   24329: bipush #32
/*      */     //   24331: iload #9
/*      */     //   24333: iadd
/*      */     //   24334: sipush #195
/*      */     //   24337: iload #8
/*      */     //   24339: imul
/*      */     //   24340: iadd
/*      */     //   24341: sipush #499
/*      */     //   24344: bipush #32
/*      */     //   24346: iload #9
/*      */     //   24348: iadd
/*      */     //   24349: sipush #195
/*      */     //   24352: iload #8
/*      */     //   24354: imul
/*      */     //   24355: iadd
/*      */     //   24356: sipush #506
/*      */     //   24359: invokevirtual drawLine : (IIII)V
/*      */     //   24362: iinc #9, 1
/*      */     //   24365: goto_w -> 24273
/*      */     //   24370: iconst_0
/*      */     //   24371: istore #9
/*      */     //   24373: iload #9
/*      */     //   24375: iconst_3
/*      */     //   24376: if_icmplt -> 24384
/*      */     //   24379: goto_w -> 25294
/*      */     //   24384: aload_0
/*      */     //   24385: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   24388: new java/awt/Color
/*      */     //   24391: dup
/*      */     //   24392: iconst_0
/*      */     //   24393: iconst_0
/*      */     //   24394: iconst_0
/*      */     //   24395: invokespecial <init> : (III)V
/*      */     //   24398: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   24401: aload_0
/*      */     //   24402: getfield hsb : [[F
/*      */     //   24405: iload #8
/*      */     //   24407: aaload
/*      */     //   24408: iload #9
/*      */     //   24410: faload
/*      */     //   24411: ldc_w 150.0
/*      */     //   24414: fmul
/*      */     //   24415: fstore #10
/*      */     //   24417: iload #9
/*      */     //   24419: iconst_1
/*      */     //   24420: if_icmpeq -> 24428
/*      */     //   24423: goto_w -> 24498
/*      */     //   24428: ldc_w 0.75
/*      */     //   24431: fstore #11
/*      */     //   24433: iload #8
/*      */     //   24435: ifeq -> 24443
/*      */     //   24438: goto_w -> 24453
/*      */     //   24443: ldc_w 0.85
/*      */     //   24446: fstore #11
/*      */     //   24448: goto_w -> 24453
/*      */     //   24453: iload #8
/*      */     //   24455: iconst_1
/*      */     //   24456: if_icmpeq -> 24464
/*      */     //   24459: goto_w -> 24474
/*      */     //   24464: ldc_w 0.8
/*      */     //   24467: fstore #11
/*      */     //   24469: goto_w -> 24474
/*      */     //   24474: aload_0
/*      */     //   24475: getfield hsb : [[F
/*      */     //   24478: iload #8
/*      */     //   24480: aaload
/*      */     //   24481: iload #9
/*      */     //   24483: faload
/*      */     //   24484: fload #11
/*      */     //   24486: fsub
/*      */     //   24487: ldc_w 0.001
/*      */     //   24490: fdiv
/*      */     //   24491: fstore #10
/*      */     //   24493: goto_w -> 24498
/*      */     //   24498: iload #9
/*      */     //   24500: iconst_2
/*      */     //   24501: if_icmpeq -> 24509
/*      */     //   24504: goto_w -> 24530
/*      */     //   24509: aload_0
/*      */     //   24510: getfield hsb : [[F
/*      */     //   24513: iload #8
/*      */     //   24515: aaload
/*      */     //   24516: iload #9
/*      */     //   24518: faload
/*      */     //   24519: ldc_w 600.0
/*      */     //   24522: fmul
/*      */     //   24523: fstore #10
/*      */     //   24525: goto_w -> 24530
/*      */     //   24530: fload #10
/*      */     //   24532: fconst_0
/*      */     //   24533: fcmpg
/*      */     //   24534: iflt -> 24542
/*      */     //   24537: goto_w -> 24550
/*      */     //   24542: fconst_0
/*      */     //   24543: fstore #10
/*      */     //   24545: goto_w -> 24550
/*      */     //   24550: fload #10
/*      */     //   24552: ldc_w 150.0
/*      */     //   24555: fcmpl
/*      */     //   24556: ifgt -> 24564
/*      */     //   24559: goto_w -> 24574
/*      */     //   24564: ldc_w 150.0
/*      */     //   24567: fstore #10
/*      */     //   24569: goto_w -> 24574
/*      */     //   24574: aload_0
/*      */     //   24575: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   24578: bipush #32
/*      */     //   24580: sipush #195
/*      */     //   24583: iload #8
/*      */     //   24585: imul
/*      */     //   24586: iadd
/*      */     //   24587: i2f
/*      */     //   24588: fload #10
/*      */     //   24590: fadd
/*      */     //   24591: f2i
/*      */     //   24592: sipush #467
/*      */     //   24595: iload #9
/*      */     //   24597: bipush #16
/*      */     //   24599: imul
/*      */     //   24600: iadd
/*      */     //   24601: bipush #32
/*      */     //   24603: sipush #195
/*      */     //   24606: iload #8
/*      */     //   24608: imul
/*      */     //   24609: iadd
/*      */     //   24610: i2f
/*      */     //   24611: fload #10
/*      */     //   24613: fadd
/*      */     //   24614: f2i
/*      */     //   24615: sipush #474
/*      */     //   24618: iload #9
/*      */     //   24620: bipush #16
/*      */     //   24622: imul
/*      */     //   24623: iadd
/*      */     //   24624: invokevirtual drawLine : (IIII)V
/*      */     //   24627: aload_0
/*      */     //   24628: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   24631: bipush #33
/*      */     //   24633: sipush #195
/*      */     //   24636: iload #8
/*      */     //   24638: imul
/*      */     //   24639: iadd
/*      */     //   24640: i2f
/*      */     //   24641: fload #10
/*      */     //   24643: fadd
/*      */     //   24644: f2i
/*      */     //   24645: sipush #467
/*      */     //   24648: iload #9
/*      */     //   24650: bipush #16
/*      */     //   24652: imul
/*      */     //   24653: iadd
/*      */     //   24654: bipush #33
/*      */     //   24656: sipush #195
/*      */     //   24659: iload #8
/*      */     //   24661: imul
/*      */     //   24662: iadd
/*      */     //   24663: i2f
/*      */     //   24664: fload #10
/*      */     //   24666: fadd
/*      */     //   24667: f2i
/*      */     //   24668: sipush #474
/*      */     //   24671: iload #9
/*      */     //   24673: bipush #16
/*      */     //   24675: imul
/*      */     //   24676: iadd
/*      */     //   24677: invokevirtual drawLine : (IIII)V
/*      */     //   24680: aload_0
/*      */     //   24681: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   24684: bipush #31
/*      */     //   24686: sipush #195
/*      */     //   24689: iload #8
/*      */     //   24691: imul
/*      */     //   24692: iadd
/*      */     //   24693: i2f
/*      */     //   24694: fload #10
/*      */     //   24696: fadd
/*      */     //   24697: f2i
/*      */     //   24698: sipush #475
/*      */     //   24701: iload #9
/*      */     //   24703: bipush #16
/*      */     //   24705: imul
/*      */     //   24706: iadd
/*      */     //   24707: iconst_4
/*      */     //   24708: iconst_2
/*      */     //   24709: invokevirtual fillRect : (IIII)V
/*      */     //   24712: aload_0
/*      */     //   24713: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   24716: bipush #30
/*      */     //   24718: sipush #195
/*      */     //   24721: iload #8
/*      */     //   24723: imul
/*      */     //   24724: iadd
/*      */     //   24725: i2f
/*      */     //   24726: fload #10
/*      */     //   24728: fadd
/*      */     //   24729: f2i
/*      */     //   24730: sipush #477
/*      */     //   24733: iload #9
/*      */     //   24735: bipush #16
/*      */     //   24737: imul
/*      */     //   24738: iadd
/*      */     //   24739: bipush #35
/*      */     //   24741: sipush #195
/*      */     //   24744: iload #8
/*      */     //   24746: imul
/*      */     //   24747: iadd
/*      */     //   24748: i2f
/*      */     //   24749: fload #10
/*      */     //   24751: fadd
/*      */     //   24752: f2i
/*      */     //   24753: sipush #477
/*      */     //   24756: iload #9
/*      */     //   24758: bipush #16
/*      */     //   24760: imul
/*      */     //   24761: iadd
/*      */     //   24762: invokevirtual drawLine : (IIII)V
/*      */     //   24765: aload_0
/*      */     //   24766: getfield xm : I
/*      */     //   24769: bipush #29
/*      */     //   24771: sipush #195
/*      */     //   24774: iload #8
/*      */     //   24776: imul
/*      */     //   24777: iadd
/*      */     //   24778: if_icmpgt -> 24786
/*      */     //   24781: goto_w -> 24892
/*      */     //   24786: aload_0
/*      */     //   24787: getfield xm : I
/*      */     //   24790: sipush #185
/*      */     //   24793: sipush #195
/*      */     //   24796: iload #8
/*      */     //   24798: imul
/*      */     //   24799: iadd
/*      */     //   24800: if_icmplt -> 24808
/*      */     //   24803: goto_w -> 24892
/*      */     //   24808: aload_0
/*      */     //   24809: getfield ym : I
/*      */     //   24812: sipush #468
/*      */     //   24815: iload #9
/*      */     //   24817: bipush #16
/*      */     //   24819: imul
/*      */     //   24820: iadd
/*      */     //   24821: if_icmpgt -> 24829
/*      */     //   24824: goto_w -> 24892
/*      */     //   24829: aload_0
/*      */     //   24830: getfield ym : I
/*      */     //   24833: sipush #477
/*      */     //   24836: iload #9
/*      */     //   24838: bipush #16
/*      */     //   24840: imul
/*      */     //   24841: iadd
/*      */     //   24842: if_icmplt -> 24850
/*      */     //   24845: goto_w -> 24892
/*      */     //   24850: aload_0
/*      */     //   24851: getfield mouses : I
/*      */     //   24854: iconst_1
/*      */     //   24855: if_icmpeq -> 24863
/*      */     //   24858: goto_w -> 24892
/*      */     //   24863: aload_0
/*      */     //   24864: getfield mouseon : I
/*      */     //   24867: iconst_m1
/*      */     //   24868: if_icmpeq -> 24876
/*      */     //   24871: goto_w -> 24892
/*      */     //   24876: aload_0
/*      */     //   24877: iload #9
/*      */     //   24879: iload #8
/*      */     //   24881: iconst_3
/*      */     //   24882: imul
/*      */     //   24883: iadd
/*      */     //   24884: putfield mouseon : I
/*      */     //   24887: goto_w -> 24892
/*      */     //   24892: aload_0
/*      */     //   24893: getfield mouseon : I
/*      */     //   24896: iload #9
/*      */     //   24898: iload #8
/*      */     //   24900: iconst_3
/*      */     //   24901: imul
/*      */     //   24902: iadd
/*      */     //   24903: if_icmpeq -> 24911
/*      */     //   24906: goto_w -> 25286
/*      */     //   24911: iload #9
/*      */     //   24913: ifeq -> 24921
/*      */     //   24916: goto_w -> 24955
/*      */     //   24921: aload_0
/*      */     //   24922: getfield hsb : [[F
/*      */     //   24925: iload #8
/*      */     //   24927: aaload
/*      */     //   24928: iload #9
/*      */     //   24930: aload_0
/*      */     //   24931: getfield xm : I
/*      */     //   24934: bipush #32
/*      */     //   24936: sipush #195
/*      */     //   24939: iload #8
/*      */     //   24941: imul
/*      */     //   24942: iadd
/*      */     //   24943: isub
/*      */     //   24944: i2f
/*      */     //   24945: ldc_w 150.0
/*      */     //   24948: fdiv
/*      */     //   24949: fastore
/*      */     //   24950: goto_w -> 24955
/*      */     //   24955: iload #9
/*      */     //   24957: iconst_1
/*      */     //   24958: if_icmpeq -> 24966
/*      */     //   24961: goto_w -> 25133
/*      */     //   24966: ldc_w 0.75
/*      */     //   24969: fstore #11
/*      */     //   24971: iload #8
/*      */     //   24973: ifeq -> 24981
/*      */     //   24976: goto_w -> 24991
/*      */     //   24981: ldc_w 0.85
/*      */     //   24984: fstore #11
/*      */     //   24986: goto_w -> 24991
/*      */     //   24991: iload #8
/*      */     //   24993: iconst_1
/*      */     //   24994: if_icmpeq -> 25002
/*      */     //   24997: goto_w -> 25012
/*      */     //   25002: ldc_w 0.8
/*      */     //   25005: fstore #11
/*      */     //   25007: goto_w -> 25012
/*      */     //   25012: aload_0
/*      */     //   25013: getfield hsb : [[F
/*      */     //   25016: iload #8
/*      */     //   25018: aaload
/*      */     //   25019: iload #9
/*      */     //   25021: fload #11
/*      */     //   25023: aload_0
/*      */     //   25024: getfield xm : I
/*      */     //   25027: bipush #32
/*      */     //   25029: sipush #195
/*      */     //   25032: iload #8
/*      */     //   25034: imul
/*      */     //   25035: iadd
/*      */     //   25036: isub
/*      */     //   25037: i2f
/*      */     //   25038: ldc_w 0.001
/*      */     //   25041: fmul
/*      */     //   25042: fadd
/*      */     //   25043: fastore
/*      */     //   25044: aload_0
/*      */     //   25045: getfield hsb : [[F
/*      */     //   25048: iload #8
/*      */     //   25050: aaload
/*      */     //   25051: iload #9
/*      */     //   25053: faload
/*      */     //   25054: fload #11
/*      */     //   25056: fcmpg
/*      */     //   25057: iflt -> 25065
/*      */     //   25060: goto_w -> 25082
/*      */     //   25065: aload_0
/*      */     //   25066: getfield hsb : [[F
/*      */     //   25069: iload #8
/*      */     //   25071: aaload
/*      */     //   25072: iload #9
/*      */     //   25074: fload #11
/*      */     //   25076: fastore
/*      */     //   25077: goto_w -> 25082
/*      */     //   25082: aload_0
/*      */     //   25083: getfield hsb : [[F
/*      */     //   25086: iload #8
/*      */     //   25088: aaload
/*      */     //   25089: iload #9
/*      */     //   25091: faload
/*      */     //   25092: fload #11
/*      */     //   25094: ldc_w 0.15
/*      */     //   25097: fadd
/*      */     //   25098: fcmpl
/*      */     //   25099: ifgt -> 25107
/*      */     //   25102: goto_w -> 25128
/*      */     //   25107: aload_0
/*      */     //   25108: getfield hsb : [[F
/*      */     //   25111: iload #8
/*      */     //   25113: aaload
/*      */     //   25114: iload #9
/*      */     //   25116: fload #11
/*      */     //   25118: ldc_w 0.15
/*      */     //   25121: fadd
/*      */     //   25122: fastore
/*      */     //   25123: goto_w -> 25128
/*      */     //   25128: goto_w -> 25133
/*      */     //   25133: iload #9
/*      */     //   25135: iconst_2
/*      */     //   25136: if_icmpeq -> 25144
/*      */     //   25139: goto_w -> 25214
/*      */     //   25144: aload_0
/*      */     //   25145: getfield hsb : [[F
/*      */     //   25148: iload #8
/*      */     //   25150: aaload
/*      */     //   25151: iload #9
/*      */     //   25153: aload_0
/*      */     //   25154: getfield xm : I
/*      */     //   25157: bipush #32
/*      */     //   25159: sipush #195
/*      */     //   25162: iload #8
/*      */     //   25164: imul
/*      */     //   25165: iadd
/*      */     //   25166: isub
/*      */     //   25167: i2f
/*      */     //   25168: ldc_w 600.0
/*      */     //   25171: fdiv
/*      */     //   25172: fastore
/*      */     //   25173: aload_0
/*      */     //   25174: getfield hsb : [[F
/*      */     //   25177: iload #8
/*      */     //   25179: aaload
/*      */     //   25180: iload #9
/*      */     //   25182: faload
/*      */     //   25183: f2d
/*      */     //   25184: ldc2_w 0.25
/*      */     //   25187: dcmpl
/*      */     //   25188: ifgt -> 25196
/*      */     //   25191: goto_w -> 25214
/*      */     //   25196: aload_0
/*      */     //   25197: getfield hsb : [[F
/*      */     //   25200: iload #8
/*      */     //   25202: aaload
/*      */     //   25203: iload #9
/*      */     //   25205: ldc_w 0.25
/*      */     //   25208: fastore
/*      */     //   25209: goto_w -> 25214
/*      */     //   25214: aload_0
/*      */     //   25215: getfield hsb : [[F
/*      */     //   25218: iload #8
/*      */     //   25220: aaload
/*      */     //   25221: iload #9
/*      */     //   25223: faload
/*      */     //   25224: fconst_1
/*      */     //   25225: fcmpl
/*      */     //   25226: ifgt -> 25234
/*      */     //   25229: goto_w -> 25250
/*      */     //   25234: aload_0
/*      */     //   25235: getfield hsb : [[F
/*      */     //   25238: iload #8
/*      */     //   25240: aaload
/*      */     //   25241: iload #9
/*      */     //   25243: fconst_1
/*      */     //   25244: fastore
/*      */     //   25245: goto_w -> 25250
/*      */     //   25250: aload_0
/*      */     //   25251: getfield hsb : [[F
/*      */     //   25254: iload #8
/*      */     //   25256: aaload
/*      */     //   25257: iload #9
/*      */     //   25259: faload
/*      */     //   25260: fconst_0
/*      */     //   25261: fcmpg
/*      */     //   25262: iflt -> 25270
/*      */     //   25265: goto_w -> 25286
/*      */     //   25270: aload_0
/*      */     //   25271: getfield hsb : [[F
/*      */     //   25274: iload #8
/*      */     //   25276: aaload
/*      */     //   25277: iload #9
/*      */     //   25279: fconst_0
/*      */     //   25280: fastore
/*      */     //   25281: goto_w -> 25286
/*      */     //   25286: iinc #9, 1
/*      */     //   25289: goto_w -> 24373
/*      */     //   25294: iinc #8, 1
/*      */     //   25297: goto_w -> 24038
/*      */     //   25302: aload_0
/*      */     //   25303: aload_0
/*      */     //   25304: getfield pfog : Ljava/awt/Checkbox;
/*      */     //   25307: sipush #258
/*      */     //   25310: sipush #511
/*      */     //   25313: sipush #200
/*      */     //   25316: bipush #23
/*      */     //   25318: invokevirtual movefield : (Ljava/awt/Component;IIII)V
/*      */     //   25321: aload_0
/*      */     //   25322: getfield pfog : Ljava/awt/Checkbox;
/*      */     //   25325: invokevirtual isShowing : ()Z
/*      */     //   25328: ifeq -> 25336
/*      */     //   25331: goto_w -> 25348
/*      */     //   25336: aload_0
/*      */     //   25337: getfield pfog : Ljava/awt/Checkbox;
/*      */     //   25340: invokevirtual show : ()V
/*      */     //   25343: goto_w -> 25348
/*      */     //   25348: aload_0
/*      */     //   25349: getfield pfog : Ljava/awt/Checkbox;
/*      */     //   25352: invokevirtual getState : ()Z
/*      */     //   25355: ifne -> 25363
/*      */     //   25358: goto_w -> 25488
/*      */     //   25363: aload_0
/*      */     //   25364: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   25367: iconst_3
/*      */     //   25368: ldc_w 0.25
/*      */     //   25371: invokestatic getInstance : (IF)Ljava/awt/AlphaComposite;
/*      */     //   25374: invokevirtual setComposite : (Ljava/awt/Composite;)V
/*      */     //   25377: aload_0
/*      */     //   25378: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   25381: new java/awt/Color
/*      */     //   25384: dup
/*      */     //   25385: iconst_0
/*      */     //   25386: iconst_0
/*      */     //   25387: iconst_0
/*      */     //   25388: invokespecial <init> : (III)V
/*      */     //   25391: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   25394: aload_0
/*      */     //   25395: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   25398: sipush #215
/*      */     //   25401: sipush #464
/*      */     //   25404: sipush #175
/*      */     //   25407: bipush #47
/*      */     //   25409: invokevirtual fillRect : (IIII)V
/*      */     //   25412: aload_0
/*      */     //   25413: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   25416: iconst_3
/*      */     //   25417: fconst_1
/*      */     //   25418: invokestatic getInstance : (IF)Ljava/awt/AlphaComposite;
/*      */     //   25421: invokevirtual setComposite : (Ljava/awt/Composite;)V
/*      */     //   25424: aload_0
/*      */     //   25425: getfield hsb : [[F
/*      */     //   25428: iconst_1
/*      */     //   25429: aaload
/*      */     //   25430: iconst_1
/*      */     //   25431: aload_0
/*      */     //   25432: getfield hsb : [[F
/*      */     //   25435: iconst_0
/*      */     //   25436: aaload
/*      */     //   25437: iconst_1
/*      */     //   25438: faload
/*      */     //   25439: aload_0
/*      */     //   25440: getfield hsb : [[F
/*      */     //   25443: iconst_2
/*      */     //   25444: aaload
/*      */     //   25445: iconst_1
/*      */     //   25446: faload
/*      */     //   25447: fadd
/*      */     //   25448: fconst_2
/*      */     //   25449: fdiv
/*      */     //   25450: fastore
/*      */     //   25451: aload_0
/*      */     //   25452: getfield hsb : [[F
/*      */     //   25455: iconst_1
/*      */     //   25456: aaload
/*      */     //   25457: iconst_0
/*      */     //   25458: aload_0
/*      */     //   25459: getfield hsb : [[F
/*      */     //   25462: iconst_2
/*      */     //   25463: aaload
/*      */     //   25464: iconst_0
/*      */     //   25465: faload
/*      */     //   25466: fastore
/*      */     //   25467: aload_0
/*      */     //   25468: getfield hsb : [[F
/*      */     //   25471: iconst_1
/*      */     //   25472: aaload
/*      */     //   25473: iconst_2
/*      */     //   25474: aload_0
/*      */     //   25475: getfield hsb : [[F
/*      */     //   25478: iconst_2
/*      */     //   25479: aaload
/*      */     //   25480: iconst_2
/*      */     //   25481: faload
/*      */     //   25482: fastore
/*      */     //   25483: goto_w -> 25488
/*      */     //   25488: aload_0
/*      */     //   25489: getfield hsb : [[F
/*      */     //   25492: iconst_0
/*      */     //   25493: aaload
/*      */     //   25494: iconst_0
/*      */     //   25495: faload
/*      */     //   25496: aload_0
/*      */     //   25497: getfield hsb : [[F
/*      */     //   25500: iconst_0
/*      */     //   25501: aaload
/*      */     //   25502: iconst_2
/*      */     //   25503: faload
/*      */     //   25504: aload_0
/*      */     //   25505: getfield hsb : [[F
/*      */     //   25508: iconst_0
/*      */     //   25509: aaload
/*      */     //   25510: iconst_1
/*      */     //   25511: faload
/*      */     //   25512: invokestatic getHSBColor : (FFF)Ljava/awt/Color;
/*      */     //   25515: astore #8
/*      */     //   25517: aload_0
/*      */     //   25518: getfield m : LMedium;
/*      */     //   25521: aload #8
/*      */     //   25523: invokevirtual getRed : ()I
/*      */     //   25526: aload #8
/*      */     //   25528: invokevirtual getGreen : ()I
/*      */     //   25531: aload #8
/*      */     //   25533: invokevirtual getBlue : ()I
/*      */     //   25536: invokevirtual setsky : (III)V
/*      */     //   25539: aload_0
/*      */     //   25540: getfield csky : [I
/*      */     //   25543: iconst_0
/*      */     //   25544: aload #8
/*      */     //   25546: invokevirtual getRed : ()I
/*      */     //   25549: iastore
/*      */     //   25550: aload_0
/*      */     //   25551: getfield csky : [I
/*      */     //   25554: iconst_1
/*      */     //   25555: aload #8
/*      */     //   25557: invokevirtual getGreen : ()I
/*      */     //   25560: iastore
/*      */     //   25561: aload_0
/*      */     //   25562: getfield csky : [I
/*      */     //   25565: iconst_2
/*      */     //   25566: aload #8
/*      */     //   25568: invokevirtual getBlue : ()I
/*      */     //   25571: iastore
/*      */     //   25572: aload_0
/*      */     //   25573: getfield hsb : [[F
/*      */     //   25576: iconst_1
/*      */     //   25577: aaload
/*      */     //   25578: iconst_0
/*      */     //   25579: faload
/*      */     //   25580: aload_0
/*      */     //   25581: getfield hsb : [[F
/*      */     //   25584: iconst_1
/*      */     //   25585: aaload
/*      */     //   25586: iconst_2
/*      */     //   25587: faload
/*      */     //   25588: aload_0
/*      */     //   25589: getfield hsb : [[F
/*      */     //   25592: iconst_1
/*      */     //   25593: aaload
/*      */     //   25594: iconst_1
/*      */     //   25595: faload
/*      */     //   25596: invokestatic getHSBColor : (FFF)Ljava/awt/Color;
/*      */     //   25599: astore #8
/*      */     //   25601: aload_0
/*      */     //   25602: getfield m : LMedium;
/*      */     //   25605: aload #8
/*      */     //   25607: invokevirtual getRed : ()I
/*      */     //   25610: aload #8
/*      */     //   25612: invokevirtual getGreen : ()I
/*      */     //   25615: aload #8
/*      */     //   25617: invokevirtual getBlue : ()I
/*      */     //   25620: invokevirtual setfade : (III)V
/*      */     //   25623: aload_0
/*      */     //   25624: getfield cfade : [I
/*      */     //   25627: iconst_0
/*      */     //   25628: aload #8
/*      */     //   25630: invokevirtual getRed : ()I
/*      */     //   25633: iastore
/*      */     //   25634: aload_0
/*      */     //   25635: getfield cfade : [I
/*      */     //   25638: iconst_1
/*      */     //   25639: aload #8
/*      */     //   25641: invokevirtual getGreen : ()I
/*      */     //   25644: iastore
/*      */     //   25645: aload_0
/*      */     //   25646: getfield cfade : [I
/*      */     //   25649: iconst_2
/*      */     //   25650: aload #8
/*      */     //   25652: invokevirtual getBlue : ()I
/*      */     //   25655: iastore
/*      */     //   25656: aload_0
/*      */     //   25657: getfield hsb : [[F
/*      */     //   25660: iconst_2
/*      */     //   25661: aaload
/*      */     //   25662: iconst_0
/*      */     //   25663: faload
/*      */     //   25664: aload_0
/*      */     //   25665: getfield hsb : [[F
/*      */     //   25668: iconst_2
/*      */     //   25669: aaload
/*      */     //   25670: iconst_2
/*      */     //   25671: faload
/*      */     //   25672: aload_0
/*      */     //   25673: getfield hsb : [[F
/*      */     //   25676: iconst_2
/*      */     //   25677: aaload
/*      */     //   25678: iconst_1
/*      */     //   25679: faload
/*      */     //   25680: invokestatic getHSBColor : (FFF)Ljava/awt/Color;
/*      */     //   25683: astore #8
/*      */     //   25685: aload_0
/*      */     //   25686: getfield m : LMedium;
/*      */     //   25689: aload #8
/*      */     //   25691: invokevirtual getRed : ()I
/*      */     //   25694: aload #8
/*      */     //   25696: invokevirtual getGreen : ()I
/*      */     //   25699: aload #8
/*      */     //   25701: invokevirtual getBlue : ()I
/*      */     //   25704: invokevirtual setgrnd : (III)V
/*      */     //   25707: aload_0
/*      */     //   25708: getfield cgrnd : [I
/*      */     //   25711: iconst_0
/*      */     //   25712: aload #8
/*      */     //   25714: invokevirtual getRed : ()I
/*      */     //   25717: iastore
/*      */     //   25718: aload_0
/*      */     //   25719: getfield cgrnd : [I
/*      */     //   25722: iconst_1
/*      */     //   25723: aload #8
/*      */     //   25725: invokevirtual getGreen : ()I
/*      */     //   25728: iastore
/*      */     //   25729: aload_0
/*      */     //   25730: getfield cgrnd : [I
/*      */     //   25733: iconst_2
/*      */     //   25734: aload #8
/*      */     //   25736: invokevirtual getBlue : ()I
/*      */     //   25739: iastore
/*      */     //   25740: aload_0
/*      */     //   25741: ldc_w ' Reset '
/*      */     //   25744: sipush #650
/*      */     //   25747: sipush #510
/*      */     //   25750: iconst_0
/*      */     //   25751: iconst_1
/*      */     //   25752: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   25755: ifne -> 25763
/*      */     //   25758: goto_w -> 25815
/*      */     //   25763: aload_0
/*      */     //   25764: getfield ttstage : Ljava/lang/String;
/*      */     //   25767: ldc ''
/*      */     //   25769: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   25772: ifeq -> 25780
/*      */     //   25775: goto_w -> 25799
/*      */     //   25780: aload_0
/*      */     //   25781: aload_0
/*      */     //   25782: getfield ttstage : Ljava/lang/String;
/*      */     //   25785: putfield tstage : Ljava/lang/String;
/*      */     //   25788: aload_0
/*      */     //   25789: ldc ''
/*      */     //   25791: putfield ttstage : Ljava/lang/String;
/*      */     //   25794: goto_w -> 25799
/*      */     //   25799: aload_0
/*      */     //   25800: iconst_1
/*      */     //   25801: invokevirtual readstage : (I)V
/*      */     //   25804: aload_0
/*      */     //   25805: bipush #-2
/*      */     //   25807: putfield dtabed : I
/*      */     //   25810: goto_w -> 25815
/*      */     //   25815: aload_0
/*      */     //   25816: ldc_w '        Save        '
/*      */     //   25819: sipush #737
/*      */     //   25822: sipush #510
/*      */     //   25825: iconst_0
/*      */     //   25826: iconst_1
/*      */     //   25827: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   25830: ifne -> 25838
/*      */     //   25833: goto_w -> 25857
/*      */     //   25838: aload_0
/*      */     //   25839: invokevirtual sortop : ()V
/*      */     //   25842: aload_0
/*      */     //   25843: ldc ''
/*      */     //   25845: putfield ttstage : Ljava/lang/String;
/*      */     //   25848: aload_0
/*      */     //   25849: invokevirtual savefile : ()V
/*      */     //   25852: goto_w -> 25857
/*      */     //   25857: goto_w -> 25862
/*      */     //   25862: aload_0
/*      */     //   25863: getfield dtab : I
/*      */     //   25866: iconst_3
/*      */     //   25867: if_icmpeq -> 25875
/*      */     //   25870: goto_w -> 29995
/*      */     //   25875: aload_0
/*      */     //   25876: getfield dtabed : I
/*      */     //   25879: aload_0
/*      */     //   25880: getfield dtab : I
/*      */     //   25883: if_icmpne -> 25891
/*      */     //   25886: goto_w -> 26000
/*      */     //   25891: aload_0
/*      */     //   25892: getfield cldd : [I
/*      */     //   25895: iconst_0
/*      */     //   25896: iaload
/*      */     //   25897: aload_0
/*      */     //   25898: getfield cldd : [I
/*      */     //   25901: iconst_1
/*      */     //   25902: iaload
/*      */     //   25903: aload_0
/*      */     //   25904: getfield cldd : [I
/*      */     //   25907: iconst_2
/*      */     //   25908: iaload
/*      */     //   25909: aload_0
/*      */     //   25910: getfield hsb : [[F
/*      */     //   25913: iconst_0
/*      */     //   25914: aaload
/*      */     //   25915: invokestatic RGBtoHSB : (III[F)[F
/*      */     //   25918: pop
/*      */     //   25919: aload_0
/*      */     //   25920: getfield texture : [I
/*      */     //   25923: iconst_0
/*      */     //   25924: iaload
/*      */     //   25925: aload_0
/*      */     //   25926: getfield texture : [I
/*      */     //   25929: iconst_1
/*      */     //   25930: iaload
/*      */     //   25931: aload_0
/*      */     //   25932: getfield texture : [I
/*      */     //   25935: iconst_2
/*      */     //   25936: iaload
/*      */     //   25937: aload_0
/*      */     //   25938: getfield hsb : [[F
/*      */     //   25941: iconst_1
/*      */     //   25942: aaload
/*      */     //   25943: invokestatic RGBtoHSB : (III[F)[F
/*      */     //   25946: pop
/*      */     //   25947: aload_0
/*      */     //   25948: getfield mgen : Ljava/awt/TextField;
/*      */     //   25951: new java/lang/StringBuilder
/*      */     //   25954: dup
/*      */     //   25955: invokespecial <init> : ()V
/*      */     //   25958: ldc ''
/*      */     //   25960: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   25963: aload_0
/*      */     //   25964: getfield m : LMedium;
/*      */     //   25967: getfield mgen : I
/*      */     //   25970: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   25973: ldc ''
/*      */     //   25975: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   25978: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   25981: invokevirtual setText : (Ljava/lang/String;)V
/*      */     //   25984: aload_0
/*      */     //   25985: iconst_m1
/*      */     //   25986: putfield mouseon : I
/*      */     //   25989: aload_0
/*      */     //   25990: ldc ''
/*      */     //   25992: putfield ttstage : Ljava/lang/String;
/*      */     //   25995: goto_w -> 26000
/*      */     //   26000: aload_0
/*      */     //   26001: getfield mouses : I
/*      */     //   26004: iconst_1
/*      */     //   26005: if_icmpne -> 26013
/*      */     //   26008: goto_w -> 26119
/*      */     //   26013: aload_0
/*      */     //   26014: getfield mouseon : I
/*      */     //   26017: ifne -> 26025
/*      */     //   26020: goto_w -> 26065
/*      */     //   26025: aload_0
/*      */     //   26026: getfield mouseon : I
/*      */     //   26029: iconst_1
/*      */     //   26030: if_icmpne -> 26038
/*      */     //   26033: goto_w -> 26065
/*      */     //   26038: aload_0
/*      */     //   26039: getfield mouseon : I
/*      */     //   26042: iconst_2
/*      */     //   26043: if_icmpne -> 26051
/*      */     //   26046: goto_w -> 26065
/*      */     //   26051: aload_0
/*      */     //   26052: getfield mouseon : I
/*      */     //   26055: bipush #6
/*      */     //   26057: if_icmpeq -> 26065
/*      */     //   26060: goto_w -> 26109
/*      */     //   26065: aload_0
/*      */     //   26066: getfield ttstage : Ljava/lang/String;
/*      */     //   26069: ldc ''
/*      */     //   26071: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   26074: ifne -> 26082
/*      */     //   26077: goto_w -> 26095
/*      */     //   26082: aload_0
/*      */     //   26083: aload_0
/*      */     //   26084: getfield tstage : Ljava/lang/String;
/*      */     //   26087: putfield ttstage : Ljava/lang/String;
/*      */     //   26090: goto_w -> 26095
/*      */     //   26095: aload_0
/*      */     //   26096: invokevirtual sortop : ()V
/*      */     //   26099: aload_0
/*      */     //   26100: iconst_1
/*      */     //   26101: invokevirtual readstage : (I)V
/*      */     //   26104: goto_w -> 26109
/*      */     //   26109: aload_0
/*      */     //   26110: iconst_m1
/*      */     //   26111: putfield mouseon : I
/*      */     //   26114: goto_w -> 26119
/*      */     //   26119: aload_0
/*      */     //   26120: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26123: new java/awt/Font
/*      */     //   26126: dup
/*      */     //   26127: ldc_w 'Arial'
/*      */     //   26130: iconst_1
/*      */     //   26131: bipush #12
/*      */     //   26133: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   26136: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   26139: aload_0
/*      */     //   26140: aload_0
/*      */     //   26141: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26144: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   26147: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   26150: aload_0
/*      */     //   26151: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26154: new java/awt/Color
/*      */     //   26157: dup
/*      */     //   26158: iconst_0
/*      */     //   26159: iconst_0
/*      */     //   26160: iconst_0
/*      */     //   26161: invokespecial <init> : (III)V
/*      */     //   26164: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   26167: aload_0
/*      */     //   26168: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26171: ldc_w 'Clouds'
/*      */     //   26174: bipush #32
/*      */     //   26176: sipush #461
/*      */     //   26179: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   26182: iconst_0
/*      */     //   26183: istore #7
/*      */     //   26185: iload #7
/*      */     //   26187: sipush #150
/*      */     //   26190: if_icmplt -> 26198
/*      */     //   26193: goto_w -> 26252
/*      */     //   26198: aload_0
/*      */     //   26199: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26202: iload #7
/*      */     //   26204: i2f
/*      */     //   26205: ldc_w 0.006667
/*      */     //   26208: fmul
/*      */     //   26209: fconst_1
/*      */     //   26210: fconst_1
/*      */     //   26211: invokestatic getHSBColor : (FFF)Ljava/awt/Color;
/*      */     //   26214: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   26217: aload_0
/*      */     //   26218: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26221: bipush #32
/*      */     //   26223: iload #7
/*      */     //   26225: iadd
/*      */     //   26226: iconst_0
/*      */     //   26227: iadd
/*      */     //   26228: sipush #467
/*      */     //   26231: bipush #32
/*      */     //   26233: iload #7
/*      */     //   26235: iadd
/*      */     //   26236: iconst_0
/*      */     //   26237: iadd
/*      */     //   26238: sipush #474
/*      */     //   26241: invokevirtual drawLine : (IIII)V
/*      */     //   26244: iinc #7, 1
/*      */     //   26247: goto_w -> 26185
/*      */     //   26252: iconst_0
/*      */     //   26253: istore #7
/*      */     //   26255: iload #7
/*      */     //   26257: sipush #150
/*      */     //   26260: if_icmplt -> 26268
/*      */     //   26263: goto_w -> 26326
/*      */     //   26268: aload_0
/*      */     //   26269: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26272: fconst_0
/*      */     //   26273: fconst_0
/*      */     //   26274: ldc_w 0.75
/*      */     //   26277: iload #7
/*      */     //   26279: i2f
/*      */     //   26280: ldc_w 0.001667
/*      */     //   26283: fmul
/*      */     //   26284: fadd
/*      */     //   26285: invokestatic getHSBColor : (FFF)Ljava/awt/Color;
/*      */     //   26288: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   26291: aload_0
/*      */     //   26292: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26295: bipush #32
/*      */     //   26297: iload #7
/*      */     //   26299: iadd
/*      */     //   26300: iconst_0
/*      */     //   26301: iadd
/*      */     //   26302: sipush #483
/*      */     //   26305: bipush #32
/*      */     //   26307: iload #7
/*      */     //   26309: iadd
/*      */     //   26310: iconst_0
/*      */     //   26311: iadd
/*      */     //   26312: sipush #490
/*      */     //   26315: invokevirtual drawLine : (IIII)V
/*      */     //   26318: iinc #7, 1
/*      */     //   26321: goto_w -> 26255
/*      */     //   26326: iconst_0
/*      */     //   26327: istore #7
/*      */     //   26329: iload #7
/*      */     //   26331: sipush #150
/*      */     //   26334: if_icmplt -> 26342
/*      */     //   26337: goto_w -> 26410
/*      */     //   26342: aload_0
/*      */     //   26343: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26346: aload_0
/*      */     //   26347: getfield hsb : [[F
/*      */     //   26350: iconst_0
/*      */     //   26351: aaload
/*      */     //   26352: iconst_0
/*      */     //   26353: faload
/*      */     //   26354: iload #7
/*      */     //   26356: i2f
/*      */     //   26357: ldc_w 0.003333
/*      */     //   26360: fmul
/*      */     //   26361: aload_0
/*      */     //   26362: getfield hsb : [[F
/*      */     //   26365: iconst_0
/*      */     //   26366: aaload
/*      */     //   26367: iconst_2
/*      */     //   26368: faload
/*      */     //   26369: invokestatic getHSBColor : (FFF)Ljava/awt/Color;
/*      */     //   26372: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   26375: aload_0
/*      */     //   26376: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26379: bipush #32
/*      */     //   26381: iload #7
/*      */     //   26383: iadd
/*      */     //   26384: iconst_0
/*      */     //   26385: iadd
/*      */     //   26386: sipush #499
/*      */     //   26389: bipush #32
/*      */     //   26391: iload #7
/*      */     //   26393: iadd
/*      */     //   26394: iconst_0
/*      */     //   26395: iadd
/*      */     //   26396: sipush #506
/*      */     //   26399: invokevirtual drawLine : (IIII)V
/*      */     //   26402: iinc #7, 1
/*      */     //   26405: goto_w -> 26329
/*      */     //   26410: aload_0
/*      */     //   26411: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26414: new java/awt/Font
/*      */     //   26417: dup
/*      */     //   26418: ldc_w 'Arial'
/*      */     //   26421: iconst_0
/*      */     //   26422: bipush #11
/*      */     //   26424: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   26427: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   26430: aload_0
/*      */     //   26431: aload_0
/*      */     //   26432: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26435: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   26438: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   26441: aload_0
/*      */     //   26442: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26445: new java/awt/Color
/*      */     //   26448: dup
/*      */     //   26449: iconst_0
/*      */     //   26450: iconst_0
/*      */     //   26451: iconst_0
/*      */     //   26452: invokespecial <init> : (III)V
/*      */     //   26455: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   26458: aload_0
/*      */     //   26459: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26462: ldc_w 'Blend:'
/*      */     //   26465: bipush #32
/*      */     //   26467: sipush #529
/*      */     //   26470: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   26473: aload_0
/*      */     //   26474: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26477: new java/awt/Color
/*      */     //   26480: dup
/*      */     //   26481: iconst_0
/*      */     //   26482: iconst_0
/*      */     //   26483: iconst_0
/*      */     //   26484: invokespecial <init> : (III)V
/*      */     //   26487: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   26490: aload_0
/*      */     //   26491: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26494: bipush #70
/*      */     //   26496: sipush #522
/*      */     //   26499: bipush #112
/*      */     //   26501: iconst_2
/*      */     //   26502: invokevirtual fillRect : (IIII)V
/*      */     //   26505: aload_0
/*      */     //   26506: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26509: bipush #70
/*      */     //   26511: sipush #528
/*      */     //   26514: bipush #112
/*      */     //   26516: iconst_2
/*      */     //   26517: invokevirtual fillRect : (IIII)V
/*      */     //   26520: fconst_0
/*      */     //   26521: fstore #7
/*      */     //   26523: sipush #255
/*      */     //   26526: istore #8
/*      */     //   26528: iconst_0
/*      */     //   26529: istore #9
/*      */     //   26531: iload #9
/*      */     //   26533: bipush #112
/*      */     //   26535: if_icmplt -> 26543
/*      */     //   26538: goto_w -> 26654
/*      */     //   26543: ldc_w 255.0
/*      */     //   26546: fload #7
/*      */     //   26548: fconst_1
/*      */     //   26549: fadd
/*      */     //   26550: fdiv
/*      */     //   26551: f2i
/*      */     //   26552: istore #8
/*      */     //   26554: iload #8
/*      */     //   26556: sipush #255
/*      */     //   26559: if_icmpgt -> 26567
/*      */     //   26562: goto_w -> 26577
/*      */     //   26567: sipush #255
/*      */     //   26570: istore #8
/*      */     //   26572: goto_w -> 26577
/*      */     //   26577: iload #8
/*      */     //   26579: iflt -> 26587
/*      */     //   26582: goto_w -> 26595
/*      */     //   26587: iconst_0
/*      */     //   26588: istore #8
/*      */     //   26590: goto_w -> 26595
/*      */     //   26595: fload #7
/*      */     //   26597: ldc_w 0.02
/*      */     //   26600: fadd
/*      */     //   26601: fstore #7
/*      */     //   26603: aload_0
/*      */     //   26604: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26607: new java/awt/Color
/*      */     //   26610: dup
/*      */     //   26611: iload #8
/*      */     //   26613: iload #8
/*      */     //   26615: iload #8
/*      */     //   26617: invokespecial <init> : (III)V
/*      */     //   26620: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   26623: aload_0
/*      */     //   26624: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26627: bipush #70
/*      */     //   26629: iload #9
/*      */     //   26631: iadd
/*      */     //   26632: sipush #524
/*      */     //   26635: bipush #70
/*      */     //   26637: iload #9
/*      */     //   26639: iadd
/*      */     //   26640: sipush #527
/*      */     //   26643: invokevirtual drawLine : (IIII)V
/*      */     //   26646: iinc #9, 1
/*      */     //   26649: goto_w -> 26531
/*      */     //   26654: aload_0
/*      */     //   26655: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26658: new java/awt/Color
/*      */     //   26661: dup
/*      */     //   26662: iconst_0
/*      */     //   26663: iconst_0
/*      */     //   26664: iconst_0
/*      */     //   26665: invokespecial <init> : (III)V
/*      */     //   26668: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   26671: aload_0
/*      */     //   26672: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26675: ldc_w 'Height'
/*      */     //   26678: sipush #202
/*      */     //   26681: aload_0
/*      */     //   26682: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   26685: ldc_w 'Height'
/*      */     //   26688: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   26691: iconst_2
/*      */     //   26692: idiv
/*      */     //   26693: isub
/*      */     //   26694: sipush #461
/*      */     //   26697: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   26700: aload_0
/*      */     //   26701: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26704: sipush #202
/*      */     //   26707: sipush #467
/*      */     //   26710: sipush #202
/*      */     //   26713: sipush #530
/*      */     //   26716: invokevirtual drawLine : (IIII)V
/*      */     //   26719: iconst_0
/*      */     //   26720: istore #9
/*      */     //   26722: iload #9
/*      */     //   26724: bipush #8
/*      */     //   26726: if_icmplt -> 26734
/*      */     //   26729: goto_w -> 26779
/*      */     //   26734: aload_0
/*      */     //   26735: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26738: sipush #202
/*      */     //   26741: sipush #466
/*      */     //   26744: iload #9
/*      */     //   26746: bipush #8
/*      */     //   26748: imul
/*      */     //   26749: iadd
/*      */     //   26750: sipush #202
/*      */     //   26753: bipush #8
/*      */     //   26755: iload #9
/*      */     //   26757: isub
/*      */     //   26758: iadd
/*      */     //   26759: sipush #466
/*      */     //   26762: iload #9
/*      */     //   26764: bipush #8
/*      */     //   26766: imul
/*      */     //   26767: iadd
/*      */     //   26768: invokevirtual drawLine : (IIII)V
/*      */     //   26771: iinc #9, 1
/*      */     //   26774: goto_w -> 26722
/*      */     //   26779: aload_0
/*      */     //   26780: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26783: new java/awt/Font
/*      */     //   26786: dup
/*      */     //   26787: ldc_w 'Arial'
/*      */     //   26790: iconst_1
/*      */     //   26791: bipush #12
/*      */     //   26793: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   26796: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   26799: aload_0
/*      */     //   26800: aload_0
/*      */     //   26801: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26804: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   26807: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   26810: aload_0
/*      */     //   26811: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26814: new java/awt/Color
/*      */     //   26817: dup
/*      */     //   26818: iconst_0
/*      */     //   26819: iconst_0
/*      */     //   26820: iconst_0
/*      */     //   26821: invokespecial <init> : (III)V
/*      */     //   26824: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   26827: aload_0
/*      */     //   26828: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26831: ldc_w 'Ground Texture'
/*      */     //   26834: sipush #257
/*      */     //   26837: sipush #471
/*      */     //   26840: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   26843: iconst_0
/*      */     //   26844: istore #9
/*      */     //   26846: iload #9
/*      */     //   26848: sipush #150
/*      */     //   26851: if_icmplt -> 26859
/*      */     //   26854: goto_w -> 26917
/*      */     //   26859: aload_0
/*      */     //   26860: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26863: iload #9
/*      */     //   26865: i2f
/*      */     //   26866: ldc_w 0.006667
/*      */     //   26869: fmul
/*      */     //   26870: fconst_1
/*      */     //   26871: fconst_1
/*      */     //   26872: invokestatic getHSBColor : (FFF)Ljava/awt/Color;
/*      */     //   26875: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   26878: aload_0
/*      */     //   26879: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26882: bipush #32
/*      */     //   26884: iload #9
/*      */     //   26886: iadd
/*      */     //   26887: sipush #225
/*      */     //   26890: iadd
/*      */     //   26891: sipush #477
/*      */     //   26894: bipush #32
/*      */     //   26896: iload #9
/*      */     //   26898: iadd
/*      */     //   26899: sipush #225
/*      */     //   26902: iadd
/*      */     //   26903: sipush #484
/*      */     //   26906: invokevirtual drawLine : (IIII)V
/*      */     //   26909: iinc #9, 1
/*      */     //   26912: goto_w -> 26846
/*      */     //   26917: iconst_0
/*      */     //   26918: istore #9
/*      */     //   26920: iload #9
/*      */     //   26922: sipush #150
/*      */     //   26925: if_icmplt -> 26933
/*      */     //   26928: goto_w -> 27004
/*      */     //   26933: aload_0
/*      */     //   26934: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26937: aload_0
/*      */     //   26938: getfield hsb : [[F
/*      */     //   26941: iconst_1
/*      */     //   26942: aaload
/*      */     //   26943: iconst_0
/*      */     //   26944: faload
/*      */     //   26945: iload #9
/*      */     //   26947: i2f
/*      */     //   26948: ldc_w 0.006667
/*      */     //   26951: fmul
/*      */     //   26952: iload #9
/*      */     //   26954: i2f
/*      */     //   26955: ldc_w 0.006667
/*      */     //   26958: fmul
/*      */     //   26959: invokestatic getHSBColor : (FFF)Ljava/awt/Color;
/*      */     //   26962: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   26965: aload_0
/*      */     //   26966: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   26969: bipush #32
/*      */     //   26971: iload #9
/*      */     //   26973: iadd
/*      */     //   26974: sipush #225
/*      */     //   26977: iadd
/*      */     //   26978: sipush #493
/*      */     //   26981: bipush #32
/*      */     //   26983: iload #9
/*      */     //   26985: iadd
/*      */     //   26986: sipush #225
/*      */     //   26989: iadd
/*      */     //   26990: sipush #500
/*      */     //   26993: invokevirtual drawLine : (IIII)V
/*      */     //   26996: iinc #9, 1
/*      */     //   26999: goto_w -> 26920
/*      */     //   27004: aload_0
/*      */     //   27005: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   27008: new java/awt/Font
/*      */     //   27011: dup
/*      */     //   27012: ldc_w 'Arial'
/*      */     //   27015: iconst_0
/*      */     //   27016: bipush #11
/*      */     //   27018: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   27021: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   27024: aload_0
/*      */     //   27025: aload_0
/*      */     //   27026: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   27029: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   27032: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   27035: aload_0
/*      */     //   27036: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   27039: new java/awt/Color
/*      */     //   27042: dup
/*      */     //   27043: iconst_0
/*      */     //   27044: iconst_0
/*      */     //   27045: iconst_0
/*      */     //   27046: invokespecial <init> : (III)V
/*      */     //   27049: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   27052: aload_0
/*      */     //   27053: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   27056: ldc_w 'Blend:'
/*      */     //   27059: sipush #257
/*      */     //   27062: sipush #523
/*      */     //   27065: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   27068: aload_0
/*      */     //   27069: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   27072: new java/awt/Color
/*      */     //   27075: dup
/*      */     //   27076: iconst_0
/*      */     //   27077: iconst_0
/*      */     //   27078: iconst_0
/*      */     //   27079: invokespecial <init> : (III)V
/*      */     //   27082: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   27085: aload_0
/*      */     //   27086: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   27089: sipush #295
/*      */     //   27092: sipush #516
/*      */     //   27095: bipush #112
/*      */     //   27097: iconst_2
/*      */     //   27098: invokevirtual fillRect : (IIII)V
/*      */     //   27101: aload_0
/*      */     //   27102: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   27105: sipush #295
/*      */     //   27108: sipush #522
/*      */     //   27111: bipush #112
/*      */     //   27113: iconst_2
/*      */     //   27114: invokevirtual fillRect : (IIII)V
/*      */     //   27117: fconst_0
/*      */     //   27118: fstore #7
/*      */     //   27120: sipush #255
/*      */     //   27123: istore #8
/*      */     //   27125: iconst_0
/*      */     //   27126: istore #9
/*      */     //   27128: iload #9
/*      */     //   27130: bipush #112
/*      */     //   27132: if_icmplt -> 27140
/*      */     //   27135: goto_w -> 27259
/*      */     //   27140: ldc_w 255.0
/*      */     //   27143: fload #7
/*      */     //   27145: fconst_1
/*      */     //   27146: fadd
/*      */     //   27147: fdiv
/*      */     //   27148: f2i
/*      */     //   27149: istore #8
/*      */     //   27151: iload #8
/*      */     //   27153: sipush #255
/*      */     //   27156: if_icmpgt -> 27164
/*      */     //   27159: goto_w -> 27174
/*      */     //   27164: sipush #255
/*      */     //   27167: istore #8
/*      */     //   27169: goto_w -> 27174
/*      */     //   27174: iload #8
/*      */     //   27176: iflt -> 27184
/*      */     //   27179: goto_w -> 27192
/*      */     //   27184: iconst_0
/*      */     //   27185: istore #8
/*      */     //   27187: goto_w -> 27192
/*      */     //   27192: fload #7
/*      */     //   27194: ldc_w 0.02
/*      */     //   27197: fadd
/*      */     //   27198: fstore #7
/*      */     //   27200: aload_0
/*      */     //   27201: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   27204: new java/awt/Color
/*      */     //   27207: dup
/*      */     //   27208: iload #8
/*      */     //   27210: iload #8
/*      */     //   27212: iload #8
/*      */     //   27214: invokespecial <init> : (III)V
/*      */     //   27217: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   27220: aload_0
/*      */     //   27221: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   27224: bipush #70
/*      */     //   27226: iload #9
/*      */     //   27228: iadd
/*      */     //   27229: sipush #225
/*      */     //   27232: iadd
/*      */     //   27233: sipush #518
/*      */     //   27236: bipush #70
/*      */     //   27238: iload #9
/*      */     //   27240: iadd
/*      */     //   27241: sipush #225
/*      */     //   27244: iadd
/*      */     //   27245: sipush #521
/*      */     //   27248: invokevirtual drawLine : (IIII)V
/*      */     //   27251: iinc #9, 1
/*      */     //   27254: goto_w -> 27128
/*      */     //   27259: iconst_0
/*      */     //   27260: istore #9
/*      */     //   27262: iload #9
/*      */     //   27264: iconst_2
/*      */     //   27265: if_icmplt -> 27273
/*      */     //   27268: goto_w -> 28759
/*      */     //   27273: iconst_3
/*      */     //   27274: istore #10
/*      */     //   27276: iload #9
/*      */     //   27278: iconst_1
/*      */     //   27279: if_icmpeq -> 27287
/*      */     //   27282: goto_w -> 27295
/*      */     //   27287: iconst_2
/*      */     //   27288: istore #10
/*      */     //   27290: goto_w -> 27295
/*      */     //   27295: iconst_0
/*      */     //   27296: istore #11
/*      */     //   27298: iload #11
/*      */     //   27300: iload #10
/*      */     //   27302: if_icmplt -> 27310
/*      */     //   27305: goto_w -> 28330
/*      */     //   27310: iload #11
/*      */     //   27312: istore #12
/*      */     //   27314: iload #11
/*      */     //   27316: iconst_1
/*      */     //   27317: if_icmpeq -> 27325
/*      */     //   27320: goto_w -> 27333
/*      */     //   27325: iconst_2
/*      */     //   27326: istore #12
/*      */     //   27328: goto_w -> 27333
/*      */     //   27333: iload #11
/*      */     //   27335: iconst_2
/*      */     //   27336: if_icmpeq -> 27344
/*      */     //   27339: goto_w -> 27352
/*      */     //   27344: iconst_1
/*      */     //   27345: istore #12
/*      */     //   27347: goto_w -> 27352
/*      */     //   27352: aload_0
/*      */     //   27353: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   27356: new java/awt/Color
/*      */     //   27359: dup
/*      */     //   27360: iconst_0
/*      */     //   27361: iconst_0
/*      */     //   27362: iconst_0
/*      */     //   27363: invokespecial <init> : (III)V
/*      */     //   27366: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   27369: aload_0
/*      */     //   27370: getfield hsb : [[F
/*      */     //   27373: iload #9
/*      */     //   27375: aaload
/*      */     //   27376: iload #12
/*      */     //   27378: faload
/*      */     //   27379: ldc_w 150.0
/*      */     //   27382: fmul
/*      */     //   27383: fstore #13
/*      */     //   27385: iload #11
/*      */     //   27387: iconst_1
/*      */     //   27388: if_icmpeq -> 27396
/*      */     //   27391: goto_w -> 27435
/*      */     //   27396: iload #9
/*      */     //   27398: ifeq -> 27406
/*      */     //   27401: goto_w -> 27435
/*      */     //   27406: ldc_w 0.75
/*      */     //   27409: fstore #14
/*      */     //   27411: aload_0
/*      */     //   27412: getfield hsb : [[F
/*      */     //   27415: iload #9
/*      */     //   27417: aaload
/*      */     //   27418: iload #12
/*      */     //   27420: faload
/*      */     //   27421: fload #14
/*      */     //   27423: fsub
/*      */     //   27424: ldc_w 0.001667
/*      */     //   27427: fdiv
/*      */     //   27428: fstore #13
/*      */     //   27430: goto_w -> 27435
/*      */     //   27435: iload #11
/*      */     //   27437: iconst_2
/*      */     //   27438: if_icmpeq -> 27446
/*      */     //   27441: goto_w -> 27477
/*      */     //   27446: iload #9
/*      */     //   27448: ifeq -> 27456
/*      */     //   27451: goto_w -> 27477
/*      */     //   27456: aload_0
/*      */     //   27457: getfield hsb : [[F
/*      */     //   27460: iload #9
/*      */     //   27462: aaload
/*      */     //   27463: iload #12
/*      */     //   27465: faload
/*      */     //   27466: ldc_w 0.003333
/*      */     //   27469: fdiv
/*      */     //   27470: fstore #13
/*      */     //   27472: goto_w -> 27477
/*      */     //   27477: fload #13
/*      */     //   27479: fconst_0
/*      */     //   27480: fcmpg
/*      */     //   27481: iflt -> 27489
/*      */     //   27484: goto_w -> 27497
/*      */     //   27489: fconst_0
/*      */     //   27490: fstore #13
/*      */     //   27492: goto_w -> 27497
/*      */     //   27497: fload #13
/*      */     //   27499: ldc_w 150.0
/*      */     //   27502: fcmpl
/*      */     //   27503: ifgt -> 27511
/*      */     //   27506: goto_w -> 27521
/*      */     //   27511: ldc_w 150.0
/*      */     //   27514: fstore #13
/*      */     //   27516: goto_w -> 27521
/*      */     //   27521: aload_0
/*      */     //   27522: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   27525: bipush #32
/*      */     //   27527: sipush #225
/*      */     //   27530: iload #9
/*      */     //   27532: imul
/*      */     //   27533: iadd
/*      */     //   27534: i2f
/*      */     //   27535: fload #13
/*      */     //   27537: fadd
/*      */     //   27538: f2i
/*      */     //   27539: sipush #467
/*      */     //   27542: iload #11
/*      */     //   27544: bipush #16
/*      */     //   27546: imul
/*      */     //   27547: iadd
/*      */     //   27548: bipush #10
/*      */     //   27550: iload #9
/*      */     //   27552: imul
/*      */     //   27553: iadd
/*      */     //   27554: bipush #32
/*      */     //   27556: sipush #225
/*      */     //   27559: iload #9
/*      */     //   27561: imul
/*      */     //   27562: iadd
/*      */     //   27563: i2f
/*      */     //   27564: fload #13
/*      */     //   27566: fadd
/*      */     //   27567: f2i
/*      */     //   27568: sipush #474
/*      */     //   27571: iload #11
/*      */     //   27573: bipush #16
/*      */     //   27575: imul
/*      */     //   27576: iadd
/*      */     //   27577: bipush #10
/*      */     //   27579: iload #9
/*      */     //   27581: imul
/*      */     //   27582: iadd
/*      */     //   27583: invokevirtual drawLine : (IIII)V
/*      */     //   27586: aload_0
/*      */     //   27587: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   27590: bipush #33
/*      */     //   27592: sipush #225
/*      */     //   27595: iload #9
/*      */     //   27597: imul
/*      */     //   27598: iadd
/*      */     //   27599: i2f
/*      */     //   27600: fload #13
/*      */     //   27602: fadd
/*      */     //   27603: f2i
/*      */     //   27604: sipush #467
/*      */     //   27607: iload #11
/*      */     //   27609: bipush #16
/*      */     //   27611: imul
/*      */     //   27612: iadd
/*      */     //   27613: bipush #10
/*      */     //   27615: iload #9
/*      */     //   27617: imul
/*      */     //   27618: iadd
/*      */     //   27619: bipush #33
/*      */     //   27621: sipush #225
/*      */     //   27624: iload #9
/*      */     //   27626: imul
/*      */     //   27627: iadd
/*      */     //   27628: i2f
/*      */     //   27629: fload #13
/*      */     //   27631: fadd
/*      */     //   27632: f2i
/*      */     //   27633: sipush #474
/*      */     //   27636: iload #11
/*      */     //   27638: bipush #16
/*      */     //   27640: imul
/*      */     //   27641: iadd
/*      */     //   27642: bipush #10
/*      */     //   27644: iload #9
/*      */     //   27646: imul
/*      */     //   27647: iadd
/*      */     //   27648: invokevirtual drawLine : (IIII)V
/*      */     //   27651: aload_0
/*      */     //   27652: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   27655: bipush #31
/*      */     //   27657: sipush #225
/*      */     //   27660: iload #9
/*      */     //   27662: imul
/*      */     //   27663: iadd
/*      */     //   27664: i2f
/*      */     //   27665: fload #13
/*      */     //   27667: fadd
/*      */     //   27668: f2i
/*      */     //   27669: sipush #475
/*      */     //   27672: iload #11
/*      */     //   27674: bipush #16
/*      */     //   27676: imul
/*      */     //   27677: iadd
/*      */     //   27678: bipush #10
/*      */     //   27680: iload #9
/*      */     //   27682: imul
/*      */     //   27683: iadd
/*      */     //   27684: iconst_4
/*      */     //   27685: iconst_2
/*      */     //   27686: invokevirtual fillRect : (IIII)V
/*      */     //   27689: aload_0
/*      */     //   27690: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   27693: bipush #30
/*      */     //   27695: sipush #225
/*      */     //   27698: iload #9
/*      */     //   27700: imul
/*      */     //   27701: iadd
/*      */     //   27702: i2f
/*      */     //   27703: fload #13
/*      */     //   27705: fadd
/*      */     //   27706: f2i
/*      */     //   27707: sipush #477
/*      */     //   27710: iload #11
/*      */     //   27712: bipush #16
/*      */     //   27714: imul
/*      */     //   27715: iadd
/*      */     //   27716: bipush #10
/*      */     //   27718: iload #9
/*      */     //   27720: imul
/*      */     //   27721: iadd
/*      */     //   27722: bipush #35
/*      */     //   27724: sipush #225
/*      */     //   27727: iload #9
/*      */     //   27729: imul
/*      */     //   27730: iadd
/*      */     //   27731: i2f
/*      */     //   27732: fload #13
/*      */     //   27734: fadd
/*      */     //   27735: f2i
/*      */     //   27736: sipush #477
/*      */     //   27739: iload #11
/*      */     //   27741: bipush #16
/*      */     //   27743: imul
/*      */     //   27744: iadd
/*      */     //   27745: bipush #10
/*      */     //   27747: iload #9
/*      */     //   27749: imul
/*      */     //   27750: iadd
/*      */     //   27751: invokevirtual drawLine : (IIII)V
/*      */     //   27754: aload_0
/*      */     //   27755: getfield xm : I
/*      */     //   27758: bipush #29
/*      */     //   27760: sipush #225
/*      */     //   27763: iload #9
/*      */     //   27765: imul
/*      */     //   27766: iadd
/*      */     //   27767: if_icmpgt -> 27775
/*      */     //   27770: goto_w -> 27893
/*      */     //   27775: aload_0
/*      */     //   27776: getfield xm : I
/*      */     //   27779: sipush #185
/*      */     //   27782: sipush #225
/*      */     //   27785: iload #9
/*      */     //   27787: imul
/*      */     //   27788: iadd
/*      */     //   27789: if_icmplt -> 27797
/*      */     //   27792: goto_w -> 27893
/*      */     //   27797: aload_0
/*      */     //   27798: getfield ym : I
/*      */     //   27801: sipush #468
/*      */     //   27804: iload #11
/*      */     //   27806: bipush #16
/*      */     //   27808: imul
/*      */     //   27809: iadd
/*      */     //   27810: bipush #10
/*      */     //   27812: iload #9
/*      */     //   27814: imul
/*      */     //   27815: iadd
/*      */     //   27816: if_icmpgt -> 27824
/*      */     //   27819: goto_w -> 27893
/*      */     //   27824: aload_0
/*      */     //   27825: getfield ym : I
/*      */     //   27828: sipush #477
/*      */     //   27831: iload #11
/*      */     //   27833: bipush #16
/*      */     //   27835: imul
/*      */     //   27836: iadd
/*      */     //   27837: bipush #10
/*      */     //   27839: iload #9
/*      */     //   27841: imul
/*      */     //   27842: iadd
/*      */     //   27843: if_icmplt -> 27851
/*      */     //   27846: goto_w -> 27893
/*      */     //   27851: aload_0
/*      */     //   27852: getfield mouses : I
/*      */     //   27855: iconst_1
/*      */     //   27856: if_icmpeq -> 27864
/*      */     //   27859: goto_w -> 27893
/*      */     //   27864: aload_0
/*      */     //   27865: getfield mouseon : I
/*      */     //   27868: iconst_m1
/*      */     //   27869: if_icmpeq -> 27877
/*      */     //   27872: goto_w -> 27893
/*      */     //   27877: aload_0
/*      */     //   27878: iload #11
/*      */     //   27880: iload #9
/*      */     //   27882: iconst_3
/*      */     //   27883: imul
/*      */     //   27884: iadd
/*      */     //   27885: putfield mouseon : I
/*      */     //   27888: goto_w -> 27893
/*      */     //   27893: aload_0
/*      */     //   27894: getfield mouseon : I
/*      */     //   27897: iload #11
/*      */     //   27899: iload #9
/*      */     //   27901: iconst_3
/*      */     //   27902: imul
/*      */     //   27903: iadd
/*      */     //   27904: if_icmpeq -> 27912
/*      */     //   27907: goto_w -> 28322
/*      */     //   27912: aload_0
/*      */     //   27913: getfield hsb : [[F
/*      */     //   27916: iload #9
/*      */     //   27918: aaload
/*      */     //   27919: iload #12
/*      */     //   27921: aload_0
/*      */     //   27922: getfield xm : I
/*      */     //   27925: bipush #32
/*      */     //   27927: sipush #225
/*      */     //   27930: iload #9
/*      */     //   27932: imul
/*      */     //   27933: iadd
/*      */     //   27934: isub
/*      */     //   27935: i2f
/*      */     //   27936: ldc_w 0.006667
/*      */     //   27939: fmul
/*      */     //   27940: fastore
/*      */     //   27941: iload #11
/*      */     //   27943: iconst_1
/*      */     //   27944: if_icmpeq -> 27952
/*      */     //   27947: goto_w -> 28059
/*      */     //   27952: iload #9
/*      */     //   27954: iconst_1
/*      */     //   27955: if_icmpeq -> 27963
/*      */     //   27958: goto_w -> 28059
/*      */     //   27963: aload_0
/*      */     //   27964: getfield hsb : [[F
/*      */     //   27967: iload #9
/*      */     //   27969: aaload
/*      */     //   27970: iconst_1
/*      */     //   27971: aload_0
/*      */     //   27972: getfield xm : I
/*      */     //   27975: bipush #32
/*      */     //   27977: sipush #225
/*      */     //   27980: iload #9
/*      */     //   27982: imul
/*      */     //   27983: iadd
/*      */     //   27984: isub
/*      */     //   27985: i2f
/*      */     //   27986: ldc_w 0.006667
/*      */     //   27989: fmul
/*      */     //   27990: fastore
/*      */     //   27991: aload_0
/*      */     //   27992: getfield hsb : [[F
/*      */     //   27995: iload #9
/*      */     //   27997: aaload
/*      */     //   27998: iconst_1
/*      */     //   27999: faload
/*      */     //   28000: fconst_1
/*      */     //   28001: fcmpl
/*      */     //   28002: ifgt -> 28010
/*      */     //   28005: goto_w -> 28025
/*      */     //   28010: aload_0
/*      */     //   28011: getfield hsb : [[F
/*      */     //   28014: iload #9
/*      */     //   28016: aaload
/*      */     //   28017: iconst_1
/*      */     //   28018: fconst_1
/*      */     //   28019: fastore
/*      */     //   28020: goto_w -> 28025
/*      */     //   28025: aload_0
/*      */     //   28026: getfield hsb : [[F
/*      */     //   28029: iload #9
/*      */     //   28031: aaload
/*      */     //   28032: iconst_1
/*      */     //   28033: faload
/*      */     //   28034: fconst_0
/*      */     //   28035: fcmpg
/*      */     //   28036: iflt -> 28044
/*      */     //   28039: goto_w -> 28059
/*      */     //   28044: aload_0
/*      */     //   28045: getfield hsb : [[F
/*      */     //   28048: iload #9
/*      */     //   28050: aaload
/*      */     //   28051: iconst_1
/*      */     //   28052: fconst_0
/*      */     //   28053: fastore
/*      */     //   28054: goto_w -> 28059
/*      */     //   28059: iload #11
/*      */     //   28061: iconst_1
/*      */     //   28062: if_icmpeq -> 28070
/*      */     //   28065: goto_w -> 28160
/*      */     //   28070: iload #9
/*      */     //   28072: ifeq -> 28080
/*      */     //   28075: goto_w -> 28160
/*      */     //   28080: ldc_w 0.75
/*      */     //   28083: fstore #14
/*      */     //   28085: aload_0
/*      */     //   28086: getfield hsb : [[F
/*      */     //   28089: iload #9
/*      */     //   28091: aaload
/*      */     //   28092: iload #12
/*      */     //   28094: fload #14
/*      */     //   28096: aload_0
/*      */     //   28097: getfield xm : I
/*      */     //   28100: bipush #32
/*      */     //   28102: sipush #225
/*      */     //   28105: iload #9
/*      */     //   28107: imul
/*      */     //   28108: iadd
/*      */     //   28109: isub
/*      */     //   28110: i2f
/*      */     //   28111: ldc_w 0.001667
/*      */     //   28114: fmul
/*      */     //   28115: fadd
/*      */     //   28116: fastore
/*      */     //   28117: aload_0
/*      */     //   28118: getfield hsb : [[F
/*      */     //   28121: iload #9
/*      */     //   28123: aaload
/*      */     //   28124: iload #12
/*      */     //   28126: faload
/*      */     //   28127: fload #14
/*      */     //   28129: fcmpg
/*      */     //   28130: iflt -> 28138
/*      */     //   28133: goto_w -> 28155
/*      */     //   28138: aload_0
/*      */     //   28139: getfield hsb : [[F
/*      */     //   28142: iload #9
/*      */     //   28144: aaload
/*      */     //   28145: iload #12
/*      */     //   28147: fload #14
/*      */     //   28149: fastore
/*      */     //   28150: goto_w -> 28155
/*      */     //   28155: goto_w -> 28160
/*      */     //   28160: iload #11
/*      */     //   28162: iconst_2
/*      */     //   28163: if_icmpeq -> 28171
/*      */     //   28166: goto_w -> 28250
/*      */     //   28171: iload #9
/*      */     //   28173: ifeq -> 28181
/*      */     //   28176: goto_w -> 28250
/*      */     //   28181: aload_0
/*      */     //   28182: getfield hsb : [[F
/*      */     //   28185: iload #9
/*      */     //   28187: aaload
/*      */     //   28188: iload #12
/*      */     //   28190: aload_0
/*      */     //   28191: getfield xm : I
/*      */     //   28194: bipush #32
/*      */     //   28196: sipush #225
/*      */     //   28199: iload #9
/*      */     //   28201: imul
/*      */     //   28202: iadd
/*      */     //   28203: isub
/*      */     //   28204: i2f
/*      */     //   28205: ldc_w 0.003333
/*      */     //   28208: fmul
/*      */     //   28209: fastore
/*      */     //   28210: aload_0
/*      */     //   28211: getfield hsb : [[F
/*      */     //   28214: iload #9
/*      */     //   28216: aaload
/*      */     //   28217: iload #12
/*      */     //   28219: faload
/*      */     //   28220: f2d
/*      */     //   28221: ldc2_w 0.5
/*      */     //   28224: dcmpl
/*      */     //   28225: ifgt -> 28233
/*      */     //   28228: goto_w -> 28250
/*      */     //   28233: aload_0
/*      */     //   28234: getfield hsb : [[F
/*      */     //   28237: iload #9
/*      */     //   28239: aaload
/*      */     //   28240: iload #12
/*      */     //   28242: ldc 0.5
/*      */     //   28244: fastore
/*      */     //   28245: goto_w -> 28250
/*      */     //   28250: aload_0
/*      */     //   28251: getfield hsb : [[F
/*      */     //   28254: iload #9
/*      */     //   28256: aaload
/*      */     //   28257: iload #12
/*      */     //   28259: faload
/*      */     //   28260: fconst_1
/*      */     //   28261: fcmpl
/*      */     //   28262: ifgt -> 28270
/*      */     //   28265: goto_w -> 28286
/*      */     //   28270: aload_0
/*      */     //   28271: getfield hsb : [[F
/*      */     //   28274: iload #9
/*      */     //   28276: aaload
/*      */     //   28277: iload #12
/*      */     //   28279: fconst_1
/*      */     //   28280: fastore
/*      */     //   28281: goto_w -> 28286
/*      */     //   28286: aload_0
/*      */     //   28287: getfield hsb : [[F
/*      */     //   28290: iload #9
/*      */     //   28292: aaload
/*      */     //   28293: iload #12
/*      */     //   28295: faload
/*      */     //   28296: fconst_0
/*      */     //   28297: fcmpg
/*      */     //   28298: iflt -> 28306
/*      */     //   28301: goto_w -> 28322
/*      */     //   28306: aload_0
/*      */     //   28307: getfield hsb : [[F
/*      */     //   28310: iload #9
/*      */     //   28312: aaload
/*      */     //   28313: iload #12
/*      */     //   28315: fconst_0
/*      */     //   28316: fastore
/*      */     //   28317: goto_w -> 28322
/*      */     //   28322: iinc #11, 1
/*      */     //   28325: goto_w -> 27298
/*      */     //   28330: aload_0
/*      */     //   28331: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   28334: new java/awt/Color
/*      */     //   28337: dup
/*      */     //   28338: iconst_0
/*      */     //   28339: iconst_0
/*      */     //   28340: iconst_0
/*      */     //   28341: invokespecial <init> : (III)V
/*      */     //   28344: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   28347: aload_0
/*      */     //   28348: getfield texture : [I
/*      */     //   28351: iconst_3
/*      */     //   28352: iaload
/*      */     //   28353: bipush #20
/*      */     //   28355: isub
/*      */     //   28356: i2f
/*      */     //   28357: ldc_w 2.8
/*      */     //   28360: fmul
/*      */     //   28361: fstore #11
/*      */     //   28363: iload #9
/*      */     //   28365: ifeq -> 28373
/*      */     //   28368: goto_w -> 28391
/*      */     //   28373: aload_0
/*      */     //   28374: getfield cldd : [I
/*      */     //   28377: iconst_3
/*      */     //   28378: iaload
/*      */     //   28379: i2f
/*      */     //   28380: ldc_w 11.2
/*      */     //   28383: fmul
/*      */     //   28384: fstore #11
/*      */     //   28386: goto_w -> 28391
/*      */     //   28391: fload #11
/*      */     //   28393: fconst_0
/*      */     //   28394: fcmpg
/*      */     //   28395: iflt -> 28403
/*      */     //   28398: goto_w -> 28411
/*      */     //   28403: fconst_0
/*      */     //   28404: fstore #11
/*      */     //   28406: goto_w -> 28411
/*      */     //   28411: fload #11
/*      */     //   28413: ldc_w 112.0
/*      */     //   28416: fcmpl
/*      */     //   28417: ifgt -> 28425
/*      */     //   28420: goto_w -> 28435
/*      */     //   28425: ldc_w 112.0
/*      */     //   28428: fstore #11
/*      */     //   28430: goto_w -> 28435
/*      */     //   28435: aload_0
/*      */     //   28436: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   28439: bipush #70
/*      */     //   28441: sipush #225
/*      */     //   28444: iload #9
/*      */     //   28446: imul
/*      */     //   28447: iadd
/*      */     //   28448: i2f
/*      */     //   28449: fload #11
/*      */     //   28451: fadd
/*      */     //   28452: f2i
/*      */     //   28453: sipush #522
/*      */     //   28456: bipush #6
/*      */     //   28458: iload #9
/*      */     //   28460: imul
/*      */     //   28461: isub
/*      */     //   28462: bipush #70
/*      */     //   28464: sipush #225
/*      */     //   28467: iload #9
/*      */     //   28469: imul
/*      */     //   28470: iadd
/*      */     //   28471: i2f
/*      */     //   28472: fload #11
/*      */     //   28474: fadd
/*      */     //   28475: f2i
/*      */     //   28476: sipush #529
/*      */     //   28479: bipush #6
/*      */     //   28481: iload #9
/*      */     //   28483: imul
/*      */     //   28484: isub
/*      */     //   28485: invokevirtual drawLine : (IIII)V
/*      */     //   28488: aload_0
/*      */     //   28489: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   28492: bipush #71
/*      */     //   28494: sipush #225
/*      */     //   28497: iload #9
/*      */     //   28499: imul
/*      */     //   28500: iadd
/*      */     //   28501: i2f
/*      */     //   28502: fload #11
/*      */     //   28504: fadd
/*      */     //   28505: f2i
/*      */     //   28506: sipush #522
/*      */     //   28509: bipush #6
/*      */     //   28511: iload #9
/*      */     //   28513: imul
/*      */     //   28514: isub
/*      */     //   28515: bipush #71
/*      */     //   28517: sipush #225
/*      */     //   28520: iload #9
/*      */     //   28522: imul
/*      */     //   28523: iadd
/*      */     //   28524: i2f
/*      */     //   28525: fload #11
/*      */     //   28527: fadd
/*      */     //   28528: f2i
/*      */     //   28529: sipush #529
/*      */     //   28532: bipush #6
/*      */     //   28534: iload #9
/*      */     //   28536: imul
/*      */     //   28537: isub
/*      */     //   28538: invokevirtual drawLine : (IIII)V
/*      */     //   28541: aload_0
/*      */     //   28542: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   28545: bipush #69
/*      */     //   28547: sipush #225
/*      */     //   28550: iload #9
/*      */     //   28552: imul
/*      */     //   28553: iadd
/*      */     //   28554: i2f
/*      */     //   28555: fload #11
/*      */     //   28557: fadd
/*      */     //   28558: f2i
/*      */     //   28559: sipush #530
/*      */     //   28562: bipush #6
/*      */     //   28564: iload #9
/*      */     //   28566: imul
/*      */     //   28567: isub
/*      */     //   28568: iconst_4
/*      */     //   28569: iconst_2
/*      */     //   28570: invokevirtual fillRect : (IIII)V
/*      */     //   28573: aload_0
/*      */     //   28574: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   28577: bipush #68
/*      */     //   28579: sipush #225
/*      */     //   28582: iload #9
/*      */     //   28584: imul
/*      */     //   28585: iadd
/*      */     //   28586: i2f
/*      */     //   28587: fload #11
/*      */     //   28589: fadd
/*      */     //   28590: f2i
/*      */     //   28591: sipush #532
/*      */     //   28594: bipush #6
/*      */     //   28596: iload #9
/*      */     //   28598: imul
/*      */     //   28599: isub
/*      */     //   28600: bipush #73
/*      */     //   28602: sipush #225
/*      */     //   28605: iload #9
/*      */     //   28607: imul
/*      */     //   28608: iadd
/*      */     //   28609: i2f
/*      */     //   28610: fload #11
/*      */     //   28612: fadd
/*      */     //   28613: f2i
/*      */     //   28614: sipush #532
/*      */     //   28617: bipush #6
/*      */     //   28619: iload #9
/*      */     //   28621: imul
/*      */     //   28622: isub
/*      */     //   28623: invokevirtual drawLine : (IIII)V
/*      */     //   28626: aload_0
/*      */     //   28627: getfield xm : I
/*      */     //   28630: bipush #67
/*      */     //   28632: sipush #225
/*      */     //   28635: iload #9
/*      */     //   28637: imul
/*      */     //   28638: iadd
/*      */     //   28639: if_icmpgt -> 28647
/*      */     //   28642: goto_w -> 28751
/*      */     //   28647: aload_0
/*      */     //   28648: getfield xm : I
/*      */     //   28651: sipush #185
/*      */     //   28654: sipush #225
/*      */     //   28657: iload #9
/*      */     //   28659: imul
/*      */     //   28660: iadd
/*      */     //   28661: if_icmplt -> 28669
/*      */     //   28664: goto_w -> 28751
/*      */     //   28669: aload_0
/*      */     //   28670: getfield ym : I
/*      */     //   28673: sipush #522
/*      */     //   28676: bipush #6
/*      */     //   28678: iload #9
/*      */     //   28680: imul
/*      */     //   28681: isub
/*      */     //   28682: if_icmpgt -> 28690
/*      */     //   28685: goto_w -> 28751
/*      */     //   28690: aload_0
/*      */     //   28691: getfield ym : I
/*      */     //   28694: sipush #532
/*      */     //   28697: bipush #6
/*      */     //   28699: iload #9
/*      */     //   28701: imul
/*      */     //   28702: isub
/*      */     //   28703: if_icmplt -> 28711
/*      */     //   28706: goto_w -> 28751
/*      */     //   28711: aload_0
/*      */     //   28712: getfield mouses : I
/*      */     //   28715: iconst_1
/*      */     //   28716: if_icmpeq -> 28724
/*      */     //   28719: goto_w -> 28751
/*      */     //   28724: aload_0
/*      */     //   28725: getfield mouseon : I
/*      */     //   28728: iconst_m1
/*      */     //   28729: if_icmpeq -> 28737
/*      */     //   28732: goto_w -> 28751
/*      */     //   28737: aload_0
/*      */     //   28738: bipush #6
/*      */     //   28740: iload #9
/*      */     //   28742: iadd
/*      */     //   28743: putfield mouseon : I
/*      */     //   28746: goto_w -> 28751
/*      */     //   28751: iinc #9, 1
/*      */     //   28754: goto_w -> 27262
/*      */     //   28759: aload_0
/*      */     //   28760: getfield mouseon : I
/*      */     //   28763: bipush #6
/*      */     //   28765: if_icmpeq -> 28773
/*      */     //   28768: goto_w -> 28847
/*      */     //   28773: aload_0
/*      */     //   28774: getfield cldd : [I
/*      */     //   28777: iconst_3
/*      */     //   28778: aload_0
/*      */     //   28779: getfield xm : I
/*      */     //   28782: bipush #70
/*      */     //   28784: isub
/*      */     //   28785: i2f
/*      */     //   28786: ldc_w 11.2
/*      */     //   28789: fdiv
/*      */     //   28790: f2i
/*      */     //   28791: iastore
/*      */     //   28792: aload_0
/*      */     //   28793: getfield cldd : [I
/*      */     //   28796: iconst_3
/*      */     //   28797: iaload
/*      */     //   28798: iflt -> 28806
/*      */     //   28801: goto_w -> 28818
/*      */     //   28806: aload_0
/*      */     //   28807: getfield cldd : [I
/*      */     //   28810: iconst_3
/*      */     //   28811: iconst_0
/*      */     //   28812: iastore
/*      */     //   28813: goto_w -> 28818
/*      */     //   28818: aload_0
/*      */     //   28819: getfield cldd : [I
/*      */     //   28822: iconst_3
/*      */     //   28823: iaload
/*      */     //   28824: bipush #10
/*      */     //   28826: if_icmpgt -> 28834
/*      */     //   28829: goto_w -> 28847
/*      */     //   28834: aload_0
/*      */     //   28835: getfield cldd : [I
/*      */     //   28838: iconst_3
/*      */     //   28839: bipush #10
/*      */     //   28841: iastore
/*      */     //   28842: goto_w -> 28847
/*      */     //   28847: aload_0
/*      */     //   28848: getfield mouseon : I
/*      */     //   28851: bipush #7
/*      */     //   28853: if_icmpeq -> 28861
/*      */     //   28856: goto_w -> 28946
/*      */     //   28861: aload_0
/*      */     //   28862: getfield texture : [I
/*      */     //   28865: iconst_3
/*      */     //   28866: aload_0
/*      */     //   28867: getfield xm : I
/*      */     //   28870: bipush #70
/*      */     //   28872: isub
/*      */     //   28873: sipush #225
/*      */     //   28876: isub
/*      */     //   28877: i2d
/*      */     //   28878: ldc2_w 2.8
/*      */     //   28881: ddiv
/*      */     //   28882: ldc2_w 20.0
/*      */     //   28885: dadd
/*      */     //   28886: d2i
/*      */     //   28887: iastore
/*      */     //   28888: aload_0
/*      */     //   28889: getfield texture : [I
/*      */     //   28892: iconst_3
/*      */     //   28893: iaload
/*      */     //   28894: bipush #20
/*      */     //   28896: if_icmplt -> 28904
/*      */     //   28899: goto_w -> 28917
/*      */     //   28904: aload_0
/*      */     //   28905: getfield texture : [I
/*      */     //   28908: iconst_3
/*      */     //   28909: bipush #20
/*      */     //   28911: iastore
/*      */     //   28912: goto_w -> 28917
/*      */     //   28917: aload_0
/*      */     //   28918: getfield texture : [I
/*      */     //   28921: iconst_3
/*      */     //   28922: iaload
/*      */     //   28923: bipush #60
/*      */     //   28925: if_icmpgt -> 28933
/*      */     //   28928: goto_w -> 28946
/*      */     //   28933: aload_0
/*      */     //   28934: getfield texture : [I
/*      */     //   28937: iconst_3
/*      */     //   28938: bipush #60
/*      */     //   28940: iastore
/*      */     //   28941: goto_w -> 28946
/*      */     //   28946: aload_0
/*      */     //   28947: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   28950: new java/awt/Color
/*      */     //   28953: dup
/*      */     //   28954: iconst_0
/*      */     //   28955: sipush #128
/*      */     //   28958: sipush #255
/*      */     //   28961: invokespecial <init> : (III)V
/*      */     //   28964: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   28967: sipush #1500
/*      */     //   28970: aload_0
/*      */     //   28971: getfield cldd : [I
/*      */     //   28974: iconst_4
/*      */     //   28975: iaload
/*      */     //   28976: invokestatic abs : (I)I
/*      */     //   28979: isub
/*      */     //   28980: i2f
/*      */     //   28981: ldc_w 15.625
/*      */     //   28984: fdiv
/*      */     //   28985: fstore #9
/*      */     //   28987: fload #9
/*      */     //   28989: ldc_w 64.0
/*      */     //   28992: fcmpl
/*      */     //   28993: ifgt -> 29001
/*      */     //   28996: goto_w -> 29011
/*      */     //   29001: ldc_w 64.0
/*      */     //   29004: fstore #9
/*      */     //   29006: goto_w -> 29011
/*      */     //   29011: fload #9
/*      */     //   29013: fconst_0
/*      */     //   29014: fcmpg
/*      */     //   29015: iflt -> 29023
/*      */     //   29018: goto_w -> 29031
/*      */     //   29023: fconst_0
/*      */     //   29024: fstore #9
/*      */     //   29026: goto_w -> 29031
/*      */     //   29031: aload_0
/*      */     //   29032: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   29035: sipush #199
/*      */     //   29038: ldc_w 465.0
/*      */     //   29041: fload #9
/*      */     //   29043: fadd
/*      */     //   29044: f2i
/*      */     //   29045: bipush #12
/*      */     //   29047: iconst_2
/*      */     //   29048: invokevirtual drawRect : (IIII)V
/*      */     //   29051: aload_0
/*      */     //   29052: getfield xm : I
/*      */     //   29055: sipush #197
/*      */     //   29058: if_icmpgt -> 29066
/*      */     //   29061: goto_w -> 29148
/*      */     //   29066: aload_0
/*      */     //   29067: getfield xm : I
/*      */     //   29070: sipush #213
/*      */     //   29073: if_icmplt -> 29081
/*      */     //   29076: goto_w -> 29148
/*      */     //   29081: aload_0
/*      */     //   29082: getfield ym : I
/*      */     //   29085: sipush #463
/*      */     //   29088: if_icmpgt -> 29096
/*      */     //   29091: goto_w -> 29148
/*      */     //   29096: aload_0
/*      */     //   29097: getfield ym : I
/*      */     //   29100: sipush #533
/*      */     //   29103: if_icmplt -> 29111
/*      */     //   29106: goto_w -> 29148
/*      */     //   29111: aload_0
/*      */     //   29112: getfield mouses : I
/*      */     //   29115: iconst_1
/*      */     //   29116: if_icmpeq -> 29124
/*      */     //   29119: goto_w -> 29148
/*      */     //   29124: aload_0
/*      */     //   29125: getfield mouseon : I
/*      */     //   29128: iconst_m1
/*      */     //   29129: if_icmpeq -> 29137
/*      */     //   29132: goto_w -> 29148
/*      */     //   29137: aload_0
/*      */     //   29138: bipush #8
/*      */     //   29140: putfield mouseon : I
/*      */     //   29143: goto_w -> 29148
/*      */     //   29148: aload_0
/*      */     //   29149: getfield mouseon : I
/*      */     //   29152: bipush #8
/*      */     //   29154: if_icmpeq -> 29162
/*      */     //   29157: goto_w -> 29249
/*      */     //   29162: aload_0
/*      */     //   29163: getfield cldd : [I
/*      */     //   29166: iconst_4
/*      */     //   29167: sipush #530
/*      */     //   29170: aload_0
/*      */     //   29171: getfield ym : I
/*      */     //   29174: isub
/*      */     //   29175: i2f
/*      */     //   29176: ldc_w 15.625
/*      */     //   29179: fmul
/*      */     //   29180: ldc_w 500.0
/*      */     //   29183: fadd
/*      */     //   29184: f2i
/*      */     //   29185: ineg
/*      */     //   29186: iastore
/*      */     //   29187: aload_0
/*      */     //   29188: getfield cldd : [I
/*      */     //   29191: iconst_4
/*      */     //   29192: iaload
/*      */     //   29193: sipush #-500
/*      */     //   29196: if_icmpgt -> 29204
/*      */     //   29199: goto_w -> 29218
/*      */     //   29204: aload_0
/*      */     //   29205: getfield cldd : [I
/*      */     //   29208: iconst_4
/*      */     //   29209: sipush #-500
/*      */     //   29212: iastore
/*      */     //   29213: goto_w -> 29218
/*      */     //   29218: aload_0
/*      */     //   29219: getfield cldd : [I
/*      */     //   29222: iconst_4
/*      */     //   29223: iaload
/*      */     //   29224: sipush #-1500
/*      */     //   29227: if_icmplt -> 29235
/*      */     //   29230: goto_w -> 29249
/*      */     //   29235: aload_0
/*      */     //   29236: getfield cldd : [I
/*      */     //   29239: iconst_4
/*      */     //   29240: sipush #-1500
/*      */     //   29243: iastore
/*      */     //   29244: goto_w -> 29249
/*      */     //   29249: aload_0
/*      */     //   29250: getfield hsb : [[F
/*      */     //   29253: iconst_0
/*      */     //   29254: aaload
/*      */     //   29255: iconst_0
/*      */     //   29256: faload
/*      */     //   29257: aload_0
/*      */     //   29258: getfield hsb : [[F
/*      */     //   29261: iconst_0
/*      */     //   29262: aaload
/*      */     //   29263: iconst_1
/*      */     //   29264: faload
/*      */     //   29265: aload_0
/*      */     //   29266: getfield hsb : [[F
/*      */     //   29269: iconst_0
/*      */     //   29270: aaload
/*      */     //   29271: iconst_2
/*      */     //   29272: faload
/*      */     //   29273: invokestatic getHSBColor : (FFF)Ljava/awt/Color;
/*      */     //   29276: astore #10
/*      */     //   29278: aload_0
/*      */     //   29279: getfield m : LMedium;
/*      */     //   29282: aload #10
/*      */     //   29284: invokevirtual getRed : ()I
/*      */     //   29287: aload #10
/*      */     //   29289: invokevirtual getGreen : ()I
/*      */     //   29292: aload #10
/*      */     //   29294: invokevirtual getBlue : ()I
/*      */     //   29297: aload_0
/*      */     //   29298: getfield cldd : [I
/*      */     //   29301: iconst_3
/*      */     //   29302: iaload
/*      */     //   29303: aload_0
/*      */     //   29304: getfield cldd : [I
/*      */     //   29307: iconst_4
/*      */     //   29308: iaload
/*      */     //   29309: invokevirtual setcloads : (IIIII)V
/*      */     //   29312: aload_0
/*      */     //   29313: getfield cldd : [I
/*      */     //   29316: iconst_0
/*      */     //   29317: aload #10
/*      */     //   29319: invokevirtual getRed : ()I
/*      */     //   29322: iastore
/*      */     //   29323: aload_0
/*      */     //   29324: getfield cldd : [I
/*      */     //   29327: iconst_1
/*      */     //   29328: aload #10
/*      */     //   29330: invokevirtual getGreen : ()I
/*      */     //   29333: iastore
/*      */     //   29334: aload_0
/*      */     //   29335: getfield cldd : [I
/*      */     //   29338: iconst_2
/*      */     //   29339: aload #10
/*      */     //   29341: invokevirtual getBlue : ()I
/*      */     //   29344: iastore
/*      */     //   29345: aload_0
/*      */     //   29346: getfield hsb : [[F
/*      */     //   29349: iconst_1
/*      */     //   29350: aaload
/*      */     //   29351: iconst_0
/*      */     //   29352: faload
/*      */     //   29353: aload_0
/*      */     //   29354: getfield hsb : [[F
/*      */     //   29357: iconst_1
/*      */     //   29358: aaload
/*      */     //   29359: iconst_1
/*      */     //   29360: faload
/*      */     //   29361: aload_0
/*      */     //   29362: getfield hsb : [[F
/*      */     //   29365: iconst_1
/*      */     //   29366: aaload
/*      */     //   29367: iconst_2
/*      */     //   29368: faload
/*      */     //   29369: invokestatic getHSBColor : (FFF)Ljava/awt/Color;
/*      */     //   29372: astore #10
/*      */     //   29374: aload_0
/*      */     //   29375: getfield m : LMedium;
/*      */     //   29378: aload #10
/*      */     //   29380: invokevirtual getRed : ()I
/*      */     //   29383: aload #10
/*      */     //   29385: invokevirtual getGreen : ()I
/*      */     //   29388: aload #10
/*      */     //   29390: invokevirtual getBlue : ()I
/*      */     //   29393: aload_0
/*      */     //   29394: getfield texture : [I
/*      */     //   29397: iconst_3
/*      */     //   29398: iaload
/*      */     //   29399: invokevirtual setexture : (IIII)V
/*      */     //   29402: aload_0
/*      */     //   29403: getfield texture : [I
/*      */     //   29406: iconst_0
/*      */     //   29407: aload #10
/*      */     //   29409: invokevirtual getRed : ()I
/*      */     //   29412: iastore
/*      */     //   29413: aload_0
/*      */     //   29414: getfield texture : [I
/*      */     //   29417: iconst_1
/*      */     //   29418: aload #10
/*      */     //   29420: invokevirtual getGreen : ()I
/*      */     //   29423: iastore
/*      */     //   29424: aload_0
/*      */     //   29425: getfield texture : [I
/*      */     //   29428: iconst_2
/*      */     //   29429: aload #10
/*      */     //   29431: invokevirtual getBlue : ()I
/*      */     //   29434: iastore
/*      */     //   29435: aload_0
/*      */     //   29436: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   29439: new java/awt/Font
/*      */     //   29442: dup
/*      */     //   29443: ldc_w 'Arial'
/*      */     //   29446: iconst_1
/*      */     //   29447: bipush #12
/*      */     //   29449: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   29452: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   29455: aload_0
/*      */     //   29456: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   29459: new java/awt/Color
/*      */     //   29462: dup
/*      */     //   29463: iconst_0
/*      */     //   29464: iconst_0
/*      */     //   29465: iconst_0
/*      */     //   29466: invokespecial <init> : (III)V
/*      */     //   29469: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   29472: aload_0
/*      */     //   29473: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   29476: ldc_w 'Mountains'
/*      */     //   29479: sipush #452
/*      */     //   29482: sipush #465
/*      */     //   29485: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   29488: aload_0
/*      */     //   29489: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   29492: new java/awt/Font
/*      */     //   29495: dup
/*      */     //   29496: ldc_w 'Arial'
/*      */     //   29499: iconst_0
/*      */     //   29500: bipush #11
/*      */     //   29502: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   29505: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   29508: aload_0
/*      */     //   29509: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   29512: ldc_w 'Mountain Generator Key:'
/*      */     //   29515: sipush #452
/*      */     //   29518: sipush #480
/*      */     //   29521: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   29524: aload_0
/*      */     //   29525: aload_0
/*      */     //   29526: getfield mgen : Ljava/awt/TextField;
/*      */     //   29529: sipush #452
/*      */     //   29532: sipush #484
/*      */     //   29535: bipush #120
/*      */     //   29537: bipush #20
/*      */     //   29539: invokevirtual movefield : (Ljava/awt/Component;IIII)V
/*      */     //   29542: aload_0
/*      */     //   29543: getfield mgen : Ljava/awt/TextField;
/*      */     //   29546: invokevirtual hasFocus : ()Z
/*      */     //   29549: ifne -> 29557
/*      */     //   29552: goto_w -> 29567
/*      */     //   29557: aload_0
/*      */     //   29558: iconst_0
/*      */     //   29559: putfield focuson : Z
/*      */     //   29562: goto_w -> 29567
/*      */     //   29567: aload_0
/*      */     //   29568: getfield mgen : Ljava/awt/TextField;
/*      */     //   29571: invokevirtual isShowing : ()Z
/*      */     //   29574: ifeq -> 29582
/*      */     //   29577: goto_w -> 29594
/*      */     //   29582: aload_0
/*      */     //   29583: getfield mgen : Ljava/awt/TextField;
/*      */     //   29586: invokevirtual show : ()V
/*      */     //   29589: goto_w -> 29594
/*      */     //   29594: aload_0
/*      */     //   29595: ldc_w '  Generate New  '
/*      */     //   29598: sipush #512
/*      */     //   29601: sipush #525
/*      */     //   29604: iconst_3
/*      */     //   29605: iconst_1
/*      */     //   29606: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   29609: ifne -> 29617
/*      */     //   29612: goto_w -> 29713
/*      */     //   29617: aload_0
/*      */     //   29618: getfield m : LMedium;
/*      */     //   29621: invokestatic random : ()D
/*      */     //   29624: ldc2_w 100000.0
/*      */     //   29627: dmul
/*      */     //   29628: d2i
/*      */     //   29629: putfield mgen : I
/*      */     //   29632: aload_0
/*      */     //   29633: getfield mgen : Ljava/awt/TextField;
/*      */     //   29636: new java/lang/StringBuilder
/*      */     //   29639: dup
/*      */     //   29640: invokespecial <init> : ()V
/*      */     //   29643: ldc ''
/*      */     //   29645: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   29648: aload_0
/*      */     //   29649: getfield m : LMedium;
/*      */     //   29652: getfield mgen : I
/*      */     //   29655: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   29658: ldc ''
/*      */     //   29660: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   29663: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   29666: invokevirtual setText : (Ljava/lang/String;)V
/*      */     //   29669: aload_0
/*      */     //   29670: getfield ttstage : Ljava/lang/String;
/*      */     //   29673: ldc ''
/*      */     //   29675: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   29678: ifne -> 29686
/*      */     //   29681: goto_w -> 29699
/*      */     //   29686: aload_0
/*      */     //   29687: aload_0
/*      */     //   29688: getfield tstage : Ljava/lang/String;
/*      */     //   29691: putfield ttstage : Ljava/lang/String;
/*      */     //   29694: goto_w -> 29699
/*      */     //   29699: aload_0
/*      */     //   29700: invokevirtual sortop : ()V
/*      */     //   29703: aload_0
/*      */     //   29704: iconst_1
/*      */     //   29705: invokevirtual readstage : (I)V
/*      */     //   29708: goto_w -> 29713
/*      */     //   29713: aload_0
/*      */     //   29714: getfield mgen : Ljava/awt/TextField;
/*      */     //   29717: invokevirtual getText : ()Ljava/lang/String;
/*      */     //   29720: new java/lang/StringBuilder
/*      */     //   29723: dup
/*      */     //   29724: invokespecial <init> : ()V
/*      */     //   29727: ldc ''
/*      */     //   29729: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   29732: aload_0
/*      */     //   29733: getfield m : LMedium;
/*      */     //   29736: getfield mgen : I
/*      */     //   29739: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   29742: ldc ''
/*      */     //   29744: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   29747: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   29750: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   29753: ifeq -> 29761
/*      */     //   29756: goto_w -> 29873
/*      */     //   29761: aload_0
/*      */     //   29762: getfield mgen : Ljava/awt/TextField;
/*      */     //   29765: invokevirtual getText : ()Ljava/lang/String;
/*      */     //   29768: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
/*      */     //   29771: invokevirtual intValue : ()I
/*      */     //   29774: istore #11
/*      */     //   29776: aload_0
/*      */     //   29777: getfield m : LMedium;
/*      */     //   29780: iload #11
/*      */     //   29782: putfield mgen : I
/*      */     //   29785: aload_0
/*      */     //   29786: getfield ttstage : Ljava/lang/String;
/*      */     //   29789: ldc ''
/*      */     //   29791: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   29794: ifne -> 29802
/*      */     //   29797: goto_w -> 29815
/*      */     //   29802: aload_0
/*      */     //   29803: aload_0
/*      */     //   29804: getfield tstage : Ljava/lang/String;
/*      */     //   29807: putfield ttstage : Ljava/lang/String;
/*      */     //   29810: goto_w -> 29815
/*      */     //   29815: aload_0
/*      */     //   29816: invokevirtual sortop : ()V
/*      */     //   29819: aload_0
/*      */     //   29820: iconst_1
/*      */     //   29821: invokevirtual readstage : (I)V
/*      */     //   29824: goto_w -> 29873
/*      */     //   29829: astore #11
/*      */     //   29831: aload_0
/*      */     //   29832: getfield mgen : Ljava/awt/TextField;
/*      */     //   29835: new java/lang/StringBuilder
/*      */     //   29838: dup
/*      */     //   29839: invokespecial <init> : ()V
/*      */     //   29842: ldc ''
/*      */     //   29844: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   29847: aload_0
/*      */     //   29848: getfield m : LMedium;
/*      */     //   29851: getfield mgen : I
/*      */     //   29854: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   29857: ldc ''
/*      */     //   29859: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   29862: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   29865: invokevirtual setText : (Ljava/lang/String;)V
/*      */     //   29868: goto_w -> 29873
/*      */     //   29873: aload_0
/*      */     //   29874: ldc_w ' Reset '
/*      */     //   29877: sipush #650
/*      */     //   29880: sipush #510
/*      */     //   29883: iconst_0
/*      */     //   29884: iconst_1
/*      */     //   29885: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   29888: ifne -> 29896
/*      */     //   29891: goto_w -> 29948
/*      */     //   29896: aload_0
/*      */     //   29897: getfield ttstage : Ljava/lang/String;
/*      */     //   29900: ldc ''
/*      */     //   29902: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   29905: ifeq -> 29913
/*      */     //   29908: goto_w -> 29932
/*      */     //   29913: aload_0
/*      */     //   29914: aload_0
/*      */     //   29915: getfield ttstage : Ljava/lang/String;
/*      */     //   29918: putfield tstage : Ljava/lang/String;
/*      */     //   29921: aload_0
/*      */     //   29922: ldc ''
/*      */     //   29924: putfield ttstage : Ljava/lang/String;
/*      */     //   29927: goto_w -> 29932
/*      */     //   29932: aload_0
/*      */     //   29933: iconst_1
/*      */     //   29934: invokevirtual readstage : (I)V
/*      */     //   29937: aload_0
/*      */     //   29938: bipush #-2
/*      */     //   29940: putfield dtabed : I
/*      */     //   29943: goto_w -> 29948
/*      */     //   29948: aload_0
/*      */     //   29949: ldc_w '        Save        '
/*      */     //   29952: sipush #737
/*      */     //   29955: sipush #510
/*      */     //   29958: iconst_0
/*      */     //   29959: iconst_1
/*      */     //   29960: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   29963: ifne -> 29971
/*      */     //   29966: goto_w -> 29990
/*      */     //   29971: aload_0
/*      */     //   29972: invokevirtual sortop : ()V
/*      */     //   29975: aload_0
/*      */     //   29976: ldc ''
/*      */     //   29978: putfield ttstage : Ljava/lang/String;
/*      */     //   29981: aload_0
/*      */     //   29982: invokevirtual savefile : ()V
/*      */     //   29985: goto_w -> 29990
/*      */     //   29990: goto_w -> 29995
/*      */     //   29995: aload_0
/*      */     //   29996: getfield dtab : I
/*      */     //   29999: iconst_1
/*      */     //   30000: if_icmpeq -> 30008
/*      */     //   30003: goto_w -> 32199
/*      */     //   30008: aload_0
/*      */     //   30009: getfield dtabed : I
/*      */     //   30012: aload_0
/*      */     //   30013: getfield dtab : I
/*      */     //   30016: if_icmpne -> 30024
/*      */     //   30019: goto_w -> 30125
/*      */     //   30024: iconst_0
/*      */     //   30025: istore #7
/*      */     //   30027: iload #7
/*      */     //   30029: iconst_3
/*      */     //   30030: if_icmplt -> 30038
/*      */     //   30033: goto_w -> 30073
/*      */     //   30038: aload_0
/*      */     //   30039: getfield snap : [I
/*      */     //   30042: iload #7
/*      */     //   30044: aload_0
/*      */     //   30045: getfield m : LMedium;
/*      */     //   30048: getfield snap : [I
/*      */     //   30051: iload #7
/*      */     //   30053: iaload
/*      */     //   30054: i2f
/*      */     //   30055: ldc_w 1.2
/*      */     //   30058: fdiv
/*      */     //   30059: ldc_w 50.0
/*      */     //   30062: fadd
/*      */     //   30063: f2i
/*      */     //   30064: iastore
/*      */     //   30065: iinc #7, 1
/*      */     //   30068: goto_w -> 30027
/*      */     //   30073: aload_0
/*      */     //   30074: getfield fogn : [I
/*      */     //   30077: iconst_0
/*      */     //   30078: bipush #8
/*      */     //   30080: aload_0
/*      */     //   30081: getfield m : LMedium;
/*      */     //   30084: getfield fogd : I
/*      */     //   30087: iconst_1
/*      */     //   30088: iadd
/*      */     //   30089: iconst_2
/*      */     //   30090: idiv
/*      */     //   30091: iconst_1
/*      */     //   30092: isub
/*      */     //   30093: isub
/*      */     //   30094: bipush #20
/*      */     //   30096: imul
/*      */     //   30097: iastore
/*      */     //   30098: aload_0
/*      */     //   30099: getfield fogn : [I
/*      */     //   30102: iconst_1
/*      */     //   30103: aload_0
/*      */     //   30104: getfield m : LMedium;
/*      */     //   30107: getfield fade : [I
/*      */     //   30110: iconst_0
/*      */     //   30111: iaload
/*      */     //   30112: sipush #5000
/*      */     //   30115: isub
/*      */     //   30116: bipush #30
/*      */     //   30118: idiv
/*      */     //   30119: iastore
/*      */     //   30120: goto_w -> 30125
/*      */     //   30125: aload_0
/*      */     //   30126: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30129: new java/awt/Color
/*      */     //   30132: dup
/*      */     //   30133: iconst_0
/*      */     //   30134: iconst_0
/*      */     //   30135: iconst_0
/*      */     //   30136: invokespecial <init> : (III)V
/*      */     //   30139: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   30142: aload_0
/*      */     //   30143: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30146: ldc_w 'Atmosphere RGB Mask'
/*      */     //   30149: bipush #20
/*      */     //   30151: sipush #461
/*      */     //   30154: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   30157: aload_0
/*      */     //   30158: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30161: new java/awt/Color
/*      */     //   30164: dup
/*      */     //   30165: sipush #128
/*      */     //   30168: sipush #128
/*      */     //   30171: sipush #128
/*      */     //   30174: invokespecial <init> : (III)V
/*      */     //   30177: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   30180: aload_0
/*      */     //   30181: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30184: bipush #10
/*      */     //   30186: sipush #457
/*      */     //   30189: bipush #17
/*      */     //   30191: sipush #457
/*      */     //   30194: invokevirtual drawLine : (IIII)V
/*      */     //   30197: aload_0
/*      */     //   30198: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30201: sipush #260
/*      */     //   30204: sipush #457
/*      */     //   30207: sipush #152
/*      */     //   30210: sipush #457
/*      */     //   30213: invokevirtual drawLine : (IIII)V
/*      */     //   30216: aload_0
/*      */     //   30217: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30220: bipush #10
/*      */     //   30222: sipush #457
/*      */     //   30225: bipush #10
/*      */     //   30227: sipush #546
/*      */     //   30230: invokevirtual drawLine : (IIII)V
/*      */     //   30233: aload_0
/*      */     //   30234: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30237: sipush #260
/*      */     //   30240: sipush #457
/*      */     //   30243: sipush #260
/*      */     //   30246: sipush #527
/*      */     //   30249: invokevirtual drawLine : (IIII)V
/*      */     //   30252: aload_0
/*      */     //   30253: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30256: sipush #260
/*      */     //   30259: sipush #527
/*      */     //   30262: sipush #360
/*      */     //   30265: sipush #527
/*      */     //   30268: invokevirtual drawLine : (IIII)V
/*      */     //   30271: aload_0
/*      */     //   30272: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30275: bipush #10
/*      */     //   30277: sipush #546
/*      */     //   30280: sipush #360
/*      */     //   30283: sipush #546
/*      */     //   30286: invokevirtual drawLine : (IIII)V
/*      */     //   30289: aload_0
/*      */     //   30290: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30293: sipush #360
/*      */     //   30296: sipush #527
/*      */     //   30299: sipush #360
/*      */     //   30302: sipush #546
/*      */     //   30305: invokevirtual drawLine : (IIII)V
/*      */     //   30308: iconst_3
/*      */     //   30309: anewarray java/lang/String
/*      */     //   30312: dup
/*      */     //   30313: iconst_0
/*      */     //   30314: ldc_w 'Red'
/*      */     //   30317: aastore
/*      */     //   30318: dup
/*      */     //   30319: iconst_1
/*      */     //   30320: ldc_w 'Green'
/*      */     //   30323: aastore
/*      */     //   30324: dup
/*      */     //   30325: iconst_2
/*      */     //   30326: ldc_w 'Blue'
/*      */     //   30329: aastore
/*      */     //   30330: astore #7
/*      */     //   30332: iconst_3
/*      */     //   30333: newarray int
/*      */     //   30335: dup
/*      */     //   30336: iconst_0
/*      */     //   30337: bipush #32
/*      */     //   30339: iastore
/*      */     //   30340: dup
/*      */     //   30341: iconst_1
/*      */     //   30342: bipush #20
/*      */     //   30344: iastore
/*      */     //   30345: dup
/*      */     //   30346: iconst_2
/*      */     //   30347: bipush #29
/*      */     //   30349: iastore
/*      */     //   30350: astore #8
/*      */     //   30352: bipush #38
/*      */     //   30354: istore #9
/*      */     //   30356: bipush #-70
/*      */     //   30358: istore #10
/*      */     //   30360: iconst_0
/*      */     //   30361: istore #11
/*      */     //   30363: iload #11
/*      */     //   30365: iconst_3
/*      */     //   30366: if_icmplt -> 30374
/*      */     //   30369: goto_w -> 30989
/*      */     //   30374: aload_0
/*      */     //   30375: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30378: new java/awt/Color
/*      */     //   30381: dup
/*      */     //   30382: iconst_0
/*      */     //   30383: iconst_0
/*      */     //   30384: iconst_0
/*      */     //   30385: invokespecial <init> : (III)V
/*      */     //   30388: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   30391: aload_0
/*      */     //   30392: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30395: new java/lang/StringBuilder
/*      */     //   30398: dup
/*      */     //   30399: invokespecial <init> : ()V
/*      */     //   30402: ldc ''
/*      */     //   30404: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   30407: aload #7
/*      */     //   30409: iload #11
/*      */     //   30411: aaload
/*      */     //   30412: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   30415: ldc_w ' :'
/*      */     //   30418: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   30421: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   30424: aload #8
/*      */     //   30426: iload #11
/*      */     //   30428: iaload
/*      */     //   30429: sipush #447
/*      */     //   30432: iload #11
/*      */     //   30434: bipush #24
/*      */     //   30436: imul
/*      */     //   30437: iadd
/*      */     //   30438: iload #9
/*      */     //   30440: iadd
/*      */     //   30441: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   30444: aload_0
/*      */     //   30445: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30448: sipush #140
/*      */     //   30451: iload #10
/*      */     //   30453: iadd
/*      */     //   30454: sipush #443
/*      */     //   30457: iload #11
/*      */     //   30459: bipush #24
/*      */     //   30461: imul
/*      */     //   30462: iload #9
/*      */     //   30464: iadd
/*      */     //   30465: iadd
/*      */     //   30466: sipush #230
/*      */     //   30469: iload #10
/*      */     //   30471: iadd
/*      */     //   30472: sipush #443
/*      */     //   30475: iload #11
/*      */     //   30477: bipush #24
/*      */     //   30479: imul
/*      */     //   30480: iadd
/*      */     //   30481: iload #9
/*      */     //   30483: iadd
/*      */     //   30484: invokevirtual drawLine : (IIII)V
/*      */     //   30487: iconst_1
/*      */     //   30488: istore #12
/*      */     //   30490: iload #12
/*      */     //   30492: bipush #10
/*      */     //   30494: if_icmplt -> 30502
/*      */     //   30497: goto_w -> 30571
/*      */     //   30502: aload_0
/*      */     //   30503: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30506: sipush #140
/*      */     //   30509: bipush #10
/*      */     //   30511: iload #12
/*      */     //   30513: imul
/*      */     //   30514: iadd
/*      */     //   30515: iload #10
/*      */     //   30517: iadd
/*      */     //   30518: sipush #443
/*      */     //   30521: iload #12
/*      */     //   30523: isub
/*      */     //   30524: iload #11
/*      */     //   30526: bipush #24
/*      */     //   30528: imul
/*      */     //   30529: iadd
/*      */     //   30530: iload #9
/*      */     //   30532: iadd
/*      */     //   30533: sipush #140
/*      */     //   30536: bipush #10
/*      */     //   30538: iload #12
/*      */     //   30540: imul
/*      */     //   30541: iadd
/*      */     //   30542: iload #10
/*      */     //   30544: iadd
/*      */     //   30545: sipush #443
/*      */     //   30548: iload #12
/*      */     //   30550: iadd
/*      */     //   30551: iload #11
/*      */     //   30553: bipush #24
/*      */     //   30555: imul
/*      */     //   30556: iadd
/*      */     //   30557: iload #9
/*      */     //   30559: iadd
/*      */     //   30560: invokevirtual drawLine : (IIII)V
/*      */     //   30563: iinc #12, 1
/*      */     //   30566: goto_w -> 30490
/*      */     //   30571: aload_0
/*      */     //   30572: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30575: new java/awt/Color
/*      */     //   30578: dup
/*      */     //   30579: sipush #255
/*      */     //   30582: iconst_0
/*      */     //   30583: iconst_0
/*      */     //   30584: invokespecial <init> : (III)V
/*      */     //   30587: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   30590: aload_0
/*      */     //   30591: getfield snap : [I
/*      */     //   30594: iload #11
/*      */     //   30596: iaload
/*      */     //   30597: i2f
/*      */     //   30598: ldc_w 1.1111
/*      */     //   30601: fdiv
/*      */     //   30602: ldc_w 10.0
/*      */     //   30605: fdiv
/*      */     //   30606: f2i
/*      */     //   30607: istore #12
/*      */     //   30609: aload_0
/*      */     //   30610: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30613: sipush #138
/*      */     //   30616: aload_0
/*      */     //   30617: getfield snap : [I
/*      */     //   30620: iload #11
/*      */     //   30622: iaload
/*      */     //   30623: i2f
/*      */     //   30624: ldc_w 1.1111
/*      */     //   30627: fdiv
/*      */     //   30628: f2i
/*      */     //   30629: iadd
/*      */     //   30630: iload #10
/*      */     //   30632: iadd
/*      */     //   30633: sipush #443
/*      */     //   30636: iload #12
/*      */     //   30638: isub
/*      */     //   30639: iload #11
/*      */     //   30641: bipush #24
/*      */     //   30643: imul
/*      */     //   30644: iadd
/*      */     //   30645: iload #9
/*      */     //   30647: iadd
/*      */     //   30648: iconst_5
/*      */     //   30649: iload #12
/*      */     //   30651: iconst_2
/*      */     //   30652: imul
/*      */     //   30653: iconst_1
/*      */     //   30654: iadd
/*      */     //   30655: invokevirtual fillRect : (IIII)V
/*      */     //   30658: aload_0
/*      */     //   30659: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30662: new java/awt/Color
/*      */     //   30665: dup
/*      */     //   30666: sipush #255
/*      */     //   30669: sipush #128
/*      */     //   30672: iconst_0
/*      */     //   30673: invokespecial <init> : (III)V
/*      */     //   30676: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   30679: aload_0
/*      */     //   30680: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   30683: sipush #139
/*      */     //   30686: aload_0
/*      */     //   30687: getfield snap : [I
/*      */     //   30690: iload #11
/*      */     //   30692: iaload
/*      */     //   30693: i2f
/*      */     //   30694: ldc_w 1.1111
/*      */     //   30697: fdiv
/*      */     //   30698: f2i
/*      */     //   30699: iadd
/*      */     //   30700: iload #10
/*      */     //   30702: iadd
/*      */     //   30703: sipush #434
/*      */     //   30706: iload #11
/*      */     //   30708: bipush #24
/*      */     //   30710: imul
/*      */     //   30711: iadd
/*      */     //   30712: iload #9
/*      */     //   30714: iadd
/*      */     //   30715: iconst_2
/*      */     //   30716: bipush #18
/*      */     //   30718: invokevirtual drawRect : (IIII)V
/*      */     //   30721: aload_0
/*      */     //   30722: ldc_w ' - '
/*      */     //   30725: sipush #260
/*      */     //   30728: iload #10
/*      */     //   30730: iadd
/*      */     //   30731: sipush #447
/*      */     //   30734: iload #11
/*      */     //   30736: bipush #24
/*      */     //   30738: imul
/*      */     //   30739: iadd
/*      */     //   30740: iload #9
/*      */     //   30742: iadd
/*      */     //   30743: iconst_4
/*      */     //   30744: iconst_0
/*      */     //   30745: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   30748: ifne -> 30756
/*      */     //   30751: goto_w -> 30795
/*      */     //   30756: aload_0
/*      */     //   30757: getfield snap : [I
/*      */     //   30760: iload #11
/*      */     //   30762: dup2
/*      */     //   30763: iaload
/*      */     //   30764: iconst_2
/*      */     //   30765: isub
/*      */     //   30766: iastore
/*      */     //   30767: aload_0
/*      */     //   30768: getfield snap : [I
/*      */     //   30771: iload #11
/*      */     //   30773: iaload
/*      */     //   30774: iflt -> 30782
/*      */     //   30777: goto_w -> 30795
/*      */     //   30782: aload_0
/*      */     //   30783: getfield snap : [I
/*      */     //   30786: iload #11
/*      */     //   30788: iconst_0
/*      */     //   30789: iastore
/*      */     //   30790: goto_w -> 30795
/*      */     //   30795: aload_0
/*      */     //   30796: ldc_w ' + '
/*      */     //   30799: sipush #300
/*      */     //   30802: iload #10
/*      */     //   30804: iadd
/*      */     //   30805: sipush #447
/*      */     //   30808: iload #11
/*      */     //   30810: bipush #24
/*      */     //   30812: imul
/*      */     //   30813: iadd
/*      */     //   30814: iload #9
/*      */     //   30816: iadd
/*      */     //   30817: iconst_4
/*      */     //   30818: iconst_0
/*      */     //   30819: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   30822: ifne -> 30830
/*      */     //   30825: goto_w -> 30981
/*      */     //   30830: aload_0
/*      */     //   30831: getfield snap : [I
/*      */     //   30834: iconst_0
/*      */     //   30835: iaload
/*      */     //   30836: aload_0
/*      */     //   30837: getfield snap : [I
/*      */     //   30840: iconst_1
/*      */     //   30841: iaload
/*      */     //   30842: iadd
/*      */     //   30843: aload_0
/*      */     //   30844: getfield snap : [I
/*      */     //   30847: iconst_2
/*      */     //   30848: iaload
/*      */     //   30849: iadd
/*      */     //   30850: sipush #200
/*      */     //   30853: if_icmpgt -> 30861
/*      */     //   30856: goto_w -> 30939
/*      */     //   30861: iconst_0
/*      */     //   30862: istore #13
/*      */     //   30864: iload #13
/*      */     //   30866: iconst_3
/*      */     //   30867: if_icmplt -> 30875
/*      */     //   30870: goto_w -> 30934
/*      */     //   30875: iload #13
/*      */     //   30877: iload #11
/*      */     //   30879: if_icmpne -> 30887
/*      */     //   30882: goto_w -> 30926
/*      */     //   30887: aload_0
/*      */     //   30888: getfield snap : [I
/*      */     //   30891: iload #13
/*      */     //   30893: dup2
/*      */     //   30894: iaload
/*      */     //   30895: iconst_1
/*      */     //   30896: isub
/*      */     //   30897: iastore
/*      */     //   30898: aload_0
/*      */     //   30899: getfield snap : [I
/*      */     //   30902: iload #13
/*      */     //   30904: iaload
/*      */     //   30905: iflt -> 30913
/*      */     //   30908: goto_w -> 30926
/*      */     //   30913: aload_0
/*      */     //   30914: getfield snap : [I
/*      */     //   30917: iload #13
/*      */     //   30919: iconst_0
/*      */     //   30920: iastore
/*      */     //   30921: goto_w -> 30926
/*      */     //   30926: iinc #13, 1
/*      */     //   30929: goto_w -> 30864
/*      */     //   30934: goto_w -> 30939
/*      */     //   30939: aload_0
/*      */     //   30940: getfield snap : [I
/*      */     //   30943: iload #11
/*      */     //   30945: dup2
/*      */     //   30946: iaload
/*      */     //   30947: iconst_2
/*      */     //   30948: iadd
/*      */     //   30949: iastore
/*      */     //   30950: aload_0
/*      */     //   30951: getfield snap : [I
/*      */     //   30954: iload #11
/*      */     //   30956: iaload
/*      */     //   30957: bipush #100
/*      */     //   30959: if_icmpgt -> 30967
/*      */     //   30962: goto_w -> 30981
/*      */     //   30967: aload_0
/*      */     //   30968: getfield snap : [I
/*      */     //   30971: iload #11
/*      */     //   30973: bipush #100
/*      */     //   30975: iastore
/*      */     //   30976: goto_w -> 30981
/*      */     //   30981: iinc #11, 1
/*      */     //   30984: goto_w -> 30363
/*      */     //   30989: aload_0
/*      */     //   30990: getfield m : LMedium;
/*      */     //   30993: getfield snap : [I
/*      */     //   30996: iconst_0
/*      */     //   30997: iaload
/*      */     //   30998: aload_0
/*      */     //   30999: getfield snap : [I
/*      */     //   31002: iconst_0
/*      */     //   31003: iaload
/*      */     //   31004: i2f
/*      */     //   31005: ldc_w 1.2
/*      */     //   31008: fmul
/*      */     //   31009: ldc_w 60.0
/*      */     //   31012: fsub
/*      */     //   31013: f2i
/*      */     //   31014: if_icmpeq -> 31022
/*      */     //   31017: goto_w -> 31088
/*      */     //   31022: aload_0
/*      */     //   31023: getfield m : LMedium;
/*      */     //   31026: getfield snap : [I
/*      */     //   31029: iconst_1
/*      */     //   31030: iaload
/*      */     //   31031: aload_0
/*      */     //   31032: getfield snap : [I
/*      */     //   31035: iconst_1
/*      */     //   31036: iaload
/*      */     //   31037: i2f
/*      */     //   31038: ldc_w 1.2
/*      */     //   31041: fmul
/*      */     //   31042: ldc_w 60.0
/*      */     //   31045: fsub
/*      */     //   31046: f2i
/*      */     //   31047: if_icmpeq -> 31055
/*      */     //   31050: goto_w -> 31088
/*      */     //   31055: aload_0
/*      */     //   31056: getfield m : LMedium;
/*      */     //   31059: getfield snap : [I
/*      */     //   31062: iconst_2
/*      */     //   31063: iaload
/*      */     //   31064: aload_0
/*      */     //   31065: getfield snap : [I
/*      */     //   31068: iconst_2
/*      */     //   31069: iaload
/*      */     //   31070: i2f
/*      */     //   31071: ldc_w 1.2
/*      */     //   31074: fmul
/*      */     //   31075: ldc_w 60.0
/*      */     //   31078: fsub
/*      */     //   31079: f2i
/*      */     //   31080: if_icmpne -> 31088
/*      */     //   31083: goto_w -> 31147
/*      */     //   31088: iconst_0
/*      */     //   31089: istore #11
/*      */     //   31091: iload #11
/*      */     //   31093: iconst_3
/*      */     //   31094: if_icmplt -> 31102
/*      */     //   31097: goto_w -> 31137
/*      */     //   31102: aload_0
/*      */     //   31103: getfield m : LMedium;
/*      */     //   31106: getfield snap : [I
/*      */     //   31109: iload #11
/*      */     //   31111: aload_0
/*      */     //   31112: getfield snap : [I
/*      */     //   31115: iload #11
/*      */     //   31117: iaload
/*      */     //   31118: i2f
/*      */     //   31119: ldc_w 1.2
/*      */     //   31122: fmul
/*      */     //   31123: ldc_w 60.0
/*      */     //   31126: fsub
/*      */     //   31127: f2i
/*      */     //   31128: iastore
/*      */     //   31129: iinc #11, 1
/*      */     //   31132: goto_w -> 31091
/*      */     //   31137: aload_0
/*      */     //   31138: iconst_2
/*      */     //   31139: invokevirtual readstage : (I)V
/*      */     //   31142: goto_w -> 31147
/*      */     //   31147: aload_0
/*      */     //   31148: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31151: new java/awt/Color
/*      */     //   31154: dup
/*      */     //   31155: iconst_0
/*      */     //   31156: iconst_0
/*      */     //   31157: iconst_0
/*      */     //   31158: invokespecial <init> : (III)V
/*      */     //   31161: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   31164: aload_0
/*      */     //   31165: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31168: ldc_w 'Car Lights :'
/*      */     //   31171: sipush #265
/*      */     //   31174: sipush #541
/*      */     //   31177: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   31180: aload_0
/*      */     //   31181: getfield snap : [I
/*      */     //   31184: iconst_0
/*      */     //   31185: iaload
/*      */     //   31186: aload_0
/*      */     //   31187: getfield snap : [I
/*      */     //   31190: iconst_1
/*      */     //   31191: iaload
/*      */     //   31192: iadd
/*      */     //   31193: aload_0
/*      */     //   31194: getfield snap : [I
/*      */     //   31197: iconst_2
/*      */     //   31198: iaload
/*      */     //   31199: iadd
/*      */     //   31200: bipush #110
/*      */     //   31202: if_icmpgt -> 31210
/*      */     //   31205: goto_w -> 31239
/*      */     //   31210: aload_0
/*      */     //   31211: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31214: ldc_w 'Off'
/*      */     //   31217: sipush #335
/*      */     //   31220: sipush #541
/*      */     //   31223: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   31226: aload_0
/*      */     //   31227: getfield m : LMedium;
/*      */     //   31230: iconst_0
/*      */     //   31231: putfield lightson : Z
/*      */     //   31234: goto_w -> 31282
/*      */     //   31239: aload_0
/*      */     //   31240: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31243: new java/awt/Color
/*      */     //   31246: dup
/*      */     //   31247: iconst_0
/*      */     //   31248: sipush #200
/*      */     //   31251: iconst_0
/*      */     //   31252: invokespecial <init> : (III)V
/*      */     //   31255: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   31258: aload_0
/*      */     //   31259: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31262: ldc_w 'On'
/*      */     //   31265: sipush #335
/*      */     //   31268: sipush #541
/*      */     //   31271: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   31274: aload_0
/*      */     //   31275: getfield m : LMedium;
/*      */     //   31278: iconst_1
/*      */     //   31279: putfield lightson : Z
/*      */     //   31282: bipush #33
/*      */     //   31284: istore #11
/*      */     //   31286: aload_0
/*      */     //   31287: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31290: new java/awt/Color
/*      */     //   31293: dup
/*      */     //   31294: iconst_0
/*      */     //   31295: iconst_0
/*      */     //   31296: iconst_0
/*      */     //   31297: invokespecial <init> : (III)V
/*      */     //   31300: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   31303: aload_0
/*      */     //   31304: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31307: ldc_w 'Dust/Fog Properties'
/*      */     //   31310: sipush #280
/*      */     //   31313: iload #11
/*      */     //   31315: iadd
/*      */     //   31316: sipush #461
/*      */     //   31319: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   31322: aload_0
/*      */     //   31323: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31326: new java/awt/Color
/*      */     //   31329: dup
/*      */     //   31330: sipush #128
/*      */     //   31333: sipush #128
/*      */     //   31336: sipush #128
/*      */     //   31339: invokespecial <init> : (III)V
/*      */     //   31342: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   31345: aload_0
/*      */     //   31346: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31349: sipush #270
/*      */     //   31352: iload #11
/*      */     //   31354: iadd
/*      */     //   31355: sipush #457
/*      */     //   31358: sipush #277
/*      */     //   31361: iload #11
/*      */     //   31363: iadd
/*      */     //   31364: sipush #457
/*      */     //   31367: invokevirtual drawLine : (IIII)V
/*      */     //   31370: aload_0
/*      */     //   31371: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31374: sipush #540
/*      */     //   31377: iload #11
/*      */     //   31379: iadd
/*      */     //   31380: sipush #457
/*      */     //   31383: sipush #393
/*      */     //   31386: iload #11
/*      */     //   31388: iadd
/*      */     //   31389: sipush #457
/*      */     //   31392: invokevirtual drawLine : (IIII)V
/*      */     //   31395: aload_0
/*      */     //   31396: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31399: sipush #270
/*      */     //   31402: iload #11
/*      */     //   31404: iadd
/*      */     //   31405: sipush #457
/*      */     //   31408: sipush #270
/*      */     //   31411: iload #11
/*      */     //   31413: iadd
/*      */     //   31414: sipush #522
/*      */     //   31417: invokevirtual drawLine : (IIII)V
/*      */     //   31420: aload_0
/*      */     //   31421: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31424: sipush #540
/*      */     //   31427: iload #11
/*      */     //   31429: iadd
/*      */     //   31430: sipush #457
/*      */     //   31433: sipush #540
/*      */     //   31436: iload #11
/*      */     //   31438: iadd
/*      */     //   31439: sipush #522
/*      */     //   31442: invokevirtual drawLine : (IIII)V
/*      */     //   31445: aload_0
/*      */     //   31446: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31449: sipush #270
/*      */     //   31452: iload #11
/*      */     //   31454: iadd
/*      */     //   31455: sipush #522
/*      */     //   31458: sipush #540
/*      */     //   31461: iload #11
/*      */     //   31463: iadd
/*      */     //   31464: sipush #522
/*      */     //   31467: invokevirtual drawLine : (IIII)V
/*      */     //   31470: iconst_2
/*      */     //   31471: anewarray java/lang/String
/*      */     //   31474: dup
/*      */     //   31475: iconst_0
/*      */     //   31476: ldc_w 'Density'
/*      */     //   31479: aastore
/*      */     //   31480: dup
/*      */     //   31481: iconst_1
/*      */     //   31482: ldc_w 'Near / Far'
/*      */     //   31485: aastore
/*      */     //   31486: astore #12
/*      */     //   31488: iconst_2
/*      */     //   31489: newarray int
/*      */     //   31491: dup
/*      */     //   31492: iconst_0
/*      */     //   31493: sipush #292
/*      */     //   31496: iload #11
/*      */     //   31498: iadd
/*      */     //   31499: iastore
/*      */     //   31500: dup
/*      */     //   31501: iconst_1
/*      */     //   31502: sipush #280
/*      */     //   31505: iload #11
/*      */     //   31507: iadd
/*      */     //   31508: iastore
/*      */     //   31509: astore #13
/*      */     //   31511: iconst_2
/*      */     //   31512: newarray int
/*      */     //   31514: dup
/*      */     //   31515: iconst_0
/*      */     //   31516: bipush #20
/*      */     //   31518: iastore
/*      */     //   31519: dup
/*      */     //   31520: iconst_1
/*      */     //   31521: bipush #10
/*      */     //   31523: iastore
/*      */     //   31524: astore #14
/*      */     //   31526: bipush #38
/*      */     //   31528: istore #9
/*      */     //   31530: sipush #210
/*      */     //   31533: iload #11
/*      */     //   31535: iadd
/*      */     //   31536: istore #10
/*      */     //   31538: iconst_0
/*      */     //   31539: istore #15
/*      */     //   31541: iload #15
/*      */     //   31543: iconst_2
/*      */     //   31544: if_icmplt -> 31552
/*      */     //   31547: goto_w -> 32066
/*      */     //   31552: aload_0
/*      */     //   31553: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31556: new java/awt/Color
/*      */     //   31559: dup
/*      */     //   31560: iconst_0
/*      */     //   31561: iconst_0
/*      */     //   31562: iconst_0
/*      */     //   31563: invokespecial <init> : (III)V
/*      */     //   31566: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   31569: aload_0
/*      */     //   31570: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31573: new java/lang/StringBuilder
/*      */     //   31576: dup
/*      */     //   31577: invokespecial <init> : ()V
/*      */     //   31580: ldc ''
/*      */     //   31582: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   31585: aload #12
/*      */     //   31587: iload #15
/*      */     //   31589: aaload
/*      */     //   31590: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   31593: ldc_w ' :'
/*      */     //   31596: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   31599: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   31602: aload #13
/*      */     //   31604: iload #15
/*      */     //   31606: iaload
/*      */     //   31607: sipush #447
/*      */     //   31610: iload #15
/*      */     //   31612: bipush #24
/*      */     //   31614: imul
/*      */     //   31615: iadd
/*      */     //   31616: iload #9
/*      */     //   31618: iadd
/*      */     //   31619: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   31622: aload_0
/*      */     //   31623: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31626: sipush #140
/*      */     //   31629: iload #10
/*      */     //   31631: iadd
/*      */     //   31632: sipush #443
/*      */     //   31635: iload #15
/*      */     //   31637: bipush #24
/*      */     //   31639: imul
/*      */     //   31640: iload #9
/*      */     //   31642: iadd
/*      */     //   31643: iadd
/*      */     //   31644: sipush #230
/*      */     //   31647: iload #10
/*      */     //   31649: iadd
/*      */     //   31650: sipush #443
/*      */     //   31653: iload #15
/*      */     //   31655: bipush #24
/*      */     //   31657: imul
/*      */     //   31658: iadd
/*      */     //   31659: iload #9
/*      */     //   31661: iadd
/*      */     //   31662: invokevirtual drawLine : (IIII)V
/*      */     //   31665: iconst_1
/*      */     //   31666: istore #16
/*      */     //   31668: iload #16
/*      */     //   31670: bipush #10
/*      */     //   31672: if_icmplt -> 31680
/*      */     //   31675: goto_w -> 31749
/*      */     //   31680: aload_0
/*      */     //   31681: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31684: sipush #140
/*      */     //   31687: bipush #10
/*      */     //   31689: iload #16
/*      */     //   31691: imul
/*      */     //   31692: iadd
/*      */     //   31693: iload #10
/*      */     //   31695: iadd
/*      */     //   31696: sipush #443
/*      */     //   31699: iload #16
/*      */     //   31701: isub
/*      */     //   31702: iload #15
/*      */     //   31704: bipush #24
/*      */     //   31706: imul
/*      */     //   31707: iadd
/*      */     //   31708: iload #9
/*      */     //   31710: iadd
/*      */     //   31711: sipush #140
/*      */     //   31714: bipush #10
/*      */     //   31716: iload #16
/*      */     //   31718: imul
/*      */     //   31719: iadd
/*      */     //   31720: iload #10
/*      */     //   31722: iadd
/*      */     //   31723: sipush #443
/*      */     //   31726: iload #16
/*      */     //   31728: iadd
/*      */     //   31729: iload #15
/*      */     //   31731: bipush #24
/*      */     //   31733: imul
/*      */     //   31734: iadd
/*      */     //   31735: iload #9
/*      */     //   31737: iadd
/*      */     //   31738: invokevirtual drawLine : (IIII)V
/*      */     //   31741: iinc #16, 1
/*      */     //   31744: goto_w -> 31668
/*      */     //   31749: aload_0
/*      */     //   31750: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31753: new java/awt/Color
/*      */     //   31756: dup
/*      */     //   31757: sipush #255
/*      */     //   31760: iconst_0
/*      */     //   31761: iconst_0
/*      */     //   31762: invokespecial <init> : (III)V
/*      */     //   31765: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   31768: aload_0
/*      */     //   31769: getfield fogn : [I
/*      */     //   31772: iload #15
/*      */     //   31774: iaload
/*      */     //   31775: i2f
/*      */     //   31776: ldc_w 1.1111
/*      */     //   31779: fdiv
/*      */     //   31780: ldc_w 10.0
/*      */     //   31783: fdiv
/*      */     //   31784: f2i
/*      */     //   31785: istore #16
/*      */     //   31787: aload_0
/*      */     //   31788: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31791: sipush #138
/*      */     //   31794: aload_0
/*      */     //   31795: getfield fogn : [I
/*      */     //   31798: iload #15
/*      */     //   31800: iaload
/*      */     //   31801: i2f
/*      */     //   31802: ldc_w 1.1111
/*      */     //   31805: fdiv
/*      */     //   31806: f2i
/*      */     //   31807: iadd
/*      */     //   31808: iload #10
/*      */     //   31810: iadd
/*      */     //   31811: sipush #443
/*      */     //   31814: iload #16
/*      */     //   31816: isub
/*      */     //   31817: iload #15
/*      */     //   31819: bipush #24
/*      */     //   31821: imul
/*      */     //   31822: iadd
/*      */     //   31823: iload #9
/*      */     //   31825: iadd
/*      */     //   31826: iconst_5
/*      */     //   31827: iload #16
/*      */     //   31829: iconst_2
/*      */     //   31830: imul
/*      */     //   31831: iconst_1
/*      */     //   31832: iadd
/*      */     //   31833: invokevirtual fillRect : (IIII)V
/*      */     //   31836: aload_0
/*      */     //   31837: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31840: new java/awt/Color
/*      */     //   31843: dup
/*      */     //   31844: sipush #255
/*      */     //   31847: sipush #128
/*      */     //   31850: iconst_0
/*      */     //   31851: invokespecial <init> : (III)V
/*      */     //   31854: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   31857: aload_0
/*      */     //   31858: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   31861: sipush #139
/*      */     //   31864: aload_0
/*      */     //   31865: getfield fogn : [I
/*      */     //   31868: iload #15
/*      */     //   31870: iaload
/*      */     //   31871: i2f
/*      */     //   31872: ldc_w 1.1111
/*      */     //   31875: fdiv
/*      */     //   31876: f2i
/*      */     //   31877: iadd
/*      */     //   31878: iload #10
/*      */     //   31880: iadd
/*      */     //   31881: sipush #434
/*      */     //   31884: iload #15
/*      */     //   31886: bipush #24
/*      */     //   31888: imul
/*      */     //   31889: iadd
/*      */     //   31890: iload #9
/*      */     //   31892: iadd
/*      */     //   31893: iconst_2
/*      */     //   31894: bipush #18
/*      */     //   31896: invokevirtual drawRect : (IIII)V
/*      */     //   31899: aload_0
/*      */     //   31900: ldc_w ' - '
/*      */     //   31903: sipush #260
/*      */     //   31906: iload #10
/*      */     //   31908: iadd
/*      */     //   31909: sipush #447
/*      */     //   31912: iload #15
/*      */     //   31914: bipush #24
/*      */     //   31916: imul
/*      */     //   31917: iadd
/*      */     //   31918: iload #9
/*      */     //   31920: iadd
/*      */     //   31921: iconst_4
/*      */     //   31922: iconst_0
/*      */     //   31923: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   31926: ifne -> 31934
/*      */     //   31929: goto_w -> 31977
/*      */     //   31934: aload_0
/*      */     //   31935: getfield fogn : [I
/*      */     //   31938: iload #15
/*      */     //   31940: dup2
/*      */     //   31941: iaload
/*      */     //   31942: aload #14
/*      */     //   31944: iload #15
/*      */     //   31946: iaload
/*      */     //   31947: isub
/*      */     //   31948: iastore
/*      */     //   31949: aload_0
/*      */     //   31950: getfield fogn : [I
/*      */     //   31953: iload #15
/*      */     //   31955: iaload
/*      */     //   31956: iflt -> 31964
/*      */     //   31959: goto_w -> 31977
/*      */     //   31964: aload_0
/*      */     //   31965: getfield fogn : [I
/*      */     //   31968: iload #15
/*      */     //   31970: iconst_0
/*      */     //   31971: iastore
/*      */     //   31972: goto_w -> 31977
/*      */     //   31977: aload_0
/*      */     //   31978: ldc_w ' + '
/*      */     //   31981: sipush #300
/*      */     //   31984: iload #10
/*      */     //   31986: iadd
/*      */     //   31987: sipush #447
/*      */     //   31990: iload #15
/*      */     //   31992: bipush #24
/*      */     //   31994: imul
/*      */     //   31995: iadd
/*      */     //   31996: iload #9
/*      */     //   31998: iadd
/*      */     //   31999: iconst_4
/*      */     //   32000: iconst_0
/*      */     //   32001: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   32004: ifne -> 32012
/*      */     //   32007: goto_w -> 32058
/*      */     //   32012: aload_0
/*      */     //   32013: getfield fogn : [I
/*      */     //   32016: iload #15
/*      */     //   32018: dup2
/*      */     //   32019: iaload
/*      */     //   32020: aload #14
/*      */     //   32022: iload #15
/*      */     //   32024: iaload
/*      */     //   32025: iadd
/*      */     //   32026: iastore
/*      */     //   32027: aload_0
/*      */     //   32028: getfield fogn : [I
/*      */     //   32031: iload #15
/*      */     //   32033: iaload
/*      */     //   32034: bipush #100
/*      */     //   32036: if_icmpgt -> 32044
/*      */     //   32039: goto_w -> 32058
/*      */     //   32044: aload_0
/*      */     //   32045: getfield fogn : [I
/*      */     //   32048: iload #15
/*      */     //   32050: bipush #100
/*      */     //   32052: iastore
/*      */     //   32053: goto_w -> 32058
/*      */     //   32058: iinc #15, 1
/*      */     //   32061: goto_w -> 31541
/*      */     //   32066: aload_0
/*      */     //   32067: getfield m : LMedium;
/*      */     //   32070: bipush #8
/*      */     //   32072: aload_0
/*      */     //   32073: getfield fogn : [I
/*      */     //   32076: iconst_0
/*      */     //   32077: iaload
/*      */     //   32078: bipush #20
/*      */     //   32080: idiv
/*      */     //   32081: isub
/*      */     //   32082: iconst_1
/*      */     //   32083: iadd
/*      */     //   32084: iconst_2
/*      */     //   32085: imul
/*      */     //   32086: iconst_1
/*      */     //   32087: isub
/*      */     //   32088: putfield fogd : I
/*      */     //   32091: aload_0
/*      */     //   32092: getfield m : LMedium;
/*      */     //   32095: sipush #5000
/*      */     //   32098: aload_0
/*      */     //   32099: getfield fogn : [I
/*      */     //   32102: iconst_1
/*      */     //   32103: iaload
/*      */     //   32104: bipush #30
/*      */     //   32106: imul
/*      */     //   32107: iadd
/*      */     //   32108: invokevirtual fadfrom : (I)V
/*      */     //   32111: aload_0
/*      */     //   32112: aload_0
/*      */     //   32113: getfield m : LMedium;
/*      */     //   32116: getfield fade : [I
/*      */     //   32119: iconst_0
/*      */     //   32120: iaload
/*      */     //   32121: putfield origfade : I
/*      */     //   32124: aload_0
/*      */     //   32125: ldc_w ' Reset '
/*      */     //   32128: sipush #650
/*      */     //   32131: sipush #510
/*      */     //   32134: iconst_0
/*      */     //   32135: iconst_1
/*      */     //   32136: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   32139: ifne -> 32147
/*      */     //   32142: goto_w -> 32158
/*      */     //   32147: aload_0
/*      */     //   32148: bipush #-2
/*      */     //   32150: putfield dtabed : I
/*      */     //   32153: goto_w -> 32158
/*      */     //   32158: aload_0
/*      */     //   32159: ldc_w '        Save        '
/*      */     //   32162: sipush #737
/*      */     //   32165: sipush #510
/*      */     //   32168: iconst_0
/*      */     //   32169: iconst_1
/*      */     //   32170: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   32173: ifne -> 32181
/*      */     //   32176: goto_w -> 32194
/*      */     //   32181: aload_0
/*      */     //   32182: invokevirtual sortop : ()V
/*      */     //   32185: aload_0
/*      */     //   32186: invokevirtual savefile : ()V
/*      */     //   32189: goto_w -> 32194
/*      */     //   32194: goto_w -> 32199
/*      */     //   32199: aload_0
/*      */     //   32200: getfield dtab : I
/*      */     //   32203: iconst_4
/*      */     //   32204: if_icmpeq -> 32212
/*      */     //   32207: goto_w -> 32477
/*      */     //   32212: aload_0
/*      */     //   32213: getfield dtabed : I
/*      */     //   32216: aload_0
/*      */     //   32217: getfield dtab : I
/*      */     //   32220: if_icmpne -> 32228
/*      */     //   32223: goto_w -> 32285
/*      */     //   32228: aload_0
/*      */     //   32229: getfield cp : LCheckPoints;
/*      */     //   32232: getfield nlaps : I
/*      */     //   32235: iconst_1
/*      */     //   32236: isub
/*      */     //   32237: ifge -> 32245
/*      */     //   32240: goto_w -> 32285
/*      */     //   32245: aload_0
/*      */     //   32246: getfield cp : LCheckPoints;
/*      */     //   32249: getfield nlaps : I
/*      */     //   32252: iconst_1
/*      */     //   32253: isub
/*      */     //   32254: bipush #14
/*      */     //   32256: if_icmple -> 32264
/*      */     //   32259: goto_w -> 32285
/*      */     //   32264: aload_0
/*      */     //   32265: getfield nlaps : LSmenu;
/*      */     //   32268: aload_0
/*      */     //   32269: getfield cp : LCheckPoints;
/*      */     //   32272: getfield nlaps : I
/*      */     //   32275: iconst_1
/*      */     //   32276: isub
/*      */     //   32277: invokevirtual select : (I)V
/*      */     //   32280: goto_w -> 32285
/*      */     //   32285: aload_0
/*      */     //   32286: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   32289: new java/awt/Color
/*      */     //   32292: dup
/*      */     //   32293: iconst_0
/*      */     //   32294: iconst_0
/*      */     //   32295: iconst_0
/*      */     //   32296: invokespecial <init> : (III)V
/*      */     //   32299: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   32302: aload_0
/*      */     //   32303: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   32306: ldc_w 'Set the number of laps for this stage:'
/*      */     //   32309: sipush #130
/*      */     //   32312: sipush #496
/*      */     //   32315: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   32318: aload_0
/*      */     //   32319: getfield nlaps : LSmenu;
/*      */     //   32322: sipush #348
/*      */     //   32325: sipush #480
/*      */     //   32328: invokevirtual move : (II)V
/*      */     //   32331: aload_0
/*      */     //   32332: getfield nlaps : LSmenu;
/*      */     //   32335: invokevirtual isShowing : ()Z
/*      */     //   32338: ifeq -> 32346
/*      */     //   32341: goto_w -> 32358
/*      */     //   32346: aload_0
/*      */     //   32347: getfield nlaps : LSmenu;
/*      */     //   32350: invokevirtual show : ()V
/*      */     //   32353: goto_w -> 32358
/*      */     //   32358: aload_0
/*      */     //   32359: getfield cp : LCheckPoints;
/*      */     //   32362: getfield nlaps : I
/*      */     //   32365: aload_0
/*      */     //   32366: getfield nlaps : LSmenu;
/*      */     //   32369: invokevirtual getSelectedIndex : ()I
/*      */     //   32372: iconst_1
/*      */     //   32373: iadd
/*      */     //   32374: if_icmpne -> 32382
/*      */     //   32377: goto_w -> 32407
/*      */     //   32382: aload_0
/*      */     //   32383: getfield cp : LCheckPoints;
/*      */     //   32386: aload_0
/*      */     //   32387: getfield nlaps : LSmenu;
/*      */     //   32390: invokevirtual getSelectedIndex : ()I
/*      */     //   32393: iconst_1
/*      */     //   32394: iadd
/*      */     //   32395: putfield nlaps : I
/*      */     //   32398: aload_0
/*      */     //   32399: invokevirtual requestFocus : ()V
/*      */     //   32402: goto_w -> 32407
/*      */     //   32407: aload_0
/*      */     //   32408: ldc_w ' Reset '
/*      */     //   32411: sipush #530
/*      */     //   32414: sipush #496
/*      */     //   32417: iconst_0
/*      */     //   32418: iconst_1
/*      */     //   32419: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   32422: ifne -> 32430
/*      */     //   32425: goto_w -> 32441
/*      */     //   32430: aload_0
/*      */     //   32431: bipush #-2
/*      */     //   32433: putfield dtabed : I
/*      */     //   32436: goto_w -> 32441
/*      */     //   32441: aload_0
/*      */     //   32442: ldc_w '        Save        '
/*      */     //   32445: sipush #617
/*      */     //   32448: sipush #496
/*      */     //   32451: iconst_0
/*      */     //   32452: iconst_1
/*      */     //   32453: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   32456: ifne -> 32464
/*      */     //   32459: goto_w -> 32477
/*      */     //   32464: aload_0
/*      */     //   32465: invokevirtual sortop : ()V
/*      */     //   32468: aload_0
/*      */     //   32469: invokevirtual savefile : ()V
/*      */     //   32472: goto_w -> 32477
/*      */     //   32477: aload_0
/*      */     //   32478: getfield dtab : I
/*      */     //   32481: iconst_5
/*      */     //   32482: if_icmpeq -> 32490
/*      */     //   32485: goto_w -> 35639
/*      */     //   32490: aload_0
/*      */     //   32491: getfield dtabed : I
/*      */     //   32494: aload_0
/*      */     //   32495: getfield dtab : I
/*      */     //   32498: if_icmpne -> 32506
/*      */     //   32501: goto_w -> 32756
/*      */     //   32506: aload_0
/*      */     //   32507: getfield tracks : LSmenu;
/*      */     //   32510: invokevirtual removeAll : ()V
/*      */     //   32513: aload_0
/*      */     //   32514: getfield tracks : LSmenu;
/*      */     //   32517: sipush #200
/*      */     //   32520: putfield maxl : I
/*      */     //   32523: aload_0
/*      */     //   32524: getfield tracks : LSmenu;
/*      */     //   32527: aload_0
/*      */     //   32528: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   32531: ldc_w 'The Play List  -  MOD Tracks'
/*      */     //   32534: invokevirtual add : (Ljava/awt/Graphics2D;Ljava/lang/String;)V
/*      */     //   32537: new java/io/File
/*      */     //   32540: dup
/*      */     //   32541: new java/lang/StringBuilder
/*      */     //   32544: dup
/*      */     //   32545: invokespecial <init> : ()V
/*      */     //   32548: ldc ''
/*      */     //   32550: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   32553: getstatic Madness.fpath : Ljava/lang/String;
/*      */     //   32556: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   32559: ldc_w 'mystages/mymusic/'
/*      */     //   32562: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   32565: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   32568: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   32571: invokevirtual list : ()[Ljava/lang/String;
/*      */     //   32574: astore #7
/*      */     //   32576: aload #7
/*      */     //   32578: ifnonnull -> 32586
/*      */     //   32581: goto_w -> 32672
/*      */     //   32586: iconst_0
/*      */     //   32587: istore #8
/*      */     //   32589: iload #8
/*      */     //   32591: aload #7
/*      */     //   32593: arraylength
/*      */     //   32594: if_icmplt -> 32602
/*      */     //   32597: goto_w -> 32667
/*      */     //   32602: aload #7
/*      */     //   32604: iload #8
/*      */     //   32606: aaload
/*      */     //   32607: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   32610: ldc_w '.zip'
/*      */     //   32613: invokevirtual endsWith : (Ljava/lang/String;)Z
/*      */     //   32616: ifne -> 32624
/*      */     //   32619: goto_w -> 32659
/*      */     //   32624: aload_0
/*      */     //   32625: getfield tracks : LSmenu;
/*      */     //   32628: aload_0
/*      */     //   32629: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   32632: aload #7
/*      */     //   32634: iload #8
/*      */     //   32636: aaload
/*      */     //   32637: iconst_0
/*      */     //   32638: aload #7
/*      */     //   32640: iload #8
/*      */     //   32642: aaload
/*      */     //   32643: invokevirtual length : ()I
/*      */     //   32646: iconst_4
/*      */     //   32647: isub
/*      */     //   32648: invokevirtual substring : (II)Ljava/lang/String;
/*      */     //   32651: invokevirtual add : (Ljava/awt/Graphics2D;Ljava/lang/String;)V
/*      */     //   32654: goto_w -> 32659
/*      */     //   32659: iinc #8, 1
/*      */     //   32662: goto_w -> 32589
/*      */     //   32667: goto_w -> 32672
/*      */     //   32672: aload_0
/*      */     //   32673: getfield ltrackname : Ljava/lang/String;
/*      */     //   32676: ldc ''
/*      */     //   32678: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   32681: ifne -> 32689
/*      */     //   32684: goto_w -> 32735
/*      */     //   32689: aload_0
/*      */     //   32690: getfield trackname : Ljava/lang/String;
/*      */     //   32693: ldc ''
/*      */     //   32695: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   32698: ifne -> 32706
/*      */     //   32701: goto_w -> 32719
/*      */     //   32706: aload_0
/*      */     //   32707: getfield tracks : LSmenu;
/*      */     //   32710: iconst_0
/*      */     //   32711: invokevirtual select : (I)V
/*      */     //   32714: goto_w -> 32746
/*      */     //   32719: aload_0
/*      */     //   32720: getfield tracks : LSmenu;
/*      */     //   32723: aload_0
/*      */     //   32724: getfield trackname : Ljava/lang/String;
/*      */     //   32727: invokevirtual select : (Ljava/lang/String;)V
/*      */     //   32730: goto_w -> 32746
/*      */     //   32735: aload_0
/*      */     //   32736: getfield tracks : LSmenu;
/*      */     //   32739: aload_0
/*      */     //   32740: getfield ltrackname : Ljava/lang/String;
/*      */     //   32743: invokevirtual select : (Ljava/lang/String;)V
/*      */     //   32746: aload_0
/*      */     //   32747: iconst_m1
/*      */     //   32748: putfield mouseon : I
/*      */     //   32751: goto_w -> 32756
/*      */     //   32756: aload_0
/*      */     //   32757: getfield tracks : LSmenu;
/*      */     //   32760: bipush #10
/*      */     //   32762: sipush #450
/*      */     //   32765: invokevirtual move : (II)V
/*      */     //   32768: aload_0
/*      */     //   32769: getfield tracks : LSmenu;
/*      */     //   32772: invokevirtual getWidth : ()I
/*      */     //   32775: sipush #200
/*      */     //   32778: if_icmpne -> 32786
/*      */     //   32781: goto_w -> 32803
/*      */     //   32786: aload_0
/*      */     //   32787: getfield tracks : LSmenu;
/*      */     //   32790: sipush #200
/*      */     //   32793: bipush #21
/*      */     //   32795: invokevirtual setSize : (II)V
/*      */     //   32798: goto_w -> 32803
/*      */     //   32803: aload_0
/*      */     //   32804: getfield tracks : LSmenu;
/*      */     //   32807: invokevirtual isShowing : ()Z
/*      */     //   32810: ifeq -> 32818
/*      */     //   32813: goto_w -> 32830
/*      */     //   32818: aload_0
/*      */     //   32819: getfield tracks : LSmenu;
/*      */     //   32822: invokevirtual show : ()V
/*      */     //   32825: goto_w -> 32830
/*      */     //   32830: aload_0
/*      */     //   32831: getfield track : LRadicalMod;
/*      */     //   32834: getfield playing : Z
/*      */     //   32837: ifne -> 32845
/*      */     //   32840: goto_w -> 33492
/*      */     //   32845: aload_0
/*      */     //   32846: getfield track : LRadicalMod;
/*      */     //   32849: getfield loaded : I
/*      */     //   32852: iconst_2
/*      */     //   32853: if_icmpeq -> 32861
/*      */     //   32856: goto_w -> 33492
/*      */     //   32861: aload_0
/*      */     //   32862: ldc_w '      Stop      '
/*      */     //   32865: bipush #110
/*      */     //   32867: sipush #495
/*      */     //   32870: iconst_2
/*      */     //   32871: iconst_0
/*      */     //   32872: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   32875: ifne -> 32883
/*      */     //   32878: goto_w -> 32895
/*      */     //   32883: aload_0
/*      */     //   32884: getfield track : LRadicalMod;
/*      */     //   32887: invokevirtual stop : ()V
/*      */     //   32890: goto_w -> 32895
/*      */     //   32895: aload_0
/*      */     //   32896: getfield ltrackname : Ljava/lang/String;
/*      */     //   32899: aload_0
/*      */     //   32900: getfield tracks : LSmenu;
/*      */     //   32903: invokevirtual getSelectedItem : ()Ljava/lang/String;
/*      */     //   32906: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   32909: ifeq -> 32917
/*      */     //   32912: goto_w -> 32929
/*      */     //   32917: aload_0
/*      */     //   32918: getfield track : LRadicalMod;
/*      */     //   32921: invokevirtual stop : ()V
/*      */     //   32924: goto_w -> 32929
/*      */     //   32929: aload_0
/*      */     //   32930: getfield xm : I
/*      */     //   32933: bipush #10
/*      */     //   32935: if_icmpgt -> 32943
/*      */     //   32938: goto_w -> 33037
/*      */     //   32943: aload_0
/*      */     //   32944: getfield xm : I
/*      */     //   32947: sipush #210
/*      */     //   32950: if_icmplt -> 32958
/*      */     //   32953: goto_w -> 33037
/*      */     //   32958: aload_0
/*      */     //   32959: getfield ym : I
/*      */     //   32962: sipush #516
/*      */     //   32965: if_icmpgt -> 32973
/*      */     //   32968: goto_w -> 33037
/*      */     //   32973: aload_0
/*      */     //   32974: getfield ym : I
/*      */     //   32977: sipush #534
/*      */     //   32980: if_icmplt -> 32988
/*      */     //   32983: goto_w -> 33037
/*      */     //   32988: aload_0
/*      */     //   32989: getfield mouses : I
/*      */     //   32992: iconst_1
/*      */     //   32993: if_icmpeq -> 33001
/*      */     //   32996: goto_w -> 33011
/*      */     //   33001: aload_0
/*      */     //   33002: iconst_1
/*      */     //   33003: putfield mouseon : I
/*      */     //   33006: goto_w -> 33011
/*      */     //   33011: aload_0
/*      */     //   33012: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   33015: new java/awt/Color
/*      */     //   33018: dup
/*      */     //   33019: iconst_0
/*      */     //   33020: sipush #164
/*      */     //   33023: sipush #242
/*      */     //   33026: invokespecial <init> : (III)V
/*      */     //   33029: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   33032: goto_w -> 33059
/*      */     //   33037: aload_0
/*      */     //   33038: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   33041: new java/awt/Color
/*      */     //   33044: dup
/*      */     //   33045: bipush #120
/*      */     //   33047: sipush #210
/*      */     //   33050: sipush #255
/*      */     //   33053: invokespecial <init> : (III)V
/*      */     //   33056: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   33059: aload_0
/*      */     //   33060: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   33063: bipush #10
/*      */     //   33065: sipush #516
/*      */     //   33068: sipush #200
/*      */     //   33071: bipush #18
/*      */     //   33073: invokevirtual drawRect : (IIII)V
/*      */     //   33076: aload_0
/*      */     //   33077: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   33080: new java/awt/Color
/*      */     //   33083: dup
/*      */     //   33084: sipush #200
/*      */     //   33087: sipush #200
/*      */     //   33090: sipush #200
/*      */     //   33093: invokespecial <init> : (III)V
/*      */     //   33096: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   33099: aload_0
/*      */     //   33100: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   33103: bipush #10
/*      */     //   33105: sipush #523
/*      */     //   33108: sipush #210
/*      */     //   33111: sipush #523
/*      */     //   33114: invokevirtual drawLine : (IIII)V
/*      */     //   33117: aload_0
/*      */     //   33118: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   33121: new java/awt/Color
/*      */     //   33124: dup
/*      */     //   33125: iconst_0
/*      */     //   33126: iconst_0
/*      */     //   33127: iconst_0
/*      */     //   33128: invokespecial <init> : (III)V
/*      */     //   33131: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   33134: aload_0
/*      */     //   33135: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   33138: bipush #10
/*      */     //   33140: sipush #524
/*      */     //   33143: sipush #210
/*      */     //   33146: sipush #524
/*      */     //   33149: invokevirtual drawLine : (IIII)V
/*      */     //   33152: aload_0
/*      */     //   33153: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   33156: bipush #10
/*      */     //   33158: sipush #525
/*      */     //   33161: sipush #210
/*      */     //   33164: sipush #525
/*      */     //   33167: invokevirtual drawLine : (IIII)V
/*      */     //   33170: aload_0
/*      */     //   33171: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   33174: bipush #10
/*      */     //   33176: sipush #526
/*      */     //   33179: sipush #210
/*      */     //   33182: sipush #526
/*      */     //   33185: invokevirtual drawLine : (IIII)V
/*      */     //   33188: aload_0
/*      */     //   33189: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   33192: new java/awt/Color
/*      */     //   33195: dup
/*      */     //   33196: sipush #255
/*      */     //   33199: sipush #255
/*      */     //   33202: sipush #255
/*      */     //   33205: invokespecial <init> : (III)V
/*      */     //   33208: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   33211: aload_0
/*      */     //   33212: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   33215: bipush #10
/*      */     //   33217: sipush #527
/*      */     //   33220: sipush #210
/*      */     //   33223: sipush #527
/*      */     //   33226: invokevirtual drawLine : (IIII)V
/*      */     //   33229: fconst_1
/*      */     //   33230: aload_0
/*      */     //   33231: getfield track : LRadicalMod;
/*      */     //   33234: getfield sClip : LSuperClip;
/*      */     //   33237: getfield stream : Ljava/io/ByteArrayInputStream;
/*      */     //   33240: invokevirtual available : ()I
/*      */     //   33243: i2f
/*      */     //   33244: aload_0
/*      */     //   33245: getfield avon : I
/*      */     //   33248: i2f
/*      */     //   33249: fdiv
/*      */     //   33250: fsub
/*      */     //   33251: ldc_w 200.0
/*      */     //   33254: fmul
/*      */     //   33255: f2i
/*      */     //   33256: istore #7
/*      */     //   33258: aload_0
/*      */     //   33259: getfield mouseon : I
/*      */     //   33262: iconst_1
/*      */     //   33263: if_icmpeq -> 33271
/*      */     //   33266: goto_w -> 33385
/*      */     //   33271: aload_0
/*      */     //   33272: getfield xm : I
/*      */     //   33275: bipush #10
/*      */     //   33277: isub
/*      */     //   33278: istore #7
/*      */     //   33280: iload #7
/*      */     //   33282: iflt -> 33290
/*      */     //   33285: goto_w -> 33298
/*      */     //   33290: iconst_0
/*      */     //   33291: istore #7
/*      */     //   33293: goto_w -> 33298
/*      */     //   33298: iload #7
/*      */     //   33300: sipush #200
/*      */     //   33303: if_icmpgt -> 33311
/*      */     //   33306: goto_w -> 33321
/*      */     //   33311: sipush #200
/*      */     //   33314: istore #7
/*      */     //   33316: goto_w -> 33321
/*      */     //   33321: aload_0
/*      */     //   33322: getfield mouses : I
/*      */     //   33325: iconst_1
/*      */     //   33326: if_icmpne -> 33334
/*      */     //   33329: goto_w -> 33385
/*      */     //   33334: aload_0
/*      */     //   33335: getfield track : LRadicalMod;
/*      */     //   33338: getfield sClip : LSuperClip;
/*      */     //   33341: getfield stream : Ljava/io/ByteArrayInputStream;
/*      */     //   33344: invokevirtual reset : ()V
/*      */     //   33347: aload_0
/*      */     //   33348: getfield track : LRadicalMod;
/*      */     //   33351: getfield sClip : LSuperClip;
/*      */     //   33354: getfield stream : Ljava/io/ByteArrayInputStream;
/*      */     //   33357: iload #7
/*      */     //   33359: i2f
/*      */     //   33360: ldc_w 200.0
/*      */     //   33363: fdiv
/*      */     //   33364: aload_0
/*      */     //   33365: getfield avon : I
/*      */     //   33368: i2f
/*      */     //   33369: fmul
/*      */     //   33370: f2l
/*      */     //   33371: invokevirtual skip : (J)J
/*      */     //   33374: pop2
/*      */     //   33375: aload_0
/*      */     //   33376: iconst_m1
/*      */     //   33377: putfield mouseon : I
/*      */     //   33380: goto_w -> 33385
/*      */     //   33385: aload_0
/*      */     //   33386: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   33389: new java/awt/Color
/*      */     //   33392: dup
/*      */     //   33393: iconst_0
/*      */     //   33394: iconst_0
/*      */     //   33395: iconst_0
/*      */     //   33396: invokespecial <init> : (III)V
/*      */     //   33399: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   33402: aload_0
/*      */     //   33403: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   33406: bipush #8
/*      */     //   33408: iload #7
/*      */     //   33410: iadd
/*      */     //   33411: sipush #516
/*      */     //   33414: iconst_4
/*      */     //   33415: bipush #18
/*      */     //   33417: invokevirtual drawRect : (IIII)V
/*      */     //   33420: aload_0
/*      */     //   33421: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   33424: new java/awt/Color
/*      */     //   33427: dup
/*      */     //   33428: iconst_0
/*      */     //   33429: sipush #164
/*      */     //   33432: sipush #242
/*      */     //   33435: invokespecial <init> : (III)V
/*      */     //   33438: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   33441: aload_0
/*      */     //   33442: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   33445: bipush #10
/*      */     //   33447: iload #7
/*      */     //   33449: iadd
/*      */     //   33450: sipush #520
/*      */     //   33453: bipush #10
/*      */     //   33455: iload #7
/*      */     //   33457: iadd
/*      */     //   33458: sipush #518
/*      */     //   33461: invokevirtual drawLine : (IIII)V
/*      */     //   33464: aload_0
/*      */     //   33465: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   33468: bipush #10
/*      */     //   33470: iload #7
/*      */     //   33472: iadd
/*      */     //   33473: sipush #530
/*      */     //   33476: bipush #10
/*      */     //   33478: iload #7
/*      */     //   33480: iadd
/*      */     //   33481: sipush #532
/*      */     //   33484: invokevirtual drawLine : (IIII)V
/*      */     //   33487: goto_w -> 33745
/*      */     //   33492: aload_0
/*      */     //   33493: getfield tracks : LSmenu;
/*      */     //   33496: invokevirtual getSelectedIndex : ()I
/*      */     //   33499: ifne -> 33507
/*      */     //   33502: goto_w -> 33745
/*      */     //   33507: aload_0
/*      */     //   33508: ldc_w '      Play  >      '
/*      */     //   33511: bipush #110
/*      */     //   33513: sipush #495
/*      */     //   33516: iconst_2
/*      */     //   33517: iconst_0
/*      */     //   33518: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   33521: ifne -> 33529
/*      */     //   33524: goto_w -> 33745
/*      */     //   33529: aload_0
/*      */     //   33530: getfield ltrackname : Ljava/lang/String;
/*      */     //   33533: aload_0
/*      */     //   33534: getfield tracks : LSmenu;
/*      */     //   33537: invokevirtual getSelectedItem : ()Ljava/lang/String;
/*      */     //   33540: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   33543: ifeq -> 33551
/*      */     //   33546: goto_w -> 33671
/*      */     //   33551: aload_0
/*      */     //   33552: getfield track : LRadicalMod;
/*      */     //   33555: invokevirtual unload : ()V
/*      */     //   33558: aload_0
/*      */     //   33559: new RadicalMod
/*      */     //   33562: dup
/*      */     //   33563: new java/lang/StringBuilder
/*      */     //   33566: dup
/*      */     //   33567: invokespecial <init> : ()V
/*      */     //   33570: ldc_w 'mystages/mymusic/'
/*      */     //   33573: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   33576: aload_0
/*      */     //   33577: getfield tracks : LSmenu;
/*      */     //   33580: invokevirtual getSelectedItem : ()Ljava/lang/String;
/*      */     //   33583: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   33586: ldc_w '.zip'
/*      */     //   33589: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   33592: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   33595: sipush #300
/*      */     //   33598: sipush #8000
/*      */     //   33601: bipush #125
/*      */     //   33603: iconst_1
/*      */     //   33604: iconst_0
/*      */     //   33605: invokespecial <init> : (Ljava/lang/String;IIIZZ)V
/*      */     //   33608: putfield track : LRadicalMod;
/*      */     //   33611: aload_0
/*      */     //   33612: getfield track : LRadicalMod;
/*      */     //   33615: getfield loaded : I
/*      */     //   33618: iconst_2
/*      */     //   33619: if_icmpeq -> 33627
/*      */     //   33622: goto_w -> 33660
/*      */     //   33627: aload_0
/*      */     //   33628: aload_0
/*      */     //   33629: getfield track : LRadicalMod;
/*      */     //   33632: getfield sClip : LSuperClip;
/*      */     //   33635: getfield stream : Ljava/io/ByteArrayInputStream;
/*      */     //   33638: invokevirtual available : ()I
/*      */     //   33641: putfield avon : I
/*      */     //   33644: aload_0
/*      */     //   33645: aload_0
/*      */     //   33646: getfield tracks : LSmenu;
/*      */     //   33649: invokevirtual getSelectedItem : ()Ljava/lang/String;
/*      */     //   33652: putfield ltrackname : Ljava/lang/String;
/*      */     //   33655: goto_w -> 33671
/*      */     //   33660: aload_0
/*      */     //   33661: ldc ''
/*      */     //   33663: putfield ltrackname : Ljava/lang/String;
/*      */     //   33666: goto_w -> 33671
/*      */     //   33671: aload_0
/*      */     //   33672: getfield ltrackname : Ljava/lang/String;
/*      */     //   33675: ldc ''
/*      */     //   33677: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   33680: ifeq -> 33688
/*      */     //   33683: goto_w -> 33700
/*      */     //   33688: aload_0
/*      */     //   33689: getfield track : LRadicalMod;
/*      */     //   33692: invokevirtual play : ()V
/*      */     //   33695: goto_w -> 33745
/*      */     //   33700: aconst_null
/*      */     //   33701: new java/lang/StringBuilder
/*      */     //   33704: dup
/*      */     //   33705: invokespecial <init> : ()V
/*      */     //   33708: ldc_w 'Failed to load ''
/*      */     //   33711: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   33714: aload_0
/*      */     //   33715: getfield tracks : LSmenu;
/*      */     //   33718: invokevirtual getSelectedItem : ()Ljava/lang/String;
/*      */     //   33721: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   33724: ldc_w '', please make sure it is a valid MOD Track!'
/*      */     //   33727: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   33730: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   33733: ldc_w 'Stage Maker'
/*      */     //   33736: iconst_1
/*      */     //   33737: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   33740: goto_w -> 33745
/*      */     //   33745: aload_0
/*      */     //   33746: getfield tracks : LSmenu;
/*      */     //   33749: invokevirtual getSelectedIndex : ()I
/*      */     //   33752: ifne -> 33760
/*      */     //   33755: goto_w -> 34243
/*      */     //   33760: aload_0
/*      */     //   33761: ldc_w '   Set as the stage's Sound Track  >   '
/*      */     //   33764: sipush #330
/*      */     //   33767: sipush #466
/*      */     //   33770: iconst_2
/*      */     //   33771: iconst_0
/*      */     //   33772: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   33775: ifne -> 33783
/*      */     //   33778: goto_w -> 34163
/*      */     //   33783: aload_0
/*      */     //   33784: getfield ltrackname : Ljava/lang/String;
/*      */     //   33787: aload_0
/*      */     //   33788: getfield tracks : LSmenu;
/*      */     //   33791: invokevirtual getSelectedItem : ()Ljava/lang/String;
/*      */     //   33794: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   33797: ifeq -> 33805
/*      */     //   33800: goto_w -> 33925
/*      */     //   33805: aload_0
/*      */     //   33806: getfield track : LRadicalMod;
/*      */     //   33809: invokevirtual unload : ()V
/*      */     //   33812: aload_0
/*      */     //   33813: new RadicalMod
/*      */     //   33816: dup
/*      */     //   33817: new java/lang/StringBuilder
/*      */     //   33820: dup
/*      */     //   33821: invokespecial <init> : ()V
/*      */     //   33824: ldc_w 'mystages/mymusic/'
/*      */     //   33827: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   33830: aload_0
/*      */     //   33831: getfield tracks : LSmenu;
/*      */     //   33834: invokevirtual getSelectedItem : ()Ljava/lang/String;
/*      */     //   33837: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   33840: ldc_w '.zip'
/*      */     //   33843: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   33846: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   33849: sipush #300
/*      */     //   33852: sipush #8000
/*      */     //   33855: bipush #125
/*      */     //   33857: iconst_1
/*      */     //   33858: iconst_0
/*      */     //   33859: invokespecial <init> : (Ljava/lang/String;IIIZZ)V
/*      */     //   33862: putfield track : LRadicalMod;
/*      */     //   33865: aload_0
/*      */     //   33866: getfield track : LRadicalMod;
/*      */     //   33869: getfield loaded : I
/*      */     //   33872: iconst_2
/*      */     //   33873: if_icmpeq -> 33881
/*      */     //   33876: goto_w -> 33914
/*      */     //   33881: aload_0
/*      */     //   33882: aload_0
/*      */     //   33883: getfield track : LRadicalMod;
/*      */     //   33886: getfield sClip : LSuperClip;
/*      */     //   33889: getfield stream : Ljava/io/ByteArrayInputStream;
/*      */     //   33892: invokevirtual available : ()I
/*      */     //   33895: putfield avon : I
/*      */     //   33898: aload_0
/*      */     //   33899: aload_0
/*      */     //   33900: getfield tracks : LSmenu;
/*      */     //   33903: invokevirtual getSelectedItem : ()Ljava/lang/String;
/*      */     //   33906: putfield ltrackname : Ljava/lang/String;
/*      */     //   33909: goto_w -> 33925
/*      */     //   33914: aload_0
/*      */     //   33915: ldc ''
/*      */     //   33917: putfield ltrackname : Ljava/lang/String;
/*      */     //   33920: goto_w -> 33925
/*      */     //   33925: aload_0
/*      */     //   33926: getfield ltrackname : Ljava/lang/String;
/*      */     //   33929: ldc ''
/*      */     //   33931: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   33934: ifeq -> 33942
/*      */     //   33937: goto_w -> 34118
/*      */     //   33942: aload_0
/*      */     //   33943: aload_0
/*      */     //   33944: getfield ltrackname : Ljava/lang/String;
/*      */     //   33947: putfield trackname : Ljava/lang/String;
/*      */     //   33950: aload_0
/*      */     //   33951: ldc_w 220.0
/*      */     //   33954: aload_0
/*      */     //   33955: getfield track : LRadicalMod;
/*      */     //   33958: getfield rvol : I
/*      */     //   33961: i2f
/*      */     //   33962: ldc_w 3750.0
/*      */     //   33965: fdiv
/*      */     //   33966: fdiv
/*      */     //   33967: f2i
/*      */     //   33968: putfield trackvol : I
/*      */     //   33971: new java/io/File
/*      */     //   33974: dup
/*      */     //   33975: new java/lang/StringBuilder
/*      */     //   33978: dup
/*      */     //   33979: invokespecial <init> : ()V
/*      */     //   33982: ldc ''
/*      */     //   33984: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   33987: getstatic Madness.fpath : Ljava/lang/String;
/*      */     //   33990: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   33993: ldc_w 'mystages/mymusic/'
/*      */     //   33996: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   33999: aload_0
/*      */     //   34000: getfield trackname : Ljava/lang/String;
/*      */     //   34003: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34006: ldc_w '.zip'
/*      */     //   34009: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34012: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   34015: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   34018: astore #7
/*      */     //   34020: aload_0
/*      */     //   34021: aload #7
/*      */     //   34023: invokevirtual length : ()J
/*      */     //   34026: ldc2_w 1024
/*      */     //   34029: ldiv
/*      */     //   34030: l2i
/*      */     //   34031: putfield tracksize : I
/*      */     //   34034: aload_0
/*      */     //   34035: getfield tracksize : I
/*      */     //   34038: sipush #700
/*      */     //   34041: if_icmpgt -> 34049
/*      */     //   34044: goto_w -> 34100
/*      */     //   34049: aconst_null
/*      */     //   34050: new java/lang/StringBuilder
/*      */     //   34053: dup
/*      */     //   34054: invokespecial <init> : ()V
/*      */     //   34057: ldc_w 'Cannot use ''
/*      */     //   34060: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34063: aload_0
/*      */     //   34064: getfield tracks : LSmenu;
/*      */     //   34067: invokevirtual getSelectedItem : ()Ljava/lang/String;
/*      */     //   34070: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34073: ldc_w '' as the sound track!\\nIts file size is bigger then 700KB.\\n\\n'
/*      */     //   34076: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34079: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   34082: ldc_w 'Stage Maker'
/*      */     //   34085: iconst_1
/*      */     //   34086: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   34089: aload_0
/*      */     //   34090: ldc ''
/*      */     //   34092: putfield trackname : Ljava/lang/String;
/*      */     //   34095: goto_w -> 34100
/*      */     //   34100: goto_w -> 34163
/*      */     //   34105: astore #7
/*      */     //   34107: aload_0
/*      */     //   34108: bipush #111
/*      */     //   34110: putfield tracksize : I
/*      */     //   34113: goto_w -> 34163
/*      */     //   34118: aconst_null
/*      */     //   34119: new java/lang/StringBuilder
/*      */     //   34122: dup
/*      */     //   34123: invokespecial <init> : ()V
/*      */     //   34126: ldc_w 'Failed to load ''
/*      */     //   34129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34132: aload_0
/*      */     //   34133: getfield tracks : LSmenu;
/*      */     //   34136: invokevirtual getSelectedItem : ()Ljava/lang/String;
/*      */     //   34139: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34142: ldc_w '', please make sure it is a valid MOD Track!'
/*      */     //   34145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34148: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   34151: ldc_w 'Stage Maker'
/*      */     //   34154: iconst_1
/*      */     //   34155: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   34158: goto_w -> 34163
/*      */     //   34163: aload_0
/*      */     //   34164: ldc_w '   X Delete   '
/*      */     //   34167: sipush #258
/*      */     //   34170: sipush #495
/*      */     //   34173: iconst_2
/*      */     //   34174: iconst_0
/*      */     //   34175: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   34178: ifne -> 34186
/*      */     //   34181: goto_w -> 34243
/*      */     //   34186: aconst_null
/*      */     //   34187: new java/lang/StringBuilder
/*      */     //   34190: dup
/*      */     //   34191: invokespecial <init> : ()V
/*      */     //   34194: ldc_w 'Are you sure you want to permanently delete this MOD Track from your Play List?\\n\\n'
/*      */     //   34197: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34200: aload_0
/*      */     //   34201: getfield tracks : LSmenu;
/*      */     //   34204: invokevirtual getSelectedItem : ()Ljava/lang/String;
/*      */     //   34207: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34210: ldc_w '\\n\\n>  If you delete this Track from the Play List you will not be able to use it for other stages as well!     \\n\\n'
/*      */     //   34213: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34216: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   34219: ldc_w 'Stage Maker'
/*      */     //   34222: iconst_0
/*      */     //   34223: invokestatic showConfirmDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)I
/*      */     //   34226: ifeq -> 34234
/*      */     //   34229: goto_w -> 34243
/*      */     //   34234: aload_0
/*      */     //   34235: invokevirtual deltrack : ()V
/*      */     //   34238: goto_w -> 34243
/*      */     //   34243: aload_0
/*      */     //   34244: ldc_w '      Add a new Track from a file . . .     '
/*      */     //   34247: sipush #330
/*      */     //   34250: sipush #530
/*      */     //   34253: iconst_0
/*      */     //   34254: iconst_0
/*      */     //   34255: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   34258: ifne -> 34266
/*      */     //   34261: goto_w -> 35277
/*      */     //   34266: aconst_null
/*      */     //   34267: ldc_w 'The game only accepts Module format music files for the game ('.mod', '.xm' and '.s3m' file extensions).\\nA good place to find Module Tracks is the modarchive.com, all the current Module Tracks\\nthat are distributed with the game are from the modarchive.com.\\n\\nTo find out more about Module Tracks and to learn how to compose & remix your own\\nmusic, please read the section of the Stage Maker help about it.\\n\\nThe Stage Maker accepts only '.mod', '.xm' & '.s3m' files or a '.zip' file containing a Module file.\\nThe file size of the Module must be less the 700KB (when compressed as a zip file).\\n'
/*      */     //   34270: ldc_w 'Stage Maker'
/*      */     //   34273: iconst_0
/*      */     //   34274: invokestatic showConfirmDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)I
/*      */     //   34277: ifeq -> 34285
/*      */     //   34280: goto_w -> 35277
/*      */     //   34285: aconst_null
/*      */     //   34286: astore #7
/*      */     //   34288: new java/awt/FileDialog
/*      */     //   34291: dup
/*      */     //   34292: new java/awt/Frame
/*      */     //   34295: dup
/*      */     //   34296: invokespecial <init> : ()V
/*      */     //   34299: ldc_w 'Stage Maker - Add MOD Track file to stage sound track play list!'
/*      */     //   34302: invokespecial <init> : (Ljava/awt/Frame;Ljava/lang/String;)V
/*      */     //   34305: astore #8
/*      */     //   34307: aload #8
/*      */     //   34309: ldc_w '*.mod;*.xm;*.s3m;*.zip'
/*      */     //   34312: invokevirtual setFile : (Ljava/lang/String;)V
/*      */     //   34315: aload #8
/*      */     //   34317: iconst_0
/*      */     //   34318: invokevirtual setMode : (I)V
/*      */     //   34321: aload #8
/*      */     //   34323: iconst_1
/*      */     //   34324: invokevirtual setVisible : (Z)V
/*      */     //   34327: aload #8
/*      */     //   34329: invokevirtual getFile : ()Ljava/lang/String;
/*      */     //   34332: ifnonnull -> 34340
/*      */     //   34335: goto_w -> 34395
/*      */     //   34340: new java/io/File
/*      */     //   34343: dup
/*      */     //   34344: new java/lang/StringBuilder
/*      */     //   34347: dup
/*      */     //   34348: invokespecial <init> : ()V
/*      */     //   34351: ldc ''
/*      */     //   34353: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34356: aload #8
/*      */     //   34358: invokevirtual getDirectory : ()Ljava/lang/String;
/*      */     //   34361: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34364: ldc ''
/*      */     //   34366: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34369: aload #8
/*      */     //   34371: invokevirtual getFile : ()Ljava/lang/String;
/*      */     //   34374: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34377: ldc ''
/*      */     //   34379: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34382: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   34385: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   34388: astore #7
/*      */     //   34390: goto_w -> 34395
/*      */     //   34395: goto_w -> 34402
/*      */     //   34400: astore #9
/*      */     //   34402: aload #7
/*      */     //   34404: ifnonnull -> 34412
/*      */     //   34407: goto_w -> 35272
/*      */     //   34412: aload #8
/*      */     //   34414: invokevirtual getFile : ()Ljava/lang/String;
/*      */     //   34417: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   34420: ldc_w '.mod'
/*      */     //   34423: invokevirtual endsWith : (Ljava/lang/String;)Z
/*      */     //   34426: ifeq -> 34434
/*      */     //   34429: goto_w -> 34478
/*      */     //   34434: aload #8
/*      */     //   34436: invokevirtual getFile : ()Ljava/lang/String;
/*      */     //   34439: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   34442: ldc_w '.xm'
/*      */     //   34445: invokevirtual endsWith : (Ljava/lang/String;)Z
/*      */     //   34448: ifeq -> 34456
/*      */     //   34451: goto_w -> 34478
/*      */     //   34456: aload #8
/*      */     //   34458: invokevirtual getFile : ()Ljava/lang/String;
/*      */     //   34461: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   34464: ldc_w '.s3m'
/*      */     //   34467: invokevirtual endsWith : (Ljava/lang/String;)Z
/*      */     //   34470: ifne -> 34478
/*      */     //   34473: goto_w -> 34831
/*      */     //   34478: new java/io/File
/*      */     //   34481: dup
/*      */     //   34482: new java/lang/StringBuilder
/*      */     //   34485: dup
/*      */     //   34486: invokespecial <init> : ()V
/*      */     //   34489: ldc ''
/*      */     //   34491: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34494: getstatic Madness.fpath : Ljava/lang/String;
/*      */     //   34497: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34500: ldc_w 'mystages/mymusic/'
/*      */     //   34503: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34506: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   34509: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   34512: astore #9
/*      */     //   34514: aload #9
/*      */     //   34516: invokevirtual exists : ()Z
/*      */     //   34519: ifeq -> 34527
/*      */     //   34522: goto_w -> 34538
/*      */     //   34527: aload #9
/*      */     //   34529: invokevirtual mkdirs : ()Z
/*      */     //   34532: pop
/*      */     //   34533: goto_w -> 34538
/*      */     //   34538: new java/lang/StringBuilder
/*      */     //   34541: dup
/*      */     //   34542: invokespecial <init> : ()V
/*      */     //   34545: ldc ''
/*      */     //   34547: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34550: getstatic Madness.fpath : Ljava/lang/String;
/*      */     //   34553: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34556: ldc_w 'mystages/mymusic/'
/*      */     //   34559: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34562: aload #7
/*      */     //   34564: invokevirtual getName : ()Ljava/lang/String;
/*      */     //   34567: iconst_0
/*      */     //   34568: aload #7
/*      */     //   34570: invokevirtual getName : ()Ljava/lang/String;
/*      */     //   34573: invokevirtual length : ()I
/*      */     //   34576: iconst_4
/*      */     //   34577: isub
/*      */     //   34578: invokevirtual substring : (II)Ljava/lang/String;
/*      */     //   34581: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34584: ldc_w '.zip'
/*      */     //   34587: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34590: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   34593: astore #10
/*      */     //   34595: new java/io/FileInputStream
/*      */     //   34598: dup
/*      */     //   34599: aload #7
/*      */     //   34601: invokespecial <init> : (Ljava/io/File;)V
/*      */     //   34604: astore #11
/*      */     //   34606: new java/util/zip/ZipOutputStream
/*      */     //   34609: dup
/*      */     //   34610: new java/io/FileOutputStream
/*      */     //   34613: dup
/*      */     //   34614: aload #10
/*      */     //   34616: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   34619: invokespecial <init> : (Ljava/io/OutputStream;)V
/*      */     //   34622: astore #12
/*      */     //   34624: new java/util/zip/ZipEntry
/*      */     //   34627: dup
/*      */     //   34628: new java/lang/StringBuilder
/*      */     //   34631: dup
/*      */     //   34632: invokespecial <init> : ()V
/*      */     //   34635: ldc ''
/*      */     //   34637: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34640: aload #7
/*      */     //   34642: invokevirtual getName : ()Ljava/lang/String;
/*      */     //   34645: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34648: ldc ''
/*      */     //   34650: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34653: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   34656: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   34659: astore #13
/*      */     //   34661: aload #13
/*      */     //   34663: aload #7
/*      */     //   34665: invokevirtual length : ()J
/*      */     //   34668: invokevirtual setSize : (J)V
/*      */     //   34671: aload #12
/*      */     //   34673: aload #13
/*      */     //   34675: invokevirtual putNextEntry : (Ljava/util/zip/ZipEntry;)V
/*      */     //   34678: sipush #1024
/*      */     //   34681: newarray byte
/*      */     //   34683: astore #14
/*      */     //   34685: aload #11
/*      */     //   34687: aload #14
/*      */     //   34689: invokevirtual read : ([B)I
/*      */     //   34692: dup
/*      */     //   34693: istore #15
/*      */     //   34695: ifgt -> 34703
/*      */     //   34698: goto_w -> 34718
/*      */     //   34703: aload #12
/*      */     //   34705: aload #14
/*      */     //   34707: iconst_0
/*      */     //   34708: iload #15
/*      */     //   34710: invokevirtual write : ([BII)V
/*      */     //   34713: goto_w -> 34685
/*      */     //   34718: aload #12
/*      */     //   34720: invokevirtual closeEntry : ()V
/*      */     //   34723: aload #12
/*      */     //   34725: invokevirtual close : ()V
/*      */     //   34728: aload #11
/*      */     //   34730: invokevirtual close : ()V
/*      */     //   34733: new java/io/File
/*      */     //   34736: dup
/*      */     //   34737: new java/lang/StringBuilder
/*      */     //   34740: dup
/*      */     //   34741: invokespecial <init> : ()V
/*      */     //   34744: ldc ''
/*      */     //   34746: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34749: getstatic Madness.fpath : Ljava/lang/String;
/*      */     //   34752: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34755: ldc_w 'mystages/mymusic/'
/*      */     //   34758: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34761: aload #7
/*      */     //   34763: invokevirtual getName : ()Ljava/lang/String;
/*      */     //   34766: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34769: ldc_w '.zip'
/*      */     //   34772: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34775: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   34778: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   34781: astore #9
/*      */     //   34783: aload #9
/*      */     //   34785: invokevirtual length : ()J
/*      */     //   34788: ldc2_w 1024
/*      */     //   34791: ldiv
/*      */     //   34792: ldc2_w 700
/*      */     //   34795: lcmp
/*      */     //   34796: ifge -> 34804
/*      */     //   34799: goto_w -> 34826
/*      */     //   34804: aconst_null
/*      */     //   34805: ldc_w 'The selected file is larger then 700KB in size when zipped and therefore cannot be added!'
/*      */     //   34808: ldc_w 'Stage Maker'
/*      */     //   34811: iconst_1
/*      */     //   34812: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   34815: aload #9
/*      */     //   34817: invokevirtual delete : ()Z
/*      */     //   34820: pop
/*      */     //   34821: goto_w -> 34826
/*      */     //   34826: goto_w -> 35049
/*      */     //   34831: aload #7
/*      */     //   34833: invokevirtual length : ()J
/*      */     //   34836: ldc2_w 1024
/*      */     //   34839: ldiv
/*      */     //   34840: ldc2_w 700
/*      */     //   34843: lcmp
/*      */     //   34844: iflt -> 34852
/*      */     //   34847: goto_w -> 35038
/*      */     //   34852: new java/io/File
/*      */     //   34855: dup
/*      */     //   34856: new java/lang/StringBuilder
/*      */     //   34859: dup
/*      */     //   34860: invokespecial <init> : ()V
/*      */     //   34863: ldc ''
/*      */     //   34865: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34868: getstatic Madness.fpath : Ljava/lang/String;
/*      */     //   34871: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34874: ldc_w 'mystages/mymusic/'
/*      */     //   34877: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34880: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   34883: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   34886: astore #9
/*      */     //   34888: aload #9
/*      */     //   34890: invokevirtual exists : ()Z
/*      */     //   34893: ifeq -> 34901
/*      */     //   34896: goto_w -> 34912
/*      */     //   34901: aload #9
/*      */     //   34903: invokevirtual mkdirs : ()Z
/*      */     //   34906: pop
/*      */     //   34907: goto_w -> 34912
/*      */     //   34912: new java/io/File
/*      */     //   34915: dup
/*      */     //   34916: new java/lang/StringBuilder
/*      */     //   34919: dup
/*      */     //   34920: invokespecial <init> : ()V
/*      */     //   34923: ldc ''
/*      */     //   34925: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34928: getstatic Madness.fpath : Ljava/lang/String;
/*      */     //   34931: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34934: ldc_w 'mystages/mymusic/'
/*      */     //   34937: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34940: aload #7
/*      */     //   34942: invokevirtual getName : ()Ljava/lang/String;
/*      */     //   34945: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34948: ldc ''
/*      */     //   34950: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   34953: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   34956: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   34959: astore #9
/*      */     //   34961: new java/io/FileInputStream
/*      */     //   34964: dup
/*      */     //   34965: aload #7
/*      */     //   34967: invokespecial <init> : (Ljava/io/File;)V
/*      */     //   34970: astore #10
/*      */     //   34972: new java/io/FileOutputStream
/*      */     //   34975: dup
/*      */     //   34976: aload #9
/*      */     //   34978: invokespecial <init> : (Ljava/io/File;)V
/*      */     //   34981: astore #11
/*      */     //   34983: sipush #1024
/*      */     //   34986: newarray byte
/*      */     //   34988: astore #12
/*      */     //   34990: aload #10
/*      */     //   34992: aload #12
/*      */     //   34994: invokevirtual read : ([B)I
/*      */     //   34997: dup
/*      */     //   34998: istore #13
/*      */     //   35000: ifgt -> 35008
/*      */     //   35003: goto_w -> 35023
/*      */     //   35008: aload #11
/*      */     //   35010: aload #12
/*      */     //   35012: iconst_0
/*      */     //   35013: iload #13
/*      */     //   35015: invokevirtual write : ([BII)V
/*      */     //   35018: goto_w -> 34990
/*      */     //   35023: aload #10
/*      */     //   35025: invokevirtual close : ()V
/*      */     //   35028: aload #11
/*      */     //   35030: invokevirtual close : ()V
/*      */     //   35033: goto_w -> 35049
/*      */     //   35038: aconst_null
/*      */     //   35039: ldc_w 'The selected file is larger then 700KB in size and therefore cannot be added!'
/*      */     //   35042: ldc_w 'Stage Maker'
/*      */     //   35045: iconst_1
/*      */     //   35046: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   35049: aload_0
/*      */     //   35050: getfield tracks : LSmenu;
/*      */     //   35053: invokevirtual removeAll : ()V
/*      */     //   35056: aload_0
/*      */     //   35057: getfield tracks : LSmenu;
/*      */     //   35060: aload_0
/*      */     //   35061: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   35064: ldc_w 'Select MOD Track                      '
/*      */     //   35067: invokevirtual add : (Ljava/awt/Graphics2D;Ljava/lang/String;)V
/*      */     //   35070: new java/io/File
/*      */     //   35073: dup
/*      */     //   35074: new java/lang/StringBuilder
/*      */     //   35077: dup
/*      */     //   35078: invokespecial <init> : ()V
/*      */     //   35081: ldc ''
/*      */     //   35083: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   35086: getstatic Madness.fpath : Ljava/lang/String;
/*      */     //   35089: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   35092: ldc_w 'mystages/mymusic/'
/*      */     //   35095: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   35098: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   35101: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   35104: invokevirtual list : ()[Ljava/lang/String;
/*      */     //   35107: astore #9
/*      */     //   35109: aload #9
/*      */     //   35111: ifnonnull -> 35119
/*      */     //   35114: goto_w -> 35205
/*      */     //   35119: iconst_0
/*      */     //   35120: istore #10
/*      */     //   35122: iload #10
/*      */     //   35124: aload #9
/*      */     //   35126: arraylength
/*      */     //   35127: if_icmplt -> 35135
/*      */     //   35130: goto_w -> 35200
/*      */     //   35135: aload #9
/*      */     //   35137: iload #10
/*      */     //   35139: aaload
/*      */     //   35140: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   35143: ldc_w '.zip'
/*      */     //   35146: invokevirtual endsWith : (Ljava/lang/String;)Z
/*      */     //   35149: ifne -> 35157
/*      */     //   35152: goto_w -> 35192
/*      */     //   35157: aload_0
/*      */     //   35158: getfield tracks : LSmenu;
/*      */     //   35161: aload_0
/*      */     //   35162: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   35165: aload #9
/*      */     //   35167: iload #10
/*      */     //   35169: aaload
/*      */     //   35170: iconst_0
/*      */     //   35171: aload #9
/*      */     //   35173: iload #10
/*      */     //   35175: aaload
/*      */     //   35176: invokevirtual length : ()I
/*      */     //   35179: iconst_4
/*      */     //   35180: isub
/*      */     //   35181: invokevirtual substring : (II)Ljava/lang/String;
/*      */     //   35184: invokevirtual add : (Ljava/awt/Graphics2D;Ljava/lang/String;)V
/*      */     //   35187: goto_w -> 35192
/*      */     //   35192: iinc #10, 1
/*      */     //   35195: goto_w -> 35122
/*      */     //   35200: goto_w -> 35205
/*      */     //   35205: aload_0
/*      */     //   35206: getfield tracks : LSmenu;
/*      */     //   35209: aload #7
/*      */     //   35211: invokevirtual getName : ()Ljava/lang/String;
/*      */     //   35214: iconst_0
/*      */     //   35215: aload #7
/*      */     //   35217: invokevirtual getName : ()Ljava/lang/String;
/*      */     //   35220: invokevirtual length : ()I
/*      */     //   35223: iconst_4
/*      */     //   35224: isub
/*      */     //   35225: invokevirtual substring : (II)Ljava/lang/String;
/*      */     //   35228: invokevirtual select : (Ljava/lang/String;)V
/*      */     //   35231: goto_w -> 35272
/*      */     //   35236: astore #9
/*      */     //   35238: aconst_null
/*      */     //   35239: new java/lang/StringBuilder
/*      */     //   35242: dup
/*      */     //   35243: invokespecial <init> : ()V
/*      */     //   35246: ldc_w 'Unable to copy file! Error Deatials:\\n'
/*      */     //   35249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   35252: aload #9
/*      */     //   35254: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*      */     //   35257: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   35260: ldc_w 'Stage Maker'
/*      */     //   35263: iconst_1
/*      */     //   35264: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   35267: goto_w -> 35272
/*      */     //   35272: goto_w -> 35277
/*      */     //   35277: sipush #200
/*      */     //   35280: istore #7
/*      */     //   35282: aload_0
/*      */     //   35283: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   35286: new java/awt/Color
/*      */     //   35289: dup
/*      */     //   35290: iconst_0
/*      */     //   35291: iconst_0
/*      */     //   35292: iconst_0
/*      */     //   35293: invokespecial <init> : (III)V
/*      */     //   35296: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   35299: aload_0
/*      */     //   35300: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   35303: ldc_w 'Sound Track'
/*      */     //   35306: sipush #280
/*      */     //   35309: iload #7
/*      */     //   35311: iadd
/*      */     //   35312: sipush #461
/*      */     //   35315: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   35318: aload_0
/*      */     //   35319: getfield trackname : Ljava/lang/String;
/*      */     //   35322: astore #8
/*      */     //   35324: aload #8
/*      */     //   35326: ldc ''
/*      */     //   35328: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   35331: ifne -> 35339
/*      */     //   35334: goto_w -> 35349
/*      */     //   35339: ldc_w 'No Sound Track set.'
/*      */     //   35342: astore #8
/*      */     //   35344: goto_w -> 35383
/*      */     //   35349: aload_0
/*      */     //   35350: ldc_w '   <  Remove Track   '
/*      */     //   35353: sipush #378
/*      */     //   35356: sipush #495
/*      */     //   35359: iconst_2
/*      */     //   35360: iconst_0
/*      */     //   35361: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   35364: ifne -> 35372
/*      */     //   35367: goto_w -> 35383
/*      */     //   35372: aload_0
/*      */     //   35373: ldc ''
/*      */     //   35375: putfield trackname : Ljava/lang/String;
/*      */     //   35378: goto_w -> 35383
/*      */     //   35383: aload_0
/*      */     //   35384: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   35387: aload #8
/*      */     //   35389: sipush #629
/*      */     //   35392: aload_0
/*      */     //   35393: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   35396: aload #8
/*      */     //   35398: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   35401: iconst_2
/*      */     //   35402: idiv
/*      */     //   35403: isub
/*      */     //   35404: sipush #482
/*      */     //   35407: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   35410: aload_0
/*      */     //   35411: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   35414: new java/awt/Color
/*      */     //   35417: dup
/*      */     //   35418: sipush #128
/*      */     //   35421: sipush #128
/*      */     //   35424: sipush #128
/*      */     //   35427: invokespecial <init> : (III)V
/*      */     //   35430: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   35433: aload_0
/*      */     //   35434: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   35437: sipush #270
/*      */     //   35440: iload #7
/*      */     //   35442: iadd
/*      */     //   35443: sipush #457
/*      */     //   35446: sipush #277
/*      */     //   35449: iload #7
/*      */     //   35451: iadd
/*      */     //   35452: sipush #457
/*      */     //   35455: invokevirtual drawLine : (IIII)V
/*      */     //   35458: aload_0
/*      */     //   35459: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   35462: sipush #589
/*      */     //   35465: iload #7
/*      */     //   35467: iadd
/*      */     //   35468: sipush #457
/*      */     //   35471: sipush #353
/*      */     //   35474: iload #7
/*      */     //   35476: iadd
/*      */     //   35477: sipush #457
/*      */     //   35480: invokevirtual drawLine : (IIII)V
/*      */     //   35483: aload_0
/*      */     //   35484: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   35487: sipush #270
/*      */     //   35490: iload #7
/*      */     //   35492: iadd
/*      */     //   35493: sipush #457
/*      */     //   35496: sipush #270
/*      */     //   35499: iload #7
/*      */     //   35501: iadd
/*      */     //   35502: sipush #497
/*      */     //   35505: invokevirtual drawLine : (IIII)V
/*      */     //   35508: aload_0
/*      */     //   35509: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   35512: sipush #589
/*      */     //   35515: iload #7
/*      */     //   35517: iadd
/*      */     //   35518: sipush #457
/*      */     //   35521: sipush #589
/*      */     //   35524: iload #7
/*      */     //   35526: iadd
/*      */     //   35527: sipush #497
/*      */     //   35530: invokevirtual drawLine : (IIII)V
/*      */     //   35533: aload_0
/*      */     //   35534: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   35537: sipush #270
/*      */     //   35540: iload #7
/*      */     //   35542: iadd
/*      */     //   35543: sipush #497
/*      */     //   35546: sipush #589
/*      */     //   35549: iload #7
/*      */     //   35551: iadd
/*      */     //   35552: sipush #497
/*      */     //   35555: invokevirtual drawLine : (IIII)V
/*      */     //   35558: aload_0
/*      */     //   35559: ldc_w ' Reset '
/*      */     //   35562: sipush #576
/*      */     //   35565: sipush #530
/*      */     //   35568: iconst_0
/*      */     //   35569: iconst_1
/*      */     //   35570: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   35573: ifne -> 35581
/*      */     //   35576: goto_w -> 35598
/*      */     //   35581: aload_0
/*      */     //   35582: ldc ''
/*      */     //   35584: putfield ltrackname : Ljava/lang/String;
/*      */     //   35587: aload_0
/*      */     //   35588: bipush #-2
/*      */     //   35590: putfield dtabed : I
/*      */     //   35593: goto_w -> 35598
/*      */     //   35598: aload_0
/*      */     //   35599: ldc_w '        Save        '
/*      */     //   35602: sipush #663
/*      */     //   35605: sipush #530
/*      */     //   35608: iconst_0
/*      */     //   35609: iconst_1
/*      */     //   35610: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   35613: ifne -> 35621
/*      */     //   35616: goto_w -> 35634
/*      */     //   35621: aload_0
/*      */     //   35622: invokevirtual sortop : ()V
/*      */     //   35625: aload_0
/*      */     //   35626: invokevirtual savefile : ()V
/*      */     //   35629: goto_w -> 35634
/*      */     //   35634: goto_w -> 35639
/*      */     //   35639: aload_0
/*      */     //   35640: getfield dtab : I
/*      */     //   35643: bipush #6
/*      */     //   35645: if_icmpeq -> 35653
/*      */     //   35648: goto_w -> 35922
/*      */     //   35653: aload_0
/*      */     //   35654: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   35657: new java/awt/Color
/*      */     //   35660: dup
/*      */     //   35661: iconst_0
/*      */     //   35662: iconst_0
/*      */     //   35663: iconst_0
/*      */     //   35664: invokespecial <init> : (III)V
/*      */     //   35667: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   35670: aload_0
/*      */     //   35671: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   35674: new java/awt/Font
/*      */     //   35677: dup
/*      */     //   35678: ldc_w 'Arial'
/*      */     //   35681: iconst_1
/*      */     //   35682: bipush #13
/*      */     //   35684: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   35687: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   35690: aload_0
/*      */     //   35691: aload_0
/*      */     //   35692: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   35695: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   35698: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   35701: aload_0
/*      */     //   35702: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   35705: ldc_w 'Test Drive the Stage'
/*      */     //   35708: sipush #400
/*      */     //   35711: aload_0
/*      */     //   35712: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   35715: ldc_w 'Test Drive the Stage'
/*      */     //   35718: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   35721: iconst_2
/*      */     //   35722: idiv
/*      */     //   35723: isub
/*      */     //   35724: sipush #470
/*      */     //   35727: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   35730: aload_0
/*      */     //   35731: getfield witho : LSmenu;
/*      */     //   35734: sipush #342
/*      */     //   35737: sipush #480
/*      */     //   35740: invokevirtual move : (II)V
/*      */     //   35743: aload_0
/*      */     //   35744: getfield witho : LSmenu;
/*      */     //   35747: invokevirtual isShowing : ()Z
/*      */     //   35750: ifeq -> 35758
/*      */     //   35753: goto_w -> 35770
/*      */     //   35758: aload_0
/*      */     //   35759: getfield witho : LSmenu;
/*      */     //   35762: invokevirtual show : ()V
/*      */     //   35765: goto_w -> 35770
/*      */     //   35770: aload_0
/*      */     //   35771: ldc_w '     TEST DRIVE!     '
/*      */     //   35774: sipush #400
/*      */     //   35777: sipush #530
/*      */     //   35780: iconst_0
/*      */     //   35781: iconst_1
/*      */     //   35782: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   35785: ifne -> 35793
/*      */     //   35788: goto_w -> 35922
/*      */     //   35793: aload_0
/*      */     //   35794: invokevirtual savefile : ()V
/*      */     //   35797: aload_0
/*      */     //   35798: iconst_0
/*      */     //   35799: putfield errd : I
/*      */     //   35802: aload_0
/*      */     //   35803: iconst_3
/*      */     //   35804: invokevirtual readstage : (I)V
/*      */     //   35807: aload_0
/*      */     //   35808: getfield cp : LCheckPoints;
/*      */     //   35811: getfield nsp : I
/*      */     //   35814: iconst_2
/*      */     //   35815: if_icmplt -> 35823
/*      */     //   35818: goto_w -> 35834
/*      */     //   35823: aload_0
/*      */     //   35824: bipush #7
/*      */     //   35826: putfield errd : I
/*      */     //   35829: goto_w -> 35834
/*      */     //   35834: aload_0
/*      */     //   35835: getfield errd : I
/*      */     //   35838: ifeq -> 35846
/*      */     //   35841: goto_w -> 35873
/*      */     //   35846: aload_0
/*      */     //   35847: getfield stagename : Ljava/lang/String;
/*      */     //   35850: putstatic Madness.testcar : Ljava/lang/String;
/*      */     //   35853: aload_0
/*      */     //   35854: getfield witho : LSmenu;
/*      */     //   35857: invokevirtual getSelectedIndex : ()I
/*      */     //   35860: iconst_3
/*      */     //   35861: iadd
/*      */     //   35862: putstatic Madness.testdrive : I
/*      */     //   35865: invokestatic game : ()V
/*      */     //   35868: goto_w -> 35922
/*      */     //   35873: aconst_null
/*      */     //   35874: new java/lang/StringBuilder
/*      */     //   35877: dup
/*      */     //   35878: invokespecial <init> : ()V
/*      */     //   35881: ldc_w 'Error!  This stage is not ready for a test drive!\\nReason:\\n'
/*      */     //   35884: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   35887: aload_0
/*      */     //   35888: getfield errlo : [Ljava/lang/String;
/*      */     //   35891: aload_0
/*      */     //   35892: getfield errd : I
/*      */     //   35895: iconst_1
/*      */     //   35896: isub
/*      */     //   35897: aaload
/*      */     //   35898: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   35901: ldc_w '\\n\\n'
/*      */     //   35904: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   35907: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   35910: ldc_w 'Stage Maker'
/*      */     //   35913: iconst_0
/*      */     //   35914: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   35917: goto_w -> 35922
/*      */     //   35922: aload_0
/*      */     //   35923: getfield dtabed : I
/*      */     //   35926: aload_0
/*      */     //   35927: getfield dtab : I
/*      */     //   35930: if_icmpne -> 35938
/*      */     //   35933: goto_w -> 35975
/*      */     //   35938: aload_0
/*      */     //   35939: getfield dtabed : I
/*      */     //   35942: bipush #-2
/*      */     //   35944: if_icmpeq -> 35952
/*      */     //   35947: goto_w -> 35962
/*      */     //   35952: aload_0
/*      */     //   35953: iconst_m1
/*      */     //   35954: putfield dtabed : I
/*      */     //   35957: goto_w -> 35975
/*      */     //   35962: aload_0
/*      */     //   35963: aload_0
/*      */     //   35964: getfield dtab : I
/*      */     //   35967: putfield dtabed : I
/*      */     //   35970: goto_w -> 35975
/*      */     //   35975: goto_w -> 35980
/*      */     //   35980: aload_0
/*      */     //   35981: getfield tab : I
/*      */     //   35984: iconst_3
/*      */     //   35985: if_icmpeq -> 35993
/*      */     //   35988: goto_w -> 43819
/*      */     //   35993: aload_0
/*      */     //   35994: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   35997: new java/awt/Font
/*      */     //   36000: dup
/*      */     //   36001: ldc_w 'Arial'
/*      */     //   36004: iconst_1
/*      */     //   36005: bipush #13
/*      */     //   36007: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   36010: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   36013: aload_0
/*      */     //   36014: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36017: new java/awt/Color
/*      */     //   36020: dup
/*      */     //   36021: iconst_0
/*      */     //   36022: iconst_0
/*      */     //   36023: iconst_0
/*      */     //   36024: invokespecial <init> : (III)V
/*      */     //   36027: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   36030: aload_0
/*      */     //   36031: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36034: new java/lang/StringBuilder
/*      */     //   36037: dup
/*      */     //   36038: invokespecial <init> : ()V
/*      */     //   36041: ldc_w 'Publish Stage :  [ '
/*      */     //   36044: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   36047: aload_0
/*      */     //   36048: getfield stagename : Ljava/lang/String;
/*      */     //   36051: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   36054: ldc_w ' ]'
/*      */     //   36057: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   36060: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   36063: bipush #30
/*      */     //   36065: bipush #50
/*      */     //   36067: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   36070: aload_0
/*      */     //   36071: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36074: ldc_w 'Publishing Type :'
/*      */     //   36077: bipush #30
/*      */     //   36079: bipush #80
/*      */     //   36081: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   36084: aload_0
/*      */     //   36085: getfield pubtyp : LSmenu;
/*      */     //   36088: sipush #150
/*      */     //   36091: bipush #63
/*      */     //   36093: invokevirtual move : (II)V
/*      */     //   36096: aload_0
/*      */     //   36097: getfield pubtyp : LSmenu;
/*      */     //   36100: invokevirtual isShowing : ()Z
/*      */     //   36103: ifeq -> 36111
/*      */     //   36106: goto_w -> 36131
/*      */     //   36111: aload_0
/*      */     //   36112: getfield pubtyp : LSmenu;
/*      */     //   36115: invokevirtual show : ()V
/*      */     //   36118: aload_0
/*      */     //   36119: getfield pubtyp : LSmenu;
/*      */     //   36122: iconst_1
/*      */     //   36123: invokevirtual select : (I)V
/*      */     //   36126: goto_w -> 36131
/*      */     //   36131: aload_0
/*      */     //   36132: getfield pubitem : LSmenu;
/*      */     //   36135: sipush #790
/*      */     //   36138: aload_0
/*      */     //   36139: getfield pubitem : LSmenu;
/*      */     //   36142: getfield w : I
/*      */     //   36145: isub
/*      */     //   36146: bipush #96
/*      */     //   36148: invokevirtual move : (II)V
/*      */     //   36151: aload_0
/*      */     //   36152: getfield pubitem : LSmenu;
/*      */     //   36155: invokevirtual isShowing : ()Z
/*      */     //   36158: ifeq -> 36166
/*      */     //   36161: goto_w -> 36178
/*      */     //   36166: aload_0
/*      */     //   36167: getfield pubitem : LSmenu;
/*      */     //   36170: invokevirtual show : ()V
/*      */     //   36173: goto_w -> 36178
/*      */     //   36178: aload_0
/*      */     //   36179: getfield pubitem : LSmenu;
/*      */     //   36182: getfield sel : I
/*      */     //   36185: ifne -> 36193
/*      */     //   36188: goto_w -> 36273
/*      */     //   36193: iconst_0
/*      */     //   36194: istore_1
/*      */     //   36195: iconst_0
/*      */     //   36196: istore_2
/*      */     //   36197: iload_2
/*      */     //   36198: aload_0
/*      */     //   36199: getfield nms : I
/*      */     //   36202: if_icmplt -> 36210
/*      */     //   36205: goto_w -> 36249
/*      */     //   36210: aload_0
/*      */     //   36211: getfield pubitem : LSmenu;
/*      */     //   36214: invokevirtual getSelectedItem : ()Ljava/lang/String;
/*      */     //   36217: aload_0
/*      */     //   36218: getfield mystages : [Ljava/lang/String;
/*      */     //   36221: iload_2
/*      */     //   36222: aaload
/*      */     //   36223: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   36226: ifne -> 36234
/*      */     //   36229: goto_w -> 36241
/*      */     //   36234: iconst_1
/*      */     //   36235: istore_1
/*      */     //   36236: goto_w -> 36241
/*      */     //   36241: iinc #2, 1
/*      */     //   36244: goto_w -> 36197
/*      */     //   36249: iload_1
/*      */     //   36250: ifeq -> 36258
/*      */     //   36253: goto_w -> 36268
/*      */     //   36258: aload_0
/*      */     //   36259: iconst_2
/*      */     //   36260: putfield logged : I
/*      */     //   36263: goto_w -> 36268
/*      */     //   36268: goto_w -> 36273
/*      */     //   36273: aload_0
/*      */     //   36274: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36277: new java/awt/Color
/*      */     //   36280: dup
/*      */     //   36281: iconst_0
/*      */     //   36282: iconst_0
/*      */     //   36283: iconst_0
/*      */     //   36284: invokespecial <init> : (III)V
/*      */     //   36287: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   36290: aload_0
/*      */     //   36291: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36294: new java/awt/Font
/*      */     //   36297: dup
/*      */     //   36298: ldc_w 'Arial'
/*      */     //   36301: iconst_0
/*      */     //   36302: bipush #12
/*      */     //   36304: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   36307: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   36310: aload_0
/*      */     //   36311: getfield pubtyp : LSmenu;
/*      */     //   36314: invokevirtual getSelectedIndex : ()I
/*      */     //   36317: ifeq -> 36325
/*      */     //   36320: goto_w -> 36360
/*      */     //   36325: aload_0
/*      */     //   36326: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36329: ldc_w 'Private :  This means only you can have your stage in your account and no one else can add'
/*      */     //   36332: sipush #268
/*      */     //   36335: bipush #72
/*      */     //   36337: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   36340: aload_0
/*      */     //   36341: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36344: ldc_w 'it to their account to play it!'
/*      */     //   36347: sipush #268
/*      */     //   36350: bipush #88
/*      */     //   36352: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   36355: goto_w -> 36360
/*      */     //   36360: aload_0
/*      */     //   36361: getfield pubtyp : LSmenu;
/*      */     //   36364: invokevirtual getSelectedIndex : ()I
/*      */     //   36367: iconst_1
/*      */     //   36368: if_icmpeq -> 36376
/*      */     //   36371: goto_w -> 36411
/*      */     //   36376: aload_0
/*      */     //   36377: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36380: ldc_w 'Public :  This means anyone can add this stage to their account to play it, but only you can'
/*      */     //   36383: sipush #268
/*      */     //   36386: bipush #72
/*      */     //   36388: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   36391: aload_0
/*      */     //   36392: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36395: ldc_w 'download it to your Stage Maker and edit it (no one else but you can edit it).'
/*      */     //   36398: sipush #268
/*      */     //   36401: bipush #88
/*      */     //   36403: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   36406: goto_w -> 36411
/*      */     //   36411: aload_0
/*      */     //   36412: getfield pubtyp : LSmenu;
/*      */     //   36415: invokevirtual getSelectedIndex : ()I
/*      */     //   36418: iconst_2
/*      */     //   36419: if_icmpeq -> 36427
/*      */     //   36422: goto_w -> 36462
/*      */     //   36427: aload_0
/*      */     //   36428: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36431: ldc_w 'Super Public :  This means anyone can add this stage to their account to play it and can also'
/*      */     //   36434: sipush #268
/*      */     //   36437: bipush #72
/*      */     //   36439: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   36442: aload_0
/*      */     //   36443: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36446: ldc_w 'download it to their stage Maker, edit it and publish it.'
/*      */     //   36449: sipush #268
/*      */     //   36452: bipush #88
/*      */     //   36454: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   36457: goto_w -> 36462
/*      */     //   36462: aload_0
/*      */     //   36463: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36466: new java/awt/Font
/*      */     //   36469: dup
/*      */     //   36470: ldc_w 'Arial'
/*      */     //   36473: iconst_1
/*      */     //   36474: bipush #12
/*      */     //   36476: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   36479: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   36482: aload_0
/*      */     //   36483: aload_0
/*      */     //   36484: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36487: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   36490: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   36493: aload_0
/*      */     //   36494: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36497: ldc_w 'Stage Name'
/*      */     //   36500: sipush #180
/*      */     //   36503: aload_0
/*      */     //   36504: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   36507: ldc_w 'Stage Name'
/*      */     //   36510: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   36513: iconst_2
/*      */     //   36514: idiv
/*      */     //   36515: isub
/*      */     //   36516: sipush #138
/*      */     //   36519: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   36522: aload_0
/*      */     //   36523: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36526: ldc_w 'Created By'
/*      */     //   36529: sipush #400
/*      */     //   36532: aload_0
/*      */     //   36533: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   36536: ldc_w 'Created By'
/*      */     //   36539: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   36542: iconst_2
/*      */     //   36543: idiv
/*      */     //   36544: isub
/*      */     //   36545: sipush #138
/*      */     //   36548: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   36551: aload_0
/*      */     //   36552: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36555: ldc_w 'Added By'
/*      */     //   36558: sipush #500
/*      */     //   36561: aload_0
/*      */     //   36562: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   36565: ldc_w 'Added By'
/*      */     //   36568: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   36571: iconst_2
/*      */     //   36572: idiv
/*      */     //   36573: isub
/*      */     //   36574: sipush #138
/*      */     //   36577: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   36580: aload_0
/*      */     //   36581: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36584: ldc_w 'Publish Type'
/*      */     //   36587: sipush #600
/*      */     //   36590: aload_0
/*      */     //   36591: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   36594: ldc_w 'Publish Type'
/*      */     //   36597: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   36600: iconst_2
/*      */     //   36601: idiv
/*      */     //   36602: isub
/*      */     //   36603: sipush #138
/*      */     //   36606: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   36609: aload_0
/*      */     //   36610: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36613: ldc_w 'Options'
/*      */     //   36616: sipush #720
/*      */     //   36619: aload_0
/*      */     //   36620: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   36623: ldc_w 'Options'
/*      */     //   36626: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   36629: iconst_2
/*      */     //   36630: idiv
/*      */     //   36631: isub
/*      */     //   36632: sipush #138
/*      */     //   36635: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   36638: aload_0
/*      */     //   36639: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36642: sipush #350
/*      */     //   36645: sipush #129
/*      */     //   36648: sipush #350
/*      */     //   36651: sipush #140
/*      */     //   36654: invokevirtual drawLine : (IIII)V
/*      */     //   36657: aload_0
/*      */     //   36658: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36661: sipush #450
/*      */     //   36664: sipush #129
/*      */     //   36667: sipush #450
/*      */     //   36670: sipush #140
/*      */     //   36673: invokevirtual drawLine : (IIII)V
/*      */     //   36676: aload_0
/*      */     //   36677: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36680: sipush #550
/*      */     //   36683: sipush #129
/*      */     //   36686: sipush #550
/*      */     //   36689: sipush #140
/*      */     //   36692: invokevirtual drawLine : (IIII)V
/*      */     //   36695: aload_0
/*      */     //   36696: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36699: sipush #650
/*      */     //   36702: sipush #129
/*      */     //   36705: sipush #650
/*      */     //   36708: sipush #140
/*      */     //   36711: invokevirtual drawLine : (IIII)V
/*      */     //   36714: aload_0
/*      */     //   36715: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36718: bipush #10
/*      */     //   36720: sipush #140
/*      */     //   36723: sipush #780
/*      */     //   36726: sipush #402
/*      */     //   36729: invokevirtual drawRect : (IIII)V
/*      */     //   36732: aload_0
/*      */     //   36733: ldc_w '       Publish  >       '
/*      */     //   36736: bipush #102
/*      */     //   36738: bipush #110
/*      */     //   36740: iconst_0
/*      */     //   36741: iconst_1
/*      */     //   36742: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   36745: ifne -> 36753
/*      */     //   36748: goto_w -> 38627
/*      */     //   36753: aload_0
/*      */     //   36754: getfield logged : I
/*      */     //   36757: ifeq -> 36765
/*      */     //   36760: goto_w -> 36781
/*      */     //   36765: aconst_null
/*      */     //   36766: ldc_w 'Please login to retrieve your account first before publishing!'
/*      */     //   36769: ldc_w 'Stage Maker'
/*      */     //   36772: iconst_1
/*      */     //   36773: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   36776: goto_w -> 36781
/*      */     //   36781: aload_0
/*      */     //   36782: getfield logged : I
/*      */     //   36785: iconst_3
/*      */     //   36786: if_icmpne -> 36794
/*      */     //   36789: goto_w -> 36807
/*      */     //   36794: aload_0
/*      */     //   36795: getfield logged : I
/*      */     //   36798: iconst_m1
/*      */     //   36799: if_icmpeq -> 36807
/*      */     //   36802: goto_w -> 38627
/*      */     //   36807: aload_0
/*      */     //   36808: invokevirtual savefile : ()V
/*      */     //   36811: aload_0
/*      */     //   36812: iconst_0
/*      */     //   36813: putfield errd : I
/*      */     //   36816: aload_0
/*      */     //   36817: iconst_3
/*      */     //   36818: invokevirtual readstage : (I)V
/*      */     //   36821: aload_0
/*      */     //   36822: getfield cp : LCheckPoints;
/*      */     //   36825: getfield nsp : I
/*      */     //   36828: iconst_2
/*      */     //   36829: if_icmplt -> 36837
/*      */     //   36832: goto_w -> 36848
/*      */     //   36837: aload_0
/*      */     //   36838: bipush #7
/*      */     //   36840: putfield errd : I
/*      */     //   36843: goto_w -> 36848
/*      */     //   36848: aload_0
/*      */     //   36849: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36852: new java/awt/Font
/*      */     //   36855: dup
/*      */     //   36856: ldc_w 'Arial'
/*      */     //   36859: iconst_1
/*      */     //   36860: bipush #12
/*      */     //   36862: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   36865: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   36868: aload_0
/*      */     //   36869: aload_0
/*      */     //   36870: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   36873: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   36876: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   36879: aload_0
/*      */     //   36880: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   36883: aload_0
/*      */     //   36884: getfield stagename : Ljava/lang/String;
/*      */     //   36887: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   36890: sipush #274
/*      */     //   36893: if_icmpgt -> 36901
/*      */     //   36896: goto_w -> 36912
/*      */     //   36901: aload_0
/*      */     //   36902: bipush #8
/*      */     //   36904: putfield errd : I
/*      */     //   36907: goto_w -> 36912
/*      */     //   36912: aload_0
/*      */     //   36913: getfield errd : I
/*      */     //   36916: ifeq -> 36924
/*      */     //   36919: goto_w -> 38578
/*      */     //   36924: iconst_0
/*      */     //   36925: istore_1
/*      */     //   36926: iconst_0
/*      */     //   36927: istore_2
/*      */     //   36928: iload_2
/*      */     //   36929: aload_0
/*      */     //   36930: getfield pubitem : LSmenu;
/*      */     //   36933: getfield no : I
/*      */     //   36936: if_icmplt -> 36944
/*      */     //   36939: goto_w -> 37019
/*      */     //   36944: aload_0
/*      */     //   36945: getfield pubitem : LSmenu;
/*      */     //   36948: getfield opts : [Ljava/lang/String;
/*      */     //   36951: iload_2
/*      */     //   36952: aaload
/*      */     //   36953: aload_0
/*      */     //   36954: getfield stagename : Ljava/lang/String;
/*      */     //   36957: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   36960: ifne -> 36968
/*      */     //   36963: goto_w -> 37011
/*      */     //   36968: aconst_null
/*      */     //   36969: new java/lang/StringBuilder
/*      */     //   36972: dup
/*      */     //   36973: invokespecial <init> : ()V
/*      */     //   36976: ldc_w 'Replace your already online stage ''
/*      */     //   36979: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   36982: aload_0
/*      */     //   36983: getfield stagename : Ljava/lang/String;
/*      */     //   36986: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   36989: ldc_w '' with this one?'
/*      */     //   36992: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   36995: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   36998: ldc_w 'Stage Maker'
/*      */     //   37001: iconst_0
/*      */     //   37002: invokestatic showConfirmDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)I
/*      */     //   37005: istore_1
/*      */     //   37006: goto_w -> 37011
/*      */     //   37011: iinc #2, 1
/*      */     //   37014: goto_w -> 36928
/*      */     //   37019: iload_1
/*      */     //   37020: ifeq -> 37028
/*      */     //   37023: goto_w -> 38573
/*      */     //   37028: aload_0
/*      */     //   37029: new java/awt/Cursor
/*      */     //   37032: dup
/*      */     //   37033: iconst_3
/*      */     //   37034: invokespecial <init> : (I)V
/*      */     //   37037: invokevirtual setCursor : (Ljava/awt/Cursor;)V
/*      */     //   37040: aload_0
/*      */     //   37041: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37044: new java/awt/Font
/*      */     //   37047: dup
/*      */     //   37048: ldc_w 'Arial'
/*      */     //   37051: iconst_1
/*      */     //   37052: bipush #13
/*      */     //   37054: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   37057: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   37060: aload_0
/*      */     //   37061: aload_0
/*      */     //   37062: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37065: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   37068: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   37071: aload_0
/*      */     //   37072: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37075: new java/awt/Color
/*      */     //   37078: dup
/*      */     //   37079: sipush #225
/*      */     //   37082: sipush #225
/*      */     //   37085: sipush #225
/*      */     //   37088: invokespecial <init> : (III)V
/*      */     //   37091: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   37094: aload_0
/*      */     //   37095: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37098: bipush #11
/*      */     //   37100: sipush #141
/*      */     //   37103: sipush #779
/*      */     //   37106: sipush #401
/*      */     //   37109: invokevirtual fillRect : (IIII)V
/*      */     //   37112: aload_0
/*      */     //   37113: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37116: new java/awt/Color
/*      */     //   37119: dup
/*      */     //   37120: iconst_0
/*      */     //   37121: iconst_0
/*      */     //   37122: iconst_0
/*      */     //   37123: invokespecial <init> : (III)V
/*      */     //   37126: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   37129: aload_0
/*      */     //   37130: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37133: ldc_w 'Connecting to Server...'
/*      */     //   37136: sipush #400
/*      */     //   37139: aload_0
/*      */     //   37140: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   37143: ldc_w 'Connecting to Server...'
/*      */     //   37146: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   37149: iconst_2
/*      */     //   37150: idiv
/*      */     //   37151: isub
/*      */     //   37152: sipush #250
/*      */     //   37155: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   37158: aload_0
/*      */     //   37159: invokevirtual repaint : ()V
/*      */     //   37162: aload_0
/*      */     //   37163: aload_0
/*      */     //   37164: getfield stagename : Ljava/lang/String;
/*      */     //   37167: putfield justpubd : Ljava/lang/String;
/*      */     //   37170: iconst_m1
/*      */     //   37171: istore_2
/*      */     //   37172: new java/net/Socket
/*      */     //   37175: dup
/*      */     //   37176: ldc_w 'multiplayer.needformadness.com'
/*      */     //   37179: sipush #7061
/*      */     //   37182: invokespecial <init> : (Ljava/lang/String;I)V
/*      */     //   37185: astore_3
/*      */     //   37186: new java/io/BufferedReader
/*      */     //   37189: dup
/*      */     //   37190: new java/io/InputStreamReader
/*      */     //   37193: dup
/*      */     //   37194: aload_3
/*      */     //   37195: invokevirtual getInputStream : ()Ljava/io/InputStream;
/*      */     //   37198: invokespecial <init> : (Ljava/io/InputStream;)V
/*      */     //   37201: invokespecial <init> : (Ljava/io/Reader;)V
/*      */     //   37204: astore #4
/*      */     //   37206: new java/io/PrintWriter
/*      */     //   37209: dup
/*      */     //   37210: aload_3
/*      */     //   37211: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
/*      */     //   37214: iconst_1
/*      */     //   37215: invokespecial <init> : (Ljava/io/OutputStream;Z)V
/*      */     //   37218: astore #5
/*      */     //   37220: aconst_null
/*      */     //   37221: astore #6
/*      */     //   37223: aload #5
/*      */     //   37225: new java/lang/StringBuilder
/*      */     //   37228: dup
/*      */     //   37229: invokespecial <init> : ()V
/*      */     //   37232: ldc_w '20|'
/*      */     //   37235: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37238: aload_0
/*      */     //   37239: getfield tnick : Ljava/awt/TextField;
/*      */     //   37242: invokevirtual getText : ()Ljava/lang/String;
/*      */     //   37245: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37248: ldc_w '|'
/*      */     //   37251: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37254: aload_0
/*      */     //   37255: getfield tpass : Ljava/awt/TextField;
/*      */     //   37258: invokevirtual getText : ()Ljava/lang/String;
/*      */     //   37261: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37264: ldc_w '|'
/*      */     //   37267: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37270: aload_0
/*      */     //   37271: getfield stagename : Ljava/lang/String;
/*      */     //   37274: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37277: ldc_w '|'
/*      */     //   37280: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37283: aload_0
/*      */     //   37284: getfield pubtyp : LSmenu;
/*      */     //   37287: invokevirtual getSelectedIndex : ()I
/*      */     //   37290: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   37293: ldc_w '|'
/*      */     //   37296: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37299: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   37302: invokevirtual println : (Ljava/lang/String;)V
/*      */     //   37305: aload #4
/*      */     //   37307: invokevirtual readLine : ()Ljava/lang/String;
/*      */     //   37310: astore #7
/*      */     //   37312: aload #7
/*      */     //   37314: ifnonnull -> 37322
/*      */     //   37317: goto_w -> 37335
/*      */     //   37322: aload_0
/*      */     //   37323: aload #7
/*      */     //   37325: iconst_0
/*      */     //   37326: invokevirtual servervalue : (Ljava/lang/String;I)I
/*      */     //   37329: istore_2
/*      */     //   37330: goto_w -> 37335
/*      */     //   37335: iload_2
/*      */     //   37336: ifeq -> 37344
/*      */     //   37339: goto_w -> 38214
/*      */     //   37344: ldc_w ' Publishing Stage '
/*      */     //   37347: astore #8
/*      */     //   37349: new java/lang/StringBuilder
/*      */     //   37352: dup
/*      */     //   37353: invokespecial <init> : ()V
/*      */     //   37356: ldc ''
/*      */     //   37358: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37361: aload_0
/*      */     //   37362: getfield tstage : Ljava/lang/String;
/*      */     //   37365: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37368: ldc_w '\\r\\n'
/*      */     //   37371: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37374: aload_0
/*      */     //   37375: getfield bstage : Ljava/lang/String;
/*      */     //   37378: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37381: ldc ''
/*      */     //   37383: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37386: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   37389: astore #9
/*      */     //   37391: new java/io/DataInputStream
/*      */     //   37394: dup
/*      */     //   37395: new java/io/ByteArrayInputStream
/*      */     //   37398: dup
/*      */     //   37399: aload #9
/*      */     //   37401: invokevirtual getBytes : ()[B
/*      */     //   37404: invokespecial <init> : ([B)V
/*      */     //   37407: invokespecial <init> : (Ljava/io/InputStream;)V
/*      */     //   37410: astore #10
/*      */     //   37412: aconst_null
/*      */     //   37413: astore #11
/*      */     //   37415: aload #10
/*      */     //   37417: invokevirtual readLine : ()Ljava/lang/String;
/*      */     //   37420: dup
/*      */     //   37421: astore #11
/*      */     //   37423: ifnonnull -> 37431
/*      */     //   37426: goto_w -> 37612
/*      */     //   37431: aload #11
/*      */     //   37433: invokevirtual trim : ()Ljava/lang/String;
/*      */     //   37436: astore #11
/*      */     //   37438: aload #5
/*      */     //   37440: aload #11
/*      */     //   37442: invokevirtual println : (Ljava/lang/String;)V
/*      */     //   37445: aload_0
/*      */     //   37446: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37449: new java/awt/Color
/*      */     //   37452: dup
/*      */     //   37453: sipush #225
/*      */     //   37456: sipush #225
/*      */     //   37459: sipush #225
/*      */     //   37462: invokespecial <init> : (III)V
/*      */     //   37465: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   37468: aload_0
/*      */     //   37469: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37472: bipush #11
/*      */     //   37474: sipush #141
/*      */     //   37477: sipush #779
/*      */     //   37480: sipush #401
/*      */     //   37483: invokevirtual fillRect : (IIII)V
/*      */     //   37486: aload_0
/*      */     //   37487: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37490: new java/awt/Color
/*      */     //   37493: dup
/*      */     //   37494: iconst_0
/*      */     //   37495: iconst_0
/*      */     //   37496: iconst_0
/*      */     //   37497: invokespecial <init> : (III)V
/*      */     //   37500: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   37503: aload_0
/*      */     //   37504: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37507: aload #8
/*      */     //   37509: sipush #400
/*      */     //   37512: aload_0
/*      */     //   37513: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   37516: aload #8
/*      */     //   37518: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   37521: iconst_2
/*      */     //   37522: idiv
/*      */     //   37523: isub
/*      */     //   37524: sipush #250
/*      */     //   37527: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   37530: new java/lang/StringBuilder
/*      */     //   37533: dup
/*      */     //   37534: invokespecial <init> : ()V
/*      */     //   37537: ldc_w '| '
/*      */     //   37540: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37543: aload #8
/*      */     //   37545: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37548: ldc_w ' |'
/*      */     //   37551: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37554: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   37557: astore #8
/*      */     //   37559: aload #8
/*      */     //   37561: ldc_w '| | | | | | | | | | | | | | | | | | | | | | | |  Publishing Stage  | | | | | | | | | | | | | | | | | | | | | | | |'
/*      */     //   37564: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   37567: ifne -> 37575
/*      */     //   37570: goto_w -> 37585
/*      */     //   37575: ldc_w ' Publishing Stage '
/*      */     //   37578: astore #8
/*      */     //   37580: goto_w -> 37585
/*      */     //   37585: aload_0
/*      */     //   37586: invokevirtual repaint : ()V
/*      */     //   37589: aload_0
/*      */     //   37590: getfield thredo : Ljava/lang/Thread;
/*      */     //   37593: pop
/*      */     //   37594: ldc2_w 10
/*      */     //   37597: invokestatic sleep : (J)V
/*      */     //   37600: goto_w -> 37415
/*      */     //   37605: astore #12
/*      */     //   37607: goto_w -> 37415
/*      */     //   37612: aload #5
/*      */     //   37614: ldc_w 'QUITX1111'
/*      */     //   37617: invokevirtual println : (Ljava/lang/String;)V
/*      */     //   37620: aload_0
/*      */     //   37621: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37624: new java/awt/Color
/*      */     //   37627: dup
/*      */     //   37628: sipush #225
/*      */     //   37631: sipush #225
/*      */     //   37634: sipush #225
/*      */     //   37637: invokespecial <init> : (III)V
/*      */     //   37640: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   37643: aload_0
/*      */     //   37644: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37647: bipush #11
/*      */     //   37649: sipush #141
/*      */     //   37652: sipush #779
/*      */     //   37655: sipush #401
/*      */     //   37658: invokevirtual fillRect : (IIII)V
/*      */     //   37661: aload_0
/*      */     //   37662: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37665: new java/awt/Color
/*      */     //   37668: dup
/*      */     //   37669: iconst_0
/*      */     //   37670: iconst_0
/*      */     //   37671: iconst_0
/*      */     //   37672: invokespecial <init> : (III)V
/*      */     //   37675: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   37678: aload_0
/*      */     //   37679: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37682: ldc_w 'Creating the stage online...'
/*      */     //   37685: sipush #400
/*      */     //   37688: aload_0
/*      */     //   37689: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   37692: ldc_w 'Creating the stage online...'
/*      */     //   37695: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   37698: iconst_2
/*      */     //   37699: idiv
/*      */     //   37700: isub
/*      */     //   37701: sipush #250
/*      */     //   37704: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   37707: aload_0
/*      */     //   37708: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37711: ldc_w 'This may take a couple of minutes, please wait...'
/*      */     //   37714: sipush #400
/*      */     //   37717: aload_0
/*      */     //   37718: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   37721: ldc_w 'This may take a couple of minutes, please wait...'
/*      */     //   37724: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   37727: iconst_2
/*      */     //   37728: idiv
/*      */     //   37729: isub
/*      */     //   37730: sipush #280
/*      */     //   37733: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   37736: aload_0
/*      */     //   37737: invokevirtual repaint : ()V
/*      */     //   37740: aload #4
/*      */     //   37742: invokevirtual readLine : ()Ljava/lang/String;
/*      */     //   37745: astore #7
/*      */     //   37747: aload #7
/*      */     //   37749: ifnonnull -> 37757
/*      */     //   37752: goto_w -> 37770
/*      */     //   37757: aload_0
/*      */     //   37758: aload #7
/*      */     //   37760: iconst_0
/*      */     //   37761: invokevirtual servervalue : (Ljava/lang/String;I)I
/*      */     //   37764: istore_2
/*      */     //   37765: goto_w -> 37772
/*      */     //   37770: iconst_m1
/*      */     //   37771: istore_2
/*      */     //   37772: iload_2
/*      */     //   37773: ifeq -> 37781
/*      */     //   37776: goto_w -> 38209
/*      */     //   37781: aload_0
/*      */     //   37782: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37785: new java/awt/Color
/*      */     //   37788: dup
/*      */     //   37789: sipush #225
/*      */     //   37792: sipush #225
/*      */     //   37795: sipush #225
/*      */     //   37798: invokespecial <init> : (III)V
/*      */     //   37801: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   37804: aload_0
/*      */     //   37805: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37808: bipush #11
/*      */     //   37810: sipush #141
/*      */     //   37813: sipush #779
/*      */     //   37816: sipush #401
/*      */     //   37819: invokevirtual fillRect : (IIII)V
/*      */     //   37822: aload_0
/*      */     //   37823: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37826: new java/awt/Color
/*      */     //   37829: dup
/*      */     //   37830: iconst_0
/*      */     //   37831: iconst_0
/*      */     //   37832: iconst_0
/*      */     //   37833: invokespecial <init> : (III)V
/*      */     //   37836: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   37839: aload_0
/*      */     //   37840: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37843: ldc_w 'Uploading stage's sound track...'
/*      */     //   37846: sipush #400
/*      */     //   37849: aload_0
/*      */     //   37850: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   37853: ldc_w 'Uploading Stage's Sound Track...'
/*      */     //   37856: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   37859: iconst_2
/*      */     //   37860: idiv
/*      */     //   37861: isub
/*      */     //   37862: sipush #250
/*      */     //   37865: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   37868: aload_0
/*      */     //   37869: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   37872: ldc_w 'This may take a couple of minutes, please wait...'
/*      */     //   37875: sipush #400
/*      */     //   37878: aload_0
/*      */     //   37879: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   37882: ldc_w 'This may take a couple of minutes, please wait...'
/*      */     //   37885: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   37888: iconst_2
/*      */     //   37889: idiv
/*      */     //   37890: isub
/*      */     //   37891: sipush #280
/*      */     //   37894: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   37897: aload_0
/*      */     //   37898: invokevirtual repaint : ()V
/*      */     //   37901: new java/io/File
/*      */     //   37904: dup
/*      */     //   37905: new java/lang/StringBuilder
/*      */     //   37908: dup
/*      */     //   37909: invokespecial <init> : ()V
/*      */     //   37912: ldc ''
/*      */     //   37914: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37917: getstatic Madness.fpath : Ljava/lang/String;
/*      */     //   37920: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37923: ldc_w 'mystages/mymusic/'
/*      */     //   37926: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37929: aload_0
/*      */     //   37930: getfield trackname : Ljava/lang/String;
/*      */     //   37933: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37936: ldc_w '.zip'
/*      */     //   37939: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   37942: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   37945: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   37948: astore #12
/*      */     //   37950: aload_0
/*      */     //   37951: getfield trackname : Ljava/lang/String;
/*      */     //   37954: ldc ''
/*      */     //   37956: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   37959: ifeq -> 37967
/*      */     //   37962: goto_w -> 38189
/*      */     //   37967: aload #12
/*      */     //   37969: invokevirtual exists : ()Z
/*      */     //   37972: ifne -> 37980
/*      */     //   37975: goto_w -> 38189
/*      */     //   37980: aload #12
/*      */     //   37982: invokevirtual length : ()J
/*      */     //   37985: l2i
/*      */     //   37986: istore #13
/*      */     //   37988: aload #5
/*      */     //   37990: new java/lang/StringBuilder
/*      */     //   37993: dup
/*      */     //   37994: invokespecial <init> : ()V
/*      */     //   37997: ldc_w 'track|'
/*      */     //   38000: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   38003: aload_0
/*      */     //   38004: getfield trackname : Ljava/lang/String;
/*      */     //   38007: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   38010: ldc_w '|'
/*      */     //   38013: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   38016: iload #13
/*      */     //   38018: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   38021: ldc_w '|'
/*      */     //   38024: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   38027: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   38030: invokevirtual println : (Ljava/lang/String;)V
/*      */     //   38033: aload #4
/*      */     //   38035: invokevirtual readLine : ()Ljava/lang/String;
/*      */     //   38038: astore #7
/*      */     //   38040: aload #7
/*      */     //   38042: ifnonnull -> 38050
/*      */     //   38045: goto_w -> 38063
/*      */     //   38050: aload_0
/*      */     //   38051: aload #7
/*      */     //   38053: iconst_0
/*      */     //   38054: invokevirtual servervalue : (Ljava/lang/String;I)I
/*      */     //   38057: istore_2
/*      */     //   38058: goto_w -> 38066
/*      */     //   38063: bipush #-2
/*      */     //   38065: istore_2
/*      */     //   38066: iload_2
/*      */     //   38067: ifeq -> 38075
/*      */     //   38070: goto_w -> 38166
/*      */     //   38075: new java/io/FileInputStream
/*      */     //   38078: dup
/*      */     //   38079: aload #12
/*      */     //   38081: invokespecial <init> : (Ljava/io/File;)V
/*      */     //   38084: astore #14
/*      */     //   38086: iload #13
/*      */     //   38088: newarray byte
/*      */     //   38090: astore #15
/*      */     //   38092: aload #14
/*      */     //   38094: aload #15
/*      */     //   38096: invokevirtual read : ([B)I
/*      */     //   38099: pop
/*      */     //   38100: aload #14
/*      */     //   38102: invokevirtual close : ()V
/*      */     //   38105: new java/io/DataOutputStream
/*      */     //   38108: dup
/*      */     //   38109: aload_3
/*      */     //   38110: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
/*      */     //   38113: invokespecial <init> : (Ljava/io/OutputStream;)V
/*      */     //   38116: astore #6
/*      */     //   38118: aload #6
/*      */     //   38120: aload #15
/*      */     //   38122: iconst_0
/*      */     //   38123: iload #13
/*      */     //   38125: invokevirtual write : ([BII)V
/*      */     //   38128: aload #4
/*      */     //   38130: invokevirtual readLine : ()Ljava/lang/String;
/*      */     //   38133: astore #7
/*      */     //   38135: aload #7
/*      */     //   38137: ifnonnull -> 38145
/*      */     //   38140: goto_w -> 38158
/*      */     //   38145: aload_0
/*      */     //   38146: aload #7
/*      */     //   38148: iconst_0
/*      */     //   38149: invokevirtual servervalue : (Ljava/lang/String;I)I
/*      */     //   38152: istore_2
/*      */     //   38153: goto_w -> 38161
/*      */     //   38158: bipush #-2
/*      */     //   38160: istore_2
/*      */     //   38161: goto_w -> 38166
/*      */     //   38166: iload_2
/*      */     //   38167: bipush #-67
/*      */     //   38169: if_icmpeq -> 38177
/*      */     //   38172: goto_w -> 38184
/*      */     //   38177: iconst_0
/*      */     //   38178: istore_2
/*      */     //   38179: goto_w -> 38184
/*      */     //   38184: goto_w -> 38204
/*      */     //   38189: aload #5
/*      */     //   38191: ldc_w 'END'
/*      */     //   38194: invokevirtual println : (Ljava/lang/String;)V
/*      */     //   38197: aload #4
/*      */     //   38199: invokevirtual readLine : ()Ljava/lang/String;
/*      */     //   38202: astore #7
/*      */     //   38204: goto_w -> 38209
/*      */     //   38209: goto_w -> 38214
/*      */     //   38214: aload_3
/*      */     //   38215: invokevirtual close : ()V
/*      */     //   38218: goto_w -> 38226
/*      */     //   38223: astore_3
/*      */     //   38224: iconst_m1
/*      */     //   38225: istore_2
/*      */     //   38226: aload_0
/*      */     //   38227: new java/awt/Cursor
/*      */     //   38230: dup
/*      */     //   38231: iconst_0
/*      */     //   38232: invokespecial <init> : (I)V
/*      */     //   38235: invokevirtual setCursor : (Ljava/awt/Cursor;)V
/*      */     //   38238: iconst_0
/*      */     //   38239: istore_3
/*      */     //   38240: iload_2
/*      */     //   38241: ifeq -> 38249
/*      */     //   38244: goto_w -> 38261
/*      */     //   38249: aload_0
/*      */     //   38250: iconst_1
/*      */     //   38251: putfield logged : I
/*      */     //   38254: iconst_1
/*      */     //   38255: istore_3
/*      */     //   38256: goto_w -> 38261
/*      */     //   38261: iload_2
/*      */     //   38262: iconst_3
/*      */     //   38263: if_icmpeq -> 38271
/*      */     //   38266: goto_w -> 38318
/*      */     //   38271: aconst_null
/*      */     //   38272: new java/lang/StringBuilder
/*      */     //   38275: dup
/*      */     //   38276: invokespecial <init> : ()V
/*      */     //   38279: ldc_w 'Unable to publish stage.\\nReason:\\n'
/*      */     //   38282: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   38285: aload_0
/*      */     //   38286: getfield errlo : [Ljava/lang/String;
/*      */     //   38289: bipush #8
/*      */     //   38291: aaload
/*      */     //   38292: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   38295: ldc_w '\\n\\n'
/*      */     //   38298: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   38301: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   38304: ldc_w 'Stage Maker'
/*      */     //   38307: iconst_1
/*      */     //   38308: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   38311: iconst_1
/*      */     //   38312: istore_3
/*      */     //   38313: goto_w -> 38318
/*      */     //   38318: iload_2
/*      */     //   38319: iconst_4
/*      */     //   38320: if_icmpeq -> 38328
/*      */     //   38323: goto_w -> 38385
/*      */     //   38328: aconst_null
/*      */     //   38329: new java/lang/StringBuilder
/*      */     //   38332: dup
/*      */     //   38333: invokespecial <init> : ()V
/*      */     //   38336: ldc_w 'Unable to publish stage.\\nReason:\\nStage name used ('
/*      */     //   38339: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   38342: aload_0
/*      */     //   38343: getfield stagename : Ljava/lang/String;
/*      */     //   38346: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   38349: ldc_w ').\\nThe name ''
/*      */     //   38352: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   38355: aload_0
/*      */     //   38356: getfield stagename : Ljava/lang/String;
/*      */     //   38359: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   38362: ldc_w '' is already used by another published stage.\\nPlease rename your stage.\\n\\n'
/*      */     //   38365: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   38368: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   38371: ldc_w 'Stage Maker'
/*      */     //   38374: iconst_1
/*      */     //   38375: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   38378: iconst_1
/*      */     //   38379: istore_3
/*      */     //   38380: goto_w -> 38385
/*      */     //   38385: iload_2
/*      */     //   38386: iconst_5
/*      */     //   38387: if_icmpeq -> 38395
/*      */     //   38390: goto_w -> 38413
/*      */     //   38395: aconst_null
/*      */     //   38396: ldc_w 'Unable to create stage online!  Unknown Error.  Please try again later.'
/*      */     //   38399: ldc_w 'Stage Maker'
/*      */     //   38402: iconst_1
/*      */     //   38403: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   38406: iconst_1
/*      */     //   38407: istore_3
/*      */     //   38408: goto_w -> 38413
/*      */     //   38413: iload_2
/*      */     //   38414: iconst_5
/*      */     //   38415: if_icmpgt -> 38423
/*      */     //   38418: goto_w -> 38441
/*      */     //   38423: aconst_null
/*      */     //   38424: ldc_w 'Unable to publish stage fully!  Unknown Error.  Please try again later.'
/*      */     //   38427: ldc_w 'Stage Maker'
/*      */     //   38430: iconst_1
/*      */     //   38431: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   38434: iconst_1
/*      */     //   38435: istore_3
/*      */     //   38436: goto_w -> 38441
/*      */     //   38441: iload_2
/*      */     //   38442: bipush #-4
/*      */     //   38444: if_icmpeq -> 38452
/*      */     //   38447: goto_w -> 38475
/*      */     //   38452: aload_0
/*      */     //   38453: iconst_1
/*      */     //   38454: putfield logged : I
/*      */     //   38457: aconst_null
/*      */     //   38458: ldc_w 'Unable to upload sound track!\\nReason:\\nAnother MOD Track is already uploaded with the same name, please rename your Track.\\nOpen your 'mystages' folder then open 'mymusic' to find your MOD Track to rename it.\\n\\n'
/*      */     //   38461: ldc_w 'Stage Maker'
/*      */     //   38464: iconst_1
/*      */     //   38465: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   38468: iconst_1
/*      */     //   38469: istore_3
/*      */     //   38470: goto_w -> 38475
/*      */     //   38475: iload_2
/*      */     //   38476: bipush #-3
/*      */     //   38478: if_icmpeq -> 38486
/*      */     //   38481: goto_w -> 38509
/*      */     //   38486: aload_0
/*      */     //   38487: iconst_1
/*      */     //   38488: putfield logged : I
/*      */     //   38491: aconst_null
/*      */     //   38492: ldc_w 'Unable to upload sound track!\\nReason:\\nYour MOD Track’s file size is too large, Track file size must be less then 700KB to be accepted.\\n\\n'
/*      */     //   38495: ldc_w 'Stage Maker'
/*      */     //   38498: iconst_1
/*      */     //   38499: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   38502: iconst_1
/*      */     //   38503: istore_3
/*      */     //   38504: goto_w -> 38509
/*      */     //   38509: iload_2
/*      */     //   38510: bipush #-2
/*      */     //   38512: if_icmpeq -> 38520
/*      */     //   38515: goto_w -> 38543
/*      */     //   38520: aload_0
/*      */     //   38521: iconst_1
/*      */     //   38522: putfield logged : I
/*      */     //   38525: aconst_null
/*      */     //   38526: ldc_w 'Unable to upload sound track!  Unknown Error.  Please try again later.'
/*      */     //   38529: ldc_w 'Stage Maker'
/*      */     //   38532: iconst_1
/*      */     //   38533: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   38536: iconst_1
/*      */     //   38537: istore_3
/*      */     //   38538: goto_w -> 38543
/*      */     //   38543: iload_3
/*      */     //   38544: ifeq -> 38552
/*      */     //   38547: goto_w -> 38568
/*      */     //   38552: aconst_null
/*      */     //   38553: ldc_w 'Unable to publish stage!  Unknown Error.'
/*      */     //   38556: ldc_w 'Stage Maker'
/*      */     //   38559: iconst_1
/*      */     //   38560: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   38563: goto_w -> 38568
/*      */     //   38568: goto_w -> 38573
/*      */     //   38573: goto_w -> 38627
/*      */     //   38578: aconst_null
/*      */     //   38579: new java/lang/StringBuilder
/*      */     //   38582: dup
/*      */     //   38583: invokespecial <init> : ()V
/*      */     //   38586: ldc_w 'Error!  This stage is not ready for publishing!\\nReason:\\n'
/*      */     //   38589: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   38592: aload_0
/*      */     //   38593: getfield errlo : [Ljava/lang/String;
/*      */     //   38596: aload_0
/*      */     //   38597: getfield errd : I
/*      */     //   38600: iconst_1
/*      */     //   38601: isub
/*      */     //   38602: aaload
/*      */     //   38603: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   38606: ldc_w '\\n\\n'
/*      */     //   38609: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   38612: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   38615: ldc_w 'Stage Maker'
/*      */     //   38618: iconst_0
/*      */     //   38619: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   38622: goto_w -> 38627
/*      */     //   38627: aload_0
/*      */     //   38628: getfield logged : I
/*      */     //   38631: iconst_3
/*      */     //   38632: if_icmpeq -> 38640
/*      */     //   38635: goto_w -> 41700
/*      */     //   38640: iconst_0
/*      */     //   38641: istore_1
/*      */     //   38642: iload_1
/*      */     //   38643: aload_0
/*      */     //   38644: getfield nms : I
/*      */     //   38647: if_icmplt -> 38655
/*      */     //   38650: goto_w -> 41695
/*      */     //   38655: aload_0
/*      */     //   38656: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   38659: new java/awt/Color
/*      */     //   38662: dup
/*      */     //   38663: sipush #235
/*      */     //   38666: sipush #235
/*      */     //   38669: sipush #235
/*      */     //   38672: invokespecial <init> : (III)V
/*      */     //   38675: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   38678: aload_0
/*      */     //   38679: getfield xm : I
/*      */     //   38682: bipush #11
/*      */     //   38684: if_icmpgt -> 38692
/*      */     //   38687: goto_w -> 38775
/*      */     //   38692: aload_0
/*      */     //   38693: getfield xm : I
/*      */     //   38696: sipush #789
/*      */     //   38699: if_icmplt -> 38707
/*      */     //   38702: goto_w -> 38775
/*      */     //   38707: aload_0
/*      */     //   38708: getfield ym : I
/*      */     //   38711: sipush #142
/*      */     //   38714: iload_1
/*      */     //   38715: bipush #20
/*      */     //   38717: imul
/*      */     //   38718: iadd
/*      */     //   38719: if_icmpgt -> 38727
/*      */     //   38722: goto_w -> 38775
/*      */     //   38727: aload_0
/*      */     //   38728: getfield ym : I
/*      */     //   38731: sipush #160
/*      */     //   38734: iload_1
/*      */     //   38735: bipush #20
/*      */     //   38737: imul
/*      */     //   38738: iadd
/*      */     //   38739: if_icmplt -> 38747
/*      */     //   38742: goto_w -> 38775
/*      */     //   38747: aload_0
/*      */     //   38748: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   38751: new java/awt/Color
/*      */     //   38754: dup
/*      */     //   38755: sipush #255
/*      */     //   38758: sipush #255
/*      */     //   38761: sipush #255
/*      */     //   38764: invokespecial <init> : (III)V
/*      */     //   38767: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   38770: goto_w -> 38775
/*      */     //   38775: aload_0
/*      */     //   38776: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   38779: bipush #11
/*      */     //   38781: sipush #142
/*      */     //   38784: iload_1
/*      */     //   38785: bipush #20
/*      */     //   38787: imul
/*      */     //   38788: iadd
/*      */     //   38789: sipush #778
/*      */     //   38792: bipush #18
/*      */     //   38794: invokevirtual fillRect : (IIII)V
/*      */     //   38797: aload_0
/*      */     //   38798: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   38801: new java/awt/Font
/*      */     //   38804: dup
/*      */     //   38805: ldc_w 'Arial'
/*      */     //   38808: iconst_0
/*      */     //   38809: bipush #12
/*      */     //   38811: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   38814: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   38817: aload_0
/*      */     //   38818: aload_0
/*      */     //   38819: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   38822: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   38825: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   38828: aload_0
/*      */     //   38829: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   38832: new java/awt/Color
/*      */     //   38835: dup
/*      */     //   38836: iconst_0
/*      */     //   38837: iconst_0
/*      */     //   38838: iconst_0
/*      */     //   38839: invokespecial <init> : (III)V
/*      */     //   38842: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   38845: aload_0
/*      */     //   38846: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   38849: aload_0
/*      */     //   38850: getfield mystages : [Ljava/lang/String;
/*      */     //   38853: iload_1
/*      */     //   38854: aaload
/*      */     //   38855: sipush #180
/*      */     //   38858: aload_0
/*      */     //   38859: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   38862: aload_0
/*      */     //   38863: getfield mystages : [Ljava/lang/String;
/*      */     //   38866: iload_1
/*      */     //   38867: aaload
/*      */     //   38868: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   38871: iconst_2
/*      */     //   38872: idiv
/*      */     //   38873: isub
/*      */     //   38874: sipush #156
/*      */     //   38877: iload_1
/*      */     //   38878: bipush #20
/*      */     //   38880: imul
/*      */     //   38881: iadd
/*      */     //   38882: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   38885: aload_0
/*      */     //   38886: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   38889: new java/awt/Color
/*      */     //   38892: dup
/*      */     //   38893: sipush #155
/*      */     //   38896: sipush #155
/*      */     //   38899: sipush #155
/*      */     //   38902: invokespecial <init> : (III)V
/*      */     //   38905: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   38908: aload_0
/*      */     //   38909: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   38912: sipush #350
/*      */     //   38915: sipush #145
/*      */     //   38918: iload_1
/*      */     //   38919: bipush #20
/*      */     //   38921: imul
/*      */     //   38922: iadd
/*      */     //   38923: sipush #350
/*      */     //   38926: sipush #157
/*      */     //   38929: iload_1
/*      */     //   38930: bipush #20
/*      */     //   38932: imul
/*      */     //   38933: iadd
/*      */     //   38934: invokevirtual drawLine : (IIII)V
/*      */     //   38937: aload_0
/*      */     //   38938: getfield pubt : [I
/*      */     //   38941: iload_1
/*      */     //   38942: iaload
/*      */     //   38943: iconst_m1
/*      */     //   38944: if_icmpne -> 38952
/*      */     //   38947: goto_w -> 41333
/*      */     //   38952: aload_0
/*      */     //   38953: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   38956: sipush #450
/*      */     //   38959: sipush #145
/*      */     //   38962: iload_1
/*      */     //   38963: bipush #20
/*      */     //   38965: imul
/*      */     //   38966: iadd
/*      */     //   38967: sipush #450
/*      */     //   38970: sipush #157
/*      */     //   38973: iload_1
/*      */     //   38974: bipush #20
/*      */     //   38976: imul
/*      */     //   38977: iadd
/*      */     //   38978: invokevirtual drawLine : (IIII)V
/*      */     //   38981: aload_0
/*      */     //   38982: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   38985: sipush #550
/*      */     //   38988: sipush #145
/*      */     //   38991: iload_1
/*      */     //   38992: bipush #20
/*      */     //   38994: imul
/*      */     //   38995: iadd
/*      */     //   38996: sipush #550
/*      */     //   38999: sipush #157
/*      */     //   39002: iload_1
/*      */     //   39003: bipush #20
/*      */     //   39005: imul
/*      */     //   39006: iadd
/*      */     //   39007: invokevirtual drawLine : (IIII)V
/*      */     //   39010: aload_0
/*      */     //   39011: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   39014: sipush #650
/*      */     //   39017: sipush #145
/*      */     //   39020: iload_1
/*      */     //   39021: bipush #20
/*      */     //   39023: imul
/*      */     //   39024: iadd
/*      */     //   39025: sipush #650
/*      */     //   39028: sipush #157
/*      */     //   39031: iload_1
/*      */     //   39032: bipush #20
/*      */     //   39034: imul
/*      */     //   39035: iadd
/*      */     //   39036: invokevirtual drawLine : (IIII)V
/*      */     //   39039: iconst_0
/*      */     //   39040: istore_2
/*      */     //   39041: aload_0
/*      */     //   39042: getfield maker : [Ljava/lang/String;
/*      */     //   39045: iload_1
/*      */     //   39046: aaload
/*      */     //   39047: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   39050: aload_0
/*      */     //   39051: getfield tnick : Ljava/awt/TextField;
/*      */     //   39054: invokevirtual getText : ()Ljava/lang/String;
/*      */     //   39057: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   39060: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   39063: ifne -> 39071
/*      */     //   39066: goto_w -> 39130
/*      */     //   39071: iconst_1
/*      */     //   39072: istore_2
/*      */     //   39073: aload_0
/*      */     //   39074: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   39077: new java/awt/Color
/*      */     //   39080: dup
/*      */     //   39081: iconst_0
/*      */     //   39082: bipush #64
/*      */     //   39084: iconst_0
/*      */     //   39085: invokespecial <init> : (III)V
/*      */     //   39088: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   39091: aload_0
/*      */     //   39092: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   39095: ldc_w 'You'
/*      */     //   39098: sipush #400
/*      */     //   39101: aload_0
/*      */     //   39102: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   39105: ldc_w 'You'
/*      */     //   39108: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   39111: iconst_2
/*      */     //   39112: idiv
/*      */     //   39113: isub
/*      */     //   39114: sipush #156
/*      */     //   39117: iload_1
/*      */     //   39118: bipush #20
/*      */     //   39120: imul
/*      */     //   39121: iadd
/*      */     //   39122: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   39125: goto_w -> 39188
/*      */     //   39130: aload_0
/*      */     //   39131: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   39134: new java/awt/Color
/*      */     //   39137: dup
/*      */     //   39138: iconst_0
/*      */     //   39139: iconst_0
/*      */     //   39140: bipush #64
/*      */     //   39142: invokespecial <init> : (III)V
/*      */     //   39145: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   39148: aload_0
/*      */     //   39149: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   39152: aload_0
/*      */     //   39153: getfield maker : [Ljava/lang/String;
/*      */     //   39156: iload_1
/*      */     //   39157: aaload
/*      */     //   39158: sipush #400
/*      */     //   39161: aload_0
/*      */     //   39162: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   39165: aload_0
/*      */     //   39166: getfield maker : [Ljava/lang/String;
/*      */     //   39169: iload_1
/*      */     //   39170: aaload
/*      */     //   39171: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   39174: iconst_2
/*      */     //   39175: idiv
/*      */     //   39176: isub
/*      */     //   39177: sipush #156
/*      */     //   39180: iload_1
/*      */     //   39181: bipush #20
/*      */     //   39183: imul
/*      */     //   39184: iadd
/*      */     //   39185: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   39188: aload_0
/*      */     //   39189: getfield nad : [I
/*      */     //   39192: iload_1
/*      */     //   39193: iaload
/*      */     //   39194: iconst_1
/*      */     //   39195: if_icmpgt -> 39203
/*      */     //   39198: goto_w -> 39553
/*      */     //   39203: aload_0
/*      */     //   39204: new java/lang/StringBuilder
/*      */     //   39207: dup
/*      */     //   39208: invokespecial <init> : ()V
/*      */     //   39211: ldc ''
/*      */     //   39213: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39216: aload_0
/*      */     //   39217: getfield nad : [I
/*      */     //   39220: iload_1
/*      */     //   39221: iaload
/*      */     //   39222: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   39225: ldc_w ' Players'
/*      */     //   39228: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39231: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   39234: sipush #500
/*      */     //   39237: sipush #156
/*      */     //   39240: iload_1
/*      */     //   39241: bipush #20
/*      */     //   39243: imul
/*      */     //   39244: iadd
/*      */     //   39245: invokevirtual ovbutton : (Ljava/lang/String;II)Z
/*      */     //   39248: ifne -> 39256
/*      */     //   39251: goto_w -> 39605
/*      */     //   39256: new java/lang/StringBuilder
/*      */     //   39259: dup
/*      */     //   39260: invokespecial <init> : ()V
/*      */     //   39263: ldc_w '[ '
/*      */     //   39266: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39269: aload_0
/*      */     //   39270: getfield mystages : [Ljava/lang/String;
/*      */     //   39273: iload_1
/*      */     //   39274: aaload
/*      */     //   39275: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39278: ldc_w ' ]  has been added by the following players to their accounts:     \\n\\n'
/*      */     //   39281: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39284: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   39287: astore_3
/*      */     //   39288: iconst_0
/*      */     //   39289: istore #4
/*      */     //   39291: iconst_0
/*      */     //   39292: istore #5
/*      */     //   39294: iload #5
/*      */     //   39296: aload_0
/*      */     //   39297: getfield nad : [I
/*      */     //   39300: iload_1
/*      */     //   39301: iaload
/*      */     //   39302: if_icmplt -> 39310
/*      */     //   39305: goto_w -> 39518
/*      */     //   39310: iinc #4, 1
/*      */     //   39313: iload #4
/*      */     //   39315: bipush #17
/*      */     //   39317: if_icmpeq -> 39325
/*      */     //   39320: goto_w -> 39354
/*      */     //   39325: new java/lang/StringBuilder
/*      */     //   39328: dup
/*      */     //   39329: invokespecial <init> : ()V
/*      */     //   39332: aload_3
/*      */     //   39333: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39336: ldc_w '\\n'
/*      */     //   39339: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39342: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   39345: astore_3
/*      */     //   39346: iconst_1
/*      */     //   39347: istore #4
/*      */     //   39349: goto_w -> 39354
/*      */     //   39354: new java/lang/StringBuilder
/*      */     //   39357: dup
/*      */     //   39358: invokespecial <init> : ()V
/*      */     //   39361: aload_3
/*      */     //   39362: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39365: aload_0
/*      */     //   39366: getfield addeda : [[Ljava/lang/String;
/*      */     //   39369: iload_1
/*      */     //   39370: aaload
/*      */     //   39371: iload #5
/*      */     //   39373: aaload
/*      */     //   39374: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39377: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   39380: astore_3
/*      */     //   39381: iload #5
/*      */     //   39383: aload_0
/*      */     //   39384: getfield nad : [I
/*      */     //   39387: iload_1
/*      */     //   39388: iaload
/*      */     //   39389: iconst_1
/*      */     //   39390: isub
/*      */     //   39391: if_icmpne -> 39399
/*      */     //   39394: goto_w -> 39510
/*      */     //   39399: iload #5
/*      */     //   39401: aload_0
/*      */     //   39402: getfield nad : [I
/*      */     //   39405: iload_1
/*      */     //   39406: iaload
/*      */     //   39407: iconst_2
/*      */     //   39408: isub
/*      */     //   39409: if_icmpne -> 39417
/*      */     //   39412: goto_w -> 39443
/*      */     //   39417: new java/lang/StringBuilder
/*      */     //   39420: dup
/*      */     //   39421: invokespecial <init> : ()V
/*      */     //   39424: aload_3
/*      */     //   39425: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39428: ldc_w ', '
/*      */     //   39431: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39434: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   39437: astore_3
/*      */     //   39438: goto_w -> 39510
/*      */     //   39443: iload #4
/*      */     //   39445: bipush #16
/*      */     //   39447: if_icmpeq -> 39455
/*      */     //   39450: goto_w -> 39484
/*      */     //   39455: new java/lang/StringBuilder
/*      */     //   39458: dup
/*      */     //   39459: invokespecial <init> : ()V
/*      */     //   39462: aload_3
/*      */     //   39463: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39466: ldc_w '\\nand '
/*      */     //   39469: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39472: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   39475: astore_3
/*      */     //   39476: iconst_0
/*      */     //   39477: istore #4
/*      */     //   39479: goto_w -> 39510
/*      */     //   39484: new java/lang/StringBuilder
/*      */     //   39487: dup
/*      */     //   39488: invokespecial <init> : ()V
/*      */     //   39491: aload_3
/*      */     //   39492: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39495: ldc_w ' and '
/*      */     //   39498: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39501: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   39504: astore_3
/*      */     //   39505: goto_w -> 39510
/*      */     //   39510: iinc #5, 1
/*      */     //   39513: goto_w -> 39294
/*      */     //   39518: new java/lang/StringBuilder
/*      */     //   39521: dup
/*      */     //   39522: invokespecial <init> : ()V
/*      */     //   39525: aload_3
/*      */     //   39526: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39529: ldc_w '\\n \\n \\n'
/*      */     //   39532: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39535: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   39538: astore_3
/*      */     //   39539: aconst_null
/*      */     //   39540: aload_3
/*      */     //   39541: ldc_w 'Stage Maker'
/*      */     //   39544: iconst_1
/*      */     //   39545: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   39548: goto_w -> 39605
/*      */     //   39553: aload_0
/*      */     //   39554: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   39557: new java/awt/Color
/*      */     //   39560: dup
/*      */     //   39561: iconst_0
/*      */     //   39562: iconst_0
/*      */     //   39563: bipush #64
/*      */     //   39565: invokespecial <init> : (III)V
/*      */     //   39568: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   39571: aload_0
/*      */     //   39572: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   39575: ldc_w 'None'
/*      */     //   39578: sipush #500
/*      */     //   39581: aload_0
/*      */     //   39582: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   39585: ldc_w 'None'
/*      */     //   39588: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   39591: iconst_2
/*      */     //   39592: idiv
/*      */     //   39593: isub
/*      */     //   39594: sipush #156
/*      */     //   39597: iload_1
/*      */     //   39598: bipush #20
/*      */     //   39600: imul
/*      */     //   39601: iadd
/*      */     //   39602: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   39605: aload_0
/*      */     //   39606: getfield pubt : [I
/*      */     //   39609: iload_1
/*      */     //   39610: iaload
/*      */     //   39611: ifeq -> 39619
/*      */     //   39614: goto_w -> 39676
/*      */     //   39619: aload_0
/*      */     //   39620: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   39623: new java/awt/Color
/*      */     //   39626: dup
/*      */     //   39627: iconst_0
/*      */     //   39628: iconst_0
/*      */     //   39629: bipush #64
/*      */     //   39631: invokespecial <init> : (III)V
/*      */     //   39634: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   39637: aload_0
/*      */     //   39638: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   39641: ldc_w 'Private'
/*      */     //   39644: sipush #600
/*      */     //   39647: aload_0
/*      */     //   39648: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   39651: ldc_w 'Private'
/*      */     //   39654: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   39657: iconst_2
/*      */     //   39658: idiv
/*      */     //   39659: isub
/*      */     //   39660: sipush #156
/*      */     //   39663: iload_1
/*      */     //   39664: bipush #20
/*      */     //   39666: imul
/*      */     //   39667: iadd
/*      */     //   39668: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   39671: goto_w -> 39676
/*      */     //   39676: aload_0
/*      */     //   39677: getfield pubt : [I
/*      */     //   39680: iload_1
/*      */     //   39681: iaload
/*      */     //   39682: iconst_1
/*      */     //   39683: if_icmpeq -> 39691
/*      */     //   39686: goto_w -> 39748
/*      */     //   39691: aload_0
/*      */     //   39692: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   39695: new java/awt/Color
/*      */     //   39698: dup
/*      */     //   39699: iconst_0
/*      */     //   39700: iconst_0
/*      */     //   39701: bipush #64
/*      */     //   39703: invokespecial <init> : (III)V
/*      */     //   39706: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   39709: aload_0
/*      */     //   39710: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   39713: ldc_w 'Public'
/*      */     //   39716: sipush #600
/*      */     //   39719: aload_0
/*      */     //   39720: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   39723: ldc_w 'Public'
/*      */     //   39726: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   39729: iconst_2
/*      */     //   39730: idiv
/*      */     //   39731: isub
/*      */     //   39732: sipush #156
/*      */     //   39735: iload_1
/*      */     //   39736: bipush #20
/*      */     //   39738: imul
/*      */     //   39739: iadd
/*      */     //   39740: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   39743: goto_w -> 39748
/*      */     //   39748: aload_0
/*      */     //   39749: getfield pubt : [I
/*      */     //   39752: iload_1
/*      */     //   39753: iaload
/*      */     //   39754: iconst_2
/*      */     //   39755: if_icmpeq -> 39763
/*      */     //   39758: goto_w -> 39820
/*      */     //   39763: aload_0
/*      */     //   39764: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   39767: new java/awt/Color
/*      */     //   39770: dup
/*      */     //   39771: iconst_0
/*      */     //   39772: bipush #64
/*      */     //   39774: iconst_0
/*      */     //   39775: invokespecial <init> : (III)V
/*      */     //   39778: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   39781: aload_0
/*      */     //   39782: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   39785: ldc_w 'Super Public'
/*      */     //   39788: sipush #600
/*      */     //   39791: aload_0
/*      */     //   39792: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   39795: ldc_w 'Super Public'
/*      */     //   39798: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   39801: iconst_2
/*      */     //   39802: idiv
/*      */     //   39803: isub
/*      */     //   39804: sipush #156
/*      */     //   39807: iload_1
/*      */     //   39808: bipush #20
/*      */     //   39810: imul
/*      */     //   39811: iadd
/*      */     //   39812: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   39815: goto_w -> 39820
/*      */     //   39820: aload_0
/*      */     //   39821: getfield pubt : [I
/*      */     //   39824: iload_1
/*      */     //   39825: iaload
/*      */     //   39826: iconst_2
/*      */     //   39827: if_icmpne -> 39835
/*      */     //   39830: goto_w -> 39844
/*      */     //   39835: iload_2
/*      */     //   39836: ifne -> 39844
/*      */     //   39839: goto_w -> 41328
/*      */     //   39844: aload_0
/*      */     //   39845: ldc_w 'Download'
/*      */     //   39848: sipush #700
/*      */     //   39851: sipush #156
/*      */     //   39854: iload_1
/*      */     //   39855: bipush #20
/*      */     //   39857: imul
/*      */     //   39858: iadd
/*      */     //   39859: invokevirtual ovbutton : (Ljava/lang/String;II)Z
/*      */     //   39862: ifne -> 39870
/*      */     //   39865: goto_w -> 41328
/*      */     //   39870: iconst_0
/*      */     //   39871: istore_3
/*      */     //   39872: iconst_0
/*      */     //   39873: istore #4
/*      */     //   39875: iload #4
/*      */     //   39877: aload_0
/*      */     //   39878: getfield slstage : LSmenu;
/*      */     //   39881: invokevirtual getItemCount : ()I
/*      */     //   39884: if_icmplt -> 39892
/*      */     //   39887: goto_w -> 39971
/*      */     //   39892: aload_0
/*      */     //   39893: getfield mystages : [Ljava/lang/String;
/*      */     //   39896: iload_1
/*      */     //   39897: aaload
/*      */     //   39898: aload_0
/*      */     //   39899: getfield slstage : LSmenu;
/*      */     //   39902: iload #4
/*      */     //   39904: invokevirtual getItem : (I)Ljava/lang/String;
/*      */     //   39907: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   39910: ifne -> 39918
/*      */     //   39913: goto_w -> 39963
/*      */     //   39918: aconst_null
/*      */     //   39919: new java/lang/StringBuilder
/*      */     //   39922: dup
/*      */     //   39923: invokespecial <init> : ()V
/*      */     //   39926: ldc_w 'Replace the local '
/*      */     //   39929: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39932: aload_0
/*      */     //   39933: getfield mystages : [Ljava/lang/String;
/*      */     //   39936: iload_1
/*      */     //   39937: aaload
/*      */     //   39938: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39941: ldc_w ' in your 'mystages' folder with the published online copy?'
/*      */     //   39944: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   39947: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   39950: ldc_w 'Stage Maker'
/*      */     //   39953: iconst_0
/*      */     //   39954: invokestatic showConfirmDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)I
/*      */     //   39957: istore_3
/*      */     //   39958: goto_w -> 39963
/*      */     //   39963: iinc #4, 1
/*      */     //   39966: goto_w -> 39875
/*      */     //   39971: iload_3
/*      */     //   39972: ifeq -> 39980
/*      */     //   39975: goto_w -> 41323
/*      */     //   39980: aload_0
/*      */     //   39981: new java/awt/Cursor
/*      */     //   39984: dup
/*      */     //   39985: iconst_3
/*      */     //   39986: invokespecial <init> : (I)V
/*      */     //   39989: invokevirtual setCursor : (Ljava/awt/Cursor;)V
/*      */     //   39992: aload_0
/*      */     //   39993: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   39996: new java/awt/Font
/*      */     //   39999: dup
/*      */     //   40000: ldc_w 'Arial'
/*      */     //   40003: iconst_1
/*      */     //   40004: bipush #13
/*      */     //   40006: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   40009: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   40012: aload_0
/*      */     //   40013: aload_0
/*      */     //   40014: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   40017: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   40020: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   40023: aload_0
/*      */     //   40024: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   40027: new java/awt/Color
/*      */     //   40030: dup
/*      */     //   40031: sipush #225
/*      */     //   40034: sipush #225
/*      */     //   40037: sipush #225
/*      */     //   40040: invokespecial <init> : (III)V
/*      */     //   40043: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   40046: aload_0
/*      */     //   40047: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   40050: bipush #11
/*      */     //   40052: sipush #141
/*      */     //   40055: sipush #779
/*      */     //   40058: sipush #401
/*      */     //   40061: invokevirtual fillRect : (IIII)V
/*      */     //   40064: aload_0
/*      */     //   40065: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   40068: new java/awt/Color
/*      */     //   40071: dup
/*      */     //   40072: iconst_0
/*      */     //   40073: iconst_0
/*      */     //   40074: iconst_0
/*      */     //   40075: invokespecial <init> : (III)V
/*      */     //   40078: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   40081: aload_0
/*      */     //   40082: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   40085: ldc_w 'Downloading stage, please wait...'
/*      */     //   40088: sipush #400
/*      */     //   40091: aload_0
/*      */     //   40092: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   40095: ldc_w 'Downloading stage, please wait...'
/*      */     //   40098: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   40101: iconst_2
/*      */     //   40102: idiv
/*      */     //   40103: isub
/*      */     //   40104: sipush #250
/*      */     //   40107: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   40110: aload_0
/*      */     //   40111: invokevirtual repaint : ()V
/*      */     //   40114: new java/lang/StringBuilder
/*      */     //   40117: dup
/*      */     //   40118: invokespecial <init> : ()V
/*      */     //   40121: ldc_w 'http://multiplayer.needformadness.com/tracks/'
/*      */     //   40124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40127: aload_0
/*      */     //   40128: getfield mystages : [Ljava/lang/String;
/*      */     //   40131: iload_1
/*      */     //   40132: aaload
/*      */     //   40133: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40136: ldc_w '.radq?reqlo='
/*      */     //   40139: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40142: invokestatic random : ()D
/*      */     //   40145: ldc2_w 1000.0
/*      */     //   40148: dmul
/*      */     //   40149: d2i
/*      */     //   40150: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   40153: ldc ''
/*      */     //   40155: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40158: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   40161: astore #4
/*      */     //   40163: aload #4
/*      */     //   40165: bipush #32
/*      */     //   40167: bipush #95
/*      */     //   40169: invokevirtual replace : (CC)Ljava/lang/String;
/*      */     //   40172: astore #4
/*      */     //   40174: new java/net/URL
/*      */     //   40177: dup
/*      */     //   40178: aload #4
/*      */     //   40180: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   40183: astore #5
/*      */     //   40185: aload #5
/*      */     //   40187: invokevirtual openConnection : ()Ljava/net/URLConnection;
/*      */     //   40190: invokevirtual getContentLength : ()I
/*      */     //   40193: istore #7
/*      */     //   40195: new java/io/DataInputStream
/*      */     //   40198: dup
/*      */     //   40199: aload #5
/*      */     //   40201: invokevirtual openStream : ()Ljava/io/InputStream;
/*      */     //   40204: invokespecial <init> : (Ljava/io/InputStream;)V
/*      */     //   40207: astore #8
/*      */     //   40209: iload #7
/*      */     //   40211: newarray byte
/*      */     //   40213: astore #9
/*      */     //   40215: aload #8
/*      */     //   40217: aload #9
/*      */     //   40219: invokevirtual readFully : ([B)V
/*      */     //   40222: aload #8
/*      */     //   40224: invokevirtual close : ()V
/*      */     //   40227: aload #9
/*      */     //   40229: iconst_0
/*      */     //   40230: baload
/*      */     //   40231: bipush #80
/*      */     //   40233: if_icmpeq -> 40241
/*      */     //   40236: goto_w -> 40291
/*      */     //   40241: aload #9
/*      */     //   40243: iconst_1
/*      */     //   40244: baload
/*      */     //   40245: bipush #75
/*      */     //   40247: if_icmpeq -> 40255
/*      */     //   40250: goto_w -> 40291
/*      */     //   40255: aload #9
/*      */     //   40257: iconst_2
/*      */     //   40258: baload
/*      */     //   40259: iconst_3
/*      */     //   40260: if_icmpeq -> 40268
/*      */     //   40263: goto_w -> 40291
/*      */     //   40268: new java/util/zip/ZipInputStream
/*      */     //   40271: dup
/*      */     //   40272: new java/io/ByteArrayInputStream
/*      */     //   40275: dup
/*      */     //   40276: aload #9
/*      */     //   40278: invokespecial <init> : ([B)V
/*      */     //   40281: invokespecial <init> : (Ljava/io/InputStream;)V
/*      */     //   40284: astore #6
/*      */     //   40286: goto_w -> 40383
/*      */     //   40291: iload #7
/*      */     //   40293: bipush #40
/*      */     //   40295: isub
/*      */     //   40296: newarray byte
/*      */     //   40298: astore #10
/*      */     //   40300: iconst_0
/*      */     //   40301: istore #11
/*      */     //   40303: iload #11
/*      */     //   40305: iload #7
/*      */     //   40307: bipush #40
/*      */     //   40309: isub
/*      */     //   40310: if_icmplt -> 40318
/*      */     //   40313: goto_w -> 40365
/*      */     //   40318: bipush #20
/*      */     //   40320: istore #12
/*      */     //   40322: iload #11
/*      */     //   40324: sipush #500
/*      */     //   40327: if_icmpge -> 40335
/*      */     //   40330: goto_w -> 40344
/*      */     //   40335: bipush #40
/*      */     //   40337: istore #12
/*      */     //   40339: goto_w -> 40344
/*      */     //   40344: aload #10
/*      */     //   40346: iload #11
/*      */     //   40348: aload #9
/*      */     //   40350: iload #11
/*      */     //   40352: iload #12
/*      */     //   40354: iadd
/*      */     //   40355: baload
/*      */     //   40356: bastore
/*      */     //   40357: iinc #11, 1
/*      */     //   40360: goto_w -> 40303
/*      */     //   40365: new java/util/zip/ZipInputStream
/*      */     //   40368: dup
/*      */     //   40369: new java/io/ByteArrayInputStream
/*      */     //   40372: dup
/*      */     //   40373: aload #10
/*      */     //   40375: invokespecial <init> : ([B)V
/*      */     //   40378: invokespecial <init> : (Ljava/io/InputStream;)V
/*      */     //   40381: astore #6
/*      */     //   40383: aload #6
/*      */     //   40385: invokevirtual getNextEntry : ()Ljava/util/zip/ZipEntry;
/*      */     //   40388: astore #10
/*      */     //   40390: aload #10
/*      */     //   40392: ifnonnull -> 40400
/*      */     //   40395: goto_w -> 41289
/*      */     //   40400: ldc ''
/*      */     //   40402: astore #11
/*      */     //   40404: aload #10
/*      */     //   40406: invokevirtual getName : ()Ljava/lang/String;
/*      */     //   40409: invokestatic valueOf : (Ljava/lang/String;)Ljava/lang/Integer;
/*      */     //   40412: invokevirtual intValue : ()I
/*      */     //   40415: istore #12
/*      */     //   40417: iload #12
/*      */     //   40419: newarray byte
/*      */     //   40421: astore #13
/*      */     //   40423: iconst_0
/*      */     //   40424: istore #14
/*      */     //   40426: iload #12
/*      */     //   40428: ifgt -> 40436
/*      */     //   40431: goto_w -> 40468
/*      */     //   40436: aload #6
/*      */     //   40438: aload #13
/*      */     //   40440: iload #14
/*      */     //   40442: iload #12
/*      */     //   40444: invokevirtual read : ([BII)I
/*      */     //   40447: istore #15
/*      */     //   40449: iload #14
/*      */     //   40451: iload #15
/*      */     //   40453: iadd
/*      */     //   40454: istore #14
/*      */     //   40456: iload #12
/*      */     //   40458: iload #15
/*      */     //   40460: isub
/*      */     //   40461: istore #12
/*      */     //   40463: goto_w -> 40426
/*      */     //   40468: new java/lang/String
/*      */     //   40471: dup
/*      */     //   40472: aload #13
/*      */     //   40474: invokespecial <init> : ([B)V
/*      */     //   40477: astore #16
/*      */     //   40479: new java/lang/StringBuilder
/*      */     //   40482: dup
/*      */     //   40483: invokespecial <init> : ()V
/*      */     //   40486: aload #16
/*      */     //   40488: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40491: ldc_w '\\n'
/*      */     //   40494: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40497: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   40500: astore #16
/*      */     //   40502: ldc ''
/*      */     //   40504: astore #17
/*      */     //   40506: iconst_0
/*      */     //   40507: istore #18
/*      */     //   40509: aload #16
/*      */     //   40511: ldc_w '\\n'
/*      */     //   40514: iconst_0
/*      */     //   40515: invokevirtual indexOf : (Ljava/lang/String;I)I
/*      */     //   40518: istore #19
/*      */     //   40520: iload #19
/*      */     //   40522: iconst_m1
/*      */     //   40523: if_icmpne -> 40531
/*      */     //   40526: goto_w -> 40720
/*      */     //   40531: iload #18
/*      */     //   40533: aload #16
/*      */     //   40535: invokevirtual length : ()I
/*      */     //   40538: if_icmplt -> 40546
/*      */     //   40541: goto_w -> 40720
/*      */     //   40546: aload #16
/*      */     //   40548: iload #18
/*      */     //   40550: iload #19
/*      */     //   40552: invokevirtual substring : (II)Ljava/lang/String;
/*      */     //   40555: astore #20
/*      */     //   40557: aload #20
/*      */     //   40559: invokevirtual trim : ()Ljava/lang/String;
/*      */     //   40562: astore #20
/*      */     //   40564: iload #19
/*      */     //   40566: iconst_1
/*      */     //   40567: iadd
/*      */     //   40568: istore #18
/*      */     //   40570: aload #16
/*      */     //   40572: ldc_w '\\n'
/*      */     //   40575: iload #18
/*      */     //   40577: invokevirtual indexOf : (Ljava/lang/String;I)I
/*      */     //   40580: istore #19
/*      */     //   40582: aload #20
/*      */     //   40584: ldc_w 'stagemaker('
/*      */     //   40587: invokevirtual startsWith : (Ljava/lang/String;)Z
/*      */     //   40590: ifeq -> 40598
/*      */     //   40593: goto_w -> 40652
/*      */     //   40598: aload #20
/*      */     //   40600: ldc_w 'publish('
/*      */     //   40603: invokevirtual startsWith : (Ljava/lang/String;)Z
/*      */     //   40606: ifeq -> 40614
/*      */     //   40609: goto_w -> 40652
/*      */     //   40614: new java/lang/StringBuilder
/*      */     //   40617: dup
/*      */     //   40618: invokespecial <init> : ()V
/*      */     //   40621: aload #17
/*      */     //   40623: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40626: ldc ''
/*      */     //   40628: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40631: aload #20
/*      */     //   40633: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40636: ldc_w '\\r\\n'
/*      */     //   40639: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40642: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   40645: astore #17
/*      */     //   40647: goto_w -> 40682
/*      */     //   40652: aload #17
/*      */     //   40654: invokevirtual trim : ()Ljava/lang/String;
/*      */     //   40657: astore #17
/*      */     //   40659: new java/lang/StringBuilder
/*      */     //   40662: dup
/*      */     //   40663: invokespecial <init> : ()V
/*      */     //   40666: aload #17
/*      */     //   40668: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40671: ldc_w '\\r\\n'
/*      */     //   40674: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40677: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   40680: astore #17
/*      */     //   40682: aload #20
/*      */     //   40684: ldc_w 'soundtrack'
/*      */     //   40687: invokevirtual startsWith : (Ljava/lang/String;)Z
/*      */     //   40690: ifne -> 40698
/*      */     //   40693: goto_w -> 40715
/*      */     //   40698: aload_0
/*      */     //   40699: ldc_w 'soundtrack'
/*      */     //   40702: aload #20
/*      */     //   40704: iconst_0
/*      */     //   40705: invokevirtual getstring : (Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
/*      */     //   40708: astore #11
/*      */     //   40710: goto_w -> 40715
/*      */     //   40715: goto_w -> 40520
/*      */     //   40720: aload #17
/*      */     //   40722: invokevirtual trim : ()Ljava/lang/String;
/*      */     //   40725: astore #17
/*      */     //   40727: new java/lang/StringBuilder
/*      */     //   40730: dup
/*      */     //   40731: invokespecial <init> : ()V
/*      */     //   40734: aload #17
/*      */     //   40736: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40739: ldc_w '\\r\\n\\r\\n'
/*      */     //   40742: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40745: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   40748: astore #17
/*      */     //   40750: new java/io/File
/*      */     //   40753: dup
/*      */     //   40754: new java/lang/StringBuilder
/*      */     //   40757: dup
/*      */     //   40758: invokespecial <init> : ()V
/*      */     //   40761: ldc ''
/*      */     //   40763: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40766: getstatic Madness.fpath : Ljava/lang/String;
/*      */     //   40769: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40772: ldc_w 'mystages/'
/*      */     //   40775: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40778: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   40781: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   40784: astore #20
/*      */     //   40786: aload #20
/*      */     //   40788: invokevirtual exists : ()Z
/*      */     //   40791: ifeq -> 40799
/*      */     //   40794: goto_w -> 40810
/*      */     //   40799: aload #20
/*      */     //   40801: invokevirtual mkdirs : ()Z
/*      */     //   40804: pop
/*      */     //   40805: goto_w -> 40810
/*      */     //   40810: new java/io/File
/*      */     //   40813: dup
/*      */     //   40814: new java/lang/StringBuilder
/*      */     //   40817: dup
/*      */     //   40818: invokespecial <init> : ()V
/*      */     //   40821: ldc ''
/*      */     //   40823: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40826: getstatic Madness.fpath : Ljava/lang/String;
/*      */     //   40829: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40832: ldc_w 'mystages/'
/*      */     //   40835: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40838: aload_0
/*      */     //   40839: getfield mystages : [Ljava/lang/String;
/*      */     //   40842: iload_1
/*      */     //   40843: aaload
/*      */     //   40844: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40847: ldc_w '.txt'
/*      */     //   40850: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40853: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   40856: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   40859: astore #20
/*      */     //   40861: new java/io/BufferedWriter
/*      */     //   40864: dup
/*      */     //   40865: new java/io/FileWriter
/*      */     //   40868: dup
/*      */     //   40869: aload #20
/*      */     //   40871: invokespecial <init> : (Ljava/io/File;)V
/*      */     //   40874: invokespecial <init> : (Ljava/io/Writer;)V
/*      */     //   40877: astore #21
/*      */     //   40879: aload #21
/*      */     //   40881: aload #17
/*      */     //   40883: invokevirtual write : (Ljava/lang/String;)V
/*      */     //   40886: aload #21
/*      */     //   40888: invokevirtual close : ()V
/*      */     //   40891: aconst_null
/*      */     //   40892: astore #21
/*      */     //   40894: aload #6
/*      */     //   40896: invokevirtual close : ()V
/*      */     //   40899: aload #11
/*      */     //   40901: ldc ''
/*      */     //   40903: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   40906: ifeq -> 40914
/*      */     //   40909: goto_w -> 41234
/*      */     //   40914: aload_0
/*      */     //   40915: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   40918: new java/awt/Color
/*      */     //   40921: dup
/*      */     //   40922: iconst_0
/*      */     //   40923: iconst_0
/*      */     //   40924: iconst_0
/*      */     //   40925: invokespecial <init> : (III)V
/*      */     //   40928: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   40931: aload_0
/*      */     //   40932: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   40935: ldc_w 'Downloading stage's sound track...'
/*      */     //   40938: sipush #400
/*      */     //   40941: aload_0
/*      */     //   40942: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   40945: ldc_w 'Downloading stage's sound track...'
/*      */     //   40948: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   40951: iconst_2
/*      */     //   40952: idiv
/*      */     //   40953: isub
/*      */     //   40954: sipush #280
/*      */     //   40957: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   40960: aload_0
/*      */     //   40961: invokevirtual repaint : ()V
/*      */     //   40964: new java/lang/StringBuilder
/*      */     //   40967: dup
/*      */     //   40968: invokespecial <init> : ()V
/*      */     //   40971: ldc_w 'http://multiplayer.needformadness.com/tracks/music/'
/*      */     //   40974: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40977: aload #11
/*      */     //   40979: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40982: ldc_w '.zip'
/*      */     //   40985: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   40988: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   40991: astore #4
/*      */     //   40993: aload #4
/*      */     //   40995: bipush #32
/*      */     //   40997: bipush #95
/*      */     //   40999: invokevirtual replace : (CC)Ljava/lang/String;
/*      */     //   41002: astore #4
/*      */     //   41004: new java/net/URL
/*      */     //   41007: dup
/*      */     //   41008: aload #4
/*      */     //   41010: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   41013: astore #5
/*      */     //   41015: aload #5
/*      */     //   41017: invokevirtual openConnection : ()Ljava/net/URLConnection;
/*      */     //   41020: invokevirtual getContentLength : ()I
/*      */     //   41023: istore #7
/*      */     //   41025: new java/io/File
/*      */     //   41028: dup
/*      */     //   41029: new java/lang/StringBuilder
/*      */     //   41032: dup
/*      */     //   41033: invokespecial <init> : ()V
/*      */     //   41036: ldc ''
/*      */     //   41038: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41041: getstatic Madness.fpath : Ljava/lang/String;
/*      */     //   41044: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41047: ldc_w 'mystages/mymusic/'
/*      */     //   41050: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41053: aload #11
/*      */     //   41055: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41058: ldc_w '.zip'
/*      */     //   41061: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41064: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   41067: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   41070: astore #20
/*      */     //   41072: aload #20
/*      */     //   41074: invokevirtual exists : ()Z
/*      */     //   41077: ifne -> 41085
/*      */     //   41080: goto_w -> 41150
/*      */     //   41085: aload #20
/*      */     //   41087: invokevirtual length : ()J
/*      */     //   41090: iload #7
/*      */     //   41092: i2l
/*      */     //   41093: lcmp
/*      */     //   41094: ifeq -> 41102
/*      */     //   41097: goto_w -> 41109
/*      */     //   41102: iconst_1
/*      */     //   41103: istore_3
/*      */     //   41104: goto_w -> 41150
/*      */     //   41109: aconst_null
/*      */     //   41110: new java/lang/StringBuilder
/*      */     //   41113: dup
/*      */     //   41114: invokespecial <init> : ()V
/*      */     //   41117: ldc_w 'Another track named ''
/*      */     //   41120: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41123: aload #11
/*      */     //   41125: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41128: ldc_w '' already exists in your Sound Tracks folder!\\nReplace it with the one attached to this stage?'
/*      */     //   41131: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41134: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   41137: ldc_w 'Stage Maker'
/*      */     //   41140: iconst_0
/*      */     //   41141: invokestatic showConfirmDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)I
/*      */     //   41144: istore_3
/*      */     //   41145: goto_w -> 41150
/*      */     //   41150: iload_3
/*      */     //   41151: ifeq -> 41159
/*      */     //   41154: goto_w -> 41222
/*      */     //   41159: new java/io/DataInputStream
/*      */     //   41162: dup
/*      */     //   41163: aload #5
/*      */     //   41165: invokevirtual openStream : ()Ljava/io/InputStream;
/*      */     //   41168: invokespecial <init> : (Ljava/io/InputStream;)V
/*      */     //   41171: astore #8
/*      */     //   41173: iload #7
/*      */     //   41175: newarray byte
/*      */     //   41177: astore #9
/*      */     //   41179: aload #8
/*      */     //   41181: aload #9
/*      */     //   41183: invokevirtual readFully : ([B)V
/*      */     //   41186: aload #8
/*      */     //   41188: invokevirtual close : ()V
/*      */     //   41191: new java/io/FileOutputStream
/*      */     //   41194: dup
/*      */     //   41195: aload #20
/*      */     //   41197: invokespecial <init> : (Ljava/io/File;)V
/*      */     //   41200: astore #22
/*      */     //   41202: aload #22
/*      */     //   41204: aload #9
/*      */     //   41206: invokevirtual write : ([B)V
/*      */     //   41209: aload #22
/*      */     //   41211: invokevirtual close : ()V
/*      */     //   41214: aconst_null
/*      */     //   41215: astore #22
/*      */     //   41217: goto_w -> 41222
/*      */     //   41222: goto_w -> 41234
/*      */     //   41227: astore #22
/*      */     //   41229: goto_w -> 41234
/*      */     //   41234: aload_0
/*      */     //   41235: new java/awt/Cursor
/*      */     //   41238: dup
/*      */     //   41239: iconst_0
/*      */     //   41240: invokespecial <init> : (I)V
/*      */     //   41243: invokevirtual setCursor : (Ljava/awt/Cursor;)V
/*      */     //   41246: aconst_null
/*      */     //   41247: new java/lang/StringBuilder
/*      */     //   41250: dup
/*      */     //   41251: invokespecial <init> : ()V
/*      */     //   41254: ldc ''
/*      */     //   41256: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41259: aload_0
/*      */     //   41260: getfield mystages : [Ljava/lang/String;
/*      */     //   41263: iload_1
/*      */     //   41264: aaload
/*      */     //   41265: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41268: ldc_w ' has been successfully downloaded!'
/*      */     //   41271: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41274: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   41277: ldc_w 'Stage Maker'
/*      */     //   41280: iconst_1
/*      */     //   41281: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   41284: goto_w -> 41300
/*      */     //   41289: aconst_null
/*      */     //   41290: ldc_w 'Unable to download stage.  Unknown Error!     \\nPlease try again later.'
/*      */     //   41293: ldc_w 'Stage Maker'
/*      */     //   41296: iconst_1
/*      */     //   41297: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   41300: goto_w -> 41323
/*      */     //   41305: astore #4
/*      */     //   41307: aconst_null
/*      */     //   41308: ldc_w 'Unable to download stage.  Unknown Error!     \\nPlease try again later.'
/*      */     //   41311: ldc_w 'Stage Maker'
/*      */     //   41314: iconst_1
/*      */     //   41315: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   41318: goto_w -> 41323
/*      */     //   41323: goto_w -> 41328
/*      */     //   41328: goto_w -> 41367
/*      */     //   41333: aload_0
/*      */     //   41334: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   41337: ldc_w '-    Error Loading this stage's info!    -'
/*      */     //   41340: sipush #550
/*      */     //   41343: aload_0
/*      */     //   41344: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   41347: ldc_w '-    Error Loading this stage's info!    -'
/*      */     //   41350: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   41353: iconst_2
/*      */     //   41354: idiv
/*      */     //   41355: isub
/*      */     //   41356: sipush #156
/*      */     //   41359: iload_1
/*      */     //   41360: bipush #20
/*      */     //   41362: imul
/*      */     //   41363: iadd
/*      */     //   41364: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   41367: aload_0
/*      */     //   41368: ldc_w 'X'
/*      */     //   41371: sipush #765
/*      */     //   41374: sipush #156
/*      */     //   41377: iload_1
/*      */     //   41378: bipush #20
/*      */     //   41380: imul
/*      */     //   41381: iadd
/*      */     //   41382: invokevirtual ovbutton : (Ljava/lang/String;II)Z
/*      */     //   41385: ifne -> 41393
/*      */     //   41388: goto_w -> 41687
/*      */     //   41393: aconst_null
/*      */     //   41394: new java/lang/StringBuilder
/*      */     //   41397: dup
/*      */     //   41398: invokespecial <init> : ()V
/*      */     //   41401: ldc_w 'Remove '
/*      */     //   41404: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41407: aload_0
/*      */     //   41408: getfield mystages : [Ljava/lang/String;
/*      */     //   41411: iload_1
/*      */     //   41412: aaload
/*      */     //   41413: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41416: ldc_w ' from your account?'
/*      */     //   41419: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41422: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   41425: ldc_w 'Stage Maker'
/*      */     //   41428: iconst_0
/*      */     //   41429: invokestatic showConfirmDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)I
/*      */     //   41432: ifeq -> 41440
/*      */     //   41435: goto_w -> 41687
/*      */     //   41440: aload_0
/*      */     //   41441: new java/awt/Cursor
/*      */     //   41444: dup
/*      */     //   41445: iconst_3
/*      */     //   41446: invokespecial <init> : (I)V
/*      */     //   41449: invokevirtual setCursor : (Ljava/awt/Cursor;)V
/*      */     //   41452: iconst_m1
/*      */     //   41453: istore_2
/*      */     //   41454: new java/net/Socket
/*      */     //   41457: dup
/*      */     //   41458: ldc_w 'multiplayer.needformadness.com'
/*      */     //   41461: sipush #7061
/*      */     //   41464: invokespecial <init> : (Ljava/lang/String;I)V
/*      */     //   41467: astore_3
/*      */     //   41468: new java/io/BufferedReader
/*      */     //   41471: dup
/*      */     //   41472: new java/io/InputStreamReader
/*      */     //   41475: dup
/*      */     //   41476: aload_3
/*      */     //   41477: invokevirtual getInputStream : ()Ljava/io/InputStream;
/*      */     //   41480: invokespecial <init> : (Ljava/io/InputStream;)V
/*      */     //   41483: invokespecial <init> : (Ljava/io/Reader;)V
/*      */     //   41486: astore #4
/*      */     //   41488: new java/io/PrintWriter
/*      */     //   41491: dup
/*      */     //   41492: aload_3
/*      */     //   41493: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
/*      */     //   41496: iconst_1
/*      */     //   41497: invokespecial <init> : (Ljava/io/OutputStream;Z)V
/*      */     //   41500: astore #5
/*      */     //   41502: aload #5
/*      */     //   41504: new java/lang/StringBuilder
/*      */     //   41507: dup
/*      */     //   41508: invokespecial <init> : ()V
/*      */     //   41511: ldc_w '19|'
/*      */     //   41514: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41517: aload_0
/*      */     //   41518: getfield tnick : Ljava/awt/TextField;
/*      */     //   41521: invokevirtual getText : ()Ljava/lang/String;
/*      */     //   41524: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41527: ldc_w '|'
/*      */     //   41530: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41533: aload_0
/*      */     //   41534: getfield tpass : Ljava/awt/TextField;
/*      */     //   41537: invokevirtual getText : ()Ljava/lang/String;
/*      */     //   41540: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41543: ldc_w '|'
/*      */     //   41546: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41549: aload_0
/*      */     //   41550: getfield mystages : [Ljava/lang/String;
/*      */     //   41553: iload_1
/*      */     //   41554: aaload
/*      */     //   41555: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41558: ldc_w '|'
/*      */     //   41561: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41564: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   41567: invokevirtual println : (Ljava/lang/String;)V
/*      */     //   41570: aload #4
/*      */     //   41572: invokevirtual readLine : ()Ljava/lang/String;
/*      */     //   41575: astore #6
/*      */     //   41577: aload #6
/*      */     //   41579: ifnonnull -> 41587
/*      */     //   41582: goto_w -> 41600
/*      */     //   41587: aload_0
/*      */     //   41588: aload #6
/*      */     //   41590: iconst_0
/*      */     //   41591: invokevirtual servervalue : (Ljava/lang/String;I)I
/*      */     //   41594: istore_2
/*      */     //   41595: goto_w -> 41600
/*      */     //   41600: aload_3
/*      */     //   41601: invokevirtual close : ()V
/*      */     //   41604: goto_w -> 41612
/*      */     //   41609: astore_3
/*      */     //   41610: iconst_m1
/*      */     //   41611: istore_2
/*      */     //   41612: iload_2
/*      */     //   41613: ifeq -> 41621
/*      */     //   41616: goto_w -> 41631
/*      */     //   41621: aload_0
/*      */     //   41622: iconst_1
/*      */     //   41623: putfield logged : I
/*      */     //   41626: goto_w -> 41682
/*      */     //   41631: aload_0
/*      */     //   41632: new java/awt/Cursor
/*      */     //   41635: dup
/*      */     //   41636: iconst_0
/*      */     //   41637: invokespecial <init> : (I)V
/*      */     //   41640: invokevirtual setCursor : (Ljava/awt/Cursor;)V
/*      */     //   41643: aconst_null
/*      */     //   41644: new java/lang/StringBuilder
/*      */     //   41647: dup
/*      */     //   41648: invokespecial <init> : ()V
/*      */     //   41651: ldc_w 'Failed to remove '
/*      */     //   41654: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41657: aload_0
/*      */     //   41658: getfield mystages : [Ljava/lang/String;
/*      */     //   41661: iload_1
/*      */     //   41662: aaload
/*      */     //   41663: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41666: ldc_w ' from your account.  Unknown Error!     \\nPlease try again later.'
/*      */     //   41669: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41672: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   41675: ldc_w 'Stage Maker'
/*      */     //   41678: iconst_1
/*      */     //   41679: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   41682: goto_w -> 41687
/*      */     //   41687: iinc #1, 1
/*      */     //   41690: goto_w -> 38642
/*      */     //   41695: goto_w -> 41700
/*      */     //   41700: aload_0
/*      */     //   41701: getfield logged : I
/*      */     //   41704: iconst_2
/*      */     //   41705: if_icmpeq -> 41713
/*      */     //   41708: goto_w -> 42330
/*      */     //   41713: aload_0
/*      */     //   41714: getfield mystages : [Ljava/lang/String;
/*      */     //   41717: aload_0
/*      */     //   41718: getfield roto : I
/*      */     //   41721: aload_0
/*      */     //   41722: getfield pubitem : LSmenu;
/*      */     //   41725: invokevirtual getSelectedItem : ()Ljava/lang/String;
/*      */     //   41728: aastore
/*      */     //   41729: aload_0
/*      */     //   41730: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   41733: new java/awt/Font
/*      */     //   41736: dup
/*      */     //   41737: ldc_w 'Arial'
/*      */     //   41740: iconst_1
/*      */     //   41741: bipush #13
/*      */     //   41743: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   41746: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   41749: aload_0
/*      */     //   41750: aload_0
/*      */     //   41751: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   41754: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   41757: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   41760: aload_0
/*      */     //   41761: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   41764: new java/awt/Color
/*      */     //   41767: dup
/*      */     //   41768: sipush #225
/*      */     //   41771: sipush #225
/*      */     //   41774: sipush #225
/*      */     //   41777: invokespecial <init> : (III)V
/*      */     //   41780: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   41783: aload_0
/*      */     //   41784: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   41787: bipush #50
/*      */     //   41789: sipush #150
/*      */     //   41792: sipush #600
/*      */     //   41795: sipush #150
/*      */     //   41798: invokevirtual fillRect : (IIII)V
/*      */     //   41801: aload_0
/*      */     //   41802: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   41805: new java/awt/Color
/*      */     //   41808: dup
/*      */     //   41809: iconst_0
/*      */     //   41810: iconst_0
/*      */     //   41811: iconst_0
/*      */     //   41812: invokespecial <init> : (III)V
/*      */     //   41815: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   41818: aload_0
/*      */     //   41819: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   41822: new java/lang/StringBuilder
/*      */     //   41825: dup
/*      */     //   41826: invokespecial <init> : ()V
/*      */     //   41829: ldc_w 'Loading '
/*      */     //   41832: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41835: aload_0
/*      */     //   41836: getfield mystages : [Ljava/lang/String;
/*      */     //   41839: aload_0
/*      */     //   41840: getfield roto : I
/*      */     //   41843: aaload
/*      */     //   41844: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41847: ldc_w '‘s info...'
/*      */     //   41850: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41853: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   41856: sipush #400
/*      */     //   41859: aload_0
/*      */     //   41860: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   41863: new java/lang/StringBuilder
/*      */     //   41866: dup
/*      */     //   41867: invokespecial <init> : ()V
/*      */     //   41870: ldc_w 'Loading '
/*      */     //   41873: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41876: aload_0
/*      */     //   41877: getfield mystages : [Ljava/lang/String;
/*      */     //   41880: aload_0
/*      */     //   41881: getfield roto : I
/*      */     //   41884: aaload
/*      */     //   41885: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41888: ldc_w '‘s info...'
/*      */     //   41891: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41894: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   41897: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   41900: iconst_2
/*      */     //   41901: idiv
/*      */     //   41902: isub
/*      */     //   41903: sipush #220
/*      */     //   41906: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   41909: aload_0
/*      */     //   41910: invokevirtual repaint : ()V
/*      */     //   41913: aload_0
/*      */     //   41914: getfield maker : [Ljava/lang/String;
/*      */     //   41917: aload_0
/*      */     //   41918: getfield roto : I
/*      */     //   41921: ldc_w 'Unkown'
/*      */     //   41924: aastore
/*      */     //   41925: aload_0
/*      */     //   41926: getfield pubt : [I
/*      */     //   41929: aload_0
/*      */     //   41930: getfield roto : I
/*      */     //   41933: iconst_m1
/*      */     //   41934: iastore
/*      */     //   41935: aload_0
/*      */     //   41936: getfield nad : [I
/*      */     //   41939: aload_0
/*      */     //   41940: getfield roto : I
/*      */     //   41943: iconst_0
/*      */     //   41944: iastore
/*      */     //   41945: ldc ''
/*      */     //   41947: astore_1
/*      */     //   41948: new java/lang/StringBuilder
/*      */     //   41951: dup
/*      */     //   41952: invokespecial <init> : ()V
/*      */     //   41955: ldc_w 'http://multiplayer.needformadness.com/tracks/'
/*      */     //   41958: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41961: aload_0
/*      */     //   41962: getfield mystages : [Ljava/lang/String;
/*      */     //   41965: aload_0
/*      */     //   41966: getfield roto : I
/*      */     //   41969: aaload
/*      */     //   41970: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41973: ldc_w '.txt?reqlo='
/*      */     //   41976: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41979: invokestatic random : ()D
/*      */     //   41982: ldc2_w 1000.0
/*      */     //   41985: dmul
/*      */     //   41986: d2i
/*      */     //   41987: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   41990: ldc ''
/*      */     //   41992: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   41995: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   41998: astore_2
/*      */     //   41999: aload_2
/*      */     //   42000: bipush #32
/*      */     //   42002: bipush #95
/*      */     //   42004: invokevirtual replace : (CC)Ljava/lang/String;
/*      */     //   42007: astore_2
/*      */     //   42008: new java/net/URL
/*      */     //   42011: dup
/*      */     //   42012: aload_2
/*      */     //   42013: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   42016: astore_3
/*      */     //   42017: new java/io/DataInputStream
/*      */     //   42020: dup
/*      */     //   42021: aload_3
/*      */     //   42022: invokevirtual openStream : ()Ljava/io/InputStream;
/*      */     //   42025: invokespecial <init> : (Ljava/io/InputStream;)V
/*      */     //   42028: astore #4
/*      */     //   42030: aload #4
/*      */     //   42032: invokevirtual readLine : ()Ljava/lang/String;
/*      */     //   42035: dup
/*      */     //   42036: astore_1
/*      */     //   42037: ifnonnull -> 42045
/*      */     //   42040: goto_w -> 42233
/*      */     //   42045: new java/lang/StringBuilder
/*      */     //   42048: dup
/*      */     //   42049: invokespecial <init> : ()V
/*      */     //   42052: ldc ''
/*      */     //   42054: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   42057: aload_1
/*      */     //   42058: invokevirtual trim : ()Ljava/lang/String;
/*      */     //   42061: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   42064: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   42067: astore_1
/*      */     //   42068: aload_1
/*      */     //   42069: ldc_w 'details'
/*      */     //   42072: invokevirtual startsWith : (Ljava/lang/String;)Z
/*      */     //   42075: ifne -> 42083
/*      */     //   42078: goto_w -> 42030
/*      */     //   42083: aload_0
/*      */     //   42084: getfield maker : [Ljava/lang/String;
/*      */     //   42087: aload_0
/*      */     //   42088: getfield roto : I
/*      */     //   42091: aload_0
/*      */     //   42092: ldc_w 'details'
/*      */     //   42095: aload_1
/*      */     //   42096: iconst_0
/*      */     //   42097: invokevirtual getSvalue : (Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
/*      */     //   42100: aastore
/*      */     //   42101: aload_0
/*      */     //   42102: getfield pubt : [I
/*      */     //   42105: aload_0
/*      */     //   42106: getfield roto : I
/*      */     //   42109: aload_0
/*      */     //   42110: ldc_w 'details'
/*      */     //   42113: aload_1
/*      */     //   42114: iconst_1
/*      */     //   42115: invokevirtual getvalue : (Ljava/lang/String;Ljava/lang/String;I)I
/*      */     //   42118: iastore
/*      */     //   42119: iconst_0
/*      */     //   42120: istore #5
/*      */     //   42122: iload #5
/*      */     //   42124: ifeq -> 42132
/*      */     //   42127: goto_w -> 42228
/*      */     //   42132: aload_0
/*      */     //   42133: getfield addeda : [[Ljava/lang/String;
/*      */     //   42136: aload_0
/*      */     //   42137: getfield roto : I
/*      */     //   42140: aaload
/*      */     //   42141: aload_0
/*      */     //   42142: getfield nad : [I
/*      */     //   42145: aload_0
/*      */     //   42146: getfield roto : I
/*      */     //   42149: iaload
/*      */     //   42150: aload_0
/*      */     //   42151: ldc_w 'details'
/*      */     //   42154: aload_1
/*      */     //   42155: iconst_2
/*      */     //   42156: aload_0
/*      */     //   42157: getfield nad : [I
/*      */     //   42160: aload_0
/*      */     //   42161: getfield roto : I
/*      */     //   42164: iaload
/*      */     //   42165: iadd
/*      */     //   42166: invokevirtual getSvalue : (Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
/*      */     //   42169: aastore
/*      */     //   42170: aload_0
/*      */     //   42171: getfield addeda : [[Ljava/lang/String;
/*      */     //   42174: aload_0
/*      */     //   42175: getfield roto : I
/*      */     //   42178: aaload
/*      */     //   42179: aload_0
/*      */     //   42180: getfield nad : [I
/*      */     //   42183: aload_0
/*      */     //   42184: getfield roto : I
/*      */     //   42187: iaload
/*      */     //   42188: aaload
/*      */     //   42189: ldc ''
/*      */     //   42191: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   42194: ifne -> 42202
/*      */     //   42197: goto_w -> 42210
/*      */     //   42202: iconst_1
/*      */     //   42203: istore #5
/*      */     //   42205: goto_w -> 42122
/*      */     //   42210: aload_0
/*      */     //   42211: getfield nad : [I
/*      */     //   42214: aload_0
/*      */     //   42215: getfield roto : I
/*      */     //   42218: dup2
/*      */     //   42219: iaload
/*      */     //   42220: iconst_1
/*      */     //   42221: iadd
/*      */     //   42222: iastore
/*      */     //   42223: goto_w -> 42122
/*      */     //   42228: goto_w -> 42030
/*      */     //   42233: aload_0
/*      */     //   42234: dup
/*      */     //   42235: getfield nms : I
/*      */     //   42238: iconst_1
/*      */     //   42239: iadd
/*      */     //   42240: putfield nms : I
/*      */     //   42243: aload_0
/*      */     //   42244: getfield nms : I
/*      */     //   42247: bipush #20
/*      */     //   42249: if_icmpgt -> 42257
/*      */     //   42252: goto_w -> 42268
/*      */     //   42257: aload_0
/*      */     //   42258: bipush #20
/*      */     //   42260: putfield nms : I
/*      */     //   42263: goto_w -> 42268
/*      */     //   42268: aload_0
/*      */     //   42269: dup
/*      */     //   42270: getfield roto : I
/*      */     //   42273: iconst_1
/*      */     //   42274: iadd
/*      */     //   42275: putfield roto : I
/*      */     //   42278: aload_0
/*      */     //   42279: getfield roto : I
/*      */     //   42282: bipush #20
/*      */     //   42284: if_icmpge -> 42292
/*      */     //   42287: goto_w -> 42302
/*      */     //   42292: aload_0
/*      */     //   42293: iconst_0
/*      */     //   42294: putfield roto : I
/*      */     //   42297: goto_w -> 42302
/*      */     //   42302: goto_w -> 42308
/*      */     //   42307: astore_2
/*      */     //   42308: aload_0
/*      */     //   42309: new java/awt/Cursor
/*      */     //   42312: dup
/*      */     //   42313: iconst_0
/*      */     //   42314: invokespecial <init> : (I)V
/*      */     //   42317: invokevirtual setCursor : (Ljava/awt/Cursor;)V
/*      */     //   42320: aload_0
/*      */     //   42321: iconst_3
/*      */     //   42322: putfield logged : I
/*      */     //   42325: goto_w -> 42330
/*      */     //   42330: aload_0
/*      */     //   42331: getfield logged : I
/*      */     //   42334: iconst_m1
/*      */     //   42335: if_icmpeq -> 42343
/*      */     //   42338: goto_w -> 42506
/*      */     //   42343: aload_0
/*      */     //   42344: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   42347: new java/awt/Font
/*      */     //   42350: dup
/*      */     //   42351: ldc_w 'Arial'
/*      */     //   42354: iconst_1
/*      */     //   42355: bipush #13
/*      */     //   42357: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   42360: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   42363: aload_0
/*      */     //   42364: aload_0
/*      */     //   42365: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   42368: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   42371: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   42374: aload_0
/*      */     //   42375: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   42378: new java/awt/Color
/*      */     //   42381: dup
/*      */     //   42382: iconst_0
/*      */     //   42383: iconst_0
/*      */     //   42384: iconst_0
/*      */     //   42385: invokespecial <init> : (III)V
/*      */     //   42388: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   42391: aload_0
/*      */     //   42392: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   42395: ldc_w 'Ready to publish...'
/*      */     //   42398: sipush #400
/*      */     //   42401: aload_0
/*      */     //   42402: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   42405: ldc_w 'Ready to publish...'
/*      */     //   42408: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   42411: iconst_2
/*      */     //   42412: idiv
/*      */     //   42413: isub
/*      */     //   42414: sipush #220
/*      */     //   42417: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   42420: aload_0
/*      */     //   42421: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   42424: new java/lang/StringBuilder
/*      */     //   42427: dup
/*      */     //   42428: invokespecial <init> : ()V
/*      */     //   42431: ldc_w 'Click ‘Publish’ above to add stage: ''
/*      */     //   42434: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   42437: aload_0
/*      */     //   42438: getfield stagename : Ljava/lang/String;
/*      */     //   42441: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   42444: ldc_w ''.'
/*      */     //   42447: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   42450: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   42453: sipush #400
/*      */     //   42456: aload_0
/*      */     //   42457: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   42460: new java/lang/StringBuilder
/*      */     //   42463: dup
/*      */     //   42464: invokespecial <init> : ()V
/*      */     //   42467: ldc_w 'Click ‘Publish’ above to add stage: ''
/*      */     //   42470: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   42473: aload_0
/*      */     //   42474: getfield stagename : Ljava/lang/String;
/*      */     //   42477: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   42480: ldc_w ''.'
/*      */     //   42483: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   42486: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   42489: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   42492: iconst_2
/*      */     //   42493: idiv
/*      */     //   42494: isub
/*      */     //   42495: sipush #280
/*      */     //   42498: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   42501: goto_w -> 42506
/*      */     //   42506: aload_0
/*      */     //   42507: getfield logged : I
/*      */     //   42510: iconst_1
/*      */     //   42511: if_icmpeq -> 42519
/*      */     //   42514: goto_w -> 43032
/*      */     //   42519: aload_0
/*      */     //   42520: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   42523: new java/awt/Color
/*      */     //   42526: dup
/*      */     //   42527: sipush #225
/*      */     //   42530: sipush #225
/*      */     //   42533: sipush #225
/*      */     //   42536: invokespecial <init> : (III)V
/*      */     //   42539: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   42542: aload_0
/*      */     //   42543: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   42546: bipush #11
/*      */     //   42548: sipush #141
/*      */     //   42551: sipush #779
/*      */     //   42554: sipush #401
/*      */     //   42557: invokevirtual fillRect : (IIII)V
/*      */     //   42560: aload_0
/*      */     //   42561: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   42564: new java/awt/Font
/*      */     //   42567: dup
/*      */     //   42568: ldc_w 'Arial'
/*      */     //   42571: iconst_1
/*      */     //   42572: bipush #13
/*      */     //   42574: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   42577: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   42580: aload_0
/*      */     //   42581: aload_0
/*      */     //   42582: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   42585: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   42588: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   42591: aload_0
/*      */     //   42592: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   42595: new java/awt/Color
/*      */     //   42598: dup
/*      */     //   42599: iconst_0
/*      */     //   42600: iconst_0
/*      */     //   42601: iconst_0
/*      */     //   42602: invokespecial <init> : (III)V
/*      */     //   42605: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   42608: aload_0
/*      */     //   42609: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   42612: ldc_w 'Loading your account's stage list...'
/*      */     //   42615: sipush #400
/*      */     //   42618: aload_0
/*      */     //   42619: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   42622: ldc_w 'Loading your account's stage list...'
/*      */     //   42625: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   42628: iconst_2
/*      */     //   42629: idiv
/*      */     //   42630: isub
/*      */     //   42631: sipush #220
/*      */     //   42634: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   42637: aload_0
/*      */     //   42638: invokevirtual repaint : ()V
/*      */     //   42641: aload_0
/*      */     //   42642: getfield pubitem : LSmenu;
/*      */     //   42645: invokevirtual removeAll : ()V
/*      */     //   42648: aload_0
/*      */     //   42649: getfield pubitem : LSmenu;
/*      */     //   42652: aload_0
/*      */     //   42653: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   42656: ldc_w 'Account Stage'
/*      */     //   42659: invokevirtual add : (Ljava/awt/Graphics2D;Ljava/lang/String;)V
/*      */     //   42662: aload_0
/*      */     //   42663: iconst_0
/*      */     //   42664: putfield nms : I
/*      */     //   42667: aload_0
/*      */     //   42668: iconst_0
/*      */     //   42669: putfield roto : I
/*      */     //   42672: iconst_0
/*      */     //   42673: istore_1
/*      */     //   42674: ldc ''
/*      */     //   42676: astore_2
/*      */     //   42677: new java/net/URL
/*      */     //   42680: dup
/*      */     //   42681: new java/lang/StringBuilder
/*      */     //   42684: dup
/*      */     //   42685: invokespecial <init> : ()V
/*      */     //   42688: ldc_w 'http://multiplayer.needformadness.com/tracks/lists/'
/*      */     //   42691: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   42694: aload_0
/*      */     //   42695: getfield tnick : Ljava/awt/TextField;
/*      */     //   42698: invokevirtual getText : ()Ljava/lang/String;
/*      */     //   42701: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   42704: ldc_w '.txt?reqlo='
/*      */     //   42707: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   42710: invokestatic random : ()D
/*      */     //   42713: ldc2_w 1000.0
/*      */     //   42716: dmul
/*      */     //   42717: d2i
/*      */     //   42718: invokevirtual append : (I)Ljava/lang/StringBuilder;
/*      */     //   42721: ldc ''
/*      */     //   42723: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   42726: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   42729: invokespecial <init> : (Ljava/lang/String;)V
/*      */     //   42732: astore_3
/*      */     //   42733: new java/io/DataInputStream
/*      */     //   42736: dup
/*      */     //   42737: aload_3
/*      */     //   42738: invokevirtual openStream : ()Ljava/io/InputStream;
/*      */     //   42741: invokespecial <init> : (Ljava/io/InputStream;)V
/*      */     //   42744: astore #4
/*      */     //   42746: aload #4
/*      */     //   42748: invokevirtual readLine : ()Ljava/lang/String;
/*      */     //   42751: dup
/*      */     //   42752: astore_2
/*      */     //   42753: ifnonnull -> 42761
/*      */     //   42756: goto_w -> 42884
/*      */     //   42761: new java/lang/StringBuilder
/*      */     //   42764: dup
/*      */     //   42765: invokespecial <init> : ()V
/*      */     //   42768: ldc ''
/*      */     //   42770: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   42773: aload_2
/*      */     //   42774: invokevirtual trim : ()Ljava/lang/String;
/*      */     //   42777: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   42780: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   42783: astore_2
/*      */     //   42784: aload_2
/*      */     //   42785: ldc_w 'mystages'
/*      */     //   42788: invokevirtual startsWith : (Ljava/lang/String;)Z
/*      */     //   42791: ifne -> 42799
/*      */     //   42794: goto_w -> 42746
/*      */     //   42799: iconst_1
/*      */     //   42800: istore #5
/*      */     //   42802: iload #5
/*      */     //   42804: ifne -> 42812
/*      */     //   42807: goto_w -> 42879
/*      */     //   42812: iload_1
/*      */     //   42813: sipush #700
/*      */     //   42816: if_icmplt -> 42824
/*      */     //   42819: goto_w -> 42879
/*      */     //   42824: aload_0
/*      */     //   42825: ldc_w 'mystages'
/*      */     //   42828: aload_2
/*      */     //   42829: iload_1
/*      */     //   42830: invokevirtual getSvalue : (Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
/*      */     //   42833: astore #6
/*      */     //   42835: aload #6
/*      */     //   42837: ldc ''
/*      */     //   42839: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   42842: ifne -> 42850
/*      */     //   42845: goto_w -> 42858
/*      */     //   42850: iconst_0
/*      */     //   42851: istore #5
/*      */     //   42853: goto_w -> 42874
/*      */     //   42858: aload_0
/*      */     //   42859: getfield pubitem : LSmenu;
/*      */     //   42862: aload_0
/*      */     //   42863: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   42866: aload #6
/*      */     //   42868: invokevirtual add : (Ljava/awt/Graphics2D;Ljava/lang/String;)V
/*      */     //   42871: iinc #1, 1
/*      */     //   42874: goto_w -> 42802
/*      */     //   42879: goto_w -> 42746
/*      */     //   42884: aload_0
/*      */     //   42885: new java/awt/Cursor
/*      */     //   42888: dup
/*      */     //   42889: iconst_0
/*      */     //   42890: invokespecial <init> : (I)V
/*      */     //   42893: invokevirtual setCursor : (Ljava/awt/Cursor;)V
/*      */     //   42896: aload_0
/*      */     //   42897: iconst_m1
/*      */     //   42898: putfield logged : I
/*      */     //   42901: aload #4
/*      */     //   42903: invokevirtual close : ()V
/*      */     //   42906: goto_w -> 42988
/*      */     //   42911: astore_3
/*      */     //   42912: new java/lang/StringBuilder
/*      */     //   42915: dup
/*      */     //   42916: invokespecial <init> : ()V
/*      */     //   42919: ldc ''
/*      */     //   42921: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   42924: aload_3
/*      */     //   42925: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
/*      */     //   42928: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   42931: astore #4
/*      */     //   42933: aload #4
/*      */     //   42935: ldc_w 'FileNotFound'
/*      */     //   42938: invokevirtual indexOf : (Ljava/lang/String;)I
/*      */     //   42941: iconst_m1
/*      */     //   42942: if_icmpne -> 42950
/*      */     //   42945: goto_w -> 42972
/*      */     //   42950: aload_0
/*      */     //   42951: new java/awt/Cursor
/*      */     //   42954: dup
/*      */     //   42955: iconst_0
/*      */     //   42956: invokespecial <init> : (I)V
/*      */     //   42959: invokevirtual setCursor : (Ljava/awt/Cursor;)V
/*      */     //   42962: aload_0
/*      */     //   42963: iconst_m1
/*      */     //   42964: putfield logged : I
/*      */     //   42967: goto_w -> 42988
/*      */     //   42972: aload_0
/*      */     //   42973: iconst_0
/*      */     //   42974: putfield logged : I
/*      */     //   42977: aconst_null
/*      */     //   42978: ldc_w 'Unable to connect to server at this moment, please try again later.'
/*      */     //   42981: ldc_w 'Stage Maker'
/*      */     //   42984: iconst_1
/*      */     //   42985: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   42988: aload_0
/*      */     //   42989: getfield justpubd : Ljava/lang/String;
/*      */     //   42992: ldc ''
/*      */     //   42994: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   42997: ifeq -> 43005
/*      */     //   43000: goto_w -> 43027
/*      */     //   43005: aload_0
/*      */     //   43006: getfield pubitem : LSmenu;
/*      */     //   43009: aload_0
/*      */     //   43010: getfield justpubd : Ljava/lang/String;
/*      */     //   43013: invokevirtual select : (Ljava/lang/String;)V
/*      */     //   43016: aload_0
/*      */     //   43017: ldc ''
/*      */     //   43019: putfield justpubd : Ljava/lang/String;
/*      */     //   43022: goto_w -> 43027
/*      */     //   43027: goto_w -> 43032
/*      */     //   43032: aload_0
/*      */     //   43033: getfield logged : I
/*      */     //   43036: ifeq -> 43044
/*      */     //   43039: goto_w -> 43819
/*      */     //   43044: aload_0
/*      */     //   43045: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   43048: new java/awt/Font
/*      */     //   43051: dup
/*      */     //   43052: ldc_w 'Arial'
/*      */     //   43055: iconst_1
/*      */     //   43056: bipush #13
/*      */     //   43058: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   43061: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   43064: aload_0
/*      */     //   43065: aload_0
/*      */     //   43066: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   43069: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   43072: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   43075: aload_0
/*      */     //   43076: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   43079: ldc_w 'Login to Retrieve your Account Stages'
/*      */     //   43082: sipush #400
/*      */     //   43085: aload_0
/*      */     //   43086: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   43089: ldc_w 'Login to Retrieve your Account Stages'
/*      */     //   43092: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   43095: iconst_2
/*      */     //   43096: idiv
/*      */     //   43097: isub
/*      */     //   43098: sipush #220
/*      */     //   43101: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   43104: aload_0
/*      */     //   43105: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   43108: ldc_w 'Nickname:'
/*      */     //   43111: sipush #376
/*      */     //   43114: aload_0
/*      */     //   43115: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   43118: ldc_w 'Nickname:'
/*      */     //   43121: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   43124: isub
/*      */     //   43125: bipush #14
/*      */     //   43127: isub
/*      */     //   43128: sipush #266
/*      */     //   43131: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   43134: aload_0
/*      */     //   43135: getfield tnick : Ljava/awt/TextField;
/*      */     //   43138: invokevirtual isShowing : ()Z
/*      */     //   43141: ifeq -> 43149
/*      */     //   43144: goto_w -> 43161
/*      */     //   43149: aload_0
/*      */     //   43150: getfield tnick : Ljava/awt/TextField;
/*      */     //   43153: invokevirtual show : ()V
/*      */     //   43156: goto_w -> 43161
/*      */     //   43161: aload_0
/*      */     //   43162: aload_0
/*      */     //   43163: getfield tnick : Ljava/awt/TextField;
/*      */     //   43166: sipush #376
/*      */     //   43169: sipush #250
/*      */     //   43172: sipush #129
/*      */     //   43175: bipush #23
/*      */     //   43177: invokevirtual movefield : (Ljava/awt/Component;IIII)V
/*      */     //   43180: aload_0
/*      */     //   43181: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   43184: ldc_w 'Password:'
/*      */     //   43187: sipush #376
/*      */     //   43190: aload_0
/*      */     //   43191: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   43194: ldc_w 'Password:'
/*      */     //   43197: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   43200: isub
/*      */     //   43201: bipush #14
/*      */     //   43203: isub
/*      */     //   43204: sipush #296
/*      */     //   43207: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   43210: aload_0
/*      */     //   43211: getfield tpass : Ljava/awt/TextField;
/*      */     //   43214: invokevirtual isShowing : ()Z
/*      */     //   43217: ifeq -> 43225
/*      */     //   43220: goto_w -> 43237
/*      */     //   43225: aload_0
/*      */     //   43226: getfield tpass : Ljava/awt/TextField;
/*      */     //   43229: invokevirtual show : ()V
/*      */     //   43232: goto_w -> 43237
/*      */     //   43237: aload_0
/*      */     //   43238: aload_0
/*      */     //   43239: getfield tpass : Ljava/awt/TextField;
/*      */     //   43242: sipush #376
/*      */     //   43245: sipush #280
/*      */     //   43248: sipush #129
/*      */     //   43251: bipush #23
/*      */     //   43253: invokevirtual movefield : (Ljava/awt/Component;IIII)V
/*      */     //   43256: aload_0
/*      */     //   43257: ldc_w '       Login       '
/*      */     //   43260: sipush #400
/*      */     //   43263: sipush #340
/*      */     //   43266: iconst_0
/*      */     //   43267: iconst_1
/*      */     //   43268: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   43271: ifne -> 43279
/*      */     //   43274: goto_w -> 43626
/*      */     //   43279: aload_0
/*      */     //   43280: new java/awt/Cursor
/*      */     //   43283: dup
/*      */     //   43284: iconst_3
/*      */     //   43285: invokespecial <init> : (I)V
/*      */     //   43288: invokevirtual setCursor : (Ljava/awt/Cursor;)V
/*      */     //   43291: iconst_m1
/*      */     //   43292: istore_1
/*      */     //   43293: new java/net/Socket
/*      */     //   43296: dup
/*      */     //   43297: ldc_w 'multiplayer.needformadness.com'
/*      */     //   43300: sipush #7061
/*      */     //   43303: invokespecial <init> : (Ljava/lang/String;I)V
/*      */     //   43306: astore_2
/*      */     //   43307: new java/io/BufferedReader
/*      */     //   43310: dup
/*      */     //   43311: new java/io/InputStreamReader
/*      */     //   43314: dup
/*      */     //   43315: aload_2
/*      */     //   43316: invokevirtual getInputStream : ()Ljava/io/InputStream;
/*      */     //   43319: invokespecial <init> : (Ljava/io/InputStream;)V
/*      */     //   43322: invokespecial <init> : (Ljava/io/Reader;)V
/*      */     //   43325: astore_3
/*      */     //   43326: new java/io/PrintWriter
/*      */     //   43329: dup
/*      */     //   43330: aload_2
/*      */     //   43331: invokevirtual getOutputStream : ()Ljava/io/OutputStream;
/*      */     //   43334: iconst_1
/*      */     //   43335: invokespecial <init> : (Ljava/io/OutputStream;Z)V
/*      */     //   43338: astore #4
/*      */     //   43340: aload #4
/*      */     //   43342: new java/lang/StringBuilder
/*      */     //   43345: dup
/*      */     //   43346: invokespecial <init> : ()V
/*      */     //   43349: ldc_w '1|'
/*      */     //   43352: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   43355: aload_0
/*      */     //   43356: getfield tnick : Ljava/awt/TextField;
/*      */     //   43359: invokevirtual getText : ()Ljava/lang/String;
/*      */     //   43362: invokevirtual toLowerCase : ()Ljava/lang/String;
/*      */     //   43365: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   43368: ldc_w '|'
/*      */     //   43371: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   43374: aload_0
/*      */     //   43375: getfield tpass : Ljava/awt/TextField;
/*      */     //   43378: invokevirtual getText : ()Ljava/lang/String;
/*      */     //   43381: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   43384: ldc_w '|'
/*      */     //   43387: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*      */     //   43390: invokevirtual toString : ()Ljava/lang/String;
/*      */     //   43393: invokevirtual println : (Ljava/lang/String;)V
/*      */     //   43396: aload_3
/*      */     //   43397: invokevirtual readLine : ()Ljava/lang/String;
/*      */     //   43400: astore #5
/*      */     //   43402: aload #5
/*      */     //   43404: ifnonnull -> 43412
/*      */     //   43407: goto_w -> 43425
/*      */     //   43412: aload_0
/*      */     //   43413: aload #5
/*      */     //   43415: iconst_0
/*      */     //   43416: invokevirtual servervalue : (Ljava/lang/String;I)I
/*      */     //   43419: istore_1
/*      */     //   43420: goto_w -> 43425
/*      */     //   43425: aload_2
/*      */     //   43426: invokevirtual close : ()V
/*      */     //   43429: goto_w -> 43437
/*      */     //   43434: astore_2
/*      */     //   43435: iconst_m1
/*      */     //   43436: istore_1
/*      */     //   43437: iload_1
/*      */     //   43438: ifne -> 43446
/*      */     //   43441: goto_w -> 43467
/*      */     //   43446: iload_1
/*      */     //   43447: iconst_3
/*      */     //   43448: if_icmpne -> 43456
/*      */     //   43451: goto_w -> 43467
/*      */     //   43456: iload_1
/*      */     //   43457: bipush #10
/*      */     //   43459: if_icmpgt -> 43467
/*      */     //   43462: goto_w -> 43495
/*      */     //   43467: aload_0
/*      */     //   43468: getfield tnick : Ljava/awt/TextField;
/*      */     //   43471: invokevirtual hide : ()V
/*      */     //   43474: aload_0
/*      */     //   43475: getfield tpass : Ljava/awt/TextField;
/*      */     //   43478: invokevirtual hide : ()V
/*      */     //   43481: aload_0
/*      */     //   43482: iconst_1
/*      */     //   43483: putfield logged : I
/*      */     //   43486: aload_0
/*      */     //   43487: invokevirtual savesettings : ()V
/*      */     //   43490: goto_w -> 43495
/*      */     //   43495: iload_1
/*      */     //   43496: iconst_1
/*      */     //   43497: if_icmpne -> 43505
/*      */     //   43500: goto_w -> 43515
/*      */     //   43505: iload_1
/*      */     //   43506: iconst_2
/*      */     //   43507: if_icmpeq -> 43515
/*      */     //   43510: goto_w -> 43543
/*      */     //   43515: aload_0
/*      */     //   43516: new java/awt/Cursor
/*      */     //   43519: dup
/*      */     //   43520: iconst_0
/*      */     //   43521: invokespecial <init> : (I)V
/*      */     //   43524: invokevirtual setCursor : (Ljava/awt/Cursor;)V
/*      */     //   43527: aconst_null
/*      */     //   43528: ldc_w 'Sorry.  Incorrect Nickname or Password!'
/*      */     //   43531: ldc_w 'Stage Maker'
/*      */     //   43534: iconst_0
/*      */     //   43535: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   43538: goto_w -> 43543
/*      */     //   43543: iload_1
/*      */     //   43544: sipush #-167
/*      */     //   43547: if_icmpeq -> 43555
/*      */     //   43550: goto_w -> 43583
/*      */     //   43555: aload_0
/*      */     //   43556: new java/awt/Cursor
/*      */     //   43559: dup
/*      */     //   43560: iconst_0
/*      */     //   43561: invokespecial <init> : (I)V
/*      */     //   43564: invokevirtual setCursor : (Ljava/awt/Cursor;)V
/*      */     //   43567: aconst_null
/*      */     //   43568: ldc_w 'Sorry.  Your trial account cannot publish stages.  Please upgrade to a full account!   '
/*      */     //   43571: ldc_w 'Stage Maker'
/*      */     //   43574: iconst_0
/*      */     //   43575: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   43578: goto_w -> 43583
/*      */     //   43583: iload_1
/*      */     //   43584: iconst_m1
/*      */     //   43585: if_icmpeq -> 43593
/*      */     //   43588: goto_w -> 43621
/*      */     //   43593: aload_0
/*      */     //   43594: new java/awt/Cursor
/*      */     //   43597: dup
/*      */     //   43598: iconst_0
/*      */     //   43599: invokespecial <init> : (I)V
/*      */     //   43602: invokevirtual setCursor : (Ljava/awt/Cursor;)V
/*      */     //   43605: aconst_null
/*      */     //   43606: ldc_w 'Unable to connect to server at this moment, please try again later.'
/*      */     //   43609: ldc_w 'Stage Maker'
/*      */     //   43612: iconst_1
/*      */     //   43613: invokestatic showMessageDialog : (Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V
/*      */     //   43616: goto_w -> 43621
/*      */     //   43621: goto_w -> 43626
/*      */     //   43626: aload_0
/*      */     //   43627: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   43630: new java/awt/Font
/*      */     //   43633: dup
/*      */     //   43634: ldc_w 'Arial'
/*      */     //   43637: iconst_1
/*      */     //   43638: bipush #13
/*      */     //   43640: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   43643: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   43646: aload_0
/*      */     //   43647: aload_0
/*      */     //   43648: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   43651: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   43654: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   43657: aload_0
/*      */     //   43658: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   43661: ldc_w 'Register a full account or if you have a trial account upgrade it!'
/*      */     //   43664: sipush #400
/*      */     //   43667: aload_0
/*      */     //   43668: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   43671: ldc_w 'Register a full account or if you have a trial account upgrade it!'
/*      */     //   43674: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   43677: iconst_2
/*      */     //   43678: idiv
/*      */     //   43679: isub
/*      */     //   43680: sipush #450
/*      */     //   43683: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   43686: aload_0
/*      */     //   43687: ldc_w '   Register!   '
/*      */     //   43690: sipush #340
/*      */     //   43693: sipush #480
/*      */     //   43696: iconst_0
/*      */     //   43697: iconst_1
/*      */     //   43698: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   43701: ifne -> 43709
/*      */     //   43704: goto_w -> 43720
/*      */     //   43709: ldc_w 'http://multiplayer.needformadness.com/register.html?ref=game'
/*      */     //   43712: invokestatic openurl : (Ljava/lang/String;)V
/*      */     //   43715: goto_w -> 43720
/*      */     //   43720: aload_0
/*      */     //   43721: ldc_w '   Upgrade!   '
/*      */     //   43724: sipush #460
/*      */     //   43727: sipush #480
/*      */     //   43730: iconst_0
/*      */     //   43731: iconst_1
/*      */     //   43732: invokevirtual button : (Ljava/lang/String;IIIZ)Z
/*      */     //   43735: ifne -> 43743
/*      */     //   43738: goto_w -> 43754
/*      */     //   43743: ldc_w 'http://multiplayer.needformadness.com/edit.pl'
/*      */     //   43746: invokestatic openurl : (Ljava/lang/String;)V
/*      */     //   43749: goto_w -> 43754
/*      */     //   43754: aload_0
/*      */     //   43755: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   43758: new java/awt/Font
/*      */     //   43761: dup
/*      */     //   43762: ldc_w 'Arial'
/*      */     //   43765: iconst_0
/*      */     //   43766: bipush #12
/*      */     //   43768: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   43771: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   43774: aload_0
/*      */     //   43775: aload_0
/*      */     //   43776: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   43779: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   43782: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   43785: aload_0
/*      */     //   43786: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   43789: ldc_w 'You need a full account to publish your stages to the multiplayer game!'
/*      */     //   43792: sipush #400
/*      */     //   43795: aload_0
/*      */     //   43796: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   43799: ldc_w 'You need a full account to publish your stages to the multiplayer game!'
/*      */     //   43802: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   43805: iconst_2
/*      */     //   43806: idiv
/*      */     //   43807: isub
/*      */     //   43808: sipush #505
/*      */     //   43811: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   43814: goto_w -> 43819
/*      */     //   43819: aload_0
/*      */     //   43820: getfield tabed : I
/*      */     //   43823: aload_0
/*      */     //   43824: getfield tab : I
/*      */     //   43827: if_icmpne -> 43835
/*      */     //   43830: goto_w -> 43872
/*      */     //   43835: aload_0
/*      */     //   43836: getfield tabed : I
/*      */     //   43839: bipush #-2
/*      */     //   43841: if_icmpeq -> 43849
/*      */     //   43844: goto_w -> 43859
/*      */     //   43849: aload_0
/*      */     //   43850: iconst_m1
/*      */     //   43851: putfield tabed : I
/*      */     //   43854: goto_w -> 43872
/*      */     //   43859: aload_0
/*      */     //   43860: aload_0
/*      */     //   43861: getfield tab : I
/*      */     //   43864: putfield tabed : I
/*      */     //   43867: goto_w -> 43872
/*      */     //   43872: aload_0
/*      */     //   43873: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   43876: new java/awt/Color
/*      */     //   43879: dup
/*      */     //   43880: iconst_0
/*      */     //   43881: iconst_0
/*      */     //   43882: iconst_0
/*      */     //   43883: invokespecial <init> : (III)V
/*      */     //   43886: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   43889: aload_0
/*      */     //   43890: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   43893: iconst_0
/*      */     //   43894: iconst_0
/*      */     //   43895: sipush #800
/*      */     //   43898: bipush #25
/*      */     //   43900: invokevirtual fillRect : (IIII)V
/*      */     //   43903: aload_0
/*      */     //   43904: getfield onbtgame : Z
/*      */     //   43907: ifeq -> 43915
/*      */     //   43910: goto_w -> 43939
/*      */     //   43915: aload_0
/*      */     //   43916: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   43919: aload_0
/*      */     //   43920: getfield btgame : [Ljava/awt/Image;
/*      */     //   43923: iconst_0
/*      */     //   43924: aaload
/*      */     //   43925: sipush #620
/*      */     //   43928: iconst_0
/*      */     //   43929: aconst_null
/*      */     //   43930: invokevirtual drawImage : (Ljava/awt/Image;IILjava/awt/image/ImageObserver;)Z
/*      */     //   43933: pop
/*      */     //   43934: goto_w -> 43958
/*      */     //   43939: aload_0
/*      */     //   43940: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   43943: aload_0
/*      */     //   43944: getfield btgame : [Ljava/awt/Image;
/*      */     //   43947: iconst_1
/*      */     //   43948: aaload
/*      */     //   43949: sipush #620
/*      */     //   43952: iconst_0
/*      */     //   43953: aconst_null
/*      */     //   43954: invokevirtual drawImage : (Ljava/awt/Image;IILjava/awt/image/ImageObserver;)Z
/*      */     //   43957: pop
/*      */     //   43958: aload_0
/*      */     //   43959: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   43962: new java/awt/Font
/*      */     //   43965: dup
/*      */     //   43966: ldc_w 'Arial'
/*      */     //   43969: iconst_1
/*      */     //   43970: bipush #13
/*      */     //   43972: invokespecial <init> : (Ljava/lang/String;II)V
/*      */     //   43975: invokevirtual setFont : (Ljava/awt/Font;)V
/*      */     //   43978: aload_0
/*      */     //   43979: aload_0
/*      */     //   43980: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   43983: invokevirtual getFontMetrics : ()Ljava/awt/FontMetrics;
/*      */     //   43986: putfield ftm : Ljava/awt/FontMetrics;
/*      */     //   43989: iconst_4
/*      */     //   43990: anewarray java/lang/String
/*      */     //   43993: dup
/*      */     //   43994: iconst_0
/*      */     //   43995: ldc_w 'Stage'
/*      */     //   43998: aastore
/*      */     //   43999: dup
/*      */     //   44000: iconst_1
/*      */     //   44001: ldc_w 'Build'
/*      */     //   44004: aastore
/*      */     //   44005: dup
/*      */     //   44006: iconst_2
/*      */     //   44007: ldc_w 'View & Edit'
/*      */     //   44010: aastore
/*      */     //   44011: dup
/*      */     //   44012: iconst_3
/*      */     //   44013: ldc_w 'Publish'
/*      */     //   44016: aastore
/*      */     //   44017: astore_1
/*      */     //   44018: iconst_4
/*      */     //   44019: newarray int
/*      */     //   44021: dup
/*      */     //   44022: iconst_0
/*      */     //   44023: iconst_0
/*      */     //   44024: iastore
/*      */     //   44025: dup
/*      */     //   44026: iconst_1
/*      */     //   44027: iconst_0
/*      */     //   44028: iastore
/*      */     //   44029: dup
/*      */     //   44030: iconst_2
/*      */     //   44031: bipush #100
/*      */     //   44033: iastore
/*      */     //   44034: dup
/*      */     //   44035: iconst_3
/*      */     //   44036: bipush #90
/*      */     //   44038: iastore
/*      */     //   44039: astore_2
/*      */     //   44040: iconst_4
/*      */     //   44041: newarray int
/*      */     //   44043: dup
/*      */     //   44044: iconst_0
/*      */     //   44045: iconst_0
/*      */     //   44046: iastore
/*      */     //   44047: dup
/*      */     //   44048: iconst_1
/*      */     //   44049: bipush #25
/*      */     //   44051: iastore
/*      */     //   44052: dup
/*      */     //   44053: iconst_2
/*      */     //   44054: bipush #25
/*      */     //   44056: iastore
/*      */     //   44057: dup
/*      */     //   44058: iconst_3
/*      */     //   44059: iconst_0
/*      */     //   44060: iastore
/*      */     //   44061: astore_3
/*      */     //   44062: iconst_4
/*      */     //   44063: istore #4
/*      */     //   44065: aload_0
/*      */     //   44066: getfield stagename : Ljava/lang/String;
/*      */     //   44069: ldc ''
/*      */     //   44071: invokevirtual equals : (Ljava/lang/Object;)Z
/*      */     //   44074: ifeq -> 44082
/*      */     //   44077: goto_w -> 44094
/*      */     //   44082: aload_0
/*      */     //   44083: getfield sfase : I
/*      */     //   44086: ifne -> 44094
/*      */     //   44089: goto_w -> 44107
/*      */     //   44094: aload_0
/*      */     //   44095: iconst_0
/*      */     //   44096: putfield tab : I
/*      */     //   44099: iconst_1
/*      */     //   44100: istore #4
/*      */     //   44102: goto_w -> 44107
/*      */     //   44107: iconst_0
/*      */     //   44108: istore #5
/*      */     //   44110: iload #5
/*      */     //   44112: iload #4
/*      */     //   44114: if_icmplt -> 44122
/*      */     //   44117: goto_w -> 44452
/*      */     //   44122: aload_0
/*      */     //   44123: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   44126: new java/awt/Color
/*      */     //   44129: dup
/*      */     //   44130: sipush #170
/*      */     //   44133: sipush #170
/*      */     //   44136: sipush #170
/*      */     //   44139: invokespecial <init> : (III)V
/*      */     //   44142: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   44145: aload_0
/*      */     //   44146: getfield xm : I
/*      */     //   44149: aload_2
/*      */     //   44150: iconst_0
/*      */     //   44151: iaload
/*      */     //   44152: if_icmpgt -> 44160
/*      */     //   44155: goto_w -> 44229
/*      */     //   44160: aload_0
/*      */     //   44161: getfield xm : I
/*      */     //   44164: aload_2
/*      */     //   44165: iconst_3
/*      */     //   44166: iaload
/*      */     //   44167: if_icmplt -> 44175
/*      */     //   44170: goto_w -> 44229
/*      */     //   44175: aload_0
/*      */     //   44176: getfield ym : I
/*      */     //   44179: ifgt -> 44187
/*      */     //   44182: goto_w -> 44229
/*      */     //   44187: aload_0
/*      */     //   44188: getfield ym : I
/*      */     //   44191: bipush #25
/*      */     //   44193: if_icmplt -> 44201
/*      */     //   44196: goto_w -> 44229
/*      */     //   44201: aload_0
/*      */     //   44202: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   44205: new java/awt/Color
/*      */     //   44208: dup
/*      */     //   44209: sipush #200
/*      */     //   44212: sipush #200
/*      */     //   44215: sipush #200
/*      */     //   44218: invokespecial <init> : (III)V
/*      */     //   44221: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   44224: goto_w -> 44229
/*      */     //   44229: aload_0
/*      */     //   44230: getfield tab : I
/*      */     //   44233: iload #5
/*      */     //   44235: if_icmpeq -> 44243
/*      */     //   44238: goto_w -> 44271
/*      */     //   44243: aload_0
/*      */     //   44244: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   44247: new java/awt/Color
/*      */     //   44250: dup
/*      */     //   44251: sipush #225
/*      */     //   44254: sipush #225
/*      */     //   44257: sipush #225
/*      */     //   44260: invokespecial <init> : (III)V
/*      */     //   44263: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   44266: goto_w -> 44271
/*      */     //   44271: aload_0
/*      */     //   44272: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   44275: aload_2
/*      */     //   44276: aload_3
/*      */     //   44277: iconst_4
/*      */     //   44278: invokevirtual fillPolygon : ([I[II)V
/*      */     //   44281: aload_0
/*      */     //   44282: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   44285: new java/awt/Color
/*      */     //   44288: dup
/*      */     //   44289: iconst_0
/*      */     //   44290: iconst_0
/*      */     //   44291: iconst_0
/*      */     //   44292: invokespecial <init> : (III)V
/*      */     //   44295: invokevirtual setColor : (Ljava/awt/Color;)V
/*      */     //   44298: aload_0
/*      */     //   44299: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   44302: aload_1
/*      */     //   44303: iload #5
/*      */     //   44305: aaload
/*      */     //   44306: iload #5
/*      */     //   44308: bipush #100
/*      */     //   44310: imul
/*      */     //   44311: bipush #45
/*      */     //   44313: iadd
/*      */     //   44314: aload_0
/*      */     //   44315: getfield ftm : Ljava/awt/FontMetrics;
/*      */     //   44318: aload_1
/*      */     //   44319: iload #5
/*      */     //   44321: aaload
/*      */     //   44322: invokevirtual stringWidth : (Ljava/lang/String;)I
/*      */     //   44325: iconst_2
/*      */     //   44326: idiv
/*      */     //   44327: isub
/*      */     //   44328: bipush #17
/*      */     //   44330: invokevirtual drawString : (Ljava/lang/String;II)V
/*      */     //   44333: aload_0
/*      */     //   44334: getfield xm : I
/*      */     //   44337: aload_2
/*      */     //   44338: iconst_0
/*      */     //   44339: iaload
/*      */     //   44340: if_icmpgt -> 44348
/*      */     //   44343: goto_w -> 44413
/*      */     //   44348: aload_0
/*      */     //   44349: getfield xm : I
/*      */     //   44352: aload_2
/*      */     //   44353: iconst_3
/*      */     //   44354: iaload
/*      */     //   44355: if_icmplt -> 44363
/*      */     //   44358: goto_w -> 44413
/*      */     //   44363: aload_0
/*      */     //   44364: getfield ym : I
/*      */     //   44367: ifgt -> 44375
/*      */     //   44370: goto_w -> 44413
/*      */     //   44375: aload_0
/*      */     //   44376: getfield ym : I
/*      */     //   44379: bipush #25
/*      */     //   44381: if_icmplt -> 44389
/*      */     //   44384: goto_w -> 44413
/*      */     //   44389: aload_0
/*      */     //   44390: getfield mouses : I
/*      */     //   44393: iconst_m1
/*      */     //   44394: if_icmpeq -> 44402
/*      */     //   44397: goto_w -> 44413
/*      */     //   44402: aload_0
/*      */     //   44403: iload #5
/*      */     //   44405: putfield tab : I
/*      */     //   44408: goto_w -> 44413
/*      */     //   44413: iconst_0
/*      */     //   44414: istore #6
/*      */     //   44416: iload #6
/*      */     //   44418: iconst_4
/*      */     //   44419: if_icmplt -> 44427
/*      */     //   44422: goto_w -> 44444
/*      */     //   44427: aload_2
/*      */     //   44428: iload #6
/*      */     //   44430: dup2
/*      */     //   44431: iaload
/*      */     //   44432: bipush #100
/*      */     //   44434: iadd
/*      */     //   44435: iastore
/*      */     //   44436: iinc #6, 1
/*      */     //   44439: goto_w -> 44416
/*      */     //   44444: iinc #5, 1
/*      */     //   44447: goto_w -> 44110
/*      */     //   44452: aload_0
/*      */     //   44453: getfield mouses : I
/*      */     //   44456: iconst_m1
/*      */     //   44457: if_icmpeq -> 44465
/*      */     //   44460: goto_w -> 44475
/*      */     //   44465: aload_0
/*      */     //   44466: iconst_0
/*      */     //   44467: putfield mouses : I
/*      */     //   44470: goto_w -> 44475
/*      */     //   44475: aload_0
/*      */     //   44476: invokevirtual drawms : ()V
/*      */     //   44479: aload_0
/*      */     //   44480: invokevirtual repaint : ()V
/*      */     //   44483: aload_0
/*      */     //   44484: getfield exwist : Z
/*      */     //   44487: ifeq -> 44495
/*      */     //   44490: goto_w -> 44518
/*      */     //   44495: aload_0
/*      */     //   44496: getfield thredo : Ljava/lang/Thread;
/*      */     //   44499: pop
/*      */     //   44500: ldc2_w 40
/*      */     //   44503: invokestatic sleep : (J)V
/*      */     //   44506: goto_w -> 44518
/*      */     //   44511: astore #5
/*      */     //   44513: goto_w -> 44518
/*      */     //   44518: goto_w -> 549
/*      */     //   44523: aload_0
/*      */     //   44524: getfield track : LRadicalMod;
/*      */     //   44527: invokevirtual unload : ()V
/*      */     //   44530: aload_0
/*      */     //   44531: aconst_null
/*      */     //   44532: putfield track : LRadicalMod;
/*      */     //   44535: aload_0
/*      */     //   44536: getfield rd : Ljava/awt/Graphics2D;
/*      */     //   44539: invokevirtual dispose : ()V
/*      */     //   44542: invokestatic gc : ()V
/*      */     //   44545: getstatic Madness.endadv : I
/*      */     //   44548: iconst_2
/*      */     //   44549: if_icmpeq -> 44557
/*      */     //   44552: goto_w -> 44565
/*      */     //   44557: invokestatic advopen : ()V
/*      */     //   44560: goto_w -> 44565
/*      */     //   44565: return
/*      */     // Line number table:
/*      */     //   Java source line number -> byte code offset
/*      */     //   #330	-> 0
/*      */     //   #332	-> 9
/*      */     //   #333	-> 45
/*      */     //   #334	-> 81
/*      */     //   #336	-> 115
/*      */     //   #338	-> 127
/*      */     //   #339	-> 174
/*      */     //   #340	-> 221
/*      */     //   #341	-> 268
/*      */     //   #342	-> 315
/*      */     //   #343	-> 362
/*      */     //   #336	-> 409
/*      */     //   #346	-> 417
/*      */     //   #347	-> 421
/*      */     //   #349	-> 425
/*      */     //   #351	-> 436
/*      */     //   #352	-> 452
/*      */     //   #353	-> 462
/*      */     //   #355	-> 474
/*      */     //   #356	-> 481
/*      */     //   #357	-> 486
/*      */     //   #358	-> 491
/*      */     //   #360	-> 531
/*      */     //   #361	-> 536
/*      */     //   #364	-> 545
/*      */     //   #366	-> 549
/*      */     //   #368	-> 561
/*      */     //   #369	-> 584
/*      */     //   #370	-> 600
/*      */     //   #372	-> 617
/*      */     //   #374	-> 642
/*      */     //   #376	-> 654
/*      */     //   #378	-> 670
/*      */     //   #379	-> 677
/*      */     //   #380	-> 687
/*      */     //   #381	-> 701
/*      */     //   #382	-> 739
/*      */     //   #383	-> 825
/*      */     //   #384	-> 931
/*      */     //   #385	-> 936
/*      */     //   #386	-> 941
/*      */     //   #388	-> 946
/*      */     //   #389	-> 964
/*      */     //   #390	-> 1093
/*      */     //   #392	-> 1128
/*      */     //   #394	-> 1159
/*      */     //   #395	-> 1290
/*      */     //   #396	-> 1345
/*      */     //   #397	-> 1374
/*      */     //   #398	-> 1395
/*      */     //   #399	-> 1399
/*      */     //   #400	-> 1424
/*      */     //   #401	-> 1483
/*      */     //   #402	-> 1524
/*      */     //   #404	-> 1559
/*      */     //   #405	-> 1562
/*      */     //   #406	-> 1697
/*      */     //   #407	-> 1752
/*      */     //   #408	-> 1783
/*      */     //   #409	-> 1804
/*      */     //   #410	-> 1808
/*      */     //   #411	-> 1835
/*      */     //   #412	-> 1894
/*      */     //   #413	-> 1939
/*      */     //   #415	-> 1974
/*      */     //   #416	-> 1977
/*      */     //   #417	-> 1981
/*      */     //   #418	-> 1998
/*      */     //   #420	-> 2032
/*      */     //   #422	-> 2044
/*      */     //   #423	-> 2075
/*      */     //   #424	-> 2125
/*      */     //   #425	-> 2152
/*      */     //   #426	-> 2203
/*      */     //   #427	-> 2289
/*      */     //   #429	-> 2405
/*      */     //   #431	-> 2420
/*      */     //   #432	-> 2486
/*      */     //   #435	-> 2497
/*      */     //   #437	-> 2510
/*      */     //   #438	-> 2541
/*      */     //   #439	-> 2561
/*      */     //   #440	-> 2579
/*      */     //   #441	-> 2600
/*      */     //   #442	-> 2634
/*      */     //   #443	-> 2642
/*      */     //   #444	-> 2660
/*      */     //   #445	-> 2702
/*      */     //   #446	-> 2736
/*      */     //   #449	-> 2785
/*      */     //   #451	-> 2798
/*      */     //   #452	-> 2879
/*      */     //   #453	-> 2899
/*      */     //   #454	-> 2917
/*      */     //   #455	-> 2951
/*      */     //   #456	-> 2972
/*      */     //   #457	-> 2980
/*      */     //   #458	-> 3021
/*      */     //   #461	-> 3063
/*      */     //   #464	-> 3068
/*      */     //   #466	-> 3081
/*      */     //   #468	-> 3097
/*      */     //   #469	-> 3105
/*      */     //   #470	-> 3110
/*      */     //   #471	-> 3131
/*      */     //   #472	-> 3153
/*      */     //   #473	-> 3175
/*      */     //   #474	-> 3197
/*      */     //   #475	-> 3202
/*      */     //   #476	-> 3219
/*      */     //   #477	-> 3224
/*      */     //   #478	-> 3229
/*      */     //   #479	-> 3287
/*      */     //   #484	-> 3297
/*      */     //   #485	-> 3946
/*      */     //   #486	-> 4352
/*      */     //   #487	-> 4508
/*      */     //   #488	-> 4578
/*      */     //   #489	-> 4602
/*      */     //   #490	-> 4883
/*      */     //   #492	-> 5113
/*      */     //   #493	-> 5219
/*      */     //   #494	-> 5224
/*      */     //   #495	-> 5248
/*      */     //   #496	-> 5272
/*      */     //   #497	-> 5297
/*      */     //   #498	-> 5323
/*      */     //   #500	-> 5348
/*      */     //   #501	-> 5371
/*      */     //   #503	-> 5389
/*      */     //   #504	-> 5397
/*      */     //   #505	-> 5406
/*      */     //   #506	-> 5414
/*      */     //   #507	-> 5424
/*      */     //   #508	-> 5434
/*      */     //   #509	-> 5443
/*      */     //   #510	-> 5453
/*      */     //   #511	-> 5463
/*      */     //   #513	-> 5473
/*      */     //   #514	-> 5492
/*      */     //   #515	-> 5511
/*      */     //   #517	-> 5522
/*      */     //   #518	-> 5524
/*      */     //   #519	-> 5530
/*      */     //   #520	-> 5595
/*      */     //   #521	-> 5599
/*      */     //   #522	-> 5626
/*      */     //   #523	-> 5796
/*      */     //   #524	-> 5838
/*      */     //   #526	-> 5867
/*      */     //   #528	-> 5883
/*      */     //   #530	-> 5903
/*      */     //   #531	-> 6003
/*      */     //   #532	-> 6103
/*      */     //   #533	-> 6185
/*      */     //   #534	-> 6267
/*      */     //   #535	-> 6280
/*      */     //   #536	-> 6286
/*      */     //   #537	-> 6298
/*      */     //   #538	-> 6356
/*      */     //   #539	-> 6366
/*      */     //   #540	-> 6383
/*      */     //   #541	-> 6414
/*      */     //   #542	-> 6512
/*      */     //   #545	-> 6517
/*      */     //   #547	-> 6615
/*      */     //   #548	-> 6715
/*      */     //   #549	-> 6815
/*      */     //   #550	-> 6897
/*      */     //   #551	-> 6979
/*      */     //   #552	-> 6992
/*      */     //   #553	-> 6998
/*      */     //   #554	-> 7009
/*      */     //   #555	-> 7067
/*      */     //   #556	-> 7077
/*      */     //   #557	-> 7094
/*      */     //   #558	-> 7125
/*      */     //   #559	-> 7235
/*      */     //   #561	-> 7240
/*      */     //   #562	-> 7256
/*      */     //   #523	-> 7285
/*      */     //   #567	-> 7301
/*      */     //   #569	-> 7360
/*      */     //   #571	-> 7384
/*      */     //   #572	-> 7425
/*      */     //   #573	-> 7466
/*      */     //   #574	-> 7498
/*      */     //   #576	-> 7519
/*      */     //   #577	-> 7530
/*      */     //   #578	-> 7589
/*      */     //   #579	-> 7648
/*      */     //   #580	-> 7685
/*      */     //   #581	-> 7688
/*      */     //   #582	-> 7693
/*      */     //   #584	-> 7698
/*      */     //   #586	-> 7715
/*      */     //   #587	-> 7782
/*      */     //   #589	-> 7849
/*      */     //   #590	-> 7861
/*      */     //   #591	-> 7888
/*      */     //   #592	-> 7915
/*      */     //   #593	-> 7943
/*      */     //   #594	-> 7974
/*      */     //   #595	-> 8002
/*      */     //   #599	-> 8033
/*      */     //   #601	-> 8047
/*      */     //   #602	-> 8069
/*      */     //   #603	-> 8122
/*      */     //   #604	-> 8144
/*      */     //   #605	-> 8197
/*      */     //   #606	-> 8219
/*      */     //   #607	-> 8272
/*      */     //   #608	-> 8294
/*      */     //   #609	-> 8347
/*      */     //   #611	-> 8352
/*      */     //   #613	-> 8365
/*      */     //   #615	-> 8421
/*      */     //   #616	-> 8606
/*      */     //   #622	-> 8796
/*      */     //   #624	-> 8880
/*      */     //   #626	-> 8986
/*      */     //   #627	-> 9025
/*      */     //   #628	-> 9064
/*      */     //   #629	-> 9103
/*      */     //   #631	-> 9142
/*      */     //   #633	-> 9250
/*      */     //   #634	-> 9289
/*      */     //   #635	-> 9328
/*      */     //   #636	-> 9367
/*      */     //   #640	-> 9406
/*      */     //   #642	-> 9419
/*      */     //   #644	-> 9459
/*      */     //   #646	-> 9489
/*      */     //   #648	-> 9617
/*      */     //   #650	-> 9675
/*      */     //   #652	-> 9753
/*      */     //   #653	-> 9823
/*      */     //   #654	-> 9857
/*      */     //   #655	-> 9882
/*      */     //   #656	-> 9927
/*      */     //   #648	-> 9937
/*      */     //   #661	-> 9958
/*      */     //   #663	-> 10069
/*      */     //   #665	-> 10127
/*      */     //   #667	-> 10205
/*      */     //   #668	-> 10275
/*      */     //   #669	-> 10309
/*      */     //   #670	-> 10334
/*      */     //   #671	-> 10379
/*      */     //   #663	-> 10389
/*      */     //   #676	-> 10410
/*      */     //   #584	-> 10415
/*      */     //   #691	-> 10423
/*      */     //   #692	-> 10442
/*      */     //   #693	-> 10461
/*      */     //   #694	-> 10475
/*      */     //   #695	-> 10489
/*      */     //   #696	-> 10576
/*      */     //   #697	-> 10611
/*      */     //   #699	-> 10624
/*      */     //   #701	-> 10636
/*      */     //   #703	-> 10649
/*      */     //   #704	-> 10665
/*      */     //   #705	-> 10700
/*      */     //   #707	-> 10713
/*      */     //   #708	-> 10756
/*      */     //   #709	-> 10798
/*      */     //   #711	-> 10839
/*      */     //   #712	-> 10844
/*      */     //   #713	-> 10847
/*      */     //   #715	-> 10862
/*      */     //   #716	-> 11052
/*      */     //   #717	-> 11265
/*      */     //   #718	-> 11419
/*      */     //   #719	-> 11616
/*      */     //   #720	-> 11621
/*      */     //   #721	-> 11915
/*      */     //   #723	-> 12014
/*      */     //   #724	-> 12030
/*      */     //   #725	-> 12046
/*      */     //   #726	-> 12052
/*      */     //   #728	-> 12057
/*      */     //   #730	-> 12154
/*      */     //   #731	-> 12168
/*      */     //   #748	-> 12182
/*      */     //   #752	-> 12187
/*      */     //   #754	-> 12199
/*      */     //   #756	-> 12224
/*      */     //   #757	-> 12229
/*      */     //   #758	-> 12232
/*      */     //   #760	-> 12249
/*      */     //   #761	-> 12345
/*      */     //   #762	-> 12441
/*      */     //   #763	-> 12521
/*      */     //   #764	-> 12601
/*      */     //   #766	-> 12765
/*      */     //   #758	-> 12898
/*      */     //   #769	-> 12906
/*      */     //   #770	-> 13019
/*      */     //   #773	-> 13058
/*      */     //   #775	-> 13070
/*      */     //   #776	-> 13075
/*      */     //   #777	-> 13080
/*      */     //   #779	-> 13097
/*      */     //   #781	-> 13175
/*      */     //   #782	-> 13271
/*      */     //   #783	-> 13367
/*      */     //   #784	-> 13447
/*      */     //   #785	-> 13527
/*      */     //   #787	-> 13651
/*      */     //   #789	-> 13730
/*      */     //   #777	-> 13735
/*      */     //   #791	-> 13743
/*      */     //   #792	-> 13887
/*      */     //   #797	-> 13892
/*      */     //   #799	-> 13926
/*      */     //   #801	-> 13951
/*      */     //   #803	-> 13971
/*      */     //   #804	-> 13981
/*      */     //   #805	-> 13991
/*      */     //   #806	-> 14010
/*      */     //   #807	-> 14029
/*      */     //   #808	-> 14040
/*      */     //   #809	-> 14140
/*      */     //   #810	-> 14240
/*      */     //   #811	-> 14322
/*      */     //   #812	-> 14404
/*      */     //   #813	-> 14414
/*      */     //   #814	-> 14424
/*      */     //   #815	-> 14447
/*      */     //   #816	-> 14462
/*      */     //   #817	-> 14485
/*      */     //   #819	-> 14500
/*      */     //   #820	-> 14561
/*      */     //   #821	-> 14607
/*      */     //   #822	-> 14664
/*      */     //   #823	-> 14702
/*      */     //   #824	-> 14851
/*      */     //   #828	-> 14866
/*      */     //   #829	-> 14889
/*      */     //   #830	-> 14906
/*      */     //   #831	-> 14922
/*      */     //   #832	-> 14940
/*      */     //   #834	-> 14957
/*      */     //   #836	-> 14971
/*      */     //   #837	-> 14988
/*      */     //   #838	-> 15008
/*      */     //   #839	-> 15022
/*      */     //   #841	-> 15036
/*      */     //   #842	-> 15039
/*      */     //   #843	-> 15104
/*      */     //   #844	-> 15127
/*      */     //   #845	-> 15188
/*      */     //   #846	-> 15204
/*      */     //   #847	-> 15287
/*      */     //   #849	-> 15314
/*      */     //   #850	-> 15317
/*      */     //   #851	-> 15382
/*      */     //   #852	-> 15405
/*      */     //   #853	-> 15466
/*      */     //   #854	-> 15482
/*      */     //   #855	-> 15565
/*      */     //   #857	-> 15592
/*      */     //   #858	-> 15686
/*      */     //   #862	-> 15691
/*      */     //   #863	-> 15694
/*      */     //   #864	-> 15809
/*      */     //   #865	-> 15830
/*      */     //   #866	-> 15833
/*      */     //   #867	-> 15950
/*      */     //   #868	-> 15972
/*      */     //   #869	-> 15975
/*      */     //   #870	-> 16092
/*      */     //   #871	-> 16114
/*      */     //   #872	-> 16117
/*      */     //   #873	-> 16234
/*      */     //   #875	-> 16256
/*      */     //   #876	-> 16259
/*      */     //   #877	-> 16396
/*      */     //   #878	-> 16417
/*      */     //   #879	-> 16420
/*      */     //   #880	-> 16557
/*      */     //   #882	-> 16578
/*      */     //   #884	-> 16629
/*      */     //   #885	-> 16660
/*      */     //   #886	-> 16677
/*      */     //   #887	-> 16691
/*      */     //   #889	-> 16722
/*      */     //   #890	-> 16733
/*      */     //   #892	-> 16771
/*      */     //   #894	-> 16790
/*      */     //   #895	-> 16801
/*      */     //   #896	-> 16829
/*      */     //   #897	-> 16858
/*      */     //   #898	-> 16887
/*      */     //   #899	-> 16916
/*      */     //   #900	-> 16932
/*      */     //   #901	-> 16936
/*      */     //   #902	-> 16945
/*      */     //   #905	-> 16955
/*      */     //   #906	-> 16978
/*      */     //   #907	-> 17094
/*      */     //   #908	-> 17134
/*      */     //   #909	-> 17179
/*      */     //   #911	-> 17224
/*      */     //   #913	-> 17294
/*      */     //   #914	-> 17504
/*      */     //   #916	-> 17522
/*      */     //   #917	-> 17564
/*      */     //   #920	-> 17734
/*      */     //   #922	-> 18113
/*      */     //   #924	-> 18127
/*      */     //   #925	-> 18147
/*      */     //   #926	-> 18164
/*      */     //   #927	-> 18179
/*      */     //   #928	-> 18221
/*      */     //   #929	-> 18248
/*      */     //   #930	-> 18279
/*      */     //   #931	-> 18307
/*      */     //   #932	-> 18351
/*      */     //   #933	-> 18433
/*      */     //   #936	-> 18460
/*      */     //   #937	-> 18468
/*      */     //   #938	-> 18477
/*      */     //   #939	-> 18485
/*      */     //   #940	-> 18494
/*      */     //   #941	-> 18504
/*      */     //   #942	-> 18514
/*      */     //   #943	-> 18524
/*      */     //   #944	-> 18533
/*      */     //   #946	-> 18543
/*      */     //   #947	-> 18552
/*      */     //   #948	-> 18562
/*      */     //   #950	-> 18572
/*      */     //   #951	-> 18656
/*      */     //   #952	-> 18698
/*      */     //   #953	-> 18739
/*      */     //   #954	-> 18777
/*      */     //   #955	-> 18806
/*      */     //   #957	-> 18878
/*      */     //   #958	-> 18891
/*      */     //   #959	-> 18904
/*      */     //   #960	-> 18917
/*      */     //   #961	-> 18938
/*      */     //   #963	-> 18954
/*      */     //   #964	-> 18957
/*      */     //   #966	-> 18982
/*      */     //   #967	-> 19146
/*      */     //   #968	-> 19210
/*      */     //   #969	-> 19233
/*      */     //   #972	-> 19301
/*      */     //   #974	-> 19354
/*      */     //   #975	-> 19391
/*      */     //   #976	-> 19455
/*      */     //   #977	-> 19478
/*      */     //   #980	-> 19547
/*      */     //   #982	-> 19560
/*      */     //   #983	-> 19597
/*      */     //   #984	-> 19636
/*      */     //   #985	-> 19677
/*      */     //   #986	-> 19802
/*      */     //   #987	-> 19825
/*      */     //   #988	-> 19960
/*      */     //   #992	-> 19965
/*      */     //   #994	-> 19979
/*      */     //   #996	-> 20293
/*      */     //   #999	-> 20363
/*      */     //   #1000	-> 20502
/*      */     //   #1003	-> 20642
/*      */     //   #1004	-> 20720
/*      */     //   #1006	-> 20785
/*      */     //   #1008	-> 20825
/*      */     //   #1009	-> 20869
/*      */     //   #1011	-> 20892
/*      */     //   #1015	-> 20908
/*      */     //   #1016	-> 20949
/*      */     //   #1018	-> 20999
/*      */     //   #1019	-> 21030
/*      */     //   #1021	-> 21047
/*      */     //   #1022	-> 21053
/*      */     //   #1023	-> 21073
/*      */     //   #1024	-> 21116
/*      */     //   #1025	-> 21159
/*      */     //   #1027	-> 21210
/*      */     //   #1028	-> 21233
/*      */     //   #1029	-> 21299
/*      */     //   #1031	-> 21316
/*      */     //   #1032	-> 21419
/*      */     //   #1033	-> 21436
/*      */     //   #1034	-> 21454
/*      */     //   #1035	-> 21484
/*      */     //   #1036	-> 21517
/*      */     //   #1037	-> 21558
/*      */     //   #1038	-> 21580
/*      */     //   #1040	-> 21717
/*      */     //   #1042	-> 21729
/*      */     //   #1043	-> 21789
/*      */     //   #1044	-> 21865
/*      */     //   #1046	-> 21888
/*      */     //   #1048	-> 21893
/*      */     //   #1050	-> 21906
/*      */     //   #1052	-> 21922
/*      */     //   #1053	-> 21930
/*      */     //   #1054	-> 21935
/*      */     //   #1055	-> 21952
/*      */     //   #1056	-> 21957
/*      */     //   #1057	-> 21969
/*      */     //   #1058	-> 21989
/*      */     //   #1059	-> 21996
/*      */     //   #1062	-> 22006
/*      */     //   #1063	-> 22014
/*      */     //   #1064	-> 22023
/*      */     //   #1065	-> 22032
/*      */     //   #1066	-> 22042
/*      */     //   #1067	-> 22051
/*      */     //   #1068	-> 22061
/*      */     //   #1069	-> 22071
/*      */     //   #1071	-> 22081
/*      */     //   #1072	-> 22092
/*      */     //   #1073	-> 22103
/*      */     //   #1074	-> 22114
/*      */     //   #1076	-> 22125
/*      */     //   #1077	-> 22136
/*      */     //   #1078	-> 22138
/*      */     //   #1079	-> 22144
/*      */     //   #1080	-> 22209
/*      */     //   #1081	-> 22213
/*      */     //   #1082	-> 22240
/*      */     //   #1083	-> 22410
/*      */     //   #1086	-> 22542
/*      */     //   #1087	-> 22617
/*      */     //   #1088	-> 22692
/*      */     //   #1089	-> 22719
/*      */     //   #1091	-> 22746
/*      */     //   #1092	-> 22796
/*      */     //   #1094	-> 22846
/*      */     //   #1095	-> 22869
/*      */     //   #1096	-> 22884
/*      */     //   #1097	-> 22901
/*      */     //   #1098	-> 22917
/*      */     //   #1101	-> 22934
/*      */     //   #1102	-> 22965
/*      */     //   #1103	-> 23015
/*      */     //   #1104	-> 23040
/*      */     //   #1105	-> 23069
/*      */     //   #1107	-> 23084
/*      */     //   #1108	-> 23107
/*      */     //   #1109	-> 23197
/*      */     //   #1110	-> 23239
/*      */     //   #1111	-> 23268
/*      */     //   #1112	-> 23306
/*      */     //   #1113	-> 23405
/*      */     //   #1105	-> 23437
/*      */     //   #1116	-> 23445
/*      */     //   #1118	-> 23527
/*      */     //   #1120	-> 23539
/*      */     //   #1121	-> 23556
/*      */     //   #1122	-> 23571
/*      */     //   #1123	-> 23586
/*      */     //   #1126	-> 23606
/*      */     //   #1128	-> 23619
/*      */     //   #1130	-> 23635
/*      */     //   #1131	-> 23663
/*      */     //   #1132	-> 23691
/*      */     //   #1133	-> 23719
/*      */     //   #1134	-> 23781
/*      */     //   #1135	-> 23888
/*      */     //   #1136	-> 23894
/*      */     //   #1140	-> 23904
/*      */     //   #1142	-> 24011
/*      */     //   #1144	-> 24035
/*      */     //   #1146	-> 24049
/*      */     //   #1147	-> 24066
/*      */     //   #1149	-> 24105
/*      */     //   #1150	-> 24187
/*      */     //   #1151	-> 24270
/*      */     //   #1153	-> 24370
/*      */     //   #1155	-> 24384
/*      */     //   #1156	-> 24401
/*      */     //   #1157	-> 24417
/*      */     //   #1158	-> 24498
/*      */     //   #1160	-> 24530
/*      */     //   #1161	-> 24550
/*      */     //   #1162	-> 24574
/*      */     //   #1163	-> 24627
/*      */     //   #1164	-> 24680
/*      */     //   #1165	-> 24712
/*      */     //   #1167	-> 24765
/*      */     //   #1168	-> 24892
/*      */     //   #1170	-> 24911
/*      */     //   #1171	-> 24955
/*      */     //   #1172	-> 25133
/*      */     //   #1173	-> 25214
/*      */     //   #1153	-> 25286
/*      */     //   #1144	-> 25294
/*      */     //   #1179	-> 25302
/*      */     //   #1180	-> 25321
/*      */     //   #1182	-> 25348
/*      */     //   #1184	-> 25363
/*      */     //   #1185	-> 25377
/*      */     //   #1186	-> 25394
/*      */     //   #1187	-> 25412
/*      */     //   #1188	-> 25424
/*      */     //   #1191	-> 25488
/*      */     //   #1192	-> 25517
/*      */     //   #1193	-> 25539
/*      */     //   #1194	-> 25572
/*      */     //   #1195	-> 25601
/*      */     //   #1196	-> 25623
/*      */     //   #1197	-> 25656
/*      */     //   #1198	-> 25685
/*      */     //   #1199	-> 25707
/*      */     //   #1201	-> 25740
/*      */     //   #1202	-> 25815
/*      */     //   #1203	-> 25857
/*      */     //   #1207	-> 25862
/*      */     //   #1209	-> 25875
/*      */     //   #1211	-> 25891
/*      */     //   #1212	-> 25919
/*      */     //   #1213	-> 25947
/*      */     //   #1214	-> 25984
/*      */     //   #1215	-> 25989
/*      */     //   #1218	-> 26000
/*      */     //   #1220	-> 26119
/*      */     //   #1221	-> 26150
/*      */     //   #1222	-> 26167
/*      */     //   #1224	-> 26182
/*      */     //   #1225	-> 26252
/*      */     //   #1226	-> 26326
/*      */     //   #1228	-> 26410
/*      */     //   #1229	-> 26441
/*      */     //   #1230	-> 26458
/*      */     //   #1231	-> 26473
/*      */     //   #1232	-> 26490
/*      */     //   #1233	-> 26505
/*      */     //   #1234	-> 26520
/*      */     //   #1235	-> 26523
/*      */     //   #1236	-> 26528
/*      */     //   #1238	-> 26654
/*      */     //   #1239	-> 26671
/*      */     //   #1240	-> 26700
/*      */     //   #1241	-> 26719
/*      */     //   #1245	-> 26779
/*      */     //   #1246	-> 26810
/*      */     //   #1247	-> 26827
/*      */     //   #1249	-> 26843
/*      */     //   #1250	-> 26917
/*      */     //   #1252	-> 27004
/*      */     //   #1253	-> 27035
/*      */     //   #1254	-> 27052
/*      */     //   #1255	-> 27068
/*      */     //   #1256	-> 27085
/*      */     //   #1257	-> 27101
/*      */     //   #1258	-> 27117
/*      */     //   #1259	-> 27120
/*      */     //   #1260	-> 27125
/*      */     //   #1265	-> 27259
/*      */     //   #1267	-> 27273
/*      */     //   #1268	-> 27295
/*      */     //   #1270	-> 27310
/*      */     //   #1271	-> 27314
/*      */     //   #1272	-> 27333
/*      */     //   #1274	-> 27352
/*      */     //   #1275	-> 27369
/*      */     //   #1276	-> 27385
/*      */     //   #1277	-> 27435
/*      */     //   #1278	-> 27477
/*      */     //   #1279	-> 27497
/*      */     //   #1281	-> 27521
/*      */     //   #1282	-> 27586
/*      */     //   #1283	-> 27651
/*      */     //   #1284	-> 27689
/*      */     //   #1286	-> 27754
/*      */     //   #1287	-> 27893
/*      */     //   #1289	-> 27912
/*      */     //   #1290	-> 27941
/*      */     //   #1291	-> 28059
/*      */     //   #1292	-> 28160
/*      */     //   #1293	-> 28250
/*      */     //   #1268	-> 28322
/*      */     //   #1297	-> 28330
/*      */     //   #1298	-> 28347
/*      */     //   #1299	-> 28363
/*      */     //   #1300	-> 28391
/*      */     //   #1301	-> 28411
/*      */     //   #1303	-> 28435
/*      */     //   #1304	-> 28488
/*      */     //   #1305	-> 28541
/*      */     //   #1306	-> 28573
/*      */     //   #1307	-> 28626
/*      */     //   #1265	-> 28751
/*      */     //   #1310	-> 28759
/*      */     //   #1311	-> 28847
/*      */     //   #1313	-> 28946
/*      */     //   #1314	-> 28967
/*      */     //   #1315	-> 29031
/*      */     //   #1316	-> 29051
/*      */     //   #1317	-> 29148
/*      */     //   #1320	-> 29249
/*      */     //   #1321	-> 29278
/*      */     //   #1322	-> 29312
/*      */     //   #1324	-> 29345
/*      */     //   #1325	-> 29374
/*      */     //   #1326	-> 29402
/*      */     //   #1328	-> 29435
/*      */     //   #1329	-> 29455
/*      */     //   #1330	-> 29472
/*      */     //   #1331	-> 29488
/*      */     //   #1332	-> 29508
/*      */     //   #1333	-> 29524
/*      */     //   #1334	-> 29567
/*      */     //   #1336	-> 29594
/*      */     //   #1338	-> 29713
/*      */     //   #1340	-> 29761
/*      */     //   #1346	-> 29873
/*      */     //   #1347	-> 29948
/*      */     //   #1348	-> 29990
/*      */     //   #1352	-> 29995
/*      */     //   #1354	-> 30008
/*      */     //   #1356	-> 30024
/*      */     //   #1357	-> 30073
/*      */     //   #1358	-> 30098
/*      */     //   #1361	-> 30125
/*      */     //   #1362	-> 30142
/*      */     //   #1364	-> 30157
/*      */     //   #1365	-> 30180
/*      */     //   #1366	-> 30197
/*      */     //   #1367	-> 30216
/*      */     //   #1368	-> 30233
/*      */     //   #1369	-> 30252
/*      */     //   #1370	-> 30271
/*      */     //   #1371	-> 30289
/*      */     //   #1373	-> 30308
/*      */     //   #1374	-> 30332
/*      */     //   #1375	-> 30352
/*      */     //   #1376	-> 30356
/*      */     //   #1377	-> 30360
/*      */     //   #1379	-> 30374
/*      */     //   #1380	-> 30391
/*      */     //   #1381	-> 30444
/*      */     //   #1382	-> 30487
/*      */     //   #1383	-> 30571
/*      */     //   #1384	-> 30590
/*      */     //   #1385	-> 30609
/*      */     //   #1386	-> 30658
/*      */     //   #1387	-> 30679
/*      */     //   #1388	-> 30721
/*      */     //   #1389	-> 30795
/*      */     //   #1377	-> 30981
/*      */     //   #1392	-> 30989
/*      */     //   #1394	-> 31088
/*      */     //   #1395	-> 31137
/*      */     //   #1398	-> 31147
/*      */     //   #1399	-> 31164
/*      */     //   #1400	-> 31180
/*      */     //   #1402	-> 31282
/*      */     //   #1404	-> 31286
/*      */     //   #1405	-> 31303
/*      */     //   #1406	-> 31322
/*      */     //   #1408	-> 31345
/*      */     //   #1409	-> 31370
/*      */     //   #1410	-> 31395
/*      */     //   #1411	-> 31420
/*      */     //   #1412	-> 31445
/*      */     //   #1414	-> 31470
/*      */     //   #1415	-> 31488
/*      */     //   #1416	-> 31511
/*      */     //   #1417	-> 31526
/*      */     //   #1418	-> 31530
/*      */     //   #1420	-> 31538
/*      */     //   #1422	-> 31552
/*      */     //   #1423	-> 31569
/*      */     //   #1424	-> 31622
/*      */     //   #1425	-> 31665
/*      */     //   #1426	-> 31749
/*      */     //   #1427	-> 31768
/*      */     //   #1428	-> 31787
/*      */     //   #1429	-> 31836
/*      */     //   #1430	-> 31857
/*      */     //   #1431	-> 31899
/*      */     //   #1432	-> 31977
/*      */     //   #1420	-> 32058
/*      */     //   #1435	-> 32066
/*      */     //   #1436	-> 32091
/*      */     //   #1438	-> 32124
/*      */     //   #1439	-> 32158
/*      */     //   #1440	-> 32194
/*      */     //   #1443	-> 32199
/*      */     //   #1445	-> 32212
/*      */     //   #1446	-> 32285
/*      */     //   #1447	-> 32302
/*      */     //   #1448	-> 32318
/*      */     //   #1449	-> 32331
/*      */     //   #1450	-> 32358
/*      */     //   #1451	-> 32407
/*      */     //   #1452	-> 32441
/*      */     //   #1456	-> 32477
/*      */     //   #1458	-> 32490
/*      */     //   #1460	-> 32506
/*      */     //   #1461	-> 32513
/*      */     //   #1462	-> 32523
/*      */     //   #1463	-> 32537
/*      */     //   #1464	-> 32576
/*      */     //   #1465	-> 32672
/*      */     //   #1466	-> 32746
/*      */     //   #1467	-> 32751
/*      */     //   #1469	-> 32756
/*      */     //   #1470	-> 32803
/*      */     //   #1472	-> 32830
/*      */     //   #1474	-> 32861
/*      */     //   #1475	-> 32895
/*      */     //   #1477	-> 32929
/*      */     //   #1478	-> 33059
/*      */     //   #1479	-> 33076
/*      */     //   #1480	-> 33229
/*      */     //   #1481	-> 33258
/*      */     //   #1482	-> 33385
/*      */     //   #1483	-> 33402
/*      */     //   #1484	-> 33420
/*      */     //   #1485	-> 33441
/*      */     //   #1486	-> 33464
/*      */     //   #1487	-> 33487
/*      */     //   #1490	-> 33492
/*      */     //   #1492	-> 33507
/*      */     //   #1494	-> 33529
/*      */     //   #1495	-> 33671
/*      */     //   #1500	-> 33745
/*      */     //   #1502	-> 33760
/*      */     //   #1504	-> 33783
/*      */     //   #1505	-> 33925
/*      */     //   #1508	-> 34163
/*      */     //   #1511	-> 34243
/*      */     //   #1513	-> 34266
/*      */     //   #1531	-> 34285
/*      */     //   #1532	-> 34288
/*      */     //   #1534	-> 34307
/*      */     //   #1535	-> 34315
/*      */     //   #1536	-> 34321
/*      */     //   #1537	-> 34327
/*      */     //   #1538	-> 34402
/*      */     //   #1543	-> 34412
/*      */     //   #1545	-> 34478
/*      */     //   #1546	-> 34538
/*      */     //   #1547	-> 34595
/*      */     //   #1548	-> 34606
/*      */     //   #1549	-> 34624
/*      */     //   #1550	-> 34661
/*      */     //   #1551	-> 34671
/*      */     //   #1552	-> 34678
/*      */     //   #1554	-> 34685
/*      */     //   #1555	-> 34718
/*      */     //   #1556	-> 34723
/*      */     //   #1557	-> 34728
/*      */     //   #1558	-> 34733
/*      */     //   #1559	-> 34783
/*      */     //   #1560	-> 34826
/*      */     //   #1563	-> 34831
/*      */     //   #1565	-> 34852
/*      */     //   #1566	-> 34912
/*      */     //   #1567	-> 34961
/*      */     //   #1568	-> 34972
/*      */     //   #1569	-> 34983
/*      */     //   #1571	-> 34990
/*      */     //   #1572	-> 35023
/*      */     //   #1573	-> 35028
/*      */     //   #1574	-> 35033
/*      */     //   #1577	-> 35049
/*      */     //   #1578	-> 35056
/*      */     //   #1579	-> 35070
/*      */     //   #1580	-> 35109
/*      */     //   #1581	-> 35205
/*      */     //   #1584	-> 35231
/*      */     //   #1586	-> 35272
/*      */     //   #1589	-> 35277
/*      */     //   #1590	-> 35282
/*      */     //   #1591	-> 35299
/*      */     //   #1592	-> 35318
/*      */     //   #1593	-> 35383
/*      */     //   #1595	-> 35410
/*      */     //   #1596	-> 35433
/*      */     //   #1597	-> 35458
/*      */     //   #1598	-> 35483
/*      */     //   #1599	-> 35508
/*      */     //   #1600	-> 35533
/*      */     //   #1602	-> 35558
/*      */     //   #1603	-> 35598
/*      */     //   #1604	-> 35634
/*      */     //   #1607	-> 35639
/*      */     //   #1609	-> 35653
/*      */     //   #1610	-> 35670
/*      */     //   #1611	-> 35701
/*      */     //   #1612	-> 35730
/*      */     //   #1613	-> 35743
/*      */     //   #1614	-> 35770
/*      */     //   #1616	-> 35793
/*      */     //   #1617	-> 35797
/*      */     //   #1618	-> 35802
/*      */     //   #1619	-> 35807
/*      */     //   #1621	-> 35834
/*      */     //   #1623	-> 35846
/*      */     //   #1624	-> 35873
/*      */     //   #1629	-> 35922
/*      */     //   #1630	-> 35975
/*      */     //   #1633	-> 35980
/*      */     //   #1635	-> 35993
/*      */     //   #1636	-> 36013
/*      */     //   #1637	-> 36030
/*      */     //   #1638	-> 36070
/*      */     //   #1639	-> 36084
/*      */     //   #1640	-> 36096
/*      */     //   #1641	-> 36131
/*      */     //   #1642	-> 36151
/*      */     //   #1643	-> 36178
/*      */     //   #1645	-> 36193
/*      */     //   #1646	-> 36195
/*      */     //   #1647	-> 36249
/*      */     //   #1648	-> 36268
/*      */     //   #1649	-> 36273
/*      */     //   #1650	-> 36290
/*      */     //   #1651	-> 36310
/*      */     //   #1652	-> 36360
/*      */     //   #1653	-> 36411
/*      */     //   #1655	-> 36462
/*      */     //   #1656	-> 36493
/*      */     //   #1657	-> 36522
/*      */     //   #1658	-> 36551
/*      */     //   #1659	-> 36580
/*      */     //   #1660	-> 36609
/*      */     //   #1661	-> 36638
/*      */     //   #1662	-> 36657
/*      */     //   #1663	-> 36676
/*      */     //   #1664	-> 36695
/*      */     //   #1665	-> 36714
/*      */     //   #1667	-> 36732
/*      */     //   #1670	-> 36753
/*      */     //   #1671	-> 36781
/*      */     //   #1673	-> 36807
/*      */     //   #1674	-> 36811
/*      */     //   #1675	-> 36816
/*      */     //   #1676	-> 36821
/*      */     //   #1677	-> 36848
/*      */     //   #1678	-> 36879
/*      */     //   #1679	-> 36912
/*      */     //   #1681	-> 36924
/*      */     //   #1682	-> 36926
/*      */     //   #1683	-> 37019
/*      */     //   #1685	-> 37028
/*      */     //   #1686	-> 37040
/*      */     //   #1688	-> 37071
/*      */     //   #1689	-> 37112
/*      */     //   #1690	-> 37158
/*      */     //   #1691	-> 37162
/*      */     //   #1692	-> 37170
/*      */     //   #1695	-> 37172
/*      */     //   #1696	-> 37186
/*      */     //   #1697	-> 37206
/*      */     //   #1698	-> 37220
/*      */     //   #1700	-> 37223
/*      */     //   #1701	-> 37305
/*      */     //   #1702	-> 37312
/*      */     //   #1703	-> 37335
/*      */     //   #1705	-> 37344
/*      */     //   #1706	-> 37349
/*      */     //   #1707	-> 37391
/*      */     //   #1708	-> 37412
/*      */     //   #1709	-> 37415
/*      */     //   #1711	-> 37431
/*      */     //   #1712	-> 37438
/*      */     //   #1714	-> 37445
/*      */     //   #1715	-> 37486
/*      */     //   #1716	-> 37530
/*      */     //   #1718	-> 37585
/*      */     //   #1719	-> 37589
/*      */     //   #1721	-> 37612
/*      */     //   #1723	-> 37620
/*      */     //   #1724	-> 37661
/*      */     //   #1725	-> 37707
/*      */     //   #1726	-> 37736
/*      */     //   #1728	-> 37740
/*      */     //   #1729	-> 37747
/*      */     //   #1731	-> 37772
/*      */     //   #1733	-> 37781
/*      */     //   #1734	-> 37822
/*      */     //   #1735	-> 37868
/*      */     //   #1736	-> 37897
/*      */     //   #1737	-> 37901
/*      */     //   #1738	-> 37950
/*      */     //   #1740	-> 37980
/*      */     //   #1741	-> 37988
/*      */     //   #1742	-> 38033
/*      */     //   #1743	-> 38040
/*      */     //   #1744	-> 38066
/*      */     //   #1746	-> 38075
/*      */     //   #1747	-> 38086
/*      */     //   #1748	-> 38105
/*      */     //   #1749	-> 38118
/*      */     //   #1750	-> 38128
/*      */     //   #1751	-> 38135
/*      */     //   #1752	-> 38161
/*      */     //   #1753	-> 38166
/*      */     //   #1754	-> 38184
/*      */     //   #1755	-> 38204
/*      */     //   #1757	-> 38209
/*      */     //   #1759	-> 38214
/*      */     //   #1761	-> 38218
/*      */     //   #1762	-> 38226
/*      */     //   #1764	-> 38238
/*      */     //   #1765	-> 38240
/*      */     //   #1766	-> 38261
/*      */     //   #1767	-> 38318
/*      */     //   #1768	-> 38385
/*      */     //   #1769	-> 38413
/*      */     //   #1770	-> 38441
/*      */     //   #1771	-> 38475
/*      */     //   #1772	-> 38509
/*      */     //   #1773	-> 38543
/*      */     //   #1775	-> 38568
/*      */     //   #1776	-> 38573
/*      */     //   #1782	-> 38627
/*      */     //   #1784	-> 38640
/*      */     //   #1786	-> 38655
/*      */     //   #1787	-> 38678
/*      */     //   #1788	-> 38775
/*      */     //   #1790	-> 38797
/*      */     //   #1791	-> 38828
/*      */     //   #1792	-> 38845
/*      */     //   #1793	-> 38885
/*      */     //   #1794	-> 38908
/*      */     //   #1796	-> 38937
/*      */     //   #1798	-> 38952
/*      */     //   #1799	-> 38981
/*      */     //   #1800	-> 39010
/*      */     //   #1802	-> 39039
/*      */     //   #1803	-> 39041
/*      */     //   #1805	-> 39188
/*      */     //   #1807	-> 39203
/*      */     //   #1808	-> 39553
/*      */     //   #1810	-> 39605
/*      */     //   #1811	-> 39676
/*      */     //   #1812	-> 39748
/*      */     //   #1814	-> 39820
/*      */     //   #1816	-> 39844
/*      */     //   #1818	-> 39870
/*      */     //   #1819	-> 39872
/*      */     //   #1821	-> 39892
/*      */     //   #1819	-> 39963
/*      */     //   #1823	-> 39971
/*      */     //   #1825	-> 39980
/*      */     //   #1826	-> 39992
/*      */     //   #1827	-> 40023
/*      */     //   #1828	-> 40064
/*      */     //   #1829	-> 40110
/*      */     //   #1831	-> 40114
/*      */     //   #1832	-> 40174
/*      */     //   #1835	-> 40185
/*      */     //   #1836	-> 40195
/*      */     //   #1837	-> 40209
/*      */     //   #1838	-> 40227
/*      */     //   #1840	-> 40268
/*      */     //   #1844	-> 40291
/*      */     //   #1845	-> 40365
/*      */     //   #1848	-> 40383
/*      */     //   #1849	-> 40390
/*      */     //   #1851	-> 40400
/*      */     //   #1853	-> 40404
/*      */     //   #1854	-> 40417
/*      */     //   #1855	-> 40423
/*      */     //   #1857	-> 40426
/*      */     //   #1858	-> 40468
/*      */     //   #1859	-> 40502
/*      */     //   #1860	-> 40506
/*      */     //   #1861	-> 40520
/*      */     //   #1863	-> 40546
/*      */     //   #1864	-> 40564
/*      */     //   #1865	-> 40582
/*      */     //   #1866	-> 40682
/*      */     //   #1867	-> 40715
/*      */     //   #1868	-> 40720
/*      */     //   #1869	-> 40727
/*      */     //   #1871	-> 40750
/*      */     //   #1872	-> 40810
/*      */     //   #1873	-> 40861
/*      */     //   #1874	-> 40879
/*      */     //   #1875	-> 40886
/*      */     //   #1876	-> 40891
/*      */     //   #1877	-> 40894
/*      */     //   #1879	-> 40899
/*      */     //   #1882	-> 40914
/*      */     //   #1883	-> 40964
/*      */     //   #1884	-> 41004
/*      */     //   #1885	-> 41015
/*      */     //   #1886	-> 41025
/*      */     //   #1887	-> 41072
/*      */     //   #1888	-> 41150
/*      */     //   #1890	-> 41159
/*      */     //   #1891	-> 41173
/*      */     //   #1892	-> 41191
/*      */     //   #1893	-> 41202
/*      */     //   #1894	-> 41209
/*      */     //   #1895	-> 41214
/*      */     //   #1896	-> 41217
/*      */     //   #1897	-> 41222
/*      */     //   #1900	-> 41234
/*      */     //   #1901	-> 41246
/*      */     //   #1902	-> 41284
/*      */     //   #1904	-> 41300
/*      */     //   #1906	-> 41323
/*      */     //   #1909	-> 41328
/*      */     //   #1910	-> 41333
/*      */     //   #1912	-> 41367
/*      */     //   #1914	-> 41393
/*      */     //   #1916	-> 41440
/*      */     //   #1917	-> 41452
/*      */     //   #1920	-> 41454
/*      */     //   #1921	-> 41468
/*      */     //   #1922	-> 41488
/*      */     //   #1923	-> 41502
/*      */     //   #1924	-> 41570
/*      */     //   #1925	-> 41577
/*      */     //   #1926	-> 41600
/*      */     //   #1928	-> 41604
/*      */     //   #1929	-> 41612
/*      */     //   #1930	-> 41682
/*      */     //   #1784	-> 41687
/*      */     //   #1937	-> 41700
/*      */     //   #1939	-> 41713
/*      */     //   #1940	-> 41729
/*      */     //   #1941	-> 41760
/*      */     //   #1942	-> 41783
/*      */     //   #1943	-> 41801
/*      */     //   #1944	-> 41818
/*      */     //   #1945	-> 41909
/*      */     //   #1946	-> 41913
/*      */     //   #1947	-> 41925
/*      */     //   #1948	-> 41935
/*      */     //   #1949	-> 41945
/*      */     //   #1952	-> 41948
/*      */     //   #1953	-> 42008
/*      */     //   #1954	-> 42017
/*      */     //   #1955	-> 42030
/*      */     //   #1957	-> 42045
/*      */     //   #1958	-> 42068
/*      */     //   #1960	-> 42083
/*      */     //   #1961	-> 42101
/*      */     //   #1962	-> 42119
/*      */     //   #1963	-> 42228
/*      */     //   #1965	-> 42233
/*      */     //   #1966	-> 42268
/*      */     //   #1967	-> 42302
/*      */     //   #1968	-> 42308
/*      */     //   #1969	-> 42320
/*      */     //   #1970	-> 42325
/*      */     //   #1973	-> 42330
/*      */     //   #1975	-> 42343
/*      */     //   #1976	-> 42391
/*      */     //   #1977	-> 42420
/*      */     //   #1982	-> 42506
/*      */     //   #1984	-> 42519
/*      */     //   #1985	-> 42560
/*      */     //   #1986	-> 42591
/*      */     //   #1987	-> 42608
/*      */     //   #1988	-> 42637
/*      */     //   #1989	-> 42641
/*      */     //   #1990	-> 42648
/*      */     //   #1991	-> 42662
/*      */     //   #1992	-> 42667
/*      */     //   #1993	-> 42672
/*      */     //   #1994	-> 42674
/*      */     //   #1997	-> 42677
/*      */     //   #1998	-> 42733
/*      */     //   #1999	-> 42746
/*      */     //   #2000	-> 42784
/*      */     //   #2002	-> 42884
/*      */     //   #2003	-> 42901
/*      */     //   #2004	-> 42906
/*      */     //   #2005	-> 42988
/*      */     //   #2006	-> 43027
/*      */     //   #2008	-> 43032
/*      */     //   #2012	-> 43044
/*      */     //   #2013	-> 43075
/*      */     //   #2014	-> 43104
/*      */     //   #2015	-> 43134
/*      */     //   #2016	-> 43161
/*      */     //   #2017	-> 43180
/*      */     //   #2018	-> 43210
/*      */     //   #2019	-> 43237
/*      */     //   #2020	-> 43256
/*      */     //   #2022	-> 43279
/*      */     //   #2023	-> 43291
/*      */     //   #2025	-> 43293
/*      */     //   #2026	-> 43307
/*      */     //   #2027	-> 43326
/*      */     //   #2028	-> 43340
/*      */     //   #2029	-> 43396
/*      */     //   #2030	-> 43402
/*      */     //   #2031	-> 43425
/*      */     //   #2033	-> 43429
/*      */     //   #2034	-> 43437
/*      */     //   #2035	-> 43495
/*      */     //   #2036	-> 43543
/*      */     //   #2037	-> 43583
/*      */     //   #2038	-> 43621
/*      */     //   #2039	-> 43626
/*      */     //   #2041	-> 43657
/*      */     //   #2045	-> 43686
/*      */     //   #2046	-> 43720
/*      */     //   #2050	-> 43754
/*      */     //   #2051	-> 43785
/*      */     //   #2057	-> 43819
/*      */     //   #2060	-> 43872
/*      */     //   #2061	-> 43889
/*      */     //   #2062	-> 43903
/*      */     //   #2064	-> 43958
/*      */     //   #2066	-> 43989
/*      */     //   #2067	-> 44018
/*      */     //   #2068	-> 44040
/*      */     //   #2070	-> 44062
/*      */     //   #2071	-> 44065
/*      */     //   #2073	-> 44107
/*      */     //   #2075	-> 44122
/*      */     //   #2076	-> 44145
/*      */     //   #2077	-> 44229
/*      */     //   #2079	-> 44271
/*      */     //   #2080	-> 44281
/*      */     //   #2081	-> 44298
/*      */     //   #2082	-> 44333
/*      */     //   #2083	-> 44413
/*      */     //   #2073	-> 44444
/*      */     //   #2086	-> 44452
/*      */     //   #2087	-> 44475
/*      */     //   #2088	-> 44479
/*      */     //   #2089	-> 44483
/*      */     //   #2090	-> 44518
/*      */     //   #2092	-> 44523
/*      */     //   #2093	-> 44530
/*      */     //   #2094	-> 44535
/*      */     //   #2095	-> 44542
/*      */     //   #2096	-> 44545
/*      */     //   #2097	-> 44565
/*      */     // Exception table:
/*      */     //   from	to	target	type
/*      */     //   10904	11035	11040	java/lang/Exception
/*      */     //   11279	11402	11407	java/lang/Exception
/*      */     //   18351	18405	18410	java/lang/Exception
/*      */     //   29761	29824	29829	java/lang/Exception
/*      */     //   33971	34100	34105	java/lang/Exception
/*      */     //   34327	34395	34400	java/lang/Exception
/*      */     //   34412	35231	35236	java/lang/Exception
/*      */     //   37172	38218	38223	java/lang/Exception
/*      */     //   37589	37600	37605	java/lang/InterruptedException
/*      */     //   40114	41300	41305	java/lang/Exception
/*      */     //   40914	41222	41227	java/lang/Exception
/*      */     //   41454	41604	41609	java/lang/Exception
/*      */     //   41948	42302	42307	java/lang/Exception
/*      */     //   42677	42906	42911	java/lang/Exception
/*      */     //   43293	43429	43434	java/lang/Exception
/*      */     //   44495	44506	44511	java/lang/InterruptedException
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removesp() {
/* 2102 */     if (this.nundo < 5000) { this.undos[this.nundo] = this.bstage; this.nundo++; }
/*      */     
/* 2104 */     String str = "";
/* 2105 */     if ((this.co[this.esp]).colok != 30 && (this.co[this.esp]).colok != 31 && (this.co[this.esp]).colok != 32 && (this.co[this.esp]).colok != 66) str = "set(" + ((this.co[this.esp]).colok + 10) + "," + (this.co[this.esp]).x + "," + (this.co[this.esp]).z + "," + (this.co[this.esp]).roofat + ")"; 
/* 2106 */     if ((this.co[this.esp]).colok == 31) str = "fix(" + ((this.co[this.esp]).colok + 10) + "," + (this.co[this.esp]).x + "," + (this.co[this.esp]).z + "," + (this.co[this.esp]).y + "," + (this.co[this.esp]).roofat + ")"; 
/* 2107 */     if ((this.co[this.esp]).colok == 30 || (this.co[this.esp]).colok == 32) str = "chk(" + ((this.co[this.esp]).colok + 10) + "," + (this.co[this.esp]).x + "," + (this.co[this.esp]).z + "," + (this.co[this.esp]).roofat + ")"; 
/* 2108 */     if ((this.co[this.esp]).colok == 54) str = "chk(" + ((this.co[this.esp]).colok + 10) + "," + (this.co[this.esp]).x + "," + (this.co[this.esp]).z + "," + (this.co[this.esp]).roofat + "," + (this.co[this.esp]).y + ")"; 
/* 2109 */     if ((this.co[this.esp]).colok == 66) str = "pile(" + (this.co[this.esp]).srz + "," + (this.co[this.esp]).srx + "," + (this.co[this.esp]).sry + "," + (this.co[this.esp]).x + "," + (this.co[this.esp]).z + ")";
/*      */     
/* 2111 */     int i = this.bstage.indexOf(str);
/* 2112 */     int j = i + str.length();
/* 2113 */     int k = -1;
/* 2114 */     int m = this.bstage.indexOf("set", j); if (m != -1) k = m; 
/* 2115 */     m = this.bstage.indexOf("chk", j); if (m != -1 && m < k) k = m; 
/* 2116 */     m = this.bstage.indexOf("fix", j); if (m != -1 && m < k) k = m; 
/* 2117 */     if (k == -1) { k = this.bstage.indexOf("\r\n", j); if (k != -1) k++;  }
/* 2118 */      if (k != -1) j = k;
/*      */     
/* 2120 */     if (i != -1) this.bstage = "" + this.bstage.substring(0, i) + "" + this.bstage.substring(j, this.bstage.length()) + ""; 
/* 2121 */     readstage(0);
/*      */   }
/*      */ 
/*      */   
/*      */   public void copyesp(boolean paramBoolean) {
/* 2126 */     this.sp = (this.co[this.esp]).colok;
/* 2127 */     this.rot = (this.co[this.esp]).roofat;
/* 2128 */     if (this.sp == 2) this.rot -= 30; 
/* 2129 */     if (this.sp == 3) this.rot += 30; 
/* 2130 */     if (this.sp == 15) this.rot += 90; 
/* 2131 */     if (this.sp == 20) this.rot += 180; 
/* 2132 */     if (this.sp == 26) this.rot -= 90;
/*      */ 
/*      */ 
/*      */     
/* 2136 */     if (this.sp == 0) { this.sptyp = 0; this.spart = 0; }
/* 2137 */      if (this.sp == 4) { this.sptyp = 0; this.spart = 1; }
/* 2138 */      if (this.sp == 13) { this.sptyp = 0; this.spart = 2; }
/* 2139 */      if (this.sp == 3) { this.sptyp = 0; this.spart = 3; }
/* 2140 */      if (this.sp == 2) { this.sptyp = 0; this.spart = 4; }
/* 2141 */      if (this.sp == 1) { this.sptyp = 0; this.spart = 5; }
/* 2142 */      if (this.sp == 35) { this.sptyp = 0; this.spart = 6; }
/* 2143 */      if (this.sp == 36) { this.sptyp = 0; this.spart = 7; }
/* 2144 */      if (this.sp == 10) { this.sptyp = 0; this.spart = 8; }
/* 2145 */      if (this.sp == 5) { this.sptyp = 0; this.spart = 9; }
/* 2146 */      if (this.sp == 7) { this.sptyp = 0; this.spart = 10; }
/* 2147 */      if (this.sp == 14) { this.sptyp = 0; this.spart = 11; }
/* 2148 */      if (this.sp == 6) { this.sptyp = 0; this.spart = 12; }
/* 2149 */      if (this.sp == 34) { this.sptyp = 0; this.spart = 13; }
/* 2150 */      if (this.sp == 33) { this.sptyp = 0; this.spart = 14; }
/* 2151 */      if (this.sp == 11) { this.sptyp = 0; this.spart = 15; }
/* 2152 */      if (this.sp == 8) { this.sptyp = 0; this.spart = 16; }
/* 2153 */      if (this.sp == 9) { this.sptyp = 0; this.spart = 17; }
/* 2154 */      if (this.sp == 15) { this.sptyp = 0; this.spart = 18; }
/* 2155 */      if (this.sp == 12) { this.sptyp = 0; this.spart = 19; }
/* 2156 */      if (this.sp == 46) { this.sptyp = 0; this.spart = 20; }
/* 2157 */      if (this.sp == 47) { this.sptyp = 0; this.spart = 21; }
/* 2158 */      if (this.sp == 48) { this.sptyp = 0; this.spart = 23; }
/* 2159 */      if (this.sp == 49) { this.sptyp = 0; this.spart = 24; }
/* 2160 */      if (this.sp == 50) { this.sptyp = 0; this.spart = 22; }
/* 2161 */      if (this.sp == 51) { this.sptyp = 0; this.spart = 25; }
/*      */ 
/*      */     
/* 2164 */     if (this.sp == 16) { this.sptyp = 1; this.spart = 0; }
/* 2165 */      if (this.sp == 18) { this.sptyp = 1; this.spart = 1; }
/* 2166 */      if (this.sp == 19) { this.sptyp = 1; this.spart = 2; }
/* 2167 */      if (this.sp == 22) { this.sptyp = 1; this.spart = 3; }
/* 2168 */      if (this.sp == 17) { this.sptyp = 1; this.spart = 4; }
/* 2169 */      if (this.sp == 21) { this.sptyp = 1; this.spart = 5; }
/* 2170 */      if (this.sp == 20) { this.sptyp = 1; this.spart = 6; }
/* 2171 */      if (this.sp == 39) { this.sptyp = 1; this.spart = 7; }
/* 2172 */      if (this.sp == 42) { this.sptyp = 1; this.spart = 8; }
/* 2173 */      if (this.sp == 40) { this.sptyp = 1; this.spart = 9; }
/* 2174 */      if (this.sp == 23) { this.sptyp = 1; this.spart = 10; }
/* 2175 */      if (this.sp == 25) { this.sptyp = 1; this.spart = 11; }
/* 2176 */      if (this.sp == 24) { this.sptyp = 1; this.spart = 12; }
/* 2177 */      if (this.sp == 43) { this.sptyp = 1; this.spart = 13; }
/* 2178 */      if (this.sp == 45) { this.sptyp = 1; this.spart = 14; }
/* 2179 */      if (this.sp == 26) { this.sptyp = 1; this.spart = 15; }
/*      */ 
/*      */     
/* 2182 */     if (this.sp == 27) { this.sptyp = 2; this.spart = 0; }
/* 2183 */      if (this.sp == 28) { this.sptyp = 2; this.spart = 1; }
/* 2184 */      if (this.sp == 41) { this.sptyp = 2; this.spart = 2; }
/* 2185 */      if (this.sp == 44) { this.sptyp = 2; this.spart = 3; }
/* 2186 */      if (this.sp == 52) { this.sptyp = 2; this.spart = 4; }
/* 2187 */      if (this.sp == 53) { this.sptyp = 2; this.spart = 5; }
/*      */ 
/*      */     
/* 2190 */     if (this.sp == 30 || this.sp == 32 || this.sp == 54) { this.sptyp = 3; this.spart = 0; }
/* 2191 */      if (this.sp == 31) { this.sptyp = 4; this.spart = 0; }
/*      */     
/* 2193 */     if (this.sp == 55) { this.sptyp = 5; this.spart = 0; }
/* 2194 */      if (this.sp == 56) { this.sptyp = 5; this.spart = 1; }
/* 2195 */      if (this.sp == 57) { this.sptyp = 5; this.spart = 2; }
/* 2196 */      if (this.sp == 58) { this.sptyp = 5; this.spart = 3; }
/* 2197 */      if (this.sp == 59) { this.sptyp = 5; this.spart = 4; }
/* 2198 */      if (this.sp == 60) { this.sptyp = 5; this.spart = 5; }
/* 2199 */      if (this.sp == 61) { this.sptyp = 5; this.spart = 6; }
/*      */     
/* 2201 */     if (this.sp == 62) { this.sptyp = 5; this.spart = 7; }
/* 2202 */      if (this.sp == 63) { this.sptyp = 5; this.spart = 8; }
/* 2203 */      if (this.sp == 64) { this.sptyp = 5; this.spart = 9; }
/* 2204 */      if (this.sp == 65) { this.sptyp = 5; this.spart = 10; }
/*      */     
/* 2206 */     if (this.sp == 66) { if (paramBoolean) { this.fgen = (this.co[this.esp]).srz; } else { this.fgen = 0; }  this.pwd = (this.co[this.esp]).srx; this.phd = (this.co[this.esp]).sry; this.pgen = false; this.sptyp = 6; }
/*      */     
/* 2208 */     if (this.sptyp == 0) { partroads(); this.part.show(); }
/* 2209 */      if (this.sptyp == 1) { partramps(); this.part.show(); }
/* 2210 */      if (this.sptyp == 2) { partobst(); this.part.show(); }
/* 2211 */      if (this.sptyp == 5) { partrees(); this.part.show(); }
/*      */     
/* 2213 */     this.ptyp.select(this.sptyp);
/* 2214 */     this.part.select(this.spart);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void partrees() {
/* 2220 */     this.part.removeAll();
/* 2221 */     this.part.add(this.rd, "Tree 1"); this.part.add(this.rd, "Tree 2"); this.part.add(this.rd, "Tree 3"); this.part.add(this.rd, "Tree 4"); this.part.add(this.rd, "Tree 5");
/* 2222 */     this.part.add(this.rd, "Palm Tree 1"); this.part.add(this.rd, "Palm Tree 2"); this.part.add(this.rd, "Palm Tree 3");
/* 2223 */     this.part.add(this.rd, "Cactus 1"); this.part.add(this.rd, "Cactus 2"); this.part.add(this.rd, "Cactus 3");
/*      */   }
/*      */ 
/*      */   
/*      */   public void partroads() {
/* 2228 */     this.part.removeAll();
/* 2229 */     this.part.add(this.rd, "NormalRoad"); this.part.add(this.rd, "NormalRoad Turn"); this.part.add(this.rd, "NormalRoad End"); this.part.add(this.rd, "NormalRoad TwistedLeft"); this.part.add(this.rd, "NormalRoad TwistedRight"); this.part.add(this.rd, "NormalRoad Edged"); this.part.add(this.rd, "NormalRoad-Raised Ramp"); this.part.add(this.rd, "NormalRoad Raised"); this.part.add(this.rd, "Normal-Off-Road Blend"); this.part.add(this.rd, "OffRoad"); this.part.add(this.rd, "OffRoad Turn"); this.part.add(this.rd, "OffRoad End"); this.part.add(this.rd, "OffRoad BumpyGreen"); this.part.add(this.rd, "OffRoad-BumpySides Start"); this.part.add(this.rd, "OffRoad BumpySides"); this.part.add(this.rd, "Off-Halfpipe-Road Blend"); this.part.add(this.rd, "HalfpipeRoad"); this.part.add(this.rd, "HalfpipeRoad Turn"); this.part.add(this.rd, "HalfpipeRoad-Ramp Filler"); this.part.add(this.rd, "Halfpipe-Normal-Road Blend");
/* 2230 */     this.part.add(this.rd, "Rollercoaster Start/End"); this.part.add(this.rd, "Rollercoaster Road1"); this.part.add(this.rd, "Rollercoaster Road2"); this.part.add(this.rd, "Rollercoaster Road3"); this.part.add(this.rd, "Rollercoaster Road4"); this.part.add(this.rd, "Rollercoaster Road5");
/*      */   }
/*      */ 
/*      */   
/*      */   public void partramps() {
/* 2235 */     this.part.removeAll();
/* 2236 */     this.part.add(this.rd, "Basic Ramp"); this.part.add(this.rd, "Two-Way Ramp"); this.part.add(this.rd, "Two-Way High-Low Ramp"); this.part.add(this.rd, "Small Ramp"); this.part.add(this.rd, "Crash Ramp"); this.part.add(this.rd, "Big-Takeoff Ramp"); this.part.add(this.rd, "Landing Ramp"); this.part.add(this.rd, "Tunnel Side Ramp"); this.part.add(this.rd, "Speed Ramp"); this.part.add(this.rd, "Launch Pad Ramp"); this.part.add(this.rd, "Offroad Bump Ramp"); this.part.add(this.rd, "Offroad Ramp"); this.part.add(this.rd, "Offroad Big Ramp"); this.part.add(this.rd, "Offroad Hill Ramp"); this.part.add(this.rd, "Offroad Big Hill Ramp"); this.part.add(this.rd, "Halfpipe");
/*      */   }
/*      */ 
/*      */   
/*      */   public void partobst() {
/* 2241 */     this.part.removeAll();
/* 2242 */     this.part.add(this.rd, "Spiky Pillars"); this.part.add(this.rd, "Rail Doorway"); this.part.add(this.rd, "The Net"); this.part.add(this.rd, "Bump Slide"); this.part.add(this.rd, "Offroad Dirt-Pile 1"); this.part.add(this.rd, "Offroad Dirt-Pile 2");
/*      */   }
/*      */ 
/*      */   
/*      */   public void init() {
/* 2247 */     setBackground(new Color(0, 0, 0));
/* 2248 */     this.offImage = createImage(800, 550);
/* 2249 */     if (this.offImage != null) this.rd = (Graphics2D)this.offImage.getGraphics(); 
/* 2250 */     this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
/*      */     
/* 2252 */     setLayout((LayoutManager)null);
/*      */     
/* 2254 */     this.slstage.setFont(new Font("Arial", 1, 13));
/* 2255 */     this.slstage.add(this.rd, "Select a Stage...         ");
/* 2256 */     this.slstage.setForeground(new Color(63, 80, 110));
/* 2257 */     this.slstage.setBackground(new Color(209, 217, 230));
/*      */     
/* 2259 */     this.srch.setFont(new Font("Arial", 1, 12));
/* 2260 */     this.srch.setBackground(new Color(255, 255, 255));
/* 2261 */     this.srch.setForeground(new Color(0, 0, 0));
/*      */     
/* 2263 */     this.strtyp.setFont(new Font("Arial", 1, 12));
/* 2264 */     this.strtyp.add(this.rd, "NormalRoad");
/* 2265 */     this.strtyp.add(this.rd, "OffRoad");
/* 2266 */     this.strtyp.setBackground(new Color(63, 80, 110));
/* 2267 */     this.strtyp.setForeground(new Color(209, 217, 230));
/*      */     
/* 2269 */     this.ptyp.setFont(new Font("Arial", 1, 12));
/* 2270 */     this.ptyp.add(this.rd, "Roads");
/* 2271 */     this.ptyp.add(this.rd, "Ramps");
/* 2272 */     this.ptyp.add(this.rd, "Obstacles");
/* 2273 */     this.ptyp.add(this.rd, "Checkpoint");
/* 2274 */     this.ptyp.add(this.rd, "Fixing Hoop");
/* 2275 */     this.ptyp.add(this.rd, "Trees");
/* 2276 */     this.ptyp.add(this.rd, "Ground Pile");
/* 2277 */     this.ptyp.setBackground(new Color(63, 80, 110));
/* 2278 */     this.ptyp.setForeground(new Color(209, 217, 230));
/*      */     
/* 2280 */     this.part.setFont(new Font("Arial", 1, 12));
/* 2281 */     this.part.add(this.rd, "Halfpipe-Normal-Road Blend");
/* 2282 */     this.part.setBackground(new Color(63, 80, 110));
/* 2283 */     this.part.setForeground(new Color(209, 217, 230));
/*      */     
/* 2285 */     this.fixh.setFont(new Font("Arial", 1, 12));
/* 2286 */     this.fixh.setBackground(new Color(255, 255, 255));
/* 2287 */     this.fixh.setForeground(new Color(0, 0, 0));
/*      */     
/* 2289 */     this.mgen.setFont(new Font("Arial", 1, 12));
/* 2290 */     this.mgen.setBackground(new Color(255, 255, 255));
/* 2291 */     this.mgen.setForeground(new Color(0, 0, 0));
/*      */     
/* 2293 */     this.pfog.setFont(new Font("Arial", 1, 12));
/* 2294 */     this.pfog.setBackground(new Color(225, 225, 225));
/* 2295 */     this.pfog.setForeground(new Color(0, 0, 0));
/*      */     
/* 2297 */     this.nlaps.setFont(new Font("Arial", 1, 12));
/* 2298 */     for (byte b = 0; b < 15; ) { this.nlaps.add(this.rd, " " + (b + 1) + " "); b++; }
/* 2299 */      this.nlaps.setBackground(new Color(63, 80, 110));
/* 2300 */     this.nlaps.setForeground(new Color(209, 217, 230));
/*      */     
/* 2302 */     this.tracks.setFont(new Font("Arial", 1, 12));
/* 2303 */     this.tracks.add(this.rd, "Select MOD Track");
/* 2304 */     this.tracks.setForeground(new Color(63, 80, 110));
/* 2305 */     this.tracks.setBackground(new Color(209, 217, 230));
/*      */     
/* 2307 */     this.witho.setFont(new Font("Arial", 1, 12));
/* 2308 */     this.witho.add(this.rd, "With other cars");
/* 2309 */     this.witho.add(this.rd, "Alone");
/* 2310 */     this.witho.setBackground(new Color(63, 80, 110));
/* 2311 */     this.witho.setForeground(new Color(209, 217, 230));
/*      */     
/* 2313 */     this.tnick.setFont(new Font("Arial", 1, 13));
/* 2314 */     this.tnick.setBackground(new Color(255, 255, 255));
/* 2315 */     this.tnick.setForeground(new Color(0, 0, 0));
/*      */     
/* 2317 */     this.tpass.setFont(new Font("Arial", 1, 13));
/* 2318 */     this.tpass.setEchoCharacter('*');
/* 2319 */     this.tpass.setBackground(new Color(255, 255, 255));
/* 2320 */     this.tpass.setForeground(new Color(0, 0, 0));
/*      */     
/* 2322 */     this.pubtyp.setFont(new Font("Arial", 1, 13));
/* 2323 */     this.pubtyp.add(this.rd, "Private");
/* 2324 */     this.pubtyp.add(this.rd, "Public");
/* 2325 */     this.pubtyp.add(this.rd, "Super Public");
/* 2326 */     this.pubtyp.setBackground(new Color(63, 80, 110));
/* 2327 */     this.pubtyp.setForeground(new Color(209, 217, 230));
/*      */     
/* 2329 */     this.pubitem.setFont(new Font("Arial", 1, 13));
/* 2330 */     this.pubitem.add(this.rd, "Account Stages");
/* 2331 */     this.pubitem.setBackground(new Color(209, 217, 230));
/* 2332 */     this.pubitem.setForeground(new Color(63, 80, 110));
/*      */     
/* 2334 */     add(this.tnick);
/* 2335 */     add(this.tpass);
/* 2336 */     add(this.srch);
/* 2337 */     add(this.fixh);
/* 2338 */     add(this.mgen);
/* 2339 */     add(this.pfog);
/*      */     
/* 2341 */     hidefields();
/*      */   }
/*      */   
/* 2344 */   public void hidefields() { this.pubtyp.hide(); this.pubitem.hide(); this.tpass.hide(); this.tnick.hide(); this.witho.hide(); this.strtyp.hide(); this.srch.hide(); this.slstage.hide(); this.tracks.hide(); this.nlaps.hide(); this.pfog.hide(); this.fixh.hide(); this.mgen.hide(); this.ptyp.hide(); this.part.hide(); } public void movefield(Component paramComponent, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 2345 */     paramInt1 += this.apx; paramInt2 += this.apy; if (paramComponent.getX() != paramInt1 || paramComponent.getY() != paramInt2 || paramComponent.getWidth() != paramInt3 || paramComponent.getHeight() != paramInt4) paramComponent.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);
/*      */   
/*      */   }
/*      */   
/*      */   boolean preop = false;
/*      */   boolean mousdr = false;
/*      */   
/*      */   public void drawms() {
/* 2353 */     boolean bool = false;
/* 2354 */     if (this.pubtyp.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) bool = true; 
/* 2355 */     if (this.pubitem.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) bool = true; 
/* 2356 */     if (this.slstage.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) bool = true; 
/* 2357 */     if (this.strtyp.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) bool = true; 
/* 2358 */     short s = 0; if (this.preop) s = -1000; 
/* 2359 */     if (this.part.draw(this.rd, this.xm, this.ym + s, (this.mousdr && !this.preop), 550, false)) bool = true; 
/* 2360 */     if (this.ptyp.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) { bool = true; this.preop = true; } else { this.preop = false; }
/* 2361 */      if (this.nlaps.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) bool = true; 
/* 2362 */     if (this.tracks.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) bool = true; 
/* 2363 */     if (this.witho.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) bool = true; 
/* 2364 */     if (bool) this.mouses = 0; 
/*      */   }
/*      */   
/*      */   public void start() {
/* 2368 */     if (this.thredo == null) this.thredo = new Thread(this);  this.thredo.start(); } public void stop() {
/* 2369 */     this.exwist = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void paint(Graphics paramGraphics) {
/* 2374 */     this.apx = getWidth() / 2 - 400;
/* 2375 */     this.apy = getHeight() / 2 - 275;
/* 2376 */     paramGraphics.drawImage(this.offImage, this.apx, this.apy, this);
/*      */   }
/*      */   public void update(Graphics paramGraphics) {
/* 2379 */     paint(paramGraphics);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean mouseUp(Event paramEvent, int paramInt1, int paramInt2) {
/* 2384 */     this.mousdr = false;
/* 2385 */     this.xm = paramInt1 - this.apx; this.ym = paramInt2 - this.apy;
/* 2386 */     if (this.mouses == 1) this.mouses = -1; 
/* 2387 */     if (this.onbtgame) Madness.game(); 
/* 2388 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean mouseDown(Event paramEvent, int paramInt1, int paramInt2) {
/* 2393 */     this.mousdr = true;
/* 2394 */     this.xm = paramInt1 - this.apx; this.ym = paramInt2 - this.apy;
/* 2395 */     this.mouses = 1;
/* 2396 */     requestFocus();
/* 2397 */     this.focuson = true;
/* 2398 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean mouseMove(Event paramEvent, int paramInt1, int paramInt2) {
/* 2403 */     this.xm = paramInt1 - this.apx; this.ym = paramInt2 - this.apy;
/* 2404 */     if (this.xm > 620 && this.xm < 774 && this.ym > 0 && this.ym < 23) { if (!this.onbtgame) { this.onbtgame = true; setCursor(new Cursor(12)); }  } else if (this.onbtgame) { this.onbtgame = false; setCursor(new Cursor(0)); }
/* 2405 */      return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean mouseDrag(Event paramEvent, int paramInt1, int paramInt2) {
/* 2410 */     this.mousdr = true;
/* 2411 */     this.xm = paramInt1 - this.apx; this.ym = paramInt2 - this.apy;
/* 2412 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean keyDown(Event paramEvent, int paramInt) {
/* 2418 */     if (this.focuson) {
/*      */       
/* 2420 */       if (paramInt == 42 || paramInt == 10 || paramInt == 56 || paramInt == 119 || paramInt == 87 || paramInt == 43 || paramInt == 61) this.zoomi = true; 
/* 2421 */       if (paramInt == 47 || paramInt == 8 || paramInt == 50 || paramInt == 115 || paramInt == 83 || paramInt == 45) this.zoomo = true; 
/* 2422 */       if (paramInt == 1006) this.left = true; 
/* 2423 */       if (paramInt == 1007) this.right = true; 
/* 2424 */       if (paramInt == 1005) this.down = true; 
/* 2425 */       if (paramInt == 1004) this.up = true; 
/*      */     } 
/* 2427 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean keyUp(Event paramEvent, int paramInt) {
/* 2432 */     if (paramInt == 42 || paramInt == 10 || paramInt == 56 || paramInt == 119 || paramInt == 87 || paramInt == 43 || paramInt == 61) this.zoomi = false; 
/* 2433 */     if (paramInt == 47 || paramInt == 8 || paramInt == 50 || paramInt == 115 || paramInt == 83 || paramInt == 45) this.zoomo = false; 
/* 2434 */     if (paramInt == 1006) this.left = false; 
/* 2435 */     if (paramInt == 1007) this.right = false; 
/* 2436 */     if (paramInt == 1005) this.down = false; 
/* 2437 */     if (paramInt == 1004) this.up = false; 
/* 2438 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void loadbase() {
/* 2444 */     String[] arrayOfString = { "road", "froad", "twister2", "twister1", "turn", "offroad", "bumproad", "offturn", "nroad", "nturn", "roblend", "noblend", "rnblend", "roadend", "offroadend", "hpground", "ramp30", "cramp35", "dramp15", "dhilo15", "slide10", "takeoff", "sramp22", "offbump", "offramp", "sofframp", "halfpipe", "spikes", "rail", "thewall", "checkpoint", "fixpoint", "offcheckpoint", "sideoff", "bsideoff", "uprise", "riseroad", "sroad", "soffroad", "tside", "launchpad", "thenet", "speedramp", "offhill", "slider", "uphill", "roll1", "roll2", "roll3", "roll4", "roll5", "roll6", "opile1", "opile2", "aircheckpoint", "tree1", "tree2", "tree3", "tree4", "tree5", "tree6", "tree7", "tree8", "cac1", "cac2", "cac3" };
/*      */ 
/*      */     
/*      */     try {
/* 2448 */       File file = new File("" + Madness.fpath + "data/models.zip");
/* 2449 */       ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
/*      */       
/* 2451 */       ZipEntry zipEntry = zipInputStream.getNextEntry();
/* 2452 */       byte[] arrayOfByte = null;
/* 2453 */       while (zipEntry != null) {
/*      */         
/* 2455 */         int i = -1; int j;
/* 2456 */         for (j = 0; j < 66; ) { if (zipEntry.getName().startsWith(arrayOfString[j])) i = j;  j++; }
/* 2457 */          if (i != -1) {
/*      */           
/* 2459 */           j = (int)zipEntry.getSize();
/* 2460 */           arrayOfByte = new byte[j];
/* 2461 */           int k = 0;
/*      */           
/* 2463 */           for (; j > 0; j -= m) {
/*      */             
/* 2465 */             int m = zipInputStream.read(arrayOfByte, k, j);
/* 2466 */             k += m;
/*      */           } 
/* 2468 */           this.bco[i] = new ContO(arrayOfByte, this.m, this.t);
/* 2469 */           for (byte b = 0; b < (this.bco[i]).npl; ) { (this.bco[i]).p[b].loadprojf(); b++; }
/* 2470 */            if (i == 31) (this.bco[i]).elec = true;
/*      */         
/*      */         } 
/* 2473 */         zipEntry = zipInputStream.getNextEntry();
/*      */       } 
/* 2475 */       zipInputStream.close();
/*      */       
/* 2477 */       this.bco[66] = new ContO((int)(10000.0D * Math.random()), (int)this.pwd, (int)this.phd, this.m, this.t, 0, 0, 0);
/*      */     } catch (Exception exception) {
/* 2479 */       JOptionPane.showMessageDialog(null, "Unable to load file 'data/models.zip'!\nError:\n" + exception, "Stage Maker", 1);
/* 2480 */     }  System.gc();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void readstage(int paramInt) {
/* 2486 */     this.errd = 0;
/*      */     
/* 2488 */     this.trackname = "";
/* 2489 */     this.t.nt = 0;
/* 2490 */     this.nob = 0;
/* 2491 */     this.xnob = 0;
/* 2492 */     this.cp.n = 0;
/* 2493 */     this.cp.nsp = 0;
/* 2494 */     this.cp.fn = 0;
/* 2495 */     this.cp.haltall = false;
/* 2496 */     this.cp.wasted = 0;
/* 2497 */     this.cp.catchfin = 0;
/* 2498 */     this.m.ground = 250;
/* 2499 */     this.m.lightson = false;
/*      */     
/* 2501 */     if (paramInt == 0) { this.m.snap[0] = 0; this.m.snap[1] = 0; this.m.snap[2] = 0; }
/*      */     
/* 2503 */     if (paramInt == 3) { this.tstage = ""; this.bstage = ""; }
/* 2504 */      String str1 = this.bstage;
/* 2505 */     if (paramInt == 1 || paramInt == 2) str1 = "" + this.tstage + "\r\n" + this.bstage + "";
/*      */     
/* 2507 */     int i = 0, j = 100, k = 0, m = 100;
/*      */     
/* 2509 */     boolean bool1 = true;
/* 2510 */     boolean bool2 = true;
/*      */     
/* 2512 */     String str2 = "";
/*      */     
/*      */     try {
/* 2515 */       DataInputStream dataInputStream = null;
/* 2516 */       if (paramInt == 3) {
/*      */         
/* 2518 */         File file = new File("" + Madness.fpath + "mystages/" + this.stagename + ".txt");
/* 2519 */         dataInputStream = new DataInputStream(new FileInputStream(file));
/* 2520 */         this.nundo = 0;
/*      */       }
/*      */       else {
/*      */         
/* 2524 */         dataInputStream = new DataInputStream(new ByteArrayInputStream(str1.getBytes()));
/*      */       } 
/*      */       String str;
/* 2527 */       while ((str = dataInputStream.readLine()) != null) {
/*      */         
/* 2529 */         str2 = "" + str.trim();
/* 2530 */         if (str2.startsWith("sky")) { this.csky[0] = getint("sky", str2, 0); this.csky[1] = getint("sky", str2, 1); this.csky[2] = getint("sky", str2, 2); this.m.setsky(this.csky[0], this.csky[1], this.csky[2]); if (paramInt == 3) this.tstage += "" + str2 + "\r\n";  }
/* 2531 */          if (str2.startsWith("ground")) { this.cgrnd[0] = getint("ground", str2, 0); this.cgrnd[1] = getint("ground", str2, 1); this.cgrnd[2] = getint("ground", str2, 2); this.m.setgrnd(this.cgrnd[0], this.cgrnd[1], this.cgrnd[2]); if (paramInt == 3) this.tstage += "" + str2 + "\r\n";  }
/* 2532 */          if (str2.startsWith("polys")) { this.m.setpolys(getint("polys", str2, 0), getint("polys", str2, 1), getint("polys", str2, 2)); if (paramInt == 3) this.tstage += "" + str2 + "\r\n";  }
/* 2533 */          if (str2.startsWith("fog")) { this.cfade[0] = getint("fog", str2, 0); this.cfade[1] = getint("fog", str2, 1); this.cfade[2] = getint("fog", str2, 2); this.m.setfade(this.cfade[0], this.cfade[1], this.cfade[2]); if (paramInt == 3) this.tstage += "" + str2 + "\r\n";  }
/*      */         
/* 2535 */         if (str2.startsWith("texture")) { this.texture[0] = getint("texture", str2, 0); this.texture[1] = getint("texture", str2, 1); this.texture[2] = getint("texture", str2, 2); this.texture[3] = getint("texture", str2, 3); this.m.setexture(this.texture[0], this.texture[1], this.texture[2], this.texture[3]); if (paramInt == 3) this.tstage += "" + str2 + "\r\n";  }
/* 2536 */          if (str2.startsWith("clouds")) { this.cldd[0] = getint("clouds", str2, 0); this.cldd[1] = getint("clouds", str2, 1); this.cldd[2] = getint("clouds", str2, 2); this.cldd[3] = getint("clouds", str2, 3); this.cldd[4] = getint("clouds", str2, 4); this.m.setcloads(this.cldd[0], this.cldd[1], this.cldd[2], this.cldd[3], this.cldd[4]); if (paramInt == 3) this.tstage += "" + str2 + "\r\n";  }
/*      */         
/* 2538 */         if (paramInt != 2 && str2.startsWith("snap")) { this.m.setsnap(getint("snap", str2, 0), getint("snap", str2, 1), getint("snap", str2, 2)); if (paramInt == 3) this.tstage += "" + str2 + "\r\n";  }
/* 2539 */          if (str2.startsWith("density")) { this.m.fogd = (getint("density", str2, 0) + 1) * 2 - 1; if (this.m.fogd < 1) this.m.fogd = 1;  if (this.m.fogd > 30) this.m.fogd = 30;  if (paramInt == 3) this.tstage += "" + str2 + "\r\n";  }
/* 2540 */          if (str2.startsWith("mountains")) { this.m.mgen = getint("mountains", str2, 0); if (paramInt == 3) this.tstage += "" + str2 + "\r\n";  }
/*      */         
/* 2542 */         if (str2.startsWith("fadefrom")) { this.m.fadfrom(getint("fadefrom", str2, 0)); this.origfade = this.m.fade[0]; if (paramInt == 3) this.tstage += "" + str2 + "\r\n";  }
/* 2543 */          if (str2.startsWith("lightson")) { this.m.lightson = true; if (paramInt == 3) this.tstage += "" + str2 + "\r\n";  }
/* 2544 */          if (str2.startsWith("nlaps")) { this.cp.nlaps = getint("nlaps", str2, 0); if (this.cp.nlaps < 1) this.cp.nlaps = 1;  if (this.cp.nlaps > 15) this.cp.nlaps = 15;  if (paramInt == 3) this.tstage += "" + str2 + "\r\n";  }
/* 2545 */          if (str2.startsWith("soundtrack")) { this.trackname = getstring("soundtrack", str2, 0); this.trackvol = getint("soundtrack", str2, 1); this.tracksize = getint("soundtrack", str2, 2); if (paramInt == 3) this.tstage += "" + str2 + "\r\n";  }
/*      */         
/* 2547 */         if (str2.startsWith("set")) { int n = getint("set", str2, 0); if (n >= 10 && n <= 25) this.m.loadnew = true;  n -= 10; this.co[this.nob] = new ContO(this.bco[n], getint("set", str2, 1), this.m.ground - (this.bco[n]).grat, getint("set", str2, 2), getint("set", str2, 3)); (this.co[this.nob]).roofat = getint("set", str2, 3); (this.co[this.nob]).colok = n; if (str2.indexOf(")p") != -1) { this.cp.x[this.cp.n] = getint("chk", str2, 1); this.cp.z[this.cp.n] = getint("chk", str2, 2); this.cp.y[this.cp.n] = 0; this.cp.typ[this.cp.n] = 0; if (str2.indexOf(")pt") != -1) this.cp.typ[this.cp.n] = -1;  if (str2.indexOf(")pr") != -1) this.cp.typ[this.cp.n] = -2;  if (str2.indexOf(")po") != -1) this.cp.typ[this.cp.n] = -3;  if (str2.indexOf(")ph") != -1) this.cp.typ[this.cp.n] = -4;  this.cp.n++; }  this.xnob++; this.nob++; if (paramInt == 3) { if (bool2) { this.bstage += "\r\n"; bool2 = false; }  this.bstage += "" + str2 + "\r\n"; }  if (this.m.loadnew) this.m.loadnew = false;  }
/* 2548 */          if (str2.startsWith("chk")) { int n = getint("chk", str2, 0); n -= 10; int i1 = this.m.ground - (this.bco[n]).grat; if (n == 54) i1 = getint("chk", str2, 4);  this.co[this.nob] = new ContO(this.bco[n], getint("chk", str2, 1), i1, getint("chk", str2, 2), getint("chk", str2, 3)); (this.co[this.nob]).roofat = getint("chk", str2, 3); (this.co[this.nob]).colok = n; this.cp.x[this.cp.n] = getint("chk", str2, 1); this.cp.z[this.cp.n] = getint("chk", str2, 2); this.cp.y[this.cp.n] = i1; if (getint("chk", str2, 3) == 0) { this.cp.typ[this.cp.n] = 1; } else { this.cp.typ[this.cp.n] = 2; }  this.cp.pcs = this.cp.n; this.cp.n++; (this.co[this.nob]).checkpoint = this.cp.nsp + 1; if (str2.indexOf(")r") != -1) (this.co[this.nob]).wh = this.cp.nsp + 1;  this.cp.nsp++; this.xnob++; this.nob++; if (paramInt == 3) { if (bool2) { this.bstage += "\r\n"; bool2 = false; }  this.bstage += "" + str2 + "\r\n"; }  }
/* 2549 */          if (str2.startsWith("fix")) { int n = getint("fix", str2, 0); n -= 10; this.co[this.nob] = new ContO(this.bco[n], getint("fix", str2, 1), getint("fix", str2, 3), getint("fix", str2, 2), getint("fix", str2, 4)); (this.co[this.nob]).roofat = getint("fix", str2, 4); (this.co[this.nob]).colok = n; this.cp.fx[this.cp.fn] = getint("fix", str2, 1); this.cp.fz[this.cp.fn] = getint("fix", str2, 2); this.cp.fy[this.cp.fn] = getint("fix", str2, 3); (this.co[this.nob]).elec = true; if (getint("fix", str2, 4) != 0) { this.cp.roted[this.cp.fn] = true; (this.co[this.nob]).roted = true; } else { this.cp.roted[this.cp.fn] = false; }  if (str2.indexOf(")s") != -1) { this.cp.special[this.cp.fn] = true; } else { this.cp.special[this.cp.fn] = false; }  this.cp.fn++; this.xnob++; this.nob++; if (paramInt == 3) { if (bool2) { this.bstage += "\r\n"; bool2 = false; }  this.bstage += "" + str2 + "\r\n"; }  }
/* 2550 */          if (str2.startsWith("pile")) { this.co[this.nob] = new ContO(getint("pile", str2, 0), getint("pile", str2, 1), getint("pile", str2, 2), this.m, this.t, getint("pile", str2, 3), getint("pile", str2, 4), this.m.ground); (this.co[this.nob]).srz = getint("pile", str2, 0); (this.co[this.nob]).srx = getint("pile", str2, 1); (this.co[this.nob]).sry = getint("pile", str2, 2); (this.co[this.nob]).colok = 66; this.xnob++; this.nob++; if (paramInt == 3) { if (bool2) { this.bstage += "\r\n"; bool2 = false; }  this.bstage += "" + str2 + "\r\n"; }
/*      */            }
/* 2552 */          if (str2.startsWith("maxr")) { int n; int i1; int i2; byte b; for (n = getint("maxr", str2, 0), i = i1 = getint("maxr", str2, 1), i2 = getint("maxr", str2, 2), b = 0; b < n; ) { this.co[this.nob] = new ContO(this.bco[29], i1, this.m.ground - (this.bco[29]).grat, b * 4800 + i2, 0); if (paramInt == 0) { this.xnob++; } else { this.nob++; }  b++; }  if (paramInt == 3) { if (bool1) { this.bstage += "\r\n"; bool1 = false; }  this.bstage += "" + str2 + "\r\n"; }  }
/* 2553 */          if (str2.startsWith("maxl")) { int n; int i1; int i2; byte b; for (n = getint("maxl", str2, 0), j = i1 = getint("maxl", str2, 1), i2 = getint("maxl", str2, 2), b = 0; b < n; ) { this.co[this.nob] = new ContO(this.bco[29], i1, this.m.ground - (this.bco[29]).grat, b * 4800 + i2, 180); if (paramInt == 0) { this.xnob++; } else { this.nob++; }  b++; }  if (paramInt == 3) { if (bool1) { this.bstage += "\r\n"; bool1 = false; }  this.bstage += "" + str2 + "\r\n"; }  }
/* 2554 */          if (str2.startsWith("maxt")) { int n; int i1; int i2; byte b; for (n = getint("maxt", str2, 0), k = i1 = getint("maxt", str2, 1), i2 = getint("maxt", str2, 2), b = 0; b < n; ) { this.co[this.nob] = new ContO(this.bco[29], b * 4800 + i2, this.m.ground - (this.bco[29]).grat, i1, 90); if (paramInt == 0) { this.xnob++; } else { this.nob++; }  b++; }  if (paramInt == 3) { if (bool1) { this.bstage += "\r\n"; bool1 = false; }  this.bstage += "" + str2 + "\r\n"; }  }
/* 2555 */          if (str2.startsWith("maxb")) { int n; int i1; int i2; byte b; for (n = getint("maxb", str2, 0), m = i1 = getint("maxb", str2, 1), i2 = getint("maxb", str2, 2), b = 0; b < n; ) { this.co[this.nob] = new ContO(this.bco[29], b * 4800 + i2, this.m.ground - (this.bco[29]).grat, i1, -90); if (paramInt == 0) { this.xnob++; } else { this.nob++; }  b++; }  if (paramInt == 3) { if (bool1) { this.bstage += "\r\n"; bool1 = false; }  this.bstage += "" + str2 + "\r\n"; }  }
/*      */       
/* 2557 */       }  dataInputStream.close();
/*      */       
/* 2559 */       this.m.newpolys(j, i - j, m, k - m, this.t, this.nob);
/* 2560 */       this.m.newclouds(j, i, m, k);
/* 2561 */       this.m.newmountains(j, i, m, k);
/* 2562 */       this.m.newstars();
/*      */     }
/* 2564 */     catch (Exception exception) {
/*      */       
/* 2566 */       System.out.println("Error in stage " + this.stagename); System.out.println("" + exception); System.out.println("At line: " + str2);
/* 2567 */       this.errd = 6;
/* 2568 */       if (this.cp.fn >= 5) this.errd = 5; 
/* 2569 */       if (this.t.nt >= 6700) this.errd = 1; 
/* 2570 */       if (this.cp.n >= 140) this.errd = 2; 
/* 2571 */       if (this.nob >= 601) this.errd = 4; 
/*      */     } 
/* 2573 */     if (this.m.nrw * this.m.ncl >= 16000) this.errd = 3; 
/* 2574 */     if (this.xnob >= 602) this.errd = 4; 
/* 2575 */     if (paramInt == 3 && this.bstage.indexOf("set(47,0,0,0)") == -1 && this.bstage.indexOf("set(48,0,0,0)") == -1) this.bstage += "set(47,0,0,0)\r\n";
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void newstage() {
/* 2582 */     if (!this.srch.getText().equals(""))
/*      */     
/* 2584 */     { File file = new File("" + Madness.fpath + "mystages/" + this.srch.getText() + ".txt");
/* 2585 */       if (!file.exists())
/*      */       
/* 2587 */       { this.stagename = this.srch.getText();
/* 2588 */         this.tstage = "snap(0,0,0)\r\nsky(191,215,255)\r\nclouds(255,255,255,5,-1000)\r\nfog(195,207,230)\r\nground(192,194,202)\r\ntexture(0,0,0,50)\r\nfadefrom(5000)\r\ndensity(5)\r\nmountains(" + (int)(Math.random() * 100000.0D) + ")\r\nnlaps(5)\r\n\r\n";
/* 2589 */         if (this.strtyp.getSelectedIndex() == 1) { this.bstage = "set(48,0,0,0)\r\n"; } else { this.bstage = "set(47,0,0,0)\r\n"; }
/* 2590 */          this.bstage += "\r\nmaxl(3,-7200,-4800)\r\nmaxb(3,-7200,-4800)\r\nmaxr(3,7200,-4800)\r\nmaxt(3,7200,-4800)\r\n";
/* 2591 */         savefile();
/* 2592 */         this.strtyp.hide(); this.srch.hide(); this.sfase = 0; this.tabed = -2; }
/* 2593 */       else { JOptionPane.showMessageDialog(null, "A stage with that name already exists, please choose another name!", "Stage Maker", 1); }  }
/* 2594 */     else { JOptionPane.showMessageDialog(null, "Please enter a stage name first!", "Stage Maker", 1); }
/*      */   
/*      */   }
/* 2597 */   String ttstage = "";
/*      */ 
/*      */   
/*      */   public void sortop() {
/* 2601 */     this.tstage = "snap(" + this.m.snap[0] + "," + this.m.snap[1] + "," + this.m.snap[2] + ")\r\nsky(" + this.csky[0] + "," + this.csky[1] + "," + this.csky[2] + ")\r\nfog(" + this.cfade[0] + "," + this.cfade[1] + "," + this.cfade[2] + ")\r\nclouds(" + this.cldd[0] + "," + this.cldd[1] + "," + this.cldd[2] + "," + this.cldd[3] + "," + this.cldd[4] + ")\r\nground(" + this.cgrnd[0] + "," + this.cgrnd[1] + "," + this.cgrnd[2] + ")\r\ntexture(" + this.texture[0] + "," + this.texture[1] + "," + this.texture[2] + "," + this.texture[3] + ")\r\nfadefrom(" + this.origfade + ")\r\ndensity(" + ((this.m.fogd + 1) / 2 - 1) + ")\r\nmountains(" + this.m.mgen + ")\r\nnlaps(" + this.cp.nlaps + ")\r\n";
/* 2602 */     if (!this.trackname.equals("")) this.tstage += "soundtrack(" + this.trackname + "," + this.trackvol + "," + this.tracksize + ")\r\n"; 
/* 2603 */     for (byte b = 0; b < 3; ) { this.snap[b] = (int)(this.m.snap[b] / 1.2F + 50.0F); b++; }
/* 2604 */      if (this.snap[0] + this.snap[1] + this.snap[2] <= 110) this.tstage += "lightson()\r\n"; 
/* 2605 */     this.tstage += "\r\n";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void sortstage() {
/* 2612 */     int[] arrayOfInt1 = new int[this.nob * 2];
/* 2613 */     int[] arrayOfInt2 = new int[this.nob * 2]; byte b;
/* 2614 */     for (b = 0; b < this.nob; ) { arrayOfInt1[b] = 0; b++; }
/* 2615 */      b = 0;
/* 2616 */     byte b1 = 0;
/* 2617 */     arrayOfInt2[b1] = 0; b1++;
/* 2618 */     boolean bool = false;
/* 2619 */     byte b2 = 0;
/*      */     
/* 2621 */     while (!bool) {
/*      */       
/* 2623 */       int[] arrayOfInt3 = { (this.co[b]).x + this.atp[(this.co[b]).colok][0], (this.co[b]).x + this.atp[(this.co[b]).colok][2] };
/* 2624 */       int[] arrayOfInt4 = { (this.co[b]).z + this.atp[(this.co[b]).colok][1], (this.co[b]).z + this.atp[(this.co[b]).colok][3] };
/* 2625 */       int i10 = (this.co[b]).roofat; if ((this.co[b]).colok == 2) i10 += 30;  if ((this.co[b]).colok == 3) i10 -= 30;  if ((this.co[b]).colok == 15) i10 -= 90;  if ((this.co[b]).colok == 20) i10 -= 180;  if ((this.co[b]).colok == 26) i10 -= 90; 
/* 2626 */       rot(arrayOfInt3, arrayOfInt4, (this.co[b]).x, (this.co[b]).z, i10, 2);
/* 2627 */       int i11 = -1; byte b3 = -1;
/*      */       
/* 2629 */       if (b2)
/*      */       {
/* 2631 */         for (byte b4 = 0; b4 < this.nob; b4++) {
/*      */           
/* 2633 */           boolean bool1 = false; if (b1 == 2 && b4 == 0) bool1 = true; 
/* 2634 */           if (b != b4 && !bool1 && arrayOfInt1[b4] == 0 && ((this.co[b4]).colok <= 14 || (this.co[b4]).colok >= 33) && ((this.co[b4]).colok < 39 || (this.co[b4]).colok >= 46) && (this.co[b4]).colok < 52) {
/*      */ 
/*      */             
/* 2637 */             byte b5 = 0;
/* 2638 */             if ((this.co[b4]).colok != 2 && (this.co[b4]).colok != 3 && (this.co[b4]).colok != 4 && (this.co[b4]).colok != 7 && (this.co[b4]).colok != 9)
/*      */             
/* 2640 */             { if (b2 == 1 && (this.co[b4]).z > (this.co[b]).z && Math.abs((this.co[b4]).x - (this.co[b]).x) < 1000 && ((this.co[b4]).roofat == 180 || (this.co[b4]).roofat == 0)) b5 = 1; 
/* 2641 */               if (b2 == 2 && (this.co[b4]).z < (this.co[b]).z && Math.abs((this.co[b4]).x - (this.co[b]).x) < 1000 && ((this.co[b4]).roofat == 180 || (this.co[b4]).roofat == 0)) b5 = 1; 
/* 2642 */               if (b2 == 3 && (this.co[b4]).x > (this.co[b]).x && Math.abs((this.co[b4]).z - (this.co[b]).z) < 1000 && ((this.co[b4]).roofat == 90 || (this.co[b4]).roofat == -90)) b5 = 1; 
/* 2643 */               if (b2 == 4 && (this.co[b4]).x < (this.co[b]).x && Math.abs((this.co[b4]).z - (this.co[b]).z) < 1000 && ((this.co[b4]).roofat == 90 || (this.co[b4]).roofat == -90)) b5 = 1;  }
/* 2644 */             else { b5 = 2; }
/*      */             
/* 2646 */             if (b5 != 0) {
/*      */               
/* 2648 */               int[] arrayOfInt5 = { (this.co[b4]).x + this.atp[(this.co[b4]).colok][0], (this.co[b4]).x + this.atp[(this.co[b4]).colok][2] };
/* 2649 */               int[] arrayOfInt6 = { (this.co[b4]).z + this.atp[(this.co[b4]).colok][1], (this.co[b4]).z + this.atp[(this.co[b4]).colok][3] };
/* 2650 */               i10 = (this.co[b4]).roofat; if ((this.co[b4]).colok == 2) i10 += 30;  if ((this.co[b4]).colok == 3) i10 -= 30;  if ((this.co[b4]).colok == 15) i10 -= 90;  if ((this.co[b4]).colok == 20) i10 -= 180;  if ((this.co[b4]).colok == 26) i10 -= 90; 
/* 2651 */               rot(arrayOfInt5, arrayOfInt6, (this.co[b4]).x, (this.co[b4]).z, i10, 2);
/* 2652 */               int i12 = 0;
/* 2653 */               if (b4 != 0) { i12 = pyn(arrayOfInt5[0], arrayOfInt3[0], arrayOfInt6[0], arrayOfInt4[0]); if (i12 >= 0 && (i12 < 100 || b5 != 2) && (i12 < i11 || i11 == -1)) { i11 = i12; b3 = b4; }  }
/* 2654 */                i12 = pyn(arrayOfInt5[1], arrayOfInt3[0], arrayOfInt6[1], arrayOfInt4[0]); if (i12 >= 0 && (i12 < 100 || b5 != 2) && (i12 < i11 || i11 == -1)) { i11 = i12; b3 = b4; }
/* 2655 */                if (b != 0) {
/*      */                 
/* 2657 */                 if (b4 != 0) { i12 = pyn(arrayOfInt5[0], arrayOfInt3[1], arrayOfInt6[0], arrayOfInt4[1]); if (i12 >= 0 && (i12 < 100 || b5 != 2) && i12 < i11) { i11 = i12; b3 = b4; }  }
/* 2658 */                  i12 = pyn(arrayOfInt5[1], arrayOfInt3[1], arrayOfInt6[1], arrayOfInt4[1]); if (i12 >= 0 && (i12 < 100 || b5 != 2) && i12 < i11) { i11 = i12; b3 = b4; }
/*      */               
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       }
/*      */       
/* 2666 */       if (b3 == -1)
/*      */       {
/* 2668 */         for (byte b4 = 0; b4 < this.nob; b4++) {
/*      */           
/* 2670 */           boolean bool1 = false; if (b1 == 2 && b4 == 0) bool1 = true; 
/* 2671 */           if (b != b4 && !bool1 && arrayOfInt1[b4] == 0 && ((this.co[b4]).colok <= 14 || (this.co[b4]).colok >= 33) && ((this.co[b4]).colok < 39 || (this.co[b4]).colok >= 46) && (this.co[b4]).colok < 52) {
/*      */             
/* 2673 */             int[] arrayOfInt5 = { (this.co[b4]).x + this.atp[(this.co[b4]).colok][0], (this.co[b4]).x + this.atp[(this.co[b4]).colok][2] };
/* 2674 */             int[] arrayOfInt6 = { (this.co[b4]).z + this.atp[(this.co[b4]).colok][1], (this.co[b4]).z + this.atp[(this.co[b4]).colok][3] };
/* 2675 */             i10 = (this.co[b4]).roofat; if ((this.co[b4]).colok == 2) i10 += 30;  if ((this.co[b4]).colok == 3) i10 -= 30;  if ((this.co[b4]).colok == 15) i10 -= 90;  if ((this.co[b4]).colok == 20) i10 -= 180;  if ((this.co[b4]).colok == 26) i10 -= 90; 
/* 2676 */             rot(arrayOfInt5, arrayOfInt6, (this.co[b4]).x, (this.co[b4]).z, i10, 2);
/* 2677 */             int i12 = 0;
/* 2678 */             if (b4 != 0) { i12 = pyn(arrayOfInt5[0], arrayOfInt3[0], arrayOfInt6[0], arrayOfInt4[0]); if (i12 >= 0 && (i12 < i11 || i11 == -1)) { i11 = i12; b3 = b4; }  }
/* 2679 */              i12 = pyn(arrayOfInt5[1], arrayOfInt3[0], arrayOfInt6[1], arrayOfInt4[0]); if (i12 >= 0 && (i12 < i11 || i11 == -1)) { i11 = i12; b3 = b4; }
/* 2680 */              if (b != 0) {
/*      */               
/* 2682 */               if (b4 != 0) { i12 = pyn(arrayOfInt5[0], arrayOfInt3[1], arrayOfInt6[0], arrayOfInt4[1]); if (i12 >= 0 && i12 < i11) { i11 = i12; b3 = b4; }  }
/* 2683 */                i12 = pyn(arrayOfInt5[1], arrayOfInt3[1], arrayOfInt6[1], arrayOfInt4[1]); if (i12 >= 0 && i12 < i11) { i11 = i12; b3 = b4; }
/*      */             
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       }
/* 2689 */       if (b3 != -1) {
/*      */         
/* 2691 */         b2 = 0;
/* 2692 */         if ((this.co[b3]).colok != 2 && (this.co[b3]).colok != 3 && (this.co[b3]).colok != 4 && (this.co[b3]).colok != 7 && (this.co[b3]).colok != 9) {
/*      */           
/* 2694 */           if (((this.co[b3]).roofat == 180 || (this.co[b3]).roofat == 0) && (this.co[b3]).z > (this.co[b]).z) b2 = 1; 
/* 2695 */           if (((this.co[b3]).roofat == 180 || (this.co[b3]).roofat == 0) && (this.co[b3]).z < (this.co[b]).z) b2 = 2; 
/* 2696 */           if (((this.co[b3]).roofat == 90 || (this.co[b3]).roofat == -90) && (this.co[b3]).x > (this.co[b]).x) b2 = 3; 
/* 2697 */           if (((this.co[b3]).roofat == 90 || (this.co[b3]).roofat == -90) && (this.co[b3]).x < (this.co[b]).x) b2 = 4; 
/*      */         } 
/* 2699 */         if ((this.co[b3]).colok == 4 || (this.co[b3]).colok == 7 || (this.co[b3]).colok == 9) { arrayOfInt1[b3] = 2; } else { arrayOfInt1[b3] = 1; }
/* 2700 */          if ((this.co[b3]).colok >= 46 && (this.co[b3]).colok <= 51) arrayOfInt1[b3] = 6; 
/* 2701 */         b = b3;
/* 2702 */         if (b3 == 0) { arrayOfInt1[0] = 1; bool = true; continue; }  arrayOfInt2[b1] = b3; b1++; continue;
/* 2703 */       }  arrayOfInt1[0] = 1; bool = true;
/*      */     } 
/*      */ 
/*      */     
/*      */     int i;
/*      */ 
/*      */     
/* 2710 */     for (i = 0; i < this.nob; ) { if (arrayOfInt1[i] == 0 && ((this.co[i]).colok <= 14 || (this.co[i]).colok >= 33) && ((this.co[i]).colok < 39 || (this.co[i]).colok >= 46) && (this.co[i]).colok < 52) { arrayOfInt2[b1] = i; b1++; }  i++; }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2715 */     for (i = 0; i < b1; i++) {
/*      */       
/* 2717 */       if ((this.co[arrayOfInt2[i]]).colok >= 46 && (this.co[arrayOfInt2[i]]).colok <= 51)
/*      */       {
/* 2719 */         for (int i10 = i + 1; i10 < b1; i10++) {
/*      */           
/* 2721 */           int i11 = pyn((this.co[arrayOfInt2[i]]).x, (this.co[arrayOfInt2[i10]]).x, (this.co[arrayOfInt2[i]]).z, (this.co[arrayOfInt2[i10]]).z);
/*      */           
/* 2723 */           if (i11 >= 0 && ((this.co[arrayOfInt2[i10]]).colok < 46 || (this.co[arrayOfInt2[i]]).colok > 51))
/*      */           {
/* 2725 */             if (i11 < ((this.co[arrayOfInt2[i]]).maxR + (this.co[arrayOfInt2[i10]]).maxR) / 100 * ((this.co[arrayOfInt2[i]]).maxR + (this.co[arrayOfInt2[i10]]).maxR) / 100) {
/*      */               
/* 2727 */               int i12 = arrayOfInt2[i10];
/* 2728 */               for (int i13 = i10; i13 > i; ) { arrayOfInt2[i13] = arrayOfInt2[i13 - 1]; i13--; }
/* 2729 */                arrayOfInt2[i] = i12;
/* 2730 */               arrayOfInt1[arrayOfInt2[i]] = 0;
/* 2731 */               i++;
/*      */             } 
/*      */           }
/*      */         } 
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2741 */     i = 1; int j;
/* 2742 */     for (j = 0; j < this.cp.nsp; j++) {
/*      */       
/* 2744 */       for (byte b3 = 0; b3 < this.nob; b3++) {
/*      */         
/* 2746 */         if ((this.co[b3]).wh == j + 1 && ((this.co[b3]).colok == 30 || (this.co[b3]).colok == 32 || (this.co[b3]).colok == 54)) {
/*      */           
/* 2748 */           int i10 = -1, i11 = -1; int i12;
/* 2749 */           for (i12 = i; i12 < b1; ) { if ((this.co[arrayOfInt2[i12]]).colok != 30 && (this.co[arrayOfInt2[i12]]).colok != 32 && (this.co[arrayOfInt2[i12]]).colok != 54) { int i13 = pyn((this.co[b3]).x, (this.co[arrayOfInt2[i12]]).x, (this.co[b3]).z, (this.co[arrayOfInt2[i12]]).z); if (i13 >= 0 && (i13 < i10 || i10 == -1)) { i10 = i13; i11 = i12; }  }  i12++; }
/* 2750 */            if (i11 != -1)
/*      */           
/* 2752 */           { arrayOfInt1[arrayOfInt2[i11]] = 0;
/* 2753 */             for (i12 = b1; i12 > i11; ) { arrayOfInt2[i12] = arrayOfInt2[i12 - 1]; i12--; }
/* 2754 */              arrayOfInt2[i11 + 1] = b3;
/* 2755 */             i = i11 + 1;
/* 2756 */             b1++; }
/* 2757 */           else { arrayOfInt2[b1] = b3; i = b1; b1++; }
/*      */         
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 2763 */     for (j = 0; j < this.nob; j++) {
/*      */       
/* 2765 */       if ((this.co[j]).wh == 0 && ((this.co[j]).colok == 30 || (this.co[j]).colok == 32 || (this.co[j]).colok == 54)) {
/*      */         
/* 2767 */         int i10 = -1, i11 = -1; int i12;
/* 2768 */         for (i12 = i; i12 < b1; ) { if ((this.co[arrayOfInt2[i12]]).colok != 30 && (this.co[arrayOfInt2[i12]]).colok != 32 && (this.co[arrayOfInt2[i12]]).colok != 54) { int i13 = pyn((this.co[j]).x, (this.co[arrayOfInt2[i12]]).x, (this.co[j]).z, (this.co[arrayOfInt2[i12]]).z); if (i13 >= 0 && (i13 < i10 || i10 == -1)) { i10 = i13; i11 = i12; }  }  i12++; }
/* 2769 */          if (i11 != -1)
/*      */         
/* 2771 */         { arrayOfInt1[arrayOfInt2[i11]] = 0;
/* 2772 */           for (i12 = b1; i12 > i11; ) { arrayOfInt2[i12] = arrayOfInt2[i12 - 1]; i12--; }
/* 2773 */            arrayOfInt2[i11 + 1] = j;
/* 2774 */           b1++; }
/* 2775 */         else { arrayOfInt2[b1] = j; b1++; }
/*      */       
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2782 */     for (j = 0; j < this.nob; j++) {
/*      */       
/* 2784 */       if ((this.co[j]).colok == 31) {
/*      */         
/* 2786 */         int i10 = -1; byte b3 = -1; byte b4;
/* 2787 */         for (b4 = 0; b4 < b1; ) { int i11 = pyn((this.co[j]).x, (this.co[arrayOfInt2[b4]]).x, (this.co[j]).z, (this.co[arrayOfInt2[b4]]).z); if (i11 >= 0 && (i11 < i10 || i10 == -1)) { i10 = i11; b3 = b4; }  b4++; }
/* 2788 */          if (b3 != -1)
/*      */         
/* 2790 */         { for (b4 = b1; b4 > b3; ) { arrayOfInt2[b4] = arrayOfInt2[b4 - 1]; b4--; }
/* 2791 */            arrayOfInt2[b3] = j;
/* 2792 */           b1++; }
/* 2793 */         else { arrayOfInt2[b1] = j; b1++; }
/*      */       
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2801 */     for (j = 0; j < this.nob; j++) {
/*      */       
/* 2803 */       if ((this.co[j]).colok == 15 || (this.co[j]).colok == 27 || (this.co[j]).colok == 28 || (this.co[j]).colok == 41 || (this.co[j]).colok == 44 || (this.co[j]).colok == 52 || (this.co[j]).colok == 53) {
/*      */         
/* 2805 */         byte b3 = -1; byte b4;
/* 2806 */         for (b4 = 0; b4 < b1; ) { if (((this.co[arrayOfInt2[b4]]).colok <= 14 || (this.co[arrayOfInt2[b4]]).colok >= 33) && (this.co[arrayOfInt2[b4]]).colok < 39) { int i10 = pyn((this.co[j]).x, (this.co[arrayOfInt2[b4]]).x, (this.co[j]).z, (this.co[arrayOfInt2[b4]]).z); if (i10 >= 0 && i10 < ((this.co[j]).maxR + (this.co[arrayOfInt2[b4]]).maxR) / 100 * ((this.co[j]).maxR + (this.co[arrayOfInt2[b4]]).maxR) / 100) b3 = b4;  }  b4++; }
/* 2807 */          if (b3 != -1)
/*      */         
/* 2809 */         { for (b4 = b1; b4 > b3; ) { arrayOfInt2[b4] = arrayOfInt2[b4 - 1]; b4--; }
/* 2810 */            arrayOfInt2[b3 + 1] = j;
/* 2811 */           b1++; }
/* 2812 */         else { arrayOfInt2[b1] = j; b1++; }
/*      */       
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2818 */     for (j = 0; j < this.nob; j++) {
/*      */       
/* 2820 */       if (((this.co[j]).colok >= 16 && (this.co[j]).colok <= 25) || (this.co[j]).colok == 40 || (this.co[j]).colok == 42 || (this.co[j]).colok == 43 || (this.co[j]).colok == 45) {
/*      */         
/* 2822 */         byte b3 = -1; byte b4;
/* 2823 */         for (b4 = 0; b4 < b1; ) { if (((this.co[arrayOfInt2[b4]]).colok <= 14 || (this.co[arrayOfInt2[b4]]).colok >= 33) && (this.co[arrayOfInt2[b4]]).colok < 39) { int i10 = pyn((this.co[j]).x, (this.co[arrayOfInt2[b4]]).x, (this.co[j]).z, (this.co[arrayOfInt2[b4]]).z); if (i10 >= 0 && i10 < ((this.co[j]).maxR + (this.co[arrayOfInt2[b4]]).maxR) / 100 * ((this.co[j]).maxR + (this.co[arrayOfInt2[b4]]).maxR) / 100) { if (arrayOfInt1[arrayOfInt2[b4]] != 0) { arrayOfInt1[arrayOfInt2[b4]] = 0; if ((this.co[j]).colok != 20) { arrayOfInt1[j] = 3; } else { arrayOfInt1[j] = 5; }  }  b3 = b4; }  }  b4++; }
/* 2824 */          if (b3 == -1);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2829 */         if (b3 != -1)
/*      */         
/* 2831 */         { for (b4 = b1; b4 > b3; ) { arrayOfInt2[b4] = arrayOfInt2[b4 - 1]; b4--; }
/* 2832 */            arrayOfInt2[b3 + 1] = j;
/* 2833 */           b1++; }
/* 2834 */         else { arrayOfInt2[b1] = j; b1++; }
/*      */       
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2840 */     for (j = 0; j < this.nob; j++) {
/*      */       
/* 2842 */       if ((this.co[j]).colok == 26 || (this.co[j]).colok == 39) {
/*      */         
/* 2844 */         boolean bool1 = false;
/* 2845 */         if (Math.random() > Math.random()) { bool1 = true; if ((this.co[j]).colok == 39) if (Math.random() > Math.random()) { bool1 = false; } else if (Math.random() > Math.random()) { bool1 = false; }
/*      */               }
/* 2847 */          byte b3 = -1;
/*      */         byte b4;
/* 2849 */         for (b4 = 0; b4 < b1; b4++) {
/*      */           
/* 2851 */           if (((this.co[arrayOfInt2[b4]]).colok <= 14 || (this.co[arrayOfInt2[b4]]).colok >= 33) && (this.co[arrayOfInt2[b4]]).colok < 39) {
/*      */             
/* 2853 */             int i10 = pyn((this.co[j]).x, (this.co[arrayOfInt2[b4]]).x, (this.co[j]).z, (this.co[arrayOfInt2[b4]]).z);
/* 2854 */             if (i10 >= 0)
/*      */             {
/* 2856 */               if (i10 < ((this.co[j]).maxR + (this.co[arrayOfInt2[b4]]).maxR) / 100 * ((this.co[j]).maxR + (this.co[arrayOfInt2[b4]]).maxR) / 100) {
/*      */                 
/* 2858 */                 boolean bool2 = false;
/* 2859 */                 if ((this.co[j]).colok == 26) {
/*      */                   
/* 2861 */                   if ((this.co[j]).roofat == 90 && (this.co[arrayOfInt2[b4]]).x > (this.co[j]).x) bool2 = true; 
/* 2862 */                   if ((this.co[j]).roofat == -90 && (this.co[arrayOfInt2[b4]]).x < (this.co[j]).x) bool2 = true; 
/* 2863 */                   if ((this.co[j]).roofat == 0 && (this.co[arrayOfInt2[b4]]).z < (this.co[j]).z) bool2 = true; 
/* 2864 */                   if ((this.co[j]).roofat == 180 && (this.co[arrayOfInt2[b4]]).z > (this.co[j]).z) bool2 = true; 
/*      */                 } 
/* 2866 */                 if ((this.co[j]).colok == 39) {
/*      */                   
/* 2868 */                   if ((this.co[j]).roofat == 90 && (this.co[arrayOfInt2[b4]]).z > (this.co[j]).z) bool2 = true; 
/* 2869 */                   if ((this.co[j]).roofat == -90 && (this.co[arrayOfInt2[b4]]).z < (this.co[j]).z) bool2 = true; 
/* 2870 */                   if ((this.co[j]).roofat == 0 && (this.co[arrayOfInt2[b4]]).x > (this.co[j]).x) bool2 = true; 
/* 2871 */                   if ((this.co[j]).roofat == 180 && (this.co[arrayOfInt2[b4]]).x < (this.co[j]).x) bool2 = true; 
/*      */                 } 
/* 2873 */                 if (bool2) { if (arrayOfInt1[arrayOfInt2[b4]] == 1 && bool1) { arrayOfInt1[arrayOfInt2[b4]] = 0; arrayOfInt1[j] = 4; }  b3 = b4; }
/*      */               
/*      */               } 
/*      */             }
/*      */           } 
/*      */         } 
/* 2879 */         if (b3 != -1)
/*      */         
/* 2881 */         { for (b4 = b1; b4 > b3; ) { arrayOfInt2[b4] = arrayOfInt2[b4 - 1]; b4--; }
/* 2882 */            arrayOfInt2[b3 + 1] = j;
/* 2883 */           b1++; }
/* 2884 */         else { arrayOfInt2[b1] = j; b1++; }
/*      */       
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2891 */     for (j = 0; j < this.nob; j++) {
/*      */       
/* 2893 */       if (((this.co[j]).colok >= 55 && (this.co[j]).colok <= 65) || (this.co[j]).colok == 66) {
/*      */         
/* 2895 */         arrayOfInt2[b1] = j; b1++;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2900 */     j = 0; int k = 0, m = 0, n = 0;
/* 2901 */     this.bstage = ""; int i1;
/* 2902 */     for (i1 = 0; i1 < b1; i1++) {
/*      */       
/* 2904 */       if ((this.co[arrayOfInt2[i1]]).colok != 30 && (this.co[arrayOfInt2[i1]]).colok != 31 && (this.co[arrayOfInt2[i1]]).colok != 32 && (this.co[arrayOfInt2[i1]]).colok != 54 && (this.co[arrayOfInt2[i1]]).colok != 66) {
/*      */         
/* 2906 */         String str = "";
/* 2907 */         if (arrayOfInt1[arrayOfInt2[i1]] == 1) str = "p";  if (arrayOfInt1[arrayOfInt2[i1]] == 2) str = "pt";  if (arrayOfInt1[arrayOfInt2[i1]] == 3) str = "pr";  if (arrayOfInt1[arrayOfInt2[i1]] == 4) str = "ph";
/*      */         
/* 2909 */         if (arrayOfInt1[arrayOfInt2[i1]] == 5) str = "pl"; 
/* 2910 */         if (arrayOfInt1[arrayOfInt2[i1]] == 6) str = "pr"; 
/* 2911 */         this.bstage += "set(" + ((this.co[arrayOfInt2[i1]]).colok + 10) + "," + (this.co[arrayOfInt2[i1]]).x + "," + (this.co[arrayOfInt2[i1]]).z + "," + (this.co[arrayOfInt2[i1]]).roofat + ")" + str + "\r\n";
/*      */       } 
/*      */       
/* 2914 */       if ((this.co[arrayOfInt2[i1]]).colok == 30 || (this.co[arrayOfInt2[i1]]).colok == 32) { if ((this.co[arrayOfInt2[i1]]).roofat == 180) (this.co[arrayOfInt2[i1]]).roofat = 0;  String str = ""; if ((this.co[arrayOfInt2[i1]]).wh != 0) str = "r";  this.bstage += "chk(" + ((this.co[arrayOfInt2[i1]]).colok + 10) + "," + (this.co[arrayOfInt2[i1]]).x + "," + (this.co[arrayOfInt2[i1]]).z + "," + (this.co[arrayOfInt2[i1]]).roofat + ")" + str + "\r\n"; }
/* 2915 */        if ((this.co[arrayOfInt2[i1]]).colok == 54) { if ((this.co[arrayOfInt2[i1]]).roofat == 180) (this.co[arrayOfInt2[i1]]).roofat = 0;  String str = ""; if ((this.co[arrayOfInt2[i1]]).wh != 0) str = "r";  this.bstage += "chk(" + ((this.co[arrayOfInt2[i1]]).colok + 10) + "," + (this.co[arrayOfInt2[i1]]).x + "," + (this.co[arrayOfInt2[i1]]).z + "," + (this.co[arrayOfInt2[i1]]).roofat + "," + (this.co[arrayOfInt2[i1]]).y + ")" + str + "\r\n"; }
/* 2916 */        if ((this.co[arrayOfInt2[i1]]).colok == 31) this.bstage += "fix(" + ((this.co[arrayOfInt2[i1]]).colok + 10) + "," + (this.co[arrayOfInt2[i1]]).x + "," + (this.co[arrayOfInt2[i1]]).z + "," + (this.co[arrayOfInt2[i1]]).y + "," + (this.co[arrayOfInt2[i1]]).roofat + ")\r\n"; 
/* 2917 */       if ((this.co[arrayOfInt2[i1]]).colok == 66) this.bstage += "pile(" + (this.co[arrayOfInt2[i1]]).srz + "," + (this.co[arrayOfInt2[i1]]).srx + "," + (this.co[arrayOfInt2[i1]]).sry + "," + (this.co[arrayOfInt2[i1]]).x + "," + (this.co[arrayOfInt2[i1]]).z + ")\r\n";
/*      */       
/* 2919 */       if ((this.co[arrayOfInt2[i1]]).x + (this.co[arrayOfInt2[i1]]).maxR > j) j = (this.co[arrayOfInt2[i1]]).x + (this.co[arrayOfInt2[i1]]).maxR; 
/* 2920 */       if ((this.co[arrayOfInt2[i1]]).x - (this.co[arrayOfInt2[i1]]).maxR < m) m = (this.co[arrayOfInt2[i1]]).x - (this.co[arrayOfInt2[i1]]).maxR; 
/* 2921 */       if ((this.co[arrayOfInt2[i1]]).z + (this.co[arrayOfInt2[i1]]).maxR > k) k = (this.co[arrayOfInt2[i1]]).z + (this.co[arrayOfInt2[i1]]).maxR; 
/* 2922 */       if ((this.co[arrayOfInt2[i1]]).z - (this.co[arrayOfInt2[i1]]).maxR < n) n = (this.co[arrayOfInt2[i1]]).z - (this.co[arrayOfInt2[i1]]).maxR;
/*      */     
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2931 */     i1 = m - 0;
/* 2932 */     int i2 = j + 0;
/* 2933 */     int i3 = (int)((i2 - i1) / 4800.0F) + 1;
/* 2934 */     int i4 = (i3 * 4800 - i2 - i1) / 2;
/* 2935 */     i1 -= i4; i2 += i4;
/* 2936 */     int i5 = i1 + 2400;
/*      */     
/* 2938 */     int i6 = n - 0;
/* 2939 */     int i7 = k + 0;
/* 2940 */     int i8 = (int)((i7 - i6) / 4800.0F) + 1;
/* 2941 */     i4 = (i8 * 4800 - i7 - i6) / 2;
/* 2942 */     i6 -= i4; i7 += i4;
/* 2943 */     int i9 = i6 + 2400;
/*      */     
/* 2945 */     this.bstage += "\r\nmaxl(" + i8 + "," + i1 + "," + i9 + ")\r\nmaxb(" + i3 + "," + i6 + "," + i5 + ")\r\nmaxr(" + i8 + "," + i2 + "," + i9 + ")\r\nmaxt(" + i3 + "," + i7 + "," + i5 + ")\r\n";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void savefile() {
/*      */     try {
/* 2953 */       File file = new File("" + Madness.fpath + "mystages/"); if (!file.exists()) file.mkdirs(); 
/* 2954 */       file = new File("" + Madness.fpath + "mystages/" + this.stagename + ".txt");
/* 2955 */       BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
/* 2956 */       bufferedWriter.write(this.tstage);
/* 2957 */       bufferedWriter.write(this.bstage);
/* 2958 */       bufferedWriter.close();
/* 2959 */       bufferedWriter = null;
/*      */     } catch (Exception exception) {
/* 2961 */       JOptionPane.showMessageDialog(null, "Unable to save file! Error Deatials:\n" + exception, "Stage Maker", 1);
/* 2962 */     }  savesettings();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void renstage(String paramString) {
/* 2968 */     if (paramString.equals("")) { JOptionPane.showMessageDialog(null, "Please Enter a New Stage Name!\n", "Stage Maker", 1); }
/* 2969 */     else { try { File file1 = new File("" + Madness.fpath + "mystages/" + this.stagename + ".txt"), file2 = new File("" + Madness.fpath + "mystages/" + paramString + ".txt"); if (file1.renameTo(file2)) { this.stagename = paramString; this.sfase = 0; hidefields(); this.tabed = -2; } else { JOptionPane.showMessageDialog(null, "Unable to rename stage to: '" + paramString + "', possible reason: stage name already used!\n", "Stage Maker", 1); }  } catch (Exception exception) { JOptionPane.showMessageDialog(null, "Unable to rename file! Error Deatials:\n" + exception, "Stage Maker", 1); }
/*      */        }
/*      */   
/*      */   }
/*      */   public void delstage(String paramString) {
/*      */     
/* 2975 */     try { File file = new File("" + Madness.fpath + "mystages/" + paramString + ".txt"); file.delete(); this.slstage.remove(paramString); this.slstage.select(0); } catch (Exception exception) { JOptionPane.showMessageDialog(null, "Unable to delete file! Error Deatials:\n" + exception, "Stage Maker", 1); }
/*      */   
/*      */   }
/*      */   public void deltrack() {
/*      */     
/* 2980 */     try { File file = new File("" + Madness.fpath + "mystages/mymusic/" + this.tracks.getSelectedItem() + ".zip"); file.delete(); if (this.trackname.equals(this.tracks.getSelectedItem())) { this.trackname = ""; sortop(); savefile(); }  this.tracks.remove(this.tracks.getSelectedItem()); this.tracks.select(0); } catch (Exception exception) { JOptionPane.showMessageDialog(null, "Unable to delete file! Error Deatials:\n" + exception, "Stage Maker", 1); }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void loadsettings() {
/*      */     try {
/* 2989 */       File file = new File("" + Madness.fpath + "mystages/settings.data");
/* 2990 */       if (file.exists())
/*      */       {
/* 2992 */         BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
/* 2993 */         String str = bufferedReader.readLine();
/* 2994 */         if (str != null) this.stagename = this.sstage = str; 
/* 2995 */         str = bufferedReader.readLine();
/* 2996 */         if (str != null) { this.suser = str; if (!this.suser.equals("Horaks")) this.tnick.setText(this.suser);  }
/* 2997 */          bufferedReader.close();
/* 2998 */         bufferedReader = null;
/*      */       }
/*      */     
/* 3001 */     } catch (Exception exception) {}
/*      */   }
/*      */ 
/*      */   
/*      */   public void savesettings() {
/* 3006 */     if (!this.sstage.equals(this.stagename) || !this.suser.equals(this.tnick.getText())) {
/*      */       
/* 3008 */       String str = "" + this.stagename + "\n" + this.tnick.getText() + "\n\n";
/* 3009 */       this.sstage = this.stagename;
/* 3010 */       this.suser = this.tnick.getText();
/*      */       
/*      */       try {
/* 3013 */         File file = new File("" + Madness.fpath + "mystages/"); if (!file.exists()) file.mkdirs(); 
/* 3014 */         file = new File("" + Madness.fpath + "mystages/settings.data");
/* 3015 */         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
/* 3016 */         bufferedWriter.write(str);
/* 3017 */         bufferedWriter.close();
/* 3018 */         bufferedWriter = null;
/*      */       }
/* 3020 */       catch (Exception exception) {}
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void fixtext(TextField paramTextField) {
/* 3026 */     String str1 = paramTextField.getText(); str1 = str1.replace('"', '#'); String str2 = "\\";
/* 3027 */     String str3 = ""; byte b = 0; byte b1 = -1;
/* 3028 */     this.rd.setFont(new Font("Arial", 1, 12)); this.ftm = this.rd.getFontMetrics();
/* 3029 */     while (b < str1.length()) { String str = "" + str1.charAt(b); if (str.equals("|") || str.equals(",") || str.equals("(") || str.equals(")") || str.equals("#") || str.equals(str2) || str.equals("!") || str.equals("?") || str.equals("~") || str.equals(".") || str.equals("@") || str.equals("$") || str.equals("%") || str.equals("^") || str.equals("&") || str.equals("*") || str.equals("+") || str.equals("=") || str.equals(">") || str.equals("<") || str.equals("/") || str.equals(";") || str.equals(":") || this.ftm.stringWidth(str3) > 274) { b1 = b; } else { str3 = str3 + str; }  b++; }
/* 3030 */      if (b1 != -1) { paramTextField.setText(str3); paramTextField.select(b1, b1); }
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   public void rot(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 3036 */     if (paramInt3 != 0)
/*      */     {
/* 3038 */       for (byte b = 0; b < paramInt4; b++) {
/*      */         
/* 3040 */         int i = paramArrayOfint1[b];
/* 3041 */         int j = paramArrayOfint2[b];
/* 3042 */         paramArrayOfint1[b] = paramInt1 + (int)((i - paramInt1) * this.m.cos(paramInt3) - (j - paramInt2) * this.m.sin(paramInt3));
/* 3043 */         paramArrayOfint2[b] = paramInt2 + (int)((i - paramInt1) * this.m.sin(paramInt3) + (j - paramInt2) * this.m.cos(paramInt3));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public int xs(int paramInt1, int paramInt2) {
/* 3050 */     if (paramInt2 < this.m.cz) paramInt2 = this.m.cz; 
/* 3051 */     return (paramInt2 - this.m.focus_point) * (this.m.cx - paramInt1) / paramInt2 + paramInt1;
/*      */   }
/*      */ 
/*      */   
/*      */   public int ys(int paramInt1, int paramInt2) {
/* 3056 */     if (paramInt2 < this.m.cz) paramInt2 = this.m.cz; 
/* 3057 */     return (paramInt2 - this.m.focus_point) * (this.m.cy - paramInt1) / paramInt2 + paramInt1;
/*      */   }
/*      */ 
/*      */   
/*      */   public int py(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 3062 */     return (int)Math.sqrt(((paramInt1 - paramInt2) * (paramInt1 - paramInt2) + (paramInt3 - paramInt4) * (paramInt3 - paramInt4)));
/*      */   }
/*      */ 
/*      */   
/*      */   public int pyn(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/* 3067 */     return (paramInt1 - paramInt2) / 100 * (paramInt1 - paramInt2) / 100 + (paramInt3 - paramInt4) / 100 * (paramInt3 - paramInt4) / 100; } public String getstring(String paramString1, String paramString2, int paramInt) { int i;
/*      */     byte b;
/*      */     String str;
/* 3070 */     for (b = 0, str = "", i = paramString1.length() + 1; i < paramString2.length(); ) { String str1 = "" + paramString2.charAt(i); if (str1.equals(",") || str1.equals(")")) { b++; i++; }  if (b == paramInt) str = str + paramString2.charAt(i);  i++; }  return str; } public int getint(String paramString1, String paramString2, int paramInt) { int i; byte b; String str;
/* 3071 */     for (b = 0, str = "", i = paramString1.length() + 1; i < paramString2.length(); ) { String str1 = "" + paramString2.charAt(i); if (str1.equals(",") || str1.equals(")")) { b++; i++; }  if (b == paramInt) str = str + paramString2.charAt(i);  i++; }  return Integer.valueOf(str).intValue(); }
/* 3072 */   public Image getImage(String paramString) { Image image = Toolkit.getDefaultToolkit().createImage(paramString); MediaTracker mediaTracker = new MediaTracker(this); mediaTracker.addImage(image, 0); try { mediaTracker.waitForID(0); } catch (Exception exception) {} return image; }
/* 3073 */   public int servervalue(String paramString, int paramInt) { int i = -1; try { byte b1; byte b2; byte b3; String str1; String str2; for (b1 = 0, b2 = 0, b3 = 0, str1 = "", str2 = ""; b1 < paramString.length() && b3 != 2; ) { str1 = "" + paramString.charAt(b1); if (str1.equals("|")) { if (b3 == 1 || ++b2 > paramInt) b3 = 2;  } else if (b2 == paramInt) { str2 = str2 + str1; b3 = 1; }  b1++; }  if (str2.equals("")) str2 = "-1";  i = Integer.valueOf(str2).intValue(); } catch (Exception exception) {} return i; }
/* 3074 */   public String serverSvalue(String paramString, int paramInt) { String str = ""; try { byte b1; byte b2; byte b3; String str1; String str2; for (b1 = 0, b2 = 0, b3 = 0, str1 = "", str2 = ""; b1 < paramString.length() && b3 != 2; ) { str1 = "" + paramString.charAt(b1); if (str1.equals("|")) { if (b3 == 1 || ++b2 > paramInt) b3 = 2;  } else if (b2 == paramInt) { str2 = str2 + str1; b3 = 1; }  b1++; }  str = str2; } catch (Exception exception) {} return str; } public int getvalue(String paramString1, String paramString2, int paramInt) { int i; byte b; String str;
/* 3075 */     for (b = 0, str = "", i = paramString1.length() + 1; i < paramString2.length(); ) { String str1 = "" + paramString2.charAt(i); if (str1.equals(",") || str1.equals(")")) { b++; i++; }  if (b == paramInt) str = str + paramString2.charAt(i);  i++; }  return Float.valueOf(str).intValue(); }
/*      */ 
/*      */   
/*      */   public String getSvalue(String paramString1, String paramString2, int paramInt) {
/* 3079 */     String str = "";
/* 3080 */     byte b = 0; int i = paramString1.length() + 1;
/* 3081 */     while (i < paramString2.length() && b <= paramInt) {
/*      */       
/* 3083 */       String str1 = "" + paramString2.charAt(i);
/* 3084 */       if (str1.equals(",") || str1.equals(")")) { b++; } else if (b == paramInt) { str = str + str1; }
/* 3085 */        i++;
/*      */     } 
/* 3087 */     return str;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean button(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
/* 3092 */     this.rd.setFont(new Font("Arial", 1, 12)); this.ftm = this.rd.getFontMetrics();
/*      */ 
/*      */ 
/*      */     
/* 3096 */     int i = this.ftm.stringWidth(paramString);
/* 3097 */     boolean bool1 = false, bool2 = false;
/*      */     
/* 3099 */     if (paramString.equals(" Cancel ") && this.epart && Math.abs(this.xm - paramInt1) < i / 2 + 12 && Math.abs(this.ym - paramInt2 + 5) < 10) this.overcan = true; 
/* 3100 */     if (Math.abs(this.xm - paramInt1) < i / 2 + 12 && Math.abs(this.ym - paramInt2 + 5) < 10 && this.mouses == 1) { bool1 = true; } else { bool1 = false; }
/* 3101 */      if (Math.abs(this.xm - paramInt1) < i / 2 + 12 && Math.abs(this.ym - paramInt2 + 5) < 10 && this.mouses == -1) { this.mouses = 0; bool2 = true; }
/*      */     
/* 3103 */     boolean bool3 = false;
/*      */     
/* 3105 */     if (paramBoolean) {
/*      */       
/* 3107 */       if (this.tab == 0) this.rd.setColor(new Color(207, 207, 207)); 
/* 3108 */       if (this.tab == 1) this.rd.setColor(new Color(200, 200, 200)); 
/* 3109 */       if (this.tab == 2) this.rd.setColor(new Color(170, 170, 170)); 
/* 3110 */       if (this.tab != 3)
/*      */       
/* 3112 */       { this.rd.drawRect(paramInt1 - i / 2 - 15, paramInt2 - 22 - paramInt3, i + 29, 34 - paramInt3 * 2);
/* 3113 */         if (paramInt3 == 2 && this.tab == 1) { this.rd.setColor(new Color(220, 220, 220)); this.rd.fillRect(paramInt1 - i / 2 - 15, paramInt2 - 22 - paramInt3, i + 29, 34 - paramInt3 * 2); }  }
/* 3114 */       else { bool3 = true; }
/*      */     
/*      */     } 
/* 3117 */     if (!bool1) {
/*      */       
/* 3119 */       this.rd.setColor(new Color(220, 220, 220)); if (bool3) this.rd.setColor(new Color(230, 230, 230)); 
/* 3120 */       this.rd.fillRect(paramInt1 - i / 2 - 10, paramInt2 - 17 - paramInt3, i + 20, 25 - paramInt3 * 2);
/* 3121 */       this.rd.setColor(new Color(240, 240, 240)); if (bool3) this.rd.setColor(new Color(255, 255, 255)); 
/* 3122 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 - 17 - paramInt3);
/* 3123 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 18 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 - 18 - paramInt3);
/* 3124 */       this.rd.setColor(new Color(240, 240, 240));
/* 3125 */       this.rd.drawLine(paramInt1 - i / 2 - 9, paramInt2 - 19 - paramInt3, paramInt1 + i / 2 + 9, paramInt2 - 19 - paramInt3);
/* 3126 */       this.rd.setColor(new Color(200, 200, 200)); if (bool3) this.rd.setColor(new Color(192, 192, 192)); 
/* 3127 */       this.rd.drawLine(paramInt1 + i / 2 + 10, paramInt2 - 17 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 + 7 - paramInt3);
/* 3128 */       this.rd.drawLine(paramInt1 + i / 2 + 11, paramInt2 - 17 - paramInt3, paramInt1 + i / 2 + 11, paramInt2 + 7 - paramInt3);
/* 3129 */       this.rd.setColor(new Color(200, 200, 200));
/* 3130 */       if (bool3) this.rd.setColor(new Color(192, 192, 192)); 
/* 3131 */       this.rd.drawLine(paramInt1 + i / 2 + 12, paramInt2 - 16 - paramInt3, paramInt1 + i / 2 + 12, paramInt2 + 6 - paramInt3);
/* 3132 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 + 7 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 + 7 - paramInt3);
/* 3133 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 + 8 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 + 8 - paramInt3);
/* 3134 */       this.rd.setColor(new Color(200, 200, 200));
/* 3135 */       this.rd.drawLine(paramInt1 - i / 2 - 9, paramInt2 + 9 - paramInt3, paramInt1 + i / 2 + 9, paramInt2 + 9 - paramInt3);
/* 3136 */       this.rd.setColor(new Color(240, 240, 240)); if (bool3) this.rd.setColor(new Color(255, 255, 255)); 
/* 3137 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 - i / 2 - 10, paramInt2 + 7 - paramInt3);
/* 3138 */       this.rd.drawLine(paramInt1 - i / 2 - 11, paramInt2 - 17 - paramInt3, paramInt1 - i / 2 - 11, paramInt2 + 7 - paramInt3);
/* 3139 */       this.rd.setColor(new Color(240, 240, 240));
/* 3140 */       this.rd.drawLine(paramInt1 - i / 2 - 12, paramInt2 - 16 - paramInt3, paramInt1 - i / 2 - 12, paramInt2 + 6 - paramInt3);
/*      */       
/* 3142 */       this.rd.setColor(new Color(0, 0, 0));
/* 3143 */       if (paramString.equals("  Keyboard Controls  ")) this.rd.setColor(new Color(100, 100, 100)); 
/* 3144 */       this.rd.drawString(paramString, paramInt1 - i / 2, paramInt2);
/*      */     }
/*      */     else {
/*      */       
/* 3148 */       this.rd.setColor(new Color(220, 220, 220));
/* 3149 */       this.rd.fillRect(paramInt1 - i / 2 - 10, paramInt2 - 17 - paramInt3, i + 20, 25 - paramInt3 * 2);
/* 3150 */       this.rd.setColor(new Color(192, 192, 192));
/* 3151 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 - 17 - paramInt3);
/* 3152 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 18 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 - 18 - paramInt3);
/* 3153 */       this.rd.drawLine(paramInt1 - i / 2 - 9, paramInt2 - 19 - paramInt3, paramInt1 + i / 2 + 9, paramInt2 - 19 - paramInt3);
/* 3154 */       this.rd.setColor(new Color(247, 247, 247));
/* 3155 */       this.rd.drawLine(paramInt1 + i / 2 + 10, paramInt2 - 17 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 + 7 - paramInt3);
/* 3156 */       this.rd.drawLine(paramInt1 + i / 2 + 11, paramInt2 - 17 - paramInt3, paramInt1 + i / 2 + 11, paramInt2 + 7 - paramInt3);
/* 3157 */       this.rd.drawLine(paramInt1 + i / 2 + 12, paramInt2 - 16 - paramInt3, paramInt1 + i / 2 + 12, paramInt2 + 6 - paramInt3);
/* 3158 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 + 7 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 + 7 - paramInt3);
/* 3159 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 + 8 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 + 8 - paramInt3);
/* 3160 */       this.rd.drawLine(paramInt1 - i / 2 - 9, paramInt2 + 9 - paramInt3, paramInt1 + i / 2 + 9, paramInt2 + 9 - paramInt3);
/* 3161 */       this.rd.setColor(new Color(192, 192, 192));
/* 3162 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 - i / 2 - 10, paramInt2 + 7 - paramInt3);
/* 3163 */       this.rd.drawLine(paramInt1 - i / 2 - 11, paramInt2 - 17 - paramInt3, paramInt1 - i / 2 - 11, paramInt2 + 7 - paramInt3);
/* 3164 */       this.rd.drawLine(paramInt1 - i / 2 - 12, paramInt2 - 16 - paramInt3, paramInt1 - i / 2 - 12, paramInt2 + 6 - paramInt3);
/*      */       
/* 3166 */       this.rd.setColor(new Color(0, 0, 0));
/* 3167 */       if (paramString.equals("  Keyboard Controls  ")) this.rd.setColor(new Color(100, 100, 100)); 
/* 3168 */       this.rd.drawString(paramString, paramInt1 - i / 2 + 1, paramInt2 + 1);
/*      */     } 
/*      */     
/* 3171 */     return bool2;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean ovbutton(String paramString, int paramInt1, int paramInt2) {
/* 3176 */     this.rd.setFont(new Font("Arial", 0, 12)); this.ftm = this.rd.getFontMetrics();
/*      */     
/* 3178 */     if (paramString.equals("X") || paramString.equals("Download")) { this.rd.setFont(new Font("Arial", 1, 12)); this.ftm = this.rd.getFontMetrics(); }
/*      */     
/* 3180 */     int i = this.ftm.stringWidth(paramString);
/* 3181 */     byte b = 4;
/* 3182 */     boolean bool1 = false, bool2 = false;
/*      */     
/* 3184 */     if (Math.abs(this.xm - paramInt1) < i / 2 + 12 && Math.abs(this.ym - paramInt2 + 5) < 10 && this.mouses == 1) { bool1 = true; } else { bool1 = false; }
/* 3185 */      if (Math.abs(this.xm - paramInt1) < i / 2 + 12 && Math.abs(this.ym - paramInt2 + 5) < 10 && this.mouses == -1) { this.mouses = 0; bool2 = true; }
/*      */     
/* 3187 */     if (!bool1) {
/*      */       
/* 3189 */       this.rd.setColor(new Color(220, 220, 220));
/* 3190 */       this.rd.fillRect(paramInt1 - i / 2 - 10, paramInt2 - 17 - b, i + 20, 25 - b * 2);
/* 3191 */       this.rd.setColor(new Color(240, 240, 240));
/* 3192 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 17 - b, paramInt1 + i / 2 + 10, paramInt2 - 17 - b);
/* 3193 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 18 - b, paramInt1 + i / 2 + 10, paramInt2 - 18 - b);
/* 3194 */       this.rd.setColor(new Color(240, 240, 240));
/* 3195 */       this.rd.drawLine(paramInt1 - i / 2 - 9, paramInt2 - 19 - b, paramInt1 + i / 2 + 9, paramInt2 - 19 - b);
/* 3196 */       this.rd.setColor(new Color(200, 200, 200));
/* 3197 */       this.rd.drawLine(paramInt1 + i / 2 + 10, paramInt2 - 17 - b, paramInt1 + i / 2 + 10, paramInt2 + 7 - b);
/* 3198 */       this.rd.drawLine(paramInt1 + i / 2 + 11, paramInt2 - 17 - b, paramInt1 + i / 2 + 11, paramInt2 + 7 - b);
/* 3199 */       this.rd.setColor(new Color(200, 200, 200));
/* 3200 */       this.rd.drawLine(paramInt1 + i / 2 + 12, paramInt2 - 16 - b, paramInt1 + i / 2 + 12, paramInt2 + 6 - b);
/* 3201 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 + 7 - b, paramInt1 + i / 2 + 10, paramInt2 + 7 - b);
/* 3202 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 + 8 - b, paramInt1 + i / 2 + 10, paramInt2 + 8 - b);
/* 3203 */       this.rd.setColor(new Color(200, 200, 200));
/* 3204 */       this.rd.drawLine(paramInt1 - i / 2 - 9, paramInt2 + 9 - b, paramInt1 + i / 2 + 9, paramInt2 + 9 - b);
/* 3205 */       this.rd.setColor(new Color(240, 240, 240));
/* 3206 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 17 - b, paramInt1 - i / 2 - 10, paramInt2 + 7 - b);
/* 3207 */       this.rd.drawLine(paramInt1 - i / 2 - 11, paramInt2 - 17 - b, paramInt1 - i / 2 - 11, paramInt2 + 7 - b);
/* 3208 */       this.rd.setColor(new Color(240, 240, 240));
/* 3209 */       this.rd.drawLine(paramInt1 - i / 2 - 12, paramInt2 - 16 - b, paramInt1 - i / 2 - 12, paramInt2 + 6 - b);
/*      */       
/* 3211 */       this.rd.setColor(new Color(0, 0, 0));
/* 3212 */       if (paramString.equals("X")) this.rd.setColor(new Color(255, 0, 0)); 
/* 3213 */       if (paramString.equals("Download")) this.rd.setColor(new Color(0, 64, 128)); 
/* 3214 */       this.rd.drawString(paramString, paramInt1 - i / 2, paramInt2);
/*      */     }
/*      */     else {
/*      */       
/* 3218 */       this.rd.setColor(new Color(220, 220, 220));
/* 3219 */       this.rd.fillRect(paramInt1 - i / 2 - 10, paramInt2 - 17 - b, i + 20, 25 - b * 2);
/* 3220 */       this.rd.setColor(new Color(192, 192, 192));
/* 3221 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 17 - b, paramInt1 + i / 2 + 10, paramInt2 - 17 - b);
/* 3222 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 18 - b, paramInt1 + i / 2 + 10, paramInt2 - 18 - b);
/* 3223 */       this.rd.drawLine(paramInt1 - i / 2 - 9, paramInt2 - 19 - b, paramInt1 + i / 2 + 9, paramInt2 - 19 - b);
/* 3224 */       this.rd.setColor(new Color(247, 247, 247));
/* 3225 */       this.rd.drawLine(paramInt1 + i / 2 + 10, paramInt2 - 17 - b, paramInt1 + i / 2 + 10, paramInt2 + 7 - b);
/* 3226 */       this.rd.drawLine(paramInt1 + i / 2 + 11, paramInt2 - 17 - b, paramInt1 + i / 2 + 11, paramInt2 + 7 - b);
/* 3227 */       this.rd.drawLine(paramInt1 + i / 2 + 12, paramInt2 - 16 - b, paramInt1 + i / 2 + 12, paramInt2 + 6 - b);
/* 3228 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 + 7 - b, paramInt1 + i / 2 + 10, paramInt2 + 7 - b);
/* 3229 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 + 8 - b, paramInt1 + i / 2 + 10, paramInt2 + 8 - b);
/* 3230 */       this.rd.drawLine(paramInt1 - i / 2 - 9, paramInt2 + 9 - b, paramInt1 + i / 2 + 9, paramInt2 + 9 - b);
/* 3231 */       this.rd.setColor(new Color(192, 192, 192));
/* 3232 */       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 17 - b, paramInt1 - i / 2 - 10, paramInt2 + 7 - b);
/* 3233 */       this.rd.drawLine(paramInt1 - i / 2 - 11, paramInt2 - 17 - b, paramInt1 - i / 2 - 11, paramInt2 + 7 - b);
/* 3234 */       this.rd.drawLine(paramInt1 - i / 2 - 12, paramInt2 - 16 - b, paramInt1 - i / 2 - 12, paramInt2 + 6 - b);
/*      */       
/* 3236 */       this.rd.setColor(new Color(0, 0, 0));
/* 3237 */       if (paramString.equals("X")) this.rd.setColor(new Color(255, 0, 0)); 
/* 3238 */       if (paramString.equals("Download")) this.rd.setColor(new Color(0, 64, 128)); 
/* 3239 */       this.rd.drawString(paramString, paramInt1 - i / 2 + 1, paramInt2 + 1);
/*      */     } 
/*      */     
/* 3242 */     return bool2;
/*      */   }
/*      */   
/*      */   public void openlink() {
/* 3246 */     Madness.openurl("http://www.needformadness.com/developer/help.html"); } public void openhlink() {
/* 3247 */     Madness.openurl("http://www.needformadness.com/developer/");
/*      */   }
/*      */ }


/* Location:              /home/naglis/Desktop/Need-for-Madness/Need for Madness/Game.jar!/StageMaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */