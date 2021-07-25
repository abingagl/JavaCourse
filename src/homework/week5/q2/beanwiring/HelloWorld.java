package homework.week5.q2.beanwiring;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/07/25
 */
public class HelloWorld {
    private String message;

    public HelloWorld() {
        super();
    }

    public HelloWorld(String message) {
        super();
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void say() {
        System.out.println("say hello world!");
    }
}
