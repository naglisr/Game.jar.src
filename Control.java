 
 public class Control
 {
   boolean left = false;
   boolean right = false;
   boolean up = false;
   boolean down = false;
   boolean handb = false;
   int lookback = 0;
   boolean enter = false;
   boolean exit = false;
   boolean arrace = false;
   boolean mutem = false;
   boolean mutes = false;
   boolean radar = false;
   int chatup = 0;
   
   int multion = 0;
 
   
   Medium m;
   
   int pan = 0;
   int attack = 0; int acr = 0;
   boolean afta = false;
   int[] fpnt = new int[5];
   int trfix = 0;
   boolean forget = false;
   boolean bulistc = false;
   int runbul = 0;
 
   
   int acuracy = 0;
   int upwait = 0;
   boolean agressed = false;
   float skiplev = 1.0F;
   int clrnce = 5;
   int rampp = 0;
   int turntyp = 0;
 
   
   float aim = 0.0F;
 
   
   int saftey = 30;
   boolean perfection = false;
   float mustland = 0.5F;
   boolean usebounce = false;
   float trickprf = 0.5F;
   int stuntf = 0;
   
   boolean zyinv = false;
   boolean lastl = false;
   boolean wlastl = false;
   int hold = 0, wall = -1, lwall = -1;
   int stcnt = 0, statusque = 0;
   int turncnt = 0, randtcnt = 0;
   int upcnt = 0;
   int trickfase = 0; int swat = 0;
   boolean udcomp = false, lrcomp = false, udbare = false, lrbare = false;
   boolean onceu = false;
   int lrdirect = 0; boolean onced = false; boolean oncel = false; boolean oncer = false; int uddirect = 0; int lrstart = 0; int udstart = 0; int oxy = 0; int ozy = 0; int flycnt = 0; boolean lrswt = false; boolean udswt = false;
   boolean gowait = false;
   int actwait = 0, cntrn = 0;
   
   int revstart = 0, oupnt = 0;
   int wtz = 0, wtx = 0, frx = 0, frz = 0, frad = 0;
   int apunch = 0;
   boolean exitattack = false;
   int avoidnlev = 0;
   public Control(Medium paramMedium) {
     this.m = paramMedium;
   }
   
   public void falseo(int paramInt) {
     this.left = false;
     this.right = false;
     this.up = false;
     this.down = false;
     this.handb = false;
     this.lookback = 0;
     this.enter = false;
     this.exit = false;
     if (paramInt != 1) {
       
       this.radar = false;
       this.arrace = false;
       this.chatup = 0;
       if (paramInt != 2) this.multion = 0; 
       if (paramInt != 3) { this.mutem = false; this.mutes = false; }
     
     } 
   }
   
   public void reset(CheckPoints paramCheckPoints, int paramInt) {
     this.pan = 0;
     this.attack = 0;
     this.acr = 0;
     this.afta = false;
     this.trfix = 0;
     this.acuracy = 0;
     this.upwait = 0;
     this.forget = false;
     this.bulistc = false;
     this.runbul = 0;
     this.revstart = 0;
     this.oupnt = 0;
     this.gowait = false;
     this.apunch = 0;
     this.exitattack = false;
     
     if (paramCheckPoints.stage == 16 || paramCheckPoints.stage == 18) this.hold = 50; 
     if (paramCheckPoints.stage == 17) this.hold = 10; 
     if (paramCheckPoints.stage == 20) this.hold = 30; 
     if (paramCheckPoints.stage == 21) { if (paramInt != 13) { this.hold = 35; this.revstart = 25; } else { this.hold = 5; }  this.statusque = 0; }
      if (paramCheckPoints.stage == 22) { if (paramInt != 13) { this.hold = (int)(20.0F + 10.0F * this.m.random()); this.revstart = (int)(10.0F + 10.0F * this.m.random()); } else { this.hold = 5; }  this.statusque = 0; }
      if (paramCheckPoints.stage == 24) { this.hold = 30; this.statusque = 0; if (paramInt != 14) this.revstart = 1;  }
      if (paramCheckPoints.stage == 25) this.hold = 40; 
     if (paramCheckPoints.stage == 26) this.hold = 20;
 
     
     if (paramCheckPoints.stage != 19 && paramCheckPoints.stage != 26) {
       byte b;
       for (b = 0; b < paramCheckPoints.fn; b++) {
         
         int i = -10;
         for (byte b1 = 0; b1 < paramCheckPoints.n; b1++) {
           
           if (py(paramCheckPoints.fx[b] / 100, paramCheckPoints.x[b1] / 100, paramCheckPoints.fz[b] / 100, paramCheckPoints.z[b1] / 100) < i || i == -10) { i = py(paramCheckPoints.fx[b] / 100, paramCheckPoints.x[b1] / 100, paramCheckPoints.fz[b] / 100, paramCheckPoints.z[b1] / 100); this.fpnt[b] = b1; }
         
         } 
       }  for (b = 0; b < paramCheckPoints.fn; ) { this.fpnt[b] = this.fpnt[b] - 4; if (this.fpnt[b] < 0) this.fpnt[b] = this.fpnt[b] + paramCheckPoints.nsp;  b++; }
     
     } else {
       
       if (paramCheckPoints.stage == 19) { this.fpnt[0] = 14; this.fpnt[1] = 36; }
        if (paramCheckPoints.stage == 26) this.fpnt[3] = 39;
     
     } 
     
     this.left = false;
     this.right = false;
     this.up = false;
     this.down = false;
     this.handb = false;
     this.lookback = 0;
     this.arrace = false;
     this.mutem = false;
     this.mutes = false;
   }
 
 
   
   public void preform(Mad paramMad, ContO paramContO, CheckPoints paramCheckPoints, Trackers paramTrackers) {
     this.left = false;
     this.right = false;
     this.up = false;
     this.down = false;
     this.handb = false;
     
     if (!paramMad.dest) {
 
 
 
 
       
       if (paramMad.mtouch)
       {
         if (this.stcnt > this.statusque)
         
         { 
           
           int i = paramCheckPoints.stage; if (i > 10) i -= 10; 
           this.acuracy = (7 - paramCheckPoints.pos[paramMad.im]) * paramCheckPoints.pos[0] * (6 - i * 2);
           if (this.acuracy < 0 || paramCheckPoints.stage == -1) this.acuracy = 0;
 
 
           
           this.clrnce = 5;
           if (paramCheckPoints.stage == 16 || paramCheckPoints.stage == 21) this.clrnce = 2; 
           if (paramCheckPoints.stage == 22 && (paramMad.pcleared == 27 || paramMad.pcleared == 17)) this.clrnce = 3; 
           if (paramCheckPoints.stage == 26 && paramMad.pcleared == 33) this.clrnce = 3;
 
 
           
           float f = 0.0F;
           if (paramCheckPoints.stage == 1) f = 2.0F; 
           if (paramCheckPoints.stage == 2) f = 1.5F; 
           if (paramCheckPoints.stage == 3 && paramMad.cn != 6) f = 0.5F; 
           if (paramCheckPoints.stage == 4) f = 0.5F; 
           if (paramCheckPoints.stage == 11) f = 2.0F; 
           if (paramCheckPoints.stage == 12) f = 1.5F; 
           if (paramCheckPoints.stage == 13 && paramMad.cn != 9) f = 0.5F; 
           if (paramCheckPoints.stage == 14) f = 0.5F; 
           this.upwait = (int)(((paramCheckPoints.pos[0] - paramCheckPoints.pos[paramMad.im]) * (paramCheckPoints.pos[0] - paramCheckPoints.pos[paramMad.im]) * (paramCheckPoints.pos[0] - paramCheckPoints.pos[paramMad.im])) * f);
           if (this.upwait > 80) this.upwait = 80; 
           if ((paramCheckPoints.stage == 11 || paramCheckPoints.stage == 1) && this.upwait < 20) this.upwait = 20;
 
 
           
           f = 0.0F;
           if (paramCheckPoints.stage == 1 || paramCheckPoints.stage == 2) f = 1.0F; 
           if (paramCheckPoints.stage == 4) f = 0.5F; 
           if (paramCheckPoints.stage == 7) f = 0.5F; 
           if (paramCheckPoints.stage == 10) f = 0.5F; 
           if (paramCheckPoints.stage == 11 || paramCheckPoints.stage == 12) f = 1.0F; 
           if (paramCheckPoints.stage == 13) f = 0.5F; 
           if (paramCheckPoints.stage == 14) f = 0.5F; 
           if (paramCheckPoints.stage == 15) f = 0.2F; 
           if (paramCheckPoints.pos[paramMad.im] - paramCheckPoints.pos[0] >= -1) { this.skiplev = (float)(this.skiplev - 0.1D); if (this.skiplev < 0.0F) this.skiplev = 0.0F;  } else { this.skiplev = (float)(this.skiplev + 0.2D); if (this.skiplev > f) this.skiplev = f;
              }
           
           if (paramCheckPoints.stage == 18) if (paramMad.pcleared >= 10 && paramMad.pcleared <= 24) { this.skiplev = 1.0F; } else { this.skiplev = 0.0F; }
               if (paramCheckPoints.stage == 21) { this.skiplev = 0.0F; if (paramMad.pcleared == 5) this.skiplev = 1.0F;  if (paramMad.pcleared == 28 || paramMad.pcleared == 35) this.skiplev = 0.5F;  }
            if (paramCheckPoints.stage == 23) this.skiplev = 0.5F; 
           if (paramCheckPoints.stage == 24 || paramCheckPoints.stage == 22) this.skiplev = 1.0F; 
           if (paramCheckPoints.stage == 26 || paramCheckPoints.stage == 25 || paramCheckPoints.stage == 20) this.skiplev = 0.0F;
 
 
           
           this.rampp = (int)(this.m.random() * 4.0F - 2.0F);
           if (paramMad.power == 98.0F) this.rampp = -1; 
           if (paramMad.power < 75.0F && this.rampp == -1) this.rampp = 0; 
           if (paramMad.power < 60.0F) this.rampp = 1; 
           if (paramCheckPoints.stage == 6) this.rampp = 2; 
           if (paramCheckPoints.stage == 18 && paramMad.pcleared >= 45) this.rampp = 2; 
           if (paramCheckPoints.stage == 22 && paramMad.pcleared == 17) this.rampp = 2; 
           if (paramCheckPoints.stage == 25 || paramCheckPoints.stage == 26) this.rampp = 0;
 
 
           
           if (this.cntrn == 0)
           
           { this.agressed = false;
             this.turntyp = (int)(this.m.random() * 4.0F);
             if (paramCheckPoints.stage == 3 && paramMad.cn == 6) { this.turntyp = 1; if (this.attack == 0) this.agressed = true;  }
              if (paramCheckPoints.stage == 9 && paramMad.cn == 15) { this.turntyp = 1; if (this.attack == 0) this.agressed = true;  }
              if (paramCheckPoints.stage == 13 && paramMad.cn == 9) { this.turntyp = 1; if (this.attack == 0) this.agressed = true;  }
             
             if (paramCheckPoints.pos[0] - paramCheckPoints.pos[paramMad.im] < 0) this.turntyp = (int)(this.m.random() * 2.0F); 
             if (paramCheckPoints.stage == 10) this.turntyp = 2; 
             if (paramCheckPoints.stage == 18) this.turntyp = 2; 
             if (paramCheckPoints.stage == 20) this.turntyp = 0; 
             if (paramCheckPoints.stage == 23) this.turntyp = 1; 
             if (paramCheckPoints.stage == 24) this.turntyp = 0;
             
             if (this.attack != 0) {
               this.turntyp = 2;
               if (paramCheckPoints.stage == 9 || paramCheckPoints.stage == 10 || paramCheckPoints.stage == 19 || paramCheckPoints.stage == 21 || paramCheckPoints.stage == 23 || paramCheckPoints.stage == 27) this.turntyp = (int)(this.m.random() * 3.0F); 
               if (paramCheckPoints.stage == 26 && paramCheckPoints.clear[paramMad.im] - paramCheckPoints.clear[0] >= 5) this.turntyp = 0;
             
             } 
             if (paramCheckPoints.stage == 6) { this.turntyp = 1; this.agressed = true; }
              if (paramCheckPoints.stage == 7 || paramCheckPoints.stage == 9 || paramCheckPoints.stage == 10 || paramCheckPoints.stage == 16 || paramCheckPoints.stage == 17 || paramCheckPoints.stage == 19 || paramCheckPoints.stage == 20 || paramCheckPoints.stage == 21 || paramCheckPoints.stage == 22 || paramCheckPoints.stage == 24 || paramCheckPoints.stage == 26 || paramCheckPoints.stage == 27) this.agressed = true; 
             if (paramCheckPoints.stage == -1) if (this.m.random() > this.m.random()) { this.agressed = true; } else { this.agressed = false; }
                 this.cntrn = 5; }
           else { this.cntrn--; }
 
 
           
           this.saftey = (int)(((98.0F - paramMad.power) / 2.0F) * ((this.m.random() / 2.0F) + 0.5D));
           if (this.saftey > 20) this.saftey = 20;
 
           
           f = 0.0F;
           if (paramCheckPoints.stage == 1 || paramCheckPoints.stage == 11) f = 0.9F; 
           if (paramCheckPoints.stage == 2 || paramCheckPoints.stage == 12) f = 0.7F; 
           if (paramCheckPoints.stage == 4 || paramCheckPoints.stage == 13) f = 0.4F; 
           this.mustland = f + (float)((this.m.random() / 2.0F) - 0.25D);
 
           
           f = 1.0F;
           if (paramCheckPoints.stage == 1 || paramCheckPoints.stage == 11) f = 5.0F; 
           if (paramCheckPoints.stage == 2 || paramCheckPoints.stage == 12) f = 2.0F; 
           if (paramCheckPoints.stage == 4 || paramCheckPoints.stage == 13) f = 1.5F; 
           if (paramMad.power > 50.0F)
           
           { if (paramCheckPoints.pos[0] - paramCheckPoints.pos[paramMad.im] > 0) { this.saftey = (int)(this.saftey * f); } else { this.mustland = 0.0F; }  }
           else { this.mustland -= 0.5F; }
            if (paramCheckPoints.stage == 18 || paramCheckPoints.stage == 20 || paramCheckPoints.stage == 22 || paramCheckPoints.stage == 24) this.mustland = 0.0F;
 
           
           this.stuntf = 0;
           if (paramCheckPoints.stage == 8) this.stuntf = 17; 
           if (paramCheckPoints.stage == 18 && paramMad.pcleared == 57) this.stuntf = 1; 
           if (paramCheckPoints.stage == 19 && paramMad.pcleared == 3) this.stuntf = 2; 
           if (paramCheckPoints.stage == 20) if (paramCheckPoints.pos[0] < paramCheckPoints.pos[paramMad.im] || Math.abs(paramCheckPoints.clear[0] - paramMad.clear) >= 2 || paramMad.clear < 2) { this.stuntf = 4; this.saftey = 10; } else { this.stuntf = 3; }
               if (paramCheckPoints.stage == 21 && paramMad.pcleared == 21) this.stuntf = 1; 
           if (paramCheckPoints.stage == 24) { this.saftey = 10; if (paramMad.pcleared >= 4 && paramMad.pcleared < 70) { this.stuntf = 4; } else if (paramMad.cn == 12 || paramMad.cn == 8) { this.stuntf = 2; }  if (paramMad.cn == 14) this.stuntf = 6;  }
           
           if (paramCheckPoints.stage == 26) {
             
             this.mustland = 0.0F;
             this.saftey = 10;
             if ((paramMad.pcleared == 15 || paramMad.pcleared == 51) && (this.m.random() > 0.4D || this.trfix != 0)) this.stuntf = 7; 
             if (paramMad.pcleared == 42) this.stuntf = 1; 
             if (paramMad.pcleared == 77) this.stuntf = 7; 
             this.avoidnlev = (int)(2700.0F * this.m.random());
           } 
 
           
           this.trickprf = (paramMad.power - 38.0F) / 50.0F - this.m.random() / 2.0F;
           if (paramMad.power < 60.0F) this.trickprf = -1.0F; 
           if (paramCheckPoints.stage == 6 && this.trickprf > 0.5D) this.trickprf = 0.5F; 
           if (paramCheckPoints.stage == 3 && paramMad.cn == 6 && this.trickprf > 0.7D) this.trickprf = 0.7F; 
           if (paramCheckPoints.stage == 13 && paramMad.cn == 9 && this.trickprf > 0.7D) this.trickprf = 0.7F; 
           if (paramCheckPoints.stage == 16 && this.trickprf > 0.3D) this.trickprf = 0.3F; 
           if (paramCheckPoints.stage == 18 && this.trickprf > 0.2D) this.trickprf = 0.2F; 
           if (paramCheckPoints.stage == 19) { if (this.trickprf > 0.5D) this.trickprf = 0.5F;  if ((paramMad.im == 6 || paramMad.im == 5) && this.trickprf > 0.3D) this.trickprf = 0.3F;  }
            if (paramCheckPoints.stage == 21 && this.trickprf != -1.0F) this.trickprf *= 0.75F; 
           if (paramCheckPoints.stage == 22 && (paramMad.pcleared == 55 || paramMad.pcleared == 7)) { this.trickprf = -1.0F; this.stuntf = 5; }
            if (paramCheckPoints.stage == 23 && this.trickprf > 0.4D) this.trickprf = 0.4F; 
           if (paramCheckPoints.stage == 24 && this.trickprf > 0.5D) this.trickprf = 0.5F; 
           if (paramCheckPoints.stage == 27) this.trickprf = -1.0F;
 
           
           if (this.m.random() > paramMad.power / 100.0F) { this.usebounce = true; } else { this.usebounce = false; }
            if (paramCheckPoints.stage == 9) this.usebounce = false; 
           if (paramCheckPoints.stage == 14 || paramCheckPoints.stage == 16) this.usebounce = true; 
           if (paramCheckPoints.stage == 20 || paramCheckPoints.stage == 24) this.usebounce = false;
 
           
           if (this.m.random() > paramMad.hitmag / paramMad.cd.maxmag[paramMad.cn]) { this.perfection = false; } else { this.perfection = true; }
            if (100.0F * paramMad.hitmag / paramMad.cd.maxmag[paramMad.cn] > 60.0F) this.perfection = true; 
           if (paramCheckPoints.stage == 3 && paramMad.cn == 6) this.perfection = true; 
           if (paramCheckPoints.stage == 6 || paramCheckPoints.stage == 8 || paramCheckPoints.stage == 9 || paramCheckPoints.stage == 10 || paramCheckPoints.stage == 16 || paramCheckPoints.stage == 18 || paramCheckPoints.stage == 19 || paramCheckPoints.stage == 20 || paramCheckPoints.stage == 21 || paramCheckPoints.stage == 22 || paramCheckPoints.stage == 24 || paramCheckPoints.stage == 26 || paramCheckPoints.stage == 27) this.perfection = true;
 
 
           
           if (this.attack == 0) {
 
             
             boolean bool2 = true;
             if (paramCheckPoints.stage == 3 || paramCheckPoints.stage == 1 || paramCheckPoints.stage == 4 || paramCheckPoints.stage == 9 || paramCheckPoints.stage == 13 || paramCheckPoints.stage == 11 || paramCheckPoints.stage == 14 || paramCheckPoints.stage == 19 || paramCheckPoints.stage == 23 || paramCheckPoints.stage == 26) bool2 = this.afta; 
             if (paramCheckPoints.stage == 8 || paramCheckPoints.stage == 6 || paramCheckPoints.stage == 18 || paramCheckPoints.stage == 16 || paramCheckPoints.stage == 20 || paramCheckPoints.stage == 24) bool2 = false; 
             if (paramCheckPoints.stage == 3 && paramMad.cn == 6) bool2 = false; 
             if (paramCheckPoints.stage == -1 && this.m.random() > this.m.random()) bool2 = false;
 
             
             boolean bool3 = false;
             if (paramCheckPoints.stage == 13 && paramMad.cn == 9) bool3 = true; 
             if (paramCheckPoints.stage == 18 && paramMad.cn == 11) bool3 = true; 
             if (paramCheckPoints.stage == 19 && paramCheckPoints.clear[0] >= 20) bool3 = true; 
             if (paramCheckPoints.stage == 4 || paramCheckPoints.stage == 10 || paramCheckPoints.stage == 21 || paramCheckPoints.stage == 22 || paramCheckPoints.stage == 23 || paramCheckPoints.stage == 25 || paramCheckPoints.stage == 26) bool3 = true; 
             if (paramCheckPoints.stage == 3 && paramMad.cn == 6) bool3 = true;
 
             
             byte b1 = 60;
             
             if (paramCheckPoints.stage == 5) b1 = 40; 
             if (paramCheckPoints.stage == 6 && this.bulistc) b1 = 40; 
             if (paramCheckPoints.stage == 9 && this.bulistc) b1 = 30; 
             if (paramCheckPoints.stage == 3 || paramCheckPoints.stage == 13 || paramCheckPoints.stage == 21 || paramCheckPoints.stage == 27 || paramCheckPoints.stage == 20 || paramCheckPoints.stage == 18) b1 = 30; 
             if ((paramCheckPoints.stage == 12 || paramCheckPoints.stage == 23) && paramMad.cn == 13) b1 = 50; 
             if (paramCheckPoints.stage == 14) b1 = 20; 
             if (paramCheckPoints.stage == 15 && paramMad.im != 6) b1 = 40; 
             if (paramCheckPoints.stage == 17) b1 = 40; 
             if (paramCheckPoints.stage == 18 && paramMad.cn == 11) b1 = 40; 
             if (paramCheckPoints.stage == 19 && bool3) b1 = 30; 
             if (paramCheckPoints.stage == 21 && this.bulistc) b1 = 30; 
             if (paramCheckPoints.stage == 22) b1 = 50; 
             if (paramCheckPoints.stage == 25 && this.bulistc) b1 = 40; 
             if (paramCheckPoints.stage == 26) {
               
               if (paramMad.cn == 11 && paramCheckPoints.clear[0] == 27) b1 = 0; 
               if (paramMad.cn == 15 || paramMad.cn == 9) b1 = 50; 
               if (paramMad.cn == 11) b1 = 40; 
               if (paramCheckPoints.pos[0] > paramCheckPoints.pos[paramMad.im]) b1 = 80;
             
             } 
 
             
             for (byte b2 = 0; b2 < 7; b2++) {
               
               if (b2 != paramMad.im && paramCheckPoints.clear[b2] != -1) {
                 
                 int j = paramContO.xz; if (this.zyinv) j += 180;  for (; j < 0; j += 360); for (; j > 180; j -= 360); char c = Character.MIN_VALUE; if (paramCheckPoints.opx[b2] - paramContO.x >= 0) c = '´';  int k; for (k = (int)((90 + c) + Math.atan((paramCheckPoints.opz[b2] - paramContO.z) / (paramCheckPoints.opx[b2] - paramContO.x)) / 0.017453292519943295D); k < 0; k += 360); for (; k > 180; k -= 360); int m = Math.abs(j - k); if (m > 180) m = Math.abs(m - 360);
                 
                 int n = 2000 * (Math.abs(paramCheckPoints.clear[b2] - paramMad.clear) + 1);
                 if ((paramCheckPoints.stage == 6 || paramCheckPoints.stage == 9) && this.bulistc) n = 6000; 
                 if (paramCheckPoints.stage == 3 && paramMad.cn == 6 && paramCheckPoints.wasted < 2 && n > 4000) n = 4000;
                 
                 if (paramCheckPoints.stage == 13 && paramMad.cn == 9 && n < 12000) n = 12000; 
                 if (paramCheckPoints.stage == 14 && n < 4000) n = 4000; 
                 if (paramCheckPoints.stage == 18 && paramMad.cn == 11) { if (n < 12000) n = 12000;  m = 10; }
                  if (paramCheckPoints.stage == 19 && (paramMad.pcleared == 13 || paramMad.pcleared == 33 || bool3) && n < 12000) n = 12000; 
                 if (paramCheckPoints.stage == 21) if (this.bulistc) { n = 8000; m = 10; this.afta = true; } else if (n < 6000) { n = 6000; }
                     if (paramCheckPoints.stage == 22 && this.bulistc) { n = 6000; m = 10; }
                  if (paramCheckPoints.stage == 23) n = 21000; 
                 if (paramCheckPoints.stage == 25) { n *= Math.abs(paramCheckPoints.clear[b2] - paramMad.clear) + 1; if (this.bulistc) { n = 4000 * (Math.abs(paramCheckPoints.clear[b2] - paramMad.clear) + 1); m = 10; }  }
                  if (paramCheckPoints.stage == 20) n = 16000;
                 
                 if (paramCheckPoints.stage == 26) {
                   
                   if (paramMad.cn == 13 && this.bulistc) { if (this.oupnt == 33) n = 17000;  if (this.oupnt == 51) n = 30000;  if (this.oupnt == 15 && paramCheckPoints.clear[0] >= 14) n = 60000;  m = 10; }
                    if (paramMad.cn == 15 || paramMad.cn == 9) n *= Math.abs(paramCheckPoints.clear[b2] - paramMad.clear) + 1; 
                   if (paramMad.cn == 11) n = 4000 * (Math.abs(paramCheckPoints.clear[b2] - paramMad.clear) + 1);
                 
                 } 
                 
                 int i1 = 85 + 15 * (Math.abs(paramCheckPoints.clear[b2] - paramMad.clear) + 1);
                 if (paramCheckPoints.stage == 23) i1 = 45; 
                 if (paramCheckPoints.stage == 26 && (paramMad.cn == 15 || paramMad.cn == 9 || paramMad.cn == 11 || paramMad.cn == 14)) i1 = 50 + 70 * Math.abs(paramCheckPoints.clear[b2] - paramMad.clear);
                 
                 if (m < i1 && py(paramContO.x / 100, paramCheckPoints.opx[b2] / 100, paramContO.z / 100, paramCheckPoints.opz[b2] / 100) < n && this.afta && paramMad.power > b1) {
                   
                   float f1 = (35 - Math.abs(paramCheckPoints.clear[b2] - paramMad.clear) * 10); if (f1 < 1.0F) f1 = 1.0F; 
                   float f2 = ((paramCheckPoints.pos[paramMad.im] + 1) * (5 - paramCheckPoints.pos[b2])) / f1;
                   
                   if (paramCheckPoints.stage != 27 && f2 > 0.7D) f2 = 0.7F; 
                   if (b2 != 0 && paramCheckPoints.pos[0] < paramCheckPoints.pos[paramMad.im]) f2 = 0.0F; 
                   if (b2 != 0 && bool3) f2 = 0.0F;
                   
                   if (bool3 && paramCheckPoints.stage == 3 && b2 == 0) if (paramCheckPoints.wasted >= 2) { f2 *= 0.5F; } else { f2 = 0.0F; }
                       if ((paramCheckPoints.stage == 3 || paramCheckPoints.stage == 9) && b2 == 4) f2 = 0.0F; 
                   if (paramCheckPoints.stage == 6) { f2 = 0.0F; if (this.bulistc && b2 == 0) f2 = 1.0F;  }
                    if (paramCheckPoints.stage == 8) { f2 = 0.0F; if (this.bulistc && paramMad.cn != 11 && paramMad.cn != 13) f2 = 1.0F;  }
                    if (paramCheckPoints.stage == 9 && paramMad.cn == 15) f2 = 0.0F; 
                   if (paramCheckPoints.stage == 9 && this.bulistc) if (b2 == 0) { f2 = 1.0F; } else { f2 = 0.0F; }
                       if (paramCheckPoints.stage == 9 && (paramCheckPoints.pos[b2] == 4 || paramCheckPoints.pos[b2] == 3)) f2 = 0.0F;
                   
                   if (paramCheckPoints.stage == 13) if (paramMad.cn == 9 || (paramMad.cn == 13 && this.bulistc)) { f2 *= 2.0F; } else { f2 *= 0.5F; }
                       if (paramCheckPoints.stage == 16) f2 = 0.0F; 
                   if (paramCheckPoints.stage == 17 && paramMad.im == 6 && b2 == 0) f2 = (float)(f2 * 1.5D); 
                   if (paramCheckPoints.stage == 18) if (paramMad.cn == 11 || (paramMad.cn == 13 && this.bulistc)) { f2 *= 1.5F; } else { f2 = 0.0F; }
                       if (paramCheckPoints.stage == 19) { if (b2 != 0) f2 = (float)(f2 * 0.5D);  if (paramMad.pcleared != 13 && paramMad.pcleared != 33 && !bool3) f2 *= 0.5F;  if ((paramMad.im == 6 || paramMad.im == 5) && b2 != 0) f2 = 0.0F;  }
                    if (paramCheckPoints.stage == 20) { f2 = 0.0F; if (this.bulistc && paramMad.cn != 11 && paramMad.cn != 13) f2 = 1.0F;  }
                    if (paramCheckPoints.stage == 21 && this.bulistc && b2 == 0) f2 = 1.0F; 
                   if (paramCheckPoints.stage == 22) { if (paramMad.cn != 11 && paramMad.cn != 13) f2 = 0.0F;  if (paramMad.cn == 13 && b2 == 0) f2 = 1.0F;  }
                    if (paramCheckPoints.stage == 24) f2 = 0.0F; 
                   if (paramCheckPoints.stage == 25) { if (paramCheckPoints.pos[paramMad.im] == 0) f2 = (float)(f2 * 0.5D);  if (paramCheckPoints.pos[0] < paramCheckPoints.pos[paramMad.im]) f2 *= 2.0F;  if (this.bulistc && b2 == 0) f2 = 1.0F;  }
                    if (paramCheckPoints.stage == 26) {
                     
                     if (paramMad.cn != 14) { if (paramCheckPoints.pos[0] < paramCheckPoints.pos[paramMad.im] && paramCheckPoints.clear[0] - paramCheckPoints.clear[paramMad.im] != 1) f2 *= 2.0F;  } else { f2 = (float)(f2 * 0.5D); }
                      if (paramMad.cn == 13 && b2 == 0) f2 = 1.0F; 
                     if (paramCheckPoints.pos[paramMad.im] == 0 || (paramCheckPoints.pos[paramMad.im] == 1 && paramCheckPoints.pos[0] == 0)) f2 = 0.0F; 
                     if (paramCheckPoints.clear[paramMad.im] - paramCheckPoints.clear[0] >= 5 && b2 == 0) f2 = 1.0F; 
                     if (paramMad.cn == 10 || paramMad.cn == 12) f2 = 0.0F;
                   
                   } 
                   
                   if (this.m.random() < f2) {
                     
                     this.attack = 40 * (Math.abs(paramCheckPoints.clear[b2] - paramMad.clear) + 1);
                     if (this.attack > 500) this.attack = 500; 
                     this.aim = 0.0F;
                     if (paramCheckPoints.stage == 13 && paramMad.cn == 9 && this.m.random() > this.m.random()) this.aim = 1.0F; 
                     if (paramCheckPoints.stage == 14) if (b2 == 0 && paramCheckPoints.pos[0] < paramCheckPoints.pos[paramMad.im]) { this.aim = 1.5F; } else { this.aim = this.m.random(); }
                         if (paramCheckPoints.stage == 15) this.aim = this.m.random() * 1.5F; 
                     if (paramCheckPoints.stage == 17 && paramMad.im != 6 && (this.m.random() > this.m.random() || paramCheckPoints.pos[0] < paramCheckPoints.pos[paramMad.im])) this.aim = 1.0F; 
                     if (paramCheckPoints.stage == 18 && paramMad.cn == 11 && this.m.random() > this.m.random()) this.aim = 0.76F + this.m.random() * 0.76F; 
                     if (paramCheckPoints.stage == 19 && (paramMad.pcleared == 13 || paramMad.pcleared == 33)) this.aim = 1.0F; 
                     if (paramCheckPoints.stage == 21) if (this.bulistc) { this.aim = 0.7F; if (this.attack > 150) this.attack = 150;  } else { this.aim = this.m.random(); }
                         if (paramCheckPoints.stage == 22) { if (this.m.random() > this.m.random()) this.aim = 0.7F;  if (this.bulistc && this.attack > 150) this.attack = 150;  }
                      if (paramCheckPoints.stage == 23 && this.attack > 60) this.attack = 60; 
                     if (paramCheckPoints.stage == 25) { this.aim = this.m.random() * 1.5F; this.attack /= 2; if (this.m.random() > this.m.random()) { this.exitattack = true; } else { this.exitattack = false; }  }
                      if (paramCheckPoints.stage == 26) if (paramMad.cn == 13) { this.aim = 0.76F; this.attack = 150; } else { this.aim = this.m.random() * 1.5F; if (Math.abs(paramCheckPoints.clear[b2] - paramMad.clear) <= 2 || paramMad.cn == 14) this.attack /= 3;  }
                         if (paramCheckPoints.stage == -1 && this.m.random() > this.m.random()) this.aim = this.m.random() * 1.5F; 
                     this.acr = b2;
                     this.turntyp = (int)(1.0F + this.m.random() * 2.0F);
                   } 
                 } 
                 
                 if (bool2 && m > 100 && py(paramContO.x / 100, paramCheckPoints.opx[b2] / 100, paramContO.z / 100, paramCheckPoints.opz[b2] / 100) < 300 && this.m.random() > 0.6D - (paramCheckPoints.pos[paramMad.im] / 10.0F)) { this.clrnce = 0; this.acuracy = 0; }
               
               } 
             } 
           } 
 
           
           boolean bool1 = false;
           if (paramCheckPoints.stage == 6 || paramCheckPoints.stage == 8) bool1 = true; 
           if (paramCheckPoints.stage == 9 && paramMad.cn == 15) bool1 = true; 
           if (paramCheckPoints.stage == 16 || paramCheckPoints.stage == 20 || paramCheckPoints.stage == 21 || paramCheckPoints.stage == 27) bool1 = true; 
           if (paramCheckPoints.stage == 18 && paramMad.pcleared != 73) bool1 = true; 
           if (paramCheckPoints.stage == -1 && this.m.random() > this.m.random()) bool1 = true;
 
 
 
 
 
           
           if (this.trfix != 3) {
             
             this.trfix = 0;
             byte b = 50;
             if (paramCheckPoints.stage == 26) b = 40; 
             if (100.0F * paramMad.hitmag / paramMad.cd.maxmag[paramMad.cn] > b) this.trfix = 1; 
             if (!bool1) {
               
               byte b1 = 80;
               if (paramCheckPoints.stage == 18 && paramMad.cn != 11) b1 = 50; 
               if (paramCheckPoints.stage == 19) b1 = 70; 
               if (paramCheckPoints.stage == 25 && paramMad.pcleared == 91) b1 = 50; 
               if (paramCheckPoints.stage == 26 && paramCheckPoints.clear[paramMad.im] - paramCheckPoints.clear[0] >= 5 && paramMad.cn != 10 && paramMad.cn != 12) b1 = 50; 
               if (100.0F * paramMad.hitmag / paramMad.cd.maxmag[paramMad.cn] > b1) this.trfix = 2;
             
             } 
           } else {
             
             this.upwait = 0;
             this.acuracy = 0;
             this.skiplev = 1.0F;
             this.clrnce = 2;
           } 
 
 
           
           if (!this.bulistc)
           
           { if (paramCheckPoints.stage == 18 && paramMad.cn == 11 && paramMad.pcleared == 35) { paramMad.pcleared = 73; paramMad.clear = 0; this.bulistc = true; this.runbul = (int)(100.0F * this.m.random()); }
              if (paramCheckPoints.stage == 21 && paramMad.cn == 13) this.bulistc = true; 
             if (paramCheckPoints.stage == 22 && paramMad.cn == 13) this.bulistc = true; 
             if (paramCheckPoints.stage == 25 && paramCheckPoints.clear[0] - paramMad.clear >= 3 && this.trfix == 0) { this.bulistc = true; this.oupnt = -1; }
             
             if (paramCheckPoints.stage == 26) {
               
               if (paramMad.cn == 13 && paramCheckPoints.pcleared == 8) { this.bulistc = true; this.attack = 0; }
                if (paramMad.cn == 11 && paramCheckPoints.clear[0] - paramMad.clear >= 2 && this.trfix == 0) { this.bulistc = true; this.oupnt = -1; }
             
             } 
             
             if (paramCheckPoints.stage == 6 || paramCheckPoints.stage == 8 || paramCheckPoints.stage == 12 || paramCheckPoints.stage == 13 || paramCheckPoints.stage == 14 || paramCheckPoints.stage == 15 || paramCheckPoints.stage == 18 || paramCheckPoints.stage == 20 || paramCheckPoints.stage == 23)
             {
               if (paramMad.cn == 13 && Math.abs(paramCheckPoints.clear[0] - paramMad.clear) >= 2) this.bulistc = true;
             
             }
             
             if (paramCheckPoints.stage == 8 || paramCheckPoints.stage == 20)
             {
               if (paramMad.cn == 11 && Math.abs(paramCheckPoints.clear[0] - paramMad.clear) >= 1) this.bulistc = true;
             
             }
             
             if (paramCheckPoints.stage == 6 && paramMad.cn == 11) this.bulistc = true; 
             if (paramCheckPoints.stage == 9 && this.afta && (paramCheckPoints.pos[paramMad.im] == 4 || paramCheckPoints.pos[paramMad.im] == 3) && paramMad.cn != 15 && this.trfix != 0) this.bulistc = true;
             
             
              }
           
           else if (paramCheckPoints.stage == 18) { this.runbul--; if (paramMad.pcleared == 10) this.runbul = 0;  if (this.runbul <= 0) this.bulistc = false;
              }
 
           
           this.stcnt = 0;
           this.statusque = (int)(20.0F * this.m.random()); }
         else { this.stcnt++; }
       
       }
 
 
 
 
 
 
       
       boolean bool = false;
       if (this.usebounce) { bool = paramMad.wtouch; } else { bool = paramMad.mtouch; }
       
       if (bool) {
         
         if (this.trickfase != 0) this.trickfase = 0; 
         if (this.trfix == 2 || this.trfix == 3) this.attack = 0;
 
 
         
         if (this.attack == 0) {
           
           if (this.upcnt < 30) if (this.revstart <= 0) { this.up = true; } else { this.down = true; this.revstart--; }
               if (this.upcnt < 25 + this.actwait) { this.upcnt++; } else { this.upcnt = 0; this.actwait = this.upwait; }
            int j = paramMad.point;
           byte b = 50;
           if (paramCheckPoints.stage == 9) b = 20; 
           if (paramCheckPoints.stage == 18) b = 20; 
           if (paramCheckPoints.stage == 25) b = 40; 
           if (paramCheckPoints.stage == 26) b = 20;
 
 
           
           if (!this.bulistc || this.trfix == 2 || this.trfix == 3 || this.trfix == 4 || paramMad.power < b) {
 
             
             if (this.rampp == 1 && paramCheckPoints.typ[j] <= 0) { int k = j + 1; if (k >= paramCheckPoints.n) k = 0;  if (paramCheckPoints.typ[k] == -2) j = k;  }
              if (this.rampp == -1 && paramCheckPoints.typ[j] == -2 && ++j >= paramCheckPoints.n) j = 0; 
             if (this.m.random() > this.skiplev) { int k = j; boolean bool1 = false; if (paramCheckPoints.typ[k] > 0) { byte b1; byte b2; for (b1 = 0, b2 = 0; b2 < paramCheckPoints.n; ) { if (paramCheckPoints.typ[b2] > 0 && b2 < k) b1++;  b2++; }  bool1 = (paramMad.clear != b1 + paramMad.nlaps * paramCheckPoints.nsp) ? true : false; }  while (paramCheckPoints.typ[k] == 0 || paramCheckPoints.typ[k] == -1 || paramCheckPoints.typ[k] == -3 || bool1) { j = k; if (++k >= paramCheckPoints.n) k = 0;  bool1 = false; if (paramCheckPoints.typ[k] > 0) { byte b1; byte b2; for (b1 = 0, b2 = 0; b2 < paramCheckPoints.n; ) { if (paramCheckPoints.typ[b2] > 0 && b2 < k) b1++;  b2++; }  bool1 = (paramMad.clear != b1 + paramMad.nlaps * paramCheckPoints.nsp) ? true : false; }  }  } else if (this.m.random() > this.skiplev) { while (paramCheckPoints.typ[j] == -1) { if (++j >= paramCheckPoints.n) j = 0;
                  }
                }
             
             if (paramCheckPoints.stage == 18 && paramMad.pcleared == 73 && this.trfix == 0 && paramMad.clear != 0) j = 10; 
             if (paramCheckPoints.stage == 19 && paramMad.pcleared == 18 && this.trfix == 0) j = 27; 
             if (paramCheckPoints.stage == 21) { if (paramMad.pcleared == 5 && this.trfix == 0 && paramMad.power < 70.0F) if (j <= 16) { j = 16; } else { j = 21; }   if (paramMad.pcleared == 50) j = 57;  }
              if (paramCheckPoints.stage == 22 && (paramMad.pcleared == 27 || paramMad.pcleared == 37)) while (paramCheckPoints.typ[j] == -1) { if (++j >= paramCheckPoints.n) j = 0;  }
                 if (paramCheckPoints.stage == 23) while (paramCheckPoints.typ[j] == -1) { if (++j >= paramCheckPoints.n) j = 0;  }
                 if (paramCheckPoints.stage == 24) { while (paramCheckPoints.typ[j] == -1) { if (++j >= paramCheckPoints.n) j = 0;  }  if (!paramMad.gtouch) while (paramCheckPoints.typ[j] == -2) { if (++j >= paramCheckPoints.n) j = 0;  }   if (this.oupnt >= 68) { j = 70; } else { this.oupnt = j; }  }
              if (paramCheckPoints.stage == 25) { if ((paramMad.pcleared != 91 && paramCheckPoints.pos[0] < paramCheckPoints.pos[paramMad.im] && paramMad.cn != 13) || (paramCheckPoints.pos[paramMad.im] == 0 && (paramMad.clear == 12 || paramMad.clear == 20))) while (paramCheckPoints.typ[j] == -4) { if (++j >= paramCheckPoints.n) j = 0;  }   if (paramMad.pcleared == 9) { if (py(paramContO.x / 100, 297, paramContO.z / 100, 347) < 400) this.oupnt = 1;  if (this.oupnt == 1 && j < 22) j = 22;  }  if (paramMad.pcleared == 67) { if (py(paramContO.x / 100, 28, paramContO.z / 100, 494) < 4000) this.oupnt = 2;  if (this.oupnt == 2) j = 76;  }  if (paramMad.pcleared == 76) { if (py(paramContO.x / 100, -50, paramContO.z / 100, 0) < 2000) this.oupnt = 3;  if (this.oupnt == 3) { j = 91; } else { j = 89; }  }  }
              if (paramCheckPoints.stage == 26) {
               
               if (paramMad.pcleared == 128) { if (py(paramContO.x / 100, 0, paramContO.z / 100, 229) < 1500 || paramContO.z > 23000) this.oupnt = 128;  if (this.oupnt != 128) j = 3;  }
                if (paramMad.pcleared == 8) { if (py(paramContO.x / 100, -207, paramContO.z / 100, 549) < 1500 || paramContO.x < -20700) this.oupnt = 8;  if (this.oupnt != 8) j = 12;  }
                if (paramMad.pcleared == 33) { if (py(paramContO.x / 100, -60, paramContO.z / 100, 168) < 250 || paramContO.z > 17000) this.oupnt = 331;  if (py(paramContO.x / 100, -112, paramContO.z / 100, 414) < 10000 || paramContO.z > 40000) this.oupnt = 332;  if (this.oupnt != 331 && this.oupnt != 332) if (this.trfix != 1) { j = 38; } else { j = 39; }   if (this.oupnt == 331) j = 71;  }
                if (paramMad.pcleared == 42) { if (py(paramContO.x / 100, -269, paramContO.z / 100, 493) < 100 || paramContO.x < -27000) this.oupnt = 142;  if (this.oupnt != 142) j = 47;  }
                if (paramMad.pcleared == 51) { if (py(paramContO.x / 100, -352, paramContO.z / 100, 260) < 100 || paramContO.z < 25000) this.oupnt = 511;  if (py(paramContO.x / 100, -325, paramContO.z / 100, 10) < 2000 || paramContO.x > -32000) this.oupnt = 512;  if (this.oupnt != 511 && this.oupnt != 512) j = 80;  if (this.oupnt == 511) j = 61;  }
                if (paramMad.pcleared == 77) { if (py(paramContO.x / 100, -371, paramContO.z / 100, 319) < 100 || paramContO.z < 31000) this.oupnt = 77;  if (this.oupnt != 77) { j = 78; paramMad.nofocus = true; }  }
                if (paramMad.pcleared == 105) { if (py(paramContO.x / 100, -179, paramContO.z / 100, 10) < 2300 || paramContO.z < 1050) this.oupnt = 105;  if (this.oupnt != 105) { j = 65; } else { j = 125; }  }
                if (this.trfix == 3) { if (py(paramContO.x / 100, -52, paramContO.z / 100, 448) < 100 || paramContO.z > 45000) this.oupnt = 176;  if (this.oupnt != 176) { j = 41; } else { j = 43; }
                  }
                if (paramCheckPoints.clear[paramMad.im] - paramCheckPoints.clear[0] >= 2 && py(paramContO.x / 100, paramCheckPoints.opx[0] / 100, paramContO.z / 100, paramCheckPoints.opz[0] / 100) < 1000 + this.avoidnlev) {
                 
                 int k = paramContO.xz; if (this.zyinv) k += 180;  for (; k < 0; k += 360); for (; k > 180; k -= 360); char c = Character.MIN_VALUE; if (paramCheckPoints.opx[0] - paramContO.x >= 0) c = '´';  int m; for (m = (int)((90 + c) + Math.atan((paramCheckPoints.opz[0] - paramContO.z) / (paramCheckPoints.opx[0] - paramContO.x)) / 0.017453292519943295D); m < 0; m += 360); for (; m > 180; m -= 360); int n = Math.abs(k - m); if (n > 180) n = Math.abs(n - 360); 
                 if (n < 90) this.wall = 0;
               
               } 
             } 
             if (this.rampp == 2) { int k = j + 1; if (k >= paramCheckPoints.n) k = 0;  if (paramCheckPoints.typ[k] == -2 && j != paramMad.point && --j < 0) j += paramCheckPoints.n;  }
              if (this.bulistc) { paramMad.nofocus = true; if (this.gowait) this.gowait = false;
                }
 
           
           } else {
             
             if ((paramCheckPoints.stage != 25 && paramCheckPoints.stage != 26) || this.runbul == 0) {
               
               j -= 2;
               if (j < 0) j += paramCheckPoints.n; 
               if (paramCheckPoints.stage == 9 && j > 76) j = 76; 
               while (paramCheckPoints.typ[j] == -4) { if (--j < 0) j += paramCheckPoints.n;  }
             
             } 
             if (paramCheckPoints.stage == 21) { if (j >= 14 && j <= 19) j = 13;  if (this.oupnt == 72 && j != 56) { j = 57; } else if (this.oupnt == 54 && j != 52) { j = 53; } else if (this.oupnt == 39 && j != 37) { j = 38; } else { this.oupnt = j; }
                }
              if (paramCheckPoints.stage == 22) {
               
               if (!this.gowait) {
                 
                 if (paramCheckPoints.clear[0] == 0) { this.wtx = -3500; this.wtz = 19000; this.frx = -3500; this.frz = 39000; this.frad = 12000; this.oupnt = 37; this.gowait = true; this.afta = false; }
                  if (paramCheckPoints.clear[0] == 7) { this.wtx = -44800; this.wtz = 40320; this.frx = -44800; this.frz = 34720; this.frad = 30000; this.oupnt = 27; this.gowait = true; this.afta = false; }
                  if (paramCheckPoints.clear[0] == 10) { this.wtx = 0; this.wtz = 48739; this.frx = 0; this.frz = 38589; this.frad = 90000; this.oupnt = 55; this.gowait = true; this.afta = false; }
                  if (paramCheckPoints.clear[0] == 14) { this.wtx = -3500; this.wtz = 19000; this.frx = -14700; this.frz = 39000; this.frad = 45000; this.oupnt = 37; this.gowait = true; this.afta = false; }
                  if (paramCheckPoints.clear[0] == 18) { this.wtx = -48300; this.wtz = -4550; this.frx = -48300; this.frz = 5600; this.frad = 90000; this.oupnt = 17; this.gowait = true; this.afta = false; }
               
               }  if (this.gowait) {
                 
                 if (py(paramContO.x / 100, this.wtx / 100, paramContO.z / 100, this.wtz / 100) < 10000 && paramMad.speed > 50.0F) this.up = false; 
                 if (py(paramContO.x / 100, this.wtx / 100, paramContO.z / 100, this.wtz / 100) < 200) { this.up = false; this.handb = true; }
                  if (paramCheckPoints.pcleared == this.oupnt && py(paramCheckPoints.opx[0] / 100, this.frx / 100, paramCheckPoints.opz[0] / 100, this.frz / 100) < this.frad) { this.afta = true; this.gowait = false; }
                  if (py(paramContO.x / 100, paramCheckPoints.opx[0] / 100, paramContO.z / 100, paramCheckPoints.opz[0] / 100) < 25) { this.afta = true; this.gowait = false; this.attack = 200; this.acr = 0; }
               
               } 
             } 
             if (paramCheckPoints.stage == 25) {
               
               if (this.oupnt == -1) { int k; byte b1; for (k = -10, b1 = 0; b1 < paramCheckPoints.n; ) { if ((paramCheckPoints.typ[b1] == -2 || paramCheckPoints.typ[b1] == -4) && (b1 < 50 || b1 > 54) && (py(paramContO.x / 100, paramCheckPoints.x[b1] / 100, paramContO.z / 100, paramCheckPoints.z[b1] / 100) < k || k == -10)) { k = py(paramContO.x / 100, paramCheckPoints.x[b1] / 100, paramContO.z / 100, paramCheckPoints.z[b1] / 100); this.oupnt = b1; }  b1++; }  this.oupnt--; if (j < 0) this.oupnt += paramCheckPoints.n;  }
                if (this.oupnt >= 0 && this.oupnt < paramCheckPoints.n) { j = this.oupnt; if (py(paramContO.x / 100, paramCheckPoints.x[j] / 100, paramContO.z / 100, paramCheckPoints.z[j] / 100) < 800) { this.oupnt = -((int)(75.0F + this.m.random() * 200.0F)); this.runbul = (int)(50.0F + this.m.random() * 100.0F); }  }
                if (this.oupnt < -1) this.oupnt++; 
               if (this.runbul != 0) this.runbul--;
             
             } 
             
             if (paramCheckPoints.stage == 26) {
               
               boolean bool1 = false;
               if (paramMad.cn == 13) {
                 
                 if (!this.gowait) {
                   
                   if (paramCheckPoints.clear[0] == 1) { if (this.m.random() > 0.5D) { this.wtx = -14000; this.wtz = 48000; this.frx = -5600; this.frz = 47600; this.frad = 88000; this.oupnt = 33; } else { this.wtx = -5600; this.wtz = 8000; this.frx = -7350; this.frz = -4550; this.frad = 22000; this.oupnt = 15; }  this.gowait = true; this.afta = false; }
                    if (paramCheckPoints.clear[0] == 4) { this.wtx = -12700; this.wtz = 14000; this.frx = -31000; this.frz = 1050; this.frad = 11000; this.oupnt = 51; this.gowait = true; this.afta = false; }
                    if (paramCheckPoints.clear[0] == 14) { this.wtx = -35350; this.wtz = 6650; this.frx = -48300; this.frz = 54950; this.frad = 11000; this.oupnt = 15; this.gowait = true; this.afta = false; }
                    if (paramCheckPoints.clear[0] == 17) { this.wtx = -42700; this.wtz = 41000; this.frx = -40950; this.frz = 49350; this.frad = 7000; this.oupnt = 42; this.gowait = true; this.afta = false; }
                    if (paramCheckPoints.clear[0] == 21) { this.wtx = -1750; this.wtz = -15750; this.frx = -25900; this.frz = -14000; this.frad = 11000; this.oupnt = 125; this.gowait = true; this.afta = false; }
                 
                 }  if (this.gowait) {
                   
                   if (py(paramContO.x / 100, this.wtx / 100, paramContO.z / 100, this.wtz / 100) < 10000 && paramMad.speed > 50.0F) this.up = false; 
                   if (py(paramContO.x / 100, this.wtx / 100, paramContO.z / 100, this.wtz / 100) < 200) { this.up = false; this.handb = true; }
                    if (paramCheckPoints.pcleared == this.oupnt && py(paramCheckPoints.opx[0] / 100, this.frx / 100, paramCheckPoints.opz[0] / 100, this.frz / 100) < this.frad) { this.runbul = 0; this.afta = true; this.gowait = false; }
                    if (py(paramContO.x / 100, paramCheckPoints.opx[0] / 100, paramContO.z / 100, paramCheckPoints.opz[0] / 100) < 25) { this.afta = true; this.gowait = false; this.attack = 200; this.acr = 0; }
                    if (paramCheckPoints.clear[0] == 21 && this.oupnt != 125) this.gowait = false; 
                 } 
                 if ((paramCheckPoints.clear[0] >= 11 && !this.gowait) || (paramMad.power < 60.0F && paramCheckPoints.clear[0] < 21)) { bool1 = true; if (!this.exitattack) { this.oupnt = -1; this.exitattack = true; }  } else if (this.exitattack) { this.exitattack = false; }
               
               }  if (paramMad.cn == 11) bool1 = true; 
               if (bool1) {
                 
                 if (this.oupnt == -1) { int k; byte b1; for (k = -10, b1 = 0; b1 < paramCheckPoints.n; ) { if (paramCheckPoints.typ[b1] == -4 && ((py(paramContO.x / 100, paramCheckPoints.x[b1] / 100, paramContO.z / 100, paramCheckPoints.z[b1] / 100) < k && this.m.random() > 0.6D) || k == -10)) { k = py(paramContO.x / 100, paramCheckPoints.x[b1] / 100, paramContO.z / 100, paramCheckPoints.z[b1] / 100); this.oupnt = b1; }  b1++; }  this.oupnt--; if (j < 0) this.oupnt += paramCheckPoints.n;  }
                  if (this.oupnt >= 0 && this.oupnt < paramCheckPoints.n) { j = this.oupnt; if (py(paramContO.x / 100, paramCheckPoints.x[j] / 100, paramContO.z / 100, paramCheckPoints.z[j] / 100) < 800) { this.oupnt = -((int)(75.0F + this.m.random() * 200.0F)); this.runbul = (int)(50.0F + this.m.random() * 100.0F); }  }
                  if (this.oupnt < -1) this.oupnt++; 
                 if (this.runbul != 0) this.runbul--;
               
               } 
             } 
             paramMad.nofocus = true;
           } 
           
           if (paramCheckPoints.stage != 27) {
 
 
             
             if (paramCheckPoints.stage == 10 || paramCheckPoints.stage == 19 || (paramCheckPoints.stage == 18 && paramMad.pcleared == 73) || paramCheckPoints.stage == 26) this.forget = true;
             
             if (paramMad.missedcp == 0 || this.forget || this.trfix == 4)
             {
               if (this.trfix != 0) {
                 
                 byte b1 = 0;
                 if (paramCheckPoints.stage == 25 || paramCheckPoints.stage == 26) b1 = 3;
                 
                 if (this.trfix == 2) {
                   int k; byte b3; byte b4;
                   for (k = -10, b3 = 0, b4 = b1; b4 < paramCheckPoints.fn; ) { if (py(paramContO.x / 100, paramCheckPoints.x[this.fpnt[b4]] / 100, paramContO.z / 100, paramCheckPoints.z[this.fpnt[b4]] / 100) < k || k == -10) { k = py(paramContO.x / 100, paramCheckPoints.x[this.fpnt[b4]] / 100, paramContO.z / 100, paramCheckPoints.z[this.fpnt[b4]] / 100); b3 = b4; }  b4++; }
                    if (paramCheckPoints.stage == 18 || paramCheckPoints.stage == 22) b3 = 1;  j = this.fpnt[b3];
                   if (paramCheckPoints.special[b3]) { this.forget = true; } else { this.forget = false; }
                 
                 } 
                 for (byte b2 = b1; b2 < paramCheckPoints.fn; ) { if (py(paramContO.x / 100, paramCheckPoints.x[this.fpnt[b2]] / 100, paramContO.z / 100, paramCheckPoints.z[this.fpnt[b2]] / 100) < 2000) { this.forget = false; this.actwait = 0; this.upwait = 0; this.turntyp = 2; this.randtcnt = -1; this.acuracy = 0; this.rampp = 0; this.trfix = 3; }  b2++; }
                  if (this.trfix == 3) paramMad.nofocus = true;
               
               } 
             }
           } 
 
           
           if (this.turncnt > this.randtcnt)
           
           { if (!this.gowait) {
               
               char c = Character.MIN_VALUE;
               if (paramCheckPoints.x[j] - paramContO.x >= 0) c = '´'; 
               this.pan = (int)((90 + c) + Math.atan((paramCheckPoints.z[j] - paramContO.z) / (paramCheckPoints.x[j] - paramContO.x)) / 0.017453292519943295D);
             } else {
               char c = Character.MIN_VALUE;
               if (this.wtx - paramContO.x >= 0) c = '´'; 
               this.pan = (int)((90 + c) + Math.atan((this.wtz - paramContO.z) / (this.wtx - paramContO.x)) / 0.017453292519943295D);
             } 
             this.turncnt = 0;
             this.randtcnt = (int)(this.acuracy * this.m.random()); }
           else { this.turncnt++;
              }
 
         
         }
         else {
           
           this.up = true;
           char c = Character.MIN_VALUE;
           int j = (int)(pys(paramContO.x, paramCheckPoints.opx[this.acr], paramContO.z, paramCheckPoints.opz[this.acr]) / 2.0F * this.aim);
           int k = (int)(paramCheckPoints.opx[this.acr] - j * this.m.sin(paramCheckPoints.omxz[this.acr]));
           int m = (int)(paramCheckPoints.opz[this.acr] + j * this.m.cos(paramCheckPoints.omxz[this.acr]));
           if (k - paramContO.x >= 0) c = '´'; 
           this.pan = (int)((90 + c) + Math.atan((m - paramContO.z) / (k - paramContO.x)) / 0.017453292519943295D);
           this.attack--;
           if (this.attack <= 0) this.attack = 0; 
           if (paramCheckPoints.stage == 25 && this.exitattack && !this.bulistc && paramMad.missedcp != 0) this.attack = 0; 
           if (paramCheckPoints.stage == 26 && paramMad.cn == 13 && (paramCheckPoints.clear[0] == 4 || paramCheckPoints.clear[0] == 13 || paramCheckPoints.clear[0] == 21)) this.attack = 0; 
           if (paramCheckPoints.stage == 26 && paramMad.missedcp != 0 && (paramCheckPoints.pos[paramMad.im] == 0 || (paramCheckPoints.pos[paramMad.im] == 1 && paramCheckPoints.pos[0] == 0))) this.attack = 0; 
           if (paramCheckPoints.stage == 26 && paramCheckPoints.pos[0] > paramCheckPoints.pos[paramMad.im] && paramMad.power < 80.0F) this.attack = 0;
         
         } 
 
 
         
         int i = paramContO.xz;
         if (this.zyinv) i += 180; 
         for (; i < 0; i += 360);
         for (; i > 180; i -= 360);
         for (; this.pan < 0; this.pan += 360);
         for (; this.pan > 180; this.pan -= 360);
         
         if (this.wall != -1 && this.hold == 0) this.clrnce = 0; 
         if (this.hold == 0)
         {
           if (Math.abs(i - this.pan) < 180) { if (Math.abs(i - this.pan) > this.clrnce)
             
             { if (i < this.pan) { this.left = true; this.lastl = true; } else { this.right = true; this.lastl = false; }
                if (Math.abs(i - this.pan) > 50 && paramMad.speed > paramMad.cd.swits[paramMad.cn][0] && this.turntyp != 0) { if (this.turntyp == 1) this.down = true;  if (this.turntyp == 2) this.handb = true;  if (!this.agressed) this.up = false;  }  }  }
           else if (Math.abs(i - this.pan) < 360 - this.clrnce)
           
           { if (i < this.pan) { this.right = true; this.lastl = false; } else { this.left = true; this.lastl = true; }
              if (Math.abs(i - this.pan) < 310 && paramMad.speed > paramMad.cd.swits[paramMad.cn][0] && this.turntyp != 0) { if (this.turntyp == 1) this.down = true;  if (this.turntyp == 2) this.handb = true;  if (!this.agressed) this.up = false;
                }
              }
         
         }
 
         
         if (paramCheckPoints.stage == 24)
         {
           if (this.wall != -1) {
             
             if (paramTrackers.dam[this.wall] == 0 || paramMad.pcleared == 45) this.wall = -1; 
             if (paramMad.pcleared == 58 && paramCheckPoints.opz[paramMad.im] < 36700) { this.wall = -1; this.hold = 0; }
           
           } 
         }
         if (this.wall != -1)
         
         { if (this.lwall != this.wall) { if (this.lastl) { this.left = true; } else { this.right = true; }  this.wlastl = this.lastl; this.lwall = this.wall; } else if (this.wlastl) { this.left = true; } else { this.right = true; }
           
           if (paramTrackers.dam[this.wall] != 0)
           
           { byte b = 1; if (paramTrackers.skd[this.wall] == 1) b = 3;  this.hold += b; if (this.hold > 10 * b) this.hold = 10 * b;  }
           else { this.hold = 1; }
           
           this.wall = -1; }
         else if (this.hold != 0) { this.hold--; }
 
       
       }
       else {
         
         if (this.trickfase == 0) {
           
           int i = (int)((paramMad.scy[0] + paramMad.scy[1] + paramMad.scy[2] + paramMad.scy[3]) * (paramContO.y - 300) / 4000.0F);
           byte b = 3;
           if (paramCheckPoints.stage == 25) b = 10; 
           if (i > 7 && (this.m.random() > this.trickprf / b || this.stuntf == 4 || this.stuntf == 3 || this.stuntf == 5 || this.stuntf == 6 || paramCheckPoints.stage == 26)) {
             
             this.oxy = paramMad.pxy;
             this.ozy = paramMad.pzy;
             this.flycnt = 0;
             this.uddirect = 0;
             this.lrdirect = 0;
             this.udswt = false;
             this.lrswt = false;
             this.trickfase = 1;
             
             if (i < 16) {
               
               if (this.stuntf != 6) { this.uddirect = -1; this.udstart = 0; this.udswt = false; } else if (this.oupnt != 70) { this.uddirect = 1; this.udstart = 0; this.udswt = false; }
 
             
             }
             else if ((this.m.random() > this.m.random() && this.stuntf != 1) || this.stuntf == 4 || this.stuntf == 6 || this.stuntf == 7 || this.stuntf == 17) {
 
 
 
               
               if ((this.m.random() > this.m.random() || this.stuntf == 2 || this.stuntf == 7) && this.stuntf != 4 && this.stuntf != 6) { this.uddirect = -1; } else { this.uddirect = 1; }
                this.udstart = (int)(10.0F * this.m.random() * this.trickprf);
               if (this.stuntf == 6) this.udstart = 0; 
               if (paramCheckPoints.stage == 26) this.udstart = 0; 
               if (paramCheckPoints.stage == 24 && (this.oupnt == 68 || this.oupnt == 69)) { this.apunch = 20; this.oupnt = 70; }
               
               if (this.m.random() > 0.85D && this.stuntf != 4 && this.stuntf != 3 && this.stuntf != 6 && this.stuntf != 17 && paramCheckPoints.stage != 26) this.udswt = true;
               
               if (this.m.random() > this.trickprf + 0.3F && this.stuntf != 4 && this.stuntf != 6)
               {
                 if (this.m.random() > this.m.random()) { this.lrdirect = -1; } else { this.lrdirect = 1; }
                  this.lrstart = (int)(30.0F * this.m.random());
                 if (this.m.random() > 0.75D) this.lrswt = true;
                 
               
               }
             
             }
             else {
               
               if (this.m.random() > this.m.random()) { this.lrdirect = -1; } else { this.lrdirect = 1; }
                this.lrstart = (int)(10.0F * this.m.random() * this.trickprf);
               if (this.m.random() > 0.75D && paramCheckPoints.stage != 26) this.lrswt = true; 
               if (this.m.random() > this.trickprf + 0.3F) {
                 
                 if (this.m.random() > this.m.random()) { this.uddirect = -1; } else { this.uddirect = 1; }
                  this.udstart = (int)(30.0F * this.m.random());
                 if (this.m.random() > 0.85D) this.udswt = true;
               
               } 
             } 
             
             if (this.trfix == 3 || this.trfix == 4) {
 
               
               if (paramCheckPoints.stage != 18 && paramCheckPoints.stage != 8) {
                 
                 if (paramCheckPoints.stage != 25 && this.lrdirect == -1) if (paramCheckPoints.stage != 19) { this.uddirect = -1; } else { this.uddirect = 1; }
                     this.lrdirect = 0;
                 if ((paramCheckPoints.stage == 19 || paramCheckPoints.stage == 25) && this.uddirect == -1) this.uddirect = 1; 
                 if (paramMad.power < 60.0F) this.uddirect = -1; 
               } else {
                 if (this.uddirect != 0) this.uddirect = -1;  this.lrdirect = 0;
               } 
               if (paramCheckPoints.stage == 20) { this.uddirect = 1; this.lrdirect = 0; }
                if (paramCheckPoints.stage == 26) {
                 
                 this.uddirect = -1; this.lrdirect = 0;
                 if (paramMad.cn != 11 && paramMad.cn != 13) { this.udstart = 7; if (paramMad.cn == 14 && paramMad.power > 30.0F) this.udstart = 14;  } else { this.udstart = 0; }
                  if (paramMad.cn == 11) { this.lrdirect = -1; this.lrstart = 0; }
               
               } 
             } 
           } else {
             this.trickfase = -1;
           } 
           if (!this.afta) this.afta = true; 
           if (this.trfix == 3) { this.trfix = 4; this.statusque += 30; }
         
         } 
         if (this.trickfase == 1) {
           
           this.flycnt++;
           if (this.lrdirect != 0 && this.flycnt > this.lrstart) { if (this.lrswt && Math.abs(paramMad.pxy - this.oxy) > 180) { if (this.lrdirect == -1) { this.lrdirect = 1; } else { this.lrdirect = -1; }  this.lrswt = false; }  if (this.lrdirect == -1) { this.handb = true; this.left = true; } else { this.handb = true; this.right = true; }  }
            if (this.uddirect != 0 && this.flycnt > this.udstart) { if (this.udswt && Math.abs(paramMad.pzy - this.ozy) > 180) { if (this.uddirect == -1) { this.uddirect = 1; } else { this.uddirect = -1; }  this.udswt = false; }  if (this.uddirect == -1) { this.handb = true; this.down = true; } else { this.handb = true; this.up = true; if (this.apunch > 0) { this.down = true; this.apunch--; }  }  }
            if ((paramMad.scy[0] + paramMad.scy[1] + paramMad.scy[2] + paramMad.scy[3]) * 100.0F / (paramContO.y - 300) < -this.saftey) { this.onceu = false; this.onced = false; this.oncel = false; this.oncer = false; this.lrcomp = false; this.udcomp = false; this.udbare = false; this.lrbare = false; this.trickfase = 2; this.swat = 0; }
         
         } 
         if (this.trickfase == 2) {
           
           if (this.swat == 0) { if (paramMad.dcomp != 0.0F || paramMad.ucomp != 0.0F) this.udbare = true;  if (paramMad.lcomp != 0.0F || paramMad.rcomp != 0.0F) this.lrbare = true;  this.swat = 1; }
            if (paramMad.wtouch) { if (this.swat == 1) this.swat = 2;  } else if (this.swat == 2) { if (paramMad.capsized && this.m.random() > this.mustland) if (this.udbare) { this.lrbare = true; this.udbare = false; } else if (this.lrbare) { this.udbare = true; this.lrbare = false; }   this.swat = 3; }
            if (this.udbare) { int i; for (i = paramMad.pzy + 90; i < 0; i += 360); for (; i > 180; i -= 360); i = Math.abs(i); if (paramMad.lcomp - paramMad.rcomp < 5.0F && (this.onced || this.onceu)) this.udcomp = true;  if (paramMad.dcomp > paramMad.ucomp) { if (paramMad.capsized) { if (this.udcomp) { if (i > 90) { this.up = true; } else { this.down = true; }  } else if (!this.onced) { this.down = true; }  } else { if (this.udcomp) { if (this.perfection && Math.abs(i - 90) > 30) if (i > 90) { this.up = true; } else { this.down = true; }   } else if (this.m.random() > this.mustland) { this.up = true; }  this.onced = true; }  } else if (paramMad.capsized) { if (this.udcomp) { if (i > 90) { this.up = true; } else { this.down = true; }  } else if (!this.onceu) { this.up = true; }  } else { if (this.udcomp) { if (this.perfection && Math.abs(i - 90) > 30) if (i > 90) { this.up = true; } else { this.down = true; }   } else if (this.m.random() > this.mustland) { this.down = true; }  this.onceu = true; }  }
            if (this.lrbare) { int i = paramMad.pxy + 90; if (this.zyinv) i += 180;  for (; i < 0; i += 360); for (; i > 180; i -= 360); i = Math.abs(i); if (paramMad.lcomp - paramMad.rcomp < 10.0F && (this.oncel || this.oncer)) this.lrcomp = true;  if (paramMad.lcomp > paramMad.rcomp) { if (paramMad.capsized) { if (this.lrcomp) { if (i > 90) { this.left = true; } else { this.right = true; }  } else if (!this.oncel) { this.left = true; }  } else { if (this.lrcomp) { if (this.perfection && Math.abs(i - 90) > 30) if (i > 90) { this.left = true; } else { this.right = true; }   } else if (this.m.random() > this.mustland) { this.right = true; }  this.oncel = true; }  } else if (paramMad.capsized) { if (this.lrcomp) { if (i > 90) { this.left = true; } else { this.right = true; }  } else if (!this.oncer) { this.right = true; }  } else { if (this.lrcomp) { if (this.perfection && Math.abs(i - 90) > 30) if (i > 90) { this.left = true; } else { this.right = true; }   } else if (this.m.random() > this.mustland) { this.left = true; }  this.oncer = true; }
              }
         
         } 
       } 
     } 
   }
 
 
   
   public int py(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
     return (paramInt1 - paramInt2) * (paramInt1 - paramInt2) + (paramInt3 - paramInt4) * (paramInt3 - paramInt4);
   }
 
   
   public int pys(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
     return (int)Math.sqrt(((paramInt1 - paramInt2) * (paramInt1 - paramInt2) + (paramInt3 - paramInt4) * (paramInt3 - paramInt4)));
   }
 }


