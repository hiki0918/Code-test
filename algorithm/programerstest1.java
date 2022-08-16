
public class programerstest1 {
    
class Solution {
    public String solution(String X, String Y) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] arrx = new int[10];
        int[] arry = new int[10];
        int[] total = new int[10];
        String[] splitx = X.split("");
        String[] splity = Y.split("");
        for (int i = 0; i < 9; i++) {
            arrx[i]=0;
            arry[i]=0;
            total[i]=0;
        }
        for (String string : splitx) {
            int a = Integer.parseInt(string);
            arrx[a]++;
        }
        for (String string : splity) {
            int a = Integer.parseInt(string);
            arry[a]++;
        }
        for (int i = 0; i < 10; i++) {
            if(arrx[i] == 0 || arry[i] == 0 ){
                continue;
            }
            if(arrx[i] >= 1 && arry[i] >= 1 ){
                int a = arrx[i] > arry[i] ? arry[i] : arrx[i];
                for (int j = 0; j < a; j++) {
                    total[i]++; 
                }
            }
        }   
        int a = 0;
        for (int i = 9; i >= 1; i--) {
            for (int j = 0; j < total[i]; j++) {
            stringBuilder.append(i);
            a++;
            }
        }
        if( a == 0 && total[0] == 0){
            stringBuilder.append("-1");
        }
        else{
            if(a == 0 && total[0] > 0){
                stringBuilder.append(0);
            }
            else{for (int i = 0; i < total[0]; i++) {
                stringBuilder.append(0);
            }
        }
        }
        
        String answer = stringBuilder.toString();
        return answer;
    }
}

}
