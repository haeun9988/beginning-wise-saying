import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<String> wise_saying = new ArrayList<>();
    static ArrayList<String> author = new ArrayList<>();
    static int num = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "db/wiseSaying/";
        //File f = new File();

        String answer = "";

        System.out.println("== 명언 앱 ==");

        while (!answer.equals("종료")) {
            System.out.print("명령) ");

            answer = sc.nextLine();

            // 명령이 등록인 경우
            if (answer.equals("등록")) {
                System.out.print("명언 : ");
                wise_saying.add(sc.nextLine());

                System.out.print("작가 : ");
                author.add(sc.nextLine());

                num++;
                String fileName = String.valueOf(num + ".json");
                // 파일 새로 생성
//                f.createNewFile();

                System.out.println(num + "번 명언이 등록되었습니다.");
            } 
            // 명령이 목록인 경우
            else if (answer.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("----------------------");

                for (int i = num; i > 0; i--) {
                    // 삭제한 명언이 있을 경우 패스
                    if (author.get(i-1).equals("X")) {
                        continue;
                    }
                    // 삭제를 안한 경우
                    else {
                        System.out.println(i + " / " + author.get(i-1) + " / " + wise_saying.get(i-1));
                    }
                }
            }
            // 명령이 삭제인 경우
            else if (answer.contains("삭제")) {
                int numd = Integer.parseInt(answer.replaceAll("[^0-9]" ,""));

                // numd번 명언이 존재하지 않을 경우
                if (wise_saying.get(numd-1).equals("X") && num < numd) {
                    System.out.println(numd + "번 명언은 존재하지 않습니다.");
                }
                else {
                    wise_saying.set(numd-1, "X");
                    author.set(numd-1, "X");

                    System.out.println(numd + "번 명령이 삭제되었습니다.");
                }
            }
            // 명령이 수정인 경우
            else if (answer.contains("수정")) {
                int nume = Integer.parseInt(answer.replaceAll("[^0-9]" ,""));

                // nume번 명언이 존재하지 않을 경우
                if (wise_saying.get(nume-1).equals("X") && num < nume) {
                    System.out.println(nume + "번 명언은 존재하지 않습니다.");
                }
                else {
                    System.out.println("명언(기존) : " + wise_saying.get(nume-1));
                    System.out.print("명언 : ");
                    wise_saying.set(nume-1, sc.nextLine());

                    System.out.println("작가(기존) : " + author.get(nume-1));
                    System.out.print("작가 : ");
                    author.set(nume-1, sc.nextLine());
                }
            }
        }
    }
}

//// 등록
//class register() {
//
//}
//
//// 목록
//class list() {
//
//}
//
//// 삭제
//class delete() {
//
//}
//// 수정
//class revise() {
//
//}