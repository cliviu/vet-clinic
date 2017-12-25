package serenitylabs.tutorials.vetclinic.models;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Meal;
import serenitylabs.tutorials.vetclinic.Pet;
import serenitylabs.tutorials.vetclinic.collections.katas.PetFood;

import java.util.List;
import java.util.Map;

public class PetSatisfactionEvaluator {

    private final Pet pet;
    private static Map<Breed, PetFood> FOOD_FOR_BREED;
    private static Map<Breed, Integer> AMOUNT_FOR_BREED;
    static{
        FOOD_FOR_BREED.put(Breed.Cat,PetFood.KittyKat);
        FOOD_FOR_BREED.put(Breed.Dog,PetFood.FidosFood);

        AMOUNT_FOR_BREED.put(Breed.Cat,10);
        AMOUNT_FOR_BREED.put(Breed.Dog,20);
    }

    public PetSatisfactionEvaluator(Pet pet) {
        this.pet = pet;
    }

    public boolean isWellFed(List<Meal> mealsGiven) {
        double totalEaten = 0.0;
        for(Meal meal : mealsGiven) {
            if(FOOD_FOR_BREED.get(pet.getBreed()).equals(meal.getFoodBrand())) {
                totalEaten = totalEaten + meal.getAmountInGrams();
            }
        }
        double amountNeeded = pet.getWeightInKilos() * AMOUNT_FOR_BREED.get(pet.getBreed());
        return (totalEaten >= amountNeeded);

    }
}
