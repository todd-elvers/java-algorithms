package te.interview.prep.strings_arrays;

/**
 * @see <a href="https://leetcode.com/problems/robot-return-to-origin/">Problem on leetcode</a>
 */
public class RobotOriginDeterminer {

    public boolean doesRobotEndAtOrigin(String moves) {
        if (moves == null || moves.isEmpty()) return true;

        // An odd number of commands means we can't possibly end at (0,0)
        if (moves.length() % 2 != 0) return false;

        int vertical = 0, horizontal = 0;
        for(char move : moves.toCharArray()) {
            switch(move) {
                case 'U':
                    vertical++;
                    break;
                case 'D':
                    vertical--;
                    break;
                case 'L':
                    horizontal--;
                    break;
                case 'R':
                    horizontal++;
                    break;
            }
        }

        return vertical == 0 && horizontal == 0;
    }


}
