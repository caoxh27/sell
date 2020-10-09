# **JavaEasyCoding**



## 第1章 计算机基础

大道至简，盘古生其中。计算机的基础世界一切都是由 0 与 1 组成的。

**追根究底**是深度分析和解决问题、提升程序员素质的关键所在，有助于编写高质量的代码。基础知识的深度认知决定着知识上层建筑的延展性。试问， 对于如下的基础知识，你的认知是否足够清晰呢？
·	 位移运算可以快速地实现乘除运算，那位移时要注意什么？
· 	浮点数的存储与计算为什么总会产生微小的误差？
· 	乱码产生的根源是什么？
· 	代码执行时， CPU 是如何与内存配合完成程序使命的？
· 	网络连接资源耗尽的问题本质是什么？
· 	黑客攻击的通常套路是什么？如何有效地防止？
本章从编程的角度深度探讨计算机组成原理、计算机网络、信息安全等相关内容，与具体编程语言无关。

### 1.1 走进0与1的世界

### 1.2 浮点数

### 1.3 字符集与乱码

### 1.4 CPU 与内存

### 1.5 TCP/IP

### 1.6 信息安全

### 1.7 编程语言的发展



## 第2章 面向对象

”一树菩提，一‘门’一世界。” 一切皆对象，万物有三问·我是谁？我从哪里来？我到哪里去？

### 2.1 OOP 理念

### 2.2 初识Java

### 2.3 类

### 2.4 方法

### 2.5 重载

### 2 .6 泛型

### 2.7 数据类型

#### 2.7.1 基本数据类型

#### 2.7.2 包装类型

#### 2.7.3 字符串

​		字符串类型是常用的数据类型，它在 JVM 中的地位并不比基本数据类型低，JVM 对字符串也做了特殊处理。String 就像是流落到基本数据类型部落的一个副首领，虽然很神气， 但是终归难以得到族人对它的认同，毕竟它是堆上分配来的。

​		字符串相关类型主要有三种String 、StringBuilder、StringBuffer 。

​		String 是只读字符串，典型的 immutable 对象，对它的任何改动，其实都是创建一个新对象，再把引用指向该对象。String 对象赋值操作后，会在常量池中进行缓存，如果下次申请创建对象时，缓存中已经存在， 则直接返回相应引用给创建者。

​		**StringBuffer 则可以在原对象上进行修改， 是线程安全的。**JDK5 引入的StringBuilder 与 StringBuffer 均继承自 AbstractStringBuiIder ， 两个子类的很多方法都是通过 "super.方法()"  的方式调用抽象父类中的方法， 此抽象类在内部与String 一样， 也是以字符数组的形式存储字符串的。**StringBuilder 是非线程安全的**， 把是否需要进行多线程加锁交给工程师决定，操作效率比StringBuffer 高。线程安全的对象先产生是因为计算机的发展总是从单线程到多线程，从单机到分布式。

​		在非基本数据类型的对象中， String 是仅支持直接相加操作的对象；这样操作比较方便， 但在循环体内，字符串的连接方式应该使用 StringBuilder 的 append 方法进行扩展。如下的方式是不推荐的

```java
String str = "start";
for (int i = O; i < 100; i++) {
	str = str + "hello" ;
}
```

​		此段代码的内部实现逻辑是每次循环都会 new 个StringBuilder 对象， 然后进行append 操作，最后通过toString 方法返回 String 对象， 不但造成了内存资源浪费，而且性能更差。







## 第3章 代码风格

流水淡，碧天长，鸿雁成行。编码风格，简捷清爽，反引无限风光。









## 第4章 走进JVM

云开方见日，潮尽炉峰出。揭开JVM的神秘面纱，探寻底层的实现原理。







## 第5章 异常与日志

“欲渡黄河冰塞川，将登太行雪满山。” 系统运行，风云不测，睹始知终，秋去冬来，一叶落而知秋。











## 第6章 数据结构与集合

​		廊腰缦回，檐牙高啄。纵使相同一砖一瓦，不同雕琢设计，亦生错落有致的廊榭美景。数据结构的魅力也缘于此中道理。			

​		在代码世界中，集合是对 Collection 一词的翻译，事实上这么翻译仍不够准确。
​		在数学世界中，集合是指具有某种特定性质的事物汇成的集体，对应英文是Set ， 它具有确定性、无序性、互异性等特点。而  **Java 中的集合表达的是数据结构的载体 **，并未对应于数学概念上的集合，  **Java 中的集合元素可以是有序的，也可以是重复的，与数学中的要求不一样 。**本书中其他地方出现的集合概念，都指的是Collection ， 用来保存各种各样的对象。我们经常说，"程序=数据结构+算法"。 **集合作为数据结构的载体， 可对元素进行加工和输出，以一定的算法实现最基本的增删改查功能，因此集合是所有编程语言的基础。**
​		在进入高并发编程时代后，由集合引发的相关故障占比越来越高。比如，多线程共享集合时出现的脏数据问题，某些集合在数据扩容时出现节点之间的死链问题；写多读少的场景误用某些集合导致性能下降问题等。本章将从数组讲起，引申到集合框架，再到重点集合源码分析， 最后介绍高并发集合框架，目的是对集合的了解成竹在
胸、运用得心应手。	

### 6.1 数据结构	

#### 6.1.1 数据结构定义

​		**数据结构是什么？** 网络上的一些定义十分抽象且各不相同，学习完之后，反而对数据结构的概念更加模糊、更有敬畏之心。**数据结构是指  (1)逻辑意义上 的 (2)数据组织方式 及其相应的(3)处理方式。**

​		( 1）什么是***逻辑意义***？ **数据结构的抽象表达非常丰富，而实际物理存储的方式相对单一。**比如，二叉树在磁盘中的存储真的是树形排列吗？并非如此。树的存储可能是**基于物理上的<u>顺序存储</u>方式**，可以理解为一个格子一个格子连续地放， 设想有7个节点的二叉树，第一个格子放根节点，第二个恪子放左子树根节点，并且根据引用知道左叶子在后续的哪个格子里，第三个格子放右子树根节点，依此类推。此外，树的存储也可能是**基于物理上的<u>链式存储</u>方式**，这里不再详细展开。

​		( 2） 什么是***数据组织方式***？ <u>逻辑意义上的组织方式有很多，比如树、图、队列、哈希等。树可以是二叉树、三叉树、B＋ 树等，图可以是有向图或无向图，队列是先进先出的线性结构；哈希是根据某种算法直接定位的数据组织方式。</u>

​		( 3 ) 什么是***数据处理方式***？ <u>在既定的数据组织方式上，以某种特定的算法实现数据的增加、删除、修改、查找和遍历。</u>不同的数据处理方式往往存在着非常大的性能差异。



#### 6.1.2 数据结构分类

​		数据结构是算法实现的基石， 它是一种体现基础逻辑思维的内功心法，也是计算机从业人员能力图谱中的重要一项。如果完全不懂数据结构，很难写出优秀的代码。有缺陷的底层数据结构容易导致系统风险高、可扩展性差，所以需要认真地对数据结构进行设计和评审。从**直接前继**和**直接后继**个数的维度来看，大体可以将数据结构分为以下四类。
​		**(1) 线性结构**：0 至 1 个直接前继和直接后继。当线性结构非空时，有唯一的首元素和尾元素，除两者外， 所有的元素都有唯一的直接前继和直接后继。线性结构包括顺序表、链表、栈、队列等，其中栈和队列是访问受限的结构。栈是后进先出，即Last-In, First-Out ，简称LIFO ；队列是先进先出，即First-In, First-Out ，简称FIFO 。

​		**(2) 树结构**：0 至 1 个直接前继 和 0 至 n 个直接后继（ n 大于或等于2 ）。树是一种非常重要的有层次的非线性数据结构，像自然界的树一样。由于树结构比较稳定和均衡，在计算机领域中得到广泛应用。

​		**(3) 图结构**：0 至n 个直接前继和直接后继（ n 大于或等于2 ）。图结构包括简单图、多重图、有向图和无向图等。
​		**(4) 哈希结构**：没有直接前继和直接后继。哈希结构通过某种特定的哈希函数将 索引 与 存储的值 关联起来，它是一种查找效率非常高的数据结构。

​		不同的 数据组织方式 和 处理方式 带来了一个新的问题·如何衡量数据处理的性能。数据结构的复杂度分为空间复杂度和时间复杂度两种，在存储设备越来越便宜的情况下，时间复杂度成为重点考量的因素。算法时间复杂度是种衡量计算性能的指标， 反映了程序执行时间随输入规模增长而增长的量级，在很大程度上能够反映出算法性能的优劣与否。而这个量级通常用大写的0 和一个函数描述， 如 O(n3） 表示程序执行时间随输入规模呈现三次方倍的增长， 这是比较差的算法实现。从最好到最坏的常用算法复杂度排序如下：

> 1. 常数级O(1)
> 2. 对数级O(logn）
> 3. 线性级O(n)
> 4. 线性对数级（nlogn） 
> 5. 平方级O(n2）
> 6. 立方级O(n3）
> 7. 指数级0(2＂）

​		有人觉得在实际编程中没有必要去纠结算法复杂度，因为现实中的数据量有限，执行时间相差无几。但是，数据规模并非静止不变，优秀的程序实现不会因为数据规模的急剧上升导致程序性能的急剧下降。

​		最后以“ 猜数字” 为例进一步理解时间复杂度， 主持人从1 ～ 100 的范围内任选一个数字， 玩家随机猜一个数， 如果没有猜中， 主持人会提示猜大了还是猜小了， 继续这样的循环，直到猜对为止。显而易见， 如果要猜测， 最多要猜100 次，最少只用猜1次。经验表明， 玩家总会往中间砍一段，平均猜测次数总在七八次左右。通过模拟程序运行1亿次， 完全随机的情况下，平均猜测的次数是7.47 次， 近似二分法猜测的是5 . 8 次， 时间复杂度为O(logn ） 。

### 6.2 集合框架图

​		<u>**Java 中的集合是用于存储对象的工具类容器， 它实现了常用的数据结构， 提供了一系列公开的方法用于增加、删除、修改、查找和遍历数据，降低了日常开发成本。**</u> 集合的种类非常多， 形成了一个比较经典的继承关系树， 称为 Java集合框架图， 如图6-1所示。

![](E:\JAVADEV\sell\docs\pics\6.1 Java集合框架图.jpg)

​		框架图中主要分为两类。第一类是**按照单个元素存储的Collection** ， 在继承树中Set 和 List 都实现了Collection 接口；第二类是**按照 Key-Value 存储的Map** 。以上两类集合体系， 无论数据存取还是遍历， 都存在非常大的差异。

​		在集合框架图中，红色代表接口， 蓝色代表抽象类， 绿色代表并发包中的类，灰色代表早期线程安全的类（基本已经弃用）。可以看到，与Collection 相关的4 条线分别是 **List 、Queue 、Set 、Map**，它们的子类会映射到数据结构中的表、树、哈希等。对集合框架图的深刻理解，有利于对集合的宏观把控，并写出更高质量的程序。此图相当于纲举目张的 "纲"，虽然部分集合没有纳入此框架图中，但是容易沿着这个图的思路理解其他集合。下面一起学习这4 个常用集合类型。



#### 6.2.1 List 集合

​		List 集合是线性数据结构的主要实现，集合元素通常存在明确的上一个和下一个元素，也存在明确的第一个元素和最后一个元素。List 集合的遍历结果是稳定的。该体系最常用的是ArrayList 和LinkedList 两个集合类。
​		ArrayList 是容量可以改变的非线程安全集合。内部实现使用数组进行存储，集合扩容时会创建更大的数组空间，把原有数据复制到新数组中。ArrayList 支持对元素的快速**随机访问**，但是插入与删除时速度通常很慢，因为这个过程很有可能需要移动其他元素。
​		LinkedList 的本质是双向链表。与 ArrayList 相比， LinkedList 的插入和删除速度更快，但是随机访问速度贝lj很慢。测试表明，对于 10 万条的数据，与 ArrayList 相比，随机提取元素时存在数百倍的差距。除继承AbstractList 抽象类外， LinkedList 还实现了另一个接口Deque ，即double-ended queue。这个接口同时具有队列和栈的性质。	**LinkedList 包含3 个重要的成员 size 、first、last。size 是双向链表中节点的个数。first 和 last 分别指向第一个和最后一个节点的引用。LinkedList 的优点在于可以将零散的内存单元通过附加引用的方式关联起来，形成按链路顺序查找的线性结构，内存利用率较高。**



#### 6.2.2 Queue 集合

​		Queue （队列） 是一种**先进先出**的数据结构，队列是一种特殊的线性表，它只允许在表的端进行获取操作，在表的另端进行插入操作。当队列中没有元素时，称为空队列。

​		自从 **BlockingQueue （阻塞队列）**问世以来，队列的地位得到极大的提升，在各种高并发编程场景中，由于其本身 FIFO 的特性和阻塞操作的特点，经常被作为Buffer （数据缓冲区）使用。



#### 6.2.3 Map 集合

​		Map 集合是以 Key-Value 键值对作为存储元素实现的哈希结构， Key 按某种哈希函数计算后是唯一的， Value 则是可以重复的。Map 类提供三种 Collection 视图，在集合框架图中， Map 指向Collection 的箭头仅表示两个类之间的依赖关系。可以**使用 keySet() 查看所有的Key，使用 values() 查看所有的Value ，使用 entrySet() 查看所有的键值对**。最早用于存储键值对的 Hashtable 因为性能瓶颈已经被淘汰，而如今广泛使用的 HashMap ， 线程是不安全的。ConcurrentHashMap 是线程安全的，在 JDK8 中进行了锁的大幅度优化，体现出不错的性能。在多线程并发场景中，优先推荐使用 ConcurrentHashMap ，而不是 HashMap 。TreeMap 是Key 有序的Map 类集合。



#### 6.2.4 Set 集合

​		Set 是不允许出现重复元素的集合类型。Set 体系最常用的是 HashSet 、TreeSet 和 LinkedHashSet  三个集合类。

​		**HashSet** 从源码分析是使用 HashMap 来实现的，只是 Value 固定为一个静态对象，使用 Key 保证集合元素的唯性，但它不保证集合元素的顺序。

​		**TreeSet** 也是如此，从源码分析是使用 TreeMap 来实现的，底层为树结构，在添加新元素到集合中时，按照某种比较规则将其插入合适的位置，保证插入后的集合仍然是有序的。

​		**LinkedHashSet** 继承自 HashSet ， 具有HashSet 的优点，内部使用链表维护了元素插入顺序。



### 6.3 集合初始化	

​		集合 初始化通常进行 **分配容量、设置特定参数** 等相关工作。我们以使用频率较高的 ArrayList 和 HashMap 为例，简要说明初始化的相关工作，**并解释为什么在任何情况下，都需要显式地设定集合容量的初始大小**。		

​		ArrayList 是存储单个元素的顺序表结构， HashMap 是存储 KV 键值对的哈希式结构。分析两者的初始化相关源码，洞悉它们的容量分配、参数设定等相关逻辑，有助于更好地了解集合特性，提升代码质量。下面先从ArrayList 源码说起：

```java
//JDK9 的源代码
package java.util;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import sun.misc.SharedSecrets;

/**
 * @see     Collection
 * @see     List
 * @see     LinkedList
 * @see     Vector
 * @since   1.2
 */

public class ArrayList<E> extends AbstractList<E>
        implements List<E>, RandomAccess, Cloneable, java.io.Serializable
{
    private static final long serialVersionUID = 8683452581122892189L;

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Shared empty array instance used for empty instances.
     * 空表的表示方法
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    transient Object[] elementData; // non-private to simplify nested class access
    private int size;
    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            //值大于0时，根据构造方法的参数值，忠实地创建一个多大的数组
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } 
    }
    
    // 公开的add方法调用此内部私有方法       
    private void add(E e, Object[] elementData, int s){
    // 当前数组能否容纳 size + 1 的元素，如果不够，则调用grow 来扩容
        if(s == elementData.length)
            elementData = grow();
        elementData[s] = e;
        size = s + 1; 
    }  
    
    private Object[] grow() {
        return grow(size + 1);
    }
    
    //扩容的最小要求，必须容纳刚才的元素个数 + 1，注意 newCapacity(minCapacity)方法才是扩容的重点  
    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData,
                                           newCapacity(minCapacity));
    }
    
     private int newCapacity(int minCapacity) {
        // overflow-conscious code
        //防止扩容 1.5 倍之后，超过int的表示范围（第1处）；
        int oldCapacity = elementData.length;
        // JDK6之前扩容 50% 或者 50%-1，但是取ceil,而之后的版本取 floor (第2处)；
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                // 无参数构造方法，会在此时分配默认为10的容量
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0) // overflow
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
            ? newCapacity
            : hugeCapacity(minCapacity);
    }   
}

```

​		第1处说明：正数带符号右移的值肯定是正值，所以 oldCapacity+(oldCapacity>> 1) 的结果可能超过 int 可以表示的最大值， 反而有可能比参数的 minCapacity 更小， 则返回值为（size＋1）的 minCapacity。
​		第2处说明：如果原始容量是 13 ， 当新添加个元素时， 依据程序中的计算方法，得出13 的二进制数为1101 ，随后右移1位操作后得到二进制数110 ，即十进制数6。最终扩容的大小计算结果为  oldCapacitiy + ( oldCapacity» 1) = 13 + 6 = 19 。使用位运算主要是基于计算效率的考虑。在 JDK7 之前的公式， 扩容计算方式和结果为 oldCapacitiy × 3÷2+1 = 13 × 3÷2 + 1 = 20  。
​		当 ArrayList 使用无参构造时，默认大小为10 ，也就是说在第次add 的时候，分配为 10 的容量，后续的每次扩容都会调用 Array. copyOf 方法，创建新数组再复制。可以想象， 假如需要将1000 个元素放置在 ArrayList  中，采用默认构造方法，则需要被动扩容 13 次才可以完成存储。反之，如果在初始化时便指定了容量 new ArrayList(l 000）， 那么在初始化 ArrayList 对象的时候就直接分配 1000 个存储空间，从而避免被动扩容和数组复制的额外开销。最后，进一步设想，如果这个值达到更大量级， 却没有注意初始的容量分配问题， 那么无形中造成的性能损耗是非常大的， 甚至导致OOM 的风险。



​		再来看一下 HashMap ， 如果它需要放置 1000 个元素， 同样没有设置初始窑量大小，随着元素的不断增加， 则需要被动扩容7 次才可以完成存储。扩窑时需要重建 hash 表，非常影响性能。在HashMap 中有两个比较重要的参数； Capacity 和 Load Factor ，其中Capacity 决定了存储容量的大小，默认为1 6 ，而 Load Factor 决定了填充比例，一般使用默认的 0.75 。基于这两个参数的乘积， HashMap 内部用 threshold 变量表示HashMap 中能放入的元素个数。HashMap 容量并不会在 new 的时候分配，而是在第一次 put 的时候完成创建的，源码如下

```java
public V put(K key , V value){
	if (table == EMPTY_TABLE) {
		inflateTable(threshold) ;
	}
	// ……省略代码
}

// 第一次 put 时，调用如下方法，初始化table
private void inflateTable(int toSize ) {
	// 找到大于参数且最接近 2 的幂值，假如输入参数是27，则返回32
	int capacity= roundUpToPowerOf2(toSize) ;
	// threshold 在不超过限制最大值的前提下等于capacity * loadFactor
	threshold= (int) Math.min(capacity * l oadFactor, MAXIMUM CAPACITY+ l );
	table= new Entry[capacity] ;
	initHashSeedAsNeeded(capacity) ;
}
```

​		为了提高运算速度，设定 HashMap 容量大小为 2的n次方，这样的方式使计算落槽位置更快。如果初始化HashMap 的时候通过构造器指定了 initialCapacity ，则会先计算出比 initialCapacity 大的 2的幕 存入 threshold ，在第一次 put 时会按照这个 2的幕 初始化数组大小，此后每次扩窑都是增加 2 倍。如果没有指定初始值， log2 1000 = 9.96，结合源码分析可知，如果想要容纳 1000 个元素，必须经过 7 次扩容。HashMap 的扩容还是有不小的成本的，如果提前能够预估出 HashMap 内要放置的元素数量，就可以在初始化时合理设置容量大小，避免不断扩容带来的性能损耗。
​		综上所述， 集合初始化时，指定集合初始值大小。如果暂时无法确定集合大小，那么指定相应的默认值，这也要求我们记得各种集合的默认值大小， ArrayList 大小为10 ， 而HashMap 默认值为16。牢记每种数据结构的默认值和初始化逻辑， 也是开发工程师基本素质的体现。





### 6.4 数组与集合

​		**数组是一种顺序表**，在各种高级语言中，它是组织和处理数据的一种常见方式，我们可以使用索引下标进行快速定位并获取指定位置的元素。

​		数组的下标从0 开始，但这并不符合生活常识，这源于BCPL 语言， 它将指针设置在0 的位置，用数组下标作为直接偏移量进行计算。为什么下标不从1开始呢？如果是这样，计算偏移量就要使用当前下标减 1 的操作。加减法运算对CPU 来说是种双数运算，在数组下标使用频率极富的场景下，这种运算是十分耗时的。

​		在 Java 体系中，**数组用以存储同一类型的对象，一旦分配内存后则无法扩容**。提倡类型与中括号紧挨着相连来定义数组，因为在Java 的世界里，万物皆为对象。String[] 用来指代String 数组对象

```java
String[] args = { "a","b"};
// 数组应用 赋值 给Object
Object obj = args;
// 使用类名 String[] 进行强制转化，并成功赋值，args[0]的值由 a 变为 object
((String[]) obj) [O] ＝ "object";
                  
String[] args3 = { "a","b"};
String[] args4 = new String[2];
args4[0] = "a";
args4[1] = "b"
```

​		args3 是静态初始化，而 args4 是动态初始化。无论静态初始化还是动态初始化，数组是固定容量大小的。注意在数组动态初始化时，出现了new ，这意昧着需要在 new String[] 的方括号内填写一个整数。如果写的是负数，并不会编译出错，但运行时会抛出异常： **NegativeArraySizeException**。 对于动态大小的数组，集合提供了 Vector 和 **ArrayList** 两个类，前者是线程安全，性能较差，基本弃用，而后者**是线程不安全，它是使用频率最高的集合之一。**

​		数组的遍历优先推荐 JDK5 引进的foreach 方式，即 for（元素：数组名）的方式，可以在不使用下标的情况下遍历数组。如果需要使用数组下标，则使用for (int i = 0; i < array.length; i ＋＋）的方式，注意length 是数组对象的一个属性，而不是方法（注: String 类是使用 length()方法 来获取字符串长度的）。也可以使用JDK8 的函数式接口进行遍历：

```java
Arrays.asList(args3).stream().forEach(x -> System.out.println(x)) ;
Arrays.asList(args3).stream().forEach(System.out::println);
```

​		**Arrays 是针对数组对象进行操作的工具类，包括数组的排序、查找、对比、拷贝等操作。尤其是排序，在多个 JDK 版本中在不断地进化，比如原来的归并排序改成 Timsort ，明显地改善了集合的排序性能。另外，通过这个工具类也可以把数组转成集合。**

​		**数组与集合都是用来存储对象的容器，前者性质单一，方便易用；后者类型安全，功能强大，且两者之间必然有互相转换的方式。**毕竟它们的性格迥异，在转换过程中，如果不注意转换背后的实现方式，很容易产生意料之外的问题。转换分成两种情况 **<u>数组转集合</u>** 和 <u>**集合转数组**</u>。

#### 数组转集合

​		在数组转集合的过程中，注意是否使用了 **视图方式** 直接返回数组中的数据。

​		我们以 **Arrays.asList()** 为例，它把数组转换成集合时，不能使用其修改集合相关的方法， 它的 add / remove / clear 方法会抛出 UnsupportedOperationException 异常。示例源码如下：

```java
package com.imooc.sell;

import java.util.Arrays;
import java.util.List;

public class ArraysAsList {
    public static void main(String[] args) {
        String[] stringArray = new String[3];
        stringArray[0] = "one";
        stringArray[1] = "two";
        stringArray[2] = "three";

        List<String> stringList = Arrays.asList(stringArray);
        // 修改转换后的集合，成功地把第一个元素 "one" 改成 "oneList"
        stringList.set(0,"oneList");
        System.out.println(stringArray[0]);

        
        // 这个是重点：以下三行编译正确，但都会抛出运行时异常
        stringList.add("four");
        stringList.remove(2);
        stringList.clear();
    }
}
```

​		事实证明，可以通过 set() 方法修改元素的值，原有数组相应位置的值同时也会被修改，但是 **不能进行修改元素个数的任何操作，否则均会抛出 UnsupportedOperationException 异常。**  Arrays.asList 体现的是 适配器模式，后台的数据仍是原有数组，set()  方法即闯接对数组进行值的修改操作。**asList 的返回对象是一个 Arrays 的内部类，它并没有实现集合个数的相关修改方法，这也正是抛出异常的原因。**

Arrays.asList 的源码如下

```java
public static <T> List<T> asList(T... a) {
        return new ArrayList<>(a);
    }
```

**返回的明明是 ArrayList  对象，怎么就不可以随心所欲地对此集合进行修改呢？注意此 ArrayList 非彼 ArrayList ，虽然 Arrays 与 ArrayList 同属于一个包，但是在Arrays 类中还定义了一个ArrayList 的内部类（或许命名为InnerArray List 更容易识别），根据作用域就近原则，此处的 ArrayList 是李鬼，即这是个内部类。此李鬼十分简单，只提供了个别方法的实现，如下所示**

```java
    private static class ArrayList<E> extends AbstractList<E>
        implements RandomAccess, java.io.Serializable
    {
        private static final long serialVersionUID = -2764017481108945198L;
        // final 修饰不准修改其引用（第一处）
        private final E[] a;
		
        // 直接把数组引用赋值给 a,而 Objects 是 JDK7 引入的工具包
        // requireNonNull 仅仅判断是否为null
        ArrayList(E[] array) {
            a = Objects.requireNonNull(array);
        }

        @Override
        public int size() {
            return a.length;
        }

        @Override
        public Object[] toArray() {
            return a.clone();
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] a) {
            int size = size();
            if (a.length < size)
                return Arrays.copyOf(this.a, size,
                                     (Class<? extends T[]>) a.getClass());
            System.arraycopy(this.a, 0, a, 0, size);
            if (a.length > size)
                a[size] = null;
            return a;
        }

        @Override
        public E get(int index) {
            return a[index];
        }

        @Override
        // 实现了修改特定位置元素的方法
        public E set(int index, E element) {
            E oldValue = a[index];
            a[index] = element;
            // 注意 set 成功返回的是此位置上的旧值
            return oldValue;
        }

        @Override
        public int indexOf(Object o) {
            E[] a = this.a;
            if (o == null) {
                for (int i = 0; i < a.length; i++)
                    if (a[i] == null)
                        return i;
            } else {
                for (int i = 0; i < a.length; i++)
                    if (o.equals(a[i]))
                        return i;
            }
            return -1;
        }

        @Override
        public boolean contains(Object o) {
            return indexOf(o) != -1;
        }

        @Override
        public Spliterator<E> spliterator() {
            return Spliterators.spliterator(a, Spliterator.ORDERED);
        }

        @Override
        public void forEach(Consumer<? super E> action) {
            Objects.requireNonNull(action);
            for (E e : a) {
                action.accept(e);
            }
        }

        @Override
        public void replaceAll(UnaryOperator<E> operator) {
            Objects.requireNonNull(operator);
            E[] a = this.a;
            for (int i = 0; i < a.length; i++) {
                a[i] = operator.apply(a[i]);
            }
        }

        @Override
        public void sort(Comparator<? super E> c) {
            Arrays.sort(a, c);
        }
    }
```

第1处的 final 引用，用于存储集合的数组引用始终被强制指向原有数姐。这个内部类并没有实现任何修改集合元素个数的相关方法， 那这个 UnsupportedOperationException 异常是从哪里抛出来的呢？是李鬼的父类
AbstractList ·

```java
public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {
	……
    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    public E remove(int index) {
        throw new UnsupportedOperationException();
    }
  
    // clear() 方法调用 remove 方法，依然抛出异常
    public void clear() {
        removeRange(0, size());
    }
	……
```

​		如果李鬼 Arrays.ArrayList 内部类覆写这些方法不抛出异常，避免使用者踩进这个坑会不会更好。**数组具有不为五斗米折腰的气节，传递的信息是 “要么直接用我，要么小心异常! ” **

​		**数组转集合引发的故障还是十分常见的。比如，某业务调用某接口时，对方以这样的方式返回一个 List 类型 的集合对象， 本方获取集合数据时， 99.9% 是只读操作，但在小概率情况下需要增加个元素，从而引发故障。在使用 数组转集合 时，需要使用李逵 java.util.ArrayList 直接创建一个新集合，参数就是 Arrays.asList 返回的不可变集合，**  源码如下:

```java
List<Object> objectList = new java.util.ArrayList<Object>(Arrays.asList(数组));
```



#### 集合转数组

​		**相对于数组转集合来说， 集合转数组 更加可控，毕竟是从相对自由的集合容器转为更加苛刻的数组。**<u>**什么情况下集合需要转成数组呢？适配别人的数组接口，或者进行局部方法计算等**</u>。先看一个源码，猜猜执行结果

```java
public class ListToArray {
public static void main(String [] args) {

```



执行结果如下:
[null , null ]
[one , two , three]
第1处比较容易理解，不要用 toArray() 无参方法把集合转换成数组，这样会导致泛型丢失，

第2 处执行成功后， 输出却为null ；

第3 处正常执行， 成功地把集合数据复制到array3 数组中。

第2 处与第3 处的区别在于即将复制进去的数组容量是否足够。如果容量不够，则弃用此数组，另起炉灶，关于此方法的源码如下

```java

```



在第1 处和第2 处均复制 java.util.ArrayList 的 elementData ~IJ 数组中，这
个elementData 是ArrayList 集合对象中真正用于存储数据的数组，它的定义为
transient Object[ ] elementData ； 。
这个存储ArrayList 真正数据的数组由transient 修饰，表示此字段在类的序列化
时将被忽略。因为集合序列化时系统会调用writeObject 写入流中，在网络客户端反
序列化的readObject 时，会重新赋值到新对象的e l ementData 中。为什么多此举？
因为elementData 容量经常会大于实际存储元素的数量，所以只需发送真正有实际值
的数组元素即可。回到刚才的场景，当入参数组容量小于集合大小时， 使用Arrays .
copyOf（）方法，它的源码如下

```java

```



我们用示例代码模拟可能出现的三种情况， 分别为入参数组窑量不够时、入参数
组容量刚好时，以及入参数组容量超过集合大小时，并记录其执行时间，

```java

```



​		

执行结果如下：
数组长度小于集合大小： n otEno ug hA rray T i m e : 12 . 317 152 ms
数组长度等于集合大小： equalArrayTime : 9 . 327377 ms
数组长度是集合的两倍： doubleArrayTime : 13 . 547622 ms
具体的执行时间， 由于CPU 资源占用的随机性， 会有一定差异。多次运行结果显示， 当数组容量等于集合大小时， 运行总是最快的，空间消耗也是最少的。由此证明，如果数组初始大小设置不当，不仅会降低性能，还会浪费空间。使用集合的toArray(T[] array） 方法，转换为数组时， 注意需要传人类型完全样的数组， 并且它的容量大小为 list.size()。





### 6.5 集合与泛型



### 6.6 元素的比较



### 6. 7 fail-fast 机制



### 6.8 Map 类集合

#### 6.8.1 红黑树

#### 6.8.2 TreeMap

#### 6.8.3 HashMap

#### 6.8.4 ConcurrentHashMap		









## 第7章 并发与多线程

​		是以驷牡异力，而六辔如琴，并驾齐驱，而一毂统辐：驭文之法，有似于此。行文如此，并发亦如此。











## 第8章 单元测试

​		祸乱生于疏忽，单元测试先于交付。穿越暂时黑暗的时光隧道，才能迎来系统的曙光。









## 第9章 代码规约

车同轨、书同文。手册源起，不忘初心，伯牙子期，琴瑟共鸣。





























