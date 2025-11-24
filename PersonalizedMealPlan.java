//Problem 4. Personalized Meal Plan Generator

import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    void showMealDetails();
}

class VegetarianMeal implements MealPlan {
    private String mainDish;

    public VegetarianMeal(String mainDish) {
        this.mainDish = mainDish;
    }

    public void showMealDetails() {
        System.out.println("Vegetarian Meal: " + mainDish);
    }
}

class VeganMeal implements MealPlan {
    private String mainDish;

    public VeganMeal(String mainDish) {
        this.mainDish = mainDish;
    }

    public void showMealDetails() {
        System.out.println("Vegan Meal: " + mainDish);
    }
}

class KetoMeal implements MealPlan {
    private String mainDish;

    public KetoMeal(String mainDish) {
        this.mainDish = mainDish;
    }

    public void showMealDetails() {
        System.out.println("Keto Meal: " + mainDish);
    }
}

class HighProteinMeal implements MealPlan {
    private String mainDish;

    public HighProteinMeal(String mainDish) {
        this.mainDish = mainDish;
    }

    public void showMealDetails() {
        System.out.println("High-Protein Meal: " + mainDish);
    }
}

class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public void showMeal() {
        mealPlan.showMealDetails();
    }
}

class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMeal(T meal) {
        return new Meal<>(meal);
    }

    public static void showAllMeals(List<? extends MealPlan> meals) {
        System.out.println("\nAvailable Meal Plans:");
        for (MealPlan m : meals) {
            m.showMealDetails();
        }
    }
}

public class PersonalizedMealPlan {
    public static void main(String[] args) {

        List<MealPlan> userMeals = new ArrayList<>();
        userMeals.add(new VegetarianMeal("Paneer Curry with Rice"));
        userMeals.add(new VeganMeal("Quinoa Salad"));
        userMeals.add(new KetoMeal("Grilled Chicken with Broccoli"));
        userMeals.add(new HighProteinMeal("Egg White Omelette"));

        System.out.println("Generating personalized meal plans...");
        List<Meal<?>> generatedMeals = new ArrayList<>();
        for (MealPlan m : userMeals) {
            generatedMeals.add(MealPlanGenerator.generateMeal(m));
        }

        for (Meal<?> meal : generatedMeals) {
            meal.showMeal();
        }
        MealPlanGenerator.showAllMeals(userMeals);
    }
}