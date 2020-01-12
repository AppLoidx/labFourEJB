package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.Table;
import java.util.Objects;

@Entity
@javax.persistence.Table(name ="webdots")
public class Dot {
    @Id
    @GeneratedValue
    private int id;

    private Double x;
    private Double y;
    private Double r;
    private String result;
    private int user_id;


    public Dot(){ }

    public Dot(Double x, Double y, Double r, String result){
        setX(x);
        setR(r);
        setY(y);
        setResult(result);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getResult() {
        return result;
    }


    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Dot{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", r=" + r +
                ", result='" + result + '\'' +
                ", user_id=" + user_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dot dot = (Dot) o;
        return id == dot.id &&
                user_id == dot.user_id &&
                Objects.equals(x, dot.x) &&
                Objects.equals(y, dot.y) &&
                Objects.equals(r, dot.r) &&
                Objects.equals(result, dot.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, x, y, r, result, user_id);
    }
}
