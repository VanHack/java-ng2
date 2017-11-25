package com.skipthedishes.api.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Set;

/**
 * Created by igorhara on 23/11/2017.
 */
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Dish implements PayableWithDishCoins {

    @Id
    private String id;

    private String idRestaurant;

    private String name;

    private String description;

    private Double rating;

    private Set<TagsEnum> tags;

    private Double price;

    @Override
    public Double getValueInDishCoins() {
        return this.convert(this.price);
    }
}
