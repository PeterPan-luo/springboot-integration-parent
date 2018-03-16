package com.study.mmdao.config;

/**
 * 数据源类型
 */
public enum DatabaseType {
    master("write"),
    salve("read");

    DatabaseType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
