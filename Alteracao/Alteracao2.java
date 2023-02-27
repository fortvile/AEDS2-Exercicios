import java.util.Random;

class Aleatoria{


	public static String changeChar(String s, char seek, char change){

		String result = "";

		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == seek){
				result += change;
			}else{
				result += s.charAt(i);
			}
		}
		return result;
	}


	public static boolean isFim(String s){
		return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
	}


	public static void main(String[] args){

		String[] entries = new String[1000];
		int numEntries = 0;
		char letra1, letra2;


		Random gerador = new Random();
		gerador.setSeed(4);


		do{
			entries[numEntries] = MyIO.readLine();
		}while(!(isFim(entries[numEntries++])));
		numEntries--;
		
		for(int i = 0; i < numEntries; i++){

			letra1 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
			letra2 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));


			MyIO.println(changeChar(entries[i], letra1, letra2)); 
		}

	}


}
