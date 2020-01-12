package labFour;

import domain.Dot;
import domain.User;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;


@Singleton
@Path("somepath2")
public class ManagerBean implements ManagerBeanInterface{

    @GET
    public String mockGet() { return  ""; }

    private EntityManager em;

    @PostConstruct
    public void init() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dots");
        em = emf.createEntityManager();
    }

    public List<DotDTO> getAll(User user) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        List<Dot> dots = em.createQuery("SELECT dot FROM Dot dot WHERE user_id = " + user.getId(), Dot.class).getResultList();
        System.out.println(dots);


        tx.commit();

        List<DotDTO> points = new ArrayList<>();
        dots.forEach(dot -> points.add(new DotDTO(dot.getX(), dot.getY(), dot.getR(), dot.getResult())));

        return points;
    }

    public void deleteAll(User user) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.createQuery("DELETE FROM Dot dot WHERE dot.user_id = " + user.getId()).executeUpdate();

        tx.commit();
    }

    public void addDot(double x, double y, double r, String result) {
        Dot dot = new Dot(x, y, r, result);
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(dot);

        tx.commit();
    }

    public User getUserIdByLogin(String login) {
        User user;
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        user = em.createQuery("SELECT User FROM User user WHERE login= " + login, User.class).getSingleResult();

        tx.commit();
        return user;
    }
}
