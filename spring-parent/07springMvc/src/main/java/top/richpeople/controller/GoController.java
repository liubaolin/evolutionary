package top.richpeople.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoController {

    /**
     * 处理HEAD类型的"/"请求
     * 此方法可以用来检测服务器的状态,因为它不返回body,所以笔GET请求更节省网络资源
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.HEAD)
    public String head() {
        return "go.jsp";
    }

    /**
     * 处理GET类型的"/index"和"/"请求
     */
    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String testMapPathUri(Model model) {

        model.addAttribute("msg", "Go Go Go!");
        return "go.jsp";
    }

}
