 package ds.nfm;
 
 import ds.nfm.mod.Mod;
 import ds.nfm.mod.ModSlayer;
 import ds.nfm.xm.IBXMod;
 import ds.nfm.xm.IBXModSlayer;
 import java.io.ByteArrayInputStream;
 import java.io.ByteArrayOutputStream;
 import java.io.DataInputStream;
 import java.io.File;
 import java.io.FileInputStream;
 import java.io.FileNotFoundException;
 import java.io.IOException;
 import java.net.URL;
 import java.util.zip.ZipEntry;
 import java.util.zip.ZipInputStream;
 
 
 
 
 
 
 
 public class ModuleLoader
 {
   public static Module loadMod(String paramString) throws FileNotFoundException, IOException {
     ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(new File(paramString)));
     return loadMod(zipInputStream);
   }
 
 
 
 
 
 
   
   public static Module loadMod(URL paramURL) throws IOException {
     ZipInputStream zipInputStream = new ZipInputStream(new DataInputStream(paramURL.openStream()));
     return loadMod(zipInputStream);
   }
 
 
 
 
 
 
   
   public static Module loadMod(byte[] paramArrayOfbyte) throws IOException {
     ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(paramArrayOfbyte));
     return loadMod(zipInputStream);
   }
 
 
 
 
   
   public static Module loadMod(ZipInputStream paramZipInputStream) throws IOException {
     Mod mod;
     byte[] arrayOfByte;
     IBXMod iBXMod = null;
     ZipEntry zipEntry = paramZipInputStream.getNextEntry();
     String str = zipEntry.getName();
     int i = (int)zipEntry.getSize();
     
     if (i == -1) {
       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
       int j;
       while ((j = paramZipInputStream.read()) != -1) {
         byteArrayOutputStream.write(j);
       }
       arrayOfByte = byteArrayOutputStream.toByteArray();
     } else {
       arrayOfByte = new byte[i];
       int j = 0;
       
       for (; i > 0; i -= k) {
         int k = paramZipInputStream.read(arrayOfByte, j, i);
         j += k;
       } 
     } 
     paramZipInputStream.close();
     
     if (str.toLowerCase().endsWith(".xm") || str.toLowerCase().endsWith(".s3m")) { iBXMod = new IBXMod(arrayOfByte); } else { mod = new Mod(arrayOfByte); }
      return (Module)mod;
   }
 
 
 
 
 
 
 
 
 
 
 
   
   public static ModuleSlayer prepareSlayer(Module paramModule, int paramInt1, int paramInt2, int paramInt3) {
     if (paramModule instanceof Mod)
       return (ModuleSlayer)new ModSlayer((Mod)paramModule, paramInt1, paramInt2, paramInt3); 
     if (paramModule instanceof IBXMod) {
       return (ModuleSlayer)new IBXModSlayer((IBXMod)paramModule, paramInt1, paramInt2, paramInt3);
     }
     throw new ModuleException("Unsuported module format: " + paramModule.getName());
   }
 }


