 
 public class Wheels
 {
   int ground = 0; int mast = 0; int sparkat = 0;
   int[] rc = new int[] { 120, 120, 120 };
   float size = 2.0F, depth = 3.0F;
 
   
   public Wheels() {
     this.sparkat = 0;
     this.ground = 0;
   }
 
   
   public void setrims(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
     this.rc[0] = paramInt1;
     this.rc[1] = paramInt2;
     this.rc[2] = paramInt3;
     this.size = paramInt4 / 10.0F;
     if (this.size < 0.0F) this.size = 0.0F; 
     this.depth = paramInt5 / 10.0F;
     if (this.depth / this.size > 41.0F) this.depth = this.size * 41.0F; 
     if (this.depth / this.size < -25.0F) this.depth = -(this.size * 25.0F);
   
   }
   
   public void make(Medium paramMedium, Trackers paramTrackers, Plane[] paramArrayOfPlane, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {
     int[] arrayOfInt1 = new int[20];
     int[] arrayOfInt2 = new int[20];
     int[] arrayOfInt3 = new int[20];
     int[] arrayOfInt4 = { 45, 45, 45 };
     int i = 0;
     float f1 = paramInt6 / 10.0F;
     float f2 = paramInt7 / 10.0F;
     if (paramInt5 == 11) i = (int)(paramInt2 + 4.0F * f1); 
     this.sparkat = (int)(f2 * 24.0F);
     this.ground = (int)(paramInt3 + 13.0F * f2);
     
     byte b = -1;
     if (paramInt2 < 0) b = 1; 
     int j;
     for (j = 0; j < 20; ) { arrayOfInt1[j] = (int)(paramInt2 - 4.0F * f1); j++; }
     
     arrayOfInt2[0] = (int)(paramInt3 - 9.1923F * f2); arrayOfInt3[0] = (int)(paramInt4 + 9.1923F * f2);
     arrayOfInt2[1] = (int)(paramInt3 - 12.557F * f2); arrayOfInt3[1] = (int)(paramInt4 + 3.3646F * f2);
     arrayOfInt2[2] = (int)(paramInt3 - 12.557F * f2); arrayOfInt3[2] = (int)(paramInt4 - 3.3646F * f2);
     arrayOfInt2[3] = (int)(paramInt3 - 9.1923F * f2); arrayOfInt3[3] = (int)(paramInt4 - 9.1923F * f2);
     arrayOfInt2[4] = (int)(paramInt3 - 3.3646F * f2); arrayOfInt3[4] = (int)(paramInt4 - 12.557F * f2);
     arrayOfInt2[5] = (int)(paramInt3 + 3.3646F * f2); arrayOfInt3[5] = (int)(paramInt4 - 12.557F * f2);
     arrayOfInt2[6] = (int)(paramInt3 + 9.1923F * f2); arrayOfInt3[6] = (int)(paramInt4 - 9.1923F * f2);
     arrayOfInt2[7] = (int)(paramInt3 + 12.557F * f2); arrayOfInt3[7] = (int)(paramInt4 - 3.3646F * f2);
     arrayOfInt2[8] = (int)(paramInt3 + 12.557F * f2); arrayOfInt3[8] = (int)(paramInt4 + 3.3646F * f2);
     arrayOfInt2[9] = (int)(paramInt3 + 9.1923F * f2); arrayOfInt3[9] = (int)(paramInt4 + 9.1923F * f2);
     arrayOfInt2[10] = (int)(paramInt3 + 3.3646F * f2); arrayOfInt3[10] = (int)(paramInt4 + 12.557F * f2);
     arrayOfInt2[11] = (int)(paramInt3 - 3.3646F * f2); arrayOfInt3[11] = (int)(paramInt4 + 12.557F * f2);
 
 
     
     arrayOfInt2[12] = paramInt3; arrayOfInt3[12] = (int)(paramInt4 + 10.0F * this.size);
     arrayOfInt2[13] = (int)(paramInt3 + 8.66D * this.size); arrayOfInt3[13] = (int)(paramInt4 + 5.0F * this.size);
     arrayOfInt2[14] = (int)(paramInt3 + 8.66D * this.size); arrayOfInt3[14] = (int)(paramInt4 - 5.0F * this.size);
     arrayOfInt2[15] = paramInt3; arrayOfInt3[15] = (int)(paramInt4 - 10.0F * this.size);
     arrayOfInt2[16] = (int)(paramInt3 - 8.66D * this.size); arrayOfInt3[16] = (int)(paramInt4 - 5.0F * this.size);
     arrayOfInt2[17] = (int)(paramInt3 - 8.66D * this.size); arrayOfInt3[17] = (int)(paramInt4 + 5.0F * this.size);
     arrayOfInt2[18] = paramInt3; arrayOfInt3[18] = (int)(paramInt4 + 10.0F * this.size);
     arrayOfInt2[19] = (int)(paramInt3 - 3.3646F * f2); arrayOfInt3[19] = (int)(paramInt4 + 12.557F * f2);
     
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 20, arrayOfInt4, 0, paramInt8, 0, i, paramInt3, paramInt4, 7, 0, false, 0, false);
     (paramArrayOfPlane[paramInt1]).master = 1;
     paramInt1++;
 
     
     arrayOfInt1[2] = (int)(paramInt2 - this.depth * f1); arrayOfInt2[2] = paramInt3; arrayOfInt3[2] = paramInt4;
     
     j = (int)(paramInt8 - this.depth / this.size * 4.0F); if (j < -16) j = -16;
     
     arrayOfInt2[0] = paramInt3; arrayOfInt3[0] = (int)(paramInt4 + 10.0F * this.size);
     arrayOfInt2[1] = (int)(paramInt3 + 8.66D * this.size); arrayOfInt3[1] = (int)(paramInt4 + 5.0F * this.size);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 3, this.rc, 0, j, 0, i, paramInt3, paramInt4, 7, 0, false, 0, false);
     if (this.depth / this.size < 7.0F) (paramArrayOfPlane[paramInt1]).master = 2; 
     paramInt1++;
     
     arrayOfInt2[0] = (int)(paramInt3 + 8.66D * this.size); arrayOfInt3[0] = (int)(paramInt4 + 5.0F * this.size);
     arrayOfInt2[1] = (int)(paramInt3 + 8.66D * this.size); arrayOfInt3[1] = (int)(paramInt4 - 5.0F * this.size);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 3, this.rc, 0, j, 0, i, paramInt3, paramInt4, 7, 0, false, 0, false);
     if (this.depth / this.size < 7.0F) (paramArrayOfPlane[paramInt1]).master = 2; 
     paramInt1++;
     
     arrayOfInt2[0] = (int)(paramInt3 + 8.66D * this.size); arrayOfInt3[0] = (int)(paramInt4 - 5.0F * this.size);
     arrayOfInt2[1] = paramInt3; arrayOfInt3[1] = (int)(paramInt4 - 10.0F * this.size);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 3, this.rc, 0, j, 0, i, paramInt3, paramInt4, 7, 0, false, 0, false);
     if (this.depth / this.size < 7.0F) (paramArrayOfPlane[paramInt1]).master = 2; 
     paramInt1++;
     
     arrayOfInt2[0] = paramInt3; arrayOfInt3[0] = (int)(paramInt4 - 10.0F * this.size);
     arrayOfInt2[1] = (int)(paramInt3 - 8.66D * this.size); arrayOfInt3[1] = (int)(paramInt4 - 5.0F * this.size);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 3, this.rc, 0, j, 0, i, paramInt3, paramInt4, 7, 0, false, 0, false);
     if (this.depth / this.size < 7.0F) (paramArrayOfPlane[paramInt1]).master = 2; 
     paramInt1++;
     
     arrayOfInt2[0] = (int)(paramInt3 - 8.66D * this.size); arrayOfInt3[0] = (int)(paramInt4 - 5.0F * this.size);
     arrayOfInt2[1] = (int)(paramInt3 - 8.66D * this.size); arrayOfInt3[1] = (int)(paramInt4 + 5.0F * this.size);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 3, this.rc, 0, j, 0, i, paramInt3, paramInt4, 7, 0, false, 0, false);
     if (this.depth / this.size < 7.0F) (paramArrayOfPlane[paramInt1]).master = 2; 
     paramInt1++;
     
     arrayOfInt2[0] = (int)(paramInt3 - 8.66D * this.size); arrayOfInt3[0] = (int)(paramInt4 + 5.0F * this.size);
     arrayOfInt2[1] = paramInt3; arrayOfInt3[1] = (int)(paramInt4 + 10.0F * this.size);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 3, this.rc, 0, j, 0, i, paramInt3, paramInt4, 7, 0, false, 0, false);
     if (this.depth / this.size < 7.0F) (paramArrayOfPlane[paramInt1]).master = 2; 
     paramInt1++;
 
 
 
 
     
     arrayOfInt1[0] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[0] = (int)(paramInt3 - 12.557F * f2); arrayOfInt3[0] = (int)(paramInt4 + 3.3646F * f2);
     arrayOfInt1[1] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[1] = (int)(paramInt3 - 12.557F * f2); arrayOfInt3[1] = (int)(paramInt4 - 3.3646F * f2);
     arrayOfInt1[2] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[2] = (int)(paramInt3 - 12.557F * f2); arrayOfInt3[2] = (int)(paramInt4 - 3.3646F * f2);
     arrayOfInt1[3] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[3] = (int)(paramInt3 - 12.557F * f2); arrayOfInt3[3] = (int)(paramInt4 + 3.3646F * f2);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 4, arrayOfInt4, 0, paramInt8, -1 * b, i, paramInt3, paramInt4, 7, 0, false, 0, true);
     paramInt1++;
     
     arrayOfInt1[0] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[0] = (int)(paramInt3 - 9.1923F * f2); arrayOfInt3[0] = (int)(paramInt4 - 9.1923F * f2);
     arrayOfInt1[1] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[1] = (int)(paramInt3 - 12.557F * f2); arrayOfInt3[1] = (int)(paramInt4 - 3.3646F * f2);
     arrayOfInt1[2] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[2] = (int)(paramInt3 - 12.557F * f2); arrayOfInt3[2] = (int)(paramInt4 - 3.3646F * f2);
     arrayOfInt1[3] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[3] = (int)(paramInt3 - 9.1923F * f2); arrayOfInt3[3] = (int)(paramInt4 - 9.1923F * f2);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 4, arrayOfInt4, 0, paramInt8, 1 * b, i, paramInt3, paramInt4, 7, 0, false, 0, true);
     paramInt1++;
     
     arrayOfInt1[0] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[0] = (int)(paramInt3 - 9.1923F * f2); arrayOfInt3[0] = (int)(paramInt4 - 9.1923F * f2);
     arrayOfInt1[1] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[1] = (int)(paramInt3 - 3.3646F * f2); arrayOfInt3[1] = (int)(paramInt4 - 12.557F * f2);
     arrayOfInt1[2] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[2] = (int)(paramInt3 - 3.3646F * f2); arrayOfInt3[2] = (int)(paramInt4 - 12.557F * f2);
     arrayOfInt1[3] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[3] = (int)(paramInt3 - 9.1923F * f2); arrayOfInt3[3] = (int)(paramInt4 - 9.1923F * f2);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 4, arrayOfInt4, 0, paramInt8, 1 * b, i, paramInt3, paramInt4, 7, 0, false, 0, true);
     paramInt1++;
     
     arrayOfInt1[0] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[0] = (int)(paramInt3 - 3.3646F * f2); arrayOfInt3[0] = (int)(paramInt4 - 12.557F * f2);
     arrayOfInt1[1] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[1] = (int)(paramInt3 + 3.3646F * f2); arrayOfInt3[1] = (int)(paramInt4 - 12.557F * f2);
     arrayOfInt1[2] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[2] = (int)(paramInt3 + 3.3646F * f2); arrayOfInt3[2] = (int)(paramInt4 - 12.557F * f2);
     arrayOfInt1[3] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[3] = (int)(paramInt3 - 3.3646F * f2); arrayOfInt3[3] = (int)(paramInt4 - 12.557F * f2);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 4, arrayOfInt4, 0, paramInt8, -1 * b, i, paramInt3, paramInt4, 7, 0, false, 0, true);
     paramInt1++;
     
     arrayOfInt1[0] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[0] = (int)(paramInt3 + 9.1923F * f2); arrayOfInt3[0] = (int)(paramInt4 - 9.1923F * f2);
     arrayOfInt1[1] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[1] = (int)(paramInt3 + 3.3646F * f2); arrayOfInt3[1] = (int)(paramInt4 - 12.557F * f2);
     arrayOfInt1[2] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[2] = (int)(paramInt3 + 3.3646F * f2); arrayOfInt3[2] = (int)(paramInt4 - 12.557F * f2);
     arrayOfInt1[3] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[3] = (int)(paramInt3 + 9.1923F * f2); arrayOfInt3[3] = (int)(paramInt4 - 9.1923F * f2);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 4, arrayOfInt4, 0, paramInt8, 1 * b, i, paramInt3, paramInt4, 7, 0, false, 0, true);
     paramInt1++;
     
     arrayOfInt1[0] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[0] = (int)(paramInt3 + 9.1923F * f2); arrayOfInt3[0] = (int)(paramInt4 - 9.1923F * f2);
     arrayOfInt1[1] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[1] = (int)(paramInt3 + 12.557F * f2); arrayOfInt3[1] = (int)(paramInt4 - 3.3646F * f2);
     arrayOfInt1[2] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[2] = (int)(paramInt3 + 12.557F * f2); arrayOfInt3[2] = (int)(paramInt4 - 3.3646F * f2);
     arrayOfInt1[3] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[3] = (int)(paramInt3 + 9.1923F * f2); arrayOfInt3[3] = (int)(paramInt4 - 9.1923F * f2);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 4, arrayOfInt4, 0, paramInt8, 1 * b, i, paramInt3, paramInt4, 7, 0, false, 0, true);
     paramInt1++;
 
     
     arrayOfInt1[0] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[0] = (int)(paramInt3 + 12.557F * f2); arrayOfInt3[0] = (int)(paramInt4 - 3.3646F * f2);
     arrayOfInt1[1] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[1] = (int)(paramInt3 + 12.557F * f2); arrayOfInt3[1] = (int)(paramInt4 + 3.3646F * f2);
     arrayOfInt1[2] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[2] = (int)(paramInt3 + 12.557F * f2); arrayOfInt3[2] = (int)(paramInt4 + 3.3646F * f2);
     arrayOfInt1[3] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[3] = (int)(paramInt3 + 12.557F * f2); arrayOfInt3[3] = (int)(paramInt4 - 3.3646F * f2);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 4, arrayOfInt4, 0, paramInt8, -1 * b, i, paramInt3, paramInt4, 7, 0, false, 0, true);
     paramInt1++;
     
     arrayOfInt1[0] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[0] = (int)(paramInt3 + 9.1923F * f2); arrayOfInt3[0] = (int)(paramInt4 + 9.1923F * f2);
     arrayOfInt1[1] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[1] = (int)(paramInt3 + 12.557F * f2); arrayOfInt3[1] = (int)(paramInt4 + 3.3646F * f2);
     arrayOfInt1[2] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[2] = (int)(paramInt3 + 12.557F * f2); arrayOfInt3[2] = (int)(paramInt4 + 3.3646F * f2);
     arrayOfInt1[3] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[3] = (int)(paramInt3 + 9.1923F * f2); arrayOfInt3[3] = (int)(paramInt4 + 9.1923F * f2);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 4, arrayOfInt4, 0, paramInt8, 1 * b, i, paramInt3, paramInt4, 7, 0, false, 0, true);
     paramInt1++;
     
     arrayOfInt1[0] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[0] = (int)(paramInt3 + 9.1923F * f2); arrayOfInt3[0] = (int)(paramInt4 + 9.1923F * f2);
     arrayOfInt1[1] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[1] = (int)(paramInt3 + 3.3646F * f2); arrayOfInt3[1] = (int)(paramInt4 + 12.557F * f2);
     arrayOfInt1[2] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[2] = (int)(paramInt3 + 3.3646F * f2); arrayOfInt3[2] = (int)(paramInt4 + 12.557F * f2);
     arrayOfInt1[3] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[3] = (int)(paramInt3 + 9.1923F * f2); arrayOfInt3[3] = (int)(paramInt4 + 9.1923F * f2);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 4, arrayOfInt4, 0, paramInt8, 1 * b, i, paramInt3, paramInt4, 7, 0, false, 0, true);
     paramInt1++;
 
     
     arrayOfInt1[0] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[0] = (int)(paramInt3 + 3.3646F * f2); arrayOfInt3[0] = (int)(paramInt4 + 12.557F * f2);
     arrayOfInt1[1] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[1] = (int)(paramInt3 - 3.3646F * f2); arrayOfInt3[1] = (int)(paramInt4 + 12.557F * f2);
     arrayOfInt1[2] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[2] = (int)(paramInt3 - 3.3646F * f2); arrayOfInt3[2] = (int)(paramInt4 + 12.557F * f2);
     arrayOfInt1[3] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[3] = (int)(paramInt3 + 3.3646F * f2); arrayOfInt3[3] = (int)(paramInt4 + 12.557F * f2);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 4, arrayOfInt4, 0, paramInt8, -1 * b, i, paramInt3, paramInt4, 7, 0, false, 0, true);
     paramInt1++;
     
     arrayOfInt1[0] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[0] = (int)(paramInt3 - 9.1923F * f2); arrayOfInt3[0] = (int)(paramInt4 + 9.1923F * f2);
     arrayOfInt1[1] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[1] = (int)(paramInt3 - 3.3646F * f2); arrayOfInt3[1] = (int)(paramInt4 + 12.557F * f2);
     arrayOfInt1[2] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[2] = (int)(paramInt3 - 3.3646F * f2); arrayOfInt3[2] = (int)(paramInt4 + 12.557F * f2);
     arrayOfInt1[3] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[3] = (int)(paramInt3 - 9.1923F * f2); arrayOfInt3[3] = (int)(paramInt4 + 9.1923F * f2);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 4, arrayOfInt4, 0, paramInt8, 1 * b, i, paramInt3, paramInt4, 7, 0, false, 0, true);
     paramInt1++;
     
     arrayOfInt1[0] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[0] = (int)(paramInt3 - 9.1923F * f2); arrayOfInt3[0] = (int)(paramInt4 + 9.1923F * f2);
     arrayOfInt1[1] = (int)(paramInt2 - 4.0F * f1); arrayOfInt2[1] = (int)(paramInt3 - 12.557F * f2); arrayOfInt3[1] = (int)(paramInt4 + 3.3646F * f2);
     arrayOfInt1[2] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[2] = (int)(paramInt3 - 12.557F * f2); arrayOfInt3[2] = (int)(paramInt4 + 3.3646F * f2);
     arrayOfInt1[3] = (int)(paramInt2 + 4.0F * f1); arrayOfInt2[3] = (int)(paramInt3 - 9.1923F * f2); arrayOfInt3[3] = (int)(paramInt4 + 9.1923F * f2);
     paramArrayOfPlane[paramInt1] = new Plane(paramMedium, paramTrackers, arrayOfInt1, arrayOfInt3, arrayOfInt2, 4, arrayOfInt4, 0, paramInt8, 1 * b, i, paramInt3, paramInt4, 7, 0, false, 0, true);
     paramInt1++;
   }
 }


