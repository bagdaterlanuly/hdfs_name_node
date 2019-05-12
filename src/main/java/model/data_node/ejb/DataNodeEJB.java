package model.data_node.ejb;

import model.data_node.model.DataNode;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
@LocalBean
public class DataNodeEJB {

    @PersistenceContext(unitName = "name_node")
    private EntityManager em;

    public void create(DataNode dataNode) {
        em.persist(dataNode);
    }

    public DataNode findByHost(String host) {
        TypedQuery<DataNode> query = em.createNamedQuery("DataNode.findByHost", DataNode.class);
        query.setParameter("host", host);
        return query.getSingleResult();
    }
}
