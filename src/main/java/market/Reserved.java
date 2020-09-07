
package market;

public class Reserved extends AbstractEvent {

    private Long id;
    private String reservationStatus;
    private Integer productId;
    private String productName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName(){
        return productName;
    }
    public void setProductName(){
        this.productName = productName;
    }
}
