package com.luo.mmconcurrent.example.singleton;


import com.luo.mmconcurrent.annotation.Recommend;
import com.luo.mmconcurrent.annotation.ThreadSafe;

@ThreadSafe
@Recommend
public class SingletonExample7 {

    private SingletonExample7() {
    }

    public SingletonExample7 GetInstance(){
        return Singleton.INSTANCE.getSingleton();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singleton;

        // JVM保证这个方法绝对只调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getSingleton() {
            return singleton;
        }
    }
}
