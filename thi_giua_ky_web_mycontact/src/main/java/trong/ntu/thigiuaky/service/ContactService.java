package trong.ntu.thigiuaky.service;

import java.util.List;

import org.springframework.data.domain.Page;

import trong.ntu.thigiuaky.models.Contact;

public interface ContactService {

	List<Contact> getAllContacts();
	
	void saveContact(Contact contact);
	
	Contact getContactById(long id);
	void deleteContactById(long id);
	
	void searchContactByName(String name);
	
	public List<Contact> listAll(String keyword);
	
	Page<Contact> findPaginated(int pageNo, int pageSize,String sortFiled, String sortDirection);
}
