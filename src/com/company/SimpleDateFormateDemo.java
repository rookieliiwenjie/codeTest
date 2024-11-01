Codepackage com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.*;

/**
 * @Author rookie.li
 * @create 2020/10/26
 */
public class SimpleDateFormateDemo {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
       /* for (int i = 0; i < 10; ++i) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {//(3)使用单例日期实例解析文本
                        System.out.println(simpleDateFormat.parse("2017-12-13 15:17:27"));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();//(4)启动线程
        }*/

        ExecutorService singleThreadPool = new ThreadPoolExecutor(0, 20,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(10));
        Calendar calendar = Calendar.getInstance();
        for (int i = 0; i < 25; i++) {
            singleThreadPool.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + simpleDateFormat.parse("2019-09-21 11:12:13"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            });
        }


        singleThreadPool.shutdown();

    }
}