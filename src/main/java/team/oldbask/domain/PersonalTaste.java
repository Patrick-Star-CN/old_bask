package team.oldbask.domain;

import lombok.Data;

/**
 * @author Patrick_Star
 * @version 1.0
 */

@Data
public class PersonalTaste {
    private Integer uid;
    private Boolean sour;
    private Boolean sweet;
    private Boolean bitterness;
    private Boolean spicy;
    private Boolean salty;
    private Boolean light;
    private Boolean fiveSpice;
    private Boolean scallion;
    private Boolean garlic;
    private Boolean milkFragrance;
    private Boolean soySauce;
    private Boolean curry;
    private Boolean cumin;
    private Boolean fruity;
    private Boolean vanilla;
    private Boolean sweetFragrance;
    private Boolean dairyAllergy;
    private Boolean proteinAllergy;
    private Boolean nutAllergy;
    private Boolean seafoodAllergy;
    private Boolean soyAllergy;
    private Boolean wheatAllergy;
    private Boolean peanutAllergy;

    public PersonalTaste(Integer uid, Boolean sour, Boolean sweet, Boolean bitterness, Boolean spicy, Boolean salty, Boolean light, Boolean fiveSpice, Boolean scallion, Boolean garlic, Boolean milkFragrance, Boolean soySauce, Boolean curry, Boolean cumin, Boolean fruity, Boolean vanilla, Boolean sweetFragrance, Boolean dairyAllergy, Boolean proteinAllergy, Boolean nutAllergy, Boolean seafoodAllergy, Boolean soyAllergy, Boolean wheatAllergy, Boolean peanutAllergy) {
        this.uid = uid;
        this.sour = sour;
        this.sweet = sweet;
        this.bitterness = bitterness;
        this.spicy = spicy;
        this.salty = salty;
        this.light = light;
        this.fiveSpice = fiveSpice;
        this.scallion = scallion;
        this.garlic = garlic;
        this.milkFragrance = milkFragrance;
        this.soySauce = soySauce;
        this.curry = curry;
        this.cumin = cumin;
        this.fruity = fruity;
        this.vanilla = vanilla;
        this.sweetFragrance = sweetFragrance;
        this.dairyAllergy = dairyAllergy;
        this.proteinAllergy = proteinAllergy;
        this.nutAllergy = nutAllergy;
        this.seafoodAllergy = seafoodAllergy;
        this.soyAllergy = soyAllergy;
        this.wheatAllergy = wheatAllergy;
        this.peanutAllergy = peanutAllergy;
    }
}
