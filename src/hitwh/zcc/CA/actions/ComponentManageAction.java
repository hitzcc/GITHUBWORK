/**
 * 
 */
package hitwh.zcc.CA.actions;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import hitwh.zcc.CA.dao.ComponentTypeDao;
import hitwh.zcc.CA.pojo.ComponentType;
import hitwh.zcc.CA.pojo.ComputerComponent;
import hitwh.zcc.CA.service.ComponentService;

import org.apache.struts2.interceptor.ServletRequestAware;
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
@Controller("CMA")
public class ComponentManageAction extends ActionSupport implements ServletRequestAware{
    private static final long serialVersionUID = 1L;
    private String name;
    private int price;
    private int level; 
    private int usage;
    private int type;
    private String model;
    private String performance;
    @Autowired
    private ComponentService cs;
    @Autowired
    private ComponentTypeDao<ComponentType> cto;
    private HttpServletRequest request;

    public String addNewComponent() throws NumberFormatException, UnsupportedEncodingException{
        
        String t4 = new String(name.getBytes("ISO-8859-1"));
        
        ComponentType ct = cto.get(ComponentType.class, type);
        
        ComputerComponent cc = new ComputerComponent();
        cc.setLevel(level);
        cc.setPrice(price);
        cc.setUsage1(usage);
        cc.setType(ct);
        cc.setName(t4);
        cc.setModel(model);
        cc.setPerformance(performance);
        cs.addComponentToDB(cc);
        
        return SUCCESS;
    }
    
    public String addComponent(){
        List<ComponentType> list = cto.findAll(ComponentType.class);
        request.setAttribute("typeList", list);
        return SUCCESS;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
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
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * @return the performance
     */
    public String getPerformance() {
        return performance;
    }

    /**
     * @param performance the performance to set
     */
    public void setPerformance(String performance) {
        this.performance = performance;
    }

    @Override
    public void setServletRequest(HttpServletRequest arg0) {
        request = arg0;
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

}
