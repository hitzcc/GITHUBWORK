/**
 * 
 */
package hitwh.zcc.CA.actions;

import hitwh.zcc.CA.Const.Const;
import hitwh.zcc.CA.dao.ComponentTypeDao;
import hitwh.zcc.CA.dao.ComputerComponentDao;
import hitwh.zcc.CA.pojo.ComponentType;
import hitwh.zcc.CA.pojo.ComputerComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author 张聪聪
 * 2015年5月25日
 * 说明：
 * 
 */
@Scope("prototype")
@Controller("Test")
public class TestAction extends ActionSupport {

    private static final long serialVersionUID = 4386939413848270244L;
    @Autowired
    private ComponentTypeDao<ComponentType> cto;
    @Autowired
    private ComputerComponentDao<ComputerComponent> ccd;
    
    public String addTestData(){
        ComponentType type1 = new ComponentType();
        type1.setName("CPU");
        
        ComponentType type2 = new ComponentType();
        type2.setName("Memory");
        
        ComponentType type3 = new ComponentType();
        type3.setName("HardDisk");
       
        
        ComputerComponent cc1 = new ComputerComponent();
        cc1.setLevel(Const.PRIMER);
        cc1.setModel("Intel i5 5520U");
        cc1.setName("Intel i5 5520U");
        cc1.setPerformance("表现优良");
        cc1.setPrice(890);
        cc1.setType(type1);
        cc1.setUsage1(Const.STUDY);
        
        ComputerComponent cc2 = new ComputerComponent();
        cc2.setLevel(Const.PRIMER);
        cc2.setModel("WD sk-2251");
        cc2.setName("西部数据硬盘");
        cc2.setPerformance("表现优良");
        cc2.setPrice(710);
        cc2.setType(type3);
        cc2.setUsage1(Const.STUDY);
        
        ComputerComponent cc3 = new ComputerComponent();
        cc3.setLevel(Const.PRIMER);
        cc3.setModel("XJ j8-918");
        cc3.setName("希捷内存条4G");
        cc3.setPerformance("表现优良");
        cc3.setPrice(520);
        cc3.setType(type2);
        cc3.setUsage1(Const.STUDY);    
        
        
        cto.save(type1);
        cto.save(type2);
        cto.save(type3);
        
        ccd.save(cc1);
        ccd.save(cc2);
        ccd.save(cc3);
        return SUCCESS;
    }

}
