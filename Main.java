public class Main {

    public static void main(String[] args) {
        while (true) {
            printMainMenu();
            int choice = Input.readInt("Ваш выбор: ");
            switch (choice) {
                case 1: menuPerson();      break;  // Задание 1.2
                case 2: menuNames13();     break;  // Задание 1.3
                case 3: menuEmployees24();   break;  // Задание 2.4 
                case 4: menuEmployees34();   break;  // Задание 3.4 
                case 5: menuNames45();     break;  // Задание 4.5
                case 6: menuGun();         break;  // Задание 5.1
                case 0:
                    System.out.println("Выход. До свидания!");
                    return;
                default:
                    System.out.println("Неверный выбор. Повторите.");
            }
        }
    }

    // ГЛАВНОЕ МЕНЮ
    private static void printMainMenu() {
        System.out.println("     ЛАБОРАТОРНАЯ РАБОТА №2");
        System.out.println("  1. Задание 1.2: Человек");
        System.out.println("  2. Задание 1.3: Имена");
        System.out.println("  3. Задание 2.4: Сотрудники и отделы ");
        System.out.println("  4. Задание 3.4: Сотрудники и отделы ");
        System.out.println("  5. Задание 4.5: Создаем Имена");
        System.out.println("  6. Задание 5.1: Пистолет");
        System.out.println("  0. Выход");
    }

    // ЗАДАНИЕ 1.2. ЧЕЛОВЕК
    private static void menuPerson() {
        while (true) {
            System.out.println("\n ЗАДАНИЕ 1.2: ЧЕЛОВЕК ");
            System.out.println("  1. Демонстрация (3 человека из условия)");
            System.out.println("  2. Создать человека вручную");
            System.out.println("  0. Назад");
            int choice = Input.readInt("Ваш выбор: ");
            switch (choice) {
                case 1: demoPerson(); break;
                case 2: createPersonManual(); break;
                case 0: return;
                default: System.out.println("Неверный выбор.");
            }
        }
    }

    private static void demoPerson() {
        System.out.println(new Person("Клеопатра", 152));
        System.out.println(new Person("Пушкин",   167));
        System.out.println(new Person("Владимир", 189));
    }

    private static void createPersonManual() {
        String name = Input.readNonEmptyString("   Имя: ");
        int height = Input.readPositiveInt("   Рост: ");
        Person p = new Person(name, height);
        System.out.println("   Создан: " + p);
    }

    // ЗАДАНИЕ 1.3. ИМЕНА
    private static void menuNames13() {
        while (true) {
            System.out.println("\n ЗАДАНИЕ 1.3: ИМЕНА ");
            System.out.println("  1. Демонстрация (3 имени из условия)");
            System.out.println("  2. Создать имя вручную");
            System.out.println("  0. Назад");
            int choice = Input.readInt("Ваш выбор: ");
            switch (choice) {
                case 1: demoNames13(); break;
                case 2: createNameManual(); break;
                case 0: return;
                default: System.out.println("Неверный выбор.");
            }
        }
    }

    private static void demoNames13() {
        System.out.println(new Name(null, "Клеопатра", null));
        System.out.println(new Name("Пушкин", "Александр", "Сергеевич"));
        System.out.println(new Name("Маяковский", "Владимир", null));
    }

    private static void createNameManual() {
        System.out.println("(пустая строка = параметр не задан)");
        String surname = Input.readOptionalString(" Фамилия: ");
        String firstName = Input.readOptionalString(" Личное имя: ");
        String patronymic = Input.readOptionalString(" Отчество: ");
        Name n = new Name(surname, firstName, patronymic);
        System.out.println("Создано имя: \"" + n + "\"");
    }
    
    // ЗАДАНИЕ 2.4. СОТРУДНИКИ И ОТДЕЛЫ
    private static void menuEmployees24() {
        Department it = new Department("IT");
        Employee petrov  = new Employee("Петров",  it);
        Employee kozlov  = new Employee("Козлов",  it);
        Employee sidorov = new Employee("Сидоров", it);

        while (true) {
            System.out.println("\n ЗАДАНИЕ 2.4: СОТРУДНИКИ И ОТДЕЛЫ ");
            System.out.println("  1. Показать отдел и трёх сотрудников");
            System.out.println("  2. Сделать Козлова начальником IT");
            System.out.println("  3. Вывести всех сотрудников");
            System.out.println("  0. Назад");
            int choice = Input.readInt("Ваш выбор: ");
            switch (choice) {
                case 1:
                    System.out.println(" Отдел: " + it);
                    System.out.println(" Сотрудники: Петров, Козлов, Сидоров");
                    break;
                case 2:
                    it.setHead(kozlov);
                    System.out.println(" Начальник IT: " + it.getHead().getName());
                    break;
                case 3:
                    System.out.println(petrov);
                    System.out.println(kozlov);
                    System.out.println(sidorov);
                    break;
                case 0: return;
                default: System.out.println("Неверный выбор.");
            }
        }
    }

    // ЗАДАНИЕ 3.4. СПИСОК СОТРУДНИКОВ ОТДЕЛА
    private static void menuEmployees34() {
        Department it = new Department("IT");
        Employee petrov  = new Employee("Петров",  it);
        Employee kozlov  = new Employee("Козлов",  it);
        Employee sidorov = new Employee("Сидоров", it);
        it.setHead(kozlov); 

        while (true) {
            System.out.println("\n ЗАДАНИЕ 3.4: СПИСОК СОТРУДНИКОВ ОТДЕЛА ");
            System.out.println("  1. Показать список сотрудников отдела (через Петрова)");
            System.out.println("  2. Показать список сотрудников отдела (через Козлова)");
            System.out.println("  3. Показать список сотрудников отдела (через Сидорова)");
            System.out.println("  4. Добавить сотрудника в IT");
            System.out.println("  5. Вывести количество сотрудников в IT");
            System.out.println("  0. Назад");
            int choice = Input.readInt("Ваш выбор: ");
            switch (choice) {
                case 1: printColleagues("Петров",  petrov.getColleagues());  break;
                case 2: printColleagues("Козлов",  kozlov.getColleagues());  break;
                case 3: printColleagues("Сидоров", sidorov.getColleagues()); break;
                case 4: {
                    String name = Input.readNonEmptyString("Имя нового сотрудника: ");
                    Employee extra = new Employee(name, it);
                    System.out.println("Добавлен: " + extra);
                    break;
                }
                case 5:
                    System.out.println("Всего сотрудников в IT: " + it.getEmployees().size());
                    break;
                case 0: return;
                default: System.out.println("Неверный выбор.");
            }
        }
    }

    private static void printColleagues(String who, java.util.List<Employee> list) {
        System.out.println("Сотрудники IT (через " + who + "):");
        for (Employee e : list) {
            System.out.println("  - " + e.getName());
        }
    }
    
    // ЗАДАНИЕ 4.5. СОЗДАЕМ ИМЕНА
    private static void menuNames45() {
        while (true) {
            System.out.println("\n ЗАДАНИЕ 4.5: СОЗДАЕМ ИМЕНА ");
            System.out.println("  1. Демонстрация (4 имени из условия)");
            System.out.println("  2. Создать: только имя");
            System.out.println("  3. Создать: имя + фамилия");
            System.out.println("  4. Создать: имя + фамилия + отчество");
            System.out.println("  0. Назад");
            int choice = Input.readInt("Ваш выбор: ");
            switch (choice) {
                case 1: demo45(); break;
                case 2: {
                    String f = Input.readNonEmptyString("Личное имя: ");
                    System.out.println(new Name(f));
                    break;
                }
                case 3: {
                    String f = Input.readNonEmptyString("Личное имя: ");
                    String s = Input.readNonEmptyString("Фамилия: ");
                    System.out.println(new Name(f, s));
                    break;
                }
                case 4: {
                    String s = Input.readNonEmptyString("Фамилия: ");
                    String f = Input.readNonEmptyString("Личное имя: ");
                    String p = Input.readNonEmptyString("Отчество: ");
                    System.out.println(new Name(s, f, p));
                    break;
                }
                case 0: return;
                default: System.out.println("Неверный выбор.");
            }
        }
    }

    private static void demo45() {
        System.out.println("\n>> 4 имени из условия:");
        System.out.println(new Name("Клеопатра"));
        System.out.println(new Name("Пушкин", "Александр", "Сергеевич"));
        System.out.println(new Name("Владимир", "Маяковский"));
        System.out.println(new Name("Христофор", "Бонифатьевич"));
    }

    // ЗАДАНИЕ 5.1. ПИСТОЛЕТ
    private static void menuGun() {
        while (true) {
            System.out.println("\n ЗАДАНИЕ 5.1: ПИСТОЛЕТ ");
            System.out.println("  1. Демонстрация: пистолет на 3 патрона, 5 выстрелов");
            System.out.println("  2. Пистолет на 5 патронов");
            System.out.println("  3. Создать пистолет вручную");
            System.out.println("  0. Назад");
            int choice = Input.readInt("Ваш выбор: ");
            switch (choice) {
                case 1: demoGun3(); break;
                case 2: Gun5(); break;
                case 3: createGunManual(); break;
                case 0: return;
                default: System.out.println("Неверный выбор.");
            }
        }
    }

    private static void demoGun3() {
        Gun gun = new Gun(3);
        System.out.println("   До стрельбы: " + gun);
        for (int i = 1; i <= 5; i++) {
            System.out.print("   Выстрел " + i + ": ");
            gun.shoot();
        }
        System.out.println("   После стрельбы: " + gun);
    }

    private static void Gun5(){
        Gun gun = new Gun();
        System.out.println("   Создан: " + gun);
        int shots = Input.readNonNegativeInt("   Сколько выстрелов: ");
        for (int i = 1; i <= shots; i++) {
            System.out.print("   Выстрел " + i + ": ");
            gun.shoot();
        }
        System.out.println("   Итог: " + gun);
    }

    private static void createGunManual() {
        int bullets = Input.readNonNegativeInt("   Количество патронов: ");
        Gun gun = new Gun(bullets);
        System.out.println("   Создан: " + gun);
        int shots = Input.readNonNegativeInt("   Сколько выстрелов: ");
        for (int i = 1; i <= shots; i++) {
            System.out.print("   Выстрел " + i + ": ");
            gun.shoot();
        }
        System.out.println("   Итог: " + gun);
    }
}