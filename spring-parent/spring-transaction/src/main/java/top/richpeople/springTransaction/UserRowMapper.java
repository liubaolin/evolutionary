package top.richpeople.springTransaction;

import org.springframework.jdbc.core.RowMapper;
import top.richpeople.springTransaction.vo.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author richey
 */
public class UserRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        User person = new User(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("sex"));
        return null;
    }
}
