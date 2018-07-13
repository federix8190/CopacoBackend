package py.com.copaco.billing.entities;

import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultFacturaPago {
 Integer codFactura;
 BigInteger codPago;
 BigDecimal monto;
}
