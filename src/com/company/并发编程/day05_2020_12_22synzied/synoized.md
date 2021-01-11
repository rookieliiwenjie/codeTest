1、synchronized修饰普通方法时，锁的是方法所在类的对象，等同于synchronized(this){}。

2、synchronized修饰static方法时，锁的是方法所在类的class，等同于synchronized(类的clas){}。


3、synchronized修饰代码块时，锁是括号里的参数，括号中的参数一致时(==)，则会形成互斥。

4、在使用synchronized时，用代码块更灵活，尽量缩小其影响范围

方法同步代码块和代码块同步是不一样的


1、方法是在方法上加关键字synchronized


2、代码块则是在代码中插入monitorentry和monitorexit，monitorexit是两次因为他要
确保不会死锁。同时需要保证monitorentry和monitorexit是成对出现的。任何
对象都于monitor关联，当且一个monitor被劫持后就处于被锁定的状态。

对象头：对象头包括markwork（hashcode 分代年龄段，锁标志位）

如果对象是数组类型，那么在32位虚拟机用三个字宽，一个字宽等于4个字节，如果是非数组类型
那么用2个字宽存储对象头，

