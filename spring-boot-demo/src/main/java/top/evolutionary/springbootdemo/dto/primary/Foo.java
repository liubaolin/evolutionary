package top.evolutionary.springbootdemo.dto.primary;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author richey
 */
@Entity
@Data
@NoArgsConstructor
public class Foo {


    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

}
