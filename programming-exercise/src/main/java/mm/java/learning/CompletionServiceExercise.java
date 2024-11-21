package mm.java.learning;

import java.util.concurrent.*;

/**
 * @ClassName CompletionServiceExercise
 * @Description TODO
 * @Author mars
 * @Date 2024/11/21 11:02
 * @Version 1.0
 **/
public class CompletionServiceExercise {
    // 创建线程池
    ScheduledExecutorService blackListCheckExecutorService = new ScheduledThreadPoolExecutor(20, new BasicThreadFactory.Builder().namingPattern("multi-black-list-decision-%d").build());

    // 定义一个completionService，返回值为boolean类型
    CompletionService<Boolean> completionService = new ExecutorCompletionService<>(blackListCheckExecutorService);

    // 把要执行的任务提交给completionService
    for (String blackListName : mutiBlackListDecisionObject.getBlackListNames()) {
        completionService.submit(() -> getData(new BlackListDecisionObject(mutiBlackListDecisionObject, blackListName)) != null);
    }

    try {
        int tasks = mutiBlackListDecisionObject.getBlackListNames().size();
        // 在循环中不断尝试get返回结构
        while (tasks > 0) {
            Future<Boolean> future = completionService.take();
            boolean result = future.get();
            // 拿到一个结果后就判断是否为true
            // 只要有一个为true直接返回true
            if (result) {
                return true;
            }
        }
    } catch (InterruptedException | ExecutionException e) {
        return false;
    }
}
