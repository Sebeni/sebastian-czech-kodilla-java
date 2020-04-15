package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StoredProcTestSuite {
    @Test
    public void testUpdateVipLevels() throws SQLException {
//        GIVEN
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "UPDATE readers SET vip_level='Not set'";
        Statement statement = dbManager.getConnection().createStatement();
        statement.execute(sqlUpdate);
        
//        WHEN
        String sqlProcedureCall = "CALL UpdateVipLevels()";
        statement.execute(sqlProcedureCall);
        
//        THEN
        String sqlCheckTable = "SELECT COUNT(*) AS how_many FROM readers WHERE vip_level='Not set'";
        ResultSet resultSet = statement.executeQuery(sqlCheckTable);
        
        int howManyNotSet = -1;
        
        while(resultSet.next()) {
            howManyNotSet = resultSet.getInt("how_many");
        }

        Assert.assertEquals(0, howManyNotSet);
        
    }
}
