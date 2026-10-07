import java.util.*;

public class Main {
    static class scan {
        int id;
        String name;
        int duration;
        boolean pause;
        String state;

        scan(int id, String name, int duration, boolean pause) {
            this.id = id;
            this.name = name;
            this.duration = duration;
            this.pause = pause;
            this.state = "IDLE";
        }
    }

    static class ScanController {
        ArrayList<scan> list = new ArrayList<>();
        void handleCommand(String command) {
            if (command.startsWith("add:")) {
                String[] p = command.substring(4).split(",");
                int id = Integer.parseInt(p[0].trim());
                String name = p[1].trim();
                int duration = Integer.parseInt(p[2].trim());
                boolean pause = p[3].trim().equalsIgnoreCase("Yes");
                list.add(new scan(id, name, duration, pause));
                System.out.println("Added " + name);
            }
            else if (command.equals("view")) {
                for (scan s : list) {
                    System.out.println(
                        s.id + ", " + s.name + ", " + s.duration + ", " + s.pause + ", " + s.state);
                }
            }
            else if (command.equals("start")) {
                for (scan s : list) {
                    if (s.state.equals("IDLE")) {
                        s.state = "RUNNING";
                        System.out.println("Starting " + s.name);
                        try {
                            Thread.sleep(s.duration * 1000);
                        }
                        catch (Exception e) {
                        }
                        s.state = "COMPLETE";
                        System.out.println("Completed " + s.name);
                        if (s.pause) {
                            break;
                        }
                    }
                }
            }
            else if (command.startsWith("remove:")) {
                int id = Integer.parseInt(command.substring(7).trim());
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).id == id &&
                        list.get(i).state.equals("IDLE")) {
                        list.remove(i);
                        break;
                    }
                }
            }
            else if (command.equals("exit")) {
                System.exit(0);
            }
        }
    }
    public static void main(String[] args) {
        ScanController scanController = new ScanController();

        Scanner sc = new Scanner(System.in);
        while(true) {
            String command = sc.nextLine();
            scanController.handleCommand(command);
        }
    }
}
