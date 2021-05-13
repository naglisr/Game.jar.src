 import java.awt.Color;
 
 
 public class Mad
 {
   Medium m;
   Record rpd;
   xtGraphics xt;
   int cn = 0;
   int im = 0;
 
   
   int mxz = 0; int cxz = 0;
 
   
   CarDefine cd;
   
   boolean[] dominate = new boolean[8];
   boolean[] caught = new boolean[8];
 
   
   int pzy = 0; int pxy = 0;
   float speed = 0.0F;
   float forca = 0.0F;
   float[] scy = new float[4];
   float[] scz = new float[4];
   float[] scx = new float[4];
   float drag = 0.5F;
   
   boolean mtouch = false;
   boolean wtouch = false;
   int cntouch = 0;
   boolean capsized = false;
   int txz = 0, fxz = 0, pmlt = 1, nmlt = 1, dcnt = 0;
   int skid = 0; boolean pushed = false; boolean gtouch = false; boolean pl = false;
   boolean pr = false;
   boolean pd = false;
   boolean pu = false;
   int loop = 0;
   float ucomp = 0.0F; float dcomp = 0.0F; float lcomp = 0.0F; float rcomp = 0.0F;
   int lxz = 0; int travxy = 0; int travzy = 0; int travxz = 0; int trcnt = 0; int capcnt = 0; int srfcnt = 0; boolean rtab = false; boolean ftab = false; boolean btab = false;
   boolean surfer = false;
   float powerup = 0.0F;
   int xtpower = 0;
 
   
   float tilt = 0.0F;
   int[][] crank = new int[4][4];
   int[][] lcrank = new int[4][4];
 
   
   int squash = 0, nbsq = 0;
   int hitmag = 0; int cntdest = 0;
   
   boolean dest = false;
   
   boolean newcar = false;
   int pan = 0;
   int pcleared = 0;
   int clear = 0;
   int nlaps = 0;
   int focus = -1;
   float power = 75.0F;
 
   
   int missedcp = 0;
   int lastcolido = 0;
   int point = 0;
   boolean nofocus = false;
   int rpdcatch = 0;
 
   
   int newedcar = 0;
   int fixes = -1;
 
   
   int shakedam = 0; int outshakedam = 0;
 
 
 
 
   
   boolean colidim;
 
 
 
 
   
   public void reseto(int paramInt, ContO paramContO, CheckPoints paramCheckPoints) {
     this.cn = paramInt; byte b;
     for (b = 0; b < 8; ) { this.dominate[b] = false; this.caught[b] = false; b++; }
     
     this.mxz = 0; this.cxz = 0;
     this.pzy = 0; this.pxy = 0;
     this.speed = 0.0F;
     for (b = 0; b < 4; ) { this.scy[b] = 0.0F; this.scx[b] = 0.0F; this.scz[b] = 0.0F; b++; }
      this.forca = ((float)Math.sqrt((paramContO.keyz[0] * paramContO.keyz[0] + paramContO.keyx[0] * paramContO.keyx[0])) + (float)Math.sqrt((paramContO.keyz[1] * paramContO.keyz[1] + paramContO.keyx[1] * paramContO.keyx[1])) + (float)Math.sqrt((paramContO.keyz[2] * paramContO.keyz[2] + paramContO.keyx[2] * paramContO.keyx[2])) + (float)Math.sqrt((paramContO.keyz[3] * paramContO.keyz[3] + paramContO.keyx[3] * paramContO.keyx[3]))) / 10000.0F * (float)(this.cd.bounce[this.cn] - 0.3D);
     this.mtouch = false; this.wtouch = false;
     this.txz = 0; this.fxz = 0; this.pmlt = 1; this.nmlt = 1; this.dcnt = 0;
     this.skid = 0;
     
     this.pushed = false; this.gtouch = false; this.pl = false; this.pr = false; this.pd = false; this.pu = false;
     this.loop = 0;
     this.ucomp = 0.0F; this.dcomp = 0.0F; this.lcomp = 0.0F; this.rcomp = 0.0F;
     this.lxz = 0; this.travxy = 0; this.travzy = 0; this.travxz = 0;
     this.rtab = false; this.ftab = false; this.btab = false;
     this.powerup = 0.0F; this.xtpower = 0;
     this.trcnt = 0; this.capcnt = 0;
     
     this.tilt = 0.0F;
     for (b = 0; b < 4; ) { for (byte b1 = 0; b1 < 4; ) { this.crank[b][b1] = 0; this.lcrank[b][b1] = 0; b1++; }  b++; }
     
     this.pan = 0;
     this.pcleared = paramCheckPoints.pcs;
     this.clear = 0;
     this.nlaps = 0;
     this.focus = -1;
     this.missedcp = 0;
     this.nofocus = false;
     this.power = 98.0F;
     
     this.lastcolido = 0;
     paramCheckPoints.dested[this.im] = 0;
     
     this.squash = 0;
     this.nbsq = 0;
     this.hitmag = 0;
     this.cntdest = 0;
     this.dest = false;
     this.newcar = false;
     
     if (this.im == this.xt.im) { this.m.checkpoint = -1; this.m.lastcheck = false; }
      this.rpdcatch = 0;
     
     this.newedcar = 0;
     this.fixes = -1;
     if (paramCheckPoints.nfix == 1) this.fixes = 4;  if (paramCheckPoints.nfix == 2) this.fixes = 3;  if (paramCheckPoints.nfix == 3) this.fixes = 2;  if (paramCheckPoints.nfix == 4) this.fixes = 1;
   
   }
 
 
   
   public void drive(Control paramControl, ContO paramContO, Trackers paramTrackers, CheckPoints paramCheckPoints) {
     byte b1 = 1;
     byte b2 = 1;
     
     boolean bool1 = false, bool2 = false, bool3 = false;
     this.capsized = false; int i;
     for (i = Math.abs(this.pzy); i > 270; i -= 360); i = Math.abs(i); if (i > 90) bool1 = true; 
     boolean bool4 = false; int j;
     for (j = Math.abs(this.pxy); j > 270; j -= 360); j = Math.abs(j); if (j > 90) { bool4 = true; b2 = -1; }
      int k = paramContO.grat;
     if (bool1) { if (bool4) { bool4 = false; bool2 = true; } else { bool4 = true; this.capsized = true; }  b1 = -1; } else if (bool4) { this.capsized = true; }
      if (this.capsized) k = this.cd.flipy[this.cn] + this.squash; 
     paramControl.zyinv = bool1;
     
     float f1 = 0.0F, f2 = 0.0F, f3 = 0.0F;
 
     
     if (this.mtouch) this.loop = 0; 
     if (this.wtouch) { if (this.loop == 2 || this.loop == -1) { this.loop = -1; if (paramControl.left) this.pl = true;  if (paramControl.right) this.pr = true;  if (paramControl.up) this.pu = true;  if (paramControl.down) this.pd = true;  }  this.ucomp = 0.0F; this.dcomp = 0.0F; this.lcomp = 0.0F; this.rcomp = 0.0F; }
      if (paramControl.handb) { if (!this.pushed) if (!this.wtouch) { if (this.loop == 0) this.loop = 1;  } else if (this.gtouch) { this.pushed = true; }   } else { this.pushed = false; }
      if (this.loop == 1) { float f; byte b; for (f = (this.scy[0] + this.scy[1] + this.scy[2] + this.scy[3]) / 4.0F, b = 0; b < 4; ) { this.scy[b] = f; b++; }  this.loop = 2; }
     
     if (!this.dest)
     {
       if (this.loop == 2) {
         
         if (paramControl.up) { if (this.ucomp == 0.0F) { this.ucomp = 10.0F + (this.scy[0] + 50.0F) / 20.0F; if (this.ucomp < 5.0F) this.ucomp = 5.0F;  if (this.ucomp > 10.0F) this.ucomp = 10.0F;  this.ucomp *= this.cd.airs[this.cn]; }  if (this.ucomp < 20.0F) this.ucomp = (float)(this.ucomp + 0.5D * this.cd.airs[this.cn]);  f1 = -this.cd.airc[this.cn] * this.m.sin(paramContO.xz) * b2; f2 = this.cd.airc[this.cn] * this.m.cos(paramContO.xz) * b2; } else if (this.ucomp != 0.0F && this.ucomp > -2.0F) { this.ucomp = (float)(this.ucomp - 0.5D * this.cd.airs[this.cn]); }
          if (paramControl.down) { if (this.dcomp == 0.0F) { this.dcomp = 10.0F + (this.scy[0] + 50.0F) / 20.0F; if (this.dcomp < 5.0F) this.dcomp = 5.0F;  if (this.dcomp > 10.0F) this.dcomp = 10.0F;  this.dcomp *= this.cd.airs[this.cn]; }  if (this.dcomp < 20.0F) this.dcomp = (float)(this.dcomp + 0.5D * this.cd.airs[this.cn]);  f3 = -this.cd.airc[this.cn]; } else if (this.dcomp != 0.0F && this.ucomp > -2.0F) { this.dcomp = (float)(this.dcomp - 0.5D * this.cd.airs[this.cn]); }
          if (paramControl.left) { if (this.lcomp == 0.0F) this.lcomp = 5.0F;  if (this.lcomp < 20.0F) this.lcomp += 2.0F * this.cd.airs[this.cn];  f1 = -this.cd.airc[this.cn] * this.m.cos(paramContO.xz) * b1; f2 = -this.cd.airc[this.cn] * this.m.sin(paramContO.xz) * b1; } else if (this.lcomp > 0.0F) { this.lcomp -= 2.0F * this.cd.airs[this.cn]; }
          if (paramControl.right) { if (this.rcomp == 0.0F) this.rcomp = 5.0F;  if (this.rcomp < 20.0F) this.rcomp += 2.0F * this.cd.airs[this.cn];  f1 = this.cd.airc[this.cn] * this.m.cos(paramContO.xz) * b1; f2 = this.cd.airc[this.cn] * this.m.sin(paramContO.xz) * b1; } else if (this.rcomp > 0.0F) { this.rcomp -= 2.0F * this.cd.airs[this.cn]; }
          this.pzy = (int)(this.pzy + (this.dcomp - this.ucomp) * this.m.cos(this.pxy));
         if (bool1) { paramContO.xz = (int)(paramContO.xz + (this.dcomp - this.ucomp) * this.m.sin(this.pxy)); } else { paramContO.xz = (int)(paramContO.xz - (this.dcomp - this.ucomp) * this.m.sin(this.pxy)); }
          this.pxy = (int)(this.pxy + this.rcomp - this.lcomp);
       }
       else {
         
         float f = this.power;
         if (f < 40.0F) f = 40.0F;
 
 
 
         
         if (paramControl.down) if (this.speed > 0.0F) { this.speed -= (this.cd.handb[this.cn] / 2); } else { byte b7; byte b8; for (b7 = 0, b8 = 0; b8 < 2; ) { if (this.speed <= -((this.cd.swits[this.cn][b8] / 2) + f * this.cd.swits[this.cn][b8] / 196.0F)) b7++;  b8++; }  if (b7 != 2) { this.speed -= this.cd.acelf[this.cn][b7] / 2.0F + f * this.cd.acelf[this.cn][b7] / 196.0F; } else { this.speed = -((this.cd.swits[this.cn][1] / 2) + f * this.cd.swits[this.cn][1] / 196.0F); }  }
             if (paramControl.up) if (this.speed < 0.0F) { this.speed += this.cd.handb[this.cn]; } else { byte b7; byte b8; for (b7 = 0, b8 = 0; b8 < 3; ) { if (this.speed >= (this.cd.swits[this.cn][b8] / 2) + f * this.cd.swits[this.cn][b8] / 196.0F) b7++;  b8++; }  if (b7 != 3) { this.speed += this.cd.acelf[this.cn][b7] / 2.0F + f * this.cd.acelf[this.cn][b7] / 196.0F; } else { this.speed = (this.cd.swits[this.cn][2] / 2) + f * this.cd.swits[this.cn][2] / 196.0F; }  }
             if (paramControl.handb && Math.abs(this.speed) > this.cd.handb[this.cn]) if (this.speed < 0.0F) { this.speed += this.cd.handb[this.cn]; } else { this.speed -= this.cd.handb[this.cn]; }
             if (this.loop == -1 && paramContO.y < 100) { if (paramControl.left) { if (!this.pl) { if (this.lcomp == 0.0F) this.lcomp = 5.0F * this.cd.airs[this.cn];  if (this.lcomp < 20.0F) this.lcomp += 2.0F * this.cd.airs[this.cn];  }  } else { if (this.lcomp > 0.0F) this.lcomp -= 2.0F * this.cd.airs[this.cn];  this.pl = false; }  if (paramControl.right) { if (!this.pr) { if (this.rcomp == 0.0F) this.rcomp = 5.0F * this.cd.airs[this.cn];  if (this.rcomp < 20.0F) this.rcomp += 2.0F * this.cd.airs[this.cn];  }  } else { if (this.rcomp > 0.0F) this.rcomp -= 2.0F * this.cd.airs[this.cn];  this.pr = false; }  if (paramControl.up) { if (!this.pu) { if (this.ucomp == 0.0F) this.ucomp = 5.0F * this.cd.airs[this.cn];  if (this.ucomp < 20.0F) this.ucomp += 2.0F * this.cd.airs[this.cn];  }  } else { if (this.ucomp > 0.0F) this.ucomp -= 2.0F * this.cd.airs[this.cn];  this.pu = false; }  if (paramControl.down) { if (!this.pd) { if (this.dcomp == 0.0F) this.dcomp = 5.0F * this.cd.airs[this.cn];  if (this.dcomp < 20.0F) this.dcomp += 2.0F * this.cd.airs[this.cn];  }  } else { if (this.dcomp > 0.0F) this.dcomp -= 2.0F * this.cd.airs[this.cn];  this.pd = false; }  this.pzy = (int)(this.pzy + (this.dcomp - this.ucomp) * this.m.cos(this.pxy)); if (bool1) { paramContO.xz = (int)(paramContO.xz + (this.dcomp - this.ucomp) * this.m.sin(this.pxy)); } else { paramContO.xz = (int)(paramContO.xz - (this.dcomp - this.ucomp) * this.m.sin(this.pxy)); }  this.pxy = (int)(this.pxy + this.rcomp - this.lcomp); }
       
       } 
     }
     
     float f4 = 20.0F * this.speed / 154.0F * this.cd.simag[this.cn];
     if (f4 > 20.0F) f4 = 20.0F; 
     paramContO.wzy = (int)(paramContO.wzy - f4);
     if (paramContO.wzy < -30) paramContO.wzy += 30; 
     if (paramContO.wzy > 30) paramContO.wzy -= 30;
     
     if (paramControl.right) { paramContO.wxz -= this.cd.turn[this.cn]; if (paramContO.wxz < -36) paramContO.wxz = -36;  }
      if (paramControl.left) { paramContO.wxz += this.cd.turn[this.cn]; if (paramContO.wxz > 36) paramContO.wxz = 36;  }
      if (paramContO.wxz != 0 && !paramControl.left && !paramControl.right) if (Math.abs(this.speed) < 10.0F) { if (Math.abs(paramContO.wxz) == 1) paramContO.wxz = 0;  if (paramContO.wxz > 0) paramContO.wxz--;  if (paramContO.wxz < 0) paramContO.wxz++;  } else { if (Math.abs(paramContO.wxz) < this.cd.turn[this.cn] * 2) paramContO.wxz = 0;  if (paramContO.wxz > 0) paramContO.wxz -= this.cd.turn[this.cn] * 2;  if (paramContO.wxz < 0) paramContO.wxz += this.cd.turn[this.cn] * 2;  }
         int m = (int)(3600.0F / this.speed * this.speed);
     if (m < 5) m = 5; 
     if (this.speed < 0.0F) m = -m; 
     if (this.wtouch) { if (!this.capsized) { if (!paramControl.handb) { this.fxz = paramContO.wxz / m * 3; } else { this.fxz = paramContO.wxz / m; }  paramContO.xz += paramContO.wxz / m; }  this.wtouch = false; this.gtouch = false; } else { paramContO.xz += this.fxz; }
 
 
     
     if (this.speed > 30.0F || this.speed < -100.0F) {
       
       while (Math.abs(this.mxz - this.cxz) > 180) { if (this.cxz > this.mxz) { this.cxz -= 360; continue; }  if (this.cxz < this.mxz) this.cxz += 360;  }
        if (Math.abs(this.mxz - this.cxz) < 30) { this.cxz = (int)(this.cxz + (this.mxz - this.cxz) / 4.0F); } else { if (this.cxz > this.mxz) this.cxz -= 10;  if (this.cxz < this.mxz) this.cxz += 10;  }
     
     } 
     float[] arrayOfFloat1 = new float[4];
     float[] arrayOfFloat2 = new float[4];
     float[] arrayOfFloat3 = new float[4]; byte b3;
     for (b3 = 0; b3 < 4; b3++) {
       
       arrayOfFloat1[b3] = (paramContO.keyx[b3] + paramContO.x);
       arrayOfFloat3[b3] = (k + paramContO.y);
       arrayOfFloat2[b3] = (paramContO.z + paramContO.keyz[b3]);
       this.scy[b3] = this.scy[b3] + 7.0F;
     } 
     rot(arrayOfFloat1, arrayOfFloat3, paramContO.x, paramContO.y, this.pxy, 4);
     rot(arrayOfFloat3, arrayOfFloat2, paramContO.y, paramContO.z, this.pzy, 4);
     rot(arrayOfFloat1, arrayOfFloat2, paramContO.x, paramContO.z, paramContO.xz, 4);
     
     b3 = 0;
     double d = 0.0D;
     
     int n = (int)((this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0F);
     int i1 = (int)((this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0F);
     int i2;
     for (i2 = 0; i2 < 4; i2++) {
       
       if (this.scx[i2] - n > 200.0F) this.scx[i2] = (200 + n); 
       if (this.scx[i2] - n < -200.0F) this.scx[i2] = (n - 200); 
       if (this.scz[i2] - i1 > 200.0F) this.scz[i2] = (200 + i1); 
       if (this.scz[i2] - i1 < -200.0F) this.scz[i2] = (i1 - 200);
     
     } 
     for (i2 = 0; i2 < 4; i2++) {
       
       arrayOfFloat3[i2] = arrayOfFloat3[i2] + this.scy[i2];
       arrayOfFloat1[i2] = arrayOfFloat1[i2] + (this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0F;
       arrayOfFloat2[i2] = arrayOfFloat2[i2] + (this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0F;
     } 
     
     i2 = (paramContO.x - paramTrackers.sx) / 3000; if (i2 > paramTrackers.ncx) i2 = paramTrackers.ncx;  if (i2 < 0) i2 = 0; 
     int i3 = (paramContO.z - paramTrackers.sz) / 3000; if (i3 > paramTrackers.ncz) i3 = paramTrackers.ncz;  if (i3 < 0) i3 = 0; 
     int i4 = 1; byte b4;
     for (b4 = 0; b4 < (paramTrackers.sect[i2][i3]).length; ) { int i12 = paramTrackers.sect[i2][i3][b4]; if (Math.abs(paramTrackers.zy[i12]) != 90 && Math.abs(paramTrackers.xy[i12]) != 90 && Math.abs(paramContO.x - paramTrackers.x[i12]) < paramTrackers.radx[i12] && Math.abs(paramContO.z - paramTrackers.z[i12]) < paramTrackers.radz[i12] && (!paramTrackers.decor[i12] || this.m.resdown != 2 || this.xt.multion != 0)) i4 = paramTrackers.skd[i12];  b4++; }
 
     
     if (this.mtouch)
     
     { float f6 = this.cd.grip[this.cn];
       f6 -= Math.abs(this.txz - paramContO.xz) * this.speed / 250.0F;
       if (paramControl.handb) f6 -= (Math.abs(this.txz - paramContO.xz) * 4); 
       if (f6 < this.cd.grip[this.cn]) { if (this.skid != 2) this.skid = 1;  this.speed -= this.speed / 100.0F; } else if (this.skid == 1) { this.skid = 2; }
        if (i4 == 1) f6 = (float)(f6 * 0.75D); 
       if (i4 == 2) f6 = (float)(f6 * 0.55D);
       
       int i12 = -((int)(this.speed * this.m.sin(paramContO.xz) * this.m.cos(this.pzy)));
       int i13 = (int)(this.speed * this.m.cos(paramContO.xz) * this.m.cos(this.pzy));
       int i14 = -((int)(this.speed * this.m.sin(this.pzy)));
       
       if (this.capsized || this.dest || paramCheckPoints.haltall) { i12 = 0; i13 = 0; i14 = 0; f6 = this.cd.grip[this.cn] / 5.0F; if (this.speed > 0.0F) { this.speed -= 2.0F; } else { this.speed += 2.0F; }  }
        if (Math.abs(this.speed) > this.drag) { if (this.speed > 0.0F) { this.speed -= this.drag; } else { this.speed += this.drag; }  } else { this.speed = 0.0F; }
        if (this.cn == 8 && f6 < 5.0F) f6 = 5.0F; 
       if (f6 < 1.0F) f6 = 1.0F;
       
       float f7 = 0.0F, f8 = 0.0F;
       
       for (byte b = 0; b < 4; b++) {
         
         if (Math.abs(this.scx[b] - i12) > f6) { if (this.scx[b] < i12) { this.scx[b] = this.scx[b] + f6; } else { this.scx[b] = this.scx[b] - f6; }  } else { this.scx[b] = i12; }
          if (Math.abs(this.scz[b] - i13) > f6) { if (this.scz[b] < i13) { this.scz[b] = this.scz[b] + f6; } else { this.scz[b] = this.scz[b] - f6; }  } else { this.scz[b] = i13; }
          if (Math.abs(this.scy[b] - i14) > f6) { if (this.scy[b] < i14) { this.scy[b] = this.scy[b] + f6; } else { this.scy[b] = this.scy[b] - f6; }  } else { this.scy[b] = i14; }
         
         if (f6 < this.cd.grip[this.cn]) { if (this.txz != paramContO.xz) { this.dcnt++; } else if (this.dcnt != 0) { this.dcnt = 0; }
           
           if (this.dcnt > 40.0F * f6 / this.cd.grip[this.cn] || this.capsized) { float f = 1.0F; if (i4 != 0) f = 1.2F;  if (this.m.random() > 0.65D) {
               paramContO.dust(b, arrayOfFloat1[b], arrayOfFloat3[b], arrayOfFloat2[b], (int)this.scx[b], (int)this.scz[b], f * this.cd.simag[this.cn], (int)this.tilt, (this.capsized && this.mtouch));
               if (this.im == this.xt.im && !this.capsized) this.xt.skid(i4, (float)Math.sqrt((this.scx[b] * this.scx[b] + this.scz[b] * this.scz[b]))); 
             }  }
           else
           { if (i4 == 1 && this.m.random() > 0.8D) paramContO.dust(b, arrayOfFloat1[b], arrayOfFloat3[b], arrayOfFloat2[b], (int)this.scx[b], (int)this.scz[b], 1.1F * this.cd.simag[this.cn], (int)this.tilt, (this.capsized && this.mtouch));  if ((i4 == 2 || i4 == 3) && this.m.random() > 0.6D) paramContO.dust(b, arrayOfFloat1[b], arrayOfFloat3[b], arrayOfFloat2[b], (int)this.scx[b], (int)this.scz[b], 1.15F * this.cd.simag[this.cn], (int)this.tilt, (this.capsized && this.mtouch));  }  } else if (this.dcnt != 0) { this.dcnt -= 2; if (this.dcnt < 0) this.dcnt = 0;  }
         
         if (i4 == 3) { int i15 = (int)(this.m.random() * 4.0F); this.scy[i15] = (float)((-100.0F * this.m.random() * this.speed / this.cd.swits[this.cn][2]) * (this.cd.bounce[this.cn] - 0.3D)); }
          if (i4 == 4) { int i15 = (int)(this.m.random() * 4.0F); this.scy[i15] = (float)((-150.0F * this.m.random() * this.speed / this.cd.swits[this.cn][2]) * (this.cd.bounce[this.cn] - 0.3D)); }
         
         f7 += this.scx[b];
         f8 += this.scz[b];
       } 
       
       this.txz = paramContO.xz;
       if (f7 > 0.0F) { b1 = -1; } else { b1 = 1; }
        d = f8 / Math.sqrt((f7 * f7 + f8 * f8));
       this.mxz = (int)(Math.acos(d) / 0.017453292519943295D * b1);
       
       if (this.skid == 2) { if (!this.capsized) { f7 /= 4.0F; f8 /= 4.0F; if (bool2) { this.speed = -((float)Math.sqrt((f7 * f7 + f8 * f8)) * this.m.cos(this.mxz - paramContO.xz)); } else { this.speed = (float)Math.sqrt((f7 * f7 + f8 * f8)) * this.m.cos(this.mxz - paramContO.xz); }  }  this.skid = 0; }
        if (this.capsized && f7 == 0.0F && f8 == 0.0F) i4 = 0;
       
       this.mtouch = false; b3 = 1; }
     else if (this.skid != 2) { this.skid = 2; }
 
     
     b4 = 0;
     boolean[] arrayOfBoolean1 = new boolean[4];
     boolean[] arrayOfBoolean2 = new boolean[4];
     boolean[] arrayOfBoolean3 = new boolean[4];
     float f5 = 0.0F;
     byte b5;
     for (b5 = 0; b5 < 4; b5++) {
       
       arrayOfBoolean2[b5] = false;
       arrayOfBoolean3[b5] = false;
       if (arrayOfFloat3[b5] > 245.0F) {
         
         b4++; this.wtouch = true; this.gtouch = true;
         if (b3 == 0 && this.scy[b5] != 7.0F) { float f6 = this.scy[b5] / 333.33F; if (f6 > 0.3D) f6 = 0.3F;  if (i4 == 0) { f6 = (float)(f6 + 1.1D); } else { f6 = (float)(f6 + 1.2D); }  paramContO.dust(b5, arrayOfFloat1[b5], arrayOfFloat3[b5], arrayOfFloat2[b5], (int)this.scx[b5], (int)this.scz[b5], f6 * this.cd.simag[this.cn], 0, (this.capsized && this.mtouch)); }
          arrayOfFloat3[b5] = 250.0F; arrayOfBoolean3[b5] = true; f5 += arrayOfFloat3[b5] - 250.0F;
         float f = Math.abs(this.m.sin(this.pxy)) + Math.abs(this.m.sin(this.pzy));
         f /= 3.0F;
         if (f > 0.4D) f = 0.4F; 
         f += this.cd.bounce[this.cn]; if (f < 1.1D) f = 1.1F; 
         regy(b5, Math.abs(this.scy[b5] * f), paramContO);
         if (this.scy[b5] > 0.0F) this.scy[b5] = this.scy[b5] - Math.abs(this.scy[b5] * f); 
         if (this.capsized) arrayOfBoolean2[b5] = true; 
       } 
       arrayOfBoolean1[b5] = false;
     } 
     
     if (b4 != 0) for (f5 /= b4, b5 = 0; b5 < 4; ) { if (!arrayOfBoolean3[b5]) arrayOfFloat3[b5] = arrayOfFloat3[b5] - f5;  b5++; }
     
     
     b5 = 0; int i5;
     for (i5 = 0; i5 < (paramTrackers.sect[i2][i3]).length; i5++) {
       
       int i12 = paramTrackers.sect[i2][i3][i5];
       
       byte b7 = 0;
       byte b8 = 0;
       for (byte b9 = 0; b9 < 4; b9++) {
         
         if (arrayOfBoolean2[b9] && (paramTrackers.skd[i12] == 0 || paramTrackers.skd[i12] == 1) && arrayOfFloat1[b9] > (paramTrackers.x[i12] - paramTrackers.radx[i12]) && arrayOfFloat1[b9] < (paramTrackers.x[i12] + paramTrackers.radx[i12]) && arrayOfFloat2[b9] > (paramTrackers.z[i12] - paramTrackers.radz[i12]) && arrayOfFloat2[b9] < (paramTrackers.z[i12] + paramTrackers.radz[i12])) { paramContO.sprk(arrayOfFloat1[b9], arrayOfFloat3[b9], arrayOfFloat2[b9], this.scx[b9], this.scy[b9], this.scz[b9], 1); if (this.im == this.xt.im) this.xt.gscrape((int)this.scx[b9], (int)this.scy[b9], (int)this.scz[b9]);  }
         
         if (!arrayOfBoolean1[b9] && arrayOfFloat1[b9] > (paramTrackers.x[i12] - paramTrackers.radx[i12]) && arrayOfFloat1[b9] < (paramTrackers.x[i12] + paramTrackers.radx[i12]) && arrayOfFloat2[b9] > (paramTrackers.z[i12] - paramTrackers.radz[i12]) && arrayOfFloat2[b9] < (paramTrackers.z[i12] + paramTrackers.radz[i12]) && arrayOfFloat3[b9] > (paramTrackers.y[i12] - paramTrackers.rady[i12]) && arrayOfFloat3[b9] < (paramTrackers.y[i12] + paramTrackers.rady[i12]) && (!paramTrackers.decor[i12] || this.m.resdown != 2 || this.xt.multion != 0)) {
 
           
           if (paramTrackers.xy[i12] == 0 && paramTrackers.zy[i12] == 0 && paramTrackers.y[i12] != 250)
           {
             if (arrayOfFloat3[b9] > (paramTrackers.y[i12] - 5)) {
               
               b8++; this.wtouch = true; this.gtouch = true;
               if (b3 == 0 && this.scy[b9] != 7.0F) { float f6 = this.scy[b9] / 333.33F; if (f6 > 0.3D) f6 = 0.3F;  if (i4 == 0) { f6 = (float)(f6 + 1.1D); } else { f6 = (float)(f6 + 1.2D); }  paramContO.dust(b9, arrayOfFloat1[b9], arrayOfFloat3[b9], arrayOfFloat2[b9], (int)this.scx[b9], (int)this.scz[b9], f6 * this.cd.simag[this.cn], 0, (this.capsized && this.mtouch)); }
               
               arrayOfFloat3[b9] = paramTrackers.y[i12];
               if (this.capsized && (paramTrackers.skd[i12] == 0 || paramTrackers.skd[i12] == 1)) { paramContO.sprk(arrayOfFloat1[b9], arrayOfFloat3[b9], arrayOfFloat2[b9], this.scx[b9], this.scy[b9], this.scz[b9], 1); if (this.im == this.xt.im) this.xt.gscrape((int)this.scx[b9], (int)this.scy[b9], (int)this.scz[b9]);  }
                float f = Math.abs(this.m.sin(this.pxy)) + Math.abs(this.m.sin(this.pzy));
               f /= 3.0F;
               if (f > 0.4D) f = 0.4F; 
               f += this.cd.bounce[this.cn]; if (f < 1.1D) f = 1.1F; 
               regy(b9, Math.abs(this.scy[b9] * f), paramContO);
               if (this.scy[b9] > 0.0F) this.scy[b9] = this.scy[b9] - Math.abs(this.scy[b9] * f); 
               arrayOfBoolean1[b9] = true;
             } 
           }
           
           if (paramTrackers.zy[i12] == -90)
           {
             if (arrayOfFloat2[b9] < (paramTrackers.z[i12] + paramTrackers.radz[i12]) && (this.scz[b9] < 0.0F || paramTrackers.radz[i12] == 287)) {
               
               for (byte b = 0; b < 4; ) { if (b9 != b && arrayOfFloat2[b] >= (paramTrackers.z[i12] + paramTrackers.radz[i12])) arrayOfFloat2[b] = arrayOfFloat2[b] - arrayOfFloat2[b9] - (paramTrackers.z[i12] + paramTrackers.radz[i12]);  b++; }
                arrayOfFloat2[b9] = (paramTrackers.z[i12] + paramTrackers.radz[i12]);
               if (paramTrackers.skd[i12] != 2) this.crank[0][b9] = this.crank[0][b9] + 1;  if (paramTrackers.skd[i12] == 5 && this.m.random() > this.m.random()) this.crank[0][b9] = this.crank[0][b9] + 1;  if (this.crank[0][b9] > 1) { paramContO.sprk(arrayOfFloat1[b9], arrayOfFloat3[b9], arrayOfFloat2[b9], this.scx[b9], this.scy[b9], this.scz[b9], 0); if (this.im == this.xt.im) this.xt.scrape((int)this.scx[b9], (int)this.scy[b9], (int)this.scz[b9]);  }
                float f = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
               f /= 4.0F;
               if (f > 0.3D) f = 0.3F; 
               if (b3 != 0) f = 0.0F; 
               f = (float)(f + this.cd.bounce[this.cn] - 0.2D); if (f < 1.1D) f = 1.1F; 
               regz(b9, Math.abs(this.scz[b9] * f * paramTrackers.dam[i12]), paramContO);
               this.scz[b9] = this.scz[b9] + Math.abs(this.scz[b9] * f);
               this.skid = 2;
               bool3 = true;
               arrayOfBoolean1[b9] = true;
               if (!paramTrackers.notwall[i12]) paramControl.wall = i12;
             
             } 
           }
           if (paramTrackers.zy[i12] == 90)
           {
             if (arrayOfFloat2[b9] > (paramTrackers.z[i12] - paramTrackers.radz[i12]) && (this.scz[b9] > 0.0F || paramTrackers.radz[i12] == 287)) {
               
               for (byte b = 0; b < 4; ) { if (b9 != b && arrayOfFloat2[b] <= (paramTrackers.z[i12] - paramTrackers.radz[i12])) arrayOfFloat2[b] = arrayOfFloat2[b] - arrayOfFloat2[b9] - (paramTrackers.z[i12] - paramTrackers.radz[i12]);  b++; }
                arrayOfFloat2[b9] = (paramTrackers.z[i12] - paramTrackers.radz[i12]);
               if (paramTrackers.skd[i12] != 2) this.crank[1][b9] = this.crank[1][b9] + 1;  if (paramTrackers.skd[i12] == 5 && this.m.random() > this.m.random()) this.crank[1][b9] = this.crank[1][b9] + 1;  if (this.crank[1][b9] > 1) { paramContO.sprk(arrayOfFloat1[b9], arrayOfFloat3[b9], arrayOfFloat2[b9], this.scx[b9], this.scy[b9], this.scz[b9], 0); if (this.im == this.xt.im) this.xt.scrape((int)this.scx[b9], (int)this.scy[b9], (int)this.scz[b9]);  }
                float f = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
               f /= 4.0F;
               if (f > 0.3D) f = 0.3F; 
               if (b3 != 0) f = 0.0F; 
               f = (float)(f + this.cd.bounce[this.cn] - 0.2D); if (f < 1.1D) f = 1.1F; 
               regz(b9, -Math.abs(this.scz[b9] * f * paramTrackers.dam[i12]), paramContO);
               this.scz[b9] = this.scz[b9] - Math.abs(this.scz[b9] * f);
               this.skid = 2;
               bool3 = true;
               arrayOfBoolean1[b9] = true;
               if (!paramTrackers.notwall[i12]) paramControl.wall = i12;
             
             } 
           }
           if (paramTrackers.xy[i12] == -90)
           {
             if (arrayOfFloat1[b9] < (paramTrackers.x[i12] + paramTrackers.radx[i12]) && (this.scx[b9] < 0.0F || paramTrackers.radx[i12] == 287)) {
               
               for (byte b = 0; b < 4; ) { if (b9 != b && arrayOfFloat1[b] >= (paramTrackers.x[i12] + paramTrackers.radx[i12])) arrayOfFloat1[b] = arrayOfFloat1[b] - arrayOfFloat1[b9] - (paramTrackers.x[i12] + paramTrackers.radx[i12]);  b++; }
                arrayOfFloat1[b9] = (paramTrackers.x[i12] + paramTrackers.radx[i12]);
               if (paramTrackers.skd[i12] != 2) this.crank[2][b9] = this.crank[2][b9] + 1;  if (paramTrackers.skd[i12] == 5 && this.m.random() > this.m.random()) this.crank[2][b9] = this.crank[2][b9] + 1;  if (this.crank[2][b9] > 1) { paramContO.sprk(arrayOfFloat1[b9], arrayOfFloat3[b9], arrayOfFloat2[b9], this.scx[b9], this.scy[b9], this.scz[b9], 0); if (this.im == this.xt.im) this.xt.scrape((int)this.scx[b9], (int)this.scy[b9], (int)this.scz[b9]);  }
                float f = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
               f /= 4.0F;
               if (f > 0.3D) f = 0.3F; 
               if (b3 != 0) f = 0.0F; 
               f = (float)(f + this.cd.bounce[this.cn] - 0.2D); if (f < 1.1D) f = 1.1F; 
               regx(b9, Math.abs(this.scx[b9] * f * paramTrackers.dam[i12]), paramContO);
               this.scx[b9] = this.scx[b9] + Math.abs(this.scx[b9] * f);
               this.skid = 2;
               bool3 = true;
               arrayOfBoolean1[b9] = true;
               if (!paramTrackers.notwall[i12]) paramControl.wall = i12;
             
             } 
           }
           if (paramTrackers.xy[i12] == 90)
           {
             if (arrayOfFloat1[b9] > (paramTrackers.x[i12] - paramTrackers.radx[i12]) && (this.scx[b9] > 0.0F || paramTrackers.radx[i12] == 287)) {
               
               for (byte b = 0; b < 4; ) { if (b9 != b && arrayOfFloat1[b] <= (paramTrackers.x[i12] - paramTrackers.radx[i12])) arrayOfFloat1[b] = arrayOfFloat1[b] - arrayOfFloat1[b9] - (paramTrackers.x[i12] - paramTrackers.radx[i12]);  b++; }
                arrayOfFloat1[b9] = (paramTrackers.x[i12] - paramTrackers.radx[i12]);
               if (paramTrackers.skd[i12] != 2) this.crank[3][b9] = this.crank[3][b9] + 1;  if (paramTrackers.skd[i12] == 5 && this.m.random() > this.m.random()) this.crank[3][b9] = this.crank[3][b9] + 1;  if (this.crank[3][b9] > 1) { paramContO.sprk(arrayOfFloat1[b9], arrayOfFloat3[b9], arrayOfFloat2[b9], this.scx[b9], this.scy[b9], this.scz[b9], 0); if (this.im == this.xt.im) this.xt.scrape((int)this.scx[b9], (int)this.scy[b9], (int)this.scz[b9]);  }
                float f = Math.abs(this.m.cos(this.pxy)) + Math.abs(this.m.cos(this.pzy));
               f /= 4.0F;
               if (f > 0.3D) f = 0.3F; 
               if (b3 != 0) f = 0.0F; 
               f = (float)(f + this.cd.bounce[this.cn] - 0.2D); if (f < 1.1D) f = 1.1F; 
               regx(b9, -Math.abs(this.scx[b9] * f * paramTrackers.dam[i12]), paramContO);
               this.scx[b9] = this.scx[b9] - Math.abs(this.scx[b9] * f);
               this.skid = 2;
               bool3 = true;
               arrayOfBoolean1[b9] = true;
               if (!paramTrackers.notwall[i12]) paramControl.wall = i12;
             
             } 
           }
           
           if (paramTrackers.zy[i12] != 0 && paramTrackers.zy[i12] != 90 && paramTrackers.zy[i12] != -90) {
             
             int i13 = 90 + paramTrackers.zy[i12];
             float f6 = 1.0F + (50 - Math.abs(paramTrackers.zy[i12])) / 30.0F; if (f6 < 1.0F) f6 = 1.0F; 
             float f7 = paramTrackers.y[i12] + (arrayOfFloat3[b9] - paramTrackers.y[i12]) * this.m.cos(i13) - (arrayOfFloat2[b9] - paramTrackers.z[i12]) * this.m.sin(i13);
             float f8 = paramTrackers.z[i12] + (arrayOfFloat3[b9] - paramTrackers.y[i12]) * this.m.sin(i13) + (arrayOfFloat2[b9] - paramTrackers.z[i12]) * this.m.cos(i13);
             if (f8 > paramTrackers.z[i12] && f8 < (paramTrackers.z[i12] + 200)) { this.scy[b9] = this.scy[b9] - (f8 - paramTrackers.z[i12]) / f6; f8 = paramTrackers.z[i12]; }
              if (f8 > (paramTrackers.z[i12] - 30)) { if (paramTrackers.skd[i12] == 2) { b7++; } else { b5++; }  this.wtouch = true; this.gtouch = false; if (this.capsized && (paramTrackers.skd[i12] == 0 || paramTrackers.skd[i12] == 1)) { paramContO.sprk(arrayOfFloat1[b9], arrayOfFloat3[b9], arrayOfFloat2[b9], this.scx[b9], this.scy[b9], this.scz[b9], 1); if (this.im == this.xt.im) this.xt.gscrape((int)this.scx[b9], (int)this.scy[b9], (int)this.scz[b9]);  }  if (b3 == 0 && i4 != 0) { float f = 1.4F; paramContO.dust(b9, arrayOfFloat1[b9], arrayOfFloat3[b9], arrayOfFloat2[b9], (int)this.scx[b9], (int)this.scz[b9], f * this.cd.simag[this.cn], 0, (this.capsized && this.mtouch)); }  }
              arrayOfFloat3[b9] = paramTrackers.y[i12] + (f7 - paramTrackers.y[i12]) * this.m.cos(-i13) - (f8 - paramTrackers.z[i12]) * this.m.sin(-i13);
             arrayOfFloat2[b9] = paramTrackers.z[i12] + (f7 - paramTrackers.y[i12]) * this.m.sin(-i13) + (f8 - paramTrackers.z[i12]) * this.m.cos(-i13);
             arrayOfBoolean1[b9] = true;
           } 
           
           if (paramTrackers.xy[i12] != 0 && paramTrackers.xy[i12] != 90 && paramTrackers.xy[i12] != -90) {
             
             int i13 = 90 + paramTrackers.xy[i12];
             float f6 = 1.0F + (50 - Math.abs(paramTrackers.xy[i12])) / 30.0F; if (f6 < 1.0F) f6 = 1.0F; 
             float f7 = paramTrackers.y[i12] + (arrayOfFloat3[b9] - paramTrackers.y[i12]) * this.m.cos(i13) - (arrayOfFloat1[b9] - paramTrackers.x[i12]) * this.m.sin(i13);
             float f8 = paramTrackers.x[i12] + (arrayOfFloat3[b9] - paramTrackers.y[i12]) * this.m.sin(i13) + (arrayOfFloat1[b9] - paramTrackers.x[i12]) * this.m.cos(i13);
             if (f8 > paramTrackers.x[i12] && f8 < (paramTrackers.x[i12] + 200)) { this.scy[b9] = this.scy[b9] - (f8 - paramTrackers.x[i12]) / f6; f8 = paramTrackers.x[i12]; }
              if (f8 > (paramTrackers.x[i12] - 30)) { if (paramTrackers.skd[i12] == 2) { b7++; } else { b5++; }  this.wtouch = true; this.gtouch = false; if (this.capsized && (paramTrackers.skd[i12] == 0 || paramTrackers.skd[i12] == 1)) { paramContO.sprk(arrayOfFloat1[b9], arrayOfFloat3[b9], arrayOfFloat2[b9], this.scx[b9], this.scy[b9], this.scz[b9], 1); if (this.im == this.xt.im) this.xt.gscrape((int)this.scx[b9], (int)this.scy[b9], (int)this.scz[b9]);  }  if (b3 == 0 && i4 != 0) { float f = 1.4F; paramContO.dust(b9, arrayOfFloat1[b9], arrayOfFloat3[b9], arrayOfFloat2[b9], (int)this.scx[b9], (int)this.scz[b9], f * this.cd.simag[this.cn], 0, (this.capsized && this.mtouch)); }  }
              arrayOfFloat3[b9] = paramTrackers.y[i12] + (f7 - paramTrackers.y[i12]) * this.m.cos(-i13) - (f8 - paramTrackers.x[i12]) * this.m.sin(-i13);
             arrayOfFloat1[b9] = paramTrackers.x[i12] + (f7 - paramTrackers.y[i12]) * this.m.sin(-i13) + (f8 - paramTrackers.x[i12]) * this.m.cos(-i13);
             arrayOfBoolean1[b9] = true;
           } 
         } 
       } 
       
       if (b7 == 4) this.mtouch = true; 
       if (b8 == 4) b4 = 4; 
     } 
     if (b5 == 4) this.mtouch = true;
     
     for (i5 = 0; i5 < 4; ) { for (byte b = 0; b < 4; ) { if (this.crank[i5][b] == this.lcrank[i5][b]) this.crank[i5][b] = 0;  this.lcrank[i5][b] = this.crank[i5][b]; b++; }  i5++; }
 
     
     i5 = 0; int i6 = 0, i7 = 0, i8 = 0;
     
     if (this.scy[2] != this.scy[0]) {
       
       if (this.scy[2] < this.scy[0]) { b1 = -1; } else { b1 = 1; }
        d = Math.sqrt(((arrayOfFloat2[0] - arrayOfFloat2[2]) * (arrayOfFloat2[0] - arrayOfFloat2[2]) + (arrayOfFloat3[0] - arrayOfFloat3[2]) * (arrayOfFloat3[0] - arrayOfFloat3[2]) + (arrayOfFloat1[0] - arrayOfFloat1[2]) * (arrayOfFloat1[0] - arrayOfFloat1[2]))) / (Math.abs(paramContO.keyz[0]) + Math.abs(paramContO.keyz[2]));
       if (d >= 0.9998D) { i5 = b1; } else { i5 = (int)(Math.acos(d) / 0.017453292519943295D * b1); }
     
     } 
     if (this.scy[3] != this.scy[1]) {
       
       if (this.scy[3] < this.scy[1]) { b1 = -1; } else { b1 = 1; }
        d = Math.sqrt(((arrayOfFloat2[1] - arrayOfFloat2[3]) * (arrayOfFloat2[1] - arrayOfFloat2[3]) + (arrayOfFloat3[1] - arrayOfFloat3[3]) * (arrayOfFloat3[1] - arrayOfFloat3[3]) + (arrayOfFloat1[1] - arrayOfFloat1[3]) * (arrayOfFloat1[1] - arrayOfFloat1[3]))) / (Math.abs(paramContO.keyz[1]) + Math.abs(paramContO.keyz[3]));
       if (d >= 0.9998D) { i6 = b1; } else { i6 = (int)(Math.acos(d) / 0.017453292519943295D * b1); }
     
     } 
     
     if (this.scy[1] != this.scy[0]) {
       
       if (this.scy[1] < this.scy[0]) { b1 = -1; } else { b1 = 1; }
        d = Math.sqrt(((arrayOfFloat2[0] - arrayOfFloat2[1]) * (arrayOfFloat2[0] - arrayOfFloat2[1]) + (arrayOfFloat3[0] - arrayOfFloat3[1]) * (arrayOfFloat3[0] - arrayOfFloat3[1]) + (arrayOfFloat1[0] - arrayOfFloat1[1]) * (arrayOfFloat1[0] - arrayOfFloat1[1]))) / (Math.abs(paramContO.keyx[0]) + Math.abs(paramContO.keyx[1]));
       if (d >= 0.9998D) { i7 = b1; } else { i7 = (int)(Math.acos(d) / 0.017453292519943295D * b1); }
     
     } 
     if (this.scy[3] != this.scy[2]) {
       
       if (this.scy[3] < this.scy[2]) { b1 = -1; } else { b1 = 1; }
        d = Math.sqrt(((arrayOfFloat2[2] - arrayOfFloat2[3]) * (arrayOfFloat2[2] - arrayOfFloat2[3]) + (arrayOfFloat3[2] - arrayOfFloat3[3]) * (arrayOfFloat3[2] - arrayOfFloat3[3]) + (arrayOfFloat1[2] - arrayOfFloat1[3]) * (arrayOfFloat1[2] - arrayOfFloat1[3]))) / (Math.abs(paramContO.keyx[2]) + Math.abs(paramContO.keyx[3]));
       if (d >= 0.9998D) { i8 = b1; } else { i8 = (int)(Math.acos(d) / 0.017453292519943295D * b1); }
     
     } 
     if (bool3) { int i12; for (i12 = Math.abs(paramContO.xz + 45); i12 > 180; i12 -= 360); if (Math.abs(i12) > 90) { this.pmlt = 1; } else { this.pmlt = -1; }  for (i12 = Math.abs(paramContO.xz - 45); i12 > 180; i12 -= 360); if (Math.abs(i12) > 90) { this.nmlt = 1; } else { this.nmlt = -1; }  }
      paramContO.xz = (int)(paramContO.xz + this.forca * (this.scz[0] * this.nmlt - this.scz[1] * this.pmlt + this.scz[2] * this.pmlt - this.scz[3] * this.nmlt + this.scx[0] * this.pmlt + this.scx[1] * this.nmlt - this.scx[2] * this.nmlt - this.scx[3] * this.pmlt));
     
     if (Math.abs(i6) > Math.abs(i5)) i5 = i6; 
     if (Math.abs(i8) > Math.abs(i7)) i7 = i8; 
     if (!bool1) { this.pzy += i5; } else { this.pzy -= i5; }
      if (!bool4) { this.pxy += i7; } else { this.pxy -= i7; }
     
     if (b4 == 4) {
       
       byte b = 0;
       while (this.pzy < 360) { this.pzy += 360; paramContO.zy += 360; }
        while (this.pzy > 360) { this.pzy -= 360; paramContO.zy -= 360; }
        if (this.pzy < 190 && this.pzy > 170) { this.pzy = 180; paramContO.zy = 180; b++; }
        if (this.pzy > 350 || this.pzy < 10) { this.pzy = 0; paramContO.zy = 0; b++; }
        while (this.pxy < 360) { this.pxy += 360; paramContO.xy += 360; }
        while (this.pxy > 360) { this.pxy -= 360; paramContO.xy -= 360; }
        if (this.pxy < 190 && this.pxy > 170) { this.pxy = 180; paramContO.xy = 180; b++; }
        if (this.pxy > 350 || this.pxy < 10) { this.pxy = 0; paramContO.xy = 0; b++; }
        if (b == 2) this.mtouch = true;
     
     } 
     if (!this.mtouch && this.wtouch) { if (this.cntouch == 10) { this.mtouch = true; } else { this.cntouch++; }  } else { this.cntouch = 0; }
 
     
     paramContO.y = (int)((arrayOfFloat3[0] + arrayOfFloat3[1] + arrayOfFloat3[2] + arrayOfFloat3[3]) / 4.0F - k * this.m.cos(this.pzy) * this.m.cos(this.pxy) + f3);
     if (bool1) { b1 = -1; } else { b1 = 1; }
      paramContO.x = (int)((arrayOfFloat1[0] - paramContO.keyx[0] * this.m.cos(paramContO.xz) + (b1 * paramContO.keyz[0]) * this.m.sin(paramContO.xz) + arrayOfFloat1[1] - paramContO.keyx[1] * this.m.cos(paramContO.xz) + (b1 * paramContO.keyz[1]) * this.m.sin(paramContO.xz) + arrayOfFloat1[2] - paramContO.keyx[2] * this.m.cos(paramContO.xz) + (b1 * paramContO.keyz[2]) * this.m.sin(paramContO.xz) + arrayOfFloat1[3] - paramContO.keyx[3] * this.m.cos(paramContO.xz) + (b1 * paramContO.keyz[3]) * this.m.sin(paramContO.xz)) / 4.0F + k * this.m.sin(this.pxy) * this.m.cos(paramContO.xz) - k * this.m.sin(this.pzy) * this.m.sin(paramContO.xz) + f1);
     paramContO.z = (int)((arrayOfFloat2[0] - (b1 * paramContO.keyz[0]) * this.m.cos(paramContO.xz) - paramContO.keyx[0] * this.m.sin(paramContO.xz) + arrayOfFloat2[1] - (b1 * paramContO.keyz[1]) * this.m.cos(paramContO.xz) - paramContO.keyx[1] * this.m.sin(paramContO.xz) + arrayOfFloat2[2] - (b1 * paramContO.keyz[2]) * this.m.cos(paramContO.xz) - paramContO.keyx[2] * this.m.sin(paramContO.xz) + arrayOfFloat2[3] - (b1 * paramContO.keyz[3]) * this.m.cos(paramContO.xz) - paramContO.keyx[3] * this.m.sin(paramContO.xz)) / 4.0F + k * this.m.sin(this.pxy) * this.m.sin(paramContO.xz) - k * this.m.sin(this.pzy) * this.m.cos(paramContO.xz) + f2);
     
     if (Math.abs(this.speed) > 10.0F || !this.mtouch) {
       
       if (Math.abs(this.pxy - paramContO.xy) >= 4) { if (this.pxy > paramContO.xy) { paramContO.xy += 2 + (this.pxy - paramContO.xy) / 2; } else { paramContO.xy -= 2 + (paramContO.xy - this.pxy) / 2; }  } else { paramContO.xy = this.pxy; }
        if (Math.abs(this.pzy - paramContO.zy) >= 4) { if (this.pzy > paramContO.zy) { paramContO.zy += 2 + (this.pzy - paramContO.zy) / 2; } else { paramContO.zy -= 2 + (paramContO.zy - this.pzy) / 2; }  } else { paramContO.zy = this.pzy; }
     
     } 
     if (this.wtouch && !this.capsized) { float f = (float)((this.speed / this.cd.swits[this.cn][2] * 14.0F) * (this.cd.bounce[this.cn] - 0.4D)); if (paramControl.left && this.tilt < f && this.tilt >= 0.0F) { this.tilt = (float)(this.tilt + 0.4D); } else if (paramControl.right && this.tilt > -f && this.tilt <= 0.0F) { this.tilt = (float)(this.tilt - 0.4D); } else if (Math.abs(this.tilt) > 3.0D * (this.cd.bounce[this.cn] - 0.4D)) { if (this.tilt > 0.0F) { this.tilt = (float)(this.tilt - 3.0D * (this.cd.bounce[this.cn] - 0.3D)); } else { this.tilt = (float)(this.tilt + 3.0D * (this.cd.bounce[this.cn] - 0.3D)); }  } else { this.tilt = 0.0F; }  paramContO.xy = (int)(paramContO.xy + this.tilt); if (this.gtouch) paramContO.y = (int)(paramContO.y - this.tilt / 1.5D);  } else if (this.tilt != 0.0F) { this.tilt = 0.0F; }
      if (this.wtouch && i4 == 2) { paramContO.zy += (int)((this.m.random() * 6.0F * this.speed / this.cd.swits[this.cn][2] - 3.0F * this.speed / this.cd.swits[this.cn][2]) * (this.cd.bounce[this.cn] - 0.3D)); paramContO.xy += (int)((this.m.random() * 6.0F * this.speed / this.cd.swits[this.cn][2] - 3.0F * this.speed / this.cd.swits[this.cn][2]) * (this.cd.bounce[this.cn] - 0.3D)); }
      if (this.wtouch && i4 == 1) { paramContO.zy += (int)((this.m.random() * 4.0F * this.speed / this.cd.swits[this.cn][2] - 2.0F * this.speed / this.cd.swits[this.cn][2]) * (this.cd.bounce[this.cn] - 0.3D)); paramContO.xy += (int)((this.m.random() * 4.0F * this.speed / this.cd.swits[this.cn][2] - 2.0F * this.speed / this.cd.swits[this.cn][2]) * (this.cd.bounce[this.cn] - 0.3D)); }
 
     
     if (this.hitmag >= this.cd.maxmag[this.cn] && !this.dest) { distruct(paramContO); if (this.cntdest == 7) { this.dest = true; } else { this.cntdest++; }  if (this.cntdest == 1) this.rpd.dest[this.im] = 300;  }
      if (paramContO.dist == 0) for (byte b = 0; b < paramContO.npl; ) { if ((paramContO.p[b]).chip != 0) (paramContO.p[b]).chip = 0;  if ((paramContO.p[b]).embos != 0) (paramContO.p[b]).embos = 13;  b++; }
     
     
     int i9 = 0, i10 = 0;
     int i11 = 0;
     if (this.nofocus) { b2 = 1; } else { b2 = 7; }
      byte b6; for (b6 = 0; b6 < paramCheckPoints.n; b6++) {
       
       if (paramCheckPoints.typ[b6] > 0) {
         
         i11++;
         if (paramCheckPoints.typ[b6] == 1) { if (this.clear == i11 + this.nlaps * paramCheckPoints.nsp) b2 = 1;  if (Math.abs(paramContO.z - paramCheckPoints.z[b6]) < 60.0F + Math.abs(this.scz[0] + this.scz[1] + this.scz[2] + this.scz[3]) / 4.0F && Math.abs(paramContO.x - paramCheckPoints.x[b6]) < 700 && Math.abs(paramContO.y - paramCheckPoints.y[b6] + 350) < 450 && this.clear == i11 + this.nlaps * paramCheckPoints.nsp - 1) { this.clear = i11 + this.nlaps * paramCheckPoints.nsp; this.pcleared = b6; this.focus = -1; }  }
          if (paramCheckPoints.typ[b6] == 2) { if (this.clear == i11 + this.nlaps * paramCheckPoints.nsp) b2 = 1;  if (Math.abs(paramContO.x - paramCheckPoints.x[b6]) < 60.0F + Math.abs(this.scx[0] + this.scx[1] + this.scx[2] + this.scx[3]) / 4.0F && Math.abs(paramContO.z - paramCheckPoints.z[b6]) < 700 && Math.abs(paramContO.y - paramCheckPoints.y[b6] + 350) < 450 && this.clear == i11 + this.nlaps * paramCheckPoints.nsp - 1) { this.clear = i11 + this.nlaps * paramCheckPoints.nsp; this.pcleared = b6; this.focus = -1; }  }
       
       }  if (py(paramContO.x / 100, paramCheckPoints.x[b6] / 100, paramContO.z / 100, paramCheckPoints.z[b6] / 100) * b2 < i10 || i10 == 0) { i9 = b6; i10 = py(paramContO.x / 100, paramCheckPoints.x[b6] / 100, paramContO.z / 100, paramCheckPoints.z[b6] / 100) * b2; }
     
     } 
     if (this.clear == i11 + this.nlaps * paramCheckPoints.nsp) { this.nlaps++; if (this.xt.multion == 1 && this.im == this.xt.im) { if (this.xt.laptime < this.xt.fastestlap || this.xt.fastestlap == 0) this.xt.fastestlap = this.xt.laptime;  this.xt.laptime = 0; }
        }
      if (this.im == this.xt.im) {
       
       if (this.xt.multion == 1 && this.xt.starcnt == 0) this.xt.laptime++; 
       for (this.m.checkpoint = this.clear; this.m.checkpoint >= paramCheckPoints.nsp; this.m.checkpoint -= paramCheckPoints.nsp);
       if (this.clear == paramCheckPoints.nlaps * paramCheckPoints.nsp - 1) this.m.lastcheck = true; 
       if (paramCheckPoints.haltall) this.m.lastcheck = false;
     
     } 
     if (this.focus == -1) {
       
       if (this.im == this.xt.im) { i9 += 2; } else { i9++; }
       
       if (!this.nofocus) {
         
         i11 = this.pcleared + 1; if (i11 >= paramCheckPoints.n) i11 = 0; 
         while (paramCheckPoints.typ[i11] <= 0) { if (++i11 >= paramCheckPoints.n) i11 = 0;  }
          if (i9 > i11 && (this.clear != this.nlaps * paramCheckPoints.nsp || i9 < this.pcleared)) this.focus = i9 = i11; 
       } 
       if (i9 >= paramCheckPoints.n) i9 -= paramCheckPoints.n; 
       if (paramCheckPoints.typ[i9] == -3) i9 = 0; 
       if (this.im == this.xt.im) { if (this.missedcp != -1) this.missedcp = -1;  } else if (this.missedcp != 0) { this.missedcp = 0; }
     
     } else {
       
       i9 = this.focus;
       if (this.im == this.xt.im) {
         
         if (this.missedcp == 0 && this.mtouch && Math.sqrt(py(paramContO.x / 10, paramCheckPoints.x[this.focus] / 10, paramContO.z / 10, paramCheckPoints.z[this.focus] / 10)) > 800.0D) this.missedcp = 1; 
         if (this.missedcp == -2 && Math.sqrt(py(paramContO.x / 10, paramCheckPoints.x[this.focus] / 10, paramContO.z / 10, paramCheckPoints.z[this.focus] / 10)) < 400.0D) this.missedcp = 0; 
         if (this.missedcp != 0 && this.mtouch && Math.sqrt(py(paramContO.x / 10, paramCheckPoints.x[this.focus] / 10, paramContO.z / 10, paramCheckPoints.z[this.focus] / 10)) < 250.0D) this.missedcp = 68;
       
       } else {
         
         this.missedcp = 1;
       } 
       if (this.nofocus) { this.focus = -1; this.missedcp = 0; }
     
     } 
     if (this.nofocus) this.nofocus = false; 
     this.point = i9;
     
     if (this.fixes != 0)
     
     { if (this.m.noelec == 0) for (b6 = 0; b6 < paramCheckPoints.fn; ) { if (!paramCheckPoints.roted[b6]) { if (Math.abs(paramContO.z - paramCheckPoints.fz[b6]) < 200 && py(paramContO.x / 100, paramCheckPoints.fx[b6] / 100, paramContO.y / 100, paramCheckPoints.fy[b6] / 100) < 30) { if (paramContO.dist == 0) { paramContO.fcnt = 8; } else { if (this.im == this.xt.im && !paramContO.fix && !this.xt.mutes) this.xt.carfixed.play();  paramContO.fix = true; }  this.rpd.fix[this.im] = 300; }  } else if (Math.abs(paramContO.x - paramCheckPoints.fx[b6]) < 200 && py(paramContO.z / 100, paramCheckPoints.fz[b6] / 100, paramContO.y / 100, paramCheckPoints.fy[b6] / 100) < 30) { if (paramContO.dist == 0) { paramContO.fcnt = 8; } else { if (this.im == this.xt.im && !paramContO.fix && !this.xt.mutes) this.xt.carfixed.play();  paramContO.fix = true; }  this.rpd.fix[this.im] = 300; }  b6++; }
           }
     else { for (b6 = 0; b6 < paramCheckPoints.fn; ) { if (rpy((paramContO.x / 100), (paramCheckPoints.fx[b6] / 100), (paramContO.y / 100), (paramCheckPoints.fy[b6] / 100), (paramContO.z / 100), (paramCheckPoints.fz[b6] / 100)) < 760) this.m.noelec = 2;  b6++; }
        }
      if (paramContO.fcnt == 7 || paramContO.fcnt == 8) { this.squash = 0; this.nbsq = 0; this.hitmag = 0; this.cntdest = 0; this.dest = false; this.newcar = true; paramContO.fcnt = 9; if (this.fixes > 0) this.fixes--;  }
      if (this.newedcar != 0) { this.newedcar--; if (this.newedcar == 10) this.newcar = false;  }
     
     if (!this.mtouch) {
       
       if (this.trcnt != 1) { this.trcnt = 1; this.lxz = paramContO.xz; }
        if (this.loop == 2 || this.loop == -1) { this.travxy = (int)(this.travxy + this.rcomp - this.lcomp); if (Math.abs(this.travxy) > 135) this.rtab = true;  this.travzy = (int)(this.travzy + this.ucomp - this.dcomp); if (this.travzy > 135) this.ftab = true;  if (this.travzy < -135) this.btab = true;  }  if (this.lxz != paramContO.xz) { this.travxz += this.lxz - paramContO.xz; this.lxz = paramContO.xz; }
        if (this.srfcnt < 10) { if (paramControl.wall != -1) this.surfer = true;  this.srfcnt++; }
 
     
     }
     else if (!this.dest) {
       
       if (!this.capsized) {
         
         if (this.capcnt != 0) this.capcnt = 0; 
         if (this.gtouch)
         {
           if (this.trcnt != 0) {
             
             if (this.trcnt == 9) {
               
               this.powerup = 0.0F;
               if (Math.abs(this.travxy) > 90) { this.powerup += Math.abs(this.travxy) / 24.0F; } else if (this.rtab) { this.powerup += 30.0F; }
                if (Math.abs(this.travzy) > 90) { this.powerup += Math.abs(this.travzy) / 18.0F; } else { if (this.ftab) this.powerup += 40.0F;  if (this.btab) this.powerup += 40.0F;  }
                if (Math.abs(this.travxz) > 90) this.powerup += Math.abs(this.travxz) / 18.0F; 
               if (this.surfer) this.powerup += 30.0F; 
               this.power += this.powerup;
               if (this.im == this.xt.im && (int)this.powerup > this.rpd.powered && this.rpd.wasted == 0 && (this.powerup > 60.0F || paramCheckPoints.stage == 1 || paramCheckPoints.stage == 2)) { this.rpdcatch = 30; if (this.rpd.hcaught) this.rpd.powered = (int)this.powerup;  if (this.xt.multion == 1 && this.powerup > this.xt.beststunt) this.xt.beststunt = (int)this.powerup;  }
                if (this.power > 98.0F) { this.power = 98.0F; if (this.powerup > 150.0F) { this.xtpower = 200; } else { this.xtpower = 100; }  }
             
             }  if (this.trcnt == 10) { this.travxy = 0; this.travzy = 0; this.travxz = 0; this.ftab = false; this.rtab = false; this.btab = false; this.trcnt = 0; this.srfcnt = 0; this.surfer = false; } else { this.trcnt++; }
           
           } 
         }
       } else {
         
         if (this.trcnt != 0) { this.travxy = 0; this.travzy = 0; this.travxz = 0; this.ftab = false; this.rtab = false; this.btab = false; this.trcnt = 0; this.srfcnt = 0; this.surfer = false; }
          if (this.capcnt == 0) { byte b; for (b6 = 0, b = 0; b < 4; ) { if (Math.abs(this.scz[b]) < 70.0F && Math.abs(this.scx[b]) < 70.0F) b6++;  b++; }  if (b6 == 4) this.capcnt = 1;  } else { this.capcnt++; if (this.capcnt == 30) { this.speed = 0.0F; paramContO.y += this.cd.flipy[this.cn]; this.pxy += 180; paramContO.xy += 180; this.capcnt = 0; }
            }
       
       }  if (this.trcnt == 0 && this.speed != 0.0F) if (this.xtpower == 0) { if (this.power > 0.0F) { this.power -= this.power * this.power * this.power / this.cd.powerloss[this.cn]; } else { this.power = 0.0F; }  } else { this.xtpower--; }
       
     
     } 
     if (this.im == this.xt.im) { if (paramControl.wall != -1) paramControl.wall = -1;  } else if (this.lastcolido != 0 && !this.dest) { this.lastcolido--; }
      if (this.dest) { if (paramCheckPoints.dested[this.im] == 0) if (this.lastcolido == 0) { paramCheckPoints.dested[this.im] = 1; } else { paramCheckPoints.dested[this.im] = 2; }   } else if (paramCheckPoints.dested[this.im] != 0 && paramCheckPoints.dested[this.im] != 3) { paramCheckPoints.dested[this.im] = 0; }
     
     if (this.im == this.xt.im && this.rpd.wasted == 0 && this.rpdcatch != 0) { this.rpdcatch--; if (this.rpdcatch == 0) { this.rpd.cotchinow(this.im); if (this.rpd.hcaught) this.rpd.whenwasted = (int)(185.0F + this.m.random() * 20.0F);  }
        }
   
   }
   
   public void distruct(ContO paramContO) {
     for (byte b = 0; b < paramContO.npl; ) { if ((paramContO.p[b]).wz == 0 || (paramContO.p[b]).gr == -17 || (paramContO.p[b]).gr == -16) (paramContO.p[b]).embos = 1;  b++; }
   
   }
 
   
   public Mad(CarDefine paramCarDefine, Medium paramMedium, Record paramRecord, xtGraphics paramxtGraphics, int paramInt) {
     this.colidim = false; this.cd = paramCarDefine; this.m = paramMedium; this.rpd = paramRecord; this.xt = paramxtGraphics;
     this.im = paramInt; } public int regy(int paramInt, float paramFloat, ContO paramContO) { int i = 0; boolean bool = true; if (this.xt.multion == 1 && this.xt.im != this.im) bool = false;  if (this.xt.multion >= 2) bool = false;  if (this.xt.lan && this.xt.multion >= 1 && this.xt.isbot[this.im]) bool = true;  paramFloat *= this.cd.dammult[this.cn]; if (paramFloat > 100.0F) { this.rpd.recy(paramInt, paramFloat, this.mtouch, this.im); byte b1, b2; int j, k; for (paramFloat -= 100.0F, b1 = 0, b2 = 0, j = paramContO.zy, k = paramContO.xy; j < 360; j += 360); for (; j > 360; j -= 360); if (j < 210 && j > 150) b1 = -1;  if (j > 330 || j < 30) b1 = 1;  for (; k < 360; k += 360); for (; k > 360; k -= 360); if (k < 210 && k > 150) b2 = -1;  if (k > 330 || k < 30) b2 = 1;  if (b2 * b1 == 0) this.shakedam = (int)((Math.abs(paramFloat) + this.shakedam) / 2.0F);  if (this.im == this.xt.im || this.colidim) this.xt.crash(paramFloat, b2 * b1);  if (b2 * b1 == 0 || this.mtouch) for (byte b = 0; b < paramContO.npl; ) { float f; byte b3; for (f = 0.0F, b3 = 0; b3 < (paramContO.p[b]).n; ) { if ((paramContO.p[b]).wz == 0 && py(paramContO.keyx[paramInt], (paramContO.p[b]).ox[b3], paramContO.keyz[paramInt], (paramContO.p[b]).oz[b3]) < this.cd.clrad[this.cn]) { f = paramFloat / 20.0F * this.m.random(); (paramContO.p[b]).oz[b3] = (int)((paramContO.p[b]).oz[b3] + f * this.m.sin(j)); (paramContO.p[b]).ox[b3] = (int)((paramContO.p[b]).ox[b3] - f * this.m.sin(k)); if (bool) { this.hitmag = (int)(this.hitmag + Math.abs(f)); i = (int)(i + Math.abs(f)); }  }  b3++; }  if (f != 0.0F) { if (Math.abs(f) >= 1.0F) { (paramContO.p[b]).chip = 1; (paramContO.p[b]).ctmag = f; }  if (!(paramContO.p[b]).nocol && (paramContO.p[b]).glass != 1) { if ((paramContO.p[b]).bfase > 20 && (paramContO.p[b]).hsb[1] > 0.25D) (paramContO.p[b]).hsb[1] = 0.25F;  if ((paramContO.p[b]).bfase > 25 && (paramContO.p[b]).hsb[2] > 0.7D) (paramContO.p[b]).hsb[2] = 0.7F;  if ((paramContO.p[b]).bfase > 30 && (paramContO.p[b]).hsb[1] > 0.15D) (paramContO.p[b]).hsb[1] = 0.15F;  if ((paramContO.p[b]).bfase > 35 && (paramContO.p[b]).hsb[2] > 0.6D) (paramContO.p[b]).hsb[2] = 0.6F;  if ((paramContO.p[b]).bfase > 40) (paramContO.p[b]).hsb[0] = 0.075F;  if ((paramContO.p[b]).bfase > 50 && (paramContO.p[b]).hsb[2] > 0.5D) (paramContO.p[b]).hsb[2] = 0.5F;  if ((paramContO.p[b]).bfase > 60) (paramContO.p[b]).hsb[0] = 0.05F;  (paramContO.p[b]).bfase = (int)((paramContO.p[b]).bfase + f); new Color((paramContO.p[b]).c[0], (paramContO.p[b]).c[1], (paramContO.p[b]).c[2]); Color color = Color.getHSBColor((paramContO.p[b]).hsb[0], (paramContO.p[b]).hsb[1], (paramContO.p[b]).hsb[2]); (paramContO.p[b]).c[0] = color.getRed(); (paramContO.p[b]).c[1] = color.getGreen(); (paramContO.p[b]).c[2] = color.getBlue(); }  if ((paramContO.p[b]).glass == 1) (paramContO.p[b]).gr = (int)((paramContO.p[b]).gr + Math.abs(f * 1.5D));  }  b++; }   if (b2 * b1 == -1) if (this.nbsq > 0) { int m; byte b3; byte b4; for (m = 0, b3 = 1, b4 = 0; b4 < paramContO.npl; ) { float f; byte b; for (f = 0.0F, b = 0; b < (paramContO.p[b4]).n; ) { if ((paramContO.p[b4]).wz == 0) { f = paramFloat / 15.0F * this.m.random(); if ((Math.abs((paramContO.p[b4]).oy[b] - this.cd.flipy[this.cn] - this.squash) < this.cd.msquash[this.cn] * 3 || (paramContO.p[b4]).oy[b] < this.cd.flipy[this.cn] + this.squash) && this.squash < this.cd.msquash[this.cn]) { (paramContO.p[b4]).oy[b] = (int)((paramContO.p[b4]).oy[b] + f); m = (int)(m + f); b3++; if (bool) { this.hitmag = (int)(this.hitmag + Math.abs(f)); i = (int)(i + Math.abs(f)); }  }  }  b++; }  if ((paramContO.p[b4]).glass == 1) { (paramContO.p[b4]).gr += 5; } else if (f != 0.0F) { (paramContO.p[b4]).bfase = (int)((paramContO.p[b4]).bfase + f); }  if (Math.abs(f) >= 1.0F) { (paramContO.p[b4]).chip = 1; (paramContO.p[b4]).ctmag = f; }  b4++; }  this.squash += m / b3; this.nbsq = 0; } else { this.nbsq++; }   }  return i; }
   public int regx(int paramInt, float paramFloat, ContO paramContO) { int i = 0; boolean bool = true; if (this.xt.multion == 1 && this.xt.im != this.im) bool = false;  if (this.xt.multion >= 2) bool = false;  if (this.xt.lan && this.xt.multion >= 1 && this.xt.isbot[this.im]) bool = true;  paramFloat *= this.cd.dammult[this.cn]; if (Math.abs(paramFloat) > 100.0F) { this.rpd.recx(paramInt, paramFloat, this.im); if (paramFloat > 100.0F) paramFloat -= 100.0F;  if (paramFloat < -100.0F) paramFloat += 100.0F;  this.shakedam = (int)((Math.abs(paramFloat) + this.shakedam) / 2.0F); if (this.im == this.xt.im || this.colidim) this.xt.crash(paramFloat, 0);  for (byte b = 0; b < paramContO.npl; ) { float f; byte b1; for (f = 0.0F, b1 = 0; b1 < (paramContO.p[b]).n; ) { if ((paramContO.p[b]).wz == 0 && py(paramContO.keyx[paramInt], (paramContO.p[b]).ox[b1], paramContO.keyz[paramInt], (paramContO.p[b]).oz[b1]) < this.cd.clrad[this.cn]) { f = paramFloat / 20.0F * this.m.random(); (paramContO.p[b]).oz[b1] = (int)((paramContO.p[b]).oz[b1] - f * this.m.sin(paramContO.xz) * this.m.cos(paramContO.zy)); (paramContO.p[b]).ox[b1] = (int)((paramContO.p[b]).ox[b1] + f * this.m.cos(paramContO.xz) * this.m.cos(paramContO.xy)); if (bool) { this.hitmag = (int)(this.hitmag + Math.abs(f)); i = (int)(i + Math.abs(f)); }  }  b1++; }  if (f != 0.0F) { if (Math.abs(f) >= 1.0F) { (paramContO.p[b]).chip = 1; (paramContO.p[b]).ctmag = f; }  if (!(paramContO.p[b]).nocol && (paramContO.p[b]).glass != 1) { if ((paramContO.p[b]).bfase > 20 && (paramContO.p[b]).hsb[1] > 0.25D) (paramContO.p[b]).hsb[1] = 0.25F;  if ((paramContO.p[b]).bfase > 25 && (paramContO.p[b]).hsb[2] > 0.7D) (paramContO.p[b]).hsb[2] = 0.7F;  if ((paramContO.p[b]).bfase > 30 && (paramContO.p[b]).hsb[1] > 0.15D) (paramContO.p[b]).hsb[1] = 0.15F;  if ((paramContO.p[b]).bfase > 35 && (paramContO.p[b]).hsb[2] > 0.6D) (paramContO.p[b]).hsb[2] = 0.6F;  if ((paramContO.p[b]).bfase > 40) (paramContO.p[b]).hsb[0] = 0.075F;  if ((paramContO.p[b]).bfase > 50 && (paramContO.p[b]).hsb[2] > 0.5D) (paramContO.p[b]).hsb[2] = 0.5F;  if ((paramContO.p[b]).bfase > 60) (paramContO.p[b]).hsb[0] = 0.05F;  (paramContO.p[b]).bfase = (int)((paramContO.p[b]).bfase + Math.abs(f)); new Color((paramContO.p[b]).c[0], (paramContO.p[b]).c[1], (paramContO.p[b]).c[2]); Color color = Color.getHSBColor((paramContO.p[b]).hsb[0], (paramContO.p[b]).hsb[1], (paramContO.p[b]).hsb[2]); (paramContO.p[b]).c[0] = color.getRed(); (paramContO.p[b]).c[1] = color.getGreen(); (paramContO.p[b]).c[2] = color.getBlue(); }  if ((paramContO.p[b]).glass == 1) (paramContO.p[b]).gr = (int)((paramContO.p[b]).gr + Math.abs(f * 1.5D));  }  b++; }  }  return i; } public int regz(int paramInt, float paramFloat, ContO paramContO) {
     int i = 0; boolean bool = true; if (this.xt.multion == 1 && this.xt.im != this.im) bool = false;  if (this.xt.multion >= 2) bool = false;  if (this.xt.lan && this.xt.multion >= 1 && this.xt.isbot[this.im]) bool = true;  paramFloat *= this.cd.dammult[this.cn]; if (Math.abs(paramFloat) > 100.0F) { this.rpd.recz(paramInt, paramFloat, this.im); if (paramFloat > 100.0F) paramFloat -= 100.0F;  if (paramFloat < -100.0F) paramFloat += 100.0F;  this.shakedam = (int)((Math.abs(paramFloat) + this.shakedam) / 2.0F); if (this.im == this.xt.im || this.colidim) this.xt.crash(paramFloat, 0);  for (byte b = 0; b < paramContO.npl; ) { float f; byte b1; for (f = 0.0F, b1 = 0; b1 < (paramContO.p[b]).n; ) { if ((paramContO.p[b]).wz == 0 && py(paramContO.keyx[paramInt], (paramContO.p[b]).ox[b1], paramContO.keyz[paramInt], (paramContO.p[b]).oz[b1]) < this.cd.clrad[this.cn]) { f = paramFloat / 20.0F * this.m.random(); (paramContO.p[b]).oz[b1] = (int)((paramContO.p[b]).oz[b1] + f * this.m.cos(paramContO.xz) * this.m.cos(paramContO.zy)); (paramContO.p[b]).ox[b1] = (int)((paramContO.p[b]).ox[b1] + f * this.m.sin(paramContO.xz) * this.m.cos(paramContO.xy)); if (bool) { this.hitmag = (int)(this.hitmag + Math.abs(f)); i = (int)(i + Math.abs(f)); }  }  b1++; }  if (f != 0.0F) { if (Math.abs(f) >= 1.0F) { (paramContO.p[b]).chip = 1; (paramContO.p[b]).ctmag = f; }  if (!(paramContO.p[b]).nocol && (paramContO.p[b]).glass != 1) { if ((paramContO.p[b]).bfase > 20 && (paramContO.p[b]).hsb[1] > 0.25D) (paramContO.p[b]).hsb[1] = 0.25F;  if ((paramContO.p[b]).bfase > 25 && (paramContO.p[b]).hsb[2] > 0.7D) (paramContO.p[b]).hsb[2] = 0.7F;  if ((paramContO.p[b]).bfase > 30 && (paramContO.p[b]).hsb[1] > 0.15D) (paramContO.p[b]).hsb[1] = 0.15F;  if ((paramContO.p[b]).bfase > 35 && (paramContO.p[b]).hsb[2] > 0.6D) (paramContO.p[b]).hsb[2] = 0.6F;  if ((paramContO.p[b]).bfase > 40) (paramContO.p[b]).hsb[0] = 0.075F;  if ((paramContO.p[b]).bfase > 50 && (paramContO.p[b]).hsb[2] > 0.5D) (paramContO.p[b]).hsb[2] = 0.5F;  if ((paramContO.p[b]).bfase > 60) (paramContO.p[b]).hsb[0] = 0.05F;  (paramContO.p[b]).bfase = (int)((paramContO.p[b]).bfase + Math.abs(f)); new Color((paramContO.p[b]).c[0], (paramContO.p[b]).c[1], (paramContO.p[b]).c[2]); Color color = Color.getHSBColor((paramContO.p[b]).hsb[0], (paramContO.p[b]).hsb[1], (paramContO.p[b]).hsb[2]); (paramContO.p[b]).c[0] = color.getRed(); (paramContO.p[b]).c[1] = color.getGreen(); (paramContO.p[b]).c[2] = color.getBlue(); }  if ((paramContO.p[b]).glass == 1) (paramContO.p[b]).gr = (int)((paramContO.p[b]).gr + Math.abs(f * 1.5D));  }  b++; }  }  return i;
   }
 
   
   public void colide(ContO paramContO1, Mad paramMad, ContO paramContO2) {
     float[] arrayOfFloat1 = new float[4], arrayOfFloat2 = new float[4], arrayOfFloat3 = new float[4];
     float[] arrayOfFloat4 = new float[4], arrayOfFloat5 = new float[4], arrayOfFloat6 = new float[4]; int i;
     for (i = 0; i < 4; ) { arrayOfFloat1[i] = (paramContO1.x + paramContO1.keyx[i]); if (this.capsized) { arrayOfFloat2[i] = (paramContO1.y + this.cd.flipy[this.cn] + this.squash); } else { arrayOfFloat2[i] = (paramContO1.y + paramContO1.grat); }  arrayOfFloat3[i] = (paramContO1.z + paramContO1.keyz[i]); arrayOfFloat4[i] = (paramContO2.x + paramContO2.keyx[i]); if (this.capsized) { arrayOfFloat5[i] = (paramContO2.y + this.cd.flipy[paramMad.cn] + paramMad.squash); } else { arrayOfFloat5[i] = (paramContO2.y + paramContO2.grat); }  arrayOfFloat6[i] = (paramContO2.z + paramContO2.keyz[i]); i++; }
      rot(arrayOfFloat1, arrayOfFloat2, paramContO1.x, paramContO1.y, paramContO1.xy, 4); rot(arrayOfFloat2, arrayOfFloat3, paramContO1.y, paramContO1.z, paramContO1.zy, 4); rot(arrayOfFloat1, arrayOfFloat3, paramContO1.x, paramContO1.z, paramContO1.xz, 4);
     rot(arrayOfFloat4, arrayOfFloat5, paramContO2.x, paramContO2.y, paramContO2.xy, 4); rot(arrayOfFloat5, arrayOfFloat6, paramContO2.y, paramContO2.z, paramContO2.zy, 4); rot(arrayOfFloat4, arrayOfFloat6, paramContO2.x, paramContO2.z, paramContO2.xz, 4);
     
     if (rpy(paramContO1.x, paramContO2.x, paramContO1.y, paramContO2.y, paramContO1.z, paramContO2.z) < (paramContO1.maxR * paramContO1.maxR + paramContO2.maxR * paramContO2.maxR) * 1.5D)
     
     { if (!this.caught[paramMad.im] && (this.speed != 0.0F || paramMad.speed != 0.0F)) {
         
         if (Math.abs(this.power * this.speed * this.cd.moment[this.cn]) != Math.abs(paramMad.power * paramMad.speed * this.cd.moment[paramMad.cn])) { if (Math.abs(this.power * this.speed * this.cd.moment[this.cn]) > Math.abs(paramMad.power * paramMad.speed * this.cd.moment[paramMad.cn])) { this.dominate[paramMad.im] = true; } else { this.dominate[paramMad.im] = false; }
           
            }
         else if (this.cd.moment[this.cn] > this.cd.moment[paramMad.cn]) { this.dominate[paramMad.im] = true; } else { this.dominate[paramMad.im] = false; }
         
         this.caught[paramMad.im] = true;
       }  }
     else if (this.caught[paramMad.im]) { this.caught[paramMad.im] = false; }
     
     i = 0; int j = 0;
     
     if (this.dominate[paramMad.im]) {
       
       int k = (int)(((this.scz[0] - paramMad.scz[0] + this.scz[1] - paramMad.scz[1] + this.scz[2] - paramMad.scz[2] + this.scz[3] - paramMad.scz[3]) * (this.scz[0] - paramMad.scz[0] + this.scz[1] - paramMad.scz[1] + this.scz[2] - paramMad.scz[2] + this.scz[3] - paramMad.scz[3]) + (this.scx[0] - paramMad.scx[0] + this.scx[1] - paramMad.scx[1] + this.scx[2] - paramMad.scx[2] + this.scx[3] - paramMad.scx[3]) * (this.scx[0] - paramMad.scx[0] + this.scx[1] - paramMad.scx[1] + this.scx[2] - paramMad.scx[2] + this.scx[3] - paramMad.scx[3])) / 16.0F);
       char c = '᭘';
       float f = 1.0F;
       if (this.xt.multion != 0) { c = '浠'; f = 1.27F; }
       
       for (byte b = 0; b < 4; b++) {
         
         for (byte b1 = 0; b1 < 4; b1++) {
           
           if (rpy(arrayOfFloat1[b], arrayOfFloat4[b1], arrayOfFloat2[b], arrayOfFloat5[b1], arrayOfFloat3[b], arrayOfFloat6[b1]) < (k + c) * (this.cd.comprad[paramMad.cn] + this.cd.comprad[this.cn])) {
 
             
             if (Math.abs(this.scx[b] * this.cd.moment[this.cn]) > Math.abs(paramMad.scx[b1] * this.cd.moment[paramMad.cn])) {
               
               float f1 = paramMad.scx[b1] * this.cd.revpush[this.cn]; if (f1 > 300.0F) f1 = 300.0F;  if (f1 < -300.0F) f1 = -300.0F; 
               float f2 = this.scx[b] * this.cd.push[this.cn]; if (f2 > 300.0F) f2 = 300.0F;  if (f2 < -300.0F) f2 = -300.0F;
               
               paramMad.scx[b1] = paramMad.scx[b1] + f2; if (this.im == this.xt.im) paramMad.colidim = true;  i += paramMad.regx(b1, f2 * this.cd.moment[this.cn] * f, paramContO2); if (paramMad.colidim) paramMad.colidim = false; 
               this.scx[b] = this.scx[b] - f1; j += regx(b, -f1 * this.cd.moment[this.cn] * f, paramContO1);
               
               this.scy[b] = this.scy[b] - this.cd.revlift[this.cn]; if (this.im == this.xt.im) paramMad.colidim = true;  i += paramMad.regy(b1, (this.cd.revlift[this.cn] * 7), paramContO2); if (paramMad.colidim) paramMad.colidim = false; 
               if (this.m.random() > this.m.random()) paramContO2.sprk((arrayOfFloat1[b] + arrayOfFloat4[b1]) / 2.0F, (arrayOfFloat2[b] + arrayOfFloat5[b1]) / 2.0F, (arrayOfFloat3[b] + arrayOfFloat6[b1]) / 2.0F, (paramMad.scx[b1] + this.scx[b]) / 4.0F, (paramMad.scy[b1] + this.scy[b]) / 4.0F, (paramMad.scz[b1] + this.scz[b]) / 4.0F, 2);
             
             } 
             if (Math.abs(this.scz[b] * this.cd.moment[this.cn]) > Math.abs(paramMad.scz[b1] * this.cd.moment[paramMad.cn])) {
               
               float f1 = paramMad.scz[b1] * this.cd.revpush[this.cn]; if (f1 > 300.0F) f1 = 300.0F;  if (f1 < -300.0F) f1 = -300.0F; 
               float f2 = this.scz[b] * this.cd.push[this.cn]; if (f2 > 300.0F) f2 = 300.0F;  if (f2 < -300.0F) f2 = -300.0F;
               
               paramMad.scz[b1] = paramMad.scz[b1] + f2; if (this.im == this.xt.im) paramMad.colidim = true;  i += paramMad.regz(b1, f2 * this.cd.moment[this.cn] * f, paramContO2); if (paramMad.colidim) paramMad.colidim = false; 
               this.scz[b] = this.scz[b] - f1; j += regz(b, -f1 * this.cd.moment[this.cn] * f, paramContO1);
               
               this.scy[b] = this.scy[b] - this.cd.revlift[this.cn]; if (this.im == this.xt.im) paramMad.colidim = true;  i += paramMad.regy(b1, (this.cd.revlift[this.cn] * 7), paramContO2); if (paramMad.colidim) paramMad.colidim = false; 
               if (this.m.random() > this.m.random()) paramContO2.sprk((arrayOfFloat1[b] + arrayOfFloat4[b1]) / 2.0F, (arrayOfFloat2[b] + arrayOfFloat5[b1]) / 2.0F, (arrayOfFloat3[b] + arrayOfFloat6[b1]) / 2.0F, (paramMad.scx[b1] + this.scx[b]) / 4.0F, (paramMad.scy[b1] + this.scy[b]) / 4.0F, (paramMad.scz[b1] + this.scz[b]) / 4.0F, 2);
             
             } 
             if (this.im == this.xt.im) paramMad.lastcolido = 70; 
             if (paramMad.im == this.xt.im) this.lastcolido = 70; 
             paramMad.scy[b1] = paramMad.scy[b1] - this.cd.lift[this.cn];
           } 
         } 
       } 
     } 
     
     if (this.xt.multion == 1) {
       
       if (paramMad.im == this.xt.im && i != 0) this.xt.dcrashes[this.im] = this.xt.dcrashes[this.im] + i; 
       if (this.im == this.xt.im && j != 0) this.xt.dcrashes[paramMad.im] = this.xt.dcrashes[paramMad.im] + j;
     
     } 
   }
   
   public void rot(float[] paramArrayOffloat1, float[] paramArrayOffloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
     if (paramInt3 != 0)
     {
       for (byte b = 0; b < paramInt4; b++) {
 
         
         float f1 = paramArrayOffloat1[b];
         float f2 = paramArrayOffloat2[b];
         paramArrayOffloat1[b] = paramInt1 + (f1 - paramInt1) * this.m.cos(paramInt3) - (f2 - paramInt2) * this.m.sin(paramInt3);
         paramArrayOffloat2[b] = paramInt2 + (f1 - paramInt1) * this.m.sin(paramInt3) + (f2 - paramInt2) * this.m.cos(paramInt3);
       } 
     }
   }
 
   
   public int rpy(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6) {
     return (int)((paramFloat1 - paramFloat2) * (paramFloat1 - paramFloat2) + (paramFloat3 - paramFloat4) * (paramFloat3 - paramFloat4) + (paramFloat5 - paramFloat6) * (paramFloat5 - paramFloat6));
   }
 
   
   public int py(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
     return (paramInt1 - paramInt2) * (paramInt1 - paramInt2) + (paramInt3 - paramInt4) * (paramInt3 - paramInt4);
   }
 }


