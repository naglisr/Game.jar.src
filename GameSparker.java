

import java.applet.Applet;
import java.awt.AlphaComposite;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class GameSparker
        extends Applet
        implements Runnable {
    Graphics2D rd;
    Image offImage;
    Thread gamer;
    int mload = 1;


    boolean exwist = false;


    int apx = 0;
    int apy = 0;
    float apmult = 1.0F;
    float reqmult = 0.0F;
    int smooth = 1;
    int moto = 1;
    int lastw = 0;
    int lasth = 0;
    boolean onbar = false;
    boolean oncarm = false;
    boolean onstgm = false;
    boolean onfulls = false;
    Image sizebar;
    Image blb;
    Image fulls;
    Image[] chkbx = new Image[2];
    Image[] carmaker = new Image[2];
    Image[] stagemaker = new Image[2];
    int showsize = 0;


    Control[] u = new Control[8];

    int mouses = 0;
    int xm = 0;
    int ym = 0;
    int mousew = 0;
    boolean lostfcs = false;
    boolean moused = false;
    int fcscnt = 0;

    int nob = 0;
    int notb = 0;
    int view = 0;

    int mvect = 100;
    int lmxz = 0;
    int shaka = 0;

    boolean applejava = false;

    TextField tnick;

    TextField tpass;
    TextField temail;
    TextField cmsg;
    TextArea mmsg;
    Checkbox mycar;
    Checkbox notp;
    Checkbox keplo;
    boolean openm = false;
    Smenu sgame = new Smenu(8);
    Smenu wgame = new Smenu(4);
    Smenu warb = new Smenu(102);
    Smenu pgame = new Smenu(11);
    Smenu vnpls = new Smenu(5);
    Smenu vtyp = new Smenu(6);
    Smenu snfmm = new Smenu(12);
    Smenu snfm1 = new Smenu(12);
    Smenu snfm2 = new Smenu(19);
    Smenu mstgs = new Smenu(707);
    Smenu mcars = new Smenu(707);
    Smenu slaps = new Smenu(17);
    Smenu snpls = new Smenu(9);
    Smenu snbts = new Smenu(8);
    Smenu swait = new Smenu(6);
    Smenu sclass = new Smenu(7);
    Smenu scars = new Smenu(4);
    Smenu sfix = new Smenu(7);
    Smenu gmode = new Smenu(3);
    Smenu rooms = new Smenu(7);
    Smenu sendtyp = new Smenu(6);
    Smenu senditem = new Smenu(707);
    Smenu clanlev = new Smenu(8);
    Smenu clcars = new Smenu(707);
    Smenu datat = new Smenu(26);
    Smenu ilaps = new Smenu(18);
    Smenu icars = new Smenu(5);
    Smenu proitem = new Smenu(707);


    public void run() {

        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(0, 0, 800, 450);
        repaint();

        requestFocus();
        if (System.getProperty("java.vendor").toLowerCase().indexOf("apple") != -1) this.applejava = true;


        Medium medium = new Medium();

        Trackers trackers = new Trackers();

        CheckPoints checkPoints = new CheckPoints();

        ContO[] arrayOfContO1 = new ContO[124];

        CarDefine carDefine = new CarDefine(arrayOfContO1, medium, trackers, this);

        xtGraphics xtGraphics = new xtGraphics(medium, carDefine, this.rd, this);


        this.sizebar = xtGraphics.getImage("data/sizebar.gif");

        this.blb = xtGraphics.getImage("data/b.gif");

        this.fulls = xtGraphics.getImage("data/fullscreen.gif");

        this.chkbx[0] = xtGraphics.getImage("data/checkbox1.gif");

        this.chkbx[1] = xtGraphics.getImage("data/checkbox2.gif");

        this.carmaker[0] = xtGraphics.getImage("data/carmaker1.gif");

        this.carmaker[1] = xtGraphics.getImage("data/carmaker2.gif");

        this.stagemaker[0] = xtGraphics.getImage("data/stagemaker1.gif");

        this.stagemaker[1] = xtGraphics.getImage("data/stagemaker2.gif");


        xtGraphics.loaddata();


        Login login = null;

        Lobby lobby = null;

        Globe globe = null;

        boolean bool1 = false;

        UDPMistro uDPMistro = new UDPMistro();


        Record record = new Record(medium);

        loadbase(arrayOfContO1, medium, trackers, xtGraphics, false);


        ContO[] arrayOfContO2 = new ContO[610];

        Mad[] arrayOfMad = new Mad[8];

        for (byte b1 = 0; b1 < 8; ) {
            arrayOfMad[b1] = new Mad(carDefine, medium, record, xtGraphics, b1);
            this.u[b1] = new Control(medium);
            b1++;
        }


        float f1 = 47.0F;

        readcookies(xtGraphics, carDefine, arrayOfContO1);


        xtGraphics.testdrive = Madness.testdrive;

        if (xtGraphics.testdrive != 0) {

            if (xtGraphics.testdrive <= 2) {
                xtGraphics.sc[0] = carDefine.loadcar(Madness.testcar, 16);

                if (xtGraphics.sc[0] != -1) {
                    xtGraphics.fase = -9;
                } else {
                    Madness.testcar = "Failx12";
                    Madness.carmaker();
                }

            } else {
                checkPoints.name = Madness.testcar;
                xtGraphics.fase = -9;
            }


        }


        xtGraphics.stoploading();

        requestFocus();


        if (xtGraphics.testdrive == 0) {

            if (xtGraphics.firstime) setupini();


        }


        System.gc();

        Date date = new Date();
        long l1 = 0L, l2 = date.getTime();

        float f2 = 30.0F;

        boolean bool2 = false;

        byte b2 = 30;
        char c1 = 'Ȓ';

        byte b3 = 0;


        short s = 0;

        char c2 = Character.MIN_VALUE;
        byte b4 = 0;
        int i = 0;

        boolean bool3 = false;


        while (true) {

            date = new Date();
            long l3 = date.getTime();

            if (xtGraphics.fase == 111) {
                if (this.mouses == 1) c2 = '̠';
                if (c2 < '̠') {
                    xtGraphics.clicknow();
                    c2++;
                } else {
                    c2 = Character.MIN_VALUE;
                    if (!this.exwist) xtGraphics.fase = 9;
                    this.mouses = 0;
                    this.lostfcs = false;
                }
            }

            if (xtGraphics.fase == 9) if (c2 < 'L') {
                xtGraphics.rad(c2);
                catchlink();
                if (this.mouses == 2) this.mouses = 0;
                if (this.mouses == 1) this.mouses = 2;
                c2++;
            } else {
                c2 = Character.MIN_VALUE;
                xtGraphics.fase = 10;
                this.mouses = 0;
                this.u[0].falseo(0);
            }

            if (xtGraphics.fase == -9) {


                if (xtGraphics.loadedt) {
                    xtGraphics.mainbg(-101);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.fillRect(0, 0, 800, 450);
                    repaint();
                    xtGraphics.strack.unload();
                    xtGraphics.strack = null;
                    xtGraphics.flexpix = null;
                    xtGraphics.fleximg = null;
                    System.gc();
                    xtGraphics.loadedt = false;
                }

                if (c2 < '\002') {
                    xtGraphics.mainbg(-101);
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.fillRect(65, 25, 670, 400);
                    c2++;
                } else {
                    checkmemory(xtGraphics);
                    xtGraphics.inishcarselect(arrayOfContO1);
                    c2 = Character.MIN_VALUE;
                    xtGraphics.fase = 7;
                    this.mvect = 50;
                    this.mouses = 0;
                }


            }
            if (xtGraphics.fase == 8) {
                xtGraphics.credits(this.u[0], this.xm, this.ym, this.mouses);
                xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (xtGraphics.flipo <= 100) catchlink();
                if (this.mouses == 2) this.mouses = 0;
                if (this.mouses == 1) this.mouses = 2;
            }

            if (xtGraphics.fase == 10) {
                this.mvect = 100;
                xtGraphics.maini(this.u[0]);
                xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) this.mouses = 0;
                if (this.mouses == 1) this.mouses = 2;
            }

            if (xtGraphics.fase == 102) {


                this.mvect = 100;

                if (xtGraphics.loadedt) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.fillRect(0, 0, 800, 450);
                    repaint();
                    checkmemory(xtGraphics);
                    xtGraphics.strack.unload();
                    xtGraphics.strack = null;
                    xtGraphics.flexpix = null;
                    xtGraphics.fleximg = null;
                    System.gc();
                    xtGraphics.loadedt = false;
                }


                if (xtGraphics.testdrive == 1 || xtGraphics.testdrive == 2) Madness.carmaker();

                if (xtGraphics.testdrive == 3 || xtGraphics.testdrive == 4) Madness.stagemaker();

                xtGraphics.maini2(this.u[0], this.xm, this.ym, this.mouses);
                xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) this.mouses = 0;
                if (this.mouses == 1) this.mouses = 2;

            }

            if (xtGraphics.fase == -22) {
                checkPoints.name = Madness.testcar;
                checkPoints.stage = -1;
                loadstage(arrayOfContO2, arrayOfContO1, medium, trackers, checkPoints, xtGraphics, arrayOfMad, record);
                if (checkPoints.stage == -3) {
                    Madness.testcar = "Failx12";
                    Madness.stagemaker();
                }
            }

            if (xtGraphics.fase == 11) {
                xtGraphics.inst(this.u[0]);
                xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) this.mouses = 0;
                if (this.mouses == 1) this.mouses = 2;
            }

            if (xtGraphics.fase == -5) {
                this.mvect = 100;
                xtGraphics.finish(checkPoints, arrayOfContO1, this.u[0], this.xm, this.ym, this.moused);
                xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) this.mouses = 0;
                if (this.mouses == 1) this.mouses = 2;
            }

            if (xtGraphics.fase == 7) {
                xtGraphics.carselect(this.u[0], arrayOfContO1, arrayOfMad[0], this.xm, this.ym, this.moused);
                xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) this.mouses = 0;
                if (this.mouses == 1) this.mouses = 2;
                drawms();
            }

            if (xtGraphics.fase == 6) {
                xtGraphics.musicomp(checkPoints.stage, this.u[0]);
                xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) this.mouses = 0;
                if (this.mouses == 1) this.mouses = 2;
            }

            if (xtGraphics.fase == 5) {
                this.mvect = 100;
                xtGraphics.loadmusic(checkPoints.stage, checkPoints.trackname, checkPoints.trackvol);
            }

            if (xtGraphics.fase == 4) {
                xtGraphics.cantgo(this.u[0]);
                xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) this.mouses = 0;
                if (this.mouses == 1) this.mouses = 2;
            }

            if (xtGraphics.fase == 3) {
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.fillRect(65, 25, 670, 400);
                repaint();
                xtGraphics.inishstageselect(checkPoints);
            }

            if (xtGraphics.fase == 2) {
                this.mvect = 100;
                xtGraphics.loadingstage(checkPoints.stage, true);
                checkPoints.nfix = 0;
                checkPoints.notb = false;
                loadstage(arrayOfContO2, arrayOfContO1, medium, trackers, checkPoints, xtGraphics, arrayOfMad, record);
                this.u[0].falseo(0);
                uDPMistro.freg = 0.0F;
                this.mvect = 20;
            }

            if (xtGraphics.fase == 1) {
                xtGraphics.trackbg(false);
                this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                if (checkPoints.stage != -3) {
                    medium.aroundtrack(checkPoints);
                    if (medium.hit == 5000 && this.mvect < 40) this.mvect++;
                    byte b5;
                    int arrayOfInt1[], j;
                    for (b5 = 0, arrayOfInt1 = new int[1000], j = xtGraphics.nplayers; j < this.notb; ) {
                        if ((arrayOfContO2[j]).dist != 0) {
                            arrayOfInt1[b5] = j;
                            b5++;
                        } else {
                            arrayOfContO2[j].d(this.rd);
                        }
                        j++;
                    }
                    int[] arrayOfInt2;
                    byte b6;
                    for (arrayOfInt2 = new int[b5], b6 = 0; b6 < b5; ) {
                        arrayOfInt2[b6] = 0;
                        b6++;
                    }
                    for (b6 = 0; b6 < b5; ) {
                        for (int k = b6 + 1; k < b5; ) {
                            if ((arrayOfContO2[arrayOfInt1[b6]]).dist != (arrayOfContO2[arrayOfInt1[k]]).dist) {
                                if ((arrayOfContO2[arrayOfInt1[b6]]).dist < (arrayOfContO2[arrayOfInt1[k]]).dist) {
                                    arrayOfInt2[b6] = arrayOfInt2[b6] + 1;
                                } else {
                                    arrayOfInt2[k] = arrayOfInt2[k] + 1;
                                }
                            } else if (k > b6) {
                                arrayOfInt2[b6] = arrayOfInt2[b6] + 1;
                            } else {
                                arrayOfInt2[k] = arrayOfInt2[k] + 1;
                            }
                            k++;
                        }
                        b6++;
                    }
                    for (b6 = 0; b6 < b5; ) {
                        for (byte b = 0; b < b5; ) {
                            if (arrayOfInt2[b] == b6) arrayOfContO2[arrayOfInt1[b]].d(this.rd);
                            b++;
                        }
                        b6++;
                    }
                }
                if (!this.openm) xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) this.mouses = 0;
                if (this.mouses == 1) this.mouses = 2;
                this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                xtGraphics.stageselect(checkPoints, this.u[0], this.xm, this.ym, this.moused);
                drawms();
            }


            if (xtGraphics.fase == 1177) {


                this.mvect = 100;

                if (!bool1) {


                    if (xtGraphics.loadedt) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.fillRect(0, 0, 800, 450);
                        repaint();
                        checkmemory(xtGraphics);
                        xtGraphics.strack.unload();
                        xtGraphics.strack = null;
                        xtGraphics.flexpix = null;
                        xtGraphics.fleximg = null;
                        System.gc();
                        xtGraphics.loadedt = false;
                    }

                    xtGraphics.intertrack.unloadimod();

                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.fillRect(65, 25, 670, 400);

                    if (this.mload > 0) this.rd.drawImage(xtGraphics.mload, 259, 195, this);

                    repaint();


                    if (this.mload == 2) {
                        carDefine.loadready();
                        loadbase(arrayOfContO1, medium, trackers, xtGraphics, true);
                        readcookies(xtGraphics, carDefine, arrayOfContO1);
                        this.mload = -1;
                    }


                    System.gc();

                    login = new Login(medium, this.rd, xtGraphics, this);

                    globe = new Globe(this.rd, xtGraphics, medium, login, carDefine, checkPoints, arrayOfContO1, arrayOfContO2, this);

                    lobby = new Lobby(medium, this.rd, login, globe, xtGraphics, carDefine, this);

                    bool1 = true;

                }


                if (login.fase != 18) {


                    boolean bool = false;

                    if (login.fase == 0) login.inishmulti();

                    if (login.fase >= 1 && login.fase <= 11)
                        login.multistart(arrayOfContO1, this.xm, this.ym, this.moused);

                    if (login.fase >= 12 && login.fase <= 17) {
                        if (globe.open != 452) {
                            login.multimode(arrayOfContO1);
                        } else {
                            bool = true;
                        }
                        globe.dome(0, this.xm, this.ym, this.moused, this.u[0]);
                    }

                    if (login.justlog) {
                        if (!xtGraphics.clan.equals("")) globe.itab = 2;
                        login.justlog = false;
                    }

                    if (!bool) {
                        login.ctachm(this.xm, this.ym, this.mouses, this.u[0], lobby);
                        this.mvect = 50;
                    } else {
                        drawms();
                        this.mvect = 100;
                    }

                    if (this.mouses == 1) this.mouses = 11;

                    if (this.mouses <= -1) {
                        this.mouses--;
                        if (this.mouses == -4) this.mouses = 0;
                    }

                    if (this.mousew != 0) if (this.mousew > 0) {
                        this.mousew--;
                    } else {
                        this.mousew++;
                    }


                } else {

                    boolean bool = false;

                    if (lobby.fase == 0) {
                        lobby.inishlobby();
                        this.mvect = 100;
                    }

                    if (lobby.fase == 1) {


                        if (globe.open >= 2 && globe.open < 452) this.openm = true;

                        if (globe.open != 452) {
                            lobby.lobby(this.xm, this.ym, this.moused, this.mousew, checkPoints, this.u[0], arrayOfContO1);
                        } else {
                            bool = true;
                        }

                        globe.dome(lobby.conon, this.xm, this.ym, this.moused, this.u[0]);

                        if (lobby.loadstage > 0) {
                            setCursor(new Cursor(3));
                            drawms();
                            repaint();
                            trackers.nt = 0;
                            if (loadstagePreview(lobby.loadstage, "", arrayOfContO2, arrayOfContO1, medium, checkPoints)) {
                                lobby.gstagename = checkPoints.name;
                                lobby.gstagelaps = checkPoints.nlaps;
                                lobby.loadstage = -lobby.loadstage;
                            } else {
                                lobby.loadstage = 0;
                                checkPoints.name = "";
                            }
                            setCursor(new Cursor(0));
                        }

                        if (lobby.msload != 0) {
                            setCursor(new Cursor(3));
                            drawms();
                            repaint();
                            if (lobby.msload == 1) carDefine.loadmystages(checkPoints);
                            if (lobby.msload == 7) carDefine.loadclanstages(xtGraphics.clan);
                            if (lobby.msload == 3 || lobby.msload == 4) carDefine.loadtop20(lobby.msload);
                            lobby.msload = 0;
                            setCursor(new Cursor(0));
                        }


                    }
                    if (lobby.fase == 3) {
                        xtGraphics.trackbg(false);
                        medium.trk = 0;
                        medium.focus_point = 400;
                        medium.crs = true;
                        medium.x = -335;
                        medium.y = 0;
                        medium.z = -50;
                        medium.xz = 0;
                        medium.zy = 20;
                        medium.ground = -2000;
                        this.mvect = 100;
                        lobby.fase = 1;
                    }

                    if (lobby.fase == 4) {
                        this.mvect = 50;
                        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
                        medium.d(this.rd);
                        medium.aroundtrack(checkPoints);
                        byte b5;
                        int[] arrayOfInt1;
                        byte b6;
                        for (b5 = 0, arrayOfInt1 = new int[1000], b6 = 0; b6 < this.nob; ) {
                            if ((arrayOfContO2[b6]).dist != 0) {
                                arrayOfInt1[b5] = b6;
                                b5++;
                            } else {
                                arrayOfContO2[b6].d(this.rd);
                            }
                            b6++;
                        }
                        int[] arrayOfInt2;
                        byte b7;
                        for (arrayOfInt2 = new int[b5], b7 = 0; b7 < b5; ) {
                            arrayOfInt2[b7] = 0;
                            b7++;
                        }
                        for (b7 = 0; b7 < b5; ) {
                            for (int j = b7 + 1; j < b5; ) {
                                if ((arrayOfContO2[arrayOfInt1[b7]]).dist != (arrayOfContO2[arrayOfInt1[j]]).dist) {
                                    if ((arrayOfContO2[arrayOfInt1[b7]]).dist < (arrayOfContO2[arrayOfInt1[j]]).dist) {
                                        arrayOfInt2[b7] = arrayOfInt2[b7] + 1;
                                    } else {
                                        arrayOfInt2[j] = arrayOfInt2[j] + 1;
                                    }
                                } else if (j > b7) {
                                    arrayOfInt2[b7] = arrayOfInt2[b7] + 1;
                                } else {
                                    arrayOfInt2[j] = arrayOfInt2[j] + 1;
                                }
                                j++;
                            }
                            b7++;
                        }
                        for (b7 = 0; b7 < b5; ) {
                            for (byte b = 0; b < b5; ) {
                                if (arrayOfInt2[b] == b7) arrayOfContO2[arrayOfInt1[b]].d(this.rd);
                                b++;
                            }
                            b7++;
                        }
                        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                        lobby.stageselect(checkPoints, this.u[0], this.xm, this.ym, this.moused);
                        if (lobby.plsndt == 1) {
                            this.mvect = 70;
                            repaint();
                            setCursor(new Cursor(3));
                            xtGraphics.loadstrack(checkPoints.stage, checkPoints.trackname, checkPoints.trackvol);
                            xtGraphics.strack.play();
                            lobby.plsndt = 2;
                            this.moused = false;
                            this.mouses = 0;
                        }
                    }

                    if (lobby.fase == 2) {
                        byte b5;
                        byte b6;
                        for (b5 = 0, b6 = 0; b6 < lobby.ngm; ) {
                            if (lobby.ongame == lobby.gnum[b6]) b5 = b6;
                            b6++;
                        }
                        b6 = 0;
                        if (lobby.gstgn[b5] > 0) {
                            if (lobby.gstgn[b5] == -lobby.loadstage) b6 = 1;
                        } else if (lobby.gstages[b5].equals(checkPoints.name)) {
                            b6 = 1;
                        }
                        if (b6 != 0) {
                            lobby.fase = 4;
                            lobby.addstage = 0;
                        } else {
                            xtGraphics.loadingstage(lobby.gstgn[b5], false);
                            trackers.nt = 0;
                            if (loadstagePreview(lobby.gstgn[b5], lobby.gstages[b5], arrayOfContO2, arrayOfContO1, medium, checkPoints)) {
                                lobby.loadstage = -lobby.gstgn[b5];
                                lobby.fase = 4;
                                lobby.addstage = 0;
                            } else {
                                lobby.loadstage = 0;
                                checkPoints.name = "";
                                lobby.fase = 3;
                            }
                        }
                    }

                    if (lobby.fase == 76) {
                        checkPoints.nlaps = lobby.laps;
                        checkPoints.stage = lobby.stage;
                        checkPoints.name = lobby.stagename;
                        checkPoints.nfix = lobby.nfix;
                        checkPoints.notb = lobby.notb;
                        xtGraphics.fase = 21;
                        (this.u[0]).multion = xtGraphics.multion;
                    }

                    if (globe.loadwbgames == 7) {
                        repaint();
                        globe.redogame();
                    }

                    if (!this.openm) {
                        if (!bool) lobby.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                    } else {
                        this.mouses = 0;
                    }
                    drawms();
                    if (lobby.fase == 1) lobby.preforma(this.xm, this.ym);

                    if (lobby.loadwarb) {
                        repaint();
                        globe.loadwarb();
                        lobby.loadwarb = false;
                    }

                    if (globe.loadwbgames == 1) {
                        repaint();
                        globe.loadwgames();
                    }

                    if (this.mouses == 1) this.mouses = 11;

                    if (this.mouses <= -1) {
                        this.mouses--;
                        if (this.mouses == -4) this.mouses = 0;
                    }

                    if (this.mousew != 0) {
                        if (this.mousew > 0) {
                            this.mousew--;
                        } else {
                            this.mousew++;
                        }
                        if (!lobby.zeromsw) this.mousew = 0;
                    }


                }

            }

            if (xtGraphics.fase == 24) {
                login.endcons();
                login = null;
                lobby = null;
                globe = null;
                bool1 = false;
                System.gc();
                System.runFinalization();
                if (!xtGraphics.mtop) {
                    xtGraphics.fase = 102;
                    xtGraphics.opselect = 2;
                } else {
                    xtGraphics.fase = 10;
                    xtGraphics.opselect = 1;
                }
            }

            if (xtGraphics.fase == 23) {
                if (login.fase == 18) xtGraphics.playingame = -101;
                login.stopallnow();
                lobby.stopallnow();
                globe.stopallnow();
                login = null;
                lobby = null;
                globe = null;
                hidefields();
                bool1 = false;
                System.gc();
                System.runFinalization();
                xtGraphics.fase = -9;
            }


            if (xtGraphics.fase == 22) {
                loadstage(arrayOfContO2, arrayOfContO1, medium, trackers, checkPoints, xtGraphics, arrayOfMad, record);
                if (checkPoints.stage != -3) {
                    if (xtGraphics.lan && xtGraphics.im == 0)
                        uDPMistro.UDPLanServer(xtGraphics.nplayers, xtGraphics.server, xtGraphics.servport, xtGraphics.playingame);
                    this.u[0].falseo(2);
                    requestFocus();
                } else {
                    xtGraphics.fase = 1177;
                }
            }

            if (xtGraphics.fase == 21) {
                login.endcons();
                login = null;
                lobby = null;
                globe = null;
                bool1 = false;
                System.gc();
                System.runFinalization();
                xtGraphics.fase = 22;
            }


            if (xtGraphics.fase == 0) {

                byte b5;

                for (b5 = 0; b5 < xtGraphics.nplayers; ) {
                    if ((arrayOfMad[b5]).newcar) {
                        int j = (arrayOfContO2[b5]).xz, k = (arrayOfContO2[b5]).xy, m = (arrayOfContO2[b5]).zy;
                        arrayOfContO2[b5] = new ContO(arrayOfContO1[(arrayOfMad[b5]).cn], (arrayOfContO2[b5]).x, (arrayOfContO2[b5]).y, (arrayOfContO2[b5]).z, 0);
                        (arrayOfContO2[b5]).xz = j;
                        (arrayOfContO2[b5]).xy = k;
                        (arrayOfContO2[b5]).zy = m;
                        (arrayOfMad[b5]).newcar = false;
                    }
                    b5++;
                }

                medium.d(this.rd);
                b5 = 0;
                int[] arrayOfInt1 = new int[200];

                for (byte b6 = 0; b6 < this.nob; ) {
                    if ((arrayOfContO2[b6]).dist != 0) {
                        arrayOfInt1[b5] = b6;
                        b5++;
                    } else {
                        arrayOfContO2[b6].d(this.rd);
                    }
                    b6++;
                }

                int[] arrayOfInt2 = new int[b5];

                int[] arrayOfInt3 = new int[b5];
                byte b7;

                for (b7 = 0; b7 < b5; ) {
                    arrayOfInt2[b7] = 0;
                    b7++;
                }

                for (b7 = 0; b7 < b5; ) {
                    for (int j = b7 + 1; j < b5; ) {
                        if ((arrayOfContO2[arrayOfInt1[b7]]).dist < (arrayOfContO2[arrayOfInt1[j]]).dist) {
                            arrayOfInt2[b7] = arrayOfInt2[b7] + 1;
                        } else {
                            arrayOfInt2[j] = arrayOfInt2[j] + 1;
                        }
                        j++;
                    }
                    arrayOfInt3[arrayOfInt2[b7]] = b7;
                    b7++;
                }

                for (b7 = 0; b7 < b5; ) {
                    arrayOfContO2[arrayOfInt1[arrayOfInt3[b7]]].d(this.rd);
                    b7++;
                }


                if (xtGraphics.starcnt == 0) {


                    for (b7 = 0; b7 < xtGraphics.nplayers; ) {
                        for (byte b = 0; b < xtGraphics.nplayers; ) {
                            if (b != b7) arrayOfMad[b7].colide(arrayOfContO2[b7], arrayOfMad[b], arrayOfContO2[b]);
                            b++;
                        }
                        b7++;
                    }

                    for (b7 = 0; b7 < xtGraphics.nplayers; ) {
                        arrayOfMad[b7].drive(this.u[b7], arrayOfContO2[b7], trackers, checkPoints);
                        b7++;
                    }

                    for (b7 = 0; b7 < xtGraphics.nplayers; ) {
                        record.rec(arrayOfContO2[b7], b7, (arrayOfMad[b7]).squash, (arrayOfMad[b7]).lastcolido, (arrayOfMad[b7]).cntdest, 0);
                        b7++;
                    }

                    checkPoints.checkstat(arrayOfMad, arrayOfContO2, record, xtGraphics.nplayers, xtGraphics.im, 0);

                    for (b7 = 1; b7 < xtGraphics.nplayers; ) {
                        this.u[b7].preform(arrayOfMad[b7], arrayOfContO2[b7], checkPoints, trackers);
                        b7++;
                    }


                } else {


                    if (xtGraphics.starcnt == 130) {
                        medium.adv = 1900;
                        medium.zy = 40;
                        medium.vxz = 70;
                        this.rd.setColor(new Color(255, 255, 255));
                        this.rd.fillRect(0, 0, 800, 450);
                    }

                    if (xtGraphics.starcnt != 0) xtGraphics.starcnt--;


                }

                if (xtGraphics.starcnt < 38) {


                    if (this.view == 0) {
                        medium.follow(arrayOfContO2[0], (arrayOfMad[0]).cxz, (this.u[0]).lookback);
                        xtGraphics.stat(arrayOfMad[0], arrayOfContO2[0], checkPoints, this.u[0], true);
                        if ((arrayOfMad[0]).outshakedam > 0) {
                            this.shaka = (arrayOfMad[0]).outshakedam / 20;
                            if (this.shaka > 25) this.shaka = 25;
                        }
                        this.mvect = 65 + Math.abs(this.lmxz - medium.xz) / 5 * 100;
                        if (this.mvect > 90) this.mvect = 90;
                        this.lmxz = medium.xz;
                    }

                    if (this.view == 1) {
                        medium.around(arrayOfContO2[0], false);
                        xtGraphics.stat(arrayOfMad[0], arrayOfContO2[0], checkPoints, this.u[0], false);
                        this.mvect = 80;
                    }

                    if (this.view == 2) {
                        medium.watch(arrayOfContO2[0], (arrayOfMad[0]).mxz);
                        xtGraphics.stat(arrayOfMad[0], arrayOfContO2[0], checkPoints, this.u[0], false);
                        this.mvect = 65 + Math.abs(this.lmxz - medium.xz) / 5 * 100;
                        if (this.mvect > 90) this.mvect = 90;
                        this.lmxz = medium.xz;
                    }

                    if (this.mouses == 1) {
                        (this.u[0]).enter = true;
                        this.mouses = 0;
                    }


                } else {


                    b7 = 3;
                    if (xtGraphics.nplayers == 1) b7 = 0;
                    medium.around(arrayOfContO2[b7], true);
                    this.mvect = 80;

                    if ((this.u[0]).enter || (this.u[0]).handb) {
                        xtGraphics.starcnt = 38;
                        (this.u[0]).enter = false;
                        (this.u[0]).handb = false;
                    }

                    if (xtGraphics.starcnt == 38) {
                        this.mouses = 0;
                        medium.vert = false;
                        medium.adv = 900;
                        medium.vxz = 180;
                        checkPoints.checkstat(arrayOfMad, arrayOfContO2, record, xtGraphics.nplayers, xtGraphics.im, 0);
                        medium.follow(arrayOfContO2[0], (arrayOfMad[0]).cxz, 0);
                        xtGraphics.stat(arrayOfMad[0], arrayOfContO2[0], checkPoints, this.u[0], true);
                        this.rd.setColor(new Color(255, 255, 255));
                        this.rd.fillRect(0, 0, 800, 450);
                    }


                }

            }


            if (xtGraphics.fase == 7001) {

                byte b5;

                for (b5 = 0; b5 < xtGraphics.nplayers; ) {
                    if ((arrayOfMad[b5]).newedcar == 0 && (arrayOfMad[b5]).newcar) {
                        int k = (arrayOfContO2[b5]).xz, m = (arrayOfContO2[b5]).xy, n = (arrayOfContO2[b5]).zy;
                        xtGraphics.colorCar(arrayOfContO1[(arrayOfMad[b5]).cn], b5);
                        arrayOfContO2[b5] = new ContO(arrayOfContO1[(arrayOfMad[b5]).cn], (arrayOfContO2[b5]).x, (arrayOfContO2[b5]).y, (arrayOfContO2[b5]).z, 0);
                        (arrayOfContO2[b5]).xz = k;
                        (arrayOfContO2[b5]).xy = m;
                        (arrayOfContO2[b5]).zy = n;
                        (arrayOfMad[b5]).newedcar = 20;
                    }
                    b5++;
                }

                medium.d(this.rd);
                b5 = 0;
                int[] arrayOfInt1 = new int[200];

                for (byte b6 = 0; b6 < this.nob; ) {
                    if ((arrayOfContO2[b6]).dist != 0) {
                        arrayOfInt1[b5] = b6;
                        b5++;
                    } else {
                        arrayOfContO2[b6].d(this.rd);
                    }
                    b6++;
                }

                int[] arrayOfInt2 = new int[b5];

                int[] arrayOfInt3 = new int[b5];
                int j;

                for (j = 0; j < b5; ) {
                    arrayOfInt2[j] = 0;
                    j++;
                }

                for (j = 0; j < b5; ) {
                    for (int k = j + 1; k < b5; ) {
                        if ((arrayOfContO2[arrayOfInt1[j]]).dist < (arrayOfContO2[arrayOfInt1[k]]).dist) {
                            arrayOfInt2[j] = arrayOfInt2[j] + 1;
                        } else {
                            arrayOfInt2[k] = arrayOfInt2[k] + 1;
                        }
                        k++;
                    }
                    arrayOfInt3[arrayOfInt2[j]] = j;
                    j++;
                }

                for (j = 0; j < b5; j++) {


                    if (arrayOfInt1[arrayOfInt3[j]] < xtGraphics.nplayers && arrayOfInt1[arrayOfInt3[j]] != xtGraphics.im)
                        uDPMistro.readContOinfo(arrayOfContO2[arrayOfInt1[arrayOfInt3[j]]], arrayOfInt1[arrayOfInt3[j]]);

                    arrayOfContO2[arrayOfInt1[arrayOfInt3[j]]].d(this.rd);

                }


                if (xtGraphics.starcnt == 0) {


                    if (xtGraphics.multion == 1) {
                        byte b;
                        for (j = 1, b = 0; b < xtGraphics.nplayers; ) {
                            if (xtGraphics.im != b) {
                                uDPMistro.readinfo(arrayOfMad[b], arrayOfContO2[b], this.u[j], b, checkPoints.dested);
                                j++;
                            }
                            b++;
                        }
                    } else {
                        for (j = 0; j < xtGraphics.nplayers; ) {
                            uDPMistro.readinfo(arrayOfMad[j], arrayOfContO2[j], this.u[j], j, checkPoints.dested);
                            j++;
                        }
                    }

                    for (j = 0; j < xtGraphics.nplayers; ) {
                        for (byte b = 0; b < xtGraphics.nplayers; ) {
                            if (b != j) arrayOfMad[j].colide(arrayOfContO2[j], arrayOfMad[b], arrayOfContO2[b]);
                            b++;
                        }
                        j++;
                    }

                    if (xtGraphics.multion == 1) {
                        byte b;
                        for (j = 1, b = 0; b < xtGraphics.nplayers; ) {
                            if (xtGraphics.im != b) {
                                arrayOfMad[b].drive(this.u[j], arrayOfContO2[b], trackers, checkPoints);
                                j++;
                            } else {
                                arrayOfMad[b].drive(this.u[0], arrayOfContO2[b], trackers, checkPoints);
                            }
                            b++;
                        }

                        for (b = 0; b < xtGraphics.nplayers; ) {
                            record.rec(arrayOfContO2[b], b, (arrayOfMad[b]).squash, (arrayOfMad[b]).lastcolido, (arrayOfMad[b]).cntdest, xtGraphics.im);
                            b++;
                        }
                    } else {
                        for (j = 0; j < xtGraphics.nplayers; ) {
                            arrayOfMad[j].drive(this.u[j], arrayOfContO2[j], trackers, checkPoints);
                            j++;
                        }
                    }

                    checkPoints.checkstat(arrayOfMad, arrayOfContO2, record, xtGraphics.nplayers, xtGraphics.im, xtGraphics.multion);

                } else {


                    if (xtGraphics.starcnt == 130) {


                        medium.adv = 1900;
                        medium.zy = 40;
                        medium.vxz = 70;
                        this.rd.setColor(new Color(255, 255, 255));
                        this.rd.fillRect(0, 0, 800, 450);
                        repaint();

                        if (xtGraphics.lan) {
                            uDPMistro.UDPConnectLan(xtGraphics.localserver, xtGraphics.nplayers, xtGraphics.im);
                            if (xtGraphics.im == 0) xtGraphics.setbots(uDPMistro.isbot, uDPMistro.frame);
                        } else {
                            uDPMistro.UDPConnectOnline(xtGraphics.server, xtGraphics.gameport, xtGraphics.nplayers, xtGraphics.im);
                        }

                        if (xtGraphics.multion >= 2) {
                            xtGraphics.im = (int) (Math.random() * xtGraphics.nplayers);
                            xtGraphics.starcnt = 0;
                        }


                    }
                    if (xtGraphics.starcnt == 50) uDPMistro.frame[uDPMistro.im][0] = 0;

                    if (xtGraphics.starcnt != 39 && xtGraphics.starcnt != 0) xtGraphics.starcnt--;

                    if (uDPMistro.go && xtGraphics.starcnt >= 39) {
                        xtGraphics.starcnt = 38;
                        if (xtGraphics.lan) {
                            j = checkPoints.stage;
                            if (j < 0) j = 33;
                            if (xtGraphics.loadedt) xtGraphics.strack.play();
                        }

                    }


                }
                if (xtGraphics.lan && uDPMistro.im == 0) for (j = 2; j < xtGraphics.nplayers; ) {
                    if (uDPMistro.isbot[j]) {
                        this.u[j].preform(arrayOfMad[j], arrayOfContO2[j], checkPoints, trackers);
                        uDPMistro.setinfo(arrayOfMad[j], arrayOfContO2[j], this.u[j], checkPoints.pos[j], checkPoints.magperc[j], false, j);
                    }
                    j++;
                }


                if (xtGraphics.starcnt < 38) {


                    if (xtGraphics.multion == 1) {


                        uDPMistro.setinfo(arrayOfMad[xtGraphics.im], arrayOfContO2[xtGraphics.im], this.u[0], checkPoints.pos[xtGraphics.im], checkPoints.magperc[xtGraphics.im], xtGraphics.holdit, xtGraphics.im);

                        if (this.view == 0) {
                            medium.follow(arrayOfContO2[xtGraphics.im], (arrayOfMad[xtGraphics.im]).cxz, (this.u[0]).lookback);
                            xtGraphics.stat(arrayOfMad[xtGraphics.im], arrayOfContO2[xtGraphics.im], checkPoints, this.u[0], true);
                            if ((arrayOfMad[xtGraphics.im]).outshakedam > 0) {
                                this.shaka = (arrayOfMad[xtGraphics.im]).outshakedam / 20;
                                if (this.shaka > 25) this.shaka = 25;
                            }
                            this.mvect = 65 + Math.abs(this.lmxz - medium.xz) / 5 * 100;
                            if (this.mvect > 90) this.mvect = 90;
                            this.lmxz = medium.xz;
                        }

                        if (this.view == 1) {
                            medium.around(arrayOfContO2[xtGraphics.im], false);
                            xtGraphics.stat(arrayOfMad[xtGraphics.im], arrayOfContO2[xtGraphics.im], checkPoints, this.u[0], false);
                            this.mvect = 80;
                        }

                        if (this.view == 2) {
                            medium.watch(arrayOfContO2[xtGraphics.im], (arrayOfMad[xtGraphics.im]).mxz);
                            xtGraphics.stat(arrayOfMad[xtGraphics.im], arrayOfContO2[xtGraphics.im], checkPoints, this.u[0], false);
                            this.mvect = 65 + Math.abs(this.lmxz - medium.xz) / 5 * 100;
                            if (this.mvect > 90) this.mvect = 90;
                            this.lmxz = medium.xz;
                        }


                    } else {


                        if (this.view == 0) {
                            medium.getaround(arrayOfContO2[xtGraphics.im]);
                            this.mvect = 80;
                        }

                        if (this.view == 1) {
                            medium.getfollow(arrayOfContO2[xtGraphics.im], (arrayOfMad[xtGraphics.im]).cxz, (this.u[0]).lookback);
                            this.mvect = 65 + Math.abs(this.lmxz - medium.xz) / 5 * 100;
                            if (this.mvect > 90) this.mvect = 90;
                            this.lmxz = medium.xz;
                        }

                        if (this.view == 2) {
                            medium.watch(arrayOfContO2[xtGraphics.im], (arrayOfMad[xtGraphics.im]).mxz);
                            this.mvect = 65 + Math.abs(this.lmxz - medium.xz) / 5 * 100;
                            if (this.mvect > 90) this.mvect = 90;
                            this.lmxz = medium.xz;
                        }

                        xtGraphics.stat(arrayOfMad[xtGraphics.im], arrayOfContO2[xtGraphics.im], checkPoints, this.u[0], true);

                    }

                    if (this.mouses == 1) {
                        if (xtGraphics.holdit && xtGraphics.exitm != 4 && xtGraphics.multion == 1)
                            (this.u[0]).enter = true;
                        this.mouses = 0;
                    }


                } else {


                    medium.around(arrayOfContO2[xtGraphics.im], true);
                    this.mvect = 80;

                    if (xtGraphics.starcnt == 39) xtGraphics.waitenter();

                    if (xtGraphics.starcnt == 38) {
                        xtGraphics.forstart = 0;
                        this.mouses = 0;
                        medium.vert = false;
                        medium.adv = 900;
                        medium.vxz = 180;
                        checkPoints.checkstat(arrayOfMad, arrayOfContO2, record, xtGraphics.nplayers, xtGraphics.im, xtGraphics.multion);
                        medium.follow(arrayOfContO2[xtGraphics.im], (arrayOfMad[xtGraphics.im]).cxz, 0);
                        xtGraphics.stat(arrayOfMad[xtGraphics.im], arrayOfContO2[xtGraphics.im], checkPoints, this.u[0], true);
                        this.rd.setColor(new Color(255, 255, 255));
                        this.rd.fillRect(0, 0, 800, 450);
                    }


                }

                xtGraphics.multistat(this.u[0], checkPoints, this.xm, this.ym, this.moused, uDPMistro);

            }


            if (xtGraphics.fase == -1) {
                if (!s) for (byte b = 0; b < xtGraphics.nplayers; ) {
                    record.ocar[b] = new ContO(arrayOfContO2[b], 0, 0, 0, 0);
                    arrayOfContO2[b] = new ContO(record.car[0][b], 0, 0, 0, 0);
                    b++;
                }
                medium.d(this.rd);
                byte b5;
                int[] arrayOfInt1;
                byte b6;
                for (b5 = 0, arrayOfInt1 = new int[200], b6 = 0; b6 < this.nob; ) {
                    if ((arrayOfContO2[b6]).dist != 0) {
                        arrayOfInt1[b5] = b6;
                        b5++;
                    } else {
                        arrayOfContO2[b6].d(this.rd);
                    }
                    b6++;
                }
                int[] arrayOfInt2;
                byte b7;
                for (arrayOfInt2 = new int[b5], b7 = 0; b7 < b5; ) {
                    arrayOfInt2[b7] = 0;
                    b7++;
                }
                for (b7 = 0; b7 < b5; ) {
                    for (int j = b7 + 1; j < b5; ) {
                        if ((arrayOfContO2[arrayOfInt1[b7]]).dist != (arrayOfContO2[arrayOfInt1[j]]).dist) {
                            if ((arrayOfContO2[arrayOfInt1[b7]]).dist < (arrayOfContO2[arrayOfInt1[j]]).dist) {
                                arrayOfInt2[b7] = arrayOfInt2[b7] + 1;
                            } else {
                                arrayOfInt2[j] = arrayOfInt2[j] + 1;
                            }
                        } else if (j > b7) {
                            arrayOfInt2[b7] = arrayOfInt2[b7] + 1;
                        } else {
                            arrayOfInt2[j] = arrayOfInt2[j] + 1;
                        }
                        j++;
                    }
                    b7++;
                }
                for (b7 = 0; b7 < b5; ) {
                    for (byte b = 0; b < b5; ) {
                        if (arrayOfInt2[b] == b7) arrayOfContO2[arrayOfInt1[b]].d(this.rd);
                        b++;
                    }
                    b7++;
                }
                if ((this.u[0]).enter || (this.u[0]).handb || this.mouses == 1) {
                    s = 299;
                    (this.u[0]).enter = false;
                    (this.u[0]).handb = false;
                    this.mouses = 0;
                }
                for (b7 = 0; b7 < xtGraphics.nplayers; ) {
                    if (record.fix[b7] == s) if ((arrayOfContO2[b7]).dist == 0) {
                        (arrayOfContO2[b7]).fcnt = 8;
                    } else {
                        (arrayOfContO2[b7]).fix = true;
                    }
                    if ((arrayOfContO2[b7]).fcnt == 7 || (arrayOfContO2[b7]).fcnt == 8) {
                        arrayOfContO2[b7] = new ContO(arrayOfContO1[(arrayOfMad[b7]).cn], 0, 0, 0, 0);
                        record.cntdest[b7] = 0;
                    }
                    if (s == 299) arrayOfContO2[b7] = new ContO(record.ocar[b7], 0, 0, 0, 0);
                    record.play(arrayOfContO2[b7], arrayOfMad[b7], b7, s);
                    b7++;
                }
                if (++s == 300) {
                    s = 0;
                    xtGraphics.fase = -6;
                } else {
                    xtGraphics.replyn();
                }
                medium.around(arrayOfContO2[0], false);
            }

            if (xtGraphics.fase == -2) {


                if (xtGraphics.multion >= 2) record.hcaught = false;
                this.u[0].falseo(3);

                if (record.hcaught && record.wasted == 0 && record.whenwasted != 229 && (checkPoints.stage == 1 || checkPoints.stage == 2) && xtGraphics.looped != 0)
                    record.hcaught = false;

                if (record.hcaught) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.fillRect(0, 0, 800, 450);
                    repaint();
                }


                if (xtGraphics.multion != 0) {
                    uDPMistro.UDPquit();
                    xtGraphics.stopchat();
                    if (this.cmsg.isShowing()) this.cmsg.hide();
                    this.cmsg.setText("");
                    requestFocus();
                }


                if (record.hcaught) {
                    if (medium.random() > 0.45D) {
                        medium.vert = false;
                    } else {
                        medium.vert = true;
                    }
                    medium.adv = (int) (900.0F * medium.random());
                    medium.vxz = (int) (360.0F * medium.random());
                    s = 0;
                    xtGraphics.fase = -3;
                    c2 = Character.MIN_VALUE;
                    b4 = 0;
                } else {
                    s = -2;
                    xtGraphics.fase = -4;
                }


            }

            if (xtGraphics.fase == -3) {


                if (s == 0) {


                    if (record.wasted == 0) {
                        if (record.whenwasted == 229) {
                            i = 67;
                            medium.vxz += 90;
                        } else {
                            i = (int) (medium.random() * 4.0F);
                            if (i == 1 || i == 3) i = 69;
                            if (i == 2 || i == 4) i = 30;
                        }
                    } else if (record.closefinish != 0 && b4) {
                        medium.vxz += 90;
                    }

                    for (byte b = 0; b < xtGraphics.nplayers; ) {
                        arrayOfContO2[b] = new ContO(record.starcar[b], 0, 0, 0, 0);
                        b++;
                    }


                }

                medium.d(this.rd);
                byte b5;
                int[] arrayOfInt1;
                byte b6;
                for (b5 = 0, arrayOfInt1 = new int[200], b6 = 0; b6 < this.nob; ) {
                    if ((arrayOfContO2[b6]).dist != 0) {
                        arrayOfInt1[b5] = b6;
                        b5++;
                    } else {
                        arrayOfContO2[b6].d(this.rd);
                    }
                    b6++;
                }
                int[] arrayOfInt2;
                byte b7;
                for (arrayOfInt2 = new int[b5], b7 = 0; b7 < b5; ) {
                    arrayOfInt2[b7] = 0;
                    b7++;
                }
                for (b7 = 0; b7 < b5; ) {
                    for (int j = b7 + 1; j < b5; ) {
                        if ((arrayOfContO2[arrayOfInt1[b7]]).dist != (arrayOfContO2[arrayOfInt1[j]]).dist) {
                            if ((arrayOfContO2[arrayOfInt1[b7]]).dist < (arrayOfContO2[arrayOfInt1[j]]).dist) {
                                arrayOfInt2[b7] = arrayOfInt2[b7] + 1;
                            } else {
                                arrayOfInt2[j] = arrayOfInt2[j] + 1;
                            }
                        } else if (j > b7) {
                            arrayOfInt2[b7] = arrayOfInt2[b7] + 1;
                        } else {
                            arrayOfInt2[j] = arrayOfInt2[j] + 1;
                        }
                        j++;
                    }
                    b7++;
                }
                for (b7 = 0; b7 < b5; ) {
                    for (byte b = 0; b < b5; ) {
                        if (arrayOfInt2[b] == b7) arrayOfContO2[arrayOfInt1[b]].d(this.rd);
                        b++;
                    }
                    b7++;
                }

                for (b7 = 0; b7 < xtGraphics.nplayers; ) {
                    if (record.hfix[b7] == s) if ((arrayOfContO2[b7]).dist == 0) {
                        (arrayOfContO2[b7]).fcnt = 8;
                    } else {
                        (arrayOfContO2[b7]).fix = true;
                    }
                    if ((arrayOfContO2[b7]).fcnt == 7 || (arrayOfContO2[b7]).fcnt == 8) {
                        arrayOfContO2[b7] = new ContO(arrayOfContO1[(arrayOfMad[b7]).cn], 0, 0, 0, 0);
                        record.cntdest[b7] = 0;
                    }
                    record.playh(arrayOfContO2[b7], arrayOfMad[b7], b7, s, xtGraphics.im);
                    b7++;
                }

                if (b4 == 2 && s == 299) (this.u[0]).enter = true;

                if ((this.u[0]).enter || (this.u[0]).handb) {


                    xtGraphics.fase = -4;
                    (this.u[0]).enter = false;
                    (this.u[0]).handb = false;
                    s = -7;

                } else {


                    xtGraphics.levelhigh(record.wasted, record.whenwasted, record.closefinish, s, checkPoints.stage);

                    if (s == 0 || s == 1 || s == 2) {
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.fillRect(0, 0, 800, 450);
                    }

                    if (record.wasted != xtGraphics.im) {
                        if (record.closefinish == 0) {
                            if (c2 == '\t' || c2 == '\013') {
                                this.rd.setColor(new Color(255, 255, 255));
                                this.rd.fillRect(0, 0, 800, 450);
                            }
                            if (c2 == '\000') medium.around(arrayOfContO2[xtGraphics.im], false);
                            if (c2 > '\000' && c2 < '\024')
                                medium.transaround(arrayOfContO2[xtGraphics.im], arrayOfContO2[record.wasted], c2);
                            if (c2 == '\024') medium.around(arrayOfContO2[record.wasted], false);
                            if (s > record.whenwasted && c2 != '\024') c2++;
                            if ((c2 == '\000' || c2 == '\024') && ++s == 300) {
                                s = 0;
                                c2 = Character.MIN_VALUE;
                                b4++;
                            }
                        } else if (record.closefinish == 1) {
                            if (c2 == '\000') medium.around(arrayOfContO2[xtGraphics.im], false);
                            if (c2 > '\000' && c2 < '\024')
                                medium.transaround(arrayOfContO2[xtGraphics.im], arrayOfContO2[record.wasted], c2);
                            if (c2 == '\024') medium.around(arrayOfContO2[record.wasted], false);
                            if (c2 > '\024' && c2 < '(')
                                medium.transaround(arrayOfContO2[record.wasted], arrayOfContO2[xtGraphics.im], c2 - 20);
                            if (c2 == '(') medium.around(arrayOfContO2[xtGraphics.im], false);
                            if (c2 > '(' && c2 < '<')
                                medium.transaround(arrayOfContO2[xtGraphics.im], arrayOfContO2[record.wasted], c2 - 40);
                            if (c2 == '<') medium.around(arrayOfContO2[record.wasted], false);
                            if (s > 160 && c2 < '\024') c2++;
                            if (s > 230 && c2 < '(') c2++;
                            if (s > 280 && c2 < '<') c2++;
                            if ((c2 == '\000' || c2 == '\024' || c2 == '(' || c2 == '<') && ++s == 300) {
                                s = 0;
                                c2 = Character.MIN_VALUE;
                                b4++;
                            }
                        } else {
                            if (c2 == '\000') medium.around(arrayOfContO2[xtGraphics.im], false);
                            if (c2 > '\000' && c2 < '\024')
                                medium.transaround(arrayOfContO2[xtGraphics.im], arrayOfContO2[record.wasted], c2);
                            if (c2 == '\024') medium.around(arrayOfContO2[record.wasted], false);
                            if (c2 > '\024' && c2 < '(')
                                medium.transaround(arrayOfContO2[record.wasted], arrayOfContO2[xtGraphics.im], c2 - 20);
                            if (c2 == '(') medium.around(arrayOfContO2[xtGraphics.im], false);
                            if (c2 > '(' && c2 < '<')
                                medium.transaround(arrayOfContO2[xtGraphics.im], arrayOfContO2[record.wasted], c2 - 40);
                            if (c2 == '<') medium.around(arrayOfContO2[record.wasted], false);
                            if (c2 > '<' && c2 < 'P')
                                medium.transaround(arrayOfContO2[record.wasted], arrayOfContO2[xtGraphics.im], c2 - 60);
                            if (c2 == 'P') medium.around(arrayOfContO2[xtGraphics.im], false);
                            if (s > 90 && c2 < '\024') c2++;
                            if (s > 160 && c2 < '(') c2++;
                            if (s > 230 && c2 < '<') c2++;
                            if (s > 280 && c2 < 'P') c2++;
                            if ((c2 == '\000' || c2 == '\024' || c2 == '(' || c2 == '<' || c2 == 'P') && ++s == 300) {
                                s = 0;
                                c2 = Character.MIN_VALUE;
                                b4++;
                            }
                        }
                    } else {
                        if (i == 67 && (c2 == '\003' || c2 == '\037' || c2 == 'B')) {
                            this.rd.setColor(new Color(255, 255, 255));
                            this.rd.fillRect(0, 0, 800, 450);
                        }
                        if (i == 69 && (c2 == '\003' || c2 == '\005' || c2 == '\037' || c2 == '!' || c2 == 'B' || c2 == 'D')) {
                            this.rd.setColor(new Color(255, 255, 255));
                            this.rd.fillRect(0, 0, 800, 450);
                        }
                        if (i == 30 && c2 >= '\001' && c2 < '\036')
                            if (c2 % (int) (2.0F + medium.random() * 3.0F) == 0 && !bool3) {
                                this.rd.setColor(new Color(255, 255, 255));
                                this.rd.fillRect(0, 0, 800, 450);
                                bool3 = true;
                            } else {
                                bool3 = false;
                            }
                        if (s > record.whenwasted && c2 != i) c2++;
                        medium.around(arrayOfContO2[xtGraphics.im], false);
                        if ((c2 == '\000' || c2 == i) && ++s == 300) {
                            s = 0;
                            c2 = Character.MIN_VALUE;
                            b4++;
                        }

                    }


                }

            }

            if (xtGraphics.fase == -4) {


                if (s == 0) {
                    xtGraphics.sendwin(checkPoints);
                    if (xtGraphics.winner && xtGraphics.multion == 0 && xtGraphics.gmode != 0 && checkPoints.stage != 27 && checkPoints.stage == xtGraphics.unlocked[xtGraphics.gmode - 1] + (xtGraphics.gmode - 1) * 10) {
                        xtGraphics.unlocked[xtGraphics.gmode - 1] = xtGraphics.unlocked[xtGraphics.gmode - 1] + 1;
                        setcarcookie(xtGraphics.sc[0], carDefine.names[xtGraphics.sc[0]], xtGraphics.arnp, xtGraphics.gmode, xtGraphics.unlocked, false);
                        xtGraphics.unlocked[xtGraphics.gmode - 1] = xtGraphics.unlocked[xtGraphics.gmode - 1] - 1;
                    }
                }

                if (s <= 0) {
                    this.rd.drawImage(xtGraphics.mdness, 289, 30, (ImageObserver) null);
                    this.rd.drawImage(xtGraphics.dude[0], 135, 10, (ImageObserver) null);
                }

                if (s >= 0) xtGraphics.fleximage(this.offImage, s, checkPoints.stage);

                if (++s == 7) {
                    xtGraphics.fase = -5;
                    this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                    this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                }


            }

            if (xtGraphics.fase == -6) {
                repaint();
                xtGraphics.pauseimage(this.offImage);
                xtGraphics.fase = -7;
                this.mouses = 0;
            }

            if (xtGraphics.fase == -7) {
                xtGraphics.pausedgame(checkPoints.stage, this.u[0], record);
                if (s != 0) s = 0;
                xtGraphics.ctachm(this.xm, this.ym, this.mouses, this.u[0]);
                if (this.mouses == 2) this.mouses = 0;
                if (this.mouses == 1) this.mouses = 2;
            }

            if (xtGraphics.fase == -8) {
                xtGraphics.cantreply();
                if (++s == 150 || (this.u[0]).enter || (this.u[0]).handb || this.mouses == 1) {
                    xtGraphics.fase = -7;
                    this.mouses = 0;
                    (this.u[0]).enter = false;
                    (this.u[0]).handb = false;
                }

            }


            if (this.lostfcs && xtGraphics.fase == 7001) if (this.fcscnt == 0) {
                if ((this.u[0]).chatup == 0) requestFocus();
                this.fcscnt = 10;
            } else {
                this.fcscnt--;
            }


            repaint();

            if (xtGraphics.im > -1 && xtGraphics.im < 8) {
                int j = 0;
                if (xtGraphics.multion == 2 || xtGraphics.multion == 3) {
                    j = xtGraphics.im;
                    (this.u[j]).mutem = (this.u[0]).mutem;
                    (this.u[j]).mutes = (this.u[0]).mutes;
                }
                xtGraphics.playsounds(arrayOfMad[xtGraphics.im], this.u[j], checkPoints.stage);
            }

            date = new Date();
            long l4 = date.getTime();


            if (xtGraphics.fase == 0 || xtGraphics.fase == -1 || xtGraphics.fase == -3 || xtGraphics.fase == 7001) {


                if (!bool2) {
                    b2 = 15;
                    f2 = f1;
                    if (f2 < 30.0F) f2 = 30.0F;
                    bool2 = true;
                    b3 = 0;
                }

                if (b3 == 10) {
                    float f = (c1 + uDPMistro.freg - (float) (l4 - l2)) / 20.0F;
                    if (f > 40.0F) f = 40.0F;
                    if (f < -40.0F) f = -40.0F;
                    f2 += f;
                    if (f2 < 5.0F) f2 = 5.0F;
                    medium.adjstfade(f2, f, xtGraphics.starcnt, this);
                    l2 = l4;
                    b3 = 0;
                } else {
                    b3++;
                }


            } else {


                if (bool2) {
                    b2 = 30;
                    f1 = f2;
                    bool2 = false;
                    b3 = 0;
                }

                if (b3 == 10) {
                    if (l4 - l2 < 400L) {
                        f2 = (float) (f2 + 3.5D);
                    } else {
                        f2 = (float) (f2 - 3.5D);
                        if (f2 < 5.0F) f2 = 5.0F;
                    }
                    l2 = l4;
                    b3 = 0;
                } else {
                    b3++;
                }


            }

            if (this.exwist) {


                this.rd.dispose();
                xtGraphics.stopallnow();
                carDefine.stopallnow();


                uDPMistro.UDPquit();
                if (bool1) {
                    lobby.stopallnow();
                    login.stopallnow();
                    globe.stopallnow();
                }

                System.gc();

                if (Madness.endadv == 2) Madness.advopen();

                this.gamer.stop();
                this.gamer = null;

            }


            l1 = Math.round(f2) - l4 - l3;

            if (l1 < b2) l1 = b2;
            try {

                Thread.sleep(l1);

            } catch (InterruptedException interruptedException) {
            }

        }

    }


    public void checkmemory(xtGraphics paramxtGraphics) {

        if (this.applejava || Runtime.getRuntime().freeMemory() / 1048576L < 50L) paramxtGraphics.badmac = true;


    }


    public void paint(Graphics paramGraphics) {

        Graphics2D graphics2D = (Graphics2D) paramGraphics;


        if (this.lastw != getWidth() || this.lasth != getHeight()) {
            this.lastw = getWidth();
            this.lasth = getHeight();
            this.showsize = 100;
            if (this.lastw <= 800 || this.lasth <= 550) this.reqmult = 0.0F;
            if (Madness.fullscreen) {
                this.apx = (int) ((getWidth() / 2) - 400.0F * this.apmult);
                this.apy = (int) ((getHeight() / 2) - 225.0F * this.apmult);
            }
        }

        int i = 0, j = 0;

        if (this.moto == 1 && this.shaka > 0) {
            i = (int) (((this.shaka * 2) * Math.random() - this.shaka) * this.apmult);
            j = (int) (((this.shaka * 2) * Math.random() - this.shaka) * this.apmult);
            this.shaka--;
        }


        if (!Madness.fullscreen) {
            if (this.showsize != 0) {


                if (this.showsize == 100 || this.showsize == 70) graphics2D.clearRect(0, 0, getWidth(), getHeight());

                float f = (getWidth() - 40) / 800.0F - 1.0F;

                if (f > (getHeight() - 70) / 450.0F - 1.0F) f = (getHeight() - 70) / 450.0F - 1.0F;

                if (f > 1.0F) f = 1.0F;

                if (f < 0.0F) f = 0.0F;

                this.apmult = 1.0F + f * this.reqmult;


                if (!this.oncarm) {
                    graphics2D.drawImage(this.carmaker[0], 50, 14, this);
                } else {
                    graphics2D.drawImage(this.carmaker[1], 50, 14, this);
                }

                if (!this.onstgm) {
                    graphics2D.drawImage(this.stagemaker[0], getWidth() - 208, 14, this);
                } else {
                    graphics2D.drawImage(this.stagemaker[1], getWidth() - 208, 14, this);
                }


                graphics2D.drawImage(this.sizebar, getWidth() / 2 - 230, 23, this);

                graphics2D.drawImage(this.blb, (int) ((getWidth() / 2 - 222) + 141.0F * this.reqmult), 23, this);

                graphics2D.drawImage(this.chkbx[this.smooth], getWidth() / 2 - 53, 23, this);

                graphics2D.setFont(new Font("Arial", 1, 11));

                graphics2D.setColor(new Color(74, 99, 125));

                graphics2D.drawString("Screen Size:", getWidth() / 2 - 224, 17);

                graphics2D.drawString("Smooth", getWidth() / 2 - 36, 34);

                graphics2D.drawImage(this.fulls, getWidth() / 2 + 27, 15, this);

                graphics2D.setColor(new Color(94, 126, 159));

                graphics2D.drawString("Fullscreen", getWidth() / 2 + 63, 30);


                graphics2D.drawImage(this.chkbx[Madness.anti], getWidth() / 2 + 135, 9, this);

                graphics2D.drawString("Antialiasing", getWidth() / 2 + 152, 20);

                graphics2D.drawImage(this.chkbx[this.moto], getWidth() / 2 + 135, 26, this);

                graphics2D.drawString("Motion Effects", getWidth() / 2 + 152, 37);


                graphics2D.setColor(new Color(0, 0, 0));
                graphics2D.fillRect(getWidth() / 2 - 153, 5, 80, 16);

                graphics2D.setColor(new Color(121, 135, 152));

                String str = "" + (int) (this.apmult * 100.0F) + "%";

                if (this.reqmult == 0.0F) str = "Original";

                if (this.reqmult == 1.0F) str = "Maximum";

                graphics2D.drawString(str, getWidth() / 2 - 150, 17);


                if (!this.oncarm && !this.onstgm) this.showsize--;

                if (this.showsize == 0) {
                    graphics2D.setColor(new Color(0, 0, 0));
                    graphics2D.fillRect(getWidth() / 2 - 260, 0, 520, 40);
                    graphics2D.fillRect(50, 14, 142, 23);
                    graphics2D.fillRect(getWidth() - 208, 14, 158, 23);
                }


            }

            this.apx = (int) ((getWidth() / 2) - 400.0F * this.apmult);

            this.apy = (int) ((getHeight() / 2) - 225.0F * this.apmult - 50.0F);
            if (this.apy < 50) this.apy = 50;

            if (this.apmult > 1.0F) {
                if (this.smooth == 1) {
                    graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

                    if (this.moto == 1) {
                        graphics2D.setComposite(AlphaComposite.getInstance(3, this.mvect / 100.0F));
                        this.rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
                        graphics2D.drawImage(this.offImage, this.apx + i, this.apy + j, (int) (800.0F * this.apmult), (int) (450.0F * this.apmult), this);
                        cropit(graphics2D, i, j);
                    } else {
                        graphics2D.drawImage(this.offImage, this.apx, this.apy, (int) (800.0F * this.apmult), (int) (450.0F * this.apmult), this);
                    }
                } else if (this.moto == 1) {
                    graphics2D.setComposite(AlphaComposite.getInstance(3, this.mvect / 100.0F));
                    this.rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
                    graphics2D.drawImage(this.offImage, this.apx + i, this.apy + j, (int) (800.0F * this.apmult), (int) (450.0F * this.apmult), this);
                    cropit(graphics2D, i, j);
                } else {
                    graphics2D.drawImage(this.offImage, this.apx, this.apy, (int) (800.0F * this.apmult), (int) (450.0F * this.apmult), this);
                }
            } else if (this.moto == 1) {
                graphics2D.setComposite(AlphaComposite.getInstance(3, this.mvect / 100.0F));
                this.rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
                graphics2D.drawImage(this.offImage, this.apx + i, this.apy + j, this);
                cropit(graphics2D, i, j);
            } else {
                graphics2D.drawImage(this.offImage, this.apx, this.apy, this);
            }
        } else if (this.moto == 1) {
            graphics2D.setComposite(AlphaComposite.getInstance(3, this.mvect / 100.0F));
            this.rd.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_SPEED);
            graphics2D.drawImage(this.offImage, this.apx + i, this.apy + j, this);
            cropit(graphics2D, i, j);
        } else {
            graphics2D.drawImage(this.offImage, this.apx, this.apy, this);
        }


    }


    public void cropit(Graphics2D paramGraphics2D, int paramInt1, int paramInt2) {

        if (paramInt1 != 0 || paramInt2 != 0) {
            paramGraphics2D.setComposite(AlphaComposite.getInstance(3, 1.0F));
            paramGraphics2D.setColor(new Color(0, 0, 0));
        }
        if (paramInt1 != 0) if (paramInt1 < 0) {
            paramGraphics2D.fillRect(this.apx + paramInt1, this.apy - (int) (25.0F * this.apmult), Math.abs(paramInt1), (int) (500.0F * this.apmult));
        } else {
            paramGraphics2D.fillRect(this.apx + (int) (800.0F * this.apmult), this.apy - (int) (25.0F * this.apmult), paramInt1, (int) (500.0F * this.apmult));
        }
        if (paramInt2 != 0) if (paramInt2 < 0) {
            paramGraphics2D.fillRect(this.apx - (int) (25.0F * this.apmult), this.apy + paramInt2, (int) (850.0F * this.apmult), Math.abs(paramInt2));
        } else {
            paramGraphics2D.fillRect(this.apx - (int) (25.0F * this.apmult), this.apy + (int) (450.0F * this.apmult), (int) (850.0F * this.apmult), paramInt2);
        }

    }

    public void update(Graphics paramGraphics) {
        paint(paramGraphics);
    }


    public void init() {

        setBackground(new Color(0, 0, 0));

        this.offImage = createImage(800, 450);

        if (this.offImage != null) this.rd = (Graphics2D) this.offImage.getGraphics();

        this.rd.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        setLayout((LayoutManager) null);


        this.tnick = new TextField("Nickbname");

        this.tnick.setFont(new Font("Arial", 1, 13));

        this.tpass = new TextField("");

        this.tpass.setFont(new Font("Arial", 1, 13));

        this.tpass.setEchoCharacter('*');

        this.temail = new TextField("");

        this.temail.setFont(new Font("Arial", 1, 13));

        this.cmsg = new TextField("");


        if (System.getProperty("java.vendor").toLowerCase().indexOf("oracle") != -1) {

            this.cmsg.addKeyListener(new KeyAdapter() {
                                         public void keyReleased(KeyEvent param1KeyEvent) {
                                         }


                                         public void keyTyped(KeyEvent param1KeyEvent) {
                                         }


                                         public void keyPressed(KeyEvent param1KeyEvent) {

                                             if (param1KeyEvent.getKeyCode() == 10 && GameSparker.this.u[0] != null)
                                                 (GameSparker.this.u[0]).enter = true;

                                         }
                                     }
            );

        }

        this.mmsg = new TextArea("", 200, 20, 3);


        this.cmsg.setFont(new Font("Tahoma", 0, 11));

        this.mmsg.setFont(new Font("Tahoma", 0, 11));

        this.mycar = new Checkbox("Sword of Justice Game!");

        this.notp = new Checkbox("No Trees & Piles");

        this.keplo = new Checkbox("Stay logged in");

        this.keplo.setState(true);


        add(this.tnick);

        add(this.tpass);

        add(this.temail);

        add(this.cmsg);

        add(this.mmsg);

        add(this.mycar);

        add(this.notp);

        add(this.keplo);


        this.sgame.setFont(new Font("Arial", 1, 13));

        this.wgame.setFont(new Font("Arial", 1, 13));

        this.warb.setFont(new Font("Arial", 1, 13));

        this.pgame.setFont(new Font("Arial", 1, 12));

        this.vnpls.setFont(new Font("Arial", 1, 13));

        this.vtyp.setFont(new Font("Arial", 1, 13));

        this.snfmm.setFont(new Font("Arial", 1, 13));

        this.snfm1.setFont(new Font("Arial", 1, 13));

        this.snfm2.setFont(new Font("Arial", 1, 13));

        this.mstgs.setFont(new Font("Arial", 1, 13));

        this.mcars.setFont(new Font("Arial", 1, 13));

        this.slaps.setFont(new Font("Arial", 1, 13));

        this.snpls.setFont(new Font("Arial", 0, 13));

        this.snbts.setFont(new Font("Arial", 0, 13));

        this.swait.setFont(new Font("Arial", 0, 12));

        this.sclass.setFont(new Font("Arial", 1, 12));

        this.scars.setFont(new Font("Arial", 1, 12));

        this.sfix.setFont(new Font("Arial", 1, 12));

        this.mycar.setFont(new Font("Arial", 1, 12));

        this.notp.setFont(new Font("Arial", 1, 12));

        this.keplo.setFont(new Font("Arial", 1, 12));

        this.gmode.setFont(new Font("Arial", 1, 13));

        this.rooms.setFont(new Font("Arial", 1, 13));

        this.sendtyp.setFont(new Font("Arial", 1, 12));

        this.senditem.setFont(new Font("Arial", 1, 12));

        this.datat.setFont(new Font("Arial", 1, 12));

        this.clanlev.setFont(new Font("Arial", 1, 12));

        this.clcars.setFont(new Font("Arial", 1, 12));

        this.clcars.alphad = true;

        this.ilaps.setFont(new Font("Arial", 1, 13));

        this.icars.setFont(new Font("Arial", 1, 12));

        this.proitem.setFont(new Font("Arial", 1, 12));


        this.sgame.add(this.rd, " NFM 1     ");

        this.sgame.add(this.rd, " NFM 2     ");

        this.sgame.add(this.rd, " My Stages ");

        this.sgame.add(this.rd, " Weekly Top20 ");

        this.sgame.add(this.rd, " Monthly Top20 ");

        this.sgame.add(this.rd, " All Time Top20 ");

        this.sgame.add(this.rd, " Stage Maker ");


        this.wgame.add(this.rd, " Normal Game");

        this.wgame.add(this.rd, " War / Battle");

        this.wgame.add(this.rd, " War / Battle - Practice");

        this.warb.add(this.rd, " Loading your clan's wars and battles, please wait...");

        this.pgame.add(this.rd, " Select the game you want to practice");

        this.vnpls.add(this.rd, "Players");

        this.vnpls.add(this.rd, " 2 VS 2");

        this.vnpls.add(this.rd, " 3 VS 3");

        this.vnpls.add(this.rd, " 4 VS 4");

        this.vtyp.add(this.rd, "Normal clan game");

        this.vtyp.add(this.rd, "Racing only");

        this.vtyp.add(this.rd, "Wasting only");

        this.vtyp.add(this.rd, "Racers VS Wasters - my clan wastes");

        this.vtyp.add(this.rd, "Racers VS Wasters - my clan races");


        this.snfmm.add(this.rd, "Select Stage");

        this.snfm1.add(this.rd, "Select Stage");

        this.snfm2.add(this.rd, "Select Stage");

        this.mstgs.add(this.rd, "Suddenly the King becomes Santa's Little Helper");

        this.mcars.add(this.rd, "Sword of Justice");


        this.snpls.add(this.rd, "Select");

        this.swait.add(this.rd, "1 Minute");

        this.ilaps.add(this.rd, "Laps");
        this.ilaps.add(this.rd, "1 Lap");
        byte b;

        for (b = 0; b < 5; ) {
            this.snfmm.add(this.rd, " Stage " + (b + 1) + "");
            b++;
        }

        for (b = 0; b < 10; ) {
            this.snfm1.add(this.rd, " Stage " + (b + 1) + "");
            b++;
        }

        for (b = 0; b < 17; ) {
            this.snfm2.add(this.rd, " Stage " + (b + 1) + "");
            b++;
        }

        for (b = 0; b < 7; ) {
            this.snpls.add(this.rd, "    " + (b + 2) + "");
            b++;
        }

        for (b = 0; b < 7; ) {
            this.snbts.add(this.rd, "    " + b + "    ");
            b++;
        }

        for (b = 0; b < 2; ) {
            this.swait.add(this.rd, "" + (b + 2) + " Minutes");
            b++;
        }

        for (b = 0; b < 15; ) {
            this.slaps.add(this.rd, "" + (b + 1) + "");
            b++;
        }

        for (b = 0; b < 14; ) {
            this.ilaps.add(this.rd, "" + (b + 2) + " Laps");
            b++;
        }

        this.sclass.add(this.rd, "All Classes");

        this.sclass.add(this.rd, "Class C Cars");

        this.sclass.add(this.rd, "Class B & C Cars");

        this.sclass.add(this.rd, "Class B Cars");

        this.sclass.add(this.rd, "Class A & B Cars");

        this.sclass.add(this.rd, "Class A Cars");

        this.scars.add(this.rd, "All Cars");

        this.scars.add(this.rd, "Custom Cars");

        this.scars.add(this.rd, "Game Cars");

        this.sfix.add(this.rd, "Unlimited Fixing");

        this.sfix.add(this.rd, "4 Fixes");

        this.sfix.add(this.rd, "3 Fixes");

        this.sfix.add(this.rd, "2 Fixes");

        this.sfix.add(this.rd, "1 Fix");

        this.sfix.add(this.rd, "No Fixing");

        this.icars.add(this.rd, "Type of Cars");

        this.icars.add(this.rd, "All Cars");

        this.icars.add(this.rd, "Clan Cars");

        this.icars.add(this.rd, "Game Cars");

        this.icars.w = 140;


        this.gmode.add(this.rd, " Normal Game ");

        this.gmode.add(this.rd, " Practice Game ");


        this.rooms.rooms = true;

        this.rooms.add(this.rd, "Ghostrider :: 1");


        this.sendtyp.add(this.rd, "Write a Message");

        this.sendtyp.add(this.rd, "Share a Custom Car");

        this.sendtyp.add(this.rd, "Share a Custom Stage");

        this.sendtyp.add(this.rd, "Send a Clan Invitation");

        this.sendtyp.add(this.rd, "Share a Relative Date");

        this.senditem.add(this.rd, "Suddenly the King becomes Santa's Little Helper");

        for (b = 0; b < 6; ) {
            this.clanlev.add(this.rd, "" + (b + 1) + "");
            b++;
        }
        this.clanlev.add(this.rd, "7 - Admin");

        hidefields();

    }


    public void hidefields() {

        this.ilaps.hide();
        this.icars.hide();
        this.proitem.hide();
        this.clcars.hide();
        this.clanlev.hide();
        this.mmsg.hide();
        this.datat.hide();
        this.senditem.hide();
        this.sendtyp.hide();
        this.rooms.hide();
        this.mcars.hide();
        this.mstgs.hide();
        this.gmode.hide();
        this.sclass.hide();
        this.scars.hide();
        this.sfix.hide();
        this.mycar.hide();
        this.notp.hide();
        this.keplo.hide();
        this.tnick.hide();
        this.tpass.hide();
        this.temail.hide();
        this.cmsg.hide();
        this.sgame.hide();
        this.wgame.hide();
        this.pgame.hide();
        this.vnpls.hide();
        this.vtyp.hide();
        this.warb.hide();
        this.slaps.hide();
        this.snfm1.hide();
        this.snfmm.hide();
        this.snfm2.hide();
        this.snpls.hide();
        this.snbts.hide();
        this.swait.hide();

    }


    public void drawms() {

        this.openm = false;

        if (this.gmode.draw(this.rd, this.xm, this.ym, this.moused, 450, true)) this.openm = true;

        if (this.swait.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.slaps.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.snpls.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.snbts.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.scars.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.sgame.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.snfm1.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.snfm2.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.snfmm.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.mstgs.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.mcars.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.pgame.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.vnpls.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.vtyp.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.warb.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.wgame.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.rooms.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.sendtyp.draw(this.rd, this.xm, this.ym, this.moused, 450, true)) this.openm = true;

        if (this.senditem.draw(this.rd, this.xm, this.ym, this.moused, 450, true)) this.openm = true;

        if (this.datat.draw(this.rd, this.xm, this.ym, this.moused, 450, true)) this.openm = true;

        if (this.clanlev.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.clcars.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.ilaps.draw(this.rd, this.xm, this.ym, this.moused, 450, true)) this.openm = true;

        if (this.icars.draw(this.rd, this.xm, this.ym, this.moused, 450, true)) this.openm = true;

        if (this.proitem.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.sfix.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;

        if (this.sclass.draw(this.rd, this.xm, this.ym, this.moused, 450, false)) this.openm = true;


    }


    public void movefield(Component paramComponent, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {

        if (paramInt3 == 360 || paramInt3 == 576) {
            paramInt1 = (int) (paramInt1 * this.apmult + this.apx + (paramComponent.getWidth() / 2) * (this.apmult - 1.0F));
            paramInt2 = (int) (paramInt2 * this.apmult + this.apy + 12.0F * (this.apmult - 1.0F));
        } else {
            paramInt1 = (int) (paramInt1 * this.apmult + this.apx);
            paramInt2 = (int) (paramInt2 * this.apmult + this.apy + 12.0F * (this.apmult - 1.0F));
        }

        if (paramComponent.getX() != paramInt1 || paramComponent.getY() != paramInt2)
            paramComponent.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);


    }


    public void movefieldd(TextField paramTextField, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {

        if (this.applejava) {


            if (paramBoolean) {

                if ((this.xm > paramInt1 && this.xm < paramInt1 + paramInt3 && this.ym > paramInt2 && this.ym < paramInt2 + paramInt4) || !paramTextField.getText().equals("")) {


                    if (!paramTextField.isShowing()) {
                        paramTextField.show();
                        paramTextField.requestFocus();
                    }


                    if (paramInt3 == 360 || paramInt3 == 576) {
                        paramInt1 = (int) (paramInt1 * this.apmult + this.apx + (paramTextField.getWidth() / 2) * (this.apmult - 1.0F));
                        paramInt2 = (int) (paramInt2 * this.apmult + this.apy + 12.0F * (this.apmult - 1.0F));
                    } else {
                        paramInt1 = (int) (paramInt1 * this.apmult + this.apx);
                        paramInt2 = (int) (paramInt2 * this.apmult + this.apy + 12.0F * (this.apmult - 1.0F));
                    }

                    if (paramTextField.getX() != paramInt1 || paramTextField.getY() != paramInt2)
                        paramTextField.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);


                } else {


                    if (paramTextField.isShowing()) {
                        paramTextField.hide();
                        requestFocus();
                    }

                    this.rd.setColor(paramTextField.getBackground());

                    this.rd.fillRect(paramInt1, paramInt2, paramInt3 - 1, paramInt4 - 1);

                    this.rd.setColor(paramTextField.getBackground().darker());

                    this.rd.drawRect(paramInt1, paramInt2, paramInt3 - 1, paramInt4 - 1);

                }

            }

        } else {

            if (paramBoolean && !paramTextField.isShowing()) paramTextField.show();
            movefield(paramTextField, paramInt1, paramInt2, paramInt3, paramInt4);

        }

    }


    public void movefielda(TextArea paramTextArea, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {

        if (this.applejava) {


            if ((this.xm > paramInt1 && this.xm < paramInt1 + paramInt3 && this.ym > paramInt2 && this.ym < paramInt2 + paramInt4) || !paramTextArea.getText().equals(" ")) {


                if (!paramTextArea.isShowing()) {
                    paramTextArea.show();
                    paramTextArea.requestFocus();
                }


                if (paramInt3 == 360 || paramInt3 == 576) {
                    paramInt1 = (int) (paramInt1 * this.apmult + this.apx + (paramTextArea.getWidth() / 2) * (this.apmult - 1.0F));
                    paramInt2 = (int) (paramInt2 * this.apmult + this.apy + 12.0F * (this.apmult - 1.0F));
                } else {
                    paramInt1 = (int) (paramInt1 * this.apmult + this.apx);
                    paramInt2 = (int) (paramInt2 * this.apmult + this.apy + 12.0F * (this.apmult - 1.0F));
                }

                if (paramTextArea.getX() != paramInt1 || paramTextArea.getY() != paramInt2)
                    paramTextArea.setBounds(paramInt1, paramInt2, paramInt3, paramInt4);


            } else {


                if (paramTextArea.isShowing()) {
                    paramTextArea.hide();
                    requestFocus();
                }

                this.rd.setColor(paramTextArea.getBackground());

                this.rd.fillRect(paramInt1, paramInt2, paramInt3 - 1, paramInt4 - 1);

                this.rd.setColor(paramTextArea.getBackground().darker());

                this.rd.drawRect(paramInt1, paramInt2, paramInt3 - 1, paramInt4 - 1);

            }

        } else {

            if (!paramTextArea.isShowing()) paramTextArea.show();
            movefield(paramTextArea, paramInt1, paramInt2, paramInt3, paramInt4);

        }

    }


    public void loadstage(ContO[] paramArrayOfContO1, ContO[] paramArrayOfContO2, Medium paramMedium, Trackers paramTrackers, CheckPoints paramCheckPoints, xtGraphics paramxtGraphics, Mad[] paramArrayOfMad, Record paramRecord) {

        if (paramxtGraphics.testdrive == 2 || paramxtGraphics.testdrive == 4) paramxtGraphics.nplayers = 1;

        if (paramxtGraphics.gmode == 1) {
            paramxtGraphics.nplayers = 5;
            paramxtGraphics.xstart[4] = 0;
            paramxtGraphics.zstart[4] = 760;
        }

        paramTrackers.nt = 0;

        this.nob = paramxtGraphics.nplayers;

        this.notb = 0;

        paramCheckPoints.n = 0;

        paramCheckPoints.nsp = 0;

        paramCheckPoints.fn = 0;

        paramCheckPoints.trackname = "";

        paramCheckPoints.haltall = false;

        paramCheckPoints.wasted = 0;

        paramCheckPoints.catchfin = 0;


        paramMedium.resdown = 0;

        paramMedium.rescnt = 5;

        paramMedium.lightson = false;

        paramMedium.noelec = 0;

        paramMedium.ground = 250;

        paramMedium.trk = 0;

        this.view = 0;


        int i = 0, j = 100, k = 0, m = 100;


        paramxtGraphics.newparts = false;

        String str = "";


        try {
            DataInputStream dataInputStream = null;


            if (paramxtGraphics.multion == 0 && paramCheckPoints.stage != -2) {


                String str2 = "stages/" + paramCheckPoints.stage + "";
                if (paramCheckPoints.stage == -1) str2 = "mystages/" + paramCheckPoints.name + "";

                File file = new File("" + Madness.fpath + "" + str2 + ".txt");

                dataInputStream = new DataInputStream(new FileInputStream(file));


            } else if (paramCheckPoints.stage > 0) {


                URL uRL = new URL("http://multiplayer.needformadness.com/stages/" + paramCheckPoints.stage + ".txt");

                dataInputStream = new DataInputStream(uRL.openStream());

            } else {

                ZipInputStream zipInputStream;


                String str2 = "http://multiplayer.needformadness.com/tracks/" + paramCheckPoints.name + ".radq";
                str2 = str2.replace(' ', '_');
                URL uRL = new URL(str2);

                int n = uRL.openConnection().getContentLength();
                DataInputStream dataInputStream1 = new DataInputStream(uRL.openStream());

                byte[] arrayOfByte1 = new byte[n];
                dataInputStream1.readFully(arrayOfByte1);

                if (arrayOfByte1[0] == 80 && arrayOfByte1[1] == 75 && arrayOfByte1[2] == 3) {
                    zipInputStream = new ZipInputStream(new ByteArrayInputStream(arrayOfByte1));
                } else {
                    byte[] arrayOfByte;
                    byte b;
                    for (arrayOfByte = new byte[n - 40], b = 0; b < n - 40; ) {
                        byte b1 = 20;
                        if (b >= 'Ǵ') b1 = 40;
                        arrayOfByte[b] = arrayOfByte1[b + b1];
                        b++;
                    }
                    zipInputStream = new ZipInputStream(new ByteArrayInputStream(arrayOfByte));
                }

                ZipEntry zipEntry;
                int i1;
                byte[] arrayOfByte2;
                int i2;
                for (zipEntry = zipInputStream.getNextEntry(), i1 = Integer.valueOf(zipEntry.getName()).intValue(), arrayOfByte2 = new byte[i1], i2 = 0; i1 > 0; ) {
                    int i3 = zipInputStream.read(arrayOfByte2, i2, i1);
                    i2 += i3;
                    i1 -= i3;
                }

                zipInputStream.close();
                dataInputStream1.close();

                dataInputStream = new DataInputStream(new ByteArrayInputStream(arrayOfByte2));

            }


            String str1;

            while ((str1 = dataInputStream.readLine()) != null) {


                str = "" + str1.trim();

                if (str.startsWith("snap"))
                    paramMedium.setsnap(getint("snap", str, 0), getint("snap", str, 1), getint("snap", str, 2));

                if (str.startsWith("sky")) {
                    paramMedium.setsky(getint("sky", str, 0), getint("sky", str, 1), getint("sky", str, 2));
                    paramxtGraphics.snap(paramCheckPoints.stage);
                }

                if (str.startsWith("ground"))
                    paramMedium.setgrnd(getint("ground", str, 0), getint("ground", str, 1), getint("ground", str, 2));

                if (str.startsWith("polys"))
                    paramMedium.setpolys(getint("polys", str, 0), getint("polys", str, 1), getint("polys", str, 2));

                if (str.startsWith("fog"))
                    paramMedium.setfade(getint("fog", str, 0), getint("fog", str, 1), getint("fog", str, 2));

                if (str.startsWith("texture"))
                    paramMedium.setexture(getint("texture", str, 0), getint("texture", str, 1), getint("texture", str, 2), getint("texture", str, 3));

                if (str.startsWith("clouds"))
                    paramMedium.setcloads(getint("clouds", str, 0), getint("clouds", str, 1), getint("clouds", str, 2), getint("clouds", str, 3), getint("clouds", str, 4));


                if (str.startsWith("density")) {
                    paramMedium.fogd = (getint("density", str, 0) + 1) * 2 - 1;
                    if (paramMedium.fogd < 1) paramMedium.fogd = 1;
                    if (paramMedium.fogd > 30) paramMedium.fogd = 30;
                }

                if (str.startsWith("fadefrom")) paramMedium.fadfrom(getint("fadefrom", str, 0));

                if (str.startsWith("lightson")) paramMedium.lightson = true;

                if (str.startsWith("mountains")) paramMedium.mgen = getint("mountains", str, 0);


                if (str.startsWith("set")) {
                    int n = getint("set", str, 0);
                    if (paramxtGraphics.nplayers == 8) {
                        if (n == 47) n = 76;
                        if (n == 48) n = 77;
                    }
                    boolean bool = true;
                    if (n >= 65 && n <= 75 && paramCheckPoints.notb) bool = false;
                    if (bool) {
                        if (n == 49 || n == 64 || (n >= 56 && n <= 61)) paramxtGraphics.newparts = true;
                        if ((paramCheckPoints.stage < 0 || paramCheckPoints.stage >= 28) && n >= 10 && n <= 25)
                            paramMedium.loadnew = true;
                        n += 46;
                        paramArrayOfContO1[this.nob] = new ContO(paramArrayOfContO2[n], getint("set", str, 1), paramMedium.ground - (paramArrayOfContO2[n]).grat, getint("set", str, 2), getint("set", str, 3));
                        if (str.indexOf(")p") != -1) {
                            paramCheckPoints.x[paramCheckPoints.n] = getint("set", str, 1);
                            paramCheckPoints.z[paramCheckPoints.n] = getint("set", str, 2);
                            paramCheckPoints.y[paramCheckPoints.n] = 0;
                            paramCheckPoints.typ[paramCheckPoints.n] = 0;
                            if (str.indexOf(")pt") != -1) paramCheckPoints.typ[paramCheckPoints.n] = -1;
                            if (str.indexOf(")pr") != -1) paramCheckPoints.typ[paramCheckPoints.n] = -2;
                            if (str.indexOf(")po") != -1) paramCheckPoints.typ[paramCheckPoints.n] = -3;
                            if (str.indexOf(")ph") != -1) paramCheckPoints.typ[paramCheckPoints.n] = -4;
                            if (str.indexOf("out") != -1) System.out.println("out: " + paramCheckPoints.n);
                            paramCheckPoints.n++;
                            this.notb = this.nob + 1;
                        }
                        this.nob++;
                        if (paramMedium.loadnew) paramMedium.loadnew = false;
                    }
                }

                if (str.startsWith("chk")) {
                    int n = getint("chk", str, 0);
                    n += 46;
                    int i1 = paramMedium.ground - (paramArrayOfContO2[n]).grat;
                    if (n == 110) i1 = getint("chk", str, 4);
                    paramArrayOfContO1[this.nob] = new ContO(paramArrayOfContO2[n], getint("chk", str, 1), i1, getint("chk", str, 2), getint("chk", str, 3));
                    paramCheckPoints.x[paramCheckPoints.n] = getint("chk", str, 1);
                    paramCheckPoints.z[paramCheckPoints.n] = getint("chk", str, 2);
                    paramCheckPoints.y[paramCheckPoints.n] = i1;
                    if (getint("chk", str, 3) == 0) {
                        paramCheckPoints.typ[paramCheckPoints.n] = 1;
                    } else {
                        paramCheckPoints.typ[paramCheckPoints.n] = 2;
                    }
                    paramCheckPoints.pcs = paramCheckPoints.n;
                    paramCheckPoints.n++;
                    (paramArrayOfContO1[this.nob]).checkpoint = paramCheckPoints.nsp + 1;
                    paramCheckPoints.nsp++;
                    this.notb = ++this.nob;
                }

                if (paramCheckPoints.nfix != 5 && str.startsWith("fix")) {
                    int n = getint("fix", str, 0);
                    n += 46;
                    paramArrayOfContO1[this.nob] = new ContO(paramArrayOfContO2[n], getint("fix", str, 1), getint("fix", str, 3), getint("fix", str, 2), getint("fix", str, 4));
                    paramCheckPoints.fx[paramCheckPoints.fn] = getint("fix", str, 1);
                    paramCheckPoints.fz[paramCheckPoints.fn] = getint("fix", str, 2);
                    paramCheckPoints.fy[paramCheckPoints.fn] = getint("fix", str, 3);
                    (paramArrayOfContO1[this.nob]).elec = true;
                    if (getint("fix", str, 4) != 0) {
                        paramCheckPoints.roted[paramCheckPoints.fn] = true;
                        (paramArrayOfContO1[this.nob]).roted = true;
                    } else {
                        paramCheckPoints.roted[paramCheckPoints.fn] = false;
                    }
                    if (str.indexOf(")s") != -1) {
                        paramCheckPoints.special[paramCheckPoints.fn] = true;
                    } else {
                        paramCheckPoints.special[paramCheckPoints.fn] = false;
                    }
                    paramCheckPoints.fn++;
                    this.notb = ++this.nob;
                }

                if (!paramCheckPoints.notb && str.startsWith("pile")) {
                    paramArrayOfContO1[this.nob] = new ContO(getint("pile", str, 0), getint("pile", str, 1), getint("pile", str, 2), paramMedium, paramTrackers, getint("pile", str, 3), getint("pile", str, 4), paramMedium.ground);
                    this.nob++;
                }


                if (paramxtGraphics.multion == 0 && str.startsWith("nlaps")) {
                    paramCheckPoints.nlaps = getint("nlaps", str, 0);
                    if (paramCheckPoints.nlaps < 1) paramCheckPoints.nlaps = 1;
                    if (paramCheckPoints.nlaps > 15) paramCheckPoints.nlaps = 15;
                }

                if (paramCheckPoints.stage > 0 && str.startsWith("name"))
                    paramCheckPoints.name = getstring("name", str, 0).replace('|', ',');

                if (str.startsWith("stagemaker")) paramCheckPoints.maker = getstring("stagemaker", str, 0);

                if (str.startsWith("publish")) paramCheckPoints.pubt = getint("publish", str, 0);


                if (str.startsWith("soundtrack")) {
                    paramCheckPoints.trackname = getstring("soundtrack", str, 0);
                    paramCheckPoints.trackvol = getint("soundtrack", str, 1);
                    if (paramCheckPoints.trackvol < 50) paramCheckPoints.trackvol = 50;
                    if (paramCheckPoints.trackvol > 300) paramCheckPoints.trackvol = 300;
                    paramxtGraphics.sndsize[32] = getint("soundtrack", str, 2);
                }


                if (str.startsWith("maxr")) {
                    int n;
                    int i1;
                    int i2;
                    byte b;
                    for (n = getint("maxr", str, 0), i = i1 = getint("maxr", str, 1), i2 = getint("maxr", str, 2), b = 0; b < n; ) {
                        paramArrayOfContO1[this.nob] = new ContO(paramArrayOfContO2[85], i1, paramMedium.ground - (paramArrayOfContO2[85]).grat, b * 4800 + i2, 0);
                        this.nob++;
                        b++;
                    }
                    paramTrackers.y[paramTrackers.nt] = -5000;
                    paramTrackers.rady[paramTrackers.nt] = 7100;
                    paramTrackers.x[paramTrackers.nt] = i1 + 500;
                    paramTrackers.radx[paramTrackers.nt] = 600;
                    paramTrackers.z[paramTrackers.nt] = n * 4800 / 2 + i2 - 2400;
                    paramTrackers.radz[paramTrackers.nt] = n * 4800 / 2;
                    paramTrackers.xy[paramTrackers.nt] = 90;
                    paramTrackers.zy[paramTrackers.nt] = 0;
                    paramTrackers.dam[paramTrackers.nt] = 167;
                    paramTrackers.decor[paramTrackers.nt] = false;
                    paramTrackers.skd[paramTrackers.nt] = 0;
                    paramTrackers.nt++;
                }

                if (str.startsWith("maxl")) {
                    int n;
                    int i1;
                    int i2;
                    byte b;
                    for (n = getint("maxl", str, 0), j = i1 = getint("maxl", str, 1), i2 = getint("maxl", str, 2), b = 0; b < n; ) {
                        paramArrayOfContO1[this.nob] = new ContO(paramArrayOfContO2[85], i1, paramMedium.ground - (paramArrayOfContO2[85]).grat, b * 4800 + i2, 180);
                        this.nob++;
                        b++;
                    }
                    paramTrackers.y[paramTrackers.nt] = -5000;
                    paramTrackers.rady[paramTrackers.nt] = 7100;
                    paramTrackers.x[paramTrackers.nt] = i1 - 500;
                    paramTrackers.radx[paramTrackers.nt] = 600;
                    paramTrackers.z[paramTrackers.nt] = n * 4800 / 2 + i2 - 2400;
                    paramTrackers.radz[paramTrackers.nt] = n * 4800 / 2;
                    paramTrackers.xy[paramTrackers.nt] = -90;
                    paramTrackers.zy[paramTrackers.nt] = 0;
                    paramTrackers.dam[paramTrackers.nt] = 167;
                    paramTrackers.decor[paramTrackers.nt] = false;
                    paramTrackers.skd[paramTrackers.nt] = 0;
                    paramTrackers.nt++;
                }

                if (str.startsWith("maxt")) {
                    int n;
                    int i1;
                    int i2;
                    byte b;
                    for (n = getint("maxt", str, 0), k = i1 = getint("maxt", str, 1), i2 = getint("maxt", str, 2), b = 0; b < n; ) {
                        paramArrayOfContO1[this.nob] = new ContO(paramArrayOfContO2[85], b * 4800 + i2, paramMedium.ground - (paramArrayOfContO2[85]).grat, i1, 90);
                        this.nob++;
                        b++;
                    }
                    paramTrackers.y[paramTrackers.nt] = -5000;
                    paramTrackers.rady[paramTrackers.nt] = 7100;
                    paramTrackers.z[paramTrackers.nt] = i1 + 500;
                    paramTrackers.radz[paramTrackers.nt] = 600;
                    paramTrackers.x[paramTrackers.nt] = n * 4800 / 2 + i2 - 2400;
                    paramTrackers.radx[paramTrackers.nt] = n * 4800 / 2;
                    paramTrackers.zy[paramTrackers.nt] = 90;
                    paramTrackers.xy[paramTrackers.nt] = 0;
                    paramTrackers.dam[paramTrackers.nt] = 167;
                    paramTrackers.decor[paramTrackers.nt] = false;
                    paramTrackers.skd[paramTrackers.nt] = 0;
                    paramTrackers.nt++;
                }

                if (str.startsWith("maxb")) {
                    int n;
                    int i1;
                    int i2;
                    byte b;
                    for (n = getint("maxb", str, 0), m = i1 = getint("maxb", str, 1), i2 = getint("maxb", str, 2), b = 0; b < n; ) {
                        paramArrayOfContO1[this.nob] = new ContO(paramArrayOfContO2[85], b * 4800 + i2, paramMedium.ground - (paramArrayOfContO2[85]).grat, i1, -90);
                        this.nob++;
                        b++;
                    }
                    paramTrackers.y[paramTrackers.nt] = -5000;
                    paramTrackers.rady[paramTrackers.nt] = 7100;
                    paramTrackers.z[paramTrackers.nt] = i1 - 500;
                    paramTrackers.radz[paramTrackers.nt] = 600;
                    paramTrackers.x[paramTrackers.nt] = n * 4800 / 2 + i2 - 2400;
                    paramTrackers.radx[paramTrackers.nt] = n * 4800 / 2;
                    paramTrackers.zy[paramTrackers.nt] = -90;
                    paramTrackers.xy[paramTrackers.nt] = 0;
                    paramTrackers.dam[paramTrackers.nt] = 167;
                    paramTrackers.decor[paramTrackers.nt] = false;
                    paramTrackers.skd[paramTrackers.nt] = 0;
                    paramTrackers.nt++;
                }


            }
            dataInputStream.close();

            paramMedium.newpolys(j, i - j, m, k - m, paramTrackers, this.notb);

            paramMedium.newclouds(j, i, m, k);

            paramMedium.newmountains(j, i, m, k);

            paramMedium.newstars();

            paramTrackers.devidetrackers(j, i - j, m, k - m);
        } catch (Exception exception) {
            paramCheckPoints.stage = -3;
            System.out.println("Error in stage " + paramCheckPoints.stage);
            System.out.println("" + exception);
            System.out.println("At line: " + str);
        }

        if (paramCheckPoints.nsp < 2) paramCheckPoints.stage = -3;

        if (paramMedium.nrw * paramMedium.ncl >= 16000) paramCheckPoints.stage = -3;


        if (paramCheckPoints.stage != -3) {
            paramCheckPoints.top20 = Math.abs(paramCheckPoints.top20);

            if (paramCheckPoints.stage == 26) {
                paramMedium.lightn = 0;
            } else {
                paramMedium.lightn = -1;
            }

            if (paramCheckPoints.stage == 1 || paramCheckPoints.stage == 11) {
                paramMedium.nochekflk = false;
            } else {
                paramMedium.nochekflk = true;
            }

            int n;

            for (n = 0; n < paramxtGraphics.nplayers; ) {
                this.u[n].reset(paramCheckPoints, paramxtGraphics.sc[n]);
                n++;
            }

            paramxtGraphics.resetstat(paramCheckPoints.stage);
            paramCheckPoints.calprox();

            for (n = 0; n < paramxtGraphics.nplayers; ) {
                if (paramxtGraphics.fase == 22) paramxtGraphics.colorCar(paramArrayOfContO2[paramxtGraphics.sc[n]], n);
                paramArrayOfContO1[n] = new ContO(paramArrayOfContO2[paramxtGraphics.sc[n]], paramxtGraphics.xstart[n], 250 - (paramArrayOfContO2[paramxtGraphics.sc[n]]).grat, paramxtGraphics.zstart[n], 0);
                paramArrayOfMad[n].reseto(paramxtGraphics.sc[n], paramArrayOfContO1[n], paramCheckPoints);
                n++;
            }


            if (paramxtGraphics.fase == 2 || paramxtGraphics.fase == -22) {
                paramMedium.trx = ((j + i) / 2);
                paramMedium.trz = ((k + m) / 2);
                paramMedium.ptr = 0;
                paramMedium.ptcnt = -10;
                paramMedium.hit = 45000;
                paramMedium.fallen = 0;
                paramMedium.nrnd = 0;
                paramMedium.trk = 1;
                paramMedium.ih = 25;
                paramMedium.iw = 65;
                paramMedium.h = 425;
                paramMedium.w = 735;
                paramxtGraphics.fase = 1;
                this.mouses = 0;
            }

            if (paramxtGraphics.fase == 22) {
                paramMedium.crs = false;
                paramxtGraphics.fase = 5;
            }


            if (paramCheckPoints.stage > 0) {
                n = paramCheckPoints.stage;

                if (n > 27) {
                    n -= 27;
                } else if (n > 10) {
                    n -= 10;
                }

                paramxtGraphics.asay = "Stage " + n + ":  " + paramCheckPoints.name + " ";
            } else {
                paramxtGraphics.asay = "Custom Stage:  " + paramCheckPoints.name + " ";
            }

            paramRecord.reset(paramArrayOfContO1);
        } else if (paramxtGraphics.fase == 2) {
            paramxtGraphics.fase = 1;
        }


        System.gc();

    }


    public boolean loadstagePreview(int paramInt, String paramString, ContO[] paramArrayOfContO1, ContO[] paramArrayOfContO2, Medium paramMedium, CheckPoints paramCheckPoints) {

        boolean bool = true;

        if (paramInt < 100) {
            paramCheckPoints.stage = paramInt;
            if (paramCheckPoints.stage < 0) paramCheckPoints.name = paramString;
        } else {
            paramCheckPoints.stage = -2;
            if (this.sgame.getSelectedIndex() == 3 || this.sgame.getSelectedIndex() == 4) {
                paramCheckPoints.name = this.mstgs.getSelectedItem();
            } else {
                int n = this.mstgs.getSelectedItem().indexOf(" ") + 1;
                if (n > 0) paramCheckPoints.name = this.mstgs.getSelectedItem().substring(n);
            }
        }

        this.nob = 0;

        paramCheckPoints.n = 0;

        paramCheckPoints.nsp = 0;

        paramCheckPoints.fn = 0;

        paramCheckPoints.haltall = false;

        paramCheckPoints.wasted = 0;

        paramCheckPoints.catchfin = 0;

        paramMedium.ground = 250;

        this.view = 0;

        paramMedium.trx = 0L;
        paramMedium.trz = 0L;


        int i = 0, j = 100, k = 0, m = 100;


        String str = "";


        try {

            DataInputStream dataInputStream = null;

            if (paramCheckPoints.stage > 0) {


                URL uRL = new URL("http://multiplayer.needformadness.com/stages/" + paramCheckPoints.stage + ".txt");

                dataInputStream = new DataInputStream(uRL.openStream());

            } else {

                ZipInputStream zipInputStream;


                String str2 = "http://multiplayer.needformadness.com/tracks/" + paramCheckPoints.name + ".radq";
                str2 = str2.replace(' ', '_');
                URL uRL = new URL(str2);

                int n = uRL.openConnection().getContentLength();
                DataInputStream dataInputStream1 = new DataInputStream(uRL.openStream());

                byte[] arrayOfByte1 = new byte[n];
                dataInputStream1.readFully(arrayOfByte1);

                if (arrayOfByte1[0] == 80 && arrayOfByte1[1] == 75 && arrayOfByte1[2] == 3) {
                    zipInputStream = new ZipInputStream(new ByteArrayInputStream(arrayOfByte1));
                } else {
                    byte[] arrayOfByte;
                    byte b;
                    for (arrayOfByte = new byte[n - 40], b = 0; b < n - 40; ) {
                        byte b1 = 20;
                        if (b >= 'Ǵ') b1 = 40;
                        arrayOfByte[b] = arrayOfByte1[b + b1];
                        b++;
                    }
                    zipInputStream = new ZipInputStream(new ByteArrayInputStream(arrayOfByte));
                }

                ZipEntry zipEntry;
                int i1;
                byte[] arrayOfByte2;
                int i2;
                for (zipEntry = zipInputStream.getNextEntry(), i1 = Integer.valueOf(zipEntry.getName()).intValue(), arrayOfByte2 = new byte[i1], i2 = 0; i1 > 0; ) {
                    int i3 = zipInputStream.read(arrayOfByte2, i2, i1);
                    i2 += i3;
                    i1 -= i3;
                }

                zipInputStream.close();
                dataInputStream1.close();

                dataInputStream = new DataInputStream(new ByteArrayInputStream(arrayOfByte2));

            }

            String str1;

            while ((str1 = dataInputStream.readLine()) != null) {


                str = "" + str1.trim();


                if (str.startsWith("snap"))
                    paramMedium.setsnap(getint("snap", str, 0), getint("snap", str, 1), getint("snap", str, 2));

                if (str.startsWith("sky"))
                    paramMedium.setsky(getint("sky", str, 0), getint("sky", str, 1), getint("sky", str, 2));

                if (str.startsWith("ground"))
                    paramMedium.setgrnd(getint("ground", str, 0), getint("ground", str, 1), getint("ground", str, 2));

                if (str.startsWith("polys"))
                    paramMedium.setpolys(getint("polys", str, 0), getint("polys", str, 1), getint("polys", str, 2));

                if (str.startsWith("fog"))
                    paramMedium.setfade(getint("fog", str, 0), getint("fog", str, 1), getint("fog", str, 2));

                if (str.startsWith("texture"))
                    paramMedium.setexture(getint("texture", str, 0), getint("texture", str, 1), getint("texture", str, 2), getint("texture", str, 3));

                if (str.startsWith("clouds"))
                    paramMedium.setcloads(getint("clouds", str, 0), getint("clouds", str, 1), getint("clouds", str, 2), getint("clouds", str, 3), getint("clouds", str, 4));


                if (str.startsWith("density")) {
                    paramMedium.fogd = (getint("density", str, 0) + 1) * 2 - 1;
                    if (paramMedium.fogd < 1) paramMedium.fogd = 1;
                    if (paramMedium.fogd > 30) paramMedium.fogd = 30;
                }

                if (str.startsWith("fadefrom")) paramMedium.fadfrom(getint("fadefrom", str, 0));

                if (str.startsWith("lightson")) paramMedium.lightson = true;

                if (str.startsWith("mountains")) paramMedium.mgen = getint("mountains", str, 0);


                if (str.startsWith("soundtrack")) {
                    paramCheckPoints.trackname = getstring("soundtrack", str, 0);
                    paramCheckPoints.trackvol = getint("soundtrack", str, 1);
                    if (paramCheckPoints.trackvol < 50) paramCheckPoints.trackvol = 50;
                    if (paramCheckPoints.trackvol > 300) paramCheckPoints.trackvol = 300;

                }


                if (str.startsWith("set")) {
                    int n = getint("set", str, 0);
                    n += 46;
                    paramArrayOfContO1[this.nob] = new ContO(paramArrayOfContO2[n], getint("set", str, 1), paramMedium.ground - (paramArrayOfContO2[n]).grat, getint("set", str, 2), getint("set", str, 3));
                    (paramArrayOfContO1[this.nob]).t.nt = 0;
                    if (str.indexOf(")p") != -1) {
                        paramCheckPoints.x[paramCheckPoints.n] = getint("chk", str, 1);
                        paramCheckPoints.z[paramCheckPoints.n] = getint("chk", str, 2);
                        paramCheckPoints.y[paramCheckPoints.n] = 0;
                        paramCheckPoints.typ[paramCheckPoints.n] = 0;
                        if (str.indexOf(")pt") != -1) paramCheckPoints.typ[paramCheckPoints.n] = -1;
                        if (str.indexOf(")pr") != -1) paramCheckPoints.typ[paramCheckPoints.n] = -2;
                        if (str.indexOf(")po") != -1) paramCheckPoints.typ[paramCheckPoints.n] = -3;
                        if (str.indexOf(")ph") != -1) paramCheckPoints.typ[paramCheckPoints.n] = -4;
                        if (str.indexOf("out") != -1) System.out.println("out: " + paramCheckPoints.n);
                        paramCheckPoints.n++;
                    }
                    this.nob++;
                }

                if (str.startsWith("chk")) {
                    int n = getint("chk", str, 0);
                    n += 46;
                    int i1 = paramMedium.ground - (paramArrayOfContO2[n]).grat;
                    if (n == 110) i1 = getint("chk", str, 4);
                    paramArrayOfContO1[this.nob] = new ContO(paramArrayOfContO2[n], getint("chk", str, 1), i1, getint("chk", str, 2), getint("chk", str, 3));
                    paramCheckPoints.x[paramCheckPoints.n] = getint("chk", str, 1);
                    paramCheckPoints.z[paramCheckPoints.n] = getint("chk", str, 2);
                    paramCheckPoints.y[paramCheckPoints.n] = i1;
                    if (getint("chk", str, 3) == 0) {
                        paramCheckPoints.typ[paramCheckPoints.n] = 1;
                    } else {
                        paramCheckPoints.typ[paramCheckPoints.n] = 2;
                    }
                    paramCheckPoints.pcs = paramCheckPoints.n;
                    paramCheckPoints.n++;
                    (paramArrayOfContO1[this.nob]).checkpoint = paramCheckPoints.nsp + 1;
                    paramCheckPoints.nsp++;
                    this.nob++;
                }

                if (str.startsWith("fix")) {
                    int n = getint("fix", str, 0);
                    n += 46;
                    paramArrayOfContO1[this.nob] = new ContO(paramArrayOfContO2[n], getint("fix", str, 1), getint("fix", str, 3), getint("fix", str, 2), getint("fix", str, 4));
                    paramCheckPoints.fx[paramCheckPoints.fn] = getint("fix", str, 1);
                    paramCheckPoints.fz[paramCheckPoints.fn] = getint("fix", str, 2);
                    paramCheckPoints.fy[paramCheckPoints.fn] = getint("fix", str, 3);
                    (paramArrayOfContO1[this.nob]).elec = true;
                    if (getint("fix", str, 4) != 0) {
                        paramCheckPoints.roted[paramCheckPoints.fn] = true;
                        (paramArrayOfContO1[this.nob]).roted = true;
                    } else {
                        paramCheckPoints.roted[paramCheckPoints.fn] = false;
                    }
                    if (str.indexOf(")s") != -1) {
                        paramCheckPoints.special[paramCheckPoints.fn] = true;
                    } else {
                        paramCheckPoints.special[paramCheckPoints.fn] = false;
                    }
                    paramCheckPoints.fn++;
                    this.nob++;
                }

                if (str.startsWith("nlaps")) {
                    paramCheckPoints.nlaps = getint("nlaps", str, 0);
                    if (paramCheckPoints.nlaps < 1) paramCheckPoints.nlaps = 1;
                    if (paramCheckPoints.nlaps > 15) paramCheckPoints.nlaps = 15;
                }

                if (paramCheckPoints.stage > 0 && str.startsWith("name"))
                    paramCheckPoints.name = getstring("name", str, 0).replace('|', ',');

                if (str.startsWith("stagemaker")) paramCheckPoints.maker = getstring("stagemaker", str, 0);

                if (str.startsWith("publish")) paramCheckPoints.pubt = getint("publish", str, 0);


                if (str.startsWith("maxr")) {
                    int n = getint("maxr", str, 1);
                }

                if (str.startsWith("maxl")) {
                    int n = getint("maxl", str, 1);
                }

                if (str.startsWith("maxt")) {
                    int n = getint("maxt", str, 1);
                }

                if (str.startsWith("maxb")) {
                    int n = getint("maxb", str, 1);
                }


            }

            dataInputStream.close();


            paramMedium.newpolys(j, i - j, m, k - m, null, this.notb);

            paramMedium.newclouds(j, i, m, k);

            paramMedium.newmountains(j, i, m, k);

            paramMedium.newstars();

        } catch (Exception exception) {

            bool = false;
            System.out.println("Error in stage " + paramCheckPoints.stage);
            System.out.println("" + exception);
            System.out.println("At line: " + str);

        }
        if (paramCheckPoints.nsp < 2) bool = false;

        if (paramMedium.nrw * paramMedium.ncl >= 16000) bool = false;


        paramMedium.trx = ((j + i) / 2);

        paramMedium.trz = ((k + m) / 2);

        System.gc();

        return bool;

    }


    public void loadbase(ContO[] paramArrayOfContO, Medium paramMedium, Trackers paramTrackers, xtGraphics paramxtGraphics, boolean paramBoolean) {

        String[] arrayOfString1 = {"2000tornados", "formula7", "canyenaro", "lescrab", "nimi", "maxrevenge", "leadoxide", "koolkat", "drifter", "policecops", "mustang", "king", "audir8", "masheen", "radicalone", "drmonster"};

        String[] arrayOfString2 = {"road", "froad", "twister2", "twister1", "turn", "offroad", "bumproad", "offturn", "nroad", "nturn", "roblend", "noblend", "rnblend", "roadend", "offroadend", "hpground", "ramp30", "cramp35", "dramp15", "dhilo15", "slide10", "takeoff", "sramp22", "offbump", "offramp", "sofframp", "halfpipe", "spikes", "rail", "thewall", "checkpoint", "fixpoint", "offcheckpoint", "sideoff", "bsideoff", "uprise", "riseroad", "sroad", "soffroad", "tside", "launchpad", "thenet", "speedramp", "offhill", "slider", "uphill", "roll1", "roll2", "roll3", "roll4", "roll5", "roll6", "opile1", "opile2", "aircheckpoint", "tree1", "tree2", "tree3", "tree4", "tree5", "tree6", "tree7", "tree8", "cac1", "cac2", "cac3", "8sroad", "8soffroad"};


        int i = 0;

        paramxtGraphics.dnload += 6;


        try {

            ZipInputStream zipInputStream = null;


            if (!paramBoolean) {


                File file = new File("" + Madness.fpath + "data/models.zip");

                zipInputStream = new ZipInputStream(new FileInputStream(file));

            } else {


                URL uRL = new URL("http://multiplayer.needformadness.com/data/models.zip");

                zipInputStream = new ZipInputStream(uRL.openStream());

            }


            ZipEntry zipEntry = zipInputStream.getNextEntry();

            byte[] arrayOfByte = null;

            while (zipEntry != null) {


                int j = 0;
                int k;

                for (k = 0; k < 16; ) {
                    if (zipEntry.getName().startsWith(arrayOfString1[k])) j = k;
                    k++;
                }

                for (k = 0; k < 68; ) {
                    if (zipEntry.getName().startsWith(arrayOfString2[k])) j = k + 56;
                    k++;
                }

                k = (int) zipEntry.getSize();

                i += k;

                arrayOfByte = new byte[k];

                int m = 0;


                for (; k > 0; k -= n) {


                    int n = zipInputStream.read(arrayOfByte, m, k);

                    m += n;

                }

                paramArrayOfContO[j] = new ContO(arrayOfByte, paramMedium, paramTrackers);

                paramxtGraphics.dnload++;

                zipEntry = zipInputStream.getNextEntry();

            }


            zipInputStream.close();

        } catch (Exception exception) {

            System.out.println("Error Reading Models: " + exception);

        }
        System.gc();

        if (this.mload != -1 && i != 615671) this.mload = 2;

    }

    public int getint(String paramString1, String paramString2, int paramInt) {
        int i;

        byte b;

        String str;

        for (b = 0, str = "", i = paramString1.length() + 1; i < paramString2.length(); ) {
            String str1 = "" + paramString2.charAt(i);
            if (str1.equals(",") || str1.equals(")")) {
                b++;
                i++;
            }
            if (b == paramInt) str = str + paramString2.charAt(i);
            i++;
        }
        return Integer.valueOf(str).intValue();
    }

    public String getstring(String paramString1, String paramString2, int paramInt) {
        int i;
        byte b;
        String str;

        for (b = 0, str = "", i = paramString1.length() + 1; i < paramString2.length(); ) {
            String str1 = "" + paramString2.charAt(i);
            if (str1.equals(",") || str1.equals(")")) {
                b++;
                i++;
            }
            if (b == paramInt) str = str + paramString2.charAt(i);
            i++;
        }
        return str;
    }


    public void start() {
        if (this.gamer == null) this.gamer = new Thread(this);
        this.gamer.start();
    }

    public void stop() {

        if (this.exwist && this.gamer != null) {
            System.gc();
            this.gamer.stop();
            this.gamer = null;
        }
        this.exwist = true;

    }


    public void setcarcookie(int paramInt1, String paramString, float[] paramArrayOffloat, int paramInt2, int[] paramArrayOfint, boolean paramBoolean) {

        try {
            File file = new File("" + Madness.fpath + "data/user.data");
            String[] arrayOfString = {"", "", "", "", ""};
            if (file.exists()) {
                BufferedReader bufferedReader;
                String str;
                byte b1;
                for (bufferedReader = new BufferedReader(new FileReader(file)), str = null, b1 = 0; (str = bufferedReader.readLine()) != null && b1 < 5; ) {
                    arrayOfString[b1] = str;
                    b1++;
                }
                bufferedReader.close();
                bufferedReader = null;
            }
            if (paramInt2 == 0)
                arrayOfString[1] = "lastcar(" + paramInt1 + "," + (int) (paramArrayOffloat[0] * 100.0F) + "," + (int) (paramArrayOffloat[1] * 100.0F) + "," + (int) (paramArrayOffloat[2] * 100.0F) + "," + (int) (paramArrayOffloat[3] * 100.0F) + "," + (int) (paramArrayOffloat[4] * 100.0F) + "," + (int) (paramArrayOffloat[5] * 100.0F) + "," + paramString + ")";
            if (paramInt2 == 1) arrayOfString[2] = "NFM1(" + paramInt1 + "," + paramArrayOfint[0] + ")";
            if (paramInt2 == 2) arrayOfString[3] = "NFM2(" + paramInt1 + "," + paramArrayOfint[1] + ")";
            BufferedWriter bufferedWriter;
            byte b;
            for (arrayOfString[4] = "graphics(" + this.moto + "," + Madness.anti + ")", bufferedWriter = new BufferedWriter(new FileWriter(file)), b = 0; b < 5; ) {
                bufferedWriter.write(arrayOfString[b]);
                bufferedWriter.newLine();
                b++;
            }
            bufferedWriter.close();
            bufferedWriter = null;
        } catch (Exception exception) {
        }
    }

    public void setloggedcookie() {

        try {
            File file = new File("" + Madness.fpath + "data/user.data");
            String[] arrayOfString = {"", "", "", "", ""};
            if (file.exists()) {
                BufferedReader bufferedReader;
                String str;
                byte b1;
                for (bufferedReader = new BufferedReader(new FileReader(file)), str = null, b1 = 0; (str = bufferedReader.readLine()) != null && b1 < 5; ) {
                    arrayOfString[b1] = str;
                    b1++;
                }
                bufferedReader.close();
                bufferedReader = null;
            }
            if (this.keplo.getState()) {
                arrayOfString[0] = "lastuser(" + this.tnick.getText() + "," + this.tpass.getText() + ")";
            } else {
                arrayOfString[0] = "lastuser(" + this.tnick.getText() + ")";
            }
            BufferedWriter bufferedWriter;
            byte b;
            for (bufferedWriter = new BufferedWriter(new FileWriter(file)), b = 0; b < 5; ) {
                bufferedWriter.write(arrayOfString[b]);
                bufferedWriter.newLine();
                b++;
            }
            bufferedWriter.close();
            bufferedWriter = null;
        } catch (Exception exception) {
        }
    }


    public void readcookies(xtGraphics paramxtGraphics, CarDefine paramCarDefine, ContO[] paramArrayOfContO) {

        paramxtGraphics.nickname = "";


        try {

            File file = new File("" + Madness.fpath + "data/user.data");
            String[] arrayOfString = {"", "", "", "", ""};
            if (file.exists()) {
                BufferedReader bufferedReader;
                String str;
                byte b;
                for (bufferedReader = new BufferedReader(new FileReader(file)), str = null, b = 0; (str = bufferedReader.readLine()) != null && b < 5; ) {
                    arrayOfString[b] = str;
                    b++;
                }
                bufferedReader.close();
                bufferedReader = null;
            }

            if (arrayOfString[0].startsWith("lastuser")) {
                paramxtGraphics.nickname = getstring("lastuser", arrayOfString[0], 0);
                if (!paramxtGraphics.nickname.equals("")) paramxtGraphics.opselect = 1;
                String str = "";
                try {
                    str = getstring("lastuser", arrayOfString[0], 1);
                } catch (Exception exception) {
                    str = "";
                }
                if (!str.equals("")) {
                    this.tnick.setText(paramxtGraphics.nickname);
                    this.tpass.setText(str);
                    paramxtGraphics.autolog = true;
                }
            }

            if (arrayOfString[2].startsWith("NFM1")) {
                int i = getint("NFM1", arrayOfString[2], 0);
                if (i >= 0 && i < 16) {
                    paramxtGraphics.scm[0] = i;
                    paramxtGraphics.firstime = false;
                }
                i = getint("NFM1", arrayOfString[2], 1);
                if (i >= 1 && i <= 11) paramxtGraphics.unlocked[0] = i;
            }

            if (arrayOfString[3].startsWith("NFM2")) {
                int i = getint("NFM2", arrayOfString[3], 0);
                if (i >= 0 && i < 16) {
                    paramxtGraphics.scm[1] = i;
                    paramxtGraphics.firstime = false;
                }
                i = getint("NFM2", arrayOfString[3], 1);
                if (i >= 1 && i <= 17) paramxtGraphics.unlocked[1] = i;
            }

            if (arrayOfString[4].startsWith("graphics")) {
                int i = getint("graphics", arrayOfString[4], 0);
                if (i >= 0 && i <= 1) this.moto = i;
                i = getint("graphics", arrayOfString[4], 1);
                if (i >= 0 && i <= 1) Madness.anti = i;
            }

            if (arrayOfString[1].startsWith("lastcar")) {
                int i = getint("lastcar", arrayOfString[1], 0);
                paramCarDefine.lastcar = getstring("lastcar", arrayOfString[1], 7);
                if (i >= 0 && i < 36) {
                    paramxtGraphics.osc = i;
                    paramxtGraphics.firstime = false;
                }
                byte b1, b2;
                for (b1 = 0, b2 = 0; b2 < 6; ) {
                    i = getint("lastcar", arrayOfString[1], b2 + 1);
                    if (i >= 0 && i <= 100) {
                        paramxtGraphics.arnp[b2] = i / 100.0F;
                        b1++;
                    }
                    b2++;
                }
                if (b1 == 6 && paramxtGraphics.osc >= 0 && paramxtGraphics.osc <= 15) {
                    Color color2;
                    byte b;
                    for (Color color1 = Color.getHSBColor(paramxtGraphics.arnp[0], paramxtGraphics.arnp[1], 1.0F - paramxtGraphics.arnp[2]); b < (paramArrayOfContO[paramxtGraphics.osc]).npl; ) {
                        if (((paramArrayOfContO[paramxtGraphics.osc]).p[b]).colnum == 1) {
                            ((paramArrayOfContO[paramxtGraphics.osc]).p[b]).c[0] = color1.getRed();
                            ((paramArrayOfContO[paramxtGraphics.osc]).p[b]).c[1] = color1.getGreen();
                            ((paramArrayOfContO[paramxtGraphics.osc]).p[b]).c[2] = color1.getBlue();
                        }
                        b++;
                    }
                    for (b = 0; b < (paramArrayOfContO[paramxtGraphics.osc]).npl; ) {
                        if (((paramArrayOfContO[paramxtGraphics.osc]).p[b]).colnum == 2) {
                            ((paramArrayOfContO[paramxtGraphics.osc]).p[b]).c[0] = color2.getRed();
                            ((paramArrayOfContO[paramxtGraphics.osc]).p[b]).c[1] = color2.getGreen();
                            ((paramArrayOfContO[paramxtGraphics.osc]).p[b]).c[2] = color2.getBlue();
                        }
                        b++;
                    }
                }
            }

        } catch (Exception exception) {
        }

    }


    public void regprom() {
    }


    public boolean mouseUp(Event paramEvent, int paramInt1, int paramInt2) {

        if (!this.exwist) {
            if (this.mouses == 11) {
                this.xm = (int) ((paramInt1 - this.apx) / this.apmult);
                this.ym = (int) ((paramInt2 - this.apy) / this.apmult);
                this.mouses = -1;
            }
            this.moused = false;
        }

        if (!Madness.fullscreen) {


            if (paramInt1 > getWidth() / 2 - 55 && paramInt1 < getWidth() / 2 + 7 && paramInt2 > 21 && paramInt2 < 38 && !this.onbar) {
                if (this.smooth == 1) {
                    this.smooth = 0;
                } else {
                    this.smooth = 1;
                }
                this.showsize = 60;
            }

            if (paramInt1 > getWidth() / 2 + 133 && paramInt1 < getWidth() / 2 + 231 && paramInt2 > 7 && paramInt2 < 24 && !this.onbar) {
                if (Madness.anti == 0) {
                    Madness.anti = 1;
                } else {
                    Madness.anti = 0;
                }
                this.showsize = 60;
            }

            if (paramInt1 > getWidth() / 2 + 133 && paramInt1 < getWidth() / 2 + 231 && paramInt2 > 24 && paramInt2 < 41 && !this.onbar) {
                if (this.moto == 0) {
                    this.moto = 1;
                } else {
                    this.moto = 0;
                }
                this.showsize = 60;
            }

            if (this.oncarm) Madness.carmaker();

            if (this.onstgm) Madness.stagemaker();

            if (this.onfulls) Madness.gofullscreen();

            this.onbar = false;

        }


        return false;

    }


    public boolean mouseDown(Event paramEvent, int paramInt1, int paramInt2) {

        requestFocus();


        if (!this.exwist) {
            if (this.mouses == 0) {
                this.xm = (int) ((paramInt1 - this.apx) / this.apmult);
                this.ym = (int) ((paramInt2 - this.apy) / this.apmult);
                this.mouses = 1;
            }
            this.moused = true;
        }

        if (!Madness.fullscreen) sizescreen(paramInt1, paramInt2);


        return false;

    }


    public boolean mouseMove(Event paramEvent, int paramInt1, int paramInt2) {

        if (!this.exwist && !this.lostfcs) {
            this.xm = (int) ((paramInt1 - this.apx) / this.apmult);
            this.ym = (int) ((paramInt2 - this.apy) / this.apmult);
        }

        if (!Madness.fullscreen) {


            if (this.showsize < 20) this.showsize = 20;

            if (paramInt1 > 50 && paramInt1 < 192 && paramInt2 > 14 && paramInt2 < 37) {
                if (!this.oncarm) {
                    this.oncarm = true;
                    setCursor(new Cursor(12));
                }
            } else if (this.oncarm) {
                this.oncarm = false;
                setCursor(new Cursor(0));
            }

            if (paramInt1 > getWidth() - 208 && paramInt1 < getWidth() - 50 && paramInt2 > 14 && paramInt2 < 37) {
                if (!this.onstgm) {
                    this.onstgm = true;
                    setCursor(new Cursor(12));
                }
            } else if (this.onstgm) {
                this.onstgm = false;
                setCursor(new Cursor(0));
            }

            if (paramInt1 > getWidth() / 2 + 22 && paramInt1 < getWidth() / 2 + 122 && paramInt2 > 14 && paramInt2 < 37) {
                if (!this.onfulls) {
                    this.onfulls = true;
                    setCursor(new Cursor(12));
                }
            } else if (this.onfulls) {
                this.onfulls = false;
                setCursor(new Cursor(0));
            }


        }

        return false;

    }


    public boolean mouseDrag(Event paramEvent, int paramInt1, int paramInt2) {

        if (!this.exwist && !this.lostfcs) {
            this.xm = (int) ((paramInt1 - this.apx) / this.apmult);
            this.ym = (int) ((paramInt2 - this.apy) / this.apmult);
        }

        if (!Madness.fullscreen) sizescreen(paramInt1, paramInt2);


        return false;

    }


    public boolean lostFocus(Event paramEvent, Object paramObject) {

        if (!this.exwist && !this.lostfcs) {
            this.lostfcs = true;
            this.fcscnt = 10;
            if (this.u[0] != null) {
                if ((this.u[0]).multion == 0) {
                    this.u[0].falseo(1);
                } else if ((this.u[0]).chatup == 0) {
                    requestFocus();
                }
                setCursor(new Cursor(0));
            }
        }

        return false;

    }


    public boolean gotFocus(Event paramEvent, Object paramObject) {

        if (!this.exwist && this.lostfcs) this.lostfcs = false;

        return false;

    }


    public void mouseW(int paramInt) {

        if (!this.exwist) this.mousew += paramInt * 4;

    }


    public void sizescreen(int paramInt1, int paramInt2) {

        if ((paramInt1 > getWidth() / 2 - 230 && paramInt1 < getWidth() / 2 - 68 && paramInt2 > 21 && paramInt2 < 39) || this.onbar) {
            this.reqmult = (paramInt1 - getWidth() / 2 - 222) / 141.0F;
            if (this.reqmult < 0.1D) this.reqmult = 0.0F;
            if (this.reqmult > 1.0F) this.reqmult = 1.0F;
            this.onbar = true;
            this.showsize = 100;
        }


    }

    public void catchlink() {
        if (!this.lostfcs)
            if ((this.xm > 65 && this.xm < 735 && this.ym > 135 && this.ym < 194) || (this.xm > 275 && this.xm < 525 && this.ym > 265 && this.ym < 284)) {
                setCursor(new Cursor(12));
                if (this.mouses == 2) openurl("http://www.radicalplay.com/");
            } else {
                setCursor(new Cursor(0));
            }

    }

    public void musiclink() {
        openurl("http://multiplayer.needformadness.com/music.html");
    }


    public void reglink() {
        openurl("http://multiplayer.needformadness.com/register.html?ref=game");
    }

    public void madlink() {

        openurl("http://www.needformadness.com/");

    }


    public void editlink(String paramString, boolean paramBoolean) {
        String str = "";
        if (paramBoolean) str = "?display=upgrade";
        openurl("http://multiplayer.needformadness.com/edit.pl" + str + "#" + paramString + "");
    }

    public void regnew() {

        openurl("http://multiplayer.needformadness.com/registernew.pl");

    }


    public void multlink() {

        openurl("http://multiplayer.needformadness.com/");

    }


    public void setupini() {

        Madness.inisetup = true;
        try {
            File file = new File("" + Madness.fpath + "Madness.ini");
            if (file.exists()) {
                String[] arrayOfString;
                byte b1;
                BufferedReader bufferedReader;
                String str;
                for (arrayOfString = new String[40], b1 = 0, bufferedReader = new BufferedReader(new FileReader(file)), str = null; (str = bufferedReader.readLine()) != null && b1 < 40; ) {
                    arrayOfString[b1] = str;
                    if (arrayOfString[b1].startsWith("Class Path"))
                        if (arrayOfString[b1].indexOf("madapps.jar") != -1) {
                            arrayOfString[b1] = "Class Path=\\data\\madapps.jar;";
                        } else {
                            arrayOfString[b1] = "Class Path=\\data\\madapp.jar;";
                        }
                    if (arrayOfString[b1].startsWith("JRE Path")) arrayOfString[b1] = "JRE Path=data\\jre\\";
                    b1++;
                }
                bufferedReader.close();
                BufferedWriter bufferedWriter;
                byte b2;
                for (bufferedReader = null, bufferedWriter = new BufferedWriter(new FileWriter(file)), b2 = 0; b2 < b1; ) {
                    bufferedWriter.write(arrayOfString[b2]);
                    bufferedWriter.newLine();
                    b2++;
                }
                bufferedWriter.close();
                bufferedWriter = null;
            }
        } catch (Exception exception) {
        }
        Madness.inisetup = false;

    }


    public void openurl(String paramString) {

        if (Desktop.isDesktopSupported()) {


            try {
                Desktop.getDesktop().browse(new URI(paramString));
            } catch (Exception exception) {
            }

        } else {


            try {
                Runtime.getRuntime().exec("" + Madness.urlopen() + " " + paramString + "");
            } catch (Exception exception) {
            }

        }

    }


    public boolean keyDown(Event paramEvent, int paramInt) {

        if (!this.exwist) {


            if ((this.u[0]).multion < 2) {


                if (paramInt == 1004) (this.u[0]).up = true;

                if (paramInt == 1005) (this.u[0]).down = true;

                if (paramInt == 1007) (this.u[0]).right = true;

                if (paramInt == 1006) (this.u[0]).left = true;

                if (paramInt == 32) (this.u[0]).handb = true;


            }

            if (paramInt == 10) (this.u[0]).enter = true;

            if (paramInt == 27) {
                (this.u[0]).exit = true;
                if ((this.u[0]).chatup != 0) (this.u[0]).chatup = 0;
            }

            if ((paramInt == 67 || paramInt == 99) && (this.u[0]).multion != 0 && (this.u[0]).chatup == 0) {
                (this.u[0]).chatup = 2;
                this.view = 0;
            }


            if ((this.u[0]).chatup == 0) {


                if (paramInt == 120 || paramInt == 88) (this.u[0]).lookback = -1;

                if (paramInt == 122 || paramInt == 90) (this.u[0]).lookback = 1;

                if (paramInt == 77 || paramInt == 109) if ((this.u[0]).mutem) {
                    (this.u[0]).mutem = false;
                } else {
                    (this.u[0]).mutem = true;
                }

                if (paramInt == 78 || paramInt == 110) if ((this.u[0]).mutes) {
                    (this.u[0]).mutes = false;
                } else {
                    (this.u[0]).mutes = true;
                }

                if (paramInt == 97 || paramInt == 65) if ((this.u[0]).arrace) {
                    (this.u[0]).arrace = false;
                } else {
                    (this.u[0]).arrace = true;
                }

                if (paramInt == 115 || paramInt == 83) if ((this.u[0]).radar) {
                    (this.u[0]).radar = false;
                } else {
                    (this.u[0]).radar = true;
                }

                if (paramInt == 118 || paramInt == 86) {
                    this.view++;
                    if (this.view == 3) this.view = 0;
                }


            }

        }

        return false;

    }


    public boolean keyUp(Event paramEvent, int paramInt) {

        if (!this.exwist) {


            if ((this.u[0]).multion < 2) {


                if (paramInt == 1004) (this.u[0]).up = false;

                if (paramInt == 1005) (this.u[0]).down = false;

                if (paramInt == 1007) (this.u[0]).right = false;

                if (paramInt == 1006) (this.u[0]).left = false;

                if (paramInt == 32) (this.u[0]).handb = false;


            }

            if (paramInt == 27) {


                (this.u[0]).exit = false;


                if (Madness.fullscreen) Madness.exitfullscreen();


            }

            if (paramInt == 120 || paramInt == 88 || paramInt == 122 || paramInt == 90) (this.u[0]).lookback = 0;


        }


        return false;

    }

}


