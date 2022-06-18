package io.example.democoffeepotservicerest.coffeepot;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
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
  public List<CoffeePot> getCoffeePots(CoffeePot coffeePot) {
    return coffeePotRepository.findAll(); //TODO make example of
  }

  @Override
  public CoffeePot addNewCoffeePot(CoffeePot coffeePot) {
    Optional<CoffeePot> coffeePotBySku = coffeePotRepository.findCoffeePotBySku(
        coffeePot.getSku());
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
    CoffeePot prevPot = coffeePotRepository
        .findById(newPot.getId())
        .orElseThrow(() -> new IllegalStateException("CoffeePot does not exist"));

    String newBrand = newPot.getBrand();
    String newSku = newPot.getSku();
    LocalDate newReleaseDate = newPot.getReleaseDate();

    if (newBrand !=null && newBrand.length() > 0 && !Objects.equals(prevPot.getBrand(), newBrand)) {prevPot.setBrand(newBrand);}
    if (newSku != null && newSku.length() > 0 && !Objects.equals(prevPot.getSku(), newSku)) {
      //      coffeePotRepository.findCoffeePotsBySku(newSku)
      //        .isPresent(throw new IllegalStateException("asdf"));
      if (coffeePotRepository.existsCoffeePotBySku(newSku)) {
        throw new IllegalStateException("Sku taken");
      }
      prevPot.setSku(newSku);
      }
    if (newReleaseDate !=null && newReleaseDate.toEpochDay() > 0 && !Objects.equals(prevPot.getReleaseDate(),
        newReleaseDate)) {prevPot.setReleaseDate(newReleaseDate);}

    return coffeePotRepository.save(prevPot);
  }

  /*
   section [1:24:25]:

!Objects.equals(student.getEmail(),  email) checking on the if statement is not appropriate if you're going to check and throw "email taken" exception.

Currently if we check the PUT method with email already existing it doesn't throw the exception. It will work this way:

if (email != null && email.length() > 0) {
            Optional<Student> studentOptional = repository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email already exist.");
            }
            student.setEmail(email);
        }

But the BEST
   */
}
