package org.muzhe.test.lambda2;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author muzhe-wang on  18-9-17 下午12:37.
 */
public class StreamForker<T> {

    private final Stream<T> stream;

    private final Map<Object, Function<Stream<T>, ?>> forks = new HashMap<>();

    public StreamForker(Stream<T> stream) {
        this.stream = stream;
    }

    public StreamForker<T> fork(Object key, Function<Stream<T>, ?> function) {
        forks.put(key, function);
        return this;
    }


    public Results getResults() {

        ForkingStreamConsumer<T> forkingStreamConsumer = build();

        try {
            stream.sequential().forEach(forkingStreamConsumer);
        } catch (Exception ex) {
            forkingStreamConsumer.finish();
        }
        return forkingStreamConsumer;

    }

    /**
     * 创建一个forkingStreamConsumer的对象。
     *
     * @return
     */
    private ForkingStreamConsumer<T> build() {

        List<BlockingQueue<T>> queues = new ArrayList<>();

        Map<Object,Future<?>> actions = forks.entrySet().stream().reduce(
                new HashMap<Object,Future<?>>(),(map,e) ->{
                    map.put(e.getKey(),getOperationResult(queues,e.getValue()));
                }))

        return null;
    }

    private Future<?> getOperationResult(List<BlockingQueue<T>> queues,Function<Stream<T>,?> function){
        BlockingQueue<T> queue = new LinkedBlockingQueue<>();
        queues.add(queue);
        Spliterator<T> spliterator = new BlockingQueueSpliterator<>(queue);
        Stream<T> source = StreamSupport.stream(spliterator, false);
        return
    }


    public static interface Results {
        public <R> R get(Object key);
    }

    private static class ForkingStreamConsumer<T> implements Consumer<T>, Results {

        static final Object END_OF_STREAM = new Object();

        private final List<BlockingQueue<T>> queues;
        private final Map<Object, Future<?>> actions;

        ForkingStreamConsumer(List<BlockingQueue<T>> queues, Map<Object, Future<?>> actions) {
            this.queues = queues;
            this.actions = actions;
        }

        @Override
        public void accept(T t) {
            queues.forEach(q -> q.add(t));
        }

        @Override
        public <R> R get(Object key) {
            try {
                return ((Future<R>) actions.get(key)).get();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }

        public void finish() {
            accept((T) END_OF_STREAM);
        }
    }

    private static class BlockingQueueSpliterator<T> implements Spliterator<T> {

        private final BlockingQueue<T> queue;

        BlockingQueueSpliterator(BlockingQueue<T> queue) {
            this.queue = queue;
        }

        @Override
        public boolean tryAdvance(Consumer<? super T> action) {

            T t;

            while (true) {
                try {
                    t = queue.take();
                    break;
                } catch (InterruptedException ex) {
                    //lodo
                }
            }
            if (t != ForkingStreamConsumer.END_OF_STREAM) {
                action.accept(t);
                return true;
            }
            return false;
        }

        @Override
        public Spliterator<T> trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return 0;
        }

        @Override
        public int characteristics() {
            return 0;
        }
    }
}
