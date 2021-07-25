package homework.week5.q2.beanwiring.annotationauto;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/07/25
 */

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name="userDao")
    private UserDao userDao;
    @Override
    public void save() {
        this.userDao.save();
        System.out.println("userservice.save");
    }
}
