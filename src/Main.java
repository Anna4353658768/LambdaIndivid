public class Main {
    public static void main(String[] args) {

        //Создадим экземплар класса Product
        //Молоко с весом 1кг и размером 10см/10см/25см
        //И через лямбда-выражение найдем его обьем
        Product product = new Product("Молоко", 1F, 10F, 10F, 25F);

        Operation operation;
        Size size = product.getSize();
        operation = (x, y, z) -> x * y * z;

        Float res = operation.find_volume(size.getWidth(), size.getLength(), size.getHeight());
        System.out.println("Обьем продукта " + product.getName() + " : " + res);


        //Терминальное ламбда вырожение
        Printable printable = s -> System.out.println(s);
        printable.print("Вес продукта " + product.getName() + " : " + product.getWeight() + "кг");


        //Блок ламбда-выражаения
        //Если размер введен коректно возвращает его обьем
        //Если нет то -1
        Operation oper = (x, y, z) -> {
            if(x * y * z > 0){
                return x * y * z;
            }
            else
                return -1F;
        };

        //Изменим значение высоты на -10
        size.setHeight(-10F);
        Float res2 = oper.find_volume(size.getWidth(), size.getLength(), size.getHeight());

        //Вернем значение высота на корректное 25
        size.setHeight(25F);
        Float res3 = oper.find_volume(size.getWidth(), size.getLength(), size.getHeight());

        //Добавим ламбда-выражение проверки и печати результата
        Check check = f ->{
            if (f == -1){
                System.out.println("Невозможно посчитать обьем. Одно из значений размера отрицательное");
            }
            else
                System.out.println("Обьем продукта " + product.getName() + " : " + f);
        };

        //Печать результата проверки
        check.print(res2);
        check.print(res3);

    }
}