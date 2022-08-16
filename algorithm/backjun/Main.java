import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visitCheck;
    static StringBuilder stringBuilder = new StringBuilder();
    static StringBuilder stringBuilder1 = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStrings = bufferedReader.readLine().split(" ");
        visitCheck = new boolean[Integer.parseInt(inputStrings[0])+1];
        ArrayList<LinkedList<Integer>> graph = new ArrayList<>();
        LinkedList<Integer> zero = new LinkedList<>();
        graph.add(zero);
        for (int i = 0; i <Integer.parseInt(inputStrings[0]); i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 0; i <Integer.parseInt(inputStrings[1]); i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node =Integer.parseInt(stringTokenizer.nextToken());
            int linknode =Integer.parseInt(stringTokenizer.nextToken());
            graph.get(node).add(linknode);
            graph.get(linknode).add(node);
        }
        for (int i = 0; i < graph.size(); i++) {
            Collections.sort(graph.get(i));
        }
        DeapthFirstSearch(graph, Integer.parseInt(inputStrings[2]));
        BeathFisrtSearch(graph, Integer.parseInt(inputStrings[2]));
        System.out.println(stringBuilder1);
        System.out.println(stringBuilder);
}

public static void DeapthFirstSearch( ArrayList<LinkedList<Integer>> graph, int startnode){
    if(visitCheck[startnode]){
        return;
    }
    visitCheck[startnode] = true;
    stringBuilder1.append(startnode+ " ");
    for (int i = 0; i < graph.get(startnode).size(); i++) {
        DeapthFirstSearch(graph, graph.get(startnode).get(i));
    }
}

public static void BeathFisrtSearch(ArrayList<LinkedList<Integer>> graph, int startnode){
    Queue<Integer> queue = new LinkedList<>();  
    boolean[] visit = new boolean[graph.size()+1];
    queue.add(startnode);
    visit[startnode] = true;
    stringBuilder.append(startnode+" ");
    while(!queue.isEmpty()){
        if(!visit[queue.peek()]){
            stringBuilder.append(queue.peek()+" ");
            visit[queue.peek()] = true;
        }
        int next = queue.poll();
        for(Integer integer : graph.get(next)){
            if(!visit[integer]){
            queue.add(integer);
            }
        }
    }
}
}