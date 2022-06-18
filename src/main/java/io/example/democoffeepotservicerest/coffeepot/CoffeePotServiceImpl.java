package io.example.democoffeepotservicerest.coffeepot;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class CoffeePotServiceImpl implements CoffeePotService {

  private final CoffeePotRepository coffeePotRepository;

  @Autowired
  public CoffeePotServiceImpl(CoffeePotRepository coffeePotRepository) {
    this.coffeePotRepository = coffeePotRepository;
  }

  @Override
  public List<CoffeePot> getCoffeePots(CoffeePot coffeePot) {
    return coffeePotRepository.findAll(Example.of(coffeePot, ExampleMatcher.matchingAny().withIgnoreCase()));
  }

  @Override
  public CoffeePot addNewCoffeePot(CoffeePot coffeePot) {
    Optional<CoffeePot> coffeePotBySku = coffeePotRepository.findCoffeePotBySku(coffeePot.getSku());
    if (coffeePotBySku.isPresent()) {
      throw new IllegalStateException("Sku taken");
    }
    return coffeePotRepository.save(coffeePot);
  }

  @Override
  public void deleteCoffeePot(Long potId) {
    coffeePotRepository
        .findById(potId)
        .orElseThrow(() -> new IllegalStateException("CoffeePot does not exist"));
    coffeePotRepository.deleteById(potId);
  }

  @Override
  @Transactional
  public CoffeePot updateCoffeePot(CoffeePot newPot) {
    CoffeePot prevPot =
        coffeePotRepository
            .findById(newPot.getId())
            .orElseThrow(() -> new IllegalStateException("CoffeePot does not exist"));

    String newBrand = newPot.getBrand();
    String newSku = newPot.getSku();
    LocalDate newReleaseDate = newPot.getReleaseDate();

    if (newBrand != null
        && newBrand.length() > 0
        && !Objects.equals(prevPot.getBrand(), newBrand)) {
      prevPot.setBrand(newBrand);
    }
    if (newSku != null && newSku.length() > 0 && !Objects.equals(prevPot.getSku(), newSku)) {
      if (coffeePotRepository.existsCoffeePotBySku(newSku)) {
        throw new IllegalStateException("Sku taken");
      }
      prevPot.setSku(newSku);
    }
    if (newReleaseDate != null
        && newReleaseDate.toEpochDay() > 0
        && !Objects.equals(prevPot.getReleaseDate(), newReleaseDate)) {
      prevPot.setReleaseDate(newReleaseDate);
    }

    return coffeePotRepository.save(prevPot);
  }
}
