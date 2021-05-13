 import java.applet.Applet;
 import java.awt.Color;
 import java.awt.Cursor;
 import java.awt.Event;
 import java.awt.Font;
 import java.awt.FontMetrics;
 import java.awt.Graphics;
 import java.awt.Graphics2D;
 import java.awt.Image;
 import java.awt.RenderingHints;
 
 public class update
   extends Applet implements Runnable {
   Graphics2D rd;
   FontMetrics ftm;
   Image offImage;
   Thread gamer;
   int xm = 0; int ym = 0;
   boolean moused = false;
   int scur = 0;
 
   
   public void run() {
     byte b1 = 0;
     byte b2 = 0;
     boolean bool = false;
     while (!bool) {
       
       byte b = 0;
       this.rd.setColor(new Color(234, 240, 247));
       this.rd.fillRect(0, 0, 800, 300);
       this.rd.setColor(new Color(0, 0, 0));
       this.rd.setFont(new Font("Arial", 1, 15)); this.ftm = this.rd.getFontMetrics();
       this.rd.drawString("Need for Madness Update", 400 - this.ftm.stringWidth("Need for Madness Update") / 2, 30);
       
       this.rd.setFont(new Font("Arial", 1, 13));
       if (Madness.updateon == 1 || Madness.updateon == 2) this.rd.drawString("The game has just been updated!  Please wait while the game updates itself.", 30, 70); 
       if (Madness.updateon == 3) this.rd.drawString("Successfully finished updating.  Now you can close this window and start the game again.", 30, 70); 
       if (Madness.updateon == 2) { this.rd.setFont(new Font("Arial", 0, 13)); this.rd.drawString(Madness.upfile, 30, 95); this.rd.setColor(new Color(71, 95, 120)); this.rd.drawRect(50, 105, 700, 20); this.rd.fillRect(52, 107, b1, 17); if (++b1 > 'ʹ') b1 = 0;  }
        if (Madness.updateon == 3) { this.rd.setFont(new Font("Arial", 0, 13)); this.rd.drawString("Game update complete.", 30, 95); this.rd.setColor(new Color(71, 95, 120)); this.rd.drawRect(50, 105, 700, 20); this.rd.fillRect(52, 107, 697, 17); }
       
       this.rd.setColor(new Color(0, 0, 0));
       this.rd.setFont(new Font("Arial", 1, 13)); this.ftm = this.rd.getFontMetrics();
       this.rd.drawString("To learn more about this update, visit the game's development blog!", 30, 210);
       this.rd.setColor(new Color(71, 95, 120));
       this.rd.drawString("http://multiplayer.needformadness.com/development.html", 30, 232);
       int i = this.ftm.stringWidth("http://multiplayer.needformadness.com/development.html") + 30;
       this.rd.drawLine(30, 235, i, 235);
       if (this.xm > 30 && this.xm < i && this.ym > 218 && this.ym < 237) { b = 12; if (this.moused) Madness.openurl("http://multiplayer.needformadness.com/development.html");  }
       
       if (Madness.updateon == 3)
       
       { this.rd.drawString("Close updater to finish >", 400 - this.ftm.stringWidth("Close updater to finish >") / 2, 165);
         int j = 400 - this.ftm.stringWidth("Close updater to finish >") / 2;
         i = this.ftm.stringWidth("Close updater to finish >") + j;
         this.rd.drawLine(j, 167, i, 167);
         if (this.xm > j && this.xm < i && this.ym > 150 && this.ym < 169) { b = 12; if (this.moused) { Madness.exitsequance(); bool = true; }  }  }
       else { this.rd.drawString(":: : : : : : : : : : : : : : : : : : : ::", 400 - this.ftm.stringWidth(":: : : : : : : : : : : : : : : : : : : ::") / 2, 165); }
       
       if (Madness.updateon == 3 && ++b2 == 'Ϩ') Madness.exitsequance();
       
       if (b != this.scur) { setCursor(new Cursor(b)); this.scur = b; }
        if (this.moused) this.moused = false; 
       repaint(); try {
         Thread.sleep(10L);
       } catch (InterruptedException interruptedException) {}
     } 
   }
 
 
   
   public void init() {
     this.offImage = createImage(800, 300);
     if (this.offImage != null) this.rd = (Graphics2D)this.offImage.getGraphics(); 
     this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
   }
 
   
   public boolean mouseMove(Event paramEvent, int paramInt1, int paramInt2) {
     this.xm = paramInt1; this.ym = paramInt2;
     return false;
   }
 
   
   public boolean mouseUp(Event paramEvent, int paramInt1, int paramInt2) {
     this.xm = paramInt1; this.ym = paramInt2;
     this.moused = true;
     return false;
   }
   
   public void start() { if (this.gamer == null) this.gamer = new Thread(this);  this.gamer.start(); }
   public void stop() { if (this.gamer != null) this.gamer.stop();  this.gamer = null; }
   public void paint(Graphics paramGraphics) { paramGraphics.drawImage(this.offImage, 0, 0, this); } public void update(Graphics paramGraphics) {
     paint(paramGraphics);
   }
 }


