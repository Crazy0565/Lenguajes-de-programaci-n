import java.util.*;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> nom = new ArrayList<>();
        ArrayList<String> ape = new ArrayList<>();
        ArrayList<String> tel = new ArrayList<>();
        ArrayList<String> mail = new ArrayList<>();
        ArrayList<String> emp = new ArrayList<>();
        ArrayList<String> cat = new ArrayList<>();
        ArrayList<Boolean> fav = new ArrayList<>();

        int op;

        do {
            System.out.println("\n======= AGENDA =======");
            System.out.println("1. Agregar");
            System.out.println("2. Buscar");
            System.out.println("3. Filtrar categoria");
            System.out.println("4. Marcar favorito");
            System.out.println("5. Ver contactos");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");
            op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.print("Nombre: ");
                nom.add(sc.nextLine());
                System.out.print("Apellido: ");
                ape.add(sc.nextLine());
                System.out.print("Telefono: ");
                tel.add(sc.nextLine());
                System.out.print("Email: ");
                mail.add(sc.nextLine());
                System.out.print("Empresa: ");
                emp.add(sc.nextLine());

                System.out.println("1.CLIENTE 2.COLEGA 3.PROVEEDOR 4.FAMILIAR 5.OTRO");
                int c = sc.nextInt();
                sc.nextLine();

                String[] tipos = { "CLIENTE", "COLEGA", "PROVEEDOR", "FAMILIAR", "OTRO" };
                cat.add(tipos[c - 1]);

                fav.add(false);
            }

            if (op == 2) {
                System.out.print("Buscar: ");
                String b = sc.nextLine().toLowerCase();

                for (int i = 0; i < nom.size(); i++) {
                    if (nom.get(i).toLowerCase().contains(b) ||
                            ape.get(i).toLowerCase().contains(b) ||
                            emp.get(i).toLowerCase().contains(b) ||
                            mail.get(i).toLowerCase().contains(b)) {
                        System.out.println(i + ". " + nom.get(i) + " " + ape.get(i));
                    }
                }
            }

            if (op == 3) {
                System.out.println("1.CLIENTE 2.COLEGA 3.PROVEEDOR 4.FAMILIAR 5.OTRO");
                int c = sc.nextInt();
                sc.nextLine();

                String[] tipos = { "CLIENTE", "COLEGA", "PROVEEDOR", "FAMILIAR", "OTRO" };
                String f = tipos[c - 1];

                for (int i = 0; i < nom.size(); i++) {
                    if (cat.get(i).equals(f)) {
                        System.out.println(nom.get(i) + " " + ape.get(i));
                    }
                }
            }

            if (op == 4) {
                for (int i = 0; i < nom.size(); i++) {
                    System.out.println(i + ". " + nom.get(i) + " " + ape.get(i));
                }

                System.out.print("Indice: ");
                int i = sc.nextInt();
                sc.nextLine();

                if (i >= 0 && i < fav.size()) {
                    fav.set(i, !fav.get(i));
                    System.out.println("Actualizado");
                }
            }

            if (op == 5) {
                int f = 0;

                for (int i = 0; i < nom.size(); i++) {
                    System.out.println(nom.get(i) + " " + ape.get(i) + " | " + cat.get(i) + (fav.get(i) ? " ⭐" : ""));
                    if (fav.get(i))
                        f++;
                }

                System.out.println("Total: " + nom.size() + " | Favoritos: " + f);
            }

        } while (op != 6);

        sc.close();
    }
}
