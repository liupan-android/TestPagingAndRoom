package com.lp.testpagingandroom.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Author: liupan
 * @Date: 2020/11/24
 */
public class AppExecutor {
//    private static Executor mSingleExecutor;

    private AppExecutor(){

    }

    public static Executor getInstance() {
        return ExecutorEnum.SINGLE_THREAD.getExecutor();
    }

    private enum ExecutorEnum{
        SINGLE_THREAD;
        private Executor executor;
        private ExecutorEnum(){
            executor = Executors.newSingleThreadExecutor();
        }

        public Executor getExecutor() {
            return executor;
        }
    }
}
