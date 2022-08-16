import java.util.Stack; 

class Solution {
    public int solution(int[] order) {
    int list = 0;
    int answer = 0;
        
        Stack<Integer> stack =new Stack<>();
        Stack<Integer> sub_stack =new Stack<>();
    
        for (int i = order.length; i >= 1; i--) {
            stack.push(i);
        }
        int x =0;
        while(true){
                if(stack.isEmpty() && sub_stack.isEmpty()){
                    break;
                }
                if(!stack.isEmpty()){
                if(stack.peek().equals(order[list])){
                    stack.pop();
                    list++;
                    answer++;
                    continue;
                }}
                if(!sub_stack.empty()){
                if(sub_stack.peek().equals(order[list])){
                    sub_stack.pop();
                    list++;
                    answer++;
                    continue;
                }else if(stack.empty()){
                    break;
                }}

            if(!stack.isEmpty()){
                sub_stack.push(stack.pop());
            }
        }
        return answer;
    }

}