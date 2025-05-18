package ma.enset.digitalbanking.mappers;

import ma.enset.app.digitalbanking.dtos.AccountOperationDTO;
import ma.enset.app.digitalbanking.dtos.CurrentAccountDTO;
import ma.enset.app.digitalbanking.dtos.CustomerDTO;
import ma.enset.app.digitalbanking.dtos.SavingAccountDTO;
import ma.enset.app.digitalbanking.entities.AccountOperation;
import ma.enset.app.digitalbanking.entities.CurrentAccount;
import ma.enset.app.digitalbanking.entities.Customer;
import ma.enset.app.digitalbanking.entities.SavingAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapperImpl implements BankAccountMapper {
    @Override
    public CustomerDTO getCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties(customer, customerDTO);
        return customerDTO;
    }

    @Override
    public Customer getCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }

    @Override
    public SavingAccount getSavingAccount(SavingAccountDTO savingAccountDTO) {
        SavingAccount savingAccount = new SavingAccount();
        BeanUtils.copyProperties(savingAccountDTO, savingAccount);
        savingAccount.setCustomer(getCustomer(savingAccountDTO.getCustomer()));
        return savingAccount;
    }

    @Override
    public SavingAccountDTO getSavingAccountDTO(SavingAccount savingAccount) {
        SavingAccountDTO savingAccountDTO = new SavingAccountDTO();
        BeanUtils.copyProperties(savingAccount, savingAccountDTO);
        savingAccountDTO.setCustomer(getCustomerDTO(savingAccount.getCustomer()));
        savingAccountDTO.setType(SavingAccount.class.getSimpleName());
        return savingAccountDTO;
    }

    @Override
    public CurrentAccount getCurrentAccount(CurrentAccountDTO currentAccountDTO) {
        CurrentAccount currentAccount = new CurrentAccount();
        BeanUtils.copyProperties(currentAccountDTO, currentAccount);
        currentAccount.setCustomer(getCustomer(currentAccountDTO.getCustomer()));
        currentAccountDTO.setType(CurrentAccount.class.getSimpleName());
        return currentAccount;
    }

    @Override
    public CurrentAccountDTO getCurrentAccountDTO(CurrentAccount currentAccount) {
        CurrentAccountDTO currentAccountDTO = new CurrentAccountDTO();
        BeanUtils.copyProperties(currentAccount, currentAccountDTO);
        currentAccountDTO.setCustomer(getCustomerDTO(currentAccount.getCustomer()));
        return currentAccountDTO;
    }

    @Override
    public AccountOperation getAccountOperation(AccountOperationDTO accountOperationDTO) {
        AccountOperation accountOperation = new AccountOperation();
        BeanUtils.copyProperties(accountOperation, accountOperationDTO);
        return accountOperation;
    }

    @Override
    public AccountOperationDTO getAccountOperationDTO(AccountOperation accountOperation) {
        AccountOperationDTO accountOperationDTO = new AccountOperationDTO();
        accountOperationDTO.setType(accountOperation.getType());
        accountOperationDTO.setOperationDate(accountOperation.getOperationDate());
        accountOperationDTO.setAmount(accountOperation.getAmount());
        accountOperationDTO.setDescription(accountOperation.getDescription());
        return accountOperationDTO;
    }
}