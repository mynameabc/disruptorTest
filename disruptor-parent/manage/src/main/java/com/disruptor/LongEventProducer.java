package com.disruptor;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ljj
 * @description
 * @date 2019/5/10
 */
public class LongEventProducer {

    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducer(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    //发布事件
    public void onData(ByteBuffer bb){

        //1.获取下一个序列
        long sequence = ringBuffer.next();
        try {

            //2.获取disruptor的sequence
            LongEvent event = ringBuffer.get(sequence);

            //3.设置事件Context
            event.setValue(bb.getLong(0));
        } finally {
            //4.发布事件
            ringBuffer.publish(sequence);
        }
    }
}
