 import java.io.BufferedReader;
 import java.io.ByteArrayInputStream;
 import java.io.DataInputStream;
 import java.io.File;
 import java.io.FileReader;
 import java.io.InputStreamReader;
 import java.io.PrintWriter;
 import java.net.Socket;
 import java.net.URL;
 import java.util.zip.ZipEntry;
 import java.util.zip.ZipInputStream;
 
 
 
 
 public class CarDefine
   implements Runnable
 {
   Trackers t;
   GameSparker gs;
   ContO[] bco;
   Medium m;
   Thread carloader;
   Thread actionloader;
   Thread stageaction;
   int[][] swits = new int[][] { { 50, 185, 282 }, { 100, 200, 310 }, { 60, 180, 275 }, { 76, 195, 298 }, { 70, 170, 275 }, { 70, 202, 293 }, { 60, 170, 289 }, { 70, 206, 291 }, { 90, 210, 295 }, { 90, 190, 276 }, { 70, 200, 295 }, { 50, 160, 270 }, { 90, 200, 305 }, { 50, 130, 210 }, { 80, 200, 300 }, { 70, 210, 290 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
   float[][] acelf = new float[][] { { 11.0F, 5.0F, 3.0F }, { 14.0F, 7.0F, 5.0F }, { 10.0F, 5.0F, 3.5F }, { 11.0F, 6.0F, 3.5F }, { 10.0F, 5.0F, 3.5F }, { 12.0F, 6.0F, 3.0F }, { 7.0F, 9.0F, 4.0F }, { 11.0F, 5.0F, 3.0F }, { 12.0F, 7.0F, 4.0F }, { 12.0F, 7.0F, 3.5F }, { 11.5F, 6.5F, 3.5F }, { 9.0F, 5.0F, 3.0F }, { 13.0F, 7.0F, 4.5F }, { 7.5F, 3.5F, 3.0F }, { 11.0F, 7.5F, 4.0F }, { 12.0F, 6.0F, 3.5F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F }, { 0.0F, 0.0F, 0.0F } };
   int[] handb = new int[] { 7, 10, 7, 15, 12, 8, 9, 10, 5, 7, 8, 10, 8, 12, 7, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   float[] airs = new float[] { 1.0F, 1.2F, 0.95F, 1.0F, 2.2F, 1.0F, 0.9F, 0.8F, 1.0F, 0.9F, 1.15F, 0.8F, 1.0F, 0.3F, 1.3F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
   int[] airc = new int[] { 70, 30, 40, 40, 30, 50, 40, 90, 40, 50, 75, 10, 50, 0, 100, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   
   int[] turn = new int[] { 6, 9, 5, 7, 8, 7, 5, 5, 9, 7, 7, 4, 6, 5, 7, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   float[] grip = new float[] { 20.0F, 27.0F, 18.0F, 22.0F, 19.0F, 20.0F, 25.0F, 20.0F, 19.0F, 24.0F, 22.5F, 25.0F, 30.0F, 27.0F, 25.0F, 27.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
   float[] bounce = new float[] { 1.2F, 1.05F, 1.3F, 1.15F, 1.3F, 1.2F, 1.15F, 1.1F, 1.2F, 1.1F, 1.15F, 0.8F, 1.05F, 0.8F, 1.1F, 1.15F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
   float[] simag = new float[] { 0.9F, 0.85F, 1.05F, 0.9F, 0.85F, 0.9F, 1.05F, 0.9F, 1.0F, 1.05F, 0.9F, 1.1F, 0.9F, 1.3F, 0.9F, 1.15F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
   
   float[] moment = new float[] { 1.3F, 0.75F, 1.4F, 1.2F, 1.1F, 1.38F, 1.43F, 1.48F, 1.35F, 1.7F, 1.42F, 2.0F, 1.26F, 3.0F, 1.5F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
   float[] comprad = new float[] { 0.5F, 0.4F, 0.8F, 0.5F, 0.4F, 0.5F, 0.5F, 0.5F, 0.5F, 0.8F, 0.5F, 1.5F, 0.5F, 0.8F, 0.5F, 0.8F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
   
   int[] push = new int[] { 2, 2, 3, 3, 2, 2, 2, 4, 2, 2, 2, 4, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   int[] revpush = new int[] { 2, 3, 2, 2, 2, 2, 2, 1, 2, 1, 2, 1, 2, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   int[] lift = new int[] { 0, 30, 0, 20, 0, 30, 0, 0, 20, 0, 0, 0, 10, 0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   int[] revlift = new int[] { 0, 0, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   
   int[] powerloss = new int[] { 2500000, 2500000, 3500000, 2500000, 4000000, 2500000, 3200000, 3200000, 2750000, 5500000, 2750000, 4500000, 3500000, 16700000, 3000000, 5500000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
 
   
   int[] flipy = new int[] { -50, -60, -92, -44, -60, -57, -54, -60, -77, -57, -82, -85, -28, -100, -63, -127, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   int[] msquash = new int[] { 7, 4, 7, 2, 8, 4, 6, 4, 3, 8, 4, 10, 3, 20, 3, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   int[] clrad = new int[] { 3300, 1700, 4700, 3000, 2000, 4500, 3500, 5000, 10000, 15000, 4000, 7000, 10000, 15000, 5500, 5000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   float[] dammult = new float[] { 0.75F, 0.8F, 0.45F, 0.8F, 0.42F, 0.7F, 0.72F, 0.6F, 0.58F, 0.41F, 0.67F, 0.45F, 0.61F, 0.25F, 0.38F, 0.52F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
   
   int[] maxmag = new int[] { 7600, 4200, 7200, 6000, 6000, 15000, 17200, 17000, 18000, 11000, 19000, 10700, 13000, 45000, 5800, 18000, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
 
 
   
   float[] dishandle = new float[] { 0.65F, 0.6F, 0.55F, 0.77F, 0.62F, 0.9F, 0.6F, 0.72F, 0.45F, 0.8F, 0.95F, 0.4F, 0.87F, 0.42F, 1.0F, 0.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
   float[] outdam = new float[] { 0.68F, 0.35F, 0.8F, 0.5F, 0.42F, 0.76F, 0.82F, 0.76F, 0.72F, 0.62F, 0.79F, 0.95F, 0.77F, 1.0F, 0.85F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
   int[] cclass = new int[] { 0, 0, 0, 0, 0, 1, 2, 2, 2, 2, 3, 4, 4, 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
 
   
   String[] names = new String[] { "Tornado Shark", "Formula 7", "Wow Caninaro", "La Vita Crab", "Nimi", "MAX Revenge", "Lead Oxide", "Kool Kat", "Drifter X", "Sword of Justice", "High Rider", "EL KING", "Mighty Eight", "M A S H E E N", "Radical One", "DR Monstaa", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
   int[] enginsignature = new int[] { 0, 1, 2, 1, 0, 3, 2, 2, 1, 0, 3, 4, 1, 4, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   
   int lastload = 0; int nlcars = 0; int nlocars = 0; int xnlocars = 0;
   boolean[] include = new boolean[40];
   String[] createdby = new String[40];
   int[] publish = new int[40];
   public CarDefine(ContO[] paramArrayOfContO, Medium paramMedium, Trackers paramTrackers, GameSparker paramGameSparker) {
     this.bco = paramArrayOfContO; this.m = paramMedium; this.t = paramTrackers; this.gs = paramGameSparker;
   }
   
   public void loadstat(byte[] paramArrayOfbyte, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
     this.names[paramInt4] = paramString;
     boolean bool1 = false, bool2 = false;
     
     String str = "";
     int[] arrayOfInt1 = { 128, 128, 128, 128, 128 };
     int i = 640;
     int[] arrayOfInt2 = { 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50 };
     int[] arrayOfInt3 = { 50, 50, 50 };
     this.enginsignature[paramInt4] = 0;
     float f = 0.0F;
     this.publish[paramInt4 - 16] = 0;
     this.createdby[paramInt4 - 16] = "Unkown User";
 
     
     try {
       DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfbyte));
       
       while ((str = dataInputStream.readLine()) != null) {
         
         str = str.trim();
         if (str.startsWith("stat("))
           try { i = 0;
             for (byte b = 0; b < 5; ) { arrayOfInt1[b] = getvalue("stat", str, b); if (arrayOfInt1[b] > 200) arrayOfInt1[b] = 200;  if (arrayOfInt1[b] < 16) arrayOfInt1[b] = 16;  i += arrayOfInt1[b]; b++; }
              bool1 = true; }
           catch (Exception exception) { bool1 = false; }
            
         if (str.startsWith("physics("))
           try { byte b; for (b = 0; b < 11; ) { arrayOfInt2[b] = getvalue("physics", str, b); if (arrayOfInt2[b] > 100) arrayOfInt2[b] = 100;  if (arrayOfInt2[b] < 0) arrayOfInt2[b] = 0;  b++; }
              for (b = 0; b < 3; ) { arrayOfInt3[b] = getvalue("physics", str, b + 11); if (b != 0 && arrayOfInt3[b] > 100) arrayOfInt3[b] = 100;  if (arrayOfInt3[b] < 0) arrayOfInt3[b] = 0;  b++; }
              this.enginsignature[paramInt4] = getvalue("physics", str, 14); if (this.enginsignature[paramInt4] > 4) this.enginsignature[paramInt4] = 0;  if (this.enginsignature[paramInt4] < 0) this.enginsignature[paramInt4] = 0; 
             f = getvalue("physics", str, 15);
             if (f > 0.0F) bool2 = true;  }
           catch (Exception exception) { bool2 = false; }
            
         if (str.startsWith("handling(")) {
           try { int j = getvalue("handling", str, 0); if (j > 200) j = 200;  if (j < 50) j = 50; 
             this.dishandle[paramInt4] = j / 200.0F; }
           catch (Exception exception) {}
         }
         if (str.startsWith("carmaker(")) this.createdby[paramInt4 - 16] = getSvalue("carmaker", str, 0); 
         if (str.startsWith("publish(")) this.publish[paramInt4 - 16] = getvalue("publish", str, 0); 
       } 
       dataInputStream.close();
     } catch (Exception exception) {
       System.out.println("Error Loading Car Stat: " + exception);
     } 
     if (bool1 && bool2)
     
     { int j = 0;
       if (i > 680) j = 680 - i; 
       if (i > 640 && i < 680) j = 640 - i; 
       if (i > 600 && i < 640) j = 600 - i; 
       if (i > 560 && i < 600) j = 560 - i; 
       if (i > 520 && i < 560) j = 520 - i; 
       if (i < 520) j = 520 - i; 
       while (j != 0) { for (byte b = 0; b < 5; ) { if (j > 0 && arrayOfInt1[b] < 200) { arrayOfInt1[b] = arrayOfInt1[b] + 1; j--; }  if (j < 0 && arrayOfInt1[b] > 16) { arrayOfInt1[b] = arrayOfInt1[b] - 1; j++; }  b++; }  }
        i = 0; byte b1;
       for (b1 = 0; b1 < 5; ) { i += arrayOfInt1[b1]; b1++; }
        if (i == 520) this.cclass[paramInt4] = 0; 
       if (i == 560) this.cclass[paramInt4] = 1; 
       if (i == 600) this.cclass[paramInt4] = 2; 
       if (i == 640) this.cclass[paramInt4] = 3; 
       if (i == 680) this.cclass[paramInt4] = 4;
       
       b1 = 0; byte b2 = 0;
       float f1 = 0.5F;
       if (arrayOfInt1[0] == 200) { b1 = 1; b2 = 1; }
        if (arrayOfInt1[0] > 192 && arrayOfInt1[0] < 200) { b1 = 12; b2 = 1; f1 = (arrayOfInt1[0] - 192) / 8.0F; }
        if (arrayOfInt1[0] == 192) { b1 = 12; b2 = 12; }
        if (arrayOfInt1[0] > 148 && arrayOfInt1[0] < 192) { b1 = 14; b2 = 12; f1 = (arrayOfInt1[0] - 148) / 44.0F; }
        if (arrayOfInt1[0] == 148) { b1 = 14; b2 = 14; }
        if (arrayOfInt1[0] > 133 && arrayOfInt1[0] < 148) { b1 = 10; b2 = 14; f1 = (arrayOfInt1[0] - 133) / 15.0F; }
        if (arrayOfInt1[0] == 133) { b1 = 10; b2 = 10; }
        if (arrayOfInt1[0] > 112 && arrayOfInt1[0] < 133) { b1 = 15; b2 = 10; f1 = (arrayOfInt1[0] - 112) / 21.0F; }
        if (arrayOfInt1[0] == 112) { b1 = 15; b2 = 15; }
        if (arrayOfInt1[0] > 107 && arrayOfInt1[0] < 112) { b1 = 11; b2 = 15; f1 = (arrayOfInt1[0] - 107) / 5.0F; }
        if (arrayOfInt1[0] == 107) { b1 = 11; b2 = 11; }
        if (arrayOfInt1[0] > 88 && arrayOfInt1[0] < 107) { b1 = 13; b2 = 11; f1 = (arrayOfInt1[0] - 88) / 19.0F; }
        if (arrayOfInt1[0] == 88) { b1 = 13; b2 = 13; }
        if (arrayOfInt1[0] > 88) {
         
         this.swits[paramInt4][0] = (int)((this.swits[b2][0] - this.swits[b1][0]) * f1 + this.swits[b1][0]);
         this.swits[paramInt4][1] = (int)((this.swits[b2][1] - this.swits[b1][1]) * f1 + this.swits[b1][1]);
         this.swits[paramInt4][2] = (int)((this.swits[b2][2] - this.swits[b1][2]) * f1 + this.swits[b1][2]);
       }
       else {
         
         f1 = arrayOfInt1[0] / 88.0F;
         if (f1 < 0.76D) f1 = 0.76F; 
         this.swits[paramInt4][0] = (int)(50.0F * f1);
         this.swits[paramInt4][1] = (int)(130.0F * f1);
         this.swits[paramInt4][2] = (int)(210.0F * f1);
       } 
       
       b1 = 0; b2 = 0; f1 = 0.5F;
       if (arrayOfInt1[1] == 200) { b1 = 1; b2 = 1; }
        if (arrayOfInt1[1] > 150 && arrayOfInt1[1] < 200) { b1 = 14; b2 = 1; f1 = (arrayOfInt1[1] - 150) / 50.0F; }
        if (arrayOfInt1[1] == 150) { b1 = 14; b2 = 14; }
        if (arrayOfInt1[1] > 144 && arrayOfInt1[1] < 150) { b1 = 9; b2 = 14; f1 = (arrayOfInt1[1] - 144) / 6.0F; }
        if (arrayOfInt1[1] == 144) { b1 = 9; b2 = 9; }
        if (arrayOfInt1[1] > 139 && arrayOfInt1[1] < 144) { b1 = 6; b2 = 9; f1 = (arrayOfInt1[1] - 139) / 5.0F; }
        if (arrayOfInt1[1] == 139) { b1 = 6; b2 = 6; }
        if (arrayOfInt1[1] > 128 && arrayOfInt1[1] < 139) { b1 = 15; b2 = 6; f1 = (arrayOfInt1[1] - 128) / 11.0F; }
        if (arrayOfInt1[1] == 128) { b1 = 15; b2 = 15; }
        if (arrayOfInt1[1] > 122 && arrayOfInt1[1] < 128) { b1 = 10; b2 = 15; f1 = (arrayOfInt1[1] - 122) / 6.0F; }
        if (arrayOfInt1[1] == 122) { b1 = 10; b2 = 10; }
        if (arrayOfInt1[1] > 119 && arrayOfInt1[1] < 122) { b1 = 3; b2 = 10; f1 = (arrayOfInt1[1] - 119) / 3.0F; }
        if (arrayOfInt1[1] == 119) { b1 = 3; b2 = 3; }
        if (arrayOfInt1[1] > 98 && arrayOfInt1[1] < 119) { b1 = 5; b2 = 3; f1 = (arrayOfInt1[1] - 98) / 21.0F; }
        if (arrayOfInt1[1] == 98) { b1 = 5; b2 = 5; }
        if (arrayOfInt1[1] > 81 && arrayOfInt1[1] < 98) { b1 = 0; b2 = 5; f1 = (arrayOfInt1[1] - 81) / 17.0F; }
        if (arrayOfInt1[1] == 81) { b1 = 0; b2 = 0; }
        if (arrayOfInt1[1] <= 80) { b1 = 2; b2 = 2; }
        if (arrayOfInt1[0] <= 88) { b1 = 13; b2 = 13; }
        this.acelf[paramInt4][0] = (this.acelf[b2][0] - this.acelf[b1][0]) * f1 + this.acelf[b1][0];
       this.acelf[paramInt4][1] = (this.acelf[b2][1] - this.acelf[b1][1]) * f1 + this.acelf[b1][1];
       this.acelf[paramInt4][2] = (this.acelf[b2][2] - this.acelf[b1][2]) * f1 + this.acelf[b1][2];
       if (arrayOfInt1[1] <= 70 && arrayOfInt1[0] > 88) { this.acelf[paramInt4][0] = 9.0F; this.acelf[paramInt4][1] = 4.0F; this.acelf[paramInt4][2] = 3.0F; }
 
       
       f1 = (arrayOfInt1[2] - 88) / 109.0F;
       if (f1 > 1.0F) f1 = 1.0F; 
       if (f1 < -0.55D) f1 = -0.55F; 
       this.airs[paramInt4] = 0.55F + 0.45F * f1 + 0.4F * arrayOfInt2[9] / 100.0F;
       if (this.airs[paramInt4] < 0.3D) this.airs[paramInt4] = 0.3F;
       
       this.airc[paramInt4] = (int)(10.0F + 70.0F * f1 + 30.0F * arrayOfInt2[10] / 100.0F);
       if (this.airc[paramInt4] < 0) this.airc[paramInt4] = 0;
       
       int k = (int)(670.0F - (arrayOfInt2[9] + arrayOfInt2[10]) / 200.0F * 420.0F);
       if (arrayOfInt1[0] <= 88) k = (int)(1670.0F - (arrayOfInt2[9] + arrayOfInt2[10]) / 200.0F * 1420.0F); 
       if (arrayOfInt1[2] > 190 && k < 300) k = 300; 
       this.powerloss[paramInt4] = k * 10000;
 
       
       this.moment[paramInt4] = 0.7F + (arrayOfInt1[3] - 16) / 184.0F * 1.0F;
       if (arrayOfInt1[0] < 110) this.moment[paramInt4] = 0.75F + (arrayOfInt1[3] - 16) / 184.0F * 1.25F; 
       if (arrayOfInt1[3] == 200 && arrayOfInt1[4] == 200 && arrayOfInt1[0] <= 88) this.moment[paramInt4] = 3.0F;
 
       
       float f2 = 0.9F + (arrayOfInt1[4] - 90) * 0.01F;
       if (f2 < 0.6D) f2 = 0.6F; 
       if (arrayOfInt1[4] == 200 && arrayOfInt1[0] <= 88) f2 = 3.0F; 
       this.maxmag[paramInt4] = (int)(f * f2);
       
       this.outdam[paramInt4] = 0.35F + (f2 - 0.6F) * 0.5F;
       if (this.outdam[paramInt4] < 0.35D) this.outdam[paramInt4] = 0.35F; 
       if (this.outdam[paramInt4] > 1.0F) this.outdam[paramInt4] = 1.0F;
       
       this.clrad[paramInt4] = (int)((arrayOfInt3[0] * arrayOfInt3[0]) * 1.5D);
       if (this.clrad[paramInt4] < 1000) this.clrad[paramInt4] = 1000; 
       this.dammult[paramInt4] = 0.3F + arrayOfInt3[1] * 0.005F;
       
       this.msquash[paramInt4] = (int)(2.0D + arrayOfInt3[2] / 7.6D);
       this.flipy[paramInt4] = paramInt2;
       
       this.handb[paramInt4] = (int)(7.0F + arrayOfInt2[0] / 100.0F * 8.0F);
       this.turn[paramInt4] = (int)(4.0F + arrayOfInt2[1] / 100.0F * 6.0F);
       this.grip[paramInt4] = 16.0F + arrayOfInt2[2] / 100.0F * 14.0F;
       if (this.grip[paramInt4] < 21.0F) { this.swits[paramInt4][0] = (int)(this.swits[paramInt4][0] + 40.0F * (21.0F - this.grip[paramInt4]) / 5.0F); if (this.swits[paramInt4][0] > 100) this.swits[paramInt4][0] = 100;  }
       
       this.bounce[paramInt4] = 0.8F + arrayOfInt2[3] / 100.0F * 0.6F;
       if (arrayOfInt2[3] > 67) {
         
         this.airs[paramInt4] = this.airs[paramInt4] * (0.76F + (1.0F - arrayOfInt2[3] / 100.0F) * 0.24F);
         this.airc[paramInt4] = (int)(this.airc[paramInt4] * (0.76F + (1.0F - arrayOfInt2[3] / 100.0F) * 0.24F));
       } 
       
       this.lift[paramInt4] = (int)(arrayOfInt2[5] * arrayOfInt2[5] / 10000.0F * 30.0F);
       this.revlift[paramInt4] = (int)(arrayOfInt2[6] / 100.0F * 32.0F);
       this.push[paramInt4] = (int)(2.0F + arrayOfInt2[7] / 100.0F * 2.0F * ((30 - this.lift[paramInt4]) / 30));
       this.revpush[paramInt4] = (int)(1.0F + arrayOfInt2[8] / 100.0F * 2.0F);
 
       
       this.comprad[paramInt4] = paramInt1 / 400.0F + (arrayOfInt1[3] - 16) / 184.0F * 0.2F;
       if (this.comprad[paramInt4] < 0.4D) this.comprad[paramInt4] = 0.4F;
       
       this.simag[paramInt4] = (paramInt3 - 17) * 0.0167F + 0.85F; }
     else { this.names[paramInt4] = ""; }
      } public int getvalue(String paramString1, String paramString2, int paramInt) { int i;
     byte b;
     String str;
     for (b = 0, str = "", i = paramString1.length() + 1; i < paramString2.length(); ) { String str1 = "" + paramString2.charAt(i); if (str1.equals(",") || str1.equals(")")) { b++; i++; }  if (b == paramInt) str = str + paramString2.charAt(i);  i++; }  return Float.valueOf(str).intValue(); }
   
   public String getSvalue(String paramString1, String paramString2, int paramInt) {
     String str = "";
     byte b = 0; int i = paramString1.length() + 1;
     while (i < paramString2.length() && b <= paramInt) {
       
       String str1 = "" + paramString2.charAt(i);
       if (str1.equals(",") || str1.equals(")")) { b++; } else if (b == paramInt) { str = str + str1; }
        i++;
     } 
     return str;
   }
   
   public int servervalue(String paramString, int paramInt) { int i = -1; try { byte b1; byte b2; byte b3; String str1; String str2; for (b1 = 0, b2 = 0, b3 = 0, str1 = "", str2 = ""; b1 < paramString.length() && b3 != 2; ) { str1 = "" + paramString.charAt(b1); if (str1.equals("|")) { if (b3 == 1 || ++b2 > paramInt) b3 = 2;  } else if (b2 == paramInt) { str2 = str2 + str1; b3 = 1; }  b1++; }  if (str2.equals("")) str2 = "-1";  i = Integer.valueOf(str2).intValue(); } catch (Exception exception) {} return i; } public String serverSvalue(String paramString, int paramInt) {
     String str = ""; try { byte b1; byte b2; byte b3; String str1; String str2; for (b1 = 0, b2 = 0, b3 = 0, str1 = "", str2 = ""; b1 < paramString.length() && b3 != 2; ) { str1 = "" + paramString.charAt(b1); if (str1.equals("|")) { if (b3 == 1 || ++b2 > paramInt) b3 = 2;  } else if (b2 == paramInt) { str2 = str2 + str1; b3 = 1; }  b1++; }  str = str2; } catch (Exception exception) {} return str;
   }
   
   String[] loadnames = new String[20];
   int nl = 0;
   int action = 0;
   boolean carlon = false;
   int reco = -2;
   int[] lcardate = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   int haltload = 0, onloadingcar = 0;
   int ac = -1;
   String acname = "Radical One";
   String fails = "";
   String tnickey = ""; String tclan = ""; String tclankey = "";
   int loadlist = 0;
   int[] adds = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
   String viewname = "";
   
   int staction = 0;
   String onstage = "";
   
   int inslot = -1;
   int roundslot = 0;
   String lastcar = "";
 
 
   
   public void loadready() {
     this.m.csky[0] = 170; this.m.csky[1] = 220; this.m.csky[2] = 255;
     this.m.cfade[0] = 255; this.m.cfade[1] = 220; this.m.cfade[2] = 220;
     this.m.snap[0] = 0; this.m.snap[1] = 0; this.m.snap[2] = 0;
     this.fails = "";
     for (byte b = 0; b < 20; ) { this.loadnames[b] = ""; b++; }
      this.nl = 0;
     this.action = 0;
   }
   
   public void sparkactionloader() { this.actionloader = new Thread(this); this.actionloader.start(); }
   public void sparkcarloader() { if (!this.carlon) { this.carloader = new Thread(this); this.carloader.start(); this.carlon = true; }
      } public void sparkstageaction() { this.stageaction = new Thread(this); this.stageaction.start(); }
    public void stopallnow() {
     this.staction = 0; this.action = 0; if (this.carloader != null) { this.carloader.stop(); this.carloader = null; }  if (this.actionloader != null) { this.actionloader.stop(); this.actionloader = null; }  if (this.stageaction != null) { this.stageaction.stop(); this.stageaction = null; }
   
   }
   
   public void run() {
     if (Thread.currentThread() == this.actionloader) {
 
       
       if (this.action == 10) {
         
         int i = -1;
         
         try {
           Socket socket = new Socket("multiplayer.needformadness.com", 7061);
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
           printWriter.println("9|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.names[this.ac] + "|");
           String str = bufferedReader.readLine();
           if (str != null) i = servervalue(str, 0); 
           socket.close(); bufferedReader.close(); printWriter.close();
         } catch (Exception exception) {
           i = -1;
         }  if (i == 0) { this.action = 3; } else { this.action = -10; }
          System.gc();
       } 
 
 
       
       if (this.action == 1) {
         
         this.reco = -1;
         
         try {
           Socket socket = new Socket("multiplayer.needformadness.com", 7061);
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
           printWriter.println("1|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|");
           String str = bufferedReader.readLine();
           if (str != null) { this.reco = servervalue(str, 0); if (this.reco == 0 || this.reco == 3 || this.reco > 10) { this.tnickey = serverSvalue(str, 1); if (this.reco != -167) { this.tclan = serverSvalue(str, 2); this.tclankey = serverSvalue(str, 3); } else { this.tclan = ""; this.tclankey = ""; }  }  }
            socket.close(); bufferedReader.close(); printWriter.close();
         } catch (Exception exception) {
           this.reco = -1;
         }  if (this.reco == 0 || this.reco == 3 || this.reco > 10) { this.action = 2; } else { this.action = 0; }
          System.gc();
       } 
       while (this.action == 2);
       
       if (this.action == 3) {
         
         String[] arrayOfString = new String[700];
         this.nl = 0;
         String str = "";
 
         
         try { URL uRL = new URL("http://multiplayer.needformadness.com/cars/lists/" + this.gs.tnick.getText() + ".txt?reqlo=" + (int)(Math.random() * 1000.0D) + "");
           DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
           while ((str = dataInputStream.readLine()) != null) { str = "" + str.trim();
             if (str.startsWith("mycars")) for (boolean bool = true; bool && this.nl < 700; ) { arrayOfString[this.nl] = getSvalue("mycars", str, this.nl); if (arrayOfString[this.nl].equals("")) { bool = false; continue; }  this.nl++; }
                 }
            if (this.nl > 0) { this.action = 4; } else { this.action = -1; }
            dataInputStream.close(); }
         catch (Exception exception) { String str1 = "" + exception; if (str1.indexOf("FileNotFound") != -1) { this.action = -1; } else { this.action = -2; }
            }
          if (this.action == 4) { this.gs.mcars.hide(); this.gs.mcars.removeAll(); byte b; for (b = 0; b < this.nl; ) { this.gs.mcars.add(this.gs.rd, arrayOfString[b]); b++; }  if (this.lastcar.equals("")) { this.gs.mcars.select(0); } else { this.gs.mcars.select(this.lastcar); this.lastcar = ""; }  for (b = 0; b < 40; ) { this.include[b] = false; b++; }  this.roundslot = 16; this.nlocars = 16; }
       
       } 
       if (this.action == 4) {
         
         this.m.csky[0] = 170; this.m.csky[1] = 220; this.m.csky[2] = 255;
         this.m.cfade[0] = 255; this.m.cfade[1] = 220; this.m.cfade[2] = 220;
         this.m.snap[0] = 0; this.m.snap[1] = 0; this.m.snap[2] = 0;
         if (loadonlinecar(this.gs.mcars.getSelectedItem(), this.roundslot) == this.roundslot) { this.inslot = this.roundslot; this.roundslot++; if (this.roundslot == 36) this.roundslot = 16;  if (this.nlocars < 36) this.nlocars++;  this.lastload = 2; this.action = 5; } else { if (this.lastload == 2) this.lastload = 0;  this.action = -1; }
          System.gc();
       } 
 
 
       
       if (this.action == 6) {
         
         int i = -1;
         
         try {
           if (this.ac != -1) this.acname = this.names[this.ac]; 
           Socket socket = new Socket("multiplayer.needformadness.com", 7061);
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
           printWriter.println("8|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.acname + "|");
           String str = bufferedReader.readLine();
           if (str != null) i = servervalue(str, 0); 
           socket.close(); bufferedReader.close(); printWriter.close();
         } catch (Exception exception) {
           i = -1;
         }  if (i == 0) { if (this.lastload == 2) { this.lastload = -2; this.lastcar = this.gs.mcars.getSelectedItem(); }  this.action = 7; }
          if (i == 3) this.action = -7; 
         if (i == 4) this.action = -8; 
         if (this.action == 6) this.action = -9; 
         System.gc();
       } 
 
 
       
       if (this.action == 11) {
         
         this.nl = 0;
         String str = "";
 
         
         try { String str1 = "all";
           if (this.loadlist == 1) str1 = "Wall";  if (this.loadlist == 2) str1 = "WA";  if (this.loadlist == 3) str1 = "WAB";  if (this.loadlist == 4) str1 = "WB";  if (this.loadlist == 5) str1 = "WBC";  if (this.loadlist == 6) str1 = "WC"; 
           if (this.loadlist == 7) str1 = "Mall";  if (this.loadlist == 8) str1 = "MA";  if (this.loadlist == 9) str1 = "MAB";  if (this.loadlist == 10) str1 = "MB";  if (this.loadlist == 11) str1 = "MBC";  if (this.loadlist == 12) str1 = "MC"; 
           if (this.loadlist == 13) str1 = "Sall";  if (this.loadlist == 14) str1 = "SA";  if (this.loadlist == 15) str1 = "SAB";  if (this.loadlist == 16) str1 = "SB";  if (this.loadlist == 17) str1 = "SBC";  if (this.loadlist == 18) str1 = "SC"; 
           if (this.loadlist == 19) str1 = "Aall";  if (this.loadlist == 20) str1 = "AA";  if (this.loadlist == 21) str1 = "AAB";  if (this.loadlist == 22) str1 = "AB";  if (this.loadlist == 23) str1 = "ABC";  if (this.loadlist == 24) str1 = "AC";
           
           URL uRL = new URL("http://multiplayer.needformadness.com/cars/top20/" + str1 + ".txt");
           DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
           while ((str = dataInputStream.readLine()) != null) { str = "" + str.trim();
             if (str.startsWith("cars")) for (boolean bool = true; bool && this.nl < 20; ) { this.loadnames[this.nl] = getSvalue("cars", str, this.nl); if (this.loadnames[this.nl].equals("")) { bool = false; continue; }  this.nl++; }
                 if (str.startsWith("adds")) for (byte b = 0; b < this.nl; ) { this.adds[b] = getvalue("adds", str, b); b++; }
                 }
            if (this.nl > 0) { this.action = 12; } else { this.action = -1; }
            dataInputStream.close(); }
         catch (Exception exception) { this.action = -1; }
          System.gc();
       } 
       
       if (this.action == 12) {
         
         this.m.csky[0] = 170; this.m.csky[1] = 220; this.m.csky[2] = 255;
         this.m.cfade[0] = 255; this.m.cfade[1] = 220; this.m.cfade[2] = 220;
         this.m.snap[0] = 0; this.m.snap[1] = 0; this.m.snap[2] = 0;
         this.xnlocars = 36;
         int i = this.nl; this.nl = 0;
         while (this.nl < i) { if (this.xnlocars < 56 && loadonlinecar(this.loadnames[this.nl], this.xnlocars) == this.xnlocars) this.xnlocars++;  this.nl++; }
          this.nl = 0;
         if (this.xnlocars > 36) { this.action = 13; } else { this.action = -1; }
          System.gc();
       } 
 
 
       
       if (this.action == 101) {
         
         this.nl = 0;
         String str = "";
 
         
         try { URL uRL = new URL("http://multiplayer.needformadness.com/cars/lists/" + this.viewname + ".txt?reqlo=" + (int)(Math.random() * 1000.0D) + "");
           DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
           while ((str = dataInputStream.readLine()) != null) { str = "" + str.trim();
             if (str.startsWith("mycars")) for (boolean bool = true; bool && this.nl < 20; ) { this.loadnames[this.nl] = getSvalue("mycars", str, this.nl); if (this.loadnames[this.nl].equals("")) { bool = false; continue; }  this.nl++; }
                 }
            if (this.nl > 0) { this.action = 102; } else { this.action = -2; }
            dataInputStream.close(); }
         catch (Exception exception) { String str1 = "" + exception; if (str1.indexOf("FileNotFound") != -1) { this.action = -2; } else { this.action = -1; }  }
          System.gc();
       } 
       
       if (this.action == 102) {
         
         this.m.csky[0] = 170; this.m.csky[1] = 220; this.m.csky[2] = 255;
         this.m.cfade[0] = 255; this.m.cfade[1] = 220; this.m.cfade[2] = 220;
         this.m.snap[0] = 0; this.m.snap[1] = 0; this.m.snap[2] = 0; int i;
         for (i = 0; i < 40; ) { this.include[i] = false; i++; }
          this.xnlocars = 36;
         i = this.nl; this.nl = 0;
         while (this.nl < i) { if (this.xnlocars < 56 && loadonlinecar(this.loadnames[this.nl], this.xnlocars) == this.xnlocars) this.xnlocars++;  this.nl++; }
          this.nl = 0;
         if (this.xnlocars > 36) { this.action = 103; } else { this.action = -1; }
          System.gc();
       } 
 
       
       this.actionloader = null;
     } 
 
 
     
     if (Thread.currentThread() == this.carloader) {
       
       while (this.nl > 0) {
         
         int i = 0; int j;
         for (j = 16; j < 56; ) { if (this.loadnames[this.nl - 1].equals(this.names[j])) i = -1;  j++; }
          if (this.fails.indexOf("|" + this.loadnames[this.nl - 1] + "|") != -1) i = -1; 
         if (i != -1) {
           
           j = this.lcardate[0];
           int k = 36; if (this.haltload > 0) { k = 36 + this.haltload; j = this.lcardate[this.haltload]; }  i = k;
           for (int m = k; m < 56; ) { if (this.lcardate[m - 36] < j) { j = this.lcardate[m - 36]; i = m; }  m++; }
            this.onloadingcar = i - 35;
           if (loadonlinecar(this.loadnames[this.nl - 1], i) == -1) { this.fails += "|" + this.loadnames[this.nl - 1] + "|"; } else { this.lcardate[i - 36] = this.lcardate[i - 36] + 1; }
            this.onloadingcar = 0;
         } 
         this.nl--; 
         try { Thread.sleep(20L); } catch (InterruptedException interruptedException) {}
       } 
       this.carlon = false;
       this.carloader = null;
     } 
 
     
     if (Thread.currentThread() == this.stageaction) {
 
       
       if (this.staction == 1) {
         
         int i = -1;
         
         try {
           Socket socket = new Socket("multiplayer.needformadness.com", 7061);
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
           printWriter.println("19|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.onstage + "|");
           String str = bufferedReader.readLine();
           if (str != null) i = servervalue(str, 0); 
           socket.close(); bufferedReader.close(); printWriter.close();
         } catch (Exception exception) {
           i = -1;
         }  if (i == 0) { try { this.gs.mstgs.remove(this.onstage); } catch (Exception exception) {} this.gs.mstgs.select(0); this.staction = 0; } else { this.staction = -1; }
       
       } 
       if (this.staction == 4) {
         
         this.reco = -1;
         
         try {
           Socket socket = new Socket("multiplayer.needformadness.com", 7061);
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
           printWriter.println("1|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|");
           String str = bufferedReader.readLine();
           if (str != null) { this.reco = servervalue(str, 0); if (this.reco == 0 || this.reco == 3 || this.reco > 10) { this.tnickey = serverSvalue(str, 1); if (this.reco != -167) { this.tclan = serverSvalue(str, 2); this.tclankey = serverSvalue(str, 3); } else { this.tclan = ""; this.tclankey = ""; }  }  }
            socket.close(); bufferedReader.close(); printWriter.close();
         } catch (Exception exception) {
           this.reco = -1;
         }  if (this.reco == 0 || this.reco == 3 || this.reco > 10) { this.staction = 5; } else { this.staction = 3; }
          System.gc();
         while (this.staction == 5);
       } 
 
       
       if (this.staction == 2) {
         
         int i = -1;
         if (this.msloaded == 1) for (byte b = 1; b < this.gs.mstgs.getItemCount(); ) { if (this.gs.mstgs.getItem(b).equals(this.onstage)) i = 3;  b++; }
             if (i == -1)
           
           try {
             
             Socket socket = new Socket("multiplayer.needformadness.com", 7061);
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
             printWriter.println("18|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.onstage + "|");
             String str = bufferedReader.readLine();
             if (str != null) i = servervalue(str, 0); 
             socket.close(); bufferedReader.close(); printWriter.close();
           } catch (Exception exception) {
             i = -1;
           }  
         this.staction = -1;
         if (i == 0) { this.staction = 0; if (this.msloaded == 1) this.gs.mstgs.addstg(this.onstage);  }
          if (i == 3) this.staction = -2; 
         if (i == 4) this.staction = -3;
       
       } 
       
       this.stageaction = null;
     } 
   }
 
 
 
 
 
   
   public int loadonlinecar(String paramString, int paramInt) {
     try {
       ZipInputStream zipInputStream;
       String str = "http://multiplayer.needformadness.com/cars/" + paramString + ".radq";
       str = str.replace(' ', '_'); URL uRL = new URL(str);
 
 
 
 
       
       int i = uRL.openConnection().getContentLength();
       DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
       byte[] arrayOfByte = new byte[i]; dataInputStream.readFully(arrayOfByte);
       if (arrayOfByte[0] == 80 && arrayOfByte[1] == 75 && arrayOfByte[2] == 3) {
         
         zipInputStream = new ZipInputStream(new ByteArrayInputStream(arrayOfByte));
       } else {
         byte[] arrayOfByte1;
         byte b;
         for (arrayOfByte1 = new byte[i - 40], b = 0; b < i - 40; ) { byte b1 = 20; if (b >= 'Ǵ') b1 = 40;  arrayOfByte1[b] = arrayOfByte[b + b1]; b++; }
          zipInputStream = new ZipInputStream(new ByteArrayInputStream(arrayOfByte1));
       } 
 
 
       
       ZipEntry zipEntry = zipInputStream.getNextEntry();
       
       if (zipEntry != null)
       
       { int j = Integer.valueOf(zipEntry.getName()).intValue();
         byte[] arrayOfByte1 = new byte[j];
         int k = 0;
         
         while (j > 0) { int m = zipInputStream.read(arrayOfByte1, k, j); k += m; j -= m; }
          this.m.loadnew = true;
         this.bco[paramInt] = new ContO(arrayOfByte1, this.m, this.t);
         if ((this.bco[paramInt]).errd || (this.bco[paramInt]).npl <= 60 || (this.bco[paramInt]).maxR < 120) paramInt = -1; 
         if (paramInt != -1) {
           (this.bco[paramInt]).shadow = true; (this.bco[paramInt]).noline = false; (this.bco[paramInt]).decor = false; (this.bco[paramInt]).tnt = 0;
           (this.bco[paramInt]).disp = 0; (this.bco[paramInt]).disline = 7; (this.bco[paramInt]).grounded = 1.0F;
           boolean bool = true;
           if ((this.bco[paramInt]).keyz[0] < 0 || (this.bco[paramInt]).keyx[0] > 0) bool = false; 
           if ((this.bco[paramInt]).keyz[1] < 0 || (this.bco[paramInt]).keyx[1] < 0) bool = false; 
           if ((this.bco[paramInt]).keyz[2] > 0 || (this.bco[paramInt]).keyx[2] > 0) bool = false; 
           if ((this.bco[paramInt]).keyz[3] > 0 || (this.bco[paramInt]).keyx[3] < 0) bool = false; 
           if (!bool) paramInt = -1; 
         } 
         if (paramInt != -1) {
           loadstat(arrayOfByte1, paramString, (this.bco[paramInt]).maxR, (this.bco[paramInt]).roofat, (this.bco[paramInt]).wh, paramInt);
           if (this.names[paramInt].equals("")) paramInt = -1; 
         } 
         this.m.loadnew = false;
         dataInputStream.close();
         zipInputStream.close(); }
       else { paramInt = -1; }
     
     } catch (Exception exception) {
       paramInt = -1;
     }  System.gc();
     return paramInt;
   }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
   
   int msloaded = 0;
 
   
   public void loadmystages(CheckPoints paramCheckPoints) {
     String[] arrayOfString = new String[700];
     byte b = 0;
     String str = "";
 
     
     try { URL uRL = new URL("http://multiplayer.needformadness.com/tracks/lists/" + this.gs.tnick.getText() + ".txt?reqlo=" + (int)(Math.random() * 1000.0D) + "");
       DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
       while ((str = dataInputStream.readLine()) != null) { str = "" + str.trim();
         if (str.startsWith("mystages")) for (boolean bool = true; bool && b < 'ʼ'; ) { arrayOfString[b] = getSvalue("mystages", str, b); if (arrayOfString[b].equals("")) { bool = false; continue; }  b++; }
             }
        if (b > 0) { this.msloaded = 1; } else { this.msloaded = -2; }
        dataInputStream.close(); }
     catch (Exception exception) { String str1 = "" + exception; if (str1.indexOf("FileNotFound") != -1) { this.msloaded = -2; } else { this.msloaded = -1; }
        }
      if (this.msloaded == 1) { this.gs.mstgs.hide(); this.gs.mstgs.removeAll(); this.gs.mstgs.add(this.gs.rd, "Select Stage"); int i; byte b1; for (i = 0, b1 = 0; b1 < b; ) { this.gs.mstgs.add(this.gs.rd, arrayOfString[b1]); if (paramCheckPoints.name.equals(arrayOfString[b1])) { i = b1 + 1; paramCheckPoints.top20 = 0; }  b1++; }  this.gs.mstgs.select(i); this.gs.mstgs.show(); }
      if (this.msloaded == -2) { this.gs.mstgs.hide(); this.gs.mstgs.removeAll(); this.gs.mstgs.add(this.gs.rd, "You have not published or added any stages..."); this.gs.mstgs.select(0); this.gs.mstgs.show(); }
      if (this.msloaded == -1) { this.gs.mstgs.hide(); this.gs.mstgs.removeAll(); this.gs.mstgs.add(this.gs.rd, "Failed to load stages, please try again later."); this.gs.mstgs.select(0); this.gs.mstgs.show(); }
      System.gc();
   }
   
   int[] top20adds = new int[20];
 
   
   public void loadtop20(int paramInt) {
     String[] arrayOfString = new String[20];
     byte b = 0;
     String str = "";
 
     
     try { String str1 = "A"; if (paramInt == 3) str1 = "W";  if (paramInt == 4) str1 = "M"; 
       URL uRL = new URL("http://multiplayer.needformadness.com/tracks/top20/" + str1 + ".txt");
       DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
       while ((str = dataInputStream.readLine()) != null) { str = "" + str.trim();
         if (str.startsWith("stages")) for (boolean bool = true; bool && b < 20; ) { arrayOfString[b] = getSvalue("stages", str, b); if (arrayOfString[b].equals("")) { bool = false; continue; }  b++; }
             if (str.startsWith("adds")) for (byte b1 = 0; b1 < b; ) { this.top20adds[b1] = getvalue("adds", str, b1); b1++; }
             }
        if (b > 0) { this.msloaded = paramInt; } else { this.msloaded = -2; }
        dataInputStream.close(); }
     catch (Exception exception) { String str1 = "" + exception; if (str1.indexOf("FileNotFound") != -1) { this.msloaded = -2; } else { this.msloaded = -1; }
        }
      if (this.msloaded == paramInt) { this.gs.mstgs.hide(); this.gs.mstgs.removeAll(); this.gs.mstgs.add(this.gs.rd, "Select Stage"); for (byte b1 = 0; b1 < b; ) { this.gs.mstgs.add(this.gs.rd, "N#" + (b1 + 1) + " " + arrayOfString[b1]); b1++; }  this.gs.mstgs.select(0); this.gs.mstgs.show(); }
      if (this.msloaded == -1 || this.msloaded == -2) { this.gs.mstgs.hide(); this.gs.mstgs.removeAll(); this.gs.mstgs.add(this.gs.rd, "Failed to load Top20 list, please try again later."); this.gs.mstgs.select(0); this.gs.mstgs.show(); }
      System.gc();
   }
 
   
   public void loadclanstages(String paramString) {
     if (!paramString.equals(""))
     
     { String[] arrayOfString = new String[700];
       byte b = 0;
       String str = "";
       
       try { URL uRL = new URL("http://multiplayer.needformadness.com/clans/" + paramString + "/stages.txt");
         DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
         while ((str = dataInputStream.readLine()) != null && b < 'ʼ') { arrayOfString[b] = str; b++; }
          if (b > 0) { this.msloaded = 7; } else { this.msloaded = -2; }
          dataInputStream.close(); }
       catch (Exception exception) { String str1 = "" + exception; if (str1.indexOf("FileNotFound") != -1) { this.msloaded = -2; } else { this.msloaded = -1; }  }
        if (this.msloaded == 7) { this.gs.mstgs.hide(); this.gs.mstgs.removeAll(); this.gs.mstgs.add(this.gs.rd, "Select Stage"); for (byte b1 = 0; b1 < b; ) { this.gs.mstgs.add(this.gs.rd, arrayOfString[b1]); b1++; }  this.gs.mstgs.select(0); this.gs.mstgs.show(); }
        if (this.msloaded == -1) { this.gs.mstgs.hide(); this.gs.mstgs.removeAll(); this.gs.mstgs.add(this.gs.rd, "Failed to load clan stages, please try again later."); this.gs.mstgs.select(0); this.gs.mstgs.show(); }
        if (this.msloaded == -2) { this.gs.mstgs.hide(); this.gs.mstgs.removeAll(); this.gs.mstgs.add(this.gs.rd, "No stages have been added to your clan yet."); this.gs.mstgs.select(0); this.gs.mstgs.show(); }
        System.gc(); }
     else { this.msloaded = -2; this.gs.mstgs.hide(); this.gs.mstgs.removeAll(); this.gs.mstgs.add(this.gs.rd, "You are not a member of any clan yet."); this.gs.mstgs.select(0); this.gs.mstgs.show(); }
   
   }
 
 
 
 
 
   
   public void loadstagemaker() {
     this.gs.mstgs.hide();
     this.gs.mstgs.removeAll();
     this.gs.mstgs.add(this.gs.rd, "Select Stage");
     
     byte b = 0;
     File file = new File("" + Madness.fpath + "mystages/");
     if (file.exists()) {
       
       String[] arrayOfString = (new File("" + Madness.fpath + "mystages/")).list();
       for (byte b1 = 0; b1 < arrayOfString.length; ) { if (arrayOfString[b1].toLowerCase().endsWith(".txt") && b < 'È') { this.gs.mstgs.add(this.gs.rd, arrayOfString[b1].substring(0, arrayOfString[b1].length() - 4)); b++; }  b1++; }
     
     } 
     if (b != 0) { this.msloaded = 2; } else { this.gs.mstgs.add(this.gs.rd, "No stages where found in your 'mystages' folder."); this.msloaded = -1; }
      this.gs.mstgs.select(0);
     this.gs.mstgs.show();
   }
 
 
   
   public void loadcarmaker() {
     this.m.csky[0] = 170; this.m.csky[1] = 220; this.m.csky[2] = 255;
     this.m.cfade[0] = 255; this.m.cfade[1] = 220; this.m.cfade[2] = 220;
     this.m.snap[0] = 0; this.m.snap[1] = 0; this.m.snap[2] = 0;
     for (byte b = 0; b < 40; ) { this.include[b] = false; b++; }
     
     this.nlcars = 16;
     File file = new File("" + Madness.fpath + "mycars/");
     if (file.exists()) {
       
       String[] arrayOfString = (new File("" + Madness.fpath + "mycars/")).list();
       for (byte b1 = 0; b1 < arrayOfString.length; ) { if (arrayOfString[b1].toLowerCase().endsWith(".rad") && this.nlcars < 56 && loadcar(arrayOfString[b1].substring(0, arrayOfString[b1].length() - 4), this.nlcars) == this.nlcars) this.nlcars++;  b1++; }
     
     } 
     System.gc();
     if (this.nlcars > 16) this.lastload = 1;
   
   }
 
 
   
   public int loadcar(String paramString, int paramInt) {
     
     try { File file = new File("" + Madness.fpath + "mycars/" + paramString + ".rad");
       if (file.exists()) {
         
         String str1 = "";
         BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
         String str2 = null;
         for (; (str2 = bufferedReader.readLine()) != null; str1 = str1 + "" + str2 + "\n");
         bufferedReader.close(); bufferedReader = null;
         this.m.loadnew = true;
         this.bco[paramInt] = new ContO(str1.getBytes(), this.m, this.t);
         if ((this.bco[paramInt]).errd || (this.bco[paramInt]).npl <= 60) paramInt = -1; 
         if (paramInt != -1) {
           (this.bco[paramInt]).shadow = true; (this.bco[paramInt]).noline = false; (this.bco[paramInt]).decor = false; (this.bco[paramInt]).tnt = 0;
           (this.bco[paramInt]).disp = 0; (this.bco[paramInt]).disline = 7; (this.bco[paramInt]).grounded = 1.0F;
           boolean bool = true;
           if ((this.bco[paramInt]).keyz[0] < 0 || (this.bco[paramInt]).keyx[0] > 0) bool = false; 
           if ((this.bco[paramInt]).keyz[1] < 0 || (this.bco[paramInt]).keyx[1] < 0) bool = false; 
           if ((this.bco[paramInt]).keyz[2] > 0 || (this.bco[paramInt]).keyx[2] > 0) bool = false; 
           if ((this.bco[paramInt]).keyz[3] > 0 || (this.bco[paramInt]).keyx[3] < 0) bool = false; 
           if (!bool) paramInt = -1; 
         } 
         if (paramInt != -1) {
           loadstat(str1.getBytes(), paramString, (this.bco[paramInt]).maxR, (this.bco[paramInt]).roofat, (this.bco[paramInt]).wh, paramInt);
           if (this.names[paramInt].equals("")) paramInt = -1; 
         } 
         this.m.loadnew = false;
       } else {
         paramInt = -1;
       }  }
     catch (Exception exception) { paramInt = -1; System.out.println("Error Loading Car: " + exception); }
      System.gc();
     return paramInt;
   }
 }


