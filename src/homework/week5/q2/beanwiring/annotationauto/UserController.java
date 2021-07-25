package homework.week5.q2.beanwiring.annotationauto;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/07/25
 */
@Controller("userController")
public class UserController {
    @Resource(name="userService")
    private UserService userService;

    public void save() {
        this.userService.save();
        System.out.println("usercontroller.save");
    }
}
