public class Algebra {
    //2 0 0 and(not(A) , not(B))

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static String caso1(String s){
        s = s.replace('A', s.charAt(1));
        s = s.replace('B', s.charAt(2));
        s = s.substring(3);

        while(s.length() > 1){
            s = not(s);
            s = or(s);
            s = and(s);
        }
        
        return s;
    }
    public static String caso2(String s){
        s = s.replace('A', s.charAt(1));
        s = s.replace('B', s.charAt(2));
        s = s.replace('C', s.charAt(3));
        s = s.substring(4);
        
        while(s.length() > 1){
            s = not(s);
            s = or(s);
            s = and(s);
        }

        return s;
    }

    public static String not(String s){
        s = s.replace("not(0)", "1");
        s = s.replace("not(1)", "0");
        return s;
    }

    public static String and(String s){
        s = s.replace("and(1,1)", "1");
        s = s.replace("and(1,0)", "0");
        s = s.replace("and(0,1)", "0");
        s = s.replace("and(0,0)", "0");
        s = s.replace("and(1,1,1)", "1");
        s = s.replace("and(1,1,0)", "0");
        s = s.replace("and(1,0,1)", "0");
        s = s.replace("and(1,0,0)", "0");
        s = s.replace("and(0,1,1)", "0");
        s = s.replace("and(0,1,0)", "0");
        s = s.replace("and(0,0,1)", "0");
        s = s.replace("and(0,0,0)", "0");
        return s;
    }

    public static String or(String s){
        s = s.replace("or(1,1)", "1");
        s = s.replace("or(1,0)", "1");
        s = s.replace("or(0,1)", "1");
        s = s.replace("or(0,0)", "0");
        s = s.replace("or(1,1,1)", "1");
        s = s.replace("or(1,1,0)", "1");
        s = s.replace("or(1,0,0)", "1");
        s = s.replace("or(0,0,0)", "0");
        s = s.replace("or(0,0,1)", "1");
        s = s.replace("or(0,1,1)", "1");
        s = s.replace("or(1,0,1)", "1");
        s = s.replace("or(0,1,0)", "1");
        s = s.replace("or(0,0,0,0)", "0");
        s = s.replace("or(0,0,0,1)", "1");
        s = s.replace("or(0,0,1,1)", "1");
        s = s.replace("or(0,1,1,1)", "1");
        s = s.replace("or(1,1,1,1)", "1");
        s = s.replace("or(1,1,1,0)", "1");
        s = s.replace("or(1,1,0,0)", "1");
        s = s.replace("or(1,0,0,1)", "1");
        s = s.replace("or(1,0,0,0)", "1");
        s = s.replace("or(0,1,0,0)", "1");
        s = s.replace("or(0,0,1,0)", "1");
        s = s.replace("or(0,1,1,0)", "1");

        return s;
    }
    
    public static void main(String[] args){
    String s = "";

    do{
        s = MyIO.readLine();
        s = s.replace(" ", "");

        if(s.charAt(0) == '0'){
            MyIO.println('0');
        }
        
        if(s.charAt(0) == '2'){
            //MyIO.println("essa eh a string do caso1: " + caso1(s));
            MyIO.println(caso1(s));
        }   
        else if(s.charAt(0) == '3'){
            //MyIO.println("essa eh a string do caso1: " + caso2(s));
            MyIO.println( caso2(s));
        }


    }while(s.charAt(0) != '0');
}
}
