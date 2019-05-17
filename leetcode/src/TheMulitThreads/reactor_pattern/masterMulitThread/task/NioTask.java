package TheMulitThreads.reactor_pattern.masterMulitThread.task;

import java.io.Serializable;
import java.nio.channels.SocketChannel;

/**
 * Created by tangjialiang on 2018/1/11.
 * Nio task
 */

public class NioTask implements Serializable {

    private SocketChannel clientChannel ;
    private int op ;
    private Object data ;

    public NioTask(SocketChannel clientChannel, int op) {
        this.clientChannel = clientChannel ;
        this.op = op ;
    }

    public NioTask(SocketChannel clientChannel, int op, Object data) {
        this(clientChannel, op);
        this.data = data ;
    }

    public SocketChannel getClientChannel() {
        return clientChannel;
    }

    public void setClientChannel(SocketChannel clientChannel) {
        this.clientChannel = clientChannel;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

/**
 int[][] array = {
 {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
 {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
 {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1},
 {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
 {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
 {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}
 };
 int x_m = array.length;
 int y_m = array[0].length;
 switch (dir) {
 case 0:
 if (y + 1 >= y_m || array[x][y + 1] != 0) {
 return false;
 }
 y++;
 break;
 case 1:
 if (x + 1 >= x_m || array[x + 1][y] != 0) {
 return false;
 }
 x++;
 break;
 case 2:
 if (y - 1 < 0 || array[x][y - 1] != 0) {
 return false;
 }
 y--;
 break;
 case 3:
 if (x - 1 < 0 || array[x - 1][y] != 0) {
 return false;
 }
 x--;
 break;
 default:
 break;
 }
 */
