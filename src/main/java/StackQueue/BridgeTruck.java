package StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BridgeTruck {
    public static void main(String[] args) {

    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0; // 현재 시간
        int tw = 0; // 다리 위의 총 무게
        int index = 0; // 지나가야하는 다음 index
        Queue<Integer> bridge = new LinkedList<>(); // 다리
        Queue<Integer> stop = new LinkedList<>(); // 분기

        while (index < truck_weights.length) {// 다 넣을 때 까지
            if (!stop.isEmpty() && time == stop.peek()) {
                // 무게 빼고 & 큐에서 빼고 동시
                tw -= bridge.poll();
                stop.remove();
            }
            // (1) 더 넣을 수 있는 상태면
            // 넣고, 무게추가, 종료시간 추가
            if (bridge.size() < bridge_length && tw + truck_weights[index] <=  weight) {
                tw += truck_weights[index]; // 무게 추가
                bridge.add(truck_weights[index]); // 다리에 넣기
                stop.add(time + bridge_length); // 시간 분기점 추가
                time++; // 시간 흐름
                index++; // 다음 배열
                continue;
            }
            // (2) 더 넣을 수 없는 상태면 그대로 시간추가 +1
            time ++;
        }

        while (!stop.isEmpty()) {
            time = stop.poll();
        }
        return time+1;
    }
}
