package ma.enset.digitalbanking.repositories;

import ma.enset.app.digitalbanking.entities.AccountOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountOperationRepository extends JpaRepository<AccountOperation, Long> {
    List<AccountOperation> findAccountOperationByBankAccountId(String accountId);
    Page<AccountOperation> findAccountOperationByBankAccountId(String accountId, Pageable pageable);

    List<AccountOperation> findAllByBankAccountId(String id);
}
