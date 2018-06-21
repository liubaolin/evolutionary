package top.evolutionary.springbootdemo.repository.secdary;

import org.springframework.data.jpa.repository.JpaRepository;
import top.evolutionary.springbootdemo.dto.secdary.Company;

public interface CompanyRepository extends JpaRepository<Company,Long> {
}
