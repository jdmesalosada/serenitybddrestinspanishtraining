package com.testautomation.mesaj.database;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class DatabaseConnectionInfo {

    private final DatabaseType databaseType;
    private final String url;
    private final String username;
    private final String password;
    private final List<String> entityNames;

}
