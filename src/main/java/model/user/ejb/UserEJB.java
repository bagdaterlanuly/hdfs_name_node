package model.user.ejb;

import model.user.model.User;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.xml.bind.ValidationException;

@Stateless
@LocalBean
public class UserEJB {

    @PersistenceContext(unitName = "name_node")
    private EntityManager em;

    public void create(User user) {
        em.persist(user);
    }

    public void edit(User user) {
        User prevUser = findUserByLogin(user.getLogin());
    }

    public User findUser(Integer id) {
        return em.find(User.class, id);
    }

    public User findUserByLogin(String login) {
        TypedQuery<User> query = em.createNamedQuery("User.findUserByLogin", User.class);
        query.setParameter("login", login);
        return query.getSingleResult();
    }

    public User authenticateUser(String login, String password) throws ValidationException {
        User user = null;

        user = findUserByLogin(login);
        if (user == null) {
            throw new ValidationException("login", "Не правильный логин или пароль!");
        }

        if (user.getPassword().equalsIgnoreCase(password)) {
            return user;
        }

        return null;
    }

}
