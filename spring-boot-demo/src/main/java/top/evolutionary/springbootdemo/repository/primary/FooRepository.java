package top.evolutionary.springbootdemo.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import top.evolutionary.springbootdemo.dto.primary.Foo;

public interface FooRepository extends JpaRepository<Foo,Long> {
}
