package io.example.democoffeepotservicerest.coffeepot;

import java.util.List;
import java.util.Optional;
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
    Optional<CoffeePot> coffeePotBySku = coffeePotRepository.findCoffeePotsBySku(
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
            .orElseThrow(() -> new IllegalStateException("CoffeePot does not exit"));
    coffeePotRepository.deleteById(potId);
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
