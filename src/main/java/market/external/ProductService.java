
package market.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by uengine on 2018. 11. 21..
 */

@FeignClient(name="Product", url="http://Product:8080")
public interface ProductService {

    @RequestMapping(method= RequestMethod.PATCH, path="/productupdate")
    public void productStatusChange(@RequestBody Product product);

}