package cn.sunyu.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: hrqx
 * @Date: 2019/4/8 9:44
 */
@RestController
public class ResourceController {

    @RequestMapping(value = "/read_user_info", method = RequestMethod.GET)
    public String getResource() {
        return "helloWorld";
    }
}
