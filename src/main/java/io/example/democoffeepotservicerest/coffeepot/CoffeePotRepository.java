package io.example.democoffeepotservicerest.coffeepot;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeePotRepository extends JpaRepository<CoffeePot, Long> {

  //  Same as @Query("SELECT c FROM CoffeePot WHERE c.sku = ?1")
  Optional<CoffeePot> findCoffeePotBySku(String sku);

  Boolean existsCoffeePotBySku(String sku);
}
