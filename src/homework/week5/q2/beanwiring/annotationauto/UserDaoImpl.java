package homework.week5.q2.beanwiring.annotationauto;

import org.springframework.stereotype.Repository;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/07/25
 */
@Repository("userDao")
public class UserDaoImpl implements com.demo.UserDao {
    @Override
    public void save() {
        System.out.println("userdao..save..");
    }
}
