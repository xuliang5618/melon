package sdu.gaming.melon.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 该类依赖于IOC容器, 注意不要在IOC初始化前调用
 *
 * @author x
 */
public class SpringHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    // 修改之前的逻辑，从web容器启动时加载的那个spring容器中获取bean，防止出现2个spring容器
    public static Object getBean(String beanid) {
        checkApplicationContext();
        return applicationContext.getBean(beanid);
    }

    private static void checkApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("applicaitonContext not set!");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        if (ac != null)
            SpringHelper.applicationContext = ac;
    }
}
