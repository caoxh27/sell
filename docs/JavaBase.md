# Java基础概念

## 1.1 不可变类

​		**不可变类 （Immutable class） 是指当一个对象被创建出来以后，它的值就不能被修改了，也就是说，一个对象一旦被创建出来，在其整个生命周期中，它的成员变量就不能被修改了。它有点类似于常量（const），只允许别的程序读，而不允许别的程序进行修改。**

​		在 Java类 库中，所有基本类型的包装类都是不可变类，例如Integer、Float等。此外，String也是不可变类。可能有人会有疑问，既然 String 是不可变类，那么为什么还可以写出如下代码来修改String类型的值呢？

```Java
public class StringTest {
    public static void main(String[] args) {
        String s = "Hello";
        s+=" word";
        System.out.println(s);
    }
}
//表面上看，好像是修改String类型对象s的值。其实不是，
//String s=“Hello” 语句声明了一个可以指向String类型对象的引用，这个引用的名字为s，它指向了一个字符串常量 “Hello”。
//s+=" world" 并没有改变s所指向的对象（由于“Hello”是String类型的对象，而String又是不可变量），
//这句代码运行后，s指向了另外一个String类型的对象，该对象的内容为“Hello world”。
//原来的那个字符串常量“Hello”还存在与内存中，并没有被改变。
```

​		在介绍完不可变类的基本概念后，下面主要介绍如何创建一个不可变类。通常来讲，要创建一个不可变类需要遵循下面五条基本原则：

​		**1）类中所有的成员变量被private所修饰。**
​		**2）类中没有写或者修改成员变量的方法，例如：setxxx。只提供构造函数，一次生成，永不改变。**
​		**3）确保类中所有的方法不会被子类覆盖，可以通过 <u>把类定义为final</u> 或者 把类中的方法定义为final 来达到这个目的。**
​		**4）如果一个类成员不是不可变量，那么在成员初始化或者使用get方法获取该成员变量是需要通过clone方法，来确保类的不可变性。**
​		**5）如果有必要，可以通过覆盖Object类的equals()方法和hashCode()方法。在equals()方法中，根据对象的属性值来比较两个对象是否相等，并且保证用equals()方法判断为相等的两个对象的hashCode()方法的返回值也相等，这可以保证这些对象能正确地放到HashMap或HashSet集合中。**
​		**除此之外，还有一些小的注意事项：由于类的不可变性，在创建对象的时候就需要初始化所有的成员变量，因此最好提供一个带参数的构造函数来初始化这些成员变量。**

​		下面通过给出一个错误的实现方法与正确的实现方法来说明在实现这种类的时候需要特别注意的问题。首先给出一个错误的实现方法，示例代码如下所示：

```java
package com.imooc.sell;
import java.util.Date;
class WrongImmutableClass {
    private Date d;
    public WrongImmutableClass(Date dp) {
        this.d = dp;
    }
    public void printState(){
        System.out.println("WrongImmutableClass d = " + d);
    }
}
class RightImmutableClass {
    private Date d;
    public RightImmutableClass(Date dp) {
        this.d = (Date) dp.clone(); //解除与d的应用关系
    }
    public void printState(){
        System.out.println("RightImmutableClass d = " + d);
    }
    public Date getDate() {
        return (Date) d.clone(); //解除与d的应用关系
    }
}
public class TestImmutable{
    public static void main(String[] args) {
        Date d1 = new Date();
        Date d2 = new Date();

        WrongImmutableClass wImmuC = new WrongImmutableClass(d1);
        wImmuC.printState();
        d1.setMonth(5);
        wImmuC.printState();
        //需要说明的是，由于Date的对象的状态是可以被改变的，
        //而 WrongImmutableClass 保存了Date类型对象的引用，
        //被引用的对象的状态改变的时候会导致 WrongImmutableClass 对象状态的改变。

        RightImmutableClass rImmuC = new RightImmutableClass(d2);
        rImmuC.printState();
        d2.setMonth(5);
        rImmuC.printState();
    }
}	
```

​		**在Java语言中，之所以设计有很多不可变类，主要是因为不可变类具有使用简单、线程安全、节省内存等优点，但凡事有利就有弊，不可变类自然也不例外，例如，不可变的对象会因为值的不同而产生新的对象，从而导致无法预料的问题，所以，切不可滥用这种模式。**

​		**引申：对于一些敏感的数据（例如密码），为什么使用字符数组存储比使用String更安全？**

​		答案：在Java语言中，String是不可变类，它被存储在常量字符串池中，从而实现了字符串的共享，减少了内存的开支。正因为如此，一旦一个String类型的字符串被创建出来，这个字符串就会存在于常量池中，直到被垃圾回收器回收为止。因此，即使这个字符串（比如密码）不再被使用，它仍然会在内存中存在一段时间（只有垃圾回收器才会回收这块内容，程序员没有办法直接回收字符串）。 **此时有权限访问 memory dump （存储器转储）的程序都可能会访问到这个字符串，从而把敏感的数据暴露出去，这是一个非常大的安全隐患。**  <u>如果使用字符数组，那么一旦程序不再使用这个数据，程序员就可以把字符数组的内容设置为空，此时这个数据在内存中就不存在了。从以上分析可以看出，与使用String相比，使用字符数组，程序员对数据的生命周期有更好的控制，从而可以增强安全性。</u>



## 1.2 “==”、equals与hashcode

“==”、equals与hashcode的作用类似，但也各有不同。
		**1）“==”运算符 用来比较 两个变量的值 是否相等，也就是用于比较 变量所对应的内存中所存储的数值 是否相同，要比较两个基本类型的数据或两个引用变量是否相等，只能使用“==”运算符。**
		具体而言，如果两个变量是基本数据类型，那么可以直接使用“==”运算符来比较其对应的值是否相等。 **如果一个变量指向的数据是对象（引用类型），那么，此时涉及了两块内存，对象本身占用一块内存（堆内存），变量也占用一块内存。例如，对于赋值语句String s=new String()，变量s占用一块存储空间，而new String()则存储在另外一块存储空间里，此时，变量s所对应的内存中存储的数值就是对象占用的那块内存的首地址。**  对于指向对象类型的变量，如果要比较两个变量是否指向同一个对象，那么要看这两个变量所对应的内存中的数值是否相等（这两个对象是否指向同一块存储空间），这时候就可以用“==”运算符进行比较。**但是，如果要比较这两个对象的内容是否相等，那么用“==”运算符就无法实现了。**

​		2）equals是Object类提供的方法之一，因为每一个Java类都继承自Object类，所以每一个对象都具有equals这个方法。 **因为Object类中定义的equals(Object)方法是直接使用“==”运算符比较的两个对象，所以在没有覆盖equals(Object)方法的情况下，equals(Object)与“==”运算符一样，比较的是引用。**
​		**相比“==”运算符，因为equals(Object)方法的特殊之处就在于它可以被覆盖，所以可以通过覆盖的方法让它不是比较引用而是比较数据内容。例如String类的equals方法是用于比较两个独立对象的内容是否相同，即堆中的内容是否相同。** 例如，对于下面的代码：

```
		String s1 = new String("Hello");
		String s2 = new String("Hello");
```

​		两条new语句创建了两个对象，然后用s1、s2这两个变量分别指向了一个对象，这是两个不同的对象，它们的首地址是不同的，即a和b中存储的数值是不相同的，所以，表达式s1==s2将返回false，而这两个对象中的内容是相同的，所以，表达式 s1.equals(s2)将返回true。
​		如果一个类没有自己定义equals方法，那么它将继承Object类的equals方法，Object类的equals方法的实现代码如下所示：

```
		boolean equals(Object o)
		{
				return this ==o;
		}
```

​		通过以上例子可以看出，如果一个类没有自己定义equals方法，那么它默认的equals方法（从Object类继承的）就是使用“==”运算符，也是在比较两个变量指向的对象是否是同一对象，此时使用equal方法和使用“==”运算符会得到同样的结果，如果比较的是两个独立的对象，那么返回false。如果编写的类希望能够比较该类创建的两个实例对象的内容是否相同，那么必须覆盖equals方法，由开发人员自己写代码来决定在什么情况即可认为两个对象的内容是相同的。

​		**3）hashCode()方法是从Object类中继承过来的，它也用来鉴定两个对象是否相等。Object类中的hashCode()方法返回对象在内存中地址转换成的一个int值，所以如果没有重写hashCode()方法，那么任何对象的hashCode()方法都是不相等的。**
​		虽然equals方法也是用来判断两个对象是否相等的，但是二者是有区别的。**一般来讲，equals方法是给用户调用的，如果需要判断两个对象是否相等，那么可以重写equals方法，然后在代码中调用，就可以判断它们是否相等了。对于hashCode()方法，用户一般不会去调用它，例如在hashmap中，由于key是不可以重复的，它在判断key是否重复的时候就判断了hashCode()这个方法，而且也用到了equals方法。此处“不可以重复”指的是equals和hashCode()只要有一个不等就可以了。所以，hashCode()相当于是一个对象的编码，就好像文件中的md5，它与equals方法的不同之处就在于它返回的是int型，比较起来不直观。**
​		**一般在覆盖equals方法的同时也要覆盖hashCode()方法，否则，就会违反Object.hashCode的通用约定，从而导致该类无法与所有基于散列值(hash)的集合类（HashMap、HashSet和Hashtable）结合在一起正常运行。**
hashCode()方法的返回值和equals方法的关系如下所示：如果x.equals(y)返回true，即两个对象根据equals方法比较是相等的，那么调用这两个对象中任意一个对象的hashCode()方法都必须产生同样的整数结果。如果x.equals(y)返回false，即两个对象根据equals()方法比较是不相等的，那么x和y的hashCode()方法的返回值有可能相等，也有可能不等。反过来，hashCode()方法的返回值不等，一定能推出equals方法的返回值也不等，而hashCode()方法的返回值相等，equals方法的返回值则可能相等，也可能不等。



## 1.3 值传递与引用传递

按值传递指的是在方法调用时，传递的参数是实参值的拷贝。

按引用传递指的是在方法调用时，传递的参数是实参的引用，也可以理解为实参所对应的内存空间的地址。
为了理解Java语言中的值传递与引用传递，首先给出下面的示例代码：





## 1.4 Java关键字

### 1.4.1 static

​		static关键字主要有两个作用：

​		第一，为某特定数据类型或对象分配单一的存储空间，而与创建对象的个数无关。

​		第二，实现 某个方法或属性与类  而不是与对象关联在一起，也就是说，在不创建对象的情况下就可以通过类来直接使用类的方法或者属性。

​		这一节将简要介绍一下static的作用。​		

（1）可修饰的元素
		变量：		静态变量，可以跨越代码块访问。
		方法：		静态方法，可以跨越代码块访问。
		代码块：	静态代码块，只能定义在类定义下，在类被加载时执行。
		内部类：	静态内部类，该类定义可以由外部类名引用。
		导入包：	静态导入包，导入指定的static变量。
		

（2）详细说明
		**static，静态，表示随着类的加载而加载，不会重复加载，执行顺序在main方法之前。在JVM内存里，static修饰的变量存在于方法区中。**



### 1.4.2 final

​		**final用于声明属性、方法和类，分别表示属性不可变、方法不可覆盖、类不可被继承（不能再派生出新的子类）。**



​		**final属性**：被final修饰的变量不可变，由于不可变有两重含义，一是引用不可变，二是对象不可变。那么final到底指的是哪种含义呢？下面通过一个例子来进行说明。





​		从以上例子中可以看出，**final指的是引用的不可变性，即它只能指向初始时指向的那个对象，而不关心指向对象内容的变化。所以，被final修饰的变量必须被初始化。**

一般可以通过以下几种方式对其进行初始化：

​		①在定义的时候初始化；

​		②**final成员变量**          可以在初始化块中初始化，但不可在静态初始化块中初始化；

​		③**静态final成员变量**  可以在静态初始化块中初始化；

​		④在类的构造器中初始化，但  **静态final成员变量**  不可以在构造方法中初始化。





​		**final方法**：当一个方法声明为final时，该方法不允许任何子类重写这个方法，但子类仍然可以使用这个方法。另外还有一种被称为inline（内联）的机制，当调用一个被声明为final的方法时，直接将方法主体插入到调用处，而不是进行方法调用（类似于C++语言中的inline），这样做能提高程序的效率。



​		**final参数**：用来表示这个参数在这个方法内部不允许被修改。
​		**final类**：	**当一个类被声明为final时，此类不能被继承，所有方法都不能被重写。但这并不表示final类的成员变量也是不可改变的，要想做到final类的成员变量不可改变，必须给成员变量增加final修饰。**  

​		值得注意的是，一个类不能既被声明为abstract，又被声明为final。

​		引申：为什么匿名内部类只能使用成员变量或者被final修饰的局部变量呢？
​		这是因为匿名内部类的生存期可能比一般的局部变量更久。
例如一个Runable的实现体，有可能在数秒之后才被调用，而它的外部方法体已经随着代码执行完毕而消亡了，之前定义在外部方法体内的变量随着方法区内存的回收也一起消亡了。
而被final修饰的局部变量在匿名内部类中有一个引用的副本，由于它本身不可被修改引用，所以可以在开发期认为final局部变量和内部类的引用副本是同一个引用。





### 1.4.3 transient

​		**Java的 serialization 提供了一种持久化对象实例的机制。当持久化一个对象时，可能并不想持久化所有的属性。对于这种情况，可以通过在属性前加上关键字transient来实现。**
​		例如以下代码是SuperClass和Sub两个类的定义。在序列化一个Sub的对象Sub到文件时，只有radius会被保存到文件中。
​		在分布式环境下，当进行远程通信时，无论是何种类型的数据，都会以二进制序列的形式在网络上传送。序列化是一种将对象转换成字节序列的过程，用于解决在对对象流进行读写操作时所引发的问题。序列化可以将对象的状态写在流里进行网络传输，或者保存到文件、数据库等系统里，并在需要的时候把该流读取出来重新构造成一个相同的对象。
​		如何实现序列化呢？其实，所有要实现序列化的类都必须实现Serializable接口，Serializable接口位于java.lang包中，它里面没有包含任何方法。使用一个输出流（例如FileOutputStream）来构造一个ObjectOutputStream（对象流）对象，紧接着，使用该对象的writeObject（Object obj）方法就可以将obj对象写出（即保存其状态），要恢复的时候可以使用其对应的输入流。
具体而言，序列化有如下几个特点：
1）如果一个类能被序列化，那么它的子类也能够被序列化。
2）由于static（静态）代表类的成员，transient（Java语言关键字，如果用transient声明一个实例变量，那么当对象存储时，它的值不需要维持）代表对象的临时数据，因此，被声明为这两种类型的数据成员是不能够被序列化的。
3）子类实现了Serializable接口，父类没有，父类中的属性不能序列化，但是子类中的属性仍能正确序列化。

### 1.4.4 volatile

​		该字段用于修饰会被多线程访问属性，以保持修改对所有线程可见。
​		相比于synchronized，它仅用于修饰字段，且它只保持线程安全三要素中的可见性和有序性，并不保证操作的原子性。所以，它不严格地保证线程安全。
​		volatile的实现基于内存栅栏（Memory Barrier）。
​		一个volatile字段在修改时，JVM会执行一个Write-Barrier操作，该操作将当前处理器缓存的数据写回系统内存，并且使其他CPU核心里引用了该地址的数据变成脏数据。
​		当读取时，JVM会多执行一个Read-Barrier指令，如果该数据已经变脏，那么从主存中重新获取数据。





# Collection框架