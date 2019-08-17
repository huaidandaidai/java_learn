#Object 类详解
Object类位于java.lang包下，全类名为java.lang.Object
## Object类的作用
Object类为Java语言中的万类之祖，所有的类都继承自Object类，并且实现Object类的方法,详细解释见类注释。
Object类包含一个静态代码块，12个方法(1个private、1个protected、10个public)

### static代码块
    static {
        registerNatives();
    }
 
### registerNatives方法
    private static native void registerNatives();
    
### getClass方法
    public final native Class<?> getClass();
###  hashCode方法
    public native int hashCode();
### equals方法

    public boolean equals(Object obj) {
        return (this == obj);
    }

### clone方法
    protected native Object clone() throws CloneNotSupportedException;

### toString方法
    
    public String toString() {
            return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }

### notify
    public final native void notify();

### notifyALL

    public final native void notifyAll();

### wait

    public final native void wait(long timeout) throws InterruptedException;
    
    public final void wait(long timeout, int nanos) throws InterruptedException {
            if (timeout < 0) {
                throw new IllegalArgumentException("timeout value is negative");
            }
    
            if (nanos < 0 || nanos > 999999) {
                throw new IllegalArgumentException(
                                    "nanosecond timeout value out of range");
            }
    
            if (nanos >= 500000 || (nanos != 0 && timeout == 0)) {
                timeout++;
            }
    
            wait(timeout);
    }
    
    public final void wait() throws InterruptedException {
            wait(0);
        }

### finalize
    protected void finalize() throws Throwable { }
    


## Object类的骚操作