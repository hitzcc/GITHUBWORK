/**
 * 
 */
package hitwh.zcc.CA.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import hitwh.zcc.CA.dao.ComponentTypeDao;
import hitwh.zcc.CA.pojo.AssembledPC;
import hitwh.zcc.CA.pojo.ComponentType;
import hitwh.zcc.CA.pojo.ComputerComponent;
import hitwh.zcc.CA.service.AdviceService;
import hitwh.zcc.CA.service.ComponentService;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author zcc
 * 2015年5月24日
 * 说明：
 * 
 */
@Scope("prototype")
@Controller("AA")
public class AdviceAction extends ActionSupport implements ServletRequestAware{
    private int usage;
    private int type;
    private int budget;
    private int componentID;
    private static final long serialVersionUID = 839041847728141545L;
    @Autowired
    private AdviceService as;
    @Autowired
    private ComponentService cs;
    @Autowired
    private ComponentTypeDao<ComponentType> cto;
    
    private HttpServletRequest request;
    
    public String chooseBudget(){
        AssembledPC apc = as.chooseBudget(budget);
        request.getSession().setAttribute("apc", apc);
        
        return SUCCESS;
    }
    
    public String chooseUsage(){
        AssembledPC apc = (AssembledPC) request.getSession().getAttribute("apc");
        AssembledPC _apc = as.chooseUsage(apc, usage);
        System.out.println("_apc = " + _apc);
        request.getSession().setAttribute("apc", _apc);
        
        int type = 1;
        System.out.println("type : " + type);
        List<ComputerComponent> cpuList = cs.getComponentByCondition(type,apc.getLevel(),apc.getUsage());
        request.setAttribute("cpuList", cpuList);
        
        return SUCCESS;
    }
    
    public String chooseCPU(){
        AssembledPC apc = (AssembledPC) request.getSession().getAttribute("apc");
        AssembledPC _apc = as.chooseComponent(apc, componentID);
        request.getSession().setAttribute("apc", _apc);
        
        int type = 2;
        System.out.println("Memorytype : " + type);
        List<ComputerComponent> mList = cs.getComponentByCondition(type,apc.getLevel(),apc.getUsage());
        request.setAttribute("mList", mList);
        
        return SUCCESS;
    }

    public String chooseMemory(){
        AssembledPC apc = (AssembledPC) request.getSession().getAttribute("apc");
        AssembledPC _apc = as.chooseComponent(apc, componentID);
        request.getSession().setAttribute("apc", _apc);
        
        int type = 3;
        System.out.println("HardDisktype : " + type);
        List<ComputerComponent> hdList = cs.getComponentByCondition(type,apc.getLevel(),apc.getUsage());
        request.setAttribute("hdList", hdList);
        
        return SUCCESS;
    }
    
    public String chooseHardDisk(){
        AssembledPC apc = (AssembledPC) request.getSession().getAttribute("apc");
        AssembledPC _apc = as.chooseComponent(apc, componentID);
        int rp = 0;
        for(ComputerComponent cc:_apc.getCcList()){
            rp += cc.getPrice();
        }
        _apc.setRealPrice(rp);
        
        request.getSession().setAttribute("apc", _apc);
        
        return SUCCESS;
    } 
    
    public String displayMessage(){
        return SUCCESS;
    }
    
    

    /**
     * @return the usage
     */
    public int getUsage() {
        return usage;
    }

    /**
     * @param usage the usage to set
     */
    public void setUsage(int usage) {
        this.usage = usage;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the componentID
     */
    public int getComponentId() {
        return componentID;
    }

    /**
     * @param componentID the componentID to set
     */
    public void setComponentId(int componentID) {
        this.componentID = componentID;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public void setServletRequest(HttpServletRequest arg0) {
        // TODO Auto-generated method stub
        this.request = arg0;
        
    }

    /**
     * @return the request
     */
    public HttpServletRequest getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * @return the budget
     */
    public int getBudget() {
        return budget;
    }

    /**
     * @param budget the budget to set
     */
    public void setBudget(int budget) {
        this.budget = budget;
    }

}
