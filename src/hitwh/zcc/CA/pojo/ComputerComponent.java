package hitwh.zcc.CA.pojo;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author 张聪聪
 * 2015年5月25日
 * 说明：
 * 
 */
@Entity
@Table
public class ComputerComponent {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int price;
    /** 等级*/
    private int level;
    /** 用途*/
    private int usage1;
    /** 类型*/
    @ManyToOne(targetEntity=ComponentType.class,fetch=FetchType.EAGER)
    @JoinColumn(name="type"
        , referencedColumnName="id")
    private ComponentType type;
    /** 型号*/
    private String model;
    /** 性能*/
    private String performance;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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
    public int getUsage1() {
        return usage1;
    }

    /**
     * @param usage the usage to set
     */
    public void setUsage1(int usage) {
        this.usage1 = usage;
    }

    /**
     * @return the type
     */
    public ComponentType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ComponentType type) {
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

}
