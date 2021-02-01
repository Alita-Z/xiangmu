package com.example.hardcoredemo.modular.disruptor;

import com.lmax.disruptor.EventFactory;

public class MyEventFactory implements EventFactory<SeriesDataEvent> {

    @Override
    public SeriesDataEvent newInstance() {
        return new SeriesDataEvent();
    }
}
