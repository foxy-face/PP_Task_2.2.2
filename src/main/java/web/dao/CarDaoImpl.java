package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarDaoImpl implements CarDao {
    private List<Car> cars;

    @Override
    public List<Car> getCarsByCount(int count) {
        cars = new ArrayList<>();

        cars.add(new Car("Toyota", "RAV4", 2014));
        cars.add(new Car("Mitsubishi", "Outlander", 2017));
        cars.add(new Car("Honda", "Civic", 2009));
        cars.add(new Car("BMW", "X6", 2008));
        cars.add(new Car("Toyota", "MarkII", 1996));

        if(count == 0 || count >=5) {
            return cars;
        } else {
            return cars.stream().limit(count).collect(Collectors.toList());
        }
    }
}
