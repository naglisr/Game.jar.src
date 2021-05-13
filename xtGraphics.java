import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class xtGraphics
        extends Panel
        implements Runnable {
    Graphics2D rd;
    Medium m;
    CarDefine cd;
    FontMetrics ftm;
    ImageObserver ob;
    GameSparker app;
    int fase = 111;
    int oldfase = 0;
    int starcnt = 0;
    boolean mtop = false;
    int opselect = 0;
    int dropf = 0;
    int cfase = 0;
    boolean firstime = true;
    boolean shaded = false;
    int flipo = 0;
    int nextc = 0;

    int multion = 0;


    int gmode = 0;


    int[] unlocked = new int[]{1, 1};
    int[] scm = new int[]{0, 0};

    int looped = 1;
    int warning = 0;

    boolean newparts = false;
    boolean logged = false;
    boolean gotlog = false;
    boolean autolog = false;
    boolean nofull = false;
    int nfreeplays = 0, ndisco = 0;
    int hours = 8;
    boolean onviewpro = false;
    int playingame = -1;
    int onjoin = -1;
    int ontyp = 0;
    boolean lan = false;
    float[] arnp = new float[]{0.5F, 0.0F, 0.0F, 1.0F, 0.5F, 0.0F};
    String nickname = "", clan = "";
    String nickey = "", clankey = "", backlog = "";
    String server = "multiplayer.needformadness.com";
    String localserver = "";
    String servername = "Madness";
    int servport = 7071, gameport = 7001;
    int acexp = 0;
    int discon = 0;
    int cntptrys = 5;
    int[] delays = new int[]{600, 600, 600};

    int nplayers = 7;
    int im = 0;
    String[] plnames = new String[]{"", "", "", "", "", "", "", ""};
    int osc = 10;
    int minsl = 0;
    int maxsl = 15;
    int[] sc = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
    int[] xstart = new int[]{0, -350, 350, 0, -350, 350, 0, 0};
    int[] zstart = new int[]{-760, -380, -380, 0, 380, 380, 760, 0};
    float[][] allrnp = new float[8][6];
    boolean[] isbot = new boolean[8];

    int clangame = 0;
    boolean clanchat = false;
    String[] pclan = new String[]{"", "", "", "", "", "", "", ""};
    String gaclan = "";
    int lcarx = 0;
    int lcary = 0;
    int lcarz = 0;
    int[] dcrashes = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
    int beststunt = 0;
    int laptime = 0, fastestlap = 0;
    int sendstat = 0;

    int testdrive = 0;

    boolean holdit = false;
    int holdcnt = 0;
    boolean winner = true;
    int[] flexpix = null;
    int[] smokey = new int[94132];
    Image fleximg;
    int flatrstart = 0;

    Thread runner;
    int runtyp = 0;

    int forstart = 0;
    int exitm = 0;
    Image odmg;
    Image opwr;
    Image opos;
    Image osped;
    Image owas;
    Image olap;
    Image oyourwasted;
    Image odisco;
    Image ogamefinished;
    Image oyoulost;
    Image oyouwon;
    Image oyouwastedem;
    Image ogameh;
    Image owgame;
    Image oloadingmusic;
    Image oflaot;
    Image oexitgame;
    Image mload;
    Image dmg;
    Image pwr;
    Image pos;
    Image sped;
    Image was;
    Image lap;
    Image br;
    Image select;
    Image loadingmusic;
    Image yourwasted;
    Image disco;
    Image gamefinished;
    Image youlost;
    Image youwon;
    Image youwastedem;
    Image gameh;
    Image wgame;
    Image congrd;
    Image gameov;
    Image carsbg;
    Image carsbgc;
    Image selectcar;
    Image statb;
    Image statbo;
    Image mdness;
    Image paused;
    Image radicalplay;
    Image logocars;
    Image logomadnes;
    Image logomadbg;
    Image byrd;
    Image bggo;
    Image opback;
    Image nfmcoms;
    Image opti;
    Image opti2;
    Image bgmain;
    Image rpro;
    Image nfmcom;
    Image flaot;
    Image brt;
    Image arn;
    Image exitgame;
    Image pgate;
    Image fixhoop;
    Image sarrow;
    Image stunts;
    Image racing;
    Image wasting;
    Image plus;
    Image space;
    Image arrows;
    Image chil;
    Image ory;
    Image kz;
    Image kx;
    Image kv;
    Image km;
    Image kn;
    Image ks;
    Image kenter;
    Image nfm;
    Image login;
    Image register;
    Image play;
    Image sdets;
    Image cancel;
    Image bob;
    Image bot;
    Image bol;
    Image bolp;
    Image bor;
    Image borp;
    Image logout;
    Image change;
    Image pln;
    Image pon;
    Image dome;
    Image upgrade;
    Image bols;
    Image bolps;
    Image bors;
    Image borps;
    Image games;
    Image exit;
    Image chat;
    Image players;
    Image cgame;
    Image ccar;
    Image lanm;
    Image asu;
    Image asd;
    Image pls;
    Image sts;
    Image gmc;
    Image stg;
    Image crd;
    Image roomp;
    Image myfr;
    Image mycl;
    Image cnmc;
    Image redy;
    Image ntrg;
    Image[] bcl = new Image[2];
    Image[] bcr = new Image[2];
    Image[] bc = new Image[2];
    Image cmc;
    Image myc;
    Image gac;
    Image yac;
    Image ycmc;
    Image top20s;
    Image[] trackbg = new Image[2];
    Image[] dude = new Image[3];
    int duds = 0;
    int dudo = 0;
    Image[] next = new Image[2];
    Image[] back = new Image[2];
    Image[] contin = new Image[2];
    Image[] ostar = new Image[2];
    Image[] star = new Image[3];
    int pcontin = 0;
    int pnext = 0;
    int pback = 0;
    int pstar = 0;

    Image[] orank = new Image[8];
    Image[] rank = new Image[8];
    Image[] ocntdn = new Image[4];
    Image[] cntdn = new Image[4];
    int gocnt = 0;

    soundClip[][] engs = new soundClip[5][5];
    boolean[] pengs = new boolean[5];
    soundClip[] air = new soundClip[6];
    boolean aird = false;
    boolean grrd = false;
    soundClip[] crash = new soundClip[3];
    soundClip[] lowcrash = new soundClip[3];
    soundClip tires;
    soundClip checkpoint;
    soundClip carfixed;
    soundClip powerup;
    soundClip three;
    soundClip two;
    soundClip one;
    soundClip go;
    soundClip wastd;
    soundClip firewasted;
    boolean pwastd = false;
    soundClip[] skid = new soundClip[3];
    soundClip[] dustskid = new soundClip[3];
    soundClip[] scrape = new soundClip[4];

    boolean mutes = false;

    RadicalMod intertrack;
    RadicalMod strack;
    boolean loadedt = false;
    boolean mutem = false;
    boolean badmac = false;
    boolean arrace = false;
    int alocked = -1;
    int lalocked = -1;
    int cntflock = 0;
    boolean onlock = false;
    int ana = 0;
    int cntan = 0;
    int cntovn = 0;

    boolean flk = false;
    int tcnt = 30;
    boolean tflk = false;
    String say = "";
    boolean wasay = false;
    int clear = 0;
    int posit = 0;
    int wasted = 0;
    int laps = 0;
    int[] dested = new int[]{0, 0, 0, 0, 0, 0, 0, 0};

    int dmcnt = 0;

    boolean dmflk = false;
    int pwcnt = 0;

    boolean pwflk = false;
    String[][] adj = new String[][]{{"Cool", "Alright", "Nice"}, {"Wicked", "Amazing", "Super"}, {"Awesome", "Ripping", "Radical"}, {"What the...?", "You're a super star!!!!", "Who are you again...?"}, {"surf style", "off the lip", "bounce back"}};
    String[] exlm = new String[]{"!", "!!", "!!!"};
    String loop = "";
    String spin = "";
    String asay = "";
    int auscnt = 45;

    boolean aflk = false;
    int[] sndsize = new int[]{39, 128, 23, 58, 106, 140, 81, 135, 38, 141, 106, 76, 56, 116, 92, 208, 70, 80, 152, 102, 27, 65, 52, 30, 151, 129, 80, 44, 57, 123, 202, 210, 111};
    Image hello;
    Image sign;
    Image loadbar;
    int kbload = 0;
    int dnload = 0;
    float shload = 0.0F;
    Socket socket;
    BufferedReader din;
    PrintWriter dout;
    int radpx;
    int pin;
    int[] trkx;
    int trkl;
    int trklim;
    int lmode;
    int[] bgmy;
    float bgf;
    boolean bgup;
    int[] ovx;
    int[] ovy;
    int[] ovw;
    int[] ovh;
    int[] ovsx;
    int removeds;
    int nfmtab;
    boolean justwon1;
    boolean justwon2;
    int lfrom;
    int lockcnt;
    boolean showtf;
    int ransay;
    String[][] cnames;
    String[][] sentn;
    int[] updatec;
    int[] movepos;
    int[] pointc;
    int[] floater;
    int[] cntchatp;
    int[] msgflk;
    String[] lcmsg;
    int flkat;
    int movly;
    int gxdu;
    int gydu;
    int muhi;
    int lsc;
    int mouson;
    int onmsc;
    boolean remi;
    int basefase;
    boolean noclass;
    int gatey;
    int[] pgatx;
    int[] pgaty;
    int[] pgady;
    boolean[] pgas;
    int waitlink;
    int lxm;
    int lym;
    int pwait;
    int stopcnt;
    int cntwis;
    int lcn;
    int crshturn;
    int bfcrash;
    int bfskid;
    boolean crashup;
    boolean skidup;
    int skflg;
    int dskflg;
    int bfscrape;
    int sturn0;
    int sturn1;
    int bfsc1;
    int bfsc2;
    int flatr;
    int flyr;
    int flyrdest;
    int flang;

    public void loaddata() {
        this.kbload = 637;
        this.runtyp = 176;
        this.runner = new Thread(this);
        this.runner.start();
        loadimages();
        this.intertrack = new RadicalMod("music/interface.zip");
        this.dnload += 44;
        loadsounds();
    }


    public void loadsounds() {
        this.dnload += 3;


        try {
            File file = new File("" + Madness.fpath + "data/sounds.zip");
            FileInputStream fileInputStream = new FileInputStream(file);

            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {

                int i = (int) zipEntry.getSize();
                String str = zipEntry.getName();
                byte[] arrayOfByte = new byte[i];
                int j = 0;
                while (i > 0) {
                    int k = zipInputStream.read(arrayOfByte, j, i);
                    j += k;
                    i -= k;
                }
                byte b;
                for (b = 0; b < 5; ) {
                    for (byte b1 = 0; b1 < 5; ) {
                        if (str.equals("" + b1 + "" + b + ".wav")) this.engs[b1][b] = new soundClip(arrayOfByte);
                        b1++;
                    }
                    b++;
                }
                for (b = 0; b < 6; ) {
                    if (str.equals("air" + b + ".wav")) this.air[b] = new soundClip(arrayOfByte);
                    b++;
                }
                for (b = 0; b < 3; ) {
                    if (str.equals("crash" + (b + 1) + ".wav")) this.crash[b] = new soundClip(arrayOfByte);
                    b++;
                }
                for (b = 0; b < 3; ) {
                    if (str.equals("lowcrash" + (b + 1) + ".wav")) this.lowcrash[b] = new soundClip(arrayOfByte);
                    b++;
                }
                for (b = 0; b < 3; ) {
                    if (str.equals("skid" + (b + 1) + ".wav")) this.skid[b] = new soundClip(arrayOfByte);
                    b++;
                }
                for (b = 0; b < 3; ) {
                    if (str.equals("dustskid" + (b + 1) + ".wav")) this.dustskid[b] = new soundClip(arrayOfByte);
                    b++;
                }
                for (b = 0; b < 3; ) {
                    if (str.equals("scrape" + (b + 1) + ".wav")) {
                        this.scrape[b] = new soundClip(arrayOfByte);
                        if (b == 2) this.scrape[3] = new soundClip(arrayOfByte);
                    }
                    b++;
                }
                if (str.equals("powerup.wav")) this.powerup = new soundClip(arrayOfByte);
                if (str.equals("tires.wav")) this.tires = new soundClip(arrayOfByte);
                if (str.equals("checkpoint.wav")) this.checkpoint = new soundClip(arrayOfByte);
                if (str.equals("carfixed.wav")) this.carfixed = new soundClip(arrayOfByte);
                if (str.equals("three.wav")) this.three = new soundClip(arrayOfByte);
                if (str.equals("two.wav")) this.two = new soundClip(arrayOfByte);
                if (str.equals("one.wav")) this.one = new soundClip(arrayOfByte);
                if (str.equals("go.wav")) this.go = new soundClip(arrayOfByte);
                if (str.equals("wasted.wav")) this.wastd = new soundClip(arrayOfByte);
                if (str.equals("firewasted.wav")) this.firewasted = new soundClip(arrayOfByte);
                this.dnload += 5;
                zipEntry = zipInputStream.getNextEntry();
            }

            fileInputStream.close();
            zipInputStream.close();
        } catch (Exception exception) {
            System.out.println("Error Loading Sounds: " + exception);
        }
        System.gc();
    }


    public void loadimages() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        MediaTracker mediaTracker = new MediaTracker(this.app);

        Image image1 = null, image2 = null;

        this.dnload += 8;


        try {
            File file = new File("" + Madness.fpath + "data/images.zip");
            FileInputStream fileInputStream = new FileInputStream(file);

            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {

                int i = (int) zipEntry.getSize();
                String str = zipEntry.getName();
                byte[] arrayOfByte = new byte[i];
                int j = 0;
                while (i > 0) {
                    int k = zipInputStream.read(arrayOfByte, j, i);
                    j += k;
                    i -= k;
                }

                if (str.equals("cars.gif")) this.carsbg = loadBimage(arrayOfByte, mediaTracker, toolkit, 1);
                if (str.equals("color.gif")) image1 = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("class.gif")) image2 = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("smokey.gif")) smokeypix(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("1.gif")) this.orank[0] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("gameh.gif")) this.ogameh = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("wgame.gif")) this.owgame = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("gameov.gif")) this.gameov = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("lap.gif")) this.olap = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("paused.gif")) this.paused = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("select.gif")) this.select = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("yourwasted.gif")) this.oyourwasted = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("disco.gif")) this.odisco = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("youwastedem.gif")) this.oyouwastedem = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("gamefinished.gif")) this.ogamefinished = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("exitgame.gif")) this.oexitgame = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("pgate.gif")) this.pgate = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("d1.png")) this.dude[0] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("d2.png")) this.dude[1] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("d3.png")) this.dude[2] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("float.gif")) this.oflaot = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("1c.gif")) this.ocntdn[1] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("2c.gif")) this.ocntdn[2] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("3c.gif")) this.ocntdn[3] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("2.gif")) this.orank[1] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("3.gif")) this.orank[2] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("4.gif")) this.orank[3] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("5.gif")) this.orank[4] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("6.gif")) this.orank[5] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("7.gif")) this.orank[6] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("8.gif")) this.orank[7] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("bgmain.jpg")) this.bgmain = loadBimage(arrayOfByte, mediaTracker, toolkit, 2);
                if (str.equals("br.png")) this.br = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("loadingmusic.gif")) this.oloadingmusic = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("radicalplay.gif")) this.radicalplay = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("back.gif")) {
                    this.back[0] = loadimage(arrayOfByte, mediaTracker, toolkit);
                    this.back[1] = bressed(this.back[0]);
                }
                if (str.equals("continue.gif")) {
                    this.contin[0] = loadimage(arrayOfByte, mediaTracker, toolkit);
                    this.contin[1] = bressed(this.contin[0]);
                }
                if (str.equals("next.gif")) {
                    this.next[0] = loadimage(arrayOfByte, mediaTracker, toolkit);
                    this.next[1] = bressed(this.next[0]);
                }
                if (str.equals("rpro.gif")) this.rpro = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("selectcar.gif")) this.selectcar = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("track.jpg")) {
                    this.trackbg[0] = loadBimage(arrayOfByte, mediaTracker, toolkit, 3);
                    this.trackbg[1] = dodgen(this.trackbg[0]);
                }
                if (str.equals("youlost.gif")) this.oyoulost = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("youwon.gif")) this.oyouwon = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("0c.gif")) this.ocntdn[0] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("damage.gif")) this.odmg = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("power.gif")) this.opwr = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("position.gif")) this.opos = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("speed.gif")) this.osped = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("wasted.gif")) this.owas = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("start1.gif")) this.ostar[0] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("start2.gif")) {
                    this.ostar[1] = loadimage(arrayOfByte, mediaTracker, toolkit);
                    this.star[2] = pressed(this.ostar[1]);
                }
                if (str.equals("congrad.gif")) this.congrd = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("statb.gif")) this.statb = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("statbo.gif")) this.statbo = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("madness.gif")) this.mdness = loadude(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("fixhoop.png")) this.fixhoop = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("arrow.gif")) this.sarrow = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("stunts.png")) this.stunts = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("racing.gif")) this.racing = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("wasting.gif")) this.wasting = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("plus.gif")) this.plus = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("space.gif")) this.space = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("arrows.gif")) this.arrows = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("chil.gif")) this.chil = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("ory.gif")) this.ory = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("kz.gif")) this.kz = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("kx.gif")) this.kx = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("kv.gif")) this.kv = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("km.gif")) this.km = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("kn.gif")) this.kn = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("ks.gif")) this.ks = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("kenter.gif")) this.kenter = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("nfm.gif")) this.nfm = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("options.png")) this.opti = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("options2.png")) this.opti2 = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("opback.png")) this.opback = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("logocars.png")) this.logocars = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("logomad.png")) this.logomadnes = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("logomadbg.jpg")) this.logomadbg = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("byrd.png")) this.byrd = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("bggo.jpg")) this.bggo = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("nfmcoms.png")) this.nfmcoms = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("nfmcom.gif")) this.nfmcom = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);

                if (str.equals("brit.gif")) this.brt = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("arn.gif")) this.arn = loadimage(arrayOfByte, mediaTracker, toolkit);


                if (str.equals("mload.gif")) this.mload = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("login.gif")) this.login = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("play.gif")) this.play = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("cancel.gif")) this.cancel = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("dome.gif")) this.dome = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("register.gif")) this.register = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("upgrade.gif")) this.upgrade = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("sdets.gif")) this.sdets = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("bob.gif")) this.bob = loadBimage(arrayOfByte, mediaTracker, toolkit, 1);
                if (str.equals("bot.gif")) this.bot = loadBimage(arrayOfByte, mediaTracker, toolkit, 1);
                if (str.equals("bol.gif")) this.bol = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("bolp.gif")) this.bolp = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("bor.gif")) this.bor = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("borp.gif")) this.borp = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);

                if (str.equals("logout.gif")) this.logout = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("change.gif")) this.change = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("pln.gif")) this.pln = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("pon.gif")) this.pon = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);

                if (str.equals("bols.gif")) this.bols = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("bolps.gif")) this.bolps = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("bors.gif")) this.bors = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("borps.gif")) this.borps = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("games.gif")) this.games = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("exit.gif")) this.exit = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("chat.gif")) this.chat = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("players.gif")) this.players = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("roomp.gif")) this.roomp = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("myfr.gif")) this.myfr = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("mycl.gif")) this.mycl = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("cnmc.gif")) this.cnmc = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("ready.gif")) this.redy = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("notreg.gif")) this.ntrg = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);

                if (str.equals("cgame.gif")) this.cgame = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("ccar.gif")) this.ccar = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("lanm.gif")) this.lanm = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("asu.gif")) this.asu = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("asd.gif")) this.asd = loadimage(arrayOfByte, mediaTracker, toolkit);

                if (str.equals("pls.gif")) this.pls = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("sts.gif")) this.sts = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("gmc.gif")) this.gmc = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("stg.gif")) this.stg = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);
                if (str.equals("crd.gif")) this.crd = loadBimage(arrayOfByte, mediaTracker, toolkit, 0);

                if (str.equals("bcl.gif")) this.bcl[0] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("bcr.gif")) this.bcr[0] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("bc.gif")) this.bc[0] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("pbcl.gif")) this.bcl[1] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("pbcr.gif")) this.bcr[1] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("pbc.gif")) this.bc[1] = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("cmc.gif")) this.cmc = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("myc.gif")) this.myc = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("gac.gif")) this.gac = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("yac.gif")) this.yac = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("ycmc.gif")) this.ycmc = loadimage(arrayOfByte, mediaTracker, toolkit);
                if (str.equals("top20s.gif")) this.top20s = loadimage(arrayOfByte, mediaTracker, toolkit);

                this.dnload += 2;
                zipEntry = zipInputStream.getNextEntry();
            }

            fileInputStream.close();
            zipInputStream.close();
        } catch (Exception exception) {
            System.out.println("Error Loading Images: " + exception);
        }

        makecarsbgc(image1, image2);

        System.gc();
    }


    public void run() {
        boolean bool = false;
        while (this.runtyp > 0) {

            if (this.runtyp >= 1 && this.runtyp <= 140) hipnoload(this.runtyp, false);
            if (this.runtyp == 176) {
                loading();
                bool = true;
            }
            this.app.repaint();
            try {
                Thread.sleep(20L);
            } catch (InterruptedException interruptedException) {
            }
        }
        if (bool) {
            pingstat();
            bool = false;
        }


        boolean[] arrayOfBoolean = {true, true};

        while ((this.runtyp == -101 || this.sendstat == 1) && !this.lan) {

            String str1 = "3|" + this.playingame + "|" + this.updatec[0] + "|";
            if (this.clanchat) {
                str1 = str1 + "" + this.updatec[1] + "|" + this.clan + "|" + this.clankey + "|";
            } else {
                str1 = str1 + "0|||";
            }
            if (this.updatec[0] <= -11) {
                for (byte b = 0; b < -this.updatec[0] - 10; ) {
                    str1 = str1 + "" + this.cnames[0][6 - b] + "|" + this.sentn[0][6 - b] + "|";
                    b++;
                }
                this.updatec[0] = -2;
            }
            if (this.clanchat && this.updatec[1] <= -11) {
                for (byte b = 0; b < -this.updatec[1] - 10; ) {
                    str1 = str1 + "" + this.cnames[1][6 - b] + "|" + this.sentn[1][6 - b] + "|";
                    b++;
                }
                this.updatec[1] = -2;
            }

            if (this.sendstat == 1) {
                byte b;
                for (str1 = "5|" + this.playingame + "|" + this.im + "|" + this.beststunt + "|" + this.fastestlap + "|", b = 0; b < this.nplayers; ) {
                    str1 = str1 + "" + this.dcrashes[b] + "|";
                    b++;
                }
                this.sendstat = 2;
            }

            boolean bool1 = false;
            String str2 = "";
            try {
                this.dout.println(str1);
                str2 = this.din.readLine();
                if (str2 == null) bool1 = true;
            } catch (Exception exception) {
                bool1 = true;
            }
            if (bool1) {

                try {
                    this.socket.close();
                    this.socket = null;
                    this.din.close();
                    this.din = null;
                    this.dout.close();
                    this.dout = null;
                } catch (Exception exception) {
                }

                try {
                    this.socket = new Socket(this.server, this.servport);
                    this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                    this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                    this.dout.println(str1);
                    str2 = this.din.readLine();
                    if (str2 != null) bool1 = false;

                } catch (Exception exception) {
                }
            }
            if (bool1) {
                try {
                    this.socket.close();
                    this.socket = null;
                } catch (Exception exception) {
                }
                this.runtyp = 0;
                if (this.app.cmsg.isShowing()) {
                    this.app.cmsg.hide();
                    this.app.requestFocus();
                }
                this.runner.stop();
            }

            if (this.sendstat != 2) {
                byte b1 = 2, b2 = 1;
                if (this.clanchat) b2 = 2;
                for (byte b3 = 0; b3 < b2; b3++) {

                    int i = getvalue(str2, b3);
                    if (this.updatec[b3] != i && this.updatec[b3] >= -2 && this.pointc[b3] == 6) {

                        for (byte b = 0; b < 7; ) {
                            this.cnames[b3][b] = getSvalue(str2, b1);
                            this.sentn[b3][b] = getSvalue(str2, ++b1);
                            b1++;
                            b++;
                        }
                        if (this.cnames[b3][6].equals("")) if (b3 == 0) {
                            this.cnames[b3][6] = "Game Chat  ";
                        } else {
                            this.cnames[b3][6] = "" + this.clan + "'s Chat  ";
                        }
                        if (this.updatec[b3] != -2) {
                            this.floater[b3] = 1;
                            if (arrayOfBoolean[b3]) {
                                this.msgflk[b3] = 67;
                                arrayOfBoolean[b3] = false;
                            } else {
                                this.msgflk[b3] = 110;
                            }
                        }
                        this.updatec[b3] = i;
                    }
                }
            } else {
                this.sendstat = 3;
            }

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException interruptedException) {
            }
        }


        if (this.runtyp == -167 || this.runtyp == -168) {


            try {
                this.socket = new Socket("multiplayer.needformadness.com", 7061);
                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                this.dout.println("101|" + (this.runtyp + 174) + "|" + this.app.tnick.getText() + "|" + this.app.tpass.getText() + "|");
                String str = this.din.readLine();
                this.socket.close();
                this.socket = null;
                this.din.close();
                this.din = null;
                this.dout.close();
                this.dout = null;
            } catch (Exception exception) {
            }
            this.runtyp = 0;
        }
        if (this.runtyp == -166 || this.runtyp == -167 || this.runtyp == -168) pingstat();
    }

    public void stopchat() {
        this.clanchat = false;
        this.clangame = 0;
        if (this.runtyp == -101) {
            this.runtyp = 0;
            try {
                this.socket.close();
                this.socket = null;
                this.din.close();
                this.din = null;
                this.dout.close();
                this.dout = null;
            } catch (Exception exception) {
            }
        }

    }

    public void sendwin(CheckPoints paramCheckPoints) {
        if (this.logged && this.multion == 1 && this.winner) {
            if (paramCheckPoints.wasted == this.nplayers - 1) {
                this.runtyp = -167;
            } else {
                this.runtyp = -168;
            }
        } else {
            this.runtyp = -166;
        }
        this.runner = new Thread(this);
        this.runner.start();
    }


    public void loading() {
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 800, 450);
        this.rd.drawImage(this.sign, 362, 35, this);
        this.rd.drawImage(this.hello, 125, 105, this);

        this.rd.setColor(new Color(198, 214, 255));
        this.rd.fillRoundRect(250, 340, 300, 80, 30, 70);
        this.rd.setColor(new Color(128, 167, 255));
        this.rd.drawRoundRect(250, 340, 300, 80, 30, 70);
        this.rd.drawImage(this.loadbar, 281, 365, this);
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        drawcs(358, "Loading game, please wait.", 0, 0, 0, 3);
        this.rd.setColor(new Color(255, 255, 255));
        this.rd.fillRect(295, 398, 210, 17);

        this.shload += (this.dnload + 10.0F - this.shload) / 100.0F;
        if (this.shload > this.kbload) this.shload = this.kbload;
        if (this.dnload == this.kbload) this.shload = this.kbload;

        drawcs(410, "" + (int) ((26.0F + this.shload / this.kbload * 200.0F) / 226.0F * 100.0F) + " % loaded    |    " + (this.kbload - (int) this.shload) + " KB remaining", 32, 64, 128, 3);
        this.rd.setColor(new Color(32, 64, 128));
        this.rd.fillRect(287, 371, 26 + (int) (this.shload / this.kbload * 200.0F), 10);
    }


    public void stoploading() {
        loading();
        this.app.repaint();
        this.runtyp = 0;
    }


    public void clicknow() {
        this.rd.setColor(new Color(198, 214, 255));
        this.rd.fillRoundRect(250, 340, 300, 80, 30, 70);
        this.rd.setColor(new Color(128, 167, 255));
        this.rd.drawRoundRect(250, 340, 300, 80, 30, 70);
        if (this.aflk) {
            drawcs(380, "Click here to Start", 0, 0, 0, 3);
            this.aflk = false;
        } else {
            drawcs(380, "Click here to Start", 0, 67, 200, 3);
            this.aflk = true;
        }

    }

    public void stopallnow() {
        if (this.runner != null) {
            this.runner.stop();
            this.runner = null;
        }
        this.runtyp = 0;
        if (this.loadedt) {
            this.strack.unload();
            this.strack = null;
            this.loadedt = false;
        }
        byte b;
        for (b = 0; b < 5; ) {
            for (byte b1 = 0; b1 < 5; ) {
                this.engs[b][b1].stop();
                this.engs[b][b1] = null;
                b1++;
            }
            b++;
        }
        for (b = 0; b < 6; ) {
            this.air[b].stop();
            this.air[b] = null;
            b++;
        }
        this.wastd.stop();
        this.intertrack.unload();
        this.intertrack = null;
    }


    public void resetstat(int paramInt) {
        this.arrace = false;
        this.alocked = -1;
        this.lalocked = -1;
        this.cntflock = 90;
        this.onlock = false;
        this.ana = 0;
        this.cntan = 0;
        this.cntovn = 0;
        this.tcnt = 30;
        this.wasay = false;
        this.clear = 0;
        this.dmcnt = 0;
        this.pwcnt = 0;
        this.auscnt = 45;
        this.pnext = 0;
        this.pback = 0;
        this.starcnt = 130;
        this.gocnt = 3;
        this.grrd = true;
        this.aird = true;
        this.bfcrash = 0;
        this.bfscrape = 0;
        this.cntwis = 0;
        this.bfskid = 0;
        this.pwait = 7;
        this.forstart = 200;
        this.exitm = 0;
        this.holdcnt = 0;
        this.holdit = false;
        this.winner = false;
        this.wasted = 0;
        byte b;
        for (b = 0; b < 8; ) {
            this.dested[b] = 0;
            this.isbot[b] = false;
            this.dcrashes[b] = 0;
            b++;
        }
        this.runtyp = 0;
        this.discon = 0;
        this.dnload = 0;
        this.beststunt = 0;
        this.laptime = 0;
        this.fastestlap = 0;
        this.sendstat = 0;

        if (this.fase == 2 || this.fase == -22) sortcars(paramInt);

        if (this.fase == 22) {

            for (b = 0; b < 2; b++) {

                for (byte b1 = 0; b1 < 7; ) {
                    this.cnames[b][b1] = "";
                    this.sentn[b][b1] = "";
                    b1++;
                }
                if (b == 0) {
                    this.cnames[b][6] = "Game Chat  ";
                } else {
                    this.cnames[b][6] = "" + this.clan + "'s Chat  ";
                }
                this.updatec[b] = -1;
                this.movepos[b] = 0;
                this.pointc[b] = 6;
                this.floater[b] = 0;
                this.cntchatp[b] = 0;
                this.msgflk[b] = 0;
                this.lcmsg[b] = "";
            }
            if (this.multion == 3) {
                this.ransay = 4;
            } else if (this.ransay == 0) {
                this.ransay = 1 + (int) (Math.random() * 3.0D);
            } else {
                this.ransay++;
                if (this.ransay > 3) this.ransay = 1;
            }

        }
    }

    public void setbots(boolean[] paramArrayOfboolean, int[][] paramArrayOfint) {
        for (byte b = 0; b < this.nplayers; ) {
            if (this.plnames[b].indexOf("MadBot") != -1) {
                paramArrayOfboolean[b] = true;
                this.isbot[b] = true;
            }
            b++;
        }
    }

    public void rad(int paramInt) {
        if (paramInt == 0) {
            this.powerup.play();
            this.radpx = 212;
            this.pin = 0;
        }
        trackbg(false);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(65, 135, 670, 59);
        if (this.pin != 0) {
            this.rd.drawImage(this.radicalplay, this.radpx + (int) (8.0D * Math.random() - 4.0D), 135, (ImageObserver) null);
        } else {
            this.rd.drawImage(this.radicalplay, 212, 135, (ImageObserver) null);
        }
        if (this.radpx != 212) {
            this.radpx += 40;
            if (this.radpx > 735) this.radpx = -388;
        } else if (this.pin != 0) {
            this.pin--;
        }
        if (paramInt == 40) {
            this.radpx = 213;
            this.pin = 7;
        }
        if (this.radpx == 212) {
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            drawcs(185 + (int) (5.0F * this.m.random()), "Radicalplay.com", 112, 120, 143, 3);
        }
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        if (this.aflk) {
            drawcs(215, "And we are never going to find the new unless we get a little crazy...", 112, 120, 143, 3);
            this.aflk = false;
        } else {
            drawcs(217, "And we are never going to find the new unless we get a little crazy...", 150, 150, 150, 3);
            this.aflk = true;
        }
        this.rd.drawImage(this.rpro, 275, 265, (ImageObserver) null);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
    }

    public void credits(Control paramControl, int paramInt1, int paramInt2, int paramInt3) {
        if (this.flipo == 0) {
            this.powerup.play();
            this.flipo = 1;
        }
        if (this.flipo >= 1 && this.flipo <= 100) {
            rad(this.flipo);
            this.flipo++;
            if (this.flipo == 100) this.flipo = 1;
        }
        if (this.flipo == 101) {
            mainbg(-1);
            this.rd.drawImage(this.mdness, 283, 32, (ImageObserver) null);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            drawcs(90, "At Radicalplay.com", 0, 0, 0, 3);
            drawcs(165, "Cartoon 3D Engine, Game Programming, 3D Models, Graphics and Sound Effects", 0, 0, 0, 3);
            drawcs(185, "By Omar Waly", 40, 60, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            drawcs(225, "Special Thanks!", 0, 0, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            drawcs(245, "Thanks to Dany Fernandez Diaz (DragShot) for imporving the game’s music player to play more mod formats & effects!", 66, 98, 0, 3);
            drawcs(260, "Thanks to Badie El Zaman (Kingofspeed) for helping make the trees & cactus 3D models.", 66, 98, 0, 3);
            drawcs(275, "Thanks to Timothy Audrain Hardin (Legnak) for making hazard designs on stage parts & the new fence 3D model.", 66, 98, 0, 3);
            drawcs(290, "Thanks to Alex Miles (A-Mile) & Jaroslav Beleren (Phyrexian) for making trailer videos for the game.", 66, 98, 0, 3);
            drawcs(305, "A big thank you to everyone playing the game for sending their feedback, supporting the game and helping it improve!", 66, 98, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            drawcs(345, "Music from ModArchive.org", 0, 0, 0, 3);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            drawcs(365, "Most of the tracks where remixed by Omar Waly to match the game.", 66, 98, 0, 3);
            drawcs(380, "More details about the tracks and their original composers at:", 66, 98, 0, 3);
            drawcs(395, "http://multiplayer.needformadness.com/music.html", 33, 49, 0, 3);
            this.rd.drawLine(400 - this.ftm.stringWidth("http://multiplayer.needformadness.com/music.html") / 2, 396, this.ftm.stringWidth("http://multiplayer.needformadness.com/music.html") / 2 + 400, 396);
            if (paramInt1 > 258 && paramInt1 < 542 && paramInt2 > 385 && paramInt2 < 399) {
                this.app.setCursor(new Cursor(12));
                if (paramInt3 == 2) this.app.musiclink();
            } else {
                this.app.setCursor(new Cursor(0));
            }
        }
        if (this.flipo == 102) {
            mainbg(0);
            this.rd.drawImage(this.nfmcom, 190, 195, (ImageObserver) null);
            if (paramInt1 > 190 && paramInt1 < 609 && paramInt2 > 195 && paramInt2 < 216) {
                this.app.setCursor(new Cursor(12));
                if (paramInt3 == 2) this.app.madlink();
            } else {
                this.app.setCursor(new Cursor(0));
            }
        }
        this.rd.drawImage(this.next[this.pnext], 665, 395, (ImageObserver) null);
        if (paramControl.enter || paramControl.handb || paramControl.right) {
            if (this.flipo >= 1 && this.flipo <= 100) {
                this.flipo = 101;
                this.app.setCursor(new Cursor(0));
            } else {
                this.flipo++;
            }
            if (this.flipo == 103) {
                this.flipo = 0;
                this.fase = 10;
            }
            paramControl.enter = false;
            paramControl.handb = false;
            paramControl.right = false;
        }
    }

    public void trackbg(boolean paramBoolean) {
        boolean bool = false;
        this.trkl++;
        if (this.trkl > this.trklim) {
            bool = true;
            this.trklim = (int) (Math.random() * 40.0D);
            this.trkl = 0;
        }
        if (paramBoolean) bool = false;
        for (byte b = 0; b < 2; b++) {
            int i = bool ? 1: 0;
            this.rd.drawImage(this.trackbg[i], this.trkx[b], 25, (ImageObserver) null);
            this.trkx[b] = this.trkx[b] - 10;
            if (this.trkx[b] <= -605) this.trkx[b] = 735;
        }
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
    }

    public void mainbg(int paramInt) {
        byte b = 2;
        this.rd.setColor(new Color(191, 184, 124));
        if (paramInt == -1) {
            if (paramInt != this.lmode) {
                this.bgmy[0] = 0;
                this.bgmy[1] = -400;
                this.bgup = false;
                this.bgf = 0.0F;
                this.lmode = paramInt;
            }
            this.rd.setColor(new Color(144, 222, 9));
            b = 8;
        }
        if (paramInt == 0) {
            if (paramInt != this.lmode) {
                this.bgmy[0] = 0;
                this.bgmy[1] = -400;
                this.bgup = false;
                this.bgf = 0.0F;
                this.lmode = paramInt;
            }
            int i = (int) (255.0F * this.bgf + 191.0F * (1.0F - this.bgf)), j = (int) (176.0F * this.bgf + 184.0F * (1.0F - this.bgf)), k = (int) (67.0F * this.bgf + 124.0F * (1.0F - this.bgf));
            if (!this.bgup) {
                this.bgf += 0.02F;
                if (this.bgf > 0.9F) {
                    this.bgf = 0.9F;
                    this.bgup = true;
                }
            } else {
                this.bgf -= 0.02F;
                if (this.bgf < 0.2F) {
                    this.bgf = 0.2F;
                    this.bgup = false;
                }
            }
            this.rd.setColor(new Color(i, j, k));
            b = 4;
        }
        if (paramInt == 1) {
            if (paramInt != this.lmode) {
                this.bgmy[0] = 0;
                this.bgmy[1] = -400;
                this.lmode = paramInt;
            }
            this.rd.setColor(new Color(255, 176, 67));
            b = 8;
        }
        if (paramInt == 2) {
            if (paramInt != this.lmode) {
                this.bgmy[0] = 0;
                this.bgmy[1] = -400;
                this.lmode = paramInt;
                this.bgf = 0.2F;
            }
            this.rd.setColor(new Color(188, 170, 122));
            if (this.flipo == 16) {
                int i = (int) (176.0F * this.bgf + 191.0F * (1.0F - this.bgf)), j = (int) (202.0F * this.bgf + 184.0F * (1.0F - this.bgf)), k = (int) (255.0F * this.bgf + 124.0F * (1.0F - this.bgf));
                this.rd.setColor(new Color(i, j, k));
                this.bgf += 0.025F;
                if (this.bgf > 0.85F) this.bgf = 0.85F;
            } else {
                this.bgf = 0.2F;
            }
            b = 2;
        }
        if (paramInt == 3) {
            if (paramInt != this.lmode) {
                this.bgmy[0] = 0;
                this.bgmy[1] = -400;
                this.bgup = false;
                this.bgf = 0.0F;
                this.lmode = paramInt;
            }
            int i = (int) (255.0F * this.bgf + 191.0F * (1.0F - this.bgf)), j = (int) (176.0F * this.bgf + 184.0F * (1.0F - this.bgf)), k = (int) (67.0F * this.bgf + 124.0F * (1.0F - this.bgf));
            if (!this.bgup) {
                this.bgf += 0.02F;
                if (this.bgf > 0.9F) {
                    this.bgf = 0.9F;
                    this.bgup = true;
                }
            } else {
                this.bgf -= 0.02F;
                if (this.bgf < 0.2F) {
                    this.bgf = 0.2F;
                    this.bgup = false;
                }
            }
            this.rd.setColor(new Color(i, j, k));
            b = 2;
        }
        if (paramInt != -101) if (paramInt == 4) {
            this.rd.setColor(new Color(216, 177, 100));
            this.rd.fillRect(65, 0, 670, 425);
        } else {
            this.rd.fillRect(65, 25, 670, 400);
        }
        if (paramInt == 4) {
            if (paramInt != this.lmode) {
                byte b2;
                for (this.bgmy[0] = 0, this.bgmy[1] = 400, b2 = 0; b2 < 4; ) {
                    this.ovw[b2] = (int) (50.0D + 150.0D * Math.random());
                    this.ovh[b2] = (int) (50.0D + 150.0D * Math.random());
                    this.ovy[b2] = (int) (400.0D * Math.random());
                    this.ovx[b2] = (int) (Math.random() * 670.0D);
                    this.ovsx[b2] = (int) (5.0D + Math.random() * 10.0D);
                    b2++;
                }
                this.lmode = paramInt;
            }
            for (byte b1 = 0; b1 < 4; ) {
                this.rd.setColor(new Color(235, 176, 84));
                this.rd.fillOval((int) ((65 + this.ovx[b1]) - this.ovw[b1] * 1.5D / 2.0D), (int) ((25 + this.ovy[b1]) - this.ovh[b1] * 1.5D / 2.0D), (int) (this.ovw[b1] * 1.5D), (int) (this.ovh[b1] * 1.5D));
                this.rd.setColor(new Color(255, 176, 67));
                this.rd.fillOval(65 + this.ovx[b1] - this.ovh[b1] / 2, 25 + this.ovy[b1] - this.ovh[b1] / 2, this.ovw[b1], this.ovh[b1]);
                this.ovx[b1] = this.ovx[b1] - this.ovsx[b1];
                if (this.ovx[b1] + this.ovw[b1] * 1.5D / 2.0D < 0.0D) {
                    this.ovw[b1] = (int) (50.0D + 150.0D * Math.random());
                    this.ovh[b1] = (int) (50.0D + 150.0D * Math.random());
                    this.ovy[b1] = (int) (400.0D * Math.random());
                    this.ovx[b1] = (int) (670.0D + this.ovw[b1] * 1.5D / 2.0D);
                    this.ovsx[b1] = (int) (5.0D + Math.random() * 10.0D);
                }
                b1++;
            }
        }
        if (paramInt != -101 && paramInt != 4) for (byte b1 = 0; b1 < 2; b1++) {
            if (paramInt != 2 || this.flipo != 16)
                this.rd.drawImage(this.bgmain, 65, 25 + this.bgmy[b1], (ImageObserver) null);
            this.bgmy[b1] = this.bgmy[b1] + b;
            if (this.bgmy[b1] >= 400) this.bgmy[b1] = -400;
        }
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        if (paramInt != 4) this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
    }

    public void inishstageselect(CheckPoints paramCheckPoints) {
        if (paramCheckPoints.stage == -2 && (this.cd.msloaded != 1 || !this.logged)) {
            paramCheckPoints.stage = (int) (Math.random() * 27.0D) + 1;
            paramCheckPoints.top20 = 0;
        }
        if (paramCheckPoints.stage > 27) paramCheckPoints.stage = (int) (Math.random() * 27.0D) + 1;
        if (paramCheckPoints.stage == -2) {
            boolean bool;
            byte b;
            for (bool = false, b = 1; b < this.app.mstgs.getItemCount(); ) {
                if (this.app.mstgs.getItem(b).equals(paramCheckPoints.name)) bool = true;
                b++;
            }
            if (!bool) paramCheckPoints.stage = (int) (Math.random() * 27.0D) + 1;
        }
        if (this.gmode == 1) {
            if (this.unlocked[0] != 11 || this.justwon1) {
                paramCheckPoints.stage = this.unlocked[0];
            } else if (this.winner || paramCheckPoints.stage > 11) {
                paramCheckPoints.stage = (int) (Math.random() * 11.0D) + 1;
            }
            if (paramCheckPoints.stage == 11) paramCheckPoints.stage = 27;
        }
        if (this.gmode == 2) if (this.unlocked[0] != 17 || this.justwon2) {
            paramCheckPoints.stage = this.unlocked[1] + 10;
        } else if (this.winner || paramCheckPoints.stage < 11) {
            paramCheckPoints.stage = (int) (Math.random() * 17.0D) + 11;
        }
        this.app.sgame.setBackground(new Color(0, 0, 0));
        this.app.sgame.setForeground(new Color(47, 179, 255));
        this.app.snfm1.setBackground(new Color(0, 0, 0));
        this.app.snfm1.setForeground(new Color(47, 179, 255));
        this.app.snfm2.setBackground(new Color(0, 0, 0));
        this.app.snfm2.setForeground(new Color(47, 179, 255));
        this.app.mstgs.setBackground(new Color(0, 0, 0));
        this.app.mstgs.setForeground(new Color(47, 179, 255));
        this.app.gmode.setBackground(new Color(49, 49, 0));
        this.app.gmode.setForeground(new Color(148, 167, 0));
        this.app.sgame.removeAll();
        this.app.sgame.add(this.rd, " NFM 1     ");
        this.app.sgame.add(this.rd, " NFM 2     ");
        this.app.sgame.add(this.rd, " My Stages ");
        this.app.sgame.add(this.rd, " Weekly Top20 ");
        this.app.sgame.add(this.rd, " Monthly Top20 ");
        this.app.sgame.add(this.rd, " Stage Maker ");
        if (paramCheckPoints.stage > 0 && paramCheckPoints.stage <= 10) {
            this.app.sgame.select(0);
            this.nfmtab = 0;
        }
        if (paramCheckPoints.stage > 10) {
            this.app.sgame.select(1);
            this.nfmtab = 1;
        }
        if (paramCheckPoints.stage == -2) {
            this.app.sgame.select(2);
            this.nfmtab = 2;
        }
        if (paramCheckPoints.stage == -1) {
            this.app.sgame.select(5);
            this.nfmtab = 5;
        }
        this.removeds = 0;
        this.lfrom = 0;
        this.cd.staction = 0;
        this.fase = 2;
    }

    public void loadingstage(int paramInt, boolean paramBoolean) {
        trackbg(true);
        this.rd.drawImage(this.br, 65, 25, (ImageObserver) null);
        this.rd.setColor(new Color(212, 214, 138));
        this.rd.fillRoundRect(265, 201, 270, 26, 20, 40);
        this.rd.setColor(new Color(57, 64, 8));
        this.rd.drawRoundRect(265, 201, 270, 26, 20, 40);
        this.rd.setFont(new Font("Arial", 1, 12));
        this.ftm = this.rd.getFontMetrics();
        drawcs(219, "Loading, please wait...", 58, 61, 17, 3);
        if (paramBoolean) this.rd.drawImage(this.select, 338, 35, (ImageObserver) null);
        this.app.repaint();
        if (this.cd.staction != 0) {
            this.app.tnick.hide();
            this.app.tpass.hide();
            this.cd.staction = 0;
        }
        this.removeds = 0;
    }

    public void cantgo(Control paramControl) {
        this.pnext = 0;
        trackbg(false);
        this.rd.drawImage(this.br, 65, 25, (ImageObserver) null);
        this.rd.drawImage(this.select, 338, 35, (ImageObserver) null);
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        drawcs(130, "This stage will be unlocked when stage " + this.unlocked[this.gmode - 1] + " is complete!", 177, 177, 177, 3);
        for (byte b = 0; b < 9; ) {
            this.rd.drawImage(this.pgate, 277 + b * 30, 215, (ImageObserver) null);
            b++;
        }
        this.rd.setFont(new Font("Arial", 1, 12));
        this.ftm = this.rd.getFontMetrics();
        if (this.aflk) {
            drawcs(185, "[ Stage " + (this.unlocked[this.gmode - 1] + 1) + " Locked ]", 255, 128, 0, 3);
            this.aflk = false;
        } else {
            drawcs(185, "[ Stage " + (this.unlocked[this.gmode - 1] + 1) + " Locked ]", 255, 0, 0, 3);
            this.aflk = true;
        }
        this.rd.drawImage(this.back[this.pback], 370, 345, (ImageObserver) null);
        this.lockcnt--;
        if (this.lockcnt == 0 || paramControl.enter || paramControl.handb || paramControl.left) {
            paramControl.left = false;
            paramControl.handb = false;
            paramControl.enter = false;
            this.fase = 1;
        }
    }

    public void stageselect(CheckPoints paramCheckPoints, Control paramControl, int paramInt1, int paramInt2, boolean paramBoolean) {
        this.rd.drawImage(this.br, 65, 25, (ImageObserver) null);
        this.rd.drawImage(this.select, 338, 35, (ImageObserver) null);
        if (this.testdrive != 3 && this.testdrive != 4) {
            if (paramCheckPoints.stage > 0 && this.cd.staction == 0) {
                if (paramCheckPoints.stage != 1 && (paramCheckPoints.stage != 11 || this.gmode != 2))
                    this.rd.drawImage(this.back[this.pback], 115, 135, (ImageObserver) null);
                if (paramCheckPoints.stage != 27)
                    this.rd.drawImage(this.next[this.pnext], 625, 135, (ImageObserver) null);
            }
            if (this.gmode == 0) {
                boolean bool = false;
                byte b = 0;
                if (this.nfmtab != this.app.sgame.getSelectedIndex()) {
                    this.nfmtab = this.app.sgame.getSelectedIndex();
                    this.app.snfm1.select(0);
                    this.app.snfm2.select(0);
                    this.app.mstgs.select(0);
                    this.app.requestFocus();
                    bool = true;
                }
                if (this.cd.staction == 5) {
                    if (this.lfrom == 0) {
                        this.cd.staction = 0;
                        this.removeds = 1;
                        bool = true;
                    } else {
                        this.cd.onstage = paramCheckPoints.name;
                        this.cd.staction = 2;
                        this.dnload = 2;
                    }
                    this.backlog = this.nickname = this.app.tnick.getText();
                    this.nickey = this.cd.tnickey;
                    this.clan = this.cd.tclan;
                    this.clankey = this.cd.tclankey;
                    this.app.setloggedcookie();
                    this.logged = true;
                    this.gotlog = true;
                    if (this.cd.reco == 0) this.acexp = 0;
                    if (this.cd.reco > 10) this.acexp = this.cd.reco - 10;
                    if (this.cd.reco == 3) this.acexp = -1;
                    if (this.cd.reco == 111) if (!this.backlog.toLowerCase().equals(this.nickname.toLowerCase())) {
                        this.acexp = -3;
                    } else {
                        this.acexp = 0;
                    }
                }
                if (this.nfmtab == 2 && this.cd.staction == 0 && this.removeds == 1) paramCheckPoints.stage = -3;
                if (this.app.openm && this.cd.staction == 3) {
                    this.app.tnick.hide();
                    this.app.tpass.hide();
                    this.cd.staction = 0;
                }
                int i = 0;
                this.app.sgame.setSize(131, 22);
                if (this.app.sgame.getSelectedIndex() == 0)
                    i = 400 - (this.app.sgame.getWidth() + 6 + this.app.snfm1.getWidth()) / 2;
                if (this.app.sgame.getSelectedIndex() == 1)
                    i = 400 - (this.app.sgame.getWidth() + 6 + this.app.snfm2.getWidth()) / 2;
                if (this.app.sgame.getSelectedIndex() == 2) {
                    this.app.mstgs.setSize(338, 22);
                    if (bool) if (this.logged) {
                        if (this.cd.msloaded != 1) {
                            this.app.mstgs.removeAll();
                            this.app.mstgs.add(this.rd, "Loading your stages now, please wait...");
                            this.app.mstgs.select(0);
                            b = 1;
                        }
                    } else {
                        this.app.mstgs.removeAll();
                        this.app.mstgs.add(this.rd, "Please login first to load your stages...");
                        this.app.mstgs.select(0);
                        this.cd.msloaded = 0;
                        this.lfrom = 0;
                        this.cd.staction = 3;
                        this.showtf = false;
                        this.tcnt = 0;
                        this.cntflock = 0;
                        this.cd.reco = -2;
                    }
                    i = 400 - (this.app.sgame.getWidth() + 6 + this.app.mstgs.getWidth()) / 2;
                }
                if (this.app.sgame.getSelectedIndex() == 3) {
                    this.app.mstgs.setSize(338, 22);
                    if (bool && this.cd.msloaded != 3) {
                        this.app.mstgs.removeAll();
                        this.app.mstgs.add(this.rd, "Loading Top20 list, please wait...");
                        this.app.mstgs.select(0);
                        b = 3;
                    }
                    i = 400 - (this.app.sgame.getWidth() + 6 + this.app.mstgs.getWidth()) / 2;
                }
                if (this.app.sgame.getSelectedIndex() == 4) {
                    this.app.mstgs.setSize(338, 22);
                    if (bool && this.cd.msloaded != 4) {
                        this.app.mstgs.removeAll();
                        this.app.mstgs.add(this.rd, "Loading Top20 list, please wait...");
                        this.app.mstgs.select(0);
                        b = 4;
                    }
                    i = 400 - (this.app.sgame.getWidth() + 6 + this.app.mstgs.getWidth()) / 2;
                }
                if (this.app.sgame.getSelectedIndex() == 5) {
                    if (this.cd.staction != 0) {
                        this.app.tnick.hide();
                        this.app.tpass.hide();
                        this.cd.staction = 0;
                    }
                    this.app.mstgs.setSize(338, 22);
                    if (bool && this.cd.msloaded != 2) {
                        this.app.mstgs.removeAll();
                        this.app.mstgs.add(this.rd, "Loading Stage Maker stages, please wait...");
                        this.app.mstgs.select(0);
                        b = 2;
                    }
                    i = 400 - (this.app.sgame.getWidth() + 6 + this.app.mstgs.getWidth()) / 2;
                }
                if (!this.app.sgame.isShowing()) this.app.sgame.show();
                this.app.sgame.move(i, 62);
                i += this.app.sgame.getWidth() + 6;
                if (this.nfmtab == 0) {
                    if (!this.app.snfm1.isShowing()) {
                        this.app.snfm1.show();
                        if (!bool && paramCheckPoints.stage > 0) this.app.snfm1.select(paramCheckPoints.stage);
                    }
                    this.app.snfm1.move(i, 62);
                    if (this.app.snfm2.isShowing()) this.app.snfm2.hide();
                    if (this.app.mstgs.isShowing()) this.app.mstgs.hide();
                }
                if (this.nfmtab == 1) {
                    if (!this.app.snfm2.isShowing()) {
                        this.app.snfm2.show();
                        if (!bool && paramCheckPoints.stage > 10) this.app.snfm2.select(paramCheckPoints.stage - 10);
                    }
                    this.app.snfm2.move(i, 62);
                    if (this.app.snfm1.isShowing()) this.app.snfm1.hide();
                    if (this.app.mstgs.isShowing()) this.app.mstgs.hide();
                }
                if (this.nfmtab == 2 || this.nfmtab == 3 || this.nfmtab == 4 || this.nfmtab == 5) {
                    if (!this.app.mstgs.isShowing()) {
                        this.app.mstgs.show();
                        if (!bool) this.app.mstgs.select(paramCheckPoints.name);
                    }
                    this.app.mstgs.move(i, 62);
                    if (this.app.snfm1.isShowing()) this.app.snfm1.hide();
                    if (this.app.snfm2.isShowing()) this.app.snfm2.hide();
                }
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (this.cd.staction == 0 || this.cd.staction == 6) if (paramCheckPoints.stage != -3) {
                    String str = "";
                    if (paramCheckPoints.top20 >= 3) str = "N#" + paramCheckPoints.nto + "  ";
                    if (this.aflk) {
                        drawcs(132, str + paramCheckPoints.name, 240, 240, 240, 3);
                        this.aflk = false;
                    } else {
                        drawcs(132, str + paramCheckPoints.name, 176, 176, 176, 3);
                        this.aflk = true;
                    }
                    if (paramCheckPoints.stage == -2 && this.cd.staction == 0) {
                        this.rd.setFont(new Font("Arial", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(255, 176, 85));
                        if (paramCheckPoints.maker.equals(this.nickname)) {
                            this.rd.drawString("Created by You", 70, 115);
                        } else {
                            this.rd.drawString("Created by :  " + paramCheckPoints.maker + "", 70, 115);
                        }
                        if (paramCheckPoints.top20 >= 3)
                            this.rd.drawString("Added by :  " + this.cd.top20adds[paramCheckPoints.nto - 1] + " Players", 70, 135);
                    }
                } else if (this.removeds != 1) {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    drawcs(132, "Failed to load stage...", 255, 138, 0, 3);
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    if (this.nfmtab == 5)
                        drawcs(155, "Please Test Drive this stage in the Stage Maker to make sure it can be loaded!", 255, 138, 0, 3);
                    if (this.nfmtab == 2 || this.nfmtab == 3 || this.nfmtab == 4)
                        drawcs(155, "It could be a connection error, please try again later.", 255, 138, 0, 3);
                    if (this.nfmtab == 1 || this.nfmtab == 0) {
                        drawcs(155, "Will try to load another stage...", 255, 138, 0, 3);
                        this.app.repaint();
                        try {
                            Thread.sleep(5000L);
                        } catch (InterruptedException interruptedException) {
                        }
                        if (this.nfmtab == 0) this.app.snfm1.select(1 + (int) (Math.random() * 10.0D));
                        if (this.nfmtab == 1) this.app.snfm2.select(1 + (int) (Math.random() * 17.0D));
                    }
                }
                if (this.cd.staction == 3) {
                    drawdprom(145, 170);
                    if (this.cd.reco == -2) if (this.lfrom == 0) {
                        drawcs(171, "Login to Retrieve your Account Stages", 0, 0, 0, 3);
                    } else {
                        drawcs(171, "Login to add this stage to your account.", 0, 0, 0, 3);
                    }
                    if (this.cd.reco == -1) drawcs(171, "Unable to connect to server, try again later!", 0, 8, 0, 3);
                    if (this.cd.reco == 1)
                        drawcs(171, "Sorry.  The Nickname you have entered is incorrect.", 0, 0, 0, 3);
                    if (this.cd.reco == 2)
                        drawcs(171, "Sorry.  The Password you have entered is incorrect.", 0, 0, 0, 3);
                    if (this.cd.reco == -167 || this.cd.reco == -177) {
                        if (this.cd.reco == -167) {
                            this.backlog = this.nickname = this.app.tnick.getText();
                            this.cd.reco = -177;
                        }
                        drawcs(171, "You are currently using a trial account.", 0, 0, 0, 3);
                    }
                    if (this.cd.reco == -3 && (this.tcnt % 3 != 0 || this.tcnt > 20))
                        drawcs(171, "Please enter your Nickname!", 0, 0, 0, 3);
                    if (this.cd.reco == -4 && (this.tcnt % 3 != 0 || this.tcnt > 20))
                        drawcs(171, "Please enter your Password!", 0, 0, 0, 3);
                    if (!this.showtf) {
                        this.app.tnick.setBackground(new Color(206, 237, 255));
                        if (this.cd.reco != 1) {
                            if (this.cd.reco != 2) this.app.tnick.setText(this.nickname);
                            this.app.tnick.setForeground(new Color(0, 0, 0));
                        } else {
                            this.app.tnick.setForeground(new Color(255, 0, 0));
                        }
                        this.app.tnick.requestFocus();
                        this.app.tpass.setBackground(new Color(206, 237, 255));
                        if (this.cd.reco != 2) {
                            if (!this.autolog) this.app.tpass.setText("");
                            this.app.tpass.setForeground(new Color(0, 0, 0));
                        } else {
                            this.app.tpass.setForeground(new Color(255, 0, 0));
                        }
                        if (!this.app.tnick.getText().equals("") && this.cd.reco != 1) this.app.tpass.requestFocus();
                        this.showtf = true;
                    }
                    this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 201);
                    this.rd.drawString("Password:", 376 - this.ftm.stringWidth("Password:") - 14, 231);
                    this.app.movefieldd(this.app.tnick, 376, 185, 129, 23, true);
                    this.app.movefieldd(this.app.tpass, 376, 215, 129, 23, true);
                    if (this.tcnt < 30) {
                        this.tcnt++;
                        if (this.tcnt == 30) {
                            if (this.cd.reco == 2) this.app.tpass.setText("");
                            this.app.tnick.setForeground(new Color(0, 0, 0));
                            this.app.tpass.setForeground(new Color(0, 0, 0));
                        }
                    }
                    if (this.cd.reco != -177) {
                        if ((drawcarb(true, null, "       Login       ", 347, 247, paramInt1, paramInt2, paramBoolean) || paramControl.handb || paramControl.enter) && this.tcnt > 5) {
                            this.tcnt = 0;
                            if (!this.app.tnick.getText().equals("") && !this.app.tpass.getText().equals("")) {
                                this.autolog = false;
                                this.app.tnick.hide();
                                this.app.tpass.hide();
                                this.app.requestFocus();
                                this.cd.staction = 4;
                                this.cd.sparkstageaction();
                            } else {
                                if (this.app.tpass.getText().equals("")) this.cd.reco = -4;
                                if (this.app.tnick.getText().equals("")) this.cd.reco = -3;
                            }
                        }
                    } else if (drawcarb(true, null, "  Upgrade to have your own stages!  ", 277, 247, paramInt1, paramInt2, paramBoolean) && this.cntflock == 0) {
                        this.app.editlink(this.nickname, true);
                        this.cntflock = 100;
                    }
                    if (drawcarb(true, null, "  Cancel  ", 409, 282, paramInt1, paramInt2, paramBoolean)) {
                        this.app.tnick.hide();
                        this.app.tpass.hide();
                        this.app.requestFocus();
                        this.cd.staction = 0;
                    }
                    if (drawcarb(true, null, "  Register!  ", 316, 282, paramInt1, paramInt2, paramBoolean)) {
                        if (this.cntflock == 0) {
                            this.app.reglink();
                            this.cntflock = 100;
                        }
                    } else if (this.cntflock != 0) {
                        this.cntflock--;
                    }
                }
                if (this.cd.staction == 4) {
                    drawdprom(145, 170);
                    drawcs(195, "Logging in to your account...", 0, 0, 0, 3);
                }
                if (paramCheckPoints.stage == -2 && this.cd.msloaded == 1 && paramCheckPoints.top20 < 3 && !this.app.openm && drawcarb(true, null, "X", 609, 113, paramInt1, paramInt2, paramBoolean))
                    this.cd.staction = 6;
                if (this.cd.staction == -1 && paramCheckPoints.top20 < 3) {
                    this.removeds = 0;
                    drawdprom(145, 95);
                    drawcs(175, "Failed to remove stage from your account, try again later.", 0, 0, 0, 3);
                    if (drawcarb(true, null, " OK ", 379, 195, paramInt1, paramInt2, paramBoolean))
                        this.cd.staction = 0;
                }
                if (this.cd.staction == 1) {
                    drawdprom(145, 95);
                    drawcs(195, "Removing stage from your account...", 0, 0, 0, 3);
                    this.removeds = 1;
                }
                if (this.cd.staction == 6) {
                    drawdprom(145, 95);
                    drawcs(175, "Remove this stage from your account?", 0, 0, 0, 3);
                    if (drawcarb(true, null, " Yes ", 354, 195, paramInt1, paramInt2, paramBoolean)) {
                        this.cd.onstage = this.app.mstgs.getSelectedItem();
                        this.cd.staction = 1;
                        this.cd.sparkstageaction();
                    }
                    if (drawcarb(true, null, " No ", 408, 195, paramInt1, paramInt2, paramBoolean))
                        this.cd.staction = 0;
                }
                if (b == 1) {
                    this.app.drawms();
                    this.app.repaint();
                    this.cd.loadmystages(paramCheckPoints);
                }
                if (b >= 3) {
                    this.app.drawms();
                    this.app.repaint();
                    this.cd.loadtop20(b);
                }
                if (b == 2) {
                    this.app.drawms();
                    this.app.repaint();
                    this.cd.loadstagemaker();
                }
                if (paramCheckPoints.stage != -3 && this.cd.staction == 0 && paramCheckPoints.top20 < 3) {
                    this.rd.drawImage(this.contin[this.pcontin], 355, 360, (ImageObserver) null);
                } else {
                    this.pcontin = 0;
                }
                if (paramCheckPoints.top20 >= 3 && this.cd.staction != 3 && this.cd.staction != 4) {
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    if (this.dnload == 0 && drawcarb(true, null, " Add to My Stages ", 334, 355, paramInt1, paramInt2, paramBoolean))
                        if (this.logged) {
                            this.cd.onstage = paramCheckPoints.name;
                            this.cd.staction = 2;
                            this.cd.sparkstageaction();
                            this.dnload = 2;
                        } else {
                            this.lfrom = 1;
                            this.cd.staction = 3;
                            this.showtf = false;
                            this.tcnt = 0;
                            this.cntflock = 0;
                            this.cd.reco = -2;
                        }
                    if (this.dnload == 2) {
                        drawcs(370, "Adding stage please wait...", 193, 106, 0, 3);
                        if (this.cd.staction == 0) this.dnload = 3;
                        if (this.cd.staction == -2) this.dnload = 4;
                        if (this.cd.staction == -3) this.dnload = 5;
                        if (this.cd.staction == -1) this.dnload = 6;
                        if (this.dnload != 2) this.cd.staction = 0;
                    }
                    if (this.dnload == 3)
                        drawcs(370, "Stage has been successfully added to your stages!", 193, 106, 0, 3);
                    if (this.dnload == 4) drawcs(370, "You already have this stage!", 193, 106, 0, 3);
                    if (this.dnload == 5)
                        drawcs(370, "Cannot add more then 20 stages to your account!", 193, 106, 0, 3);
                    if (this.dnload == 6)
                        drawcs(370, "Failed to add stage, unknown error, please try again later.", 193, 106, 0, 3);
                }
                if (this.testdrive == 0 && paramCheckPoints.top20 < 3) {
                    if (!this.app.gmode.isShowing()) {
                        this.app.gmode.select(0);
                        this.app.gmode.show();
                    }
                    this.app.gmode.move(400 - this.app.gmode.getWidth() / 2, 395);
                    if (this.app.gmode.getSelectedIndex() == 0 && this.nplayers != 7) {
                        this.nplayers = 7;
                        this.fase = 2;
                        this.app.requestFocus();
                    }
                    if (this.app.gmode.getSelectedIndex() == 1 && this.nplayers != 1) {
                        this.nplayers = 1;
                        this.fase = 2;
                        this.app.requestFocus();
                    }
                } else if (this.app.gmode.isShowing()) {
                    this.app.gmode.hide();
                }
                if (this.nfmtab == 0 && this.app.snfm1.getSelectedIndex() != paramCheckPoints.stage && this.app.snfm1.getSelectedIndex() != 0) {
                    paramCheckPoints.stage = this.app.snfm1.getSelectedIndex();
                    paramCheckPoints.top20 = 0;
                    paramCheckPoints.nto = 0;
                    hidos();
                    this.fase = 2;
                    this.app.requestFocus();
                }
                if (this.nfmtab == 1 && this.app.snfm2.getSelectedIndex() != paramCheckPoints.stage - 10 && this.app.snfm2.getSelectedIndex() != 0) {
                    paramCheckPoints.stage = this.app.snfm2.getSelectedIndex() + 10;
                    paramCheckPoints.top20 = 0;
                    paramCheckPoints.nto = 0;
                    hidos();
                    this.fase = 2;
                    this.app.requestFocus();
                }
                if ((this.nfmtab == 2 || this.nfmtab == 5) && !this.app.mstgs.getSelectedItem().equals(paramCheckPoints.name) && this.app.mstgs.getSelectedIndex() != 0) {
                    if (this.nfmtab == 2) {
                        paramCheckPoints.stage = -2;
                    } else {
                        paramCheckPoints.stage = -1;
                    }
                    paramCheckPoints.name = this.app.mstgs.getSelectedItem();
                    paramCheckPoints.top20 = 0;
                    paramCheckPoints.nto = 0;
                    hidos();
                    this.fase = 2;
                    this.app.requestFocus();
                }
                if (this.nfmtab == 3 || this.nfmtab == 4) {
                    String str = "";
                    int j = this.app.mstgs.getSelectedItem().indexOf(" ") + 1;
                    if (j > 0) str = this.app.mstgs.getSelectedItem().substring(j);
                    if (!str.equals("") && !str.equals(paramCheckPoints.name) && this.app.mstgs.getSelectedIndex() != 0) {
                        paramCheckPoints.stage = -2;
                        paramCheckPoints.name = str;
                        paramCheckPoints.top20 = -this.cd.msloaded;
                        paramCheckPoints.nto = this.app.mstgs.getSelectedIndex();
                        hidos();
                        this.fase = 2;
                        this.app.requestFocus();
                    }
                }
            } else {
                this.rd.setFont(new Font("SansSerif", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (paramCheckPoints.stage != 27) {
                    int i = paramCheckPoints.stage;
                    if (i > 10) i -= 10;
                    drawcs(80, "Stage " + i + "  >", 255, 128, 0, 3);
                } else {
                    drawcs(80, "Final Party Stage  >", 255, 128, 0, 3);
                }
                if (this.aflk) {
                    drawcs(100, "| " + paramCheckPoints.name + " |", 240, 240, 240, 3);
                    this.aflk = false;
                } else {
                    drawcs(100, "| " + paramCheckPoints.name + " |", 176, 176, 176, 3);
                    this.aflk = true;
                }
                if (paramCheckPoints.stage != -3) {
                    this.rd.drawImage(this.contin[this.pcontin], 355, 360, (ImageObserver) null);
                } else {
                    this.pcontin = 0;
                }
            }
            if (this.cd.staction == 0) {
                if ((paramControl.handb || paramControl.enter) && paramCheckPoints.stage != -3 && paramCheckPoints.top20 < 3) {
                    this.app.gmode.hide();
                    hidos();
                    this.dudo = 150;
                    this.fase = 5;
                    paramControl.handb = false;
                    paramControl.enter = false;
                    this.intertrack.stop();
                    this.intertrack.unloadimod();
                }
                if (paramCheckPoints.stage > 0) {
                    if (paramControl.right) {
                        if (this.gmode == 0 || (this.gmode == 1 && paramCheckPoints.stage != this.unlocked[0]) || (this.gmode == 2 && paramCheckPoints.stage != this.unlocked[1] + 10) || paramCheckPoints.stage == 27) {
                            if (paramCheckPoints.stage != 27) {
                                hidos();
                                paramCheckPoints.stage++;
                                if (this.gmode == 1 && paramCheckPoints.stage == 11) paramCheckPoints.stage = 27;
                                if (paramCheckPoints.stage > 10) {
                                    this.app.sgame.select(1);
                                    this.nfmtab = 1;
                                } else {
                                    this.app.sgame.select(0);
                                    this.nfmtab = 0;
                                }
                                this.fase = 2;
                            }
                        } else {
                            this.fase = 4;
                            this.lockcnt = 100;
                        }
                        paramControl.right = false;
                    }
                    if (paramControl.left && paramCheckPoints.stage != 1 && (paramCheckPoints.stage != 11 || this.gmode != 2)) {
                        hidos();
                        paramCheckPoints.stage--;
                        if (this.gmode == 1 && paramCheckPoints.stage == 26) paramCheckPoints.stage = 10;
                        if (paramCheckPoints.stage > 10) {
                            this.app.sgame.select(1);
                            this.nfmtab = 1;
                        } else {
                            this.app.sgame.select(0);
                            this.nfmtab = 0;
                        }
                        this.fase = 2;
                        paramControl.left = false;
                    }
                }
            }
        } else {
            if (this.aflk) {
                drawcs(132, paramCheckPoints.name, 240, 240, 240, 3);
                this.aflk = false;
            } else {
                drawcs(132, paramCheckPoints.name, 176, 176, 176, 3);
                this.aflk = true;
            }
            this.rd.drawImage(this.contin[this.pcontin], 355, 360, (ImageObserver) null);
            if (paramControl.handb || paramControl.enter) {
                this.dudo = 150;
                this.fase = 5;
                paramControl.handb = false;
                paramControl.enter = false;
                this.intertrack.stop();
                this.intertrack.unloadimod();
            }
        }
        if (drawcarb(true, null, " Exit X ", 670, 30, paramInt1, paramInt2, paramBoolean)) {
            this.fase = 102;
            if (this.gmode == 0) this.opselect = 3;
            if (this.gmode == 1) this.opselect = 0;
            if (this.gmode == 2) this.opselect = 1;
            this.app.gmode.hide();
            hidos();
            this.app.tnick.hide();
            this.app.tpass.hide();
            this.intertrack.stop();
        }
    }

    public void hidos() {
        this.app.sgame.hide();
        this.app.snfm1.hide();
        this.app.snfm2.hide();
        this.app.mstgs.hide();
    }

    public void hipnoload(int paramInt, boolean paramBoolean) {
        int[] arrayOfInt = {this.m.snap[0], this.m.snap[1], this.m.snap[2]};
        while (arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] < -30) {
            for (byte b1 = 0; b1 < 3; ) {
                if (arrayOfInt[b1] < 50) arrayOfInt[b1] = arrayOfInt[b1] + 1;
                b1++;
            }
        }
        int i = (int) (230.0F - 230.0F * arrayOfInt[0] / 100.0F);
        if (i > 255) i = 255;
        if (i < 0) i = 0;
        int j = (int) (230.0F - 230.0F * arrayOfInt[1] / 100.0F);
        if (j > 255) j = 255;
        if (j < 0) j = 0;
        int k = (int) (230.0F - 230.0F * arrayOfInt[2] / 100.0F);
        if (k > 255) k = 255;
        if (k < 0) k = 0;
        this.rd.setColor(new Color(i, j, k));
        this.rd.fillRect(65, 25, 670, 400);
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
        this.rd.drawImage(this.bggo, 0, -25, (ImageObserver) null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        drawcs(50, this.asay, 0, 0, 0, 3);
        byte b = -90;
        if (this.multion == 0) {
            if (paramInt == 1 || paramInt == 2 || paramInt == 3 || paramInt == 4 || paramInt == 5 || paramInt == 10)
                b = 0;
            if (paramInt == 11 || paramInt == 12 || paramInt == 13 || paramInt == 14 || paramInt == 17 || paramInt == 18 || paramInt == 19 || paramInt == 20 || paramInt == 22 || paramInt == 23 || paramInt == 26)
                b = 0;
            if (paramInt < 0 && this.nplayers != 1 && this.newparts) b = 0;
        } else if (this.ransay == 1 || this.ransay == 2 || this.ransay == 3 || this.ransay == 4 || paramInt == 10) {
            b = 0;
        }
        if (b == 0) {
            if (this.dudo > 0) {
                if (this.aflk) {
                    if (Math.random() > Math.random()) {
                        this.duds = (int) (Math.random() * 3.0D);
                    } else {
                        this.duds = (int) (Math.random() * 2.0D);
                    }
                    this.aflk = false;
                } else {
                    this.aflk = true;
                }
                this.dudo--;
            } else {
                this.duds = 0;
            }
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
            this.rd.drawImage(this.dude[this.duds], 95, 35, (ImageObserver) null);
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.7F));
            this.rd.drawImage(this.flaot, 192, 67, (ImageObserver) null);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            i = (int) (80.0F - 80.0F * arrayOfInt[0] / 100.0F);
            if (i > 255) i = 255;
            if (i < 0) i = 0;
            j = (int) (80.0F - 80.0F * arrayOfInt[1] / 100.0F);
            if (j > 255) j = 255;
            if (j < 0) j = 0;
            k = (int) (80.0F - 80.0F * arrayOfInt[2] / 100.0F);
            if (k > 255) k = 255;
            if (k < 0) k = 0;
            this.rd.setColor(new Color(i, j, k));
            this.rd.setFont(new Font("Arial", 1, 13));
            if (this.multion != 0) {
                if (this.ransay == 1 && paramInt != 10)
                    this.rd.drawString("Multiplayer Tip:  Press [ C ] to access chat quickly during the game!", 262, 92);
                if (this.ransay == 2 && paramInt != 10) {
                    this.rd.drawString("Multiplayer Tip:  Press [ A ] to make Guidance Arrow point to cars and", 262, 92);
                    this.rd.drawString("click any of the players listed on the right to lock the Arrow on!", 262, 112);
                }
                if (this.ransay == 3 && paramInt != 10) {
                    this.rd.drawString("Multiplayer Tip:  When wasting in multiplayer it's better to aim slightly", 262, 92);
                    this.rd.drawString("ahead of the other player's car to compensate for internet delay.", 262, 112);
                }
                if (this.ransay == 4) {
                    this.rd.drawString("When watching a game, click any player listed on the right of the", 262, 92);
                    this.rd.drawString("screen to follow and watch.", 262, 112);
                    this.rd.drawString("Press [ V ] to change the viewing mode!", 262, 132);
                }
                if (paramInt == 10 && this.ransay != 4) {
                    if (this.tflk) {
                        this.rd.setColor(new Color(200, j, k));
                        this.tflk = false;
                    } else {
                        this.tflk = true;
                    }
                    this.rd.drawString("NOTE: Guidance Arrow and opponent status is disabled in this stage!", 262, 92);
                }
            } else {
                if (paramInt < 0 && this.nplayers != 1 && this.newparts) {
                    this.rd.drawString("Please note, the computer car's AI has not yet been trained to handle", 262, 92);
                    this.rd.drawString("some of the new stage parts such as the 'Rollercoaster Road' and the", 262, 112);
                    this.rd.drawString("'Tunnel Side Ramp'.", 262, 132);
                    this.rd.drawString("(Those new parts where mostly designed for the multiplayer game.)", 262, 152);
                    this.rd.drawString("The AI will be trained and ready in the future releases of the game!", 262, 172);
                }
                if (paramInt == 1 || paramInt == 11) {
                    this.rd.drawString("Hey!  Don't forget, to complete a lap you must pass through", 262, 92);
                    this.rd.drawString("all checkpoints in the track!", 262, 112);
                }
                if (paramInt == 2 || paramInt == 12)
                    this.rd.drawString("Remember, the more power you have the faster your car will be!", 262, 92);
                if (paramInt == 3) {
                    this.rd.drawString("> Hint: its easier to waste the other cars then to race in this stage!", 262, 92);
                    this.rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to", 262, 112);
                    this.rd.drawString("the track.", 262, 132);
                }
                if (paramInt == 4)
                    this.rd.drawString("Remember, the better the stunt you perform the more power you get!", 262, 92);
                if (paramInt == 5)
                    this.rd.drawString("Remember, the more power you have the stronger your car is!", 262, 92);
                if (paramInt == 10) {
                    if (this.tflk) {
                        this.rd.setColor(new Color(200, j, k));
                        this.tflk = false;
                    } else {
                        this.tflk = true;
                    }
                    this.rd.drawString("NOTE: Guidance Arrow is disabled in this stage!", 262, 92);
                }
                if (paramInt == 13) {
                    this.rd.drawString("Watch out!  Look out!  The policeman might be out to get you!", 262, 92);
                    this.rd.drawString("Don't upset him or you'll be arrested!", 262, 112);
                    this.rd.drawString("Better run, run, run.", 262, 152);
                }
                if (paramInt == 14) {
                    this.rd.drawString("Don't waste your time.  Waste them instead!", 262, 92);
                    this.rd.drawString("Try a taste of sweet revenge here (if you can)!", 262, 112);
                    this.rd.drawString("Press [ A ] to make the guidance arrow point to cars instead of to", 262, 152);
                    this.rd.drawString("the track.", 262, 172);
                }
                if (paramInt == 17) {
                    this.rd.drawString("Welcome to the realm of the king...", 262, 92);
                    this.rd.drawString("The key word here is 'POWER'.  The more you have of it the faster", 262, 132);
                    this.rd.drawString("and STRONGER you car will be!", 262, 152);
                }
                if (paramInt == 18) {
                    this.rd.drawString("Watch out, EL KING is out to get you now!", 262, 92);
                    this.rd.drawString("He seems to be seeking revenge?", 262, 112);
                    this.rd.drawString("(To fly longer distances in the air try drifting your car on the ramp", 262, 152);
                    this.rd.drawString("before take off).", 262, 172);
                }
                if (paramInt == 19) this.rd.drawString("It’s good to be the king!", 262, 92);
                if (paramInt == 20) {
                    this.rd.drawString("Remember, forward loops give your car a push forwards in the air", 262, 92);
                    this.rd.drawString("and help in racing.", 262, 112);
                    this.rd.drawString("(You may need to do more forward loops here.  Also try keeping", 262, 152);
                    this.rd.drawString("your power at maximum at all times.  Try not to miss a ramp).", 262, 172);
                }
                if (paramInt == 22) {
                    this.rd.drawString("Watch out!  Beware!  Take care!", 262, 92);
                    this.rd.drawString("MASHEEN is hiding out there some where, don't get mashed now!", 262, 112);
                }
                if (paramInt == 23) {
                    this.rd.drawString("Anyone for a game of Digger?!", 262, 92);
                    this.rd.drawString("You can have fun using MASHEEN here!", 262, 112);
                }
                if (paramInt == 26) {
                    this.rd.drawString("This is it!  This is the toughest stage in the game!", 262, 92);
                    this.rd.drawString("This track is actually a 4D object projected onto the 3D world.", 262, 132);
                    this.rd.drawString("It's been broken down, separated and, in many ways, it is also a", 262, 152);
                    this.rd.drawString("maze!  GOOD LUCK!", 262, 172);
                }
            }
        }
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.8F));
        this.rd.drawImage(this.loadingmusic, 289, 205 + b, (ImageObserver) null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        int m = paramInt - 1;
        if (m < 0) m = 32;
        if (!paramBoolean) {
            drawcs(340 + b, "" + this.sndsize[m] + " KB", 0, 0, 0, 3);
            drawcs(375 + b, " Please Wait...", 0, 0, 0, 3);
        } else {
            drawcs(365 + b, "Loading complete!  Press Start to begin...", 0, 0, 0, 3);
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
            this.rd.drawImage(this.star[this.pstar], 359, 385 + b, (ImageObserver) null);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            if (this.pstar != 2) if (this.pstar == 0) {
                this.pstar = 1;
            } else {
                this.pstar = 0;
            }
            if (this.multion != 0) drawcs(380 + b, "" + (this.forstart / 20), 0, 0, 0, 3);
        }
    }

    public void loadmusic(int paramInt1, String paramString, int paramInt2) {
        hipnoload(paramInt1, false);
        this.app.setCursor(new Cursor(3));
        this.app.repaint();
        boolean bool = false;
        if (this.multion == 0) {
            if (paramInt1 == 1 || paramInt1 == 2 || paramInt1 == 3 || paramInt1 == 4 || paramInt1 == 5 || paramInt1 == 10)
                bool = true;
            if (paramInt1 == 11 || paramInt1 == 12 || paramInt1 == 13 || paramInt1 == 14 || paramInt1 == 17 || paramInt1 == 18 || paramInt1 == 19 || paramInt1 == 20 || paramInt1 == 22 || paramInt1 == 23 || paramInt1 == 26)
                bool = true;
            if (paramInt1 < 0 && this.nplayers != 1 && this.newparts) bool = true;
        } else if (this.ransay == 1 || this.ransay == 2 || this.ransay == 3 || this.ransay == 4 || paramInt1 == 10) {
            bool = true;
        }
        if (bool) {
            this.runtyp = paramInt1;
            this.runner = new Thread(this);
            this.runner.start();
        }
        loadstrack(paramInt1, paramString, paramInt2);
        if (bool) {
            this.runner.stop();
            this.runner = null;
            this.runtyp = 0;
        }
        System.gc();
        if (this.multion == 0 && this.app.applejava) try {
            Thread.sleep(1000L);
        } catch (InterruptedException interruptedException) {
        }
        if (!this.lan) {
            this.strack.play();
        } else if (this.im != 0) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException interruptedException) {
            }
        }
        this.app.setCursor(new Cursor(0));
        this.pcontin = 0;
        this.mutem = false;
        this.mutes = false;
        this.fase = 6;
    }

    public void loadstrack(int paramInt1, String paramString, int paramInt2) {
        if (paramInt1 == 1)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 240, 8400, 135, false, false);
        if (paramInt1 == 2)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 190, 9000, 145, false, false);
        if (paramInt1 == 3)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 170, 8500, 145, false, false);
        if (paramInt1 == 4)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 205, 7500, 125, false, false);
        if (paramInt1 == 5)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 170, 7900, 125, false, false);
        if (paramInt1 == 6)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 370, 7900, 125, false, false);
        if (paramInt1 == 7)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 205, 7500, 125, false, false);
        if (paramInt1 == 8)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 230, 7900, 125, false, false);
        if (paramInt1 == 9)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 180, 7900, 125, false, false);
        if (paramInt1 == 10)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 280, 8100, 145, false, false);
        if (paramInt1 == 11)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 120, 8000, 125, false, false);
        if (paramInt1 == 12)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 260, 7200, 125, false, false);
        if (paramInt1 == 13)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 270, 8000, 125, false, false);
        if (paramInt1 == 14)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 190, 8000, 125, false, false);
        if (paramInt1 == 15)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 162, 7800, 125, false, false);
        if (paramInt1 == 16)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 220, 7600, 125, false, false);
        if (paramInt1 == 17)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 300, 7500, 125, false, false);
        if (paramInt1 == 18)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 200, 7900, 125, false, false);
        if (paramInt1 == 19)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 200, 7900, 125, false, false);
        if (paramInt1 == 20)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 232, 7300, 125, false, false);
        if (paramInt1 == 21)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 370, 7900, 125, false, false);
        if (paramInt1 == 22)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 290, 7900, 125, false, false);
        if (paramInt1 == 23)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 222, 7600, 125, false, false);
        if (paramInt1 == 24)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 230, 8000, 125, false, false);
        if (paramInt1 == 25)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 220, 8000, 125, false, false);
        if (paramInt1 == 26)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 261, 8000, 125, false, false);
        if (paramInt1 == 27) if (this.gmode == 2) {
            this.strack = new RadicalMod("music/party.zip", 400, 7600, 125, false, false);
        } else {
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 276, 8800, 145, false, false);
        }
        if (paramInt1 == 28)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 182, 8000, 125, false, false);
        if (paramInt1 == 29)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 220, 8000, 125, false, false);
        if (paramInt1 == 30)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 200, 8000, 125, false, false);
        if (paramInt1 == 31)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 350, 7900, 125, false, false);
        if (paramInt1 == 32)
            this.strack = new RadicalMod("music/stage" + paramInt1 + ".zip", 310, 8000, 125, false, false);
        if (paramInt1 < 0) if (!paramString.equals("")) {
            if (paramInt1 != -2) {
                this.strack = new RadicalMod("mystages/mymusic/" + paramString + ".zip", paramInt2, 8000, 125, false, false);
            } else {
                this.strack = new RadicalMod(paramString, paramInt2, 8000, 125, false, true);
            }
        } else {
            this.strack = new RadicalMod();
        }
        this.loadedt = true;
    }

    public void musicomp(int paramInt, Control paramControl) {
        hipnoload(paramInt, true);
        if (this.multion != 0) {
            this.forstart--;
            if (this.lan && this.im == 0) this.forstart = 0;
        }
        if (paramControl.handb || paramControl.enter || this.forstart == 0) {
            System.gc();
            this.m.trk = 0;
            this.m.crs = false;
            this.m.ih = 0;
            this.m.iw = 0;
            this.m.h = 450;
            this.m.w = 800;
            this.m.focus_point = 400;
            this.m.cx = 400;
            this.m.cy = 225;
            this.m.cz = 50;
            this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
            this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            if (this.multion == 0) {
                this.fase = 0;
            } else {
                this.fase = 7001;
                this.forstart = 0;
                if (!this.lan) try {
                    this.socket = new Socket(this.server, this.servport);
                    this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                    this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                    this.runtyp = -101;
                    this.runner = new Thread(this);
                    this.runner.start();
                } catch (Exception exception) {
                }
            }
            if (Math.random() > Math.random()) {
                this.dudo = 250;
            } else {
                this.dudo = 428;
            }
            paramControl.handb = false;
            paramControl.enter = false;
        }
    }

    public void waitenter() {
        if (this.forstart < 690) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            drawcs(70, "Waiting for all players to finish loading!", 0, 0, 0, 0);
            if (this.forstart <= 640) {
                drawcs(90, "" + ((640 - this.forstart) / 32) + "", 0, 0, 0, 0);
            } else {
                drawcs(90, "Your connection to game may have been lost...", 0, 0, 0, 0);
            }
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            if (this.tflk) {
                drawcs(125, "Get Ready!", 0, 0, 0, 0);
                this.tflk = false;
            } else {
                drawcs(125, "Get Ready!", 0, 128, 255, 0);
                this.tflk = true;
            }
        }
        this.forstart++;
        if (this.forstart == 700) {
            this.fase = -2;
            this.winner = false;
        }
    }

    public void multistat(Control paramControl, CheckPoints paramCheckPoints, int paramInt1, int paramInt2, boolean paramBoolean, UDPMistro paramUDPMistro) {
        byte b = -1;
        if (this.fase != -2) {
            if (this.exitm != 0 && !this.holdit) {
                if (!this.lan || this.im != 0) {
                    if (paramBoolean) if (paramInt1 > 357 && paramInt1 < 396 && paramInt2 > 162 && paramInt2 < 179) {
                        this.exitm = 2;
                        if (this.multion == 1 && !this.lan && this.sendstat == 0) {
                            this.sendstat = 1;
                            if (this.runtyp != -101) {
                                if (this.runner != null) this.runner.stop();
                                this.runner = new Thread(this);
                                this.runner.start();
                            }
                        }
                    } else {
                        this.exitm = 0;
                    }
                    float[] arrayOfFloat = new float[3];
                    Color.RGBtoHSB(this.m.cgrnd[0], this.m.cgrnd[1], this.m.cgrnd[2], arrayOfFloat);
                    arrayOfFloat[1] = (float) (arrayOfFloat[1] - 0.15D);
                    if (arrayOfFloat[1] < 0.0F) arrayOfFloat[1] = 0.0F;
                    arrayOfFloat[2] = (float) (arrayOfFloat[2] + 0.15D);
                    if (arrayOfFloat[2] > 1.0F) arrayOfFloat[2] = 1.0F;
                    this.rd.setColor(Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]));
                    this.rd.fillRect(357, 169, 39, 10);
                    this.rd.fillRect(403, 169, 39, 10);
                    arrayOfFloat[1] = (float) (arrayOfFloat[1] - 0.07D);
                    if (arrayOfFloat[1] < 0.0F) arrayOfFloat[1] = 0.0F;
                    arrayOfFloat[2] = (float) (arrayOfFloat[2] + 0.07D);
                    if (arrayOfFloat[2] > 1.0F) arrayOfFloat[2] = 1.0F;
                    this.rd.setColor(Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]));
                    this.rd.fillRect(357, 162, 39, 7);
                    this.rd.fillRect(403, 162, 39, 7);
                    drawhi(this.exitgame, 116);
                    if (paramInt1 > 357 && paramInt1 < 396 && paramInt2 > 162 && paramInt2 < 179) {
                        this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                        this.rd.fillRect(357, 162, 39, 17);
                    }
                    if (paramInt1 > 403 && paramInt1 < 442 && paramInt2 > 162 && paramInt2 < 179) {
                        this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                        this.rd.fillRect(403, 162, 39, 17);
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Yes", 366, 175);
                    this.rd.drawString("No", 416, 175);
                    this.rd.setColor(new Color(this.m.csky[0] / 2, this.m.csky[1] / 2, this.m.csky[2] / 2));
                    this.rd.drawRect(403, 162, 39, 17);
                    this.rd.drawRect(357, 162, 39, 17);
                } else {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    drawcs(125, "You cannot exit game.  Your computer is the LAN server!", 0, 0, 0, 0);
                    this.msgflk[0] = this.msgflk[0] + 1;
                    if (this.msgflk[0] == 67 || paramBoolean) {
                        this.msgflk[0] = 0;
                        this.exitm = 0;
                    }
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                }
            } else if (this.exitm == 4) {
                if (paramBoolean) {
                    if (paramInt1 > 357 && paramInt1 < 396 && paramInt2 > 362 && paramInt2 < 379) {
                        this.alocked = -1;
                        this.lalocked = -1;
                        paramControl.multion = this.multion = 2;
                        this.holdit = false;
                        this.exitm = 0;
                        paramControl.chatup = 0;
                    }
                    if ((!this.lan || this.im != 0) && paramInt1 > 403 && paramInt1 < 442 && paramInt2 > 362 && paramInt2 < 379) {
                        this.holdcnt = 600;
                        this.exitm = 0;
                        paramControl.chatup = 0;
                    }
                }
                float[] arrayOfFloat = new float[3];
                Color.RGBtoHSB(this.m.cgrnd[0], this.m.cgrnd[1], this.m.cgrnd[2], arrayOfFloat);
                arrayOfFloat[1] = (float) (arrayOfFloat[1] - 0.15D);
                if (arrayOfFloat[1] < 0.0F) arrayOfFloat[1] = 0.0F;
                arrayOfFloat[2] = (float) (arrayOfFloat[2] + 0.15D);
                if (arrayOfFloat[2] > 1.0F) arrayOfFloat[2] = 1.0F;
                this.rd.setColor(Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]));
                this.rd.fillRect(357, 369, 39, 10);
                if (!this.lan || this.im != 0) this.rd.fillRect(403, 369, 39, 10);
                arrayOfFloat[1] = (float) (arrayOfFloat[1] - 0.07D);
                if (arrayOfFloat[1] < 0.0F) arrayOfFloat[1] = 0.0F;
                arrayOfFloat[2] = (float) (arrayOfFloat[2] + 0.07D);
                if (arrayOfFloat[2] > 1.0F) arrayOfFloat[2] = 1.0F;
                this.rd.setColor(Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]));
                this.rd.fillRect(357, 362, 39, 7);
                if (!this.lan || this.im != 0) this.rd.fillRect(403, 362, 39, 7);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (this.lan && this.im == 0)
                    drawcs(140, "( You cannot exit game.  Your computer is the LAN server... )", 0, 0, 0, 0);
                this.rd.drawString("Continue watching this game?", 155, 375);
                if (paramInt1 > 357 && paramInt1 < 396 && paramInt2 > 362 && paramInt2 < 379) {
                    this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                    this.rd.fillRect(357, 362, 39, 17);
                }
                if (!this.lan || this.im != 0)
                    if (paramInt1 > 403 && paramInt1 < 442 && paramInt2 > 362 && paramInt2 < 379) {
                        this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
                        this.rd.fillRect(403, 362, 39, 17);
                    }
                this.rd.setFont(new Font("Arial", 1, 11));
                this.ftm = this.rd.getFontMetrics();
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString("Yes", 366, 375);
                if (!this.lan || this.im != 0) this.rd.drawString("No", 416, 375);
                this.rd.setColor(new Color(this.m.csky[0] / 2, this.m.csky[1] / 2, this.m.csky[2] / 2));
                if (!this.lan || this.im != 0) {
                    this.rd.drawRoundRect(147, 357, 301, 27, 7, 20);
                } else {
                    this.rd.drawRoundRect(147, 357, 262, 27, 7, 20);
                }
                this.rd.drawRect(357, 362, 39, 17);
                if (!this.lan || this.im != 0) this.rd.drawRect(403, 362, 39, 17);
            }
            if (this.runtyp == -101 && !this.lan) {
                if (this.warning == 0 || this.warning == 210) {
                    byte b1 = 0;
                    byte b2 = 0;
                    if (this.clanchat) {
                        b1 = 1;
                        b2 = -23;
                    } else if (paramControl.chatup == 2) {
                        paramControl.chatup = 1;
                    }
                    for (byte b3 = b1; b3>=0; b3--) {
                        boolean bool1 = false;
                        if (paramInt1 > 5 && paramInt1 < 33 && paramInt2 > 423 + b2 && paramInt2 < 446 + b2) {
                            bool1 = true;
                            if (paramControl.chatup != 0) paramControl.chatup = 0;
                        } else if (this.pointc[b3] != 6) {
                            this.pointc[b3] = 6;
                            this.floater[b3] = 1;
                        }
                        if (paramInt1 > 33 && paramInt1 < 666 && paramInt2 > 423 + b2 && paramInt2 < 446 + b2 && this.lxm != paramInt1 && paramInt2 != this.lym && this.lxm != -100) {
                            paramControl.chatup = b3 + 1;
                            this.cntchatp[b3] = 0;
                        }
                        if (b3 == 0) {
                            this.lxm = paramInt1;
                            this.lym = paramInt2;
                        }
                        if (this.exitm != 0 && this.exitm != 4) paramControl.chatup = 0;
                        boolean bool2 = false;
                        if (paramControl.enter && paramControl.chatup == b3 + 1) {
                            bool2 = true;
                            paramControl.chatup = 0;
                            paramControl.enter = false;
                            this.lxm = -100;
                        }
                        if (paramBoolean) {
                            if (this.mouson == 0) {
                                if (paramInt1 > 676 && paramInt1 < 785 && paramInt2 > 426 + b2 && paramInt2 < 443 + b2 && paramControl.chatup == b3 + 1) {
                                    bool2 = true;
                                    paramControl.chatup = 0;
                                }
                                if (bool1 && this.pointc[b3] > 0) {
                                    this.pointc[b3] = this.pointc[b3] - 1;
                                    this.floater[b3] = 1;
                                }
                                if (b3 == 0) this.mouson = 1;
                            }
                            if (b3 == 0) paramControl.chatup = 0;
                        } else if (b3 == 0 && this.mouson != 0) {
                            this.mouson = 0;
                        }
                        if (bool2) {
                            String str = "";
                            byte b4 = 0, b5 = 1;
                            while (b4 < this.lcmsg[b3].length()) {
                                String str1 = "" + this.lcmsg[b3].charAt(b4);
                                if (str1.equals(" ")) {
                                    b5++;
                                } else {
                                    b5 = 0;
                                }
                                if (b5 < 2) str = str + str1;
                                b4++;
                            }
                            if (!str.equals("")) {
                                str = str.replace('|', ':');
                                if (str.toLowerCase().indexOf(this.app.tpass.getText().toLowerCase()) != -1) str = " ";
                                if (!msgcheck(str) && this.updatec[b3] > -12) {
                                    if (this.cnames[b3][6].equals("Game Chat  ") || this.cnames[b3][6].equals("" + this.clan + "'s Chat  "))
                                        this.cnames[b3][6] = "";
                                    for (byte b6 = 0; b6 < 6; ) {
                                        this.sentn[b3][b6] = this.sentn[b3][b6 + 1];
                                        this.cnames[b3][b6] = this.cnames[b3][b6 + 1];
                                        b6++;
                                    }
                                    this.sentn[b3][6] = str;
                                    this.cnames[b3][6] = this.nickname;
                                    if (this.pointc[b3] != 6) {
                                        this.pointc[b3] = 6;
                                        this.floater[b3] = 1;
                                    }
                                    this.msgflk[b3] = 110;
                                    if (this.updatec[b3] > -11) {
                                        this.updatec[b3] = -11;
                                    } else {
                                        this.updatec[b3] = this.updatec[b3] - 1;
                                    }
                                } else {
                                    this.warning++;
                                }
                            }
                        }
                        if (bool1 || this.floater[b3] != 0 || paramControl.chatup == b3 + 1 || this.msgflk[b3] != 0) {
                            float[] arrayOfFloat = new float[3];
                            Color.RGBtoHSB(this.m.cgrnd[0], this.m.cgrnd[1], this.m.cgrnd[2], arrayOfFloat);
                            arrayOfFloat[1] = (float) (arrayOfFloat[1] - 0.15D);
                            if (arrayOfFloat[1] < 0.0F) arrayOfFloat[1] = 0.0F;
                            arrayOfFloat[2] = (float) (arrayOfFloat[2] + 0.15D);
                            if (arrayOfFloat[2] > 1.0F) arrayOfFloat[2] = 1.0F;
                            this.rd.setColor(Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]));
                            this.rd.fillRect(33, 423 + b2, 761, 23);
                        }
                        if (paramControl.chatup == 0 && this.app.cmsg.isShowing()) {
                            this.app.cmsg.hide();
                            this.app.requestFocus();
                        }
                        if (paramControl.chatup != b3 + 1) {
                            int i = 0;
                            int j = (int) (48.0F + 48.0F * this.m.snap[1] / 100.0F);
                            if (j > 255) j = 255;
                            if (j < 0) j = 0;
                            int k = (int) (96.0F + 96.0F * this.m.snap[2] / 100.0F);
                            if (k > 255) k = 255;
                            if (k < 0) k = 0;
                            if (this.floater[b3] != 0) {
                                for (byte b4 = 6; b4 >= 0; b4--) {
                                    if (this.pointc[b3] == b4) if (Math.abs(i + this.movepos[b3]) > 10) {
                                        this.floater[b3] = (this.movepos[b3] + i) / 4;
                                        if (this.floater[b3] > -5 && this.floater[b3] < 0) this.floater[b3] = -5;
                                        if (this.floater[b3] < 10 && this.floater[b3] > 0) this.floater[b3] = 10;
                                        this.movepos[b3] = this.movepos[b3] - this.floater[b3];
                                    } else {
                                        this.movepos[b3] = -i;
                                        this.floater[b3] = 0;
                                    }
                                    if (this.pointc[b3] >= b4) {
                                        this.rd.setColor(new Color(0, j, k));
                                        this.rd.setFont(new Font("Tahoma", 1, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString(this.cnames[b3][b4] + ": ", 39 + i + this.movepos[b3], 439 + b2);
                                        i += this.ftm.stringWidth(this.cnames[b3][b4] + ": ");
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.setFont(new Font("Tahoma", 0, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString(this.sentn[b3][b4] + "   ", 39 + i + this.movepos[b3], 439 + b2);
                                        i += this.ftm.stringWidth(this.sentn[b3][b4] + "   ");
                                    } else {
                                        i += this.ftm.stringWidth(this.cnames[b3][b4] + ": ");
                                        i += this.ftm.stringWidth(this.sentn[b3][b4] + "   ");
                                    }
                                }
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.fillRect(0, 423 + b2, 5, 24);
                                this.rd.fillRect(794, 423 + b2, 6, 24);
                            } else {
                                for (int m = this.pointc[b3]; m >= 0; m--) {
                                    if (m == 6 && this.msgflk[b3] != 0) this.msgflk[b3] = this.msgflk[b3] - 1;
                                    this.rd.setColor(new Color(0, j, k));
                                    this.rd.setFont(new Font("Tahoma", 1, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    if (this.ftm.stringWidth(this.cnames[b3][m] + ": ") + 39 + i < 775) {
                                        if (m != 6 || this.msgflk[b3] < 67 || this.msgflk[b3] % 3 != 0)
                                            this.rd.drawString(this.cnames[b3][m] + ": ", 39 + i, 439 + b2);
                                        i += this.ftm.stringWidth(this.cnames[b3][m] + ": ");
                                    } else {
                                        String str = "";
                                        byte b4 = 0;
                                        while (this.ftm.stringWidth(str) + 39 + i < 775 && b4 < this.cnames[b3][m].length()) {
                                            str = str + this.cnames[b3][m].charAt(b4);
                                            b4++;
                                        }
                                        str = str + "...";
                                        if (m != 6 || this.msgflk[b3] < 67 || this.msgflk[b3] % 3 != 0)
                                            this.rd.drawString(str, 39 + i, 439 + b2);
                                        break;
                                    }
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    if (this.ftm.stringWidth(this.sentn[b3][m]) + 39 + i < 775) {
                                        if (m != 6 || this.msgflk[b3] < 67 || this.msgflk[b3] % 3 != 0)
                                            this.rd.drawString(this.sentn[b3][m] + "   ", 39 + i, 439 + b2);
                                        i += this.ftm.stringWidth(this.sentn[b3][m] + "   ");
                                    } else {
                                        String str = "";
                                        byte b4 = 0;
                                        while (this.ftm.stringWidth(str) + 39 + i < 775 && b4 < this.sentn[b3][m].length()) {
                                            str = str + this.sentn[b3][m].charAt(b4);
                                            b4++;
                                        }
                                        str = str + "...";
                                        if (m != 6 || this.msgflk[b3] < 67 || this.msgflk[b3] % 3 != 0)
                                            this.rd.drawString(str, 39 + i, 439 + b2);
                                        break;
                                    }
                                }
                            }
                        } else {
                            this.msgflk[b3] = 0;
                            b = b3;
                        }
                        if (bool1 || this.floater[b3] != 0) {
                            float[] arrayOfFloat = new float[3];
                            Color.RGBtoHSB(this.m.cgrnd[0], this.m.cgrnd[1], this.m.cgrnd[2], arrayOfFloat);
                            arrayOfFloat[1] = (float) (arrayOfFloat[1] - 0.076D);
                            if (arrayOfFloat[1] < 0.0F) arrayOfFloat[1] = 0.0F;
                            arrayOfFloat[2] = (float) (arrayOfFloat[2] + 0.076D);
                            if (arrayOfFloat[2] > 1.0F) arrayOfFloat[2] = 1.0F;
                            this.rd.setColor(Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]));
                            this.rd.fillRect(5, 423 + b2, 28, 23);
                        }
                        if (bool1) {
                            this.rd.setColor(new Color(0, 0, 0));
                        } else {
                            this.rd.setColor(new Color((int) (this.m.cgrnd[0] / 2.0F), (int) (this.m.cgrnd[1] / 2.0F), (int) (this.m.cgrnd[2] / 2.0F)));
                        }
                        this.rd.setFont(new Font("Tahoma", 1, 11));
                        this.rd.drawString("<<", 10, 439 + b2);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRect(5, 423 + b2, 789, 23);
                        this.rd.drawLine(33, 423 + b2, 33, 446 + b2);
                        b2 += 23;
                    }
                    if (paramInt1 > 775 && paramInt1 < 794 && paramInt2 > 409 - b1 * 23 && paramInt2 < 423 - b1 * 23) {
                        this.rd.drawRect(775, 409 - b1 * 23, 19, 14);
                        this.rd.setColor(new Color(200, 0, 0));
                        if (paramBoolean) {
                            paramControl.chatup = 0;
                            if (this.app.cmsg.isShowing()) {
                                this.app.cmsg.hide();
                                this.app.requestFocus();
                            }
                            this.runtyp = 0;
                            try {
                                this.socket.close();
                                this.socket = null;
                                this.din.close();
                                this.din = null;
                                this.dout.close();
                                this.dout = null;
                            } catch (Exception exception) {
                            }
                        }
                    }
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.drawString("x", 782, 420 - b1 * 23);
                } else {
                    drawWarning();
                    if (this.app.cmsg.isShowing()) {
                        this.app.cmsg.hide();
                        this.app.requestFocus();
                    }
                    this.warning++;
                }
                this.rd.setFont(new Font("Arial", 1, 11));
                this.ftm = this.rd.getFontMetrics();
            } else if (paramControl.chatup != 0) {
                paramControl.chatup = 0;
                if (!this.lan) {
                    this.runtyp = -101;
                    if (this.runner != null) this.runner.stop();
                    this.runner = new Thread(this);
                    this.runner.start();
                }
            }
            if (this.holdit && this.multion == 1 && !this.lan && this.sendstat == 0) {
                this.sendstat = 1;
                if (this.runtyp != -101) {
                    if (this.runner != null) this.runner.stop();
                    this.runner = new Thread(this);
                    this.runner.start();
                }
            }
            if ((paramControl.arrace && this.starcnt < 38 && !this.holdit && paramCheckPoints.stage != 10) || this.multion >= 2) {
                if (this.alocked != -1 && paramCheckPoints.dested[this.alocked] != 0) {
                    this.alocked = -1;
                    this.lalocked = -1;
                }
                if (this.multion >= 2) {
                    if (this.alocked == -1 || this.holdit) {
                        if (this.cntflock == 100) for (byte b2 = 0; b2 < this.nplayers; ) {
                            if (this.holdit) {
                                if (paramCheckPoints.pos[b2] == 0) {
                                    this.alocked = b2;
                                    this.im = b2;
                                }
                            } else if (paramCheckPoints.dested[b2] == 0) {
                                this.alocked = b2;
                                this.im = b2;
                            }
                            b2++;
                        }
                        this.cntflock++;
                    } else {
                        this.cntflock = 0;
                    }
                    if (this.lan) {
                        boolean bool;
                        byte b2;
                        for (bool = true, b2 = 0; b2 < this.nplayers; ) {
                            if (this.dested[b2] == 0 && this.plnames[b2].indexOf("MadBot") == -1) bool = false;
                            b2++;
                        }
                        if (bool) this.exitm = 2;
                    }
                }
                int i = this.nplayers;
                for (byte b1 = 0; b1 < i; b1++) {
                    boolean bool = false;
                    for (byte b2 = 0; b2 < this.nplayers; b2++) {
                        if (paramCheckPoints.pos[b2] == b1 && paramCheckPoints.dested[b2] == 0 && !bool) {
                            int j = 0, k = 0, m = 0;
                            m = (int) (100.0F + 100.0F * this.m.snap[2] / 100.0F);
                            if (m > 255) m = 255;
                            if (m < 0) m = 0;
                            this.rd.setColor(new Color(0, 0, m));
                            if (b1 == 0) this.rd.drawString("1st", 673, 76 + 30 * b1);
                            if (b1 == 1) this.rd.drawString("2nd", 671, 76 + 30 * b1);
                            if (b1 == 2) this.rd.drawString("3rd", 671, 76 + 30 * b1);
                            if (b1 >= 3) this.rd.drawString("" + (b1 + 1) + "th", 671, 76 + 30 * b1);
                            if (this.clangame != 0) {
                                if (this.pclan[b2].toLowerCase().equals(this.gaclan.toLowerCase())) {
                                    j = 255;
                                    k = 128;
                                    m = 0;
                                } else {
                                    j = 0;
                                    k = 128;
                                    m = 255;
                                }
                                j = (int) (j + j * this.m.snap[0] / 100.0F);
                                if (j > 255) j = 255;
                                if (j < 0) j = 0;
                                k = (int) (k + k * this.m.snap[1] / 100.0F);
                                if (k > 255) k = 255;
                                if (k < 0) k = 0;
                                m = (int) (m + m * this.m.snap[2] / 100.0F);
                                if (m > 255) m = 255;
                                if (m < 0) m = 0;
                                this.rd.setColor(new Color(j, k, m));
                                this.rd.drawString(this.plnames[b2], 731 - this.ftm.stringWidth(this.plnames[b2]) / 2, 70 + 30 * b1);
                            }
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawString(this.plnames[b2], 730 - this.ftm.stringWidth(this.plnames[b2]) / 2, 70 + 30 * b1);
                            int n = (int) (60.0F * paramCheckPoints.magperc[b2]);
                            j = 244;
                            k = 244;
                            m = 11;
                            if (n > 20) k = (int) (244.0F - 233.0F * (n - 20) / 40.0F);
                            j = (int) (j + j * this.m.snap[0] / 100.0F);
                            if (j > 255) j = 255;
                            if (j < 0) j = 0;
                            k = (int) (k + k * this.m.snap[1] / 100.0F);
                            if (k > 255) k = 255;
                            if (k < 0) k = 0;
                            m = (int) (m + m * this.m.snap[2] / 100.0F);
                            if (m > 255) m = 255;
                            if (m < 0) m = 0;
                            this.rd.setColor(new Color(j, k, m));
                            this.rd.fillRect(700, 74 + 30 * b1, n, 5);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRect(700, 74 + 30 * b1, 60, 5);
                            boolean bool1 = false;
                            if ((this.im != b2 || this.multion >= 2) && paramInt1 > 661 && paramInt1 < 775 && paramInt2 > 58 + 30 * b1 && paramInt2 < 83 + 30 * b1) {
                                bool1 = true;
                                if (paramBoolean) {
                                    if (!this.onlock) if (this.alocked != b2 || this.multion >= 2) {
                                        this.alocked = b2;
                                        if (this.multion >= 2) this.im = b2;
                                    } else {
                                        this.alocked = -1;
                                    }
                                    this.onlock = true;
                                } else if (this.onlock) {
                                    this.onlock = false;
                                }
                            }
                            if (this.alocked == b2) {
                                j = (int) (159.0F + 159.0F * this.m.snap[0] / 100.0F);
                                if (j > 255) j = 255;
                                if (j < 0) j = 0;
                                k = (int) (207.0F + 207.0F * this.m.snap[1] / 100.0F);
                                if (k > 255) k = 255;
                                if (k < 0) k = 0;
                                m = (int) (255.0F + 255.0F * this.m.snap[2] / 100.0F);
                                if (m > 255) m = 255;
                                if (m < 0) m = 0;
                                this.rd.setColor(new Color(j, k, m));
                                this.rd.drawRect(661, 58 + 30 * b1, 114, 25);
                                this.rd.drawRect(662, 59 + 30 * b1, 112, 23);
                            }
                            if (bool1 && !this.onlock) {
                                if (this.alocked == b2) {
                                    j = (int) (120.0F + 120.0F * this.m.snap[0] / 100.0F);
                                    if (j > 255) j = 255;
                                    if (j < 0) j = 0;
                                    k = (int) (114.0F + 114.0F * this.m.snap[1] / 100.0F);
                                    if (k > 255) k = 255;
                                    if (k < 0) k = 0;
                                    m = (int) (255.0F + 255.0F * this.m.snap[2] / 100.0F);
                                    if (m > 255) m = 255;
                                    if (m < 0) m = 0;
                                } else {
                                    j = (int) (140.0F + 140.0F * this.m.snap[0] / 100.0F);
                                    if (j > 255) j = 255;
                                    if (j < 0) j = 0;
                                    k = (int) (160.0F + 160.0F * this.m.snap[1] / 100.0F);
                                    if (k > 255) k = 255;
                                    if (k < 0) k = 0;
                                    m = (int) (255.0F + 255.0F * this.m.snap[2] / 100.0F);
                                    if (m > 255) m = 255;
                                    if (m < 0) m = 0;
                                }
                                this.rd.setColor(new Color(j, k, m));
                                this.rd.drawRect(660, 57 + 30 * b1, 116, 27);
                            }
                            bool = true;
                        }
                    }
                }
            }
            if (paramUDPMistro.go && paramUDPMistro.runon == 1 && !this.holdit) {
                byte b1 = 0, b2 = 0;
                for (byte b3 = 0; b3 < this.nplayers; ) {
                    if (b3 != paramUDPMistro.im) {
                        b2++;
                        if (paramUDPMistro.lframe[b3] == paramUDPMistro.lcframe[b3] || paramUDPMistro.force[b3] == 7) {
                            b1++;
                        } else {
                            paramUDPMistro.lcframe[b3] = paramUDPMistro.lframe[b3];
                        }
                    }
                    b3++;
                }
                if (b1 == b2) {
                    this.discon++;
                } else if (this.discon != 0) {
                    this.discon = 0;
                }
                if (this.discon == 240) paramUDPMistro.runon = 2;
            }
        }
        if (b != -1) {
            float[] arrayOfFloat = new float[3];
            Color.RGBtoHSB(this.m.cgrnd[0], this.m.cgrnd[1], this.m.cgrnd[2], arrayOfFloat);
            arrayOfFloat[1] = (float) (arrayOfFloat[1] - 0.22D);
            if (arrayOfFloat[1] < 0.0F) arrayOfFloat[1] = 0.0F;
            arrayOfFloat[2] = (float) (arrayOfFloat[2] + 0.22D);
            if (arrayOfFloat[2] > 1.0F) arrayOfFloat[2] = 1.0F;
            Color color = Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
            this.rd.setColor(color);
            this.rd.fillRect(676, 426 - b * 23, 109, 7);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Tahoma", 1, 11));
            this.rd.drawString("Send Message  >", 684, 439 - b * 23);
            this.rd.setColor(new Color((int) (this.m.cgrnd[0] / 1.2F), (int) (this.m.cgrnd[1] / 1.2F), (int) (this.m.cgrnd[2] / 1.2F)));
            this.rd.drawRect(676, 426 - b * 23, 109, 17);
            if (!this.app.cmsg.isShowing()) {
                this.app.cmsg.show();
                this.app.cmsg.requestFocus();
                this.lcmsg[b] = "";
                this.app.cmsg.setText("");
                this.app.cmsg.setBackground(color);
            }
            this.app.movefield(this.app.cmsg, 34, 424 - b * 23, 633, 22);
            if (this.app.cmsg.getText().equals(this.lcmsg[b])) {
                this.cntchatp[b] = this.cntchatp[b] + 1;
            } else {
                this.cntchatp[b] = -200;
            }
            this.lcmsg[b] = "" + this.app.cmsg.getText();
            if (this.cntchatp[b] == 67) paramControl.chatup = 0;
            if (this.app.cmsg.getText().length() > 100) {
                this.app.cmsg.setText(this.app.cmsg.getText().substring(0, 100));
                this.app.cmsg.select(100, 100);
            }
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
        }
    }

    public void levelhigh(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        this.rd.drawImage(this.gameh, 301, 20, (ImageObserver) null);
        byte b = 16;
        char c1 = '0', c2 = '`';
        if (paramInt4 < 50) if (this.aflk) {
            b = 106;
            c1 = '°';
            c2 = 'ÿ';
            this.aflk = false;
        } else {
            this.aflk = true;
        }
        if (paramInt1 != this.im) {
            if (paramInt3 == 0) {
                drawcs(60, "You Wasted 'em!", b, c1, c2, 0);
            } else if (paramInt3 == 1) {
                drawcs(60, "Close Finish!", b, c1, c2, 0);
            } else {
                drawcs(60, "Close Finish!  Almost got it!", b, c1, c2, 0);
            }
        } else if (paramInt2 == 229) {
            if (this.discon != 240) {
                drawcs(60, "Wasted!", b, c1, c2, 0);
            } else {
                drawcs(60, "Disconnected!", b, c1, c2, 0);
            }
        } else if (paramInt5 > 2 || paramInt5 < 0) {
            drawcs(60, "Stunts!", b, c1, c2, 0);
        } else {
            drawcs(60, "Best Stunt!", b, c1, c2, 0);
        }
        drawcs(380, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
    }

    public void inst(Control paramControl) {
        if (this.flipo == 0) this.flipo = 1;
        if (this.flipo == 2) {
            this.flipo = 3;
            this.dudo = 200;
        }
        if (this.flipo == 4) {
            this.flipo = 5;
            this.dudo = 250;
        }
        if (this.flipo == 6) {
            this.flipo = 7;
            this.dudo = 200;
        }
        if (this.flipo == 8) {
            this.flipo = 9;
            this.dudo = 250;
        }
        if (this.flipo == 10) {
            this.flipo = 11;
            this.dudo = 200;
        }
        if (this.flipo == 12) {
            this.flipo = 13;
            this.dudo = 200;
        }
        if (this.flipo == 14) {
            this.flipo = 15;
            this.dudo = 100;
        }
        mainbg(2);
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
        this.rd.drawImage(this.bggo, 65, 25, (ImageObserver) null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 425, 670, 25);
        if (this.aflk) {
            this.aflk = false;
        } else {
            this.aflk = true;
        }
        if (this.flipo != 1 && this.flipo != 16) {
            if (this.dudo > 0) {
                if (this.aflk) if (Math.random() > Math.random()) {
                    this.duds = (int) (Math.random() * 3.0D);
                } else {
                    this.duds = (int) (Math.random() * 2.0D);
                }
                this.dudo--;
            } else {
                this.duds = 0;
            }
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
            this.rd.drawImage(this.dude[this.duds], 95, 15, (ImageObserver) null);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            this.rd.drawImage(this.oflaot, 192, 42, (ImageObserver) null);
        }
        this.rd.setColor(new Color(0, 64, 128));
        this.rd.setFont(new Font("Arial", 1, 13));
        if (this.flipo == 3 || this.flipo == 5) {
            if (this.flipo == 3) {
                this.rd.drawString("Hello!  Welcome to the world of", 262, 67);
                this.rd.drawString("!", 657, 67);
                this.rd.drawImage(this.nfm, 469, 55, (ImageObserver) null);
                this.rd.drawString("In this game there are two ways to complete a stage.", 262, 107);
                this.rd.drawString("One is by racing and finishing in first place, the other is by", 262, 127);
                this.rd.drawString("wasting and crashing all the other cars in the stage!", 262, 147);
            } else {
                this.rd.setColor(new Color(0, 128, 255));
                this.rd.drawString("While racing, you will need to focus on going fast and passing", 262, 67);
                this.rd.drawString("through all the checkpoints in the track. To complete a lap, you", 262, 87);
                this.rd.drawString("must not miss a checkpoint.", 262, 107);
                this.rd.drawString("While wasting, you will just need to chase the other cars and", 262, 127);
                this.rd.drawString("crash into them (without worrying about track and checkpoints).", 262, 147);
            }
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawImage(this.racing, 165, 185, (ImageObserver) null);
            this.rd.drawImage(this.ory, 429, 235, (ImageObserver) null);
            this.rd.drawImage(this.wasting, 492, 185, (ImageObserver) null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.drawString("Checkpoint", 392, 189);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.rd.drawString("Drive your car using the Arrow Keys and Spacebar", 125, 320);
            this.rd.drawImage(this.space, 171, 355, (ImageObserver) null);
            this.rd.drawImage(this.arrows, 505, 323, (ImageObserver) null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.drawString("(When your car is on the ground Spacebar is for Handbrake)", 125, 341);
            this.rd.drawString("Accelerate", 515, 319);
            this.rd.drawString("Brake/Reverse", 506, 397);
            this.rd.drawString("Turn left", 454, 375);
            this.rd.drawString("Turn right", 590, 375);
            this.rd.drawString("Handbrake", 247, 374);
        }
        if (this.flipo == 7 || this.flipo == 9) {
            if (this.flipo == 7) {
                this.rd.drawString("Whether you are racing or wasting the other cars you will need", 262, 67);
                this.rd.drawString("to power up your car.", 262, 87);
                this.rd.drawString("=> More 'Power' makes your car become faster and stronger!", 262, 107);
                this.rd.drawString("To power up your car (and keep it powered up) you will need to", 262, 127);
                this.rd.drawString("perform stunts!", 262, 147);
                this.rd.drawImage(this.chil, 167, 295, (ImageObserver) null);
            } else {
                this.rd.drawString("The better the stunt the more power you get!", 262, 67);
                this.rd.setColor(new Color(0, 128, 255));
                this.rd.drawString("Forward looping pushes your car forwards in the air and helps", 262, 87);
                this.rd.drawString("when racing. Backward looping pushes your car upwards giving it", 262, 107);
                this.rd.drawString("more hang time in the air making it easier to control its landing.", 262, 127);
                this.rd.drawString("Left and right rolls shift your car in the air left and right slightly.", 262, 147);
                if (this.aflk || this.dudo < 150) this.rd.drawImage(this.chil, 167, 295, (ImageObserver) null);
            }
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawImage(this.stunts, 105, 175, (ImageObserver) null);
            this.rd.drawImage(this.opwr, 540, 253, (ImageObserver) null);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.rd.drawString("To perform stunts. When your car is in the AIR:", 125, 310);
            this.rd.drawString("Press combo Spacebar + Arrow Keys", 125, 330);
            this.rd.drawImage(this.space, 185, 355, (ImageObserver) null);
            this.rd.drawImage(this.plus, 405, 358, (ImageObserver) null);
            this.rd.drawImage(this.arrows, 491, 323, (ImageObserver) null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Forward Loop", 492, 319);
            this.rd.drawString("Backward Loop", 490, 397);
            this.rd.drawString("Left Roll", 443, 375);
            this.rd.drawString("Right Roll", 576, 375);
            this.rd.drawString("Spacebar", 266, 374);
            this.rd.setColor(new Color(140, 243, 244));
            this.rd.fillRect(602, 257, 76, 9);
        }
        if (this.flipo == 11 || this.flipo == 13) {
            if (this.flipo == 11) {
                this.rd.drawString("When wasting cars, to help you find the other cars in the stage,", 262, 67);
                this.rd.drawString("press [ A ] to toggle the guidance arrow from pointing to the track", 262, 87);
                this.rd.drawString("to pointing to the cars.", 262, 107);
                this.rd.drawString("When your car is damaged. You fix it (and reset its 'Damage') by", 262, 127);
                this.rd.drawString("jumping through the electrified hoop.", 262, 147);
            } else {
                this.rd.setColor(new Color(0, 128, 255));
                this.rd.drawString("You will find that in some stages it's easier to waste the other cars", 262, 67);
                this.rd.drawString("and in some others it's easier to race and finish in first place.", 262, 87);
                this.rd.drawString("It is up to you to decide when to waste and when to race.", 262, 107);
                this.rd.drawString("And remember, 'Power' is an important factor in the game. You", 262, 127);
                this.rd.drawString("will need it whether you are racing or wasting!", 262, 147);
            }
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawImage(this.fixhoop, 185, 218, (ImageObserver) null);
            this.rd.drawImage(this.sarrow, 385, 228, (ImageObserver) null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.drawString("The Electrified Hoop", 192, 216);
            this.rd.drawString("Jumping through it fixes your car.", 158, 338);
            this.rd.drawString("Make guidance arrow point to cars.", 385, 216);
        }
        if (this.flipo == 15) {
            this.rd.drawString("And if you don’t know who I am,", 262, 67);
            this.rd.drawString("I am Coach Insano, I am the coach and narrator of this game!", 262, 87);
            this.rd.drawString("I recommended starting with NFM 1 if it’s your first time to play.", 262, 127);
            this.rd.drawString("Good Luck & Have Fun!", 262, 147);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Other Controls :", 155, 205);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.rd.drawImage(this.kz, 169, 229, (ImageObserver) null);
            this.rd.drawString("OR", 206, 251);
            this.rd.drawImage(this.kx, 229, 229, (ImageObserver) null);
            this.rd.drawString("To look behind you while driving.", 267, 251);
            this.rd.drawImage(this.kv, 169, 279, (ImageObserver) null);
            this.rd.drawString("Change Views", 207, 301);
            this.rd.drawImage(this.kenter, 169, 329, (ImageObserver) null);
            this.rd.drawString("Navigate & Pause Game", 275, 351);
            this.rd.drawImage(this.km, 489, 229, (ImageObserver) null);
            this.rd.drawString("Mute Music", 527, 251);
            this.rd.drawImage(this.kn, 489, 279, (ImageObserver) null);
            this.rd.drawString("Mute Sound Effects", 527, 301);
            this.rd.drawImage(this.ks, 489, 329, (ImageObserver) null);
            this.rd.drawString("Toggle radar / map", 527, 351);
        }
        if (this.flipo == 1 || this.flipo == 16) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.rd.setColor(new Color(0, 0, 0));
            if (this.flipo == 16) {
                this.rd.drawString("M A I N    C O N T R O L S   -   once again!", 400 - this.ftm.stringWidth("M A I N    C O N T R O L S   -   once again!") / 2, 49);
            } else {
                this.rd.drawString("M A I N    C O N T R O L S", 400 - this.ftm.stringWidth("M A I N    C O N T R O L S") / 2, 49);
            }
            this.rd.drawString("Drive your car using the Arrow Keys:", 125, 80);
            this.rd.drawString("On the GROUND Spacebar is for Handbrake", 125, 101);
            this.rd.drawImage(this.space, 171, 115, (ImageObserver) null);
            this.rd.drawImage(this.arrows, 505, 83, (ImageObserver) null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("Accelerate", 515, 79);
            this.rd.drawString("Brake/Reverse", 506, 157);
            this.rd.drawString("Turn left", 454, 135);
            this.rd.drawString("Turn right", 590, 135);
            this.rd.drawString("Handbrake", 247, 134);
            drawcs(175, "----------------------------------------------------------------------------------------------------------------------------------------------------", 0, 64, 128, 3);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("To perform STUNTS:", 125, 200);
            this.rd.drawString("In the AIR press combo Spacebar + Arrow Keys", 125, 220);
            this.rd.drawImage(this.space, 185, 245, (ImageObserver) null);
            this.rd.drawImage(this.plus, 405, 248, (ImageObserver) null);
            this.rd.drawImage(this.arrows, 491, 213, (ImageObserver) null);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Forward Loop", 492, 209);
            this.rd.drawString("Backward Loop", 490, 287);
            this.rd.drawString("Left Roll", 443, 265);
            this.rd.drawString("Right Roll", 576, 265);
            this.rd.drawString("Spacebar", 266, 264);
            this.rd.drawImage(this.stunts, 125, 285, (ImageObserver) null);
        }
        if (this.flipo >= 1 && this.flipo <= 15)
            this.rd.drawImage(this.next[this.pnext], 665, 395, (ImageObserver) null);
        if (this.flipo >= 3 && this.flipo <= 16)
            this.rd.drawImage(this.back[this.pback], 75, 395, (ImageObserver) null);
        if (this.flipo == 16) this.rd.drawImage(this.contin[this.pcontin], 565, 395, (ImageObserver) null);
        if (paramControl.enter || paramControl.right) {
            if (paramControl.enter && this.flipo == 16) {
                this.flipo = 0;
                this.fase = this.oldfase;
                this.rd.setFont(new Font("Arial", 1, 11));
                this.ftm = this.rd.getFontMetrics();
            }
            paramControl.enter = false;
            paramControl.right = false;
            if (this.flipo >= 1 && this.flipo <= 15) this.flipo++;
        }
        if (paramControl.left) {
            if (this.flipo >= 3 && this.flipo <= 15) this.flipo -= 3;
            if (this.flipo == 16) this.flipo--;
            paramControl.left = false;
        }
    }

    public void maini(Control paramControl) {
        if (this.flipo == 0) {
            this.app.setCursor(new Cursor(0));
            this.flipo++;
        }
        mainbg(1);
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
        this.rd.drawImage(this.logomadbg, 65, 25, (ImageObserver) null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        this.rd.drawImage(this.logomadnes, 233, 186, (ImageObserver) null);
        float f = this.flkat / 800.0F;
        if (f > 0.2D) f = 0.2F;
        if (this.flkat > 200) {
            f = (400 - this.flkat) / 1000.0F;
            if (f < 0.0F) f = 0.0F;
        }
        this.flkat++;
        if (this.flkat == 400) this.flkat = 0;
        this.rd.setComposite(AlphaComposite.getInstance(3, f));
        this.rd.drawImage(this.dude[0], 351 + this.gxdu, 28 + this.gydu, (ImageObserver) null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        if (this.movly == 0) {
            this.gxdu = (int) (5.0D - 11.0D * Math.random());
            this.gydu = (int) (5.0D - 11.0D * Math.random());
        }
        this.movly++;
        if (this.movly == 2) this.movly = 0;
        this.rd.drawImage(this.logocars, 66, 33, (ImageObserver) null);
        this.rd.drawImage(this.opback, 247, 237, (ImageObserver) null);
        if (this.muhi < 0) {
            this.rd.setColor(new Color(140, 70, 0));
            this.rd.fillRoundRect(335, 293, 114, 19, 7, 20);
        }
        this.muhi--;
        if (this.muhi < -5) this.muhi = 50;
        if (paramControl.up) {
            this.opselect--;
            if (this.opselect == -1) this.opselect = 3;
            paramControl.up = false;
        }
        if (paramControl.down) {
            this.opselect++;
            if (this.opselect == 4) this.opselect = 0;
            paramControl.down = false;
        }
        if (this.opselect == 0) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(343, 261, 110, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 200, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(343, 261, 110, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(343, 261, 110, 22, 7, 20);
        }
        if (this.opselect == 1) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(288, 291, 221, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 191, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 95, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(288, 291, 221, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(288, 291, 221, 22, 7, 20);
        }
        if (this.opselect == 2) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(301, 321, 196, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 128, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(301, 321, 196, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(301, 321, 196, 22, 7, 20);
        }
        if (this.opselect == 3) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(357, 351, 85, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 0, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(357, 351, 85, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(357, 351, 85, 22, 7, 20);
        }
        this.rd.drawImage(this.opti, 294, 265, (ImageObserver) null);
        if (paramControl.enter || paramControl.handb) {
            if (this.opselect == 1) {
                this.mtop = true;
                this.multion = 1;
                this.gmode = 0;
                if (this.firstime) {
                    this.oldfase = -9;
                    this.fase = 11;
                    this.firstime = false;
                } else {
                    this.fase = -9;
                }
            }
            if (this.opselect == 2) {
                this.oldfase = 10;
                this.fase = 11;
                this.firstime = false;
            }
            if (this.opselect == 3) this.fase = 8;
            if (this.opselect == 0) {
                if (this.unlocked[0] == 11) if (this.unlocked[1] != 17) {
                    this.opselect = 1;
                } else {
                    this.opselect = 2;
                }
                if (this.firstime) {
                    this.oldfase = 102;
                    this.fase = 11;
                    this.firstime = false;
                } else {
                    this.fase = 102;
                }
            }
            this.flipo = 0;
            paramControl.enter = false;
            paramControl.handb = false;
        }
        this.rd.drawImage(this.byrd, 72, 410, (ImageObserver) null);
        this.rd.drawImage(this.nfmcoms, 567, 410, (ImageObserver) null);
        if (this.shaded) {
            this.app.repaint();
            try {
                Thread.sleep(200L);
            } catch (InterruptedException interruptedException) {
            }
        }
    }

    public xtGraphics(Medium paramMedium, CarDefine paramCarDefine, Graphics2D paramGraphics2D, GameSparker paramGameSparker) {
        this.radpx = 212;
        this.pin = 60;


        this.trkx = new int[]{65, 735};
        this.trkl = 0;
        this.trklim = (int) (Math.random() * 40.0D);


        this.lmode = 0;
        this.bgmy = new int[]{0, -400};
        this.bgf = 0.0F;
        this.bgup = false;
        this.ovx = new int[]{0, 0, 0, 0};
        this.ovy = new int[]{0, 0, 0, 0};
        this.ovw = new int[]{0, 0, 0, 0};
        this.ovh = new int[]{0, 0, 0, 0};
        this.ovsx = new int[]{0, 0, 0, 0};


        this.removeds = 0;
        this.nfmtab = 0;
        this.justwon1 = false;
        this.justwon2 = false;
        this.lfrom = 0;


        this.lockcnt = 0;


        this.showtf = false;


        this.ransay = 0;


        this.cnames = new String[][]{{"", "", "", "", "", "", "Game Chat  "}, {"", "", "", "", "", "", "Your Clan's Chat  "}};
        this.sentn = new String[][]{{"", "", "", "", "", "", ""}, {"", "", "", "", "", "", ""}};
        this.updatec = new int[]{-1, -1};

        this.movepos = new int[]{0, 0};
        this.pointc = new int[]{6, 6};
        this.floater = new int[]{0, 0};
        this.cntchatp = new int[]{0, 0};
        this.msgflk = new int[]{0, 0};
        this.lcmsg = new String[]{"", ""};


        this.flkat = 0;
        this.movly = 0;
        this.gxdu = 0;
        this.gydu = 0;
        this.muhi = 0;


        this.lsc = -1;
        this.mouson = -1;
        this.onmsc = -1;
        this.remi = false;
        this.basefase = 0;
        this.noclass = false;


        this.gatey = 300;
        this.pgatx = new int[]{211, 240, 280, 332, 399, 466, 517, 558, 586};
        this.pgaty = new int[]{193, 213, 226, 237, 244, 239, 228, 214, 196};
        this.pgady = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        this.pgas = new boolean[]{false, false, false, false, false, false, false, false, false};


        this.waitlink = 0;


        this.lxm = -10;
        this.lym = -10;


        this.pwait = 7;
        this.stopcnt = 0;
        this.cntwis = 0;


        this.lcn = 0;


        this.crshturn = 0;
        this.bfcrash = 0;
        this.bfskid = 0;
        this.crashup = false;

        this.skidup = false;
        this.skflg = 0;
        this.dskflg = 0;


        this.bfscrape = 0;
        this.sturn0 = 0;
        this.sturn1 = 0;


        this.bfsc1 = 0;
        this.bfsc2 = 0;


        this.flatr = 0;
        this.flyr = 0;
        this.flyrdest = 0;
        this.flang = 0;
        this.m = paramMedium;
        this.cd = paramCarDefine;
        this.app = paramGameSparker;
        this.rd = paramGraphics2D;
        this.hello = getImage("data/hello.gif");
        this.sign = getImage("data/sign.gif");
        this.loadbar = getImage("data/loadbar.gif");
        for (byte b = 0; b < 5; ) {
            this.pengs[b] = false;
            b++;
        }
        this.nofull = false;
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) try {
            securityManager.checkConnect("needformadness.com", -1);
        } catch (Exception exception) {
            String str = "" + exception;
            if (str.indexOf("access denied") != -1) this.nofull = true;
        }
        this.badmac = false;
    }

    public void maini2(Control paramControl, int paramInt1, int paramInt2, int paramInt3) {
        mainbg(1);
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
        this.rd.drawImage(this.logomadbg, 65, 25, (ImageObserver) null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        this.rd.drawImage(this.logomadnes, 233, 186, (ImageObserver) null);
        float f = this.flkat / 800.0F;
        if (f > 0.2D) f = 0.2F;
        if (this.flkat > 200) {
            f = (400 - this.flkat) / 1000.0F;
            if (f < 0.0F) f = 0.0F;
        }
        this.flkat++;
        if (this.flkat == 400) this.flkat = 0;
        this.rd.setComposite(AlphaComposite.getInstance(3, f));
        this.rd.drawImage(this.dude[0], 351 + this.gxdu, 28 + this.gydu, (ImageObserver) null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        if (this.movly == 0) {
            this.gxdu = (int) (5.0D - 11.0D * Math.random());
            this.gydu = (int) (5.0D - 11.0D * Math.random());
        }
        this.movly++;
        if (this.movly == 2) this.movly = 0;
        this.rd.drawImage(this.logocars, 66, 33, (ImageObserver) null);
        this.rd.drawImage(this.opback, 247, 237, (ImageObserver) null);
        if (paramControl.up) {
            this.opselect--;
            if (this.opselect == -1) this.opselect = 3 - this.dropf / 15;
            paramControl.up = false;
        }
        if (paramControl.down) {
            this.opselect++;
            if (this.opselect == 4 - this.dropf / 15) this.opselect = 0;
            paramControl.down = false;
        }
        if (this.opselect == 0) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(358, 262 + this.dropf, 82, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 64, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(358, 262 + this.dropf, 82, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(358, 262 + this.dropf, 82, 22, 7, 20);
        }
        if (this.opselect == 1) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(358, 290 + this.dropf, 82, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 64, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 95, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(358, 290 + this.dropf, 82, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(358, 290 + this.dropf, 82, 22, 7, 20);
        }
        if (this.opselect == 2) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(333, 318 + this.dropf, 132, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 255, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(333, 318 + this.dropf, 132, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(333, 318 + this.dropf, 132, 22, 7, 20);
        }
        if (this.dropf == 0) if (this.opselect == 3) {
            if (this.shaded) {
                this.rd.setColor(new Color(140, 70, 0));
                this.rd.fillRect(348, 346, 102, 22);
                this.aflk = false;
            }
            if (this.aflk) {
                this.rd.setColor(new Color(200, 64, 0));
                this.aflk = false;
            } else {
                this.rd.setColor(new Color(255, 128, 0));
                this.aflk = true;
            }
            this.rd.drawRoundRect(348, 346, 102, 22, 7, 20);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(348, 346, 102, 22, 7, 20);
        }
        this.rd.drawImage(this.opti2, 346, 265 + this.dropf, (ImageObserver) null);
        if (this.dropf != 0) {
            this.rd.setColor(new Color(58, 30, 8));
            this.rd.fillRect(357, 365, 87, 15);
        }
        if (paramControl.enter || paramControl.handb) {
            this.mtop = false;
            if (this.opselect == 0) {
                this.multion = 0;
                this.clangame = 0;
                this.gmode = 1;
                this.fase = -9;
            }
            if (this.opselect == 1) {
                this.multion = 0;
                this.clangame = 0;
                this.gmode = 2;
                this.fase = -9;
                this.opselect = 0;
            }
            if (this.dropf == 0 && this.opselect == 3) {
                this.multion = 0;
                this.clangame = 0;
                this.gmode = 0;
                this.fase = -9;
                this.opselect = 0;
            }
            if (this.opselect == 2) {
                this.multion = 1;
                this.gmode = 0;
                if (this.firstime) {
                    this.oldfase = -9;
                    this.fase = 11;
                    this.firstime = false;
                } else {
                    this.fase = -9;
                }
            }
            this.flipo = 0;
            paramControl.enter = false;
            paramControl.handb = false;
        }
        this.rd.drawImage(this.byrd, 72, 410, (ImageObserver) null);
        this.rd.drawImage(this.nfmcoms, 567, 410, (ImageObserver) null);
        boolean bool = false;
        if (paramInt3 == 2) bool = true;
        if (drawcarb(true, null, "   < Back   ", 161, 313, paramInt1, paramInt2, bool)) {
            this.opselect = 0;
            this.fase = 10;
        }
        if (this.shaded) {
            this.app.repaint();
            try {
                Thread.sleep(200L);
            } catch (InterruptedException interruptedException) {
            }
        }
    }

    public void pausedgame(int paramInt, Control paramControl, Record paramRecord) {
        if (!this.badmac) {
            this.rd.drawImage(this.fleximg, 0, 0, (ImageObserver) null);
        } else {
            this.rd.setColor(new Color(30, 67, 110));
            this.rd.fillRect(281, 8, 237, 188);
        }
        if (paramControl.up) {
            this.opselect--;
            if (this.opselect == -1) this.opselect = 3;
            paramControl.up = false;
        }
        if (paramControl.down) {
            this.opselect++;
            if (this.opselect == 4) this.opselect = 0;
            paramControl.down = false;
        }
        if (this.opselect == 0) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(329, 45, 137, 22, 7, 20);
            if (this.shaded) {
                this.rd.setColor(new Color(225, 200, 255));
            } else {
                this.rd.setColor(new Color(0, 89, 223));
            }
            this.rd.drawRoundRect(329, 45, 137, 22, 7, 20);
        }
        if (this.opselect == 1) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(320, 73, 155, 22, 7, 20);
            if (this.shaded) {
                this.rd.setColor(new Color(225, 200, 255));
            } else {
                this.rd.setColor(new Color(0, 89, 223));
            }
            this.rd.drawRoundRect(320, 73, 155, 22, 7, 20);
        }
        if (this.opselect == 2) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(303, 99, 190, 22, 7, 20);
            if (this.shaded) {
                this.rd.setColor(new Color(225, 200, 255));
            } else {
                this.rd.setColor(new Color(0, 89, 223));
            }
            this.rd.drawRoundRect(303, 99, 190, 22, 7, 20);
        }
        if (this.opselect == 3) {
            this.rd.setColor(new Color(64, 143, 223));
            this.rd.fillRoundRect(341, 125, 109, 22, 7, 20);
            if (this.shaded) {
                this.rd.setColor(new Color(225, 200, 255));
            } else {
                this.rd.setColor(new Color(0, 89, 223));
            }
            this.rd.drawRoundRect(341, 125, 109, 22, 7, 20);
        }
        this.rd.drawImage(this.paused, 281, 8, (ImageObserver) null);
        if (paramControl.enter || paramControl.handb) {
            if (this.opselect == 0) {
                if (this.loadedt && !this.mutem) this.strack.resume();
                this.fase = 0;
            }
            if (this.opselect == 1) if (paramRecord.caught >= 300) {
                if (this.loadedt && !this.mutem) this.strack.resume();
                this.fase = -1;
            } else {
                this.fase = -8;
            }
            if (this.opselect == 2) {
                if (this.loadedt) this.strack.stop();
                this.oldfase = -7;
                this.fase = 11;
            }
            if (this.opselect == 3) {
                if (this.loadedt) this.strack.unload();
                this.fase = 102;
                if (this.gmode == 0) this.opselect = 3;
                if (this.gmode == 1) this.opselect = 0;
                if (this.gmode == 2) this.opselect = 1;
                this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            }
            paramControl.enter = false;
            paramControl.handb = false;
        }
    }

    public void replyn() {
        if (this.aflk) {
            drawcs(30, "Replay  > ", 0, 0, 0, 0);
            this.aflk = false;
        } else {
            drawcs(30, "Replay  >>", 0, 128, 255, 0);
            this.aflk = true;
        }
    }

    public void cantreply() {
        this.rd.setColor(new Color(64, 143, 223));
        this.rd.fillRoundRect(200, 73, 400, 23, 7, 20);
        this.rd.setColor(new Color(0, 89, 223));
        this.rd.drawRoundRect(200, 73, 400, 23, 7, 20);
        drawcs(89, "Sorry not enough replay data to play available, please try again later.", 255, 255, 255, 1);
    }

    public void nofocus() {
        this.rd.setColor(new Color(255, 255, 255));
        this.rd.fillRect(0, 0, 800, 20);
        this.rd.fillRect(0, 0, 20, 450);
        this.rd.fillRect(0, 430, 800, 20);
        this.rd.fillRect(780, 0, 20, 450);
        this.rd.setColor(new Color(192, 192, 192));
        this.rd.drawRect(20, 20, 760, 410);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.drawRect(22, 22, 756, 406);
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        drawcs(14, "Game lost its focus.   Click screen with mouse to continue.", 100, 100, 100, 3);
        drawcs(445, "Game lost its focus.   Click screen with mouse to continue.", 100, 100, 100, 3);
    }

    public void inishcarselect(ContO[] paramArrayOfContO) {
        this.nplayers = 7;
        this.im = 0;
        this.xstart[0] = 0;
        this.xstart[1] = -350;
        this.xstart[2] = 350;
        this.xstart[3] = 0;
        this.xstart[4] = -350;
        this.xstart[5] = 350;
        this.xstart[6] = 0;
        this.zstart[0] = -760;
        this.zstart[1] = -380;
        this.zstart[2] = -380;
        this.zstart[3] = 0;
        this.zstart[4] = 380;
        this.zstart[5] = 380;
        this.zstart[6] = 760;
        this.onmsc = -1;
        this.remi = false;
        this.basefase = 0;
        this.noclass = false;
        if (this.testdrive != 1 && this.testdrive != 2) {
            if (this.gmode != 0) {
                this.cfase = 0;
                this.sc[0] = this.scm[this.gmode - 1];
            }
            if (this.gmode == 0) this.sc[0] = this.osc;
            if (this.cd.lastload != 1 || this.cfase != 3) this.onmsc = this.sc[0];
            if (this.cfase == 0 && this.sc[0] > 15) {
                this.sc[0] = 15;
                if (this.multion != 0) this.cfase = -1;
            }
            if (this.onjoin != -1 && this.multion != 0) {
                if (this.ontyp <= -2) this.cfase = 0;
                if (this.ontyp >= 20) {
                    this.ontyp -= 20;
                    this.cfase = 0;
                }
                if (this.ontyp >= 10) {
                    this.ontyp -= 10;
                    if (this.cd.lastload != 2) {
                        this.cfase = -1;
                        this.onjoin = -1;
                    } else {
                        this.cfase = 3;
                    }
                }
            }
            if (this.cfase == 11 || this.cfase == 101)
                if (this.sc[0] >= 16 && this.cd.lastload == 2 && this.sc[0] < 36) {
                    this.cfase = 3;
                } else {
                    this.cfase = 0;
                }
            if (this.cfase == 3) {
                if (this.multion != 0 && this.cd.lastload == 1) {
                    this.sc[0] = 15;
                    this.minsl = 0;
                    this.maxsl = 15;
                    this.cfase = 0;
                }
                if (this.cd.lastload == 0) {
                    this.sc[0] = 15;
                    this.minsl = 0;
                    this.maxsl = 15;
                    this.cfase = 0;
                }
                if (this.cd.lastload == 2) {
                    this.minsl = 16;
                    this.maxsl = this.cd.nlocars - 1;
                    if (this.sc[0] < this.minsl) this.sc[0] = this.minsl;
                    if (this.sc[0] > this.maxsl) this.sc[0] = this.maxsl;
                    if (this.onjoin != -1 && this.multion != 0 && this.ontyp > 0 && this.ontyp <= 5) {
                        boolean bool;
                        byte b;
                        for (bool = false, b = 16; b < this.cd.nlocars; ) {
                            if (Math.abs(this.cd.cclass[b] - this.ontyp - 1) <= 1) {
                                if (!bool) {
                                    this.minsl = b;
                                    bool = true;
                                }
                                if (bool) this.maxsl = b;
                            }
                            b++;
                        }
                        if (!bool) {
                            this.onjoin = -1;
                            this.noclass = true;
                        } else {
                            if (this.sc[0] < this.minsl) this.sc[0] = this.minsl;
                            if (this.sc[0] > this.maxsl) this.sc[0] = this.maxsl;
                            if (Math.abs(this.cd.cclass[this.sc[0]] - this.ontyp - 1) > 1) this.sc[0] = this.minsl;
                        }
                    }
                }
                if (this.cd.lastload == -2 && this.logged) {
                    this.cfase = 5;
                    this.showtf = false;
                    this.cd.action = 3;
                    this.cd.sparkactionloader();
                }
            }
            if (this.cfase == 0) {
                this.minsl = 0;
                this.maxsl = 15;
                if (this.onjoin != -1 && this.multion != 0) {
                    if (this.ontyp == 1) {
                        this.minsl = 0;
                        this.maxsl = 5;
                    }
                    if (this.ontyp == 2) {
                        this.minsl = 0;
                        this.maxsl = 9;
                    }
                    if (this.ontyp == 3) {
                        this.minsl = 5;
                        this.maxsl = 10;
                    }
                    if (this.ontyp == 4) {
                        this.minsl = 6;
                        this.maxsl = 15;
                    }
                    if (this.ontyp == 5) {
                        this.minsl = 10;
                        this.maxsl = 15;
                    }
                    if (this.ontyp <= -2) {
                        this.minsl = Math.abs(this.ontyp + 2);
                        this.maxsl = Math.abs(this.ontyp + 2);
                    }
                }
                if (this.sc[0] < this.minsl) this.sc[0] = this.minsl;
                if (this.sc[0] > this.maxsl) this.sc[0] = this.maxsl;
            }
        } else {
            this.minsl = this.sc[0];
            this.maxsl = this.sc[0];
        }
        this.app.mcars.setBackground(new Color(0, 0, 0));
        this.app.mcars.setForeground(new Color(47, 179, 255));
        this.app.mcars.alphad = true;
        this.app.mcars.carsel = true;
        carsbginflex();
        this.flatrstart = 0;
        this.m.lightson = false;
        this.pnext = 0;
        this.pback = 0;
        this.lsc = -1;
        this.mouson = -1;
        if (this.multion == 0) {
            this.app.mycar.setLabel(" Include in this game.");
            this.app.mycar.setBackground(new Color(198, 179, 129));
            this.app.mycar.setForeground(new Color(0, 0, 0));
            int i = 16;
            if (this.cd.lastload == 2) i = this.cd.nlocars;
            byte b;
            for (b = 0; b < i; b++) {
                float[] arrayOfFloat = new float[3];
                Color.RGBtoHSB((paramArrayOfContO[b]).fcol[0], (paramArrayOfContO[b]).fcol[1], (paramArrayOfContO[b]).fcol[2], arrayOfFloat);
                byte b1;
                for (b1 = 0; b1 < (paramArrayOfContO[b]).npl; ) {
                    if (((paramArrayOfContO[b]).p[b1]).colnum == 1) {
                        ((paramArrayOfContO[b]).p[b1]).hsb[0] = arrayOfFloat[0];
                        ((paramArrayOfContO[b]).p[b1]).hsb[1] = arrayOfFloat[1];
                        ((paramArrayOfContO[b]).p[b1]).hsb[2] = arrayOfFloat[2];
                        ((paramArrayOfContO[b]).p[b1]).oc[0] = (paramArrayOfContO[b]).fcol[0];
                        ((paramArrayOfContO[b]).p[b1]).oc[1] = (paramArrayOfContO[b]).fcol[1];
                        ((paramArrayOfContO[b]).p[b1]).oc[2] = (paramArrayOfContO[b]).fcol[2];
                    }
                    b1++;
                }
                Color.RGBtoHSB((paramArrayOfContO[b]).scol[0], (paramArrayOfContO[b]).scol[1], (paramArrayOfContO[b]).scol[2], arrayOfFloat);
                for (b1 = 0; b1 < (paramArrayOfContO[b]).npl; ) {
                    if (((paramArrayOfContO[b]).p[b1]).colnum == 2) {
                        ((paramArrayOfContO[b]).p[b1]).hsb[0] = arrayOfFloat[0];
                        ((paramArrayOfContO[b]).p[b1]).hsb[1] = arrayOfFloat[1];
                        ((paramArrayOfContO[b]).p[b1]).hsb[2] = arrayOfFloat[2];
                        ((paramArrayOfContO[b]).p[b1]).oc[0] = (paramArrayOfContO[b]).scol[0];
                        ((paramArrayOfContO[b]).p[b1]).oc[1] = (paramArrayOfContO[b]).scol[1];
                        ((paramArrayOfContO[b]).p[b1]).oc[2] = (paramArrayOfContO[b]).scol[2];
                    }
                    b1++;
                }
                (paramArrayOfContO[b]).xy = 0;
            }
            for (b = 0; b < 6; ) {
                this.arnp[b] = -1.0F;
                b++;
            }
        }
        this.m.trk = 0;
        this.m.crs = true;
        this.m.x = -400;
        this.m.y = -525;
        this.m.z = -50;
        this.m.xz = 0;
        this.m.zy = 10;
        this.m.ground = 495;
        this.m.ih = 0;
        this.m.iw = 0;
        this.m.h = 450;
        this.m.w = 800;
        this.m.focus_point = 400;
        this.m.cx = 400;
        this.m.cy = 225;
        this.m.cz = 50;
        if (this.multion == 0) {
            this.intertrack.loadimod(false);
            this.intertrack.play();
        }
    }

    public void carselect(Control paramControl, ContO[] paramArrayOfContO, Mad paramMad, int paramInt1, int paramInt2, boolean paramBoolean) {
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        this.rd.fillRect(65, 0, 670, 25);
        this.rd.fillRect(65, 425, 670, 25);
        if (this.flatrstart == 6) {
            if (this.multion != 0 || this.testdrive == 1 || this.testdrive == 2) {
                this.rd.drawImage(this.carsbgc, 65, 25, (ImageObserver) null);
            } else {
                this.rd.drawImage(this.carsbg, 65, 25, (ImageObserver) null);
            }
        } else if (this.flatrstart <= 1) {
            drawSmokeCarsbg();
        } else {
            this.rd.setColor(new Color(255, 255, 255));
            this.rd.fillRect(65, 25, 670, 400);
            carsbginflex();
            this.flatrstart = 6;
        }
        this.rd.drawImage(this.selectcar, 321, 37, (ImageObserver) null);
        if (this.cfase == 3 || this.cfase == 7 || this.remi) {
            if (this.cd.lastload == 1) this.rd.drawImage(this.ycmc, 337, 58, (ImageObserver) null);
            if (this.cd.lastload == 2) this.rd.drawImage(this.yac, 323, 58, (ImageObserver) null);
        }
        if (this.cfase == 11) {
            this.rd.setFont(new Font("Arial", 1, 13));
            String str1;
            int k;
            String str2;
            for (this.ftm = this.rd.getFontMetrics(), str1 = "Top 20 Cars", k = this.cd.loadlist, str2 = "Weekly"; k > 6; ) {
                k -= 6;
                if (str2.equals("Semi-Annual")) str2 = "Annual";
                if (str2.equals("Monthly")) str2 = "Semi-Annual";
                if (str2.equals("Weekly")) str2 = "Monthly";
            }
            if (k == 1) str1 = "" + str2 + " Top 20 Cars";
            if (k == 2) str1 = "" + str2 + " Top 20 Class A Cars";
            if (k == 3) str1 = "" + str2 + " Top 20 Class A & B Cars";
            if (k == 4) str1 = "" + str2 + " Top 20 Class B Cars";
            if (k == 5) str1 = "" + str2 + " Top 20 Class B & C Cars";
            if (k == 6) str1 = "" + str2 + " Top 20 Class C Cars";
            drawcs(69, str1, 120, 176, 255, 3);
        }
        if (this.cfase == 101) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            drawcs(69, "" + this.cd.viewname + "'s account cars!", 220, 112, 33, 3);
        }
        if (!this.remi) {
            this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            paramArrayOfContO[this.sc[0]].d(this.rd);
            this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        if (this.cfase == 8) {
            drawprom(150, 85);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            drawcs(195, "Removing Car...", 0, 0, 0, 3);
            if (this.cd.action != 10) if (this.cd.action != -10) {
                this.cfase = 5;
                this.showtf = false;
            } else {
                this.cfase = 9;
            }
        }
        if (this.multion != 0 || this.testdrive == 1 || this.testdrive == 2) if (this.lsc != this.sc[0]) {
            if ((paramArrayOfContO[this.sc[0]]).xy != 0) (paramArrayOfContO[this.sc[0]]).xy = 0;
            boolean bool1;
            byte b1;
            for (bool1 = false, b1 = 0; b1 < (paramArrayOfContO[this.sc[0]]).npl && !bool1; ) {
                if (((paramArrayOfContO[this.sc[0]]).p[b1]).colnum == 1) {
                    float[] arrayOfFloat = new float[3];
                    Color.RGBtoHSB(((paramArrayOfContO[this.sc[0]]).p[b1]).c[0], ((paramArrayOfContO[this.sc[0]]).p[b1]).c[1], ((paramArrayOfContO[this.sc[0]]).p[b1]).c[2], arrayOfFloat);
                    this.arnp[0] = arrayOfFloat[0];
                    this.arnp[1] = arrayOfFloat[1];
                    this.arnp[2] = 1.0F - arrayOfFloat[2];
                    bool1 = true;
                }
                b1++;
            }
            for (bool1 = false, b1 = 0; b1 < (paramArrayOfContO[this.sc[0]]).npl && !bool1; ) {
                if (((paramArrayOfContO[this.sc[0]]).p[b1]).colnum == 2) {
                    float[] arrayOfFloat = new float[3];
                    Color.RGBtoHSB(((paramArrayOfContO[this.sc[0]]).p[b1]).c[0], ((paramArrayOfContO[this.sc[0]]).p[b1]).c[1], ((paramArrayOfContO[this.sc[0]]).p[b1]).c[2], arrayOfFloat);
                    this.arnp[3] = arrayOfFloat[0];
                    this.arnp[4] = arrayOfFloat[1];
                    this.arnp[5] = 1.0F - arrayOfFloat[2];
                    bool1 = true;
                }
                b1++;
            }
            Color color1 = Color.getHSBColor(this.arnp[0], this.arnp[1], 1.0F - this.arnp[2]);
            Color color2 = Color.getHSBColor(this.arnp[3], this.arnp[4], 1.0F - this.arnp[5]);
            for (byte b2 = 0; b2 < (paramArrayOfContO[this.sc[0]]).npl; b2++) {
                if (((paramArrayOfContO[this.sc[0]]).p[b2]).colnum == 1) {
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).hsb[0] = this.arnp[0];
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).hsb[1] = this.arnp[1];
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).hsb[2] = 1.0F - this.arnp[2];
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).c[0] = color1.getRed();
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).c[1] = color1.getGreen();
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).c[2] = color1.getBlue();
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).oc[0] = color1.getRed();
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).oc[1] = color1.getGreen();
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).oc[2] = color1.getBlue();
                }
                if (((paramArrayOfContO[this.sc[0]]).p[b2]).colnum == 2) {
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).hsb[0] = this.arnp[3];
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).hsb[1] = this.arnp[4];
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).hsb[2] = 1.0F - this.arnp[5];
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).c[0] = color2.getRed();
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).c[1] = color2.getGreen();
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).c[2] = color2.getBlue();
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).oc[0] = color2.getRed();
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).oc[1] = color2.getGreen();
                    ((paramArrayOfContO[this.sc[0]]).p[b2]).oc[2] = color2.getBlue();
                }
            }
            this.lsc = this.sc[0];
        }
        int i = -1;
        int j = 0;
        boolean bool = false;
        if (this.flipo == 0) {
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            byte b = 0;
            if (this.flatrstart < 6) b = 2;
            if (!this.remi && (this.cfase != 10 || (this.cd.action != 0 && this.cd.action < 14))) {
                if (this.cfase == 3 && this.cd.lastload == 2) {
                    this.app.mcars.move(400 - this.app.mcars.w / 2, 78);
                    this.app.mcars.show = true;
                    if (!this.app.mcars.getSelectedItem().equals(this.cd.names[this.sc[0]])) {
                        for (byte b1 = 16; b1 < this.cd.nlocars; ) {
                            if (this.cd.names[b1].equals(this.app.mcars.getSelectedItem())) i = b1;
                            b1++;
                        }
                        if (i == -1) {
                            this.cfase = 5;
                            this.cd.action = 4;
                            this.cd.sparkactionloader();
                        }
                    }
                } else {
                    this.app.mcars.show = false;
                    String str = "";
                    if (this.cfase == 11) str = "N#" + (this.sc[0] - 35) + "  ";
                    if (this.aflk) {
                        drawcs(95 + b, str + this.cd.names[this.sc[0]], 240, 240, 240, 3);
                        this.aflk = false;
                    } else {
                        drawcs(95, str + this.cd.names[this.sc[0]], 176, 176, 176, 3);
                        this.aflk = true;
                    }
                }
            } else {
                this.app.mcars.show = false;
            }
            (paramArrayOfContO[this.sc[0]]).z = 950;
            if (this.sc[0] == 13) (paramArrayOfContO[this.sc[0]]).z = 1000;
            (paramArrayOfContO[this.sc[0]]).y = -34 - (paramArrayOfContO[this.sc[0]]).grat;
            (paramArrayOfContO[this.sc[0]]).x = 0;
            if (this.mouson >= 0 && this.mouson <= 3) {
                (paramArrayOfContO[this.sc[0]]).xz += 2;
            } else {
                (paramArrayOfContO[this.sc[0]]).xz += 5;
            }
            if ((paramArrayOfContO[this.sc[0]]).xz > 360) (paramArrayOfContO[this.sc[0]]).xz -= 360;
            (paramArrayOfContO[this.sc[0]]).zy = 0;
            (paramArrayOfContO[this.sc[0]]).wzy -= 10;
            if ((paramArrayOfContO[this.sc[0]]).wzy < -30) (paramArrayOfContO[this.sc[0]]).wzy += 30;
            if (!this.remi) {
                if (this.sc[0] != this.minsl) this.rd.drawImage(this.back[this.pback], 95, 275, (ImageObserver) null);
                if (this.sc[0] != this.maxsl) this.rd.drawImage(this.next[this.pnext], 645, 275, (ImageObserver) null);
            }
            if (this.gmode == 1) {
                if (this.sc[0] == 5 && this.unlocked[0] <= 2) j = 2;
                if (this.sc[0] == 6 && this.unlocked[0] <= 4) j = 4;
                if (this.sc[0] == 11 && this.unlocked[0] <= 6) j = 6;
                if (this.sc[0] == 14 && this.unlocked[0] <= 8) j = 8;
                if (this.sc[0] == 15 && this.unlocked[0] <= 10) j = 10;
            }
            if (this.gmode == 2 && this.sc[0] >= 8 && this.unlocked[1] <= (this.sc[0] - 7) * 2)
                j = (this.sc[0] - 7) * 2;
            if (j != 0) {
                if (this.gatey == 300) {
                    for (byte b2 = 0; b2 < 9; ) {
                        this.pgas[b2] = false;
                        this.pgady[b2] = 0;
                        b2++;
                    }
                    this.pgas[0] = true;
                }
                for (byte b1 = 0; b1 < 9; b1++) {
                    this.rd.drawImage(this.pgate, this.pgatx[b1], this.pgaty[b1] + this.pgady[b1] - this.gatey, (ImageObserver) null);
                    if (this.flatrstart == 6) if (this.pgas[b1]) {
                        this.pgady[b1] = this.pgady[b1] - (80 + 100 / (b1 + 1) - Math.abs(this.pgady[b1])) / 3;
                        if (this.pgady[b1] < -(70 + 100 / (b1 + 1))) {
                            this.pgas[b1] = false;
                            if (b1 != 8) this.pgas[b1 + 1] = true;
                        }
                    } else {
                        this.pgady[b1] = this.pgady[b1] + (80 + 100 / (b1 + 1) - Math.abs(this.pgady[b1])) / 3;
                        if (this.pgady[b1] > 0) this.pgady[b1] = 0;
                    }
                }
                if (this.gatey != 0) this.gatey -= 100;
                if (this.flatrstart == 6) {
                    drawcs(355, "[ Car Locked ]", 210, 210, 210, 3);
                    drawcs(375, "This car unlocks when stage " + j + " is completed...", 255, 96, 0, 3);
                }
            } else {
                if (this.flatrstart == 6) {
                    if (this.cfase == 10) {
                        if (this.cd.action == 13) {
                            this.minsl = 36;
                            this.maxsl = this.cd.xnlocars - 1;
                            i = 36;
                            this.cd.action = 0;
                            this.cfase = 11;
                        }
                        if (this.cd.action == 12) {
                            int k;
                            String str1;
                            String str2;
                            for (k = this.cd.loadlist, str1 = "Top 20 Cars", str2 = "Weekly"; k > 6; ) {
                                k -= 6;
                                if (str2.equals("Semi-Annual")) str2 = "Annual";
                                if (str2.equals("Monthly")) str2 = "Semi-Annual";
                                if (str2.equals("Weekly")) str2 = "Monthly";
                            }
                            if (k == 1) str1 = "" + str2 + " Top 20 Cars";
                            if (k == 2) str1 = "" + str2 + " Top 20 Class A Cars";
                            if (k == 3) str1 = "" + str2 + " Top 20 Class A & B Cars";
                            if (k == 4) str1 = "" + str2 + " Top 20 Class B Cars";
                            if (k == 5) str1 = "" + str2 + " Top 20 Class B & C Cars";
                            if (k == 6) str1 = "" + str2 + " Top 20 Class C Cars";
                            drawprom(145, 170);
                            drawcs(195, "[  Loading " + str1 + "  ]", 0, 0, 0, 3);
                            if (this.cd.nl > 0 && this.cd.nl <= 20)
                                drawcs(235, "Loading :  " + this.cd.loadnames[this.cd.nl - 1] + "", 0, 0, 0, 3);
                        }
                        if (this.cd.action == 11) {
                            drawprom(145, 170);
                            drawcs(195, "Loading List, Please Wait...", 0, 0, 0, 3);
                        }
                        if (this.cd.action == -1) {
                            drawprom(145, 170);
                            drawcs(195, "Failed to Load List.", 0, 0, 0, 3);
                            drawcs(225, "Unknown Error.  Please try again later.", 0, 0, 0, 3);
                            if (drawcarb(true, null, "   OK   ", 371, 255, paramInt1, paramInt2, paramBoolean)) {
                                this.cd.action = 0;
                                this.cfase = this.basefase;
                            }
                        }
                        if (this.cd.action == 0 || this.cd.action == 14 || this.cd.action == 15 || this.cd.action == 16 || this.cd.action == 17) {
                            drawprom(65, 250);
                            if (drawcarb(true, null, " X ", 557, 70, paramInt1, paramInt2, paramBoolean)) {
                                this.cd.action = 0;
                                this.cfase = this.basefase;
                            }
                            drawcs(305, "The lists get updated every 24 hours!", 0, 0, 0, 3);
                            if (this.cd.action == 14 || this.cd.action == 15 || this.cd.action == 16 || this.cd.action == 17) {
                                if (!paramBoolean && this.cntflock == 20) this.cntflock = 0;
                                if (this.cd.action == 14) drawcs(91, "Weekly Top 20 Cars", 0, 0, 0, 3);
                                if (this.cd.action == 15) drawcs(91, "Monthly Top 20 Cars", 0, 0, 0, 3);
                                if (this.cd.action == 16) drawcs(91, "Semi-Annual Top 20 Cars", 0, 0, 0, 3);
                                if (this.cd.action == 17) drawcs(91, "Annual Top 20 Cars", 0, 0, 0, 3);
                                if (drawcarb(true, null, "   All Cars, All Classes   ", 318, 105, paramInt1, paramInt2, paramBoolean) && this.cntflock == 0) {
                                    this.cd.loadlist = 1 + (this.cd.action - 14) * 6;
                                    this.cd.action = 11;
                                    this.cd.sparkactionloader();
                                }
                                if (drawcarb(true, null, "Class A Cars", 337, 135, paramInt1, paramInt2, paramBoolean) && this.cntflock == 0) {
                                    this.cd.loadlist = 2 + (this.cd.action - 14) * 6;
                                    this.cd.action = 11;
                                    this.cd.sparkactionloader();
                                }
                                if (drawcarb(true, null, "Class A & B Cars", 337, 165, paramInt1, paramInt2, paramBoolean) && this.cntflock == 0) {
                                    this.cd.loadlist = 3 + (this.cd.action - 14) * 6;
                                    this.cd.action = 11;
                                    this.cd.sparkactionloader();
                                }
                                if (drawcarb(true, null, "Class B Cars", 337, 195, paramInt1, paramInt2, paramBoolean) && this.cntflock == 0) {
                                    this.cd.loadlist = 4 + (this.cd.action - 14) * 6;
                                    this.cd.action = 11;
                                    this.cd.sparkactionloader();
                                }
                                if (drawcarb(true, null, "Class B & C Cars", 337, 225, paramInt1, paramInt2, paramBoolean) && this.cntflock == 0) {
                                    this.cd.loadlist = 5 + (this.cd.action - 14) * 6;
                                    this.cd.action = 11;
                                    this.cd.sparkactionloader();
                                }
                                if (drawcarb(true, null, "Class C Cars", 337, 255, paramInt1, paramInt2, paramBoolean) && this.cntflock == 0) {
                                    this.cd.loadlist = 6 + (this.cd.action - 14) * 6;
                                    this.cd.action = 11;
                                    this.cd.sparkactionloader();
                                }
                            }
                            if (this.cd.action == 0) {
                                drawcs(91, "Top 20 Most Added Public Custom Cars", 0, 0, 0, 3);
                                if (drawcarb(true, null, "  Weekly Top 20  ", 338, 125, paramInt1, paramInt2, paramBoolean))
                                    this.cd.action = 14;
                                if (drawcarb(true, null, "  Monthly Top 20  ", 337, 165, paramInt1, paramInt2, paramBoolean))
                                    this.cd.action = 15;
                                if (drawcarb(true, null, "  Semi-Annual Top 20  ", 321, 205, paramInt1, paramInt2, paramBoolean))
                                    this.cd.action = 16;
                                if (drawcarb(true, null, "  Annual Top 20  ", 339, 245, paramInt1, paramInt2, paramBoolean))
                                    this.cd.action = 17;
                                if (this.cntflock != 20) this.cntflock = 20;
                            }
                        }
                    }
                    if (this.cfase == 100) {
                        if (this.cd.action == -1) {
                            drawprom(145, 170);
                            drawcs(195, "Failed to Load List.", 0, 0, 0, 3);
                            drawcs(225, "Unknown Error.  Please try again later.", 0, 0, 0, 3);
                            if (drawcarb(true, null, "   OK   ", 371, 255, paramInt1, paramInt2, paramBoolean))
                                if (this.sc[0] >= 16 && this.cd.lastload == 2 && this.sc[0] < 36) {
                                    this.cfase = 3;
                                } else {
                                    this.cfase = 0;
                                }
                        }
                        if (this.cd.action == -2) {
                            drawprom(145, 170);
                            drawcs(195, "No account cars found.", 0, 0, 0, 3);
                            drawcs(225, "" + this.cd.viewname + " does not have any published or added cars.", 0, 0, 0, 3);
                            if (drawcarb(true, null, "   OK   ", 371, 255, paramInt1, paramInt2, paramBoolean))
                                if (this.sc[0] >= 16 && this.cd.lastload == 2 && this.sc[0] < 36) {
                                    this.cfase = 3;
                                } else {
                                    this.cfase = 0;
                                }
                        }
                        if (this.cd.action == 100) {
                            this.cd.action = 101;
                            this.cd.sparkactionloader();
                        }
                        if (this.cd.action == 101) {
                            drawprom(145, 170);
                            drawcs(195, "Loading " + this.cd.viewname + "'s account cars, please wait...", 0, 0, 0, 3);
                        }
                        if (this.cd.action == 102) {
                            drawprom(145, 170);
                            drawcs(195, "Loading " + this.cd.viewname + "'s account cars, please wait...", 0, 0, 0, 3);
                            if (this.cd.nl > 0 && this.cd.nl <= 20)
                                drawcs(235, "Loading :  " + this.cd.loadnames[this.cd.nl - 1] + "", 0, 0, 0, 3);
                        }
                        if (this.cd.action == 103) {
                            this.minsl = 36;
                            this.maxsl = this.cd.xnlocars - 1;
                            i = 36;
                            this.cd.action = 0;
                            this.cfase = 101;
                        }
                    }
                    if (this.cfase == 0 && this.testdrive != 1 && this.testdrive != 2 && this.gmode == 0) {
                        char c = '_';
                        byte b1 = 5;
                        if (this.multion != 0) {
                            c = '¹';
                            b1 = 0;
                        }
                        if (this.multion == 0 && drawcarb(false, this.cmc, "", 95, 70, paramInt1, paramInt2, paramBoolean))
                            if (this.cd.lastload != 1) {
                                this.cfase = 1;
                            } else {
                                this.minsl = 16;
                                this.maxsl = this.cd.nlcars - 1;
                                i = 16;
                                this.cfase = 3;
                            }
                        if (drawcarb(false, this.myc, "", c, 105 + b1, paramInt1, paramInt2, paramBoolean))
                            if (this.cd.lastload != 2) {
                                this.cfase = 5;
                                this.showtf = false;
                                if (!this.logged) {
                                    this.cd.action = 0;
                                    this.cd.reco = -2;
                                    this.tcnt = 5;
                                    this.cntflock = 0;
                                } else {
                                    this.cd.action = 3;
                                    this.cd.sparkactionloader();
                                }
                            } else {
                                this.minsl = 16;
                                this.maxsl = this.cd.nlocars - 1;
                                if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                                    i = this.onmsc;
                                } else {
                                    i = 16;
                                }
                                this.cfase = 3;
                            }
                        if ((this.multion == 0 || this.onjoin == -1) && drawcarb(false, this.top20s, "", c, (c - 95) / 7 + 25 + b1, paramInt1, paramInt2, paramBoolean)) {
                            this.cd.action = 0;
                            this.cfase = 10;
                        }
                        if (this.remi) this.remi = false;
                    }
                    if (this.cfase == -1) if (this.autolog) {
                        this.autolog = false;
                        this.cfase = 5;
                        this.cd.action = 1;
                        this.cd.sparkactionloader();
                    } else if (this.cd.lastload != 2) {
                        this.cfase = 5;
                        this.showtf = false;
                        if (!this.logged) {
                            this.cd.action = 0;
                            this.cd.reco = -2;
                            this.tcnt = 5;
                            this.cntflock = 0;
                        } else {
                            this.cd.action = 3;
                            this.cd.sparkactionloader();
                        }
                    } else {
                        this.minsl = 16;
                        this.maxsl = this.cd.nlocars - 1;
                        if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                            i = this.onmsc;
                        } else {
                            i = 16;
                        }
                        this.cfase = 3;
                    }
                    if (this.cfase == 9) {
                        drawprom(145, 95);
                        drawcs(175, "Failed to remove car.  Unkown Error.  Try again laster.", 0, 0, 0, 3);
                        if (drawcarb(true, null, "   OK   ", 371, 195, paramInt1, paramInt2, paramBoolean)) {
                            this.minsl = 16;
                            this.maxsl = this.cd.nlocars - 1;
                            if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                                i = this.onmsc;
                            } else {
                                i = 16;
                            }
                            this.cfase = 3;
                        }
                    }
                    if (this.cfase == 7) {
                        if (this.app.mycar.isShowing()) this.app.mycar.hide();
                        drawprom(145, 95);
                        drawcs(175, "Remove this car from your account?", 0, 0, 0, 3);
                        if (drawcarb(true, null, " Yes ", 354, 195, paramInt1, paramInt2, paramBoolean)) {
                            this.remi = true;
                            this.minsl = 0;
                            this.maxsl = 15;
                            i = 15;
                            this.cfase = 8;
                            this.onmsc = this.sc[0];
                            this.cd.ac = this.sc[0];
                            this.cd.action = 10;
                            this.cd.sparkactionloader();
                        }
                        if (drawcarb(true, null, " No ", 408, 195, paramInt1, paramInt2, paramBoolean)) this.cfase = 3;
                    }
                    if (this.cfase == 3 && i == -1) {
                        char c = '_';
                        byte b1 = 5;
                        if (this.multion != 0) {
                            c = '¹';
                            b1 = 0;
                        }
                        if (drawcarb(false, this.gac, "", c, 105 + b1, paramInt1, paramInt2, paramBoolean)) {
                            this.minsl = 0;
                            this.maxsl = 15;
                            if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                                i = this.onmsc;
                            } else {
                                i = 15;
                            }
                            this.cfase = 0;
                        }
                        if (this.multion == 0) {
                            if (!this.app.openm) {
                                if (!this.app.mycar.isShowing()) {
                                    this.app.mycar.show();
                                    this.app.mycar.setState(this.cd.include[this.sc[0] - 16]);
                                }
                            } else {
                                this.app.mycar.hide();
                            }
                            this.rd.setColor(new Color(198, 179, 129));
                            this.rd.fillRoundRect(305, 302, 190, 24, 7, 20);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(305, 302, 190, 24, 7, 20);
                            this.app.movefield(this.app.mycar, 334, 306, 150, 17);
                            if (this.app.mycar.getState() != this.cd.include[this.sc[0] - 16]) {
                                this.cd.include[this.sc[0] - 16] = this.app.mycar.getState();
                                this.app.requestFocus();
                            }
                        }
                        if ((this.multion == 0 || this.onjoin == -1) && drawcarb(false, this.top20s, "", c, (c - 95) / 7 + 25 + b1, paramInt1, paramInt2, paramBoolean)) {
                            this.cd.action = 0;
                            this.cfase = 10;
                            if (this.app.mycar.isShowing()) this.app.mycar.hide();
                        }
                        if (this.cd.lastload == 2) {
                            if (drawcarb(true, null, "X", 567, 135, paramInt1, paramInt2, paramBoolean)) this.cfase = 7;
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.setColor(new Color(0, 0, 0));
                            if (!this.cd.createdby[this.sc[0] - 16].equals(this.nickname)) {
                                bool = clink(this.cd.createdby[this.sc[0] - 16], paramInt1, paramInt2, paramBoolean);
                            } else {
                                this.rd.drawString("Created by You", 241, 160);
                            }
                        }
                        if (this.remi) this.remi = false;
                        if (this.noclass) {
                            drawprom(200, 95);
                            this.rd.setFont(new Font("Arial", 1, 13));
                            this.ftm = this.rd.getFontMetrics();
                            String str = "Class C";
                            if (this.ontyp == 2) str = "Class B or C";
                            if (this.ontyp == 3) str = "Class B";
                            if (this.ontyp == 4) str = "Class A or B";
                            if (this.ontyp == 5) str = "Class A";
                            drawcs(230, "You do not have a " + str + " car in your account cars.", 0, 0, 0, 3);
                            if (drawcarb(true, null, "   OK   ", 371, 250, paramInt1, paramInt2, paramBoolean))
                                this.noclass = false;
                        }
                    }
                    if ((this.cfase == 11 || this.cfase == 101) && i == -1) {
                        if (this.cd.action == -9) {
                            drawprom(145, 95);
                            drawcs(175, "Unknown error!  Failed to add car.  Try again later.", 0, 0, 0, 3);
                            if (drawcarb(true, null, " OK ", 379, 195, paramInt1, paramInt2, paramBoolean))
                                this.cd.action = 0;
                        }
                        if (this.cd.action == -8) {
                            drawprom(145, 95);
                            drawcs(175, "Failed.  You already have 20 cars in your account!", 0, 0, 0, 3);
                            if (drawcarb(true, null, " OK ", 379, 195, paramInt1, paramInt2, paramBoolean))
                                this.cd.action = 0;
                        }
                        if (this.cd.action == -7) {
                            drawprom(145, 95);
                            drawcs(175, "You already have this car!", 0, 0, 0, 3);
                            if (drawcarb(true, null, " OK ", 379, 195, paramInt1, paramInt2, paramBoolean))
                                this.cd.action = 0;
                        }
                        if (this.cd.action == 7) {
                            drawprom(145, 95);
                            drawcs(175, "" + this.cd.names[this.cd.ac] + " has been successfully added to your cars!", 0, 0, 0, 3);
                            if (drawcarb(true, null, " OK ", 379, 195, paramInt1, paramInt2, paramBoolean))
                                this.cd.action = 0;
                        }
                        if (this.cd.action == 6) {
                            drawprom(145, 95);
                            drawcs(195, "Adding " + this.cd.names[this.cd.ac] + " to your cars...", 0, 0, 0, 3);
                        }
                        char c = '_';
                        byte b1 = 5;
                        if (this.multion != 0) {
                            c = '¹';
                            b1 = 0;
                        }
                        if (this.onmsc >= 16 && (this.cd.lastload == 2 || this.cd.lastload == -2)) {
                            if (drawcarb(false, this.myc, "", c, 105 + b1, paramInt1, paramInt2, paramBoolean)) {
                                if (this.cd.lastload != 2) {
                                    this.cfase = 5;
                                    this.showtf = false;
                                    if (!this.logged) {
                                        this.cd.action = 0;
                                        this.cd.reco = -2;
                                        this.tcnt = 5;
                                        this.cntflock = 0;
                                    } else {
                                        this.cd.action = 3;
                                        this.cd.sparkactionloader();
                                    }
                                } else {
                                    this.cd.action = 0;
                                    this.minsl = 16;
                                    this.maxsl = this.cd.nlocars - 1;
                                    if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                                        i = this.onmsc;
                                    } else {
                                        i = 16;
                                    }
                                    this.cfase = 3;
                                }
                                this.app.moused = false;
                            }
                        } else if (drawcarb(false, this.gac, "", c, 105 + b1, paramInt1, paramInt2, paramBoolean)) {
                            this.cd.action = 0;
                            this.minsl = 0;
                            this.maxsl = 15;
                            if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                                i = this.onmsc;
                            } else {
                                i = 15;
                            }
                            this.cfase = 0;
                            this.app.moused = false;
                        }
                        if (drawcarb(false, this.top20s, "", c, (c - 95) / 7 + 25 + b1, paramInt1, paramInt2, paramBoolean)) {
                            this.cd.action = 0;
                            this.cfase = 10;
                        }
                        if (this.cd.action == 0) {
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.setColor(new Color(0, 0, 0));
                            if (!this.cd.createdby[this.sc[0] - 16].equals(this.nickname)) {
                                bool = clink(this.cd.createdby[this.sc[0] - 16], paramInt1, paramInt2, paramBoolean);
                            } else {
                                this.rd.drawString("Created by You", 241, 160);
                            }
                            if (this.cfase != 101) {
                                this.rd.setFont(new Font("Arial", 1, 11));
                                this.rd.drawString("Added by :  " + this.cd.adds[this.sc[0] - 36] + " Players", 241, 180);
                            }
                        }
                    }
                    if (this.cfase == 5) {
                        drawprom(145, 170);
                        if (this.cd.action == 5) {
                            this.minsl = 16;
                            this.maxsl = this.cd.nlocars - 1;
                            if (this.cd.inslot != -1) {
                                this.onmsc = this.cd.inslot;
                                this.cd.inslot = -1;
                            }
                            if (this.onmsc >= this.minsl && this.onmsc <= this.maxsl) {
                                i = this.onmsc;
                            } else {
                                i = 16;
                            }
                            this.cfase = 3;
                        }
                        if (this.cd.action == 4) {
                            drawcs(195, "[  Loading Car  ]", 0, 0, 0, 3);
                            drawcs(235, "Loading :  " + this.app.mcars.getSelectedItem() + "", 0, 0, 0, 3);
                        }
                        if (this.cd.action == -2) {
                            drawcs(195, "Unknown Connection Error", 0, 0, 0, 3);
                            drawcs(225, "Failed to connect to server, try again later!", 0, 0, 0, 3);
                            if (drawcarb(true, null, "   OK   ", 371, 255, paramInt1, paramInt2, paramBoolean))
                                this.cfase = 0;
                        }
                        if (this.cd.action == -1) {
                            drawcs(195, "No published cars found...", 0, 0, 0, 3);
                            drawcs(225, "You have no added cars to your account yet!", 0, 0, 0, 3);
                            if (drawcarb(true, null, "   OK   ", 371, 255, paramInt1, paramInt2, paramBoolean))
                                this.cfase = 0;
                        }
                        if (this.cd.action == 2 || this.cd.action == 3) {
                            drawcs(195, "Loading your Account Cars list...", 0, 0, 0, 3);
                            if (this.cd.action == 2) {
                                this.backlog = this.nickname = this.app.tnick.getText();
                                this.nickey = this.cd.tnickey;
                                this.clan = this.cd.tclan;
                                this.clankey = this.cd.tclankey;
                                this.app.setloggedcookie();
                                this.logged = true;
                                this.gotlog = true;
                                if (this.cd.reco == 0) this.acexp = 0;
                                if (this.cd.reco > 10) this.acexp = this.cd.reco - 10;
                                if (this.cd.reco == 3) this.acexp = -1;
                                if (this.cd.reco == 111)
                                    if (!this.backlog.toLowerCase().equals(this.nickname.toLowerCase())) {
                                        this.acexp = -3;
                                    } else {
                                        this.acexp = 0;
                                    }
                                if (this.basefase == 0) this.cd.action = 3;
                                if (this.basefase == 11) {
                                    this.cd.action = 6;
                                    this.cfase = 11;
                                }
                                if (this.basefase == 101) {
                                    this.cd.action = 6;
                                    this.cfase = 101;
                                }
                            }
                        }
                        if (this.cd.action == 1) drawcs(195, "Logging in to your account...", 0, 0, 0, 3);
                        if (this.cd.action == 0) {
                            if (this.cd.reco == -5) drawcs(171, "Login to Add this Car to your Account", 0, 0, 0, 3);
                            if (this.cd.reco == -2) drawcs(171, "Login to Retrieve your Account Cars", 0, 0, 0, 3);
                            if (this.cd.reco == -1)
                                drawcs(171, "Unable to connect to server, try again later!", 0, 8, 0, 3);
                            if (this.cd.reco == 1)
                                drawcs(171, "Sorry.  The Nickname you have entered is incorrect.", 0, 0, 0, 3);
                            if (this.cd.reco == 2)
                                drawcs(171, "Sorry.  The Password you have entered is incorrect.", 0, 0, 0, 3);
                            if (this.cd.reco == -167 || this.cd.reco == -177) {
                                if (this.cd.reco == -167) {
                                    this.backlog = this.nickname = this.app.tnick.getText();
                                    this.cd.reco = -177;
                                }
                                drawcs(171, "You are currently using a trial account.", 0, 0, 0, 3);
                            }
                            if (this.cd.reco == -3 && (this.tcnt % 3 != 0 || this.tcnt > 20))
                                drawcs(171, "Please enter your Nickname!", 0, 0, 0, 3);
                            if (this.cd.reco == -4 && (this.tcnt % 3 != 0 || this.tcnt > 20))
                                drawcs(171, "Please enter your Password!", 0, 0, 0, 3);
                            if (!this.showtf) {
                                this.app.tnick.show();
                                this.app.tnick.setBackground(new Color(206, 237, 255));
                                if (this.cd.reco != 1) {
                                    if (this.cd.reco != 2) this.app.tnick.setText(this.nickname);
                                    this.app.tnick.setForeground(new Color(0, 0, 0));
                                } else {
                                    this.app.tnick.setForeground(new Color(255, 0, 0));
                                }
                                this.app.tnick.requestFocus();
                                this.app.tpass.show();
                                this.app.tpass.setBackground(new Color(206, 237, 255));
                                if (this.cd.reco != 2) {
                                    if (!this.autolog) this.app.tpass.setText("");
                                    this.app.tpass.setForeground(new Color(0, 0, 0));
                                } else {
                                    this.app.tpass.setForeground(new Color(255, 0, 0));
                                }
                                if (!this.app.tnick.getText().equals("") && this.cd.reco != 1)
                                    this.app.tpass.requestFocus();
                                this.showtf = true;
                            }
                            this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 201);
                            this.rd.drawString("Password:", 376 - this.ftm.stringWidth("Password:") - 14, 231);
                            this.app.movefieldd(this.app.tnick, 376, 185, 129, 23, true);
                            this.app.movefieldd(this.app.tpass, 376, 215, 129, 23, true);
                            if (this.tcnt < 30) {
                                this.tcnt++;
                                if (this.tcnt == 30) {
                                    if (this.cd.reco == 2) this.app.tpass.setText("");
                                    this.app.tnick.setForeground(new Color(0, 0, 0));
                                    this.app.tpass.setForeground(new Color(0, 0, 0));
                                }
                            }
                            if (this.cd.reco != -177) {
                                if (drawcarb(true, null, "       Login       ", 347, 247, paramInt1, paramInt2, paramBoolean) && this.tcnt > 5) {
                                    this.tcnt = 0;
                                    if (!this.app.tnick.getText().equals("") && !this.app.tpass.getText().equals("")) {
                                        this.autolog = false;
                                        this.app.tnick.hide();
                                        this.app.tpass.hide();
                                        this.app.requestFocus();
                                        this.cd.action = 1;
                                        this.cd.sparkactionloader();
                                    } else {
                                        if (this.app.tpass.getText().equals("")) this.cd.reco = -4;
                                        if (this.app.tnick.getText().equals("")) this.cd.reco = -3;
                                    }
                                }
                            } else if (drawcarb(true, null, "  Upgrade to have your own cars!  ", 284, 247, paramInt1, paramInt2, paramBoolean) && this.cntflock == 0) {
                                this.app.editlink(this.nickname, true);
                                this.cntflock = 100;
                            }
                            if (drawcarb(true, null, "  Cancel  ", 409, 282, paramInt1, paramInt2, paramBoolean)) {
                                this.app.tnick.hide();
                                this.app.tpass.hide();
                                this.app.requestFocus();
                                this.cfase = this.basefase;
                            }
                            if (drawcarb(true, null, "  Register!  ", 316, 282, paramInt1, paramInt2, paramBoolean)) {
                                if (this.cntflock == 0) {
                                    this.app.reglink();
                                    this.cntflock = 100;
                                }
                            } else if (this.cntflock != 0) {
                                this.cntflock--;
                            }
                        }
                    }
                    if (this.cfase == 4) {
                        drawprom(145, 150);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Failed to find any ready car in your ‘mycars’ folder!", 215, 175);
                        this.rd.drawString("Please ‘Test Drive’ your cars in the Car Maker to make", 215, 215);
                        this.rd.drawString("sure they are ready.", 215, 235);
                        if (drawcarb(true, null, "   OK   ", 371, 255, paramInt1, paramInt2, paramBoolean))
                            this.cfase = 0;
                    }
                    if (this.cfase == 2) {
                        drawprom(165, 70);
                        drawcs(205, "Loading Car Maker Cars...", 0, 0, 0, 3);
                        this.app.repaint();
                        this.cd.loadcarmaker();
                        if (this.cd.nlcars > 16) {
                            this.minsl = 16;
                            this.maxsl = this.cd.nlcars - 1;
                            i = 16;
                            this.cfase = 3;
                        } else {
                            this.cfase = 4;
                        }
                    }
                    if (this.cfase == 1) {
                        drawprom(145, 170);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("The game will now load all the cars that can be loaded", 215, 170);
                        this.rd.drawString("from your ‘mycars’ folder.", 215, 190);
                        this.rd.drawString("If a car is not loaded, then it is not ready (not finished).", 215, 210);
                        this.rd.drawString("Perform a ‘Test Drive’ on any car to see if it is ready or not.", 215, 230);
                        this.rd.drawString("The maximum number of cars that can be loaded is  40 !", 215, 260);
                        if (drawcarb(true, null, "   OK   ", 371, 275, paramInt1, paramInt2, paramBoolean))
                            this.cfase = 2;
                    }
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(181, 120, 40));
                    this.rd.drawString("Top Speed:", 98, 343);
                    this.rd.drawImage(this.statb, 162, 337, (ImageObserver) null);
                    this.rd.drawString("Acceleration:", 88, 358);
                    this.rd.drawImage(this.statb, 162, 352, (ImageObserver) null);
                    this.rd.drawString("Handling:", 110, 373);
                    this.rd.drawImage(this.statb, 162, 367, (ImageObserver) null);
                    this.rd.drawString("Stunts:", 495, 343);
                    this.rd.drawImage(this.statb, 536, 337, (ImageObserver) null);
                    this.rd.drawString("Strength:", 483, 358);
                    this.rd.drawImage(this.statb, 536, 352, (ImageObserver) null);
                    this.rd.drawString("Endurance:", 473, 373);
                    this.rd.drawImage(this.statb, 536, 367, (ImageObserver) null);
                    this.rd.setColor(new Color(0, 0, 0));
                    float f1 = (this.cd.swits[this.sc[0]][2] - 220) / 90.0F;
                    if (f1 < 0.2D) f1 = 0.2F;
                    this.rd.fillRect((int) (162.0F + 156.0F * f1), 337, (int) (156.0F * (1.0F - f1) + 1.0F), 7);
                    f1 = this.cd.acelf[this.sc[0]][1] * this.cd.acelf[this.sc[0]][0] * this.cd.acelf[this.sc[0]][2] * this.cd.grip[this.sc[0]] / 7700.0F;
                    if (f1 > 1.0F) f1 = 1.0F;
                    this.rd.fillRect((int) (162.0F + 156.0F * f1), 352, (int) (156.0F * (1.0F - f1) + 1.0F), 7);
                    f1 = this.cd.dishandle[this.sc[0]];
                    this.rd.fillRect((int) (162.0F + 156.0F * f1), 367, (int) (156.0F * (1.0F - f1) + 1.0F), 7);
                    f1 = (this.cd.airc[this.sc[0]] * this.cd.airs[this.sc[0]] * this.cd.bounce[this.sc[0]] + 28.0F) / 139.0F;
                    if (f1 > 1.0F) f1 = 1.0F;
                    this.rd.fillRect((int) (536.0F + 156.0F * f1), 337, (int) (156.0F * (1.0F - f1) + 1.0F), 7);
                    float f2 = 0.5F;
                    f1 = (this.cd.moment[this.sc[0]] + f2) / 2.6F;
                    if (f1 > 1.0F) f1 = 1.0F;
                    this.rd.fillRect((int) (536.0F + 156.0F * f1), 352, (int) (156.0F * (1.0F - f1) + 1.0F), 7);
                    f1 = this.cd.outdam[this.sc[0]];
                    this.rd.fillRect((int) (536.0F + 156.0F * f1), 367, (int) (156.0F * (1.0F - f1) + 1.0F), 7);
                    this.rd.drawImage(this.statbo, 162, 337, (ImageObserver) null);
                    this.rd.drawImage(this.statbo, 162, 352, (ImageObserver) null);
                    this.rd.drawImage(this.statbo, 162, 367, (ImageObserver) null);
                    this.rd.drawImage(this.statbo, 536, 337, (ImageObserver) null);
                    this.rd.drawImage(this.statbo, 536, 352, (ImageObserver) null);
                    this.rd.drawImage(this.statbo, 536, 367, (ImageObserver) null);
                    if (this.multion != 0 || this.testdrive == 1 || this.testdrive == 2) {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        String str = "Class C";
                        if (this.cd.cclass[this.sc[0]] == 1) str = "Class B & C";
                        if (this.cd.cclass[this.sc[0]] == 2) str = "Class B";
                        if (this.cd.cclass[this.sc[0]] == 3) str = "Class A & B";
                        if (this.cd.cclass[this.sc[0]] == 4) str = "Class A";
                        if (this.kbload < 7) {
                            this.rd.setColor(new Color(0, 0, 0));
                            this.kbload++;
                        } else {
                            this.rd.setColor(new Color(176, 41, 0));
                            this.kbload = 0;
                        }
                        if (this.cfase != 10 || (this.cd.action != 0 && this.cd.action < 14))
                            this.rd.drawString(str, 549 - this.ftm.stringWidth(str) / 2, 95);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("1st Color", 100, 55);
                        this.rd.drawString("2nd Color", 649, 55);
                        this.rd.setFont(new Font("Arial", 1, 10));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Hue  | ", 97, 70);
                        this.rd.drawImage(this.brt, 137, 63, (ImageObserver) null);
                        this.rd.drawString("Hue  | ", 647, 70);
                        this.rd.drawImage(this.brt, 687, 63, (ImageObserver) null);
                        this.rd.drawString("Intensity", 121, 219);
                        this.rd.drawString("Intensity", 671, 219);
                        this.rd.drawString("Reset", 110, 257);
                        this.rd.drawString("Reset", 660, 257);
                        byte b1;
                        for (b1 = 0; b1 < '¡'; b1++) {
                            this.rd.setColor(Color.getHSBColor((float) (b1 * 0.00625D), 1.0F, 1.0F));
                            this.rd.drawLine(102, 75 + b1, 110, 75 + b1);
                            if (b1 <= '') {
                                this.rd.setColor(Color.getHSBColor(1.0F, 0.0F, (float) (1.0D - b1 * 0.00625D)));
                                this.rd.drawLine(137, 75 + b1, 145, 75 + b1);
                            }
                            this.rd.setColor(Color.getHSBColor((float) (b1 * 0.00625D), 1.0F, 1.0F));
                            this.rd.drawLine(652, 75 + b1, 660, 75 + b1);
                            if (b1 <= '') {
                                this.rd.setColor(Color.getHSBColor(1.0F, 0.0F, (float) (1.0D - b1 * 0.00625D)));
                                this.rd.drawLine(687, 75 + b1, 695, 75 + b1);
                            }
                        }
                        for (b1 = 0; b1 < 40; b1++) {
                            this.rd.setColor(Color.getHSBColor(this.arnp[0], (float) (b1 * 0.025D), 1.0F - this.arnp[2]));
                            this.rd.drawLine(121 + b1, 224, 121 + b1, 230);
                            this.rd.setColor(Color.getHSBColor(this.arnp[3], (float) (b1 * 0.025D), 1.0F - this.arnp[5]));
                            this.rd.drawLine(671 + b1, 224, 671 + b1, 230);
                        }
                        this.rd.drawImage(this.arn, 110, 71 + (int) (this.arnp[0] * 160.0F), (ImageObserver) null);
                        this.rd.drawImage(this.arn, 145, 71 + (int) (this.arnp[2] * 160.0F), (ImageObserver) null);
                        this.rd.drawImage(this.arn, 660, 71 + (int) (this.arnp[3] * 160.0F), (ImageObserver) null);
                        this.rd.drawImage(this.arn, 695, 71 + (int) (this.arnp[5] * 160.0F), (ImageObserver) null);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.fillRect(120 + (int) (this.arnp[1] * 40.0F), 222, 3, 3);
                        this.rd.drawLine(121 + (int) (this.arnp[1] * 40.0F), 224, 121 + (int) (this.arnp[1] * 40.0F), 230);
                        this.rd.fillRect(120 + (int) (this.arnp[1] * 40.0F), 230, 3, 3);
                        this.rd.fillRect(670 + (int) (this.arnp[4] * 40.0F), 222, 3, 3);
                        this.rd.drawLine(671 + (int) (this.arnp[4] * 40.0F), 224, 671 + (int) (this.arnp[4] * 40.0F), 230);
                        this.rd.fillRect(670 + (int) (this.arnp[4] * 40.0F), 230, 3, 3);
                        if (paramBoolean) {
                            if (this.mouson == -1) {
                                if (paramInt1 > 96 && paramInt1 < 152 && paramInt2 > 248 && paramInt2 < 258) {
                                    float[] arrayOfFloat = new float[3];
                                    Color.RGBtoHSB((paramArrayOfContO[this.sc[0]]).fcol[0], (paramArrayOfContO[this.sc[0]]).fcol[1], (paramArrayOfContO[this.sc[0]]).fcol[2], arrayOfFloat);
                                    this.arnp[0] = arrayOfFloat[0];
                                    this.arnp[1] = arrayOfFloat[1];
                                    this.arnp[2] = 1.0F - arrayOfFloat[2];
                                }
                                if (paramInt1 > 646 && paramInt1 < 702 && paramInt2 > 248 && paramInt2 < 258) {
                                    float[] arrayOfFloat = new float[3];
                                    Color.RGBtoHSB((paramArrayOfContO[this.sc[0]]).scol[0], (paramArrayOfContO[this.sc[0]]).scol[1], (paramArrayOfContO[this.sc[0]]).scol[2], arrayOfFloat);
                                    this.arnp[3] = arrayOfFloat[0];
                                    this.arnp[4] = arrayOfFloat[1];
                                    this.arnp[5] = 1.0F - arrayOfFloat[2];
                                }
                                this.mouson = -2;
                                if (paramInt1 > 119 && paramInt1 < 163 && paramInt2 > 222 && paramInt2 < 232)
                                    this.mouson = 1;
                                if (paramInt1 > 669 && paramInt1 < 713 && paramInt2 > 222 && paramInt2 < 232)
                                    this.mouson = 4;
                                if (paramInt1 > 98 && paramInt1 < 122 && paramInt2 > 69 && paramInt2 < 241 && this.mouson == -2)
                                    this.mouson = 0;
                                if (paramInt1 > 133 && paramInt1 < 157 && paramInt2 > 69 && paramInt2 < 209 && this.mouson == -2)
                                    this.mouson = 2;
                                if (paramInt1 > 648 && paramInt1 < 672 && paramInt2 > 69 && paramInt2 < 241 && this.mouson == -2)
                                    this.mouson = 3;
                                if (paramInt1 > 683 && paramInt1 < 707 && paramInt2 > 69 && paramInt2 < 209 && this.mouson == -2)
                                    this.mouson = 5;
                            }
                        } else if (this.mouson != -1) {
                            this.mouson = -1;
                        }
                        if (this.mouson == 0 || this.mouson == 2 || this.mouson == 3 || this.mouson == 5) {
                            this.arnp[this.mouson] = (float) ((paramInt2 - 75.0F) * 0.00625D);
                            if (this.mouson == 2 || this.mouson == 5) {
                                if (this.arnp[this.mouson] > 0.8D) this.arnp[this.mouson] = 0.8F;
                            } else if (this.arnp[this.mouson] > 1.0F) {
                                this.arnp[this.mouson] = 1.0F;
                            }
                            if (this.arnp[this.mouson] < 0.0F) this.arnp[this.mouson] = 0.0F;
                        }
                        if (this.mouson == 1) {
                            this.arnp[this.mouson] = (float) ((paramInt1 - 121.0F) * 0.025D);
                            if (this.arnp[this.mouson] > 1.0F) this.arnp[this.mouson] = 1.0F;
                            if (this.arnp[this.mouson] < 0.0F) this.arnp[this.mouson] = 0.0F;
                        }
                        if (this.mouson == 4) {
                            this.arnp[this.mouson] = (float) ((paramInt1 - 671.0F) * 0.025D);
                            if (this.arnp[this.mouson] > 1.0F) this.arnp[this.mouson] = 1.0F;
                            if (this.arnp[this.mouson] < 0.0F) this.arnp[this.mouson] = 0.0F;
                        }
                        if (this.cfase != 10 && this.cfase != 5 && i == -1) {
                            Color color1 = Color.getHSBColor(this.arnp[0], this.arnp[1], 1.0F - this.arnp[2]);
                            Color color2 = Color.getHSBColor(this.arnp[3], this.arnp[4], 1.0F - this.arnp[5]);
                            for (byte b2 = 0; b2 < (paramArrayOfContO[this.sc[0]]).npl; b2++) {
                                if (((paramArrayOfContO[this.sc[0]]).p[b2]).colnum == 1) {
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).hsb[0] = this.arnp[0];
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).hsb[1] = this.arnp[1];
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).hsb[2] = 1.0F - this.arnp[2];
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).c[0] = color1.getRed();
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).c[1] = color1.getGreen();
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).c[2] = color1.getBlue();
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).oc[0] = color1.getRed();
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).oc[1] = color1.getGreen();
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).oc[2] = color1.getBlue();
                                }
                                if (((paramArrayOfContO[this.sc[0]]).p[b2]).colnum == 2) {
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).hsb[0] = this.arnp[3];
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).hsb[1] = this.arnp[4];
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).hsb[2] = 1.0F - this.arnp[5];
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).c[0] = color2.getRed();
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).c[1] = color2.getGreen();
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).c[2] = color2.getBlue();
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).oc[0] = color2.getRed();
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).oc[1] = color2.getGreen();
                                    ((paramArrayOfContO[this.sc[0]]).p[b2]).oc[2] = color2.getBlue();
                                }
                            }
                        }
                    }
                }
                if (!this.remi && this.cfase != 10 && this.cfase != 11 && this.cfase != 100 && this.cfase != 101) {
                    this.rd.drawImage(this.contin[this.pcontin], 355, 385, (ImageObserver) null);
                } else {
                    if (this.cfase == 11 && drawcarb(true, null, "Add to My Cars", 345, 385, paramInt1, paramInt2, paramBoolean) && this.cd.action == 0) {
                        this.cd.ac = this.sc[0];
                        if (this.logged) {
                            this.cd.action = 6;
                            this.cd.sparkactionloader();
                        } else {
                            this.cd.reco = -5;
                            this.cfase = 5;
                            this.showtf = false;
                        }
                    }
                    if (this.cfase == 101 && i == -1)
                        if (this.cd.publish[this.sc[0] - 16] == 1 || this.cd.publish[this.sc[0] - 16] == 2) {
                            if (drawcarb(true, null, "Add to My Cars", 345, 385, paramInt1, paramInt2, paramBoolean) && this.cd.action == 0) {
                                this.cd.ac = this.sc[0];
                                if (this.logged) {
                                    this.cd.action = 6;
                                    this.cd.sparkactionloader();
                                } else {
                                    this.cd.reco = -5;
                                    this.cfase = 5;
                                    this.showtf = false;
                                }
                            }
                        } else {
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            drawcs(405, "Private Car", 193, 106, 0, 3);
                        }
                }
            }
        } else {
            if (this.cfase == 11 || this.cfase == 101) this.cd.action = 0;
            if (this.app.mycar.isShowing()) this.app.mycar.hide();
            this.pback = 0;
            this.pnext = 0;
            this.gatey = 300;
            if (this.flipo > 10) {
                (paramArrayOfContO[this.sc[0]]).y -= 100;
                if (this.nextc == 1) (paramArrayOfContO[this.sc[0]]).zy += 20;
                if (this.nextc == -1) (paramArrayOfContO[this.sc[0]]).zy -= 20;
            } else {
                if (this.flipo == 10) {
                    if (this.nextc >= 20) {
                        this.sc[0] = this.nextc - 20;
                        this.lsc = -1;
                    }
                    if (this.nextc == 1) {
                        this.sc[0] = this.sc[0] + 1;
                        if (this.gmode == 1) {
                            if (this.sc[0] == 7) this.sc[0] = 11;
                            if (this.sc[0] == 12) this.sc[0] = 14;
                        }
                        if (this.multion != 0 && this.onjoin != -1 && this.ontyp > 0 && this.ontyp <= 5)
                            for (; this.sc[0] < this.maxsl && Math.abs(this.cd.cclass[this.sc[0]] - this.ontyp - 1) > 1; this.sc[0] = this.sc[0] + 1)
                                ;
                    }
                    if (this.nextc == -1) {
                        this.sc[0] = this.sc[0] - 1;
                        if (this.gmode == 1) {
                            if (this.sc[0] == 13) this.sc[0] = 11;
                            if (this.sc[0] == 10) this.sc[0] = 6;
                        }
                        if (this.multion != 0 && this.onjoin != -1 && this.ontyp > 0 && this.ontyp <= 5)
                            for (; this.sc[0] > this.minsl && Math.abs(this.cd.cclass[this.sc[0]] - this.ontyp - 1) > 1; this.sc[0] = this.sc[0] - 1)
                                ;
                    }
                    if (this.cfase == 3 && this.cd.lastload == 2) this.app.mcars.select(this.cd.names[this.sc[0]]);
                    (paramArrayOfContO[this.sc[0]]).z = 950;
                    (paramArrayOfContO[this.sc[0]]).y = -34 - (paramArrayOfContO[this.sc[0]]).grat - 1100;
                    (paramArrayOfContO[this.sc[0]]).x = 0;
                    (paramArrayOfContO[this.sc[0]]).zy = 0;
                }
                (paramArrayOfContO[this.sc[0]]).y += 100;
            }
            this.flipo--;
        }
        if (this.cfase == 0 || this.cfase == 3 || this.cfase == 11 || this.cfase == 101) {
            this.basefase = this.cfase;
            if (i != -1) {
                if (this.flatrstart > 1) this.flatrstart = 0;
                this.nextc = i + 20;
                this.flipo = 20;
            }
            if (paramControl.right) {
                paramControl.right = false;
                if (this.sc[0] != this.maxsl && this.flipo == 0) {
                    if (this.flatrstart > 1) this.flatrstart = 0;
                    this.nextc = 1;
                    this.flipo = 20;
                }
            }
            if (paramControl.left) {
                paramControl.left = false;
                if (this.sc[0] != this.minsl && this.flipo == 0) {
                    if (this.flatrstart > 1) this.flatrstart = 0;
                    this.nextc = -1;
                    this.flipo = 20;
                }
            }
            if (this.cfase != 11 && this.cfase != 101 && j == 0 && this.flipo < 10 && (paramControl.handb || paramControl.enter)) {
                this.m.crs = false;
                this.app.mcars.show = false;
                if (this.multion != 0) {
                    this.fase = 1177;
                    this.intertrack.stop();
                } else if (this.testdrive != 3 && this.testdrive != 4) {
                    this.fase = 3;
                } else {
                    this.fase = -22;
                }
                if (this.sc[0] < 16 || this.cd.lastload == 2)
                    this.app.setcarcookie(this.sc[0], this.cd.names[this.sc[0]], this.arnp, this.gmode, this.unlocked, this.mtop);
                if (this.cd.haltload != 0) {
                    if (this.cd.haltload == 2) this.cd.lcardate[1] = 0;
                    this.cd.lcardate[0] = 0;
                    this.cd.haltload = 0;
                }
                if (this.gmode == 0) this.osc = this.sc[0];
                if (this.gmode == 1) this.scm[0] = this.sc[0];
                if (this.gmode == 2) this.scm[1] = this.sc[0];
                if (this.app.mycar.isShowing()) this.app.mycar.hide();
                this.flexpix = null;
                paramControl.handb = false;
                paramControl.enter = false;
            }
        } else {
            this.pback = 0;
            this.pnext = 0;
            this.pcontin = 0;
            if (this.cfase == 8 && i != -1) {
                if (this.flatrstart > 1) this.flatrstart = 0;
                this.nextc = i + 20;
                this.flipo = 20;
            }
            if (this.cfase == 5 && this.cd.action == 0 && paramControl.enter) {
                this.tcnt = 0;
                if (!this.app.tnick.getText().equals("") && !this.app.tpass.getText().equals("")) {
                    this.app.tnick.hide();
                    this.app.tpass.hide();
                    this.app.requestFocus();
                    this.cd.action = 1;
                    this.cd.sparkactionloader();
                } else {
                    if (this.app.tpass.getText().equals("")) this.cd.reco = -4;
                    if (this.app.tnick.getText().equals("")) this.cd.reco = -3;
                }
                paramControl.enter = false;
            }
        }
        if (paramControl.handb || paramControl.enter) {
            paramControl.handb = false;
            paramControl.enter = false;
        }
        if (bool) {
            this.app.mouses = 0;
            this.onviewpro = true;
            this.cd.viewname = this.cd.createdby[this.sc[0] - 16];
            this.m.crs = false;
            this.fase = 1177;
            this.intertrack.stop();
            this.sc[0] = this.onmsc;
            if ((this.sc[0] >= 16 && this.cd.lastload != 2) || this.sc[0] >= 36) this.sc[0] = 15;
            this.osc = this.sc[0];
            this.multion = 1;
            this.gmode = 0;
            if (this.app.mycar.isShowing()) this.app.mycar.hide();
            this.flexpix = null;
            paramControl.handb = false;
            paramControl.enter = false;
        }
    }

    public void colorCar(ContO paramContO, int paramInt) {
        if (this.plnames[paramInt].indexOf("MadBot") == -1) {
            for (byte b = 0; b < paramContO.npl; b++) {
                if ((paramContO.p[b]).colnum == 1) {
                    Color color = Color.getHSBColor(this.allrnp[paramInt][0], this.allrnp[paramInt][1], 1.0F - this.allrnp[paramInt][2]);
                    (paramContO.p[b]).oc[0] = color.getRed();
                    (paramContO.p[b]).oc[1] = color.getGreen();
                    (paramContO.p[b]).oc[2] = color.getBlue();
                }
                if ((paramContO.p[b]).colnum == 2) {
                    Color color = Color.getHSBColor(this.allrnp[paramInt][3], this.allrnp[paramInt][4], 1.0F - this.allrnp[paramInt][5]);
                    (paramContO.p[b]).oc[0] = color.getRed();
                    (paramContO.p[b]).oc[1] = color.getGreen();
                    (paramContO.p[b]).oc[2] = color.getBlue();
                }
            }
        } else {
            for (byte b = 0; b < paramContO.npl; b++) {
                if ((paramContO.p[b]).colnum == 1) {
                    (paramContO.p[b]).oc[0] = paramContO.fcol[0];
                    (paramContO.p[b]).oc[1] = paramContO.fcol[1];
                    (paramContO.p[b]).oc[2] = paramContO.fcol[2];
                }
                if ((paramContO.p[b]).colnum == 2) {
                    (paramContO.p[b]).oc[0] = paramContO.scol[0];
                    (paramContO.p[b]).oc[1] = paramContO.scol[1];
                    (paramContO.p[b]).oc[2] = paramContO.scol[2];
                }
            }
        }
    }

    public boolean clink(String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {
        boolean bool = false;
        this.rd.drawString("Created by :  " + paramString + "", 241, 160);
        int i = this.ftm.stringWidth(paramString);
        int j = 241 + this.ftm.stringWidth("Created by :  " + paramString + "") - i;
        this.rd.drawLine(j, 162, j + i - 2, 162);
        if (paramInt1 > j - 2 && paramInt1 < j + i && paramInt2 > 147 && paramInt2 < 164) {
            if (paramBoolean) bool = true;
            if (this.waitlink != 1) {
                this.app.setCursor(new Cursor(12));
                this.waitlink = 1;
            }
        } else if (this.waitlink != 0) {
            this.app.setCursor(new Cursor(0));
            this.waitlink = 0;
        }
        return bool;
    }

    public void drawprom(int paramInt1, int paramInt2) {
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.76F));
        this.rd.setColor(new Color(129, 203, 237));
        this.rd.fillRoundRect(205, paramInt1, 390, paramInt2, 30, 30);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.drawRoundRect(205, paramInt1, 390, paramInt2, 30, 30);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
    }

    public void drawdprom(int paramInt1, int paramInt2) {
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.9F));
        this.rd.setColor(new Color(129, 203, 237));
        this.rd.fillRoundRect(205, paramInt1, 390, paramInt2, 30, 30);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.drawRoundRect(205, paramInt1, 390, paramInt2, 30, 30);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
    }

    public void drawlprom(int paramInt1, int paramInt2) {
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
        this.rd.setColor(new Color(129, 203, 237));
        this.rd.fillRoundRect(277, paramInt1, 390, paramInt2, 30, 30);
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.drawRoundRect(277, paramInt1, 390, paramInt2, 30, 30);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
    }

    public void finish(CheckPoints paramCheckPoints, ContO[] paramArrayOfContO, Control paramControl, int paramInt1, int paramInt2, boolean paramBoolean) {
        if (!this.badmac) {
            this.rd.drawImage(this.fleximg, 0, 0, (ImageObserver) null);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.1F));
            this.rd.fillRect(0, 0, 800, 450);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        }
        this.rd.setFont(new Font("Arial", 1, 11));
        this.ftm = this.rd.getFontMetrics();
        char c = Character.MIN_VALUE;
        String str = ":";
        if (paramCheckPoints.stage > 0) {
            int i = paramCheckPoints.stage;
            if (i > 10) i -= 10;
            str = " " + i + "!";
        }
        if (this.multion < 3) {
            if (this.winner) {
                this.rd.drawImage(this.congrd, 265, 87, (ImageObserver) null);
                drawcs(137, "You Won!  At Stage" + str + "", 255, 161, 85, 3);
                drawcs(154, "" + paramCheckPoints.name + "", 255, 115, 0, 3);
                c = '';
            } else {
                this.rd.drawImage(this.gameov, 315, 117, (ImageObserver) null);
                if (this.multion != 0 && (this.forstart == 700 || this.discon == 240)) {
                    drawcs(167, "Sorry, You where Disconnected from Game!", 255, 161, 85, 3);
                    drawcs(184, "Please check your connection!", 255, 115, 0, 3);
                } else {
                    drawcs(167, "You Lost!  At Stage" + str + "", 255, 161, 85, 3);
                    drawcs(184, "" + paramCheckPoints.name + "", 255, 115, 0, 3);
                    c = '¸';
                }
            }
        } else {
            this.rd.drawImage(this.gameov, 315, 117, (ImageObserver) null);
            drawcs(167, "Finished Watching Game!  At Stage" + str + "", 255, 161, 85, 3);
            drawcs(184, "" + paramCheckPoints.name + "", 255, 115, 0, 3);
            c = '¸';
        }
        if (this.winner && this.multion == 0 && this.gmode != 0)
            if (paramCheckPoints.stage == this.unlocked[this.gmode - 1] + (this.gmode - 1) * 10 || paramCheckPoints.stage == 27) {
                byte b = 0;
                char c1 = Character.MIN_VALUE;
                this.pin = 60;
                if (this.gmode == 1) {
                    if (paramCheckPoints.stage == 2) {
                        b = 5;
                        c1 = 'ŭ';
                        this.pin = -20;
                        this.scm[0] = 5;
                    }
                    if (paramCheckPoints.stage == 4) {
                        b = 6;
                        c1 = 'ŀ';
                        this.pin = -20;
                        this.scm[0] = 6;
                    }
                    if (paramCheckPoints.stage == 6) {
                        b = 11;
                        c1 = 'ņ';
                        this.pin = -20;
                        this.scm[0] = 11;
                    }
                    if (paramCheckPoints.stage == 8) {
                        b = 14;
                        c1 = 'Ş';
                        this.pin = -20;
                        this.scm[0] = 14;
                    }
                    if (paramCheckPoints.stage == 10) {
                        b = 15;
                        c1 = 'Ų';
                        this.pin = -20;
                        this.scm[0] = 15;
                    }
                }
                if (this.gmode == 2) {
                    if (paramCheckPoints.stage == 12) {
                        b = 8;
                        c1 = 'ŭ';
                        this.pin = -20;
                        this.scm[1] = 8;
                    }
                    if (paramCheckPoints.stage == 14) {
                        b = 9;
                        c1 = 'ŀ';
                        this.pin = -20;
                        this.scm[1] = 9;
                    }
                    if (paramCheckPoints.stage == 16) {
                        b = 10;
                        c1 = 'Ų';
                        this.pin = -20;
                        this.scm[1] = 10;
                    }
                    if (paramCheckPoints.stage == 18) {
                        b = 11;
                        c1 = 'ņ';
                        this.pin = -20;
                        this.scm[1] = 11;
                    }
                    if (paramCheckPoints.stage == 20) {
                        b = 12;
                        c1 = 'Ķ';
                        this.pin = -20;
                        this.scm[1] = 12;
                    }
                    if (paramCheckPoints.stage == 22) {
                        b = 13;
                        c1 = 'Ķ';
                        this.pin = -20;
                        this.scm[1] = 13;
                    }
                    if (paramCheckPoints.stage == 24) {
                        b = 14;
                        c1 = 'Ş';
                        this.pin = -20;
                        this.scm[1] = 14;
                    }
                    if (paramCheckPoints.stage == 26) {
                        b = 15;
                        c1 = 'Ų';
                        this.pin = -20;
                        this.scm[1] = 15;
                    }
                }
                if (paramCheckPoints.stage != 27) {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    if (this.aflk) {
                        drawcs(200 + this.pin, "Stage " + (paramCheckPoints.stage + 1 - (this.gmode - 1) * 10) + " is now unlocked!", 196, 176, 0, 3);
                    } else {
                        drawcs(200 + this.pin, "Stage " + (paramCheckPoints.stage + 1 - (this.gmode - 1) * 10) + " is now unlocked!", 255, 247, 165, 3);
                    }
                    if (b != 0) {
                        if (this.aflk) {
                            drawcs(200, "And:", 196, 176, 0, 3);
                        } else {
                            drawcs(200, "And:", 255, 247, 165, 3);
                        }
                        this.rd.setColor(new Color(236, 226, 202));
                        if (Math.random() > 0.5D) {
                            this.rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
                            this.rd.fillRect(226, 211, 344, 125);
                            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        }
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.fillRect(226, 211, 348, 4);
                        this.rd.fillRect(226, 211, 4, 125);
                        this.rd.fillRect(226, 332, 348, 4);
                        this.rd.fillRect(570, 211, 4, 125);
                        (paramArrayOfContO[b]).y = c1;
                        this.m.crs = true;
                        this.m.x = -400;
                        this.m.y = 0;
                        this.m.z = -50;
                        this.m.xz = 0;
                        this.m.zy = 0;
                        this.m.ground = 2470;
                        (paramArrayOfContO[b]).z = 1000;
                        (paramArrayOfContO[b]).x = 0;
                        (paramArrayOfContO[b]).xz += 5;
                        (paramArrayOfContO[b]).zy = 0;
                        (paramArrayOfContO[b]).wzy -= 10;
                        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                        paramArrayOfContO[b].d(this.rd);
                        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        if (Math.random() < 0.5D) {
                            this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                            this.rd.setColor(new Color(236, 226, 202));
                            for (byte b1 = 0; b1 < 30; ) {
                                this.rd.drawLine(230, 215 + 4 * b1, 569, 215 + 4 * b1);
                                b1++;
                            }
                            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        }
                        String str1 = "";
                        if (b == 13) str1 = " ";
                        if (this.aflk) {
                            drawcs(320, "" + this.cd.names[b] + "" + str1 + " has been unlocked!", 196, 176, 0, 3);
                        } else {
                            drawcs(320, "" + this.cd.names[b] + "" + str1 + " has been unlocked!", 255, 247, 165, 3);
                        }
                        this.pin = 140;
                    }
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    drawcs(220 + this.pin, "GAME SAVED", 230, 167, 0, 3);
                    if (this.pin == 60) {
                        this.pin = 30;
                    } else {
                        this.pin = 0;
                    }
                } else {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    if (this.aflk) {
                        drawcs(180, "Woohoooo you finished NFM" + this.gmode + " !!!", 144, 167, 255, 3);
                    } else {
                        drawcs(180, "Woohoooo you finished NFM" + this.gmode + " !!!", 228, 240, 255, 3);
                    }
                    if (this.aflk) {
                        drawcs(210, "You're Awesome!", 144, 167, 255, 3);
                    } else {
                        drawcs(212, "You're Awesome!", 228, 240, 255, 3);
                    }
                    if (this.aflk) {
                        drawcs(240, "You're truly a RADICAL GAMER!", 144, 167, 255, 3);
                    } else {
                        drawcs(240, "You're truly a RADICAL GAMER!", 255, 100, 100, 3);
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.fillRect(0, 255, 800, 62);
                    this.rd.drawImage(this.radicalplay, this.radpx + (int) (8.0D * Math.random() - 4.0D), 255, (ImageObserver) null);
                    if (this.radpx != 212) {
                        this.radpx += 40;
                        if (this.radpx > 800) this.radpx = -468;
                    }
                    if (this.flipo == 40) this.radpx = 213;
                    this.flipo++;
                    if (this.flipo == 70) this.flipo = 0;
                    if (this.radpx == 212) {
                        this.rd.setFont(new Font("Arial", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        if (this.aflk) {
                            drawcs(309, "A Game by Radicalplay.com", 144, 167, 255, 3);
                        } else {
                            drawcs(309, "A Game by Radicalplay.com", 228, 240, 255, 3);
                        }
                    }
                    if (this.aflk) {
                        drawcs(350, "Now get up and dance!", 144, 167, 255, 3);
                    } else {
                        drawcs(350, "Now get up and dance!", 228, 240, 255, 3);
                    }
                    this.pin = 0;
                }
                if (this.aflk) {
                    this.aflk = false;
                } else {
                    this.aflk = true;
                }
            }
        if (this.multion != 0 && paramCheckPoints.stage == -2 && c != '\000') {
            drawcs(c + 17, "Created by: " + paramCheckPoints.maker + "", 255, 161, 85, 3);
            if (paramCheckPoints.pubt > 0) {
                if (paramCheckPoints.pubt == 2) {
                    drawcs(310, "Super Public Stage", 41, 177, 255, 3);
                } else {
                    drawcs(310, "Public Stage", 41, 177, 255, 3);
                }
                if (this.dnload == 0 && drawcarb(true, null, " Add to My Stages ", 334, 317, paramInt1, paramInt2, paramBoolean))
                    if (this.logged) {
                        this.cd.onstage = paramCheckPoints.name;
                        this.cd.staction = 2;
                        this.cd.sparkstageaction();
                        this.dnload = 2;
                    } else {
                        this.dnload = 1;
                        this.waitlink = 20;
                    }
                if (this.dnload == 1) {
                    this.rd.setColor(new Color(193, 106, 0));
                    String str1 = "Upgrade to a full account to add custom stages!";
                    int i = 400 - this.ftm.stringWidth(str1) / 2, j = i + this.ftm.stringWidth(str1);
                    this.rd.drawString(str1, i, 332);
                    if (this.waitlink != -1) this.rd.drawLine(i, 334, j, 334);
                    if (paramInt1 > i && paramInt1 < j && paramInt2 > 321 && paramInt2 < 334) {
                        if (this.waitlink != -1) this.app.setCursor(new Cursor(12));
                        if (paramBoolean && this.waitlink == 0) {
                            this.app.editlink(this.nickname, true);
                            this.waitlink = -1;
                        }
                    } else {
                        this.app.setCursor(new Cursor(0));
                    }
                    if (this.waitlink > 0) this.waitlink--;
                }
                if (this.dnload == 2) {
                    drawcs(332, "Adding stage please wait...", 193, 106, 0, 3);
                    if (this.cd.staction == 0) this.dnload = 3;
                    if (this.cd.staction == -2) this.dnload = 4;
                    if (this.cd.staction == -3) this.dnload = 5;
                    if (this.cd.staction == -1) this.dnload = 6;
                }
                if (this.dnload == 3) drawcs(332, "Stager has been successfully added to your stages!", 193, 106, 0, 3);
                if (this.dnload == 4) drawcs(332, "You already have this stage!", 193, 106, 0, 3);
                if (this.dnload == 5) drawcs(332, "Cannot add more then 20 stages to your account!", 193, 106, 0, 3);
                if (this.dnload == 6)
                    drawcs(332, "Failed to add stage, unknown error, please try again later.", 193, 106, 0, 3);
            } else {
                drawcs(342, "Private Stage", 193, 106, 0, 3);
            }
        }
        this.rd.drawImage(this.contin[this.pcontin], 355, 380, (ImageObserver) null);
        if (paramControl.enter || paramControl.handb) {
            if (this.loadedt) this.strack.unload();
            if (this.multion == 0) {
                this.opselect = 3;
                if (this.gmode == 1) {
                    this.opselect = 0;
                    if (this.winner && paramCheckPoints.stage == this.unlocked[this.gmode - 1] + (this.gmode - 1) * 10 && paramCheckPoints.stage != 27) {
                        this.unlocked[this.gmode - 1] = this.unlocked[this.gmode - 1] + 1;
                        this.justwon1 = true;
                    } else {
                        this.justwon1 = false;
                    }
                }
                if (this.gmode == 2) {
                    this.opselect = 1;
                    if (this.winner && paramCheckPoints.stage == this.unlocked[this.gmode - 1] + (this.gmode - 1) * 10 && paramCheckPoints.stage != 27) {
                        this.unlocked[this.gmode - 1] = this.unlocked[this.gmode - 1] + 1;
                        this.justwon2 = true;
                    } else {
                        this.justwon2 = false;
                    }
                }
                if (paramCheckPoints.stage == 27 && this.gmode == 0)
                    paramCheckPoints.stage = (int) (Math.random() * 27.0D) + 1;
                this.fase = 102;
            } else if (this.cd.haltload == 1) {
                this.sc[0] = 36;
                this.fase = 1177;
            } else if (!this.mtop || (this.nfreeplays >= 5 && !this.logged)) {
                this.opselect = 2;
                this.fase = 102;
            } else {
                this.fase = -9;
            }
            if (this.multion == 0 && this.winner && paramCheckPoints.stage != 27 && paramCheckPoints.stage > 0)
                paramCheckPoints.stage++;
            if (!this.winner && this.multion != 0 && (this.forstart == 700 || this.discon == 240) && this.ndisco < 5)
                this.ndisco++;
            this.flipo = 0;
            paramControl.enter = false;
            paramControl.handb = false;
        }
    }

    public void sortcars(int paramInt) {
        if (paramInt != 0) {
            for (byte b1 = 1; b1 < 7; ) {
                this.sc[b1] = -1;
                b1++;
            }
            boolean[] arrayOfBoolean = new boolean[7];
            if (paramInt < 0) paramInt = 27;
            byte b2 = 7;
            if (this.gmode == 1) b2 = 5;
            boolean bool = false;
            if (paramInt <= 10) {
                byte b = 6;
                if (this.gmode == 1) b = 4;
                if ((paramInt == 1 || paramInt == 2) && this.sc[0] != 5) {
                    this.sc[b] = 5;
                    b2 = b;
                }
                if ((paramInt == 3 || paramInt == 4) && this.sc[0] != 6) {
                    this.sc[b] = 6;
                    b2 = b;
                }
                if ((paramInt == 5 || paramInt == 6) && this.sc[0] != 11) {
                    this.sc[b] = 11;
                    b2 = b;
                }
                if ((paramInt == 7 || paramInt == 8) && this.sc[0] != 14) {
                    this.sc[b] = 14;
                    b2 = b;
                }
                if ((paramInt == 9 || paramInt == 10) && this.sc[0] != 15) {
                    this.sc[b] = 15;
                    b2 = b;
                }
            } else {
                paramInt -= 10;
                bool = true;
                if (this.sc[0] != 7 + (paramInt + 1) / 2 && paramInt != 17) {
                    this.sc[6] = 7 + (paramInt + 1) / 2;
                    b2 = 6;
                }
            }
            int i = 16;
            byte b3 = 1, b4 = 2;
            byte b5;
            for (b5 = 1; b5 < b2; b5++) {
                arrayOfBoolean[b5] = false;
                while (!arrayOfBoolean[b5]) {
                    float f1 = 10.0F;
                    if (bool) f1 = 17.0F;
                    this.sc[b5] = (int) (Math.random() * (24.0F + 8.0F * paramInt / f1));
                    if (this.sc[b5] >= 16) this.sc[b5] = this.sc[b5] - 16;
                    arrayOfBoolean[b5] = true;
                    for (byte b = 0; b < 7; ) {
                        if (b5 != b && this.sc[b5] == this.sc[b]) arrayOfBoolean[b5] = false;
                        b++;
                    }
                    if (bool) f1 = 16.0F;
                    float f2 = (15 - this.sc[b5]) / 15.0F * paramInt / f1;
                    if (f2 > 0.8D) f2 = 0.8F;
                    if (paramInt == 17 && f2 > 0.5D) f2 = 0.5F;
                    if (f2 > Math.random()) arrayOfBoolean[b5] = false;
                    if (this.gmode == 1) {
                        if (this.sc[b5] >= 7 && this.sc[b5] <= 10) arrayOfBoolean[b5] = false;
                        if (this.sc[b5] == 12 || this.sc[b5] == 13) arrayOfBoolean[b5] = false;
                        if (this.sc[b5] > 5 && this.unlocked[0] <= 2) arrayOfBoolean[b5] = false;
                        if (this.sc[b5] > 6 && this.unlocked[0] <= 4) arrayOfBoolean[b5] = false;
                        if (this.sc[b5] > 11 && this.unlocked[0] <= 6) arrayOfBoolean[b5] = false;
                        if (this.sc[b5] > 14 && this.unlocked[0] <= 8) arrayOfBoolean[b5] = false;
                    }
                    if (this.gmode == 2) {
                        if ((this.sc[b5] - 7) * 2 > this.unlocked[1]) arrayOfBoolean[b5] = false;
                        if (paramInt == 16 && this.unlocked[1] == 16 && this.sc[b5] < 9) arrayOfBoolean[b5] = false;
                    }
                }
                if (this.sc[b5] < i) {
                    i = this.sc[b5];
                    if (b3 != b5) {
                        b4 = b3;
                        b3 = b5;
                    }
                }
            }
            if (!bool) if (paramInt == 10) {
                byte b;
                for (b5 = 0, b = 0; b < 7; ) {
                    if (this.sc[b] == 11) b5 = 1;
                    b++;
                }
                if (b5 == 0 && (Math.random() > Math.random() || this.gmode != 0)) this.sc[b3] = 11;
                for (b5 = 0, b = 0; b < 7; ) {
                    if (this.sc[b] == 14) b5 = 1;
                    b++;
                }
                if (b5 == 0 && (Math.random() > Math.random() || this.gmode != 0)) this.sc[b4] = 14;
            }
            if (paramInt == 12) {
                byte b;
                for (b5 = 0, b = 0; b < 7; ) {
                    if (this.sc[b] == 11) b5 = 1;
                    b++;
                }
                if (b5 == 0) this.sc[b3] = 11;
            }
            if (paramInt == 14) {
                byte b;
                for (b5 = 0, b = 0; b < 7; ) {
                    if (this.sc[b] == 12) b5 = 1;
                    b++;
                }
                if (b5 == 0 && (Math.random() > Math.random() || this.gmode != 0)) this.sc[b3] = 12;
                for (b5 = 0, b = 0; b < 7; ) {
                    if (this.sc[b] == 10) b5 = 1;
                    b++;
                }
                if (b5 == 0 && (Math.random() > Math.random() || this.gmode != 0)) this.sc[b4] = 10;
            }
            if (paramInt == 15) {
                byte b;
                for (b5 = 0, b = 0; b < 7; ) {
                    if (this.sc[b] == 11) b5 = 1;
                    b++;
                }
                if (b5 == 0 && (Math.random() > Math.random() || this.gmode != 0)) this.sc[b3] = 11;
                for (b5 = 0, b = 0; b < 7; ) {
                    if (this.sc[b] == 13) b5 = 1;
                    b++;
                }
                if (b5 == 0 && (Math.random() > Math.random() || this.gmode != 0)) this.sc[b4] = 13;
            }
            if (paramInt == 16) {
                byte b;
                for (b5 = 0, b = 0; b < 7; ) {
                    if (this.sc[b] == 13) b5 = 1;
                    b++;
                }
                if (b5 == 0 && (Math.random() > Math.random() || this.gmode != 0)) this.sc[b3] = 13;
                for (b5 = 0, b = 0; b < 7; ) {
                    if (this.sc[b] == 12) b5 = 1;
                    b++;
                }
                if (b5 == 0 && (Math.random() > Math.random() || this.gmode != 0)) this.sc[b4] = 12;
            }
            if (this.cd.lastload == 1) {
                b5 = 0;
                for (byte b = 0; b < this.cd.nlcars - 16; b++) {
                    if (b5 == 0) for (byte b6 = 1; b6 < b2; ) {
                        arrayOfBoolean[b6] = false;
                        b6++;
                    }
                    if (this.cd.include[b] && this.sc[0] != b + 16) {
                        int j;
                        for (j = (int) (1.0D + Math.random() * (b2 - 1)); arrayOfBoolean[j]; j = (int) (1.0D + Math.random() * (b2 - 1)))
                            ;
                        arrayOfBoolean[j] = true;
                        this.sc[j] = b + 16;
                        if (++b5 == b2 - 1) b5 = 0;
                    }
                }
            }
            if (this.cd.lastload == 2) {
                b5 = 0;
                for (byte b = 0; b < this.cd.nlocars - 16; b++) {
                    if (b5 == 0) for (byte b6 = 1; b6 < b2; ) {
                        arrayOfBoolean[b6] = false;
                        b6++;
                    }
                    if (this.cd.include[b] && this.sc[0] != b + 16) {
                        int j;
                        for (j = (int) (1.0D + Math.random() * (b2 - 1)); arrayOfBoolean[j]; j = (int) (1.0D + Math.random() * (b2 - 1)))
                            ;
                        arrayOfBoolean[j] = true;
                        this.sc[j] = b + 16;
                        if (++b5 == b2 - 1) b5 = 0;
                    }
                }
            }
        }
    }

    public void ctachm(int paramInt1, int paramInt2, int paramInt3, Control paramControl) {
        if (this.fase == 1) {
            if (paramInt3 == 1) {
                if (over(this.next[0], paramInt1, paramInt2, 625, 135)) this.pnext = 1;
                if (over(this.back[0], paramInt1, paramInt2, 115, 135)) this.pback = 1;
                if (over(this.contin[0], paramInt1, paramInt2, 355, 360)) this.pcontin = 1;
            }
            if (paramInt3 == 2) {
                if (this.pnext == 1) paramControl.right = true;
                if (this.pback == 1) paramControl.left = true;
                if (this.pcontin == 1) paramControl.enter = true;
            }
        }
        if (this.fase == 3) {
            if (paramInt3 == 1 && over(this.contin[0], paramInt1, paramInt2, 355, 350)) this.pcontin = 1;
            if (paramInt3 == 2 && this.pcontin == 1) {
                paramControl.enter = true;
                this.pcontin = 0;
            }
        }
        if (this.fase == 4) {
            if (paramInt3 == 1 && over(this.back[0], paramInt1, paramInt2, 370, 345)) this.pback = 1;
            if (paramInt3 == 2 && this.pback == 1) {
                paramControl.enter = true;
                this.pback = 0;
            }
        }
        if (this.fase == 6) {
            if (paramInt3 == 1 && (over(this.star[0], paramInt1, paramInt2, 359, 385) || over(this.star[0], paramInt1, paramInt2, 359, 295)))
                this.pstar = 2;
            if (paramInt3 == 2 && this.pstar == 2) {
                paramControl.enter = true;
                this.pstar = 1;
            }
        }
        if (this.fase == 7) {
            if (paramInt3 == 1) {
                if (over(this.next[0], paramInt1, paramInt2, 645, 275)) this.pnext = 1;
                if (over(this.back[0], paramInt1, paramInt2, 95, 275)) this.pback = 1;
                if (over(this.contin[0], paramInt1, paramInt2, 355, 385) && !this.app.openm) this.pcontin = 1;
            }
            if (paramInt3 == 2) {
                if (this.pnext == 1) paramControl.right = true;
                if (this.pback == 1) paramControl.left = true;
                if (this.pcontin == 1) {
                    paramControl.enter = true;
                    this.pcontin = 0;
                }
            }
        }
        if (this.fase == -5) {
            this.lxm = paramInt1;
            this.lym = paramInt2;
            if (paramInt3 == 1 && over(this.contin[0], paramInt1, paramInt2, 355, 380)) this.pcontin = 1;
            if (paramInt3 == 2 && this.pcontin == 1) {
                paramControl.enter = true;
                this.pcontin = 0;
            }
        }
        if (this.fase == -7) {
            if (paramInt3 == 1) {
                if (overon(329, 45, 137, 22, paramInt1, paramInt2)) {
                    this.opselect = 0;
                    this.shaded = true;
                }
                if (overon(320, 73, 155, 22, paramInt1, paramInt2)) {
                    this.opselect = 1;
                    this.shaded = true;
                }
                if (overon(303, 99, 190, 22, paramInt1, paramInt2)) {
                    this.opselect = 2;
                    this.shaded = true;
                }
                if (overon(341, 125, 109, 22, paramInt1, paramInt2)) {
                    this.opselect = 3;
                    this.shaded = true;
                }
            }
            if (paramInt3 == 2 && this.shaded) {
                paramControl.enter = true;
                this.shaded = false;
            }
            if (paramInt3 == 0) if (paramInt1 != this.lxm || paramInt2 != this.lym) {
                if (overon(329, 45, 137, 22, paramInt1, paramInt2)) this.opselect = 0;
                if (overon(320, 73, 155, 22, paramInt1, paramInt2)) this.opselect = 1;
                if (overon(303, 99, 190, 22, paramInt1, paramInt2)) this.opselect = 2;
                if (overon(341, 125, 109, 22, paramInt1, paramInt2)) this.opselect = 3;
                this.lxm = paramInt1;
                this.lym = paramInt2;
            }
        }
        if (this.fase == 10) {
            if (paramInt3 == 1) {
                if (overon(343, 261, 110, 22, paramInt1, paramInt2)) {
                    this.opselect = 0;
                    this.shaded = true;
                }
                if (overon(288, 291, 221, 22, paramInt1, paramInt2)) {
                    this.opselect = 1;
                    this.shaded = true;
                }
                if (overon(301, 321, 196, 22, paramInt1, paramInt2)) {
                    this.opselect = 2;
                    this.shaded = true;
                }
                if (overon(357, 351, 85, 22, paramInt1, paramInt2)) {
                    this.opselect = 3;
                    this.shaded = true;
                }
            }
            if (paramInt3 == 2 && this.shaded) {
                paramControl.enter = true;
                this.shaded = false;
            }
            if (paramInt3 == 0) if (paramInt1 != this.lxm || paramInt2 != this.lym) {
                if (overon(343, 261, 110, 22, paramInt1, paramInt2)) this.opselect = 0;
                if (overon(288, 291, 221, 22, paramInt1, paramInt2)) this.opselect = 1;
                if (overon(301, 321, 196, 22, paramInt1, paramInt2)) this.opselect = 2;
                if (overon(357, 351, 85, 22, paramInt1, paramInt2)) this.opselect = 3;
                this.lxm = paramInt1;
                this.lym = paramInt2;
            }
        }
        if (this.fase == 102) {
            if (paramInt3 == 1) {
                if (overon(358, 262 + this.dropf, 82, 22, paramInt1, paramInt2)) {
                    this.opselect = 0;
                    this.shaded = true;
                }
                if (overon(358, 290 + this.dropf, 82, 22, paramInt1, paramInt2)) {
                    this.opselect = 1;
                    this.shaded = true;
                }
                if (overon(333, 318 + this.dropf, 132, 22, paramInt1, paramInt2)) {
                    this.opselect = 2;
                    this.shaded = true;
                }
                if (this.dropf == 0 && overon(348, 346, 102, 22, paramInt1, paramInt2)) {
                    this.opselect = 3;
                    this.shaded = true;
                }
            }
            if (paramInt3 == 2 && this.shaded) {
                paramControl.enter = true;
                this.shaded = false;
            }
            if (paramInt3 == 0) if (paramInt1 != this.lxm || paramInt2 != this.lym) {
                if (overon(358, 262 + this.dropf, 82, 22, paramInt1, paramInt2)) this.opselect = 0;
                if (overon(358, 290 + this.dropf, 82, 22, paramInt1, paramInt2)) this.opselect = 1;
                if (overon(333, 318 + this.dropf, 132, 22, paramInt1, paramInt2)) this.opselect = 2;
                if (this.dropf == 0 && overon(348, 346, 102, 22, paramInt1, paramInt2)) this.opselect = 3;
                this.lxm = paramInt1;
                this.lym = paramInt2;
            }
        }
        if (this.fase == 11) {
            if (this.flipo >= 1 && this.flipo <= 15) {
                if (paramInt3 == 1 && over(this.next[0], paramInt1, paramInt2, 665, 395)) this.pnext = 1;
                if (paramInt3 == 2 && this.pnext == 1) {
                    paramControl.right = true;
                    this.pnext = 0;
                }
            }
            if (this.flipo >= 3 && this.flipo <= 16) {
                if (paramInt3 == 1 && over(this.back[0], paramInt1, paramInt2, 75, 395)) this.pback = 1;
                if (paramInt3 == 2 && this.pback == 1) {
                    paramControl.left = true;
                    this.pback = 0;
                }
            }
            if (this.flipo == 16) {
                if (paramInt3 == 1 && over(this.contin[0], paramInt1, paramInt2, 565, 395)) this.pcontin = 1;
                if (paramInt3 == 2 && this.pcontin == 1) {
                    paramControl.enter = true;
                    this.pcontin = 0;
                }
            }
        }
        if (this.fase == 8) {
            if (paramInt3 == 1 && over(this.next[0], paramInt1, paramInt2, 665, 395)) this.pnext = 1;
            if (paramInt3 == 2 && this.pnext == 1) {
                paramControl.enter = true;
                this.pnext = 0;
            }
        }
    }

    public void stat(Mad paramMad, ContO paramContO, CheckPoints paramCheckPoints, Control paramControl, boolean paramBoolean) {
        if (this.holdit) {
            char c = 'ú';
            if (this.fase == 7001) if (this.exitm != 4) {
                this.exitm = 0;
                c = 'ɘ';
            } else {
                c = 'Ұ';
            }
            if (this.exitm != 4 || !this.lan || this.im != 0) {
                this.holdcnt++;
                if ((paramControl.enter || this.holdcnt > c) && (paramControl.chatup == 0 || this.fase != 7001)) {
                    this.fase = -2;
                    paramControl.enter = false;
                }
            } else if (paramControl.enter) {
                paramControl.enter = false;
            }
        } else {
            if (this.holdcnt != 0) this.holdcnt = 0;
            if (paramControl.enter || paramControl.exit) {
                if (this.fase == 0) {
                    if (this.loadedt) this.strack.stop();
                    this.fase = -6;
                } else if (this.starcnt == 0 && paramControl.chatup == 0 && (this.multion < 2 || !this.lan)) {
                    if (this.exitm == 0) {
                        this.exitm = 1;
                    } else {
                        this.exitm = 0;
                    }
                }
                if (paramControl.chatup == 0 || this.fase != 7001) paramControl.enter = false;
                paramControl.exit = false;
            }
        }
        if (this.exitm == 2) {
            this.fase = -2;
            this.winner = false;
        }
        if (this.fase != -2) {
            this.holdit = false;
            if (paramCheckPoints.haltall) paramCheckPoints.haltall = false;
            boolean bool = false;
            String str1 = "", str2 = "";
            if (this.clangame != 0 && (!paramMad.dest || this.multion >= 2)) {
                byte b;
                for (bool = true, b = 0; b < this.nplayers; ) {
                    if (paramCheckPoints.dested[b] == 0) if (str1.equals("")) {
                        str1 = this.pclan[b];
                    } else if (!str1.toLowerCase().equals(this.pclan[b].toLowerCase())) {
                        bool = false;
                        break;
                    }
                    b++;
                }
            }
            if (this.clangame > 1) {
                boolean bool1 = false;
                String str = "";
                if (bool) {
                    for (byte b1 = 0; b1 < this.nplayers; ) {
                        if (!str1.toLowerCase().equals(this.pclan[b1].toLowerCase())) {
                            str2 = this.pclan[b1];
                            break;
                        }
                        b1++;
                    }
                    if (this.clangame == 2) {
                        bool1 = true;
                        str = "Clan " + str2 + " wasted, nobody won becuase this is a racing only game!";
                    }
                    if (this.clangame == 4 && !str1.toLowerCase().equals(this.gaclan.toLowerCase())) {
                        bool1 = true;
                        str = "Clan " + str2 + " wasted, nobody won becuase " + str1 + " should have raced in this racing vs wasting game!";
                    }
                    if (this.clangame == 5 && str1.toLowerCase().equals(this.gaclan.toLowerCase())) {
                        bool1 = true;
                        str = "Clan " + str2 + " wasted, nobody won becuase " + str1 + " should have raced in this racing vs wasting game!";
                    }
                }
                for (byte b = 0; b < this.nplayers; b++) {
                    if (paramCheckPoints.clear[b] == paramCheckPoints.nlaps * paramCheckPoints.nsp && paramCheckPoints.pos[b] == 0) {
                        if (this.clangame == 3) {
                            bool1 = true;
                            str = "" + this.plnames[b] + " of clan " + this.pclan[b] + " finished first, nobody won becuase this is a wasting only game!";
                        }
                        if (this.clangame == 4 && this.pclan[b].toLowerCase().equals(this.gaclan.toLowerCase())) {
                            bool1 = true;
                            str = "" + this.plnames[b] + " of clan " + this.pclan[b] + " finished first, nobody won becuase " + this.pclan[b] + " should have wasted in this racing vs wasting game!";
                        }
                        if (this.clangame == 5 && !this.pclan[b].toLowerCase().equals(this.gaclan.toLowerCase())) {
                            bool1 = true;
                            str = "" + this.plnames[b] + " of clan " + this.pclan[b] + " finished first, nobody won becuase " + this.pclan[b] + " should have wasted in this racing vs wasting game!";
                        }
                    }
                }
                if (bool1) {
                    drawhi(this.gamefinished, 70);
                    if (this.aflk) {
                        drawcs(120, str, 0, 0, 0, 0);
                        this.aflk = false;
                    } else {
                        drawcs(120, str, 0, 128, 255, 0);
                        this.aflk = true;
                    }
                    drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    paramCheckPoints.haltall = true;
                    this.holdit = true;
                    this.winner = false;
                }
            }
            if (this.multion < 2) {
                if (!this.holdit) if ((paramCheckPoints.wasted == this.nplayers - 1 && this.nplayers != 1) || bool) {
                    drawhi(this.youwastedem, 70);
                    if (!bool) {
                        if (this.aflk) {
                            drawcs(120, "You Won, all cars have been wasted!", 0, 0, 0, 0);
                            this.aflk = false;
                        } else {
                            drawcs(120, "You Won, all cars have been wasted!", 0, 128, 255, 0);
                            this.aflk = true;
                        }
                    } else if (this.aflk) {
                        drawcs(120, "Your clan " + str1 + " has wasted all the cars!", 0, 0, 0, 0);
                        this.aflk = false;
                    } else {
                        drawcs(120, "Your clan " + str1 + " has wasted all the cars!", 0, 128, 255, 0);
                        this.aflk = true;
                    }
                    drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    paramCheckPoints.haltall = true;
                    this.holdit = true;
                    this.winner = true;
                }
                if (!this.holdit) if (paramMad.dest && this.cntwis == 8) {
                    if (this.discon != 240) {
                        drawhi(this.yourwasted, 70);
                    } else {
                        drawhi(this.disco, 70);
                        stopchat();
                    }
                    boolean bool1 = false;
                    if (this.lan) {
                        byte b;
                        for (bool1 = true, b = 0; b < this.nplayers; ) {
                            if (b != this.im && this.dested[b] == 0 && this.plnames[b].indexOf("MadBot") == -1)
                                bool1 = false;
                            b++;
                        }
                    }
                    if (this.fase == 7001 && this.nplayers - paramCheckPoints.wasted + 1 >= 2 && this.discon != 240 && !bool1) {
                        this.exitm = 4;
                    } else {
                        if (this.exitm == 4) this.exitm = 0;
                        drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    }
                    this.holdit = true;
                    this.winner = false;
                }
                if (!this.holdit) for (byte b = 0; b < this.nplayers; b++) {
                    if (paramCheckPoints.clear[b] == paramCheckPoints.nlaps * paramCheckPoints.nsp && paramCheckPoints.pos[b] == 0) {
                        if (this.clangame == 0) {
                            if (b == this.im) {
                                drawhi(this.youwon, 70);
                                if (this.aflk) {
                                    drawcs(120, "You finished first, nice job!", 0, 0, 0, 0);
                                    this.aflk = false;
                                } else {
                                    drawcs(120, "You finished first, nice job!", 0, 128, 255, 0);
                                    this.aflk = true;
                                }
                                this.winner = true;
                            } else {
                                drawhi(this.youlost, 70);
                                if (this.fase != 7001) {
                                    if (this.aflk) {
                                        drawcs(120, "" + this.cd.names[this.sc[b]] + " finished first, race over!", 0, 0, 0, 0);
                                        this.aflk = false;
                                    } else {
                                        drawcs(120, "" + this.cd.names[this.sc[b]] + " finished first, race over!", 0, 128, 255, 0);
                                        this.aflk = true;
                                    }
                                } else if (this.aflk) {
                                    drawcs(120, "" + this.plnames[b] + " finished first, race over!", 0, 0, 0, 0);
                                    this.aflk = false;
                                } else {
                                    drawcs(120, "" + this.plnames[b] + " finished first, race over!", 0, 128, 255, 0);
                                    this.aflk = true;
                                }
                                this.winner = false;
                            }
                        } else if (this.pclan[b].toLowerCase().equals(this.pclan[this.im].toLowerCase())) {
                            drawhi(this.youwon, 70);
                            if (this.aflk) {
                                drawcs(120, "Your clan " + this.pclan[this.im] + " finished first, nice job!", 0, 0, 0, 0);
                                this.aflk = false;
                            } else {
                                drawcs(120, "Your clan " + this.pclan[this.im] + " finished first, nice job!", 0, 128, 255, 0);
                                this.aflk = true;
                            }
                            this.winner = true;
                        } else {
                            drawhi(this.youlost, 70);
                            if (this.aflk) {
                                drawcs(120, "" + this.plnames[b] + " of clan " + this.pclan[b] + " finished first, race over!", 0, 0, 0, 0);
                                this.aflk = false;
                            } else {
                                drawcs(120, "" + this.plnames[b] + " of clan " + this.pclan[b] + " finished first, race over!", 0, 128, 255, 0);
                                this.aflk = true;
                            }
                            this.winner = false;
                        }
                        drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                        paramCheckPoints.haltall = true;
                        this.holdit = true;
                    }
                }
            } else {
                if (!this.holdit) if (paramCheckPoints.wasted >= this.nplayers - 1 || bool) {
                    String str = "Someone";
                    if (!bool) {
                        for (byte b = 0; b < this.nplayers; ) {
                            if (paramCheckPoints.dested[b] == 0) str = this.plnames[b];
                            b++;
                        }
                    } else {
                        str = "Clan " + str1 + "";
                    }
                    drawhi(this.gamefinished, 70);
                    if (this.aflk) {
                        drawcs(120, "" + str + " has wasted all the cars!", 0, 0, 0, 0);
                        this.aflk = false;
                    } else {
                        drawcs(120, "" + str + " has wasted all the cars!", 0, 128, 255, 0);
                        this.aflk = true;
                    }
                    drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    paramCheckPoints.haltall = true;
                    this.holdit = true;
                    this.winner = false;
                }
                if (!this.holdit) for (byte b = 0; b < this.nplayers; b++) {
                    if (paramCheckPoints.clear[b] == paramCheckPoints.nlaps * paramCheckPoints.nsp && paramCheckPoints.pos[b] == 0) {
                        drawhi(this.gamefinished, 70);
                        if (this.clangame == 0) {
                            if (this.aflk) {
                                drawcs(120, "" + this.plnames[b] + " finished first, race over!", 0, 0, 0, 0);
                                this.aflk = false;
                            } else {
                                drawcs(120, "" + this.plnames[b] + " finished first, race over!", 0, 128, 255, 0);
                                this.aflk = true;
                            }
                        } else if (this.aflk) {
                            drawcs(120, "Clan " + this.pclan[b] + " finished first, race over!", 0, 0, 0, 0);
                            this.aflk = false;
                        } else {
                            drawcs(120, "Clan " + this.pclan[b] + " finished first, race over!", 0, 128, 255, 0);
                            this.aflk = true;
                        }
                        drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                        paramCheckPoints.haltall = true;
                        this.holdit = true;
                        this.winner = false;
                    }
                }
                if (!this.holdit) if (this.discon == 240) {
                    drawhi(this.gamefinished, 70);
                    if (this.aflk) {
                        drawcs(120, "Game got disconnected!", 0, 0, 0, 0);
                        this.aflk = false;
                    } else {
                        drawcs(120, "Game got disconnected!", 0, 128, 255, 0);
                        this.aflk = true;
                    }
                    drawcs(350, "Press  [ Enter ]  to continue", 0, 0, 0, 0);
                    paramCheckPoints.haltall = true;
                    this.holdit = true;
                    this.winner = false;
                }
                if (!this.holdit) {
                    this.rd.drawImage(this.wgame, 311, 20, (ImageObserver) null);
                    if (!this.clanchat) {
                        drawcs(397, "Click any player on the right to follow!", 0, 0, 0, 0);
                        if (!this.lan) {
                            drawcs(412, "Press [V] to change view.  Press [Enter] to exit.", 0, 0, 0, 0);
                        } else {
                            drawcs(412, "Press [V] to change view.", 0, 0, 0, 0);
                        }
                    }
                }
            }
            if (paramBoolean) {
                if (paramCheckPoints.stage != 10 && this.multion < 2 && this.nplayers != 1 && this.arrace != paramControl.arrace) {
                    this.arrace = paramControl.arrace;
                    if (this.multion == 1 && this.arrace) paramControl.radar = true;
                    if (this.arrace) {
                        this.wasay = true;
                        this.say = " Arrow now pointing at >  CARS";
                        if (this.multion == 1) this.say += "    Press [S] to toggle Radar!";
                        this.tcnt = -5;
                    }
                    if (!this.arrace) {
                        this.wasay = false;
                        this.say = " Arrow now pointing at >  TRACK";
                        if (this.multion == 1) this.say += "    Press [S] to toggle Radar!";
                        this.tcnt = -5;
                        this.cntan = 20;
                        this.alocked = -1;
                        this.alocked = -1;
                    }
                }
                if (!this.holdit && this.fase != -6 && this.starcnt == 0 && this.multion < 2 && paramCheckPoints.stage != 10) {
                    arrow(paramMad.point, paramMad.missedcp, paramCheckPoints, this.arrace);
                    if (!this.arrace) {
                        if (this.auscnt == 45 && paramMad.capcnt == 0 && this.exitm == 0) if (paramMad.missedcp > 0) {
                            if (paramMad.missedcp > 15 && paramMad.missedcp < 50) if (this.flk) {
                                drawcs(70, "Checkpoint Missed!", 255, 0, 0, 0);
                            } else {
                                drawcs(70, "Checkpoint Missed!", 255, 150, 0, 2);
                            }
                            paramMad.missedcp++;
                            if (paramMad.missedcp == 70) paramMad.missedcp = -2;
                        } else if (paramMad.mtouch && this.cntovn < 70) {
                            if (Math.abs(this.ana) > 100) {
                                this.cntan++;
                            } else if (this.cntan != 0) {
                                this.cntan--;
                            }
                            if (this.cntan > 40) {
                                this.cntovn++;
                                this.cntan = 40;
                                if (this.flk) {
                                    drawcs(70, "Wrong Way!", 255, 150, 0, 0);
                                    this.flk = false;
                                } else {
                                    drawcs(70, "Wrong Way!", 255, 0, 0, 2);
                                    this.flk = true;
                                }
                            }
                        }
                    } else if (this.alocked != this.lalocked) {
                        if (this.alocked != -1) {
                            this.wasay = true;
                            this.say = " Arrow Locked on >  " + this.plnames[this.alocked] + "";
                            this.tcnt = -5;
                        } else {
                            this.wasay = true;
                            this.say = "Arrow Unlocked!";
                            this.tcnt = 10;
                        }
                        this.lalocked = this.alocked;
                    }
                }
                if (this.m.darksky) {
                    Color color = new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]);
                    float[] arrayOfFloat = new float[3];
                    Color.RGBtoHSB(this.m.csky[0], this.m.csky[1], this.m.csky[2], arrayOfFloat);
                    arrayOfFloat[2] = 0.6F;
                    color = Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
                    this.rd.setColor(color);
                    this.rd.fillRect(602, 9, 54, 14);
                    this.rd.drawLine(601, 10, 601, 21);
                    this.rd.drawLine(600, 12, 600, 19);
                    this.rd.fillRect(607, 29, 49, 14);
                    this.rd.drawLine(606, 30, 606, 41);
                    this.rd.drawLine(605, 32, 605, 39);
                    this.rd.fillRect(18, 6, 155, 14);
                    this.rd.drawLine(17, 7, 17, 18);
                    this.rd.drawLine(16, 9, 16, 16);
                    this.rd.drawLine(173, 7, 173, 18);
                    this.rd.drawLine(174, 9, 174, 16);
                    this.rd.fillRect(40, 26, 107, 21);
                    this.rd.drawLine(39, 27, 39, 45);
                    this.rd.drawLine(38, 29, 38, 43);
                    this.rd.drawLine(147, 27, 147, 45);
                    this.rd.drawLine(148, 29, 148, 43);
                }
                this.rd.drawImage(this.dmg, 600, 7, (ImageObserver) null);
                this.rd.drawImage(this.pwr, 600, 27, (ImageObserver) null);
                this.rd.drawImage(this.lap, 19, 7, (ImageObserver) null);
                this.rd.setColor(new Color(0, 0, 100));
                this.rd.drawString("" + (paramMad.nlaps + 1) + " / " + paramCheckPoints.nlaps + "", 51, 18);
                this.rd.drawImage(this.was, 92, 7, (ImageObserver) null);
                this.rd.setColor(new Color(0, 0, 100));
                this.rd.drawString("" + paramCheckPoints.wasted + " / " + (this.nplayers - 1) + "", 150, 18);
                this.rd.drawImage(this.pos, 42, 27, (ImageObserver) null);
                this.rd.drawImage(this.rank[paramCheckPoints.pos[paramMad.im]], 110, 28, (ImageObserver) null);
                drawstat(this.cd.maxmag[paramMad.cn], paramMad.hitmag, paramMad.newcar, paramMad.power);
                if (paramControl.radar && paramCheckPoints.stage != 10)
                    radarstat(paramMad, paramContO, paramCheckPoints);
            }
            if (!this.holdit) {
                if (this.starcnt != 0 && this.starcnt <= 35) {
                    if (this.starcnt == 35 && !this.mutes) this.three.play();
                    if (this.starcnt == 24) {
                        this.gocnt = 2;
                        if (!this.mutes) this.two.play();
                    }
                    if (this.starcnt == 13) {
                        this.gocnt = 1;
                        if (!this.mutes) this.one.play();
                    }
                    if (this.starcnt == 2) {
                        this.gocnt = 0;
                        if (!this.mutes) this.go.play();
                    }
                    this.duds = 0;
                    if (this.starcnt <= 37 && this.starcnt > 32) this.duds = 1;
                    if (this.starcnt <= 26 && this.starcnt > 21) this.duds = 1;
                    if (this.starcnt <= 15 && this.starcnt > 10) this.duds = 1;
                    if (this.starcnt <= 4) this.duds = 2;
                    if (this.dudo != -1) {
                        this.rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
                        this.rd.drawImage(this.dude[this.duds], this.dudo, 0, (ImageObserver) null);
                        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    }
                    if (this.gocnt != 0) {
                        this.rd.drawImage(this.cntdn[this.gocnt], 385, 50, (ImageObserver) null);
                    } else {
                        this.rd.drawImage(this.cntdn[this.gocnt], 363, 50, (ImageObserver) null);
                    }
                }
                if (this.looped != 0 && paramMad.loop == 2) this.looped = 0;
                if (paramMad.power < 45.0F) {
                    if (this.tcnt == 30 && this.auscnt == 45 && paramMad.mtouch && paramMad.capcnt == 0 && this.exitm == 0) {
                        if (this.looped != 2) {
                            if (this.pwcnt < 70 || (this.pwcnt < 100 && this.looped != 0)) if (this.pwflk) {
                                drawcs(110, "Power low, perform stunt!", 0, 0, 200, 0);
                                this.pwflk = false;
                            } else {
                                drawcs(110, "Power low, perform stunt!", 255, 100, 0, 0);
                                this.pwflk = true;
                            }
                        } else if (this.pwcnt < 100) {
                            String str = "";
                            if (this.multion == 0) str = "  (Press Enter)";
                            if (this.pwflk) {
                                drawcs(110, "Please read the Game Instructions!" + str + "", 0, 0, 200, 0);
                                this.pwflk = false;
                            } else {
                                drawcs(110, "Please read the Game Instructions!" + str + "", 255, 100, 0, 0);
                                this.pwflk = true;
                            }
                        }
                        this.pwcnt++;
                        if (this.pwcnt == 300) {
                            this.pwcnt = 0;
                            if (this.looped != 0) {
                                this.looped++;
                                if (this.looped == 4) this.looped = 2;
                            }
                        }
                    }
                } else if (this.pwcnt != 0) {
                    this.pwcnt = 0;
                }
                if (paramMad.capcnt == 0) {
                    if (this.tcnt < 30) {
                        if (this.exitm == 0) if (this.tflk) {
                            if (!this.wasay) {
                                drawcs(105, this.say, 0, 0, 0, 0);
                            } else {
                                drawcs(105, this.say, 0, 0, 0, 0);
                            }
                            this.tflk = false;
                        } else {
                            if (!this.wasay) {
                                drawcs(105, this.say, 0, 128, 255, 0);
                            } else {
                                drawcs(105, this.say, 255, 128, 0, 0);
                            }
                            this.tflk = true;
                        }
                        this.tcnt++;
                    } else if (this.wasay) {
                        this.wasay = false;
                    }
                    if (this.auscnt < 45) {
                        if (this.exitm == 0) if (this.aflk) {
                            drawcs(85, this.asay, 98, 176, 255, 0);
                            this.aflk = false;
                        } else {
                            drawcs(85, this.asay, 0, 128, 255, 0);
                            this.aflk = true;
                        }
                        this.auscnt++;
                    }
                } else if (this.exitm == 0) {
                    if (this.tflk) {
                        drawcs(110, "Bad Landing!", 0, 0, 200, 0);
                        this.tflk = false;
                    } else {
                        drawcs(110, "Bad Landing!", 255, 100, 0, 0);
                        this.tflk = true;
                    }
                }
                if (paramMad.trcnt == 10) {
                    char c;
                    for (this.loop = "", this.spin = "", this.asay = "", c = Character.MIN_VALUE; paramMad.travzy > 225; ) {
                        paramMad.travzy -= 360;
                        c++;
                    }
                    while (paramMad.travzy < -225) {
                        paramMad.travzy += 360;
                        c--;
                    }
                    if (c == '\001') this.loop = "Forward loop";
                    if (c == '\002') this.loop = "double Forward";
                    if (c == '\003') this.loop = "triple Forward";
                    if (c >= '\004') this.loop = "massive Forward looping";
                    if (c == -1) this.loop = "Backloop";
                    if (c == -2) this.loop = "double Back";
                    if (c == -3) this.loop = "triple Back";
                    if (c <= -4) this.loop = "massive Back looping";
                    if (c == Character.MIN_VALUE) if (paramMad.ftab && paramMad.btab) {
                        this.loop = "Tabletop and reversed Tabletop";
                    } else if (paramMad.ftab || paramMad.btab) {
                        this.loop = "Tabletop";
                    }
                    if (c > Character.MIN_VALUE && paramMad.btab) this.loop = "Hanged " + this.loop;
                    if (c < Character.MIN_VALUE && paramMad.ftab) this.loop = "Hanged " + this.loop;
                    if (this.loop != "") this.asay += " " + this.loop;
                    for (c = Character.MIN_VALUE, paramMad.travxy = Math.abs(paramMad.travxy); paramMad.travxy > 270; ) {
                        paramMad.travxy -= 360;
                        c++;
                    }
                    if (c == Character.MIN_VALUE && paramMad.rtab) if (this.loop == "") {
                        this.spin = "Tabletop";
                    } else {
                        this.spin = "Flipside";
                    }
                    if (c == '\001') this.spin = "Rollspin";
                    if (c == '\002') this.spin = "double Rollspin";
                    if (c == '\003') this.spin = "triple Rollspin";
                    if (c >= '\004') this.spin = "massive Roll spinning";
                    boolean bool1;
                    for (c = Character.MIN_VALUE, bool1 = false, paramMad.travxz = Math.abs(paramMad.travxz); paramMad.travxz > 90; ) {
                        paramMad.travxz -= 180;
                        c += 180;
                        if (c > '΄') {
                            c = '΄';
                            bool1 = true;
                        }
                    }
                    if (c != '\000') {
                        if (this.loop == "" && this.spin == "") {
                            this.asay += " " + c;
                            if (bool1) this.asay += " and beyond";
                        } else {
                            if (this.spin != "") if (this.loop == "") {
                                this.asay += " " + this.spin;
                            } else {
                                this.asay += " with " + this.spin;
                            }
                            this.asay += " by " + c;
                            if (bool1) this.asay += " and beyond";
                        }
                    } else if (this.spin != "") {
                        if (this.loop == "") {
                            this.asay += " " + this.spin;
                        } else {
                            this.asay += " by " + this.spin;
                        }
                    }
                    if (this.asay != "") this.auscnt -= 15;
                    if (this.loop != "") this.auscnt -= 25;
                    if (this.spin != "") this.auscnt -= 25;
                    if (c != '\000') this.auscnt -= 25;
                    if (this.auscnt < 45) {
                        if (!this.mutes) this.powerup.play();
                        if (this.auscnt < -20) this.auscnt = -20;
                        byte b1 = 0;
                        if (paramMad.powerup > 20.0F) b1 = 1;
                        if (paramMad.powerup > 40.0F) b1 = 2;
                        if (paramMad.powerup > 150.0F) b1 = 3;
                        if (paramMad.surfer) this.asay = " " + this.adj[4][(int) (this.m.random() * 3.0F)] + this.asay;
                        if (b1 != 3) {
                            this.asay = this.adj[b1][(int) (this.m.random() * 3.0F)] + this.asay + this.exlm[b1];
                        } else {
                            this.asay = this.adj[b1][(int) (this.m.random() * 3.0F)];
                        }
                        if (!this.wasay) {
                            this.tcnt = this.auscnt;
                            if (paramMad.power != 98.0F) {
                                this.say = "Power Up " + (int) (100.0F * paramMad.powerup / 98.0F) + "%";
                            } else {
                                this.say = "Power To The MAX";
                            }
                            if (this.skidup) {
                                this.skidup = false;
                            } else {
                                this.skidup = true;
                            }
                        }
                    }
                }
                if (paramMad.newcar) {
                    if (!this.wasay) {
                        this.say = "Car Fixed";
                        this.tcnt = 0;
                    }
                    if (this.crashup) {
                        this.crashup = false;
                    } else {
                        this.crashup = true;
                    }
                }
                for (byte b = 0; b < this.nplayers; b++) {
                    if (this.dested[b] != paramCheckPoints.dested[b] && b != this.im) {
                        this.dested[b] = paramCheckPoints.dested[b];
                        if (this.fase != 7001) {
                            if (this.dested[b] == 1) {
                                this.wasay = true;
                                this.say = "" + this.cd.names[this.sc[b]] + " has been wasted!";
                                this.tcnt = -15;
                            }
                            if (this.dested[b] == 2) {
                                this.wasay = true;
                                this.say = "You wasted " + this.cd.names[this.sc[b]] + "!";
                                this.tcnt = -15;
                            }
                        } else {
                            if (this.dested[b] == 1) {
                                this.wasay = true;
                                this.say = "" + this.plnames[b] + " has been wasted!";
                                this.tcnt = -15;
                            }
                            if (this.dested[b] == 2) {
                                this.wasay = true;
                                if (this.multion < 2) {
                                    this.say = "You wasted " + this.plnames[b] + "!";
                                } else {
                                    this.say = "" + this.plnames[this.im] + " wasted " + this.plnames[b] + "!";
                                }
                                this.tcnt = -15;
                            }
                            if (this.dested[b] == 3) {
                                this.wasay = true;
                                this.say = "" + this.plnames[b] + " has been wasted! (Disconnected)";
                                this.tcnt = -15;
                            }
                        }
                    }
                }
                if (this.multion >= 2 && this.alocked != this.lalocked) {
                    if (this.alocked != -1) {
                        this.wasay = false;
                        this.say = "Now following " + this.plnames[this.alocked] + "!";
                        this.tcnt = -15;
                    }
                    this.lalocked = this.alocked;
                    this.clear = paramMad.clear;
                }
                if (this.clear != paramMad.clear && paramMad.clear != 0) {
                    if (!this.wasay) {
                        this.say = "Checkpoint!";
                        this.tcnt = 15;
                    }
                    this.clear = paramMad.clear;
                    if (!this.mutes) this.checkpoint.play();
                    this.cntovn = 0;
                    if (this.cntan != 0) this.cntan = 0;
                }
            }
        }
        if (this.m.lightn != -1) {
            int i = this.strack.sClip.stream.available();
            this.m.lton = false;
            if (i <= 6380001 && i > 5368001) this.m.lton = true;
            if (i <= 2992001 && i > 1320001) this.m.lton = true;
        }
    }

    public void drawstat(int paramInt1, int paramInt2, boolean paramBoolean, float paramFloat) {
        int[] arrayOfInt1 = new int[4], arrayOfInt2 = new int[4];
        if (paramInt2 > paramInt1) paramInt2 = paramInt1;
        int i = (int) (98.0F * paramInt2 / paramInt1);
        arrayOfInt1[0] = 662;
        arrayOfInt2[0] = 11;
        arrayOfInt1[1] = 662;
        arrayOfInt2[1] = 20;
        arrayOfInt1[2] = 662 + i;
        arrayOfInt2[2] = 20;
        arrayOfInt1[3] = 662 + i;
        arrayOfInt2[3] = 11;
        int j = 244, k = 244, m = 11;
        if (i > 33) k = (int) (244.0F - 233.0F * (i - 33) / 65.0F);
        if (i > 70) {
            if (this.dmcnt < 10) if (this.dmflk) {
                k = 170;
                this.dmflk = false;
            } else {
                this.dmflk = true;
            }
            this.dmcnt++;
            if (this.dmcnt > 167.0D - i * 1.5D) this.dmcnt = 0;
        }
        j = (int) (j + j * this.m.snap[0] / 100.0F);
        if (j > 255) j = 255;
        if (j < 0) j = 0;
        k = (int) (k + k * this.m.snap[1] / 100.0F);
        if (k > 255) k = 255;
        if (k < 0) k = 0;
        m = (int) (m + m * this.m.snap[2] / 100.0F);
        if (m > 255) m = 255;
        if (m < 0) m = 0;
        this.rd.setColor(new Color(j, k, m));
        this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
        arrayOfInt1[0] = 662;
        arrayOfInt2[0] = 31;
        arrayOfInt1[1] = 662;
        arrayOfInt2[1] = 40;
        arrayOfInt1[2] = (int) (662.0F + paramFloat);
        arrayOfInt2[2] = 40;
        arrayOfInt1[3] = (int) (662.0F + paramFloat);
        arrayOfInt2[3] = 31;
        j = 128;
        if (paramFloat == 98.0F) j = 64;
        k = (int) (190.0D + paramFloat * 0.37D);
        m = 244;
        if (this.auscnt < 45 && this.aflk) {
            j = 128;
            k = 244;
            m = 244;
        }
        j = (int) (j + j * this.m.snap[0] / 100.0F);
        if (j > 255) j = 255;
        if (j < 0) j = 0;
        k = (int) (k + k * this.m.snap[1] / 100.0F);
        if (k > 255) k = 255;
        if (k < 0) k = 0;
        m = (int) (m + m * this.m.snap[2] / 100.0F);
        if (m > 255) m = 255;
        if (m < 0) m = 0;
        this.rd.setColor(new Color(j, k, m));
        this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
    }

    public void carsbginflex() {
        if (!this.badmac) {
            this.flatr = 0;
            this.flyr = (int) (this.m.random() * 160.0F - 80.0F);
            this.flyrdest = (int) (this.flyr + this.m.random() * 160.0F - 80.0F);
            this.flang = 1;


            this.flexpix = new int[268000];
            PixelGrabber pixelGrabber = new PixelGrabber(this.carsbg, 0, 0, 670, 400, this.flexpix, 0, 670);
            try {
                pixelGrabber.grabPixels();
            } catch (InterruptedException interruptedException) {
            }
        }
    }

    public void drawhi(Image paramImage, int paramInt) {
        if (this.m.darksky) {
            Color color = new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]);
            float[] arrayOfFloat = new float[3];
            Color.RGBtoHSB(this.m.csky[0], this.m.csky[1], this.m.csky[2], arrayOfFloat);
            arrayOfFloat[2] = 0.6F;
            color = Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
            this.rd.setColor(color);
            this.rd.fillRoundRect(390 - paramImage.getWidth(this.ob) / 2, paramInt - 2, paramImage.getWidth(this.ob) + 20, paramImage.getHeight(this.ob) + 2, 7, 20);
            this.rd.setColor(new Color((int) (color.getRed() / 1.1D), (int) (color.getGreen() / 1.1D), (int) (color.getBlue() / 1.1D)));
            this.rd.drawRoundRect(390 - paramImage.getWidth(this.ob) / 2, paramInt - 2, paramImage.getWidth(this.ob) + 20, paramImage.getHeight(this.ob) + 2, 7, 20);
        }
        this.rd.drawImage(paramImage, 400 - paramImage.getWidth(this.ob) / 2, paramInt, (ImageObserver) null);
    }

    public void drawcs(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        if (paramInt5 != 3 && paramInt5 != 4 && paramInt5 != 5) {
            paramInt2 = (int) (paramInt2 + paramInt2 * this.m.snap[0] / 100.0F);
            if (paramInt2 > 255) paramInt2 = 255;
            if (paramInt2 < 0) paramInt2 = 0;
            paramInt3 = (int) (paramInt3 + paramInt3 * this.m.snap[1] / 100.0F);
            if (paramInt3 > 255) paramInt3 = 255;
            if (paramInt3 < 0) paramInt3 = 0;
            paramInt4 = (int) (paramInt4 + paramInt4 * this.m.snap[2] / 100.0F);
            if (paramInt4 > 255) paramInt4 = 255;
            if (paramInt4 < 0) paramInt4 = 0;
        }
        if (paramInt5 == 4) {
            paramInt2 = (int) (paramInt2 - paramInt2 * this.m.snap[0] / 100.0F);
            if (paramInt2 > 255) paramInt2 = 255;
            if (paramInt2 < 0) paramInt2 = 0;
            paramInt3 = (int) (paramInt3 - paramInt3 * this.m.snap[1] / 100.0F);
            if (paramInt3 > 255) paramInt3 = 255;
            if (paramInt3 < 0) paramInt3 = 0;
            paramInt4 = (int) (paramInt4 - paramInt4 * this.m.snap[2] / 100.0F);
            if (paramInt4 > 255) paramInt4 = 255;
            if (paramInt4 < 0) paramInt4 = 0;
        }
        if (paramInt5 == 1) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(paramString, 400 - this.ftm.stringWidth(paramString) / 2 + 1, paramInt1 + 1);
        }
        if (paramInt5 == 2) {
            paramInt2 = (paramInt2 * 2 + this.m.csky[0] * 1) / 3;
            if (paramInt2 > 255) paramInt2 = 255;
            if (paramInt2 < 0) paramInt2 = 0;
            paramInt3 = (paramInt3 * 2 + this.m.csky[1] * 1) / 3;
            if (paramInt3 > 255) paramInt3 = 255;
            if (paramInt3 < 0) paramInt3 = 0;
            paramInt4 = (paramInt4 * 2 + this.m.csky[2] * 1) / 3;
            if (paramInt4 > 255) paramInt4 = 255;
            if (paramInt4 < 0) paramInt4 = 0;
        }
        if (paramInt5 == 5) {
            this.rd.setColor(new Color(this.m.csky[0] / 2, this.m.csky[1] / 2, this.m.csky[2] / 2));
            this.rd.drawString(paramString, 400 - this.ftm.stringWidth(paramString) / 2 + 1, paramInt1 + 1);
        }
        this.rd.setColor(new Color(paramInt2, paramInt3, paramInt4));
        this.rd.drawString(paramString, 400 - this.ftm.stringWidth(paramString) / 2, paramInt1);
    }

    public void arrow(int paramInt1, int paramInt2, CheckPoints paramCheckPoints, boolean paramBoolean) {
        int[] arrayOfInt1 = new int[7], arrayOfInt2 = new int[7], arrayOfInt3 = new int[7];
        char c1 = 'Ɛ';
        byte b = -90;
        char c2 = 'ʼ';
        int i;
        for (i = 0; i < 7; ) {
            arrayOfInt2[i] = b;
            i++;
        }
        arrayOfInt1[0] = c1;
        arrayOfInt3[0] = c2 + 110;
        arrayOfInt1[1] = c1 - 35;
        arrayOfInt3[1] = c2 + 50;
        arrayOfInt1[2] = c1 - 15;
        arrayOfInt3[2] = c2 + 50;
        arrayOfInt1[3] = c1 - 15;
        arrayOfInt3[3] = c2 - 50;
        arrayOfInt1[4] = c1 + 15;
        arrayOfInt3[4] = c2 - 50;
        arrayOfInt1[5] = c1 + 15;
        arrayOfInt3[5] = c2 + 50;
        arrayOfInt1[6] = c1 + 35;
        arrayOfInt3[6] = c2 + 50;
        i = 0;
        if (!paramBoolean) {
            char c = Character.MIN_VALUE;
            if (paramCheckPoints.x[paramInt1] - paramCheckPoints.opx[this.im] >= 0) c = '´';
            i = (int) ((90 + c) + Math.atan((paramCheckPoints.z[paramInt1] - paramCheckPoints.opz[this.im]) / (paramCheckPoints.x[paramInt1] - paramCheckPoints.opx[this.im])) / 0.017453292519943295D);
        } else {
            int j = 0;
            if (this.multion == 0 || this.alocked == -1) {
                int k = -1;
                boolean bool = false;
                for (byte b1 = 0; b1 < this.nplayers; ) {
                    if (b1 != this.im && (py(paramCheckPoints.opx[this.im] / 100, paramCheckPoints.opx[b1] / 100, paramCheckPoints.opz[this.im] / 100, paramCheckPoints.opz[b1] / 100) < k || k == -1) && (!bool || paramCheckPoints.onscreen[b1] != 0) && paramCheckPoints.dested[b1] == 0) {
                        j = b1;
                        k = py(paramCheckPoints.opx[this.im] / 100, paramCheckPoints.opx[b1] / 100, paramCheckPoints.opz[this.im] / 100, paramCheckPoints.opz[b1] / 100);
                        if (paramCheckPoints.onscreen[b1] != 0) bool = true;
                    }
                    b1++;
                }
            } else {
                j = this.alocked;
            }
            char c = Character.MIN_VALUE;
            if (paramCheckPoints.opx[j] - paramCheckPoints.opx[this.im] >= 0) c = '´';
            i = (int) ((90 + c) + Math.atan((paramCheckPoints.opz[j] - paramCheckPoints.opz[this.im]) / (paramCheckPoints.opx[j] - paramCheckPoints.opx[this.im])) / 0.017453292519943295D);
            if (this.multion == 0) {
                drawcs(13, "[                                ]", 76, 67, 240, 0);
                drawcs(13, this.cd.names[this.sc[j]], 0, 0, 0, 0);
            } else {
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                drawcs(17, "[                                ]", 76, 67, 240, 0);
                drawcs(12, this.plnames[j], 0, 0, 0, 0);
                this.rd.setFont(new Font("Arial", 0, 10));
                this.ftm = this.rd.getFontMetrics();
                drawcs(24, this.cd.names[this.sc[j]], 0, 0, 0, 0);
                this.rd.setFont(new Font("Arial", 1, 11));
                this.ftm = this.rd.getFontMetrics();
            }
        }
        for (i += this.m.xz; i < 0; i += 360) ;
        for (; i > 180; i -= 360) ;
        if (!paramBoolean) {
            if (i > 130) i = 130;
            if (i < -130) i = -130;
        } else {
            if (i > 100) i = 100;
            if (i < -100) i = -100;
        }
        if (Math.abs(this.ana - i) < 180) {
            if (Math.abs(this.ana - i) < 10) {
                this.ana = i;
            } else if (this.ana < i) {
                this.ana += 10;
            } else {
                this.ana -= 10;
            }
        } else {
            if (i < 0) {
                this.ana += 15;
                if (this.ana > 180) this.ana -= 360;
            }
            if (i > 0) {
                this.ana -= 15;
                if (this.ana < -180) this.ana += 360;
            }
        }
        rot(arrayOfInt1, arrayOfInt3, c1, c2, this.ana, 7);
        i = Math.abs(this.ana);
        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (!paramBoolean) {
            if (i > 7 || paramInt2 > 0 || paramInt2 == -2 || this.cntan != 0) {
                int j;
                for (j = 0; j < 7; ) {
                    arrayOfInt1[j] = xs(arrayOfInt1[j], arrayOfInt3[j]);
                    arrayOfInt2[j] = ys(arrayOfInt2[j], arrayOfInt3[j]);
                    j++;
                }
                j = (int) (190.0F + 190.0F * this.m.snap[0] / 100.0F);
                if (j > 255) j = 255;
                if (j < 0) j = 0;
                int k = (int) (255.0F + 255.0F * this.m.snap[1] / 100.0F);
                if (k > 255) k = 255;
                if (k < 0) k = 0;
                int m = 0;
                if (paramInt2 <= 0) {
                    if (i <= 45 && paramInt2 != -2 && this.cntan == 0) {
                        j = (j * i + this.m.csky[0] * (45 - i)) / 45;
                        k = (k * i + this.m.csky[1] * (45 - i)) / 45;
                        m = (m * i + this.m.csky[2] * (45 - i)) / 45;
                    }
                    if (i >= 90) {
                        int n = (int) (255.0F + 255.0F * this.m.snap[0] / 100.0F);
                        if (n > 255) n = 255;
                        if (n < 0) n = 0;
                        j = (j * (140 - i) + n * (i - 90)) / 50;
                        if (j > 255) j = 255;
                    }
                } else if (this.flk) {
                    j = (int) (255.0F + 255.0F * this.m.snap[0] / 100.0F);
                    if (j > 255) j = 255;
                    if (j < 0) j = 0;
                    this.flk = false;
                } else {
                    j = (int) (255.0F + 255.0F * this.m.snap[0] / 100.0F);
                    if (j > 255) j = 255;
                    if (j < 0) j = 0;
                    k = (int) (220.0F + 220.0F * this.m.snap[1] / 100.0F);
                    if (k > 255) k = 255;
                    if (k < 0) k = 0;
                    this.flk = true;
                }
                this.rd.setColor(new Color(j, k, m));
                this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 7);
                j = (int) (115.0F + 115.0F * this.m.snap[0] / 100.0F);
                if (j > 255) j = 255;
                if (j < 0) j = 0;
                k = (int) (170.0F + 170.0F * this.m.snap[1] / 100.0F);
                if (k > 255) k = 255;
                if (k < 0) k = 0;
                m = 0;
                if (paramInt2 <= 0) {
                    if (i <= 45 && paramInt2 != -2 && this.cntan == 0) {
                        j = (j * i + this.m.csky[0] * (45 - i)) / 45;
                        k = (k * i + this.m.csky[1] * (45 - i)) / 45;
                        m = (m * i + this.m.csky[2] * (45 - i)) / 45;
                    }
                } else if (this.flk) {
                    j = (int) (255.0F + 255.0F * this.m.snap[0] / 100.0F);
                    if (j > 255) j = 255;
                    if (j < 0) j = 0;
                    k = 0;
                }
                this.rd.setColor(new Color(j, k, m));
                this.rd.drawPolygon(arrayOfInt1, arrayOfInt2, 7);
            }
        } else {
            byte b1 = 0;
            if (this.multion != 0) b1 = 8;
            int j;
            for (j = 0; j < 7; ) {
                arrayOfInt1[j] = xs(arrayOfInt1[j], arrayOfInt3[j]);
                arrayOfInt2[j] = ys(arrayOfInt2[j], arrayOfInt3[j]) + b1;
                j++;
            }
            j = (int) (159.0F + 159.0F * this.m.snap[0] / 100.0F);
            if (j > 255) j = 255;
            if (j < 0) j = 0;
            int k = (int) (207.0F + 207.0F * this.m.snap[1] / 100.0F);
            if (k > 255) k = 255;
            if (k < 0) k = 0;
            int m = (int) (255.0F + 255.0F * this.m.snap[2] / 100.0F);
            if (m > 255) m = 255;
            if (m < 0) m = 0;
            this.rd.setColor(new Color(j, k, m));
            this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 7);
            j = (int) (120.0F + 120.0F * this.m.snap[0] / 100.0F);
            if (j > 255) j = 255;
            if (j < 0) j = 0;
            k = (int) (114.0F + 114.0F * this.m.snap[1] / 100.0F);
            if (k > 255) k = 255;
            if (k < 0) k = 0;
            m = (int) (255.0F + 255.0F * this.m.snap[2] / 100.0F);
            if (m > 255) m = 255;
            if (m < 0) m = 0;
            this.rd.setColor(new Color(j, k, m));
            this.rd.drawPolygon(arrayOfInt1, arrayOfInt2, 7);
        }
        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
    }

    public void radarstat(Mad paramMad, ContO paramContO, CheckPoints paramCheckPoints) {
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
        this.rd.setColor(new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]));
        this.rd.fillRoundRect(10, 55, 172, 172, 30, 30);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.rd.setColor(new Color(this.m.csky[0] / 2, this.m.csky[1] / 2, this.m.csky[2] / 2));
        int i;
        for (i = 0; i < paramCheckPoints.n; i++) {
            int i2 = i + 1;
            if (i == paramCheckPoints.n - 1) i2 = 0;
            boolean bool = false;
            if (paramCheckPoints.typ[i2] == -3) {
                i2 = 0;
                bool = true;
            }
            int[] arrayOfInt1 = {(int) (96.0F - (paramCheckPoints.opx[this.im] - paramCheckPoints.x[i]) / paramCheckPoints.prox), (int) (96.0F - (paramCheckPoints.opx[this.im] - paramCheckPoints.x[i2]) / paramCheckPoints.prox)};
            int[] arrayOfInt2 = {(int) (141.0F - (paramCheckPoints.z[i] - paramCheckPoints.opz[this.im]) / paramCheckPoints.prox), (int) (141.0F - (paramCheckPoints.z[i2] - paramCheckPoints.opz[this.im]) / paramCheckPoints.prox)};
            rot(arrayOfInt1, arrayOfInt2, 96, 141, paramMad.cxz, 2);
            this.rd.drawLine(arrayOfInt1[0], arrayOfInt2[0], arrayOfInt1[1], arrayOfInt2[1]);
            if (bool) break;
        }
        i = 0;
        int j = 0, k = 0;
        if (this.arrace || this.multion > 1) {
            int[] arrayOfInt1 = new int[this.nplayers];
            int[] arrayOfInt2 = new int[this.nplayers];
            byte b;
            for (b = 0; b < this.nplayers; ) {
                arrayOfInt1[b] = (int) (96.0F - (paramCheckPoints.opx[this.im] - paramCheckPoints.opx[b]) / paramCheckPoints.prox);
                arrayOfInt2[b] = (int) (141.0F - (paramCheckPoints.opz[b] - paramCheckPoints.opz[this.im]) / paramCheckPoints.prox);
                b++;
            }
            rot(arrayOfInt1, arrayOfInt2, 96, 141, paramMad.cxz, this.nplayers);
            i = 0;
            j = (int) (80.0F + 80.0F * this.m.snap[1] / 100.0F);
            if (j > 255) j = 255;
            if (j < 0) j = 0;
            k = (int) (159.0F + 159.0F * this.m.snap[2] / 100.0F);
            if (k > 255) k = 255;
            if (k < 0) k = 0;
            for (b = 0; b < this.nplayers; b++) {
                if (b != this.im && paramCheckPoints.dested[b] == 0) {
                    if (this.clangame != 0) {
                        if (this.pclan[b].toLowerCase().equals(this.gaclan.toLowerCase())) {
                            i = 159;
                            j = 80;
                            k = 0;
                        } else {
                            i = 0;
                            j = 80;
                            k = 159;
                        }
                        i = (int) (i + i * this.m.snap[0] / 100.0F);
                        if (i > 255) i = 255;
                        if (i < 0) i = 0;
                        j = (int) (j + j * this.m.snap[1] / 100.0F);
                        if (j > 255) j = 255;
                        if (j < 0) j = 0;
                        k = (int) (k + k * this.m.snap[2] / 100.0F);
                        if (k > 255) k = 255;
                        if (k < 0) k = 0;
                    }
                    byte b1 = 2;
                    if (this.alocked == b) {
                        b1 = 3;
                        this.rd.setColor(new Color(i, j, k));
                    } else {
                        this.rd.setColor(new Color((i + this.m.csky[0]) / 2, (this.m.csky[1] + j) / 2, (k + this.m.csky[2]) / 2));
                    }
                    this.rd.drawLine(arrayOfInt1[b] - b1, arrayOfInt2[b], arrayOfInt1[b] + b1, arrayOfInt2[b]);
                    this.rd.drawLine(arrayOfInt1[b], arrayOfInt2[b] + b1, arrayOfInt1[b], arrayOfInt2[b] - b1);
                    this.rd.setColor(new Color(i, j, k));
                    this.rd.fillRect(arrayOfInt1[b] - 1, arrayOfInt2[b] - 1, 3, 3);
                }
            }
        }
        i = (int) (159.0F + 159.0F * this.m.snap[0] / 100.0F);
        if (i > 255) i = 255;
        if (i < 0) i = 0;
        j = 0;
        k = 0;
        if (this.clangame != 0) {
            if (this.pclan[this.im].toLowerCase().equals(this.gaclan.toLowerCase())) {
                i = 159;
                j = 80;
                k = 0;
            } else {
                i = 0;
                j = 80;
                k = 159;
            }
            i = (int) (i + i * this.m.snap[0] / 100.0F);
            if (i > 255) i = 255;
            if (i < 0) i = 0;
            j = (int) (j + j * this.m.snap[1] / 100.0F);
            if (j > 255) j = 255;
            if (j < 0) j = 0;
            k = (int) (k + k * this.m.snap[2] / 100.0F);
            if (k > 255) k = 255;
            if (k < 0) k = 0;
        }
        this.rd.setColor(new Color((i + this.m.csky[0]) / 2, (this.m.csky[1] + j) / 2, (k + this.m.csky[2]) / 2));
        this.rd.drawLine(96, 139, 96, 143);
        this.rd.drawLine(94, 141, 98, 141);
        this.rd.setColor(new Color(i, j, k));
        this.rd.fillRect(95, 140, 3, 3);
        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        if (this.m.darksky) {
            Color color = new Color(this.m.csky[0], this.m.csky[1], this.m.csky[2]);
            float[] arrayOfFloat = new float[3];
            Color.RGBtoHSB(this.m.csky[0], this.m.csky[1], this.m.csky[2], arrayOfFloat);
            arrayOfFloat[2] = 0.6F;
            color = Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
            this.rd.setColor(color);
            this.rd.fillRect(5, 232, 181, 17);
            this.rd.drawLine(4, 233, 4, 247);
            this.rd.drawLine(3, 235, 3, 245);
            this.rd.drawLine(186, 233, 186, 247);
            this.rd.drawLine(187, 235, 187, 245);
        }
        this.rd.drawImage(this.sped, 7, 234, (ImageObserver) null);
        int m = paramContO.x - this.lcarx;
        this.lcarx = paramContO.x;
        int n = paramContO.y - this.lcary;
        this.lcary = paramContO.y;
        int i1 = paramContO.z - this.lcarz;
        this.lcarz = paramContO.z;
        float f1 = (float) Math.sqrt((m * m + i1 * i1));
        float f2 = f1 * 1.4F * 21.0F * 60.0F * 60.0F / 100000.0F;
        float f3 = f2 * 0.621371F;
        this.rd.setColor(new Color(0, 0, 100));
        this.rd.drawString("" + (int) f2, 62, 245);
        this.rd.drawString("" + (int) f3, 132, 245);
    }

    public void playsounds(Mad paramMad, Control paramControl, int paramInt) {
        if ((this.fase == 0 || this.fase == 7001) && this.starcnt < 35 && this.cntwis != 8 && !this.mutes) {
            boolean bool1 = ((paramControl.up && paramMad.speed > 0.0F) || (paramControl.down && paramMad.speed < 10.0F)) ? true : false;
            boolean bool2 = ((paramMad.skid == 1 && paramControl.handb) || Math.abs(paramMad.scz[0] - (paramMad.scz[1] + paramMad.scz[0] + paramMad.scz[2] + paramMad.scz[3]) / 4.0F) > 1.0F || Math.abs(paramMad.scx[0] - (paramMad.scx[1] + paramMad.scx[0] + paramMad.scx[2] + paramMad.scx[3]) / 4.0F) > 1.0F) ? true : false;
            boolean bool3 = false;
            if (paramControl.up && paramMad.speed < 10.0F) {
                bool2 = true;
                bool1 = true;
                bool3 = true;
            }
            if (bool1 && paramMad.mtouch) {
                if (!paramMad.capsized) {
                    if (!bool2) {
                        if (paramMad.power != 98.0F) {
                            if (Math.abs(paramMad.speed) > 0.0F && Math.abs(paramMad.speed) <= this.cd.swits[paramMad.cn][0]) {
                                int i = (int) (3.0F * Math.abs(paramMad.speed) / this.cd.swits[paramMad.cn][0]);
                                if (i == 2) {
                                    if (this.pwait == 0) {
                                        i = 0;
                                    } else {
                                        this.pwait--;
                                    }
                                } else {
                                    this.pwait = 7;
                                }
                                sparkeng(i, paramMad.cn);
                            }
                            if (Math.abs(paramMad.speed) > this.cd.swits[paramMad.cn][0] && Math.abs(paramMad.speed) <= this.cd.swits[paramMad.cn][1]) {
                                int i = (int) (3.0F * (Math.abs(paramMad.speed) - this.cd.swits[paramMad.cn][0]) / (this.cd.swits[paramMad.cn][1] - this.cd.swits[paramMad.cn][0]));
                                if (i == 2) {
                                    if (this.pwait == 0) {
                                        i = 0;
                                    } else {
                                        this.pwait--;
                                    }
                                } else {
                                    this.pwait = 7;
                                }
                                sparkeng(i, paramMad.cn);
                            }
                            if (Math.abs(paramMad.speed) > this.cd.swits[paramMad.cn][1] && Math.abs(paramMad.speed) <= this.cd.swits[paramMad.cn][2]) {
                                int i = (int) (3.0F * (Math.abs(paramMad.speed) - this.cd.swits[paramMad.cn][1]) / (this.cd.swits[paramMad.cn][2] - this.cd.swits[paramMad.cn][1]));
                                sparkeng(i, paramMad.cn);
                            }
                        } else {
                            byte b = 2;
                            if (this.pwait == 0) {
                                if (Math.abs(paramMad.speed) > this.cd.swits[paramMad.cn][1]) b = 3;
                            } else {
                                this.pwait--;
                            }
                            sparkeng(b, paramMad.cn);
                        }
                    } else {
                        sparkeng(-1, paramMad.cn);
                        if (bool3) {
                            if (this.stopcnt <= 0) {
                                this.air[5].loop();
                                this.stopcnt = 10;
                            }
                        } else if (this.stopcnt <= -2) {
                            this.air[2 + (int) (this.m.random() * 3.0F)].loop();
                            this.stopcnt = 7;
                        }
                    }
                } else {
                    sparkeng(3, paramMad.cn);
                }
                this.grrd = false;
                this.aird = false;
            } else {
                this.pwait = 15;
                if (!paramMad.mtouch && !this.grrd && this.m.random() > 0.4D) {
                    this.air[(int) (this.m.random() * 4.0F)].loop();
                    this.stopcnt = 5;
                    this.grrd = true;
                }
                if (!paramMad.wtouch && !this.aird) {
                    stopairs();
                    this.air[(int) (this.m.random() * 4.0F)].loop();
                    this.stopcnt = 10;
                    this.aird = true;
                }
                sparkeng(-1, paramMad.cn);
            }
            if (paramMad.cntdest != 0 && this.cntwis < 7) {
                if (!this.pwastd) {
                    this.wastd.loop();
                    this.pwastd = true;
                }
            } else {
                if (this.pwastd) {
                    this.wastd.stop();
                    this.pwastd = false;
                }
                if (this.cntwis == 7 && !this.mutes) this.firewasted.play();
            }
        } else {
            sparkeng(-2, paramMad.cn);
            if (this.pwastd) {
                this.wastd.stop();
                this.pwastd = false;
            }
        }
        if (this.stopcnt != -20) {
            if (this.stopcnt == 1) stopairs();
            this.stopcnt--;
        }
        if (this.bfcrash != 0) this.bfcrash--;
        if (this.bfscrape != 0) this.bfscrape--;
        if (this.bfsc1 != 0) this.bfsc1--;
        if (this.bfsc2 != 0) this.bfsc2--;
        if (this.bfskid != 0) this.bfskid--;
        if (paramMad.newcar) this.cntwis = 0;
        if (this.fase == 0 || this.fase == 7001 || this.fase == 6 || this.fase == -1 || this.fase == -2 || this.fase == -3 || this.fase == -4 || this.fase == -5) {
            if (this.mutes != paramControl.mutes) this.mutes = paramControl.mutes;
            if (paramControl.mutem != this.mutem) {
                this.mutem = paramControl.mutem;
                if (this.mutem) {
                    if (this.loadedt) this.strack.stop();
                } else if (this.loadedt) {
                    this.strack.resume();
                }
            }
        }
        if (paramMad.cntdest != 0 && this.cntwis < 7) {
            if (paramMad.dest) this.cntwis++;
        } else {
            if (paramMad.cntdest == 0) this.cntwis = 0;
            if (this.cntwis == 7) this.cntwis = 8;
        }
        if (this.app.applejava) closesounds();
    }

    public void stopairs() {
        for (byte b = 0; b < 6; ) {
            this.air[b].stop();
            b++;
        }
    }

    public void sparkeng(int paramInt1, int paramInt2) {
        if (this.lcn != paramInt2) {
            for (byte b1 = 0; b1 < 5; ) {
                if (this.pengs[b1]) {
                    this.engs[this.cd.enginsignature[this.lcn]][b1].stop();
                    this.pengs[b1] = false;
                }
                b1++;
            }
            this.lcn = paramInt2;
        }
        paramInt1++;
        for (byte b = 0; b < 5; ) {
            if (paramInt1 == b) {
                if (!this.pengs[b]) {
                    this.engs[this.cd.enginsignature[paramInt2]][b].loop();
                    this.pengs[b] = true;
                }
            } else if (this.pengs[b]) {
                this.engs[this.cd.enginsignature[paramInt2]][b].stop();
                this.pengs[b] = false;
            }
            b++;
        }
    }

    public void crash(float paramFloat, int paramInt) {
        if (this.bfcrash == 0) {
            if (paramInt == 0) {
                if (Math.abs(paramFloat) > 25.0F && Math.abs(paramFloat) < 170.0F) {
                    if (!this.mutes) this.lowcrash[this.crshturn].play();
                    this.bfcrash = 2;
                }
                if (Math.abs(paramFloat) >= 170.0F) {
                    if (!this.mutes) this.crash[this.crshturn].play();
                    this.bfcrash = 2;
                }
                if (Math.abs(paramFloat) > 25.0F) {
                    if (this.crashup) {
                        this.crshturn--;
                    } else {
                        this.crshturn++;
                    }
                    if (this.crshturn == -1) this.crshturn = 2;
                    if (this.crshturn == 3) this.crshturn = 0;
                }
            }
            if (paramInt == -1) {
                if (Math.abs(paramFloat) > 25.0F && Math.abs(paramFloat) < 170.0F) {
                    if (!this.mutes) this.lowcrash[2].play();
                    this.bfcrash = 2;
                }
                if (Math.abs(paramFloat) > 170.0F) {
                    if (!this.mutes) this.crash[2].play();
                    this.bfcrash = 2;
                }
            }
            if (paramInt == 1) {
                if (!this.mutes) this.tires.play();
                this.bfcrash = 3;
            }
        }
    }

    public void skid(int paramInt, float paramFloat) {
        if (this.bfcrash == 0 && this.bfskid == 0 && paramFloat > 150.0F) {
            if (paramInt == 0) {
                if (!this.mutes) this.skid[this.skflg].play();
                if (this.skidup) {
                    this.skflg++;
                } else {
                    this.skflg--;
                }
                if (this.skflg == 3) this.skflg = 0;
                if (this.skflg == -1) this.skflg = 2;
            } else {
                if (!this.mutes) this.dustskid[this.dskflg].play();
                if (this.skidup) {
                    this.dskflg++;
                } else {
                    this.dskflg--;
                }
                if (this.dskflg == 3) this.dskflg = 0;
                if (this.dskflg == -1) this.dskflg = 2;
            }
            this.bfskid = 35;
        }
    }

    public void scrape(int paramInt1, int paramInt2, int paramInt3) {
        if (this.bfscrape == 0)
            if (Math.sqrt((paramInt1 * paramInt1 + paramInt2 * paramInt2 + paramInt3 * paramInt3)) / 10.0D > 10.0D) {
                boolean bool = false;
                if (this.m.random() > this.m.random()) bool = true;
                if (!bool) {
                    this.sturn1 = 0;
                    this.sturn0++;
                    if (this.sturn0 == 3) {
                        bool = true;
                        this.sturn1 = 1;
                        this.sturn0 = 0;
                    }
                } else {
                    this.sturn0 = 0;
                    this.sturn1++;
                    if (this.sturn1 == 3) {
                        bool = false;
                        this.sturn0 = 1;
                        this.sturn1 = 0;
                    }
                }
                if (!this.mutes) this.scrape[bool].play();
                this.bfscrape = 5;
            }
    }

    public void gscrape(int paramInt1, int paramInt2, int paramInt3) {
        if (this.bfsc1 == 0 || this.bfsc2 == 0)
            if (Math.sqrt((paramInt1 * paramInt1 + paramInt2 * paramInt2 + paramInt3 * paramInt3)) / 10.0D > 15.0D)
                if (this.bfsc1 == 0) {
                    if (!this.mutes) {
                        this.scrape[2].stop();
                        this.scrape[2].play();
                    }
                    this.bfsc1 = 12;
                    this.bfsc2 = 6;
                } else {
                    if (!this.mutes) {
                        this.scrape[3].stop();
                        this.scrape[3].play();
                    }
                    this.bfsc2 = 12;
                    this.bfsc1 = 6;
                }
    }

    public void closesounds() {
        byte b;
        for (b = 0; b < 5; ) {
            for (byte b1 = 0; b1 < 5; ) {
                this.engs[b][b1].checkopen();
                b1++;
            }
            b++;
        }
        for (b = 0; b < 6; ) {
            this.air[b].checkopen();
            b++;
        }
        this.tires.checkopen();
        this.checkpoint.checkopen();
        this.carfixed.checkopen();
        this.powerup.checkopen();
        this.three.checkopen();
        this.two.checkopen();
        this.one.checkopen();
        this.go.checkopen();
        this.wastd.checkopen();
        this.firewasted.checkopen();
        for (b = 0; b < 3; ) {
            this.skid[b].checkopen();
            this.dustskid[b].checkopen();
            this.crash[b].checkopen();
            this.lowcrash[b].checkopen();
            this.scrape[b].checkopen();
            b++;
        }
    }

    public void rot(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (paramInt3 != 0) for (byte b = 0; b < paramInt4; ) {
            int i = paramArrayOfint1[b], j = paramArrayOfint2[b];
            paramArrayOfint1[b] = paramInt1 + (int) ((i - paramInt1) * this.m.cos(paramInt3) - (j - paramInt2) * this.m.sin(paramInt3));
            paramArrayOfint2[b] = paramInt2 + (int) ((i - paramInt1) * this.m.sin(paramInt3) + (j - paramInt2) * this.m.cos(paramInt3));
            b++;
        }
    }

    public int xs(int paramInt1, int paramInt2) {
        if (paramInt2 < 50) paramInt2 = 50;
        return (paramInt2 - this.m.focus_point) * (this.m.cx - paramInt1) / paramInt2 + paramInt1;
    }

    public int ys(int paramInt1, int paramInt2) {
        if (paramInt2 < 50) paramInt2 = 50;
        return (paramInt2 - this.m.focus_point) * (this.m.cy - paramInt1) / paramInt2 + paramInt1;
    }

    public int py(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        return (paramInt1 - paramInt2) * (paramInt1 - paramInt2) + (paramInt3 - paramInt4) * (paramInt3 - paramInt4);
    }

    public float pys(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        return (float) Math.sqrt(((paramInt1 - paramInt2) * (paramInt1 - paramInt2) + (paramInt3 - paramInt4) * (paramInt3 - paramInt4)));
    }

    public void snap(int paramInt) {
        byte b;
        for (this.dmg = loadsnap(this.odmg), this.pwr = loadsnap(this.opwr), this.was = loadsnap(this.owas), this.lap = loadsnap(this.olap), this.pos = loadsnap(this.opos), this.sped = loadsnap(this.osped), b = 0; b < 8; ) {
            this.rank[b] = loadsnap(this.orank[b]);
            b++;
        }
        for (b = 0; b < 4; ) {
            this.cntdn[b] = loadsnap(this.ocntdn[b]);
            b++;
        }
        if (this.multion != 0) {
            this.wgame = loadsnap(this.owgame);
            this.exitgame = loadsnap(this.oexitgame);
            this.gamefinished = loadsnap(this.ogamefinished);
            this.disco = loadsnap(this.odisco);
        }
        this.yourwasted = loadsnap(this.oyourwasted);
        this.youlost = loadsnap(this.oyoulost);
        this.youwon = loadsnap(this.oyouwon);
        this.youwastedem = loadsnap(this.oyouwastedem);
        this.gameh = loadsnap(this.ogameh);
        this.loadingmusic = loadopsnap(this.oloadingmusic, paramInt, 76);
        this.star[0] = loadopsnap(this.ostar[0], paramInt, 0);
        this.star[1] = loadopsnap(this.ostar[1], paramInt, 0);
        this.flaot = loadopsnap(this.oflaot, paramInt, 1);
    }

    public boolean overon(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
        return (paramInt5 > paramInt1 && paramInt5 < paramInt1 + paramInt3 && paramInt6 > paramInt2 && paramInt6 < paramInt2 + paramInt4);
    }

    public boolean over(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int i = paramImage.getHeight(this.ob), j = paramImage.getWidth(this.ob);
        return (paramInt1 > paramInt3 - 5 && paramInt1 < paramInt3 + j + 5 && paramInt2 > paramInt4 - 5 && paramInt2 < paramInt4 + i + 5);
    }

    public void fleximage(Image paramImage, int paramInt1, int paramInt2) {
        if (!this.badmac) {
            if (paramInt1 == 0) {
                this.flexpix = new int[360000];
                PixelGrabber pixelGrabber = new PixelGrabber(paramImage, 0, 0, 800, 450, this.flexpix, 0, 800);
                try {
                    pixelGrabber.grabPixels();
                } catch (InterruptedException interruptedException) {
                }
            }
            byte b1 = 0;
            int i = 0, j = 0, k = 0;
            int m = (int) (Math.random() * 128.0D);
            int n = (int) (5.0D + Math.random() * 15.0D);
            for (byte b2 = 0; b2 < 360000; b2++) {
                Color color1 = new Color(this.flexpix[b2]);
                int i1 = 0, i2 = 0, i3 = 0;
                if (!b1) {
                    i = i1 = color1.getRed();
                    j = i2 = color1.getGreen();
                    k = i3 = color1.getBlue();
                } else {
                    i = i1 = (int) ((color1.getRed() + i * 0.38F * paramInt1) / (1.0F + 0.38F * paramInt1));
                    j = i2 = (int) ((color1.getGreen() + j * 0.38F * paramInt1) / (1.0F + 0.38F * paramInt1));
                    k = i3 = (int) ((color1.getBlue() + k * 0.38F * paramInt1) / (1.0F + 0.38F * paramInt1));
                }
                if (++b1 == '̠') b1 = 0;
                int i4 = (int) ((i1 * 17 + i2 + i3 + m) / 21.0F);
                int i5 = (int) ((i2 * 17 + i1 + i3 + m) / 22.0F);
                int i6 = (int) ((i3 * 17 + i1 + i2 + m) / 24.0F);
                if (--n == 0) {
                    m = (int) (Math.random() * 128.0D);
                    n = (int) (5.0D + Math.random() * 15.0D);
                }
                Color color2 = new Color(i4, i5, i6);
                this.flexpix[b2] = color2.getRGB();
            }
            this.fleximg = createImage(new MemoryImageSource(800, 450, this.flexpix, 0, 800));
            this.rd.drawImage(this.fleximg, 0, 0, (ImageObserver) null);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.1F));
            this.rd.fillRect(0, 0, 800, 450);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        }
    }

    private Image loadsnap(Image paramImage) {
        int i = paramImage.getHeight(this.ob), j = paramImage.getWidth(this.ob), arrayOfInt[] = new int[j * i];
        PixelGrabber pixelGrabber = new PixelGrabber(paramImage, 0, 0, j, i, arrayOfInt, 0, j);
        try {
            pixelGrabber.grabPixels();
        } catch (InterruptedException interruptedException) {
        }
        for (byte b = 0; b < j * i; b++) {
            Color color1 = new Color(arrayOfInt[j * i - 1]);
            Color color2 = new Color(arrayOfInt[b]);
            if (color2.getRed() != color2.getGreen() && color2.getGreen() != color2.getBlue()) {
                int k = (int) (color2.getRed() + color2.getRed() * this.m.snap[0] / 100.0F);
                if (k > 255) k = 255;
                if (k < 0) k = 0;
                int m = (int) (color2.getGreen() + color2.getGreen() * this.m.snap[1] / 100.0F);
                if (m > 255) m = 255;
                if (m < 0) m = 0;
                int n = (int) (color2.getBlue() + color2.getBlue() * this.m.snap[2] / 100.0F);
                if (n > 255) n = 255;
                if (n < 0) n = 0;
                arrayOfInt[b] = 0xFF000000 | k << 16 | m << 8 | n;
            } else {
                int k = (int) ((color1.getRed() - color2.getRed()) / color1.getRed() * 255.0F);
                if (k > 255) k = 255;
                if (k < 0) k = 0;
                arrayOfInt[b] = k << 24 | 0x0 | 0x0 | 0x0;
            }
        }
        BufferedImage bufferedImage = new BufferedImage(j, i, 2);
        bufferedImage.setRGB(0, 0, j, i, arrayOfInt, 0, j);
        return bufferedImage;
    }

    private Image loadopsnap(Image paramImage, int paramInt1, int paramInt2) {
        int i = paramImage.getHeight(this.ob), j = paramImage.getWidth(this.ob), arrayOfInt1[] = new int[j * i];
        PixelGrabber pixelGrabber = new PixelGrabber(paramImage, 0, 0, j, i, arrayOfInt1, 0, j);
        try {
            pixelGrabber.grabPixels();
        } catch (InterruptedException interruptedException) {
        }
        if (paramInt1 < 0) paramInt1 = 33;
        int k = 0;
        if (paramInt2 == 1) k = arrayOfInt1[61993];
        int[] arrayOfInt2 = {this.m.snap[0], this.m.snap[1], this.m.snap[2]};
        while (arrayOfInt2[0] + arrayOfInt2[1] + arrayOfInt2[2] < -30) {
            for (byte b1 = 0; b1 < 3; ) {
                if (arrayOfInt2[b1] < 50) arrayOfInt2[b1] = arrayOfInt2[b1] + 1;
                b1++;
            }
        }
        for (byte b = 0; b < j * i; b++) {
            if (arrayOfInt1[b] != arrayOfInt1[paramInt2]) {
                Color color1 = new Color(arrayOfInt1[b]);
                int m = 0, n = 0, i1 = 0;
                if (paramInt2 == 1 && arrayOfInt1[b] == k) {
                    m = (int) (237.0F - 237.0F * arrayOfInt2[0] / 150.0F);
                    if (m > 255) m = 255;
                    if (m < 0) m = 0;
                    n = (int) (237.0F - 237.0F * arrayOfInt2[1] / 150.0F);
                    if (n > 255) n = 255;
                    if (n < 0) n = 0;
                    i1 = (int) (237.0F - 237.0F * arrayOfInt2[2] / 150.0F);
                    if (i1 > 255) i1 = 255;
                    if (i1 < 0) i1 = 0;
                    if (paramInt1 == 11) {
                        m = 250;
                        n = 250;
                        i1 = 250;
                    }
                } else {
                    m = (int) (color1.getRed() - color1.getRed() * arrayOfInt2[0] / 100.0F);
                    if (m > 255) m = 255;
                    if (m < 0) m = 0;
                    n = (int) (color1.getGreen() - color1.getGreen() * arrayOfInt2[1] / 100.0F);
                    if (n > 255) n = 255;
                    if (n < 0) n = 0;
                    i1 = (int) (color1.getBlue() - color1.getBlue() * arrayOfInt2[2] / 100.0F);
                    if (i1 > 255) i1 = 255;
                    if (i1 < 0) i1 = 0;
                }
                Color color2 = new Color(m, n, i1);
                arrayOfInt1[b] = color2.getRGB();
            }
        }
        return createImage(new MemoryImageSource(j, i, arrayOfInt1, 0, j));
    }

    private Image pressed(Image paramImage) {
        int i = paramImage.getHeight(this.ob), j = paramImage.getWidth(this.ob), arrayOfInt[] = new int[j * i];
        PixelGrabber pixelGrabber = new PixelGrabber(paramImage, 0, 0, j, i, arrayOfInt, 0, j);
        try {
            pixelGrabber.grabPixels();
        } catch (InterruptedException interruptedException) {
        }
        for (byte b = 0; b < j * i; ) {
            if (arrayOfInt[b] != arrayOfInt[j * i - 1]) arrayOfInt[b] = -16777216;
            b++;
        }
        return createImage(new MemoryImageSource(j, i, arrayOfInt, 0, j));
    }

    private Image bressed(Image paramImage) {
        int i = paramImage.getHeight(this.ob), j = paramImage.getWidth(this.ob), arrayOfInt[] = new int[j * i];
        PixelGrabber pixelGrabber = new PixelGrabber(paramImage, 0, 0, j, i, arrayOfInt, 0, j);
        try {
            pixelGrabber.grabPixels();
        } catch (InterruptedException interruptedException) {
        }
        Color color;
        byte b;
        for (color = new Color(247, 255, 165), b = 0; b < j * i; ) {
            if (arrayOfInt[b] != arrayOfInt[j * i - 1]) arrayOfInt[b] = color.getRGB();
            b++;
        }
        return createImage(new MemoryImageSource(j, i, arrayOfInt, 0, j));
    }

    public void pauseimage(Image paramImage) {
        if (!this.badmac) {
            int[] arrayOfInt = new int[360000];
            PixelGrabber pixelGrabber = new PixelGrabber(paramImage, 0, 0, 800, 450, arrayOfInt, 0, 800);
            try {
                pixelGrabber.grabPixels();
            } catch (InterruptedException interruptedException) {
            }
            byte b1 = 0, b2 = 0;
            int i = 0;
            byte b3 = 0;
            for (byte b4 = 0; b4 < 360000; b4++) {
                Color color = new Color(arrayOfInt[b4]);
                int j = 0;
                if (!b3) {
                    i = j = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
                } else {
                    i = j = (color.getRed() + color.getGreen() + color.getBlue() + i * 30) / 33;
                }
                if (++b3 == '̠') b3 = 0;
                if (b4 > 800 * (8 + b2) + 281 && b2 < '¼') {
                    int k = (j + 60) / 3, m = (j + 135) / 3, n = (j + 220) / 3;
                    if (++b1 == 'í') {
                        b2++;
                        b1 = 0;
                    }
                    Color color1 = new Color(k, m, n);
                    arrayOfInt[b4] = color1.getRGB();
                } else {
                    Color color1 = new Color(j, j, j);
                    arrayOfInt[b4] = color1.getRGB();
                }
            }
            this.fleximg = createImage(new MemoryImageSource(800, 450, arrayOfInt, 0, 800));
            this.rd.drawImage(this.fleximg, 0, 0, (ImageObserver) null);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
            this.rd.fillRect(0, 0, 800, 450);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        }
    }

    public void jflexo() {
        if (!this.badmac) {
            int[] arrayOfInt = new int[360000];
            PixelGrabber pixelGrabber = new PixelGrabber(this.app.offImage, 0, 0, 800, 450, arrayOfInt, 0, 800);
            try {
                pixelGrabber.grabPixels();
            } catch (InterruptedException interruptedException) {
            }
            int i = 0, j = 0, k = 0;
            byte b1 = 0;
            for (byte b2 = 0; b2 < 360000; b2++) {
                Color color1 = new Color(arrayOfInt[b2]);
                int m = 0, n = 0, i1 = 0;
                if (!b1) {
                    i = m = color1.getRed();
                    k = n = color1.getGreen();
                    j = i1 = color1.getBlue();
                } else {
                    i = m = (color1.getRed() + i * 10) / 11;
                    k = n = (color1.getGreen() + k * 10) / 11;
                    j = i1 = (color1.getBlue() + j * 10) / 11;
                }
                if (++b1 == '̠') b1 = 0;
                Color color2 = new Color(m, n, i1);
                arrayOfInt[b2] = color2.getRGB();
            }
            Image image = createImage(new MemoryImageSource(800, 450, arrayOfInt, 0, 800));
            this.rd.drawImage(image, 0, 0, (ImageObserver) null);
        } else {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.5F));
            this.rd.fillRect(0, 0, 800, 450);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        }
    }

    public void pingstat() {
        int i = (int) (100.0D * Math.random());
        try {
            URL uRL = new URL("http://c.statcounter.com/9994681/0/14bb645e/1/?reco=" + i + "");
            uRL.openConnection().setConnectTimeout(5000);
            Image image = Toolkit.getDefaultToolkit().createImage(uRL);
            MediaTracker mediaTracker = new MediaTracker(this.app);
            mediaTracker.addImage(image, 0);
            mediaTracker.waitForID(0);
            mediaTracker.removeImage(image, 0);
            mediaTracker = null;
            image = null;
        } catch (Exception exception) {
        }
    }

    public Image getImage(String paramString) {
        Image image = Toolkit.getDefaultToolkit().createImage("" + Madness.fpath + "" + paramString + "");
        MediaTracker mediaTracker = new MediaTracker(this.app);
        mediaTracker.addImage(image, 0);
        try {
            mediaTracker.waitForID(0);
        } catch (Exception exception) {
        }
        return image;
    }

    private Image loadimage(byte[] paramArrayOfbyte, MediaTracker paramMediaTracker, Toolkit paramToolkit) {
        Image image = paramToolkit.createImage(paramArrayOfbyte);
        paramMediaTracker.addImage(image, 0);
        try {
            paramMediaTracker.waitForID(0);
        } catch (Exception exception) {
        }
        return image;
    }

    private Image loadude(byte[] paramArrayOfbyte, MediaTracker paramMediaTracker, Toolkit paramToolkit) {
        Image image = paramToolkit.createImage(paramArrayOfbyte);
        paramMediaTracker.addImage(image, 0);
        try {
            paramMediaTracker.waitForID(0);
        } catch (Exception exception) {
        }
        int i = image.getHeight(this.ob);
        int j = image.getWidth(this.ob);
        int[] arrayOfInt = new int[j * i];
        PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, j, i, arrayOfInt, 0, j);
        try {
            pixelGrabber.grabPixels();
        } catch (InterruptedException interruptedException) {
        }
        for (byte b = 0; b < j * i; b++) {
            Color color = new Color(arrayOfInt[b]);
            if (color.getGreen() > color.getRed() + 5 && color.getGreen() > color.getBlue() + 5) {
                int k = (int) (255.0F - (color.getGreen() - (color.getRed() + color.getBlue()) / 2) * 1.5F);
                if (k > 255) k = 255;
                if (k < 0) k = 0;
                arrayOfInt[b] = k << 24 | 0x0 | 0x0 | 0x0;
            }
        }
        BufferedImage bufferedImage = new BufferedImage(j, i, 2);
        bufferedImage.setRGB(0, 0, j, i, arrayOfInt, 0, j);
        image = null;
        return bufferedImage;
    }

    private Image loadBimage(byte[] paramArrayOfbyte, MediaTracker paramMediaTracker, Toolkit paramToolkit, int paramInt) {
        Image image1 = paramToolkit.createImage(paramArrayOfbyte);
        paramMediaTracker.addImage(image1, 0);
        try {
            paramMediaTracker.waitForID(0);
        } catch (Exception exception) {
        }
        int i = image1.getHeight(this.ob);
        int j = image1.getWidth(this.ob);
        int[] arrayOfInt = new int[j * i];
        PixelGrabber pixelGrabber = new PixelGrabber(image1, 0, 0, j, i, arrayOfInt, 0, j);
        try {
            pixelGrabber.grabPixels();
        } catch (InterruptedException interruptedException) {
        }
        for (byte b = 0; b < j * i; b++) {
            if (arrayOfInt[b] != arrayOfInt[0] || paramInt != 0) {
                Color color1 = new Color(arrayOfInt[b]);
                float[] arrayOfFloat = new float[3];
                Color.RGBtoHSB(color1.getRed(), color1.getGreen(), color1.getBlue(), arrayOfFloat);
                arrayOfFloat[0] = 0.12F;
                arrayOfFloat[1] = 0.45F;
                if (paramInt == 3) {
                    arrayOfFloat[0] = 0.13F;
                    arrayOfFloat[1] = 0.45F;
                }
                Color color2 = Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
                arrayOfInt[b] = color2.getRGB();
            }
        }
        if (paramInt == 2) {
            Color color = new Color(arrayOfInt[0]);
            int k = 0x40000000 | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue();
            color = new Color(arrayOfInt[1]);
            int m = Integer.MIN_VALUE | color.getRed() << 16 | color.getGreen() << 8 | color.getBlue();
            for (byte b1 = 2; b1 < j * i; b1++) {
                if (arrayOfInt[b1] == arrayOfInt[0]) arrayOfInt[b1] = k;
                if (arrayOfInt[b1] == arrayOfInt[1]) arrayOfInt[b1] = m;
            }
            arrayOfInt[0] = k;
            arrayOfInt[1] = m;
        }
        Image image2 = null;
        if (paramInt == 2) {
            BufferedImage bufferedImage = new BufferedImage(j, i, 2);
            bufferedImage.setRGB(0, 0, j, i, arrayOfInt, 0, j);
            image2 = bufferedImage;
        } else {
            image2 = createImage(new MemoryImageSource(j, i, arrayOfInt, 0, j));
        }
        image1 = null;
        return image2;
    }

    private Image dodgen(Image paramImage) {
        int i = paramImage.getHeight(this.ob), j = paramImage.getWidth(this.ob), arrayOfInt[] = new int[j * i];
        PixelGrabber pixelGrabber = new PixelGrabber(paramImage, 0, 0, j, i, arrayOfInt, 0, j);
        try {
            pixelGrabber.grabPixels();
        } catch (InterruptedException interruptedException) {
        }
        for (byte b = 0; b < j * i; ) {
            Color color1 = new Color(arrayOfInt[b]);
            int k = color1.getRed() * 4 + 90;
            if (k > 255) k = 255;
            if (k < 0) k = 0;
            int m = color1.getGreen() * 4 + 90;
            if (m > 255) m = 255;
            if (m < 0) m = 0;
            int n = color1.getBlue() * 4 + 90;
            if (n > 255) n = 255;
            if (n < 0) n = 0;
            Color color2 = new Color(k, m, n);
            arrayOfInt[b] = color2.getRGB();
            b++;
        }
        return createImage(new MemoryImageSource(j, i, arrayOfInt, 0, j));
    }

    private void smokeypix(byte[] paramArrayOfbyte, MediaTracker paramMediaTracker, Toolkit paramToolkit) {
        Image image = paramToolkit.createImage(paramArrayOfbyte);
        paramMediaTracker.addImage(image, 0);
        try {
            paramMediaTracker.waitForID(0);
        } catch (Exception exception) {
        }
        PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, 466, 202, this.smokey, 0, 466);
        try {
            pixelGrabber.grabPixels();
        } catch (InterruptedException interruptedException) {
        }
        for (byte b = 0; b < 94132; b++) {
            if (this.smokey[b] != this.smokey[0]) {
                Color color1 = new Color(this.smokey[b]);
                float[] arrayOfFloat = new float[3];
                Color.RGBtoHSB(color1.getRed(), color1.getGreen(), color1.getBlue(), arrayOfFloat);
                arrayOfFloat[0] = 0.11F;
                arrayOfFloat[1] = 0.45F;
                Color color2 = Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
                this.smokey[b] = color2.getRGB();
            }
        }
    }

    private void makecarsbgc(Image paramImage1, Image paramImage2) {
        int[] arrayOfInt1 = new int[268000];
        PixelGrabber pixelGrabber1 = new PixelGrabber(this.carsbg, 0, 0, 670, 400, arrayOfInt1, 0, 670);
        try {
            pixelGrabber1.grabPixels();
        } catch (InterruptedException interruptedException) {
        }
        int[] arrayOfInt2 = new int[20700];
        PixelGrabber pixelGrabber2 = new PixelGrabber(paramImage1, 0, 0, 92, 225, arrayOfInt2, 0, 92);
        try {
            pixelGrabber2.grabPixels();
        } catch (InterruptedException interruptedException) {
        }
        int[] arrayOfInt3 = new int[2112];
        PixelGrabber pixelGrabber3 = new PixelGrabber(paramImage2, 0, 0, 88, 24, arrayOfInt3, 0, 88);
        try {
            pixelGrabber3.grabPixels();
        } catch (InterruptedException interruptedException) {
        }
        for (byte b = 0; b < 'ʞ'; b++) {
            for (byte b1 = 0; b1 < 'Ɛ'; b1++) {
                if (b > 14 && b < 106 && b1 > 11 && b1 < 'ì')
                    if (arrayOfInt2[b - 14 + (b1 - 11) * 92] != arrayOfInt2[0]) {
                        Color color1 = new Color(arrayOfInt1[b + b1 * 670]);
                        Color color2 = new Color(arrayOfInt2[b - 14 + (b1 - 11) * 92]);
                        int i = (int) (color1.getRed() * 0.33D + color2.getRed() * 0.67D);
                        if (i > 255) i = 255;
                        if (i < 0) i = 0;
                        int j = (int) (color1.getGreen() * 0.33D + color2.getGreen() * 0.67D);
                        if (j > 255) j = 255;
                        if (j < 0) j = 0;
                        int k = (int) (color1.getBlue() * 0.33D + color2.getBlue() * 0.67D);
                        if (k > 255) k = 255;
                        if (k < 0) k = 0;
                        Color color3 = new Color(i, j, k);
                        arrayOfInt1[b + b1 * 670] = color3.getRGB();
                    }
                if (b > 'ȴ' && b < 'ʐ' && b1 > 11 && b1 < 'ì')
                    if (arrayOfInt2[b - 564 + (b1 - 11) * 92] != arrayOfInt2[0]) {
                        Color color1 = new Color(arrayOfInt1[b + b1 * 670]);
                        Color color2 = new Color(arrayOfInt2[b - 564 + (b1 - 11) * 92]);
                        int i = (int) (color1.getRed() * 0.33D + color2.getRed() * 0.67D);
                        if (i > 255) i = 255;
                        if (i < 0) i = 0;
                        int j = (int) (color1.getGreen() * 0.33D + color2.getGreen() * 0.67D);
                        if (j > 255) j = 255;
                        if (j < 0) j = 0;
                        int k = (int) (color1.getBlue() * 0.33D + color2.getBlue() * 0.67D);
                        if (k > 255) k = 255;
                        if (k < 0) k = 0;
                        Color color3 = new Color(i, j, k);
                        arrayOfInt1[b + b1 * 670] = color3.getRGB();
                    }
                if (b > 'Ƹ' && b < 'Ȑ' && b1 > 53 && b1 < 77)
                    if (arrayOfInt3[b - 440 + (b1 - 53) * 88] != arrayOfInt3[0]) {
                        Color color1 = new Color(arrayOfInt1[b + b1 * 670]);
                        Color color2 = new Color(arrayOfInt3[b - 440 + (b1 - 53) * 88]);
                        int i = (int) (color1.getRed() * 0.33D + color2.getRed() * 0.67D);
                        if (i > 255) i = 255;
                        if (i < 0) i = 0;
                        int j = (int) (color1.getGreen() * 0.33D + color2.getGreen() * 0.67D);
                        if (j > 255) j = 255;
                        if (j < 0) j = 0;
                        int k = (int) (color1.getBlue() * 0.33D + color2.getBlue() * 0.67D);
                        if (k > 255) k = 255;
                        if (k < 0) k = 0;
                        Color color3 = new Color(i, j, k);
                        arrayOfInt1[b + b1 * 670] = color3.getRGB();
                    }
            }
        }
        this.carsbgc = createImage(new MemoryImageSource(670, 400, arrayOfInt1, 0, 670));
    }

    public void drawSmokeCarsbg() {
        if (!this.badmac) {
            if (Math.abs(this.flyr - this.flyrdest) > 20) {
                if (this.flyr > this.flyrdest) {
                    this.flyr -= 20;
                } else {
                    this.flyr += 20;
                }
            } else {
                this.flyr = this.flyrdest;
                this.flyrdest = (int) (this.flyr + this.m.random() * 160.0F - 80.0F);
            }
            if (this.flyr > 160) this.flyr = 160;

            if (this.flatr > 170) {

                this.flatrstart++;
                this.flatr = this.flatrstart * 3;
                this.flyr = (int) (this.m.random() * 160.0F - 80.0F);
                this.flyrdest = (int) (this.flyr + this.m.random() * 160.0F - 80.0F);
                this.flang = 1;
            }


            for (byte b = 0; b < 'ǒ'; b++) {

                for (byte b1 = 0; b1 < 'Ê'; b1++) {

                    if (this.smokey[b + b1 * 466] != this.smokey[0]) {

                        float f = pys(b, 233, b1, this.flyr);
                        int i = (int) ((b - 233) / f * this.flatr);
                        int j = (int) ((b1 - this.flyr) / f * this.flatr);
                        int k = b + i + 100 + (b1 + j + 110) * 670;
                        if (b + i + 100 < 670 && b + i + 100 > 0 && b1 + j + 110 < 400 && b1 + j + 110 > 0 && k < 268000 && k >= 0) {

                            Color color1 = new Color(this.flexpix[k]);
                            Color color2 = new Color(this.smokey[b + b1 * 466]);
                            float f1 = (255.0F - color2.getRed()) / 255.0F;
                            float f2 = (255.0F - color2.getGreen()) / 255.0F;
                            float f3 = (255.0F - color2.getBlue()) / 255.0F;
                            int m = (int) ((color1.getRed() * this.flang * f1 + color2.getRed() * (1.0F - f1)) / (this.flang * f1 + 1.0F - f1));
                            int n = (int) ((color1.getGreen() * this.flang * f2 + color2.getGreen() * (1.0F - f2)) / (this.flang * f2 + 1.0F - f2));
                            int i1 = (int) ((color1.getBlue() * this.flang * f3 + color2.getBlue() * (1.0F - f3)) / (this.flang * f3 + 1.0F - f3));
                            if (m > 255) m = 255;
                            if (m < 0) m = 0;
                            if (n > 255) n = 255;
                            if (n < 0) n = 0;
                            if (i1 > 255) i1 = 255;
                            if (i1 < 0) i1 = 0;
                            Color color3 = new Color(m, n, i1);
                            this.flexpix[k] = color3.getRGB();
                        }
                    }
                }
            }

            this.flang += 2;
            this.flatr += 10 + this.flatrstart * 2;

            Image image = createImage(new MemoryImageSource(670, 400, this.flexpix, 0, 670));
            this.rd.drawImage(image, 65, 25, (ImageObserver) null);
        } else {
            this.rd.drawImage(this.carsbg, 65, 25, (ImageObserver) null);
            this.flatrstart++;
        }
    }


    public boolean msgcheck(String paramString) {
        boolean bool1 = false;
        paramString = paramString.toLowerCase();
        String[] arrayOfString = {"fu ", " rape", "slut ", "screw ", "redtube", "fuck", "fuk", "f*ck", "fu*k", "f**k", "ass hole", "asshole", "dick", "dik", "cock", "cok ", "shit", "damn", "sex", "anal", "whore", "bitch", "biatch", "bich", " ass", "bastard", "cunt", "dildo", "fag", "homo", "mothaf", "motherf", "negro", "nigga", "nigger", "pussy", "gay", "homo", "you punk", "i will kill you"};
        for (byte b1 = 0; b1 < arrayOfString.length; ) {
            if (paramString.indexOf(arrayOfString[b1]) != -1) bool1 = true;
            b1++;
        }
        if (paramString.startsWith("ass ")) bool1 = true;
        if (paramString.equals("ass")) bool1 = true;
        if (paramString.equals("rape")) bool1 = true;
        if (paramString.equals("fu")) bool1 = true;

        String str1 = "", str2 = "";
        byte b2 = 0, b3 = 0;
        boolean bool2 = false;
        while (b2 < paramString.length() && !bool2) {
            if (!b3) {
                str1 = str1 + "" + paramString.charAt(b2);
                b3 = 1;
            } else {
                b3 = 0;
                if (!str2.equals("") && !str2.equals("" + paramString.charAt(b2))) bool2 = true;
                str2 = "" + paramString.charAt(b2);
            }
            b2++;
        }
        if (!bool2) for (byte b = 0; b < arrayOfString.length; ) {
            if (str1.indexOf(arrayOfString[b]) != -1) bool1 = true;
            b++;
        }
        str1 = "";
        str2 = "";
        b2 = 0;
        b3 = 1;
        bool2 = false;
        while (b2 < paramString.length() && !bool2) {
            if (!b3) {
                str1 = str1 + "" + paramString.charAt(b2);
                b3 = 1;
            } else {
                b3 = 0;
                if (!str2.equals("") && !str2.equals("" + paramString.charAt(b2))) bool2 = true;
                str2 = "" + paramString.charAt(b2);
            }
            b2++;
        }
        if (!bool2) for (byte b = 0; b < arrayOfString.length; ) {
            if (str1.indexOf(arrayOfString[b]) != -1) bool1 = true;
            b++;
        }

        str1 = "";
        str2 = "";
        b2 = 0;
        b3 = 0;
        bool2 = false;
        while (b2 < paramString.length() && !bool2) {
            if (!b3) {
                str1 = str1 + "" + paramString.charAt(b2);
                b3 = 2;
            } else {
                b3--;
                if (!str2.equals("") && !str2.equals("" + paramString.charAt(b2))) bool2 = true;
                str2 = "" + paramString.charAt(b2);
            }
            b2++;
        }
        if (!bool2) for (byte b = 0; b < arrayOfString.length; ) {
            if (str1.indexOf(arrayOfString[b]) != -1) bool1 = true;
            b++;
        }
        str1 = "";
        str2 = "";
        b2 = 0;
        b3 = 1;
        bool2 = false;
        while (b2 < paramString.length() && !bool2) {
            if (b3 == 0) {
                str1 = str1 + "" + paramString.charAt(b2);
                b3 = 2;
            } else {
                b3--;
                if (!str2.equals("") && !str2.equals("" + paramString.charAt(b2))) bool2 = true;
                str2 = "" + paramString.charAt(b2);
            }
            b2++;
        }
        if (!bool2) for (byte b = 0; b < arrayOfString.length; ) {
            if (str1.indexOf(arrayOfString[b]) != -1) bool1 = true;
            b++;
        }
        str1 = "";
        str2 = "";
        b2 = 0;
        b3 = 2;
        bool2 = false;
        while (b2 < paramString.length() && !bool2) {
            if (b3 == 0) {
                str1 = str1 + "" + paramString.charAt(b2);
                b3 = 2;
            } else {
                b3--;
                if (!str2.equals("") && !str2.equals("" + paramString.charAt(b2))) bool2 = true;
                str2 = "" + paramString.charAt(b2);
            }
            b2++;
        }
        if (!bool2) for (byte b = 0; b < arrayOfString.length; ) {
            if (str1.indexOf(arrayOfString[b]) != -1) bool1 = true;
            b++;
        }

        return bool1;
    }


    public boolean drawcarb(boolean paramBoolean1, Image paramImage, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2) {
        boolean bool1 = false;
        int i = 0;
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        if (paramBoolean1) {
            i = this.ftm.stringWidth(paramString);
            if (paramString.startsWith("Class")) i = 112;
        } else {
            i = paramImage.getWidth(this.ob);
        }

        boolean bool2 = false;
        if (paramInt3 > paramInt1 && paramInt3 < paramInt1 + i + 14 && paramInt4 > paramInt2 && paramInt4 < paramInt2 + 28) {
            bool2 = true;
            if (paramBoolean2) bool1 = true;
        }


        this.rd.drawImage(this.bcl[bool2], paramInt1, paramInt2, (ImageObserver) null);
        this.rd.drawImage(this.bc[bool2], paramInt1 + 4, paramInt2, i + 6, 28, null);
        this.rd.drawImage(this.bcr[bool2], paramInt1 + i + 10, paramInt2, (ImageObserver) null);

        if (!paramBoolean1 && i == 73) paramInt2--;
        if (paramBoolean1) {
            if (paramString.equals("X") && bool2 == true) {
                this.rd.setColor(new Color(255, 0, 0));
            } else {
                this.rd.setColor(new Color(0, 0, 0));
            }
            if (paramString.startsWith("Class")) {
                this.rd.drawString(paramString, 400 - this.ftm.stringWidth(paramString) / 2, paramInt2 + 19);
            } else {
                this.rd.drawString(paramString, paramInt1 + 7, paramInt2 + 19);
            }
        } else {
            this.rd.drawImage(paramImage, paramInt1 + 7, paramInt2 + 7, (ImageObserver) null);
        }


        return bool1;
    }


    public void drawWarning() {
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 800, 450);
        this.rd.setFont(new Font("Arial", 1, 22));
        this.ftm = this.rd.getFontMetrics();
        drawcs(100, "Warning!", 255, 0, 0, 3);
        this.rd.setFont(new Font("Arial", 1, 18));
        this.ftm = this.rd.getFontMetrics();
        drawcs(150, "Bad language and flooding is strictly prohibited in this game!", 255, 255, 255, 3);
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        if (this.warning < 210)
            drawcs(200, "If you continue typing bad language or flooding your game will shut down.", 200, 200, 200, 3);
        if (this.warning > 210)
            drawcs(200, "Sorry. This was your second warring your game has shut down.", 200, 200, 200, 3);
        if (this.warning > 250) {
            stopallnow();
            this.runtyp = 0;
            this.app.repaint();
            this.app.gamer.stop();
        }

    }

    public int getvalue(String paramString, int paramInt) {
        int i = -1;
        try {
            byte b1;
            byte b2;
            byte b3;
            String str1;
            String str2;
            for (b1 = 0, b2 = 0, b3 = 0, str1 = "", str2 = ""; b1 < paramString.length() && b3 != 2; ) {
                str1 = "" + paramString.charAt(b1);
                if (str1.equals("|")) {
                    if (b3 == 1 || ++b2 > paramInt) b3 = 2;
                } else if (b2 == paramInt) {
                    str2 = str2 + str1;
                    b3 = 1;
                }
                b1++;
            }
            if (str2.equals("")) str2 = "-1";
            i = Integer.valueOf(str2).intValue();
        } catch (Exception exception) {
        }
        return i;
    }

    public String getSvalue(String paramString, int paramInt) {
        String str = "";
        try {
            byte b1;
            byte b2;
            byte b3;
            String str1;
            String str2;
            for (b1 = 0, b2 = 0, b3 = 0, str1 = "", str2 = ""; b1 < paramString.length() && b3 != 2; ) {
                str1 = "" + paramString.charAt(b1);
                if (str1.equals("|")) {
                    if (b3 == 1 || ++b2 > paramInt) b3 = 2;
                } else if (b2 == paramInt) {
                    str2 = str2 + str1;
                    b3 = 1;
                }
                b1++;
            }
            str = str2;
        } catch (Exception exception) {
        }
        return str;
    }
}


