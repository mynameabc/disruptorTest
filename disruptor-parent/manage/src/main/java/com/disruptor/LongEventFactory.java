package com.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author ljj
 * @description 通过一个工厂来生产数据(Event)
 * @date 2019/5/10
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
