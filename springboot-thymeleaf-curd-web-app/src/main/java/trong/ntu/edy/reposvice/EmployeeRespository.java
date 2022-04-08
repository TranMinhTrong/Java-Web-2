package trong.ntu.edy.reposvice;

import org.springframework.data.jpa.repository.JpaRepository;

import trong.ntu.edy.model.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Long> {
	

}
