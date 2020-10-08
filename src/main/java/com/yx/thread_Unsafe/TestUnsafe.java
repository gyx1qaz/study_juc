package com.yx.thread_Unsafe;


import sun.misc.Unsafe;

/**
 * Unsafe
 */
public class TestUnsafe {
    // 获取Unsafe的实例2.2.1
    static final Unsafe unsafe = Unsafe.getUnsafe();
    // 记录变量sate在类TestUnsafe中的偏移量
    static final long stateOffset = 0;

    //变量2.2.3
    private volatile long state=0;

    static {
        
    }
    
        public static void main(String[] args) {

    }
}
