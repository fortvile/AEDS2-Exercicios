

class Is{

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean onlyConsoante(String s){
        boolean onlyCons = true;
        for(int i = 0; i < s.length(); i++){
            if((s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || 
            s.charAt(i) == 'o' || s.charAt(i) == 'u') || (s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || 
            s.charAt(i) == 'O' || s.charAt(i) == 'U') ){
                onlyCons = false;
                break;
            }
        }

        return onlyCons;
    }

    public static boolean onlyVogais(String s){
        if(onlyConsoante(s) == true){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean isInt(String s){
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) < 48 || s.charAt(i) > 57) return false;
		}
		return true;
    }

    public static boolean isFloat(String s){
		int count = 0, countChars = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == 44 || s.charAt(i) == 46) count++;
			if(s.charAt(i) >= 48 && s.charAt(i) <= 57) countChars++;
		}

		if((count == 0 || count == 1) && countChars == s.length() - count) return true;
		return false;
    }


    public static void main(String[] args) throws Exception{
        MyIO.setCharset("utf-8");
        String s = "";
        String X1, X2, X3, X4;

        do{
            s = MyIO.readLine();

            if(onlyVogais(s) == true){
                X1 = "SIM";
            }
            else{
                X1 = "NAO";
            }

            if(onlyConsoante(s) == true){
                X2 = "SIM";
            }
            else{
                X2 = "NAO";
            }

            if(isFloat(s) == true){
                X3 = "SIM";
            }
            else{
                X3 = "NAO";
            }

            if(isInt(s) == true){
                X4 = "SIM";
            }
            else{
                X4 = "NAO";
            }

            MyIO.println(X1 + " " + X2 + " "  + X3 + " " + X4);
        }while(isFim(s) == false);

    }
}
