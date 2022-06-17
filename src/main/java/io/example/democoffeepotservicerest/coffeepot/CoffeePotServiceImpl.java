package io.example.democoffeepotservicerest.coffeepot;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeePotServiceImpl implements CoffeePotService{

  private final CoffeePotRepository coffeePotRepository;

  @Autowired
  public CoffeePotServiceImpl(CoffeePotRepository coffeePotRepository) {
    this.coffeePotRepository = coffeePotRepository;
  }

  @Override
  public List<CoffeePot> getAllCoffeePots(CoffeePot coffeePot) {
    return coffeePotRepository.findAll(); //TODO make example of
  }
}
