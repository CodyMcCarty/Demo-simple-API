package io.example.democoffeepotservicerest.coffeepot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CoffeePotController.class})
@ExtendWith(SpringExtension.class)
class CoffeePotControllerTest {

  @Autowired
  private CoffeePotController coffeePotController;

  @MockBean
  private CoffeePotService coffeePotService;

  /**
   * Method under test: {@link CoffeePotController#addNewCoffeePot(CoffeePot)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testAddNewCoffeePot() {
    //   Unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: Failed to instantiate class under test.
    //   Unable to construct an instance of CoffeePotController.
    //   Add a package-visible constructor or a factory method for the class under test.
    //   This can happen because the factory method takes arguments, throws, returns null
    //   or returns a subtype.

    // TODO: Complete this test.
    //   Reason: No inputs found that don't throw a trivial exception.
    //   The method under test threw
    //   org.springframework.web.server.ResponseStatusException: 409 CONFLICT "Sku Taken"
    //       at io.example.democoffeepotservicerest.coffeepot.CoffeePotServiceImpl.addNewCoffeePot(CoffeePotServiceImpl.java:49)
    //       at io.example.democoffeepotservicerest.coffeepot.CoffeePotController.addNewCoffeePot(CoffeePotController.java:40)
    //   In order to prevent addNewCoffeePot(CoffeePot)
    //   from throwing ResponseStatusException, add constructors or factory
    //   methods that make it easier to construct fully initialized objects used in
    //   addNewCoffeePot(CoffeePot).

    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku00");

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku01");
    Optional<CoffeePot> ofResult = Optional.of(coffeePot1);
    CoffeePotRepository coffeePotRepository = mock(CoffeePotRepository.class);
    when(coffeePotRepository.save((CoffeePot) any())).thenReturn(coffeePot);
    when(coffeePotRepository.findCoffeePotBySku((String) any())).thenReturn(ofResult);
    CoffeePotController coffeePotController = new CoffeePotController(
        new CoffeePotServiceImpl(coffeePotRepository));

    CoffeePot coffeePot2 = new CoffeePot();
    coffeePot2.setAge(1);
    coffeePot2.setBrand("Brand");
    coffeePot2.setId(123L);
    coffeePot2.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot2.setSku("Sku02");

    // Act
    coffeePotController.addNewCoffeePot(coffeePot2);
  }

  /**
   * Method under test: {@link CoffeePotController#addNewCoffeePot(CoffeePot)}
   */
  @Test
  void testAddNewCoffeePot2() {
    //   Unable to write a Spring test, so wrote a non-Spring test instead.
    //   Reason: Failed to instantiate class under test.
    //   Unable to construct an instance of CoffeePotController.
    //   Add a package-visible constructor or a factory method for the class under test.
    //   This can happen because the factory method takes arguments, throws, returns null
    //   or returns a subtype.

    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");
    CoffeePotRepository coffeePotRepository = mock(CoffeePotRepository.class);
    when(coffeePotRepository.save((CoffeePot) any())).thenReturn(coffeePot);
    when(coffeePotRepository.findCoffeePotBySku((String) any())).thenReturn(Optional.empty());
    CoffeePotController coffeePotController = new CoffeePotController(
        new CoffeePotServiceImpl(coffeePotRepository));

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");

    // Act
    ResponseEntity<CoffeePot> actualAddNewCoffeePotResult = coffeePotController.addNewCoffeePot(
        coffeePot1);

    // Assert
    assertEquals(coffeePot1, actualAddNewCoffeePotResult.getBody());
    assertTrue(actualAddNewCoffeePotResult.getHeaders().isEmpty());
    assertEquals(HttpStatus.CREATED, actualAddNewCoffeePotResult.getStatusCode());
    verify(coffeePotRepository).save((CoffeePot) any());
    verify(coffeePotRepository).findCoffeePotBySku((String) any());
  }

  /**
   * Method under test: {@link CoffeePotController#updateCoffeePot(CoffeePot, Long)}
   */
  @Test
  @Disabled("TODO: Complete this test")
  void testUpdateCoffeePot() {
    //   Unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: Failed to instantiate class under test.
    //   Unable to construct an instance of CoffeePotController.
    //   Add a package-visible constructor or a factory method for the class under test.
    //   This can happen because the factory method takes arguments, throws, returns null
    //   or returns a subtype.

    // TODO: Complete this test.
    //   Reason: No inputs found that don't throw a trivial exception.
    //   Method under test threw
    //   org.springframework.web.server.ResponseStatusException: 409 CONFLICT "Path id 1 doesn't match request body id 123"
    //       at io.example.democoffeepotservicerest.coffeepot.CoffeePotServiceImpl.updateCoffeePot(CoffeePotServiceImpl.java:69)
    //       at io.example.democoffeepotservicerest.coffeepot.CoffeePotController.updateCoffeePot(CoffeePotController.java:52)
    //   In order to prevent updateCoffeePot(CoffeePot, Long)
    //   from throwing ResponseStatusException, add constructors or factory
    //   methods that make it easier to construct fully initialized objects used in
    //   updateCoffeePot(CoffeePot, Long).

    // Arrange
    CoffeePotController coffeePotController = new CoffeePotController(
        new CoffeePotServiceImpl(mock(CoffeePotRepository.class)));

    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");

    // Act
    coffeePotController.updateCoffeePot(coffeePot, 1L);
  }

  /**
   * Method under test: {@link CoffeePotController#updateCoffeePot(CoffeePot, Long)}
   */
  @Test
  void testUpdateCoffeePot2() {
    //   Unable to write a Spring test,
    //   so wrote a non-Spring test instead.
    //   Reason: Failed to instantiate class under test.
    //   Unable to construct an instance of CoffeePotController.
    //   Add a package-visible constructor or a factory method for the class under test.
    //   This can happen because the factory method takes arguments, throws, returns null
    //   or returns a subtype.

    // Arrange
    CoffeePot coffeePot = mock(CoffeePot.class);
    doNothing().when(coffeePot).setAge(anyInt());
    doNothing().when(coffeePot).setBrand((String) any());
    doNothing().when(coffeePot).setId((Long) any());
    doNothing().when(coffeePot).setReleaseDate((LocalDate) any());
    doNothing().when(coffeePot).setSku((String) any());
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");
    CoffeePot coffeePot1 = mock(CoffeePot.class);
    doNothing().when(coffeePot1).setAge(anyInt());
    doNothing().when(coffeePot1).setBrand((String) any());
    doNothing().when(coffeePot1).setId((Long) any());
    doNothing().when(coffeePot1).setReleaseDate((LocalDate) any());
    doNothing().when(coffeePot1).setSku((String) any());
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");

    CoffeePot coffeePot2 = new CoffeePot();
    coffeePot2.setAge(1);
    coffeePot2.setBrand("Brand");
    coffeePot2.setId(123L);
    coffeePot2.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot2.setSku("Sku");
    Optional<CoffeePot> ofResult = Optional.of(coffeePot2);
    CoffeePotRepository coffeePotRepository = mock(CoffeePotRepository.class);
    when(coffeePotRepository.save((CoffeePot) any())).thenReturn(coffeePot1);
    when(coffeePotRepository.findCoffeePotBySku((String) any())).thenReturn(Optional.empty());
    when(coffeePotRepository.findById((Long) any())).thenReturn(ofResult);

    CoffeePot coffeePot3 = new CoffeePot();
    coffeePot3.setAge(1);
    coffeePot3.setBrand("CoffeePot does not exist");
    coffeePot3.setId(123L);
    coffeePot3.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot3.setSku("CoffeePot does not exist");

    CoffeePotServiceImpl coffeePotServiceImpl = new CoffeePotServiceImpl(coffeePotRepository);
    coffeePotServiceImpl.addNewCoffeePot(coffeePot3);
    CoffeePotController coffeePotController = new CoffeePotController(coffeePotServiceImpl);

    CoffeePot coffeePot4 = new CoffeePot();
    coffeePot4.setAge(1);
    coffeePot4.setBrand("Brand");
    coffeePot4.setId(123L);
    coffeePot4.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot4.setSku("Sku");

    // Act
    ResponseEntity<CoffeePot> actualUpdateCoffeePotResult = coffeePotController.updateCoffeePot(
        coffeePot4, 123L);

    // Assert
    assertTrue(actualUpdateCoffeePotResult.hasBody());
    assertEquals(HttpStatus.OK, actualUpdateCoffeePotResult.getStatusCode());
    assertTrue(actualUpdateCoffeePotResult.getHeaders().isEmpty());
    verify(coffeePotRepository, atLeast(1)).save((CoffeePot) any());
    verify(coffeePotRepository).findCoffeePotBySku((String) any());
    verify(coffeePotRepository).findById((Long) any());
    verify(coffeePot1).setAge(anyInt());
    verify(coffeePot1).setBrand((String) any());
    verify(coffeePot1).setId((Long) any());
    verify(coffeePot1).setReleaseDate((LocalDate) any());
    verify(coffeePot1).setSku((String) any());
    verify(coffeePot).setAge(anyInt());
    verify(coffeePot).setBrand((String) any());
    verify(coffeePot).setId((Long) any());
    verify(coffeePot).setReleaseDate((LocalDate) any());
    verify(coffeePot).setSku((String) any());
  }

  /**
   * Method under test: {@link CoffeePotController#deleteCoffeePot(Long)}
   */
  @Test
  void testDeleteCoffeePot() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/{potId}", 123L);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.coffeePotController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Method under test: {@link CoffeePotController#getCoffeePotById(Long)}
   */
  @Test
  void testGetCoffeePotById() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{potId}", 123L);

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.coffeePotController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
  }

  /**
   * Method under test: {@link CoffeePotController#getCoffeePots(CoffeePot)}
   */
  @Test
  void testGetCoffeePots() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");

    // Act
    ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.coffeePotController)
        .build()
        .perform(requestBuilder);

    // Assert
    actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
  }
}

