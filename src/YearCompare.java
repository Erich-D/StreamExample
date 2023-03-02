import java.util.Comparator;

public class YearCompare implements Comparator<Car> {

    @Override
    public int compare(Car o1, Car o2) {
        int result = o1.getYear() - o2.getYear();
        if(result != 0){
            return result;
        }else{
            return o1.getMake().compareTo(o2.getMake());
        }

    }
}
