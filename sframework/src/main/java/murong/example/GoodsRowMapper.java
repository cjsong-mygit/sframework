package murong.example;


import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by murong on 2017/5/20.
 */
public class GoodsRowMapper implements RowMapper<Goods> {

        public Goods mapRow(ResultSet resultSet, int i) throws SQLException {
            Goods goods = new Goods();
            goods.setId(resultSet.getLong("id"));
            goods.setName(resultSet.getString("name"));
            return goods;
        }
}
