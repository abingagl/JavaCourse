package demo.week5.spring;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/07/23
 */
public class HelloWorld {
    private String message;
    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("Your Message : " + message);
    }
}
