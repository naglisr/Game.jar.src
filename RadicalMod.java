 import ds.nfm.Module;
 import ds.nfm.ModuleLoader;
 import ds.nfm.ModuleSlayer;
 
 public class RadicalMod {
   SuperClip sClip;
   int loaded = 0; boolean playing = false;
   int rvol = 0;
 
   
   String imod = "";
   String pmod = "";
   
   public RadicalMod() {
     this.loaded = 0;
     System.gc();
   }
 
   
   public RadicalMod(String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) {
     char c = '嗰';
     paramInt2 = (int)(paramInt2 / 8000.0F * 2.0F * c);
     paramInt1 = (int)(paramInt1 * 0.8F);
     try {
       Module module = null;
       if (!paramBoolean2) {
 
         
         module = ModuleLoader.loadMod("" + Madness.fpath + "" + paramString + "");
       } else {
         paramString = paramString.replace(' ', '_');
         URL uRL = new URL("http://multiplayer.needformadness.com/tracks/music/" + paramString + ".zip");
         module = ModuleLoader.loadMod(uRL);
       } 
       if (module.isLoaded()) {
         ModuleSlayer moduleSlayer = ModuleLoader.prepareSlayer(module, paramInt2, paramInt1, paramInt3);
         
         byte[] arrayOfByte = moduleSlayer.turnbytesNorm(paramBoolean1);
         if (paramBoolean1) {
           this.rvol = moduleSlayer.olav;
         }
         this.sClip = new SuperClip(arrayOfByte, moduleSlayer.oln, c);
         this.sClip.rollBackPos = moduleSlayer.rollBackPos;
         this.sClip.rollBackTrig = moduleSlayer.oln - moduleSlayer.rollBackTrig;
         arrayOfByte = null;
         module = null;
         moduleSlayer = null;
         this.loaded = 2;
       } 
     } catch (Exception exception) {
       System.out.println("Error downloading and making Mod: " + exception.toString());
       this.loaded = 0;
     } 
     System.runFinalization();
     System.gc();
   }
   
   public RadicalMod(String paramString) {
     this.loaded = 1;
 
     
     this.imod = "" + Madness.fpath + "" + paramString + "";
   }
   
   public void loadimod(boolean paramBoolean) {
     if (this.loaded == 1) {
       char c = 'ꯠ';
       char c1 = ' ';
       if (paramBoolean) {
         c1 = 'Ĭ';
       }
       byte b = 125;
       try {
         Module module = ModuleLoader.loadMod(this.imod);
         if (module.isLoaded()) {
           ModuleSlayer moduleSlayer = ModuleLoader.prepareSlayer(module, c, c1, b);
           
           byte[] arrayOfByte = moduleSlayer.turnbytesNorm(paramBoolean);
           if (paramBoolean) {
             this.rvol = moduleSlayer.olav;
           }
           this.sClip = new SuperClip(arrayOfByte, moduleSlayer.oln, 22000);
           this.sClip.rollBackPos = moduleSlayer.rollBackPos;
           this.sClip.rollBackTrig = moduleSlayer.oln - moduleSlayer.rollBackTrig;
           arrayOfByte = null;
           module = null;
           moduleSlayer = null;
           this.loaded = 2;
         } 
       } catch (Exception exception) {
         System.out.println("Error making a imod: " + exception.toString());
         this.loaded = 0;
       } 
       System.runFinalization();
       System.gc();
     } 
   }
   
   public void loadpmod(boolean paramBoolean) {
     if (this.loaded == 1) {
       char c = 'ꯠ';
       char c1 = ' ';
       if (paramBoolean) {
         c1 = 'Ĭ';
       }
       byte b = 125;
       try {
         Module module = ModuleLoader.loadMod(this.pmod);
         if (module.isLoaded()) {
           ModuleSlayer moduleSlayer = ModuleLoader.prepareSlayer(module, c, c1, b);
           
           byte[] arrayOfByte = moduleSlayer.turnbytesNorm(paramBoolean);
           if (paramBoolean) {
             this.rvol = moduleSlayer.olav;
           }
           this.sClip = new SuperClip(arrayOfByte, moduleSlayer.oln, 22000);
           this.sClip.rollBackPos = moduleSlayer.rollBackPos;
           this.sClip.rollBackTrig = moduleSlayer.oln - moduleSlayer.rollBackTrig;
           arrayOfByte = null;
           module = null;
           moduleSlayer = null;
           this.loaded = 2;
         } 
       } catch (Exception exception) {
         System.out.println("Error making a imod: " + exception.toString());
         this.loaded = 0;
       } 
       System.runFinalization();
       System.gc();
     } 
   }
   
   public RadicalMod(String paramString, boolean paramBoolean) {
     this.loaded = 1;
     this.pmod = paramString;
     loadpmod(true);
   }
   
   public void play() {
     if (!this.playing && this.loaded == 2) {
       this.sClip.play();
       if (this.sClip.stoped == 0) {
         this.playing = true;
       }
     } 
   }
   
   public void resume() {
     if (!this.playing && this.loaded == 2) {
       this.sClip.resume();
       if (this.sClip.stoped == 0) {
         this.playing = true;
       }
     } 
   }
   
   public void stop() {
     if (this.playing && this.loaded == 2) {
       this.sClip.stop();
       this.playing = false;
     } 
   }
   
   protected void unloadimod() {
     if (this.loaded == 2) {
       if (this.playing) {
         this.sClip.stop();
         this.playing = false;
       } 
       try {
         this.sClip.close();
         this.sClip = null;
       } catch (Exception exception) {}
       
       System.gc();
       this.loaded = 1;
     } 
   }
   
   protected void unload() {
     if (this.playing && this.loaded == 2) {
       this.sClip.stop();
       this.playing = false;
     } 
     try {
       this.sClip.close();
       this.sClip = null;
     } catch (Exception exception) {}
     
     try {
       this.imod = null;
     } catch (Exception exception) {}
     
     System.gc();
     this.loaded = 0;
   }
 }


