import java.util.*;
/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
отвечающие фильтру. Критерии фильтрации можно хранить в Map. Например: “Введите цифру,
соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
 */

public class Main {
    public static void main(String[] args) {
        Laptop laptop001 = new Laptop();
        laptop001.model = "Irbis NB283";
        laptop001.ram = 4;
        laptop001.hdd = 128;
        laptop001.os = "Windows 10 Pro";
        laptop001.color = "серый";

        Laptop laptop002 = new Laptop();
        laptop002.model = "ASUS Laptop 15 F515JF-BR226";
        laptop002.ram = 8;
        laptop002.hdd = 256;
        laptop002.os = "без ОС";
        laptop002.color = "серебристый";

        Laptop laptop003 = new Laptop();
        laptop003.model = "Tecno Megabook T1";
        laptop003.ram = 12;
        laptop003.hdd = 256;
        laptop003.os = "Linux";
        laptop003.color = "синий";

        Laptop laptop004 = new Laptop();
        laptop004.model = "Dell Vostro 3500-5650";
        laptop004.ram = 4;
        laptop004.hdd = 1000;
        laptop004.os = "Windows 10";
        laptop004.color = "черный";

        Laptop laptop005 = new Laptop();
        laptop005.model = "F Plus FLAPTOP-R-Series";
        laptop005.ram = 16;
        laptop005.hdd = 512;
        laptop005.os = "Windows 11";
        laptop005.color = "серебристый";

        Laptop laptop006 = new Laptop();
        laptop006.model = "MSI GT77 Titan 12UHS-066RU";
        laptop006.ram = 32;
        laptop006.hdd = 2000;
        laptop006.os = "Windows 11";
        laptop006.color = "черный";

        Set laptops = new HashSet<>(Arrays.asList(laptop001, laptop002, laptop003, laptop004, laptop005, laptop006));
        System.out.println(laptops);
        Map<Integer, String> specsMap = new HashMap<>();
        specsMap(specsMap);
        System.out.println(specsMap);
        Set<Laptop> filter = filter(specsMap, laptops);
        System.out.println(filter);
        System.out.println();
        System.out.printf("Найдено %d ноутбука по текущему критерию", filter.size());


    }
    static Map<Integer, String> specsMap(Map<Integer, String> specsMap) {
        Map<Integer, String> options = new HashMap<>();
        options.put(1, "Введите минимальный объем ОЗУ (GB): ");
        options.put(2, "Введите минимальный объем ЖД (GB): ");
        options.put(3, "Введите ОС(Windows 10, Windows 11, Linux или напишите 'без ОС'): ");
        options.put(4, "Введите цвет (серебристый, серый, черный, синий...): ");
        System.out.print("Введите цифру, соответствующую необходимому критерию: " +
                "1 - ОЗУ, " +
                "2 - Объем ЖД, " +
                "3 - Операционная система, " +
                "4 - Цвет: ");
        Scanner scanner = new Scanner(System.in);
        int spec = scanner.nextInt();
        if (spec < 5 && spec > 0) {
            System.out.print(options.get(spec));
            scanner.nextLine();
            specsMap.put(spec, scanner.nextLine());
            System.out.print("Хотите выбрать еще один критерий? да или нет? ");
            String answer = scanner.nextLine();
            if (answer.equals("да")||answer.equals("Да")) {
                specsMap(specsMap);
            }
        } else {
            System.out.println("Данный критерий не представлен");
        }
        return specsMap;
    }

    static Set<Laptop> filter(Map<Integer, String> specsMap, Set laptops) {
        Set<Laptop> filter = new HashSet<>();
        Iterator<Laptop> iterator = laptops.iterator();
        while (iterator.hasNext()) {
            Laptop current = iterator.next();
            int count = 0;
            for (Map.Entry<Integer, String> entry : specsMap.entrySet()) {
                switch (entry.getKey()) {
                    case 1:
                        if (current.ram < Integer.parseInt(entry.getValue())) {
                            count++;
                        }
                        break;
                    case 2:
                        if (current.hdd < Integer.parseInt(entry.getValue())) {
                            count++;
                        }
                        break;
                    case 3:
                        if (!current.os.equals(entry.getValue())) {
                            count++;
                        }
                        break;
                    case 4:
                        if (!current.color.equals(entry.getValue())) {
                            count++;
                        }
                        break;
                }

            }
            if (count == 0) {
                filter.add(current);
            }
        }
        return filter;
    }
}