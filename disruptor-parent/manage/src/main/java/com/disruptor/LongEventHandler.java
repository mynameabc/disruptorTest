package com.disruptor;

import com.lmax.disruptor.EventHandler;

/**
 * @author ljj
 * @description 在定义了Event之后我们需要创建一个消费者来处理这些事件，也是一个事件处理器
 * @date 2019/5/10
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    private String clientName;

    LongEventHandler(String clientName){
        this.clientName = clientName;
    }

    /**
     * 事件监听，类似观察者模式
     * @param event
     * @param sequence
     * @param endOfBatch
     * @throws Exception
     */
    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
//        System.out.println(this.clientName + event.get());//向Client推送消息
        event.getValue();
    }
}
