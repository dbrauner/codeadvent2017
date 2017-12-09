package day5;

/**
 * Created by douglas on 09/12/2017.
 */
public class TrampolineMaze {

    public int findMazeExit(int[] jumpList) {
        int steps = 0;
        int index = 0;
        while (true) {
            if (index >= jumpList.length)
                return steps;
            int jump = jumpList[index];
            jumpList[index]++;

            index += jump;

            steps++;
        }

    }
}
