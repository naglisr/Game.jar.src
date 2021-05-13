 
 
 
 
 public class Trackers
 {
   int[] x = new int[6700];
   int[] y = new int[6700];
   int[] z = new int[6700];
   
   int[] xy = new int[6700];
   int[] zy = new int[6700];
   
   int[] skd = new int[6700];
   int[] dam = new int[6700];
   
   boolean[] notwall = new boolean[6700];
   boolean[] decor = new boolean[6700];
   
   int[][] c = new int[6700][3];
   int[] radx = new int[6700];
   int[] radz = new int[6700];
   int[] rady = new int[6700];
   int nt = 0;
 
 
 
   
   int sx = 0; int sz = 0; int ncx = 0; int ncz = 0;
   int[][][] sect = (int[][][])null;
 
   
   public void devidetrackers(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
     this.sect = (int[][][])null;
     this.sx = paramInt1;
     this.sz = paramInt3;
     this.ncx = paramInt2 / 3000; if (this.ncx <= 0) this.ncx = 1; 
     this.ncz = paramInt4 / 3000; if (this.ncz <= 0) this.ncz = 1; 
     this.sect = new int[this.ncx][this.ncz][]; byte b;
     for (b = 0; b < this.ncx; b++) {
       
       for (byte b1 = 0; b1 < this.ncz; b1++) {
         
         int i = this.sx + b * 3000 + 1500;
         int j = this.sz + b1 * 3000 + 1500;
         int[] arrayOfInt = new int[6700];
         byte b2 = 0; byte b3;
         for (b3 = 0; b3 < this.nt; b3++) {
           
           int k = py(i, this.x[b3], j, this.z[b3]);
           if (k < 20250000 && k > 0 && this.dam[b3] != 167) { arrayOfInt[b2] = b3; b2++; }
         
         }  if (b == 0 || b1 == 0 || b == this.ncx - 1 || b1 == this.ncz - 1) for (b3 = 0; b3 < this.nt; ) { if (this.dam[b3] == 167) { arrayOfInt[b2] = b3; b2++; }  b3++; }
             if (b2 == 0) { arrayOfInt[b2] = 0; b2++; }
          this.sect[b][b1] = new int[b2];
         for (b3 = 0; b3 < b2; ) { this.sect[b][b1][b3] = arrayOfInt[b3]; b3++; }
       
       } 
     }  for (b = 0; b < this.nt; ) { if (this.dam[b] == 167) this.dam[b] = 1;  b++; }
      this.ncx--;
     this.ncz--;
   }
 
 
 
   
   public int py(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
     return (paramInt1 - paramInt2) * (paramInt1 - paramInt2) + (paramInt3 - paramInt4) * (paramInt3 - paramInt4);
   }
 }


