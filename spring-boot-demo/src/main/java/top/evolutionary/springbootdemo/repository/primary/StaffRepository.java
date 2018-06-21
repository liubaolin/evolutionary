package top.evolutionary.springbootdemo.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import top.evolutionary.springbootdemo.dto.primary.Staff;

public interface StaffRepository extends JpaRepository<Staff,Long> {
}
