package com.testautomation.mesaj.database;

public enum DatabaseType {

    SQL_SERVER("org.hibernate.dialect.SQLServerDialect"),
    MYSQL("org.hibernate.dialect.MySQL57Dialect"),
    ORACLE("org.hibernate.dialect.OracleDialect");

    private String dialect;

    public String getDialect() {
        return dialect;
    }

    DatabaseType(String dialect) {
        this.dialect = dialect;
    }
}
