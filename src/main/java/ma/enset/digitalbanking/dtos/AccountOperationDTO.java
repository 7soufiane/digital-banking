package ma.enset.digitalbanking.dtos;

import ma.enset.app.digitalbanking.enums.OperationType;
import lombok.Data;

import java.util.Date;

@Data
public class AccountOperationDTO {
    private Date operationDate;
    private double amount;
    private OperationType type;
    private String description;
}