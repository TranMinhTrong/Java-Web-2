package trong.ntu.thigiuaky.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import trong.ntu.thigiuaky.models.Contact;
import trong.ntu.thigiuaky.reposvice.ContactRepository;

@Service
public class ContactServiceTmpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return contactRepository.findAll();
	}

	@Override
	public void saveContact(Contact contact) {
		// TODO Auto-generated method stub
		this.contactRepository.save(contact);
	}

	@Override
	public Contact getContactById(long id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Optional<Contact> optinal= contactRepository.findById(id);
		Contact contact = null;
		if (optinal.isPresent()) {
			contact = optinal.get();
		}else {
			throw new RuntimeException("Contact not found for id : "+id);
			
		}
		return contact;
	}
	


	@Override
	public void deleteContactById(long id) {
		// TODO Auto-generated method stub
		this.contactRepository.deleteById(id);
	}

	@Override
	public void searchContactByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<Contact> findPaginated(int pageNo, int pageSize, String sortFiled, String sortDirection) {
		// TODO Auto-generated method stub
		Sort sort= sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortFiled).ascending():
			Sort.by(sortFiled).descending();
		
		Pageable pageable =PageRequest.of(pageNo -1, pageSize,sort);
		return this.contactRepository.findAll(pageable);
	}

	@Override
	public List<Contact> listAll(String keyword) {
		// TODO Auto-generated method stub
		 if (keyword != null) {
	            return contactRepository.search(keyword);
	        }
	        return contactRepository.findAll();
	}

}
