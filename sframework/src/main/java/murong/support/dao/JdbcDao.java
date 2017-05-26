package murong.support.dao;

import murong.example.Goods;
import murong.example.GoodsRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by murong on 2017/5/18.
 */
@Repository
@Configuration
public class JdbcDao {

    private JdbcOperations jdbcOperations = null;

    @Autowired
    @Qualifier("jdbcTemplate")
    public void setJdbcDao(JdbcOperations jdbcOperations){
        this.jdbcOperations = jdbcOperations;
    }

    public Goods findOne(){
        return jdbcOperations.queryForObject("select * from goods where id = ?;",new GoodsRowMapper(),3);
    }
}
