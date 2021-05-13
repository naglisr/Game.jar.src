 
 public class CheckPoints
 {
   int[] x = new int[140];
   int[] z = new int[140];
   int[] y = new int[140];
   int[] typ = new int[140];
   int pcs = 0;
   int nsp = 0;
   int n = 0;
   
   int[] fx = new int[5];
   int[] fz = new int[5];
   int[] fy = new int[5];
   boolean[] roted = new boolean[5];
   boolean[] special = new boolean[5];
   int fn = 0;
   
   int stage = (int)(Math.random() * 27.0D) + 1;
   int nlaps = 0;
   int nfix = 0;
   boolean notb = false;
   String name = "hogan rewish";
   String maker = "";
   int pubt = 0;
   String trackname = "";
   int trackvol = 200;
   int top20 = 0;
   int nto = 0;
   
   int[] pos = new int[] { 7, 7, 7, 7, 7, 7, 7, 7 };
   int[] clear = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
   int[] dested = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
   float[] magperc = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
   
   int wasted = 0;
   boolean haltall = false;
   int pcleared = 0;
   
   int[] opx = new int[8];
   int[] opz = new int[8];
   int[] onscreen = new int[8];
   int[] omxz = new int[8];
   
   int catchfin = 0;
   int postwo = 0;
 
   
   public void checkstat(Mad[] paramArrayOfMad, ContO[] paramArrayOfContO, Record paramRecord, int paramInt1, int paramInt2, int paramInt3) {
     if (!this.haltall) {
       
       this.pcleared = (paramArrayOfMad[paramInt2]).pcleared;
       byte b1;
       for (b1 = 0; b1 < paramInt1; b1++) {
         
         this.magperc[b1] = (paramArrayOfMad[b1]).hitmag / (paramArrayOfMad[b1]).cd.maxmag[(paramArrayOfMad[b1]).cn]; if (this.magperc[b1] > 1.0F) this.magperc[b1] = 1.0F; 
         this.pos[b1] = 0; this.onscreen[b1] = (paramArrayOfContO[b1]).dist; this.opx[b1] = (paramArrayOfContO[b1]).x; this.opz[b1] = (paramArrayOfContO[b1]).z; this.omxz[b1] = (paramArrayOfMad[b1]).mxz;
         if (this.dested[b1] == 0) { this.clear[b1] = (paramArrayOfMad[b1]).clear; } else { this.clear[b1] = -1; }
          (paramArrayOfMad[b1]).outshakedam = (paramArrayOfMad[b1]).shakedam; (paramArrayOfMad[b1]).shakedam = 0;
       } 
       
       for (b1 = 0; b1 < paramInt1; b1++) {
         
         for (int i = b1 + 1; i < paramInt1; i++) {
           
           if (this.clear[b1] != this.clear[i]) {
             
             if (this.clear[b1] < this.clear[i]) { this.pos[b1] = this.pos[b1] + 1; } else { this.pos[i] = this.pos[i] + 1; }
           
           } else {
             
             int j = (paramArrayOfMad[b1]).pcleared + 1; if (j >= this.n) j = 0; 
             while (this.typ[j] <= 0) { if (++j >= this.n) j = 0;  }
              if (py((paramArrayOfContO[b1]).x / 100, this.x[j] / 100, (paramArrayOfContO[b1]).z / 100, this.z[j] / 100) > py((paramArrayOfContO[i]).x / 100, this.x[j] / 100, (paramArrayOfContO[i]).z / 100, this.z[j] / 100)) { this.pos[b1] = this.pos[b1] + 1; } else { this.pos[i] = this.pos[i] + 1; }
           
           } 
         } 
       } 
       
       if (this.stage > 2)
       {
         for (b1 = 0; b1 < paramInt1; b1++) {
           
           if (this.clear[b1] == this.nlaps * this.nsp && this.pos[b1] == 0)
           {
             if (b1 == paramInt2)
             
             { for (byte b2 = 0; b2 < paramInt1; ) { if (this.pos[b2] == 1) this.postwo = b2;  b2++; }
                if (py(this.opx[paramInt2] / 100, this.opx[this.postwo] / 100, this.opz[paramInt2] / 100, this.opz[this.postwo] / 100) < 14000 && this.clear[paramInt2] - this.clear[this.postwo] == 1) this.catchfin = 30;
               
                }
             
             else if (this.pos[paramInt2] == 1 && py(this.opx[paramInt2] / 100, this.opx[b1] / 100, this.opz[paramInt2] / 100, this.opz[b1] / 100) < 14000 && this.clear[b1] - this.clear[paramInt2] == 1) { this.catchfin = 30; this.postwo = b1; }
           
           }
         } 
       }
     } 
 
     
     this.wasted = 0;
     for (byte b = 0; b < paramInt1; ) { if ((paramInt2 != b || paramInt3 >= 2) && (paramArrayOfMad[b]).dest) this.wasted++;  b++; }
     
     if (this.catchfin != 0 && paramInt3 < 2) { this.catchfin--; if (this.catchfin == 0) { paramRecord.cotchinow(this.postwo); paramRecord.closefinish = this.pos[paramInt2] + 1; }
        }
   
   }
   float prox = 0.0F;
   
   public void calprox() {
     int i = 0;
     for (byte b = 0; b < this.n - 1; ) { for (int j = b + 1; j < this.n; ) { if (Math.abs(this.x[b] - this.x[j]) > i) i = Math.abs(this.x[b] - this.x[j]);  if (Math.abs(this.z[b] - this.z[j]) > i) i = Math.abs(this.z[b] - this.z[j]);  j++; }  b++; }
      this.prox = i / 90.0F;
   }
 
 
 
   
   public int py(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
     return (paramInt1 - paramInt2) * (paramInt1 - paramInt2) + (paramInt3 - paramInt4) * (paramInt3 - paramInt4);
   }
 }


