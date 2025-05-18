package ma.enset.digitalbanking.mappers;

import ma.enset.app.digitalbanking.dtos.AccountOperationDTO;
import ma.enset.app.digitalbanking.dtos.CurrentAccountDTO;
import ma.enset.app.digitalbanking.dtos.CustomerDTO;
import ma.enset.app.digitalbanking.dtos.SavingAccountDTO;
import ma.enset.app.digitalbanking.entities.AccountOperation;
import ma.enset.app.digitalbanking.entities.CurrentAccount;
import ma.enset.app.digitalbanking.entities.Customer;
import ma.enset.app.digitalbanking.entities.SavingAccount;

public interface BankAccountMapper {
    CustomerDTO getCustomerDTO(Customer customer);
    Customer getCustomer(CustomerDTO customerDTO);
    SavingAccountDTO getSavingAccountDTO(SavingAccount savingAccount);
    SavingAccount getSavingAccount(SavingAccountDTO savingAccountDTO);
    CurrentAccountDTO getCurrentAccountDTO(CurrentAccount currentAccount);
    CurrentAccount getCurrentAccount(CurrentAccountDTO currentAccountDTO);
    AccountOperation getAccountOperation(AccountOperationDTO accountOperationDTO);
    AccountOperationDTO getAccountOperationDTO(AccountOperation accountOperation);
}