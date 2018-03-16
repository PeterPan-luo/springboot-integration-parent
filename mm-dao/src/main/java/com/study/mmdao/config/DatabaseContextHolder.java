package com.study.mmdao.config;

/**
 *保存一个线程安全的DatabaseType容器
 * 用于保存数据源类型
 */
public class DatabaseContextHolder {

    private  static  final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();

    public static DatabaseType getDatabaseType(){
        return contextHolder.get();
    }

    public static void setDatabaseType(DatabaseType databaseType){
        contextHolder.set(databaseType);
    }
}

