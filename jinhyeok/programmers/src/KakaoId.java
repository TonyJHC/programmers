import java.util.Locale;

public class KakaoId {
    public static String solution(String new_id) {
        int i = 1;
        while (i <= 7){
            new_id = process(new_id, i);
            i ++;
        }
        return new_id;
    }
    private static String process(String str, int case_num) {
        switch(case_num){
            case 1:
                return str.toLowerCase();
            case 2:
                return str.replaceAll("[^a-z0-9-_.]", "");
            case 3:
                return str.replaceAll("[.]{2,}", ".");
            case 4:
                return str.replaceAll("^[.]|[.]$", "");
            case 5:
                if (str.isEmpty())
                    return "a";
                return str;
            case 6:
                if (str.length()>15)
                    str = str.substring(0, 15);
                return str.replaceAll("[.]$", "");
            case 7:
                while (str.length()<=2)
                    str += str.substring(str.length()-1);
                return str;
        }
        return "";
    }

    public static void main(String[] args) {
        String new_id = "123_.def";
        System.out.println(solution(new_id));
    }
}
