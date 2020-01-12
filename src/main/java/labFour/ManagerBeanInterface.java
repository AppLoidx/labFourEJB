package labFour;

import domain.User;

import javax.ejb.Local;
import java.util.List;

/**
 * @author Arthur Kupriyanov
 */
@Local
public interface ManagerBeanInterface {
    void init();
    List<DotDTO> getAll(User user);
    void deleteAll(User user);
    void addDot(double x, double y, double r, String result);
    User getUserIdByLogin(String login);

}
