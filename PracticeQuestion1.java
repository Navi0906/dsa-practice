import java.util.*;

public class PracticeQuestion1 {
    public static List<List<String>> filterLogs(List<List<String>> logs) {
        List<List<String>> filtered = new ArrayList<>();
        for (List<String> log : logs) {
            if (log.get(2).equals("ERROR") || log.get(2).equals("CRITICAL")) {
                filtered.add(log);
            }
        }


        filtered.sort((a, b) -> {
            String d1 = a.get(0) + " " + a.get(1);
            String d2 = b.get(0) + " " + b.get(1);
            return d1.compareTo(d2);
        });

        return filtered;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<String>> logs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> log = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                log.add(sc.next());
            }
            logs.add(log);
        }

        List<List<String>> result = filterLogs(logs);
        System.out.println(result);
    }
}