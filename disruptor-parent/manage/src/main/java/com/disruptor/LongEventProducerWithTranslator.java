package com.disruptor;

import com.lmax.disruptor.EventTranslatorOneArg;
import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;

/**
 * @author ljj
 * @description 在disruptor3.0版本中。添加了一个更丰富的lambda风格的API，
 * 通过将这种复杂性封装在ringBuffer(环形缓冲区)来帮助开发人员，因此post-3.0
 * 之后发布消息可以通过Event Publisher(事件发布者)或者Event Translator(事件转换器)
 * 来进行事件发布
 * 优点：这种方法的优点就是可以将转换程序代码放置到单独的类，并且可以轻松的进行单元测试Disruptor
 * 提供类许多不同的接口(EventTranslator、EventTranslatorOneArg、EventTranslatorTwoArg等),
 * 可以实现这些接口来提供Translator，作为Translator方法的参数通过对ringBuffer进行调用传递给
 * Translator。
 * @date 2019/5/10
 */
public class LongEventProducerWithTranslator {

    private final RingBuffer<LongEvent> ringBuffer;

    public LongEventProducerWithTranslator(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    private static final EventTranslatorOneArg<LongEvent, ByteBuffer> TRANSLATOR =
            new EventTranslatorOneArg<LongEvent, ByteBuffer>() {
                @Override
                public void translateTo(LongEvent event, long sequence, ByteBuffer bb) {
                    event.setValue(bb.get(0));
                }
            };

    public void onData(ByteBuffer bb){
        ringBuffer.publishEvent(TRANSLATOR, bb);
    }
}
