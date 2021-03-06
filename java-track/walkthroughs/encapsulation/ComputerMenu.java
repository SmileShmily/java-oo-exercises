package encapsulation;

import java.util.ArrayList;
import java.util.Scanner;

public class ComputerMenu {

	
	private ArrayList<Computer> computers;
	private Scanner s;
	
	public static void main(String[] args){
		int x = 0;
		ComputerMenu cm = new ComputerMenu();
		do{
			x = cm.startMenu();
			cm.processInput(x);
		} while (x !=5);
	}
	
	public ComputerMenu()
	{
		s = new Scanner(System.in);
		computers = new ArrayList<Computer>();
	}
	
	public int startMenu(){
		System.out.println("Welcome to the computer menu!");
		System.out.println("1. Create a computer");
		System.out.println("2. Display the list of available computer");
		System.out.println("3. Change the processor of a computer");
		System.out.println("4. Add memory to a computer");
		System.out.println("5. Exit");
		System.out.println("Please select an option: ");
		int selection = s.nextInt();
		while(selection < 0 || selection > 5){
			System.out.println("Invalid selection, please try again: ");
			selection = s.nextInt();
		}
		return selection;
	}
	
	public void processInput(int selection){
		if(selection == 1){
			createComputer();
		}
		else if(selection == 2){
			displayComputers();
		}
		else if(selection == 3){
			displayComputers();
			Computer c = selectComputer();
			System.out.println("Please enter a processor speed for the computer: ");
			int proc = s.nextInt();
			while(proc < 1){
				System.out.println("Invalid value. Please enter a positive integer: ");
				proc = s.nextInt();
			}
			c.setProcessor(proc);
			System.out.println("Here is the computer's status after it moves: ");
			System.out.println(c);
		}
		else if(selection == 4){
			displayComputers();
			Computer c = selectComputer();
			System.out.println("How much memory would you like to add?");
			int mem = s.nextInt();
			while(mem < 0){
				System.out.println("Invalid amount, please enter a positive integer");
				mem = s.nextInt();
			}
			c.addMemory(mem);
			System.out.println("Here is what the computer looks like after memory is added");
			System.out.println(c);
		}
	}
	
	private void displayComputers(){
		for(int i = 0; i < computers.size(); i++){
			System.out.println((i+1) + ".)" + computers.get(i));
		}
	}
	
	private Computer selectComputer(){
		System.out.println("Please select a computer: ");
		int selection = s.nextInt();
		while(selection < 1 || selection > computers.size()){
			System.out.println("Invalid selection, please try again: ");
			selection = s.nextInt();
		}
		return computers.get(selection-1);
	}
	
	private void createComputer(){
		System.out.println("Please enter the memory that the computer has");
		int mem = s.nextInt();
		while(mem < 1){
			System.out.println("invalid value. Please enter a positive integer");
			mem = s.nextInt();
		}
		System.out.println("Please enter a processor speed for the computer");
		int proc = s.nextInt();
		while(proc < 1){
			System.out.println("Invalid value. Please enter a positive integer");
			proc = s.nextInt();
		}
		System.out.println("Please enter a size for the computer: ");
		int size = s.nextInt();
		while(size < 1){
			System.out.println("Invalid valud. Please enter a positive value");
			size = s.nextInt();
		}
		System.out.println("Plese enter a brand for the robot: ");
		String brand = s.next();
		computers.add(new Computer(mem, size, proc, brand));
	}
}
