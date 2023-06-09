package com.itwill.post.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// 
public class HikariDataSourceUtil {
    // singleton
    private static HikariDataSourceUtil instance = null;
    
    private HikariDataSource ds;
    
    private HikariDataSourceUtil() {
        // HikariCP를 사용하기 위한 환경 설정 객체
        HikariConfig config = new HikariConfig();
        
        // CP(Data Source)을 생성하기 위한 설정들:
        config.setDriverClassName("oracle.jdbc.OracleDriver");
        config.setJdbcUrl("jdbc:oracle:thin:@192.168.20.31:1521:xe");
        config.setUsername("scott");
        config.setPassword("tiger");
        
        // CP(Data Source) 객체 생성
        ds = new HikariDataSource(config);
    }
    
    public static HikariDataSourceUtil getinstance() {
        if (instance == null) {
            instance = new HikariDataSourceUtil();
        }
        return instance;
    }
    
    public HikariDataSource getDataSource() {
        return ds;
    }
    
}
