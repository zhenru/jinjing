package org.bupt.muzhe.log;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author muzhe-wang on  18-6-29 上午10:32.
 */
@Slf4j
public class LogType {


    /**
     * 调用远端的服务的输入和输出
     *
     * @param param
     */
    public void showInvokeRemoteService(Object param) {

        log.info("invoke remote service , the param = {}", param);
        try {

            Object result = invokeRemoteService(param);
            log.info("invoke remote service success , the result ={}", result);

        } catch (Exception ex) {
            log.error("invoke remote service fail ,the param = " + param, ex);
        }

    }

    /**
     * 整个系统的入口
     *
     * @param param
     * @return
     */
    public Object serviceFacade(Object param) {

        log.info("call service , the param ={}", param);
        Object result = null;
        //业务代码
        log.info("call service, the result={}", result);
        return result;

    }


    /**
     * 　输出重要的状态
     */
    public void showImportantStatus() {

        //bizz　code 1
        String importantStatus = "开始开户";
        log.info(" the important status >> {}", importantStatus);

        //bizz　code 2
        importantStatus = "提交信息成功";
        log.info("the import status >> {}", importantStatus);

        //bizz code 3
        importantStatus = "审核通过";
        log.info("the important status >> {}", importantStatus);

        //bizz code 4
        importantStatus = "开户成功";
        log.info("the important status >> {}", importantStatus);

    }


    /**
     * 显示业务流程中的关键异常
     */
    public void showBusinessException(Object param) {

        try {

            //bizz code

        } catch (IOException ex) {
            log.warn("execute biz fail ,the param = " + param, ex);
        } catch (BusinessException ex) {
            log.warn("execute biz fail, the param =" + param + "the fail reason  ", ex);
        } catch (Exception ex) {
            log.error("execute biz fail , the param = " + param, ex);
        }

    }

    /**
     * 将一些非预期的状态打印出来
     */
    public void showIllegalStatus(Object param) {

        int updateCount = updatePayStatus(param);
        if (updateCount <= 0) {
            log.info(" update pay status　，the param ={} , the updateCount ={}", param, updateCount);
        }

    }


    /**
     * 失去上下文的信息
     *
     * @param param
     */
    public void lostContext(Object param) {

        Object result = doSomething(param);
        if (result == null) {
            log.info("the result is illegal");
        }

    }


    public void outputIllegalPoint() {
        try {
            //bizz code
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 错误的日志等级
     */
    public  void illegalLogLevel(Object param){

        try{
            //errorCode
        }catch (Exception ex){
            log.info("invoke the service occur exception ,the param ={}" , param , ex);
        }

    }

    public void lostInfo(Object param){

        try {
            //biz Code
        }catch ( Exception ex){
            log.error(" invoke the service occur exception ,the param =" + param);
        }
    }

    private Object doSomething(Object param) {
        return null;
    }

    private int updatePayStatus(Object param) {
        return 0;
    }

    private Object invokeRemoteService(Object param) {
        return null;
    }
}
