package top.evolutionary.security.web;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.evolutionary.security.dto.User;
import top.evolutionary.security.dto.UserQueryCondition;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping(value = "/user")
    public List<User> query(UserQueryCondition condition,@PageableDefault(size = 5,page = 2,sort = "age,asc") Pageable pageable) {
        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

}
