import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OpenChat {
    public static String[] solution(String[] record) {
        HashMap<String, String> nameMap = new HashMap<>();
        List<String[]> addStrList = new ArrayList<>();
        HashMap<String, String> statusMap = new HashMap<String, String>(){{
            put("Enter", "들어왔습니다.");
            put("Leave", "나갔습니다.");
        }};

        int i;
        for (i = 0; i<record.length; i++) {
            String[] logArray = record[i].split(" ");
            if (logArray[0].equals("Enter")) {
                nameMap.computeIfAbsent(logArray[1], k -> logArray[2]);
                nameMap.replace(logArray[1], logArray[2]);
                addStrList.add(logArray);
            } else if (logArray[0].equals("Leave")) {
                addStrList.add(logArray);
            } else {
                nameMap.replace(logArray[1], logArray[2]);
            }
        }

        int size = addStrList.size();
        String[] answer = new String[size];
        for (i = 0; i< size; i++) {
            String[] logArray = addStrList.get(i);
            answer[i] = nameMap.get(logArray[1]) + "님이 " + statusMap.get(logArray[0]);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        for (String log : solution(record)) {
            System.out.println(log);
        }
    }
}
