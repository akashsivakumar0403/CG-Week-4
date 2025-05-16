import java.util.*;

interface MealPlan {
    String getName();
    List<String> getIngredients();
}

class VegMeal implements MealPlan {
    public String getName() {
        return "Vegetarian Meal";
    }

    public List<String> getIngredients() {
        return Arrays.asList("Tofu", "Vegetables", "Rice", "Lentils");
    }
}

class VeganMeal implements MealPlan {
    public String getName() {
        return "Vegan Meal";
    }

    public List<String> getIngredients() {
        return Arrays.asList("Quinoa", "Chickpeas", "Leafy Greens", "Nuts");
    }
}

class KetoMeal implements MealPlan {
    public String getName() {
        return "Keto Meal";
    }

    public List<String> getIngredients() {
        return Arrays.asList("Avocado", "Eggs", "Chicken", "Cheese");
    }
}

class HighProteinMeal implements MealPlan {
    public String getName() {
        return "High-Protein Meal";
    }

    public List<String> getIngredients() {
        return Arrays.asList("Beef", "Eggs", "Greek Yogurt", "Beans");
    }
}

class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public void displayMeal() {
        System.out.println("Meal Type = " + meal.getName());
        System.out.println("Ingredients = " + meal.getIngredients());
    }

    public T getMeal() { return meal; }
}

class MealPlanner {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealType) {
        System.out.println("Generating meal plan for = " + mealType.getName());
        return new Meal<>(mealType);
    }
}

public class MealPlanGenerator {
    public static void main(String[] args) {
        Meal<VegMeal> veg = MealPlanner.generateMealPlan(new VegMeal());
        Meal<VeganMeal> vegan = MealPlanner.generateMealPlan(new VeganMeal());
        Meal<KetoMeal> keto = MealPlanner.generateMealPlan(new KetoMeal());
        Meal<HighProteinMeal> highProtein = MealPlanner.generateMealPlan(new HighProteinMeal());

        System.out.println();
        veg.displayMeal();
        System.out.println();
        vegan.displayMeal();
        System.out.println();
        keto.displayMeal();
        System.out.println();
        highProtein.displayMeal();
    }
}
