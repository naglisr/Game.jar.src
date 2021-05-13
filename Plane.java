 import java.awt.Color;
 import java.awt.Graphics2D;
 import java.awt.RenderingHints;
 
 
 
 public class Plane
 {
   Medium m;
   Trackers t;
   int[] ox;
   int[] oy;
   int[] oz;
   int n;
   int[] c = new int[3];
   int[] oc = new int[3];
   float[] hsb = new float[3];
   int glass = 0;
   int gr = 0;
   int fs = 0;
   int disline = 7; boolean road = false;
   boolean solo = false;
   int light = 0;
   
   int master = 0;
   int wx = 0; int wz = 0; int wy = 0;
   
   float deltaf = 1.0F;
   float projf = 1.0F;
   int av = 0;
   
   int bfase = 0;
   
   boolean nocol = false;
   int chip = 0;
   float ctmag = 0.0F;
   int cxz = 0; int cxy = 0; int czy = 0;
   int[] cox = new int[3];
   int[] coz = new int[3];
   int[] coy = new int[3];
   int dx = 0, dy = 0, dz = 0, vx = 0, vy = 0, vz = 0;
   
   int embos = 0, typ = 0, pa = 0, pb = 0;
   int flx = 0;
   
   int colnum = 0;
 
   
   public Plane(Medium paramMedium, Trackers paramTrackers, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt1, int[] paramArrayOfint4, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, boolean paramBoolean1, int paramInt10, boolean paramBoolean2) {
     this.m = paramMedium;
     this.t = paramTrackers;
     this.n = paramInt1;
     this.ox = new int[this.n]; this.oz = new int[this.n]; this.oy = new int[this.n]; int i;
     for (i = 0; i < this.n; ) { this.ox[i] = paramArrayOfint1[i]; this.oy[i] = paramArrayOfint3[i]; this.oz[i] = paramArrayOfint2[i]; i++; }
      for (i = 0; i < 3; ) { this.oc[i] = paramArrayOfint4[i]; i++; }
     
     if (paramInt3 == -15) {
       
       if (paramArrayOfint4[0] == 211) { int j; byte b1; for (i = (int)(Math.random() * 40.0D - 20.0D), j = (int)(Math.random() * 40.0D - 20.0D), b1 = 0; b1 < this.n; ) { this.ox[b1] = this.ox[b1] + i; this.oz[b1] = this.oz[b1] + j; b1++; }  }
        i = (int)(185.0D + Math.random() * 20.0D); paramArrayOfint4[0] = (217 + i) / 2; if (paramArrayOfint4[0] == 211) paramArrayOfint4[0] = 210;  byte b; for (paramArrayOfint4[1] = (189 + i) / 2, paramArrayOfint4[2] = (132 + i) / 2, b = 0; b < this.n; ) { if (Math.random() > Math.random()) this.ox[b] = this.ox[b] + (int)(8.0D * Math.random() - 4.0D);  if (Math.random() > Math.random()) this.oy[b] = this.oy[b] + (int)(8.0D * Math.random() - 4.0D);  if (Math.random() > Math.random()) this.oz[b] = this.oz[b] + (int)(8.0D * Math.random() - 4.0D);  b++; }
     
     } 
     if (paramArrayOfint4[0] == paramArrayOfint4[1] && paramArrayOfint4[1] == paramArrayOfint4[2]) this.nocol = true; 
     if (paramInt2 == 0) for (i = 0; i < 3; ) { this.c[i] = (int)(paramArrayOfint4[i] + paramArrayOfint4[i] * this.m.snap[i] / 100.0F); if (this.c[i] > 255) this.c[i] = 255;  if (this.c[i] < 0) this.c[i] = 0;  i++; }
         if (paramInt2 == 1) for (i = 0; i < 3; ) { this.c[i] = (this.m.csky[i] * this.m.fade[0] * 2 + this.m.cfade[i] * 3000) / (this.m.fade[0] * 2 + 3000); i++; }
         if (paramInt2 == 2) for (i = 0; i < 3; ) { this.c[i] = (int)(this.m.crgrnd[i] * 0.925F); i++; }
         if (paramInt2 == 3) for (i = 0; i < 3; ) { this.c[i] = paramArrayOfint4[i]; i++; }
         this.disline = paramInt8;
     this.bfase = paramInt9;
     this.glass = paramInt2;
     Color.RGBtoHSB(this.c[0], this.c[1], this.c[2], this.hsb);
     if (paramInt2 == 3 && this.m.trk != 2) { this.hsb[1] = this.hsb[1] + 0.05F; if (this.hsb[1] > 1.0F) this.hsb[1] = 1.0F;  }
     
     if (!this.nocol && this.glass != 1) {
       
       if (this.bfase > 20 && this.hsb[1] > 0.25D) this.hsb[1] = 0.25F; 
       if (this.bfase > 25 && this.hsb[2] > 0.7D) this.hsb[2] = 0.7F; 
       if (this.bfase > 30 && this.hsb[1] > 0.15D) this.hsb[1] = 0.15F; 
       if (this.bfase > 35 && this.hsb[2] > 0.6D) this.hsb[2] = 0.6F; 
       if (this.bfase > 40) this.hsb[0] = 0.075F; 
       if (this.bfase > 50 && this.hsb[2] > 0.5D) this.hsb[2] = 0.5F; 
       if (this.bfase > 60) this.hsb[0] = 0.05F; 
     } 
     this.road = paramBoolean1;
     this.light = paramInt10;
     this.solo = paramBoolean2;
     this.gr = paramInt3;
     this.fs = paramInt4;
     this.wx = paramInt5;
     this.wy = paramInt6;
     this.wz = paramInt7;
     deltafntyp();
   }
 
 
   
   public void deltafntyp() {
     int i = Math.abs(this.ox[2] - this.ox[1]);
     int j = Math.abs(this.oy[2] - this.oy[1]);
     int k = Math.abs(this.oz[2] - this.oz[1]);
     if (j <= i && j <= k) this.typ = 2; 
     if (i <= j && i <= k) this.typ = 1; 
     if (k <= i && k <= j) this.typ = 3; 
     this.deltaf = 1.0F;
     for (byte b = 0; b < 3; ) { for (byte b1 = 0; b1 < 3; ) { if (b1 != b) this.deltaf *= (float)(Math.sqrt(((this.ox[b1] - this.ox[b]) * (this.ox[b1] - this.ox[b]) + (this.oy[b1] - this.oy[b]) * (this.oy[b1] - this.oy[b]) + (this.oz[b1] - this.oz[b]) * (this.oz[b1] - this.oz[b]))) / 100.0D);  b1++; }  b++; }
      this.deltaf /= 3.0F;
   }
 
 
   
   public void loadprojf() {
     this.projf = 1.0F;
     for (byte b = 0; b < 3; ) { for (byte b1 = 0; b1 < 3; ) { if (b1 != b) this.projf *= (float)(Math.sqrt(((this.ox[b] - this.ox[b1]) * (this.ox[b] - this.ox[b1]) + (this.oz[b] - this.oz[b1]) * (this.oz[b] - this.oz[b1]))) / 100.0D);  b1++; }  b++; }
      this.projf /= 3.0F;
   }
 
 
   
   public void d(Graphics2D paramGraphics2D, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, int paramInt9) {
     if (this.master == 1) if (this.av > 1500 && !this.m.crs) { this.n = 12; } else { this.n = 20; }
        
     int[] arrayOfInt1 = new int[this.n], arrayOfInt2 = new int[this.n], arrayOfInt3 = new int[this.n];
     
     if (this.embos == 0) {
       byte b;
       for (b = 0; b < this.n; ) { arrayOfInt1[b] = this.ox[b] + paramInt1; arrayOfInt3[b] = this.oy[b] + paramInt2; arrayOfInt2[b] = this.oz[b] + paramInt3; b++; }
        if ((this.gr == -11 || this.gr == -12 || this.gr == -13) && this.m.lastmaf == 1) for (b = 0; b < this.n; ) { arrayOfInt1[b] = -this.ox[b] + paramInt1; arrayOfInt3[b] = this.oy[b] + paramInt2; arrayOfInt2[b] = -this.oz[b] + paramInt3; b++; }
       
     
     } else {
       if (this.embos <= 11 && this.m.random() > 0.5D && this.glass != 1) {
         
         for (byte b9 = 0; b9 < this.n; ) { arrayOfInt1[b9] = (int)((this.ox[b9] + paramInt1) + 15.0F - this.m.random() * 30.0F); arrayOfInt3[b9] = (int)((this.oy[b9] + paramInt2) + 15.0F - this.m.random() * 30.0F); arrayOfInt2[b9] = (int)((this.oz[b9] + paramInt3) + 15.0F - this.m.random() * 30.0F); b9++; }
          rot(arrayOfInt1, arrayOfInt3, paramInt1, paramInt2, paramInt5, this.n);
         rot(arrayOfInt3, arrayOfInt2, paramInt2, paramInt3, paramInt6, this.n);
         rot(arrayOfInt1, arrayOfInt2, paramInt1, paramInt3, paramInt4, this.n);
         rot(arrayOfInt1, arrayOfInt2, this.m.cx, this.m.cz, this.m.xz, this.n);
         rot(arrayOfInt3, arrayOfInt2, this.m.cy, this.m.cz, this.m.zy, this.n);
         int[] arrayOfInt8 = new int[this.n];
         int[] arrayOfInt9 = new int[this.n];
         for (byte b10 = 0; b10 < this.n; b10++) {
           
           arrayOfInt8[b10] = xs(arrayOfInt1[b10], arrayOfInt2[b10]);
           arrayOfInt9[b10] = ys(arrayOfInt3[b10], arrayOfInt2[b10]);
         } 
         paramGraphics2D.setColor(new Color(230, 230, 230));
         paramGraphics2D.fillPolygon(arrayOfInt8, arrayOfInt9, this.n);
       } 
       
       float f = 1.0F;
       if (this.embos <= 4) f = 1.0F + this.m.random() / 5.0F; 
       if (this.embos > 4 && this.embos <= 7) f = 1.0F + this.m.random() / 4.0F; 
       if (this.embos > 7 && this.embos <= 9) { f = 1.0F + this.m.random() / 3.0F; if (this.hsb[2] > 0.7D) this.hsb[2] = 0.7F;  }
        if (this.embos > 9 && this.embos <= 10) { f = 1.0F + this.m.random() / 2.0F; if (this.hsb[2] > 0.6D) this.hsb[2] = 0.6F;  }
        if (this.embos > 10 && this.embos <= 12) { f = 1.0F + this.m.random() / 1.0F; if (this.hsb[2] > 0.5D) this.hsb[2] = 0.5F;  }
        if (this.embos == 12) { this.chip = 1; this.ctmag = 2.0F; this.bfase = -7; }
        if (this.embos == 13) { this.hsb[1] = 0.2F; this.hsb[2] = 0.4F; }
 
       
       if (this.embos == 16) for (this.pa = (int)(this.m.random() * this.n), this.pb = (int)(this.m.random() * this.n); this.pa == this.pb; this.pb = (int)(this.m.random() * this.n)); 
       if (this.embos >= 16) {
         
         byte b9 = 1, b10 = 1; int k;
         for (k = Math.abs(paramInt6); k > 270; k -= 360); k = Math.abs(k); if (k > 90) b9 = -1;  int m;
         for (m = Math.abs(paramInt5); m > 270; m -= 360); m = Math.abs(m); if (m > 90) b10 = -1;
         
         int[] arrayOfInt8 = new int[3];
         int[] arrayOfInt9 = new int[3];
         
         arrayOfInt1[0] = this.ox[this.pa] + paramInt1; arrayOfInt3[0] = this.oy[this.pa] + paramInt2; arrayOfInt2[0] = this.oz[this.pa] + paramInt3; arrayOfInt1[1] = this.ox[this.pb] + paramInt1; arrayOfInt3[1] = this.oy[this.pb] + paramInt2; arrayOfInt2[1] = this.oz[this.pb] + paramInt3;
         while (Math.abs(arrayOfInt1[0] - arrayOfInt1[1]) > 100) { if (arrayOfInt1[1] > arrayOfInt1[0]) { arrayOfInt1[1] = arrayOfInt1[1] - 30; continue; }  arrayOfInt1[1] = arrayOfInt1[1] + 30; }
          while (Math.abs(arrayOfInt2[0] - arrayOfInt2[1]) > 100) { if (arrayOfInt2[1] > arrayOfInt2[0]) { arrayOfInt2[1] = arrayOfInt2[1] - 30; continue; }  arrayOfInt2[1] = arrayOfInt2[1] + 30; }
         
         int n = (int)((Math.abs(arrayOfInt1[0] - arrayOfInt1[1]) / 3) * (0.5D - this.m.random()));
         int i1 = (int)((Math.abs(arrayOfInt2[0] - arrayOfInt2[1]) / 3) * (0.5D - this.m.random()));
         
         arrayOfInt1[2] = (arrayOfInt1[0] + arrayOfInt1[1]) / 2 + n;
         arrayOfInt2[2] = (arrayOfInt2[0] + arrayOfInt2[1]) / 2 + i1;
         int i2 = (int)((Math.abs(arrayOfInt1[0] - arrayOfInt1[1]) + Math.abs(arrayOfInt2[0] - arrayOfInt2[1])) / 1.5D * ((this.m.random() / 2.0F) + 0.5D));
         arrayOfInt3[2] = (arrayOfInt3[0] + arrayOfInt3[1]) / 2 - b9 * b10 * i2;
         
         rot(arrayOfInt1, arrayOfInt3, paramInt1, paramInt2, paramInt5, 3); rot(arrayOfInt3, arrayOfInt2, paramInt2, paramInt3, paramInt6, 3); rot(arrayOfInt1, arrayOfInt2, paramInt1, paramInt3, paramInt4, 3); rot(arrayOfInt1, arrayOfInt2, this.m.cx, this.m.cz, this.m.xz, 3); rot(arrayOfInt3, arrayOfInt2, this.m.cy, this.m.cz, this.m.zy, 3); int i3;
         for (i3 = 0; i3 < 3; ) { arrayOfInt8[i3] = xs(arrayOfInt1[i3], arrayOfInt2[i3]); arrayOfInt9[i3] = ys(arrayOfInt3[i3], arrayOfInt2[i3]); i3++; }
         
         i3 = (int)(255.0F + 255.0F * this.m.snap[0] / 400.0F); if (i3 > 255) i3 = 255;  if (i3 < 0) i3 = 0; 
         int i4 = (int)(169.0F + 169.0F * this.m.snap[1] / 300.0F); if (i4 > 255) i4 = 255;  if (i4 < 0) i4 = 0; 
         int i5 = (int)(89.0F + 89.0F * this.m.snap[2] / 200.0F); if (i5 > 255) i5 = 255;  if (i5 < 0) i5 = 0;
         
         paramGraphics2D.setColor(new Color(i3, i4, i5));
         paramGraphics2D.fillPolygon(arrayOfInt8, arrayOfInt9, 3);
 
         
         arrayOfInt1[0] = this.ox[this.pa] + paramInt1; arrayOfInt3[0] = this.oy[this.pa] + paramInt2; arrayOfInt2[0] = this.oz[this.pa] + paramInt3; arrayOfInt1[1] = this.ox[this.pb] + paramInt1; arrayOfInt3[1] = this.oy[this.pb] + paramInt2; arrayOfInt2[1] = this.oz[this.pb] + paramInt3;
         while (Math.abs(arrayOfInt1[0] - arrayOfInt1[1]) > 100) { if (arrayOfInt1[1] > arrayOfInt1[0]) { arrayOfInt1[1] = arrayOfInt1[1] - 30; continue; }  arrayOfInt1[1] = arrayOfInt1[1] + 30; }
          while (Math.abs(arrayOfInt2[0] - arrayOfInt2[1]) > 100) { if (arrayOfInt2[1] > arrayOfInt2[0]) { arrayOfInt2[1] = arrayOfInt2[1] - 30; continue; }  arrayOfInt2[1] = arrayOfInt2[1] + 30; }
         
         arrayOfInt1[2] = (arrayOfInt1[0] + arrayOfInt1[1]) / 2 + n;
         arrayOfInt2[2] = (arrayOfInt2[0] + arrayOfInt2[1]) / 2 + i1;
         
         i2 = (int)(i2 * 0.8D);
         arrayOfInt3[2] = (arrayOfInt3[0] + arrayOfInt3[1]) / 2 - b9 * b10 * i2;
         
         rot(arrayOfInt1, arrayOfInt3, paramInt1, paramInt2, paramInt5, 3); rot(arrayOfInt3, arrayOfInt2, paramInt2, paramInt3, paramInt6, 3); rot(arrayOfInt1, arrayOfInt2, paramInt1, paramInt3, paramInt4, 3); rot(arrayOfInt1, arrayOfInt2, this.m.cx, this.m.cz, this.m.xz, 3); rot(arrayOfInt3, arrayOfInt2, this.m.cy, this.m.cz, this.m.zy, 3);
         for (byte b11 = 0; b11 < 3; ) { arrayOfInt8[b11] = xs(arrayOfInt1[b11], arrayOfInt2[b11]); arrayOfInt9[b11] = ys(arrayOfInt3[b11], arrayOfInt2[b11]); b11++; }
         
         i3 = (int)(255.0F + 255.0F * this.m.snap[0] / 400.0F); if (i3 > 255) i3 = 255;  if (i3 < 0) i3 = 0; 
         i4 = (int)(207.0F + 207.0F * this.m.snap[1] / 300.0F); if (i4 > 255) i4 = 255;  if (i4 < 0) i4 = 0; 
         i5 = (int)(136.0F + 136.0F * this.m.snap[2] / 200.0F); if (i5 > 255) i5 = 255;  if (i5 < 0) i5 = 0;
         
         paramGraphics2D.setColor(new Color(i3, i4, i5));
         paramGraphics2D.fillPolygon(arrayOfInt8, arrayOfInt9, 3);
       } 
       
       for (byte b = 0; b < this.n; b++) {
         
         if (this.typ == 1) { arrayOfInt1[b] = (int)(this.ox[b] * f + paramInt1); } else { arrayOfInt1[b] = this.ox[b] + paramInt1; }
          if (this.typ == 2) { arrayOfInt3[b] = (int)(this.oy[b] * f + paramInt2); } else { arrayOfInt3[b] = this.oy[b] + paramInt2; }
          if (this.typ == 3) { arrayOfInt2[b] = (int)(this.oz[b] * f + paramInt3); } else { arrayOfInt2[b] = this.oz[b] + paramInt3; }
       
       } 
       if (this.embos != 70) { this.embos++; } else { this.embos = 16; }
     
     } 
     
     if (this.wz != 0) rot(arrayOfInt3, arrayOfInt2, this.wy + paramInt2, this.wz + paramInt3, paramInt8, this.n); 
     if (this.wx != 0) rot(arrayOfInt1, arrayOfInt2, this.wx + paramInt1, this.wz + paramInt3, paramInt7, this.n);
     
     if (this.chip == 1 && (this.m.random() > 0.6D || this.bfase == 0)) { this.chip = 0; if (this.bfase == 0 && this.nocol) this.bfase = 1;  }
      if (this.chip != 0) {
       
       if (this.chip == 1) {
         
         this.cxz = paramInt4;
         this.cxy = paramInt5;
         this.czy = paramInt6;
         int m = (int)(this.m.random() * this.n);
         this.cox[0] = this.ox[m];
         this.coz[0] = this.oz[m];
         this.coy[0] = this.oy[m];
         if (this.ctmag > 3.0F) this.ctmag = 3.0F; 
         if (this.ctmag < -3.0F) this.ctmag = -3.0F; 
         this.cox[1] = (int)(this.cox[0] + this.ctmag * (10.0F - this.m.random() * 20.0F));
         this.cox[2] = (int)(this.cox[0] + this.ctmag * (10.0F - this.m.random() * 20.0F));
         this.coy[1] = (int)(this.coy[0] + this.ctmag * (10.0F - this.m.random() * 20.0F));
         this.coy[2] = (int)(this.coy[0] + this.ctmag * (10.0F - this.m.random() * 20.0F));
         this.coz[1] = (int)(this.coz[0] + this.ctmag * (10.0F - this.m.random() * 20.0F));
         this.coz[2] = (int)(this.coz[0] + this.ctmag * (10.0F - this.m.random() * 20.0F));
         this.dx = 0; this.dy = 0; this.dz = 0;
         if (this.bfase != -7) {
           
           this.vx = (int)(this.ctmag * (30.0F - this.m.random() * 60.0F));
           this.vz = (int)(this.ctmag * (30.0F - this.m.random() * 60.0F));
           this.vy = (int)(this.ctmag * (30.0F - this.m.random() * 60.0F));
         }
         else {
           
           this.vx = (int)(this.ctmag * (10.0F - this.m.random() * 20.0F));
           this.vz = (int)(this.ctmag * (10.0F - this.m.random() * 20.0F));
           this.vy = (int)(this.ctmag * (10.0F - this.m.random() * 20.0F));
         } 
         this.chip = 2;
       } 
       
       int[] arrayOfInt8 = new int[3], arrayOfInt9 = new int[3], arrayOfInt10 = new int[3]; byte b;
       for (b = 0; b < 3; ) { arrayOfInt8[b] = this.cox[b] + paramInt1; arrayOfInt10[b] = this.coy[b] + paramInt2; arrayOfInt9[b] = this.coz[b] + paramInt3; b++; }
       
       rot(arrayOfInt8, arrayOfInt10, paramInt1, paramInt2, this.cxy, 3);
       rot(arrayOfInt10, arrayOfInt9, paramInt2, paramInt3, this.czy, 3);
       rot(arrayOfInt8, arrayOfInt9, paramInt1, paramInt3, this.cxz, 3);
       
       for (b = 0; b < 3; ) { arrayOfInt8[b] = arrayOfInt8[b] + this.dx; arrayOfInt10[b] = arrayOfInt10[b] + this.dy; arrayOfInt9[b] = arrayOfInt9[b] + this.dz; b++; }
        this.dx += this.vx;
       this.dz += this.vz;
       this.dy += this.vy;
       this.vy += 7;
       if (arrayOfInt10[0] > this.m.ground) this.chip = 19;
       
       rot(arrayOfInt8, arrayOfInt9, this.m.cx, this.m.cz, this.m.xz, 3);
       rot(arrayOfInt10, arrayOfInt9, this.m.cy, this.m.cz, this.m.zy, 3);
       int[] arrayOfInt11 = new int[3];
       int[] arrayOfInt12 = new int[3]; int k;
       for (k = 0; k < 3; k++) {
         
         arrayOfInt11[k] = xs(arrayOfInt8[k], arrayOfInt9[k]);
         arrayOfInt12[k] = ys(arrayOfInt10[k], arrayOfInt9[k]);
       } 
       k = (int)(this.m.random() * 3.0F);
       if (this.bfase != -7) {
         
         if (k == 0) paramGraphics2D.setColor((new Color(this.c[0], this.c[1], this.c[2])).darker()); 
         if (k == 1) paramGraphics2D.setColor(new Color(this.c[0], this.c[1], this.c[2])); 
         if (k == 2) paramGraphics2D.setColor((new Color(this.c[0], this.c[1], this.c[2])).brighter());
       
       } else {
         
         paramGraphics2D.setColor(Color.getHSBColor(this.hsb[0], this.hsb[1], this.hsb[2]));
       } 
       paramGraphics2D.fillPolygon(arrayOfInt11, arrayOfInt12, 3);
       this.chip++;
       if (this.chip == 20) this.chip = 0;
     
     } 
 
 
     
     rot(arrayOfInt1, arrayOfInt3, paramInt1, paramInt2, paramInt5, this.n);
     rot(arrayOfInt3, arrayOfInt2, paramInt2, paramInt3, paramInt6, this.n);
     rot(arrayOfInt1, arrayOfInt2, paramInt1, paramInt3, paramInt4, this.n);
 
     
     if ((paramInt5 != 0 || paramInt6 != 0 || paramInt4 != 0) && this.m.trk != 2) {
       
       this.projf = 1.0F;
       for (byte b = 0; b < 3; ) { for (byte b9 = 0; b9 < 3; ) { if (b9 != b) this.projf *= (float)(Math.sqrt(((arrayOfInt1[b] - arrayOfInt1[b9]) * (arrayOfInt1[b] - arrayOfInt1[b9]) + (arrayOfInt2[b] - arrayOfInt2[b9]) * (arrayOfInt2[b] - arrayOfInt2[b9]))) / 100.0D);  b9++; }  b++; }  this.projf /= 3.0F;
     } 
     
     rot(arrayOfInt1, arrayOfInt2, this.m.cx, this.m.cz, this.m.xz, this.n);
     
     boolean bool = false; int arrayOfInt4[] = new int[this.n], arrayOfInt5[] = new int[this.n], i = 500; byte b1;
     for (b1 = 0; b1 < this.n; ) { arrayOfInt4[b1] = xs(arrayOfInt1[b1], arrayOfInt2[b1]); arrayOfInt5[b1] = ys(arrayOfInt3[b1], arrayOfInt2[b1]); b1++; }
      b1 = 0; byte b2 = 1; byte b3;
     for (b3 = 0; b3 < this.n; ) { for (byte b = b3; b < this.n; ) { if (b3 != b && Math.abs(arrayOfInt4[b3] - arrayOfInt4[b]) - Math.abs(arrayOfInt5[b3] - arrayOfInt5[b]) < i) { b2 = b3; b1 = b; i = Math.abs(arrayOfInt4[b3] - arrayOfInt4[b]) - Math.abs(arrayOfInt5[b3] - arrayOfInt5[b]); }  b++; }  b3++; }
      if (arrayOfInt5[b1] < arrayOfInt5[b2]) { b3 = b1; b1 = b2; b2 = b3; }
      if (spy(arrayOfInt1[b1], arrayOfInt2[b1]) > spy(arrayOfInt1[b2], arrayOfInt2[b2])) {
       
       bool = true; b3 = 0;
       for (byte b = 0; b < this.n; ) { if (arrayOfInt2[b] < 50 && arrayOfInt3[b] > this.m.cy) { bool = false; } else if (arrayOfInt3[b] == arrayOfInt3[0]) { b3++; }  b++; }
        if (b3 == this.n && arrayOfInt3[0] > this.m.cy) bool = false;
     
     } 
     rot(arrayOfInt3, arrayOfInt2, this.m.cy, this.m.cz, this.m.zy, this.n);
     
     b3 = 1;
     
     int[] arrayOfInt6 = new int[this.n];
     int[] arrayOfInt7 = new int[this.n];
     byte b4 = 0, b5 = 0, b6 = 0, b7 = 0, b8 = 0; int j;
     for (j = 0; j < this.n; j++) {
       
       arrayOfInt6[j] = xs(arrayOfInt1[j], arrayOfInt2[j]);
       arrayOfInt7[j] = ys(arrayOfInt3[j], arrayOfInt2[j]);
       
       if (arrayOfInt7[j] < this.m.ih || arrayOfInt2[j] < 10) b4++; 
       if (arrayOfInt7[j] > this.m.h || arrayOfInt2[j] < 10) b5++; 
       if (arrayOfInt6[j] < this.m.iw || arrayOfInt2[j] < 10) b6++; 
       if (arrayOfInt6[j] > this.m.w || arrayOfInt2[j] < 10) b7++; 
       if (arrayOfInt2[j] < 10) b8++;
     
     } 
     if (b6 == this.n || b4 == this.n || b5 == this.n || b7 == this.n) b3 = 0; 
     if ((this.m.trk == 1 || this.m.trk == 4) && (b6 != 0 || b4 != 0 || b5 != 0 || b7 != 0)) b3 = 0; 
     if (this.m.trk == 3 && b8 != 0) b3 = 0; 
     if (b8 != 0) paramBoolean = true;
     
     if (b3 != 0 && paramInt9 != -1) {
       
       j = 0;
       int k = 0;
       for (byte b = 0; b < this.n; ) { for (byte b9 = b; b9 < this.n; ) { if (b != b9) { if (Math.abs(arrayOfInt6[b] - arrayOfInt6[b9]) > j) j = Math.abs(arrayOfInt6[b] - arrayOfInt6[b9]);  if (Math.abs(arrayOfInt7[b] - arrayOfInt7[b9]) > k) k = Math.abs(arrayOfInt7[b] - arrayOfInt7[b9]);  }  b9++; }  b++; }
        if (j == 0 || k == 0) { b3 = 0; }
       
       else if (j < 3 && k < 3 && ((paramInt9 / j > 15 && paramInt9 / k > 15) || paramBoolean) && (!this.m.lightson || this.light == 0)) { b3 = 0; }
     
     } 
 
     
     if (b3 != 0) {
 
       
       j = 1;
       int k = this.gr;
       if (k < 0 && k >= -15) k = 0; 
       if (this.gr == -11) k = -90; 
       if (this.gr == -12) k = -75; 
       if (this.gr == -14 || this.gr == -15) k = -50; 
       if (this.glass == 2) k = 200;
       
       if (this.fs != 0) {
         
         byte b9 = 1, b10 = 1; if (Math.abs(arrayOfInt7[0] - arrayOfInt7[1]) > Math.abs(arrayOfInt7[2] - arrayOfInt7[1])) { b9 = 0; b10 = 2; } else { b9 = 2; b10 = 0; j *= -1; }
          if (arrayOfInt7[1] > arrayOfInt7[b9]) j *= -1;  if (arrayOfInt6[1] > arrayOfInt6[b10]) j *= -1; 
         if (this.fs != 22) { j *= this.fs; if (j == -1) { k += 40; j = -111; }
            }
       
       }  if (this.m.lightson && this.light == 2) k -= 40;
       
       int m = arrayOfInt3[0], n = arrayOfInt3[0], i1 = arrayOfInt1[0], i2 = arrayOfInt1[0], i3 = arrayOfInt2[0], i4 = arrayOfInt2[0]; int i5;
       for (i5 = 0; i5 < this.n; ) { if (arrayOfInt3[i5] > m) m = arrayOfInt3[i5];  if (arrayOfInt3[i5] < n) n = arrayOfInt3[i5];  if (arrayOfInt1[i5] > i1) i1 = arrayOfInt1[i5];  if (arrayOfInt1[i5] < i2) i2 = arrayOfInt1[i5];  if (arrayOfInt2[i5] > i3) i3 = arrayOfInt2[i5];  if (arrayOfInt2[i5] < i4) i4 = arrayOfInt2[i5];  i5++; }
        i5 = (m + n) / 2;
       int i6 = (i1 + i2) / 2;
       int i7 = (i3 + i4) / 2;
       this.av = (int)Math.sqrt(((this.m.cy - i5) * (this.m.cy - i5) + (this.m.cx - i6) * (this.m.cx - i6) + i7 * i7 + k * k * k));
       
       if (this.m.trk == 0 && (this.av > this.m.fade[this.disline] || this.av == 0)) b3 = 0;
 
       
       if (j == -111 && this.av > 4500 && !this.road) b3 = 0; 
       if (j == -111 && this.av > 1500) paramBoolean = true; 
       if (this.av > 3000 && this.m.adv <= 900) paramBoolean = true;
       
       if (this.fs == 22 && this.av < 11200) this.m.lastmaf = j; 
       if (this.gr == -13 && (!this.m.lastcheck || paramInt9 != -1)) b3 = 0; 
       if (this.master == 2 && this.av > 1500 && !this.m.crs) b3 = 0; 
       if ((this.gr == -14 || this.gr == -15 || this.gr == -12) && (this.av > 11000 || bool || j == -111 || this.m.resdown == 2) && this.m.trk != 2 && this.m.trk != 3) b3 = 0; 
       if (this.gr == -11 && this.av > 11000 && this.m.trk != 2 && this.m.trk != 3) b3 = 0; 
       if (this.glass == 2 && (this.m.trk != 0 || this.av > 6700)) b3 = 0; 
       if (this.flx != 0 && this.m.random() > 0.3D && this.flx != 77) b3 = 0;
     
     } 
     if (b3 != 0) {
       
       float f = (float)((this.projf / this.deltaf) + 0.3D);
       
       if (paramBoolean && !this.solo) {
         
         boolean bool1 = false;
         if (f > 1.0F) { if (f >= 1.27D) bool1 = true;  f = 1.0F; }
          if (bool1) { f = (float)(f * 0.89D); } else { f = (float)(f * 0.86D); }
          if (f < 0.37D) f = 0.37F; 
         if (this.gr == -9) f = 0.7F; 
         if (this.gr == -4) f = 0.74F; 
         if (this.gr != -7 && this.m.trk == 0 && bool) f = 0.32F; 
         if (this.gr == -8 || this.gr == -14 || this.gr == -15) f = 1.0F; 
         if (this.gr == -11 || this.gr == -12) { f = 0.6F; if (paramInt9 == -1) if (this.m.cpflik || (this.m.nochekflk && !this.m.lastcheck)) { f = 1.0F; } else { f = 0.76F; }   }
          if (this.gr == -13 && paramInt9 == -1) if (this.m.cpflik) { f = 0.0F; } else { f = 0.76F; }
             if (this.gr == -6) f = 0.62F; 
         if (this.gr == -5) f = 0.55F;
       
       } else {
         
         if (f > 1.0F) f = 1.0F; 
         if (f < 0.6D || bool) f = 0.6F;
       
       } 
       
       Color color = Color.getHSBColor(this.hsb[0], this.hsb[1], this.hsb[2] * f);
       
       if (this.m.trk == 1) { float[] arrayOfFloat = new float[3]; Color.RGBtoHSB(this.oc[0], this.oc[1], this.oc[2], arrayOfFloat); arrayOfFloat[0] = 0.15F; arrayOfFloat[1] = 0.3F; color = Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2] * f + 0.0F); }
        if (this.m.trk == 3) { float[] arrayOfFloat = new float[3]; Color.RGBtoHSB(this.oc[0], this.oc[1], this.oc[2], arrayOfFloat); arrayOfFloat[0] = 0.6F; arrayOfFloat[1] = 0.14F; color = Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2] * f + 0.0F); }
       
       int k = color.getRed();
       int m = color.getGreen();
       int n = color.getBlue();
       
       if (this.m.lightson && (this.light != 0 || ((this.gr == -11 || this.gr == -12) && paramInt9 == -1))) { k = this.oc[0]; if (k > 255) k = 255;  if (k < 0) k = 0;  m = this.oc[1]; if (m > 255) m = 255;  if (m < 0) m = 0;  n = this.oc[2]; if (n > 255) n = 255;  if (n < 0) n = 0;  }
       
       if (this.m.trk == 0)
       {
         for (byte b = 0; b < 16; b++) {
           
           if (this.av > this.m.fade[b]) { k = (k * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1); m = (m * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1); n = (n * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1); }
         
         } 
       }
       paramGraphics2D.setColor(new Color(k, m, n));
       paramGraphics2D.fillPolygon(arrayOfInt6, arrayOfInt7, this.n);
       
       if (this.m.trk != 0 && this.gr == -10) paramBoolean = false;
       
       if (!paramBoolean) {
         
         if (this.flx == 0) {
           
           if (!this.solo) {
             
             k = 0; m = 0; n = 0;
             if (this.m.lightson && this.light != 0) { k = this.oc[0] / 2; if (k > 255) k = 255;  if (k < 0) k = 0;  m = this.oc[1] / 2; if (m > 255) m = 255;  if (m < 0) m = 0;  n = this.oc[2] / 2; if (n > 255) n = 255;  if (n < 0) n = 0;  }
              if (Madness.anti == 1) paramGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
             paramGraphics2D.setColor(new Color(k, m, n));
             paramGraphics2D.drawPolygon(arrayOfInt6, arrayOfInt7, this.n);
             if (Madness.anti == 1) paramGraphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
           
           } 
         } else {
           
           if (this.flx == 2) { paramGraphics2D.setColor(new Color(0, 0, 0)); paramGraphics2D.drawPolygon(arrayOfInt6, arrayOfInt7, this.n); }
            if (this.flx == 1) { k = 0; m = (int)(223.0F + 223.0F * this.m.snap[1] / 100.0F); if (m > 255) m = 255;  if (m < 0) m = 0;  n = (int)(255.0F + 255.0F * this.m.snap[2] / 100.0F); if (n > 255) n = 255;  if (n < 0) n = 0;  paramGraphics2D.setColor(new Color(k, m, n)); paramGraphics2D.drawPolygon(arrayOfInt6, arrayOfInt7, this.n); this.flx = 2; }
            if (this.flx == 3) { k = 0; m = (int)(255.0F + 255.0F * this.m.snap[1] / 100.0F); if (m > 255) m = 255;  if (m < 0) m = 0;  n = (int)(223.0F + 223.0F * this.m.snap[2] / 100.0F); if (n > 255) n = 255;  if (n < 0) n = 0;  paramGraphics2D.setColor(new Color(k, m, n)); paramGraphics2D.drawPolygon(arrayOfInt6, arrayOfInt7, this.n); this.flx = 2; }
            if (this.flx == 77) { paramGraphics2D.setColor(new Color(16, 198, 255)); paramGraphics2D.drawPolygon(arrayOfInt6, arrayOfInt7, this.n); this.flx = 0; }
 
         
         }
       
       } else if (this.road && this.av <= 3000 && this.m.trk == 0 && this.m.fade[0] > 4000) {
         
         k -= 10; if (k < 0) k = 0; 
         m -= 10; if (m < 0) m = 0; 
         n -= 10; if (n < 0) n = 0; 
         paramGraphics2D.setColor(new Color(k, m, n));
         paramGraphics2D.drawPolygon(arrayOfInt6, arrayOfInt7, this.n);
       } 
 
 
       
       if (this.gr == -10)
       {
         if (this.m.trk == 0)
         
         { k = this.c[0]; m = this.c[1]; n = this.c[2];
           if (paramInt9 == -1 && this.m.cpflik) { k = (int)(k * 1.6D); if (k > 255) k = 255;  m = (int)(m * 1.6D); if (m > 255) m = 255;  n = (int)(n * 1.6D); if (n > 255) n = 255;  }
            for (byte b = 0; b < 16; ) { if (this.av > this.m.fade[b]) { k = (k * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1); m = (m * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1); n = (n * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1); }  b++; }
            paramGraphics2D.setColor(new Color(k, m, n));
           paramGraphics2D.drawPolygon(arrayOfInt6, arrayOfInt7, this.n); }
         
         else if (this.m.cpflik && this.m.hit == 5000) { m = (int)(Math.random() * 115.0D); k = m * 2 - 54; if (k < 0) k = 0;  if (k > 255) k = 255;  n = 202 + m * 2; if (n < 0) n = 0;  if (n > 255) n = 255;  m += 101; if (m < 0) m = 0;  if (m > 255) m = 255;  paramGraphics2D.setColor(new Color(k, m, n)); paramGraphics2D.drawPolygon(arrayOfInt6, arrayOfInt7, this.n); }
       
       }
       
       if (this.gr == -18 && this.m.trk == 0) {
         
         k = this.c[0]; m = this.c[1]; n = this.c[2];
         
         if (this.m.cpflik)
         {
           if (this.m.elecr >= 0.0F) {
             
             k = (int)(25.5F * this.m.elecr); if (k > 255) k = 255; 
             m = (int)(128.0F + 12.8F * this.m.elecr); if (m > 255) m = 255; 
             n = 255;
           } 
         }
         
         for (byte b = 0; b < 16; ) { if (this.av > this.m.fade[b]) { k = (k * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1); m = (m * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1); n = (n * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1); }  b++; }
          paramGraphics2D.setColor(new Color(k, m, n));
         paramGraphics2D.drawPolygon(arrayOfInt6, arrayOfInt7, this.n);
       } 
     } 
   }
 
 
 
 
 
 
   
   public void s(Graphics2D paramGraphics2D, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7) {
     int[] arrayOfInt1 = new int[this.n], arrayOfInt2 = new int[this.n], arrayOfInt3 = new int[this.n]; int i;
     for (i = 0; i < this.n; ) { arrayOfInt1[i] = this.ox[i] + paramInt1; arrayOfInt3[i] = this.oy[i] + paramInt2; arrayOfInt2[i] = this.oz[i] + paramInt3; i++; }
     
     rot(arrayOfInt1, arrayOfInt3, paramInt1, paramInt2, paramInt5, this.n);
     rot(arrayOfInt3, arrayOfInt2, paramInt2, paramInt3, paramInt6, this.n);
     rot(arrayOfInt1, arrayOfInt2, paramInt1, paramInt3, paramInt4, this.n);
     
     i = (int)(this.m.crgrnd[0] / 1.5D);
     int j = (int)(this.m.crgrnd[1] / 1.5D);
     int k = (int)(this.m.crgrnd[2] / 1.5D);
     int m;
     for (m = 0; m < this.n; ) { arrayOfInt3[m] = this.m.ground; m++; }
     
     if (paramInt7 == 0) {
       
       m = 0; int n = 0, i1 = 0, i2 = 0; int i3;
       for (i3 = 0; i3 < this.n; i3++) {
         
         byte b1 = 0, b2 = 0, b3 = 0, b4 = 0;
         for (byte b5 = 0; b5 < this.n; ) { if (arrayOfInt1[i3] >= arrayOfInt1[b5]) b1++;  if (arrayOfInt1[i3] <= arrayOfInt1[b5]) b2++;  if (arrayOfInt2[i3] >= arrayOfInt2[b5]) b3++;  if (arrayOfInt2[i3] <= arrayOfInt2[b5]) b4++;  b5++; }
          if (b1 == this.n) m = arrayOfInt1[i3];  if (b2 == this.n) n = arrayOfInt1[i3];  if (b3 == this.n) i1 = arrayOfInt2[i3];  if (b4 == this.n) i2 = arrayOfInt2[i3];
       
       } 
       i3 = (m + n) / 2;
       int i4 = (i1 + i2) / 2;
       
       int i5 = (i3 - this.t.sx + this.m.x) / 3000; if (i5 > this.t.ncx) i5 = this.t.ncx;  if (i5 < 0) i5 = 0; 
       int i6 = (i4 - this.t.sz + this.m.z) / 3000; if (i6 > this.t.ncz) i6 = this.t.ncz;  if (i6 < 0) i6 = 0;
       
       for (int i7 = (this.t.sect[i5][i6]).length - 1; i7 >= 0; i7--) {
         
         int i8 = this.t.sect[i5][i6][i7];
         
         byte b = 0;
         if (Math.abs(this.t.zy[i8]) != 90 && Math.abs(this.t.xy[i8]) != 90 && this.t.rady[i8] != 801 && Math.abs(i3 - this.t.x[i8] - this.m.x) < this.t.radx[i8] && Math.abs(i4 - this.t.z[i8] - this.m.z) < this.t.radz[i8] && (!this.t.decor[i8] || this.m.resdown != 2)) b++;
         
         if (b != 0) {
 
           
           for (byte b1 = 0; b1 < this.n; b1++) {
             
             arrayOfInt3[b1] = this.t.y[i8] - this.m.y;
             if (this.t.zy[i8] != 0) arrayOfInt3[b1] = (int)(arrayOfInt3[b1] + (arrayOfInt2[b1] - this.t.z[i8] - this.m.z - this.t.radz[i8]) * this.m.sin(this.t.zy[i8]) / this.m.sin(90 - this.t.zy[i8]) - this.t.radz[i8] * this.m.sin(this.t.zy[i8]) / this.m.sin(90 - this.t.zy[i8])); 
             if (this.t.xy[i8] != 0) arrayOfInt3[b1] = (int)(arrayOfInt3[b1] + (arrayOfInt1[b1] - this.t.x[i8] - this.m.x - this.t.radx[i8]) * this.m.sin(this.t.xy[i8]) / this.m.sin(90 - this.t.xy[i8]) - this.t.radx[i8] * this.m.sin(this.t.xy[i8]) / this.m.sin(90 - this.t.xy[i8]));
           
           } 
           i = (int)(this.t.c[i8][0] / 1.5D);
           j = (int)(this.t.c[i8][1] / 1.5D);
           k = (int)(this.t.c[i8][2] / 1.5D);
           
           break;
         } 
       } 
     } 
     
     m = 1;
     int[] arrayOfInt4 = new int[this.n];
     int[] arrayOfInt5 = new int[this.n];
     
     if (paramInt7 == 2) {
       
       i = 87;
       j = 85;
       k = 57;
     }
     else {
       
       for (byte b = 0; b < this.m.nsp; b++) {
         
         for (byte b1 = 0; b1 < this.n; b1++) {
           
           if (Math.abs(arrayOfInt1[b1] - this.m.spx[b]) < this.m.sprad[b] && Math.abs(arrayOfInt2[b1] - this.m.spz[b]) < this.m.sprad[b]) m = 0;
         
         } 
       } 
     } 
     if (m != 0) {
       
       rot(arrayOfInt1, arrayOfInt2, this.m.cx, this.m.cz, this.m.xz, this.n);
       rot(arrayOfInt3, arrayOfInt2, this.m.cy, this.m.cz, this.m.zy, this.n);
       
       byte b1 = 0, b2 = 0, b3 = 0, b4 = 0;
       
       for (byte b5 = 0; b5 < this.n; b5++) {
         
         arrayOfInt4[b5] = xs(arrayOfInt1[b5], arrayOfInt2[b5]);
         arrayOfInt5[b5] = ys(arrayOfInt3[b5], arrayOfInt2[b5]);
         if (arrayOfInt5[b5] < this.m.ih || arrayOfInt2[b5] < 10) b1++; 
         if (arrayOfInt5[b5] > this.m.h || arrayOfInt2[b5] < 10) b2++; 
         if (arrayOfInt4[b5] < this.m.iw || arrayOfInt2[b5] < 10) b3++; 
         if (arrayOfInt4[b5] > this.m.w || arrayOfInt2[b5] < 10) b4++; 
       } 
       if (b3 == this.n || b1 == this.n || b2 == this.n || b4 == this.n) m = 0;
     
     } 
 
 
 
 
 
 
 
 
 
 
 
 
 
     
     if (m != 0) {
       
       for (byte b = 0; b < 16; ) { if (this.av > this.m.fade[b]) { i = (i * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1); j = (j * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1); k = (k * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1); }  b++; }
        paramGraphics2D.setColor(new Color(i, j, k));
       paramGraphics2D.fillPolygon(arrayOfInt4, arrayOfInt5, this.n);
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
   
   public int spy(int paramInt1, int paramInt2) {
     return (int)Math.sqrt(((paramInt1 - this.m.cx) * (paramInt1 - this.m.cx) + paramInt2 * paramInt2));
   }
 }


