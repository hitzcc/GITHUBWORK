/**
 * 
 */
package hitwh.zcc.CA.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张聪聪
 * 2015年5月25日
 * 说明：
 * 
 */
public class AssembledPC {
    
    private int budget;
    
    private int realPrice;
    
    private int usage;
    
    private int level;
    
    private List<ComputerComponent> ccList = new ArrayList<ComputerComponent>();

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

    /**
     * @return the realPrice
     */
    public int getRealPrice() {
        return realPrice;
    }

    /**
     * @param realPrice the realPrice to set
     */
    public void setRealPrice(int realPrice) {
        this.realPrice = realPrice;
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
     * @return the ccList
     */
    public List<ComputerComponent> getCcList() {
        return ccList;
    }

    /**
     * @param ccList the ccList to set
     */
    public void setCcList(List<ComputerComponent> ccList) {
        this.ccList = ccList;
    }

}
