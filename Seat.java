public class Seat implements Comparable<Seat>{

	private String letter;
	private int number;
	private String student = "notAssigned";
	
	public Seat(String s){

		letter = s.substring(0,1);
		number = Integer.parseInt(s.substring(1,s.length()));

	}

	public int compareTo(Seat o){

		String oL = o.getLetter();
		int oN = o.getNumber();

		if(letter.compareTo(oL) == 0){
			if(number > oN){
				return 1;
			}
			else if(number == oN){
				return 0;
			}
			else{
				return -1;
			}
		}
		else{
			return letter.compareTo(oL);
		}

	}

	public String toString(){
		return letter + number + "  " + student;
	}

	public String getLetter(){
		return letter;
	}

	public int getNumber(){
		return number;
	}

	public String getStudent(){
		return student;
	}

	public void setStudent(String s){
		student = s;
	}
}
