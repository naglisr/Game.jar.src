 package ds.nfm.xm;
 
 import ds.nfm.Module;
 //import ibxm.Module;
 import java.io.ByteArrayInputStream;
 import java.io.IOException;
 import java.io.InputStream;
 
 
 public class IBXMod extends Module
 {
   //originally ds.nfm.Module
   ibxm.Module refMod;
   
   public IBXMod(byte[] modf) {
     try {
       loadMod(new ByteArrayInputStream(modf));
       this.loaded = true;
     } catch (Exception e) {
       this.loaded = false;
     } 
   }
 
   
   public void loadMod(InputStream inputstream) throws IOException {
     this.refMod = new ibxm.Module(inputstream);
   }
 }


