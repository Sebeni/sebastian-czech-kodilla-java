package com.kodilla.jdbc;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.Assert.*;

public class StoredProcTestSuite {
    private static DbManager dbManager;
    @BeforeClass
    public static void createConn() throws SQLException{
        dbManager = DbManager.getInstance();
    }
    
    
    @Test
    public void testUpdateVipLevels() throws SQLException {
//        GIVEN
        Statement statement = dbManager.getConnection().createStatement();
        String sqlUpdate = "UPDATE readers SET vip_level='Not set'";
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
        resultSet.close();
        statement.close();

        assertEquals(0, howManyNotSet);
        
    }
    
    @Test
    public void testUpdateBestSellers() throws SQLException {
        Statement statement = dbManager.getConnection().createStatement();
        String sqlSetNull = "UPDATE books SET bestseller = NULL";
        statement.execute(sqlSetNull);
        
        String callUpdateBestsellers = "CALL UpdateBestSellers()";
        statement.execute(callUpdateBestsellers);
        
        String countHowManyNulls = "SELECT SUM(CASE WHEN bestseller IS NULL THEN 1 END) AS num_of_nulls FROM books";
        ResultSet rs = statement.executeQuery(countHowManyNulls);
        
        int numOfNulls = -1;

        while(rs.next()) {
            numOfNulls = rs.getInt("num_of_nulls");
        }
        rs.close();
        statement.close();

        assertEquals(0, numOfNulls);
    }
}
