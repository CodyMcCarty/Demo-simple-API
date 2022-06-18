package io.example.democoffeepotservicerest.coffeepot;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
@Api(
    tags = {"Online Coffee Pot controller"},
    description = "Full CRUD operations related to coffee pots")
public class CoffeePotController {

  private final CoffeePotService coffeePotService;

  @Autowired
  public CoffeePotController(CoffeePotService coffeePotService) {
    this.coffeePotService = coffeePotService;
  }

  @GetMapping
  @ApiOperation(
      value = "Fetches all coffee pots by default, or queried pots if supplied",
      notes =
          "Not all queries are supported.  Only a basic query operations have been implemented. "
              + " Leave each query blank to retrieve all coffee pots",
      response = CoffeePot.class)
  public ResponseEntity<List<CoffeePot>> getCoffeePots(CoffeePot coffeePot) {
    return ResponseEntity.ok(coffeePotService.getCoffeePots(coffeePot));
  }

  @GetMapping(path = "{potId}")
  @ApiOperation(
      value = "Finds a coffee pot by id",
      notes = "Supply an ID to look up a specific coffeepot",
      response = CoffeePot.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Coffee pot found!"),
        @ApiResponse(code = 404, message = "That coffee pot doesn't exist :("),
        @ApiResponse(code = 403, message = "Error: Beginning location trace...")
      })
  public ResponseEntity<CoffeePot> getCoffeePotById(
      @ApiParam(value = "ID for the coffee pot to " + "fetch", required = true)
          @PathVariable("potId")
          final Long potId) {
    return new ResponseEntity<>(coffeePotService.getCoffeePotById(potId), HttpStatus.OK);
  }

  @PostMapping()
  @Validated
  @ApiOperation(
      value = "Adds a supplied coffee pot to the DB",
      notes =
          "Supply a coffee pot in the request body. "
              + " Do not include an ID or age, because these are generated values.",
      response = CoffeePot.class)
  public ResponseEntity<CoffeePot> addNewCoffeePot(@RequestBody @Valid CoffeePot coffeePot) {
    return new ResponseEntity<>(coffeePotService.addNewCoffeePot(coffeePot), HttpStatus.CREATED);
  }

  @DeleteMapping(path = "{potId}")
  @ApiOperation(
      value = "Delets a coffee pot from the DB by id",
      notes = "Enter the ID of the coffee pot in the path.",
      response = CoffeePot.class)
  public ResponseEntity<Void> deleteCoffeePot(
      @ApiParam(value = "ID for the coffee pot to " + "fetch", required = true)
          @PathVariable("potId")
          final Long potId) {
    coffeePotService.deleteCoffeePot(potId);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{potId}")
  @Validated
  @ApiOperation(
      value = "Updates a coffee pot in the DB",
      notes = "Path ID and request body ID must match.  All fields are required(except age).",
      response = CoffeePot.class)
  public ResponseEntity<CoffeePot> updateCoffeePot(
      @RequestBody @Valid CoffeePot coffeePot,
      @ApiParam(value = "ID for the coffee pot to fetch", required = true) @PathVariable
          final Long potId) {
    return new ResponseEntity<>(coffeePotService.updateCoffeePot(coffeePot, potId), HttpStatus.OK);
  }
}
