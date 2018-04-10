package platform.console.test;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Random;
//
//public class GA {
//
//    private int         scale;  // 种群规模
//    private int         choNum; // 染色体长度,g+c+t
//    private int         gNum, cNum, tNum;
//
//    private int         MAX_GEN;         // 运行代数
//    private float[][][] exData;           // 表达水平矩阵，第一维是condition，第二维是gene，第三维是time; // 表达水平矩阵
//    private int         bestT;            // 最佳出现代数
//    private float       bestLength;      // 最佳适应度值
//    private int[]       bestTricluster;  // 最佳聚类簇
//    private int         MAX_CLU;          // 聚类数
//    private int[][]     sol;              // 最佳聚类集，MAX_CLU*choNum
//    private int         cc;               // 当前已找到的聚类数
//    // 初始种群，父代种群，行数表示种群规模，一行代表一个个体，即染色体，列表示染色体基因片段
//    private int[][]     oldPopulation;
//    private int[][]     newPopulation;    // 新的种群，子代种群
//    private float[]     fitness;          // 种群适应度，表示种群中各个个体的适应度
//    private float       Ale;              // 种群初始化中的随机率
//    private float[]     Pi;               // 种群中各个个体的累计概率
//    private float       Ps;               // 选择概率
//    private float       Pm;               // 变异概率
//    private int         ite;              // 当前代数
//    private int         sNum;             // 选择的个体
//    private int         cpNum;            // 交叉的父本数
//    private float       Wf, Wg, Wc, Wt, WOg, WOc, WOt;
//    private int[]       lev;                           // Data Hierarchy,按出现次数存储位置号，如第0位是出现次数最少的位置号，最后一位是出现次数最多的位置号。
//
//    private Random      random;
//
//    public GA() {
//
//    }
//
//    /**
//     * constructor of GA
//     * 
//     * @param s
//     *            种群规模
//     * @param n
//     *            聚类个数
//     * @param gN
//     *            总基因数
//     * @param tN
//     *            总时间数
//     * @param cN
//     *            总条件数
//     * @param G
//     *            运行代数
//     * @param pc
//     *            交叉率
//     * @param ale
//     *            初始化种群中随机产生的种群数因子
//     * @param m
//     *            突变率
//     * @param sel
//     *            选择率
//     * @param wf
//     *            这个我也不知道是什么，值固定为0.8
//     * @param wg
//     *            基因个数因子
//     * @param wc
//     *            条件个数因子
//     * @param wt
//     *            时间个数因子
//     * @param wog
//     *            基因重复率因子
//     * @param woc
//     *            条件重复率因子
//     * @param wot
//     *            时间重复率因子
//     **/
//    public GA(int n, int s, int gN, int tN, int cN, int G, float pc, float ale, float m, float sel, float wf, float wg, float wc, float wt, float wog, float woc, float wot) {
//        MAX_CLU = n;
//        scale = s;
//        gNum = gN;
//        cNum = cN;
//        tNum = tN;
//        choNum = cN + gN + tN;
//        MAX_GEN = G;
//        Ale = ale;
//        Pm = m;
//        Ps = sel;
//        Wf = wf;
//        Wg = wg;
//        Wc = wc;
//        Wt = wt;
//        WOg = wog;
//        WOc = woc;
//        WOt = wot;
//        sNum = (int) (scale * Ps);
//        cpNum = scale - sNum;
//        exData = new float[tNum][gNum][cNum];
//        sol = new int[MAX_CLU][choNum];
//        lev = new int[choNum];
//        for ( int i = 0 ; i < choNum ; i++ ) {
//            lev[i] = i;
//        }
//    }
//
//    public void init() throws IOException{
//        // 读取数据
//        try {
//            // 读取文件夹内文件，按0-1-11-12-13……-2-3-4的顺序读取文件
//            // String filepath = "d:/ecworkspace/TriGenV0/0014";
//            // File file = new File(filepath);
//            // String[] filelist = file.list();
//            //
//            // for (int k = 0; k < filelist.length; k++) {
//            // File readfile = new File(filepath + "\\" + filelist[k]);
//            //
//            // if (!readfile.isDirectory()) {
//            // //读取文件内容
//            //
//            // String filename = readfile.getPath();
//            // BufferedReader reader = new BufferedReader(new FileReader(filename));
//            // //reader.readLine();//第一行信息，为标题信息，不用
//            // String line = null;
//            // int i = 0;
//            // while((line=reader.readLine())!=null){
//            // String item[] = line.split(";");//CSV格式文件为分号分隔符文件，这里根据分号切分
//            // for (int j =0;j < cNum;j++){
//            // float a = Float.parseFloat(item[j]);//字符串转化为数值
//            // exData[k][i][j] = a;
//            // }
//            // i++;
//            // }
//            // reader.close();
//            //
//            // } else if (readfile.isDirectory()) {
//            // System.out.println("文件夹");
//            // }
//            // }
//            // 按0-1-2-3……-10-11的顺序读取文件
//            for ( int k = 0 ; k < tNum ; k++ ) {
//                String filename = "sintetico01_t" + k + ".csv";
//                BufferedReader reader = new BufferedReader (new FileReader (filename));
//                // reader.readLine();//第一行信息，为标题信息，不用
//                String line = null;
//                int i = 0;
//                while ((line = reader.readLine ()) != null) {
//                    String item[] = line.split (";");// CSV格式文件为分号分隔符文件，这里根据分号切分
//                    for ( int j = 0 ; j < cNum ; j++ ) {
//                        float a = Float.parseFloat (item[j]);// 字符串转化为数值
//                        exData[k][i][j] = a;
//
//                    }
//                    i++;
//                }
//
//                reader.close ();
//
//            }
//
//        } catch (FileNotFoundException e) {
//            System.out.println ("readfile()   Exception:" + e.getMessage ());
//        }
//
//        bestTricluster = new int[choNum];
//        bestT = 0;
//        ite = 0;
//
//        newPopulation = new int[scale][choNum];
//        oldPopulation = new int[scale][choNum];
//        fitness = new float[scale];
//        Pi = new float[scale];
//
//        random = new Random (System.currentTimeMillis ());
//
//    }
//
//    // 初始化种群
//    void initGroup(){
//        int i, j;
//        int sum = 0;
//
//        // 随机产生的种群
//        for ( j = 0 ; j < (int) (Ale * scale / 2) ; j++ ) {
//            for ( i = 0 ; i < choNum ; i++ ) {
//                oldPopulation[j][i] = Math.random () > 0.5 ? 1 : 0;
//                sum += oldPopulation[j][i];
//                // 确保至少有两个坐标
//                if (i == cNum - 1) {
//                    int n = 0;
//                    SureTwoCod (sum, n, i, j);
//
//                } else if (i == cNum + gNum - 1) {
//                    int n = cNum;
//                    SureTwoCod (sum, n, i, j);
//                }
//                // 检查个体中的condition，gene，time坐标数，保证每个子染色体至少有两个坐标数
//            }
//            int n = cNum + gNum;
//            SureTwoCod (sum, n, i - 1, j);
//        }
//        // 随机连续产生的种群
//        for ( ; j < (Ale * scale - (int) (Ale * scale / 2)) ; j++ ) {
//
//            // 产生随机坐标数
//            int triCNum = random.nextInt (cNum - 2) + 2;
//            int triGNum = random.nextInt (gNum - 2) + 2;
//            int triTNum = random.nextInt (tNum - 2) + 2;
//            // 产生初始位
//            int in = random.nextInt (cNum - triCNum);// in要小于cNum-triCNum
//            // 产生 随机数个 连续坐标
//            for ( i = in ; i < in + triCNum ; i++ ) {
//                oldPopulation[j][i] = 1;
//            }
//            in = random.nextInt (gNum - triGNum);
//            for ( i = in + cNum ; i < in + cNum + triGNum ; i++ ) {
//                oldPopulation[j][i] = 1;
//            }
//            in = random.nextInt (tNum - triTNum);
//            for ( i = in + cNum + gNum ; i < in + cNum + gNum + triTNum ; i++ ) {
//                oldPopulation[j][i] = 1;
//            }
//        }
//        // 控制重复率并随机产生的种群，优先选择出现次数少的
//        for ( ; j < scale ; j++ ) {
//            // 产生随机坐标数
//            int triCNum = random.nextInt (cNum - 2) + 2;
//            int triGNum = random.nextInt (gNum - 2) + 2;
//            int triTNum = random.nextInt (tNum - 2) + 2;
//            for ( i = 0 ; i < triCNum ; i++ ) {
//                oldPopulation[j][lev[i]] = 1;
//            }
//            for ( i = cNum ; i < cNum + triGNum ; i++ ) {
//                oldPopulation[j][lev[i]] = 1;
//            }
//            for ( i = cNum + gNum ; i < cNum + gNum + triTNum ; i++ ) {
//                oldPopulation[j][lev[i]] = 1;
//            }
//        }
//
//        /*
//         * for(i=0;i<scale;i++) { for(j=0;j<cityNum;j++) { System.out.print(oldPopulation[i][j]+","); } System.out.println(); }
//         */
//    }
//
//    private void SureTwoCod(int sum,int n,int i,int j){
//        // 确保生成的每个初始子染色体中至少有2个坐标
//        if (sum < 2) {
//            // condition,'0'位置'1'
//            int[] zeroPo = new int[sum];
//            int m = 0;
//            for ( ; n < i + 1 ; n++ ) {
//                if (newPopulation[j][n] == 0) {
//                    zeroPo[m] = n;
//                    m++;
//                }
//            }
//            n = random.nextInt (zeroPo.length);
//            newPopulation[j][zeroPo[n]] = 1;// 增加一个坐标
//            do {
//                m = random.nextInt (zeroPo.length);
//            } while (m == n);// 当m=n时继续循环
//            newPopulation[j][zeroPo[m]] = 1;// 增加一个坐标
//        }
//        sum = 0;
//    }
//
//    // 计算适应度值,坐标必须至少有两个
//    public float evaluate(int[] chromosome){
//
//        float ff;
//        float pai = 3.14F;
//        int triGNum = 0, triCNum = 0, triTNum = 0;
//        // 计算triGNum，triCNum，triTNum
//        int i;
//        for ( i = 0 ; i < cNum ; i++ ) {
//            triCNum += chromosome[i];
//        }
//        for ( ; i < cNum + gNum ; i++ ) {
//            triGNum += chromosome[i];
//        }
//        for ( ; i < choNum ; i++ ) {
//            triTNum += chromosome[i];
//        }
//
//        // float w = 1 / (Wf+Wg+Wc+Wt+WOg+WOc+WOt);//w固定为1，这行忽略
//        // 有3个适应度函数：msr(),lsl(),msl()，先确认msr（）是否正确
//        float ms = lsl (chromosome, triGNum, triCNum, triTNum);
//        float mm = Wf * (ms / (pai + pai));
//        int rc = repeatCodNum (0, chromosome);
//        int rg = repeatCodNum (1, chromosome);
//        int rt = repeatCodNum (2, chromosome);
//
//        // 染色体
//        ff = mm + Wg * (1 - triGNum / gNum) + Wc * (1 - triCNum / cNum) + Wt * (1 - triTNum / tNum) + WOg * (rg / (triGNum * (cc + 1))) + WOc * (rc / (triCNum * (cc + 1))) + WOt
//                * (rt / (triTNum * (cc + 1)));
//        return ff;
//    }
//
//    private int repeatCodNum(int f,int[] chromosome){
//        // 返回在当前聚类中出现，而在已找到的最优聚类中没出现的坐标数
//        int r = 0, i;
//        int[] s = new int[choNum];
//        if (f == 0) {
//            // 重复的condition坐标数
//
//            for ( i = 0 ; i < cNum ; i++ ) {
//                s[i] = 0;
//                for ( int j = 0 ; j < cc ; j++ ) {
//                    s[i] = s[i] + sol[j][i];
//                    if (s[i] > 1) {
//                        s[i] = 1;
//                    }
//                    if (s[i] + chromosome[i] > 1) {
//                        r++;
//                    }
//                }
//            }
//        } else if (f == 1) {
//            // 计算重复的基因坐标数
//
//            for ( i = cNum ; i < cNum + gNum ; i++ ) {
//                s[i] = 0;
//                for ( int j = 0 ; j < cc ; j++ ) {
//                    s[i] = s[i] + sol[j][i];
//                    if (s[i] > 1) {
//                        s[i] = 1;
//                    }
//                    if (s[i] + chromosome[i] > 1) {
//                        r++;
//                    }
//                }
//            }
//
//        } else {
//            // 重复的时间坐标数
//
//            for ( i = cNum + gNum ; i < choNum ; i++ ) {
//                s[i] = 0;
//                for ( int j = 0 ; j < cc ; j++ ) {
//                    s[i] = s[i] + sol[j][i];
//                    if (s[i] > 1) {
//                        s[i] = 1;
//                    }
//                    if (s[i] + chromosome[i] > 1) {
//                        r++;
//                    }
//                }
//            }
//
//        }
//
//        return r;
//    }
//
//    public float msr(int[] chromosome,int g,int c,int t){// g表示当前聚类中的基因数，c表示条件数，t表示时间数
//        float m = 0;
//        // 将染色体分割为3个子染色体，分别代表个C,G,T
//        int[] choC = new int[cNum];// choC表示当前聚类中条件子染色体的编码情况
//        int[] choG = new int[gNum];
//        int[] choT = new int[tNum];
//        for ( int i = 0 ; i < cNum ; i++ ) {
//            choC[i] = chromosome[i];
//        }
//        for ( int i = 0 ; i < gNum ; i++ ) {
//            choG[i] = chromosome[cNum + i];
//        }
//        for ( int i = 0 ; i < tNum ; i++ ) {
//            choT[i] = chromosome[gNum + cNum + i];
//        }
//        int[] cCod = calculateCod (choC, c, cNum);// cCod存储当前聚类中条件的坐标，即编码为1的位置号码
//        int[] gCod = calculateCod (choG, g, gNum);
//        int[] tCod = calculateCod (choT, t, tNum);
//
//        // 计算mGCt
//        float[] mGCt = new float[t];
//        float sGCt;
//        for ( int i = 0 ; i < t ; i++ ) {
//            sGCt = 0;
//            for ( int j = 0 ; j < g ; j++ ) {
//                for ( int k = 0 ; k < c ; k++ ) {
//                    sGCt = sGCt + exData[tCod[i]][gCod[j]][cCod[k]];
//                }
//            }
//            mGCt[i] = sGCt / (g * c);
//        }
//        // 计算mGTc
//        float[] mGTc = new float[c];
//        float sGTc;
//        for ( int i = 0 ; i < c ; i++ ) {
//            sGTc = 0;
//            for ( int j = 0 ; j < g ; j++ ) {
//                for ( int k = 0 ; k < t ; k++ ) {
//                    sGTc = sGTc + exData[tCod[k]][gCod[j]][cCod[i]];
//                }
//            }
//            mGTc[i] = sGTc / (g * t);
//        }
//        // 计算mCTg
//        float[] mCTg = new float[g];
//        float sCTg;
//        for ( int i = 0 ; i < g ; i++ ) {
//            sCTg = 0;
//            for ( int j = 0 ; j < c ; j++ ) {
//                for ( int k = 0 ; k < t ; k++ ) {
//                    sCTg = sCTg + exData[tCod[k]][gCod[i]][cCod[j]];
//                }
//            }
//            mCTg[i] = sCTg / (c * t);
//        }
//        // 计算mGct
//        float[][] mGct = new float[c][t];
//        float sGct;
//        for ( int i = 0 ; i < c ; i++ ) {
//            for ( int j = 0 ; j < t ; j++ ) {
//                sGct = 0;
//                for ( int k = 0 ; k < g ; k++ ) {
//                    sGct = sGct + exData[tCod[j]][gCod[k]][cCod[i]];
//                }
//                mGct[i][j] = sGct / g;
//            }
//        }
//        // 计算mCgt
//        float[][] mCgt = new float[g][t];
//        float sCgt;
//        for ( int i = 0 ; i < g ; i++ ) {
//            for ( int j = 0 ; j < t ; j++ ) {
//                sCgt = 0;
//                for ( int k = 0 ; k < c ; k++ ) {
//                    sCgt = sCgt + exData[tCod[j]][gCod[i]][cCod[k]];
//                }
//                mCgt[i][j] = sCgt / c;
//            }
//        }
//        // 计算mTgc
//        float[][] mTgc = new float[g][c];
//        float sTgc;
//        for ( int i = 0 ; i < g ; i++ ) {
//            for ( int j = 0 ; j < c ; j++ ) {
//                sTgc = 0;
//                for ( int k = 0 ; k < t ; k++ ) {
//                    sTgc = sTgc + exData[tCod[k]][gCod[i]][cCod[j]];
//                }
//                mTgc[i][j] = sTgc / t;
//            }
//        }
//        // 计算mGCT
//        float sGCT = 0;
//        for ( int i = 0 ; i < t ; i++ ) {
//            for ( int j = 0 ; j < g ; j++ ) {
//                for ( int k = 0 ; k < c ; k++ ) {
//                    sGCT = sGCT + exData[tCod[i]][gCod[j]][cCod[k]];
//                }
//            }
//        }
//        float mGCT = sGCT / (c * g * t);
//
//        // 计算Rgct的平方
//        float ssRgct = 0;
//        float rgct;
//        ;
//        for ( int i = 0 ; i < t ; i++ ) {
//            for ( int j = 0 ; j < g ; j++ ) {
//                for ( int k = 0 ; k < c ; k++ ) {
//                    rgct = exData[tCod[i]][gCod[j]][cCod[k]] + mGCt[i] + mGTc[k] + mCTg[j] - mGct[k][i] - mCgt[j][i] - mTgc[j][k] - mGCT;
//                    ssRgct = ssRgct + rgct * rgct;
//                }
//            }
//        }
//        m = ssRgct / (c * g * t);
//        return m;
//    }
//
//    // 计算LSL值
//    public float lsl(int[] chromosome,int g,int c,int t){// g表示当前聚类中的基因数，c表示条件数，t表示时间数
//        float m = 0;
//        // 将染色体分割为3个子染色体，分别代表个C,G,T
//        int[] choC = new int[cNum];// choC表示当前聚类中条件子染色体的编码情况
//        int[] choG = new int[gNum];
//        int[] choT = new int[tNum];
//        for ( int i = 0 ; i < cNum ; i++ ) {
//            choC[i] = chromosome[i];
//        }
//        for ( int i = 0 ; i < gNum ; i++ ) {
//            choG[i] = chromosome[cNum + i];
//        }
//        for ( int i = 0 ; i < tNum ; i++ ) {
//            choT[i] = chromosome[gNum + cNum + i];
//        }
//        int[] cCod = calculateCod (choC, c, cNum);// cCod存储当前聚类中条件的坐标，即编码为1的位置号码
//        int[] gCod = calculateCod (choG, g, gNum);
//        int[] tCod = calculateCod (choT, t, tNum);
//
//        // 计算个体中基因坐标的总和sumXtc
//        float sumXtc = 0;
//        for ( int i = 0 ; i < g ; i++ ) {
//            sumXtc = sumXtc + gCod[i];
//        }
//        // 计算个体中所有基因坐标的平方和sumXXtc
//        float sumXXtc = 0;
//        for ( int i = 0 ; i < g ; i++ ) {
//            sumXXtc = sumXXtc + gCod[i] * gCod[i];
//        }
//        // 计算个体中所有时间坐标的总和sumXg
//        float sumXg = 0;
//        for ( int i = 0 ; i < t ; i++ ) {
//            sumXg = sumXg + tCod[i];
//        }
//        // 计算个体中所有时间坐标的平方和sumXXg
//        float sumXXg = 0;
//        for ( int i = 0 ; i < t ; i++ ) {
//            sumXXg = sumXXg + tCod[i] * tCod[i];
//        }
//
//        // 对每个时间坐标计算TDt（最小二乘逼近）
//        float[] TDt = new float[t];
//        for ( int i = 0 ; i < t ; i++ ) {
//            // sumYt表示当前时间坐标下的所有表达水平之和
//            // sumXYt表示当前时间坐标下的所有表达水平与基因坐标的积之和
//            float sumYt = 0;
//            float sumXYt = 0;
//            for ( int j = 0 ; j < c ; j++ ) {
//                for ( int k = 0 ; k < g ; k++ ) {
//                    sumYt = sumYt + exData[tCod[i]][gCod[k]][cCod[j]];
//                    sumXYt = sumXYt + exData[tCod[i]][gCod[k]][cCod[j]] * k;
//                }
//            }
//            // 计算TDt
//            TDt[i] = (g * sumXYt - (sumXtc * sumYt)) / (g * sumXXtc - sumXtc * sumXtc);
//        }
//        // 计算Tr
//        float Tr = 0;
//        for ( int i = 0 ; i < t - 1 ; i++ ) {
//            for ( int j = i ; j < t ; j++ ) {
//                Tr = Tr + Math.abs (TDt[i] - TDt[j]);
//            }
//        }
//        Tr = Tr / ((t - 1) * t) * 2;
//
//        // 对每个条件坐标计算CDc
//        float[] CDc = new float[c];
//        for ( int i = 0 ; i < c ; i++ ) {
//            // sumYc表示当前条件坐标下的所有表达水平之和
//            // sumXYc表示当前条件坐标下的所有表达水平与基因坐标的积之和
//            float sumYc = 0;
//            float sumXYc = 0;
//            for ( int j = 0 ; j < t ; j++ ) {
//                for ( int k = 0 ; k < g ; k++ ) {
//                    sumYc = sumYc + exData[tCod[j]][gCod[k]][cCod[i]];
//                    sumXYc = sumXYc + exData[tCod[j]][gCod[k]][cCod[i]] * k;
//                }
//            }
//            CDc[i] = (g * sumXYc - (sumXtc * sumYc)) / (g * sumXXtc - sumXtc * sumXtc);
//        }
//        float Cr = 0;
//        for ( int i = 0 ; i < c - 1 ; i++ ) {
//            for ( int j = i ; j < c ; j++ ) {
//                Cr = Cr + Math.abs (CDc[i] - CDc[j]);
//            }
//        }
//        Cr = Cr / ((c - 1) * c) * 2;
//
//        // 对每个条件坐标计算GDc
//        float[] GDc = new float[c];
//        for ( int i = 0 ; i < c ; i++ ) {
//            // sumYg表示当前条件坐标下的所有表达水平之和
//            // sumXYg表示当前条件坐标下的所有表达水平与基因坐标的积之和
//            float sumYg = 0;
//            float sumXYg = 0;
//            for ( int j = 0 ; j < t ; j++ ) {
//                for ( int k = 0 ; k < g ; k++ ) {
//                    sumYg = sumYg + exData[tCod[j]][gCod[k]][cCod[i]];
//                    sumXYg = sumXYg + exData[tCod[j]][gCod[k]][cCod[i]] * j;
//                }
//            }
//            GDc[i] = (t * sumXYg - (sumXg * sumYg)) / (t * sumXXg - sumXg * sumXg);
//        }
//        float Gr = 0;
//        for ( int i = 0 ; i < c - 1 ; i++ ) {
//            for ( int j = i ; j < c ; j++ ) {
//                Gr = Gr + Math.abs (GDc[i] - GDc[j]);
//            }
//        }
//        Gr = Gr / ((c - 1) * c) * 2;
//
//        m = (Tr + Cr + Gr) / 3;
//        return m;
//    }
//
//    // 计算MSL值
//    public float msl(int[] chromosome,int g,int c,int t){
//        float m = 0;
//        // 将染色体分割为3个子染色体，分别代表个C,G,T
//        int[] choC = new int[cNum];
//        int[] choG = new int[gNum];
//        int[] choT = new int[tNum];
//        for ( int i = 0 ; i < cNum ; i++ ) {
//            choC[i] = chromosome[i];
//        }
//        for ( int i = 0 ; i < gNum ; i++ ) {
//            choG[i] = chromosome[cNum + i];
//        }
//        for ( int i = 0 ; i < tNum ; i++ ) {
//            choT[i] = chromosome[gNum + cNum + i];
//        }
//        int[] cCod = calculateCod (choC, c, cNum);
//        int[] gCod = calculateCod (choG, g, gNum);
//        int[] tCod = calculateCod (choT, t, tNum);
//
//        float a1 = angVector (g, c, t, 1, tCod, gCod, cCod, chromosome);
//        float a2 = angVector (g, t, c, 2, tCod, gCod, cCod, chromosome);
//        float a3 = angVector (t, g, c, 3, tCod, gCod, cCod, chromosome);
//        m = (a1 + a2 + a3) / 3;
//        return m;
//    }
//
//    // 计算个体中c,g,t的坐标
//    public int[] calculateCod(int[] chro,int triNum,int n){
//        int[] Cod = new int[triNum];
//        int i = 0;
//        for ( int j = 0 ; j < n ; j++ ) {
//            if (chro[j] == 1) {
//                Cod[i] = j;
//                i++;
//            }
//        }
//        return Cod;
//    }
//
//    // 计算angle vector值
//    public float angVector(int x,int o,int p,int f,int[] tCod,int[] gCod,int[] cCod,int[] chromosome){
//        float ac, v = 0, h = 0;
//        float[][][] sop = new float[p][o][x];
//        float[][][] avArray = new float[p][o][x - 1];// 存储弧度变化值av，每一个元素是一个一维数组，数组长度为x-1
//        // 出现数组长度为负数的异常情况
//
//        sop = calculateSop (f, x, o, p, tCod, gCod, cCod);
//
//        // 计算弧度变化值av
//        for ( int i = 0 ; i < p ; i++ ) {
//            for ( int j = 0 ; j < o ; j++ ) {
//                for ( int k = 0 ; k < x - 1 ; k++ )
//                    avArray[i][j][k] = calculateAlpha (sop[i][j][k], sop[i][j][k + 1]);
//            }
//        }
//        // 计算v和h
//        for ( int i = 0 ; i < p ; i++ ) {
//            for ( int j = 0 ; j < o - 1 ; j++ ) {
//                for ( int k = 0 ; k < o - 1 - j ; k++ ) {
//                    v = v + calculateDetAv (avArray[i][j], avArray[i][j + 1]);
//                }
//            }
//        }
//        for ( int i = 0 ; i < o ; i++ ) {
//            for ( int j = 0 ; j < p - 1 ; j++ ) {
//                for ( int k = 0 ; k < p - 1 - j ; k++ ) {
//                    h = h + calculateDetAv (avArray[j][i], avArray[j + 1][i]);
//                }
//            }
//        }
//
//        float n = (o * p * (o + p - 2)) / 2;
//        ac = (v + h) / n;
//        return ac;
//    }
//
//    // 得到sop三维数组
//    public float[][][] calculateSop(int f,int x,int o,int p,int[] tCod,int[] gCod,int[] cCod){
//        float[][][] sop = new float[p][o][x];
//
//        if (f == 1) {
//            // gct
//            for ( int i = 0 ; i < p ; i++ ) {
//                for ( int j = 0 ; j < o ; j++ ) {
//                    for ( int k = 0 ; k < x ; k++ ) {
//                        sop[i][j][k] = exData[tCod[i]][gCod[k]][cCod[j]];
//                    }
//                }
//
//            }
//
//        } else if (f == 2) {
//            // gtc
//            for ( int i = 0 ; i < p ; i++ ) {
//                for ( int j = 0 ; j < o ; j++ ) {
//                    for ( int k = 0 ; k < x ; k++ ) {
//                        sop[i][j][k] = exData[tCod[j]][gCod[k]][cCod[i]];
//                    }
//                }
//
//            }
//        } else {
//            // tgc
//            for ( int i = 0 ; i < p ; i++ ) {
//                for ( int j = 0 ; j < o ; j++ ) {
//                    for ( int k = 0 ; k < x ; k++ ) {
//                        sop[i][j][k] = exData[tCod[k]][gCod[j]][cCod[i]];
//                    }
//                }
//
//            }
//        }
//        return sop;
//
//    }
//
//    // 计算弧度值alpha
//    public float calculateAlpha(float y1,float y2){
//        float alpha, det;
//        float pai = 3.14f;
//        det = y2 - y1;
//        alpha = (float) Math.atan (det);
//        if (alpha < 0) {
//            alpha = alpha + 2 * pai;
//        }
//        return alpha;
//
//    }
//
//    // 计算detav(avA,avB)
//    public float calculateDetAv(float[] avA,float[] avB){
//        float detAv;
//        float s = 0;
//        for ( int i = 0 ; i < avA.length ; i++ ) {
//            if (avA[i] < avB[i]) {
//                s = s + avB[i] - avA[i];
//            } else {
//                s = s + avA[i] - avB[i];
//            }
//
//        }
//        detAv = s / avA.length;
//        return detAv;
//
//    }
//
//    // 计算种群中各个个体的累积概率，前提是已经计算出各个个体的适应度fitness[max]，作为赌轮选择策略一部分，Pi[max]
//    public void countRate(){
//        int k;
//        float sumFitness = 0;// 适应度总和
//
//        double[] tempf = new double[scale];
//
//        for ( k = 0 ; k < scale ; k++ ) {
//            tempf[k] = 10.0 / fitness[k];
//            sumFitness += tempf[k];
//        }
//
//        Pi[0] = (float) (tempf[0] / sumFitness);
//        for ( k = 1 ; k < scale ; k++ ) {
//            Pi[k] = (float) (tempf[k] / sumFitness + Pi[k - 1]);
//        }
//
//        /*
//         * for(k=0;k<scale;k++) { System.out.println(fitness[k]+" "+Pi[k]); }
//         */
//    }
//
//    // 挑选某代种群中适应度最高的个体，直接复制到子代中
//    // 前提是已经计算出各个个体的适应度Fitness[max]
//    public void selectBestGh(int s){
//        int k, i, maxid;
//        float maxevaluation;
//
//        maxid = 0;
//        maxevaluation = fitness[0];
//        for ( k = 1 ; k < scale ; k++ ) {
//            if (maxevaluation > fitness[k]) {
//                maxevaluation = fitness[k];
//                maxid = k;
//            }
//        }
//        if ((ite == 0 && s == 1) || bestLength > maxevaluation) {
//            bestLength = maxevaluation;
//            bestT = ite;// 最好的染色体出现的代数;
//            for ( i = 0 ; i < choNum ; i++ ) {
//                bestTricluster[i] = oldPopulation[maxid][i];
//            }
//        }
//
//        // System.out.println("代数 " + t + " " + maxevaluation);
//        // 复制染色体，k表示新染色体在种群中的位置，kk表示旧的染色体在种群中的位置
//        copyGh (0, maxid);// 将当代种群中适应度最高的染色体k复制到新种群中，排在第一位0
//    }
//
//    // 复制染色体，k表示新染色体在种群中的位置，kk表示旧的染色体在种群中的位置
//    public void copyGh(int k,int kk){
//        int i;
//        for ( i = 0 ; i < choNum ; i++ ) {
//            newPopulation[k][i] = oldPopulation[kk][i];
//        }
//    }
//
//    // 进化函数，正常交叉变异
//    public void evolution(){
//        int k;
//        // 保存某代种群中适应度最高的个体
//        selectBestGh (1);
//        System.out.print (" 选择");
//        // 赌轮选择策略挑选scale *Ps个下一代个体
//        select ();
//
//        // Random random = new Random(System.currentTimeMillis());
//
//        System.out.print ("--交叉");
//        // 交叉方法
//        // 随机选择scal -#slected=cpNum 个个体作为父本
//        int[][] parents = new int[cpNum][choNum];// 交叉父本池
//        int i;
//        for ( i = 0 ; i < cpNum ; i++ ) {
//            int ran = random.nextInt (65535) % scale;// 从0~（scal-1）中随机选择一个整数
//            parents[i] = oldPopulation[ran];
//        }
//        for ( k = 0 ; k < cpNum ; k = k + 2 ) {
//            // System.out.println(k + "与" + k + 1 + "进行交叉...");
//            if (k + 1 < cpNum) {
//                OXCross (k, k + 1, parents);// 进行交叉
//            } else {
//                newPopulation[sNum + k] = oldPopulation[sNum + k];
//            }
//        }
//
//        // 保存某代种群中适应度最高的个体
//        selectBestGh (0);
//
//        System.out.println ("--变异");
//        // 变异方法
//        for ( i = 0 ; i < scale ; i++ ) {
//            OnCVariation (i);
//        }
//        // 保存某代种群中适应度最高的个体
//        selectBestGh (0);
//    }
//
//    // 赌轮选择策略挑选scale *Ps=sNum个下一代个体
//    public void select(){
//        int k, i, selectId;
//        float ran1;
//
//        // Random random = new Random(System.currentTimeMillis());
//        for ( k = 1 ; k < sNum ; k++ ) {
//            ran1 = (float) (random.nextInt (65535) % 1000 / 1000.0);
//            // System.out.println("概率"+ran1);
//            // 产生方式
//            for ( i = 0 ; i < scale ; i++ ) {
//                if (ran1 <= Pi[i]) {
//                    break;
//                }
//            }
//            selectId = i;
//            // System.out.println("选中" + selectId);
//            copyGh (k, selectId);
//        }
//    }
//
//    // 单点交叉算子,交叉后可能出现全0
//    void OXCross(int k1,int k2,int[][] parents){
//        int i, j;
//        int ran1, ran2, ran3;
//        int[] Gh1 = new int[choNum];
//        int[] Gh2 = new int[choNum];// 子代
//        // Random random = new Random(System.currentTimeMillis());
//
//        ran1 = random.nextInt (65535) % (cNum - 2) + 1;
//        ran2 = random.nextInt (65535) % (gNum - 2) + 1;
//        ran3 = random.nextInt (65535) % (tNum - 2) + 1;// 从1到tNum-2挑选1个整数作为交叉位置
//        int s11 = 0, s21 = 0, s12 = 0, s22 = 0, s13 = 0, s23 = 0;
//        // condition不变部分
//        for ( j = 0 ; j < ran1 ; j++ ) {
//            Gh1[j] = parents[k1][j];
//            Gh2[j] = parents[k2][j];
//            s11 += Gh1[j];
//            s21 += Gh2[j];
//        }
//        // condition交叉部分
//        for ( ; j < cNum ; j++ ) {
//            Gh1[j] = parents[k2][j];
//            Gh2[j] = parents[k1][j];
//            s11 += Gh1[j];
//            s21 += Gh2[j];
//        }
//
//        for ( ; j < cNum + ran2 ; j++ ) {
//            Gh1[j] = parents[k1][j];
//            Gh2[j] = parents[k2][j];
//            s12 += Gh1[j];
//            s22 += Gh2[j];
//        }
//
//        // gene交叉部分
//        for ( ; j < cNum + gNum ; j++ ) {
//            Gh1[j] = parents[k2][j];
//            Gh2[j] = parents[k1][j];
//            s12 += Gh1[j];
//            s22 += Gh2[j];
//        }
//
//        for ( ; j < cNum + gNum + ran3 ; j++ ) {
//            Gh1[j] = parents[k1][j];
//            Gh2[j] = parents[k2][j];
//            s13 += Gh1[j];
//            s23 += Gh2[j];
//        }
//
//        // time交叉部分
//        for ( ; j < choNum ; j++ ) {
//            Gh1[j] = parents[k2][j];
//            Gh2[j] = parents[k1][j];
//            s13 += Gh1[j];
//            s23 += Gh2[j];
//        }
//
//        // 交叉后子代1为全0 或者 只有一个1，新个体不变
//        Gh1 = check (s11, s12, s13, Gh1, k1);
//        Gh2 = check (s21, s22, s23, Gh2, k2);
//
//        for ( i = 0 ; i < choNum ; i++ ) {
//            newPopulation[sNum + k1][i] = Gh1[i];// 交叉完毕放回种群
//            newPopulation[sNum + k2][i] = Gh2[i];// 交叉完毕放回种群
//        }
//    }
//
//    // 交叉后子代1为全0 或者 只有一个1，新个体不变
//    private int[] check(int m1,int m2,int m3,int[] Gh,int k){
//        int i;
//        if (m1 == 0 || m1 == 1) {
//            for ( i = 0 ; i < cNum ; i++ ) {
//                Gh[i] = oldPopulation[sNum + k][i];
//            }
//        }
//        if (m2 == 0 || m2 == 1) {
//            for ( i = cNum ; i < gNum + cNum ; i++ ) {
//                Gh[i] = oldPopulation[sNum + k][i];
//            }
//        }
//        if (m3 == 0 || m3 == 1) {
//            for ( i = cNum + gNum ; i < choNum ; i++ ) {
//                Gh[i] = oldPopulation[sNum + k][i];
//            }
//        }
//        return Gh;
//    }
//
//    // 变异算子
//    public void OnCVariation(int k){
//        // 从9种操作选择一种,k表示第k个个体
//        int i, tag;
//        int g = 0, c = 0, t = 0;
//        float ran = random.nextFloat ();// 0-1之间的一个随机数
//        for ( i = 0 ; i < cNum ; i++ ) {
//            c = c + newPopulation[k][i];
//        }
//        for ( ; i < cNum + gNum ; i++ ) {
//            g = g + newPopulation[k][i];
//        }
//        for ( ; i < choNum ; i++ ) {
//            t = t + newPopulation[k][i];
//        }
//
//        int Mtag = 0;// 是否变异成功，0表示未变异，1表示变异成功
//        ArrayList tagSeq = new ArrayList (9);
//        int[] a = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
//        for ( i = 0 ; i < a.length ; i++ ) {
//            tagSeq.add (a[i]);
//        }
//        // 随机数小于突变率时突变
//
//        if (ran < Pm) {
//            while (Mtag == 0) {
//                int ind = random.nextInt (tagSeq.size ());
//                tag = (int) tagSeq.get (ind);// 0-8间选择一个整数
//
//                switch (tag) {
//                // tag = 0表示增加一个基因坐标
//                    case 0:
//                        Mtag = AddMutation (Mtag, k, cNum - c, 0);
//                        if (Mtag == 0) {
//                            // 删除
//                            for ( i = 0 ; i < tagSeq.size () ; i++ ) {
//                                if ((int) tagSeq.get (i) == tag) {
//                                    tagSeq.remove (i);
//                                    break;
//                                }
//                            }
//                        }
//                        break;
//                    case 1:
//                        Mtag = AddMutation (Mtag, k, gNum - g, 1);
//                        if (Mtag == 0) {
//                            // 删除
//                            for ( i = 0 ; i < tagSeq.size () ; i++ ) {
//                                if ((int) tagSeq.get (i) == tag) {
//                                    tagSeq.remove (i);
//                                    break;
//                                }
//                            }
//                        }
//                        break;
//                    case 2:
//                        Mtag = AddMutation (Mtag, k, tNum - t, 2);
//                        if (Mtag == 0) {
//                            // 删除
//                            for ( i = 0 ; i < tagSeq.size () ; i++ ) {
//                                if ((int) tagSeq.get (i) == tag) {
//                                    tagSeq.remove (i);
//                                    break;
//                                }
//                            }
//                        }
//                        break;
//                    case 3:
//                        Mtag = DelMutation (Mtag, k, c, 0);// 至少要有3个坐标才能删除
//                        if (Mtag == 0) {
//                            // 删除
//                            for ( i = 0 ; i < tagSeq.size () ; i++ ) {
//                                if ((int) tagSeq.get (i) == tag) {
//                                    tagSeq.remove (i);
//                                    break;
//                                }
//                            }
//                        }
//                        break;
//                    case 4:
//                        Mtag = DelMutation (Mtag, k, g, 1);
//                        if (Mtag == 0) {
//                            // 删除
//                            for ( i = 0 ; i < tagSeq.size () ; i++ ) {
//                                if ((int) tagSeq.get (i) == tag) {
//                                    tagSeq.remove (i);
//                                    break;
//                                }
//                            }
//                        }
//                        break;
//                    case 5:
//                        Mtag = DelMutation (Mtag, k, t, 2);
//                        if (Mtag == 0) {
//                            // 删除
//                            for ( i = 0 ; i < tagSeq.size () ; i++ ) {
//                                if ((int) tagSeq.get (i) == tag) {
//                                    tagSeq.remove (i);
//                                    break;
//                                }
//                            }
//                        }
//                        break;
//                    case 6:
//                        Mtag = ChangeMutation (Mtag, k, cNum - c, c, 0);
//                        if (Mtag == 0) {
//                            // 删除
//                            for ( i = 0 ; i < tagSeq.size () ; i++ ) {
//                                if ((int) tagSeq.get (i) == tag) {
//                                    tagSeq.remove (i);
//                                    break;
//                                }
//                            }
//                        }
//                        break;
//                    case 7:
//                        Mtag = ChangeMutation (Mtag, k, gNum - g, g, 1);
//                        if (Mtag == 0) {
//                            // 删除
//                            for ( i = 0 ; i < tagSeq.size () ; i++ ) {
//                                if ((int) tagSeq.get (i) == tag) {
//                                    tagSeq.remove (i);
//                                    break;
//                                }
//                            }
//                        }
//                        break;
//                    case 8:
//                        Mtag = ChangeMutation (Mtag, k, tNum - t, t, 2);
//                        if (Mtag == 0) {
//                            // 删除
//                            for ( i = 0 ; i < tagSeq.size () ; i++ ) {
//                                if ((int) tagSeq.get (i) == tag) {
//                                    tagSeq.remove (i);
//                                    break;
//                                }
//                            }
//                        }
//                        break;
//                }
//            }
//        }
//
//    }
//
//    private int AddMutation(int Mtag,int k,int zeroNum,int tt){
//        // 添加一个坐标，zeroNum表示可添加位置的总数
//        if (zeroNum > 0) {
//            Mtag = 1;
//            int[] zeroPo = new int[zeroNum];// 存放可添加的位置号
//            int i, s;
//            if (tt == 0) {
//                i = 0;
//                s = cNum;
//            } else if (tt == 1) {
//                i = cNum;
//                s = cNum + gNum;
//            } else {
//                i = cNum + gNum;
//                s = choNum;
//            }
//            int j = 0;
//            for ( ; i < s ; i++ ) {
//                if (newPopulation[k][i] == 0) {
//                    zeroPo[j] = i;
//                    j++;
//                }
//            }
//            j = random.nextInt (zeroPo.length);
//            newPopulation[k][zeroPo[j]] = 1;// 增加一个坐标
//        }
//        return Mtag;
//    }
//
//    private int DelMutation(int Mtag,int k,int triNum,int tt){
//        // 至少要有3个坐标才能删除
//        if (triNum > 2) {
//            Mtag = 1;
//            int[] OnePo = new int[triNum];// 存放可删除位置的位置号
//            int i, s;
//            if (tt == 0) {
//                i = 0;
//                s = cNum;
//            } else if (tt == 1) {
//                i = cNum;
//                s = cNum + gNum;
//            } else {
//                i = cNum + gNum;
//                s = choNum;
//            }
//            int j = 0;
//            for ( ; i < s ; i++ ) {
//                if (newPopulation[k][i] == 1) {
//                    OnePo[j] = i;
//                    j++;
//                }
//            }
//            j = random.nextInt (OnePo.length);
//            newPopulation[k][OnePo[j]] = 0;// 删除一个坐标
//        }
//        return Mtag;
//    }
//
//    private int ChangeMutation(int Mtag,int k,int zeroNum,int triNum,int tt){
//        // 将一个坐标变成另一个坐标，即删除一个坐标同时增加一个坐标
//        if (zeroNum > 0 && triNum > 3) {
//            Mtag = 1;
//            int[] zeroPo = new int[zeroNum];// 存放可添加的位置号
//            int[] OnePo = new int[triNum];// 存放可删除位置的位置号
//            int i, s;
//            if (tt == 0) {
//                i = 0;
//                s = cNum;
//            } else if (tt == 1) {
//                i = cNum;
//                s = cNum + gNum;
//            } else {
//                i = cNum + gNum;
//                s = choNum;
//            }
//            int j = 0, jj = 0;
//            for ( ; i < s ; i++ ) {
//                if (newPopulation[k][i] == 0) {
//                    zeroPo[j] = i;
//                    j++;
//                } else {
//                    OnePo[jj] = i;
//                    jj++;
//                }
//
//            }
//            j = random.nextInt (OnePo.length);
//            newPopulation[k][OnePo[j]] = 0;// 删除一个坐标
//            j = random.nextInt (zeroPo.length);
//            newPopulation[k][zeroPo[j]] = 1;// 增加一个坐标
//        }
//        return Mtag;
//    }
//
//    public void solve() throws IOException{
//        int i;
//        int k;
//        int[] occ = new int[choNum];// 存放各个位置号的出现次数，数组下标即为位置号；
//        // float[][] trace = new float[MAX_CLU][MAX_GEN];
//
//        // 读取数据
//
//        init ();
//        PrintWriter out = new PrintWriter ("testresult.txt");
//        PrintWriter priTra = new PrintWriter ("priTra.txt");
//        for ( cc = 0 ; cc < MAX_CLU ; cc++ ) {
//            System.out.println ("第" + cc + "个聚类 ： ");
//            // 初始化种群
//            System.out.println ("初始化种群...");
//            initGroup ();
//            // 计算初始化种群适应度，Fitness[max]
//            for ( k = 0 ; k < scale ; k++ ) {
//                fitness[k] = evaluate (oldPopulation[k]);
//                System.out.print (fitness[k] + "--");
//            }
//            System.out.print ('\n');
//            // 计算初始化种群中各个个体的累积概率，Pi[max]
//            countRate ();
//            System.out.println ("进化中 ： ");
//            for ( ite = 0 ; ite < MAX_GEN ; ite++ ) {
//                System.out.print ("第" + ite + "代 : ");
//
//                evolution ();
//
//                // 跟踪算法性能
//                // trace[cc][ite] = bestLength;
//                priTra.print (bestLength + ";");
//                // 将新种群newGroup复制到旧种群oldGroup中，准备下一代进化
//                for ( k = 0 ; k < scale ; k++ ) {
//                    for ( i = 0 ; i < choNum ; i++ ) {
//                        oldPopulation[k][i] = newPopulation[k][i];
//                    }
//                }
//                // 计算种群适应度
//                for ( k = 0 ; k < scale ; k++ ) {
//                    fitness[k] = evaluate (oldPopulation[k]);
//                    System.out.print (fitness[k] + "--");
//                }
//                System.out.print ('\n');
//                // 计算种群中各个个体的累积概率
//                countRate ();
//            }
//
//            // System.out.println("最后种群...");
//            // for (k = 0; k < scale; k++) {
//            // for (i = 0; i < choNum; i++) {
//            // System.out.print(oldPopulation[k][i] + ",");
//            // }
//            // System.out.println();
//            // System.out.println("---" + fitness[k] + " " + Pi[k]);
//            // }
//
//            int triGNum = 0, triCNum = 0, triTNum = 0;
//            for ( i = 0 ; i < cNum ; i++ ) {
//                triCNum += bestTricluster[i];
//            }
//            for ( ; i < cNum + gNum ; i++ ) {
//                triGNum += bestTricluster[i];
//            }
//            for ( ; i < choNum ; i++ ) {
//                triTNum += bestTricluster[i];
//            }
//            // 子染色体
//            int[] choC = new int[cNum];
//            int[] choG = new int[gNum];
//            int[] choT = new int[tNum];
//            for ( i = 0 ; i < cNum ; i++ ) {
//                choC[i] = bestTricluster[i];
//            }
//            for ( i = 0 ; i < gNum ; i++ ) {
//                choG[i] = bestTricluster[cNum + i];
//            }
//            for ( i = 0 ; i < tNum ; i++ ) {
//                choT[i] = bestTricluster[gNum + cNum + i];
//            }
//            // 子染色体坐标
//            int[] cCod = calculateCod (choC, triCNum, cNum);
//            int[] gCod = calculateCod (choG, triGNum, gNum);
//            int[] tCod = calculateCod (choT, triTNum, tNum);
//
//            System.out.print ("最佳长度出现代数 ：");
//            System.out.println (bestT);
//            System.out.print ("最佳长度 :");
//            System.out.println (bestLength);
//            System.out.println ("最佳三维聚类 ：");
//
//            System.out.print (triGNum + " : ");
//            for ( i = 0 ; i < triGNum ; i++ ) {
//                System.out.print (gCod[i] + ",");
//                out.print (gCod[i] + ";");
//            }
//            out.print ("\n");
//            System.out.print ('\n');
//
//            System.out.print (triCNum + " : ");
//            for ( i = 0 ; i < triCNum ; i++ ) {
//                System.out.print (cCod[i] + ",");
//                out.print (cCod[i] + ";");
//            }
//            out.print ("\n");
//            System.out.println ();
//
//            System.out.print (triTNum + " : ");
//            for ( i = 0 ; i < triTNum ; i++ ) {
//                System.out.print (tCod[i] + ",");
//                out.print (tCod[i] + ";");
//            }
//            out.print ("\n");
//            // priTra.print("\n");
//            System.out.print ('\n');
//
//            for ( i = 0 ; i < choNum ; i++ ) {
//                sol[cc][i] = bestTricluster[i];
//                if (bestTricluster[i] == 1) {
//                    occ[i]++;// 更新occ
//                }
//            }
//
//            if (cc < MAX_CLU) {
//                // 对occ进行排序，按照坐标出现次数从小到大的顺序，将对应的位置号依次放到lev数组中
//                sort (0, cNum, occ); // condition,直接选择排序
//                quicksort (cNum, cNum + gNum, occ);// gene，快速排序
//                sort (cNum + gNum, choNum, occ);// time，直接选择排序
//            }
//            out.println (";;");
//
//        }
//
//        out.close ();
//        priTra.close ();
//    }
//
//    // 直接选择排序
//    private void sort(int in,int num,int[] occ){
//
//        int i, j, k, tem;
//        for ( i = in ; i < num - 1 ; i++ ) {
//            k = i; // 预置i为最小值的下标，记在k中
//            for ( j = i + 1 ; j < num ; j++ ) {
//                if (occ[j] < occ[k]) {
//                    k = j;// 若j位的值更小，更新k为j
//                }
//            }
//            // 将最小值(k位)和该趟比较的首位进行交换
//            if (k != i) {
//                tem = occ[i];
//                occ[i] = occ[k];
//                occ[k] = tem;
//            }
//            lev[i] = k;
//        }
//        // 最后一位
//        int s = 0, se = 0;
//        for ( i = in ; i < num ; i++ ) {
//            s = s + i;
//            se = se + lev[i];
//        }
//        lev[num - 1] = s - se;
//
//    }
//
//    // 快速排序
//    public void quicksort(int in,int num,int[] occ){
//        int i;
//        if (in < num) {
//            i = divideareasort (in, num, occ);// 分割区间,并把基准位置送i
//            quicksort (in, i - 1, occ);// 对基准记录前的区间快速排序
//            quicksort (i + 1, num, occ);// 对基准记录后的区间快速排序
//        }
//    }
//
//    // 一次分割排序
//    public int divideareasort(int in,int num,int[] occ){
//        int i, j, t;
//        i = in;// 区间指示器变量初始化
//        j = num;
//        t = occ[in];// 确定分割基准，通常选第一个
//        do {
//            while ((occ[j] >= t) && (i < j)) {
//                j--;// 自后向前扫描找小于基准关键字的记录
//            }
//            if (i < j) {
//                occ[i] = occ[j];
//                i++;
//            }
//            while ((occ[i] <= t) && (i < j)) {
//                i++;// 自前向后扫描找大于基准关键字的记录
//            }
//            if (i < j) {
//                occ[j] = occ[i];
//                j--;
//            }
//        } while (i < j);
//
//        occ[i] = t;
//
//        return i;
//    }
//
//    public void outputValue(){
//        for ( int ii = 0 ; ii < 1 ; ii++ ) {
//
//            // 目标聚类
//
//            // 将染色体分割为3个子染色体，分别代表个C,G,T
//            int[] choC = new int[cNum];
//            int[] choG = new int[gNum];
//            int[] choT = new int[tNum];
//            for ( int i = 0 ; i < cNum ; i++ ) {
//                choC[i] = sol[ii][i];
//            }
//            for ( int i = 0 ; i < gNum ; i++ ) {
//                choG[i] = sol[ii][cNum + i];
//            }
//            for ( int i = 0 ; i < tNum ; i++ ) {
//                choT[i] = sol[ii][gNum + cNum + i];
//            }
//            // 计算triGNum，triCNum，triTNum
//            int triGNum = 0, triCNum = 0, triTNum = 0;
//            int i;
//            for ( i = 0 ; i < cNum ; i++ ) {
//                triCNum += sol[ii][i];
//            }
//            for ( ; i < cNum + gNum ; i++ ) {
//                triGNum += sol[ii][i];
//            }
//            for ( ; i < choNum ; i++ ) {
//                triTNum += sol[ii][i];
//            }
//            int[] C = calculateCod (choC, triCNum, cNum);
//            int[] G = calculateCod (choG, triGNum, gNum);
//            int[] T = calculateCod (choT, triTNum, tNum);
//
//            // 从exData中取出目标聚类的表达水平值
//            float[][] tex = new float[triCNum * triGNum][triTNum];
//            for ( i = 0 ; i < T.length ; i++ ) {
//                for ( int j = 0 ; j < C.length ; j++ ) {
//                    for ( int k = 0 ; k < G.length ; k++ ) {
//                        tex[j * k][i] = exData[T[i]][G[k]][C[j]];
//                    }
//                }
//
//            }
//            try {
//
//                PrintWriter out = new PrintWriter ("level.txt");
//
//                for ( int j = 0 ; j < triCNum * triGNum ; j++ ) {
//                    for ( i = 0 ; i < T.length ; i++ ) {
//                        out.print (tex[j][i] + ";"); // 添加一个数据,随后 加上 一个分号
//
//                    }
//                    out.print ("\n");// 换行
//                }
//                out.close ();
//            } catch (IOException e) {
//
//            }
//        }
//    }
//
//    /**
//     * @param args
//     * @throws IOException
//     */
//    public static void main(String[] args) throws IOException{
//        // TODO 自动生成的方法存根
//        int gNum = 4000;
//        int cNum = 30;
//        int tNum = 20;
//
//        // input parameters
//        int N = 10, G = 50, I = 100;
//        float Ale = 0.9f, Sel = 0.4f, Mut = 0.9f, Wf = 0.8f;
//        float Wg = 0.07f, Wc = 0.0f, Wt = 0.03f;
//        float WOg = 0.025f, WOc = 0.025f, WOt = 0.05f;
//        // 主体
//        long startMili = System.currentTimeMillis ();// 当前时间对应的毫秒数
//
//        GA ga = new GA (N,I,gNum,tNum,cNum,G,Wf,Ale,Mut,Sel,Wf,Wg,Wc,Wt,WOg,WOc,WOt);
//        ga.solve ();
//        long endMili = System.currentTimeMillis ();
//        System.out.println ("总耗时为：" + (endMili - startMili) + "毫秒");
//    }
//
//}
