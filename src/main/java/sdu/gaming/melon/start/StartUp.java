package sdu.gaming.melon.start;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动类
 *
 * @author xuliang
 */
public class StartUp {
    public static void main(String args[]) throws Exception {
        //这里注意spring配置文件的名字和路径
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:spring.xml"});
        applicationContext.start();
        System.in.read();
    }
}
