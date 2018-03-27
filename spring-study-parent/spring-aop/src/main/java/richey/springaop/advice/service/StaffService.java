package richey.springaop.advice.service;

import richey.springaop.advice.entity.Staff;

import java.sql.SQLException;

/**
 * @author richey
 */
public class StaffService {

    public void removeStaff(int staffId) {
        //do sth..
        throw new RuntimeException("运行异常。");
    }

    public void updateStaff(Staff staff) throws SQLException {
        //do sth..
        throw new SQLException("数据更新操作异常");
    }

}
