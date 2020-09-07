package market;

import javax.persistence.*;

import market.external.Product;
import market.external.ProductService;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Payment_table")
public class Payment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer reservationId;
    private Integer productId;
    private String paymentStatus;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @PostUpdate
    public void onPostUpdate(){

// 부하 주는 로직
//        try {
//            Thread.currentThread().sleep((long) (400 + Math.random() * 220));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Paid paid = new Paid();
        BeanUtils.copyProperties(this, paid);
        paid.publish();

        Product product = new Product();
        product.setId(this.getProductId());
        product.setProductStatus("soldOut");

        ProductService productService = Application.applicationContext.getBean(ProductService.class);
        productService.productStatusChange(product);

    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }



}
