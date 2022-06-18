package io.example.democoffeepotservicerest.coffeepot;

import java.util.List;

public interface CoffeePotService {

  /**
   * Queries the DB for coffee pots
   *
   * @param coffeePot the example coffee pot
   * @return a list of matching coffee pots
   */
  List<CoffeePot> getCoffeePots(CoffeePot coffeePot);

  /**
   * Persist a coffee pot to the repository
   *
   * @param coffeePot the coffee pot to add
   * @return the added coffee pot
   */
  CoffeePot addNewCoffeePot(CoffeePot coffeePot);

  /**
   * Deletes a coffee pot from the repository
   *
   * @param potId the Id of the coffee pot to delete
   */
  void deleteCoffeePot(Long potId);

  /**
   * updates the coffee pot infor
   *
   * @param coffeePot the updated info
   * @return the updated coffee pot
   */
  CoffeePot updateCoffeePot(CoffeePot coffeePot);
}
