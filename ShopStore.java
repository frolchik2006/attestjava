import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ShopStore {
    public static void main(String[] args) {
        Shop noteBook1 = new Shop("Lenovo", 15, 4, 256, "Windows 11", "grey");
        Shop noteBook2 = new Shop("LG", 17.3, 8, 512, "Windows 11", "black");
        Shop noteBook3 = new Shop("Apple", 13.3, 8, 256, "macOS", "white");
        Shop noteBook4 = new Shop("HUAWEI", 16, 16, 512, "Windows 11", "grey");
        Shop noteBook5 = new Shop("MSI", 15.6, 8, 512, "Windows 11", "white");
        Shop noteBook6 = new Shop("Xiaomi", 16, 16, 512, "Windows 11", "black");

        Set<Shop> noteBooks = new HashSet<>();
        noteBooks.add(noteBook1);
        noteBooks.add(noteBook2);
        noteBooks.add(noteBook3);
        noteBooks.add(noteBook4);
        noteBooks.add(noteBook5);
        noteBooks.add(noteBook6);

        Map<Integer, String> criterias = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        int criteriaNumber = 0;
        String criteriaValue;

        while (criteriaNumber != 5) {
            System.out.println("Введите критерии для поиска:" + "\n"
                    + "1 - ОЗУ" + "\n"
                    + "2 - Объем ЖД" + "\n"
                    + "3 - Операционная система" + "\n"
                    + "4 - Цвет" + "\n"
                    + "5 - Выход");
            criteriaNumber = scanner.nextInt();

            if(criteriaNumber < 1 || criteriaNumber > 5) {
                System.out.println("Такого критерия не существует");
            }
            else if (criteriaNumber != 5) {
                criterias.put(criteriaNumber, null);
            }
            System.out.println();
        }

        for (Map.Entry<Integer, String> item : criterias.entrySet()) {
            System.out.printf("Введите значени для критерия %d:\n", item.getKey());
            criteriaValue = scanner1.nextLine();
            criterias.put(item.getKey(), criteriaValue);
            System.out.println();
        }

        scanner.close();
        scanner1.close();

        ShopFilter(criterias, noteBooks);
    }

    public static void ShopFilter(Map<Integer, String> critates, Set<Shop> laptops) {

        for (Shop laptop : laptops) {
            boolean corresponds = true;

            for (Map.Entry<Integer, String> entry : critates.entrySet()) {
                int criterion = entry.getKey();
                String value = entry.getValue();

                switch (criterion) {
                    case 1:
                        if (laptop.getRam() < Integer.parseInt(value)) {
                            corresponds = false;
                        }
                        break;
                    case 2:
                        if (laptop.getHdd() < Integer.parseInt(value)) {
                            corresponds = false;
                        }
                        break;
                    case 3:
                        if (!laptop.getOS().equals(value)) {
                            corresponds = false;
                        }
                        break;
                    case 4:
                        if (!laptop.getColor().equals(value)) {
                            corresponds = false;
                        }
                        break;

                    default:
                        break;
                }
            }
            if (corresponds) {
                System.out.println(laptop);
            }
        }
    }
}