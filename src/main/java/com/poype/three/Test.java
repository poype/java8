package com.poype.three;

public class Test {

    public static void main(String[] args) {
        Calculator calculator = new ForkJoinCalculator();
        long[] array = {1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10};
        System.out.println(calculator.sumUp(array));
    }
}
/**
 * ForkJoinPool就是利用分治法的思想
 * 一般的分治法是利用递归函数实现，这样整个计算过程只能在同一个线程中完成，无法利用多个cpu并行
 * RecursiveTask(递归任务)将一个大任务拆分成多个小任务，各个小任务可以分散到不同的线程执行，然后再合并所有的小任务结果最终拼装整个结果
 * fork：Arranges to asynchronously execute this task in the pool the current task is running in
 * fork()不是真的启动一个线程，而是将任务放入到工作队列中。
 * join：Returns the result of the computation when it is done
 * join不是简单地阻塞线程，而是利用工作线程运行其它任务。当一个工作线程中调用了join()方法，它将处理其它任务，直到注意到目标子任务已经完成了。
 *
 * ForkJoinTask代表一个可以并行、合并的任务。ForkJoinTask是一个抽象类，它还有两个抽象子类：RecusiveAction和RecusiveTask。
 *
 * 原理：
 * （1）每个工作线程都有自己的工作队列WorkQueue；
 * （2）这是一个双端队列，它是线程私有的；
 * （3）ForkJoinTask中fork的子任务，将放入运行该任务的工作线程的队头，工作线程将以LIFO的顺序来处理工作队列中的任务；
 * （4）为了最大化地利用CPU，空闲的线程将从其它线程的队列中“窃取”任务来执行；
 * （5）从工作队列的尾部窃取任务，以减少竞争；
 * （6）双端队列的操作：push()/pop()仅在其所有者工作线程中调用，poll()是由其它线程窃取任务时调用的；
 * （7）当只剩下最后一个任务时，还是会存在竞争，是通过CAS来实现的；
 *
 * ForkJoinPool中的线程数根据cpu的核心数而定，例如在8核的cpu上线程池中会包含8个线程
 */

