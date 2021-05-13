 import java.net.DatagramPacket;
 import java.net.DatagramSocket;
 import java.net.InetAddress;
 
 
 
 public class udpServe
   implements Runnable
 {
   Thread servo;
   DatagramSocket dSocket;
   UDPMistro um;
   int mport = 7060;
   int im = 0;
   int[] lsframe = new int[] { -1, -1, -1, -1, -1, -1, -1, -1 };
 
   
   public udpServe(UDPMistro paramUDPMistro, int paramInt) {
     this.um = paramUDPMistro;
     this.im = paramInt;
     this.mport = 7060 + this.im;
     this.servo = new Thread(this);
     this.servo.start();
   }
   
   public void stopServe() {
     
     try { this.dSocket.close(); this.dSocket = null; } catch (Exception exception) {}
     if (this.servo != null) { this.servo.stop(); this.servo = null; }
   
   }
 
   
   public void run() {
     try {
       this.dSocket = new DatagramSocket(this.mport);
       byte[] arrayOfByte = new byte[128];
 
       
       while (true) {
         DatagramPacket datagramPacket = new DatagramPacket(arrayOfByte, arrayOfByte.length);
         
         this.dSocket.receive(datagramPacket);
         String str1 = new String(datagramPacket.getData());
         
         String str2 = getSvalue(str1, 0);
         int i = getvalue(str1, 1);
         if (i == this.im && this.im < this.um.nplayers)
         {
           if (this.um.out[i] != 76) {
             
             int k = getvalue(str1, 2); byte b1, b2;
             for (b1 = 0, b2 = 0; b2 < 3; ) { if (k != this.um.frame[i][b2]) b1++;  b2++; }
              if (b1 == 3) for (b2 = 0; b2 < 3; ) { if (k > this.um.frame[i][b2]) { for (byte b3 = 2; b3 >= b2 + 1; ) { this.um.frame[i][b3] = this.um.frame[i][b3 - 1]; this.um.info[i][b3] = this.um.info[i][b3 - 1]; b3--; }  this.um.frame[i][b2] = k; this.um.info[i][b2] = getSvalue(str1, 3); b2 = 3; }  b2++; }
                 if (this.um.gocnt[i] != 0) { byte b3; for (b2 = 0, b3 = 0; b3 < this.um.nplayers; ) { if (this.um.frame[b3][0] >= 0) b2++;  b3++; }  if (b2 == this.um.nplayers) { str2 = "1111111"; this.um.gocnt[i] = this.um.gocnt[i] - 1; }  }
              if (!this.um.go) { byte b3; for (b2 = 0, b3 = 0; b3 < this.um.nplayers; ) { if (this.um.frame[b3][0] >= 0) b2++;  b3++; }  if (b2 == this.um.nplayers) this.um.gocnt[0] = this.um.gocnt[0] - 1;  if (this.um.gocnt[0] <= 1) this.um.go = true;  }
           
           } 
         }
         InetAddress inetAddress = datagramPacket.getAddress();
         int j = datagramPacket.getPort();
         
         for (byte b = 0; b < this.um.nplayers; b++) {
           
           if (b != this.im)
           {
             byte b1 = -1; byte b2;
             for (b2 = 0; b2 < 3; ) { if (this.um.frame[b][b2] == this.lsframe[b] + 1) b1 = b2;  b2++; }
              if (b1 == -1) for (b2 = 0; b2 < 3; ) { if (this.um.frame[b][b2] > this.lsframe[b]) b1 = b2;  b2++; }
                 if (b1 == -1) b1 = 0; 
             this.lsframe[b] = this.um.frame[b][b1];
             
             String str = "" + str2 + "|" + b + "|" + this.um.frame[b][b1] + "|" + this.um.info[b][b1] + "|";
             byte[] arrayOfByte1 = str.getBytes();
             DatagramPacket datagramPacket1 = new DatagramPacket(arrayOfByte1, arrayOfByte1.length, inetAddress, j);
             this.dSocket.send(datagramPacket1);
           }
         
         } 
       } 
     } catch (Exception exception) {
       return;
     } 
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


