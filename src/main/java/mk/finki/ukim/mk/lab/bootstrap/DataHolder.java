package mk.finki.ukim.mk.lab.bootstrap;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Balloon> balloons = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();
    public static Order pedingOrder;

    @PostConstruct
    public void init() {
        Manufacturer manufacturer = new Manufacturer("Ballooneria", "MKD", "Vodnjanska 21");
        manufacturers.add(manufacturer);
        balloons.add(new Balloon("Green balloon", "Small", manufacturer));

        manufacturer = new Manufacturer("Cameron Balloons Ltd", "UK", "Bristol BS3 4NH");
        manufacturers.add(manufacturer);
        balloons.add(new Balloon("Blue balloon", "Medium", manufacturer));

        manufacturer = new Manufacturer("GO International Ltd", "UK", "Stevenage SG1 2BD");
        manufacturers.add(manufacturer);
        balloons.add(new Balloon("Red balloon", "Big", manufacturer));

        manufacturer = new Manufacturer("RubAir Balloons Pvt Ltd.", "IND", "Maharashtra 400004");
        manufacturers.add(manufacturer);
        balloons.add(new Balloon("Yellow balloon", "Extra Big", manufacturer));

    }
}
