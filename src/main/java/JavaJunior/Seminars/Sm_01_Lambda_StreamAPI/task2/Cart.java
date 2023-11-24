package JavaJunior.Seminars.Sm_01_Lambda_StreamAPI.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Корзина
 * @param <T> Еда
 */
public class Cart <T extends Food>{

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    public Cart(Class<T> clazz, UMarket market)
    {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs(){
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> {
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                    index.getAndIncrement(), food.getName(),
                    food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет");
        });
    }

    /**
     * Балансировка корзины
     */

    // мой вариант метода cardBalancing()
    public void cardBalancing() {
        // Проверяем, удовлетворяет ли хотя бы один элемент потока определенному условию
        boolean proteins = foodstuffs.stream().anyMatch(Food::getProteins);
        boolean[] proteinsArr = new boolean[]{proteins}; // пришлось добавить в контейнер иначе нельзя было
                                                         // использовать переменную в stream

        boolean fats = foodstuffs.stream().anyMatch(Food::getFats);
        boolean[] fatsArr = new boolean[]{fats};

        boolean carbohydrates = foodstuffs.stream().anyMatch(Food::getCarbohydrates);
        boolean[] carbohydratesArr = new boolean[]{carbohydrates};

        // Если все ОК, то выводим все ОК!
        if (proteins && fats && carbohydrates) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
        }

        // Создаем коллекцию из всех продовольственных товаров нашего магазина
        Collection<Food> things = market.getThings(Food.class);

        things.stream()
                .filter(thing -> !proteinsArr[0] && thing.getProteins()) // изначально пытался сделать через map, но
                                                                         // IDE ругался на (T)food и писал:
                                                        // Inconvertible types; cannot cast 'java.lang.Boolean' to 'T'
                                                        // поменял на filter и все заработало
                .findFirst().ifPresent(food -> {
                    proteinsArr[0] = true;
                    foodstuffs.add((T)food);
                });

        proteins = proteinsArr[0];

        things.stream()
                .filter(thing -> !fatsArr[0] && thing.getFats())
                .findFirst().ifPresent(food -> {
                    fatsArr[0] = true;
                    foodstuffs.add((T)food);
                });

        fats = fatsArr[0];

        things.stream()
                .filter(thing -> !carbohydratesArr[0] && thing.getCarbohydrates())
                .findFirst().ifPresent(food -> {
                    carbohydratesArr[0] = true;
                    foodstuffs.add((T)food);
                });

        carbohydrates = carbohydratesArr[0];


        if (proteins && fats && carbohydrates) {
            System.out.println("Корзина сбалансирована по БЖУ.");
        } else {
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");
        }

    }

    // Вариант преподавателя
//    public void cardBalancing() {
//
//        boolean proteins = false;
//        boolean fats = false;
//        boolean carbohydrates = false;
//
//        for (var food : foodstuffs) {
//
//            if (!proteins && food.getProteins()) {
//                proteins = true;
//            } else if (!fats && food.getFats()) {
//                fats = true;
//            } else if (!carbohydrates && food.getCarbohydrates()) {
//                carbohydrates = true;
//            }
//
//            if (proteins && fats && carbohydrates) {
//                break;
//            }
//        }
//
//        if (proteins && fats && carbohydrates) {
//
//            System.out.println("Корзина уже сбалансирована по БЖУ.");
//            return;
//        }
//
//
//        for (var thing : market.getThings(Food.class)) {
//
//            if (!proteins && thing.getProteins()) {
//                proteins = true;
//                foodstuffs.add((T)thing);
//
//            } else if (!fats && thing.getFats()) {
//                fats = true;
//                foodstuffs.add((T)thing);
//
//            } else if (!carbohydrates && thing.getCarbohydrates()) {
//
//                carbohydrates = true;
//                foodstuffs.add((T)thing);
//            }
//
//            if (proteins && fats && carbohydrates) {
//                break;
//            }
//        }
//
//        if (proteins && fats && carbohydrates) {
//            System.out.println("Корзина сбалансирована по БЖУ.");
//        } else {
//            System.out.println("Невозможно сбалансировать корзину по БЖУ.");
//        }
//    }


}
