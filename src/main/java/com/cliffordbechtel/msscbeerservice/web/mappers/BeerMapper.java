package com.cliffordbechtel.msscbeerservice.web.mappers;

import com.cliffordbechtel.msscbeerservice.beer_service.domain.Beer;
import com.cliffordbechtel.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    BeerDto beerToBeerDtoWithInventory(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
