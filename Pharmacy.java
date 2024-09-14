package pharmacy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pharmacy  {
    private String name;
    private  String timeWork;
    List<Medicine> medicines = new ArrayList<>();

    public Pharmacy(String name, String timeWork) {
        this.name = name;
        this.timeWork = timeWork;
    }

    private void addMedicine(String name, double price) throws IOException {
//        var reader = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Введите названия лекартсва и его цену через -");
//        String[] infoMedicine = reader.readLine().split("-");

        medicines.add(new Medicine(name,price));





    }

    private void showMedicine() throws IOException {
        boolean right = false;
        while (!right) {
            var reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Выберите способ сортировки: (n) по имени; (p) по цене ");
            var answer = reader.readLine();
            switch (answer) {
                case "n":
                    Comparator<Medicine> comparatorName = new Comparator<Medicine>() {
                    @Override
                    public int compare(Medicine o1, Medicine o2) {
                        return o1.getName().compareTo(o2.getName());  //Для обратной сортировки нужно поменять местами
                    }

                };
                    medicines.sort(comparatorName);
                    System.out.println(medicines);
                    right = true;
                    break;
                case "p":
                    Comparator<Medicine> comparatoPrice = new Comparator<Medicine>() {
                        @Override
                        public int compare(Medicine o1, Medicine o2) {
                            return (int) (o1.getPrice() - o2.getPrice());  //Для обратной сортировки нужно поменять местами
                        }

                    };
                    medicines.sort(comparatoPrice);
                    System.out.println(medicines);
                    right = true;
                    break;
                default:

                    System.out.println("Неверное значение");

            }
        }
    }

    void addMedicines() throws IOException {
        boolean right = false;


        while (!right) {
            System.out.println("\"Введите названия лекартсва и его цену через -. Для отображения списка введите LIST, для остановки STOP ");
            var reader = new BufferedReader(new InputStreamReader(System.in));
            var answer = reader.readLine();

            if(answer.equalsIgnoreCase("LIST")) {
                showMedicine();
                continue;
            }
            if(answer.equalsIgnoreCase("STOP")) {
                right = true;
            }
            else {
                String[] infoMedicine = answer.split("-");
                addMedicine(infoMedicine[0],Double.parseDouble(infoMedicine[1]));

            }
            continue;
        }

    }





}
