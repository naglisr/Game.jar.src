

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;


public class Lobby implements Runnable {
    Graphics2D rd;
    Login lg;
    Globe gb;
    xtGraphics xt;
    CarDefine cd;
    Medium m;
    FontMetrics ftm;
    ImageObserver ob;
    GameSparker gs;
    Thread connector;
    int conon = 0;


    boolean regnow = false;

    boolean lanlogged = false;

    int fase = 0;
    int stage = 0;
    int laps = 3;
    String stagename = "";
    int nfix = 0;

    boolean notb = false;
    boolean[] pessd = new boolean[]{false, false, false, false, false, false, false, false};
    int[] bx = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
    int[] by = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
    int[] bw = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
    int btn = 0;
    int pbtn = 0;

    int nflk = 0;
    int ncnt = 0;
    int rerr = 0;
    int pback = 0;
    int cflk = 0;
    int sflk = 0;
    String msg = "";
    String lmsg = "| Searching/Waiting for other LAN Players |";
    int opselect = 0;

    boolean lloaded = false;
    int npo = 0;
    String[] pnames = new String[200];
    int[] pcars = new int[200];
    String[] pcarnames = new String[200];
    String[] pclan = new String[200];
    int[] pgames = new int[200];
    float[][] pcols = new float[200][6];


    int prnpo = 0;
    String[] prnames = new String[]{"", "", "", "", "", "", "", ""};
    int[] ppos = new int[]{6, 6, 6, 6, 6, 6, 6, 6};
    int[] plap = new int[]{6, 6, 6, 6, 6, 6, 6, 6};
    int[] ppow = new int[]{50, 50, 50, 50, 50, 50, 50, 50};
    int[] pdam = new int[]{50, 50, 50, 50, 50, 50, 50, 50};
    int prevloaded = -1;
    String stuntname = "";
    String lapsname = "";
    String wastename = "";


    int ngm = 0;
    int[] gnum = new int[500];
    int[] gstgn = new int[500];
    String[] gstages = new String[500];
    int[] gnlaps = new int[500];
    int[] mnpls = new int[500];
    int[] mnbts = new int[500];
    int[] wait = new int[500];
    int[] gcrs = new int[500];
    int[] gclss = new int[500];
    int[] gfx = new int[500];
    int[] gntb = new int[500];
    String[] gplyrs = new String[500];
    int[] gwarb = new int[500];
    String[] gwarbnum = new String[500];
    int[] gameturn = new int[500];
    String[] gaclan = new String[500];
    String[] gvclan = new String[500];
    int[] gascore = new int[500];
    int[] gvscore = new int[500];
    int[] gwtyp = new int[500];

    String[] gmaker = new String[500];
    int[] npls = new int[500];

    int ongame = -1, join = -1, chalngd = -1, im = 0, longame = -1, onjoin = -1, ontyp = 0;
    int dispcar = -1;
    int forcar = -1;
    int addstage = 0;
    ContO dispco = null;
    boolean fstart = false;
    boolean jflexo = false;
    String chalby = "";
    int ctime = 0;
    boolean invo = false;
    String[] invos = new String[]{"", "", "", "", "", "", "", ""};
    String[] dinvi = new String[]{"", "", "", "", "", "", "", ""};

    String[] cnames = new String[]{"", "", "", "", "", "", ""};
    String[] sentn = new String[]{"", "", "", "", "", "", ""};
    int updatec = -1;

    int loadstage = 0, gstage = 0, gstagelaps = 0, gnpls = 8, gwait = 0, gnbts = 0, gcars, gclass = 0, gfix = 0, gnotp = 0, remstage = 0;
    int msload = 0;
    int sgflag = 0;
    String gstagename = "";
    String gplayers = "";

    boolean inwab = false;
    boolean loadwarb = false;
    int warbsel = 0, cancreate = 0, pgamesel = 0;

    int cntchkn = 0;

    Socket socket;

    BufferedReader din;

    PrintWriter dout;

    int spos;

    int spos2;

    int spos3;

    int mscro;

    int lspos;

    int mscro2;

    int lspos2;

    int mscro3;

    int lspos3;

    int clicked;

    int opengame;

    int britchl;

    boolean zeromsw;

    int mousonp;

    int cmonp;

    long ptime;

    int pcurs;

    boolean grprsd;

    int pend;

    int mrot;

    boolean pendb;

    int[] cac;

    int[] cax;

    int[] cay;

    boolean mousedout;

    int flks;

    int waitlink;

    boolean pre1;

    boolean pre2;
    int prereq;
    int plsndt;
    int lxm;
    int lym;


    public void inishlobby() {

        this.gs.tnick.hide();
        this.gs.tpass.hide();
        this.gs.temail.hide();

        hideinputs();

        this.gs.mycar.setBackground(color2k(255, 255, 255));

        this.gs.mycar.setForeground(new Color(0, 0, 0));

        this.gs.rooms.removeAll();

        this.gs.rooms.add(this.rd, "" + this.xt.servername + " :: " + (this.xt.servport - 7070) + "");

        this.gs.rooms.select(0);

        this.gs.requestFocus();


        this.cd.loadready();

        byte b;

        for (b = 0; b < 'Ǵ'; b++) {


            this.gnum[b] = -2;

            this.gstgn[b] = 0;

            this.gstages[b] = "";

            this.gnlaps[b] = 0;

            this.mnpls[b] = 0;

            this.mnbts[b] = 0;

            this.wait[b] = 0;

            this.gmaker[b] = "";

            this.gcrs[b] = 0;

            this.gclss[b] = 0;

            this.gfx[b] = 0;

            this.gntb[b] = 0;

            this.gplyrs[b] = "";

            this.npls[b] = 0;

            this.gwarb[b] = 0;

            this.gwarbnum[b] = "";

            this.gameturn[b] = 0;

            this.gaclan[b] = "";

            this.gvclan[b] = "";

            this.gascore[b] = 0;

            this.gvscore[b] = 0;

            this.gwtyp[b] = 0;

        }


        for (b = 0; b < 'È'; b++) {


            this.pnames[b] = "";

            this.pcars[b] = 0;

            this.pcarnames[b] = "";

            this.pgames[b] = -1;

            this.pclan[b] = "";

            for (byte b1 = 0; b1 < 6; ) {
                this.pcols[b][b1] = 0.0F;
                b1++;
            }


        }

        this.ongame = -1;

        this.join = -1;

        this.onjoin = -1;

        this.chalngd = -1;

        this.dispcar = -1;

        this.forcar = -1;

        this.chalby = "";

        this.im = 0;

        this.fstart = false;

        this.updatec = -1;

        this.prevloaded = -1;

        this.spos = 0;

        this.spos2 = 0;

        this.spos3 = 0;

        this.ngm = 0;

        this.npo = 0;

        this.fase = 1;

        this.lloaded = false;

        this.lg.gamec = -1;


        try {

            this.socket = new Socket(this.xt.server, this.xt.servport);

            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

            this.dout = new PrintWriter(this.socket.getOutputStream(), true);

        } catch (Exception exception) {
        }


        this.conon = 1;

        this.connector = new Thread(this);
        this.connector.start();

    }


    public void run() {

        int i = -1;


        while (this.conon == 1) {


            Date date = new Date();
            long l1 = date.getTime();


            if (!this.lloaded) this.gs.setCursor(new Cursor(3));


            if (!this.xt.logged && !this.xt.lan && this.xt.nfreeplays - this.xt.ndisco >= 5) {


                if (this.join >= 0) {
                    this.join = -1;
                    this.regnow = true;
                }

                if (this.pgames[this.im] != -1) {
                    this.join = -2;
                    this.regnow = true;
                }


            }

            if ((this.join >= 0 || this.pgames[this.im] != -1) && !this.regnow) {


                byte b1 = -1;
                byte b2;

                for (b2 = 0; b2 < this.ngm; ) {
                    if (this.join == this.gnum[b2] || this.pgames[this.im] == this.gnum[b2]) b1 = b2;
                    b2++;
                }

                if (b1 != -1) {


                    b2 = 0;

                    this.ontyp = 0;

                    if (this.gcrs[b1] == 1 && this.pcars[this.im] < 16) {
                        b2 = 1;
                        this.ontyp = 10;
                        if (this.gclss[b1] > 0 && this.gclss[b1] <= 5) this.ontyp += this.gclss[b1];
                    }

                    if (this.gcrs[b1] == 2 && this.pcars[this.im] >= 16) {
                        b2 = 1;
                        this.ontyp = 20;
                        if (this.gclss[b1] > 0 && this.gclss[b1] <= 5) this.ontyp += this.gclss[b1];
                    }

                    if (this.gcrs[b1] == 1 && this.gwarb[b1] != 0 && this.xt.sc[0] != 36) {
                        b2 = 1;
                        this.ontyp = 30;
                        if (this.gclss[b1] > 0 && this.gclss[b1] <= 5) this.ontyp += this.gclss[b1];
                    }

                    if (this.gclss[b1] > 0 && this.gclss[b1] <= 5 && Math.abs(this.cd.cclass[this.pcars[this.im]] - this.gclss[b1] - 1) > 1) {
                        b2 = 1;
                        if (this.gcrs[b1] == 1) if (this.gwarb[b1] == 0) {
                            this.ontyp = 10;
                        } else {
                            this.ontyp = 30;
                        }
                        if (this.gcrs[b1] == 2) this.ontyp = 20;
                        this.ontyp += this.gclss[b1];
                    }

                    if (this.gclss[b1] <= -2 && this.pcars[this.im] != Math.abs(this.gclss[b1] + 2)) {
                        b2 = 1;
                        this.ontyp = this.gclss[b1];
                    }

                    if (this.gstgn[b1] == -2 && !this.xt.logged) {
                        b2 = 1;
                        this.ontyp = 76;
                    }


                    if (b2 != 0) {
                        this.onjoin = this.gnum[b1];
                        this.jflexo = false;
                        if (this.join >= 0) this.join = -1;
                        if (this.pgames[this.im] != -1) this.join = -2;
                    }


                }

            }

            if (this.xt.onjoin != -1) {
                this.join = this.xt.onjoin;
                this.ongame = this.xt.onjoin;
                this.xt.onjoin = -1;
            }


            if (this.updatec < -17) this.updatec = -17;

            boolean bool1 = false;


            if (this.lloaded) {
                i = this.pgames[this.im];
                if (i != -1) for (byte b1 = 0; b1 < this.ngm; ) {
                    if (i == this.gnum[b1]) {
                        this.laps = this.gnlaps[b1];
                        this.stage = this.gstgn[b1];
                        this.stagename = this.gstages[b1];
                        this.nfix = this.gfx[b1];
                        if (this.gntb[b1] == 1) {
                            this.notb = true;
                        } else {
                            this.notb = false;
                        }
                    }
                    b1++;
                }

            }

            String str1 = "" + this.xt.sc[0] + "";
            if (this.xt.sc[0] >= 16) str1 = "C" + this.cd.names[this.xt.sc[0]] + "";


            String str2 = "1|" + this.xt.nickname + ":" + this.xt.nickey + "|" + this.xt.clan + "|" + this.xt.clankey + "|" + str1 + "|" + this.join + "|" + (int) (this.xt.arnp[0] * 100.0F) + "|" + (int) (this.xt.arnp[1] * 100.0F) + "|" + (int) (this.xt.arnp[2] * 100.0F) + "|" + (int) (this.xt.arnp[3] * 100.0F) + "|" + (int) (this.xt.arnp[4] * 100.0F) + "|" + (int) (this.xt.arnp[5] * 100.0F) + "|" + this.ongame + "|";

            if (!this.xt.lan) {
                str2 = str2 + "" + this.updatec + "|";
                if (this.updatec <= -11) {
                    for (byte b1 = 0; b1 < -this.updatec - 10; ) {
                        str2 = str2 + "" + this.cnames[6 - b1] + "|" + this.sentn[6 - b1] + "|";
                        b1++;
                    }
                    this.updatec = -2;
                }
            } else {
                String str = "Nonex";
                try {
                    str = InetAddress.getLocalHost().getHostName();
                    if (str.indexOf("|") != -1) str = InetAddress.getLocalHost().getHostAddress();
                } catch (Exception exception) {
                    str = "Nonex";
                }
                boolean bool = false;
                if (this.xt.logged) bool = true;
                str2 = str2 + "" + str + "|" + bool + "|";
            }

            if (this.fstart) {
                str2 = str2 + "3|";
                bool1 = true;
            }

            if (this.chalngd == -5 && !this.fstart) {


                str2 = str2 + "11|" + this.gstage + "|" + this.gstagename + "|" + this.gstagelaps + "|" + this.gnpls + "|" + this.gwait + "|" + this.pnames[this.im] + "|" + this.gcars + "|" + this.gclass + "|" + this.gfix + "|" + this.gnotp + "|" + this.gplayers + "|";
                if (this.xt.lan) str2 = str2 + "" + this.gnbts + "|";

            }

            if (this.ongame != -1 && this.chalngd != -5 && !this.fstart) {
                boolean bool;
                byte b1;
                for (bool = false, b1 = 0; b1 < 7; ) {
                    if (!this.invos[b1].equals("") && !this.dinvi[b1].equals(this.invos[b1])) {
                        if (!bool) {
                            str2 = str2 + "2|" + this.ongame + "|";
                            bool = true;
                        }
                        str2 = str2 + "" + this.invos[b1] + "|";
                        this.dinvi[b1] = this.invos[b1];
                    }
                    b1++;
                }

            }

            String str3 = "";


            boolean bool2 = false;

            try {
                this.dout.println(str2);
                str3 = this.din.readLine();
                if (str3 == null) bool2 = true;
            } catch (Exception exception) {
                bool2 = true;
            }

            if (bool2) {


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

                    this.socket = new Socket(this.xt.server, this.xt.servport);

                    this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

                    this.dout = new PrintWriter(this.socket.getOutputStream(), true);

                    this.dout.println(str2);

                    str3 = this.din.readLine();

                    if (str3 != null) bool2 = false;


                } catch (Exception exception) {
                }

            }

            if (bool2) {
                try {
                    this.socket.close();
                    this.socket = null;
                } catch (Exception exception) {
                }
                this.conon = 0;
                this.lg.exitfromlobby();
                hideinputs();
                this.connector.stop();
            }

            if (this.regnow && this.join == -2) this.join = -1;


            this.npo = getvalue(str3, 0);

            if (this.npo < 0) this.npo = 0;

            this.im = getvalue(str3, 1);

            if (this.im < 0) this.im = 0;

            int j;

            for (j = 0; j < this.npo; j++) {


                this.pnames[j] = getSvalue(str3, 2 + j * 10);
                if (this.pnames[j].equals("")) this.pnames[j] = "Unknown";


                String str = getSvalue(str3, 3 + j * 10);

                if (str.startsWith("C")) {
                    this.pcarnames[j] = str.substring(1);

                    if (!this.pcarnames[j].equals("")) {
                        byte b1 = 0;
                        byte b2;

                        for (b2 = 16; b2 < 56; ) {
                            if (this.pcarnames[j].equals(this.cd.names[b2])) {
                                b1 = b2;
                                break;
                            }
                            b2++;
                        }

                        if (b1 == 0) {
                            this.pcars[j] = -1;
                            byte b3;

                            for (b2 = 0, b3 = 0; b3 < this.cd.nl; ) {
                                if (this.pcarnames[j].equals(this.cd.loadnames[b3])) b2 = 1;
                                b3++;
                            }

                            if (b2 == 0 && this.cd.nl < 20 && this.cd.nl >= 0) {
                                this.cd.loadnames[this.cd.nl] = this.pcarnames[j];
                                this.cd.nl++;
                            }

                            this.cd.sparkcarloader();
                        } else {
                            this.pcars[j] = b1;
                        }
                    } else {
                        this.pcars[j] = 0;
                        this.pcarnames[j] = this.cd.names[this.pcars[j]];
                    }
                } else {
                    this.pcars[j] = getvalue(str3, 3 + j * 10);
                    if (this.pcars[j] == -1) this.pcars[j] = 0;
                    this.pcarnames[j] = this.cd.names[this.pcars[j]];
                }


                this.pclan[j] = getSvalue(str3, 4 + j * 10);

                this.pgames[j] = getvalue(str3, 5 + j * 10);

                this.pcols[j][0] = getvalue(str3, 6 + j * 10) / 100.0F;
                if (this.pcols[j][0] == -1.0F) this.pcols[j][0] = 0.0F;

                this.pcols[j][1] = getvalue(str3, 7 + j * 10) / 100.0F;
                if (this.pcols[j][1] == -1.0F) this.pcols[j][1] = 0.0F;

                this.pcols[j][2] = getvalue(str3, 8 + j * 10) / 100.0F;
                if (this.pcols[j][2] == -1.0F) this.pcols[j][2] = 0.0F;

                this.pcols[j][3] = getvalue(str3, 9 + j * 10) / 100.0F;
                if (this.pcols[j][3] == -1.0F) this.pcols[j][3] = 0.0F;

                this.pcols[j][4] = getvalue(str3, 10 + j * 10) / 100.0F;
                if (this.pcols[j][4] == -1.0F) this.pcols[j][4] = 0.0F;

                this.pcols[j][5] = getvalue(str3, 11 + j * 10) / 100.0F;
                if (this.pcols[j][5] == -1.0F) this.pcols[j][5] = 0.0F;


            }

            j = 12 + (this.npo - 1) * 10;


            this.ngm = getvalue(str3, j);

            if (this.ngm < 0) this.ngm = 0;


            byte b = 12;
            if (this.xt.lan) b = 13;

            int k;

            for (k = 0; k < this.ngm; k++) {


                this.gnum[k] = getvalue(str3, j + 1 + k * b);

                this.gstgn[k] = getvalue(str3, j + 2 + k * b);
                this.gstgn[k] = Math.abs(this.gstgn[k]);
                if (this.gstgn[k] > 100) this.gstgn[k] = -2;

                this.gstages[k] = getSvalue(str3, j + 3 + k * b);

                this.gnlaps[k] = getvalue(str3, j + 4 + k * b);

                this.mnpls[k] = getvalue(str3, j + 5 + k * b);

                this.wait[k] = getvalue(str3, j + 6 + k * b);

                this.gmaker[k] = getSvalue(str3, j + 7 + k * b);

                this.gcrs[k] = getvalue(str3, j + 8 + k * b);

                this.gclss[k] = getvalue(str3, j + 9 + k * b);

                this.gfx[k] = getvalue(str3, j + 10 + k * b);

                this.gntb[k] = getvalue(str3, j + 11 + k * b);

                this.gplyrs[k] = getSvalue(str3, j + 12 + k * b);

                if (this.gplyrs[k].startsWith("#warb#")) {
                    this.gwarb[k] = getHvalue(this.gplyrs[k], 2);
                    this.gwarbnum[k] = getHSvalue(this.gplyrs[k], 3);
                    this.gameturn[k] = getHvalue(this.gplyrs[k], 4);
                    this.gaclan[k] = getHSvalue(this.gplyrs[k], 5);
                    this.gvclan[k] = getHSvalue(this.gplyrs[k], 6);
                    this.gascore[k] = getHvalue(this.gplyrs[k], 7);
                    this.gvscore[k] = getHvalue(this.gplyrs[k], 8);
                    this.gwtyp[k] = getHvalue(this.gplyrs[k], 9);
                    if (this.gwtyp[k] < 1 || this.gwtyp[k] > 5) this.gwtyp[k] = 1;
                    this.gplyrs[k] = "";
                } else {
                    this.gwarb[k] = 0;
                    this.gwarbnum[k] = "";
                    this.gameturn[k] = 0;
                    this.gaclan[k] = "";
                    this.gvclan[k] = "";
                    this.gascore[k] = 0;
                    this.gvscore[k] = 0;
                    this.gwtyp[k] = 0;
                }


                if (this.xt.lan) this.mnbts[k] = getvalue(str3, j + 13 + k * b);

                if (this.xt.playingame > -1 && this.xt.playingame == this.gnum[k] && !this.xt.lan)
                    this.ongame = this.gnum[k];

                if (i == this.gnum[k] && this.wait[k] == 0 && this.lloaded && i != -1) {


                    for (byte b1 = 0; b1 < this.npo; ) {
                        if (this.pgames[b1] == this.gnum[k] && this.pnames[b1].equals(this.xt.nickname)) {
                            this.im = b1;
                            break;
                        }
                        b1++;
                    }

                    this.conon = 2;
                    this.gs.setCursor(new Cursor(3));

                }

            }


            for (k = 0; k < this.ngm; ) {
                byte b1;
                for (this.npls[k] = 0, b1 = 0; b1 < this.npo; ) {
                    if (this.pgames[b1] == this.gnum[k]) this.npls[k] = this.npls[k] + 1;
                    b1++;
                }
                k++;
            }


            if (this.conon != 0 && this.xt.playingame != -1) this.xt.playingame = -1;

            if (this.ongame != -1) {
                byte b1;
                for (k = 0, b1 = 0; b1 < this.ngm; ) {
                    if (this.ongame == this.gnum[b1]) k = 1;
                    b1++;
                }
                if (k == 0) this.britchl = -1;
            }

            if (this.join > -1) {
                byte b1;
                for (k = 0, b1 = 0; b1 < this.ngm; ) {
                    if (this.join == this.gnum[b1]) k = 1;
                    b1++;
                }
                if (k == 0) this.join = -1;
            }

            for (k = 0; k < this.npo; ) {
                if (this.pgames[k] != -1) {
                    boolean bool;
                    byte b1;
                    for (bool = false, b1 = 0; b1 < this.ngm; ) {
                        if (this.pgames[k] == this.gnum[b1]) bool = true;
                        b1++;
                    }
                    if (!bool) this.pgames[k] = -1;
                }
                k++;
            }


            if (this.xt.lan) {
                j += 14 + (this.ngm - 1) * 13;
            } else {
                j += 13 + (this.ngm - 1) * 12;
            }


            if (!this.xt.lan) {


                k = getvalue(str3, j);

                int n = getvalue(str3, j + 1);

                j += 2;

                if (this.updatec != k && this.updatec >= -2 && n == this.ongame) {


                    for (byte b1 = 0; b1 < 7; ) {
                        this.cnames[b1] = getSvalue(str3, j + b1 * 2);
                        this.sentn[b1] = getSvalue(str3, j + 1 + b1 * 2);
                        b1++;
                    }

                    this.updatec = k;

                    if (this.ongame == -1) this.spos3 = 28;

                    j += 14;

                }

                if (this.ongame != -1) {


                    if (this.prevloaded != -1) this.prevloaded = -1;

                    boolean bool = false;
                    byte b1;

                    for (b1 = 0; b1 < this.ngm; ) {
                        if (this.ongame == this.gnum[b1] && this.wait[b1] <= 0) bool = true;
                        b1++;
                    }

                    if (bool) {


                        this.prevloaded = getvalue(str3, j);
                        j++;

                        if (this.prevloaded == 1) {

                            this.prnpo = getvalue(str3, j);
                            j++;

                            for (b1 = 0; b1 < this.prnpo; ) {
                                this.prnames[b1] = getSvalue(str3, j);
                                j++;
                                b1++;
                            }

                            for (b1 = 0; b1 < this.prnpo; ) {
                                this.ppos[b1] = getvalue(str3, j);
                                j++;
                                b1++;
                            }

                            for (b1 = 0; b1 < this.prnpo; ) {
                                this.plap[b1] = getvalue(str3, j);
                                j++;
                                b1++;
                            }

                            for (b1 = 0; b1 < this.prnpo; ) {
                                this.ppow[b1] = (int) (getvalue(str3, j) / 9800.0F * 55.0F);
                                j++;
                                b1++;
                            }

                            for (b1 = 0; b1 < this.prnpo; ) {
                                int i1 = getvalue(str3, j);
                                if (i1 != -17) {
                                    this.pdam[b1] = (int) (i1 / 100.0F * 55.0F);
                                } else {
                                    this.pdam[b1] = -17;
                                }
                                j++;
                                b1++;
                            }

                            this.stuntname = getSvalue(str3, j);
                            j++;

                            this.lapsname = getSvalue(str3, j);
                            j++;

                            this.wastename = getSvalue(str3, j);
                            j++;

                        }


                    }

                }

            } else {


                k = getvalue(str3, j);

                if (k == 1) {
                    this.lanlogged = true;
                } else {
                    this.lanlogged = false;
                }

                j++;

            }


            k = getvalue(str3, j);


            if (k != -1) {

                byte b1;
                byte b2;

                for (b1 = 0, b2 = 0; b2 < this.ngm; ) {
                    if (k == this.gnum[b2]) b1 = b2;
                    b2++;
                }

                b2 = 0;
                if (this.gwarb[b1] != 0) {
                    if (this.xt.clan.toLowerCase().equals(this.gaclan[b1].toLowerCase()) || this.xt.clan.toLowerCase().equals(this.gvclan[b1].toLowerCase()))
                        b2 = 1;
                } else {
                    b2 = 1;
                }


                if ((this.pgames[this.im] != this.ongame || this.ongame == -1) && k != this.ongame && this.chalngd == -1 && this.join == -1 && this.fase == 1 && this.wait[b1] > 0 && b2 != 0) {


                    this.chalngd = k;

                    this.chalby = getSvalue(str3, j + 1);

                    this.cflk = 20;

                    this.ctime = 20;

                    this.ptime = 0L;

                    this.longame = this.ongame;

                    if (this.gs.rooms.open) this.gs.rooms.open = false;

                    if (this.ongame != -1) this.britchl = -1;

                }

                j++;

            }


            if (!this.xt.lan) {


                byte b1 = 1;
                byte b2;

                for (b2 = 1; b2 < 6; b2++) {


                    if (b2 != this.xt.servport - 7070) {


                        int n = getvalue(str3, j + b2);

                        if (n != -1) {


                            this.gs.rooms.sopts[b1] = "Room " + b2 + "  ::  " + n + "";


                            this.gs.rooms.opts[b1] = "";

                            this.gs.rooms.iroom[b1] = b2;

                            b1++;

                        }

                    }

                }

                for (b2 = 0; b2 < this.lg.nservers; b2++) {


                    if (!this.xt.server.equals(this.lg.servers[b2]) && this.xt.delays[b2] < 300) {


                        this.gs.rooms.sopts[b1] = ":: " + this.lg.snames[b2] + "";

                        this.gs.rooms.opts[b1] = "";

                        this.gs.rooms.iroom[b1] = 1000 + b2;

                        b1++;

                    }

                }

                this.gs.rooms.no = b1;

            }


            if (this.join > -1) {
                boolean bool;
                byte b1;
                for (bool = false, b1 = 0; b1 < this.ngm; ) {
                    if (this.join == this.gnum[b1] && this.wait[b1] == 0) bool = true;
                    b1++;
                }
                if (this.pgames[this.im] == this.join || bool) {
                    this.join = -1;
                    this.nflk = 3;
                }
            }

            if (this.join == -2) {
                boolean bool;
                byte b1;
                for (bool = false, b1 = 0; b1 < this.ngm; ) {
                    if (this.pgames[this.im] == this.gnum[b1] && this.wait[b1] == 0) bool = true;
                    b1++;
                }
                if (this.pgames[this.im] == -1 || bool) {
                    this.join = -1;
                    if (!bool) this.ongame = -1;
                }

            }

            if (this.chalngd == -5 && this.pgames[this.im] != -1) {
                this.ongame = this.pgames[this.im];
                this.chalngd = -1;
                if (!this.xt.lan && this.gplayers.equals("")) this.lg.gamealert();
            }


            if (this.fstart && bool1) this.fstart = false;


            this.rerr = 0;

            if (!this.lloaded) {
                this.gs.setCursor(new Cursor(0));
                this.lloaded = true;
            }


            if (!this.gb.domon) {
                this.gb.roomlogos(this.pnames, this.npo);

                if (this.ongame == -1) {
                    if (this.cntchkn == 5) this.lg.checkgamealerts();
                } else if (this.lg.gamec != -1) {
                    this.lg.gamec = -1;
                }

                if (this.cntchkn == 5) {
                    this.lg.checknotifcations();
                    this.cntchkn = 0;
                } else {
                    this.cntchkn++;
                }
            } else if (this.lg.gamec != -1) {
                this.lg.gamec = -1;
            }


            date = new Date();
            long l2 = date.getTime();


            int m = 700 - (int) (l2 - l1);
            if (m < 50) m = 50;

            try {
                Thread.sleep(m);
            } catch (InterruptedException interruptedException) {
            }

        }


        if (this.conon == 2) {


            byte b = 20;

            this.xt.playingame = -1;


            while (b != 0) {


                String str1 = "2|" + i + "|";

                String str2 = "";


                boolean bool = false;

                try {
                    this.dout.println(str1);
                    str2 = this.din.readLine();
                    if (str2 == null) bool = true;
                } catch (Exception exception) {
                    bool = true;
                }

                if (bool) {


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

                        this.socket = new Socket(this.xt.server, this.xt.servport);

                        this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

                        this.dout = new PrintWriter(this.socket.getOutputStream(), true);

                        this.dout.println(str1);

                        str2 = this.din.readLine();

                        if (str2 != null) bool = false;


                    } catch (Exception exception) {
                    }

                }

                if (bool) {
                    try {
                        this.socket.close();
                        this.socket = null;
                    } catch (Exception exception) {
                    }
                    this.conon = 0;
                    this.lg.exitfromlobby();
                    hideinputs();
                    this.connector.stop();
                }


                if (!this.xt.lan) {


                    this.xt.gameport = getvalue(str2, 0);

                } else {


                    this.xt.gameport = -1;

                    this.xt.localserver = getSevervalue(str2, 0);

                    if (!this.xt.localserver.equals("")) this.xt.gameport = 0;


                }


                if (this.xt.gameport != -1) {
                    byte b1 = 0;

                    this.xt.im = -1;

                    this.xt.nplayers = getvalue(str2, 1);
                    if (this.xt.nplayers < 1) this.xt.nplayers = 1;
                    if (this.xt.nplayers > 8) this.xt.nplayers = 8;
                    int j;

                    for (j = 0; j < this.xt.nplayers; ) {
                        this.xt.plnames[j] = getSvalue(str2, 2 + j);
                        if (this.xt.nickname.equals(this.xt.plnames[j])) this.xt.im = j;
                        j++;
                    }

                    j = 2 + this.xt.nplayers;

                    byte b2;

                    for (b2 = 0; b2 < this.xt.nplayers; b2++) {


                        String str = getSvalue(str2, j + b2);

                        if (str.startsWith("C")) {
                            str = str.substring(1);

                            if (!str.equals("")) {
                                byte b3 = 0;
                                byte b4;

                                for (b4 = 16; b4 < 56; ) {
                                    if (str.equals(this.cd.names[b4])) {
                                        b3 = b4;
                                        break;
                                    }
                                    b4++;
                                }

                                while (b3 == 0 && b1 < 100) {

                                    byte b5;

                                    for (b4 = 0, b5 = 0; b5 < this.cd.nl; ) {
                                        if (str.equals(this.cd.loadnames[b5])) b4 = 1;
                                        b5++;
                                    }

                                    if (b4 == 0 && this.cd.nl < 20) {
                                        this.cd.loadnames[this.cd.nl] = str;
                                        this.cd.nl++;
                                    }

                                    this.cd.sparkcarloader();

                                    try {
                                        Thread.sleep(100L);
                                    } catch (InterruptedException interruptedException) {
                                    }

                                    for (b5 = 16; b5 < 56; ) {
                                        if (str.equals(this.cd.names[b5])) b3 = b5;
                                        b5++;
                                    }

                                    b1++;

                                }

                                if (b3 != 0) {
                                    for (this.xt.sc[b2] = b3, b4 = 0; b4 < this.npo; ) {
                                        if (this.pcarnames[b4].equals(str)) this.pcars[b4] = b3;
                                        b4++;
                                    }
                                } else {
                                    this.xt.im = -1;
                                }
                            } else {
                                this.xt.im = -1;
                            }
                        } else {
                            this.xt.sc[b2] = getvalue(str2, j + b2);
                            if (this.xt.sc[b2] == -1) this.xt.im = -1;
                        }


                    }

                    j += this.xt.nplayers;

                    for (b2 = 0; b2 < this.xt.nplayers; ) {
                        this.xt.xstart[b2] = getvalue(str2, j + b2);
                        b2++;
                    }

                    j += this.xt.nplayers;

                    for (b2 = 0; b2 < this.xt.nplayers; ) {
                        this.xt.zstart[b2] = getvalue(str2, j + b2);
                        b2++;
                    }

                    j += this.xt.nplayers;

                    for (b2 = 0; b2 < this.xt.nplayers; ) {
                        for (byte b3 = 0; b3 < 6; ) {
                            this.xt.allrnp[b2][b3] = getvalue(str2, j + b2 * 6 + b3) / 100.0F;
                            b3++;
                        }
                        b2++;
                    }


                    if (this.xt.im != -1) {
                        byte b3;

                        for (this.xt.playingame = i, b2 = 0, b3 = 0; b3 < this.ngm; ) {
                            if (i == this.gnum[b3]) b2 = b3;
                            b3++;
                        }

                        if (this.gwarb[b2] != 0) {
                            for (this.xt.clangame = this.gwtyp[b2], this.xt.clanchat = true, this.xt.gaclan = this.gaclan[b2], b3 = 0; b3 < this.xt.nplayers; ) {
                                for (byte b4 = 0; b4 < this.npo; ) {
                                    if (this.xt.plnames[b3].equals(this.pnames[b4]) && this.pgames[b4] == i)
                                        this.xt.pclan[b3] = this.pclan[b4];
                                    b4++;
                                }
                                b3++;
                            }
                        } else {
                            this.xt.clangame = 0;
                        }
                    } else {
                        this.xt.playingame = -1;
                        this.xt.im = 0;
                    }


                    b = 0;
                } else {
                    b--;
                }


                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException interruptedException) {
                }

            }


            try {
                this.socket.close();
                this.socket = null;
                this.din.close();
                this.din = null;
                this.dout.close();
                this.dout = null;
            } catch (Exception exception) {
            }


            if (this.xt.playingame != -1) {
                if (!this.xt.lan && !this.xt.logged) {


                    this.xt.nfreeplays++;


                    try {

                        this.socket = new Socket(this.lg.servers[0], 7061);

                        this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

                        this.dout = new PrintWriter(this.socket.getOutputStream(), true);

                        this.dout.println("7|" + this.xt.nfreeplays + "|");

                        String str = this.din.readLine();

                        this.xt.hours = getvalue(str, 0);

                        this.socket.close();
                        this.socket = null;
                        this.din.close();
                        this.din = null;
                        this.dout.close();
                        this.dout = null;

                    } catch (Exception exception) {
                    }

                }


                hideinputs();

                this.xt.multion = 1;
                this.fase = 76;

                System.gc();
            } else {
                inishlobby();
            }


        }


        if (this.conon == 3) {


            byte b = 20;

            this.xt.playingame = -1;


            while (b != 0) {


                String str1 = "4|" + this.ongame + "|";

                String str2 = "";


                boolean bool = false;

                try {
                    this.dout.println(str1);
                    str2 = this.din.readLine();
                    if (str2 == null) bool = true;
                } catch (Exception exception) {
                    bool = true;
                }

                if (bool) {


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

                        this.socket = new Socket(this.xt.server, this.xt.servport);

                        this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

                        this.dout = new PrintWriter(this.socket.getOutputStream(), true);

                        this.dout.println(str1);

                        str2 = this.din.readLine();

                        if (str2 != null) bool = false;


                    } catch (Exception exception) {
                    }

                }

                if (bool) {
                    try {
                        this.socket.close();
                        this.socket = null;
                    } catch (Exception exception) {
                    }
                    this.conon = 0;
                    this.lg.exitfromlobby();
                    hideinputs();
                    this.connector.stop();
                }


                if (!this.xt.lan) {


                    this.xt.gameport = getvalue(str2, 0);

                } else {


                    this.xt.gameport = -1;

                    this.xt.localserver = getSevervalue(str2, 0);

                    if (!this.xt.localserver.equals("")) this.xt.gameport = 0;


                }

                if (this.xt.gameport != -1) {
                    byte b1 = 0;

                    this.xt.nplayers = getvalue(str2, 1);
                    if (this.xt.nplayers < 1) this.xt.nplayers = 1;
                    if (this.xt.nplayers > 8) this.xt.nplayers = 8;

                    this.xt.im = getvalue(str2, 2) + this.xt.nplayers;
                    int j;

                    for (j = 0; j < this.xt.nplayers; ) {
                        this.xt.plnames[j] = getSvalue(str2, 3 + j);
                        j++;
                    }

                    j = 3 + this.xt.nplayers;

                    byte b2;

                    for (b2 = 0; b2 < this.xt.nplayers; b2++) {


                        String str = getSvalue(str2, j + b2);

                        if (str.startsWith("C")) {
                            str = str.substring(1);

                            if (!str.equals("")) {
                                byte b3 = 0;
                                byte b4;

                                for (b4 = 16; b4 < 56; ) {
                                    if (str.equals(this.cd.names[b4])) {
                                        b3 = b4;
                                        break;
                                    }
                                    b4++;
                                }

                                while (b3 == 0 && b1 < 100) {

                                    byte b5;

                                    for (b4 = 0, b5 = 0; b5 < this.cd.nl; ) {
                                        if (str.equals(this.cd.loadnames[b5])) b4 = 1;
                                        b5++;
                                    }

                                    if (b4 == 0 && this.cd.nl < 20) {
                                        this.cd.loadnames[this.cd.nl] = str;
                                        this.cd.nl++;
                                    }

                                    this.cd.sparkcarloader();

                                    try {
                                        Thread.sleep(100L);
                                    } catch (InterruptedException interruptedException) {
                                    }

                                    for (b5 = 16; b5 < 56; ) {
                                        if (str.equals(this.cd.names[b5])) b3 = b5;
                                        b5++;
                                    }

                                    b1++;

                                }

                                if (b3 != 0) {
                                    for (this.xt.sc[b2] = b3, b4 = 0; b4 < this.npo; ) {
                                        if (this.pcarnames[b4].equals(str)) this.pcars[b4] = b3;
                                        b4++;
                                    }
                                } else {
                                    this.xt.im = -1;
                                }
                            } else {
                                this.xt.im = -1;
                            }
                        } else {
                            this.xt.sc[b2] = getvalue(str2, j + b2);
                            if (this.xt.sc[b2] == -1) this.xt.im = -1;
                        }


                    }

                    j += this.xt.nplayers;

                    for (b2 = 0; b2 < this.xt.nplayers; ) {
                        this.xt.xstart[b2] = getvalue(str2, j + b2);
                        b2++;
                    }

                    j += this.xt.nplayers;

                    for (b2 = 0; b2 < this.xt.nplayers; ) {
                        this.xt.zstart[b2] = getvalue(str2, j + b2);
                        b2++;
                    }

                    j += this.xt.nplayers;

                    for (b2 = 0; b2 < this.xt.nplayers; ) {
                        for (byte b3 = 0; b3 < 6; ) {
                            this.xt.allrnp[b2][b3] = getvalue(str2, j + b2 * 6 + b3) / 100.0F;
                            b3++;
                        }
                        b2++;
                    }


                    if (this.xt.im >= this.xt.nplayers && this.xt.im < this.xt.nplayers + 3) {
                        byte b3;

                        for (this.xt.playingame = this.ongame, b2 = 0, b3 = 0; b3 < this.ngm; ) {
                            if (this.ongame == this.gnum[b3]) b2 = b3;
                            b3++;
                        }

                        if (this.gwarb[b2] != 0) {
                            this.xt.clangame = this.gwtyp[b2];
                            this.xt.gaclan = this.gaclan[b2];
                            if (this.xt.clan.toLowerCase().equals(this.gaclan[b2].toLowerCase()) || this.xt.clan.toLowerCase().equals(this.gvclan[b2].toLowerCase()))
                                this.xt.clanchat = true;
                            for (b3 = 0; b3 < this.xt.nplayers; ) {
                                for (byte b4 = 0; b4 < this.npo; ) {
                                    if (this.xt.plnames[b3].equals(this.pnames[b4]) && this.pgames[b4] == this.ongame)
                                        this.xt.pclan[b3] = this.pclan[b4];
                                    b4++;
                                }
                                b3++;
                            }
                        } else {
                            this.xt.clangame = 0;
                        }
                    } else {
                        this.xt.playingame = -1;
                        this.xt.im = 0;
                    }


                    b = 0;
                } else {
                    b--;
                }


                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException interruptedException) {
                }

            }


            try {
                this.socket.close();
                this.socket = null;
                this.din.close();
                this.din = null;
                this.dout.close();
                this.dout = null;
            } catch (Exception exception) {
            }

            if (this.xt.playingame != -1) {
                hideinputs();

                this.xt.multion = 3;
                this.fase = 76;

                System.gc();
            } else {
                inishlobby();
            }


        }

    }


    public void stopallnow() {

        this.conon = 0;
        try {
            this.socket.close();
            this.socket = null;
            this.din.close();
            this.din = null;
            this.dout.close();
            this.dout = null;
        } catch (Exception exception) {
        }
        if (this.connector != null) {
            this.connector.stop();
            this.connector = null;
        }


    }

    public Lobby(Medium paramMedium, Graphics2D paramGraphics2D, Login paramLogin, Globe paramGlobe, xtGraphics paramxtGraphics, CarDefine paramCarDefine, GameSparker paramGameSparker) {
        this.spos = 0;
        this.spos2 = 0;
        this.spos3 = 28;

        this.mscro = 125;
        this.lspos = 0;
        this.mscro2 = 145;
        this.lspos2 = 0;
        this.mscro3 = 345;
        this.lspos3 = 0;
        this.clicked = -1;
        this.opengame = 0;
        this.britchl = 0;

        this.zeromsw = false;

        this.mousonp = -1;
        this.cmonp = -1;

        this.ptime = 0L;

        this.pcurs = 0;

        this.grprsd = false;


        this.pend = 0;
        this.mrot = 0;

        this.pendb = false;

        this.cac = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};

        this.cax = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

        this.cay = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

        this.mousedout = false;

        this.flks = 0;

        this.waitlink = 0;

        this.pre1 = false;
        this.pre2 = false;


        this.prereq = 0;


        this.plsndt = 0;


        this.lxm = 0;
        this.lym = 0;
        this.m = paramMedium;
        this.rd = paramGraphics2D;
        this.xt = paramxtGraphics;
        this.cd = paramCarDefine;
        this.gs = paramGameSparker;
        this.lg = paramLogin;
        this.gb = paramGlobe;
        this.gs.cmsg.setBackground(color2k(240, 240, 240));
        this.gs.swait.setBackground(color2k(220, 220, 220));
        this.gs.snpls.setBackground(color2k(220, 220, 220));
        this.gs.snbts.setBackground(color2k(220, 220, 220));
        this.gs.sgame.setBackground(color2k(200, 200, 200));
        this.gs.wgame.setBackground(color2k(200, 200, 200));
        this.gs.pgame.setBackground(color2k(200, 200, 200));
        this.gs.vnpls.setBackground(color2k(200, 200, 200));
        this.gs.vtyp.setBackground(color2k(200, 200, 200));
        this.gs.warb.setBackground(color2k(200, 200, 200));
        this.gs.snfmm.setBackground(color2k(200, 200, 200));
        this.gs.snfm1.setBackground(color2k(200, 200, 200));
        this.gs.snfm2.setBackground(color2k(200, 200, 200));
        this.gs.mstgs.setBackground(color2k(230, 230, 230));
        this.gs.slaps.setBackground(color2k(200, 200, 200));
        this.gs.sclass.setBackground(color2k(220, 220, 220));
        this.gs.scars.setBackground(color2k(220, 220, 220));
        this.gs.sfix.setBackground(color2k(220, 220, 220));
        this.gs.mycar.setBackground(color2k(255, 255, 255));
        this.gs.notp.setBackground(color2k(255, 255, 255));
        this.gs.rooms.setBackground(color2k(170, 170, 170));
        this.gs.swait.setForeground(new Color(0, 0, 0));
        this.gs.snpls.setForeground(new Color(0, 0, 0));
        this.gs.snbts.setForeground(new Color(0, 0, 0));
        this.gs.sgame.setForeground(new Color(0, 0, 0));
        this.gs.wgame.setForeground(new Color(0, 0, 0));
        this.gs.pgame.setForeground(new Color(0, 0, 0));
        this.gs.vnpls.setForeground(new Color(0, 0, 0));
        this.gs.vtyp.setForeground(new Color(0, 0, 0));
        this.gs.warb.setForeground(new Color(0, 0, 0));
        this.gs.snfmm.setForeground(new Color(0, 0, 0));
        this.gs.snfm1.setForeground(new Color(0, 0, 0));
        this.gs.slaps.setForeground(new Color(0, 0, 0));
        this.gs.snfm2.setForeground(new Color(0, 0, 0));
        this.gs.mstgs.setForeground(new Color(0, 0, 0));
        this.gs.sclass.setForeground(new Color(0, 0, 0));
        this.gs.scars.setForeground(new Color(0, 0, 0));
        this.gs.sfix.setForeground(new Color(0, 0, 0));
        this.gs.mycar.setForeground(new Color(0, 0, 0));
        this.gs.notp.setForeground(new Color(0, 0, 0));
        this.gs.rooms.setForeground(new Color(0, 0, 0));
        this.gs.sgame.removeAll();
        this.gs.sgame.add(this.rd, " NFM Multiplayer ");
        this.gs.sgame.add(this.rd, " NFM 2     ");
        this.gs.sgame.add(this.rd, " NFM 1     ");
        this.gs.sgame.add(this.rd, " My Stages ");

        this.gs.sgame.add(this.rd, " My Clan Stages ");

        this.gs.sgame.add(this.rd, " Weekly Top 20 ");

        this.gs.sgame.add(this.rd, " Monthly Top 20 ");
    }

    public void lobby(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, CheckPoints paramCheckPoints, Control paramControl, ContO[] paramArrayOfContO) { // Byte code:

        //public void ctachm ( int paramInt1, int paramInt2, int paramInt3, Control paramControl){
            byte b = -1;
            /*      */
            /* 2750 */
            if (this.fase == 1 || this.fase == 4)
                /*      */ {
                /* 2752 */
                for (byte b1 = 0; b1 < this.btn; b1++) {
                    /*      */
                    /* 2754 */
                    if (Math.abs(paramInt1 - this.bx[b1]) < this.bw[b1] / 2 + 12 && Math.abs(paramInt2 - this.by[b1]) < 14 && (paramInt3 == 1 || paramInt3 == 11)) {
                        this.pessd[b1] = true;
                    } else {
                        this.pessd[b1] = false;
                    }
                    /* 2755 */
                    if (Math.abs(paramInt1 - this.bx[b1]) < this.bw[b1] / 2 + 12 && Math.abs(paramInt2 - this.by[b1]) < 14 && paramInt3 <= -1) {
                        b = b1;
                        this.gs.mouses = 0;
                    }
                    /*      */
                    /*      */
                }
                /*      */
            }
            /* 2759 */
            if (this.conon == 1)
                /*      */ {
                /* 2761 */
                if (!this.regnow) {
                    /*      */
                    /* 2763 */
                    if (this.onjoin == -1) {
                        /*      */
                        /*      */
                        /* 2766 */
                        if (this.fase == 4) {
                            /*      */
                            /* 2768 */
                            if (paramInt1 > 532 && paramInt1 < 592 && paramInt2 > 285 && paramInt2 < 306 && (paramInt3 == 1 || paramInt3 == 11)) {
                                this.pback = 1;
                            } else {
                                this.pback = 0;
                            }
                            /* 2769 */
                            if (paramInt1 > 532 && paramInt1 < 592 && paramInt2 > 285 && paramInt2 < 306 && paramInt3 <= -1) {
                                this.gs.mouses = 0;
                                this.m.trk = 0;
                                if (this.xt.loadedt) this.xt.strack.unload();
                                this.m.focus_point = 400;
                                this.m.crs = true;
                                this.m.x = -335;
                                this.m.y = 0;
                                this.m.z = -50;
                                this.m.xz = 0;
                                this.m.zy = 20;
                                this.m.ground = -2000;
                                this.fase = 1;
                            }
                            /* 2770 */
                            if (b == 0 && this.chalngd == -1) {
                                b = -1;
                                this.join = this.ongame;
                                this.msg = "| Joining Game |";
                                this.spos = 0;
                                this.m.trk = 0;
                                if (this.xt.loadedt) this.xt.strack.unload();
                                this.m.focus_point = 400;
                                this.m.crs = true;
                                this.m.x = -335;
                                this.m.y = 0;
                                this.m.z = -50;
                                this.m.xz = 0;
                                this.m.zy = 20;
                                this.m.ground = -2000;
                                this.fase = 1;
                            }
                            /*      */
                            /*      */
                        }
                        /* 2773 */
                        if (this.fase == 1)
                            /*      */ {
                            /* 2775 */
                            if (this.ongame == -1) {
                                /*      */
                                /* 2777 */
                                if (b == 0) if (this.chalngd == -1) {
                                    if (this.xt.lan && !this.lanlogged) {
                                        this.gs.reglink();
                                    }
                                    /*      */
                                    else
                                        /* 2779 */ {
                                        boolean bool;
                                        byte b2;
                                        for (bool = false, b2 = 0; b2 < this.ngm; ) {
                                            if (this.wait[b2] == 0) {
                                                bool = true;
                                                break;
                                            }
                                            b2++;
                                        }
                                        /* 2780 */
                                        if (!bool || this.xt.lan) {
                                            this.loadstage = 0;
                                            this.remstage = 0;
                                            this.gstage = 0;
                                            this.gnpls = 8;
                                            this.gwait = 0;
                                            this.gnbts = 0;
                                            this.gclass = 0;
                                            this.gcars = 0;
                                            this.gfix = 0;
                                            this.gnotp = 0;
                                            this.gplayers = "";
                                            this.gs.wgame.select(0);
                                            this.chalngd = -2;
                                        } else {
                                            this.chalngd = -6;
                                        }
                                    }
                                }
                                /* 2781 */
                                else if (this.chalngd != -5) {
                                    if (this.invo) this.invo = false;
                                    for (byte b2 = 0; b2 < 7; ) {
                                        if (!this.invos[b2].equals("")) this.invos[b2] = "";
                                        if (!this.dinvi[b2].equals("")) this.dinvi[b2] = "";
                                        b2++;
                                    }
                                    this.gs.swait.hide();
                                    this.gs.snpls.hide();
                                    this.gs.snbts.hide();
                                    this.gs.sgame.hide();
                                    this.gs.wgame.hide();
                                    this.gs.pgame.hide();
                                    this.gs.vnpls.hide();
                                    this.gs.vtyp.hide();
                                    this.gs.warb.hide();
                                    this.gs.mstgs.hide();
                                    this.gs.slaps.hide();
                                    this.gs.snfm1.hide();
                                    this.gs.snfmm.hide();
                                    this.gs.snfm2.hide();
                                    this.gs.sclass.hide();
                                    this.gs.scars.hide();
                                    this.gs.sfix.hide();
                                    this.gs.mycar.hide();
                                    this.gs.notp.hide();
                                    this.gs.requestFocus();
                                    this.chalngd = -1;
                                }
                                /* 2782 */
                                if (b == 1) this.xt.fase = 23;
                                /* 2783 */
                                if (b == 2) {
                                    this.conon = 0;
                                    this.lg.exitfromlobby();
                                    try {
                                        this.socket.close();
                                        this.socket = null;
                                        this.din.close();
                                        this.din = null;
                                        this.dout.close();
                                        this.dout = null;
                                    } catch (Exception exception) {
                                    }
                                    hideinputs();
                                }
                                /*      */
                                /* 2785 */
                                byte b1 = 3;
                                /*      */
                                /* 2787 */
                                if (this.chalngd > -1) {
                                    /*      */
                                    /* 2789 */
                                    if (b == 3) {
                                        this.ongame = this.chalngd;
                                        this.chalngd = -1;
                                    }
                                    /* 2790 */
                                    if (b == 4) {
                                        this.ongame = this.chalngd;
                                        this.join = this.chalngd;
                                        this.msg = "| Joining Game |";
                                        this.chalngd = -1;
                                        this.longame = -1;
                                    }
                                    /* 2791 */
                                    if (b == 5) {
                                        this.ongame = this.longame;
                                        this.chalngd = -1;
                                        this.longame = -1;
                                    }
                                    /* 2792 */
                                    b1 = 6;
                                    /*      */
                                }
                                /*      */
                                else {
                                    /*      */
                                    /* 2796 */
                                    if (this.chalngd != -1 && this.chalngd != -5 && b == 3) {
                                        if (this.invo) this.invo = false;
                                        for (byte b2 = 0; b2 < 7; ) {
                                            if (!this.invos[b2].equals("")) this.invos[b2] = "";
                                            if (!this.dinvi[b2].equals("")) this.dinvi[b2] = "";
                                            b2++;
                                        }
                                        this.gs.swait.hide();
                                        this.gs.snpls.hide();
                                        this.gs.snbts.hide();
                                        this.gs.sgame.hide();
                                        this.gs.wgame.hide();
                                        this.gs.pgame.hide();
                                        this.gs.vnpls.hide();
                                        this.gs.vtyp.hide();
                                        this.gs.warb.hide();
                                        this.gs.mstgs.hide();
                                        this.gs.slaps.hide();
                                        this.gs.snfm1.hide();
                                        this.gs.snfmm.hide();
                                        this.gs.snfm2.hide();
                                        this.gs.sclass.hide();
                                        this.gs.scars.hide();
                                        this.gs.sfix.hide();
                                        this.gs.mycar.hide();
                                        this.gs.notp.hide();
                                        this.gs.requestFocus();
                                        this.chalngd = -1;
                                    }
                                    /*      */
                                    /* 2798 */
                                    if (this.chalngd == -6 && b == 4) this.chalngd = -1;
                                    /*      */
                                    /* 2800 */
                                    if (this.chalngd == -2)
                                        /*      */ {
                                        /* 2802 */
                                        if (this.gs.wgame.getSelectedIndex() == 0)
                                            /*      */
                                            /* 2804 */ {
                                            if (this.gs.sgame.getSelectedIndex() >= 3 && !this.xt.logged)
                                                /*      */ {
                                                /* 2806 */
                                                if (b == 4) this.gs.editlink(this.xt.nickname, true);
                                                /* 2807 */
                                                b1 = 5;
                                                /*      */
                                            }
                                            /*      */
                                            else
                                                /*      */ {
                                                /* 2811 */
                                                if (b == 4)
                                                    /*      */ {
                                                    /* 2813 */
                                                    if (this.loadstage < 0)
                                                        /*      */
                                                        /* 2815 */ {
                                                        this.rd.setColor(new Color(0, 0, 0));
                                                        this.rd.fillRect(0, 0, 670, 400);
                                                        this.gs.repaint();
                                                        /* 2816 */
                                                        this.gs.rooms.hide();
                                                        this.gs.cmsg.hide();
                                                        this.gs.sgame.hide();
                                                        this.gs.wgame.hide();
                                                        this.gs.warb.hide();
                                                        this.gs.pgame.hide();
                                                        this.gs.vnpls.hide();
                                                        this.gs.vtyp.hide();
                                                        this.gs.mstgs.hide();
                                                        this.gs.slaps.hide();
                                                        this.gs.snfm1.hide();
                                                        this.gs.snfmm.hide();
                                                        this.gs.snfm2.hide();
                                                        this.gs.requestFocus();
                                                        /* 2817 */
                                                        this.m.ptr = 0;
                                                        this.m.ptcnt = -10;
                                                        this.m.hit = 20000;
                                                        this.m.fallen = 0;
                                                        this.m.nrnd = 0;
                                                        this.m.ih = 25;
                                                        this.m.iw = 65;
                                                        this.m.h = 425;
                                                        this.m.w = 735;
                                                        this.m.trk = 4;
                                                        this.plsndt = 0;
                                                        /* 2818 */
                                                        this.addstage = 0;
                                                        /* 2819 */
                                                        this.fase = 4;
                                                    }
                                                    /* 2820 */
                                                    else {
                                                        this.sflk = 25;
                                                    }
                                                    /*      */
                                                }
                                                /* 2822 */
                                                if (this.loadstage >= 0) {
                                                    b1 = 5;
                                                } else {
                                                    if (b == 5) if (this.gstage != 0) {
                                                        this.gs.sgame.hide();
                                                        this.gs.wgame.hide();
                                                        this.gs.pgame.hide();
                                                        this.gs.vnpls.hide();
                                                        this.gs.vtyp.hide();
                                                        this.gs.warb.hide();
                                                        this.gs.mstgs.hide();
                                                        this.gs.slaps.hide();
                                                        this.gs.snfm1.hide();
                                                        this.gs.snfmm.hide();
                                                        this.gs.snfm2.hide();
                                                        this.gs.requestFocus();
                                                        this.chalngd = -3;
                                                        b = -1;
                                                    } else {
                                                        this.sflk = 25;
                                                    }
                                                    b1 = 6;
                                                }
                                                /*      */
                                                /*      */
                                                /*      */
                                            }
                                            /*      */
                                        }
                                        /* 2827 */
                                        else if (!this.xt.clan.equals(""))
                                            /*      */
                                            /*      */ {
                                            /* 2830 */
                                            byte b2 = 4;
                                            /* 2831 */
                                            if (this.gs.warb.sel != 0 && this.gb.loadwbgames == 2) {
                                                /*      */
                                                /* 2833 */
                                                if (this.gs.wgame.getSelectedIndex() == 1 && this.gs.vnpls.sel != 0)
                                                    /*      */ {
                                                    /* 2835 */
                                                    if (this.cancreate == 2) {
                                                        /*      */
                                                        /* 2837 */
                                                        if (b == 4) {
                                                            /*      */
                                                            /* 2839 */
                                                            if (this.invo) this.invo = false;
                                                            this.msg = "| Creating Game |";
                                                            /* 2840 */
                                                            this.gplayers = "#warb#" + this.gb.warb + "#" + this.gb.warbnum + "#" + (this.gb.gameturn + 1) + "#" + this.xt.clan + "#" + this.gb.vclan + "#" + this.gb.ascore + "#" + this.gb.vscore + "#" + (this.gs.vtyp.sel + 1) + "#";
                                                            /* 2841 */
                                                            this.gstage = this.gb.wbstage[this.gb.gameturn];
                                                            /* 2842 */
                                                            this.gstagelaps = this.gb.wblaps[this.gb.gameturn];
                                                            /* 2843 */
                                                            this.gcars = this.gb.wbcars[this.gb.gameturn] - 1;
                                                            /* 2844 */
                                                            this.gclass = this.gb.wbclass[this.gb.gameturn];
                                                            /* 2845 */
                                                            this.gfix = this.gb.wbfix[this.gb.gameturn];
                                                            /* 2846 */
                                                            this.gnpls = 8;
                                                            if (this.gs.vnpls.sel == 1) this.gnpls = 4;
                                                            if (this.gs.vnpls.sel == 2) this.gnpls = 6;
                                                            /* 2847 */
                                                            this.gwait = 120;
                                                            /* 2848 */
                                                            this.gnotp = 0;
                                                            /* 2849 */
                                                            this.gs.wgame.hide();
                                                            this.gs.pgame.hide();
                                                            this.gs.vnpls.hide();
                                                            this.gs.vtyp.hide();
                                                            this.gs.warb.hide();
                                                            this.gs.requestFocus();
                                                            /* 2850 */
                                                            this.chalngd = -5;
                                                            /*      */
                                                        }
                                                        /* 2852 */
                                                        b2++;
                                                        /*      */
                                                    }
                                                    /*      */
                                                }
                                                /*      */
                                                /* 2856 */
                                                if (this.gs.wgame.getSelectedIndex() == 2 && this.gs.pgame.sel != 0)
                                                    /*      */ {
                                                    /* 2858 */
                                                    if (b == 4) {
                                                        /*      */
                                                        /* 2860 */
                                                        if (this.invo) this.invo = false;
                                                        this.msg = "| Creating Game |";
                                                        /* 2861 */
                                                        this.gstage = this.gb.wbstage[this.gs.pgame.sel - 1];
                                                        /* 2862 */
                                                        this.gstagelaps = this.gb.wblaps[this.gs.pgame.sel - 1];
                                                        /* 2863 */
                                                        this.gcars = this.gb.wbcars[this.gs.pgame.sel - 1] - 1;
                                                        /* 2864 */
                                                        this.gclass = this.gb.wbclass[this.gs.pgame.sel - 1];
                                                        /* 2865 */
                                                        this.gfix = this.gb.wbfix[this.gs.pgame.sel - 1];
                                                        /* 2866 */
                                                        this.gnpls = 8;
                                                        /* 2867 */
                                                        this.gwait = 120;
                                                        /* 2868 */
                                                        this.gnotp = 0;
                                                        this.gplayers = "";
                                                        /* 2869 */
                                                        this.gs.wgame.hide();
                                                        this.gs.pgame.hide();
                                                        this.gs.vnpls.hide();
                                                        this.gs.vtyp.hide();
                                                        this.gs.warb.hide();
                                                        this.gs.requestFocus();
                                                        /* 2870 */
                                                        this.chalngd = -5;
                                                        /*      */
                                                    }
                                                    /*      */
                                                }
                                                /*      */
                                                /* 2874 */
                                                if (this.gs.wgame.getSelectedIndex() == 1 && this.gb.canredo && b == b2)
                                                    this.gb.loadwbgames = 7;
                                                /*      */
                                                /*      */
                                            }
                                        }
                                        /* 2877 */
                                        else if (b == 4) {
                                            this.gb.tab = 3;
                                            this.gb.cfase = 2;
                                            this.gb.em = 1;
                                            this.gb.msg = "Clan Search";
                                            this.gb.smsg = "Listing clans with recent activity...";
                                            this.gb.nclns = 0;
                                            this.gb.spos5 = 0;
                                            this.gb.lspos5 = 0;
                                            this.gb.flko = 0;
                                            this.gb.open = 2;
                                            this.gb.upo = true;
                                        }
                                        /*      */
                                        /*      */
                                    }
                                    /*      */
                                    /*      */
                                    /* 2882 */
                                    if (this.chalngd == -3) {
                                        /*      */
                                        /* 2884 */
                                        if (b == 4) {
                                            this.chalngd = -2;
                                            this.gs.snpls.hide();
                                            this.gs.snbts.hide();
                                            this.gs.swait.hide();
                                            this.gs.requestFocus();
                                        }
                                        /* 2885 */
                                        if (b == 5) if (this.gnpls != 0 && this.gs.snpls.getSelectedIndex() != 0) {
                                            byte b2;
                                            for (this.chalngd = -4, b2 = 0; b2 < 7; ) {
                                                if (!this.invos[b2].equals("")) this.invos[b2] = "";
                                                if (!this.dinvi[b2].equals("")) this.dinvi[b2] = "";
                                                b2++;
                                            }
                                            b = -1;
                                            this.gs.snpls.hide();
                                            this.gs.snbts.hide();
                                            this.gs.swait.hide();
                                            this.gs.requestFocus();
                                        } else {
                                            this.sflk = 25;
                                        }
                                        /* 2886 */
                                        b1 = 6;
                                        /*      */
                                    }
                                    /*      */
                                    /* 2889 */
                                    if (this.chalngd == -4) {
                                        /*      */
                                        /* 2891 */
                                        b1 = 7;
                                        /* 2892 */
                                        byte b2 = 0;
                                        byte b3;
                                        /* 2893 */
                                        for (b3 = 0; b3 < 7; ) {
                                            if (!this.invos[b3].equals("")) b2++;
                                            b3++;
                                        }
                                        /* 2894 */
                                        if (b2 < this.gnpls - 1) {
                                            if (b == 4) if (!this.invo) {
                                                this.invo = true;
                                            } else {
                                                this.invo = false;
                                            }
                                        } else {
                                            b1 = 6;
                                        }
                                        /* 2895 */
                                        if (b == b1 - 2) {
                                            if (this.invo) this.invo = false;
                                            if (this.gs.mycar.getState() && this.xt.sc[0] < 16) {
                                                this.gclass = -(this.xt.sc[0] + 2);
                                                this.gcars = 0;
                                            }
                                            if (this.gs.notp.getState()) {
                                                this.gnotp = 1;
                                            } else {
                                                this.gnotp = 0;
                                            }
                                            this.gplayers = "";
                                            this.gs.sclass.hide();
                                            this.gs.scars.hide();
                                            this.gs.sfix.hide();
                                            this.gs.mycar.hide();
                                            this.gs.notp.hide();
                                            this.gs.requestFocus();
                                            this.chalngd = -3;
                                        }
                                        /* 2896 */
                                        if (b == b1 - 1) {
                                            if (this.invo) this.invo = false;
                                            this.msg = "| Creating Game |";
                                            if (this.gs.mycar.getState() && this.xt.sc[0] < 16) {
                                                this.gclass = -(this.xt.sc[0] + 2);
                                                this.gcars = 0;
                                            }
                                            if (this.gclass != 0) this.gwait = 120;
                                            if (this.gs.notp.getState()) {
                                                this.gnotp = 1;
                                            } else {
                                                this.gnotp = 0;
                                            }
                                            this.gplayers = "";
                                            if (b2 != 0)
                                                for (this.gnpls = b2 + 1, this.gplayers = "" + this.pnames[this.im] + "#", b3 = 0; b3 < b2; ) {
                                                    this.gplayers += this.invos[b3] + "#";
                                                    b3++;
                                                }
                                            this.gs.sclass.hide();
                                            this.gs.scars.hide();
                                            this.gs.sfix.hide();
                                            this.gs.mycar.hide();
                                            this.gs.notp.hide();
                                            this.gs.requestFocus();
                                            this.chalngd = -5;
                                        }
                                        /*      */
                                        /*      */
                                    }
                                    /*      */
                                }
                                /*      */
                                /* 2901 */
                                if (b == b1 && !this.xt.lan)
                                    /*      */ {
                                    /* 2903 */
                                    if (!this.gs.cmsg.getText().equals("Type here...") && !this.gs.cmsg.getText().equals(""))
                                        /*      */ {
                                        /*      */
                                        /* 2906 */
                                        String str = this.gs.cmsg.getText().replace('|', ':');
                                        /* 2907 */
                                        if (str.toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) != -1)
                                            str = " ";
                                        /* 2908 */
                                        if (!this.xt.msgcheck(str) && this.updatec > -12)
                                            /*      */
                                            /* 2910 */ {
                                            for (byte b2 = 0; b2 < 6; ) {
                                                this.sentn[b2] = this.sentn[b2 + 1];
                                                this.cnames[b2] = this.cnames[b2 + 1];
                                                b2++;
                                            }
                                            /* 2911 */
                                            this.sentn[6] = str;
                                            this.cnames[6] = this.pnames[this.im];
                                            /* 2912 */
                                            if (this.updatec > -11) {
                                                this.updatec = -11;
                                            } else {
                                                this.updatec--;
                                            }
                                            /* 2913 */
                                            this.spos3 = 28;
                                        }
                                        /* 2914 */
                                        else {
                                            this.xt.warning++;
                                        }
                                        /*      */
                                        /* 2916 */
                                        this.gs.cmsg.setText("");
                                        /*      */
                                        /*      */
                                        /*      */
                                    }
                                    /*      */
                                    /*      */
                                    /*      */
                                }
                                /*      */
                                /*      */
                            }
                            /* 2925 */
                            else if (this.dispcar == -1) {
                                /*      */
                                /* 2927 */
                                byte b1 = 0;
                                byte b2;
                                /* 2928 */
                                for (b2 = 0; b2 < this.ngm; ) {
                                    if (this.ongame == this.gnum[b2]) b1 = b2;
                                    b2++;
                                }
                                /*      */
                                /* 2930 */
                                b2 = 0;
                                /* 2931 */
                                if (this.gwarb[b1] == 0) {
                                    if (!this.gplyrs[b1].equals("") && this.gplyrs[b1].indexOf(this.pnames[this.im]) == -1)
                                        b2 = 1;
                                } else if (!this.xt.clan.toLowerCase().equals(this.gaclan[b1].toLowerCase()) && !this.xt.clan.toLowerCase().equals(this.gvclan[b1].toLowerCase())) {
                                    b2 = 1;
                                }
                                /*      */
                                /* 2933 */
                                if (paramControl.enter && this.wait[b1] > 0 && this.pgames[this.im] == -1 && b2 == 0) {
                                    this.join = this.ongame;
                                    this.msg = "| Joining Game |";
                                    this.spos = 0;
                                    if (this.pbtn == 0) this.pessd[1] = true;
                                }
                                /*      */
                                /* 2935 */
                                if (this.wait[b1] == -1 && this.pgames[this.im] == -1 && paramControl.enter) {
                                    b = 0;
                                    this.pessd[0] = true;
                                }
                                /* 2936 */
                                if (this.pgames[this.im] == -1 && paramControl.exit) {
                                    b = 0;
                                    this.pessd[0] = true;
                                }
                                /* 2937 */
                                if (b == 0) if (this.pgames[this.im] == -1) {
                                    this.ongame = -1;
                                    this.chalngd = -1;
                                } else {
                                    this.join = -2;
                                    this.msg = "| Leaving Game |";
                                    this.longame = -1;
                                }
                                /*      */
                                /* 2939 */
                                if (this.pbtn == 0) {
                                    /*      */
                                    /* 2941 */
                                    if (b == 1)
                                        /*      */ {
                                        /* 2943 */
                                        if (this.wait[b1] > 0) {
                                            /*      */
                                            /* 2945 */
                                            if (this.pgames[this.im] == -1) {
                                                this.join = this.ongame;
                                                this.msg = "| Joining Game |";
                                                this.spos = 0;
                                            } else if (this.gmaker[b1].equals(this.pnames[this.im]) && this.npls[b1] > 1) {
                                                this.fstart = true;
                                            } else {
                                                b = 2;
                                            }
                                            /*      */
                                            /*      */
                                        } else {
                                            /*      */
                                            /* 2949 */
                                            if (this.wait[b1] == 0 && this.prevloaded == 1) {
                                                this.laps = this.gnlaps[b1];
                                                this.stage = this.gstgn[b1];
                                                this.stagename = this.gstages[b1];
                                                this.nfix = this.gfx[b1];
                                                if (this.gntb[b1] == 1) {
                                                    this.notb = true;
                                                } else {
                                                    this.notb = false;
                                                }
                                                this.gs.setCursor(new Cursor(3));
                                                this.conon = 3;
                                            } else {
                                                b = 2;
                                            }
                                            /* 2950 */
                                            if (this.wait[b1] == 0 && this.xt.lan) {
                                                this.laps = this.gnlaps[b1];
                                                this.stage = this.gstgn[b1];
                                                this.stagename = this.gstages[b1];
                                                this.nfix = this.gfx[b1];
                                                if (this.gntb[b1] == 1) {
                                                    this.notb = true;
                                                } else {
                                                    this.notb = false;
                                                }
                                                this.gs.setCursor(new Cursor(3));
                                                this.conon = 3;
                                            }
                                            /*      */
                                            /*      */
                                        }
                                        /*      */
                                    }
                                    /* 2954 */
                                    if (b == 2 && !this.xt.lan)
                                        /*      */ {
                                        /* 2956 */
                                        if (!this.gs.cmsg.getText().equals("Type here...") && !this.gs.cmsg.getText().equals("")) {
                                            /*      */
                                            /*      */
                                            /* 2959 */
                                            String str = this.gs.cmsg.getText().replace('|', ':');
                                            /* 2960 */
                                            if (str.toLowerCase().indexOf(this.gs.tpass.getText().toLowerCase()) != -1)
                                                str = " ";
                                            /* 2961 */
                                            if (!this.xt.msgcheck(str) && this.updatec > -12)
                                                /*      */
                                                /* 2963 */ {
                                                for (byte b3 = 0; b3 < 6; ) {
                                                    this.sentn[b3] = this.sentn[b3 + 1];
                                                    this.cnames[b3] = this.cnames[b3 + 1];
                                                    b3++;
                                                }
                                                /* 2964 */
                                                this.sentn[6] = str;
                                                this.cnames[6] = this.pnames[this.im];
                                                /* 2965 */
                                                if (this.updatec > -11) {
                                                    this.updatec = -11;
                                                } else {
                                                    this.updatec--;
                                                }
                                            }
                                            /* 2966 */
                                            else {
                                                this.xt.warning++;
                                            }
                                            /*      */
                                            /* 2968 */
                                            this.gs.cmsg.setText("");
                                            /*      */
                                        }
                                        /*      */
                                    }
                                    /*      */
                                }
                                /*      */
                                /*      */
                                /* 2974 */
                                if (this.pbtn == 1)
                                    /*      */ {
                                    /* 2976 */
                                    if (b == 1) if (this.pgames[this.im] == -1) {
                                        this.join = this.ongame;
                                        this.msg = "| Joining Game |";
                                        this.spos = 0;
                                    } else if (!this.invo) {
                                        this.invo = true;
                                    } else {
                                        this.invo = false;
                                    }
                                    /*      */
                                    /*      */
                                }
                                /* 2979 */
                                if (this.pbtn == 2)
                                    /*      */ {
                                    /* 2981 */
                                    if (b == 1 || b == 2) {
                                        this.fase = 2;
                                        this.m.ptr = 0;
                                        this.m.ptcnt = -10;
                                        this.m.hit = 20000;
                                        this.m.fallen = 500;
                                        this.m.nrnd = 0;
                                        this.m.ih = 25;
                                        this.m.iw = 65;
                                        this.m.h = 425;
                                        this.m.w = 735;
                                        this.m.trk = 4;
                                        this.plsndt = 0;
                                        if (this.gs.cmsg.isShowing()) {
                                            this.gs.cmsg.hide();
                                            this.gs.requestFocus();
                                        }
                                        /*      */
                                    }
                                    /*      */
                                    /*      */
                                }
                                /*      */
                            } else {
                                /*      */
                                /* 2987 */
                                if (b == 0) if (this.pgames[this.im] == -1) {
                                    this.ongame = -1;
                                    this.chalngd = -1;
                                } else {
                                    this.join = -2;
                                    this.msg = "| Leaving Game |";
                                    this.longame = -1;
                                }
                                /* 2988 */
                                if (this.pbtn == 1 && b == 1) if (this.pgames[this.im] == -1) {
                                    this.join = this.ongame;
                                    this.msg = "| Joining Game |";
                                    this.spos = 0;
                                } else if (!this.invo) {
                                    this.invo = true;
                                } else {
                                    this.invo = false;
                                    /*      */
                                }
                                /*      */
                                /*      */
                                /*      */
                                /*      */
                            }
                            /*      */
                            /*      */
                        }
                        /*      */
                    }
                    /* 2997 */
                    else if (this.ontyp != 76) {
                        /*      */
                        /* 2999 */
                        if (b == 0)
                            /*      */ {
                            /* 3001 */
                            if (this.ontyp < 30)
                                /*      */
                                /* 3003 */ {
                                this.xt.onjoin = this.onjoin;
                                /* 3004 */
                                this.xt.ontyp = this.ontyp;
                                /* 3005 */
                                this.xt.playingame = -101;
                                /* 3006 */
                                this.xt.fase = 23;
                            }
                            /* 3007 */
                            else {
                                if (!this.gb.claname.equals(this.xt.clan)) {
                                    this.gb.claname = this.xt.clan;
                                    this.gb.loadedc = false;
                                }
                                this.gb.spos5 = 0;
                                this.gb.lspos5 = 0;
                                this.gb.cfase = 3;
                                this.gb.loadedcars = -1;
                                this.gb.loadedcar = 0;
                                this.gb.ctab = 2;
                                this.gb.tab = 3;
                                this.gb.open = 2;
                                this.gb.upo = true;
                                this.onjoin = -1;
                            }
                            /*      */
                        }
                        /* 3009 */
                        if (b == 1) this.onjoin = -1;
                        /*      */
                        /*      */
                    } else {
                        /*      */
                        /* 3013 */
                        if (b == 0) {
                            this.gs.editlink(this.xt.nickname, true);
                            this.onjoin = -1;
                        }
                        /*      */
                        /* 3015 */
                        if (b == 1) this.onjoin = -1;
                        /*      */
                        /*      */
                    }
                    /*      */
                    /*      */
                }
                /*      */
                else {
                    /*      */
                    /* 3022 */
                    if (b == 0) this.gs.editlink(this.xt.nickname, true);
                    /* 3023 */
                    if (b == 1) this.regnow = false;
                    /*      */
                    /*      */
                }
                /*      */
            }
            /* 3027 */
            this.lxm = paramInt1;
            this.lym = paramInt2;
            /* 3028 */
            paramControl.enter = false;
            /* 3029 */
            paramControl.exit = false;
        }
        public void preforma ( int paramInt1, int paramInt2){
            if (this.pre1) {
                boolean bool = false;
                if (!this.gs.openm && this.gb.open == 0) {
                    if (this.conon != 0)
                        /*      */ bool = true;
                } else if (this.gs.cmsg.isShowing()) {
                    this.gs.cmsg.hide();
                }
                this.gs.movefieldd(this.gs.cmsg, 235, 390, 360, 22, bool);
                if (this.gs.cmsg.getText().equals("Type here...") && paramInt1 > 234 && paramInt1 < 603 && paramInt2 > 385 && paramInt2 < 417)
                    /*      */ this.gs.cmsg.setText("");
            }
            if (this.pre2) {
                boolean bool = false;
                if (!this.gs.openm && this.gb.open == 0) {
                    bool = true;
                } else if (this.gs.cmsg.isShowing()) {
                    this.gs.cmsg.hide();
                }
                this.gs.movefieldd(this.gs.cmsg, 237, 390, 360, 22, bool);
                if (this.gs.cmsg.getText().equals("Type here...") && paramInt1 > 232 && paramInt1 < 601 && paramInt2 > 385 && paramInt2 < 417)
                    /*      */ this.gs.cmsg.setText("");
            }
            if (this.pre1 || this.pre2) {
                if (this.gs.cmsg.getText().length() > 100) {
                    this.gs.cmsg.setText(this.gs.cmsg.getText().substring(0, 100));
                    this.gs.cmsg.select(100, 100);
                }
                this.pre1 = false;
                this.pre2 = false;
            }
            /*      */
        }
        /* 3034 */
        public void hideinputs () {
            this.gs.cmsg.hide();
            /* 3035 */
            this.gs.swait.hide();
            /* 3036 */
            this.gs.snpls.hide();
            /* 3037 */
            this.gs.snbts.hide();
            /* 3038 */
            this.gs.sgame.hide();
            /* 3039 */
            this.gs.wgame.hide();
            /* 3040 */
            this.gs.pgame.hide();
            /* 3041 */
            this.gs.vnpls.hide();
            /* 3042 */
            this.gs.vtyp.hide();
            /* 3043 */
            this.gs.warb.hide();
            /* 3044 */
            this.gs.mstgs.hide();
            /* 3045 */
            this.gs.snfm1.hide();
            /* 3046 */
            this.gs.snfmm.hide();
            /* 3047 */
            this.gs.slaps.hide();
            /* 3048 */
            this.gs.snfm2.hide();
            /* 3049 */
            this.gs.sclass.hide();
            /* 3050 */
            this.gs.scars.hide();
            /* 3051 */
            this.gs.sfix.hide();
            /* 3052 */
            this.gs.mycar.hide();
            /* 3053 */
            this.gs.notp.hide();
            /* 3054 */
            this.gs.rooms.hide();
            /* 3055 */
            this.gs.requestFocus();
        }
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        public void drawSbutton (Image paramImage,int paramInt1, int paramInt2){
            /* 3061 */
            this.bx[this.btn] = paramInt1;
            this.by[this.btn] = paramInt2;
            /* 3062 */
            this.bw[this.btn] = paramImage.getWidth(this.ob);
            /*      */
            /* 3064 */
            if (!this.pessd[this.btn]) {
                /*      */
                /* 3066 */
                this.rd.drawImage(paramImage, paramInt1 - this.bw[this.btn] / 2, paramInt2 - paramImage.getHeight(this.ob) / 2 - 1, (ImageObserver) null);
                /* 3067 */
                this.rd.drawImage(this.xt.bols, paramInt1 - this.bw[this.btn] / 2 - 15, paramInt2 - 13, (ImageObserver) null);
                /* 3068 */
                this.rd.drawImage(this.xt.bors, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 - 13, (ImageObserver) null);
                /* 3069 */
                this.rd.drawImage(this.xt.bot, paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 - 13, this.bw[this.btn] + 18, 3, null);
                /* 3070 */
                this.rd.drawImage(this.xt.bob, paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 + 10, this.bw[this.btn] + 18, 3, null);
                /*      */
            }
            /*      */
            else {
                /*      */
                /* 3074 */
                this.rd.drawImage(paramImage, paramInt1 - this.bw[this.btn] / 2 + 1, paramInt2 - paramImage.getHeight(this.ob) / 2, (ImageObserver) null);
                /* 3075 */
                this.rd.drawImage(this.xt.bolps, paramInt1 - this.bw[this.btn] / 2 - 15, paramInt2 - 13, (ImageObserver) null);
                /* 3076 */
                this.rd.drawImage(this.xt.borps, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 - 13, (ImageObserver) null);
                /* 3077 */
                this.rd.drawImage(this.xt.bob, paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 - 13, this.bw[this.btn] + 18, 3, null);
                /* 3078 */
                this.rd.drawImage(this.xt.bot, paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 + 10, this.bw[this.btn] + 18, 3, null);
                /*      */
            }
            /*      */
            /* 3081 */
            this.btn++;
            /*      */
        }
        public void stageselect (CheckPoints paramCheckPoints, Control paramControl,int paramInt1, int paramInt2,
        boolean paramBoolean){
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.fillRect(0, 0, 65, 450);
            this.rd.fillRect(735, 0, 65, 450);
            this.rd.fillRect(65, 0, 670, 25);
            this.rd.fillRect(65, 425, 670, 25);
            this.btn = 0;
            byte b1 = 0;
            this.rd.drawImage(this.xt.br, 65, 25, (ImageObserver) null);
            if (this.britchl == -1) {
                this.ongame = -1;
                this.britchl = 0;
            }
            byte b2 = 0;
            byte b3;
            for (b3 = 0; b3 < this.ngm; ) {
                if (this.ongame == this.gnum[b3]) b2 = b3;
                b3++;
            }
            if (this.chalngd != -2 && this.ongame != -1) {
                this.rd.setColor(color2k(20, 20, 20));
                this.rd.fillRect(80, 0, 640, 40);
                this.rd.setColor(color2k(70, 70, 70));
                this.rd.drawLine(80, 40, 720, 40);
                this.rd.drawLine(80, 40, 80, 0);
                this.rd.drawLine(720, 40, 720, 0);
                this.rd.setColor(new Color(193, 106, 0));
                this.rd.setFont(new Font("Arial", 1, 12));
                this.ftm = this.rd.getFontMetrics();
                if (this.wait[b2] > 0) {
                    if (this.gwarb[b2] == 0) {
                        if (this.wait[b2] > 30 || this.npls[b2] <= 1) {
                            String str1 = "";
                            if (this.npls[b2] > 1) {
                                Date date = new Date();
                                long l = date.getTime();
                                if (this.ptime == 0L || l > this.ptime + 1500L) {
                                    if (this.ptime != 0L) {
                                        this.wait[b2] = this.wait[b2] - 1;
                                        if (this.wait[b2] < 1) this.wait[b2] = 1;
                                    }
                                    this.ptime = l;
                                }
                                str1 = " (waiting " + this.wait[b2] + " seconds maximum)";
                                if (this.wait[b2] > 60)
                                    str1 = " (waiting " + ((int) (this.wait[b2] / 60.0F * 100.0F) / 100.0F) + " minutes maximum)";
                            }
                            this.rd.drawString("Waiting for " + (this.mnpls[b2] - this.npls[b2]) + " more players to join to start this game" + str1 + "!", 95, 15);
                            this.rd.setFont(new Font("Arial", 0, 12));
                            if (!this.gmaker[b2].equals("Coach Insano") && !this.gmaker[b2].equals(this.pnames[this.im])) {
                                boolean bool;
                                byte b;
                                for (bool = false, b = 0; b < this.npo; ) {
                                    if (this.pgames[b] == this.ongame && this.gmaker[b2].equals(this.pnames[b]))
                                        bool = true;
                                    b++;
                                }
                                if (bool)
                                    this.rd.drawString("" + this.gmaker[b2] + " can start this game at anytime (the game creator)...", 95, 31);
                            }
                        } else {
                            Date date = new Date();
                            long l = date.getTime();
                            if (this.ptime == 0L || l > this.ptime + 1500L) {
                                if (this.ptime != 0L) {
                                    this.wait[b2] = this.wait[b2] - 1;
                                    if (this.wait[b2] < 1) this.wait[b2] = 1;
                                }
                                this.ptime = l;
                            }
                            if (this.pgames[this.im] == this.ongame || this.nflk != 0) {
                                this.rd.drawString("Game starts in " + this.wait[b2] + " seconds!", 400 - this.ftm.stringWidth("Game starts in " + this.wait[b2] + " seconds!") / 2, 23);
                                if (this.pgames[this.im] != this.ongame) this.nflk--;
                            } else if (this.pgames[this.im] != this.ongame) {
                                this.nflk = 3;
                            }
                        }
                    } else {
                        this.rd.drawString("Waiting for " + (this.mnpls[b2] - this.npls[b2]) + " clan members to join to start this game!", 95, 23);
                    }
                    if (this.pgames[this.im] != this.ongame) {
                        b3 = 0;
                        if (this.gwarb[b2] == 0) {
                            if (this.gplyrs[b2].equals("") || this.gplyrs[b2].indexOf(this.pnames[this.im]) != -1)
                                b3 = 1;
                        } else if (this.xt.clan.toLowerCase().equals(this.gaclan[b2].toLowerCase()) || this.xt.clan.toLowerCase().equals(this.gvclan[b2].toLowerCase())) {
                            b3 = 1;
                        }
                        if (b3 != 0) stringbutton(" Join Game ", 660, 23, 2);
                    }
                } else {
                    this.rd.setColor(color2k(120, 120, 120));
                    if (this.wait[b2] == 0) {
                        this.rd.drawString("Game Started", 400 - this.ftm.stringWidth("Game Started") / 2, 20);
                    } else {
                        this.rd.drawString("Game Finished", 400 - this.ftm.stringWidth("Game Finished") / 2, 20);
                    }
                }
            }
            this.rd.setFont(new Font("Arial", 1, 11));
            this.xt.ftm = this.rd.getFontMetrics();
            this.ftm = this.rd.getFontMetrics();
            String str = "";
            if (paramCheckPoints.stage < 0) str = "Custom Stage";
            if (paramCheckPoints.stage > 0 && paramCheckPoints.stage <= 10)
                str = "Stage " + paramCheckPoints.stage + " NFM 1";
            if (paramCheckPoints.stage > 10 && paramCheckPoints.stage <= 27)
                str = "Stage " + (paramCheckPoints.stage - 10) + " NFM 2";
            if (paramCheckPoints.stage > 27) str = "Multiplayer Stage " + (paramCheckPoints.stage - 27) + "";
            this.xt.drawcs(85, "Previewing " + str + "  >", 255, 138, 0, 5);
            this.xt.drawcs(105, "| " + paramCheckPoints.name + " |", 255, 176, 85, 5);
            this.rd.drawImage(this.xt.back[this.pback], 532, 285, (ImageObserver) null);
            if (this.plsndt == 0) {
                String str1 = "Play Soundtrack >";
                int i = 562 - this.ftm.stringWidth(str1) / 2, j = i + this.ftm.stringWidth(str1);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawString(str1, i + 1, 326);
                this.rd.drawLine(i + 1, 328, j + 1, 328);
                this.rd.setColor(new Color(255, 138, 0));
                this.rd.drawString(str1, i, 325);
                this.rd.drawLine(i, 327, j, 327);
                if (paramInt1 > i && paramInt1 < j && paramInt2 > 314 && paramInt2 < 327) {
                    b1 = 12;
                    if (paramBoolean) this.plsndt = 1;
                }
            }
            if (this.plsndt == 1) this.xt.drawcs(190, "Loading Soundtrack, please wait...", 255, 138, 0, 5);
            if (paramCheckPoints.stage < 0) {
                this.rd.setColor(new Color(255, 138, 0));
                this.rd.drawString("Created by: " + paramCheckPoints.maker + "", 85, 413);
                if (paramCheckPoints.pubt > 0) {
                    if (paramCheckPoints.pubt == 2) {
                        this.xt.drawcs(413, "Super Public Stage", 41, 177, 255, 3);
                    } else {
                        this.xt.drawcs(413, "Public Stage", 41, 177, 255, 3);
                    }
                    if (this.addstage == 0 && this.xt.drawcarb(true, null, " Add to My Stages ", 334, 420, paramInt1, paramInt2, paramBoolean))
                        if (this.xt.logged) {
                            this.cd.onstage = paramCheckPoints.name;
                            this.cd.staction = 2;
                            this.cd.sparkstageaction();
                            this.addstage = 2;
                        } else {
                            this.addstage = 1;
                            this.waitlink = 20;
                        }
                    if (this.addstage == 1) {
                        this.rd.setFont(new Font("Arial", 1, 11));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(193, 106, 0));
                        String str1 = "Upgrade to a full account to add custom stages!";
                        int i = 400 - this.ftm.stringWidth(str1) / 2, j = i + this.ftm.stringWidth(str1);
                        this.rd.drawString(str1, i, 435);
                        if (this.waitlink != -1) this.rd.drawLine(i, 437, j, 437);
                        if (paramInt1 > i && paramInt1 < j && paramInt2 > 424 && paramInt2 < 437) {
                            if (this.waitlink != -1) b1 = 12;
                            if (paramBoolean && this.waitlink == 0) {
                                this.gs.editlink(this.xt.nickname, true);
                                this.waitlink = -1;
                            }
                        }
                        if (this.waitlink > 0) this.waitlink--;
                    }
                    if (this.addstage == 2) {
                        this.xt.drawcs(435, "Adding stage please wait...", 193, 106, 0, 3);
                        if (this.cd.staction == 0) this.addstage = 3;
                        if (this.cd.staction == -2) this.addstage = 4;
                        if (this.cd.staction == -3) this.addstage = 5;
                        if (this.cd.staction == -1) this.addstage = 6;
                    }
                    if (this.addstage == 3)
                        this.xt.drawcs(435, "Stage has been successfully added to your stages!", 193, 106, 0, 3);
                    if (this.addstage == 4)
                        /*      */ this.xt.drawcs(435, "You already have this stage!", 193, 106, 0, 3);
                    if (this.addstage == 5)
                        /*      */
                        this.xt.drawcs(435, "Cannot add more then 20 stages to your account!", 193, 106, 0, 3);
                    if (this.addstage == 6)
                        /*      */
                        this.xt.drawcs(435, "Failed to add stage, unknown error, please try again later.", 193, 106, 0, 3);
                } else {
                    this.xt.drawcs(435, "Private Stage", 193, 106, 0, 3);
                }
            }
            if (paramControl.enter || this.conon == 2 || (this.ongame == -1 && this.chalngd != -2)) {
                this.m.trk = 0;
                if (this.xt.loadedt)
                    /* 3086 */ this.xt.strack.unload();
                this.m.focus_point = 400;
                this.m.crs = true;
                this.m.x = -335;
                this.m.y = 0;
                this.m.z = -50;
                this.m.xz = 0;
                this.m.zy = 20;
                this.m.ground = -2000;
                this.fase = 1;
                paramControl.enter = false;
            }
            if (b1 != this.pcurs) {
                this.gs.setCursor(new Cursor(b1));
                this.pcurs = b1;
            }
        }
        public void stringbutton (String paramString,int paramInt1, int paramInt2, int paramInt3){
            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
            /*      */
            /* 3088 */
            this.bx[this.btn] = paramInt1;
            this.by[this.btn] = paramInt2 - 5;
            /* 3089 */
            this.bw[this.btn] = this.ftm.stringWidth(paramString);
            /*      */
            /* 3091 */
            if (!this.pessd[this.btn]) {
                /*      */
                /* 3093 */
                this.rd.setColor(color2k(220, 220, 220));
                /* 3094 */
                this.rd.fillRect(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, this.bw[this.btn] + 20, 25 - paramInt3 * 2);
                /* 3095 */
                this.rd.setColor(color2k(240, 240, 240));
                /* 3096 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 17 - paramInt3);
                /* 3097 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 18 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 18 - paramInt3);
                /* 3098 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 - 19 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 - 19 - paramInt3);
                /* 3099 */
                this.rd.setColor(color2k(200, 200, 200));
                /* 3100 */
                this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 7 - paramInt3);
                /* 3101 */
                this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 11, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 11, paramInt2 + 7 - paramInt3);
                /* 3102 */
                this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 12, paramInt2 - 16 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 12, paramInt2 + 6 - paramInt3);
                /* 3103 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 7 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 7 - paramInt3);
                /* 3104 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 8 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 8 - paramInt3);
                /* 3105 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 + 9 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 + 9 - paramInt3);
                /* 3106 */
                this.rd.setColor(color2k(240, 240, 240));
                /* 3107 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 7 - paramInt3);
                /* 3108 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 11, paramInt2 - 17 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 11, paramInt2 + 7 - paramInt3);
                /* 3109 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 12, paramInt2 - 16 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 12, paramInt2 + 6 - paramInt3);
                /* 3110 */
                this.rd.setColor(new Color(0, 0, 0));
                /* 3111 */
                this.rd.drawString(paramString, paramInt1 - this.bw[this.btn] / 2, paramInt2);
                /*      */
            }
            /*      */
            else {
                /*      */
                /* 3115 */
                this.rd.setColor(color2k(210, 210, 210));
                /* 3116 */
                this.rd.fillRect(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, this.bw[this.btn] + 20, 25 - paramInt3 * 2);
                /* 3117 */
                this.rd.setColor(color2k(200, 200, 200));
                /* 3118 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 17 - paramInt3);
                /* 3119 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 18 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 18 - paramInt3);
                /* 3120 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 - 19 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 - 19 - paramInt3);
                /* 3121 */
                this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 7 - paramInt3);
                /* 3122 */
                this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 11, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 11, paramInt2 + 7 - paramInt3);
                /* 3123 */
                this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 12, paramInt2 - 16 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 12, paramInt2 + 6 - paramInt3);
                /* 3124 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 7 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 7 - paramInt3);
                /* 3125 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 8 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 8 - paramInt3);
                /* 3126 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 + 9 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 + 9 - paramInt3);
                /* 3127 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 7 - paramInt3);
                /* 3128 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 11, paramInt2 - 17 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 11, paramInt2 + 7 - paramInt3);
                /* 3129 */
                this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 12, paramInt2 - 16 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 12, paramInt2 + 6 - paramInt3);
                /* 3130 */
                this.rd.setColor(new Color(0, 0, 0));
                /* 3131 */
                this.rd.drawString(paramString, paramInt1 - this.bw[this.btn] / 2 + 1, paramInt2);
                /*      */
            }
            /*      */
            /* 3134 */
            this.btn++;
        }
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        /*      */
        public Color color2k ( int paramInt1, int paramInt2, int paramInt3){
            /* 3141 */
            Color color = new Color(paramInt1, paramInt2, paramInt3);
            /* 3142 */
            float[] arrayOfFloat = new float[3];
            /* 3143 */
            Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), arrayOfFloat);
            /* 3144 */
            arrayOfFloat[0] = 0.13F;
            /* 3145 */
            arrayOfFloat[1] = 0.35F;
            /* 3146 */
            return Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
            /*      */
        }
        /*      */
        /*      */
        public int getvalue (String paramString,int paramInt)
        /*      */
        {
            /* 3151 */
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
            /* 3152 */
        }
        public String getSvalue (String paramString,int paramInt){
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
        /* 3153 */
        public int getHvalue (String paramString,int paramInt){
            int i = -1;
            try {
                byte b1;
                byte b2;
                byte b3;
                String str1;
                String str2;
                for (b1 = 0, b2 = 0, b3 = 0, str1 = "", str2 = ""; b1 < paramString.length() && b3 != 2; ) {
                    str1 = "" + paramString.charAt(b1);
                    if (str1.equals("#")) {
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
        public String getHSvalue (String paramString,int paramInt){
            /* 3154 */
            String str = "";
            try {
                byte b1;
                byte b2;
                byte b3;
                String str1;
                String str2;
                for (b1 = 0, b2 = 0, b3 = 0, str1 = "", str2 = ""; b1 < paramString.length() && b3 != 2; ) {
                    str1 = "" + paramString.charAt(b1);
                    if (str1.equals("#")) {
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
            /*      */
        }
        /*      */
        /*      */
        /*      */
        public String getSevervalue (String paramString,int paramInt){
            /* 3159 */
            String str = "";
            /*      */
            /* 3161 */
            if (!paramString.equals("")) {
                /*      */
                /*      */
                /*      */
                try {
                    /* 3165 */
                    boolean bool = false;
                    /*      */
                    /*      */
                    /*      */
                    /*      */
                    /*      */
                    /*      */
                    /*      */
                    /*      */
                    /*      */
                    /*      */
                    /*      */
                    /*      */
                    /*      */
                    /* 3179 */
                    byte b1 = 0, b2 = 0, b3 = 0;
                    /* 3180 */
                    String str1 = "", str2 = "";
                    /* 3181 */
                    while (b1 < paramString.length() && b3 != 2) {
                        /*      */
                        /* 3183 */
                        str1 = "" + paramString.charAt(b1);
                        if (str1.equals("|")) {
                            if (b3 == 1 || ++b2 > paramInt) b3 = 2;
                        } else if (b2 == paramInt) {
                            str2 = str2 + str1;
                            b3 = 1;
                        }
                        /* 3184 */
                        b1++;
                        /*      */
                    }
                    /*      */
                    /*      */
                    /* 3188 */
                    str = str2;
                }
                /* 3189 */ catch (Exception exception) {
                    str = "";
                }
                /*      */
                /*      */
            }
            /* 3192 */
            return str;
            /*      */
        }
        /*      */
    }


/* Location:              /home/naglis/Desktop/Need-for-Madness/Need for Madness/Game.jar!/Lobby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */