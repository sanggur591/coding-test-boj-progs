class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ",-1);
        for(int i=0;i<arr.length;i++){
            if(arr[i].length()==0) continue;
            if(Character.isDigit(arr[i].charAt(0))&&arr[i].length()!=1){
                arr[i]=arr[i].charAt(0)+arr[i].substring(1).toLowerCase();
            }
            else if(!Character.isDigit(arr[i].charAt(0))&&arr[i].length()!=1){
                arr[i]=Character.toString(arr[i].charAt(0)).toUpperCase() + arr[i].substring(1).toLowerCase();
            }
            else if(!Character.isDigit(arr[i].charAt(0))&&arr[i].length()==1){
                arr[i]=arr[i].toUpperCase();
            }
        }
        return String.join(" ",arr);
    }
}