package com.the703.v3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// 1. 캐릭터 정보 클래스
class CharacterDto {
    private String id;
    private String pass;
    private double gold;

    public CharacterDto() { super(); }

    public CharacterDto(String id, String pass, double gold) {
        super();
        this.id = id;
        this.pass = pass;
        this.gold = gold;
    }

    public CharacterDto(String id) {
        super();
        this.id = id;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }

    public double getGold() { return gold; }
    public void setGold(double gold) { this.gold = gold; }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        CharacterDto other = (CharacterDto) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "CharacterDto [id=" + id + ", gold=" + gold + "]";
    }
}


// 2. RPG 게임 시스템 클래스
class GameSystem {

    List<CharacterDto> users;
    Scanner sc = new Scanner(System.in);

    public GameSystem() { super(); }

    public GameSystem(List<CharacterDto> users) {
        super();
        this.users = users;
    }

    // 메뉴
    public void menu() {

        int menu = -1;

        while(menu != 9) {

            System.out.print(
                    "\n\n🎮 =============================== 🎮\n" +
                    "      RPG GAME SYSTEM\n" +
                    "🎮 =============================== 🎮\n" +
                    "[1] 🧙 캐릭터 생성\n" +
                    "[2] 🔍 캐릭터 조회\n" +
                    "[3] ⚔️ 몬스터 사냥 (골드 획득)\n" +
                    "[4] 🛒 아이템 구매\n" +
                    "[5] ❌ 캐릭터 삭제\n" +
                    "[9] 🚪 게임 종료\n" +
                    "👉 메뉴 선택 : "
            );

            menu = sc.nextInt();

            switch(menu) {

                case 1:
                    createCharacter();
                    break;

                case 2:
                case 3:
                case 4:
                case 5:

                    CharacterDto user = login();

                    if(user == null) {
                        System.out.println("❌ 아이디 또는 비밀번호가 틀렸습니다.");
                        break;
                    }

                    switch(menu) {

                        case 2:
                            showCharacter(user);
                            break;

                        case 3:
                            huntMonster(user);
                            break;

                        case 4:
                            buyItem(user);
                            break;

                        case 5:
                            deleteCharacter(user);
                            break;
                    }

                    break;

                case 9:
                    exit();
                    break;

                default:
                    System.out.println("⚠️ 잘못된 입력입니다.");
            }
        }
    }

    // 캐릭터 생성
    public void createCharacter() {

        System.out.print("🧙 캐릭터 이름 입력 > ");
        String tid = sc.next();

        // 중복 검사
        if(users.contains(new CharacterDto(tid))) {
            System.out.println("⚠️ 이미 존재하는 캐릭터입니다.");
            return;
        }

        System.out.print("🔑 비밀번호 입력 > ");
        String tpass = sc.next();

        System.out.print("💰 시작 골드 입력 > ");
        double tgold = sc.nextDouble();

        users.add(new CharacterDto(tid, tpass, tgold));

        System.out.println("✅ 캐릭터 생성 완료!");
    }

    // 로그인
    public CharacterDto login() {

        System.out.print("🧙 캐릭터 이름 입력 > ");
        String tid = sc.next();

        System.out.print("🔑 비밀번호 입력 > ");
        String tpass = sc.next();

        for(CharacterDto user : users) {

            if(user.getId().equals(tid)
                    && user.getPass().equals(tpass)) {

                return user;
            }
        }

        return null;
    }

    // 캐릭터 조회
    public void showCharacter(CharacterDto user) {

        System.out.println("\n📜 CHARACTER INFO");
        System.out.println("---------------------------");
        System.out.println("🧙 이름 : " + user.getId());
        System.out.println("💰 골드 : " + user.getGold());
        System.out.println("---------------------------");
    }

    // 몬스터 사냥 (골드 획득)
    public void huntMonster(CharacterDto user) {

        System.out.print("⚔️ 획득할 골드 입력 > ");
        double gold = sc.nextDouble();

        if(gold <= 0) {
            System.out.println("⚠️ 0보다 큰 값만 입력 가능합니다.");
            return;
        }

        user.setGold(user.getGold() + gold);

        System.out.println("🎉 몬스터 처치 성공!");
        System.out.println("💰 현재 골드 : " + user.getGold());
    }

    // 아이템 구매
    public void buyItem(CharacterDto user) {

        System.out.print("🛒 사용할 골드 입력 > ");
        double gold = sc.nextDouble();

        if(gold <= 0) {
            System.out.println("⚠️ 0보다 큰 값만 입력 가능합니다.");
            return;
        }

        if(user.getGold() < gold) {
            System.out.println("❌ 골드가 부족합니다.");
            return;
        }

        user.setGold(user.getGold() - gold);

        System.out.println("✅ 아이템 구매 완료!");
        System.out.println("💰 남은 골드 : " + user.getGold());
    }

    // 캐릭터 삭제
    public void deleteCharacter(CharacterDto user) {

        System.out.print("❓ 정말 삭제하시겠습니까? (Y/N) : ");
        char answer = sc.next().charAt(0);

        if(answer == 'Y' || answer == 'y') {

            users.remove(user);

            System.out.println("🗑️ 캐릭터 삭제 완료!");
        }
        else {
            System.out.println("👍 삭제가 취소되었습니다.");
        }
    }

    // 종료
    public void exit() {
        System.out.println("🎮 게임을 종료합니다.");
    }
}


// 3. 실행 클래스
public class RPGGameProject {

    public static void main(String[] args) {

        List<CharacterDto> users = new ArrayList<>();

        GameSystem controller = new GameSystem(users);

        controller.menu();
    }
}