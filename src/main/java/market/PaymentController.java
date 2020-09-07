package market;

import market.external.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 @RestController
 public class PaymentController {

     @Autowired
     PaymentRepository paymentRepository;

     @RequestMapping(method= RequestMethod.PATCH, path="/paid")
     public void paid(@RequestBody Paid paid) {
         Payment payment = new Payment();

         payment.setId(paid.getId());
         payment.setPaymentStatus(paid.getPaymentStatus());
         payment.setProductId(paid.getProductId());
         payment.setReservationId(paid.getReservationId());
         payment.setType("paid");
         paymentRepository.save(payment);
     }

 }
