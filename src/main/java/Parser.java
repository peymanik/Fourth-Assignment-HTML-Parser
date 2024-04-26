import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Parser {
    static List<Country> countries = new ArrayList<>();

    public List<Country> sortByName(){
//        List<Country> sortedByName = new ArrayList<>(countries);
//        return  sortedByName;
        List<Country> sortedByArea = new ArrayList<>(countries);
        Collections.sort(sortedByArea, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return (Double.compare(o2.getArea(), o1.getArea()));
            }
        });
        return sortedByArea;
    }

    public List<Country> sortByPopulation(){
        List<Country> sortedByPopulation = new ArrayList<>(countries);
        List<Country> countriesCopy = new ArrayList<>();
        for (int i=0 ; i<countries.size() ; i++){
            countriesCopy.add(countries.get(i));
        }
        for (int i=0 ; i<countries.size() ; i++){
            int maxIndex = 0;
            for (int j=0 ; j<countriesCopy.size() ; j++){
                if (countriesCopy.get(j+1).getPopulation() > countriesCopy.get(j).getPopulation()){
                    maxIndex = j+1;
                }
            }
            sortedByPopulation.add(countriesCopy.get(maxIndex));
            countriesCopy.remove(maxIndex);

        }

        return sortedByPopulation;
    }

    public List<Country> sortByArea(){
        List<Country> sortedByArea = new ArrayList<>(countries);
        List<Country> countriesCopy = new ArrayList<>();
        for (int i=0 ; i<countries.size() ; i++){
            countriesCopy.add(countries.get(i));
        }
        for (int i=0 ; i<countries.size() ; i++){
            int maxIndex = 0;
            for (int j=0 ; j<countriesCopy.size() ; j++){
                if (countriesCopy.get(j+1).getArea() > countriesCopy.get(j).getArea()){
                    maxIndex = j+1;
                }
            }
            sortedByArea.add(countriesCopy.get(maxIndex));
            countriesCopy.remove(maxIndex);

        }

        return sortedByArea;
    }

    public void setUp() throws IOException {

        //Parse the HTML file using Jsoup
        //TODO
//        File input = new File("/tmp/input.html");
//        Document doc = Jsoup.parse(input, "UTF-8");

        // Extract data from the HTML
        //TODO

        // Iterate through each country div to extract country data
        //TODO


        File input = new File("C:\\Users\\Asus\\Desktop\\Projects\\Fourth-Assignment-HTML-Parser\\src\\Resources\\country-list.html");
        Document doc = Jsoup.parse(input , "UTF-8");
        Elements country_element = doc.getElementsByClass("country");
        for(Element c : country_element){
            String name = c.select(".country-name").text();
            String capital = c.select(".country-capital").text();
            String population = c.select(".country-population").text();
            String area = c.select(".country-area").text();
            Country country = new Country(name, capital, Integer.parseInt(population), Double.parseDouble(area));
            countries.add(country);
        }
    }

    public static void main(String[] args) {
        //you can test your code here before you run the unit tests ;)
    }
}
