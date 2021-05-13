 import java.io.ByteArrayInputStream;
 import javax.sound.sampled.AudioFormat;
 import javax.sound.sampled.AudioSystem;
 import javax.sound.sampled.DataLine;
 import javax.sound.sampled.SourceDataLine;
 
 
 
 
 
 
 public class SuperClip
   implements Runnable
 {
   int skiprate = 0;
   Thread cliper;
   int stoped = 1;
   SourceDataLine source = null;
   
   ByteArrayInputStream stream;
   
   int rollBackPos = 0;
   int rollBackTrig = 0;
   boolean changeGain = false;
   
   public SuperClip(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
     this.stoped = 2;
     this.skiprate = paramInt2;
     this.stream = new ByteArrayInputStream(paramArrayOfbyte, 0, paramInt1);
   }
 
   
   public void run() {
     try {
       AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, this.skiprate, 16, 1, 2, this.skiprate, false);
       DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
       this.source = (SourceDataLine)AudioSystem.getLine(info);
       this.source.open(audioFormat);
       this.source.start();
     } catch (Exception exception) {
       this.stoped = 1;
     } 
     boolean bool = false;
     while (this.stoped == 0) {
       try {
         int i = this.skiprate, j = this.stream.available();
         if (j % 2 != 0) j++; 
         byte[] arrayOfByte = new byte[(j > i) ? i : j];
         int k = this.stream.read(arrayOfByte, 0, arrayOfByte.length);
         if (k == -1 || (this.rollBackPos != 0 && j < this.rollBackTrig)) bool = true; 
         if (bool) {
           if (k != -1) this.source.write(arrayOfByte, 0, arrayOfByte.length); 
           this.stream.reset();
           if (this.rollBackPos != 0) this.stream.skip(this.rollBackPos); 
           j = this.stream.available();
           if (j % 2 != 0) j++; 
           arrayOfByte = new byte[(j > i) ? i : j];
           this.stream.read(arrayOfByte, 0, arrayOfByte.length);
           bool = false;
         } 
         this.source.write(arrayOfByte, 0, arrayOfByte.length);
 
 
 
 
 
 
 
 
       
       }
       catch (Exception exception) {
         System.out.println("Play error: " + exception);
         this.stoped = 1;
       } 
       try {
         Thread.sleep(200L);
       } catch (InterruptedException interruptedException) {}
     } 
     
     this.source.stop();
     this.source.close();
     this.source = null;
     this.stoped = 2;
   }
   
   public void play() {
     if (this.stoped == 2) {
       this.stoped = 0;
       try {
         this.stream.reset();
       } catch (Exception exception) {}
       
       this.cliper = new Thread(this);
       this.cliper.start();
     } 
   }
   
   public void resume() {
     if (this.stoped == 2) {
       this.stoped = 0;
       this.cliper = new Thread(this);
       this.cliper.start();
     } 
   }
   
   public void stop() {
     if (this.stoped == 0) {
       this.stoped = 1;
       if (this.source != null) {
         this.source.stop();
       }
     } 
   }
   
   public void close() {
     try {
       this.stream.close();
       this.stream = null;
     } catch (Exception exception) {}
   }
 }


