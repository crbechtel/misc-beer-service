package com.cliffordbechtel.msscbeerservice.beer_service.bootstrap;

import com.cliffordbechtel.msscbeerservice.beer_service.domain.Beer;
import com.cliffordbechtel.msscbeerservice.beer_service.repositories.BeerRepository;
import com.cliffordbechtel.msscbeerservice.web.model.BeerStyleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";
    public static final String BEER_4_UPC = "0083783375232";
    public static final String BEER_5_UPC = "0083782275213";
    public static final String BEER_6_UPC = "0023763375222";
    public static final String BEER_7_UPC = "0783783332215";
    public static final String BEER_8_UPC = "0883783375217";
    public static final String BEER_9_UPC = "0983783375443";

    private final BeerRepository beerRepository;


    public BeerLoader(
                                BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        checkInventory();
    }

    private void loadBeerData() {
        if (beerRepository.count() == 0) {
            Beer mangoBobs = Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle(BeerStyleEnum.IPA)
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .quantityOnHand(500)
                    .upc(BEER_1_UPC)
                    .build();

            beerRepository.save(mangoBobs);

            Beer galaxyCat = Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyleEnum.PALE_ALE)
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(BEER_2_UPC)
                    .build();

            beerRepository.save(galaxyCat);

            Beer pinball = Beer.builder()
                    .beerName("Pinball Porter")
                    .beerStyle(BeerStyleEnum.PORTER)
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(BEER_3_UPC)
                    .build();

            beerRepository.save(pinball);

            beerRepository.save(Beer.builder()
                    .beerName("Golden Buddha")
                    .beerStyle(BeerStyleEnum.IPA)
                    .minOnHand(12)
                    .quantityToBrew(300)
                    .upc(BEER_4_UPC)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Cage Blond")
                    .beerStyle(BeerStyleEnum.ALE)
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(BEER_5_UPC)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Amarmillo IPA")
                    .beerStyle(BeerStyleEnum.IPA)
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(BEER_6_UPC)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("King Krush")
                    .beerStyle(BeerStyleEnum.IPA)
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(BEER_7_UPC)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Static IPA")
                    .beerStyle(BeerStyleEnum.IPA)
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(BEER_8_UPC)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Grand Central")
                    .beerStyle(BeerStyleEnum.ALE)
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .upc(BEER_9_UPC)
                    .build());
        }
    }

    public void checkInventory(){
        List<Beer> beers = beerRepository.findAll();

        beers.forEach(beer -> {
            AtomicInteger inventory_qoh = new AtomicInteger();

//            beer.getBeerInventory().forEach(inv -> inventory_qoh.addAndGet(inv.getQuantityOnHand()));
//
//            log.debug("Inv: " + beer.getBeerName() + " : QOH = " + inventory_qoh.get());
//
//            if(beer.getMinOnHand() >= inventory_qoh.get() ) {
//                //brew beer
//                publisher.publishEvent(new BrewBeerEvent(beer));
//            }
        });
    }
}
