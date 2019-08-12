package com.clicdirectory.database;


import com.clicdirectory.SysProperties;

import java.sql.SQLException;

public class DatabaseUtil {
    private static DatabaseConnectionPool databaseConnectionPool;

    static {
        try {
            databaseConnectionPool = new DatabaseConnectionPool(
                    SysProperties.getInstance().getProperty("DB_URL")+SysProperties.getInstance().getProperty("DB_NAME"), SysProperties.getProperty("DB_USERNAME"),  SysProperties.getProperty("DB_PASSWORD"), 350, 350);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseConnectionPool getDataseBaseConnectionPool() {
        return databaseConnectionPool;
    }
}