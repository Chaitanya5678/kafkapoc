package io.ather.message_queue.strategies;

public interface MessageQueueStrategy {
    void sendMessage(String message);
    void consume(String message);
}
