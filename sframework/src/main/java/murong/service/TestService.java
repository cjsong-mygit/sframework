package murong.service;

import murong.support.dao.JdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by murong on 2017/5/18.
 */
@Service
public class TestService {

    private JdbcDao jdbcDao;

    @Autowired
    public TestService(JdbcDao jdbcDao){
        this.jdbcDao = jdbcDao;
    }



}
