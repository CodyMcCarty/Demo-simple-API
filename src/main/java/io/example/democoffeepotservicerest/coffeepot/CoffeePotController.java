package io.example.democoffeepotservicerest.coffeepot;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/coffeepot")
public class CoffeePotController {

  private final CoffeePotService coffeePotService;

  @Autowired
  public CoffeePotController(CoffeePotService coffeePotService) {
    this.coffeePotService = coffeePotService;
  }

  @GetMapping
  public ResponseEntity<List<CoffeePot>> getCoffeePots(CoffeePot coffeePot) {
    return ResponseEntity.ok(coffeePotService.getCoffeePots(coffeePot));
  }

  @GetMapping(path = "{potId}")
  public ResponseEntity<CoffeePot> getCoffeePotById(@PathVariable("potId") final Long potId) {
    return new ResponseEntity<>(coffeePotService.getCoffeePotById(potId), HttpStatus.OK);
  }

  @PostMapping()
  public ResponseEntity<CoffeePot> addNewCoffeePot(@RequestBody @Valid CoffeePot coffeePot) {
    return new ResponseEntity<>(coffeePotService.addNewCoffeePot(coffeePot), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "{potId}")
  public ResponseEntity<Void> deleteCoffeePot(@PathVariable("potId") final Long potId) {
    coffeePotService.deleteCoffeePot(potId);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{potId}")
  public ResponseEntity<CoffeePot> updateCoffeePot(
      @RequestBody @Valid CoffeePot coffeePot, @PathVariable final Long potId) {
    return new ResponseEntity<>(coffeePotService.updateCoffeePot(coffeePot, potId), HttpStatus.OK);
  }
}
