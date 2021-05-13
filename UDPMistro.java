 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 import java.io.PrintWriter;
 import java.net.Socket;
 import java.util.Date;
 
 public class UDPMistro
   implements Runnable
 {
   Thread runner;
   int runon = 0;
   udpOnline[] udpc = new udpOnline[20];
   int porturn = 0;
   udpServe[] usrv = new udpServe[13];
   
   int diledelay = 0;
   long sendat = 0L;
   String sendcheck = "";
   int delay = 0;
   int[] ldelays = new int[5];
   int diled = 0;
   
   int rate = 30;
   float freg = 0.0F;
   
   boolean go = false;
   int im = 0;
   int nplayers = 0;
   
   String[][] info = new String[14][3];
   int[][] frame = new int[14][3];
   int[] lframe = new int[8];
   int[] force = new int[8];
   int[] lcframe = new int[8];
   boolean[] isbot = new boolean[8];
   
   Socket socket;
   
   BufferedReader din;
   PrintWriter dout;
   int[] gocnt = new int[8];
   int[] out = new int[8];
   String xtserver = "";
   int xtservport = 0;
   int pgame = 0;
 
 
 
 
   
   int wx;
 
 
 
 
   
   public void UDPConnectOnline(String paramString, int paramInt1, int paramInt2, int paramInt3) {
     this.diledelay = 0;
     this.delay = 0; byte b;
     for (b = 0; b < 5; ) { this.ldelays[b] = 0; b++; }
      this.diled = 0;
     
     this.go = false;
     this.freg = 0.0F;
     this.im = paramInt3;
     this.nplayers = paramInt2;
     
     for (b = 0; b < 8; ) { for (byte b1 = 0; b1 < 3; ) { this.frame[b][b1] = -1; this.info[b][b1] = ""; b1++; }  this.isbot[b] = false; this.lframe[b] = 0; this.force[b] = 0; this.lcframe[b] = 0; b++; }
      for (b = 0; b < 20; ) { this.udpc[b] = new udpOnline(this, paramString, paramInt1 + this.im, b, this.porturn); b++; }
      if (this.porturn == 0) { this.porturn = 20; } else { this.porturn = 0; }
      if (this.im >= this.nplayers) { for (this.frame[this.im][0] = 11111, this.info[this.im][0] = "watching"; this.info[this.im][0].length() < 110; this.info[this.im][0] = this.info[this.im][0] + "|"); this.nplayers++; this.go = true; }
     
     this.runon = 1;
     this.runner = new Thread(this); this.runner.start();
   }
 
 
   
   public void UDPConnectLan(String paramString, int paramInt1, int paramInt2) {
     this.diledelay = 0;
     this.delay = 0; byte b;
     for (b = 0; b < 5; ) { this.ldelays[b] = 0; b++; }
      this.diled = 0;
     
     this.go = false;
     this.freg = 0.0F;
     this.im = paramInt2;
     this.nplayers = paramInt1;
     for (b = 0; b < 8; ) { for (byte b1 = 0; b1 < 3; ) { this.frame[b][b1] = -1; this.info[b][b1] = ""; b1++; }  this.isbot[b] = false; this.lframe[b] = 0; this.force[b] = 0; this.lcframe[b] = 0; b++; }
     
     if (this.im != 0) {
       
       for (b = 0; b < 20; ) { this.udpc[b] = new udpOnline(this, paramString, 7060 + this.im, b, this.porturn); b++; }
        if (this.porturn == 0) { this.porturn = 20; } else { this.porturn = 0; }
        if (this.im >= this.nplayers) { for (this.frame[this.im][0] = 11111, this.info[this.im][0] = "watching"; this.info[this.im][0].length() < 110; this.info[this.im][0] = this.info[this.im][0] + "|"); this.nplayers++; this.go = true; }
        this.runon = 1;
     } else {
 
       
       try {
         
         this.socket = new Socket(this.xtserver, this.xtservport);
         this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
         this.dout = new PrintWriter(this.socket.getOutputStream(), true);
       } catch (Exception exception) {}
       this.runon = 4;
     } 
     
     this.runner = new Thread(this); this.runner.start();
   }
 
 
   
   public void UDPLanServer(int paramInt1, String paramString, int paramInt2, int paramInt3) {
     this.xtserver = paramString;
     this.xtservport = paramInt2;
     this.pgame = paramInt3; byte b;
     for (b = 0; b < 8; ) { byte b1; for (this.gocnt[b] = 3, this.out[b] = 0, b1 = 0; b1 < 3; ) { this.frame[b][b1] = -1; this.info[b][b1] = ""; b1++; }  this.lframe[b] = 0; this.force[b] = 0; this.lcframe[b] = 0; b++; }
      for (b = 0; b < this.nplayers + 5; ) { this.usrv[b] = new udpServe(this, b + 1); b++; }
   
   }
   public void UDPquit() {
     if (this.runon == 1) this.runon = 2;  if (this.runon == 4) this.runon = 5;
   
   }
   
   public void run() {
     byte b1 = 0;
     
     while (this.runon == 1) {
       
       if (!(this.udpc[0]).started) { this.udpc[0].spark(); b1 = 1; } else { Date date = new Date(); if (b1 > this.delay / this.rate && date.getTime() - (this.udpc[0]).sendat > (this.rate - 5)) { this.udpc[0].spark(); b1 = 1; }
          }
        if (this.delay > this.rate && b1 <= this.delay / this.rate && b1 >= 1 && b1 < 20) {
         
         Date date = new Date(); long l = date.getTime() - (this.udpc[b1 - 1]).sendat;
         if (l >= (this.rate - 5) && l < (this.rate * 2)) { this.udpc[b1].spark(); b1++; }
       
       } 
       if (this.diled == 10)
       {
         for (byte b = 0; b < 20; ) { if ((this.udpc[b]).started) { Date date = new Date(); long l = date.getTime() - (this.udpc[b]).sendat; if (l > this.delay * 1.5D && l > this.rate) this.udpc[b].stomp();  }  b++; }
       
       }
       if (this.diledelay > 0) this.diledelay--; 
       try {
         Thread.sleep(5L);
       } catch (InterruptedException interruptedException) {}
     } 
 
     
     byte b2 = 0;
     byte b3 = 0;
     
     while (this.runon == 4) {
       
       for (byte b = 0; b < this.nplayers; b++) {
         
         boolean bool = false;
         if (this.info[b][0].length() > 16) { String str = "" + this.info[b][0].charAt(15); if (!str.equals("0")) bool = true;  }
          if (!bool && this.out[b] == 77) this.out[b] = 0;
         
         if (this.out[b] < 76)
         {
           if (this.frame[b][0] > 6)
           
           { if (this.lcframe[b] != this.frame[b][0] && !bool) { this.lcframe[b] = this.frame[b][0]; this.out[b] = 0; } else { if (this.out[b] < 70) this.out[b] = 71;  this.out[b] = this.out[b] + 1; if (bool) this.out[b] = 77;  if (this.out[b] == 76) { this.info[b][0] = "disco"; this.frame[b][0] = this.frame[b][0] + 10; }  }
              }
           else { this.out[b] = this.out[b] + 1; if (this.out[b] == 30) this.frame[b][0] = 7;
              }
         
         }
       } 
       if (b3 == 10)
       
       { String str1 = "3|" + this.pgame + "|alive|";
         String str2 = "";
         if (!b2) try { this.dout.println(str1); str2 = this.din.readLine(); if (str2 == null) b2 = 1;  } catch (Exception exception) { b2 = 1; }
             if (b2 == 1) {
           
           try { this.socket.close(); this.socket = null; this.din.close(); this.din = null; this.dout.close(); this.dout = null; } catch (Exception exception) {}
           
           try {
             this.socket = new Socket(this.xtserver, this.xtservport);
             this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
             this.dout = new PrintWriter(this.socket.getOutputStream(), true);
             this.dout.println(str1);
             str2 = this.din.readLine();
             if (str2 != null) b2 = 0;
           
           } catch (Exception exception) {}
         } 
         if (b2 == 1) { try { this.socket.close(); this.socket = null; } catch (Exception exception) {} b2 = 2; }
          b3 = 0; }
       else { b3++; }
       
       try {
         Thread.sleep(1000L);
       } catch (InterruptedException interruptedException) {}
     } 
 
 
     
     byte b4 = 0;
     while (this.runon == 2) {
       
       byte b5 = 0; byte b6;
       for (b6 = 0; b6 < 20; ) { if (!(this.udpc[b6]).started) b5++;  b6++; }
        if (b5 != 20) b4++; 
       if (b4 == 'Ɛ' || b5 == 20) { for (b6 = 0; b6 < 20; ) { this.udpc[b6].closeSocket(); this.udpc[b6] = null; b6++; }  this.runon = 3; }
        try { Thread.sleep(5L); }
       catch (InterruptedException interruptedException) {}
     } 
     if (this.runon == 3) {
       
       System.gc();
       System.runFinalization();
       this.runon = 0;
       this.runner = null;
     } 
 
     
     if (this.runon == 5) {
       
       for (byte b = 0; b < this.nplayers + 2; ) { try { this.usrv[b].stopServe(); this.usrv[b] = null; } catch (Exception exception) {} b++; }
        String str = "3|" + this.pgame + "|finish|"; 
       try { this.dout.println(str); String str1 = this.din.readLine(); this.socket.close(); this.socket = null; this.din.close(); this.din = null; this.dout.close(); this.dout = null; } catch (Exception exception) {}
       System.gc();
       System.runFinalization();
       this.runon = 0;
       this.runner = null;
     } 
   }
 
 
 
 
 
 
 
 
 
 
 
 
   
   public void readinfo(Mad paramMad, ContO paramContO, Control paramControl, int paramInt, int[] paramArrayOfint) {
     if (this.go && this.force[paramInt] != 7 && !this.isbot[paramInt]) {
       
       this.freg = (float)(this.freg + 0.05D);
       byte b = -1;
       if (b == -1) for (byte b1 = 0; b1 < 3; ) { if (this.frame[paramInt][b1] == this.lframe[paramInt] + 1) { b = b1; if (b1 == 1) this.freg = (float)(this.freg - 0.1D);  if (b1 == 2) this.freg = (float)(this.freg - 0.15D);  }  b1++; }
           if (b == -1) { byte b1; byte b2; for (b1 = 0, b2 = 0; b2 < 3; ) { if (this.frame[paramInt][b2] > this.lframe[paramInt] + 1) b1++;  b2++; }  if (b1 == 3) b = 2;  }
        if (b == -1 && this.force[paramInt] == 1) { for (byte b1 = 0; b1 < 3; ) { if (this.frame[paramInt][b1] >= this.lframe[paramInt]) b = b1;  b1++; }  if (b == -1) this.freg = (float)(this.freg + 0.2D);  }
        if (this.freg < -15.0F) this.freg = -15.0F; 
       if (this.freg > 0.0F) this.freg = 0.0F;
 
 
 
 
 
 
 
 
       
       if (b != -1)
       
       { this.force[paramInt] = 0;
         String str1 = this.info[paramInt][b];
         
         String str2 = getSvalue(str1, 0);
         if (str2.length() == 16)
         
         { String str = "";
           str = "" + str2.charAt(0); if (str.equals("0")) { paramControl.left = false; } else { paramControl.left = true; }
            str = "" + str2.charAt(1); if (str.equals("0")) { paramControl.right = false; } else { paramControl.right = true; }
            str = "" + str2.charAt(2); if (str.equals("0")) { paramControl.up = false; } else { paramControl.up = true; }
            str = "" + str2.charAt(3); if (str.equals("0")) { paramControl.down = false; } else { paramControl.down = true; }
            str = "" + str2.charAt(4); if (str.equals("0")) { paramControl.handb = false; } else { paramControl.handb = true; }
            str = "" + str2.charAt(5); if (str.equals("0")) { paramMad.newcar = false; } else { paramMad.newcar = true; }
            str = "" + str2.charAt(6); if (str.equals("0")) { paramMad.mtouch = false; } else { paramMad.mtouch = true; }
            str = "" + str2.charAt(7); if (str.equals("0")) { paramMad.wtouch = false; } else { paramMad.wtouch = true; }
            str = "" + str2.charAt(8); if (str.equals("0")) { paramMad.pushed = false; } else { paramMad.pushed = true; }
            str = "" + str2.charAt(9); if (str.equals("0")) { paramMad.gtouch = false; } else { paramMad.gtouch = true; }
            str = "" + str2.charAt(10); if (str.equals("0")) { paramMad.pl = false; } else { paramMad.pl = true; }
            str = "" + str2.charAt(11); if (str.equals("0")) { paramMad.pr = false; } else { paramMad.pr = true; }
            str = "" + str2.charAt(12); if (str.equals("0")) { paramMad.pd = false; } else { paramMad.pd = true; }
            str = "" + str2.charAt(13); if (str.equals("0")) { paramMad.pu = false; } else { paramMad.pu = true; }
            str = "" + str2.charAt(14); if (str.equals("0")) { paramMad.dest = false; } else { paramMad.dest = true; }
           
            }
         
         else if (str2.equals("disco")) { paramArrayOfint[paramInt] = 3; paramMad.hitmag = paramMad.cd.maxmag[paramMad.cn] + 100; this.force[paramInt] = 7; }
 
         
         if (this.force[paramInt] != 7) {
           
           int i = getncoms(str1);
           this.wx = 0;
           if (i > 1) paramContO.x = getvalue(str1, 1); 
           if (i > 2) paramContO.y = getvalue(str1, 0); 
           if (i > 3) paramContO.z = getvalue(str1, 0); 
           if (i > 4) paramContO.xz = getvalue(str1, 0); 
           if (i > 5) paramContO.xy = getvalue(str1, 0); 
           if (i > 6) paramContO.zy = getvalue(str1, 0); 
           if (i > 7) paramMad.speed = getvalue(str1, 0) / 100.0F; 
           if (i > 8) paramMad.power = getvalue(str1, 0) / 100.0F; 
           if (i > 9) paramMad.mxz = getvalue(str1, 0); 
           if (i > 10) paramMad.pzy = getvalue(str1, 0); 
           if (i > 11) paramMad.pxy = getvalue(str1, 0); 
           if (i > 12) paramMad.txz = getvalue(str1, 0); 
           if (i > 13) paramMad.loop = getvalue(str1, 0); 
           if (i > 14) paramContO.wxz = getvalue(str1, 0); 
           if (i > 15) paramMad.pcleared = getvalue(str1, 0); 
           if (i > 16) paramMad.clear = getvalue(str1, 0); 
           if (i > 17) paramMad.nlaps = getvalue(str1, 0); 
           if (i > 18) paramMad.hitmag = (int)(getvalue(str1, 0) / 100.0F * paramMad.cd.maxmag[paramMad.cn]);
         
         } 
         this.lframe[paramInt] = this.frame[paramInt][b];
         
          }
       
       else if (this.force[paramInt] == 0) { this.lframe[paramInt] = this.lframe[paramInt] + 1; this.force[paramInt] = 1; }
     
     } 
   }
 
 
   
   public void readContOinfo(ContO paramContO, int paramInt) {
     if (this.go && this.force[paramInt] == 1 && !this.isbot[paramInt]) {
       
       byte b = -2;
       if (b == -2) for (byte b1 = 0; b1 < 3; ) { if (this.frame[paramInt][b1] == this.lframe[paramInt] + 1) b = -1;  b1++; }
           if (b == -1) for (byte b1 = 0; b1 < 3; ) { if (this.frame[paramInt][b1] == this.lframe[paramInt]) b = b1;  b1++; }
          
       if (b > 0) {
         
         String str = this.info[paramInt][b];
         int i = getncoms(str);
         this.wx = 0;
         if (i > 1) paramContO.x = getvalue(str, 1); 
         if (i > 1) paramContO.y = getvalue(str, 0); 
         if (i > 1) paramContO.z = getvalue(str, 0); 
         if (i > 1) paramContO.xz = getvalue(str, 0); 
         if (i > 1) paramContO.xy = getvalue(str, 0); 
         if (i > 1) paramContO.zy = getvalue(str, 0);
       
       } 
     } 
   }
 
 
   
   public void setinfo(Mad paramMad, ContO paramContO, Control paramControl, int paramInt1, float paramFloat, boolean paramBoolean, int paramInt2) {
     this.info[paramInt2][0] = "";
     if (paramControl.left) { this.info[paramInt2][0] = this.info[paramInt2][0] + "1"; } else { this.info[paramInt2][0] = this.info[paramInt2][0] + "0"; }
      if (paramControl.right) { this.info[paramInt2][0] = this.info[paramInt2][0] + "1"; } else { this.info[paramInt2][0] = this.info[paramInt2][0] + "0"; }
      if (paramControl.up) { this.info[paramInt2][0] = this.info[paramInt2][0] + "1"; } else { this.info[paramInt2][0] = this.info[paramInt2][0] + "0"; }
      if (paramControl.down) { this.info[paramInt2][0] = this.info[paramInt2][0] + "1"; } else { this.info[paramInt2][0] = this.info[paramInt2][0] + "0"; }
      if (paramControl.handb) { this.info[paramInt2][0] = this.info[paramInt2][0] + "1"; } else { this.info[paramInt2][0] = this.info[paramInt2][0] + "0"; }
      if (paramMad.newcar) { this.info[paramInt2][0] = this.info[paramInt2][0] + "1"; } else { this.info[paramInt2][0] = this.info[paramInt2][0] + "0"; }
      if (paramMad.mtouch) { this.info[paramInt2][0] = this.info[paramInt2][0] + "1"; } else { this.info[paramInt2][0] = this.info[paramInt2][0] + "0"; }
      if (paramMad.wtouch) { this.info[paramInt2][0] = this.info[paramInt2][0] + "1"; } else { this.info[paramInt2][0] = this.info[paramInt2][0] + "0"; }
      if (paramMad.pushed) { this.info[paramInt2][0] = this.info[paramInt2][0] + "1"; } else { this.info[paramInt2][0] = this.info[paramInt2][0] + "0"; }
      if (paramMad.gtouch) { this.info[paramInt2][0] = this.info[paramInt2][0] + "1"; } else { this.info[paramInt2][0] = this.info[paramInt2][0] + "0"; }
      if (paramMad.pl) { this.info[paramInt2][0] = this.info[paramInt2][0] + "1"; } else { this.info[paramInt2][0] = this.info[paramInt2][0] + "0"; }
      if (paramMad.pr) { this.info[paramInt2][0] = this.info[paramInt2][0] + "1"; } else { this.info[paramInt2][0] = this.info[paramInt2][0] + "0"; }
      if (paramMad.pd) { this.info[paramInt2][0] = this.info[paramInt2][0] + "1"; } else { this.info[paramInt2][0] = this.info[paramInt2][0] + "0"; }
      if (paramMad.pu) { this.info[paramInt2][0] = this.info[paramInt2][0] + "1"; } else { this.info[paramInt2][0] = this.info[paramInt2][0] + "0"; }
      if (paramMad.dest) { this.info[paramInt2][0] = this.info[paramInt2][0] + "1"; } else { this.info[paramInt2][0] = this.info[paramInt2][0] + "0"; }
      if (paramBoolean) { this.info[paramInt2][0] = this.info[paramInt2][0] + "1"; } else { this.info[paramInt2][0] = this.info[paramInt2][0] + "0"; }
     
     this.info[paramInt2][0] = this.info[paramInt2][0] + "," + paramContO.x + "," + paramContO.y + "," + paramContO.z + "," + paramContO.xz + "," + paramContO.xy + "," + paramContO.zy + "," + (int)(paramMad.speed * 100.0F) + "," + (int)(paramMad.power * 100.0F) + "," + paramMad.mxz + "," + paramMad.pzy + "," + paramMad.pxy + "," + paramMad.txz + "," + paramMad.loop + "," + paramContO.wxz + "," + paramMad.pcleared + "," + paramMad.clear + "," + paramMad.nlaps + "," + (int)(paramFloat * 100.0F) + "," + paramInt1 + ",";
     
     for (; this.info[paramInt2][0].length() < 110; this.info[paramInt2][0] = this.info[paramInt2][0] + "|");
     
     if (this.runon == 2) paramMad.hitmag = paramMad.cd.maxmag[paramMad.cn] + 100;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
     
     this.frame[paramInt2][0] = this.frame[paramInt2][0] + 1;
   }
 
   
   public UDPMistro() {
     this.wx = 0;
   }
   
   public int getvalue(String paramString, int paramInt) {
     int i = -1;
     
     try {
       byte b1 = 0, b2 = 0;
       String str1 = "", str2 = "";
       
       while (this.wx < paramString.length() && b2 != 2) {
         
         str1 = "" + paramString.charAt(this.wx);
         if (str1.equals(",")) { if (b2 == 1 || ++b1 > paramInt) b2 = 2;  } else if (b1 == paramInt) { str2 = str2 + str1; b2 = 1; }
          this.wx++;
       } 
       
       if (str2.equals("")) str2 = "-1"; 
       i = Integer.valueOf(str2).intValue();
     }
     catch (Exception exception) {}
     return i;
   }
 
 
   
   public String getSvalue(String paramString, int paramInt) {
     String str = "";
     
     try {
       byte b1 = 0, b2 = 0, b3 = 0;
       String str1 = "", str2 = "";
       
       while (b1 < paramString.length() && b3 != 2) {
         
         str1 = "" + paramString.charAt(b1);
         if (str1.equals(",")) { if (b3 == 1 || ++b2 > paramInt) b3 = 2;  } else if (b2 == paramInt) { str2 = str2 + str1; b3 = 1; }
          b1++;
       } 
       
       str = str2;
     }
     catch (Exception exception) {}
     return str;
   }
 
 
   
   public int getncoms(String paramString) {
     byte b1 = 0, b2 = 0;
     String str = "";
     while (b2 < paramString.length()) { str = "" + paramString.charAt(b2); if (str.equals(",")) b1++;  b2++; }
      return b1;
   }
 }


