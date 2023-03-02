import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Ford","Mustang","green",1968));
        cars.add(new Car("Pontiac","GTO Judge","red",1969));
        cars.add(new Car("Chevrolet","Camaro","yellow",1969));
        cars.add(new Car("Dodge","Charger","rust",1969));
        cars.add(new Car("Plymouth","Road Runner","orange",1970));
        cars.add(new Car("Dodge","Challenger","orange",1971));
        cars.add(new Car("Chevrolet","Corvette","white",1963));
        cars.add(new Car("AMC","AMX","red",1970));
        cars.add(new Car("Chevrolet","Chevelle","forest green",1970));
        cars.add(new Car("Plymouth","Barracuda","neon green",1970));
        cars.add(new Car("Oldsmobile","442","pewter",1968));
        cars.add(new Car("Mercury","Cougar","blue",1970));
        cars.add(new Car("Buick","Grand National","black",1982));
        cars.add(new Car("Dodge","Coronet","light green",1970));

        cars.stream().map(c-> {
            if (c.getMake().compareTo("Chevrolet") == 0) {
                System.out.println("Found Chevrolet "+c.getModel());
                c.setMake("Chevy");
            }
            System.out.println();
            return c;
        }).filter(c->c.getYear()>1968).sorted(new YearCompare()).forEach(c-> System.out.println(c));

        List<Car> ofYear = cars.stream().filter(c->c.getMake().compareTo("Dodge")==0).toList();
        System.out.println("Newest car in list = "+ofYear.stream().reduce((ac,c)-> {
                    return (c.getYear() > ac.getYear()) ? c : ac;
                }
        ).get());
    }
}