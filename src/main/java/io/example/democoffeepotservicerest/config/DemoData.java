package io.example.democoffeepotservicerest.config;

import io.example.democoffeepotservicerest.coffeepot.CoffeePot;
import io.example.democoffeepotservicerest.coffeepot.CoffeePotRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoData implements CommandLineRunner {
  int NUM_OF_COFFEEPOTS = 75;

  @Autowired
  private CoffeePotRepository coffeePotRepository;

  @Override
  public void run(String... strings) {
    try {
      seedDB();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void seedDB() {
    coffeePotFactory(NUM_OF_COFFEEPOTS);
  }

  private void coffeePotFactory(int howMany) {
    List<CoffeePot> coffeePots = new ArrayList<>();
    for (int i = 0; i < howMany; i++) {
      String brand = coffeePotBrands[new Random().nextInt(coffeePotBrands.length)];
      LocalDate releaseDate = genDate(1995, 2022);
      String sku = brand.charAt(0) + genString(3) + "-" + genAlphaNum(8);
      coffeePots.add(new CoffeePot(brand, sku, releaseDate));
    }
    coffeePotRepository.saveAll(coffeePots);
  }

  private String[] coffeePotBrands = {"Breville", "Bonavita", "Cuisinart", "Technivorm", "OXO",
      "Cafe", "Ninja", "Hamilton Beach", "Mr. Coffee", "Keurig", "Mainstays", "Toastmaster", "Crux"};

  private LocalDate genDate(int startYear, int endYear) {
    long startDay = LocalDate.of(startYear, 1, 1).toEpochDay();
    long endDay = LocalDate.of(endYear, 12, 31).toEpochDay();
    long randomDay = ThreadLocalRandom.current().nextLong(startDay, endDay);
    return LocalDate.ofEpochDay(randomDay);
  }

  private String genAlphaNum(int stringLength) {
    int zero = 48;
    int z = 122;
    return new Random().ints(zero, z)
        .filter((i) -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(stringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString()
        .toUpperCase();
  }

  private String genString(int stringLength) {
    int a = 97;
    int z = 122;
    return new Random().ints(a,z + 1)
        .limit(stringLength)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString()
        .toUpperCase();
  }
}
