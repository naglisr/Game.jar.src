import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Medium {
    int focus_point = 400;
    int ground = 250;
    int skyline = -300;
    int[] fade = new int[]{3000, 4500, 6000, 7500, 9000, 10500, 12000, 13500, 15000, 16500, 18000, 19500, 21000, 22500, 24000, 25500};

    int[] cldd = new int[]{210, 210, 210, 1, -1000};
    int[] clds = new int[]{210, 210, 210};
    int[] osky = new int[]{170, 220, 255};
    int[] csky = new int[]{170, 220, 255};
    int[] ogrnd = new int[]{205, 200, 200};
    int[] cgrnd = new int[]{205, 200, 200};
    int[] texture = new int[]{0, 0, 0, 50};
    int[] cpol = new int[]{215, 210, 210};
    int[] crgrnd = new int[]{205, 200, 200};
    int[] cfade = new int[]{255, 220, 220};
    int[] snap = new int[]{0, 0, 0};
    int fogd = 7;
    int mgen = (int) (Math.random() * 100000.0D);

    boolean loadnew = false;

    boolean lightson = false;

    boolean darksky = false;

    int lightn = -1;
    int lilo = 217;
    boolean lton = false;
    int noelec = 0;

    int trk = 0;

    boolean crs = false;
    int cx = 400;
    int cy = 225;
    int cz = 50;

    int xz = 0;
    int zy = 0;

    int x = 0;
    int y = 0;
    int z = 0;

    int iw = 0;
    int ih = 0;
    int w = 800;
    int h = 450;

    int nsp = 0;
    int[] spx = new int[7];
    int[] spz = new int[7];
    int[] sprad = new int[7];

    boolean td = false;
    int bcxz = 0;
    boolean bt = false;
    int vxz = 180;
    int adv = 500;

    boolean vert = false;

    float[] tcos = new float[360];
    float[] tsin = new float[360];


    int lastmaf = 0;
    int checkpoint = -1;
    boolean lastcheck = false;
    float elecr = 0.0F;
    boolean cpflik = false;
    boolean nochekflk = false;
    int cntrn;
    boolean[] diup;
    int[] rand;
    int trn;
    int hit;
    int ptr;
    int ptcnt;
    int nrnd;
    long trx;
    long trz;
    long atrx;
    long atrz;
    int fallen;
    float fo;
    float gofo;
    int fvect;
    int[][] ogpx;
    int[][] ogpz;
    float[][] pvr;
    int[] cgpx;
    int[] cgpz;
    int[] pmx;
    float[] pcv;
    int sgpx;
    int sgpz;
    int nrw;
    int ncl;
    int noc;
    int[] clx;
    int[] clz;
    int[] cmx;
    int[][][] clax;
    int[][][] clay;
    int[][][] claz;
    int[][][][] clc;
    int nmt;
    int[] mrd;
    int[] nmv;
    int[][] mtx;
    int[][] mty;
    int[][] mtz;
    int[][][] mtc;
    int nst;
    int[] stx;
    int[] stz;
    int[][][] stc;
    boolean[] bst;
    int[] twn;
    int resdown;
    int rescnt;

    public float random() {
        if (this.cntrn == 0) {
            for (byte b1 = 0; b1 < 3; ) {
                this.rand[b1] = (int) (10.0D * Math.random());
                if (Math.random() > Math.random()) {
                    this.diup[b1] = false;
                } else {
                    this.diup[b1] = true;
                }
                b1++;
            }
            this.cntrn = 20;
        } else {
            this.cntrn--;
        }
        for (byte b = 0; b < 3; ) {
            if (this.diup[b]) {
                this.rand[b] = this.rand[b] + 1;
                if (this.rand[b] == 10) this.rand[b] = 0;
            } else {
                this.rand[b] = this.rand[b] - 1;
                if (this.rand[b] == -1) this.rand[b] = 9;
            }
            b++;
        }
        this.trn++;
        if (this.trn == 3) this.trn = 0;
        return this.rand[this.trn] / 10.0F;
    }

    public void watch(ContO paramContO, int paramInt) {
        if (this.td) {
            this.y = (int) ((paramContO.y - 300) - 1100.0F * random());
            this.x = paramContO.x + (int) ((paramContO.x + 400 - paramContO.x) * cos(paramInt) - (paramContO.z + 5000 - paramContO.z) * sin(paramInt));
            this.z = paramContO.z + (int) ((paramContO.x + 400 - paramContO.x) * sin(paramInt) + (paramContO.z + 5000 - paramContO.z) * cos(paramInt));
            this.td = false;
        }
        short s = 0;
        if (paramContO.x - this.x - this.cx > 0) s = 180;
        int i = -((int) ((90 + s) + Math.atan((paramContO.z - this.z) / (paramContO.x - this.x - this.cx)) / 0.017453292519943295D));
        s = 0;
        if (paramContO.y - this.y - this.cy < 0) s = -180;
        int j = (int) Math.sqrt(((paramContO.z - this.z) * (paramContO.z - this.z) + (paramContO.x - this.x - this.cx) * (paramContO.x - this.x - this.cx)));
        int k = (int) ((90 + s) - Math.atan(j / (paramContO.y - this.y - this.cy)) / 0.017453292519943295D);
        for (; i < 0; i += 360) ;
        for (; i > 360; i -= 360) ;
        this.xz = i;
        this.zy += (k - this.zy) / 5;
        if ((int) Math.sqrt(((paramContO.z - this.z) * (paramContO.z - this.z) + (paramContO.x - this.x - this.cx) * (paramContO.x - this.x - this.cx) + (paramContO.y - this.y - this.cy) * (paramContO.y - this.y - this.cy))) > 6000)
            this.td = true;
    }

    public void aroundtrack(CheckPoints paramCheckPoints) {
        this.y = -this.hit;
        this.x = this.cx + (int) this.trx + (int) (17000.0F * cos(this.vxz));
        this.z = (int) this.trz + (int) (17000.0F * sin(this.vxz));
        if (this.hit > 5000) {
            if (this.hit == 45000) {
                this.fo = 1.0F;
                this.zy = 67;
                this.atrx = (paramCheckPoints.x[0] - this.trx) / 116L;
                this.atrz = (paramCheckPoints.z[0] - this.trz) / 116L;
                this.focus_point = 400;
            }
            if (this.hit == 20000) {
                this.fallen = 500;
                this.fo = 1.0F;
                this.zy = 67;
                this.atrx = (paramCheckPoints.x[0] - this.trx) / 116L;
                this.atrz = (paramCheckPoints.z[0] - this.trz) / 116L;
                this.focus_point = 400;
            }
            this.hit -= this.fallen;
            this.fallen += 7;
            this.trx += this.atrx;
            this.trz += this.atrz;
            if (this.hit < 17600) this.zy -= 2;
            if (this.fallen > 500) this.fallen = 500;
            if (this.hit <= 5000) {
                this.hit = 5000;
                this.fallen = 0;
            }
            this.vxz += 3;
        } else {
            this.focus_point = (int) (400.0F * this.fo);
            if (Math.abs(this.fo - this.gofo) > 0.005D) {
                if (this.fo < this.gofo) {
                    this.fo += 0.005F;
                } else {
                    this.fo -= 0.005F;
                }
            } else {
                this.gofo = (float) (0.3499999940395355D + Math.random() * 1.3D);
            }
            this.vxz++;
            this.trx -= (this.trx - paramCheckPoints.x[this.ptr]) / 10L;
            this.trz -= (this.trz - paramCheckPoints.z[this.ptr]) / 10L;
            if (this.ptcnt == 7) {
                this.ptr++;
                if (this.ptr == paramCheckPoints.n) {
                    this.ptr = 0;
                    this.nrnd++;
                }
                this.ptcnt = 0;
            } else {
                this.ptcnt++;
            }
        }
        if (this.vxz > 360) this.vxz -= 360;
        this.xz = -this.vxz - 90;
        short s = 0;
        if (-this.y - this.cy < 0) s = -180;
        int i = (int) Math.sqrt(((this.trz - this.z + this.cz) * (this.trz - this.z + this.cz) + (this.trx - this.x - this.cx) * (this.trx - this.x - this.cx)));
        if (this.cpflik) {
            this.cpflik = false;
        } else {
            this.cpflik = true;
        }
    }

    public void around(ContO paramContO, boolean paramBoolean) {
        if (!paramBoolean) {
            if (!this.vert) {
                this.adv += 2;
            } else {
                this.adv -= 2;
            }
            if (this.adv > 900) this.vert = true;
            if (this.adv < -500) this.vert = false;
        } else {
            this.adv -= 14;
            if (this.adv < 617) this.adv = 617;
        }
        int i = 500 + this.adv;
        if (paramBoolean && i < 1300) i = 1300;
        if (i < 1000) i = 1000;
        this.y = paramContO.y - this.adv;
        if (this.y > 10) this.vert = false;
        this.x = paramContO.x + (int) ((paramContO.x - i - paramContO.x) * cos(this.vxz));
        this.z = paramContO.z + (int) ((paramContO.x - i - paramContO.x) * sin(this.vxz));
        if (!paramBoolean) {
            this.vxz += 2;
        } else {
            this.vxz += 4;
        }
        short s = 0;
        int j = this.y;
        if (j > 0) j = 0;
        if (paramContO.y - j - this.cy < 0) s = -180;
        int k = (int) Math.sqrt(((paramContO.z - this.z + this.cz) * (paramContO.z - this.z + this.cz) + (paramContO.x - this.x - this.cx) * (paramContO.x - this.x - this.cx)));
        int m = (int) ((90 + s) - Math.atan(k / (paramContO.y - j - this.cy)) / 0.017453292519943295D);
        this.xz = -this.vxz + 90;
        if (paramBoolean) m -= 15;
        this.zy += (m - this.zy) / 10;
    }

    public void getaround(ContO paramContO) {
        if (!this.vert) {
            this.adv += 2;
        } else {
            this.adv -= 2;
        }
        if (this.adv > 1700) this.vert = true;
        if (this.adv < -500) this.vert = false;
        if (paramContO.y - this.adv > 10) this.vert = false;
        int i = 500 + this.adv;
        if (i < 1000) i = 1000;
        int j = paramContO.y - this.adv;
        int k = paramContO.x + (int) ((paramContO.x - i - paramContO.x) * cos(this.vxz));
        int m = paramContO.z + (int) ((paramContO.x - i - paramContO.x) * sin(this.vxz));
        byte b = 0;
        if (Math.abs(j - this.y) > this.fvect) {
            if (this.y < j) {
                this.y += this.fvect;
            } else {
                this.y -= this.fvect;
            }
        } else {
            this.y = j;
            b++;
        }
        if (Math.abs(k - this.x) > this.fvect) {
            if (this.x < k) {
                this.x += this.fvect;
            } else {
                this.x -= this.fvect;
            }
        } else {
            this.x = k;
            b++;
        }
        if (Math.abs(m - this.z) > this.fvect) {
            if (this.z < m) {
                this.z += this.fvect;
            } else {
                this.z -= this.fvect;
            }
        } else {
            this.z = m;
            b++;
        }
        if (b == 3) {
            this.fvect = 200;
        } else {
            this.fvect += 2;
        }
        for (this.vxz += 2; this.vxz > 360; this.vxz -= 360) ;
        int n = -this.vxz + 90;
        short s = 0;
        if (paramContO.x - this.x - this.cx > 0) s = 180;
        int i1 = -((int) ((90 + s) + Math.atan((paramContO.z - this.z) / (paramContO.x - this.x - this.cx)) / 0.017453292519943295D));
        int i2 = this.y;
        s = 0;
        if (i2 > 0) i2 = 0;
        if (paramContO.y - i2 - this.cy < 0) s = -180;
        int i3 = (int) Math.sqrt(((paramContO.z - this.z + this.cz) * (paramContO.z - this.z + this.cz) + (paramContO.x - this.x - this.cx) * (paramContO.x - this.x - this.cx)));
        int i4 = 25;
        if (i3 != 0) i4 = (int) ((90 + s) - Math.atan(i3 / (paramContO.y - i2 - this.cy)) / 0.017453292519943295D);
        for (; n < 0; n += 360) ;
        for (; n > 360; n -= 360) ;
        for (; i1 < 0; i1 += 360) ;
        for (; i1 > 360; i1 -= 360) ;
        if ((Math.abs(n - i1) < 30 || Math.abs(n - i1) > 330) && b == 3) {
            if (Math.abs(n - this.xz) > 7 && Math.abs(n - this.xz) < 353) {
                if (Math.abs(n - this.xz) > 180) {
                    if (this.xz > n) {
                        this.xz += 7;
                    } else {
                        this.xz -= 7;
                    }
                } else if (this.xz < n) {
                    this.xz += 7;
                } else {
                    this.xz -= 7;
                }
            } else {
                this.xz = n;
            }
        } else if (Math.abs(i1 - this.xz) > 6 && Math.abs(i1 - this.xz) < 354) {
            if (Math.abs(i1 - this.xz) > 180) {
                if (this.xz > i1) {
                    this.xz += 3;
                } else {
                    this.xz -= 3;
                }
            } else if (this.xz < i1) {
                this.xz += 3;
            } else {
                this.xz -= 3;
            }
        } else {
            this.xz = i1;
        }
        this.zy += (i4 - this.zy) / 10;
    }

    public void transaround(ContO paramContO1, ContO paramContO2, int paramInt) {
        int i = (paramContO1.x * (20 - paramInt) + paramContO2.x * paramInt) / 20, j = (paramContO1.y * (20 - paramInt) + paramContO2.y * paramInt) / 20, k = (paramContO1.z * (20 - paramInt) + paramContO2.z * paramInt) / 20;
        if (!this.vert) {
            this.adv += 2;
        } else {
            this.adv -= 2;
        }
        if (this.adv > 900) this.vert = true;
        if (this.adv < -500) this.vert = false;
        int m = 500 + this.adv;
        if (m < 1000) m = 1000;
        this.y = j - this.adv;
        if (this.y > 10) this.vert = false;
        this.x = i + (int) ((i - m - i) * cos(this.vxz));
        this.z = k + (int) ((i - m - i) * sin(this.vxz));
        this.vxz += 2;
        short s = 0;
        int n = this.y;
        if (n > 0) n = 0;
        if (j - n - this.cy < 0) s = -180;
        int i1 = (int) Math.sqrt(((k - this.z + this.cz) * (k - this.z + this.cz) + (i - this.x - this.cx) * (i - this.x - this.cx))), i2 = (int) ((90 + s) - Math.atan(i1 / (j - n - this.cy)) / 0.017453292519943295D);
        this.xz = -this.vxz + 90;
        this.zy += (i2 - this.zy) / 10;
    }

    public void follow(ContO paramContO, int paramInt1, int paramInt2) {
        this.zy = 10;
        int i = 2 + Math.abs(this.bcxz) / 4;
        if (i > 20) i = 20;
        if (paramInt2 != 0) {
            if (paramInt2 == 1) {
                if (this.bcxz < 180) this.bcxz += i;
                if (this.bcxz > 180) this.bcxz = 180;
            }
            if (paramInt2 == -1) {
                if (this.bcxz > -180)
                    this.bcxz -= i;
                if (this.bcxz < -180)
                    this.bcxz = -180;
            }
        } else if (Math.abs(this.bcxz) > i) {
            if (this.bcxz > 0) {
                this.bcxz -= i;
            } else {
                this.bcxz += i;
            }
        } else if (this.bcxz != 0) {
            this.bcxz = 0;
        }
        paramInt1 += this.bcxz;
        this.xz = -paramInt1;
        this.x = paramContO.x - this.cx + (int) (-(paramContO.z - 800 - paramContO.z) * sin(paramInt1));
        this.z = paramContO.z - this.cz + (int) ((paramContO.z - 800 - paramContO.z) * cos(paramInt1));
        this.y = paramContO.y - 250 - this.cy;
    }

    public Medium() {
        this.cntrn = 0;
        this.diup = new boolean[]{false, false, false};
        this.rand = new int[]{0, 0, 0};
        this.trn = 0;


        this.hit = 45000;
        this.ptr = 0;
        this.ptcnt = -10;
        this.nrnd = 0;
        this.trx = 0L;
        this.trz = 0L;
        this.atrx = 0L;
        this.atrz = 0L;
        this.fallen = 0;
        this.fo = 1.0F;
        this.gofo = (float) (0.33000001311302185D + Math.random() * 1.34D);


        this.fvect = 200;


        this.ogpx = (int[][]) null;
        this.ogpz = (int[][]) null;
        this.pvr = (float[][]) null;
        this.cgpx = null;
        this.cgpz = null;
        this.pmx = null;
        this.pcv = null;

        this.sgpx = 0;
        this.sgpz = 0;
        this.nrw = 0;
        this.ncl = 0;


        this.noc = 0;
        this.clx = null;
        this.clz = null;
        this.cmx = null;
        this.clax = (int[][][]) null;
        this.clay = (int[][][]) null;
        this.claz = (int[][][]) null;
        this.clc = (int[][][][]) null;


        this.nmt = 0;
        this.mrd = null;
        this.nmv = null;
        this.mtx = (int[][]) null;
        this.mty = (int[][]) null;
        this.mtz = (int[][]) null;
        this.mtc = (int[][][]) null;


        this.nst = 0;
        this.stx = null;
        this.stz = null;
        this.stc = (int[][][]) null;
        this.bst = null;
        this.twn = null;


        this.resdown = 0;
        this.rescnt = 5;
        byte b;
        for (b = 0; b < 'Ũ'; ) {
            this.tcos[b] = (float) Math.cos(b * 0.017453292519943295D);
            b++;
        }
        for (b = 0; b < 'Ũ'; ) {
            this.tsin[b] = (float) Math.sin(b * 0.017453292519943295D);
            b++;
        }
    }

    public void getfollow(ContO paramContO, int paramInt1, int paramInt2) {
        this.zy = 10;
        int i = 2 + Math.abs(this.bcxz) / 4;
        if (i > 20) i = 20;
        if (paramInt2 != 0) {
            if (paramInt2 == 1) {
                if (this.bcxz < 180) this.bcxz += i;
                if (this.bcxz > 180) this.bcxz = 180;
            }
            if (paramInt2 == -1) {
                if (this.bcxz > -180) this.bcxz -= i;
                if (this.bcxz < -180) this.bcxz = -180;
            }
        } else if (Math.abs(this.bcxz) > i) {
            if (this.bcxz > 0) {
                this.bcxz -= i;
            } else {
                this.bcxz += i;
            }
        } else if (this.bcxz != 0) {
            this.bcxz = 0;
        }
        paramInt1 += this.bcxz;
        this.xz = -paramInt1;
        int j = paramContO.x - this.cx + (int) (-(paramContO.z - 800 - paramContO.z) * sin(paramInt1));
        int k = paramContO.z - this.cz + (int) ((paramContO.z - 800 - paramContO.z) * cos(paramInt1));
        int m = paramContO.y - 250 - this.cy;
        byte b = 0;
        if (Math.abs(m - this.y) > this.fvect) {
            if (this.y < m) {
                this.y += this.fvect;
            } else {
                this.y -= this.fvect;
            }
        } else {
            this.y = m;
            b++;
        }
        if (Math.abs(j - this.x) > this.fvect) {
            if (this.x < j) {
                this.x += this.fvect;
            } else {
                this.x -= this.fvect;
            }
        } else {
            this.x = j;
            b++;
        }
        if (Math.abs(k - this.z) > this.fvect) {
            if (this.z < k) {
                this.z += this.fvect;
            } else {
                this.z -= this.fvect;
            }
        } else {
            this.z = k;
            b++;
        }
        if (b == 3) {
            this.fvect = 200;
        } else {
            this.fvect += 2;
        }
    }

    public void newpolys(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Trackers paramTrackers, int paramInt5) {
        Random random = new Random(((paramInt5 + this.cgrnd[0] + this.cgrnd[1] + this.cgrnd[2]) * 1671));
        this.nrw = paramInt2 / 1200 + 9;
        this.ncl = paramInt4 / 1200 + 9;
        this.sgpx = paramInt1 - 4800;
        this.sgpz = paramInt3 - 4800;
        this.ogpx = (int[][]) null;
        this.ogpz = (int[][]) null;
        this.pvr = (float[][]) null;
        this.cgpx = null;
        this.cgpz = null;
        this.pmx = null;
        this.pcv = null;
        this.ogpx = new int[this.nrw * this.ncl][8];
        this.ogpz = new int[this.nrw * this.ncl][8];
        this.pvr = new float[this.nrw * this.ncl][8];
        this.cgpx = new int[this.nrw * this.ncl];
        this.cgpz = new int[this.nrw * this.ncl];
        this.pmx = new int[this.nrw * this.ncl];
        this.pcv = new float[this.nrw * this.ncl];
        byte b1 = 0;
        byte b2 = 0;
        byte b3;
        for (b3 = 0; b3 < this.nrw * this.ncl; b3++) {
            this.cgpx[b3] = this.sgpx + b1 * 1200 + (int) (random.nextDouble() * 1000.0D - 500.0D);
            this.cgpz[b3] = this.sgpz + b2 * 1200 + (int) (random.nextDouble() * 1000.0D - 500.0D);
            if (paramTrackers != null) for (byte b = 0; b < paramTrackers.nt; b++) {
                if (paramTrackers.zy[b] == 0 && paramTrackers.xy[b] == 0) {
                    if (paramTrackers.radx[b] < paramTrackers.radz[b] && Math.abs(this.cgpz[b3] - paramTrackers.z[b]) < paramTrackers.radz[b])
                        for (; Math.abs(this.cgpx[b3] - paramTrackers.x[b]) < paramTrackers.radx[b]; this.cgpx[b3] = (int) (this.cgpx[b3] + random.nextDouble() * paramTrackers.radx[b] * 2.0D - paramTrackers.radx[b]))
                            ;
                    if (paramTrackers.radz[b] < paramTrackers.radx[b] && Math.abs(this.cgpx[b3] - paramTrackers.x[b]) < paramTrackers.radx[b])
                        for (; Math.abs(this.cgpz[b3] - paramTrackers.z[b]) < paramTrackers.radz[b]; this.cgpz[b3] = (int) (this.cgpz[b3] + random.nextDouble() * paramTrackers.radz[b] * 2.0D - paramTrackers.radz[b]))
                            ;
                }
            }
            if (++b1 == this.nrw) {
                b1 = 0;
                b2++;
            }
        }
        for (b3 = 0; b3 < this.nrw * this.ncl; b3++) {
            float f = (float) (0.3D + 1.6D * random.nextDouble());
            this.ogpx[b3][0] = 0;
            this.ogpz[b3][0] = (int) ((100.0D + random.nextDouble() * 760.0D) * f);
            this.ogpx[b3][1] = (int) ((100.0D + random.nextDouble() * 760.0D) * 0.7071D * f);
            this.ogpz[b3][1] = this.ogpx[b3][1];
            this.ogpx[b3][2] = (int) ((100.0D + random.nextDouble() * 760.0D) * f);
            this.ogpz[b3][2] = 0;
            this.ogpx[b3][3] = (int) ((100.0D + random.nextDouble() * 760.0D) * 0.7071D * f);
            this.ogpz[b3][3] = -this.ogpx[b3][3];
            this.ogpx[b3][4] = 0;
            this.ogpz[b3][4] = -((int) ((100.0D + random.nextDouble() * 760.0D) * f));
            this.ogpx[b3][5] = -((int) ((100.0D + random.nextDouble() * 760.0D) * 0.7071D * f));
            this.ogpz[b3][5] = this.ogpx[b3][5];
            this.ogpx[b3][6] = -((int) ((100.0D + random.nextDouble() * 760.0D) * f));
            this.ogpz[b3][6] = 0;
            this.ogpx[b3][7] = -((int) ((100.0D + random.nextDouble() * 760.0D) * 0.7071D * f));
            this.ogpz[b3][7] = -this.ogpx[b3][7];
            for (byte b = 0; b < 8; b++) {
                int i = b - 1;
                if (i == -1) i = 7;
                int j = b + 1;
                if (j == 8) j = 0;
                this.ogpx[b3][b] = ((this.ogpx[b3][i] + this.ogpx[b3][j]) / 2 + this.ogpx[b3][b]) / 2;
                this.ogpz[b3][b] = ((this.ogpz[b3][i] + this.ogpz[b3][j]) / 2 + this.ogpz[b3][b]) / 2;
                this.pvr[b3][b] = (float) (1.1D + random.nextDouble() * 0.8D);
                int k = (int) Math.sqrt((int) ((this.ogpx[b3][b] * this.ogpx[b3][b]) * this.pvr[b3][b] * this.pvr[b3][b] + (this.ogpz[b3][b] * this.ogpz[b3][b]) * this.pvr[b3][b] * this.pvr[b3][b]));
                if (k > this.pmx[b3]) this.pmx[b3] = k;
            }
            this.pcv[b3] = (float) (0.97D + random.nextDouble() * 0.03D);
            if (this.pcv[b3] > 1.0F) this.pcv[b3] = 1.0F;
            if (random.nextDouble() > random.nextDouble()) this.pcv[b3] = 1.0F;
        }
    }

    public void groundpolys(Graphics2D paramGraphics2D) {
        int i = (this.x - this.sgpx) / 1200 - 12;
        if (i < 0) i = 0;
        int j = i + 25;
        if (j > this.nrw) j = this.nrw;
        if (j < i) j = i;
        int k = (this.z - this.sgpz) / 1200 - 12;
        if (k < 0) k = 0;
        int m = k + 25;
        if (m > this.ncl) m = this.ncl;
        if (m < k) m = k;
        int[][] arrayOfInt = new int[j - i][m - k];
        int n;
        for (n = i; n < j; n++) {
            for (int i1 = k; i1 < m; i1++) {
                arrayOfInt[n - i][i1 - k] = 0;
                int i2 = n + i1 * this.nrw;
                if (this.resdown < 2 || i2 % 2 == 0) {
                    int i3 = this.cx + (int) ((this.cgpx[i2] - this.x - this.cx) * cos(this.xz) - (this.cgpz[i2] - this.z - this.cz) * sin(this.xz));
                    int i4 = this.cz + (int) ((this.cgpx[i2] - this.x - this.cx) * sin(this.xz) + (this.cgpz[i2] - this.z - this.cz) * cos(this.xz));
                    int i5 = this.cz + (int) ((250 - this.y - this.cy) * sin(this.zy) + (i4 - this.cz) * cos(this.zy));
                    if (xs(i3 + this.pmx[i2], i5) > 0 && xs(i3 - this.pmx[i2], i5) < this.w && i5 > -this.pmx[i2] && i5 < this.fade[2]) {
                        arrayOfInt[n - i][i1 - k] = i5;
                        int[] arrayOfInt1 = new int[8], arrayOfInt2 = new int[8], arrayOfInt3 = new int[8];
                        for (byte b1 = 0; b1 < 8; ) {
                            arrayOfInt1[b1] = (int) (this.ogpx[i2][b1] * this.pvr[i2][b1] + this.cgpx[i2] - this.x);
                            arrayOfInt2[b1] = (int) (this.ogpz[i2][b1] * this.pvr[i2][b1] + this.cgpz[i2] - this.z);
                            arrayOfInt3[b1] = this.ground;
                            b1++;
                        }
                        rot(arrayOfInt1, arrayOfInt2, this.cx, this.cz, this.xz, 8);
                        rot(arrayOfInt3, arrayOfInt2, this.cy, this.cz, this.zy, 8);
                        int[] arrayOfInt4 = new int[8];
                        int[] arrayOfInt5 = new int[8];
                        byte b2 = 0, b3 = 0, b4 = 0, b5 = 0;
                        boolean bool = true;
                        int i6;
                        for (i6 = 0; i6 < 8; i6++) {
                            arrayOfInt4[i6] = xs(arrayOfInt1[i6], arrayOfInt2[i6]);
                            arrayOfInt5[i6] = ys(arrayOfInt3[i6], arrayOfInt2[i6]);
                            if (arrayOfInt5[i6] < 0 || arrayOfInt2[i6] < 10) b2++;
                            if (arrayOfInt5[i6] > this.h || arrayOfInt2[i6] < 10) b3++;
                            if (arrayOfInt4[i6] < 0 || arrayOfInt2[i6] < 10) b4++;
                            if (arrayOfInt4[i6] > this.w || arrayOfInt2[i6] < 10) b5++;
                        }
                        if (b4 == 8 || b2 == 8 || b3 == 8 || b5 == 8) bool = false;
                        if (bool) {
                            i6 = (int) ((this.cpol[0] * this.pcv[i2] + this.cgrnd[0]) / 2.0F);
                            int i7 = (int) ((this.cpol[1] * this.pcv[i2] + this.cgrnd[1]) / 2.0F);
                            int i8 = (int) ((this.cpol[2] * this.pcv[i2] + this.cgrnd[2]) / 2.0F);
                            if (i5 - this.pmx[i2] > this.fade[0]) {
                                i6 = (i6 * 7 + this.cfade[0]) / 8;
                                i7 = (i7 * 7 + this.cfade[1]) / 8;
                                i8 = (i8 * 7 + this.cfade[2]) / 8;
                            }
                            if (i5 - this.pmx[i2] > this.fade[1]) {
                                i6 = (i6 * 7 + this.cfade[0]) / 8;
                                i7 = (i7 * 7 + this.cfade[1]) / 8;
                                i8 = (i8 * 7 + this.cfade[2]) / 8;
                            }
                            paramGraphics2D.setColor(new Color(i6, i7, i8));
                            paramGraphics2D.fillPolygon(arrayOfInt4, arrayOfInt5, 8);
                        }
                    }
                }
            }
        }
        for (n = i; n < j; n++) {
            for (int i1 = k; i1 < m; i1++) {
                if (arrayOfInt[n - i][i1 - k] != 0) {
                    int i2 = n + i1 * this.nrw;
                    int[] arrayOfInt1 = new int[8], arrayOfInt2 = new int[8], arrayOfInt3 = new int[8];
                    for (byte b1 = 0; b1 < 8; ) {
                        arrayOfInt1[b1] = this.ogpx[i2][b1] + this.cgpx[i2] - this.x;
                        arrayOfInt2[b1] = this.ogpz[i2][b1] + this.cgpz[i2] - this.z;
                        arrayOfInt3[b1] = this.ground;
                        b1++;
                    }
                    rot(arrayOfInt1, arrayOfInt2, this.cx, this.cz, this.xz, 8);
                    rot(arrayOfInt3, arrayOfInt2, this.cy, this.cz, this.zy, 8);
                    int[] arrayOfInt4 = new int[8];
                    int[] arrayOfInt5 = new int[8];
                    byte b2 = 0, b3 = 0, b4 = 0, b5 = 0;
                    boolean bool = true;
                    int i3;
                    for (i3 = 0; i3 < 8; i3++) {
                        arrayOfInt4[i3] = xs(arrayOfInt1[i3], arrayOfInt2[i3]);
                        arrayOfInt5[i3] = ys(arrayOfInt3[i3], arrayOfInt2[i3]);
                        if (arrayOfInt5[i3] < 0 || arrayOfInt2[i3] < 10) b2++;
                        if (arrayOfInt5[i3] > this.h || arrayOfInt2[i3] < 10) b3++;
                        if (arrayOfInt4[i3] < 0 || arrayOfInt2[i3] < 10) b4++;
                        if (arrayOfInt4[i3] > this.w || arrayOfInt2[i3] < 10) b5++;
                    }
                    if (b4 == 8 || b2 == 8 || b3 == 8 || b5 == 8) bool = false;
                    if (bool) {
                        i3 = (int) (this.cpol[0] * this.pcv[i2]);
                        int i4 = (int) (this.cpol[1] * this.pcv[i2]);
                        int i5 = (int) (this.cpol[2] * this.pcv[i2]);
                        if (arrayOfInt[n - i][i1 - k] - this.pmx[i2] > this.fade[0]) {
                            i3 = (i3 * 7 + this.cfade[0]) / 8;
                            i4 = (i4 * 7 + this.cfade[1]) / 8;
                            i5 = (i5 * 7 + this.cfade[2]) / 8;
                        }
                        if (arrayOfInt[n - i][i1 - k] - this.pmx[i2] > this.fade[1]) {
                            i3 = (i3 * 7 + this.cfade[0]) / 8;
                            i4 = (i4 * 7 + this.cfade[1]) / 8;
                            i5 = (i5 * 7 + this.cfade[2]) / 8;
                        }
                        paramGraphics2D.setColor(new Color(i3, i4, i5));
                        paramGraphics2D.fillPolygon(arrayOfInt4, arrayOfInt5, 8);
                    }
                }
            }
        }
    }

    public void newclouds(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        this.clx = null;
        this.clz = null;
        this.cmx = null;
        this.clax = (int[][][]) null;
        this.clay = (int[][][]) null;
        this.claz = (int[][][]) null;
        this.clc = (int[][][][]) null;
        paramInt1 = paramInt1 / 20 - 10000;
        paramInt2 = paramInt2 / 20 + 10000;
        paramInt3 = paramInt3 / 20 - 10000;
        paramInt4 = paramInt4 / 20 + 10000;
        this.noc = (paramInt2 - paramInt1) * (paramInt4 - paramInt3) / 16666667;
        this.clx = new int[this.noc];
        this.clz = new int[this.noc];
        this.cmx = new int[this.noc];
        this.clax = new int[this.noc][3][12];
        this.clay = new int[this.noc][3][12];
        this.claz = new int[this.noc][3][12];
        this.clc = new int[this.noc][2][6][3];
        for (byte b = 0; b < this.noc; b++) {
            this.clx[b] = (int) (paramInt1 + (paramInt2 - paramInt1) * Math.random());
            this.clz[b] = (int) (paramInt3 + (paramInt4 - paramInt3) * Math.random());
            float f1 = (float) (0.25D + Math.random() * 1.25D);
            float f2 = (float) ((200.0D + Math.random() * 700.0D) * f1);
            this.clax[b][0][0] = (int) (f2 * 0.3826D);
            this.claz[b][0][0] = (int) (f2 * 0.9238D);
            this.clay[b][0][0] = (int) ((25.0D - Math.random() * 50.0D) * f1);
            f2 = (float) ((200.0D + Math.random() * 700.0D) * f1);
            this.clax[b][0][1] = (int) (f2 * 0.7071D);
            this.claz[b][0][1] = (int) (f2 * 0.7071D);
            this.clay[b][0][1] = (int) ((25.0D - Math.random() * 50.0D) * f1);
            f2 = (float) ((200.0D + Math.random() * 700.0D) * f1);
            this.clax[b][0][2] = (int) (f2 * 0.9238D);
            this.claz[b][0][2] = (int) (f2 * 0.3826D);
            this.clay[b][0][2] = (int) ((25.0D - Math.random() * 50.0D) * f1);
            f2 = (float) ((200.0D + Math.random() * 700.0D) * f1);
            this.clax[b][0][3] = (int) (f2 * 0.9238D);
            this.claz[b][0][3] = -((int) (f2 * 0.3826D));
            this.clay[b][0][3] = (int) ((25.0D - Math.random() * 50.0D) * f1);
            f2 = (float) ((200.0D + Math.random() * 700.0D) * f1);
            this.clax[b][0][4] = (int) (f2 * 0.7071D);
            this.claz[b][0][4] = -((int) (f2 * 0.7071D));
            this.clay[b][0][4] = (int) ((25.0D - Math.random() * 50.0D) * f1);
            f2 = (float) ((200.0D + Math.random() * 700.0D) * f1);
            this.clax[b][0][5] = (int) (f2 * 0.3826D);
            this.claz[b][0][5] = -((int) (f2 * 0.9238D));
            this.clay[b][0][5] = (int) ((25.0D - Math.random() * 50.0D) * f1);
            f2 = (float) ((200.0D + Math.random() * 700.0D) * f1);
            this.clax[b][0][6] = -((int) (f2 * 0.3826D));
            this.claz[b][0][6] = -((int) (f2 * 0.9238D));
            this.clay[b][0][6] = (int) ((25.0D - Math.random() * 50.0D) * f1);
            f2 = (float) ((200.0D + Math.random() * 700.0D) * f1);
            this.clax[b][0][7] = -((int) (f2 * 0.7071D));
            this.claz[b][0][7] = -((int) (f2 * 0.7071D));
            this.clay[b][0][7] = (int) ((25.0D - Math.random() * 50.0D) * f1);
            f2 = (float) ((200.0D + Math.random() * 700.0D) * f1);
            this.clax[b][0][8] = -((int) (f2 * 0.9238D));
            this.claz[b][0][8] = -((int) (f2 * 0.3826D));
            this.clay[b][0][8] = (int) ((25.0D - Math.random() * 50.0D) * f1);
            f2 = (float) ((200.0D + Math.random() * 700.0D) * f1);
            this.clax[b][0][9] = -((int) (f2 * 0.9238D));
            this.claz[b][0][9] = (int) (f2 * 0.3826D);
            this.clay[b][0][9] = (int) ((25.0D - Math.random() * 50.0D) * f1);
            f2 = (float) ((200.0D + Math.random() * 700.0D) * f1);
            this.clax[b][0][10] = -((int) (f2 * 0.7071D));
            this.claz[b][0][10] = (int) (f2 * 0.7071D);
            this.clay[b][0][10] = (int) ((25.0D - Math.random() * 50.0D) * f1);
            f2 = (float) ((200.0D + Math.random() * 700.0D) * f1);
            this.clax[b][0][11] = -((int) (f2 * 0.3826D));
            this.claz[b][0][11] = (int) (f2 * 0.9238D);
            this.clay[b][0][11] = (int) ((25.0D - Math.random() * 50.0D) * f1);
            byte b1;
            for (b1 = 0; b1 < 12; b1++) {
                int i = b1 - 1;
                if (i == -1) i = 11;
                int j = b1 + 1;
                if (j == 12) j = 0;
                this.clax[b][0][b1] = ((this.clax[b][0][i] + this.clax[b][0][j]) / 2 + this.clax[b][0][b1]) / 2;
                this.clay[b][0][b1] = ((this.clay[b][0][i] + this.clay[b][0][j]) / 2 + this.clay[b][0][b1]) / 2;
                this.claz[b][0][b1] = ((this.claz[b][0][i] + this.claz[b][0][j]) / 2 + this.claz[b][0][b1]) / 2;
            }
            for (b1 = 0; b1 < 12; b1++) {
                f2 = (float) (1.2D + 0.6D * Math.random());
                this.clax[b][1][b1] = (int) (this.clax[b][0][b1] * f2);
                this.claz[b][1][b1] = (int) (this.claz[b][0][b1] * f2);
                this.clay[b][1][b1] = (int) (this.clay[b][0][b1] - 100.0D * Math.random());
                f2 = (float) (1.1D + 0.3D * Math.random());
                this.clax[b][2][b1] = (int) (this.clax[b][1][b1] * f2);
                this.claz[b][2][b1] = (int) (this.claz[b][1][b1] * f2);
                this.clay[b][2][b1] = (int) (this.clay[b][1][b1] - 240.0D * Math.random());
            }
            this.cmx[b] = 0;
            for (b1 = 0; b1 < 12; b1++) {
                int i = b1 - 1;
                if (i == -1) i = 11;
                int j = b1 + 1;
                if (j == 12) j = 0;
                this.clay[b][1][b1] = ((this.clay[b][1][i] + this.clay[b][1][j]) / 2 + this.clay[b][1][b1]) / 2;
                this.clay[b][2][b1] = ((this.clay[b][2][i] + this.clay[b][2][j]) / 2 + this.clay[b][2][b1]) / 2;
                int k = (int) Math.sqrt((this.clax[b][2][b1] * this.clax[b][2][b1] + this.claz[b][2][b1] * this.claz[b][2][b1]));
                if (k > this.cmx[b]) this.cmx[b] = k;
            }
            for (b1 = 0; b1 < 6; b1++) {
                double d1 = Math.random();
                double d2 = Math.random();
                for (byte b2 = 0; b2 < 3; b2++) {
                    f2 = this.clds[b2] * 1.05F - this.clds[b2];
                    this.clc[b][0][b1][b2] = (int) (this.clds[b2] + f2 * d1);
                    if (this.clc[b][0][b1][b2] > 255) this.clc[b][0][b1][b2] = 255;
                    if (this.clc[b][0][b1][b2] < 0) this.clc[b][0][b1][b2] = 0;
                    this.clc[b][1][b1][b2] = (int) ((this.clds[b2] * 1.05F) + f2 * d2);
                    if (this.clc[b][1][b1][b2] > 255) this.clc[b][1][b1][b2] = 255;
                    if (this.clc[b][1][b1][b2] < 0) this.clc[b][1][b1][b2] = 0;
                }
            }
        }
    }

    public void drawclouds(Graphics2D paramGraphics2D) {
        for (byte b = 0; b < this.noc; b++) {
            int i = this.cx + (int) ((this.clx[b] - this.x / 20 - this.cx) * cos(this.xz) - (this.clz[b] - this.z / 20 - this.cz) * sin(this.xz));
            int j = this.cz + (int) ((this.clx[b] - this.x / 20 - this.cx) * sin(this.xz) + (this.clz[b] - this.z / 20 - this.cz) * cos(this.xz));
            int k = this.cz + (int) ((this.cldd[4] - this.y / 20 - this.cy) * sin(this.zy) + (j - this.cz) * cos(this.zy));
            int m = xs(i + this.cmx[b], k);
            int n = xs(i - this.cmx[b], k);
            if (m > 0 && n < this.w && k > -this.cmx[b] && m - n > 20) {
                int[][] arrayOfInt1 = new int[3][12];
                int[][] arrayOfInt2 = new int[3][12];
                int[][] arrayOfInt3 = new int[3][12];
                int[] arrayOfInt4 = new int[12];
                int[] arrayOfInt5 = new int[12];
                byte b1 = 0, b2 = 0, b3 = 0, b4 = 0;
                boolean bool = true;
                int i1 = 0, i2 = 0, i3 = 0;
                int i4;
                for (i4 = 0; i4 < 3; i4++) {
                    for (byte b5 = 0; b5 < 12; b5++) {
                        arrayOfInt1[i4][b5] = this.clax[b][i4][b5] + this.clx[b] - this.x / 20;
                        arrayOfInt3[i4][b5] = this.claz[b][i4][b5] + this.clz[b] - this.z / 20;
                        arrayOfInt2[i4][b5] = this.clay[b][i4][b5] + this.cldd[4] - this.y / 20;
                    }
                    rot(arrayOfInt1[i4], arrayOfInt3[i4], this.cx, this.cz, this.xz, 12);
                    rot(arrayOfInt2[i4], arrayOfInt3[i4], this.cy, this.cz, this.zy, 12);
                }
                for (i4 = 0; i4 < 12; i4 += 2) {
                    b1 = 0;
                    b2 = 0;
                    b3 = 0;
                    b4 = 0;
                    bool = true;
                    i1 = 0;
                    i2 = 0;
                    i3 = 0;
                    int i5;
                    for (i5 = 0; i5 < 6; i5++) {
                        int i6 = 0;
                        byte b5 = 1;
                        if (i5 == 0) i6 = i4;
                        if (i5 == 1) {
                            i6 = i4 + 1;
                            if (i6 >= 12) i6 -= 12;
                        }
                        if (i5 == 2) {
                            i6 = i4 + 2;
                            if (i6 >= 12) i6 -= 12;
                        }
                        if (i5 == 3) {
                            i6 = i4 + 2;
                            if (i6 >= 12) i6 -= 12;
                            b5 = 2;
                        }
                        if (i5 == 4) {
                            i6 = i4 + 1;
                            if (i6 >= 12) i6 -= 12;
                            b5 = 2;
                        }
                        if (i5 == 5) {
                            i6 = i4;
                            b5 = 2;
                        }
                        arrayOfInt4[i5] = xs(arrayOfInt1[b5][i6], arrayOfInt3[b5][i6]);
                        arrayOfInt5[i5] = ys(arrayOfInt2[b5][i6], arrayOfInt3[b5][i6]);
                        i2 += arrayOfInt1[b5][i6];
                        i1 += arrayOfInt2[b5][i6];
                        i3 += arrayOfInt3[b5][i6];
                        if (arrayOfInt5[i5] < 0 || arrayOfInt3[0][i5] < 10) b1++;
                        if (arrayOfInt5[i5] > this.h || arrayOfInt3[0][i5] < 10) b2++;
                        if (arrayOfInt4[i5] < 0 || arrayOfInt3[0][i5] < 10) b3++;
                        if (arrayOfInt4[i5] > this.w || arrayOfInt3[0][i5] < 10) b4++;
                    }
                    if (b3 == 6 || b1 == 6 || b2 == 6 || b4 == 6) bool = false;
                    if (bool) {
                        i2 /= 6;
                        i1 /= 6;
                        i3 /= 6;
                        i5 = (int) Math.sqrt(((this.cy - i1) * (this.cy - i1) + (this.cx - i2) * (this.cx - i2) + i3 * i3));
                        if (i5 < this.fade[7]) {
                            int i6 = this.clc[b][1][i4 / 2][0];
                            int i7 = this.clc[b][1][i4 / 2][1];
                            int i8 = this.clc[b][1][i4 / 2][2];
                            for (byte b5 = 0; b5 < 16; ) {
                                if (i5 > this.fade[b5]) {
                                    i6 = (i6 * this.fogd + this.cfade[0]) / (this.fogd + 1);
                                    i7 = (i7 * this.fogd + this.cfade[1]) / (this.fogd + 1);
                                    i8 = (i8 * this.fogd + this.cfade[2]) / (this.fogd + 1);
                                }
                                b5++;
                            }
                            paramGraphics2D.setColor(new Color(i6, i7, i8));
                            paramGraphics2D.fillPolygon(arrayOfInt4, arrayOfInt5, 6);
                        }
                    }
                }
                for (i4 = 0; i4 < 12; i4 += 2) {
                    b1 = 0;
                    b2 = 0;
                    b3 = 0;
                    b4 = 0;
                    bool = true;
                    i1 = 0;
                    i2 = 0;
                    i3 = 0;
                    int i5;
                    for (i5 = 0; i5 < 6; i5++) {
                        int i6 = 0;
                        boolean bool1 = false;
                        if (i5 == 0) i6 = i4;
                        if (i5 == 1) {
                            i6 = i4 + 1;
                            if (i6 >= 12) i6 -= 12;
                        }
                        if (i5 == 2) {
                            i6 = i4 + 2;
                            if (i6 >= 12) i6 -= 12;
                        }
                        if (i5 == 3) {
                            i6 = i4 + 2;
                            if (i6 >= 12) i6 -= 12;
                            bool1 = true;
                        }
                        if (i5 == 4) {
                            i6 = i4 + 1;
                            if (i6 >= 12) i6 -= 12;
                            bool1 = true;
                        }
                        if (i5 == 5) {
                            i6 = i4;
                            bool1 = true;
                        }
                        arrayOfInt4[i5] = xs(arrayOfInt1[bool1][i6], arrayOfInt3[bool1][i6]);
                        arrayOfInt5[i5] = ys(arrayOfInt2[bool1][i6], arrayOfInt3[bool1][i6]);
                        i2 += arrayOfInt1[bool1][i6];
                        i1 += arrayOfInt2[bool1][i6];
                        i3 += arrayOfInt3[bool1][i6];
                        if (arrayOfInt5[i5] < 0 || arrayOfInt3[0][i5] < 10) b1++;
                        if (arrayOfInt5[i5] > this.h || arrayOfInt3[0][i5] < 10) b2++;
                        if (arrayOfInt4[i5] < 0 || arrayOfInt3[0][i5] < 10) b3++;
                        if (arrayOfInt4[i5] > this.w || arrayOfInt3[0][i5] < 10) b4++;
                    }
                    if (b3 == 6 || b1 == 6 || b2 == 6 || b4 == 6) bool = false;
                    if (bool) {
                        i2 /= 6;
                        i1 /= 6;
                        i3 /= 6;
                        i5 = (int) Math.sqrt(((this.cy - i1) * (this.cy - i1) + (this.cx - i2) * (this.cx - i2) + i3 * i3));
                        if (i5 < this.fade[7]) {
                            int i6 = this.clc[b][0][i4 / 2][0];
                            int i7 = this.clc[b][0][i4 / 2][1];
                            int i8 = this.clc[b][0][i4 / 2][2];
                            for (byte b5 = 0; b5 < 16; ) {
                                if (i5 > this.fade[b5]) {
                                    i6 = (i6 * this.fogd + this.cfade[0]) / (this.fogd + 1);
                                    i7 = (i7 * this.fogd + this.cfade[1]) / (this.fogd + 1);
                                    i8 = (i8 * this.fogd + this.cfade[2]) / (this.fogd + 1);
                                }
                                b5++;
                            }
                            paramGraphics2D.setColor(new Color(i6, i7, i8));
                            paramGraphics2D.fillPolygon(arrayOfInt4, arrayOfInt5, 6);
                        }
                    }
                }
                b1 = 0;
                b2 = 0;
                b3 = 0;
                b4 = 0;
                bool = true;
                i1 = 0;
                i2 = 0;
                i3 = 0;
                for (i4 = 0; i4 < 12; i4++) {
                    arrayOfInt4[i4] = xs(arrayOfInt1[0][i4], arrayOfInt3[0][i4]);
                    arrayOfInt5[i4] = ys(arrayOfInt2[0][i4], arrayOfInt3[0][i4]);
                    i2 += arrayOfInt1[0][i4];
                    i1 += arrayOfInt2[0][i4];
                    i3 += arrayOfInt3[0][i4];
                    if (arrayOfInt5[i4] < 0 || arrayOfInt3[0][i4] < 10) b1++;
                    if (arrayOfInt5[i4] > this.h || arrayOfInt3[0][i4] < 10) b2++;
                    if (arrayOfInt4[i4] < 0 || arrayOfInt3[0][i4] < 10) b3++;
                    if (arrayOfInt4[i4] > this.w || arrayOfInt3[0][i4] < 10) b4++;
                }
                if (b3 == 12 || b1 == 12 || b2 == 12 || b4 == 12) bool = false;
                if (bool) {
                    i2 /= 12;
                    i1 /= 12;
                    i3 /= 12;
                    i4 = (int) Math.sqrt(((this.cy - i1) * (this.cy - i1) + (this.cx - i2) * (this.cx - i2) + i3 * i3));
                    if (i4 < this.fade[7]) {
                        int i5 = this.clds[0];
                        int i6 = this.clds[1];
                        int i7 = this.clds[2];
                        for (byte b5 = 0; b5 < 16; ) {
                            if (i4 > this.fade[b5]) {
                                i5 = (i5 * this.fogd + this.cfade[0]) / (this.fogd + 1);
                                i6 = (i6 * this.fogd + this.cfade[1]) / (this.fogd + 1);
                                i7 = (i7 * this.fogd + this.cfade[2]) / (this.fogd + 1);
                            }
                            b5++;
                        }
                        paramGraphics2D.setColor(new Color(i5, i6, i7));
                        paramGraphics2D.fillPolygon(arrayOfInt4, arrayOfInt5, 12);
                    }
                }
            }
        }
    }

    public void newmountains(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        Random random = new Random(this.mgen);
        this.nmt = (int) (20.0D + 10.0D * random.nextDouble());
        int i = (paramInt1 + paramInt2) / 60;
        int j = (paramInt3 + paramInt4) / 60;
        int k = Math.max(paramInt2 - paramInt1, paramInt4 - paramInt3) / 60;
        this.mrd = null;
        this.nmv = null;
        this.mtx = (int[][]) null;
        this.mty = (int[][]) null;
        this.mtz = (int[][]) null;
        this.mtc = (int[][][]) null;
        this.mrd = new int[this.nmt];
        this.nmv = new int[this.nmt];
        this.mtx = new int[this.nmt][];
        this.mty = new int[this.nmt][];
        this.mtz = new int[this.nmt][];
        this.mtc = new int[this.nmt][][];
        int[] arrayOfInt1 = new int[this.nmt];
        int[] arrayOfInt2 = new int[this.nmt];
        byte b;
        for (b = 0; b < this.nmt; b++) {
            int m = 85;
            float f1 = 0.5F;
            float f2 = 0.5F;
            arrayOfInt1[b] = (int) (10000.0D + random.nextDouble() * 10000.0D);
            int n = (int) (random.nextDouble() * 360.0D);
            if (random.nextDouble() > random.nextDouble()) {
                f1 = (float) (0.2D + random.nextDouble() * 0.35D);
                f2 = (float) (0.2D + random.nextDouble() * 0.35D);
                this.nmv[b] = (int) (f1 * (24.0D + 16.0D * random.nextDouble()));
                m = (int) (85.0D + 10.0D * random.nextDouble());
            } else {
                f1 = (float) (0.3D + random.nextDouble() * 1.1D);
                f2 = (float) (0.2D + random.nextDouble() * 0.35D);
                this.nmv[b] = (int) (f1 * (12.0D + 8.0D * random.nextDouble()));
                m = (int) (104.0D - 10.0D * random.nextDouble());
            }
            this.mtx[b] = new int[this.nmv[b] * 2];
            this.mty[b] = new int[this.nmv[b] * 2];
            this.mtz[b] = new int[this.nmv[b] * 2];
            this.mtc[b] = new int[this.nmv[b]][3];
            byte b1;
            for (b1 = 0; b1 < this.nmv[b]; b1++) {
                this.mtx[b][b1] = (int) (((b1 * 500) + random.nextDouble() * 800.0D - 400.0D - (250 * (this.nmv[b] - 1))) * f1);
                this.mtx[b][b1 + this.nmv[b]] = (int) (((b1 * 500) + random.nextDouble() * 800.0D - 400.0D - (250 * (this.nmv[b] - 1))) * f1);
                this.mtx[b][this.nmv[b]] = (int) (this.mtx[b][0] - (100.0D + random.nextDouble() * 600.0D) * f1);
                this.mtx[b][this.nmv[b] * 2 - 1] = (int) (this.mtx[b][this.nmv[b] - 1] + (100.0D + random.nextDouble() * 600.0D) * f1);
                if (b1 == 0 || b1 == this.nmv[b] - 1)
                    this.mty[b][b1] = (int) ((-400.0D - 1200.0D * random.nextDouble()) * f2 + this.ground);
                if (b1 == 1 || b1 == this.nmv[b] - 2)
                    this.mty[b][b1] = (int) ((-1000.0D - 1450.0D * random.nextDouble()) * f2 + this.ground);
                if (b1 > 1 && b1 < this.nmv[b] - 2)
                    this.mty[b][b1] = (int) ((-1600.0D - 1700.0D * random.nextDouble()) * f2 + this.ground);
                this.mty[b][b1 + this.nmv[b]] = this.ground - 70;
                this.mtz[b][b1] = j + k + arrayOfInt1[b];
                this.mtz[b][b1 + this.nmv[b]] = j + k + arrayOfInt1[b];
                float f = (float) (0.5D + random.nextDouble() * 0.5D);
                this.mtc[b][b1][0] = (int) (170.0F * f + 170.0F * f * this.snap[0] / 100.0F);
                if (this.mtc[b][b1][0] > 255) this.mtc[b][b1][0] = 255;
                if (this.mtc[b][b1][0] < 0) this.mtc[b][b1][0] = 0;
                this.mtc[b][b1][1] = (int) (m * f + 85.0F * f * this.snap[1] / 100.0F);
                if (this.mtc[b][b1][1] > 255) this.mtc[b][b1][1] = 255;
                if (this.mtc[b][b1][1] < 1) this.mtc[b][b1][1] = 0;
                this.mtc[b][b1][2] = 0;
            }
            for (b1 = 1; b1 < this.nmv[b] - 1; b1++) {
                int i1 = b1 - 1;
                int i2 = b1 + 1;
                this.mty[b][b1] = ((this.mty[b][i1] + this.mty[b][i2]) / 2 + this.mty[b][b1]) / 2;
            }
            rot(this.mtx[b], this.mtz[b], i, j, n, this.nmv[b] * 2);
            arrayOfInt2[b] = 0;
        }
        for (b = 0; b < this.nmt; ) {
            for (int m = b + 1; m < this.nmt; ) {
                if (arrayOfInt1[b] < arrayOfInt1[m]) {
                    arrayOfInt2[b] = arrayOfInt2[b] + 1;
                } else {
                    arrayOfInt2[m] = arrayOfInt2[m] + 1;
                }
                m++;
            }
            this.mrd[arrayOfInt2[b]] = b;
            b++;
        }
    }

    public void adjstfade(float paramFloat1, float paramFloat2, int paramInt, GameSparker paramGameSparker) {
        if (this.resdown != 2) {
            if (paramFloat1 == 5.0F) {
                if (this.resdown == 0 && this.rescnt == 0) {
                    paramGameSparker.moto = 0;
                    Madness.anti = 0;
                    this.fade[0] = 3000;
                    fadfrom(this.fade[0]);
                    this.resdown = 1;
                    this.rescnt = 10;
                }
                if (this.resdown == 1 && this.rescnt == 0) this.resdown = 2;
                if ((paramInt == 0 || this.resdown == 0) && paramFloat2 <= -20.0F) this.rescnt--;
            } else if (this.resdown == 0) {
                this.rescnt = 5;
            } else {
                this.rescnt = 10;
            }
        }
    }

    public void drawmountains(Graphics2D paramGraphics2D) {
        for (byte b = 0; b < this.nmt; b++) {
            int i = this.mrd[b];
            int j = this.cx + (int) ((this.mtx[i][0] - this.x / 30 - this.cx) * cos(this.xz) - (this.mtz[i][0] - this.z / 30 - this.cz) * sin(this.xz));
            int k = this.cz + (int) ((this.mtx[i][0] - this.x / 30 - this.cx) * sin(this.xz) + (this.mtz[i][0] - this.z / 30 - this.cz) * cos(this.xz));
            int m = this.cz + (int) ((this.mty[i][0] - this.y / 30 - this.cy) * sin(this.zy) + (k - this.cz) * cos(this.zy));
            int n = this.cx + (int) ((this.mtx[i][this.nmv[i] - 1] - this.x / 30 - this.cx) * cos(this.xz) - (this.mtz[i][this.nmv[i] - 1] - this.z / 30 - this.cz) * sin(this.xz));
            int i1 = this.cz + (int) ((this.mtx[i][this.nmv[i] - 1] - this.x / 30 - this.cx) * sin(this.xz) + (this.mtz[i][this.nmv[i] - 1] - this.z / 30 - this.cz) * cos(this.xz));
            int i2 = this.cz + (int) ((this.mty[i][this.nmv[i] - 1] - this.y / 30 - this.cy) * sin(this.zy) + (i1 - this.cz) * cos(this.zy));
            if (xs(n, i2) > 0 && xs(j, m) < this.w) {
                int[] arrayOfInt1 = new int[this.nmv[i] * 2];
                int[] arrayOfInt2 = new int[this.nmv[i] * 2];
                int[] arrayOfInt3 = new int[this.nmv[i] * 2];
                int i3;
                for (i3 = 0; i3 < this.nmv[i] * 2; ) {
                    arrayOfInt1[i3] = this.mtx[i][i3] - this.x / 30;
                    arrayOfInt2[i3] = this.mty[i][i3] - this.y / 30;
                    arrayOfInt3[i3] = this.mtz[i][i3] - this.z / 30;
                    i3++;
                }
                i3 = (int) Math.sqrt((arrayOfInt1[this.nmv[i] / 4] * arrayOfInt1[this.nmv[i] / 4] + arrayOfInt3[this.nmv[i] / 4] * arrayOfInt3[this.nmv[i] / 4]));
                rot(arrayOfInt1, arrayOfInt3, this.cx, this.cz, this.xz, this.nmv[i] * 2);
                rot(arrayOfInt2, arrayOfInt3, this.cy, this.cz, this.zy, this.nmv[i] * 2);
                int[] arrayOfInt4 = new int[4];
                int[] arrayOfInt5 = new int[4];
                byte b1 = 0, b2 = 0, b3 = 0, b4 = 0;
                boolean bool = true;
                for (byte b5 = 0; b5 < this.nmv[i] - 1; b5++) {
                    b1 = 0;
                    b2 = 0;
                    b3 = 0;
                    b4 = 0;
                    bool = true;
                    for (byte b6 = 0; b6 < 4; b6++) {
                        int i4 = b6 + b5;
                        if (b6 == 2) i4 = b5 + this.nmv[i] + 1;
                        if (b6 == 3) i4 = b5 + this.nmv[i];
                        arrayOfInt4[b6] = xs(arrayOfInt1[i4], arrayOfInt3[i4]);
                        arrayOfInt5[b6] = ys(arrayOfInt2[i4], arrayOfInt3[i4]);
                        if (arrayOfInt5[b6] < 0 || arrayOfInt3[i4] < 10) b1++;
                        if (arrayOfInt5[b6] > this.h || arrayOfInt3[i4] < 10) b2++;
                        if (arrayOfInt4[b6] < 0 || arrayOfInt3[i4] < 10) b3++;
                        if (arrayOfInt4[b6] > this.w || arrayOfInt3[i4] < 10) b4++;
                    }
                    if (b3 == 4 || b1 == 4 || b2 == 4 || b4 == 4) bool = false;
                    if (bool) {
                        float f = i3 / 2500.0F + (8000.0F - this.fade[0]) / 1000.0F - 2.0F - (Math.abs(this.y) - 250.0F) / 5000.0F;
                        if (f > 0.0F && f < 10.0F) {
                            if (f < 3.5D) f = 3.5F;
                            int i4 = (int) (((this.mtc[i][b5][0] + this.cgrnd[0]) + this.csky[0] * f + this.cfade[0] * f) / (2.0F + f * 2.0F));
                            int i5 = (int) (((this.mtc[i][b5][1] + this.cgrnd[1]) + this.csky[1] * f + this.cfade[1] * f) / (2.0F + f * 2.0F));
                            int i6 = (int) (((this.mtc[i][b5][2] + this.cgrnd[2]) + this.csky[2] * f + this.cfade[2] * f) / (2.0F + f * 2.0F));
                            paramGraphics2D.setColor(new Color(i4, i5, i6));
                            paramGraphics2D.fillPolygon(arrayOfInt4, arrayOfInt5, 4);
                        }
                    }
                }
            }
        }
    }

    public void newstars() {
        this.stx = null;
        this.stz = null;
        this.stc = (int[][][]) null;
        this.bst = null;
        this.twn = null;
        this.nst = 0;
        if (this.lightson) {
            Random random = new Random((long) (Math.random() * 100000.0D));
            this.nst = 40;
            this.stx = new int[this.nst];
            this.stz = new int[this.nst];
            this.stc = new int[this.nst][2][3];
            this.bst = new boolean[this.nst];
            this.twn = new int[this.nst];
            for (byte b = 0; b < this.nst; b++) {
                this.stx[b] = (int) (2000.0D * random.nextDouble() - 1000.0D);
                this.stz[b] = (int) (2000.0D * random.nextDouble() - 1000.0D);
                int i = (int) (3.0D * random.nextDouble());
                if (i >= 3) i = 0;
                if (i <= -1) i = 2;
                int j = i + 1;
                if (random.nextDouble() > random.nextDouble()) j = i - 1;
                if (j == 3) j = 0;
                if (j == -1) j = 2;
                for (byte b1 = 0; b1 < 3; b1++) {
                    this.stc[b][0][b1] = 200;
                    if (i == b1) this.stc[b][0][b1] = this.stc[b][0][b1] + (int) (55.0D * random.nextDouble());
                    if (j == b1) this.stc[b][0][b1] = this.stc[b][0][b1] + 55;
                    this.stc[b][0][b1] = (this.stc[b][0][b1] * 2 + this.csky[b1]) / 3;
                    this.stc[b][1][b1] = (this.stc[b][0][b1] + this.csky[b1]) / 2;
                }
                this.twn[b] = (int) (4.0D * random.nextDouble());
                if (random.nextDouble() > 0.8D) {
                    this.bst[b] = true;
                } else {
                    this.bst[b] = false;
                }
            }
        }
    }

    public void drawstars(Graphics2D paramGraphics2D) {
        for (byte b = 0; b < this.nst; b++) {
            int i = this.cx + (int) (this.stx[b] * cos(this.xz) - this.stz[b] * sin(this.xz));
            int j = this.cz + (int) (this.stx[b] * sin(this.xz) + this.stz[b] * cos(this.xz));
            int k = this.cy + (int) (-200.0F * cos(this.zy) - j * sin(this.zy));
            int m = this.cz + (int) (-200.0F * sin(this.zy) + j * cos(this.zy));
            i = xs(i, m);
            k = ys(k, m);
            if (i - 1 > this.iw && i + 3 < this.w && k - 1 > this.ih && k + 3 < this.h) {
                if (this.twn[b] == 0) {
                    int n = (int) (3.0D * Math.random());
                    if (n >= 3) n = 0;
                    if (n <= -1) n = 2;
                    int i1 = n + 1;
                    if (Math.random() > Math.random()) i1 = n - 1;
                    if (i1 == 3) i1 = 0;
                    if (i1 == -1) i1 = 2;
                    for (byte b2 = 0; b2 < 3; ) {
                        this.stc[b][0][b2] = 200;
                        if (n == b2) this.stc[b][0][b2] = this.stc[b][0][b2] + (int) (55.0D * Math.random());
                        if (i1 == b2) this.stc[b][0][b2] = this.stc[b][0][b2] + 55;
                        this.stc[b][0][b2] = (this.stc[b][0][b2] * 2 + this.csky[b2]) / 3;
                        this.stc[b][1][b2] = (this.stc[b][0][b2] + this.csky[b2]) / 2;
                        b2++;
                    }
                    this.twn[b] = 3;
                } else {
                    this.twn[b] = this.twn[b] - 1;
                }
                byte b1 = 0;
                if (this.bst[b]) b1 = 1;
                paramGraphics2D.setColor(new Color(this.stc[b][1][0], this.stc[b][1][1], this.stc[b][1][2]));
                paramGraphics2D.fillRect(i - 1, k, 3 + b1, 1 + b1);
                paramGraphics2D.fillRect(i, k - 1, 1 + b1, 3 + b1);
                paramGraphics2D.setColor(new Color(this.stc[b][0][0], this.stc[b][0][1], this.stc[b][0][2]));
                paramGraphics2D.fillRect(i, k, 1 + b1, 1 + b1);
            }
        }
    }

    public void d(Graphics2D paramGraphics2D) {
        this.nsp = 0;
        if (this.zy > 90) this.zy = 90;
        if (this.zy < -90) this.zy = -90;
        if (this.xz > 360) this.xz -= 360;
        if (this.xz < 0) this.xz += 360;
        if (this.y > 0) this.y = 0;
        this.ground = 250 - this.y;
        int[] arrayOfInt1 = new int[4];
        int[] arrayOfInt2 = new int[4];
        int i = this.cgrnd[0];
        int j = this.cgrnd[1];
        int k = this.cgrnd[2];
        int m = this.crgrnd[0];
        int n = this.crgrnd[1];
        int i1 = this.crgrnd[2];
        int i2 = this.h;
        int i3;
        for (i3 = 0; i3 < 16; i3++) {
            int i9 = this.fade[i3];
            int i10 = this.ground;
            if (this.zy != 0) {
                i10 = this.cy + (int) ((this.ground - this.cy) * cos(this.zy) - (this.fade[i3] - this.cz) * sin(this.zy));
                i9 = this.cz + (int) ((this.ground - this.cy) * sin(this.zy) + (this.fade[i3] - this.cz) * cos(this.zy));
            }
            arrayOfInt1[0] = this.iw;
            arrayOfInt2[0] = ys(i10, i9);
            if (arrayOfInt2[0] < this.ih) arrayOfInt2[0] = this.ih;
            if (arrayOfInt2[0] > this.h) arrayOfInt2[0] = this.h;
            arrayOfInt1[1] = this.iw;
            arrayOfInt2[1] = i2;
            arrayOfInt1[2] = this.w;
            arrayOfInt2[2] = i2;
            arrayOfInt1[3] = this.w;
            arrayOfInt2[3] = arrayOfInt2[0];
            i2 = arrayOfInt2[0];
            if (i3 > 0) {
                m = (m * 7 + this.cfade[0]) / 8;
                n = (n * 7 + this.cfade[1]) / 8;
                i1 = (i1 * 7 + this.cfade[2]) / 8;
                if (i3 < 3) {
                    i = (i * 7 + this.cfade[0]) / 8;
                    j = (j * 7 + this.cfade[1]) / 8;
                    k = (k * 7 + this.cfade[2]) / 8;
                } else {
                    i = m;
                    j = n;
                    k = i1;
                }
            }
            if (arrayOfInt2[0] < this.h && arrayOfInt2[1] > this.ih) {
                paramGraphics2D.setColor(new Color(i, j, k));
                paramGraphics2D.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
            }
        }
        if (this.lightn != -1 && this.lton) {
            if (this.lightn < 16) {
                if (this.lilo > this.lightn + 217) {
                    this.lilo -= 3;
                } else {
                    this.lightn = (int) (16.0F + 16.0F * random());
                }
            } else if (this.lilo < this.lightn + 217) {
                this.lilo += 7;
            } else {
                this.lightn = (int) (16.0F * random());
            }
            this.csky[0] = (int) (this.lilo + this.lilo * this.snap[0] / 100.0F);
            if (this.csky[0] > 255) this.csky[0] = 255;
            if (this.csky[0] < 0) this.csky[0] = 0;
            this.csky[1] = (int) (this.lilo + this.lilo * this.snap[1] / 100.0F);
            if (this.csky[1] > 255) this.csky[1] = 255;
            if (this.csky[1] < 0) this.csky[1] = 0;
            this.csky[2] = (int) (this.lilo + this.lilo * this.snap[2] / 100.0F);
            if (this.csky[2] > 255) this.csky[2] = 255;
            if (this.csky[2] < 0) this.csky[2] = 0;
        }
        i = this.csky[0];
        j = this.csky[1];
        k = this.csky[2];
        i3 = i;
        int i4 = j;
        int i5 = k;
        int i6 = this.cy + (int) ((this.skyline - 700 - this.cy) * cos(this.zy) - (7000 - this.cz) * sin(this.zy));
        int i7 = this.cz + (int) ((this.skyline - 700 - this.cy) * sin(this.zy) + (7000 - this.cz) * cos(this.zy));
        i6 = ys(i6, i7);
        int i8 = this.ih;
        byte b;
        for (b = 0; b < 16; b++) {
            int i9 = this.fade[b];
            int i10 = this.skyline;
            if (this.zy != 0) {
                i10 = this.cy + (int) ((this.skyline - this.cy) * cos(this.zy) - (this.fade[b] - this.cz) * sin(this.zy));
                i9 = this.cz + (int) ((this.skyline - this.cy) * sin(this.zy) + (this.fade[b] - this.cz) * cos(this.zy));
            }
            arrayOfInt1[0] = this.iw;
            arrayOfInt2[0] = ys(i10, i9);
            if (arrayOfInt2[0] > this.h) arrayOfInt2[0] = this.h;
            if (arrayOfInt2[0] < this.ih) arrayOfInt2[0] = this.ih;
            arrayOfInt1[1] = this.iw;
            arrayOfInt2[1] = i8;
            arrayOfInt1[2] = this.w;
            arrayOfInt2[2] = i8;
            arrayOfInt1[3] = this.w;
            arrayOfInt2[3] = arrayOfInt2[0];
            i8 = arrayOfInt2[0];
            if (b > 0) {
                i = (i * 7 + this.cfade[0]) / 8;
                j = (j * 7 + this.cfade[1]) / 8;
                k = (k * 7 + this.cfade[2]) / 8;
            }
            if (arrayOfInt2[1] < i6) {
                i3 = i;
                i4 = j;
                i5 = k;
            }
            if (arrayOfInt2[0] > this.ih && arrayOfInt2[1] < this.h) {
                paramGraphics2D.setColor(new Color(i, j, k));
                paramGraphics2D.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
            }
        }
        arrayOfInt1[0] = this.iw;
        arrayOfInt2[0] = i8;
        arrayOfInt1[1] = this.iw;
        arrayOfInt2[1] = i2;
        arrayOfInt1[2] = this.w;
        arrayOfInt2[2] = i2;
        arrayOfInt1[3] = this.w;
        arrayOfInt2[3] = i8;
        if (arrayOfInt2[0] < this.h && arrayOfInt2[1] > this.ih) {
            float f = (Math.abs(this.y) - 250.0F) / (this.fade[0] * 2);
            if (f < 0.0F) f = 0.0F;
            if (f > 1.0F) f = 1.0F;
            i = (int) ((i * (1.0F - f) + m * (1.0F + f)) / 2.0F);
            j = (int) ((j * (1.0F - f) + n * (1.0F + f)) / 2.0F);
            k = (int) ((k * (1.0F - f) + i1 * (1.0F + f)) / 2.0F);
            paramGraphics2D.setColor(new Color(i, j, k));
            paramGraphics2D.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
        }
        if (this.resdown != 2) {
            for (b = 1; b < 20; b++) {
                int i9 = 7000;
                int i10 = this.skyline - 700 - b * 70;
                if (this.zy != 0 && b != 19) {
                    i10 = this.cy + (int) ((this.skyline - 700 - b * 70 - this.cy) * cos(this.zy) - (7000 - this.cz) * sin(this.zy));
                    i9 = this.cz + (int) ((this.skyline - 700 - b * 70 - this.cy) * sin(this.zy) + (7000 - this.cz) * cos(this.zy));
                }
                arrayOfInt1[0] = this.iw;
                if (b != 19) {
                    arrayOfInt2[0] = ys(i10, i9);
                    if (arrayOfInt2[0] > this.h) arrayOfInt2[0] = this.h;
                    if (arrayOfInt2[0] < this.ih) arrayOfInt2[0] = this.ih;
                } else {
                    arrayOfInt2[0] = this.ih;
                }
                arrayOfInt1[1] = this.iw;
                arrayOfInt2[1] = i6;
                arrayOfInt1[2] = this.w;
                arrayOfInt2[2] = i6;
                arrayOfInt1[3] = this.w;
                arrayOfInt2[3] = arrayOfInt2[0];
                i6 = arrayOfInt2[0];
                i3 = (int) (i3 * 0.991D);
                i4 = (int) (i4 * 0.991D);
                i5 = (int) (i5 * 0.998D);
                if (arrayOfInt2[1] > this.ih && arrayOfInt2[0] < this.h) {
                    paramGraphics2D.setColor(new Color(i3, i4, i5));
                    paramGraphics2D.fillPolygon(arrayOfInt1, arrayOfInt2, 4);
                }
            }
            if (this.lightson) drawstars(paramGraphics2D);
            drawmountains(paramGraphics2D);
            drawclouds(paramGraphics2D);
        }
        groundpolys(paramGraphics2D);
        if (this.noelec != 0) this.noelec--;
        if (this.cpflik) {
            this.cpflik = false;
        } else {
            this.cpflik = true;
            this.elecr = random() * 15.0F - 6.0F;
        }
    }

    public void addsp(int paramInt1, int paramInt2, int paramInt3) {
        if (this.nsp != 7) {
            this.spx[this.nsp] = paramInt1;
            this.spz[this.nsp] = paramInt2;
            this.sprad[this.nsp] = paramInt3;
            this.nsp++;
        }
    }

    public void setsnap(int paramInt1, int paramInt2, int paramInt3) {
        this.snap[0] = paramInt1;
        this.snap[1] = paramInt2;
        this.snap[2] = paramInt3;
    }

    public void setsky(int paramInt1, int paramInt2, int paramInt3) {
        this.osky[0] = paramInt1;
        this.osky[1] = paramInt2;
        this.osky[2] = paramInt3;
        for (byte b = 0; b < 3; b++) {
            this.clds[b] = (this.osky[b] * this.cldd[3] + this.cldd[b]) / (this.cldd[3] + 1);
            this.clds[b] = (int) (this.clds[b] + this.clds[b] * this.snap[b] / 100.0F);
            if (this.clds[b] > 255) this.clds[b] = 255;
            if (this.clds[b] < 0) this.clds[b] = 0;
        }
        this.csky[0] = (int) (paramInt1 + paramInt1 * this.snap[0] / 100.0F);
        if (this.csky[0] > 255) this.csky[0] = 255;
        if (this.csky[0] < 0) this.csky[0] = 0;
        this.csky[1] = (int) (paramInt2 + paramInt2 * this.snap[1] / 100.0F);
        if (this.csky[1] > 255) this.csky[1] = 255;
        if (this.csky[1] < 0) this.csky[1] = 0;
        this.csky[2] = (int) (paramInt3 + paramInt3 * this.snap[2] / 100.0F);
        if (this.csky[2] > 255) this.csky[2] = 255;
        if (this.csky[2] < 0) this.csky[2] = 0;
        float[] arrayOfFloat = new float[3];
        Color.RGBtoHSB(this.csky[0], this.csky[1], this.csky[2], arrayOfFloat);
        if (arrayOfFloat[2] < 0.6D) {
            this.darksky = true;
        } else {
            this.darksky = false;
        }
    }

    public void setcloads(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        if (paramInt4 < 0) paramInt4 = 0;
        if (paramInt4 > 10) paramInt4 = 10;
        if (paramInt5 < -1500) paramInt5 = -1500;
        if (paramInt5 > -500) paramInt5 = -500;
        this.cldd[0] = paramInt1;
        this.cldd[1] = paramInt2;
        this.cldd[2] = paramInt3;
        this.cldd[3] = paramInt4;
        this.cldd[4] = paramInt5;
        for (byte b = 0; b < 3; b++) {
            this.clds[b] = (this.osky[b] * this.cldd[3] + this.cldd[b]) / (this.cldd[3] + 1);
            this.clds[b] = (int) (this.clds[b] + this.clds[b] * this.snap[b] / 100.0F);
            if (this.clds[b] > 255) this.clds[b] = 255;
            if (this.clds[b] < 0) this.clds[b] = 0;
        }
    }

    public void setgrnd(int paramInt1, int paramInt2, int paramInt3) {
        this.ogrnd[0] = paramInt1;
        this.ogrnd[1] = paramInt2;
        this.ogrnd[2] = paramInt3;
        byte b;
        for (b = 0; b < 3; b++) {
            this.cpol[b] = (this.ogrnd[b] * this.texture[3] + this.texture[b]) / (1 + this.texture[3]);
            this.cpol[b] = (int) (this.cpol[b] + this.cpol[b] * this.snap[b] / 100.0F);
            if (this.cpol[b] > 255) this.cpol[b] = 255;
            if (this.cpol[b] < 0) this.cpol[b] = 0;
        }
        this.cgrnd[0] = (int) (paramInt1 + paramInt1 * this.snap[0] / 100.0F);
        if (this.cgrnd[0] > 255) this.cgrnd[0] = 255;
        if (this.cgrnd[0] < 0) this.cgrnd[0] = 0;
        this.cgrnd[1] = (int) (paramInt2 + paramInt2 * this.snap[1] / 100.0F);
        if (this.cgrnd[1] > 255) this.cgrnd[1] = 255;
        if (this.cgrnd[1] < 0) this.cgrnd[1] = 0;
        this.cgrnd[2] = (int) (paramInt3 + paramInt3 * this.snap[2] / 100.0F);
        if (this.cgrnd[2] > 255) this.cgrnd[2] = 255;
        if (this.cgrnd[2] < 0) this.cgrnd[2] = 0;
        for (b = 0; b < 3; ) {
            this.crgrnd[b] = (int) ((this.cpol[b] * 0.99D + this.cgrnd[b]) / 2.0D);
            b++;
        }
    }

    public void setexture(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (paramInt4 < 20) paramInt4 = 20;
        if (paramInt4 > 60) paramInt4 = 60;
        this.texture[0] = paramInt1;
        this.texture[1] = paramInt2;
        this.texture[2] = paramInt3;
        this.texture[3] = paramInt4;
        paramInt1 = (this.ogrnd[0] * paramInt4 + paramInt1) / (1 + paramInt4);
        paramInt2 = (this.ogrnd[1] * paramInt4 + paramInt2) / (1 + paramInt4);
        paramInt3 = (this.ogrnd[2] * paramInt4 + paramInt3) / (1 + paramInt4);
        this.cpol[0] = (int) (paramInt1 + paramInt1 * this.snap[0] / 100.0F);
        if (this.cpol[0] > 255) this.cpol[0] = 255;
        if (this.cpol[0] < 0) this.cpol[0] = 0;
        this.cpol[1] = (int) (paramInt2 + paramInt2 * this.snap[1] / 100.0F);
        if (this.cpol[1] > 255) this.cpol[1] = 255;
        if (this.cpol[1] < 0) this.cpol[1] = 0;
        this.cpol[2] = (int) (paramInt3 + paramInt3 * this.snap[2] / 100.0F);
        if (this.cpol[2] > 255) this.cpol[2] = 255;
        if (this.cpol[2] < 0) this.cpol[2] = 0;
        for (byte b = 0; b < 3; ) {
            this.crgrnd[b] = (int) ((this.cpol[b] * 0.99D + this.cgrnd[b]) / 2.0D);
            b++;
        }
    }

    public void setpolys(int paramInt1, int paramInt2, int paramInt3) {
        this.cpol[0] = (int) (paramInt1 + paramInt1 * this.snap[0] / 100.0F);
        if (this.cpol[0] > 255) this.cpol[0] = 255;
        if (this.cpol[0] < 0) this.cpol[0] = 0;
        this.cpol[1] = (int) (paramInt2 + paramInt2 * this.snap[1] / 100.0F);
        if (this.cpol[1] > 255) this.cpol[1] = 255;
        if (this.cpol[1] < 0) this.cpol[1] = 0;
        this.cpol[2] = (int) (paramInt3 + paramInt3 * this.snap[2] / 100.0F);
        if (this.cpol[2] > 255) this.cpol[2] = 255;
        if (this.cpol[2] < 0) this.cpol[2] = 0;
        for (byte b = 0; b < 3; ) {
            this.crgrnd[b] = (int) ((this.cpol[b] * 0.99D + this.cgrnd[b]) / 2.0D);
            b++;
        }
    }

    public void setfade(int paramInt1, int paramInt2, int paramInt3) {
        this.cfade[0] = (int) (paramInt1 + paramInt1 * this.snap[0] / 100.0F);
        if (this.cfade[0] > 255) this.cfade[0] = 255;
        if (this.cfade[0] < 0) this.cfade[0] = 0;
        this.cfade[1] = (int) (paramInt2 + paramInt2 * this.snap[1] / 100.0F);
        if (this.cfade[1] > 255) this.cfade[1] = 255;
        if (this.cfade[1] < 0) this.cfade[1] = 0;
        this.cfade[2] = (int) (paramInt3 + paramInt3 * this.snap[2] / 100.0F);
        if (this.cfade[2] > 255) this.cfade[2] = 255;
        if (this.cfade[2] < 0) this.cfade[2] = 0;
    }

    public void fadfrom(int paramInt) {
        if (paramInt > 8000) paramInt = 8000;
        for (byte b = 1; b < 17; ) {
            this.fade[b - 1] = paramInt / 2 * (b + 1);
            b++;
        }
    }

    public int xs(int paramInt1, int paramInt2) {
        if (paramInt2 < this.cz) paramInt2 = this.cz;
        return (paramInt2 - this.focus_point) * (this.cx - paramInt1) / paramInt2 + paramInt1;
    }

    public int ys(int paramInt1, int paramInt2) {
        if (paramInt2 < 10) paramInt2 = 10;
        return (paramInt2 - this.focus_point) * (this.cy - paramInt1) / paramInt2 + paramInt1;
    }

    public float cos(int paramInt) {
        for (; paramInt >= 360; paramInt -= 360) ;
        for (; paramInt < 0; paramInt += 360) ;
        return this.tcos[paramInt];
    }

    public float sin(int paramInt) {
        for (; paramInt >= 360; paramInt -= 360) ;
        for (; paramInt < 0; paramInt += 360) ;
        return this.tsin[paramInt];
    }


    public void rot(int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        if (paramInt3 != 0) {
            for (byte b = 0; b < paramInt4; b++) {

                int i = paramArrayOfint1[b];
                int j = paramArrayOfint2[b];
                paramArrayOfint1[b] = paramInt1 + (int) ((i - paramInt1) * cos(paramInt3) - (j - paramInt2) * sin(paramInt3));
                paramArrayOfint2[b] = paramInt2 + (int) ((i - paramInt1) * sin(paramInt3) + (j - paramInt2) * cos(paramInt3));
            }
        }
    }
}


