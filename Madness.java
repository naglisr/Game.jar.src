import java.applet.Applet;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import javax.swing.JOptionPane;

public class Madness extends Panel {
    static Frame frame;
    static Applet applet;
    static String fpath = "";

    static boolean fullscreen = false;
    static int anti = 1;
    static GraphicsDevice myDevice;
    static DisplayMode defdisp;
    static DisplayMode fulldisp;
    static int testdrive = 0;
    static String testcar = "";
    static int textid = 0;


    public static void main(String[] paramArrayOfString) {
        System.runFinalizersOnExit(true);
        frame = new Frame("Need for Madness");
        frame.setBackground(new Color(0, 0, 0));
        frame.setIgnoreRepaint(true);

        fpath = "";
        boolean bool = false;
        for (String str : paramArrayOfString) {
            if (!bool) {
                fpath += str;
                bool = true;
            } else {
                fpath += " " + str;
            }
        }
        if (!fpath.equals("")) {
            if (fpath.equals("manar")) {
                fpath = "";
                try {
                    File file = new File("data/manar.ok");
                    if (!file.exists()) {
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                        bufferedWriter.write("" + (int) (Math.random() * 1000.0D) + "");
                        bufferedWriter.newLine();
                        bufferedWriter.close();
                    }
                } catch (Exception exception) {
                }
            } else {
                File file = new File("" + fpath + "data/models.zip");
                if (!file.exists()) fpath = "";
            }

        }
        frame.setIconImage(Toolkit.getDefaultToolkit().createImage("" + fpath + "data/icon.png"));
        applet = new GameSparker();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent param1WindowEvent) {
                Madness.exitsequance();
            }
        });
        frame.add("Center", applet);
        frame.show();
        frame.setMinimumSize(new Dimension(930, 586));
        frame.setSize(930, 586);
        frame.setExtendedState(6);
        applet.init();
        applet.start();
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        myDevice = graphicsEnvironment.getDefaultScreenDevice();
        defdisp = myDevice.getDisplayMode();
        checknupdate(36);
    }


    public static void gofullscreen() {
        DisplayMode[] arrayOfDisplayMode = myDevice.getDisplayModes();

        String[] arrayOfString1 = new String[100];
        int[] arrayOfInt = new int[100];
        int i = 0;
        float f1 = defdisp.getWidth() / defdisp.getHeight();
        float f2 = -1.0F;
        byte b1 = 0;
        for (byte b2 = 0; b2 < arrayOfDisplayMode.length; b2++) {

            if (arrayOfDisplayMode[b2].getWidth() >= 800 && arrayOfDisplayMode[b2].getBitDepth() >= 16 && b1 < 100) {

                if (arrayOfDisplayMode[b2].getWidth() < 900) {

                    float f = arrayOfDisplayMode[b2].getWidth() / arrayOfDisplayMode[b2].getHeight();
                    f = Math.abs(f1 - f);
                    if (f <= f2 || f2 == -1.0F) {
                        i = b1;
                        f2 = f;
                    }

                }
                arrayOfString1[b1] = "" + arrayOfDisplayMode[b2].getWidth() + " x " + arrayOfDisplayMode[b2].getHeight() + " Resolution   -   " + arrayOfDisplayMode[b2].getBitDepth() + " Bits   -   " + arrayOfDisplayMode[b2].getRefreshRate() + " Refresh Rate";
                arrayOfInt[b1] = b2;
                b1++;
            }
        }
        if (f2 != -1.0F) arrayOfString1[i] = arrayOfString1[i] + "     <  Recommended";
        try {
            File file = new File("" + fpath + "data/full_screen.data");
            if (file.exists()) {
                BufferedReader bufferedReader;
                String str;
                boolean bool;
                for (bufferedReader = new BufferedReader(new FileReader(file)), str = null, bool = false; (str = bufferedReader.readLine()) != null && !bool; ) {
                    str = str.trim();
                    int k = i;
                    try {
                        k = Integer.valueOf(str).intValue();
                    } catch (Exception exception) {
                        k = i;
                    }
                    i = k;
                    if (i < 0) i = 0;
                    if (i > b1 - 1) i = b1 - 1;
                    bool = true;
                }
                bufferedReader.close();
                bufferedReader = null;
            }
        } catch (Exception exception) {
        }
        String[] arrayOfString2;
        byte b3;
        for (arrayOfString2 = new String[b1], b3 = 0; b3 < b1; ) {
            arrayOfString2[b3] = arrayOfString1[b3];
            b3++;
        }
        String[] arrayOfString3 = arrayOfString2;
        Object object = JOptionPane.showInputDialog(null, "Choose a screen resolution setting below and click OK to try it.\nExit Fullscreen by pressing [Esc].\n\nIMPORTANT: If the game does not display properly in Fullscreen press [Esc]      \nand try a different resolution setting below,", "Fullscreen Options", 1, null, (Object[]) arrayOfString3, arrayOfString3[i]);
        int j = -1;
        if (object != null) for (byte b = 0; b < b1; ) {
            if (object.equals(arrayOfString3[b])) {
                j = arrayOfInt[b];
                i = b;
                break;
            }
            b++;
        }
        if (j != -1) {

            try {
                File file = new File("" + fpath + "data/full_screen.data");
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write("" + i + "");
                bufferedWriter.newLine();
                bufferedWriter.close();
                bufferedWriter = null;
            } catch (Exception exception) {
            }
            fullscreen = true;
            frame.dispose();
            frame = new Frame("Fullscreen Need for Madness");
            frame.setBackground(new Color(0, 0, 0));
            frame.setUndecorated(true);
            frame.setResizable(false);
            frame.setExtendedState(6);
            frame.setIgnoreRepaint(true);
            frame.add("Center", applet);
            frame.show();
            if (myDevice.isFullScreenSupported()) {

                try {
                    myDevice.setFullScreenWindow(frame);
                } catch (Exception exception) {
                }
                if (myDevice.isDisplayChangeSupported()) try {
                    myDevice.setDisplayMode(arrayOfDisplayMode[j]);
                } catch (Exception exception) {
                }
            }
            applet.requestFocus();
        }
    }


    public static void exitfullscreen() {
        frame.dispose();
        frame = new Frame("Need for Madness");
        frame.setBackground(new Color(0, 0, 0));
        frame.setIgnoreRepaint(true);
        frame.setIconImage(Toolkit.getDefaultToolkit().createImage("" + fpath + "data/icon.gif"));
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent param1WindowEvent) {
                Madness.exitsequance();
            }
        });
        frame.add("Center", applet);
        frame.show();
        if (myDevice.isFullScreenSupported()) {

            try {
                myDevice.setDisplayMode(defdisp);
            } catch (Exception exception) {
            }
            if (myDevice.isDisplayChangeSupported()) try {
                myDevice.setFullScreenWindow(null);
            } catch (Exception exception) {
            }
        }
        frame.setMinimumSize(new Dimension(930, 586));
        frame.setSize(800, 586);
        frame.setExtendedState(6);
        applet.requestFocus();
        fullscreen = false;
    }

    static int updateon = 0;
    static String upfile = "";

    static boolean inisetup = false;

    public static void exitsequance() {
        if (updateon == 0 || updateon == 3) {

            if (endadv == 1) endadv = 2;
            if (updateon != 3) applet.stop();
            frame.removeAll();


            try {
                Thread.sleep(200L);
            } catch (Exception exception) {
            }
            applet.destroy();
            applet = null;
            System.exit(0);
        }
    }


    public static void checknupdate(int paramInt) {
        String str1 = "";
        boolean bool1 = true;
        boolean bool2 = false;
        String str2 = "";
        byte b = 0;
        String[] arrayOfString1 = new String[100];
        String[] arrayOfString2 = new String[100];
        while (bool1) {

            bool1 = false;


            try {
                URL uRL = new URL("http://multiplayer.needformadness.com/update/" + paramInt + ".txt");


                uRL.openConnection().setConnectTimeout(5000);
                str1 = uRL.openConnection().getContentType();
                if (str1.equals("text/plain")) {

                    DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
                    String str = "";
                    while ((str = dataInputStream.readLine()) != null) {

                        str = str.trim();
                        if (str.startsWith("maddapp")) {
                            str2 = getfuncSvalue("maddapp", str, 0);
                            bool2 = true;
                            bool1 = true;
                        }
                        if (str.startsWith("file") && b < 100) {
                            arrayOfString1[b] = getfuncSvalue("file", str, 0);
                            arrayOfString2[b] = getfuncSvalue("file", str, 1);
                            b++;
                            bool1 = true;
                        }

                    }
                }
                paramInt++;
            } catch (Exception exception) {
                str1 = "";
            }

        }


        if (bool2 || b != 0) {

            updateon = 1;
            frame.dispose();
            while (inisetup) ;
            applet.stop();
            applet.destroy();
            if (fullscreen && myDevice.isFullScreenSupported()) {
                try {
                    myDevice.setDisplayMode(defdisp);
                } catch (Exception exception) {
                }
                if (myDevice.isDisplayChangeSupported()) try {
                    myDevice.setFullScreenWindow(null);
                } catch (Exception exception) {
                }
            }
            frame = new Frame("Updating Need for Madness...");
            frame.setBackground(new Color(234, 240, 247));
            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent param1WindowEvent) {
                    Madness.exitsequance();
                }
            });
            applet = new update();
            frame.add("Center", applet);
            frame.show();
            frame.setSize(800, 300);
            frame.setResizable(false);
            frame.setLocation((int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - 800.0D) / 2.0D), (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() - 300.0D) / 2.0D));
            applet.init();
            applet.start();

            if (b != 0) {
                for (byte b1 = 0; b1 < b; b1++) {


                    try {
                        upfile = "Downloading and updating file: " + arrayOfString2[b1] + "";
                        updateon = 2;
                        URL uRL = new URL(arrayOfString1[b1]);
                        int i = uRL.openConnection().getContentLength();
                        DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
                        byte[] arrayOfByte = new byte[i];
                        dataInputStream.readFully(arrayOfByte);
                        File file = new File("" + fpath + "" + arrayOfString2[b1] + "");
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(arrayOfByte);
                        fileOutputStream.close();
                        fileOutputStream = null;
                        dataInputStream.close();
                        dataInputStream = null;
                    } catch (Exception exception) {
                    }
                }
            }

            if (bool2) {

                try {

                    upfile = "Downloading and updating game's code";
                    updateon = 2;
                    URL uRL = new URL(str2);
                    int i = uRL.openConnection().getContentLength();
                    DataInputStream dataInputStream = new DataInputStream(uRL.openStream());
                    byte[] arrayOfByte = new byte[i];
                    dataInputStream.readFully(arrayOfByte);
                    File file = new File("" + fpath + "madapp.jar");
                    if (file.exists()) {
                        FileOutputStream fileOutputStream1 = new FileOutputStream(file);
                        fileOutputStream1.write(arrayOfByte);
                        fileOutputStream1.close();
                        fileOutputStream1 = null;
                    }
                    file = new File("" + fpath + "madapps.jar");
                    if (file.exists()) {
                        FileOutputStream fileOutputStream1 = new FileOutputStream(file);
                        fileOutputStream1.write(arrayOfByte);
                        fileOutputStream1.close();
                        fileOutputStream1 = null;
                    }
                    file = new File("" + fpath + "data/madapp.jar");
                    if (file.exists()) {
                        FileOutputStream fileOutputStream1 = new FileOutputStream(file);
                        fileOutputStream1.write(arrayOfByte);
                        fileOutputStream1.close();
                        fileOutputStream1 = null;
                    }
                    file = new File("" + fpath + "data/madapps.jar");
                    if (file.exists()) {
                        FileOutputStream fileOutputStream1 = new FileOutputStream(file);
                        fileOutputStream1.write(arrayOfByte);
                        fileOutputStream1.close();
                        fileOutputStream1 = null;
                    }
                    file = new File("" + fpath + "Madness.app/Contents/Java/madapp.jar");
                    if (file.exists()) {
                        FileOutputStream fileOutputStream1 = new FileOutputStream(file);
                        fileOutputStream1.write(arrayOfByte);
                        fileOutputStream1.close();
                        fileOutputStream1 = null;
                    }
                    file = new File("" + fpath + "Game.jar");
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(arrayOfByte);
                    fileOutputStream.close();
                    fileOutputStream = null;
                    dataInputStream.close();
                    dataInputStream = null;
                } catch (Exception exception) {
                }
            }

            updateon = 3;
        }
    }


    public static void carmaker() {
        applet.stop();
        frame.removeAll();
        try {
            Thread.sleep(400L);
        } catch (Exception exception) {
        }

        applet.destroy();
        applet = null;
        System.gc();
        System.runFinalization();

        try {
            Thread.sleep(400L);
        } catch (Exception exception) {
        }

        applet = new CarMaker();
        frame.add("Center", applet);
        frame.show();
        applet.init();
        applet.start();
    }


    public static void stagemaker() {
        applet.stop();
        frame.removeAll();
        try {
            Thread.sleep(400L);
        } catch (Exception exception) {
        }

        applet.destroy();
        applet = null;
        System.gc();
        System.runFinalization();

        try {
            Thread.sleep(400L);
        } catch (Exception exception) {
        }

        applet = new StageMaker();
        frame.add("Center", applet);
        frame.show();
        applet.init();
        applet.start();
    }


    public static void game() {
        applet.stop();
        frame.removeAll();
        try {
            Thread.sleep(400L);
        } catch (Exception exception) {
        }

        applet.destroy();
        applet = null;
        System.gc();
        System.runFinalization();

        try {
            Thread.sleep(400L);
        } catch (Exception exception) {
        }

        applet = new GameSparker();
        frame.add("Center", applet);
        frame.show();
        applet.init();
        applet.start();
    }


    static int endadv = 0;
    static long advtime = 0L;


    public static void advopen() {
        try {
            File file = new File("" + fpath + "data/user.data");
            if (file.exists()) {

                Date date = new Date();
                long l = date.getTime();
                if (advtime == 0L || l - advtime > 120000L) {

                    String str = System.getProperty("os.name").toLowerCase();
                    if (str.indexOf("win") != -1) {
                        File file1 = new File("" + fpath + "data/adv.bat");
                        boolean bool = false;
                        if (!file1.exists()) {
                            bool = true;
                        } else if (file1.length() != 81L) {
                            bool = true;
                        }
                        if (bool) {
                            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
                            bufferedWriter.write("cd %programfiles%\\Internet Explorer");
                            bufferedWriter.newLine();
                            bufferedWriter.write("iexplore -k http://www.needformadness.com/");
                            bufferedWriter.newLine();
                            bufferedWriter.close();
                            bufferedWriter = null;
                        }
                        Process process;
                        DataInputStream dataInputStream;
                        for (process = Runtime.getRuntime().exec(file1.getAbsolutePath()), dataInputStream = new DataInputStream(process.getInputStream()); dataInputStream.readLine() != null; )
                            ;
                    } else {
                        openurl("http://www.needformadness.com/");
                    }
                    advtime = l;
                    endadv = 1;
                }
            }
        } catch (Exception exception) {
        }
    }

    public static String urlopen() {
        String str1 = "explorer", str2 = System.getProperty("os.name").toLowerCase();
        if (str2.indexOf("linux") != -1 || str2.indexOf("unix") != -1 || str2.equals("aix")) str1 = "xdg-open";
        if (str2.indexOf("mac") != -1) str1 = "open";
        return str1;
    }

    public static void openurl(String paramString) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(paramString));
            } catch (Exception exception) {
            }
        } else {
            try {
                Runtime.getRuntime().exec("" + urlopen() + " " + paramString + "");
            } catch (Exception exception) {
            }
        }
    }

    public static String getfuncSvalue(String paramString1, String paramString2, int paramInt) {
        String str;
        byte b;
        int i;
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

}


