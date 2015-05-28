/**
 * Lacus
 * hitwh.yxx.lacus.beanFactoryPostProcessor
 * 
 */
package hitwh.zcc.CA.util;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;


/**
 * @author lacus 
 * <br>2015年4月15日
 * <br>说明：这是一个spring的后处理器，只是用来检测当前的所有bean是否处于容器监控下
 * <br>还可添加一些测试数据
 */
public class LacusPostProcessor implements BeanFactoryPostProcessor{
    
    
    
    
    
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory f)
            throws BeansException {
        System.out.println("来自Spring后处理器：容器加载成功！\nbean列表为：");
        String[] beans = f.getBeanDefinitionNames();
        
        int count = 1;
        for(String beanName : beans){
            BeanDefinition def = f.getBeanDefinition(beanName);
            System.out.println("第" + count+"个Bean是：" + beanName);
            System.out.println("\t完整类名：" + def.getBeanClassName());
            System.out.println("\t有效范围：" + def.getScope());
            System.out.println("\t配置资源：" + def.getResourceDescription());
            System.out.println("\t配置参数：" + def.getPropertyValues());
            System.out.println("\t依赖关系：" + def.getDependsOn() + "\n");
            count++;
        }  
    }
 

}
