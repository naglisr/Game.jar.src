 import java.net.DatagramPacket;
 import java.net.DatagramSocket;
 import java.net.InetAddress;
 import java.util.Date;
 
 public class udpOnline
   implements Runnable
 {
   Thread con;
   UDPMistro um;
   int gameport = 7001;
   
   InetAddress IPAddress;
   DatagramSocket dSocket;
   long sendat = 0L;
   
   boolean started = false;
   boolean errd = false;
   int nu = 0;
 
   
   public udpOnline(UDPMistro paramUDPMistro, String paramString, int paramInt1, int paramInt2, int paramInt3) {
     this.um = paramUDPMistro;
     this.gameport = paramInt1;
     this.nu = paramInt2;
     
     try {
       this.dSocket = new DatagramSocket(7010 + paramInt3 + this.nu); this.errd = false;
       this.IPAddress = InetAddress.getByName(paramString);
     } catch (Exception exception) {
       System.out.println("Error preparing for UDP Connection: " + exception);
     } 
   }
   
   public void spark() {
     if (this.errd) try { this.dSocket = new DatagramSocket(7020 + this.nu); this.errd = false; } catch (Exception exception) {}  
     try { this.con = new Thread(this); this.con.start(); } catch (Exception exception) {}
   }
   
   public void closeSocket() {
     
     try { this.dSocket.close(); } catch (Exception exception) {} this.dSocket = null; this.errd = true;
     if (this.con != null) { this.con.stop(); this.con = null; }
      this.started = false;
   }
 
   
   public void stomp() {
     if (this.con != null) { this.con.stop(); this.con = null; }
      this.started = false;
   }
 
 
 
   
   public void run() {
     this.started = true;
     Date date = new Date(); this.sendat = date.getTime();
     String str = "";
     if (!this.um.go) str = "MAGNITUDE"; 
     if (this.nu == 0 && this.um.diledelay == 0) { this.um.sendat = this.sendat; str = "" + this.sendat; this.um.sendcheck = str = str.substring(str.length() - 3, str.length()); this.um.diledelay = 100; }
 
 
     
     try { byte[] arrayOfByte1 = new byte[4];
       DatagramPacket datagramPacket = new DatagramPacket(arrayOfByte1, arrayOfByte1.length, this.IPAddress, this.gameport);
       
       String str1 = "" + str + "|" + this.um.im + "|" + this.um.frame[this.um.im][0] + "|" + this.um.info[this.um.im][0] + "|";
       byte[] arrayOfByte2 = str1.getBytes();
       datagramPacket.setData(arrayOfByte2);
       this.dSocket.send(datagramPacket);
       byte b;
       for (b = 0; b < this.um.nplayers - 1; b++) {
         
         this.dSocket.receive(datagramPacket);
         String str2 = new String(datagramPacket.getData());
         if ((this.nu == 0 || !this.um.go) && b == 0) { str = getSvalue(str2, 0); if (!this.um.go && str.equals("1111111")) this.um.go = true;  }
          int i = getvalue(str2, 1);
         if (i >= 0 && i < this.um.nplayers) {
           
           int j = getvalue(str2, 2); byte b1, b2;
           for (b1 = 0, b2 = 0; b2 < 3; ) { if (j != this.um.frame[i][b2]) b1++;  b2++; }
            if (b1 == 3) for (b2 = 0; b2 < 3; ) { if (j > this.um.frame[i][b2]) { for (byte b3 = 2; b3 >= b2 + 1; ) { this.um.frame[i][b3] = this.um.frame[i][b3 - 1]; this.um.info[i][b3] = this.um.info[i][b3 - 1]; b3--; }  this.um.frame[i][b2] = j; this.um.info[i][b2] = getSvalue(str2, 3); b2 = 3; }  b2++; }
              
         } 
       } 
       if (this.nu == 0 && this.um.diledelay != 0 && this.um.sendcheck.equals(str)) { for (date = new Date(), b = 4; b > 0; ) { this.um.ldelays[b] = this.um.ldelays[b - 1]; b--; }  for (this.um.ldelays[0] = (int)(date.getTime() - this.um.sendat), this.um.delay = 0, b = 0; b < 5; ) { if (this.um.ldelays[b] != 0 && (this.um.delay == 0 || this.um.ldelays[b] < this.um.delay)) this.um.delay = this.um.ldelays[b];  b++; }  this.um.diledelay = 0; if (this.um.diled != 10) this.um.diled++;  }
        }
     catch (Exception exception) { 
       try { this.dSocket.close(); } catch (Exception exception1) {} this.dSocket = null; this.errd = true; }
     
     this.started = false;
     this.con = null;
   }
 
 
   
   public int getvalue(String paramString, int paramInt) {
     int i = -1;
     
     try {
       byte b1 = 0, b2 = 0, b3 = 0;
       String str1 = "", str2 = "";
       
       while (b1 < paramString.length() && b3 != 2) {
         
         str1 = "" + paramString.charAt(b1);
         if (str1.equals("|")) { if (b3 == 1 || ++b2 > paramInt) b3 = 2;  } else if (b2 == paramInt) { str2 = str2 + str1; b3 = 1; }
          b1++;
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
         if (str1.equals("|")) { if (b3 == 1 || ++b2 > paramInt) b3 = 2;  } else if (b2 == paramInt) { str2 = str2 + str1; b3 = 1; }
          b1++;
       } 
       
       str = str2;
     }
     catch (Exception exception) {}
     return str;
   }
 }


