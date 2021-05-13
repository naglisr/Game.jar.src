 import java.awt.AlphaComposite;
 import java.awt.Color;
 import java.awt.Graphics2D;
 import java.io.ByteArrayInputStream;
 import java.io.DataInputStream;
 import java.util.Random;
 
 
 public class ContO
 {
   Medium m;
   Trackers t;
   Plane[] p;
   int npl = 0;
   
   int x = 0;
   int y = 0;
   int z = 0;
   
   int xz = 0;
   int xy = 0;
   int zy = 0;
   
   int wxz = 0;
   int wzy = 0;
   
   int dist = 0;
   
   int maxR = 0;
   int disp = 0;
   int disline = 14;
   boolean shadow = false;
   boolean noline = false;
   boolean decor = false;
   float grounded = 1.0F;
   int grat = 0;
   int[] keyx = new int[4];
   int[] keyz = new int[4];
   int sprkat = 0;
   
   int[] txy;
   int[] tzy;
   int[][] tc;
   int[] tradx;
   int[] tradz;
   int[] trady;
   int[] tx;
   int[] ty;
   int[] tz;
   int[] skd;
   int[] dam;
   boolean[] notwall;
   int tnt = 0;
   
   int[] stg;
   int[] sx;
   int[] sy;
   int[] sz;
   int[] scx;
   int[] scz;
   float[] osmag;
   int[] sav;
   float[][] smag;
   int[][] srgb;
   float[] sbln;
   int ust = 0;
   
   int srx = 0; int sry = 0; int srz = 0;
   float rcx = 0.0F; float rcy = 0.0F; float rcz = 0.0F;
   int sprk = 0;
   
   int[] rtg;
   
   boolean[] rbef;
   int[] rx;
   int[] ry;
   int[] rz;
   float[] vrx;
   float[] vry;
   float[] vrz;
   boolean elec = false;
   boolean roted = false;
   int[] edl = new int[4];
   int[] edr = new int[4];
   int[] elc = new int[] { 0, 0, 0, 0 };
   
   boolean fix = false;
   int fcnt = 0;
   int checkpoint = 0;
   
   int[] fcol = new int[] { 0, 0, 0 };
   int[] scol = new int[] { 0, 0, 0 };
   
   int colok = 0;
   boolean errd = false;
   String err = "";
   int roofat = 0, wh = 0;
 
   
   public ContO(byte[] paramArrayOfbyte, Medium paramMedium, Trackers paramTrackers) {
     this.m = paramMedium;
     this.t = paramTrackers;
     this.p = new Plane[286];
     int[] arrayOfInt1 = new int[286]; byte b1;
     for (b1 = 0; b1 < 'Ğ'; ) { arrayOfInt1[b1] = 0; b1++; }
      if (this.m.loadnew) { for (b1 = 0; b1 < 4; ) { this.keyz[b1] = 0; b1++; }  this.shadow = true; }
     
     String str = "";
     boolean bool1 = false, bool2 = false;
     byte b2 = 0;
     float f1 = 1.0F;
     float f2 = 1.0F;
     float[] arrayOfFloat = { 1.0F, 1.0F, 1.0F };
     
     int[] arrayOfInt2 = new int[100];
     int[] arrayOfInt3 = new int[100];
     int[] arrayOfInt4 = new int[100];
     int[] arrayOfInt5 = { 0, 0, 0 };
     boolean bool3 = false;
     Wheels wheels = new Wheels();
     
     boolean bool4 = false;
     
     byte b3 = 0;
     int i = 1;
     int j = 0;
     int k = 0;
     byte b4 = 0;
     byte b5 = 0;
     boolean bool5 = false;
     boolean bool6 = false;
     
     try {
       DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfbyte));
       String str1;
       while ((str1 = dataInputStream.readLine()) != null) {
         
         str = "" + str1.trim();
         
         if (this.npl < 210) {
           
           if (str.startsWith("<p>")) { bool1 = true; b2 = 0; i = 0; j = 0; b4 = 0; arrayOfInt1[this.npl] = 1; if (!bool6) bool5 = false;  }
            if (bool1) {
             
             if (str.startsWith("gr(")) i = getvalue("gr", str, 0); 
             if (str.startsWith("fs(")) { j = getvalue("fs", str, 0); arrayOfInt1[this.npl] = 2; }
              if (str.startsWith("c(")) { b5 = 0; arrayOfInt5[0] = getvalue("c", str, 0); arrayOfInt5[1] = getvalue("c", str, 1); arrayOfInt5[2] = getvalue("c", str, 2); }
             
             if (str.startsWith("glass")) b5 = 1; 
             if (str.startsWith("gshadow")) b5 = 2; 
             if (str.startsWith("lightF")) b4 = 1; 
             if (str.startsWith("light")) b4 = 1; 
             if (str.startsWith("lightB")) b4 = 2; 
             if (str.startsWith("noOutline")) bool5 = true; 
             if (str.startsWith("p(")) {
               
               arrayOfInt2[b2] = (int)(getvalue("p", str, 0) * f1 * f2 * arrayOfFloat[0]); arrayOfInt3[b2] = (int)(getvalue("p", str, 1) * f1 * arrayOfFloat[1]); arrayOfInt4[b2] = (int)(getvalue("p", str, 2) * f1 * arrayOfFloat[2]);
               int m = (int)Math.sqrt((arrayOfInt2[b2] * arrayOfInt2[b2] + arrayOfInt3[b2] * arrayOfInt3[b2] + arrayOfInt4[b2] * arrayOfInt4[b2]));
               if (m > this.maxR) this.maxR = m; 
               b2++;
             } 
           } 
           if (str.startsWith("</p>")) { this.p[this.npl] = new Plane(this.m, this.t, arrayOfInt2, arrayOfInt4, arrayOfInt3, b2, arrayOfInt5, b5, i, j, 0, 0, 0, this.disline, 0, bool3, b4, bool5); if (arrayOfInt5[0] == this.fcol[0] && arrayOfInt5[1] == this.fcol[1] && arrayOfInt5[2] == this.fcol[2] && b5 == 0) (this.p[this.npl]).colnum = 1;  if (arrayOfInt5[0] == this.scol[0] && arrayOfInt5[1] == this.scol[1] && arrayOfInt5[2] == this.scol[2] && b5 == 0) (this.p[this.npl]).colnum = 2;  this.npl++; bool1 = false; }
         
         } 
         if (str.startsWith("rims(")) wheels.setrims(getvalue("rims", str, 0), getvalue("rims", str, 1), getvalue("rims", str, 2), getvalue("rims", str, 3), getvalue("rims", str, 4)); 
         if (str.startsWith("w(") && b3 < 4) {
           
           this.keyx[b3] = (int)(getvalue("w", str, 0) * f1 * arrayOfFloat[0]);
           this.keyz[b3] = (int)(getvalue("w", str, 2) * f1 * arrayOfFloat[2]);
           wheels.make(this.m, this.t, this.p, this.npl, (int)(getvalue("w", str, 0) * f1 * f2 * arrayOfFloat[0]), (int)(getvalue("w", str, 1) * f1 * arrayOfFloat[1]), (int)(getvalue("w", str, 2) * f1 * arrayOfFloat[2]), getvalue("w", str, 3), (int)(getvalue("w", str, 4) * f1 * f2), (int)(getvalue("w", str, 5) * f1), k);
           this.npl += 19;
           if (this.m.loadnew) {
             
             this.wh += (int)(getvalue("w", str, 5) * f1);
             if (wheels.ground > 140) { String str2 = "FRONT"; if (this.keyz[b3] < 0) str2 = "BACK";  this.err = "Wheels Error:\n" + str2 + " Wheels floor is too far below the center of Y Axis of the car!    \n\nPlease decrease the Y value of the " + str2 + " Wheels or decrease its height.     \n \n"; this.errd = true; this.keyz[b3] = 0; this.keyx[b3] = 0; }
              if (wheels.ground < -100) { String str2 = "FRONT"; if (this.keyz[b3] < 0) str2 = "BACK";  this.err = "Wheels Error:\n" + str2 + " Wheels floor is too far above the center of Y Axis of the car!    \n\nPlease increase the Y value of the " + str2 + " Wheels or increase its height.     \n \n"; this.errd = true; this.keyz[b3] = 0; this.keyx[b3] = 0; }
              if (Math.abs(this.keyx[b3]) > 400) { String str2 = "FRONT"; if (this.keyz[b3] < 0) str2 = "BACK";  this.err = "Wheels Error:\n" + str2 + " Wheels are too far apart!    \n\nPlease decrease the ±X value of the " + str2 + " Wheels.     \n \n"; this.errd = true; this.keyz[b3] = 0; this.keyx[b3] = 0; }
              if (Math.abs(this.keyz[b3]) > 700) { if (this.keyz[b3] < 0) { this.err = "Wheels Error:\nBACK Wheels are too far backwards from the center of the Z Axis!    \n\nPlease increase the -Z value of the BACK Wheels.     \n \n"; } else { this.err = "Wheels Error:\nFRONT Wheels are too far forwards from the center of the Z Axis!    \n\nPlease decrease the +Z value of the FRONT Wheels.     \n \n"; }  this.errd = true; this.keyz[b3] = 0; this.keyx[b3] = 0; }
              if ((int)(getvalue("w", str, 4) * f1 * f2) > 300) { String str2 = "FRONT"; if (this.keyz[b3] < 0) str2 = "BACK";  this.err = "Wheels Error:\nWidth of the " + str2 + " Wheels is too large!    \n\nPlease decrease the width of the " + str2 + " Wheels.     \n \n"; this.errd = true; this.keyz[b3] = 0; this.keyx[b3] = 0; }
           
           }  b3++;
         } 
         
         if (str.startsWith("tracks")) {
           
           int m = getvalue("tracks", str, 0);
           this.txy = new int[m];
           this.tzy = new int[m];
           this.tc = new int[m][3];
           this.tradx = new int[m];
           this.tradz = new int[m];
           this.trady = new int[m];
           this.tx = new int[m];
           this.ty = new int[m];
           this.tz = new int[m];
           this.skd = new int[m];
           this.dam = new int[m];
           this.notwall = new boolean[m];
           bool4 = true;
         } 
         
         if (bool4) {
           
           if (str.startsWith("<track>")) { bool2 = true; this.notwall[this.tnt] = false; this.dam[this.tnt] = 1; this.skd[this.tnt] = 0; this.ty[this.tnt] = 0; this.tx[this.tnt] = 0; this.tz[this.tnt] = 0; this.txy[this.tnt] = 0; this.tzy[this.tnt] = 0; this.trady[this.tnt] = 0; this.tradx[this.tnt] = 0; this.tradz[this.tnt] = 0; this.tc[this.tnt][0] = 0; this.tc[this.tnt][1] = 0; this.tc[this.tnt][2] = 0; }
            if (bool2) {
             
             if (str.startsWith("c")) { this.tc[this.tnt][0] = getvalue("c", str, 0); this.tc[this.tnt][1] = getvalue("c", str, 1); this.tc[this.tnt][2] = getvalue("c", str, 2); }
              if (str.startsWith("xy")) this.txy[this.tnt] = getvalue("xy", str, 0); 
             if (str.startsWith("zy")) this.tzy[this.tnt] = getvalue("zy", str, 0); 
             if (str.startsWith("radx")) this.tradx[this.tnt] = (int)(getvalue("radx", str, 0) * f1); 
             if (str.startsWith("rady")) this.trady[this.tnt] = (int)(getvalue("rady", str, 0) * f1); 
             if (str.startsWith("radz")) this.tradz[this.tnt] = (int)(getvalue("radz", str, 0) * f1); 
             if (str.startsWith("ty")) this.ty[this.tnt] = (int)(getvalue("ty", str, 0) * f1); 
             if (str.startsWith("tx")) this.tx[this.tnt] = (int)(getvalue("tx", str, 0) * f1); 
             if (str.startsWith("tz")) this.tz[this.tnt] = (int)(getvalue("tz", str, 0) * f1); 
             if (str.startsWith("skid")) this.skd[this.tnt] = getvalue("skid", str, 0); 
             if (str.startsWith("dam")) this.dam[this.tnt] = 3; 
             if (str.startsWith("notwall")) this.notwall[this.tnt] = true; 
           } 
           if (str.startsWith("</track>")) { bool2 = false; this.tnt++; }
         
         } 
         if (str.startsWith("disp(")) this.disp = getvalue("disp", str, 0); 
         if (str.startsWith("disline(")) this.disline = getvalue("disline", str, 0) * 2; 
         if (str.startsWith("shadow")) this.shadow = true; 
         if (str.startsWith("stonecold")) this.noline = true; 
         if (str.startsWith("newstone")) { this.noline = true; bool5 = true; bool6 = true; }
          if (str.startsWith("decorative")) this.decor = true; 
         if (str.startsWith("road")) bool3 = true; 
         if (str.startsWith("notroad")) bool3 = false; 
         if (str.startsWith("grounded(")) this.grounded = getvalue("grounded", str, 0) / 100.0F; 
         if (str.startsWith("div(")) f1 = getvalue("div", str, 0) / 10.0F; 
         if (str.startsWith("idiv(")) f1 = getvalue("idiv", str, 0) / 100.0F; 
         if (str.startsWith("iwid(")) f2 = getvalue("iwid", str, 0) / 100.0F; 
         if (str.startsWith("ScaleX(")) arrayOfFloat[0] = getvalue("ScaleX", str, 0) / 100.0F; 
         if (str.startsWith("ScaleY(")) arrayOfFloat[1] = getvalue("ScaleY", str, 0) / 100.0F; 
         if (str.startsWith("ScaleZ(")) arrayOfFloat[2] = getvalue("ScaleZ", str, 0) / 100.0F; 
         if (str.startsWith("gwgr(")) { k = getvalue("gwgr", str, 0); if (this.m.loadnew) { if (k > 40) k = 40;  if (k < 0 && k >= -15) k = -16;  if (k < -40) k = -40;  }
            }
          if (str.startsWith("1stColor(")) { this.fcol[0] = getvalue("1stColor", str, 0); this.fcol[1] = getvalue("1stColor", str, 1); this.fcol[2] = getvalue("1stColor", str, 2); this.colok++; }
          if (str.startsWith("2ndColor(")) { this.scol[0] = getvalue("2ndColor", str, 0); this.scol[1] = getvalue("2ndColor", str, 1); this.scol[2] = getvalue("2ndColor", str, 2); this.colok++; }
       
       } 
       dataInputStream.close();
     } catch (Exception exception) {
       if (!this.errd) { this.err = "Error While Loading 3D Model\n\nLine:     " + str + "\n\nError Detail:\n" + exception + "           \n \n"; System.out.println(this.err); this.errd = true; } 
     }  this.grat = wheels.ground;
     this.sprkat = wheels.sparkat;
     
     if (this.shadow) { byte b; for (this.stg = new int[20], this.rtg = new int[100], b = 0; b < 20; ) { this.stg[b] = 0; b++; }  for (b = 0; b < 100; ) { this.rtg[b] = 0; b++; }
        }
 
 
     
     if (this.m.loadnew) {
       
       if (b3 != 0) this.wh /= b3; 
       boolean bool = false;
       
       for (byte b = 0; b < this.npl; b++) {
 
 
         
         byte b6 = 0; int m = (this.p[b]).ox[0], n = (this.p[b]).ox[0], i1 = (this.p[b]).oy[0], i2 = (this.p[b]).oy[0], i3 = (this.p[b]).oz[0], i4 = (this.p[b]).oz[0]; int i5;
         for (i5 = 0; i5 < (this.p[b]).n; i5++) {
           
           if ((this.p[b]).ox[i5] > m) m = (this.p[b]).ox[i5]; 
           if ((this.p[b]).ox[i5] < n) n = (this.p[b]).ox[i5]; 
           if ((this.p[b]).oy[i5] > i1) i1 = (this.p[b]).oy[i5]; 
           if ((this.p[b]).oy[i5] < i2) i2 = (this.p[b]).oy[i5]; 
           if ((this.p[b]).oz[i5] > i3) i3 = (this.p[b]).oz[i5]; 
           if ((this.p[b]).oz[i5] < i4) i4 = (this.p[b]).oz[i5]; 
         } 
         if (Math.abs(m - n) <= Math.abs(i1 - i2) && Math.abs(m - n) <= Math.abs(i3 - i4)) b6 = 1; 
         if (Math.abs(i1 - i2) <= Math.abs(m - n) && Math.abs(i1 - i2) <= Math.abs(i3 - i4)) b6 = 2; 
         if (Math.abs(i3 - i4) <= Math.abs(m - n) && Math.abs(i3 - i4) <= Math.abs(i1 - i2)) b6 = 3;
         
         if (b6 == 2)
         {
           if (!bool || (i1 + i2) / 2 < this.roofat) { this.roofat = (i1 + i2) / 2; bool = true; }
         
         }
         if (arrayOfInt1[b] == 1) {
 
 
           
           i5 = 1000;
           byte b7 = 0; byte b8;
           for (b8 = 0; b8 < (this.p[b]).n; b8++) {
             
             int i6 = b8 + 1; if (i6 >= (this.p[b]).n) i6 -= (this.p[b]).n; 
             int i7 = b8 + 2; if (i7 >= (this.p[b]).n) i7 -= (this.p[b]).n; 
             if (b6 == 1) {
               
               int i8 = Math.abs((int)(Math.atan(((this.p[b]).oz[b8] - (this.p[b]).oz[i6]) / ((this.p[b]).oy[b8] - (this.p[b]).oy[i6])) / 0.017453292519943295D));
               int i9 = Math.abs((int)(Math.atan(((this.p[b]).oz[i7] - (this.p[b]).oz[i6]) / ((this.p[b]).oy[i7] - (this.p[b]).oy[i6])) / 0.017453292519943295D));
               if (i8 > 45) { i8 = 90 - i8; } else { i9 = 90 - i9; }
                if (i8 + i9 < i5) { i5 = i8 + i9; b7 = b8; }
             
             }  if (b6 == 2) {
               
               int i8 = Math.abs((int)(Math.atan(((this.p[b]).oz[b8] - (this.p[b]).oz[i6]) / ((this.p[b]).ox[b8] - (this.p[b]).ox[i6])) / 0.017453292519943295D));
               int i9 = Math.abs((int)(Math.atan(((this.p[b]).oz[i7] - (this.p[b]).oz[i6]) / ((this.p[b]).ox[i7] - (this.p[b]).ox[i6])) / 0.017453292519943295D));
               if (i8 > 45) { i8 = 90 - i8; } else { i9 = 90 - i9; }
                if (i8 + i9 < i5) { i5 = i8 + i9; b7 = b8; }
             
             }  if (b6 == 3) {
               
               int i8 = Math.abs((int)(Math.atan(((this.p[b]).oy[b8] - (this.p[b]).oy[i6]) / ((this.p[b]).ox[b8] - (this.p[b]).ox[i6])) / 0.017453292519943295D));
               int i9 = Math.abs((int)(Math.atan(((this.p[b]).oy[i7] - (this.p[b]).oy[i6]) / ((this.p[b]).ox[i7] - (this.p[b]).ox[i6])) / 0.017453292519943295D));
               if (i8 > 45) { i8 = 90 - i8; } else { i9 = 90 - i9; }
                if (i8 + i9 < i5) { i5 = i8 + i9; b7 = b8; }
             
             } 
           } 
           
           if (b7 != 0) {
             
             int[] arrayOfInt6 = new int[(this.p[b]).n];
             int[] arrayOfInt7 = new int[(this.p[b]).n];
             int[] arrayOfInt8 = new int[(this.p[b]).n]; byte b10;
             for (b10 = 0; b10 < (this.p[b]).n; ) { arrayOfInt6[b10] = (this.p[b]).ox[b10]; arrayOfInt7[b10] = (this.p[b]).oy[b10]; arrayOfInt8[b10] = (this.p[b]).oz[b10]; b10++; }
              for (b10 = 0; b10 < (this.p[b]).n; b10++) {
               
               int i6 = b10 + b7; if (i6 >= (this.p[b]).n) i6 -= (this.p[b]).n; 
               (this.p[b]).ox[b10] = arrayOfInt6[i6];
               (this.p[b]).oy[b10] = arrayOfInt7[i6];
               (this.p[b]).oz[b10] = arrayOfInt8[i6];
             } 
           } 
 
           
           if (b6 == 1)
           {
             if (Math.abs((this.p[b]).oz[0] - (this.p[b]).oz[1]) > Math.abs((this.p[b]).oy[0] - (this.p[b]).oy[1]))
             
             { if ((this.p[b]).oz[0] > (this.p[b]).oz[1]) { if ((this.p[b]).oy[1] > (this.p[b]).oy[2]) { (this.p[b]).fs = 1; } else { (this.p[b]).fs = -1; }  } else if ((this.p[b]).oy[1] > (this.p[b]).oy[2]) { (this.p[b]).fs = -1; } else { (this.p[b]).fs = 1; }
               
                }
             
             else if ((this.p[b]).oy[0] > (this.p[b]).oy[1]) { if ((this.p[b]).oz[1] > (this.p[b]).oz[2]) { (this.p[b]).fs = -1; } else { (this.p[b]).fs = 1; }  } else if ((this.p[b]).oz[1] > (this.p[b]).oz[2]) { (this.p[b]).fs = 1; } else { (this.p[b]).fs = -1; }
           
           }
           if (b6 == 2)
           {
             if (Math.abs((this.p[b]).oz[0] - (this.p[b]).oz[1]) > Math.abs((this.p[b]).ox[0] - (this.p[b]).ox[1]))
             
             { if ((this.p[b]).oz[0] > (this.p[b]).oz[1]) { if ((this.p[b]).ox[1] > (this.p[b]).ox[2]) { (this.p[b]).fs = -1; } else { (this.p[b]).fs = 1; }  } else if ((this.p[b]).ox[1] > (this.p[b]).ox[2]) { (this.p[b]).fs = 1; } else { (this.p[b]).fs = -1; }
               
                }
             
             else if ((this.p[b]).ox[0] > (this.p[b]).ox[1]) { if ((this.p[b]).oz[1] > (this.p[b]).oz[2]) { (this.p[b]).fs = 1; } else { (this.p[b]).fs = -1; }  } else if ((this.p[b]).oz[1] > (this.p[b]).oz[2]) { (this.p[b]).fs = -1; } else { (this.p[b]).fs = 1; }
           
           }
           if (b6 == 3)
           {
             if (Math.abs((this.p[b]).oy[0] - (this.p[b]).oy[1]) > Math.abs((this.p[b]).ox[0] - (this.p[b]).ox[1]))
             
             { if ((this.p[b]).oy[0] > (this.p[b]).oy[1]) { if ((this.p[b]).ox[1] > (this.p[b]).ox[2]) { (this.p[b]).fs = 1; } else { (this.p[b]).fs = -1; }  } else if ((this.p[b]).ox[1] > (this.p[b]).ox[2]) { (this.p[b]).fs = -1; } else { (this.p[b]).fs = 1; }
               
                }
             
             else if ((this.p[b]).ox[0] > (this.p[b]).ox[1]) { if ((this.p[b]).oy[1] > (this.p[b]).oy[2]) { (this.p[b]).fs = -1; } else { (this.p[b]).fs = 1; }  } else if ((this.p[b]).oy[1] > (this.p[b]).oy[2]) { (this.p[b]).fs = 1; } else { (this.p[b]).fs = -1; }
           
           }
 
 
           
           b8 = 0;
           boolean bool7 = false; byte b9;
           for (b9 = 0; b9 < this.npl; b9++) {
             
             if (b9 != b && arrayOfInt1[b9] != 0) {
               
               boolean bool8 = false; int i6 = (this.p[b9]).ox[0], i7 = (this.p[b9]).ox[0], i8 = (this.p[b9]).oy[0], i9 = (this.p[b9]).oy[0], i10 = (this.p[b9]).oz[0], i11 = (this.p[b9]).oz[0]; int i12;
               for (i12 = 0; i12 < (this.p[b9]).n; i12++) {
                 
                 if ((this.p[b9]).ox[i12] > i6) i6 = (this.p[b9]).ox[i12]; 
                 if ((this.p[b9]).ox[i12] < i7) i7 = (this.p[b9]).ox[i12]; 
                 if ((this.p[b9]).oy[i12] > i8) i8 = (this.p[b9]).oy[i12]; 
                 if ((this.p[b9]).oy[i12] < i9) i9 = (this.p[b9]).oy[i12]; 
                 if ((this.p[b9]).oz[i12] > i10) i10 = (this.p[b9]).oz[i12]; 
                 if ((this.p[b9]).oz[i12] < i11) i11 = (this.p[b9]).oz[i12]; 
               } 
               i12 = (i6 + i7) / 2;
               int i13 = (i8 + i9) / 2;
               int i14 = (i10 + i11) / 2;
               int i15 = (m + n) / 2;
               int i16 = (i1 + i2) / 2;
               int i17 = (i3 + i4) / 2;
               if (b6 == 1)
               {
                 if ((i13 <= i1 && i13 >= i2 && i14 <= i3 && i14 >= i4) || (i16 <= i8 && i16 >= i9 && i17 <= i10 && i17 >= i11)) {
                   
                   if (i6 < n) b8 = 1; 
                   if (i7 > m) bool7 = true; 
                 } 
               }
               if (b6 == 2)
               {
                 if ((i12 <= m && i12 >= n && i14 <= i3 && i14 >= i4) || (i15 <= i6 && i15 >= i7 && i17 <= i10 && i17 >= i11)) {
                   
                   if (i8 < i2) b8 = 1; 
                   if (i9 > i1) bool7 = true; 
                 } 
               }
               if (b6 == 3)
               {
                 if ((i12 <= m && i12 >= n && i13 <= i1 && i13 >= i2) || (i15 <= i6 && i15 >= i7 && i16 <= i8 && i16 >= i9)) {
                   
                   if (i10 < i4) b8 = 1; 
                   if (i11 > i3) bool7 = true; 
                 } 
               }
             } 
             if (b8 != 0 && bool7)
               break; 
           } 
           b9 = 0;
           if (b8 != 0 && !bool7) b9 = 1; 
           if (bool7 && b8 == 0) { (this.p[b]).fs *= -1; b9 = 1; }
            if (b8 != 0 && bool7) { (this.p[b]).fs = 0; (this.p[b]).gr = 40; b9 = 1; }
 
 
           
           if (b9 == 0) {
             
             int i6 = 0, i7 = 0;
             if (b6 == 1) i7 = i6 = (m + n) / 2; 
             if (b6 == 2) i7 = i6 = (i1 + i2) / 2; 
             if (b6 == 3) i7 = i6 = (i3 + i4) / 2; 
             for (byte b10 = 0; b10 < this.npl; b10++) {
               
               if (b10 != b) {
                 
                 boolean bool8 = false;
                 boolean[] arrayOfBoolean = new boolean[(this.p[b10]).n]; byte b11;
                 for (b11 = 0; b11 < (this.p[b10]).n; ) { byte b12; for (arrayOfBoolean[b11] = false, b12 = 0; b12 < (this.p[b]).n; ) { if ((this.p[b]).ox[b12] == (this.p[b10]).ox[b11] && (this.p[b]).oy[b12] == (this.p[b10]).oy[b11] && (this.p[b]).oz[b12] == (this.p[b10]).oz[b11]) { arrayOfBoolean[b11] = true; bool8 = true; }  b12++; }  b11++; }
                  if (bool8)
                 {
                   for (b11 = 0; b11 < (this.p[b10]).n; b11++) {
                     
                     if (!arrayOfBoolean[b11]) {
                       
                       if (b6 == 1) { if ((this.p[b10]).ox[b11] > i6) i6 = (this.p[b10]).ox[b11];  if ((this.p[b10]).ox[b11] < i7) i7 = (this.p[b10]).ox[b11];  }
                        if (b6 == 2) { if ((this.p[b10]).oy[b11] > i6) i6 = (this.p[b10]).oy[b11];  if ((this.p[b10]).oy[b11] < i7) i7 = (this.p[b10]).oy[b11];  }
                        if (b6 == 3) { if ((this.p[b10]).oz[b11] > i6) i6 = (this.p[b10]).oz[b11];  if ((this.p[b10]).oz[b11] < i7) i7 = (this.p[b10]).oz[b11];  }
                     
                     } 
                   }  } 
               } 
             } 
             if (b6 == 1) if ((i6 + i7) / 2 > (m + n) / 2) { (this.p[b]).fs *= -1; } else if ((i6 + i7) / 2 == (m + n) / 2 && (m + n) / 2 < 0) { (this.p[b]).fs *= -1; }
                 if (b6 == 2) if ((i6 + i7) / 2 > (i1 + i2) / 2) { (this.p[b]).fs *= -1; } else if ((i6 + i7) / 2 == (i1 + i2) / 2 && (i1 + i2) / 2 < 0) { (this.p[b]).fs *= -1; }
                 if (b6 == 3) if ((i6 + i7) / 2 > (i3 + i4) / 2) { (this.p[b]).fs *= -1; } else if ((i6 + i7) / 2 == (i3 + i4) / 2 && (i3 + i4) / 2 < 0) { (this.p[b]).fs *= -1; }
                
           } 
           this.p[b].deltafntyp();
         } 
       } 
     } 
   }
 
 
 
 
 
 
   
   public ContO(ContO paramContO, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
     this.m = paramContO.m;
     this.t = paramContO.t;
     this.npl = paramContO.npl;
     this.maxR = paramContO.maxR;
     this.disp = paramContO.disp;
     this.disline = paramContO.disline;
     this.noline = paramContO.noline;
     this.shadow = paramContO.shadow;
     this.grounded = paramContO.grounded;
     this.decor = paramContO.decor;
     if (this.m.loadnew && (paramInt4 == 90 || paramInt4 == -90)) this.grounded += 10000.0F; 
     this.grat = paramContO.grat;
     this.sprkat = paramContO.sprkat;
     this.p = new Plane[paramContO.npl]; byte b;
     for (b = 0; b < this.npl; b++) {
       
       if ((paramContO.p[b]).master == 1) (paramContO.p[b]).n = 20; 
       this.p[b] = new Plane(this.m, this.t, (paramContO.p[b]).ox, (paramContO.p[b]).oz, (paramContO.p[b]).oy, (paramContO.p[b]).n, (paramContO.p[b]).oc, (paramContO.p[b]).glass, (paramContO.p[b]).gr, (paramContO.p[b]).fs, (paramContO.p[b]).wx, (paramContO.p[b]).wy, (paramContO.p[b]).wz, paramContO.disline, (paramContO.p[b]).bfase, (paramContO.p[b]).road, (paramContO.p[b]).light, (paramContO.p[b]).solo);
     } 
     
     this.x = paramInt1; this.y = paramInt2; this.z = paramInt3;
     this.xz = 0; this.xy = 0; this.zy = 0;
     
     for (b = 0; b < this.npl; ) { (this.p[b]).colnum = (paramContO.p[b]).colnum; (this.p[b]).master = (paramContO.p[b]).master; this.p[b].rot((this.p[b]).ox, (this.p[b]).oz, 0, 0, paramInt4, (this.p[b]).n); this.p[b].loadprojf(); b++; }
     
     if (paramContO.tnt != 0)
     {
       for (b = 0; b < paramContO.tnt; b++) {
         
         this.t.xy[this.t.nt] = (int)(paramContO.txy[b] * this.m.cos(paramInt4) - paramContO.tzy[b] * this.m.sin(paramInt4));
         this.t.zy[this.t.nt] = (int)(paramContO.tzy[b] * this.m.cos(paramInt4) + paramContO.txy[b] * this.m.sin(paramInt4)); int i;
         for (i = 0; i < 3; ) { this.t.c[this.t.nt][i] = (int)(paramContO.tc[b][i] + paramContO.tc[b][i] * this.m.snap[i] / 100.0F); if (this.t.c[this.t.nt][i] > 255) this.t.c[this.t.nt][i] = 255;  if (this.t.c[this.t.nt][i] < 0) this.t.c[this.t.nt][i] = 0;  i++; }
         
         this.t.x[this.t.nt] = (int)(this.x + paramContO.tx[b] * this.m.cos(paramInt4) - paramContO.tz[b] * this.m.sin(paramInt4));
         this.t.z[this.t.nt] = (int)(this.z + paramContO.tz[b] * this.m.cos(paramInt4) + paramContO.tx[b] * this.m.sin(paramInt4));
         this.t.y[this.t.nt] = this.y + paramContO.ty[b];
         this.t.skd[this.t.nt] = paramContO.skd[b];
         this.t.dam[this.t.nt] = paramContO.dam[b];
         this.t.notwall[this.t.nt] = paramContO.notwall[b];
         if (this.decor) { this.t.decor[this.t.nt] = true; } else { this.t.decor[this.t.nt] = false; }
         
         i = Math.abs(paramInt4);
         if (i == 180) i = 0; 
         this.t.radx[this.t.nt] = (int)Math.abs(paramContO.tradx[b] * this.m.cos(i) + paramContO.tradz[b] * this.m.sin(i));
         this.t.radz[this.t.nt] = (int)Math.abs(paramContO.tradx[b] * this.m.sin(i) + paramContO.tradz[b] * this.m.cos(i));
         this.t.rady[this.t.nt] = paramContO.trady[b];
         this.t.nt++;
       } 
     }
     
     for (b = 0; b < 4; ) { this.keyx[b] = paramContO.keyx[b]; this.keyz[b] = paramContO.keyz[b]; b++; }
      if (this.shadow) {
       
       this.stg = new int[20]; this.sx = new int[20]; this.sy = new int[20]; this.sz = new int[20]; this.scx = new int[20]; this.scz = new int[20]; this.osmag = new float[20]; this.sav = new int[20]; this.smag = new float[20][8]; this.srgb = new int[20][3]; this.sbln = new float[20]; this.ust = 0;
       for (b = 0; b < 20; ) { this.stg[b] = 0; b++; }
        this.rtg = new int[100]; this.rbef = new boolean[100]; this.rx = new int[100]; this.ry = new int[100]; this.rz = new int[100]; this.vrx = new float[100]; this.vry = new float[100]; this.vrz = new float[100];
       for (b = 0; b < 100; ) { this.rtg[b] = 0; b++; }
     
     } 
   }
 
 
   
   public ContO(int paramInt1, int paramInt2, int paramInt3, Medium paramMedium, Trackers paramTrackers, int paramInt4, int paramInt5, int paramInt6) {
     this.m = paramMedium;
     this.t = paramTrackers;
     this.x = paramInt4; this.z = paramInt5; this.y = paramInt6;
     this.xz = 0; this.xy = 0; this.zy = 0; this.grat = 0; this.sprkat = 0;
     this.disline = 4;
     this.noline = true;
     this.shadow = false;
     this.grounded = 115.0F;
     this.decor = true;
     this.npl = 5;
     this.p = new Plane[5];
     
     Random random = new Random(paramInt1);
     
     int[] arrayOfInt1 = new int[8];
     int[] arrayOfInt2 = new int[8];
     int[] arrayOfInt3 = new int[8];
     int[] arrayOfInt4 = new int[8];
     int[] arrayOfInt5 = new int[8];
     
     float f1 = paramInt2;
     float f2 = paramInt3;
     if (f2 < 2.0F) f2 = 2.0F;  if (f2 > 6.0F) f2 = 6.0F; 
     if (f1 < 2.0F) f1 = 2.0F;  if (f1 > 6.0F) f1 = 6.0F; 
     f1 /= 1.5F; f2 /= 1.5F;
     f2 *= 1.0F + (f1 - 2.0F) * 0.1786F;
     
     float f3 = (float)(50.0D + 100.0D * random.nextDouble()); arrayOfInt1[0] = -((int)(f3 * f1 * 0.7071F)); arrayOfInt2[0] = (int)(f3 * f1 * 0.7071F);
     f3 = (float)(50.0D + 100.0D * random.nextDouble()); arrayOfInt1[1] = 0; arrayOfInt2[1] = (int)(f3 * f1);
     f3 = (float)(50.0D + 100.0D * random.nextDouble()); arrayOfInt1[2] = (int)((f3 * f1) * 0.7071D); arrayOfInt2[2] = (int)((f3 * f1) * 0.7071D);
     f3 = (float)(50.0D + 100.0D * random.nextDouble()); arrayOfInt1[3] = (int)(f3 * f1); arrayOfInt2[3] = 0;
     f3 = (float)(50.0D + 100.0D * random.nextDouble()); arrayOfInt1[4] = (int)((f3 * f1) * 0.7071D); arrayOfInt2[4] = -((int)((f3 * f1) * 0.7071D));
     f3 = (float)(50.0D + 100.0D * random.nextDouble()); arrayOfInt1[5] = 0; arrayOfInt2[5] = -((int)(f3 * f1));
     f3 = (float)(50.0D + 100.0D * random.nextDouble()); arrayOfInt1[6] = -((int)((f3 * f1) * 0.7071D)); arrayOfInt2[6] = -((int)((f3 * f1) * 0.7071D));
     f3 = (float)(50.0D + 100.0D * random.nextDouble()); arrayOfInt1[7] = -((int)(f3 * f1)); arrayOfInt2[7] = 0;
     byte b1;
     for (b1 = 0; b1 < 8; b1++) {
       
       arrayOfInt3[b1] = (int)(arrayOfInt1[b1] * (0.2D + 0.4D * random.nextDouble()));
       arrayOfInt4[b1] = (int)(arrayOfInt2[b1] * (0.2D + 0.4D * random.nextDouble()));
       arrayOfInt5[b1] = -((int)((10.0D + 15.0D * random.nextDouble()) * f2));
     } 
     
     this.maxR = 0;
     for (b1 = 0; b1 < 8; b1++) {
       
       int i = b1 - 1; if (i == -1) i = 7; 
       int j = b1 + 1; if (j == 8) j = 0; 
       arrayOfInt1[b1] = ((arrayOfInt1[i] + arrayOfInt1[j]) / 2 + arrayOfInt1[b1]) / 2;
       arrayOfInt2[b1] = ((arrayOfInt2[i] + arrayOfInt2[j]) / 2 + arrayOfInt2[b1]) / 2;
       arrayOfInt3[b1] = ((arrayOfInt3[i] + arrayOfInt3[j]) / 2 + arrayOfInt3[b1]) / 2;
       arrayOfInt4[b1] = ((arrayOfInt4[i] + arrayOfInt4[j]) / 2 + arrayOfInt4[b1]) / 2;
       arrayOfInt5[b1] = ((arrayOfInt5[i] + arrayOfInt5[j]) / 2 + arrayOfInt5[b1]) / 2;
       int k = (int)Math.sqrt((arrayOfInt1[b1] * arrayOfInt1[b1] + arrayOfInt2[b1] * arrayOfInt2[b1])); if (k > this.maxR) this.maxR = k; 
       k = (int)Math.sqrt((arrayOfInt3[b1] * arrayOfInt3[b1] + arrayOfInt5[b1] * arrayOfInt5[b1] + arrayOfInt4[b1] * arrayOfInt4[b1])); if (k > this.maxR) this.maxR = k; 
     } 
     this.disp = this.maxR / 17;
     
     int[] arrayOfInt6 = new int[3];
     float f4 = -1.0F;
     float f5 = (f1 / f2 - 0.33F) / 33.4F;
     if (f5 < 0.005D) f5 = 0.0F; 
     if (f5 > 0.057D) f5 = 0.057F;  byte b2;
     for (b2 = 0; b2 < 4; b2++) {
       
       int i = b2 * 2, j = i + 2; if (j == 8) j = 0; 
       int[] arrayOfInt9 = new int[6], arrayOfInt10 = new int[6], arrayOfInt11 = new int[6];
       arrayOfInt9[0] = arrayOfInt1[i]; arrayOfInt9[1] = arrayOfInt1[i + 1]; arrayOfInt9[2] = arrayOfInt1[j]; arrayOfInt9[5] = arrayOfInt3[i]; arrayOfInt9[4] = arrayOfInt3[i + 1]; arrayOfInt9[3] = arrayOfInt3[j];
       arrayOfInt11[0] = arrayOfInt2[i]; arrayOfInt11[1] = arrayOfInt2[i + 1]; arrayOfInt11[2] = arrayOfInt2[j]; arrayOfInt11[5] = arrayOfInt4[i]; arrayOfInt11[4] = arrayOfInt4[i + 1]; arrayOfInt11[3] = arrayOfInt4[j];
       arrayOfInt10[0] = 0; arrayOfInt10[1] = 0; arrayOfInt10[2] = 0; arrayOfInt10[5] = arrayOfInt5[i]; arrayOfInt10[4] = arrayOfInt5[i + 1]; arrayOfInt10[3] = arrayOfInt5[j];
       f3 = (float)((0.17D - f5) * random.nextDouble());
       for (; Math.abs(f4 - f3) < 0.03D - (f5 * 0.176F); f3 = (float)((0.17D - f5) * random.nextDouble())); f4 = f3;
       for (byte b = 0; b < 3; ) { if (this.m.trk == 2) { arrayOfInt6[b] = (int)(390.0F / (2.2F + f3 - f5)); } else { arrayOfInt6[b] = (int)((this.m.cpol[b] + this.m.cgrnd[b]) / (2.2F + f3 - f5)); }  b++; }
        this.p[b2] = new Plane(this.m, this.t, arrayOfInt9, arrayOfInt11, arrayOfInt10, 6, arrayOfInt6, 3, -8, 0, 0, 0, 0, this.disline, 0, true, 0, false);
     } 
     f3 = (float)(0.02D * random.nextDouble());
     for (b2 = 0; b2 < 3; ) { if (this.m.trk == 2) { arrayOfInt6[b2] = (int)(390.0F / (2.15F + f3)); } else { arrayOfInt6[b2] = (int)((this.m.cpol[b2] + this.m.cgrnd[b2]) / (2.15F + f3)); }  b2++; }
      this.p[4] = new Plane(this.m, this.t, arrayOfInt3, arrayOfInt4, arrayOfInt5, 8, arrayOfInt6, 3, -8, 0, 0, 0, 0, this.disline, 0, true, 0, false);
 
     
     int[] arrayOfInt7 = new int[2];
     int[] arrayOfInt8 = new int[2];
     byte b3;
     for (b3 = 0; b3 < 4; b3++) {
       
       int i = b3 * 2 + 1;
       this.t.y[this.t.nt] = arrayOfInt5[i] / 2;
       this.t.rady[this.t.nt] = Math.abs(arrayOfInt5[i] / 2);
       if (b3 == 0 || b3 == 2) {
         
         this.t.z[this.t.nt] = (arrayOfInt2[i] + arrayOfInt4[i]) / 2;
         this.t.radz[this.t.nt] = Math.abs(this.t.z[this.t.nt] - arrayOfInt2[i]);
         i = b3 * 2 + 2; if (i == 8) i = 0; 
         this.t.x[this.t.nt] = (arrayOfInt1[b3 * 2] + arrayOfInt1[i]) / 2;
         this.t.radx[this.t.nt] = Math.abs(this.t.x[this.t.nt] - arrayOfInt1[b3 * 2]);
       }
       else {
         
         this.t.x[this.t.nt] = (arrayOfInt1[i] + arrayOfInt3[i]) / 2;
         this.t.radx[this.t.nt] = Math.abs(this.t.x[this.t.nt] - arrayOfInt1[i]);
         i = b3 * 2 + 2; if (i == 8) i = 0; 
         this.t.z[this.t.nt] = (arrayOfInt2[b3 * 2] + arrayOfInt2[i]) / 2;
         this.t.radz[this.t.nt] = Math.abs(this.t.z[this.t.nt] - arrayOfInt2[b3 * 2]);
       } 
       if (b3 == 0) { arrayOfInt8[0] = this.t.z[this.t.nt] - this.t.radz[this.t.nt]; this.t.zy[this.t.nt] = (int)(Math.atan(this.t.rady[this.t.nt] / this.t.radz[this.t.nt]) / 0.017453292519943295D); if (this.t.zy[this.t.nt] > 40) this.t.zy[this.t.nt] = 40;  this.t.xy[this.t.nt] = 0; }
        if (b3 == 1) { arrayOfInt7[0] = this.t.x[this.t.nt] - this.t.radx[this.t.nt]; this.t.xy[this.t.nt] = (int)(Math.atan(this.t.rady[this.t.nt] / this.t.radx[this.t.nt]) / 0.017453292519943295D); if (this.t.xy[this.t.nt] > 40) this.t.xy[this.t.nt] = 40;  this.t.zy[this.t.nt] = 0; }
        if (b3 == 2) { arrayOfInt8[1] = this.t.z[this.t.nt] + this.t.radz[this.t.nt]; this.t.zy[this.t.nt] = -((int)(Math.atan(this.t.rady[this.t.nt] / this.t.radz[this.t.nt]) / 0.017453292519943295D)); if (this.t.zy[this.t.nt] < -40) this.t.zy[this.t.nt] = -40;  this.t.xy[this.t.nt] = 0; }
        if (b3 == 3) { arrayOfInt7[1] = this.t.x[this.t.nt] + this.t.radx[this.t.nt]; this.t.xy[this.t.nt] = -((int)(Math.atan(this.t.rady[this.t.nt] / this.t.radx[this.t.nt]) / 0.017453292519943295D)); if (this.t.xy[this.t.nt] < -40) this.t.xy[this.t.nt] = -40;  this.t.zy[this.t.nt] = 0; }
        this.t.x[this.t.nt] = this.t.x[this.t.nt] + this.x;
       this.t.z[this.t.nt] = this.t.z[this.t.nt] + this.z;
       this.t.y[this.t.nt] = this.t.y[this.t.nt] + this.y;
       for (byte b = 0; b < 3; ) { this.t.c[this.t.nt][b] = (this.p[b3]).oc[b]; b++; }
        this.t.skd[this.t.nt] = 2;
       this.t.dam[this.t.nt] = 1;
       this.t.notwall[this.t.nt] = false;
       this.t.decor[this.t.nt] = true;
       this.t.rady[this.t.nt] = this.t.rady[this.t.nt] + 10;
       this.t.nt++;
     } 
 
     
     this.t.y[this.t.nt] = 0;
     for (b3 = 0; b3 < 8; ) { this.t.y[this.t.nt] = this.t.y[this.t.nt] + arrayOfInt5[b3]; b3++; }
      this.t.y[this.t.nt] = this.t.y[this.t.nt] / 8;
     this.t.y[this.t.nt] = this.t.y[this.t.nt] + this.y;
     this.t.rady[this.t.nt] = 200;
     this.t.radx[this.t.nt] = arrayOfInt7[0] - arrayOfInt7[1];
     this.t.radz[this.t.nt] = arrayOfInt8[0] - arrayOfInt8[1];
     this.t.x[this.t.nt] = (arrayOfInt7[0] + arrayOfInt7[1]) / 2 + this.x;
     this.t.z[this.t.nt] = (arrayOfInt8[0] + arrayOfInt8[1]) / 2 + this.z;
     this.t.zy[this.t.nt] = 0; this.t.xy[this.t.nt] = 0;
     for (b3 = 0; b3 < 3; ) { this.t.c[this.t.nt][b3] = (this.p[4]).oc[b3]; b3++; }
      this.t.skd[this.t.nt] = 4;
     this.t.dam[this.t.nt] = 1;
     this.t.notwall[this.t.nt] = false;
     this.t.decor[this.t.nt] = true;
     this.t.nt++;
   }
 
 
 
   
   public void d(Graphics2D paramGraphics2D) {
     if (this.dist != 0) this.dist = 0;
     
     int i = this.m.cx + (int)((this.x - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (this.z - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
     int j = this.m.cz + (int)((this.x - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (this.z - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
     int k = this.m.cz + (int)((this.y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (j - this.m.cz) * this.m.cos(this.m.zy));
     
     int m = xs(i + this.maxR, k) - xs(i - this.maxR, k);
     if (xs(i + this.maxR * 2, k) > this.m.iw && xs(i - this.maxR * 2, k) < this.m.w && k > -this.maxR && (k < this.m.fade[this.disline] + this.maxR || this.m.trk != 0) && (m > this.disp || this.m.trk != 0) && (!this.decor || (this.m.resdown != 2 && this.m.trk != 1))) {
 
       
       if (this.shadow)
       {
         if (!this.m.crs)
         
         { if (k < 2000) {
             
             boolean bool = false;
             if (this.t.ncx != 0 || this.t.ncz != 0) {
               
               int i1 = (this.x - this.t.sx) / 3000; if (i1 > this.t.ncx) i1 = this.t.ncx;  if (i1 < 0) i1 = 0; 
               int i2 = (this.z - this.t.sz) / 3000; if (i2 > this.t.ncz) i2 = this.t.ncz;  if (i2 < 0) i2 = 0; 
               for (int i3 = (this.t.sect[i1][i2]).length - 1; i3 >= 0; ) { int i4 = this.t.sect[i1][i2][i3]; if (Math.abs(this.t.zy[i4]) != 90 && Math.abs(this.t.xy[i4]) != 90 && Math.abs(this.x - this.t.x[i4]) < this.t.radx[i4] + this.maxR && Math.abs(this.z - this.t.z[i4]) < this.t.radz[i4] + this.maxR && (!this.t.decor[i4] || this.m.resdown != 2)) { bool = true; break; }  i3--; }
             
             } 
             if (bool) {
               
               for (byte b = 0; b < this.npl; ) { this.p[b].s(paramGraphics2D, this.x - this.m.x, this.y - this.m.y, this.z - this.m.z, this.xz, this.xy, this.zy, 0); b++; }
             
             } else {
               
               int i1 = this.m.cy + (int)((this.m.ground - this.m.cy) * this.m.cos(this.m.zy) - (j - this.m.cz) * this.m.sin(this.m.zy));
               int i2 = this.m.cz + (int)((this.m.ground - this.m.cy) * this.m.sin(this.m.zy) + (j - this.m.cz) * this.m.cos(this.m.zy));
               if (ys(i1 + this.maxR, i2) > 0 && ys(i1 - this.maxR, i2) < this.m.h) for (byte b = 0; b < this.npl; ) { this.p[b].s(paramGraphics2D, this.x - this.m.x, this.y - this.m.y, this.z - this.m.z, this.xz, this.xy, this.zy, 1); b++; }
                  
             } 
             this.m.addsp(this.x - this.m.x, this.z - this.m.z, (int)(this.maxR * 0.8D));
           } else {
             lowshadow(paramGraphics2D, k);
           }  }
         else { for (byte b = 0; b < this.npl; ) { this.p[b].s(paramGraphics2D, this.x - this.m.x, this.y - this.m.y, this.z - this.m.z, this.xz, this.xy, this.zy, 2); b++; }
            }
          } 
       int n = this.m.cy + (int)((this.y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (j - this.m.cz) * this.m.sin(this.m.zy));
       if (ys(n + this.maxR, k) > this.m.ih && ys(n - this.maxR, k) < this.m.h) {
         
         if (this.elec && this.m.noelec == 0) electrify(paramGraphics2D); 
         if (this.fix) fixit(paramGraphics2D); 
         if (this.checkpoint != 0 && this.checkpoint - 1 == this.m.checkpoint) m = -1; 
         if (this.shadow) { byte b1; for (this.dist = (int)Math.sqrt(((this.m.x + this.m.cx - this.x) * (this.m.x + this.m.cx - this.x) + (this.m.z - this.z) * (this.m.z - this.z) + (this.m.y + this.m.cy - this.y) * (this.m.y + this.m.cy - this.y))), b1 = 0; b1 < 20; ) { if (this.stg[b1] != 0) pdust(b1, paramGraphics2D, true);  b1++; }  dsprk(paramGraphics2D, true); }
         
         int[] arrayOfInt1 = new int[this.npl];
         int[] arrayOfInt2 = new int[this.npl]; byte b;
         for (b = 0; b < this.npl; ) { arrayOfInt1[b] = 0; b++; }
          for (b = 0; b < this.npl; ) { for (int i1 = b + 1; i1 < this.npl; ) { if ((this.p[b]).av != (this.p[i1]).av) { if ((this.p[b]).av < (this.p[i1]).av) { arrayOfInt1[b] = arrayOfInt1[b] + 1; } else { arrayOfInt1[i1] = arrayOfInt1[i1] + 1; }  } else if (b > i1) { arrayOfInt1[b] = arrayOfInt1[b] + 1; } else { arrayOfInt1[i1] = arrayOfInt1[i1] + 1; }  i1++; }  arrayOfInt2[arrayOfInt1[b]] = b; b++; }
          for (b = 0; b < this.npl; ) { this.p[arrayOfInt2[b]].d(paramGraphics2D, this.x - this.m.x, this.y - this.m.y, this.z - this.m.z, this.xz, this.xy, this.zy, this.wxz, this.wzy, this.noline, m); b++; }
         
         if (this.shadow) { for (b = 0; b < 20; ) { if (this.stg[b] != 0) pdust(b, paramGraphics2D, false);  b++; }  dsprk(paramGraphics2D, false); }
          this.dist = (int)(Math.sqrt((int)Math.sqrt(((this.m.x + this.m.cx - this.x) * (this.m.x + this.m.cx - this.x) + (this.m.z - this.z) * (this.m.z - this.z) + (this.m.y + this.m.cy - this.y) * (this.m.y + this.m.cy - this.y)))) * this.grounded);
       } 
     } 
     if (this.shadow && this.dist == 0) { byte b; for (b = 0; b < 20; ) { if (this.stg[b] != 0) this.stg[b] = 0;  b++; }  for (b = 0; b < 100; ) { if (this.rtg[b] != 0) this.rtg[b] = 0;  b++; }  if (this.sprk != 0) this.sprk = 0;
        }
   
   }
   
   public void lowshadow(Graphics2D paramGraphics2D, int paramInt) {
     int[] arrayOfInt1 = new int[4];
     int[] arrayOfInt2 = new int[4];
     int[] arrayOfInt3 = new int[4];
     
     byte b = 1; int i;
     for (i = Math.abs(this.zy); i > 270; i -= 360); i = Math.abs(i); if (i > 90) b = -1; 
     arrayOfInt1[0] = (int)(this.keyx[0] * 1.2D + this.x - this.m.x); arrayOfInt3[0] = (int)(((this.keyz[0] + 30) * b) * 1.2D + this.z - this.m.z);
     arrayOfInt1[1] = (int)(this.keyx[1] * 1.2D + this.x - this.m.x); arrayOfInt3[1] = (int)(((this.keyz[1] + 30) * b) * 1.2D + this.z - this.m.z);
     arrayOfInt1[2] = (int)(this.keyx[3] * 1.2D + this.x - this.m.x); arrayOfInt3[2] = (int)(((this.keyz[3] - 30) * b) * 1.2D + this.z - this.m.z);
     arrayOfInt1[3] = (int)(this.keyx[2] * 1.2D + this.x - this.m.x); arrayOfInt3[3] = (int)(((this.keyz[2] - 30) * b) * 1.2D + this.z - this.m.z);
     
     rot(arrayOfInt1, arrayOfInt3, this.x - this.m.x, this.z - this.m.z, this.xz, 4);
     
     int j = (int)(this.m.crgrnd[0] / 1.5D);
     int k = (int)(this.m.crgrnd[1] / 1.5D);
     int m = (int)(this.m.crgrnd[2] / 1.5D);
     int n;
     for (n = 0; n < 4; ) { arrayOfInt2[n] = this.m.ground; n++; }
     
     if (this.t.ncx != 0 || this.t.ncz != 0) {
       
       n = (this.x - this.t.sx) / 3000; if (n > this.t.ncx) n = this.t.ncx;  if (n < 0) n = 0; 
       int i1 = (this.z - this.t.sz) / 3000; if (i1 > this.t.ncz) i1 = this.t.ncz;  if (i1 < 0) i1 = 0; 
       for (int i2 = (this.t.sect[n][i1]).length - 1; i2 >= 0; i2--) {
         
         int i3 = this.t.sect[n][i1][i2];
         
         byte b6 = 0; byte b7;
         for (b7 = 0; b7 < 4; b7++) {
           
           if (Math.abs(this.t.zy[i3]) != 90 && Math.abs(this.t.xy[i3]) != 90 && this.t.rady[i3] != 801 && Math.abs(arrayOfInt1[b7] - this.t.x[i3] - this.m.x) < this.t.radx[i3] && Math.abs(arrayOfInt3[b7] - this.t.z[i3] - this.m.z) < this.t.radz[i3] && (!this.t.decor[i3] || this.m.resdown != 2)) b6++;
         
         } 
         if (b6 > 2) {
           
           for (b7 = 0; b7 < 4; b7++) {
             
             arrayOfInt2[b7] = this.t.y[i3] - this.m.y;
             if (this.t.zy[i3] != 0) arrayOfInt2[b7] = (int)(arrayOfInt2[b7] + (arrayOfInt3[b7] - this.t.z[i3] - this.m.z - this.t.radz[i3]) * this.m.sin(this.t.zy[i3]) / this.m.sin(90 - this.t.zy[i3]) - this.t.radz[i3] * this.m.sin(this.t.zy[i3]) / this.m.sin(90 - this.t.zy[i3])); 
             if (this.t.xy[i3] != 0) arrayOfInt2[b7] = (int)(arrayOfInt2[b7] + (arrayOfInt1[b7] - this.t.x[i3] - this.m.x - this.t.radx[i3]) * this.m.sin(this.t.xy[i3]) / this.m.sin(90 - this.t.xy[i3]) - this.t.radx[i3] * this.m.sin(this.t.xy[i3]) / this.m.sin(90 - this.t.xy[i3])); 
           } 
           j = (int)(this.t.c[i3][0] / 1.5D);
           k = (int)(this.t.c[i3][1] / 1.5D);
           m = (int)(this.t.c[i3][2] / 1.5D);
           
           break;
         } 
       } 
     } 
     
     rot(arrayOfInt1, arrayOfInt3, this.m.cx, this.m.cz, this.m.xz, 4);
     rot(arrayOfInt2, arrayOfInt3, this.m.cy, this.m.cz, this.m.zy, 4);
     
     n = 1;
     byte b1 = 0, b2 = 0, b3 = 0, b4 = 0;
     byte b5;
     for (b5 = 0; b5 < 4; b5++) {
       
       arrayOfInt1[b5] = xs(arrayOfInt1[b5], arrayOfInt3[b5]);
       arrayOfInt2[b5] = ys(arrayOfInt2[b5], arrayOfInt3[b5]);
       if (arrayOfInt2[b5] < this.m.ih || arrayOfInt3[b5] < 10) b1++; 
       if (arrayOfInt2[b5] > this.m.h || arrayOfInt3[b5] < 10) b2++; 
       if (arrayOfInt1[b5] < this.m.iw || arrayOfInt3[b5] < 10) b3++; 
       if (arrayOfInt1[b5] > this.m.w || arrayOfInt3[b5] < 10) b4++; 
     } 
     if (b3 == 4 || b1 == 4 || b2 == 4 || b4 == 4) n = 0;
     
     if (n != 0) {
       
       for (b5 = 0; b5 < 16; ) { if (paramInt > this.m.fade[b5]) { j = (j * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1); k = (k * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1); m = (m * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1); }  b5++; }
       
       paramGraphics2D.setColor(new Color(j, k, m));
       paramGraphics2D.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
     } 
   }
 
 
 
 
   
   public void fixit(Graphics2D paramGraphics2D) {
     if (this.fcnt == 1)
     {
       for (byte b = 0; b < this.npl; b++) {
         
         (this.p[b]).hsb[0] = 0.57F; (this.p[b]).hsb[2] = 0.8F; (this.p[b]).hsb[1] = 0.8F;
         Color color = Color.getHSBColor((this.p[b]).hsb[0], (this.p[b]).hsb[1], (this.p[b]).hsb[2]);
         int i = (int)(color.getRed() + color.getRed() * this.m.snap[0] / 100.0F); if (i > 255) i = 255;  if (i < 0) i = 0; 
         int j = (int)(color.getGreen() + color.getGreen() * this.m.snap[1] / 100.0F); if (j > 255) j = 255;  if (j < 0) j = 0; 
         int k = (int)(color.getBlue() + color.getBlue() * this.m.snap[2] / 100.0F); if (k > 255) k = 255;  if (k < 0) k = 0; 
         Color.RGBtoHSB(i, j, k, (this.p[b]).hsb);
         (this.p[b]).flx = 1;
       } 
     }
     
     if (this.fcnt == 2) for (byte b = 0; b < this.npl; ) { (this.p[b]).flx = 1; b++; }
         if (this.fcnt == 4) for (byte b = 0; b < this.npl; ) { (this.p[b]).flx = 3; b++; }
        
     if ((this.fcnt == 1 || this.fcnt > 2) && this.fcnt != 9) {
       
       int[] arrayOfInt1 = new int[8];
       int[] arrayOfInt2 = new int[8];
       int[] arrayOfInt3 = new int[4];
       int i;
       for (i = 0; i < 4; ) { arrayOfInt1[i] = this.keyx[i] + this.x - this.m.x; arrayOfInt2[i] = this.grat + this.y - this.m.y; arrayOfInt3[i] = this.keyz[i] + this.z - this.m.z; i++; }
       
       rot(arrayOfInt1, arrayOfInt2, this.x - this.m.x, this.y - this.m.y, this.xy, 4);
       rot(arrayOfInt2, arrayOfInt3, this.y - this.m.y, this.z - this.m.y, this.zy, 4);
       rot(arrayOfInt1, arrayOfInt3, this.x - this.m.x, this.z - this.m.z, this.xz, 4);
       
       rot(arrayOfInt1, arrayOfInt3, this.m.cx, this.m.cz, this.m.xz, 4);
       rot(arrayOfInt2, arrayOfInt3, this.m.cy, this.m.cz, this.m.zy, 4);
 
       
       i = 0; int j = 0, k = 0; int m;
       for (m = 0; m < 4; m++) {
         
         for (byte b = 0; b < 4; b++) {
           
           if (Math.abs(arrayOfInt1[m] - arrayOfInt1[b]) > i) i = Math.abs(arrayOfInt1[m] - arrayOfInt1[b]); 
           if (Math.abs(arrayOfInt2[m] - arrayOfInt2[b]) > j) j = Math.abs(arrayOfInt2[m] - arrayOfInt2[b]); 
           if (py(arrayOfInt1[m], arrayOfInt1[b], arrayOfInt2[m], arrayOfInt2[b]) > k) k = py(arrayOfInt1[m], arrayOfInt1[b], arrayOfInt2[m], arrayOfInt2[b]); 
         } 
       } 
       k = (int)(Math.sqrt(k) / 1.5D);
       if (i < k) i = k; 
       if (j < k) j = k;
       
       m = this.m.cx + (int)((this.x - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (this.z - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
       int n = this.m.cz + (int)((this.x - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (this.z - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
       int i1 = this.m.cy + (int)((this.y - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (n - this.m.cz) * this.m.sin(this.m.zy));
       n = this.m.cz + (int)((this.y - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (n - this.m.cz) * this.m.cos(this.m.zy));
       
       arrayOfInt1[0] = xs((int)(m - i / 0.8D - this.m.random() * i / 2.4D), n);
       arrayOfInt2[0] = ys((int)(i1 - j / 1.92D - this.m.random() * j / 5.67D), n);
       arrayOfInt1[1] = xs((int)(m - i / 0.8D - this.m.random() * i / 2.4D), n);
       arrayOfInt2[1] = ys((int)(i1 + j / 1.92D + this.m.random() * j / 5.67D), n);
       arrayOfInt1[2] = xs((int)(m - i / 1.92D - this.m.random() * i / 5.67D), n);
       arrayOfInt2[2] = ys((int)(i1 + j / 0.8D + this.m.random() * j / 2.4D), n);
       arrayOfInt1[3] = xs((int)(m + i / 1.92D + this.m.random() * i / 5.67D), n);
       arrayOfInt2[3] = ys((int)(i1 + j / 0.8D + this.m.random() * j / 2.4D), n);
       arrayOfInt1[4] = xs((int)(m + i / 0.8D + this.m.random() * i / 2.4D), n);
       arrayOfInt2[4] = ys((int)(i1 + j / 1.92D + this.m.random() * j / 5.67D), n);
       arrayOfInt1[5] = xs((int)(m + i / 0.8D + this.m.random() * i / 2.4D), n);
       arrayOfInt2[5] = ys((int)(i1 - j / 1.92D - this.m.random() * j / 5.67D), n);
       arrayOfInt1[6] = xs((int)(m + i / 1.92D + this.m.random() * i / 5.67D), n);
       arrayOfInt2[6] = ys((int)(i1 - j / 0.8D - this.m.random() * j / 2.4D), n);
       arrayOfInt1[7] = xs((int)(m - i / 1.92D - this.m.random() * i / 5.67D), n);
       arrayOfInt2[7] = ys((int)(i1 - j / 0.8D - this.m.random() * j / 2.4D), n);
       
       if (this.fcnt == 3) rot(arrayOfInt1, arrayOfInt2, xs(m, n), ys(i1, n), 22, 8); 
       if (this.fcnt == 4) rot(arrayOfInt1, arrayOfInt2, xs(m, n), ys(i1, n), 22, 8); 
       if (this.fcnt == 5) rot(arrayOfInt1, arrayOfInt2, xs(m, n), ys(i1, n), 0, 8); 
       if (this.fcnt == 6) rot(arrayOfInt1, arrayOfInt2, xs(m, n), ys(i1, n), -22, 8); 
       if (this.fcnt == 7) rot(arrayOfInt1, arrayOfInt2, xs(m, n), ys(i1, n), -22, 8);
       
       int i2 = (int)(191.0F + 191.0F * this.m.snap[0] / 350.0F); if (i2 > 255) i2 = 255;  if (i2 < 0) i2 = 0; 
       int i3 = (int)(232.0F + 232.0F * this.m.snap[1] / 350.0F); if (i3 > 255) i3 = 255;  if (i3 < 0) i3 = 0; 
       int i4 = (int)(255.0F + 255.0F * this.m.snap[2] / 350.0F); if (i4 > 255) i4 = 255;  if (i4 < 0) i4 = 0;
       
       paramGraphics2D.setColor(new Color(i2, i3, i4));
       paramGraphics2D.fillPolygon(arrayOfInt1, arrayOfInt2, 8);
       
       arrayOfInt1[0] = xs((int)((m - i) - this.m.random() * (i / 4)), n);
       arrayOfInt2[0] = ys((int)(i1 - j / 2.4D - this.m.random() * j / 9.6D), n);
       arrayOfInt1[1] = xs((int)((m - i) - this.m.random() * (i / 4)), n);
       arrayOfInt2[1] = ys((int)(i1 + j / 2.4D + this.m.random() * j / 9.6D), n);
       arrayOfInt1[2] = xs((int)(m - i / 2.4D - this.m.random() * i / 9.6D), n);
       arrayOfInt2[2] = ys((int)((i1 + j) + this.m.random() * (j / 4)), n);
       arrayOfInt1[3] = xs((int)(m + i / 2.4D + this.m.random() * i / 9.6D), n);
       arrayOfInt2[3] = ys((int)((i1 + j) + this.m.random() * (j / 4)), n);
       arrayOfInt1[4] = xs((int)((m + i) + this.m.random() * (i / 4)), n);
       arrayOfInt2[4] = ys((int)(i1 + j / 2.4D + this.m.random() * j / 9.6D), n);
       arrayOfInt1[5] = xs((int)((m + i) + this.m.random() * (i / 4)), n);
       arrayOfInt2[5] = ys((int)(i1 - j / 2.4D - this.m.random() * j / 9.6D), n);
       arrayOfInt1[6] = xs((int)(m + i / 2.4D + this.m.random() * i / 9.6D), n);
       arrayOfInt2[6] = ys((int)((i1 - j) - this.m.random() * (j / 4)), n);
       arrayOfInt1[7] = xs((int)(m - i / 2.4D - this.m.random() * i / 9.6D), n);
       arrayOfInt2[7] = ys((int)((i1 - j) - this.m.random() * (j / 4)), n);
       
       i2 = (int)(213.0F + 213.0F * this.m.snap[0] / 350.0F); if (i2 > 255) i2 = 255;  if (i2 < 0) i2 = 0; 
       i3 = (int)(239.0F + 239.0F * this.m.snap[1] / 350.0F); if (i3 > 255) i3 = 255;  if (i3 < 0) i3 = 0; 
       i4 = (int)(255.0F + 255.0F * this.m.snap[2] / 350.0F); if (i4 > 255) i4 = 255;  if (i4 < 0) i4 = 0;
       
       paramGraphics2D.setColor(new Color(i2, i3, i4));
       paramGraphics2D.fillPolygon(arrayOfInt1, arrayOfInt2, 8);
     } 
     
     if (this.fcnt > 7) { this.fcnt = 0; this.fix = false; } else { this.fcnt++; }
   
   }
 
 
 
 
   
   public void electrify(Graphics2D paramGraphics2D) {
     for (byte b = 0; b < 4; b++) {
       
       if (this.elc[b] == 0) {
         
         this.edl[b] = (int)(380.0F - this.m.random() * 760.0F);
         this.edr[b] = (int)(380.0F - this.m.random() * 760.0F);
         this.elc[b] = 1;
       } 
       
       int i = (int)(this.edl[b] + 190.0F - this.m.random() * 380.0F);
       int j = (int)(this.edr[b] + 190.0F - this.m.random() * 380.0F);
       
       int k = (int)(this.m.random() * 126.0F);
       int m = (int)(this.m.random() * 126.0F);
       
       int[] arrayOfInt1 = new int[8], arrayOfInt2 = new int[8], arrayOfInt3 = new int[8]; byte b1;
       for (b1 = 0; b1 < 8; ) { arrayOfInt3[b1] = this.z - this.m.z; b1++; }
       
       arrayOfInt1[0] = this.x - this.m.x - 504;
       arrayOfInt2[0] = this.y - this.m.y - this.edl[b] - 5 - (int)(this.m.random() * 5.0F);
       
       arrayOfInt1[1] = this.x - this.m.x - 252 + m;
       arrayOfInt2[1] = this.y - this.m.y - i - 5 - (int)(this.m.random() * 5.0F);
       
       arrayOfInt1[2] = this.x - this.m.x + 252 - k;
       arrayOfInt2[2] = this.y - this.m.y - j - 5 - (int)(this.m.random() * 5.0F);
       
       arrayOfInt1[3] = this.x - this.m.x + 504;
       arrayOfInt2[3] = this.y - this.m.y - this.edr[b] - 5 - (int)(this.m.random() * 5.0F);
       
       arrayOfInt1[4] = this.x - this.m.x + 504;
       arrayOfInt2[4] = this.y - this.m.y - this.edr[b] + 5 + (int)(this.m.random() * 5.0F);
       
       arrayOfInt1[5] = this.x - this.m.x + 252 - k;
       arrayOfInt2[5] = this.y - this.m.y - j + 5 + (int)(this.m.random() * 5.0F);
       
       arrayOfInt1[6] = this.x - this.m.x - 252 + m;
       arrayOfInt2[6] = this.y - this.m.y - i + 5 + (int)(this.m.random() * 5.0F);
       
       arrayOfInt1[7] = this.x - this.m.x - 504;
       arrayOfInt2[7] = this.y - this.m.y - this.edl[b] + 5 + (int)(this.m.random() * 5.0F);
       
       if (this.roted) rot(arrayOfInt1, arrayOfInt3, this.x - this.m.x, this.z - this.m.z, 90, 8); 
       rot(arrayOfInt1, arrayOfInt3, this.m.cx, this.m.cz, this.m.xz, 8);
       rot(arrayOfInt2, arrayOfInt3, this.m.cy, this.m.cz, this.m.zy, 8);
       
       b1 = 1;
       byte b2 = 0, b3 = 0, b4 = 0, b5 = 0;
       int[] arrayOfInt4 = new int[8];
       int[] arrayOfInt5 = new int[8];
       int n;
       for (n = 0; n < 8; n++) {
         
         arrayOfInt4[n] = xs(arrayOfInt1[n], arrayOfInt3[n]);
         arrayOfInt5[n] = ys(arrayOfInt2[n], arrayOfInt3[n]);
         if (arrayOfInt5[n] < this.m.ih || arrayOfInt3[n] < 10) b2++; 
         if (arrayOfInt5[n] > this.m.h || arrayOfInt3[n] < 10) b3++; 
         if (arrayOfInt4[n] < this.m.iw || arrayOfInt3[n] < 10) b4++; 
         if (arrayOfInt4[n] > this.m.w || arrayOfInt3[n] < 10) b5++; 
       } 
       if (b4 == 8 || b2 == 8 || b3 == 8 || b5 == 8) b1 = 0;
       
       if (b1 != 0) {
         
         n = (int)(160.0F + 160.0F * this.m.snap[0] / 500.0F); if (n > 255) n = 255;  if (n < 0) n = 0; 
         int i1 = (int)(238.0F + 238.0F * this.m.snap[1] / 500.0F); if (i1 > 255) i1 = 255;  if (i1 < 0) i1 = 0; 
         int i2 = (int)(255.0F + 255.0F * this.m.snap[2] / 500.0F); if (i2 > 255) i2 = 255;  if (i2 < 0) i2 = 0;
         
         n = (n * 2 + 214 * (this.elc[b] - 1)) / (this.elc[b] + 1);
         i1 = (i1 * 2 + 236 * (this.elc[b] - 1)) / (this.elc[b] + 1);
         
         if (this.m.trk == 1) { n = 255; i1 = 128; i2 = 0; }
          paramGraphics2D.setColor(new Color(n, i1, i2));
         paramGraphics2D.fillPolygon(arrayOfInt4, arrayOfInt5, 8);
         if (arrayOfInt3[0] < 4000) {
           
           n = (int)(150.0F + 150.0F * this.m.snap[0] / 500.0F); if (n > 255) n = 255;  if (n < 0) n = 0; 
           i1 = (int)(227.0F + 227.0F * this.m.snap[1] / 500.0F); if (i1 > 255) i1 = 255;  if (i1 < 0) i1 = 0; 
           i2 = (int)(255.0F + 255.0F * this.m.snap[2] / 500.0F); if (i2 > 255) i2 = 255;  if (i2 < 0) i2 = 0;
           
           paramGraphics2D.setColor(new Color(n, i1, i2));
           paramGraphics2D.drawPolygon(arrayOfInt4, arrayOfInt5, 8);
         } 
       } 
       
       if (this.elc[b] > this.m.random() * 60.0F) { this.elc[b] = 0; } else { this.elc[b] = this.elc[b] + 1; }
     
     } 
     if (!this.roted || this.xz != 0) { this.xy += 11; if (this.xy > 360) this.xy -= 360;  } else { this.zy += 11; if (this.zy > 360) this.zy -= 360;
        }
   
   }
   
   public void dust(int paramInt1, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt2, int paramInt3, float paramFloat4, int paramInt4, boolean paramBoolean) {
     boolean bool = false;
     if (paramInt4 > 5 && (paramInt1 == 0 || paramInt1 == 2)) bool = true; 
     if (paramInt4 < -5 && (paramInt1 == 1 || paramInt1 == 3)) bool = true; 
     float f = (float)((Math.sqrt((paramInt2 * paramInt2 + paramInt3 * paramInt3)) - 40.0D) / 160.0D); if (f > 1.0F) f = 1.0F; 
     if (f > 0.2D && !bool) {
       
       this.ust++; if (this.ust == 20) this.ust = 0; 
       if (!paramBoolean) {
         
         float f1 = this.m.random();
         this.sx[this.ust] = (int)((paramFloat1 + this.x * f1) / (1.0F + f1));
         this.sz[this.ust] = (int)((paramFloat3 + this.z * f1) / (1.0F + f1));
         this.sy[this.ust] = (int)((paramFloat2 + this.y * f1) / (1.0F + f1));
       } else {
         this.sx[this.ust] = (int)((paramFloat1 + (this.x + paramInt2)) / 2.0F); this.sz[this.ust] = (int)((paramFloat3 + (this.z + paramInt3)) / 2.0F); this.sy[this.ust] = (int)paramFloat2;
       } 
       if (this.sy[paramInt1] > 250) this.sy[paramInt1] = 250; 
       this.osmag[this.ust] = paramFloat4 * f;
       this.scx[this.ust] = paramInt2;
       this.scz[this.ust] = paramInt3;
       this.stg[this.ust] = 1;
     } 
   }
 
 
   
   public void pdust(int paramInt, Graphics2D paramGraphics2D, boolean paramBoolean) {
     if (paramBoolean) this.sav[paramInt] = (int)Math.sqrt(((this.m.x + this.m.cx - this.sx[paramInt]) * (this.m.x + this.m.cx - this.sx[paramInt]) + (this.m.y + this.m.cy - this.sy[paramInt]) * (this.m.y + this.m.cy - this.sy[paramInt]) + (this.m.z - this.sz[paramInt]) * (this.m.z - this.sz[paramInt])));
     
     if ((paramBoolean && this.sav[paramInt] > this.dist) || (!paramBoolean && this.sav[paramInt] <= this.dist)) {
 
       
       if (this.stg[paramInt] == 1) {
         
         this.sbln[paramInt] = 0.6F;
         boolean bool = false;
         int[] arrayOfInt = new int[3]; int n;
         for (n = 0; n < 3; ) { arrayOfInt[n] = (int)(255.0F + 255.0F * this.m.snap[n] / 100.0F); if (arrayOfInt[n] > 255) arrayOfInt[n] = 255;  if (arrayOfInt[n] < 0) arrayOfInt[n] = 0;  n++; }
          n = (this.x - this.t.sx) / 3000; if (n > this.t.ncx) n = this.t.ncx;  if (n < 0) n = 0; 
         int i1 = (this.z - this.t.sz) / 3000; if (i1 > this.t.ncz) i1 = this.t.ncz;  if (i1 < 0) i1 = 0;  byte b6;
         for (b6 = 0; b6 < (this.t.sect[n][i1]).length; b6++) {
           
           int i2 = this.t.sect[n][i1][b6];
           if (Math.abs(this.t.zy[i2]) != 90 && Math.abs(this.t.xy[i2]) != 90 && Math.abs(this.sx[paramInt] - this.t.x[i2]) < this.t.radx[i2] && Math.abs(this.sz[paramInt] - this.t.z[i2]) < this.t.radz[i2]) {
             
             if (this.t.skd[i2] == 0) this.sbln[paramInt] = 0.2F; 
             if (this.t.skd[i2] == 1) this.sbln[paramInt] = 0.4F; 
             if (this.t.skd[i2] == 2) this.sbln[paramInt] = 0.45F; 
             for (byte b = 0; b < 3; ) { this.srgb[paramInt][b] = (this.t.c[i2][b] + arrayOfInt[b]) / 2; b++; }
              bool = true;
           } 
         } 
         if (!bool) for (b6 = 0; b6 < 3; ) { this.srgb[paramInt][b6] = (this.m.crgrnd[b6] + arrayOfInt[b6]) / 2; b6++; }
             float f = (float)(0.1D + this.m.random()); if (f > 1.0F) f = 1.0F; 
         this.scx[paramInt] = (int)(this.scx[paramInt] * f);
         this.scz[paramInt] = (int)(this.scx[paramInt] * f); byte b7;
         for (b7 = 0; b7 < 8; ) { this.smag[paramInt][b7] = this.osmag[paramInt] * this.m.random() * 50.0F; b7++; }
          for (b7 = 0; b7 < 8; ) { int i2 = b7 - 1; if (i2 == -1) i2 = 7;  int i3 = b7 + 1; if (i3 == 8) i3 = 0;  this.smag[paramInt][b7] = ((this.smag[paramInt][i2] + this.smag[paramInt][i3]) / 2.0F + this.smag[paramInt][b7]) / 2.0F; b7++; }
          this.smag[paramInt][6] = this.smag[paramInt][7];
       } 
       
       int i = this.m.cx + (int)((this.sx[paramInt] - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (this.sz[paramInt] - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
       int j = this.m.cz + (int)((this.sx[paramInt] - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (this.sz[paramInt] - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
       int k = this.m.cy + (int)(((this.sy[paramInt] - this.m.y - this.m.cy) - this.smag[paramInt][7]) * this.m.cos(this.m.zy) - (j - this.m.cz) * this.m.sin(this.m.zy));
       j = this.m.cz + (int)(((this.sy[paramInt] - this.m.y - this.m.cy) - this.smag[paramInt][7]) * this.m.sin(this.m.zy) + (j - this.m.cz) * this.m.cos(this.m.zy));
       
       this.sx[paramInt] = this.sx[paramInt] + this.scx[paramInt] / (this.stg[paramInt] + 1);
       this.sz[paramInt] = this.sz[paramInt] + this.scz[paramInt] / (this.stg[paramInt] + 1);
       
       int[] arrayOfInt1 = new int[8];
       int[] arrayOfInt2 = new int[8];
       
       arrayOfInt1[0] = xs((int)(i + this.smag[paramInt][0] * 0.9238F * 1.5F), j);
       arrayOfInt2[0] = ys((int)(k + this.smag[paramInt][0] * 0.3826F * 1.5F), j);
       arrayOfInt1[1] = xs((int)(i + this.smag[paramInt][1] * 0.9238F * 1.5F), j);
       arrayOfInt2[1] = ys((int)(k - this.smag[paramInt][1] * 0.3826F * 1.5F), j);
       arrayOfInt1[2] = xs((int)(i + this.smag[paramInt][2] * 0.3826F), j);
       arrayOfInt2[2] = ys((int)(k - this.smag[paramInt][2] * 0.9238F), j);
       arrayOfInt1[3] = xs((int)(i - this.smag[paramInt][3] * 0.3826F), j);
       arrayOfInt2[3] = ys((int)(k - this.smag[paramInt][3] * 0.9238F), j);
       arrayOfInt1[4] = xs((int)(i - this.smag[paramInt][4] * 0.9238F * 1.5F), j);
       arrayOfInt2[4] = ys((int)(k - this.smag[paramInt][4] * 0.3826F * 1.5F), j);
       arrayOfInt1[5] = xs((int)(i - this.smag[paramInt][5] * 0.9238F * 1.5F), j);
       arrayOfInt2[5] = ys((int)(k + this.smag[paramInt][5] * 0.3826F * 1.5F), j);
       arrayOfInt1[6] = xs((int)(i - this.smag[paramInt][6] * 0.3826F * 1.7F), j);
       arrayOfInt2[6] = ys((int)(k + this.smag[paramInt][6] * 0.9238F), j);
       arrayOfInt1[7] = xs((int)(i + this.smag[paramInt][7] * 0.3826F * 1.7F), j);
       arrayOfInt2[7] = ys((int)(k + this.smag[paramInt][7] * 0.9238F), j);
       byte b1;
       for (b1 = 0; b1 < 7; ) { this.smag[paramInt][b1] = this.smag[paramInt][b1] + 5.0F + this.m.random() * 15.0F; b1++; }
        this.smag[paramInt][7] = this.smag[paramInt][6];
       
       b1 = 1;
       byte b2 = 0, b3 = 0, b4 = 0, b5 = 0;
       int m;
       for (m = 0; m < 8; m++) {
         
         if (arrayOfInt2[m] < this.m.ih || j < 10) b2++; 
         if (arrayOfInt2[m] > this.m.h || j < 10) b3++; 
         if (arrayOfInt1[m] < this.m.iw || j < 10) b4++; 
         if (arrayOfInt1[m] > this.m.w || j < 10) b5++; 
       } 
       if (b4 == 4 || b2 == 4 || b3 == 4 || b5 == 4) b1 = 0;
       
       if (b1 != 0) {
         
         m = this.srgb[paramInt][0];
         int n = this.srgb[paramInt][1];
         int i1 = this.srgb[paramInt][2];
         for (byte b = 0; b < 16; ) { if (this.sav[paramInt] > this.m.fade[b]) { m = (m * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1); n = (n * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1); i1 = (i1 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1); }  b++; }
          paramGraphics2D.setColor(new Color(m, n, i1));
         float f = this.sbln[paramInt] - this.stg[paramInt] * this.sbln[paramInt] / 8.0F;
         paramGraphics2D.setComposite(AlphaComposite.getInstance(3, f));
         paramGraphics2D.fillPolygon(arrayOfInt1, arrayOfInt2, 8);
         paramGraphics2D.setComposite(AlphaComposite.getInstance(3, 1.0F));
       } 
       
       if (this.stg[paramInt] == 7) { this.stg[paramInt] = 0; } else { this.stg[paramInt] = this.stg[paramInt] + 1; }
     
     } 
   }
 
   
   public void sprk(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, int paramInt) {
     if (paramInt != 1) {
       
       this.srx = (int)(paramFloat1 - this.sprkat * this.m.sin(this.xz));
       this.sry = (int)(paramFloat2 - this.sprkat * this.m.cos(this.zy) * this.m.cos(this.xy));
       this.srz = (int)(paramFloat3 + this.sprkat * this.m.cos(this.xz));
       this.sprk = 1;
     }
     else {
       
       this.sprk++;
       if (this.sprk == 4) { this.srx = (int)(this.x + paramFloat4); this.sry = (int)paramFloat2; this.srz = (int)(this.z + paramFloat6); this.sprk = 5; } else { this.srx = (int)paramFloat1; this.sry = (int)paramFloat2; this.srz = (int)paramFloat3; }
     
     }  if (paramInt == 2) this.sprk = 6; 
     this.rcx = paramFloat4;
     this.rcy = paramFloat5;
     this.rcz = paramFloat6;
   }
 
   
   public void dsprk(Graphics2D paramGraphics2D, boolean paramBoolean) {
     if (paramBoolean && this.sprk != 0) {
       
       int i = (int)(Math.sqrt((this.rcx * this.rcx + this.rcy * this.rcy + this.rcz * this.rcz)) / 10.0D);
       if (i > 5) {
         
         boolean bool = false;
         if (this.dist < Math.sqrt(((this.m.x + this.m.cx - this.srx) * (this.m.x + this.m.cx - this.srx) + (this.m.y + this.m.cy - this.sry) * (this.m.y + this.m.cy - this.sry) + (this.m.z - this.srz) * (this.m.z - this.srz)))) bool = true; 
         if (i > 33) i = 33;  byte b1 = 0;
         for (byte b2 = 0; b2 < 100; ) { if (this.rtg[b2] == 0) { this.rtg[b2] = 1; this.rbef[b2] = bool; b1++; }  if (b1 == i) break;  b2++; }
       
       } 
     } 
     for (byte b = 0; b < 100; b++) {
       
       if (this.rtg[b] != 0)
       {
         if ((this.rbef[b] && paramBoolean) || (!this.rbef[b] && !paramBoolean)) {
 
           
           if (this.rtg[b] == 1) {
             
             if (this.sprk < 5)
             
             { this.rx[b] = this.srx + 3 - (int)(this.m.random() * 6.7D);
               this.ry[b] = this.sry + 3 - (int)(this.m.random() * 6.7D);
               this.rz[b] = this.srz + 3 - (int)(this.m.random() * 6.7D); }
             else { this.rx[b] = this.srx + 10 - (int)(this.m.random() * 20.0F); this.ry[b] = this.sry - (int)(this.m.random() * 4.0F); this.rz[b] = this.srz + 10 - (int)(this.m.random() * 20.0F); }
              int i6 = (int)Math.sqrt((this.rcx * this.rcx + this.rcy * this.rcy + this.rcz * this.rcz));
             float f1 = 0.2F + 0.4F * this.m.random();
             float f2 = this.m.random() * this.m.random() * this.m.random();
             float f3 = 1.0F;
             if (this.m.random() > this.m.random()) { if (this.m.random() > this.m.random()) f3 *= -1.0F; 
               this.vrx[b] = -((this.rcx + i6 * (1.0F - this.rcx / i6) * f2 * f3) * f1); }
             
             if (this.m.random() > this.m.random()) { if (this.m.random() > this.m.random()) f3 *= -1.0F;  if (this.sprk == 5) f3 = 1.0F; 
               this.vry[b] = -((this.rcy + i6 * (1.0F - this.rcy / i6) * f2 * f3) * f1); }
             
             if (this.m.random() > this.m.random()) { if (this.m.random() > this.m.random()) f3 *= -1.0F; 
               this.vrz[b] = -((this.rcz + i6 * (1.0F - this.rcz / i6) * f2 * f3) * f1); }
           
           } 
           
           this.rx[b] = (int)(this.rx[b] + this.vrx[b]);
           this.ry[b] = (int)(this.ry[b] + this.vry[b]);
           this.rz[b] = (int)(this.rz[b] + this.vrz[b]);
           
           int i = this.m.cx + (int)((this.rx[b] - this.m.x - this.m.cx) * this.m.cos(this.m.xz) - (this.rz[b] - this.m.z - this.m.cz) * this.m.sin(this.m.xz));
           int j = this.m.cz + (int)((this.rx[b] - this.m.x - this.m.cx) * this.m.sin(this.m.xz) + (this.rz[b] - this.m.z - this.m.cz) * this.m.cos(this.m.xz));
           int k = this.m.cy + (int)((this.ry[b] - this.m.y - this.m.cy) * this.m.cos(this.m.zy) - (j - this.m.cz) * this.m.sin(this.m.zy));
           j = this.m.cz + (int)((this.ry[b] - this.m.y - this.m.cy) * this.m.sin(this.m.zy) + (j - this.m.cz) * this.m.cos(this.m.zy));
           int m = this.m.cx + (int)(((this.rx[b] - this.m.x - this.m.cx) + this.vrx[b]) * this.m.cos(this.m.xz) - ((this.rz[b] - this.m.z - this.m.cz) + this.vrz[b]) * this.m.sin(this.m.xz));
           int n = this.m.cz + (int)(((this.rx[b] - this.m.x - this.m.cx) + this.vrx[b]) * this.m.sin(this.m.xz) + ((this.rz[b] - this.m.z - this.m.cz) + this.vrz[b]) * this.m.cos(this.m.xz));
           int i1 = this.m.cy + (int)(((this.ry[b] - this.m.y - this.m.cy) + this.vry[b]) * this.m.cos(this.m.zy) - (n - this.m.cz) * this.m.sin(this.m.zy));
           n = this.m.cz + (int)(((this.ry[b] - this.m.y - this.m.cy) + this.vry[b]) * this.m.sin(this.m.zy) + (n - this.m.cz) * this.m.cos(this.m.zy));
           
           int i2 = xs(i, j);
           int i3 = ys(k, j);
           int i4 = xs(m, n);
           int i5 = ys(i1, n);
           if (i2 < this.m.iw && i4 < this.m.iw) this.rtg[b] = 0; 
           if (i2 > this.m.w && i4 > this.m.w) this.rtg[b] = 0; 
           if (i3 < this.m.ih && i5 < this.m.ih) this.rtg[b] = 0; 
           if (i3 > this.m.h && i5 > this.m.h) this.rtg[b] = 0; 
           if (this.ry[b] > 250) this.rtg[b] = 0; 
           if (this.rtg[b] != 0) {
             
             int i6 = 255;
             int i7 = 197 - 30 * this.rtg[b];
             int i8 = 0;
             for (byte b1 = 0; b1 < 16; ) { if (j > this.m.fade[b1]) { i6 = (i6 * this.m.fogd + this.m.cfade[0]) / (this.m.fogd + 1); i7 = (i7 * this.m.fogd + this.m.cfade[1]) / (this.m.fogd + 1); i8 = (i8 * this.m.fogd + this.m.cfade[2]) / (this.m.fogd + 1); }  b1++; }
              paramGraphics2D.setColor(new Color(i6, i7, i8));
             paramGraphics2D.drawLine(i2, i3, i4, i5);
             this.vrx[b] = this.vrx[b] * 0.8F;
             this.vry[b] = this.vry[b] * 0.8F;
             this.vrz[b] = this.vrz[b] * 0.8F;
             if (this.rtg[b] == 3) { this.rtg[b] = 0; } else { this.rtg[b] = this.rtg[b] + 1; }
           
           } 
         } 
       }
     } 
     
     if (this.sprk != 0) this.sprk = 0;
   
   }
 
   
   public int xs(int paramInt1, int paramInt2) {
     if (paramInt2 < 50) paramInt2 = 50; 
     return (paramInt2 - this.m.focus_point) * (this.m.cx - paramInt1) / paramInt2 + paramInt1;
   }
 
   
   public int ys(int paramInt1, int paramInt2) {
     if (paramInt2 < 50) paramInt2 = 50;
     
     return (paramInt2 - this.m.focus_point) * (this.m.cy - paramInt1) / paramInt2 + paramInt1; } public int getvalue(String paramString1, String paramString2, int paramInt) { int i;
     byte b;
     String str;
     for (b = 0, str = "", i = paramString1.length() + 1; i < paramString2.length(); ) { String str1 = "" + paramString2.charAt(i); if (str1.equals(",") || str1.equals(")")) { b++; i++; }  if (b == paramInt) str = str + paramString2.charAt(i);  i++; }  return Float.valueOf(str).intValue(); }
 
   
   public int getpy(int paramInt1, int paramInt2, int paramInt3) {
     return (paramInt1 - this.x) / 10 * (paramInt1 - this.x) / 10 + (paramInt2 - this.y) / 10 * (paramInt2 - this.y) / 10 + (paramInt3 - this.z) / 10 * (paramInt3 - this.z) / 10;
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
 }


