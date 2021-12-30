package 每日一题;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author W.Wen
 * @version : V1.0
 * @className: LK20211202
 * @description: 相对名次
 * @date 2021-12-02
 */
public class LK20211202 {
    class Player {
        int index;
        int grade;

        public Player(int index, int grade) {
            this.index = index;
            this.grade = grade;
        }
    }

    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Player> players = new PriorityQueue<>(new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o2.grade - o1.grade;
            }
        });
        String[] res = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            players.add(new Player(i, score[i]));
        }
        for (int i = 0; !players.isEmpty(); i++) {
            Player poll = players.poll();
            if (i == 0) {
                res[poll.index] = "Gold Medal";
            } else if (i == 1) {
                res[poll.index] = "Silver Medal";
            } else if (i == 2) {
                res[poll.index] = "Bronze Medal";
            } else {
                res[poll.index] = String.valueOf(i-1);
            }
        }
        return res;
    }
}
