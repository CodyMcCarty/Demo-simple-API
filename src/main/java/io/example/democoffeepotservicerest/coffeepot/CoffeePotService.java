package io.example.democoffeepotservicerest.coffeepot;

import java.util.List;

public interface CoffeePotService {

  /**
   * Queries the DB for coffee pots
   * @param coffeePot the example coffee pot
   * @return a list of matching coffee pots
   */
  List<CoffeePot> getAllCoffeePots(CoffeePot coffeePot);

}
