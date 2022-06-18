package io.example.democoffeepotservicerest.coffeepot;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

@ContextConfiguration(classes = {CoffeePotServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CoffeePotServiceImplTest {

  @MockBean private CoffeePotRepository coffeePotRepository;

  @Autowired private CoffeePotServiceImpl coffeePotServiceImpl;

  /** Method under test: {@link CoffeePotServiceImpl#getCoffeePots(CoffeePot)} */
  @Test
  void testGetCoffeePots() {
    // Arrange
    ArrayList<CoffeePot> coffeePotList = new ArrayList<>();
    when(this.coffeePotRepository.findAll(
            (org.springframework.data.domain.Example<CoffeePot>) any()))
        .thenReturn(coffeePotList);

    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");

    // Act
    List<CoffeePot> actualCoffeePots = this.coffeePotServiceImpl.getCoffeePots(coffeePot);

    // Assert
    assertSame(coffeePotList, actualCoffeePots);
    assertTrue(actualCoffeePots.isEmpty());
    verify(this.coffeePotRepository)
        .findAll((org.springframework.data.domain.Example<CoffeePot>) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#getCoffeePots(CoffeePot)} */
  @Test
  void testGetCoffeePots2() {
    // Arrange
    when(this.coffeePotRepository.findAll(
            (org.springframework.data.domain.Example<CoffeePot>) any()))
        .thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));

    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");

    // Act and Assert
    assertThrows(
        ResponseStatusException.class, () -> this.coffeePotServiceImpl.getCoffeePots(coffeePot));
    verify(this.coffeePotRepository)
        .findAll((org.springframework.data.domain.Example<CoffeePot>) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#getCoffeePotById(Long)} */
  @Test
  void testGetCoffeePotById() {
    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");
    Optional<CoffeePot> ofResult = Optional.of(coffeePot);
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(ofResult);

    // Act and Assert
    assertSame(coffeePot, this.coffeePotServiceImpl.getCoffeePotById(123L));
    verify(this.coffeePotRepository).findById((Long) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#getCoffeePotById(Long)} */
  @Test
  void testGetCoffeePotById2() {
    // Arrange
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(Optional.empty());

    // Act and Assert
    assertThrows(
        ResponseStatusException.class, () -> this.coffeePotServiceImpl.getCoffeePotById(123L));
    verify(this.coffeePotRepository).findById((Long) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#getCoffeePotById(Long)} */
  @Test
  void testGetCoffeePotById3() {
    // Arrange
    when(this.coffeePotRepository.findById((Long) any()))
        .thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));

    // Act and Assert
    assertThrows(
        ResponseStatusException.class, () -> this.coffeePotServiceImpl.getCoffeePotById(123L));
    verify(this.coffeePotRepository).findById((Long) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#addNewCoffeePot(CoffeePot)} */
  @Test
  void testAddNewCoffeePot() {
    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");
    Optional<CoffeePot> ofResult = Optional.of(coffeePot1);
    when(this.coffeePotRepository.save((CoffeePot) any())).thenReturn(coffeePot);
    when(this.coffeePotRepository.findCoffeePotBySku((String) any())).thenReturn(ofResult);

    CoffeePot coffeePot2 = new CoffeePot();
    coffeePot2.setAge(1);
    coffeePot2.setBrand("Brand");
    coffeePot2.setId(123L);
    coffeePot2.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot2.setSku("Sku");

    // Act and Assert
    assertThrows(
        ResponseStatusException.class, () -> this.coffeePotServiceImpl.addNewCoffeePot(coffeePot2));
    verify(this.coffeePotRepository).findCoffeePotBySku((String) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#addNewCoffeePot(CoffeePot)} */
  @Test
  void testAddNewCoffeePot2() {
    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");
    when(this.coffeePotRepository.save((CoffeePot) any())).thenReturn(coffeePot);
    when(this.coffeePotRepository.findCoffeePotBySku((String) any())).thenReturn(Optional.empty());

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");

    // Act and Assert
    assertSame(coffeePot, this.coffeePotServiceImpl.addNewCoffeePot(coffeePot1));
    verify(this.coffeePotRepository).save((CoffeePot) any());
    verify(this.coffeePotRepository).findCoffeePotBySku((String) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#addNewCoffeePot(CoffeePot)} */
  @Test
  void testAddNewCoffeePot3() {
    // Arrange
    when(this.coffeePotRepository.save((CoffeePot) any()))
        .thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));
    when(this.coffeePotRepository.findCoffeePotBySku((String) any()))
        .thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));

    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");

    // Act and Assert
    assertThrows(
        ResponseStatusException.class, () -> this.coffeePotServiceImpl.addNewCoffeePot(coffeePot));
    verify(this.coffeePotRepository).findCoffeePotBySku((String) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#deleteCoffeePot(Long)} */
  @Test
  void testDeleteCoffeePot() {
    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");
    Optional<CoffeePot> ofResult = Optional.of(coffeePot);
    doNothing().when(this.coffeePotRepository).deleteById((Long) any());
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(ofResult);

    // Act
    this.coffeePotServiceImpl.deleteCoffeePot(123L);

    // Assert that nothing has changed
    verify(this.coffeePotRepository).findById((Long) any());
    verify(this.coffeePotRepository).deleteById((Long) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#deleteCoffeePot(Long)} */
  @Test
  void testDeleteCoffeePot2() {
    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");
    Optional<CoffeePot> ofResult = Optional.of(coffeePot);
    doThrow(new ResponseStatusException(HttpStatus.CONTINUE))
        .when(this.coffeePotRepository)
        .deleteById((Long) any());
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(ofResult);

    // Act and Assert
    assertThrows(
        ResponseStatusException.class, () -> this.coffeePotServiceImpl.deleteCoffeePot(123L));
    verify(this.coffeePotRepository).findById((Long) any());
    verify(this.coffeePotRepository).deleteById((Long) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#deleteCoffeePot(Long)} */
  @Test
  void testDeleteCoffeePot3() {
    // Arrange
    doNothing().when(this.coffeePotRepository).deleteById((Long) any());
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(Optional.empty());

    // Act and Assert
    assertThrows(
        ResponseStatusException.class, () -> this.coffeePotServiceImpl.deleteCoffeePot(123L));
    verify(this.coffeePotRepository).findById((Long) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#updateCoffeePot(CoffeePot, Long)} */
  @Test
  void testUpdateCoffeePot() {
    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");
    Optional<CoffeePot> ofResult = Optional.of(coffeePot);

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");
    when(this.coffeePotRepository.save((CoffeePot) any())).thenReturn(coffeePot1);
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(ofResult);

    CoffeePot coffeePot2 = new CoffeePot();
    coffeePot2.setAge(1);
    coffeePot2.setBrand("Brand");
    coffeePot2.setId(123L);
    coffeePot2.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot2.setSku("Sku");

    // Act and Assert
    assertSame(coffeePot1, this.coffeePotServiceImpl.updateCoffeePot(coffeePot2, 123L));
    verify(this.coffeePotRepository).save((CoffeePot) any());
    verify(this.coffeePotRepository).findById((Long) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#updateCoffeePot(CoffeePot, Long)} */
  @Test
  void testUpdateCoffeePot2() {
    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");
    Optional<CoffeePot> ofResult = Optional.of(coffeePot);
    when(this.coffeePotRepository.save((CoffeePot) any()))
        .thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(ofResult);

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");

    // Act and Assert
    assertThrows(
        ResponseStatusException.class,
        () -> this.coffeePotServiceImpl.updateCoffeePot(coffeePot1, 123L));
    verify(this.coffeePotRepository).save((CoffeePot) any());
    verify(this.coffeePotRepository).findById((Long) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#updateCoffeePot(CoffeePot, Long)} */
  @Test
  void testUpdateCoffeePot3() {
    // Arrange
    CoffeePot coffeePot = mock(CoffeePot.class);
    when(coffeePot.getReleaseDate()).thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));
    when(coffeePot.getBrand()).thenReturn("Brand");
    when(coffeePot.getSku()).thenReturn("Sku");
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
    Optional<CoffeePot> ofResult = Optional.of(coffeePot);

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");
    when(this.coffeePotRepository.existsCoffeePotBySku((String) any())).thenReturn(true);
    when(this.coffeePotRepository.save((CoffeePot) any())).thenReturn(coffeePot1);
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(ofResult);

    CoffeePot coffeePot2 = new CoffeePot();
    coffeePot2.setAge(1);
    coffeePot2.setBrand("Brand");
    coffeePot2.setId(123L);
    coffeePot2.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot2.setSku("Sku");

    // Act and Assert
    assertThrows(
        ResponseStatusException.class,
        () -> this.coffeePotServiceImpl.updateCoffeePot(coffeePot2, 123L));
    verify(this.coffeePotRepository).findById((Long) any());
    verify(coffeePot).getBrand();
    verify(coffeePot).getSku();
    verify(coffeePot).getReleaseDate();
    verify(coffeePot).setAge(anyInt());
    verify(coffeePot).setBrand((String) any());
    verify(coffeePot).setId((Long) any());
    verify(coffeePot).setReleaseDate((LocalDate) any());
    verify(coffeePot).setSku((String) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#updateCoffeePot(CoffeePot, Long)} */
  @Test
  void testUpdateCoffeePot4() {
    // Arrange
    CoffeePot coffeePot = mock(CoffeePot.class);
    when(coffeePot.getReleaseDate()).thenReturn(LocalDate.ofEpochDay(-1L));
    when(coffeePot.getBrand()).thenReturn("Brand");
    when(coffeePot.getSku()).thenReturn("Sku");
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
    Optional<CoffeePot> ofResult = Optional.of(coffeePot);

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");
    when(this.coffeePotRepository.existsCoffeePotBySku((String) any())).thenReturn(true);
    when(this.coffeePotRepository.save((CoffeePot) any())).thenReturn(coffeePot1);
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(ofResult);

    CoffeePot coffeePot2 = new CoffeePot();
    coffeePot2.setAge(1);
    coffeePot2.setBrand("Brand");
    coffeePot2.setId(123L);
    coffeePot2.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot2.setSku("Sku");

    // Act and Assert
    assertSame(coffeePot1, this.coffeePotServiceImpl.updateCoffeePot(coffeePot2, 123L));
    verify(this.coffeePotRepository).save((CoffeePot) any());
    verify(this.coffeePotRepository).findById((Long) any());
    verify(coffeePot).getBrand();
    verify(coffeePot).getSku();
    verify(coffeePot).getReleaseDate();
    verify(coffeePot).setAge(anyInt());
    verify(coffeePot).setBrand((String) any());
    verify(coffeePot).setId((Long) any());
    verify(coffeePot, atLeast(1)).setReleaseDate((LocalDate) any());
    verify(coffeePot).setSku((String) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#updateCoffeePot(CoffeePot, Long)} */
  @Test
  void testUpdateCoffeePot5() {
    // Arrange
    CoffeePot coffeePot = mock(CoffeePot.class);
    when(coffeePot.getReleaseDate()).thenReturn(LocalDate.ofEpochDay(1L));
    when(coffeePot.getBrand()).thenReturn("foo");
    when(coffeePot.getSku()).thenReturn("Sku");
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
    Optional<CoffeePot> ofResult = Optional.of(coffeePot);

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");
    when(this.coffeePotRepository.existsCoffeePotBySku((String) any())).thenReturn(true);
    when(this.coffeePotRepository.save((CoffeePot) any())).thenReturn(coffeePot1);
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(ofResult);

    CoffeePot coffeePot2 = new CoffeePot();
    coffeePot2.setAge(1);
    coffeePot2.setBrand("Brand");
    coffeePot2.setId(123L);
    coffeePot2.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot2.setSku("Sku");

    // Act and Assert
    assertSame(coffeePot1, this.coffeePotServiceImpl.updateCoffeePot(coffeePot2, 123L));
    verify(this.coffeePotRepository).save((CoffeePot) any());
    verify(this.coffeePotRepository).findById((Long) any());
    verify(coffeePot).getBrand();
    verify(coffeePot).getSku();
    verify(coffeePot).getReleaseDate();
    verify(coffeePot).setAge(anyInt());
    verify(coffeePot, atLeast(1)).setBrand((String) any());
    verify(coffeePot).setId((Long) any());
    verify(coffeePot).setReleaseDate((LocalDate) any());
    verify(coffeePot).setSku((String) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#updateCoffeePot(CoffeePot, Long)} */
  @Test
  void testUpdateCoffeePot6() {
    // Arrange
    CoffeePot coffeePot = mock(CoffeePot.class);
    when(coffeePot.getReleaseDate()).thenReturn(LocalDate.ofEpochDay(1L));
    when(coffeePot.getBrand()).thenReturn("Brand");
    when(coffeePot.getSku()).thenReturn("foo");
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
    Optional<CoffeePot> ofResult = Optional.of(coffeePot);

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");
    when(this.coffeePotRepository.existsCoffeePotBySku((String) any())).thenReturn(true);
    when(this.coffeePotRepository.save((CoffeePot) any())).thenReturn(coffeePot1);
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(ofResult);

    CoffeePot coffeePot2 = new CoffeePot();
    coffeePot2.setAge(1);
    coffeePot2.setBrand("Brand");
    coffeePot2.setId(123L);
    coffeePot2.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot2.setSku("Sku");

    // Act and Assert
    assertThrows(
        ResponseStatusException.class,
        () -> this.coffeePotServiceImpl.updateCoffeePot(coffeePot2, 123L));
    verify(this.coffeePotRepository).existsCoffeePotBySku((String) any());
    verify(this.coffeePotRepository).findById((Long) any());
    verify(coffeePot).getBrand();
    verify(coffeePot).getSku();
    verify(coffeePot).setAge(anyInt());
    verify(coffeePot).setBrand((String) any());
    verify(coffeePot).setId((Long) any());
    verify(coffeePot).setReleaseDate((LocalDate) any());
    verify(coffeePot).setSku((String) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#updateCoffeePot(CoffeePot, Long)} */
  @Test
  void testUpdateCoffeePot7() {
    // Arrange
    CoffeePot coffeePot = new CoffeePot();
    coffeePot.setAge(1);
    coffeePot.setBrand("Brand");
    coffeePot.setId(123L);
    coffeePot.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot.setSku("Sku");
    when(this.coffeePotRepository.existsCoffeePotBySku((String) any())).thenReturn(true);
    when(this.coffeePotRepository.save((CoffeePot) any())).thenReturn(coffeePot);
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(Optional.empty());
    CoffeePot coffeePot1 = mock(CoffeePot.class);
    when(coffeePot1.getReleaseDate()).thenReturn(LocalDate.ofEpochDay(1L));
    when(coffeePot1.getBrand()).thenReturn("Brand");
    when(coffeePot1.getSku()).thenReturn("Sku");
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

    // Act and Assert
    assertThrows(
        ResponseStatusException.class,
        () -> this.coffeePotServiceImpl.updateCoffeePot(coffeePot2, 123L));
    verify(this.coffeePotRepository).findById((Long) any());
    verify(coffeePot1).setAge(anyInt());
    verify(coffeePot1).setBrand((String) any());
    verify(coffeePot1).setId((Long) any());
    verify(coffeePot1).setReleaseDate((LocalDate) any());
    verify(coffeePot1).setSku((String) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#updateCoffeePot(CoffeePot, Long)} */
  @Test
  void testUpdateCoffeePot8() {
    // Arrange
    CoffeePot coffeePot = mock(CoffeePot.class);
    when(coffeePot.getReleaseDate()).thenReturn(LocalDate.ofEpochDay(1L));
    when(coffeePot.getBrand()).thenReturn("Brand");
    when(coffeePot.getSku()).thenReturn("Sku");
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
    Optional<CoffeePot> ofResult = Optional.of(coffeePot);

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");
    when(this.coffeePotRepository.existsCoffeePotBySku((String) any())).thenReturn(true);
    when(this.coffeePotRepository.save((CoffeePot) any())).thenReturn(coffeePot1);
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(ofResult);
    CoffeePot coffeePot2 = mock(CoffeePot.class);
    when(coffeePot2.getBrand()).thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));
    when(coffeePot2.getSku()).thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));
    when(coffeePot2.getReleaseDate()).thenThrow(new ResponseStatusException(HttpStatus.CONTINUE));
    when(coffeePot2.getId()).thenReturn(123L);
    doNothing().when(coffeePot2).setAge(anyInt());
    doNothing().when(coffeePot2).setBrand((String) any());
    doNothing().when(coffeePot2).setId((Long) any());
    doNothing().when(coffeePot2).setReleaseDate((LocalDate) any());
    doNothing().when(coffeePot2).setSku((String) any());
    coffeePot2.setAge(1);
    coffeePot2.setBrand("Brand");
    coffeePot2.setId(123L);
    coffeePot2.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot2.setSku("Sku");

    // Act and Assert
    assertThrows(
        ResponseStatusException.class,
        () -> this.coffeePotServiceImpl.updateCoffeePot(coffeePot2, 123L));
    verify(this.coffeePotRepository).findById((Long) any());
    verify(coffeePot).setAge(anyInt());
    verify(coffeePot).setBrand((String) any());
    verify(coffeePot).setId((Long) any());
    verify(coffeePot).setReleaseDate((LocalDate) any());
    verify(coffeePot).setSku((String) any());
    verify(coffeePot2, atLeast(1)).getId();
    verify(coffeePot2).getBrand();
    verify(coffeePot2).setAge(anyInt());
    verify(coffeePot2).setBrand((String) any());
    verify(coffeePot2).setId((Long) any());
    verify(coffeePot2).setReleaseDate((LocalDate) any());
    verify(coffeePot2).setSku((String) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#updateCoffeePot(CoffeePot, Long)} */
  @Test
  void testUpdateCoffeePot9() {
    // Arrange
    CoffeePot coffeePot = mock(CoffeePot.class);
    when(coffeePot.getReleaseDate()).thenReturn(LocalDate.ofEpochDay(1L));
    when(coffeePot.getBrand()).thenReturn("Brand");
    when(coffeePot.getSku()).thenReturn("Sku");
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
    Optional<CoffeePot> ofResult = Optional.of(coffeePot);

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");
    when(this.coffeePotRepository.existsCoffeePotBySku((String) any())).thenReturn(true);
    when(this.coffeePotRepository.save((CoffeePot) any())).thenReturn(coffeePot1);
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(ofResult);
    CoffeePot coffeePot2 = mock(CoffeePot.class);
    when(coffeePot2.getBrand()).thenReturn("");
    when(coffeePot2.getSku()).thenReturn("Sku");
    when(coffeePot2.getReleaseDate()).thenReturn(LocalDate.ofEpochDay(1L));
    when(coffeePot2.getId()).thenReturn(123L);
    doNothing().when(coffeePot2).setAge(anyInt());
    doNothing().when(coffeePot2).setBrand((String) any());
    doNothing().when(coffeePot2).setId((Long) any());
    doNothing().when(coffeePot2).setReleaseDate((LocalDate) any());
    doNothing().when(coffeePot2).setSku((String) any());
    coffeePot2.setAge(1);
    coffeePot2.setBrand("Brand");
    coffeePot2.setId(123L);
    coffeePot2.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot2.setSku("Sku");

    // Act and Assert
    assertSame(coffeePot1, this.coffeePotServiceImpl.updateCoffeePot(coffeePot2, 123L));
    verify(this.coffeePotRepository).save((CoffeePot) any());
    verify(this.coffeePotRepository).findById((Long) any());
    verify(coffeePot).getSku();
    verify(coffeePot).getReleaseDate();
    verify(coffeePot).setAge(anyInt());
    verify(coffeePot).setBrand((String) any());
    verify(coffeePot).setId((Long) any());
    verify(coffeePot).setReleaseDate((LocalDate) any());
    verify(coffeePot).setSku((String) any());
    verify(coffeePot2, atLeast(1)).getId();
    verify(coffeePot2).getBrand();
    verify(coffeePot2).getSku();
    verify(coffeePot2).getReleaseDate();
    verify(coffeePot2).setAge(anyInt());
    verify(coffeePot2).setBrand((String) any());
    verify(coffeePot2).setId((Long) any());
    verify(coffeePot2).setReleaseDate((LocalDate) any());
    verify(coffeePot2).setSku((String) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#updateCoffeePot(CoffeePot, Long)} */
  @Test
  void testUpdateCoffeePot10() {
    // Arrange
    CoffeePot coffeePot = mock(CoffeePot.class);
    when(coffeePot.getReleaseDate()).thenReturn(LocalDate.ofEpochDay(1L));
    when(coffeePot.getBrand()).thenReturn("Brand");
    when(coffeePot.getSku()).thenReturn("Sku");
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
    Optional<CoffeePot> ofResult = Optional.of(coffeePot);

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");
    when(this.coffeePotRepository.existsCoffeePotBySku((String) any())).thenReturn(true);
    when(this.coffeePotRepository.save((CoffeePot) any())).thenReturn(coffeePot1);
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(ofResult);
    CoffeePot coffeePot2 = mock(CoffeePot.class);
    when(coffeePot2.getBrand()).thenReturn("Brand");
    when(coffeePot2.getSku()).thenReturn("");
    when(coffeePot2.getReleaseDate()).thenReturn(LocalDate.ofEpochDay(1L));
    when(coffeePot2.getId()).thenReturn(123L);
    doNothing().when(coffeePot2).setAge(anyInt());
    doNothing().when(coffeePot2).setBrand((String) any());
    doNothing().when(coffeePot2).setId((Long) any());
    doNothing().when(coffeePot2).setReleaseDate((LocalDate) any());
    doNothing().when(coffeePot2).setSku((String) any());
    coffeePot2.setAge(1);
    coffeePot2.setBrand("Brand");
    coffeePot2.setId(123L);
    coffeePot2.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot2.setSku("Sku");

    // Act and Assert
    assertSame(coffeePot1, this.coffeePotServiceImpl.updateCoffeePot(coffeePot2, 123L));
    verify(this.coffeePotRepository).save((CoffeePot) any());
    verify(this.coffeePotRepository).findById((Long) any());
    verify(coffeePot).getBrand();
    verify(coffeePot).getReleaseDate();
    verify(coffeePot).setAge(anyInt());
    verify(coffeePot).setBrand((String) any());
    verify(coffeePot).setId((Long) any());
    verify(coffeePot).setReleaseDate((LocalDate) any());
    verify(coffeePot).setSku((String) any());
    verify(coffeePot2, atLeast(1)).getId();
    verify(coffeePot2).getBrand();
    verify(coffeePot2).getSku();
    verify(coffeePot2).getReleaseDate();
    verify(coffeePot2).setAge(anyInt());
    verify(coffeePot2).setBrand((String) any());
    verify(coffeePot2).setId((Long) any());
    verify(coffeePot2).setReleaseDate((LocalDate) any());
    verify(coffeePot2).setSku((String) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#updateCoffeePot(CoffeePot, Long)} */
  @Test
  void testUpdateCoffeePot11() {
    // Arrange
    CoffeePot coffeePot = mock(CoffeePot.class);
    when(coffeePot.getReleaseDate()).thenReturn(LocalDate.ofEpochDay(1L));
    when(coffeePot.getBrand()).thenReturn("Brand");
    when(coffeePot.getSku()).thenReturn("Sku");
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
    Optional<CoffeePot> ofResult = Optional.of(coffeePot);

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");
    when(this.coffeePotRepository.existsCoffeePotBySku((String) any())).thenReturn(true);
    when(this.coffeePotRepository.save((CoffeePot) any())).thenReturn(coffeePot1);
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(ofResult);
    CoffeePot coffeePot2 = mock(CoffeePot.class);
    when(coffeePot2.getBrand()).thenReturn("Brand");
    when(coffeePot2.getSku()).thenReturn("Sku");
    when(coffeePot2.getReleaseDate()).thenReturn(LocalDate.ofEpochDay(-1L));
    when(coffeePot2.getId()).thenReturn(123L);
    doNothing().when(coffeePot2).setAge(anyInt());
    doNothing().when(coffeePot2).setBrand((String) any());
    doNothing().when(coffeePot2).setId((Long) any());
    doNothing().when(coffeePot2).setReleaseDate((LocalDate) any());
    doNothing().when(coffeePot2).setSku((String) any());
    coffeePot2.setAge(1);
    coffeePot2.setBrand("Brand");
    coffeePot2.setId(123L);
    coffeePot2.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot2.setSku("Sku");

    // Act and Assert
    assertSame(coffeePot1, this.coffeePotServiceImpl.updateCoffeePot(coffeePot2, 123L));
    verify(this.coffeePotRepository).save((CoffeePot) any());
    verify(this.coffeePotRepository).findById((Long) any());
    verify(coffeePot).getBrand();
    verify(coffeePot).getSku();
    verify(coffeePot).setAge(anyInt());
    verify(coffeePot).setBrand((String) any());
    verify(coffeePot).setId((Long) any());
    verify(coffeePot).setReleaseDate((LocalDate) any());
    verify(coffeePot).setSku((String) any());
    verify(coffeePot2, atLeast(1)).getId();
    verify(coffeePot2).getBrand();
    verify(coffeePot2).getSku();
    verify(coffeePot2).getReleaseDate();
    verify(coffeePot2).setAge(anyInt());
    verify(coffeePot2).setBrand((String) any());
    verify(coffeePot2).setId((Long) any());
    verify(coffeePot2).setReleaseDate((LocalDate) any());
    verify(coffeePot2).setSku((String) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#updateCoffeePot(CoffeePot, Long)} */
  @Test
  void testUpdateCoffeePot12() {
    // Arrange
    CoffeePot coffeePot = mock(CoffeePot.class);
    when(coffeePot.getReleaseDate()).thenReturn(LocalDate.ofEpochDay(1L));
    when(coffeePot.getBrand()).thenReturn("Brand");
    when(coffeePot.getSku()).thenReturn("Sku");
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
    Optional<CoffeePot> ofResult = Optional.of(coffeePot);

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");
    when(this.coffeePotRepository.existsCoffeePotBySku((String) any())).thenReturn(true);
    when(this.coffeePotRepository.save((CoffeePot) any())).thenReturn(coffeePot1);
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(ofResult);
    CoffeePot coffeePot2 = mock(CoffeePot.class);
    when(coffeePot2.getBrand()).thenReturn("Brand");
    when(coffeePot2.getSku()).thenReturn("Sku");
    when(coffeePot2.getReleaseDate()).thenReturn(null);
    when(coffeePot2.getId()).thenReturn(123L);
    doNothing().when(coffeePot2).setAge(anyInt());
    doNothing().when(coffeePot2).setBrand((String) any());
    doNothing().when(coffeePot2).setId((Long) any());
    doNothing().when(coffeePot2).setReleaseDate((LocalDate) any());
    doNothing().when(coffeePot2).setSku((String) any());
    coffeePot2.setAge(1);
    coffeePot2.setBrand("Brand");
    coffeePot2.setId(123L);
    coffeePot2.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot2.setSku("Sku");

    // Act and Assert
    assertSame(coffeePot1, this.coffeePotServiceImpl.updateCoffeePot(coffeePot2, 123L));
    verify(this.coffeePotRepository).save((CoffeePot) any());
    verify(this.coffeePotRepository).findById((Long) any());
    verify(coffeePot).getBrand();
    verify(coffeePot).getSku();
    verify(coffeePot).setAge(anyInt());
    verify(coffeePot).setBrand((String) any());
    verify(coffeePot).setId((Long) any());
    verify(coffeePot).setReleaseDate((LocalDate) any());
    verify(coffeePot).setSku((String) any());
    verify(coffeePot2, atLeast(1)).getId();
    verify(coffeePot2).getBrand();
    verify(coffeePot2).getSku();
    verify(coffeePot2).getReleaseDate();
    verify(coffeePot2).setAge(anyInt());
    verify(coffeePot2).setBrand((String) any());
    verify(coffeePot2).setId((Long) any());
    verify(coffeePot2).setReleaseDate((LocalDate) any());
    verify(coffeePot2).setSku((String) any());
  }

  /** Method under test: {@link CoffeePotServiceImpl#updateCoffeePot(CoffeePot, Long)} */
  @Test
  void testUpdateCoffeePot13() {
    // Arrange
    CoffeePot coffeePot = mock(CoffeePot.class);
    when(coffeePot.getReleaseDate()).thenReturn(LocalDate.ofEpochDay(1L));
    when(coffeePot.getBrand()).thenReturn("Brand");
    when(coffeePot.getSku()).thenReturn("Sku");
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
    Optional<CoffeePot> ofResult = Optional.of(coffeePot);

    CoffeePot coffeePot1 = new CoffeePot();
    coffeePot1.setAge(1);
    coffeePot1.setBrand("Brand");
    coffeePot1.setId(123L);
    coffeePot1.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot1.setSku("Sku");
    when(this.coffeePotRepository.existsCoffeePotBySku((String) any())).thenReturn(true);
    when(this.coffeePotRepository.save((CoffeePot) any())).thenReturn(coffeePot1);
    when(this.coffeePotRepository.findById((Long) any())).thenReturn(ofResult);
    CoffeePot coffeePot2 = mock(CoffeePot.class);
    when(coffeePot2.getBrand()).thenReturn("Brand");
    when(coffeePot2.getSku()).thenReturn("Sku");
    when(coffeePot2.getReleaseDate()).thenReturn(LocalDate.ofEpochDay(1L));
    when(coffeePot2.getId()).thenReturn(1L);
    doNothing().when(coffeePot2).setAge(anyInt());
    doNothing().when(coffeePot2).setBrand((String) any());
    doNothing().when(coffeePot2).setId((Long) any());
    doNothing().when(coffeePot2).setReleaseDate((LocalDate) any());
    doNothing().when(coffeePot2).setSku((String) any());
    coffeePot2.setAge(1);
    coffeePot2.setBrand("Brand");
    coffeePot2.setId(123L);
    coffeePot2.setReleaseDate(LocalDate.ofEpochDay(1L));
    coffeePot2.setSku("Sku");

    // Act and Assert
    assertThrows(
        ResponseStatusException.class,
        () -> this.coffeePotServiceImpl.updateCoffeePot(coffeePot2, 123L));
    verify(coffeePot).setAge(anyInt());
    verify(coffeePot).setBrand((String) any());
    verify(coffeePot).setId((Long) any());
    verify(coffeePot).setReleaseDate((LocalDate) any());
    verify(coffeePot).setSku((String) any());
    verify(coffeePot2, atLeast(1)).getId();
    verify(coffeePot2).setAge(anyInt());
    verify(coffeePot2).setBrand((String) any());
    verify(coffeePot2).setId((Long) any());
    verify(coffeePot2).setReleaseDate((LocalDate) any());
    verify(coffeePot2).setSku((String) any());
  }
}
