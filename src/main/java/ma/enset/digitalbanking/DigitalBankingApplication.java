package ma.enset.digitalbanking;
import ma.enset.digitalbanking.entities.AccountOperation;
import ma.enset.digitalbanking.entities.CurrentAccount;
import ma.enset.digitalbanking.entities.Customer;
import ma.enset.digitalbanking.entities.SavingAccount;
import ma.enset.digitalbanking.enums.AccountStatus;
import ma.enset.digitalbanking.enums.OperationType;
import ma.enset.digitalbanking.repositories.AccountOperationRepository;
import ma.enset.digitalbanking.repositories.BankAccountRepository;
import ma.enset.digitalbanking.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class DigitalBankingApplication {

    public static void main(String[] args) {
        SpringApplication.run(DigitalBankingApplication.class, args);
    }

    @Bean
    CommandLineRunner run(CustomerRepository customerRepository, BankAccountRepository bankAccountRepository, AccountOperationRepository accountOperationRepository){
        return args -> {
            Stream.of("Ismail", "Yassine", "Oussama").forEach(name -> {
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name + "@gmail.com");
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(

                    customer -> {
                        CurrentAccount currentAccount = new CurrentAccount();
                        currentAccount.setBalance(Math.random() * 90000);
                        currentAccount.setCreatedAt(new Date());
                        currentAccount.setStatus(AccountStatus.ACTIVATED);
                        currentAccount.setOverDraft(10000);
                        currentAccount.setCustomer(customer);
                        currentAccount.setId(UUID.randomUUID().toString());
                        bankAccountRepository.save(currentAccount);

                        SavingAccount savingAccount = new SavingAccount();
                        savingAccount.setBalance(Math.random() * 90000);
                        savingAccount.setCreatedAt(new Date());
                        savingAccount.setStatus(AccountStatus.ACTIVATED);
                        savingAccount.setInterestRate(1.2);
                        savingAccount.setCustomer(customer);
                        savingAccount.setId(UUID.randomUUID().toString());
                        bankAccountRepository.save(currentAccount);
                    }
            );

            bankAccountRepository.findAll().forEach(bankAccount -> {
                for (int i = 0; i < 10; i++) {
                    AccountOperation accountOperation = new AccountOperation();
                    accountOperation.setType(Math.random() > 0.5 ? OperationType.DEBIT : OperationType.CREDIT);
                    accountOperation.setOperationDate(new Date());
                    accountOperation.setAmount(Math.random() * 1000);
                    accountOperation.setDescription("Operation description");
                    accountOperation.setBankAccount(bankAccount);
                    accountOperationRepository.save(accountOperation);
                }
            });
        };

    }

}
