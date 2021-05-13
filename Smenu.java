 import java.awt.AlphaComposite;
 import java.awt.Color;
 import java.awt.Font;
 import java.awt.FontMetrics;
 import java.awt.Graphics2D;
 
 public class Smenu
 {
   int sel = 0;
   String[] opts;
   String[] sopts;
   int no = 0;
   int x = 0; int y = 0;
   Font font = new Font("Arial", 1, 13);
   Color bcol = new Color(255, 255, 255);
   Color fcol = new Color(0, 0, 0);
   int w = 0; int h = 0;
   FontMetrics ftm;
   boolean show = false;
   boolean open = false;
   boolean dis = false;
   int maxl = 0;
   boolean rooms = false;
   int[] iroom;
   int kmoused = 0;
   
   boolean alphad = false;
   
   boolean revup = false;
   boolean carsel = false;
   boolean flksel = false;
   boolean om;
   boolean onsc;
   int scro;
   int scra;
   
   public void add(Graphics2D paramGraphics2D, String paramString) {
     paramGraphics2D.setFont(this.font); this.ftm = paramGraphics2D.getFontMetrics();
     if ((!this.rooms || this.no == 0) && this.ftm.stringWidth(paramString) + 30 > this.w) this.w = this.ftm.stringWidth(paramString) + 30; 
     if (this.rooms) { byte b; for (this.iroom = new int[7], b = 0; b < 7; ) { this.iroom[b] = 0; b++; }  }
      this.opts[this.no] = paramString;
     
     if (this.maxl != 0) {
       
       int i = paramString.length();
       for (; this.ftm.stringWidth(paramString.substring(0, i)) + 30 > this.maxl; i--);
       if (i != paramString.length()) { paramString = paramString.substring(0, i - 3); paramString = paramString + "..."; }
     
     } 
     this.sopts[this.no] = paramString;
     if (this.no < this.opts.length - 1) this.no++;
   
   }
   
   public void addw(String paramString1, String paramString2) {
     this.w = 300;
     this.opts[this.no] = paramString2;
     this.sopts[this.no] = paramString1;
     if (this.no < this.opts.length - 1) this.no++;
   
   }
   
   public void addstg(String paramString) {
     if (this.ftm.stringWidth(paramString) + 30 > this.w) this.w = this.ftm.stringWidth(paramString) + 30; 
     this.no++; if (this.no > 701) this.no = 701; 
     for (int i = this.no - 1; i > 1; ) { this.opts[i] = this.opts[i - 1]; this.sopts[i] = this.sopts[i - 1]; i--; }
      this.opts[1] = paramString;
     this.sopts[1] = paramString;
   }
   
   public void removeAll() { this.no = 0; this.w = 0; this.sel = 0; }
   public void select(int paramInt) { if (paramInt >= 0 && paramInt < this.no) this.sel = paramInt;  }
   public void select(String paramString) { for (byte b = 0; b < this.no; ) { if (this.opts[b].equals(paramString)) { this.sel = b; break; }  b++; }
      } public int getSelectedIndex() { return this.sel; }
   public String getSelectedItem() { return this.opts[this.sel]; }
   public String getItem(int paramInt) { String str = ""; if (paramInt >= 0 && paramInt < this.no) str = this.opts[paramInt];  return str; }
   public int getItemCount() { return this.no; }
   public void remove(String paramString) { for (byte b = 0; b < this.no; ) { if (this.opts[b].equals(paramString)) { for (byte b1 = b; b1 < this.no; ) { if (b1 != this.no - 1) { this.opts[b1] = this.opts[b1 + 1]; this.sopts[b1] = this.sopts[b1 + 1]; }  b1++; }  this.no--; break; }  b++; }
      } public void setSize(int paramInt1, int paramInt2) { this.w = paramInt1; this.h = paramInt2; }
   public int getWidth() { return this.w; }
   public void setFont(Font paramFont) { this.font = paramFont; }
   public void setBackground(Color paramColor) { this.bcol = paramColor; }
   public void setForeground(Color paramColor) { this.fcol = paramColor; }
   public Color getBackground() { return this.bcol; } public Color getForeground() {
     return this.fcol;
   }
   public void hide() { this.show = false; this.open = false; }
   public void show() { this.show = true; }
   public boolean isShowing() { return this.show; }
   public void move(int paramInt1, int paramInt2) { this.x = paramInt1; this.y = paramInt2; } public boolean hasFocus() {
     return false;
   }
   public void disable() { this.dis = true; }
   public void enable() { this.dis = false; } public boolean isEnabled() {
     return !this.dis;
   }
   public Smenu(int paramInt) {
     this.om = false; this.onsc = false;
     this.scro = 0; this.scra = 0;
     this.opts = new String[paramInt];
     this.sopts = new String[paramInt];
   } public boolean draw(Graphics2D paramGraphics2D, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2) {
     boolean bool = false;
     if (this.revup) { if (paramBoolean2) { paramBoolean2 = false; } else { paramBoolean2 = true; }  this.revup = false; }
     
     if (this.show)
     
     { if (this.alphad) paramGraphics2D.setComposite(AlphaComposite.getInstance(3, 0.7F));
       
       boolean bool1 = false;
       if (paramBoolean1) { if (!this.om) { this.om = true; bool1 = true; }  } else if (this.om) { this.om = false; }
        boolean bool2 = false;
       if ((this.bcol.getRed() + this.bcol.getGreen() + this.bcol.getBlue()) / 3 > (this.fcol.getRed() + this.fcol.getGreen() + this.fcol.getBlue()) / 3) bool2 = true; 
       boolean bool3 = false;
       if (paramInt1 > this.x && paramInt1 < this.x + this.w && paramInt2 > this.y + 1 && paramInt2 < this.y + 22 && !this.open && !this.dis) bool3 = true; 
       if (!this.open && bool3 && bool1 && !this.dis) { this.open = true; bool1 = false; }
        paramGraphics2D.setFont(this.font); this.ftm = paramGraphics2D.getFontMetrics();
       
       if (this.open)
       
       { int i = 4 + (this.ftm.getHeight() + 2) * this.no;
         
         if (!paramBoolean2) {
           
           byte b = 0;
           paramGraphics2D.setColor(this.bcol);
           paramGraphics2D.fillRect(this.x, this.y + 23, this.w, i);
           paramGraphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
           paramGraphics2D.drawRect(this.x, this.y + 23, this.w, i);
           
           if (this.y + 23 + i > paramInt3) {
             
             paramGraphics2D.drawLine(this.x + this.w - 18, this.y + 17, this.x + this.w - 18, paramInt3);
             if (bool2) { paramGraphics2D.setColor(new Color((this.bcol.getRed() + 510) / 3, (this.bcol.getGreen() + 510) / 3, (this.bcol.getBlue() + 510) / 3)); } else { paramGraphics2D.setColor(new Color((this.fcol.getRed() + 510) / 3, (this.fcol.getGreen() + 510) / 3, (this.fcol.getBlue() + 510) / 3)); }
              paramGraphics2D.fillRect(this.x + this.w - 15, this.y + 25 + this.scra, 13, 30);
             paramGraphics2D.setColor(this.fcol);
             paramGraphics2D.drawRect(this.x + this.w - 15, this.y + 25 + this.scra, 12, 30);
             paramGraphics2D.setColor(new Color(0, 0, 0));
             paramGraphics2D.drawLine(this.x + this.w - 12, this.y + 9 + 29 + this.scra, this.x + this.w - 12, this.y + 10 + 29 + this.scra);
             paramGraphics2D.drawLine(this.x + this.w - 11, this.y + 10 + 29 + this.scra, this.x + this.w - 11, this.y + 11 + 29 + this.scra);
             paramGraphics2D.drawLine(this.x + this.w - 10, this.y + 11 + 29 + this.scra, this.x + this.w - 10, this.y + 12 + 29 + this.scra);
             paramGraphics2D.drawLine(this.x + this.w - 9, this.y + 12 + 29 + this.scra, this.x + this.w - 9, this.y + 13 + 29 + this.scra);
             paramGraphics2D.drawLine(this.x + this.w - 8, this.y + 11 + 29 + this.scra, this.x + this.w - 8, this.y + 12 + 29 + this.scra);
             paramGraphics2D.drawLine(this.x + this.w - 7, this.y + 10 + 29 + this.scra, this.x + this.w - 7, this.y + 11 + 29 + this.scra);
             paramGraphics2D.drawLine(this.x + this.w - 6, this.y + 9 + 29 + this.scra, this.x + this.w - 6, this.y + 10 + 29 + this.scra);
             b = -18;
             if (paramBoolean1) { if (paramInt1 > this.x + this.w - 18 && paramInt1 < this.x + this.w && paramInt2 > this.y + 25 && paramInt2 < paramInt3) { bool1 = false; this.onsc = true; }  } else if (this.onsc) { this.onsc = false; }
              if (this.onsc) {
               
               this.scra = paramInt2 - this.y + 25 - 15; if (this.scra < 0) this.scra = 0; 
               int j = paramInt3 - this.y + 25 - 33; if (this.scra > j) this.scra = j; 
               int k = this.no * (this.ftm.getHeight() + 2) - j - this.ftm.getHeight() / 2;
               this.scro = -((int)(this.scra * k / j));
             } 
           } 
 
           
           for (byte b1 = 0; b1 < this.no; b1++) {
             
             if (Math.abs(this.scro) < (b1 + 1) * (this.ftm.getHeight() + 2)) {
               
               paramGraphics2D.setColor(this.fcol);
               if (paramInt1 > this.x && paramInt1 < this.x + this.w && paramInt2 > this.y + 25 + this.scro + b1 * (this.ftm.getHeight() + 2) && paramInt2 < this.y + 25 + this.scro + (b1 + 1) * (this.ftm.getHeight() + 2)) {
                 
                 if (bool2) { paramGraphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2)); } else { paramGraphics2D.setColor(this.fcol); }
                  paramGraphics2D.fillRect(this.x + 1, this.y + 25 + this.scro + b1 * (this.ftm.getHeight() + 2), this.w - 1 + b, this.ftm.getHeight() + 2); paramGraphics2D.setColor(this.bcol);
                 if (bool1) { if (!this.rooms || !this.opts[b1].equals("full")) { this.sel = b1; if (this.rooms && b1 != 0) this.sopts[b1] = " ";  } else { this.kmoused = 20; }  this.open = false; }
               
               }  if (this.rooms && this.sopts[b1].indexOf("10 / 10") != -1) paramGraphics2D.setColor(new Color(255, 0, 0)); 
               paramGraphics2D.drawString(this.sopts[b1], this.x + 4, this.y + 38 + this.scro + b1 * (this.ftm.getHeight() + 2));
             } 
           } 
           
           if (b != 0)
           {
             paramGraphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
             paramGraphics2D.drawLine(this.x, paramInt3 - 1, this.x + this.w, paramInt3 - 1);
           }
         
         }
         else {
           
           byte b = 0;
           paramGraphics2D.setColor(this.bcol);
           paramGraphics2D.fillRect(this.x, this.y - i, this.w, i);
           paramGraphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
           paramGraphics2D.drawRect(this.x, this.y - i, this.w, i);
           
           if (this.y - i < 0) {
             
             paramGraphics2D.drawLine(this.x + this.w - 18, 0, this.x + this.w - 18, this.y);
             if (bool2) { paramGraphics2D.setColor(new Color((this.bcol.getRed() + 510) / 3, (this.bcol.getGreen() + 510) / 3, (this.bcol.getBlue() + 510) / 3)); } else { paramGraphics2D.setColor(new Color((this.fcol.getRed() + 510) / 3, (this.fcol.getGreen() + 510) / 3, (this.fcol.getBlue() + 510) / 3)); }
              paramGraphics2D.fillRect(this.x + this.w - 15, this.y - this.scra - 33, 13, 30);
             paramGraphics2D.setColor(this.fcol);
             paramGraphics2D.drawRect(this.x + this.w - 15, this.y - this.scra - 33, 12, 30);
             paramGraphics2D.setColor(new Color(0, 0, 0));
             paramGraphics2D.drawLine(this.x + this.w - 12, this.y + 13 - 29 - this.scra, this.x + this.w - 12, this.y + 12 - 29 - this.scra);
             paramGraphics2D.drawLine(this.x + this.w - 11, this.y + 12 - 29 - this.scra, this.x + this.w - 11, this.y + 11 - 29 - this.scra);
             paramGraphics2D.drawLine(this.x + this.w - 10, this.y + 11 - 29 - this.scra, this.x + this.w - 10, this.y + 10 - 29 - this.scra);
             paramGraphics2D.drawLine(this.x + this.w - 9, this.y + 10 - 29 - this.scra, this.x + this.w - 9, this.y + 9 - 29 - this.scra);
             paramGraphics2D.drawLine(this.x + this.w - 8, this.y + 11 - 29 - this.scra, this.x + this.w - 8, this.y + 10 - 29 - this.scra);
             paramGraphics2D.drawLine(this.x + this.w - 7, this.y + 12 - 29 - this.scra, this.x + this.w - 7, this.y + 11 - 29 - this.scra);
             paramGraphics2D.drawLine(this.x + this.w - 6, this.y + 13 - 29 - this.scra, this.x + this.w - 6, this.y + 12 - 29 - this.scra);
             b = -18;
             if (paramBoolean1) { if (paramInt1 > this.x + this.w - 18 && paramInt1 < this.x + this.w && paramInt2 > 0 && paramInt2 < this.y - 3) { bool1 = false; this.onsc = true; }  } else if (this.onsc) { this.onsc = false; }
              if (this.onsc) {
               
               this.scra = this.y - 3 - 15 - paramInt2; if (this.scra < 0) this.scra = 0; 
               int j = this.y - 35; if (this.scra > j) this.scra = j; 
               int k = this.no * (this.ftm.getHeight() + 2) - j - this.ftm.getHeight() / 2;
               this.scro = (int)(this.scra * k / j);
             } 
           } 
           
           for (byte b1 = 0; b1 < this.no; b1++) {
             
             if (Math.abs(this.scro) < (b1 + 1) * (this.ftm.getHeight() + 2)) {
               
               paramGraphics2D.setColor(this.fcol);
               if (paramInt1 > this.x && paramInt1 < this.x + this.w && paramInt2 < this.y - 18 + this.scro - (b1 - 1) * (this.ftm.getHeight() + 2) && paramInt2 > this.y - 18 + this.scro - b1 * (this.ftm.getHeight() + 2)) {
                 
                 if (bool2) { paramGraphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2)); } else { paramGraphics2D.setColor(this.fcol); }
                  paramGraphics2D.fillRect(this.x + 1, this.y - 18 + this.scro - b1 * (this.ftm.getHeight() + 2), this.w - 1 + b, this.ftm.getHeight() + 2); paramGraphics2D.setColor(this.bcol);
                 if (bool1) { this.sel = b1; this.open = false; }
               
               }  paramGraphics2D.drawString(this.sopts[b1], this.x + 4, this.y - 5 + this.scro - b1 * (this.ftm.getHeight() + 2));
             } 
           } 
           
           if (b != 0) {
             
             paramGraphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
             paramGraphics2D.drawLine(this.x, 0, this.x + this.w, 0);
           } 
         } 
 
         
         bool = true; if (bool1) this.open = false;  }
       else { if (this.scro != 0) this.scro = 0;  if (this.scra != 0) this.scra = 0;
          }
       
       if (bool3) { if (bool2) { paramGraphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2)); } else { paramGraphics2D.setColor(this.fcol); }  } else { paramGraphics2D.setColor(this.bcol); }
        paramGraphics2D.fillRect(this.x, this.y + 1, this.w, 21);
       paramGraphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed()) / 2, (this.fcol.getGreen() + this.bcol.getGreen()) / 2, (this.fcol.getBlue() + this.bcol.getBlue()) / 2));
       paramGraphics2D.drawRect(this.x, this.y + 1, this.w, 21);
       
       if (bool2) { paramGraphics2D.setColor(new Color((this.bcol.getRed() + 255) / 2, (this.bcol.getGreen() + 255) / 2, (this.bcol.getBlue() + 255) / 2)); } else { paramGraphics2D.setColor(new Color((this.fcol.getRed() + 255) / 2, (this.fcol.getGreen() + 255) / 2, (this.fcol.getBlue() + 255) / 2)); }
        paramGraphics2D.drawRect(this.x + 1, this.y + 2, this.w - 2, 19);
       paramGraphics2D.drawLine(this.x + this.w - 17, this.y + 3, this.x + this.w - 17, this.y + 20);
       paramGraphics2D.setColor(this.fcol);
       if (this.dis) paramGraphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed() * 2) / 3, (this.fcol.getGreen() + this.bcol.getGreen() * 2) / 3, (this.fcol.getBlue() + this.bcol.getBlue() * 2) / 3)); 
       paramGraphics2D.drawRect(this.x + this.w - 16, this.y + 3, 14, 17);
       if (bool2) { paramGraphics2D.setColor(new Color((this.bcol.getRed() + 510) / 3, (this.bcol.getGreen() + 510) / 3, (this.bcol.getBlue() + 510) / 3)); } else { paramGraphics2D.setColor(new Color((this.fcol.getRed() + 510) / 3, (this.fcol.getGreen() + 510) / 3, (this.fcol.getBlue() + 510) / 3)); }
        paramGraphics2D.fillRect(this.x + this.w - 15, this.y + 4, 13, 16);
       paramGraphics2D.setColor(new Color(0, 0, 0));
       if (this.dis) paramGraphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed() * 2) / 3, (this.fcol.getGreen() + this.bcol.getGreen() * 2) / 3, (this.fcol.getBlue() + this.bcol.getBlue() * 2) / 3)); 
       paramGraphics2D.drawLine(this.x + this.w - 12, this.y + 9, this.x + this.w - 12, this.y + 10);
       paramGraphics2D.drawLine(this.x + this.w - 11, this.y + 10, this.x + this.w - 11, this.y + 11);
       paramGraphics2D.drawLine(this.x + this.w - 10, this.y + 11, this.x + this.w - 10, this.y + 12);
       paramGraphics2D.drawLine(this.x + this.w - 9, this.y + 12, this.x + this.w - 9, this.y + 13);
       paramGraphics2D.drawLine(this.x + this.w - 8, this.y + 11, this.x + this.w - 8, this.y + 12);
       paramGraphics2D.drawLine(this.x + this.w - 7, this.y + 10, this.x + this.w - 7, this.y + 11);
       paramGraphics2D.drawLine(this.x + this.w - 6, this.y + 9, this.x + this.w - 6, this.y + 10);
       if (bool3) { paramGraphics2D.setColor(this.bcol); } else { paramGraphics2D.setColor(this.fcol); }
        if (this.dis) paramGraphics2D.setColor(new Color((this.fcol.getRed() + this.bcol.getRed() * 2) / 3, (this.fcol.getGreen() + this.bcol.getGreen() * 2) / 3, (this.fcol.getBlue() + this.bcol.getBlue() * 2) / 3)); 
       if (this.carsel && !bool3) if (this.flksel) { paramGraphics2D.setColor(new Color(240, 240, 240)); this.flksel = false; } else { this.flksel = true; }
          
       paramGraphics2D.drawString(this.sopts[this.sel], this.x + 4, this.y + this.ftm.getHeight() + 2);
 
       
       if (this.alphad) paramGraphics2D.setComposite(AlphaComposite.getInstance(3, 1.0F));  }
     else { if (this.scro != 0) this.scro = 0;  if (this.scra != 0) this.scra = 0;  }
      return bool;
   }
 }


