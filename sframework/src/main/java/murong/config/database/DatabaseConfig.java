package murong.config.database;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by murong on 2017/5/17.
 */
@Configuration
public class DatabaseConfig {

    //使用阿里的durid数据源
    @Bean(name = "druidDataSource")
    public DruidDataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1/test?prepStmtCacheSize=517&cachePrepStmts=true&autoReconnect=true&characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("mysql@cjsong39");
        //dataSource.setInitialSize(5);//池启动时创建的连接数量
        dataSource.setMaxActive(500);//同一时间可从池中分配的最多连接数，如果设置为0，表示无限制

        return dataSource;
    }

    //JDBC模板类
    @Bean
    @Qualifier("jdbcTemplate")
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource){
        return new JdbcTemplate(druidDataSource);
    }


}

