
import java.util.ArrayList;
import java.util.Scanner;

class Inventory {
	public String name;
	public String serialNumber;
	public int value;
}

class Main {
	public static void main(String[] args) {
		ArrayList<Inventory> inventory = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		boolean loop = true;
		do{
			System.out.println("Press 1 to add an item.");
			System.out.println("Press 2 to delete an item.");
			System.out.println("Press 3 to update an item.");
			System.out.println("Press 4 to show all the items.");
			System.out.println("Press 5 to quit the program.");
			int choice = scanner.nextInt();
			switch(choice){
				case 1:
					Inventory item = new Inventory();
					scanner.nextLine();
					System.out.println("Enter the name:");
					item.name = scanner.nextLine();
					System.out.println("Enter the serial number:");
					item.serialNumber = scanner.nextLine();
					System.out.println("Enter the value in dollars (whole number):");
					item.value = scanner.nextInt();
					inventory.add(item);
					break;
				case 2:
					scanner.nextLine();
					scanner.nextLine();
					System.out.println("Enter the serial number of the item to delete:");
					String case2String = scanner.nextLine();
					inventory.removeIf(i -> i.serialNumber.equals(case2String));
					break;
				case 3:
					scanner.nextLine();
					System.out.println("Enter the serial number of the item to change:");
					String case3String = scanner.nextLine();
					inventory.forEach( f-> {
						if(f.serialNumber.equals(case3String)){
							System.out.println("Enter the new name:");
							f.name = scanner.nextLine();
							System.out.println("Enter the new value in dollars (whole number):");
							f.value = scanner.nextInt();
						}
					});
					break;
				case 4:
					inventory.forEach(f -> {
						System.out.println(f.name + "," + f.serialNumber + ","+ f.value);
					});
					break;
				case 5:
					loop = false;
					break;
			}

		}while(loop);
		scanner.close();

	}
	
}