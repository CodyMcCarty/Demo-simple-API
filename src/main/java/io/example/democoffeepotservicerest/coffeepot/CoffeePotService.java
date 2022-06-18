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
   * fetches a coffee pot by Id
   *
   * @param potId the coffee pot ID
   * @return a coffee pot
   */
  CoffeePot getCoffeePotById(Long potId);

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
   * updates the coffee pot info
   *
   * @param coffeePot the updated info from request body
   * @param potId the coffee pot id from the path
   * @return the updated coffee pot
   */
  CoffeePot updateCoffeePot(CoffeePot coffeePot, Long potId);
}
