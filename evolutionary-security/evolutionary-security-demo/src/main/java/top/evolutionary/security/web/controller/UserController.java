package top.evolutionary.security.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.evolutionary.security.dto.User;
import top.evolutionary.security.dto.UserQueryCondition;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult erros) {

        if (erros.hasErrors()) {
            erros.getAllErrors().forEach(effor -> {
                System.out.println(effor.getDefaultMessage());
            });
        }

        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        System.out.println(user.getId());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult erros) {

        if (erros.hasErrors()) {
            erros.getAllErrors().forEach(error -> {
//                FieldError fieldError = (FieldError) error;
//                String message = fieldError.getField() + " " + error.getDefaultMessage();
                System.out.println(error.getDefaultMessage());

            });
        }

        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        System.out.println(user.getId());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition condition, @PageableDefault(size = 5, page = 2, sort = "age,asc") Pageable pageable) {
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


    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id) {
        User user = new User();
        user.setUserName("richey");
        user.setPassword("123456");
        return user;

    }

}
