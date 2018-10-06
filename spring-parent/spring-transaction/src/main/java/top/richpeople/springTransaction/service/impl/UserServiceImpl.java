package top.richpeople.springTransaction.service.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import top.richpeople.springTransaction.service.UserService;
import top.richpeople.springTransaction.vo.User;

import javax.sql.DataSource;
import java.sql.Types;

/**
 * @author richey
 */
public class UserServiceImpl implements UserService {

    private JdbcTemplate jdbcTemplate;


    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void save(User user) throws Exception {
        jdbcTemplate.update("insert into user(name,age,gender) values(?,?,?)",
                new Object[]{user.getName(), user.getAge(), user.getGender()},
                new int[]{Types.VARBINARY, Types.INTEGER, Types.VARBINARY});
//        throw new RuntimeException("事务测试,抛出运行时异常事务回滚,数据不会入库");
    }


}
