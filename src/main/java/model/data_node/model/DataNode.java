package model.data_node.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "data_node")
@NamedQueries({
        @NamedQuery(name = "DataNode.findByHost",
                query = "SELECT dn FROM DataNode dn WHERE dn.host = :host")
})
public class DataNode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "host")
    private String host;

    @Column(name = "total_space")
    private Long totalSpace;

    @Column(name = "used_space")
    private Long usedSpace;

    @Column(name = "free_space")
    private Long freeSpace;

    @Column(name = "is_active")
    private Boolean isActive;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTotalSpace() {
        return totalSpace;
    }

    public void setTotalSpace(Long totalSpace) {
        this.totalSpace = totalSpace;
    }

    public Long getUsedSpace() {
        return usedSpace;
    }

    public void setUsedSpace(Long usedSpace) {
        this.usedSpace = usedSpace;
    }

    public Long getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(Long freeSpace) {
        this.freeSpace = freeSpace;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @NotNull
    public String getHost() {
        return host;
    }

    public void setHost(@NotNull String host) {
        this.host = host;
    }
}
