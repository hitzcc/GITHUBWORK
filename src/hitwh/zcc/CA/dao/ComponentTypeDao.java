/**
 * 
 */
package hitwh.zcc.CA.dao;

import hitwh.zcc.CA.pojo.ComponentType;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @author 张聪聪
 * 2015年5月26日
 * 说明：
 * 
 */
@Scope("prototype")
@Repository  
public class ComponentTypeDao<T> extends BaseDao<T> {
    public Integer findIdByName(String name){
        //return   ((ComponentType)(findAll((Class<T>) ComponentType.class).get(0))).getId();
        //List<ComponentType> ccList = (List<ComponentType>) findAll((Class<T>) ComponentType.class);
        List<ComponentType> l = (List<ComponentType>) find("select en from ComputerComponent en where en.name = '" + name +"'");
        System.out.println(l.size());
        return null;
    }

}
