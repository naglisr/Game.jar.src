 import java.applet.Applet;
 import java.awt.AlphaComposite;
 import java.awt.Color;
 import java.awt.Component;
 import java.awt.Cursor;
 import java.awt.Event;
 import java.awt.FileDialog;
 import java.awt.Font;
 import java.awt.FontMetrics;
 import java.awt.Frame;
 import java.awt.Graphics;
 import java.awt.Graphics2D;
 import java.awt.Image;
 import java.awt.LayoutManager;
 import java.awt.MediaTracker;
 import java.awt.MenuItem;
 import java.awt.PopupMenu;
 import java.awt.RenderingHints;
 import java.awt.TextArea;
 import java.awt.TextField;
 import java.awt.Toolkit;
 import java.awt.datatransfer.DataFlavor;
 import java.awt.datatransfer.StringSelection;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.awt.image.ImageObserver;
 import java.io.BufferedReader;
 import java.io.BufferedWriter;
 import java.io.ByteArrayInputStream;
 import java.io.DataInputStream;
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileReader;
 import java.io.FileWriter;
 import java.io.InputStreamReader;
 import java.io.PrintWriter;
 import java.net.Socket;
 import java.net.URL;
 import java.util.zip.ZipEntry;
 import java.util.zip.ZipInputStream;
 import javax.swing.JOptionPane;
 
 
 public class CarMaker
   extends Applet
   implements Runnable, ActionListener
 {
   Graphics2D rd;
   Image offImage;
   Thread thredo;
   boolean exwist = false;
   FontMetrics ftm;
   int apx = 0; int apy = 0;
   boolean focuson = true;
   Image[] btgame = new Image[2];
   
   Image logo;
   boolean onbtgame = false;
   int tab = 0; int tabed = -1;
   boolean loadedfile = false;
   String carname = "";
 
 
   
   String scar = "";
   String suser = "Horaks";
   String sfont = "Monospaced";
   int sthm = 0;
 
 
   
   int sfase = 0;
   Smenu slcar = new Smenu(2000);
   boolean tutok = false;
   int flk = 0;
   
   boolean changed = false;
   
   String lastedo = ""; boolean prefs = false;
   boolean mirror = false;
   PopupMenu popupMenu;
   TextArea editor = new TextArea(20, 20);
   TextField srch = new TextField("", 15);
   TextField rplc = new TextField("", 15);
   Smenu fontsel = new Smenu(40);
   String cfont = "Monospaced";
   Smenu ctheme = new Smenu(40); Color defb;
   Color deff;
   int cthm = 0; int cntprf = 0; int cntpls = 0; int cntchk = 0; int npolys = 0;
   
   boolean tomany = false;
   
   int ox = 335;
   int oy = 40;
   int oz = 800;
   int oxz = -90;
   int oxy = 0;
   int ozy = 0;
   Medium m = new Medium();
   Trackers t = new Trackers();
   ContO o;
   ContO[] compo = new ContO[16]; boolean right = false, left = false, up = false, down = false;
   boolean rotl = false, rotr = false, plus = false, minus = false, in = false, out = false;
   boolean pflk = false;
   boolean breakbond = false;
   int polynum = -1, prflk = 0, bfo = 0;
   int dtab = 0; int dtabed = -1; int mouseon = -1;
   String fcol = ""; String ofcol = ""; String scol = ""; String oscol = "";
   float[] fhsb = new float[] { 0.5F, 0.5F, 0.5F };
   float[] shsb = new float[] { 0.5F, 0.5F, 0.5F };
   int[] scale = new int[] { 100, 100, 100 };
   int[] oscale = new int[] { 100, 100, 100 };
   Smenu compcar = new Smenu(40);
   int compsel = 0;
   int[] adna = new int[] { 276, 276, 276, 276, 276, 276 };
   boolean changed2 = false;
   TextField[] wv = new TextField[16];
   boolean defnow = false;
   String aply1 = ""; String aply2 = "";
   boolean aplyd1 = false, aplyd2 = false;
   boolean forwheels = false;
   Smenu cls = new Smenu(40);
   Smenu simcar = new Smenu(40);
   int[] stat = new int[] { 100, 100, 100, 100, 100 };
   int[] rstat = new int[] { 0, 0, 0, 0, 0 };
   int[][] carstat = new int[][] { { 110, 81, 131, 98, 100 }, { 200, 200, 88, 16, 16 }, { 108, 80, 93, 114, 125 }, { 146, 119, 100, 83, 72 }, { 109, 85, 141, 96, 93 }, { 128, 98, 102, 109, 123 }, { 115, 139, 96, 117, 133 }, { 120, 81, 145, 126, 128 }, { 140, 122, 101, 113, 124 }, { 110, 144, 100, 154, 92 }, { 133, 122, 144, 115, 126 }, { 107, 96, 96, 192, 189 }, { 192, 200, 106, 92, 90 }, { 88, 104, 88, 200, 200 }, { 148, 150, 197, 95, 90 }, { 112, 128, 120, 192, 128 } };
   int carsel = 0; int clsel = 0;
   boolean statdef = false;
   int pfase = 0;
   int[] phys = new int[] { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
   int[] rphys = new int[] { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
   int[] crash = new int[] { 50, 50, 50 };
   int[] rcrash = new int[] { 50, 50, 50 };
   String[] pname = new String[] { "Handbrake", "Turning Sensitivity", "Tire Grip", "Bouncing", "Empty", "Lifts Others", "Gets Lifted", "Pushes Others", "Gets Pushed", "Aerial Rotation Speed", "Aerial Control/Gliding" };
   int[] pnx = new int[] { 62, 20, 76, 71, 60, 38, 44, 20, 33, 320, 324 };
   String[] usage = new String[] { "Handbrake:\nThis defines the hand braking power of the car.\nThe more handbrake the car has the faster it brakes when you press Spacebar while driving.\nBut also the lesser the Handbrake the more the car can drift when you press Spacebar.\n\n", "Turning Sensitivity:\nThis defines how fast the car turns (or how fast the wheels respond to turning).\nThe more turning sensitive the faster the car turns and responds.\n\nWhen designing a fast car that is more racing oriented high turning sensitivity is     \nrecommended for the car to be able to take sharp and quick turns.\nHowever too much turning sensitivity can make the car hard to drive!\n\nWhen designing a slower and bigger car (like El King) lower turning sensitivity is\nrecommended for a more realistic effect.\n\n", "Tires Grip:\nThis defines the griping power of the car’s wheels on the ground.\n\nThe more griping the more the cars sticks to track.\nThe less gripping the more the car drifts in the turns.\n\nSome drifting can be helpful as it makes the car drive smoother while less drifting can\nmake the car more irritable, it depends on how you like to drive the car and how it\nfeels for you.\n\n", "Bouncing:\nThis defines how the car bounces back when it hits the ground or obstacles.\n\nBouncing can help when performing stunts as when you land up side down\nif the car bounces it can be filliped over before landing again to avoid a 'bad landing'.\n\nHowever bouncing is not helpful in controlling the car and in racing.\n\n", "If you can read this then you are decompiling the code! Please don’t bother trying to allow the car maker to give you max stats, the stats get check on the server before the car can be accepted. Just to save you sometime.", "Lifts Others:\nThis defines if the car lifts up other cars when it collides with them from the front and\nhow high it can lift them.\n\nDoes the car have a pointy nose like MAX Revenge, Radical One or La Vita Crab, a\npointy nose/front part that can go under the wheels of other cars and lift them?\nIf so then give it some Lifts Others.\n\nIf it has a nose/front part that is a block like most cars then give it 0 Lifts Others.\n\n", "Gets Lifted:\nThis defines if the car can get lifted over other cars when it collides with them and how\nhigh it can get lifted.\n\nIs the car higher off the ground like Wow Caninaro or has big wheels like Dr Monstaa,\nshould its jump over cars when it collides with them?\nIf so then give it some Gets Lifted depending on how high it should go.\n\nIf the car is lower to the ground like most cars then it should have 0 Gets Lifted\n\n", "Pushes Others:\nThis defines if the car pushes other cars away when it collides with them and how far it\ncan push them.\n\nIs the car a heavy car with a strong body like MASHEEN or El King, where when it\ncollides with other cars it pushes them away?\nOr does the car have special bumpers or body parts for pushing cars away like Sword of\nJustice has?\nIf so then give it some Pushes Others depending how strong you think it can push cars.\n\nIf it is a car like any other car, with an average weight and body strength then you should\ngive it 0 Pushes Others.\n\n", "Gets Pushed:\nThis defines if the car gets pushed away when it collides with other cars and how far it\ngets pushed away.\n\nIf the car is lighter then most cars, then it should get pushed away when it collides with\nothers cars.\nGetting pushed can be helpful if the car is week because it gets it away from the danger\n(from the car that hit it) faster, making it take lesser hits and escape better.\nHowever getting pushed is not helpful when racing.\n\n", "Aerial Rotation Speed:\nThis adjusts how fast the car can rotate and flip in the air when its performing a stunt.\n\nThis variable also depends on how much the ‘Stunts’ stat of the car is, if the car has a\nhigh Stunts stat then this variable will have a much bigger effect, if it has low Stunts stat\nthe variable will have a lower effect.\n\nIf you think the car is rotating too fast or too slow in the air when performing a stunt use\nthis variable to adjust that.\n\nIf the aerial rotation is too fast it can make the car hard to control in the air as it flips and\nhard to land upright.\n\nIf the car is a big and heavy car like MASHHEN or El King then it should have low\naerial rotation for a realistic effect.\n\n", "Aerial Control/Gliding:\nThis adjusts the cars ability to push itself in the air and glide when performing stunts!\n\nIf you don’t know, in the game:\nBackward looping pushes the car upwards. \nForward looping pushes the car forwards. \nLeft and right rolling pushes the car left and right. \n\nThis variable adjust the power if this aerial push.\n\nThe variable also depends on how much the ‘Stunts’ stat of the car is, if the car has a\nhigh Stunts stat then this variable will have a much bigger effect, if it has low Stunts stat\nthe variable will have a lower effect.\n\nIf the car has some kind of wings or fins like Radical One or Kool Kat have then it should\nhave higher aerial control and gliding ability.\n\n", "Crash Look Test!\nThis defines how the car will look when it gets damaged.\nOr in other words what the car will look like as it gets damaged until it becomes wasted!\n\nIMPORTANT:\nYou need to perform a 'Normal Crash' test with a 'Roof Crash' test until the car gets totally destroyed (gets wasted and burns).\nYou need to also try a 'Normal Crash' test alone (without the roof crash) until the car gets wasted!\nA 'Roof Crash' happens significantly more when the car falls on its roof from a high jumps.\nA 'Normal Crash' is what happens as the car crashes normally with other cars and obstacles.\n\nClick any of adjustment variable names ‘Radius’, ‘Magnitude’ and ‘Roof Destruction’ to learn about their effect.\n\n>  You must perform the crash test more then once in order to make sure that this is how your want the car to look as it gets damaged\nuntil total destruction.", "Crash Radius:\nThe radius around the crash at which the polygons/pieces that lay inside it get\naffected.\n\nOr basically in other words the number of pieces that get affected on collision (the pieces\naround the crash location).\n\nIncreasing the radius will result in more pieces/polygons around the point of collision\ngetting crashed and distorted.\nDecreasing the radius means less pieces/polygons around the collision point getting\ndistorted and crashed.\n\n", "Crash Magnitude:\nThe magnitude of the distortion and indentation to occur on the effected pieces/polygons.\n\nOr basically in other words the amount of destruction that happens to each piece when\ncrashed.\n\nHigher magnitude means the piece gets more destructed from an amount of damage,\nlower magnitude means the piece gets less destructed from that same amount of damage.\n\n", "Roof Destruction:\nThe amount of destruction to occur on the car’s top.\nThe length of indentation and destruction to happen from above.\n\nTo really see this variable's effect try crashing the roof alone (without a normal crash),\ntry more then once while fixing the car and changing the variable’s value to see the\ndifference.\n\nThe roof crash normally happens in the game when the car lands upside down from a\njump or when a big car like Dr Monstaa steps on it.\n\n" };
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
   
   int hitmag = 0, actmag = 0;
   int squash = 0; boolean crashok = false;
   boolean crashleft = false;
   soundClip[] crashs = new soundClip[3];
   soundClip[] lowcrashs = new soundClip[3];
   Smenu engine = new Smenu(40);
   soundClip[][] engs = new soundClip[5][5];
   int engsel = 0;
   boolean engon = false;
   Smenu witho = new Smenu(40); boolean tested = false;
   boolean rateh = false;
   int handling = 140;
 
 
   
   int logged = 0;
   TextField tnick = new TextField("", 15);
   TextField tpass = new TextField("", 15);
   Smenu pubitem = new Smenu(707);
   Smenu pubtyp = new Smenu(40);
   int nmc = 0; int roto = 0;
   String[] mycars = new String[20];
   String[] maker = new String[20];
   int[] pubt = new int[20];
   int[] clas = new int[20];
   String[][] addeda = new String[20][5000];
   int[] nad = new int[20];
   String justpubd = "";
 
   
   boolean[] pessd = new boolean[] { false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, 
       false, false, false, false }; int[] bx = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   int[] by = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   int[] bw = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   int btn = 0;
   int mouses = 0, xm = 0, ym = 0;
 
 
   
   public void run() {
     this.thredo.setPriority(10);
     
     this.btgame[0] = getImage("" + Madness.fpath + "data/backtogame1.gif");
     this.btgame[1] = getImage("" + Madness.fpath + "data/backtogame2.gif");
     this.logo = getImage("" + Madness.fpath + "data/carmakerlogo.gif");
     
     this.m.w = 700;
     this.m.cx = 350;
     this.m.y = -240;
     this.m.z = -400;
     this.m.zy = 4;
     this.m.focus_point = 800;
     this.m.fadfrom(8000);
     this.m.cfade[0] = 187;
     this.m.cfade[1] = 210;
     this.m.cfade[2] = 227;
     loadsounds();
     loadbase();
     this.m.loadnew = true;
     
     loadsettings();
     this.editor.setFont(new Font(this.cfont, 1, 14));
     this.srch.setFont(new Font(this.cfont, 1, 14));
     this.rplc.setFont(new Font(this.cfont, 1, 14)); byte b;
     for (b = 0; b < 16; ) { this.wv[b].setFont(new Font(this.cfont, 1, 14)); b++; }
      setheme();
     
     if (Madness.testdrive != 0) {
       
       if (Madness.testcar.equals("Failx12")) {
         JOptionPane.showMessageDialog(null, "Failed to load car! Please make sure car is saved before Test Drive.", "Car Maker", 1);
         this.thredo.stop();
       } else {
         this.carname = Madness.testcar;
         loadfile();
         if (this.loadedfile) { this.tested = true; this.tab = 2; this.dtab = 6; this.witho.select(Madness.testdrive - 1); }
       
       }  Madness.testcar = "";
       Madness.testdrive = 0;
     } 
     
     b = 0;
     if (!this.carname.equals("")) { this.tutok = true; b = 1; }
     
     while (!this.exwist) {
 
       
       if (this.tab != this.tabed) {
         
         hidefields();
         if (this.tab == 1) { this.editor.enable(); } else { this.editor.disable(); }
          if (this.tabed == 2) if (!this.breakbond) { if (!this.editor.getText().equals(this.lastedo)) this.editor.setText(this.lastedo);  } else { this.breakbond = false; }
             setCursor(new Cursor(0));
       } 
       
       this.rd.setColor(new Color(225, 225, 225));
       this.rd.fillRect(0, 0, 700, 550);
       this.rd.setColor(new Color(0, 0, 0));
       this.btn = 0;
       
       byte b1 = 50;
       
       if (this.tab == 0) {
 
         
         if (this.tabed != this.tab) {
           
           this.slcar.removeAll();
           this.slcar.maxl = 200;
           this.slcar.add(this.rd, "Select a Car                      ");
           String[] arrayOfString1 = (new File("" + Madness.fpath + "mycars/")).list();
           if (arrayOfString1 != null) for (byte b7 = 0; b7 < arrayOfString1.length; ) { if (arrayOfString1[b7].toLowerCase().endsWith(".rad")) this.slcar.add(this.rd, arrayOfString1[b7].substring(0, arrayOfString1[b7].length() - 4));  b7++; }
               if (this.carname.equals("")) { this.slcar.select(0); } else { this.slcar.select(this.carname); if (this.carname.equals(this.slcar.getSelectedItem())) loadfile();  }
            this.mouseon = -1;
           this.srch.setText("");
           this.sfase = 0;
         } 
         
         this.rd.setFont(new Font("Arial", 1, 13));
         this.rd.setColor(new Color(0, 0, 0));
         
         this.rd.drawImage(this.logo, 214, 35, (ImageObserver)null);
         if (this.xm > 214 && this.xm < 485 && this.ym > 25 && this.ym < 104 && !this.openm) { if (this.mouseon == -1) { this.mouseon = 3; setCursor(new Cursor(12)); }  } else if (this.mouseon == 3) { this.mouseon = -1; setCursor(new Cursor(0)); }
          if (this.mouseon == 3 && this.mouses == -1) openhlink();
         
         char c = '\036';
         byte b4 = 0;
         if (this.tutok) { c = 'ú'; b4 = -70; }
         
         if (this.xm > 76 && this.xm < 624 && this.ym > 84 + c && this.ym < 167 + c && !this.openm) { if (this.mouseon == -1) { this.mouseon = 1; setCursor(new Cursor(12)); }  } else if (this.mouseon == 1) { this.mouseon = -1; setCursor(new Cursor(0)); }
          byte b5 = 0;
         if (!this.tutok && this.mouseon != 1 && b == 0) if (this.flk <= 0) { this.rd.setColor(new Color(255, 0, 0)); this.flk--; if (this.flk == -2) this.flk = 1;  } else { this.rd.setColor(new Color(0, 0, 255)); b5 = 2; this.flk++; if (this.flk == 3) this.flk = 0;  }
             this.rd.drawLine(76 + b5, 84 + c, 76 + b5, 167 + c); this.rd.drawLine(76 + b5, 84 + c, 95 + b5, 84 + c); this.rd.drawLine(76 + b5, 167 + c, 95 + b5, 167 + c);
         this.rd.drawLine(624 - b5, 84 + c, 624 - b5, 167 + c); this.rd.drawLine(624 - b5, 84 + c, 605 - b5, 84 + c); this.rd.drawLine(624 - b5, 167 + c, 605 - b5, 167 + c);
         if (this.mouseon == 1) { this.rd.setColor(new Color(0, 64, 128)); } else { this.rd.setColor(new Color(0, 0, 0)); }
          this.rd.drawString("If this is your first time creating a car please follow the tutorial found at:", 106, 110 + c);
         this.rd.setColor(new Color(0, 128, 255));
         this.rd.drawString("http://www.needformadness.com/developer/simplecar.html", 106, 130 + c);
         if (this.mouseon == 1) { this.rd.setColor(new Color(0, 128, 255)); } else { this.rd.setColor(new Color(0, 64, 128)); }
          this.rd.drawLine(106, 131 + c, 480, 131 + c);
         if (this.mouseon == 1) { this.rd.setColor(new Color(0, 64, 128)); } else { this.rd.setColor(new Color(0, 0, 0)); }
          this.rd.drawString("It is highly recommended that you follow this tutorial before trying anything!", 106, 150 + c);
         if (this.mouseon == 1 && this.mouses == -1) { openlink(); b = 1; }
         
         if (this.xm > 200 && this.xm < 500 && this.ym > 467 && this.ym < 504 && !this.openm) { if (this.mouseon == -1) { this.mouseon = 2; setCursor(new Cursor(12)); }  } else if (this.mouseon == 2) { this.mouseon = -1; setCursor(new Cursor(0)); }
          this.ftm = this.rd.getFontMetrics();
         if (this.mouseon == 2) { this.rd.setColor(new Color(0, 64, 128)); } else { this.rd.setColor(new Color(0, 0, 0)); }
          this.rd.drawString("For the Car Maker Homepage, Development Center and Forums :", 350 - this.ftm.stringWidth("For the Car Maker Homepage, Development Center and Forums :") / 2, 480);
         this.rd.setColor(new Color(0, 128, 255));
         String str = "http://www.needformadness.com/developer/";
         this.rd.drawString(str, 350 - this.ftm.stringWidth(str) / 2, 500);
         if (this.mouseon == 2) { this.rd.setColor(new Color(0, 128, 255)); } else { this.rd.setColor(new Color(0, 64, 128)); }
          this.rd.drawLine(350 - this.ftm.stringWidth(str) / 2, 501, 350 + this.ftm.stringWidth(str) / 2, 501);
         if (this.mouseon == 2 && this.mouses == -1) openhlink();
         
         byte b6 = 0;
         if (this.sfase == 3) b6 = 100; 
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawRect(177 - b6, 202 + b4, 346 + b6 * 2, 167 + b6 / 5);
         
         if (this.sfase == 0) {
           
           this.rd.drawString("Select Car to Edit", 350 - this.ftm.stringWidth("Select Car to Edit") / 2, 230 + b4);
           this.slcar.move(250, 240 + b4); if (this.slcar.getWidth() != 200) this.slcar.setSize(200, 21); 
           if (!this.slcar.isShowing()) this.slcar.show(); 
           stringbutton("    Make new Car    ", 430, 296 + b4, 0, true);
           stringbutton("     Rename Car     ", 270, 296 + b4, 0, false);
           stringbutton("      Delete Car      ", 270, 336 + b4, 0, false);
           stringbutton("     Import & Export     ", 430, 336 + b4, 0, false);
           
           if (this.slcar.getSelectedIndex() != 0)
           
           { if (!this.carname.equals(this.slcar.getSelectedItem())) { this.tomany = false; this.carname = this.slcar.getSelectedItem(); loadfile(); this.editor.select(0, 0); this.tested = false; requestFocus(); }  }
           else { this.carname = ""; }
         
         } 
         
         if (this.sfase == 1) {
           
           this.rd.drawString("Make a new Car", 350 - this.ftm.stringWidth("Make a new Car") / 2, 230 + b4);
           this.rd.setFont(new Font("Arial", 1, 12));
           this.rd.drawString("New car name :", 228, 266 + b4);
           movefield(this.srch, 335, 250 + b4, 129, 22); if (!this.srch.isShowing()) { this.srch.show(); this.srch.requestFocus(); }
            fixtext(this.srch);
           stringbutton("    Make Car    ", 350, 306 + b4, 0, true);
           stringbutton("  Cancel  ", 350, 346 + b4, 0, false);
         } 
         
         if (this.sfase == 2) {
           
           this.rd.drawString("Rename Car :  " + this.carname + "", 350 - this.ftm.stringWidth("Rename Car :  " + this.carname + "") / 2, 230 + b4);
           this.rd.setFont(new Font("Arial", 1, 12));
           this.rd.drawString("New name :", 239, 266 + b4);
           movefield(this.srch, 316, 250 + b4, 129, 22); if (!this.srch.isShowing()) { this.srch.show(); this.srch.requestFocus(); }
            fixtext(this.srch);
           stringbutton("   Rename Car   ", 350, 306 + b4, 0, true);
           stringbutton("  Cancel  ", 350, 346 + b4, 0, false);
         } 
         
         if (this.sfase == 3) {
           
           this.rd.drawString("Import a Wavefront OBJ 3D Model", 350 - this.ftm.stringWidth("Import a Wavefront OBJ 3D Model") / 2, 230 + b4);
           
           if (this.xm > 116 && this.xm < 584 && this.ym > 246 + b4 && this.ym < 290 + b4) { if (this.mouseon == -1) { this.mouseon = 3; setCursor(new Cursor(12)); }  } else if (this.mouseon == 3) { this.mouseon = -1; setCursor(new Cursor(0)); }
            this.ftm = this.rd.getFontMetrics();
           if (this.mouseon == 3) { this.rd.setColor(new Color(0, 64, 128)); } else { this.rd.setColor(new Color(0, 0, 0)); }
            this.rd.drawString("Please read the important information about importing cars found at:", 350 - this.ftm.stringWidth("Please read the important information about importing cars, found here :") / 2, 260 + b4);
           this.rd.setColor(new Color(0, 128, 255));
           str = "http://www.needformadness.com/developer/extras.html";
           this.rd.drawString(str, 350 - this.ftm.stringWidth(str) / 2, 280 + b4);
           if (this.mouseon == 3) { this.rd.setColor(new Color(0, 128, 255)); } else { this.rd.setColor(new Color(0, 64, 128)); }
            this.rd.drawLine(350 - this.ftm.stringWidth(str) / 2, 281 + b4, 350 + this.ftm.stringWidth(str) / 2, 281 + b4);
           if (this.mouseon == 3 && this.mouses == -1) openelink();
           
           stringbutton("     Import Car     ", 350, 326 + b4, 0, true);
           stringbutton("  Export >  ", 550, 326 + b4, 0, false);
           
           stringbutton("  Cancel  ", 350, 366 + b4, 0, false);
         } 
 
         
         if (this.sfase == 4) {
           
           this.rd.drawString("Select Car to Export", 350 - this.ftm.stringWidth("Select Car to Export") / 2, 230 + b4);
           this.slcar.move(250, 240 + b4); if (this.slcar.getWidth() != 200) this.slcar.setSize(200, 21); 
           if (!this.slcar.isShowing()) this.slcar.show(); 
           stringbutton("     Export Car     ", 350, 306 + b4, 0, true);
           stringbutton("  Cancel  ", 350, 346 + b4, 0, false);
           if (this.slcar.getSelectedIndex() != 0) { if (!this.carname.equals(this.slcar.getSelectedItem())) { this.tomany = false; this.carname = this.slcar.getSelectedItem(); loadfile(); this.editor.select(0, 0); this.tested = false; requestFocus(); }  } else { this.carname = ""; }
         
         } 
       } 
 
       
       if (this.tab == 1) {
         
         if (this.tabed != this.tab) {
           
           this.srch.setText("");
           this.rplc.setText("");
           this.cntchk = 1;
           this.npolys = 0;
           this.prefs = false;
         } 
         
         movefield(this.editor, 5, 30, 690, 400);
         if (!this.openm) { if (!this.editor.isShowing()) { this.editor.show(); this.editor.requestFocus(); }  } else if (this.editor.isShowing()) { this.editor.hide(); }
         
         this.rd.setFont(new Font("Arial", 1, 12));
         
         if (this.prefs) {
           
           this.rd.drawString("Code Font:", 10, 446);
           this.fontsel.move(76, 430);
           if (!this.fontsel.isShowing()) { this.fontsel.show(); this.fontsel.select(this.cfont); }
            if (!this.cfont.equals(this.fontsel.getSelectedItem())) { this.cntprf = 0; this.cfont = this.fontsel.getSelectedItem(); this.editor.setFont(new Font(this.cfont, 1, 14)); this.srch.setFont(new Font(this.cfont, 1, 14)); this.rplc.setFont(new Font(this.cfont, 1, 14)); for (byte b4 = 0; b4 < 16; ) { this.wv[b4].setFont(new Font(this.cfont, 1, 14)); b4++; }  this.editor.requestFocus(); }
           
           this.rd.drawString("Code Theme:", 190, 446);
           this.ctheme.move(271, 430);
           if (!this.ctheme.isShowing()) { this.ctheme.show(); this.ctheme.select(this.cthm); }
            if (this.cthm != this.ctheme.getSelectedIndex()) { this.cntprf = 0; this.cthm = this.ctheme.getSelectedIndex(); setheme(); this.editor.requestFocus(); }
           
           stringbutton("<", 400, 446, 3, false);
           this.cntprf++; if (this.cntprf == 200) this.prefs = false;
         
         } else {
           
           stringbutton("Preferences", 52, 446, 3, false);
           if (this.ctheme.isShowing()) this.ctheme.hide(); 
           if (this.fontsel.isShowing()) this.fontsel.hide(); 
           if (this.cntprf != 0) this.cntprf = 0;
           
           if (this.cntchk == 0)
           
           { this.npolys = 0;
             int i = 0;
             boolean bool = false;
             while (i != -1 && this.mouses != 1) {
               
               if (!bool) { i = this.editor.getText().indexOf("<p>", i); } else { i = this.editor.getText().indexOf("</p>", i); }
                if (i != -1) { if (!bool) { bool = true; } else { bool = false; this.npolys++; }  i += 3; }
             
             }  if (this.mouses == 1) this.npolys = 0; 
             this.cntchk = 30; }
           else { this.cntchk--; }
           
           if (this.npolys > 210) this.rd.setColor(new Color(255, 0, 0)); 
           if (this.npolys != 0) this.rd.drawString("Number of Polygons :  " + this.npolys + " / 210", 200, 446);
         
         } 
         if (!this.changed && !this.editor.getText().equals(this.lastedo)) this.changed = true;
         
         stringbutton("  Save  ", 490, 455, 0, this.changed);
         stringbutton("  Save & Preview  >  ", 600, 455, 0, this.changed);
         
         this.mirror = false;
         this.polynum = -1; this.cntpls = 0;
         String str = ""; 
         try { str = this.editor.getSelectedText(); } catch (Exception exception) {}
         if (!str.equals("")) {
           
           int i = str.indexOf("<p>", 0);
           while (i != -1 && i + 1 < str.length()) {
             
             if (!this.mirror) { i = str.indexOf("</p>", i + 1); if (i != -1) { this.mirror = true; this.cntpls++; }  }
              if (this.mirror) { i = str.indexOf("<p>", i + 1); if (i != -1) this.mirror = false;
                }
           
           } 
         } 
         if (!this.mirror) {
           
           this.rd.setColor(new Color(170, 170, 170));
           this.rd.drawRect(5, 474, 494, 70);
           this.rd.setColor(new Color(0, 0, 0));
           this.rd.drawString("Text to find:", 18, 500);
           movefield(this.srch, 91, 484, 129, 22);
           if (!this.srch.isShowing()) this.srch.show(); 
           boolean bool = false; if (!this.srch.getText().equals("")) bool = true; 
           stringbutton(" Find ", 117, 526, 2, bool);
           this.rd.drawString("Replace with:", 255, 500);
           movefield(this.rplc, 338, 484, 129, 22);
           if (!this.rplc.isShowing()) this.rplc.show(); 
           bool = false; if (!this.srch.getText().equals("") && !this.rplc.getText().equals("")) bool = true; 
           stringbutton(" Replace ", 376, 526, 2, bool);
         }
         else {
           
           if (this.srch.isShowing()) this.srch.hide(); 
           if (this.rplc.isShowing()) this.rplc.hide(); 
           this.rd.setColor(new Color(170, 170, 170));
           this.rd.drawRect(5, 474, 450, 70);
           this.rd.setColor(new Color(0, 0, 0));
           this.rd.drawString("Mirror [Selected] polygon(s) along:", 18, 490);
           stringbutton(" Mirro Along X Axis ", 90, 525, 2, true);
           stringbutton(" Mirro Along Y Axis ", 230, 525, 2, false);
           stringbutton(" Mirro Along Z Axis ", 370, 525, 2, false);
           
           this.rd.setColor(new Color(170, 170, 170));
           this.rd.drawRect(465, 474, 230, 70);
           this.rd.setColor(new Color(0, 0, 0));
           this.rd.drawString("Show [Selected] polygon(s):", 478, 490);
           stringbutton(" Show in 3D  > ", 580, 523, 0, true);
         } 
 
 
         
         if (this.npolys > 210 && !this.tomany) { repaint(); JOptionPane.showMessageDialog(null, "Maximum number of polygons (pieces) allowed has been exceeded!\nThe maximum allowed is 210 polygons, please decrease.\n", "Car Maker", 1); this.tomany = true; }
       
       } 
 
       
       if (this.tab == 2) {
         
         if (this.tabed != this.tab) {
           
           setupo();
           this.dtabed = -1;
         } 
         
         this.m.d(this.rd);
         this.o.d(this.rd);
         
         if (this.dtab == 2) {
           
           if (this.compsel > 0 && this.compsel <= 16) { (this.compo[this.compsel - 1]).x = this.o.x; (this.compo[this.compsel - 1]).y = this.o.y; (this.compo[this.compsel - 1]).z = this.o.z; (this.compo[this.compsel - 1]).xz = this.o.xz; (this.compo[this.compsel - 1]).xy = this.o.xy; (this.compo[this.compsel - 1]).zy = this.o.zy; this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F)); this.compo[this.compsel - 1].d(this.rd); this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F)); }
            if (this.xm > 420 && this.xm < 690 && this.ym > 425 && this.ym < 540) { int[] arrayOfInt5, arrayOfInt6, arrayOfInt7; byte b4; for (arrayOfInt5 = new int[] { 50 + this.adna[0], -50 - this.adna[1], 0, 0, 0, 0 }, arrayOfInt6 = new int[] { 0, 0, 50 + this.adna[2], -50 - this.adna[3], 0, 0 }, arrayOfInt7 = new int[] { 0, 0, 0, 0, 50 + this.adna[4], -50 - this.adna[5] }, b4 = 0; b4 < 6; ) { arrayOfInt5[b4] = arrayOfInt5[b4] + this.o.x - this.m.x; arrayOfInt6[b4] = arrayOfInt6[b4] + this.o.y - this.m.y; arrayOfInt7[b4] = arrayOfInt7[b4] + this.o.z - this.m.z; b4++; }  rot(arrayOfInt5, arrayOfInt6, this.o.x - this.m.x, this.o.y - this.m.y, this.o.xy, 6); rot(arrayOfInt6, arrayOfInt7, this.o.y - this.m.y, this.o.z - this.m.z, this.o.zy, 6); rot(arrayOfInt5, arrayOfInt7, this.o.x - this.m.x, this.o.z - this.m.z, this.o.xz, 6); rot(arrayOfInt5, arrayOfInt7, this.m.cx, this.m.cz, this.m.xz, 6); rot(arrayOfInt6, arrayOfInt7, this.m.cy, this.m.cz, this.m.zy, 6); int[] arrayOfInt8, arrayOfInt9; byte b5; for (arrayOfInt8 = new int[6], arrayOfInt9 = new int[6], b5 = 0; b5 < 6; ) { arrayOfInt8[b5] = xs(arrayOfInt5[b5], arrayOfInt7[b5]); arrayOfInt9[b5] = ys(arrayOfInt6[b5], arrayOfInt7[b5]); b5++; }  this.rd.setColor(new Color(0, 150, 0)); this.rd.drawString("X+", arrayOfInt8[0] - 7, arrayOfInt9[0] + 4); this.rd.drawString("-X", arrayOfInt8[1] - 5, arrayOfInt9[1] + 4); this.rd.drawLine(arrayOfInt8[0], arrayOfInt9[0], arrayOfInt8[1], arrayOfInt9[1]); this.rd.setColor(new Color(150, 0, 0)); this.rd.drawString("Y+", arrayOfInt8[2] - 7, arrayOfInt9[2] + 4); this.rd.drawString("-Y", arrayOfInt8[3] - 5, arrayOfInt9[3] + 4); this.rd.drawLine(arrayOfInt8[2], arrayOfInt9[2], arrayOfInt8[3], arrayOfInt9[3]); this.rd.setColor(new Color(0, 0, 150)); this.rd.drawString("Z+", arrayOfInt8[4] - 7, arrayOfInt9[4] + 4); this.rd.drawString("-Z", arrayOfInt8[5] - 5, arrayOfInt9[5] + 4); this.rd.drawLine(arrayOfInt8[4], arrayOfInt9[4], arrayOfInt8[5], arrayOfInt9[5]); for (b5 = 0; b5 < 6; ) { if (Math.abs(arrayOfInt9[b5] - 207) * 1.91F > Math.abs(arrayOfInt8[b5] - 350)) { if (Math.abs(Math.abs(arrayOfInt9[b5] - 207) - 170) > 10) if (Math.abs(arrayOfInt9[b5] - 207) < 170) { this.adna[b5] = this.adna[b5] + 10; } else { this.adna[b5] = this.adna[b5] - 10; }   } else if (Math.abs(Math.abs(arrayOfInt8[b5] - 350) - 338) > 10) { if (Math.abs(arrayOfInt8[b5] - 350) < 338) { this.adna[b5] = this.adna[b5] + 10; } else { this.adna[b5] = this.adna[b5] - 10; }  }  if (this.adna[b5] > 276) this.adna[b5] = 276;  if (this.adna[b5] < 0) this.adna[b5] = 0;  b5++; }
              }
         
         }  this.rd.setColor(new Color(205, 200, 200)); this.rd.fillRect(0, 390, 700, 20); this.rd.setColor(new Color(225, 225, 225)); this.rd.fillRect(0, 410, 700, 140);
         this.rd.setFont(new Font("Arial", 1, 12)); this.ftm = this.rd.getFontMetrics();
         String[] arrayOfString1 = { "3D Controls", "Color Edit", "Scale & Align", "Wheels", "Stats & Class", "Physics", "Test Drive" };
         int[] arrayOfInt3 = { 0, 0, 100, 90 };
         int[] arrayOfInt4 = { 390, 410, 410, 390 }; int i;
         for (i = 0; i < 7; ) { this.rd.setColor(new Color(170, 170, 170)); if (this.xm > arrayOfInt3[0] && this.xm < arrayOfInt3[3] && this.ym > 390 && this.ym < 410) this.rd.setColor(new Color(190, 190, 190));  if (this.dtab == i) this.rd.setColor(new Color(225, 225, 225));  this.rd.fillPolygon(arrayOfInt3, arrayOfInt4, 4); this.rd.setColor(new Color(0, 0, 0)); this.rd.drawString(arrayOfString1[i], i * 100 + 47 - this.ftm.stringWidth(arrayOfString1[i]) / 2, 404); if (this.xm > arrayOfInt3[0] && this.xm < arrayOfInt3[3] && this.ym > 390 && this.ym < 410 && this.mouses == -1) this.dtab = i;  for (byte b4 = 0; b4 < 4; ) { arrayOfInt3[b4] = arrayOfInt3[b4] + 100; b4++; }  i++; }
         
         if (this.dtabed != this.dtab) {
           
           if (this.dtabed != -1) {
             
             if (!this.editor.getText().equals(this.lastedo)) this.editor.setText(this.lastedo); 
             setupo();
           } 
           setCursor(new Cursor(0));
           hidefields();
           requestFocus();
         } 
         
         this.rd.setColor(new Color(0, 0, 0));
         if (this.dtab == 0) { this.rd.drawString("Rotate Car around its X & Z Axis using:  [ Keyboard Arrows ] ", 20, 440); this.rd.drawString("Rotate Car fully around the Y Axis using:    [ < ]  &  [ > ]    or    [ A ]  &  [ D ]    or    [ 4 ]  &  [ 6 ]    Keys", 20, 465); this.rd.drawString("Move Car Up and Down using:    [ - ]  &  [ + ]    Keys", 20, 490); this.rd.drawString("Move Car Forwards and Backwards using:    [ W ]  &  [ S ]    or    [ 8 ]  &  [ 2 ]    or    [ Enter ]  &  [ Backspace ]    Keys", 20, 515); }
         
         if (this.dtab == 1)
         {
           if (this.o.colok != 2) {
             
             this.rd.setFont(new Font("Arial", 1, 13)); this.ftm = this.rd.getFontMetrics();
             this.rd.drawString("[  First & Second Color not defined yet  ]", 350 - this.ftm.stringWidth("[  First & Second Color not defined yet  ]") / 2, 450);
             stringbutton(" Define 1st and 2nd Color ", 350, 490, 0, true);
           }
           else {
             
             if (this.dtabed != this.dtab) {
               
               this.fcol = "(" + this.o.fcol[0] + "," + this.o.fcol[1] + "," + this.o.fcol[2] + ")";
               this.srch.setText(this.fcol); this.ofcol = this.fcol;
               Color.RGBtoHSB(this.o.fcol[0], this.o.fcol[1], this.o.fcol[2], this.fhsb);
               float f = this.fhsb[1]; this.fhsb[1] = this.fhsb[2]; this.fhsb[2] = f;
               this.scol = "(" + this.o.scol[0] + "," + this.o.scol[1] + "," + this.o.scol[2] + ")";
               this.rplc.setText(this.scol); this.oscol = this.scol;
               Color.RGBtoHSB(this.o.scol[0], this.o.scol[1], this.o.scol[2], this.shsb);
               f = this.shsb[1]; this.shsb[1] = this.shsb[2]; this.shsb[2] = f;
               this.bfo = 51;
               this.mouseon = -1;
             } 
             
             if (this.mouses != 1) this.mouseon = -1;
             
             this.rd.setColor(new Color(170, 170, 170));
             this.rd.drawRect(20, 425, 320, 110);
             this.rd.setColor(new Color(225, 225, 225));
             this.rd.fillRect(141, 419, 77, 9);
             this.rd.setColor(new Color(0, 0, 0));
             this.rd.drawString("First Color", 151, 428);
             this.rd.drawString("Hue:", 75, 450);
             this.rd.drawString("Brightness:", 35, 470);
             this.rd.drawString("Saturation:", 38, 490);
             this.rd.drawString("RGB Value:", 38, 520);
             movefield(this.srch, 106, 504, 129, 22); if (this.srch.hasFocus()) this.focuson = false; 
             if (!this.srch.isShowing()) this.srch.show(); 
             for (i = 0; i < 200; ) { this.rd.setColor(Color.getHSBColor((float)(i * 0.005D), 1.0F, 1.0F)); this.rd.drawLine(110 + i, 442, 110 + i, 449); i++; }
              for (i = 0; i < 200; ) { this.rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.2F + (float)(i * 0.004D))); this.rd.drawLine(110 + i, 462, 110 + i, 469); i++; }
              for (i = 0; i < 200; ) { this.rd.setColor(Color.getHSBColor(this.fhsb[0], (float)(i * 0.005D), this.fhsb[1])); this.rd.drawLine(110 + i, 482, 110 + i, 489); i++; }
              for (i = 0; i < 3; i++) {
               
               this.rd.setColor(new Color(0, 0, 0));
               float f = this.fhsb[i] * 200.0F; if (i == 1) f = (this.fhsb[i] - 0.2F) * 250.0F; 
               this.rd.drawLine((int)(110.0F + f), 442 + i * 20, (int)(110.0F + f), 449 + i * 20);
               this.rd.drawLine((int)(111.0F + f), 442 + i * 20, (int)(111.0F + f), 449 + i * 20);
               this.rd.fillRect((int)(109.0F + f), 450 + i * 20, 4, 2);
               this.rd.drawLine((int)(108.0F + f), 452 + i * 20, (int)(113.0F + f), 452 + i * 20);
               if (this.xm > 107 && this.xm < 313 && this.ym > 439 + i * 20 && this.ym < 452 + i * 20 && this.mouses == 1 && this.mouseon == -1) this.mouseon = i; 
               if (this.mouseon == i) { if (i == 1) { this.fhsb[i] = 0.2F + (this.xm - 110) / 250.0F; if (this.fhsb[i] < 0.2D) this.fhsb[i] = 0.2F;  } else { this.fhsb[i] = (this.xm - 110) / 200.0F; }  if (this.fhsb[i] > 1.0F) this.fhsb[i] = 1.0F;  if (this.fhsb[i] < 0.0F) this.fhsb[i] = 0.0F;  }
             
             }  stringbutton(" Save ", 300, 520, 0, !this.fcol.equals(this.ofcol));
             
             this.rd.setColor(new Color(170, 170, 170));
             this.rd.drawRect(360, 425, 320, 110);
             this.rd.setColor(new Color(225, 225, 225));
             this.rd.fillRect(472, 419, 95, 9);
             this.rd.setColor(new Color(0, 0, 0));
             this.rd.drawString("Second Color", 482, 428);
             this.rd.drawString("Hue:", 415, 450);
             this.rd.drawString("Brightness:", 375, 470);
             this.rd.drawString("Saturation:", 378, 490);
             this.rd.drawString("RGB Value:", 378, 520);
             movefield(this.rplc, 446, 504, 129, 22); if (this.rplc.hasFocus()) this.focuson = false; 
             if (!this.rplc.isShowing()) this.rplc.show(); 
             for (i = 0; i < 200; ) { this.rd.setColor(Color.getHSBColor((float)(i * 0.005D), 1.0F, 1.0F)); this.rd.drawLine(450 + i, 442, 450 + i, 449); i++; }
              for (i = 0; i < 200; ) { this.rd.setColor(Color.getHSBColor(0.0F, 0.0F, 0.2F + (float)(i * 0.004D))); this.rd.drawLine(450 + i, 462, 450 + i, 469); i++; }
              for (i = 0; i < 200; ) { this.rd.setColor(Color.getHSBColor(this.shsb[0], (float)(i * 0.005D), this.shsb[2])); this.rd.drawLine(450 + i, 482, 450 + i, 489); i++; }
              for (i = 0; i < 3; i++) {
               
               this.rd.setColor(new Color(0, 0, 0));
               float f = this.shsb[i] * 200.0F; if (i == 1) f = (this.shsb[i] - 0.2F) * 250.0F; 
               this.rd.drawLine((int)(450.0F + f), 442 + i * 20, (int)(450.0F + f), 449 + i * 20);
               this.rd.drawLine((int)(451.0F + f), 442 + i * 20, (int)(451.0F + f), 449 + i * 20);
               this.rd.fillRect((int)(449.0F + f), 450 + i * 20, 4, 2);
               this.rd.drawLine((int)(448.0F + f), 452 + i * 20, (int)(453.0F + f), 452 + i * 20);
               if (this.xm > 447 && this.xm < 653 && this.ym > 439 + i * 20 && this.ym < 452 + i * 20 && this.mouses == 1 && this.mouseon == -1) this.mouseon = i + 3; 
               if (this.mouseon == i + 3) { if (i == 1) { this.shsb[i] = 0.2F + (this.xm - 450) / 250.0F; if (this.shsb[i] < 0.2D) this.shsb[i] = 0.2F;  } else { this.shsb[i] = (this.xm - 450) / 200.0F; }  if (this.shsb[i] > 1.0F) this.shsb[i] = 1.0F;  if (this.shsb[i] < 0.0F) this.shsb[i] = 0.0F;  }
             
             }  stringbutton(" Save ", 640, 520, 0, !this.scol.equals(this.oscol));
             
             if (this.fhsb[1] < 0.2D) this.fhsb[1] = 0.2F; 
             if (this.shsb[1] < 0.2D) this.shsb[1] = 0.2F; 
             for (i = 0; i < this.o.npl; i++) {
               
               if ((this.o.p[i]).colnum == 1) { (this.o.p[i]).hsb[0] = this.fhsb[0]; (this.o.p[i]).hsb[1] = this.fhsb[2]; (this.o.p[i]).hsb[2] = this.fhsb[1]; }
                if ((this.o.p[i]).colnum == 2) { (this.o.p[i]).hsb[0] = this.shsb[0]; (this.o.p[i]).hsb[1] = this.shsb[2]; (this.o.p[i]).hsb[2] = this.shsb[1]; }
             
             } 
             String str = "(" + Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getRed() + "," + Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getGreen() + "," + Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getBlue() + ")";
             if (!this.fcol.equals(str)) { this.fcol = str; this.srch.setText(this.fcol); }
              str = "(" + Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getRed() + "," + Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getGreen() + "," + Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getBlue() + ")";
             if (!this.scol.equals(str)) { this.scol = str; this.rplc.setText(this.scol); }
 
             
             if (this.srch.getText().equals(this.fcol) && this.rplc.getText().equals(this.scol)) {
               
               if (this.bfo < 50) { this.bfo++; } else if (this.bfo == 50) { requestFocus(); this.bfo = 51; }
             
             } else {
               
               this.bfo = 0;
               if (!this.srch.getText().equals(this.fcol)) { this.fcol = this.srch.getText(); int[] arrayOfInt = new int[3]; boolean bool = true; try { int j = this.fcol.indexOf(",", 0), k = this.fcol.indexOf(",", j + 1); arrayOfInt[0] = Integer.valueOf(this.fcol.substring(1, j)).intValue(); if (arrayOfInt[0] < 0) arrayOfInt[0] = 0;  if (arrayOfInt[0] > 255) arrayOfInt[0] = 255;  arrayOfInt[1] = Integer.valueOf(this.fcol.substring(j + 1, k)).intValue(); if (arrayOfInt[1] < 0) arrayOfInt[1] = 0;  if (arrayOfInt[1] > 255) arrayOfInt[1] = 255;  arrayOfInt[2] = Integer.valueOf(this.fcol.substring(k + 1, this.fcol.length() - 1)).intValue(); if (arrayOfInt[2] < 0) arrayOfInt[2] = 0;  if (arrayOfInt[2] > 255) arrayOfInt[2] = 255;  } catch (Exception exception) { bool = false; }  if (bool) { Color.RGBtoHSB(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], this.fhsb); float f = this.fhsb[1]; this.fhsb[1] = this.fhsb[2]; this.fhsb[2] = f; }  }
                if (!this.rplc.getText().equals(this.scol)) { this.scol = this.rplc.getText(); int[] arrayOfInt = new int[3]; boolean bool = true; try { int j = this.scol.indexOf(",", 0), k = this.scol.indexOf(",", j + 1); arrayOfInt[0] = Integer.valueOf(this.scol.substring(1, j)).intValue(); if (arrayOfInt[0] < 0) arrayOfInt[0] = 0;  if (arrayOfInt[0] > 255) arrayOfInt[0] = 255;  arrayOfInt[1] = Integer.valueOf(this.scol.substring(j + 1, k)).intValue(); if (arrayOfInt[1] < 0) arrayOfInt[1] = 0;  if (arrayOfInt[1] > 255) arrayOfInt[1] = 255;  arrayOfInt[2] = Integer.valueOf(this.scol.substring(k + 1, this.scol.length() - 1)).intValue(); if (arrayOfInt[2] < 0) arrayOfInt[2] = 0;  if (arrayOfInt[2] > 255) arrayOfInt[2] = 255;  } catch (Exception exception) { bool = false; }  if (bool) { Color.RGBtoHSB(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], this.shsb); float f = this.shsb[1]; this.shsb[1] = this.shsb[2]; this.shsb[2] = f; }
                  }
             
             } 
           } 
         }
         
         if (this.dtab == 2) {
           
           if (this.dtabed != this.dtab) {
             
             this.lastedo = this.editor.getText();
             this.scale[0] = 100;
             i = this.editor.getText().indexOf("\nScaleX(", 0);
             if (i != -1) { i++; try { this.scale[0] = Integer.valueOf(this.editor.getText().substring(i + 7, this.editor.getText().indexOf(")", i))).intValue(); } catch (Exception exception) { this.scale[0] = 100; }  }
              this.oscale[0] = this.scale[0];
             this.scale[1] = 100;
             i = this.editor.getText().indexOf("\nScaleY(", 0);
             if (i != -1) { i++; try { this.scale[1] = Integer.valueOf(this.editor.getText().substring(i + 7, this.editor.getText().indexOf(")", i))).intValue(); } catch (Exception exception) { this.scale[1] = 100; }  }
              this.oscale[1] = this.scale[1];
             this.scale[2] = 100;
             i = this.editor.getText().indexOf("\nScaleZ(", 0);
             if (i != -1) { i++; try { this.scale[2] = Integer.valueOf(this.editor.getText().substring(i + 7, this.editor.getText().indexOf(")", i))).intValue(); } catch (Exception exception) { this.scale[2] = 100; }  }
              this.oscale[2] = this.scale[2];
             this.bfo = 0;
             this.compsel = 0;
             this.compcar.select(this.compsel);
             this.changed2 = false;
           } 
           
           this.rd.setColor(new Color(170, 170, 170));
           this.rd.drawRect(9, 425, 270, 115);
           this.rd.setColor(new Color(225, 225, 225));
           this.rd.fillRect(119, 419, 51, 9);
           this.rd.setColor(new Color(0, 0, 0));
           this.rd.drawString("Scale", 129, 428);
           this.rd.setColor(new Color(0, 0, 0));
           this.rd.drawString("Scale X", 25, 450);
           stringbutton(" - ", 92, 450, 4, false);
           this.rd.drawString("" + (this.scale[0] / 100.0F) + "", 126 - this.ftm.stringWidth("" + (this.scale[0] / 100.0F) + "") / 2, 450);
           stringbutton(" + ", 160, 450, 4, false);
           this.rd.drawString("Scale Y", 25, 474);
           stringbutton(" - ", 92, 474, 4, false);
           this.rd.drawString("" + (this.scale[1] / 100.0F) + "", 126 - this.ftm.stringWidth("" + (this.scale[1] / 100.0F) + "") / 2, 474);
           stringbutton(" + ", 160, 474, 4, false);
           this.rd.drawString("Scale Z", 25, 498);
           stringbutton(" - ", 92, 498, 4, false);
           this.rd.drawString("" + (this.scale[2] / 100.0F) + "", 126 - this.ftm.stringWidth("" + (this.scale[2] / 100.0F) + "") / 2, 498);
           stringbutton(" + ", 160, 498, 4, false);
           this.rd.drawString("Scale ALL", 25, 527);
           stringbutton(" - ", 106, 527, 2, true);
           stringbutton(" + ", 146, 527, 2, true);
           stringbutton("   Save   ", 230, 454, 0, (this.oscale[0] != this.scale[0] || this.oscale[1] != this.scale[1] || this.oscale[2] != this.scale[2]));
           stringbutton(" Reset ", 230, 493, 0, false);
           
           this.rd.drawString("Compare scale and", 296, 440);
           this.rd.drawString("alignment with:", 308, 455);
           this.compcar.move(288, 462); if (this.compcar.hasFocus()) { this.focuson = false; this.bfo++; if (this.bfo == 100) requestFocus();  } else { this.bfo = 0; }
            if (!this.compcar.isShowing()) this.compcar.show(); 
           if (this.compsel != this.compcar.getSelectedIndex()) { this.compsel = this.compcar.getSelectedIndex(); requestFocus(); }
           
           this.rd.setColor(new Color(170, 170, 170));
           this.rd.drawRect(420, 425, 270, 115);
           this.rd.setColor(new Color(225, 225, 225));
           this.rd.fillRect(531, 419, 47, 9);
           this.rd.setColor(new Color(0, 0, 0));
           this.rd.drawString("Align", 541, 428);
           this.rd.drawString("Align in X", 433, 450);
           stringbutton(" Rotate 90° ", 535, 450, 4, false);
           stringbutton("+10", 607, 450, 4, false);
           stringbutton("-10", 656, 450, 4, false);
           this.rd.drawString("Align in Y", 433, 474);
           stringbutton(" Rotate 90° ", 535, 474, 4, false);
           stringbutton("+10", 607, 474, 4, false);
           stringbutton("-10", 656, 474, 4, false);
           this.rd.drawString("Align in Z", 433, 498);
           stringbutton(" Rotate 90° ", 535, 498, 4, false);
           stringbutton("+10", 607, 498, 4, false);
           stringbutton("-10", 656, 498, 4, false);
           stringbutton(" Reset ", 490, 527, 0, false);
           stringbutton("      Save      ", 607, 527, 0, this.changed2);
         } 
 
         
         if (this.dtab == 3) {
           
           if (this.dtabed != this.dtab) {
             
             i = 45; int j = 45, k = 15, m = 15, n = 76, i1 = -76, i2 = 26, i3 = 26, i4 = 20, i5 = 20, i6 = 18, i7 = 18, i8 = 10, i9 = 10, i10 = 0, i11 = 0;
             String str1 = "(140,140,140)", str2 = "(140,140,140)";
             byte b4 = 0;
             String str3 = "" + this.editor.getText() + "\n";
             int i12 = 0, i13 = str3.indexOf("\n", 0);
             int i14 = 0, i15 = 15, i16 = 20;
             String str4 = "(140,140,140)";
             while (i13 != -1 && i12 < str3.length()) {
               
               String str = str3.substring(i12, i13); str = str.trim();
               i12 = i13 + 1; i13 = str3.indexOf("\n", i12);
               
               try {
                 if (str.startsWith("rims(")) { str4 = "(" + getvalue("rims", str, 0) + "," + getvalue("rims", str, 1) + "," + getvalue("rims", str, 2) + ")"; i15 = getvalue("rims", str, 3); i16 = getvalue("rims", str, 4); }
                  if (str.startsWith("gwgr(")) i14 = getvalue("gwgr", str, 0); 
                 if (str.startsWith("w(")) {
                   
                   int i17 = getvalue("w", str, 2);
                   if (i17 > 0) {
                     
                     i = Math.abs(getvalue("w", str, 0));
                     k = getvalue("w", str, 1);
                     n = i17;
                     i2 = Math.abs(getvalue("w", str, 4));
                     i4 = Math.abs(getvalue("w", str, 5));
                     str1 = str4; i6 = i15; i8 = i16; i10 = i14;
                   }
                   else {
                     
                     j = Math.abs(getvalue("w", str, 0));
                     m = getvalue("w", str, 1);
                     i1 = i17;
                     i3 = Math.abs(getvalue("w", str, 4));
                     i5 = Math.abs(getvalue("w", str, 5));
                     str2 = str4; i7 = i15; i9 = i16; i11 = i14;
                   } 
                   b4++;
                 } 
               } catch (Exception exception) {}
             } 
             
             if (b4 != 4) { this.defnow = true; } else { this.defnow = false; }
              this.wv[0].setText("" + j + ""); this.wv[1].setText("" + m + ""); this.wv[2].setText("" + i1 + ""); this.wv[3].setText("" + i5 + ""); this.wv[4].setText("" + i3 + ""); this.srch.setText(str2); this.wv[5].setText("" + i7 + ""); this.wv[6].setText("" + i9 + ""); this.wv[7].setText("" + i11 + "");
             this.wv[8].setText("" + i + ""); this.wv[9].setText("" + k + ""); this.wv[10].setText("" + n + ""); this.wv[11].setText("" + i4 + ""); this.wv[12].setText("" + i2 + ""); this.rplc.setText(str1); this.wv[13].setText("" + i6 + ""); this.wv[14].setText("" + i8 + ""); this.wv[15].setText("" + i10 + "");
             this.aply1 = "" + this.wv[0].getText() + "" + this.wv[1].getText() + "" + this.wv[2].getText() + "" + this.wv[3].getText() + "" + this.wv[4].getText() + "" + this.srch.getText() + "" + this.wv[5].getText() + "" + this.wv[6].getText() + "" + this.wv[7].getText() + "";
             this.aply2 = "" + this.wv[8].getText() + "" + this.wv[9].getText() + "" + this.wv[10].getText() + "" + this.wv[11].getText() + "" + this.wv[12].getText() + "" + this.rplc.getText() + "" + this.wv[13].getText() + "" + this.wv[14].getText() + "" + this.wv[15].getText() + "";
             this.aplyd1 = false;
             this.aplyd2 = false;
             this.changed2 = false;
             this.mouseon = -1;
           } 
           
           this.rd.setColor(new Color(0, 0, 0));
           
           this.rd.drawString("BACK Wheels :", 12, 424);
           this.rd.drawString("±X :", 12, 449);
           movefield(this.wv[0], 35, 433, 40, 22);
           this.rd.drawString("Y :", 86, 449);
           movefield(this.wv[1], 101, 433, 40, 22);
           this.rd.drawString("Z :", 151, 449);
           movefield(this.wv[2], 166, 433, 40, 22);
           this.rd.drawString("Height :", 12, 479);
           movefield(this.wv[3], 56, 463, 40, 22);
           this.rd.drawString("Width :", 107, 479);
           movefield(this.wv[4], 148, 463, 40, 22);
           this.rd.drawString("Rims RGB Color :", 12, 509);
           movefield(this.srch, 109, 493, 129, 22);
           this.rd.drawString("Rims Size :", 12, 539);
           movefield(this.wv[5], 76, 523, 40, 22);
           this.rd.drawString("Rims Depth :", 126, 539);
           movefield(this.wv[6], 199, 523, 40, 22);
           if (this.xm > 245 && this.xm < 336 && this.ym > 524 && this.ym < 541) { this.rd.setColor(new Color(255, 0, 0)); this.rd.drawLine(248, 540, 279, 540); this.rd.drawLine(327, 540, 334, 540); if (this.mouseon == -1) { this.mouseon = 1; setCursor(new Cursor(12)); }  } else if (this.mouseon == 1) { this.mouseon = -1; setCursor(new Cursor(0)); }
            this.rd.drawString("Hide :                ?", 249, 539);
           movefield(this.wv[7], 282, 523, 40, 22);
           stringbutton("   Apply   ", 300, 440, 0, this.aplyd1);
           stringbutton("   Save   ", 300, 477, 0, this.changed2);
           
           this.rd.drawString("FRONT Wheels :", 362, 424);
           this.rd.drawString("±X :", 362, 449);
           movefield(this.wv[8], 385, 433, 40, 22);
           this.rd.drawString("Y :", 436, 449);
           movefield(this.wv[9], 451, 433, 40, 22);
           this.rd.drawString("Z :", 501, 449);
           movefield(this.wv[10], 516, 433, 40, 22);
           this.rd.drawString("Height :", 362, 479);
           movefield(this.wv[11], 406, 463, 40, 22);
           this.rd.drawString("Width :", 457, 479);
           movefield(this.wv[12], 498, 463, 40, 22);
           this.rd.drawString("Rims RGB Color :", 362, 509);
           movefield(this.rplc, 459, 493, 129, 22);
           this.rd.drawString("Rims Size :", 362, 539);
           movefield(this.wv[13], 426, 523, 40, 22);
           this.rd.drawString("Rims Depth :", 476, 539);
           movefield(this.wv[14], 549, 523, 40, 22);
           if (this.xm > 595 && this.xm < 686 && this.ym > 524 && this.ym < 541) { this.rd.setColor(new Color(255, 0, 0)); this.rd.drawLine(598, 540, 629, 540); this.rd.drawLine(677, 540, 684, 540); if (this.mouseon == -1) { this.mouseon = 2; setCursor(new Cursor(12)); }  } else if (this.mouseon == 2) { this.mouseon = -1; setCursor(new Cursor(0)); }
            this.rd.drawString("Hide :                ?", 599, 539);
           movefield(this.wv[15], 632, 523, 40, 22);
           stringbutton("   Apply   ", 650, 440, 0, this.aplyd2);
           stringbutton("   Save   ", 650, 477, 0, this.changed2);
           
           if (this.mouses == -1)
           {
             if (this.mouseon == 1 || this.mouseon == 2)
             {
               JOptionPane.showMessageDialog(null, "Use this variable to hide the car wheels inside the car if you need to (if they are getting drawn over the car when they\nshould be drawn behind it).\n\nIf you have created a car model with specific places for the wheels go inside them (inside the car), if when you place the\nwheels there they don’t get drawn inside the car (they get drawn over it instead), use this variable to adjust that.\n\nYou can also use this variable to do the opposite, to make the wheels get drawn over the car if they are getting drawn\nbehind it when they shouldn’t.\n\nThe Hide variable takes values from -40 to 40:\nA +ve value from 1 to 40 makes the wheels more hidden, where 40 is the maximum the car wheel can be hidden.\nA -ve value from -1 to -40 does exactly the opposite and makes the wheels more apparent (this if the car wheels appear\ninside the car when they should be outside).\nA 0 value means do nothing.\nMost of the time you will need to use this variable, it will be to enter +ve values from 1-40 for hiding the car wheels.\n\n", "Car Maker", 1);
             }
           }
           
           for (i = 0; i < 16; i++) {
             
             if (this.wv[i].hasFocus()) this.focuson = false; 
             if (!this.wv[i].isShowing()) this.wv[i].show(); 
           } 
           if (this.srch.hasFocus()) this.focuson = false; 
           if (!this.srch.isShowing()) this.srch.show(); 
           if (this.rplc.hasFocus()) this.focuson = false; 
           if (!this.rplc.isShowing()) this.rplc.show();
           
           if (!this.focuson) {
             
             if (!this.aplyd1 && !this.aply1.equals("" + this.wv[0].getText() + "" + this.wv[1].getText() + "" + this.wv[2].getText() + "" + this.wv[3].getText() + "" + this.wv[4].getText() + "" + this.srch.getText() + "" + this.wv[5].getText() + "" + this.wv[6].getText() + "" + this.wv[7].getText() + "")) this.aplyd1 = true; 
             if (!this.aplyd2 && !this.aply2.equals("" + this.wv[8].getText() + "" + this.wv[9].getText() + "" + this.wv[10].getText() + "" + this.wv[11].getText() + "" + this.wv[12].getText() + "" + this.rplc.getText() + "" + this.wv[13].getText() + "" + this.wv[14].getText() + "" + this.wv[15].getText() + "")) this.aplyd2 = true;
           
           } 
           this.rd.setColor(new Color(170, 170, 170));
           this.rd.drawLine(350, 410, 350, 550);
           this.rd.drawLine(300, 409, 400, 409);
         } 
 
         
         if (this.dtab == 4) {
           
           if (this.dtabed != this.dtab) {
             
             this.changed2 = false;
             this.statdef = false;
             String str = "" + this.editor.getText() + "\n";
             int j = 0, k = str.indexOf("\n", 0);
             
             while (k != -1 && j < str.length()) {
               
               String str1 = str.substring(j, k); str1 = str1.trim();
               j = k + 1; k = str.indexOf("\n", j);
 
               
               try { if (str1.startsWith("stat(")) {
                   
                   int m = 0; int n;
                   for (n = 0; n < 5; ) { this.stat[n] = getvalue("stat", str1, n); if (this.stat[n] > 200) this.stat[n] = 200;  if (this.stat[n] < 16) this.stat[n] = 16;  m += this.stat[n]; n++; }
                    n = 0;
                   if (m > 680) { n = 680 - m; this.changed2 = true; }
                    if (m > 640 && m < 680) { n = 640 - m; this.changed2 = true; }
                    if (m > 600 && m < 640) { n = 600 - m; this.changed2 = true; }
                    if (m > 560 && m < 600) { n = 560 - m; this.changed2 = true; }
                    if (m > 520 && m < 560) { n = 520 - m; this.changed2 = true; }
                    if (m < 520) { n = 520 - m; this.changed2 = true; }
                    while (n != 0) { for (byte b5 = 0; b5 < 5; ) { if (n > 0 && this.stat[b5] < 200) { this.stat[b5] = this.stat[b5] + 1; n--; }  if (n < 0 && this.stat[b5] > 16) { this.stat[b5] = this.stat[b5] - 1; n++; }  b5++; }  }
                    for (byte b4 = 0; b4 < 5; ) { this.rstat[b4] = this.stat[b4]; b4++; }
                    this.statdef = true;
                 }  }
               catch (Exception exception) { this.statdef = false; }
             
             }  if (this.statdef) { if (this.simcar.getItemCount() == 16) this.simcar.add(this.rd, "   ");  } else if (this.simcar.getItemCount() == 17) { this.simcar.remove("   "); }
           
           } 
           this.rd.setColor(new Color(0, 0, 0));
           
           if (!this.statdef) {
             
             this.rd.setFont(new Font("Arial", 1, 13)); this.ftm = this.rd.getFontMetrics();
             this.rd.drawString("To start, please select the most similar NFM car to this car", 350 - this.ftm.stringWidth("To start, please select the most similar NFM car to this car") / 2, 450);
             this.simcar.move(288, 460);
             if (!this.simcar.isShowing()) this.simcar.show(); 
             stringbutton("   OK   ", 350, 515, 0, true);
           }
           else {
             
             this.rd.drawString("Car Class", 54, 435);
             this.cls.move(34, 440);
             if (!this.cls.isShowing()) this.cls.show(); 
             i = 0;
             int j = 0; int k;
             for (k = 0; k < 5; ) { j += this.stat[k]; if (this.stat[k] != this.rstat[k]) i = 1;  k++; }
             
             if (this.clsel != this.cls.getSelectedIndex()) {
               
               this.clsel = this.cls.getSelectedIndex();
               k = (4 - this.clsel) * 40 + 520 - j;
               while (k != 0) { for (byte b6 = 0; b6 < 5; ) { if (k > 0 && this.stat[b6] < 200) { this.stat[b6] = this.stat[b6] + 1; k--; }  if (k < 0 && this.stat[b6] > 16) { this.stat[b6] = this.stat[b6] - 1; k++; }  b6++; }
                  }
             
             }  if (4 - (j - 520) / 40 != this.cls.getSelectedIndex()) { this.clsel = 4 - (j - 520) / 40; this.cls.select(this.clsel); }
             
             this.rd.drawString("Most Similar Car", 36, 490);
             this.simcar.move(20, 495);
             if (!this.simcar.isShowing()) this.simcar.show(); 
             if (this.carsel != this.simcar.getSelectedIndex()) { this.carsel = this.simcar.getSelectedIndex(); if (this.carsel != 16) for (k = 0; k < 5; ) { this.stat[k] = this.carstat[this.carsel][k]; k++; }   requestFocus(); }
             
             k = 60; byte b4 = 16; byte b5;
             for (b5 = 0; b5 < 16; b5++) {
               
               int m = 0;
               for (byte b6 = 0; b6 < 5; ) { m += Math.abs(this.carstat[b5][b6] - this.stat[b6]); b6++; }
                if (m < k) { b4 = b5; k = m; }
             
             }  if (b4 != this.carsel) { this.carsel = b4; if (this.carsel < this.simcar.getItemCount()) this.simcar.select(this.carsel);  }
             
             this.rd.drawString("Speed :", 196, 435);
             this.rd.drawString("Acceleration :", 160, 459);
             this.rd.drawString("Stunts :", 195, 483);
             this.rd.drawString("Strength :", 183, 507);
             this.rd.drawString("Endurance :", 171, 531);
             
             for (b5 = 0; b5 < 5; b5++) {
               byte b6;
               for (b6 = 0; b6 < this.stat[b5]; ) { this.rd.setColor(Color.getHSBColor((float)(b6 * 7.0E-4D), 1.0F, 1.0F)); this.rd.drawLine(250 + b6, 426 + b5 * 24, 250 + b6, 434 + b5 * 24); b6++; }
                this.rd.setColor(new Color(0, 0, 0)); this.rd.drawLine(249, 426 + b5 * 24, 249, 434 + b5 * 24); this.rd.drawLine(450, 426 + b5 * 24, 450, 434 + b5 * 24); this.rd.drawLine(249, 435 + b5 * 24, 450, 435 + b5 * 24);
               for (b6 = 0; b6 < 7; ) { this.rd.drawLine(275 + b6 * 25, 434 + b5 * 24, 275 + b6 * 25, 430 + b5 * 24); b6++; }
                stringbutton(" - ", 480, 435 + b5 * 24, 4, false);
               stringbutton(" + ", 520, 435 + b5 * 24, 4, false);
             } 
             
             if (this.carsel < 16 && k != 0) { stringbutton(" Reselect ", 80, 534, 4, true); } else { stringbutton(" Reselect ", 80, -1000, 4, true); }
             
             stringbutton("      Save      ", 620, 459, 0, (i != 0 || this.changed2));
             stringbutton("   Reset   ", 620, 507, 0, false);
           } 
         } 
         
         if (this.dtab == 5) {
           
           if (this.dtabed != this.dtab) {
             
             this.mouseon = -1;
             this.pfase = 0;
             if (this.o.keyz[0] <= 0 || this.o.keyx[0] >= 0) this.pfase = -1; 
             if (this.o.keyz[1] <= 0 || this.o.keyx[1] <= 0) this.pfase = -1; 
             if (this.o.keyz[2] >= 0 || this.o.keyx[2] >= 0) this.pfase = -1; 
             if (this.o.keyz[3] >= 0 || this.o.keyx[3] <= 0) this.pfase = -1; 
             this.crashok = false;
             if (Math.random() > Math.random()) { this.crashleft = false; } else { this.crashleft = true; }
              this.engsel = 0;
             
             if (this.pfase == 0) {
               
               String str = "" + this.editor.getText() + "\n";
               int j = 0, k = str.indexOf("\n", 0);
               while (k != -1 && j < str.length()) {
                 
                 String str1 = str.substring(j, k); str1 = str1.trim();
                 j = k + 1; k = str.indexOf("\n", j);
 
                 
                 try { if (str1.startsWith("physics(")) {
                     byte b4;
                     for (b4 = 0; b4 < 11; ) { this.phys[b4] = getvalue("physics", str1, b4); if (this.phys[b4] > 100) this.phys[b4] = 100;  if (this.phys[b4] < 0) this.phys[b4] = 0;  b4++; }
                      for (b4 = 0; b4 < 11; ) { this.rphys[b4] = this.phys[b4]; b4++; }
                      for (b4 = 0; b4 < 3; ) { this.crash[b4] = getvalue("physics", str1, b4 + 11); if (this.crash[b4] > 100) this.crash[b4] = 100;  if (this.crash[b4] < 0) this.crash[b4] = 0;  b4++; }
                      for (b4 = 0; b4 < 3; ) { this.rcrash[b4] = this.crash[b4]; b4++; }
                      this.engsel = getvalue("physics", str1, 14); if (this.engsel > 4) this.engsel = 0;  if (this.engsel < 0) this.engsel = 0; 
                     this.crashok = true;
                   }  }
                 catch (Exception exception) { this.crashok = false; }
               
               } 
             } 
             this.engon = false;
           } 
           
           i = -1;
           
           if (this.pfase == 0) {
             
             for (byte b4 = 0; b4 < 4; b4++) {
               
               this.rd.setColor(new Color(0, 0, 0));
               if (this.xm > this.pnx[b4] && this.xm < 230 && this.ym > 433 + b4 * 24 && this.ym < 453 + b4 * 24) { i = b4; this.rd.setColor(new Color(176, 64, 0)); this.rd.drawLine(this.pnx[b4], 448 + b4 * 24, 128, 448 + b4 * 24); }
                this.rd.drawString("" + this.pname[b4] + " :", this.pnx[b4], 447 + b4 * 24);
               this.rd.drawLine(140, 443 + b4 * 24, 230, 443 + b4 * 24); int j;
               for (j = 1; j < 10; ) { this.rd.drawLine(140 + 10 * j, 443 - j + b4 * 24, 140 + 10 * j, 443 + j + b4 * 24); j++; }
                this.rd.setColor(new Color(255, 0, 0));
               j = (int)(this.phys[b4] / 1.1111F / 10.0F);
               this.rd.fillRect(138 + (int)(this.phys[b4] / 1.1111F), 443 - j + b4 * 24, 5, j * 2 + 1);
               this.rd.setColor(new Color(255, 128, 0));
               this.rd.drawRect(139 + (int)(this.phys[b4] / 1.1111F), 434 + b4 * 24, 2, 18);
               stringbutton(" - ", 260, 447 + b4 * 24, 4, false);
               stringbutton(" + ", 300, 447 + b4 * 24, 4, false);
             } 
             
             this.rd.setColor(new Color(0, 0, 0));
             this.rd.drawString("<  Click on any variable name to learn about its function & use!", 333, 447);
             stringbutton(" Random ", 380, 496, 0, false);
             stringbutton(" Reset ", 455, 496, 0, false);
             stringbutton("       Next  >       ", 570, 496, 0, true);
           } 
           
           if (this.pfase == 1) {
             byte b4;
             for (b4 = 0; b4 < 4; b4++) {
               
               this.rd.setColor(new Color(0, 0, 0));
               if (this.xm > this.pnx[b4 + 5] && this.xm < 211 && this.ym > 433 + b4 * 24 && this.ym < 453 + b4 * 24) { i = b4 + 5; this.rd.setColor(new Color(176, 64, 0)); this.rd.drawLine(this.pnx[b4 + 5], 448 + b4 * 24, 109, 448 + b4 * 24); }
                this.rd.drawString("" + this.pname[b4 + 5] + " :", this.pnx[b4 + 5], 447 + b4 * 24);
               this.rd.drawLine(121, 443 + b4 * 24, 211, 443 + b4 * 24); int j;
               for (j = 1; j < 10; ) { this.rd.drawLine(121 + 10 * j, 443 - j + b4 * 24, 121 + 10 * j, 443 + j + b4 * 24); j++; }
                this.rd.setColor(new Color(255, 0, 0));
               j = (int)(this.phys[b4 + 5] / 1.1111F / 10.0F);
               this.rd.fillRect(119 + (int)(this.phys[b4 + 5] / 1.1111F), 443 - j + b4 * 24, 5, j * 2 + 1);
               this.rd.setColor(new Color(255, 128, 0));
               this.rd.drawRect(120 + (int)(this.phys[b4 + 5] / 1.1111F), 434 + b4 * 24, 2, 18);
               stringbutton(" - ", 241, 447 + b4 * 24, 4, false);
               stringbutton(" + ", 281, 447 + b4 * 24, 4, false);
             } 
             for (b4 = 0; b4 < 2; b4++) {
               
               this.rd.setColor(new Color(0, 0, 0));
               if (this.xm > this.pnx[b4 + 9] && this.xm < 548 && this.ym > 433 + b4 * 24 && this.ym < 453 + b4 * 24) { i = b4 + 9; this.rd.setColor(new Color(176, 64, 0)); this.rd.drawLine(this.pnx[b4 + 9], 448 + b4 * 24, 446, 448 + b4 * 24); }
                this.rd.drawString("" + this.pname[b4 + 9] + " :", this.pnx[b4 + 9], 447 + b4 * 24);
               this.rd.drawLine(458, 443 + b4 * 24, 548, 443 + b4 * 24); int j;
               for (j = 1; j < 10; ) { this.rd.drawLine(458 + 10 * j, 443 - j + b4 * 24, 458 + 10 * j, 443 + j + b4 * 24); j++; }
                this.rd.setColor(new Color(255, 0, 0));
               j = (int)(this.phys[b4 + 9] / 1.1111F / 10.0F);
               this.rd.fillRect(456 + (int)(this.phys[b4 + 9] / 1.1111F), 443 - j + b4 * 24, 5, j * 2 + 1);
               this.rd.setColor(new Color(255, 128, 0));
               this.rd.drawRect(457 + (int)(this.phys[b4 + 9] / 1.1111F), 434 + b4 * 24, 2, 18);
               stringbutton(" - ", 578, 447 + b4 * 24, 4, false);
               stringbutton(" + ", 618, 447 + b4 * 24, 4, false);
             } 
             stringbutton(" Random ", 361, 519, 0, false);
             stringbutton(" Reset ", 436, 519, 0, false);
             stringbutton(" <  Back ", 509, 519, 0, false);
             stringbutton("       Next  >       ", 603, 519, 0, true);
           } 
           
           if (this.pfase == 2) {
 
             
             if (this.xm > 40 && this.xm < 670 && this.ym > 416 && this.ym < 436) { i = 11; this.rd.setColor(new Color(176, 64, 0)); this.rd.drawLine(596, 431, 669, 431); }
             
             this.rd.drawString("[   Crash Test,  Damage :                                       ]                                                     What is this?", 180, 430);
             
             if (this.hitmag < 0) this.hitmag = 0; 
             if (this.hitmag > 17000) {
               
               this.crashok = true;
               this.hitmag = 17000;
               for (byte b5 = 0; b5 < this.o.npl; ) { if (((this.o.p[b5]).wz == 0 || (this.o.p[b5]).gr == -17 || (this.o.p[b5]).gr == -16) && (this.o.p[b5]).embos == 0) (this.o.p[b5]).embos = 1;  b5++; }
             
             } 
             this.rd.setColor(new Color(255, (int)(250.0F - this.hitmag / 68.0F), 0));
             this.rd.fillRect(322, 423, (int)(this.hitmag / 170.0F), 7);
             
             this.rd.setColor(new Color(255, 0, 0));
             this.rd.drawRect(322, 423, 100, 7);
             
             if (i != 11) { this.rd.setColor(new Color(170, 170, 170)); } else { this.rd.setColor(new Color(176, 64, 0)); }
              this.rd.drawString("Normal Crash", 39, 438);
             this.rd.drawString("Roof Crash", 501, 438);
             this.rd.drawLine(125, 426, 179, 426);
             this.rd.drawLine(125, 426, 125, 440);
             this.rd.drawLine(491, 426, 437, 426);
             this.rd.drawLine(491, 426, 491, 440);
 
             
             this.rd.drawRect(19, 440, 276, 91);
 
             
             this.rd.drawRect(339, 440, 312, 67);
             
             this.rd.setColor(new Color(0, 0, 0));
             if (this.xm > 50 && this.xm < 195 && this.ym > 446 && this.ym < 466) { i = 12; this.rd.setColor(new Color(176, 64, 0)); this.rd.drawLine(50, 461, 94, 461); }
              this.rd.drawString("Radius :", 50, 460);
             this.rd.drawLine(105, 456, 195, 456); int j;
             for (j = 1; j < 10; ) { this.rd.drawLine(105 + 10 * j, 456 - j, 105 + 10 * j, 456 + j); j++; }
              this.rd.setColor(new Color(255, 0, 0));
             j = (int)(this.crash[0] / 1.1111F / 10.0F);
             this.rd.fillRect(103 + (int)(this.crash[0] / 1.1111F), 456 - j, 5, j * 2 + 1);
             this.rd.setColor(new Color(255, 128, 0));
             this.rd.drawRect(104 + (int)(this.crash[0] / 1.1111F), 447, 2, 18);
             stringbutton(" - ", 225, 460, 4, false);
             stringbutton(" + ", 265, 460, 4, false);
             
             this.rd.setColor(new Color(0, 0, 0));
             if (this.xm > 30 && this.xm < 195 && this.ym > 470 && this.ym < 490) { i = 13; this.rd.setColor(new Color(176, 64, 0)); this.rd.drawLine(30, 485, 94, 485); }
              this.rd.drawString("Magnitude :", 30, 484);
             this.rd.drawLine(105, 480, 195, 480); byte b4;
             for (b4 = 1; b4 < 10; ) { this.rd.drawLine(105 + 10 * b4, 480 - b4, 105 + 10 * b4, 480 + b4); b4++; }
              this.rd.setColor(new Color(255, 0, 0));
             j = (int)(this.crash[1] / 1.1111F / 10.0F);
             this.rd.fillRect(103 + (int)(this.crash[1] / 1.1111F), 480 - j, 5, j * 2 + 1);
             this.rd.setColor(new Color(255, 128, 0));
             this.rd.drawRect(104 + (int)(this.crash[1] / 1.1111F), 471, 2, 18);
             stringbutton(" - ", 225, 484, 4, false);
             stringbutton(" + ", 265, 484, 4, false);
             
             this.rd.setColor(new Color(0, 0, 0));
             if (this.xm > 350 && this.xm < 551 && this.ym > 446 && this.ym < 466) { i = 14; this.rd.setColor(new Color(176, 64, 0)); this.rd.drawLine(350, 461, 450, 461); }
              this.rd.drawString("Roof Destruction :", 350, 460);
             this.rd.drawLine(461, 456, 551, 456);
             for (b4 = 1; b4 < 10; ) { this.rd.drawLine(461 + 10 * b4, 456 - b4, 461 + 10 * b4, 456 + b4); b4++; }
              this.rd.setColor(new Color(255, 0, 0));
             j = (int)(this.crash[2] / 1.1111F / 10.0F);
             this.rd.fillRect(459 + (int)(this.crash[2] / 1.1111F), 456 - j, 5, j * 2 + 1);
             this.rd.setColor(new Color(255, 128, 0));
             this.rd.drawRect(460 + (int)(this.crash[2] / 1.1111F), 447, 2, 18);
             stringbutton(" - ", 581, 460, 4, false);
             stringbutton(" + ", 621, 460, 4, false);
 
             
             stringbutton("    CRASH!    ", 143, 516, 0, true);
             stringbutton("  Fix  ", 235, 516, 0, false);
             
             stringbutton("    CRASH Roof!    ", 484, 492, 0, true);
             stringbutton("  Fix  ", 591, 492, 0, false);
             
             stringbutton(" Reset ", 435, 535, 0, false);
             stringbutton(" <  Back ", 508, 535, 0, false);
             stringbutton("       Next  >       ", 602, 535, 0, true);
           } 
           
           if (this.pfase == 3) {
             
             this.rd.setColor(new Color(0, 0, 0));
             this.rd.drawString("Select the most suitable engine for your car :", 30, 440);
             this.engine.move(293, 424);
             if (!this.engine.isShowing()) { this.engine.show(); this.engine.select(this.engsel); }
              if (this.engsel != this.engine.getSelectedIndex()) { byte b4; for (this.engsel = this.engine.getSelectedIndex(), b4 = 0; b4 < 5; ) { for (byte b5 = 0; b5 < 5; ) { this.engs[b5][b4].stop(); this.engs[b5][b4].checkopen(); b5++; }  b4++; }  this.engon = false; }
             
             if (this.engsel == 0) this.rd.drawString("Normal Engine:  Like Tornado Shark, Sword of Justice or Radical One's engine.", 30, 470); 
             if (this.engsel == 1) this.rd.drawString("V8 Engine:  High speed engine like Formula 7, Drifter X or Might Eight's engine.", 30, 470); 
             if (this.engsel == 2) this.rd.drawString("Retro Engine:  Like Wow Caninaro, Lead Oxide or Kool Kat’s engine.", 30, 470); 
             if (this.engsel == 3) this.rd.drawString("Power Engine:  Turbo/super charged engine like Max Revenge, High Rider or Dr Monstaa’s engine.", 30, 470); 
             if (this.engsel == 4) this.rd.drawString("Diesel Engine:  Big diesel powered engine for big cars like EL King or  M A S H E E N .", 30, 470);
             
             this.rd.drawString("LISTEN :", 30, 500);
             stringbutton(" Idle ", 108, 500, 0, true);
             stringbutton(" RPM 1 ", 170, 500, 0, true);
             stringbutton(" RPM 2 ", 240, 500, 0, true);
             stringbutton(" RPM 3 ", 310, 500, 0, true);
             stringbutton(" RPM MAX ", 389, 500, 0, true);
             
             if (this.engon) { stringbutton("          Stop Engine          ", 240, 535, 0, true); } else { stringbutton("          Stop Engine          ", 240, -2500, 0, true); }
             
             stringbutton(" <  Back ", 500, 525, 0, false);
             stringbutton("     Save & Finish!     ", 610, 525, 0, true);
           } 
           
           if (this.pfase == 4) {
             
             this.rd.drawString("Testing & Setting up Physics...", 265, 470);
             repaint(); 
             try { Thread.sleep(100L); } catch (InterruptedException interruptedException) {}
             
             for (byte b4 = 0; b4 < 4; b4++) {
               
               byte b6 = 0, b7 = 4;
               if (b4 == 1) b7 = 2; 
               if (b4 == 2) b6 = 2;
               
               for (byte b8 = 0; b8 < 10; b8++) {
                 
                 setupo();
                 this.o.xy = 0;
                 this.hitmag = 0;
                 int n = 0;
                 this.actmag = 0;
                 byte b11 = b6;
                 boolean bool = false;
                 while (this.hitmag < 17000) {
                   
                   if (bool) { regx(b11, (int)(150.0D + 600.0D * Math.random()), true); } else { regz(b11, (int)(150.0D + 600.0D * Math.random()), true); }
                    b11++;
                   if (b11 == b7) { this.o.xz += 45; this.o.zy += 45; b11 = 0; if (bool) { bool = false; } else { bool = true; }  if (n == this.actmag) this.crash[0] = this.crash[0] + 10;  n = this.actmag; }
                 
                 } 
               }  float f1 = 0.0F;
               for (byte b9 = 0; b9 < 10; b9++) {
                 
                 setupo();
                 this.o.xy = 0;
                 this.actmag = 0;
                 this.hitmag = 0;
                 byte b11 = b6;
                 boolean bool = false;
                 while (this.hitmag < 17000) {
                   
                   if (bool) { regx(b11, (int)(150.0D + 600.0D * Math.random()), true); } else { regz(b11, (int)(150.0D + 600.0D * Math.random()), true); }
                    b11++;
                   if (b11 == b7) { this.o.xz += 45; this.o.zy += 45; b11 = 0; if (bool) { bool = false; continue; }  bool = true; }
                 
                 }  f1 += this.actmag / this.hitmag;
               } 
               f1 /= 10.0F;
               this.actmag = (int)(this.hitmag * f1);
               if (this.stat[4] > 200) this.stat[4] = 200;  if (this.stat[4] < 16) this.stat[4] = 16; 
               float f2 = 0.9F + (this.stat[4] - 90) * 0.01F;
               if (f2 < 0.6D) f2 = 0.6F; 
               if (this.stat[4] == 200 && this.stat[0] <= 88) f2 = 3.0F; 
               int m = (int)(this.actmag * f2); byte b10;
               for (b10 = 0; b10 < 12; b10++) {
                 
                 setupo();
                 this.o.xy = 0;
                 this.o.xz = 90 * b10; if (this.o.xz >= 360) this.o.xz -= 360; 
                 this.hitmag = 0;
                 int n = 0;
                 this.actmag = 0;
                 byte b11 = b6;
                 boolean bool = false;
                 while (this.actmag < m) {
                   
                   if (bool) { regx(b11, (int)(150.0D + 600.0D * Math.random()), true); } else { regz(b11, (int)(150.0D + 600.0D * Math.random()), true); }
                    b11++;
                   if (b11 == b7) { if (bool) { bool = false; } else { bool = true; }  b11 = 0; if (n == this.actmag) this.crash[0] = this.crash[0] + 10;  n = this.actmag; }
                 
                 } 
               } 
               if (b4 == 3) {
                 
                 f1 = 0.0F;
                 for (b10 = 0; b10 < 10; b10++) {
                   
                   setupo();
                   this.o.xy = 0;
                   this.actmag = 0;
                   this.hitmag = 0;
                   byte b11 = b6;
                   boolean bool = false;
                   while (this.hitmag < 17000) {
                     
                     if (bool) { regx(b11, (int)(150.0D + 600.0D * Math.random()), true); } else { regz(b11, (int)(150.0D + 600.0D * Math.random()), true); }
                      b11++;
                     if (b11 == b7) { this.o.xz += 45; this.o.zy += 45; b11 = 0; if (bool) { bool = false; continue; }  bool = true; }
                   
                   }  f1 += this.actmag / this.hitmag;
                 } 
                 f1 /= 10.0F;
                 this.actmag = (int)(this.hitmag * f1);
               } 
             } 
 
 
             
             setupo();
             
             String str1 = "" + this.editor.getText() + "\n";
             String str2 = "";
             int j = 0, k = str1.indexOf("\n", 0);
             while (k != -1 && j < str1.length()) {
               
               String str = str1.substring(j, k); str = str.trim();
               j = k + 1; k = str1.indexOf("\n", j);
               if (!str.startsWith("physics(")) { str2 = str2 + "" + str + "\n"; continue; }  str2 = str2.trim(); str2 = str2 + "\n";
             } 
             str2 = str2.trim();
             str2 = str2 + "\n\n\nphysics(" + this.phys[0] + "," + this.phys[1] + "," + this.phys[2] + "," + this.phys[3] + "," + this.phys[4] + "," + this.phys[5] + "," + this.phys[6] + "," + this.phys[7] + "," + this.phys[8] + "," + this.phys[9] + "," + this.phys[10] + "," + this.crash[0] + "," + this.crash[1] + "," + this.crash[2] + "," + this.engsel + "," + this.actmag + ")\n\n\n\n";
             this.editor.setText(str2);
             savefile(); byte b5;
             for (b5 = 0; b5 < 11; ) { this.rphys[b5] = this.phys[b5]; b5++; }
              for (b5 = 0; b5 < 3; ) { this.rcrash[b5] = this.crash[b5]; b5++; }
              this.pfase = 5;
           } 
           
           if (this.pfase == 5) {
             
             this.rd.drawString("Car physics has been successfully set up!", 231, 450);
             this.rd.drawString("Test drive your car to see the results...", 242, 490);
           } 
 
           
           if (i != -1) { if (this.mouseon == -1) { this.mouseon = i; setCursor(new Cursor(12)); }  } else if (this.mouseon != -1) { this.mouseon = -1; setCursor(new Cursor(0)); }
            if (this.mouses == -1 && i != -1) JOptionPane.showMessageDialog(null, this.usage[i], "Car Maker", 1);
         
         } 
         
         if (this.dtab == 6) {
           
           if (this.dtab != this.dtabed) {
             
             String str = "" + this.editor.getText() + "\n";
             int j = 0, k = str.indexOf("\n", 0);
             while (k != -1 && j < str.length()) {
               
               String str1 = str.substring(j, k); str1 = str1.trim();
               j = k + 1; k = str.indexOf("\n", j);
               if (str1.startsWith("handling(")) try { this.handling = getvalue("handling", str1, 0); if (this.handling > 200) this.handling = 200;  if (this.handling < 50) this.handling = 50;  } catch (Exception exception) {} 
             } 
             this.rateh = false;
           } 
           
           if (!this.rateh) {
             
             this.rd.setFont(new Font("Arial", 1, 13)); this.ftm = this.rd.getFontMetrics();
             this.rd.drawString("Test Drive the Car", 350 - this.ftm.stringWidth("Test Drive the Car") / 2, 445);
             this.witho.move(292, 455);
             if (!this.witho.isShowing()) this.witho.show(); 
             stringbutton("     TEST DRIVE!     ", 350, 505, 0, true);
             if (this.tested)
             {
               stringbutton("  Edit Stats & Class  ", 150, 471, 0, false);
               stringbutton("  Edit Physics  ", 150, 505, 0, false);
               stringbutton("     Rate Car Handling     ", 550, 471, 0, true);
             }
           
           } else {
             
             this.rd.setFont(new Font("Arial", 1, 13)); this.ftm = this.rd.getFontMetrics();
             this.rd.drawString("Based on you test drive(s), how do your rate " + this.carname + "'s handling?", 350 - this.ftm.stringWidth("Based on your test drive(s), how do you rate " + this.carname + "'s handling?") / 2, 445);
             this.rd.setFont(new Font("Arial", 1, 12));
             this.rd.drawString("Handling :", 183, 483);
             for (i = 0; i < this.handling; ) { this.rd.setColor(Color.getHSBColor((float)(i * 7.0E-4D), 1.0F, 1.0F)); this.rd.drawLine(250 + i, 474, 250 + i, 482); i++; }
              this.rd.setColor(new Color(0, 0, 0)); this.rd.drawLine(249, 474, 249, 482); this.rd.drawLine(450, 474, 450, 482); this.rd.drawLine(249, 483, 450, 483);
             for (i = 0; i < 7; ) { this.rd.drawLine(275 + i * 25, 482, 275 + i * 25, 478); i++; }
              stringbutton(" - ", 480, 483, 4, false);
             stringbutton(" + ", 520, 483, 4, false);
             stringbutton("       Save       ", 388, 525, 0, true);
             stringbutton(" Cancel ", 298, 525, 0, false);
           } 
         } 
 
         
         if (this.polynum >= 0 && this.cntpls > 0) { for (i = 0; i < this.o.npl; ) { if (i >= this.polynum && i < this.polynum + this.cntpls) { if (this.pflk) { (this.o.p[i]).hsb[2] = 1.0F; } else { for ((this.o.p[i]).hsb[2] = 0.0F, (this.o.p[i]).hsb[0] = Math.abs(0.5F - (this.o.p[i]).hsb[0]); (this.o.p[i]).hsb[0] > 1.0F; (this.o.p[i]).hsb[0] = (this.o.p[i]).hsb[0] - 1.0F); }  } else if (this.prflk > 6 && this.prflk < 20) { (this.o.p[i]).gr = -13; } else { (this.o.p[i]).gr = 1; }  i++; }  if (this.pflk) { this.pflk = false; } else { this.pflk = true; }  if (this.prflk < 40) this.prflk++;  this.rd.setFont(new Font("Arial", 1, 12)); this.rd.setColor(new Color(0, 0, 0)); this.rd.drawString("[ Showing " + this.cntpls + " Polygons Selected ]", 350 - this.ftm.stringWidth("[ Showing " + this.cntpls + " Polygons Selected ]") / 2, 45); stringbutton("  Stop  ", 350, 67, 5, false); }
 
         
         b1 = 50;
         if (this.rotr) { this.o.xz -= 5; b1 = 15; }
          if (this.rotl) { this.o.xz += 5; b1 = 15; }
          if (this.left) { this.o.xy -= 5; b1 = 15; }
          if (this.right) { this.o.xy += 5; b1 = 15; }
          if (this.up) { this.o.zy -= 5; b1 = 15; }
          if (this.down) { this.o.zy += 5; b1 = 15; }
          if (this.plus) { this.o.y += 5; b1 = 15; }
          if (this.minus) { this.o.y -= 5; b1 = 15; }
          if (this.in) { this.o.z += 10; b1 = 15; }
          if (this.out) { this.o.z -= 10; b1 = 15; }
          this.ox = this.o.x; this.oy = this.o.y; this.oz = this.o.z; this.oxz = this.o.xz; this.oxy = this.o.xy; this.ozy = this.o.zy;
         
         if (this.dtabed != this.dtab) this.dtabed = this.dtab;
         
         if (this.dtab == 5 && this.pfase == -1) { repaint(); JOptionPane.showMessageDialog(null, "Car Wheels not defined or not defined correctly.\nBefore defining the car Physics car Wheels must be defined correctly!\nPlease go to the ‘Wheels’ tab and use  [ Apply ]  and  [ Save ]  to define correctly.\n", "Car Maker", 1); this.dtab = 3; }
       
       } 
       if (this.tab == 3) {
         
         this.rd.setFont(new Font("Arial", 1, 13));
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString("Publish Car :  [ " + this.carname + " ]", 30, 50);
         this.rd.drawString("Publishing Type :", 30, 80);
         this.pubtyp.move(150, 63);
         if (!this.pubtyp.isShowing()) { this.pubtyp.show(); this.pubtyp.select(1); }
          stringbutton("       Publish  >       ", 102, 110, 0, true);
         this.pubitem.move(690 - this.pubitem.w, 96);
         if (!this.pubitem.isShowing()) this.pubitem.show(); 
         if (this.pubitem.sel != 0) {
           
           boolean bool = false;
           for (byte b4 = 0; b4 < this.nmc; ) { if (this.pubitem.getSelectedItem().equals(this.mycars[b4])) bool = true;  b4++; }
            if (!bool) this.logged = 2; 
         } 
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.setFont(new Font("Arial", 0, 12));
         if (this.pubtyp.getSelectedIndex() == 0) {
           
           this.rd.drawString("Private :  This means only you can use your car and no one else can add", 268, 72);
           this.rd.drawString("it to their account to play with it !", 268, 88);
         } 
         if (this.pubtyp.getSelectedIndex() == 1) {
           
           this.rd.drawString("Public :  This means anyone can add this car to their account to play with it,", 268, 72);
           this.rd.drawString("but only you can download it to your Car Maker (no one else can get it’s code).", 268, 88);
         } 
         if (this.pubtyp.getSelectedIndex() == 2) {
           
           this.rd.drawString("Super Public :  This means anyone can add this car to their account to play", 268, 72);
           this.rd.drawString("with it and anyone can also download it to their Car Maker to get its code.", 268, 88);
         } 
         
         this.rd.setFont(new Font("Arial", 1, 12)); this.ftm = this.rd.getFontMetrics();
         this.rd.drawString("Car Name", 80 - this.ftm.stringWidth("Car Name") / 2, 138);
         this.rd.drawString("Car Class", 200 - this.ftm.stringWidth("Car Class") / 2, 138);
         this.rd.drawString("Created By", 300 - this.ftm.stringWidth("Created By") / 2, 138);
         this.rd.drawString("Added By", 400 - this.ftm.stringWidth("Added By") / 2, 138);
         this.rd.drawString("Publish Type", 500 - this.ftm.stringWidth("Publish Type") / 2, 138);
         this.rd.drawString("Options", 620 - this.ftm.stringWidth("Options") / 2, 138);
         this.rd.drawLine(150, 129, 150, 140);
         this.rd.drawLine(250, 129, 250, 140);
         this.rd.drawLine(350, 129, 350, 140);
         this.rd.drawLine(450, 129, 450, 140);
         this.rd.drawLine(550, 129, 550, 140);
         this.rd.drawRect(10, 140, 680, 402);
         
         if (this.logged == 0) {
 
 
           
           this.rd.setFont(new Font("Arial", 1, 13)); this.ftm = this.rd.getFontMetrics();
           this.rd.drawString("Login to Retrieve your Account Cars", 350 - this.ftm.stringWidth("Login to Retrieve your Account Cars") / 2, 220);
           this.rd.drawString("Nickname:", 326 - this.ftm.stringWidth("Nickname:") - 14, 266);
           movefield(this.tnick, 326, 250, 129, 22);
           if (!this.tnick.isShowing()) this.tnick.show(); 
           this.rd.drawString("Password:", 326 - this.ftm.stringWidth("Password:") - 14, 296);
           movefield(this.tpass, 326, 280, 129, 22);
           if (!this.tpass.isShowing()) this.tpass.show(); 
           stringbutton("       Login       ", 350, 340, 0, true);
           this.rd.setFont(new Font("Arial", 1, 13)); this.ftm = this.rd.getFontMetrics();
           
           this.rd.drawString("Register a full account or if you have a trial account upgrade it!", 350 - this.ftm.stringWidth("Register a full account or if you have a trial account upgrade it!") / 2, 450);
 
           
           stringbutton("   Register!   ", 290, 480, 0, true);
           stringbutton("   Upgrade!   ", 410, 480, 0, true);
           this.rd.setFont(new Font("Arial", 0, 12)); this.ftm = this.rd.getFontMetrics();
           this.rd.drawString("You need a full account to publish your cars to the multiplayer game!", 350 - this.ftm.stringWidth("You need a full account to publish your cars to the multiplayer game!") / 2, 505);
         } 
         
         if (this.logged == -1) {
           
           this.rd.setFont(new Font("Arial", 1, 13)); this.ftm = this.rd.getFontMetrics();
           this.rd.drawString("Ready to publish...", 350 - this.ftm.stringWidth("Ready to publish...") / 2, 220);
           this.rd.drawString("Click ‘Publish’ above to add car: '" + this.carname + "'.", 350 - this.ftm.stringWidth("Click ‘Publish’ above to add car: '" + this.carname + "'.") / 2, 280);
         } 
 
 
 
         
         if (this.logged == 2) {
           
           this.mycars[this.roto] = this.pubitem.getSelectedItem();
           this.rd.setFont(new Font("Arial", 1, 13)); this.ftm = this.rd.getFontMetrics();
           this.rd.setColor(new Color(225, 225, 225));
           this.rd.fillRect(50, 150, 600, 150);
           this.rd.setColor(new Color(0, 0, 0));
           this.rd.drawString("Loading " + this.mycars[this.roto] + "‘s info...", 350 - this.ftm.stringWidth("Loading " + this.mycars[this.roto] + "‘s info...") / 2, 220);
           repaint();
           this.maker[this.roto] = "Unkown";
           this.pubt[this.roto] = -1;
           this.clas[this.roto] = 0;
           this.nad[this.roto] = 0;
           String str = "";
           
           try {
             String str1 = "http://multiplayer.needformadness.com/cars/" + this.mycars[this.roto] + ".txt?reqlo=" + (int)(Math.random() * 1000.0D) + ""; str1 = str1.replace(' ', '_');
             URL uRL = new URL(str1);
             DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
             while ((str = dataInputStream.readLine()) != null) {
               
               str = "" + str.trim();
               if (str.startsWith("details")) {
                 
                 this.maker[this.roto] = getSvalue("details", str, 0);
                 this.pubt[this.roto] = getvalue("details", str, 1);
                 this.clas[this.roto] = getvalue("details", str, 2);
                 for (boolean bool = false; !bool; ) { this.addeda[this.roto][this.nad[this.roto]] = getSvalue("details", str, 3 + this.nad[this.roto]); if (this.addeda[this.roto][this.nad[this.roto]].equals("")) { bool = true; continue; }  this.nad[this.roto] = this.nad[this.roto] + 1; }
               
               } 
             }  this.nmc++; if (this.nmc > 20) this.nmc = 20; 
             this.roto++; if (this.roto >= 20) this.roto = 0; 
           } catch (Exception exception) {}
           this.logged = 3;
         } 
         
         if (this.logged == 1) {
           
           this.rd.setFont(new Font("Arial", 1, 13)); this.ftm = this.rd.getFontMetrics();
           this.rd.drawString("Loading your account car list...", 350 - this.ftm.stringWidth("Loading your account car list...") / 2, 220);
           repaint();
           this.pubitem.removeAll();
           this.pubitem.add(this.rd, "Account Cars");
           this.nmc = 0;
           this.roto = 0;
           byte b4 = 0;
           String str = "";
 
           
           try { URL uRL = new URL("http://multiplayer.needformadness.com/cars/lists/" + this.tnick.getText() + ".txt?reqlo=" + (int)(Math.random() * 1000.0D) + "");
             DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
             while ((str = dataInputStream.readLine()) != null) { str = "" + str.trim();
               if (str.startsWith("mycars")) for (boolean bool = true; bool && b4 < 'ʼ'; ) { String str1 = getSvalue("mycars", str, b4); if (str1.equals("")) { bool = false; continue; }  this.pubitem.add(this.rd, str1); b4++; }
                   }
              setCursor(new Cursor(0)); this.logged = -1;
             dataInputStream.close(); }
           catch (Exception exception) { String str1 = "" + exception; if (str1.indexOf("FileNotFound") != -1) { setCursor(new Cursor(0)); this.logged = -1; } else { this.logged = 0; JOptionPane.showMessageDialog(null, "Unable to connect to server at this moment, please try again later.", "Car Maker", 1); }  }
            if (!this.justpubd.equals("")) { this.pubitem.select(this.justpubd); this.justpubd = ""; }
         
         } 
         if (this.logged == 3)
         {
           for (byte b4 = 0; b4 < this.nmc; b4++) {
             
             this.rd.setColor(new Color(235, 235, 235));
             if (this.xm > 11 && this.xm < 689 && this.ym > 142 + b4 * 20 && this.ym < 160 + b4 * 20) this.rd.setColor(new Color(255, 255, 255)); 
             this.rd.fillRect(11, 142 + b4 * 20, 678, 18);
             
             this.rd.setFont(new Font("Arial", 0, 12)); this.ftm = this.rd.getFontMetrics();
             this.rd.setColor(new Color(0, 0, 0));
             this.rd.drawString(this.mycars[b4], 80 - this.ftm.stringWidth(this.mycars[b4]) / 2, 156 + b4 * 20);
             this.rd.setColor(new Color(155, 155, 155));
             this.rd.drawLine(150, 145 + b4 * 20, 150, 157 + b4 * 20);
             
             if (this.pubt[b4] != -1) {
               
               this.rd.drawLine(250, 145 + b4 * 20, 250, 157 + b4 * 20);
               this.rd.drawLine(350, 145 + b4 * 20, 350, 157 + b4 * 20);
               this.rd.drawLine(450, 145 + b4 * 20, 450, 157 + b4 * 20);
               this.rd.drawLine(550, 145 + b4 * 20, 550, 157 + b4 * 20);
               
               this.rd.setColor(new Color(0, 0, 64));
               String str = "C"; if (this.clas[b4] == 1) str = "B & C";  if (this.clas[b4] == 2) str = "B";  if (this.clas[b4] == 3) str = "A & B";  if (this.clas[b4] == 4) str = "A"; 
               this.rd.drawString("Class " + str + "", 200 - this.ftm.stringWidth("Class " + str + "") / 2, 156 + b4 * 20);
               
               boolean bool = false;
               if (this.maker[b4].toLowerCase().equals(this.tnick.getText().toLowerCase())) { bool = true; this.rd.setColor(new Color(0, 64, 0)); this.rd.drawString("You", 300 - this.ftm.stringWidth("You") / 2, 156 + b4 * 20); } else { this.rd.drawString(this.maker[b4], 300 - this.ftm.stringWidth(this.maker[b4]) / 2, 156 + b4 * 20); }
               
               if (this.nad[b4] > 1)
               
               { if (ovbutton("" + this.nad[b4] + " Players", 400, 156 + b4 * 20)) { String str1; byte b5; byte b6; for (str1 = "[ " + this.mycars[b4] + " ]  has been added by the following players to their accounts:     \n\n", b5 = 0, b6 = 0; b6 < this.nad[b4]; ) { if (++b5 == 17) { str1 = str1 + "\n"; b5 = 1; }  str1 = str1 + this.addeda[b4][b6]; if (b6 != this.nad[b4] - 1) if (b6 != this.nad[b4] - 2) { str1 = str1 + ", "; } else if (b5 == 16) { str1 = str1 + "\nand "; b5 = 0; } else { str1 = str1 + " and "; }   b6++; }  str1 = str1 + "\n \n \n"; JOptionPane.showMessageDialog(null, str1, "Car Maker", 1); }  }
               else { this.rd.setColor(new Color(0, 0, 64)); this.rd.drawString("None", 400 - this.ftm.stringWidth("None") / 2, 156 + b4 * 20); }
 
               
               if (this.pubt[b4] == 0) { this.rd.setColor(new Color(0, 0, 64)); this.rd.drawString("Private", 500 - this.ftm.stringWidth("Private") / 2, 156 + b4 * 20); }
                if (this.pubt[b4] == 1) { this.rd.setColor(new Color(0, 0, 64)); this.rd.drawString("Public", 500 - this.ftm.stringWidth("Public") / 2, 156 + b4 * 20); }
                if (this.pubt[b4] == 2) { this.rd.setColor(new Color(0, 64, 0)); this.rd.drawString("Super Public", 500 - this.ftm.stringWidth("Super Public") / 2, 156 + b4 * 20); }
               
               if (this.pubt[b4] == 2 || bool)
               {
                 if (ovbutton("Download", 600, 156 + b4 * 20)) {
                   
                   int i = 0;
                   for (byte b5 = 0; b5 < this.slcar.getItemCount(); b5++) {
                     
                     if (this.mycars[b4].equals(this.slcar.getItem(b5))) i = JOptionPane.showConfirmDialog(null, "Replace the local " + this.mycars[b4] + " in your 'mycars' folder with the published online copy?", "Car Maker", 0); 
                   } 
                   if (i == 0) {
                     
                     setCursor(new Cursor(3));
                     this.rd.setFont(new Font("Arial", 1, 13)); this.ftm = this.rd.getFontMetrics();
                     this.rd.setColor(new Color(225, 225, 225)); this.rd.fillRect(11, 141, 679, 401);
                     this.rd.setColor(new Color(0, 0, 0)); this.rd.drawString("Downloading car, please wait...", 350 - this.ftm.stringWidth("Downloading car, please wait...") / 2, 250);
                     repaint(); 
                     try { ZipInputStream zipInputStream;
                       String str1 = "http://multiplayer.needformadness.com/cars/" + this.mycars[b4] + ".radq?reqlo=" + (int)(Math.random() * 1000.0D) + ""; str1 = str1.replace(' ', '_');
                       URL uRL = new URL(str1);
 
                       
                       int j = uRL.openConnection().getContentLength();
                       DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
                       byte[] arrayOfByte = new byte[j]; dataInputStream.readFully(arrayOfByte);
                       if (arrayOfByte[0] == 80 && arrayOfByte[1] == 75 && arrayOfByte[2] == 3) {
                         
                         zipInputStream = new ZipInputStream(new ByteArrayInputStream(arrayOfByte));
                       } else {
                         byte[] arrayOfByte1;
                         byte b6;
                         for (arrayOfByte1 = new byte[j - 40], b6 = 0; b6 < j - 40; ) { byte b7 = 20; if (b6 >= 'Ǵ') b7 = 40;  arrayOfByte1[b6] = arrayOfByte[b6 + b7]; b6++; }
                          zipInputStream = new ZipInputStream(new ByteArrayInputStream(arrayOfByte1));
                       } 
                       
                       ZipEntry zipEntry = zipInputStream.getNextEntry();
                       if (zipEntry != null)
                       
                       { int k = Integer.valueOf(zipEntry.getName()).intValue();
                         byte[] arrayOfByte1 = new byte[k];
                         int m = 0;
                         
                         while (k > 0) { int i2 = zipInputStream.read(arrayOfByte1, m, k); m += i2; k -= i2; }
                          String str2 = new String(arrayOfByte1); str2 = str2 + "\n";
                         String str3 = "";
                         int n = 0, i1 = str2.indexOf("\n", 0);
                         while (i1 != -1 && n < str2.length()) {
                           
                           String str4 = str2.substring(n, i1); str4 = str4.trim();
                           n = i1 + 1; i1 = str2.indexOf("\n", n);
                           if (!str4.startsWith("carmaker(") && !str4.startsWith("publish(")) { str3 = str3 + "" + str4 + "\n"; continue; }  str3 = str3.trim(); str3 = str3 + "\n";
                         } 
                         str3 = str3.trim();
                         str3 = str3 + "\n\n";
                         
                         File file = new File("" + Madness.fpath + "mycars/"); if (!file.exists()) file.mkdirs(); 
                         file = new File("" + Madness.fpath + "mycars/" + this.mycars[b4] + ".rad");
                         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                         bufferedWriter.write(str3);
                         bufferedWriter.close();
                         bufferedWriter = null;
                         zipInputStream.close();
                         if (this.carname.equals(this.mycars[b4])) { this.editor.setText(str3); this.lastedo = str3; }
                          setCursor(new Cursor(0));
                         JOptionPane.showMessageDialog(null, "" + this.mycars[b4] + " has been successfully downloaded!", "Car Maker", 1); }
                       else { JOptionPane.showMessageDialog(null, "Unable to download car.  Unknown Error!     \nPlease try again later.", "Car Maker", 1); }
                        }
                     catch (Exception exception) { JOptionPane.showMessageDialog(null, "Unable to download car.  Unknown Error!     \nPlease try again later.", "Car Maker", 1); }
                   
                   } 
                 } 
               }
             } else {
               this.rd.drawString("-    Error Loading this car's info!    -", 350 - this.ftm.stringWidth("-    Error Loading this car's info!    -") / 2, 156 + b4 * 20);
             } 
             if (ovbutton("X", 665, 156 + b4 * 20))
             {
               if (JOptionPane.showConfirmDialog(null, "Remove " + this.mycars[b4] + " from your account?", "Car Maker", 0) == 0) {
                 
                 setCursor(new Cursor(3));
                 int i = -1;
                 
                 try {
                   Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                   PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                   printWriter.println("9|" + this.tnick.getText() + "|" + this.tpass.getText() + "|" + this.mycars[b4] + "|");
                   String str = bufferedReader.readLine();
                   if (str != null) i = servervalue(str, 0); 
                   socket.close();
                 } catch (Exception exception) {
                   i = -1;
                 }  if (i == 0) { this.logged = 1; } else { setCursor(new Cursor(0)); JOptionPane.showMessageDialog(null, "Failed to remove " + this.mycars[b4] + " from your account.  Unknown Error!     \nPlease try again later.", "Car Maker", 1); }
               
               } 
             }
           } 
         }
       } 
 
 
 
 
       
       if (this.tabed != this.tab) this.tabed = this.tab;
 
       
       this.rd.setColor(new Color(0, 0, 0));
       this.rd.fillRect(0, 0, 700, 25);
       if (!this.onbtgame) { this.rd.drawImage(this.btgame[0], 520, 0, (ImageObserver)null); } else { this.rd.drawImage(this.btgame[1], 520, 0, (ImageObserver)null); }
       
       this.rd.setFont(new Font("Arial", 1, 13)); this.ftm = this.rd.getFontMetrics();
       
       String[] arrayOfString = { "Car", "Code Edit", "3D Edit", "Publish" };
       int[] arrayOfInt1 = { 0, 0, 100, 90 };
       int[] arrayOfInt2 = { 0, 25, 25, 0 };
       
       byte b2 = 4;
       if (this.carname.equals("") || !this.loadedfile || this.sfase != 0) { this.tab = 0; b2 = 1; }
       
       for (byte b3 = 0; b3 < b2; b3++) {
         
         this.rd.setColor(new Color(170, 170, 170));
         if (this.xm > arrayOfInt1[0] && this.xm < arrayOfInt1[3] && this.ym > 0 && this.ym < 25) this.rd.setColor(new Color(200, 200, 200)); 
         if (this.tab == b3) this.rd.setColor(new Color(225, 225, 225));
         
         this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
         this.rd.setColor(new Color(0, 0, 0));
         this.rd.drawString(arrayOfString[b3], b3 * 100 + 45 - this.ftm.stringWidth(arrayOfString[b3]) / 2, 17);
         if (this.xm > arrayOfInt1[0] && this.xm < arrayOfInt1[3] && this.ym > 0 && this.ym < 25 && this.mouses == -1) { if (this.tab != b3 && this.tab == 1) savefile();  this.tab = b3; }
          for (byte b4 = 0; b4 < 4; ) { arrayOfInt1[b4] = arrayOfInt1[b4] + 100; b4++; }
       
       } 
       drawms();
       ctachm();
       repaint();
       if (!this.exwist) try { Thread.sleep(b1); } catch (InterruptedException interruptedException) {} 
     } 
     this.rd.dispose();
     System.gc();
     if (Madness.endadv == 2) Madness.advopen(); 
   }
   
   int sls = -1, sle = -1;
 
   
   public void ctachm() {
     int i = -1; int j;
     for (j = 0; j < this.btn; j++) {
       
       if (Math.abs(this.xm - this.bx[j]) < this.bw[j] / 2 + 12 && Math.abs(this.ym - this.by[j]) < 14 && this.mouses == 1) { this.pessd[j] = true; } else { this.pessd[j] = false; }
        if (Math.abs(this.xm - this.bx[j]) < this.bw[j] / 2 + 12 && Math.abs(this.ym - this.by[j]) < 14 && this.mouses == -1) i = j; 
     } 
     if (this.mouses == -1) this.mouses = 0;
 
     
     if (this.tab == 0) {
       
       if (this.sfase == 0) {
         
         if (i == 0) { this.sfase = 1; i = -1; hidefields(); }
          if (i == 1) if (!this.carname.equals("")) { this.srch.setText(this.carname); this.sfase = 2; i = -1; hidefields(); } else { JOptionPane.showMessageDialog(null, "Please Select a Car to Rename!\n", "Car Maker", 1); }
             if (i == 2) delcar(this.carname); 
         if (i == 3) { this.sfase = 3; i = -1; hidefields(); }
       
       }  if (this.sfase == 1) {
         
         if (i == 0) { newcar(this.srch.getText()); i = -1; }
          if (i == 1) { this.srch.setText(""); this.sfase = 0; i = -1; hidefields(); }
       
       } 
       if (this.sfase == 2) {
         
         if (i == 0) { rencar(this.srch.getText()); i = -1; }
          if (i == 1) { this.srch.setText(""); this.sfase = 0; i = -1; hidefields(); }
       
       } 
       if (this.sfase == 3) {
         
         if (i == 0) {
 
 
 
 
 
 
 
 
 
 
 
 
 
           
           File file = null;
           FileDialog fileDialog = new FileDialog(new Frame(), "Car Maker - Wavefront OBJ Import");
           
           fileDialog.setFile("*.obj");
           fileDialog.setMode(0);
           fileDialog.setVisible(true); 
           try { if (fileDialog.getFile() != null) file = new File("" + fileDialog.getDirectory() + "" + fileDialog.getFile() + "");  } catch (Exception exception) {}
           if (file != null) {
 
             
             setCursor(new Cursor(3));
             byte b = 0;
             if (this.tutok) b = -70;
             
             this.rd.setColor(new Color(225, 225, 225));
             this.rd.fillRect(116, 246 + b, 468, 50);
             this.rd.setColor(new Color(0, 0, 0));
             this.rd.setFont(new Font("Arial", 1, 13)); this.ftm = this.rd.getFontMetrics();
             this.rd.drawString("Reading " + file.getName() + ", please wait...", 350 - this.ftm.stringWidth("Reading " + file.getName() + ", please wait...") / 2, 276 + b);
             repaint();
             
             int[] arrayOfInt1 = new int[6000];
             int[] arrayOfInt2 = new int[6000];
             int[] arrayOfInt3 = new int[6000];
             byte b1 = 0;
             
             int[][] arrayOfInt = new int[600][100];
             int[] arrayOfInt4 = new int[600];
             byte b2 = 0;
             
             if (file.exists()) {
 
               
               try {
                 BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                 String str1 = null;
                 boolean bool1 = false, bool2 = false;
                 while ((str1 = bufferedReader.readLine()) != null) {
                   
                   if (str1.startsWith("v ")) if (b1 < 'ᝰ') { this.multf10 = true; arrayOfInt1[b1] = objvalue(str1, 0); arrayOfInt2[b1] = objvalue(str1, 1); arrayOfInt3[b1] = objvalue(str1, 2); b1++; } else { bool1 = true; }
                       if (str1.startsWith("f ")) { if (b2 < 'ɘ') { for (this.multf10 = false, this.objfacend = false, arrayOfInt4[b2] = 0; !this.objfacend && arrayOfInt4[b2] < 100; ) { arrayOfInt[b2][arrayOfInt4[b2]] = objvalue(str1, arrayOfInt4[b2]); arrayOfInt4[b2] = arrayOfInt4[b2] + 1; }  b2++; continue; }  bool2 = true; }
                 
                 }  if (bool1) JOptionPane.showMessageDialog(null, "Warning!\nThe number of Vertices in file " + file.getName() + " exceeded the maximum of 6000 that the Car Maker can read!     \n\nPlease choose a simpler model to import.\n \n", "Car Maker", 0); 
                 if (bool2) JOptionPane.showMessageDialog(null, "Warning!\nThe number of Faces in file " + file.getName() + " exceeded the maximum of 600 that the Car Maker can read!     \n\nPlease choose a simpler model to import.\n \n", "Car Maker", 0); 
                 bufferedReader.close();
                 bufferedReader = null;
               } catch (Exception exception) {
                 JOptionPane.showMessageDialog(null, "Unable to load file! Error Deatials:\n" + exception, "Car Maker", 1);
               } 
               this.rd.setColor(new Color(225, 225, 225));
               this.rd.fillRect(116, 246 + b, 468, 50);
               this.rd.setColor(new Color(0, 0, 0));
               this.rd.setFont(new Font("Arial", 1, 13)); this.ftm = this.rd.getFontMetrics();
               this.rd.drawString("Importing " + file.getName() + ", please wait...", 350 - this.ftm.stringWidth("Importing " + file.getName() + ", please wait...") / 2, 276 + b);
               repaint();
               
               this.carname = file.getName();
               if (this.carname.endsWith(".obj")) this.carname = this.carname.substring(0, this.carname.length() - 4);
               
               String str = "\n// imported car: " + this.carname + "\n---------------------\n\n// Please read the helpful information about importing cars found at:\n// http://www.needformadness.com/developer/extras.html\n\n\n";
               int k;
               for (k = 0; k < b2; k++) {
                 
                 str = str + "<p>\nc(200,200,220)\n\n";
                 for (byte b3 = 0; b3 < arrayOfInt4[k]; ) { if (arrayOfInt[k][b3] < 6000) { int m = arrayOfInt[k][b3]; str = str + "p(" + arrayOfInt1[m] + "," + -arrayOfInt2[m] + "," + arrayOfInt3[m] + ")\n"; }  b3++; }
                  str = str + "</p>\n\n";
               } 
               
               str = str + "\n\n\n\n";
               
               file = new File("" + Madness.fpath + "mycars/"); if (!file.exists()) file.mkdirs(); 
               file = new File("" + Madness.fpath + "mycars/" + this.carname + ".rad");
               k = 0;
               if (file.exists()) k = JOptionPane.showConfirmDialog(null, "Another car with the name '" + this.carname + "' already exists, replace it?      \n", "Car Maker", 0);
               
               if (k == 0)
 
                 
                 try { 
                   BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                   bufferedWriter.write(str);
                   bufferedWriter.close();
                   bufferedWriter = null;
                   if (file.exists()) { this.sfase = 0; hidefields(); this.tabed = -1; } else { this.carname = ""; JOptionPane.showMessageDialog(null, "Failed to create car, unknown reason!\n", "Car Maker", 1); }
                    }
                 catch (Exception exception) { this.carname = ""; JOptionPane.showMessageDialog(null, "Unable to create file! Error Deatials:\n" + exception, "Car Maker", 1); }
                  
             } else {
               JOptionPane.showMessageDialog(null, "Error, " + file.getName() + " was not found!", "Car Maker", 1);
             }  setCursor(new Cursor(0));
           } 
         } 
         if (i == 1) { this.sfase = 4; i = -1; }
          if (i == 2) { this.sfase = 0; i = -1; }
       
       } 
       if (this.sfase == 4) {
         
         if (i == 0) {
 
 
 
 
 
 
 
 
 
 
 
 
 
 
           
           File file = null;
           FileDialog fileDialog = new FileDialog(new Frame(), "Car Maker - Wavefront OBJ Import");
           
           fileDialog.setFile("" + this.carname + ".obj");
           fileDialog.setMode(1);
           fileDialog.setVisible(true); 
           try { if (fileDialog.getFile() != null) file = new File("" + fileDialog.getDirectory() + "" + fileDialog.getFile() + "");  } catch (Exception exception) {}
           if (file != null) {
 
             
             int k = 0;
             if (file.exists()) k = JOptionPane.showConfirmDialog(null, "File " + file.getName() + " already exists, replace it?      \n", "Car Maker", 0); 
             if (k == 0) {
               
               setCursor(new Cursor(3));
               
               setupo();
               
               int[] arrayOfInt1 = new int[6000];
               int[] arrayOfInt2 = new int[6000];
               int[] arrayOfInt3 = new int[6000];
               byte b1 = 0;
               
               String str = "";
               byte b2;
               for (b2 = 0; b2 < this.o.npl; b2++) {
                 
                 for (byte b = 0; b < (this.o.p[b2]).n; b++) {
                   
                   boolean bool = false;
                   for (byte b3 = 0; b3 < b1; ) { if (arrayOfInt1[b3] == (this.o.p[b2]).ox[b] && arrayOfInt2[b3] == (this.o.p[b2]).oy[b] && arrayOfInt3[b3] == (this.o.p[b2]).oz[b]) bool = true;  b3++; }
                    if (!bool && b1 < 'ᝰ') { arrayOfInt1[b1] = (this.o.p[b2]).ox[b]; arrayOfInt2[b1] = (this.o.p[b2]).oy[b]; arrayOfInt3[b1] = (this.o.p[b2]).oz[b]; b1++; }
                 
                 } 
               }  for (b2 = 0; b2 < b1; ) { str = str + "v " + (arrayOfInt1[b2] / 10.0F) + " " + (-arrayOfInt2[b2] / 10.0F) + " " + (arrayOfInt3[b2] / 10.0F) + "\n"; b2++; }
               
               for (b2 = 0; b2 < this.o.npl; b2++) {
                 
                 if ((this.o.p[b2]).wz == 0) {
                   
                   str = str + "f";
                   for (byte b = 0; b < (this.o.p[b2]).n; b++) {
                     
                     str = str + " ";
                     for (byte b3 = 0; b3 < b1; b3++) {
                       
                       if (arrayOfInt1[b3] == (this.o.p[b2]).ox[b] && arrayOfInt2[b3] == (this.o.p[b2]).oy[b] && arrayOfInt3[b3] == (this.o.p[b2]).oz[b]) str = str + "" + (b3 + 1); 
                     } 
                   } 
                   str = str + "\n";
                 } 
               } 
 
 
 
               
               try { BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                 bufferedWriter.write(str);
                 bufferedWriter.close();
                 bufferedWriter = null;
                 if (file.exists()) { JOptionPane.showMessageDialog(null, "Car has been successfully exported to:\n" + file.getAbsolutePath() + "          \n \n", "Car Maker", 1); this.sfase = 0; hidefields(); this.tabed = -1; } else { JOptionPane.showMessageDialog(null, "Failed to export car, unknown reason!\n", "Car Maker", 1); }
                  }
               catch (Exception exception) { JOptionPane.showMessageDialog(null, "Unable to create exported file! Error Deatials:\n" + exception, "Car Maker", 1); }
               
               setCursor(new Cursor(0));
             } 
           } 
         } 
         if (i == 1) { this.sfase = 0; i = -1; }
       
       } 
     } 
     
     if (this.tab == 1) {
       
       if (i == 0) if (this.prefs) { this.prefs = false; } else { this.prefs = true; }
           if (i == 1 || i == 2) { savefile(); if (i == 2) this.tab = 2;  }
       
       if (!this.mirror) {
         
         j = 0;
         if (i == 4) {
           
           if (this.sls != -1 && this.sle != -1 && this.editor.getSelectedText().equals(this.srch.getText())) { this.editor.replaceText(this.rplc.getText(), this.sls, this.sle); this.sls = -1; this.sle = -1; j = 1; try { Thread.sleep(100L); } catch (InterruptedException interruptedException) {} }
            i = 3;
         } 
         if (i == 3)
         {
           if (!this.srch.getText().equals("")) {
             
             this.editor.requestFocus();
             this.sls = this.editor.getText().indexOf(this.srch.getText(), this.editor.getSelectionEnd());
             if (this.sls != -1) { this.sle = this.sls + this.srch.getText().length(); this.editor.select(this.sls, this.sle); } else if (j == 0) { JOptionPane.showMessageDialog(null, "Cannot find  '" + this.srch.getText() + "'  from Cursor position    ", "Car Maker", 1); }
           
           } 
         }
       } else {
         
         if (i == 3 || i == 4 || i == 5) { String str1 = "" + this.editor.getSelectedText() + "\n", str2 = "\n\n"; if (this.cntpls == 1) { str2 = str2 + "// Mirror of the polygon above along the "; } else { str2 = str2 + "// Mirror of the " + this.cntpls + " polygons above along the "; }  if (i == 3) str2 = str2 + "X axis:";  if (i == 4) str2 = str2 + "Y axis:";  if (i == 5) str2 = str2 + "Z axis:";  int k, m; for (str2 = str2 + "\n\n", k = 0, m = str1.indexOf("\n", 0); m != -1 && k < str1.length(); ) { String str = str1.substring(k, m); str = str.trim(); k = m + 1; m = str1.indexOf("\n", k); if (str.startsWith("fs(-")) { str = "fs(" + str.substring(4, str.length()) + ""; } else if (str.startsWith("fs(")) { str = "fs(-" + str.substring(3, str.length()) + ""; }  if (i == 3) if (str.startsWith("p(-")) { str = "p(" + str.substring(3, str.length()) + ""; } else if (str.startsWith("p(")) { str = "p(-" + str.substring(2, str.length()) + ""; }   if (i == 4 && str.startsWith("p(")) { int n = str.indexOf(",", 0); if (n >= 0) if (str.startsWith(",-", n)) { str = "" + str.substring(0, n) + "," + str.substring(n + 2, str.length()) + ""; } else if (str.startsWith(",", n)) { str = "" + str.substring(0, n) + ",-" + str.substring(n + 1, str.length()) + ""; }   }  if (i == 5 && str.startsWith("p(")) { int n = str.indexOf(",", 0); n = str.indexOf(",", n + 1); if (n >= 0) if (str.startsWith(",-", n)) { str = "" + str.substring(0, n) + "," + str.substring(n + 2, str.length()) + ""; } else if (str.startsWith(",", n)) { str = "" + str.substring(0, n) + ",-" + str.substring(n + 1, str.length()) + ""; }   }  str2 = str2 + "" + str + "\n"; }  str2 = str2 + "\n// End of mirror"; this.editor.insertText(str2, this.editor.getSelectionEnd()); }
          if (i == 6) { boolean bool; for (this.polynum = 0, j = this.editor.getText().lastIndexOf("</p>", this.editor.getSelectionStart()), bool = false; j >= 0; ) { if (!bool) { j = this.editor.getText().lastIndexOf("<p>", j); if (j != -1) { bool = true; this.polynum++; }  } else { j = this.editor.getText().lastIndexOf("</p>", j); if (j != -1) bool = false;  }  j--; }  this.prflk = 0; this.tab = 2; }
       
       } 
       i = -1;
     } 
 
 
     
     if (this.tab == 2) {
       
       j = 0;
       
       if (this.dtab == 1)
       {
         if (this.o.colok != 2) {
           
           if (i == 0) {
             
             JOptionPane.showMessageDialog(null, "Car Maker will attempt now to find the first and second colors automatically.\nPlease make sure that they are the correct colors!\n\nPlease note that these are also the colors that will be editable in the multiplayer game.      ", "Car Maker", 1);
             String str1 = "" + this.editor.getText() + "\n"; int k = 0, m = str1.indexOf("\n", 0);
             byte b = 0; String str2 = "", str3 = "";
             while (m != -1 && k < str1.length() && b != 2) {
               
               String str = str1.substring(k, m); str = str.trim(); k = m + 1; m = str1.indexOf("\n", k);
               if (str.startsWith("c(")) {
                 
                 String str4 = str.substring(1, str.indexOf(")") + 1);
                 if (b == 1 && !str4.equals(str3)) { str2 = str2 + "2ndColor" + str4 + "\n\n\n"; b = 2; }
                  if (b == 0) { str3 = str4; str2 = "1stColor" + str4 + "\n"; b = 1; }
               
               } 
             }  if (b == 0) { str2 = "1stColor(255,0,0)\n2ndColor(0,0,255)\n\n\n"; b = 2; }
              if (b == 1) { str2 = str2 + "2ndColor(0,0,255)\n\n\n"; b = 2; }
              int n = this.editor.getText().indexOf("<p>", 0);
             this.editor.insertText(str2, n);
             this.editor.select(n, n + str2.length() - 2);
             this.breakbond = true;
             this.tab = 1;
           } 
           
           j = 1;
         }
         else {
           
           if (i == 0) { int k; int m; for (this.ofcol = "(" + this.o.fcol[0] + "," + this.o.fcol[1] + "," + this.o.fcol[2] + ")", m = k = this.editor.getText().indexOf(this.ofcol, 0); k != -1; ) { this.editor.replaceText(this.fcol, k, k + this.ofcol.length()); k = this.editor.getText().indexOf(this.ofcol, k + 1); }  this.ofcol = this.fcol; this.editor.select(m - 8, m - 8); savefile(); this.o.fcol[0] = Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getRed(); this.o.fcol[1] = Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getGreen(); this.o.fcol[2] = Color.getHSBColor(this.fhsb[0], this.fhsb[2], this.fhsb[1]).getBlue(); }
            if (i == 1) { int k; int m; for (this.oscol = "(" + this.o.scol[0] + "," + this.o.scol[1] + "," + this.o.scol[2] + ")", m = k = this.editor.getText().indexOf(this.oscol, 0); k != -1; ) { this.editor.replaceText(this.scol, k, k + this.oscol.length()); k = this.editor.getText().indexOf(this.oscol, k + 1); }  this.oscol = this.scol; this.editor.select(m - 8, m - 8); savefile(); this.o.scol[0] = Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getRed(); this.o.scol[1] = Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getGreen(); this.o.scol[2] = Color.getHSBColor(this.shsb[0], this.shsb[2], this.shsb[1]).getBlue(); }
            j = 2;
         } 
       }
       
       if (this.dtab == 2) {
         
         if (i == 9) { this.scale[0] = 100; this.scale[1] = 100; this.scale[2] = 100; }
          if (i == 0 || i == 1 || i == 6 || i == 7 || i == 9) { if (i == 0 || i == 6) this.scale[0] = this.scale[0] - 5;  if (i == 1 || i == 7) this.scale[0] = this.scale[0] + 5;  if (this.scale[0] < 0) this.scale[0] = 0;  int k = this.editor.getText().indexOf("\nScaleX(", 0); if (k != -1) { int m = this.editor.getText().indexOf(")", ++k), n = this.editor.getText().indexOf("\n", k); if (n > m) { this.editor.replaceText("ScaleX(" + this.scale[0] + ")", k, m + 1); } else { this.editor.replaceText("ScaleX(" + this.scale[0] + ")", k, n); }  } else { int m = this.editor.getText().indexOf("<p>", 0), n = this.editor.getText().indexOf("\nScale", 0); if (n < m && n != -1) { this.editor.insertText("\nScaleX(" + this.scale[0] + ")", n); } else { this.editor.insertText("ScaleX(" + this.scale[0] + ")\n\n\n", m); }  }  }
          if (i == 2 || i == 3 || i == 6 || i == 7 || i == 9) { if (i == 2 || i == 6) this.scale[1] = this.scale[1] - 5;  if (i == 3 || i == 7) this.scale[1] = this.scale[1] + 5;  if (this.scale[1] < 0) this.scale[1] = 0;  int k = this.editor.getText().indexOf("\nScaleY(", 0); if (k != -1) { int m = this.editor.getText().indexOf(")", ++k), n = this.editor.getText().indexOf("\n", k); if (n > m) { this.editor.replaceText("ScaleY(" + this.scale[1] + ")", k, m + 1); } else { this.editor.replaceText("ScaleY(" + this.scale[1] + ")", k, n); }  } else { int m = this.editor.getText().indexOf("<p>", 0), n = this.editor.getText().indexOf("\nScale", 0); if (n < m && n != -1) { this.editor.insertText("\nScaleY(" + this.scale[1] + ")", n); } else { this.editor.insertText("ScaleY(" + this.scale[1] + ")\n\n\n", m); }  }  }
          if (i == 4 || i == 5 || i == 6 || i == 7 || i == 9) { if (i == 4 || i == 6) this.scale[2] = this.scale[2] - 5;  if (i == 5 || i == 7) this.scale[2] = this.scale[2] + 5;  if (this.scale[2] < 0) this.scale[2] = 0;  int k = this.editor.getText().indexOf("\nScaleZ(", 0); if (k != -1) { int m = this.editor.getText().indexOf(")", ++k), n = this.editor.getText().indexOf("\n", k); if (n > m) { this.editor.replaceText("ScaleZ(" + this.scale[2] + ")", k, m + 1); } else { this.editor.replaceText("ScaleZ(" + this.scale[2] + ")", k, n); }  } else { int m = this.editor.getText().indexOf("<p>", 0), n = this.editor.getText().indexOf("\nScale", 0); if (n < m && n != -1) { this.editor.insertText("\nScaleZ(" + this.scale[2] + ")", n); } else { this.editor.insertText("ScaleZ(" + this.scale[2] + ")\n\n\n", m); }  }  }
          if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6 || i == 7 || i == 9) setupo(); 
         if (i == 8) { savefile(); this.oscale[0] = this.scale[0]; this.oscale[1] = this.scale[1]; this.oscale[2] = this.scale[2]; }
          if (i == 10 || i == 11 || i == 12 || i == 13 || i == 14 || i == 15 || i == 16 || i == 17 || i == 18) try { String str1; String str2; int k; int m; for (str1 = "" + this.editor.getText() + "\n", str2 = "", k = 0, m = str1.indexOf("\n", 0); m != -1 && k < str1.length(); ) { String str = str1.substring(k, m); str = str.trim(); k = m + 1; m = str1.indexOf("\n", k); if (str.startsWith("p(")) { int n = str.indexOf(",", 0), i1 = str.indexOf(",", n + 1), i2 = str.indexOf(")", i1 + 1); if (n != -1 && i1 != -1 && i2 != -1) { int i3 = Float.valueOf(str.substring(2, n)).intValue(), i4 = Float.valueOf(str.substring(n + 1, i1)).intValue(), i5 = Float.valueOf(str.substring(i1 + 1, i2)).intValue(); if (i == 10) { int i6 = i4; i4 = i5; i5 = -i6; }  if (i == 11) i3 += 10;  if (i == 12) i3 -= 10;  if (i == 13) { int i6 = i3; i3 = -i5; i5 = i6; }  if (i == 14) i4 += 10;  if (i == 15) i4 -= 10;  if (i == 16) { int i6 = i4; i4 = -i3; i3 = i6; }  if (i == 17) i5 += 10;  if (i == 18) i5 -= 10;  str2 = str2 + "p(" + i3 + "," + i4 + "," + i5 + ")" + str.substring(i2 + 1, str.length()) + "\n"; continue; }  str2 = str2 + "" + str + "\n"; continue; }  str2 = str2 + "" + str + "\n"; }  this.editor.setText(str2); setupo(); this.changed2 = true; } catch (Exception exception) {} 
         if (i == 19) { this.editor.setText(this.lastedo); setupo(); this.changed2 = false; }
          if (i == 20 && this.changed2) { int k = JOptionPane.showConfirmDialog(null, "Saving now will permanently change the point locations & numbers entered in the code!      \n\nContinue?", "Car Maker", 0); if (k == 0) { this.editor.setText(this.editor.getText().trim() + "\n\n\n\n"); savefile(); this.changed2 = false; }  }
          j = 21;
       } 
       
       if (this.dtab == 3) {
         
         if (i == 0 || i == 2 || this.defnow) {
           
           if (this.defnow) { this.defnow = false; repaint(); JOptionPane.showMessageDialog(null, "Car Maker will setup default Front and Back Wheels positions and adjustments.\n\nEnter the desired positions and adjustments then press ' Apply ' to view!\nDon't forget to press ' Save ' when finished!", "Car Maker", 1); }
            byte b = 0;
           try {
             int k = Float.valueOf(this.wv[10].getText()).intValue(); if (k <= 0) b = 1; 
             k = Float.valueOf(this.wv[2].getText()).intValue(); if (k >= 0) b = 2; 
             k = Float.valueOf(this.wv[8].getText()).intValue(); if (k <= 0) b = 3; 
             k = Float.valueOf(this.wv[0].getText()).intValue(); if (k <= 0) b = 4;
             
             k = Float.valueOf(this.wv[15].getText()).intValue(); if (k > 40) this.wv[15].setText("40");  if (k < -40) this.wv[15].setText("-40"); 
             k = Float.valueOf(this.wv[7].getText()).intValue(); if (k > 40) this.wv[7].setText("40");  if (k < -40) this.wv[7].setText("-40"); 
           } catch (Exception exception) {}
           
           if (b == 1) JOptionPane.showMessageDialog(null, "ERROR:\nThe Z location value of the FRONT Wheels must be greater then zero! (it should have a +ve value)\nZ :  '" + this.wv[10].getText() + "'  is less or equal to zero, where it should have +ve value!", "Car Maker", 1); 
           if (b == 2) JOptionPane.showMessageDialog(null, "ERROR:\nThe Z location value of the BACK Wheels must be smaller then zero! (it should have a -ve value)\nZ :  '" + this.wv[2].getText() + "'  is bigger or equal to zero, where it should have -ve value!", "Car Maker", 1); 
           if (b == 3) JOptionPane.showMessageDialog(null, "ERROR:\nThe ±X location value of the FRONT or BACK Wheels must be greater then zero! (it should have a +ve value)\n±X :  '" + this.wv[8].getText() + "'  is less or equal to zero, where it should have +ve value!", "Car Maker", 1); 
           if (b == 4) JOptionPane.showMessageDialog(null, "ERROR:\nThe ±X location value of the FRONT or BACK Wheels must be greater then zero! (it should have a +ve value)\n±X :  '" + this.wv[0].getText() + "'  is less or equal to zero, whenr it should have +ve value!", "Car Maker", 1);
           
           if (b == 0) {
             
             String str1 = "" + this.editor.getText() + "\n";
             String str2 = "";
             int k = 0, m = str1.indexOf("\n", 0);
             while (m != -1 && k < str1.length()) {
               
               String str = str1.substring(k, m); str = str.trim();
               k = m + 1; m = str1.indexOf("\n", k);
               if (!str.startsWith("rims(") && !str.startsWith("gwgr(") && !str.startsWith("w(")) { str2 = str2 + "" + str + "\n"; continue; }  str2 = str2.trim(); str2 = str2 + "\n";
             } 
             
             str2 = str2.trim();
             
             str2 = str2 + "\n\n\ngwgr(" + this.wv[15].getText() + ")\n";
             String str3 = "140,140,140";
             if (this.rplc.getText().startsWith("(") && this.rplc.getText().endsWith(")")) str3 = this.rplc.getText().substring(1, this.rplc.getText().length() - 1); 
             str2 = str2 + "rims(" + str3 + "," + this.wv[13].getText() + "," + this.wv[14].getText() + ")\n";
             str2 = str2 + "w(-" + this.wv[8].getText() + "," + this.wv[9].getText() + "," + this.wv[10].getText() + ",11," + this.wv[12].getText() + "," + this.wv[11].getText() + ")\n";
             str2 = str2 + "w(" + this.wv[8].getText() + "," + this.wv[9].getText() + "," + this.wv[10].getText() + ",11,-" + this.wv[12].getText() + "," + this.wv[11].getText() + ")\n";
             
             str2 = str2 + "\ngwgr(" + this.wv[7].getText() + ")\n";
             str3 = "140,140,140";
             if (this.srch.getText().startsWith("(") && this.srch.getText().endsWith(")")) str3 = this.srch.getText().substring(1, this.srch.getText().length() - 1); 
             str2 = str2 + "rims(" + str3 + "," + this.wv[5].getText() + "," + this.wv[6].getText() + ")\n";
             str2 = str2 + "w(-" + this.wv[0].getText() + "," + this.wv[1].getText() + "," + this.wv[2].getText() + ",0," + this.wv[4].getText() + "," + this.wv[3].getText() + ")\n";
             str2 = str2 + "w(" + this.wv[0].getText() + "," + this.wv[1].getText() + "," + this.wv[2].getText() + ",0,-" + this.wv[4].getText() + "," + this.wv[3].getText() + ")\n\n\n\n";
             
             this.editor.setText(str2);
             this.forwheels = true;
             setupo();
             this.forwheels = false;
             this.aply1 = "" + this.wv[0].getText() + "" + this.wv[1].getText() + "" + this.wv[2].getText() + "" + this.wv[3].getText() + "" + this.wv[4].getText() + "" + this.srch.getText() + "" + this.wv[5].getText() + "" + this.wv[6].getText() + "" + this.wv[7].getText() + "";
             this.aply2 = "" + this.wv[8].getText() + "" + this.wv[9].getText() + "" + this.wv[10].getText() + "" + this.wv[11].getText() + "" + this.wv[12].getText() + "" + this.rplc.getText() + "" + this.wv[13].getText() + "" + this.wv[14].getText() + "" + this.wv[15].getText() + "";
             this.aplyd1 = false;
             this.aplyd2 = false;
             this.changed2 = true;
           } 
         } 
         
         if (i == 1 || i == 3) if (!this.o.errd) { savefile(); this.changed2 = false; } else { JOptionPane.showMessageDialog(null, "Unable to Save, press  [ Apply ]  to find out why!", "Car Maker", 1); }
             j = 4;
       } 
 
       
       if (this.dtab == 4)
       {
         if (!this.statdef) {
           
           if (i == 0) {
             
             this.carsel = this.simcar.getSelectedIndex();
             int k = 0;
             for (byte b = 0; b < 5; ) { this.stat[b] = this.carstat[this.carsel][b]; this.rstat[b] = this.stat[b]; k += this.stat[b]; b++; }
              this.clsel = 4 - (k - 520) / 40;
             this.cls.select(this.clsel);
             if (this.simcar.getItemCount() == 16) this.simcar.add(this.rd, "   "); 
             this.statdef = true;
             this.changed2 = true;
           } 
           j = 1;
         } else {
           int k;
           
           for (k = 0; k < 5; k++) {
             
             int m = 0;
             if (i == 1 + k * 2 && this.stat[k] < 200) { m = 200 - this.stat[k]; if (m > 4) m = 4;  }
              if (i == k * 2 && this.stat[k] > 16) { m = 16 - this.stat[k]; if (m < -4) m = -4;  }
              byte b = 0;
             while (m != 0 && b != 5) {
               b = 0;
               for (byte b1 = 0; b1 < 5; ) { if (k != b1 && (this.stat[b1] <= 200 || m > 0) && (this.stat[b1] >= 16 || m < 0) && m != 0) { if (m > 0) { this.stat[k] = this.stat[k] + 1; this.stat[b1] = this.stat[b1] - 1; m--; } else { this.stat[k] = this.stat[k] - 1; this.stat[b1] = this.stat[b1] + 1; m++; }  } else { b++; }  b1++; }
             
             } 
           }  if (i == 10) { byte b; for (this.carsel = this.simcar.getSelectedIndex(), k = 0, b = 0; b < 5; ) { this.stat[b] = this.carstat[this.carsel][b]; k += this.stat[b]; b++; }  this.clsel = 4 - (k - 520) / 40; this.cls.select(this.clsel); }
           
           if (i == 11) {
             
             String str1 = "" + this.editor.getText() + "\n";
             String str2 = "";
             int m = 0, n = str1.indexOf("\n", 0);
             while (n != -1 && m < str1.length()) {
               
               String str = str1.substring(m, n); str = str.trim();
               m = n + 1; n = str1.indexOf("\n", m);
               if (!str.startsWith("stat(")) { str2 = str2 + "" + str + "\n"; continue; }  str2 = str2.trim(); str2 = str2 + "\n";
             } 
             str2 = str2.trim();
             str2 = str2 + "\n\n\nstat(" + this.stat[0] + "," + this.stat[1] + "," + this.stat[2] + "," + this.stat[3] + "," + this.stat[4] + ")\n\n\n\n";
             this.editor.setText(str2);
             savefile();
             for (byte b = 0; b < 5; ) { this.rstat[b] = this.stat[b]; b++; }
              this.changed2 = false;
           } 
           
           if (i == 12) for (k = 0; k < 5; ) { this.stat[k] = this.rstat[k]; k++; }
               j = 13;
         } 
       }
       
       if (this.dtab == 5) {
         
         if (this.pfase == 0) {
           byte b;
           for (b = 0; b < 4; b++) {
             
             if (i == 1 + b * 2) { this.phys[b] = this.phys[b] + 2; if (this.phys[b] > 100) this.phys[b] = 100;  }
              if (i == b * 2) { this.phys[b] = this.phys[b] - 2; if (this.phys[b] < 0) this.phys[b] = 0;  }
           
           }  if (i == 8) for (b = 0; b < 5; ) { this.phys[b] = (int)(Math.random() * 100.0D); b++; }
               if (i == 9) for (b = 0; b < 5; ) { this.phys[b] = this.rphys[b]; b++; }
               if (i == 10) { this.pfase = 1; i = -1; }
            j = 11;
         } 
         if (this.pfase == 1) {
           byte b;
           for (b = 0; b < 6; b++) {
             
             if (i == 1 + b * 2) { this.phys[b + 5] = this.phys[b + 5] + 2; if (this.phys[b + 5] > 100) this.phys[b + 5] = 100;  }
              if (i == b * 2) { this.phys[b + 5] = this.phys[b + 5] - 2; if (this.phys[b + 5] < 0) this.phys[b + 5] = 0;  }
           
           }  if (i == 12) for (b = 0; b < 6; ) { this.phys[b + 5] = (int)(Math.random() * 100.0D); b++; }
               if (i == 13) for (b = 0; b < 6; ) { this.phys[b + 5] = this.rphys[b + 5]; b++; }
               if (i == 14) { this.pfase = 0; i = -1; }
            if (i == 15) { this.pfase = 2; i = -1; }
            j = 16;
         } 
         if (this.pfase == 2) {
           int k;
           for (k = 0; k < 3; k++) {
             
             if (i == 1 + k * 2) { this.crash[k] = this.crash[k] + 2; if (this.crash[k] > 100) this.crash[k] = 100;  }
              if (i == k * 2) { this.crash[k] = this.crash[k] - 2; if (this.crash[k] < 0) this.crash[k] = 0;  }
           
           } 
           if (i == 6) {
             
             k = (int)(150.0D + 600.0D * Math.random());
             boolean bool1 = false;
             boolean bool2 = false;
             if (Math.random() > Math.random()) bool1 = true; 
             if (Math.random() > Math.random()) bool2 = true; 
             int[] arrayOfInt = { -101, -101, -101, -101 };
             arrayOfInt[0] = (int)(Math.random() * 4.0D);
             if (Math.random() > Math.random()) {
               
               if (bool2) { arrayOfInt[1] = arrayOfInt[0] + 1; } else { arrayOfInt[1] = arrayOfInt[0] - 1; }
                if (Math.random() > Math.random()) {
                 
                 if (bool2) { arrayOfInt[2] = arrayOfInt[1] + 1; } else { arrayOfInt[2] = arrayOfInt[1] - 1; }
                  if (Math.random() > Math.random())
                 {
                   if (bool2) { arrayOfInt[3] = arrayOfInt[2] + 1; } else { arrayOfInt[3] = arrayOfInt[2] - 1; }  } 
               } 
             }  if (Math.random() > Math.random()) { this.crashup = false; } else { this.crashup = true; }
              for (byte b = 0; b < 4; b++) {
               
               if (arrayOfInt[b] != -101) { if (arrayOfInt[b] >= 4) arrayOfInt[b] = arrayOfInt[b] - 4;  if (arrayOfInt[b] <= -1) arrayOfInt[b] = arrayOfInt[b] + 4;  k -= 50 * b; if (k < 150) k = 150;  if (bool1) { regx(arrayOfInt[b], k, false); } else { regz(arrayOfInt[b], k, false); }  }
             
             }  if (this.hitmag < 17000) if (this.crashleft) { this.o.xz += 22; } else { this.o.xz -= 22; }
                
           }  if (i == 8) { if (Math.random() > Math.random()) { this.crashup = false; } else { this.crashup = true; }  roofsqsh((int)(230.0D + Math.random() * 80.0D)); }
            if (i == 9 || i == 7) { setupo(); if (Math.random() > Math.random()) { this.crashleft = false; } else { this.crashleft = true; }  }
            if (i == 10) for (k = 0; k < 3; ) { this.crash[k] = this.rcrash[k]; k++; }
               if (i == 11) { setupo(); this.pfase = 1; i = -1; }
            if (i == 12) if (this.crashok) { setupo(); this.pfase = 3; i = -1; } else { JOptionPane.showMessageDialog(null, this.usage[11], "Car Maker", 1); }
               j = 13;
         } 
         
         if (this.pfase == 3) {
           
           for (byte b = 0; b < 5; b++) {
             
             if (i == b) {
               
               for (byte b1 = 0; b1 < 5; ) { for (byte b2 = 0; b2 < 5; ) { this.engs[b2][b1].stop(); b2++; }  b1++; }
                this.engs[this.engsel][b].loop();
               this.engon = true;
             } 
             if (i == 5) { for (byte b1 = 0; b1 < 5; ) { for (byte b2 = 0; b2 < 5; ) { this.engs[b2][b1].stop(); b2++; }  b1++; }  this.engon = false; }
              if (i == 6) { this.pfase = 2; i = -1; this.engine.hide(); }
              if (i == 7) { this.pfase = 4; i = -1; this.engine.hide(); }
           
           }  j = 8;
         } 
       } 
 
       
       if (this.dtab == 6)
       {
         if (!this.rateh) {
           
           if (i == 0 && checko("Test Drive")) { Madness.testcar = this.carname; Madness.testdrive = this.witho.getSelectedIndex() + 1; Madness.game(); }
            j = 1;
           if (this.tested)
           {
             if (i == 1) { this.dtab = 4; i = -1; }
              if (i == 2) { this.dtab = 5; i = -1; }
              if (i == 3) { this.rateh = true; hidefields(); }
              j = 4;
           }
         
         } else {
           
           if (i == 0) { this.handling -= 2; if (this.handling < 50) this.handling = 50;  }
            if (i == 1) { this.handling += 2; if (this.handling > 200) this.handling = 200;  }
            if (i == 2) {
             
             String str1 = "" + this.editor.getText() + "\n";
             String str2 = "";
             int k = 0, m = str1.indexOf("\n", 0);
             while (m != -1 && k < str1.length()) {
               
               String str = str1.substring(k, m); str = str.trim();
               k = m + 1; m = str1.indexOf("\n", k);
               if (!str.startsWith("handling(")) { str2 = str2 + "" + str + "\n"; continue; }  str2 = str2.trim(); str2 = str2 + "\n";
             } 
             str2 = str2.trim();
             str2 = str2 + "\n\n\nhandling(" + this.handling + ")\n\n\n\n";
             this.editor.setText(str2);
             savefile();
             this.rateh = false;
           } 
           if (i == 3) this.rateh = false; 
           j = 4;
         } 
       }
       
       if (i == j) { for (byte b = 0; b < this.o.npl; ) { Color.RGBtoHSB((this.o.p[b]).c[0], (this.o.p[b]).c[1], (this.o.p[b]).c[2], (this.o.p[b]).hsb); if ((this.o.p[b]).gr == -13) (this.o.p[b]).gr = 1;  b++; }  this.polynum = -1; }
        i = -1;
     } 
 
     
     if (this.tab == 3) {
 
       
       if (i == 0) {
         
         if (this.logged == 0) JOptionPane.showMessageDialog(null, "Please login to retrieve your account first before publishing!", "Car Maker", 1); 
         if (this.logged == 3 || this.logged == -1)
         {
           if (checko("Publishing")) {
             
             j = 0; byte b;
             for (b = 0; b < this.pubitem.no; ) { if (this.pubitem.opts[b].equals(this.carname)) j = JOptionPane.showConfirmDialog(null, "Replace your already online car '" + this.carname + "' with this one?", "Car Maker", 0);  b++; }
              if (j == 0) {
               
               setCursor(new Cursor(3));
               this.rd.setFont(new Font("Arial", 1, 13)); this.ftm = this.rd.getFontMetrics();
               
               this.rd.setColor(new Color(225, 225, 225)); this.rd.fillRect(11, 141, 679, 401);
               this.rd.setColor(new Color(0, 0, 0)); this.rd.drawString("Connecting to Server...", 350 - this.ftm.stringWidth("Connecting to Server...") / 2, 250);
               repaint();
               
               b = 0;
               String str = "" + this.editor.getText() + "\n"; int k = 0, m = str.indexOf("\n", 0);
               while (m != -1 && k < str.length()) { k = m + 1; m = str.indexOf("\n", k); b++; }
                this.justpubd = this.carname;
               int n = -1;
               
               try {
                 Socket socket = new Socket("multiplayer.needformadness.com", 7061);
                 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                 printWriter.println("10|" + this.tnick.getText() + "|" + this.tpass.getText() + "|" + this.carname + "|" + this.pubtyp.getSelectedIndex() + "|");
                 String str1 = bufferedReader.readLine();
                 if (str1 != null) n = servervalue(str1, 0); 
                 if (n == 0) {
                   
                   byte b1 = 0;
                   str = "" + this.editor.getText() + "\n";
                   k = 0; m = str.indexOf("\n", 0);
                   while (m != -1 && k < str.length()) {
                     
                     String str2 = str.substring(k, m); str2 = str2.trim();
                     printWriter.println(str2);
                     k = m + 1; m = str.indexOf("\n", k);
                     
                     b1++;
                     this.rd.setColor(new Color(225, 225, 225)); this.rd.fillRect(11, 141, 679, 401);
                     this.rd.setColor(new Color(0, 0, 0)); this.rd.drawString("Publishing Car...", 350 - this.ftm.stringWidth("Publishing Car...") / 2, 250);
                     this.rd.setColor(new Color(119, 147, 191)); this.rd.fillRect(250, 270, (int)(b1 / b * 200.0F), 7);
                     this.rd.setColor(new Color(0, 0, 0)); this.rd.drawRect(250, 270, 200, 7);
                     repaint(); 
                     try { Thread.sleep(10L); } catch (InterruptedException interruptedException) {}
                   } 
                   printWriter.println("QUITX1111");
                   
                   this.rd.setColor(new Color(225, 225, 225)); this.rd.fillRect(11, 141, 679, 401);
                   this.rd.setColor(new Color(0, 0, 0)); this.rd.drawString("Creating the car online...", 350 - this.ftm.stringWidth("Creating the car online...") / 2, 250);
                   this.rd.drawString("This may take a couple of minutes, please wait...", 350 - this.ftm.stringWidth("This may take a couple of minutes, please wait...") / 2, 280);
                   repaint();
                   
                   str1 = bufferedReader.readLine(); if (str1 != null) n = servervalue(str1, 0);
                 
                 } 
                 socket.close();
               } catch (Exception exception) {
                 n = -1;
               }  setCursor(new Cursor(0));
               boolean bool = false;
               if (n == 0) { this.logged = 1; bool = true; }
                if (n == 3) { JOptionPane.showMessageDialog(null, "Unable to publish car.\nReason:\nCar name is too large.  Please rename your car.  Car name must be less then 15 characters.", "Car Maker", 1); bool = true; }
                if (n == 4) { JOptionPane.showMessageDialog(null, "Unable to publish car.\nReason:  Car name used (" + this.carname + ").\nThe name '" + this.carname + "' is already used by another published car.  Please rename your car.", "Car Maker", 1); bool = true; }
                if (n == 6) { JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nError loading 3D model!  Format maybe incorrect!", "Car Maker", 1); bool = true; }
                if (n == 7) { JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nFirst and Second colors not defined yet!\nPlease go to the 'Color Edit' tab to define the colors.", "Car Maker", 1); bool = true; }
                if (n == 8) { JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar Wheels not defined or not defined correctly!\nPlease go to the ‘Wheels’ tab and use  [ Apply ]  and  [ Save ]  to define correctly.", "Car Maker", 1); bool = true; }
                if (n == 9) { JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nNo car seems to be designed!\nYou have not built a car yet please go to the ‘Car’ tab to find the tutorial on how to build a car.", "Car Maker", 1); bool = true; }
                if (n == 10) { JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar contains too many polygons (pieces).\nNumber of polygons used need to be less then 210.\nPlease use the counter in the ‘Code Edit’ to decrease the number of polygons (pieces).", "Car Maker", 1); bool = true; }
                if (n == 11) { JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar scale size is too large!\nPlease use the ‘Scale All’ option in the ‘Scale & Align’ tab to resize your car to suitable size.       \nCompare it to other NFM cars using the ‘Compare Car...’ option.\nCurrently you car needs to be scaled down by " + (int)((this.o.maxR / 400.0F - 1.0F) * 100.0F) + "%.\n", "Car Maker", 1); bool = true; }
                if (n == 12) { JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar scale size is too small!\nPlease use the ‘Scale All’ option in the ‘Scale & Align’ tab to resize your car to suitable size.       \nCompare it to other NFM cars using the ‘Compare Car...’ option.\nCurrently you car needs to be scaled up by " + (int)((120.0F / this.o.maxR - 1.0F) * 100.0F) + "%.\n", "Car Maker", 1); bool = true; }
                if (n == 13) { JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar Stats & Class not defined correctly!\nPlease go to the 'Stats & Class' tab to define stats and don't forget to press  [ Save ]  when finished.\n", "Car Maker", 1); bool = true; }
                if (n == 14) { JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar Physics not defined correctly!\nPlease go to the 'Physics' tab and complete the car physics definition until it is saved.\n", "Car Maker", 1); bool = true; }
                if (n == 15) { JOptionPane.showMessageDialog(null, "Error Creating Car!\nReason:\nCar Handling not rated.\nPlease Test Drive your car to rate its handling before publishing!\n", "Car Maker", 1); bool = true; }
                if (n > 15) { JOptionPane.showMessageDialog(null, "Unable to publish car fully!  Unknown Error.  Please try again later.\n", "Car Maker", 1); bool = true; }
                if (!bool) JOptionPane.showMessageDialog(null, "Unable to publish car!  Unknown Error.\n", "Car Maker", 1);
             
             } 
           } 
         }
       } 
       if (this.logged == 0) {
         
         if (i == 1) {
           
           setCursor(new Cursor(3));
           j = -1;
           
           try {
             Socket socket = new Socket("multiplayer.needformadness.com", 7061);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
             printWriter.println("1|" + this.tnick.getText().toLowerCase() + "|" + this.tpass.getText() + "|");
             String str = bufferedReader.readLine();
             if (str != null) j = servervalue(str, 0); 
             socket.close();
           } catch (Exception exception) {
             j = -1;
           }  if (j == 0 || j == 3 || j > 10) { this.tnick.hide(); this.tpass.hide(); this.logged = 1; savesettings(); }
            if (j == 1 || j == 2) { setCursor(new Cursor(0)); JOptionPane.showMessageDialog(null, "Sorry.  Incorrect Nickname or Password!", "Car Maker", 0); }
            if (j == -167) { setCursor(new Cursor(0)); JOptionPane.showMessageDialog(null, "Sorry.  Your trial account cannot publish cars.  Please upgrade to a full account!   ", "Car Maker", 0); }
            if (j == -1) { setCursor(new Cursor(0)); JOptionPane.showMessageDialog(null, "Unable to connect to server at this moment, please try again later.", "Car Maker", 1); }
         
         } 
         if (i == 2) Madness.openurl("http://multiplayer.needformadness.com/register.html?ref=game"); 
         if (i == 3) Madness.openurl("http://multiplayer.needformadness.com/edit.pl");
       
       } 
     } 
   }
 
 
 
 
 
   
   public void setupo() {
     this.o = new ContO(this.editor.getText().getBytes(), this.m, this.t);
     this.o.x = this.ox; this.o.y = this.oy; this.o.z = this.oz; this.o.xz = this.oxz; this.o.xy = this.oxy; this.o.zy = this.ozy;
     this.o.shadow = true; this.o.tnt = 0; this.o.disp = 0; this.o.disline = 7; this.o.grounded = 1.0F; this.o.noline = false; this.o.decor = false;
     if (this.o.errd && (!this.o.err.startsWith("Wheels Error:") || this.forwheels)) JOptionPane.showMessageDialog(null, this.o.err, "Car Maker", 0); 
     if (this.o.maxR == 0) this.o.maxR = 100; 
     this.squash = 0;
     this.hitmag = 0;
   }
 
   
   public void loadfile() {
     this.loadedfile = false;
     this.lastedo = "";
     
     try {
       File file = new File("" + Madness.fpath + "mycars/" + this.carname + ".rad");
       BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
       String str = null;
       for (; (str = bufferedReader.readLine()) != null; this.lastedo += "" + str + "\n");
       this.loadedfile = true;
       bufferedReader.close();
       bufferedReader = null;
     } catch (Exception exception) {
       this.loadedfile = false; this.lastedo = ""; JOptionPane.showMessageDialog(null, "Unable to load file! Error Deatials:\n" + exception, "Car Maker", 1);
     }  this.editor.setText(this.lastedo);
   }
 
 
   
   public void savefile() {
     if (!this.editor.getText().equals(""))
       
       try {
         
         File file = new File("" + Madness.fpath + "mycars/"); if (!file.exists()) file.mkdirs(); 
         file = new File("" + Madness.fpath + "mycars/" + this.carname + ".rad");
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
         bufferedWriter.write(this.editor.getText());
         bufferedWriter.close();
         bufferedWriter = null;
         this.changed = false;
         this.lastedo = this.editor.getText();
       } catch (Exception exception) {
         JOptionPane.showMessageDialog(null, "Unable to save file! Error Deatials:\n" + exception, "Car Maker", 1);
       }  
     savesettings();
   }
 
   
   public void newcar(String paramString) {
     if (paramString.equals("")) { JOptionPane.showMessageDialog(null, "Please Enter a Car Name!\n", "Car Maker", 1); }
     else
     
     { String str = "\n// car: " + paramString + "\n---------------------\n\n// To start making you car you must start by reading the tutorial at:\n// http://www.needformadness.com/developer/simplecar.html\n\n\n<p>\nc(100,200,100)\n\np(-40,-50,80)\np(-40,-50,-70)\np(40,-50,-70)\np(40,-50,80)\n</p>\n\n<p>\nc(100,150,200)\n\np(-40,-20,-100)\np(-40,-50,-70)\np(40,-50,-70)\np(40,-20,-100)\n</p>\n\n\n\n";
 
       
       try { File file = new File("" + Madness.fpath + "mycars/"); if (!file.exists()) file.mkdirs(); 
         this.carname = paramString;
         file = new File("" + Madness.fpath + "mycars/" + this.carname + ".rad");
         if (!file.exists())
         
         { BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
           bufferedWriter.write(str);
           bufferedWriter.close();
           bufferedWriter = null;
           if (file.exists()) { this.sfase = 0; hidefields(); this.tabed = -1; } else { JOptionPane.showMessageDialog(null, "Failed to create car, unknown reason!\n", "Car Maker", 1); }  }
         else { JOptionPane.showMessageDialog(null, "A car with the name '" + this.carname + "' already exists, please choose another name!\n", "Car Maker", 1); }
          }
       catch (Exception exception) { this.carname = ""; JOptionPane.showMessageDialog(null, "Unable to create file! Error Deatials:\n" + exception, "Car Maker", 1); }
        }
   
   }
   
   public void delcar(String paramString) {
     if (paramString.equals("")) { JOptionPane.showMessageDialog(null, "Please Select a Car to Delete!\n", "Car Maker", 1); }
     else { int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete car :  " + paramString + " ?  ", "Car Maker", 0);
       if (i == 0)
         try { File file = new File("" + Madness.fpath + "mycars/" + paramString + ".rad"); file.delete(); this.slcar.remove(paramString); this.slcar.select(0); } catch (Exception exception) { JOptionPane.showMessageDialog(null, "Unable to delete file! Error Deatials:\n" + exception, "Car Maker", 1); }
           }
   
   }
   
   public void rencar(String paramString) {
     if (paramString.equals("")) { JOptionPane.showMessageDialog(null, "Please Enter a New Car Name!\n", "Car Maker", 1); }
     else { try { File file1 = new File("" + Madness.fpath + "mycars/" + this.carname + ".rad"), file2 = new File("" + Madness.fpath + "mycars/" + paramString + ".rad"); if (file1.renameTo(file2)) { this.carname = paramString; this.sfase = 0; hidefields(); this.tabed = -1; } else { JOptionPane.showMessageDialog(null, "Unable to rename car to: '" + paramString + "', possible reason: Car name already used!\n", "Car Maker", 1); }  } catch (Exception exception) { JOptionPane.showMessageDialog(null, "Unable to rename file! Error Deatials:\n" + exception, "Car Maker", 1); }
        }
   
   }
 
   
   public void loadsettings() {
     try {
       File file = new File("" + Madness.fpath + "mycars/settings.data");
       if (file.exists())
       {
         BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
         String str = bufferedReader.readLine();
         if (str != null) this.carname = this.scar = str; 
         str = bufferedReader.readLine();
         if (str != null) { this.suser = str; if (!this.suser.equals("Horaks")) this.tnick.setText(this.suser);  }
          str = bufferedReader.readLine();
         if (str != null) this.cfont = this.sfont = str; 
         str = bufferedReader.readLine();
         if (str != null) this.cthm = this.sthm = Float.valueOf(str).intValue(); 
         bufferedReader.close();
         bufferedReader = null;
       }
     
     } catch (Exception exception) {}
   }
 
   
   public void savesettings() {
     if (!this.scar.equals(this.carname) || !this.suser.equals(this.tnick.getText()) || !this.sfont.equals(this.cfont) || this.cthm != this.sthm) {
       
       String str = "" + this.carname + "\n" + this.tnick.getText() + "\n" + this.cfont + "\n" + this.cthm + "\n\n";
       this.scar = this.carname; this.suser = this.tnick.getText(); this.sfont = this.cfont; this.sthm = this.cthm;
       
       try {
         File file = new File("" + Madness.fpath + "mycars/"); if (!file.exists()) file.mkdirs(); 
         file = new File("" + Madness.fpath + "mycars/settings.data");
         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
         bufferedWriter.write(str);
         bufferedWriter.close();
         bufferedWriter = null;
       }
       catch (Exception exception) {}
     } 
   }
 
 
   
   public boolean checko(String paramString) {
     loadfile();
     setupo();
 
 
     
     if (this.o.colok < 2) {
       
       JOptionPane.showMessageDialog(null, "Car is not ready for " + paramString + "!\nReason:\nFirst and Second colors not defined yet!\nPlease go to the 'Color Edit' tab to define the colors.\n", "Car Maker", 1);
       return false;
     } 
     
     boolean bool1 = true;
     if (this.o.keyz[0] <= 0 || this.o.keyx[0] >= 0) bool1 = false; 
     if (this.o.keyz[1] <= 0 || this.o.keyx[1] <= 0) bool1 = false; 
     if (this.o.keyz[2] >= 0 || this.o.keyx[2] >= 0) bool1 = false; 
     if (this.o.keyz[3] >= 0 || this.o.keyx[3] <= 0) bool1 = false; 
     if (!bool1) {
       
       JOptionPane.showMessageDialog(null, "Car is not ready for " + paramString + "!\nReason:\nCar Wheels not defined or not defined correctly!\nPlease go to the ‘Wheels’ tab and use  [ Apply ]  and  [ Save ]  to define correctly.\n", "Car Maker", 1);
       return false;
     } 
     
     if (this.o.npl <= 60) {
       
       JOptionPane.showMessageDialog(null, "Car is not ready for " + paramString + "!\nReason:\nNo car seems to be designed!\nYou have not built a car yet please go to the ‘Car’ tab to find the tutorial on how to build a car.\n", "Car Maker", 1);
       return false;
     } 
     
     if (this.o.npl > 286) {
       
       JOptionPane.showMessageDialog(null, "Car is not ready for " + paramString + "!\nReason:\nCar contains too many polygons (pieces).\nNumber of polygons used need to be less then 210.\nPlease use the counter in the ‘Code Edit’ to decrease the number of polygons (pieces).\n", "Car Maker", 1);
       return false;
     } 
     
     if (this.o.maxR > 400) {
       
       JOptionPane.showMessageDialog(null, "Car is not ready for " + paramString + "!\nReason:\nCar scale size is too large!\nPlease use the ‘Scale All’ option in the ‘Scale & Align’ tab to resize your car to suitable size.       \nCompare it to other NFM cars using the ‘Compare Car...’ option.\nCurrently you car needs to be scaled down by " + (int)((this.o.maxR / 400.0F - 1.0F) * 100.0F) + "%.\n", "Car Maker", 1);
       return false;
     } 
     
     if (this.o.maxR < 120) {
       
       JOptionPane.showMessageDialog(null, "Car is not ready for " + paramString + "!\nReason:\nCar scale size is too small!\nPlease use the ‘Scale All’ option in the ‘Scale & Align’ tab to resize your car to suitable size.       \nCompare it to other NFM cars using the ‘Compare Car...’ option.\nCurrently you car needs to be scaled up by " + (int)((120.0F / this.o.maxR - 1.0F) * 100.0F) + "%.\n", "Car Maker", 1);
       return false;
     } 
     
     String str = "" + this.editor.getText() + "\n";
     int i = 0, j = str.indexOf("\n", 0);
     boolean bool2 = false, bool3 = false, bool4 = false;
     
     while (j != -1 && i < str.length()) {
       
       String str1 = str.substring(i, j); str1 = str1.trim();
       i = j + 1; j = str.indexOf("\n", i);
       if (str1.startsWith("stat(")) {
         
         bool2 = true;
         
         try { int k = 0;
           for (byte b = 0; b < 5; ) { this.stat[b] = getvalue("stat", str1, b); if (this.stat[b] > 200) bool2 = false;  if (this.stat[b] < 16) bool2 = false;  k += this.stat[b]; b++; }
            if (k != 680 && k != 640 && k != 600 && k != 560 && k != 520) bool2 = false;  }
         catch (Exception exception) { bool2 = false; }
       
       }  if (str1.startsWith("physics(")) {
         
         bool3 = true; 
         try { byte b;
           for (b = 0; b < 11; ) { this.phys[b] = getvalue("physics", str1, b); if (this.phys[b] > 100) bool3 = false;  if (this.phys[b] < 0) bool3 = false;  b++; }
            for (b = 0; b < 3; ) { this.crash[b] = getvalue("physics", str1, b + 11); if (b != 0 && this.crash[b] > 100) bool3 = false;  if (this.crash[b] < 0) bool3 = false;  b++; }
            this.engsel = getvalue("physics", str1, 14); if (this.engsel > 4) bool3 = false;  if (this.engsel < 0) bool3 = false;  }
         catch (Exception exception) { bool3 = false; }
       
       }  if (str1.startsWith("handling(")) {
         
         bool4 = true; try { int k = getvalue("handling", str1, 0); if (k > 200) bool4 = false;  if (k < 0) bool4 = false;  } catch (Exception exception) { bool4 = false; }
       
       } 
     } 
     if (!bool2) {
       
       JOptionPane.showMessageDialog(null, "Car is not ready for " + paramString + "!\nReason:\nCar Stats & Class not defined correctly!\nPlease go to the 'Stats & Class' tab to define stats and don't forget to press  [ Save ]  when finished.\n", "Car Maker", 1);
       return false;
     } 
     
     if (!bool3) {
       
       JOptionPane.showMessageDialog(null, "Car is not ready for " + paramString + "!\nReason:\nCar Physics not defined correctly!\nPlease go to the 'Physics' tab and complete the car physics definition until it is saved.\n", "Car Maker", 1);
       return false;
     } 
     
     if (!bool4 && paramString.equals("Publishing")) {
       
       JOptionPane.showMessageDialog(null, "Car is not ready for " + paramString + "!\nReason:\nCar Handling not rated.\nPlease Test Drive your car to rate its handling before publishing!\n", "Car Maker", 1);
       return false;
     } 
     
     return true;
   }
 
   
   public void regx(int paramInt, float paramFloat, boolean paramBoolean) {
     this.hitmag = (int)(this.hitmag + paramFloat);
     if (!paramBoolean) crash(paramFloat); 
     paramFloat *= 0.3F + this.crash[1] * 0.005F;
     if (Math.abs(paramFloat) > 100.0F) {
       
       int i = (int)((this.crash[0] * this.crash[0]) * 1.5D);
       if (i < 1000) i = 1000; 
       if (paramFloat > 100.0F) paramFloat -= 100.0F;  if (paramFloat < -100.0F) paramFloat += 100.0F; 
       for (byte b = 0; b < this.o.npl; b++) {
         float f; byte b1;
         for (f = 0.0F, b1 = 0; b1 < (this.o.p[b]).n; ) { if ((this.o.p[b]).wz == 0 && py(this.o.keyx[paramInt], (this.o.p[b]).ox[b1], this.o.keyz[paramInt], (this.o.p[b]).oz[b1]) < i) { f = paramFloat / 20.0F * this.m.random(); (this.o.p[b]).oz[b1] = (int)((this.o.p[b]).oz[b1] - f * this.m.sin(this.o.xz) * this.m.cos(this.o.zy)); (this.o.p[b]).ox[b1] = (int)((this.o.p[b]).ox[b1] + f * this.m.cos(this.o.xz) * this.m.cos(this.o.xy)); if (paramBoolean) this.actmag = (int)(this.actmag + Math.abs(f));  }  b1++; }
          if (f != 0.0F) { if (Math.abs(f) >= 1.0F) { (this.o.p[b]).chip = 1; (this.o.p[b]).ctmag = f; }  if (!(this.o.p[b]).nocol && (this.o.p[b]).glass != 1) { if ((this.o.p[b]).bfase > 20 && (this.o.p[b]).hsb[1] > 0.25D) (this.o.p[b]).hsb[1] = 0.25F;  if ((this.o.p[b]).bfase > 25 && (this.o.p[b]).hsb[2] > 0.7D) (this.o.p[b]).hsb[2] = 0.7F;  if ((this.o.p[b]).bfase > 30 && (this.o.p[b]).hsb[1] > 0.15D) (this.o.p[b]).hsb[1] = 0.15F;  if ((this.o.p[b]).bfase > 35 && (this.o.p[b]).hsb[2] > 0.6D) (this.o.p[b]).hsb[2] = 0.6F;  if ((this.o.p[b]).bfase > 40) (this.o.p[b]).hsb[0] = 0.075F;  if ((this.o.p[b]).bfase > 50 && (this.o.p[b]).hsb[2] > 0.5D) (this.o.p[b]).hsb[2] = 0.5F;  if ((this.o.p[b]).bfase > 60) (this.o.p[b]).hsb[0] = 0.05F;  (this.o.p[b]).bfase = (int)((this.o.p[b]).bfase + Math.abs(f)); new Color((this.o.p[b]).c[0], (this.o.p[b]).c[1], (this.o.p[b]).c[2]); Color color = Color.getHSBColor((this.o.p[b]).hsb[0], (this.o.p[b]).hsb[1], (this.o.p[b]).hsb[2]); (this.o.p[b]).c[0] = color.getRed(); (this.o.p[b]).c[1] = color.getGreen(); (this.o.p[b]).c[2] = color.getBlue(); }  if ((this.o.p[b]).glass == 1) (this.o.p[b]).gr = (int)((this.o.p[b]).gr + Math.abs(f * 1.5D));  }
       
       } 
     } 
   }
   
   public void regz(int paramInt, float paramFloat, boolean paramBoolean) {
     this.hitmag = (int)(this.hitmag + paramFloat);
     if (!paramBoolean) crash(paramFloat); 
     paramFloat *= 0.3F + this.crash[1] * 0.005F;
     if (Math.abs(paramFloat) > 100.0F) {
       
       int i = (int)((this.crash[0] * this.crash[0]) * 1.5D);
       if (i < 1000) i = 1000; 
       if (paramFloat > 100.0F) paramFloat -= 100.0F;  if (paramFloat < -100.0F) paramFloat += 100.0F; 
       for (byte b = 0; b < this.o.npl; b++) {
         float f; byte b1;
         for (f = 0.0F, b1 = 0; b1 < (this.o.p[b]).n; ) { if ((this.o.p[b]).wz == 0 && py(this.o.keyx[paramInt], (this.o.p[b]).ox[b1], this.o.keyz[paramInt], (this.o.p[b]).oz[b1]) < i) { f = paramFloat / 20.0F * this.m.random(); (this.o.p[b]).oz[b1] = (int)((this.o.p[b]).oz[b1] + f * this.m.cos(this.o.xz) * this.m.cos(this.o.zy)); (this.o.p[b]).ox[b1] = (int)((this.o.p[b]).ox[b1] + f * this.m.sin(this.o.xz) * this.m.cos(this.o.xy)); if (paramBoolean) this.actmag = (int)(this.actmag + Math.abs(f));  }  b1++; }
          if (f != 0.0F) { if (Math.abs(f) >= 1.0F) { (this.o.p[b]).chip = 1; (this.o.p[b]).ctmag = f; }  if (!(this.o.p[b]).nocol && (this.o.p[b]).glass != 1) { if ((this.o.p[b]).bfase > 20 && (this.o.p[b]).hsb[1] > 0.25D) (this.o.p[b]).hsb[1] = 0.25F;  if ((this.o.p[b]).bfase > 25 && (this.o.p[b]).hsb[2] > 0.7D) (this.o.p[b]).hsb[2] = 0.7F;  if ((this.o.p[b]).bfase > 30 && (this.o.p[b]).hsb[1] > 0.15D) (this.o.p[b]).hsb[1] = 0.15F;  if ((this.o.p[b]).bfase > 35 && (this.o.p[b]).hsb[2] > 0.6D) (this.o.p[b]).hsb[2] = 0.6F;  if ((this.o.p[b]).bfase > 40) (this.o.p[b]).hsb[0] = 0.075F;  if ((this.o.p[b]).bfase > 50 && (this.o.p[b]).hsb[2] > 0.5D) (this.o.p[b]).hsb[2] = 0.5F;  if ((this.o.p[b]).bfase > 60) (this.o.p[b]).hsb[0] = 0.05F;  (this.o.p[b]).bfase = (int)((this.o.p[b]).bfase + Math.abs(f)); new Color((this.o.p[b]).c[0], (this.o.p[b]).c[1], (this.o.p[b]).c[2]); Color color = Color.getHSBColor((this.o.p[b]).hsb[0], (this.o.p[b]).hsb[1], (this.o.p[b]).hsb[2]); (this.o.p[b]).c[0] = color.getRed(); (this.o.p[b]).c[1] = color.getGreen(); (this.o.p[b]).c[2] = color.getBlue(); }  if ((this.o.p[b]).glass == 1) (this.o.p[b]).gr = (int)((this.o.p[b]).gr + Math.abs(f * 1.5D));
            }
       
       } 
     } 
   }
   
   public void roofsqsh(float paramFloat) {
     if (paramFloat > 100.0F) {
       
       crash(paramFloat);
       paramFloat -= 100.0F;
       
       int i = (int)(2.0D + this.crash[2] / 7.6D);
       
       int j = 0; byte b1 = 1;
       for (byte b2 = 0; b2 < this.o.npl; b2++) {
         
         float f = 0.0F;
         if (Math.random() > 0.9D) f = paramFloat / 15.0F * this.m.random(); 
         for (byte b = 0; b < (this.o.p[b2]).n; b++) {
           
           if ((this.o.p[b2]).wz == 0)
           {
             if ((Math.abs((this.o.p[b2]).oy[b] - this.o.roofat - this.squash) < i * 3 || (this.o.p[b2]).oy[b] < this.o.roofat + this.squash) && this.squash < i) {
               
               f = paramFloat / 15.0F * this.m.random();
               (this.o.p[b2]).oy[b] = (int)((this.o.p[b2]).oy[b] + f);
               j = (int)(j + f);
               b1++;
               this.hitmag = (int)(this.hitmag + Math.abs(f));
             } 
           }
         } 
         
         if (!(this.o.p[b2]).nocol && (this.o.p[b2]).glass != 1)
         
         { if (f != 0.0F) {
             
             if ((this.o.p[b2]).bfase > 20 && (this.o.p[b2]).hsb[1] > 0.25D) (this.o.p[b2]).hsb[1] = 0.25F; 
             if ((this.o.p[b2]).bfase > 25 && (this.o.p[b2]).hsb[2] > 0.7D) (this.o.p[b2]).hsb[2] = 0.7F; 
             if ((this.o.p[b2]).bfase > 30 && (this.o.p[b2]).hsb[1] > 0.15D) (this.o.p[b2]).hsb[1] = 0.15F; 
             if ((this.o.p[b2]).bfase > 35 && (this.o.p[b2]).hsb[2] > 0.6D) (this.o.p[b2]).hsb[2] = 0.6F; 
             if ((this.o.p[b2]).bfase > 40) (this.o.p[b2]).hsb[0] = 0.075F; 
             if ((this.o.p[b2]).bfase > 50 && (this.o.p[b2]).hsb[2] > 0.5D) (this.o.p[b2]).hsb[2] = 0.5F; 
             if ((this.o.p[b2]).bfase > 60) (this.o.p[b2]).hsb[0] = 0.05F; 
             (this.o.p[b2]).bfase = (int)((this.o.p[b2]).bfase + f);
             new Color((this.o.p[b2]).c[0], (this.o.p[b2]).c[1], (this.o.p[b2]).c[2]); Color color = Color.getHSBColor((this.o.p[b2]).hsb[0], (this.o.p[b2]).hsb[1], (this.o.p[b2]).hsb[2]);
             (this.o.p[b2]).c[0] = color.getRed();
             (this.o.p[b2]).c[1] = color.getGreen();
             (this.o.p[b2]).c[2] = color.getBlue();
           }  }
         else if ((this.o.p[b2]).glass == 1) { (this.o.p[b2]).gr += 5; }
         
         if (Math.abs(f) >= 1.0F) { (this.o.p[b2]).chip = 1; (this.o.p[b2]).ctmag = f; }
       
       }  this.squash += j / b1;
     } 
   }
 
 
   
   int crshturn = 0;
   boolean crashup = false;
   
   public void crash(float paramFloat) {
     if (paramFloat > 100.0F) paramFloat -= 100.0F;  if (paramFloat < -100.0F) paramFloat += 100.0F; 
     if (Math.abs(paramFloat) > 25.0F && Math.abs(paramFloat) < 170.0F) this.lowcrashs[this.crshturn].play(); 
     if (Math.abs(paramFloat) >= 170.0F) this.crashs[this.crshturn].play(); 
     if (Math.abs(paramFloat) > 25.0F) { if (this.crashup) { this.crshturn--; } else { this.crshturn++; }  if (this.crshturn == -1) this.crshturn = 2;  if (this.crshturn == 3) this.crshturn = 0;
        }
   
   }
 
 
 
 
 
   
   public void setheme() {
     if (this.cthm == 0) { this.editor.setForeground(this.deff); this.editor.setBackground(this.defb); }
      if (this.cthm == 1) { this.editor.setForeground(new Color(0, 0, 0)); this.editor.setBackground(new Color(192, 192, 192)); }
      if (this.cthm == 2) { this.editor.setForeground(new Color(192, 192, 192)); this.editor.setBackground(new Color(0, 0, 0)); }
      if (this.cthm == 3) { this.editor.setForeground(new Color(0, 0, 0)); this.editor.setBackground(new Color(50, 200, 0)); }
      if (this.cthm == 4) { this.editor.setForeground(new Color(67, 255, 77)); this.editor.setBackground(new Color(0, 0, 0)); }
      if (this.cthm == 5) { this.editor.setForeground(new Color(0, 172, 255)); this.editor.setBackground(new Color(210, 234, 255)); }
      if (this.cthm == 6) { this.editor.setForeground(new Color(255, 230, 0)); this.editor.setBackground(new Color(255, 77, 67)); }
      if (this.cthm == 7) { this.editor.setForeground(new Color(0, 159, 255)); this.editor.setBackground(new Color(9, 47, 104)); }
   
   }
 
   
   public int py(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
     return (paramInt1 - paramInt2) * (paramInt1 - paramInt2) + (paramInt3 - paramInt4) * (paramInt3 - paramInt4);
   }
 
   
   public void rot(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
     if (paramInt3 != 0)
     {
       for (byte b = 0; b < paramInt4; b++) {
         
         int i = paramArrayOfint1[b];
         int j = paramArrayOfint2[b];
         paramArrayOfint1[b] = paramInt1 + (int)((i - paramInt1) * this.m.cos(paramInt3) - (j - paramInt2) * this.m.sin(paramInt3));
         paramArrayOfint2[b] = paramInt2 + (int)((i - paramInt1) * this.m.sin(paramInt3) + (j - paramInt2) * this.m.cos(paramInt3));
       } 
     }
   }
 
   
   public int xs(int paramInt1, int paramInt2) {
     if (paramInt2 < this.m.cz) paramInt2 = this.m.cz; 
     return (paramInt2 - this.m.focus_point) * (this.m.cx - paramInt1) / paramInt2 + paramInt1;
   }
 
   
   public int ys(int paramInt1, int paramInt2) {
     if (paramInt2 < this.m.cz) paramInt2 = this.m.cz; 
     return (paramInt2 - this.m.focus_point) * (this.m.cy - paramInt1) / paramInt2 + paramInt1;
   }
 
 
   
   public void init() {
     setBackground(new Color(0, 0, 0));
     this.offImage = createImage(700, 550);
     if (this.offImage != null) this.rd = (Graphics2D)this.offImage.getGraphics(); 
     this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
     
     boolean bool = true;
     if (System.getProperty("java.vendor").toLowerCase().indexOf("apple") != -1 || System.getProperty("java.vendor").toLowerCase().indexOf("sun") != -1) bool = false;
     
     setLayout((LayoutManager)null);
     
     this.slcar.setFont(new Font("Arial", 1, 13));
     this.slcar.add(this.rd, "Select a Car...         ");
     this.slcar.setForeground(new Color(63, 80, 110));
     this.slcar.setBackground(new Color(209, 217, 230));
     
     this.fontsel.setFont(new Font("Arial", 1, 12));
     this.fontsel.add(this.rd, "Arial");
     this.fontsel.add(this.rd, "Dialog");
     this.fontsel.add(this.rd, "DialogInput");
     this.fontsel.add(this.rd, "Monospaced");
     this.fontsel.add(this.rd, "Serif");
     this.fontsel.add(this.rd, "SansSerif");
     this.fontsel.add(this.rd, "Verdana");
     this.fontsel.setBackground(new Color(63, 80, 110));
     this.fontsel.setForeground(new Color(209, 217, 230));
     
     this.ctheme.setFont(new Font("Arial", 1, 12));
     this.ctheme.add(this.rd, "Default");
     this.ctheme.add(this.rd, "Author");
     this.ctheme.add(this.rd, "Dos");
     this.ctheme.add(this.rd, "Green");
     this.ctheme.add(this.rd, "The Matrix");
     this.ctheme.add(this.rd, "Ice Age");
     this.ctheme.add(this.rd, "Fire");
     this.ctheme.add(this.rd, "Ocean");
     this.ctheme.setBackground(new Color(63, 80, 110));
     this.ctheme.setForeground(new Color(209, 217, 230));
     
     this.compcar.setFont(new Font("Arial", 1, 12));
     this.compcar.add(this.rd, "Compare Car...");
     this.compcar.add(this.rd, "Tornado Shark");
     this.compcar.add(this.rd, "Formula 7");
     this.compcar.add(this.rd, "Wow Caninaro");
     this.compcar.add(this.rd, "La Vita Crab");
     this.compcar.add(this.rd, "Nimi");
     this.compcar.add(this.rd, "MAX Revenge");
     this.compcar.add(this.rd, "Lead Oxide");
     this.compcar.add(this.rd, "Kool Kat");
     this.compcar.add(this.rd, "Drifter X");
     this.compcar.add(this.rd, "Sword of Justice");
     this.compcar.add(this.rd, "High Rider");
     this.compcar.add(this.rd, "EL KING");
     this.compcar.add(this.rd, "Mighty Eight");
     this.compcar.add(this.rd, "M A S H E E N");
     this.compcar.add(this.rd, "Radical One");
     this.compcar.add(this.rd, "DR Monstaa");
     this.compcar.add(this.rd, " -  None  - ");
     this.compcar.setBackground(new Color(63, 80, 110));
     this.compcar.setForeground(new Color(209, 217, 230));
     
     this.cls.setFont(new Font("Arial", 1, 12));
     this.cls.add(this.rd, "Class A");
     this.cls.add(this.rd, "Class A & B");
     this.cls.add(this.rd, "Class B");
     this.cls.add(this.rd, "Class B & C");
     this.cls.add(this.rd, "Class C");
     this.cls.setBackground(new Color(63, 80, 110));
     this.cls.setForeground(new Color(209, 217, 230));
     
     this.simcar.setFont(new Font("Arial", 1, 12));
     this.simcar.add(this.rd, "Tornado Shark");
     this.simcar.add(this.rd, "Formula 7");
     this.simcar.add(this.rd, "Wow Caninaro");
     this.simcar.add(this.rd, "La Vita Crab");
     this.simcar.add(this.rd, "Nimi");
     this.simcar.add(this.rd, "MAX Revenge");
     this.simcar.add(this.rd, "Lead Oxide");
     this.simcar.add(this.rd, "Kool Kat");
     this.simcar.add(this.rd, "Drifter X");
     this.simcar.add(this.rd, "Sword of Justice");
     this.simcar.add(this.rd, "High Rider");
     this.simcar.add(this.rd, "EL KING");
     this.simcar.add(this.rd, "Mighty Eight");
     this.simcar.add(this.rd, "M A S H E E N");
     this.simcar.add(this.rd, "Radical One");
     this.simcar.add(this.rd, "DR Monstaa");
     this.simcar.setBackground(new Color(63, 80, 110));
     this.simcar.setForeground(new Color(209, 217, 230));
     
     this.witho.setFont(new Font("Arial", 1, 12));
     this.witho.add(this.rd, "With other cars");
     this.witho.add(this.rd, "Alone");
     this.witho.setBackground(new Color(63, 80, 110));
     this.witho.setForeground(new Color(209, 217, 230));
     
     this.engine.setFont(new Font("Arial", 1, 12));
     this.engine.add(this.rd, "Normal Engine");
     this.engine.add(this.rd, "V8 Engine");
     this.engine.add(this.rd, "Retro Engine");
     this.engine.add(this.rd, "Power Engine");
     this.engine.add(this.rd, "Diesel Engine");
     this.engine.setBackground(new Color(63, 80, 110));
     this.engine.setForeground(new Color(209, 217, 230));
     
     MenuItem menuItem1 = new MenuItem("Cut");
     MenuItem menuItem2 = new MenuItem("Copy");
     MenuItem menuItem3 = new MenuItem("Paste");
     MenuItem menuItem4 = new MenuItem("Select All");
     
     this.popupMenu = new PopupMenu();
     this.popupMenu.add(menuItem1);
     this.popupMenu.add(menuItem2);
     this.popupMenu.add(menuItem3);
     this.popupMenu.add(menuItem4);
     menuItem1.addActionListener(this);
     menuItem2.addActionListener(this);
     menuItem3.addActionListener(this);
     menuItem4.addActionListener(this);
     add(this.popupMenu);
     
     for (byte b = 0; b < 16; b++) {
       
       this.wv[b] = new TextField("", 2);
       this.wv[b].setBackground(new Color(255, 255, 255));
       this.wv[b].setForeground(new Color(0, 0, 0));
       this.wv[b].setFont(new Font(this.cfont, 1, 14));
       if (bool) this.wv[b].addMouseListener(new MouseHandler(this.popupMenu, b)); 
       add(this.wv[b]);
     } 
     
     this.tnick.setFont(new Font("Arial", 1, 13));
     this.tnick.setBackground(new Color(255, 255, 255));
     this.tnick.setForeground(new Color(0, 0, 0));
     
     this.tpass.setFont(new Font("Arial", 1, 13));
     this.tpass.setEchoCharacter('*');
     this.tpass.setBackground(new Color(255, 255, 255));
     this.tpass.setForeground(new Color(0, 0, 0));
     
     this.pubtyp.setFont(new Font("Arial", 1, 13));
     this.pubtyp.add(this.rd, "Private");
     this.pubtyp.add(this.rd, "Public");
     this.pubtyp.add(this.rd, "Super Public");
     this.pubtyp.setBackground(new Color(63, 80, 110));
     this.pubtyp.setForeground(new Color(209, 217, 230));
     
     this.pubitem.setFont(new Font("Arial", 1, 13));
     this.pubitem.add(this.rd, "Account Cars");
     this.pubitem.setBackground(new Color(209, 217, 230));
     this.pubitem.setForeground(new Color(63, 80, 110));
     
     this.srch.setBackground(new Color(255, 255, 255));
     this.srch.setForeground(new Color(0, 0, 0));
     if (bool) this.srch.addMouseListener(new MouseHandler(this.popupMenu, 16)); 
     this.rplc.setBackground(new Color(255, 255, 255));
     this.rplc.setForeground(new Color(0, 0, 0));
     if (bool) this.rplc.addMouseListener(new MouseHandler(this.popupMenu, 17));
     
     if (bool) this.editor.addMouseListener(new MouseHandler(this.popupMenu, 18));
     
     add(this.tnick);
     add(this.tpass);
     add(this.editor);
     add(this.srch);
     add(this.rplc);
     this.defb = new Color(255, 255, 255);
     this.deff = new Color(0, 0, 0);
     
     hidefields();
   }
   
   public void hidefields() { this.pubtyp.hide(); this.pubitem.hide(); this.tpass.hide(); this.tnick.hide(); this.slcar.hide(); this.witho.hide(); for (byte b = 0; b < 16; ) { this.wv[b].hide(); b++; }  this.simcar.hide(); this.engine.hide(); this.cls.hide(); this.compcar.hide(); this.editor.hide(); this.fontsel.hide(); this.ctheme.hide(); this.srch.hide(); this.rplc.hide(); } public void movefield(Component paramComponent, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
     paramInt1 += this.apx; paramInt2 += this.apy; if (paramComponent.getX() != paramInt1 || paramComponent.getY() != paramInt2 || paramComponent.getWidth() != paramInt3 || paramComponent.getHeight() != paramInt4) paramComponent.setBounds(paramInt1, paramInt2, paramInt3, paramInt4); 
   }
   boolean openm = false, mousdr = false;
   boolean waso = false;
   
   public void drawms() {
     this.openm = false;
     if (this.pubtyp.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) this.openm = true; 
     if (this.pubitem.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) this.openm = true; 
     if (this.fontsel.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) this.openm = true; 
     if (this.ctheme.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) this.openm = true; 
     if (this.compcar.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) this.openm = true; 
     if (this.cls.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) this.openm = true; 
     if (this.simcar.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) this.openm = true; 
     if (this.engine.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) this.openm = true; 
     if (this.witho.draw(this.rd, this.xm, this.ym, this.mousdr, 550, true)) this.openm = true; 
     if (this.slcar.draw(this.rd, this.xm, this.ym, this.mousdr, 550, false)) this.openm = true; 
     if (this.openm) { this.waso = true; this.mouses = 0; }
   
   }
   
   public void openlink() { Madness.openurl("http://www.needformadness.com/developer/simplecar.html"); }
   public void openhlink() { Madness.openurl("http://www.needformadness.com/developer/"); } public void openelink() {
     Madness.openurl("http://www.needformadness.com/developer/extras.html");
   }
   public void start() { if (this.thredo == null) this.thredo = new Thread(this);  this.thredo.start(); } public void stop() {
     this.exwist = true;
   }
 
   
   public void paint(Graphics paramGraphics) {
     this.apx = getWidth() / 2 - 350;
     this.apy = getHeight() / 2 - 275;
     paramGraphics.drawImage(this.offImage, this.apx, this.apy, this);
   }
   public void update(Graphics paramGraphics) {
     paint(paramGraphics);
   }
 
   
   public boolean mouseUp(Event paramEvent, int paramInt1, int paramInt2) {
     this.xm = paramInt1 - this.apx; this.ym = paramInt2 - this.apy;
     if (this.waso) { this.waso = false; } else { this.mouses = -1; }
      this.mousdr = false;
     if (this.onbtgame) Madness.game(); 
     return false;
   }
 
   
   public boolean mouseDown(Event paramEvent, int paramInt1, int paramInt2) {
     this.xm = paramInt1 - this.apx; this.ym = paramInt2 - this.apy;
     this.mouses = 1;
     this.mousdr = true;
     if (this.tab != 1) requestFocus(); 
     return false;
   }
 
   
   public boolean mouseMove(Event paramEvent, int paramInt1, int paramInt2) {
     this.xm = paramInt1 - this.apx; this.ym = paramInt2 - this.apy;
     if (this.xm > 520 && this.xm < 674 && this.ym > 0 && this.ym < 23) { if (!this.onbtgame) { this.onbtgame = true; setCursor(new Cursor(12)); }  } else if (this.onbtgame) { this.onbtgame = false; setCursor(new Cursor(0)); }
      return false;
   }
 
   
   public boolean mouseDrag(Event paramEvent, int paramInt1, int paramInt2) {
     this.mousdr = true;
     this.xm = paramInt1 - this.apx; this.ym = paramInt2 - this.apy;
     return false;
   }
 
   
   public boolean lostFocus(Event paramEvent, Object paramObject) {
     this.focuson = false;
     return false;
   }
 
   
   public boolean gotFocus(Event paramEvent, Object paramObject) {
     this.focuson = true;
     return false;
   }
 
 
 
 
 
   
   public boolean keyDown(Event paramEvent, int paramInt) {
     if (this.focuson) {
       
       if (paramInt == 54 || paramInt == 46 || paramInt == 100 || paramInt == 68) this.rotr = true; 
       if (paramInt == 52 || paramInt == 44 || paramInt == 97 || paramInt == 65) this.rotl = true; 
       if (paramInt == 43 || paramInt == 61) this.plus = true; 
       if (paramInt == 45) this.minus = true; 
       if (paramInt == 42 || paramInt == 10 || paramInt == 56 || paramInt == 119 || paramInt == 87) this.in = true; 
       if (paramInt == 47 || paramInt == 8 || paramInt == 50 || paramInt == 115 || paramInt == 83) this.out = true; 
       if (paramInt == 1006) this.left = true; 
       if (paramInt == 1007) this.right = true; 
       if (paramInt == 1005) this.down = true; 
       if (paramInt == 1004) this.up = true; 
     } 
     return false;
   }
 
   
   public boolean keyUp(Event paramEvent, int paramInt) {
     if (paramInt == 54 || paramInt == 46 || paramInt == 100 || paramInt == 68) this.rotr = false; 
     if (paramInt == 52 || paramInt == 44 || paramInt == 97 || paramInt == 65) this.rotl = false; 
     if (paramInt == 43 || paramInt == 61) this.plus = false; 
     if (paramInt == 45) this.minus = false; 
     if (paramInt == 42 || paramInt == 10 || paramInt == 56 || paramInt == 119 || paramInt == 97) this.in = false; 
     if (paramInt == 47 || paramInt == 8 || paramInt == 50 || paramInt == 115 || paramInt == 83) this.out = false; 
     if (paramInt == 1006) this.left = false; 
     if (paramInt == 1007) this.right = false; 
     if (paramInt == 1005) this.down = false; 
     if (paramInt == 1004) this.up = false; 
     return false;
   }
 
 
 
   
   public void loadsounds() {
     
     try { File file = new File("" + Madness.fpath + "data/sounds.zip");
       FileInputStream fileInputStream = new FileInputStream(file);
       ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
       ZipEntry zipEntry = zipInputStream.getNextEntry();
       while (zipEntry != null) {
         
         int i = (int)zipEntry.getSize();
         String str = zipEntry.getName();
         byte[] arrayOfByte = new byte[i];
         int j = 0;
         while (i > 0) { int k = zipInputStream.read(arrayOfByte, j, i); j += k; i -= k; }
          byte b; for (b = 0; b < 5; ) { for (byte b1 = 0; b1 < 5; ) { if (str.equals("" + b1 + "" + b + ".wav")) this.engs[b1][b] = new soundClip(arrayOfByte);  b1++; }  b++; }
          for (b = 0; b < 3; ) { if (str.equals("crash" + (b + 1) + ".wav")) this.crashs[b] = new soundClip(arrayOfByte);  b++; }
          for (b = 0; b < 3; ) { if (str.equals("lowcrash" + (b + 1) + ".wav")) this.lowcrashs[b] = new soundClip(arrayOfByte);  b++; }
          zipEntry = zipInputStream.getNextEntry();
       } 
       fileInputStream.close(); zipInputStream.close(); }
     catch (Exception exception) { System.out.println("Error Loading Sounds: " + exception); }
      System.gc();
   }
 
 
   
   public void loadbase() {
     String[] arrayOfString = { "2000tornados", "formula7", "canyenaro", "lescrab", "nimi", "maxrevenge", "leadoxide", "koolkat", "drifter", "policecops", "mustang", "king", "audir8", "masheen", "radicalone", "drmonster" };
 
     
     try {
       File file = new File("" + Madness.fpath + "data/models.zip");
       ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
 
       
       ZipEntry zipEntry = zipInputStream.getNextEntry();
       byte[] arrayOfByte = null;
       while (zipEntry != null) {
         
         int i = -1; int j;
         for (j = 0; j < 16; ) { if (zipEntry.getName().startsWith(arrayOfString[j])) i = j;  j++; }
          if (i != -1) {
           
           j = (int)zipEntry.getSize();
           arrayOfByte = new byte[j];
           int k = 0;
           
           for (; j > 0; j -= m) {
             
             int m = zipInputStream.read(arrayOfByte, k, j);
             k += m;
           } 
           this.compo[i] = new ContO(arrayOfByte, this.m, this.t);
           (this.compo[i]).shadow = false;
           (this.compo[i]).noline = true;
         } 
         zipEntry = zipInputStream.getNextEntry();
       } 
       
       zipInputStream.close();
     } catch (Exception exception) {
       System.out.println("Error Loading Models from Zip: " + exception);
     }  System.gc(); } public void fixtext(TextField paramTextField) { String str1; String str2; String str3;
     byte b;
     byte b1;
     for (str1 = paramTextField.getText(), str1 = str1.replace('"', '#'), str2 = "\\", str3 = "", b = 0, b1 = -1; b < str1.length(); ) { String str = "" + str1.charAt(b); if (str.equals("|") || str.equals(",") || str.equals("(") || str.equals(")") || str.equals("#") || str.equals(str2) || str.equals("!") || str.equals("?") || str.equals("~") || str.equals(".") || str.equals("@") || str.equals("$") || str.equals("%") || str.equals("^") || str.equals("&") || str.equals("*") || str.equals("+") || str.equals("=") || str.equals(">") || str.equals("<") || str.equals("/") || str.equals("'") || str.equals(";") || str.equals(":") || b > 15) { b1 = b; } else { str3 = str3 + str; }  b++; }  if (b1 != -1) { paramTextField.setText(str3); paramTextField.select(b1, b1); }
      } public int getvalue(String paramString1, String paramString2, int paramInt) { int i; byte b; String str;
     for (b = 0, str = "", i = paramString1.length() + 1; i < paramString2.length(); ) { String str1 = "" + paramString2.charAt(i); if (str1.equals(",") || str1.equals(")")) { b++; i++; }  if (b == paramInt) str = str + paramString2.charAt(i);  i++; }  return Float.valueOf(str).intValue(); }
 
   
   public String getSvalue(String paramString1, String paramString2, int paramInt) {
     String str = "";
     byte b = 0; int i = paramString1.length() + 1;
     while (i < paramString2.length() && b <= paramInt) {
       
       String str1 = "" + paramString2.charAt(i);
       if (str1.equals(",") || str1.equals(")")) { b++; } else if (b == paramInt) { str = str + str1; }
        i++;
     } 
     return str;
   }
   
   public int servervalue(String paramString, int paramInt) { int i = -1; try { byte b1; byte b2; byte b3; String str1; String str2; for (b1 = 0, b2 = 0, b3 = 0, str1 = "", str2 = ""; b1 < paramString.length() && b3 != 2; ) { str1 = "" + paramString.charAt(b1); if (str1.equals("|")) { if (b3 == 1 || ++b2 > paramInt) b3 = 2;  } else if (b2 == paramInt) { str2 = str2 + str1; b3 = 1; }  b1++; }  if (str2.equals("")) str2 = "-1";  i = Integer.valueOf(str2).intValue(); } catch (Exception exception) {} return i; } public String serverSvalue(String paramString, int paramInt) {
     String str = ""; try { byte b1; byte b2; byte b3; String str1; String str2; for (b1 = 0, b2 = 0, b3 = 0, str1 = "", str2 = ""; b1 < paramString.length() && b3 != 2; ) { str1 = "" + paramString.charAt(b1); if (str1.equals("|")) { if (b3 == 1 || ++b2 > paramInt) b3 = 2;  } else if (b2 == paramInt) { str2 = str2 + str1; b3 = 1; }  b1++; }  str = str2; } catch (Exception exception) {} return str;
   }
 
   
   boolean objfacend = false;
   boolean multf10 = false;
   
   public int objvalue(String paramString, int paramInt) {
     int i = 0;
     
     try {
       byte b1 = 2, b2 = 0, b3 = 0;
       String str1 = "", str2 = "";
       boolean bool = false;
       while (b1 < paramString.length() && b3 != 2) {
         
         str1 = "" + paramString.charAt(b1);
         if (str1.equals(" ")) { if (bool) { b2++; bool = false; }  if (b3 == 1 || b2 > paramInt) b3 = 2;  } else { if (b2 == paramInt) { str2 = str2 + str1; b3 = 1; }  bool = true; }
          b1++;
       } 
       if (b1 >= paramString.length()) this.objfacend = true;
       
       if (str2.equals("")) str2 = "0"; 
       if (this.multf10) { i = (int)(Float.valueOf(str2).floatValue() * 10.0F); } else { int j = str2.indexOf("/", 0); if (j != -1) str2 = str2.substring(0, j);  i = Float.valueOf(str2).intValue() - 1; if (i < 0) i = 0;  } 
     } catch (Exception exception) {}
     return i;
   }
   
   public Image getImage(String paramString) {
     Image image = Toolkit.getDefaultToolkit().createImage(paramString); MediaTracker mediaTracker = new MediaTracker(this); mediaTracker.addImage(image, 0); try { mediaTracker.waitForID(0); } catch (Exception exception) {} return image;
   }
   
   public void stringbutton(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {
     this.rd.setFont(new Font("Arial", 1, 12)); this.ftm = this.rd.getFontMetrics();
     if (paramString.indexOf("Publish") != -1) { this.rd.setFont(new Font("Arial", 1, 13)); this.ftm = this.rd.getFontMetrics(); }
     
     this.bx[this.btn] = paramInt1; this.by[this.btn] = paramInt2 - 5;
     this.bw[this.btn] = this.ftm.stringWidth(paramString);
     
     if (!this.pessd[this.btn]) {
       
       this.rd.setColor(new Color(220, 220, 220)); if (paramBoolean) this.rd.setColor(new Color(230, 230, 230)); 
       this.rd.fillRect(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, this.bw[this.btn] + 20, 25 - paramInt3 * 2);
       this.rd.setColor(new Color(240, 240, 240)); if (paramBoolean) this.rd.setColor(new Color(255, 255, 255)); 
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 17 - paramInt3);
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 18 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 18 - paramInt3);
       this.rd.setColor(new Color(240, 240, 240));
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 - 19 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 - 19 - paramInt3);
       this.rd.setColor(new Color(200, 200, 200)); if (paramBoolean) this.rd.setColor(new Color(192, 192, 192)); 
       this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 7 - paramInt3);
       this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 11, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 11, paramInt2 + 7 - paramInt3);
       this.rd.setColor(new Color(200, 200, 200));
       this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 12, paramInt2 - 16 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 12, paramInt2 + 6 - paramInt3);
       if (paramBoolean) this.rd.setColor(new Color(192, 192, 192)); 
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 7 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 7 - paramInt3);
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 8 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 8 - paramInt3);
       this.rd.setColor(new Color(200, 200, 200));
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 + 9 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 + 9 - paramInt3);
       this.rd.setColor(new Color(240, 240, 240)); if (paramBoolean) this.rd.setColor(new Color(255, 255, 255)); 
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 7 - paramInt3);
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 11, paramInt2 - 17 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 11, paramInt2 + 7 - paramInt3);
       this.rd.setColor(new Color(240, 240, 240));
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 12, paramInt2 - 16 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 12, paramInt2 + 6 - paramInt3);
       
       this.rd.setColor(new Color(0, 0, 0));
       this.rd.drawString(paramString, paramInt1 - this.bw[this.btn] / 2, paramInt2);
     }
     else {
       
       this.rd.setColor(new Color(220, 220, 220));
       this.rd.fillRect(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, this.bw[this.btn] + 20, 25 - paramInt3 * 2);
       this.rd.setColor(new Color(192, 192, 192));
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 17 - paramInt3);
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 18 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 18 - paramInt3);
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 - 19 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 - 19 - paramInt3);
       this.rd.setColor(new Color(247, 247, 247));
       this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 7 - paramInt3);
       this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 11, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 11, paramInt2 + 7 - paramInt3);
       this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 12, paramInt2 - 16 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 12, paramInt2 + 6 - paramInt3);
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 7 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 7 - paramInt3);
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 8 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 8 - paramInt3);
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 + 9 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 + 9 - paramInt3);
       this.rd.setColor(new Color(192, 192, 192));
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 7 - paramInt3);
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 11, paramInt2 - 17 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 11, paramInt2 + 7 - paramInt3);
       this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 12, paramInt2 - 16 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 12, paramInt2 + 6 - paramInt3);
       this.rd.setColor(new Color(0, 0, 0));
       
       this.rd.drawString(paramString, paramInt1 - this.bw[this.btn] / 2 + 1, paramInt2 + 1);
     } 
     
     this.btn++;
   }
 
 
   
   public boolean ovbutton(String paramString, int paramInt1, int paramInt2) {
     this.rd.setFont(new Font("Arial", 0, 12)); this.ftm = this.rd.getFontMetrics();
     
     if (paramString.equals("X") || paramString.equals("Download")) { this.rd.setFont(new Font("Arial", 1, 12)); this.ftm = this.rd.getFontMetrics(); }
     
     int i = this.ftm.stringWidth(paramString);
     byte b = 4;
     boolean bool1 = false, bool2 = false;
     
     if (Math.abs(this.xm - paramInt1) < i / 2 + 12 && Math.abs(this.ym - paramInt2 + 5) < 10 && this.mouses == 1) { bool1 = true; } else { bool1 = false; }
      if (Math.abs(this.xm - paramInt1) < i / 2 + 12 && Math.abs(this.ym - paramInt2 + 5) < 10 && this.mouses == -1) { this.mouses = 0; bool2 = true; }
     
     if (!bool1) {
       
       this.rd.setColor(new Color(220, 220, 220));
       this.rd.fillRect(paramInt1 - i / 2 - 10, paramInt2 - 17 - b, i + 20, 25 - b * 2);
       this.rd.setColor(new Color(240, 240, 240));
       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 17 - b, paramInt1 + i / 2 + 10, paramInt2 - 17 - b);
       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 18 - b, paramInt1 + i / 2 + 10, paramInt2 - 18 - b);
       this.rd.setColor(new Color(240, 240, 240));
       this.rd.drawLine(paramInt1 - i / 2 - 9, paramInt2 - 19 - b, paramInt1 + i / 2 + 9, paramInt2 - 19 - b);
       this.rd.setColor(new Color(200, 200, 200));
       this.rd.drawLine(paramInt1 + i / 2 + 10, paramInt2 - 17 - b, paramInt1 + i / 2 + 10, paramInt2 + 7 - b);
       this.rd.drawLine(paramInt1 + i / 2 + 11, paramInt2 - 17 - b, paramInt1 + i / 2 + 11, paramInt2 + 7 - b);
       this.rd.setColor(new Color(200, 200, 200));
       this.rd.drawLine(paramInt1 + i / 2 + 12, paramInt2 - 16 - b, paramInt1 + i / 2 + 12, paramInt2 + 6 - b);
       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 + 7 - b, paramInt1 + i / 2 + 10, paramInt2 + 7 - b);
       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 + 8 - b, paramInt1 + i / 2 + 10, paramInt2 + 8 - b);
       this.rd.setColor(new Color(200, 200, 200));
       this.rd.drawLine(paramInt1 - i / 2 - 9, paramInt2 + 9 - b, paramInt1 + i / 2 + 9, paramInt2 + 9 - b);
       this.rd.setColor(new Color(240, 240, 240));
       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 17 - b, paramInt1 - i / 2 - 10, paramInt2 + 7 - b);
       this.rd.drawLine(paramInt1 - i / 2 - 11, paramInt2 - 17 - b, paramInt1 - i / 2 - 11, paramInt2 + 7 - b);
       this.rd.setColor(new Color(240, 240, 240));
       this.rd.drawLine(paramInt1 - i / 2 - 12, paramInt2 - 16 - b, paramInt1 - i / 2 - 12, paramInt2 + 6 - b);
       
       this.rd.setColor(new Color(0, 0, 0));
       if (paramString.equals("X")) this.rd.setColor(new Color(255, 0, 0)); 
       if (paramString.equals("Download")) this.rd.setColor(new Color(0, 64, 128)); 
       this.rd.drawString(paramString, paramInt1 - i / 2, paramInt2);
     }
     else {
       
       this.rd.setColor(new Color(220, 220, 220));
       this.rd.fillRect(paramInt1 - i / 2 - 10, paramInt2 - 17 - b, i + 20, 25 - b * 2);
       this.rd.setColor(new Color(192, 192, 192));
       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 17 - b, paramInt1 + i / 2 + 10, paramInt2 - 17 - b);
       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 18 - b, paramInt1 + i / 2 + 10, paramInt2 - 18 - b);
       this.rd.drawLine(paramInt1 - i / 2 - 9, paramInt2 - 19 - b, paramInt1 + i / 2 + 9, paramInt2 - 19 - b);
       this.rd.setColor(new Color(247, 247, 247));
       this.rd.drawLine(paramInt1 + i / 2 + 10, paramInt2 - 17 - b, paramInt1 + i / 2 + 10, paramInt2 + 7 - b);
       this.rd.drawLine(paramInt1 + i / 2 + 11, paramInt2 - 17 - b, paramInt1 + i / 2 + 11, paramInt2 + 7 - b);
       this.rd.drawLine(paramInt1 + i / 2 + 12, paramInt2 - 16 - b, paramInt1 + i / 2 + 12, paramInt2 + 6 - b);
       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 + 7 - b, paramInt1 + i / 2 + 10, paramInt2 + 7 - b);
       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 + 8 - b, paramInt1 + i / 2 + 10, paramInt2 + 8 - b);
       this.rd.drawLine(paramInt1 - i / 2 - 9, paramInt2 + 9 - b, paramInt1 + i / 2 + 9, paramInt2 + 9 - b);
       this.rd.setColor(new Color(192, 192, 192));
       this.rd.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 17 - b, paramInt1 - i / 2 - 10, paramInt2 + 7 - b);
       this.rd.drawLine(paramInt1 - i / 2 - 11, paramInt2 - 17 - b, paramInt1 - i / 2 - 11, paramInt2 + 7 - b);
       this.rd.drawLine(paramInt1 - i / 2 - 12, paramInt2 - 16 - b, paramInt1 - i / 2 - 12, paramInt2 + 6 - b);
       
       this.rd.setColor(new Color(0, 0, 0));
       if (paramString.equals("X")) this.rd.setColor(new Color(255, 0, 0)); 
       if (paramString.equals("Download")) this.rd.setColor(new Color(0, 64, 128)); 
       this.rd.drawString(paramString, paramInt1 - i / 2 + 1, paramInt2 + 1);
     } 
     
     return bool2;
   }
 
   
   public void actionPerformed(ActionEvent paramActionEvent) {
     TextArea textArea;
     TextField textField = this.wv[0];
     if (Madness.textid >= 0 && Madness.textid <= 15) textField = this.wv[Madness.textid]; 
     if (Madness.textid == 16) textField = this.srch; 
     if (Madness.textid == 17) textField = this.rplc; 
     if (Madness.textid == 18) textArea = this.editor;
     
     String str = paramActionEvent.getActionCommand();
     
     if (str.equals("Cut")) {
       
       StringSelection stringSelection = new StringSelection(textArea.getSelectedText());
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
       if (Madness.textid == 18) { this.editor.replaceText("", this.editor.getSelectionStart(), this.editor.getSelectionEnd()); } else { textArea.setText(textArea.getText().substring(0, textArea.getSelectionStart()) + textArea.getText().substring(textArea.getSelectionEnd(), textArea.getText().length())); }
     
     } 
     if (str.equals("Copy")) {
       
       StringSelection stringSelection = new StringSelection(textArea.getSelectedText());
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
     } 
     
     if (str.equals("Paste")) {
       
       try {
         String str1 = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
         if (Madness.textid == 18) { this.editor.replaceText(str1, this.editor.getSelectionStart(), this.editor.getSelectionEnd()); } else { textArea.setText(textArea.getText().substring(0, textArea.getSelectionStart()) + str1 + textArea.getText().substring(textArea.getSelectionEnd(), textArea.getText().length())); } 
       } catch (Exception exception) {}
     }
     
     if (str.equals("Select All")) textArea.selectAll(); 
   }
 }


