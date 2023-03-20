class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        char[] order = skill.toCharArray();
        for(int i=0;i< skill_trees.length;i++){
            char[] skill_tree = skill_trees[i].toCharArray();
            int previous=-1;
            int now = -1;
            int cnt =0;
            boolean isInOrder = false;
            for(int j=0; j<skill_tree.length;j++){//스킬트리의 모든 문자 조사
                for(int k=0; k<order.length;k++){ //스킬트리의 각 문자가 order에 있는것인지 파악한다
                    if(skill_tree[j]==order[k]){
                        now = k;
                        isInOrder=true;
                        break;
                    }
                }
                //이전의 order와 같았던 문자의 숫자보다 1보다 커야 ok // 아니면 break
                if(isInOrder&&now!=previous+1) break;
                previous = now;
                isInOrder = false;
                cnt++;
            }
            if(cnt==skill_tree.length) answer++;
        }
        return answer;
    }
}