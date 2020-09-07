package market;

import market.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReserved_PayListRegist(@Payload Reserved reserved){

        if(reserved.isMe()){
            Payment payment = new Payment();
            payment.setProductId(reserved.getProductId());
            payment.setPaymentStatus(reserved.getReservationStatus());
            payment.setReservationId(Integer.parseInt(reserved.getId().toString()));
            paymentRepository.save(payment);
            System.out.println("##### listener PayListRegist : " + reserved.toJson());

        }
    }
}
