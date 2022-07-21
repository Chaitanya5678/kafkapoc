package io.ather.message_queue.utils;

public class AppConstants {
    public static final String TOPIC_NAME = "ather-events";
    public static final String GROUP_ID = "group_id"; // spring.kafka.consumer.group-id
    public static final int NUMBER_OF_PARTITIONS = 3;
    public static final int NUMBER_OF_REPLICAS = 3;
}
