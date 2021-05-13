import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.image.ImageObserver;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Date;


public class Login
        implements Runnable {
    Graphics2D rd;
    xtGraphics xt;
    Medium m;
    FontMetrics ftm;
    ImageObserver ob;
    GameSparker gs;
    int nmsgs = 0, nconf = 0, nfreq = 0, ncreq = 0;
    int fclan = 0;
    int fplayer = 0;
    String clanapv = "";

    boolean justlog = false;

    int cntgame = 0;
    int gamec = -1;
    int groom = 0;
    String gmaker = "";
    String gservern = "";

    Thread connector;
    int fase = 0;

    Socket socket;

    BufferedReader din;
    PrintWriter dout;
    boolean[] pessd = new boolean[]{false, false, false, false, false, false};
    int[] bx = new int[]{0, 0, 0, 0, 0, 0};
    int[] by = new int[]{0, 0, 0, 0, 0, 0};
    int[] bw = new int[]{0, 0, 0, 0, 0, 0};
    int btn = 0;

    int nflk = 0;
    int ncnt = 0;
    int errcnt = 0;
    int lrgfase = 0;
    String msg = "";
    String lnick = "";
    String lpass = "";
    String lemail = "";
    boolean onf = false;
    boolean nickero = false;
    boolean jflk = false;
    boolean ond = false;
    int opselect = 0;
    int trans = 0;
    int cntcl = 0;

    boolean contrb = false;
    int nservers = 2;
    String[] servers = new String[]{"multiplayer.needformadness.com", "avenger.needformadness.com", "ghostrider.needformadness.com"};
    InetAddress[] IPAddress = new InetAddress[3];
    DatagramSocket[] dSocket = new DatagramSocket[3];
    int[] serverdone = new int[]{-1, -1, -1};
    long[] servestart = new long[]{0L, 0L, 0L};
    String[] snames = new String[]{"Dominion", "Avenger", "Ghostrider"};
    boolean socketson = false;
    int srvtrn = 0;

    int[] rmps = new int[]{0, 0, 0, 0, 0};
    int[] rmwt = new int[]{0, 0, 0, 0, 0};
    int recom = 0;

    boolean resofaso = false;

    boolean checknote = false;
    int pend = 0;

    boolean pendb = false;
    boolean gotcai = false;
    int cax = 0;
    int cay = 0;

    boolean btroom = false;

    boolean showtf = false;
    int[] bgmy;
    int flipo;
    int xrl;
    int xrr;
    boolean onr;
    int oxm;
    int oym;
    int lxm;
    int lym;

    public void inishmulti() {
        this.gs.tnick.hide();
        this.gs.tnick.enable();
        this.gs.tnick.setForeground(new Color(0, 0, 0));
        this.gs.tnick.setBackground(color2k(240, 240, 240));
        this.gs.tpass.hide();
        this.gs.tpass.enable();
        this.gs.tpass.setForeground(new Color(0, 0, 0));
        this.gs.tpass.setBackground(color2k(240, 240, 240));
        this.gs.temail.hide();
        this.gs.temail.enable();
        this.gs.temail.setForeground(new Color(0, 0, 0));
        this.gs.temail.setBackground(color2k(240, 240, 240));
        this.gs.keplo.hide();
        this.gs.keplo.enable();
        this.gs.keplo.setForeground(new Color(0, 0, 0));
        this.gs.keplo.setBackground(new Color(193, 181, 142));
        this.gs.requestFocus();
        if (this.gs.tnick.getText().equals("")) this.gs.tnick.setText("Nickname");
        byte b;
        for (b = 0; b < 6; ) {
            this.pessd[b] = false;
            b++;
        }
        this.nflk = 0;
        this.ncnt = 0;
        this.errcnt = 0;
        this.onf = false;
        this.ond = false;

        this.msg = "";
        this.btroom = false;
        this.gotcai = false;
        this.m.crs = true;
        this.m.x = -335;
        this.m.y = 0;
        this.m.z = -50;
        this.m.xz = 0;
        this.m.zy = 20;
        this.m.ground = -2000;
        this.pend = 0;
        this.pendb = false;

        this.resofaso = false;
        for (b = 0; b < this.nservers; ) {
            this.serverdone[b] = -1;
            this.servestart[b] = 0L;
            b++;
        }
        this.checknote = false;
        if (this.xt.gotlog) {
            this.checknote = true;
            this.socketson = false;
            this.fase = 12;
            this.connector = new Thread(this);
            this.connector.start();
        } else {
            this.msg = "Login to access the multiplayer madness!";
            this.gs.tnick.setText(this.xt.nickname);
            this.fase = 3;
        }

    }


    public void exitfromlobby() {
        if (!this.xt.lan) {
            this.opselect = 0;
        } else {
            this.opselect = 1;
        }
        byte b;
        for (b = 0; b < this.nservers; ) {
            this.serverdone[b] = -1;
            this.servestart[b] = 0L;
            b++;
        }

        for (b = 0; b < 6; ) {
            this.pessd[b] = false;
            b++;
        }
        this.gotcai = false;
        this.btroom = false;
        this.m.crs = true;
        this.m.x = -335;
        this.m.y = 0;
        this.m.z = -50;
        this.m.xz = 0;
        this.m.zy = 20;
        this.m.ground = -2000;
        this.pend = 0;
        this.pendb = false;
        this.gamec = -1;

        this.socketson = false;
        if (!this.xt.lan) {
            this.msg = "| Connecting to Servers |";
            this.trans = 0;
            this.fase = 13;
            this.nflk = 0;
        } else {
            this.fase = 12;
        }
        System.gc();
        this.connector = new Thread(this);
        this.connector.start();
    }


    public void endcons() {
        for (byte b = 0; b < this.nservers; ) {
            try {
                this.dSocket[b].close();
                this.dSocket[b] = null;
            } catch (Exception exception) {
            }
            b++;
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
    }


    public void checknotifcations() {
        byte b1 = 0;
        byte b2 = 0;
        byte b3 = 0;
        int i = 0;
        int j = 0;
        String str = "";
        byte b4 = 0;

        try {
            URL uRL = new URL("http://multiplayer.needformadness.com/profiles/" + this.xt.nickname + "/notify.txt?req=" + (int) (Math.random() * 1000.0D) + "");
            uRL.openConnection().setConnectTimeout(2000);
            String str1 = uRL.openConnection().getContentType();
            if (str1.equals("text/plain")) {

                DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
                String str2 = "";
                byte b = 0;
                while ((str2 = dataInputStream.readLine()) != null && b < 5) {

                    str2 = str2.trim();

                    if (b == 0) for (String str3 = getSvalue(str2, b1); !str3.equals(""); ) {
                        if (str3.startsWith("clan: ")) {
                            b2++;
                        } else if (!str3.startsWith("your clan")) {
                            b3++;
                        }
                        str3 = getSvalue(str2, ++b1);
                    }
                    if (b == 1) {
                        int k = 0;
                        try {
                            k = Integer.valueOf(str2).intValue();
                        } catch (Exception exception) {
                            k = 0;
                        }
                        i = k;
                    }
                    if (b == 2) {
                        int k = 0;
                        try {
                            k = Integer.valueOf(str2).intValue();
                        } catch (Exception exception) {
                            k = 0;
                        }
                        j = k;
                    }
                    if (b == 3) str = getSvalue(str2, 0);
                    if (b == 4)
                        for (String str3 = getSvalue(str2, b4); !str3.equals(""); str3 = getSvalue(str2, ++b4)) ;
                    b++;
                }
                dataInputStream.close();
            }
        } catch (Exception exception) {
        }
        this.nmsgs = b1;
        this.fclan = b2;
        this.fplayer = b3;
        this.nfreq = i;
        this.nconf = j;
        this.clanapv = str;
        this.ncreq = b4;
    }


    public void gamealert() {
        try {
            this.socket = new Socket(this.servers[0], 7061);
            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.dout = new PrintWriter(this.socket.getOutputStream(), true);
            this.dout.println("101|20|" + this.xt.nickname + "|" + this.xt.nickey + "|" + this.xt.servername + "|" + (this.xt.servport - 7070) + "|");
            String str = this.din.readLine();
            this.socket.close();
            this.din.close();
            this.dout.close();
        } catch (Exception exception) {
        }
    }


    public void checkgamealerts() {
        try {
            this.socket = new Socket(this.servers[0], 7061);
            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.dout = new PrintWriter(this.socket.getOutputStream(), true);
            this.dout.println("101|21|");
            String str = this.din.readLine();
            if (str != null) {

                int i = getvalue(str, 0);
                if (i != -1 && i != this.gamec) {

                    String str1 = getSvalue(str, 2);
                    int j = getvalue(str, 3);
                    boolean bool = false;
                    if (!str1.equals(this.xt.servername) || j != this.xt.servport - 7070)
                        for (byte b = 0; b < this.nservers; ) {
                            if (str1.equals(this.snames[b]) && this.xt.delays[b] < 300) bool = true;
                            b++;
                        }
                    if (bool) {

                        this.gmaker = getSvalue(str, 1);
                        if (this.gmaker.equals(this.xt.nickname)) this.gmaker = "You";
                        this.groom = j;
                        this.gservern = str1;
                        this.gamec = i;
                        this.cntgame = 0;
                    }
                }
            }
            this.socket.close();
            this.din.close();
            this.dout.close();
        } catch (Exception exception) {
        }
    }


    public void run() {
        if (this.checknote) {
            checknotifcations();
            this.checknote = false;
        }

        if (this.fase == 2) {

            this.gs.setCursor(new Cursor(3));
            int i = -1;
            int j = -1;


            try {
                this.socket = new Socket(this.servers[0], 7061);
                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                this.dout.println("0|" + this.gs.tnick.getText() + "|");
                String str = this.din.readLine();
                if (str != null) {
                    i = getvalue(str, 0);
                    if (i == 0) {
                        j = getvalue(str, 1);
                        this.xt.hours = getvalue(str, 2);
                        this.xt.nickey = getSvalue(str, 3);
                    }
                }
                this.socket.close();
                this.din.close();
                this.dout.close();
            } catch (Exception exception) {
            }

            this.gs.tnick.enable();

            if (i == -1) {

                this.msg = "Unable to connect to any server at this moment.  Please try again later.";
                this.fase = 1;
            }

            if (i == 0) {

                this.xt.nickname = this.gs.tnick.getText();
                if (j != -1) this.xt.nfreeplays = j;
                this.gs.tnick.hide();
                this.gs.tpass.hide();
                this.gs.temail.hide();
                this.gs.keplo.hide();
                this.gs.requestFocus();
                this.xt.logged = false;
                this.fase = 12;
                System.gc();
            }

            if (i == 1) {

                this.msg = "This Nickname is being used by someone else right now.  Please use another.";
                this.nickero = true;
                this.gs.tnick.setForeground(new Color(255, 0, 0));
                this.gs.tnick.requestFocus();
                this.errcnt = 30;
                this.fase = 1;
            }


            if (i == 2) {

                this.msg = "Nickname registerd.  Please use another or click 'Login' bellow to login to this Nickname.";
                this.nickero = true;
                this.gs.tnick.setForeground(new Color(255, 0, 0));
                this.gs.tnick.requestFocus();
                this.errcnt = 30;
                this.fase = 1;
            }

            this.gs.setCursor(new Cursor(0));
        }


        if (this.fase == 4) {

            this.gs.setCursor(new Cursor(3));
            int i = -1;
            int j = -1;
            String str = "";

            try {
                this.socket = new Socket(this.servers[0], 7061);
                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                this.dout.println("1|" + this.gs.tnick.getText() + "|" + this.gs.tpass.getText() + "|");
                str = this.din.readLine();
                if (str != null) {
                    i = getvalue(str, 0);
                    if (i == 0 || i == 3 || i > 10 || i == -167) {
                        this.xt.nickey = getSvalue(str, 1);
                        if (i != -167) {
                            this.xt.clan = getSvalue(str, 2);
                            this.xt.clankey = getSvalue(str, 3);
                        } else {
                            this.xt.clan = "";
                            this.xt.clankey = "";
                            j = getvalue(str, 2);
                            this.xt.hours = getvalue(str, 3);
                        }
                    }
                }
                this.socket.close();
                this.din.close();
                this.dout.close();
            } catch (Exception exception) {
            }

            this.gs.tnick.enable();
            this.gs.tpass.enable();
            this.gs.keplo.enable();

            if (i == -1) {

                this.msg = "Unable to connect to server at this moment.  Please try again later.";
                this.fase = 3;
            }

            if (i == 0 || i == 3 || i > 10 || i == -167 || i == 111) {

                this.xt.nickname = this.gs.tnick.getText();
                this.showtf = false;
                this.gs.tnick.hide();
                this.gs.tpass.hide();
                this.gs.temail.hide();
                this.gs.keplo.hide();
                this.gs.requestFocus();
                this.gs.setloggedcookie();
                this.btroom = false;
                this.xt.logged = true;
                this.xt.gotlog = true;
                if (i == 0) this.xt.acexp = 0;
                if (i > 10) this.xt.acexp = i - 10;
                if (i == 3) this.xt.acexp = -1;

                if (i == -167) {
                    this.xt.logged = false;
                    if (j != -1) this.xt.nfreeplays = j;
                }

                if (this.xt.logged) this.xt.backlog = this.xt.nickname;
                this.fase = 12;
                this.justlog = true;
                checknotifcations();
                System.gc();
            }

            if (i == 1) {

                this.msg = "Sorry.  The Nickname you have entered is incorrect or does not exist.";
                this.gs.tnick.setForeground(new Color(255, 0, 0));
                this.gs.tnick.requestFocus();
                this.errcnt = 40;
                this.fase = 3;
            }

            if (i == 2) {

                this.msg = "Sorry.  The Password you have entered is incorrect.";
                this.gs.tpass.setForeground(new Color(255, 0, 0));
                this.gs.tpass.requestFocus();
                this.errcnt = 40;
                this.fase = 3;
            }


            this.gs.setCursor(new Cursor(0));
        }


        if (this.fase == 8) {

            this.gs.setCursor(new Cursor(3));
            int i = -1;


            try {
                this.socket = new Socket(this.servers[0], 7061);
                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                this.dout.println("2|" + this.gs.temail.getText().toLowerCase() + "|");
                String str = this.din.readLine();
                if (str != null) i = getvalue(str, 0);
                this.socket.close();
                this.din.close();
                this.dout.close();
            } catch (Exception exception) {
            }

            this.gs.temail.enable();

            if (i == -1) {

                this.msg = "Unable to connect to server at this moment.  Please try again later.";
                this.fase = 7;
            }

            if (i == 0) {

                this.showtf = false;
                this.gs.temail.hide();
                this.msg = "Please check your Email: " + this.gs.temail.getText() + " to login.";
                this.gs.temail.setText("");
                this.gs.tnick.setText("");
                this.gs.tpass.setText("");
                this.fase = 3;
            }

            if (i == 1) {

                this.msg = "Sorry.  This Email Address does not exist in our system!";
                this.gs.temail.setForeground(new Color(255, 0, 0));
                this.errcnt = 40;
                this.fase = 7;
            }

            this.gs.setCursor(new Cursor(0));
        }


        if (this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15) {
            if (!this.socketson) {

                for (byte b = 0; b < this.nservers; b++) {


                    try {
                        this.serverdone[b] = -1;
                        this.IPAddress[b] = InetAddress.getByName(this.servers[b]);
                        this.dSocket[b] = new DatagramSocket(7001 + b);
                    } catch (Exception exception) {
                        this.serverdone[b] = 5;
                    }

                }
                this.srvtrn = 0;
                this.socketson = true;
            }
        }


        while (this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15) {


            if (this.srvtrn < this.nservers) {


                while (this.serverdone[this.srvtrn] < this.xt.cntptrys) {

                    if (this.serverdone[this.srvtrn] == -1) this.serverdone[this.srvtrn] = 0;
                    Date date = new Date();
                    this.servestart[this.srvtrn] = date.getTime();


                    try {
                        byte[] arrayOfByte1 = new byte[4];
                        DatagramPacket datagramPacket = new DatagramPacket(arrayOfByte1, arrayOfByte1.length, this.IPAddress[this.srvtrn], 7000);
                        String str1 = "" + this.xt.nickname + "|";
                        byte[] arrayOfByte2 = str1.getBytes();
                        datagramPacket.setData(arrayOfByte2);
                        this.dSocket[this.srvtrn].send(datagramPacket);
                        this.dSocket[this.srvtrn].receive(datagramPacket);
                        String str2 = new String(datagramPacket.getData());
                        if (str2.startsWith("OK")) {
                            date = new Date();
                            if (date.getTime() - this.servestart[this.srvtrn] < this.xt.delays[this.srvtrn])
                                this.xt.delays[this.srvtrn] = (int) (date.getTime() - this.servestart[this.srvtrn]);
                        }
                    } catch (Exception exception) {
                        this.xt.delays[this.srvtrn] = 600;
                        this.serverdone[this.srvtrn] = 5;
                    }

                    this.serverdone[this.srvtrn] = this.serverdone[this.srvtrn] + 1;
                }

                this.srvtrn++;


            } else if (this.fase == 13) {

                int i = -1;
                boolean bool = false;
                for (byte b = 0; b < this.nservers; ) {
                    if (this.xt.delays[b] < i || i == -1) {
                        i = this.xt.delays[b];
                        this.opselect = b;
                    }
                    if (this.xt.delays[b] >= 600) bool = true;
                    b++;
                }
                if (!bool) {
                    this.xt.cntptrys -= 2;
                    if (this.xt.cntptrys < 1) this.xt.cntptrys = 1;
                }
                this.fase = 14;
            }


            try {
                Thread.sleep(5L);
            } catch (InterruptedException interruptedException) {
            }
        }


        if (this.fase != 12 && this.fase != 13 && this.fase != 14 && this.fase != 15 && this.fase != 5) {
            if (this.socketson) {

                for (byte b = 0; b < this.nservers; ) {
                    try {
                        this.dSocket[b].close();
                        this.dSocket[b] = null;
                    } catch (Exception exception) {
                    }
                    b++;
                }
                this.socketson = false;
            }
        }


        if (this.fase == 16 || this.fase == 17) {

            boolean bool = false;
            byte b = 0;
            int i = -1;
            this.recom = 0;


            try {
                this.socket = new Socket(this.xt.server, 7067);
                this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                this.dout = new PrintWriter(this.socket.getOutputStream(), true);
            } catch (Exception exception) {
            }

            while ((this.fase == 16 || this.fase == 17) && b != 3) {


                String str = "";

                if (!bool) {

                    try {
                        this.dout.println("10|");
                        String str1 = this.din.readLine();
                        if (str1 == null) {
                            bool = true;
                        } else {
                            str = str1;
                        }
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
                            this.socket = new Socket(this.xt.server, 7067);
                            this.din = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                            this.dout = new PrintWriter(this.socket.getOutputStream(), true);
                            this.dout.println("10|");
                            String str1 = this.din.readLine();
                            if (str1 != null) {
                                bool = false;
                            } else {
                                str = str1;
                            }
                        } catch (Exception exception) {
                            bool = true;
                        }

                    }
                    if (bool) try {
                        this.socket.close();
                        this.socket = null;
                    } catch (Exception exception) {
                    }

                }
                if (!bool) {
                    int j;
                    for (j = 0; j < 5; ) {
                        this.rmps[j] = getvalue(str, j * 2);
                        this.rmwt[j] = getvalue(str, 1 + j * 2);
                        j++;
                    }
                    byte b1;
                    for (j = 1000, b1 = 0; b1 < 5; ) {
                        if (Math.abs(this.rmps[b1] - 6) < j) {
                            this.recom = b1;
                            j = Math.abs(this.rmps[b1] - 6);
                        }
                        b1++;
                    }
                    if (this.recom != i) {
                        this.opselect = this.recom;
                        i = this.recom;
                    }
                    if (this.fase == 16) this.fase = 17;
                } else {
                    this.msg = "Failed to connect to this Server!";
                    b++;
                }

                if (b != 3) try {
                    Thread.sleep(2000L);
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

            if (b == 3) this.resofaso = true;

        }
    }


    public void stopallnow() {
        if (this.connector != null) {
            this.connector.stop();
            this.connector = null;
        }
        endcons();
    }

    public Login(Medium paramMedium, Graphics2D paramGraphics2D, xtGraphics paramxtGraphics, GameSparker paramGameSparker) {
        this.bgmy = new int[]{0, 400, 800};
        this.flipo = 0;


        this.xrl = 0;
        this.xrr = 0;
        this.onr = false;
        this.oxm = 0;
        this.oym = 0;


        this.lxm = 0;
        this.lym = 0;
        this.m = paramMedium;
        this.rd = paramGraphics2D;
        this.xt = paramxtGraphics;
        this.gs = paramGameSparker;
        if (this.xt.playingame != -1)
            this.fase = 18;
        if (this.xt.nofull)
            this.nservers = 1;
    }

    public void multimode(ContO[] paramArrayOfContO) {
        this.btn = 0;
        this.xt.mainbg(4);
        for (byte b = 0; b < 3; ) {
            this.rd.drawImage(this.xt.bgmain, 65, this.bgmy[b], (ImageObserver) null);
            this.bgmy[b] = this.bgmy[b] - 4;
            if (this.bgmy[b] <= -400)
                this.bgmy[b] = 800;
            b++;
        }
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
        this.rd.drawImage(this.xt.bggo, 0, 0, (ImageObserver) null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(65, 425, 670, 25);
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        float f = 1.0F - (this.flipo - 10) / 80.0F;
        if (f > 1.0F)
            f = 1.0F;
        if (f < 0.0F)
            f = 0.0F;
        this.rd.setComposite(AlphaComposite.getInstance(3, f));
        if (this.flipo > 10) {
            this.rd.drawImage(this.xt.logomadnes, 96 + (int) (2.0D - Math.random() * 4.0D), 11 + (int) (2.0D - Math.random() * 4.0D), (ImageObserver) null);
        } else {
            this.rd.drawImage(this.xt.logomadnes, 96, 11, (ImageObserver) null);
        }
        this.flipo++;
        if (this.flipo > 50)
            this.flipo = 0;
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        drawSbutton(this.xt.exit, 690, 17);
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
        this.rd.setColor(new Color(203, 227, 253));
        this.rd.fillRoundRect(319, 83, 180, 96, 20, 20);
        this.rd.fillRoundRect(173, 83, 132, 32, 20, 20);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        this.rd.setColor(color2k(90, 90, 90));
        this.rd.drawRoundRect(319, 83, 180, 96, 20, 20);
        this.rd.drawRoundRect(173, 83, 132, 32, 20, 20);
        if (!this.gotcai) {
            int i = ((paramArrayOfContO[this.xt.sc[0]]).p[0]).oz[0];
            int j = i;
            int k = ((paramArrayOfContO[this.xt.sc[0]]).p[0]).oy[0];
            int m = k;
            for (byte b1 = 0; b1 < (paramArrayOfContO[this.xt.sc[0]]).npl; ) {
                for (byte b2 = 0; b2 < ((paramArrayOfContO[this.xt.sc[0]]).p[b1]).n; ) {
                    if (((paramArrayOfContO[this.xt.sc[0]]).p[b1]).oz[b2] < i)
                        i = ((paramArrayOfContO[this.xt.sc[0]]).p[b1]).oz[b2];
                    if (((paramArrayOfContO[this.xt.sc[0]]).p[b1]).oz[b2] > j)
                        j = ((paramArrayOfContO[this.xt.sc[0]]).p[b1]).oz[b2];
                    if (((paramArrayOfContO[this.xt.sc[0]]).p[b1]).oy[b2] < k)
                        k = ((paramArrayOfContO[this.xt.sc[0]]).p[b1]).oy[b2];
                    if (((paramArrayOfContO[this.xt.sc[0]]).p[b1]).oy[b2] > m)
                        m = ((paramArrayOfContO[this.xt.sc[0]]).p[b1]).oy[b2];
                    b2++;
                }
                b1++;
            }
            this.cax = (j + i) / 2;
            this.cay = (m + k) / 2;
            this.gotcai = true;
        }
        (paramArrayOfContO[this.xt.sc[0]]).z = 1500;
        (paramArrayOfContO[this.xt.sc[0]]).y = 380 - this.cay;
        (paramArrayOfContO[this.xt.sc[0]]).x = 100 - this.cax;
        (paramArrayOfContO[this.xt.sc[0]]).zy = 0;
        (paramArrayOfContO[this.xt.sc[0]]).xz = -90;
        (paramArrayOfContO[this.xt.sc[0]]).xy = this.pend;
        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        paramArrayOfContO[this.xt.sc[0]].d(this.rd);
        this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (!this.pendb) {
            this.pend += 2;
            if (this.pend > 80)
                this.pendb = true;
        } else {
            this.pend -= 2;
            if (this.pend < -10)
                this.pendb = false;
        }
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.drawString(this.xt.nickname, 239 - this.ftm.stringWidth(this.xt.nickname) / 2, 105);
        this.rd.setColor(color2k(90, 90, 90));
        this.rd.drawString("" + this.xt.cd.names[this.xt.sc[0]] + "", 409 - this.ftm.stringWidth("" + this.xt.cd.names[this.xt.sc[0]] + "") / 2, 81);
        this.rd.drawString("Nickname", 239 - this.ftm.stringWidth("Nickname") / 2, 81);
        drawbutton(this.xt.change, 570, 98);
        drawSbutton(this.xt.logout, 239, 135);
        this.rd.setColor(new Color(98, 56, 0));
        this.rd.drawString("Edit my Account", 239 - this.ftm.stringWidth("Edit my Account") / 2, 168);
        if (this.ond)
            this.rd.drawLine(239 - this.ftm.stringWidth("Edit my Account") / 2, 169, 239 - this.ftm.stringWidth("Edit my Account") / 2 + this.ftm.stringWidth("Edit my Account"), 169);
        if (this.fase == 12 || this.fase == 13 || this.fase == 14 || this.fase == 15) {
            int i = this.srvtrn;
            if (i < this.nservers)
                if (this.serverdone[i] != -1) {
                    Date date = new Date();
                    if (date.getTime() - this.servestart[i] > 1500L) {
                        if (this.connector != null) {
                            this.connector.stop();
                            this.connector = null;
                        }
                        this.xt.delays[i] = 600;
                        this.serverdone[i] = 5;
                        this.connector = new Thread(this);
                        this.connector.start();
                    }
                }
        }
        if (this.fase == 12)
            if (this.xt.acexp == 0 || this.contrb) {
                this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
                this.rd.setColor(new Color(203, 227, 253));
                this.rd.fillRoundRect(205, 225, 390, 120, 20, 20);
                this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                this.rd.setColor(color2k(90, 90, 90));
                this.rd.drawString("Multiplayer Mode", 400 - this.ftm.stringWidth("Multiplayer Mode") / 2, 220);
                this.rd.drawRoundRect(205, 225, 390, 120, 20, 20);
                if (this.opselect == 0 && !this.pessd[3]) {
                    this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
                    this.rd.setColor(new Color(203, 227, 253));
                    this.rd.fillRect(387 - this.xt.pon.getWidth(this.ob) / 2, 242, this.xt.pon.getWidth(this.ob) + 26, 26);
                    this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                }
                drawbutton(this.xt.pon, 400, 255);
                if (this.opselect == 1 && !this.pessd[4]) {
                    this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
                    this.rd.setColor(new Color(203, 227, 253));
                    this.rd.fillRect(387 - this.xt.pln.getWidth(this.ob) / 2, 302, this.xt.pln.getWidth(this.ob) + 26, 26);
                    this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                }
                drawbutton(this.xt.pln, 400, 315);
                if (!this.xt.logged) {
                    this.rd.setColor(new Color(30, 70, 110));
                    this.rd.drawString("You can play 5 multiplayer turns per day to try the game with your trial account.", 400 - this.ftm.stringWidth("You can play 1 multiplayer turn per day to try the game with your trial account.") / 2, 368);
                    this.rd.drawString("Upgrade your account to purchase the game.", 400 - this.ftm.stringWidth("You can play 1 multiplayer turn per day to try the game with your trial account.") / 2, 385);
                    drawSbutton(this.xt.upgrade, 400, 406);
                }
            } else {
                this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
                this.rd.setColor(new Color(203, 227, 253));
                this.rd.fillRoundRect(165, 219, 470, 135, 20, 20);
                this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                this.rd.setColor(color2k(90, 90, 90));
                this.rd.drawRoundRect(165, 219, 470, 135, 20, 20);
                if (this.xt.acexp > 0) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Dear " + this.xt.nickname + ",", 185, 245);
                    this.rd.drawString("Your account is due to expire in " + this.xt.acexp + " days.", 185, 265);
                    this.rd.drawString("Renew your registration soon!", 185, 295);
                    stringbutton("Renew my Account Registration now!", 345, 332, 0);
                    stringbutton("Renew Later", 524, 332, 0);
                }
                if (this.xt.acexp == -1) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Dear " + this.xt.nickname + ",", 185, 245);
                    this.rd.drawString("Your Need for Madness account registration has expired.", 185, 265);
                    this.rd.drawString("Please renew your registration.", 185, 295);
                    stringbutton("Renew my account registration now!", 362, 332, 0);
                    stringbutton("Cancel", 524, 332, 0);
                }
                if (this.xt.acexp == -2) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Dear " + this.xt.nickname + ",", 185, 245);
                    this.rd.drawString("Trial accounts are not allowed to access the downloaded game.", 185, 265);
                    this.rd.drawString("You can only play the game online using your trial account.", 185, 295);
                    stringbutton("Play the multiplayer online!", 362, 332, 0);
                    stringbutton("Cancel", 524, 332, 0);
                }
                if (this.xt.acexp == -3) {
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString("Some one else is already logged in the game with your account.", 185, 245);
                    this.rd.drawString("If you where just in the game then quitted it suddenly, it could just", 185, 265);
                    this.rd.drawString("be your 'ghost entry', if so please wait a few minutes and try again.", 185, 285);
                    this.rd.drawString("Otherwise please consider changing your password.", 185, 305);
                    stringbutton("Change Password", 332, 336, 0);
                    stringbutton("Try Again", 494, 336, 0);
                }
            }
        if (this.fase == 13 || this.fase == 14 || this.fase == 16 || this.fase == 17) {
            if (this.trans < 40) {
                this.rd.drawImage(this.xt.pon, 400 - this.xt.pon.getWidth(this.ob) / 2, 255 - this.xt.pon.getHeight(this.ob) / 2 - 12 - this.trans, (ImageObserver) null);
            } else {
                this.rd.drawImage(this.xt.pon, 400 - this.xt.pon.getWidth(this.ob) / 2, 215 - this.xt.pon.getHeight(this.ob) / 2 - 12, (ImageObserver) null);
            }
            if (this.trans >= 40) {
                this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
                this.rd.setColor(new Color(203, 227, 253));
                this.rd.fillRoundRect(165, 219, 470, 150, 20, 20);
                this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
                this.rd.setColor(color2k(90, 90, 90));
                this.rd.drawRoundRect(165, 219, 470, 150, 20, 20);
                drawbutton(this.xt.cancel, 583, 395);
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (this.fase == 13) {
                    this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 295);
                    if (this.msg.equals(". . . | Connecting to Servers | . . .") && this.ncnt == 0) {
                        this.msg = "| Connecting to Servers |";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals(". . | Connecting to Servers | . .") && this.ncnt == 0) {
                        this.msg = ". . . | Connecting to Servers | . . .";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals(". | Connecting to Servers | .") && this.ncnt == 0) {
                        this.msg = ". . | Connecting to Servers | . .";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals("| Connecting to Servers |") && this.ncnt == 0) {
                        this.msg = ". | Connecting to Servers | .";
                        this.ncnt = 5;
                    }
                    if (this.ncnt != 0)
                        this.ncnt--;
                }
                if (this.fase == 16) {
                    this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 295);
                    if (this.msg.equals(". . . | Finding Rooms | . . .") && this.ncnt == 0) {
                        this.msg = "| Finding Rooms |";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals(". . | Finding Rooms | . .") && this.ncnt == 0) {
                        this.msg = ". . . | Finding Rooms | . . .";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals(". | Finding Rooms | .") && this.ncnt == 0) {
                        this.msg = ". . | Finding Rooms | . .";
                        this.ncnt = 5;
                    }
                    if (this.msg.equals("| Finding Rooms |") && this.ncnt == 0) {
                        this.msg = ". | Finding Rooms | .";
                        this.ncnt = 5;
                    }
                    if (this.ncnt != 0)
                        this.ncnt--;
                }
                if (this.fase == 14) {
                    this.msg = "";
                    byte b1 = 0;
                    if (!this.xt.nofull)
                        for (byte b2 = 0; b2 < this.nservers; ) {
                            if (this.xt.delays[b2] >= 400)
                                b1++;
                            b2++;
                        }
                    if (b1 != this.nservers) {
                        boolean bool = false;
                        byte b2 = 0;
                        for (byte b3 = 0; b3 < this.nservers; b3++) {
                            this.rd.setColor(new Color(0, 0, 0));
                            if (this.opselect == b3) {
                                this.rd.setColor(new Color(98, 56, 0));
                                this.rd.fillRoundRect(175, 230 + b3 * 20, 450, 20, 14, 14);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawRoundRect(175, 230 + b3 * 20, 450, 20, 14, 14);
                                this.rd.setColor(color2k(255, 255, 255));
                                if (this.xt.delays[b3] >= 400) {
                                    this.msg = "Your connection to this server is too slow!";
                                    b2 = 1;
                                }
                                if (this.xt.delays[b3] == 600) {
                                    this.msg = "This server is not responding!";
                                    b2 = 1;
                                }
                                if (this.xt.delays[b3] < 400) {
                                    for (byte b4 = 0; b4 < this.nservers; ) {
                                        if (this.xt.delays[b4] < this.xt.delays[b3] && b3 != b4)
                                            bool = true;
                                        b4++;
                                    }
                                    if (bool) {
                                        this.msg = "It is recommended to choose the fastest server.";
                                    } else if (this.xt.delays[b3] >= 300) {
                                        this.msg = "Your connection speed is not perfect.  You may encounter delay!";
                                    }
                                }
                            }
                            this.rd.drawString("Server Name :", 195, 245 + b3 * 20);
                            this.rd.drawString("|   Delay/Speed :", 385, 245 + b3 * 20);
                            int i = 0;
                            int j = 0;
                            String str = "" + this.xt.delays[b3] + "/";
                            if (this.xt.delays[b3] < 75) {
                                str = str + "EXCELENT *****";
                                i = 62;
                                j = 100;
                            }
                            if (this.xt.delays[b3] >= 75 && this.xt.delays[b3] < 150) {
                                str = str + "Perfect ****";
                                i = 62;
                                j = 100;
                            }
                            if (this.xt.delays[b3] >= 150 && this.xt.delays[b3] < 250) {
                                str = str + "Good ***";
                                i = 81;
                                j = 100;
                            }
                            if (this.xt.delays[b3] >= 250 && this.xt.delays[b3] < 400) {
                                str = str + "Acceptable **";
                                i = 100;
                                j = 100;
                            }
                            if (this.xt.delays[b3] >= 400 && this.xt.delays[b3] < 600) {
                                str = str + "Poor";
                                i = 100;
                                j = 0;
                            }
                            if (this.xt.delays[b3] == 600)
                                str = "Not Responding";
                            if (this.opselect == b3) {
                                i = (int) (i * 2.55F);
                                j = (int) (j * 2.55F);
                            }
                            if (i > 255)
                                i = 255;
                            if (i < 0)
                                i = 0;
                            if (j > 255)
                                j = 255;
                            if (j < 0)
                                j = 0;
                            this.rd.setColor(new Color(i, j, 0));
                            this.rd.drawString("" + this.snames[b3] + "", 294, 245 + b3 * 20);
                            this.rd.drawString(str, 497, 245 + b3 * 20);
                        }
                        // original: if (!this.xt.logged && this.xt.nfreeplays - this.xt.ndisco >= 5 && !b2) {
                        if (!this.xt.logged && this.xt.nfreeplays - this.xt.ndisco >= 5) {
                            this.msg = "You have played your 5 games today, please upgrade your account.";
                            b2 = 2;
                        }
                        if (this.xt.nofull) {
                            if (this.nflk % 4 != 0 || this.nflk == 0) {
                                this.rd.setFont(new Font("Arial", 0, 13));
                                this.ftm = this.rd.getFontMetrics();
                                this.rd.setColor(new Color(200, 0, 0));
                                this.rd.drawString("Warning! You did not allow the game full permissions when you started it.", 175, 275);
                                this.rd.setColor(new Color(0, 0, 0));
                                this.rd.drawString("(You didn't click 'Run' at the prompt that came up at the start of the game).", 175, 292);
                                this.rd.drawString("Because of this you will be able to connect to ONLY the game's main server:", 175, 309);
                                this.rd.drawString("'" + this.snames[0] + "', which is not necessarily the fastest server you can connect to.", 175, 326);
                                this.rd.drawString("Please allow Java full permissions next time to be able to play on all servers!", 175, 343);
                                this.rd.setFont(new Font("Arial", 1, 13));
                                this.ftm = this.rd.getFontMetrics();
                            }
                        } else {
                            if (b2 == 0)
                                this.rd.setColor(new Color(98, 56, 0));
                            if (b2 == 1)
                                this.rd.setColor(new Color(200, 0, 0));
                            if (b2 == 2)
                                this.rd.setColor(new Color(30, 70, 110));
                            if (this.nflk % 4 != 0 || this.nflk == 0)
                                this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 360);
                            if (this.nflk != 0)
                                this.nflk--;
                        }
                    } else {
                        if (this.nflk % 4 != 0 || this.nflk == 0) {
                            this.rd.setColor(new Color(200, 0, 0));
                            this.rd.drawString("Sorry.  Your connection is currently not fast enough to play online!", 400 - this.ftm.stringWidth("Sorry.  Your connection is currently not fast enough to play online!") / 2, 242);
                        }
                        if (this.nflk != 0)
                            this.nflk--;
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.setFont(new Font("Arial", 0, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Please make sure you or anyone else using this connection is not slowing", 181, 265);
                        this.rd.drawString("it down right now by downloading or streaming.", 181, 282);
                        this.rd.drawString("Also please make sure you don't have any other programs running on your", 181, 299);
                        this.rd.drawString("computer that maybe consuming your bandwidth.", 181, 316);
                        this.rd.drawString("Otherwise you may need to upgrade your connection speed to play!", 181, 333);
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Press 'Cancel' to try again or to try playing a Lan game instead.", 400 - this.ftm.stringWidth("Press 'Cancel' to try again or to try playing a Lan game instead.") / 2, 357);
                    }
                    drawbutton(this.xt.play, 400, 395);
                }
                if (this.fase == 17) {
                    byte b1 = 14;
                    this.rd.setColor(new Color(0, 0, 0));
                    this.rd.drawString(": :   " + this.xt.servername + "   : :", 400 - this.ftm.stringWidth(": :   " + this.xt.servername + "   : :") / 2, 239);
                    for (byte b2 = 0; b2 < 5; b2++) {
                        if (this.opselect == b2) {
                            this.rd.setColor(new Color(98, 56, 0));
                            this.rd.fillRoundRect(300, 230 + b2 * 20 + b1, 200, 20, 14, 14);
                            this.rd.setColor(new Color(0, 0, 0));
                            this.rd.drawRoundRect(300, 230 + b2 * 20 + b1, 200, 20, 14, 14);
                            this.rd.setColor(color2k(255, 255, 255));
                        }
                        this.rd.drawString("Room " + (b2 + 1) + " :", 329, 245 + b2 * 20 + b1);
                        this.rd.drawString("" + this.rmps[b2] + "  Players", 471 - this.ftm.stringWidth("" + this.rmps[b2] + "  Players"), 245 + b2 * 20 + b1);
                        if (b2 == this.recom)
                            if (this.opselect != b2) {
                                this.rd.setColor(new Color(125, 200, 0));
                            } else {
                                this.rd.setColor(new Color(160, 255, 0));
                            }
                        this.rd.setColor(new Color(0, 0, 0));
                    }
                    drawbutton(this.xt.play, 400, 395);
                }
            } else {
                this.trans += 8;
            }
        }
        if (this.fase == 15) {
            if (this.trans < 100) {
                this.rd.drawImage(this.xt.pln, 400 - this.xt.pln.getWidth(this.ob) / 2, 315 - this.xt.pln.getHeight(this.ob) / 2 - 12 - this.trans, (ImageObserver) null);
            } else {
                this.rd.drawImage(this.xt.pln, 400 - this.xt.pln.getWidth(this.ob) / 2, 215 - this.xt.pln.getHeight(this.ob) / 2 - 12, (ImageObserver) null);
            }
            if (this.trans >= 100) {
                this.rd.setColor(color2k(255, 255, 255));
                this.rd.fillRoundRect(165, 219, 470, 150, 20, 20);
                this.rd.setColor(new Color(0, 0, 0));
                this.rd.drawRoundRect(165, 219, 470, 150, 20, 20);
                this.rd.setFont(new Font("Arial", 1, 13));
                this.ftm = this.rd.getFontMetrics();
                if (this.xt.nofull) {
                    if (this.nflk % 4 != 0 || this.nflk == 0) {
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(200, 0, 0));
                        this.rd.drawString("Sorry. You did not allow the game full permissions when you started it.", 175, 242);
                        this.rd.setFont(new Font("Arial", 0, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.setColor(new Color(0, 0, 0));
                        this.rd.drawString("(You didn't click 'Run' at the prompt that came up at the start of the game).", 175, 262);
                        this.rd.drawString("Because of this the game will not be able to create LAN connections!", 175, 288);
                        this.rd.setFont(new Font("Arial", 1, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("Please restart the game and allow Java full permissions to be able to", 175, 315);
                        this.rd.drawString("play LAN games!", 175, 332);
                        this.rd.setFont(new Font("Arial", 0, 13));
                        this.ftm = this.rd.getFontMetrics();
                        this.rd.drawString("( Close ALL browser windows including this one then", 295, 332);
                        this.rd.drawString("start the game again but click 'Run' when asked to 'run this application'. )", 175, 349);
                    }
                    if (this.nflk != 0)
                        this.nflk--;
                } else {
                    this.rd.drawString("Play a multiplayer game across your Local Area Network (LAN).", 179, 245);
                    this.rd.drawString("Experience the game live with zero delay and 100% real-time action!", 179, 262);
                    this.rd.setFont(new Font("Arial", 0, 13));
                    this.ftm = this.rd.getFontMetrics();
                    this.rd.drawString("This is for if there is more then one computer connected to your network or", 179, 292);
                    this.rd.drawString("if you are in a computer lab or in an internet café.", 179, 309);
                    this.rd.drawString("You can also invite your friends to come over with their Laptop PCs or Macs", 179, 335);
                    this.rd.drawString("to log on to your internet connection/network and play with you!", 179, 352);
                }
                drawbutton(this.xt.cancel, 583, 395);
                drawbutton(this.xt.play, 400, 395);
            } else {
                this.trans += 10;
            }
        }
        if (this.resofaso) {
            this.resofaso = false;
            if (this.connector != null) {
                this.connector.stop();
                this.connector = null;
            }
            this.socketson = false;
            this.msg = "| Connecting to Servers |";
            this.fase = 13;
            this.connector = new Thread(this);
            this.connector.start();
        }
    }

    public void drawSbutton(Image paramImage, int paramInt1, int paramInt2) {
        this.bx[this.btn] = paramInt1;
        this.by[this.btn] = paramInt2;
        this.bw[this.btn] = paramImage.getWidth(this.ob);

        if (!this.pessd[this.btn]) {

            this.rd.drawImage(paramImage, paramInt1 - this.bw[this.btn] / 2, paramInt2 - paramImage.getHeight(this.ob) / 2 - 1, (ImageObserver) null);
            this.rd.drawImage(this.xt.bols, paramInt1 - this.bw[this.btn] / 2 - 15, paramInt2 - 13, (ImageObserver) null);
            this.rd.drawImage(this.xt.bors, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 - 13, (ImageObserver) null);
            this.rd.drawImage(this.xt.bot, paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 - 13, this.bw[this.btn] + 18, 3, null);
            this.rd.drawImage(this.xt.bob, paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 + 10, this.bw[this.btn] + 18, 3, null);
        } else {

            this.rd.drawImage(paramImage, paramInt1 - this.bw[this.btn] / 2 + 1, paramInt2 - paramImage.getHeight(this.ob) / 2, (ImageObserver) null);
            this.rd.drawImage(this.xt.bolps, paramInt1 - this.bw[this.btn] / 2 - 15, paramInt2 - 13, (ImageObserver) null);
            this.rd.drawImage(this.xt.borps, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 - 13, (ImageObserver) null);
            this.rd.drawImage(this.xt.bob, paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 - 13, this.bw[this.btn] + 18, 3, null);
            this.rd.drawImage(this.xt.bot, paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 + 10, this.bw[this.btn] + 18, 3, null);
        }

        this.btn++;
    }


    public void drawbutton(Image paramImage, int paramInt1, int paramInt2) {
        this.bx[this.btn] = paramInt1;
        this.by[this.btn] = paramInt2;
        this.bw[this.btn] = paramImage.getWidth(this.ob);

        if (!this.pessd[this.btn]) {

            this.rd.drawImage(paramImage, paramInt1 - this.bw[this.btn] / 2, paramInt2 - paramImage.getHeight(this.ob) / 2, (ImageObserver) null);
            this.rd.drawImage(this.xt.bol, paramInt1 - this.bw[this.btn] / 2 - 15, paramInt2 - 16, (ImageObserver) null);
            this.rd.drawImage(this.xt.bor, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 - 16, (ImageObserver) null);
            this.rd.drawImage(this.xt.bot, paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 - 16, this.bw[this.btn] + 18, 3, null);
            this.rd.drawImage(this.xt.bob, paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 + 13, this.bw[this.btn] + 18, 3, null);
        } else {

            this.rd.drawImage(paramImage, paramInt1 - this.bw[this.btn] / 2 + 1, paramInt2 - paramImage.getHeight(this.ob) / 2 + 1, (ImageObserver) null);
            this.rd.drawImage(this.xt.bolp, paramInt1 - this.bw[this.btn] / 2 - 15, paramInt2 - 16, (ImageObserver) null);
            this.rd.drawImage(this.xt.borp, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 - 16, (ImageObserver) null);
            this.rd.drawImage(this.xt.bob, paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 - 16, this.bw[this.btn] + 18, 3, null);
            this.rd.drawImage(this.xt.bot, paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 + 13, this.bw[this.btn] + 18, 3, null);
        }

        this.btn++;
    }

    public void multistart(ContO[] paramArrayOfContO, int paramInt1, int paramInt2, boolean paramBoolean) {
        this.btn = 0;
        this.xt.mainbg(4);
        for (byte b1 = 0; b1 < 3; ) {
            this.rd.drawImage(this.xt.bgmain, 65, this.bgmy[b1], (ImageObserver) null);
            this.bgmy[b1] = this.bgmy[b1] - 4;
            if (this.bgmy[b1] <= -400) this.bgmy[b1] = 800;
            b1++;
        }
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.2F));
        this.rd.drawImage(this.xt.bggo, 0, 0, (ImageObserver) null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        this.rd.setColor(new Color(0, 0, 0));
        this.rd.fillRect(65, 425, 670, 25);
        this.rd.fillRect(0, 0, 65, 450);
        this.rd.fillRect(735, 0, 65, 450);
        float f = 1.0F - (this.flipo - 10) / 80.0F;
        if (f > 1.0F) f = 1.0F;
        if (f < 0.0F) f = 0.0F;
        this.rd.setComposite(AlphaComposite.getInstance(3, f));
        if (this.flipo > 10) {
            this.rd.drawImage(this.xt.logomadnes, 96 + (int) (2.0D - Math.random() * 4.0D), 11 + (int) (2.0D - Math.random() * 4.0D), (ImageObserver) null);
        } else {
            this.rd.drawImage(this.xt.logomadnes, 96, 11, (ImageObserver) null);
        }
        this.flipo++;
        if (this.flipo > 50) this.flipo = 0;
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        byte b2 = 0;
        if (paramInt1 != this.oxm || paramInt2 != this.oym) {
            b2 = 1;
            this.oxm = paramInt1;
            this.oym = paramInt2;
        }
        if (paramBoolean) b2 = 2;
        this.rd.setComposite(AlphaComposite.getInstance(3, 0.3F));
        this.rd.drawImage(this.xt.dude[b2], 87, 76, (ImageObserver) null);
        this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
        this.rd.drawImage(this.xt.redy, 445, 153, (ImageObserver) null);
        drawSbutton(this.xt.exit, 690, 17);
        this.rd.setFont(new Font("Arial", 1, 13));
        this.ftm = this.rd.getFontMetrics();
        if (this.fase != 5) {
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
            this.rd.setColor(new Color(203, 227, 253));
            this.rd.fillRoundRect(246, 83, 180, 96, 20, 20);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            this.rd.setColor(color2k(90, 90, 90));
            this.rd.drawString("" + this.xt.cd.names[this.xt.sc[0]] + "", 336 - this.ftm.stringWidth("" + this.xt.cd.names[this.xt.sc[0]] + "") / 2, 81);
            this.rd.drawRoundRect(246, 83, 180, 96, 20, 20);
            if (!this.gotcai) {
                int i = ((paramArrayOfContO[this.xt.sc[0]]).p[0]).oz[0];
                int j = i;
                int k = ((paramArrayOfContO[this.xt.sc[0]]).p[0]).oy[0];
                int m = k;
                for (byte b = 0; b < (paramArrayOfContO[this.xt.sc[0]]).npl; ) {
                    for (byte b3 = 0; b3 < ((paramArrayOfContO[this.xt.sc[0]]).p[b]).n; ) {
                        if (((paramArrayOfContO[this.xt.sc[0]]).p[b]).oz[b3] < i)
                            i = ((paramArrayOfContO[this.xt.sc[0]]).p[b]).oz[b3];
                        if (((paramArrayOfContO[this.xt.sc[0]]).p[b]).oz[b3] > j)
                            j = ((paramArrayOfContO[this.xt.sc[0]]).p[b]).oz[b3];
                        if (((paramArrayOfContO[this.xt.sc[0]]).p[b]).oy[b3] < k)
                            k = ((paramArrayOfContO[this.xt.sc[0]]).p[b]).oy[b3];
                        if (((paramArrayOfContO[this.xt.sc[0]]).p[b]).oy[b3] > m)
                            m = ((paramArrayOfContO[this.xt.sc[0]]).p[b]).oy[b3];
                        b3++;
                    }
                    b++;
                }
                this.cax = (j + i) / 2;
                this.cay = (m + k) / 2;
                this.gotcai = true;
            }
            (paramArrayOfContO[this.xt.sc[0]]).z = 1500;
            (paramArrayOfContO[this.xt.sc[0]]).y = 380 - this.cay;
            (paramArrayOfContO[this.xt.sc[0]]).x = -170 - this.cax;
            (paramArrayOfContO[this.xt.sc[0]]).zy = 0;
            (paramArrayOfContO[this.xt.sc[0]]).xz = -90;
            (paramArrayOfContO[this.xt.sc[0]]).xy = this.pend;
            this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            paramArrayOfContO[this.xt.sc[0]].d(this.rd);
            this.rd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (!this.pendb) {
                this.pend += 2;
                if (this.pend > 80) this.pendb = true;
            } else {
                this.pend -= 2;
                if (this.pend < -10) this.pendb = false;
            }
            drawbutton(this.xt.change, 497, 98);
        }
        if (this.fase == 1 || this.fase == 2) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 205);
            this.rd.drawString("Enter a Nickname:", 400 - this.ftm.stringWidth("Enter a Nickname:") - 14, 241);
            if (this.fase == 2) {
                if (this.msg.equals(". . . | Checking Nickname | . . .") && this.ncnt == 0) {
                    this.msg = "| Checking Nickname |";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". . | Checking Nickname | . .") && this.ncnt == 0) {
                    this.msg = ". . . | Checking Nickname | . . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". | Checking Nickname | .") && this.ncnt == 0) {
                    this.msg = ". . | Checking Nickname | . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals("| Checking Nickname |") && this.ncnt == 0) {
                    this.msg = ". | Checking Nickname | .";
                    this.ncnt = 5;
                }
                if (this.ncnt != 0) this.ncnt--;
                this.pessd[2] = true;
            }
            if (this.fase == 1 && !this.gs.tnick.isShowing()) {
                this.gs.tnick.show();
                this.gs.tnick.requestFocus();
                if (this.gs.tnick.getText().equals("Nickname")) this.gs.tnick.select(8, 8);
            }
            if (this.errcnt != 0) {
                this.errcnt--;
                if (this.errcnt == 0) this.gs.tnick.setForeground(new Color(0, 0, 0));
            }
            drawbutton(this.xt.play, 400, 285);
            if (this.nflk > 0) {
                if (this.gs.tnick.getText().equals("")) {
                    this.gs.tnick.setText("Nickname");
                    if (this.nflk == 1) this.gs.tnick.select(8, 8);
                } else {
                    this.gs.tnick.setText("");
                }
                this.nflk--;
            }
            drawbutton(this.xt.login, 400, 340);
            drawbutton(this.xt.register, 400, 395);
            this.gs.movefield(this.gs.tnick, 400, 225, 129, 23);
            while (this.ftm.stringWidth(this.gs.tnick.getText()) > 86) {
                this.gs.tnick.setText(this.gs.tnick.getText().substring(0, this.gs.tnick.getText().length() - 1));
                this.gs.tnick.select(this.gs.tnick.getText().length(), this.gs.tnick.getText().length());
            }
            if (!this.gs.tnick.getText().equals(this.lnick)) {
                fixtext(this.gs.tnick);
                this.lnick = this.gs.tnick.getText();
            }
            if (this.xt.msgcheck(this.gs.tnick.getText())) this.gs.tnick.setText("");
            if (this.gs.tnick.getText().toLowerCase().indexOf("madbot") != -1) this.gs.tnick.setText("");
        }
        if (this.fase == 3 || this.fase == 4) {
            this.rd.drawImage(this.xt.ntrg, 97, 388, (ImageObserver) null);
            this.rd.setComposite(AlphaComposite.getInstance(3, 0.25F));
            this.rd.setColor(new Color(203, 227, 253));
            this.rd.fillRoundRect(246, 212, 308, 142, 20, 20);
            this.rd.setComposite(AlphaComposite.getInstance(3, 1.0F));
            this.rd.setColor(color2k(90, 90, 90));
            this.rd.drawRoundRect(246, 212, 308, 142, 20, 20);
            this.rd.setColor(new Color(0, 0, 0));
            if (this.nflk % 4 != 0 || this.nflk == 0)
                this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 205);
            if (this.nflk != 0) this.nflk--;
            this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 237);
            this.rd.drawString("Password:", 376 - this.ftm.stringWidth("Password:") - 14, 267);
            if (this.fase == 4) {
                if (this.msg.equals(". . . | Logging In | . . .") && this.ncnt == 0) {
                    this.msg = "| Logging In |";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". . | Logging In | . .") && this.ncnt == 0) {
                    this.msg = ". . . | Logging In | . . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". | Logging In | .") && this.ncnt == 0) {
                    this.msg = ". . | Logging In | . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals("| Logging In |") && this.ncnt == 0) {
                    this.msg = ". | Logging In | .";
                    this.ncnt = 5;
                }
                if (this.ncnt != 0) this.ncnt--;
                this.pessd[2] = true;
            }
            if (this.fase == 3) {
                this.showtf = true;
                if (!this.gs.applejava) {
                    if (!this.gs.tpass.isShowing()) {
                        this.gs.tpass.show();
                        if (!this.gs.tnick.getText().equals("")) this.gs.tpass.requestFocus();
                    }
                    if (!this.gs.tnick.isShowing()) {
                        this.gs.tnick.show();
                        if (this.gs.tnick.getText().equals("")) this.gs.tnick.requestFocus();
                    }
                }
            }
            if (this.errcnt != 0) {
                this.errcnt--;
                if (this.errcnt == 0) {
                    this.gs.tpass.setText("");
                    this.gs.tnick.setForeground(new Color(0, 0, 0));
                    this.gs.tpass.setForeground(new Color(0, 0, 0));
                }
            }
            drawbutton(this.xt.login, 400, 315);
            if (this.onf) {
                this.rd.setColor(color2k(0, 72, 255));
            } else {
                this.rd.setColor(color2k(120, 120, 120));
            }
            this.rd.setFont(new Font("Arial", 1, 11));
            this.ftm = this.rd.getFontMetrics();
            this.rd.drawString("Forgot your nickname or password?", 400 - this.ftm.stringWidth("Forgot your nickname or password?") / 2, 345);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.setFont(new Font("Arial", 1, 12));
            this.ftm = this.rd.getFontMetrics();
            String str = "Register a full account here!";
            this.xrl = 400 - this.ftm.stringWidth(str) / 2;
            this.xrr = this.xrl + this.ftm.stringWidth(str);
            this.rd.drawString(str, this.xrl, 371);
            this.rd.drawLine(this.xrl, 372, this.xrr, 372);
            drawbutton(this.xt.register, 400, 395);
            this.gs.movefieldd(this.gs.tnick, 376, 221, 129, 23, this.showtf);
            if (!this.gs.tnick.getText().equals(this.lnick)) {
                fixtext(this.gs.tnick);
                this.lnick = this.gs.tnick.getText();
            }
            this.gs.movefieldd(this.gs.tpass, 376, 251, 129, 23, this.showtf);
            if (!this.gs.tpass.getText().equals(this.lpass)) {
                fixtext(this.gs.tpass);
                this.lpass = this.gs.tpass.getText();
            }
            if (this.fase == 3 && ((!this.gs.tpass.getText().equals("") && !this.gs.tnick.getText().equals("")) || !this.gs.applejava) && !this.gs.keplo.isShowing())
                this.gs.keplo.show();
            this.gs.movefield(this.gs.keplo, 376, 275, 129, 23);
        }
        if (this.fase == 5) {
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString("Nickname:", 376 - this.ftm.stringWidth("Nickname:") - 14, 141);
            this.gs.movefield(this.gs.tnick, 376, 125, 129, 23);
            while (this.ftm.stringWidth(this.gs.tnick.getText()) > 86) {
                this.gs.tnick.setText(this.gs.tnick.getText().substring(0, this.gs.tnick.getText().length() - 1));
                this.gs.tnick.select(this.gs.tnick.getText().length(), this.gs.tnick.getText().length());
            }
            if (!this.gs.tnick.getText().equals(this.lnick)) {
                fixtext(this.gs.tnick);
                this.lnick = this.gs.tnick.getText();
            }
            if (!this.gs.tnick.isShowing()) this.gs.tnick.show();
            drawbutton(this.xt.register, 400, 325);
            drawbutton(this.xt.cancel, 400, 375);
        }
        if (this.fase == 7 || this.fase == 8) {
            this.rd.setColor(new Color(0, 0, 0));
            if (this.nflk % 4 != 0 || this.nflk == 0)
                this.rd.drawString(this.msg, 400 - this.ftm.stringWidth(this.msg) / 2, 205);
            if (this.nflk != 0)
                this.nflk--;
            this.rd.drawString("Your Email:", 344 - this.ftm.stringWidth("Your Email:") - 14, 241);
            if (this.fase == 8) {
                if (this.msg.equals(". . . | Checking Email | . . .") && this.ncnt == 0) {
                    this.msg = "| Checking Email |";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". . | Checking Email | . .") && this.ncnt == 0) {
                    this.msg = ". . . | Checking Email | . . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals(". | Checking Email | .") && this.ncnt == 0) {
                    this.msg = ". . | Checking Email | . .";
                    this.ncnt = 5;
                }
                if (this.msg.equals("| Checking Email |") && this.ncnt == 0) {
                    this.msg = ". | Checking Email | .";
                    this.ncnt = 5;
                }
                if (this.ncnt != 0)
                    this.ncnt--;
                this.pessd[2] = true;
            }
            if (this.fase == 7) {
                this.showtf = true;
                if (!this.gs.applejava && !this.gs.temail.isShowing()) {
                    this.gs.temail.show();
                    this.gs.temail.requestFocus();
                }
            }
            if (this.errcnt != 0) {
                this.errcnt--;
                if (this.errcnt == 0)
                    this.gs.temail.setForeground(new Color(0, 0, 0));
            }
            drawbutton(this.xt.sdets, 400, 280);
            drawbutton(this.xt.cancel, 400, 375);
            this.gs.movefieldd(this.gs.temail, 344, 225, 199, 23, this.showtf);
            if (!this.gs.temail.getText().equals(this.lemail)) {
                fixtext(this.gs.temail);
                this.lemail = this.gs.temail.getText();
            }
        }
    }

    public void ctachm(int paramInt1, int paramInt2, int paramInt3, Control paramControl, Lobby paramLobby) { // Byte code:

    }

    //Need to sort the structure around stringbutton
    public void stringbutton(String paramString, int paramInt1, int paramInt2, int paramInt3) {
        this.rd.setFont(new Font("Arial", 1, 12));
        this.ftm = this.rd.getFontMetrics();


        this.bx[this.btn] = paramInt1;
        this.by[this.btn] = paramInt2 - 5;
        this.bw[this.btn] = this.ftm.stringWidth(paramString);

        if (!this.pessd[this.btn]) {

            this.rd.setColor(color2k(220, 220, 220));
            this.rd.fillRect(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, this.bw[this.btn] + 20, 25 - paramInt3 * 2);
            this.rd.setColor(color2k(240, 240, 240));
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 17 - paramInt3);
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 18 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 18 - paramInt3);
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 - 19 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 - 19 - paramInt3);
            this.rd.setColor(color2k(200, 200, 200));
            this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 7 - paramInt3);
            this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 11, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 11, paramInt2 + 7 - paramInt3);
            this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 12, paramInt2 - 16 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 12, paramInt2 + 6 - paramInt3);
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 7 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 7 - paramInt3);
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 8 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 8 - paramInt3);
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 + 9 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 + 9 - paramInt3);
            this.rd.setColor(color2k(240, 240, 240));
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 7 - paramInt3);
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 11, paramInt2 - 17 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 11, paramInt2 + 7 - paramInt3);
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 12, paramInt2 - 16 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 12, paramInt2 + 6 - paramInt3);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(paramString, paramInt1 - this.bw[this.btn] / 2, paramInt2);
        } else {

            this.rd.setColor(color2k(210, 210, 210));
            this.rd.fillRect(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, this.bw[this.btn] + 20, 25 - paramInt3 * 2);
            this.rd.setColor(color2k(200, 200, 200));
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 17 - paramInt3);
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 18 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 18 - paramInt3);
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 - 19 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 - 19 - paramInt3);
            this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 7 - paramInt3);
            this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 11, paramInt2 - 17 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 11, paramInt2 + 7 - paramInt3);
            this.rd.drawLine(paramInt1 + this.bw[this.btn] / 2 + 12, paramInt2 - 16 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 12, paramInt2 + 6 - paramInt3);
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 7 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 7 - paramInt3);
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 8 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 10, paramInt2 + 8 - paramInt3);
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 9, paramInt2 + 9 - paramInt3, paramInt1 + this.bw[this.btn] / 2 + 9, paramInt2 + 9 - paramInt3);
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 - 17 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 10, paramInt2 + 7 - paramInt3);
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 11, paramInt2 - 17 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 11, paramInt2 + 7 - paramInt3);
            this.rd.drawLine(paramInt1 - this.bw[this.btn] / 2 - 12, paramInt2 - 16 - paramInt3, paramInt1 - this.bw[this.btn] / 2 - 12, paramInt2 + 6 - paramInt3);
            this.rd.setColor(new Color(0, 0, 0));
            this.rd.drawString(paramString, paramInt1 - this.bw[this.btn] / 2 + 1, paramInt2);
        }

        this.btn++;
    }


    public Color color2k(int paramInt1, int paramInt2, int paramInt3) {
        Color color = new Color(paramInt1, paramInt2, paramInt3);
        float[] arrayOfFloat = new float[3];
        Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), arrayOfFloat);
        arrayOfFloat[0] = 0.13F;
        arrayOfFloat[1] = 0.35F;
        return Color.getHSBColor(arrayOfFloat[0], arrayOfFloat[1], arrayOfFloat[2]);
    }

    public void fixtext(TextField paramTextField) {
        String str1;
        String str2;
        String str3;
        byte b;
        byte b1;
        for (str1 = paramTextField.getText(), str1 = str1.replace('"', '#'), str2 = "\\", str3 = "", b = 0, b1 = -1; b < str1.length(); ) {
            String str = "" + str1.charAt(b);
            if (str.equals("|") || str.equals(",") || str.equals("(") || str.equals(")") || str.equals("#") || str.equals(str2) || str.equals("!") || str.equals("?") || str.equals(" ") || str.equals("~") || str.equals("$") || str.equals("%") || str.equals("^") || str.equals("&") || str.equals("*") || str.equals("+") || str.equals("=") || str.equals(">") || str.equals("<") || str.equals("/") || str.equals("'") || str.equals(";") || str.equals(":") || str.equals(" ")) {
                b1 = b;
            } else {
                str3 = str3 + str;
            }
            b++;
        }
        if (b1 != -1) {
            paramTextField.setText(str3);
            paramTextField.select(b1, b1);
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


