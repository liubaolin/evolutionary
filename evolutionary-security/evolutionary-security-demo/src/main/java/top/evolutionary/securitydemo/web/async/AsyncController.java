package top.evolutionary.securitydemo.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * spring mvc异步请求的两种方式
 */
@RestController
public class AsyncController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MockQueue mockQueue;
    @Autowired
    DeferredResultHolder deferredResultHolder;

    @GetMapping("/order")
    public String order() throws InterruptedException {
        logger.info("主线程开始");
        Thread.sleep(1000);
        logger.info("主线程结束");
        return "success";
    }

    @GetMapping("/order/async")
    public Callable<String> ordeAsync() throws InterruptedException {
        logger.info("主线程开始");
        Callable<String> result =  () -> {
            logger.info("副线程开始");
            Thread.sleep(2000);
            logger.info("副线程结束");
            return "success";
        };
        logger.info("主线程结束");
        return result;
    }

    @GetMapping("/order/async/deferred")
    public DeferredResult<String> ordeAsyncDeferred() throws InterruptedException {
        logger.info("主线程开始");
        String orderNumber = RandomStringUtils.randomNumeric(8);
        mockQueue.setPlaceOrder(orderNumber);

        DeferredResult<String> result = new DeferredResult<>();
        deferredResultHolder.getMap().put(orderNumber, result);
        logger.info("主线程结束");

        return result;
    }

}
