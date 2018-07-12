# 责任链模式和应用

在一些框架中会提供Filter作为扩展点。这里首先介绍一些Filter的实现方式。然后介绍一下dubbo,SpringMVC,Mybatis中过滤器实现原理。

## Filter和FilterChain

### 案例

#### 问题一

​	处理一个请求的时候，可能会不断的添加对这个请求的操作，一种做法如下：

```java
 public void handlerRequest(String request, String response) {

        doSomething1(request, response);
        doSomething2(request, response);
        doSomething3(request, response);
        
    }
```

​	以上对于一个请求需要１，２，３三个步骤，如果有一个需求是添加第４个步骤，或者是在一个请求中需要使用１，３，另外一个请求中使用２，４.如果随意的修改代码满足需求，就会违反开放闭合原则(对扩展开发，对修改闭合)。如果有1000个操作，代码就会很臃肿。

解决一

​	如果这些操作都有相同的request和response，这个时候将这些操作抽象为一个统一接口的实现，然后使用一个容器将这些接口实现组合在一起向外提供服务。这样就能解决以上的问题，能够随意的扩展以及随意组合。甚至可以更加的易用，可以将这个配置的过程使用一个配置文件实现，或者是注解来实现等。

**抽象接口**：

```java
public interface Filter {

    /**
     * 处理请求
     * @param request
     * @param response
     */
    public void doSomething(String request , String response);

}

```



**实现一**：

```java

public class ShowFilter implements Filter {
    @Override
    public void doSomething(String request, String response) {
        System.out.println("request : " + request + "  response : " + response);
    }
}

```

**实现二**：

```java
@Slf4j
public class LogFilter implements  Filter {
    
    public void doSomething(String request, String response) {
        log.info("request : " + request + "  response : " + response);
    } 
    
}
```



**容器**：

```java
public class FilterChain implements Filter {

    private List<Filter> filterChain = new LinkedList<Filter>();

    public FilterChain addFilterChain(Filter filter) {
        filterChain.add(filter);
        return this;
    }

    public void doSomething(String request, String response) {
        for (Filter filter : filterChain) {
            filter.doSomething(request, response);
        }
    }
    
}
```



**调用**：

```java
public static void main(String[] args) {

        Filter filter = generateFilterChain();
        String request = "张三";
        String response = "zhagnsan";
        filter.doSomething(request, response);

    }

    private static Filter generateFilterChain() {

        FilterChain filterChain = new FilterChain();
        filterChain.addFilterChain(new SoutFilter());
        filterChain.addFilterChain(new LogFilter());
        return filterChain;

    }
```

通过一个`private static Filter generateFilterChain()`来构建一个过滤器。也可以根据需求构建更多的过滤器。

#### 问题二

这里只能对请求进行过滤，有一个需求是对请求和返回结果进行过滤。如下图实现。

---> filter1 ---> filter2 ---> filter3 ---> filter4 |

 <--- filter1<--- filter2 <--- filter3 <--- filter4 |

对于执行的顺序进行修改：第一步执行前置过滤，第二步执行过滤链，第三步执行后置过滤

相对的Filter接口中需要知道过滤链的引用，接口需要修改。

**抽象接口**

```java
public interface Filter {

    /**
     * 过滤接口
     * @param request       请求参数
     * @param response      返回结果
     * @param filterChain   过滤链　由于需要在过滤链之后执行操作，所以需要将过滤链作为参数传递进来
     */
    void doFilter(String request ,String response , FilterChain filterChain);

}
```

**实现一**

```java
public class StdFilter implements Filter {

    public void doFilter(String request, String response, FilterChain filterChain) {

        //前置执行
        System.out.println(request);
        //过滤链执行
        filterChain.doFilter(request,response , filterChain);
        //后置执行
        System.out.println(response);

    }

}
```

**实现二**

```java
@Slf4j
public class LogFilter implements Filter {

    public void doFilter(String request, String response, FilterChain filterChain) {

        //前置执行
        log.info(request);
        //过滤链执行
        filterChain.doFilter(request , response, filterChain);
        //后置执行
        log.info(response);

    }
    
}
```

**容器**

```java
public class FilterChain implements Filter {

    private List<Filter> filterList;
    private int position;

    public FilterChain() {
        filterList = new LinkedList<Filter>();
        position = 0;
    }

    /**
     * 注册　过滤器
     *
     * @param filter
     * @return
     */
    public FilterChain addFilter(Filter filter) {
        this.filterList.add(filter);
        return this;
    }

    public void doFilter(String request, String response, FilterChain filterChain) {

        if (position < filterList.size()) {
            filterList.get(position++).doFilter(request, response, this);
        }

    }

}

```

以上是一个容器，维护了所有的过滤器的信息。其中postion对象维护了调用链调用的进度。在调用过程中所有的过滤器都使用了这个调用链对象。

**调用**

```java
public class MainTest {

    public static void main(String[] args) {

        FilterChain filterChain = generateStdLogFilter();
        String request = "request";
        String response = "response";
        filterChain.doFilter(request, response, filterChain);
        System.out.println("**********************************");
        FilterChain filterChain2 = genearteLogStdFilter();
        filterChain2.doFilter(request, response, filterChain2);
    }

    private static FilterChain genearteLogStdFilter() {

        FilterChain filterChain = new FilterChain();
        Filter logFilter = new LogFilter();
        Filter stdFilter = new StdFilter();
        filterChain.addFilter(logFilter).addFilter(stdFilter);
        return filterChain;

    }

    private static FilterChain generateStdLogFilter() {
        FilterChain filterChain = new FilterChain();
        Filter stdFilter = new StdFilter();
        Filter logFilter = new LogFilter();
        filterChain.addFilter(stdFilter).addFilter(logFilter);
        return filterChain;
    }
}
```

通过不同方法构造过滤链，然后使用这些过滤链进行执行。

执行的结果：

```java
request
[2018-07-12 14:49:09] [INFO ] filterChain.demo1.blogDemo2.LogFilter 13 -- [] request
[2018-07-12 14:49:09] [INFO ] filterChain.demo1.blogDemo2.LogFilter 15 -- [] response
response
***************************************************************************************
[2018-07-12 14:49:09] [INFO ] filterChain.demo1.blogDemo2.LogFilter 13 -- [] request
request
response
[2018-07-12 14:49:09] [INFO ] filterChain.demo1.blogDemo2.LogFilter 15 -- [] response
```

上面一半是StdFilter+LogFilter的实现，request先输出到控制台，然后输出到日志，response先输出到日志，然后输出到控制台;下面一半是LogFilter+StdFilter的实现，request先输出到日志，然后输出到控制台，response先输出到控制台，然后输出到日志。



### dubbo中Filter的实现

dubbo中构造责任链是在`ProtocolFilterWrapper`类中的`private static <T> Invoker<T> buildInvokerChain(final Invoker<T> invoker, String key, String group)`方法中实现的。这里用了一种责任链的方式实现的。

```java
/**
     * 这个方法是通过当前的Invoker构造一个　调用链。　
     * 第一点：实现的方式是将　Filter转换为一个　Invoker　的实现。
     * 第二点：将每一个Filter对象转变为一个Invoker类，其中的invoke方法调用了filter中的实现。这样将所有的Filter串联起来。
     * 
     * @param invoker
     * @param key
     * @param group
     * @param <T>
     * @return
     */
    private static <T> Invoker<T> buildInvokerChain(final Invoker<T> invoker, String key, String group) {
        //引用
        Invoker<T> last = invoker;//这个表示最后执行的对象。
        //找出当前Invoker所关注的所有的Filter
        List<Filter> filters = ExtensionLoader.getExtensionLoader(Filter.class).getActivateExtension(invoker.getUrl(), key, group);
        //将所有Filter转换为一个Invoker，最里面的是　正在的Invoker。向外的是依次封装的对象。
        if (filters.size() > 0) {
            for (int i = filters.size() - 1; i >= 0; i --) {

                final Filter filter = filters.get(i);
                final Invoker<T> next = last;
                last = new Invoker<T>() {

                    public Class<T> getInterface() {
                        return invoker.getInterface();
                    }

                    public URL getUrl() {
                        return invoker.getUrl();
                    }

                    public boolean isAvailable() {
                        return invoker.isAvailable();
                    }

                    public Result invoke(Invocation invocation) throws RpcException {
                        //这里封装了一个Invoker。
                        return filter.invoke(next, invocation);
                    }

                    public void destroy() {
                        invoker.destroy();
                    }

                    @Override
                    public String toString() {
                        return invoker.toString();
                    }
                };
            }
        }
        return last;
    }
```

在filter的方法中会有一个参数是Invoker，可以没有吗，也可以，但是会比较的麻烦。

一个DEMO:

**Filter**

```java
/**
 * @author muzhe-wang on  18-7-12 下午4:22.
 */
public interface Filter {

    /**
     * 执行当前系统中的实现
     *
     * @param invoker    执行器,这个执行器需要封装在当前的方法中，否则就需要提供一个方法给Filter取得当前Filter封装Invoker对象。
     * @param invocation 执行参数
     * @return 执行结果
     */
    public String filter(Invoker invoker, String invocation);

}
```

**Invoker**

```java
/**
 * @author muzhe-wang on  18-7-12 下午4:18.
 */
public interface Invoker {

    /**
     * 执行当前的实现。这个类是被封装的对象
     * @param invocation
     * @return
     */
    String doInvoke(String invocation);
    
}
```

**FilterWrapper**

```java
public class FilterWrapper {

    /**
     * 返回执行之后的Filter对象。
     * @param invoker 执行器
     * @return 封装了Filter的Invoker对象
     */
    public static Invoker buildFilterChain(Invoker invoker) {

        Invoker last = invoker;
        final List<Filter> filterList = getFilterList(invoker);

        if (filterList.size() > 0) {
            //从后往前依次封装当前对象
            for (int i = filterList.size() - 1; i >= 0; i--) {
                final Invoker next = last;
                final Filter filter = filterList.get(i);
                last = new Invoker() {
                    public String doInvoke(String invocation) {
                        return filter.filter(next, invocation);
                    }
                };
            }
        }
        return last;
    }

    private static List<Filter> getFilterList(Invoker invoker) {

        List<Filter> filterList = new LinkedList<Filter>();
        filterList.add(new FirstFilter());
        filterList.add(new SecondFilter());

        return filterList;
    }

}

}
```

这个对象封装了通过Invoker封装了Filter。

### SpringMVC的Interceptor的实现

在ＳpringMVC中经常会使用Interceptor拦截一些请求，然后在这个拦截器中实现一些功能。这里也是使用了一个责任链来实现的。可以看一下代码。

```java
protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpServletRequest processedRequest = request;
		HandlerExecutionChain mappedHandler = null;
		boolean multipartRequestParsed = false;

		WebAsyncManager asyncManager = WebAsyncUtils.getAsyncManager(request);

		try {
			ModelAndView mv = null;
			Exception dispatchException = null;

			try {
				processedRequest = checkMultipart(request);
				multipartRequestParsed = processedRequest != request;

				// Determine handler for the current request.
				mappedHandler = getHandler(processedRequest);
				if (mappedHandler == null || mappedHandler.getHandler() == null) {
					noHandlerFound(processedRequest, response);
					return;
				}

				// Determine handler adapter for the current request.
				HandlerAdapter ha = getHandlerAdapter(mappedHandler.getHandler());

				// Process last-modified header, if supported by the handler.
				String method = request.getMethod();
				boolean isGet = "GET".equals(method);
				if (isGet || "HEAD".equals(method)) {
					long lastModified = ha.getLastModified(request, mappedHandler.getHandler());
					if (logger.isDebugEnabled()) {
						logger.debug("Last-Modified value for [" + getRequestUri(request) + "] is: " + lastModified);
					}
					if (new ServletWebRequest(request, response).checkNotModified(lastModified) && isGet) {
						return;
					}
				}

				if (!mappedHandler.applyPreHandle(processedRequest, response)) {
					return;
				}

				try {
					// Actually invoke the handler.
					mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
				}
				finally {
					if (asyncManager.isConcurrentHandlingStarted()) {
						return;
					}
				}

				applyDefaultViewName(request, mv);
				mappedHandler.applyPostHandle(processedRequest, response, mv);
			}
			catch (Exception ex) {
				dispatchException = ex;
			}
			processDispatchResult(processedRequest, response, mappedHandler, mv, dispatchException);
		}
		catch (Exception ex) {
			triggerAfterCompletion(processedRequest, response, mappedHandler, ex);
		}
		catch (Error err) {
			triggerAfterCompletionWithError(processedRequest, response, mappedHandler, err);
		}
		finally {
			if (asyncManager.isConcurrentHandlingStarted()) {
				// Instead of postHandle and afterCompletion
				mappedHandler.applyAfterConcurrentHandlingStarted(processedRequest, response);
				return;
			}
			// Clean up any resources used by a multipart request.
			if (multipartRequestParsed) {
				cleanupMultipart(processedRequest);
			}
		}
	}
```

以上代码中可以看出获取责任链的实现：

```java
// Determine handler for the current request.
mappedHandler = getHandler(processedRequest);
```

以上方法是获取到当前请求的过滤器。看下这个代码的实现：

一路跟下去可一看出获取到Interceptor的获取的方式：

具体实现是`AbstractHandlerMapping.`

```java
protected HandlerExecutionChain getHandlerExecutionChain(Object handler, HttpServletRequest request) {
		HandlerExecutionChain chain = (handler instanceof HandlerExecutionChain ?
				(HandlerExecutionChain) handler : new HandlerExecutionChain(handler));
		chain.addInterceptors(getAdaptedInterceptors());

		String lookupPath = this.urlPathHelper.getLookupPathForRequest(request);
		for (MappedInterceptor mappedInterceptor : this.mappedInterceptors) {
			if (mappedInterceptor.matches(lookupPath, this.pathMatcher)) {
				chain.addInterceptor(mappedInterceptor.getInterceptor());
			}
		}

		return chain;
	}
```

这里将所有适配的Interceptor的添加到这个过滤器链中，然后执行这个链路中关于什么周期中的方法。

这里主要有三个方法：

**方法一**：`boolean applyPreHandle(HttpServletRequest request, HttpServletResponse response)`在执行之前

```java
boolean applyPreHandle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (getInterceptors() != null) {
			for (int i = 0; i < getInterceptors().length; i++) {
				HandlerInterceptor interceptor = getInterceptors()[i];
				if (!interceptor.preHandle(request, response, this.handler)) {
					triggerAfterCompletion(request, response, null);
					return false;
				}
				this.interceptorIndex = i;
			}
		}
		return true;
	}
```



这个方法从头开始执行这个链路。

**方法二**：`void applyPostHandle(HttpServletRequest request, HttpServletResponse response, ModelAndView mv)`请求完成以后执行。

```
/**
 * Apply postHandle methods of registered interceptors.
 */
void applyPostHandle(HttpServletRequest request, HttpServletResponse response, ModelAndView mv) throws Exception {
   if (getInterceptors() == null) {
      return;
   }
   for (int i = getInterceptors().length - 1; i >= 0; i--) {
      HandlerInterceptor interceptor = getInterceptors()[i];
      interceptor.postHandle(request, response, this.handler, mv);
   }
}
```

方法三：`void triggerAfterCompletion(HttpServletRequest request, HttpServletResponse response, Exception ex)`处理所有的请求

```java
/**
	 * Trigger afterCompletion callbacks on the mapped HandlerInterceptors.
	 * Will just invoke afterCompletion for all interceptors whose preHandle invocation
	 * has successfully completed and returned true.
	 */
	void triggerAfterCompletion(HttpServletRequest request, HttpServletResponse response, Exception ex)
			throws Exception {

		if (getInterceptors() == null) {
			return;
		}
		for (int i = this.interceptorIndex; i >= 0; i--) {
			HandlerInterceptor interceptor = getInterceptors()[i];
			try {
				interceptor.afterCompletion(request, response, this.handler, ex);
			}
			catch (Throwable ex2) {
				logger.error("HandlerInterceptor.afterCompletion threw exception", ex2);
			}
		}
	}
```

这个方法的执行的起点是interceptorIndex的位置，有一种情况是如果请求之前前的过滤器执行中断，这个时候只执行这些方法，并不会执行全部的方法。

以上。

### 总结

两种责任链模式的实现中，一种是每一个Filter中维护下一个Filter的引用，dubbo使用这种实现方式;还有一种使用一个List+position来维护Filter的引用，SpringMVC就使用这种实现方式。这两种实现方式中第二种的实现方式更加灵活，第一种更加简单。