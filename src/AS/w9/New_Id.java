package AS.w9;

public class New_Id {
    public static void main(String[] args) {
        solved sol = new solved();

        String new_id = "abcdefghijklmn.p";
        System.out.println(sol.solution(new_id));
    }
}

class solved {
    public String solution(String new_id) {
        String answer = "";
        // 1단계 모든 대문자를 대응되는 소문자로 치환
        String temp = new_id.toLowerCase();
        // 2단계 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        temp = temp.replaceAll("[^-_.a-z0-9]","");
        // 3단계 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        temp = temp.replaceAll("[.]{2,}",".");
        // 4단계 마침표(.)가 처음이나 끝에 위치한다면 제거
        temp = temp.replaceAll("^[.]|[.]$","");
        // 5단계 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(temp.equals(""))
            temp+="a";
        // 6단계 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        if(temp.length() >= 16){
            temp = temp.substring(0,15);
            temp = temp.replaceAll("^[.]|[.]$","");
        }
        // 7단계 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while (temp.length()<=2)    temp += temp.charAt(temp.length()-1);

        answer = temp;
        return answer;
    }
}