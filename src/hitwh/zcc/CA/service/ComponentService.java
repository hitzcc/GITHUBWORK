/**
 * 
 */
package hitwh.zcc.CA.service;

import hitwh.zcc.CA.dao.ComputerComponentDao;
import hitwh.zcc.CA.pojo.ComputerComponent;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

/**
 * @author 张聪聪
 * 2015年5月26日
 * 说明：
 * 
 */
@Scope("prototype")
@Service
public class ComponentService {
    @Autowired
    private ComputerComponentDao<ComputerComponent> ccd;
    
    public List<ComputerComponent> getComponentByCondition(int type){
        return ccd.findComponentByType(type);
        
    }
    
    public Serializable addComponentToDB( ComputerComponent cc){
        return ccd.save(cc);
    }
    
    public List<ComputerComponent> getComponentByCondition(int type,int level,int usage){
        return ccd.findComponentByTypeAndLevel(type,level,usage);
    }

}
