import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.util.Calendar;


public class Globe
        implements Runnable {
    MediaTracker mt;
    Graphics2D rd;
    xtGraphics xt;
    FontMetrics ftm;
    ImageObserver ob;
    GameSparker gs;
    Login lg;
    CarDefine cd;
    Medium m;
    Graphics2D rdo;
    Image gImage;
    Thread connector;
    boolean domon = false;
    Socket socket;
    BufferedReader din;
    PrintWriter dout;
    int fase = 0;
    int open = 0;
    boolean upo = false;
    int tab = 3;
    boolean onp = false;
    int ptab = 0;
    int spos = 0, lspos = 0, mscro = 825, spos2 = 0, lspos2 = 0, mscro2 = 825, spos3 = 0, lspos3 = 0, mscro3 = 825, spos4 = 208, lspos4 = 0, mscro4 = 825, spos5 = 0, lspos5 = 0, mscro5 = 825;
    int overit = 0;
    int flk = 0;
    int flko = 0;
    boolean flg = false;
    int curs = 0;
    int waitlink = 0;
    int addstage = 0;


    boolean darker = false;

    int npo = -1;
    String[] pname = new String[900];
    int[] proom = new int[900];
    int[] pserver = new int[900];
    int[][] roomf = new int[3][5];


    int npf = -1;
    String[] fname = new String[900];
    String[] cnfname = new String[10];
    int ncnf = 0;
    int freq = 0;
    int sfreq = 0;
    String freqname = "";
    String sfreqname = "";
    int cntf = 0;


    String[] cnames = new String[21];
    String[] sentn = new String[21];
    String[] ctime = new String[21];
    long[] nctime = new long[21];
    int updatec = -1;


    String proname = "";
    boolean loadedp = false;
    int edit = 0;
    int upload = 0;
    int perc = 0;
    int playt = 0;
    int uploadt = 0;
    String filename = "";
    String msg = "";
    String trackname = "";
    boolean refresh = false;
    boolean logol = false;
    boolean avatarl = false;
    int sentchange = 0;
    boolean badlang = false;
    String[] aboutxt = new String[3];
    int nab = 0;
    Image clanlogo;
    Image avatar;
    int racing = 50;
    int wasting = 150;
    String themesong = "";
    String sentance = "";
    int trackvol = 0;
    int comesoon = 0;
    String proclan = "";
    int protab = 0;
    int loadpst = 0;
    String loadpstage = "";

    boolean loadedpstage = false;

    int nlg = 0;
    String[] logos = new String[200];
    boolean[] logon = new boolean[200];
    Image[] logoi = new Image[200];


    int loadmsgs = -1;
    String hasmsgs = "";
    String lastsub = "";
    int nm = 0;
    String[] mname = new String[200];
    String[] mconvo = new String[200];
    String[] msub = new String[200];
    int[] mtyp = new int[200];
    String[] mtime = new String[200];
    long[] mctime = new long[200];
    int openc = 0;
    int opy = 0, addopy = 0, oph = 0;
    int itemsel = 0;
    int loaditem = 0;
    String[] mline = new String[1000];
    int[] mlinetyp = new int[1000];
    long[] mctimes = new long[1000];
    String[] mtimes = new String[1000];
    int nml = 0;
    int readmsg = 0;
    String opname = "";
    String blockname = "";
    String unblockname = "";
    int sendmsg = 0;
    String[] wday = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    String[] month = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    int itab = 0, litab = -1;
    int cadmin = 0;
    String[] cmline = new String[1000];
    int[] cmlinetyp = new int[1000];
    long[] cmctimes = new long[1000];
    String[] cmtimes = new String[1000];
    int cnml = 0;
    int readclan = 0, sendcmsg = 0;

    int loadinter = -1;
    int ni = 0;
    String[] iclan = new String[200];
    String[] iconvo = new String[200];
    String[] isub = new String[200];
    String[] icheck = new String[200];
    String[] itime = new String[200];
    long[] ictime = new long[200];
    String[] istat = new String[200];
    String[] itcar = new String[200];
    String[] igcar = new String[200];
    String[] iwarn = new String[200];

    int openi = 0;
    int readint = 0;
    String intclan = "";
    String lastint = "";
    int dispi = 0;
    String dwarn = "";
    String dtcar = "";
    String dgcar = "";
    int nil = 0;
    String[] iline = new String[1000];
    int[] ilinetyp = new int[1000];
    long[] ictimes = new long[1000];
    String[] itimes = new String[1000];
    int intsel = 0;
    int isel = 0;
    int ifas = 0;
    int leader = -1;
    int sendint = 0;

    boolean inishsel = false;
    boolean redif = false;
    String imsg = "";
    int wag = 0;
    int iflk = 0;
    String itake = "";
    String igive = "";
    String viewcar = "";
    String warnum = "";
    boolean sendwarnum = false;
    String[] wstages = new String[5];
    int[] wlaps = new int[5];
    int[] wcars = new int[5];
    int[] wclass = new int[5];
    int[] wfix = new int[5];
    int nvgames1 = 0, nvgames2 = 0;
    int viewgame1 = 0;
    int viewgame2 = 0;
    String viewwar1 = "";
    String viewwar2 = "";
    String xclan = "";
    String sendwar = "";
    boolean ichlng = false;
    String[] vwstages1 = new String[10];
    int[] vwlaps1 = new int[10];
    int[] vwcars1 = new int[10];
    int[] vwclass1 = new int[10];
    int[] vwfix1 = new int[10];
    String[] vwstages2 = new String[10];
    int[] vwlaps2 = new int[10];
    int[] vwcars2 = new int[10];
    int[] vwclass2 = new int[10];
    int[] vwfix2 = new int[10];
    String[] vwinner = new String[10];
    int vwscorex = 0;
    int vwscorei = 0;
    Image intclanbg = null;
    String intclanlo = "";
    boolean intclanbgloaded = false;
    Image myclanbg = null;
    int loadedmyclanbg = 0;


    int cfase = 0;
    boolean notclan = false;
    String claname = "EvilOnes";
    boolean loadedc = false;
    boolean clanbgl = false;
    Image clanbg;
    int editc = 0, em = 0, ctab = 0;
    int nmb = 0;
    String lccnam = "";
    String[] member = new String[20];
    int[] mlevel = new int[20];
    String[] mrank = new String[20];
    int nrmb = 0;
    String[] rmember = new String[100];
    boolean showreqs = false;
    int blocknote = 0;
    int blockb = 0;
    boolean loadedcm = false;
    int ncln = 0;
    String[] clname = new String[20];
    String smsg = "";
    String sltit = "";
    boolean attachetoclan = false;
    boolean loadedlink = false;
    int loadedcars = -1;
    int loadedcar = 0;
    String ltit = "";
    String ldes = "";
    String lurl = "";
    boolean forcsel = false;
    String selcar = "";
    String selstage = "";
    String perry = "";
    int mrot = 0;
    int loadedstages = -1;
    int loadedstage = 0;
    CheckPoints cp;
    ContO[] bco;
    ContO[] co;
    int mouson = -1;


    int nclns = 0;
    String[] clanlo = new String[20];


    int ntab = 0;
    int loadednews = 0;
    int spos6 = 0;
    int lspos6 = 0;
    String[] newplayers = new String[]{"", "", "", "", ""};
    int[] nwarbs = new int[]{-1, -1, -1, -1, -1};
    String[] nwclan = new String[5];
    String[] nlclan = new String[5];
    String[] nwinob = new String[5];
    int[] nwinp = new int[5];
    int[] nlosp = new int[5];
    String[] nwtime = new String[5];

    int il = 0;
    String[] nttime = new String[300];
    String[] text = new String[300];
    int[] nln = new int[300];
    String[][][] link = new String[300][4][2];

    int maxclans = 1000;
    int loadwstat = 0;
    int ncc = 0;
    int champ = -1;
    int leadsby = 0;
    String[] conclan;
    int[] totp;
    int[] ord;
    int[] nvc;
    int[][] points;
    String[][] verclan;
    int eng = -1;
    int engo = 0;
    boolean frkl = false;
    float bgf;
    boolean bgup;
    int[] bgx;
    int flkn;
    int cur;
    int sdist;
    int scro;
    boolean donewc;
    boolean dosrch;
    boolean dorank;
    boolean doweb1;
    boolean doweb2;
    boolean dommsg;
    boolean donemsg;
    int doi;
    int ados;
    int lspos6w;
    long ntime;
    int loadwbgames;
    int warb;
    int gameturn;
    String warbnum;
    String vclan;
    String[] wbstages;
    int[] wbstage;
    int[] wblaps;
    int[] wbcars;
    int[] wbclass;
    int[] wbfix;
    String gameturndisp;
    int ascore;
    int vscore;
    String lwbwinner;
    int underc = 0;
    boolean canredo;

    public void dome(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, Control paramControl) {
        boolean bool1 = false;
        boolean bool2 = false;
        this.dommsg = false;
        this.dorank = false;
        this.donewc = false;
        this.dosrch = false;
        this.doweb1 = false;
        this.doweb2 = false;
        if (this.open == 0) {
            boolean bool = false;
            if (this.lg.nmsgs == 0 && this.lg.nfreq == 0 && this.lg.nconf == 0 && this.lg.ncreq == 0 && this.lg.clanapv.equals("")) {
                if (paramInt3 > 425 && paramInt3 < 450 && paramInt2 < 568 && paramInt2 > 232) bool = true;
                int[] arrayOfInt1 = {0, 9, 232, 250, 550, 568, 791, 800};
                int[] arrayOfInt2 = {452, 443, 443, 425, 425, 443, 443, 452};
                if (bool) {
                    this.rd.setColor(color2k(255, 255, 255));
                } else {
                    this.rd.setColor(new Color(207, 177, 110));
                }
                this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 8);
                this.rd.setColor(new Color(103, 88, 55));
                this.rd.drawPolygon(arrayOfInt1, arrayOfInt2, 8);
                this.rd.drawImage(this.xt.dome, 311, 430, (ImageObserver) null);
            } else {
                String str = "You have ";
                if (!this.lg.clanapv.equals("")) {
                    str = str + "been approved for a clan membership";
                    if (this.lg.nmsgs != 0 || this.lg.nfreq != 0 || this.lg.nconf != 0) str = str + "! + You have ";
                }
                if (this.lg.ncreq != 0) {
                    str = str + "" + this.lg.ncreq + " clan membership requests";
                    if (this.lg.nmsgs != 0 || this.lg.nfreq != 0 || this.lg.nconf != 0) str = str + "! + You have ";
                }
                if (this.lg.nmsgs != 0) {
                    str = str + "new interactions";
                    if (this.lg.fclan > 0 && this.lg.fplayer > 0) {
                        String str1 = "", str2 = "";
                        if (this.lg.fplayer > 1) str1 = "s";
                        if (this.lg.fclan > 1) str2 = "s";
                        str = str + " from " + this.lg.fplayer + " player" + str1 + " & " + this.lg.fclan + " clan" + str2 + "";
                    } else {
                        if (this.lg.fclan == 1) str = str + " from 1 clan";
                        if (this.lg.fclan > 1) str = str + " from " + this.lg.fclan + " clans";
                        if (this.lg.fplayer == 1) str = str + " from 1 player";
                        if (this.lg.fplayer > 1) str = str + " from " + this.lg.fplayer + " players";
                        if (this.lg.fclan == 0 && this.lg.fplayer == 0) str = str + " from your clan's discussion";
                    }
                    if (this.lg.nfreq != 0 && this.lg.nconf != 0) {
                        str = str + ", ";
                    } else {
                        if (this.lg.nfreq != 0) str = str + " and ";
                        if (this.lg.nconf != 0) str = str + " and ";
                    }
                }
                if (this.lg.nfreq != 0) {
                    str = str + "" + this.lg.nfreq + " friend request";
                    if (this.lg.nfreq > 1) str = str + "s";
                    if (this.lg.nconf != 0) str = str + " and ";
                }
                if (this.lg.nconf != 0) {
                    str = str + "" + this.lg.nconf + " friend confirmation";
                    if (this.lg.nconf > 1) str = str + "s";
                }
                str = str + "!";
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                int i = 0;
                if (this.ftm.stringWidth(str) > 280) i = (this.ftm.stringWidth(str) - 280) / 2;
                if (paramInt3 > 425 && paramInt3 < 450 && paramInt2 < 568 + i && paramInt2 > 232 - i) bool = true;
                int[] arrayOfInt1 = {0, 9, 232 - i, 250 - i, 550 + i, 568 + i, 791, 800};
                int[] arrayOfInt2 = {452, 443, 443, 425, 425, 443, 443, 452};
                if (bool) {
                    this.rd.setColor(color2k(255, 255, 255));
                } else {
                    this.rd.setColor(new Color(207, 177, 110));
                }
                this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 8);
                this.rd.setColor(new Color(103, 88, 55));
                this.rd.drawPolygon(arrayOfInt1, arrayOfInt2, 8);
                if (this.flkn % 3 == 0) {
                    this.rd.setColor(new Color(60, 30, 0));
                } else {
                    this.rd.setColor(new Color(0, 100, 0));
                }
                this.rd.drawString(str, 400 - this.ftm.stringWidth(str) / 2, 442);
                if (this.flkn < 33) this.flkn++;
            }
            if (bool && paramBoolean && paramInt1 < 2) {
                this.open = 2;
                this.upo = true;
                if (this.lg.nmsgs != 0) {
                    this.tab = 2;
                    if (this.lg.fplayer > 0) {
                        this.itab = 0;
                    } else if (this.lg.fclan > 0) {
                        this.itab = 1;
                    } else {
                        this.itab = 2;
                    }
                    this.litab = -1;
                }
                if (!this.lg.clanapv.equals("")) {
                    this.claname = this.lg.clanapv;
                    this.loadedc = false;
                    this.spos5 = 0;
                    this.lspos5 = 0;
                    this.cfase = 3;
                    this.tab = 3;
                    this.ctab = 0;
                }
                if (this.lg.ncreq != 0) {
                    this.claname = this.xt.clan;
                    this.loadedc = false;
                    this.spos5 = 0;
                    this.lspos5 = 0;
                    this.cfase = 3;
                    this.tab = 3;
                    this.ctab = 0;
                }
                if (this.lg.nfreq != 0 || this.lg.nconf != 0) this.ptab = 1;
            }
            if (this.xt.onviewpro) {
                this.proname = this.cd.viewname;
                this.open = 2;
                this.upo = true;
                this.tab = 1;
                this.xt.onviewpro = false;
            }
        } else if (this.flkn != 0) {
            this.flkn = 0;
        }
        if (this.open >= 2 && this.open < 452) {
            int[] arrayOfInt1 = {0, 0, 9, 232, 250, 550, 568, 791, 800, 800};
            int[] arrayOfInt2 = {902 - this.open, 452 - this.open, 443 - this.open, 443 - this.open, 425 - this.open, 425 - this.open, 443 - this.open, 443 - this.open, 452 - this.open, 902 - this.open};
            float f = (this.open - 2.0F) / 450.0F;
            int i = (int) (255.0F * (1.0F - f) + 216.0F * f);
            if (i > 255) i = 255;
            if (i < 0) i = 0;
            int j = (int) (243.0F * (1.0F - f) + 179.0F * f);
            if (j > 255) j = 255;
            if (j < 0) j = 0;
            int k = (int) (179.0F * (1.0F - f) + 100.0F * f);
            if (k > 255) k = 255;
            if (k < 0) k = 0;
            this.rd.setColor(new Color(i, j, k));
            this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 10);
            this.rd.drawImage(this.xt.dome, 311, 430 - this.open, (ImageObserver) null);
            if (this.upo) {
                this.open += 45;
            } else {
                this.open -= 45;
            }
            this.gs.hidefields();
            if (this.open == 452) {
                this.gs.setCursor(new Cursor(0));
                this.npo = -1;
                this.updatec = -1;
                this.domon = true;
                this.connector = new Thread(this);
                this.connector.start();
            }
        }
        if (this.open == 452) if (this.xt.warning == 0 || this.xt.warning == 210) {
            this.cur = 0;
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
            this.rd.fillRect(0, 0, 800, 450);
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
            this.rd.drawImage(this.xt.bgmain, this.bgx[0], 0, (ImageObserver) null);
            this.rd.drawImage(this.xt.bgmain, this.bgx[1], 0, (ImageObserver) null);
            this.rd.drawImage(this.xt.bgmain, this.bgx[2], 0, (ImageObserver) null);
            this.rd.drawImage(this.xt.bgmain, this.bgx[0], 400, (ImageObserver) null);
            this.rd.drawImage(this.xt.bgmain, this.bgx[1], 400, (ImageObserver) null);
            this.rd.drawImage(this.xt.bgmain, this.bgx[2], 400, (ImageObserver) null);
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.1F));
            this.rd.drawImage(this.xt.bggo, 0, 0, (ImageObserver) null);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            int m;
            for (m = 0; m < 3; ) {
                this.bgx[m] = this.bgx[m] - 5;
                if (this.bgx[m] <= -670) this.bgx[m] = 1340;
                m++;
            }
            if (drawbutton(this.xt.exit, 755, 17, paramInt2, paramInt3, paramBoolean) || paramInt1 >= 2) {
                this.open = 450;
                this.upo = false;
                this.domon = false;
                onexit();
            }
            this.sdist = 0;
            this.scro = 0;
            if (this.domon) {
                if (this.tab == 0) {
                    this.rd.setColor(color2k(230, 230, 230));
                    this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
                    if (this.updatec != -1) {
                        String[] arrayOfString1, arrayOfString2, arrayOfString3;
                        boolean[] arrayOfBoolean;
                        byte b1;
                        for (arrayOfString1 = new String[42], arrayOfString2 = new String[42], arrayOfString3 = new String[42], arrayOfBoolean = new boolean[42], b1 = 0; b1 < 42; ) {
                            arrayOfString1[b1] = "";
                            arrayOfString2[b1] = "";
                            arrayOfString3[b1] = "";
                            arrayOfBoolean[b1] = false;
                            b1++;
                        }
                        b1 = 0;
                        this.rd.setFont(new Font("Tahoma", 0, 11));
                        this.ftm = this.rd.getFontMetrics();
                        for (byte b2 = 0; b2 < 21; ) {
                            byte b5;
                            byte b6;
                            byte b7;
                            byte b8;
                            byte b9;
                            for (arrayOfString1[b1] = "", arrayOfString2[b1] = this.cnames[b2], arrayOfString3[b1] = this.ctime[b2], b5 = 0, b6 = 0, b7 = 0, b8 = 0, b9 = 0; b5 < this.sentn[b2].length(); ) {
                                String str1 = "" + this.sentn[b2].charAt(b5);
                                if (str1.equals(" ")) {
                                    b6 = b7;
                                    b8 = b5;
                                    b9++;
                                } else {
                                    b9 = 0;
                                }
                                if (b9 <= 1) {
                                    arrayOfString1[b1] = arrayOfString1[b1] + str1;
                                    b7++;
                                    if (this.ftm.stringWidth(arrayOfString1[b1]) > 469) if (b6 != 0) {
                                        arrayOfString1[b1] = arrayOfString1[b1].substring(0, b6);
                                        if (b1 == 41) {
                                            for (byte b = 0; b < 41; ) {
                                                arrayOfString1[b] = arrayOfString1[b + 1];
                                                arrayOfString2[b] = arrayOfString2[b + 1];
                                                arrayOfString3[b] = arrayOfString3[b + 1];
                                                arrayOfBoolean[b] = arrayOfBoolean[b + 1];
                                                b++;
                                            }
                                            arrayOfString1[b1] = "";
                                            arrayOfBoolean[b1] = true;
                                        } else {
                                            arrayOfString2[++b1] = this.cnames[b2];
                                            arrayOfString3[b1] = this.ctime[b2];
                                        }
                                        b5 = b8;
                                        b7 = 0;
                                        b6 = 0;
                                    } else {
                                        arrayOfString1[b1] = "";
                                        b7 = 0;
                                    }
                                }
                                b5++;
                            }
                            if (b1 == 41 && b2 != 20) {
                                for (byte b = 0; b < 41; ) {
                                    arrayOfString1[b] = arrayOfString1[b + 1];
                                    arrayOfString2[b] = arrayOfString2[b + 1];
                                    arrayOfString3[b] = arrayOfString3[b + 1];
                                    arrayOfBoolean[b] = arrayOfBoolean[b + 1];
                                    b++;
                                }
                            } else {
                                b1++;
                            }
                            b2++;
                        }
                        String str;
                        byte b3, b4;
                        for (str = "", b3 = b1, b4 = 0; b4 < b1; ) {
                            if (!str.equals(arrayOfString2[b4])) {
                                if (b4 != 0) b3++;
                                str = arrayOfString2[b4];
                            }
                            b4++;
                        }
                        this.sdist = (int) ((b3 - 21.5F) * 15.0F);
                        if (this.sdist < 0) this.sdist = 0;
                        this.scro = (int) (this.spos2 / 275.0F * this.sdist);
                        for (b3 = 0, str = "", b4 = 0; b4 <= b1; ) {
                            if (b4 != b1) {
                                if (!str.equals(arrayOfString2[b4])) {
                                    if (b4 != 0) {
                                        if (b3 * 15 - this.scro > -20 && b3 * 15 - this.scro < 345) {
                                            this.rd.setFont(new Font("Tahoma", 0, 11));
                                            this.rd.setColor(color2k(125, 125, 125));
                                            this.rd.drawString(arrayOfString3[b4 - 1], 297, 82 + b3 * 15 - this.scro);
                                        }
                                        b3++;
                                    }
                                    if (b3 * 15 - this.scro > -20 && b3 * 15 - this.scro < 345) {
                                        this.rd.setFont(new Font("Tahoma", 1, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.drawString(arrayOfString2[b4] + ":", 292 - this.ftm.stringWidth(arrayOfString2[b4] + ":"), 82 + b3 * 15 - this.scro);
                                    }
                                    str = arrayOfString2[b4];
                                }
                                if (arrayOfBoolean[b4] && b4 == 0 && arrayOfString1[b4].indexOf(" ") != -1)
                                    arrayOfString1[b4] = "..." + arrayOfString1[b4].substring(arrayOfString1[b4].indexOf(" "), arrayOfString1[b4].length()) + "";
                                if (b3 * 15 - this.scro > -20 && b3 * 15 - this.scro < 345) {
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString(arrayOfString1[b4], 297, 82 + b3 * 15 - this.scro);
                                }
                                b3++;
                            } else if (b3 * 15 - this.scro > -20 && b3 * 15 - this.scro < 345) {
                                this.rd.setFont(new Font("Tahoma", 0, 11));
                                this.rd.setColor(color2k(125, 125, 125));
                                this.rd.drawString(arrayOfString3[b4 - 1], 297, 82 + b3 * 15 - this.scro);
                            }
                            b4++;
                        }
                    } else {
                        this.sdist = 0;
                        this.scro = 0;
                        this.spos2 = 275;
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Tahoma", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Loading chat...", 498 - this.ftm.stringWidth("Loading chat...") / 2, 220);
                    }
                    this.rd.setColor(color2k(205, 205, 205));
                    this.rd.fillRect(207, 46, 582, 25);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.rd.setColor(color2k(40, 40, 40));
                    this.rd.drawString("Global Chat", 213, 62);
                    this.rd.setColor(color2k(150, 150, 150));
                    this.rd.drawLine(207, 68, 770, 68);
                    this.rd.setColor(color2k(205, 205, 205));
                    this.rd.fillRect(207, 411, 582, 28);
                    this.rd.setColor(color2k(150, 150, 150));
                    this.rd.drawLine(207, 413, 770, 413);
                    this.rd.setColor(color2k(205, 205, 205));
                    this.rd.fillRect(772, 88, 17, 306);
                    this.rd.setColor(color2k(205, 205, 205));
                    this.rd.fillRect(203, 46, 4, 393);
                    bool1 = true;
                    if ((stringbutton(this.rd, "Send Message", 731, 430, 3, paramInt2, paramInt3, paramBoolean, 0, 0) || paramControl.enter) && !this.gs.cmsg.getText().equals("Type here...") && !this.gs.cmsg.getText().equals("") && this.xt.acexp != -3) {
                        String str = this.gs.cmsg.getText().replace('|', ':');
                        if (str.toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) != -1) str = " ";
                        if (!this.xt.msgcheck(str) && this.updatec > -12) {
                            for (byte b = 0; b < 20; ) {
                                this.sentn[b] = this.sentn[b + 1];
                                this.cnames[b] = this.cnames[b + 1];
                                this.ctime[b] = this.ctime[b + 1];
                                b++;
                            }
                            this.sentn[20] = str;
                            this.cnames[20] = this.xt.nickname;
                            this.ctime[20] = "- just now";
                            if (this.updatec > -11) {
                                this.updatec = -11;
                            } else {
                                this.updatec--;
                            }
                            this.spos2 = 275;
                        } else {
                            this.xt.warning++;
                        }
                        this.gs.cmsg.setText("");
                        paramControl.enter = false;
                    }
                    if (this.mscro2 == 831 || this.sdist == 0) {
                        if (this.sdist == 0) {
                            this.rd.setColor(color2k(205, 205, 205));
                        } else {
                            this.rd.setColor(color2k(215, 215, 215));
                        }
                        this.rd.fillRect(772, 71, 17, 17);
                    } else {
                        this.rd.setColor(color2k(220, 220, 220));
                        this.rd.fill3DRect(772, 71, 17, 17, true);
                    }
                    if (this.sdist != 0) this.rd.drawImage(this.xt.asu, 777, 77, (ImageObserver) null);
                    if (this.mscro2 == 832 || this.sdist == 0) {
                        if (this.sdist == 0) {
                            this.rd.setColor(color2k(205, 205, 205));
                        } else {
                            this.rd.setColor(color2k(215, 215, 215));
                        }
                        this.rd.fillRect(772, 394, 17, 17);
                    } else {
                        this.rd.setColor(color2k(220, 220, 220));
                        this.rd.fill3DRect(772, 394, 17, 17, true);
                    }
                    if (this.sdist != 0) this.rd.drawImage(this.xt.asd, 777, 401, (ImageObserver) null);
                    if (this.sdist != 0) {
                        if (this.lspos2 != this.spos2) {
                            this.rd.setColor(color2k(215, 215, 215));
                            this.rd.fillRect(772, 88 + this.spos2, 17, 31);
                        } else {
                            if (this.mscro2 == 831) this.rd.setColor(color2k(215, 215, 215));
                            this.rd.fill3DRect(772, 88 + this.spos2, 17, 31, true);
                        }
                        this.rd.setColor(color2k(150, 150, 150));
                        this.rd.drawLine(777, 101 + this.spos2, 783, 101 + this.spos2);
                        this.rd.drawLine(777, 103 + this.spos2, 783, 103 + this.spos2);
                        this.rd.drawLine(777, 105 + this.spos2, 783, 105 + this.spos2);
                        if (this.mscro2 > 800 && this.lspos2 != this.spos2) this.lspos2 = this.spos2;
                        if (paramBoolean) {
                            if (this.mscro2 == 825 && paramInt2 > 772 && paramInt2 < 789 && paramInt3 > 88 + this.spos2 && paramInt3 < this.spos2 + 119)
                                this.mscro2 = paramInt3 - this.spos2;
                            if (this.mscro2 == 825 && paramInt2 > 770 && paramInt2 < 791 && paramInt3 > 69 && paramInt3 < 90)
                                this.mscro2 = 831;
                            if (this.mscro2 == 825 && paramInt2 > 770 && paramInt2 < 791 && paramInt3 > 392 && paramInt3 < 413)
                                this.mscro2 = 832;
                            if (this.mscro2 == 825 && paramInt2 > 772 && paramInt2 < 789 && paramInt3 > 88 && paramInt3 < 394) {
                                this.mscro2 = 103;
                                this.spos2 = paramInt3 - this.mscro2;
                            }
                            m = 2670 / this.sdist;
                            if (m < 1) m = 1;
                            if (this.mscro2 == 831) {
                                this.spos2 -= m;
                                if (this.spos2 > 275) this.spos2 = 275;
                                if (this.spos2 < 0) this.spos2 = 0;
                                this.lspos2 = this.spos2;
                            }
                            if (this.mscro2 == 832) {
                                this.spos2 += m;
                                if (this.spos2 > 275) this.spos2 = 275;
                                if (this.spos2 < 0) this.spos2 = 0;
                                this.lspos2 = this.spos2;
                            }
                            if (this.mscro2 < 800) {
                                this.spos2 = paramInt3 - this.mscro2;
                                if (this.spos2 > 275) this.spos2 = 275;
                                if (this.spos2 < 0) this.spos2 = 0;
                            }
                            if (this.mscro2 == 825) this.mscro2 = 925;
                        } else if (this.mscro2 != 825) {
                            this.mscro2 = 825;
                        }
                    }
                }
                if (this.tab == 1) {
                    this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                    this.rd.setColor(new Color(255, 255, 255));
                    this.rd.fillRoundRect(207, 45, 577, 394, 20, 20);
                    this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawRoundRect(207, 45, 577, 394, 20, 20);
                    if (!this.flg) {
                        this.flk += 5;
                    } else {
                        this.flk -= 5;
                    }
                    if (this.flk >= 100) {
                        this.flk = 100;
                        this.flg = true;
                    }
                    if (this.flk <= 60) {
                        this.flk = 60;
                        this.flg = false;
                    }
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.setComposite(AlphaComposite.getInstance(3, this.flk / 100.0F));
                    m = 0;
                    if (this.protab == 2) {
                        if (this.proname.equals(this.xt.nickname)) {
                            this.rd.drawString("Your Stages", 227, 67);
                            m = 1;
                        } else {
                            this.rd.drawString("" + this.proname + "'s", 227, 67);
                            this.rd.drawString("Stages", 227, 84);
                        }
                        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        this.gs.proitem.move(496 - this.gs.proitem.getWidth() / 2, 60);
                        this.gs.proitem.show = true;
                        if (stringbutton(this.rd, "< Back to Profile", 715, 76, 1, paramInt2, paramInt3, paramBoolean, 0, 0)) {
                            this.protab = 0;
                            this.gs.proitem.show = false;
                            this.addstage = 0;
                        }
                        if (this.gs.proitem.sel != 0) {
                            if (this.gs.proitem.getSelectedItem().equals(this.loadpstage)) {
                                if (this.loadedpstage) {
                                    this.m.trk = 4;
                                    this.m.ih = -10;
                                    this.m.iw = -10;
                                    this.m.h = 320;
                                    this.m.w = 580;
                                    this.m.cx = 280;
                                    this.m.cy = 150;
                                    this.m.aroundtrack(this.cp);
                                    this.rdo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                                    this.m.d(this.rdo);
                                    byte b1;
                                    int[] arrayOfInt3;
                                    byte b2;
                                    for (b1 = 0, arrayOfInt3 = new int[1000], b2 = 0; b2 < this.gs.nob; ) {
                                        if ((this.co[b2]).dist != 0) {
                                            arrayOfInt3[b1] = b2;
                                            b1++;
                                        } else {
                                            this.co[b2].d(this.rdo);
                                        }
                                        b2++;
                                    }
                                    int arrayOfInt4[], i1;
                                    for (arrayOfInt4 = new int[b1], i1 = 0; i1 < b1; ) {
                                        arrayOfInt4[i1] = 0;
                                        i1++;
                                    }
                                    for (i1 = 0; i1 < b1; ) {
                                        for (int i3 = i1 + 1; i3 < b1; ) {
                                            if ((this.co[arrayOfInt3[i1]]).dist != (this.co[arrayOfInt3[i3]]).dist) {
                                                if ((this.co[arrayOfInt3[i1]]).dist < (this.co[arrayOfInt3[i3]]).dist) {
                                                    arrayOfInt4[i1] = arrayOfInt4[i1] + 1;
                                                } else {
                                                    arrayOfInt4[i3] = arrayOfInt4[i3] + 1;
                                                }
                                            } else if (i3 > i1) {
                                                arrayOfInt4[i1] = arrayOfInt4[i1] + 1;
                                            } else {
                                                arrayOfInt4[i3] = arrayOfInt4[i3] + 1;
                                            }
                                            i3++;
                                        }
                                        i1++;
                                    }
                                    for (i1 = 0; i1 < b1; ) {
                                        for (byte b = 0; b < b1; ) {
                                            if (arrayOfInt4[b] == i1) this.co[arrayOfInt3[b]].d(this.rdo);
                                            b++;
                                        }
                                        i1++;
                                    }
                                    this.rdo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                                    this.m.trk = 0;
                                    this.m.h = 450;
                                    this.m.w = 800;
                                    this.m.cx = 400;
                                    this.m.cy = 225;
                                    this.rdo.setComposite(AlphaComposite.getInstance(3, 0.5F));
                                    this.rdo.setColor(new Color(255, 255, 255));
                                    this.rdo.fillRoundRect(9, 44, 136, 39, 20, 20);
                                    this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                                    this.rdo.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rdo.getFontMetrics();
                                    this.rdo.setColor(new Color(0, 0, 0));
                                    this.rdo.drawString("Created/Published by", 17, 59);
                                    i1 = 17 + this.ftm.stringWidth("Created/Published by") / 2 - this.ftm.stringWidth(this.cp.maker) / 2;
                                    int i2 = i1 + this.ftm.stringWidth(this.cp.maker);
                                    this.rdo.drawString(this.cp.maker, i1, 74);
                                    this.rdo.drawLine(i1, 76, i2, 76);
                                    if (paramInt2 > i1 + 216 && paramInt2 < i2 + 216 && paramInt3 > 154 && paramInt3 < 168) {
                                        this.cur = 12;
                                        if (paramBoolean) {
                                            this.tab = 1;
                                            if (!this.proname.equals(this.cp.maker)) {
                                                this.proname = this.cp.maker;
                                                this.loadedp = false;
                                                onexitpro();
                                            }
                                        }
                                    }
                                    if (this.gs.proitem.getSelectedIndex() != this.gs.proitem.no - 1 && stringbutton(this.rdo, " Next > ", 510, 200, -3, paramInt2, paramInt3, (paramBoolean && !this.gs.openm), 216, 92))
                                        this.gs.proitem.sel++;
                                    if (this.gs.proitem.getSelectedIndex() != 1 && stringbutton(this.rdo, " < Prev ", 50, 200, -3, paramInt2, paramInt3, (paramBoolean && !this.gs.openm), 216, 92))
                                        this.gs.proitem.sel--;
                                    if (this.cp.pubt > 0) {
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.setColor(new Color(0, 0, 0));
                                        if (this.addstage == 2) {
                                            this.rd.drawString("Adding Stage...", 496 - this.ftm.stringWidth("Adding Stage...") / 2, 419);
                                            if (this.cd.staction == 0) this.addstage = 3;
                                            if (this.cd.staction == -2) this.addstage = 4;
                                            if (this.cd.staction == -3) this.addstage = 5;
                                            if (this.cd.staction == -1) this.addstage = 6;
                                        }
                                        if (this.addstage == 3)
                                            this.rd.drawString("[" + this.cd.onstage + "] has been added to your stages!", 496 - this.ftm.stringWidth("[" + this.cd.onstage + "] has been added to your stages!") / 2, 419);
                                        if (this.addstage == 4)
                                            this.rd.drawString("You already have this stage.", 496 - this.ftm.stringWidth("You already have this stage.") / 2, 419);
                                        if (this.addstage == 5)
                                            this.rd.drawString("Cannot add more then 20 stages to your account!", 496 - this.ftm.stringWidth("Cannot add more then 20 stages to your account!") / 2, 419);
                                        if (this.addstage == 6)
                                            this.rd.drawString("Failed to add stage!  Unknown error, please try again later.", 496 - this.ftm.stringWidth("Failed to add stage!  Unknown error, please try again later.") / 2, 419);
                                        if (this.addstage == 1) {
                                            String str = "Upgrade to a full account to add custom stages!";
                                            int i3 = 496 - this.ftm.stringWidth(str) / 2, i4 = i3 + this.ftm.stringWidth(str);
                                            this.rd.drawString(str, i3, 419);
                                            if (this.waitlink != -1) this.rd.drawLine(i3, 435, i4, 435);
                                            if (paramInt2 > i3 && paramInt2 < i4 && paramInt3 > 421 && paramInt3 < 435) {
                                                if (this.waitlink != -1) this.cur = 12;
                                                if (paramBoolean && this.waitlink == 0) {
                                                    this.gs.editlink(this.xt.nickname, true);
                                                    this.waitlink = -1;
                                                }
                                            }
                                            if (this.waitlink > 0) this.waitlink--;
                                        }
                                        if (this.addstage == 0 && this.xt.drawcarb(true, null, " Add to My Stages ", 437, 401, paramInt2, paramInt3, (paramBoolean && this.blocknote == 0)))
                                            if (this.xt.logged) {
                                                this.cd.onstage = this.loadpstage;
                                                this.cd.staction = 2;
                                                this.cd.sparkstageaction();
                                                this.addstage = 2;
                                            } else {
                                                this.addstage = 1;
                                                this.waitlink = 20;
                                            }
                                    } else {
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.drawString("Private Stage", 496 - this.ftm.stringWidth("Private Stage") / 2, 419);
                                    }
                                } else {
                                    this.rdo.setColor(new Color(206, 171, 98));
                                    this.rdo.fillRect(0, 0, 560, 300);
                                    this.rdo.setColor(new Color(0, 0, 0));
                                    this.rdo.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rdo.getFontMetrics();
                                    this.rdo.drawString("Failed to load stage, try again later or try another stage...", 280 - this.ftm.stringWidth("Failed to load stage, try again later or try another stage...") / 2, 140);
                                }
                            } else {
                                this.rdo.setColor(new Color(206, 171, 98));
                                this.rdo.fillRect(0, 0, 560, 300);
                                this.rdo.setColor(new Color(0, 0, 0));
                                this.rdo.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rdo.getFontMetrics();
                                this.rdo.drawString("Loading stage, please wait...", 280 - this.ftm.stringWidth("Loading stage, please wait...") / 2, 140);
                            }
                        } else {
                            this.rdo.setColor(new Color(206, 171, 98));
                            this.rdo.fillRect(0, 0, 560, 300);
                        }
                        this.rd.drawImage(this.gImage, 216, 92, (ImageObserver) null);
                    }
                    if (this.protab == 0) {
                        if (this.proname.equals(this.xt.nickname)) {
                            this.rd.drawString("Your Profile", 232, 67);
                            m = 1;
                        } else {
                            this.rd.drawString("" + this.proname + "'s Profile", 232, 67);
                        }
                        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        if (this.loadedp) {
                            if (m == 0 && stringbutton(this.rd, "   My Profile   ", 715, 73, 1, paramInt2, paramInt3, paramBoolean, 0, 0)) {
                                this.proname = this.xt.nickname;
                                this.loadedp = false;
                                onexitpro();
                            }
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.setFont(new Font("Arial", 0, 11));
                            this.ftm = this.rd.getFontMetrics();
                            if (this.logol) {
                                drawl(this.rd, this.proname, 236, 101, true);
                            } else {
                                this.rd.drawString("No logo available", 296 - this.ftm.stringWidth("No logo available") / 2, 121);
                            }
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            String str = "Logo";
                            if (paramInt2 > 232 && paramInt2 < 359 && paramInt3 > 84 && paramInt3 < 134 && this.edit == 0 && m != 0) {
                                str = "Edit Logo";
                                this.rd.drawLine(238, 98, 238 + this.ftm.stringWidth(str), 98);
                                if (paramInt2 > 238 && paramInt2 < 238 + this.ftm.stringWidth(str) && paramInt3 > 85 && paramInt3 < 100) {
                                    this.cur = 12;
                                    if (paramBoolean) if (this.xt.logged) {
                                        this.edit = 1;
                                        this.msg = "Edit your Nickname's logo";
                                        this.flko = 0;
                                    } else {
                                        this.edit = 5;
                                    }
                                }
                            }
                            this.rd.drawString(str, 238, 97);
                            this.rd.drawLine(232, 84, 232, 134);
                            this.rd.drawLine(232, 84, 238 + this.ftm.stringWidth(str) + 2, 84);
                            this.rd.drawLine(238 + this.ftm.stringWidth(str) + 2, 84, 238 + this.ftm.stringWidth(str) + 15, 97);
                            this.rd.drawLine(238 + this.ftm.stringWidth(str) + 15, 97, 359, 97);
                            this.rd.drawLine(359, 97, 359, 134);
                            this.rd.drawLine(232, 134, 359, 134);
                            if (m != 0 && !this.xt.clan.equals(this.proclan)) this.proclan = this.xt.clan;
                            if (!this.proclan.equals("")) {
                                if (!drawl(this.rd, "#" + this.proclan + "#", 406, 101, true)) {
                                    this.rd.setFont(new Font("Arial", 1, 13));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString("" + this.proclan + "", 581 - this.ftm.stringWidth("" + this.proclan + "") / 2, 121);
                                }
                            } else {
                                this.rd.setFont(new Font("Arial", 0, 11));
                                this.ftm = this.rd.getFontMetrics();
                                if (m != 0) {
                                    this.rd.drawString("You have not joined a clan yet!", 416, 121);
                                    if (stringbutton(this.rd, "   Find a clan to join   ", 663, 121, 1, paramInt2, paramInt3, paramBoolean, 0, 0)) {
                                        this.tab = 3;
                                        this.cfase = 2;
                                        this.em = 1;
                                        this.msg = "Clan Search";
                                        this.smsg = "Listing clans with recent activity...";
                                        this.nclns = 0;
                                        this.spos5 = 0;
                                        this.lspos5 = 0;
                                        this.flko = 0;
                                    }
                                } else if (this.xt.clan.equals("")) {
                                    this.rd.drawString("Has not joined a clan yet", 581 - this.ftm.stringWidth("Has not joined a clan yet") / 2, 121);
                                } else {
                                    this.rd.drawString("Has not joined a clan yet", 430, 121);
                                    if (stringbutton(this.rd, " Invite to join your clan ", 657, 121, 1, paramInt2, paramInt3, paramBoolean, 0, 0)) {
                                        this.tab = 2;
                                        this.itab = 0;
                                        this.litab = -1;
                                        this.openc = 10;
                                        if (!this.opname.equals(this.proname)) {
                                            this.opname = this.proname;
                                            this.lastsub = "";
                                            this.readmsg = 1;
                                        }
                                        this.itemsel = 3;
                                        this.forcsel = true;
                                    }
                                }
                            }
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            str = "Clan";
                            if (paramInt2 > 402 && paramInt2 < 759 && paramInt3 > 84 && paramInt3 < 134 && !this.proclan.equals("") && this.edit == 0) {
                                str = "Clan :  " + this.proclan + "";
                                this.rd.drawLine(408, 98, 408 + this.ftm.stringWidth(str), 98);
                                if ((paramInt2 > 408 && paramInt2 < 408 + this.ftm.stringWidth(str) && paramInt3 > 85 && paramInt3 < 100) || (paramInt2 > 406 && paramInt2 < 756 && paramInt3 > 101 && paramInt3 < 131)) {
                                    this.cur = 12;
                                    if (paramBoolean) {
                                        if (!this.claname.equals(this.proclan)) {
                                            this.claname = this.proclan;
                                            this.loadedc = false;
                                        }
                                        this.spos5 = 0;
                                        this.lspos5 = 0;
                                        this.cfase = 3;
                                        this.tab = 3;
                                        this.ctab = 0;
                                    }
                                }
                            }
                            this.rd.drawString(str, 408, 97);
                            this.rd.drawLine(402, 84, 402, 134);
                            this.rd.drawLine(402, 84, 408 + this.ftm.stringWidth(str) + 2, 84);
                            this.rd.drawLine(408 + this.ftm.stringWidth(str) + 2, 84, 408 + this.ftm.stringWidth(str) + 15, 97);
                            this.rd.drawLine(408 + this.ftm.stringWidth(str) + 15, 97, 759, 97);
                            this.rd.drawLine(759, 97, 759, 134);
                            this.rd.drawLine(402, 134, 759, 134);
                            this.rd.setFont(new Font("Arial", 0, 11));
                            this.ftm = this.rd.getFontMetrics();
                            if (this.avatarl) {
                                this.rd.drawImage(this.avatar, 236, 161, (ImageObserver) null);
                            } else {
                                this.rd.drawString("No avatar available", 336 - this.ftm.stringWidth("No avatar available") / 2, 255);
                            }
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            str = "Avatar";
                            if (paramInt2 > 232 && paramInt2 < 439 && paramInt3 > 144 && paramInt3 < 364 && this.edit == 0 && m != 0) {
                                str = "Edit Avatar";
                                this.rd.drawLine(238, 158, 238 + this.ftm.stringWidth(str), 158);
                                if (paramInt2 > 238 && paramInt2 < 238 + this.ftm.stringWidth(str) && paramInt3 > 145 && paramInt3 < 160) {
                                    this.cur = 12;
                                    if (paramBoolean) if (this.xt.logged) {
                                        this.edit = 2;
                                        this.msg = "Edit your proflie avatar";
                                        this.flko = 0;
                                    } else {
                                        this.edit = 5;
                                    }
                                }
                            }
                            this.rd.drawString(str, 238, 157);
                            this.rd.drawLine(232, 144, 232, 364);
                            this.rd.drawLine(232, 144, 238 + this.ftm.stringWidth(str) + 2, 144);
                            this.rd.drawLine(238 + this.ftm.stringWidth(str) + 2, 144, 238 + this.ftm.stringWidth(str) + 15, 157);
                            this.rd.drawLine(238 + this.ftm.stringWidth(str) + 15, 157, 439, 157);
                            this.rd.drawLine(439, 157, 439, 364);
                            this.rd.drawLine(232, 364, 439, 364);
                            str = "About";
                            if (paramInt2 > 459 && paramInt2 < 759 && paramInt3 > 144 && paramInt3 < 364 && this.edit == 0 && m != 0) {
                                str = "Edit About";
                                this.rd.drawLine(465, 158, 465 + this.ftm.stringWidth(str), 158);
                                if (paramInt2 > 465 && paramInt2 < 465 + this.ftm.stringWidth(str) && paramInt3 > 145 && paramInt3 < 160) {
                                    this.cur = 12;
                                    if (paramBoolean) if (this.xt.logged) {
                                        this.edit = 3;
                                        this.msg = "";
                                        this.flko = 0;
                                        this.sentchange = 0;
                                        this.badlang = false;
                                    } else {
                                        this.edit = 5;
                                    }
                                }
                            }
                            this.rd.drawString(str, 465, 157);
                            this.rd.drawLine(459, 144, 459, 364);
                            this.rd.drawLine(459, 144, 465 + this.ftm.stringWidth(str) + 2, 144);
                            this.rd.drawLine(465 + this.ftm.stringWidth(str) + 2, 144, 465 + this.ftm.stringWidth(str) + 15, 157);
                            this.rd.drawLine(465 + this.ftm.stringWidth(str) + 15, 157, 759, 157);
                            this.rd.drawLine(759, 157, 759, 364);
                            this.rd.drawLine(459, 364, 759, 364);
                            if (this.nab != 0) {
                                this.rd.setFont(new Font("Tahoma", 1, 11));
                                char c = 'È';
                                if (this.nab == 2) c = 'À';
                                if (this.nab == 3) c = '¹';
                                for (byte b1 = 0; b1 < this.nab; ) {
                                    this.rd.drawString(this.aboutxt[b1], 469, c + b1 * 15);
                                    b1++;
                                }
                            } else {
                                this.rd.setFont(new Font("Arial", 0, 11));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString("No description available", 609 - this.ftm.stringWidth("No description available") / 2, 200);
                            }
                            this.rd.drawLine(489, 230, 729, 230);
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.drawString("Racing", 532 - this.ftm.stringWidth("Racing") / 2, 253);
                            this.rd.drawString("VS", 532 - this.ftm.stringWidth("VS") / 2, 270);
                            this.rd.drawString("Wasting", 532 - this.ftm.stringWidth("Wasting") / 2, 287);
                            float f1 = this.racing;
                            float f2 = this.wasting;
                            if (this.racing > 10 && this.racing > this.wasting) {
                                f1 = 10.0F;
                                f2 = this.wasting / this.racing / 10.0F;
                            }
                            if (this.wasting > 10 && this.wasting >= this.racing) {
                                f2 = 10.0F;
                                f1 = this.racing / this.wasting / 10.0F;
                            }
                            f1 *= 14.0F;
                            f2 *= 14.0F;
                            byte b;
                            for (b = 0; b < 5; b++) {
                                if (f1 != 0.0F) {
                                    this.rd.setColor(new Color(0, b * 50, 255));
                                    this.rd.drawLine(569, 245 + b, (int) (569.0F + f1), 245 + b);
                                    this.rd.drawLine(569, 254 - b, (int) (569.0F + f1), 254 - b);
                                }
                                if (f2 != 0.0F) {
                                    this.rd.setColor(new Color(255, b * 50, 0));
                                    this.rd.drawLine(569, 279 + b, (int) (569.0F + f2), 279 + b);
                                    this.rd.drawLine(569, 288 - b, (int) (569.0F + f2), 288 - b);
                                }
                            }
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRect(569, 244, 140, 11);
                            this.rd.drawRect(569, 278, 140, 11);
                            this.rd.drawLine(489, 304, 729, 304);
                            if (!this.themesong.equals("") && this.trackvol != 0) {
                                if (this.playt == 1)
                                    this.rd.drawString("Loading theme song, please wait...", 609 - this.ftm.stringWidth("Loading theme song, please wait...") / 2, 340);
                                if (this.playt == 0 && stringbutton(this.rd, " Play Theme Song ", 609, 340, 1, paramInt2, paramInt3, paramBoolean, 0, 0) && this.edit == 0)
                                    this.playt = 1;
                                if (this.playt == 2) {
                                    this.rd.drawString("Theme song playing...", 609 - this.ftm.stringWidth("Theme song playing...") / 2, 325);
                                    if (stringbutton(this.rd, " Stop ", 609, 350, 2, paramInt2, paramInt3, paramBoolean, 0, 0)) {
                                        this.xt.strack.unload();
                                        this.playt = 0;
                                    }
                                }
                            } else {
                                this.rd.setFont(new Font("Arial", 0, 11));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString("No theme song available", 609 - this.ftm.stringWidth("No theme song available") / 2, 340);
                            }
                            if (m == 0) if (this.sfreq == 0) {
                                this.rd.drawRect(232, 378, 527, 50);
                                b = 0;
                                for (byte b1 = 0; b1 < this.npf; ) {
                                    if (this.proname.toLowerCase().equals(this.fname[b1].toLowerCase())) {
                                        b = 1;
                                        break;
                                    }
                                    b1++;
                                }
                                if (b != 0) {
                                    if (stringbutton(this.rd, "    Un-friend    ", 313, 408, 1, paramInt2, paramInt3, paramBoolean, 0, 0))
                                        this.sfreq = 4;
                                } else if (stringbutton(this.rd, "   Add Friend   ", 313, 408, 1, paramInt2, paramInt3, paramBoolean, 0, 0)) {
                                    this.sfreq = 1;
                                }
                                if (stringbutton(this.rd, "   Send Message   ", 436, 408, 1, paramInt2, paramInt3, paramBoolean, 0, 0)) {
                                    this.tab = 2;
                                    this.openc = 10;
                                    this.itab = 0;
                                    this.litab = -1;
                                    if (!this.opname.equals(this.proname)) {
                                        this.opname = this.proname;
                                        this.lastsub = "";
                                        this.readmsg = 1;
                                    }
                                }
                                if (stringbutton(this.rd, "   View Cars   ", 558, 408, 1, paramInt2, paramInt3, paramBoolean, 0, 0)) {
                                    this.cd.viewname = this.proname;
                                    onexitpro();
                                    this.cd.action = 100;
                                    this.xt.cfase = 100;
                                    this.xt.onviewpro = true;
                                    this.xt.fase = 23;
                                }
                                if (stringbutton(this.rd, "   View Stages   ", 673, 408, 1, paramInt2, paramInt3, paramBoolean, 0, 0)) {
                                    this.protab = 2;
                                    this.loadpst = 0;
                                    this.gs.proitem.removeAll();
                                    this.gs.proitem.add(this.gs.rd, "Loading stages, please wait...");
                                }
                            } else {
                                this.rd.setColor(new Color(236, 215, 140));
                                this.rd.fillRect(232, 378, 527, 50);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawRect(232, 378, 527, 50);
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                if (this.sfreq == 1)
                                    this.rd.drawString("Sending a friend request to " + this.proname + ", please wait...", 495 - this.ftm.stringWidth("Sending a friend request to " + this.proname + ", please wait...") / 2, 408);
                                if (this.sfreq == 2) {
                                    this.rd.drawString("Friend request sent, waiting for " + this.proname + "'s approval.", 495 - this.ftm.stringWidth("Friend request sent, waiting for " + this.proname + "'s approval.") / 2, 408);
                                    if (stringbutton(this.rd, "  OK  ", 690, 408, 1, paramInt2, paramInt3, paramBoolean, 0, 0))
                                        this.sfreq = 0;
                                }
                                if (this.sfreq == 3) {
                                    this.rd.drawString("Failed to send friend request, please try again later.", 495 - this.ftm.stringWidth("Failed to send friend request, please try again later.") / 2, 408);
                                    if (stringbutton(this.rd, "  OK  ", 690, 408, 1, paramInt2, paramInt3, paramBoolean, 0, 0))
                                        this.sfreq = 0;
                                }
                                if (this.sfreq == 4)
                                    this.rd.drawString("Removing " + this.proname + " from firends, please wait...", 495 - this.ftm.stringWidth("Removing " + this.proname + " from firends, please wait...") / 2, 408);
                                if (this.sfreq == 5) {
                                    this.rd.drawString("You are no longer friends with " + this.proname + ".", 495 - this.ftm.stringWidth("You are no longer friends with " + this.proname + ".") / 2, 408);
                                    if (stringbutton(this.rd, "  OK  ", 690, 408, 1, paramInt2, paramInt3, paramBoolean, 0, 0))
                                        this.sfreq = 0;
                                }
                                if (this.sfreq == 6) {
                                    this.rd.drawString("Failed to remove friend, please try again later.", 495 - this.ftm.stringWidth("Failed to remove friend, please try again later.") / 2, 408);
                                    if (stringbutton(this.rd, "  OK  ", 690, 408, 1, paramInt2, paramInt3, paramBoolean, 0, 0))
                                        this.sfreq = 0;
                                }
                            }
                            if (this.edit == 1 || this.edit == 2) {
                                this.rd.setColor(new Color(244, 232, 204));
                                this.rd.fillRoundRect(265, 92, 460, 220, 20, 20);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawRoundRect(265, 92, 460, 220, 20, 20);
                                String[] arrayOfString = {"logo", "120x30", "4 : 1"};
                                if (this.edit == 2) {
                                    arrayOfString[0] = "avatar";
                                    arrayOfString[1] = "200x200";
                                    arrayOfString[2] = "1 : 1";
                                }
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                if (this.flko % 4 != 0 || this.flko == 0)
                                    this.rd.drawString(this.msg, 495 - this.ftm.stringWidth(this.msg) / 2, 115);
                                if (this.flko != 0) this.flko--;
                                this.rd.setFont(new Font("Arial", 0, 12));
                                this.rd.drawString("The " + arrayOfString[0] + " image is " + arrayOfString[1] + " pixels.", 275, 140);
                                this.rd.drawString("Any image uploaded will be resized to that width and height. For the best results", 275, 160);
                                this.rd.drawString("try to upload an image that is bigger or equal to " + arrayOfString[1] + " and has the scale of", 275, 180);
                                this.rd.drawString("[ " + arrayOfString[2] + " ]  in  [ Width : Height ].", 275, 200);
                                this.rd.drawString("Image uploaded must be less than 1MB and in the format of JPEG, GIF or PNG.", 275, 220);
                                if (this.upload == 0) {
                                    if (stringbutton(this.rd, "  Upload Image  ", 495, 250, 0, paramInt2, paramInt3, paramBoolean, 0, 0)) {
                                        FileDialog fileDialog = new FileDialog(new Frame(), "Upload Image");
                                        fileDialog.setMode(0);
                                        fileDialog.setVisible(true);
                                        this.filename = "" + fileDialog.getDirectory() + "" + fileDialog.getFile() + "";
                                        if (!this.filename.equals("nullnull")) this.upload = 1;
                                    }
                                } else {
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    if (this.upload == 1)
                                        this.rd.drawString("Checking image...", 495 - this.ftm.stringWidth("Checking image...") / 2, 250);
                                    if (this.upload == 2)
                                        this.rd.drawString("Authenticating...", 495 - this.ftm.stringWidth("Authenticating...") / 2, 250);
                                    if (this.upload == 3)
                                        this.rd.drawString("Uploading image :  " + this.perc + " %", 495 - this.ftm.stringWidth("Uploading image :  80 %") / 2, 250);
                                    if (this.upload == 4)
                                        this.rd.drawString("Creating image online...", 495 - this.ftm.stringWidth("Creating image online...") / 2, 250);
                                    if (this.upload == 5)
                                        this.rd.drawString("Done", 495 - this.ftm.stringWidth("Done") / 2, 250);
                                }
                                if (stringbutton(this.rd, " Cancel ", 495, 290, 2, paramInt2, paramInt3, paramBoolean, 0, 0))
                                    if (this.upload == 0) {
                                        this.edit = 0;
                                    } else {
                                        this.upload = 0;
                                    }
                            }
                            if (this.edit == 3) {
                                this.rd.setColor(new Color(244, 232, 204));
                                this.rd.fillRoundRect(265, 38, 460, 390, 20, 20);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawRoundRect(265, 38, 460, 390, 20, 20);
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString("Edit your about section", 495 - this.ftm.stringWidth("Edit your about section") / 2, 61);
                                this.rd.setFont(new Font("Arial", 0, 12));
                                if (!this.badlang) {
                                    this.rd.drawString("Type in a sentence that best describes you and your playing style in the game :", 275, 86);
                                } else {
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.rd.drawString("The sentence must not contain bad language!", 275, 86);
                                    this.rd.setFont(new Font("Arial", 0, 12));
                                }
                                bool2 = true;
                                this.rd.drawLine(315, 123, 675, 123);
                                this.rd.drawString("The ( Racing VS Wasting ) is comparison between your multiplayer wins by", 275, 146);
                                this.rd.drawString("racing versus wasting.", 275, 166);
                                this.rd.drawString("It does not in anyway signify if you are better or worse than another player!", 275, 186);
                                this.rd.drawString("It simply shows whether you have a tendency to win games by racing or by", 275, 206);
                                this.rd.drawString("wasting, it shows what you are better at.", 275, 226);
                                this.rd.drawLine(315, 241, 675, 241);
                                this.rd.drawString("Upload your very own theme song!", 275, 264);
                                this.rd.drawString("The theme song must be a Module Track that is in a zip file and less than 700KB.", 275, 284);
                                this.rd.drawString("You can find lots of Module Tracks at modarchive.org.", 275, 304);
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                if (this.uploadt == 0) {
                                    if (this.msg.equals("")) {
                                        if (!this.themesong.equals("") && this.trackvol != 0) {
                                            this.rd.drawString("Current Track : " + this.themesong + "", 495 - this.ftm.stringWidth("Current Track : " + this.themesong + "") / 2, 324);
                                        } else {
                                            this.rd.setFont(new Font("Arial", 0, 12));
                                            this.rd.drawString("[ No theme song uploaded... ]", 495 - this.ftm.stringWidth("[ No theme song uploaded... ]") / 2, 324);
                                        }
                                    } else {
                                        if (this.flko % 4 != 0 || this.flko == 0)
                                            this.rd.drawString(this.msg, 495 - this.ftm.stringWidth(this.msg) / 2, 324);
                                        if (this.flko != 0) this.flko--;
                                    }
                                    if (stringbutton(this.rd, "  Upload Track  ", 495, 354, 0, paramInt2, paramInt3, paramBoolean, 0, 0)) {
                                        FileDialog fileDialog = new FileDialog(new Frame(), "Upload Track");
                                        fileDialog.setMode(0);
                                        fileDialog.setFile("*.zip");
                                        fileDialog.setVisible(true);
                                        this.filename = "" + fileDialog.getDirectory() + "" + fileDialog.getFile() + "";
                                        if (!this.filename.equals("nullnull")) {
                                            this.trackname = fileDialog.getFile().substring(0, fileDialog.getFile().length() - 4);
                                            this.uploadt = 1;
                                        }
                                    }
                                } else {
                                    if (this.uploadt == 1)
                                        this.rd.drawString("Checking MOD Track...", 495 - this.ftm.stringWidth("Checking MOD Track...") / 2, 354);
                                    if (this.uploadt == 2)
                                        this.rd.drawString("Authenticating...", 495 - this.ftm.stringWidth("Authenticating...") / 2, 354);
                                    if (this.uploadt == 3)
                                        this.rd.drawString("Uploading track, please wait...", 495 - this.ftm.stringWidth("Uploading track, please wait...") / 2, 354);
                                    if (this.uploadt == 4)
                                        this.rd.drawString("Adding track to your profile...", 495 - this.ftm.stringWidth("Adding track to your profile...") / 2, 354);
                                    if (this.uploadt == 5)
                                        this.rd.drawString("Done", 495 - this.ftm.stringWidth("Done") / 2, 354);
                                }
                                this.rd.drawLine(315, 376, 675, 376);
                                if (stringbutton(this.rd, "        Done        ", 495, 407, 1, paramInt2, paramInt3, paramBoolean, 0, 0)) {
                                    this.edit = 0;
                                    if (this.sentchange == 1) {
                                        if (this.xt.msgcheck(this.sentance) || this.sentance.toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) != -1 || this.xt.acexp == -3) {
                                            this.edit = 3;
                                            this.sentchange = 0;
                                            this.sentance = "";
                                            this.gs.cmsg.setText(this.sentance);
                                            this.badlang = true;
                                        } else {
                                            this.sentchange = 2;
                                        }
                                        trunsent();
                                    }
                                }
                            }
                            if (this.edit == 5) {
                                this.rd.setColor(new Color(244, 232, 204));
                                this.rd.fillRoundRect(265, 187, 460, 125, 20, 20);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawRoundRect(265, 187, 460, 125, 20, 20);
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString("You need to upgrade your account to a full account to have a profile!", 495 - this.ftm.stringWidth("You need to upgrade your account to a full account to have a profile!") / 2, 209);
                                this.rd.setColor(new Color(206, 171, 98));
                                this.rd.fillRoundRect(405, 222, 180, 50, 20, 20);
                                if (drawbutton(this.xt.upgrade, 495, 247, paramInt2, paramInt3, paramBoolean))
                                    this.gs.editlink(this.xt.nickname, true);
                                if (stringbutton(this.rd, "  Cancel  ", 495, 297, 2, paramInt2, paramInt3, paramBoolean, 0, 0))
                                    this.edit = 0;
                            }
                        } else {
                            this.rd.drawString("Loading profile, please wait...", 495 - this.ftm.stringWidth("Loading profile, please wait...") / 2, 222);
                        }
                    }
                } else {
                    this.edit = 0;
                    this.uploadt = 0;
                    this.sentchange = 0;
                    this.underc = 0;
                    this.protab = 0;
                    if (this.gs.proitem.show) {
                        this.gs.proitem.show = false;
                        this.addstage = 0;
                    }
                }
                if (this.tab == 2) {
                    dotab2(paramInt2, paramInt3, paramBoolean);
                } else {
                    if (this.gs.sendtyp.isShowing()) this.gs.sendtyp.hide();
                    if (this.gs.senditem.isShowing()) this.gs.senditem.hide();
                    if (this.gs.datat.isShowing()) this.gs.datat.hide();
                    this.gs.ilaps.hide();
                    this.gs.icars.hide();
                    this.gs.sclass.hide();
                    this.gs.sfix.hide();
                }
                if (this.tab == 3) {
                    dotab3(paramInt2, paramInt3, paramBoolean);
                } else {
                    if (this.gs.clcars.isShowing()) this.gs.clcars.hide();
                    if (this.editc != 0) {
                        this.editc = 0;
                        if (this.gs.clanlev.isShowing()) this.gs.clanlev.hide();
                    }
                    if (this.cfase == 1) this.cfase = 0;
                }
                if (this.ptab == 0) if (this.npo != -1) {
                    this.sdist = (this.npo - 7) * 50;
                    if (this.sdist < 0) this.sdist = 0;
                    this.scro = (int) (this.spos / 345.0F * this.sdist);
                    for (m = 0; m < this.npo; m++) {
                        if (57 + 50 * m - this.scro > 0 && 57 + 50 * (m - 1) - this.scro < 438) {
                            boolean bool = false;
                            if (paramInt2 > 26 && paramInt2 < 146 && paramInt3 > 38 + 50 * m - this.scro && paramInt3 < 68 + 50 * m - this.scro && !this.onp && this.overit == 0) {
                                bool = true;
                                this.cur = 12;
                                if (paramBoolean) {
                                    this.tab = 1;
                                    if (!this.proname.equals(this.pname[m])) {
                                        this.proname = this.pname[m];
                                        this.loadedp = false;
                                        onexitpro();
                                    }
                                }
                            }
                            boolean bool3 = drawl(this.rd, this.pname[m], 26, 38 + 50 * m - this.scro, bool);
                            if (!bool || !bool3) {
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString(this.pname[m], 86 - this.ftm.stringWidth(this.pname[m]) / 2, 49 + 50 * m - this.scro);
                                this.rd.setFont(new Font("Arial", 1, 11));
                                this.ftm = this.rd.getFontMetrics();
                                String str = "Not in any room...";
                                if (this.pserver[m] >= 0 && this.pserver[m] <= 2 && this.proom[m] >= 0 && this.proom[m] <= 4) {
                                    str = "" + this.lg.snames[this.pserver[m]] + " :: Room " + (this.proom[m] + 1) + "";
                                    this.rd.setColor(new Color(49, 79, 0));
                                }
                                this.rd.drawString(str, 86 - this.ftm.stringWidth(str) / 2, 65 + 50 * m - this.scro);
                            }
                            this.rd.setColor(color2k(150, 150, 150));
                            this.rd.drawLine(5, 77 + 50 * m - this.scro, 167, 77 + 50 * m - this.scro);
                        }
                    }
                } else {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Loading players...", 86 - this.ftm.stringWidth("Loading players...") / 2, 200);
                }
                if (this.ptab == 1) if (this.npf >= 0) {
                    this.sdist = (this.npf - 7) * 50;
                    if (this.sdist < 0) this.sdist = 0;
                    this.scro = (int) (this.spos / 345.0F * this.sdist);
                    m = 0;
                    if (this.npf != 0) {
                        byte b;
                        for (b = 0; b < this.npf; b++) {
                            byte b1;
                            byte b2;
                            for (b1 = -1, b2 = 0; b2 < this.npo; ) {
                                if (this.pname[b2].toLowerCase().equals(this.fname[b].toLowerCase())) {
                                    b1 = b2;
                                    break;
                                }
                                b2++;
                            }
                            if (b1 != -1) {
                                if (57 + 50 * m - this.scro > 0 && 57 + 50 * (m - 1) - this.scro < 438) {
                                    b2 = 0;
                                    if (paramInt2 > 26 && paramInt2 < 146 && paramInt3 > 38 + 50 * m - this.scro && paramInt3 < 68 + 50 * m - this.scro && !this.onp && this.overit == 0 && this.freq <= 0) {
                                        b2 = 1;
                                        this.cur = 12;
                                        if (paramBoolean) {
                                            this.tab = 1;
                                            if (!this.proname.equals(this.fname[b])) {
                                                this.proname = this.fname[b];
                                                this.loadedp = false;
                                                onexitpro();
                                            }
                                        }
                                    }
                                    boolean bool = drawl(this.rd, this.fname[b], 26, 38 + 50 * m - this.scro, b2);
                                    if (b2 == 0 || !bool) {
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.drawString(this.fname[b], 86 - this.ftm.stringWidth(this.fname[b]) / 2, 49 + 50 * m - this.scro);
                                        this.rd.setFont(new Font("Arial", 1, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        String str = "Not in any room...";
                                        if (this.pserver[b1] >= 0 && this.pserver[b1] <= 2 && this.proom[b1] >= 0 && this.proom[b1] <= 4) {
                                            str = "" + this.lg.snames[this.pserver[b1]] + " :: Room " + (this.proom[b1] + 1) + "";
                                            this.rd.setColor(new Color(49, 79, 0));
                                        }
                                        this.rd.drawString(str, 86 - this.ftm.stringWidth(str) / 2, 65 + 50 * m - this.scro);
                                    }
                                    this.rd.setColor(color2k(150, 150, 150));
                                    this.rd.drawLine(5, 77 + 50 * m - this.scro, 167, 77 + 50 * m - this.scro);
                                }
                                m++;
                            }
                        }
                        for (b = 0; b < this.npf; b++) {
                            byte b1;
                            byte b2;
                            for (b1 = -1, b2 = 0; b2 < this.npo; ) {
                                if (this.pname[b2].toLowerCase().equals(this.fname[b].toLowerCase())) {
                                    b1 = b2;
                                    break;
                                }
                                b2++;
                            }
                            if (b1 == -1) {
                                if (57 + 50 * m - this.scro > 0 && 57 + 50 * (m - 1) - this.scro < 438) {
                                    b2 = 0;
                                    if (paramInt2 > 26 && paramInt2 < 146 && paramInt3 > 38 + 50 * m - this.scro && paramInt3 < 68 + 50 * m - this.scro && !this.onp && this.overit == 0 && this.freq <= 0) {
                                        b2 = 1;
                                        this.cur = 12;
                                        if (paramBoolean) {
                                            this.tab = 1;
                                            if (!this.proname.equals(this.fname[b])) {
                                                this.proname = this.fname[b];
                                                this.loadedp = false;
                                                onexitpro();
                                            }
                                        }
                                    }
                                    boolean bool = drawl(this.rd, this.fname[b], 26, 38 + 50 * m - this.scro, b2);
                                    if (b2 == 0 || !bool) {
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.drawString(this.fname[b], 86 - this.ftm.stringWidth(this.fname[b]) / 2, 49 + 50 * m - this.scro);
                                        this.rd.setFont(new Font("Arial", 0, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        String str = "Player Offline";
                                        this.rd.drawString(str, 86 - this.ftm.stringWidth(str) / 2, 65 + 50 * m - this.scro);
                                    }
                                    this.rd.setColor(color2k(150, 150, 150));
                                    this.rd.drawLine(5, 77 + 50 * m - this.scro, 167, 77 + 50 * m - this.scro);
                                }
                                m++;
                            }
                        }
                    } else {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("No friends added yet.", 86 - this.ftm.stringWidth("No friends added yet.") / 2, 200);
                    }
                    if (this.freq == 1) {
                        this.rd.setColor(new Color(236, 215, 140));
                        this.rd.fillRect(-10, 28, 200, 130);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRect(-10, 28, 200, 130);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Friend request from:", 86 - this.ftm.stringWidth("Friend request from:") / 2, 45);
                        this.rd.setColor(new Color(240, 222, 164));
                        this.rd.fillRect(26, 51, 119, 29);
                        if (!drawl(this.rd, this.freqname, 26, 51, true)) {
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawString(this.freqname, 86 - this.ftm.stringWidth(this.freqname) / 2, 70);
                            this.rd.setColor(color2k(150, 150, 150));
                            this.rd.drawRect(26, 51, 119, 29);
                        }
                        if (paramInt2 > 26 && paramInt2 < 146 && paramInt3 > 51 && paramInt3 < 81) {
                            this.cur = 12;
                            if (paramBoolean) {
                                this.tab = 1;
                                if (!this.proname.equals(this.freqname)) {
                                    this.proname = this.freqname;
                                    this.loadedp = false;
                                    onexitpro();
                                }
                            }
                        }
                        if (stringbutton(this.rd, "    Confirm    ", 86, 107, 0, paramInt2, paramInt3, paramBoolean, 0, 0))
                            this.freq = 2;
                        if (stringbutton(this.rd, "Cancel", 86, 140, 2, paramInt2, paramInt3, paramBoolean, 0, 0))
                            this.freq = 3;
                    }
                    if (this.freq == -1) {
                        this.rd.setColor(new Color(236, 215, 140));
                        this.rd.fillRect(-10, 28, 200, 25);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRect(-10, 28, 200, 25);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Failed to confirm friend!", 86 - this.ftm.stringWidth("Failed to confirm friend!") / 2, 45);
                        this.cntf--;
                        if (this.cntf <= 0) this.freq = 0;
                    }
                    if (this.freq == -2) {
                        this.rd.setColor(new Color(236, 215, 140));
                        this.rd.fillRect(-10, 28, 200, 25);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRect(-10, 28, 200, 25);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Failed to cancel request!", 86 - this.ftm.stringWidth("Failed to cancel request!") / 2, 45);
                        this.cntf--;
                        if (this.cntf <= 0) this.freq = 0;
                    }
                    if (this.freq == 2) {
                        this.rd.setColor(new Color(236, 215, 140));
                        this.rd.fillRect(-10, 28, 200, 25);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRect(-10, 28, 200, 25);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Confirming friend...", 86 - this.ftm.stringWidth("Confirming friend...") / 2, 45);
                    }
                    if (this.freq == 3) {
                        this.rd.setColor(new Color(236, 215, 140));
                        this.rd.fillRect(-10, 28, 200, 25);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRect(-10, 28, 200, 25);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Canceling...", 86 - this.ftm.stringWidth("Canceling...") / 2, 45);
                    }
                    if (this.freq == 6) {
                        this.rd.setColor(new Color(236, 215, 140));
                        this.rd.fillRect(-10, 28, 200, 61 + this.ncnf * 35);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRect(-10, 28, 200, 61 + this.ncnf * 35);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Friend Confirmation(s):", 86 - this.ftm.stringWidth("Friend Confirmation(s):") / 2, 45);
                        for (byte b = 0; b < this.ncnf; b++) {
                            this.rd.setColor(new Color(240, 222, 164));
                            this.rd.fillRect(26, 51 + 35 * b, 119, 29);
                            if (!drawl(this.rd, this.cnfname[b], 26, 51 + 35 * b, true)) {
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString(this.cnfname[b], 86 - this.ftm.stringWidth(this.cnfname[b]) / 2, 70 + 35 * b);
                                this.rd.setColor(color2k(150, 150, 150));
                                this.rd.drawRect(26, 51 + 35 * b, 119, 29);
                            }
                            if (paramInt2 > 26 && paramInt2 < 146 && paramInt3 > 51 + 35 * b && paramInt3 < 81 + 35 * b) {
                                this.cur = 12;
                                if (paramBoolean) {
                                    this.tab = 1;
                                    if (!this.proname.equals(this.cnfname[b])) {
                                        this.proname = this.cnfname[b];
                                        this.loadedp = false;
                                        onexitpro();
                                    }
                                }
                            }
                        }
                        if (stringbutton(this.rd, "  OK  ", 86, 107 + 35 * (this.ncnf - 1), 0, paramInt2, paramInt3, paramBoolean, 0, 0))
                            this.freq = -6;
                    }
                } else {
                    if (this.npf == -1) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Loading friends...", 86 - this.ftm.stringWidth("Loading friends...") / 2, 200);
                    }
                    if (this.npf == -2) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Failed to load friends!", 86 - this.ftm.stringWidth("Failed to load friends!") / 2, 200);
                    }
                }
                if (this.ptab == 2) if (this.xt.clan.equals("")) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Not in a Clan", 86 - this.ftm.stringWidth("Not in a Clan") / 2, 200);
                    this.rd.setFont(new Font("Arial", 0, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("You haven't joined and clan yet.", 86 - this.ftm.stringWidth("You haven't joined and clan yet.") / 2, 220);
                } else if (this.loadedcm) {
                    this.sdist = (this.ncln - 7) * 50;
                    if (this.sdist < 0) this.sdist = 0;
                    this.scro = (int) (this.spos / 345.0F * this.sdist);
                    m = 0;
                    byte b;
                    for (b = 0; b < this.ncln; b++) {
                        byte b1;
                        byte b2;
                        for (b1 = -1, b2 = 0; b2 < this.npo; ) {
                            if (this.pname[b2].toLowerCase().equals(this.clname[b].toLowerCase())) {
                                b1 = b2;
                                break;
                            }
                            b2++;
                        }
                        if (b1 != -1) {
                            if (57 + 50 * m - this.scro > 0 && 57 + 50 * (m - 1) - this.scro < 438) {
                                b2 = 0;
                                if (paramInt2 > 26 && paramInt2 < 146 && paramInt3 > 38 + 50 * m - this.scro && paramInt3 < 68 + 50 * m - this.scro && !this.onp && this.overit == 0 && this.freq <= 0) {
                                    b2 = 1;
                                    this.cur = 12;
                                    if (paramBoolean) {
                                        this.tab = 1;
                                        if (!this.proname.equals(this.clname[b])) {
                                            this.proname = this.clname[b];
                                            this.loadedp = false;
                                            onexitpro();
                                        }
                                    }
                                }
                                boolean bool = drawl(this.rd, this.clname[b], 26, 38 + 50 * m - this.scro, b2);
                                if (b2 == 0 || !bool) {
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString(this.clname[b], 86 - this.ftm.stringWidth(this.clname[b]) / 2, 49 + 50 * m - this.scro);
                                    this.rd.setFont(new Font("Arial", 1, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    String str = "Not in any room...";
                                    if (this.pserver[b1] >= 0 && this.pserver[b1] <= 2 && this.proom[b1] >= 0 && this.proom[b1] <= 4) {
                                        str = "" + this.lg.snames[this.pserver[b1]] + " :: Room " + (this.proom[b1] + 1) + "";
                                        this.rd.setColor(new Color(49, 79, 0));
                                    }
                                    this.rd.drawString(str, 86 - this.ftm.stringWidth(str) / 2, 65 + 50 * m - this.scro);
                                }
                                this.rd.setColor(color2k(150, 150, 150));
                                this.rd.drawLine(5, 77 + 50 * m - this.scro, 167, 77 + 50 * m - this.scro);
                            }
                            m++;
                        }
                    }
                    for (b = 0; b < this.ncln; b++) {
                        byte b1;
                        byte b2;
                        for (b1 = -1, b2 = 0; b2 < this.npo; ) {
                            if (this.pname[b2].toLowerCase().equals(this.clname[b].toLowerCase())) {
                                b1 = b2;
                                break;
                            }
                            b2++;
                        }
                        if (b1 == -1) {
                            if (57 + 50 * m - this.scro > 0 && 57 + 50 * (m - 1) - this.scro < 438) {
                                b2 = 0;
                                if (paramInt2 > 26 && paramInt2 < 146 && paramInt3 > 38 + 50 * m - this.scro && paramInt3 < 68 + 50 * m - this.scro && !this.onp && this.overit == 0 && this.freq <= 0) {
                                    b2 = 1;
                                    this.cur = 12;
                                    if (paramBoolean) {
                                        this.tab = 1;
                                        if (!this.proname.equals(this.clname[b])) {
                                            this.proname = this.clname[b];
                                            this.loadedp = false;
                                            onexitpro();
                                        }
                                    }
                                }
                                boolean bool = drawl(this.rd, this.clname[b], 26, 38 + 50 * m - this.scro, b2);
                                if (b2 == 0 || !bool) {
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString(this.clname[b], 86 - this.ftm.stringWidth(this.clname[b]) / 2, 49 + 50 * m - this.scro);
                                    this.rd.setFont(new Font("Arial", 0, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    String str = "Player Offline";
                                    this.rd.drawString(str, 86 - this.ftm.stringWidth(str) / 2, 65 + 50 * m - this.scro);
                                }
                                this.rd.setColor(color2k(150, 150, 150));
                                this.rd.drawLine(5, 77 + 50 * m - this.scro, 167, 77 + 50 * m - this.scro);
                            }
                            m++;
                        }
                    }
                } else {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Loading clan mates...", 86 - this.ftm.stringWidth("Loading clan mates...") / 2, 200);
                }
            } else if (this.open == 452) {
                this.rd.setColor(color2k(230, 230, 230));
                this.rd.fillRoundRect(240, 170, 511, 90, 20, 20);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRoundRect(240, 170, 511, 90, 20, 20);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                this.rd.drawString("Failed to connect to server at this time, please exit and try again later.", 495 - this.ftm.stringWidth("Failed to connect to server at this time, please exit and try again later.") / 2, 200);
                if (stringbutton(this.rd, "  Exit  ", 495, 230, 1, paramInt2, paramInt3, paramBoolean, 0, 0)) {
                    this.open = 450;
                    this.upo = false;
                    this.domon = false;
                }
            }
            int[] arrayOfInt1 = {193, 193, 295, 318}, arrayOfInt2 = {33, 10, 10, 33};
            int n;
            for (n = 0; n < 4; n++) {
                boolean bool = false;
                if (this.tab == 3 && n == 0) bool = true;
                if (this.tab == 1 && n == 1) bool = true;
                if (this.tab == 2 && n == 2) bool = true;
                if (this.tab == 0 && n == 3) bool = true;
                this.rd.setColor(new Color(255, 255, 255));
                if (bool) {
                    this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
                } else {
                    this.rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
                }
                if (paramInt3 >= 12 && paramInt3 <= 32 && paramInt2 > arrayOfInt1[0] && paramInt2 < arrayOfInt1[3]) {
                    this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                    if (paramBoolean && !this.gs.openm) {
                        if (n == 0) this.tab = 3;
                        if (n == 1 || n == 2) this.tab = n;
                        if (n == 3) this.tab = 0;
                        if (this.tab == 1 && this.proname.equals("")) {
                            this.proname = this.xt.nickname;
                            this.loadedp = false;
                            onexitpro();
                        }
                    }
                }
                this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawPolygon(arrayOfInt1, arrayOfInt2, 4);
                this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                if (n == 0) {
                    arrayOfInt2[1] = 13;
                    arrayOfInt2[2] = 13;
                    arrayOfInt1[2] = 298;
                }
                for (byte b = 0; b < 4; ) {
                    arrayOfInt1[b] = arrayOfInt1[b] + 125;
                    b++;
                }
            }
            this.rd.drawImage(this.xt.cnmc, 224, 15, (ImageObserver) null);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawLine(191, 34, 800, 34);
            this.rd.setColor(color2k(200, 200, 200));
            this.rd.fillRect(0, 0, 190, 28);
            this.rd.setColor(color2k(150, 150, 150));
            this.rd.drawLine(0, 25, 170, 25);
            this.rd.setColor(color2k(200, 200, 200));
            this.rd.fillRect(0, 438, 190, 12);
            this.rd.setColor(color2k(150, 150, 150));
            this.rd.drawLine(0, 440, 170, 440);
            this.rd.setColor(color2k(200, 200, 200));
            this.rd.fillRect(173, 28, 17, 410);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawLine(191, 0, 191, 450);
            if (paramInt2 > 0 && paramInt2 < 171 && paramInt3 > 2 && paramInt3 < 23) {
                if (!this.onp) {
                    this.rd.setColor(color2k(220, 220, 220));
                    this.rd.fillRect(2, 2, 146, 21);
                }
                this.rd.setColor(color2k(255, 255, 255));
                if (paramBoolean && this.overit == 0 && !this.onp) {
                    this.onp = true;
                    this.overit = 5;
                }
            } else {
                this.rd.setColor(color2k(235, 235, 235));
            }
            if (this.overit < 0) this.overit++;
            this.rd.fillRect(150, 2, 20, 20);
            this.rd.setColor(color2k(150, 150, 150));
            this.rd.drawRect(150, 2, 20, 20);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawLine(157, 10, 157, 11);
            this.rd.drawLine(158, 11, 158, 12);
            this.rd.drawLine(159, 12, 159, 13);
            this.rd.drawLine(160, 13, 160, 14);
            this.rd.drawLine(161, 12, 161, 13);
            this.rd.drawLine(162, 11, 162, 12);
            this.rd.drawLine(163, 10, 163, 11);
            if (this.ptab == 0) this.rd.drawImage(this.xt.players, 7, 5, (ImageObserver) null);
            if (this.ptab == 1) this.rd.drawImage(this.xt.myfr, 21, 4, (ImageObserver) null);
            if (this.ptab == 2) this.rd.drawImage(this.xt.mycl, 34, 4, (ImageObserver) null);
            if (this.onp) {
                this.rd.setColor(color2k(200, 200, 200));
                this.rd.fillRect(0, 25, 170, 67);
                this.rd.setColor(color2k(150, 150, 150));
                this.rd.drawRect(0, 25, 170, 67);
                if (paramInt2 > 0 && paramInt2 < 171 && paramInt3 >= 26 && paramInt3 < 48) {
                    this.rd.setColor(color2k(235, 235, 235));
                    this.rd.fillRect(1, 26, 169, 22);
                    if (paramBoolean) this.ptab = 0;
                }
                if (paramInt2 > 0 && paramInt2 < 171 && paramInt3 >= 48 && paramInt3 < 70) {
                    this.rd.setColor(color2k(235, 235, 235));
                    this.rd.fillRect(1, 48, 169, 22);
                    if (paramBoolean) {
                        this.ptab = 1;
                        this.npf = -1;
                    }
                }
                if (paramInt2 > 0 && paramInt2 < 171 && paramInt3 >= 70 && paramInt3 < 92) {
                    this.rd.setColor(color2k(235, 235, 235));
                    this.rd.fillRect(1, 70, 169, 22);
                    if (paramBoolean) this.ptab = 2;
                }
                this.rd.drawImage(this.xt.players, 7, 30, (ImageObserver) null);
                this.rd.drawImage(this.xt.myfr, 21, 51, (ImageObserver) null);
                this.rd.drawImage(this.xt.mycl, 34, 73, (ImageObserver) null);
                if (paramBoolean && this.overit == 0) {
                    this.onp = false;
                    this.overit = -5;
                }
                if (this.overit > 0) this.overit--;
            }
            if (this.mscro == 831 || this.sdist == 0) {
                if (this.sdist == 0) {
                    this.rd.setColor(color2k(205, 205, 205));
                } else {
                    this.rd.setColor(color2k(215, 215, 215));
                }
                this.rd.fillRect(173, 28, 17, 17);
            } else {
                this.rd.setColor(color2k(220, 220, 220));
                this.rd.fill3DRect(173, 28, 17, 17, true);
            }
            if (this.sdist != 0) this.rd.drawImage(this.xt.asu, 178, 34, (ImageObserver) null);
            if (this.mscro == 832 || this.sdist == 0) {
                if (this.sdist == 0) {
                    this.rd.setColor(color2k(205, 205, 205));
                } else {
                    this.rd.setColor(color2k(215, 215, 215));
                }
                this.rd.fillRect(173, 421, 17, 17);
            } else {
                this.rd.setColor(color2k(220, 220, 220));
                this.rd.fill3DRect(173, 421, 17, 17, true);
            }
            if (this.sdist != 0) this.rd.drawImage(this.xt.asd, 178, 428, (ImageObserver) null);
            if (this.sdist != 0) {
                if (this.lspos != this.spos) {
                    this.rd.setColor(color2k(215, 215, 215));
                    this.rd.fillRect(173, 45 + this.spos, 17, 31);
                } else {
                    if (this.mscro == 831) this.rd.setColor(color2k(215, 215, 215));
                    this.rd.fill3DRect(173, 45 + this.spos, 17, 31, true);
                }
                this.rd.setColor(color2k(150, 150, 150));
                this.rd.drawLine(178, 58 + this.spos, 184, 58 + this.spos);
                this.rd.drawLine(178, 60 + this.spos, 184, 60 + this.spos);
                this.rd.drawLine(178, 62 + this.spos, 184, 62 + this.spos);
                if (this.mscro > 800 && this.lspos != this.spos) this.lspos = this.spos;
                if (paramBoolean) {
                    if (this.mscro == 825 && paramInt2 > 173 && paramInt2 < 190 && paramInt3 > 45 + this.spos && paramInt3 < this.spos + 76)
                        this.mscro = paramInt3 - this.spos;
                    if (this.mscro == 825 && paramInt2 > 171 && paramInt2 < 192 && paramInt3 > 26 && paramInt3 < 47)
                        this.mscro = 831;
                    if (this.mscro == 825 && paramInt2 > 171 && paramInt2 < 192 && paramInt3 > 419 && paramInt3 < 440)
                        this.mscro = 832;
                    if (this.mscro == 825 && paramInt2 > 173 && paramInt2 < 190 && paramInt3 > 45 && paramInt3 < 421) {
                        this.mscro = 60;
                        this.spos = paramInt3 - this.mscro;
                    }
                    n = 2670 / this.sdist;
                    if (n < 1) n = 1;
                    if (this.mscro == 831) {
                        this.spos -= n;
                        if (this.spos > 345) this.spos = 345;
                        if (this.spos < 0) this.spos = 0;
                        this.lspos = this.spos;
                    }
                    if (this.mscro == 832) {
                        this.spos += n;
                        if (this.spos > 345) this.spos = 345;
                        if (this.spos < 0) this.spos = 0;
                        this.lspos = this.spos;
                    }
                    if (this.mscro < 800) {
                        this.spos = paramInt3 - this.mscro;
                        if (this.spos > 345) this.spos = 345;
                        if (this.spos < 0) this.spos = 0;
                    }
                    if (this.mscro == 825) this.mscro = 925;
                } else if (this.mscro != 825) {
                    this.mscro = 825;
                }
            }
            if (this.cur != this.curs) {
                this.gs.setCursor(new Cursor(this.cur));
                this.curs = this.cur;
            }
        } else {
            this.xt.drawWarning();
            if (this.gs.cmsg.isShowing()) {
                this.gs.cmsg.hide();
                this.gs.requestFocus();
            }
            if (this.xt.warning > 220) {
                paramInt1 = 0;
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
            this.xt.warning++;
        }
        if (bool1) {
            this.gs.movefieldd(this.gs.cmsg, 207, 414, 462, 22, true);
            if (this.gs.cmsg.getText().equals("Type here...") && paramInt2 > 197 && paramInt2 < 679 && paramInt3 > 404 && paramInt3 < 446)
                this.gs.cmsg.setText("");
            if (this.gs.cmsg.getText().length() > 200) {
                this.gs.cmsg.setText(this.gs.cmsg.getText().substring(0, 200));
                this.gs.cmsg.select(200, 200);
            }
        }
        if (bool2) {
            if (!this.gs.cmsg.isShowing()) {
                this.gs.cmsg.show();
                this.gs.cmsg.setText(this.sentance);
                this.gs.cmsg.requestFocus();
            }
            this.gs.movefield(this.gs.cmsg, 275, 91, 440, 22);
            if (!this.sentance.equals(this.gs.cmsg.getText())) {
                this.sentchange = 1;
                this.rd.setFont(new Font("Tahoma", 1, 11));
                this.ftm = this.rd.getFontMetrics();
                if (this.ftm.stringWidth(this.gs.cmsg.getText()) > 800) {
                    this.gs.cmsg.setText(this.sentance);
                } else {
                    this.sentance = this.gs.cmsg.getText();
                }
            }
        }
        if (this.dorank) {
            if (!this.gs.cmsg.isShowing()) {
                this.gs.cmsg.show();
                this.gs.cmsg.setText(this.mrank[this.em]);
                this.gs.cmsg.requestFocus();
            }
            this.gs.movefield(this.gs.cmsg, 402, 131, 300, 22);
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            if (this.ftm.stringWidth(this.gs.cmsg.getText()) > 270) {
                int i = this.gs.cmsg.getText().length() - 1;
                if (i < 0) i = 0;
                this.gs.cmsg.setText(this.gs.cmsg.getText().substring(0, i));
                this.gs.cmsg.select(i, i);
            }
        }
        if (this.donewc) {
            if (!this.gs.temail.isShowing()) {
                this.gs.temail.show();
                this.gs.temail.setText("");
                this.gs.temail.requestFocus();
            }
            this.gs.movefield(this.gs.temail, 473, 141, 150, 22);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            if (this.ftm.stringWidth(this.gs.temail.getText()) > 150) {
                int i = this.gs.temail.getText().length() - 1;
                if (i < 0) i = 0;
                this.gs.temail.setText(this.gs.temail.getText().substring(0, i));
                this.gs.temail.select(i, i);
            }
            if (!this.gs.temail.getText().equals(this.lccnam)) {
                this.lg.fixtext(this.gs.temail);
                this.lccnam = this.gs.temail.getText();
            }
            if (this.xt.msgcheck(this.gs.temail.getText())) this.gs.temail.setText("");
        }
        if (this.dosrch) {
            if (!this.gs.temail.isShowing()) {
                this.gs.temail.show();
                this.gs.temail.setText("");
                this.gs.temail.requestFocus();
            }
            this.gs.movefield(this.gs.temail, 371, 88, 150, 22);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            if (this.ftm.stringWidth(this.gs.temail.getText()) > 150) {
                int i = this.gs.temail.getText().length() - 1;
                if (i < 0) i = 0;
                this.gs.temail.setText(this.gs.temail.getText().substring(0, i));
                this.gs.temail.select(i, i);
            }
            if (!this.gs.temail.getText().equals(this.lccnam)) {
                this.lg.fixtext(this.gs.temail);
                this.lccnam = this.gs.temail.getText();
            }
            if (this.xt.msgcheck(this.gs.temail.getText())) this.gs.temail.setText("");
        }
        if (this.doweb1) {
            if (!this.gs.temail.isShowing()) {
                this.gs.temail.show();
                this.gs.temail.setText(this.ltit);
                this.gs.temail.requestFocus();
            }
            this.gs.movefield(this.gs.temail, 411, 174, 150, 22);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            if (this.ftm.stringWidth(this.gs.temail.getText()) > 200) {
                int i = this.gs.temail.getText().length() - 1;
                if (i < 0) i = 0;
                this.gs.temail.setText(this.gs.temail.getText().substring(0, i));
                this.gs.temail.select(i, i);
            }
            if (this.xt.msgcheck(this.gs.temail.getText())) this.gs.temail.setText("");
            if (!this.gs.cmsg.isShowing()) {
                this.gs.cmsg.show();
                this.gs.cmsg.setText(this.ldes);
            }
            this.gs.movefield(this.gs.cmsg, 411, 204, 300, 22);
            this.rd.setFont(new Font("Arial", 0, 12));
            this.ftm = this.rd.getFontMetrics();
            if (this.ftm.stringWidth(this.gs.cmsg.getText()) > 400) {
                int i = this.gs.cmsg.getText().length() - 1;
                if (i < 0) i = 0;
                this.gs.cmsg.setText(this.gs.cmsg.getText().substring(0, i));
                this.gs.cmsg.select(i, i);
            }
            if (this.xt.msgcheck(this.gs.cmsg.getText())) this.gs.cmsg.setText("");
        }
        if (this.doweb2) {
            if (!this.gs.temail.isShowing()) {
                this.gs.temail.show();
                this.gs.temail.requestFocus();
            }
            this.gs.movefield(this.gs.temail, 354, 134, 350, 22);
        }
        if (this.dommsg) {
            if (!this.donemsg) {
                this.gs.mmsg.setText(" ");
                if (!this.gs.applejava) {
                    this.gs.mmsg.show();
                    this.gs.mmsg.requestFocus();
                }
                this.donemsg = true;
            }
            this.gs.movefielda(this.gs.mmsg, 207, 389, 450, 50);
        } else {
            if (this.gs.mmsg.isShowing()) this.gs.mmsg.hide();
            if (this.donemsg) this.donemsg = false;
        }
        if (!this.dosrch && !this.donewc && !this.doweb1 && !this.doweb2 && this.gs.temail.isShowing())
            this.gs.temail.hide();
        if (!bool1 && !bool2 && !this.dorank && !this.doweb1 && this.open == 452 && this.gs.cmsg.isShowing())
            this.gs.cmsg.hide();
    }

    public void dotab3(int paramInt1, int paramInt2, boolean paramBoolean) {
        if (this.cfase == 0) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRect(214, 44, 160, 50);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            char c = 'ï';
            int i = this.ftm.stringWidth("Search for a clan");
            this.rd.fillRect(225, 57, 4, 4);
            this.rd.drawString("Search for a clan", c, 63);
            if (paramInt1 > c && paramInt1 < c + i && paramInt2 > 46 && paramInt2 < 65 && this.editc == 0) {
                this.rd.drawLine(c, 65, c + i, 65);
                this.cur = 12;
                if (paramBoolean) {
                    this.cfase = 2;
                    this.em = 1;
                    this.msg = "Clan Search";
                    this.smsg = "Listing clans with recent activity...";
                    this.nclns = 0;
                    this.spos5 = 0;
                    this.lspos5 = 0;
                    this.flko = 0;
                }
            }
            c = 'ï';
            i = this.ftm.stringWidth("Create a new clan");
            this.rd.fillRect(225, 77, 4, 4);
            this.rd.drawString("Create a new clan", c, 83);
            if (paramInt1 > c && paramInt1 < c + i && paramInt2 > 66 && paramInt2 < 85 && this.editc == 0) {
                this.rd.drawLine(c, 85, c + i, 85);
                this.cur = 12;
                if (paramBoolean) {
                    this.cfase = 1;
                    this.em = 0;
                    this.msg = "Start a new Need for Madness clan,";
                    this.flko = 0;
                }
            }
            if (!this.xt.clan.equals("")) {
                byte b1 = -40;
                byte b2 = 19;
                if (!drawl(this.rd, "#" + this.xt.clan + "#", 406 + b2, 101 + b1, true)) {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("" + this.xt.clan + "", 581 + b2 - this.ftm.stringWidth("" + this.xt.clan + "") / 2, 121 + b1);
                }
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                String str = "Your Clan";
                if (paramInt1 > 402 + b2 && paramInt1 < 759 + b2 && paramInt2 > 84 + b1 && paramInt2 < 134 + b1) {
                    str = "Clan :  " + this.xt.clan + "";
                    this.rd.drawLine(408 + b2, 98 + b1, 408 + b2 + this.ftm.stringWidth(str), 98 + b1);
                    if ((paramInt1 > 408 + b2 && paramInt1 < 408 + b2 + this.ftm.stringWidth(str) && paramInt2 > 85 + b1 && paramInt2 < 100 + b1) || (paramInt1 > 406 + b2 && paramInt1 < 756 + b2 && paramInt2 > 101 + b1 && paramInt2 < 131 + b1)) {
                        this.cur = 12;
                        if (paramBoolean) {
                            if (!this.claname.equals(this.xt.clan)) {
                                this.claname = this.xt.clan;
                                this.loadedc = false;
                            }
                            this.spos5 = 0;
                            this.lspos5 = 0;
                            this.cfase = 3;
                            this.ctab = 0;
                            this.blocknote = 10;
                        }
                    }
                }
                this.rd.drawString(str, 408 + b2, 97 + b1);
                this.rd.drawLine(402 + b2, 84 + b1, 402 + b2, 134 + b1);
                this.rd.drawLine(402 + b2, 84 + b1, 408 + b2 + this.ftm.stringWidth(str) + 2, 84 + b1);
                this.rd.drawLine(408 + b2 + this.ftm.stringWidth(str) + 2, 84 + b1, 408 + b2 + this.ftm.stringWidth(str) + 15, 97 + b1);
                this.rd.drawLine(408 + b2 + this.ftm.stringWidth(str) + 15, 97 + b1, 759 + b2, 97 + b1);
                this.rd.drawLine(759 + b2, 97 + b1, 759 + b2, 134 + b1);
                this.rd.drawLine(402 + b2, 134 + b1, 759 + b2, 134 + b1);
            }
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            if (this.ntab == 0) {
                int[] arrayOfInt1 = {214, 225 + this.ftm.stringWidth("Game News"), 225 + this.ftm.stringWidth("Game News") + 23, 778, 778, 214};
                int[] arrayOfInt2 = {112, 112, 135, 135, 443, 443};
                this.rd.setColor(new Color(206, 171, 98));
                this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 6);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawPolygon(arrayOfInt1, arrayOfInt2, 6);
            }
            if (this.ntab == 1) {
                int[] arrayOfInt1 = {214, 225 + this.ftm.stringWidth("Game News") + 23, 225 + this.ftm.stringWidth("Game News") + 23, 236 + this.ftm.stringWidth("Game News") + 23 + this.ftm.stringWidth("Wars World Championship"), 236 + this.ftm.stringWidth("Game News") + 23 + this.ftm.stringWidth("Wars World Championship") + 23, 778, 778, 214};
                int[] arrayOfInt2 = {135, 135, 112, 112, 135, 135, 443, 443};
                this.rd.setColor(new Color(206, 171, 98));
                this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 8);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawPolygon(arrayOfInt1, arrayOfInt2, 8);
            }
            int j = 223, k = this.ftm.stringWidth("Game News");
            byte b = 23;
            this.rd.drawString("Game News", j, 107 + b);
            if (paramInt1 > j && paramInt1 < j + k && paramInt2 > 90 + b && paramInt2 < 109 + b) {
                this.rd.drawLine(j, 109 + b, j + k, 109 + b);
                this.cur = 12;
                if (paramBoolean) {
                    this.ntab = 0;
                    this.spos6 = 0;
                }
            }
            j += k + 35;
            k = this.ftm.stringWidth("Wars World Championship");
            this.rd.drawString("Wars World Championship", j, 107 + b);
            if (paramInt1 > j && paramInt1 < j + k && paramInt2 > 90 + b && paramInt2 < 109 + b) {
                this.rd.drawLine(j, 109 + b, j + k, 109 + b);
                this.cur = 12;
                if (paramBoolean) {
                    this.ntab = 1;
                    this.spos6 = 0;
                }
            }
            this.rdo.setColor(new Color(206, 171, 98));
            this.rdo.fillRect(0, 0, 560, 300);
            this.darker = true;
            if (stringbutton(this.rd, "  Refresh  ", 738, 125, 3, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                if (this.ntab == 0) this.loadednews = 0;
                if (this.ntab == 1) this.loadwstat = 0;
            }
            this.darker = false;
            if (this.ntab == 0) {
                if (this.loadednews == 1) {
                    byte b1;
                    int m;
                    for (b1 = 0, m = 0; m < 5; ) {
                        if (this.nwarbs[m] > 0) b1++;
                        m++;
                    }
                    if (b1 == 0) b1 = 1;
                    this.sdist = 100 + 35 * b1 + this.doi * 16 - 200;
                    if (this.sdist < 0) this.sdist = 0;
                    this.scro = (int) (this.spos6 / 229.0F * this.sdist);
                    if (this.scro < 55) {
                        this.rdo.setFont(new Font("Tahoma", 1, 11));
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawString("A big welcome to the latest players to join the game with full accounts!", 18, 15 - this.scro);
                        for (m = 0; m < 4; m++) {
                            boolean bool1 = false;
                            boolean bool2 = false;
                            if (paramInt1 > 234 + 128 * m && paramInt1 < 354 + 128 * m && paramInt2 > 159 - this.scro && paramInt2 < 189 - this.scro && paramInt2 > 139 && paramInt2 < 439) {
                                bool2 = true;
                                this.cur = 12;
                                if (paramBoolean) {
                                    this.tab = 1;
                                    if (!this.proname.equals(this.newplayers[m])) {
                                        this.proname = this.newplayers[m];
                                        this.loadedp = false;
                                        onexitpro();
                                    }
                                }
                            }
                            if (!bool2) {
                                bool1 = drawl(this.rdo, this.newplayers[m], 18 + 128 * m, 20 - this.scro, true);
                            } else {
                                drawl(this.rdo, this.newplayers[m], 18 + 128 * m, 20 - this.scro, false);
                            }
                            if (!bool1) {
                                this.rdo.setComposite(AlphaComposite.getInstance(3, 0.2F));
                                this.rdo.setColor(new Color(255, 255, 255));
                                this.rdo.fillRect(18 + 128 * m, 20 - this.scro, 119, 29);
                                this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                                this.rdo.setColor(new Color(0, 0, 0));
                                this.rdo.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rdo.getFontMetrics();
                                this.rdo.drawRect(18 + 128 * m, 20 - this.scro, 119, 29);
                                this.rdo.drawString(this.newplayers[m], 78 + 128 * m - this.ftm.stringWidth(this.newplayers[m]) / 2, 39 - this.scro);
                            }
                        }
                    }
                    if (75 + 35 * b1 - this.scro > 0) {
                        this.rdo.setFont(new Font("Tahoma", 1, 11));
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawString("Recent clan wars & battles:", 18, 70 - this.scro);
                        b1 = 0;
                        for (m = 0; m < 5; m++) {
                            if (this.nwarbs[m] > 0) {
                                this.rdo.setComposite(AlphaComposite.getInstance(3, 0.2F));
                                boolean bool1 = false;
                                bool1 = drawl(this.rdo, "#" + this.nwclan[m] + "#", 18, 75 - this.scro + 35 * b1, true);
                                if (!bool1) {
                                    this.rdo.setColor(new Color(255, 255, 255));
                                    this.rdo.fillRect(18, 75 - this.scro + 35 * b1, 350, 30);
                                }
                                this.rdo.setComposite(AlphaComposite.getInstance(3, 0.1F));
                                this.rdo.setColor(new Color(255, 255, 255));
                                this.rdo.fillRect(368, 75 - this.scro + 35 * b1, 154, 30);
                                this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                                this.rdo.setColor(new Color(0, 0, 0));
                                this.rdo.setFont(new Font("Tahoma", 1, 11));
                                String str1 = "war";
                                if (this.nwarbs[m] == 2) str1 = "car battle";
                                if (this.nwarbs[m] == 3) str1 = "stage battle";
                                String str2 = "" + this.nwclan[m] + " defeated " + this.nlclan[m] + " in a " + str1 + "!";
                                this.rdo.drawString(str2, 22, 87 - this.scro + 35 * b1);
                                tlink(this.rdo, 22, 87 - this.scro + 35 * b1, str2, this.nwclan[m], paramInt1, paramInt2, paramBoolean, 216, 139, 1, this.nwclan[m], "");
                                tlink(this.rdo, 22, 87 - this.scro + 35 * b1, str2, this.nlclan[m], paramInt1, paramInt2, paramBoolean, 216, 139, 1, this.nlclan[m], "");
                                if (this.nwarbs[m] == 1 && this.nwinp[m] != -1 && this.nlosp[m] != -1)
                                    if (this.nwinob[m].equals("champ")) {
                                        String str3 = "" + this.nwclan[m] + " has taken the clan wars world championship title!";
                                        this.rdo.setFont(new Font("Tahoma", 0, 11));
                                        this.rdo.drawString(str3, 22, 100 - this.scro + 35 * b1);
                                        tlink(this.rdo, 22, 100 - this.scro + 35 * b1, str3, "clan wars world championship title", paramInt1, paramInt2, paramBoolean, 216, 139, 5, "", "");
                                    } else if (this.nwinob[m].equals("re-champ")) {
                                        String str3 = "" + this.nwclan[m] + " has defended and re-claimed the clan wars world championship title!";
                                        this.rdo.setFont(new Font("Tahoma", 0, 11));
                                        this.rdo.drawString(str3, 22, 100 - this.scro + 35 * b1);
                                        tlink(this.rdo, 22, 100 - this.scro + 35 * b1, str3, "clan wars world championship title", paramInt1, paramInt2, paramBoolean, 216, 139, 5, "", "");
                                    } else {
                                        String str3 = "" + this.nwclan[m] + " won: [ " + this.nwinp[m] + " points ]  & " + this.nlclan[m] + " lost: [ " + this.nlosp[m] + " points ]";
                                        this.rdo.setFont(new Font("Tahoma", 0, 11));
                                        this.rdo.drawString(str3, 22, 100 - this.scro + 35 * b1);
                                        tlink(this.rdo, 22, 100 - this.scro + 35 * b1, str3, "" + this.nwinp[m] + " points", paramInt1, paramInt2, paramBoolean, 216, 139, 5, "", "");
                                        tlink(this.rdo, 22, 100 - this.scro + 35 * b1, str3, "" + this.nlosp[m] + " points", paramInt1, paramInt2, paramBoolean, 216, 139, 5, "", "");
                                    }
                                if (this.nwarbs[m] == 2) {
                                    String str3 = "" + this.nwclan[m] + " took car [" + this.nwinob[m] + "] from " + this.nlclan[m] + ".";
                                    this.rdo.setFont(new Font("Tahoma", 0, 11));
                                    this.rdo.drawString(str3, 22, 100 - this.scro + 35 * b1);
                                    tlink(this.rdo, 22, 100 - this.scro + 35 * b1, str3, this.nwinob[m], paramInt1, paramInt2, paramBoolean, 216, 139, 3, this.nwinob[m], this.nwclan[m]);
                                }
                                if (this.nwarbs[m] == 3) {
                                    String str3 = this.nwinob[m];
                                    if (str3.length() > 20) str3 = "" + str3.substring(0, 20) + "...";
                                    String str4 = "" + this.nwclan[m] + " took stage [" + str3 + "] from " + this.nlclan[m] + ".";
                                    this.rdo.setFont(new Font("Tahoma", 0, 11));
                                    this.rdo.drawString(str4, 22, 100 - this.scro + 35 * b1);
                                    tlink(this.rdo, 22, 100 - this.scro + 35 * b1, str4, str3, paramInt1, paramInt2, paramBoolean, 216, 139, 4, this.nwinob[m], this.nwclan[m]);
                                }
                                this.rdo.setColor(new Color(98, 76, 29));
                                this.rdo.setFont(new Font("Tahoma", 0, 11));
                                this.ftm = this.rdo.getFontMetrics();
                                this.rdo.drawString(this.nwtime[m], 518 - this.ftm.stringWidth(this.nwtime[m]), 87 - this.scro + 35 * b1);
                                b1++;
                            }
                        }
                        if (b1 == 0) {
                            this.rdo.setColor(new Color(0, 0, 0));
                            this.rdo.setFont(new Font("Tahoma", 0, 11));
                            this.ftm = this.rdo.getFontMetrics();
                            this.rdo.drawString("(No recent clan wars or battles have been played yet...)", 280 - this.ftm.stringWidth("(No recent clan wars or battles have been played yet...)") / 2, 91 - this.scro);
                            b1 = 1;
                        }
                    }
                    m = 70 + 35 * b1 - this.scro;
                    if (m + 25 > 0) {
                        this.rdo.setFont(new Font("Tahoma", 1, 11));
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawString("Recent clan activity:", 18, m + 20);
                    }
                    boolean bool = false;
                    String str = "";
                    this.doi = 0;
                    for (byte b2 = 0; b2 < this.il; b2++) {
                        if (!this.text[b2].equals(str)) {
                            if (!bool) {
                                bool = true;
                            } else {
                                bool = false;
                            }
                            if (m + this.doi * 16 + 38 > 0 && m + this.doi * 16 + 18 < 300) {
                                if (bool) {
                                    this.rdo.setComposite(AlphaComposite.getInstance(3, 0.1F));
                                    this.rdo.setColor(new Color(255, 255, 255));
                                    this.rdo.fillRect(18, m + this.doi * 16 + 24, 504, 16);
                                    this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                                }
                                this.rdo.setFont(new Font("Tahoma", 0, 11));
                                this.ftm = this.rdo.getFontMetrics();
                                if (this.text[b2].startsWith("Battle")) {
                                    this.rdo.setFont(new Font("Tahoma", 1, 11));
                                } else {
                                    this.rdo.setColor(new Color(98, 76, 29));
                                    this.rdo.drawString(this.nttime[b2], 518 - this.ftm.stringWidth(this.nttime[b2]), m + this.doi * 16 + 36);
                                }
                                if (this.text[b2].indexOf("started") != -1) {
                                    this.rdo.setFont(new Font("Tahoma", 1, 11));
                                    if (this.text[b2].indexOf("war") == -1) if (!bool) {
                                        bool = true;
                                    } else {
                                        bool = false;
                                    }
                                }
                                if (this.text[b2].indexOf("clan wars world champion") != -1) {
                                    this.rdo.setFont(new Font("Tahoma", 1, 11));
                                    if (!bool) {
                                        bool = true;
                                    } else {
                                        bool = false;
                                    }
                                }
                                this.rdo.setColor(new Color(0, 0, 0));
                                this.rdo.drawString(this.text[b2], 22, m + this.doi * 16 + 36);
                                for (byte b3 = 0; b3 < this.nln[b2]; ) {
                                    tlink(this.rdo, 22, m + this.doi * 16 + 36, this.text[b2], this.link[b2][b3][0], paramInt1, paramInt2, paramBoolean, 216, 139, getvalue(this.link[b2][b3][1], 0), getSvalue(this.link[b2][b3][1], 1), getSvalue(this.link[b2][b3][1], 2));
                                    b3++;
                                }
                            }
                            str = this.text[b2];
                            this.doi++;
                        }
                    }
                } else {
                    this.sdist = 0;
                }
                if (this.loadednews == 0) {
                    this.rdo.setFont(new Font("Tahoma", 1, 11));
                    this.ftm = this.rdo.getFontMetrics();
                    this.rdo.setColor(new Color(0, 0, 0));
                    this.rdo.drawString("Loading game news, please wait...", 280 - this.ftm.stringWidth("Loading game news, please wait...") / 2, 140);
                }
                if (this.loadednews == -1) {
                    this.rdo.setFont(new Font("Tahoma", 1, 11));
                    this.ftm = this.rdo.getFontMetrics();
                    this.rdo.setColor(new Color(0, 0, 0));
                    this.rdo.drawString("Failed to load game news, please try again later...", 280 - this.ftm.stringWidth("Failed to load game news, please try again later...") / 2, 140);
                }
            }
            if (this.ntab == 1) {
                this.darker = true;
                if (stringbutton(this.rd, "  About Championship  ", 617, 125, 3, paramInt1, paramInt2, paramBoolean, 0, 0))
                    this.ntab = 2;
                this.darker = false;
                if (this.loadwstat == 1) {
                    if (this.eng == -1) {
                        int m = this.ncc;
                        if (this.champ >= 0) m--;
                        if (m < 0) m = 0;
                        this.sdist = 154 + m * 45 - 260;
                        if (this.sdist < 0) this.sdist = 0;
                        this.scro = (int) (this.spos6 / 229.0F * this.sdist);
                        this.rdo.setFont(new Font("Tahoma", 1, 11));
                        this.ftm = this.rdo.getFontMetrics();
                        int n = this.ftm.stringWidth("Engagement Stats");
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawString("Current World Champion", 10, 20 - this.scro);
                        this.rdo.setColor(new Color(228, 177, 31));
                        this.rdo.fillRoundRect(10, 28 - this.scro, 520, 70, 20, 20);
                        this.rdo.setColor(new Color(199, 154, 63));
                        this.rdo.fillRoundRect(13, 33 - this.scro, 514, 60, 20, 20);
                        this.rdo.setColor(new Color(255, 198, 0));
                        this.rdo.drawRoundRect(13, 33 - this.scro, 514, 60, 20, 20);
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawRoundRect(10, 28 - this.scro, 520, 70, 20, 20);
                        if (this.champ == -1) {
                            this.rdo.setFont(new Font("Tahoma", 0, 11));
                            this.ftm = this.rdo.getFontMetrics();
                            this.rdo.drawString("No current world champion because no contender has attained or surpassed 3 points yet!", 270 - this.ftm.stringWidth("No current world champion because no contender has attained or surpassed 3 points yet!") / 2, 65 - this.scro);
                        }
                        if (this.champ == -2) {
                            this.rdo.setFont(new Font("Tahoma", 0, 11));
                            this.ftm = this.rdo.getFontMetrics();
                            this.rdo.drawString("No current world champion at this moment because the top contenders are tied in points!", 270 - this.ftm.stringWidth("No current world champion at this moment because the top contenders are tied in points!") / 2, 65 - this.scro);
                        }
                        if (this.champ >= 0) {
                            if (!drawl(this.rdo, "#" + this.conclan[this.champ] + "#", 21, 40 - this.scro, true)) {
                                this.rdo.setColor(new Color(100, 77, 31));
                                this.rdo.drawRect(21, 40 - this.scro, 349, 29);
                                this.rdo.setFont(new Font("Arial", 1, 13));
                                this.ftm = this.rdo.getFontMetrics();
                                this.rdo.drawString(this.conclan[this.champ], 196 - this.ftm.stringWidth(this.conclan[this.champ]) / 2, 59 - this.scro);
                            }
                            if (paramInt1 > 237 && paramInt1 < 587 && paramInt2 > 179 - this.scro && paramInt2 < 209 - this.scro && paramInt2 > 139 && paramInt2 < 439) {
                                this.cur = 12;
                                if (paramBoolean) {
                                    if (!this.claname.equals(this.conclan[this.champ])) {
                                        this.claname = this.conclan[this.champ];
                                        this.loadedc = false;
                                    }
                                    this.spos5 = 0;
                                    this.lspos5 = 0;
                                    this.cfase = 3;
                                    this.ctab = 0;
                                }
                            }
                            this.rdo.setFont(new Font("Tahoma", 0, 11));
                            this.rdo.setColor(new Color(0, 0, 0));
                            this.rdo.drawString("" + this.conclan[this.champ] + " is leading the championship by " + this.leadsby + " points difference from the first contender!", 22, 85 - this.scro);
                            this.rdo.setFont(new Font("Tahoma", 1, 11));
                            this.rdo.drawString("Attained points:  [ " + this.totp[this.champ] + " ]", 383, 51 - this.scro);
                            this.rdo.drawString("Engagement Stats", 383, 66 - this.scro);
                            this.rdo.drawLine(383, 68 - this.scro, 383 + n, 68 - this.scro);
                            if (paramInt1 > 599 && paramInt1 < 383 + n + 216 && paramInt2 > 195 - this.scro && paramInt2 < 208 - this.scro && paramInt2 > 139 && paramInt2 < 439) {
                                this.cur = 12;
                                if (paramBoolean) {
                                    this.eng = this.champ;
                                    this.engo = 40 - this.scro;
                                    this.lspos6w = this.spos6;
                                    this.spos6 = 0;
                                }
                            }
                        }
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.setFont(new Font("Tahoma", 1, 11));
                        this.ftm = this.rdo.getFontMetrics();
                        this.rdo.drawString("Contenders", 10, 125 - this.scro);
                        if (m > 3) {
                            m = 160 + 45 * (m - 3);
                        } else {
                            m = 160;
                        }
                        this.rdo.drawRoundRect(10, 133 - this.scro, 520, m, 20, 20);
                        if (this.ncc == 0 || (this.ncc == 1 && this.champ == 0)) {
                            this.rdo.drawString("No contenders...", 270 - this.ftm.stringWidth("No contenders...") / 2, 160 - this.scro);
                            this.rdo.setFont(new Font("Tahoma", 0, 11));
                            this.ftm = this.rdo.getFontMetrics();
                            this.rdo.setColor(new Color(0, 0, 0));
                            this.rdo.drawString("To become a contender, a clan must get points by winning a war against any other clan.", 270 - this.ftm.stringWidth("To become a contender, a clan must get points by winning a war against any other clan.") / 2, 185 - this.scro);
                        } else {
                            this.rdo.setFont(new Font("Tahoma", 0, 11));
                            this.ftm = this.rdo.getFontMetrics();
                            this.rdo.setColor(new Color(0, 0, 0));
                            this.rdo.drawString("To become a contender, a clan must get points by winning a war against any other clan.", 270 - this.ftm.stringWidth("To become a contender, a clan must get points by winning a war against any other clan.") / 2, 147 - this.scro);
                            byte b1 = 0;
                            for (byte b2 = 0; b2 < this.ncc; b2++) {
                                if (this.ord[b2] != this.champ) {
                                    this.rdo.setColor(new Color(199, 154, 63));
                                    this.rdo.fillRect(11, 154 + b1 * 45 - this.scro, 519, 40);
                                    if (!drawl(this.rdo, "#" + this.conclan[this.ord[b2]] + "#", 21, 159 + b1 * 45 - this.scro, true)) {
                                        this.rdo.setColor(new Color(100, 77, 31));
                                        this.rdo.drawRect(21, 159 + b1 * 45 - this.scro, 349, 29);
                                        this.rdo.setFont(new Font("Arial", 1, 13));
                                        this.ftm = this.rdo.getFontMetrics();
                                        this.rdo.drawString(this.conclan[this.ord[b2]], 196 - this.ftm.stringWidth(this.conclan[this.ord[b2]]) / 2, 178 + b1 * 45 - this.scro);
                                    }
                                    if (paramInt1 > 237 && paramInt1 < 587 && paramInt2 > 159 + b1 * 45 + 139 - this.scro && paramInt2 < 189 + b1 * 45 + 139 - this.scro && paramInt2 > 139 && paramInt2 < 439) {
                                        this.cur = 12;
                                        if (paramBoolean) {
                                            if (!this.claname.equals(this.conclan[this.ord[b2]])) {
                                                this.claname = this.conclan[this.ord[b2]];
                                                this.loadedc = false;
                                            }
                                            this.spos5 = 0;
                                            this.lspos5 = 0;
                                            this.cfase = 3;
                                            this.ctab = 0;
                                        }
                                    }
                                    this.rdo.setColor(new Color(0, 0, 0));
                                    this.rdo.setFont(new Font("Tahoma", 1, 11));
                                    this.rdo.drawString("Attained points:  [ " + this.totp[this.ord[b2]] + " ]", 383, 170 + b1 * 45 - this.scro);
                                    this.rdo.drawString("Engagement Stats", 383, 185 + b1 * 45 - this.scro);
                                    this.rdo.drawLine(383, 187 + b1 * 45 - this.scro, 383 + n, 187 + b1 * 45 - this.scro);
                                    if (paramInt1 > 599 && paramInt1 < 383 + n + 216 && paramInt2 > 175 + b1 * 45 + 139 - this.scro && paramInt2 < 188 + b1 * 45 + 139 - this.scro && paramInt2 > 139 && paramInt2 < 439) {
                                        this.cur = 12;
                                        if (paramBoolean) {
                                            this.eng = this.ord[b2];
                                            this.engo = 159 + b1 * 45 - this.scro;
                                            this.lspos6w = this.spos6;
                                            this.spos6 = 0;
                                        }
                                    }
                                    b1++;
                                }
                            }
                        }
                    } else {
                        if (this.engo == 15) {
                            this.sdist = 87 + this.ados + this.nvc[this.eng] * 17 - 260;
                            if (this.sdist < 0) this.sdist = 0;
                            this.scro = (int) (this.spos6 / 229.0F * this.sdist);
                            this.ados = 0;
                            this.rdo.setFont(new Font("Tahoma", 1, 11));
                            this.rdo.setColor(new Color(0, 0, 0));
                            this.rdo.drawString("Engagement Stats", 385, 40 - this.scro);
                            String str = "s";
                            if (!this.xt.clan.equals("") && !this.xt.clan.toLowerCase().equals(this.conclan[this.eng].toLowerCase())) {
                                this.ados = 116;
                                int m, n, i1;
                                for (m = -1, n = 0, i1 = 0; i1 < this.ncc; ) {
                                    if (this.xt.clan.toLowerCase().equals(this.conclan[i1].toLowerCase())) {
                                        n = this.totp[i1];
                                        m = i1;
                                        break;
                                    }
                                    i1++;
                                }
                                i1 = this.totp[this.eng] + 1;
                                int i2 = n + 1;
                                if (i2 > this.totp[this.eng]) i2 = this.totp[this.eng];
                                if (m != -1) for (byte b3 = 0; b3 < this.nvc[m]; ) {
                                    if (this.conclan[this.eng].toLowerCase().equals(this.verclan[m][b3].toLowerCase())) {
                                        i1 -= this.points[m][b3];
                                        if (i1 < 0) i1 = 0;
                                        break;
                                    }
                                    b3++;
                                }
                                this.rdo.setFont(new Font("Tahoma", 1, 11));
                                this.rdo.setColor(new Color(0, 0, 0));
                                this.rdo.drawString("If your clan " + this.xt.clan + " engages & defeats " + this.conclan[this.eng] + " in a war:", 27, 70 - this.scro);
                                this.rdo.setFont(new Font("Tahoma", 0, 11));
                                str = "s";
                                if (i1 == 1) str = "";
                                this.rdo.drawString("- Your clan will get:  [ " + i1 + " point" + str + " ]", 47, 87 - this.scro);
                                str = "s";
                                if (i2 == 1) str = "";
                                this.rdo.drawString("- " + this.conclan[this.eng] + " will lose:  [ " + i2 + " point" + str + " ]", 47, 104 - this.scro);
                                if (i1 + n > 3 && i1 + n > this.totp[this.ord[0]] && !this.xt.clan.toLowerCase().equals(this.conclan[this.ord[0]].toLowerCase())) {
                                    if (this.frkl) {
                                        this.rdo.setColor(new Color(0, 0, 0));
                                        this.frkl = false;
                                    } else {
                                        this.rdo.setColor(new Color(106, 80, 0));
                                        this.frkl = true;
                                    }
                                    if (this.champ >= 0) {
                                        this.rdo.drawString("- Your clan would take the championship title from " + this.conclan[this.champ] + " !", 47, 121 - this.scro);
                                    } else {
                                        this.rdo.drawString("- Your clan would take the champion ship title!", 42, 121 - this.scro);
                                    }
                                    this.ados += 17;
                                }
                                this.rdo.setColor(new Color(0, 0, 0));
                                i1 = n + 1;
                                i2 = this.totp[this.eng] + 1;
                                if (i2 > n) i2 = n;
                                for (byte b2 = 0; b2 < this.nvc[this.eng]; ) {
                                    if (this.xt.clan.toLowerCase().equals(this.verclan[this.eng][b2].toLowerCase())) {
                                        i1 -= this.points[this.eng][b2];
                                        if (i1 < 0) i1 = 0;
                                        break;
                                    }
                                    b2++;
                                }
                                this.rdo.setFont(new Font("Tahoma", 1, 11));
                                this.rdo.setColor(new Color(0, 0, 0));
                                this.rdo.drawString("If your clan loses a war against " + this.conclan[this.eng] + ":", 27, 12 + this.ados - this.scro);
                                this.rdo.setFont(new Font("Tahoma", 0, 11));
                                str = "s";
                                if (i2 == 1) str = "";
                                this.rdo.drawString("- Your clan will lose:  [ " + i2 + " point" + str + " ]", 47, 29 + this.ados - this.scro);
                                str = "s";
                                if (i1 == 1) str = "";
                                this.rdo.drawString("- " + this.conclan[this.eng] + " will get:  [ " + i1 + " point" + str + " ]", 47, 46 + this.ados - this.scro);
                            }
                            this.rdo.setFont(new Font("Tahoma", 1, 11));
                            this.rdo.setColor(new Color(0, 0, 0));
                            this.rdo.drawString("" + this.conclan[this.eng] + " has attained its points from clan wars:", 27, 70 + this.ados - this.scro);
                            this.rdo.setFont(new Font("Tahoma", 0, 11));
                            for (byte b1 = 0; b1 < this.nvc[this.eng]; b1++) {
                                str = "s";
                                if (this.points[this.eng][b1] == 1) str = "";
                                this.rdo.drawString("Versus clan " + this.verclan[this.eng][b1] + ":  [ " + this.points[this.eng][b1] + " point" + str + " ]", 47, 87 + this.ados + b1 * 17 - this.scro);
                            }
                            this.rdo.setFont(new Font("Tahoma", 1, 11));
                            this.rdo.setColor(new Color(0, 0, 0));
                            this.rdo.drawString("Total attained points:  [ " + this.totp[this.eng] + " ]", 47, 87 + this.ados + this.nvc[this.eng] * 17 - this.scro);
                        } else if (Math.abs(this.engo - 15) < 20) {
                            this.engo = 15;
                        } else if (this.engo < 15) {
                            this.engo += 20;
                        } else {
                            this.engo -= 20;
                        }
                        if (!drawl(this.rdo, "#" + this.conclan[this.eng] + "#", 21, this.engo - this.scro, true)) {
                            this.rdo.setColor(new Color(100, 77, 31));
                            this.rdo.drawRect(21, this.engo - this.scro, 349, 29);
                            this.rdo.setFont(new Font("Arial", 1, 13));
                            this.ftm = this.rdo.getFontMetrics();
                            this.rdo.drawString(this.conclan[this.champ], 196 - this.ftm.stringWidth(this.conclan[this.champ]) / 2, this.engo + 19 - this.scro);
                        }
                        if (this.engo == 15) {
                            this.darker = true;
                            if (!this.xt.clan.equals("") && !this.xt.clan.toLowerCase().equals(this.conclan[this.eng].toLowerCase()) && stringbutton(this.rdo, "   Declare War  >   ", 459, 176, 1, paramInt1, paramInt2, paramBoolean, 216, 139)) {
                                this.tab = 2;
                                this.itab = 1;
                                this.litab = -1;
                                this.openi = 10;
                                this.viewgame2 = 0;
                                if (!this.intclan.equals(this.conclan[this.eng])) {
                                    this.intclan = this.conclan[this.eng];
                                    this.dispi = 0;
                                    this.nil = 0;
                                    this.lastint = "";
                                    this.readint = 1;
                                }
                                this.redif = true;
                                this.intsel = 4;
                                this.eng = -1;
                                this.spos6 = this.lspos6w;
                            }
                            if (stringbutton(this.rdo, "   <  Back   ", 480, 110, 1, paramInt1, paramInt2, paramBoolean, 216, 139)) {
                                this.eng = -1;
                                this.spos6 = this.lspos6w;
                            }
                            this.darker = false;
                        }
                    }
                } else {
                    this.sdist = 0;
                }
                if (this.loadwstat == 0) {
                    this.rdo.setFont(new Font("Tahoma", 1, 11));
                    this.ftm = this.rdo.getFontMetrics();
                    this.rdo.setColor(new Color(0, 0, 0));
                    this.rdo.drawString("Loading championship, please wait...", 280 - this.ftm.stringWidth("Loading championship, please wait...") / 2, 140);
                }
                if (this.loadwstat == -1) {
                    this.rdo.setFont(new Font("Tahoma", 1, 11));
                    this.ftm = this.rdo.getFontMetrics();
                    this.rdo.setColor(new Color(0, 0, 0));
                    this.rdo.drawString("Failed to load championship, please try again later...", 280 - this.ftm.stringWidth("Failed to load championship, please try again later...") / 2, 140);
                }
            }
            if (this.ntab == 2) {
                this.rdo.setFont(new Font("Tahoma", 1, 11));
                this.ftm = this.rdo.getFontMetrics();
                this.rdo.setColor(new Color(0, 0, 0));
                this.rdo.drawString("About the Championship", 280 - this.ftm.stringWidth("About the Championship") / 2, 40);
                this.rdo.setFont(new Font("Tahoma", 0, 11));
                this.rdo.drawString("The clan wars world championship is ongoing championship that does not end!", 7, 70);
                this.rdo.drawString("Every clan always has a chance to claim & re-claim the championship title from the current winner.", 7, 85);
                this.rdo.drawString("The champion clan is the clan that is at the current moment attaining the most points.", 7, 115);
                this.rdo.drawString("Clans get points by defeating other clans in wars, but not every clan you defeat earns you the same amount of", 7, 130);
                this.rdo.drawString("points. It depends on how much points that clan has and from which wars where these points attained.", 7, 145);
                this.rdo.drawString("The points system is designed to deliver a fair & balanced championship that is also fun, exiting and never ending!", 7, 160);
                this.rdo.setFont(new Font("Tahoma", 1, 11));
                this.rdo.drawString("Currently there are no rewards in the game for claiming or re-claiming the championship title, but", 7, 190);
                this.rdo.drawString("in the coming updates there will be rewards that can be used to 'super power' clan cars!", 7, 205);
                this.rdo.setFont(new Font("Tahoma", 0, 11));
                this.rdo.drawString("Stay tuned for the rewards system to come!", 7, 220);
                this.rdo.setFont(new Font("Tahoma", 1, 11));
                this.ftm = this.rdo.getFontMetrics();
                this.rdo.drawString("Good Luck!", 280 - this.ftm.stringWidth("Good Luck!") / 2, 250);
                this.darker = true;
                if (stringbutton(this.rdo, "   <  Back   ", 280, 280, 1, paramInt1, paramInt2, paramBoolean, 216, 139))
                    this.ntab = 1;
                this.darker = false;
            }
            if (this.sdist != 0) {
                byte b1 = 27;
                this.rdo.setColor(color2k(200, 200, 200));
                this.rdo.fillRect(540, 20, 17, 260);
                if (this.mscro5 == 831) {
                    this.rdo.setColor(color2k(215, 215, 215));
                    this.rdo.fillRect(540, 3, 17, 17);
                } else {
                    this.rdo.setColor(color2k(220, 220, 220));
                    this.rdo.fill3DRect(540, 3, 17, 17, true);
                }
                this.rdo.drawImage(this.xt.asu, 545, 9, (ImageObserver) null);
                if (this.mscro5 == 832) {
                    this.rdo.setColor(color2k(215, 215, 215));
                    this.rdo.fillRect(540, 280, 17, 17);
                } else {
                    this.rdo.setColor(color2k(220, 220, 220));
                    this.rdo.fill3DRect(540, 280, 17, 17, true);
                }
                this.rdo.drawImage(this.xt.asd, 545, 287, (ImageObserver) null);
                if (this.lspos6 != this.spos6) {
                    this.rdo.setColor(color2k(215, 215, 215));
                    this.rdo.fillRect(540, 20 + this.spos6, 17, 31);
                } else {
                    if (this.mscro5 == 831) this.rdo.setColor(color2k(215, 215, 215));
                    this.rdo.fill3DRect(540, 20 + this.spos6, 17, 31, true);
                }
                this.rdo.setColor(color2k(150, 150, 150));
                this.rdo.drawLine(545, 33 + this.spos6, 551, 33 + this.spos6);
                this.rdo.drawLine(545, 35 + this.spos6, 551, 35 + this.spos6);
                this.rdo.drawLine(545, 37 + this.spos6, 551, 37 + this.spos6);
                if (this.mscro5 > 800 && this.lspos6 != this.spos6) this.lspos6 = this.spos6;
                if (paramBoolean) {
                    if (this.mscro5 == 825 && paramInt1 > 756 && paramInt1 < 773 && paramInt2 > 132 + b1 + this.spos6 && paramInt2 < this.spos6 + b1 + 163)
                        this.mscro5 = paramInt2 - this.spos6;
                    if (this.mscro5 == 825 && paramInt1 > 754 && paramInt1 < 775 && paramInt2 > 26 + b1 && paramInt2 < 134 + b1)
                        this.mscro5 = 831;
                    if (this.mscro5 == 825 && paramInt1 > 754 && paramInt1 < 775 && paramInt2 > 390 + b1 && paramInt2 < 411 + b1)
                        this.mscro5 = 832;
                    if (this.mscro5 == 825 && paramInt1 > 756 && paramInt1 < 773 && paramInt2 > 132 + b1 && paramInt2 < 392 + b1) {
                        this.mscro5 = 152 + b1;
                        this.spos6 = paramInt2 - this.mscro5;
                    }
                    int m = 2670 / this.sdist;
                    if (m < 1) m = 1;
                    if (this.mscro5 == 831) {
                        this.spos6 -= m;
                        if (this.spos6 > 229) this.spos6 = 229;
                        if (this.spos6 < 0) this.spos6 = 0;
                        this.lspos6 = this.spos6;
                    }
                    if (this.mscro5 == 832) {
                        this.spos6 += m;
                        if (this.spos6 > 229) this.spos6 = 229;
                        if (this.spos6 < 0) this.spos6 = 0;
                        this.lspos6 = this.spos6;
                    }
                    if (this.mscro5 < 800) {
                        this.spos6 = paramInt2 - this.mscro5;
                        if (this.spos6 > 229) this.spos6 = 229;
                        if (this.spos6 < 0) this.spos6 = 0;
                    }
                    if (this.mscro5 == 825) this.mscro5 = 925;
                } else if (this.mscro5 != 825) {
                    this.mscro5 = 825;
                }
            }
            this.rd.drawImage(this.gImage, 216, 139, (ImageObserver) null);
        }
        if (this.cfase == 1) if (this.xt.logged) {
            if (this.xt.clan.equals("")) {
                this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                this.rd.setColor(new Color(255, 255, 255));
                this.rd.fillRoundRect(232, 90, 527, 176, 20, 20);
                this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRoundRect(232, 90, 527, 176, 20, 20);
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (this.flko % 4 != 0 || this.flko == 0)
                    this.rd.drawString(this.msg, 495 - this.ftm.stringWidth(this.msg) / 2, 120);
                if (this.flko != 0) this.flko--;
                this.rd.drawString("Clan name :", 462 - this.ftm.stringWidth("Clan name :"), 156);
                this.donewc = true;
                if (this.em != 1) {
                    if (stringbutton(this.rd, "     Create     ", 495, 204, 0, paramInt1, paramInt2, paramBoolean, 0, 0))
                        if (!this.gs.temail.getText().equals("")) {
                            this.em = 1;
                        } else {
                            this.msg = "Please enter a clan name!";
                            this.flko = 45;
                        }
                    if (stringbutton(this.rd, " Cancel ", 495, 244, 2, paramInt1, paramInt2, paramBoolean, 0, 0))
                        this.cfase = 0;
                } else {
                    this.rd.drawString("Creating, please wait...", 495 - this.ftm.stringWidth("Creating, please wait...") / 2, 224);
                }
            } else {
                this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
                this.rd.setColor(new Color(255, 255, 255));
                this.rd.fillRoundRect(232, 90, 527, 136, 20, 20);
                this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRoundRect(232, 90, 527, 136, 20, 20);
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                this.rd.drawString("You are already a member of a clan (" + this.xt.clan + ").", 495 - this.ftm.stringWidth("You are already a member of a clan (" + this.xt.clan + ").") / 2, 120);
                this.rd.drawString("You need to leave your clan first in order to create a new one.", 495 - this.ftm.stringWidth("You need to leave your clan first in order to create a new one.") / 2, 140);
                if (stringbutton(this.rd, "   OK   ", 495, 204, 0, paramInt1, paramInt2, paramBoolean, 0, 0))
                    this.cfase = 0;
            }
        } else {
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
            this.rd.setColor(new Color(255, 255, 255));
            this.rd.fillRoundRect(232, 90, 527, 176, 20, 20);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(232, 90, 527, 176, 20, 20);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("You are currently using a trial account.", 495 - this.ftm.stringWidth("You are currently using a trial account.") / 2, 120);
            this.rd.drawString("You need to upgrade to be able participate in any NFM clan activity.", 495 - this.ftm.stringWidth("You need to upgrade to be able participate in any NFM clan activity.") / 2, 140);
            this.rd.setColor(new Color(206, 171, 98));
            this.rd.fillRoundRect(405, 163, 180, 50, 20, 20);
            if (drawbutton(this.xt.upgrade, 495, 188, paramInt1, paramInt2, paramBoolean))
                this.gs.editlink(this.xt.nickname, true);
            if (stringbutton(this.rd, " Cancel ", 495, 244, 2, paramInt1, paramInt2, paramBoolean, 0, 0))
                this.cfase = 0;
        }
        if (this.cfase == 2) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            if (this.flko % 4 != 0 || this.flko == 0)
                this.rd.drawString(this.msg, 495 - this.ftm.stringWidth(this.msg) / 2, 60);
            if (this.flko != 0) this.flko--;
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
            this.rd.setColor(new Color(255, 255, 255));
            this.rd.fillRoundRect(197, 73, 597, 371, 20, 20);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(197, 73, 597, 371, 20, 20);
            this.dosrch = true;
            this.darker = true;
            if (stringbutton(this.rd, "   Search   ", 579, 104, 2, paramInt1, paramInt2, paramBoolean, 0, 0))
                if (!this.gs.temail.getText().equals("")) {
                    this.em = 2;
                    this.smsg = "Searching for '" + this.gs.temail.getText() + "' in clans...";
                    this.nclns = 0;
                    this.spos5 = 0;
                    this.lspos5 = 0;
                } else {
                    this.msg = "Please enter a search phrase!";
                    this.flko = 45;
                }
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Arial", 1, 13));
            this.rd.drawString(this.smsg, 218, 135);
            if (stringbutton(this.rd, " <   Back to Main  ", 725, 60, 2, paramInt1, paramInt2, paramBoolean, 0, 0))
                this.cfase = 0;
            this.darker = false;
            this.rdo.setColor(new Color(206, 171, 98));
            this.rdo.fillRect(0, 0, 560, 300);
            this.sdist = (int) ((this.nclns - 4.5F) * 55.0F);
            if (this.sdist < 0 || this.nclns == 0) this.sdist = 0;
            this.scro = (int) (this.spos5 / 229.0F * this.sdist);
            this.rdo.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            byte b;
            for (b = 0; b < this.nclns; b++) {
                if (60 + b * 55 - this.scro > 0 && 20 + b * 55 - this.scro < 300) {
                    boolean bool = true;
                    if (paramInt1 > 308 && paramInt1 < 683 && paramInt2 > 159 + b * 55 - this.scro && paramInt2 < 199 + b * 55 - this.scro) {
                        this.cur = 12;
                        bool = false;
                        if (paramBoolean) {
                            if (!this.claname.equals(this.clanlo[b])) {
                                this.claname = this.clanlo[b];
                                this.loadedc = false;
                            }
                            this.spos5 = 0;
                            this.lspos5 = 0;
                            this.cfase = 3;
                            this.ctab = 0;
                        }
                    }
                    this.rdo.setColor(new Color(0, 0, 0));
                    this.rdo.drawRoundRect(92, 20 + b * 55 - this.scro, 375, 40, 20, 20);
                    if (!drawl(this.rdo, "#" + this.clanlo[b] + "#", 105, 25 + b * 55 - this.scro, bool) || !bool)
                        this.rdo.drawString("" + this.clanlo[b] + "", 280 - this.ftm.stringWidth("" + this.clanlo[b] + "") / 2, 45 + b * 55 - this.scro);
                }
            }
            if (this.sdist != 0) {
                b = 27;
                this.rdo.setColor(color2k(200, 200, 200));
                this.rdo.fillRect(540, 20, 17, 260);
                if (this.mscro5 == 831) {
                    this.rdo.setColor(color2k(215, 215, 215));
                    this.rdo.fillRect(540, 3, 17, 17);
                } else {
                    this.rdo.setColor(color2k(220, 220, 220));
                    this.rdo.fill3DRect(540, 3, 17, 17, true);
                }
                this.rdo.drawImage(this.xt.asu, 545, 9, (ImageObserver) null);
                if (this.mscro5 == 832) {
                    this.rdo.setColor(color2k(215, 215, 215));
                    this.rdo.fillRect(540, 280, 17, 17);
                } else {
                    this.rdo.setColor(color2k(220, 220, 220));
                    this.rdo.fill3DRect(540, 280, 17, 17, true);
                }
                this.rdo.drawImage(this.xt.asd, 545, 287, (ImageObserver) null);
                if (this.lspos5 != this.spos5) {
                    this.rdo.setColor(color2k(215, 215, 215));
                    this.rdo.fillRect(540, 20 + this.spos5, 17, 31);
                } else {
                    if (this.mscro5 == 831) this.rdo.setColor(color2k(215, 215, 215));
                    this.rdo.fill3DRect(540, 20 + this.spos5, 17, 31, true);
                }
                this.rdo.setColor(color2k(150, 150, 150));
                this.rdo.drawLine(545, 33 + this.spos5, 551, 33 + this.spos5);
                this.rdo.drawLine(545, 35 + this.spos5, 551, 35 + this.spos5);
                this.rdo.drawLine(545, 37 + this.spos5, 551, 37 + this.spos5);
                if (this.mscro5 > 800 && this.lspos5 != this.spos5) this.lspos5 = this.spos5;
                if (paramBoolean) {
                    if (this.mscro5 == 825 && paramInt1 > 756 && paramInt1 < 773 && paramInt2 > 132 + b + this.spos5 && paramInt2 < this.spos5 + b + 163)
                        this.mscro5 = paramInt2 - this.spos5;
                    if (this.mscro5 == 825 && paramInt1 > 754 && paramInt1 < 775 && paramInt2 > 26 + b && paramInt2 < 134 + b)
                        this.mscro5 = 831;
                    if (this.mscro5 == 825 && paramInt1 > 754 && paramInt1 < 775 && paramInt2 > 390 + b && paramInt2 < 411 + b)
                        this.mscro5 = 832;
                    if (this.mscro5 == 825 && paramInt1 > 756 && paramInt1 < 773 && paramInt2 > 132 + b && paramInt2 < 392 + b) {
                        this.mscro5 = 152 + b;
                        this.spos5 = paramInt2 - this.mscro5;
                    }
                    int i = 2670 / this.sdist;
                    if (i < 1) i = 1;
                    if (this.mscro5 == 831) {
                        this.spos5 -= i;
                        if (this.spos5 > 229) this.spos5 = 229;
                        if (this.spos5 < 0) this.spos5 = 0;
                        this.lspos5 = this.spos5;
                    }
                    if (this.mscro5 == 832) {
                        this.spos5 += i;
                        if (this.spos5 > 229) this.spos5 = 229;
                        if (this.spos5 < 0) this.spos5 = 0;
                        this.lspos5 = this.spos5;
                    }
                    if (this.mscro5 < 800) {
                        this.spos5 = paramInt2 - this.mscro5;
                        if (this.spos5 > 229) this.spos5 = 229;
                        if (this.spos5 < 0) this.spos5 = 0;
                    }
                    if (this.mscro5 == 825) this.mscro5 = 925;
                } else if (this.mscro5 != 825) {
                    this.mscro5 = 825;
                }
            }
            this.rd.drawImage(this.gImage, 216, 139, (ImageObserver) null);
        }
        if (this.cfase == 3) {
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.4F));
            this.rd.setColor(new Color(255, 255, 255));
            this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
            this.rd.setFont(new Font("Arial", 1, 13));
            this.ftm = this.rd.getFontMetrics();
            if (this.loadedc) {
                byte b = -1;
                byte b1;
                for (b1 = 0; b1 < this.nmb; ) {
                    if (this.member[b1].toLowerCase().equals(this.xt.nickname.toLowerCase()) && (this.mlevel[b1] == 7 || b1 == 0))
                        b = b1;
                    b1++;
                }
                b1 = 0;
                if (paramInt1 > 197 && paramInt1 < 563 && paramInt2 > 40 && paramInt2 < 83 && this.editc == 0) b1 = 1;
                boolean bool = drawl(this.rd, "#" + this.claname + "#", 206, 47, (b1 == 0));
                if (!bool || b1 != 0) {
                    this.rd.drawString("Clan :  " + this.claname + "", 381 - this.ftm.stringWidth("Clan :  " + this.claname + "") / 2, 67);
                    if (b != -1) {
                        this.rd.setFont(new Font("Arial", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Edit Logo", 505, 74);
                        this.rd.drawLine(505, 76, 505 + this.ftm.stringWidth("Edit Logo"), 76);
                        if (paramInt1 > 505 && paramInt1 < 505 + this.ftm.stringWidth("Edit Logo") && paramInt2 > 62 && paramInt2 < 77 && this.editc == 0) {
                            this.cur = 12;
                            if (paramBoolean) {
                                this.editc = 1;
                                this.msg = "Edit Clan's Logo Image";
                                this.flko = 0;
                            }
                        }
                    }
                }
                this.rd.drawLine(563, 40, 563, 83);
                this.rd.drawLine(563, 83, 197, 83);
                if (stringbutton(this.rd, "   <   Back to Main  ", 688, 69, 1, paramInt1, paramInt2, paramBoolean, 0, 0))
                    this.cfase = 0;
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                int i = 220, j = this.ftm.stringWidth("Members");
                if (this.ctab != 0) this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
                this.rd.drawString("Members", i, 107);
                if (this.ctab != 0) this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                if (paramInt1 > i && paramInt1 < i + j && paramInt2 > 90 && paramInt2 < 109 && this.editc == 0) {
                    this.rd.drawLine(i, 109, i + j, 109);
                    this.cur = 12;
                    if (paramBoolean) this.ctab = 0;
                }
                i += j + 20;
                j = this.ftm.stringWidth("Cars");
                if (this.ctab != 2) this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
                this.rd.drawString("Cars", i, 107);
                if (this.ctab != 2) this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                if (paramInt1 > i && paramInt1 < i + j && paramInt2 > 90 && paramInt2 < 109 && this.editc == 0 && !this.notclan) {
                    this.rd.drawLine(i, 109, i + j, 109);
                    this.cur = 12;
                    if (paramBoolean) {
                        this.ctab = 2;
                        this.loadedcars = -1;
                    }
                }
                i += j + 20;
                j = this.ftm.stringWidth("Stages");
                if (this.ctab != 3) this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
                this.rd.drawString("Stages", i, 107);
                if (this.ctab != 3) this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                if (paramInt1 > i && paramInt1 < i + j && paramInt2 > 90 && paramInt2 < 109 && this.editc == 0 && !this.notclan) {
                    this.rd.drawLine(i, 109, i + j, 109);
                    this.cur = 12;
                    if (paramBoolean) {
                        this.ctab = 3;
                        this.loadedstages = -1;
                    }
                }
                i += j + 20;
                j = this.ftm.stringWidth("Interact");
                if (this.ctab != 1) this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
                this.rd.drawString("Interact", i, 107);
                if (this.ctab != 1) this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                if (paramInt1 > i && paramInt1 < i + j && paramInt2 > 90 && paramInt2 < 109 && this.editc == 0 && !this.notclan) {
                    this.rd.drawLine(i, 109, i + j, 109);
                    this.cur = 12;
                    if (paramBoolean) this.ctab = 1;
                }
                i += j + 20;
                j = this.ftm.stringWidth("Web Presence");
                if (this.ctab != 4) this.rd.setComposite(AlphaComposite.getInstance(3, 0.6F));
                this.rd.drawString("Web Presence", i, 107);
                if (this.ctab != 4) this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                if (paramInt1 > i && paramInt1 < i + j && paramInt2 > 90 && paramInt2 < 109 && this.editc == 0 && !this.notclan) {
                    this.rd.drawLine(i, 109, i + j, 109);
                    this.cur = 12;
                    if (paramBoolean) {
                        this.ctab = 4;
                        this.loadedlink = false;
                    }
                }
                this.rdo.setColor(new Color(206, 171, 98));
                this.rdo.fillRect(0, 0, 560, 300);
                if (this.clanbgl) this.rdo.drawImage(this.clanbg, 0, 0, (ImageObserver) null);
                if (this.notclan) {
                    this.rdo.setColor(new Color(0, 0, 0));
                    this.rdo.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rdo.getFontMetrics();
                    this.rdo.drawString("[  Clan Removed  ]", 280 - this.ftm.stringWidth("[  Clan Removed  ]") / 2, 40);
                    this.rdo.drawString("This clan has been abandoned by its members and no longer exists...", 280 - this.ftm.stringWidth("This clan has been abandoned by its members and no longer exists...") / 2, 140);
                }
                if (b != -1 && paramInt1 > 216 && paramInt1 < 776 && paramInt2 > 92 && paramInt2 < 412 && this.editc == 0) {
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Edit Background", 688, 107);
                    this.rd.drawLine(688, 109, 688 + this.ftm.stringWidth("Edit Background"), 109);
                    if (paramInt1 > 688 && paramInt1 < 688 + this.ftm.stringWidth("Edit Background") && paramInt2 > 95 && paramInt2 < 110 && this.editc == 0) {
                        this.cur = 12;
                        if (paramBoolean) {
                            this.editc = 2;
                            this.msg = "Edit Clan's Background Display Image";
                            this.flko = 0;
                        }
                    }
                }
                if (this.ctab == 0) if (!this.showreqs) {
                    this.sdist = (int) ((this.nmb - 4.0F) * 55.0F);
                    if (this.sdist < 0 || this.nmb < 5) this.sdist = 0;
                } else {
                    this.sdist = (int) ((this.nrmb - 4.0F) * 40.0F);
                    if (this.sdist < 0) this.sdist = 0;
                }
                if (this.ctab == 1 || this.ctab == 2 || this.ctab == 3 || this.ctab == 4) {
                    this.sdist = 0;
                    if (this.sdist < 0) this.sdist = 0;
                }
                this.scro = (int) (this.spos5 / 229.0F * this.sdist);
                if (this.ctab == 0) if (!this.showreqs) {
                    byte b2 = 0;
                    for (byte b3 = 0; b3 < this.nmb; b3++) {
                        boolean bool1;
                        byte b4;
                        for (bool1 = false, b4 = 0; b4 < this.npo; ) {
                            if (this.member[b3].toLowerCase().equals(this.pname[b4].toLowerCase())) {
                                bool1 = true;
                                b2++;
                            }
                            b4++;
                        }
                        if (60 + b3 * 55 - this.scro > 0 && 20 + b3 * 55 - this.scro < 300) {
                            b4 = 0;
                            float f = 0.5F;
                            if (paramInt1 > 266 && paramInt1 < 726 && paramInt2 > 132 + b3 * 55 - this.scro && paramInt2 < 172 + b3 * 55 - this.scro && this.editc == 0) {
                                f = 0.8F;
                                if (b3 >= b && b != -1) b4 = 1;
                                if (this.xt.nickname.toLowerCase().equals(this.member[b3].toLowerCase()) && b4 == 0)
                                    b4 = 2;
                            }
                            this.rdo.setComposite(AlphaComposite.getInstance(3, f));
                            this.rdo.setColor(new Color(255, 255, 255));
                            this.rdo.fillRoundRect(50, 20 + b3 * 55 - this.scro, 460, 40, 20, 20);
                            this.rdo.setColor(new Color(0, 0, 0));
                            if (bool1) this.rdo.setColor(new Color(123, 200, 0));
                            this.rdo.drawRoundRect(50, 20 + b3 * 55 - this.scro, 460, 40, 20, 20);
                            this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                            boolean bool2 = false;
                            boolean bool3 = false;
                            if (paramInt1 > 276 && paramInt1 < 396 && paramInt2 > 137 + b3 * 55 - this.scro && paramInt2 < 167 + b3 * 55 - this.scro && paramInt2 > 112 && paramInt2 < 412 && this.editc == 0) {
                                bool3 = true;
                                this.cur = 12;
                                if (paramBoolean) {
                                    this.tab = 1;
                                    if (!this.proname.equals(this.member[b3])) {
                                        this.proname = this.member[b3];
                                        this.loadedp = false;
                                        onexitpro();
                                    }
                                }
                            }
                            if (!bool3) {
                                bool2 = drawl(this.rdo, this.member[b3], 60, 25 + b3 * 55 - this.scro, true);
                            } else {
                                drawl(this.rdo, this.member[b3], 60, 25 + b3 * 55 - this.scro, false);
                            }
                            if (!bool2) {
                                this.rdo.setComposite(AlphaComposite.getInstance(3, 0.5F));
                                this.rdo.setColor(new Color(255, 255, 255));
                                this.rdo.fillRect(60, 25 + b3 * 55 - this.scro, 119, 29);
                                this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                                this.rdo.setColor(new Color(0, 0, 0));
                                this.rdo.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rdo.getFontMetrics();
                                this.rdo.drawRect(60, 25 + b3 * 55 - this.scro, 119, 29);
                                this.rdo.drawString(this.member[b3], 120 - this.ftm.stringWidth(this.member[b3]) / 2, 44 + b3 * 55 - this.scro);
                            }
                            this.rdo.setColor(new Color(0, 0, 0));
                            this.rdo.setFont(new Font("Arial", 1, 11));
                            this.ftm = this.rdo.getFontMetrics();
                            String str = "";
                            if (b3 == 0) {
                                str = "  ( Clan Leader / Admin )";
                            } else if (this.mlevel[b3] == 7) {
                                str = "  ( Admin )";
                            }
                            this.rdo.drawString("Level :  " + this.mlevel[b3] + "" + str + "", 190, 36 + b3 * 55 - this.scro);
                            this.rdo.drawString("Rank :  " + this.mrank[b3] + "", 190, 52 + b3 * 55 - this.scro);
                            if (b4 != 0) {
                                if (b4 == 1) {
                                    this.rdo.drawString("Edit", 424, 36 + b3 * 55 - this.scro);
                                    this.rdo.drawLine(424, 38 + b3 * 55 - this.scro, 424 + this.ftm.stringWidth("Edit"), 38 + b3 * 55 - this.scro);
                                    if (paramInt1 > 640 && paramInt1 < 640 + this.ftm.stringWidth("Edit") && paramInt2 > 136 + b3 * 55 - this.scro && paramInt2 < 151 + b3 * 55 - this.scro && this.editc == 0) {
                                        this.cur = 12;
                                        if (paramBoolean) {
                                            this.em = b3;
                                            this.editc = 3;
                                        }
                                    }
                                }
                                String str1 = "Remove";
                                if (this.xt.nickname.toLowerCase().equals(this.member[b3].toLowerCase()))
                                    str1 = "Leave";
                                this.rdo.drawString(str1, 454, 36 + b3 * 55 - this.scro);
                                this.rdo.drawLine(454, 38 + b3 * 55 - this.scro, 454 + this.ftm.stringWidth(str1), 38 + b3 * 55 - this.scro);
                                if (paramInt1 > 670 && paramInt1 < 670 + this.ftm.stringWidth(str1) && paramInt2 > 136 + b3 * 55 - this.scro && paramInt2 < 151 + b3 * 55 - this.scro && this.editc == 0) {
                                    this.cur = 12;
                                    if (paramBoolean) {
                                        this.em = b3;
                                        this.editc = 4;
                                    }
                                }
                            } else if (bool1) {
                                this.rdo.setColor(new Color(49, 79, 0));
                                this.rdo.drawString("Online", 454, 36 + b3 * 55 - this.scro);
                            }
                        }
                    }
                    if (this.nmb == 1 && b != -1) {
                        float f = 0.5F;
                        if (paramInt1 > 266 && paramInt1 < 726 && paramInt2 > 187 - this.scro && paramInt2 < 287 - this.scro && this.editc == 0)
                            f = 0.8F;
                        this.rdo.setComposite(AlphaComposite.getInstance(3, f));
                        this.rdo.setColor(new Color(255, 255, 255));
                        this.rdo.fillRoundRect(50, 75 - this.scro, 460, 100, 20, 20);
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawRoundRect(50, 75 - this.scro, 460, 100, 20, 20);
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        this.rdo.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rdo.getFontMetrics();
                        this.rdo.drawString("Welcome to your clan " + this.claname + "!", 60, 91 - this.scro);
                        this.rdo.drawString("Now you will need to invite other players to join this clan.", 60, 121 - this.scro);
                        this.rdo.drawString("To invite, visit a player's profile and in the clan area click 'Invite to Join...'.", 60, 136 - this.scro);
                        this.rdo.drawString("(That is if the player is not already a member of another clan).", 60, 151 - this.scro);
                        this.rdo.drawString("The maximum number of members a clan can have is 20.", 60, 166 - this.scro);
                    } else if (this.nmb > 1) {
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 0.8F));
                        this.rdo.setColor(new Color(255, 255, 255));
                        this.rdo.fillRoundRect(212, 20 + this.nmb * 55 - this.scro, 136, 27, 20, 20);
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawRoundRect(212, 20 + this.nmb * 55 - this.scro, 136, 27, 20, 20);
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        this.rdo.setFont(new Font("Arial", 1, 11));
                        this.ftm = this.rdo.getFontMetrics();
                        this.rdo.drawString("" + b2 + " player(s) online", 280 - this.ftm.stringWidth("" + b2 + " player(s) online") / 2, 37 + this.nmb * 55 - this.scro);
                    }
                } else {
                    this.rdo.setComposite(AlphaComposite.getInstance(3, 0.8F));
                    this.rdo.setColor(new Color(244, 232, 204));
                    this.rdo.fillRoundRect(70, 20 - this.scro, 420, 80 + this.nrmb * 40, 20, 20);
                    this.rdo.setColor(new Color(0, 0, 0));
                    this.rdo.drawRoundRect(70, 20 - this.scro, 420, 80 + this.nrmb * 40, 20, 20);
                    this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    this.rdo.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rdo.getFontMetrics();
                    this.rdo.drawString("Membership Requests", 280 - this.ftm.stringWidth("Membership Requests") / 2, 45 - this.scro);
                    this.darker = true;
                    for (byte b2 = 0; b2 < this.nrmb; b2++) {
                        boolean bool1 = false;
                        boolean bool2 = false;
                        if (paramInt1 > 356 && paramInt1 < 476 && paramInt2 > 172 + b2 * 40 - this.scro && paramInt2 < 202 + b2 * 55 - this.scro && paramInt2 > 112 && paramInt2 < 412 && this.editc == 0) {
                            bool2 = true;
                            this.cur = 12;
                            if (paramBoolean) {
                                this.tab = 1;
                                if (!this.proname.equals(this.rmember[b2])) {
                                    this.proname = this.rmember[b2];
                                    this.loadedp = false;
                                    onexitpro();
                                }
                            }
                        }
                        if (!bool2) {
                            bool1 = drawl(this.rdo, this.rmember[b2], 140, 60 + b2 * 40 - this.scro, true);
                        } else {
                            drawl(this.rdo, this.rmember[b2], 140, 60 + b2 * 40 - this.scro, false);
                        }
                        if (!bool1) {
                            this.rdo.setComposite(AlphaComposite.getInstance(3, 0.5F));
                            this.rdo.setColor(new Color(255, 255, 255));
                            this.rdo.fillRect(140, 60 + b2 * 40 - this.scro, 119, 29);
                            this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                            this.rdo.setColor(new Color(0, 0, 0));
                            this.rdo.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rdo.getFontMetrics();
                            this.rdo.drawRect(140, 60 + b2 * 40 - this.scro, 119, 29);
                            this.rdo.drawString(this.rmember[b2], 200 - this.ftm.stringWidth(this.rmember[b2]) / 2, 79 + b2 * 40 - this.scro);
                        }
                        if (stringbutton(this.rdo, "  Approve  ", 310, 79 + b2 * 40 - this.scro, 3, paramInt1, paramInt2, (paramBoolean && this.editc == 0), 216, 112)) {
                            this.em = b2;
                            this.editc = 66;
                        }
                        if (stringbutton(this.rdo, "  Deny  ", 391, 79 + b2 * 40 - this.scro, 3, paramInt1, paramInt2, (paramBoolean && this.editc == 0), 216, 112)) {
                            this.em = b2;
                            this.editc = 77;
                        }
                    }
                    if (stringbutton(this.rdo, "    Decide Later    ", 280, 80 + this.nrmb * 40 - this.scro, 1, paramInt1, paramInt2, (paramBoolean && this.editc == 0), 216, 112)) {
                        this.spos5 = 0;
                        this.lspos5 = 0;
                        this.showreqs = false;
                    }
                    this.darker = false;
                }
                if (this.ctab == 1) {
                    this.rdo.setComposite(AlphaComposite.getInstance(3, 0.25F));
                    this.rdo.setColor(new Color(255, 255, 255));
                    this.rdo.fillRoundRect(20, 246, 520, 39, 20, 20);
                    this.rdo.setColor(new Color(0, 0, 0));
                    this.rdo.drawRoundRect(20, 246, 520, 39, 20, 20);
                    this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    if (this.xt.clan.toLowerCase().equals(this.claname.toLowerCase())) {
                        if (stringbutton(this.rdo, "       Open your clan's discussion       ", 280, 270, -1, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112)) {
                            this.tab = 2;
                            this.itab = 2;
                            this.litab = -1;
                        }
                    } else {
                        if (stringbutton(this.rdo, "       Declare war on " + this.claname + "       ", 162, 270, -1, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112)) {
                            this.tab = 2;
                            this.itab = 1;
                            this.litab = -1;
                            this.openi = 10;
                            this.viewgame2 = 0;
                            if (!this.intclan.equals(this.claname)) {
                                this.intclan = this.claname;
                                this.dispi = 0;
                                this.nil = 0;
                                this.lastint = "";
                                this.readint = 1;
                            }
                            this.redif = true;
                            this.intsel = 4;
                        }
                        if (stringbutton(this.rdo, "    Talk with " + this.claname + "    ", 422, 270, -1, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112)) {
                            this.tab = 2;
                            this.itab = 1;
                            this.litab = -1;
                            this.openi = 10;
                            this.viewgame2 = 0;
                            if (!this.intclan.equals(this.claname)) {
                                this.intclan = this.claname;
                                this.dispi = 0;
                                this.nil = 0;
                                this.lastint = "";
                                this.readint = 1;
                            }
                        }
                    }
                }
                if (this.ctab == 3) {
                    if (this.loadedstages != 1 && this.loadedstages != 5) {
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 0.7F));
                        this.rdo.setColor(new Color(255, 255, 255));
                        this.rdo.fillRoundRect(60, 70, 440, 100, 20, 20);
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawRoundRect(60, 70, 440, 100, 20, 20);
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    }
                    this.rdo.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rdo.getFontMetrics();
                    if (this.loadedstages == -2)
                        this.rdo.drawString("Failed to load clan stages, connection error, try again later...", 280 - this.ftm.stringWidth("Failed to load clan stages, connection error, try again later...") / 2, 125);
                    if (this.loadedstages == -1)
                        this.rdo.drawString("Loading clan stages, please wait...", 280 - this.ftm.stringWidth("Loading clan stages, please wait...") / 2, 125);
                    if (this.loadedstages == 0)
                        this.rdo.drawString("No custom clan stages have been added yet!", 280 - this.ftm.stringWidth("No custom clan stages have been added yet!") / 2, 125);
                    if (this.loadedstages == 2)
                        this.rdo.drawString("Searching for and loading stages created by you,  " + this.perry + "  ...", 280 - this.ftm.stringWidth("Searching for and loading stages created by you,  " + this.perry + "  ...") / 2, 125);
                    if (this.loadedstages == 3) {
                        this.rdo.drawString("Found no stages that can be added!", 280 - this.ftm.stringWidth("Found no stages that can be added!") / 2, 95);
                        this.rdo.drawString("Found no stages created by you that also do not already belong to a clan.", 280 - this.ftm.stringWidth("Found no stages created by you that also do not already belong to a clan.") / 2, 115);
                        if (stringbutton(this.rdo, " OK ", 280, 155, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                            this.loadedstages = -1;
                    }
                    if (this.loadedstages == 4) {
                        this.rdo.drawString("Failed to load stages created by you, connection error, try again later...", 280 - this.ftm.stringWidth("Failed to load stages created by you, connection error, try again later...") / 2, 110);
                        if (stringbutton(this.rdo, " OK ", 280, 140, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                            this.loadedstages = -1;
                    }
                    if (this.loadedstages == 6)
                        this.rdo.drawString("Adding stage to your clan's stages, please wait...", 280 - this.ftm.stringWidth("Adding stage to your clan's stages, please wait...") / 2, 125);
                    if (this.loadedstages == 7) {
                        this.rdo.drawString("Failed to add stage, server error, try again later...", 280 - this.ftm.stringWidth("Failed to add stage, server error, try again later...") / 2, 110);
                        if (stringbutton(this.rdo, " OK ", 280, 140, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                            this.loadedstages = -1;
                    }
                    if (this.loadedstages == 8)
                        this.rdo.drawString("Removing stage from your clan's cars, please wait...", 280 - this.ftm.stringWidth("Removing stage from your clan's cars, please wait...") / 2, 125);
                    if (this.loadedstages == 9) {
                        this.rdo.drawString("Failed to remove stage, server error, try again later...", 280 - this.ftm.stringWidth("Failed to remove stage, server error, try again later...") / 2, 110);
                        if (stringbutton(this.rdo, " OK ", 280, 140, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                            this.loadedstages = -1;
                    }
                    if (this.loadedstages == 10) {
                        this.rdo.drawString("Are you sure you want to remove this stage from your clan's stages?", 280 - this.ftm.stringWidth("Are you sure you want to remove this stage from your clan's stages?") / 2, 93);
                        if (stringbutton(this.rdo, "    Yes    ", 280, 128, -2, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                            this.loadedstages = 8;
                        if (stringbutton(this.rdo, "  No  ", 280, 158, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                            this.loadedstages = 1;
                    }
                    if (this.loadedstages == 5) {
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 0.7F));
                        this.rdo.setColor(new Color(255, 255, 255));
                        this.rdo.fillRoundRect(60, 58, 440, 162, 20, 20);
                        this.rdo.setColor(new Color(0, 0, 0));
                        this.rdo.drawRoundRect(60, 58, 440, 162, 20, 20);
                        this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                        this.rdo.drawString("Select a stage to add.", 280 - this.ftm.stringWidth("Select a stage to add.") / 2, 80);
                        this.gs.clcars.move(496 - this.gs.clcars.getWidth() / 2, 206);
                        if (this.editc == 0) {
                            if (!this.gs.clcars.isShowing()) {
                                this.gs.clcars.show();
                                this.gs.clcars.select(0);
                            }
                        } else {
                            this.gs.clcars.hide();
                        }
                        if (!this.gs.clcars.getSelectedItem().equals(this.selstage))
                            this.selstage = this.gs.clcars.getSelectedItem();
                        if (this.gs.clcars.open) this.blocknote = 20;
                        if (stringbutton(this.rdo, "     Add Stage     ", 280, 150, -2, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                            this.loadedstages = 6;
                        if (stringbutton(this.rdo, "  Cancel  ", 280, 200, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                            this.loadedstages = -1;
                    }
                    if (this.loadedstages == 1) {
                        if (this.editc == 0) {
                            if (!this.gs.clcars.isShowing()) {
                                this.gs.clcars.show();
                                this.selstage = this.gs.clcars.getSelectedItem();
                            }
                        } else {
                            this.gs.clcars.hide();
                        }
                        this.gs.clcars.move(496 - this.gs.clcars.getWidth() / 2, 122);
                        if (!this.gs.clcars.getSelectedItem().equals(this.selstage)) {
                            this.selstage = this.gs.clcars.getSelectedItem();
                            this.loadedstage = 0;
                            this.addstage = 0;
                        }
                        if (this.gs.clcars.open) this.blocknote = 20;
                        if (!this.selstage.equals("Select Stage")) {
                            if (this.loadedstage > 0) {
                                this.m.trk = 3;
                                this.m.ih = 0;
                                this.m.iw = 0;
                                this.m.h = 300;
                                this.m.w = 560;
                                this.m.cx = 280;
                                this.m.cy = 150;
                                this.m.aroundtrack(this.cp);
                                this.rdo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                                byte b2;
                                int[] arrayOfInt1;
                                byte b3;
                                for (b2 = 0, arrayOfInt1 = new int[200], b3 = 0; b3 < this.gs.nob; ) {
                                    if ((this.co[b3]).dist != 0) {
                                        arrayOfInt1[b2] = b3;
                                        b2++;
                                    } else {
                                        this.co[b3].d(this.rdo);
                                    }
                                    b3++;
                                }
                                int arrayOfInt2[], k;
                                for (arrayOfInt2 = new int[b2], k = 0; k < b2; ) {
                                    arrayOfInt2[k] = 0;
                                    k++;
                                }
                                for (k = 0; k < b2; ) {
                                    for (int n = k + 1; n < b2; ) {
                                        if ((this.co[arrayOfInt1[k]]).dist != (this.co[arrayOfInt1[n]]).dist) {
                                            if ((this.co[arrayOfInt1[k]]).dist < (this.co[arrayOfInt1[n]]).dist) {
                                                arrayOfInt2[k] = arrayOfInt2[k] + 1;
                                            } else {
                                                arrayOfInt2[n] = arrayOfInt2[n] + 1;
                                            }
                                        } else if (n > k) {
                                            arrayOfInt2[k] = arrayOfInt2[k] + 1;
                                        } else {
                                            arrayOfInt2[n] = arrayOfInt2[n] + 1;
                                        }
                                        n++;
                                    }
                                    k++;
                                }
                                for (k = 0; k < b2; ) {
                                    for (byte b4 = 0; b4 < b2; ) {
                                        if (arrayOfInt2[b4] == k) this.co[arrayOfInt1[b4]].d(this.rdo);
                                        b4++;
                                    }
                                    k++;
                                }
                                this.rdo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                                this.m.trk = 0;
                                this.m.h = 450;
                                this.m.w = 800;
                                this.m.cx = 400;
                                this.m.cy = 225;
                                this.rdo.setComposite(AlphaComposite.getInstance(3, 0.5F));
                                this.rdo.setColor(new Color(255, 255, 255));
                                this.rdo.fillRoundRect(9, 44, 136, 39, 20, 20);
                                this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                                this.rdo.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rdo.getFontMetrics();
                                this.rdo.setColor(new Color(0, 0, 0));
                                this.rdo.drawString("Created/Published by", 17, 59);
                                k = 17 + this.ftm.stringWidth("Created/Published by") / 2 - this.ftm.stringWidth(this.cp.maker) / 2;
                                int m = k + this.ftm.stringWidth(this.cp.maker);
                                this.rdo.drawString(this.cp.maker, k, 74);
                                this.rdo.drawLine(k, 76, m, 76);
                                if (paramInt1 > k + 216 && paramInt1 < m + 216 && paramInt2 > 174 && paramInt2 < 188) {
                                    this.cur = 12;
                                    if (paramBoolean) {
                                        this.tab = 1;
                                        if (!this.proname.equals(this.cp.maker)) {
                                            this.proname = this.cp.maker;
                                            this.loadedp = false;
                                            onexitpro();
                                        }
                                    }
                                }
                                if ((b != -1 || this.cp.maker.toLowerCase().equals(this.xt.nickname.toLowerCase())) && stringbutton(this.rdo, " Remove X ", 510, 27, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                                    this.loadedstages = 10;
                                if (this.gs.clcars.getSelectedIndex() != this.gs.clcars.no - 1 && stringbutton(this.rdo, " Next > ", 520, 137, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                                    this.gs.clcars.sel++;
                                if (this.gs.clcars.getSelectedIndex() != 1 && stringbutton(this.rdo, " < Prev ", 40, 137, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                                    this.gs.clcars.sel--;
                                if (this.cp.pubt > 0) {
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(0, 0, 0));
                                    if (this.addstage == 2) {
                                        this.rd.drawString("Adding Stage...", 496 - this.ftm.stringWidth("Adding Stage...") / 2, 432);
                                        if (this.cd.staction == 0) this.addstage = 3;
                                        if (this.cd.staction == -2) this.addstage = 4;
                                        if (this.cd.staction == -3) this.addstage = 5;
                                        if (this.cd.staction == -1) this.addstage = 6;
                                    }
                                    if (this.addstage == 3)
                                        this.rd.drawString("[" + this.cd.onstage + "] has been added to your stages!", 496 - this.ftm.stringWidth("[" + this.cd.onstage + "] has been added to your stages!") / 2, 432);
                                    if (this.addstage == 4)
                                        this.rd.drawString("You already have this stage.", 496 - this.ftm.stringWidth("You already have this stage.") / 2, 432);
                                    if (this.addstage == 5)
                                        this.rd.drawString("Cannot add more then 20 stages to your account!", 496 - this.ftm.stringWidth("Cannot add more then 20 stages to your account!") / 2, 432);
                                    if (this.addstage == 6)
                                        this.rd.drawString("Failed to add stage!  Unknown error, please try again later.", 496 - this.ftm.stringWidth("Failed to add stage!  Unknown error, please try again later.") / 2, 432);
                                    if (this.addstage == 1) {
                                        String str = "Upgrade to a full account to add custom stages!";
                                        int n = 496 - this.ftm.stringWidth(str) / 2, i1 = n + this.ftm.stringWidth(str);
                                        this.rd.drawString(str, n, 432);
                                        if (this.waitlink != -1) this.rd.drawLine(n, 435, i1, 435);
                                        if (paramInt1 > n && paramInt1 < i1 && paramInt2 > 421 && paramInt2 < 435) {
                                            if (this.waitlink != -1) this.cur = 12;
                                            if (paramBoolean && this.waitlink == 0) {
                                                this.gs.editlink(this.xt.nickname, true);
                                                this.waitlink = -1;
                                            }
                                        }
                                        if (this.waitlink > 0) this.waitlink--;
                                    }
                                    if (this.addstage == 0 && this.xt.drawcarb(true, null, " Add to My Stages ", 437, 414, paramInt1, paramInt2, (paramBoolean && this.blocknote == 0)))
                                        if (this.xt.logged) {
                                            this.cd.onstage = this.selstage;
                                            this.cd.staction = 2;
                                            this.cd.sparkstageaction();
                                            this.addstage = 2;
                                        } else {
                                            this.addstage = 1;
                                            this.waitlink = 20;
                                        }
                                } else {
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString("Private Stage", 496 - this.ftm.stringWidth("Private Stage") / 2, 432);
                                }
                            }
                            if (this.loadedstage == 0) {
                                this.rdo.setComposite(AlphaComposite.getInstance(3, 0.7F));
                                this.rdo.setColor(new Color(255, 255, 255));
                                this.rdo.fillRoundRect(150, 100, 260, 40, 20, 20);
                                this.rdo.setColor(new Color(0, 0, 0));
                                this.rdo.drawRoundRect(150, 100, 260, 40, 20, 20);
                                this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                                this.rdo.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rdo.getFontMetrics();
                                this.rdo.setColor(new Color(0, 0, 0));
                                this.rdo.drawString("Loading...", 280 - this.ftm.stringWidth("Loading...") / 2, 125);
                            }
                            if (this.loadedstage == -1) {
                                this.rdo.setComposite(AlphaComposite.getInstance(3, 0.7F));
                                this.rdo.setColor(new Color(255, 255, 255));
                                this.rdo.fillRoundRect(50, 100, 460, 40, 20, 20);
                                this.rdo.setColor(new Color(0, 0, 0));
                                this.rdo.drawRoundRect(50, 100, 460, 40, 20, 20);
                                this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                                this.rdo.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rdo.getFontMetrics();
                                this.rdo.setColor(new Color(0, 0, 0));
                                this.rdo.drawString("Error loading stage, try again later...", 280 - this.ftm.stringWidth("Error loading stage, try again later...") / 2, 125);
                            }
                        }
                    }
                    if (this.loadedstages != 1 && this.loadedstages != 5 && this.gs.clcars.isShowing())
                        this.gs.clcars.hide();
                    if (this.xt.clan.toLowerCase().equals(this.claname.toLowerCase())) {
                        if (this.loadedstages >= 0 && this.loadedstages < 2)
                            if (stringbutton(this.rdo, "     Add a stage of yours to the clan's stages     ", 280, 286, -2, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112)) {
                                this.loadedstages = 2;
                                this.perry = "0 %";
                            }
                    } else if (this.loadedstages == 1 && !this.selstage.equals("Select Stage") && this.loadedstage > 0) {
                        if (stringbutton(this.rdo, "     Battle with clan over this stage!     ", 280, 286, -2, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112)) {
                            this.tab = 2;
                            this.itab = 1;
                            this.litab = -1;
                            this.openi = 10;
                            if (!this.intclan.equals(this.claname)) {
                                this.intclan = this.claname;
                                this.dispi = 0;
                                this.nil = 0;
                                this.lastint = "";
                                this.readint = 1;
                            }
                            this.redif = true;
                            this.intsel = 2;
                        }
                    }
                }
                if (this.ctab == 2) {
                    float f = 0.7F;
                    if (this.loadedcars == 1) f = 0.5F;
                    this.rdo.setComposite(AlphaComposite.getInstance(3, f));
                    this.rdo.setColor(new Color(255, 255, 255));
                    this.rdo.fillRoundRect(40, 20, 480, 245, 20, 20);
                    this.rdo.setColor(new Color(0, 0, 0));
                    this.rdo.drawRoundRect(40, 20, 480, 245, 20, 20);
                    this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    this.rdo.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rdo.getFontMetrics();
                    if (this.loadedcars == -2)
                        this.rdo.drawString("Failed to load clan cars, connection error, try again later...", 280 - this.ftm.stringWidth("Failed to load clan cars, connection error, try again later...") / 2, 125);
                    if (this.loadedcars == -1)
                        this.rdo.drawString("Loading clan cars, please wait...", 280 - this.ftm.stringWidth("Loading clan cars, please wait...") / 2, 125);
                    if (this.loadedcars == 0)
                        this.rdo.drawString("No custom clan cars have been added yet!", 280 - this.ftm.stringWidth("No custom clan cars have been added yet!") / 2, 125);
                    if (this.loadedcars == 2)
                        this.rdo.drawString("Searching for and loading cars created by you,  " + this.perry + "  ...", 280 - this.ftm.stringWidth("Searching for and loading cars created by you,  " + this.perry + "  ...") / 2, 125);
                    if (this.loadedcars == 3) {
                        this.rdo.drawString("Found no cars that can be added!", 280 - this.ftm.stringWidth("Found no cars that can be added!") / 2, 105);
                        this.rdo.drawString("Found no cars created by you that also do not already belong to a clan.", 280 - this.ftm.stringWidth("Found no cars created by you that also do not already belong to a clan.") / 2, 125);
                        if (stringbutton(this.rdo, " OK ", 280, 155, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                            this.loadedcars = -1;
                    }
                    if (this.loadedcars == 4) {
                        this.rdo.drawString("Failed to load cars created by you, connection error, try again later...", 280 - this.ftm.stringWidth("Failed to load cars created by you, connection error, try again later...") / 2, 125);
                        if (stringbutton(this.rdo, " OK ", 280, 155, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                            this.loadedcars = -1;
                    }
                    if (this.loadedcars == 6)
                        this.rdo.drawString("Adding " + this.selcar + " to your clan's cars, please wait...", 280 - this.ftm.stringWidth("Adding " + this.selcar + " to your clan's cars, please wait...") / 2, 125);
                    if (this.loadedcars == 7) {
                        this.rdo.drawString("Failed to add car, server error, try again later...", 280 - this.ftm.stringWidth("Failed to add car, server error, try again later...") / 2, 125);
                        if (stringbutton(this.rdo, " OK ", 280, 155, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                            this.loadedcars = -1;
                    }
                    if (this.loadedcars == 8)
                        this.rdo.drawString("Removing " + this.selcar + " from your clan's cars, please wait...", 280 - this.ftm.stringWidth("Removing " + this.selcar + " from your clan's cars, please wait...") / 2, 125);
                    if (this.loadedcars == 9) {
                        this.rdo.drawString("Failed to remove car, server error, try again later...", 280 - this.ftm.stringWidth("Failed to remove car, server error, try again later...") / 2, 125);
                        if (stringbutton(this.rdo, " OK ", 280, 155, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                            this.loadedcars = -1;
                    }
                    if (this.loadedcars == 10) {
                        this.rdo.drawString("Are you sure you want to remove " + this.selcar + " from your clan's cars?", 280 - this.ftm.stringWidth("Are you sure you want to remove " + this.selcar + " from your clan's cars?") / 2, 100);
                        if (stringbutton(this.rdo, "    Yes    ", 280, 135, -2, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                            this.loadedcars = 8;
                        if (stringbutton(this.rdo, "  No  ", 280, 165, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                            this.loadedcars = 1;
                    }
                    if (this.loadedcars == 5) {
                        this.rdo.drawString("Select a car to add.", 280 - this.ftm.stringWidth("Select a car to add.") / 2, 80);
                        this.gs.clcars.move(496 - this.gs.clcars.getWidth() / 2, 206);
                        if (this.editc == 0) {
                            if (!this.gs.clcars.isShowing()) {
                                this.gs.clcars.show();
                                this.gs.clcars.select(0);
                            }
                        } else {
                            this.gs.clcars.hide();
                        }
                        if (!this.gs.clcars.getSelectedItem().equals(this.selcar))
                            this.selcar = this.gs.clcars.getSelectedItem();
                        if (this.gs.clcars.open) this.blocknote = 20;
                        if (stringbutton(this.rdo, "     Add Car     ", 280, 150, -2, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                            this.loadedcars = 6;
                        if (stringbutton(this.rdo, "  Cancel  ", 280, 200, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                            this.loadedcars = -1;
                    }
                    if (this.loadedcars == 1) {
                        if (this.editc == 0) {
                            if (!this.gs.clcars.isShowing()) {
                                this.gs.clcars.show();
                                this.selcar = this.gs.clcars.getSelectedItem();
                            }
                        } else {
                            this.gs.clcars.hide();
                        }
                        this.gs.clcars.move(496 - this.gs.clcars.getWidth() / 2, 140);
                        if (!this.gs.clcars.getSelectedItem().equals(this.selcar)) {
                            this.selcar = this.gs.clcars.getSelectedItem();
                            this.loadedcar = 0;
                            this.cd.action = 0;
                        }
                        if (this.gs.clcars.open) this.blocknote = 20;
                        if (!this.selcar.equals("Select Car")) {
                            if (this.loadedcar > 0) {
                                this.rdo.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rdo.getFontMetrics();
                                this.rdo.setColor(new Color(0, 0, 0));
                                this.rdo.drawString("Created/Published by", 63, 37);
                                int k = 63 + this.ftm.stringWidth("Created/Published by") / 2 - this.ftm.stringWidth(this.cd.createdby[19 + this.cd.haltload]) / 2;
                                int m = k + this.ftm.stringWidth(this.cd.createdby[19 + this.cd.haltload]);
                                this.rdo.drawString(this.cd.createdby[19 + this.cd.haltload], k, 52);
                                this.rdo.drawLine(k, 54, m, 54);
                                if (paramInt1 > k + 216 && paramInt1 < m + 216 && paramInt2 > 152 && paramInt2 < 166) {
                                    this.cur = 12;
                                    if (paramBoolean) {
                                        this.tab = 1;
                                        if (!this.proname.equals(this.cd.createdby[19 + this.cd.haltload])) {
                                            this.proname = this.cd.createdby[19 + this.cd.haltload];
                                            this.loadedp = false;
                                            onexitpro();
                                        }
                                    }
                                }
                                String str = "Class C";
                                if (this.cd.cclass[35 + this.cd.haltload] == 1) str = "Class B&C";
                                if (this.cd.cclass[35 + this.cd.haltload] == 2) str = "Class B";
                                if (this.cd.cclass[35 + this.cd.haltload] == 3) str = "Class A&B";
                                if (this.cd.cclass[35 + this.cd.haltload] == 4) str = "Class A";
                                this.rdo.drawString(str, 389 - this.ftm.stringWidth(str) / 2, 45);
                                if ((b != -1 || this.cd.createdby[19 + this.cd.haltload].toLowerCase().equals(this.xt.nickname.toLowerCase())) && stringbutton(this.rdo, " Remove X ", 466, 45, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                                    this.loadedcars = 10;
                                this.m.crs = true;
                                this.m.focus_point = 400;
                                this.m.x = -335;
                                this.m.y = 0;
                                this.m.z = -50;
                                this.m.xz = 0;
                                this.m.zy = 20;
                                this.m.ground = -2000;
                                this.m.cx = 280;
                                this.m.cy = 150;
                                (this.bco[35 + this.cd.haltload]).z = 1000;
                                (this.bco[35 + this.cd.haltload]).y = 480 - (this.bco[35 + this.cd.haltload]).grat;
                                (this.bco[35 + this.cd.haltload]).x = -52;
                                (this.bco[35 + this.cd.haltload]).zy = 0;
                                (this.bco[35 + this.cd.haltload]).xz = this.mrot;
                                this.mrot -= 5;
                                if (this.mrot < -360) this.mrot += 360;
                                (this.bco[35 + this.cd.haltload]).xy = 0;
                                (this.bco[35 + this.cd.haltload]).wzy -= 10;
                                if ((this.bco[35 + this.cd.haltload]).wzy < -45)
                                    (this.bco[35 + this.cd.haltload]).wzy += 45;
                                this.rdo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                                this.bco[35 + this.cd.haltload].d(this.rdo);
                                this.rdo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                                this.m.cx = 400;
                                this.m.cy = 225;
                                char c = '';
                                if (this.xt.sc[0] == 35 + this.cd.haltload) c = 'ÿ';
                                if (this.gs.clcars.getSelectedIndex() != this.gs.clcars.no - 1 && stringbutton(this.rdo, " Next > ", 476, c, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                                    this.gs.clcars.sel++;
                                if (this.gs.clcars.getSelectedIndex() != 1 && stringbutton(this.rdo, " < Prev ", 84, c, -3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112))
                                    this.gs.clcars.sel--;
                                if (this.xt.sc[0] != 35 + this.cd.haltload || paramInt1 < 256 || paramInt1 > 736 || paramInt2 < 132 || paramInt2 > 377) {
                                    this.rdo.setFont(new Font("Arial", 1, 11));
                                    this.ftm = this.rdo.getFontMetrics();
                                    this.rdo.setColor(new Color(0, 0, 0));
                                    byte b2 = -36;
                                    short s1 = -181;
                                    short s2 = -155;
                                    this.rdo.drawString("Top Speed:", 98 + b2, 343 + s2);
                                    this.rdo.drawImage(this.xt.statb, 162 + b2, 337 + s2, (ImageObserver) null);
                                    this.rdo.drawString("Acceleration:", 88 + b2, 358 + s2);
                                    this.rdo.drawImage(this.xt.statb, 162 + b2, 352 + s2, (ImageObserver) null);
                                    this.rdo.drawString("Handling:", 110 + b2, 373 + s2);
                                    this.rdo.drawImage(this.xt.statb, 162 + b2, 367 + s2, (ImageObserver) null);
                                    this.rdo.drawString("Stunts:", 495 + s1, 343 + s2);
                                    this.rdo.drawImage(this.xt.statb, 536 + s1, 337 + s2, (ImageObserver) null);
                                    this.rdo.drawString("Strength:", 483 + s1, 358 + s2);
                                    this.rdo.drawImage(this.xt.statb, 536 + s1, 352 + s2, (ImageObserver) null);
                                    this.rdo.drawString("Endurance:", 473 + s1, 373 + s2);
                                    this.rdo.drawImage(this.xt.statb, 536 + s1, 367 + s2, (ImageObserver) null);
                                    this.rdo.setColor(new Color(0, 0, 0));
                                    float f1 = (this.cd.swits[35 + this.cd.haltload][2] - 220) / 90.0F;
                                    if (f1 < 0.2D) f1 = 0.2F;
                                    this.rdo.fillRect((int) (162.0F + 156.0F * f1) + b2, 337 + s2, (int) (156.0F * (1.0F - f1) + 1.0F), 7);
                                    f1 = this.cd.acelf[35 + this.cd.haltload][1] * this.cd.acelf[35 + this.cd.haltload][0] * this.cd.acelf[35 + this.cd.haltload][2] * this.cd.grip[35 + this.cd.haltload] / 7700.0F;
                                    if (f1 > 1.0F) f1 = 1.0F;
                                    this.rdo.fillRect((int) (162.0F + 156.0F * f1) + b2, 352 + s2, (int) (156.0F * (1.0F - f1) + 1.0F), 7);
                                    f1 = this.cd.dishandle[35 + this.cd.haltload];
                                    this.rdo.fillRect((int) (162.0F + 156.0F * f1) + b2, 367 + s2, (int) (156.0F * (1.0F - f1) + 1.0F), 7);
                                    f1 = (this.cd.airc[35 + this.cd.haltload] * this.cd.airs[35 + this.cd.haltload] * this.cd.bounce[35 + this.cd.haltload] + 28.0F) / 139.0F;
                                    if (f1 > 1.0F) f1 = 1.0F;
                                    this.rdo.fillRect((int) (536.0F + 156.0F * f1) + s1, 337 + s2, (int) (156.0F * (1.0F - f1) + 1.0F), 7);
                                    float f2 = 0.5F;
                                    f1 = (this.cd.moment[35 + this.cd.haltload] + f2) / 2.6F;
                                    if (f1 > 1.0F) f1 = 1.0F;
                                    this.rdo.fillRect((int) (536.0F + 156.0F * f1) + s1, 352 + s2, (int) (156.0F * (1.0F - f1) + 1.0F), 7);
                                    f1 = this.cd.outdam[35 + this.cd.haltload];
                                    this.rdo.fillRect((int) (536.0F + 156.0F * f1) + s1, 367 + s2, (int) (156.0F * (1.0F - f1) + 1.0F), 7);
                                    this.rdo.drawImage(this.xt.statbo, 162 + b2, 337 + s2, (ImageObserver) null);
                                    this.rdo.drawImage(this.xt.statbo, 162 + b2, 352 + s2, (ImageObserver) null);
                                    this.rdo.drawImage(this.xt.statbo, 162 + b2, 367 + s2, (ImageObserver) null);
                                    this.rdo.drawImage(this.xt.statbo, 536 + s1, 337 + s2, (ImageObserver) null);
                                    this.rdo.drawImage(this.xt.statbo, 536 + s1, 352 + s2, (ImageObserver) null);
                                    this.rdo.drawImage(this.xt.statbo, 536 + s1, 367 + s2, (ImageObserver) null);
                                } else {
                                    byte b2 = -20;
                                    short s = -220;
                                    this.rdo.setFont(new Font("Arial", 1, 10));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rdo.drawString("Hue  | ", 97 + b2, 70);
                                    this.rdo.drawImage(this.xt.brt, 137 + b2, 63, (ImageObserver) null);
                                    this.rdo.drawString("Intensity", 121 + b2, 219);
                                    this.rdo.drawString("Hue  | ", 647 + s, 70);
                                    this.rdo.drawImage(this.xt.brt, 687 + s, 63, (ImageObserver) null);
                                    this.rdo.drawString("Intensity", 671 + s, 219);
                                    byte b3;
                                    for (b3 = 0; b3 < '¡'; ) {
                                        this.rdo.setColor(Color.getHSBColor((float) (b3 * 0.00625D), 1.0F, 1.0F));
                                        this.rdo.drawLine(102 + b2, 75 + b3, 110 + b2, 75 + b3);
                                        if (b3 <= '') {
                                            this.rdo.setColor(Color.getHSBColor(1.0F, 0.0F, (float) (1.0D - b3 * 0.00625D)));
                                            this.rdo.drawLine(137 + b2, 75 + b3, 145 + b2, 75 + b3);
                                        }
                                        this.rdo.setColor(Color.getHSBColor((float) (b3 * 0.00625D), 1.0F, 1.0F));
                                        this.rdo.drawLine(652 + s, 75 + b3, 660 + s, 75 + b3);
                                        if (b3 <= '') {
                                            this.rdo.setColor(Color.getHSBColor(1.0F, 0.0F, (float) (1.0D - b3 * 0.00625D)));
                                            this.rdo.drawLine(687 + s, 75 + b3, 695 + s, 75 + b3);
                                        }
                                        b3++;
                                    }
                                    for (b3 = 0; b3 < 40; ) {
                                        this.rdo.setColor(Color.getHSBColor(this.xt.arnp[0], (float) (b3 * 0.025D), 1.0F - this.xt.arnp[2]));
                                        this.rdo.drawLine(121 + b3 + b2, 224, 121 + b3 + b2, 230);
                                        this.rdo.setColor(Color.getHSBColor(this.xt.arnp[3], (float) (b3 * 0.025D), 1.0F - this.xt.arnp[5]));
                                        this.rdo.drawLine(671 + b3 + s, 224, 671 + b3 + s, 230);
                                        b3++;
                                    }
                                    this.rdo.drawImage(this.xt.arn, 110 + b2, 71 + (int) (this.xt.arnp[0] * 160.0F), (ImageObserver) null);
                                    this.rdo.drawImage(this.xt.arn, 145 + b2, 71 + (int) (this.xt.arnp[2] * 160.0F), (ImageObserver) null);
                                    this.rdo.drawImage(this.xt.arn, 660 + s, 71 + (int) (this.xt.arnp[3] * 160.0F), (ImageObserver) null);
                                    this.rdo.drawImage(this.xt.arn, 695 + s, 71 + (int) (this.xt.arnp[5] * 160.0F), (ImageObserver) null);
                                    this.rdo.setColor(new Color(0, 0, 0));
                                    this.rdo.fillRect(120 + b2 + (int) (this.xt.arnp[1] * 40.0F), 222, 3, 3);
                                    this.rdo.drawLine(121 + b2 + (int) (this.xt.arnp[1] * 40.0F), 224, 121 + b2 + (int) (this.xt.arnp[1] * 40.0F), 230);
                                    this.rdo.fillRect(120 + b2 + (int) (this.xt.arnp[1] * 40.0F), 230, 3, 3);
                                    this.rdo.fillRect(670 + s + (int) (this.xt.arnp[4] * 40.0F), 222, 3, 3);
                                    this.rdo.drawLine(671 + s + (int) (this.xt.arnp[4] * 40.0F), 224, 671 + s + (int) (this.xt.arnp[4] * 40.0F), 230);
                                    this.rdo.fillRect(670 + s + (int) (this.xt.arnp[4] * 40.0F), 230, 3, 3);
                                    if (paramBoolean) {
                                        if (this.mouson == -1) {
                                            this.mouson = -2;
                                            if (paramInt1 > 335 + b2 && paramInt1 < 379 + b2 && paramInt2 > 334 && paramInt2 < 344)
                                                this.mouson = 1;
                                            if (paramInt1 > 885 + s && paramInt1 < 929 + s && paramInt2 > 334 && paramInt2 < 344)
                                                this.mouson = 4;
                                            if (paramInt1 > 314 + b2 && paramInt1 < 338 + b2 && paramInt2 > 181 && paramInt2 < 353 && this.mouson == -2)
                                                this.mouson = 0;
                                            if (paramInt1 > 349 + b2 && paramInt1 < 373 + b2 && paramInt2 > 181 && paramInt2 < 321 && this.mouson == -2)
                                                this.mouson = 2;
                                            if (paramInt1 > 864 + s && paramInt1 < 888 + s && paramInt2 > 181 && paramInt2 < 353 && this.mouson == -2)
                                                this.mouson = 3;
                                            if (paramInt1 > 899 + s && paramInt1 < 923 + s && paramInt2 > 181 && paramInt2 < 321 && this.mouson == -2)
                                                this.mouson = 5;
                                        }
                                    } else if (this.mouson != -1) {
                                        this.mouson = -1;
                                    }
                                    if (this.mouson >= 0 && this.mouson <= 5) this.blocknote = 20;
                                    if (this.mouson == 0 || this.mouson == 2 || this.mouson == 3 || this.mouson == 5) {
                                        this.xt.arnp[this.mouson] = (float) ((paramInt2 - 187.0F) * 0.00625D);
                                        if (this.mouson == 2 || this.mouson == 5) {
                                            if (this.xt.arnp[this.mouson] > 0.8D) this.xt.arnp[this.mouson] = 0.8F;
                                        } else if (this.xt.arnp[this.mouson] > 1.0F) {
                                            this.xt.arnp[this.mouson] = 1.0F;
                                        }
                                        if (this.xt.arnp[this.mouson] < 0.0F) this.xt.arnp[this.mouson] = 0.0F;
                                    }
                                    if (this.mouson == 1) {
                                        this.xt.arnp[this.mouson] = (float) ((paramInt1 - (337 + b2)) * 0.025D);
                                        if (this.xt.arnp[this.mouson] > 1.0F) this.xt.arnp[this.mouson] = 1.0F;
                                        if (this.xt.arnp[this.mouson] < 0.0F) this.xt.arnp[this.mouson] = 0.0F;
                                    }
                                    if (this.mouson == 4) {
                                        this.xt.arnp[this.mouson] = (float) ((paramInt1 - (887 + s)) * 0.025D);
                                        if (this.xt.arnp[this.mouson] > 1.0F) this.xt.arnp[this.mouson] = 1.0F;
                                        if (this.xt.arnp[this.mouson] < 0.0F) this.xt.arnp[this.mouson] = 0.0F;
                                    }
                                    Color color1, color2;
                                    byte b4;
                                    for (color1 = Color.getHSBColor(this.xt.arnp[0], this.xt.arnp[1], 1.0F - this.xt.arnp[2]), color2 = Color.getHSBColor(this.xt.arnp[3], this.xt.arnp[4], 1.0F - this.xt.arnp[5]), b4 = 0; b4 < (this.bco[36]).npl; ) {
                                        if (((this.bco[36]).p[b4]).colnum == 1) {
                                            ((this.bco[36]).p[b4]).hsb[0] = this.xt.arnp[0];
                                            ((this.bco[36]).p[b4]).hsb[1] = this.xt.arnp[1];
                                            ((this.bco[36]).p[b4]).hsb[2] = 1.0F - this.xt.arnp[2];
                                            ((this.bco[36]).p[b4]).c[0] = color1.getRed();
                                            ((this.bco[36]).p[b4]).c[1] = color1.getGreen();
                                            ((this.bco[36]).p[b4]).c[2] = color1.getBlue();
                                            ((this.bco[36]).p[b4]).oc[0] = color1.getRed();
                                            ((this.bco[36]).p[b4]).oc[1] = color1.getGreen();
                                            ((this.bco[36]).p[b4]).oc[2] = color1.getBlue();
                                        }
                                        if (((this.bco[36]).p[b4]).colnum == 2) {
                                            ((this.bco[36]).p[b4]).hsb[0] = this.xt.arnp[3];
                                            ((this.bco[36]).p[b4]).hsb[1] = this.xt.arnp[4];
                                            ((this.bco[36]).p[b4]).hsb[2] = 1.0F - this.xt.arnp[5];
                                            ((this.bco[36]).p[b4]).c[0] = color2.getRed();
                                            ((this.bco[36]).p[b4]).c[1] = color2.getGreen();
                                            ((this.bco[36]).p[b4]).c[2] = color2.getBlue();
                                            ((this.bco[36]).p[b4]).oc[0] = color2.getRed();
                                            ((this.bco[36]).p[b4]).oc[1] = color2.getGreen();
                                            ((this.bco[36]).p[b4]).oc[2] = color2.getBlue();
                                        }
                                        b4++;
                                    }
                                    if (stringbutton(this.rdo, "    Play >    ", 280, 220, -1, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112)) {
                                        this.open = 450;
                                        this.upo = false;
                                        this.domon = false;
                                        onexit();
                                    }
                                }
                                if (this.xt.clan.toLowerCase().equals(this.claname.toLowerCase()))
                                    if (this.xt.sc[0] != 36) {
                                        if (stringbutton(this.rdo, "     Switch to using clan cars     ", 280, 250, -2, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112)) {
                                            boolean bool1;
                                            byte b2;
                                            for (this.xt.sc[0] = 36, bool1 = false, b2 = 0; b2 < (this.bco[36]).npl && !bool1; ) {
                                                if (((this.bco[36]).p[b2]).colnum == 1) {
                                                    float[] arrayOfFloat = new float[3];
                                                    Color.RGBtoHSB(((this.bco[36]).p[b2]).c[0], ((this.bco[36]).p[b2]).c[1], ((this.bco[36]).p[b2]).c[2], arrayOfFloat);
                                                    this.xt.arnp[0] = arrayOfFloat[0];
                                                    this.xt.arnp[1] = arrayOfFloat[1];
                                                    this.xt.arnp[2] = 1.0F - arrayOfFloat[2];
                                                    bool1 = true;
                                                }
                                                b2++;
                                            }
                                            for (bool1 = false, b2 = 0; b2 < (this.bco[36]).npl && !bool1; ) {
                                                if (((this.bco[36]).p[b2]).colnum == 2) {
                                                    float[] arrayOfFloat = new float[3];
                                                    Color.RGBtoHSB(((this.bco[36]).p[b2]).c[0], ((this.bco[36]).p[b2]).c[1], ((this.bco[36]).p[b2]).c[2], arrayOfFloat);
                                                    this.xt.arnp[3] = arrayOfFloat[0];
                                                    this.xt.arnp[4] = arrayOfFloat[1];
                                                    this.xt.arnp[5] = 1.0F - arrayOfFloat[2];
                                                    bool1 = true;
                                                }
                                                b2++;
                                            }
                                        }
                                    } else {
                                        this.rdo.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rdo.getFontMetrics();
                                        this.rdo.setColor(new Color(0, 0, 0));
                                        this.rdo.drawString("You are currently using your clan's cars.", 280 - this.ftm.stringWidth("You are currently using your clan's cars.") / 2, 250);
                                    }
                                if (this.cd.publish[19 + this.cd.haltload] > 0) {
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(0, 0, 0));
                                    if (this.cd.action == -9)
                                        this.rd.drawString("Failed to add car!  Unknown error, please try again later.", 496 - this.ftm.stringWidth("Failed to add car!  Unknown error, please try again later.") / 2, 432);
                                    if (this.cd.action == -8)
                                        this.rd.drawString("Cannot add more then 20 cars to your account!", 496 - this.ftm.stringWidth("Cannot add more then 20 cars to your account!") / 2, 432);
                                    if (this.cd.action == 7)
                                        this.rd.drawString("[" + this.cd.acname + "] has been added to your cars!", 496 - this.ftm.stringWidth("[" + this.cd.acname + "] has been added to your cars!") / 2, 432);
                                    if (this.cd.action == -7)
                                        this.rd.drawString("You already have this car.", 496 - this.ftm.stringWidth("You already have this car.") / 2, 432);
                                    if (this.cd.action == 6)
                                        this.rd.drawString("Adding Car...", 496 - this.ftm.stringWidth("Adding Car...") / 2, 432);
                                    if (this.cd.action == -6) {
                                        String str1 = "Upgrade to a full account to add custom cars!";
                                        int n = 496 - this.ftm.stringWidth(str1) / 2, i1 = n + this.ftm.stringWidth(str1);
                                        this.rd.drawString(str1, n, 432);
                                        if (this.waitlink != -1) this.rd.drawLine(n, 435, i1, 435);
                                        if (paramInt1 > n && paramInt1 < i1 && paramInt2 > 421 && paramInt2 < 435) {
                                            if (this.waitlink != -1) this.cur = 12;
                                            if (paramBoolean && this.waitlink == 0) {
                                                this.gs.editlink(this.xt.nickname, true);
                                                this.waitlink = -1;
                                            }
                                        }
                                        if (this.waitlink > 0) this.waitlink--;
                                    }
                                    if (this.cd.action == 0 && this.xt.drawcarb(true, null, " Add to My Cars ", 437, 414, paramInt1, paramInt2, (paramBoolean && this.blocknote == 0)))
                                        if (this.xt.logged) {
                                            this.cd.action = 6;
                                            this.cd.ac = -1;
                                            this.cd.acname = this.selcar;
                                            this.cd.sparkactionloader();
                                        } else {
                                            this.cd.action = -6;
                                            this.waitlink = 20;
                                        }
                                } else {
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString("Private Car", 496 - this.ftm.stringWidth("Private Car") / 2, 432);
                                }
                            }
                            if (this.loadedcar == 0) {
                                this.rdo.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rdo.getFontMetrics();
                                this.rdo.setColor(new Color(0, 0, 0));
                                this.rdo.drawString("Loading...", 280 - this.ftm.stringWidth("Loading...") / 2, 125);
                            }
                            if (this.loadedcar == -1) {
                                this.rdo.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rdo.getFontMetrics();
                                this.rdo.setColor(new Color(0, 0, 0));
                                this.rdo.drawString("Error loading car, try again later...", 280 - this.ftm.stringWidth("Error loading car, try again later...") / 2, 125);
                            }
                        }
                    }
                    if (this.loadedcars != 1 && this.loadedcars != 5 && this.gs.clcars.isShowing())
                        this.gs.clcars.hide();
                    if (this.xt.clan.toLowerCase().equals(this.claname.toLowerCase())) {
                        if (this.loadedcars >= 0 && this.loadedcars < 2)
                            if (stringbutton(this.rdo, "     Add a car of yours to the clan's cars     ", 280, 286, -2, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112)) {
                                this.loadedcars = 2;
                                this.perry = "0 %";
                            }
                    } else if (this.loadedcars == 1 && !this.selcar.equals("Select Car") && this.loadedcar > 0) {
                        if (stringbutton(this.rdo, "     Battle with clan over this car!     ", 280, 286, -2, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 216, 112)) {
                            this.tab = 2;
                            this.itab = 1;
                            this.litab = -1;
                            this.openi = 10;
                            if (!this.intclan.equals(this.claname)) {
                                this.intclan = this.claname;
                                this.dispi = 0;
                                this.nil = 0;
                                this.lastint = "";
                                this.readint = 1;
                            }
                            this.redif = true;
                            this.intsel = 3;
                        }
                    }
                }
                if (this.ctab != 2 && this.ctab != 3 && this.gs.clcars.isShowing()) this.gs.clcars.hide();
                if (this.ctab == 4) {
                    boolean bool1 = false;
                    if (paramInt1 > 266 && paramInt1 < 726 && paramInt2 > 162 && paramInt2 < 223 && this.editc == 0)
                        bool1 = true;
                    this.rdo.setComposite(AlphaComposite.getInstance(3, 0.7F));
                    this.rdo.setColor(new Color(255, 255, 255));
                    this.rdo.fillRoundRect(50, 50, 460, 61, 20, 20);
                    this.rdo.setColor(new Color(0, 0, 0));
                    this.rdo.drawRoundRect(50, 50, 460, 61, 20, 20);
                    this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    if (this.loadedlink) {
                        if (b != -1 && bool1) {
                            this.rdo.setFont(new Font("Arial", 1, 11));
                            this.ftm = this.rdo.getFontMetrics();
                            this.rdo.drawString("Edit", 480, 66);
                            this.rdo.drawLine(480, 68, 480 + this.ftm.stringWidth("Edit"), 68);
                            if (paramInt1 > 696 && paramInt1 < 696 + this.ftm.stringWidth("Edit") && paramInt2 > 166 && paramInt2 < 181 && this.editc == 0) {
                                this.cur = 12;
                                if (paramBoolean) {
                                    this.editc = 6;
                                    this.msg = "Edit Clan's Web Presence";
                                    this.flko = 0;
                                    paramBoolean = false;
                                }
                            }
                        }
                        if (!this.ltit.equals("") && !this.lurl.equals("")) {
                            this.rdo.setFont(new Font("Arial", 1, 13));
                            this.ftm = this.rdo.getFontMetrics();
                            this.rdo.drawString(this.ltit, 70, 74);
                            if (bool1) this.rdo.drawLine(70, 76, 70 + this.ftm.stringWidth(this.ltit), 76);
                            this.rdo.setFont(new Font("Arial", 0, 12));
                            this.ftm = this.rdo.getFontMetrics();
                            this.rdo.drawString(this.ldes, 70, 94);
                            if (bool1 && this.editc == 0) {
                                this.cur = 12;
                                if (paramBoolean) this.gs.openurl(this.lurl);
                            }
                        } else {
                            this.rdo.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rdo.getFontMetrics();
                            this.rdo.drawString("" + this.claname + " has no external online presence.", 280 - this.ftm.stringWidth("" + this.claname + " has no external online presence.") / 2, 85);
                        }
                    } else {
                        this.rdo.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rdo.getFontMetrics();
                        this.rdo.drawString("Loading...", 280 - this.ftm.stringWidth("Loading...") / 2, 85);
                    }
                }
                if (this.sdist != 0) {
                    this.rdo.setColor(color2k(200, 200, 200));
                    this.rdo.fillRect(540, 20, 17, 260);
                    if (this.mscro5 == 831) {
                        this.rdo.setColor(color2k(215, 215, 215));
                        this.rdo.fillRect(540, 3, 17, 17);
                    } else {
                        this.rdo.setColor(color2k(220, 220, 220));
                        this.rdo.fill3DRect(540, 3, 17, 17, true);
                    }
                    this.rdo.drawImage(this.xt.asu, 545, 9, (ImageObserver) null);
                    if (this.mscro5 == 832) {
                        this.rdo.setColor(color2k(215, 215, 215));
                        this.rdo.fillRect(540, 280, 17, 17);
                    } else {
                        this.rdo.setColor(color2k(220, 220, 220));
                        this.rdo.fill3DRect(540, 280, 17, 17, true);
                    }
                    this.rdo.drawImage(this.xt.asd, 545, 287, (ImageObserver) null);
                    if (this.lspos5 != this.spos5) {
                        this.rdo.setColor(color2k(215, 215, 215));
                        this.rdo.fillRect(540, 20 + this.spos5, 17, 31);
                    } else {
                        if (this.mscro5 == 831) this.rdo.setColor(color2k(215, 215, 215));
                        this.rdo.fill3DRect(540, 20 + this.spos5, 17, 31, true);
                    }
                    this.rdo.setColor(color2k(150, 150, 150));
                    this.rdo.drawLine(545, 33 + this.spos5, 551, 33 + this.spos5);
                    this.rdo.drawLine(545, 35 + this.spos5, 551, 35 + this.spos5);
                    this.rdo.drawLine(545, 37 + this.spos5, 551, 37 + this.spos5);
                    if (this.mscro5 > 800 && this.lspos5 != this.spos5) this.lspos5 = this.spos5;
                    if (paramBoolean) {
                        if (this.mscro5 == 825 && paramInt1 > 756 && paramInt1 < 773 && paramInt2 > 132 + this.spos5 && paramInt2 < this.spos5 + 163)
                            this.mscro5 = paramInt2 - this.spos5;
                        if (this.mscro5 == 825 && paramInt1 > 754 && paramInt1 < 775 && paramInt2 > 26 && paramInt2 < 134)
                            this.mscro5 = 831;
                        if (this.mscro5 == 825 && paramInt1 > 754 && paramInt1 < 775 && paramInt2 > 390 && paramInt2 < 411)
                            this.mscro5 = 832;
                        if (this.mscro5 == 825 && paramInt1 > 756 && paramInt1 < 773 && paramInt2 > 132 && paramInt2 < 392) {
                            this.mscro5 = 152;
                            this.spos5 = paramInt2 - this.mscro5;
                        }
                        int k = 2670 / this.sdist;
                        if (k < 1) k = 1;
                        if (this.mscro5 == 831) {
                            this.spos5 -= k;
                            if (this.spos5 > 229) this.spos5 = 229;
                            if (this.spos5 < 0) this.spos5 = 0;
                            this.lspos5 = this.spos5;
                        }
                        if (this.mscro5 == 832) {
                            this.spos5 += k;
                            if (this.spos5 > 229) this.spos5 = 229;
                            if (this.spos5 < 0) this.spos5 = 0;
                            this.lspos5 = this.spos5;
                        }
                        if (this.mscro5 < 800) {
                            this.spos5 = paramInt2 - this.mscro5;
                            if (this.spos5 > 229) this.spos5 = 229;
                            if (this.spos5 < 0) this.spos5 = 0;
                        }
                        if (this.mscro5 == 825) this.mscro5 = 925;
                    } else if (this.mscro5 != 825) {
                        this.mscro5 = 825;
                    }
                }
                this.rd.drawImage(this.gImage, 216, 112, (ImageObserver) null);
                if (this.ctab != 2 && this.ctab != 3) if (this.xt.clan.equals("")) {
                    boolean bool1 = false;
                    byte b2;
                    for (b2 = 0; b2 < this.nmb; ) {
                        if (this.xt.nickname.toLowerCase().equals(this.member[b2].toLowerCase())) {
                            bool1 = true;
                            break;
                        }
                        b2++;
                    }
                    if (!bool1) {
                        b2 = 0;
                        int k;
                        for (k = 0; k < this.nrmb; ) {
                            if (this.xt.nickname.toLowerCase().equals(this.rmember[k].toLowerCase())) {
                                b2 = 1;
                                break;
                            }
                            k++;
                        }
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        if (b2 == 0) {
                            if (stringbutton(this.rd, "      Request to Join this Clan      ", 496, 432, 3, paramInt1, paramInt2, (paramBoolean && !this.gs.openm), 0, 0))
                                if (this.xt.logged) {
                                    this.editc = 99;
                                } else {
                                    this.editc = 101;
                                }
                            k = this.ftm.stringWidth("      Request to Join this Clan      ");
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(496 - k / 2 - 20, 415, k + 40, 24, 20, 20);
                        } else {
                            k = this.ftm.stringWidth("You have requested to join this clan, waiting for admin to approve your membership.");
                            this.rd.drawString("You have requested to join this clan, waiting for admin to approve your membership.", 496 - k / 2, 432);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(496 - k / 2 - 20, 415, k + 40, 24, 20, 20);
                        }
                    }
                }
                if (this.editc == 1 || this.editc == 2) {
                    this.rd.setColor(new Color(244, 232, 204));
                    this.rd.fillRoundRect(265, 92, 460, 220, 20, 20);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawRoundRect(265, 92, 460, 220, 20, 20);
                    String[] arrayOfString = {"logo", "350x30", "35 : 3"};
                    if (this.editc == 2) {
                        arrayOfString[0] = "background";
                        arrayOfString[1] = "560x300";
                        arrayOfString[2] = "56 : 30";
                    }
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    if (this.flko % 4 != 0 || this.flko == 0)
                        this.rd.drawString(this.msg, 495 - this.ftm.stringWidth(this.msg) / 2, 115);
                    if (this.flko != 0) this.flko--;
                    this.rd.setFont(new Font("Arial", 0, 12));
                    this.rd.drawString("The " + arrayOfString[0] + " image is " + arrayOfString[1] + " pixels.", 275, 140);
                    this.rd.drawString("Any image uploaded will be resized to that width and height. For the best results", 275, 160);
                    this.rd.drawString("try to upload an image that is bigger or equal to " + arrayOfString[1] + " and has the scale of", 275, 180);
                    this.rd.drawString("[ " + arrayOfString[2] + " ]  in  [ Width : Height ].", 275, 200);
                    this.rd.drawString("Image uploaded must be less than 1MB and in the format of JPEG, GIF or PNG.", 275, 220);
                    if (this.upload == 0) {
                        if (stringbutton(this.rd, "  Upload Image  ", 495, 250, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                            FileDialog fileDialog = new FileDialog(new Frame(), "Upload Image");
                            fileDialog.setMode(0);
                            fileDialog.setVisible(true);
                            this.filename = "" + fileDialog.getDirectory() + "" + fileDialog.getFile() + "";
                            if (!this.filename.equals("nullnull")) this.upload = 1;
                        }
                    } else {
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        if (this.upload == 1)
                            this.rd.drawString("Checking image...", 495 - this.ftm.stringWidth("Checking image...") / 2, 250);
                        if (this.upload == 2)
                            this.rd.drawString("Authenticating...", 495 - this.ftm.stringWidth("Authenticating...") / 2, 250);
                        if (this.upload == 3)
                            this.rd.drawString("Uploading image :  " + this.perc + " %", 495 - this.ftm.stringWidth("Uploading image :  80 %") / 2, 250);
                        if (this.upload == 4)
                            this.rd.drawString("Creating image online...", 495 - this.ftm.stringWidth("Creating image online...") / 2, 250);
                        if (this.upload == 5) this.rd.drawString("Done", 495 - this.ftm.stringWidth("Done") / 2, 250);
                    }
                    if (stringbutton(this.rd, " Cancel ", 495, 290, 2, paramInt1, paramInt2, paramBoolean, 0, 0))
                        if (this.upload == 0) {
                            this.editc = 0;
                        } else {
                            this.upload = 0;
                        }
                }
                if (this.editc == 3) {
                    this.rd.setColor(new Color(244, 232, 204));
                    this.rd.fillRoundRect(245, 92, 500, 190, 20, 20);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawRoundRect(245, 92, 500, 190, 20, 20);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    String str = "" + this.member[this.em] + "'s";
                    if (this.xt.nickname.toLowerCase().equals(this.member[this.em].toLowerCase())) str = "Your";
                    this.rd.drawString("Edit " + str + " Clan Membership", 495 - this.ftm.stringWidth("Edit " + str + "'s Clan Membership") / 2, 115);
                    this.rd.drawString("Rank Description :", 399 - this.ftm.stringWidth("Membership Level :"), 146);
                    this.dorank = true;
                    this.rd.drawString("Membership Level :", 503 - this.ftm.stringWidth("Membership Level :"), 176);
                    this.gs.clanlev.move(513, 159);
                    if (!this.gs.clanlev.isShowing()) {
                        this.gs.clanlev.select(this.mlevel[this.em] - 1);
                        if (this.em == 0 && this.mlevel[this.em] == 7) {
                            this.gs.clanlev.disable();
                        } else {
                            this.gs.clanlev.enable();
                        }
                        this.gs.clanlev.show();
                    }
                    if (stringbutton(this.rd, "     Save     ", 495, 220, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                        this.gs.clanlev.hide();
                        this.editc = 33;
                    }
                    if (stringbutton(this.rd, " Cancel ", 495, 260, 2, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                        this.editc = 0;
                        this.gs.clanlev.hide();
                    }
                }
                if (this.editc == 4) {
                    this.rd.setColor(new Color(244, 232, 204));
                    this.rd.fillRoundRect(220, 92, 550, 155, 20, 20);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawRoundRect(220, 92, 550, 155, 20, 20);
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    String str = "" + this.member[this.em] + "";
                    if (this.xt.nickname.toLowerCase().equals(this.member[this.em].toLowerCase())) str = "yourself";
                    this.rd.drawString("Are you sure you want to remove " + str + " from the clan?", 495 - this.ftm.stringWidth("Are you sure you want to remove " + str + " from the clan?") / 2, 120);
                    if (this.xt.nickname.toLowerCase().equals(this.member[this.em].toLowerCase()) && this.em == 0) {
                        this.rd.setFont(new Font("Arial", 0, 12));
                        this.ftm = this.rd.getFontMetrics();
                        if (this.nmb > 1) {
                            this.rd.drawString("Note: This will result in the second high ranking player (" + this.member[1] + ") becoming the new Clan Leader!", 495 - this.ftm.stringWidth("Note: This will result in the second high ranking player (" + this.member[1] + ") becoming the new Clan Leader!") / 2, 140);
                        } else {
                            this.rd.drawString("Note: This will result in the deletion of this clan since you are the only player in it.", 495 - this.ftm.stringWidth("Note: This will result in the deletion of this clan since you are the only player in it.") / 2, 140);
                        }
                    }
                    if (stringbutton(this.rd, "     Yes     ", 495, 185, 0, paramInt1, paramInt2, paramBoolean, 0, 0))
                        this.editc = 44;
                    if (stringbutton(this.rd, " No, Cancel ", 495, 225, 2, paramInt1, paramInt2, paramBoolean, 0, 0))
                        this.editc = 0;
                }
                if (this.editc == 6) {
                    this.rd.setColor(new Color(244, 232, 204));
                    this.rd.fillRoundRect(245, 92, 500, 225, 20, 20);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawRoundRect(245, 92, 500, 225, 20, 20);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    if (this.flko % 4 != 0 || this.flko == 0)
                        this.rd.drawString(this.msg, 495 - this.ftm.stringWidth(this.msg) / 2, 115);
                    if (this.flko != 0) this.flko--;
                    this.rd.setFont(new Font("Arial", 0, 12));
                    this.rd.drawString("Does your clan have an online forum, a Facebook group, a website or any online", 255, 140);
                    this.rd.drawString("presence at all beyond the game?  If so, you can link to it from here!", 255, 160);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Link Title :", 400 - this.ftm.stringWidth("Link Title :"), 190);
                    this.rd.drawString("Link Description :", 400 - this.ftm.stringWidth("Link Description :"), 220);
                    this.doweb1 = true;
                    if (stringbutton(this.rd, "     Next >     ", 495, 255, 0, paramInt1, paramInt2, paramBoolean, 0, 0))
                        if (this.gs.temail.getText().equals("") || this.gs.cmsg.getText().equals("")) {
                            this.msg = "Please enter a link title and a link description!";
                            this.flko = 45;
                        } else {
                            this.sltit = this.gs.temail.getText();
                            if (!this.lurl.equals("") && this.lurl.toLowerCase().startsWith("http")) {
                                this.gs.temail.setText(this.lurl);
                            } else {
                                this.gs.temail.setText("http://");
                            }
                            this.msg = "Edit Clan's Web Presence";
                            this.flko = 0;
                            this.editc = 7;
                        }
                    if (stringbutton(this.rd, " Cancel ", 495, 295, 2, paramInt1, paramInt2, paramBoolean, 0, 0))
                        this.editc = 0;
                }
                if (this.editc == 7) {
                    this.rd.setColor(new Color(244, 232, 204));
                    this.rd.fillRoundRect(245, 92, 500, 225, 20, 20);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawRoundRect(245, 92, 500, 225, 20, 20);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    if (this.flko % 4 != 0 || this.flko == 0)
                        this.rd.drawString(this.msg, 495 - this.ftm.stringWidth(this.msg) / 2, 115);
                    if (this.flko != 0) this.flko--;
                    this.rd.drawString("Link URL :", 343 - this.ftm.stringWidth("Link URL :"), 150);
                    this.doweb2 = true;
                    this.rd.drawString("WARNING :", 255, 180);
                    this.rd.setFont(new Font("Arial", 0, 12));
                    this.rd.drawString("Any link placed that contains inappropriate, spam or unrelated content will result in", 255, 200);
                    this.rd.drawString("instant clan deletion and permanent account banning!", 255, 220);
                    if (stringbutton(this.rd, "     Save     ", 495, 255, 0, paramInt1, paramInt2, paramBoolean, 0, 0))
                        if (this.gs.temail.getText().equals("") || this.gs.temail.getText().equals("http://")) {
                            this.msg = "Please enter a link URL!";
                            this.flko = 45;
                        } else {
                            this.editc = 55;
                        }
                    if (stringbutton(this.rd, " Cancel ", 495, 295, 2, paramInt1, paramInt2, paramBoolean, 0, 0))
                        this.editc = 0;
                }
                if (this.editc == 33 || this.editc == 44 || this.editc == 66 || this.editc == 77 || this.editc == 99 || this.editc == 55) {
                    this.rd.setColor(new Color(244, 232, 204));
                    this.rd.fillRoundRect(345, 92, 300, 40, 20, 20);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawRoundRect(345, 92, 300, 40, 20, 20);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("One moment...", 495 - this.ftm.stringWidth("One moment...") / 2, 117);
                }
                if (this.editc == 5) {
                    this.rd.setColor(new Color(244, 232, 204));
                    this.rd.fillRoundRect(265, 92, 460, 115, 20, 20);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawRoundRect(265, 92, 460, 115, 20, 20);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Server error occurred or was unable to authorize this action.", 495 - this.ftm.stringWidth("Server error occurred or was unable to authorize this action.") / 2, 120);
                    this.rd.drawString("Please try again later.", 495 - this.ftm.stringWidth("Please try again later.") / 2, 150);
                    if (stringbutton(this.rd, "     OK     ", 495, 185, 2, paramInt1, paramInt2, paramBoolean, 0, 0))
                        this.editc = 0;
                }
                if (this.editc == 101) {
                    this.rd.setColor(new Color(244, 232, 204));
                    this.rd.fillRoundRect(232, 90, 527, 176, 20, 20);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawRoundRect(232, 90, 527, 176, 20, 20);
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("You are currently using a trial account.", 495 - this.ftm.stringWidth("You are currently using a trial account.") / 2, 120);
                    this.rd.drawString("You need to upgrade to be able participate in any NFM clan activity.", 495 - this.ftm.stringWidth("You need to upgrade to be able participate in any NFM clan activity.") / 2, 140);
                    this.rd.setColor(new Color(206, 171, 98));
                    this.rd.fillRoundRect(405, 163, 180, 50, 20, 20);
                    if (drawbutton(this.xt.upgrade, 495, 188, paramInt1, paramInt2, paramBoolean))
                        this.gs.editlink(this.xt.nickname, true);
                    if (stringbutton(this.rd, " Cancel ", 495, 244, 2, paramInt1, paramInt2, paramBoolean, 0, 0))
                        this.editc = 0;
                }
            } else {
                this.rd.drawString("Loading clan: " + this.claname + ", please wait...", 495 - this.ftm.stringWidth("Loading clan: " + this.claname + ", please wait...") / 2, 222);
            }
        } else {
            if (this.gs.clcars.isShowing()) this.gs.clcars.hide();
            if (this.editc != 0) {
                this.editc = 0;
                if (this.gs.clanlev.isShowing()) this.gs.clanlev.hide();
            }
        }
    }

    public void dotab2(int paramInt1, int paramInt2, boolean paramBoolean) {
        if (this.itab == 0) {
            if (this.litab != this.itab) {
                this.spos3 = 0;
                this.gs.senditem.hide();
                this.gs.datat.hide();
                this.gs.sendtyp.removeAll();
                this.gs.sendtyp.add(this.rd, "Write a Message");
                this.gs.sendtyp.add(this.rd, "Share a Custom Car");
                this.gs.sendtyp.add(this.rd, "Share a Custom Stage");
                this.gs.sendtyp.add(this.rd, "Send a Clan Invitation");
                this.gs.sendtyp.add(this.rd, "Share a Relative Date");
                if (!this.forcsel) {
                    this.gs.sendtyp.select(0);
                } else {
                    this.gs.sendtyp.select(this.itemsel);
                }
                this.forcsel = false;
                this.flko = 0;
                this.itemsel = 0;
                this.flko = 0;
                this.litab = this.itab;
            }
            if (this.openc != 10) {
                this.rd.setColor(color2k(230, 230, 230));
                this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
                if (this.loadmsgs != 0 && this.loadmsgs != -2 && this.loadmsgs != -1) {
                    this.sdist = (this.nm - 10) * 31;
                    if (this.sdist < 0) this.sdist = 0;
                    this.scro = (int) (this.spos3 / 268.0F * this.sdist);
                    byte b1 = 0;
                    byte b2;
                    for (b2 = 0; b2 < this.nm; ) {
                        if (this.mtyp[b2] != 3) {
                            if (76 + 31 * b1 - this.scro < 408 && 107 + 31 * b1 - this.scro > 76) {
                                boolean bool = false;
                                if (paramInt1 > 207 && paramInt1 < 770 && paramInt2 > 76 + 31 * b1 - this.scro && paramInt2 < 106 + 31 * b1 - this.scro) {
                                    bool = true;
                                    this.cur = 12;
                                    if (paramBoolean && this.openc == 0) {
                                        this.opy = 70 + 31 * b1 - this.scro;
                                        this.addopy = (40 - this.opy) / 10;
                                        this.oph = 44;
                                        this.openc = 1;
                                        if (!this.opname.equals(this.mname[b2])) {
                                            this.opname = this.mname[b2];
                                            this.lastsub = "";
                                            this.readmsg = 1;
                                        }
                                    }
                                }
                                if (this.mtyp[b2] == 1) {
                                    this.rd.setColor(color2k(240, 240, 240));
                                    this.rd.fillRect(207, 77 + 31 * b1 - this.scro, 564, 30);
                                }
                                if (bool) {
                                    this.rd.setColor(color2k(250, 250, 250));
                                    this.rd.fillRect(207, 77 + 31 * b1 - this.scro, 564, 30);
                                }
                                boolean bool1 = drawl(this.rd, this.mname[b2], 207, 77 + 31 * b1 - this.scro, bool);
                                if (!bool || !bool1) {
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString(this.mname[b2], 267 - this.ftm.stringWidth(this.mname[b2]) / 2, 96 + 31 * b1 - this.scro);
                                }
                                int[] arrayOfInt3 = {0, 5, 5, 14, 14, 5, 5}, arrayOfInt4 = {0, -5, -2, -2, 3, 3, 5};
                                if (this.mtyp[b2] != 2) {
                                    for (byte b = 0; b < 7; ) {
                                        arrayOfInt3[b] = arrayOfInt3[b] + 335;
                                        arrayOfInt4[b] = arrayOfInt4[b] + 98 + 31 * b1 - this.scro;
                                        b++;
                                    }
                                    this.rd.setColor(new Color(0, 128, 0));
                                } else {
                                    for (byte b = 0; b < 7; ) {
                                        arrayOfInt3[b] = 349 - arrayOfInt3[b];
                                        arrayOfInt4[b] = arrayOfInt4[b] + 98 + 31 * b1 - this.scro;
                                        b++;
                                    }
                                    this.rd.setColor(new Color(0, 0, 128));
                                }
                                this.rd.fillPolygon(arrayOfInt3, arrayOfInt4, 7);
                                this.rd.setFont(new Font("Tahoma", 0, 11));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.setColor(color2k(125, 125, 125));
                                this.rd.drawString(this.mtime[b2], 760 - this.ftm.stringWidth(this.mtime[b2]), 102 + 31 * b1 - this.scro);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString(this.msub[b2], 335, 89 + 31 * b1 - this.scro);
                                this.rd.setColor(color2k(150, 150, 150));
                                this.rd.drawLine(207, 107 + 31 * b1 - this.scro, 770, 107 + 31 * b1 - this.scro);
                            }
                            b1++;
                        }
                        b2++;
                    }
                    for (b2 = 0; b2 < this.nm; ) {
                        if (this.mtyp[b2] == 3) {
                            if (76 + 31 * b1 - this.scro < 408 && 107 + 31 * b1 - this.scro > 76) {
                                this.rd.setFont(new Font("Arial", 1, 12));
                                this.ftm = this.rd.getFontMetrics();
                                boolean bool = false;
                                if (paramInt1 > 207 && paramInt1 < 770 && paramInt2 > 76 + 31 * b1 - this.scro && paramInt2 < 106 + 31 * b1 - this.scro)
                                    bool = true;
                                boolean bool1 = drawl(this.rd, this.mname[b2], 207, 77 + 31 * b1 - this.scro, bool);
                                if (!bool || !bool1) {
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString(this.mname[b2], 267 - this.ftm.stringWidth(this.mname[b2]) / 2, 96 + 31 * b1 - this.scro);
                                }
                                this.rd.setColor(color2k(100, 100, 100));
                                this.rd.fillRect(327, 77 + 31 * b1 - this.scro, 444, 30);
                                this.rd.setColor(color2k(200, 200, 200));
                                if (this.unblockname.equals("")) {
                                    this.rd.drawString("Blocked", 337, 96 + 31 * b1 - this.scro);
                                } else {
                                    this.rd.drawString("Unblocking...", 337, 96 + 31 * b1 - this.scro);
                                }
                                if (bool && stringbutton(this.rd, "   Unblock  ", 724, 96 + 31 * b1 - this.scro, 3, paramInt1, paramInt2, paramBoolean, 0, 0) && this.unblockname.equals(""))
                                    this.unblockname = this.mname[b2];
                                this.rd.setColor(color2k(150, 150, 150));
                                this.rd.drawLine(207, 107 + 31 * b1 - this.scro, 770, 107 + 31 * b1 - this.scro);
                            }
                            b1++;
                        }
                        b2++;
                    }
                    this.rd.setColor(color2k(205, 205, 205));
                    this.rd.fillRect(207, 46, 582, 30);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    String[] arrayOfString;
                    int arrayOfInt1[], arrayOfInt2[], i;
                    for (this.ftm = this.rd.getFontMetrics(), arrayOfString = new String[]{"Player Interaction", "Clan Interaction", "Your Clan's Discussion"}, arrayOfInt1 = new int[]{207, 390, 368, 207}, arrayOfInt2 = new int[]{73, 73, 51, 51}, i = 0; i < 3; ) {
                        if (this.itab == i) {
                            this.rd.setColor(color2k(230, 230, 230));
                            this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
                        } else if (paramInt1 > arrayOfInt1[0] && paramInt1 < arrayOfInt1[2] && paramInt2 > 51 && paramInt2 < 73) {
                            this.rd.setColor(color2k(217, 217, 217));
                            this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
                            if (paramBoolean) this.itab = i;
                        }
                        this.rd.setColor(color2k(150, 150, 150));
                        this.rd.drawPolygon(arrayOfInt1, arrayOfInt2, 4);
                        this.rd.setColor(color2k(40, 40, 40));
                        this.rd.drawString(arrayOfString[i], arrayOfInt1[0] + 80 - this.ftm.stringWidth(arrayOfString[i]) / 2, 67);
                        for (byte b = 0; b < 4; ) {
                            arrayOfInt1[b] = arrayOfInt1[b] + 183;
                            b++;
                        }
                        i++;
                    }
                    this.rd.setColor(color2k(150, 150, 150));
                    this.rd.drawLine(207, 73, 770, 73);
                    this.rd.setColor(color2k(205, 205, 205));
                    this.rd.fillRect(207, 409, 582, 30);
                    this.rd.setColor(color2k(150, 150, 150));
                    this.rd.drawLine(207, 411, 770, 411);
                    this.rd.setColor(color2k(205, 205, 205));
                    this.rd.fillRect(772, 93, 17, 299);
                    this.rd.setColor(color2k(205, 205, 205));
                    this.rd.fillRect(203, 46, 4, 393);
                    if (this.mscro3 == 831 || this.sdist == 0) {
                        if (this.sdist == 0) {
                            this.rd.setColor(color2k(205, 205, 205));
                        } else {
                            this.rd.setColor(color2k(215, 215, 215));
                        }
                        this.rd.fillRect(772, 76, 17, 17);
                    } else {
                        this.rd.setColor(color2k(220, 220, 220));
                        this.rd.fill3DRect(772, 76, 17, 17, true);
                    }
                    if (this.sdist != 0) this.rd.drawImage(this.xt.asu, 777, 82, (ImageObserver) null);
                    if (this.mscro3 == 832 || this.sdist == 0) {
                        if (this.sdist == 0) {
                            this.rd.setColor(color2k(205, 205, 205));
                        } else {
                            this.rd.setColor(color2k(215, 215, 215));
                        }
                        this.rd.fillRect(772, 392, 17, 17);
                    } else {
                        this.rd.setColor(color2k(220, 220, 220));
                        this.rd.fill3DRect(772, 392, 17, 17, true);
                    }
                    if (this.sdist != 0) this.rd.drawImage(this.xt.asd, 777, 399, (ImageObserver) null);
                    if (this.sdist != 0) {
                        if (this.lspos3 != this.spos3) {
                            this.rd.setColor(color2k(215, 215, 215));
                            this.rd.fillRect(772, 93 + this.spos3, 17, 31);
                        } else {
                            if (this.mscro3 == 831) this.rd.setColor(color2k(215, 215, 215));
                            this.rd.fill3DRect(772, 93 + this.spos3, 17, 31, true);
                        }
                        this.rd.setColor(color2k(150, 150, 150));
                        this.rd.drawLine(777, 106 + this.spos3, 783, 106 + this.spos3);
                        this.rd.drawLine(777, 108 + this.spos3, 783, 108 + this.spos3);
                        this.rd.drawLine(777, 110 + this.spos3, 783, 110 + this.spos3);
                        if (this.mscro3 > 800 && this.lspos3 != this.spos3) this.lspos3 = this.spos3;
                        if (paramBoolean && this.openc == 0) {
                            if (this.mscro3 == 825 && paramInt1 > 772 && paramInt1 < 789 && paramInt2 > 93 + this.spos3 && paramInt2 < this.spos3 + 124)
                                this.mscro3 = paramInt2 - this.spos3;
                            if (this.mscro3 == 825 && paramInt1 > 770 && paramInt1 < 791 && paramInt2 > 74 && paramInt2 < 95)
                                this.mscro3 = 831;
                            if (this.mscro3 == 825 && paramInt1 > 770 && paramInt1 < 791 && paramInt2 > 390 && paramInt2 < 411)
                                this.mscro3 = 832;
                            if (this.mscro3 == 825 && paramInt1 > 772 && paramInt1 < 789 && paramInt2 > 93 && paramInt2 < 392) {
                                this.mscro3 = 108;
                                this.spos3 = paramInt2 - this.mscro3;
                            }
                            i = 2670 / this.sdist;
                            if (i < 1) i = 1;
                            if (this.mscro3 == 831) {
                                this.spos3 -= i;
                                if (this.spos3 > 268) this.spos3 = 268;
                                if (this.spos3 < 0) this.spos3 = 0;
                                this.lspos3 = this.spos3;
                            }
                            if (this.mscro3 == 832) {
                                this.spos3 += i;
                                if (this.spos3 > 268) this.spos3 = 268;
                                if (this.spos3 < 0) this.spos3 = 0;
                                this.lspos3 = this.spos3;
                            }
                            if (this.mscro3 < 800) {
                                this.spos3 = paramInt2 - this.mscro3;
                                if (this.spos3 > 268) this.spos3 = 268;
                                if (this.spos3 < 0) this.spos3 = 0;
                            }
                            if (this.mscro3 == 825) this.mscro3 = 925;
                        } else if (this.mscro3 != 825) {
                            this.mscro3 = 825;
                        }
                    }
                } else {
                    this.rd.setColor(color2k(205, 205, 205));
                    this.rd.fillRect(207, 46, 582, 30);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    String[] arrayOfString;
                    int[] arrayOfInt1, arrayOfInt2;
                    byte b;
                    for (this.ftm = this.rd.getFontMetrics(), arrayOfString = new String[]{"Player Interaction", "Clan Interaction", "Your Clan's Discussion"}, arrayOfInt1 = new int[]{207, 390, 368, 207}, arrayOfInt2 = new int[]{73, 73, 51, 51}, b = 0; b < 3; ) {
                        if (this.itab == b) {
                            this.rd.setColor(color2k(230, 230, 230));
                            this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
                        } else if (paramInt1 > arrayOfInt1[0] && paramInt1 < arrayOfInt1[2] && paramInt2 > 51 && paramInt2 < 73) {
                            this.rd.setColor(color2k(217, 217, 217));
                            this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
                            if (paramBoolean) this.itab = b;
                        }
                        this.rd.setColor(color2k(150, 150, 150));
                        this.rd.drawPolygon(arrayOfInt1, arrayOfInt2, 4);
                        this.rd.setColor(color2k(40, 40, 40));
                        this.rd.drawString(arrayOfString[b], arrayOfInt1[0] + 80 - this.ftm.stringWidth(arrayOfString[b]) / 2, 67);
                        for (byte b1 = 0; b1 < 4; ) {
                            arrayOfInt1[b1] = arrayOfInt1[b1] + 183;
                            b1++;
                        }
                        b++;
                    }
                    this.rd.setColor(color2k(150, 150, 150));
                    this.rd.drawLine(207, 73, 770, 73);
                    this.rd.setColor(color2k(205, 205, 205));
                    this.rd.fillRect(207, 409, 582, 30);
                    this.rd.setColor(color2k(150, 150, 150));
                    this.rd.drawLine(207, 411, 770, 411);
                    this.rd.setColor(color2k(205, 205, 205));
                    this.rd.fillRect(772, 76, 17, 333);
                    this.rd.setColor(color2k(205, 205, 205));
                    this.rd.fillRect(203, 46, 4, 393);
                    if (this.loadmsgs == 0) {
                        this.rd.setFont(new Font("Arial", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("You have not started any conversations yet.", 487 - this.ftm.stringWidth("You have not started any conversations yet.") / 2, 200);
                    }
                    if (this.loadmsgs == -2) {
                        this.rd.setFont(new Font("Arial", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Failed to load conversations, will try again now...", 487 - this.ftm.stringWidth("Failed to load conversations, will try again now...") / 2, 200);
                    }
                    if (this.loadmsgs == -1) {
                        this.rd.setFont(new Font("Arial", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Loading conversations, please wait...", 487 - this.ftm.stringWidth("Loading conversation, please wait...") / 2, 200);
                    }
                }
                if (this.gs.sendtyp.isShowing()) {
                    this.gs.sendtyp.hide();
                    this.gs.sendtyp.select(0);
                    this.flko = 0;
                }
                if (this.gs.senditem.isShowing()) this.gs.senditem.hide();
                if (this.gs.datat.isShowing()) this.gs.datat.hide();
            } else {
                this.rd.setColor(color2k(240, 240, 240));
                this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
                this.rd.setColor(color2k(250, 250, 250));
                this.rd.fillRect(207, 86, 577, 274);
                this.sdist = (int) ((this.nml - 14.75F) * 17.0F);
                if (this.sdist < 0) this.sdist = 0;
                this.scro = (int) (this.spos4 / 208.0F * this.sdist);
                if (this.readmsg == 2) {
                    if (this.gs.openm) {
                        this.blockb = 10;
                    } else if (this.blockb != 0) {
                        this.blockb--;
                    }
                    for (byte b = 0; b < this.nml; b++) {
                        if (86 + 17 * b - this.scro < 360 && 125 + 17 * b - this.scro > 86 && this.mlinetyp[b] != 167) {
                            this.rd.setColor(new Color(0, 0, 0));
                            if (this.mlinetyp[b] != 10 && this.mlinetyp[b] != 20 && this.mlinetyp[b] != 30) {
                                if (this.mlinetyp[b] == 0 || this.mlinetyp[b] == 1 || this.mlinetyp[b] == 2 || this.mlinetyp[b] == 3 || this.mlinetyp[b] == 4) {
                                    this.rd.setFont(new Font("Tahoma", 1, 11));
                                } else {
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                }
                                this.rd.drawString(this.mline[b], 217, 103 + 17 * b - this.scro);
                                if (this.mlinetyp[b] == 0 || this.mlinetyp[b] == 1 || this.mlinetyp[b] == 2 || this.mlinetyp[b] == 3 || this.mlinetyp[b] == 4) {
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(color2k(125, 125, 125));
                                    this.rd.drawString(this.mtimes[b], 757 - this.ftm.stringWidth(this.mtimes[b]), 103 + 17 * b - this.scro);
                                }
                            } else {
                                if (this.mlinetyp[b] == 30) {
                                    boolean bool = true;
                                    if (paramInt1 > 217 && paramInt1 < 567 && paramInt2 > 93 + b * 17 - this.scro && paramInt2 < 123 + b * 17 - this.scro && this.blockb == 0) {
                                        this.cur = 12;
                                        bool = false;
                                        if (paramBoolean) {
                                            if (!this.claname.equals(this.mline[b])) {
                                                this.claname = this.mline[b];
                                                this.loadedc = false;
                                            }
                                            this.tab = 3;
                                            this.spos5 = 0;
                                            this.lspos5 = 0;
                                            this.cfase = 3;
                                            this.ctab = 0;
                                        }
                                    }
                                    if (!drawl(this.rd, "#" + this.mline[b] + "#", 217, 93 + b * 17 - this.scro, bool) || !bool) {
                                        this.rd.setColor(new Color(0, 0, 0));
                                        this.rd.drawRect(217, 93 + b * 17 - this.scro, 349, 29);
                                        this.rd.setFont(new Font("Arial", 1, 13));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.drawString("" + this.mline[b] + "", 392 - this.ftm.stringWidth("" + this.mline[b] + "") / 2, 113 + b * 17 - this.scro);
                                    }
                                }
                                if (this.mlinetyp[b] == 10) {
                                    if (this.cd.acname.equals(this.mline[b])) {
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        if (this.cd.action == -9)
                                            this.rd.drawString("Failed to add car!  Unknown error, please try again later.", 217, 109 + 17 * b - this.scro);
                                        if (this.cd.action == -8)
                                            this.rd.drawString("Cannot add more then 20 cars to your account!", 217, 109 + 17 * b - this.scro);
                                        if (this.cd.action == 7) {
                                            this.rd.setColor(new Color(94, 170, 0));
                                            this.rd.drawString("[" + this.mline[b] + "] has been added to your cars!", 217, 109 + 17 * b - this.scro);
                                        }
                                        if (this.cd.action == -7)
                                            this.rd.drawString("You already have this car.", 217, 109 + 17 * b - this.scro);
                                        if (this.cd.action == 6)
                                            this.rd.drawString("Adding Car...", 217, 109 + 17 * b - this.scro);
                                        if (this.cd.action == -6) {
                                            this.rd.setColor(new Color(193, 106, 0));
                                            String str1 = "Upgrade to a full account to add custom cars!";
                                            char c = 'Ù';
                                            int i = c + this.ftm.stringWidth(str1);
                                            this.rd.drawString(str1, c, 109 + 17 * b - this.scro);
                                            if (this.waitlink != -1)
                                                this.rd.drawLine(c, 111 + 17 * b - this.scro, i, 111 + 17 * b - this.scro);
                                            if (paramInt1 > c && paramInt1 < i && paramInt2 > 98 + 17 * b - this.scro && paramInt2 < 111 + 17 * b - this.scro) {
                                                if (this.waitlink != -1) this.cur = 12;
                                                if (paramBoolean && this.waitlink == 0) {
                                                    this.gs.editlink(this.xt.nickname, true);
                                                    this.waitlink = -1;
                                                }
                                            }
                                            if (this.waitlink > 0) this.waitlink--;
                                        }
                                    }
                                    if (this.cd.action == 0 || !this.cd.acname.equals(this.mline[b])) {
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.rd.drawString("[  " + this.mline[b] + "  ]", 340, 109 + 17 * b - this.scro);
                                        if (this.xt.drawcarb(true, null, " Add to My Cars ", 217, 90 + 17 * b - this.scro, paramInt1, paramInt2, (paramBoolean && this.blockb == 0)))
                                            if (this.xt.logged) {
                                                this.cd.action = 6;
                                                this.cd.ac = -1;
                                                this.cd.acname = this.mline[b];
                                                this.cd.sparkactionloader();
                                            } else {
                                                this.cd.acname = this.mline[b];
                                                this.cd.action = -6;
                                                this.waitlink = 20;
                                            }
                                    }
                                }
                                if (this.mlinetyp[b] == 20) {
                                    if (this.cd.onstage.equals(this.mline[b])) {
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.ftm = this.rd.getFontMetrics();
                                        if (this.addstage == 2) {
                                            this.rd.drawString("Adding stage...", 217, 109 + 17 * b - this.scro);
                                            if (this.cd.staction == 0) this.addstage = 3;
                                            if (this.cd.staction == -2) this.addstage = 4;
                                            if (this.cd.staction == -3) this.addstage = 5;
                                            if (this.cd.staction == -1) this.addstage = 6;
                                        }
                                        if (this.addstage == 3) {
                                            this.rd.setColor(new Color(94, 170, 0));
                                            this.rd.drawString("[" + this.mline[b] + "] has been added to your stages!", 217, 109 + 17 * b - this.scro);
                                        }
                                        if (this.addstage == 4)
                                            this.rd.drawString("You already have this stage.", 217, 109 + 17 * b - this.scro);
                                        if (this.addstage == 5)
                                            this.rd.drawString("Cannot add more then 20 stages to your account!", 217, 109 + 17 * b - this.scro);
                                        if (this.addstage == 6)
                                            this.rd.drawString("Failed to add stage!  Unknown error, please try again later.", 217, 109 + 17 * b - this.scro);
                                        if (this.addstage == 1) {
                                            this.rd.setColor(new Color(193, 106, 0));
                                            String str1 = "Upgrade to a full account to add custom stages!";
                                            char c = 'Ù';
                                            int i = c + this.ftm.stringWidth(str1);
                                            this.rd.drawString(str1, c, 109 + 17 * b - this.scro);
                                            if (this.waitlink != -1)
                                                this.rd.drawLine(c, 111 + 17 * b - this.scro, i, 111 + 17 * b - this.scro);
                                            if (paramInt1 > c && paramInt1 < i && paramInt2 > 98 + 17 * b - this.scro && paramInt2 < 111 + 17 * b - this.scro) {
                                                if (this.waitlink != -1) this.cur = 12;
                                                if (paramBoolean && this.waitlink == 0) {
                                                    this.gs.editlink(this.xt.nickname, true);
                                                    this.waitlink = -1;
                                                }
                                            }
                                            if (this.waitlink > 0) this.waitlink--;
                                        }
                                    }
                                    if (this.addstage == 0 || !this.cd.onstage.equals(this.mline[b])) {
                                        this.rd.setFont(new Font("Arial", 1, 12));
                                        this.rd.drawString("[  " + this.mline[b] + "  ]", 355, 109 + 17 * b - this.scro);
                                        if (this.xt.drawcarb(true, null, " Add to My Stages ", 217, 90 + 17 * b - this.scro, paramInt1, paramInt2, (paramBoolean && this.blockb == 0)))
                                            if (this.xt.logged) {
                                                this.cd.onstage = this.mline[b];
                                                this.cd.staction = 2;
                                                this.cd.sparkstageaction();
                                                this.addstage = 2;
                                            } else {
                                                this.cd.onstage = this.mline[b];
                                                this.addstage = 1;
                                                this.waitlink = 20;
                                            }
                                    }
                                }
                            }
                        }
                    }
                }
                if (this.readmsg == 1) {
                    this.rd.setFont(new Font("Tahoma", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Reading...", 487 - this.ftm.stringWidth("Reading...") / 2, 200);
                }
                if (this.readmsg == 3) {
                    this.rd.setFont(new Font("Tahoma", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Failed to fetch and load conversation.", 487 - this.ftm.stringWidth("Failed to fetch and load conversation.") / 2, 200);
                }
                if (this.readmsg == 4) {
                    this.rd.setFont(new Font("Tahoma", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Failed to load conversation, server error, please try again later.", 487 - this.ftm.stringWidth("Failed to load conversation, please try again later.") / 2, 200);
                }
                if (this.readmsg == 5) {
                    this.rd.setFont(new Font("Tahoma", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Failed to send message, server error, please try again later.", 487 - this.ftm.stringWidth("Failed to send message, server error, please try again later.") / 2, 200);
                }
                this.rd.setColor(color2k(240, 240, 240));
                this.rd.fillRect(207, 47, 577, 39);
                this.rd.fillRect(207, 360, 577, 39);
                this.rd.setColor(color2k(205, 205, 205));
                this.rd.drawLine(207, 86, 783, 86);
                this.rd.drawLine(207, 86, 207, 360);
                this.rd.drawLine(207, 360, 783, 360);
                this.rd.fillRect(767, 104, 17, 239);
                if (this.mscro4 == 831 || this.sdist == 0) {
                    if (this.sdist == 0) {
                        this.rd.setColor(color2k(205, 205, 205));
                    } else {
                        this.rd.setColor(color2k(215, 215, 215));
                    }
                    this.rd.fillRect(767, 87, 17, 17);
                } else {
                    this.rd.setColor(color2k(220, 220, 220));
                    this.rd.fill3DRect(767, 87, 17, 17, true);
                }
                if (this.sdist != 0) this.rd.drawImage(this.xt.asu, 772, 93, (ImageObserver) null);
                if (this.mscro4 == 832 || this.sdist == 0) {
                    if (this.sdist == 0) {
                        this.rd.setColor(color2k(205, 205, 205));
                    } else {
                        this.rd.setColor(color2k(215, 215, 215));
                    }
                    this.rd.fillRect(767, 343, 17, 17);
                } else {
                    this.rd.setColor(color2k(220, 220, 220));
                    this.rd.fill3DRect(767, 343, 17, 17, true);
                }
                if (this.sdist != 0) this.rd.drawImage(this.xt.asd, 772, 350, (ImageObserver) null);
                if (this.sdist != 0) {
                    if (this.lspos4 != this.spos4) {
                        this.rd.setColor(color2k(215, 215, 215));
                        this.rd.fillRect(767, 104 + this.spos4, 17, 31);
                    } else {
                        if (this.mscro4 == 831) this.rd.setColor(color2k(215, 215, 215));
                        this.rd.fill3DRect(767, 104 + this.spos4, 17, 31, true);
                    }
                    this.rd.setColor(color2k(150, 150, 150));
                    this.rd.drawLine(772, 117 + this.spos4, 778, 117 + this.spos4);
                    this.rd.drawLine(772, 119 + this.spos4, 778, 119 + this.spos4);
                    this.rd.drawLine(772, 121 + this.spos4, 778, 121 + this.spos4);
                    if (this.mscro4 > 800 && this.lspos4 != this.spos4) this.lspos4 = this.spos4;
                    if (paramBoolean) {
                        if (this.mscro4 == 825 && paramInt1 > 767 && paramInt1 < 784 && paramInt2 > 104 + this.spos4 && paramInt2 < this.spos4 + 135)
                            this.mscro4 = paramInt2 - this.spos4;
                        if (this.mscro4 == 825 && paramInt1 > 765 && paramInt1 < 786 && paramInt2 > 85 && paramInt2 < 106)
                            this.mscro4 = 831;
                        if (this.mscro4 == 825 && paramInt1 > 765 && paramInt1 < 786 && paramInt2 > 341 && paramInt2 < 362)
                            this.mscro4 = 832;
                        if (this.mscro4 == 825 && paramInt1 > 767 && paramInt1 < 784 && paramInt2 > 104 && paramInt2 < 343) {
                            this.mscro4 = 119;
                            this.spos4 = paramInt2 - this.mscro4;
                        }
                        int i = 2670 / this.sdist;
                        if (i < 1) i = 1;
                        if (this.mscro4 == 831) {
                            this.spos4 -= i;
                            if (this.spos4 > 208) this.spos4 = 208;
                            if (this.spos4 < 0) this.spos4 = 0;
                            this.lspos4 = this.spos4;
                        }
                        if (this.mscro4 == 832) {
                            this.spos4 += i;
                            if (this.spos4 > 208) this.spos4 = 208;
                            if (this.spos4 < 0) this.spos4 = 0;
                            this.lspos4 = this.spos4;
                        }
                        if (this.mscro4 < 800) {
                            this.spos4 = paramInt2 - this.mscro4;
                            if (this.spos4 > 208) this.spos4 = 208;
                            if (this.spos4 < 0) this.spos4 = 0;
                        }
                        if (this.mscro4 == 825) this.mscro4 = 925;
                    } else if (this.mscro4 != 825) {
                        this.mscro4 = 825;
                    }
                }
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                if (!drawl(this.rd, this.opname, 207, 47, true)) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString(this.opname, 267 - this.ftm.stringWidth(this.opname) / 2, 66);
                    this.rd.setColor(color2k(150, 150, 150));
                    this.rd.drawRect(207, 47, 119, 29);
                }
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString("::  Conversation with " + this.opname + "", 336, 72);
                if (paramInt1 > 207 && paramInt1 < 327 && paramInt2 > 47 && paramInt2 < 77) {
                    this.cur = 12;
                    if (paramBoolean) {
                        this.tab = 1;
                        if (!this.proname.equals(this.opname)) {
                            this.proname = this.opname;
                            this.loadedp = false;
                            onexitpro();
                        }
                    }
                }
                if (stringbutton(this.rd, "Block / Ignore", 665, 66, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                    this.openc = 0;
                    this.blockname = this.opname;
                }
                if (stringbutton(this.rd, "Close X", 752, 66, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                    this.openc = 0;
                    this.readmsg = 0;
                }
                if (!this.gs.sendtyp.isShowing()) this.gs.sendtyp.show();
                this.gs.sendtyp.move(207, 365);
                if (this.sendmsg != 0) {
                    this.gs.sendtyp.disable();
                } else {
                    this.gs.sendtyp.enable();
                }
                String str = "";
                if (this.gs.sendtyp.getSelectedIndex() == 0) {
                    this.dommsg = true;
                    if (this.loaditem != 0) this.loaditem = 0;
                }
                if (this.gs.sendtyp.getSelectedIndex() == 1) {
                    str = "car";
                    this.rd.setFont(new Font("Arial", 0, 12));
                    this.rd.drawString("Send a public car you have or a private car that belongs to you.", 376, 382);
                }
                if (this.gs.sendtyp.getSelectedIndex() == 2) {
                    str = "stage";
                    this.rd.setFont(new Font("Arial", 0, 12));
                    this.rd.drawString("Send a public stage you have or a private stage that belongs to you.", 376, 382);
                }
                if (this.gs.sendtyp.getSelectedIndex() == 3) {
                    this.rd.setFont(new Font("Arial", 0, 12));
                    this.rd.drawString("Send an invitation to " + this.opname + " to join your clan.", 376, 382);
                }
                if (this.gs.sendtyp.getSelectedIndex() == 4) {
                    this.rd.setFont(new Font("Arial", 0, 12));
                    this.rd.drawString("A date that gets converted to the local time of the person previewing it.", 376, 382);
                }
                if (this.itemsel != this.gs.sendtyp.getSelectedIndex()) {
                    this.gs.senditem.hide();
                    this.gs.datat.hide();
                    this.itemsel = this.gs.sendtyp.getSelectedIndex();
                }
                if (this.gs.sendtyp.getSelectedIndex() == 0) if (this.sendmsg == 0) {
                    if (stringbutton(this.rd, "   Send  >  ", 723, 408, 0, paramInt1, paramInt2, paramBoolean, 0, 0) && !this.gs.mmsg.getText().trim().equals("") && this.gs.mmsg.getText().toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) == -1 && this.xt.acexp != -3)
                        if (!this.xt.msgcheck(this.gs.mmsg.getText())) {
                            this.sendmsg = 1;
                        } else {
                            this.gs.sendtyp.hide();
                            this.xt.warning++;
                        }
                } else {
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 408);
                }
                if (this.gs.sendtyp.getSelectedIndex() == 1 || this.gs.sendtyp.getSelectedIndex() == 2) {
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Select " + str + " to share:", 207, 420);
                    if (!this.gs.senditem.isShowing()) {
                        this.gs.senditem.removeAll();
                        if (this.xt.logged) {
                            this.gs.senditem.add(this.rd, "Loading your " + str + " list, please wait...");
                            this.loaditem = this.gs.sendtyp.getSelectedIndex();
                        } else {
                            this.gs.senditem.add(this.rd, "You need to upgrade to have custom " + str + "s!");
                        }
                        this.gs.senditem.select(0);
                        this.gs.senditem.show();
                    }
                    this.gs.senditem.move(207 + this.ftm.stringWidth("Select " + str + " to share:") + 11, 403);
                    if ((this.loaditem == 10 && this.gs.sendtyp.getSelectedIndex() == 1) || (this.loaditem == 20 && this.gs.sendtyp.getSelectedIndex() == 2) || !this.xt.logged)
                        if (this.xt.logged) {
                            if (this.sendmsg == 0) {
                                if (stringbutton(this.rd, "   Send  >  ", 723, 420, 0, paramInt1, paramInt2, paramBoolean, 0, 0))
                                    this.sendmsg = 1;
                            } else {
                                this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 420);
                            }
                        } else {
                            this.rd.setColor(new Color(206, 171, 98));
                            this.rd.fillRoundRect(651, 391, 136, 46, 20, 20);
                            if (drawbutton(this.xt.upgrade, 719, 414, paramInt1, paramInt2, paramBoolean))
                                this.gs.editlink(this.xt.nickname, true);
                        }
                }
                if (this.gs.sendtyp.getSelectedIndex() == 3) {
                    if (!this.xt.clan.equals("")) {
                        char c = 'Ĳ';
                        short s = -195;
                        if (!drawl(this.rd, "#" + this.xt.clan + "#", 406 + s, 101 + c, true)) {
                            this.rd.setFont(new Font("Arial", 1, 13));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.drawString("" + this.xt.clan + "", 581 + s - this.ftm.stringWidth("" + this.xt.clan + "") / 2, 121 + c);
                        }
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        String str1 = "Your Clan";
                        if (paramInt1 > 402 + s && paramInt1 < 759 + s && paramInt2 > 84 + c && paramInt2 < 134 + c) {
                            str1 = "Clan :  " + this.xt.clan + "";
                            this.rd.drawLine(408 + s, 98 + c, 408 + s + this.ftm.stringWidth(str1), 98 + c);
                            if ((paramInt1 > 408 + s && paramInt1 < 408 + s + this.ftm.stringWidth(str1) && paramInt2 > 85 + c && paramInt2 < 100 + c) || (paramInt1 > 406 + s && paramInt1 < 756 + s && paramInt2 > 101 + c && paramInt2 < 131 + c)) {
                                this.cur = 12;
                                if (paramBoolean && this.sendmsg == 0) {
                                    if (!this.claname.equals(this.xt.clan)) {
                                        this.claname = this.xt.clan;
                                        this.loadedc = false;
                                    }
                                    this.tab = 3;
                                    this.spos5 = 0;
                                    this.lspos5 = 0;
                                    this.cfase = 3;
                                    this.ctab = 0;
                                }
                            }
                        }
                        this.rd.drawString(str1, 408 + s, 97 + c);
                        this.rd.drawLine(402 + s, 84 + c, 402 + s, 134 + c);
                        this.rd.drawLine(402 + s, 84 + c, 408 + s + this.ftm.stringWidth(str1) + 2, 84 + c);
                        this.rd.drawLine(408 + s + this.ftm.stringWidth(str1) + 2, 84 + c, 408 + s + this.ftm.stringWidth(str1) + 15, 97 + c);
                        this.rd.drawLine(408 + s + this.ftm.stringWidth(str1) + 15, 97 + c, 759 + s, 97 + c);
                        this.rd.drawLine(759 + s, 97 + c, 759 + s, 134 + c);
                        this.rd.drawLine(402 + s, 134 + c, 759 + s, 134 + c);
                    } else if (this.xt.logged) {
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        if (this.flko % 4 != 0 || this.flko == 0)
                            this.rd.drawString("You are not a member of any clan yet!", 376 - this.ftm.stringWidth("You are not a member of any clan yet!") / 2, 417);
                        if (this.flko != 0) this.flko--;
                    } else {
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("You need to upgrade to a full account to participate in NFM clan's activities.", 207, 420);
                        this.rd.setColor(new Color(206, 171, 98));
                        this.rd.fillRoundRect(651, 391, 136, 46, 20, 20);
                        if (drawbutton(this.xt.upgrade, 719, 414, paramInt1, paramInt2, paramBoolean))
                            this.gs.editlink(this.xt.nickname, true);
                    }
                    if (this.xt.logged) if (this.sendmsg == 0) {
                        if (stringbutton(this.rd, "   Send  >  ", 723, 408, 0, paramInt1, paramInt2, paramBoolean, 0, 0))
                            if (!this.xt.clan.equals("")) {
                                this.sendmsg = 1;
                            } else {
                                this.flko = 45;
                            }
                    } else {
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 408);
                    }
                }
                if (this.gs.sendtyp.getSelectedIndex() == 4) {
                    if (!this.gs.senditem.isShowing()) {
                        this.gs.senditem.removeAll();
                        Calendar calendar;
                        boolean bool;
                        byte b;
                        for (calendar = Calendar.getInstance(), bool = false, b = 0; b < 20; ) {
                            String str1 = this.wday[calendar.get(7) - 1];
                            if (!bool) {
                                str1 = "Today";
                                bool = true;
                            }
                            this.gs.senditem.add(this.rd, "" + str1 + "  -  " + this.month[calendar.get(2)] + " " + calendar.get(5) + "");
                            calendar.roll(5, true);
                            b++;
                        }
                        this.gs.senditem.select(0);
                        this.gs.senditem.show();
                    }
                    if (!this.gs.datat.isShowing()) {
                        this.gs.datat.removeAll();
                        byte b1;
                        String str1;
                        byte b2;
                        for (b1 = 12, str1 = "PM", b2 = 0; b2 < 24; ) {
                            this.gs.datat.add(this.rd, "" + b1 + " " + str1 + "");
                            if (++b1 == 12) str1 = "AM";
                            if (b1 == 13) b1 = 1;
                            b2++;
                        }
                        this.gs.datat.select(0);
                        this.gs.datat.show();
                    }
                    this.gs.senditem.move(300, 395);
                    this.gs.datat.move(491, 395);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Date is displayed based on your computer calendar's date/time, please make sure it is correct.", 207, 435);
                    if (this.sendmsg == 0) {
                        if (stringbutton(this.rd, "   Send  >  ", 723, 408, 0, paramInt1, paramInt2, paramBoolean, 0, 0))
                            this.sendmsg = 1;
                    } else {
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 408);
                    }
                }
            }
            if (this.openc >= 1 && this.openc < 10) {
                this.rd.setColor(color2k(240, 240, 230));
                this.rd.fillRoundRect(197, this.opy, 597, this.oph, 20, 20);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRoundRect(197, this.opy, 597, this.oph, 20, 20);
                if (!drawl(this.rd, this.opname, 207, this.opy + 7, true)) {
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString(this.opname, 267 - this.ftm.stringWidth(this.opname) / 2, this.opy + 26);
                    this.rd.setColor(color2k(150, 150, 150));
                    this.rd.drawRect(207, this.opy + 7, 119, 29);
                }
                this.opy += this.addopy;
                this.oph += 36;
                this.openc++;
            }
        }
        if (this.itab == 1) {
            if (this.litab != this.itab) {
                this.spos3 = 0;
                this.gs.senditem.hide();
                this.gs.datat.hide();
                this.gs.sendtyp.removeAll();
                this.gs.sendtyp.add(this.rd, "Write a Message");
                this.gs.sendtyp.add(this.rd, "Share a Relative Date");
                this.gs.sendtyp.add(this.rd, "Battle over Stage");
                this.gs.sendtyp.add(this.rd, "Battle over Car");
                this.gs.sendtyp.add(this.rd, "Declare War");
                if (!this.redif) {
                    this.gs.sendtyp.select(0);
                } else {
                    this.gs.sendtyp.select(this.intsel);
                    if (this.intsel == 4) this.redif = false;
                }
                if (this.sendwarnum) this.gs.sendtyp.sel = this.intsel;
                this.intsel = 0;
                this.litab = this.itab;
            }
            if (!this.xt.clan.equals("")) {
                if (this.openi != 10) {
                    this.rd.setColor(color2k(230, 230, 230));
                    this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
                    if (this.loadinter != 0 && this.loadinter != -2 && this.loadinter != -1) {
                        this.sdist = (this.ni - 10) * 31;
                        if (this.sdist < 0) this.sdist = 0;
                        this.scro = (int) (this.spos3 / 268.0F * this.sdist);
                        byte b1 = 0;
                        for (byte b2 = 0; b2 < this.ni; b2++) {
                            if (76 + 31 * b1 - this.scro < 408 && 107 + 31 * b1 - this.scro > 76) {
                                boolean bool = false;
                                if (paramInt1 > 207 && paramInt1 < 770 && paramInt2 > 76 + 31 * b1 - this.scro && paramInt2 < 106 + 31 * b1 - this.scro) {
                                    bool = true;
                                    this.cur = 12;
                                    if (paramBoolean && this.openc == 0) {
                                        this.opy = 70 + 31 * b1 - this.scro;
                                        this.addopy = (40 - this.opy) / 10;
                                        this.oph = 44;
                                        this.openi = 1;
                                        if (!this.intclan.equals(this.iclan[b2])) {
                                            this.intclan = this.iclan[b2];
                                            this.dispi = 0;
                                            this.nil = 0;
                                            this.lastint = "";
                                            this.readint = 1;
                                        }
                                    }
                                }
                                if (this.icheck[b2].toLowerCase().indexOf(this.xt.nickname.toLowerCase()) == -1) {
                                    this.rd.setColor(color2k(240, 240, 240));
                                    this.rd.fillRect(207, 77 + 31 * b1 - this.scro, 564, 30);
                                }
                                if (bool) {
                                    this.rd.setColor(color2k(250, 250, 250));
                                    this.rd.fillRect(207, 77 + 31 * b1 - this.scro, 564, 30);
                                }
                                boolean bool1 = drawl(this.rd, "#" + this.iclan[b2] + "#", 207, 77 + 31 * b1 - this.scro, bool);
                                if (!bool || !bool1) {
                                    this.rd.setFont(new Font("Arial", 1, 12));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.drawString(this.iclan[b2], 382 - this.ftm.stringWidth(this.iclan[b2]) / 2, 96 + 31 * b1 - this.scro);
                                }
                                this.rd.setFont(new Font("Tahoma", 0, 11));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.setColor(color2k(125, 125, 125));
                                this.rd.drawString(this.itime[b2], 760 - this.ftm.stringWidth(this.itime[b2]), 102 + 31 * b1 - this.scro);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString(this.isub[b2], 565, 89 + 31 * b1 - this.scro);
                                this.rd.setFont(new Font("Arial", 1, 11));
                                this.rd.setColor(new Color(117, 67, 0));
                                this.rd.drawString(this.istat[b2], 565, 102 + 31 * b1 - this.scro);
                                this.rd.setColor(color2k(150, 150, 150));
                                this.rd.drawLine(207, 107 + 31 * b1 - this.scro, 770, 107 + 31 * b1 - this.scro);
                            }
                            b1++;
                        }
                        this.rd.setColor(color2k(205, 205, 205));
                        this.rd.fillRect(207, 46, 582, 30);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        String[] arrayOfString;
                        int arrayOfInt1[], arrayOfInt2[], i;
                        for (this.ftm = this.rd.getFontMetrics(), arrayOfString = new String[]{"Player Interaction", "Clan Interaction", "Your Clan's Discussion"}, arrayOfInt1 = new int[]{207, 390, 368, 207}, arrayOfInt2 = new int[]{73, 73, 51, 51}, i = 0; i < 3; ) {
                            if (this.itab == i) {
                                this.rd.setColor(color2k(230, 230, 230));
                                this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
                            } else if (paramInt1 > arrayOfInt1[0] && paramInt1 < arrayOfInt1[2] && paramInt2 > 51 && paramInt2 < 73) {
                                this.rd.setColor(color2k(217, 217, 217));
                                this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
                                if (paramBoolean) this.itab = i;
                            }
                            this.rd.setColor(color2k(150, 150, 150));
                            this.rd.drawPolygon(arrayOfInt1, arrayOfInt2, 4);
                            this.rd.setColor(color2k(40, 40, 40));
                            this.rd.drawString(arrayOfString[i], arrayOfInt1[0] + 80 - this.ftm.stringWidth(arrayOfString[i]) / 2, 67);
                            for (byte b = 0; b < 4; ) {
                                arrayOfInt1[b] = arrayOfInt1[b] + 183;
                                b++;
                            }
                            i++;
                        }
                        this.rd.setColor(color2k(150, 150, 150));
                        this.rd.drawLine(207, 73, 770, 73);
                        this.rd.setColor(color2k(205, 205, 205));
                        this.rd.fillRect(207, 409, 582, 30);
                        this.rd.setColor(color2k(150, 150, 150));
                        this.rd.drawLine(207, 411, 770, 411);
                        this.rd.setColor(color2k(205, 205, 205));
                        this.rd.fillRect(772, 93, 17, 299);
                        this.rd.setColor(color2k(205, 205, 205));
                        this.rd.fillRect(203, 46, 4, 393);
                        if (this.mscro3 == 831 || this.sdist == 0) {
                            if (this.sdist == 0) {
                                this.rd.setColor(color2k(205, 205, 205));
                            } else {
                                this.rd.setColor(color2k(215, 215, 215));
                            }
                            this.rd.fillRect(772, 76, 17, 17);
                        } else {
                            this.rd.setColor(color2k(220, 220, 220));
                            this.rd.fill3DRect(772, 76, 17, 17, true);
                        }
                        if (this.sdist != 0) this.rd.drawImage(this.xt.asu, 777, 82, (ImageObserver) null);
                        if (this.mscro3 == 832 || this.sdist == 0) {
                            if (this.sdist == 0) {
                                this.rd.setColor(color2k(205, 205, 205));
                            } else {
                                this.rd.setColor(color2k(215, 215, 215));
                            }
                            this.rd.fillRect(772, 392, 17, 17);
                        } else {
                            this.rd.setColor(color2k(220, 220, 220));
                            this.rd.fill3DRect(772, 392, 17, 17, true);
                        }
                        if (this.sdist != 0) this.rd.drawImage(this.xt.asd, 777, 399, (ImageObserver) null);
                        if (this.sdist != 0) {
                            if (this.lspos3 != this.spos3) {
                                this.rd.setColor(color2k(215, 215, 215));
                                this.rd.fillRect(772, 93 + this.spos3, 17, 31);
                            } else {
                                if (this.mscro3 == 831) this.rd.setColor(color2k(215, 215, 215));
                                this.rd.fill3DRect(772, 93 + this.spos3, 17, 31, true);
                            }
                            this.rd.setColor(color2k(150, 150, 150));
                            this.rd.drawLine(777, 106 + this.spos3, 783, 106 + this.spos3);
                            this.rd.drawLine(777, 108 + this.spos3, 783, 108 + this.spos3);
                            this.rd.drawLine(777, 110 + this.spos3, 783, 110 + this.spos3);
                            if (this.mscro3 > 800 && this.lspos3 != this.spos3) this.lspos3 = this.spos3;
                            if (paramBoolean && this.openc == 0) {
                                if (this.mscro3 == 825 && paramInt1 > 772 && paramInt1 < 789 && paramInt2 > 93 + this.spos3 && paramInt2 < this.spos3 + 124)
                                    this.mscro3 = paramInt2 - this.spos3;
                                if (this.mscro3 == 825 && paramInt1 > 770 && paramInt1 < 791 && paramInt2 > 74 && paramInt2 < 95)
                                    this.mscro3 = 831;
                                if (this.mscro3 == 825 && paramInt1 > 770 && paramInt1 < 791 && paramInt2 > 390 && paramInt2 < 411)
                                    this.mscro3 = 832;
                                if (this.mscro3 == 825 && paramInt1 > 772 && paramInt1 < 789 && paramInt2 > 93 && paramInt2 < 392) {
                                    this.mscro3 = 108;
                                    this.spos3 = paramInt2 - this.mscro3;
                                }
                                i = 2670 / this.sdist;
                                if (i < 1) i = 1;
                                if (this.mscro3 == 831) {
                                    this.spos3 -= i;
                                    if (this.spos3 > 268) this.spos3 = 268;
                                    if (this.spos3 < 0) this.spos3 = 0;
                                    this.lspos3 = this.spos3;
                                }
                                if (this.mscro3 == 832) {
                                    this.spos3 += i;
                                    if (this.spos3 > 268) this.spos3 = 268;
                                    if (this.spos3 < 0) this.spos3 = 0;
                                    this.lspos3 = this.spos3;
                                }
                                if (this.mscro3 < 800) {
                                    this.spos3 = paramInt2 - this.mscro3;
                                    if (this.spos3 > 268) this.spos3 = 268;
                                    if (this.spos3 < 0) this.spos3 = 0;
                                }
                                if (this.mscro3 == 825) this.mscro3 = 925;
                            } else if (this.mscro3 != 825) {
                                this.mscro3 = 825;
                            }
                        }
                    } else {
                        this.rd.setColor(color2k(205, 205, 205));
                        this.rd.fillRect(207, 46, 582, 30);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        String[] arrayOfString;
                        int[] arrayOfInt1, arrayOfInt2;
                        byte b;
                        for (this.ftm = this.rd.getFontMetrics(), arrayOfString = new String[]{"Player Interaction", "Clan Interaction", "Your Clan's Discussion"}, arrayOfInt1 = new int[]{207, 390, 368, 207}, arrayOfInt2 = new int[]{73, 73, 51, 51}, b = 0; b < 3; ) {
                            if (this.itab == b) {
                                this.rd.setColor(color2k(230, 230, 230));
                                this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
                            } else if (paramInt1 > arrayOfInt1[0] && paramInt1 < arrayOfInt1[2] && paramInt2 > 51 && paramInt2 < 73) {
                                this.rd.setColor(color2k(217, 217, 217));
                                this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
                                if (paramBoolean) this.itab = b;
                            }
                            this.rd.setColor(color2k(150, 150, 150));
                            this.rd.drawPolygon(arrayOfInt1, arrayOfInt2, 4);
                            this.rd.setColor(color2k(40, 40, 40));
                            this.rd.drawString(arrayOfString[b], arrayOfInt1[0] + 80 - this.ftm.stringWidth(arrayOfString[b]) / 2, 67);
                            for (byte b1 = 0; b1 < 4; ) {
                                arrayOfInt1[b1] = arrayOfInt1[b1] + 183;
                                b1++;
                            }
                            b++;
                        }
                        this.rd.setColor(color2k(150, 150, 150));
                        this.rd.drawLine(207, 73, 770, 73);
                        this.rd.setColor(color2k(205, 205, 205));
                        this.rd.fillRect(207, 409, 582, 30);
                        this.rd.setColor(color2k(150, 150, 150));
                        this.rd.drawLine(207, 411, 770, 411);
                        this.rd.setColor(color2k(205, 205, 205));
                        this.rd.fillRect(772, 76, 17, 333);
                        this.rd.setColor(color2k(205, 205, 205));
                        this.rd.fillRect(203, 46, 4, 393);
                        if (this.loadinter == 0) {
                            this.rd.setFont(new Font("Arial", 1, 11));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawString("You have not started any interactions with other clans yet.", 487 - this.ftm.stringWidth("You have not started any interactions with other clans yet.") / 2, 200);
                        }
                        if (this.loadinter == -2) {
                            this.rd.setFont(new Font("Arial", 1, 11));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawString("Failed to load interactions, will try again now...", 487 - this.ftm.stringWidth("Failed to load interactions, will try again now...") / 2, 200);
                        }
                        if (this.loadinter == -1) {
                            this.rd.setFont(new Font("Arial", 1, 11));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawString("Loading interactions, please wait...", 487 - this.ftm.stringWidth("Loading interactions, please wait...") / 2, 200);
                        }
                    }
                    if (this.gs.sendtyp.isShowing()) this.gs.sendtyp.hide();
                    if (this.gs.senditem.isShowing()) this.gs.senditem.hide();
                    if (this.gs.datat.isShowing()) this.gs.datat.hide();
                    this.gs.ilaps.hide();
                    this.gs.icars.hide();
                    this.gs.sclass.hide();
                    this.gs.sfix.hide();
                    if (this.gs.sendtyp.getSelectedIndex() != 0) {
                        this.gs.sendtyp.select(0);
                        this.intsel = 0;
                    }
                } else {
                    this.rd.setColor(color2k(240, 240, 240));
                    this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
                    this.rd.setColor(color2k(250, 250, 250));
                    this.rd.fillRect(207, 86, 577, 274);
                    if (this.intclanlo.equals(this.intclan) && this.intclanbgloaded) {
                        this.rd.setComposite(AlphaComposite.getInstance(3, 0.1F));
                        this.rd.drawImage(this.intclanbg, 207, 86, (ImageObserver) null);
                        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                    }
                    this.sdist = 0;
                    if ((this.readint == 2 || this.readint == 1) && this.viewgame2 == 0) {
                        this.sdist = (int) ((this.nil - 14.75F) * 17.0F);
                        if (this.sdist < 0) this.sdist = 0;
                        this.scro = (int) (this.spos4 / 208.0F * this.sdist);
                        if (this.gs.openm) {
                            this.blockb = 10;
                        } else if (this.blockb != 0) {
                            this.blockb--;
                        }
                        for (byte b = 0; b < this.nil; b++) {
                            if (86 + 17 * b - this.scro < 360 && 125 + 17 * b - this.scro > 86 && this.ilinetyp[b] != 167) {
                                this.rd.setColor(new Color(0, 0, 0));
                                if (this.ilinetyp[b] != 20 && this.ilinetyp[b] != 30 && this.ilinetyp[b] != 40 && this.ilinetyp[b] != 80 && this.ilinetyp[b] != 90 && this.ilinetyp[b] != 100) {
                                    if (this.ilinetyp[b] >= 0) {
                                        this.rd.setFont(new Font("Tahoma", 1, 11));
                                    } else {
                                        this.rd.setFont(new Font("Tahoma", 0, 11));
                                    }
                                    this.rd.drawString(this.iline[b], 217, 103 + 17 * b - this.scro);
                                    if (this.ilinetyp[b] >= 0) {
                                        this.rd.setFont(new Font("Tahoma", 0, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        this.rd.setColor(color2k(125, 125, 125));
                                        this.rd.drawString(this.itimes[b], 757 - this.ftm.stringWidth(this.itimes[b]), 103 + 17 * b - this.scro);
                                    }
                                } else {
                                    if (this.ilinetyp[b] == 40) {
                                        if (stringbutton(this.rd, "  View War Declaration  ", 300, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                            this.viewgame2 = 1;
                                            this.nvgames2 = 4;
                                            this.viewwar2 = getSvalue(this.iline[b], 1);
                                            if (this.iline[b].startsWith("I|")) {
                                                this.ichlng = true;
                                            } else {
                                                this.ichlng = false;
                                            }
                                        }
                                        if (!this.iline[b].endsWith("|out|")) {
                                            if (this.iline[b].startsWith("Y|") && stringbutton(this.rd, "  Accept War  ", 441, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                                this.gs.sendtyp.sel = 7;
                                                this.sendwar = getSvalue(this.iline[b], 1);
                                            }
                                        } else {
                                            this.rd.setColor(color2k(170, 170, 170));
                                            this.rd.drawString("[ Accepted or interaction replaced. ]", 490 - this.ftm.stringWidth("[ Accepted or interaction replaced. ]") / 2, 112 + 17 * b - this.scro);
                                        }
                                    }
                                    if (this.ilinetyp[b] == 30) {
                                        if (stringbutton(this.rd, "  View Car Battle  ", 282, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                            this.viewgame2 = 1;
                                            this.nvgames2 = 2;
                                            this.viewwar2 = getSvalue(this.iline[b], 3);
                                            if (this.iline[b].startsWith("I|")) {
                                                this.ichlng = true;
                                            } else {
                                                this.ichlng = false;
                                            }
                                        }
                                        if (!this.iline[b].endsWith("|out|")) {
                                            if (this.iline[b].startsWith("Y|") && stringbutton(this.rd, "  Accept Battle  ", 410, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                                this.gs.sendtyp.sel = 6;
                                                this.itake = getSvalue(this.iline[b], 1);
                                                this.igive = getSvalue(this.iline[b], 2);
                                                this.sendwar = getSvalue(this.iline[b], 3);
                                            }
                                        } else {
                                            this.rd.setColor(color2k(170, 170, 170));
                                            this.rd.drawString("[ Accepted or interaction replaced. ]", 454 - this.ftm.stringWidth("[ Accepted or interaction replaced. ]") / 2, 112 + 17 * b - this.scro);
                                        }
                                        this.rd.setFont(new Font("Tahoma", 0, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        if (stringbutton(this.rd, "  View Car  ", 217 + this.ftm.stringWidth(this.iline[b + 2]) + 47, 137 + 17 * b - this.scro, 6, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                            this.viewcar = getSvalue(this.iline[b], 1);
                                            if (!this.claname.equals(this.intclan)) {
                                                this.claname = this.intclan;
                                                this.loadedc = false;
                                            }
                                            this.spos5 = 0;
                                            this.lspos5 = 0;
                                            this.cfase = 3;
                                            this.loadedcars = -1;
                                            this.loadedcar = 0;
                                            this.ctab = 2;
                                            this.tab = 3;
                                        }
                                        this.rd.setFont(new Font("Tahoma", 0, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        if (stringbutton(this.rd, "  View Car  ", 217 + this.ftm.stringWidth(this.iline[b + 3]) + 47, 154 + 17 * b - this.scro, 6, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                            this.viewcar = getSvalue(this.iline[b], 2);
                                            if (!this.claname.equals(this.xt.clan)) {
                                                this.claname = this.xt.clan;
                                                this.loadedc = false;
                                            }
                                            this.spos5 = 0;
                                            this.lspos5 = 0;
                                            this.cfase = 3;
                                            this.loadedcars = -1;
                                            this.loadedcar = 0;
                                            this.ctab = 2;
                                            this.tab = 3;
                                        }
                                    }
                                    if (this.ilinetyp[b] == 20) {
                                        if (stringbutton(this.rd, "  View Stage Battle  ", 289, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                            this.viewgame2 = 1;
                                            this.nvgames2 = 2;
                                            this.viewwar2 = getSvalue(this.iline[b], 3);
                                            if (this.iline[b].startsWith("I|")) {
                                                this.ichlng = true;
                                            } else {
                                                this.ichlng = false;
                                            }
                                        }
                                        if (!this.iline[b].endsWith("|out|")) {
                                            if (this.iline[b].startsWith("Y|") && stringbutton(this.rd, "  Accept Battle  ", 424, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                                this.gs.sendtyp.sel = 5;
                                                this.itake = getSvalue(this.iline[b], 1);
                                                this.igive = getSvalue(this.iline[b], 2);
                                                this.sendwar = getSvalue(this.iline[b], 3);
                                            }
                                        } else {
                                            this.rd.setColor(color2k(170, 170, 170));
                                            this.rd.drawString("[ Accepted or interaction replaced. ]", 468 - this.ftm.stringWidth("[ Accepted or interaction replaced. ]") / 2, 112 + 17 * b - this.scro);
                                        }
                                        this.rd.setFont(new Font("Tahoma", 0, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        if (stringbutton(this.rd, "  View Stage  ", 217 + this.ftm.stringWidth(this.iline[b + 2]) + 54, 137 + 17 * b - this.scro, 6, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                            this.viewcar = getSvalue(this.iline[b], 1);
                                            if (!this.claname.equals(this.intclan)) {
                                                this.claname = this.intclan;
                                                this.loadedc = false;
                                            }
                                            this.spos5 = 0;
                                            this.lspos5 = 0;
                                            this.cfase = 3;
                                            this.loadedstages = -1;
                                            this.loadedstage = 0;
                                            this.ctab = 3;
                                            this.tab = 3;
                                        }
                                        this.rd.setFont(new Font("Tahoma", 0, 11));
                                        this.ftm = this.rd.getFontMetrics();
                                        if (stringbutton(this.rd, "  View Stage  ", 217 + this.ftm.stringWidth(this.iline[b + 3]) + 54, 154 + 17 * b - this.scro, 6, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                            this.viewcar = getSvalue(this.iline[b], 2);
                                            if (!this.claname.equals(this.xt.clan)) {
                                                this.claname = this.xt.clan;
                                                this.loadedc = false;
                                            }
                                            this.spos5 = 0;
                                            this.lspos5 = 0;
                                            this.cfase = 3;
                                            this.loadedstages = -1;
                                            this.loadedstage = 0;
                                            this.ctab = 3;
                                            this.tab = 3;
                                        }
                                    }
                                    if (this.ilinetyp[b] == 80) {
                                        if (stringbutton(this.rd, "        View War        ", 284, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                            this.viewgame2 = 1;
                                            this.nvgames2 = 9;
                                            this.viewwar2 = getSvalue(this.iline[b], 0);
                                        }
                                        if (stringbutton(this.rd, "  View Championship  ", 432, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                            this.cfase = 0;
                                            this.ntab = 1;
                                            this.loadwstat = 0;
                                            this.tab = 3;
                                        }
                                    }
                                    if (this.ilinetyp[b] == 90) {
                                        if (stringbutton(this.rd, "        View Battle        ", 284, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                            this.viewgame2 = 1;
                                            this.nvgames2 = 5;
                                            this.viewwar2 = getSvalue(this.iline[b], 0);
                                        }
                                        if (stringbutton(this.rd, "        View Car        ", 424, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                            this.viewcar = getSvalue(this.iline[b], 1);
                                            String str = getSvalue(this.iline[b], 2);
                                            if (!this.claname.equals(str)) {
                                                this.claname = str;
                                                this.loadedc = false;
                                            }
                                            this.spos5 = 0;
                                            this.lspos5 = 0;
                                            this.cfase = 3;
                                            this.loadedcars = -1;
                                            this.loadedcar = 0;
                                            this.ctab = 2;
                                            this.tab = 3;
                                        }
                                    }
                                    if (this.ilinetyp[b] == 100) {
                                        if (stringbutton(this.rd, "        View Battle        ", 284, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                            this.viewgame2 = 1;
                                            this.nvgames2 = 5;
                                            this.viewwar2 = getSvalue(this.iline[b], 0);
                                        }
                                        if (stringbutton(this.rd, "        View Stage        ", 431, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                            this.viewcar = getSvalue(this.iline[b], 1);
                                            String str = getSvalue(this.iline[b], 2);
                                            if (!this.claname.equals(str)) {
                                                this.claname = str;
                                                this.loadedc = false;
                                            }
                                            this.spos5 = 0;
                                            this.lspos5 = 0;
                                            this.cfase = 3;
                                            this.loadedstages = -1;
                                            this.loadedstage = 0;
                                            this.ctab = 3;
                                            this.tab = 3;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (this.readint == 1) {
                        this.rd.setColor(color2k(240, 240, 240));
                        this.rd.fillRoundRect(387, 140, 200, 30, 20, 20);
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawRoundRect(387, 140, 200, 30, 20, 20);
                        this.rd.setFont(new Font("Tahoma", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Reading...", 487 - this.ftm.stringWidth("Reading...") / 2, 160);
                    }
                    if (this.readint == 3) {
                        this.rd.setFont(new Font("Tahoma", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Failed to fetch and load interaction.", 487 - this.ftm.stringWidth("Failed to fetch and load interaction.") / 2, 200);
                    }
                    if (this.readint == 4) {
                        this.rd.setFont(new Font("Tahoma", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Failed to load interaction, server error, please try again later.", 487 - this.ftm.stringWidth("Failed to load interaction, server error, please try again later.") / 2, 200);
                    }
                    if (this.readint == 5) {
                        this.rd.setFont(new Font("Tahoma", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Failed to send interaction, please try again later.", 487 - this.ftm.stringWidth("Failed to send interaction, please try again later.") / 2, 200);
                    }
                    if (this.readint == 6) {
                        this.rd.setFont(new Font("Tahoma", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("The war or battle you are trying to engage has expired or was not found...", 487 - this.ftm.stringWidth("The war or battle you are trying to engage has expired or was not found...") / 2, 200);
                    }
                    this.rd.setColor(color2k(240, 240, 240));
                    this.rd.fillRect(207, 47, 577, 39);
                    this.rd.fillRect(207, 360, 577, 70);
                    this.rd.setColor(color2k(205, 205, 205));
                    this.rd.drawLine(207, 86, 783, 86);
                    this.rd.drawLine(207, 86, 207, 360);
                    this.rd.drawLine(207, 360, 783, 360);
                    this.rd.fillRect(767, 104, 17, 239);
                    if (this.mscro4 == 831 || this.sdist == 0) {
                        if (this.sdist == 0) {
                            this.rd.setColor(color2k(205, 205, 205));
                        } else {
                            this.rd.setColor(color2k(215, 215, 215));
                        }
                        this.rd.fillRect(767, 87, 17, 17);
                    } else {
                        this.rd.setColor(color2k(220, 220, 220));
                        this.rd.fill3DRect(767, 87, 17, 17, true);
                    }
                    if (this.sdist != 0) this.rd.drawImage(this.xt.asu, 772, 93, (ImageObserver) null);
                    if (this.mscro4 == 832 || this.sdist == 0) {
                        if (this.sdist == 0) {
                            this.rd.setColor(color2k(205, 205, 205));
                        } else {
                            this.rd.setColor(color2k(215, 215, 215));
                        }
                        this.rd.fillRect(767, 343, 17, 17);
                    } else {
                        this.rd.setColor(color2k(220, 220, 220));
                        this.rd.fill3DRect(767, 343, 17, 17, true);
                    }
                    if (this.sdist != 0) this.rd.drawImage(this.xt.asd, 772, 350, (ImageObserver) null);
                    if (this.sdist != 0) {
                        if (this.lspos4 != this.spos4) {
                            this.rd.setColor(color2k(215, 215, 215));
                            this.rd.fillRect(767, 104 + this.spos4, 17, 31);
                        } else {
                            if (this.mscro4 == 831) this.rd.setColor(color2k(215, 215, 215));
                            this.rd.fill3DRect(767, 104 + this.spos4, 17, 31, true);
                        }
                        this.rd.setColor(color2k(150, 150, 150));
                        this.rd.drawLine(772, 117 + this.spos4, 778, 117 + this.spos4);
                        this.rd.drawLine(772, 119 + this.spos4, 778, 119 + this.spos4);
                        this.rd.drawLine(772, 121 + this.spos4, 778, 121 + this.spos4);
                        if (this.mscro4 > 800 && this.lspos4 != this.spos4) this.lspos4 = this.spos4;
                        if (paramBoolean) {
                            if (this.mscro4 == 825 && paramInt1 > 767 && paramInt1 < 784 && paramInt2 > 104 + this.spos4 && paramInt2 < this.spos4 + 135)
                                this.mscro4 = paramInt2 - this.spos4;
                            if (this.mscro4 == 825 && paramInt1 > 765 && paramInt1 < 786 && paramInt2 > 85 && paramInt2 < 106)
                                this.mscro4 = 831;
                            if (this.mscro4 == 825 && paramInt1 > 765 && paramInt1 < 786 && paramInt2 > 341 && paramInt2 < 362)
                                this.mscro4 = 832;
                            if (this.mscro4 == 825 && paramInt1 > 767 && paramInt1 < 784 && paramInt2 > 104 && paramInt2 < 343) {
                                this.mscro4 = 119;
                                this.spos4 = paramInt2 - this.mscro4;
                            }
                            int i = 2670 / this.sdist;
                            if (i < 1) i = 1;
                            if (this.mscro4 == 831) {
                                this.spos4 -= i;
                                if (this.spos4 > 208) this.spos4 = 208;
                                if (this.spos4 < 0) this.spos4 = 0;
                                this.lspos4 = this.spos4;
                            }
                            if (this.mscro4 == 832) {
                                this.spos4 += i;
                                if (this.spos4 > 208) this.spos4 = 208;
                                if (this.spos4 < 0) this.spos4 = 0;
                                this.lspos4 = this.spos4;
                            }
                            if (this.mscro4 < 800) {
                                this.spos4 = paramInt2 - this.mscro4;
                                if (this.spos4 > 208) this.spos4 = 208;
                                if (this.spos4 < 0) this.spos4 = 0;
                            }
                            if (this.mscro4 == 825) this.mscro4 = 925;
                        } else if (this.mscro4 != 825) {
                            this.mscro4 = 825;
                        }
                    }
                    if (this.dispi != 0) {
                        char c = 'Ȯ';
                        if (this.viewgame2 != 0) c = 'Ɂ';
                        this.rd.setColor(color2k(220, 220, 220));
                        this.rd.fillRect(207, 86, c, 41);
                        this.rd.setColor(color2k(150, 150, 150));
                        this.rd.drawRect(207, 86, c, 41);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.rd.setColor(new Color(0, 0, 0));
                        if (this.dispi == 1) {
                            this.rd.drawString("Car battle with " + this.intclan + " is on!", 215, 101);
                            this.rd.setFont(new Font("Arial", 0, 11));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.drawString("You win: [ " + this.dtcar + " ]", 215, 118);
                            int i = 215 + this.ftm.stringWidth("You win: [ " + this.dtcar + " ]") + 44;
                            if (stringbutton(this.rd, "View Car", i, 119, 6, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                this.viewcar = this.dtcar;
                                if (!this.claname.equals(this.intclan)) {
                                    this.claname = this.intclan;
                                    this.loadedc = false;
                                }
                                this.spos5 = 0;
                                this.lspos5 = 0;
                                this.cfase = 3;
                                this.loadedcars = -1;
                                this.loadedcar = 0;
                                this.ctab = 2;
                                this.tab = 3;
                            }
                            i += 44;
                            this.rd.setFont(new Font("Arial", 0, 11));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.drawString("You lose: [ " + this.dgcar + " ]", i, 118);
                            i += this.ftm.stringWidth("You lose: [ " + this.dgcar + " ]") + 44;
                            if (stringbutton(this.rd, "View Car", i, 119, 6, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                this.viewcar = this.dgcar;
                                if (!this.claname.equals(this.xt.clan)) {
                                    this.claname = this.xt.clan;
                                    this.loadedc = false;
                                }
                                this.spos5 = 0;
                                this.lspos5 = 0;
                                this.cfase = 3;
                                this.loadedcars = -1;
                                this.loadedcar = 0;
                                this.ctab = 2;
                                this.tab = 3;
                            }
                            if (stringbutton(this.rd, "View Battle", 714, 111, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                this.viewgame2 = 1;
                                this.nvgames2 = 5;
                                this.viewwar2 = this.dwarn;
                            }
                        }
                        if (this.dispi == 2) {
                            this.rd.drawString("Stage battle with " + this.intclan + " is on!", 215, 101);
                            this.rd.setFont(new Font("Arial", 0, 11));
                            this.ftm = this.rd.getFontMetrics();
                            String str = this.dtcar;
                            if (str.length() > 10) str = "" + str.substring(0, 10) + "...";
                            this.rd.drawString("You win: [ " + str + " ]", 215, 118);
                            int i = 215 + this.ftm.stringWidth("You win: [ " + str + " ]") + 51;
                            if (stringbutton(this.rd, "View Stage", i, 119, 6, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                this.viewcar = this.dtcar;
                                if (!this.claname.equals(this.intclan)) {
                                    this.claname = this.intclan;
                                    this.loadedc = false;
                                }
                                this.spos5 = 0;
                                this.lspos5 = 0;
                                this.cfase = 3;
                                this.loadedstages = -1;
                                this.loadedstage = 0;
                                this.ctab = 3;
                                this.tab = 3;
                            }
                            i += 51;
                            this.rd.setFont(new Font("Arial", 0, 11));
                            this.ftm = this.rd.getFontMetrics();
                            str = this.dgcar;
                            if (str.length() > 10) str = "" + str.substring(0, 10) + "...";
                            this.rd.drawString("You lose: [ " + str + " ]", i, 118);
                            i += this.ftm.stringWidth("You lose: [ " + str + " ]") + 51;
                            if (stringbutton(this.rd, "View Stage", i, 119, 6, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                this.viewcar = this.dgcar;
                                if (!this.claname.equals(this.xt.clan)) {
                                    this.claname = this.xt.clan;
                                    this.loadedc = false;
                                }
                                this.spos5 = 0;
                                this.lspos5 = 0;
                                this.cfase = 3;
                                this.loadedstages = -1;
                                this.loadedstage = 0;
                                this.ctab = 3;
                                this.tab = 3;
                            }
                            if (stringbutton(this.rd, "View Battle", 714, 111, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                this.viewgame2 = 1;
                                this.nvgames2 = 5;
                                this.viewwar2 = this.dwarn;
                            }
                        }
                        if (this.dispi == 3) {
                            this.rd.drawString("War between your clan and " + this.intclan + " has started!", 227, 111);
                            if (stringbutton(this.rd, "         View War         ", 670, 111, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                this.viewgame2 = 1;
                                this.nvgames2 = 9;
                                this.viewwar2 = this.dwarn;
                            }
                        }
                    }
                    if (this.viewgame2 != 0) {
                        this.rd.setColor(color2k(210, 210, 210));
                        this.rd.fillRoundRect(204, 127, 583, 230, 20, 20);
                        this.rd.setColor(color2k(150, 150, 150));
                        this.rd.drawRoundRect(204, 127, 583, 230, 20, 20);
                        this.rd.setFont(new Font("Tahoma", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        if (this.nvgames2 == 4) {
                            this.rd.drawString("War declaration, your clan " + this.xt.clan + " versus " + this.intclan + ".", 215, 145);
                            if (this.viewgame2 == 2) if (this.ichlng) {
                                this.rd.drawString("" + this.intclan + " would create 5 more games and the first clan to win 5 games wins the war!", 215, 210 + this.nvgames2 * 18);
                            } else {
                                this.rd.drawString("Your clan would create 5 more games and the first clan to win 5 games wins the war!", 215, 210 + this.nvgames2 * 18);
                            }
                        }
                        if (this.nvgames2 == 2) {
                            this.rd.drawString("Battle, your clan " + this.xt.clan + " versus " + this.intclan + ".", 215, 145);
                            if (this.viewgame2 == 2) if (this.ichlng) {
                                this.rd.drawString("" + this.intclan + " would create 3 more games and the first clan to win 3 games wins the battle!", 215, 210 + this.nvgames2 * 18);
                            } else {
                                this.rd.drawString("Your clan would create 3 more games and the first clan to win 3 games wins the battle!", 215, 210 + this.nvgames2 * 18);
                            }
                        }
                        if ((this.nvgames2 == 9 || this.nvgames2 == 5) && this.viewgame2 == 2) {
                            this.rd.drawString("" + this.xt.clan + "  " + this.vwscorex + "           |           " + this.intclan + "  " + this.vwscorei + "", 505 - this.ftm.stringWidth("" + this.xt.clan + "  " + this.vwscorex + "           |           " + this.intclan + "  " + this.vwscorei + "") / 2, 145);
                            this.rd.drawRect(320, 131, 370, 19);
                        }
                        if (stringbutton(this.rd, "Close X", 749, 148, 3, paramInt1, paramInt2, paramBoolean, 0, 0))
                            this.viewgame2 = 0;
                        this.rd.setFont(new Font("Tahoma", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        if (this.viewgame2 == 2) {
                            this.rd.drawString("Game", 246 - this.ftm.stringWidth("Game") / 2, 175);
                            this.rd.drawString("Stage", 412 - this.ftm.stringWidth("Stage") / 2, 175);
                            this.rd.drawString("Laps", 564 - this.ftm.stringWidth("Laps") / 2, 175);
                            this.rd.drawString("Type of Cars", 653 - this.ftm.stringWidth("Type of Cars") / 2, 175);
                            this.rd.drawString("Fixing", 751 - this.ftm.stringWidth("Fixing") / 2, 175);
                            int i = 1;
                            byte b1 = 1;
                            if (this.nvgames2 == 4 || this.nvgames2 == 2) {
                                i = 2;
                                b1 = 2;
                            }
                            byte b2;
                            for (b2 = 0; b2 < this.nvgames2; b2++) {
                                if (!this.vwinner[b2].equals("")) {
                                    this.rd.setColor(color2k(220, 220, 220));
                                    this.rd.fillRect(213, 180 + b2 * 18, 565, 18);
                                    this.rd.setColor(new Color(0, 0, 0));
                                }
                                this.rd.setFont(new Font("Tahoma", 0, 11));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.drawString("# " + i + "", 246 - this.ftm.stringWidth("# " + i + "") / 2, 193 + b2 * 18);
                                i += b1;
                                this.rd.drawString(this.vwstages2[b2], 412 - this.ftm.stringWidth(this.vwstages2[b2]) / 2, 193 + b2 * 18);
                                this.rd.drawString("" + this.vwlaps2[b2] + "", 564 - this.ftm.stringWidth("" + this.vwlaps2[b2] + "") / 2, 193 + b2 * 18);
                                String str1 = "All Cars";
                                if (this.vwcars2[b2] == 2) str1 = "Clan Cars";
                                if (this.vwcars2[b2] == 3) str1 = "Game Cars";
                                if (this.vwclass2[b2] == 0) str1 = str1 + ", All Classes";
                                if (this.vwclass2[b2] == 1) str1 = str1 + ", Class C";
                                if (this.vwclass2[b2] == 2) str1 = str1 + ", Class B & C";
                                if (this.vwclass2[b2] == 3) str1 = str1 + ", Class B";
                                if (this.vwclass2[b2] == 4) str1 = str1 + ", Class A & B";
                                if (this.vwclass2[b2] == 5) str1 = str1 + ", Class A";
                                this.rd.drawString(str1, 653 - this.ftm.stringWidth(str1) / 2, 193 + b2 * 18);
                                String str2 = "Infinite";
                                if (this.vwfix2[b2] == 1) str2 = "4 Fixes";
                                if (this.vwfix2[b2] == 2) str2 = "3 Fixes";
                                if (this.vwfix2[b2] == 3) str2 = "2 Fixes";
                                if (this.vwfix2[b2] == 4) str2 = "1 Fix";
                                if (this.vwfix2[b2] == 5) str2 = "No Fixing";
                                this.rd.drawString(str2, 751 - this.ftm.stringWidth(str2) / 2, 193 + b2 * 18);
                                this.rd.drawRect(213, 180 + b2 * 18, 565, 18);
                            }
                            this.rd.drawLine(213, 162, 213, 180 + this.nvgames2 * 18);
                            this.rd.drawLine(279, 162, 279, 180 + this.nvgames2 * 18);
                            this.rd.drawLine(546, 162, 546, 180 + this.nvgames2 * 18);
                            this.rd.drawLine(583, 162, 583, 180 + this.nvgames2 * 18);
                            this.rd.drawLine(723, 162, 723, 180 + this.nvgames2 * 18);
                            this.rd.drawLine(778, 162, 778, 180 + this.nvgames2 * 18);
                            for (b2 = 0; b2 < this.nvgames2; b2++) {
                                if (paramInt1 > 213 && paramInt1 < 778 && paramInt2 > 180 + b2 * 18 && paramInt2 < 198 + b2 * 18 && !this.vwinner[b2].equals("")) {
                                    this.rd.setColor(color2k(230, 230, 230));
                                    this.rd.fillRect(213, 180 + b2 * 18, 565, 18);
                                    this.rd.setColor(new Color(0, 0, 0));
                                    this.rd.setFont(new Font("Tahoma", 1, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.drawString("" + this.vwinner[b2] + "  Wins!", 495 - this.ftm.stringWidth("" + this.vwinner[b2] + "  Wins!") / 2, 193 + b2 * 18);
                                    this.rd.drawRect(213, 180 + b2 * 18, 565, 18);
                                }
                            }
                        }
                        if (this.viewgame2 == 1)
                            this.rd.drawString("Loading...", 495 - this.ftm.stringWidth("Loading...") / 2, 242);
                        if (this.viewgame2 == 3) {
                            if (this.nvgames2 == 4 || this.nvgames2 == 9)
                                this.rd.drawString("This war has expired and no longer exists.", 495 - this.ftm.stringWidth("This war has expired and no longer exists.") / 2, 232);
                            if (this.nvgames2 == 2 || this.nvgames2 == 5)
                                this.rd.drawString("This battle has expired and no longer exists.", 495 - this.ftm.stringWidth("This battle has expired and no longer exists.") / 2, 232);
                            if (this.nvgames2 == 9 || this.nvgames2 == 5) {
                                this.rd.drawString("(Started/finished wars and battles expire after 180 days.)", 495 - this.ftm.stringWidth("(Started/finished wars and battles expire after 180 days.)") / 2, 252);
                            } else {
                                this.rd.drawString("(Suggestions expire after 90 days.)", 495 - this.ftm.stringWidth("(Suggestions expire after 90 days.)") / 2, 252);
                            }
                        }
                        if (this.viewgame2 == 4)
                            this.rd.drawString("Error loading games, please try again later...", 495 - this.ftm.stringWidth("Error loading games, please try again later...") / 2, 242);
                    }
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    if (!drawl(this.rd, "#" + this.intclan + "#", 207, 47, true)) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString(this.intclan, 382 - this.ftm.stringWidth(this.intclan) / 2, 66);
                        this.rd.setColor(color2k(150, 150, 150));
                        this.rd.drawRect(207, 47, 349, 29);
                    }
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("::  Versus your clan", 566, 72);
                    if (paramInt1 > 207 && paramInt1 < 557 && paramInt2 > 47 && paramInt2 < 77) {
                        this.cur = 12;
                        if (paramBoolean) {
                            if (!this.claname.equals(this.intclan)) {
                                this.claname = this.intclan;
                                this.loadedc = false;
                            }
                            this.spos5 = 0;
                            this.lspos5 = 0;
                            this.cfase = 3;
                            this.ctab = 0;
                            this.tab = 3;
                        }
                    }
                    if (stringbutton(this.rd, "Close X", 752, 66, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                        this.openi = 0;
                        this.readint = 0;
                        this.viewgame2 = 0;
                    }
                    if (this.gs.sendtyp.getSelectedIndex() < 5) {
                        if (!this.gs.sendtyp.isShowing()) this.gs.sendtyp.show();
                        this.gs.sendtyp.move(207, 365);
                    } else {
                        this.gs.sendtyp.hide();
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.rd.setColor(new Color(0, 0, 0));
                        if (this.gs.sendtyp.getSelectedIndex() == 5)
                            this.rd.drawString("::  Accept Stage Battle", 207, 382);
                        if (this.gs.sendtyp.getSelectedIndex() == 6)
                            this.rd.drawString("::  Accept Car Battle", 207, 382);
                        if (this.gs.sendtyp.getSelectedIndex() == 7) this.rd.drawString("::  Accept War", 207, 382);
                        if (stringbutton(this.rd, "  Cancel  ", 742, 382, 3, paramInt1, paramInt2, paramBoolean, 0, 0))
                            this.gs.sendtyp.select(0);
                    }
                    if (this.sendint != 0) {
                        this.gs.sendtyp.disable();
                    } else {
                        this.gs.sendtyp.enable();
                    }
                    if (this.intsel != this.gs.sendtyp.getSelectedIndex()) {
                        this.gs.senditem.hide();
                        this.gs.datat.hide();
                        this.gs.ilaps.hide();
                        this.gs.icars.hide();
                        this.gs.sclass.hide();
                        this.gs.sfix.hide();
                        this.gs.senditem.enable();
                        this.gs.datat.enable();
                        this.gs.ilaps.enable();
                        this.gs.icars.enable();
                        this.gs.sclass.enable();
                        this.gs.sfix.enable();
                        this.intsel = this.gs.sendtyp.getSelectedIndex();
                        this.inishsel = true;
                    }
                    if (this.gs.sendtyp.getSelectedIndex() == 0) {
                        this.dommsg = true;
                        if (this.sendint == 0) {
                            if (stringbutton(this.rd, "   Send  >  ", 723, 408, 0, paramInt1, paramInt2, paramBoolean, 0, 0) && !this.gs.mmsg.getText().trim().equals("") && this.gs.mmsg.getText().toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) == -1 && this.xt.acexp != -3)
                                if (!this.xt.msgcheck(this.gs.mmsg.getText())) {
                                    this.sendint = 1;
                                } else {
                                    this.gs.sendtyp.hide();
                                    this.xt.warning++;
                                }
                        } else {
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 408);
                        }
                    }
                    if (this.gs.sendtyp.getSelectedIndex() == 1) {
                        this.rd.setFont(new Font("Arial", 0, 12));
                        this.rd.drawString("A date that gets converted to the local time of any person previewing it.", 376, 382);
                        if (!this.gs.senditem.isShowing()) {
                            this.gs.senditem.removeAll();
                            Calendar calendar;
                            boolean bool;
                            byte b;
                            for (calendar = Calendar.getInstance(), bool = false, b = 0; b < 20; ) {
                                String str = this.wday[calendar.get(7) - 1];
                                if (!bool) {
                                    str = "Today";
                                    bool = true;
                                }
                                this.gs.senditem.add(this.rd, "" + str + "  -  " + this.month[calendar.get(2)] + " " + calendar.get(5) + "");
                                calendar.roll(5, true);
                                b++;
                            }
                            this.gs.senditem.select(0);
                            this.gs.senditem.show();
                        }
                        if (!this.gs.datat.isShowing()) {
                            this.gs.datat.removeAll();
                            byte b1;
                            String str;
                            byte b2;
                            for (b1 = 12, str = "PM", b2 = 0; b2 < 24; ) {
                                this.gs.datat.add(this.rd, "" + b1 + " " + str + "");
                                if (++b1 == 12) str = "AM";
                                if (b1 == 13) b1 = 1;
                                b2++;
                            }
                            this.gs.datat.select(0);
                            this.gs.datat.show();
                        }
                        this.gs.senditem.move(300, 395);
                        this.gs.datat.move(491, 395);
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Date is displayed based on your computer calendar's date/time, please make sure it is correct.", 207, 435);
                        if (this.sendint == 0) {
                            if (stringbutton(this.rd, "   Send  >  ", 723, 408, 0, paramInt1, paramInt2, paramBoolean, 0, 0))
                                this.sendint = 1;
                        } else {
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 408);
                        }
                    }
                    if (this.gs.sendtyp.getSelectedIndex() == 2) {
                        if (this.inishsel) {
                            if (this.redif) {
                                this.ifas = 1;
                                this.gs.datat.removeAll();
                                for (byte b = 0; b < this.gs.clcars.getItemCount(); ) {
                                    this.gs.datat.add(this.rd, this.gs.clcars.getItem(b));
                                    b++;
                                }
                                this.gs.datat.select(this.gs.clcars.getSelectedIndex());
                                this.redif = false;
                            } else {
                                this.ifas = 0;
                                this.gs.datat.removeAll();
                                this.gs.datat.add(this.rd, "Loading " + this.intclan + "'s stages, please wait...");
                            }
                            this.imsg = "Battle over a stage that belongs to " + this.intclan + " to take it.";
                            this.iflk = 0;
                            if (this.sendwarnum) {
                                this.ifas = 4;
                                this.sendint = 1;
                                this.gs.senditem.disable();
                                this.gs.datat.disable();
                                this.gs.ilaps.disable();
                                this.gs.icars.disable();
                                this.gs.sclass.disable();
                                this.gs.sfix.disable();
                            }
                        }
                        this.rd.setFont(new Font("Arial", 0, 12));
                        if (this.iflk % 3 != 0 || this.iflk == 0) this.rd.drawString(this.imsg, 376, 382);
                        if (this.iflk != 0) this.iflk--;
                        if (this.ifas == 0 || this.ifas == 1) {
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.rd.drawString("Choose the stage of " + this.intclan + " you want to take to your clan, if you win!", 207, 402);
                            if (!this.gs.datat.isShowing()) this.gs.datat.show();
                            this.gs.datat.move(495 - this.gs.datat.getWidth() / 2, 410);
                        }
                        if (this.ifas == 2 || this.ifas == 3) {
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.rd.drawString("Choose a stage of your clan that you would give to " + this.intclan + ", if you lose!", 207, 402);
                            if (!this.gs.datat.isShowing()) this.gs.datat.show();
                            this.gs.datat.move(495 - this.gs.datat.getWidth() / 2, 410);
                        }
                        if (this.ifas == 4 || this.ifas == 5) {
                            if (this.ifas == 4) {
                                this.isel = 0;
                                this.gs.senditem.removeAll();
                                this.gs.senditem.add(this.rd, " NFM Multiplayer ");
                                this.gs.senditem.add(this.rd, " NFM 2     ");
                                this.gs.senditem.add(this.rd, " NFM 1     ");
                                this.gs.senditem.add(this.rd, " Clan Stages ");
                                this.gs.senditem.select(0);
                                this.gs.datat.removeAll();
                                this.gs.datat.add(this.rd, "Select Stage");
                                for (byte b = 0; b < 5; ) {
                                    this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                    b++;
                                }
                                this.gs.datat.select(0);
                                this.gs.ilaps.hide();
                                this.gs.icars.hide();
                                this.gs.sclass.hide();
                                this.gs.sfix.hide();
                                this.ifas = 5;
                            }
                            this.rd.setFont(new Font("Arial", 0, 12));
                            if (this.iflk % 3 != 0 || this.iflk == 0) this.rd.drawString(this.imsg, 376, 382);
                            if (this.iflk != 0) this.iflk--;
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.rd.drawString("Game #" + (this.wag * 2 + 2) + " :", 207, 407);
                            if (!this.gs.senditem.isShowing()) this.gs.senditem.show();
                            this.gs.senditem.move(280, 390);
                            if (!this.gs.datat.isShowing()) this.gs.datat.show();
                            this.gs.datat.move(286 + this.gs.senditem.getWidth(), 390);
                            int i = 207;
                            if (!this.gs.ilaps.isShowing()) {
                                this.gs.ilaps.show();
                                this.gs.ilaps.select(0);
                            }
                            this.gs.ilaps.move(i, 415);
                            i += 6 + this.gs.ilaps.getWidth();
                            if (!this.gs.icars.isShowing()) {
                                this.gs.icars.show();
                                this.gs.icars.select(0);
                            }
                            this.gs.icars.move(i, 415);
                            i += 6 + this.gs.icars.getWidth();
                            if (!this.gs.sclass.isShowing()) {
                                this.gs.sclass.show();
                                this.gs.sclass.select(0);
                            }
                            this.gs.sclass.move(i, 415);
                            this.gs.sclass.revup = true;
                            i += 6 + this.gs.sclass.getWidth();
                            if (!this.gs.sfix.isShowing()) {
                                this.gs.sfix.show();
                                this.gs.sfix.select(0);
                            }
                            this.gs.sfix.move(i, 415);
                            this.gs.sfix.revup = true;
                            this.gs.datat.setSize(i + this.gs.sfix.getWidth() - 286 - this.gs.senditem.getWidth(), 22);
                            if (this.gs.senditem.getSelectedIndex() == 0 && this.isel != 0) {
                                this.gs.datat.removeAll();
                                this.gs.datat.add(this.rd, "Select Stage");
                                for (byte b = 0; b < 5; ) {
                                    this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                    b++;
                                }
                                this.gs.datat.select(0);
                                this.isel = 0;
                            }
                            if (this.gs.senditem.getSelectedIndex() == 1 && this.isel != 1) {
                                this.gs.datat.removeAll();
                                this.gs.datat.add(this.rd, "Select Stage");
                                for (byte b = 0; b < 17; ) {
                                    this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                    b++;
                                }
                                this.gs.datat.select(0);
                                this.isel = 1;
                            }
                            if (this.gs.senditem.getSelectedIndex() == 2 && this.isel != 2) {
                                this.gs.datat.removeAll();
                                this.gs.datat.add(this.rd, "Select Stage");
                                for (byte b = 0; b < 10; ) {
                                    this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                    b++;
                                }
                                this.gs.datat.select(0);
                                this.isel = 2;
                            }
                            if (this.gs.senditem.getSelectedIndex() == 3 && this.isel < 3) {
                                this.gs.datat.removeAll();
                                this.gs.datat.add(this.rd, "Loading stages, please wait...");
                                this.gs.datat.select(0);
                                this.isel = 3;
                            }
                        }
                        if (this.sendint == 0) {
                            String str = "  Next >  ";
                            if (this.ifas == 5 && this.wag == 1) str = "   Done   ";
                            if (stringbutton(this.rd, str, 742, 417, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                if (this.ifas == 4 || this.ifas == 5) if (this.gs.datat.getSelectedIndex() != 0) {
                                    if (this.gs.ilaps.getSelectedIndex() != 0) {
                                        if (this.gs.icars.getSelectedIndex() != 0) {
                                            if (this.gs.senditem.getSelectedIndex() == 0)
                                                this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 27) + "";
                                            if (this.gs.senditem.getSelectedIndex() == 1)
                                                this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 10) + "";
                                            if (this.gs.senditem.getSelectedIndex() == 2)
                                                this.wstages[this.wag] = "#" + this.gs.datat.getSelectedIndex() + "";
                                            if (this.gs.senditem.getSelectedIndex() == 3)
                                                this.wstages[this.wag] = "" + this.gs.datat.getSelectedItem() + "";
                                            this.wlaps[this.wag] = this.gs.ilaps.getSelectedIndex();
                                            this.wcars[this.wag] = this.gs.icars.getSelectedIndex();
                                            this.wclass[this.wag] = this.gs.sclass.getSelectedIndex();
                                            this.wfix[this.wag] = this.gs.sfix.getSelectedIndex();
                                            this.wag++;
                                            if (this.wag < 2) {
                                                this.ifas = 4;
                                                this.imsg = "Create second game.";
                                            } else {
                                                this.wag--;
                                                this.sendint = 1;
                                                this.gs.senditem.disable();
                                                this.gs.datat.disable();
                                                this.gs.ilaps.disable();
                                                this.gs.icars.disable();
                                                this.gs.sclass.disable();
                                                this.gs.sfix.disable();
                                            }
                                        } else {
                                            this.imsg = "Please choose a type of cars for this game!";
                                            this.iflk = 40;
                                        }
                                    } else {
                                        this.imsg = "Please select a number of laps!";
                                        this.iflk = 40;
                                    }
                                } else {
                                    this.imsg = "Please select a stage!";
                                    this.iflk = 40;
                                }
                                if (this.ifas == 2 || this.ifas == 3) if (this.gs.datat.getSelectedIndex() == 0) {
                                    this.imsg = "Please choose a stage to give to " + this.intclan + " if you lose!";
                                    this.iflk = 40;
                                } else {
                                    this.imsg = "Create 2 games and " + this.intclan + " will create another 3.";
                                    this.iflk = 0;
                                    this.igive = this.gs.datat.getSelectedItem();
                                    this.ifas = 4;
                                    this.wag = 0;
                                }
                                if (this.ifas == 0 || this.ifas == 1) if (this.gs.datat.getSelectedIndex() == 0) {
                                    this.imsg = "Please choose a stage to battle over!";
                                    this.iflk = 40;
                                } else {
                                    this.imsg = "Battle over a stage that belongs to " + this.intclan + " to take it.";
                                    this.iflk = 0;
                                    this.itake = this.gs.datat.getSelectedItem();
                                    this.gs.datat.removeAll();
                                    this.gs.datat.add(this.rd, "Loading your clan's stages, please wait...");
                                    this.ifas = 2;
                                }
                            }
                        } else {
                            this.imsg = "Sending stage battle, pleas wait...";
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawString("Sending...", 742 - this.ftm.stringWidth("Sending...") / 2, 417);
                        }
                    }
                    if (this.gs.sendtyp.getSelectedIndex() == 3) {
                        if (this.inishsel) {
                            if (this.redif) {
                                this.ifas = 1;
                                this.gs.datat.removeAll();
                                for (byte b = 0; b < this.gs.clcars.getItemCount(); ) {
                                    this.gs.datat.add(this.rd, this.gs.clcars.getItem(b));
                                    b++;
                                }
                                this.gs.datat.select(this.gs.clcars.getSelectedIndex());
                                this.redif = false;
                            } else {
                                this.ifas = 0;
                                this.gs.datat.removeAll();
                                this.gs.datat.add(this.rd, "Loading " + this.intclan + "'s cars, please wait...");
                            }
                            this.imsg = "Battle over a car that belongs to " + this.intclan + " to take it.";
                            this.iflk = 0;
                            if (this.sendwarnum) {
                                this.ifas = 4;
                                this.sendint = 1;
                                this.gs.senditem.disable();
                                this.gs.datat.disable();
                                this.gs.ilaps.disable();
                                this.gs.icars.disable();
                                this.gs.sclass.disable();
                                this.gs.sfix.disable();
                            }
                        }
                        this.rd.setFont(new Font("Arial", 0, 12));
                        if (this.iflk % 3 != 0 || this.iflk == 0) this.rd.drawString(this.imsg, 376, 382);
                        if (this.iflk != 0) this.iflk--;
                        if (this.ifas == 0 || this.ifas == 1) {
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.rd.drawString("Choose the car of " + this.intclan + " you want to take to your clan, if you win!", 207, 402);
                            if (!this.gs.datat.isShowing()) this.gs.datat.show();
                            this.gs.datat.move(495 - this.gs.datat.getWidth() / 2, 410);
                        }
                        if (this.ifas == 2 || this.ifas == 3) {
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.rd.drawString("Choose a car of your clan that you would give to " + this.intclan + ", if you lose!", 207, 402);
                            if (!this.gs.datat.isShowing()) this.gs.datat.show();
                            this.gs.datat.move(495 - this.gs.datat.getWidth() / 2, 410);
                        }
                        if (this.ifas == 4 || this.ifas == 5) {
                            if (this.ifas == 4) {
                                this.isel = 0;
                                this.gs.senditem.removeAll();
                                this.gs.senditem.add(this.rd, " NFM Multiplayer ");
                                this.gs.senditem.add(this.rd, " NFM 2     ");
                                this.gs.senditem.add(this.rd, " NFM 1     ");
                                this.gs.senditem.add(this.rd, " Clan Stages ");
                                this.gs.senditem.select(0);
                                this.gs.datat.removeAll();
                                this.gs.datat.add(this.rd, "Select Stage");
                                for (byte b = 0; b < 5; ) {
                                    this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                    b++;
                                }
                                this.gs.datat.select(0);
                                this.gs.ilaps.hide();
                                this.gs.icars.hide();
                                this.gs.sclass.hide();
                                this.gs.sfix.hide();
                                this.ifas = 5;
                            }
                            this.rd.setFont(new Font("Arial", 0, 12));
                            if (this.iflk % 3 != 0 || this.iflk == 0) this.rd.drawString(this.imsg, 376, 382);
                            if (this.iflk != 0) this.iflk--;
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.rd.drawString("Game #" + (this.wag * 2 + 2) + " :", 207, 407);
                            if (!this.gs.senditem.isShowing()) this.gs.senditem.show();
                            this.gs.senditem.move(280, 390);
                            if (!this.gs.datat.isShowing()) this.gs.datat.show();
                            this.gs.datat.move(286 + this.gs.senditem.getWidth(), 390);
                            int i = 207;
                            if (!this.gs.ilaps.isShowing()) {
                                this.gs.ilaps.show();
                                this.gs.ilaps.select(0);
                            }
                            this.gs.ilaps.move(i, 415);
                            i += 6 + this.gs.ilaps.getWidth();
                            if (!this.gs.icars.isShowing()) {
                                this.gs.icars.show();
                                this.gs.icars.select(0);
                            }
                            this.gs.icars.move(i, 415);
                            i += 6 + this.gs.icars.getWidth();
                            if (!this.gs.sclass.isShowing()) {
                                this.gs.sclass.show();
                                this.gs.sclass.select(0);
                            }
                            this.gs.sclass.move(i, 415);
                            this.gs.sclass.revup = true;
                            i += 6 + this.gs.sclass.getWidth();
                            if (!this.gs.sfix.isShowing()) {
                                this.gs.sfix.show();
                                this.gs.sfix.select(0);
                            }
                            this.gs.sfix.move(i, 415);
                            this.gs.sfix.revup = true;
                            this.gs.datat.setSize(i + this.gs.sfix.getWidth() - 286 - this.gs.senditem.getWidth(), 22);
                            if (this.gs.senditem.getSelectedIndex() == 0 && this.isel != 0) {
                                this.gs.datat.removeAll();
                                this.gs.datat.add(this.rd, "Select Stage");
                                for (byte b = 0; b < 5; ) {
                                    this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                    b++;
                                }
                                this.gs.datat.select(0);
                                this.isel = 0;
                            }
                            if (this.gs.senditem.getSelectedIndex() == 1 && this.isel != 1) {
                                this.gs.datat.removeAll();
                                this.gs.datat.add(this.rd, "Select Stage");
                                for (byte b = 0; b < 17; ) {
                                    this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                    b++;
                                }
                                this.gs.datat.select(0);
                                this.isel = 1;
                            }
                            if (this.gs.senditem.getSelectedIndex() == 2 && this.isel != 2) {
                                this.gs.datat.removeAll();
                                this.gs.datat.add(this.rd, "Select Stage");
                                for (byte b = 0; b < 10; ) {
                                    this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                    b++;
                                }
                                this.gs.datat.select(0);
                                this.isel = 2;
                            }
                            if (this.gs.senditem.getSelectedIndex() == 3 && this.isel < 3) {
                                this.gs.datat.removeAll();
                                this.gs.datat.add(this.rd, "Loading stages, please wait...");
                                this.gs.datat.select(0);
                                this.isel = 3;
                            }
                        }
                        if (this.sendint == 0) {
                            String str = "  Next >  ";
                            if (this.ifas == 5 && this.wag == 1) str = "   Done   ";
                            if (stringbutton(this.rd, str, 742, 417, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                if (this.ifas == 4 || this.ifas == 5) if (this.gs.datat.getSelectedIndex() != 0) {
                                    if (this.gs.ilaps.getSelectedIndex() != 0) {
                                        if (this.gs.icars.getSelectedIndex() != 0) {
                                            if (this.gs.senditem.getSelectedIndex() == 0)
                                                this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 27) + "";
                                            if (this.gs.senditem.getSelectedIndex() == 1)
                                                this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 10) + "";
                                            if (this.gs.senditem.getSelectedIndex() == 2)
                                                this.wstages[this.wag] = "#" + this.gs.datat.getSelectedIndex() + "";
                                            if (this.gs.senditem.getSelectedIndex() == 3)
                                                this.wstages[this.wag] = "" + this.gs.datat.getSelectedItem() + "";
                                            this.wlaps[this.wag] = this.gs.ilaps.getSelectedIndex();
                                            this.wcars[this.wag] = this.gs.icars.getSelectedIndex();
                                            this.wclass[this.wag] = this.gs.sclass.getSelectedIndex();
                                            this.wfix[this.wag] = this.gs.sfix.getSelectedIndex();
                                            this.wag++;
                                            if (this.wag < 2) {
                                                this.ifas = 4;
                                                this.imsg = "Create second game.";
                                            } else {
                                                this.wag--;
                                                this.sendint = 1;
                                                this.gs.senditem.disable();
                                                this.gs.datat.disable();
                                                this.gs.ilaps.disable();
                                                this.gs.icars.disable();
                                                this.gs.sclass.disable();
                                                this.gs.sfix.disable();
                                            }
                                        } else {
                                            this.imsg = "Please choose a type of cars for this game!";
                                            this.iflk = 40;
                                        }
                                    } else {
                                        this.imsg = "Please select a number of laps!";
                                        this.iflk = 40;
                                    }
                                } else {
                                    this.imsg = "Please select a stage!";
                                    this.iflk = 40;
                                }
                                if (this.ifas == 2 || this.ifas == 3) if (this.gs.datat.getSelectedIndex() == 0) {
                                    this.imsg = "Please choose a car to give to " + this.intclan + " if you lose!";
                                    this.iflk = 40;
                                } else {
                                    this.imsg = "Create 2 games and " + this.intclan + " will create another 3.";
                                    this.iflk = 0;
                                    this.igive = this.gs.datat.getSelectedItem();
                                    this.ifas = 4;
                                    this.wag = 0;
                                }
                                if (this.ifas == 0 || this.ifas == 1) if (this.gs.datat.getSelectedIndex() == 0) {
                                    this.imsg = "Please choose a car to battle over!";
                                    this.iflk = 40;
                                } else {
                                    this.imsg = "Battle over a car that belongs to " + this.intclan + " to take it.";
                                    this.iflk = 0;
                                    this.itake = this.gs.datat.getSelectedItem();
                                    this.gs.datat.removeAll();
                                    this.gs.datat.add(this.rd, "Loading your clan's cars, please wait...");
                                    this.ifas = 2;
                                }
                            }
                        } else {
                            this.imsg = "Sending car battle, pleas wait...";
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawString("Sending...", 742 - this.ftm.stringWidth("Sending...") / 2, 417);
                        }
                    }
                    if (this.gs.sendtyp.getSelectedIndex() == 4) {
                        if (this.inishsel || this.redif) {
                            this.isel = 0;
                            this.gs.senditem.removeAll();
                            this.gs.senditem.add(this.rd, " NFM Multiplayer ");
                            this.gs.senditem.add(this.rd, " NFM 2     ");
                            this.gs.senditem.add(this.rd, " NFM 1     ");
                            this.gs.senditem.add(this.rd, " Clan Stages ");
                            this.gs.senditem.select(0);
                            this.gs.datat.removeAll();
                            this.gs.datat.add(this.rd, "Select Stage");
                            for (byte b = 0; b < 5; ) {
                                this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                b++;
                            }
                            this.gs.datat.select(0);
                            if (!this.redif) {
                                this.wag = 0;
                                this.imsg = "Create 4 games and " + this.intclan + " will create another 5.";
                                this.iflk = 0;
                            } else {
                                this.imsg = "Create next game.";
                                if (this.wag == 3) this.imsg = "Create last game.";
                                this.iflk = 0;
                                this.gs.ilaps.hide();
                                this.gs.icars.hide();
                                this.gs.sclass.hide();
                                this.gs.sfix.hide();
                            }
                            if (this.sendwarnum) {
                                this.sendint = 1;
                                this.gs.senditem.disable();
                                this.gs.datat.disable();
                                this.gs.ilaps.disable();
                                this.gs.icars.disable();
                                this.gs.sclass.disable();
                                this.gs.sfix.disable();
                            }
                            this.redif = false;
                        }
                        this.rd.setFont(new Font("Arial", 0, 12));
                        if (this.iflk % 3 != 0 || this.iflk == 0) this.rd.drawString(this.imsg, 376, 382);
                        if (this.iflk != 0) this.iflk--;
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.rd.drawString("Game #" + (this.wag * 2 + 2) + " :", 207, 407);
                        if (!this.gs.senditem.isShowing()) this.gs.senditem.show();
                        this.gs.senditem.move(280, 390);
                        if (!this.gs.datat.isShowing()) this.gs.datat.show();
                        this.gs.datat.move(286 + this.gs.senditem.getWidth(), 390);
                        int i = 207;
                        if (!this.gs.ilaps.isShowing()) {
                            this.gs.ilaps.show();
                            this.gs.ilaps.select(0);
                        }
                        this.gs.ilaps.move(i, 415);
                        i += 6 + this.gs.ilaps.getWidth();
                        if (!this.gs.icars.isShowing()) {
                            this.gs.icars.show();
                            this.gs.icars.select(0);
                        }
                        this.gs.icars.move(i, 415);
                        i += 6 + this.gs.icars.getWidth();
                        if (!this.gs.sclass.isShowing()) {
                            this.gs.sclass.show();
                            this.gs.sclass.select(0);
                        }
                        this.gs.sclass.move(i, 415);
                        this.gs.sclass.revup = true;
                        i += 6 + this.gs.sclass.getWidth();
                        if (!this.gs.sfix.isShowing()) {
                            this.gs.sfix.show();
                            this.gs.sfix.select(0);
                        }
                        this.gs.sfix.move(i, 415);
                        this.gs.sfix.revup = true;
                        this.gs.datat.setSize(i + this.gs.sfix.getWidth() - 286 - this.gs.senditem.getWidth(), 22);
                        if (this.gs.senditem.getSelectedIndex() == 0 && this.isel != 0) {
                            this.gs.datat.removeAll();
                            this.gs.datat.add(this.rd, "Select Stage");
                            for (byte b = 0; b < 5; ) {
                                this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                b++;
                            }
                            this.gs.datat.select(0);
                            this.isel = 0;
                        }
                        if (this.gs.senditem.getSelectedIndex() == 1 && this.isel != 1) {
                            this.gs.datat.removeAll();
                            this.gs.datat.add(this.rd, "Select Stage");
                            for (byte b = 0; b < 17; ) {
                                this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                b++;
                            }
                            this.gs.datat.select(0);
                            this.isel = 1;
                        }
                        if (this.gs.senditem.getSelectedIndex() == 2 && this.isel != 2) {
                            this.gs.datat.removeAll();
                            this.gs.datat.add(this.rd, "Select Stage");
                            for (byte b = 0; b < 10; ) {
                                this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                b++;
                            }
                            this.gs.datat.select(0);
                            this.isel = 2;
                        }
                        if (this.gs.senditem.getSelectedIndex() == 3 && this.isel < 3) {
                            this.gs.datat.removeAll();
                            this.gs.datat.add(this.rd, "Loading stages, please wait...");
                            this.gs.datat.select(0);
                            this.isel = 3;
                        }
                        if (this.sendint == 0) {
                            String str = "  Next >  ";
                            if (this.wag == 3) str = "   Done   ";
                            if (stringbutton(this.rd, str, 742, 417, 0, paramInt1, paramInt2, paramBoolean, 0, 0))
                                if (this.gs.datat.getSelectedIndex() != 0) {
                                    if (this.gs.ilaps.getSelectedIndex() != 0) {
                                        if (this.gs.icars.getSelectedIndex() != 0) {
                                            if (this.gs.senditem.getSelectedIndex() == 0)
                                                this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 27) + "";
                                            if (this.gs.senditem.getSelectedIndex() == 1)
                                                this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 10) + "";
                                            if (this.gs.senditem.getSelectedIndex() == 2)
                                                this.wstages[this.wag] = "#" + this.gs.datat.getSelectedIndex() + "";
                                            if (this.gs.senditem.getSelectedIndex() == 3)
                                                this.wstages[this.wag] = "" + this.gs.datat.getSelectedItem() + "";
                                            this.wlaps[this.wag] = this.gs.ilaps.getSelectedIndex();
                                            this.wcars[this.wag] = this.gs.icars.getSelectedIndex();
                                            this.wclass[this.wag] = this.gs.sclass.getSelectedIndex();
                                            this.wfix[this.wag] = this.gs.sfix.getSelectedIndex();
                                            this.wag++;
                                            if (this.wag < 4) {
                                                this.redif = true;
                                            } else {
                                                this.wag--;
                                                this.sendint = 1;
                                                this.gs.senditem.disable();
                                                this.gs.datat.disable();
                                                this.gs.ilaps.disable();
                                                this.gs.icars.disable();
                                                this.gs.sclass.disable();
                                                this.gs.sfix.disable();
                                            }
                                        } else {
                                            this.imsg = "Please choose a type of cars for this game!";
                                            this.iflk = 40;
                                        }
                                    } else {
                                        this.imsg = "Please select a number of laps!";
                                        this.iflk = 40;
                                    }
                                } else {
                                    this.imsg = "Please select a stage!";
                                    this.iflk = 40;
                                }
                        } else {
                            this.imsg = "Sending war declaration, pleas wait...";
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawString("Sending...", 742 - this.ftm.stringWidth("Sending...") / 2, 417);
                        }
                    }
                    if (this.gs.sendtyp.getSelectedIndex() == 5 || this.gs.sendtyp.getSelectedIndex() == 6) {
                        if (this.inishsel || this.redif) {
                            this.isel = 0;
                            this.gs.senditem.removeAll();
                            this.gs.senditem.add(this.rd, " NFM Multiplayer ");
                            this.gs.senditem.add(this.rd, " NFM 2     ");
                            this.gs.senditem.add(this.rd, " NFM 1     ");
                            this.gs.senditem.add(this.rd, " Clan Stages ");
                            this.gs.senditem.select(0);
                            this.gs.datat.removeAll();
                            this.gs.datat.add(this.rd, "Select Stage");
                            for (byte b = 0; b < 5; ) {
                                this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                b++;
                            }
                            this.gs.datat.select(0);
                            if (!this.redif) {
                                this.wag = 0;
                                this.imsg = "Create 3 games to be added to the battle.";
                                this.iflk = 0;
                            } else {
                                this.imsg = "Create next game.";
                                if (this.wag == 2) this.imsg = "Create last game.";
                                this.iflk = 0;
                                this.gs.ilaps.hide();
                                this.gs.icars.hide();
                                this.gs.sclass.hide();
                                this.gs.sfix.hide();
                            }
                            if (this.sendwarnum) {
                                this.sendint = 1;
                                this.gs.senditem.disable();
                                this.gs.datat.disable();
                                this.gs.ilaps.disable();
                                this.gs.icars.disable();
                                this.gs.sclass.disable();
                                this.gs.sfix.disable();
                            }
                            this.redif = false;
                        }
                        this.rd.setFont(new Font("Arial", 0, 12));
                        if (this.iflk % 3 != 0 || this.iflk == 0) this.rd.drawString(this.imsg, 350, 382);
                        if (this.iflk != 0) this.iflk--;
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.rd.drawString("Game #" + (this.wag * 2 + 1) + " :", 207, 407);
                        if (!this.gs.senditem.isShowing()) this.gs.senditem.show();
                        this.gs.senditem.move(280, 390);
                        if (!this.gs.datat.isShowing()) this.gs.datat.show();
                        this.gs.datat.move(286 + this.gs.senditem.getWidth(), 390);
                        int i = 207;
                        if (!this.gs.ilaps.isShowing()) {
                            this.gs.ilaps.show();
                            this.gs.ilaps.select(0);
                        }
                        this.gs.ilaps.move(i, 415);
                        i += 6 + this.gs.ilaps.getWidth();
                        if (!this.gs.icars.isShowing()) {
                            this.gs.icars.show();
                            this.gs.icars.select(0);
                        }
                        this.gs.icars.move(i, 415);
                        i += 6 + this.gs.icars.getWidth();
                        if (!this.gs.sclass.isShowing()) {
                            this.gs.sclass.show();
                            this.gs.sclass.select(0);
                        }
                        this.gs.sclass.move(i, 415);
                        this.gs.sclass.revup = true;
                        i += 6 + this.gs.sclass.getWidth();
                        if (!this.gs.sfix.isShowing()) {
                            this.gs.sfix.show();
                            this.gs.sfix.select(0);
                        }
                        this.gs.sfix.move(i, 415);
                        this.gs.sfix.revup = true;
                        this.gs.datat.setSize(i + this.gs.sfix.getWidth() - 286 - this.gs.senditem.getWidth(), 22);
                        if (this.gs.senditem.getSelectedIndex() == 0 && this.isel != 0) {
                            this.gs.datat.removeAll();
                            this.gs.datat.add(this.rd, "Select Stage");
                            for (byte b = 0; b < 5; ) {
                                this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                b++;
                            }
                            this.gs.datat.select(0);
                            this.isel = 0;
                        }
                        if (this.gs.senditem.getSelectedIndex() == 1 && this.isel != 1) {
                            this.gs.datat.removeAll();
                            this.gs.datat.add(this.rd, "Select Stage");
                            for (byte b = 0; b < 17; ) {
                                this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                b++;
                            }
                            this.gs.datat.select(0);
                            this.isel = 1;
                        }
                        if (this.gs.senditem.getSelectedIndex() == 2 && this.isel != 2) {
                            this.gs.datat.removeAll();
                            this.gs.datat.add(this.rd, "Select Stage");
                            for (byte b = 0; b < 10; ) {
                                this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                b++;
                            }
                            this.gs.datat.select(0);
                            this.isel = 2;
                        }
                        if (this.gs.senditem.getSelectedIndex() == 3 && this.isel < 3) {
                            this.gs.datat.removeAll();
                            this.gs.datat.add(this.rd, "Loading stages, please wait...");
                            this.gs.datat.select(0);
                            this.isel = 3;
                        }
                        if (this.sendint == 0) {
                            String str = "  Next >  ";
                            if (this.wag == 2) str = "   Done   ";
                            if (stringbutton(this.rd, str, 742, 417, 0, paramInt1, paramInt2, paramBoolean, 0, 0))
                                if (this.gs.datat.getSelectedIndex() != 0) {
                                    if (this.gs.ilaps.getSelectedIndex() != 0) {
                                        if (this.gs.icars.getSelectedIndex() != 0) {
                                            if (this.gs.senditem.getSelectedIndex() == 0)
                                                this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 27) + "";
                                            if (this.gs.senditem.getSelectedIndex() == 1)
                                                this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 10) + "";
                                            if (this.gs.senditem.getSelectedIndex() == 2)
                                                this.wstages[this.wag] = "#" + this.gs.datat.getSelectedIndex() + "";
                                            if (this.gs.senditem.getSelectedIndex() == 3)
                                                this.wstages[this.wag] = "" + this.gs.datat.getSelectedItem() + "";
                                            this.wlaps[this.wag] = this.gs.ilaps.getSelectedIndex();
                                            this.wcars[this.wag] = this.gs.icars.getSelectedIndex();
                                            this.wclass[this.wag] = this.gs.sclass.getSelectedIndex();
                                            this.wfix[this.wag] = this.gs.sfix.getSelectedIndex();
                                            this.wag++;
                                            if (this.wag < 3) {
                                                this.redif = true;
                                            } else {
                                                this.wag--;
                                                this.sendint = 1;
                                                this.gs.senditem.disable();
                                                this.gs.datat.disable();
                                                this.gs.ilaps.disable();
                                                this.gs.icars.disable();
                                                this.gs.sclass.disable();
                                                this.gs.sfix.disable();
                                            }
                                        } else {
                                            this.imsg = "Please choose a type of cars for this game!";
                                            this.iflk = 40;
                                        }
                                    } else {
                                        this.imsg = "Please select a number of laps!";
                                        this.iflk = 40;
                                    }
                                } else {
                                    this.imsg = "Please select a stage!";
                                    this.iflk = 40;
                                }
                        } else {
                            this.imsg = "Sending war declaration, pleas wait...";
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawString("Sending...", 742 - this.ftm.stringWidth("Sending...") / 2, 417);
                        }
                    }
                    if (this.gs.sendtyp.getSelectedIndex() == 7) {
                        if (this.inishsel || this.redif) {
                            this.isel = 0;
                            this.gs.senditem.removeAll();
                            this.gs.senditem.add(this.rd, " NFM Multiplayer ");
                            this.gs.senditem.add(this.rd, " NFM 2     ");
                            this.gs.senditem.add(this.rd, " NFM 1     ");
                            this.gs.senditem.add(this.rd, " Clan Stages ");
                            this.gs.senditem.select(0);
                            this.gs.datat.removeAll();
                            this.gs.datat.add(this.rd, "Select Stage");
                            for (byte b = 0; b < 5; ) {
                                this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                b++;
                            }
                            this.gs.datat.select(0);
                            if (!this.redif) {
                                this.wag = 0;
                                this.imsg = "Create 5 games to be added to the war.";
                                this.iflk = 0;
                            } else {
                                this.imsg = "Create next game.";
                                if (this.wag == 4) this.imsg = "Create last game.";
                                this.iflk = 0;
                                this.gs.ilaps.hide();
                                this.gs.icars.hide();
                                this.gs.sclass.hide();
                                this.gs.sfix.hide();
                            }
                            if (this.sendwarnum) {
                                this.sendint = 1;
                                this.gs.senditem.disable();
                                this.gs.datat.disable();
                                this.gs.ilaps.disable();
                                this.gs.icars.disable();
                                this.gs.sclass.disable();
                                this.gs.sfix.disable();
                            }
                            this.redif = false;
                        }
                        this.rd.setFont(new Font("Arial", 0, 12));
                        if (this.iflk % 3 != 0 || this.iflk == 0) this.rd.drawString(this.imsg, 350, 382);
                        if (this.iflk != 0) this.iflk--;
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.rd.drawString("Game #" + (this.wag * 2 + 1) + " :", 207, 407);
                        if (!this.gs.senditem.isShowing()) this.gs.senditem.show();
                        this.gs.senditem.move(280, 390);
                        if (!this.gs.datat.isShowing()) this.gs.datat.show();
                        this.gs.datat.move(286 + this.gs.senditem.getWidth(), 390);
                        int i = 207;
                        if (!this.gs.ilaps.isShowing()) {
                            this.gs.ilaps.show();
                            this.gs.ilaps.select(0);
                        }
                        this.gs.ilaps.move(i, 415);
                        i += 6 + this.gs.ilaps.getWidth();
                        if (!this.gs.icars.isShowing()) {
                            this.gs.icars.show();
                            this.gs.icars.select(0);
                        }
                        this.gs.icars.move(i, 415);
                        i += 6 + this.gs.icars.getWidth();
                        if (!this.gs.sclass.isShowing()) {
                            this.gs.sclass.show();
                            this.gs.sclass.select(0);
                        }
                        this.gs.sclass.move(i, 415);
                        this.gs.sclass.revup = true;
                        i += 6 + this.gs.sclass.getWidth();
                        if (!this.gs.sfix.isShowing()) {
                            this.gs.sfix.show();
                            this.gs.sfix.select(0);
                        }
                        this.gs.sfix.move(i, 415);
                        this.gs.sfix.revup = true;
                        this.gs.datat.setSize(i + this.gs.sfix.getWidth() - 286 - this.gs.senditem.getWidth(), 22);
                        if (this.gs.senditem.getSelectedIndex() == 0 && this.isel != 0) {
                            this.gs.datat.removeAll();
                            this.gs.datat.add(this.rd, "Select Stage");
                            for (byte b = 0; b < 5; ) {
                                this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                b++;
                            }
                            this.gs.datat.select(0);
                            this.isel = 0;
                        }
                        if (this.gs.senditem.getSelectedIndex() == 1 && this.isel != 1) {
                            this.gs.datat.removeAll();
                            this.gs.datat.add(this.rd, "Select Stage");
                            for (byte b = 0; b < 17; ) {
                                this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                b++;
                            }
                            this.gs.datat.select(0);
                            this.isel = 1;
                        }
                        if (this.gs.senditem.getSelectedIndex() == 2 && this.isel != 2) {
                            this.gs.datat.removeAll();
                            this.gs.datat.add(this.rd, "Select Stage");
                            for (byte b = 0; b < 10; ) {
                                this.gs.datat.add(this.rd, " Stage " + (b + 1) + "");
                                b++;
                            }
                            this.gs.datat.select(0);
                            this.isel = 2;
                        }
                        if (this.gs.senditem.getSelectedIndex() == 3 && this.isel < 3) {
                            this.gs.datat.removeAll();
                            this.gs.datat.add(this.rd, "Loading stages, please wait...");
                            this.gs.datat.select(0);
                            this.isel = 3;
                        }
                        if (this.sendint == 0) {
                            String str = "  Next >  ";
                            if (this.wag == 4) str = "   Done   ";
                            if (stringbutton(this.rd, str, 742, 417, 0, paramInt1, paramInt2, paramBoolean, 0, 0))
                                if (this.gs.datat.getSelectedIndex() != 0) {
                                    if (this.gs.ilaps.getSelectedIndex() != 0) {
                                        if (this.gs.icars.getSelectedIndex() != 0) {
                                            if (this.gs.senditem.getSelectedIndex() == 0)
                                                this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 27) + "";
                                            if (this.gs.senditem.getSelectedIndex() == 1)
                                                this.wstages[this.wag] = "#" + (this.gs.datat.getSelectedIndex() + 10) + "";
                                            if (this.gs.senditem.getSelectedIndex() == 2)
                                                this.wstages[this.wag] = "#" + this.gs.datat.getSelectedIndex() + "";
                                            if (this.gs.senditem.getSelectedIndex() == 3)
                                                this.wstages[this.wag] = "" + this.gs.datat.getSelectedItem() + "";
                                            this.wlaps[this.wag] = this.gs.ilaps.getSelectedIndex();
                                            this.wcars[this.wag] = this.gs.icars.getSelectedIndex();
                                            this.wclass[this.wag] = this.gs.sclass.getSelectedIndex();
                                            this.wfix[this.wag] = this.gs.sfix.getSelectedIndex();
                                            this.wag++;
                                            if (this.wag < 5) {
                                                this.redif = true;
                                            } else {
                                                this.wag--;
                                                this.sendint = 1;
                                                this.gs.senditem.disable();
                                                this.gs.datat.disable();
                                                this.gs.ilaps.disable();
                                                this.gs.icars.disable();
                                                this.gs.sclass.disable();
                                                this.gs.sfix.disable();
                                            }
                                        } else {
                                            this.imsg = "Please choose a type of cars for this game!";
                                            this.iflk = 40;
                                        }
                                    } else {
                                        this.imsg = "Please select a number of laps!";
                                        this.iflk = 40;
                                    }
                                } else {
                                    this.imsg = "Please select a stage!";
                                    this.iflk = 40;
                                }
                        } else {
                            this.imsg = "Sending war declaration, pleas wait...";
                            this.rd.setFont(new Font("Arial", 1, 12));
                            this.ftm = this.rd.getFontMetrics();
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawString("Sending...", 742 - this.ftm.stringWidth("Sending...") / 2, 417);
                        }
                    }
                    if (this.inishsel) this.inishsel = false;
                }
                if (this.openi >= 1 && this.openi < 10) {
                    this.rd.setColor(color2k(240, 240, 230));
                    this.rd.fillRoundRect(197, this.opy, 597, this.oph, 20, 20);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawRoundRect(197, this.opy, 597, this.oph, 20, 20);
                    if (!drawl(this.rd, "#" + this.intclan + "#", 207, this.opy + 7, true)) {
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString(this.intclan, 382 - this.ftm.stringWidth(this.intclan) / 2, this.opy + 26);
                        this.rd.setColor(color2k(150, 150, 150));
                        this.rd.drawRect(207, this.opy + 7, 349, 29);
                    }
                    this.opy += this.addopy;
                    this.oph += 36;
                    this.openi++;
                }
            } else {
                this.rd.setColor(color2k(230, 230, 230));
                this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
                if (this.xt.logged) {
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("You are not a member of any clan.  You need to join a clan first to have access to this.", 487 - this.ftm.stringWidth("You are not a member of any clan.  You need to join a clan first to have access to this.") / 2, 200);
                    if (stringbutton(this.rd, "   Find a clan to join   ", 487, 230, 1, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                        this.tab = 3;
                        this.cfase = 2;
                        this.em = 1;
                        this.msg = "Clan Search";
                        this.smsg = "Listing clans with recent activity...";
                        this.nclns = 0;
                        this.spos5 = 0;
                        this.lspos5 = 0;
                        this.flko = 0;
                    }
                } else {
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("You are currently using a trial account.", 495 - this.ftm.stringWidth("You are currently using a trial account.") / 2, 180);
                    this.rd.drawString("You need to upgrade to be able participate in NFM clan's activities.", 495 - this.ftm.stringWidth("You need to upgrade to be able participate in NFM clan's activities.") / 2, 200);
                    this.rd.setColor(new Color(206, 171, 98));
                    this.rd.fillRoundRect(405, 223, 180, 50, 20, 20);
                    if (drawbutton(this.xt.upgrade, 495, 248, paramInt1, paramInt2, paramBoolean))
                        this.gs.editlink(this.xt.nickname, true);
                }
                this.rd.setColor(color2k(205, 205, 205));
                this.rd.fillRect(207, 46, 582, 30);
                this.rd.setFont(new Font("Arial", 1, 12));
                String[] arrayOfString;
                int[] arrayOfInt1, arrayOfInt2;
                byte b;
                for (this.ftm = this.rd.getFontMetrics(), arrayOfString = new String[]{"Player Interaction", "Clan Interaction", "Your Clan's Discussion"}, arrayOfInt1 = new int[]{207, 390, 368, 207}, arrayOfInt2 = new int[]{73, 73, 51, 51}, b = 0; b < 3; ) {
                    if (this.itab == b) {
                        this.rd.setColor(color2k(230, 230, 230));
                        this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
                    } else if (paramInt1 > arrayOfInt1[0] && paramInt1 < arrayOfInt1[2] && paramInt2 > 51 && paramInt2 < 73) {
                        this.rd.setColor(color2k(217, 217, 217));
                        this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
                        if (paramBoolean) this.itab = b;
                    }
                    this.rd.setColor(color2k(150, 150, 150));
                    this.rd.drawPolygon(arrayOfInt1, arrayOfInt2, 4);
                    this.rd.setColor(color2k(40, 40, 40));
                    this.rd.drawString(arrayOfString[b], arrayOfInt1[0] + 80 - this.ftm.stringWidth(arrayOfString[b]) / 2, 67);
                    for (byte b1 = 0; b1 < 4; ) {
                        arrayOfInt1[b1] = arrayOfInt1[b1] + 183;
                        b1++;
                    }
                    b++;
                }
                this.rd.setColor(color2k(150, 150, 150));
                this.rd.drawLine(207, 73, 770, 73);
                this.rd.setColor(color2k(205, 205, 205));
                this.rd.fillRect(207, 409, 582, 30);
                this.rd.setColor(color2k(150, 150, 150));
                this.rd.drawLine(207, 411, 770, 411);
                this.rd.setColor(color2k(205, 205, 205));
                this.rd.fillRect(772, 76, 17, 333);
                this.rd.setColor(color2k(205, 205, 205));
                this.rd.fillRect(203, 46, 4, 393);
            }
        }
        if (this.itab == 2) {
            if (this.litab != this.itab) {
                if (this.readclan > 0) this.spos3 = 219;
                this.gs.senditem.hide();
                this.gs.datat.hide();
                this.gs.ilaps.hide();
                this.gs.icars.hide();
                this.gs.sclass.hide();
                this.gs.sfix.hide();
                this.gs.senditem.enable();
                this.gs.datat.enable();
                this.gs.ilaps.enable();
                this.gs.icars.enable();
                this.gs.sclass.enable();
                this.gs.sfix.enable();
                this.gs.sendtyp.removeAll();
                this.gs.sendtyp.add(this.rd, "Write a Message");
                this.gs.sendtyp.add(this.rd, "Share a Relative Date");
                this.gs.sendtyp.select(0);
                this.litab = this.itab;
            }
            this.rd.setColor(color2k(230, 230, 230));
            this.rd.fillRoundRect(197, 40, 597, 404, 20, 20);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawRoundRect(197, 40, 597, 404, 20, 20);
            if (!this.xt.clan.equals("")) {
                this.rd.setColor(color2k(250, 250, 250));
                this.rd.fillRect(207, 76, 565, 300);
            }
            if (this.loadedmyclanbg == 1) {
                this.rd.setComposite(AlphaComposite.getInstance(3, 0.1F));
                this.rd.drawImage(this.myclanbg, 207, 76, 565, 300, null);
                this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            }
            this.rd.setColor(new Color(0, 0, 0));
            this.sdist = 0;
            if (!this.xt.clan.equals("")) {
                if (this.gs.openm) {
                    this.blockb = 10;
                } else if (this.blockb != 0) {
                    this.blockb--;
                }
                if ((this.readclan > 0 || this.readclan == -3) && this.viewgame1 == 0) {
                    this.sdist = (int) ((this.cnml - 14.75F) * 17.0F);
                    if (this.sdist < 0) this.sdist = 0;
                    this.scro = (int) (this.spos3 / 219.0F * this.sdist);
                    for (byte b = 0; b < this.cnml; b++) {
                        if (86 + 17 * b - this.scro < 360 && 125 + 17 * b - this.scro > 76 && this.cmlinetyp[b] != 167)
                            if (this.cmlinetyp[b] != 20 && this.cmlinetyp[b] != 30 && this.cmlinetyp[b] != 40 && this.cmlinetyp[b] != 50 && this.cmlinetyp[b] != 60 && this.cmlinetyp[b] != 70 && this.cmlinetyp[b] != 80) {
                                this.rd.setColor(new Color(0, 0, 0));
                                if (this.cmlinetyp[b] >= 0) {
                                    this.rd.setFont(new Font("Tahoma", 1, 11));
                                } else {
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                }
                                this.rd.drawString(this.cmline[b], 217, 103 + 17 * b - this.scro);
                                if (this.cmlinetyp[b] >= 0) {
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    this.rd.setColor(color2k(125, 125, 125));
                                    this.rd.drawString(this.cmtimes[b], 757 - this.ftm.stringWidth(this.cmtimes[b]), 103 + 17 * b - this.scro);
                                }
                            } else {
                                if (this.cmlinetyp[b] == 20 || this.cmlinetyp[b] == 50) {
                                    if (stringbutton(this.rd, "  View Clan  ", 267, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                        String str = getSvalue(this.cmline[b], 0);
                                        if (!this.claname.equals(str)) {
                                            this.claname = str;
                                            this.loadedc = false;
                                        }
                                        this.spos5 = 0;
                                        this.lspos5 = 0;
                                        this.cfase = 3;
                                        this.ctab = 0;
                                        this.tab = 3;
                                    }
                                    if (stringbutton(this.rd, "  View War Suggestion  ", 403, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                        this.viewgame1 = 1;
                                        if (this.cmlinetyp[b] == 20) {
                                            this.nvgames1 = 4;
                                        } else {
                                            this.nvgames1 = 9;
                                        }
                                        this.xclan = getSvalue(this.cmline[b], 0);
                                        this.viewwar1 = getSvalue(this.cmline[b], 1);
                                    }
                                    if (!this.cmline[b].endsWith("|out|")) {
                                        if (this.cadmin == 1 && stringbutton(this.rd, "  Approve War  ", 548, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                            this.tab = 2;
                                            this.itab = 1;
                                            this.litab = -1;
                                            this.openi = 10;
                                            String str = getSvalue(this.cmline[b], 0);
                                            if (!this.intclan.equals(str)) {
                                                this.intclan = str;
                                                this.dispi = 0;
                                                this.nil = 0;
                                                this.lastint = "";
                                                this.readint = 1;
                                            }
                                            this.warnum = getSvalue(this.cmline[b], 1);
                                            this.sendwarnum = true;
                                            if (this.cmlinetyp[b] == 20) {
                                                this.intsel = 4;
                                            } else {
                                                this.intsel = 7;
                                            }
                                        }
                                    } else {
                                        this.rd.setColor(color2k(170, 170, 170));
                                        this.rd.drawString("[ Approved or interaction replaced. ]", 597 - this.ftm.stringWidth("[ Approved or interaction replaced. ]") / 2, 112 + 17 * b - this.scro);
                                    }
                                }
                                if (this.cmlinetyp[b] == 30 || this.cmlinetyp[b] == 60) {
                                    if (stringbutton(this.rd, "  View Clan  ", 267, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                        String str = getSvalue(this.cmline[b], 0);
                                        if (!this.claname.equals(str)) {
                                            this.claname = str;
                                            this.loadedc = false;
                                        }
                                        this.spos5 = 0;
                                        this.lspos5 = 0;
                                        this.cfase = 3;
                                        this.ctab = 0;
                                        this.tab = 3;
                                    }
                                    if (stringbutton(this.rd, "  View Battle Suggestion  ", 407, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                        this.viewgame1 = 1;
                                        if (this.cmlinetyp[b] == 30) {
                                            this.nvgames1 = 2;
                                        } else {
                                            this.nvgames1 = 5;
                                        }
                                        this.xclan = getSvalue(this.cmline[b], 0);
                                        this.viewwar1 = getSvalue(this.cmline[b], 3);
                                    }
                                    if (!this.cmline[b].endsWith("|out|")) {
                                        if (this.cadmin == 1 && stringbutton(this.rd, "  Approve Battle  ", 560, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                            this.tab = 2;
                                            this.itab = 1;
                                            this.litab = -1;
                                            this.openi = 10;
                                            String str = getSvalue(this.cmline[b], 0);
                                            if (!this.intclan.equals(str)) {
                                                this.intclan = str;
                                                this.dispi = 0;
                                                this.nil = 0;
                                                this.lastint = "";
                                                this.readint = 1;
                                            }
                                            this.itake = getSvalue(this.cmline[b], 1);
                                            this.igive = getSvalue(this.cmline[b], 2);
                                            this.warnum = getSvalue(this.cmline[b], 3);
                                            this.sendwarnum = true;
                                            if (this.cmlinetyp[b] == 30) {
                                                this.intsel = 3;
                                            } else {
                                                this.intsel = 6;
                                            }
                                        }
                                    } else {
                                        this.rd.setColor(color2k(170, 170, 170));
                                        this.rd.drawString("[ Approved or interaction replaced. ]", 604 - this.ftm.stringWidth("[ Approved or interaction replaced. ]") / 2, 112 + 17 * b - this.scro);
                                    }
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    if (stringbutton(this.rd, "  View Car  ", 217 + this.ftm.stringWidth(this.cmline[b + 2]) + 47, 137 + 17 * b - this.scro, 6, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                        this.viewcar = getSvalue(this.cmline[b], 1);
                                        String str = getSvalue(this.cmline[b], 0);
                                        if (!this.claname.equals(str)) {
                                            this.claname = str;
                                            this.loadedc = false;
                                        }
                                        this.spos5 = 0;
                                        this.lspos5 = 0;
                                        this.cfase = 3;
                                        this.loadedcars = -1;
                                        this.loadedcar = 0;
                                        this.ctab = 2;
                                        this.tab = 3;
                                    }
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    if (stringbutton(this.rd, "  View Car  ", 217 + this.ftm.stringWidth(this.cmline[b + 3]) + 47, 154 + 17 * b - this.scro, 6, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                        this.viewcar = getSvalue(this.cmline[b], 2);
                                        if (!this.claname.equals(this.xt.clan)) {
                                            this.claname = this.xt.clan;
                                            this.loadedc = false;
                                        }
                                        this.spos5 = 0;
                                        this.lspos5 = 0;
                                        this.cfase = 3;
                                        this.loadedcars = -1;
                                        this.loadedcar = 0;
                                        this.ctab = 2;
                                        this.tab = 3;
                                    }
                                }
                                if (this.cmlinetyp[b] == 40 || this.cmlinetyp[b] == 70) {
                                    if (stringbutton(this.rd, "  View Clan  ", 267, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                        String str = getSvalue(this.cmline[b], 0);
                                        if (!this.claname.equals(str)) {
                                            this.claname = str;
                                            this.loadedc = false;
                                        }
                                        this.spos5 = 0;
                                        this.lspos5 = 0;
                                        this.cfase = 3;
                                        this.ctab = 0;
                                        this.tab = 3;
                                    }
                                    if (stringbutton(this.rd, "  View Battle Suggestion  ", 407, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                        this.viewgame1 = 1;
                                        if (this.cmlinetyp[b] == 40) {
                                            this.nvgames1 = 2;
                                        } else {
                                            this.nvgames1 = 5;
                                        }
                                        this.xclan = getSvalue(this.cmline[b], 0);
                                        this.viewwar1 = getSvalue(this.cmline[b], 3);
                                    }
                                    if (!this.cmline[b].endsWith("|out|")) {
                                        if (this.cadmin == 1 && stringbutton(this.rd, "  Approve Battle  ", 560, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                            this.tab = 2;
                                            this.itab = 1;
                                            this.litab = -1;
                                            this.openi = 10;
                                            String str = getSvalue(this.cmline[b], 0);
                                            if (!this.intclan.equals(str)) {
                                                this.intclan = str;
                                                this.dispi = 0;
                                                this.nil = 0;
                                                this.lastint = "";
                                                this.readint = 1;
                                            }
                                            this.itake = getSvalue(this.cmline[b], 1);
                                            this.igive = getSvalue(this.cmline[b], 2);
                                            this.warnum = getSvalue(this.cmline[b], 3);
                                            this.sendwarnum = true;
                                            if (this.cmlinetyp[b] == 40) {
                                                this.intsel = 2;
                                            } else {
                                                this.intsel = 5;
                                            }
                                        }
                                    } else {
                                        this.rd.setColor(color2k(170, 170, 170));
                                        this.rd.drawString("[ Approved or interaction replaced. ]", 604 - this.ftm.stringWidth("[ Approved or interaction replaced. ]") / 2, 112 + 17 * b - this.scro);
                                    }
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    if (stringbutton(this.rd, "  View Stage  ", 217 + this.ftm.stringWidth(this.cmline[b + 2]) + 54, 137 + 17 * b - this.scro, 6, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                        this.viewcar = getSvalue(this.cmline[b], 1);
                                        String str = getSvalue(this.cmline[b], 0);
                                        if (!this.claname.equals(str)) {
                                            this.claname = str;
                                            this.loadedc = false;
                                        }
                                        this.spos5 = 0;
                                        this.lspos5 = 0;
                                        this.cfase = 3;
                                        this.loadedstages = -1;
                                        this.loadedstage = 0;
                                        this.ctab = 3;
                                        this.tab = 3;
                                    }
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    this.ftm = this.rd.getFontMetrics();
                                    if (stringbutton(this.rd, "  View Stage  ", 217 + this.ftm.stringWidth(this.cmline[b + 3]) + 54, 154 + 17 * b - this.scro, 6, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                        this.viewcar = getSvalue(this.cmline[b], 2);
                                        if (!this.claname.equals(this.xt.clan)) {
                                            this.claname = this.xt.clan;
                                            this.loadedc = false;
                                        }
                                        this.spos5 = 0;
                                        this.lspos5 = 0;
                                        this.cfase = 3;
                                        this.loadedstages = -1;
                                        this.loadedstage = 0;
                                        this.ctab = 3;
                                        this.tab = 3;
                                    }
                                }
                                if (this.cmlinetyp[b] == 80)
                                    if (stringbutton(this.rd, "  View Championship  ", 295, 112 + 17 * b - this.scro, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                                        this.cfase = 0;
                                        this.ntab = 1;
                                        this.loadwstat = 0;
                                        this.tab = 3;
                                    }
                            }
                    }
                }
                if (this.readclan == -3) {
                    this.rd.setColor(color2k(240, 240, 240));
                    this.rd.fillRoundRect(387, 140, 200, 30, 20, 20);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawRoundRect(387, 140, 200, 30, 20, 20);
                    this.rd.setFont(new Font("Tahoma", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Reading...", 487 - this.ftm.stringWidth("Reading...") / 2, 160);
                }
                if (this.readclan == -1) {
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Failed to load clan's conversation, please try again later...", 487 - this.ftm.stringWidth("Failed to load clan's conversation, please try again later...") / 2, 200);
                }
                if (this.readclan == -2) {
                    this.rd.setFont(new Font("Arial", 1, 11));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Failed to send data, please try again later...", 487 - this.ftm.stringWidth("Failed to send data, please try again later...") / 2, 200);
                }
                this.rd.setColor(color2k(205, 205, 205));
                this.rd.fillRect(207, 76, 357, 36);
                if (!drawl(this.rd, "#" + this.xt.clan + "#", 209, 78, true)) {
                    this.rd.drawRect(209, 78, 349, 29);
                    this.rd.setFont(new Font("Arial", 1, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("" + this.xt.clan + "", 384 - this.ftm.stringWidth("" + this.xt.clan + "") / 2, 98);
                }
                if (paramInt1 > 209 && paramInt1 < 559 && paramInt2 > 78 && paramInt2 < 108 && this.blockb == 0) {
                    this.cur = 12;
                    if (paramBoolean) {
                        if (!this.claname.equals(this.xt.clan)) {
                            this.claname = this.xt.clan;
                            this.loadedc = false;
                        }
                        this.spos5 = 0;
                        this.lspos5 = 0;
                        this.cfase = 3;
                        this.ctab = 0;
                        this.tab = 3;
                    }
                }
            } else if (this.xt.logged) {
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString("You are not a member of any clan.  You need to join a clan first to have access to this.", 487 - this.ftm.stringWidth("You are not a member of any clan.  You need to join a clan first to have access to this.") / 2, 170);
                if (stringbutton(this.rd, "   Find a clan to join   ", 487, 200, 1, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                    this.tab = 3;
                    this.cfase = 2;
                    this.em = 1;
                    this.msg = "Clan Search";
                    this.smsg = "Listing clans with recent activity...";
                    this.nclns = 0;
                    this.spos5 = 0;
                    this.lspos5 = 0;
                    this.flko = 0;
                }
            } else {
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                this.rd.drawString("You are currently using a trial account.", 495 - this.ftm.stringWidth("You are currently using a trial account.") / 2, 150);
                this.rd.drawString("You need to upgrade to be able participate in NFM clan's activities.", 495 - this.ftm.stringWidth("You need to upgrade to be able participate in NFM clan's activities.") / 2, 170);
                this.rd.setColor(new Color(206, 171, 98));
                this.rd.fillRoundRect(405, 193, 180, 50, 20, 20);
                if (drawbutton(this.xt.upgrade, 495, 218, paramInt1, paramInt2, paramBoolean))
                    this.gs.editlink(this.xt.nickname, true);
            }
            this.rd.setColor(color2k(205, 205, 205));
            this.rd.fillRect(207, 46, 582, 30);
            this.rd.setFont(new Font("Arial", 1, 12));
            String[] arrayOfString;
            int arrayOfInt1[], arrayOfInt2[], i;
            for (this.ftm = this.rd.getFontMetrics(), arrayOfString = new String[]{"Player Interaction", "Clan Interaction", "Your Clan's Discussion"}, arrayOfInt1 = new int[]{207, 390, 368, 207}, arrayOfInt2 = new int[]{73, 73, 51, 51}, i = 0; i < 3; ) {
                if (this.itab == i) {
                    this.rd.setColor(color2k(230, 230, 230));
                    this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
                } else if (paramInt1 > arrayOfInt1[0] && paramInt1 < arrayOfInt1[2] && paramInt2 > 51 && paramInt2 < 73) {
                    this.rd.setColor(color2k(217, 217, 217));
                    this.rd.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
                    if (paramBoolean) this.itab = i;
                }
                this.rd.setColor(color2k(150, 150, 150));
                this.rd.drawPolygon(arrayOfInt1, arrayOfInt2, 4);
                this.rd.setColor(color2k(40, 40, 40));
                this.rd.drawString(arrayOfString[i], arrayOfInt1[0] + 80 - this.ftm.stringWidth(arrayOfString[i]) / 2, 67);
                for (byte b = 0; b < 4; ) {
                    arrayOfInt1[b] = arrayOfInt1[b] + 183;
                    b++;
                }
                i++;
            }
            this.rd.setColor(color2k(150, 150, 150));
            this.rd.drawLine(207, 73, 770, 73);
            this.rd.setColor(color2k(205, 205, 205));
            this.rd.fillRect(207, 360, 582, 79);
            this.rd.setColor(color2k(150, 150, 150));
            this.rd.drawLine(207, 362, 770, 362);
            this.rd.setColor(color2k(205, 205, 205));
            this.rd.fillRect(772, 76, 17, 333);
            this.rd.setColor(color2k(205, 205, 205));
            this.rd.fillRect(203, 46, 4, 393);
            if (this.mscro3 == 831 || this.sdist == 0) {
                if (this.sdist == 0) {
                    this.rd.setColor(color2k(205, 205, 205));
                } else {
                    this.rd.setColor(color2k(215, 215, 215));
                }
                this.rd.fillRect(772, 76, 17, 17);
            } else {
                this.rd.setColor(color2k(220, 220, 220));
                this.rd.fill3DRect(772, 76, 17, 17, true);
            }
            if (this.sdist != 0) this.rd.drawImage(this.xt.asu, 777, 82, (ImageObserver) null);
            if (this.mscro3 == 832 || this.sdist == 0) {
                if (this.sdist == 0) {
                    this.rd.setColor(color2k(205, 205, 205));
                } else {
                    this.rd.setColor(color2k(215, 215, 215));
                }
                this.rd.fillRect(772, 343, 17, 17);
            } else {
                this.rd.setColor(color2k(220, 220, 220));
                this.rd.fill3DRect(772, 343, 17, 17, true);
            }
            if (this.sdist != 0) this.rd.drawImage(this.xt.asd, 777, 350, (ImageObserver) null);
            if (this.sdist != 0) {
                if (this.lspos3 != this.spos3) {
                    this.rd.setColor(color2k(215, 215, 215));
                    this.rd.fillRect(772, 93 + this.spos3, 17, 31);
                } else {
                    if (this.mscro3 == 831) this.rd.setColor(color2k(215, 215, 215));
                    this.rd.fill3DRect(772, 93 + this.spos3, 17, 31, true);
                }
                this.rd.setColor(color2k(150, 150, 150));
                this.rd.drawLine(777, 106 + this.spos3, 783, 106 + this.spos3);
                this.rd.drawLine(777, 108 + this.spos3, 783, 108 + this.spos3);
                this.rd.drawLine(777, 110 + this.spos3, 783, 110 + this.spos3);
                if (this.mscro3 > 800 && this.lspos3 != this.spos3) this.lspos3 = this.spos3;
                if (paramBoolean && this.openc == 0) {
                    if (this.mscro3 == 825 && paramInt1 > 772 && paramInt1 < 789 && paramInt2 > 93 + this.spos3 && paramInt2 < this.spos3 + 124)
                        this.mscro3 = paramInt2 - this.spos3;
                    if (this.mscro3 == 825 && paramInt1 > 770 && paramInt1 < 791 && paramInt2 > 74 && paramInt2 < 95)
                        this.mscro3 = 831;
                    if (this.mscro3 == 825 && paramInt1 > 770 && paramInt1 < 791 && paramInt2 > 341 && paramInt2 < 362)
                        this.mscro3 = 832;
                    if (this.mscro3 == 825 && paramInt1 > 772 && paramInt1 < 789 && paramInt2 > 93 && paramInt2 < 343) {
                        this.mscro3 = 108;
                        this.spos3 = paramInt2 - this.mscro3;
                    }
                    i = 2670 / this.sdist;
                    if (i < 1) i = 1;
                    if (this.mscro3 == 831) {
                        this.spos3 -= i;
                        if (this.spos3 > 219) this.spos3 = 219;
                        if (this.spos3 < 0) this.spos3 = 0;
                        this.lspos3 = this.spos3;
                    }
                    if (this.mscro3 == 832) {
                        this.spos3 += i;
                        if (this.spos3 > 219) this.spos3 = 219;
                        if (this.spos3 < 0) this.spos3 = 0;
                        this.lspos3 = this.spos3;
                    }
                    if (this.mscro3 < 800) {
                        this.spos3 = paramInt2 - this.mscro3;
                        if (this.spos3 > 219) this.spos3 = 219;
                        if (this.spos3 < 0) this.spos3 = 0;
                    }
                    if (this.mscro3 == 825) this.mscro3 = 925;
                } else if (this.mscro3 != 825) {
                    this.mscro3 = 825;
                }
            }
            if (this.viewgame1 != 0) {
                this.rd.setColor(color2k(210, 210, 210));
                this.rd.fillRoundRect(204, 127, 583, 230, 20, 20);
                this.rd.setColor(color2k(150, 150, 150));
                this.rd.drawRoundRect(204, 127, 583, 230, 20, 20);
                this.rd.setFont(new Font("Tahoma", 1, 11));
                this.ftm = this.rd.getFontMetrics();
                this.rd.setColor(new Color(0, 0, 0));
                if (this.nvgames1 == 4) {
                    this.rd.drawString("War declaration, your clan " + this.xt.clan + " versus " + this.xclan + ".", 215, 145);
                    if (this.viewgame1 == 2)
                        this.rd.drawString("" + this.xclan + " would create 5 more games and the first clan to win 5 games wins the war!", 215, 210 + this.nvgames1 * 18);
                }
                if (this.nvgames1 == 2) {
                    this.rd.drawString("Battle, your clan " + this.xt.clan + " versus " + this.xclan + ".", 215, 145);
                    if (this.viewgame1 == 2)
                        this.rd.drawString("" + this.xclan + " would create 3 more games and the first clan to win 3 games wins the battle!", 215, 210 + this.nvgames1 * 18);
                }
                if (this.nvgames1 == 9)
                    this.rd.drawString("Suggestion to accept war, your clan " + this.xt.clan + " versus " + this.xclan + ".", 215, 145);
                if (this.nvgames1 == 5)
                    this.rd.drawString("Suggestion to accept to battle, your clan " + this.xt.clan + " versus " + this.xclan + ".", 215, 145);
                if (stringbutton(this.rd, "Close X", 749, 148, 3, paramInt1, paramInt2, paramBoolean, 0, 0))
                    this.viewgame1 = 0;
                this.rd.setFont(new Font("Tahoma", 1, 11));
                this.ftm = this.rd.getFontMetrics();
                this.rd.setColor(new Color(0, 0, 0));
                if (this.viewgame1 == 2) {
                    this.rd.drawString("Game", 246 - this.ftm.stringWidth("Game") / 2, 175);
                    this.rd.drawString("Stage", 412 - this.ftm.stringWidth("Stage") / 2, 175);
                    this.rd.drawString("Laps", 564 - this.ftm.stringWidth("Laps") / 2, 175);
                    this.rd.drawString("Type of Cars", 653 - this.ftm.stringWidth("Type of Cars") / 2, 175);
                    this.rd.drawString("Fixing", 751 - this.ftm.stringWidth("Fixing") / 2, 175);
                    i = 1;
                    byte b1 = 1;
                    if (this.nvgames1 == 4 || this.nvgames1 == 2) {
                        i = 2;
                        b1 = 2;
                    }
                    for (byte b2 = 0; b2 < this.nvgames1; b2++) {
                        this.rd.setFont(new Font("Tahoma", 0, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("# " + i + "", 246 - this.ftm.stringWidth("# " + i + "") / 2, 193 + b2 * 18);
                        i += b1;
                        this.rd.drawString(this.vwstages1[b2], 412 - this.ftm.stringWidth(this.vwstages1[b2]) / 2, 193 + b2 * 18);
                        this.rd.drawString("" + this.vwlaps1[b2] + "", 564 - this.ftm.stringWidth("" + this.vwlaps1[b2] + "") / 2, 193 + b2 * 18);
                        String str1 = "All Cars";
                        if (this.vwcars1[b2] == 2) str1 = "Clan Cars";
                        if (this.vwcars1[b2] == 3) str1 = "Game Cars";
                        if (this.vwclass1[b2] == 0) str1 = str1 + ", All Classes";
                        if (this.vwclass1[b2] == 1) str1 = str1 + ", Class C";
                        if (this.vwclass1[b2] == 2) str1 = str1 + ", Class B & C";
                        if (this.vwclass1[b2] == 3) str1 = str1 + ", Class B";
                        if (this.vwclass1[b2] == 4) str1 = str1 + ", Class A & B";
                        if (this.vwclass1[b2] == 5) str1 = str1 + ", Class A";
                        this.rd.drawString(str1, 653 - this.ftm.stringWidth(str1) / 2, 193 + b2 * 18);
                        String str2 = "Infinite";
                        if (this.vwfix1[b2] == 1) str2 = "4 Fixes";
                        if (this.vwfix1[b2] == 2) str2 = "3 Fixes";
                        if (this.vwfix1[b2] == 3) str2 = "2 Fixes";
                        if (this.vwfix1[b2] == 4) str2 = "1 Fix";
                        if (this.vwfix1[b2] == 5) str2 = "No Fixing";
                        this.rd.drawString(str2, 751 - this.ftm.stringWidth(str2) / 2, 193 + b2 * 18);
                        this.rd.drawRect(213, 180 + b2 * 18, 565, 18);
                    }
                    this.rd.drawLine(213, 162, 213, 180 + this.nvgames1 * 18);
                    this.rd.drawLine(279, 162, 279, 180 + this.nvgames1 * 18);
                    this.rd.drawLine(546, 162, 546, 180 + this.nvgames1 * 18);
                    this.rd.drawLine(583, 162, 583, 180 + this.nvgames1 * 18);
                    this.rd.drawLine(723, 162, 723, 180 + this.nvgames1 * 18);
                    this.rd.drawLine(778, 162, 778, 180 + this.nvgames1 * 18);
                }
                if (this.viewgame1 == 1)
                    this.rd.drawString("Loading...", 495 - this.ftm.stringWidth("Loading...") / 2, 242);
                if (this.viewgame1 == 3) {
                    if (this.nvgames1 == 4 || this.nvgames1 == 9)
                        this.rd.drawString("This war suggestion has expired and no longer exists.", 495 - this.ftm.stringWidth("This war suggestion has expired and no longer exists.") / 2, 232);
                    if (this.nvgames1 == 2 || this.nvgames1 == 5)
                        this.rd.drawString("This battle suggestion has expired and no longer exists.", 495 - this.ftm.stringWidth("This battle suggestion has expired and no longer exists.") / 2, 232);
                    this.rd.drawString("(Suggestions expire after 90 days.)", 495 - this.ftm.stringWidth("(Suggestions expire after 90 days.)") / 2, 252);
                }
                if (this.viewgame1 == 4)
                    this.rd.drawString("Error loading suggestion, please try again later...", 495 - this.ftm.stringWidth("Error loading suggestion, please try again later...") / 2, 242);
            }
            if (!this.xt.clan.equals("")) {
                if (!this.gs.sendtyp.isShowing()) {
                    this.gs.sendtyp.show();
                    this.gs.sendtyp.select(0);
                }
                this.gs.sendtyp.move(207, 365);
                if (this.sendcmsg != 0) {
                    this.gs.sendtyp.disable();
                } else {
                    this.gs.sendtyp.enable();
                }
                this.darker = true;
                if (this.gs.sendtyp.getSelectedIndex() == 0) {
                    this.dommsg = true;
                    if (this.sendcmsg == 0) {
                        if (stringbutton(this.rd, "   Send  >  ", 723, 408, 0, paramInt1, paramInt2, paramBoolean, 0, 0) && !this.gs.mmsg.getText().trim().equals("") && this.gs.mmsg.getText().toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) == -1 && this.xt.acexp != -3)
                            if (!this.xt.msgcheck(this.gs.mmsg.getText())) {
                                this.sendcmsg = 1;
                                this.viewgame1 = 0;
                            } else {
                                this.gs.sendtyp.hide();
                                this.xt.warning++;
                            }
                    } else {
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 408);
                    }
                }
                if (this.gs.sendtyp.getSelectedIndex() == 1) {
                    this.rd.setFont(new Font("Arial", 0, 12));
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("A date that gets converted to the local time of any person previewing it.", 376, 382);
                    if (!this.gs.senditem.isShowing()) {
                        this.gs.senditem.removeAll();
                        Calendar calendar;
                        boolean bool;
                        byte b;
                        for (calendar = Calendar.getInstance(), bool = false, b = 0; b < 20; ) {
                            String str = this.wday[calendar.get(7) - 1];
                            if (!bool) {
                                str = "Today";
                                bool = true;
                            }
                            this.gs.senditem.add(this.rd, "" + str + "  -  " + this.month[calendar.get(2)] + " " + calendar.get(5) + "");
                            calendar.roll(5, true);
                            b++;
                        }
                        this.gs.senditem.select(0);
                        this.gs.senditem.show();
                    }
                    if (!this.gs.datat.isShowing()) {
                        this.gs.datat.removeAll();
                        String str;
                        byte b;
                        for (i = 12, str = "PM", b = 0; b < 24; ) {
                            this.gs.datat.add(this.rd, "" + i + " " + str + "");
                            if (++i == 12) str = "AM";
                            if (i == 13) i = 1;
                            b++;
                        }
                        this.gs.datat.select(0);
                        this.gs.datat.show();
                    }
                    this.gs.senditem.move(300, 395);
                    this.gs.datat.move(491, 395);
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("Date is displayed based on your computer calendar's date/time, please make sure it is correct.", 207, 435);
                    if (this.sendcmsg == 0) {
                        if (stringbutton(this.rd, "   Send  >  ", 723, 408, 0, paramInt1, paramInt2, paramBoolean, 0, 0)) {
                            this.sendcmsg = 1;
                            this.viewgame1 = 0;
                        }
                    } else {
                        this.rd.setFont(new Font("Arial", 1, 12));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Sending...", 723 - this.ftm.stringWidth("Sending...") / 2, 408);
                    }
                } else {
                    if (this.gs.senditem.isShowing()) this.gs.senditem.hide();
                    if (this.gs.datat.isShowing()) this.gs.datat.hide();
                }
                this.darker = false;
            }
        }
    }

    public void run() {
        try {
            this.socket = new Socket(this.lg.servers[0], 7061);
            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.dout = new PrintWriter(this.socket.getOutputStream(), true);
        } catch (Exception exception) {
            this.domon = false;
        }
        while (this.domon) {
            String str1 = "", str2 = "";
            str1 = "101|0|" + this.xt.nickname + ":" + this.xt.nickey + "|";
            try {
                this.dout.println(str1);
                str2 = this.din.readLine();
                if (str2 == null) this.domon = false;
            } catch (Exception exception) {
                this.domon = false;
            }
            if (this.domon) {
                this.ntime = getLvalue(str2, 0);
                this.maxclans = getvalue(str2, 1);
                byte b1;
                for (b1 = 0; b1 < 3; ) {
                    for (byte b = 0; b < 5; ) {
                        this.roomf[b1][b] = 0;
                        b++;
                    }
                    b1++;
                }
                b1 = 0;
                byte b2 = 2;
                boolean bool = false;
                while (!bool) {
                    String str = getSvalue(str2, b2);
                    if (!str.equals("")) {
                        int i = getvalue(str2, b2 + 1), j = getvalue(str2, b2 + 2);
                        if ((i == -1 || j == -1) && b1 < '΄') {
                            this.pname[b1] = str;
                            this.proom[b1] = i;
                            this.pserver[b1] = j;
                            b1++;
                        }
                    } else {
                        bool = true;
                    }
                    b2 += 3;
                }
                b2 = 2;
                bool = false;
                while (!bool) {
                    String str = getSvalue(str2, b2);
                    if (!str.equals("")) {
                        int i = getvalue(str2, b2 + 1), j = getvalue(str2, b2 + 2);
                        if (i >= 0 && i <= 4 && j >= 0 && j <= 2) {
                            this.roomf[j][i] = this.roomf[j][i] + 1;
                            if (b1 < '΄') {
                                this.pname[b1] = str;
                                this.proom[b1] = i;
                                this.pserver[b1] = j;
                                b1++;
                            }
                        }
                    } else {
                        bool = true;
                    }
                    b2 += 3;
                }
                this.npo = b1;
            }
            if (this.ptab == 1) {
                if (this.freq == 2) {
                    str1 = "101|14|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.freqname + "|";
                    try {
                        this.dout.println(str1);
                        str2 = this.din.readLine();
                    } catch (Exception exception) {
                    }
                    if (str2.equals("OK")) {
                        this.freq = 0;
                        this.npf = -1;
                    } else {
                        this.freq = -1;
                        this.cntf = 40;
                    }
                }
                if (this.freq == 3) {
                    str1 = "101|15|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.freqname + "|";
                    try {
                        this.dout.println(str1);
                        str2 = this.din.readLine();
                    } catch (Exception exception) {
                    }
                    if (str2.equals("OK")) {
                        this.freq = 0;
                        this.npf = -1;
                    } else {
                        this.freq = -2;
                        this.cntf = 40;
                    }
                }
                if (this.freq == -6) {
                    str1 = "101|18|" + this.xt.nickname + "|" + this.xt.nickey + "|";
                    try {
                        this.dout.println(str1);
                        str2 = this.din.readLine();
                    } catch (Exception exception) {
                    }
                    this.freq = 0;
                }
                loadfriends();
            }
            if (this.sfreq == 1) {
                str1 = "101|16|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.proname + "|";
                try {
                    this.dout.println(str1);
                    str2 = this.din.readLine();
                } catch (Exception exception) {
                }
                if (str2.equals("OK")) {
                    this.sfreq = 2;
                } else {
                    this.sfreq = 3;
                }
            }
            if (this.sfreq == 4) {
                str1 = "101|17|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.proname + "|";
                try {
                    this.dout.println(str1);
                    str2 = this.din.readLine();
                } catch (Exception exception) {
                }
                if (str2.equals("OK")) {
                    this.sfreq = 5;
                    this.npf = -1;
                } else {
                    this.sfreq = 6;
                }
            }
            if (this.sentchange == 2 && this.domon) {
                str1 = "101|5|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.sentance + "|";
                try {
                    this.dout.println(str1);
                    str2 = this.din.readLine();
                } catch (Exception exception) {
                }
                this.sentchange = 0;
            }
            if (this.tab == 2 && this.domon) {
                if (this.itab == 0) {
                    if (!this.blockname.equals("")) {
                        for (byte b = 0; b < this.nm; ) {
                            if (this.mname[b].equals(this.blockname)) {
                                this.mtyp[b] = 3;
                                break;
                            }
                            b++;
                        }
                        try {
                            str1 = "101|11|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.blockname + "|";
                            this.dout.println(str1);
                            str2 = this.din.readLine();
                        } catch (Exception exception) {
                        }
                        this.blockname = "";
                    }
                    if (!this.unblockname.equals("")) {
                        for (byte b = 0; b < this.nm; ) {
                            if (this.mname[b].equals(this.unblockname)) {
                                this.mtyp[b] = 0;
                                break;
                            }
                            b++;
                        }
                        try {
                            str1 = "101|12|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.unblockname + "|";
                            this.dout.println(str1);
                            str2 = this.din.readLine();
                        } catch (Exception exception) {
                        }
                        this.unblockname = "";
                    }
                    try {
                        str1 = "101|13|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.loadmsgs + "|";
                        this.dout.println(str1);
                        str2 = this.din.readLine();
                        if (str2.startsWith("MSGS")) {
                            this.loadmsgs = getvalue(str2, 1);
                            DataInputStream dataInputStream = new DataInputStream(this.socket.getInputStream());
                            byte[] arrayOfByte = new byte[this.loadmsgs];
                            dataInputStream.readFully(arrayOfByte);
                            str2 = this.din.readLine();
                            dataInputStream = new DataInputStream(new ByteArrayInputStream(arrayOfByte));
                            String str = "";
                            this.nm = 0;
                            while ((str = dataInputStream.readLine()) != null && this.nm < 200) {
                                this.mname[this.nm] = getSvalue(str, 0);
                                this.mtyp[this.nm] = getvalue(str, 1);
                                this.mconvo[this.nm] = getSvalue(str, 2);
                                this.msub[this.nm] = getSvalue(str, 3);
                                this.mctime[this.nm] = getLvalue(str, 4);
                                this.mtime[this.nm] = "";
                                this.nm++;
                            }
                        } else if (str2.equals("NOMSGS")) {
                            this.loadmsgs = 0;
                        }
                    } catch (Exception exception) {
                        this.loadmsgs = -2;
                    }
                    if (this.loadmsgs > 0) for (byte b = 0; b < this.nm; ) {
                        if (this.mctime[b] > 0L) {
                            try {
                                long l = this.ntime - this.mctime[b];
                                String str = "Received";
                                if (this.mtyp[b] == 2) str = "Sent";
                                if (l >= 1000L && l < 60000L) this.mtime[b] = "" + str + " seconds ago";
                                if (l >= 60000L && l < 3600000L) {
                                    int i = (int) (l / 60000L);
                                    String str3 = "s";
                                    if (i == 1) str3 = "";
                                    this.mtime[b] = "" + str + " " + i + " minute" + str3 + " ago";
                                }
                                if (l >= 3600000L && l < 86400000L) {
                                    int i = (int) (l / 3600000L);
                                    String str3 = "s";
                                    if (i == 1) str3 = "";
                                    this.mtime[b] = "" + str + " " + i + " hour" + str3 + " ago";
                                }
                                if (l >= 86400000L) {
                                    int i = (int) (l / 86400000L);
                                    String str3 = "s";
                                    if (i == 1) str3 = "";
                                    this.mtime[b] = "" + str + " " + i + " day" + str3 + " ago";
                                }
                            } catch (Exception exception) {
                                this.mtime[b] = "";
                            }
                        } else {
                            this.mtime[b] = "";
                        }
                        b++;
                    }
                    if (this.openc != 0) {
                        boolean bool = false;
                        int i = -1;
                        int j;
                        for (j = 0; j < this.nm; ) {
                            if (this.mname[j].equals(this.opname)) {
                                i = j;
                                break;
                            }
                            j++;
                        }
                        if (i != -1 && this.readmsg != 3 && this.readmsg != 4 && this.readmsg != 5) {
                            if (!this.lastsub.equals("" + this.mctime[i])) {
                                bool = true;
                                this.readmsg = 1;
                            } else {
                                this.readmsg = 2;
                            }
                        } else {
                            this.lastsub = "";
                            if (this.readmsg == 1) {
                                this.readmsg = 0;
                                this.nml = 0;
                            }
                        }
                        if (bool) try {
                            str1 = "101|8|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.mconvo[i] + "";
                            this.dout.println(str1);
                            str2 = this.din.readLine();
                            if (str2.startsWith("RECIVE")) {
                                for (j = 0; j < this.nml; ) {
                                    this.mline[j] = null;
                                    this.mlinetyp[j] = 0;
                                    this.mctimes[j] = 0L;
                                    this.mtimes[j] = null;
                                    j++;
                                }
                                this.nml = 0;
                                this.cd.acname = "";
                                this.cd.action = 0;
                                this.cd.onstage = "";
                                this.addstage = 0;
                                this.nclns = 0;
                                j = getvalue(str2, 1);
                                DataInputStream dataInputStream = new DataInputStream(this.socket.getInputStream());
                                byte[] arrayOfByte = new byte[j];
                                dataInputStream.readFully(arrayOfByte);
                                str2 = this.din.readLine();
                                dataInputStream = new DataInputStream(new ByteArrayInputStream(arrayOfByte));
                                String str = "";
                                while ((str = dataInputStream.readLine()) != null) {
                                    if (str.startsWith("|")) {
                                        if (this.nml != 0) {
                                            this.mline[this.nml] = "";
                                            this.mlinetyp[this.nml] = 167;
                                            this.nml++;
                                        }
                                        String str3 = getSvalue(str, 1);
                                        if (str3.toLowerCase().equals(this.xt.nickname.toLowerCase())) str3 = "You";
                                        this.mlinetyp[this.nml] = getvalue(str, 2);
                                        int k = this.mlinetyp[this.nml];
                                        if (k == 0) {
                                            this.mline[this.nml] = "" + str3 + " wrote:";
                                            this.mctimes[this.nml] = getLvalue(str, 3);
                                            this.mtimes[this.nml] = "";
                                            this.nml++;
                                        }
                                        if (k == 1) {
                                            this.mline[this.nml] = "" + str3 + " shared a car:";
                                            this.mctimes[this.nml] = getLvalue(str, 3);
                                            this.mtimes[this.nml] = "";
                                            this.nml++;
                                            this.mline[this.nml] = getSvalue(str, 4);
                                            this.mlinetyp[this.nml] = 10;
                                            this.nml++;
                                            this.mline[this.nml] = "";
                                            this.mlinetyp[this.nml] = 167;
                                            this.nml++;
                                        }
                                        if (k == 2) {
                                            this.mline[this.nml] = "" + str3 + " shared a stage:";
                                            this.mctimes[this.nml] = getLvalue(str, 3);
                                            this.mtimes[this.nml] = "";
                                            this.nml++;
                                            this.mline[this.nml] = getSvalue(str, 4);
                                            this.mlinetyp[this.nml] = 20;
                                            this.nml++;
                                            this.mline[this.nml] = "";
                                            this.mlinetyp[this.nml] = 167;
                                            this.nml++;
                                        }
                                        if (k == 3) {
                                            if (str3.equals("You")) {
                                                this.mline[this.nml] = "You have invited " + this.mname[i] + " to join your clan:";
                                            } else {
                                                this.mline[this.nml] = "" + str3 + " has invited you to join clan:";
                                            }
                                            this.mctimes[this.nml] = getLvalue(str, 3);
                                            this.mtimes[this.nml] = "";
                                            this.nml++;
                                            this.mline[this.nml] = getSvalue(str, 4);
                                            if (this.nclns < 20) {
                                                this.clanlo[this.nclns] = this.mline[this.nml];
                                                this.nclns++;
                                            }
                                            this.mlinetyp[this.nml] = 30;
                                            this.nml++;
                                            this.mline[this.nml] = "";
                                            this.mlinetyp[this.nml] = 167;
                                            this.nml++;
                                            if (!str3.equals("You")) {
                                                if (this.xt.clan.equals("")) {
                                                    this.mline[this.nml] = "(If you would like join this clan, visit that clan's page and click 'Request to Join..'.)";
                                                } else {
                                                    this.mline[this.nml] = "(You will need to leave your clan " + this.xt.clan + " first before being able to join...)";
                                                }
                                                this.mlinetyp[this.nml] = -1;
                                                this.nml++;
                                            }
                                        }
                                        if (k == 4) {
                                            if (str3.equals("You")) {
                                                this.mline[this.nml] = "You have shared the following date:";
                                            } else {
                                                this.mline[this.nml] = "" + str3 + " has shared the following date:";
                                            }
                                            this.mctimes[this.nml] = getLvalue(str, 3);
                                            this.mtimes[this.nml] = "";
                                            Calendar calendar = Calendar.getInstance();
                                            long l = calendar.getTimeInMillis() - this.ntime - this.mctimes[this.nml] + getLvalue(str, 4);
                                            if (l > 0L) calendar.setTimeInMillis(l);
                                            this.nml++;
                                            int m = calendar.get(11);
                                            String str4 = "AM";
                                            if (calendar.get(12) > 30 && ++m == 24) m -= 24;
                                            if (m >= 12) str4 = "PM";
                                            if (m > 12) m -= 12;
                                            if (m == 0) m = 12;
                                            try {
                                                this.mline[this.nml] = "[  " + this.wday[calendar.get(7) - 1] + "  -  " + this.month[calendar.get(2)] + " " + calendar.get(5) + ",  " + m + " " + str4 + "  ]";
                                            } catch (Exception exception) {
                                                this.mline[this.nml] = "Error occurred while calculating this date.";
                                            }
                                            this.mlinetyp[this.nml] = -1;
                                            this.nml++;
                                            this.mline[this.nml] = "(Please make sure your computer's calendar/clock is adjusted correctly, to read this date in your local time.)";
                                            this.mlinetyp[this.nml] = -1;
                                            this.nml++;
                                        }
                                        continue;
                                    }
                                    this.mline[this.nml] = str;
                                    try {
                                        this.rd.setFont(new Font("Tahoma", 0, 11));
                                        byte b;
                                        String str3;
                                        for (this.ftm = this.rd.getFontMetrics(), b = 0, str3 = ""; b < str.length(); ) {
                                            str3 = str3 + str.charAt(b);
                                            if (this.ftm.stringWidth(str3) > 540) {
                                                if (str3.lastIndexOf(" ") != -1) {
                                                    this.mline[this.nml] = str3.substring(0, str3.lastIndexOf(" "));
                                                    str3 = str3.substring(str3.lastIndexOf(" ") + 1, str3.length());
                                                } else {
                                                    this.mline[this.nml] = str3;
                                                    str3 = "";
                                                }
                                                this.mlinetyp[this.nml] = -1;
                                                this.nml++;
                                            }
                                            b++;
                                        }
                                        this.mline[this.nml] = str3;
                                    } catch (Exception exception) {
                                    }
                                    this.mlinetyp[this.nml] = -1;
                                    this.nml++;
                                }
                                this.readmsg = 2;
                                this.lastsub = "" + this.mctime[i];
                                if (this.mtyp[i] == 1) {
                                    this.mtyp[i] = 0;
                                    try {
                                        this.dout.println("101|10|" + this.xt.nickname + "|" + this.opname + "|");
                                        str2 = this.din.readLine();
                                    } catch (Exception exception) {
                                    }
                                }
                                this.spos4 = 208;
                            } else {
                                this.readmsg = 3;
                            }
                        } catch (Exception exception) {
                            this.readmsg = 4;
                        }
                        if (this.readmsg == 2) for (j = 0; j < this.nml; ) {
                            if ((this.mlinetyp[j] == 0 || this.mlinetyp[j] == 1 || this.mlinetyp[j] == 2 || this.mlinetyp[j] == 3 || this.mlinetyp[j] == 4) && this.mctimes[j] > 0L) {
                                try {
                                    long l = this.ntime - this.mctimes[j];
                                    if (l >= 1000L && l < 60000L) this.mtimes[j] = "seconds ago";
                                    if (l >= 60000L && l < 3600000L) {
                                        int k = (int) (l / 60000L);
                                        String str = "s";
                                        if (k == 1) str = "";
                                        this.mtimes[j] = "" + k + " minute" + str + " ago";
                                    }
                                    if (l >= 3600000L && l < 86400000L) {
                                        int k = (int) (l / 3600000L);
                                        String str = "s";
                                        if (k == 1) str = "";
                                        this.mtimes[j] = "" + k + " hour" + str + " ago";
                                    }
                                    if (l >= 86400000L) {
                                        int k = (int) (l / 86400000L);
                                        String str = "s";
                                        if (k == 1) str = "";
                                        this.mtimes[j] = "" + k + " day" + str + " ago";
                                    }
                                } catch (Exception exception) {
                                    this.mtimes[j] = "";
                                }
                            } else {
                                this.mtimes[j] = "";
                            }
                            j++;
                        }
                    }
                    if (this.sendmsg == 2) {
                        this.gs.mmsg.setText(" ");
                        this.sendmsg = 0;
                    }
                    if (this.openc == 10) {
                        if (this.loaditem == 1) {
                            byte b = 0;
                            String[] arrayOfString = new String[700];
                            try {
                                URL uRL = new URL("http://multiplayer.needformadness.com/cars/lists/" + this.gs.tnick.getText() + ".txt?reqlo=" + (int) (Math.random() * 1000.0D) + "");
                                uRL.openConnection().setConnectTimeout(2000);
                                DataInputStream dataInputStream;
                                for (String str = ""; (str = dataInputStream.readLine()) != null; ) {
                                    str = "" + str.trim();
                                    if (str.startsWith("mycars")) for (boolean bool = true; bool && b < 700; ) {
                                        arrayOfString[b] = getfuncSvalue("mycars", str, b);
                                        if (arrayOfString[b].equals("")) {
                                            bool = false;
                                            continue;
                                        }
                                        b++;
                                    }
                                }
                                dataInputStream.close();
                            } catch (Exception exception) {
                                String str = "" + exception;
                                if (str.indexOf("FileNotFound") != -1) {
                                    b = 0;
                                } else {
                                    b = -1;
                                }
                            }
                            if (b == -1) {
                                this.gs.senditem.removeAll();
                                this.gs.senditem.add(this.rd, "Failed to load your cars, please try again later.");
                                this.loaditem = 0;
                            }
                            if (b == 0) {
                                this.gs.senditem.removeAll();
                                this.gs.senditem.add(this.rd, "You have no added or published cars to load.");
                                this.loaditem = 0;
                            }
                            if (b > 0) {
                                String[] arrayOfString1;
                                byte b1;
                                byte b2;
                                for (arrayOfString1 = new String[700], b1 = 0, b2 = 0; b2 < b; ) {
                                    this.gs.senditem.removeAll();
                                    this.gs.senditem.add(this.rd, "Loading shareable cars,  " + (int) (b2 / b * 100.0F) + " %");
                                    try {
                                        String str3 = "http://multiplayer.needformadness.com/cars/" + arrayOfString[b2] + ".txt?reqlo=" + (int) (Math.random() * 1000.0D) + "";
                                        str3 = str3.replace(' ', '_');
                                        URL uRL = new URL(str3);
                                        uRL.openConnection().setConnectTimeout(2000);
                                        DataInputStream dataInputStream;
                                        for (String str4 = ""; (str4 = dataInputStream.readLine()) != null; ) {
                                            str4 = "" + str4.trim();
                                            if (str4.startsWith("details")) {
                                                String str = getfuncSvalue("details", str4, 0);
                                                int i = getfuncvalue("details", str4, 1);
                                                if (i > 0 || str.toLowerCase().equals(this.gs.tnick.getText().toLowerCase())) {
                                                    arrayOfString1[b1] = arrayOfString[b2];
                                                    b1++;
                                                }
                                            }
                                        }
                                        dataInputStream.close();
                                    } catch (Exception exception) {
                                    }
                                    b2++;
                                }
                                this.gs.senditem.removeAll();
                                if (b1 > 0) {
                                    for (b2 = 0; b2 < b1; ) {
                                        this.gs.senditem.add(this.rd, arrayOfString1[b2]);
                                        b2++;
                                    }
                                    this.loaditem = 10;
                                } else {
                                    this.gs.senditem.add(this.rd, "You have no cars that can be shared.");
                                    this.loaditem = 0;
                                }
                            }
                        }
                        if (this.loaditem == 2) {
                            byte b = 0;
                            String[] arrayOfString = new String[700];
                            try {
                                URL uRL = new URL("http://multiplayer.needformadness.com/tracks/lists/" + this.gs.tnick.getText() + ".txt?reqlo=" + (int) (Math.random() * 1000.0D) + "");
                                uRL.openConnection().setConnectTimeout(2000);
                                DataInputStream dataInputStream;
                                for (String str = ""; (str = dataInputStream.readLine()) != null; ) {
                                    str = "" + str.trim();
                                    if (str.startsWith("mystages")) for (boolean bool = true; bool && b < 700; ) {
                                        arrayOfString[b] = getfuncSvalue("mystages", str, b);
                                        if (arrayOfString[b].equals("")) {
                                            bool = false;
                                            continue;
                                        }
                                        b++;
                                    }
                                }
                                dataInputStream.close();
                            } catch (Exception exception) {
                                String str = "" + exception;
                                if (str.indexOf("FileNotFound") != -1) {
                                    b = 0;
                                } else {
                                    b = -1;
                                }
                            }
                            if (b == -1) {
                                this.gs.senditem.removeAll();
                                this.gs.senditem.add(this.rd, "Failed to load your stages, please try again later.");
                                this.loaditem = 0;
                            }
                            if (b == 0) {
                                this.gs.senditem.removeAll();
                                this.gs.senditem.add(this.rd, "You have no added or published stages to load.");
                                this.loaditem = 0;
                            }
                            if (b > 0) {
                                String[] arrayOfString1;
                                byte b1;
                                byte b2;
                                for (arrayOfString1 = new String[700], b1 = 0, b2 = 0; b2 < b; ) {
                                    this.gs.senditem.removeAll();
                                    this.gs.senditem.add(this.rd, "Loading shareable stages,  " + (int) (b2 / b * 100.0F) + " %");
                                    try {
                                        String str3 = "http://multiplayer.needformadness.com/tracks/" + arrayOfString[b2] + ".txt?reqlo=" + (int) (Math.random() * 1000.0D) + "";
                                        str3 = str3.replace(' ', '_');
                                        URL uRL = new URL(str3);
                                        uRL.openConnection().setConnectTimeout(2000);
                                        DataInputStream dataInputStream;
                                        for (String str4 = ""; (str4 = dataInputStream.readLine()) != null; ) {
                                            str4 = "" + str4.trim();
                                            if (str4.startsWith("details")) {
                                                String str = getfuncSvalue("details", str4, 0);
                                                int i = getfuncvalue("details", str4, 1);
                                                if (i > 0 || str.toLowerCase().equals(this.gs.tnick.getText().toLowerCase())) {
                                                    arrayOfString1[b1] = arrayOfString[b2];
                                                    b1++;
                                                }
                                            }
                                        }
                                        dataInputStream.close();
                                    } catch (Exception exception) {
                                    }
                                    b2++;
                                }
                                this.gs.senditem.removeAll();
                                if (b1 > 0) {
                                    for (b2 = 0; b2 < b1; ) {
                                        this.gs.senditem.add(this.rd, arrayOfString1[b2]);
                                        b2++;
                                    }
                                    this.loaditem = 20;
                                } else {
                                    this.gs.senditem.add(this.rd, "You have no stages that can be shared.");
                                    this.loaditem = 0;
                                }
                            }
                        }
                        if (this.gs.sendtyp.getSelectedIndex() == 3 && !this.xt.clan.equals(""))
                            clanlogopng(this.xt.clan);
                        if (this.sendmsg == 1) try {
                            String str = "#nada#";
                            for (byte b = 0; b < this.nm; ) {
                                if (this.mname[b].equals(this.opname)) {
                                    str = this.mconvo[b];
                                    break;
                                }
                                b++;
                            }
                            str1 = "101|9|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.opname + "|" + str + "|" + this.gs.sendtyp.getSelectedIndex() + "|";
                            if (this.gs.sendtyp.getSelectedIndex() == 0) {
                                String str3;
                                String str4;
                                byte b1;
                                byte b2;
                                for (str3 = this.gs.mmsg.getText().replace("|", ":"), str3 = str3.replaceAll("[\\t\\n\\r]", "|"), str4 = "", b1 = 0, b2 = 0; b1 < str3.length(); ) {
                                    String str5 = "" + str3.charAt(b1);
                                    if (str5.equals("|")) {
                                        b2++;
                                    } else {
                                        b2 = 0;
                                    }
                                    if (b2 <= 1) str4 = str4 + str5;
                                    b1++;
                                }
                                str1 = str1 + "" + str4 + "||";
                            }
                            if (this.gs.sendtyp.getSelectedIndex() == 1 || this.gs.sendtyp.getSelectedIndex() == 2)
                                str1 = str1 + "" + this.gs.senditem.getSelectedItem() + "|";
                            if (this.gs.sendtyp.getSelectedIndex() == 3) str1 = str1 + "" + this.xt.clan + "|";
                            if (this.gs.sendtyp.getSelectedIndex() == 4) {
                                Calendar calendar = Calendar.getInstance();
                                long l = calendar.getTimeInMillis();
                                calendar.roll(5, this.gs.senditem.getSelectedIndex());
                                int i = this.gs.datat.getSelectedIndex() + 12;
                                if (i >= 24) i -= 24;
                                calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), i, 0);
                                l = calendar.getTimeInMillis() - l;
                                str1 = str1 + "" + l + "|";
                            }
                            this.dout.println(str1);
                            str2 = this.din.readLine();
                            if (str2.equals("OK")) {
                                this.sendmsg = 2;
                            } else {
                                this.readmsg = 5;
                                this.sendmsg = 0;
                            }
                        } catch (Exception exception) {
                            this.readmsg = 5;
                            this.sendmsg = 0;
                        }
                    }
                }
                if (this.itab == 1) if (!this.xt.clan.equals("")) {
                    try {
                        str1 = "101|38|" + this.xt.clan + "|" + this.xt.clankey + "|" + this.loadinter + "|";
                        this.dout.println(str1);
                        str2 = this.din.readLine();
                        if (str2.startsWith("INTER")) {
                            this.loadinter = getvalue(str2, 1);
                            DataInputStream dataInputStream = new DataInputStream(this.socket.getInputStream());
                            byte[] arrayOfByte = new byte[this.loadinter];
                            dataInputStream.readFully(arrayOfByte);
                            str2 = this.din.readLine();
                            dataInputStream = new DataInputStream(new ByteArrayInputStream(arrayOfByte));
                            String str = "";
                            this.ni = 0;
                            while ((str = dataInputStream.readLine()) != null && this.ni < 200) {
                                this.iclan[this.ni] = getSvalue(str, 0);
                                this.icheck[this.ni] = getSvalue(str, 1);
                                this.iconvo[this.ni] = getSvalue(str, 2);
                                this.isub[this.ni] = getSvalue(str, 3);
                                this.ictime[this.ni] = getLvalue(str, 4);
                                this.itime[this.ni] = "";
                                this.istat[this.ni] = getSvalue(str, 5);
                                if (this.istat[this.ni].equals("War")) this.iwarn[this.ni] = getSvalue(str, 6);
                                if (this.istat[this.ni].equals("Car Battle") || this.istat[this.ni].equals("Stage Battle")) {
                                    this.iwarn[this.ni] = getSvalue(str, 6);
                                    this.itcar[this.ni] = getSvalue(str, 7);
                                    this.igcar[this.ni] = getSvalue(str, 8);
                                }
                                this.ni++;
                            }
                        } else if (str2.equals("NOINTER")) {
                            this.loadinter = 0;
                        }
                    } catch (Exception exception) {
                        this.loadmsgs = -2;
                    }
                    if (this.loadinter > 0) for (byte b = 0; b < this.ni; ) {
                        if (this.ictime[b] > 0L) {
                            try {
                                long l = this.ntime - this.ictime[b];
                                if (l >= 1000L && l < 60000L) this.itime[b] = "Seconds ago";
                                if (l >= 60000L && l < 3600000L) {
                                    int i = (int) (l / 60000L);
                                    String str = "s";
                                    if (i == 1) str = "";
                                    this.itime[b] = "" + i + " minute" + str + " ago";
                                }
                                if (l >= 3600000L && l < 86400000L) {
                                    int i = (int) (l / 3600000L);
                                    String str = "s";
                                    if (i == 1) str = "";
                                    this.itime[b] = "" + i + " hour" + str + " ago";
                                }
                                if (l >= 86400000L) {
                                    int i = (int) (l / 86400000L);
                                    String str = "s";
                                    if (i == 1) str = "";
                                    this.itime[b] = "" + i + " day" + str + " ago";
                                }
                            } catch (Exception exception) {
                                this.itime[b] = "";
                            }
                        } else {
                            this.itime[b] = "";
                        }
                        b++;
                    }
                    if (this.loadwstat == 0) loadchamps();
                    if (this.openi != 0) {
                        boolean bool = false;
                        byte b = -1;
                        byte b1;
                        for (b1 = 0; b1 < this.ni; ) {
                            if (this.iclan[b1].equals(this.intclan)) {
                                b = b1;
                                break;
                            }
                            b1++;
                        }
                        if (this.readint == 6) try {
                            Thread.sleep(2000L);
                        } catch (InterruptedException interruptedException) {
                        }
                        if (b != -1 && this.readint != 3 && this.readint != 4 && this.readint != 5) {
                            if (!this.lastint.equals("" + this.ictime[b])) {
                                bool = true;
                                this.readint = 1;
                            } else {
                                this.readint = 2;
                            }
                        } else {
                            this.lastint = "";
                            if (this.readint == 1) {
                                this.readint = 0;
                                this.nil = 0;
                            }
                        }
                        if (bool && this.sendint != 1) try {
                            str1 = "101|40|" + this.xt.clan + "|" + this.xt.clankey + "|" + this.iconvo[b] + "|";
                            this.dout.println(str1);
                            str2 = this.din.readLine();
                            if (str2.startsWith("RECIVE")) {
                                if (this.istat[b].equals("Car Battle")) {
                                    this.dispi = 1;
                                    this.dwarn = this.iwarn[b];
                                    this.dtcar = this.itcar[b];
                                    this.dgcar = this.igcar[b];
                                }
                                if (this.istat[b].equals("Stage Battle")) {
                                    this.dispi = 2;
                                    this.dwarn = this.iwarn[b];
                                    this.dtcar = this.itcar[b];
                                    this.dgcar = this.igcar[b];
                                }
                                if (this.istat[b].equals("War")) {
                                    this.dispi = 3;
                                    this.dwarn = this.iwarn[b];
                                }
                                b1 = 0;
                                String[] arrayOfString1 = new String[1000];
                                int[] arrayOfInt = new int[1000];
                                long[] arrayOfLong = new long[1000];
                                String[] arrayOfString2 = new String[1000];
                                if (this.dispi != 0) {
                                    arrayOfString1[b1] = "";
                                    arrayOfInt[b1] = 167;
                                    arrayOfString1[++b1] = "";
                                    arrayOfInt[b1] = 167;
                                    b1++;
                                }
                                int i = getvalue(str2, 1);
                                DataInputStream dataInputStream = new DataInputStream(this.socket.getInputStream());
                                byte[] arrayOfByte = new byte[i];
                                dataInputStream.readFully(arrayOfByte);
                                str2 = this.din.readLine();
                                dataInputStream = new DataInputStream(new ByteArrayInputStream(arrayOfByte));
                                String str = "";
                                while ((str = dataInputStream.readLine()) != null) {
                                    if (str.startsWith("|")) {
                                        if (b1 != 0) {
                                            arrayOfString1[b1] = "";
                                            arrayOfInt[b1] = 167;
                                            b1++;
                                        }
                                        String str3 = getSvalue(str, 1);
                                        if (str3.toLowerCase().equals(this.xt.nickname.toLowerCase())) str3 = "You";
                                        arrayOfInt[b1] = getvalue(str, 2);
                                        int j = arrayOfInt[b1];
                                        if (j == 0) {
                                            arrayOfString1[b1] = "" + str3 + " wrote:";
                                            arrayOfLong[b1] = getLvalue(str, 3);
                                            arrayOfString2[b1] = "";
                                            b1++;
                                        }
                                        if (j == 1) {
                                            if (str3.equals("You")) {
                                                arrayOfString1[b1] = "You have shared the following date:";
                                            } else {
                                                arrayOfString1[b1] = "" + str3 + " has shared the following date:";
                                            }
                                            arrayOfLong[b1] = getLvalue(str, 3);
                                            arrayOfString2[b1] = "";
                                            Calendar calendar = Calendar.getInstance();
                                            long l = calendar.getTimeInMillis() - this.ntime - arrayOfLong[b1] + getLvalue(str, 4);
                                            if (l > 0L) calendar.setTimeInMillis(l);
                                            b1++;
                                            int k = calendar.get(11);
                                            String str4 = "AM";
                                            if (calendar.get(12) > 30 && ++k == 24) k -= 24;
                                            if (k >= 12) str4 = "PM";
                                            if (k > 12) k -= 12;
                                            if (k == 0) k = 12;
                                            try {
                                                arrayOfString1[b1] = "[  " + this.wday[calendar.get(7) - 1] + "  -  " + this.month[calendar.get(2)] + " " + calendar.get(5) + ",  " + k + " " + str4 + "  ]";
                                            } catch (Exception exception) {
                                                arrayOfString1[b1] = "Error occurred while calculating this date.";
                                            }
                                            arrayOfInt[b1] = -1;
                                            arrayOfString1[++b1] = "(Please make sure your computer's calendar/clock is adjusted correctly, to read this date in your local time.)";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                        if (j == 4) if (str3.toLowerCase().equals(this.xt.clan.toLowerCase())) {
                                            arrayOfString1[b1] = "Your clan has declared war on " + this.intclan + ":";
                                            arrayOfLong[b1] = getLvalue(str, 3);
                                            arrayOfString2[b1] = "";
                                            b1++;
                                            arrayOfString1[b1] = "I|" + getSvalue(str, 4) + "|" + getSvalue(str, 5) + "|";
                                            arrayOfInt[b1] = 40;
                                            b1++;
                                            arrayOfString1[b1] = "";
                                            arrayOfInt[b1] = 167;
                                            b1++;
                                            if (this.loadwstat == 1 && !str.endsWith("|out|")) {
                                                int k = -1, m = 0, n = -1, i1 = 0;
                                                int i2;
                                                for (i2 = 0; i2 < this.ncc; ) {
                                                    if (this.xt.clan.toLowerCase().equals(this.conclan[i2].toLowerCase())) {
                                                        m = this.totp[i2];
                                                        k = i2;
                                                    }
                                                    if (this.intclan.toLowerCase().equals(this.conclan[i2].toLowerCase())) {
                                                        i1 = this.totp[i2];
                                                        n = i2;
                                                    }
                                                    i2++;
                                                }
                                                i2 = i1 + 1;
                                                int i3 = m + 1;
                                                if (i3 > i1) i3 = i1;
                                                if (k != -1) for (byte b3 = 0; b3 < this.nvc[k]; ) {
                                                    if (this.intclan.toLowerCase().equals(this.verclan[k][b3].toLowerCase())) {
                                                        i2 -= this.points[k][b3];
                                                        if (i2 < 0) i2 = 0;
                                                        break;
                                                    }
                                                    b3++;
                                                }
                                                arrayOfString1[b1] = "If you win this war, your clan would get:  [ " + i2 + " points ]   &  " + this.intclan + " would lose:  [ " + i3 + " points ]";
                                                arrayOfInt[b1] = -1;
                                                b1++;
                                                i2 = m + 1;
                                                i3 = i1 + 1;
                                                if (i3 > m) i3 = m;
                                                if (n != -1) for (byte b3 = 0; b3 < this.nvc[n]; ) {
                                                    if (this.xt.clan.toLowerCase().equals(this.verclan[n][b3].toLowerCase())) {
                                                        i2 -= this.points[n][b3];
                                                        if (i2 < 0) i2 = 0;
                                                        break;
                                                    }
                                                    b3++;
                                                }
                                                arrayOfString1[b1] = "If you lose this war, your clan would lose:  [ " + i3 + " points ]   &  " + this.intclan + " would get:  [ " + i2 + " points ]";
                                                arrayOfInt[b1] = -1;
                                                b1++;
                                            }
                                            if (!str.endsWith("|out|")) {
                                                arrayOfString1[b1] = "(Waiting for " + this.intclan + " to accept this war declaration and create 5 more games.)";
                                                arrayOfInt[b1] = -1;
                                                b1++;
                                            }
                                        } else {
                                            arrayOfString1[b1] = "" + this.intclan + " has declaring war on your clan:";
                                            arrayOfLong[b1] = getLvalue(str, 3);
                                            arrayOfString2[b1] = "";
                                            b1++;
                                            arrayOfString1[b1] = "Y|" + getSvalue(str, 4) + "|" + getSvalue(str, 5) + "|";
                                            arrayOfInt[b1] = 40;
                                            b1++;
                                            arrayOfString1[b1] = "";
                                            arrayOfInt[b1] = 167;
                                            b1++;
                                            if (this.loadwstat == 1 && !str.endsWith("|out|")) {
                                                int k = -1, m = 0, n = -1, i1 = 0;
                                                int i2;
                                                for (i2 = 0; i2 < this.ncc; ) {
                                                    if (this.xt.clan.toLowerCase().equals(this.conclan[i2].toLowerCase())) {
                                                        m = this.totp[i2];
                                                        k = i2;
                                                    }
                                                    if (this.intclan.toLowerCase().equals(this.conclan[i2].toLowerCase())) {
                                                        i1 = this.totp[i2];
                                                        n = i2;
                                                    }
                                                    i2++;
                                                }
                                                i2 = i1 + 1;
                                                int i3 = m + 1;
                                                if (i3 > i1) i3 = i1;
                                                if (k != -1) for (byte b3 = 0; b3 < this.nvc[k]; ) {
                                                    if (this.intclan.toLowerCase().equals(this.verclan[k][b3].toLowerCase())) {
                                                        i2 -= this.points[k][b3];
                                                        if (i2 < 0) i2 = 0;
                                                        break;
                                                    }
                                                    b3++;
                                                }
                                                arrayOfString1[b1] = "If you win this war, your clan would get:  [ " + i2 + " points ]   &  " + this.intclan + " would lose:  [ " + i3 + " points ]";
                                                arrayOfInt[b1] = -1;
                                                b1++;
                                                i2 = m + 1;
                                                i3 = i1 + 1;
                                                if (i3 > m) i3 = m;
                                                if (n != -1) for (byte b3 = 0; b3 < this.nvc[n]; ) {
                                                    if (this.xt.clan.toLowerCase().equals(this.verclan[n][b3].toLowerCase())) {
                                                        i2 -= this.points[n][b3];
                                                        if (i2 < 0) i2 = 0;
                                                        break;
                                                    }
                                                    b3++;
                                                }
                                                arrayOfString1[b1] = "If you lose this war, your clan would lose:  [ " + i3 + " points ]   &  " + this.intclan + " would get:  [ " + i2 + " points ]";
                                                arrayOfInt[b1] = -1;
                                                b1++;
                                            }
                                            if (!str.endsWith("|out|")) {
                                                arrayOfString1[b1] = "(You accept this war declaration by creating 5 more games to be added to it.)";
                                                arrayOfInt[b1] = -1;
                                                b1++;
                                            }
                                        }
                                        if (j == 3) if (str3.toLowerCase().equals(this.xt.clan.toLowerCase())) {
                                            arrayOfString1[b1] = "Your clan has challenged " + this.intclan + " to a car battle:";
                                            arrayOfLong[b1] = getLvalue(str, 3);
                                            arrayOfString2[b1] = "";
                                            b1++;
                                            arrayOfString1[b1] = "I|" + getSvalue(str, 4) + "|" + getSvalue(str, 5) + "|" + getSvalue(str, 6) + "|" + getSvalue(str, 7) + "|";
                                            arrayOfInt[b1] = 30;
                                            b1++;
                                            arrayOfString1[b1] = "";
                                            arrayOfInt[b1] = 167;
                                            b1++;
                                            arrayOfString1[b1] = "If you win you will take " + this.intclan + "'s car :  [ " + getSvalue(str, 4) + " ]";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                            arrayOfString1[b1] = "If you lose you will give " + this.intclan + " your clan's car :  [ " + getSvalue(str, 5) + " ]";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                            if (!str.endsWith("|out|")) {
                                                arrayOfString1[b1] = "(Waiting for " + this.intclan + " to accept this car battle and create 3 more games.)";
                                                arrayOfInt[b1] = -1;
                                                b1++;
                                            }
                                        } else {
                                            arrayOfString1[b1] = "" + this.intclan + " has challenged your clan to a car battle:";
                                            arrayOfLong[b1] = getLvalue(str, 3);
                                            arrayOfString2[b1] = "";
                                            b1++;
                                            arrayOfString1[b1] = "Y|" + getSvalue(str, 5) + "|" + getSvalue(str, 4) + "|" + getSvalue(str, 6) + "|" + getSvalue(str, 7) + "|";
                                            arrayOfInt[b1] = 30;
                                            b1++;
                                            arrayOfString1[b1] = "";
                                            arrayOfInt[b1] = 167;
                                            b1++;
                                            arrayOfString1[b1] = "If you win you will take " + this.intclan + "'s car :  [ " + getSvalue(str, 5) + " ]";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                            arrayOfString1[b1] = "If you lose you will give " + this.intclan + " your clan's car :  [ " + getSvalue(str, 4) + " ]";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                            if (!str.endsWith("|out|")) {
                                                arrayOfString1[b1] = "(You accept this car battle by creating 3 more games to be added to it.)";
                                                arrayOfInt[b1] = -1;
                                                b1++;
                                            }
                                        }
                                        if (j == 2) if (str3.toLowerCase().equals(this.xt.clan.toLowerCase())) {
                                            arrayOfString1[b1] = "Your clan has challenged " + this.intclan + " to a stage battle:";
                                            arrayOfLong[b1] = getLvalue(str, 3);
                                            arrayOfString2[b1] = "";
                                            b1++;
                                            arrayOfString1[b1] = "I|" + getSvalue(str, 4) + "|" + getSvalue(str, 5) + "|" + getSvalue(str, 6) + "|" + getSvalue(str, 7) + "|";
                                            arrayOfInt[b1] = 20;
                                            b1++;
                                            arrayOfString1[b1] = "";
                                            arrayOfInt[b1] = 167;
                                            b1++;
                                            String str4 = getSvalue(str, 4);
                                            if (str4.length() > 20) str4 = "" + str4.substring(0, 20) + "...";
                                            arrayOfString1[b1] = "If you win you will take " + this.intclan + "'s stage :  [ " + str4 + " ]";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                            str4 = getSvalue(str, 5);
                                            if (str4.length() > 20) str4 = "" + str4.substring(0, 20) + "...";
                                            arrayOfString1[b1] = "If you lose you will give " + this.intclan + " your clan's stage :  [ " + str4 + " ]";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                            if (!str.endsWith("|out|")) {
                                                arrayOfString1[b1] = "(Waiting for " + this.intclan + " to accept this stage battle and create 3 more games.)";
                                                arrayOfInt[b1] = -1;
                                                b1++;
                                            }
                                        } else {
                                            arrayOfString1[b1] = "" + this.intclan + " has challenged your clan to a stage battle:";
                                            arrayOfLong[b1] = getLvalue(str, 3);
                                            arrayOfString2[b1] = "";
                                            b1++;
                                            arrayOfString1[b1] = "Y|" + getSvalue(str, 5) + "|" + getSvalue(str, 4) + "|" + getSvalue(str, 6) + "|" + getSvalue(str, 7) + "|";
                                            arrayOfInt[b1] = 20;
                                            b1++;
                                            arrayOfString1[b1] = "";
                                            arrayOfInt[b1] = 167;
                                            b1++;
                                            String str4 = getSvalue(str, 5);
                                            if (str4.length() > 20) str4 = "" + str4.substring(0, 20) + "...";
                                            arrayOfString1[b1] = "If you win you will take " + this.intclan + "'s stage :  [ " + str4 + " ]";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                            str4 = getSvalue(str, 4);
                                            if (str4.length() > 20) str4 = "" + str4.substring(0, 20) + "...";
                                            arrayOfString1[b1] = "If you lose you will give " + this.intclan + " your clan's stage :  [ " + str4 + " ]";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                            if (!str.endsWith("|out|")) {
                                                arrayOfString1[b1] = "(You accept this stage battle by creating 3 more games to be added to it.)";
                                                arrayOfInt[b1] = -1;
                                                b1++;
                                            }
                                        }
                                        if (j == 5) {
                                            arrayOfString1[b1] = "A stage battle has now started between your clan and " + this.intclan + " !";
                                            arrayOfLong[b1] = getLvalue(str, 3);
                                            arrayOfString2[b1] = "";
                                            arrayOfString1[++b1] = "(See the bar at the top of the page for more details.)";
                                            arrayOfInt[b1] = -1;
                                            arrayOfString1[++b1] = "Arrange to meet " + this.intclan + " at a chosen room in a server on a specific date to play the battle.";
                                            arrayOfInt[b1] = -1;
                                            arrayOfString1[++b1] = "Use the 'Share a Relative Date' option to help you organize a time that is suitable for all.";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                        if (j == 6) {
                                            arrayOfString1[b1] = "A car battle has now started between your clan and " + this.intclan + " !";
                                            arrayOfLong[b1] = getLvalue(str, 3);
                                            arrayOfString2[b1] = "";
                                            arrayOfString1[++b1] = "(See the bar at the top of the page for more details.)";
                                            arrayOfInt[b1] = -1;
                                            arrayOfString1[++b1] = "Arrange to meet " + this.intclan + " at a chosen room in a server on a specific date to play the battle.";
                                            arrayOfInt[b1] = -1;
                                            arrayOfString1[++b1] = "Use the 'Share a Relative Date' option to help you organize a time that is suitable for all.";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                        if (j == 7) {
                                            arrayOfString1[b1] = "A war has now started between your clan and " + this.intclan + " !";
                                            arrayOfLong[b1] = getLvalue(str, 3);
                                            arrayOfString2[b1] = "";
                                            b1++;
                                            if (this.loadwstat == 1) {
                                                int k = -1, m = 0, n = -1, i1 = 0;
                                                int i2;
                                                for (i2 = 0; i2 < this.ncc; ) {
                                                    if (this.xt.clan.toLowerCase().equals(this.conclan[i2].toLowerCase())) {
                                                        m = this.totp[i2];
                                                        k = i2;
                                                    }
                                                    if (this.intclan.toLowerCase().equals(this.conclan[i2].toLowerCase())) {
                                                        i1 = this.totp[i2];
                                                        n = i2;
                                                    }
                                                    i2++;
                                                }
                                                i2 = i1 + 1;
                                                int i3 = m + 1;
                                                if (i3 > i1) i3 = i1;
                                                if (k != -1) for (byte b3 = 0; b3 < this.nvc[k]; ) {
                                                    if (this.intclan.toLowerCase().equals(this.verclan[k][b3].toLowerCase())) {
                                                        i2 -= this.points[k][b3];
                                                        if (i2 < 0) i2 = 0;
                                                        break;
                                                    }
                                                    b3++;
                                                }
                                                arrayOfString1[b1] = "If you win this war, your clan would get:  [ " + i2 + " points ]   &  " + this.intclan + " would lose:  [ " + i3 + " points ]";
                                                arrayOfInt[b1] = -1;
                                                b1++;
                                                i2 = m + 1;
                                                i3 = i1 + 1;
                                                if (i3 > m) i3 = m;
                                                if (n != -1) for (byte b3 = 0; b3 < this.nvc[n]; ) {
                                                    if (this.xt.clan.toLowerCase().equals(this.verclan[n][b3].toLowerCase())) {
                                                        i2 -= this.points[n][b3];
                                                        if (i2 < 0) i2 = 0;
                                                        break;
                                                    }
                                                    b3++;
                                                }
                                                arrayOfString1[b1] = "If you lose this war, your clan would lose:  [ " + i3 + " points ]   &  " + this.intclan + " would get:  [ " + i2 + " points ]";
                                                arrayOfInt[b1] = -1;
                                                b1++;
                                            }
                                            arrayOfString1[b1] = "(See the bar at the top of the page for more details.)";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                            arrayOfString1[b1] = "Arrange to meet " + this.intclan + " at a chosen room in a server on a specific date to play the war.";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                            arrayOfString1[b1] = "Use the 'Share a Relative Date' option to help you organize a time that is suitable for all.";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                        if (j == 8) {
                                            if (str3.toLowerCase().equals(this.xt.clan.toLowerCase())) {
                                                arrayOfString1[b1] = "Your clan has defeated " + this.intclan + " in the war, congratulations!";
                                            } else {
                                                arrayOfString1[b1] = "Your clan has lost the war against " + this.intclan + ".";
                                            }
                                            arrayOfLong[b1] = getLvalue(str, 3);
                                            arrayOfString2[b1] = "";
                                            b1++;
                                            if (str3.toLowerCase().equals(this.xt.clan.toLowerCase())) {
                                                arrayOfString1[b1] = "Your clan won:  [ " + getSvalue(str, 5) + " points ]   &  " + this.intclan + " lost:  [ " + getSvalue(str, 6) + " points ]";
                                            } else {
                                                arrayOfString1[b1] = "Your clan lost:  [ " + getSvalue(str, 6) + " points ]   &  " + this.intclan + " won:  [ " + getSvalue(str, 5) + " points ]";
                                            }
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                            arrayOfString1[b1] = "" + getSvalue(str, 4) + "|";
                                            arrayOfInt[b1] = 80;
                                            b1++;
                                            arrayOfString1[b1] = "";
                                            arrayOfInt[b1] = 167;
                                            b1++;
                                        }
                                        if (j == 9) {
                                            String str4 = "";
                                            if (str3.toLowerCase().equals(this.xt.clan.toLowerCase())) {
                                                arrayOfString1[b1] = "Your clan has defeated " + this.intclan + " in the car battle, congratulations!";
                                                arrayOfLong[b1] = getLvalue(str, 3);
                                                arrayOfString2[b1] = "";
                                                b1++;
                                                arrayOfString1[b1] = "You took " + this.intclan + "'s car :  [ " + getSvalue(str, 5) + " ] !";
                                                arrayOfInt[b1] = -1;
                                                b1++;
                                                str4 = this.xt.clan;
                                            } else {
                                                arrayOfString1[b1] = "Your clan has lost the car battle against " + this.intclan + ".";
                                                arrayOfLong[b1] = getLvalue(str, 3);
                                                arrayOfString2[b1] = "";
                                                b1++;
                                                arrayOfString1[b1] = "" + this.intclan + " took your car :  [ " + getSvalue(str, 5) + " ] !";
                                                arrayOfInt[b1] = -1;
                                                b1++;
                                                str4 = this.intclan;
                                            }
                                            arrayOfString1[b1] = "" + getSvalue(str, 4) + "|" + getSvalue(str, 5) + "|" + str4 + "|";
                                            arrayOfInt[b1] = 90;
                                            b1++;
                                            arrayOfString1[b1] = "";
                                            arrayOfInt[b1] = 167;
                                            b1++;
                                        }
                                        if (j == 10) {
                                            String str4 = "";
                                            if (str3.toLowerCase().equals(this.xt.clan.toLowerCase())) {
                                                arrayOfString1[b1] = "Your clan has defeated " + this.intclan + " in the stage battle, congratulations!";
                                                arrayOfLong[b1] = getLvalue(str, 3);
                                                arrayOfString2[b1] = "";
                                                b1++;
                                                String str5 = getSvalue(str, 5);
                                                if (str5.length() > 20) str5 = "" + str5.substring(0, 20) + "...";
                                                arrayOfString1[b1] = "You took " + this.intclan + "'s stage :  [ " + str5 + " ] !";
                                                arrayOfInt[b1] = -1;
                                                b1++;
                                                str4 = this.xt.clan;
                                            } else {
                                                arrayOfString1[b1] = "Your clan has lost the stage battle against " + this.intclan + ".";
                                                arrayOfLong[b1] = getLvalue(str, 3);
                                                arrayOfString2[b1] = "";
                                                b1++;
                                                String str5 = getSvalue(str, 5);
                                                if (str5.length() > 20) str5 = "" + str5.substring(0, 20) + "...";
                                                arrayOfString1[b1] = "" + this.intclan + " took your stage :  [ " + str5 + " ] !";
                                                arrayOfInt[b1] = -1;
                                                b1++;
                                                str4 = this.intclan;
                                            }
                                            arrayOfString1[b1] = "" + getSvalue(str, 4) + "|" + getSvalue(str, 5) + "|" + str4 + "|";
                                            arrayOfInt[b1] = 100;
                                            b1++;
                                            arrayOfString1[b1] = "";
                                            arrayOfInt[b1] = 167;
                                            b1++;
                                        }
                                        continue;
                                    }
                                    arrayOfString1[b1] = str;
                                    try {
                                        this.rd.setFont(new Font("Tahoma", 0, 11));
                                        byte b3;
                                        String str3;
                                        for (this.ftm = this.rd.getFontMetrics(), b3 = 0, str3 = ""; b3 < str.length(); ) {
                                            str3 = str3 + str.charAt(b3);
                                            if (this.ftm.stringWidth(str3) > 540) {
                                                if (str3.lastIndexOf(" ") != -1) {
                                                    arrayOfString1[b1] = str3.substring(0, str3.lastIndexOf(" "));
                                                    str3 = str3.substring(str3.lastIndexOf(" ") + 1, str3.length());
                                                } else {
                                                    arrayOfString1[b1] = str3;
                                                    str3 = "";
                                                }
                                                arrayOfInt[b1] = -1;
                                                b1++;
                                            }
                                            b3++;
                                        }
                                        arrayOfString1[b1] = str3;
                                    } catch (Exception exception) {
                                    }
                                    arrayOfInt[b1] = -1;
                                    b1++;
                                }
                                for (byte b2 = 0; b2 < b1; ) {
                                    this.iline[b2] = arrayOfString1[b2];
                                    this.ilinetyp[b2] = arrayOfInt[b2];
                                    this.ictimes[b2] = arrayOfLong[b2];
                                    this.itimes[b2] = arrayOfString2[b2];
                                    b2++;
                                }
                                this.nil = b1;
                                this.readint = 2;
                                this.lastint = "" + this.ictime[b];
                                if (this.icheck[b].toLowerCase().indexOf(this.xt.nickname.toLowerCase()) == -1) {
                                    this.icheck[b] = this.icheck[b] + "#" + this.xt.nickname + "#";
                                    try {
                                        this.dout.println("101|41|" + this.xt.nickname + "|" + this.xt.clan + "|" + this.intclan + "|");
                                        str2 = this.din.readLine();
                                    } catch (Exception exception) {
                                    }
                                }
                                this.spos4 = 208;
                            } else {
                                this.readint = 3;
                            }
                        } catch (Exception exception) {
                            this.readint = 4;
                        }
                        if (this.readint == 2) for (b1 = 0; b1 < this.nil; ) {
                            if (this.ilinetyp[b1] >= 0 && this.ilinetyp[b1] != 167 && this.ictimes[b1] > 0L) {
                                try {
                                    long l = this.ntime - this.ictimes[b1];
                                    if (l >= 1000L && l < 60000L) this.itimes[b1] = "seconds ago";
                                    if (l >= 60000L && l < 3600000L) {
                                        int i = (int) (l / 60000L);
                                        String str = "s";
                                        if (i == 1) str = "";
                                        this.itimes[b1] = "" + i + " minute" + str + " ago";
                                    }
                                    if (l >= 3600000L && l < 86400000L) {
                                        int i = (int) (l / 3600000L);
                                        String str = "s";
                                        if (i == 1) str = "";
                                        this.itimes[b1] = "" + i + " hour" + str + " ago";
                                    }
                                    if (l >= 86400000L) {
                                        int i = (int) (l / 86400000L);
                                        String str = "s";
                                        if (i == 1) str = "";
                                        this.itimes[b1] = "" + i + " day" + str + " ago";
                                    }
                                } catch (Exception exception) {
                                    this.itimes[b1] = "";
                                }
                            } else {
                                this.itimes[b1] = "";
                            }
                            b1++;
                        }
                        intclanbgpng(this.intclan);
                    }
                    if (this.sendint == 2) {
                        this.gs.mmsg.setText(" ");
                        this.sendint = 0;
                        if (this.gs.sendtyp.getSelectedIndex() > 1) this.gs.sendtyp.select(0);
                    }
                    if (this.openi == 10) {
                        if (this.viewgame2 == 1) {
                            this.vwscorex = 0;
                            this.vwscorei = 0;
                            String str = "pending_war";
                            if (this.nvgames2 == 2) str = "pending_battle";
                            if (this.nvgames2 == 9) str = "war";
                            if (this.nvgames2 == 5) str = "battle";
                            try {
                                URL uRL = new URL("http://multiplayer.needformadness.com/interact/" + str + "/" + this.viewwar2 + ".txt");
                                uRL.openConnection().setConnectTimeout(2000);
                                String str3 = uRL.openConnection().getContentType();
                                if (str3.equals("text/plain")) {
                                    DataInputStream dataInputStream;
                                    String str4;
                                    byte b;
                                    for (dataInputStream = new DataInputStream(uRL.openStream()), str4 = "", b = 0; (str4 = dataInputStream.readLine()) != null && b < this.nvgames2; ) {
                                        String str5 = getSvalue(str4, 0);
                                        if (str5.startsWith("#")) {
                                            int i = 1;
                                            try {
                                                i = Integer.valueOf(str5.substring(1)).intValue();
                                            } catch (Exception exception) {
                                                i = 1;
                                            }
                                            str5 = "NFM 1  -  Stage " + i + "";
                                            if (i > 10) str5 = "NFM 2  -  Stage " + (i - 10) + "";
                                            if (i > 27) str5 = "NFM Multiplayer  -  Stage " + (i - 27) + "";
                                        }
                                        this.vwstages2[b] = str5;
                                        this.vwlaps2[b] = getvalue(str4, 1);
                                        this.vwcars2[b] = getvalue(str4, 2);
                                        this.vwclass2[b] = getvalue(str4, 3);
                                        this.vwfix2[b] = getvalue(str4, 4);
                                        this.vwinner[b] = getSvalue(str4, 5);
                                        if (this.vwinner[b].toLowerCase().equals(this.xt.clan.toLowerCase()))
                                            this.vwscorex++;
                                        if (this.vwinner[b].toLowerCase().equals(this.intclan.toLowerCase()))
                                            this.vwscorei++;
                                        b++;
                                    }
                                    dataInputStream.close();
                                    if (b != 0) {
                                        this.viewgame2 = 2;
                                    } else {
                                        this.viewgame2 = 4;
                                    }
                                } else {
                                    this.viewgame2 = 3;
                                }
                            } catch (Exception exception) {
                                this.viewgame2 = 4;
                            }
                        }
                        if ((this.gs.sendtyp.getSelectedIndex() == 4 || this.gs.sendtyp.getSelectedIndex() == 5 || this.gs.sendtyp.getSelectedIndex() == 6 || this.gs.sendtyp.getSelectedIndex() == 7) && this.gs.senditem.getSelectedIndex() == 3 && this.isel == 3) {
                            loadiclanstages(this.xt.clan);
                            this.isel = 4;
                        }
                        if (this.gs.sendtyp.getSelectedIndex() == 3 && this.ifas == 0) {
                            loadiclancars(this.intclan);
                            this.ifas = 1;
                        }
                        if (this.gs.sendtyp.getSelectedIndex() == 3 && this.ifas == 2) {
                            loadiclancars(this.xt.clan);
                            this.ifas = 3;
                        }
                        if (this.gs.sendtyp.getSelectedIndex() == 3 && this.gs.senditem.getSelectedIndex() == 3 && this.ifas == 5 && this.isel == 3) {
                            loadiclanstages(this.xt.clan);
                            this.isel = 4;
                        }
                        if (this.gs.sendtyp.getSelectedIndex() == 2 && this.ifas == 0) {
                            loadiclanstages(this.intclan);
                            this.ifas = 1;
                        }
                        if (this.gs.sendtyp.getSelectedIndex() == 2 && this.ifas == 2) {
                            loadiclanstages(this.xt.clan);
                            this.ifas = 3;
                        }
                        if (this.gs.sendtyp.getSelectedIndex() == 2 && this.gs.senditem.getSelectedIndex() == 3 && this.ifas == 5 && this.isel == 3) {
                            loadiclanstages(this.xt.clan);
                            this.isel = 4;
                        }
                        if (this.sendint == 1) try {
                            String str = "#nada#";
                            byte b;
                            for (b = 0; b < this.ni; ) {
                                if (this.iclan[b].equals(this.intclan)) {
                                    str = this.iconvo[b];
                                    break;
                                }
                                b++;
                            }
                            str1 = "101|39|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.xt.clan + "|" + this.xt.clankey + "|" + this.intclan + "|" + str + "|" + this.gs.sendtyp.getSelectedIndex() + "|";
                            if (this.gs.sendtyp.getSelectedIndex() == 0) {
                                String str3;
                                String str4;
                                byte b1;
                                byte b2;
                                for (str3 = this.gs.mmsg.getText().replace("|", ":"), str3 = str3.replaceAll("[\\t\\n\\r]", "|"), str4 = "", b1 = 0, b2 = 0; b1 < str3.length(); ) {
                                    String str5 = "" + str3.charAt(b1);
                                    if (str5.equals("|")) {
                                        b2++;
                                    } else {
                                        b2 = 0;
                                    }
                                    if (b2 <= 1) str4 = str4 + str5;
                                    b1++;
                                }
                                str1 = str1 + "" + str4 + "||";
                            }
                            if (this.gs.sendtyp.getSelectedIndex() == 1) {
                                Calendar calendar = Calendar.getInstance();
                                long l = calendar.getTimeInMillis();
                                calendar.roll(5, this.gs.senditem.getSelectedIndex());
                                int i = this.gs.datat.getSelectedIndex() + 12;
                                if (i >= 24) i -= 24;
                                calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), i, 0);
                                l = calendar.getTimeInMillis() - l;
                                str1 = str1 + "" + l + "|";
                            }
                            if (this.gs.sendtyp.getSelectedIndex() == 2 || this.gs.sendtyp.getSelectedIndex() == 3) {
                                str1 = str1 + "" + this.itake + "|" + this.igive + "|";
                                if (!this.sendwarnum) {
                                    for (b = 0; b < 2; ) {
                                        str1 = str1 + "" + this.wstages[b] + "|" + this.wlaps[b] + "|" + this.wcars[b] + "|" + this.wclass[b] + "|" + this.wfix[b] + "|";
                                        b++;
                                    }
                                } else {
                                    str1 = str1 + "warnum#|" + this.warnum + "|";
                                    this.sendwarnum = false;
                                }
                            }
                            if (this.gs.sendtyp.getSelectedIndex() == 4) if (!this.sendwarnum) {
                                for (b = 0; b < 4; ) {
                                    str1 = str1 + "" + this.wstages[b] + "|" + this.wlaps[b] + "|" + this.wcars[b] + "|" + this.wclass[b] + "|" + this.wfix[b] + "|";
                                    b++;
                                }
                            } else {
                                str1 = str1 + "warnum#|" + this.warnum + "|";
                                this.sendwarnum = false;
                            }
                            if (this.gs.sendtyp.getSelectedIndex() == 5 || this.gs.sendtyp.getSelectedIndex() == 6) {
                                str1 = str1 + "" + this.itake + "|" + this.igive + "|";
                                if (!this.sendwarnum) {
                                    for (str1 = str1 + "" + this.sendwar + "|", b = 0; b < 3; ) {
                                        str1 = str1 + "" + this.wstages[b] + "|" + this.wlaps[b] + "|" + this.wcars[b] + "|" + this.wclass[b] + "|" + this.wfix[b] + "|";
                                        b++;
                                    }
                                } else {
                                    str1 = str1 + "warnum#|" + this.warnum + "|";
                                    this.sendwarnum = false;
                                }
                            }
                            if (this.gs.sendtyp.getSelectedIndex() == 7) if (!this.sendwarnum) {
                                for (str1 = str1 + "" + this.sendwar + "|", b = 0; b < 5; ) {
                                    str1 = str1 + "" + this.wstages[b] + "|" + this.wlaps[b] + "|" + this.wcars[b] + "|" + this.wclass[b] + "|" + this.wfix[b] + "|";
                                    b++;
                                }
                            } else {
                                str1 = str1 + "warnum#|" + this.warnum + "|";
                                this.sendwarnum = false;
                            }
                            this.dout.println(str1);
                            str2 = this.din.readLine();
                            if (str2.equals("OK")) {
                                this.sendint = 2;
                            } else if (str2.equals("SUJ")) {
                                this.itab = 2;
                                this.sendint = 0;
                                this.openi = 0;
                                this.readint = 0;
                            } else if (str2.equals("failfile")) {
                                this.readint = 6;
                                this.sendint = 0;
                                this.gs.mmsg.setText(" ");
                                this.gs.sendtyp.select(0);
                            } else {
                                this.readint = 5;
                                this.sendint = 0;
                            }
                        } catch (Exception exception) {
                            this.readint = 5;
                            this.sendint = 0;
                        }
                    }
                }
                if (this.itab == 2) if (!this.xt.clan.equals("")) {
                    try {
                        str1 = "101|36|" + this.xt.clan + "|" + this.xt.clankey + "|" + this.readclan + "|" + this.xt.nickname + "|";
                        this.dout.println(str1);
                        str2 = this.din.readLine();
                        if (str2.startsWith("RECIVE")) {
                            this.readclan = -3;
                            if (this.loadwstat == 0) loadchamps();
                            int i = getvalue(str2, 1);
                            this.cadmin = getvalue(str2, 2);
                            byte b1 = 0;
                            String[] arrayOfString1 = new String[1000];
                            int[] arrayOfInt = new int[1000];
                            long[] arrayOfLong = new long[1000];
                            String[] arrayOfString2 = new String[1000];
                            arrayOfString1[b1] = "";
                            arrayOfInt[b1] = 167;
                            b1++;
                            DataInputStream dataInputStream = new DataInputStream(this.socket.getInputStream());
                            byte[] arrayOfByte = new byte[i];
                            dataInputStream.readFully(arrayOfByte);
                            str2 = this.din.readLine();
                            dataInputStream = new DataInputStream(new ByteArrayInputStream(arrayOfByte));
                            String str = "";
                            while ((str = dataInputStream.readLine()) != null) {
                                if (str.startsWith("|")) {
                                    arrayOfString1[b1] = "";
                                    arrayOfInt[b1] = 167;
                                    b1++;
                                    String str3 = getSvalue(str, 1);
                                    if (str3.toLowerCase().equals(this.xt.nickname.toLowerCase())) str3 = "You";
                                    arrayOfInt[b1] = getvalue(str, 2);
                                    int j = arrayOfInt[b1];
                                    if (j == 0) {
                                        arrayOfString1[b1] = "" + str3 + " wrote:";
                                        arrayOfLong[b1] = getLvalue(str, 3);
                                        arrayOfString2[b1] = "";
                                        b1++;
                                    }
                                    if (j == 1) {
                                        if (str3.equals("You")) {
                                            arrayOfString1[b1] = "You have shared the following date:";
                                        } else {
                                            arrayOfString1[b1] = "" + str3 + " has shared the following date:";
                                        }
                                        arrayOfLong[b1] = getLvalue(str, 3);
                                        arrayOfString2[b1] = "";
                                        Calendar calendar = Calendar.getInstance();
                                        long l = calendar.getTimeInMillis() - this.ntime - arrayOfLong[b1] + getLvalue(str, 4);
                                        if (l > 0L) calendar.setTimeInMillis(l);
                                        b1++;
                                        int k = calendar.get(11);
                                        String str4 = "AM";
                                        if (calendar.get(12) > 30 && ++k == 24) k -= 24;
                                        if (k >= 12) str4 = "PM";
                                        if (k > 12) k -= 12;
                                        if (k == 0) k = 12;
                                        try {
                                            arrayOfString1[b1] = "[  " + this.wday[calendar.get(7) - 1] + "  -  " + this.month[calendar.get(2)] + " " + calendar.get(5) + ",  " + k + " " + str4 + "  ]";
                                        } catch (Exception exception) {
                                            arrayOfString1[b1] = "Error occurred while calculating this date.";
                                        }
                                        arrayOfInt[b1] = -1;
                                        arrayOfString1[++b1] = "(Please make sure your computer's calendar/clock is adjusted correctly, to read this date in your local time.)";
                                        arrayOfInt[b1] = -1;
                                        b1++;
                                    }
                                    if (j == 2) {
                                        String str4 = getSvalue(str, 4);
                                        if (str3.equals("You")) {
                                            arrayOfString1[b1] = "You have suggested declaring war on [ " + str4 + " ] :";
                                        } else {
                                            arrayOfString1[b1] = "" + str3 + " suggested declaring war on [ " + str4 + " ] :";
                                        }
                                        arrayOfLong[b1] = getLvalue(str, 3);
                                        arrayOfString2[b1] = "";
                                        b1++;
                                        arrayOfString1[b1] = "" + str4 + "|" + getSvalue(str, 5) + "|" + getSvalue(str, 6) + "|";
                                        arrayOfInt[b1] = 20;
                                        b1++;
                                        arrayOfString1[b1] = "";
                                        arrayOfInt[b1] = 167;
                                        b1++;
                                        if (this.loadwstat == 1 && !str.endsWith("|out|")) {
                                            int k = -1, m = 0, n = -1, i1 = 0;
                                            int i2;
                                            for (i2 = 0; i2 < this.ncc; ) {
                                                if (this.xt.clan.toLowerCase().equals(this.conclan[i2].toLowerCase())) {
                                                    m = this.totp[i2];
                                                    k = i2;
                                                }
                                                if (str4.toLowerCase().equals(this.conclan[i2].toLowerCase())) {
                                                    i1 = this.totp[i2];
                                                    n = i2;
                                                }
                                                i2++;
                                            }
                                            i2 = i1 + 1;
                                            int i3 = m + 1;
                                            if (i3 > i1) i3 = i1;
                                            if (k != -1) for (byte b = 0; b < this.nvc[k]; ) {
                                                if (str4.toLowerCase().equals(this.verclan[k][b].toLowerCase())) {
                                                    i2 -= this.points[k][b];
                                                    if (i2 < 0) i2 = 0;
                                                    break;
                                                }
                                                b++;
                                            }
                                            arrayOfString1[b1] = "If you win this war, your clan would get:  [ " + i2 + " points ]   &  " + str4 + " would lose:  [ " + i3 + " points ]";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                            i2 = m + 1;
                                            i3 = i1 + 1;
                                            if (i3 > m) i3 = m;
                                            if (n != -1) for (byte b = 0; b < this.nvc[n]; ) {
                                                if (this.xt.clan.toLowerCase().equals(this.verclan[n][b].toLowerCase())) {
                                                    i2 -= this.points[n][b];
                                                    if (i2 < 0) i2 = 0;
                                                    break;
                                                }
                                                b++;
                                            }
                                            arrayOfString1[b1] = "If you lose this war, your clan would lose:  [ " + i3 + " points ]   &  " + str4 + " would get:  [ " + i2 + " points ]";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                        if (!str.endsWith("|out|")) {
                                            arrayOfString1[b1] = "(This needs to be approved by the Clan Leader or an Admin to be declared on " + str4 + ".)";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                    }
                                    if (j == 3) {
                                        String str4 = getSvalue(str, 4);
                                        if (str3.equals("You")) {
                                            arrayOfString1[b1] = "You have suggested to car battle with [ " + str4 + " ] :";
                                        } else {
                                            arrayOfString1[b1] = "" + str3 + " suggested to car battle with [ " + str4 + " ] :";
                                        }
                                        arrayOfLong[b1] = getLvalue(str, 3);
                                        arrayOfString2[b1] = "";
                                        b1++;
                                        arrayOfString1[b1] = "" + str4 + "|" + getSvalue(str, 5) + "|" + getSvalue(str, 6) + "|" + getSvalue(str, 7) + "|" + getSvalue(str, 8) + "|";
                                        arrayOfInt[b1] = 30;
                                        b1++;
                                        arrayOfString1[b1] = "";
                                        arrayOfInt[b1] = 167;
                                        b1++;
                                        arrayOfString1[b1] = "If you win you will take " + str4 + "'s car :  [ " + getSvalue(str, 5) + " ]";
                                        arrayOfInt[b1] = -1;
                                        b1++;
                                        arrayOfString1[b1] = "If you lose you will give " + str4 + " your clan's car :  [ " + getSvalue(str, 6) + " ]";
                                        arrayOfInt[b1] = -1;
                                        b1++;
                                        if (!str.endsWith("|out|")) {
                                            arrayOfString1[b1] = "(This needs to be approved by the Clan Leader or an Admin to be sent to " + str4 + ".)";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                    }
                                    if (j == 4) {
                                        String str4 = getSvalue(str, 4);
                                        if (str3.equals("You")) {
                                            arrayOfString1[b1] = "You have suggested to stage battle with [ " + str4 + " ] :";
                                        } else {
                                            arrayOfString1[b1] = "" + str3 + " suggested to stage battle with [ " + str4 + " ] :";
                                        }
                                        arrayOfLong[b1] = getLvalue(str, 3);
                                        arrayOfString2[b1] = "";
                                        b1++;
                                        arrayOfString1[b1] = "" + str4 + "|" + getSvalue(str, 5) + "|" + getSvalue(str, 6) + "|" + getSvalue(str, 7) + "|" + getSvalue(str, 8) + "|";
                                        arrayOfInt[b1] = 40;
                                        b1++;
                                        arrayOfString1[b1] = "";
                                        arrayOfInt[b1] = 167;
                                        b1++;
                                        String str5 = getSvalue(str, 5);
                                        if (str5.length() > 20) str5 = "" + str5.substring(0, 20) + "...";
                                        arrayOfString1[b1] = "If you win you will take " + str4 + "'s stage :  [ " + str5 + " ]";
                                        arrayOfInt[b1] = -1;
                                        b1++;
                                        str5 = getSvalue(str, 6);
                                        if (str5.length() > 20) str5 = "" + str5.substring(0, 20) + "...";
                                        arrayOfString1[b1] = "If you lose you will give " + str4 + " your clan's stage :  [ " + str5 + " ]";
                                        arrayOfInt[b1] = -1;
                                        b1++;
                                        if (!str.endsWith("|out|")) {
                                            arrayOfString1[b1] = "(This needs to be approved by the Clan Leader or an Admin to be sent to " + str4 + ".)";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                    }
                                    if (j == 5) {
                                        String str4 = getSvalue(str, 4);
                                        if (str3.equals("You")) {
                                            arrayOfString1[b1] = "You have suggested accepting to go to war with [ " + str4 + " ] :";
                                        } else {
                                            arrayOfString1[b1] = "" + str3 + " suggested accepting to go to war with [ " + str4 + " ] :";
                                        }
                                        arrayOfLong[b1] = getLvalue(str, 3);
                                        arrayOfString2[b1] = "";
                                        b1++;
                                        arrayOfString1[b1] = "" + str4 + "|" + getSvalue(str, 5) + "|" + getSvalue(str, 6) + "|";
                                        arrayOfInt[b1] = 50;
                                        b1++;
                                        arrayOfString1[b1] = "";
                                        arrayOfInt[b1] = 167;
                                        b1++;
                                        if (this.loadwstat == 1 && !str.endsWith("|out|")) {
                                            int k = -1, m = 0, n = -1, i1 = 0;
                                            int i2;
                                            for (i2 = 0; i2 < this.ncc; ) {
                                                if (this.xt.clan.toLowerCase().equals(this.conclan[i2].toLowerCase())) {
                                                    m = this.totp[i2];
                                                    k = i2;
                                                }
                                                if (str4.toLowerCase().equals(this.conclan[i2].toLowerCase())) {
                                                    i1 = this.totp[i2];
                                                    n = i2;
                                                }
                                                i2++;
                                            }
                                            i2 = i1 + 1;
                                            int i3 = m + 1;
                                            if (i3 > i1) i3 = i1;
                                            if (k != -1) for (byte b = 0; b < this.nvc[k]; ) {
                                                if (str4.toLowerCase().equals(this.verclan[k][b].toLowerCase())) {
                                                    i2 -= this.points[k][b];
                                                    if (i2 < 0) i2 = 0;
                                                    break;
                                                }
                                                b++;
                                            }
                                            arrayOfString1[b1] = "If you win this war, your clan would get:  [ " + i2 + " points ]   &  " + str4 + " would lose:  [ " + i3 + " points ]";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                            i2 = m + 1;
                                            i3 = i1 + 1;
                                            if (i3 > m) i3 = m;
                                            if (n != -1) for (byte b = 0; b < this.nvc[n]; ) {
                                                if (this.xt.clan.toLowerCase().equals(this.verclan[n][b].toLowerCase())) {
                                                    i2 -= this.points[n][b];
                                                    if (i2 < 0) i2 = 0;
                                                    break;
                                                }
                                                b++;
                                            }
                                            arrayOfString1[b1] = "If you lose this war, your clan would lose:  [ " + i3 + " points ]   &  " + str4 + " would get:  [ " + i2 + " points ]";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                        if (!str.endsWith("|out|")) {
                                            arrayOfString1[b1] = "(This needs to be approved by the Clan Leader or an Admin to be declared on " + str4 + ".)";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                    }
                                    if (j == 6) {
                                        String str4 = getSvalue(str, 4);
                                        if (str3.equals("You")) {
                                            arrayOfString1[b1] = "You have suggested accepting to car battle with [ " + str4 + " ] :";
                                        } else {
                                            arrayOfString1[b1] = "" + str3 + " suggested accepting to car battle with [ " + str4 + " ] :";
                                        }
                                        arrayOfLong[b1] = getLvalue(str, 3);
                                        arrayOfString2[b1] = "";
                                        b1++;
                                        arrayOfString1[b1] = "" + str4 + "|" + getSvalue(str, 5) + "|" + getSvalue(str, 6) + "|" + getSvalue(str, 7) + "|" + getSvalue(str, 8) + "|";
                                        arrayOfInt[b1] = 60;
                                        b1++;
                                        arrayOfString1[b1] = "";
                                        arrayOfInt[b1] = 167;
                                        b1++;
                                        arrayOfString1[b1] = "If you win you will take " + str4 + "'s car :  [ " + getSvalue(str, 5) + " ]";
                                        arrayOfInt[b1] = -1;
                                        b1++;
                                        arrayOfString1[b1] = "If you lose you will give " + str4 + " your clan's car :  [ " + getSvalue(str, 6) + " ]";
                                        arrayOfInt[b1] = -1;
                                        b1++;
                                        if (!str.endsWith("|out|")) {
                                            arrayOfString1[b1] = "(This needs to be approved by the Clan Leader or an Admin to be sent to " + str4 + ".)";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                    }
                                    if (j == 7) {
                                        String str4 = getSvalue(str, 4);
                                        if (str3.equals("You")) {
                                            arrayOfString1[b1] = "You have suggested accepting to stage battle with [ " + str4 + " ] :";
                                        } else {
                                            arrayOfString1[b1] = "" + str3 + " suggested accepting to stage battle with [ " + str4 + " ] :";
                                        }
                                        arrayOfLong[b1] = getLvalue(str, 3);
                                        arrayOfString2[b1] = "";
                                        b1++;
                                        arrayOfString1[b1] = "" + str4 + "|" + getSvalue(str, 5) + "|" + getSvalue(str, 6) + "|" + getSvalue(str, 7) + "|" + getSvalue(str, 8) + "|";
                                        arrayOfInt[b1] = 70;
                                        b1++;
                                        arrayOfString1[b1] = "";
                                        arrayOfInt[b1] = 167;
                                        b1++;
                                        String str5 = getSvalue(str, 5);
                                        if (str5.length() > 20) str5 = "" + str5.substring(0, 20) + "...";
                                        arrayOfString1[b1] = "If you win you will take " + str4 + "'s stage :  [ " + str5 + " ]";
                                        arrayOfInt[b1] = -1;
                                        b1++;
                                        str5 = getSvalue(str, 6);
                                        if (str5.length() > 20) str5 = "" + str5.substring(0, 20) + "...";
                                        arrayOfString1[b1] = "If you lose you will give " + str4 + " your clan's stage :  [ " + str5 + " ]";
                                        arrayOfInt[b1] = -1;
                                        b1++;
                                        if (!str.endsWith("|out|")) {
                                            arrayOfString1[b1] = "(This needs to be approved by the Clan Leader or an Admin to be sent to " + str4 + ".)";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                    }
                                    if (j == 8) {
                                        int k = getvalue(str, 4);
                                        String str4 = "taken";
                                        if (k == 2) str4 = "re-claimed";
                                        arrayOfString1[b1] = "Congratulations!!  Your clan has " + str4 + " the clan wars world championship title!";
                                        arrayOfLong[b1] = getLvalue(str, 3);
                                        arrayOfString2[b1] = "";
                                        b1++;
                                        if (k == 1) {
                                            arrayOfString1[b1] = "Your recent win in the war against " + getSvalue(str, 6) + " has given you the championship title!";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                        if (k == 2) {
                                            arrayOfString1[b1] = "You have successfully defended your championship title against " + getSvalue(str, 6) + "!";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                        if (k == 3) {
                                            arrayOfString1[b1] = "A recent war between " + getSvalue(str, 5) + " and " + getSvalue(str, 6) + " has resulted in a change of points!";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                        if (k == 4) {
                                            arrayOfString1[b1] = "Clan " + getSvalue(str, 5) + " removed itself from the game which resulted in a change of points, giving you the title!";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                        if (k != 2) {
                                            arrayOfString1[b1] = "" + this.xt.clan + " is now the new champion of the world in Need for Madness!";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        } else {
                                            arrayOfString1[b1] = "" + this.xt.clan + " still remains the champion of the world in Need for Madness!";
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                        arrayOfInt[b1] = 80;
                                        b1++;
                                        arrayOfString1[b1] = "";
                                        arrayOfInt[b1] = 167;
                                        b1++;
                                    }
                                    continue;
                                }
                                arrayOfString1[b1] = str;
                                try {
                                    this.rd.setFont(new Font("Tahoma", 0, 11));
                                    byte b;
                                    String str3;
                                    for (this.ftm = this.rd.getFontMetrics(), b = 0, str3 = ""; b < str.length(); ) {
                                        str3 = str3 + str.charAt(b);
                                        if (this.ftm.stringWidth(str3) > 540) {
                                            if (str3.lastIndexOf(" ") != -1) {
                                                arrayOfString1[b1] = str3.substring(0, str3.lastIndexOf(" "));
                                                str3 = str3.substring(str3.lastIndexOf(" ") + 1, str3.length());
                                            } else {
                                                arrayOfString1[b1] = str3;
                                                str3 = "";
                                            }
                                            arrayOfInt[b1] = -1;
                                            b1++;
                                        }
                                        b++;
                                    }
                                    arrayOfString1[b1] = str3;
                                } catch (Exception exception) {
                                }
                                arrayOfInt[b1] = -1;
                                b1++;
                            }
                            for (byte b2 = 0; b2 < b1; ) {
                                this.cmline[b2] = arrayOfString1[b2];
                                this.cmlinetyp[b2] = arrayOfInt[b2];
                                this.cmctimes[b2] = arrayOfLong[b2];
                                this.cmtimes[b2] = arrayOfString2[b2];
                                b2++;
                            }
                            this.cnml = b1;
                            this.readclan = i;
                            this.spos3 = 219;
                        }
                    } catch (Exception exception) {
                        this.readclan = -1;
                    }
                    if (this.readclan > 0) for (byte b = 0; b < this.cnml; ) {
                        if (this.cmlinetyp[b] >= 0 && this.cmlinetyp[b] != 167 && this.cmctimes[b] > 0L) {
                            try {
                                long l = this.ntime - this.cmctimes[b];
                                if (l >= 1000L && l < 60000L) this.cmtimes[b] = "seconds ago";
                                if (l >= 60000L && l < 3600000L) {
                                    int i = (int) (l / 60000L);
                                    String str = "s";
                                    if (i == 1) str = "";
                                    this.cmtimes[b] = "" + i + " minute" + str + " ago";
                                }
                                if (l >= 3600000L && l < 86400000L) {
                                    int i = (int) (l / 3600000L);
                                    String str = "s";
                                    if (i == 1) str = "";
                                    this.cmtimes[b] = "" + i + " hour" + str + " ago";
                                }
                                if (l >= 86400000L) {
                                    int i = (int) (l / 86400000L);
                                    String str = "s";
                                    if (i == 1) str = "";
                                    this.cmtimes[b] = "" + i + " day" + str + " ago";
                                }
                            } catch (Exception exception) {
                                this.cmtimes[b] = "";
                            }
                        } else {
                            this.cmtimes[b] = "";
                        }
                        b++;
                    }
                    clanlogopng(this.xt.clan);
                    if (this.sendcmsg == 2) {
                        this.gs.mmsg.setText(" ");
                        this.sendcmsg = 0;
                    }
                    if (this.viewgame1 == 1) try {
                        String str3 = "pending_war";
                        if (this.nvgames1 == 2 || this.nvgames1 == 5) str3 = "pending_battle";
                        URL uRL = new URL("http://multiplayer.needformadness.com/interact/" + str3 + "/" + this.viewwar1 + ".txt");
                        uRL.openConnection().setConnectTimeout(2000);
                        String str4 = uRL.openConnection().getContentType();
                        if (str4.equals("text/plain")) {
                            DataInputStream dataInputStream;
                            String str;
                            byte b;
                            for (dataInputStream = new DataInputStream(uRL.openStream()), str = "", b = 0; (str = dataInputStream.readLine()) != null && b < this.nvgames1; ) {
                                String str5 = getSvalue(str, 0);
                                if (str5.startsWith("#")) {
                                    int i = 1;
                                    try {
                                        i = Integer.valueOf(str5.substring(1)).intValue();
                                    } catch (Exception exception) {
                                        i = 1;
                                    }
                                    str5 = "NFM 1  -  Stage " + i + "";
                                    if (i > 10) str5 = "NFM 2  -  Stage " + (i - 10) + "";
                                    if (i > 27)
                                        str5 = "NFM Multiplayer  -  Stage " + (i - 27) + "";
                                }
                                this.vwstages1[b] = str5;
                                this.vwlaps1[b] = getvalue(str, 1);
                                this.vwcars1[b] = getvalue(str, 2);
                                this.vwclass1[b] = getvalue(str, 3);
                                this.vwfix1[b] = getvalue(str, 4);
                                b++;
                            }
                            dataInputStream.close();
                            if (b != 0) {
                                this.viewgame1 = 2;
                            } else {
                                this.viewgame1 = 4;
                            }
                        } else {
                            this.viewgame1 = 3;
                        }
                    } catch (Exception exception) {
                        this.viewgame1 = 4;
                    }
                    if (this.sendcmsg == 1)
                        try {
                            str1 = "101|37|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.xt.clan + "|" + this.xt.clankey + "|" + this.gs.sendtyp.getSelectedIndex() + "|";
                            if (this.gs.sendtyp.getSelectedIndex() == 0) {
                                String str3;
                                String str4;
                                byte b1;
                                byte b2;
                                for (str3 = this.gs.mmsg.getText().replace("|", ":"), str3 = str3.replaceAll("[\\t\\n\\r]", "|"), str4 = "", b1 = 0, b2 = 0; b1 < str3.length(); ) {
                                    String str = "" + str3.charAt(b1);
                                    if (str.equals("|")) {
                                        b2++;
                                    } else {
                                        b2 = 0;
                                    }
                                    if (b2 <= 1)
                                        str4 = str4 + str;
                                    b1++;
                                }
                                str1 = str1 + "" + str4 + "||";
                            }
                            if (this.gs.sendtyp.getSelectedIndex() == 1) {
                                Calendar calendar = Calendar.getInstance();
                                long l = calendar.getTimeInMillis();
                                calendar.roll(5, this.gs.senditem.getSelectedIndex());
                                int i = this.gs.datat.getSelectedIndex() + 12;
                                if (i >= 24)
                                    i -= 24;
                                calendar.set(calendar.get(1), calendar.get(2), calendar.get(5), i, 0);
                                l = calendar.getTimeInMillis() - l;
                                str1 = str1 + "" + l + "|";
                            }
                            this.dout.println(str1);
                            str2 = this.din.readLine();
                            if (str2.equals("OK")) {
                                this.sendcmsg = 2;
                            } else {
                                this.readclan = -2;
                                this.sendcmsg = 0;
                            }
                        } catch (Exception exception) {
                            this.readclan = -2;
                            this.sendcmsg = 0;
                        }
                    loadmyclanbg();
                }
            }
            if (this.lg.nmsgs != 0 || this.lg.nfreq != 0 || this.lg.nconf != 0 || this.lg.ncreq != 0 || !this.lg.clanapv.equals("")) {
                str1 = "101|19|" + this.xt.nickname + "|" + this.xt.nickey + "|";
                try {
                    this.dout.println(str1);
                    str2 = this.din.readLine();
                } catch (Exception exception) {
                }
                this.lg.nmsgs = 0;
                this.lg.nfreq = 0;
                this.lg.nconf = 0;
                this.lg.ncreq = 0;
                this.lg.clanapv = "";
            }
            if (this.tab == 0 && this.domon) {
                str1 = "101|101|" + this.updatec + "|";
                if (this.updatec <= -11) {
                    for (byte b = 0; b < -this.updatec - 10; ) {
                        str1 = str1 + "" + this.cnames[20 - b] + "|" + this.sentn[20 - b] + "|";
                        b++;
                    }
                    this.updatec = -2;
                }
                try {
                    this.dout.println(str1);
                    str2 = this.din.readLine();
                    if (str2 == null)
                        this.domon = false;
                } catch (Exception exception) {
                    this.domon = false;
                }
                if (this.domon) {
                    int i = getvalue(str2, 0);
                    if (this.updatec != i && this.updatec >= -2) {
                        for (byte b1 = 0; b1 < 21; ) {
                            this.cnames[b1] = getSvalue(str2, 1 + b1 * 3);
                            this.sentn[b1] = getSvalue(str2, 2 + b1 * 3);
                            this.nctime[b1] = getLvalue(str2, 3 + b1 * 3);
                            b1++;
                        }
                        this.updatec = i;
                    }
                    for (byte b = 0; b < 21; b++) {
                        if (this.nctime[b] > 0L) {
                            long l = this.ntime - this.nctime[b];
                            if (l < 1000L)
                                this.ctime[b] = "- just now";
                            if (l >= 1000L && l < 60000L)
                                this.ctime[b] = "- seconds ago";
                            if (l >= 60000L && l < 3600000L) {
                                int j = (int) (l / 60000L);
                                String str = "s";
                                if (j == 1)
                                    str = "";
                                this.ctime[b] = "- " + j + " minute" + str + " ago";
                            }
                            if (l >= 3600000L && l < 86400000L) {
                                int j = (int) (l / 3600000L);
                                String str = "s";
                                if (j == 1)
                                    str = "";
                                this.ctime[b] = "- " + j + " hour" + str + " ago";
                            }
                            if (l >= 86400000L) {
                                int j = (int) (l / 86400000L);
                                String str = "s";
                                if (j == 1)
                                    str = "";
                                this.ctime[b] = "- " + j + " day" + str + " ago";
                            }
                        } else {
                            this.ctime[b] = "";
                        }
                    }
                }
            }
            if (this.tab == 1) {
                if (this.upload == 5) {
                    this.upload = 0;
                    this.loadedp = false;
                    this.edit = 0;
                    this.refresh = true;
                }
                if (!this.loadedp) {
                    if (!this.refresh) {
                        loadproinfo();
                        trunsent();
                    }
                    logopng();
                    avatarpng();
                    clanlogopng(this.proclan);
                    this.refresh = false;
                    this.protab = 0;
                    this.loadedp = true;
                }
                if (this.protab == 2) {
                    if (this.loadpst == 0)
                        loadprostages();
                    if (this.loadpst == 1 && !this.gs.proitem.getSelectedItem().equals(this.loadpstage) && this.gs.proitem.sel != 0) {
                        this.addstage = 0;
                        if (this.gs.loadstagePreview(-2, this.gs.proitem.getSelectedItem(), this.co, this.bco, this.m, this.cp)) {
                            this.loadedpstage = true;
                            this.m.hit = 20000;
                            this.m.fallen = 0;
                        } else {
                            this.loadedpstage = false;
                        }
                        this.loadpstage = this.gs.proitem.getSelectedItem();
                    }
                }
            }
            if (this.ptab == 2 && !this.xt.clan.equals("") && !this.loadedcm) {
                loadfclan();
                this.loadedcm = true;
            }
            if (this.tab == 3) {
                if (this.cfase == 0) {
                    if (!this.xt.clan.equals(""))
                        clanlogopng(this.xt.clan);
                    if (this.ntab == 0 && this.loadednews == 0)
                        loadnews();
                    if (this.ntab == 1 && this.loadwstat == 0)
                        loadchamps();
                }
                if (this.cfase == 1)
                    if (this.em == 1) {
                        String str = this.gs.temail.getText();
                        str1 = "101|26|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + str + "|";
                        try {
                            this.dout.println(str1);
                            str2 = this.din.readLine();
                        } catch (Exception exception) {
                            str2 = "fail";
                        }
                        if (str2.startsWith("OK")) {
                            this.xt.clan = str;
                            this.xt.clankey = getSvalue(str2, 1);
                            this.spos5 = 0;
                            this.lspos5 = 0;
                            this.cfase = 3;
                            this.claname = str;
                            this.loadedc = false;
                            this.ctab = 0;
                            this.em = 0;
                        } else if (str2.equals("FOUND")) {
                            this.msg = "The name '" + str + "' is already used by another clan!";
                            this.flko = 45;
                            this.em = 0;
                        } else {
                            this.msg = "Server error authorizing clan creation, please try again later...";
                            this.flko = 45;
                            this.em = 0;
                        }
                    }
                if (this.cfase == 2) {
                    if (this.em == 1) {
                        str1 = "101|27|";
                        try {
                            this.dout.println(str1);
                            str2 = this.din.readLine();
                        } catch (Exception exception) {
                            str2 = "";
                        }
                        this.nclns = 0;
                        String str = getSvalue(str2, this.nclns);
                        while (!str.equals("") && this.nclns < 20) {
                            this.clanlo[this.nclns] = str;
                            this.nclns++;
                            str = getSvalue(str2, this.nclns);
                        }
                        if (this.nclns != 0) {
                            this.smsg = "Clans with recent activity:";
                        } else {
                            this.smsg = "Found no clans with recent activity.";
                        }
                        this.em = 0;
                    }
                    if (this.em == 2) {
                        str1 = "101|28|" + this.gs.temail.getText() + "";
                        try {
                            this.dout.println(str1);
                            str2 = this.din.readLine();
                        } catch (Exception exception) {
                            str2 = "";
                        }
                        this.nclns = 0;
                        String str = getSvalue(str2, this.nclns);
                        while (!str.equals("") && this.nclns < 20) {
                            this.clanlo[this.nclns] = str;
                            this.nclns++;
                            str = getSvalue(str2, this.nclns);
                        }
                        if (this.nclns != 0) {
                            this.smsg = "Search result for '" + this.gs.temail.getText() + "' in clans:";
                        } else {
                            this.smsg = "Found no clans with the phrase '" + this.gs.temail.getText() + "' in them.";
                        }
                        this.em = 0;
                    }
                }
                if (this.cfase == 3) {
                    if (this.editc == 33) {
                        str1 = "101|24|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|" + this.member[this.em] + "|" + (this.gs.clanlev.getSelectedIndex() + 1) + "|" + this.gs.cmsg.getText() + "|";
                        try {
                            this.dout.println(str1);
                            str2 = this.din.readLine();
                        } catch (Exception exception) {
                            str2 = "fail";
                        }
                        if (str2.equals("OK")) {
                            this.editc = 0;
                            this.loadedc = false;
                        } else {
                            this.editc = 5;
                        }
                    }
                    if (this.editc == 66) {
                        str1 = "101|24|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|" + this.rmember[this.em] + "|1|New member - just approved.|";
                        try {
                            this.dout.println(str1);
                            str2 = this.din.readLine();
                        } catch (Exception exception) {
                            str2 = "fail";
                        }
                        if (str2.equals("OK")) {
                            this.editc = 0;
                            if (this.nrmb == 1) {
                                this.spos5 = 0;
                                this.lspos5 = 0;
                            }
                            this.loadedc = false;
                        } else {
                            this.editc = 5;
                        }
                    }
                    if (this.editc == 44) {
                        str1 = "101|25|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|" + this.member[this.em] + "|";
                        try {
                            this.dout.println(str1);
                            str2 = this.din.readLine();
                        } catch (Exception exception) {
                            str2 = "fail";
                        }
                        if (str2.equals("OK")) {
                            this.editc = 0;
                            this.loadedc = false;
                            if (this.member[this.em].toLowerCase().equals(this.xt.nickname.toLowerCase())) {
                                if (this.proname.equals(this.xt.nickname))
                                    this.proclan = "";
                                this.xt.clan = "";
                                this.xt.clankey = "";
                                if (this.nmb == 1)
                                    this.cfase = 0;
                            }
                        } else {
                            this.editc = 5;
                        }
                    }
                    if (this.editc == 77) {
                        str1 = "101|25|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|" + this.rmember[this.em] + "|";
                        try {
                            this.dout.println(str1);
                            str2 = this.din.readLine();
                        } catch (Exception exception) {
                            str2 = "fail";
                        }
                        if (str2.equals("OK")) {
                            this.editc = 0;
                            if (this.nrmb == 1) {
                                this.spos5 = 0;
                                this.lspos5 = 0;
                            }
                            this.loadedc = false;
                        } else {
                            this.editc = 5;
                        }
                    }
                    if (this.editc == 99) {
                        str1 = "101|30|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|";
                        try {
                            this.dout.println(str1);
                            str2 = this.din.readLine();
                        } catch (Exception exception) {
                            str2 = "fail";
                        }
                        if (str2.equals("OK")) {
                            this.editc = 0;
                            this.loadedc = false;
                        } else {
                            this.editc = 5;
                        }
                    }
                    if (this.upload == 5) {
                        this.upload = 0;
                        this.loadedc = false;
                        if (this.editc == 2)
                            this.loadedmyclanbg = -1;
                        this.editc = 0;
                        this.refresh = true;
                    }
                    if (!this.loadedc) {
                        if (!this.refresh)
                            loadclan();
                        clanlogopng(this.claname);
                        clanbgpng();
                        this.refresh = false;
                        this.loadedc = true;
                    }
                    if (this.attachetoclan) {
                        str1 = "101|29|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|";
                        try {
                            this.dout.println(str1);
                            str2 = this.din.readLine();
                        } catch (Exception exception) {
                            str2 = "fail";
                        }
                        if (str2.indexOf("|") != -1) {
                            this.xt.clan = getSvalue(str2, 0);
                            this.xt.clankey = getSvalue(str2, 1);
                        }
                        this.attachetoclan = false;
                    }
                    if (this.editc == 55) {
                        str1 = "101|31|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|" + this.sltit + "|" + this.gs.cmsg.getText() + "|" + this.gs.temail.getText() + "|";
                        try {
                            this.dout.println(str1);
                            str2 = this.din.readLine();
                        } catch (Exception exception) {
                            str2 = "fail";
                        }
                        if (str2.equals("OK")) {
                            this.editc = 0;
                            this.loadedlink = false;
                        } else {
                            this.editc = 5;
                        }
                    }
                    if (this.ctab == 2) {
                        if (this.loadedcars == 6) {
                            str1 = "101|32|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|" + this.selcar + "|";
                            try {
                                this.dout.println(str1);
                                str2 = this.din.readLine();
                            } catch (Exception exception) {
                                str2 = "fail";
                            }
                            if (str2.equals("OK")) {
                                this.loadedcars = -1;
                            } else {
                                this.loadedcars = 7;
                            }
                        }
                        if (this.loadedcars == 8) {
                            str1 = "101|33|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|" + this.selcar + "|";
                            try {
                                this.dout.println(str1);
                                str2 = this.din.readLine();
                            } catch (Exception exception) {
                                str2 = "fail";
                            }
                            if (str2.equals("OK")) {
                                this.loadedcars = -1;
                            } else {
                                this.loadedcars = 9;
                            }
                        }
                        if (this.loadedcars == -1)
                            this.loadedcars = loadclancars();
                        if (this.loadedcars == 1 && !this.selcar.equals("Select Car") && this.loadedcar == 0) {
                            if (this.xt.sc[0] != 36 || this.xt.clan.toLowerCase().equals(this.claname.toLowerCase())) {
                                this.cd.haltload = 1;
                            } else {
                                this.cd.haltload = 2;
                            }
                            while (this.cd.haltload == this.cd.onloadingcar) ;
                            this.loadedcar = this.cd.loadonlinecar(this.selcar, 35 + this.cd.haltload);
                            if (this.xt.sc[0] == 36 && this.cd.haltload == 1 && this.loadedcar > 0) {
                                boolean bool;
                                byte b;
                                for (bool = false, b = 0; b < (this.bco[36]).npl && !bool; ) {
                                    if (((this.bco[36]).p[b]).colnum == 1) {
                                        float[] arrayOfFloat = new float[3];
                                        Color.RGBtoHSB(((this.bco[36]).p[b]).c[0], ((this.bco[36]).p[b]).c[1], ((this.bco[36]).p[b]).c[2], arrayOfFloat);
                                        this.xt.arnp[0] = arrayOfFloat[0];
                                        this.xt.arnp[1] = arrayOfFloat[1];
                                        this.xt.arnp[2] = 1.0F - arrayOfFloat[2];
                                        bool = true;
                                    }
                                    b++;
                                }
                                for (bool = false, b = 0; b < (this.bco[36]).npl && !bool; ) {
                                    if (((this.bco[36]).p[b]).colnum == 2) {
                                        float[] arrayOfFloat = new float[3];
                                        Color.RGBtoHSB(((this.bco[36]).p[b]).c[0], ((this.bco[36]).p[b]).c[1], ((this.bco[36]).p[b]).c[2], arrayOfFloat);
                                        this.xt.arnp[3] = arrayOfFloat[0];
                                        this.xt.arnp[4] = arrayOfFloat[1];
                                        this.xt.arnp[5] = 1.0F - arrayOfFloat[2];
                                        bool = true;
                                    }
                                    b++;
                                }
                            }
                        }
                        if (this.loadedcars == 2)
                            this.loadedcars = loadaddcars();
                    }
                    if (this.ctab == 3) {
                        if (this.loadedstages == 6) {
                            str1 = "101|34|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|" + this.selstage + "|";
                            try {
                                this.dout.println(str1);
                                str2 = this.din.readLine();
                            } catch (Exception exception) {
                                str2 = "fail";
                            }
                            if (str2.equals("OK")) {
                                this.loadedstages = -1;
                            } else {
                                this.loadedstages = 7;
                            }
                        }
                        if (this.loadedstages == 8) {
                            str1 = "101|35|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.claname + "|" + this.selstage + "|";
                            try {
                                this.dout.println(str1);
                                str2 = this.din.readLine();
                            } catch (Exception exception) {
                                str2 = "fail";
                            }
                            if (str2.equals("OK")) {
                                this.loadedstages = -1;
                            } else {
                                this.loadedstages = 9;
                            }
                        }
                        if (this.loadedstages == -1)
                            this.loadedstages = loadclanstages();
                        if (this.loadedstages == 1 && !this.selstage.equals("Select Stage") && this.loadedstage == 0) {
                            this.cd.t.nt = 0;
                            if (this.gs.loadstagePreview(-2, this.selstage, this.co, this.bco, this.m, this.cp)) {
                                this.loadedstage = 1;
                                this.m.ptr = 0;
                                this.m.ptcnt = -10;
                                this.m.hit = 45000;
                                this.m.fallen = 0;
                                this.m.nrnd = 0;
                            } else {
                                this.loadedstage = -1;
                            }
                        }
                        if (this.loadedstages == 2)
                            this.loadedstages = loadaddstages();
                    }
                    if (this.ctab == 4 && !this.loadedlink) {
                        loadclanlink();
                        this.loadedlink = true;
                    }
                }
            }
            if (this.upload != 0)
                if (this.filename.toLowerCase().endsWith(".gif") || this.filename.toLowerCase().endsWith(".jpg") || this.filename.toLowerCase().endsWith(".jpeg") || this.filename.toLowerCase().endsWith(".png")) {
                    File file = new File(this.filename);
                    if (file.exists()) {
                        int i = (int) file.length();
                        if (i < 1048576) {
                            if (this.upload != 0) {
                                this.upload = 2;
                                try {
                                    byte b = 2;
                                    if (this.tab == 1 && this.edit == 2)
                                        b = 3;
                                    String str = "";
                                    if (this.tab == 3) {
                                        if (this.editc == 1)
                                            b = 22;
                                        if (this.editc == 2)
                                            b = 23;
                                        str = "" + this.claname + "|";
                                    }
                                    str1 = "101|" + b + "|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + i + "|" + str + "";
                                    this.dout.println(str1);
                                    str2 = this.din.readLine();
                                    if (str2.equals("OK")) {
                                        FileInputStream fileInputStream = new FileInputStream(file);
                                        byte[] arrayOfByte = new byte[i];
                                        fileInputStream.read(arrayOfByte);
                                        fileInputStream.close();
                                        DataOutputStream dataOutputStream = new DataOutputStream(this.socket.getOutputStream());
                                        if (this.upload != 0)
                                            this.upload = 3;
                                        this.perc = 0;
                                        int j = 0;
                                        while (j < i && this.upload != 0) {
                                            int k = 10240;
                                            if (j + k > i)
                                                k = i - j;
                                            dataOutputStream.write(arrayOfByte, j, k);
                                            j += k;
                                            this.perc = (int) (j / i * 100.0F);
                                        }
                                        if (this.upload != 0) {
                                            str2 = this.din.readLine();
                                            if (str2.equals("CR")) {
                                                this.upload = 4;
                                            } else {
                                                this.msg = "Failed to create image online, server error!";
                                                this.flko = 45;
                                                this.upload = 0;
                                            }
                                            str2 = this.din.readLine();
                                            if (str2.equals("OK"))
                                                this.upload = 5;
                                        } else {
                                            try {
                                                this.socket.close();
                                                this.socket = null;
                                                this.din.close();
                                                this.din = null;
                                                this.dout.close();
                                                this.dout = null;
                                                this.connector = null;
                                            } catch (Exception exception) {
                                            }
                                            try {
                                                this.socket = new Socket(this.lg.servers[0], 7061);
                                                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                                                this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                                            } catch (Exception exception) {
                                            }
                                        }
                                    } else {
                                        this.msg = "Failed to authenticate to start an uploading connection!";
                                        this.flko = 45;
                                        this.upload = 0;
                                    }
                                } catch (Exception exception) {
                                    this.msg = "Failed to upload image, unknown error!";
                                    this.flko = 45;
                                    this.upload = 0;
                                    try {
                                        this.socket.close();
                                        this.socket = null;
                                        this.din.close();
                                        this.din = null;
                                        this.dout.close();
                                        this.dout = null;
                                        this.connector = null;
                                    } catch (Exception exception1) {
                                    }
                                    try {
                                        this.socket = new Socket(this.lg.servers[0], 7061);
                                        this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                                        this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                                    } catch (Exception exception1) {
                                    }
                                }
                            }
                        } else {
                            this.msg = "Uploaded image must be less than 1MB in size!";
                            this.flko = 45;
                            this.upload = 0;
                        }
                    } else {
                        this.msg = "The file chosen is invalid or does not exist!";
                        this.flko = 45;
                        this.upload = 0;
                    }
                } else {
                    this.msg = "Uploaded image must be JPEG, GIF or PNG!";
                    this.flko = 45;
                    this.upload = 0;
                }
            if (this.uploadt == 5) {
                this.uploadt = 0;
                this.msg = "";
            }
            if (this.uploadt != 0) {
                File file = new File(this.filename);
                if (file.exists()) {
                    int i = (int) file.length();
                    if (i < 716800) {
                        this.xt.strack = new RadicalMod(this.filename, true);
                        if (this.xt.strack.loaded == 2) {
                            this.trackvol = (int) (220.0F / this.xt.strack.rvol / 3750.0F);
                            this.xt.strack.unload();
                            if (this.uploadt != 0) {
                                this.uploadt = 2;
                                try {
                                    str1 = "101|4|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|" + this.trackname + "|" + this.trackvol + "|" + i + "|";
                                    this.dout.println(str1);
                                    str2 = this.din.readLine();
                                    if (str2.equals("OK")) {
                                        str2 = this.din.readLine();
                                        if (this.uploadt != 0) {
                                            if (str2.equals("UPLOAD")) {
                                                this.uploadt = 3;
                                                FileInputStream fileInputStream = new FileInputStream(file);
                                                byte[] arrayOfByte = new byte[i];
                                                fileInputStream.read(arrayOfByte);
                                                fileInputStream.close();
                                                DataOutputStream dataOutputStream = new DataOutputStream(this.socket.getOutputStream());
                                                dataOutputStream.write(arrayOfByte, 0, i);
                                                this.uploadt = 4;
                                                str2 = this.din.readLine();
                                            }
                                            if (str2.equals("FOUND")) {
                                                this.uploadt = 4;
                                                str2 = this.din.readLine();
                                            }
                                            if (str2.equals("OK")) {
                                                this.themesong = this.trackname;
                                                this.uploadt = 5;
                                            } else if (str2.equals("EXIST")) {
                                                this.msg = "Another track with the same name already exists, please rename you file!";
                                                this.flko = 45;
                                                this.uploadt = 0;
                                            } else {
                                                this.msg = "Failed to add MOD Track to your profile, unknown error!";
                                                this.flko = 45;
                                                this.uploadt = 0;
                                            }
                                        } else {
                                            try {
                                                this.socket.close();
                                                this.socket = null;
                                                this.din.close();
                                                this.din = null;
                                                this.dout.close();
                                                this.dout = null;
                                                this.connector = null;
                                            } catch (Exception exception) {
                                            }
                                            try {
                                                this.socket = new Socket(this.lg.servers[0], 7061);
                                                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                                                this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                                            } catch (Exception exception) {
                                            }
                                        }
                                    } else {
                                        this.msg = "Failed to authenticate to start an uploading connection!";
                                        this.flko = 45;
                                        this.uploadt = 0;
                                    }
                                } catch (Exception exception) {
                                    this.msg = "Failed to upload track, unknown error!";
                                    this.flko = 45;
                                    this.uploadt = 0;
                                    try {
                                        this.socket.close();
                                        this.socket = null;
                                        this.din.close();
                                        this.din = null;
                                        this.dout.close();
                                        this.dout = null;
                                        this.connector = null;
                                    } catch (Exception exception1) {
                                    }
                                    try {
                                        this.socket = new Socket(this.lg.servers[0], 7061);
                                        this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                                        this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                                    } catch (Exception exception1) {
                                    }
                                }
                            }
                        } else {
                            this.xt.strack.unload();
                            this.msg = "The file choosen is not a valid MOD Track!";
                            this.flko = 45;
                            this.uploadt = 0;
                        }
                    } else {
                        this.msg = "Uploaded file must be less than 250KB in size!";
                        this.flko = 45;
                        this.uploadt = 0;
                    }
                } else {
                    this.msg = "The file chosen is invalid or does not exist!";
                    this.flko = 45;
                    this.uploadt = 0;
                }
            }
            if (this.playt == 1) {
                this.xt.strack = new RadicalMod(this.themesong, this.trackvol, 8000, 125, false, true);
                this.xt.strack.play();
                this.playt = 2;
            }
            domelogos();
            try {
                Thread.sleep(600L);
            } catch (InterruptedException interruptedException) {
            }
        }
        onexit();
    }

    public void onexit() {
        onexitpro();
        this.gs.hidefields();
        this.cd.acname = "";
        this.cd.action = 0;
        this.cd.staction = 0;
        this.cd.onstage = "";
        this.addstage = 0;
        this.npf = -1;
        this.editc = 0;
        this.openc = 0;
        this.readmsg = 0;
        this.loadmsgs = -1;
        this.readclan = 0;
        if (this.cd.haltload == 2) {
            this.cd.haltload = 1;
            this.cd.lcardate[1] = 0;
        }
        if (this.cd.haltload == 1)
            if (this.xt.sc[0] == 36) {
                if (!this.xt.clan.toLowerCase().equals(this.claname.toLowerCase()))
                    this.loadedcars = -1;
            } else {
                this.cd.haltload = 0;
                this.cd.lcardate[0] = 0;
            }
        this.m.crs = true;
        this.m.focus_point = 400;
        this.m.x = -335;
        this.m.y = 0;
        this.m.z = -50;
        this.m.xz = 0;
        this.m.zy = 20;
        this.m.ground = -2000;
        try {
            this.socket.close();
            this.socket = null;
            this.din.close();
            this.din = null;
            this.dout.close();
            this.dout = null;
            this.connector = null;
        } catch (Exception exception) {
        }
    }

    public void onexitpro() {
        this.edit = 0;
        this.upload = 0;
        this.uploadt = 0;
        this.sfreq = 0;
        if (this.playt == 2) {
            this.xt.strack.unload();
            this.playt = 0;
        }
        this.protab = 0;
        this.gs.proitem.show = false;
        this.addstage = 0;
    }

    public void stopallnow() {
        if (this.connector != null) {
            this.connector.stop();
            this.connector = null;
        }
        try {
            this.socket.close();
            this.socket = null;
            this.din.close();
            this.din = null;
            this.dout.close();
            this.dout = null;
            this.connector = null;
        } catch (Exception exception) {
        }
    }

    public void trunsent() {
        byte b;
        for (b = 0; b < 3; ) {
            this.aboutxt[b] = "";
            b++;
        }
        if (!this.sentance.equals("")) {
            this.rd.setFont(new Font("Tahoma", 1, 11));
            int i, j, k;
            boolean bool;
            for (this.ftm = this.rd.getFontMetrics(), b = 0, i = 0, j = 0, k = 0, bool = false; i < this.sentance.length(); ) {
                String str = "" + this.sentance.charAt(i);
                if (str.equals(" "))
                    j = i;
                if (b < 3) {
                    this.aboutxt[b] = this.aboutxt[b] + str;
                    if (this.ftm.stringWidth(this.aboutxt[b]) > 276) {
                        if (j != k) {
                            this.aboutxt[b] = this.sentance.substring(k, j);
                            k = i = j;
                        } else if (b == 2) {
                            bool = true;
                        }
                        b++;
                    }
                } else {
                    if (bool)
                        this.aboutxt[2] = this.aboutxt[2].substring(0, this.aboutxt[2].length() - 3);
                    this.aboutxt[2] = this.aboutxt[2] + "...";
                    i = this.sentance.length();
                }
                i++;
            }
        }
        for (this.nab = 0, b = 0; b < 3 && !this.aboutxt[b].equals(""); ) {
            this.aboutxt[b] = this.aboutxt[b].trim();
            this.nab++;
            b++;
        }
    }

    public void roomlogos(String[] paramArrayOfString, int paramInt) {
        for (byte b = 0; b < 2; ) {
            boolean bool = true;
            String str = "";
            for (byte b1 = 0; b1 < paramInt; b1++) {
                bool = false;
                for (byte b2 = 0; b2 < this.nlg; ) {
                    if (paramArrayOfString[b1].toLowerCase().equals(this.logos[b2].toLowerCase())) {
                        bool = true;
                        break;
                    }
                    b2++;
                }
                if (!bool) {
                    str = paramArrayOfString[b1].toLowerCase();
                    break;
                }
            }
            if (!bool) {
                this.logos[this.nlg] = str;
                this.logon[this.nlg] = false;
                try {
                    URL uRL = new URL("http://multiplayer.needformadness.com/profiles/" + this.logos[this.nlg] + "/logo.png");
                    uRL.openConnection().setConnectTimeout(2000);
                    String str1 = uRL.openConnection().getContentType();
                    if (str1.equals("image/png")) {
                        this.logoi[this.nlg] = Toolkit.getDefaultToolkit().createImage(uRL);
                        this.mt.addImage(this.logoi[this.nlg], this.nlg);
                        this.logon[this.nlg] = true;
                    }
                } catch (Exception exception) {
                }
                this.nlg++;
                if (this.nlg == 200)
                    this.nlg = 0;
                b++;
            }
        }
    }

    public Globe(Graphics2D paramGraphics2D, xtGraphics paramxtGraphics, Medium paramMedium, Login paramLogin, CarDefine paramCarDefine, CheckPoints paramCheckPoints, ContO[] paramArrayOfContO1, ContO[] paramArrayOfContO2, GameSparker paramGameSparker) {
        this.bgf = 0.0F;
        this.bgup = false;
        this.bgx = new int[]{0, 670, 1340};
        this.flkn = 0;
        this.cur = 0;
        this.sdist = 0;
        this.scro = 0;
        this.donewc = false;
        this.dosrch = false;
        this.dorank = false;
        this.doweb1 = false;
        this.doweb2 = false;
        this.dommsg = false;
        this.donemsg = false;


        this.doi = 0;
        this.ados = 0;
        this.lspos6w = 0;















































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /* 2934 */
        this.ntime = 0L;
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /* 4570 */
        this.loadwbgames = 0;
        this.warb = 0;
        this.gameturn = -1;
        /* 4571 */
        this.warbnum = "";
        this.vclan = "";
        /* 4572 */
        this.wbstages = new String[10];
        /* 4573 */
        this.wbstage = new int[10];
        /* 4574 */
        this.wblaps = new int[10];
        /* 4575 */
        this.wbcars = new int[10];
        /* 4576 */
        this.wbclass = new int[10];
        /* 4577 */
        this.wbfix = new int[10];
        /* 4578 */
        this.gameturndisp = "";
        /* 4579 */
        this.ascore = 0;
        this.vscore = 0;
        /* 4580 */
        this.lwbwinner = "";
        /* 4581 */
        this.canredo = false;
        this.rd = paramGraphics2D;
        this.xt = paramxtGraphics;
        this.m = paramMedium;
        this.gs = paramGameSparker;
        this.lg = paramLogin;
        this.cd = paramCarDefine;
        this.cp = paramCheckPoints;
        this.bco = paramArrayOfContO1;
        this.co = paramArrayOfContO2;
        this.gImage = this.gs.createImage(560, 300);
        this.rdo = (Graphics2D) this.gImage.getGraphics();
        this.rdo.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        this.rdo.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        byte b;
        for (b = 0; b < 21; ) {
            this.ctime[b] = "";
            this.cnames[b] = "";
            this.sentn[b] = "";
            this.nctime[b] = 0L;
            b++;
        }
        for (b = 0; b < '΄'; ) {
            this.pname[b] = "";
            b++;
        }
        for (b = 0; b < 'È'; ) {
            this.logos[b] = "";
            this.logon[b] = false;
            b++;
        }
        this.mt = new MediaTracker(this.gs);
        this.gs.sendtyp.setBackground(colorb2k(false, 210, 210, 210));
        this.gs.sendtyp.setForeground(new Color(0, 0, 0));
        this.gs.sendtyp.removeAll();
        this.gs.sendtyp.add(this.rd, "Write a Message");
        this.gs.sendtyp.add(this.rd, "Share a Custom Car");
        this.gs.sendtyp.add(this.rd, "Share a Custom Stage");
        this.gs.sendtyp.add(this.rd, "Send a Clan Invitation");
        this.gs.sendtyp.add(this.rd, "Share a Relative Date");
        this.gs.senditem.setBackground(colorb2k(false, 230, 230, 230));
        this.gs.senditem.setForeground(new Color(0, 0, 0));
        this.gs.proitem.setBackground(new Color(206, 171, 98));
        this.gs.proitem.setForeground(new Color(0, 0, 0));
        this.gs.datat.setBackground(colorb2k(false, 230, 230, 230));
        this.gs.datat.setForeground(new Color(0, 0, 0));
        this.gs.mmsg.setBackground(colorb2k(false, 240, 240, 240));
        this.gs.mmsg.setForeground(new Color(0, 0, 0));
        this.gs.clanlev.setBackground(colorb2k(false, 230, 230, 230));
        this.gs.clanlev.setForeground(new Color(0, 0, 0));
        this.gs.clcars.setBackground(new Color(0, 0, 0));
        this.gs.clcars.setForeground(new Color(255, 255, 255));
        this.gs.ilaps.setBackground(colorb2k(false, 220, 220, 220));
        this.gs.ilaps.setForeground(new Color(0, 0, 0));
        this.gs.icars.setBackground(colorb2k(false, 220, 220, 220));
        this.gs.icars.setForeground(new Color(0, 0, 0));
        if (!this.xt.clan.equals("")) this.itab = 2;
    }

    public void domelogos() {
        for (byte b = 0; b < 5; ) {
            boolean bool1 = true;
            boolean bool2 = false;
            String str1 = "", str2 = "";
            if (this.freq == 1) {
                bool1 = false;
                for (byte b1 = 0; b1 < this.nlg; ) {
                    if (this.freqname.toLowerCase().equals(this.logos[b1].toLowerCase())) {
                        bool1 = true;
                        break;
                    }
                    b1++;
                }
                if (!bool1) str1 = this.freqname.toLowerCase();
            }
            if (bool1 && this.loadednews == 1) for (byte b1 = 0; b1 < 4; b1++) {
                if (!this.newplayers[b1].equals("")) {
                    bool1 = false;
                    for (byte b2 = 0; b2 < this.nlg; ) {
                        if (this.newplayers[b1].toLowerCase().equals(this.logos[b2].toLowerCase())) {
                            bool1 = true;
                            break;
                        }
                        b2++;
                    }
                    if (!bool1) {
                        str1 = this.newplayers[b1].toLowerCase();
                        break;
                    }
                }
            }
            if (bool1 && this.loadednews == 1) for (byte b1 = 0; b1 < 5; b1++) {
                if (this.nwarbs[b1] > 0) {
                    bool1 = false;
                    String str = "#" + this.nwclan[b1] + "#";
                    for (byte b2 = 0; b2 < this.nlg; ) {
                        if (str.toLowerCase().equals(this.logos[b2].toLowerCase())) {
                            bool1 = true;
                            break;
                        }
                        b2++;
                    }
                    if (!bool1) {
                        str1 = str.toLowerCase();
                        bool2 = true;
                        str2 = this.nwclan[b1];
                        break;
                    }
                }
            }
            if (bool1 && this.loadwstat == 1) for (byte b1 = 0; b1 < 5; b1++) {
                if (this.ncc > 0) {
                    bool1 = false;
                    String str = "#" + this.conclan[b1] + "#";
                    for (byte b2 = 0; b2 < this.nlg; ) {
                        if (str.toLowerCase().equals(this.logos[b2].toLowerCase())) {
                            bool1 = true;
                            break;
                        }
                        b2++;
                    }
                    if (!bool1) {
                        str1 = str.toLowerCase();
                        bool2 = true;
                        str2 = this.conclan[b1];
                        break;
                    }
                }
            }
            if (bool1 && this.ni > 0) for (byte b1 = 0; b1 < this.ni; b1++) {
                bool1 = false;
                String str = "#" + this.iclan[b1] + "#";
                for (byte b2 = 0; b2 < this.nlg; ) {
                    if (str.toLowerCase().equals(this.logos[b2].toLowerCase())) {
                        bool1 = true;
                        break;
                    }
                    b2++;
                }
                if (!bool1) {
                    str1 = str.toLowerCase();
                    bool2 = true;
                    str2 = this.iclan[b1];
                    break;
                }
            }
            if (bool1 && this.nclns > 0) for (byte b1 = 0; b1 < this.nclns; b1++) {
                bool1 = false;
                String str = "#" + this.clanlo[b1] + "#";
                for (byte b2 = 0; b2 < this.nlg; ) {
                    if (str.toLowerCase().equals(this.logos[b2].toLowerCase())) {
                        bool1 = true;
                        break;
                    }
                    b2++;
                }
                if (!bool1) {
                    str1 = str.toLowerCase();
                    bool2 = true;
                    str2 = this.clanlo[b1];
                    break;
                }
            }
            if (bool1 && this.nrmb > 0 && this.showreqs) for (byte b1 = 0; b1 < this.nrmb; b1++) {
                bool1 = false;
                for (byte b2 = 0; b2 < this.nlg; ) {
                    if (this.rmember[b1].toLowerCase().equals(this.logos[b2].toLowerCase())) {
                        bool1 = true;
                        break;
                    }
                    b2++;
                }
                if (!bool1) {
                    str1 = this.rmember[b1].toLowerCase();
                    break;
                }
            }
            if (bool1 && this.nmb > 0) for (byte b1 = 0; b1 < this.nmb; b1++) {
                bool1 = false;
                for (byte b2 = 0; b2 < this.nlg; ) {
                    if (this.member[b1].toLowerCase().equals(this.logos[b2].toLowerCase())) {
                        bool1 = true;
                        break;
                    }
                    b2++;
                }
                if (!bool1) {
                    str1 = this.member[b1].toLowerCase();
                    break;
                }
            }
            if (bool1 && this.nclns > 0) for (byte b1 = 0; b1 < this.ncln; b1++) {
                bool1 = false;
                for (byte b2 = 0; b2 < this.nlg; ) {
                    if (this.clname[b1].toLowerCase().equals(this.logos[b2].toLowerCase())) {
                        bool1 = true;
                        break;
                    }
                    b2++;
                }
                if (!bool1) {
                    str1 = this.clname[b1].toLowerCase();
                    break;
                }
            }
            if (bool1 && this.npf > 0) for (byte b1 = 0; b1 < this.npf; b1++) {
                bool1 = false;
                for (byte b2 = 0; b2 < this.nlg; ) {
                    if (this.fname[b1].toLowerCase().equals(this.logos[b2].toLowerCase())) {
                        bool1 = true;
                        break;
                    }
                    b2++;
                }
                if (!bool1) {
                    str1 = this.fname[b1].toLowerCase();
                    break;
                }
            }
            if (bool1 && this.nm > 0) for (byte b1 = 0; b1 < this.nm; b1++) {
                bool1 = false;
                for (byte b2 = 0; b2 < this.nlg; ) {
                    if (this.mname[b1].toLowerCase().equals(this.logos[b2].toLowerCase())) {
                        bool1 = true;
                        break;
                    }
                    b2++;
                }
                if (!bool1) {
                    str1 = this.mname[b1].toLowerCase();
                    break;
                }
            }
            if (bool1) for (byte b1 = 0; b1 < this.npo; b1++) {
                bool1 = false;
                for (byte b2 = 0; b2 < this.nlg; ) {
                    if (this.pname[b1].toLowerCase().equals(this.logos[b2].toLowerCase())) {
                        bool1 = true;
                        break;
                    }
                    b2++;
                }
                if (!bool1) {
                    str1 = this.pname[b1].toLowerCase();
                    break;
                }
            }
            if (!bool1) {
                this.logos[this.nlg] = str1;
                this.logon[this.nlg] = false;
                try {
                    String str3 = "http://multiplayer.needformadness.com/profiles/" + this.logos[this.nlg] + "/logo.png";
                    if (bool2) str3 = "http://multiplayer.needformadness.com/clans/" + str2 + "/logo.png";
                    URL uRL = new URL(str3);
                    uRL.openConnection().setConnectTimeout(2000);
                    String str4 = uRL.openConnection().getContentType();
                    if (str4.equals("image/png")) {
                        this.logoi[this.nlg] = Toolkit.getDefaultToolkit().createImage(uRL);
                        this.mt.addImage(this.logoi[this.nlg], this.nlg);
                        this.logon[this.nlg] = true;
                    }
                } catch (Exception exception) {
                }
                this.nlg++;
                if (this.nlg == 200) this.nlg = 0;
                b++;
            }
        }
    }

    public boolean drawl(Graphics2D paramGraphics2D, String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {
        boolean bool = false;
        byte b;
        byte b1;
        for (b = -1, b1 = 0; b1 < this.nlg; ) {
            if (paramString.toLowerCase().equals(this.logos[b1].toLowerCase())) {
                b = b1;
                break;
            }
            b1++;
        }
        if (b != -1) if (this.logon[b]) {
            if (!paramBoolean) paramGraphics2D.setComposite(AlphaComposite.getInstance(3, 0.1F));
            paramGraphics2D.drawImage(this.logoi[b], paramInt1, paramInt2, (ImageObserver) null);
            bool = this.mt.checkID(b);
            if (!paramBoolean) paramGraphics2D.setComposite(AlphaComposite.getInstance(3, 1.0F));
        }
        return bool;
    }

    public void logopng() {
        int i = -1;
        boolean bool = false;
        for (byte b = 0; b < this.nlg; ) {
            if (this.proname.toLowerCase().equals(this.logos[b].toLowerCase())) {
                i = b;
                if (this.logon[i] && !this.refresh) {
                    bool = true;
                    this.logol = true;
                }
                break;
            }
            b++;
        }
        if (!bool) {
            if (i == -1) {
                i = this.nlg;
                this.nlg++;
                if (this.nlg == 200) this.nlg = 0;
            }
            this.logos[i] = this.proname.toLowerCase();
            try {
                String str1 = "";
                if (this.refresh) str1 = "?req=" + (int) (Math.random() * 1000.0D) + "";
                URL uRL = new URL("http://multiplayer.needformadness.com/profiles/" + this.proname + "/logo.png" + str1 + "");
                uRL.openConnection().setConnectTimeout(2000);
                String str2 = uRL.openConnection().getContentType();
                if (str2.equals("image/png")) {
                    this.logoi[i] = Toolkit.getDefaultToolkit().createImage(uRL);
                    this.mt.addImage(this.logoi[i], i);
                    this.logon[i] = true;
                } else {
                    this.logon[i] = false;
                }
            } catch (Exception exception) {
            }
            this.logol = this.logon[i];
        }
    }

    public void clanlogopng(String paramString) {
        int i = -1;
        boolean bool = false;
        String str = "#" + paramString.toLowerCase() + "#";
        for (byte b = 0; b < this.nlg; ) {
            if (str.equals(this.logos[b])) {
                i = b;
                if (this.logon[i] && !this.refresh) bool = true;
                break;
            }
            b++;
        }
        if (!bool) {
            if (i == -1) {
                i = this.nlg;
                this.nlg++;
                if (this.nlg == 200) this.nlg = 0;
            }
            this.logos[i] = str;
            try {
                String str1 = "";
                if (this.refresh) str1 = "?req=" + (int) (Math.random() * 1000.0D) + "";
                URL uRL = new URL("http://multiplayer.needformadness.com/clans/" + paramString + "/logo.png" + str1 + "");
                uRL.openConnection().setConnectTimeout(2000);
                String str2 = uRL.openConnection().getContentType();
                if (str2.equals("image/png")) {
                    this.logoi[i] = Toolkit.getDefaultToolkit().createImage(uRL);
                    this.mt.addImage(this.logoi[i], i);
                    this.logon[i] = true;
                } else {
                    this.logon[i] = false;
                }
            } catch (Exception exception) {
            }
        }
    }

    public void avatarpng() {
        this.avatarl = false;
        String str = "";
        if (this.refresh) str = "?req=" + (int) (Math.random() * 1000.0D) + "";
        try {
            URL uRL = new URL("http://multiplayer.needformadness.com/profiles/" + this.proname + "/avatar.png" + str + "");
            uRL.openConnection().setConnectTimeout(2000);
            String str1 = uRL.openConnection().getContentType();
            if (str1.equals("image/png")) {
                this.avatar = Toolkit.getDefaultToolkit().createImage(uRL);
                this.avatarl = true;
            }
        } catch (Exception exception) {
        }
    }

    /*      */
    public void clanbgpng() {
        this.clanbgl = false;
        String str = "";
        if (this.refresh) str = "?req=" + (int) (Math.random() * 1000.0D) + "";
        try {
            URL uRL = new URL("http://multiplayer.needformadness.com/clans/" + this.claname + "/bg.jpg" + str + "");
            uRL.openConnection().setConnectTimeout(2000);
            String str1 = uRL.openConnection().getContentType();
            if (str1.equals("image/jpeg")) {
                this.clanbg = Toolkit.getDefaultToolkit().createImage(uRL);
                this.clanbgl = true;
            }
        } catch (Exception exception) {
        }
    }

    /*      */
    public void intclanbgpng(String paramString) {
        if (!this.intclanlo.equals(paramString)) {
            this.intclanbgloaded = false;
            try {
                URL uRL = new URL("http://multiplayer.needformadness.com/clans/" + paramString + "/bg.jpg");
                uRL.openConnection().setConnectTimeout(2000);
                String str = uRL.openConnection().getContentType();
                if (str.equals("image/jpeg")) {
                    this.intclanbg = Toolkit.getDefaultToolkit().createImage(uRL);
                    this.intclanbgloaded = true;
                }
            } catch (Exception exception) {
            }
            this.intclanlo = paramString;
        }
    }

    /*      */
    public void loadmyclanbg() {
        if (this.loadedmyclanbg <= 0) {
            String str = "";
            if (this.loadedmyclanbg == -1) str = "?req=" + (int) (Math.random() * 1000.0D) + "";
            this.loadedmyclanbg = 2;
            try {
                URL uRL = new URL("http://multiplayer.needformadness.com/clans/" + this.xt.clan + "/bg.jpg" + str + "");
                uRL.openConnection().setConnectTimeout(2000);
                String str1 = uRL.openConnection().getContentType();
                if (str1.equals("image/jpeg")) {
                    this.myclanbg = Toolkit.getDefaultToolkit().createImage(uRL);
                    this.loadedmyclanbg = 1;
                }
            } catch (Exception exception) {
            }
        }
    }

    /* 4585 */
    public void loadwgames() {
        this.canredo = false;
        /* 4586 */
        this.gameturn = -1;
        /* 4587 */
        this.lwbwinner = "";
        /* 4588 */
        this.ascore = 0;
        this.vscore = 0;
        /* 4589 */
        this.gs.pgame.removeAll();
        this.gs.pgame.add(this.rd, " Select Game");
        /* 4590 */
        byte b = 5;
        String str = "battle";
        this.warb = 2;
        /* 4591 */
        if (this.gs.warb.sopts[this.gs.warb.sel].startsWith(" War with")) {
            b = 9;
            str = "war";
            this.warb = 1;
        }
        /* 4592 */
        if (this.gs.warb.sopts[this.gs.warb.sel].startsWith(" Stage battle with")) this.warb = 3;
        /* 4593 */
        this.warbnum = getSvalue(this.gs.warb.opts[this.gs.warb.sel], 0);
        /* 4594 */
        this.vclan = getSvalue(this.gs.warb.opts[this.gs.warb.sel], 1);
        /*      */
        /*      */
        /* 4597 */
        try {
            URL uRL = new URL("http://multiplayer.needformadness.com/interact/" + str + "/" + this.warbnum + ".txt?req=" + (int) (Math.random() * 1000.0D) + "");
            /* 4598 */
            uRL.openConnection().setConnectTimeout(2000);
            String str1 = uRL.openConnection().getContentType();
            /* 4599 */
            if (str1.equals("text/plain"))
                /*      */
                /* 4601 */ {
                DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
                String str2 = "";
                byte b1 = 0;
                /* 4602 */
                while ((str2 = dataInputStream.readLine()) != null && b1 < b) {
                    /*      */
                    /* 4604 */
                    String str3 = getSvalue(str2, 0);
                    if (str3.startsWith("#")) {
                        int i = 1;
                        try {
                            i = Integer.valueOf(str3.substring(1)).intValue();
                        } catch (Exception exception) {
                            i = 1;
                        }
                        this.wbstage[b1] = i;
                        str3 = "NFM 1 - Stage " + i + "";
                        if (i > 10) str3 = "NFM 2 - Stage " + (i - 10) + "";
                        if (i > 27) str3 = "NFM Multiplayer - Stage " + (i - 27) + "";
                    } else {
                        this.wbstage[b1] = 101;
                    }
                    this.wbstages[b1] = str3;
                    /* 4605 */
                    this.wblaps[b1] = getvalue(str2, 1);
                    /* 4606 */
                    this.wbcars[b1] = getvalue(str2, 2);
                    /* 4607 */
                    this.wbclass[b1] = getvalue(str2, 3);
                    /* 4608 */
                    this.wbfix[b1] = getvalue(str2, 4);
                    /* 4609 */
                    String str4 = getSvalue(str2, 5);
                    /*      */
                    /* 4611 */
                    String str5 = "";
                    if (this.wbcars[b1] == 2) str5 = ",  Clan Cars";
                    if (this.wbcars[b1] == 3) str5 = ",  Game Cars";
                    if (this.wbclass[b1] == 1) str5 = str5 + ",  Class C";
                    if (this.wbclass[b1] == 2) str5 = str5 + ",  Class B & C";
                    if (this.wbclass[b1] == 3) str5 = str5 + ",  Class B";
                    if (this.wbclass[b1] == 4) str5 = str5 + ",  Class A & B";
                    if (this.wbclass[b1] == 5) str5 = str5 + ",  Class A";
                    /* 4612 */
                    String str6 = "";
                    if (this.wbfix[b1] == 1) str6 = ",  4 Fixes";
                    if (this.wbfix[b1] == 2) str6 = ",  3 Fixes";
                    if (this.wbfix[b1] == 3) str6 = ",  2 Fixes";
                    if (this.wbfix[b1] == 4) str6 = ",  1 Fix";
                    if (this.wbfix[b1] == 5) str6 = ",  No Fixing";
                    /* 4613 */
                    this.rd.setFont(new Font("Arial", 1, 12));
                    this.ftm = this.rd.getFontMetrics();
                    /* 4614 */
                    String str7 = this.wbstages[b1];
                    /* 4615 */
                    String str8 = "Game #" + (b1 + 1) + ":  " + str7 + "" + str5 + "" + str6 + ",  " + this.wblaps[b1] + " Laps";
                    /* 4616 */
                    while (this.ftm.stringWidth(str8) > 400) {
                        str7 = str7.substring(0, str7.length() - 1);
                        str8 = "Game #" + (b1 + 1) + ":  " + str7 + "..." + str5 + "" + str6 + ",  " + this.wblaps[b1] + " Laps";
                    }
                    /*      */
                    /* 4618 */
                    if (this.gameturn == -1) if (str4.equals("") || str4.equals("#redo#")) {
                        if (!str4.equals("#redo#") && b1 > 0) this.canredo = true;
                        this.gameturn = b1;
                        this.gameturndisp = str8;
                    } else {
                        if (str4.toLowerCase().equals(this.xt.clan.toLowerCase())) this.ascore++;
                        if (str4.toLowerCase().equals(this.vclan.toLowerCase())) this.vscore++;
                        this.lwbwinner = str4;
                    }
                    /* 4619 */
                    this.gs.pgame.add(this.rd, " " + str8 + "");
                    /* 4620 */
                    b1++;
                    /*      */
                }
                /* 4622 */
                dataInputStream.close();
                /* 4623 */
                if (b1 != 0) {
                    this.loadwbgames = 2;
                } else {
                    this.loadwbgames = 3;
                }
            }
            /* 4624 */
            else {
                this.loadwbgames = 4;
            }
        }
        /* 4625 */ catch (Exception exception) {
            this.loadwbgames = 3;
        }
    }

    public void loadclan() {
        this.notclan = false;
        byte b = 0;
        String[] arrayOfString1 = new String[20];
        int[] arrayOfInt = new int[20];
        String[] arrayOfString2 = new String[20];
        this.showreqs = false;
        this.nrmb = 0;
        try {
            URL uRL = new URL("http://multiplayer.needformadness.com/clans/" + this.claname + "/members.txt?req=" + (int) (Math.random() * 1000.0D) + "");
            uRL.openConnection().setConnectTimeout(2000);
            String str = uRL.openConnection().getContentType();
            if (str.equals("text/plain")) {
                DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
                String str1 = "";
                while ((str1 = dataInputStream.readLine()) != null && b < 20) {
                    str1 = str1.trim();
                    String str2 = getSvalue(str1, 0);
                    if (!str2.equals("")) {
                        int i = getvalue(str1, 1);
                        if (i != 0) {
                            arrayOfString1[b] = str2;
                            arrayOfInt[b] = i;
                            arrayOfString2[b] = getSvalue(str1, 2);
                            b++;
                            continue;
                        }
                        if (this.nrmb < 100) {
                            this.rmember[this.nrmb] = str2;
                            this.nrmb++;
                        }
                    }
                }
                dataInputStream.close();
            } else {
                this.notclan = true;
            }
        } catch (Exception exception) {
        }
        this.nmb = 0;
        if (!this.notclan) {
            byte b1;
            for (b1 = 7; b1 > 0; ) {
                for (byte b2 = 0; b2 < b; ) {
                    if (arrayOfInt[b2] == b1) {
                        this.member[this.nmb] = arrayOfString1[b2];
                        this.mrank[this.nmb] = arrayOfString2[b2];
                        this.mlevel[this.nmb] = arrayOfInt[b2];
                        this.nmb++;
                    }
                    b2++;
                }
                b1--;
            }
            for (b1 = 0; b1 < this.nmb; ) {
                if (this.xt.nickname.toLowerCase().equals(this.member[b1].toLowerCase())) {
                    if ((this.mlevel[b1] == 7 || b1 == 0) && this.nrmb != 0) this.showreqs = true;
                    if (!this.xt.clan.toLowerCase().equals(this.claname.toLowerCase())) this.attachetoclan = true;
                }
                b1++;
            }
            if (this.xt.clan.toLowerCase().equals(this.claname.toLowerCase())) {
                for (b1 = 0; b1 < b; ) {
                    this.clname[b1] = arrayOfString1[b1];
                    b1++;
                }
                this.ncln = b;
                this.loadedcm = true;
            }
        }
    }

    public void loadclanlink() {
        this.ltit = "";
        this.ldes = "";
        this.lurl = "";
        try {
            URL uRL = new URL("http://multiplayer.needformadness.com/clans/" + this.claname + "/link.txt?req=" + (int) (Math.random() * 1000.0D) + "");
            uRL.openConnection().setConnectTimeout(2000);
            String str = uRL.openConnection().getContentType();
            if (str.equals("text/plain")) {
                DataInputStream dataInputStream;
                String str1;
                byte b;
                for (dataInputStream = new DataInputStream(uRL.openStream()), str1 = "", b = 0; (str1 = dataInputStream.readLine()) != null && b < 3; ) {
                    str1 = str1.trim();
                    if (b == 0) this.ltit = str1;
                    if (b == 1) this.ldes = str1;
                    if (b == 2) this.lurl = str1;
                    b++;
                }
                dataInputStream.close();
            }
        } catch (Exception exception) {
            this.ltit = "";
            this.ldes = "";
            this.lurl = "";
        }
    }

    public void loadfclan() {
        this.ncln = 0;
        try {
            URL uRL = new URL("http://multiplayer.needformadness.com/clans/" + this.xt.clan + "/members.txt?req=" + (int) (Math.random() * 1000.0D) + "");
            uRL.openConnection().setConnectTimeout(2000);
            DataInputStream dataInputStream;
            String str;
            for (dataInputStream = new DataInputStream(uRL.openStream()), str = ""; (str = dataInputStream.readLine()) != null && this.ncln < 20; ) {
                str = str.trim();
                String str1 = getSvalue(str, 0);
                if (!str1.equals("") && getvalue(str, 1) != 0) {
                    this.clname[this.ncln] = str1;
                    this.ncln++;
                }
            }
            dataInputStream.close();
        } catch (Exception exception) {
        }
    }

    public int loadclancars() {
        this.m.csky[0] = 170;
        this.m.csky[1] = 220;
        this.m.csky[2] = 255;
        this.m.cfade[0] = 255;
        this.m.cfade[1] = 220;
        this.m.cfade[2] = 220;
        this.m.snap[0] = 0;
        this.m.snap[1] = 0;
        this.m.snap[2] = 0;
        byte b = 0;
        this.gs.clcars.removeAll();
        this.gs.clcars.add(this.rd, "Select Car");
        try {
            URL uRL = new URL("http://multiplayer.needformadness.com/clans/" + this.claname + "/cars.txt?req=" + (int) (Math.random() * 1000.0D) + "");
            uRL.openConnection().setConnectTimeout(2000);
            String str = uRL.openConnection().getContentType();
            if (str.equals("text/plain")) {
                DataInputStream dataInputStream;
                String str1;
                byte b1;
                for (dataInputStream = new DataInputStream(uRL.openStream()), str1 = "", b1 = 0; (str1 = dataInputStream.readLine()) != null && b1 < 'ʼ'; ) {
                    this.gs.clcars.add(this.rd, str1);
                    b1++;
                    if (b != 1) b = 1;
                }
                dataInputStream.close();
            }
        } catch (Exception exception) {
            b = -2;
        }
        if (b == 1) {
            if (this.viewcar.equals("")) {
                this.gs.clcars.select(0);
            } else {
                this.gs.clcars.select(this.viewcar);
                this.viewcar = "";
            }
            this.selcar = this.gs.clcars.getSelectedItem();
        }
        return b;
    }

    public int loadaddcars() {
        byte b = 3;
        byte b1 = 0;
        String[] arrayOfString = new String[700];
        try {
            URL uRL = new URL("http://multiplayer.needformadness.com/cars/lists/" + this.gs.tnick.getText() + ".txt?reqlo=" + (int) (Math.random() * 1000.0D) + "");
            uRL.openConnection().setConnectTimeout(2000);
            DataInputStream dataInputStream;
            String str;
            for (dataInputStream = new DataInputStream(uRL.openStream()), str = ""; (str = dataInputStream.readLine()) != null; ) {
                str = "" + str.trim();
                if (str.startsWith("mycars")) for (boolean bool = true; bool && b1 < 700; ) {
                    arrayOfString[b1] = getfuncSvalue("mycars", str, b1);
                    if (arrayOfString[b1].equals("")) {
                        bool = false;
                        continue;
                    }
                    b1++;
                }
            }
            dataInputStream.close();
        } catch (Exception exception) {
            String str = "" + exception;
            if (str.indexOf("FileNotFound") != -1) {
                b1 = 0;
                b = 3;
            } else {
                b1 = -1;
                b = 4;
            }
        }
        if (b1 > 0) {
            String[] arrayOfString1;
            byte b2;
            byte b3;
            for (arrayOfString1 = new String[700], b2 = 0, b3 = 0; b3 < b1; ) {
                this.perry = "" + (int) (b3 / b1 * 100.0F) + " %";
                try {
                    String str1 = "http://multiplayer.needformadness.com/cars/" + arrayOfString[b3] + ".txt?reqlo=" + (int) (Math.random() * 1000.0D) + "";
                    str1 = str1.replace(' ', '_');
                    URL uRL = new URL(str1);
                    uRL.openConnection().setConnectTimeout(2000);
                    DataInputStream dataInputStream;
                    String str2;
                    for (dataInputStream = new DataInputStream(uRL.openStream()), str2 = ""; (str2 = dataInputStream.readLine()) != null; ) {
                        str2 = "" + str2.trim();
                        if (str2.startsWith("details")) {
                            String str = getfuncSvalue("details", str2, 0);
                            if (str.toLowerCase().equals(this.gs.tnick.getText().toLowerCase()) && str2.indexOf("Clan#") == -1) {
                                arrayOfString1[b2] = arrayOfString[b3];
                                b2++;
                            }
                        }
                    }
                    dataInputStream.close();
                } catch (Exception exception) {
                }
                b3++;
            }
            if (b2 > 0) {
                this.gs.clcars.removeAll();
                for (b3 = 0; b3 < b2; ) {
                    this.gs.clcars.add(this.rd, arrayOfString1[b3]);
                    b3++;
                }
                b = 5;
            } else {
                b = 3;
            }
        }
        return b;
    }

    public void loadiclancars(String paramString) {
        try {
            URL uRL = new URL("http://multiplayer.needformadness.com/clans/" + paramString + "/cars.txt");
            uRL.openConnection().setConnectTimeout(2000);
            String str = uRL.openConnection().getContentType();
            if (str.equals("text/plain")) {
                this.gs.datat.removeAll();
                this.gs.datat.add(this.rd, "Select Car");
                DataInputStream dataInputStream;
                String str1;
                byte b;
                for (dataInputStream = new DataInputStream(uRL.openStream()), str1 = "", b = 0; (str1 = dataInputStream.readLine()) != null && b < 'ʼ'; ) {
                    this.gs.datat.add(this.rd, str1);
                    b++;
                }
                dataInputStream.close();
            } else {
                this.gs.datat.removeAll();
                this.gs.datat.add(this.rd, "No clan cars where found.");
            }
        } catch (Exception exception) {
            this.gs.datat.removeAll();
            this.gs.datat.add(this.rd, "Failed to load cars, try again later...");
        }
        this.gs.datat.select(0);
    }

    public int loadclanstages() {
        byte b = 0;
        this.gs.clcars.removeAll();
        this.gs.clcars.add(this.rd, "Select Stage");
        try {
            URL uRL = new URL("http://multiplayer.needformadness.com/clans/" + this.claname + "/stages.txt?req=" + (int) (Math.random() * 1000.0D) + "");
            uRL.openConnection().setConnectTimeout(2000);
            String str = uRL.openConnection().getContentType();
            if (str.equals("text/plain")) {
                DataInputStream dataInputStream;
                String str1;
                byte b1;
                for (dataInputStream = new DataInputStream(uRL.openStream()), str1 = "", b1 = 0; (str1 = dataInputStream.readLine()) != null && b1 < 'ʼ'; ) {
                    this.gs.clcars.add(this.rd, str1);
                    b1++;
                    if (b != 1) b = 1;
                }
                dataInputStream.close();
            }
        } catch (Exception exception) {
            b = -2;
        }
        if (b == 1) {
            if (this.viewcar.equals("")) {
                this.gs.clcars.select(0);
            } else {
                this.gs.clcars.select(this.viewcar);
                this.viewcar = "";
            }
            this.selstage = this.gs.clcars.getSelectedItem();
        }
        return b;
    }

    public int loadaddstages() {
        byte b = 3;
        byte b1 = 0;
        String[] arrayOfString = new String[700];
        try {
            URL uRL = new URL("http://multiplayer.needformadness.com/tracks/lists/" + this.gs.tnick.getText() + ".txt?reqlo=" + (int) (Math.random() * 1000.0D) + "");
            uRL.openConnection().setConnectTimeout(2000);
            DataInputStream dataInputStream;
            String str;
            for (dataInputStream = new DataInputStream(uRL.openStream()), str = ""; (str = dataInputStream.readLine()) != null; ) {
                str = "" + str.trim();
                if (str.startsWith("mystages")) for (boolean bool = true; bool && b1 < 700; ) {
                    arrayOfString[b1] = getfuncSvalue("mystages", str, b1);
                    if (arrayOfString[b1].equals("")) {
                        bool = false;
                        continue;
                    }
                    b1++;
                }
            }
            dataInputStream.close();
        } catch (Exception exception) {
            String str = "" + exception;
            if (str.indexOf("FileNotFound") != -1) {
                b1 = 0;
                b = 3;
            } else {
                b1 = -1;
                b = 4;
            }
        }
        if (b1 > 0) {
            String[] arrayOfString1;
            byte b2;
            byte b3;
            for (arrayOfString1 = new String[700], b2 = 0, b3 = 0; b3 < b1; ) {
                this.perry = "" + (int) (b3 / b1 * 100.0F) + " %";
                try {
                    String str1 = "http://multiplayer.needformadness.com/tracks/" + arrayOfString[b3] + ".txt?reqlo=" + (int) (Math.random() * 1000.0D) + "";
                    str1 = str1.replace(' ', '_');
                    URL uRL = new URL(str1);
                    uRL.openConnection().setConnectTimeout(2000);
                    DataInputStream dataInputStream;
                    String str2;
                    for (dataInputStream = new DataInputStream(uRL.openStream()), str2 = ""; (str2 = dataInputStream.readLine()) != null; ) {
                        str2 = "" + str2.trim();
                        if (str2.startsWith("details")) {
                            String str = getfuncSvalue("details", str2, 0);
                            if (str.toLowerCase().equals(this.gs.tnick.getText().toLowerCase()) && str2.indexOf("Clan#") == -1) {
                                arrayOfString1[b2] = arrayOfString[b3];
                                b2++;
                            }
                        }
                    }
                    dataInputStream.close();
                } catch (Exception exception) {
                }
                b3++;
            }
            if (b2 > 0) {
                this.gs.clcars.removeAll();
                for (b3 = 0; b3 < b2; ) {
                    this.gs.clcars.add(this.rd, arrayOfString1[b3]);
                    b3++;
                }
                b = 5;
            } else {
                b = 3;
            }
        }
        return b;
    }

    public void loadiclanstages(String paramString) {
        try {
            URL uRL = new URL("http://multiplayer.needformadness.com/clans/" + paramString + "/stages.txt");
            uRL.openConnection().setConnectTimeout(2000);
            String str = uRL.openConnection().getContentType();
            if (str.equals("text/plain")) {
                this.gs.datat.removeAll();
                this.gs.datat.add(this.rd, "Select Stage");
                DataInputStream dataInputStream;
                String str1;
                byte b;
                for (dataInputStream = new DataInputStream(uRL.openStream()), str1 = "", b = 0; (str1 = dataInputStream.readLine()) != null && b < 'ʼ'; ) {
                    this.gs.datat.add(this.rd, str1);
                    b++;
                }
                dataInputStream.close();
            } else {
                this.gs.datat.removeAll();
                this.gs.datat.add(this.rd, "No clan stages where found.");
            }
        } catch (Exception exception) {
            this.gs.datat.removeAll();
            this.gs.datat.add(this.rd, "Failed to load stages, try again later...");
        }
        this.gs.datat.select(0);
    }

    public void loadproinfo() {
        if (!this.proname.equals(this.xt.nickname) && this.npf == -1) loadfriends();
        this.racing = 0;
        this.wasting = 0;
        this.themesong = "";
        this.trackvol = 0;
        this.sentance = "";
        this.proclan = "";
        try {
            String str1 = "";
            if (this.proname.equals(this.xt.nickname)) str1 = "?req=" + (int) (Math.random() * 1000.0D) + "";
            URL uRL = new URL("http://multiplayer.needformadness.com/profiles/" + this.proname + "/info.txt" + str1 + "");
            uRL.openConnection().setConnectTimeout(2000);
            String str2 = uRL.openConnection().getContentType();
            if (str2.equals("text/plain")) {
                DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
                String str = "";
                byte b = 0;
                while ((str = dataInputStream.readLine()) != null && b < 9) {
                    str = str.trim();
                    if (b == 0) this.themesong = str;
                    if (b == 1) {
                        int i = 0;
                        try {
                            i = Integer.valueOf(str).intValue();
                        } catch (Exception exception) {
                            i = 0;
                        }
                        this.trackvol = i;
                    }
                    if (b == 2) {
                        int i = 0;
                        try {
                            i = Integer.valueOf(str).intValue();
                        } catch (Exception exception) {
                            i = 0;
                        }
                        this.racing = i;
                    }
                    if (b == 3) {
                        int i = 0;
                        try {
                            i = Integer.valueOf(str).intValue();
                        } catch (Exception exception) {
                            i = 0;
                        }
                        this.wasting = i;
                    }
                    if (b == 4) this.proclan = str;
                    if (b == 8) this.sentance = str;
                    b++;
                }
                dataInputStream.close();
            }
        } catch (Exception exception) {
            this.sentance = "Failed to load profile info, server error!";
        }
    }

    public void loadprostages() {
        String[] arrayOfString = new String[700];
        byte b = 0;
        String str = "";
        try {
            URL uRL = new URL("http://multiplayer.needformadness.com/tracks/lists/" + this.proname + ".txt?reqlo=" + (int) (Math.random() * 1000.0D) + "");
            DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
            while ((str = dataInputStream.readLine()) != null) {
                str = "" + str.trim();
                if (str.startsWith("mystages")) for (boolean bool = true; bool && b < 'ʼ'; ) {
                    arrayOfString[b] = getfuncSvalue("mystages", str, b);
                    if (arrayOfString[b].equals("")) {
                        bool = false;
                        continue;
                    }
                    b++;
                }
            }
            if (b > 0) {
                this.loadpst = 1;
            } else {
                this.loadpst = -2;
            }
            dataInputStream.close();
        } catch (Exception exception) {
            String str1 = "" + exception;
            if (str1.indexOf("FileNotFound") != -1) {
                this.loadpst = -2;
            } else {
                this.loadpst = -1;
            }
        }
        if (this.loadpst == 1) {
            this.gs.proitem.removeAll();
            this.gs.proitem.add(this.gs.rd, "Select Stage");
            for (byte b1 = 0; b1 < b; ) {
                this.gs.proitem.add(this.gs.rd, arrayOfString[b1]);
                b1++;
            }
            this.gs.proitem.select(0);
            this.loadpstage = "Select Stage";
            this.gs.proitem.show();
        }
        if (this.loadpst == -2) {
            this.gs.proitem.removeAll();
            this.gs.proitem.add(this.gs.rd, "No published or added stages found...");
            this.gs.proitem.select(0);
            this.gs.proitem.show();
        }
        if (this.loadpst == -1) {
            this.gs.proitem.removeAll();
            this.gs.proitem.add(this.gs.rd, "Failed to load stages, please try again later.");
            this.gs.proitem.select(0);
            this.gs.proitem.show();
        }
        System.gc();
    }

    /*      */
    public void loadfriends() {
        if (this.npf == -1) {
            this.freq = 0;
            try {
                URL uRL = new URL("http://multiplayer.needformadness.com/profiles/" + this.xt.nickname + "/friends.txt?req=" + (int) (Math.random() * 1000.0D) + "");
                uRL.openConnection().setConnectTimeout(2000);
                String str = uRL.openConnection().getContentType();
                if (str.equals("text/plain")) {
                    byte b1 = 0;
                    DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
                    String str1 = "";
                    byte b2 = 0;
                    while ((str1 = dataInputStream.readLine()) != null && b2 < 3) {
                        str1 = str1.trim();
                        if (b2 == 0) for (String str2 = getSvalue(str1, b1); !str2.equals("") && this.npf < 900; ) {
                            this.fname[b1] = str2;
                            str2 = getSvalue(str1, ++b1);
                        }
                        if (b2 == 1) {
                            this.freqname = getSvalue(str1, 0);
                            if (!this.freqname.equals("")) this.freq = 1;
                        }
                        if (b2 == 2 && this.freq != 1) {
                            String str2;
                            for (this.ncnf = 0, str2 = getSvalue(str1, this.ncnf); !str2.equals("") && this.ncnf < 10; ) {
                                this.cnfname[this.ncnf] = str2;
                                this.ncnf++;
                                str2 = getSvalue(str1, this.ncnf);
                            }
                            if (this.ncnf != 0) this.freq = 6;
                        }
                        b2++;
                    }
                    dataInputStream.close();
                    this.npf = b1;
                } else {
                    this.npf = 0;
                }
            } catch (Exception exception) {
                this.npf = -2;
            }
        }
    }

    /*      */
    public void loadnews() {
        try {
            URL uRL = new URL("http://multiplayer.needformadness.com/interact/news.txt?req=" + (int) (Math.random() * 1000.0D) + "");
            uRL.openConnection().setConnectTimeout(2000);
            DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
            String str1 = "";
            byte b = 0;
            String str2 = "";
            this.il = 0;
            while ((str1 = dataInputStream.readLine()) != null && b < 'Ĭ') {
                str1 = str1.trim();
                if (b == 0) for (byte b1 = 0; b1 < 4; ) {
                    this.newplayers[b1] = getSvalue(str1, b1);
                    b1++;
                }
                if (b >= 1 && b <= 5) {
                    this.nwtime[b - 1] = contime(getLvalue(str1, 0));
                    this.nwarbs[b - 1] = getvalue(str1, 1);
                    this.nwclan[b - 1] = getSvalue(str1, 2);
                    this.nlclan[b - 1] = getSvalue(str1, 3);
                    this.nwinob[b - 1] = getSvalue(str1, 4);
                    this.nwinp[b - 1] = getvalue(str1, 5);
                    this.nlosp[b - 1] = getvalue(str1, 6);
                }
                if (b >= 6 && this.il < 300) {
                    this.nttime[this.il] = contime(getLvalue(str1, 0));
                    int i = getvalue(str1, 1);
                    if (i == 4) {
                        int j = getvalue(str1, 4);
                        if (j <= 0) {
                            this.text[this.il] = "" + getSvalue(str1, 2) + " has joined clan " + getSvalue(str1, 3) + ".";
                        } else {
                            int k = getvalue(str1, 5);
                            if (k == j) {
                                this.text[this.il] = "" + getSvalue(str1, 2) + " got a new rank in clan " + getSvalue(str1, 3) + ".";
                            } else {
                                String str = "promoted";
                                if (k - j < 0) str = "demoted";
                                if (k != 7) {
                                    this.text[this.il] = "" + getSvalue(str1, 2) + " has been " + str + " in clan " + getSvalue(str1, 3) + " to a level " + k + " member.";
                                } else {
                                    this.text[this.il] = "" + getSvalue(str1, 2) + " has been " + str + " in clan " + getSvalue(str1, 3) + " to Clan Admin!";
                                }
                            }
                        }
                        this.nln[this.il] = 2;
                        this.link[this.il][0][0] = getSvalue(str1, 2);
                        this.link[this.il][0][1] = "0|" + getSvalue(str1, 2) + "|";
                        this.link[this.il][1][0] = getSvalue(str1, 3);
                        this.link[this.il][1][1] = "1|" + getSvalue(str1, 3) + "|";
                        this.il++;
                    }
                    if (i == 5) {
                        String str3 = getSvalue(str1, 2), str4 = getSvalue(str1, 4), str5 = "left";
                        if (!str3.toLowerCase().equals(str4.toLowerCase())) str5 = "been removed from";
                        this.text[this.il] = "" + str3 + " has " + str5 + " clan " + getSvalue(str1, 3) + ".";
                        this.nln[this.il] = 2;
                        this.link[this.il][0][0] = getSvalue(str1, 2);
                        this.link[this.il][0][1] = "0|" + getSvalue(str1, 2) + "|";
                        this.link[this.il][1][0] = getSvalue(str1, 3);
                        this.link[this.il][1][1] = "1|" + getSvalue(str1, 3) + "|";
                        this.il++;
                    }
                    if (i == 6) {
                        this.text[this.il] = "" + getSvalue(str1, 2) + " has updated clan " + getSvalue(str1, 3) + "'s web presence.";
                        this.nln[this.il] = 3;
                        this.link[this.il][0][0] = getSvalue(str1, 2);
                        this.link[this.il][0][1] = "0|" + getSvalue(str1, 2) + "|";
                        this.link[this.il][1][0] = getSvalue(str1, 3);
                        this.link[this.il][1][1] = "1|" + getSvalue(str1, 3) + "|";
                        this.link[this.il][2][0] = "web presence";
                        this.link[this.il][2][1] = "2|" + getSvalue(str1, 3) + "|";
                        this.il++;
                    }
                    if (i == 7) if (str2.indexOf("#" + getSvalue(str1, 4) + "#") == -1) {
                        this.text[this.il] = "" + getSvalue(str1, 2) + " has added car " + getSvalue(str1, 4) + " to clan " + getSvalue(str1, 3) + ".";
                        this.nln[this.il] = 3;
                        this.link[this.il][0][0] = getSvalue(str1, 2);
                        this.link[this.il][0][1] = "0|" + getSvalue(str1, 2) + "|";
                        this.link[this.il][1][0] = getSvalue(str1, 3);
                        this.link[this.il][1][1] = "1|" + getSvalue(str1, 3) + "|";
                        this.link[this.il][2][0] = getSvalue(str1, 4);
                        this.link[this.il][2][1] = "3|" + getSvalue(str1, 4) + "|" + getSvalue(str1, 3) + "|";
                        str2 = str2 + "#" + getSvalue(str1, 4) + "#";
                        this.il++;
                    }
                    if (i == 8) if (str2.indexOf("#" + getSvalue(str1, 4) + "#") == -1) {
                        String str = getSvalue(str1, 4);
                        if (str.length() > 20) str = "" + str.substring(0, 20) + "...";
                        this.text[this.il] = "" + getSvalue(str1, 2) + " has added stage " + str + " to clan " + getSvalue(str1, 3) + ".";
                        this.nln[this.il] = 3;
                        this.link[this.il][0][0] = getSvalue(str1, 2);
                        this.link[this.il][0][1] = "0|" + getSvalue(str1, 2) + "|";
                        this.link[this.il][1][0] = getSvalue(str1, 3);
                        this.link[this.il][1][1] = "1|" + getSvalue(str1, 3) + "|";
                        this.link[this.il][2][0] = str;
                        this.link[this.il][2][1] = "4|" + getSvalue(str1, 4) + "|" + getSvalue(str1, 3) + "|";
                        str2 = str2 + "#" + getSvalue(str1, 4) + "#";
                        this.il++;
                    }
                    if (i == 9) {
                        String str = getSvalue(str1, 2);
                        if (str.startsWith("War")) {
                            this.text[this.il] = "Clans " + getSvalue(str1, 7) + " & " + getSvalue(str1, 8) + " have now started a war!";
                            this.nln[this.il] = 2;
                            this.link[this.il][0][0] = getSvalue(str1, 7);
                            this.link[this.il][0][1] = "1|" + getSvalue(str1, 7) + "|";
                            this.link[this.il][1][0] = getSvalue(str1, 8);
                            this.link[this.il][1][1] = "1|" + getSvalue(str1, 8) + "|";
                            this.il++;
                        }
                        if (str.startsWith("Car")) {
                            this.text[this.il] = "Clans " + getSvalue(str1, 7) + " & " + getSvalue(str1, 8) + " have started a car battle!";
                            this.nln[this.il] = 2;
                            this.link[this.il][0][0] = getSvalue(str1, 7);
                            this.link[this.il][0][1] = "1|" + getSvalue(str1, 7) + "|";
                            this.link[this.il][1][0] = getSvalue(str1, 8);
                            this.link[this.il][1][1] = "1|" + getSvalue(str1, 8) + "|";
                            this.il++;
                            if (this.il < 300) {
                                this.text[this.il] = "Battle over cars: [" + getSvalue(str1, 4) + "] & [" + getSvalue(str1, 5) + "]";
                                this.nln[this.il] = 2;
                                this.link[this.il][0][0] = getSvalue(str1, 4);
                                this.link[this.il][0][1] = "3|" + getSvalue(str1, 4) + "|" + getSvalue(str1, 8) + "|";
                                this.link[this.il][1][0] = getSvalue(str1, 5);
                                this.link[this.il][1][1] = "3|" + getSvalue(str1, 5) + "|" + getSvalue(str1, 7) + "|";
                                this.nttime[this.il] = "";
                                this.il++;
                            }
                        }
                        if (str.startsWith("Stage")) {
                            String str3 = getSvalue(str1, 4);
                            if (str3.length() > 20) str3 = "" + str3.substring(0, 20) + "...";
                            String str4 = getSvalue(str1, 5);
                            if (str4.length() > 20) str4 = "" + str4.substring(0, 20) + "...";
                            this.text[this.il] = "Clans " + getSvalue(str1, 7) + " & " + getSvalue(str1, 8) + " have started a stage battle!";
                            this.nln[this.il] = 2;
                            this.link[this.il][0][0] = getSvalue(str1, 7);
                            this.link[this.il][0][1] = "1|" + getSvalue(str1, 7) + "|";
                            this.link[this.il][1][0] = getSvalue(str1, 8);
                            this.link[this.il][1][1] = "1|" + getSvalue(str1, 8) + "|";
                            this.il++;
                            if (this.il < 300) {
                                this.text[this.il] = "Battle over stages: [" + str3 + "] & [" + str4 + "]";
                                this.nln[this.il] = 2;
                                this.link[this.il][0][0] = str3;
                                this.link[this.il][0][1] = "4|" + getSvalue(str1, 4) + "|" + getSvalue(str1, 8) + "|";
                                this.link[this.il][1][0] = str4;
                                this.link[this.il][1][1] = "4|" + getSvalue(str1, 5) + "|" + getSvalue(str1, 7) + "|";
                                this.nttime[this.il] = "";
                                this.il++;
                            }
                        }
                    }
                    if (i == 10 || i == 11 || i == 12 || i == 13) {
                        if (i == 11) {
                            this.text[this.il] = "" + getSvalue(str1, 2) + " has re-claimed its title as clan wars world champion!";
                        } else {
                            this.text[this.il] = "" + getSvalue(str1, 2) + " has now become the new clan wars world champion!";
                        }
                        this.nln[this.il] = 2;
                        this.link[this.il][0][0] = getSvalue(str1, 2);
                        this.link[this.il][0][1] = "1|" + getSvalue(str1, 2) + "|";
                        this.link[this.il][1][0] = "clan wars world champion";
                        this.link[this.il][1][1] = "5|championship|";
                        if (getSvalue(str1, 2).equals("")) {
                            this.text[this.il] = "No one is currently the clan wars world champion!";
                            this.nln[this.il] = 1;
                            this.link[this.il][0][0] = "clan wars world champion";
                            this.link[this.il][0][1] = "5|championship|";
                        }
                        this.il++;
                        if (i == 10)
                            this.text[this.il] = "" + getSvalue(str1, 2) + " recent win against " + getSvalue(str1, 4) + " has given it the championship title!";
                        if (i == 11)
                            this.text[this.il] = "" + getSvalue(str1, 2) + " has successfully defended its championship title against " + getSvalue(str1, 4) + "!";
                        if (i == 12)
                            this.text[this.il] = "A recent war between " + getSvalue(str1, 3) + " and " + getSvalue(str1, 4) + " has resulted in a change of points!";
                        if (i == 13)
                            this.text[this.il] = "Clan " + getSvalue(str1, 3) + " removed itself from the game which resulted in a change of points!";
                        this.nttime[this.il] = "";
                        this.nln[this.il] = 0;
                        this.il++;
                    }
                }
                b++;
            }
            dataInputStream.close();
            this.spos6 = 0;
            this.loadednews = 1;
        } catch (Exception exception) {
            this.loadednews = -1;
        }
    }

    /*      */
    public void loadchamps() {
        this.eng = -1;
        this.engo = 0;
        if (this.maxclans <= 0) this.maxclans = 1000;
        this.ncc = 0;
        this.champ = -1;
        int i = 0;
        this.conclan = new String[this.maxclans];
        this.totp = new int[this.maxclans];
        this.nvc = new int[this.maxclans];
        this.points = new int[this.maxclans][this.maxclans];
        this.verclan = new String[this.maxclans][this.maxclans];
        try {
            URL uRL = new URL("http://multiplayer.needformadness.com/interact/clanstat.txt?req=" + (int) (Math.random() * 1000.0D) + "");
            uRL.openConnection().setConnectTimeout(2000);
            DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
            String str = "";
            while ((str = dataInputStream.readLine()) != null && this.ncc < this.maxclans) {
                this.conclan[this.ncc] = getSvalue(str, 0);
                if (!this.conclan[this.ncc].equals("")) {
                    this.totp[this.ncc] = 0;
                    this.nvc[this.ncc] = 0;
                    int j = getpvalue(str, 1);
                    while (j != 0 && this.nvc[this.ncc] < this.maxclans) {
                        this.totp[this.ncc] = this.totp[this.ncc] + j;
                        this.points[this.ncc][this.nvc[this.ncc]] = j;
                        this.verclan[this.ncc][this.nvc[this.ncc]] = getSvalue(str, 2 + this.nvc[this.ncc] * 2);
                        this.nvc[this.ncc] = this.nvc[this.ncc] + 1;
                        j = getpvalue(str, 1 + this.nvc[this.ncc] * 2);
                    }
                    if (this.totp[this.ncc] >= i && this.totp[this.ncc] >= 3) if (this.totp[this.ncc] == i) {
                        this.champ = -2;
                    } else {
                        i = this.totp[this.ncc];
                        this.champ = this.ncc;
                    }
                    this.ncc++;
                }
            }
            dataInputStream.close();
            this.ord = new int[this.ncc];
            int[] arrayOfInt = new int[this.ncc];
            this.leadsby = i;
            byte b;
            for (b = 0; b < this.ncc; ) {
                if (b != this.champ && i - this.totp[b] < this.leadsby) this.leadsby = i - this.totp[b];
                arrayOfInt[b] = 0;
                b++;
            }
            for (b = 0; b < this.ncc; ) {
                for (int j = b + 1; j < this.ncc; ) {
                    if (this.totp[b] < this.totp[j]) {
                        arrayOfInt[b] = arrayOfInt[b] + 1;
                    } else {
                        arrayOfInt[j] = arrayOfInt[j] + 1;
                    }
                    j++;
                }
                this.ord[arrayOfInt[b]] = b;
                b++;
            }
            this.spos6 = 0;
            this.loadwstat = 1;
        } catch (Exception exception) {
            String str = "" + exception;
            if (str.indexOf("java.io.FileNotFoundException") != -1) {
                this.loadwstat = 1;
            } else {
                this.loadwstat = -1;
            }
        }
    }

    /*      */
    public String contime(long paramLong) {
        String str = "";
        if (paramLong != -1L) try {
            long l = this.ntime - paramLong;
            if (l >= 1000L && l < 60000L) str = "seconds ago";
            if (l >= 60000L && l < 3600000L) {
                int i = (int) (l / 60000L);
                String str1 = "s";
                if (i == 1) str1 = "";
                str = "" + i + " minute" + str1 + " ago";
            }
            if (l >= 3600000L && l < 86400000L) {
                int i = (int) (l / 3600000L);
                String str1 = "s";
                if (i == 1) str1 = "";
                str = "" + i + " hour" + str1 + " ago";
            }
            if (l >= 86400000L) {
                int i = (int) (l / 86400000L);
                String str1 = "s";
                if (i == 1) str1 = "";
                str = "" + i + " day" + str1 + " ago";
            }
        } catch (Exception exception) {
            str = "";
        }
        return str;
    }

    /*      */
    public void tlink(Graphics2D paramGraphics2D, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, int paramInt4, boolean paramBoolean, int paramInt5, int paramInt6, int paramInt7, String paramString3, String paramString4) {
        this.ftm = this.rdo.getFontMetrics();
        int i = 0, j = 0, k = paramString1.indexOf(paramString2);
        if (k != -1) {
            i = this.ftm.stringWidth(paramString1.substring(0, k)) + paramInt1;
            j = i + this.ftm.stringWidth(paramString2) - 2;
        }
        this.rdo.drawLine(i, paramInt2 + 1, j, paramInt2 + 1);
        if (paramInt3 > i + paramInt5 && paramInt3 < j + paramInt5 && paramInt4 > paramInt2 - 11 + paramInt6 && paramInt4 < paramInt2 + 1 + paramInt6) {
            this.cur = 12;
            if (paramBoolean) {
                if (paramInt7 == 0) {
                    this.tab = 1;
                    if (!this.proname.equals(paramString3)) {
                        this.proname = paramString3;
                        this.loadedp = false;
                        onexitpro();
                    }
                }
                if (paramInt7 == 1) {
                    if (!this.claname.equals(paramString3)) {
                        this.claname = paramString3;
                        this.loadedc = false;
                    }
                    this.spos5 = 0;
                    this.lspos5 = 0;
                    this.cfase = 3;
                    this.ctab = 0;
                    this.tab = 3;
                }
                if (paramInt7 == 2) {
                    if (!this.claname.equals(paramString3)) {
                        this.claname = paramString3;
                        this.loadedc = false;
                    }
                    this.spos5 = 0;
                    this.lspos5 = 0;
                    this.cfase = 3;
                    this.loadedlink = false;
                    this.ctab = 4;
                    this.tab = 3;
                }
                if (paramInt7 == 3) {
                    this.viewcar = paramString3;
                    if (!this.claname.equals(paramString4)) {
                        this.claname = paramString4;
                        this.loadedc = false;
                    }
                    this.spos5 = 0;
                    this.lspos5 = 0;
                    this.cfase = 3;
                    this.loadedcars = -1;
                    this.loadedcar = 0;
                    this.ctab = 2;
                    this.tab = 3;
                }
                if (paramInt7 == 4) {
                    this.viewcar = paramString3;
                    if (!this.claname.equals(paramString4)) {
                        this.claname = paramString4;
                        this.loadedc = false;
                    }
                    this.spos5 = 0;
                    this.lspos5 = 0;
                    this.cfase = 3;
                    this.loadedstages = -1;
                    this.loadedstage = 0;
                    this.ctab = 3;
                    this.tab = 3;
                }
                if (paramInt7 == 5) {
                    this.loadwstat = 0;
                    this.ntab = 1;
                }
            }
        }
    }

    /*      */
    public void loadwarb() {
        try {
            URL uRL = new URL("http://multiplayer.needformadness.com/clans/" + this.xt.clan + "/inter.txt?req=" + (int) (Math.random() * 1000.0D) + "");
            uRL.openConnection().setConnectTimeout(2000);
            String str = uRL.openConnection().getContentType();
            this.gs.warb.removeAll();
            this.gs.warb.add(this.rd, " Select  War / Battle");
            if (str.equals("text/plain")) {
                DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
                String str1 = "";
                byte b = 0;
                boolean bool = false;
                while ((str1 = dataInputStream.readLine()) != null && b < 100) {
                    str1 = str1.trim();
                    String str2 = getSvalue(str1, 5);
                    if (str2.equals("War")) {
                        this.gs.warb.addw(" War with " + getSvalue(str1, 0) + "", "" + getSvalue(str1, 6) + "|" + getSvalue(str1, 0) + "|");
                        bool = true;
                    }
                    if (str2.equals("Car Battle")) {
                        this.gs.warb.addw(" Car battle with " + getSvalue(str1, 0) + "", "" + getSvalue(str1, 6) + "|" + getSvalue(str1, 0) + "|");
                        bool = true;
                    }
                    if (str2.equals("Stage Battle")) {
                        this.gs.warb.addw(" Stage battle with " + getSvalue(str1, 0) + "", "" + getSvalue(str1, 6) + "|" + getSvalue(str1, 0) + "|");
                        bool = true;
                    }
                    b++;
                }
                dataInputStream.close();
                if (!bool) {
                    this.gs.warb.removeAll();
                    this.gs.warb.add(this.rd, "Your clan has not started any new wars or battles.");
                }
            } else {
                this.gs.warb.removeAll();
                this.gs.warb.add(this.rd, "Your clan has not started any wars or battles yet.");
            }
        } catch (Exception exception) {
            this.gs.warb.removeAll();
            this.gs.warb.add(this.rd, "Error occurred while loading, please try again later.");
        }
        this.gs.warb.select(0);
    }

    /* 4632 */
    public void redogame() {
        try {
            this.socket = new Socket(this.lg.servers[0], 7061);
            /* 4633 */
            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            /* 4634 */
            this.dout = new PrintWriter(this.socket.getOutputStream(), true);
            /* 4635 */
            String str1 = "101|43|" + this.warb + "|" + this.warbnum + "|";
            /* 4636 */
            this.dout.println(str1);
            String str2 = this.din.readLine();
            /* 4637 */
            if (!str2.equals("OK")) this.loadwbgames = 6;
            /* 4638 */
            this.socket.close();
            this.socket = null;
            this.din.close();
            this.din = null;
            this.dout.close();
            this.dout = null;
        }
        /*      */ catch (Exception exception)
            /* 4640 */ {
            this.loadwbgames = 6;
        }
        /* 4641 */
        if (this.loadwbgames != 6) loadwgames();
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    public boolean drawbutton(Image paramImage, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {
        /* 4647 */
        boolean bool1 = false;
        /* 4648 */
        boolean bool2 = false;
        /* 4649 */
        int i = paramImage.getWidth(this.ob);
        /*      */
        /* 4651 */
        if (Math.abs(paramInt3 - paramInt1) < i / 2 + 12 && Math.abs(paramInt4 - paramInt2) < 14 && paramBoolean)
            bool2 = true;
        /* 4652 */
        if (Math.abs(paramInt3 - paramInt1) < i / 2 + 12 && Math.abs(paramInt4 - paramInt2) < 14 && this.gs.mouses <= -1) {
            bool1 = true;
            this.gs.mouses = 0;
        }
        /*      */
        /* 4654 */
        if (!bool2) {
            /*      */
            /* 4656 */
            this.rd.drawImage(paramImage, paramInt1 - i / 2, paramInt2 - paramImage.getHeight(this.ob) / 2, (ImageObserver) null);
            /* 4657 */
            this.rd.drawImage(this.xt.bols, paramInt1 - i / 2 - 15, paramInt2 - 13, (ImageObserver) null);
            /* 4658 */
            this.rd.drawImage(this.xt.bors, paramInt1 + i / 2 + 9, paramInt2 - 13, (ImageObserver) null);
            /* 4659 */
            this.rd.drawImage(this.xt.bot, paramInt1 - i / 2 - 9, paramInt2 - 13, i + 18, 3, null);
            /* 4660 */
            this.rd.drawImage(this.xt.bob, paramInt1 - i / 2 - 9, paramInt2 + 10, i + 18, 3, null);
            /*      */
        }
        /*      */
        else {
            /*      */
            /* 4664 */
            this.rd.drawImage(paramImage, paramInt1 - i / 2 + 1, paramInt2 - paramImage.getHeight(this.ob) / 2 + 1, (ImageObserver) null);
            /* 4665 */
            this.rd.drawImage(this.xt.bolps, paramInt1 - i / 2 - 15, paramInt2 - 13, (ImageObserver) null);
            /* 4666 */
            this.rd.drawImage(this.xt.borps, paramInt1 + i / 2 + 9, paramInt2 - 13, (ImageObserver) null);
            /* 4667 */
            this.rd.drawImage(this.xt.bob, paramInt1 - i / 2 - 9, paramInt2 - 13, i + 18, 3, null);
            /* 4668 */
            this.rd.drawImage(this.xt.bot, paramInt1 - i / 2 - 9, paramInt2 + 10, i + 18, 3, null);
            /*      */
        }
        /*      */
        /* 4671 */
        return bool1;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    public boolean stringbutton(Graphics2D paramGraphics2D, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean, int paramInt6, int paramInt7) {
        /* 4677 */
        boolean bool1 = false;
        /* 4678 */
        boolean bool2 = false;
        /* 4679 */
        paramGraphics2D.setFont(new Font("Arial", 1, 12));
        this.ftm = paramGraphics2D.getFontMetrics();
        /* 4680 */
        if (paramInt3 == 6) {
            paramGraphics2D.setFont(new Font("Arial", 1, 11));
            this.ftm = paramGraphics2D.getFontMetrics();
        }
        /* 4681 */
        int i = this.ftm.stringWidth(paramString);
        /*      */
        /* 4683 */
        if (Math.abs(paramInt4 - paramInt6 - paramInt1) < i / 2 + 12 && Math.abs(paramInt5 - paramInt7 - paramInt2) < 14 && paramBoolean)
            bool2 = true;
        /* 4684 */
        if (Math.abs(paramInt4 - paramInt6 - paramInt1) < i / 2 + 12 && Math.abs(paramInt5 - paramInt7 - paramInt2) < 14 && this.gs.mouses <= -1 && this.blocknote == 0 && this.blockb == 0 && !this.gs.openm && (this.editc == 0 || paramInt6 == 0)) {
            bool1 = true;
            this.gs.mouses = 0;
        }
        /* 4685 */
        if (this.blocknote != 0) this.blocknote--;
        /*      */
        /* 4687 */
        boolean bool3 = false;
        if (paramInt3 < 0) {
            paramInt3 *= -1;
            bool3 = true;
        }
        /*      */
        /* 4689 */
        if (bool3) this.rdo.setComposite(AlphaComposite.getInstance(3, 0.7F));
        /*      */
        /* 4691 */
        if (!bool2) {
            /*      */
            /* 4693 */
            paramGraphics2D.setColor(colorb2k(bool3, 220, 220, 220));
            /* 4694 */
            paramGraphics2D.fillRect(paramInt1 - i / 2 - 10, paramInt2 - 17 - paramInt3, i + 20, 25 - paramInt3 * 2);
            /* 4695 */
            paramGraphics2D.setColor(colorb2k(bool3, 240, 240, 240));
            /* 4696 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 - 17 - paramInt3);
            /* 4697 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 18 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 - 18 - paramInt3);
            /* 4698 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 9, paramInt2 - 19 - paramInt3, paramInt1 + i / 2 + 9, paramInt2 - 19 - paramInt3);
            /* 4699 */
            paramGraphics2D.setColor(colorb2k(bool3, 200, 200, 200));
            /* 4700 */
            paramGraphics2D.drawLine(paramInt1 + i / 2 + 10, paramInt2 - 17 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 + 7 - paramInt3);
            /* 4701 */
            paramGraphics2D.drawLine(paramInt1 + i / 2 + 11, paramInt2 - 17 - paramInt3, paramInt1 + i / 2 + 11, paramInt2 + 7 - paramInt3);
            /* 4702 */
            paramGraphics2D.drawLine(paramInt1 + i / 2 + 12, paramInt2 - 16 - paramInt3, paramInt1 + i / 2 + 12, paramInt2 + 6 - paramInt3);
            /* 4703 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 10, paramInt2 + 7 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 + 7 - paramInt3);
            /* 4704 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 10, paramInt2 + 8 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 + 8 - paramInt3);
            /* 4705 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 9, paramInt2 + 9 - paramInt3, paramInt1 + i / 2 + 9, paramInt2 + 9 - paramInt3);
            /* 4706 */
            paramGraphics2D.setColor(colorb2k(bool3, 240, 240, 240));
            /* 4707 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 - i / 2 - 10, paramInt2 + 7 - paramInt3);
            /* 4708 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 11, paramInt2 - 17 - paramInt3, paramInt1 - i / 2 - 11, paramInt2 + 7 - paramInt3);
            /* 4709 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 12, paramInt2 - 16 - paramInt3, paramInt1 - i / 2 - 12, paramInt2 + 6 - paramInt3);
            /* 4710 */
            if (bool3) this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
            /* 4711 */
            paramGraphics2D.setColor(new Color(0, 0, 0));
            /* 4712 */
            paramGraphics2D.drawString(paramString, paramInt1 - i / 2, paramInt2);
            /*      */
        }
        /*      */
        else {
            /*      */
            /* 4716 */
            paramGraphics2D.setColor(colorb2k(bool3, 210, 210, 210));
            /* 4717 */
            paramGraphics2D.fillRect(paramInt1 - i / 2 - 10, paramInt2 - 17 - paramInt3, i + 20, 25 - paramInt3 * 2);
            /* 4718 */
            paramGraphics2D.setColor(colorb2k(bool3, 200, 200, 200));
            /* 4719 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 - 17 - paramInt3);
            /* 4720 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 18 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 - 18 - paramInt3);
            /* 4721 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 9, paramInt2 - 19 - paramInt3, paramInt1 + i / 2 + 9, paramInt2 - 19 - paramInt3);
            /* 4722 */
            paramGraphics2D.drawLine(paramInt1 + i / 2 + 10, paramInt2 - 17 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 + 7 - paramInt3);
            /* 4723 */
            paramGraphics2D.drawLine(paramInt1 + i / 2 + 11, paramInt2 - 17 - paramInt3, paramInt1 + i / 2 + 11, paramInt2 + 7 - paramInt3);
            /* 4724 */
            paramGraphics2D.drawLine(paramInt1 + i / 2 + 12, paramInt2 - 16 - paramInt3, paramInt1 + i / 2 + 12, paramInt2 + 6 - paramInt3);
            /* 4725 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 10, paramInt2 + 7 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 + 7 - paramInt3);
            /* 4726 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 10, paramInt2 + 8 - paramInt3, paramInt1 + i / 2 + 10, paramInt2 + 8 - paramInt3);
            /* 4727 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 9, paramInt2 + 9 - paramInt3, paramInt1 + i / 2 + 9, paramInt2 + 9 - paramInt3);
            /* 4728 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 - i / 2 - 10, paramInt2 + 7 - paramInt3);
            /* 4729 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 11, paramInt2 - 17 - paramInt3, paramInt1 - i / 2 - 11, paramInt2 + 7 - paramInt3);
            /* 4730 */
            paramGraphics2D.drawLine(paramInt1 - i / 2 - 12, paramInt2 - 16 - paramInt3, paramInt1 - i / 2 - 12, paramInt2 + 6 - paramInt3);
            /* 4731 */
            if (bool3) this.rdo.setComposite(AlphaComposite.getInstance(3, 1.0F));
            /* 4732 */
            paramGraphics2D.setColor(new Color(0, 0, 0));
            /* 4733 */
            paramGraphics2D.drawString(paramString, paramInt1 - i / 2 + 1, paramInt2);
            /*      */
        }
        /*      */
        /*      */
        /* 4737 */
        return bool1;
        /*      */
    }

    /*      */
    /*      */
    /*      */
    public Color color2k(int paramInt1, int paramInt2, int paramInt3) {
        /* 4742 */
        Color color = new Color(paramInt1, paramInt2, paramInt3);
        /* 4743 */
        float[] arrayOfFloat = new float[3];
        /* 4744 */
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), arrayOfFloat);
        /* 4745 */
        arrayOfFloat[0] = 0.13F;
        /* 4746 */
        arrayOfFloat[1] = 0.35F;
        /* 4747 */
        return Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
        /*      */
    }

    /*      */
    /*      */
    /*      */
    /*      */
    public Color colorb2k(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
        /* 4753 */
        Color color = new Color(paramInt1, paramInt2, paramInt3);
        /* 4754 */
        if (!paramBoolean)
            /*      */
            /* 4756 */ {
            float[] arrayOfFloat = new float[3];
            /* 4757 */
            Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), arrayOfFloat);
            /* 4758 */
            arrayOfFloat[0] = 0.13F;
            /* 4759 */
            arrayOfFloat[1] = 0.35F;
            /* 4760 */
            if (this.darker) arrayOfFloat[2] = arrayOfFloat[2] * 0.9F;
            /* 4761 */
            color = Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
        }
        /* 4762 */
        else {
            color = new Color((int) (paramInt1 * 0.9F), (int) (paramInt2 * 0.9F), (int) (paramInt3 * 0.9F));
        }
        /* 4763 */
        return color;
        /*      */
    }

    /*      */
    /* 4766 */
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

    /* 4767 */
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

    /* 4768 */
    public long getLvalue(String paramString, int paramInt) {
        long l = -1L;
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
            l = Long.valueOf(str2).longValue();
        } catch (Exception exception) {
        }
        return l;
    }

    /* 4769 */
    public int getpvalue(String paramString, int paramInt) {
        int i = 0;
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
            if (str2.equals("")) str2 = "0";
            i = Integer.valueOf(str2).intValue();
        } catch (Exception exception) {
        }
        return i;
    }

    public int getfuncvalue(String paramString1, String paramString2, int paramInt) {
        int i;
        byte b;
        /*      */
        String str;
        /* 4771 */
        for (b = 0, str = "", i = paramString1.length() + 1; i < paramString2.length(); ) {
            String str1 = "" + paramString2.charAt(i);
            if (str1.equals(",") || str1.equals(")")) {
                b++;
                i++;
            }
            if (b == paramInt) str = str + paramString2.charAt(i);
            i++;
        }
        return Float.valueOf(str).intValue();
    }

    public String getfuncSvalue(String paramString1, String paramString2, int paramInt) {
        String str;
        byte b;
        int i;
        /* 4772 */
        for (str = "", b = 0, i = paramString1.length() + 1; i < paramString2.length() && b <= paramInt; ) {
            String str1 = "" + paramString2.charAt(i);
            if (str1.equals(",") || str1.equals(")")) {
                b++;
            } else if (b == paramInt) {
                str = str + str1;
            }
            i++;
        }
        return str;
    }
    /*      */
    /*      */
}


/* Location:              /home/naglis/Desktop/Need-for-Madness/Need for Madness/Game.jar!/Globe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */