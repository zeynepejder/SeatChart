import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class SeatChart{
	
	public static void main(String[] args){

	ArrayList<Seat> seats = new ArrayList<Seat>();
	ArrayList<String> students = new ArrayList<String>();
	Random randomSeats = new Random();
	int numOfSeats;

	System.out.println("File name: " + args[0]);

		File inputFile = new File(args[0]);
        File studentNames = new File(args[1]);

		String outputFile = "output.txt";
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(outputFile);
		} 
		catch(FileNotFoundException e) {
			System.out.println("Writer Failed.");
			System.exit(1);
		}

		Scanner inStudents = null;
		Scanner in = null;

		try {
			inStudents = new Scanner(studentNames);
			in = new Scanner(inputFile);
			System.out.println("We made it!");
		} 
		catch( FileNotFoundException e) {
			System.out.println("The file doesn't exist.");
			System.exit(1);
		}

		while(inStudents.hasNextLine()) {
			students.add(inStudents.nextLine());
		}

		while(in.hasNext()) {
			seats.add(new Seat(in.next()));
		}

		Collections.sort(seats);
		numOfSeats = seats.size();
		if(numOfSeats < students.size()){
			System.out.println("There are more students than this room can accommodate. The program will only assign seats to the first " +numOfSeats+" students.");
		}

		for(int i = 0; i < seats.size(); i++){
			int s = randomSeats.nextInt(numOfSeats);
			while(!(seats.get(s).getStudent().equals("notAssigned"))){
				s = randomSeats.nextInt(numOfSeats);
			}
			seats.get(s).setStudent(students.get(i));
		}

		for(int i = 0; i < seats.size(); i++){

			writer.println(seats.get(i));

		}

		writer.close();

	}
}
