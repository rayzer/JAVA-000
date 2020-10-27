
````
λ java -version
openjdk version "1.8.0_272"
OpenJDK Runtime Environment (AdoptOpenJDK)(build 1.8.0_272-b10)
OpenJDK 64-Bit Server VM (AdoptOpenJDK)(build 25.272-b10, mixed mode)
````

### 测试案例一 GCLogAnalysis

* Serial GC
```
java -XX:+UseSerialGC -Xmx512m -Xms512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
2020-10-27T17:50:02.375-0800: [GC (Allocation Failure) 2020-10-27T17:50:02.375-0800: [DefNew: 139776K->17472K(157248K), 0.0305140 secs] 139776K->46504K(506816K), 0.0305554 secs] [Times: user=0.01 sys=0.02, real=0.03 secs] 
2020-10-27T17:50:02.432-0800: [GC (Allocation Failure) 2020-10-27T17:50:02.432-0800: [DefNew: 157248K->17468K(157248K), 0.0366103 secs] 186280K->85022K(506816K), 0.0366487 secs] [Times: user=0.02 sys=0.01, real=0.03 secs] 
2020-10-27T17:50:02.492-0800: [GC (Allocation Failure) 2020-10-27T17:50:02.492-0800: [DefNew: 157182K->17470K(157248K), 0.0293253 secs] 224737K->124696K(506816K), 0.0293631 secs] [Times: user=0.02 sys=0.01, real=0.03 secs] 
2020-10-27T17:50:02.542-0800: [GC (Allocation Failure) 2020-10-27T17:50:02.543-0800: [DefNew: 157246K->17471K(157248K), 0.0331530 secs] 264472K->171112K(506816K), 0.0331925 secs] [Times: user=0.02 sys=0.01, real=0.03 secs] 
2020-10-27T17:50:02.597-0800: [GC (Allocation Failure) 2020-10-27T17:50:02.597-0800: [DefNew: 157247K->17468K(157248K), 0.0284801 secs] 310888K->210290K(506816K), 0.0285205 secs] [Times: user=0.02 sys=0.01, real=0.03 secs] 
2020-10-27T17:50:02.650-0800: [GC (Allocation Failure) 2020-10-27T17:50:02.650-0800: [DefNew: 157244K->17470K(157248K), 0.0299118 secs] 350066K->252912K(506816K), 0.0299557 secs] [Times: user=0.02 sys=0.02, real=0.03 secs] 
2020-10-27T17:50:02.699-0800: [GC (Allocation Failure) 2020-10-27T17:50:02.699-0800: [DefNew: 157246K->17472K(157248K), 0.0323574 secs] 392688K->297737K(506816K), 0.0323953 secs] [Times: user=0.02 sys=0.01, real=0.04 secs] 
2020-10-27T17:50:02.753-0800: [GC (Allocation Failure) 2020-10-27T17:50:02.753-0800: [DefNew: 157245K->17469K(157248K), 0.0284635 secs] 437511K->338687K(506816K), 0.0285097 secs] [Times: user=0.01 sys=0.01, real=0.03 secs] 
2020-10-27T17:50:02.799-0800: [GC (Allocation Failure) 2020-10-27T17:50:02.799-0800: [DefNew: 157245K->157245K(157248K), 0.0000163 secs]2020-10-27T17:50:02.799-0800: [Tenured: 321217K->267559K(349568K), 0.0534962 secs] 478463K->267559K(506816K), [Metaspace: 2889K->2889K(1056768K)], 0.0535628 secs] [Times: user=0.05 sys=0.00, real=0.06 secs] 
2020-10-27T17:50:02.870-0800: [GC (Allocation Failure) 2020-10-27T17:50:02.870-0800: [DefNew: 139776K->17471K(157248K), 0.0066441 secs] 407335K->313210K(506816K), 0.0066800 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2020-10-27T17:50:02.895-0800: [GC (Allocation Failure) 2020-10-27T17:50:02.895-0800: [DefNew: 157247K->17471K(157248K), 0.0274458 secs] 452986K->363021K(506816K), 0.0275128 secs] [Times: user=0.01 sys=0.01, real=0.03 secs] 
2020-10-27T17:50:02.945-0800: [GC (Allocation Failure) 2020-10-27T17:50:02.945-0800: [DefNew: 157247K->157247K(157248K), 0.0000161 secs]2020-10-27T17:50:02.945-0800: [Tenured: 345549K->316440K(349568K), 0.0521273 secs] 502797K->316440K(506816K), [Metaspace: 2889K->2889K(1056768K)], 0.0522112 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
2020-10-27T17:50:03.017-0800: [GC (Allocation Failure) 2020-10-27T17:50:03.017-0800: [DefNew: 139776K->139776K(157248K), 0.0000202 secs]2020-10-27T17:50:03.017-0800: [Tenured: 316440K->325907K(349568K), 0.0471482 secs] 456216K->325907K(506816K), [Metaspace: 2889K->2889K(1056768K)], 0.0472198 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
2020-10-27T17:50:03.085-0800: [GC (Allocation Failure) 2020-10-27T17:50:03.085-0800: [DefNew: 139776K->139776K(157248K), 0.0000164 secs]2020-10-27T17:50:03.085-0800: [Tenured: 325907K->323728K(349568K), 0.0527531 secs] 465683K->323728K(506816K), [Metaspace: 2889K->2889K(1056768K)], 0.0528374 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
2020-10-27T17:50:03.158-0800: [GC (Allocation Failure) 2020-10-27T17:50:03.158-0800: [DefNew: 139560K->139560K(157248K), 0.0000152 secs]2020-10-27T17:50:03.158-0800: [Tenured: 323728K->340935K(349568K), 0.0337621 secs] 463289K->340935K(506816K), [Metaspace: 2889K->2889K(1056768K)], 0.0338310 secs] [Times: user=0.03 sys=0.00, real=0.04 secs] 
2020-10-27T17:50:03.213-0800: [GC (Allocation Failure) 2020-10-27T17:50:03.213-0800: [DefNew: 139776K->139776K(157248K), 0.0000187 secs]2020-10-27T17:50:03.213-0800: [Tenured: 340935K->343428K(349568K), 0.0418385 secs] 480711K->343428K(506816K), [Metaspace: 2889K->2889K(1056768K)], 0.0419075 secs] [Times: user=0.04 sys=0.00, real=0.04 secs] 
2020-10-27T17:50:03.270-0800: [GC (Allocation Failure) 2020-10-27T17:50:03.270-0800: [DefNew: 139776K->139776K(157248K), 0.0000170 secs]2020-10-27T17:50:03.270-0800: [Tenured: 343428K->349480K(349568K), 0.0542108 secs] 483204K->358451K(506816K), [Metaspace: 2889K->2889K(1056768K)], 0.0542736 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
执行结束!共生成对象次数:9028
Heap
 def new generation   total 157248K, used 14812K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)
  eden space 139776K,  10% used [0x00000007a0000000, 0x00000007a0e772a0, 0x00000007a8880000)
  from space 17472K,   0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)
  to   space 17472K,   0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)
 tenured generation   total 349568K, used 349480K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)
   the space 349568K,  99% used [0x00000007aaaa0000, 0x00000007bffea270, 0x00000007bffea400, 0x00000007c0000000)
 Metaspace       used 2896K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 310K, capacity 386K, committed 512K, reserved 1048576K


java -XX:+UseSerialGC -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
2020-10-27T17:50:41.555-0800: [GC (Allocation Failure) 2020-10-27T17:50:41.555-0800: [DefNew: 279616K->34944K(314560K), 0.0483221 secs] 279616K->80850K(1013632K), 0.0483612 secs] [Times: user=0.03 sys=0.02, real=0.05 secs] 
2020-10-27T17:50:41.655-0800: [GC (Allocation Failure) 2020-10-27T17:50:41.655-0800: [DefNew: 314560K->34943K(314560K), 0.0656740 secs] 360466K->156473K(1013632K), 0.0657105 secs] [Times: user=0.04 sys=0.03, real=0.07 secs] 
2020-10-27T17:50:41.762-0800: [GC (Allocation Failure) 2020-10-27T17:50:41.762-0800: [DefNew: 314559K->34942K(314560K), 0.0499099 secs] 436089K->230674K(1013632K), 0.0499440 secs] [Times: user=0.02 sys=0.02, real=0.05 secs] 
2020-10-27T17:50:41.846-0800: [GC (Allocation Failure) 2020-10-27T17:50:41.846-0800: [DefNew: 314558K->34943K(314560K), 0.1183296 secs] 510290K->309786K(1013632K), 0.1183843 secs] [Times: user=0.03 sys=0.02, real=0.12 secs] 
2020-10-27T17:50:42.019-0800: [GC (Allocation Failure) 2020-10-27T17:50:42.019-0800: [DefNew: 314559K->34943K(314560K), 0.0764754 secs] 589402K->393586K(1013632K), 0.0765319 secs] [Times: user=0.04 sys=0.03, real=0.08 secs] 
2020-10-27T17:50:42.136-0800: [GC (Allocation Failure) 2020-10-27T17:50:42.136-0800: [DefNew: 314559K->34943K(314560K), 0.0805732 secs] 673202K->477168K(1013632K), 0.0806090 secs] [Times: user=0.03 sys=0.03, real=0.08 secs] 
2020-10-27T17:50:42.257-0800: [GC (Allocation Failure) 2020-10-27T17:50:42.257-0800: [DefNew: 314559K->34943K(314560K), 0.0674899 secs] 756784K->555843K(1013632K), 0.0675495 secs] [Times: user=0.04 sys=0.03, real=0.07 secs] 
2020-10-27T17:50:42.365-0800: [GC (Allocation Failure) 2020-10-27T17:50:42.365-0800: [DefNew: 314559K->34944K(314560K), 0.0600907 secs] 835459K->634228K(1013632K), 0.0601575 secs] [Times: user=0.03 sys=0.03, real=0.06 secs] 
执行结束!共生成对象次数:8292
Heap
 def new generation   total 314560K, used 46142K [0x0000000780000000, 0x0000000795550000, 0x0000000795550000)
  eden space 279616K,   4% used [0x0000000780000000, 0x0000000780aefa48, 0x0000000791110000)
  from space 34944K, 100% used [0x0000000791110000, 0x0000000793330000, 0x0000000793330000)
  to   space 34944K,   0% used [0x0000000793330000, 0x0000000793330000, 0x0000000795550000)
 tenured generation   total 699072K, used 599284K [0x0000000795550000, 0x00000007c0000000, 0x00000007c0000000)
   the space 699072K,  85% used [0x0000000795550000, 0x00000007b9e8d080, 0x00000007b9e8d200, 0x00000007c0000000)
 Metaspace       used 2895K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 310K, capacity 386K, committed 512K, reserved 1048576K


java -XX:+UseSerialGC -Xmx4g -Xms4g -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
2020-10-27T17:51:21.812-0800: [GC (Allocation Failure) 2020-10-27T17:51:21.812-0800: [DefNew: 1118528K->139776K(1258304K), 0.2219027 secs] 1118528K->247663K(4054528K), 0.2219574 secs] [Times: user=0.10 sys=0.08, real=0.22 secs] 
执行结束!共生成对象次数:7839
Heap
 def new generation   total 1258304K, used 1152765K [0x00000006c0000000, 0x0000000715550000, 0x0000000715550000)
  eden space 1118528K,  90% used [0x00000006c0000000, 0x00000006fdd3f738, 0x0000000704450000)
  from space 139776K, 100% used [0x000000070ccd0000, 0x0000000715550000, 0x0000000715550000)
  to   space 139776K,   0% used [0x0000000704450000, 0x0000000704450000, 0x000000070ccd0000)
 tenured generation   total 2796224K, used 107887K [0x0000000715550000, 0x00000007c0000000, 0x00000007c0000000)
   the space 2796224K,   3% used [0x0000000715550000, 0x000000071beabff0, 0x000000071beac000, 0x00000007c0000000)
 Metaspace       used 2895K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 310K, capacity 386K, committed 512K, reserved 1048576K
```

* Parallel GC
```
java -Xmx512m -Xms512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
2020-10-27T17:52:09.888-0800: [GC (Allocation Failure) [PSYoungGen: 131584K->21485K(153088K)] 131584K->45472K(502784K), 0.0198927 secs] [Times: user=0.02 sys=0.09, real=0.02 secs] 
2020-10-27T17:52:09.929-0800: [GC (Allocation Failure) [PSYoungGen: 153069K->21486K(153088K)] 177056K->85104K(502784K), 0.0240780 secs] [Times: user=0.03 sys=0.09, real=0.03 secs] 
2020-10-27T17:52:09.973-0800: [GC (Allocation Failure) [PSYoungGen: 153070K->21501K(153088K)] 216688K->130022K(502784K), 0.0220545 secs] [Times: user=0.03 sys=0.08, real=0.02 secs] 
2020-10-27T17:52:10.017-0800: [GC (Allocation Failure) [PSYoungGen: 152827K->21493K(153088K)] 261348K->167119K(502784K), 0.0176430 secs] [Times: user=0.04 sys=0.05, real=0.02 secs] 
2020-10-27T17:52:10.055-0800: [GC (Allocation Failure) [PSYoungGen: 153077K->21501K(153088K)] 298703K->205329K(502784K), 0.0204248 secs] [Times: user=0.03 sys=0.07, real=0.02 secs] 
2020-10-27T17:52:10.095-0800: [GC (Allocation Failure) [PSYoungGen: 153085K->21495K(80384K)] 336913K->248689K(430080K), 0.0208752 secs] [Times: user=0.04 sys=0.06, real=0.02 secs] 
2020-10-27T17:52:10.126-0800: [GC (Allocation Failure) [PSYoungGen: 80375K->34744K(116736K)] 307569K->268233K(466432K), 0.0061229 secs] [Times: user=0.02 sys=0.01, real=0.01 secs] 
2020-10-27T17:52:10.141-0800: [GC (Allocation Failure) [PSYoungGen: 92984K->56004K(116736K)] 326473K->293210K(466432K), 0.0081634 secs] [Times: user=0.03 sys=0.01, real=0.01 secs] 
2020-10-27T17:52:10.159-0800: [GC (Allocation Failure) [PSYoungGen: 114884K->57838K(116736K)] 352090K->311420K(466432K), 0.0153350 secs] [Times: user=0.05 sys=0.02, real=0.02 secs] 
2020-10-27T17:52:10.185-0800: [GC (Allocation Failure) [PSYoungGen: 116718K->39598K(116736K)] 370300K->331359K(466432K), 0.0192391 secs] [Times: user=0.03 sys=0.06, real=0.02 secs] 
2020-10-27T17:52:10.204-0800: [Full GC (Ergonomics) [PSYoungGen: 39598K->0K(116736K)] [ParOldGen: 291761K->238288K(349696K)] 331359K->238288K(466432K), [Metaspace: 2889K->2889K(1056768K)], 0.0393716 secs] [Times: user=0.15 sys=0.01, real=0.04 secs] 
2020-10-27T17:52:10.255-0800: [GC (Allocation Failure) [PSYoungGen: 58880K->21438K(116736K)] 297168K->259726K(466432K), 0.0049425 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 
2020-10-27T17:52:10.274-0800: [GC (Allocation Failure) [PSYoungGen: 80316K->21727K(116736K)] 318605K->281102K(466432K), 0.0060031 secs] [Times: user=0.04 sys=0.00, real=0.01 secs] 
2020-10-27T17:52:10.293-0800: [GC (Allocation Failure) [PSYoungGen: 80607K->18151K(116736K)] 339982K->296797K(466432K), 0.0062392 secs] [Times: user=0.04 sys=0.00, real=0.00 secs] 
2020-10-27T17:52:10.312-0800: [GC (Allocation Failure) [PSYoungGen: 76971K->20594K(116736K)] 355616K->316140K(466432K), 0.0073348 secs] [Times: user=0.02 sys=0.01, real=0.01 secs] 
2020-10-27T17:52:10.332-0800: [GC (Allocation Failure) [PSYoungGen: 79474K->19208K(116736K)] 375020K->333461K(466432K), 0.0111120 secs] [Times: user=0.02 sys=0.04, real=0.01 secs] 
2020-10-27T17:52:10.343-0800: [Full GC (Ergonomics) [PSYoungGen: 19208K->0K(116736K)] [ParOldGen: 314252K->268972K(349696K)] 333461K->268972K(466432K), [Metaspace: 2889K->2889K(1056768K)], 0.0346514 secs] [Times: user=0.17 sys=0.01, real=0.03 secs] 
2020-10-27T17:52:10.391-0800: [GC (Allocation Failure) [PSYoungGen: 58880K->23562K(116736K)] 327852K->292535K(466432K), 0.0040994 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2020-10-27T17:52:10.410-0800: [GC (Allocation Failure) [PSYoungGen: 82442K->24597K(116736K)] 351415K->314826K(466432K), 0.0063005 secs] [Times: user=0.04 sys=0.00, real=0.00 secs] 
2020-10-27T17:52:10.429-0800: [GC (Allocation Failure) [PSYoungGen: 83477K->23134K(116736K)] 373706K->336676K(466432K), 0.0058732 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 
2020-10-27T17:52:10.435-0800: [Full GC (Ergonomics) [PSYoungGen: 23134K->0K(116736K)] [ParOldGen: 313542K->287043K(349696K)] 336676K->287043K(466432K), [Metaspace: 2889K->2889K(1056768K)], 0.0382467 secs] [Times: user=0.21 sys=0.00, real=0.04 secs] 
2020-10-27T17:52:10.488-0800: [GC (Allocation Failure) [PSYoungGen: 58710K->21821K(116736K)] 345753K->308865K(466432K), 0.0033768 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 
2020-10-27T17:52:10.505-0800: [GC (Allocation Failure) [PSYoungGen: 80701K->23177K(116736K)] 367745K->330655K(466432K), 0.0053748 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 
2020-10-27T17:52:10.520-0800: [GC (Allocation Failure) [PSYoungGen: 82057K->20806K(116736K)] 389535K->349578K(466432K), 0.0104443 secs] [Times: user=0.03 sys=0.04, real=0.01 secs] 
2020-10-27T17:52:10.531-0800: [Full GC (Ergonomics) [PSYoungGen: 20806K->0K(116736K)] [ParOldGen: 328771K->307400K(349696K)] 349578K->307400K(466432K), [Metaspace: 2889K->2889K(1056768K)], 0.0389404 secs] [Times: user=0.22 sys=0.00, real=0.04 secs] 
2020-10-27T17:52:10.583-0800: [GC (Allocation Failure) [PSYoungGen: 58880K->16521K(116736K)] 366280K->323921K(466432K), 0.0058001 secs] [Times: user=0.02 sys=0.00, real=0.00 secs] 
2020-10-27T17:52:10.602-0800: [GC (Allocation Failure) [PSYoungGen: 75401K->23159K(116736K)] 382801K->345436K(466432K), 0.0059506 secs] [Times: user=0.04 sys=0.00, real=0.00 secs] 
2020-10-27T17:52:10.608-0800: [Full GC (Ergonomics) [PSYoungGen: 23159K->0K(116736K)] [ParOldGen: 322277K->313885K(349696K)] 345436K->313885K(466432K), [Metaspace: 2889K->2889K(1056768K)], 0.0393132 secs] [Times: user=0.20 sys=0.00, real=0.04 secs] 
2020-10-27T17:52:10.660-0800: [GC (Allocation Failure) [PSYoungGen: 58839K->21237K(116736K)] 372724K->335123K(466432K), 0.0042978 secs] [Times: user=0.01 sys=0.01, real=0.00 secs] 
2020-10-27T17:52:10.675-0800: [GC (Allocation Failure) [PSYoungGen: 80117K->20284K(116736K)] 394003K->353628K(466432K), 0.0067281 secs] [Times: user=0.03 sys=0.01, real=0.01 secs] 
2020-10-27T17:52:10.682-0800: [Full GC (Ergonomics) [PSYoungGen: 20284K->0K(116736K)] [ParOldGen: 333343K->317748K(349696K)] 353628K->317748K(466432K), [Metaspace: 2889K->2889K(1056768K)], 0.0387379 secs] [Times: user=0.23 sys=0.00, real=0.04 secs] 
2020-10-27T17:52:10.735-0800: [Full GC (Ergonomics) [PSYoungGen: 58823K->0K(116736K)] [ParOldGen: 317748K->325418K(349696K)] 376572K->325418K(466432K), [Metaspace: 2889K->2889K(1056768K)], 0.0420301 secs] [Times: user=0.25 sys=0.00, real=0.04 secs] 
2020-10-27T17:52:10.794-0800: [Full GC (Ergonomics) [PSYoungGen: 58880K->0K(116736K)] [ParOldGen: 325418K->330810K(349696K)] 384298K->330810K(466432K), [Metaspace: 2889K->2889K(1056768K)], 0.0421613 secs] [Times: user=0.22 sys=0.01, real=0.04 secs] 
执行结束!共生成对象次数:7564
Heap
 PSYoungGen      total 116736K, used 2775K [0x00000007b5580000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 58880K, 4% used [0x00000007b5580000,0x00000007b5835ed0,0x00000007b8f00000)
  from space 57856K, 0% used [0x00000007b8f00000,0x00000007b8f00000,0x00000007bc780000)
  to   space 57856K, 0% used [0x00000007bc780000,0x00000007bc780000,0x00000007c0000000)
 ParOldGen       total 349696K, used 330810K [0x00000007a0000000, 0x00000007b5580000, 0x00000007b5580000)
  object space 349696K, 94% used [0x00000007a0000000,0x00000007b430e968,0x00000007b5580000)
 Metaspace       used 2896K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 310K, capacity 386K, committed 512K, reserved 1048576K

java -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
2020-10-27T17:53:51.157-0800: [GC (Allocation Failure) [PSYoungGen: 262144K->43519K(305664K)] 262144K->78986K(1005056K), 0.0328159 secs] [Times: user=0.04 sys=0.15, real=0.04 secs] 
2020-10-27T17:53:51.243-0800: [GC (Allocation Failure) [PSYoungGen: 305663K->43516K(305664K)] 341130K->158039K(1005056K), 0.0495915 secs] [Times: user=0.05 sys=0.20, real=0.05 secs] 
2020-10-27T17:53:51.329-0800: [GC (Allocation Failure) [PSYoungGen: 305660K->43519K(305664K)] 420183K->237382K(1005056K), 0.0391283 secs] [Times: user=0.05 sys=0.06, real=0.04 secs] 
2020-10-27T17:53:51.410-0800: [GC (Allocation Failure) [PSYoungGen: 305056K->43519K(305664K)] 498920K->313966K(1005056K), 0.0369085 secs] [Times: user=0.07 sys=0.16, real=0.03 secs] 
2020-10-27T17:53:51.480-0800: [GC (Allocation Failure) [PSYoungGen: 305663K->43515K(305664K)] 576110K->395070K(1005056K), 0.0387789 secs] [Times: user=0.07 sys=0.12, real=0.03 secs] 
2020-10-27T17:53:51.563-0800: [GC (Allocation Failure) [PSYoungGen: 305659K->43501K(160256K)] 657214K->470541K(859648K), 0.0377760 secs] [Times: user=0.05 sys=0.16, real=0.04 secs] 
2020-10-27T17:53:51.616-0800: [GC (Allocation Failure) [PSYoungGen: 160237K->69801K(232960K)] 587277K->505666K(932352K), 0.0109895 secs] [Times: user=0.04 sys=0.01, real=0.01 secs] 
2020-10-27T17:53:51.642-0800: [GC (Allocation Failure) [PSYoungGen: 186537K->91914K(232960K)] 622402K->536279K(932352K), 0.0130133 secs] [Times: user=0.06 sys=0.02, real=0.01 secs] 
2020-10-27T17:53:51.674-0800: [GC (Allocation Failure) [PSYoungGen: 208650K->100309K(232960K)] 653015K->562396K(932352K), 0.0271624 secs] [Times: user=0.06 sys=0.01, real=0.03 secs] 
2020-10-27T17:53:51.729-0800: [GC (Allocation Failure) [PSYoungGen: 216718K->69220K(232960K)] 678805K->588668K(932352K), 0.0334929 secs] [Times: user=0.05 sys=0.07, real=0.04 secs] 
2020-10-27T17:53:51.779-0800: [GC (Allocation Failure) [PSYoungGen: 185950K->40736K(232960K)] 705399K->622022K(932352K), 0.0285388 secs] [Times: user=0.04 sys=0.13, real=0.03 secs] 
2020-10-27T17:53:51.821-0800: [GC (Allocation Failure) [PSYoungGen: 157210K->46342K(232960K)] 738496K->664265K(932352K), 0.0190575 secs] [Times: user=0.03 sys=0.07, real=0.02 secs] 
2020-10-27T17:53:51.840-0800: [Full GC (Ergonomics) [PSYoungGen: 46342K->0K(232960K)] [ParOldGen: 617923K->344032K(699392K)] 664265K->344032K(932352K), [Metaspace: 2889K->2889K(1056768K)], 0.0571406 secs] [Times: user=0.20 sys=0.02, real=0.05 secs] 
2020-10-27T17:53:51.917-0800: [GC (Allocation Failure) [PSYoungGen: 116736K->36629K(232960K)] 460768K->380662K(932352K), 0.0055338 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 
2020-10-27T17:53:51.947-0800: [GC (Allocation Failure) [PSYoungGen: 152997K->41423K(232960K)] 497030K->418210K(932352K), 0.0095395 secs] [Times: user=0.06 sys=0.00, real=0.01 secs] 
2020-10-27T17:53:51.973-0800: [GC (Allocation Failure) [PSYoungGen: 158159K->39738K(232960K)] 534946K->453508K(932352K), 0.0094890 secs] [Times: user=0.06 sys=0.00, real=0.01 secs] 
2020-10-27T17:53:51.999-0800: [GC (Allocation Failure) [PSYoungGen: 156474K->40849K(232960K)] 570244K->491419K(932352K), 0.0099099 secs] [Times: user=0.05 sys=0.01, real=0.01 secs] 
执行结束!共生成对象次数:10347
Heap
 PSYoungGen      total 232960K, used 46297K [0x00000007aab00000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 116736K, 4% used [0x00000007aab00000,0x00000007ab051f38,0x00000007b1d00000)
  from space 116224K, 35% used [0x00000007b8e80000,0x00000007bb664770,0x00000007c0000000)
  to   space 116224K, 0% used [0x00000007b1d00000,0x00000007b1d00000,0x00000007b8e80000)
 ParOldGen       total 699392K, used 450569K [0x0000000780000000, 0x00000007aab00000, 0x00000007aab00000)
  object space 699392K, 64% used [0x0000000780000000,0x000000079b802528,0x00000007aab00000)
 Metaspace       used 2896K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 310K, capacity 386K, committed 512K, reserved 1048576K

java -Xmx4g -Xms4g -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
2020-10-27T17:54:33.432-0800: [GC (Allocation Failure) [PSYoungGen: 1048576K->174591K(1223168K)] 1048576K->231919K(4019712K), 0.0906993 secs] [Times: user=0.10 sys=0.33, real=0.09 secs] 
2020-10-27T17:54:33.677-0800: [GC (Allocation Failure) [PSYoungGen: 1223167K->174577K(1223168K)] 1280495K->355605K(4019712K), 0.1900085 secs] [Times: user=0.13 sys=0.45, real=0.19 secs] 
执行结束!共生成对象次数:8154
Heap
 PSYoungGen      total 1223168K, used 280708K [0x000000076ab00000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 1048576K, 10% used [0x000000076ab00000,0x00000007712a4df8,0x00000007aab00000)
  from space 174592K, 99% used [0x00000007b5580000,0x00000007bfffc540,0x00000007c0000000)
  to   space 174592K, 0% used [0x00000007aab00000,0x00000007aab00000,0x00000007b5580000)
 ParOldGen       total 2796544K, used 181028K [0x00000006c0000000, 0x000000076ab00000, 0x000000076ab00000)
  object space 2796544K, 6% used [0x00000006c0000000,0x00000006cb0c90e8,0x000000076ab00000)
 Metaspace       used 2896K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 310K, capacity 386K, committed 512K, reserved 1048576K
```

* CMS Concurrent Mark and Sweep GC
```
2020-10-27T17:56:08.315-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.315-0800: [ParNew: 41381K->5173K(46656K), 0.0064492 secs] 41381K->14360K(150464K), 0.0064997 secs] [Times: user=0.01 sys=0.03, real=0.01 secs] 
2020-10-27T17:56:08.332-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.332-0800: [ParNew: 46611K->5179K(46656K), 0.0063913 secs] 55798K->26110K(150464K), 0.0064411 secs] [Times: user=0.02 sys=0.02, real=0.00 secs] 
2020-10-27T17:56:08.345-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.345-0800: [ParNew: 46549K->5178K(46656K), 0.0096730 secs] 67479K->39960K(150464K), 0.0097103 secs] [Times: user=0.05 sys=0.01, real=0.01 secs] 
2020-10-27T17:56:08.363-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.363-0800: [ParNew: 46650K->5183K(46656K), 0.0090548 secs] 81432K->54787K(150464K), 0.0090984 secs] [Times: user=0.06 sys=0.00, real=0.01 secs] 
2020-10-27T17:56:08.381-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.381-0800: [ParNew: 46655K->5181K(46656K), 0.0092159 secs] 96259K->68860K(150464K), 0.0092518 secs] [Times: user=0.04 sys=0.01, real=0.01 secs] 
2020-10-27T17:56:08.391-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 63678K(103808K)] 69004K(150464K), 0.0002029 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:08.391-0800: [CMS-concurrent-mark-start]
2020-10-27T17:56:08.391-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:08.392-0800: [CMS-concurrent-preclean-start]
2020-10-27T17:56:08.392-0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:08.392-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-27T17:56:08.398-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.398-0800: [ParNew: 46620K->5177K(46656K), 0.0089212 secs] 110298K->82370K(150464K), 0.0090018 secs] [Times: user=0.05 sys=0.00, real=0.01 secs] 
2020-10-27T17:56:08.413-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.413-0800: [ParNew: 46343K->5178K(46656K), 0.0091398 secs] 123536K->96566K(150464K), 0.0091757 secs] [Times: user=0.05 sys=0.01, real=0.01 secs] 
2020-10-27T17:56:08.428-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.428-0800: [ParNew: 46578K->5183K(46656K), 0.0092149 secs] 137966K->109933K(152068K), 0.0092577 secs] [Times: user=0.05 sys=0.01, real=0.01 secs] 
2020-10-27T17:56:08.443-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.444-0800: [ParNew: 46545K->5183K(46656K), 0.0102036 secs] 151295K->125578K(167628K), 0.0102449 secs] [Times: user=0.05 sys=0.00, real=0.01 secs] 
2020-10-27T17:56:08.459-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.459-0800: [ParNew: 46655K->5182K(46656K), 0.0089691 secs] 167050K->138722K(180732K), 0.0090082 secs] [Times: user=0.06 sys=0.01, real=0.01 secs] 
2020-10-27T17:56:08.476-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.476-0800: [ParNew: 46635K->5179K(46656K), 0.0103787 secs] 180175K->152672K(194768K), 0.0104220 secs] [Times: user=0.05 sys=0.00, real=0.01 secs] 
2020-10-27T17:56:08.491-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.491-0800: [ParNew: 46521K->5181K(46656K), 0.0119406 secs] 194015K->167624K(209688K), 0.0119778 secs] [Times: user=0.02 sys=0.01, real=0.01 secs] 
2020-10-27T17:56:08.510-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.510-0800: [ParNew: 46511K->5170K(46656K), 0.0096697 secs] 208954K->180695K(222936K), 0.0097129 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 
2020-10-27T17:56:08.527-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.527-0800: [ParNew: 46642K->5179K(46656K), 0.0088444 secs] 222167K->193055K(235264K), 0.0088842 secs] [Times: user=0.03 sys=0.01, real=0.01 secs] 
2020-10-27T17:56:08.542-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.542-0800: [ParNew: 46651K->5175K(46656K), 0.0106802 secs] 234527K->209372K(251612K), 0.0107199 secs] [Times: user=0.05 sys=0.01, real=0.01 secs] 
2020-10-27T17:56:08.558-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.558-0800: [ParNew: 46408K->5179K(46656K), 0.0087038 secs] 250605K->222582K(264708K), 0.0087653 secs] [Times: user=0.04 sys=0.00, real=0.01 secs] 
2020-10-27T17:56:08.573-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.574-0800: [ParNew: 46644K->5182K(46656K), 0.0132365 secs] 264046K->242698K(284800K), 0.0132945 secs] [Times: user=0.06 sys=0.01, real=0.01 secs] 
2020-10-27T17:56:08.594-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.594-0800: [ParNew: 46654K->5181K(46656K), 0.0098484 secs] 284170K->256800K(298908K), 0.0098834 secs] [Times: user=0.05 sys=0.01, real=0.01 secs] 
2020-10-27T17:56:08.610-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.610-0800: [ParNew: 46546K->5171K(46656K), 0.0098029 secs] 298165K->271890K(314172K), 0.0098416 secs] [Times: user=0.05 sys=0.00, real=0.01 secs] 
2020-10-27T17:56:08.627-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.627-0800: [ParNew: 46387K->5181K(46656K), 0.0136849 secs] 313107K->289006K(331248K), 0.0137332 secs] [Times: user=0.03 sys=0.01, real=0.02 secs] 
2020-10-27T17:56:08.649-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.649-0800: [ParNew: 46653K->5180K(46656K), 0.0110341 secs] 330478K->303106K(345336K), 0.0110815 secs] [Times: user=0.04 sys=0.00, real=0.02 secs] 
2020-10-27T17:56:08.668-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.668-0800: [ParNew: 46475K->5180K(46656K), 0.0099662 secs] 344401K->317086K(359284K), 0.0100084 secs] [Times: user=0.04 sys=0.01, real=0.01 secs] 
2020-10-27T17:56:08.683-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.683-0800: [ParNew: 46519K->5176K(46656K), 0.0104416 secs] 358425K->330599K(372840K), 0.0104831 secs] [Times: user=0.05 sys=0.01, real=0.01 secs] 
2020-10-27T17:56:08.700-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.700-0800: [ParNew: 46230K->5181K(46656K), 0.0118757 secs] 371652K->345503K(387676K), 0.0119127 secs] [Times: user=0.05 sys=0.00, real=0.01 secs] 
2020-10-27T17:56:08.713-0800: [CMS-concurrent-abortable-preclean: 0.013/0.321 secs] [Times: user=0.97 sys=0.11, real=0.32 secs] 
2020-10-27T17:56:08.713-0800: [GC (CMS Final Remark) [YG occupancy: 14810 K (46656 K)]2020-10-27T17:56:08.713-0800: [Rescan (parallel) , 0.0015072 secs]2020-10-27T17:56:08.714-0800: [weak refs processing, 0.0000445 secs]2020-10-27T17:56:08.715-0800: [class unloading, 0.0002348 secs]2020-10-27T17:56:08.715-0800: [scrub symbol table, 0.0003309 secs]2020-10-27T17:56:08.715-0800: [scrub string table, 0.0001273 secs][1 CMS-remark: 340321K(341020K)] 355132K(387676K), 0.0023094 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:08.715-0800: [CMS-concurrent-sweep-start]
2020-10-27T17:56:08.716-0800: [CMS-concurrent-sweep: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:08.716-0800: [CMS-concurrent-reset-start]
2020-10-27T17:56:08.717-0800: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:08.721-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.721-0800: [ParNew: 46567K->46567K(46656K), 0.0000188 secs]2020-10-27T17:56:08.721-0800: [CMS: 336052K->248149K(349568K), 0.0485558 secs] 382619K->248149K(396224K), [Metaspace: 2890K->2890K(1056768K)], 0.0488582 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
2020-10-27T17:56:08.770-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 248149K(349568K)] 248449K(506816K), 0.0002554 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:08.770-0800: [CMS-concurrent-mark-start]
2020-10-27T17:56:08.771-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:08.771-0800: [CMS-concurrent-preclean-start]
2020-10-27T17:56:08.772-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:08.772-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-27T17:56:08.832-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.832-0800: [ParNew: 139776K->17471K(157248K), 0.0135146 secs] 387925K->290070K(506816K), 0.0135558 secs] [Times: user=0.08 sys=0.00, real=0.01 secs] 
2020-10-27T17:56:08.864-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.865-0800: [ParNew: 157247K->17470K(157248K), 0.0165836 secs] 429846K->335463K(506816K), 0.0166411 secs] [Times: user=0.08 sys=0.00, real=0.02 secs] 
2020-10-27T17:56:08.898-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.898-0800: [ParNew: 156960K->156960K(157248K), 0.0000170 secs]2020-10-27T17:56:08.898-0800: [CMS2020-10-27T17:56:08.898-0800: [CMS-concurrent-abortable-preclean: 0.004/0.126 secs] [Times: user=0.23 sys=0.04, real=0.12 secs] 
 (concurrent mode failure): 317992K->282919K(349568K), 0.0458243 secs] 474953K->282919K(506816K), [Metaspace: 2890K->2890K(1056768K)], 0.0458966 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
2020-10-27T17:56:08.965-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.965-0800: [ParNew: 139776K->17470K(157248K), 0.0069424 secs] 422695K->326789K(506816K), 0.0070426 secs] [Times: user=0.04 sys=0.00, real=0.01 secs] 
2020-10-27T17:56:08.972-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 309319K(349568K)] 327193K(506816K), 0.0002561 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:08.972-0800: [CMS-concurrent-mark-start]
2020-10-27T17:56:08.974-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:08.974-0800: [CMS-concurrent-preclean-start]
2020-10-27T17:56:08.974-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:08.974-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-27T17:56:08.992-0800: [GC (Allocation Failure) 2020-10-27T17:56:08.992-0800: [ParNew: 157246K->157246K(157248K), 0.0000180 secs]2020-10-27T17:56:08.992-0800: [CMS2020-10-27T17:56:08.992-0800: [CMS-concurrent-abortable-preclean: 0.001/0.018 secs] [Times: user=0.02 sys=0.00, real=0.02 secs] 
 (concurrent mode failure): 309319K->302507K(349568K), 0.0499606 secs] 466565K->302507K(506816K), [Metaspace: 2890K->2890K(1056768K)], 0.0500339 secs] [Times: user=0.05 sys=0.00, real=0.05 secs] 
2020-10-27T17:56:09.065-0800: [GC (Allocation Failure) 2020-10-27T17:56:09.065-0800: [ParNew: 139776K->17467K(157248K), 0.0074159 secs] 442283K->346502K(506816K), 0.0074654 secs] [Times: user=0.03 sys=0.00, real=0.01 secs] 
2020-10-27T17:56:09.072-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 329035K(349568K)] 346646K(506816K), 0.0002409 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:09.072-0800: [CMS-concurrent-mark-start]
2020-10-27T17:56:09.074-0800: [CMS-concurrent-mark: 0.002/0.002 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:09.074-0800: [CMS-concurrent-preclean-start]
2020-10-27T17:56:09.075-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:09.075-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-27T17:56:09.075-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:09.075-0800: [GC (CMS Final Remark) [YG occupancy: 31698 K (157248 K)]2020-10-27T17:56:09.088-0800: [Rescan (parallel) , 0.0013905 secs]2020-10-27T17:56:09.089-0800: [weak refs processing, 0.0000338 secs]2020-10-27T17:56:09.089-0800: [class unloading, 0.0002114 secs]2020-10-27T17:56:09.089-0800: [scrub symbol table, 0.0004246 secs]2020-10-27T17:56:09.090-0800: [scrub string table, 0.0001450 secs][1 CMS-remark: 329035K(349568K)] 360733K(506816K), 0.0148297 secs] [Times: user=0.01 sys=0.00, real=0.02 secs] 
2020-10-27T17:56:09.090-0800: [CMS-concurrent-sweep-start]
2020-10-27T17:56:09.091-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:09.091-0800: [CMS-concurrent-reset-start]
2020-10-27T17:56:09.091-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:09.109-0800: [GC (Allocation Failure) 2020-10-27T17:56:09.109-0800: [ParNew: 157243K->17470K(157248K), 0.0102904 secs] 445420K->353188K(506816K), 0.0103285 secs] [Times: user=0.05 sys=0.00, real=0.02 secs] 
2020-10-27T17:56:09.120-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 335718K(349568K)] 353267K(506816K), 0.0001899 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:09.120-0800: [CMS-concurrent-mark-start]
2020-10-27T17:56:09.121-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:09.121-0800: [CMS-concurrent-preclean-start]
2020-10-27T17:56:09.122-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:09.122-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-27T17:56:09.122-0800: [CMS-concurrent-abortable-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:09.122-0800: [GC (CMS Final Remark) [YG occupancy: 31686 K (157248 K)]2020-10-27T17:56:09.122-0800: [Rescan (parallel) , 0.0003780 secs]2020-10-27T17:56:09.122-0800: [weak refs processing, 0.0000274 secs]2020-10-27T17:56:09.122-0800: [class unloading, 0.0002772 secs]2020-10-27T17:56:09.123-0800: [scrub symbol table, 0.0003874 secs]2020-10-27T17:56:09.123-0800: [scrub string table, 0.0001428 secs][1 CMS-remark: 335718K(349568K)] 367404K(506816K), 0.0012806 secs] [Times: user=0.01 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:09.123-0800: [CMS-concurrent-sweep-start]
2020-10-27T17:56:09.124-0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:09.124-0800: [CMS-concurrent-reset-start]
2020-10-27T17:56:09.124-0800: [CMS-concurrent-reset: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:09.143-0800: [GC (Allocation Failure) 2020-10-27T17:56:09.143-0800: [ParNew: 157246K->157246K(157248K), 0.0000197 secs]2020-10-27T17:56:09.143-0800: [CMS: 297216K->329846K(349568K), 0.0546525 secs] 454463K->329846K(506816K), [Metaspace: 2890K->2890K(1056768K)], 0.0547256 secs] [Times: user=0.06 sys=0.00, real=0.05 secs] 
2020-10-27T17:56:09.198-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 329846K(349568K)] 330222K(506816K), 0.0003549 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:09.198-0800: [CMS-concurrent-mark-start]
2020-10-27T17:56:09.200-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
2020-10-27T17:56:09.200-0800: [CMS-concurrent-preclean-start]
2020-10-27T17:56:09.200-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:56:09.200-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-27T17:56:09.222-0800: [GC (Allocation Failure) 2020-10-27T17:56:09.222-0800: [ParNew: 139754K->139754K(157248K), 0.0000207 secs]2020-10-27T17:56:09.222-0800: [CMS2020-10-27T17:56:09.222-0800: [CMS-concurrent-abortable-preclean: 0.001/0.022 secs] [Times: user=0.02 sys=0.00, real=0.02 secs] 
 (concurrent mode failure): 329846K->330678K(349568K), 0.0553455 secs] 469600K->330678K(506816K), [Metaspace: 2890K->2890K(1056768K)], 0.0554241 secs] [Times: user=0.06 sys=0.00, real=0.05 secs] 
执行结束!共生成对象次数:8858
Heap
 par new generation   total 157248K, used 37661K [0x00000007a0000000, 0x00000007aaaa0000, 0x00000007aaaa0000)
  eden space 139776K,  26% used [0x00000007a0000000, 0x00000007a24c75d8, 0x00000007a8880000)
  from space 17472K,   0% used [0x00000007a9990000, 0x00000007a9990000, 0x00000007aaaa0000)
  to   space 17472K,   0% used [0x00000007a8880000, 0x00000007a8880000, 0x00000007a9990000)
 concurrent mark-sweep generation total 349568K, used 330678K [0x00000007aaaa0000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 2896K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 310K, capacity 386K, committed 512K, reserved 1048576K


java -XX:+UseConcMarkSweepGC -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
2020-10-27T17:57:43.074-0800: [GC (Allocation Failure) 2020-10-27T17:57:43.074-0800: [ParNew: 279616K->34943K(314560K), 0.0387258 secs] 279616K->90193K(1013632K), 0.0387778 secs] [Times: user=0.05 sys=0.11, real=0.04 secs] 
2020-10-27T17:57:43.161-0800: [GC (Allocation Failure) 2020-10-27T17:57:43.161-0800: [ParNew: 314559K->34940K(314560K), 0.0374596 secs] 369809K->165072K(1013632K), 0.0374978 secs] [Times: user=0.06 sys=0.15, real=0.03 secs] 
2020-10-27T17:57:43.234-0800: [GC (Allocation Failure) 2020-10-27T17:57:43.234-0800: [ParNew: 314556K->34944K(314560K), 0.0538360 secs] 444688K->254153K(1013632K), 0.0538978 secs] [Times: user=0.35 sys=0.03, real=0.05 secs] 
2020-10-27T17:57:43.326-0800: [GC (Allocation Failure) 2020-10-27T17:57:43.326-0800: [ParNew: 314560K->34944K(314560K), 0.0454046 secs] 533769K->327699K(1013632K), 0.0454427 secs] [Times: user=0.30 sys=0.03, real=0.05 secs] 
2020-10-27T17:57:43.405-0800: [GC (Allocation Failure) 2020-10-27T17:57:43.405-0800: [ParNew: 314560K->34942K(314560K), 0.0567363 secs] 607315K->413108K(1013632K), 0.0567790 secs] [Times: user=0.30 sys=0.03, real=0.06 secs] 
2020-10-27T17:57:43.462-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 378165K(699072K)] 413596K(1013632K), 0.0004630 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:57:43.463-0800: [CMS-concurrent-mark-start]
2020-10-27T17:57:43.466-0800: [CMS-concurrent-mark: 0.003/0.003 secs] [Times: user=0.01 sys=0.01, real=0.00 secs] 
2020-10-27T17:57:43.466-0800: [CMS-concurrent-preclean-start]
2020-10-27T17:57:43.467-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:57:43.467-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-27T17:57:43.498-0800: [GC (Allocation Failure) 2020-10-27T17:57:43.498-0800: [ParNew: 314558K->34940K(314560K), 0.0492185 secs] 692724K->491173K(1013632K), 0.0492600 secs] [Times: user=0.28 sys=0.02, real=0.05 secs] 
2020-10-27T17:57:43.581-0800: [GC (Allocation Failure) 2020-10-27T17:57:43.581-0800: [ParNew: 314556K->34943K(314560K), 0.0541332 secs] 770789K->576974K(1013632K), 0.0541934 secs] [Times: user=0.35 sys=0.04, real=0.05 secs] 
2020-10-27T17:57:43.675-0800: [GC (Allocation Failure) 2020-10-27T17:57:43.675-0800: [ParNew: 314559K->34943K(314560K), 0.0440806 secs] 856590K->648037K(1013632K), 0.0441203 secs] [Times: user=0.29 sys=0.02, real=0.04 secs] 
2020-10-27T17:57:43.753-0800: [GC (Allocation Failure) 2020-10-27T17:57:43.753-0800: [ParNew: 314559K->314559K(314560K), 0.0000160 secs]2020-10-27T17:57:43.753-0800: [CMS2020-10-27T17:57:43.753-0800: [CMS-concurrent-abortable-preclean: 0.009/0.286 secs] [Times: user=1.06 sys=0.08, real=0.29 secs] 
 (concurrent mode failure): 613093K->337394K(699072K), 0.0619346 secs] 927653K->337394K(1013632K), [Metaspace: 2889K->2889K(1056768K)], 0.0619994 secs] [Times: user=0.06 sys=0.00, real=0.06 secs] 
2020-10-27T17:57:43.849-0800: [GC (Allocation Failure) 2020-10-27T17:57:43.849-0800: [ParNew: 279616K->34942K(314560K), 0.0123131 secs] 617010K->422647K(1013632K), 0.0123495 secs] [Times: user=0.08 sys=0.00, real=0.02 secs] 
2020-10-27T17:57:43.862-0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 387704K(699072K)] 422957K(1013632K), 0.0002161 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:57:43.862-0800: [CMS-concurrent-mark-start]
2020-10-27T17:57:43.863-0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:57:43.863-0800: [CMS-concurrent-preclean-start]
2020-10-27T17:57:43.865-0800: [CMS-concurrent-preclean: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
2020-10-27T17:57:43.865-0800: [CMS-concurrent-abortable-preclean-start]
2020-10-27T17:57:43.901-0800: [GC (Allocation Failure) 2020-10-27T17:57:43.901-0800: [ParNew: 314558K->34943K(314560K), 0.0188138 secs] 702263K->502780K(1013632K), 0.0188516 secs] [Times: user=0.11 sys=0.00, real=0.02 secs] 
执行结束!共生成对象次数:11533
Heap
 par new generation   total 314560K, used 46143K [0x0000000780000000, 0x0000000795550000, 0x0000000795550000)
  eden space 279616K,   4% used [0x0000000780000000, 0x0000000780af0040, 0x0000000791110000)
  from space 34944K,  99% used [0x0000000791110000, 0x000000079332fe58, 0x0000000793330000)
  to   space 34944K,   0% used [0x0000000793330000, 0x0000000793330000, 0x0000000795550000)
 concurrent mark-sweep generation total 699072K, used 467836K [0x0000000795550000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 2896K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 310K, capacity 386K, committed 512K, reserved 1048576K


java -XX:+UseConcMarkSweepGC -Xmx4g -Xms4g -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
2020-10-27T17:58:08.070-0800: [GC (Allocation Failure) 2020-10-27T17:58:08.070-0800: [ParNew: 545344K->68096K(613440K), 0.0637226 secs] 545344K->150584K(4126208K), 0.0637773 secs] [Times: user=0.12 sys=0.28, real=0.06 secs] 
2020-10-27T17:58:08.214-0800: [GC (Allocation Failure) 2020-10-27T17:58:08.214-0800: [ParNew: 613440K->68096K(613440K), 0.0729031 secs] 695928K->287267K(4126208K), 0.0729463 secs] [Times: user=0.13 sys=0.27, real=0.07 secs] 
2020-10-27T17:58:08.364-0800: [GC (Allocation Failure) 2020-10-27T17:58:08.364-0800: [ParNew: 613440K->68096K(613440K), 0.0788363 secs] 832611K->410371K(4126208K), 0.0788750 secs] [Times: user=0.56 sys=0.04, real=0.08 secs] 
2020-10-27T17:58:08.517-0800: [GC (Allocation Failure) 2020-10-27T17:58:08.517-0800: [ParNew: 613440K->68096K(613440K), 0.0801223 secs] 955715K->543718K(4126208K), 0.0801629 secs] [Times: user=0.54 sys=0.05, real=0.08 secs] 
2020-10-27T17:58:08.682-0800: [GC (Allocation Failure) 2020-10-27T17:58:08.682-0800: [ParNew: 613440K->68095K(613440K), 0.0786556 secs] 1089062K->669451K(4126208K), 0.0786987 secs] [Times: user=0.54 sys=0.05, real=0.08 secs] 
执行结束!共生成对象次数:10714
Heap
 par new generation   total 613440K, used 203001K [0x00000006c0000000, 0x00000006e9990000, 0x00000006e9990000)
  eden space 545344K,  24% used [0x00000006c0000000, 0x00000006c83be750, 0x00000006e1490000)
  from space 68096K,  99% used [0x00000006e5710000, 0x00000006e998fd38, 0x00000006e9990000)
  to   space 68096K,   0% used [0x00000006e1490000, 0x00000006e1490000, 0x00000006e5710000)
 concurrent mark-sweep generation total 3512768K, used 601356K [0x00000006e9990000, 0x00000007c0000000, 0x00000007c0000000)
 Metaspace       used 2896K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 310K, capacity 386K, committed 512K, reserved 1048576K
```

* G1 GC
```
java -XX:+UseG1GC -Xloggc:gc.demo.g1.512m.log -XX:MaxGCPauseMillis=50 -Xmx512m -Xms512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
执行结束!共生成对象次数:11057
java -XX:+UseG1GC -XX:MaxGCPauseMillis=50 -Xloggc:gc.demo.g1.1g.log -Xmx1g -Xms1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
执行结束!共生成对象次数:12274
java -XX:+UseG1GC -XX:MaxGCPauseMillis=50 -Xloggc:gc.demo.g1.4g.log -Xmx4g -Xms4g -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
执行结束!共生成对象次数:12854 d
```

* 统计

| 512m             |           |             |        |       |
| ---------------- | --------- | ----------- | ------ | ----- |
|                  | Serial GC | Parallel GC | CMS GC | G1 GC |
| Object generated | 9028      | 7564        | 8858   | 11057 |
| GC avg pause     | 36.5      | 17.9        | 14     | 3.31  |
| GC max pause     | 60        | 40          | 50     | 30    |
| Minor GC         | 10        | 25          | 31     | 32    |
| Minor GC total   | 280       | 280         | 420    | 140   |
| Full GC          | 7         | 8           | 3      | n/a   |
| Full total       | 340       | 310         | 150    | n/a   |

| 1G               |           |             |        |       |
| ---------------- | --------- | ----------- | ------ | ----- |
|                  | Serial GC | Parallel GC | CMS GC | G1 GC |
| Object generated | 8292      | 10347       | 11533  | 12274 |
| GC avg pause     | 72.5      | 27.1        | 39.2   | 7.61  |
| GC max pause     | 120       | 50          | 60     | 40    |
| Minor GC         | 8         | 16          | 10     | 22    |
| Minor GC total   | 580       | 410         | 410    | 250   |
| Full GC          | 0         | 1           | 1      | n/a   |
| Full total       | 0         | 50          | 60     | n/a   |

| 4G               |           |             |        |       |
| ---------------- | --------- | ----------- | ------ | ----- |
|                  | Serial GC | Parallel GC | CMS GC | G1 GC |
| Object generated | 9028      | 8154        | 10714  | 12854 |
| GC avg pause     | 220       | 140         | 74     | 24.7  |
| GC max pause     | 220       | 190         | 80     | 30    |
| Minor GC         | 1         | 2           | 5      | 19    |
| Minor GC total   | 220       | 280         | 370    | 470   |
| Full GC          | 0         | 0           | 0      | n/a   |
| Full total       | 0         | 0           | 0      | n/a   |


* 总结
  1. 随着堆大小增加，GC 的次数减少。
  2. 堆比较小（512MB）的情况下，程序生成对象的效率，串行 GC 的情况好于并行 GC 和 CMS。
  3. GC 平均暂停时间，并行 GC 远好于串行 GC；CMS 远好于并行 GC；G1 GC 远好于并行 GC。
  4. G1 GC 会更加频繁地进行 Minor GC，但其最大 GC 暂停时间非常稳定可靠。

### 测试案例二 Gateway Server

* 测试办法：
1. 取第 2 次压测执行结果，以免受未预热的影响。
2. wrk 取 4个线程，80 个连接，每次压测 30 秒。 
```
wrk -t4 -c80 -d30s --latency http://localhost:8088/api/hello
```

* Serial GC

```
java -XX:+UseSerialGC -Xmx512m -Xms512m -jar target/gateway-server-0.0.1-SNAPSHOT.jar
Running 30s test @ http://localhost:8088/api/hello
  4 threads and 80 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    15.00ms   49.95ms 426.18ms   92.48%
    Req/Sec    13.52k     3.65k   24.72k    85.23%
  Latency Distribution
     50%    1.18ms
     75%    1.56ms
     90%   15.24ms
     99%  269.13ms
  1519300 requests in 30.07s, 181.39MB read
Requests/sec:  50528.09
Transfer/sec:      6.03MB

java -XX:+UseSerialGC -Xmx4g -Xms4g -jar target/gateway-server-0.0.1-SNAPSHOT.jar
Running 30s test @ http://localhost:8088/api/hello
  4 threads and 80 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     9.56ms   44.56ms 468.70ms   95.87%
    Req/Sec    14.40k     3.12k   25.33k    86.70%
  Latency Distribution
     50%    1.14ms
     75%    1.43ms
     90%    2.11ms
     99%  278.55ms
  1557442 requests in 30.09s, 185.94MB read
  Socket errors: connect 0, read 0, write 0, timeout 80
Requests/sec:  51757.47
Transfer/sec:      6.18MB
```

* Parallel GC
  
```
java  -Xmx512m -Xms512m -jar target/gateway-server-0.0.1-SNAPSHOT.jar
Running 30s test @ http://localhost:8088/api/hello
  4 threads and 80 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    21.41ms   85.12ms 801.67ms   93.92%
    Req/Sec    13.71k     3.84k   29.41k    85.83%
  Latency Distribution
     50%    1.15ms
     75%    1.52ms
     90%    4.95ms
     99%  513.04ms
  1381328 requests in 30.08s, 164.92MB read
Requests/sec:  45915.96
Transfer/sec:      5.48MB

java  -Xmx4g -Xms4g -jar target/gateway-server-0.0.1-SNAPSHOT.jar
Running 30s test @ http://localhost:8088/api/hello
  4 threads and 80 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    12.13ms   53.10ms 598.52ms   94.86%
    Req/Sec    14.14k     3.54k   25.21k    85.95%
  Latency Distribution
     50%    1.13ms
     75%    1.45ms
     90%    2.54ms
     99%  282.74ms
  1452386 requests in 30.08s, 173.40MB read
Requests/sec:  48289.29
Transfer/sec:      5.77MB
```

* CMS Concurrent Mark and Sweep GC

```
java -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC -jar target/gateway-server-0.0.1-SNAPSHOT.jar
Running 30s test @ http://localhost:8088/api/hello
  4 threads and 80 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    20.40ms   61.27ms 433.00ms   91.09%
    Req/Sec    13.18k     3.86k   23.02k    84.84%
  Latency Distribution
     50%    1.21ms
     75%    1.63ms
     90%   61.26ms
     99%  318.17ms
  1451277 requests in 30.05s, 173.27MB read
Requests/sec:  48296.56
Transfer/sec:      5.77MB

java -Xmx4g -Xms4g -XX:+UseConcMarkSweepGC -jar target/gateway-server-0.0.1-SNAPSHOT.jar
Running 30s test @ http://localhost:8088/api/hello
  4 threads and 80 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     7.91ms   28.77ms 278.67ms   94.15%
    Req/Sec    13.67k     3.78k   39.46k    83.29%
  Latency Distribution
     50%    1.15ms
     75%    1.49ms
     90%    2.90ms
     99%  163.78ms
  1569700 requests in 30.10s, 187.41MB read
Requests/sec:  52155.15
Transfer/sec:      6.23MB
```

* G1 GC
  
```
java -Xmx512m -Xms512m -XX:+UseG1GC -XX:MaxGCPauseMillis=50 -jar target/gateway-server-0.0.1-SNAPSHOT.jar
Running 30s test @ http://localhost:8088/api/hello
  4 threads and 80 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    17.47ms   70.88ms 735.93ms   93.84%
    Req/Sec    13.70k     3.20k   32.25k    87.20%
  Latency Distribution
     50%    1.20ms
     75%    1.58ms
     90%    3.45ms
     99%  400.00ms
  1542192 requests in 30.08s, 184.12MB read
Requests/sec:  51267.46
Transfer/sec:      6.12MB

java -Xmx4g -Xms4g -XX:+UseG1GC -XX:MaxGCPauseMillis=50 -jar target/gateway-server-0.0.1-SNAPSHOT.jar
Running 30s test @ http://localhost:8088/api/hello
  4 threads and 80 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.29ms  801.59us  13.29ms   86.82%
    Req/Sec    14.39k     1.91k   19.55k    74.70%
  Latency Distribution
     50%    1.14ms
     75%    1.45ms
     90%    2.05ms
     99%    3.95ms
  1569900 requests in 30.09s, 187.43MB read
Requests/sec:  52176.93
Transfer/sec:      6.23MB
```

* 分析
  * 在本机上，无论采用哪种垃圾回收算法（Serial，parallel，CMS，G1），和哪种堆内存大小500M或者4G， 在40个连接、30秒的压测情况下，请求吞吐量都没有太大的区别，都在每秒钟50000请求上下。
  * 串行 GC 模式下甚至跑出了较并行 GC 更好的吞吐。 
  * 被测试应用在本机的瓶颈是 CPU。被测试应用不会大量地创建对象，在给定堆大小下不会出现 Full GC。
  * 预热与否吞吐表现影响较大，吞吐率甚至有成倍数的区别。
  * 串行 GC 在堆1G 的情况下出现了最大将近两秒的延迟。
  * G1 GC 在较大堆内存的条件下表现了非常优异的平均延迟，和极低的标准差。