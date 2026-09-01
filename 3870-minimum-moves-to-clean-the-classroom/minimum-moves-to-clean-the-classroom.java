import java.util.*;

class Solution {


    static class State {
        int row, col, mask, energy, moves;

        State(int row, int col, int mask, int energy, int moves) {
            this.row = row;
            this.col = col;
            this.mask = mask;
            this.energy = energy;
            this.moves = moves;
        }
    }


    public int minMoves(String[] classroom, int energy) {
        int rows = classroom.length;
        int cols = classroom[0].length();

        int[][] litterId = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(litterId[i], -1);
        }

        int litterCount = 0;
        int startRow = 0, startCol = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (classroom[i].charAt(j) == 'S') {
                    startRow = i;
                    startCol = j;
                } else if (classroom[i].charAt(j) == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        if (litterCount == 0) return 0;

        int fullMask = (1 << litterCount) - 1;

        int[][][] maxEnergy = new int[rows][cols][1 << litterCount];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Arrays.fill(maxEnergy[i][j], -1);
            }
        }

        Queue<State> queue = new LinkedList<>();

        maxEnergy[startRow][startCol][0] = energy;
        queue.offer(new State(startRow, startCol, 0, energy, 0));

        int[] rowDir = {-1, 1, 0, 0};
        int[] colDir = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            State current = queue.poll();

            for (int direction = 0; direction < 4; direction++) {
                int nextRow = current.row + rowDir[direction];
                int nextCol = current.col + colDir[direction];

                if (nextRow < 0 || nextRow >= rows ||
                    nextCol < 0 || nextCol >= cols)
                    continue;

                if (classroom[nextRow].charAt(nextCol) == 'X')
                    continue;

                int remainingEnergy = current.energy - 1;

                if (remainingEnergy < 0)
                    continue;

                int nextMask = current.mask;

                if (classroom[nextRow].charAt(nextCol) == 'R') {
                    remainingEnergy = energy;
                }

                if (classroom[nextRow].charAt(nextCol) == 'L') {
                    nextMask |= (1 << litterId[nextRow][nextCol]);
                }

                if (nextMask == fullMask) {
                    return current.moves + 1;
                }

                if (remainingEnergy <= maxEnergy[nextRow][nextCol][nextMask]){
                    continue;
                }

                maxEnergy[nextRow][nextCol][nextMask] = remainingEnergy;
                queue.offer(new State(nextRow,nextCol,nextMask,remainingEnergy,current.moves + 1));
            }
        }

        return -1;
    }

}