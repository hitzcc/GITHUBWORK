/**
 * 
 */
package hitwh.zcc.CA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import hitwh.zcc.CA.Const.Const;
import hitwh.zcc.CA.dao.ComputerComponentDao;
import hitwh.zcc.CA.pojo.AssembledPC;
import hitwh.zcc.CA.pojo.ComputerComponent;

/**
 * @author 张聪聪
 * 2015年5月26日
 * 说明：
 * 
 */
@Scope("prototype")
@Service
public class AdviceService {
    @Autowired
    private ComputerComponentDao<ComputerComponent> ccd;

    public AssembledPC chooseBudget(int budget){
        AssembledPC apc = new AssembledPC();
        apc.setBudget(budget);
        if(apc.getBudget() < 2000){
            apc.setLevel(Const.PRIMER);
        }else if(apc.getBudget() < 4000){
            apc.setLevel(Const.NOMRAL);
        }else if(apc.getBudget() < 6000){
            apc.setLevel(Const.PROFESSIONAL);
        }else{
            apc.setLevel(Const.ENTHUSIAST);
        }
        return apc;
    }
    
    public AssembledPC chooseUsage(AssembledPC apc,int usage){
        apc.setUsage(usage);
        return apc;
    }   
    
    public AssembledPC chooseComponent(AssembledPC apc,int comoponentId){
        ComputerComponent cc = ccd.get(ComputerComponent.class,new Integer(comoponentId));
        System.out.println(cc);
        System.out.println(apc);
        apc.getCcList().add(cc);
        return apc;
    }

}
