package io.example.democoffeepotservicerest.coffeepot;

import java.net.URI;
import java.util.List;

public interface CoffeePotService {

  /**
   * Queries the DB for coffee pots
   * @param coffeePot the example coffee pot
   * @return a list of matching coffee pots
   */
  List<CoffeePot> getCoffeePots(CoffeePot coffeePot);

  /**
   * Persist a coffee pot to the repository
   * @param coffeePot the coffee pot to add
   * @return the added coffee pot
   */
  CoffeePot addNewCoffeePot(CoffeePot coffeePot);
}
