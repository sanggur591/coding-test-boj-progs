class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        //for문을 돌려서 풀수밖에..
        for(int i=0;i<db.length;i++){
            //id가 있을때
            if(id_pw[0].equals(db[i][0])){
                //pw가 같을때
                if(id_pw[1].equals(db[i][1])) return "login";
                //pw가 다를때
                else return "wrong pw";
            }
            //id가 없을때
        }
        return "fail";
    }
}