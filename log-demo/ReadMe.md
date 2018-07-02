#应该如何记录日志

##排查问题的日志
- 依赖外部系统的调用

调用外部系统的前后都记录下日志，能够很方便的排查问题。出错能够方便的排查问题。
```java

public void showInvokeRemoteService(Object param){

        log.info("invoke remote service , the param = {}" , param);
        try {
            
             Object result = invokeRemoteService(param);
            log.info("invoke remote service success , the result ={}" , result);

        }catch (Exception ex){
            log.error("invoke remote service fail ,the param = " + param  ,ex);
        }
        
    }
    
```

- 整个系统的入口或者某个服务的入口

整个系统的输入,便于排查问题。
```java

 public Object serviceFacade(Object param){

        log.info("call service , the param ={}" , param);
        Object result = null;
        //业务代码
        log.info("call service, the result={}" , result);
        return result;

    }
    
```

- 系统中核心流程的关键状态

将当前流程中的关键流程记录下来，便于定位

```java

    public void showImportantStatus(){
    
            //bizz　code 1
            String  importantStatus ="开始开户";
            log.info(" the important status >> {}" , importantStatus);
    
            //bizz　code 2
            importantStatus = "提交信息成功";
            log.info("the import status >> {}" , importantStatus);
    
            //bizz code 3
            importantStatus = "审核通过";
            log.info("the important status >> {}" , importantStatus);
    
            //bizz code 4
            importantStatus = "开户成功";
            log.info("the important status >> {}" , importantStatus);
    
        }
        
```
- 系统允许过程中异常信息

将系统中关键的异常打印出来。
 
 ```java

public  void showBusinessException(Object param){

        try{
          
            //bizz code

        }catch (IOException ex){
            log.warn("execute biz fail ,the param = " + param , ex);
        }catch (BusinessException ex){
            log.warn("execute biz fail, the param =" + param + "the fail reason  " , ex );
        }catch (Exception ex){
            log.error("execute biz fail , the param = " + param , ex);
        }

    }
    
```

- 将超出预期运行场景打印出来


```java

 public void showIllegalStatus(Object param){

        int updateCount = updatePayStatus(param);
        if (updateCount <= 0){
            log.info(" update pay status　，the param ={} , the updateCount ={}" , param, updateCount);
        }

    }

```




##不好的实现


- 没有提供足够上下文的日志

打印的日志中缺少上下文，这样日志就无法根据关键字检索到相对应的异常日志，这条信息不便于排查。

```java

 public void lostContext(Object param){
        
        Object result = doSomething(param);
        if (result == null){
            log.info("the result is illegal");
        }
        
    }

```

- 记错位置的日志
将错误信息记录在类控制台上，没有打印在对应文件中。

```java

public void outputIllegalPoint() {
        try {
            //bizz code
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

```

- 记错级别的日志
```java

 public  void illegalLogLevel(Object param){

        try{
            //biz Code
        }catch (Exception ex){
            log.info("invoke the service occur exception ,the param ={}" , param , ex);
        }

    }

```

- 日志信息遗漏
日志被搜索出来，但是没有记录下足够的信息。
```java
public void lostInfo(Object param){

        try {
            //biz Code
        }catch ( Exception ex){
            log.error(" invoke the service occur exception ,the param =" + param);
        }
    }
```