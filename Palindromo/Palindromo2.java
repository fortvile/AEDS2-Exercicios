
class Palindromo2 {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean isPalindromo(String palindromo) {

        boolean isPal = true;
        int n = palindromo.length() - 1;
        for (int i = 0; i < palindromo.length() / 2; i++, n--) {
            if (palindromo.charAt(i) != palindromo.charAt(n)) {
                isPal = false;
                break;
            }
        }
        return isPal;
    }

    public static void main(String[] args) {

        String palindromo = "";
        

        //boolean isPal = isPalindromo(palindromo);

        do {
            palindromo = MyIO.readLine();
            if (isPalindromo(palindromo) == true) {
                MyIO.println("SIM");
            } else {
                MyIO.println("NAO");
            }
        } while (isFim(palindromo) == false);

    }

}