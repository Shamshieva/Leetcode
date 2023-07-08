package yandex;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RequestFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.nextLine(); // consume the newline character after the integer

        String[] logs = new String[K];
        for (int i = 0; i < K; i++) {
            logs[i] = scanner.nextLine();
        }

        String[] filteredLogs = filterRequests(N, logs);

        for (String log : filteredLogs) {
            System.out.println(log);
        }
    }

    private static String[] filterRequests(int N, String[] logs) {
        Map<String, Integer> counts = new HashMap<>();
        String[] filteredLogs = new String[logs.length];
        int index = 0;

        for (String log : logs) {
            String[] parts = log.split(" ");
            long timestamp = Long.parseLong(parts[0]);
            String token = parts[1];

            int userCount = counts.getOrDefault(token, 0);
            if (userCount < N) {
                counts.put(token, userCount + 1);
                filteredLogs[index++] = log;
            }
        }

        return filteredLogs;
    }
}
