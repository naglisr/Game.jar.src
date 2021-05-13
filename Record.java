 import java.awt.Color;
 
 public class Record
 {
   Medium m;
   int caught = 0;
   
   boolean hcaught = false;
   boolean prepit = true;
   ContO[] ocar = new ContO[8];
   int cntf = 50;
   
   ContO[][] car = new ContO[6][8];
   int[][] squash = new int[6][8];
   
   int[] fix = new int[8];
   int[] dest = new int[8];
   
   int[][] x = new int[300][8];
   int[][] y = new int[300][8];
   int[][] z = new int[300][8];
   
   int[][] xy = new int[300][8];
   int[][] zy = new int[300][8];
   int[][] xz = new int[300][8];
   
   int[][] wxz = new int[300][8];
   int[][] wzy = new int[300][8];
   
   int[][] ns = new int[8][20];
   int[][][] sspark = new int[8][20][30];
   int[][][] sx = new int[8][20][30];
   int[][][] sy = new int[8][20][30];
   int[][][] sz = new int[8][20][30];
   float[][][] smag = new float[8][20][30];
   int[][][] scx = new int[8][20][30];
   int[][][] scz = new int[8][20][30];
   
   int[] nr = new int[8];
   int[][] rspark = new int[8][200];
   int[][] sprk = new int[8][200];
   int[][] srx = new int[8][200];
   int[][] sry = new int[8][200];
   int[][] srz = new int[8][200];
   float[][] rcx = new float[8][200];
   float[][] rcy = new float[8][200];
   float[][] rcz = new float[8][200];
   
   int[][] nry = new int[8][4];
   int[][][] ry = new int[8][4][7];
   int[][][] magy = new int[8][4][7];
   boolean[][] mtouch = new boolean[8][7];
   
   int[][] nrx = new int[8][4];
   int[][][] rx = new int[8][4][7];
   int[][][] magx = new int[8][4][7];
   int[][] nrz = new int[8][4];
   int[][][] rz = new int[8][4][7];
   int[][][] magz = new int[8][4][7];
   
   int[] checkpoint = new int[300];
   boolean[] lastcheck = new boolean[300];
 
 
   
   int wasted = 0;
   int whenwasted = 0;
   int powered = 0;
   int closefinish = 0;
   
   ContO[] starcar = new ContO[8];
   int[] hsquash = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
   int[] hfix = new int[] { -1, -1, -1, -1, -1, -1, -1, -1 };
   int[] hdest = new int[] { -1, -1, -1, -1, -1, -1, -1, -1 };
   
   int[][] hx = new int[300][8];
   int[][] hy = new int[300][8];
   int[][] hz = new int[300][8];
   int[][] hxy = new int[300][8];
   int[][] hzy = new int[300][8];
   int[][] hxz = new int[300][8];
   int[][] hwxz = new int[300][8];
   int[][] hwzy = new int[300][8];
   
   int[][][] hsspark = new int[8][20][30];
   int[][][] hsx = new int[8][20][30];
   int[][][] hsy = new int[8][20][30];
   int[][][] hsz = new int[8][20][30];
   float[][][] hsmag = new float[8][20][30];
   int[][][] hscx = new int[8][20][30];
   int[][][] hscz = new int[8][20][30];
   
   int[][] hrspark = new int[8][200];
   int[][] hsprk = new int[8][200];
   int[][] hsrx = new int[8][200];
   int[][] hsry = new int[8][200];
   int[][] hsrz = new int[8][200];
   float[][] hrcx = new float[8][200];
   float[][] hrcy = new float[8][200];
   float[][] hrcz = new float[8][200];
 
   
   int[][][] hry = new int[8][4][7];
   int[][][] hmagy = new int[8][4][7];
   int[][][] hrx = new int[8][4][7];
   int[][][] hmagx = new int[8][4][7];
   int[][][] hrz = new int[8][4][7];
   int[][][] hmagz = new int[8][4][7];
   
   boolean[][] hmtouch = new boolean[8][7];
   
   int[] hcheckpoint = new int[300];
   boolean[] hlastcheck = new boolean[300];
   
   public Record(Medium paramMedium) {
     this.m = paramMedium; this.caught = 0; cotchinow(0);
   }
   
   public void reset(ContO[] paramArrayOfContO) {
     this.caught = 0;
     this.hcaught = false;
     this.wasted = 0;
     this.whenwasted = 0;
     this.closefinish = 0;
     this.powered = 0;
     byte b;
     for (b = 0; b < 8; ) { if (this.prepit) this.starcar[b] = new ContO(paramArrayOfContO[b], 0, 0, 0, 0);  this.fix[b] = -1; this.dest[b] = -1; this.cntdest[b] = 0; b++; }
      for (b = 0; b < 6; ) { for (byte b1 = 0; b1 < 8; ) { this.car[b][b1] = new ContO(paramArrayOfContO[b1], 0, 0, 0, 0); this.squash[b][b1] = 0; b1++; }  b++; }
      for (b = 0; b < 8; b++) {
       byte b1;
       for (this.nr[b] = 0, b1 = 0; b1 < 'È'; ) { this.rspark[b][b1] = -1; b1++; }
        for (b1 = 0; b1 < 20; ) { byte b2; for (this.ns[b][b1] = 0, b2 = 0; b2 < 30; ) { this.sspark[b][b1][b2] = -1; b2++; }  b1++; }
        for (b1 = 0; b1 < 4; ) { byte b2; for (this.nry[b][b1] = 0, this.nrx[b][b1] = 0, this.nrz[b][b1] = 0, b2 = 0; b2 < 7; ) { this.ry[b][b1][b2] = -1; this.rx[b][b1][b2] = -1; this.rz[b][b1][b2] = -1; b2++; }  b1++; }
     
     }  this.prepit = false;
   }
 
   
   public void cotchinow(int paramInt) {
     if (this.caught >= 300) {
       
       this.wasted = paramInt;
       byte b;
       for (b = 0; b < 8; ) { this.starcar[b] = new ContO(this.car[0][b], 0, 0, 0, 0); this.hsquash[b] = this.squash[0][b]; this.hfix[b] = this.fix[b]; this.hdest[b] = this.dest[b]; b++; }
       
       for (b = 0; b < 'Ĭ'; b++) {
         
         for (byte b1 = 0; b1 < 8; b1++) {
           
           this.hx[b][b1] = this.x[b][b1];
           this.hy[b][b1] = this.y[b][b1];
           this.hz[b][b1] = this.z[b][b1];
           this.hxy[b][b1] = this.xy[b][b1];
           this.hzy[b][b1] = this.zy[b][b1];
           this.hxz[b][b1] = this.xz[b][b1];
           this.hwxz[b][b1] = this.wxz[b][b1];
           this.hwzy[b][b1] = this.wzy[b][b1];
         } 
         this.hcheckpoint[b] = this.checkpoint[b];
         this.hlastcheck[b] = this.lastcheck[b];
       } 
       
       for (b = 0; b < 8; b++) {
         byte b1;
         for (b1 = 0; b1 < 20; b1++) {
           
           for (byte b2 = 0; b2 < 30; b2++) {
             
             this.hsspark[b][b1][b2] = this.sspark[b][b1][b2];
             this.hsx[b][b1][b2] = this.sx[b][b1][b2];
             this.hsy[b][b1][b2] = this.sy[b][b1][b2];
             this.hsz[b][b1][b2] = this.sz[b][b1][b2];
             this.hsmag[b][b1][b2] = this.smag[b][b1][b2];
             this.hscx[b][b1][b2] = this.scx[b][b1][b2];
             this.hscz[b][b1][b2] = this.scz[b][b1][b2];
           } 
         } 
         for (b1 = 0; b1 < 'È'; b1++) {
           
           this.hrspark[b][b1] = this.rspark[b][b1];
           this.hsprk[b][b1] = this.sprk[b][b1];
           this.hsrx[b][b1] = this.srx[b][b1];
           this.hsry[b][b1] = this.sry[b][b1];
           this.hsrz[b][b1] = this.srz[b][b1];
           this.hrcx[b][b1] = this.rcx[b][b1];
           this.hrcy[b][b1] = this.rcy[b][b1];
           this.hrcz[b][b1] = this.rcz[b][b1];
         } 
       } 
       
       for (b = 0; b < 8; b++) {
         
         for (byte b1 = 0; b1 < 4; b1++) {
           
           for (byte b2 = 0; b2 < 7; b2++) {
             
             this.hry[b][b1][b2] = this.ry[b][b1][b2];
             this.hmagy[b][b1][b2] = this.magy[b][b1][b2];
             this.hrx[b][b1][b2] = this.rx[b][b1][b2];
             this.hmagx[b][b1][b2] = this.magx[b][b1][b2];
             this.hrz[b][b1][b2] = this.rz[b][b1][b2];
             this.hmagz[b][b1][b2] = this.magz[b][b1][b2];
           } 
         } 
       } 
       
       for (b = 0; b < 8; ) { for (byte b1 = 0; b1 < 7; ) { this.hmtouch[b][b1] = this.mtouch[b][b1]; b1++; }  b++; }
        this.hcaught = true;
     } 
   }
 
 
   
   public void rec(ContO paramContO, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
     if (paramInt1 == paramInt5) this.caught++; 
     if (this.cntf == 50) {
       
       for (byte b1 = 0; b1 < 5; ) { this.car[b1][paramInt1] = new ContO(this.car[b1 + 1][paramInt1], 0, 0, 0, 0); this.squash[b1][paramInt1] = this.squash[b1 + 1][paramInt1]; b1++; }
        this.car[5][paramInt1] = new ContO(paramContO, 0, 0, 0, 0);
       this.squash[5][paramInt1] = paramInt2;
       this.cntf = 0;
     }
     else {
       
       this.cntf++;
     } 
     
     this.fix[paramInt1] = this.fix[paramInt1] - 1;
     if (paramInt4 != 0) this.dest[paramInt1] = this.dest[paramInt1] - 1; 
     if (this.dest[paramInt1] == 230)
     {
       if (paramInt1 == paramInt5) { cotchinow(paramInt5); this.whenwasted = 229; } else if (paramInt3 != 0) { cotchinow(paramInt1); this.whenwasted = 165 + paramInt3; }
     
     }
     byte b;
     for (b = 0; b < 'ī'; b++) {
       
       this.x[b][paramInt1] = this.x[b + 1][paramInt1];
       this.y[b][paramInt1] = this.y[b + 1][paramInt1];
       this.z[b][paramInt1] = this.z[b + 1][paramInt1];
       this.zy[b][paramInt1] = this.zy[b + 1][paramInt1];
       this.xy[b][paramInt1] = this.xy[b + 1][paramInt1];
       this.xz[b][paramInt1] = this.xz[b + 1][paramInt1];
       this.wxz[b][paramInt1] = this.wxz[b + 1][paramInt1];
       this.wzy[b][paramInt1] = this.wzy[b + 1][paramInt1];
     } 
     this.x[299][paramInt1] = paramContO.x;
     this.y[299][paramInt1] = paramContO.y;
     this.z[299][paramInt1] = paramContO.z;
     this.xy[299][paramInt1] = paramContO.xy;
     this.zy[299][paramInt1] = paramContO.zy;
     this.xz[299][paramInt1] = paramContO.xz;
     this.wxz[299][paramInt1] = paramContO.wxz;
     this.wzy[299][paramInt1] = paramContO.wzy;
     
     if (paramInt1 == paramInt5) {
       
       for (b = 0; b < 'ī'; b++) {
         
         this.checkpoint[b] = this.checkpoint[b + 1];
         this.lastcheck[b] = this.lastcheck[b + 1];
       } 
       this.checkpoint[299] = paramContO.m.checkpoint;
       this.lastcheck[299] = paramContO.m.lastcheck;
     } 
 
     
     for (b = 0; b < 20; b++) {
       
       if (paramContO.stg[b] == 1) {
         
         this.sspark[paramInt1][b][this.ns[paramInt1][b]] = 300;
         this.sx[paramInt1][b][this.ns[paramInt1][b]] = paramContO.sx[b];
         this.sy[paramInt1][b][this.ns[paramInt1][b]] = paramContO.sy[b];
         this.sz[paramInt1][b][this.ns[paramInt1][b]] = paramContO.sz[b];
         this.smag[paramInt1][b][this.ns[paramInt1][b]] = paramContO.osmag[b];
         this.scx[paramInt1][b][this.ns[paramInt1][b]] = paramContO.scx[b];
         this.scz[paramInt1][b][this.ns[paramInt1][b]] = paramContO.scz[b];
         this.ns[paramInt1][b] = this.ns[paramInt1][b] + 1; if (this.ns[paramInt1][b] == 30) this.ns[paramInt1][b] = 0; 
       } 
       for (byte b1 = 0; b1 < 30; ) { this.sspark[paramInt1][b][b1] = this.sspark[paramInt1][b][b1] - 1; b1++; }
     
     } 
     if (paramContO.sprk != 0) {
       
       this.rspark[paramInt1][this.nr[paramInt1]] = 300;
       this.sprk[paramInt1][this.nr[paramInt1]] = paramContO.sprk;
       this.srx[paramInt1][this.nr[paramInt1]] = paramContO.srx;
       this.sry[paramInt1][this.nr[paramInt1]] = paramContO.sry;
       this.srz[paramInt1][this.nr[paramInt1]] = paramContO.srz;
       this.rcx[paramInt1][this.nr[paramInt1]] = paramContO.rcx;
       this.rcy[paramInt1][this.nr[paramInt1]] = paramContO.rcy;
       this.rcz[paramInt1][this.nr[paramInt1]] = paramContO.rcz;
       this.nr[paramInt1] = this.nr[paramInt1] + 1; if (this.nr[paramInt1] == 200) this.nr[paramInt1] = 0; 
     } 
     for (b = 0; b < 'È'; ) { this.rspark[paramInt1][b] = this.rspark[paramInt1][b] - 1; b++; }
     
     for (b = 0; b < 4; ) { for (byte b1 = 0; b1 < 7; ) { this.ry[paramInt1][b][b1] = this.ry[paramInt1][b][b1] - 1; this.rx[paramInt1][b][b1] = this.rx[paramInt1][b][b1] - 1; this.rz[paramInt1][b][b1] = this.rz[paramInt1][b][b1] - 1; b1++; }  b++; }
   
   }
   int[] cntdest = new int[8];
 
   
   public void play(ContO paramContO, Mad paramMad, int paramInt1, int paramInt2) {
     paramContO.x = this.x[paramInt2][paramInt1];
     paramContO.y = this.y[paramInt2][paramInt1];
     paramContO.z = this.z[paramInt2][paramInt1];
     paramContO.zy = this.zy[paramInt2][paramInt1];
     paramContO.xy = this.xy[paramInt2][paramInt1];
     paramContO.xz = this.xz[paramInt2][paramInt1];
     paramContO.wxz = this.wxz[paramInt2][paramInt1];
     paramContO.wzy = this.wzy[paramInt2][paramInt1];
     
     if (paramInt1 == 0) {
       
       paramContO.m.checkpoint = this.checkpoint[paramInt2];
       paramContO.m.lastcheck = this.lastcheck[paramInt2];
     } 
     
     if (paramInt2 == 0) this.cntdest[paramInt1] = 0; 
     if (this.dest[paramInt1] == paramInt2) this.cntdest[paramInt1] = 7; 
     if (paramInt2 == 0 && this.dest[paramInt1] < -1) for (byte b1 = 0; b1 < paramContO.npl; ) { if ((paramContO.p[b1]).wz == 0 || (paramContO.p[b1]).gr == -17 || (paramContO.p[b1]).gr == -16) (paramContO.p[b1]).embos = 13;  b1++; }
         if (this.cntdest[paramInt1] != 0) { for (byte b1 = 0; b1 < paramContO.npl; ) { if ((paramContO.p[b1]).wz == 0 || (paramContO.p[b1]).gr == -17 || (paramContO.p[b1]).gr == -16) (paramContO.p[b1]).embos = 1;  b1++; }  this.cntdest[paramInt1] = this.cntdest[paramInt1] - 1; }
     
     byte b;
     for (b = 0; b < 20; b++) {
       
       for (byte b1 = 0; b1 < 30; b1++) {
         
         if (this.sspark[paramInt1][b][b1] == paramInt2) {
           
           paramContO.stg[b] = 1;
           paramContO.sx[b] = this.sx[paramInt1][b][b1];
           paramContO.sy[b] = this.sy[paramInt1][b][b1];
           paramContO.sz[b] = this.sz[paramInt1][b][b1];
           paramContO.osmag[b] = this.smag[paramInt1][b][b1];
           paramContO.scx[b] = this.scx[paramInt1][b][b1];
           paramContO.scz[b] = this.scz[paramInt1][b][b1];
         } 
       } 
     } 
     
     for (b = 0; b < 'È'; b++) {
       
       if (this.rspark[paramInt1][b] == paramInt2) {
         
         paramContO.sprk = this.sprk[paramInt1][b];
         paramContO.srx = this.srx[paramInt1][b];
         paramContO.sry = this.sry[paramInt1][b];
         paramContO.srz = this.srz[paramInt1][b];
         paramContO.rcx = this.rcx[paramInt1][b];
         paramContO.rcy = this.rcy[paramInt1][b];
         paramContO.rcz = this.rcz[paramInt1][b];
       } 
     } 
     
     for (b = 0; b < 4; b++) {
       
       for (byte b1 = 0; b1 < 7; b1++) {
         
         if (this.ry[paramInt1][b][b1] == paramInt2) regy(b, this.magy[paramInt1][b][b1], this.mtouch[paramInt1][b1], paramContO, paramMad); 
         if (this.rx[paramInt1][b][b1] == paramInt2) regx(b, this.magx[paramInt1][b][b1], paramContO, paramMad); 
         if (this.rz[paramInt1][b][b1] == paramInt2) regz(b, this.magz[paramInt1][b][b1], paramContO, paramMad);
       
       } 
     } 
   }
   
   int lastfr = 0;
 
   
   public void playh(ContO paramContO, Mad paramMad, int paramInt1, int paramInt2, int paramInt3) {
     paramContO.x = this.hx[paramInt2][paramInt1];
     paramContO.y = this.hy[paramInt2][paramInt1];
     paramContO.z = this.hz[paramInt2][paramInt1];
     paramContO.zy = this.hzy[paramInt2][paramInt1];
     paramContO.xy = this.hxy[paramInt2][paramInt1];
     paramContO.xz = this.hxz[paramInt2][paramInt1];
     paramContO.wxz = this.hwxz[paramInt2][paramInt1];
     paramContO.wzy = this.hwzy[paramInt2][paramInt1];
     
     if (paramInt1 == paramInt3) {
       
       paramContO.m.checkpoint = this.hcheckpoint[paramInt2];
       paramContO.m.lastcheck = this.hlastcheck[paramInt2];
     } 
     
     if (paramInt2 == 0) this.cntdest[paramInt1] = 0; 
     if (this.hdest[paramInt1] == paramInt2) this.cntdest[paramInt1] = 7; 
     if (paramInt2 == 0 && this.hdest[paramInt1] < -1) for (byte b1 = 0; b1 < paramContO.npl; ) { if ((paramContO.p[b1]).wz == 0 || (paramContO.p[b1]).gr == -17 || (paramContO.p[b1]).gr == -16) (paramContO.p[b1]).embos = 13;  b1++; }
         if (this.cntdest[paramInt1] != 0) { for (byte b1 = 0; b1 < paramContO.npl; ) { if ((paramContO.p[b1]).wz == 0 || (paramContO.p[b1]).gr == -17 || (paramContO.p[b1]).gr == -16) (paramContO.p[b1]).embos = 1;  b1++; }  this.cntdest[paramInt1] = this.cntdest[paramInt1] - 1; }
      byte b;
     for (b = 0; b < 20; b++) {
       
       for (byte b1 = 0; b1 < 30; b1++) {
         
         if (this.hsspark[paramInt1][b][b1] == paramInt2) {
           
           paramContO.stg[b] = 1;
           paramContO.sx[b] = this.hsx[paramInt1][b][b1];
           paramContO.sy[b] = this.hsy[paramInt1][b][b1];
           paramContO.sz[b] = this.hsz[paramInt1][b][b1];
           paramContO.osmag[b] = this.hsmag[paramInt1][b][b1];
           paramContO.scx[b] = this.hscx[paramInt1][b][b1];
           paramContO.scz[b] = this.hscz[paramInt1][b][b1];
         } 
       } 
     } 
     
     for (b = 0; b < 'È'; b++) {
       
       if (this.hrspark[paramInt1][b] == paramInt2) {
         
         paramContO.sprk = this.hsprk[paramInt1][b];
         paramContO.srx = this.hsrx[paramInt1][b];
         paramContO.sry = this.hsry[paramInt1][b];
         paramContO.srz = this.hsrz[paramInt1][b];
         paramContO.rcx = this.hrcx[paramInt1][b];
         paramContO.rcy = this.hrcy[paramInt1][b];
         paramContO.rcz = this.hrcz[paramInt1][b];
       } 
     } 
     
     for (b = 0; b < 4; b++) {
       
       for (byte b1 = 0; b1 < 7; b1++) {
         
         if (this.hry[paramInt1][b][b1] == paramInt2 && this.lastfr != paramInt2) regy(b, this.hmagy[paramInt1][b][b1], this.hmtouch[paramInt1][b1], paramContO, paramMad); 
         if (this.hrx[paramInt1][b][b1] == paramInt2) if (this.lastfr != paramInt2) { regx(b, this.hmagx[paramInt1][b][b1], paramContO, paramMad); } else { chipx(b, this.hmagx[paramInt1][b][b1], paramContO, paramMad); }
             if (this.hrz[paramInt1][b][b1] == paramInt2) if (this.lastfr != paramInt2) { regz(b, this.hmagz[paramInt1][b][b1], paramContO, paramMad); } else { chipz(b, this.hmagz[paramInt1][b][b1], paramContO, paramMad); }
            
       } 
     } 
     this.lastfr = paramInt2;
   }
 
 
   
   public void recy(int paramInt1, float paramFloat, boolean paramBoolean, int paramInt2) {
     this.ry[paramInt2][paramInt1][this.nry[paramInt2][paramInt1]] = 300;
     this.magy[paramInt2][paramInt1][this.nry[paramInt2][paramInt1]] = (int)paramFloat;
     this.mtouch[paramInt2][this.nry[paramInt2][paramInt1]] = paramBoolean;
     this.nry[paramInt2][paramInt1] = this.nry[paramInt2][paramInt1] + 1; if (this.nry[paramInt2][paramInt1] == 7) this.nry[paramInt2][paramInt1] = 0;
   
   }
   
   public void recx(int paramInt1, float paramFloat, int paramInt2) {
     this.rx[paramInt2][paramInt1][this.nry[paramInt2][paramInt1]] = 300;
     this.magx[paramInt2][paramInt1][this.nry[paramInt2][paramInt1]] = (int)paramFloat;
     this.nrx[paramInt2][paramInt1] = this.nrx[paramInt2][paramInt1] + 1; if (this.nrx[paramInt2][paramInt1] == 7) this.nrx[paramInt2][paramInt1] = 0;
   
   }
   
   public void recz(int paramInt1, float paramFloat, int paramInt2) {
     this.rz[paramInt2][paramInt1][this.nry[paramInt2][paramInt1]] = 300;
     this.magz[paramInt2][paramInt1][this.nry[paramInt2][paramInt1]] = (int)paramFloat;
     this.nrz[paramInt2][paramInt1] = this.nrz[paramInt2][paramInt1] + 1; if (this.nrz[paramInt2][paramInt1] == 7) this.nrz[paramInt2][paramInt1] = 0; 
   }
   
   public void regy(int paramInt, float paramFloat, boolean paramBoolean, ContO paramContO, Mad paramMad) { if (paramFloat > 100.0F) { byte b1; byte b2; int i; int j; for (paramFloat -= 100.0F, b1 = 0, b2 = 0, i = paramContO.zy, j = paramContO.xy; i < 360; i += 360); for (; i > 360; i -= 360); if (i < 210 && i > 150) b1 = -1;  if (i > 330 || i < 30) b1 = 1;  for (; j < 360; j += 360); for (; j > 360; j -= 360); if (j < 210 && j > 150) b2 = -1;  if (j > 330 || j < 30) b2 = 1;  if (b2 * b1 == 0 || paramBoolean) for (byte b = 0; b < paramContO.npl; ) { float f; byte b3; for (f = 0.0F, b3 = 0; b3 < (paramContO.p[b]).n; ) { if ((paramContO.p[b]).wz == 0 && py(paramContO.keyx[paramInt], (paramContO.p[b]).ox[b3], paramContO.keyz[paramInt], (paramContO.p[b]).oz[b3]) < paramMad.cd.clrad[paramMad.cn]) { f = paramFloat / 20.0F * this.m.random(); (paramContO.p[b]).oz[b3] = (int)((paramContO.p[b]).oz[b3] + f * this.m.sin(i)); (paramContO.p[b]).ox[b3] = (int)((paramContO.p[b]).ox[b3] - f * this.m.sin(j)); }  b3++; }  if (f != 0.0F) { if (Math.abs(f) >= 1.0F) { (paramContO.p[b]).chip = 1; (paramContO.p[b]).ctmag = f; }  if (!(paramContO.p[b]).nocol && (paramContO.p[b]).glass != 1) { if ((paramContO.p[b]).bfase > 20 && (paramContO.p[b]).hsb[1] > 0.2D) (paramContO.p[b]).hsb[1] = 0.2F;  if ((paramContO.p[b]).bfase > 30) { if ((paramContO.p[b]).hsb[2] < 0.5D) (paramContO.p[b]).hsb[2] = 0.5F;  if ((paramContO.p[b]).hsb[1] > 0.1D) (paramContO.p[b]).hsb[1] = 0.1F;  }  if ((paramContO.p[b]).bfase > 40) (paramContO.p[b]).hsb[1] = 0.05F;  if ((paramContO.p[b]).bfase > 50) { if ((paramContO.p[b]).hsb[2] > 0.8D) (paramContO.p[b]).hsb[2] = 0.8F;  (paramContO.p[b]).hsb[0] = 0.075F; (paramContO.p[b]).hsb[1] = 0.05F; }  if ((paramContO.p[b]).bfase > 60) (paramContO.p[b]).hsb[0] = 0.05F;  (paramContO.p[b]).bfase = (int)((paramContO.p[b]).bfase + f); new Color((paramContO.p[b]).c[0], (paramContO.p[b]).c[1], (paramContO.p[b]).c[2]); Color color = Color.getHSBColor((paramContO.p[b]).hsb[0], (paramContO.p[b]).hsb[1], (paramContO.p[b]).hsb[2]); (paramContO.p[b]).c[0] = color.getRed(); (paramContO.p[b]).c[1] = color.getGreen(); (paramContO.p[b]).c[2] = color.getBlue(); }  if ((paramContO.p[b]).glass == 1) (paramContO.p[b]).gr = (int)((paramContO.p[b]).gr + Math.abs(f * 1.5D));  }  b++; }   if (b2 * b1 == -1) { int k; byte b3; byte b4; for (k = 0, b3 = 1, b4 = 0; b4 < paramContO.npl; ) { float f; byte b; for (f = 0.0F, b = 0; b < (paramContO.p[b4]).n; ) { if ((paramContO.p[b4]).wz == 0) { f = paramFloat / 15.0F * this.m.random(); if ((Math.abs((paramContO.p[b4]).oy[b] - paramMad.cd.flipy[paramMad.cn] - this.squash[0][paramMad.im]) < paramMad.cd.msquash[paramMad.cn] * 3 || (paramContO.p[b4]).oy[b] < paramMad.cd.flipy[paramMad.cn] + this.squash[0][paramMad.im]) && this.squash[0][paramMad.im] < paramMad.cd.msquash[paramMad.cn]) { (paramContO.p[b4]).oy[b] = (int)((paramContO.p[b4]).oy[b] + f); k = (int)(k + f); b3++; }  }  b++; }  if ((paramContO.p[b4]).glass == 1) { (paramContO.p[b4]).gr += 5; } else if (f != 0.0F) { (paramContO.p[b4]).bfase = (int)((paramContO.p[b4]).bfase + f); }  if (Math.abs(f) >= 1.0F) { (paramContO.p[b4]).chip = 1; (paramContO.p[b4]).ctmag = f; }  b4++; }  this.squash[0][paramMad.im] = this.squash[0][paramMad.im] + k / b3; }  }
      } public void regx(int paramInt, float paramFloat, ContO paramContO, Mad paramMad) { if (Math.abs(paramFloat) > 100.0F) { if (paramFloat > 100.0F) paramFloat -= 100.0F;  if (paramFloat < -100.0F) paramFloat += 100.0F;  for (byte b = 0; b < paramContO.npl; ) { float f; byte b1; for (f = 0.0F, b1 = 0; b1 < (paramContO.p[b]).n; ) { if ((paramContO.p[b]).wz == 0 && py(paramContO.keyx[paramInt], (paramContO.p[b]).ox[b1], paramContO.keyz[paramInt], (paramContO.p[b]).oz[b1]) < paramMad.cd.clrad[paramMad.cn]) { f = paramFloat / 20.0F * this.m.random(); (paramContO.p[b]).oz[b1] = (int)((paramContO.p[b]).oz[b1] - f * this.m.sin(paramContO.xz) * this.m.cos(paramContO.zy)); (paramContO.p[b]).ox[b1] = (int)((paramContO.p[b]).ox[b1] + f * this.m.cos(paramContO.xz) * this.m.cos(paramContO.xy)); }  b1++; }  if (f != 0.0F) { if (Math.abs(f) >= 1.0F) { (paramContO.p[b]).chip = 1; (paramContO.p[b]).ctmag = f; }  if (!(paramContO.p[b]).nocol && (paramContO.p[b]).glass != 1) { if ((paramContO.p[b]).bfase > 20 && (paramContO.p[b]).hsb[1] > 0.2D) (paramContO.p[b]).hsb[1] = 0.2F;  if ((paramContO.p[b]).bfase > 30) { if ((paramContO.p[b]).hsb[2] < 0.5D) (paramContO.p[b]).hsb[2] = 0.5F;  if ((paramContO.p[b]).hsb[1] > 0.1D) (paramContO.p[b]).hsb[1] = 0.1F;  }  if ((paramContO.p[b]).bfase > 40) (paramContO.p[b]).hsb[1] = 0.05F;  if ((paramContO.p[b]).bfase > 50) { if ((paramContO.p[b]).hsb[2] > 0.8D) (paramContO.p[b]).hsb[2] = 0.8F;  (paramContO.p[b]).hsb[0] = 0.075F; (paramContO.p[b]).hsb[1] = 0.05F; }  if ((paramContO.p[b]).bfase > 60) (paramContO.p[b]).hsb[0] = 0.05F;  (paramContO.p[b]).bfase = (int)((paramContO.p[b]).bfase + Math.abs(f)); new Color((paramContO.p[b]).c[0], (paramContO.p[b]).c[1], (paramContO.p[b]).c[2]); Color color = Color.getHSBColor((paramContO.p[b]).hsb[0], (paramContO.p[b]).hsb[1], (paramContO.p[b]).hsb[2]); (paramContO.p[b]).c[0] = color.getRed(); (paramContO.p[b]).c[1] = color.getGreen(); (paramContO.p[b]).c[2] = color.getBlue(); }  if ((paramContO.p[b]).glass == 1) (paramContO.p[b]).gr = (int)((paramContO.p[b]).gr + Math.abs(f * 1.5D));  }  b++; }  }
      } public void regz(int paramInt, float paramFloat, ContO paramContO, Mad paramMad) { if (Math.abs(paramFloat) > 100.0F) { if (paramFloat > 100.0F) paramFloat -= 100.0F;  if (paramFloat < -100.0F) paramFloat += 100.0F;  for (byte b = 0; b < paramContO.npl; ) { float f; byte b1; for (f = 0.0F, b1 = 0; b1 < (paramContO.p[b]).n; ) { if ((paramContO.p[b]).wz == 0 && py(paramContO.keyx[paramInt], (paramContO.p[b]).ox[b1], paramContO.keyz[paramInt], (paramContO.p[b]).oz[b1]) < paramMad.cd.clrad[paramMad.cn]) { f = paramFloat / 20.0F * this.m.random(); (paramContO.p[b]).oz[b1] = (int)((paramContO.p[b]).oz[b1] + f * this.m.cos(paramContO.xz) * this.m.cos(paramContO.zy)); (paramContO.p[b]).ox[b1] = (int)((paramContO.p[b]).ox[b1] + f * this.m.sin(paramContO.xz) * this.m.cos(paramContO.xy)); }  b1++; }  if (f != 0.0F) { if (Math.abs(f) >= 1.0F) { (paramContO.p[b]).chip = 1; (paramContO.p[b]).ctmag = f; }  if (!(paramContO.p[b]).nocol && (paramContO.p[b]).glass != 1) { if ((paramContO.p[b]).bfase > 20 && (paramContO.p[b]).hsb[1] > 0.2D) (paramContO.p[b]).hsb[1] = 0.2F;  if ((paramContO.p[b]).bfase > 30) { if ((paramContO.p[b]).hsb[2] < 0.5D) (paramContO.p[b]).hsb[2] = 0.5F;  if ((paramContO.p[b]).hsb[1] > 0.1D) (paramContO.p[b]).hsb[1] = 0.1F;  }  if ((paramContO.p[b]).bfase > 40) (paramContO.p[b]).hsb[1] = 0.05F;  if ((paramContO.p[b]).bfase > 50) { if ((paramContO.p[b]).hsb[2] > 0.8D) (paramContO.p[b]).hsb[2] = 0.8F;  (paramContO.p[b]).hsb[0] = 0.075F; (paramContO.p[b]).hsb[1] = 0.05F; }  if ((paramContO.p[b]).bfase > 60) (paramContO.p[b]).hsb[0] = 0.05F;  (paramContO.p[b]).bfase = (int)((paramContO.p[b]).bfase + Math.abs(f)); new Color((paramContO.p[b]).c[0], (paramContO.p[b]).c[1], (paramContO.p[b]).c[2]); Color color = Color.getHSBColor((paramContO.p[b]).hsb[0], (paramContO.p[b]).hsb[1], (paramContO.p[b]).hsb[2]); (paramContO.p[b]).c[0] = color.getRed(); (paramContO.p[b]).c[1] = color.getGreen(); (paramContO.p[b]).c[2] = color.getBlue(); }  if ((paramContO.p[b]).glass == 1) (paramContO.p[b]).gr = (int)((paramContO.p[b]).gr + Math.abs(f * 1.5D));  }  b++; }
        }
      }
    public void chipx(int paramInt, float paramFloat, ContO paramContO, Mad paramMad) {
     if (Math.abs(paramFloat) > 100.0F) {
       
       if (paramFloat > 100.0F) paramFloat -= 100.0F;  if (paramFloat < -100.0F) paramFloat += 100.0F; 
       for (byte b = 0; b < paramContO.npl; b++) {
         float f; byte b1;
         for (f = 0.0F, b1 = 0; b1 < (paramContO.p[b]).n; ) { if ((paramContO.p[b]).wz == 0 && py(paramContO.keyx[paramInt], (paramContO.p[b]).ox[b1], paramContO.keyz[paramInt], (paramContO.p[b]).oz[b1]) < paramMad.cd.clrad[paramMad.cn]) f = paramFloat / 20.0F * this.m.random();  b1++; }
          if (f != 0.0F && Math.abs(f) >= 1.0F) { (paramContO.p[b]).chip = 1; (paramContO.p[b]).ctmag = f; }
       
       } 
     } 
   }
   
   public void chipz(int paramInt, float paramFloat, ContO paramContO, Mad paramMad) {
     if (Math.abs(paramFloat) > 100.0F) {
       
       if (paramFloat > 100.0F) paramFloat -= 100.0F;  if (paramFloat < -100.0F) paramFloat += 100.0F; 
       for (byte b = 0; b < paramContO.npl; b++) {
         float f; byte b1;
         for (f = 0.0F, b1 = 0; b1 < (paramContO.p[b]).n; ) { if ((paramContO.p[b]).wz == 0 && py(paramContO.keyx[paramInt], (paramContO.p[b]).ox[b1], paramContO.keyz[paramInt], (paramContO.p[b]).oz[b1]) < paramMad.cd.clrad[paramMad.cn]) f = paramFloat / 20.0F * this.m.random();  b1++; }
          if (f != 0.0F && Math.abs(f) >= 1.0F) { (paramContO.p[b]).chip = 1; (paramContO.p[b]).ctmag = f; }
       
       } 
     } 
   }
 
   
   public int py(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
     return (paramInt1 - paramInt2) * (paramInt1 - paramInt2) + (paramInt3 - paramInt4) * (paramInt3 - paramInt4);
   }
 }


