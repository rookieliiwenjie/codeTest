1、synchronized修饰普通方法时，锁的是方法所在类的对象，等同于synchronized(this){}。

2、synchronized修饰static方法时，锁的是方法所在类的class，等同于synchronized(类的clas){}。


3、synchronized修饰代码块时，锁是括号里的参数，括号中的参数一致时(==)，则会形成互斥。

4、在使用synchronized时，用代码块更灵活，尽量缩小其影响范围