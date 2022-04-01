package hiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long car_Id;

    @Column(name="series")
    int series;

    @Column(name="model")
    String model;

    public Car() {

    }

    public Car(int series, String model) {
        this.series = series;
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "car_Id=" + car_Id +
                ", series=" + series +
                ", model='" + model + '\'' +
                '}';
    }
}
