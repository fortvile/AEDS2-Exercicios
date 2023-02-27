


class Palindromo3{


	public static String isPalindrome(String s){
		int j = s.length() - 1;

		for(int i = 0; i < s.length(); i++, j--){
			if(s.charAt(i) != s.charAt(j)) return "NAO";
		}
		return "SIM";
	}


	public static boolean isFim(String s){
		return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
	}


	public static void main (String[] args){

		String[] entries = new String[1000];
		int numEntries = 0;


		do{
			entries[numEntries] = MyIO.readLine();
		} while(!(isFim(entries[numEntries++])));
		numEntries--; 


		for(int i = 0; i < numEntries; i++){
			MyIO.println(isPalindrome(entries[i]));
		}
	}	

}
