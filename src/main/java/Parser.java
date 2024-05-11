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
        List<Country> sortedByName = new ArrayList<>();
        List<Country> countriesCopy = new ArrayList<>();
        for (int i=0 ; i<countries.size() ; i++){
            countriesCopy.add(countries.get(i));
        }
        for (int i=0 ; i<countries.size() ; i++){
            int maxIndex = 0;
            for (int j=0 ; j<countriesCopy.size() ; j++){
                if (countriesCopy.get(j).getName().compareTo(countriesCopy.get(maxIndex).getName()) < 0){
                    maxIndex = j;
                }
            }
            sortedByName.add(countriesCopy.get(maxIndex));
            countriesCopy.remove(maxIndex);
        }
        return  sortedByName;
    }

    public List<Country> sortByPopulation(){
        List<Country> sortedByPopulation = new ArrayList<>();
        List<Country> countriesCopy = new ArrayList<>();
        for (int i=0 ; i<countries.size() ; i++){
            countriesCopy.add(countries.get(i));
        }
        for (int i=0 ; i<countries.size() ; i++){
            int maxIndex = 0;
            for (int j=0 ; j<countriesCopy.size() ; j++){
                if (countriesCopy.get(j).getPopulation() > countriesCopy.get(maxIndex).getPopulation()){
                    maxIndex = j;
                }
            }
            sortedByPopulation.add(countriesCopy.get(maxIndex));
            countriesCopy.remove(maxIndex);
        }
        return sortedByPopulation;
    }

    public List<Country> sortByArea(){
        List<Country> sortedByArea = new ArrayList<>();
        List<Country> countriesCopy = new ArrayList<>();
        for (int i=0 ; i<countries.size() ; i++){
            countriesCopy.add(countries.get(i));
        }
        for (int i=0 ; i<countries.size() ; i++){
            int maxIndex = 0;
            for (int j=0 ; j<countriesCopy.size() ; j++){
                if (countriesCopy.get(j).getArea() > countriesCopy.get(maxIndex).getArea()){
                    maxIndex = j;
                }
            }
            sortedByArea.add(countriesCopy.get(maxIndex));
            countriesCopy.remove(maxIndex);

        }
        return sortedByArea;

    }

    public void setUp() throws IOException {

        File input = new File("C:\\Users\\Asus\\Desktop\\Projects\\Fourth-Assignment-HTML-Parser\\src\\Resources\\country-list.html");
        Document doc = Jsoup.parse(input);
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

    public static void main(String[] args) throws IOException {

        Parser p = new Parser();
        p.setUp();
        p.sortByPopulation();
    }
}
