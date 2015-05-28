/**
 * 
 */
package hitwh.zcc.CA.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @author 张聪聪
 * 2015年5月25日
 * 说明：
 * 
 */
@Scope("prototype")
@Repository  
public class ComputerComponentDao<T> extends BaseDao<T> {
    public List<T> findComponentByType(int type){
        return find("select en from  ComputerComponent"+" en where en.type = " +type);
    }
    
    public List<T> findComponentByTypeAndLevel(int type,int level,int usage){
        return find("select en from  ComputerComponent"+" en where en.type = " +type +" and en.level = " + level + " and en.usage1 = " + usage);
    }

}
