
public class PhoneNumber {
    public static String solution(String phone_number) {
        int replace_length = phone_number.length()-4;
        int i = 0;
        String answer = "";
        while(true) {
            if (i == replace_length) {
                answer += phone_number.substring(i);
                return answer;
            }
            answer += "*";
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("01033334444"));
        System.out.println(solution("027778888"));
    }
}
