package labFour;

import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Singleton
@Path("somepath")
public class AreaValidator implements LocalAreaValidator {

    @GET
    public String get() {return  "kek";}

    @Override
    public String checkArea(double x, double y, double r) {

        String result;
        if ((checkRectangle(x, y, r) || checkCircle(x, y, r) || checkTriangle(x, y, r))) {
            result = "TRUE";
        } else {
            result = "FALSE";
        }
        return result;
    }

    @Override
    public boolean checkRectangle(double x, double y, double r) {
        return (x >= -r) && (x <= 0) && (y <= r) && (y >= 0);
    }

    @Override
    public boolean checkCircle(double x, double y, double r) {
        return (x * x + y * y <= r * r *0.25 ) && (x >= 0) && (y >= 0);
    }

    @Override
    public boolean checkTriangle(double x, double y, double r) {
        return ( -x - r*0.5 <= y) && (x >= 0) && (y <= 0);
    }
}
