package com.Aconduction.Service;

import com.Aconduction.Entity.Consumer;
import com.Aconduction.Entity.dto.CustomerUsage;
import com.Aconduction.Repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    ConsumerRepository consumerRepository;

    public Consumer getdataFromCustomerUsage(CustomerUsage customerUsage){
        Consumer consumer=new Consumer();
        int coll_cost= customerUsage.getCallMinute() * 2;
        double data_cost= customerUsage.getDataMb() * 0.85;
        double sms_cost= customerUsage.getSmsCount()*2.8;
        double total=data_cost + sms_cost +coll_cost;

        double tax=(0.18)*total;
        double discount=(0.9)*total;
        total=total+tax-discount;

        consumer.setTotal_cost(total);
        consumer.setName(customerUsage.getCustomerName());
        consumer.setBilled(true);
        return consumerRepository.save(consumer);
    }

    @KafkaListener(topics = "bhat-Kafka",groupId = "consumerId")
    public void listendata(CustomerUsage customerUsage){
        getdataFromCustomerUsage(customerUsage);
    }
}
