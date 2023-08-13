package com.cliffordbechtel.msscbeerservice.bootstrap;

import com.cliffordbechtel.msscbeerservice.domain.Beer;
import com.cliffordbechtel.msscbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0) {

            beerRepository.save(Beer.builder()
                            .beerName("Guinness")
                            .beerStyle("Stout")
                            .minOnHand(12)
                            .quantityToBrew(200)
                            .upc(3040405055L)
                            .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Yuengling")
                    .beerStyle("Lager")
                    .minOnHand(25)
                    .quantityToBrew(300)
                    .upc(304040343455L)
                    .price(new BigDecimal("6.95"))
                    .build());
        }

        System.out.println("beer repository count: " + beerRepository.count());
    }
}
