package com.example.digitalbanking.mappers;

import com.example.digitalbanking.dtos.AccountOperationDTO;
import com.example.digitalbanking.dtos.BankAccountDTO;
import com.example.digitalbanking.dtos.CurrentAccountDTO;
import com.example.digitalbanking.dtos.CustomerDTO;
import com.example.digitalbanking.dtos.SavingAccountDTO;
import com.example.digitalbanking.entities.AccountOperation;
import com.example.digitalbanking.entities.AppUser;
import com.example.digitalbanking.entities.BankAccount;
import com.example.digitalbanking.entities.CurrentAccount;
import com.example.digitalbanking.entities.Customer;
import com.example.digitalbanking.entities.SavingAccount;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-08T16:37:45+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (JetBrains s.r.o.)"
)
@Component
public class BankAccountMapperImpl implements BankAccountMapper {

    @Override
    public CustomerDTO fromCustomer(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setCreatedByUsername( customerAppUserUsername( customer ) );
        customerDTO.setId( customer.getId() );
        customerDTO.setName( customer.getName() );
        customerDTO.setEmail( customer.getEmail() );

        return customerDTO;
    }

    @Override
    public Customer fromCustomerDTO(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDTO.getId() );
        customer.setName( customerDTO.getName() );
        customer.setEmail( customerDTO.getEmail() );

        return customer;
    }

    @Override
    public BankAccountDTO fromBankAccount(BankAccount bankAccount) {
        if ( bankAccount == null ) {
            return null;
        }

        BankAccountDTO bankAccountDTO = new BankAccountDTO();

        bankAccountDTO.setCustomer( fromCustomer( bankAccount.getCustomer() ) );
        bankAccountDTO.setId( bankAccount.getId() );
        bankAccountDTO.setBalance( bankAccount.getBalance() );
        bankAccountDTO.setCreatedAt( bankAccount.getCreatedAt() );
        bankAccountDTO.setStatus( bankAccount.getStatus() );

        bankAccountDTO.setType( getAccountType(bankAccount) );
        bankAccountDTO.setOverdraft( getOverdraft(bankAccount) );
        bankAccountDTO.setInterestRate( getInterestRate(bankAccount) );

        return bankAccountDTO;
    }

    @Override
    public SavingAccountDTO fromSavingAccount(SavingAccount savingAccount) {
        if ( savingAccount == null ) {
            return null;
        }

        SavingAccountDTO savingAccountDTO = new SavingAccountDTO();

        savingAccountDTO.setCustomer( fromCustomer( savingAccount.getCustomer() ) );
        savingAccountDTO.setId( savingAccount.getId() );
        savingAccountDTO.setBalance( savingAccount.getBalance() );
        savingAccountDTO.setCreatedAt( savingAccount.getCreatedAt() );
        savingAccountDTO.setStatus( savingAccount.getStatus() );
        savingAccountDTO.setInterestRate( savingAccount.getInterestRate() );

        savingAccountDTO.setType( "SAVING" );

        return savingAccountDTO;
    }

    @Override
    public SavingAccount toSavingAccount(SavingAccountDTO savingAccountDTO) {
        if ( savingAccountDTO == null ) {
            return null;
        }

        SavingAccount savingAccount = new SavingAccount();

        savingAccount.setCustomer( fromCustomerDTO( savingAccountDTO.getCustomer() ) );
        savingAccount.setId( savingAccountDTO.getId() );
        savingAccount.setBalance( savingAccountDTO.getBalance() );
        savingAccount.setCreatedAt( savingAccountDTO.getCreatedAt() );
        savingAccount.setStatus( savingAccountDTO.getStatus() );
        savingAccount.setInterestRate( savingAccountDTO.getInterestRate() );

        return savingAccount;
    }

    @Override
    public CurrentAccountDTO fromCurrentAccount(CurrentAccount currentAccount) {
        if ( currentAccount == null ) {
            return null;
        }

        CurrentAccountDTO currentAccountDTO = new CurrentAccountDTO();

        currentAccountDTO.setCustomer( fromCustomer( currentAccount.getCustomer() ) );
        currentAccountDTO.setId( currentAccount.getId() );
        currentAccountDTO.setBalance( currentAccount.getBalance() );
        currentAccountDTO.setCreatedAt( currentAccount.getCreatedAt() );
        currentAccountDTO.setStatus( currentAccount.getStatus() );
        currentAccountDTO.setOverdraft( currentAccount.getOverdraft() );

        currentAccountDTO.setType( "CURRENT" );

        return currentAccountDTO;
    }

    @Override
    public CurrentAccount toCurrentAccount(CurrentAccountDTO currentAccountDTO) {
        if ( currentAccountDTO == null ) {
            return null;
        }

        CurrentAccount currentAccount = new CurrentAccount();

        currentAccount.setCustomer( fromCustomerDTO( currentAccountDTO.getCustomer() ) );
        currentAccount.setId( currentAccountDTO.getId() );
        currentAccount.setBalance( currentAccountDTO.getBalance() );
        currentAccount.setCreatedAt( currentAccountDTO.getCreatedAt() );
        currentAccount.setStatus( currentAccountDTO.getStatus() );
        currentAccount.setOverdraft( currentAccountDTO.getOverdraft() );

        return currentAccount;
    }

    @Override
    public AccountOperationDTO fromAccountOperation(AccountOperation accountOperation) {
        if ( accountOperation == null ) {
            return null;
        }

        AccountOperationDTO accountOperationDTO = new AccountOperationDTO();

        accountOperationDTO.setBankAccountId( accountOperationBankAccountId( accountOperation ) );
        accountOperationDTO.setPerformedByUsername( accountOperationAppUserUsername( accountOperation ) );
        accountOperationDTO.setId( accountOperation.getId() );
        accountOperationDTO.setOperationDate( accountOperation.getOperationDate() );
        accountOperationDTO.setAmount( accountOperation.getAmount() );
        accountOperationDTO.setType( accountOperation.getType() );
        accountOperationDTO.setDescription( accountOperation.getDescription() );

        return accountOperationDTO;
    }

    private String customerAppUserUsername(Customer customer) {
        if ( customer == null ) {
            return null;
        }
        AppUser appUser = customer.getAppUser();
        if ( appUser == null ) {
            return null;
        }
        String username = appUser.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    private String accountOperationBankAccountId(AccountOperation accountOperation) {
        if ( accountOperation == null ) {
            return null;
        }
        BankAccount bankAccount = accountOperation.getBankAccount();
        if ( bankAccount == null ) {
            return null;
        }
        String id = bankAccount.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String accountOperationAppUserUsername(AccountOperation accountOperation) {
        if ( accountOperation == null ) {
            return null;
        }
        AppUser appUser = accountOperation.getAppUser();
        if ( appUser == null ) {
            return null;
        }
        String username = appUser.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }
}
